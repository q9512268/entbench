package edu.umd.cs.findbugs.detect;
public class AppendingToAnObjectOutputStream extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    edu.umd.cs.findbugs.BugReporter bugReporter;
    public AppendingToAnObjectOutputStream(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        if (hasInterestingClass(
              classContext.
                getJavaClass(
                  ).
                getConstantPool(
                  ),
              java.util.Collections.
                singleton(
                  "java/io/ObjectOutputStream"))) {
            super.
              visitClassContext(
                classContext);
        }
    }
    boolean sawOpenInAppendMode;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        sawOpenInAppendMode =
          false;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen != INVOKESPECIAL) {
                                          sawOpenInAppendMode =
                                            false;
                                          return;
                                      }
                                      java.lang.String calledClassName =
                                        getClassConstantOperand(
                                          );
                                      java.lang.String calledMethodName =
                                        getNameConstantOperand(
                                          );
                                      java.lang.String calledMethodSig =
                                        getSigConstantOperand(
                                          );
                                      if (!sawOpenInAppendMode) {
                                          if ("java/io/ObjectOutputStream".
                                                equals(
                                                  calledClassName) &&
                                                "<init>".
                                                equals(
                                                  calledMethodName) &&
                                                "(Ljava/io/OutputStream;)V".
                                                equals(
                                                  calledMethodSig) &&
                                                stack.
                                                getStackItem(
                                                  0).
                                                getSpecialKind(
                                                  ) ==
                                                edu.umd.cs.findbugs.OpcodeStack.Item.
                                                  FILE_OPENED_IN_APPEND_MODE) {
                                              bugReporter.
                                                reportBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "IO_APPENDING_TO_OBJECT_OUTPUT_STREAM",
                                                    edu.umd.cs.findbugs.Priorities.
                                                      HIGH_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addSourceLine(
                                                      this));
                                          }
                                          return;
                                      }
                                      if ("java/io/FileOutputStream".
                                            equals(
                                              calledClassName) &&
                                            "<init>".
                                            equals(
                                              calledMethodName) &&
                                            ("(Ljava/io/File;Z)V".
                                               equals(
                                                 calledMethodSig) ||
                                               "(Ljava/lang/String;Z)V".
                                               equals(
                                                 calledMethodSig))) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item item =
                                            stack.
                                            getStackItem(
                                              0);
                                          java.lang.Object value =
                                            item.
                                            getConstant(
                                              );
                                          sawOpenInAppendMode =
                                            value instanceof java.lang.Integer &&
                                              ((java.lang.Integer)
                                                 value).
                                              intValue(
                                                ) ==
                                              1;
                                      }
                                      else
                                          if (!sawOpenInAppendMode) {
                                              return;
                                          }
                                          else
                                              if ("java/io/BufferedOutputStream".
                                                    equals(
                                                      calledClassName) &&
                                                    "<init>".
                                                    equals(
                                                      calledMethodName) &&
                                                    "(Ljava/io/OutputStream;)V".
                                                    equals(
                                                      calledMethodSig)) {
                                                  
                                              }
                                              else
                                                  if ("java/io/ObjectOutputStream".
                                                        equals(
                                                          calledClassName) &&
                                                        "<init>".
                                                        equals(
                                                          calledMethodName) &&
                                                        "(Ljava/io/OutputStream;)V".
                                                        equals(
                                                          calledMethodSig)) {
                                                      bugReporter.
                                                        reportBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "IO_APPENDING_TO_OBJECT_OUTPUT_STREAM",
                                                            edu.umd.cs.findbugs.Priorities.
                                                              HIGH_PRIORITY).
                                                            addClassAndMethod(
                                                              this).
                                                            addSourceLine(
                                                              this));
                                                      sawOpenInAppendMode =
                                                        false;
                                                  }
                                                  else {
                                                      sawOpenInAppendMode =
                                                        false;
                                                  }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZe2wUxxmfOz8xBj94xoAB21BhyB2EkIoYaMDYweT8EHZQ" +
       "axrM3t7cefHe7rI7a5+d0BKkClo1iBJCaBX8T4mSIhJQ2rSNmqSuojaJklZK" +
       "QpukVUjVViptihpUNalK2/T7ZvZuH3dnGiltLd3c3Dy++d7fb8bnr5IyyySN" +
       "VGMRNm5QK9KhsT7JtGiiXZUsawDGhuSHS6S/7L3SszFMygfJ7GHJ6pYli3Yq" +
       "VE1Yg2SJollM0mRq9VCawB19JrWoOSoxRdcGyTzF6kobqiIrrFtPUFywWzJj" +
       "pE5izFTiNqNdDgFGlsSAkyjnJLo1ON0WI9Wyboy7yxd6lrd7ZnBl2j3LYqQ2" +
       "tl8alaI2U9RoTLFYW8Ykqw1dHU+pOovQDIvsVzc4KtgZ25CngqaLNR9cPz5c" +
       "y1UwR9I0nXHxrF3U0tVRmoiRGne0Q6Vp6wD5AimJkZmexYy0xLKHRuHQKBya" +
       "ldZdBdzPopqdbte5OCxLqdyQkSFGlvuJGJIppR0yfZxnoFDJHNn5ZpB2WU5a" +
       "IWWeiA+tjp58eG/tUyWkZpDUKFo/siMDEwwOGQSF0nScmtbWRIImBkmdBsbu" +
       "p6YiqcqEY+l6S0lpErPB/Fm14KBtUJOf6eoK7AiymbbMdDMnXpI7lPOrLKlK" +
       "KZB1viurkLATx0HAKgUYM5MS+J2zpXRE0RKMLA3uyMnYchcsgK0VacqG9dxR" +
       "pZoEA6ReuIgqaaloP7ieloKlZTo4oMlIQ1GiqGtDkkekFB1Cjwys6xNTsGoG" +
       "VwRuYWRecBmnBFZqCFjJY5+rPZuO3avt0MIkBDwnqKwi/zNhU2Ng0y6apCaF" +
       "OBAbq1tjp6T5zx0NEwKL5wUWizXfu+/aHWsap14SaxYVWNMb309lNiSfjc9+" +
       "bXH7qo0lyEaloVsKGt8nOY+yPmemLWNAhpmfo4iTkezk1K6ffO7QOfpemFR1" +
       "kXJZV+00+FGdrKcNRaXmnVSjpsRooovMoFqinc93kQroxxSNitHeZNKirIuU" +
       "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" +
       "d6pwasL2Dd7F5tK/AZgsjTOSGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vOklAAA=");
}
