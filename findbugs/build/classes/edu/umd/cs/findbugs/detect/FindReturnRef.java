package edu.umd.cs.findbugs.detect;
public class FindReturnRef extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    boolean check = false;
    boolean thisOnTOS = false;
    boolean fieldOnTOS = false;
    boolean publicClass = false;
    boolean staticMethod = false;
    java.lang.String nameOnStack;
    java.lang.String classNameOnStack;
    java.lang.String sigOnStack;
    int parameterCount;
    boolean fieldIsStatic;
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    public FindReturnRef(edu.umd.cs.findbugs.BugReporter bugReporter) { super(
                                                                          );
                                                                        this.
                                                                          bugAccumulator =
                                                                          new edu.umd.cs.findbugs.BugAccumulator(
                                                                            bugReporter);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) {
        publicClass =
          obj.
            isPublic(
              );
        super.
          visit(
            obj);
    }
    @java.lang.Override
    public void visitAfter(org.apache.bcel.classfile.JavaClass obj) {
        bugAccumulator.
          reportAccumulatedBugs(
            );
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        check =
          publicClass &&
            (obj.
               getAccessFlags(
                 ) &
               ACC_PUBLIC) !=
            0;
        if (!check) {
            return;
        }
        staticMethod =
          (obj.
             getAccessFlags(
               ) &
             ACC_STATIC) !=
            0;
        parameterCount =
          getNumberMethodArguments(
            );
        if (!staticMethod) {
            parameterCount++;
        }
        thisOnTOS =
          false;
        fieldOnTOS =
          false;
        super.
          visit(
            obj);
        thisOnTOS =
          false;
        fieldOnTOS =
          false;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        if (check) {
            super.
              visit(
                obj);
        }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (!check) {
                                          return;
                                      }
                                      if (staticMethod &&
                                            seen ==
                                            PUTSTATIC &&
                                            edu.umd.cs.findbugs.detect.MutableStaticFields.
                                            mutableSignature(
                                              getSigConstantOperand(
                                                ))) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item top =
                                            stack.
                                            getStackItem(
                                              0);
                                          if (isPotentialCapture(
                                                top)) {
                                              bugAccumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "EI_EXPOSE_STATIC_REP2",
                                                    NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addReferencedField(
                                                      this).
                                                    add(
                                                      edu.umd.cs.findbugs.LocalVariableAnnotation.
                                                        getLocalVariableAnnotation(
                                                          getMethod(
                                                            ),
                                                          top.
                                                            getRegisterNumber(
                                                              ),
                                                          getPC(
                                                            ),
                                                          getPC(
                                                            ) -
                                                            1)),
                                                  this);
                                          }
                                      }
                                      if (!staticMethod &&
                                            seen ==
                                            PUTFIELD &&
                                            edu.umd.cs.findbugs.detect.MutableStaticFields.
                                            mutableSignature(
                                              getSigConstantOperand(
                                                ))) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item top =
                                            stack.
                                            getStackItem(
                                              0);
                                          edu.umd.cs.findbugs.OpcodeStack.Item target =
                                            stack.
                                            getStackItem(
                                              1);
                                          if (isPotentialCapture(
                                                top) &&
                                                target.
                                                getRegisterNumber(
                                                  ) ==
                                                0) {
                                              bugAccumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "EI_EXPOSE_REP2",
                                                    NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addReferencedField(
                                                      this).
                                                    add(
                                                      edu.umd.cs.findbugs.LocalVariableAnnotation.
                                                        getLocalVariableAnnotation(
                                                          getMethod(
                                                            ),
                                                          top.
                                                            getRegisterNumber(
                                                              ),
                                                          getPC(
                                                            ),
                                                          getPC(
                                                            ) -
                                                            1)),
                                                  this);
                                          }
                                      }
                                      if (seen ==
                                            ALOAD_0 &&
                                            !staticMethod) {
                                          thisOnTOS =
                                            true;
                                          fieldOnTOS =
                                            false;
                                          return;
                                      }
                                      if (thisOnTOS &&
                                            seen ==
                                            GETFIELD &&
                                            getClassConstantOperand(
                                              ).
                                            equals(
                                              getClassName(
                                                )) &&
                                            !edu.umd.cs.findbugs.ba.AnalysisContext.
                                            currentXFactory(
                                              ).
                                            isEmptyArrayField(
                                              getXFieldOperand(
                                                ))) {
                                          fieldOnTOS =
                                            true;
                                          thisOnTOS =
                                            false;
                                          nameOnStack =
                                            getNameConstantOperand(
                                              );
                                          classNameOnStack =
                                            getDottedClassConstantOperand(
                                              );
                                          sigOnStack =
                                            getSigConstantOperand(
                                              );
                                          fieldIsStatic =
                                            false;
                                          return;
                                      }
                                      if (seen ==
                                            GETSTATIC &&
                                            getClassConstantOperand(
                                              ).
                                            equals(
                                              getClassName(
                                                )) &&
                                            !edu.umd.cs.findbugs.ba.AnalysisContext.
                                            currentXFactory(
                                              ).
                                            isEmptyArrayField(
                                              getXFieldOperand(
                                                ))) {
                                          fieldOnTOS =
                                            true;
                                          thisOnTOS =
                                            false;
                                          nameOnStack =
                                            getNameConstantOperand(
                                              );
                                          classNameOnStack =
                                            getDottedClassConstantOperand(
                                              );
                                          sigOnStack =
                                            getSigConstantOperand(
                                              );
                                          fieldIsStatic =
                                            true;
                                          return;
                                      }
                                      thisOnTOS =
                                        false;
                                      if (check &&
                                            fieldOnTOS &&
                                            seen ==
                                            ARETURN &&
                                            nameOnStack.
                                            indexOf(
                                              "EMPTY") ==
                                            -1 &&
                                            edu.umd.cs.findbugs.detect.MutableStaticFields.
                                            mutableSignature(
                                              sigOnStack)) {
                                          bugAccumulator.
                                            accumulateBug(
                                              new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                staticMethod
                                                  ? "MS_EXPOSE_REP"
                                                  : "EI_EXPOSE_REP",
                                                NORMAL_PRIORITY).
                                                addClassAndMethod(
                                                  this).
                                                addField(
                                                  classNameOnStack,
                                                  nameOnStack,
                                                  sigOnStack,
                                                  fieldIsStatic),
                                              this);
                                      }
                                      fieldOnTOS =
                                        false;
                                      thisOnTOS =
                                        false;
    }
    private boolean isPotentialCapture(edu.umd.cs.findbugs.OpcodeStack.Item top) {
        if (!top.
              isInitialParameter(
                )) {
            return false;
        }
        if ((getMethod(
               ).
               getAccessFlags(
                 ) &
               ACC_VARARGS) ==
              0) {
            return true;
        }
        if (top.
              getRegisterNumber(
                ) ==
              parameterCount -
              1) {
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
       "87/1K6TqiiUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "YnEZ66mb7kjv7/Wqv/7mI/c/+abwb8sr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("fMd3bx9gK/cbqeOcvhNz6vlqEOmGVXLqgf0NmaCk6IWk8vTFtyqTytX9QwH5" +
       "0vP7Ji8llcdv0SQB4x8+nq79QeCYT2onlcvqmc/VpHLf4eekcg/IT388AEXg" +
       "Y/EIBUeS/PCt4JYmf0qcZInaj7JLZyOlY5N+7E7yORVcvXgmJCrPiI/Cl3R/" +
       "x/1V9a03B6Mf+07zi/v7icD57HZFL/ezlfv2VyWPQ6DnL+ztqK+r9Mvfe/g3" +
       "HnjpKFx7eA/4xA5OYXv21pcBu26QlNf3dv/iyd/86D9580/L88P/B456h856" +
       "MAAA");
}
