package edu.umd.cs.findbugs.detect;
public class FindLocalSelfAssignment2 extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private int previousLoadOf = -1;
    private int previousGotoTarget;
    private int gotoCount;
    public FindLocalSelfAssignment2(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    private final java.util.BitSet previousStores = new java.util.BitSet(
      );
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { previousLoadOf =
                                                              -1;
                                                            previousGotoTarget =
                                                              -1;
                                                            gotoCount =
                                                              0;
                                                            previousStores.
                                                              clear(
                                                                );
                                                            super.
                                                              visit(
                                                                obj);
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen == GOTO) { previousGotoTarget =
                                                            getBranchTarget(
                                                              );
                                                          gotoCount++;
                                                          if (previousGotoTarget <
                                                                getPC(
                                                                  )) {
                                                              previousLoadOf =
                                                                -1;
                                                          }
                                      }
                                      else {
                                          if (isRegisterLoad(
                                                )) {
                                              previousLoadOf =
                                                getRegisterOperand(
                                                  );
                                          }
                                          else {
                                              if (isRegisterStore(
                                                    )) {
                                                  if (previousLoadOf ==
                                                        getRegisterOperand(
                                                          ) &&
                                                        gotoCount <
                                                        2 &&
                                                        getPC(
                                                          ) !=
                                                        previousGotoTarget) {
                                                      int priority =
                                                        NORMAL_PRIORITY;
                                                      java.lang.String methodName =
                                                        getMethodName(
                                                          );
                                                      if ("<init>".
                                                            equals(
                                                              methodName) ||
                                                            methodName.
                                                            startsWith(
                                                              "set") &&
                                                            getCode(
                                                              ).
                                                              getCode(
                                                                ).
                                                              length <=
                                                            5 ||
                                                            !previousStores.
                                                            get(
                                                              getRegisterOperand(
                                                                ))) {
                                                          priority =
                                                            HIGH_PRIORITY;
                                                      }
                                                      previousStores.
                                                        set(
                                                          getRegisterOperand(
                                                            ));
                                                      edu.umd.cs.findbugs.ba.XClass c =
                                                        getXClass(
                                                          );
                                                      edu.umd.cs.findbugs.LocalVariableAnnotation local =
                                                        edu.umd.cs.findbugs.LocalVariableAnnotation.
                                                        getLocalVariableAnnotation(
                                                          getMethod(
                                                            ),
                                                          getRegisterOperand(
                                                            ),
                                                          getPC(
                                                            ),
                                                          getPC(
                                                            ));
                                                      if ("?".
                                                            equals(
                                                              local.
                                                                getName(
                                                                  ))) {
                                                          priority++;
                                                      }
                                                      else {
                                                          for (edu.umd.cs.findbugs.ba.XField f
                                                                :
                                                                c.
                                                                 getXFields(
                                                                   )) {
                                                              if (f.
                                                                    getName(
                                                                      ).
                                                                    equals(
                                                                      local.
                                                                        getName(
                                                                          )) &&
                                                                    (f.
                                                                       isStatic(
                                                                         ) ||
                                                                       !getMethod(
                                                                          ).
                                                                       isStatic(
                                                                         ))) {
                                                                  bugReporter.
                                                                    reportBug(
                                                                      new edu.umd.cs.findbugs.BugInstance(
                                                                        this,
                                                                        "SA_LOCAL_SELF_ASSIGNMENT_INSTEAD_OF_FIELD",
                                                                        priority).
                                                                        addClassAndMethod(
                                                                          this).
                                                                        add(
                                                                          local).
                                                                        addField(
                                                                          f).
                                                                        describe(
                                                                          edu.umd.cs.findbugs.FieldAnnotation.
                                                                            DID_YOU_MEAN_ROLE).
                                                                        addSourceLine(
                                                                          this));
                                                                  return;
                                                              }
                                                          }
                                                      }
                                                      bugReporter.
                                                        reportBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "SA_LOCAL_SELF_ASSIGNMENT",
                                                            priority).
                                                            addClassAndMethod(
                                                              this).
                                                            add(
                                                              local).
                                                            addSourceLine(
                                                              this));
                                                  }
                                                  else {
                                                      previousStores.
                                                        set(
                                                          getRegisterOperand(
                                                            ));
                                                  }
                                              }
                                              previousLoadOf =
                                                -1;
                                              gotoCount =
                                                0;
                                          }
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Oin4gsoDezgXJA1z4nf5K2ve+x8iN/AqUhwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "wo/SKqlc/OK7f/7DP/n6H1TXyv8Pi/ZPeTEnAAA=");
}
