package edu.umd.cs.findbugs.plan;
public class ExecutionPlan {
    public static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "findbugs.execplan.debug");
    private java.util.List<edu.umd.cs.findbugs.Plugin> pluginList;
    private edu.umd.cs.findbugs.DetectorFactoryChooser factoryChooser;
    private java.util.LinkedList<edu.umd.cs.findbugs.plan.AnalysisPass> passList;
    private java.util.Map<java.lang.String,edu.umd.cs.findbugs.DetectorFactory>
      factoryMap;
    private java.util.List<edu.umd.cs.findbugs.plan.DetectorOrderingConstraint>
      interPassConstraintList;
    private java.util.List<edu.umd.cs.findbugs.plan.DetectorOrderingConstraint>
      intraPassConstraintList;
    private java.util.Set<edu.umd.cs.findbugs.DetectorFactory> assignedToPassSet;
    public ExecutionPlan() { super();
                             this.pluginList = new java.util.LinkedList<edu.umd.cs.findbugs.Plugin>(
                                                 );
                             this.factoryChooser = new edu.umd.cs.findbugs.DetectorFactoryChooser(
                                                     ) {
                                                       @java.lang.Override
                                                       public boolean choose(edu.umd.cs.findbugs.DetectorFactory factory) {
                                                           return true;
                                                       }
                                                       @java.lang.Override
                                                       public void enable(edu.umd.cs.findbugs.DetectorFactory factory) {
                                                           
                                                       }
                                                   };
                             this.passList =
                               new java.util.LinkedList<edu.umd.cs.findbugs.plan.AnalysisPass>(
                                 );
                             this.factoryMap =
                               new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.DetectorFactory>(
                                 );
                             this.interPassConstraintList =
                               new java.util.LinkedList<edu.umd.cs.findbugs.plan.DetectorOrderingConstraint>(
                                 );
                             this.intraPassConstraintList =
                               new java.util.LinkedList<edu.umd.cs.findbugs.plan.DetectorOrderingConstraint>(
                                 );
                             this.assignedToPassSet =
                               new java.util.HashSet<edu.umd.cs.findbugs.DetectorFactory>(
                                 ); }
    public void dispose() { pluginList.clear(
                                         );
                            factoryChooser =
                              null;
                            passList.clear(
                                       );
                            factoryMap.clear(
                                         );
                            interPassConstraintList.
                              clear(
                                );
                            intraPassConstraintList.
                              clear(
                                );
                            assignedToPassSet.
                              clear(
                                ); }
    public void setDetectorFactoryChooser(edu.umd.cs.findbugs.DetectorFactoryChooser factoryChooser) {
        this.
          factoryChooser =
          factoryChooser;
    }
    public boolean isActive(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                            java.lang.String detectorClass) {
        return factoryMap.
          containsKey(
            detectorClass);
    }
    public boolean isActive(java.lang.Class<? extends edu.umd.cs.findbugs.Detector> detectorClass) {
        return isActive(
                 detectorClass.
                   getName(
                     ));
    }
    public void addPlugin(edu.umd.cs.findbugs.Plugin plugin)
          throws edu.umd.cs.findbugs.plan.OrderingConstraintException {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Adding plugin " +
                plugin.
                  getPluginId(
                    ) +
                " to execution plan");
        }
        pluginList.
          add(
            plugin);
        copyTo(
          plugin.
            interPassConstraintIterator(
              ),
          interPassConstraintList);
        copyTo(
          plugin.
            intraPassConstraintIterator(
              ),
          intraPassConstraintList);
        for (edu.umd.cs.findbugs.DetectorFactory factory
              :
              plugin.
               getDetectorFactories(
                 )) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "  Detector factory " +
                    factory.
                      getShortName(
                        ));
            }
            if (factoryMap.
                  put(
                    factory.
                      getFullName(
                        ),
                    factory) !=
                  null) {
                throw new edu.umd.cs.findbugs.plan.OrderingConstraintException(
                  "Detector " +
                  factory.
                    getFullName(
                      ) +
                  " is defined by more than one plugin");
            }
        }
    }
    public void build() throws edu.umd.cs.findbugs.plan.OrderingConstraintException {
        for (edu.umd.cs.findbugs.DetectorFactory detectorFactory
              :
              factoryMap.
               values(
                 )) {
            detectorFactory.
              setEnabledButNonReporting(
                false);
        }
        java.util.ArrayList<edu.umd.cs.findbugs.plan.DetectorOrderingConstraint> allConstraints =
          new java.util.ArrayList<edu.umd.cs.findbugs.plan.DetectorOrderingConstraint>(
          interPassConstraintList.
            size(
              ) +
            intraPassConstraintList.
            size(
              ));
        allConstraints.
          addAll(
            interPassConstraintList);
        allConstraints.
          addAll(
            intraPassConstraintList);
        java.util.Map<java.lang.String,edu.umd.cs.findbugs.plan.DetectorNode> nodeMapAll =
          new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.plan.DetectorNode>(
          );
        edu.umd.cs.findbugs.plan.ConstraintGraph allPassConstraintGraph =
          buildConstraintGraph(
            nodeMapAll,
            new java.util.HashSet<edu.umd.cs.findbugs.DetectorFactory>(
              factoryMap.
                values(
                  )),
            allConstraints);
        boolean change;
        do  {
            change =
              false;
            for (java.util.Iterator<edu.umd.cs.findbugs.plan.DetectorNode> i =
                   allPassConstraintGraph.
                   vertexIterator(
                     );
                 i.
                   hasNext(
                     );
                 ) {
                edu.umd.cs.findbugs.plan.DetectorNode end =
                  i.
                  next(
                    );
                if (factoryChooser.
                      choose(
                        end.
                          getFactory(
                            ))) {
                    for (java.util.Iterator<edu.umd.cs.findbugs.plan.ConstraintEdge> j =
                           allPassConstraintGraph.
                           incomingEdgeIterator(
                             end);
                         j.
                           hasNext(
                             );
                         ) {
                        edu.umd.cs.findbugs.plan.ConstraintEdge edge =
                          j.
                          next(
                            );
                        edu.umd.cs.findbugs.plan.DetectorNode start =
                          edge.
                          getSource(
                            );
                        edu.umd.cs.findbugs.DetectorFactory startFactory =
                          start.
                          getFactory(
                            );
                        if (!factoryChooser.
                              choose(
                                startFactory) &&
                              edge.
                              isSingleSource(
                                )) {
                            factoryChooser.
                              enable(
                                startFactory);
                            change =
                              true;
                            if (DEBUG ||
                                  edu.umd.cs.findbugs.FindBugs2.
                                    DEBUG) {
                                java.lang.System.
                                  out.
                                  println(
                                    "Dependences force enabling of " +
                                    startFactory.
                                      getFullName(
                                        ));
                            }
                        }
                    }
                }
            }
        }while(change); 
        for (java.util.Iterator<java.util.Map.Entry<java.lang.String,edu.umd.cs.findbugs.DetectorFactory>> i =
               factoryMap.
               entrySet(
                 ).
               iterator(
                 );
             i.
               hasNext(
                 );
             ) {
            java.util.Map.Entry<java.lang.String,edu.umd.cs.findbugs.DetectorFactory> e =
              i.
              next(
                );
            if (!factoryChooser.
                  choose(
                    e.
                      getValue(
                        ))) {
                i.
                  remove(
                    );
            }
        }
        java.util.Map<java.lang.String,edu.umd.cs.findbugs.plan.DetectorNode> nodeMap =
          new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.plan.DetectorNode>(
          );
        edu.umd.cs.findbugs.plan.ConstraintGraph interPassConstraintGraph =
          buildConstraintGraph(
            nodeMap,
            new java.util.HashSet<edu.umd.cs.findbugs.DetectorFactory>(
              factoryMap.
                values(
                  )),
            interPassConstraintList);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                interPassConstraintGraph.
                  getNumVertices(
                    ) +
                " nodes in inter-pass constraint graph");
        }
        buildPassList(
          interPassConstraintGraph);
        for (edu.umd.cs.findbugs.plan.AnalysisPass pass
              :
              passList) {
            sortPass(
              intraPassConstraintList,
              factoryMap,
              pass);
        }
        if (factoryMap.
              size(
                ) >
              assignedToPassSet.
              size(
                )) {
            edu.umd.cs.findbugs.plan.AnalysisPass lastPass;
            if (passList.
                  isEmpty(
                    )) {
                lastPass =
                  new edu.umd.cs.findbugs.plan.AnalysisPass(
                    );
                addPass(
                  lastPass);
            }
            else {
                lastPass =
                  passList.
                    getLast(
                      );
            }
            java.util.Set<edu.umd.cs.findbugs.DetectorFactory> unassignedSet =
              getUnassignedSet(
                );
            for (edu.umd.cs.findbugs.DetectorFactory factory
                  :
                  unassignedSet) {
                assignToPass(
                  factory,
                  lastPass);
            }
            appendDetectorsToPass(
              unassignedSet,
              lastPass);
        }
        if (DEBUG) {
            print(
              );
        }
    }
    public java.util.Iterator<edu.umd.cs.findbugs.plan.AnalysisPass> passIterator() {
        return passList.
          iterator(
            );
    }
    public int getNumPasses() { return passList.
                                  size(
                                    ); }
    private static <T> void copyTo(java.util.Iterator<T> iter,
                                   java.util.Collection<T> dest) {
        while (iter.
                 hasNext(
                   )) {
            dest.
              add(
                iter.
                  next(
                    ));
        }
    }
    private edu.umd.cs.findbugs.plan.ConstraintGraph buildConstraintGraph(java.util.Map<java.lang.String,edu.umd.cs.findbugs.plan.DetectorNode> nodeMap,
                                                                          java.util.Set<edu.umd.cs.findbugs.DetectorFactory> factorySet,
                                                                          java.util.List<edu.umd.cs.findbugs.plan.DetectorOrderingConstraint> constraintList) {
        edu.umd.cs.findbugs.plan.ConstraintGraph result =
          new edu.umd.cs.findbugs.plan.ConstraintGraph(
          );
        for (edu.umd.cs.findbugs.plan.DetectorOrderingConstraint constraint
              :
              constraintList) {
            java.util.Set<edu.umd.cs.findbugs.plan.DetectorNode> earlierSet =
              addOrCreateDetectorNodes(
                constraint.
                  getEarlier(
                    ),
                nodeMap,
                factorySet,
                result);
            java.util.Set<edu.umd.cs.findbugs.plan.DetectorNode> laterSet =
              addOrCreateDetectorNodes(
                constraint.
                  getLater(
                    ),
                nodeMap,
                factorySet,
                result);
            createConstraintEdges(
              result,
              earlierSet,
              laterSet,
              constraint);
        }
        return result;
    }
    private java.util.Set<edu.umd.cs.findbugs.DetectorFactory> selectDetectors(edu.umd.cs.findbugs.plan.DetectorFactorySelector selector,
                                                                               java.util.Set<edu.umd.cs.findbugs.DetectorFactory> candidateSet) {
        java.util.Set<edu.umd.cs.findbugs.DetectorFactory> result =
          new java.util.HashSet<edu.umd.cs.findbugs.DetectorFactory>(
          );
        for (edu.umd.cs.findbugs.DetectorFactory factory
              :
              candidateSet) {
            if (selector.
                  selectFactory(
                    factory)) {
                result.
                  add(
                    factory);
            }
        }
        return result;
    }
    private java.util.Set<edu.umd.cs.findbugs.plan.DetectorNode> addOrCreateDetectorNodes(edu.umd.cs.findbugs.plan.DetectorFactorySelector selector,
                                                                                          java.util.Map<java.lang.String,edu.umd.cs.findbugs.plan.DetectorNode> nodeMap,
                                                                                          java.util.Set<edu.umd.cs.findbugs.DetectorFactory> factorySet,
                                                                                          edu.umd.cs.findbugs.plan.ConstraintGraph constraintGraph) {
        java.util.HashSet<edu.umd.cs.findbugs.plan.DetectorNode> result =
          new java.util.HashSet<edu.umd.cs.findbugs.plan.DetectorNode>(
          );
        java.util.Set<edu.umd.cs.findbugs.DetectorFactory> chosenSet =
          selectDetectors(
            selector,
            factorySet);
        for (edu.umd.cs.findbugs.DetectorFactory factory
              :
              chosenSet) {
            edu.umd.cs.findbugs.plan.DetectorNode node =
              addOrCreateDetectorNode(
                factory,
                nodeMap,
                constraintGraph);
            result.
              add(
                node);
        }
        return result;
    }
    private edu.umd.cs.findbugs.plan.DetectorNode addOrCreateDetectorNode(edu.umd.cs.findbugs.DetectorFactory factory,
                                                                          java.util.Map<java.lang.String,edu.umd.cs.findbugs.plan.DetectorNode> nodeMap,
                                                                          edu.umd.cs.findbugs.plan.ConstraintGraph constraintGraph) {
        edu.umd.cs.findbugs.plan.DetectorNode node =
          nodeMap.
          get(
            factory.
              getFullName(
                ));
        if (node ==
              null) {
            node =
              new edu.umd.cs.findbugs.plan.DetectorNode(
                factory);
            nodeMap.
              put(
                factory.
                  getFullName(
                    ),
                node);
            constraintGraph.
              addVertex(
                node);
        }
        return node;
    }
    private void createConstraintEdges(edu.umd.cs.findbugs.plan.ConstraintGraph result,
                                       java.util.Set<edu.umd.cs.findbugs.plan.DetectorNode> earlierSet,
                                       java.util.Set<edu.umd.cs.findbugs.plan.DetectorNode> laterSet,
                                       edu.umd.cs.findbugs.plan.DetectorOrderingConstraint constraint) {
        if (earlierSet.
              isEmpty(
                ) ||
              laterSet.
              isEmpty(
                )) {
            return;
        }
        for (edu.umd.cs.findbugs.plan.DetectorNode earlier
              :
              earlierSet) {
            for (edu.umd.cs.findbugs.plan.DetectorNode later
                  :
                  laterSet) {
                edu.umd.cs.findbugs.plan.ConstraintEdge edge =
                  result.
                  createEdge(
                    earlier,
                    later);
                edge.
                  setConstraint(
                    constraint);
            }
        }
    }
    private void buildPassList(edu.umd.cs.findbugs.plan.ConstraintGraph constraintGraph)
          throws edu.umd.cs.findbugs.plan.OrderingConstraintException {
        int passCount =
          0;
        while (constraintGraph.
                 getNumVertices(
                   ) >
                 0) {
            java.util.List<edu.umd.cs.findbugs.plan.DetectorNode> inDegreeZeroList =
              new java.util.LinkedList<edu.umd.cs.findbugs.plan.DetectorNode>(
              );
            for (java.util.Iterator<edu.umd.cs.findbugs.plan.DetectorNode> i =
                   constraintGraph.
                   vertexIterator(
                     );
                 i.
                   hasNext(
                     );
                 ) {
                edu.umd.cs.findbugs.plan.DetectorNode node =
                  i.
                  next(
                    );
                if (constraintGraph.
                      getNumIncomingEdges(
                        node) ==
                      0) {
                    inDegreeZeroList.
                      add(
                        node);
                }
                else
                    if (DEBUG) {
                        java.lang.System.
                          out.
                          println(
                            "Can\'t schedule " +
                            node.
                              getFactory(
                                ).
                              getShortName(
                                ));
                        java.util.Iterator<edu.umd.cs.findbugs.plan.ConstraintEdge> incomingEdgeIterator =
                          constraintGraph.
                          incomingEdgeIterator(
                            node);
                        while (incomingEdgeIterator.
                                 hasNext(
                                   )) {
                            edu.umd.cs.findbugs.plan.ConstraintEdge edge =
                              incomingEdgeIterator.
                              next(
                                );
                            java.lang.System.
                              out.
                              println(
                                "  requires " +
                                edge.
                                  getSource(
                                    ).
                                  getFactory(
                                    ).
                                  getShortName(
                                    ));
                        }
                    }
            }
            if (inDegreeZeroList.
                  isEmpty(
                    )) {
                throw new edu.umd.cs.findbugs.plan.OrderingConstraintException(
                  "Cycle in inter-pass ordering constraints");
            }
            for (edu.umd.cs.findbugs.plan.DetectorNode node
                  :
                  inDegreeZeroList) {
                constraintGraph.
                  removeVertex(
                    node);
            }
            edu.umd.cs.findbugs.plan.AnalysisPass pass =
              new edu.umd.cs.findbugs.plan.AnalysisPass(
              );
            addPass(
              pass);
            passCount++;
            for (edu.umd.cs.findbugs.plan.DetectorNode node
                  :
                  inDegreeZeroList) {
                assignToPass(
                  node.
                    getFactory(
                      ),
                  pass);
            }
        }
    }
    private void addPass(edu.umd.cs.findbugs.plan.AnalysisPass pass) {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Adding pass " +
                passList.
                  size(
                    ));
        }
        passList.
          add(
            pass);
    }
    private void sortPass(java.util.List<edu.umd.cs.findbugs.plan.DetectorOrderingConstraint> constraintList,
                          java.util.Map<java.lang.String,edu.umd.cs.findbugs.DetectorFactory> factoryMap,
                          edu.umd.cs.findbugs.plan.AnalysisPass pass)
          throws edu.umd.cs.findbugs.plan.OrderingConstraintException {
        java.util.Set<edu.umd.cs.findbugs.DetectorFactory> detectorSet =
          new java.util.HashSet<edu.umd.cs.findbugs.DetectorFactory>(
          pass.
            getMembers(
              ));
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                detectorSet.
                  size(
                    ) +
                " detectors currently in this pass");
        }
        java.util.List<edu.umd.cs.findbugs.plan.DetectorOrderingConstraint> passConstraintList =
          new java.util.LinkedList<edu.umd.cs.findbugs.plan.DetectorOrderingConstraint>(
          );
        for (edu.umd.cs.findbugs.plan.DetectorOrderingConstraint constraint
              :
              constraintList) {
            if (selectDetectors(
                  constraint.
                    getEarlier(
                      ),
                  detectorSet).
                  size(
                    ) >
                  0 ||
                  selectDetectors(
                    constraint.
                      getLater(
                        ),
                    detectorSet).
                  size(
                    ) >
                  0) {
                passConstraintList.
                  add(
                    constraint);
            }
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                passConstraintList.
                  size(
                    ) +
                " constraints are applicable for this pass");
        }
        java.util.HashSet<edu.umd.cs.findbugs.DetectorFactory> availableSet =
          new java.util.HashSet<edu.umd.cs.findbugs.DetectorFactory>(
          );
        availableSet.
          addAll(
            detectorSet);
        availableSet.
          addAll(
            getUnassignedSet(
              ));
        java.util.Map<java.lang.String,edu.umd.cs.findbugs.plan.DetectorNode> nodeMap =
          new java.util.HashMap<java.lang.String,edu.umd.cs.findbugs.plan.DetectorNode>(
          );
        edu.umd.cs.findbugs.plan.ConstraintGraph constraintGraph =
          buildConstraintGraph(
            nodeMap,
            availableSet,
            passConstraintList);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Pass constraint graph:");
            dumpGraph(
              constraintGraph);
        }
        for (edu.umd.cs.findbugs.plan.DetectorNode node
              :
              nodeMap.
               values(
                 )) {
            if (!pass.
                  contains(
                    node.
                      getFactory(
                        ))) {
                assignToPass(
                  node.
                    getFactory(
                      ),
                  pass);
            }
        }
        edu.umd.cs.findbugs.graph.DepthFirstSearch<edu.umd.cs.findbugs.plan.ConstraintGraph,edu.umd.cs.findbugs.plan.ConstraintEdge,edu.umd.cs.findbugs.plan.DetectorNode> dfs =
          new edu.umd.cs.findbugs.graph.DepthFirstSearch<edu.umd.cs.findbugs.plan.ConstraintGraph,edu.umd.cs.findbugs.plan.ConstraintEdge,edu.umd.cs.findbugs.plan.DetectorNode>(
          constraintGraph);
        dfs.
          search(
            );
        if (dfs.
              containsCycle(
                )) {
            throw new edu.umd.cs.findbugs.plan.OrderingConstraintException(
              "Cycle in intra-pass ordering constraints!");
        }
        for (java.util.Iterator<edu.umd.cs.findbugs.plan.DetectorNode> i =
               dfs.
               topologicalSortIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.plan.DetectorNode node =
              i.
              next(
                );
            appendToPass(
              node.
                getFactory(
                  ),
              pass);
        }
        appendDetectorsToPass(
          pass.
            getUnpositionedMembers(
              ),
          pass);
    }
    private java.util.Set<edu.umd.cs.findbugs.DetectorFactory> getUnassignedSet() {
        java.util.Set<edu.umd.cs.findbugs.DetectorFactory> unassignedSet =
          new java.util.HashSet<edu.umd.cs.findbugs.DetectorFactory>(
          );
        unassignedSet.
          addAll(
            factoryMap.
              values(
                ));
        unassignedSet.
          removeAll(
            assignedToPassSet);
        return unassignedSet;
    }
    private void assignToPass(edu.umd.cs.findbugs.DetectorFactory factory,
                              edu.umd.cs.findbugs.plan.AnalysisPass pass) {
        pass.
          addToPass(
            factory);
        assignedToPassSet.
          add(
            factory);
    }
    private void appendToPass(edu.umd.cs.findbugs.DetectorFactory factory,
                              edu.umd.cs.findbugs.plan.AnalysisPass pass) {
        pass.
          append(
            factory);
    }
    private void appendDetectorsToPass(java.util.Collection<edu.umd.cs.findbugs.DetectorFactory> detectorSet,
                                       edu.umd.cs.findbugs.plan.AnalysisPass pass) {
        edu.umd.cs.findbugs.DetectorFactory[] unassignedList =
          detectorSet.
          toArray(
            new edu.umd.cs.findbugs.DetectorFactory[detectorSet.
                                                      size(
                                                        )]);
        java.util.Arrays.
          sort(
            unassignedList,
            new java.util.Comparator<edu.umd.cs.findbugs.DetectorFactory>(
              ) {
                @java.lang.Override
                public int compare(edu.umd.cs.findbugs.DetectorFactory a,
                                   edu.umd.cs.findbugs.DetectorFactory b) {
                    int cmp =
                      a.
                      getPlugin(
                        ).
                      getPluginId(
                        ).
                      compareTo(
                        b.
                          getPlugin(
                            ).
                          getPluginId(
                            ));
                    if (cmp !=
                          0) {
                        return cmp;
                    }
                    return a.
                      getPositionSpecifiedInPluginDescriptor(
                        ) -
                      b.
                      getPositionSpecifiedInPluginDescriptor(
                        );
                }
            });
        for (edu.umd.cs.findbugs.DetectorFactory factory
              :
              unassignedList) {
            appendToPass(
              factory,
              pass);
        }
    }
    private void print() { java.lang.System.
                             out.println(
                                   "\nExecution plan:");
                           int passCount =
                             0;
                           for (java.util.Iterator<edu.umd.cs.findbugs.plan.AnalysisPass> i =
                                  passList.
                                  iterator(
                                    ); i.
                                         hasNext(
                                           );
                                ++passCount) {
                               java.lang.System.
                                 out.
                                 println(
                                   "Pass " +
                                   passCount);
                               edu.umd.cs.findbugs.plan.AnalysisPass pass =
                                 i.
                                 next(
                                   );
                               for (java.util.Iterator<edu.umd.cs.findbugs.DetectorFactory> j =
                                      pass.
                                      iterator(
                                        );
                                    j.
                                      hasNext(
                                        );
                                    ) {
                                   edu.umd.cs.findbugs.DetectorFactory factory =
                                     j.
                                     next(
                                       );
                                   java.lang.System.
                                     out.
                                     println(
                                       "  " +
                                       factory.
                                         getShortName(
                                           ));
                               }
                           }
                           java.lang.System.
                             out.println(
                                   ); }
    private void dumpGraph(edu.umd.cs.findbugs.plan.ConstraintGraph graph) {
        for (java.util.Iterator<edu.umd.cs.findbugs.plan.ConstraintEdge> i =
               graph.
               edgeIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.plan.ConstraintEdge edge =
              i.
              next(
                );
            java.lang.System.
              out.
              println(
                edge.
                  getSource(
                    ).
                  getFactory(
                    ).
                  getShortName(
                    ) +
                " ==> " +
                edge.
                  getTarget(
                    ).
                  getFactory(
                    ).
                  getShortName(
                    ));
        }
    }
    public static void main(java.lang.String[] argv)
          throws java.lang.Exception { edu.umd.cs.findbugs.DetectorFactoryCollection detectorFactoryCollection =
                                         edu.umd.cs.findbugs.DetectorFactoryCollection.
                                         instance(
                                           );
                                       edu.umd.cs.findbugs.plan.ExecutionPlan execPlan =
                                         new edu.umd.cs.findbugs.plan.ExecutionPlan(
                                         );
                                       for (java.lang.String pluginId
                                             :
                                             argv) {
                                           edu.umd.cs.findbugs.Plugin plugin =
                                             detectorFactoryCollection.
                                             getPluginById(
                                               pluginId);
                                           if (plugin !=
                                                 null) {
                                               execPlan.
                                                 addPlugin(
                                                   plugin);
                                           }
                                       }
                                       execPlan.
                                         build(
                                           );
                                       java.lang.System.
                                         out.
                                         println(
                                           execPlan.
                                             getNumPasses(
                                               ) +
                                           " passes in plan");
                                       execPlan.
                                         print(
                                           );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Hf3spYt73z5bQsogyEb/JuiwYoYleSwo2eTsoLELrtYAFfi9cZxaTvczgZuC" +
       "rcvdza0XKFkS1Dcz1fmrLgiWdkn6ajWTTjLX77ZTlRlNc9YyFam+7FlzOwTB" +
       "I8Aux7ppWEgdg53rIsYNzGQ7K8FM17e0N3d2Jrq+0tGa6G7e0ta8ur2VqasG" +
       "lZFWS6Fr7E548JFT9Sl+q+oOZsCyzojOESKangB/7vCaZ6lA87wMPitNllYG" +
       "mOd7uXnGoj/fDgdRwyzuY9Hw7pYBVTUk3eJ4oR/HayQqYeO1LhIPc/cVyFwM" +
       "Pk3m8JoCmPvLUOaCqClm+QyDuRi8MTisck7xMyu2YUfynVj8VU4zfBMoWHec" +
       "tcgGGhW8f/v/c0BIvY89jCsyXn4jN7R5gamgZghTdxuy0QHdXI7+Hi1QxNjf" +
       "DaaQbggQ8ZOhIg6ihjjC1F9Y6Y1QyPWuRaePdH+Ug3CsLV1oijdP+4i1hPGP" +
       "Y42OUKwBQ8jJ8zSTZ7dbnnNHMCX587E44+3tZndvDmPHM+eXowh/U6AitMLn" +
       "JlOUNwUowkuhihBETckktrmAKs0zabBkpfbUd4QuO/k1cwA8aAmdqXj7Lgu1" +
       "awLnlCUIlohAb5wbxOUA+/JlANtsQtMcAOz5UGCDqDmwupAPLFaf84z7rQLH" +
       "jYn7FvPJLQHj/k3ouIOoKamFEcv9aYgbVRx8pzRSL1DvykD6GIiLfgYCmuLN" +
       "S1fE7gcMITelLzkNPpbPXI6W/TZEWlkb9UU51NlfGfFsvDhQd48BFkJBe2Ns" +
       "6X38rsPHkpsfXmqtubZRMpqq2hJFGpIUR1cNeUuqjWw30M46vTXu3t/8uLF/" +
       "dSE7D3hvxjB7C/h7ZvgizTuU5+96b0rXjQM7CthEmOlBydvlYxtPnF03X7w3" +
       "yrY+eTosb8vUTdTkCdYh/s/oaXcaYa47kT8ZPttNuW73zkVbczwqkUuPB5EG" +
       "J5IjFSF1lViUUFKelA0NwkzWiHnELq6aPZSUDqlyMqfOkdLhjE94LhdvNPMg" +
       "4nM3Mh3wGTTZGywcmSBSD/eOmfogg6AhBJ4pWNRTMtmQaGBYHqmywRlfBHDq" +
       "sW4qfFSTQ7VwcIJIg8F5ngEwLwQcfFZkFoT/stEsYrIPG3XaWMwuJhaGyZBR" +
       "OBZBpP5YjNCbTbBT6sz65vuzyLU5f1ZtR4VWOiGy4op4tMBhWD4tsoL5tC7u" +
       "04zgVMqXZSXZIuhJntt6+PPRc1dNOvtFZm7zMxZhWQoY1xwc3HLgopIjz78p" +
       "6b4yG/2rM/2WQbZeIShSz2b6CkQ4LWyZMKIogc2hZSHzqw2LJcHzK1YsQ/wF" +
       "+OwxJ8mewudXEGmwrfkLxm9XyAQExK8NXBTkLwZas6KkYTjAOkZ/FtkMUY+Q" +
       "TPJ0ksdqdxQLSdyWut+E4/7CkQwiDVEaMRDlyJdZA9SiyC2UjOrNwAz3AJEo" +
       "AhBs8mP66WOTm48LByKINAQILaSOee1BSqowcdVGJfaewggNfYO9ZrAofWx9" +
       "Jmfr6+y1i9UeG2SviLkPG0zO4me9q5gTI7JPtlYoRdCKaqxDR/6ZKdrPCteK" +
       "INIQyf95SN0BLP4MtKJfopsyKVzNSjzV/yUszIDYExyXyOZrqCH47SsCfmhZ" +
       "8B2ZSJT3yb8D8GOlYzcxipfsTb+Nnt3EupAePdBFd9m5uEGHzpv6zzRvBJqO" +
       "TW5zqjvcZIvgCWHMseTb3ZRM6tiyuaV1zdYtre59B2wWOeKIdEau8gXlr+13" +
       "UXyMwPf98tc2BTY5eUXMQPiAcobgpMcQRB4aeaByLGTi/JiBTfE1VW13F75N" +
       "6vQp3x6J9jvc1EMjnQLTsO5qoGowtaRhGBOSn9cKJPVwW8JfRcnpupW8NhPZ" +
       "WJ5mhY84HXlrvP20pRPBGwdWGLnJTI08i8XzI049XcDiHJPMP4ZI7WUsngbd" +
       "ZIGAHTut0wVtwBrkFwIH6UfA5H2mCNZutiXqq0x5XVW4qINIQ8waAHD1sFIy" +
       "8wGdksJ+MgkwgN8MAf8dLF6FlaDByKy+WNsLNpavFQHLGVh3HQCx1ARkaeFY" +
       "BpF6OC5lAylFTs5j8aylnpFfMBTeC0HoEhbvQogDQftmvUWXBCo5J4ZhT8aL" +
       "rqQxlpdYMazjIR/iQ84WGA79rghCmWwpuLnzEsnbtxleKEGk/rYMfz5jCcWU" +
       "x6ch8vgciz+Cxw2QB0PSBum/iwCStUsfudnkdEPhIG0IIA3W3F9g8R9WQV7F" +
       "h0Qrg5GKVmExipIJIgPJsSpN9rMEq8M7RsuKhRNoQWSbyey2wnEKIvXw7fDb" +
       "TIWiIQ3Y+jM6GYs6SsYyt9NhvjngQaW+WKgsgrHcY7J2T+GoBJEGMg1rLeSn" +
       "MURd5mMxk5JyzE6YyUAHFLOKBQX4gci3TH4OFQ7FoQDSYGvDdjF/aIOydDhV" +
       "uQaLxZRUGKpOfaBZUqxIA9xa5JzJ37nCoQkiDVGCG0PqVmGxkpIaWJduTVvb" +
       "reZGqB0sRL9YLE1pA17OmzydLxyOIFL/wGun6ZdMJbk5BJiNWKyFBTvHhG9A" +
       "e3RkXTFBedfk7N3CQQkiHREofxoCSg8WnQiKpknppC8oXcUCpRc4umhydrFw" +
       "UIJI/UHJBYDWQttcdGN5cufwi2ts8iRDdsRLKw6/FAJ/Cosd4Pw5/LnA3lcO" +
       "QrHkAMvZyKcmmJ8WLocg0hC+syF1e7AwKBml6RAFeTCgxcIAjHh0DO+TfxeE" +
       "QSDpcAHQ3SFAYBYmegclo5OZlMaWzR4w7iwCGHVYtxA4qTc5qg8Bg5XeTGEM" +
       "C2+msDakR3+MDP/jBOy8HN9l3D7muaeNh373pPWmSkoL26Hc0L7cQXvse3Nf" +
       "/vqxub9mx9UqZKNb0Jv1fp+D4w6aD0+88/65sdNPsvdZcm/sj/WeuM8/UO86" +
       "J883O7Xgd/7ygMDfLZr55lX06HDQb2JP6KKkTJHS/eyIduQQUh7RbCXw5C3q" +
       "nVvMalrCt7qtOp6NlNVY7r8UQGWe1eNqxNKH0SP2VFnExhKi5I+F1H0fi++B" +
       "JRBxTJyFkOYng1TcN3Nopiqj9wWoXz4yrm3CKPqC6AFKSlOCd4cwevBKTMws" +
       "rHpc58PxYGND3n+f4P8xQTx5rLpi0rGtr3HltP6rQVU7qejLKIrz6J3jukzT" +
       "pT6Z6UsVK2u5AH9CSUNQJgs4xi8cdfQ0b/40wOTTHEJx69LZ+h8oqbRbUxIV" +
       "XdXPwtrGrKakBEpn5QtwCyrx8qzmM4PMIwKRfAfN3q2bMJxcHG/JzQ08tLIx" +
       "w/87SEI8dWzDpq99dN3D/LC0qAh70HnhWY9yfm7bnPLe0zXO3qy+ytYv+GTc" +
       "E6PnWdaslg/YtrZTbVXHF0IjGurDFM9JYqMxd6D4jePX/+yl/WXnorgsjwgg" +
       "o235JzmzWkYn07e15x+Msw53NC34zu4bF/f955vsrKxpmacFt0+IPfe93vbE" +
       "4B9WsX9GMQo0QMqyI6Zrdqe3SOKQ7jpl539UZqzrqAwlc/IPGQ57NAYM8xj7" +
       "jmWLQ07LIIF9x2GtE8yIZRF90L9E+0ZNM3dTStdrbLbuCAwCo+fZJV699X87" +
       "v36+JkgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VPHJYrKpzOvYiqmSfCpSA9zR5cpCnPQ3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
