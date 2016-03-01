package edu.umd.cs.findbugs.detect;
public class FindDeadLocalStores implements edu.umd.cs.findbugs.Detector {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fdls.debug");
    private static final java.lang.String FINDBUGS_EXCLUDED_LOCALS_PROP_NAME =
      "findbugs.dls.exclusions";
    @edu.umd.cs.findbugs.internalAnnotations.StaticConstant
    private static final java.util.Set<java.lang.String> EXCLUDED_LOCALS =
      new java.util.HashSet<java.lang.String>(
      );
    static { EXCLUDED_LOCALS.add("gxp_locale");
             java.lang.String exclLocalsProperty = edu.umd.cs.findbugs.SystemProperties.
               getProperty(
                 FINDBUGS_EXCLUDED_LOCALS_PROP_NAME);
             if (exclLocalsProperty != null) { for (java.lang.String s
                                                     :
                                                     exclLocalsProperty.
                                                      split(
                                                        ",")) { java.lang.String s2 =
                                                                  s.
                                                                  trim(
                                                                    );
                                                                if (s2.
                                                                      length(
                                                                        ) >
                                                                      0) {
                                                                    EXCLUDED_LOCALS.
                                                                      add(
                                                                        s2);
                                                                }
                                               } }
    }
    private static final boolean SUPPRESS_IF_AT_LEAST_ONE_LIVE_STORE_ON_LINE =
      edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "findbugs.dls.suppressIfOneLiveStore");
    private static final java.util.BitSet defensiveConstantValueOpcodes =
      new java.util.BitSet(
      );
    static { defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 DCONST_0);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 DCONST_1);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 FCONST_0);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 FCONST_1);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 ACONST_NULL);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 ICONST_M1);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 ICONST_0);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 ICONST_1);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 ICONST_2);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 ICONST_3);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 ICONST_4);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 ICONST_5);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 LCONST_0);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 LCONST_1);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 LDC);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 LDC_W);
             defensiveConstantValueOpcodes.set(org.apache.bcel.Constants.
                                                 LDC2_W);
    }
    private final edu.umd.cs.findbugs.BugReporter
      bugReporter;
    public FindDeadLocalStores(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Debugging FindDeadLocalStores detector");
        }
    }
    private boolean prescreen(edu.umd.cs.findbugs.ba.ClassContext classContext,
                              org.apache.bcel.classfile.Method method) {
        return true;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        org.apache.bcel.classfile.JavaClass javaClass =
          classContext.
          getJavaClass(
            );
        org.apache.bcel.classfile.Method[] methodList =
          javaClass.
          getMethods(
            );
        for (org.apache.bcel.classfile.Method method
              :
              methodList) {
            org.apache.bcel.generic.MethodGen methodGen =
              classContext.
              getMethodGen(
                method);
            if (methodGen ==
                  null) {
                continue;
            }
            if (!prescreen(
                   classContext,
                   method)) {
                continue;
            }
            try {
                analyzeMethod(
                  classContext,
                  method);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                bugReporter.
                  logError(
                    "Error analyzing " +
                    method.
                      toString(
                        ),
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                bugReporter.
                  logError(
                    "Error analyzing " +
                    method.
                      toString(
                        ),
                    e);
            }
        }
    }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        edu.umd.cs.findbugs.ba.CFGBuilderException {
        if (edu.umd.cs.findbugs.bcel.BCELUtil.
              isSynthetic(
                method) ||
              (method.
                 getAccessFlags(
                   ) &
                 org.apache.bcel.Constants.
                   ACC_BRIDGE) ==
              org.apache.bcel.Constants.
                ACC_BRIDGE) {
            return;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "    Analyzing method " +
                classContext.
                  getJavaClass(
                    ).
                  getClassName(
                    ) +
                "." +
                method.
                  getName(
                    ));
        }
        org.apache.bcel.classfile.JavaClass javaClass =
          classContext.
          getJavaClass(
            );
        java.util.BitSet linesMentionedMultipleTimes =
          classContext.
          linesMentionedMultipleTimes(
            method);
        edu.umd.cs.findbugs.BugAccumulator accumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
          bugReporter);
        edu.umd.cs.findbugs.ba.Dataflow<java.util.BitSet,edu.umd.cs.findbugs.ba.LiveLocalStoreAnalysis> llsaDataflow =
          classContext.
          getLiveLocalStoreDataflow(
            method);
        int numLocals =
          method.
          getCode(
            ).
          getMaxLocals(
            );
        int[] localStoreCount =
          new int[numLocals];
        int[] localLoadCount =
          new int[numLocals];
        int[] localIncrementCount =
          new int[numLocals];
        org.apache.bcel.generic.MethodGen methodGen =
          classContext.
          getMethodGen(
            method);
        edu.umd.cs.findbugs.ba.CFG cfg =
          classContext.
          getCFG(
            method);
        if (cfg.
              isFlagSet(
                edu.umd.cs.findbugs.ba.CFG.
                  FOUND_INEXACT_UNCONDITIONAL_THROWERS)) {
            return;
        }
        java.util.BitSet liveStoreSetAtEntry =
          llsaDataflow.
          getAnalysis(
            ).
          getResultFact(
            cfg.
              getEntry(
                ));
        java.util.BitSet complainedAbout =
          new java.util.BitSet(
          );
        edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow =
          classContext.
          getTypeDataflow(
            method);
        int localsThatAreParameters =
          edu.umd.cs.findbugs.visitclass.PreorderVisitor.
          getNumberArguments(
            method.
              getSignature(
                ));
        if (!method.
              isStatic(
                )) {
            localsThatAreParameters++;
        }
        countLocalStoresLoadsAndIncrements(
          localStoreCount,
          localLoadCount,
          localIncrementCount,
          cfg);
        for (int i =
               0;
             i <
               localsThatAreParameters;
             i++) {
            localStoreCount[i]++;
        }
        java.util.BitSet liveStoreSourceLineSet =
          new java.util.BitSet(
          );
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               cfg.
               locationIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location location =
              i.
              next(
                );
            edu.umd.cs.findbugs.BugInstance pendingBugReportAboutOverwrittenParameter =
              null;
            try {
                edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty> propertySet =
                  new edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty>(
                  );
                if (!isStore(
                       location)) {
                    continue;
                }
                if (location.
                      getBasicBlock(
                        ).
                      isExceptionHandler(
                        )) {
                    propertySet.
                      addProperty(
                        edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                          EXCEPTION_HANDLER);
                }
                org.apache.bcel.generic.InstructionHandle handle =
                  location.
                  getHandle(
                    );
                int pc =
                  handle.
                  getPosition(
                    );
                org.apache.bcel.generic.IndexedInstruction ins =
                  (org.apache.bcel.generic.IndexedInstruction)
                    location.
                    getHandle(
                      ).
                    getInstruction(
                      );
                int local =
                  ins.
                  getIndex(
                    );
                java.util.BitSet liveStoreSet =
                  llsaDataflow.
                  getAnalysis(
                    ).
                  getFactAtLocation(
                    location);
                boolean storeLive =
                  llsaDataflow.
                  getAnalysis(
                    ).
                  isStoreAlive(
                    liveStoreSet,
                    local);
                edu.umd.cs.findbugs.LocalVariableAnnotation lvAnnotation =
                  edu.umd.cs.findbugs.LocalVariableAnnotation.
                  getLocalVariableAnnotation(
                    method,
                    location,
                    ins);
                java.lang.String sourceFileName =
                  javaClass.
                  getSourceFileName(
                    );
                if ("?".
                      equals(
                        lvAnnotation.
                          getName(
                            ))) {
                    if (sourceFileName.
                          endsWith(
                            ".groovy")) {
                        continue;
                    }
                    if (method.
                          getCode(
                            ).
                          getLocalVariableTable(
                            ) !=
                          null) {
                        continue;
                    }
                }
                edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation =
                  edu.umd.cs.findbugs.SourceLineAnnotation.
                  fromVisitedInstruction(
                    classContext,
                    methodGen,
                    sourceFileName,
                    location.
                      getHandle(
                        ));
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "    Store at " +
                        sourceLineAnnotation.
                          getStartLine(
                            ) +
                        "@" +
                        location.
                          getHandle(
                            ).
                          getPosition(
                            ) +
                        " is " +
                        (storeLive
                           ? "live"
                           : "dead"));
                    java.lang.System.
                      out.
                      println(
                        "Previous is: " +
                        location.
                          getHandle(
                            ).
                          getPrev(
                            ));
                }
                if (storeLive &&
                      sourceLineAnnotation.
                      getStartLine(
                        ) >
                      0) {
                    liveStoreSourceLineSet.
                      set(
                        sourceLineAnnotation.
                          getStartLine(
                            ));
                }
                java.lang.String lvName =
                  lvAnnotation.
                  getName(
                    );
                if (lvName.
                      charAt(
                        0) ==
                      '$' ||
                      lvName.
                      charAt(
                        0) ==
                      '_') {
                    propertySet.
                      addProperty(
                        edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                          SYNTHETIC_NAME);
                }
                if (EXCLUDED_LOCALS.
                      contains(
                        lvName)) {
                    continue;
                }
                propertySet.
                  setProperty(
                    edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                      LOCAL_NAME,
                    lvName);
                boolean isParameter =
                  local <
                  localsThatAreParameters;
                if (isParameter) {
                    propertySet.
                      addProperty(
                        edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                          IS_PARAMETER);
                }
                org.apache.bcel.classfile.Field shadowedField =
                  null;
                for (org.apache.bcel.classfile.Field f
                      :
                      javaClass.
                       getFields(
                         )) {
                    if (f.
                          getName(
                            ).
                          equals(
                            lvName) &&
                          f.
                          isStatic(
                            ) ==
                          method.
                          isStatic(
                            )) {
                        shadowedField =
                          f;
                        propertySet.
                          addProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              SHADOWS_FIELD);
                        break;
                    }
                }
                boolean parameterThatIsDeadAtEntry =
                  isParameter &&
                  !llsaDataflow.
                  getAnalysis(
                    ).
                  isStoreAlive(
                    liveStoreSetAtEntry,
                    local);
                if (parameterThatIsDeadAtEntry &&
                      !complainedAbout.
                      get(
                        local)) {
                    int priority =
                      storeLive
                      ? LOW_PRIORITY
                      : NORMAL_PRIORITY;
                    if (shadowedField !=
                          null) {
                        priority--;
                    }
                    pendingBugReportAboutOverwrittenParameter =
                      new edu.umd.cs.findbugs.BugInstance(
                        this,
                        "IP_PARAMETER_IS_DEAD_BUT_OVERWRITTEN",
                        priority).
                        addClassAndMethod(
                          methodGen,
                          sourceFileName).
                        add(
                          lvAnnotation);
                    if (shadowedField !=
                          null) {
                        pendingBugReportAboutOverwrittenParameter.
                          addField(
                            edu.umd.cs.findbugs.FieldAnnotation.
                              fromBCELField(
                                classContext.
                                  getJavaClass(
                                    ),
                                shadowedField)).
                          describe(
                            edu.umd.cs.findbugs.FieldAnnotation.
                              DID_YOU_MEAN_ROLE);
                    }
                    pendingBugReportAboutOverwrittenParameter.
                      addSourceLine(
                        classContext,
                        methodGen,
                        sourceFileName,
                        location.
                          getHandle(
                            ));
                    complainedAbout.
                      set(
                        local);
                }
                if (storeLive) {
                    continue;
                }
                edu.umd.cs.findbugs.ba.type.TypeFrame typeFrame =
                  typeDataflow.
                  getAnalysis(
                    ).
                  getFactAtLocation(
                    location);
                org.apache.bcel.generic.Type typeOfValue =
                  null;
                if (typeFrame.
                      isValid(
                        ) &&
                      typeFrame.
                      getStackDepth(
                        ) >
                      0) {
                    typeOfValue =
                      typeFrame.
                        getTopValue(
                          );
                }
                boolean storeOfNull =
                  false;
                org.apache.bcel.generic.InstructionHandle prevInsHandle =
                  location.
                  getHandle(
                    ).
                  getPrev(
                    );
                if (prevInsHandle !=
                      null) {
                    org.apache.bcel.generic.Instruction prevIns =
                      prevInsHandle.
                      getInstruction(
                        );
                    boolean foundDeadClassInitialization =
                      false;
                    java.lang.String initializationOf =
                      null;
                    if (prevIns instanceof org.apache.bcel.generic.ConstantPushInstruction) {
                        continue;
                    }
                    else
                        if (prevIns instanceof org.apache.bcel.generic.GETSTATIC) {
                            org.apache.bcel.generic.GETSTATIC getStatic =
                              (org.apache.bcel.generic.GETSTATIC)
                                prevIns;
                            org.apache.bcel.generic.ConstantPoolGen cpg =
                              methodGen.
                              getConstantPool(
                                );
                            foundDeadClassInitialization =
                              getStatic.
                                getFieldName(
                                  cpg).
                                startsWith(
                                  "class$") &&
                                "Ljava/lang/Class;".
                                equals(
                                  getStatic.
                                    getSignature(
                                      cpg));
                            for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> j =
                                   cfg.
                                   locationIterator(
                                     );
                                 j.
                                   hasNext(
                                     );
                                 ) {
                                edu.umd.cs.findbugs.ba.Location location2 =
                                  j.
                                  next(
                                    );
                                if (location2.
                                      getHandle(
                                        ).
                                      getPosition(
                                        ) +
                                      15 ==
                                      location.
                                      getHandle(
                                        ).
                                      getPosition(
                                        )) {
                                    org.apache.bcel.generic.Instruction instruction2 =
                                      location2.
                                      getHandle(
                                        ).
                                      getInstruction(
                                        );
                                    if (instruction2 instanceof org.apache.bcel.generic.LDC) {
                                        java.lang.Object value =
                                          ((org.apache.bcel.generic.LDC)
                                             instruction2).
                                          getValue(
                                            methodGen.
                                              getConstantPool(
                                                ));
                                        if (value instanceof java.lang.String) {
                                            java.lang.String n =
                                              (java.lang.String)
                                                value;
                                            if (n.
                                                  length(
                                                    ) >
                                                  0) {
                                                initializationOf =
                                                  edu.umd.cs.findbugs.util.ClassName.
                                                    toSignature(
                                                      n);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        else
                            if (prevIns instanceof org.apache.bcel.generic.LDC) {
                                org.apache.bcel.generic.LDC ldc =
                                  (org.apache.bcel.generic.LDC)
                                    prevIns;
                                org.apache.bcel.generic.Type t =
                                  ldc.
                                  getType(
                                    methodGen.
                                      getConstantPool(
                                        ));
                                if ("Ljava/lang/Class;".
                                      equals(
                                        t.
                                          getSignature(
                                            ))) {
                                    java.lang.Object value =
                                      ldc.
                                      getValue(
                                        methodGen.
                                          getConstantPool(
                                            ));
                                    if (value instanceof org.apache.bcel.classfile.ConstantClass) {
                                        org.apache.bcel.classfile.ConstantClass v =
                                          (org.apache.bcel.classfile.ConstantClass)
                                            value;
                                        initializationOf =
                                          edu.umd.cs.findbugs.util.ClassName.
                                            toSignature(
                                              v.
                                                getBytes(
                                                  javaClass.
                                                    getConstantPool(
                                                      )));
                                        foundDeadClassInitialization =
                                          true;
                                    }
                                    else
                                        if (value instanceof org.apache.bcel.generic.ObjectType) {
                                            org.apache.bcel.generic.ObjectType v =
                                              (org.apache.bcel.generic.ObjectType)
                                                value;
                                            initializationOf =
                                              edu.umd.cs.findbugs.util.ClassName.
                                                toSignature(
                                                  v.
                                                    getClassName(
                                                      ));
                                            foundDeadClassInitialization =
                                              true;
                                        }
                                        else {
                                            edu.umd.cs.findbugs.ba.AnalysisContext.
                                              logError(
                                                "LDC loaded " +
                                                value +
                                                "at " +
                                                location.
                                                  getHandle(
                                                    ).
                                                  getPosition(
                                                    ) +
                                                " in " +
                                                classContext.
                                                  getFullyQualifiedMethodName(
                                                    method));
                                        }
                                }
                                else {
                                    continue;
                                }
                            }
                            else
                                if (prevIns instanceof org.apache.bcel.generic.DUP2) {
                                    org.apache.bcel.generic.Instruction cur =
                                      location.
                                      getHandle(
                                        ).
                                      getInstruction(
                                        );
                                    org.apache.bcel.generic.Instruction nxt =
                                      location.
                                      getHandle(
                                        ).
                                      getNext(
                                        ).
                                      getInstruction(
                                        );
                                    if (cur instanceof org.apache.bcel.generic.LSTORE &&
                                          nxt instanceof org.apache.bcel.generic.LRETURN) {
                                        continue;
                                    }
                                }
                    if (foundDeadClassInitialization) {
                        if ("org.apache.axis.client.Stub".
                              equals(
                                classContext.
                                  getJavaClass(
                                    ).
                                  getSuperclassName(
                                    ))) {
                            continue;
                        }
                        edu.umd.cs.findbugs.BugInstance bugInstance =
                          new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "DLS_DEAD_STORE_OF_CLASS_LITERAL",
                          edu.umd.cs.findbugs.Priorities.
                            NORMAL_PRIORITY).
                          addClassAndMethod(
                            methodGen,
                            sourceFileName).
                          add(
                            lvAnnotation).
                          addType(
                            initializationOf);
                        accumulator.
                          accumulateBug(
                            bugInstance,
                            sourceLineAnnotation);
                        continue;
                    }
                    if (prevIns instanceof org.apache.bcel.generic.LDC ||
                          prevIns instanceof org.apache.bcel.generic.ConstantPushInstruction) {
                        propertySet.
                          addProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              STORE_OF_CONSTANT);
                    }
                    else
                        if (prevIns instanceof org.apache.bcel.generic.ACONST_NULL) {
                            storeOfNull =
                              true;
                            propertySet.
                              addProperty(
                                edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                                  STORE_OF_NULL);
                        }
                }
                if (typeOfValue instanceof org.apache.bcel.generic.BasicType ||
                      org.apache.bcel.generic.Type.
                        STRING.
                      equals(
                        typeOfValue)) {
                    propertySet.
                      addProperty(
                        edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                          BASE_VALUE);
                }
                boolean killedBySubsequentStore =
                  llsaDataflow.
                  getAnalysis(
                    ).
                  killedByStore(
                    liveStoreSet,
                    local);
                if (killedBySubsequentStore) {
                    if (propertySet.
                          containsProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              STORE_OF_NULL) ||
                          propertySet.
                          containsProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              STORE_OF_CONSTANT)) {
                        continue;
                    }
                    propertySet.
                      addProperty(
                        edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                          KILLED_BY_SUBSEQUENT_STORE);
                }
                org.apache.bcel.generic.InstructionHandle prev =
                  location.
                  getBasicBlock(
                    ).
                  getPredecessorOf(
                    location.
                      getHandle(
                        ));
                if (prev !=
                      null) {
                    if (defensiveConstantValueOpcodes.
                          get(
                            prev.
                              getInstruction(
                                ).
                              getOpcode(
                                ))) {
                        propertySet.
                          addProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              DEFENSIVE_CONSTANT_OPCODE);
                    }
                    if (prev.
                          getInstruction(
                            ) instanceof org.apache.bcel.generic.GETFIELD) {
                        org.apache.bcel.generic.InstructionHandle prev2 =
                          prev.
                          getPrev(
                            );
                        if (prev2 !=
                              null &&
                              prev2.
                              getInstruction(
                                ) instanceof org.apache.bcel.generic.ALOAD) {
                            propertySet.
                              addProperty(
                                edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                                  CACHING_VALUE);
                        }
                    }
                    if (prev.
                          getInstruction(
                            ) instanceof org.apache.bcel.generic.LoadInstruction) {
                        propertySet.
                          addProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              COPY_VALUE);
                    }
                    if (prev.
                          getInstruction(
                            ) instanceof org.apache.bcel.generic.InvokeInstruction) {
                        propertySet.
                          addProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              METHOD_RESULT);
                    }
                }
                boolean deadObjectStore =
                  false;
                if (ins instanceof org.apache.bcel.generic.IINC) {
                    if ("main".
                          equals(
                            method.
                              getName(
                                )) &&
                          method.
                          isStatic(
                            ) &&
                          "([Ljava/lang/String;)V".
                          equals(
                            method.
                              getSignature(
                                ))) {
                        propertySet.
                          addProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              DEAD_INCREMENT_IN_MAIN);
                    }
                    org.apache.bcel.generic.InstructionHandle next =
                      location.
                      getHandle(
                        ).
                      getNext(
                        );
                    if (next !=
                          null &&
                          next.
                          getInstruction(
                            ) instanceof org.apache.bcel.generic.IRETURN) {
                        propertySet.
                          addProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              DEAD_INCREMENT_IN_RETURN);
                    }
                    else {
                        propertySet.
                          addProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              DEAD_INCREMENT);
                    }
                    if (localIncrementCount[local] ==
                          1) {
                        propertySet.
                          addProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              SINGLE_DEAD_INCREMENT);
                    }
                    else {
                        propertySet.
                          removeProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              IS_PARAMETER);
                    }
                }
                else
                    if (ins instanceof org.apache.bcel.generic.ASTORE &&
                          prev !=
                          null) {
                        org.apache.bcel.generic.Instruction prevIns =
                          prev.
                          getInstruction(
                            );
                        if (prevIns instanceof org.apache.bcel.generic.INVOKESPECIAL &&
                              "<init>".
                              equals(
                                ((org.apache.bcel.generic.INVOKESPECIAL)
                                   prevIns).
                                  getMethodName(
                                    methodGen.
                                      getConstantPool(
                                        ))) ||
                              prevIns instanceof org.apache.bcel.generic.ANEWARRAY ||
                              prevIns instanceof org.apache.bcel.generic.NEWARRAY ||
                              prevIns instanceof org.apache.bcel.generic.MULTIANEWARRAY) {
                            deadObjectStore =
                              true;
                        }
                        else
                            if (prevIns instanceof org.apache.bcel.generic.DUP) {
                                propertySet.
                                  addProperty(
                                    edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                                      DUP_THEN_STORE);
                            }
                    }
                if (deadObjectStore) {
                    propertySet.
                      addProperty(
                        edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                          DEAD_OBJECT_STORE);
                }
                else
                    if (!killedBySubsequentStore &&
                          localStoreCount[local] ==
                          2 &&
                          localLoadCount[local] >
                          0) {
                        propertySet.
                          addProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              TWO_STORES_MULTIPLE_LOADS);
                    }
                    else
                        if (!parameterThatIsDeadAtEntry &&
                              localStoreCount[local] ==
                              1 &&
                              localLoadCount[local] ==
                              0 &&
                              propertySet.
                              containsProperty(
                                edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                                  DEFENSIVE_CONSTANT_OPCODE)) {
                            propertySet.
                              addProperty(
                                edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                                  SINGLE_STORE);
                        }
                        else
                            if (!parameterThatIsDeadAtEntry &&
                                  !propertySet.
                                  containsProperty(
                                    edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                                      SHADOWS_FIELD) &&
                                  localLoadCount[local] ==
                                  0) {
                                propertySet.
                                  addProperty(
                                    edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                                      NO_LOADS);
                            }
                if (!storeOfNull &&
                      typeOfValue !=
                      null &&
                      !propertySet.
                      containsProperty(
                        edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                          EXCEPTION_HANDLER)) {
                    java.lang.String signatureOfValue =
                      typeOfValue.
                      getSignature(
                        );
                    if ((signatureOfValue.
                           startsWith(
                             "Ljava/sql/") ||
                           signatureOfValue.
                           startsWith(
                             "Ljavax/sql/")) &&
                          !signatureOfValue.
                          endsWith(
                            "Exception")) {
                        propertySet.
                          addProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              STORE_OF_DATABASE_VALUE);
                    }
                }
                if (parameterThatIsDeadAtEntry) {
                    propertySet.
                      addProperty(
                        edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                          PARAM_DEAD_ON_ENTRY);
                    if (pendingBugReportAboutOverwrittenParameter !=
                          null) {
                        pendingBugReportAboutOverwrittenParameter.
                          setPriority(
                            edu.umd.cs.findbugs.Priorities.
                              HIGH_PRIORITY);
                    }
                }
                if (localStoreCount[local] >
                      3) {
                    propertySet.
                      addProperty(
                        edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                          MANY_STORES);
                }
                int occurrences =
                  cfg.
                  getLocationsContainingInstructionWithOffset(
                    pc).
                  size(
                    );
                if (occurrences >
                      2 ||
                      sourceLineAnnotation.
                      getStartLine(
                        ) >
                      0 &&
                      linesMentionedMultipleTimes.
                      get(
                        sourceLineAnnotation.
                          getStartLine(
                            ))) {
                    propertySet.
                      addProperty(
                        edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                          CLONED_STORE);
                }
                java.lang.String sourceFile =
                  javaClass.
                  getSourceFileName(
                    );
                if (edu.umd.cs.findbugs.ba.ch.Subtypes2.
                      isJSP(
                        javaClass)) {
                    propertySet.
                      addProperty(
                        edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                          IN_JSP_PAGE);
                }
                else
                    if (edu.umd.cs.findbugs.bcel.BCELUtil.
                          isSynthetic(
                            javaClass) ||
                          sourceFile !=
                          null &&
                          !sourceFile.
                          endsWith(
                            ".java")) {
                        if (sourceFile !=
                              null &&
                              sourceFile.
                              endsWith(
                                ".gxp") &&
                              (lvName.
                                 startsWith(
                                   "gxp$") ||
                                 lvName.
                                 startsWith(
                                   "gxp_"))) {
                            continue;
                        }
                        propertySet.
                          addProperty(
                            edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                              NOT_JAVA);
                    }
                java.lang.String bugPattern;
                if (storeOfNull) {
                    bugPattern =
                      "DLS_DEAD_LOCAL_STORE_OF_NULL";
                }
                else
                    if (shadowedField !=
                          null) {
                        bugPattern =
                          "DLS_DEAD_LOCAL_STORE_SHADOWS_FIELD";
                    }
                    else
                        if (propertySet.
                              containsProperty(
                                edu.umd.cs.findbugs.detect.DeadLocalStoreProperty.
                                  DEAD_INCREMENT_IN_RETURN)) {
                            bugPattern =
                              "DLS_DEAD_LOCAL_INCREMENT_IN_RETURN";
                        }
                        else {
                            bugPattern =
                              "DLS_DEAD_LOCAL_STORE";
                        }
                edu.umd.cs.findbugs.BugInstance bugInstance =
                  new edu.umd.cs.findbugs.BugInstance(
                  this,
                  bugPattern,
                  NORMAL_PRIORITY).
                  addClassAndMethod(
                    methodGen,
                    sourceFileName).
                  add(
                    lvAnnotation);
                if (shadowedField !=
                      null) {
                    bugInstance.
                      addField(
                        edu.umd.cs.findbugs.FieldAnnotation.
                          fromBCELField(
                            classContext.
                              getJavaClass(
                                ),
                            shadowedField)).
                      describe(
                        edu.umd.cs.findbugs.FieldAnnotation.
                          DID_YOU_MEAN_ROLE);
                }
                if (edu.umd.cs.findbugs.FindBugsAnalysisFeatures.
                      isRelaxedMode(
                        )) {
                    edu.umd.cs.findbugs.props.WarningPropertyUtil.
                      addPropertiesForDataMining(
                        propertySet,
                        classContext,
                        method,
                        location);
                }
                propertySet.
                  decorateBugInstance(
                    bugInstance);
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        sourceFileName +
                        " : " +
                        methodGen.
                          getName(
                            ));
                    java.lang.System.
                      out.
                      println(
                        "priority: " +
                        bugInstance.
                          getPriority(
                            ));
                    java.lang.System.
                      out.
                      println(
                        "Reporting " +
                        bugInstance);
                    java.lang.System.
                      out.
                      println(
                        propertySet);
                }
                accumulator.
                  accumulateBug(
                    bugInstance,
                    sourceLineAnnotation);
            }
            finally {
                if (pendingBugReportAboutOverwrittenParameter !=
                      null) {
                    bugReporter.
                      reportBug(
                        pendingBugReportAboutOverwrittenParameter);
                }
            }
        }
        suppressWarningsIfOneLiveStoreOnLine(
          accumulator,
          liveStoreSourceLineSet);
        accumulator.
          reportAccumulatedBugs(
            );
    }
    private void suppressWarningsIfOneLiveStoreOnLine(edu.umd.cs.findbugs.BugAccumulator accumulator,
                                                      java.util.BitSet liveStoreSourceLineSet) {
        if (!SUPPRESS_IF_AT_LEAST_ONE_LIVE_STORE_ON_LINE) {
            return;
        }
        entryLoop: for (java.util.Iterator<? extends edu.umd.cs.findbugs.BugInstance> i =
                          accumulator.
                          uniqueBugs(
                            ).
                          iterator(
                            );
                        i.
                          hasNext(
                            );
                        ) {
            for (edu.umd.cs.findbugs.SourceLineAnnotation annotation
                  :
                  accumulator.
                   locations(
                     i.
                       next(
                         ))) {
                if (liveStoreSourceLineSet.
                      get(
                        annotation.
                          getStartLine(
                            ))) {
                    i.
                      remove(
                        );
                    continue entryLoop;
                }
            }
        }
    }
    private void countLocalStoresLoadsAndIncrements(int[] localStoreCount,
                                                    int[] localLoadCount,
                                                    int[] localIncrementCount,
                                                    edu.umd.cs.findbugs.ba.CFG cfg) {
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               cfg.
               locationIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location location =
              i.
              next(
                );
            if (location.
                  getBasicBlock(
                    ).
                  isExceptionHandler(
                    )) {
                continue;
            }
            boolean isStore =
              isStore(
                location);
            boolean isLoad =
              isLoad(
                location);
            if (!isStore &&
                  !isLoad) {
                continue;
            }
            org.apache.bcel.generic.IndexedInstruction ins =
              (org.apache.bcel.generic.IndexedInstruction)
                location.
                getHandle(
                  ).
                getInstruction(
                  );
            int local =
              ins.
              getIndex(
                );
            if (ins instanceof org.apache.bcel.generic.IINC) {
                localStoreCount[local]++;
                localLoadCount[local]++;
                localIncrementCount[local]++;
            }
            else
                if (isStore) {
                    localStoreCount[local]++;
                }
                else {
                    localLoadCount[local]++;
                }
        }
    }
    private boolean isStore(edu.umd.cs.findbugs.ba.Location location) {
        org.apache.bcel.generic.Instruction ins =
          location.
          getHandle(
            ).
          getInstruction(
            );
        return ins instanceof org.apache.bcel.generic.StoreInstruction ||
          ins instanceof org.apache.bcel.generic.IINC;
    }
    private boolean isLoad(edu.umd.cs.findbugs.ba.Location location) {
        org.apache.bcel.generic.Instruction ins =
          location.
          getHandle(
            ).
          getInstruction(
            );
        return ins instanceof org.apache.bcel.generic.LoadInstruction ||
          ins instanceof org.apache.bcel.generic.IINC;
    }
    @java.lang.Override
    public void report() {  }
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
       "VVcWNT+aVsfJsj8uj21t4NMhG+GQy2u+7DWwKiuZW6tGcvCQ7nda6molTTeE" +
       "tfHm0KrBMqyKE60F7lSYIItWdcypWZTY2mJjY8k1qqRNSAY9njbmzNJr+XWT" +
       "hoxmhk574lYgFjgb4jYfrrOa0kSpPi5o4ixbCojjMO3uSBw0YC1TRo42Gsxx" +
       "b1vhnUXY5WV8wy9TujKvVRZNjeikKzbwlkCh584mwzClMkjnDaUr0ibRYDid" +
       "Y1pUZxr3Zb+ZOBGhQZojy7lrOYgJfwGpWH+40vvysNNoZATXAlJCkMwauRsb" +
       "2lgEJQy31pwbMZjhSq6fJUMDGZQ7aKgaIwTKAFpG82mvLfi215CzhBiok77O" +
       "TCuQvnJrTrncx5diGHCy2R72I0i310tO2faloEumU7qSZcSoSZIbHqmbc6fN" +
       "Z5SlTpeSMZ/aqRTJcJqNDXpAZTGEoGNiConclNm0+92oU0ccqF7fJP05QXYV" +
       "MnEr7iKpLdhskFHOWl1lPaKBiiikNhJLmAlbvlbX3EDwBkx1lfZhJHD9sDkJ" +
       "La69WqKpuhBULSSh8kIJbGHJ2kIV7dWxYVNiicZ86odDd+tPhfUsjjJIT8dj" +
       "pLcaVNgWbEe1baXNxMqsFrfMaISyxphImtgoI1ODTlPYjFXdo4Cs3DWKL3t4" +
       "V9rIIY1HETKNFXkmVzyFBULqWGoNn0AO3FFYmpiMkjHwwKx4Qs7iLGZhU44b" +
       "E0nsC8tymNoh7daxnheI0waGw7Y19aFlHWe63Ey1hr2mVFNdQSO87aJTX6+G" +
       "rk8JQYCQnuOwk3UFMxjU1nWb6DJ2j0bs2thOq8AbbZTNfjaXZss0ZoXORp5p" +
       "mRoR8ZKpIAM7sMEwpOjo9tbrRDS7oVBoI7W6WRpRHRvnMKjcQDEoXA9WYzjr" +
       "BRXHHvo9g1eAxyZom4a98gCnXWylil1RXIgCM6L8uoobWL9MzdBO3COlFp7U" +
       "ONrQN7LZiIJBLLZaDcImsERi6CgjSQ6AaC9UXL3Xb5oM2R1wATxOPSETR2gY" +
       "zMBq21YdW1H7sr0gwpCyZFJkI8TBfC+b+NC8B0+W1phBq5JU1rmJuECG/WUZ" +
       "G3bqlW1nHuABny0aa1Nob6rE1M3KUW8WcJusGzVhortcB0K9W1PorcYuqIkW" +
       "wo26kggVUmgxC5ljnSk/FVbl1die1LZVadJpUQ04ENohVG1qqlZR+nB9gWzX" +
       "c6/SC6e1DN1UAGhMR7bLEf1szc8SYgKV+yJwM7W06eqrUSUp0zq0TsqLNKzX" +
       "p0E9zoRNVmYzGClDqKgtTBxtiYoBdnljyLV9deJiAUq7bhylCjRTWlNBl6YS" +
       "R/fVgQRVeXsw31KLLlmeCnM+GbdMXMmMQNV6G6QXJAlpjxfWxpFpEhlMO/KK" +
       "M9oLHYuMpkSk0EzsDJrjWUgZY4RERmuRWtssY22GFLUa1hESk8b9tYuZTlPP" +
       "rG3Y140WISGa7Ukw1cya8w1JmU6XKMvDWqraLkxkyaRK9PvmFnbW4sSfpbZY" +
       "Q/WOEzbYVJ/7lN+zZz2hadfLc34YqfVJvUUstSwiiWE0JCqUakVruNuo2Oxw" +
       "3J5WCHU6agwUNV36IUFukSmbilulUsvWCtQnl0zUshyOnjMUrK1oPuTxgTUe" +
       "iv4kpEW6s5EaZtyWauMJA7zknkRu+sCA01G8GafYJiXhsbCxp0lMhnC1JRit" +
       "6bajYQMJ7M+gWnvQS7He1HZqWaUnuKOoE0poklHLjbWt1mhDGAK2zEx+aDbG" +
       "qiOPVKMykDccP+/FBs0kGlnj19aA6Q1UBG+EY45CRL/d628bas+bzpooPJ0F" +
       "cy0h17WlRDSrHYLv9lawkSzqCNZEETjpKzVrJbWUGhRYChGbSkK5osKFvDLT" +
       "SURdyKOy1qv2AIqxaQWurevLUG4xTqrgCwcV05qiVKHyFtNrbBuiFGO7ZlAu" +
       "I8gljcZIeTYaJbWk34RbrRqrBQznu2JljI+gpsC0nJbZZ1rNFldZOHE1VFYQ" +
       "wa5HsDeTJ5JQtTJXGkL2Wi9DzFCfeMp04i2DeXWpig1LkquM7Ihri+0HZW6J" +
       "s4IUpCN84eoOuZw2pAlwzXihAi/CcbhW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "f60Itfq/r5uw4D87AAA=");
}
