package edu.umd.cs.findbugs.detect;
public class RepeatedConditionals extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    edu.umd.cs.findbugs.BugReporter bugReporter;
    private final edu.umd.cs.findbugs.detect.FindNoSideEffectMethods.NoSideEffectMethodsDatabase
      noSideEffectMethods;
    public RepeatedConditionals(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          noSideEffectMethods =
          edu.umd.cs.findbugs.classfile.Global.
            getAnalysisCache(
              ).
            getDatabase(
              edu.umd.cs.findbugs.detect.FindNoSideEffectMethods.NoSideEffectMethodsDatabase.class);
        reset(
          );
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code code) { boolean interesting =
                                                               true;
                                                             if (interesting) {
                                                                 super.
                                                                   visit(
                                                                     code);
                                                                 reset(
                                                                   );
                                                             }
    }
    int oldPC;
    java.util.LinkedList<java.lang.Integer> emptyStackLocations =
      new java.util.LinkedList<java.lang.Integer>(
      );
    java.util.LinkedList<java.lang.Integer> prevOpcodeLocations =
      new java.util.LinkedList<java.lang.Integer>(
      );
    java.util.Map<java.lang.Integer,java.lang.Integer> branchTargets =
      new java.util.HashMap<java.lang.Integer,java.lang.Integer>(
      );
    @java.lang.Override
    public void sawBranchTo(int pc) { branchTargets.put(getPC(
                                                          ),
                                                        pc);
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (hasSideEffect(seen)) {
                                          reset(
                                            );
                                      }
                                      else
                                          if (stack.
                                                getStackDepth(
                                                  ) ==
                                                0) {
                                              if (emptyStackLocations.
                                                    size(
                                                      ) >
                                                    1) {
                                                  for (int n =
                                                         1;
                                                       n <=
                                                         emptyStackLocations.
                                                         size(
                                                           ) /
                                                         2;
                                                       n++) {
                                                      int first =
                                                        emptyStackLocations.
                                                        get(
                                                          emptyStackLocations.
                                                            size(
                                                              ) -
                                                            2 *
                                                            n);
                                                      int second =
                                                        emptyStackLocations.
                                                        get(
                                                          emptyStackLocations.
                                                            size(
                                                              ) -
                                                            n);
                                                      int third =
                                                        getPC(
                                                          );
                                                      if (third -
                                                            second ==
                                                            second -
                                                            first) {
                                                          int endOfFirstSegment =
                                                            prevOpcodeLocations.
                                                            get(
                                                              emptyStackLocations.
                                                                size(
                                                                  ) -
                                                                n);
                                                          int endOfSecondSegment =
                                                            oldPC;
                                                          int opcodeAtEndOfFirst =
                                                            getCodeByte(
                                                              endOfFirstSegment);
                                                          int opcodeAtEndOfSecond =
                                                            getCodeByte(
                                                              endOfSecondSegment);
                                                          if (!isBranch(
                                                                 opcodeAtEndOfFirst) ||
                                                                !isBranch(
                                                                   opcodeAtEndOfSecond)) {
                                                              continue;
                                                          }
                                                          if (opcodeAtEndOfFirst ==
                                                                org.objectweb.asm.Opcodes.
                                                                  GOTO ||
                                                                opcodeAtEndOfSecond ==
                                                                org.objectweb.asm.Opcodes.
                                                                  GOTO) {
                                                              continue;
                                                          }
                                                          if (opcodeAtEndOfFirst !=
                                                                opcodeAtEndOfSecond &&
                                                                !areOppositeBranches(
                                                                   opcodeAtEndOfFirst,
                                                                   opcodeAtEndOfSecond)) {
                                                              continue;
                                                          }
                                                          if (first ==
                                                                endOfFirstSegment) {
                                                              continue;
                                                          }
                                                          java.lang.Integer firstTarget =
                                                            branchTargets.
                                                            get(
                                                              endOfFirstSegment);
                                                          java.lang.Integer secondTarget =
                                                            branchTargets.
                                                            get(
                                                              endOfSecondSegment);
                                                          if (firstTarget ==
                                                                null ||
                                                                secondTarget ==
                                                                null) {
                                                              continue;
                                                          }
                                                          if (firstTarget >=
                                                                second &&
                                                                firstTarget <=
                                                                endOfSecondSegment) {
                                                              continue;
                                                          }
                                                          boolean identicalCheck =
                                                            firstTarget.
                                                            equals(
                                                              secondTarget) &&
                                                            opcodeAtEndOfFirst ==
                                                            opcodeAtEndOfSecond ||
                                                            firstTarget.
                                                            intValue(
                                                              ) ==
                                                            getPC(
                                                              ) &&
                                                            opcodeAtEndOfFirst !=
                                                            opcodeAtEndOfSecond;
                                                          if (!compareCode(
                                                                 first,
                                                                 endOfFirstSegment,
                                                                 second,
                                                                 endOfSecondSegment,
                                                                 !identicalCheck)) {
                                                              continue;
                                                          }
                                                          edu.umd.cs.findbugs.SourceLineAnnotation firstSourceLine =
                                                            edu.umd.cs.findbugs.SourceLineAnnotation.
                                                            fromVisitedInstructionRange(
                                                              getClassContext(
                                                                ),
                                                              this,
                                                              first,
                                                              endOfFirstSegment -
                                                                1);
                                                          edu.umd.cs.findbugs.SourceLineAnnotation secondSourceLine =
                                                            edu.umd.cs.findbugs.SourceLineAnnotation.
                                                            fromVisitedInstructionRange(
                                                              getClassContext(
                                                                ),
                                                              this,
                                                              second,
                                                              endOfSecondSegment -
                                                                1);
                                                          int priority =
                                                            HIGH_PRIORITY;
                                                          if (firstSourceLine.
                                                                getStartLine(
                                                                  ) ==
                                                                -1 ||
                                                                firstSourceLine.
                                                                getStartLine(
                                                                  ) !=
                                                                secondSourceLine.
                                                                getEndLine(
                                                                  )) {
                                                              priority++;
                                                          }
                                                          if (stack.
                                                                isJumpTarget(
                                                                  second)) {
                                                              priority++;
                                                          }
                                                          if (!identicalCheck) {
                                                              priority +=
                                                                2;
                                                          }
                                                          edu.umd.cs.findbugs.BugInstance bug =
                                                            new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "RpC_REPEATED_CONDITIONAL_TEST",
                                                            priority).
                                                            addClassAndMethod(
                                                              this).
                                                            add(
                                                              firstSourceLine).
                                                            add(
                                                              secondSourceLine);
                                                          bugReporter.
                                                            reportBug(
                                                              bug);
                                                      }
                                                  }
                                              }
                                              emptyStackLocations.
                                                add(
                                                  getPC(
                                                    ));
                                              prevOpcodeLocations.
                                                add(
                                                  oldPC);
                                          }
                                      oldPC =
                                        getPC(
                                          );
    }
    private boolean compareCode(int first,
                                int endOfFirstSegment,
                                int second,
                                int endOfSecondSegment,
                                boolean oppositeChecks) {
        if (endOfFirstSegment -
              first !=
              endOfSecondSegment -
              second) {
            return false;
        }
        org.apache.bcel.generic.MethodGen methodGen =
          null;
        try {
            methodGen =
              edu.umd.cs.findbugs.classfile.Global.
                getAnalysisCache(
                  ).
                getMethodAnalysis(
                  org.apache.bcel.generic.MethodGen.class,
                  getMethodDescriptor(
                    ));
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            
        }
        if (methodGen ==
              null) {
            byte[] code =
              getCode(
                ).
              getCode(
                );
            for (int i =
                   first;
                 i <
                   endOfFirstSegment;
                 i++) {
                if (code[i] !=
                      code[i -
                             first +
                             second]) {
                    return false;
                }
            }
            return true;
        }
        org.apache.bcel.generic.InstructionHandle firstHandle =
          methodGen.
          getInstructionList(
            ).
          findHandle(
            first);
        org.apache.bcel.generic.InstructionHandle secondHandle =
          methodGen.
          getInstructionList(
            ).
          findHandle(
            second);
        while (true) {
            if (firstHandle ==
                  null ||
                  secondHandle ==
                  null) {
                return false;
            }
            if (firstHandle.
                  getPosition(
                    ) >=
                  endOfFirstSegment) {
                return secondHandle.
                  getPosition(
                    ) >=
                  endOfSecondSegment;
            }
            if (secondHandle.
                  getPosition(
                    ) >=
                  endOfSecondSegment) {
                return firstHandle.
                  getPosition(
                    ) >=
                  endOfFirstSegment;
            }
            org.apache.bcel.generic.Instruction firstInstruction =
              firstHandle.
              getInstruction(
                );
            org.apache.bcel.generic.Instruction secondInstruction =
              secondHandle.
              getInstruction(
                );
            if (firstInstruction instanceof org.apache.bcel.generic.BranchInstruction &&
                  secondInstruction instanceof org.apache.bcel.generic.BranchInstruction) {
                int firstOpcode =
                  firstInstruction.
                  getOpcode(
                    );
                int secondOpcode =
                  secondInstruction.
                  getOpcode(
                    );
                if (firstOpcode !=
                      secondOpcode) {
                    return false;
                }
                int firstTarget =
                  ((org.apache.bcel.generic.BranchInstruction)
                     firstInstruction).
                  getTarget(
                    ).
                  getPosition(
                    );
                int secondTarget =
                  ((org.apache.bcel.generic.BranchInstruction)
                     secondInstruction).
                  getTarget(
                    ).
                  getPosition(
                    );
                if (firstTarget ==
                      second) {
                    if (oppositeChecks ||
                          secondTarget <=
                          endOfSecondSegment) {
                        return false;
                    }
                }
                else {
                    if (!(firstTarget >=
                            first &&
                            firstTarget <=
                            endOfFirstSegment &&
                            firstTarget -
                            first ==
                            secondTarget -
                            second ||
                            firstTarget ==
                            secondTarget)) {
                        return false;
                    }
                }
            }
            else {
                if (!firstInstruction.
                      equals(
                        secondInstruction)) {
                    return false;
                }
            }
            firstHandle =
              firstHandle.
                getNext(
                  );
            secondHandle =
              secondHandle.
                getNext(
                  );
        }
    }
    private boolean hasSideEffect(int seen) {
        if (seen ==
              INVOKEVIRTUAL ||
              seen ==
              INVOKESPECIAL ||
              seen ==
              INVOKEINTERFACE ||
              seen ==
              INVOKESTATIC) {
            return noSideEffectMethods.
              is(
                getMethodDescriptorOperand(
                  ),
                edu.umd.cs.findbugs.detect.FindNoSideEffectMethods.MethodSideEffectStatus.
                  SE,
                edu.umd.cs.findbugs.detect.FindNoSideEffectMethods.MethodSideEffectStatus.
                  OBJ);
        }
        return isRegisterStore(
                 ) ||
          isReturn(
            seen) ||
          isSwitch(
            seen) ||
          seen ==
          INVOKEDYNAMIC ||
          seen ==
          PUTFIELD ||
          seen ==
          PUTSTATIC;
    }
    private void reset() { emptyStackLocations.
                             clear(
                               );
                           prevOpcodeLocations.
                             clear(
                               );
                           branchTargets.
                             clear(
                               );
                           oldPC = -1; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "t/7/AWjwlyO3JwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WdSTKjIgUDUSF2izWl5H2w0Ix9tBBo06");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Vi3SlQ3qjS0XblLaer0i+mknamyJbBnGpk7M8EwUF6pmqM1UsmGki7FxRkOI" +
       "q01GnjGXZHHdldYULXYZFu+tuwxeUZRpHQ3GS5ypjrneqpJlyNy2qqsowBBt" +
       "Bau6hSJ8DKEQNrNSewuSgBTD8ldMv/HGXn09XLzlO6rEs2w0H/jkG3i7tRt6" +
       "Om+eO3ojXPyuls5Ub514I3zqFWcUlt52UYFd8TXvE+9/+RVl9CvwpYP3obfi" +
       "0j2x57/DVteqfQLU1Tt/H9t9bz3+Sv+77/+Txyc/ZrznDdQoPXkGz7Mg/8Xw" +
       "U5/v/oj8c5dKl4++2d9W+Xh60YtnvpqEapyE7uTU9/q3na4TegpcjQPONs6+" +
       "az+W3W1asFdowU72Z4pNzhSsPOGF+r7kS7Kh7i9l1d69385L9/bbnqIWIP7T" +
       "HepVvpQ3X4hLV4rvbee+RV17pnKsYl88rWL3H6nYEUo3Tnx2WathaCrqHbTy" +
       "9kqSouNzpxn5LLiGB4wc/kAZmT/+eDHhj+7Apv+eN1+LS/dFUorvvn0U9ZB/" +
       "cMyYr1/ImLz7v/5AWMAdsID7W2LBa3dgwV/kzZ8BgwYs2H2WOsOAb/3tMeDR" +
       "vDMvuvulAwb80htlAHMuA64UE64UDDjTnGcK15aeZ6uSW8D6zsW82iu8+P8G" +
       "6iIXhXdq+4Bb3z3m1l+/3oeI12PH0+D6ygE7vvKDYcdZfdh74A40Xs+bu+PS" +
       "A4YUHZfKnKZy757vg8q8qLj0GLi+cUDlN34wVJ4k4ofuMPbDefMocI2hGqnx" +
       "aWXfe9MbIWwTlx49r7w3r1V87Lb/K9jVwsuffuX63W95RfgvRYXrUb36PXTp" +
       "bi2x7ZMlYyfur/qhqpkF2ffsCsiKL517z8Slxy8ugopLV3c3OeZ7T++WPJdX" +
       "tty+JAb7H9yenP2jcene49lx6ZJ8argMjOdgOC5dBu3JwX3QBQbzW8g/jCJv" +
       "Pw/dIsLtnE9Rb0MUWHvhZu90nnJkZTdeT0wnUptnLywjGSa7/wu5JX/mlQHz" +
       "E681fmVXvgtibZblUO6mS9d2lcRHCcjTF0I7hHW19/y3H/z1e547TJYe3CF8" +
       "rNQncHvy/FpZMq88yssusn/zln/1zn/+yleLL6z/D2dQzBquMwAA");
}
