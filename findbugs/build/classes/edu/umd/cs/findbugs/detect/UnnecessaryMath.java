package edu.umd.cs.findbugs.detect;
public class UnnecessaryMath extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    static final int SEEN_NOTHING = 0;
    static final int SEEN_DCONST = 1;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private int state = SEEN_NOTHING;
    private double constValue;
    @edu.umd.cs.findbugs.internalAnnotations.StaticConstant
    private static final java.util.Set<java.lang.String> zeroMethods = new java.util.HashSet<java.lang.String>(
      ) {
        {
            add(
              "acos");
            add(
              "asin");
            add(
              "atan");
            add(
              "atan2");
            add(
              "cbrt");
            add(
              "cos");
            add(
              "cosh");
            add(
              "exp");
            add(
              "expm1");
            add(
              "log");
            add(
              "log10");
            add(
              "pow");
            add(
              "sin");
            add(
              "sinh");
            add(
              "sqrt");
            add(
              "tan");
            add(
              "tanh");
            add(
              "toDegrees");
            add(
              "toRadians");
        }
    };
    @edu.umd.cs.findbugs.internalAnnotations.StaticConstant
    private static final java.util.Set<java.lang.String> oneMethods =
      new java.util.HashSet<java.lang.String>(
      ) {
        {
            add(
              "acos");
            add(
              "asin");
            add(
              "atan");
            add(
              "cbrt");
            add(
              "exp");
            add(
              "log");
            add(
              "log10");
            add(
              "pow");
            add(
              "sqrt");
            add(
              "toDegrees");
        }
    };
    @edu.umd.cs.findbugs.internalAnnotations.StaticConstant
    private static final java.util.Set<java.lang.String> anyMethods =
      new java.util.HashSet<java.lang.String>(
      ) {
        {
            add(
              "abs");
            add(
              "ceil");
            add(
              "floor");
            add(
              "rint");
            add(
              "round");
        }
    };
    public UnnecessaryMath(edu.umd.cs.findbugs.BugReporter bugReporter) {
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
                  "java/lang/Math"))) {
            super.
              visitClassContext(
                classContext);
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        if ("<clinit>".
              equals(
                getMethod(
                  ).
                  getName(
                    ))) {
            return;
        }
        state =
          SEEN_NOTHING;
        super.
          visit(
            obj);
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (state == SEEN_NOTHING) {
                                          if (seen ==
                                                DCONST_0 ||
                                                seen ==
                                                DCONST_1) {
                                              constValue =
                                                seen -
                                                  DCONST_0;
                                              state =
                                                SEEN_DCONST;
                                          }
                                          else
                                              if (seen ==
                                                    LDC2_W ||
                                                    seen ==
                                                    LDC_W) {
                                                  state =
                                                    SEEN_DCONST;
                                                  org.apache.bcel.classfile.Constant c =
                                                    this.
                                                    getConstantRefOperand(
                                                      );
                                                  if (c instanceof org.apache.bcel.classfile.ConstantDouble) {
                                                      constValue =
                                                        ((org.apache.bcel.classfile.ConstantDouble)
                                                           c).
                                                          getBytes(
                                                            );
                                                  }
                                                  else
                                                      if (c instanceof org.apache.bcel.classfile.ConstantFloat) {
                                                          constValue =
                                                            ((org.apache.bcel.classfile.ConstantFloat)
                                                               c).
                                                              getBytes(
                                                                );
                                                      }
                                                      else
                                                          if (c instanceof org.apache.bcel.classfile.ConstantLong) {
                                                              constValue =
                                                                ((org.apache.bcel.classfile.ConstantLong)
                                                                   c).
                                                                  getBytes(
                                                                    );
                                                          }
                                                          else {
                                                              state =
                                                                SEEN_NOTHING;
                                                          }
                                              }
                                      }
                                      else
                                          if (state ==
                                                SEEN_DCONST) {
                                              if (seen ==
                                                    INVOKESTATIC) {
                                                  state =
                                                    SEEN_NOTHING;
                                                  if ("java.lang.Math".
                                                        equals(
                                                          getDottedClassConstantOperand(
                                                            ))) {
                                                      java.lang.String methodName =
                                                        getNameConstantOperand(
                                                          );
                                                      if (constValue ==
                                                            0.0 &&
                                                            zeroMethods.
                                                            contains(
                                                              methodName) ||
                                                            constValue ==
                                                            1.0 &&
                                                            oneMethods.
                                                            contains(
                                                              methodName) ||
                                                            anyMethods.
                                                            contains(
                                                              methodName)) {
                                                          bugReporter.
                                                            reportBug(
                                                              new edu.umd.cs.findbugs.BugInstance(
                                                                this,
                                                                "UM_UNNECESSARY_MATH",
                                                                LOW_PRIORITY).
                                                                addClassAndMethod(
                                                                  this).
                                                                addSourceLine(
                                                                  this));
                                                      }
                                                  }
                                              }
                                              state =
                                                SEEN_NOTHING;
                                          }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "derwxMjK/wHCBI5v2yUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2m21D/Re77abFow1RWhdC6NtdW5bnoaz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("SDCFptWBavfmO2C9EPByJI4WZ/CMVXdUM7F5N+HakoS3sgUkC/U23Q76sjpS" +
       "Im68GFpTve9mwBOxDAe45Gh7SSb+bKw587XmRgEtd6rrlLcH2EoL04y2xlCK" +
       "D/pEa9vIhV6v98EPFtdFv/nWrrEeLq/gjuMAv4fLt8MPP0Xy9PGlZuXoUvNM" +
       "7NipS81T18rHl8VPX3RZXFwMa7YWRWgZVuWFxcfb91wWDFh+uP3sR196eTX5" +
       "xfrVwxvrWVy5L/b8H7S1rWafmvjaG3942l+engQY/NZH//hR/oeM599CeNXj" +
       "5+g8P+Q/oz/3xdH71J++Wrl2HG7wuijNs52eO/dxItTiJHT5M6EG7zkb4vQB" +
       "8ISH6xCev1w+WemLvzT+wF5TzsXJnIu1eeqilVPk/bocBsqW43zlDeJtfr9I" +
       "vgxUsvy2dbrrhReqW89cnWjof3nTTxG3Tn312GphaK60N73kPk1iWfCls5J9" +
       "HDz5oWTz/yeSfcwL9QPZl1VDO1BUzd5/RyoCOA8G3mp/jf3NNxDqa0Xy9bhy" +
       "vRRq8fK1E6F94w2/AfzRX1s8T4HnY4fi+djfqHiKV7Zs8JdvwPx3iuRbwPoj" +
       "OZ34KpDXOQH8xd+gALK4cvNczGcRwPau10WX7yOi1V97+ea973xZ+G9l2ONx" +
       "1PJ9VOXedWLbp+OITuXv9kPgxJXM3bePKvKLnyt3x5VHL49FLeIAykxB9JXr" +
       "+y73xZVHLugSg/kPs6dbPxBXbpy0jitX1TPVN+PKPYfVceUaSE9X3gJFoLLI" +
       "PuIfKfb7LwzPywGVYJk4FcCr6erHmH/lzGfIkwW89WafUI67nI6pPP8dnE72" +
       "/x1wR33lZZL5kdfav7iP6QS2ttsVo9xLVe7Zh5ceQ/uTl452NNbd+DPffvDX" +
       "73v6aBt6cE/wid6fou3xiwMoMXDYLUMed//6nf/iA7/08lfLkK7/C8Djvxi0" +
       "MQAA");
}
