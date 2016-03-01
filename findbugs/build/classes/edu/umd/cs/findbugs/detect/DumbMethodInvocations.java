package edu.umd.cs.findbugs.detect;
public class DumbMethodInvocations implements edu.umd.cs.findbugs.Detector {
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor STRING_SUBSTRING =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/lang/String",
      "substring",
      "(I)Ljava/lang/String;");
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    private final java.util.Map<edu.umd.cs.findbugs.classfile.MethodDescriptor,int[]>
      allFileNameStringMethods;
    private final java.util.Map<edu.umd.cs.findbugs.classfile.MethodDescriptor,int[]>
      allDatabasePasswordMethods;
    public DumbMethodInvocations(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
        edu.umd.cs.findbugs.detect.BuildStringPassthruGraph.StringPassthruDatabase database =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          getDatabase(
            edu.umd.cs.findbugs.detect.BuildStringPassthruGraph.StringPassthruDatabase.class);
        allFileNameStringMethods =
          database.
            getFileNameStringMethods(
              );
        allDatabasePasswordMethods =
          database.
            findLinkedMethods(
              java.util.Collections.
                singleton(
                  new edu.umd.cs.findbugs.detect.BuildStringPassthruGraph.MethodParameter(
                    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
                      "java/sql/DriverManager",
                      "getConnection",
                      ("(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljav" +
                       "a/sql/Connection;"),
                      true),
                    2)));
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        org.apache.bcel.classfile.Method[] methodList =
          classContext.
          getJavaClass(
            ).
          getMethods(
            );
        for (org.apache.bcel.classfile.Method method
              :
              methodList) {
            if (method.
                  getCode(
                    ) ==
                  null) {
                continue;
            }
            try {
                analyzeMethod(
                  classContext,
                  method);
                bugAccumulator.
                  reportAccumulatedBugs(
                    );
            }
            catch (edu.umd.cs.findbugs.ba.MethodUnprofitableException mue) {
                if (edu.umd.cs.findbugs.SystemProperties.
                      getBoolean(
                        "unprofitable.debug")) {
                    bugReporter.
                      logError(
                        "skipping unprofitable method in " +
                        getClass(
                          ).
                          getName(
                            ));
                }
            }
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                bugReporter.
                  logError(
                    "Detector " +
                    this.
                      getClass(
                        ).
                      getName(
                        ) +
                    " caught exception",
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                bugReporter.
                  logError(
                    "Detector " +
                    this.
                      getClass(
                        ).
                      getName(
                        ) +
                    " caught exception",
                    e);
            }
        }
    }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        edu.umd.cs.findbugs.ba.CFG cfg =
          classContext.
          getCFG(
            method);
        edu.umd.cs.findbugs.ba.constant.ConstantDataflow constantDataflow =
          classContext.
          getConstantDataflow(
            method);
        org.apache.bcel.generic.ConstantPoolGen cpg =
          classContext.
          getConstantPoolGen(
            );
        org.apache.bcel.generic.MethodGen methodGen =
          classContext.
          getMethodGen(
            method);
        java.lang.String sourceFile =
          classContext.
          getJavaClass(
            ).
          getSourceFileName(
            );
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               cfg.
               locationIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location location =
              i.
              next(
                );
            org.apache.bcel.generic.Instruction ins =
              location.
              getHandle(
                ).
              getInstruction(
                );
            if (!(ins instanceof org.apache.bcel.generic.InvokeInstruction)) {
                continue;
            }
            org.apache.bcel.generic.InvokeInstruction iins =
              (org.apache.bcel.generic.InvokeInstruction)
                ins;
            edu.umd.cs.findbugs.ba.constant.ConstantFrame frame =
              constantDataflow.
              getFactAtLocation(
                location);
            if (!frame.
                  isValid(
                    )) {
                continue;
            }
            edu.umd.cs.findbugs.classfile.MethodDescriptor md =
              new edu.umd.cs.findbugs.classfile.MethodDescriptor(
              iins,
              cpg);
            if (allDatabasePasswordMethods.
                  containsKey(
                    md)) {
                for (int paramNumber
                      :
                      allDatabasePasswordMethods.
                       get(
                         md)) {
                    edu.umd.cs.findbugs.ba.constant.Constant operandValue =
                      frame.
                      getStackValue(
                        iins.
                          getArgumentTypes(
                            cpg).
                          length -
                          1 -
                          paramNumber);
                    if (operandValue.
                          isConstantString(
                            )) {
                        java.lang.String password =
                          operandValue.
                          getConstantString(
                            );
                        if (password.
                              length(
                                ) ==
                              0) {
                            bugAccumulator.
                              accumulateBug(
                                new edu.umd.cs.findbugs.BugInstance(
                                  this,
                                  "DMI_EMPTY_DB_PASSWORD",
                                  NORMAL_PRIORITY).
                                  addClassAndMethod(
                                    methodGen,
                                    sourceFile),
                                classContext,
                                methodGen,
                                sourceFile,
                                location);
                        }
                        else {
                            bugAccumulator.
                              accumulateBug(
                                new edu.umd.cs.findbugs.BugInstance(
                                  this,
                                  "DMI_CONSTANT_DB_PASSWORD",
                                  NORMAL_PRIORITY).
                                  addClassAndMethod(
                                    methodGen,
                                    sourceFile),
                                classContext,
                                methodGen,
                                sourceFile,
                                location);
                        }
                    }
                }
            }
            if (md.
                  equals(
                    STRING_SUBSTRING)) {
                edu.umd.cs.findbugs.ba.constant.Constant operandValue =
                  frame.
                  getTopValue(
                    );
                if (!operandValue.
                      isConstantInteger(
                        )) {
                    continue;
                }
                int v =
                  operandValue.
                  getConstantInt(
                    );
                if (v ==
                      0) {
                    bugAccumulator.
                      accumulateBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "DMI_USELESS_SUBSTRING",
                          NORMAL_PRIORITY).
                          addClassAndMethod(
                            methodGen,
                            sourceFile),
                        classContext,
                        methodGen,
                        sourceFile,
                        location);
                }
            }
            else
                if (allFileNameStringMethods.
                      containsKey(
                        md)) {
                    for (int paramNumber
                          :
                          allFileNameStringMethods.
                           get(
                             md)) {
                        edu.umd.cs.findbugs.ba.constant.Constant operandValue =
                          frame.
                          getStackValue(
                            iins.
                              getArgumentTypes(
                                cpg).
                              length -
                              1 -
                              paramNumber);
                        if (!operandValue.
                              isConstantString(
                                )) {
                            continue;
                        }
                        java.lang.String v =
                          operandValue.
                          getConstantString(
                            );
                        if (isAbsoluteFileName(
                              v) &&
                              !v.
                              startsWith(
                                "/etc/") &&
                              !v.
                              startsWith(
                                "/dev/") &&
                              !v.
                              startsWith(
                                "/proc")) {
                            int priority =
                              NORMAL_PRIORITY;
                            if (v.
                                  startsWith(
                                    "/tmp")) {
                                priority =
                                  LOW_PRIORITY;
                            }
                            else
                                if (v.
                                      indexOf(
                                        "/home") >=
                                      0) {
                                    priority =
                                      HIGH_PRIORITY;
                                }
                            bugAccumulator.
                              accumulateBug(
                                new edu.umd.cs.findbugs.BugInstance(
                                  this,
                                  "DMI_HARDCODED_ABSOLUTE_FILENAME",
                                  priority).
                                  addClassAndMethod(
                                    methodGen,
                                    sourceFile).
                                  addString(
                                    v).
                                  describe(
                                    "FILE_NAME"),
                                classContext,
                                methodGen,
                                sourceFile,
                                location);
                        }
                    }
                }
        }
    }
    private boolean isAbsoluteFileName(java.lang.String v) {
        if (v.
              startsWith(
                "/dev/")) {
            return false;
        }
        if (v.
              startsWith(
                "/")) {
            return true;
        }
        if (v.
              startsWith(
                "\\\\")) {
            return true;
        }
        if (v.
              length(
                ) >=
              2 &&
              v.
              charAt(
                1) ==
              ':') {
            char driveletter =
              v.
              charAt(
                0);
            if (driveletter >=
                  'A' &&
                  driveletter <=
                  'Z' ||
                  driveletter >=
                  'a' &&
                  driveletter <=
                  'z') {
                return true;
            }
        }
        try {
            java.io.File f =
              new java.io.File(
              v);
            return f.
              isAbsolute(
                );
        }
        catch (java.lang.RuntimeException e) {
            return false;
        }
    }
    @java.lang.Override
    public void report() {  }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mdrMNZA3fw3WpSm3/BW6ReB6JdNETCFAPsmEexEq6jFtkZaenmjvZV3t0bUt" +
       "3Z0trZF2pq0aLAbW2upc7SDheUjKyO6wWO7NDevysid/a9zz14eCVpqse/11" +
       "neWzbd8N9H/vm2lFWHDYQkx3Ob4t1MiHXHoNquNix8jPZ774w5GZ77AsvUQy" +
       "QFjgU7N03Vwwn+5/66OXK6YeYBVv2jdV+NuVmd1IT5ORax8Ou1JG9tDRpUsJ" +
       "qD2HrNBxbtd6cVtj13u26AxHdQPZVbe2zeqazUi3zbi3z5Ol+w4Nb6l9a+Pu" +
       "4w9Y0TCjH+DZTLft+slXoR27eInJe68zM9qfbhjef+XRC4fdeLv6fKcwiI73" +
       "D245vG/LVn6rWm8nEQ3qgT/+9/nQbW8/k6VdVSBZ/XOskQLpDtNYrwA4QUtv" +
       "qHpkZ21BB4i6k5QkFenKJO2Me91KMbhkV2x2erpOOm+RhoIB+22yCyz3BVju" +
       "xLXBSot+kSctCvG0iKGFtF6mygBvYN6Fw+0u/EEOZLuMMY7LaJNVhaKLstd4" +
       "O05SQ+kePixm3tSfK9jtPbu2erPyxj8/3DjQejp9OJybdopOG/49PX/24b/K" +
       "U9d/OKl3yeD602ipTffpnh/lfav2P7NstnhjkH0m4EVfxucFL1CzLwxBZEvq" +
       "ildDZnLRM+lxueMwlwk4T5PjkTxrj+HwMNR6Igqa60We7Y9n9g1wok1ztRgs" +
       "FcA/93HF+BEONzAE250ItRJfd7LZ3pS7mUAy1Inj8lUZG0+zylgBz1wras3N" +
       "UWU8eyZVRi6kJpkEVcZSwRRQi7sgIxhW9fgqx72bPoqey0NRyiXw9BXYTxHx" +
       "fYNwXcHF1XTTbEq2em4p68SrOsvyc31LYl51z/W7RuJr7j3HDjD3mGS0qWrz" +
       "ZTpEZdd5hez9kLcTuxieRdZdF/ll4HAjQwBMA0JZOp65kPl02Nc3nJmNBTGB" +
       "U2p9uWTXeSePLfwFh9dNUsPyeDco2z5iRSr8dbdJCodUKe6I+g2vqMvTok7f" +
       "sdaVt4Fz06U4zaMdX6fDxy3VJ5ZyXMMkrtviZPfpimWNTyxleZD52Bl0rOtd" +
       "m+4Zqj4QEjRBHKShmEjljC4Ru9AX2THZSJpyCbhjWWtSwo9V7SmRamk3PyHH" +
       "ByoAQfvth5KhRRHkTYZkpAHZPU7icAKKRgGXN1N+RZx83xH230/lqc5Absz8" +
       "sQ11l8Xqu/LIDYd/ZkopF2h+43EVFLxzgicFSnNbSgAL7MAoUGnJaIkZqpw0" +
       "qd17YfvvcJmKz2yKY6oqU0HJE12QxYGib4HFzGNhv/OwxafDp2sa2TxWLmR5" +
       "+Dc9z1o9DhMhvdNZ89GreYFJOd0MTn/8jTiUlEnqsn7BxU8KEzL+e4T/x4N4" +
       "YKSqZPzIpa/y+sj+r4RySOX6k7Lsbnq73os0nfZLjO3lvAWuMSY0QajN/X0Z" +
       "mMNfkILAHA4yH9LcLCAmnG+9uncvMEmps9skQdGzfB4oqrUMpQOM7sWFMAWL" +
       "+HqhlrsqD2RmQMx51J1Ks9Mg7k+K/jbRqiT/D5+oeHBkxeqrTiy8l3/SBOe6" +
       "eTNiKYMahX9dTWe59Tmx2biKls85Wfng6Fl2LlDDL+yYxWRXvGwDrdNQJyb5" +
       "vvcZjenPfkf3LH7shW1FL0NFto4EBJDRuszvKCktCUnKukhmLWb3U5rn3LFp" +
       "ybz+v73OvlQRXpBMyb0/Kvbd9Frngxu/uJj9Q8ko0ACaYh94lm5Suqk4pHsK" +
       "u+zNqQpPc8okDZk17SmbUVAaljkzdnWTpz+FAM6Mq2mwl/tR5D7oXzSyStOs" +
       "kr9grMYsd1/OLDuwgr3i28r/AdsvcHfqJwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fmehQOLK87tVo1xDCKFLpZluyl3OZZac");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("jlFNGvOmPXcg9Vdi4G8qgQI3F9p6LQ+cYVbdDhcNL5hWyAEBV8fpomcua2Q3" +
       "6zHGGmI3qaR1/GokVfl0RjmTerkjoxnsoR2DNtYKI7bQXqguugNWqdC8C7I0" +
       "3pzahBtEbhNPp60hkVFltcZDaY2pLYZcII6yvi9B23JklcPaZMux88aqSUVL" +
       "N2giXlRxNZGyWMReY7OE5haVsWQx0LwiOjSjrfoURmK1LYlSMtXGHLdXRhNX" +
       "XtOE40cogAull2l4zQvCKe2PWboZzbo0BnY2ZGDYYQQgb+KM6bQOD+BhhNJ6" +
       "c1UeQtZyEpg81KmXPZXEV6kahLy5bdkIxOGs2lB5xhwuaMmYowo/U+so76TV" +
       "pTm0o1Z9prl6o2tXKbvTocrbRTqbzNe9TSdUmDGAgjrQsGip7khbaQhFNkEC" +
       "DXepCtONQdaKDzqTJMrWw/Yqbk/dYbIyHGq2RKb10EWorr9dZuV1E2HX9ngy" +
       "93F6u6xAw/VSQbuhq6cJlAwsdNxaeRWsLS0MtGY7dS4JVjWfjIZJOWOCsT+S" +
       "W96qI65gYHPLqYBJtrXKFHfG+1m5i9ENOqg6GxuKJ/VO05tn3JaLAeaGqB7S" +
       "i0iBIRYkrRs9RMxqK4QwJVrLpBYMNhiWH5X9m3d2hHd/cVp5eDHVspt5wxff" +
       "wSldeuwA+/Cst/i5XDp1mfHYWe+xM+XDC0PvOeu7e6e40ueF+aeSx867lFp8" +
       "Jvn8x15+RWF/Eb64f0r9d+PSXbHnf8BW16p9bL7bivefP3kL7QXwoPu8oqfP" +
       "pY+0cZNeLxR6Tc86uT91Herps6RbSjsh9j9ZFeN8/RbH9n+UF18Dy1Z8pj5O" +
       "euaB69ozlaNV/A8nV/Gew1U85PGBYx8w12oYmop6i4W/+eLSKc3ek1fmdx0m" +
       "+5qdvFPNEmdq9uLR94A/PGD9CS/U9yRfkg11bymr9k03ZIqRvnP2SAeDPHfe" +
       "GnV7eGLmd1KJVFb9w49KD51zDxWQ5J8lNNvbYK5kgwQzOiQs+HgzL74Zl+6V" +
       "8uZM3bGYV75xtF7fequz8Vuo/l15ZX5/5xf2Vf8LPxjVXzjq8MWiw/fPt9YL" +
       "Rbe/AGZlRiA2enYSqwf3VM4y1zuWnmerknukge/9X2igcOtHwPPlfQ18+Qfj" +
       "1scFvO8Wbdfy4q64dDks7j+dXNsLV871xbz6T96R16Vx6aEzrzzn9zcfuenf" +
       "LXb/IiB/4ZWrdz78yvQ/7W4PHFzjv4sq3akltn38Gt2x98t+qGpmoZe7dpfq" +
       "/ELYR+LSo+dfyAZK2L3krF94eEfyw3HpwTNIYjD//uvx3o/HpStHvePSRflE" +
       "85PAevab49IlUB5vvA6qQGP++kyx9B9OL5z4pnlkcA+8lcEdkhy/Inz6+g+d" +
       "7P795Yb82isD5ifebPzi7ooygKQsy0e5kyrdsbstffgl+slzRzsY6zL57Pfu" +
       "+7W7njmIb/ftGD6y4mO8vffs+8AgH4uLG7zZrz/8xRf+2SvfKL4A/h+s5mj7" +
       "lTQAAA==");
}
