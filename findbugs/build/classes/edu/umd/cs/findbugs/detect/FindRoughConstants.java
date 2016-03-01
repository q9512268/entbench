package edu.umd.cs.findbugs.detect;
public class FindRoughConstants extends edu.umd.cs.findbugs.BytecodeScanningDetector {
    static class BadConstant {
        double base;
        double factor;
        java.lang.String replacement;
        double value;
        int basePriority;
        java.util.Set<java.lang.Number> approxSet = new java.util.HashSet<java.lang.Number>(
          );
        BadConstant(double base, double factor, java.lang.String replacement,
                    int basePriority) { super();
                                        this.base = base;
                                        this.factor = factor;
                                        this.value = this.base * this.
                                                                   factor;
                                        this.replacement = replacement;
                                        this.basePriority = basePriority;
                                        java.math.BigDecimal valueBig =
                                          java.math.BigDecimal.
                                          valueOf(
                                            value);
                                        java.math.BigDecimal baseBig =
                                          java.math.BigDecimal.
                                          valueOf(
                                            base);
                                        java.math.BigDecimal factorBig =
                                          java.math.BigDecimal.
                                          valueOf(
                                            factor);
                                        for (int prec = 0; prec <
                                                             14; prec++) {
                                            addApprox(
                                              baseBig.
                                                round(
                                                  new java.math.MathContext(
                                                    prec,
                                                    java.math.RoundingMode.
                                                      FLOOR)).
                                                multiply(
                                                  factorBig));
                                            addApprox(
                                              baseBig.
                                                round(
                                                  new java.math.MathContext(
                                                    prec,
                                                    java.math.RoundingMode.
                                                      CEILING)).
                                                multiply(
                                                  factorBig));
                                            addApprox(
                                              valueBig.
                                                round(
                                                  new java.math.MathContext(
                                                    prec,
                                                    java.math.RoundingMode.
                                                      FLOOR)));
                                            addApprox(
                                              valueBig.
                                                round(
                                                  new java.math.MathContext(
                                                    prec,
                                                    java.math.RoundingMode.
                                                      CEILING)));
                                        } }
        @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("FE_FLOATING_POINT_EQUALITY") 
        public boolean exact(java.lang.Number candidate) { if (candidate instanceof java.lang.Double) {
                                                               return candidate.
                                                                 doubleValue(
                                                                   ) ==
                                                                 value;
                                                           }
                                                           return candidate.
                                                             floatValue(
                                                               ) ==
                                                             (float)
                                                               value;
        }
        public double diff(double candidate) { return java.lang.Math.
                                                 abs(
                                                   value -
                                                     candidate) /
                                                 value; }
        public boolean equalPrefix(java.lang.Number candidate) {
            return approxSet.
              contains(
                candidate);
        }
        @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("FE_FLOATING_POINT_EQUALITY") 
        private void addApprox(java.math.BigDecimal roundFloor) {
            double approxDouble =
              roundFloor.
              doubleValue(
                );
            if (approxDouble !=
                  value &&
                  java.lang.Math.
                  abs(
                    approxDouble -
                      value) /
                  value <
                  0.001) {
                approxSet.
                  add(
                    approxDouble);
            }
            float approxFloat =
              roundFloor.
              floatValue(
                );
            if (java.lang.Math.
                  abs(
                    approxFloat -
                      value) /
                  value <
                  0.001) {
                approxSet.
                  add(
                    approxFloat);
                approxSet.
                  add(
                    (double)
                      approxFloat);
            }
        }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "cx3fJCj2KW+UztwNOnE8cWo/M45Kb73o");
        public static final java.lang.String jlc$ClassType$jl5$1 =
          ("+lZxZv3JD7zymjr8herlg83PZlK6dnCr7nicq3c/wGCLq2vHx5e/8YFvPMX/" +
           "oPneN3Dx5e1niDw75D9gP/2F7g8of/ty6crRYeYdl+pOd3rpzCZ3pCVp5PGn" +
           "DjLfeiTWJ3JxPQ0ScSBW4uypz/FSnr9Gr+5U4cwp/KXjBh8tGvzqXY7pfy3P" +
           "/nlSuk/LJCU5b2v0ftn3HU3yjlXqc6dV6sEjlbp0uOcNn3dJ6sSq7E3SIIi0" +
           "OCbRmQTQwTPii4Y8PPcD+lC/502C/P6pdnAsXdwa2VcevLn4L//y5T8v7S5A" +
           "gKHOvQiUL0OpDRJ+sBb42bXIr+Scf9llAsh3tMT38sOhF/70+Yff/Yt/72eL" +
           "6e7XnKMTVLq41dJ6QywcnrjvK+zo/Z2nf+qPfr/Q7+vF8TtoUYx751F5nv3r" +
           "LCk9RRL7JDNEeGrQ3eeG1IDfJ0YCwlD8okCK7LzrC0XBPz0STH62XXoKJOZA" +
           "MMz/dSWFiwb//i5K+tU8+70EWCGIvYsux8r45Xvt0t+FucICnwOJO2CO+39k" +
           "gV+/C3PfyLP/lJRuamEqOVyk6VZR/uvHPP7h/wGPRbMGSMIBj8Ib4RGYfxBZ" +
           "KynR7sboodnvbja6UmLuoZaBa4rlHhw0fecuAvjzPPvT/PBaVZHi/PrcE5qV" +
           "b6nHIvnWhRiUF//m3Sq/WFT+zp22zx9IiL/D9vOfLxX5vwXZpcvfq3GBfjdP" +
           "3Ag9lNuLb+hOKYCRJ++4xb67ea388mu3rj/xmvB7xU3Ko9vRDwDM0FPHOXm9" +
           "5sTzteBI6R7YIUiQ/1y6Cbi8mLL8AlnxkHNx6cauy0NJ6bFzuiRg/oPHk60f" +
           "SUo3jlsnpcvKqeo3A+07qE5KV0B+svIJUAQq88cni2X6cHbpdBxypCuP3st8" +
           "ToQu77jwYJ9Nd/9VsK985rX+4H3fbv7C7tqn4kjbbT7KdQD4uxuoRzHGsxeO" +
           "djjWtd7z333oVx5452Ew9NCO4GObPEHb28/3P4QbJMX1yO0/eeIfvfsXX/tq" +
           "cXb6vwGoggrB7DEAAA==");
    }
    private static final edu.umd.cs.findbugs.detect.FindRoughConstants.BadConstant[]
      badConstants =
      new edu.umd.cs.findbugs.detect.FindRoughConstants.BadConstant[] { new edu.umd.cs.findbugs.detect.FindRoughConstants.BadConstant(
      java.lang.Math.
        PI,
      1,
      "Math.PI",
      HIGH_PRIORITY),
    new edu.umd.cs.findbugs.detect.FindRoughConstants.BadConstant(
      java.lang.Math.
        PI,
      1 /
        2.0,
      "Math.PI/2",
      NORMAL_PRIORITY),
    new edu.umd.cs.findbugs.detect.FindRoughConstants.BadConstant(
      java.lang.Math.
        PI,
      1 /
        3.0,
      "Math.PI/3",
      LOW_PRIORITY),
    new edu.umd.cs.findbugs.detect.FindRoughConstants.BadConstant(
      java.lang.Math.
        PI,
      1 /
        4.0,
      "Math.PI/4",
      LOW_PRIORITY),
    new edu.umd.cs.findbugs.detect.FindRoughConstants.BadConstant(
      java.lang.Math.
        PI,
      2,
      "2*Math.PI",
      NORMAL_PRIORITY),
    new edu.umd.cs.findbugs.detect.FindRoughConstants.BadConstant(
      java.lang.Math.
        E,
      1,
      "Math.E",
      LOW_PRIORITY) };
    private final edu.umd.cs.findbugs.BugAccumulator
      bugAccumulator;
    private edu.umd.cs.findbugs.BugInstance
      lastBug;
    private int lastPriority;
    public FindRoughConstants(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        if (hasInterestingConstant(
              classContext.
                getJavaClass(
                  ).
                getConstantPool(
                  ))) {
            super.
              visitClassContext(
                classContext);
        }
    }
    @java.lang.Override
    public void visitAfter(org.apache.bcel.classfile.JavaClass obj) {
        bugAccumulator.
          reportAccumulatedBugs(
            );
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen ==
                                            LDC ||
                                            seen ==
                                            LDC_W ||
                                            seen ==
                                            LDC2_W) {
                                          org.apache.bcel.classfile.Constant c =
                                            getConstantRefOperand(
                                              );
                                          if (c instanceof org.apache.bcel.classfile.ConstantFloat) {
                                              checkConst(
                                                ((org.apache.bcel.classfile.ConstantFloat)
                                                   c).
                                                  getBytes(
                                                    ));
                                          }
                                          else
                                              if (c instanceof org.apache.bcel.classfile.ConstantDouble) {
                                                  checkConst(
                                                    ((org.apache.bcel.classfile.ConstantDouble)
                                                       c).
                                                      getBytes(
                                                        ));
                                              }
                                          return;
                                      }
                                      if (seen ==
                                            INVOKESTATIC &&
                                            lastBug !=
                                            null) {
                                          if (getNextOpcode(
                                                ) ==
                                                AASTORE &&
                                                getNameConstantOperand(
                                                  ).
                                                equals(
                                                  "valueOf") &&
                                                (getClassConstantOperand(
                                                   ).
                                                   equals(
                                                     "java/lang/Double") ||
                                                   getClassConstantOperand(
                                                     ).
                                                   equals(
                                                     "java/lang/Float"))) {
                                              lastBug =
                                                (edu.umd.cs.findbugs.BugInstance)
                                                  lastBug.
                                                  clone(
                                                    );
                                              lastBug.
                                                setPriority(
                                                  lastPriority +
                                                    1);
                                              bugAccumulator.
                                                forgetLastBug(
                                                  );
                                              bugAccumulator.
                                                accumulateBug(
                                                  lastBug,
                                                  this);
                                          }
                                      }
                                      lastBug =
                                        null;
    }
    private boolean hasInterestingConstant(org.apache.bcel.classfile.ConstantPool cp) {
        for (org.apache.bcel.classfile.Constant constant
              :
              cp.
               getConstantPool(
                 )) {
            if (constant instanceof org.apache.bcel.classfile.ConstantFloat) {
                float val =
                  ((org.apache.bcel.classfile.ConstantFloat)
                     constant).
                  getBytes(
                    );
                if (isInteresting(
                      val,
                      val)) {
                    return true;
                }
            }
            if (constant instanceof org.apache.bcel.classfile.ConstantDouble) {
                double val =
                  ((org.apache.bcel.classfile.ConstantDouble)
                     constant).
                  getBytes(
                    );
                if (isInteresting(
                      val,
                      val)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean isInteresting(java.lang.Number constValue,
                                  double candidate) {
        for (edu.umd.cs.findbugs.detect.FindRoughConstants.BadConstant badConstant
              :
              badConstants) {
            if (getPriority(
                  badConstant,
                  constValue,
                  candidate) <
                  IGNORE_PRIORITY) {
                return true;
            }
        }
        return false;
    }
    private int getPriority(edu.umd.cs.findbugs.detect.FindRoughConstants.BadConstant badConstant,
                            java.lang.Number constValue,
                            double candidate) {
        if (badConstant.
              exact(
                constValue)) {
            return IGNORE_PRIORITY;
        }
        double diff =
          badConstant.
          diff(
            candidate);
        if (diff >
              0.001) {
            return IGNORE_PRIORITY;
        }
        if (badConstant.
              equalPrefix(
                constValue)) {
            return diff >
              1.0E-4
              ? badConstant.
                  basePriority +
              1
              : (diff <
                   1.0E-6
                   ? badConstant.
                       basePriority -
                   1
                   : badConstant.
                       basePriority);
        }
        if (diff >
              1.0E-7) {
            return IGNORE_PRIORITY;
        }
        return badConstant.
                 basePriority +
          1;
    }
    private void checkConst(java.lang.Number constValue) {
        double candidate =
          constValue.
          doubleValue(
            );
        if (java.lang.Double.
              isNaN(
                candidate) ||
              java.lang.Double.
              isInfinite(
                candidate)) {
            return;
        }
        for (edu.umd.cs.findbugs.detect.FindRoughConstants.BadConstant badConstant
              :
              badConstants) {
            int priority =
              getPriority(
                badConstant,
                constValue,
                candidate);
            if (getNextOpcode(
                  ) ==
                  FASTORE ||
                  getNextOpcode(
                    ) ==
                  DASTORE) {
                priority++;
            }
            if (priority <
                  IGNORE_PRIORITY) {
                lastPriority =
                  priority;
                lastBug =
                  new edu.umd.cs.findbugs.BugInstance(
                    this,
                    "CNT_ROUGH_CONSTANT_VALUE",
                    priority).
                    addClassAndMethod(
                      this).
                    addString(
                      constValue.
                        toString(
                          )).
                    addString(
                      badConstant.
                        replacement);
                bugAccumulator.
                  accumulateBug(
                    lastBug,
                    this);
                return;
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KpW6lqJhkI8ni6pMrTyStUNih2nmku4mwkqydsowb4xcCWP7LlGhfKElWmxD" +
       "xrd9sVux2TqyhaNKUqObfrrcJj0pDbs7ZzVPFWPuBVWsOhVc0yD6LQTBWqmx" +
       "9hOuMXAmBCV3JUoygw0jLWu6KXbcXurooqQT8Jj37NlCH/XpujDXSIxY+Evd" +
       "xzfuIO25Q62+8aRmQptMj6wiqIXhtjuY7NzKkhKAr6wndjgIJruJ6XCzKdLF" +
       "W2RlVJ94DbS7HeFDJR8hTbieK5SiNdxMmeAuZWs90unYQCldPbcHUrWrrh0b" +
       "Uyq9rqgjapMcmtpq2DU6KI4FrEkpzWm1QhGqzruUZY0jNFw4NM04IjGi2sKc" +
       "EHWKqgWCUW+NJZdi1yvToBOkJqwxY44kVZrSZCtAamSG4yHmsJVYUHwUjmJx" +
       "XM+Y2rCadcKuEQQNuEsMZ8JiNwaIWctqC5QbLLU220VjFDWEcVvLsJ06GKde" +
       "n06zyRLXCHbesex11nR2lqbrhm8OEVrcWZ6jCkMGmXey3VYYO/WAB58hjyCN" +
       "ficeYPQoGOk1ceDhxswFVrViyA0conl9sGvCa7q3rC1o1cyx+oqzA4fLJuMd" +
       "UmdiOobtPJ+pwkwg2PFusBshnmVIIZstkcxuDPtWrY7KhgfDFoeJUp+w8GVv" +
       "4Q1brqkkYlWzpYD0lHDJkW4srSRB0GZWU2RdP2mjfkukW0gnpzuGJW/TzYJi" +
       "MF8V1la9EclOT620Ns32fG3oFbNab4WG67vpMhqb2tzy7OGEpwe4QU03diOf" +
       "r4iJrGnoTqgv0W1r2eoud22THBCLIZic8MG07ueilG2zCF5vmxwS1SYIQgVu" +
       "zeFcmZwzRseXyGGHr5gbu0dgzK620xYLYrmZ5e1ef8HPyF1XGwZ4f0G6xiaL" +
       "dlRGspSxEnduY51RfkVaNEYeJq1YTE02rGHb7BbO0Gk3b28qMBzpTcMXdjY5" +
       "09lONtFNCltwMLIdurEIp6KpWvU1nvKZKZiVyphW6mtB12mFHmGjSWel+XY6" +
       "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" +
       "2v850Phfb0bEDZiCbj9KL67zvOO2S7f7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("i6LqF165/sDbX5n9m/2lgKPLnA+y0ANG5rqnb1Wcer8cxrphlxI8uL9jERZ/" +
       "Fy6n0ON3P+UvTL18Kfi+cP++yYMp9OgdmqSg/8PX07WvAVWd1E6hi+qZ4usA" +
       "Jw6LU+gSSE8X3gRZoLB4fTQ88tD33fHcewu4BPjNqyACAz7WK7kO4s2Fs0Hi" +
       "8SDdfKNBOhVXPnsmGiyvTB9Fbtn+0vSL6hdfYUY/+nrjs/sbbgBkd7uCygMs" +
       "dGV/2e44+nv6rtSOaF2mn/vWwz/34LuPItWH9wyfGPcp3t515+tkhBem5QWw" +
       "3d97+999/9945bfKY9X/B7wOnGjLLgAA");
}
