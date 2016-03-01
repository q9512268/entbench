package edu.umd.cs.findbugs.detect;
public class CheckTypeQualifiers extends edu.umd.cs.findbugs.bcel.CFGDetector {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "ctq.debug");
    private static final boolean DEBUG_DATAFLOW = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "ctq.dataflow.debug");
    private static final java.lang.String DEBUG_DATAFLOW_MODE = edu.umd.cs.findbugs.SystemProperties.
      getProperty(
        "ctq.dataflow.debug.mode",
        "both");
    private static final java.lang.String NONNULL_ANNOTATION =
      edu.umd.cs.findbugs.ba.jsr305.JSR305NullnessAnnotations.
        NONNULL.
      getClassName(
        );
    private static final java.lang.String METHOD = edu.umd.cs.findbugs.SystemProperties.
      getProperty(
        "ctq.method");
    private final edu.umd.cs.findbugs.BugReporter
      bugReporter;
    public CheckTypeQualifiers(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    boolean checked;
    boolean shouldRunAnalysis;
    @java.lang.Override
    public void visitClass(edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor)
          throws edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
        if (!checked) {
            checked =
              true;
            java.util.Collection<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>> allKnownTypeQualifiers =
              edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
              getAllKnownTypeQualifiers(
                );
            int size =
              allKnownTypeQualifiers.
              size(
                );
            if (size ==
                  1) {
                edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> value =
                  edu.umd.cs.findbugs.util.Util.
                  first(
                    allKnownTypeQualifiers);
                if (!value.
                       typeQualifier.
                      getClassName(
                        ).
                      equals(
                        NONNULL_ANNOTATION)) {
                    shouldRunAnalysis =
                      true;
                }
            }
            else
                if (size >
                      1) {
                    shouldRunAnalysis =
                      true;
                }
        }
        if (shouldRunAnalysis) {
            super.
              visitClass(
                classDescriptor);
        }
    }
    @java.lang.Override
    protected void visitMethodCFG(edu.umd.cs.findbugs.classfile.MethodDescriptor methodDescriptor,
                                  edu.umd.cs.findbugs.ba.CFG cfg)
          throws edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
        if (METHOD !=
              null &&
              !methodDescriptor.
              getName(
                ).
              equals(
                METHOD)) {
            return;
        }
        if (methodDescriptor.
              getName(
                ).
              startsWith(
                "access$")) {
            return;
        }
        edu.umd.cs.findbugs.ba.XMethod xMethod =
          edu.umd.cs.findbugs.ba.XFactory.
          createXMethod(
            methodDescriptor);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "CheckTypeQualifiers: checking " +
                methodDescriptor.
                  toString(
                    ));
        }
        java.util.Collection<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>> relevantQualifiers =
          edu.umd.cs.findbugs.ba.jsr305.Analysis.
          getRelevantTypeQualifiers(
            methodDescriptor,
            cfg);
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?>> i =
               relevantQualifiers.
               iterator(
                 );
             i.
               hasNext(
                 );
             ) {
            if (i.
                  next(
                    ).
                  getTypeQualifierClassDescriptor(
                    ).
                  getClassName(
                    ).
                  equals(
                    NONNULL_ANNOTATION)) {
                i.
                  remove(
                    );
            }
        }
        if (relevantQualifiers.
              isEmpty(
                )) {
            return;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "  Relevant type qualifiers are " +
                relevantQualifiers);
        }
        edu.umd.cs.findbugs.classfile.IAnalysisCache analysisCache =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            );
        edu.umd.cs.findbugs.ba.jsr305.ForwardTypeQualifierDataflowFactory forwardDataflowFactory =
          analysisCache.
          getMethodAnalysis(
            edu.umd.cs.findbugs.ba.jsr305.ForwardTypeQualifierDataflowFactory.class,
            methodDescriptor);
        edu.umd.cs.findbugs.ba.jsr305.BackwardTypeQualifierDataflowFactory backwardDataflowFactory =
          analysisCache.
          getMethodAnalysis(
            edu.umd.cs.findbugs.ba.jsr305.BackwardTypeQualifierDataflowFactory.class,
            methodDescriptor);
        edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow vnaDataflow =
          analysisCache.
          getMethodAnalysis(
            edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow.class,
            methodDescriptor);
        for (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue
              :
              relevantQualifiers) {
            try {
                checkQualifier(
                  xMethod,
                  cfg,
                  typeQualifierValue,
                  forwardDataflowFactory,
                  backwardDataflowFactory,
                  vnaDataflow);
            }
            catch (edu.umd.cs.findbugs.classfile.MissingClassException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  reportMissingClass(
                    e);
            }
            catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                bugReporter.
                  logError(
                    "Exception checking type qualifier " +
                    typeQualifierValue.
                      toString(
                        ) +
                    " on method " +
                    methodDescriptor.
                      toString(
                        ),
                    e);
            }
        }
    }
    private java.lang.String checkLocation;
    private void checkQualifier(edu.umd.cs.findbugs.ba.XMethod xmethod,
                                edu.umd.cs.findbugs.ba.CFG cfg,
                                edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue,
                                edu.umd.cs.findbugs.ba.jsr305.ForwardTypeQualifierDataflowFactory forwardDataflowFactory,
                                edu.umd.cs.findbugs.ba.jsr305.BackwardTypeQualifierDataflowFactory backwardDataflowFactory,
                                edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow vnaDataflow)
          throws edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                ("------------------------------------------------------------" +
                 "----------"));
            java.lang.System.
              out.
              println(
                "Checking type qualifier " +
                typeQualifierValue.
                  toString(
                    ) +
                " on method " +
                xmethod.
                  toString(
                    ));
            if (typeQualifierValue.
                  isStrictQualifier(
                    )) {
                java.lang.System.
                  out.
                  println(
                    "  Strict type qualifier");
            }
            java.lang.System.
              out.
              println(
                ("------------------------------------------------------------" +
                 "----------"));
        }
        if (DEBUG_DATAFLOW) {
            java.lang.System.
              out.
              println(
                "********* Valuenumber analysis *********");
            edu.umd.cs.findbugs.ba.DataflowCFGPrinter<edu.umd.cs.findbugs.ba.vna.ValueNumberFrame,edu.umd.cs.findbugs.ba.vna.ValueNumberAnalysis> p =
              new edu.umd.cs.findbugs.ba.DataflowCFGPrinter<edu.umd.cs.findbugs.ba.vna.ValueNumberFrame,edu.umd.cs.findbugs.ba.vna.ValueNumberAnalysis>(
              vnaDataflow);
            p.
              print(
                java.lang.System.
                  out);
        }
        edu.umd.cs.findbugs.ba.jsr305.ForwardTypeQualifierDataflow forwardDataflow =
          forwardDataflowFactory.
          getDataflow(
            typeQualifierValue);
        if (DEBUG_DATAFLOW &&
              (DEBUG_DATAFLOW_MODE.
                 startsWith(
                   "forward") ||
                 "both".
                 equals(
                   DEBUG_DATAFLOW_MODE))) {
            java.lang.System.
              out.
              println(
                "********* Forwards analysis *********");
            edu.umd.cs.findbugs.ba.DataflowCFGPrinter<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet,edu.umd.cs.findbugs.ba.jsr305.ForwardTypeQualifierDataflowAnalysis> p =
              new edu.umd.cs.findbugs.ba.DataflowCFGPrinter<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet,edu.umd.cs.findbugs.ba.jsr305.ForwardTypeQualifierDataflowAnalysis>(
              forwardDataflow);
            p.
              print(
                java.lang.System.
                  out);
        }
        edu.umd.cs.findbugs.ba.jsr305.BackwardTypeQualifierDataflow backwardDataflow =
          backwardDataflowFactory.
          getDataflow(
            typeQualifierValue);
        if (DEBUG_DATAFLOW &&
              (DEBUG_DATAFLOW_MODE.
                 startsWith(
                   "backward") ||
                 "both".
                 equals(
                   DEBUG_DATAFLOW_MODE))) {
            java.lang.System.
              out.
              println(
                "********* Backwards analysis *********");
            edu.umd.cs.findbugs.ba.DataflowCFGPrinter<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet,edu.umd.cs.findbugs.ba.jsr305.BackwardTypeQualifierDataflowAnalysis> p =
              new edu.umd.cs.findbugs.ba.DataflowCFGPrinter<edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet,edu.umd.cs.findbugs.ba.jsr305.BackwardTypeQualifierDataflowAnalysis>(
              backwardDataflow);
            p.
              print(
                java.lang.System.
                  out);
        }
        checkDataflow(
          xmethod,
          cfg,
          typeQualifierValue,
          vnaDataflow,
          forwardDataflow,
          backwardDataflow);
        checkValueSources(
          xmethod,
          cfg,
          typeQualifierValue,
          vnaDataflow,
          forwardDataflow,
          backwardDataflow);
    }
    private void checkDataflow(edu.umd.cs.findbugs.ba.XMethod xmethod,
                               edu.umd.cs.findbugs.ba.CFG cfg,
                               edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue,
                               edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow vnaDataflow,
                               edu.umd.cs.findbugs.ba.jsr305.ForwardTypeQualifierDataflow forwardDataflow,
                               edu.umd.cs.findbugs.ba.jsr305.BackwardTypeQualifierDataflow backwardDataflow)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               cfg.
               locationIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location loc =
              i.
              next(
                );
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet forwardsFact =
              forwardDataflow.
              getFactAtLocation(
                loc);
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet backwardsFact =
              backwardDataflow.
              getFactAfterLocation(
                loc);
            if (!forwardsFact.
                  isValid(
                    ) ||
                  !backwardsFact.
                  isValid(
                    )) {
                continue;
            }
            if (DEBUG) {
                checkLocation =
                  "location " +
                  loc.
                    toCompactString(
                      );
            }
            checkForConflictingValues(
              xmethod,
              cfg,
              typeQualifierValue,
              forwardsFact,
              backwardsFact,
              loc,
              loc,
              vnaDataflow.
                getFactAtLocation(
                  loc));
            checkForEqualityTest(
              xmethod,
              cfg,
              typeQualifierValue,
              forwardsFact,
              loc,
              vnaDataflow.
                getFactAtLocation(
                  loc));
        }
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Edge> i =
               cfg.
               edgeIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Edge edge =
              i.
              next(
                );
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet forwardFact =
              forwardDataflow.
              getFactOnEdge(
                edge);
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet backwardFact =
              backwardDataflow.
              getResultFact(
                edge.
                  getTarget(
                    ));
            edu.umd.cs.findbugs.ba.Location edgeTargetLocation =
              getEdgeTargetLocation(
                cfg,
                edge);
            edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
              edgeTargetLocation !=
              null
              ? vnaDataflow.
              getFactAtLocation(
                edgeTargetLocation)
              : null;
            edu.umd.cs.findbugs.ba.Location locationToReport;
            if (edge.
                  getSource(
                    ).
                  getLastInstruction(
                    ) !=
                  null) {
                locationToReport =
                  getEdgeSourceLocation(
                    cfg,
                    edge);
            }
            else {
                locationToReport =
                  edgeTargetLocation;
            }
            checkForConflictingValues(
              xmethod,
              cfg,
              typeQualifierValue,
              forwardFact,
              backwardFact,
              locationToReport,
              edgeTargetLocation,
              vnaFrame);
        }
    }
    private void checkForEqualityTest(edu.umd.cs.findbugs.ba.XMethod xmethod,
                                      edu.umd.cs.findbugs.ba.CFG cfg,
                                      edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue,
                                      edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet forwardsFact,
                                      edu.umd.cs.findbugs.ba.Location loc,
                                      edu.umd.cs.findbugs.ba.vna.ValueNumberFrame factAtLocation)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        org.apache.bcel.generic.InstructionHandle handle =
          loc.
          getHandle(
            );
        org.apache.bcel.generic.Instruction ins =
          handle.
          getInstruction(
            );
        boolean isTest =
          false;
        org.apache.bcel.generic.ConstantPoolGen cpg =
          cfg.
          getMethodGen(
            ).
          getConstantPool(
            );
        if (ins instanceof org.apache.bcel.generic.IfInstruction &&
              ins.
              consumeStack(
                cpg) ==
              2) {
            isTest =
              true;
        }
        else
            if (ins instanceof org.apache.bcel.generic.InvokeInstruction &&
                  ins.
                  consumeStack(
                    cpg) ==
                  2) {
                org.apache.bcel.generic.InvokeInstruction invoke =
                  (org.apache.bcel.generic.InvokeInstruction)
                    ins;
                isTest =
                  "equals".
                    equals(
                      invoke.
                        getMethodName(
                          cpg)) &&
                    "(Ljava/lang/Object;)Z".
                    equals(
                      invoke.
                        getSignature(
                          cpg));
            }
        if (isTest) {
            edu.umd.cs.findbugs.ba.vna.ValueNumber top =
              factAtLocation.
              getStackValue(
                0);
            if (top.
                  hasFlag(
                    edu.umd.cs.findbugs.ba.vna.ValueNumber.
                      CONSTANT_VALUE)) {
                return;
            }
            edu.umd.cs.findbugs.ba.vna.ValueNumber next =
              factAtLocation.
              getStackValue(
                1);
            if (next.
                  hasFlag(
                    edu.umd.cs.findbugs.ba.vna.ValueNumber.
                      CONSTANT_VALUE)) {
                return;
            }
            edu.umd.cs.findbugs.ba.jsr305.FlowValue topTQ =
              forwardsFact.
              getValue(
                top);
            edu.umd.cs.findbugs.ba.jsr305.FlowValue nextTQ =
              forwardsFact.
              getValue(
                next);
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Comparing values at " +
                    loc.
                      toCompactString(
                        ));
                java.lang.System.
                  out.
                  println(
                    " Comparing " +
                    topTQ +
                    " and " +
                    nextTQ);
            }
            if (topTQ.
                  equals(
                    nextTQ)) {
                return;
            }
            if (edu.umd.cs.findbugs.ba.jsr305.FlowValue.
                  valuesConflict(
                    typeQualifierValue.
                      isStrictQualifier(
                        ) &&
                      !xmethod.
                      isIdentity(
                        ),
                    topTQ,
                    nextTQ)) {
                edu.umd.cs.findbugs.BugInstance warning =
                  new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "TQ_COMPARING_VALUES_WITH_INCOMPATIBLE_TYPE_QUALIFIERS",
                  HIGH_PRIORITY).
                  addClassAndMethod(
                    xmethod);
                annotateWarningWithTypeQualifier(
                  warning,
                  typeQualifierValue);
                for (edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo s
                      :
                      forwardsFact.
                       getWhere(
                         top)) {
                    annotateWarningWithSourceSinkInfo(
                      warning,
                      xmethod,
                      top,
                      s);
                }
                for (edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo s
                      :
                      forwardsFact.
                       getWhere(
                         next)) {
                    annotateWarningWithSourceSinkInfo(
                      warning,
                      xmethod,
                      next,
                      s);
                }
                edu.umd.cs.findbugs.SourceLineAnnotation observedLocation =
                  edu.umd.cs.findbugs.SourceLineAnnotation.
                  fromVisitedInstruction(
                    xmethod.
                      getMethodDescriptor(
                        ),
                    loc);
                warning.
                  add(
                    observedLocation);
                warning.
                  addSomeSourceForTopTwoStackValues(
                    classContext,
                    method,
                    loc);
                bugReporter.
                  reportBug(
                    warning);
            }
        }
    }
    private void checkValueSources(edu.umd.cs.findbugs.ba.XMethod xMethod,
                                   edu.umd.cs.findbugs.ba.CFG cfg,
                                   edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue,
                                   edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow vnaDataflow,
                                   edu.umd.cs.findbugs.ba.jsr305.ForwardTypeQualifierDataflow forwardDataflow,
                                   edu.umd.cs.findbugs.ba.jsr305.BackwardTypeQualifierDataflow backwardDataflow)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
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
            java.util.Set<edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo> sourceSet =
              forwardDataflow.
              getAnalysis(
                ).
              getSourceSinkInfoSet(
                location);
            for (edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo source
                  :
                  sourceSet) {
                edu.umd.cs.findbugs.ba.vna.ValueNumber vn =
                  source.
                  getValueNumber(
                    );
                edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet backwardsFact =
                  backwardDataflow.
                  getFactAtLocation(
                    location);
                edu.umd.cs.findbugs.ba.jsr305.FlowValue backwardsFlowValue =
                  backwardsFact.
                  getValue(
                    vn);
                if (!(backwardsFlowValue ==
                        edu.umd.cs.findbugs.ba.jsr305.FlowValue.
                          ALWAYS ||
                        backwardsFlowValue ==
                        edu.umd.cs.findbugs.ba.jsr305.FlowValue.
                          NEVER)) {
                    continue;
                }
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Checking value source at " +
                        location.
                          toCompactString(
                            ) +
                        " for " +
                        typeQualifierValue);
                    java.lang.System.
                      out.
                      println(
                        "  back=" +
                        backwardsFact);
                    java.lang.System.
                      out.
                      println(
                        "  source=" +
                        source);
                }
                edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet forwardsFact =
                  forwardDataflow.
                  getFactAfterLocation(
                    location);
                edu.umd.cs.findbugs.ba.jsr305.FlowValue forwardsFlowValue =
                  forwardsFact.
                  getValue(
                    vn);
                if (edu.umd.cs.findbugs.ba.jsr305.FlowValue.
                      valuesConflict(
                        typeQualifierValue.
                          isStrictQualifier(
                            ) &&
                          !xMethod.
                          isIdentity(
                            ),
                        forwardsFlowValue,
                        backwardsFlowValue)) {
                    continue;
                }
                if (edu.umd.cs.findbugs.ba.jsr305.FlowValue.
                      backwardsValueConflictsWithSource(
                        backwardsFlowValue,
                        source,
                        typeQualifierValue,
                        xMethod.
                          isIdentity(
                            ))) {
                    java.lang.String bugType =
                      backwardsFlowValue ==
                      edu.umd.cs.findbugs.ba.jsr305.FlowValue.
                        NEVER
                      ? "TQ_MAYBE_SOURCE_VALUE_REACHES_NEVER_SINK"
                      : "TQ_MAYBE_SOURCE_VALUE_REACHES_ALWAYS_SINK";
                    emitSourceWarning(
                      bugType,
                      xMethod,
                      typeQualifierValue,
                      backwardsFlowValue,
                      backwardsFact,
                      source,
                      vn,
                      location);
                }
                else
                    if (source.
                          getWhen(
                            ) ==
                          javax.annotation.meta.When.
                            UNKNOWN &&
                          source.
                          getType(
                            ) ==
                          edu.umd.cs.findbugs.ba.jsr305.SourceSinkType.
                            PARAMETER) {
                        int p =
                          source.
                          getParameter(
                            );
                        edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation directTypeQualifierAnnotation =
                          edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.
                          getDirectTypeQualifierAnnotation(
                            xMethod,
                            p,
                            typeQualifierValue);
                        if (directTypeQualifierAnnotation !=
                              null &&
                              directTypeQualifierAnnotation.
                                when ==
                              javax.annotation.meta.When.
                                UNKNOWN) {
                            java.lang.String bugType =
                              backwardsFlowValue ==
                              edu.umd.cs.findbugs.ba.jsr305.FlowValue.
                                NEVER
                              ? "TQ_EXPLICIT_UNKNOWN_SOURCE_VALUE_REACHES_NEVER_SINK"
                              : "TQ_EXPLICIT_UNKNOWN_SOURCE_VALUE_REACHES_ALWAYS_SINK";
                            emitSourceWarning(
                              bugType,
                              xMethod,
                              typeQualifierValue,
                              backwardsFlowValue,
                              backwardsFact,
                              source,
                              vn,
                              location);
                        }
                    }
                    else
                        if (source.
                              getWhen(
                                ) ==
                              javax.annotation.meta.When.
                                UNKNOWN &&
                              typeQualifierValue.
                              isStrictQualifier(
                                )) {
                            emitDataflowWarning(
                              xMethod,
                              typeQualifierValue,
                              forwardsFact,
                              backwardsFact,
                              vn,
                              forwardsFlowValue,
                              backwardsFlowValue,
                              location,
                              null,
                              vnaDataflow.
                                getFactAtLocation(
                                  location));
                        }
            }
        }
    }
    private edu.umd.cs.findbugs.ba.Location getEdgeTargetLocation(edu.umd.cs.findbugs.ba.CFG cfg,
                                                                  edu.umd.cs.findbugs.ba.Edge edge) {
        edu.umd.cs.findbugs.ba.BasicBlock targetBlock =
          edge.
          getTarget(
            );
        if (targetBlock.
              getFirstInstruction(
                ) !=
              null) {
            return new edu.umd.cs.findbugs.ba.Location(
              targetBlock.
                getFirstInstruction(
                  ),
              targetBlock);
        }
        if (targetBlock.
              isExceptionThrower(
                )) {
            edu.umd.cs.findbugs.ba.BasicBlock fallThroughSuccessor =
              cfg.
              getSuccessorWithEdgeType(
                targetBlock,
                edu.umd.cs.findbugs.ba.EdgeTypes.
                  FALL_THROUGH_EDGE);
            if (fallThroughSuccessor ==
                  null) {
                for (java.util.Iterator<edu.umd.cs.findbugs.ba.Edge> i =
                       cfg.
                       removedEdgeIterator(
                         );
                     i.
                       hasNext(
                         );
                     ) {
                    edu.umd.cs.findbugs.ba.Edge removedEdge =
                      i.
                      next(
                        );
                    if (removedEdge.
                          getSource(
                            ) ==
                          targetBlock &&
                          removedEdge.
                          getType(
                            ) ==
                          edu.umd.cs.findbugs.ba.EdgeTypes.
                            FALL_THROUGH_EDGE) {
                        fallThroughSuccessor =
                          removedEdge.
                            getTarget(
                              );
                        break;
                    }
                }
            }
            if (fallThroughSuccessor !=
                  null &&
                  fallThroughSuccessor.
                  getFirstInstruction(
                    ) !=
                  null) {
                return new edu.umd.cs.findbugs.ba.Location(
                  fallThroughSuccessor.
                    getFirstInstruction(
                      ),
                  fallThroughSuccessor);
            }
        }
        return null;
    }
    private edu.umd.cs.findbugs.ba.Location getEdgeSourceLocation(edu.umd.cs.findbugs.ba.CFG cfg,
                                                                  edu.umd.cs.findbugs.ba.Edge edge) {
        edu.umd.cs.findbugs.ba.BasicBlock sourceBlock =
          edge.
          getSource(
            );
        return sourceBlock.
          getLastInstruction(
            ) !=
          null
          ? new edu.umd.cs.findbugs.ba.Location(
          sourceBlock.
            getLastInstruction(
              ),
          sourceBlock)
          : null;
    }
    private void checkForConflictingValues(edu.umd.cs.findbugs.ba.XMethod xMethod,
                                           edu.umd.cs.findbugs.ba.CFG cfg,
                                           edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue,
                                           edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet forwardsFact,
                                           edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet backwardsFact,
                                           edu.umd.cs.findbugs.ba.Location locationToReport,
                                           edu.umd.cs.findbugs.ba.Location locationWhereDoomedValueIsObserved,
                                           edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame)
          throws edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
        java.util.Set<edu.umd.cs.findbugs.ba.vna.ValueNumber> valueNumberSet =
          new java.util.HashSet<edu.umd.cs.findbugs.ba.vna.ValueNumber>(
          );
        valueNumberSet.
          addAll(
            forwardsFact.
              getValueNumbers(
                ));
        valueNumberSet.
          addAll(
            backwardsFact.
              getValueNumbers(
                ));
        for (edu.umd.cs.findbugs.ba.vna.ValueNumber vn
              :
              valueNumberSet) {
            edu.umd.cs.findbugs.ba.jsr305.FlowValue forward =
              forwardsFact.
              getValue(
                vn);
            edu.umd.cs.findbugs.ba.jsr305.FlowValue backward =
              backwardsFact.
              getValue(
                vn);
            if (!edu.umd.cs.findbugs.ba.jsr305.FlowValue.
                  valuesConflict(
                    typeQualifierValue.
                      isStrictQualifier(
                        ) &&
                      !xMethod.
                      isIdentity(
                        ),
                    forward,
                    backward)) {
                continue;
            }
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Check " +
                    vn +
                    ": forward=" +
                    forward +
                    ", backward=" +
                    backward +
                    " at " +
                    checkLocation);
            }
            emitDataflowWarning(
              xMethod,
              typeQualifierValue,
              forwardsFact,
              backwardsFact,
              vn,
              forward,
              backward,
              locationToReport,
              locationWhereDoomedValueIsObserved,
              vnaFrame);
        }
    }
    private void emitDataflowWarning(edu.umd.cs.findbugs.ba.XMethod xMethod,
                                     edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue,
                                     edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet forwardsFact,
                                     edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet backwardsFact,
                                     edu.umd.cs.findbugs.ba.vna.ValueNumber vn,
                                     edu.umd.cs.findbugs.ba.jsr305.FlowValue forward,
                                     edu.umd.cs.findbugs.ba.jsr305.FlowValue backward,
                                     edu.umd.cs.findbugs.ba.Location locationToReport,
                                     @javax.annotation.CheckForNull
                                     edu.umd.cs.findbugs.ba.Location locationWhereDoomedValueIsObserved,
                                     edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame)
          throws edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
        java.lang.String bugType;
        if (typeQualifierValue.
              isStrictQualifier(
                ) &&
              forward ==
              edu.umd.cs.findbugs.ba.jsr305.FlowValue.
                UNKNOWN) {
            bugType =
              "TQ_UNKNOWN_VALUE_USED_WHERE_ALWAYS_STRICTLY_REQUIRED";
        }
        else
            if (backward ==
                  edu.umd.cs.findbugs.ba.jsr305.FlowValue.
                    NEVER) {
                bugType =
                  "TQ_ALWAYS_VALUE_USED_WHERE_NEVER_REQUIRED";
            }
            else {
                bugType =
                  "TQ_NEVER_VALUE_USED_WHERE_ALWAYS_REQUIRED";
            }
        edu.umd.cs.findbugs.BugInstance warning =
          new edu.umd.cs.findbugs.BugInstance(
          this,
          bugType,
          edu.umd.cs.findbugs.Priorities.
            NORMAL_PRIORITY).
          addClassAndMethod(
            xMethod);
        annotateWarningWithTypeQualifier(
          warning,
          typeQualifierValue);
        java.util.Set<? extends edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo> sourceSet =
          forward ==
          edu.umd.cs.findbugs.ba.jsr305.FlowValue.
            ALWAYS
          ? forwardsFact.
          getWhereAlways(
            vn)
          : forwardsFact.
          getWhereNever(
            vn);
        for (edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo source
              :
              sourceSet) {
            annotateWarningWithSourceSinkInfo(
              warning,
              xMethod,
              vn,
              source);
        }
        java.util.Set<? extends edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo> sinkSet =
          backward ==
          edu.umd.cs.findbugs.ba.jsr305.FlowValue.
            ALWAYS
          ? backwardsFact.
          getWhereAlways(
            vn)
          : backwardsFact.
          getWhereNever(
            vn);
        edu.umd.cs.findbugs.ba.Location sinkLocation =
          getSinkLocation(
            sinkSet);
        if (sinkLocation ==
              null) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Unable to compute sink location for " +
                xMethod);
            return;
        }
        if (locationWhereDoomedValueIsObserved !=
              null) {
            org.apache.bcel.classfile.Method method =
              edu.umd.cs.findbugs.classfile.Global.
              getAnalysisCache(
                ).
              getMethodAnalysis(
                org.apache.bcel.classfile.Method.class,
                xMethod.
                  getMethodDescriptor(
                    ));
            edu.umd.cs.findbugs.LocalVariableAnnotation localVariable =
              edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
              findLocalAnnotationFromValueNumber(
                method,
                locationWhereDoomedValueIsObserved,
                vn,
                vnaFrame);
            if (localVariable !=
                  null &&
                  !localVariable.
                  equals(
                    warning.
                      getPrimaryLocalVariableAnnotation(
                        ))) {
                localVariable.
                  setDescription(
                    localVariable.
                      isSignificant(
                        )
                      ? "LOCAL_VARIABLE_VALUE_DOOMED_NAMED"
                      : "LOCAL_VARIABLE_VALUE_DOOMED");
                warning.
                  add(
                    localVariable);
            }
            if (!sinkLocation.
                  equals(
                    locationToReport)) {
                edu.umd.cs.findbugs.SourceLineAnnotation observedLocation =
                  edu.umd.cs.findbugs.SourceLineAnnotation.
                  fromVisitedInstruction(
                    xMethod.
                      getMethodDescriptor(
                        ),
                    locationToReport);
                observedLocation.
                  setDescription(
                    "SOURCE_LINE_VALUE_DOOMED");
                warning.
                  add(
                    observedLocation);
            }
        }
        for (edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo sink
              :
              sinkSet) {
            annotateWarningWithSourceSinkInfo(
              warning,
              xMethod,
              vn,
              sink);
        }
        bugReporter.
          reportBug(
            warning);
    }
    private void emitSourceWarning(java.lang.String bugType,
                                   edu.umd.cs.findbugs.ba.XMethod xMethod,
                                   edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue,
                                   edu.umd.cs.findbugs.ba.jsr305.FlowValue backwardsFlowValue,
                                   edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValueSet backwardsFact,
                                   edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo source,
                                   edu.umd.cs.findbugs.ba.vna.ValueNumber vn,
                                   edu.umd.cs.findbugs.ba.Location location) {
        edu.umd.cs.findbugs.BugInstance warning =
          new edu.umd.cs.findbugs.BugInstance(
          this,
          bugType,
          edu.umd.cs.findbugs.Priorities.
            NORMAL_PRIORITY).
          addClassAndMethod(
            xMethod);
        annotateWarningWithTypeQualifier(
          warning,
          typeQualifierValue);
        annotateWarningWithSourceSinkInfo(
          warning,
          xMethod,
          vn,
          source);
        java.util.Set<? extends edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo> sinkSet =
          backwardsFlowValue ==
          edu.umd.cs.findbugs.ba.jsr305.FlowValue.
            NEVER
          ? backwardsFact.
          getWhereNever(
            vn)
          : backwardsFact.
          getWhereAlways(
            vn);
        for (edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo sink
              :
              sinkSet) {
            annotateWarningWithSourceSinkInfo(
              warning,
              xMethod,
              vn,
              sink);
        }
        bugReporter.
          reportBug(
            warning);
    }
    private void annotateWarningWithTypeQualifier(edu.umd.cs.findbugs.BugInstance warning,
                                                  edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> typeQualifierValue) {
        if (edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
              hasMultipleVariants(
                typeQualifierValue)) {
            java.lang.StringBuilder buf =
              new java.lang.StringBuilder(
              );
            buf.
              append(
                "@");
            buf.
              append(
                typeQualifierValue.
                  typeQualifier.
                  getDottedClassName(
                    ));
            buf.
              append(
                "(");
            buf.
              append(
                typeQualifierValue.
                  value);
            buf.
              append(
                ")");
            warning.
              addString(
                buf.
                  toString(
                    )).
              describe(
                edu.umd.cs.findbugs.StringAnnotation.
                  TYPE_QUALIFIER_ROLE);
        }
        else {
            warning.
              addClass(
                typeQualifierValue.
                  typeQualifier).
              describe(
                edu.umd.cs.findbugs.ClassAnnotation.
                  TYPE_QUALIFIER_ROLE);
        }
    }
    private void annotateWarningWithSourceSinkInfo(edu.umd.cs.findbugs.BugInstance warning,
                                                   edu.umd.cs.findbugs.ba.XMethod xMethod,
                                                   edu.umd.cs.findbugs.ba.vna.ValueNumber vn,
                                                   edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo sourceSinkInfo) {
        edu.umd.cs.findbugs.classfile.MethodDescriptor methodDescriptor =
          xMethod.
          getMethodDescriptor(
            );
        switch (sourceSinkInfo.
                  getType(
                    )) {
            case PARAMETER:
                try {
                    org.apache.bcel.classfile.Method method =
                      edu.umd.cs.findbugs.classfile.Global.
                      getAnalysisCache(
                        ).
                      getMethodAnalysis(
                        org.apache.bcel.classfile.Method.class,
                        methodDescriptor);
                    edu.umd.cs.findbugs.LocalVariableAnnotation lva =
                      edu.umd.cs.findbugs.LocalVariableAnnotation.
                      getParameterLocalVariableAnnotation(
                        method,
                        sourceSinkInfo.
                          getLocal(
                            ));
                    lva.
                      setDescription(
                        lva.
                          isSignificant(
                            )
                          ? edu.umd.cs.findbugs.LocalVariableAnnotation.
                              PARAMETER_VALUE_SOURCE_NAMED_ROLE
                          : edu.umd.cs.findbugs.LocalVariableAnnotation.
                              PARAMETER_VALUE_SOURCE_ROLE);
                    warning.
                      add(
                        lva);
                }
                catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                    warning.
                      addSourceLine(
                        methodDescriptor,
                        sourceSinkInfo.
                          getLocation(
                            )).
                      describe(
                        "SOURCE_LINE_VALUE_SOURCE");
                }
                break;
            case CONSTANT_VALUE:
                java.lang.Object constantValue =
                  sourceSinkInfo.
                  getConstantValue(
                    );
                if (constantValue instanceof java.lang.String) {
                    warning.
                      addString(
                        (java.lang.String)
                          constantValue).
                      describe(
                        edu.umd.cs.findbugs.StringAnnotation.
                          STRING_CONSTANT_ROLE);
                }
                else
                    if (constantValue instanceof java.lang.Integer) {
                        warning.
                          addInt(
                            (java.lang.Integer)
                              constantValue).
                          describe(
                            edu.umd.cs.findbugs.IntAnnotation.
                              INT_VALUE);
                    }
                    else
                        if (constantValue ==
                              null) {
                            warning.
                              addString(
                                "null").
                              describe(
                                edu.umd.cs.findbugs.StringAnnotation.
                                  STRING_NONSTRING_CONSTANT_ROLE);
                        }
                        else {
                            warning.
                              addString(
                                constantValue.
                                  toString(
                                    )).
                              describe(
                                edu.umd.cs.findbugs.StringAnnotation.
                                  STRING_NONSTRING_CONSTANT_ROLE);
                        }
                break;
            case RETURN_VALUE_OF_CALLED_METHOD:
            case FIELD_LOAD:
                warning.
                  addSourceLine(
                    methodDescriptor,
                    sourceSinkInfo.
                      getLocation(
                        )).
                  describe(
                    "SOURCE_LINE_VALUE_SOURCE");
                break;
            case ARGUMENT_TO_CALLED_METHOD:
            case RETURN_VALUE:
            case FIELD_STORE:
                warning.
                  addSourceLine(
                    methodDescriptor,
                    sourceSinkInfo.
                      getLocation(
                        ));
                return;
            default:
                throw new java.lang.IllegalStateException(
                  );
        }
    }
    @javax.annotation.CheckForNull
    private edu.umd.cs.findbugs.ba.Location getSinkLocation(edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo sourceSinkInfo) {
        switch (sourceSinkInfo.
                  getType(
                    )) {
            case ARGUMENT_TO_CALLED_METHOD:
            case RETURN_VALUE:
            case FIELD_STORE:
                return sourceSinkInfo.
                  getLocation(
                    );
            default:
                return null;
        }
    }
    @javax.annotation.CheckForNull
    private edu.umd.cs.findbugs.ba.Location getSinkLocation(java.lang.Iterable<? extends edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo> info) {
        for (edu.umd.cs.findbugs.ba.jsr305.SourceSinkInfo s
              :
              info) {
            edu.umd.cs.findbugs.ba.Location l =
              getSinkLocation(
                s);
            if (l !=
                  null) {
                return l;
            }
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1bC3AcRXruXcmSLNnWw0/8kF/ClI3ZBQOmjDjHsh5YsHpg" +
       "yVKQD69Hsy1prN2ZYaZXXpnzHbiKw3cXiAHDcYRzLjkoHsVhKoFcLgTK1F14" +
       "BEjlHC7YdzkgCakzr3DOFVwqJEf+v3tm57EzK60P4appj7r7/7v/7//7///u" +
       "nn38QzLLNEgjVVmMTerUjLWrrFcyTJpqTUum2Q91SfnbZdJv9pzp3hIlFUNk" +
       "3phkdsmSSTsUmk6ZQ2SFoppMUmVqdlOaQopeg5rUmJCYoqlDZKFidmb0tCIr" +
       "rEtLUewwIBkJUi8xZijDWUY7LQaMrEjATOJ8JvEWf3NzgsyRNX3S6b7E1b3V" +
       "1YI9M85YJiN1iX3ShBTPMiUdTygma84Z5EJdS0+OpjUWozkW25e+3ILgmsTl" +
       "BRCsebL2k0+PjNVxCOZLqqoxLp65k5paeoKmEqTWqW1P04x5I/kqKUuQGldn" +
       "RpoS9qBxGDQOg9rSOr1g9nOpms20alwcZnOq0GWcECOrvUx0yZAyFptePmfg" +
       "UMUs2TkxSLsqL62QskDEey6MH/32nrq/KCO1Q6RWUftwOjJMgsEgQwAozQxT" +
       "w2xJpWhqiNSroOw+aihSWjlgabrBVEZViWVB/TYsWJnVqcHHdLACPYJsRlZm" +
       "mpEXb4QblPXXrJG0NAqyLnJkFRJ2YD0IWK3AxIwRCezOIikfV9QUIyv9FHkZ" +
       "m66FDkBamaFsTMsPVa5KUEEahImkJXU03gemp45C11kaGKDByNJQpoi1Lsnj" +
       "0ihNokX6+vWKJug1mwOBJIws9HfjnEBLS31acunnw+6r7rhJ3aFGSQTmnKJy" +
       "GudfA0SNPqKddIQaFNaBIJyzIXGvtOjZw1FCoPNCX2fR54dfObttY+OJl0Sf" +
       "ZQF9eob3UZkl5QeH5/10eev6LWU4jSpdMxVUvkdyvsp6rZbmnA4eZlGeIzbG" +
       "7MYTO1+4/ubH6PtRUt1JKmQtnc2AHdXLWkZX0tS4mqrUkBhNdZLZVE218vZO" +
       "UgnvCUWlorZnZMSkrJOUp3lVhcb/BohGgAVCVA3vijqi2e+6xMb4e04nhFTC" +
       "Q+bAM0TEP/4/IzQ+pmVoXJIlVVG1eK+hofxmHDzOMGA7Fh8BYxrOjppx05Dj" +
       "3HRoKhvPZlJx2XQaU5QBWbx1jMrjCON1WVgwYOmGGUMa/YsaKIcSz98fiYAy" +
       "lvtdQRpW0Q4tnaJGUj6a3d5+9onkK8LMcGlYWDESg3FjMG5MNmP2uDExbixg" +
       "XBKJ8OEW4PhC76C1cVj/4IDnrO+74Zq9h9eUgcHp+8sBcuy6xhOIWh0nYXv2" +
       "pHy8Ye6B1W9e8uMoKU+QBklmMB7GlRZjFDyWPG4t6jnDEKKcSLHKFSkwxBma" +
       "DMIYNCxiWFyqtAlqYD0jC1wc7DiGKzYeHkUC509O3Lf/loGvXRwlUW9wwCFn" +
       "gV9D8l506XnX3eR3CkF8a28788nxew9qjnvwRBs7SBZQogxr/Abhhycpb1gl" +
       "PZ189mATh302uG8mwXIDz9joH8PjfZptT46yVIHAI5qRkdLYZGNczcYMbb9T" +
       "wy21nr8vALOoweXYCM+otT75/9i6SMdysbBstDOfFDxSfKlP/+6pf3j3Ug63" +
       "HVRqXdlAH2XNLkeGzBq4y6p3zLbfoBT6/fK+3rvv+fC23dxmocfaoAGbsGwF" +
       "BwYqBJhvfenG02+9+eDrUcfOGUTy7DAkRLm8kFhPqosICaOtc+YDjjANiw6t" +
       "pmmXCvYJC04aTlNcWP9be/4lT39wR52wgzTU2Ga0cWoGTv1528nNr+z5bSNn" +
       "E5ExEDuYOd2Ed5/vcG4xDGkS55G75eSK77wofRfiBPhmUzlAubuNWGsdJ7UE" +
       "gnWQS9meHd1Jdc2AyMuVeznvfTEvL0NgOA/C27Zgcb7pXiTedehKrJLykdd/" +
       "PXfg18+d5VJ5MzO3TXRJerMwQyzW5YD9Yr8T2yGZY9DvshPdX65Ln/gUOA4B" +
       "RxnSEbPHAE+a81iQ1XtW5c+f//GivT8tI9EOUp3WpFSHxBcjmQ2rgJpj4IRz" +
       "+h9sE0awvwqKOi4qKRC+oAIVsTJYxe0ZnXGlHPjrxU9d9fCxN7k16oLHMk4/" +
       "G+OCx/vy/N5xAI/90xU/e/jOe/eLDGF9uNfz0S35n5708KF/++8CyLm/C8he" +
       "fPRD8ccfWNq69X1O7zgepG7KFcYycN4O7abHMh9H11T8XZRUDpE62cqnB6R0" +
       "FpfzEOSQpp1kQ87taffmgyL5ac471uV+p+ca1u/ynBgK79gb3+f6vNx5qMKd" +
       "8Oy2HMBuv5eLEP5yLSe5gJcbsLiIq6+MkUrdUGDPBTOvMHnqzmAeiiqlfW5m" +
       "SZFRgKStffuuq72hGMNdX3bYhLCpZMBLTliJ5abevfLhpt53hEmcF0Ag+i18" +
       "JH77wBv7XuU+uAoDc78NgyvsQgB3BYA6MenP4F8Ent/hg5PFCpGgNbRaWeKq" +
       "fJqIJl3UNn0CxA82vDX+wJkfCAH8hujrTA8f/eZnsTuOCscq9hprC9J9N43Y" +
       "bwhxsBjE2a0uNgqn6PjV8YPPPHLwNjGrBm/m3A4bwx/88/+9Grvv7ZcDUrTK" +
       "YU1LU0nNe4dIPrda4NWPEKrtG7V/e6ShrAPCeiepyqrKjVnamfIabaWZHXYp" +
       "zNnHOIZsiYfKYSSyAfQggjKWV2KREEb4pVDX1u5dCil4brCM9IaQpTAashTw" +
       "tQeLXiyuCzD/MM6MzOPmn2xr6W/pSPQMYu2AT5SxEkWZgCdpDZgMEUU7Z1HC" +
       "ODMy3ytKsqunrd0Ou3U8TqBri4mtrk9GvUQZR+CRrJlIITJOnrOMYZzBB3T3" +
       "dHfvSiSSLd3dPf0t/Z093diS9YlzoERx+uGRrUHlEHFuOWdxwjiD4+5q79/R" +
       "0xYkwqHpi9CAtRvgodZANESEbwSLEM2L4J99fRGmjNQMO3kbVm32ifDN6YvA" +
       "R8OXcWu08RAR7gwWgfgmXl6EFThNGTevNBW02u8qcdK4U8lYI2VCJv0dMWks" +
       "jhbOM4yaQbowpmXTqZ1ZtQXC+qSpmEEzvn/6M8ZjD7Ianp9YY/4kZMbfC4Y5" +
       "wi3Fh3VNEX4MsizEOqHJkr3b8lv6nxWZf85B7sL8qPxfBfGd4LhGdaW5BEPw" +
       "irBDNh5+Hzx09Fiq56FLotYOYw+D5FzTL0rTCZp2sapFTp6MuYsfKzrp5y/n" +
       "3fXvP2oa3V7KUQXWNU5xGIF/r4TUYEN4ouOfyouH3lvav3VsbwmnDit9KPlZ" +
       "Ptr1+MtXr5PvivIzVJEXF5y9eomavYlFtUFZ1lC9qcRa786/GS3A0ut+v3U6" +
       "lhNsmrGAHXYYM98e07dPvShon8qP4/GUUVhQGzVlQ9FhO8cn9qPiHDdPwVG4" +
       "JHuht+dkqqPCOOtnsfhLRqonFFNhfHDO9nosBoXQNzBSPqEpKWdhPeVdWHPy" +
       "Cys/pwYnLegBWzOUFC2yFqezJ8WKVp3XH8/rYh62dcFzj6WLe0pRLCxH3dDw" +
       "0JGmfPqdW4SnTxtREepsyQOPNh1tCDN2FGyTLQ0iG5ZirR1XcxlOBtsA/vkc" +
       "73AKi1cg7+SaFMMAMdY+72ju1VDNYfULM6EjHhr2wfNzC89TRXSExfcLo8Cp" +
       "EFIfKBV8IhU2po0hmP6hQAd7/QwP3wK2m7xwXZloX66v+fMn+qi1vwugcHW+" +
       "45m/GRq6oE4WnYO2v757lUcerpJ/kXnhHTtQ7MojkL9T2GohwP9nZPTzOeof" +
       "luL7TOPSiy+Pew7c+bmFfavwRQ2VK4iCflz/tXt5tTbeWy9wLRKz/IS3K8de" +
       "+/uPa28JOnHid54WqZ/u9KmyTTWs6Y95rCvH4Ip6qUmQWSb2xMuA0PtTzkts" +
       "2edh8X7ONsuLQ8xSwBMrhAfpfuPdd9voJOXcwv4F6+dc97aQbfUUoCTlzkyy" +
       "7+nTt23mW/5a7izEXbu43l7kud6271iaPde+gbAl5TPHb39p9XsD8/l9nkAI" +
       "Z44Hu/j/VsutRLhbiRJxlrDMI5M1D36CnJRf3ahcUfUvrz8qRDs/RDQvzVce" +
       "+N1r7x588+UyUgFpAeYSkkEhbQDHHHZh7mbQ1A9vbUAFCcY8QQ17Wm4Sluob" +
       "8rX5uw0I6mG8+UlR4Q1RdVrbT43tWlblXqjJl81kdd3dyo2oNu8TViGKl/l9" +
       "ArZ+wL3ih7mvGmTjNNDKC2vxwf0eAD3Pid14RuRuBHcwvzXR0teX7L++tz05" +
       "0LKzs2V7op0bqA6NkZb8cbzDxMkRXUfouNrDNDqopFOtkpESi/Chz2av3bb4" +
       "5Sv5IiwEbgqwLsKpx+AZtMQYFA5UnVGv1qLjZyoiL7b96Bc8orXqvEc04vQ5" +
       "5z6ud8VxV04h571VS3Fv1aEZ+y1V5efSJjFpBBQlbiQmbU7bi3PaDvuY6bIK" +
       "TLKA1YQqxbjL7M7iJyY2NbeJd6bIoCJL8PUtyKD4xjI/BV8G9fZUm+JzTZFg" +
       "fxKZJXhGykpOkQRJAGlwioR//gdPgLB4D8VfaIN75blr3GbR/HuomutibfEk" +
       "OyyE2jwKNjuOltdj0WgfH9gEXiVHVs6UkveAhlosTW0rXcnbQkinpWQbvEtL" +
       "zT/6KMu79RBa+xjG7nfh9BZoByQRlKtlc+jqjGzgHbZicQkjC7jewAjbb8RJ" +
       "ssl+KvIMl/o2zeQatbb9kWzp6suGkE5/jWLRhMU6Dkpn8DLhqDkmfy0WbYzU" +
       "c+iESrWsYX3v5sKtfQZwW4htG0DopyzhnyodtzDSUOlhX2cZ4rIQQ2xPjQrD" +
       "G/AxcX0SEBnC4jpGFo5ShgT9kgFvriPHyBYHvJ0zCd5JC4GTpYMXRloEPBRn" +
       "kCNAi6CDVz2RvQ46wqZC0JFmakmqINppS8Q3SkfnjRBSn9xVfCJVAUvyinyx" +
       "JV/wbV/EmCrhQLcVyTBynu3SWjV1BLI4BpsLvkr961OdKRCPwLzOWkh8VDqI" +
       "H4WQ+gCo5hOpzoPows9eruumFzfs7hdMkapAZLd30JFDQTr62lQ6uhWLA7Dt" +
       "oRmF2dnCoGSo1lWnSzs3zZR2GmFdXiZ4RjeVrB1BEkAabuJZr4oOeVS0sTjm" +
       "wgv0Kep4p/hSNnIzx5yjeaSIOzmKxbcgSiHSgkswzn80UzjrAFKbBVZb6TiH" +
       "kRZPZcO+W3Nf47zHAfrTIuB9H4v7GVllbbZt6AYVNuZJ6HxY/slMYQlBK2pt" +
       "uaMDpWM5EELqg6CcT6QcJfmebbPC3u7ksDxRBLInsXiUkdUBkBUYsRuzx2YA" +
       "M7xvIMtB4K9bgn+9dMxutUhvLY6ZK7MWID1TBCS8H4r8FSO1EOMRjpDo/sMp" +
       "L4RW8DMJ91lQqxX0urPpdDignwOkRy1cjpYO6d0W6d3TgpT//SvBhX9dFvy5" +
       "2RLna8BORg08iRMXRPZ3lP+JkL6WP4Fx3aXZ/bHDP/L2j3kZdLaK9Z/+XpPB" +
       "Ucr4UPxsr9+eUOGBErZEqqYcbL7nY+n8OLqwxemcSvE5vVLEYN/G4oUpDfbF" +
       "Yvdgkec/F3vM4WFp4Y8Z8OvaJQU/oRI/+5GfOFZbtfjYrjf4RX/+pzlzEqRq" +
       "BJaJ+/tP13uFbtARhZvzHPE1qNDduyHXiuKHFoxUiBeuvDOC5APMdApJGIxv" +
       "vbp7f8RItdObkajsaf4vRiqtZkbKoHQ3fgxV0Iivn+SPKpsCcwuZpvEetI3P" +
       "VjNykUJD4UdzC6dyzK4vN9aG3mZ0ZcVP35Ly8WPXdN90dvND4ot/sNYDB5BL" +
       "TYJUih8fcKZlBdcubm42r4od6z+d9+Ts8+0rvnoxYccFLXOMmLSCHepoJ0t9" +
       "n8ObTfmv4k8/eNVzrx2uOBklkd0kIoHedhd+ZpzTswZZsTtR+MGmfQfQvP7+" +
       "ya0bRz76Bf+Qm4hLmeXh/ZPy0N2nOp8c/+02/kurWaAkmuPfP7dNqjupPGF4" +
       "vv4MvkOZ67lDYWRN4cevU96ZzE2QGqdGaKLoNQoSODWW6rAcxmIwJ1xUWTLR" +
       "peuWyyqbpfO1LAc7Iyijs/krvlX/P/O8K+4DOwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "om22psSq34PFSXmB+4hJB1uf8ddRWw+T");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("xO1sjahpaiNbDlAJBBSAFmLCh42aM2kkpkihTSL2WbdT0zzc73J+1RE9bhvV" +
       "txJb67odbWZJMLvUpyFWxUgblZVkIIWwT+tTrhLxS3e9SCtDPYADyAS7lv42" +
       "QzZLXeb69NYdZoq64Kwet7Cj9dZrVYTtMkQ7QwWbSkqDt3o2KzGSSpfF+tiA" +
       "m9seaoR8P8HaPThtdqeOoyhS3EDn03EiDRq9bA5Fzmg+cbBhLYgTeUQE4ggh" +
       "SWq1aOAq35ioA8PVFYXB60nTjoiMBZh50cwSbE3AbEyYR2yyzWpzdNTMgFbF" +
       "GDxsKwuv3NZGWRILZkrNG9KwORL7RJXHcK7Vg8NWh6OrJD1ilwHhQ9EooGBW" +
       "bBGjQbvqAEOcVZKQCTTCWnhr2mY3VXUZzOmGVhEbWp1fBDwEcSlmztpaJ90g" +
       "NZby5BZGs4tKy2KBzjBS3WHKA5tqiCDozuryTIKUHsFAVG1ZtyWNkodtCSrP" +
       "AgYT1BAWmCwKwQ5UoLsYGUrkajVXFarpzctei6ZW60x3VS4lkXRKkfMx1IV9" +
       "ISAMpTNPtYWtq1Cnno5gsRPA85bUolN5MBEgn+1DZaRr0B1JiY3lPFwaMDuD" +
       "ysHW2ZIrFux95UEZiplqPekoMcqaUrrtMWR1NSa0ZNObWcmw1/EzwcL0JCVo" +
       "HEGZkYYGg24/S1MlaBotth9rtGLLy0g24JS1VrFkK0O/N6kbC+AG+1bqlTlm" +
       "GES4uk6kICX1uF9npsvxxhYGBCxoW7yhbbZDOB235W7dlSqSOmXqCLVpicxM" +
       "G7crWjomYD+GovGcwBCw/5kPBMtsGepQcjBNTRQXrgGd1RrbstYu81GrXAlT" +
       "z8/mqtqhZvTIpTi8pwf+oBK3AZIKb7gpbLcgfTzdhlktoTHbsbWK3fd7YHXW" +
       "ylKw5aO1JEV8zJZHIC6aGJOUaZY3ckVht80GZpQnLmxSrj4zIYnZVMY1jw5a" +
       "KlSu1CA7CUUZtd2EMZimNl4tk4DpduA0hUepTUuNpkPMRXYMq3oqtBvSlqxN" +
       "uiutKw8pfzzxOZoQxUaIqpnbXw+qmSDyFBvoibjZrJTAoKsUqjb7G2sZQXaY" +
       "OjOIgejWsAwT9BpF89vs//j2bv8/VDzVOMrB/Bs8z9hdejwvXnX0BKj4u1w6" +
       "k7d34gnQiZSOUv4c/WUXpVYWz9A/9s6nPqrRH69e2j+0YuLSvbEfvMHRU905" +
       "MdQVMNLrLs4XGBWZpccpGr/5zu+8hP8p8223kaD28jN0nh3yn48++eXuq9W/" +
       "e6l0x1HCxg05r6c7PXE6TeO+UI+T0ONPJWu87HSS2BO5DPbIrs8+WzuW3fkP" +
       "1l6zk/2ZTKMz2UpvOC9bqchwzhM3d+Ih9EgNrSD2d7lLv37zERu3GHH3TPTw" +
       "CSSZqXqQy6IY+l/lxa/GpftSK7LiYvJzH06lvqUda+1nT2vt/Udae0TTw8dP" +
       "1ehUD0NL02+i6DdmJhUVnzmSzQN55QgcH9zL5oO3Ixug00Ho5/maunauiC7t" +
       "HnIfEn9uwucxoDslO5bRYbeXnNdNka/hnZ1T+J3zxZj//HzR4Pfz4stx6YFC" +
       "GLtpQOe89gvH4P/WheDn1b/xTGAuHi8vwfGHe5i/frsmQJ6L7+WiweVDoB69" +
       "AKjZjuW81ddu7m+4RIniE0niv2h99Ld/68+vvGOXCnQ6sal4T2Df9Wy/b3z9" +
       "jtpz4qvvL/zUnYocFZ7hHqp0V5S3jEuPXfzOQTHWLmvpOUcIHqVV/9QeweL/" +
       "uLR4drKdFRlaRmG9gkCnco6L3LbDxOof1VTZoTgrF4hz1/3ajd3zft85leJ1" +
       "voCvq333Ove5b7y7UWRwXSnMQtf4/Ssep/NJj3Osnzj12se5KnBd/fanf/FL" +
       "j39n+rwin38n7ZwsJAsKtlp7AzooDOhSaZen/aoLCN5TVKS/Xld/5iN//dt/" +
       "/OQ3v3xH6TJYdPKVSg51sCgBx3LRazAnB7jKgzMC9ALL1wO73pa3KJR2r5wP" +
       "H9UeJVmDdeWisYt0vjO52PmLJI6/1kPMT7zC4B49s1YmQXDyaqHm9x+p+WM5" +
       "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");
}
