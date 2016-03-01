package edu.umd.cs.findbugs.detect;
public class FindUseOfNonSerializableValue implements edu.umd.cs.findbugs.Detector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    private static final boolean DEBUG = false;
    public FindUseOfNonSerializableValue(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        org.apache.bcel.classfile.JavaClass javaClass =
          classContext.
          getJavaClass(
            );
        boolean skip =
          false;
        org.apache.bcel.classfile.ConstantPool constantPool =
          javaClass.
          getConstantPool(
            );
        for (org.apache.bcel.classfile.Constant c
              :
              constantPool.
               getConstantPool(
                 )) {
            if (c instanceof org.apache.bcel.classfile.ConstantMethodref ||
                  c instanceof org.apache.bcel.classfile.ConstantInterfaceMethodref) {
                org.apache.bcel.classfile.ConstantCP m =
                  (org.apache.bcel.classfile.ConstantCP)
                    c;
                java.lang.String clazz =
                  m.
                  getClass(
                    constantPool);
                org.apache.bcel.classfile.ConstantNameAndType nt =
                  (org.apache.bcel.classfile.ConstantNameAndType)
                    constantPool.
                    getConstant(
                      m.
                        getNameAndTypeIndex(
                          ),
                      org.apache.bcel.Constants.
                        CONSTANT_NameAndType);
                java.lang.String name =
                  nt.
                  getName(
                    constantPool);
                if ("setAttribute".
                      equals(
                        name) &&
                      "javax.servlet.http.HttpSession".
                      equals(
                        clazz) ||
                      "writeObject".
                      equals(
                        name) &&
                      ("java.io.ObjectOutput".
                         equals(
                           clazz) ||
                         "java.io.ObjectOutputStream".
                         equals(
                           clazz))) {
                    if (DEBUG) {
                        java.lang.System.
                          out.
                          println(
                            "Found call to " +
                            clazz +
                            "." +
                            name);
                    }
                    skip =
                      false;
                    break;
                }
            }
        }
        if (skip) {
            return;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                this.
                  getClass(
                    ).
                  getSimpleName(
                    ) +
                " Checking " +
                javaClass.
                  getClassName(
                    ));
        }
        org.apache.bcel.classfile.Method[] methodList =
          javaClass.
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
                
            }
            bugAccumulator.
              reportAccumulatedBugs(
                );
        }
    }
    enum Use {
        STORE_INTO_HTTP_SESSION, PASSED_TO_WRITE_OBJECT,
         STORED_IN_SERIALZIED_FIELD;
         
        private Use() {
            
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long
          jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long
          jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "n3/xK8WV2P8HGMrRIAUqAAA=");
    }
    @javax.annotation.CheckForNull
    edu.umd.cs.findbugs.detect.FindUseOfNonSerializableValue.Use getUse(org.apache.bcel.generic.ConstantPoolGen cpg,
                                                                        org.apache.bcel.generic.Instruction ins) {
        if (ins instanceof org.apache.bcel.generic.InvokeInstruction) {
            org.apache.bcel.generic.InvokeInstruction invoke =
              (org.apache.bcel.generic.InvokeInstruction)
                ins;
            java.lang.String mName =
              invoke.
              getMethodName(
                cpg);
            java.lang.String cName =
              invoke.
              getClassName(
                cpg);
            if ("setAttribute".
                  equals(
                    mName) &&
                  "javax.servlet.http.HttpSession".
                  equals(
                    cName)) {
                return edu.umd.cs.findbugs.detect.FindUseOfNonSerializableValue.Use.
                         STORE_INTO_HTTP_SESSION;
            }
            if ("writeObject".
                  equals(
                    mName) &&
                  ("java.io.ObjectOutput".
                     equals(
                       cName) ||
                     "java.io.ObjectOutputStream".
                     equals(
                       cName))) {
                return edu.umd.cs.findbugs.detect.FindUseOfNonSerializableValue.Use.
                         PASSED_TO_WRITE_OBJECT;
            }
        }
        return null;
    }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        org.apache.bcel.generic.MethodGen methodGen =
          classContext.
          getMethodGen(
            method);
        if (methodGen ==
              null) {
            return;
        }
        java.util.BitSet bytecodeSet =
          classContext.
          getBytecodeSet(
            method);
        if (bytecodeSet ==
              null) {
            return;
        }
        if (bytecodeSet.
              get(
                org.apache.bcel.Constants.
                  INSTANCEOF) ||
              bytecodeSet.
              get(
                org.apache.bcel.Constants.
                  CHECKCAST)) {
            return;
        }
        edu.umd.cs.findbugs.ba.CFG cfg =
          classContext.
          getCFG(
            method);
        edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow =
          classContext.
          getTypeDataflow(
            method);
        org.apache.bcel.generic.ConstantPoolGen cpg =
          classContext.
          getConstantPoolGen(
            );
        java.lang.String sourceFile =
          classContext.
          getJavaClass(
            ).
          getSourceFileName(
            );
        if (DEBUG) {
            java.lang.String methodName =
              methodGen.
              getClassName(
                ) +
            "." +
            methodGen.
              getName(
                );
            java.lang.System.
              out.
              println(
                "Checking " +
                methodName);
        }
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
            org.apache.bcel.generic.InstructionHandle handle =
              location.
              getHandle(
                );
            org.apache.bcel.generic.Instruction ins =
              handle.
              getInstruction(
                );
            edu.umd.cs.findbugs.detect.FindUseOfNonSerializableValue.Use use =
              getUse(
                cpg,
                ins);
            if (use ==
                  null) {
                continue;
            }
            edu.umd.cs.findbugs.ba.type.TypeFrame frame =
              typeDataflow.
              getFactAtLocation(
                location);
            if (!frame.
                  isValid(
                    )) {
                continue;
            }
            org.apache.bcel.generic.Type operandType =
              frame.
              getTopValue(
                );
            if (operandType.
                  equals(
                    edu.umd.cs.findbugs.ba.type.TopType.
                      instance(
                        ))) {
                continue;
            }
            if (!(operandType instanceof org.apache.bcel.generic.ReferenceType)) {
                continue;
            }
            org.apache.bcel.generic.ReferenceType refType =
              (org.apache.bcel.generic.ReferenceType)
                operandType;
            if (refType.
                  equals(
                    edu.umd.cs.findbugs.ba.type.NullType.
                      instance(
                        ))) {
                continue;
            }
            try {
                double isSerializable =
                  edu.umd.cs.findbugs.DeepSubtypeAnalysis.
                  isDeepSerializable(
                    refType);
                if (isSerializable <
                      0.9) {
                    edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation =
                      edu.umd.cs.findbugs.SourceLineAnnotation.
                      fromVisitedInstruction(
                        classContext,
                        methodGen,
                        sourceFile,
                        handle);
                    org.apache.bcel.generic.ReferenceType problem =
                      edu.umd.cs.findbugs.DeepSubtypeAnalysis.
                      getLeastSerializableTypeComponent(
                        refType);
                    java.lang.String pattern;
                    switch (use) {
                        case PASSED_TO_WRITE_OBJECT:
                            pattern =
                              "DMI_NONSERIALIZABLE_OBJECT_WRITTEN";
                            double isRemote =
                              edu.umd.cs.findbugs.DeepSubtypeAnalysis.
                              isDeepRemote(
                                refType);
                            if (isRemote >=
                                  0.9) {
                                continue;
                            }
                            if (isSerializable <
                                  isRemote) {
                                isSerializable =
                                  isRemote;
                            }
                            break;
                        case STORE_INTO_HTTP_SESSION:
                            pattern =
                              "J2EE_STORE_OF_NON_SERIALIZABLE_OBJECT_INTO_SESSION";
                            break;
                        default:
                            throw new java.lang.IllegalStateException(
                              );
                    }
                    bugAccumulator.
                      accumulateBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          pattern,
                          isSerializable <
                            0.15
                            ? HIGH_PRIORITY
                            : (isSerializable >
                                 0.5
                                 ? LOW_PRIORITY
                                 : NORMAL_PRIORITY)).
                          addClassAndMethod(
                            methodGen,
                            sourceFile).
                          addType(
                            problem).
                          describe(
                            edu.umd.cs.findbugs.TypeAnnotation.
                              FOUND_ROLE),
                        sourceLineAnnotation);
                }
            }
            catch (java.lang.ClassNotFoundException e) {
                
            }
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
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+zr1n0f77V9r33j+F47jeN6tmM7N21tNT9KIiVKsJOF" +
       "pEiJEilREklJ7FqHb1J8ig9RYustDbAlWIc0aJ0uG1Lvj6VYV6RJMaxYhiGD" +
       "i2Fru3QbMnRbO2RNUezRrcvQYFg3NNu6Q+r3vg/X67AfwPOjzjnf7/k+P+fw" +
       "nPPFb0EPJTFUi0Jvb3lhemTs0qO11zpK95GRHA3ZFq/EiaGTnpIkAqh7TXvx" +
       "F27+wXc+Y9+6Cl2TofcoQRCmSuqEQTIzktDbGjoL3TyrpTzDT1LoFrtWtgqc" +
       "pY4Hs06SvsJC7zpHmkK32RMRYCACDESAKxFg/KwXIHq3EWQ+WVIoQZpsoD8L" +
       "XWGha5FWipdCL1xkEimx4h+z4SsNAIeHy98SUKoi3sXQ86e6H3S+Q+HP1uA3" +
       "/vIP3fpbD0A3ZeimE8xLcTQgRAoGkaFHfcNXjTjBdd3QZejxwDD0uRE7iucU" +
       "ldwy9ETiWIGSZrFxaqSyMouMuBrzzHKPaqVucaalYXyqnukYnn7y6yHTUyyg" +
       "65Nnuh40pMt6oOANBwgWm4pmnJA86DqBnkLvv0xxquPtEegASK/7RmqHp0M9" +
       "GCigAnri4DtPCSx4nsZOYIGuD4UZGCWFnr4n09LWkaK5imW8lkJPXe7HH5pA" +
       "r0cqQ5QkKfTey90qTsBLT1/y0jn/fGv86qd/OBgEVyuZdUPzSvkfBkTPXSKa" +
       "GaYRG4FmHAgffZn9KeXJr37qKgSBzu+91PnQ5+/8yLc/+v3PvfUrhz5/6i59" +
       "Jura0NLXtC+oj339GfKl7gOlGA9HYeKUzr+geRX+/HHLK7sIZN6TpxzLxqOT" +
       "xrdm/2j18Z8zfu8qdIOBrmmhl/kgjh7XQj9yPCPuG4ERK6mhM9AjRqCTVTsD" +
       "XQfvrBMYh9qJaSZGykAPelXVtbD6DUxkAhalia6Ddycww5P3SEnt6n0XQRB0" +
       "HTzQR8BTgw5/1f8UCmE79A1Y0ZTACUKYj8NS/wQ2glQFtrVhEwSTmlkJnMQa" +
       "XIWOoWdw5uuwlpw16kYKyGAa/BYTY2KOw+A0a1QPZKiXGUcldfT/f8hdaYVb" +
       "+ZUrwEHPXIYHD2TWIPR0I35NeyMjqG9/6bWvXT1Nl2P7pVAHSHAEJDjSkqMT" +
       "CY4OEhzdVwLoypVq4O8qJTlEBfCpC9AB4OajL81/cPixT734AAjHKH8QOKTs" +
       "Ct8bvskzPGEq1NRAUENvfS7/UenP1a9CVy/icCk9qLpRkvMlep6i5O3L+Xc3" +
       "vjc/+bt/8OWfej08y8QLwH4MEHdSlgn+4mU7x6EGTBgbZ+xffl75xde++vrt" +
       "q9CDADUAUqYKiGwAQs9dHuNCor9yApqlLg8Bhc0w9hWvbDpBuhupHYf5WU0V" +
       "AI9V748DG7+rjPzvAw9ynArV/7L1PVFZftchYEqnXdKiAuUPz6Of/o1/+h+R" +
       "ytwn+H3z3Iw4N9JXzmFGyexmhQ6Pn8WAEBsG6PdvPsf/5Ge/9ckfqAIA9PjA" +
       "3Qa8XZYkwArgQmDmP/8rm9/85m994devngVNCibNTPUcbXeqZFkP3biPkmC0" +
       "7zmTB2COB2K5jJrbYuCHumM6ZQyXUfo/b36w8Yv/+dO3DnHggZqTMPr+t2dw" +
       "Vv/dBPTxr/3Qf3+uYnNFK+e8M5uddTsA6XvOOONxrOxLOXY/+s+f/Su/rPw0" +
       "gGQAg4lTGBWyXTlOnFKo94J58W6ZSmTWzIjCGExylXPhqvfLVXlUGqbiAVVt" +
       "SFm8PzmfJBfz8Nwa5jXtM7/++++Wfv/vf7vS6uIi6HxMcEr0yiEMy+L5HWD/" +
       "vsuIMFASG/RD3xr/mVveW98BHGXAUQMzfzKJAUDtLkTQce+Hrv/rX/oHT37s" +
       "6w9AV2nohhcqOq1UyQg9ArLASGyAbbvoT3/0EAT5w6C4VakK3aH8IXieqn5d" +
       "AwK+dG8coss1zFkqP/WHE0/9xO/8jzuMUCHQXabuS/Qy/MXPP01+5Pcq+jMo" +
       "KKmf290J2mC9d0bb/Dn/v1198do/vApdl6Fb2vFissJekGAyWEAlJytMsOC8" +
       "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" +
       "o7S6P1F85X1/+9W/8eZvVedG/wdQMGVyKyoAAA==");
}
