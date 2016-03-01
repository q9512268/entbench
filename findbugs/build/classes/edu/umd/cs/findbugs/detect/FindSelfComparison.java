package edu.umd.cs.findbugs.detect;
public class FindSelfComparison extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    public FindSelfComparison(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    int putFieldPC = java.lang.Integer.MIN_VALUE;
    edu.umd.cs.findbugs.OpcodeStack.Item putFieldObj;
    edu.umd.cs.findbugs.OpcodeStack.Item putFieldValue;
    edu.umd.cs.findbugs.ba.XField putFieldXField;
    int lastMethodCall;
    static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.getBoolean(
                                                                        "fsc.debug");
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { if (DEBUG) {
                                                                java.lang.System.
                                                                  out.
                                                                  println(
                                                                    getFullyQualifiedMethodName(
                                                                      ));
                                                            }
                                                            whichRegister =
                                                              -1;
                                                            registerLoadCount =
                                                              0;
                                                            lastMethodCall =
                                                              -1;
                                                            resetDoubleAssignmentState(
                                                              );
                                                            super.
                                                              visit(
                                                                obj);
                                                            resetDoubleAssignmentState(
                                                              );
                                                            bugAccumulator.
                                                              reportAccumulatedBugs(
                                                                );
                                                            if (DEBUG) {
                                                                java.lang.System.
                                                                  out.
                                                                  println(
                                                                    );
                                                            }
    }
    private void resetDoubleAssignmentState() {
        putFieldPC =
          java.lang.Integer.
            MIN_VALUE;
        putFieldXField =
          null;
        putFieldValue =
          null;
        putFieldObj =
          null;
    }
    @java.lang.Override
    public void sawBranchTo(int target) {
        resetDoubleAssignmentState(
          );
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (DEBUG) {
                                          java.lang.System.
                                            out.
                                            printf(
                                              "%3d %-15s %s%n",
                                              getPC(
                                                ),
                                              OPCODE_NAMES[seen],
                                              stack);
                                      }
                                      if (stack.
                                            hasIncomingBranches(
                                              getPC(
                                                ))) {
                                          resetDoubleAssignmentState(
                                            );
                                      }
                                      if (seen ==
                                            PUTFIELD) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item obj =
                                            stack.
                                            getStackItem(
                                              1);
                                          edu.umd.cs.findbugs.OpcodeStack.Item value =
                                            stack.
                                            getStackItem(
                                              0);
                                          edu.umd.cs.findbugs.ba.XField f =
                                            getXFieldOperand(
                                              );
                                          edu.umd.cs.findbugs.ba.XClass x =
                                            getXClassOperand(
                                              );
                                          checkPUTFIELD: if (putFieldPC +
                                                               10 >
                                                               getPC(
                                                                 ) &&
                                                               f !=
                                                               null &&
                                                               obj !=
                                                               null &&
                                                               f.
                                                               equals(
                                                                 putFieldXField) &&
                                                               !f.
                                                               isSynthetic(
                                                                 ) &&
                                                               obj.
                                                               sameValue(
                                                                 putFieldObj) &&
                                                               x !=
                                                               null) {
                                              org.apache.bcel.classfile.LineNumberTable table =
                                                getCode(
                                                  ).
                                                getLineNumberTable(
                                                  );
                                              if (table !=
                                                    null) {
                                                  int first =
                                                    table.
                                                    getSourceLine(
                                                      putFieldPC);
                                                  int second =
                                                    table.
                                                    getSourceLine(
                                                      getPC(
                                                        ));
                                                  if (first +
                                                        1 !=
                                                        second &&
                                                        first !=
                                                        second) {
                                                      break checkPUTFIELD;
                                                  }
                                              }
                                              else
                                                  if (putFieldPC +
                                                        3 !=
                                                        getPC(
                                                          )) {
                                                      break checkPUTFIELD;
                                                  }
                                              int priority =
                                                NORMAL_PRIORITY;
                                              if (value.
                                                    equals(
                                                      putFieldValue) &&
                                                    putFieldPC +
                                                    3 !=
                                                    getPC(
                                                      )) {
                                                  priority++;
                                              }
                                              boolean storeOfDefaultValue =
                                                putFieldValue.
                                                isNull(
                                                  ) ||
                                                putFieldValue.
                                                hasConstantValue(
                                                  0);
                                              if (storeOfDefaultValue) {
                                                  priority++;
                                              }
                                              if (f.
                                                    isVolatile(
                                                      )) {
                                                  priority++;
                                              }
                                              edu.umd.cs.findbugs.ba.XField intendedTarget =
                                                null;
                                              double minimumDistance =
                                                2;
                                              int matches =
                                                0;
                                              for (edu.umd.cs.findbugs.ba.XField f2
                                                    :
                                                    x.
                                                     getXFields(
                                                       )) {
                                                  if (!f.
                                                        equals(
                                                          f2) &&
                                                        !f2.
                                                        isStatic(
                                                          ) &&
                                                        !f2.
                                                        isFinal(
                                                          ) &&
                                                        !f2.
                                                        isSynthetic(
                                                          ) &&
                                                        f2.
                                                        getSignature(
                                                          ).
                                                        equals(
                                                          f.
                                                            getSignature(
                                                              ))) {
                                                      double distance =
                                                        edu.umd.cs.findbugs.util.EditDistance.
                                                        editDistanceRatio(
                                                          f.
                                                            getName(
                                                              ),
                                                          f2.
                                                            getName(
                                                              ));
                                                      matches++;
                                                      if (minimumDistance >
                                                            distance) {
                                                          minimumDistance =
                                                            distance;
                                                          intendedTarget =
                                                            f2;
                                                      }
                                                  }
                                              }
                                              if (minimumDistance >
                                                    0.6 &&
                                                    (matches >
                                                       1 ||
                                                       storeOfDefaultValue)) {
                                                  intendedTarget =
                                                    null;
                                              }
                                              else
                                                  if (intendedTarget !=
                                                        null) {
                                                      priority--;
                                                  }
                                              edu.umd.cs.findbugs.BugInstance bug =
                                                new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                "SA_FIELD_DOUBLE_ASSIGNMENT",
                                                priority).
                                                addClassAndMethod(
                                                  this).
                                                addReferencedField(
                                                  this);
                                              if (intendedTarget !=
                                                    null) {
                                                  bug.
                                                    addField(
                                                      intendedTarget).
                                                    describe(
                                                      edu.umd.cs.findbugs.FieldAnnotation.
                                                        DID_YOU_MEAN_ROLE);
                                              }
                                              bugAccumulator.
                                                accumulateBug(
                                                  bug,
                                                  this);
                                          }
                                          putFieldPC =
                                            getPC(
                                              );
                                          putFieldXField =
                                            f;
                                          putFieldObj =
                                            obj;
                                          putFieldValue =
                                            value;
                                      }
                                      else
                                          if (isReturn(
                                                seen)) {
                                              resetDoubleAssignmentState(
                                                );
                                          }
                                          else
                                              if (seen ==
                                                    GETFIELD &&
                                                    edu.umd.cs.findbugs.util.Util.
                                                    nullSafeEquals(
                                                      getXFieldOperand(
                                                        ),
                                                      putFieldXField)) {
                                                  edu.umd.cs.findbugs.OpcodeStack.Item obj =
                                                    stack.
                                                    getStackItem(
                                                      0);
                                                  if (obj.
                                                        sameValue(
                                                          putFieldObj)) {
                                                      resetDoubleAssignmentState(
                                                        );
                                                  }
                                              }
                                      switch (seen) {
                                          case INVOKEVIRTUAL:
                                          case INVOKEINTERFACE:
                                              if (getClassName(
                                                    ).
                                                    toLowerCase(
                                                      ).
                                                    indexOf(
                                                      "test") >=
                                                    0) {
                                                  break;
                                              }
                                              if (getMethodName(
                                                    ).
                                                    toLowerCase(
                                                      ).
                                                    indexOf(
                                                      "test") >=
                                                    0) {
                                                  break;
                                              }
                                              if (getSuperclassName(
                                                    ).
                                                    toLowerCase(
                                                      ).
                                                    indexOf(
                                                      "test") >=
                                                    0) {
                                                  break;
                                              }
                                              if (getNextOpcode(
                                                    ) ==
                                                    POP) {
                                                  break;
                                              }
                                              java.lang.String name =
                                                getNameConstantOperand(
                                                  );
                                              boolean booleanComparisonMethod =
                                                edu.umd.cs.findbugs.detect.FindSelfComparison2.
                                                booleanComparisonMethod(
                                                  name);
                                              if (booleanComparisonMethod ||
                                                    edu.umd.cs.findbugs.detect.FindSelfComparison2.
                                                    comparatorMethod(
                                                      name)) {
                                                  java.lang.String sig =
                                                    getSigConstantOperand(
                                                      );
                                                  edu.umd.cs.findbugs.ba.SignatureParser parser =
                                                    new edu.umd.cs.findbugs.ba.SignatureParser(
                                                    sig);
                                                  int numParameters =
                                                    parser.
                                                    getNumParameters(
                                                      );
                                                  if ((numParameters ==
                                                         1 ||
                                                         seen ==
                                                         INVOKESTATIC &&
                                                         numParameters ==
                                                         2) &&
                                                        (booleanComparisonMethod &&
                                                           sig.
                                                           endsWith(
                                                             ";)Z") ||
                                                           edu.umd.cs.findbugs.detect.FindSelfComparison2.
                                                           comparatorMethod(
                                                             name) &&
                                                           sig.
                                                           endsWith(
                                                             ";)I"))) {
                                                      checkForSelfOperation(
                                                        seen,
                                                        "COMPARISON");
                                                  }
                                              }
                                              break;
                                          case LOR:
                                          case LAND:
                                          case LXOR:
                                          case LSUB:
                                          case IOR:
                                          case IAND:
                                          case IXOR:
                                          case ISUB:
                                              checkForSelfOperation(
                                                seen,
                                                "COMPUTATION");
                                              break;
                                          case FCMPG:
                                          case DCMPG:
                                          case DCMPL:
                                          case FCMPL:
                                              break;
                                          case LCMP:
                                          case IF_ACMPEQ:
                                          case IF_ACMPNE:
                                          case IF_ICMPNE:
                                          case IF_ICMPEQ:
                                          case IF_ICMPGT:
                                          case IF_ICMPLE:
                                          case IF_ICMPLT:
                                          case IF_ICMPGE:
                                              checkForSelfOperation(
                                                seen,
                                                "COMPARISON");
                                              break;
                                          default:
                                              break;
                                      }
                                      if (isRegisterLoad(
                                            ) &&
                                            seen !=
                                            IINC) {
                                          if (getRegisterOperand(
                                                ) ==
                                                whichRegister) {
                                              registerLoadCount++;
                                          }
                                          else {
                                              whichRegister =
                                                getRegisterOperand(
                                                  );
                                              registerLoadCount =
                                                1;
                                          }
                                      }
                                      else {
                                          whichRegister =
                                            -1;
                                          registerLoadCount =
                                            0;
                                      }
                                      if (isMethodCall(
                                            )) {
                                          lastMethodCall =
                                            getPC(
                                              );
                                      } }
    int whichRegister;
    int registerLoadCount;
    private void checkForSelfOperation(int opCode,
                                       java.lang.String op) {
        {
            edu.umd.cs.findbugs.OpcodeStack.Item item0 =
              stack.
              getStackItem(
                0);
            edu.umd.cs.findbugs.OpcodeStack.Item item1 =
              stack.
              getStackItem(
                1);
            if ("D".
                  equals(
                    item0.
                      getSignature(
                        )) ||
                  "F".
                  equals(
                    item0.
                      getSignature(
                        ))) {
                return;
            }
            if ("D".
                  equals(
                    item1.
                      getSignature(
                        )) ||
                  "F".
                  equals(
                    item1.
                      getSignature(
                        ))) {
                return;
            }
            java.util.BitSet linesMentionedMultipleTimes =
              getClassContext(
                ).
              linesMentionedMultipleTimes(
                getMethod(
                  ));
            edu.umd.cs.findbugs.SourceLineAnnotation source =
              edu.umd.cs.findbugs.SourceLineAnnotation.
              fromVisitedInstruction(
                this);
            boolean possibleClone =
              source.
              getStartLine(
                ) >
              0 &&
              linesMentionedMultipleTimes.
              get(
                source.
                  getStartLine(
                    ));
            org.apache.bcel.classfile.LineNumberTable lineNumberTable =
              getCode(
                ).
              getLineNumberTable(
                );
            int linesDifference =
              0;
            if (item0.
                  getPC(
                    ) !=
                  -1 &&
                  item1.
                  getPC(
                    ) !=
                  -1) {
                if (lineNumberTable !=
                      null) {
                    int line0 =
                      lineNumberTable.
                      getSourceLine(
                        item0.
                          getPC(
                            ));
                    int line1 =
                      lineNumberTable.
                      getSourceLine(
                        item1.
                          getPC(
                            ));
                    int firstPos =
                      java.lang.Math.
                      min(
                        item0.
                          getPC(
                            ),
                        item1.
                          getPC(
                            ));
                    if (firstPos <
                          lastMethodCall &&
                          line0 !=
                          line1) {
                        return;
                    }
                    linesDifference =
                      java.lang.Math.
                        abs(
                          line0 -
                            line1);
                }
                else {
                    int firstPos =
                      java.lang.Math.
                      min(
                        item0.
                          getPC(
                            ),
                        item1.
                          getPC(
                            ));
                    int lastPos =
                      java.lang.Math.
                      max(
                        item0.
                          getPC(
                            ),
                        item1.
                          getPC(
                            ));
                    if (firstPos <
                          lastMethodCall &&
                          lastPos -
                          firstPos >
                          4) {
                        return;
                    }
                    linesDifference =
                      (lastPos -
                         firstPos) /
                        10;
                }
            }
            edu.umd.cs.findbugs.ba.XField field0 =
              item0.
              getXField(
                );
            edu.umd.cs.findbugs.ba.XField field1 =
              item1.
              getXField(
                );
            int fr0 =
              item0.
              getFieldLoadedFromRegister(
                );
            int fr1 =
              item1.
              getFieldLoadedFromRegister(
                );
            if (field0 !=
                  null &&
                  field0.
                  equals(
                    field1) &&
                  (field0.
                     isStatic(
                       ) ||
                     fr0 !=
                     -1 &&
                     fr0 ==
                     fr1)) {
                int priority =
                  NORMAL_PRIORITY;
                if (field0.
                      isVolatile(
                        )) {
                    priority++;
                }
                if (linesDifference >
                      1) {
                    if (possibleClone) {
                        return;
                    }
                    priority++;
                }
                edu.umd.cs.findbugs.BugInstance bug =
                  new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "SA_FIELD_SELF_" +
                  op,
                  priority).
                  addClassAndMethod(
                    this).
                  addField(
                    field0);
                if (this.
                      isMethodCall(
                        )) {
                    bug.
                      addCalledMethod(
                        this);
                }
                bugAccumulator.
                  accumulateBug(
                    bug,
                    this);
            }
            else
                if (opCode ==
                      IXOR &&
                      item0.
                      sameValue(
                        item1)) {
                    edu.umd.cs.findbugs.LocalVariableAnnotation localVariableAnnotation =
                      edu.umd.cs.findbugs.LocalVariableAnnotation.
                      getLocalVariableAnnotation(
                        this,
                        item0);
                    if (localVariableAnnotation !=
                          null) {
                        bugAccumulator.
                          accumulateBug(
                            new edu.umd.cs.findbugs.BugInstance(
                              this,
                              "SA_LOCAL_SELF_" +
                              op,
                              linesDifference >
                                1
                                ? NORMAL_PRIORITY
                                : HIGH_PRIORITY).
                              addClassAndMethod(
                                this).
                              add(
                                localVariableAnnotation),
                            this);
                    }
                }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "WdWEzkN6KvTYFuGlgfXZkdX/BRMY4JXoIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UOg733eLoYf2LwXuS1f2Xa7G0Htu0yUG");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8x+/nm99LYaunbWOocvKherHgXU6ro6hKyA/X3kDFIHK4vXJ4MS2vnbbw9LC" +
       "7p87hu6VqP0wu3TRe58u0lP3WqRzDv/lC266vIV84lKT/T3kN5UvvTOkv//r" +
       "rZ/YXxoDHijPi1EeHkNX9/fXTt3yi3cc7WSsh8hXvvnEzz3ywZMQ4ok94DNh" +
       "P4fthdvf0Oq7QVzeqcp/8Zm/+8ZPvvO75VnV/wUG7+DPHi4AAA==");
}
