package edu.umd.cs.findbugs.detect;
public class FindFloatEquality extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private static final int SAW_NOTHING = 0;
    private static final int SAW_COMP = 1;
    private int priority;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    private int state;
    public FindFloatEquality(edu.umd.cs.findbugs.BugReporter bugReporter) {
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
    java.util.Collection<edu.umd.cs.findbugs.SourceLineAnnotation> found =
      new java.util.LinkedList<edu.umd.cs.findbugs.SourceLineAnnotation>(
      );
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { found.clear();
                                                            priority = LOW_PRIORITY;
                                                            state = SAW_NOTHING;
                                                            super.visit(obj);
                                                            bugAccumulator.
                                                              reportAccumulatedBugs(
                                                                );
                                                            if (!found.
                                                                  isEmpty(
                                                                    )) {
                                                                edu.umd.cs.findbugs.BugInstance bug =
                                                                  new edu.umd.cs.findbugs.BugInstance(
                                                                  this,
                                                                  "FE_FLOATING_POINT_EQUALITY",
                                                                  priority).
                                                                  addClassAndMethod(
                                                                    this);
                                                                boolean first =
                                                                  true;
                                                                for (edu.umd.cs.findbugs.SourceLineAnnotation s
                                                                      :
                                                                      found) {
                                                                    bug.
                                                                      add(
                                                                        s);
                                                                    if (first) {
                                                                        first =
                                                                          false;
                                                                    }
                                                                    else {
                                                                        bug.
                                                                          describe(
                                                                            edu.umd.cs.findbugs.SourceLineAnnotation.
                                                                              ROLE_ANOTHER_INSTANCE);
                                                                    }
                                                                }
                                                                bugReporter.
                                                                  reportBug(
                                                                    bug);
                                                                found.
                                                                  clear(
                                                                    );
                                                            }
    }
    public boolean isZero(java.lang.Number n) {
        if (n ==
              null) {
            return false;
        }
        double v =
          n.
          doubleValue(
            );
        return v ==
          0.0;
    }
    public boolean okValueToCompareAgainst(java.lang.Number n) {
        if (n ==
              null) {
            return false;
        }
        double v =
          n.
          doubleValue(
            );
        if (java.lang.Double.
              isInfinite(
                v) ||
              java.lang.Double.
              isNaN(
                v)) {
            return true;
        }
        v =
          v -
            java.lang.Math.
            floor(
              v);
        return v ==
          0.0;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { switch (seen) {
                                          case FCMPG:
                                          case FCMPL:
                                          case DCMPG:
                                          case DCMPL:
                                              if (stack.
                                                    getStackDepth(
                                                      ) >=
                                                    2) {
                                                  edu.umd.cs.findbugs.OpcodeStack.Item first =
                                                    stack.
                                                    getStackItem(
                                                      0);
                                                  edu.umd.cs.findbugs.OpcodeStack.Item second =
                                                    stack.
                                                    getStackItem(
                                                      1);
                                                  if (first.
                                                        getRegisterNumber(
                                                          ) ==
                                                        second.
                                                        getRegisterNumber(
                                                          ) &&
                                                        first.
                                                        getRegisterNumber(
                                                          ) !=
                                                        -1) {
                                                      break;
                                                  }
                                                  if (first.
                                                        isInitialParameter(
                                                          ) &&
                                                        second.
                                                        isInitialParameter(
                                                          )) {
                                                      break;
                                                  }
                                                  if (sameField(
                                                        first,
                                                        second)) {
                                                      break;
                                                  }
                                                  java.lang.Number n1 =
                                                    (java.lang.Number)
                                                      first.
                                                      getConstant(
                                                        );
                                                  java.lang.Number n2 =
                                                    (java.lang.Number)
                                                      second.
                                                      getConstant(
                                                        );
                                                  if (n1 !=
                                                        null &&
                                                        java.lang.Double.
                                                        isNaN(
                                                          n1.
                                                            doubleValue(
                                                              )) ||
                                                        n2 !=
                                                        null &&
                                                        java.lang.Double.
                                                        isNaN(
                                                          n2.
                                                            doubleValue(
                                                              ))) {
                                                      edu.umd.cs.findbugs.BugInstance bug =
                                                        new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "FE_TEST_IF_EQUAL_TO_NOT_A_NUMBER",
                                                        HIGH_PRIORITY).
                                                        addClassAndMethod(
                                                          this);
                                                      bugAccumulator.
                                                        accumulateBug(
                                                          bug,
                                                          this);
                                                      state =
                                                        SAW_NOTHING;
                                                      break;
                                                  }
                                                  if (first.
                                                        getSpecialKind(
                                                          ) ==
                                                        edu.umd.cs.findbugs.OpcodeStack.Item.
                                                          NASTY_FLOAT_MATH &&
                                                        !isZero(
                                                           n2) ||
                                                        second.
                                                        getSpecialKind(
                                                          ) ==
                                                        edu.umd.cs.findbugs.OpcodeStack.Item.
                                                          NASTY_FLOAT_MATH &&
                                                        !isZero(
                                                           n1) ||
                                                        first.
                                                        getSpecialKind(
                                                          ) ==
                                                        edu.umd.cs.findbugs.OpcodeStack.Item.
                                                          FLOAT_MATH &&
                                                        !okValueToCompareAgainst(
                                                           n2) ||
                                                        second.
                                                        getSpecialKind(
                                                          ) ==
                                                        edu.umd.cs.findbugs.OpcodeStack.Item.
                                                          FLOAT_MATH &&
                                                        !okValueToCompareAgainst(
                                                           n1)) {
                                                      if (priority !=
                                                            HIGH_PRIORITY) {
                                                          found.
                                                            clear(
                                                              );
                                                      }
                                                      priority =
                                                        HIGH_PRIORITY;
                                                      state =
                                                        SAW_COMP;
                                                      break;
                                                  }
                                                  if (priority ==
                                                        HIGH_PRIORITY) {
                                                      break;
                                                  }
                                                  if (n1 !=
                                                        null &&
                                                        n2 !=
                                                        null) {
                                                      break;
                                                  }
                                                  if (okValueToCompareAgainst(
                                                        n1) ||
                                                        okValueToCompareAgainst(
                                                          n2)) {
                                                      break;
                                                  }
                                                  if (n1 !=
                                                        null &&
                                                        !second.
                                                        isInitialParameter(
                                                          ) ||
                                                        n2 !=
                                                        null &&
                                                        !first.
                                                        isInitialParameter(
                                                          )) {
                                                      if (priority ==
                                                            LOW_PRIORITY) {
                                                          found.
                                                            clear(
                                                              );
                                                      }
                                                      priority =
                                                        NORMAL_PRIORITY;
                                                  }
                                                  else
                                                      if (priority ==
                                                            NORMAL_PRIORITY) {
                                                          break;
                                                      }
                                                  state =
                                                    SAW_COMP;
                                              }
                                              break;
                                          case IFEQ:
                                          case IFNE:
                                              if (state ==
                                                    SAW_COMP) {
                                                  edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation =
                                                    edu.umd.cs.findbugs.SourceLineAnnotation.
                                                    fromVisitedInstruction(
                                                      getClassContext(
                                                        ),
                                                      this,
                                                      getPC(
                                                        ));
                                                  if (sourceLineAnnotation !=
                                                        null) {
                                                      found.
                                                        add(
                                                          sourceLineAnnotation);
                                                  }
                                              }
                                              state =
                                                SAW_NOTHING;
                                              break;
                                          default:
                                              state =
                                                SAW_NOTHING;
                                              break;
                                      } }
    static boolean sameField(edu.umd.cs.findbugs.OpcodeStack.Item i1,
                             edu.umd.cs.findbugs.OpcodeStack.Item i2) {
        if (i1.
              getXField(
                ) ==
              null) {
            return false;
        }
        if (!i1.
              getXField(
                ).
              equals(
                i2.
                  getXField(
                    ))) {
            return false;
        }
        if (i1.
              getFieldLoadedFromRegister(
                ) !=
              i2.
              getFieldLoadedFromRegister(
                )) {
            return false;
        }
        return true;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "sbfqP/S2ZsHfJgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "H45Fkmo2o4jeNsbzGtABdLtqImi/56Hx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("pGwNVQiVp1iXm9uo4jEWZ6OTie2Uo+V6Np9t27WFZHSZkQPpDDNdD2B3YKht" +
       "lB2PtB48XsYZEhjdZSXdJA2j2p2l3d5k1IMWwtCGazPDodURbxsCpFeqlbpS" +
       "EV0JVZZtxJkLkdUftGscIcPDOejPxJGs7TeVgU3BmwVaoatiQCbzUI3FCj/Q" +
       "BGjC1pO471OjeqQYKwbialLUM/omhuXHU//i7R2bPVwcAx7F4C0dJC/4+bdx" +
       "MrYrejpPnju69yh+l0tn4rZO3HucOP88ipN47tzj0/wWxtGjqF2EM/lhflP6" +
       "3rsF4hW3pJ/92Guva+Ofq+4dHK1ycen+2A/e7+iJ7pwY+NK9r1PoIg7x+Fr/" +
       "Vz/2h49Pf2jx4bcR1PTkGTrPdvlP6M99ufs+9e/ulS4eXfLfESF5utHLZw7Z" +
       "Qz1eh9701AX/e08HFj0Jnh88mIcfPHv/dDzT59+HPb/TlDPRKWciXJ7wQ3Nf" +
       "DmR1oe8rqu7sjuvzEL99wtd2h7u/dY8Al9/Jky/HpUvF9cy557WJb2nHCvlr" +
       "pxXywSOFPCLp5olT+kQPQ0vT76HDd4aeFBm/ciTIR/LM/Fp5diDI2f8TQd4R" +
       "QVE0+sY9RPdf8+T34tJlK5L00D9PdlcU33d02TsW39fe7KT7zSSRX2V/6EAS" +
       "H/pLlUT++Z+LCn9yD66/kyf/Iy495ttF3MzU30Wj6ZgpW97uHu6bx/z+z++D" +
       "38KEngXP8oDf5V86v2xR4Xt35/dCUe3PAY5FcjoOVGBTecZXjjn87l0NIs/+" +
       "6vet+nlw4hcPBPDFtysA6lwB7O1iBw5V/9Z56L/jFawBqn2LinU3l8U7Cok8" +
       "eA9p3ciTK4W0XL0I7DqtDxeuvh19yMAqeUcQbR4R+O47gvZ3gebqL71+/epj" +
       "r8/+YxFHehQMfv+wdNVYO87JwKwT75eDUDesQlL378K0goKZx+LS43cP7wWG" +
       "v3vJyb7w6K7J43HpkXOaxGD8g9eTtd8bl64d145Le+qp4qcAgBwUx6WLID1Z" +
       "+CzIAoX5663gcCbPjUYuloUT03m0nF84dRV6rNE332yOjpqcDFI9e1VPr3f/" +
       "dHFb/fzr/dGPfrv5c7sgWbBAbbd5L1eHpSu7eN2jVfvpu/Z22Nfl3gvffeiX" +
       "73/u0MN4aEfwsR2coO3J8yNSSTeIixjS7b967J9/4Odf/1oRI/d/AdUR014L" +
       "MwAA");
}
