package edu.umd.cs.findbugs.detect;
public class FindPuzzlers extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    static edu.umd.cs.findbugs.classfile.FieldDescriptor SYSTEM_OUT = new edu.umd.cs.findbugs.classfile.FieldDescriptor(
      "java/lang/System",
      "out",
      "Ljava/io/PrintStream;",
      true);
    static edu.umd.cs.findbugs.classfile.FieldDescriptor SYSTEM_ERR =
      new edu.umd.cs.findbugs.classfile.FieldDescriptor(
      "java/lang/System",
      "err",
      "Ljava/io/PrintStream;",
      true);
    final edu.umd.cs.findbugs.BugReporter bugReporter;
    final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    private final boolean testingEnabled;
    public FindPuzzlers(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
        testingEnabled =
          edu.umd.cs.findbugs.SystemProperties.
            getBoolean(
              "report_TESTING_pattern_in_standard_detectors");
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { prevOpcodeIncrementedRegister =
                                                              -1;
                                                            best_priority_for_ICAST_INTEGER_MULTIPLY_CAST_TO_LONG =
                                                              LOW_PRIORITY +
                                                                1;
                                                            prevOpCode =
                                                              NOP;
                                                            previousMethodInvocation =
                                                              null;
                                                            badlyComputingOddState =
                                                              0;
                                                            resetIMulCastLong(
                                                              );
                                                            imul_distance =
                                                              10000;
                                                            ternaryConversionState =
                                                              0;
                                                            becameTop =
                                                              -1;
                                                            super.
                                                              visit(
                                                                obj);
                                                            bugAccumulator.
                                                              reportAccumulatedBugs(
                                                                );
                                                            pendingUnreachableBranch =
                                                              null;
    }
    int becameTop;
    int imul_constant;
    int imul_distance;
    boolean imul_operand_is_parameter;
    int prevOpcodeIncrementedRegister;
    int valueOfConstantArgumentToShift;
    int best_priority_for_ICAST_INTEGER_MULTIPLY_CAST_TO_LONG;
    boolean constantArgumentToShift;
    boolean shiftOfNonnegativeValue;
    int ternaryConversionState = 0;
    int badlyComputingOddState;
    int prevOpCode;
    edu.umd.cs.findbugs.ba.XMethod previousMethodInvocation;
    boolean isTigerOrHigher;
    static edu.umd.cs.findbugs.classfile.ClassDescriptor
      ITERATOR =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.util.Iterator.class);
    static edu.umd.cs.findbugs.classfile.ClassDescriptor
      MAP_ENTRY =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.util.Map.Entry.class);
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) {
        isTigerOrHigher =
          obj.
            getMajor(
              ) >=
            MAJOR_1_5;
        try {
            edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
              edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getSubtypes2(
                );
            edu.umd.cs.findbugs.classfile.ClassDescriptor me =
              getClassDescriptor(
                );
            if (subtypes2.
                  isSubtype(
                    me,
                    MAP_ENTRY) &&
                  subtypes2.
                  isSubtype(
                    me,
                    ITERATOR)) {
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "PZ_DONT_REUSE_ENTRY_OBJECTS_IN_ITERATORS",
                      NORMAL_PRIORITY).
                      addClass(
                        this).
                      addString(
                        "shouldn\'t reuse Iterator as a Map.Entry"));
            }
        }
        catch (java.lang.ClassNotFoundException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              reportMissingClass(
                e);
        }
    }
    private void resetIMulCastLong() { imul_constant =
                                         1;
                                       imul_operand_is_parameter =
                                         false;
    }
    private int adjustPriority(int factor,
                               int priority) {
        if (factor <=
              4) {
            return LOW_PRIORITY +
              2;
        }
        if (factor <=
              10000) {
            return priority +
              1;
        }
        if (factor <=
              60 *
              60 *
              1000) {
            return priority;
        }
        return priority -
          1;
    }
    private int adjustMultiplier(java.lang.Object constant,
                                 int mul) {
        if (!(constant instanceof java.lang.Integer)) {
            return mul;
        }
        return java.lang.Math.
          abs(
            ((java.lang.Integer)
               constant).
              intValue(
                )) *
          mul;
    }
    @java.lang.Override
    public boolean beforeOpcode(int seen) {
        super.
          beforeOpcode(
            seen);
        return true;
    }
    edu.umd.cs.findbugs.BugInstance pendingUnreachableBranch;
    @java.lang.Override
    public void sawOpcode(int seen) { if (stack.
                                            isTop(
                                              )) {
                                          pendingUnreachableBranch =
                                            null;
                                          if (becameTop ==
                                                -1) {
                                              becameTop =
                                                getPC(
                                                  );
                                          }
                                          if (testingEnabled &&
                                                seen ==
                                                GOTO &&
                                                getBranchTarget(
                                                  ) <
                                                becameTop) {
                                              pendingUnreachableBranch =
                                                new edu.umd.cs.findbugs.BugInstance(
                                                  this,
                                                  "TESTING",
                                                  NORMAL_PRIORITY).
                                                  addClassAndMethod(
                                                    this).
                                                  addString(
                                                    "Unreachable loop body").
                                                  addSourceLineRange(
                                                    this,
                                                    becameTop,
                                                    getPC(
                                                      ));
                                          }
                                          return;
                                      }
                                      if (pendingUnreachableBranch !=
                                            null) {
                                          bugReporter.
                                            reportBug(
                                              pendingUnreachableBranch);
                                          pendingUnreachableBranch =
                                            null;
                                      }
                                      becameTop =
                                        -1;
                                      if (seen ==
                                            INVOKESPECIAL &&
                                            "<init>".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            "(Ljava/util/Collection;)V".
                                            equals(
                                              getSigConstantOperand(
                                                )) &&
                                            getClassConstantOperand(
                                              ).
                                            contains(
                                              "Set") ||
                                            (seen ==
                                               INVOKEVIRTUAL ||
                                               seen ==
                                               INVOKEINTERFACE) &&
                                            "addAll".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            "(Ljava/util/Collection;)Z".
                                            equals(
                                              getSigConstantOperand(
                                                ))) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item top =
                                            stack.
                                            getStackItem(
                                              0);
                                          edu.umd.cs.findbugs.ba.XMethod returnValueOf =
                                            top.
                                            getReturnValueOf(
                                              );
                                          if (returnValueOf !=
                                                null &&
                                                "entrySet".
                                                equals(
                                                  returnValueOf.
                                                    getName(
                                                      ))) {
                                              java.lang.String name =
                                                returnValueOf.
                                                getClassName(
                                                  );
                                              int priority =
                                                edu.umd.cs.findbugs.Priorities.
                                                  LOW_PRIORITY;
                                              if ("java.util.Map".
                                                    equals(
                                                      name)) {
                                                  priority =
                                                    edu.umd.cs.findbugs.Priorities.
                                                      NORMAL_PRIORITY;
                                              }
                                              else
                                                  if (name.
                                                        equals(
                                                          java.util.EnumMap.class.
                                                            getName(
                                                              )) ||
                                                        name.
                                                        equals(
                                                          java.util.IdentityHashMap.class.
                                                            getName(
                                                              ))) {
                                                      priority =
                                                        edu.umd.cs.findbugs.Priorities.
                                                          HIGH_PRIORITY;
                                                  }
                                              bugReporter.
                                                reportBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "DMI_ENTRY_SETS_MAY_REUSE_ENTRY_OBJECTS",
                                                    priority).
                                                    addClassAndMethod(
                                                      this).
                                                    addCalledMethod(
                                                      returnValueOf).
                                                    addCalledMethod(
                                                      this).
                                                    addValueSource(
                                                      top,
                                                      this).
                                                    addSourceLine(
                                                      this));
                                          }
                                      }
                                      if (seen ==
                                            INVOKEVIRTUAL &&
                                            "hashCode".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            "()I".
                                            equals(
                                              getSigConstantOperand(
                                                )) &&
                                            stack.
                                            getStackDepth(
                                              ) >
                                            0) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item item0 =
                                            stack.
                                            getStackItem(
                                              0);
                                          if (item0.
                                                getSignature(
                                                  ).
                                                charAt(
                                                  0) ==
                                                '[') {
                                              bugReporter.
                                                reportBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "DMI_INVOKING_HASHCODE_ON_ARRAY",
                                                    NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addValueSource(
                                                      item0,
                                                      this).
                                                    addSourceLine(
                                                      this));
                                          }
                                      }
                                      if (seen !=
                                            RETURN &&
                                            isReturn(
                                              seen) &&
                                            isRegisterStore(
                                              getPrevOpcode(
                                                1))) {
                                          int priority =
                                            edu.umd.cs.findbugs.Priorities.
                                              NORMAL_PRIORITY;
                                          if (getMethodSig(
                                                ).
                                                endsWith(
                                                  ")Z")) {
                                              priority =
                                                edu.umd.cs.findbugs.Priorities.
                                                  HIGH_PRIORITY;
                                          }
                                          else {
                                              if (getMethodSig(
                                                    ).
                                                    endsWith(
                                                      ")Ljava/lang/String;")) {
                                                  priority =
                                                    edu.umd.cs.findbugs.Priorities.
                                                      LOW_PRIORITY;
                                              }
                                              if (getPC(
                                                    ) ==
                                                    getCode(
                                                      ).
                                                      getCode(
                                                        ).
                                                      length -
                                                    1) {
                                                  priority++;
                                              }
                                          }
                                          bugReporter.
                                            reportBug(
                                              new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                "DLS_DEAD_LOCAL_STORE_IN_RETURN",
                                                priority).
                                                addClassAndMethod(
                                                  this).
                                                addSourceLine(
                                                  this));
                                      }
                                      if (seen ==
                                            IMUL) {
                                          if (imul_distance !=
                                                1) {
                                              resetIMulCastLong(
                                                );
                                          }
                                          imul_distance =
                                            0;
                                          if (stack.
                                                getStackDepth(
                                                  ) >
                                                1) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item item0 =
                                                stack.
                                                getStackItem(
                                                  0);
                                              edu.umd.cs.findbugs.OpcodeStack.Item item1 =
                                                stack.
                                                getStackItem(
                                                  1);
                                              imul_constant =
                                                adjustMultiplier(
                                                  item0.
                                                    getConstant(
                                                      ),
                                                  imul_constant);
                                              imul_constant =
                                                adjustMultiplier(
                                                  item1.
                                                    getConstant(
                                                      ),
                                                  imul_constant);
                                              if (item0.
                                                    isInitialParameter(
                                                      ) ||
                                                    item1.
                                                    isInitialParameter(
                                                      )) {
                                                  imul_operand_is_parameter =
                                                    true;
                                              }
                                          }
                                      }
                                      else {
                                          imul_distance++;
                                      }
                                      if (prevOpCode ==
                                            IMUL &&
                                            seen ==
                                            I2L) {
                                          int priority =
                                            adjustPriority(
                                              imul_constant,
                                              NORMAL_PRIORITY);
                                          if (priority >=
                                                LOW_PRIORITY &&
                                                imul_constant !=
                                                1000 &&
                                                imul_constant !=
                                                60 &&
                                                imul_operand_is_parameter) {
                                              priority =
                                                NORMAL_PRIORITY;
                                          }
                                          if (priority <=
                                                best_priority_for_ICAST_INTEGER_MULTIPLY_CAST_TO_LONG) {
                                              best_priority_for_ICAST_INTEGER_MULTIPLY_CAST_TO_LONG =
                                                priority;
                                              bugAccumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "ICAST_INTEGER_MULTIPLY_CAST_TO_LONG",
                                                    priority).
                                                    addClassAndMethod(
                                                      this),
                                                  this);
                                          }
                                      }
                                      if ("<clinit>".
                                            equals(
                                              getMethodName(
                                                )) &&
                                            (seen ==
                                               PUTSTATIC ||
                                               seen ==
                                               GETSTATIC ||
                                               seen ==
                                               INVOKESTATIC)) {
                                          java.lang.String clazz =
                                            getClassConstantOperand(
                                              );
                                          if (!clazz.
                                                equals(
                                                  getClassName(
                                                    ))) {
                                              try {
                                                  org.apache.bcel.classfile.JavaClass targetClass =
                                                    org.apache.bcel.Repository.
                                                    lookupClass(
                                                      clazz);
                                                  if (org.apache.bcel.Repository.
                                                        instanceOf(
                                                          targetClass,
                                                          getThisClass(
                                                            ))) {
                                                      int priority =
                                                        NORMAL_PRIORITY;
                                                      if (seen ==
                                                            GETSTATIC) {
                                                          priority--;
                                                      }
                                                      if (!targetClass.
                                                            isPublic(
                                                              )) {
                                                          priority++;
                                                      }
                                                      bugAccumulator.
                                                        accumulateBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION",
                                                            priority).
                                                            addClassAndMethod(
                                                              this).
                                                            addClass(
                                                              getClassConstantOperand(
                                                                )),
                                                          this);
                                                  }
                                              }
                                              catch (java.lang.ClassNotFoundException e) {
                                                  
                                              }
                                          }
                                      }
                                      if (seen >=
                                            IALOAD &&
                                            seen <=
                                            SALOAD ||
                                            seen >=
                                            IASTORE &&
                                            seen <=
                                            SASTORE) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item index =
                                            stack.
                                            getStackItem(
                                              0);
                                          if (index.
                                                getSpecialKind(
                                                  ) ==
                                                edu.umd.cs.findbugs.OpcodeStack.Item.
                                                  AVERAGE_COMPUTED_USING_DIVISION) {
                                              edu.umd.cs.findbugs.SourceLineAnnotation where;
                                              if (index.
                                                    getPC(
                                                      ) >=
                                                    0) {
                                                  where =
                                                    edu.umd.cs.findbugs.SourceLineAnnotation.
                                                      fromVisitedInstruction(
                                                        this,
                                                        index.
                                                          getPC(
                                                            ));
                                              }
                                              else {
                                                  where =
                                                    edu.umd.cs.findbugs.SourceLineAnnotation.
                                                      fromVisitedInstruction(
                                                        this);
                                              }
                                              bugAccumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "IM_AVERAGE_COMPUTATION_COULD_OVERFLOW",
                                                    NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this),
                                                  where);
                                          }
                                      }
                                      if ((seen ==
                                             IFEQ ||
                                             seen ==
                                             IFNE) &&
                                            getPrevOpcode(
                                              1) ==
                                            IMUL &&
                                            (getPrevOpcode(
                                               2) ==
                                               SIPUSH ||
                                               getPrevOpcode(
                                                 2) ==
                                               BIPUSH) &&
                                            getPrevOpcode(
                                              3) ==
                                            IREM) {
                                          bugAccumulator.
                                            accumulateBug(
                                              new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                "IM_MULTIPLYING_RESULT_OF_IREM",
                                                LOW_PRIORITY).
                                                addClassAndMethod(
                                                  this),
                                              this);
                                      }
                                      if (seen ==
                                            I2S &&
                                            getPrevOpcode(
                                              1) ==
                                            IUSHR &&
                                            !shiftOfNonnegativeValue &&
                                            (!constantArgumentToShift ||
                                               valueOfConstantArgumentToShift %
                                               16 !=
                                               0) ||
                                            seen ==
                                            I2B &&
                                            getPrevOpcode(
                                              1) ==
                                            IUSHR &&
                                            !shiftOfNonnegativeValue &&
                                            (!constantArgumentToShift ||
                                               valueOfConstantArgumentToShift %
                                               8 !=
                                               0)) {
                                          bugAccumulator.
                                            accumulateBug(
                                              new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                "ICAST_QUESTIONABLE_UNSIGNED_RIGHT_SHIFT",
                                                NORMAL_PRIORITY).
                                                addClassAndMethod(
                                                  this),
                                              this);
                                      }
                                      if (seen ==
                                            IADD &&
                                            (getNextOpcode(
                                               ) ==
                                               ISHL ||
                                               getNextOpcode(
                                                 ) ==
                                               LSHL) &&
                                            stack.
                                            getStackDepth(
                                              ) >=
                                            3) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item l =
                                            stack.
                                            getStackItem(
                                              2);
                                          edu.umd.cs.findbugs.OpcodeStack.Item v =
                                            stack.
                                            getStackItem(
                                              1);
                                          java.lang.Object constantValue =
                                            v.
                                            getConstant(
                                              );
                                          if (constantValue instanceof java.lang.Integer &&
                                                !java.lang.Integer.
                                                valueOf(
                                                  1).
                                                equals(
                                                  l.
                                                    getConstant(
                                                      ))) {
                                              int c =
                                                ((java.lang.Integer)
                                                   constantValue).
                                                intValue(
                                                  );
                                              int priority =
                                                LOW_PRIORITY;
                                              if (c <
                                                    32 ||
                                                    c <
                                                    64 &&
                                                    getNextOpcode(
                                                      ) ==
                                                    LSHL) {
                                                  if (c ==
                                                        8) {
                                                      priority--;
                                                  }
                                                  if (getPrevOpcode(
                                                        1) ==
                                                        IAND) {
                                                      priority--;
                                                  }
                                                  if (getMethodName(
                                                        ).
                                                        equals(
                                                          "hashCode") &&
                                                        getMethodSig(
                                                          ).
                                                        equals(
                                                          "()I") &&
                                                        (getCode(
                                                           ).
                                                           getCode(
                                                             )[getNextPC(
                                                                 ) +
                                                                 1] &
                                                           255) ==
                                                        IRETURN) {
                                                      priority =
                                                        HIGH_PRIORITY;
                                                  }
                                                  bugAccumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "BSHIFT_WRONG_ADD_PRIORITY",
                                                        priority).
                                                        addClassAndMethod(
                                                          this).
                                                        addInt(
                                                          c).
                                                        describe(
                                                          edu.umd.cs.findbugs.IntAnnotation.
                                                            INT_SHIFT).
                                                        addValueSource(
                                                          stack.
                                                            getStackItem(
                                                              2),
                                                          this).
                                                        addValueSource(
                                                          stack.
                                                            getStackItem(
                                                              0),
                                                          this),
                                                      this);
                                              }
                                          }
                                      }
                                      constantArgumentToShift =
                                        false;
                                      shiftOfNonnegativeValue =
                                        false;
                                      if (seen ==
                                            IUSHR ||
                                            seen ==
                                            ISHR ||
                                            seen ==
                                            ISHL) {
                                          if (stack.
                                                getStackDepth(
                                                  ) <=
                                                1) {
                                              constantArgumentToShift =
                                                true;
                                              valueOfConstantArgumentToShift =
                                                8;
                                          }
                                          else {
                                              java.lang.Object rightHandSide =
                                                stack.
                                                getStackItem(
                                                  0).
                                                getConstant(
                                                  );
                                              java.lang.Object leftHandSide =
                                                stack.
                                                getStackItem(
                                                  1).
                                                getConstant(
                                                  );
                                              shiftOfNonnegativeValue =
                                                stack.
                                                  getStackItem(
                                                    1).
                                                  isNonNegative(
                                                    );
                                              if (rightHandSide instanceof java.lang.Integer) {
                                                  constantArgumentToShift =
                                                    true;
                                                  valueOfConstantArgumentToShift =
                                                    (java.lang.Integer)
                                                      rightHandSide;
                                                  if (valueOfConstantArgumentToShift <
                                                        0 ||
                                                        valueOfConstantArgumentToShift >=
                                                        32) {
                                                      bugAccumulator.
                                                        accumulateBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "ICAST_BAD_SHIFT_AMOUNT",
                                                            valueOfConstantArgumentToShift <
                                                              0
                                                              ? LOW_PRIORITY
                                                              : (valueOfConstantArgumentToShift ==
                                                                   32 &&
                                                                   "hashCode".
                                                                   equals(
                                                                     getMethodName(
                                                                       ))
                                                                   ? NORMAL_PRIORITY
                                                                   : HIGH_PRIORITY)).
                                                            addClassAndMethod(
                                                              this).
                                                            addInt(
                                                              valueOfConstantArgumentToShift).
                                                            describe(
                                                              edu.umd.cs.findbugs.IntAnnotation.
                                                                INT_SHIFT).
                                                            addValueSource(
                                                              stack.
                                                                getStackItem(
                                                                  1),
                                                              this),
                                                          this);
                                                  }
                                              }
                                              if (leftHandSide !=
                                                    null &&
                                                    leftHandSide instanceof java.lang.Integer &&
                                                    (java.lang.Integer)
                                                      leftHandSide >
                                                    0) {
                                                  constantArgumentToShift =
                                                    true;
                                                  valueOfConstantArgumentToShift =
                                                    8;
                                              }
                                          }
                                      }
                                      if (seen ==
                                            INVOKEVIRTUAL &&
                                            stack.
                                            getStackDepth(
                                              ) >
                                            0 &&
                                            ("java/util/Date".
                                               equals(
                                                 getClassConstantOperand(
                                                   )) ||
                                               "java/sql/Date".
                                               equals(
                                                 getClassConstantOperand(
                                                   ))) &&
                                            "setMonth".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            "(I)V".
                                            equals(
                                              getSigConstantOperand(
                                                ))) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item item =
                                            stack.
                                            getStackItem(
                                              0);
                                          java.lang.Object o =
                                            item.
                                            getConstant(
                                              );
                                          if (o !=
                                                null &&
                                                o instanceof java.lang.Integer) {
                                              int v =
                                                (java.lang.Integer)
                                                  o;
                                              if (v <
                                                    0 ||
                                                    v >
                                                    11) {
                                                  bugReporter.
                                                    reportBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "DMI_BAD_MONTH",
                                                        HIGH_PRIORITY).
                                                        addClassAndMethod(
                                                          this).
                                                        addInt(
                                                          v).
                                                        describe(
                                                          edu.umd.cs.findbugs.IntAnnotation.
                                                            INT_VALUE).
                                                        addCalledMethod(
                                                          this).
                                                        addSourceLine(
                                                          this));
                                              }
                                          }
                                      }
                                      if (seen ==
                                            INVOKEVIRTUAL &&
                                            stack.
                                            getStackDepth(
                                              ) >
                                            1 &&
                                            "java/util/Calendar".
                                            equals(
                                              getClassConstantOperand(
                                                )) &&
                                            "set".
                                            equals(
                                              getNameConstantOperand(
                                                )) ||
                                            seen ==
                                            INVOKESPECIAL &&
                                            stack.
                                            getStackDepth(
                                              ) >
                                            1 &&
                                            "java/util/GregorianCalendar".
                                            equals(
                                              getClassConstantOperand(
                                                )) &&
                                            "<init>".
                                            equals(
                                              getNameConstantOperand(
                                                ))) {
                                          java.lang.String sig =
                                            getSigConstantOperand(
                                              );
                                          if (sig.
                                                startsWith(
                                                  "(III")) {
                                              int pos =
                                                sig.
                                                length(
                                                  ) -
                                                5;
                                              edu.umd.cs.findbugs.OpcodeStack.Item item =
                                                stack.
                                                getStackItem(
                                                  pos);
                                              java.lang.Object o =
                                                item.
                                                getConstant(
                                                  );
                                              if (o !=
                                                    null &&
                                                    o instanceof java.lang.Integer) {
                                                  int v =
                                                    (java.lang.Integer)
                                                      o;
                                                  if (v <
                                                        0 ||
                                                        v >
                                                        11) {
                                                      bugReporter.
                                                        reportBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "DMI_BAD_MONTH",
                                                            NORMAL_PRIORITY).
                                                            addClassAndMethod(
                                                              this).
                                                            addInt(
                                                              v).
                                                            describe(
                                                              edu.umd.cs.findbugs.IntAnnotation.
                                                                INT_VALUE).
                                                            addCalledMethod(
                                                              this).
                                                            addSourceLine(
                                                              this));
                                                  }
                                              }
                                          }
                                      }
                                      if (isRegisterStore(
                                            ) &&
                                            (seen ==
                                               ISTORE ||
                                               seen ==
                                               ISTORE_0 ||
                                               seen ==
                                               ISTORE_1 ||
                                               seen ==
                                               ISTORE_2 ||
                                               seen ==
                                               ISTORE_3) &&
                                            getRegisterOperand(
                                              ) ==
                                            prevOpcodeIncrementedRegister) {
                                          bugAccumulator.
                                            accumulateBug(
                                              new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                "DLS_OVERWRITTEN_INCREMENT",
                                                HIGH_PRIORITY).
                                                addClassAndMethod(
                                                  this),
                                              this);
                                      }
                                      if (seen ==
                                            IINC) {
                                          prevOpcodeIncrementedRegister =
                                            getRegisterOperand(
                                              );
                                      }
                                      else {
                                          prevOpcodeIncrementedRegister =
                                            -1;
                                      }
                                      switch (badlyComputingOddState) {
                                          case 0:
                                              if (seen ==
                                                    ICONST_2) {
                                                  badlyComputingOddState++;
                                              }
                                              break;
                                          case 1:
                                              if (seen ==
                                                    IREM) {
                                                  edu.umd.cs.findbugs.OpcodeStack.Item item =
                                                    stack.
                                                    getStackItem(
                                                      1);
                                                  if (!item.
                                                        isNonNegative(
                                                          ) &&
                                                        item.
                                                        getSpecialKind(
                                                          ) !=
                                                        edu.umd.cs.findbugs.OpcodeStack.Item.
                                                          MATH_ABS) {
                                                      badlyComputingOddState++;
                                                  }
                                                  else {
                                                      badlyComputingOddState =
                                                        0;
                                                  }
                                              }
                                              else {
                                                  badlyComputingOddState =
                                                    0;
                                              }
                                              break;
                                          case 2:
                                              if (seen ==
                                                    ICONST_1) {
                                                  badlyComputingOddState++;
                                              }
                                              else {
                                                  badlyComputingOddState =
                                                    0;
                                              }
                                              break;
                                          case 3:
                                              if (seen ==
                                                    IF_ICMPEQ ||
                                                    seen ==
                                                    IF_ICMPNE) {
                                                  bugAccumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "IM_BAD_CHECK_FOR_ODD",
                                                        NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this),
                                                      this);
                                              }
                                              badlyComputingOddState =
                                                0;
                                              break;
                                          default:
                                              break;
                                      }
                                      if (seen ==
                                            INVOKEVIRTUAL &&
                                            stack.
                                            getStackDepth(
                                              ) >
                                            0 &&
                                            ("toString".
                                               equals(
                                                 getNameConstantOperand(
                                                   )) &&
                                               "()Ljava/lang/String;".
                                               equals(
                                                 getSigConstantOperand(
                                                   )) ||
                                               "append".
                                               equals(
                                                 getNameConstantOperand(
                                                   )) &&
                                               "(Ljava/lang/Object;)Ljava/lang/StringBuilder;".
                                               equals(
                                                 getSigConstantOperand(
                                                   )) &&
                                               "java/lang/StringBuilder".
                                               equals(
                                                 getClassConstantOperand(
                                                   )) ||
                                               "append".
                                               equals(
                                                 getNameConstantOperand(
                                                   )) &&
                                               "(Ljava/lang/Object;)Ljava/lang/StringBuffer;".
                                               equals(
                                                 getSigConstantOperand(
                                                   )) &&
                                               "java/lang/StringBuffer".
                                               equals(
                                                 getClassConstantOperand(
                                                   )) ||
                                               ("print".
                                                  equals(
                                                    getNameConstantOperand(
                                                      )) ||
                                                  "println".
                                                  equals(
                                                    getNameConstantOperand(
                                                      ))) &&
                                               "(Ljava/lang/Object;)V".
                                               equals(
                                                 getSigConstantOperand(
                                                   )))) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item item =
                                            stack.
                                            getStackItem(
                                              0);
                                          java.lang.String signature =
                                            item.
                                            getSignature(
                                              );
                                          if (signature !=
                                                null &&
                                                signature.
                                                startsWith(
                                                  "[")) {
                                              boolean debuggingContext =
                                                "[Ljava/lang/StackTraceElement;".
                                                equals(
                                                  signature);
                                              if (!debuggingContext) {
                                                  for (org.apache.bcel.classfile.CodeException e
                                                        :
                                                        getCode(
                                                          ).
                                                         getExceptionTable(
                                                           )) {
                                                      if (e.
                                                            getHandlerPC(
                                                              ) <=
                                                            getPC(
                                                              ) &&
                                                            e.
                                                            getHandlerPC(
                                                              ) +
                                                            30 >=
                                                            getPC(
                                                              )) {
                                                          debuggingContext =
                                                            true;
                                                      }
                                                  }
                                                  for (int i =
                                                         1;
                                                       !debuggingContext &&
                                                         i <
                                                         stack.
                                                         getStackDepth(
                                                           );
                                                       i++) {
                                                      edu.umd.cs.findbugs.OpcodeStack.Item e =
                                                        stack.
                                                        getStackItem(
                                                          i);
                                                      if (e.
                                                            getSignature(
                                                              ).
                                                            indexOf(
                                                              "Logger") >=
                                                            0 ||
                                                            e.
                                                            getSignature(
                                                              ).
                                                            indexOf(
                                                              "Exception") >=
                                                            0) {
                                                          debuggingContext =
                                                            true;
                                                      }
                                                      edu.umd.cs.findbugs.ba.XField f =
                                                        e.
                                                        getXField(
                                                          );
                                                      if (f !=
                                                            null &&
                                                            (SYSTEM_ERR.
                                                               equals(
                                                                 f.
                                                                   getFieldDescriptor(
                                                                     )) ||
                                                               SYSTEM_OUT.
                                                               equals(
                                                                 f.
                                                                   getFieldDescriptor(
                                                                     )))) {
                                                          debuggingContext =
                                                            true;
                                                      }
                                                  }
                                              }
                                              int reg =
                                                item.
                                                getRegisterNumber(
                                                  );
                                              java.util.Collection<edu.umd.cs.findbugs.BugAnnotation> as =
                                                new java.util.ArrayList<edu.umd.cs.findbugs.BugAnnotation>(
                                                );
                                              edu.umd.cs.findbugs.ba.XField field =
                                                item.
                                                getXField(
                                                  );
                                              edu.umd.cs.findbugs.FieldAnnotation fieldAnnotation =
                                                null;
                                              if (field !=
                                                    null) {
                                                  fieldAnnotation =
                                                    edu.umd.cs.findbugs.FieldAnnotation.
                                                      fromXField(
                                                        field);
                                                  fieldAnnotation.
                                                    setDescription(
                                                      edu.umd.cs.findbugs.FieldAnnotation.
                                                        LOADED_FROM_ROLE);
                                              }
                                              if (reg !=
                                                    -1) {
                                                  edu.umd.cs.findbugs.LocalVariableAnnotation lva =
                                                    edu.umd.cs.findbugs.LocalVariableAnnotation.
                                                    getLocalVariableAnnotation(
                                                      getMethod(
                                                        ),
                                                      reg,
                                                      getPC(
                                                        ),
                                                      getPC(
                                                        ) -
                                                        1);
                                                  if (lva.
                                                        isNamed(
                                                          )) {
                                                      as.
                                                        add(
                                                          lva);
                                                      if (fieldAnnotation !=
                                                            null) {
                                                          as.
                                                            add(
                                                              fieldAnnotation);
                                                      }
                                                  }
                                                  else {
                                                      if (fieldAnnotation !=
                                                            null) {
                                                          as.
                                                            add(
                                                              fieldAnnotation);
                                                      }
                                                      as.
                                                        add(
                                                          lva);
                                                  }
                                              }
                                              else
                                                  if (fieldAnnotation !=
                                                        null) {
                                                      as.
                                                        add(
                                                          fieldAnnotation);
                                                  }
                                                  else {
                                                      edu.umd.cs.findbugs.ba.XMethod m =
                                                        item.
                                                        getReturnValueOf(
                                                          );
                                                      if (m !=
                                                            null) {
                                                          edu.umd.cs.findbugs.MethodAnnotation methodAnnotation =
                                                            edu.umd.cs.findbugs.MethodAnnotation.
                                                            fromXMethod(
                                                              m);
                                                          methodAnnotation.
                                                            setDescription(
                                                              edu.umd.cs.findbugs.MethodAnnotation.
                                                                METHOD_RETURN_VALUE_OF);
                                                          as.
                                                            add(
                                                              methodAnnotation);
                                                      }
                                                  }
                                              int priority =
                                                debuggingContext
                                                ? NORMAL_PRIORITY
                                                : HIGH_PRIORITY;
                                              if (!as.
                                                    isEmpty(
                                                      )) {
                                                  bugAccumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "DMI_INVOKING_TOSTRING_ON_ARRAY",
                                                        priority).
                                                        addClassAndMethod(
                                                          this).
                                                        addAnnotations(
                                                          as),
                                                      this);
                                              }
                                              else {
                                                  bugAccumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "DMI_INVOKING_TOSTRING_ON_ANONYMOUS_ARRAY",
                                                        priority).
                                                        addClassAndMethod(
                                                          this),
                                                      this);
                                              }
                                          }
                                      }
                                      if (isTigerOrHigher) {
                                          if (previousMethodInvocation !=
                                                null &&
                                                prevOpCode ==
                                                INVOKEVIRTUAL &&
                                                seen ==
                                                INVOKESTATIC) {
                                              java.lang.String classNameForPreviousMethod =
                                                previousMethodInvocation.
                                                getClassName(
                                                  );
                                              java.lang.String classNameForThisMethod =
                                                getClassConstantOperand(
                                                  );
                                              if (classNameForPreviousMethod.
                                                    startsWith(
                                                      "java.lang.") &&
                                                    classNameForPreviousMethod.
                                                    equals(
                                                      classNameForThisMethod.
                                                        replace(
                                                          '/',
                                                          '.')) &&
                                                    previousMethodInvocation.
                                                    getName(
                                                      ).
                                                    endsWith(
                                                      "Value") &&
                                                    previousMethodInvocation.
                                                    getSignature(
                                                      ).
                                                    length(
                                                      ) ==
                                                    3 &&
                                                    "valueOf".
                                                    equals(
                                                      getNameConstantOperand(
                                                        )) &&
                                                    getSigConstantOperand(
                                                      ).
                                                    charAt(
                                                      1) ==
                                                    previousMethodInvocation.
                                                    getSignature(
                                                      ).
                                                    charAt(
                                                      2)) {
                                                  bugAccumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "BX_UNBOXING_IMMEDIATELY_REBOXED",
                                                        NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this).
                                                        addCalledMethod(
                                                          this),
                                                      this);
                                              }
                                          }
                                          if (previousMethodInvocation !=
                                                null &&
                                                prevOpCode ==
                                                INVOKESPECIAL &&
                                                seen ==
                                                INVOKEVIRTUAL) {
                                              java.lang.String classNameForPreviousMethod =
                                                previousMethodInvocation.
                                                getClassName(
                                                  );
                                              java.lang.String classNameForThisMethod =
                                                getClassConstantOperand(
                                                  );
                                              if (classNameForPreviousMethod.
                                                    startsWith(
                                                      "java.lang.") &&
                                                    classNameForPreviousMethod.
                                                    equals(
                                                      classNameForThisMethod.
                                                        replace(
                                                          '/',
                                                          '.')) &&
                                                    getNameConstantOperand(
                                                      ).
                                                    endsWith(
                                                      "Value") &&
                                                    getSigConstantOperand(
                                                      ).
                                                    length(
                                                      ) ==
                                                    3) {
                                                  if (getSigConstantOperand(
                                                        ).
                                                        charAt(
                                                          2) ==
                                                        previousMethodInvocation.
                                                        getSignature(
                                                          ).
                                                        charAt(
                                                          1)) {
                                                      bugAccumulator.
                                                        accumulateBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "BX_BOXING_IMMEDIATELY_UNBOXED",
                                                            NORMAL_PRIORITY).
                                                            addClassAndMethod(
                                                              this),
                                                          this);
                                                  }
                                                  else {
                                                      bugAccumulator.
                                                        accumulateBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "BX_BOXING_IMMEDIATELY_UNBOXED_TO_PERFORM_COERCION",
                                                            NORMAL_PRIORITY).
                                                            addClassAndMethod(
                                                              this),
                                                          this);
                                                  }
                                                  ternaryConversionState =
                                                    1;
                                              }
                                              else {
                                                  ternaryConversionState =
                                                    0;
                                              }
                                          }
                                          else
                                              if (seen ==
                                                    INVOKEVIRTUAL) {
                                                  if (getClassConstantOperand(
                                                        ).
                                                        startsWith(
                                                          "java/lang") &&
                                                        getNameConstantOperand(
                                                          ).
                                                        endsWith(
                                                          "Value") &&
                                                        getSigConstantOperand(
                                                          ).
                                                        length(
                                                          ) ==
                                                        3) {
                                                      ternaryConversionState =
                                                        1;
                                                  }
                                                  else {
                                                      ternaryConversionState =
                                                        0;
                                                  }
                                              }
                                              else
                                                  if (ternaryConversionState ==
                                                        1) {
                                                      if (I2L <
                                                            seen &&
                                                            seen <=
                                                            I2S) {
                                                          ternaryConversionState =
                                                            2;
                                                      }
                                                      else {
                                                          ternaryConversionState =
                                                            0;
                                                      }
                                                  }
                                                  else
                                                      if (ternaryConversionState ==
                                                            2) {
                                                          ternaryConversionState =
                                                            0;
                                                          if (seen ==
                                                                GOTO) {
                                                              bugReporter.
                                                                reportBug(
                                                                  new edu.umd.cs.findbugs.BugInstance(
                                                                    this,
                                                                    "BX_UNBOXED_AND_COERCED_FOR_TERNARY_OPERATOR",
                                                                    NORMAL_PRIORITY).
                                                                    addClassAndMethod(
                                                                      this).
                                                                    addSourceLine(
                                                                      this));
                                                          }
                                                      }
                                                      else {
                                                          ternaryConversionState =
                                                            0;
                                                      }
                                      }
                                      AssertInvokedFromRun: if (seen ==
                                                                  INVOKESTATIC) {
                                          if ((getNameConstantOperand(
                                                 ).
                                                 startsWith(
                                                   "assert") ||
                                                 getNameConstantOperand(
                                                   ).
                                                 startsWith(
                                                   "fail")) &&
                                                "run".
                                                equals(
                                                  getMethodName(
                                                    )) &&
                                                implementsRunnable(
                                                  getThisClass(
                                                    ))) {
                                              int size1 =
                                                edu.umd.cs.findbugs.visitclass.Util.
                                                getSizeOfSurroundingTryBlock(
                                                  getConstantPool(
                                                    ),
                                                  getMethod(
                                                    ).
                                                    getCode(
                                                      ),
                                                  "java/lang/Throwable",
                                                  getPC(
                                                    ));
                                              int size2 =
                                                edu.umd.cs.findbugs.visitclass.Util.
                                                getSizeOfSurroundingTryBlock(
                                                  getConstantPool(
                                                    ),
                                                  getMethod(
                                                    ).
                                                    getCode(
                                                      ),
                                                  "java/lang/Error",
                                                  getPC(
                                                    ));
                                              int size3 =
                                                edu.umd.cs.findbugs.visitclass.Util.
                                                getSizeOfSurroundingTryBlock(
                                                  getConstantPool(
                                                    ),
                                                  getMethod(
                                                    ).
                                                    getCode(
                                                      ),
                                                  "java/lang/AssertionFailureError",
                                                  getPC(
                                                    ));
                                              int size =
                                                java.lang.Math.
                                                min(
                                                  java.lang.Math.
                                                    min(
                                                      size1,
                                                      size2),
                                                  size3);
                                              if (size ==
                                                    java.lang.Integer.
                                                      MAX_VALUE) {
                                                  java.lang.String dottedClassName =
                                                    getClassConstantOperand(
                                                      ).
                                                    replace(
                                                      '/',
                                                      '.');
                                                  if (!dottedClassName.
                                                        startsWith(
                                                          "junit")) {
                                                      try {
                                                          org.apache.bcel.classfile.JavaClass targetClass =
                                                            edu.umd.cs.findbugs.ba.AnalysisContext.
                                                            currentAnalysisContext(
                                                              ).
                                                            lookupClass(
                                                              dottedClassName);
                                                          if (!targetClass.
                                                                getSuperclassName(
                                                                  ).
                                                                startsWith(
                                                                  "junit")) {
                                                              break AssertInvokedFromRun;
                                                          }
                                                      }
                                                      catch (java.lang.ClassNotFoundException e) {
                                                          edu.umd.cs.findbugs.ba.AnalysisContext.
                                                            reportMissingClass(
                                                              e);
                                                          break AssertInvokedFromRun;
                                                      }
                                                  }
                                                  bugAccumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "IJU_ASSERT_METHOD_INVOKED_FROM_RUN_METHOD",
                                                        extendsThread(
                                                          getThisClass(
                                                            ))
                                                          ? NORMAL_PRIORITY
                                                          : LOW_PRIORITY).
                                                        addClassAndMethod(
                                                          this),
                                                      this);
                                              }
                                          }
                                      }
                                      if (seen ==
                                            INVOKESPECIAL &&
                                            getClassConstantOperand(
                                              ).
                                            startsWith(
                                              "java/lang/") &&
                                            "<init>".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            getSigConstantOperand(
                                              ).
                                            length(
                                              ) ==
                                            4) {
                                          previousMethodInvocation =
                                            edu.umd.cs.findbugs.ba.XFactory.
                                              createReferencedXMethod(
                                                this);
                                      }
                                      else
                                          if (seen ==
                                                INVOKESTATIC &&
                                                getClassConstantOperand(
                                                  ).
                                                startsWith(
                                                  "java/lang/") &&
                                                "valueOf".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                getSigConstantOperand(
                                                  ).
                                                length(
                                                  ) ==
                                                4) {
                                              previousMethodInvocation =
                                                edu.umd.cs.findbugs.ba.XFactory.
                                                  createReferencedXMethod(
                                                    this);
                                          }
                                          else
                                              if (seen ==
                                                    INVOKEVIRTUAL &&
                                                    getClassConstantOperand(
                                                      ).
                                                    startsWith(
                                                      "java/lang/") &&
                                                    getNameConstantOperand(
                                                      ).
                                                    endsWith(
                                                      "Value") &&
                                                    getSigConstantOperand(
                                                      ).
                                                    length(
                                                      ) ==
                                                    3) {
                                                  previousMethodInvocation =
                                                    edu.umd.cs.findbugs.ba.XFactory.
                                                      createReferencedXMethod(
                                                        this);
                                              }
                                              else {
                                                  previousMethodInvocation =
                                                    null;
                                              }
                                      if (testingEnabled &&
                                            seen ==
                                            IAND ||
                                            seen ==
                                            LAND) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item rhs =
                                            stack.
                                            getStackItem(
                                              0);
                                          edu.umd.cs.findbugs.OpcodeStack.Item lhs =
                                            stack.
                                            getStackItem(
                                              1);
                                          java.lang.Object constant =
                                            rhs.
                                            getConstant(
                                              );
                                          edu.umd.cs.findbugs.OpcodeStack.Item value =
                                            lhs;
                                          if (constant ==
                                                null) {
                                              constant =
                                                lhs.
                                                  getConstant(
                                                    );
                                              value =
                                                rhs;
                                          }
                                          if (constant instanceof java.lang.Number &&
                                                (seen ==
                                                   LAND ||
                                                   value.
                                                   getSpecialKind(
                                                     ) ==
                                                   edu.umd.cs.findbugs.OpcodeStack.Item.
                                                     RESULT_OF_L2I)) {
                                              long constantValue =
                                                ((java.lang.Number)
                                                   constant).
                                                longValue(
                                                  );
                                              if (constantValue ==
                                                    4026531839L ||
                                                    constantValue ==
                                                    -1152921504606846977L ||
                                                    seen ==
                                                    IAND &&
                                                    constantValue ==
                                                    -268435457) {
                                                  bugAccumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "TESTING",
                                                        seen ==
                                                          LAND
                                                          ? HIGH_PRIORITY
                                                          : NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this).
                                                        addString(
                                                          "Possible failed attempt to mask lower 31 bits of an int").
                                                        addValueSource(
                                                          value,
                                                          this),
                                                      this);
                                              }
                                          }
                                      }
                                      if (seen ==
                                            INEG) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item top =
                                            stack.
                                            getStackItem(
                                              0);
                                          edu.umd.cs.findbugs.ba.XMethod m =
                                            top.
                                            getReturnValueOf(
                                              );
                                          if (m !=
                                                null) {
                                              if ("compareTo".
                                                    equals(
                                                      m.
                                                        getName(
                                                          )) ||
                                                    "compare".
                                                    equals(
                                                      m.
                                                        getName(
                                                          ))) {
                                                  bugAccumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "RV_NEGATING_RESULT_OF_COMPARETO",
                                                        NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this).
                                                        addCalledMethod(
                                                          m).
                                                        addValueSource(
                                                          top,
                                                          this),
                                                      this);
                                              }
                                          }
                                      }
                                      prevOpCode =
                                        seen;
    }
    boolean implementsRunnable(org.apache.bcel.classfile.JavaClass obj) {
        return edu.umd.cs.findbugs.ba.ch.Subtypes2.
          instanceOf(
            obj,
            "java.lang.Runnable");
    }
    boolean extendsThread(org.apache.bcel.classfile.JavaClass obj) {
        return edu.umd.cs.findbugs.ba.ch.Subtypes2.
          instanceOf(
            obj,
            "java.lang.Thread");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ji5Dv2Kv9O3x/wID/rnxKzEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1hBqcsgmDWYYOznVXqROV/RoGR91dNbr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "5DQ+AAA=");
}
