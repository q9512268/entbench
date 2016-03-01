package edu.umd.cs.findbugs.ba.npe;
public class NullDerefAndRedundantComparisonFinder {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fnd.debug");
    private static final boolean PRUNE_GUARANTEED_DEREFERENCES = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fnd.prune",
        true);
    private static final boolean DEBUG_DEREFS = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fnd.derefs.debug");
    private final edu.umd.cs.findbugs.ba.ClassContext classContext;
    private final org.apache.bcel.classfile.Method method;
    private final edu.umd.cs.findbugs.ba.npe.NullDerefAndRedundantComparisonCollector
      collector;
    private final boolean findGuaranteedDerefs;
    private final java.util.List<edu.umd.cs.findbugs.ba.npe.RedundantBranch>
      redundantBranchList;
    private final java.util.BitSet definitelySameBranchSet;
    private final java.util.BitSet definitelyDifferentBranchSet;
    private final java.util.BitSet undeterminedBranchSet;
    private final java.util.BitSet lineMentionedMultipleTimes;
    private edu.umd.cs.findbugs.ba.npe.IsNullValueDataflow
      invDataflow;
    private edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow
      vnaDataflow;
    private edu.umd.cs.findbugs.ba.deref.UnconditionalValueDerefDataflow
      uvdDataflow;
    private final edu.umd.cs.findbugs.ba.AssertionMethods
      assertionMethods;
    static { if (DEBUG) { java.lang.System.out.println(
                                                 "fnd.debug enabled");
             } }
    public NullDerefAndRedundantComparisonFinder(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                                 org.apache.bcel.classfile.Method method,
                                                 edu.umd.cs.findbugs.ba.npe.NullDerefAndRedundantComparisonCollector collector) {
        super(
          );
        this.
          classContext =
          classContext;
        this.
          method =
          method;
        this.
          collector =
          collector;
        this.
          findGuaranteedDerefs =
          classContext.
            getAnalysisContext(
              ).
            getBoolProperty(
              edu.umd.cs.findbugs.ba.AnalysisFeatures.
                TRACK_GUARANTEED_VALUE_DEREFS_IN_NULL_POINTER_ANALYSIS);
        this.
          lineMentionedMultipleTimes =
          classContext.
            linesMentionedMultipleTimes(
              method);
        this.
          redundantBranchList =
          new java.util.LinkedList<edu.umd.cs.findbugs.ba.npe.RedundantBranch>(
            );
        this.
          definitelySameBranchSet =
          new java.util.BitSet(
            );
        this.
          definitelyDifferentBranchSet =
          new java.util.BitSet(
            );
        this.
          undeterminedBranchSet =
          new java.util.BitSet(
            );
        this.
          assertionMethods =
          classContext.
            getAssertionMethods(
              );
    }
    public void execute() { edu.umd.cs.findbugs.log.Profiler profiler =
                              edu.umd.cs.findbugs.classfile.Global.
                              getAnalysisCache(
                                ).
                              getProfiler(
                                );
                            profiler.start(
                                       this.
                                         getClass(
                                           ));
                            try { this.invDataflow =
                                    classContext.
                                      getIsNullValueDataflow(
                                        method);
                                  this.vnaDataflow =
                                    classContext.
                                      getValueNumberDataflow(
                                        method);
                                  if (findGuaranteedDerefs) {
                                      if (DEBUG_DEREFS) {
                                          java.lang.System.
                                            out.
                                            println(
                                              "Checking for guaranteed derefs in " +
                                              classContext.
                                                getClassDescriptor(
                                                  ).
                                                getDottedClassName(
                                                  ) +
                                              "." +
                                              method.
                                                getName(
                                                  ) +
                                              method.
                                                getSignature(
                                                  ));
                                      }
                                      this.
                                        uvdDataflow =
                                        classContext.
                                          getUnconditionalValueDerefDataflow(
                                            method);
                                  }
                                  examineBasicBlocks(
                                    );
                                  if (findGuaranteedDerefs) {
                                      examineNullValues(
                                        );
                                  }
                                  examineRedundantBranches(
                                    ); }
                            catch (edu.umd.cs.findbugs.ba.MissingClassException e) {
                                edu.umd.cs.findbugs.ba.AnalysisContext.
                                  reportMissingClass(
                                    e.
                                      getClassNotFoundException(
                                        ));
                            }
                            catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                                edu.umd.cs.findbugs.ba.AnalysisContext.
                                  logError(
                                    "Error while checking guaranteed derefs in " +
                                    classContext.
                                      getClassDescriptor(
                                        ).
                                      getDottedClassName(
                                        ) +
                                    "." +
                                    method.
                                      getName(
                                        ) +
                                    method.
                                      getSignature(
                                        ),
                                    e);
                            }
                            finally { profiler.
                                        end(
                                          this.
                                            getClass(
                                              ));
                            } }
    private void examineBasicBlocks() throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        edu.umd.cs.findbugs.ba.CFGBuilderException {
        java.util.Iterator<edu.umd.cs.findbugs.ba.BasicBlock> bbIter =
          invDataflow.
          getCFG(
            ).
          blockIterator(
            );
        while (bbIter.
                 hasNext(
                   )) {
            edu.umd.cs.findbugs.ba.BasicBlock basicBlock =
              bbIter.
              next(
                );
            if (basicBlock.
                  isNullCheck(
                    )) {
                analyzeNullCheck(
                  invDataflow,
                  basicBlock);
            }
            else
                if (!basicBlock.
                      isEmpty(
                        )) {
                    org.apache.bcel.generic.InstructionHandle lastHandle =
                      basicBlock.
                      getLastInstruction(
                        );
                    org.apache.bcel.generic.Instruction last =
                      lastHandle.
                      getInstruction(
                        );
                    switch (last.
                              getOpcode(
                                )) {
                        case org.apache.bcel.Constants.
                               IF_ACMPEQ:
                        case org.apache.bcel.Constants.
                               IF_ACMPNE:
                            analyzeRefComparisonBranch(
                              basicBlock,
                              lastHandle);
                            break;
                        case org.apache.bcel.Constants.
                               IFNULL:
                        case org.apache.bcel.Constants.
                               IFNONNULL:
                            analyzeIfNullBranch(
                              basicBlock,
                              lastHandle);
                            break;
                        default:
                            break;
                    }
                }
        }
    }
    private void examineNullValues() throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        java.util.Set<edu.umd.cs.findbugs.ba.npe.LocationWhereValueBecomesNull> locationWhereValueBecomesNullSet =
          invDataflow.
          getAnalysis(
            ).
          getLocationWhereValueBecomesNullSet(
            );
        if (DEBUG_DEREFS) {
            java.lang.System.
              out.
              println(
                "----------------------- examineNullValues " +
                locationWhereValueBecomesNullSet.
                  size(
                    ));
        }
        java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,java.util.SortedSet<edu.umd.cs.findbugs.ba.Location>> bugStatementLocationMap =
          new java.util.HashMap<edu.umd.cs.findbugs.ba.vna.ValueNumber,java.util.SortedSet<edu.umd.cs.findbugs.ba.Location>>(
          );
        java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,edu.umd.cs.findbugs.ba.npe.NullValueUnconditionalDeref> nullValueGuaranteedDerefMap =
          new java.util.HashMap<edu.umd.cs.findbugs.ba.vna.ValueNumber,edu.umd.cs.findbugs.ba.npe.NullValueUnconditionalDeref>(
          );
        edu.umd.cs.findbugs.ba.CFG cfg =
          classContext.
          getCFG(
            method);
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
            if (DEBUG_DEREFS) {
                java.lang.System.
                  out.
                  println(
                    "At location " +
                    location);
            }
            checkForUnconditionallyDereferencedNullValues(
              location,
              bugStatementLocationMap,
              nullValueGuaranteedDerefMap,
              vnaDataflow.
                getFactAtLocation(
                  location),
              invDataflow.
                getFactAtLocation(
                  location),
              uvdDataflow.
                getFactAfterLocation(
                  location),
              false);
        }
        java.util.HashSet<edu.umd.cs.findbugs.ba.vna.ValueNumber> npeIfStatementCovered =
          new java.util.HashSet<edu.umd.cs.findbugs.ba.vna.ValueNumber>(
          nullValueGuaranteedDerefMap.
            keySet(
              ));
        java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,java.util.SortedSet<edu.umd.cs.findbugs.ba.Location>> bugEdgeLocationMap =
          new java.util.HashMap<edu.umd.cs.findbugs.ba.vna.ValueNumber,java.util.SortedSet<edu.umd.cs.findbugs.ba.Location>>(
          );
        checkEdges(
          cfg,
          nullValueGuaranteedDerefMap,
          bugEdgeLocationMap);
        java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,java.util.SortedSet<edu.umd.cs.findbugs.ba.Location>> bugLocationMap =
          bugEdgeLocationMap;
        bugLocationMap.
          putAll(
            bugStatementLocationMap);
        java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,java.util.Set<edu.umd.cs.findbugs.ba.Location>> nullValueAssignmentMap =
          findNullAssignments(
            locationWhereValueBecomesNullSet);
        reportBugs(
          nullValueGuaranteedDerefMap,
          npeIfStatementCovered,
          bugLocationMap,
          nullValueAssignmentMap);
    }
    public java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,java.util.Set<edu.umd.cs.findbugs.ba.Location>> findNullAssignments(java.util.Set<edu.umd.cs.findbugs.ba.npe.LocationWhereValueBecomesNull> locationWhereValueBecomesNullSet) {
        java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,java.util.Set<edu.umd.cs.findbugs.ba.Location>> nullValueAssignmentMap =
          new java.util.HashMap<edu.umd.cs.findbugs.ba.vna.ValueNumber,java.util.Set<edu.umd.cs.findbugs.ba.Location>>(
          );
        for (edu.umd.cs.findbugs.ba.npe.LocationWhereValueBecomesNull lwvbn
              :
              locationWhereValueBecomesNullSet) {
            if (DEBUG_DEREFS) {
                java.lang.System.
                  out.
                  println(
                    "OOO " +
                    lwvbn);
            }
            java.util.Set<edu.umd.cs.findbugs.ba.Location> locationSet =
              nullValueAssignmentMap.
              get(
                lwvbn.
                  getValueNumber(
                    ));
            if (locationSet ==
                  null) {
                locationSet =
                  new java.util.HashSet<edu.umd.cs.findbugs.ba.Location>(
                    4);
                nullValueAssignmentMap.
                  put(
                    lwvbn.
                      getValueNumber(
                        ),
                    locationSet);
            }
            locationSet.
              add(
                lwvbn.
                  getLocation(
                    ));
            if (DEBUG_DEREFS) {
                java.lang.System.
                  out.
                  println(
                    lwvbn.
                      getValueNumber(
                        ) +
                    " becomes null at " +
                    lwvbn.
                      getLocation(
                        ));
            }
        }
        return nullValueAssignmentMap;
    }
    public void reportBugs(java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,edu.umd.cs.findbugs.ba.npe.NullValueUnconditionalDeref> nullValueGuaranteedDerefMap,
                           java.util.HashSet<edu.umd.cs.findbugs.ba.vna.ValueNumber> npeIfStatementCovered,
                           java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,java.util.SortedSet<edu.umd.cs.findbugs.ba.Location>> bugLocationMap,
                           java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,java.util.Set<edu.umd.cs.findbugs.ba.Location>> nullValueAssignmentMap)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        for (java.util.Map.Entry<edu.umd.cs.findbugs.ba.vna.ValueNumber,edu.umd.cs.findbugs.ba.npe.NullValueUnconditionalDeref> e
              :
              nullValueGuaranteedDerefMap.
               entrySet(
                 )) {
            edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
              e.
              getKey(
                );
            java.util.Set<edu.umd.cs.findbugs.ba.Location> derefLocationSet =
              e.
              getValue(
                ).
              getDerefLocationSet(
                );
            java.util.Set<edu.umd.cs.findbugs.ba.Location> assignedNullLocationSet =
              nullValueAssignmentMap.
              get(
                valueNumber);
            if (assignedNullLocationSet ==
                  null) {
                if (DEBUG_DEREFS) {
                    java.lang.String where =
                      classContext.
                      getJavaClass(
                        ).
                      getClassName(
                        ) +
                    "." +
                    method.
                      getName(
                        ) +
                    ":" +
                    method.
                      getSignature(
                        );
                    java.lang.System.
                      out.
                      println(
                        "Problem at " +
                        where);
                    java.lang.System.
                      out.
                      println(
                        "Value number " +
                        valueNumber);
                    for (edu.umd.cs.findbugs.ba.Location loc
                          :
                          derefLocationSet) {
                        java.lang.System.
                          out.
                          println(
                            "Dereference at " +
                            loc);
                    }
                }
                assignedNullLocationSet =
                  java.util.Collections.
                    <edu.umd.cs.findbugs.ba.Location>
                  emptySet(
                    );
            }
            java.util.SortedSet<edu.umd.cs.findbugs.ba.Location> knownNullAndDoomedAt =
              bugLocationMap.
              get(
                valueNumber);
            edu.umd.cs.findbugs.BugAnnotation variableAnnotation =
              null;
            try {
                for (edu.umd.cs.findbugs.ba.Location loc
                      :
                      derefLocationSet) {
                    variableAnnotation =
                      edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
                        findAnnotationFromValueNumber(
                          method,
                          loc,
                          valueNumber,
                          vnaDataflow.
                            getFactAtLocation(
                              loc),
                          "VALUE_OF");
                    if (variableAnnotation !=
                          null) {
                        break;
                    }
                }
                if (variableAnnotation ==
                      null) {
                    for (edu.umd.cs.findbugs.ba.Location loc
                          :
                          knownNullAndDoomedAt) {
                        variableAnnotation =
                          edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
                            findAnnotationFromValueNumber(
                              method,
                              loc,
                              valueNumber,
                              vnaDataflow.
                                getFactAtLocation(
                                  loc),
                              "VALUE_OF");
                        if (variableAnnotation !=
                              null) {
                            break;
                        }
                    }
                }
                if (variableAnnotation ==
                      null) {
                    for (edu.umd.cs.findbugs.ba.Location loc
                          :
                          assignedNullLocationSet) {
                        variableAnnotation =
                          edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
                            findAnnotationFromValueNumber(
                              method,
                              loc,
                              valueNumber,
                              vnaDataflow.
                                getFactAtLocation(
                                  loc),
                              "VALUE_OF");
                        if (variableAnnotation !=
                              null) {
                            break;
                        }
                    }
                }
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e2) {
                
            }
            if (variableAnnotation ==
                  null) {
                variableAnnotation =
                  new edu.umd.cs.findbugs.LocalVariableAnnotation(
                    "?",
                    -1,
                    derefLocationSet.
                      iterator(
                        ).
                      next(
                        ).
                      getHandle(
                        ).
                      getPosition(
                        ));
            }
            if (PRUNE_GUARANTEED_DEREFERENCES) {
                edu.umd.cs.findbugs.ba.PostDominatorsAnalysis postDomAnalysis =
                  classContext.
                  getNonExceptionPostDominatorsAnalysis(
                    method);
                removeStrictlyPostDominatedLocations(
                  derefLocationSet,
                  postDomAnalysis);
                removeStrictlyPostDominatedLocations(
                  assignedNullLocationSet,
                  postDomAnalysis);
                edu.umd.cs.findbugs.ba.DominatorsAnalysis domAnalysis =
                  classContext.
                  getNonExceptionDominatorsAnalysis(
                    method);
                removeStrictlyDominatedLocations(
                  knownNullAndDoomedAt,
                  domAnalysis);
            }
            collector.
              foundGuaranteedNullDeref(
                assignedNullLocationSet,
                derefLocationSet,
                knownNullAndDoomedAt,
                vnaDataflow,
                valueNumber,
                variableAnnotation,
                e.
                  getValue(
                    ),
                npeIfStatementCovered.
                  contains(
                    valueNumber));
        }
    }
    public void checkEdges(edu.umd.cs.findbugs.ba.CFG cfg,
                           java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,edu.umd.cs.findbugs.ba.npe.NullValueUnconditionalDeref> nullValueGuaranteedDerefMap,
                           java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,java.util.SortedSet<edu.umd.cs.findbugs.ba.Location>> bugEdgeLocationMap)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
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
            edu.umd.cs.findbugs.ba.deref.UnconditionalValueDerefSet uvdFact =
              uvdDataflow.
              getFactOnEdge(
                edge);
            if (uvdFact.
                  isEmpty(
                    )) {
                continue;
            }
            if (edge.
                  isExceptionEdge(
                    )) {
                if (DEBUG_DEREFS) {
                    java.lang.System.
                      out.
                      println(
                        "On exception edge " +
                        edge.
                          formatAsString(
                            false));
                }
            }
            if (DEBUG_DEREFS) {
                java.lang.System.
                  out.
                  println(
                    "On edge " +
                    edge.
                      formatAsString(
                        false));
            }
            edu.umd.cs.findbugs.ba.BasicBlock source =
              edge.
              getSource(
                );
            edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFact =
              vnaDataflow.
              getResultFact(
                source);
            edu.umd.cs.findbugs.ba.npe.IsNullValueFrame invFact =
              invDataflow.
              getFactAtMidEdge(
                edge);
            edu.umd.cs.findbugs.ba.Location location =
              null;
            if (edge.
                  isExceptionEdge(
                    )) {
                edu.umd.cs.findbugs.ba.BasicBlock b =
                  cfg.
                  getSuccessorWithEdgeType(
                    source,
                    edu.umd.cs.findbugs.ba.EdgeTypes.
                      FALL_THROUGH_EDGE);
                if (b !=
                      null) {
                    location =
                      new edu.umd.cs.findbugs.ba.Location(
                        source.
                          getExceptionThrower(
                            ),
                        b);
                }
            }
            else {
                location =
                  edu.umd.cs.findbugs.ba.Location.
                    getLastLocation(
                      source);
            }
            if (location !=
                  null) {
                org.apache.bcel.generic.Instruction in =
                  location.
                  getHandle(
                    ).
                  getInstruction(
                    );
                if (assertionMethods.
                      isAssertionInstruction(
                        in,
                        classContext.
                          getConstantPoolGen(
                            ))) {
                    if (DEBUG_DEREFS) {
                        java.lang.System.
                          out.
                          println(
                            "Skipping because it is an assertion method ");
                    }
                    continue;
                }
                checkForUnconditionallyDereferencedNullValues(
                  location,
                  bugEdgeLocationMap,
                  nullValueGuaranteedDerefMap,
                  vnaFact,
                  invFact,
                  uvdFact,
                  true);
            }
        }
    }
    private void removeStrictlyPostDominatedLocations(java.util.Set<edu.umd.cs.findbugs.ba.Location> locations,
                                                      edu.umd.cs.findbugs.ba.PostDominatorsAnalysis postDomAnalysis) {
        java.util.BitSet strictlyDominated =
          new java.util.BitSet(
          );
        for (edu.umd.cs.findbugs.ba.Location loc
              :
              locations) {
            java.util.BitSet allDominatedBy =
              postDomAnalysis.
              getAllDominatedBy(
                loc.
                  getBasicBlock(
                    ));
            allDominatedBy.
              clear(
                loc.
                  getBasicBlock(
                    ).
                  getLabel(
                    ));
            strictlyDominated.
              or(
                allDominatedBy);
        }
        java.util.LinkedList<edu.umd.cs.findbugs.ba.Location> locations2 =
          new java.util.LinkedList<edu.umd.cs.findbugs.ba.Location>(
          locations);
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               locations.
               iterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location loc =
              i.
              next(
                );
            if (strictlyDominated.
                  get(
                    loc.
                      getBasicBlock(
                        ).
                      getLabel(
                        ))) {
                i.
                  remove(
                    );
                continue;
            }
            for (edu.umd.cs.findbugs.ba.Location loc2
                  :
                  locations2) {
                if (loc.
                      getBasicBlock(
                        ).
                      equals(
                        loc2.
                          getBasicBlock(
                            )) &&
                      loc.
                      getHandle(
                        ).
                      getPosition(
                        ) >
                      loc2.
                      getHandle(
                        ).
                      getPosition(
                        )) {
                    i.
                      remove(
                        );
                    break;
                }
            }
        }
    }
    private void removeStrictlyDominatedLocations(java.util.Set<edu.umd.cs.findbugs.ba.Location> locations,
                                                  edu.umd.cs.findbugs.ba.DominatorsAnalysis domAnalysis) {
        java.util.BitSet strictlyDominated =
          new java.util.BitSet(
          );
        for (edu.umd.cs.findbugs.ba.Location loc
              :
              locations) {
            java.util.BitSet allDominatedBy =
              domAnalysis.
              getAllDominatedBy(
                loc.
                  getBasicBlock(
                    ));
            allDominatedBy.
              clear(
                loc.
                  getBasicBlock(
                    ).
                  getLabel(
                    ));
            strictlyDominated.
              or(
                allDominatedBy);
        }
        java.util.LinkedList<edu.umd.cs.findbugs.ba.Location> locations2 =
          new java.util.LinkedList<edu.umd.cs.findbugs.ba.Location>(
          locations);
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               locations.
               iterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location loc =
              i.
              next(
                );
            if (strictlyDominated.
                  get(
                    loc.
                      getBasicBlock(
                        ).
                      getLabel(
                        ))) {
                i.
                  remove(
                    );
                continue;
            }
            for (edu.umd.cs.findbugs.ba.Location loc2
                  :
                  locations2) {
                if (loc.
                      getBasicBlock(
                        ).
                      equals(
                        loc2.
                          getBasicBlock(
                            )) &&
                      loc.
                      getHandle(
                        ).
                      getPosition(
                        ) >
                      loc2.
                      getHandle(
                        ).
                      getPosition(
                        )) {
                    i.
                      remove(
                        );
                    break;
                }
            }
        }
    }
    private static final boolean MY_DEBUG =
      false;
    private void checkForUnconditionallyDereferencedNullValues(edu.umd.cs.findbugs.ba.Location thisLocation,
                                                               java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,java.util.SortedSet<edu.umd.cs.findbugs.ba.Location>> knownNullAndDoomedAt,
                                                               java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,edu.umd.cs.findbugs.ba.npe.NullValueUnconditionalDeref> nullValueGuaranteedDerefMap,
                                                               edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame,
                                                               edu.umd.cs.findbugs.ba.npe.IsNullValueFrame invFrame,
                                                               edu.umd.cs.findbugs.ba.deref.UnconditionalValueDerefSet derefSet,
                                                               boolean isEdge) {
        if (DEBUG_DEREFS) {
            java.lang.System.
              out.
              println(
                "vna *** " +
                vnaFrame);
            java.lang.System.
              out.
              println(
                "inv *** " +
                invFrame);
            java.lang.System.
              out.
              println(
                "deref * " +
                derefSet);
        }
        if (!vnaFrame.
              isValid(
                ) ||
              !invFrame.
              isValid(
                ) ||
              vnaFrame.
              getNumLocals(
                ) !=
              invFrame.
              getNumLocals(
                ) ||
              derefSet.
              isEmpty(
                )) {
            return;
        }
        int slots;
        if (vnaFrame.
              getNumSlots(
                ) ==
              invFrame.
              getNumSlots(
                )) {
            slots =
              vnaFrame.
                getNumSlots(
                  );
        }
        else {
            slots =
              vnaFrame.
                getNumLocals(
                  );
        }
        for (int j =
               0;
             j <
               slots;
             j++) {
            edu.umd.cs.findbugs.ba.npe.IsNullValue isNullValue =
              invFrame.
              getValue(
                j);
            edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
              vnaFrame.
              getValue(
                j);
            if ((isNullValue.
                   isDefinitelyNull(
                     ) ||
                   isNullValue.
                   isNullOnSomePath(
                     ) &&
                   isNullValue.
                   isReturnValue(
                     )) &&
                  derefSet.
                  isUnconditionallyDereferenced(
                    valueNumber)) {
                if (MY_DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Found NP bug");
                    java.lang.System.
                      out.
                      println(
                        "Location: " +
                        thisLocation);
                    java.lang.System.
                      out.
                      println(
                        "Value number frame: " +
                        vnaFrame);
                    java.lang.System.
                      out.
                      println(
                        "Value number: " +
                        valueNumber);
                    java.lang.System.
                      out.
                      println(
                        "IsNullValue frame: " +
                        invFrame);
                    java.lang.System.
                      out.
                      println(
                        "IsNullValue value: " +
                        isNullValue);
                    java.lang.System.
                      out.
                      println(
                        "Unconditional dere framef: " +
                        derefSet);
                    java.lang.System.
                      out.
                      println(
                        "Unconditionally dereferenced: " +
                        derefSet.
                          isUnconditionallyDereferenced(
                            valueNumber));
                }
                edu.umd.cs.findbugs.ba.Location where =
                  thisLocation;
                if (!isEdge &&
                      isNullValue.
                      isNullOnSomePath(
                        ) &&
                      isNullValue.
                      isReturnValue(
                        )) {
                    try {
                        where =
                          classContext.
                            getCFG(
                              method).
                            getPreviousLocation(
                              where);
                    }
                    catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                        edu.umd.cs.findbugs.ba.AnalysisContext.
                          logError(
                            "Error looking for previous instruction to " +
                            where +
                            " in " +
                            classContext.
                              getFullyQualifiedMethodName(
                                method),
                            e);
                    }
                }
                noteUnconditionallyDereferencedNullValue(
                  where,
                  knownNullAndDoomedAt,
                  nullValueGuaranteedDerefMap,
                  derefSet,
                  isNullValue,
                  valueNumber);
            }
        }
        for (java.util.Map.Entry<edu.umd.cs.findbugs.ba.vna.ValueNumber,edu.umd.cs.findbugs.ba.npe.IsNullValue> entry
              :
              invFrame.
               getKnownValueMapEntrySet(
                 )) {
            edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
              entry.
              getKey(
                );
            edu.umd.cs.findbugs.ba.npe.IsNullValue isNullValue =
              entry.
              getValue(
                );
            if ((isNullValue.
                   isDefinitelyNull(
                     ) ||
                   isNullValue.
                   isNullOnSomePath(
                     ) &&
                   (isNullValue.
                      isReturnValue(
                        ) ||
                      isNullValue.
                      isFieldValue(
                        ))) &&
                  derefSet.
                  isUnconditionallyDereferenced(
                    valueNumber)) {
                noteUnconditionallyDereferencedNullValue(
                  thisLocation,
                  knownNullAndDoomedAt,
                  nullValueGuaranteedDerefMap,
                  derefSet,
                  isNullValue,
                  valueNumber);
            }
        }
    }
    private void noteUnconditionallyDereferencedNullValue(edu.umd.cs.findbugs.ba.Location thisLocation,
                                                          java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,java.util.SortedSet<edu.umd.cs.findbugs.ba.Location>> bugLocations,
                                                          java.util.Map<edu.umd.cs.findbugs.ba.vna.ValueNumber,edu.umd.cs.findbugs.ba.npe.NullValueUnconditionalDeref> nullValueGuaranteedDerefMap,
                                                          edu.umd.cs.findbugs.ba.deref.UnconditionalValueDerefSet derefSet,
                                                          edu.umd.cs.findbugs.ba.npe.IsNullValue isNullValue,
                                                          edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber) {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "%%% HIT for value number " +
                valueNumber +
                " @ " +
                thisLocation);
        }
        java.util.Set<edu.umd.cs.findbugs.ba.Location> unconditionalDerefLocationSet =
          derefSet.
          getUnconditionalDerefLocationSet(
            valueNumber);
        if (unconditionalDerefLocationSet.
              isEmpty(
                )) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "empty set of unconditionally dereferenced locations at " +
                thisLocation.
                  getHandle(
                    ).
                  getPosition(
                    ) +
                " in " +
                classContext.
                  getClassDescriptor(
                    ) +
                "." +
                method.
                  getName(
                    ) +
                method.
                  getSignature(
                    ));
            return;
        }
        edu.umd.cs.findbugs.ba.npe.NullValueUnconditionalDeref thisNullValueDeref =
          nullValueGuaranteedDerefMap.
          get(
            valueNumber);
        if (thisNullValueDeref ==
              null) {
            thisNullValueDeref =
              new edu.umd.cs.findbugs.ba.npe.NullValueUnconditionalDeref(
                );
            nullValueGuaranteedDerefMap.
              put(
                valueNumber,
                thisNullValueDeref);
        }
        thisNullValueDeref.
          add(
            isNullValue,
            unconditionalDerefLocationSet);
        if (thisLocation !=
              null) {
            java.util.SortedSet<edu.umd.cs.findbugs.ba.Location> locationsForThisBug =
              bugLocations.
              get(
                valueNumber);
            if (locationsForThisBug ==
                  null) {
                locationsForThisBug =
                  new java.util.TreeSet<edu.umd.cs.findbugs.ba.Location>(
                    );
                bugLocations.
                  put(
                    valueNumber,
                    locationsForThisBug);
            }
            locationsForThisBug.
              add(
                thisLocation);
        }
    }
    private void examineRedundantBranches() {
        for (edu.umd.cs.findbugs.ba.npe.RedundantBranch redundantBranch
              :
              redundantBranchList) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Redundant branch: " +
                    redundantBranch);
            }
            int lineNumber =
              redundantBranch.
                lineNumber;
            boolean confused =
              undeterminedBranchSet.
              get(
                lineNumber) ||
              definitelySameBranchSet.
              get(
                lineNumber) &&
              definitelyDifferentBranchSet.
              get(
                lineNumber);
            boolean reportIt =
              true;
            if (lineMentionedMultipleTimes.
                  get(
                    lineNumber) &&
                  confused) {
                reportIt =
                  false;
            }
            else
                if (redundantBranch.
                      location.
                      getBasicBlock(
                        ).
                      isInJSRSubroutine(
                        ) &&
                      confused) {
                    reportIt =
                      false;
                }
                else {
                    int pc =
                      redundantBranch.
                        location.
                      getHandle(
                        ).
                      getPosition(
                        );
                    for (org.apache.bcel.classfile.CodeException e
                          :
                          method.
                           getCode(
                             ).
                           getExceptionTable(
                             )) {
                        if (e.
                              getCatchType(
                                ) ==
                              0 &&
                              e.
                              getStartPC(
                                ) !=
                              e.
                              getHandlerPC(
                                ) &&
                              e.
                              getEndPC(
                                ) <=
                              pc &&
                              pc <=
                              e.
                              getEndPC(
                                ) +
                              5) {
                            reportIt =
                              false;
                        }
                    }
                }
            if (reportIt) {
                collector.
                  foundRedundantNullCheck(
                    redundantBranch.
                      location,
                    redundantBranch);
            }
        }
    }
    private void analyzeRefComparisonBranch(edu.umd.cs.findbugs.ba.BasicBlock basicBlock,
                                            org.apache.bcel.generic.InstructionHandle lastHandle)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        edu.umd.cs.findbugs.ba.Location location =
          new edu.umd.cs.findbugs.ba.Location(
          lastHandle,
          basicBlock);
        edu.umd.cs.findbugs.ba.npe.IsNullValueFrame frame =
          invDataflow.
          getFactAtLocation(
            location);
        if (!frame.
              isValid(
                )) {
            return;
        }
        if (frame.
              getStackDepth(
                ) <
              2) {
            throw new edu.umd.cs.findbugs.ba.DataflowAnalysisException(
              "Stack underflow at " +
              lastHandle);
        }
        int lineNumber =
          getLineNumber(
            method,
            lastHandle);
        if (lineNumber <
              0) {
            return;
        }
        int numSlots =
          frame.
          getNumSlots(
            );
        edu.umd.cs.findbugs.ba.npe.IsNullValue top =
          frame.
          getValue(
            numSlots -
              1);
        edu.umd.cs.findbugs.ba.npe.IsNullValue topNext =
          frame.
          getValue(
            numSlots -
              2);
        boolean definitelySame =
          top.
          isDefinitelyNull(
            ) &&
          topNext.
          isDefinitelyNull(
            );
        boolean definitelyDifferent =
          top.
          isDefinitelyNull(
            ) &&
          topNext.
          isDefinitelyNotNull(
            ) ||
          top.
          isDefinitelyNotNull(
            ) &&
          topNext.
          isDefinitelyNull(
            );
        if (definitelySame ||
              definitelyDifferent) {
            if (definitelySame) {
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Line " +
                        lineNumber +
                        " always same");
                }
                definitelySameBranchSet.
                  set(
                    lineNumber);
            }
            if (definitelyDifferent) {
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Line " +
                        lineNumber +
                        " always different");
                }
                definitelyDifferentBranchSet.
                  set(
                    lineNumber);
            }
            edu.umd.cs.findbugs.ba.npe.RedundantBranch redundantBranch =
              new edu.umd.cs.findbugs.ba.npe.RedundantBranch(
              location,
              lineNumber,
              top,
              topNext);
            boolean wantSame =
              lastHandle.
              getInstruction(
                ).
              getOpcode(
                ) ==
              org.apache.bcel.Constants.
                IF_ACMPEQ;
            int infeasibleEdgeType =
              wantSame ==
              definitelySame
              ? edu.umd.cs.findbugs.ba.EdgeTypes.
                  FALL_THROUGH_EDGE
              : edu.umd.cs.findbugs.ba.EdgeTypes.
                  IFCMP_EDGE;
            edu.umd.cs.findbugs.ba.Edge infeasibleEdge =
              invDataflow.
              getCFG(
                ).
              getOutgoingEdgeWithType(
                basicBlock,
                infeasibleEdgeType);
            redundantBranch.
              setInfeasibleEdge(
                infeasibleEdge);
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Adding redundant branch: " +
                    redundantBranch);
            }
            redundantBranchList.
              add(
                redundantBranch);
        }
        else {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Line " +
                    lineNumber +
                    " undetermined");
            }
            undeterminedBranchSet.
              set(
                lineNumber);
        }
    }
    private void analyzeIfNullBranch(edu.umd.cs.findbugs.ba.BasicBlock basicBlock,
                                     org.apache.bcel.generic.InstructionHandle lastHandle)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        edu.umd.cs.findbugs.ba.Location location =
          new edu.umd.cs.findbugs.ba.Location(
          lastHandle,
          basicBlock);
        edu.umd.cs.findbugs.ba.npe.IsNullValueFrame frame =
          invDataflow.
          getFactAtLocation(
            location);
        if (!frame.
              isValid(
                )) {
            return;
        }
        edu.umd.cs.findbugs.ba.npe.IsNullValue top =
          frame.
          getTopValue(
            );
        int lineNumber =
          getLineNumber(
            method,
            lastHandle);
        if (lineNumber <
              0) {
            return;
        }
        if (!(top.
                isDefinitelyNull(
                  ) ||
                top.
                isDefinitelyNotNull(
                  ))) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Line " +
                    lineNumber +
                    " undetermined");
            }
            undeterminedBranchSet.
              set(
                lineNumber);
            return;
        }
        short opcode =
          lastHandle.
          getInstruction(
            ).
          getOpcode(
            );
        boolean definitelySame =
          top.
          isDefinitelyNull(
            );
        if (opcode !=
              org.apache.bcel.Constants.
                IFNULL) {
            definitelySame =
              !definitelySame;
        }
        if (definitelySame) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Line " +
                    lineNumber +
                    " always same");
            }
            definitelySameBranchSet.
              set(
                lineNumber);
        }
        else {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Line " +
                    lineNumber +
                    " always different");
            }
            definitelyDifferentBranchSet.
              set(
                lineNumber);
        }
        edu.umd.cs.findbugs.ba.npe.RedundantBranch redundantBranch =
          new edu.umd.cs.findbugs.ba.npe.RedundantBranch(
          location,
          lineNumber,
          top);
        boolean wantNull =
          opcode ==
          org.apache.bcel.Constants.
            IFNULL;
        int infeasibleEdgeType =
          wantNull ==
          top.
          isDefinitelyNull(
            )
          ? edu.umd.cs.findbugs.ba.EdgeTypes.
              FALL_THROUGH_EDGE
          : edu.umd.cs.findbugs.ba.EdgeTypes.
              IFCMP_EDGE;
        edu.umd.cs.findbugs.ba.Edge infeasibleEdge =
          invDataflow.
          getCFG(
            ).
          getOutgoingEdgeWithType(
            basicBlock,
            infeasibleEdgeType);
        redundantBranch.
          setInfeasibleEdge(
            infeasibleEdge);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Adding redundant branch: " +
                redundantBranch);
        }
        redundantBranchList.
          add(
            redundantBranch);
    }
    private void analyzeNullCheck(edu.umd.cs.findbugs.ba.npe.IsNullValueDataflow invDataflow,
                                  edu.umd.cs.findbugs.ba.BasicBlock basicBlock)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        edu.umd.cs.findbugs.ba.CFGBuilderException {
        org.apache.bcel.generic.InstructionHandle exceptionThrowerHandle =
          basicBlock.
          getExceptionThrower(
            );
        org.apache.bcel.generic.Instruction exceptionThrower =
          exceptionThrowerHandle.
          getInstruction(
            );
        edu.umd.cs.findbugs.ba.npe.IsNullValueFrame frame =
          invDataflow.
          getStartFact(
            basicBlock);
        if (!frame.
              isValid(
                )) {
            return;
        }
        edu.umd.cs.findbugs.ba.npe.IsNullValue refValue =
          frame.
          getInstance(
            exceptionThrower,
            classContext.
              getConstantPoolGen(
                ));
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "For basic block " +
                basicBlock +
                " value is " +
                refValue);
        }
        if (refValue.
              isDefinitelyNotNull(
                )) {
            return;
        }
        if (!refValue.
              isDefinitelyNull(
                )) {
            return;
        }
        edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
          classContext.
          getValueNumberDataflow(
            method).
          getStartFact(
            basicBlock);
        if (!vnaFrame.
              isValid(
                )) {
            return;
        }
        edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
          vnaFrame.
          getInstance(
            exceptionThrower,
            classContext.
              getConstantPoolGen(
                ));
        edu.umd.cs.findbugs.ba.Location location =
          new edu.umd.cs.findbugs.ba.Location(
          exceptionThrowerHandle,
          basicBlock);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Warning: VN " +
                valueNumber +
                " invf: " +
                frame +
                " @ " +
                location);
        }
        boolean isConsistent =
          true;
        java.util.Iterator<edu.umd.cs.findbugs.ba.BasicBlock> bbIter =
          invDataflow.
          getCFG(
            ).
          blockIterator(
            );
        org.apache.bcel.classfile.LineNumberTable table =
          method.
          getLineNumberTable(
            );
        int position =
          exceptionThrowerHandle.
          getPosition(
            );
        int line =
          table ==
          null
          ? 0
          : table.
          getSourceLine(
            position);
        while (bbIter.
                 hasNext(
                   )) {
            edu.umd.cs.findbugs.ba.BasicBlock bb =
              bbIter.
              next(
                );
            if (!bb.
                  isNullCheck(
                    )) {
                continue;
            }
            org.apache.bcel.generic.InstructionHandle eth =
              bb.
              getExceptionThrower(
                );
            if (eth ==
                  exceptionThrowerHandle) {
                continue;
            }
            if (eth.
                  getInstruction(
                    ).
                  getOpcode(
                    ) !=
                  exceptionThrower.
                  getOpcode(
                    )) {
                continue;
            }
            int ePosition =
              eth.
              getPosition(
                );
            if (ePosition ==
                  position ||
                  table !=
                  null &&
                  line ==
                  table.
                  getSourceLine(
                    ePosition)) {
                edu.umd.cs.findbugs.ba.npe.IsNullValueFrame frame2 =
                  invDataflow.
                  getStartFact(
                    bb);
                if (!frame2.
                      isValid(
                        )) {
                    continue;
                }
                edu.umd.cs.findbugs.ba.npe.IsNullValue rv =
                  frame2.
                  getInstance(
                    eth.
                      getInstruction(
                        ),
                    classContext.
                      getConstantPoolGen(
                        ));
                if (!rv.
                      equals(
                        refValue)) {
                    isConsistent =
                      false;
                }
            }
        }
        collector.
          foundNullDeref(
            location,
            valueNumber,
            refValue,
            vnaFrame,
            isConsistent);
    }
    @java.lang.Deprecated
    public static edu.umd.cs.findbugs.ba.XField findXFieldFromValueNumber(org.apache.bcel.classfile.Method method,
                                                                          edu.umd.cs.findbugs.ba.Location location,
                                                                          edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber,
                                                                          edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame) {
        return edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
          findXFieldFromValueNumber(
            method,
            location,
            valueNumber,
            vnaFrame);
    }
    @java.lang.Deprecated
    public static edu.umd.cs.findbugs.FieldAnnotation findFieldAnnotationFromValueNumber(org.apache.bcel.classfile.Method method,
                                                                                         edu.umd.cs.findbugs.ba.Location location,
                                                                                         edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber,
                                                                                         edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame) {
        return edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
          findFieldAnnotationFromValueNumber(
            method,
            location,
            valueNumber,
            vnaFrame);
    }
    @java.lang.Deprecated
    public static edu.umd.cs.findbugs.LocalVariableAnnotation findLocalAnnotationFromValueNumber(org.apache.bcel.classfile.Method method,
                                                                                                 edu.umd.cs.findbugs.ba.Location location,
                                                                                                 edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber,
                                                                                                 edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame) {
        return edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
          findLocalAnnotationFromValueNumber(
            method,
            location,
            valueNumber,
            vnaFrame);
    }
    @java.lang.Deprecated
    public static edu.umd.cs.findbugs.BugAnnotation findAnnotationFromValueNumber(org.apache.bcel.classfile.Method method,
                                                                                  edu.umd.cs.findbugs.ba.Location location,
                                                                                  edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber,
                                                                                  edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame) {
        return edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
          findRequiredAnnotationFromValueNumber(
            method,
            location,
            valueNumber,
            vnaFrame,
            null);
    }
    private static int getLineNumber(org.apache.bcel.classfile.Method method,
                                     org.apache.bcel.generic.InstructionHandle handle) {
        org.apache.bcel.classfile.LineNumberTable table =
          method.
          getCode(
            ).
          getLineNumberTable(
            );
        if (table ==
              null) {
            return -1;
        }
        return table.
          getSourceLine(
            handle.
              getPosition(
                ));
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
       "1ahtxTHsa5bHsdUemIK7TTvRegFesaeJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "WAAA");
}
