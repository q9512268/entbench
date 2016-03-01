package edu.umd.cs.findbugs.detect;
public class OverridingEqualsNotSymmetrical extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector implements edu.umd.cs.findbugs.FirstPassDetector {
    private static final java.lang.String EQUALS_NAME = "equals";
    private static final java.lang.String EQUALS_SIGNATURE = "(Ljava/lang/Object;)Z";
    private static final java.lang.String STATIC_EQUALS_SIGNATURE = "(Ljava/lang/Object;Ljava/lang/Object;)Z";
    java.util.Map<edu.umd.cs.findbugs.classfile.ClassDescriptor,java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor>>
      classesWithGetClassBasedEquals =
      new java.util.HashMap<edu.umd.cs.findbugs.classfile.ClassDescriptor,java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor>>(
      );
    java.util.Map<edu.umd.cs.findbugs.classfile.ClassDescriptor,java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor>>
      classesWithInstanceOfBasedEquals =
      new java.util.HashMap<edu.umd.cs.findbugs.classfile.ClassDescriptor,java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor>>(
      );
    java.util.Map<edu.umd.cs.findbugs.ClassAnnotation,edu.umd.cs.findbugs.ClassAnnotation>
      parentMap =
      new java.util.TreeMap<edu.umd.cs.findbugs.ClassAnnotation,edu.umd.cs.findbugs.ClassAnnotation>(
      );
    java.util.Map<edu.umd.cs.findbugs.ClassAnnotation,edu.umd.cs.findbugs.classfile.MethodDescriptor>
      equalsMethod =
      new java.util.TreeMap<edu.umd.cs.findbugs.ClassAnnotation,edu.umd.cs.findbugs.classfile.MethodDescriptor>(
      );
    final edu.umd.cs.findbugs.BugReporter
      bugReporter;
    final edu.umd.cs.findbugs.BugAccumulator
      bugAccumulator;
    final edu.umd.cs.findbugs.ba.EqualsKindSummary
      equalsKindSummary;
    public OverridingEqualsNotSymmetrical(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
        equalsKindSummary =
          edu.umd.cs.findbugs.ba.AnalysisContext.
            currentAnalysisContext(
              ).
            getEqualsKindSummary(
              );
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        if (EQUALS_NAME.
              equals(
                getMethodName(
                  )) &&
              !getMethod(
                 ).
              isStatic(
                ) &&
              getMethod(
                ).
              isPublic(
                ) &&
              EQUALS_SIGNATURE.
              equals(
                getMethodSig(
                  ))) {
            sawCheckedCast =
              (sawSuperEquals =
                 (sawInstanceOf =
                    (sawGetClass =
                       (sawReturnSuper =
                          (sawCompare =
                             (sawReturnNonSuper =
                                (prevWasSuperEquals =
                                   (sawGoodEqualsClass =
                                      (sawBadEqualsClass =
                                         (dangerDanger =
                                            (sawInstanceOfSupertype =
                                               (alwaysTrue =
                                                  (alwaysFalse =
                                                     (sawStaticDelegate =
                                                        (sawEqualsBuilder =
                                                           false)))))))))))))));
            sawInitialIdentityCheck =
              obj.
                getCode(
                  ).
                length ==
                11 ||
                obj.
                  getCode(
                    ).
                  length ==
                9;
            equalsCalls =
              0;
            super.
              visit(
                obj);
            edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals kind =
              edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                UNKNOWN;
            if (alwaysTrue) {
                kind =
                  edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                    ALWAYS_TRUE;
            }
            else
                if (alwaysFalse) {
                    kind =
                      edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                        ALWAYS_FALSE;
                }
                else
                    if (sawReturnSuper &&
                          !sawReturnNonSuper) {
                        kind =
                          edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                            RETURNS_SUPER;
                    }
                    else
                        if (sawSuperEquals) {
                            kind =
                              edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                                INVOKES_SUPER;
                        }
                        else
                            if (sawInstanceOfSupertype) {
                                kind =
                                  edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                                    INSTANCE_OF_SUPERCLASS_EQUALS;
                            }
                            else
                                if (sawInstanceOf) {
                                    kind =
                                      getThisClass(
                                        ).
                                        isAbstract(
                                          )
                                        ? edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                                            ABSTRACT_INSTANCE_OF
                                        : edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                                            INSTANCE_OF_EQUALS;
                                }
                                else
                                    if (sawGetClass &&
                                          sawGoodEqualsClass) {
                                        kind =
                                          getThisClass(
                                            ).
                                            isAbstract(
                                              )
                                            ? edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                                                ABSTRACT_GETCLASS_GOOD_EQUALS
                                            : edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                                                GETCLASS_GOOD_EQUALS;
                                    }
                                    else
                                        if (sawGetClass &&
                                              sawBadEqualsClass) {
                                            kind =
                                              edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                                                GETCLASS_BAD_EQUALS;
                                        }
                                        else
                                            if (equalsCalls ==
                                                  1 ||
                                                  sawStaticDelegate ||
                                                  sawEqualsBuilder) {
                                                kind =
                                                  edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                                                    DELEGATE_EQUALS;
                                            }
                                            else
                                                if (sawInitialIdentityCheck) {
                                                    kind =
                                                      edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                                                        TRIVIAL_EQUALS;
                                                }
                                                else
                                                    if (sawCheckedCast) {
                                                        kind =
                                                          edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                                                            CHECKED_CAST_EQUALS;
                                                    }
                                                    else
                                                        if (sawCompare) {
                                                            kind =
                                                              edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                                                                COMPARE_EQUALS;
                                                        }
                                                        else {
                                                            if (edu.umd.cs.findbugs.ba.AnalysisContext.
                                                                  currentAnalysisContext(
                                                                    ).
                                                                  isApplicationClass(
                                                                    getThisClass(
                                                                      ))) {
                                                                bugReporter.
                                                                  reportBug(
                                                                    new edu.umd.cs.findbugs.BugInstance(
                                                                      this,
                                                                      "EQ_UNUSUAL",
                                                                      edu.umd.cs.findbugs.Priorities.
                                                                        NORMAL_PRIORITY).
                                                                      addClassAndMethod(
                                                                        this));
                                                            }
                                                        }
            edu.umd.cs.findbugs.ClassAnnotation classAnnotation =
              new edu.umd.cs.findbugs.ClassAnnotation(
              getDottedClassName(
                ));
            equalsKindSummary.
              put(
                classAnnotation,
                kind);
            count(
              kind);
            if (kind ==
                  edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                    GETCLASS_GOOD_EQUALS ||
                  kind ==
                  edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                    ABSTRACT_GETCLASS_GOOD_EQUALS ||
                  kind ==
                  edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                    GETCLASS_BAD_EQUALS) {
                edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor =
                  getClassDescriptor(
                    );
                try {
                    java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor> subtypes =
                      edu.umd.cs.findbugs.ba.AnalysisContext.
                      currentAnalysisContext(
                        ).
                      getSubtypes2(
                        ).
                      getSubtypes(
                        classDescriptor);
                    if (subtypes.
                          size(
                            ) >
                          1) {
                        classesWithGetClassBasedEquals.
                          put(
                            classDescriptor,
                            subtypes);
                    }
                }
                catch (java.lang.ClassNotFoundException e) {
                    assert true;
                }
            }
            if (kind ==
                  edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                    INSTANCE_OF_EQUALS ||
                  kind ==
                  edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                    ABSTRACT_INSTANCE_OF) {
                edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor =
                  getClassDescriptor(
                    );
                try {
                    java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor> subtypes =
                      edu.umd.cs.findbugs.ba.AnalysisContext.
                      currentAnalysisContext(
                        ).
                      getSubtypes2(
                        ).
                      getSubtypes(
                        classDescriptor);
                    if (subtypes.
                          size(
                            ) >
                          1) {
                        classesWithInstanceOfBasedEquals.
                          put(
                            classDescriptor,
                            subtypes);
                    }
                }
                catch (java.lang.ClassNotFoundException e) {
                    assert true;
                }
            }
            java.lang.String superClassName =
              getSuperclassName(
                ).
              replace(
                '/',
                '.');
            if (!"java.lang.Object".
                  equals(
                    superClassName)) {
                parentMap.
                  put(
                    classAnnotation,
                    new edu.umd.cs.findbugs.ClassAnnotation(
                      superClassName));
            }
            equalsMethod.
              put(
                classAnnotation,
                getMethodDescriptor(
                  ));
        }
        bugAccumulator.
          reportAccumulatedBugs(
            );
    }
    boolean sawInstanceOf;
    boolean sawInstanceOfSupertype;
    boolean sawCheckedCast;
    boolean sawGetClass;
    boolean sawReturnSuper;
    boolean sawSuperEquals;
    boolean sawReturnNonSuper;
    boolean prevWasSuperEquals;
    boolean sawInitialIdentityCheck;
    boolean alwaysTrue;
    boolean alwaysFalse;
    int equalsCalls;
    boolean sawGoodEqualsClass;
    boolean sawBadEqualsClass;
    boolean sawCompare;
    boolean dangerDanger = false;
    boolean sawStaticDelegate;
    boolean sawEqualsBuilder;
    private final java.util.EnumMap<edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals,java.lang.Integer>
      count =
      new java.util.EnumMap<edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals,java.lang.Integer>(
      edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.class);
    private void count(edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals k) {
        java.lang.Integer v =
          count.
          get(
            k);
        if (v ==
              null) {
            count.
              put(
                k,
                1);
        }
        else {
            count.
              put(
                k,
                v +
                  1);
        }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (getPC(
                                            ) ==
                                            2 &&
                                            seen !=
                                            IF_ACMPEQ &&
                                            seen !=
                                            IF_ACMPNE) {
                                          sawInitialIdentityCheck =
                                            false;
                                      }
                                      if (getPC(
                                            ) ==
                                            2 &&
                                            seen ==
                                            INVOKESTATIC &&
                                            getCode(
                                              ).
                                              getCode(
                                                ).
                                              length ==
                                            6 &&
                                            (getPrevOpcode(
                                               1) ==
                                               ALOAD_0 &&
                                               getPrevOpcode(
                                                 2) ==
                                               ALOAD_1 ||
                                               getPrevOpcode(
                                                 1) ==
                                               ALOAD_1 &&
                                               getPrevOpcode(
                                                 2) ==
                                               ALOAD_0)) {
                                          sawStaticDelegate =
                                            true;
                                      }
                                      if ((seen ==
                                             INVOKESTATIC ||
                                             seen ==
                                             INVOKESPECIAL ||
                                             seen ==
                                             INVOKEVIRTUAL) &&
                                            ("org/apache/commons/lang/builder/EqualsBuilder".
                                               equals(
                                                 getClassConstantOperand(
                                                   )) ||
                                               "org/apache/commons/lang3/builder/EqualsBuilder".
                                               equals(
                                                 getClassConstantOperand(
                                                   )))) {
                                          sawEqualsBuilder =
                                            true;
                                      }
                                      if (seen ==
                                            IRETURN &&
                                            getPC(
                                              ) ==
                                            1 &&
                                            getPrevOpcode(
                                              1) ==
                                            ICONST_0) {
                                          alwaysFalse =
                                            true;
                                          if (edu.umd.cs.findbugs.ba.AnalysisContext.
                                                currentAnalysisContext(
                                                  ).
                                                isApplicationClass(
                                                  getThisClass(
                                                    ))) {
                                              bugReporter.
                                                reportBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "EQ_ALWAYS_FALSE",
                                                    edu.umd.cs.findbugs.Priorities.
                                                      HIGH_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addSourceLine(
                                                      this));
                                          }
                                      }
                                      if (seen ==
                                            IRETURN &&
                                            getPC(
                                              ) ==
                                            1 &&
                                            getPrevOpcode(
                                              1) ==
                                            ICONST_1) {
                                          alwaysTrue =
                                            true;
                                          if (edu.umd.cs.findbugs.ba.AnalysisContext.
                                                currentAnalysisContext(
                                                  ).
                                                isApplicationClass(
                                                  getThisClass(
                                                    ))) {
                                              bugReporter.
                                                reportBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "EQ_ALWAYS_TRUE",
                                                    edu.umd.cs.findbugs.Priorities.
                                                      HIGH_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addSourceLine(
                                                      this));
                                          }
                                      }
                                      if (seen ==
                                            IF_ACMPEQ ||
                                            seen ==
                                            IF_ACMPNE) {
                                          checkForComparingClasses(
                                            );
                                      }
                                      if (callToInvoke(
                                            seen)) {
                                          equalsCalls++;
                                          checkForComparingClasses(
                                            );
                                          if (edu.umd.cs.findbugs.ba.AnalysisContext.
                                                currentAnalysisContext(
                                                  ).
                                                isApplicationClass(
                                                  getThisClass(
                                                    )) &&
                                                dangerDanger) {
                                              bugReporter.
                                                reportBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "EQ_COMPARING_CLASS_NAMES",
                                                    edu.umd.cs.findbugs.Priorities.
                                                      NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addSourceLine(
                                                      this));
                                          }
                                      }
                                      if ((seen ==
                                             INVOKEINTERFACE ||
                                             seen ==
                                             INVOKEVIRTUAL) &&
                                            "compare".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            stack.
                                            getStackDepth(
                                              ) >=
                                            2) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item left =
                                            stack.
                                            getStackItem(
                                              1);
                                          edu.umd.cs.findbugs.OpcodeStack.Item right =
                                            stack.
                                            getStackItem(
                                              0);
                                          if (left.
                                                getRegisterNumber(
                                                  ) +
                                                right.
                                                getRegisterNumber(
                                                  ) ==
                                                1) {
                                              sawCompare =
                                                true;
                                          }
                                      }
                                      dangerDanger =
                                        false;
                                      if (seen ==
                                            INVOKEVIRTUAL &&
                                            "java/lang/Class".
                                            equals(
                                              getClassConstantOperand(
                                                )) &&
                                            "getName".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            "()Ljava/lang/String;".
                                            equals(
                                              getSigConstantOperand(
                                                )) &&
                                            stack.
                                            getStackDepth(
                                              ) >=
                                            2) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item left =
                                            stack.
                                            getStackItem(
                                              1);
                                          edu.umd.cs.findbugs.ba.XMethod leftM =
                                            left.
                                            getReturnValueOf(
                                              );
                                          edu.umd.cs.findbugs.OpcodeStack.Item right =
                                            stack.
                                            getStackItem(
                                              0);
                                          edu.umd.cs.findbugs.ba.XMethod rightM =
                                            right.
                                            getReturnValueOf(
                                              );
                                          if (leftM !=
                                                null &&
                                                rightM !=
                                                null &&
                                                "getName".
                                                equals(
                                                  leftM.
                                                    getName(
                                                      )) &&
                                                "getClass".
                                                equals(
                                                  rightM.
                                                    getName(
                                                      ))) {
                                              dangerDanger =
                                                true;
                                          }
                                      }
                                      if (seen ==
                                            INVOKESPECIAL &&
                                            EQUALS_NAME.
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            EQUALS_SIGNATURE.
                                            equals(
                                              getSigConstantOperand(
                                                ))) {
                                          sawSuperEquals =
                                            (prevWasSuperEquals =
                                               true);
                                      }
                                      else {
                                          if (seen ==
                                                IRETURN) {
                                              if (prevWasSuperEquals) {
                                                  sawReturnSuper =
                                                    true;
                                              }
                                              else {
                                                  sawReturnNonSuper =
                                                    true;
                                              }
                                          }
                                          prevWasSuperEquals =
                                            false;
                                      }
                                      if (seen ==
                                            INSTANCEOF &&
                                            stack.
                                            getStackDepth(
                                              ) >
                                            0 &&
                                            stack.
                                            getStackItem(
                                              0).
                                            getRegisterNumber(
                                              ) ==
                                            1) {
                                          edu.umd.cs.findbugs.classfile.ClassDescriptor instanceOfCheck =
                                            getClassDescriptorOperand(
                                              );
                                          if (instanceOfCheck.
                                                equals(
                                                  getClassDescriptor(
                                                    ))) {
                                              sawInstanceOf =
                                                true;
                                          }
                                          else {
                                              try {
                                                  if (edu.umd.cs.findbugs.ba.AnalysisContext.
                                                        currentAnalysisContext(
                                                          ).
                                                        getSubtypes2(
                                                          ).
                                                        isSubtype(
                                                          getClassDescriptor(
                                                            ),
                                                          instanceOfCheck)) {
                                                      sawInstanceOfSupertype =
                                                        true;
                                                  }
                                              }
                                              catch (java.lang.ClassNotFoundException e) {
                                                  sawInstanceOfSupertype =
                                                    true;
                                              }
                                          }
                                      }
                                      if (seen ==
                                            CHECKCAST &&
                                            stack.
                                            getStackDepth(
                                              ) >
                                            0 &&
                                            stack.
                                            getStackItem(
                                              0).
                                            getRegisterNumber(
                                              ) ==
                                            1) {
                                          edu.umd.cs.findbugs.classfile.ClassDescriptor castTo =
                                            getClassDescriptorOperand(
                                              );
                                          if (castTo.
                                                equals(
                                                  getClassDescriptor(
                                                    ))) {
                                              sawCheckedCast =
                                                true;
                                          }
                                          try {
                                              if (edu.umd.cs.findbugs.ba.AnalysisContext.
                                                    currentAnalysisContext(
                                                      ).
                                                    getSubtypes2(
                                                      ).
                                                    isSubtype(
                                                      getClassDescriptor(
                                                        ),
                                                      castTo)) {
                                                  sawCheckedCast =
                                                    true;
                                              }
                                          }
                                          catch (java.lang.ClassNotFoundException e) {
                                              sawCheckedCast =
                                                true;
                                          }
                                      }
                                      if (seen ==
                                            INVOKEVIRTUAL &&
                                            "getClass".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            "()Ljava/lang/Class;".
                                            equals(
                                              getSigConstantOperand(
                                                ))) {
                                          sawGetClass =
                                            true;
                                      } }
    private boolean callToInvoke(int seen) {
        if (seen ==
              INVOKEVIRTUAL ||
              seen ==
              INVOKEINTERFACE ||
              seen ==
              INVOKESPECIAL) {
            return invokesMethodWithEqualLikeName(
                     ) &&
              EQUALS_SIGNATURE.
              equals(
                getSigConstantOperand(
                  ));
        }
        if (seen ==
              INVOKESTATIC) {
            java.lang.String sig =
              getSigConstantOperand(
                );
            return invokesMethodWithEqualLikeName(
                     ) &&
              sig.
              endsWith(
                "Ljava/lang/Object;)Z");
        }
        return false;
    }
    public boolean invokesMethodWithEqualLikeName() {
        return getNameConstantOperand(
                 ).
          toLowerCase(
            ).
          indexOf(
            EQUALS_NAME) >=
          0;
    }
    private void checkForComparingClasses() {
        if (stack.
              getStackDepth(
                ) >=
              2) {
            edu.umd.cs.findbugs.OpcodeStack.Item left =
              stack.
              getStackItem(
                1);
            edu.umd.cs.findbugs.ba.XMethod leftM =
              left.
              getReturnValueOf(
                );
            edu.umd.cs.findbugs.OpcodeStack.Item right =
              stack.
              getStackItem(
                0);
            edu.umd.cs.findbugs.ba.XMethod rightM =
              right.
              getReturnValueOf(
                );
            if ("Ljava/lang/Class;".
                  equals(
                    left.
                      getSignature(
                        )) &&
                  "Ljava/lang/Class;".
                  equals(
                    right.
                      getSignature(
                        ))) {
                boolean leftMatch =
                  leftM !=
                  null &&
                  "getClass".
                  equals(
                    leftM.
                      getName(
                        ));
                boolean rightMatch =
                  rightM !=
                  null &&
                  "getClass".
                  equals(
                    rightM.
                      getName(
                        ));
                if (leftMatch &&
                      rightMatch) {
                    sawGoodEqualsClass =
                      true;
                }
                else {
                    if (getClassName(
                          ).
                          equals(
                            left.
                              getConstant(
                                )) &&
                          rightMatch ||
                          leftMatch &&
                          getClassName(
                            ).
                          equals(
                            right.
                              getConstant(
                                ))) {
                        if (getThisClass(
                              ).
                              isFinal(
                                )) {
                            sawGoodEqualsClass =
                              true;
                        }
                        else {
                            sawBadEqualsClass =
                              true;
                            if (edu.umd.cs.findbugs.ba.AnalysisContext.
                                  currentAnalysisContext(
                                    ).
                                  isApplicationClass(
                                    getThisClass(
                                      ))) {
                                int priority =
                                  edu.umd.cs.findbugs.Priorities.
                                    NORMAL_PRIORITY;
                                edu.umd.cs.findbugs.BugInstance bug =
                                  new edu.umd.cs.findbugs.BugInstance(
                                  this,
                                  "EQ_GETCLASS_AND_CLASS_CONSTANT",
                                  priority).
                                  addClassAndMethod(
                                    this);
                                try {
                                    edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
                                      edu.umd.cs.findbugs.ba.AnalysisContext.
                                      currentAnalysisContext(
                                        ).
                                      getSubtypes2(
                                        );
                                    java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor> subtypes =
                                      subtypes2.
                                      getDirectSubtypes(
                                        getClassDescriptor(
                                          ));
                                    for (edu.umd.cs.findbugs.classfile.ClassDescriptor c
                                          :
                                          subtypes) {
                                        try {
                                            edu.umd.cs.findbugs.classfile.Global.
                                              getAnalysisCache(
                                                ).
                                              getClassAnalysis(
                                                edu.umd.cs.findbugs.ba.XClass.class,
                                                c);
                                        }
                                        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                                            continue;
                                        }
                                        edu.umd.cs.findbugs.ba.XMethod m =
                                          edu.umd.cs.findbugs.ba.Hierarchy2.
                                          findMethod(
                                            c,
                                            "equals",
                                            "(Ljava/lang/Object;)Z",
                                            false);
                                        if (m ==
                                              null) {
                                            bug.
                                              addClass(
                                                c).
                                              describe(
                                                edu.umd.cs.findbugs.ClassAnnotation.
                                                  SUBCLASS_ROLE);
                                            priority--;
                                            bug.
                                              setPriority(
                                                priority);
                                        }
                                    }
                                }
                                catch (java.lang.ClassNotFoundException e) {
                                    bugReporter.
                                      reportMissingClass(
                                        e);
                                }
                                bugAccumulator.
                                  accumulateBug(
                                    bug,
                                    this);
                            }
                        }
                    }
                }
            }
        }
    }
    @java.lang.Override
    public void report() { if (false) { edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
                                          edu.umd.cs.findbugs.ba.AnalysisContext.
                                          currentAnalysisContext(
                                            ).
                                          getSubtypes2(
                                            );
                                        for (java.util.Map.Entry<edu.umd.cs.findbugs.classfile.ClassDescriptor,java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor>> e
                                              :
                                              classesWithGetClassBasedEquals.
                                               entrySet(
                                                 )) {
                                            edu.umd.cs.findbugs.ClassAnnotation parentClass =
                                              edu.umd.cs.findbugs.ClassAnnotation.
                                              fromClassDescriptor(
                                                e.
                                                  getKey(
                                                    ));
                                            edu.umd.cs.findbugs.ba.XClass xParent =
                                              edu.umd.cs.findbugs.ba.AnalysisContext.
                                              currentXFactory(
                                                ).
                                              getXClass(
                                                e.
                                                  getKey(
                                                    ));
                                            if (xParent ==
                                                  null) {
                                                continue;
                                            }
                                            edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals parentKind =
                                              equalsKindSummary.
                                              get(
                                                parentClass);
                                            for (edu.umd.cs.findbugs.classfile.ClassDescriptor child
                                                  :
                                                  e.
                                                   getValue(
                                                     )) {
                                                if (child.
                                                      equals(
                                                        e.
                                                          getKey(
                                                            ))) {
                                                    continue;
                                                }
                                                edu.umd.cs.findbugs.ba.XClass xChild =
                                                  edu.umd.cs.findbugs.ba.AnalysisContext.
                                                  currentXFactory(
                                                    ).
                                                  getXClass(
                                                    child);
                                                if (xChild ==
                                                      null) {
                                                    continue;
                                                }
                                                edu.umd.cs.findbugs.ClassAnnotation childClass =
                                                  edu.umd.cs.findbugs.ClassAnnotation.
                                                  fromClassDescriptor(
                                                    child);
                                                edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals childKind =
                                                  equalsKindSummary.
                                                  get(
                                                    childClass);
                                                int fieldsOfInterest =
                                                  0;
                                                for (edu.umd.cs.findbugs.ba.XField f
                                                      :
                                                      xChild.
                                                       getXFields(
                                                         )) {
                                                    if (!f.
                                                          isStatic(
                                                            ) &&
                                                          !f.
                                                          isSynthetic(
                                                            )) {
                                                        fieldsOfInterest++;
                                                    }
                                                }
                                                int grandchildren =
                                                  -1;
                                                try {
                                                    grandchildren =
                                                      subtypes2.
                                                        getSubtypes(
                                                          child).
                                                        size(
                                                          );
                                                }
                                                catch (java.lang.ClassNotFoundException e1) {
                                                    assert true;
                                                }
                                                java.lang.System.
                                                  out.
                                                  println(
                                                    parentKind +
                                                    " " +
                                                    childKind +
                                                    " " +
                                                    parentClass +
                                                    " " +
                                                    childClass +
                                                    " " +
                                                    fieldsOfInterest +
                                                    " " +
                                                    grandchildren);
                                                try {
                                                    if (grandchildren >=
                                                          2) {
                                                        for (edu.umd.cs.findbugs.classfile.ClassDescriptor g
                                                              :
                                                              subtypes2.
                                                               getSubtypes(
                                                                 child)) {
                                                            if (!g.
                                                                  equals(
                                                                    child)) {
                                                                java.lang.System.
                                                                  out.
                                                                  println(
                                                                    "  " +
                                                                    g);
                                                            }
                                                        }
                                                    }
                                                }
                                                catch (java.lang.ClassNotFoundException e1) {
                                                    assert true;
                                                }
                                            }
                                        }
                                        int overridden =
                                          0;
                                        int total =
                                          0;
                                        for (java.util.Map.Entry<edu.umd.cs.findbugs.classfile.ClassDescriptor,java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor>> e
                                              :
                                              classesWithInstanceOfBasedEquals.
                                               entrySet(
                                                 )) {
                                            edu.umd.cs.findbugs.ClassAnnotation parentClass =
                                              edu.umd.cs.findbugs.ClassAnnotation.
                                              fromClassDescriptor(
                                                e.
                                                  getKey(
                                                    ));
                                            edu.umd.cs.findbugs.ba.XClass xParent =
                                              edu.umd.cs.findbugs.ba.AnalysisContext.
                                              currentXFactory(
                                                ).
                                              getXClass(
                                                e.
                                                  getKey(
                                                    ));
                                            if (xParent ==
                                                  null) {
                                                continue;
                                            }
                                            edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals parentKind =
                                              equalsKindSummary.
                                              get(
                                                parentClass);
                                            boolean isOverridden =
                                              false;
                                            for (edu.umd.cs.findbugs.classfile.ClassDescriptor child
                                                  :
                                                  e.
                                                   getValue(
                                                     )) {
                                                if (child.
                                                      equals(
                                                        e.
                                                          getKey(
                                                            ))) {
                                                    continue;
                                                }
                                                edu.umd.cs.findbugs.ba.XClass xChild =
                                                  edu.umd.cs.findbugs.ba.AnalysisContext.
                                                  currentXFactory(
                                                    ).
                                                  getXClass(
                                                    child);
                                                if (xChild ==
                                                      null) {
                                                    continue;
                                                }
                                                edu.umd.cs.findbugs.ClassAnnotation childClass =
                                                  edu.umd.cs.findbugs.ClassAnnotation.
                                                  fromClassDescriptor(
                                                    child);
                                                edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals childKind =
                                                  equalsKindSummary.
                                                  get(
                                                    childClass);
                                                if (childKind !=
                                                      null) {
                                                    isOverridden =
                                                      true;
                                                }
                                            }
                                            total++;
                                            if (isOverridden) {
                                                overridden++;
                                            }
                                            java.lang.System.
                                              out.
                                              println(
                                                "IS_OVERRIDDEN: " +
                                                e.
                                                  getKey(
                                                    ).
                                                  getClassName(
                                                    ));
                                        }
                                        java.lang.System.
                                          out.
                                          println(
                                            "Instance of equals: " +
                                            total +
                                            " subclassed, " +
                                            overridden +
                                            " overrridden");
                                        for (java.util.Map.Entry<edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals,java.lang.Integer> e
                                              :
                                              count.
                                               entrySet(
                                                 )) {
                                            java.lang.System.
                                              out.
                                              println(
                                                e);
                                        }
                           }
                           for (java.util.Map.Entry<edu.umd.cs.findbugs.ClassAnnotation,edu.umd.cs.findbugs.ClassAnnotation> e
                                 :
                                 parentMap.
                                  entrySet(
                                    )) { edu.umd.cs.findbugs.ClassAnnotation childClass =
                                           e.
                                           getKey(
                                             );
                                         edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals childKind =
                                           equalsKindSummary.
                                           get(
                                             childClass);
                                         edu.umd.cs.findbugs.ClassAnnotation parentClass =
                                           e.
                                           getValue(
                                             );
                                         edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals parentKind =
                                           equalsKindSummary.
                                           get(
                                             parentClass);
                                         if (childKind ==
                                               edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                                                 INSTANCE_OF_EQUALS &&
                                               parentKind ==
                                               edu.umd.cs.findbugs.ba.EqualsKindSummary.KindOfEquals.
                                                 INSTANCE_OF_EQUALS) {
                                             bugReporter.
                                               reportBug(
                                                 new edu.umd.cs.findbugs.BugInstance(
                                                   this,
                                                   "EQ_OVERRIDING_EQUALS_NOT_SYMMETRIC",
                                                   NORMAL_PRIORITY).
                                                   add(
                                                     childClass).
                                                   addMethod(
                                                     equalsMethod.
                                                       get(
                                                         childClass)).
                                                   addMethod(
                                                     equalsMethod.
                                                       get(
                                                         parentClass)).
                                                   describe(
                                                     edu.umd.cs.findbugs.MethodAnnotation.
                                                       METHOD_OVERRIDDEN));
                                         }
                           } }
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
       "6TFwRFTVaDSkNJ7NW6zuLBo0iVb6UYi7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "B/bwCPpE0ue/DfumnaYUeSdXPg+ujT7j+Po1yZXklXptKavm6YsEjqIWp5E/" +
       "ddDEqVujVz6cR+8LS3cV13bOPfPaOoZyctr4E2cV8sFjhTyG9PipSxy7O+bq" +
       "TXT4xvucecKVHz9m5IN5YgOET+4Z+cnbZWTnZozMO0sLVvziTdj0b/PoE0dv" +
       "AeQ/PnrCkn9z2QngTagr1OT1IPzWnrrf+rKqSd7ZGwsKPnUT6n49j34FjNVA" +
       "ikeuDPTmgMJPXij0PPfjX4p485e7Ss+Clvavvl+54dX3L1m8Owb87k0Y8Jk8" +
       "+nRYelCWTJN3KHvrbHYvx5zw4Le/BCk/kSdWAJzJnsjJl0fKp2n4o5vk/XEe" +
       "/T6wFkZB2f5GR34Vp3jBgDY26nBv2U5R/NkvgeJi1EIA/GJP8eLLI9bTVP3v" +
       "m+R9Po8+F5aekvOXNTuOv3tB7OiOXmGRTmv4pW8vXzaGnwKw372n9d1ffun+" +
       "zU3y/i6P/iIs3e0Xt1EOKPvLL+PYTYAK3fy7IflHEJ664XNGu0/wyB957yP3" +
       "Pvne6X8pPp1x/Jmc++jSvVpkmqfvop96vtv1VW135ei+3c304g2eq3eGpacv" +
       "/rwJ4MbuIafh6h27KveEpSfOqRKC/vePp0vfH5buPykdlq7KZ7IfCkv37LPD" +
       "0h0gPp35KEgCmfnjY+7RxPiWc1/+ySftndHlQsCoY2frypl3fk48wscv09Tj" +
       "Kqe/y3F4wZaJdp+jui5/9L394Td/of4Tu++CAPchK+4U3kuX7tl9ouTYp3ru" +
       "wtaO2rq79+LfPvyx+95w5P89vAN8ov6nsL3u/I9wtC03LD6bkX3iyY9//U++" +
       "97PFKz7/D5hPzMolTAAA");
}
