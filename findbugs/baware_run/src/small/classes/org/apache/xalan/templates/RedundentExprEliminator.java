package org.apache.xalan.templates;
public class RedundentExprEliminator extends org.apache.xalan.templates.XSLTVisitor {
    java.util.Vector m_paths;
    java.util.Vector m_absPaths;
    boolean m_isSameContext;
    org.apache.xalan.templates.AbsPathChecker m_absPathChecker = new org.apache.xalan.templates.AbsPathChecker(
      );
    private static int m_uniquePseudoVarID = 1;
    static final java.lang.String PSUEDOVARNAMESPACE = org.apache.xalan.templates.Constants.
                                                         S_VENDORURL +
    "/xalan/psuedovar";
    public static final boolean DEBUG = false;
    public static final boolean DIAGNOSE_NUM_PATHS_REDUCED =
      false;
    public static final boolean DIAGNOSE_MULTISTEPLIST = false;
    org.apache.xalan.templates.VarNameCollector m_varNameCollector =
      new org.apache.xalan.templates.VarNameCollector(
      );
    public RedundentExprEliminator() { super();
                                       m_isSameContext = true;
                                       m_absPaths = new java.util.Vector(
                                                      );
                                       m_paths = null; }
    public void eleminateRedundentLocals(org.apache.xalan.templates.ElemTemplateElement psuedoVarRecipient) {
        eleminateRedundent(
          psuedoVarRecipient,
          m_paths);
    }
    public void eleminateRedundentGlobals(org.apache.xalan.templates.StylesheetRoot stylesheet) {
        eleminateRedundent(
          stylesheet,
          m_absPaths);
    }
    protected void eleminateRedundent(org.apache.xalan.templates.ElemTemplateElement psuedoVarRecipient,
                                      java.util.Vector paths) {
        int n =
          paths.
          size(
            );
        int numPathsEliminated =
          0;
        int numUniquePathsEliminated =
          0;
        for (int i =
               0;
             i <
               n;
             i++) {
            org.apache.xpath.ExpressionOwner owner =
              (org.apache.xpath.ExpressionOwner)
                paths.
                elementAt(
                  i);
            if (null !=
                  owner) {
                int found =
                  findAndEliminateRedundant(
                    i +
                      1,
                    i,
                    owner,
                    psuedoVarRecipient,
                    paths);
                if (found >
                      0)
                    numUniquePathsEliminated++;
                numPathsEliminated +=
                  found;
            }
        }
        eleminateSharedPartialPaths(
          psuedoVarRecipient,
          paths);
        if (DIAGNOSE_NUM_PATHS_REDUCED)
            diagnoseNumPaths(
              paths,
              numPathsEliminated,
              numUniquePathsEliminated);
    }
    protected void eleminateSharedPartialPaths(org.apache.xalan.templates.ElemTemplateElement psuedoVarRecipient,
                                               java.util.Vector paths) {
        org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder list =
          createMultistepExprList(
            paths);
        if (null !=
              list) {
            if (DIAGNOSE_MULTISTEPLIST)
                list.
                  diagnose(
                    );
            boolean isGlobal =
              paths ==
              m_absPaths;
            int longestStepsCount =
              list.
                m_stepCount;
            for (int i =
                   longestStepsCount -
                   1;
                 i >=
                   1;
                 i--) {
                org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder next =
                  list;
                while (null !=
                         next) {
                    if (next.
                          m_stepCount <
                          i)
                        break;
                    list =
                      matchAndEliminatePartialPaths(
                        next,
                        list,
                        isGlobal,
                        i,
                        psuedoVarRecipient);
                    next =
                      next.
                        m_next;
                }
            }
        }
    }
    protected org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder matchAndEliminatePartialPaths(org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder testee,
                                                                                                                   org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder head,
                                                                                                                   boolean isGlobal,
                                                                                                                   int lengthToTest,
                                                                                                                   org.apache.xalan.templates.ElemTemplateElement varScope) {
        if (null ==
              testee.
                m_exprOwner)
            return head;
        org.apache.xpath.axes.WalkingIterator iter1 =
          (org.apache.xpath.axes.WalkingIterator)
            testee.
              m_exprOwner.
            getExpression(
              );
        if (partialIsVariable(
              testee,
              lengthToTest))
            return head;
        org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder matchedPaths =
          null;
        org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder matchedPathsTail =
          null;
        org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder meh =
          head;
        while (null !=
                 meh) {
            if (meh !=
                  testee &&
                  null !=
                  meh.
                    m_exprOwner) {
                org.apache.xpath.axes.WalkingIterator iter2 =
                  (org.apache.xpath.axes.WalkingIterator)
                    meh.
                      m_exprOwner.
                    getExpression(
                      );
                if (stepsEqual(
                      iter1,
                      iter2,
                      lengthToTest)) {
                    if (null ==
                          matchedPaths) {
                        try {
                            matchedPaths =
                              (org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder)
                                testee.
                                clone(
                                  );
                            testee.
                              m_exprOwner =
                              null;
                        }
                        catch (java.lang.CloneNotSupportedException cnse) {
                            
                        }
                        matchedPathsTail =
                          matchedPaths;
                        matchedPathsTail.
                          m_next =
                          null;
                    }
                    try {
                        matchedPathsTail.
                          m_next =
                          (org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder)
                            meh.
                            clone(
                              );
                        meh.
                          m_exprOwner =
                          null;
                    }
                    catch (java.lang.CloneNotSupportedException cnse) {
                        
                    }
                    matchedPathsTail =
                      matchedPathsTail.
                        m_next;
                    matchedPathsTail.
                      m_next =
                      null;
                }
            }
            meh =
              meh.
                m_next;
        }
        int matchCount =
          0;
        if (null !=
              matchedPaths) {
            org.apache.xalan.templates.ElemTemplateElement root =
              isGlobal
              ? varScope
              : findCommonAncestor(
                  matchedPaths);
            org.apache.xpath.axes.WalkingIterator sharedIter =
              (org.apache.xpath.axes.WalkingIterator)
                matchedPaths.
                  m_exprOwner.
                getExpression(
                  );
            org.apache.xpath.axes.WalkingIterator newIter =
              createIteratorFromSteps(
                sharedIter,
                lengthToTest);
            org.apache.xalan.templates.ElemVariable var =
              createPseudoVarDecl(
                root,
                newIter,
                isGlobal);
            if (DIAGNOSE_MULTISTEPLIST)
                java.lang.System.
                  err.
                  println(
                    "Created var: " +
                    var.
                      getName(
                        ) +
                    (isGlobal
                       ? "(Global)"
                       : ""));
            while (null !=
                     matchedPaths) {
                org.apache.xpath.ExpressionOwner owner =
                  matchedPaths.
                    m_exprOwner;
                org.apache.xpath.axes.WalkingIterator iter =
                  (org.apache.xpath.axes.WalkingIterator)
                    owner.
                    getExpression(
                      );
                if (DIAGNOSE_MULTISTEPLIST)
                    diagnoseLineNumber(
                      iter);
                org.apache.xpath.axes.LocPathIterator newIter2 =
                  changePartToRef(
                    var.
                      getName(
                        ),
                    iter,
                    lengthToTest,
                    isGlobal);
                owner.
                  setExpression(
                    newIter2);
                matchedPaths =
                  matchedPaths.
                    m_next;
            }
        }
        if (DIAGNOSE_MULTISTEPLIST)
            diagnoseMultistepList(
              matchCount,
              lengthToTest,
              isGlobal);
        return head;
    }
    boolean partialIsVariable(org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder testee,
                              int lengthToTest) {
        if (1 ==
              lengthToTest) {
            org.apache.xpath.axes.WalkingIterator wi =
              (org.apache.xpath.axes.WalkingIterator)
                testee.
                  m_exprOwner.
                getExpression(
                  );
            if (wi.
                  getFirstWalker(
                    ) instanceof org.apache.xpath.axes.FilterExprWalker)
                return true;
        }
        return false;
    }
    protected void diagnoseLineNumber(org.apache.xpath.Expression expr) {
        org.apache.xalan.templates.ElemTemplateElement e =
          getElemFromExpression(
            expr);
        java.lang.System.
          err.
          println(
            "   " +
            e.
              getSystemId(
                ) +
            " Line " +
            e.
              getLineNumber(
                ));
    }
    protected org.apache.xalan.templates.ElemTemplateElement findCommonAncestor(org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder head) {
        int numExprs =
          head.
          getLength(
            );
        org.apache.xalan.templates.ElemTemplateElement[] elems =
          new org.apache.xalan.templates.ElemTemplateElement[numExprs];
        int[] ancestorCounts =
          new int[numExprs];
        org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder next =
          head;
        int shortestAncestorCount =
          10000;
        for (int i =
               0;
             i <
               numExprs;
             i++) {
            org.apache.xalan.templates.ElemTemplateElement elem =
              getElemFromExpression(
                next.
                  m_exprOwner.
                  getExpression(
                    ));
            elems[i] =
              elem;
            int numAncestors =
              countAncestors(
                elem);
            ancestorCounts[i] =
              numAncestors;
            if (numAncestors <
                  shortestAncestorCount) {
                shortestAncestorCount =
                  numAncestors;
            }
            next =
              next.
                m_next;
        }
        for (int i =
               0;
             i <
               numExprs;
             i++) {
            if (ancestorCounts[i] >
                  shortestAncestorCount) {
                int numStepCorrection =
                  ancestorCounts[i] -
                  shortestAncestorCount;
                for (int j =
                       0;
                     j <
                       numStepCorrection;
                     j++) {
                    elems[i] =
                      elems[i].
                        getParentElem(
                          );
                }
            }
        }
        org.apache.xalan.templates.ElemTemplateElement first =
          null;
        while (shortestAncestorCount-- >=
                 0) {
            boolean areEqual =
              true;
            first =
              elems[0];
            for (int i =
                   1;
                 i <
                   numExprs;
                 i++) {
                if (first !=
                      elems[i]) {
                    areEqual =
                      false;
                    break;
                }
            }
            if (areEqual &&
                  isNotSameAsOwner(
                    head,
                    first) &&
                  first.
                  canAcceptVariables(
                    )) {
                if (DIAGNOSE_MULTISTEPLIST) {
                    java.lang.System.
                      err.
                      print(
                        first.
                          getClass(
                            ).
                          getName(
                            ));
                    java.lang.System.
                      err.
                      println(
                        " at   " +
                        first.
                          getSystemId(
                            ) +
                        " Line " +
                        first.
                          getLineNumber(
                            ));
                }
                return first;
            }
            for (int i =
                   0;
                 i <
                   numExprs;
                 i++) {
                elems[i] =
                  elems[i].
                    getParentElem(
                      );
            }
        }
        assertion(
          false,
          "Could not find common ancestor!!!");
        return null;
    }
    protected boolean isNotSameAsOwner(org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder head,
                                       org.apache.xalan.templates.ElemTemplateElement ete) {
        org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder next =
          head;
        while (null !=
                 next) {
            org.apache.xalan.templates.ElemTemplateElement elemOwner =
              getElemFromExpression(
                next.
                  m_exprOwner.
                  getExpression(
                    ));
            if (elemOwner ==
                  ete)
                return false;
            next =
              next.
                m_next;
        }
        return true;
    }
    protected int countAncestors(org.apache.xalan.templates.ElemTemplateElement elem) {
        int count =
          0;
        while (null !=
                 elem) {
            count++;
            elem =
              elem.
                getParentElem(
                  );
        }
        return count;
    }
    protected void diagnoseMultistepList(int matchCount,
                                         int lengthToTest,
                                         boolean isGlobal) {
        if (matchCount >
              0) {
            java.lang.System.
              err.
              print(
                "Found multistep matches: " +
                matchCount +
                ", " +
                lengthToTest +
                " length");
            if (isGlobal)
                java.lang.System.
                  err.
                  println(
                    " (global)");
            else
                java.lang.System.
                  err.
                  println(
                    );
        }
    }
    protected org.apache.xpath.axes.LocPathIterator changePartToRef(final org.apache.xml.utils.QName uniquePseudoVarName,
                                                                    org.apache.xpath.axes.WalkingIterator wi,
                                                                    final int numSteps,
                                                                    final boolean isGlobal) {
        org.apache.xpath.operations.Variable var =
          new org.apache.xpath.operations.Variable(
          );
        var.
          setQName(
            uniquePseudoVarName);
        var.
          setIsGlobal(
            isGlobal);
        if (isGlobal) {
            org.apache.xalan.templates.ElemTemplateElement elem =
              getElemFromExpression(
                wi);
            org.apache.xalan.templates.StylesheetRoot root =
              elem.
              getStylesheetRoot(
                );
            java.util.Vector vars =
              root.
              getVariablesAndParamsComposed(
                );
            var.
              setIndex(
                vars.
                  size(
                    ) -
                  1);
        }
        org.apache.xpath.axes.AxesWalker walker =
          wi.
          getFirstWalker(
            );
        for (int i =
               0;
             i <
               numSteps;
             i++) {
            assertion(
              null !=
                walker,
              "Walker should not be null!");
            walker =
              walker.
                getNextWalker(
                  );
        }
        if (null !=
              walker) {
            org.apache.xpath.axes.FilterExprWalker few =
              new org.apache.xpath.axes.FilterExprWalker(
              wi);
            few.
              setInnerExpression(
                var);
            few.
              exprSetParent(
                wi);
            few.
              setNextWalker(
                walker);
            walker.
              setPrevWalker(
                few);
            wi.
              setFirstWalker(
                few);
            return wi;
        }
        else {
            org.apache.xpath.axes.FilterExprIteratorSimple feis =
              new org.apache.xpath.axes.FilterExprIteratorSimple(
              var);
            feis.
              exprSetParent(
                wi.
                  exprGetParent(
                    ));
            return feis;
        }
    }
    protected org.apache.xpath.axes.WalkingIterator createIteratorFromSteps(final org.apache.xpath.axes.WalkingIterator wi,
                                                                            int numSteps) {
        org.apache.xpath.axes.WalkingIterator newIter =
          new org.apache.xpath.axes.WalkingIterator(
          wi.
            getPrefixResolver(
              ));
        try {
            org.apache.xpath.axes.AxesWalker walker =
              (org.apache.xpath.axes.AxesWalker)
                wi.
                getFirstWalker(
                  ).
                clone(
                  );
            newIter.
              setFirstWalker(
                walker);
            walker.
              setLocPathIterator(
                newIter);
            for (int i =
                   1;
                 i <
                   numSteps;
                 i++) {
                org.apache.xpath.axes.AxesWalker next =
                  (org.apache.xpath.axes.AxesWalker)
                    walker.
                    getNextWalker(
                      ).
                    clone(
                      );
                walker.
                  setNextWalker(
                    next);
                next.
                  setLocPathIterator(
                    newIter);
                walker =
                  next;
            }
            walker.
              setNextWalker(
                null);
        }
        catch (java.lang.CloneNotSupportedException cnse) {
            throw new org.apache.xml.utils.WrappedRuntimeException(
              cnse);
        }
        return newIter;
    }
    protected boolean stepsEqual(org.apache.xpath.axes.WalkingIterator iter1,
                                 org.apache.xpath.axes.WalkingIterator iter2,
                                 int numSteps) {
        org.apache.xpath.axes.AxesWalker aw1 =
          iter1.
          getFirstWalker(
            );
        org.apache.xpath.axes.AxesWalker aw2 =
          iter2.
          getFirstWalker(
            );
        for (int i =
               0;
             i <
               numSteps;
             i++) {
            if (null ==
                  aw1 ||
                  null ==
                  aw2)
                return false;
            if (!aw1.
                  deepEquals(
                    aw2))
                return false;
            aw1 =
              aw1.
                getNextWalker(
                  );
            aw2 =
              aw2.
                getNextWalker(
                  );
        }
        assertion(
          null !=
            aw1 ||
            null !=
            aw2,
          "Total match is incorrect!");
        return true;
    }
    protected org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder createMultistepExprList(java.util.Vector paths) {
        org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder first =
          null;
        int n =
          paths.
          size(
            );
        for (int i =
               0;
             i <
               n;
             i++) {
            org.apache.xpath.ExpressionOwner eo =
              (org.apache.xpath.ExpressionOwner)
                paths.
                elementAt(
                  i);
            if (null ==
                  eo)
                continue;
            org.apache.xpath.axes.LocPathIterator lpi =
              (org.apache.xpath.axes.LocPathIterator)
                eo.
                getExpression(
                  );
            int numPaths =
              countSteps(
                lpi);
            if (numPaths >
                  1) {
                if (null ==
                      first)
                    first =
                      new org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder(
                        eo,
                        numPaths,
                        null);
                else
                    first =
                      first.
                        addInSortedOrder(
                          eo,
                          numPaths);
            }
        }
        if (null ==
              first ||
              first.
              getLength(
                ) <=
              1)
            return null;
        else
            return first;
    }
    protected int findAndEliminateRedundant(int start,
                                            int firstOccuranceIndex,
                                            org.apache.xpath.ExpressionOwner firstOccuranceOwner,
                                            org.apache.xalan.templates.ElemTemplateElement psuedoVarRecipient,
                                            java.util.Vector paths)
          throws org.w3c.dom.DOMException {
        org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder head =
          null;
        org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder tail =
          null;
        int numPathsFound =
          0;
        int n =
          paths.
          size(
            );
        org.apache.xpath.Expression expr1 =
          firstOccuranceOwner.
          getExpression(
            );
        if (DEBUG)
            assertIsLocPathIterator(
              expr1,
              firstOccuranceOwner);
        boolean isGlobal =
          paths ==
          m_absPaths;
        org.apache.xpath.axes.LocPathIterator lpi =
          (org.apache.xpath.axes.LocPathIterator)
            expr1;
        int stepCount =
          countSteps(
            lpi);
        for (int j =
               start;
             j <
               n;
             j++) {
            org.apache.xpath.ExpressionOwner owner2 =
              (org.apache.xpath.ExpressionOwner)
                paths.
                elementAt(
                  j);
            if (null !=
                  owner2) {
                org.apache.xpath.Expression expr2 =
                  owner2.
                  getExpression(
                    );
                boolean isEqual =
                  expr2.
                  deepEquals(
                    lpi);
                if (isEqual) {
                    org.apache.xpath.axes.LocPathIterator lpi2 =
                      (org.apache.xpath.axes.LocPathIterator)
                        expr2;
                    if (null ==
                          head) {
                        head =
                          new org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder(
                            firstOccuranceOwner,
                            stepCount,
                            null);
                        tail =
                          head;
                        numPathsFound++;
                    }
                    tail.
                      m_next =
                      new org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder(
                        owner2,
                        stepCount,
                        null);
                    tail =
                      tail.
                        m_next;
                    paths.
                      setElementAt(
                        null,
                        j);
                    numPathsFound++;
                }
            }
        }
        if (0 ==
              numPathsFound &&
              isGlobal) {
            head =
              new org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder(
                firstOccuranceOwner,
                stepCount,
                null);
            numPathsFound++;
        }
        if (null !=
              head) {
            org.apache.xalan.templates.ElemTemplateElement root =
              isGlobal
              ? psuedoVarRecipient
              : findCommonAncestor(
                  head);
            org.apache.xpath.axes.LocPathIterator sharedIter =
              (org.apache.xpath.axes.LocPathIterator)
                head.
                  m_exprOwner.
                getExpression(
                  );
            org.apache.xalan.templates.ElemVariable var =
              createPseudoVarDecl(
                root,
                sharedIter,
                isGlobal);
            if (DIAGNOSE_MULTISTEPLIST)
                java.lang.System.
                  err.
                  println(
                    "Created var: " +
                    var.
                      getName(
                        ) +
                    (isGlobal
                       ? "(Global)"
                       : ""));
            org.apache.xml.utils.QName uniquePseudoVarName =
              var.
              getName(
                );
            while (null !=
                     head) {
                org.apache.xpath.ExpressionOwner owner =
                  head.
                    m_exprOwner;
                if (DIAGNOSE_MULTISTEPLIST)
                    diagnoseLineNumber(
                      owner.
                        getExpression(
                          ));
                changeToVarRef(
                  uniquePseudoVarName,
                  owner,
                  paths,
                  root);
                head =
                  head.
                    m_next;
            }
            paths.
              setElementAt(
                var.
                  getSelect(
                    ),
                firstOccuranceIndex);
        }
        return numPathsFound;
    }
    protected int oldFindAndEliminateRedundant(int start,
                                               int firstOccuranceIndex,
                                               org.apache.xpath.ExpressionOwner firstOccuranceOwner,
                                               org.apache.xalan.templates.ElemTemplateElement psuedoVarRecipient,
                                               java.util.Vector paths)
          throws org.w3c.dom.DOMException {
        org.apache.xml.utils.QName uniquePseudoVarName =
          null;
        boolean foundFirst =
          false;
        int numPathsFound =
          0;
        int n =
          paths.
          size(
            );
        org.apache.xpath.Expression expr1 =
          firstOccuranceOwner.
          getExpression(
            );
        if (DEBUG)
            assertIsLocPathIterator(
              expr1,
              firstOccuranceOwner);
        boolean isGlobal =
          paths ==
          m_absPaths;
        org.apache.xpath.axes.LocPathIterator lpi =
          (org.apache.xpath.axes.LocPathIterator)
            expr1;
        for (int j =
               start;
             j <
               n;
             j++) {
            org.apache.xpath.ExpressionOwner owner2 =
              (org.apache.xpath.ExpressionOwner)
                paths.
                elementAt(
                  j);
            if (null !=
                  owner2) {
                org.apache.xpath.Expression expr2 =
                  owner2.
                  getExpression(
                    );
                boolean isEqual =
                  expr2.
                  deepEquals(
                    lpi);
                if (isEqual) {
                    org.apache.xpath.axes.LocPathIterator lpi2 =
                      (org.apache.xpath.axes.LocPathIterator)
                        expr2;
                    if (!foundFirst) {
                        foundFirst =
                          true;
                        org.apache.xalan.templates.ElemVariable var =
                          createPseudoVarDecl(
                            psuedoVarRecipient,
                            lpi,
                            isGlobal);
                        if (null ==
                              var)
                            return 0;
                        uniquePseudoVarName =
                          var.
                            getName(
                              );
                        changeToVarRef(
                          uniquePseudoVarName,
                          firstOccuranceOwner,
                          paths,
                          psuedoVarRecipient);
                        paths.
                          setElementAt(
                            var.
                              getSelect(
                                ),
                            firstOccuranceIndex);
                        numPathsFound++;
                    }
                    changeToVarRef(
                      uniquePseudoVarName,
                      owner2,
                      paths,
                      psuedoVarRecipient);
                    paths.
                      setElementAt(
                        null,
                        j);
                    numPathsFound++;
                }
            }
        }
        if (0 ==
              numPathsFound &&
              paths ==
              m_absPaths) {
            org.apache.xalan.templates.ElemVariable var =
              createPseudoVarDecl(
                psuedoVarRecipient,
                lpi,
                true);
            if (null ==
                  var)
                return 0;
            uniquePseudoVarName =
              var.
                getName(
                  );
            changeToVarRef(
              uniquePseudoVarName,
              firstOccuranceOwner,
              paths,
              psuedoVarRecipient);
            paths.
              setElementAt(
                var.
                  getSelect(
                    ),
                firstOccuranceIndex);
            numPathsFound++;
        }
        return numPathsFound;
    }
    protected int countSteps(org.apache.xpath.axes.LocPathIterator lpi) {
        if (lpi instanceof org.apache.xpath.axes.WalkingIterator) {
            org.apache.xpath.axes.WalkingIterator wi =
              (org.apache.xpath.axes.WalkingIterator)
                lpi;
            org.apache.xpath.axes.AxesWalker aw =
              wi.
              getFirstWalker(
                );
            int count =
              0;
            while (null !=
                     aw) {
                count++;
                aw =
                  aw.
                    getNextWalker(
                      );
            }
            return count;
        }
        else
            return 1;
    }
    protected void changeToVarRef(org.apache.xml.utils.QName varName,
                                  org.apache.xpath.ExpressionOwner owner,
                                  java.util.Vector paths,
                                  org.apache.xalan.templates.ElemTemplateElement psuedoVarRecipient) {
        org.apache.xpath.operations.Variable varRef =
          paths ==
          m_absPaths
          ? new org.apache.xpath.operations.VariableSafeAbsRef(
          )
          : new org.apache.xpath.operations.Variable(
          );
        varRef.
          setQName(
            varName);
        if (paths ==
              m_absPaths) {
            org.apache.xalan.templates.StylesheetRoot root =
              (org.apache.xalan.templates.StylesheetRoot)
                psuedoVarRecipient;
            java.util.Vector globalVars =
              root.
              getVariablesAndParamsComposed(
                );
            varRef.
              setIndex(
                globalVars.
                  size(
                    ) -
                  1);
            varRef.
              setIsGlobal(
                true);
        }
        owner.
          setExpression(
            varRef);
    }
    private static synchronized int getPseudoVarID() {
        return m_uniquePseudoVarID++;
    }
    protected org.apache.xalan.templates.ElemVariable createPseudoVarDecl(org.apache.xalan.templates.ElemTemplateElement psuedoVarRecipient,
                                                                          org.apache.xpath.axes.LocPathIterator lpi,
                                                                          boolean isGlobal)
          throws org.w3c.dom.DOMException {
        org.apache.xml.utils.QName uniquePseudoVarName =
          new org.apache.xml.utils.QName(
          PSUEDOVARNAMESPACE,
          "#" +
          getPseudoVarID(
            ));
        if (isGlobal) {
            return createGlobalPseudoVarDecl(
                     uniquePseudoVarName,
                     (org.apache.xalan.templates.StylesheetRoot)
                       psuedoVarRecipient,
                     lpi);
        }
        else
            return createLocalPseudoVarDecl(
                     uniquePseudoVarName,
                     psuedoVarRecipient,
                     lpi);
    }
    protected org.apache.xalan.templates.ElemVariable createGlobalPseudoVarDecl(org.apache.xml.utils.QName uniquePseudoVarName,
                                                                                org.apache.xalan.templates.StylesheetRoot stylesheetRoot,
                                                                                org.apache.xpath.axes.LocPathIterator lpi)
          throws org.w3c.dom.DOMException {
        org.apache.xalan.templates.ElemVariable psuedoVar =
          new org.apache.xalan.templates.ElemVariable(
          );
        psuedoVar.
          setIsTopLevel(
            true);
        org.apache.xpath.XPath xpath =
          new org.apache.xpath.XPath(
          lpi);
        psuedoVar.
          setSelect(
            xpath);
        psuedoVar.
          setName(
            uniquePseudoVarName);
        java.util.Vector globalVars =
          stylesheetRoot.
          getVariablesAndParamsComposed(
            );
        psuedoVar.
          setIndex(
            globalVars.
              size(
                ));
        globalVars.
          addElement(
            psuedoVar);
        return psuedoVar;
    }
    protected org.apache.xalan.templates.ElemVariable createLocalPseudoVarDecl(org.apache.xml.utils.QName uniquePseudoVarName,
                                                                               org.apache.xalan.templates.ElemTemplateElement psuedoVarRecipient,
                                                                               org.apache.xpath.axes.LocPathIterator lpi)
          throws org.w3c.dom.DOMException {
        org.apache.xalan.templates.ElemVariable psuedoVar =
          new org.apache.xalan.templates.ElemVariablePsuedo(
          );
        org.apache.xpath.XPath xpath =
          new org.apache.xpath.XPath(
          lpi);
        psuedoVar.
          setSelect(
            xpath);
        psuedoVar.
          setName(
            uniquePseudoVarName);
        org.apache.xalan.templates.ElemVariable var =
          addVarDeclToElem(
            psuedoVarRecipient,
            lpi,
            psuedoVar);
        lpi.
          exprSetParent(
            var);
        return var;
    }
    protected org.apache.xalan.templates.ElemVariable addVarDeclToElem(org.apache.xalan.templates.ElemTemplateElement psuedoVarRecipient,
                                                                       org.apache.xpath.axes.LocPathIterator lpi,
                                                                       org.apache.xalan.templates.ElemVariable psuedoVar)
          throws org.w3c.dom.DOMException {
        org.apache.xalan.templates.ElemTemplateElement ete =
          psuedoVarRecipient.
          getFirstChildElem(
            );
        lpi.
          callVisitors(
            null,
            m_varNameCollector);
        if (m_varNameCollector.
              getVarCount(
                ) >
              0) {
            org.apache.xalan.templates.ElemTemplateElement baseElem =
              getElemFromExpression(
                lpi);
            org.apache.xalan.templates.ElemVariable varElem =
              getPrevVariableElem(
                baseElem);
            while (null !=
                     varElem) {
                if (m_varNameCollector.
                      doesOccur(
                        varElem.
                          getName(
                            ))) {
                    psuedoVarRecipient =
                      varElem.
                        getParentElem(
                          );
                    ete =
                      varElem.
                        getNextSiblingElem(
                          );
                    break;
                }
                varElem =
                  getPrevVariableElem(
                    varElem);
            }
        }
        if (null !=
              ete &&
              org.apache.xalan.templates.Constants.
                ELEMNAME_PARAMVARIABLE ==
              ete.
              getXSLToken(
                )) {
            if (isParam(
                  lpi))
                return null;
            while (null !=
                     ete) {
                ete =
                  ete.
                    getNextSiblingElem(
                      );
                if (null !=
                      ete &&
                      org.apache.xalan.templates.Constants.
                        ELEMNAME_PARAMVARIABLE !=
                      ete.
                      getXSLToken(
                        ))
                    break;
            }
        }
        psuedoVarRecipient.
          insertBefore(
            psuedoVar,
            ete);
        m_varNameCollector.
          reset(
            );
        return psuedoVar;
    }
    protected boolean isParam(org.apache.xpath.ExpressionNode expr) {
        while (null !=
                 expr) {
            if (expr instanceof org.apache.xalan.templates.ElemTemplateElement)
                break;
            expr =
              expr.
                exprGetParent(
                  );
        }
        if (null !=
              expr) {
            org.apache.xalan.templates.ElemTemplateElement ete =
              (org.apache.xalan.templates.ElemTemplateElement)
                expr;
            while (null !=
                     ete) {
                int type =
                  ete.
                  getXSLToken(
                    );
                switch (type) {
                    case org.apache.xalan.templates.Constants.
                           ELEMNAME_PARAMVARIABLE:
                        return true;
                    case org.apache.xalan.templates.Constants.
                           ELEMNAME_TEMPLATE:
                    case org.apache.xalan.templates.Constants.
                           ELEMNAME_STYLESHEET:
                        return false;
                }
                ete =
                  ete.
                    getParentElem(
                      );
            }
        }
        return false;
    }
    protected org.apache.xalan.templates.ElemVariable getPrevVariableElem(org.apache.xalan.templates.ElemTemplateElement elem) {
        while (null !=
                 (elem =
                    getPrevElementWithinContext(
                      elem))) {
            int type =
              elem.
              getXSLToken(
                );
            if (org.apache.xalan.templates.Constants.
                  ELEMNAME_VARIABLE ==
                  type ||
                  org.apache.xalan.templates.Constants.
                    ELEMNAME_PARAMVARIABLE ==
                  type) {
                return (org.apache.xalan.templates.ElemVariable)
                         elem;
            }
        }
        return null;
    }
    protected org.apache.xalan.templates.ElemTemplateElement getPrevElementWithinContext(org.apache.xalan.templates.ElemTemplateElement elem) {
        org.apache.xalan.templates.ElemTemplateElement prev =
          elem.
          getPreviousSiblingElem(
            );
        if (null ==
              prev)
            prev =
              elem.
                getParentElem(
                  );
        if (null !=
              prev) {
            int type =
              prev.
              getXSLToken(
                );
            if (org.apache.xalan.templates.Constants.
                  ELEMNAME_FOREACH ==
                  type ||
                  org.apache.xalan.templates.Constants.
                    ELEMNAME_TEMPLATE ==
                  type ||
                  org.apache.xalan.templates.Constants.
                    ELEMNAME_STYLESHEET ==
                  type) {
                prev =
                  null;
            }
        }
        return prev;
    }
    protected org.apache.xalan.templates.ElemTemplateElement getElemFromExpression(org.apache.xpath.Expression expr) {
        org.apache.xpath.ExpressionNode parent =
          expr.
          exprGetParent(
            );
        while (null !=
                 parent) {
            if (parent instanceof org.apache.xalan.templates.ElemTemplateElement)
                return (org.apache.xalan.templates.ElemTemplateElement)
                         parent;
            parent =
              parent.
                exprGetParent(
                  );
        }
        throw new java.lang.RuntimeException(
          org.apache.xalan.res.XSLMessages.
            createMessage(
              org.apache.xalan.res.XSLTErrorResources.
                ER_ASSERT_NO_TEMPLATE_PARENT,
              null));
    }
    public boolean isAbsolute(org.apache.xpath.axes.LocPathIterator path) {
        int analysis =
          path.
          getAnalysisBits(
            );
        boolean isAbs =
          org.apache.xpath.axes.WalkerFactory.
          isSet(
            analysis,
            org.apache.xpath.axes.WalkerFactory.
              BIT_ROOT) ||
          org.apache.xpath.axes.WalkerFactory.
          isSet(
            analysis,
            org.apache.xpath.axes.WalkerFactory.
              BIT_ANY_DESCENDANT_FROM_ROOT);
        if (isAbs) {
            isAbs =
              m_absPathChecker.
                checkAbsolute(
                  path);
        }
        return isAbs;
    }
    public boolean visitLocationPath(org.apache.xpath.ExpressionOwner owner,
                                     org.apache.xpath.axes.LocPathIterator path) {
        if (path instanceof org.apache.xpath.axes.SelfIteratorNoPredicate) {
            return true;
        }
        else
            if (path instanceof org.apache.xpath.axes.WalkingIterator) {
                org.apache.xpath.axes.WalkingIterator wi =
                  (org.apache.xpath.axes.WalkingIterator)
                    path;
                org.apache.xpath.axes.AxesWalker aw =
                  wi.
                  getFirstWalker(
                    );
                if (aw instanceof org.apache.xpath.axes.FilterExprWalker &&
                      null ==
                      aw.
                      getNextWalker(
                        )) {
                    org.apache.xpath.axes.FilterExprWalker few =
                      (org.apache.xpath.axes.FilterExprWalker)
                        aw;
                    org.apache.xpath.Expression exp =
                      few.
                      getInnerExpression(
                        );
                    if (exp instanceof org.apache.xpath.operations.Variable)
                        return true;
                }
            }
        if (isAbsolute(
              path) &&
              null !=
              m_absPaths) {
            if (DEBUG)
                validateNewAddition(
                  m_absPaths,
                  owner,
                  path);
            m_absPaths.
              addElement(
                owner);
        }
        else
            if (m_isSameContext &&
                  null !=
                  m_paths) {
                if (DEBUG)
                    validateNewAddition(
                      m_paths,
                      owner,
                      path);
                m_paths.
                  addElement(
                    owner);
            }
        return true;
    }
    public boolean visitPredicate(org.apache.xpath.ExpressionOwner owner,
                                  org.apache.xpath.Expression pred) {
        boolean savedIsSame =
          m_isSameContext;
        m_isSameContext =
          false;
        pred.
          callVisitors(
            owner,
            this);
        m_isSameContext =
          savedIsSame;
        return false;
    }
    public boolean visitTopLevelInstruction(org.apache.xalan.templates.ElemTemplateElement elem) {
        int type =
          elem.
          getXSLToken(
            );
        switch (type) {
            case org.apache.xalan.templates.Constants.
                   ELEMNAME_TEMPLATE:
                return visitInstruction(
                         elem);
            default:
                return true;
        }
    }
    public boolean visitInstruction(org.apache.xalan.templates.ElemTemplateElement elem) {
        int type =
          elem.
          getXSLToken(
            );
        switch (type) {
            case org.apache.xalan.templates.Constants.
                   ELEMNAME_CALLTEMPLATE:
            case org.apache.xalan.templates.Constants.
                   ELEMNAME_TEMPLATE:
            case org.apache.xalan.templates.Constants.
                   ELEMNAME_FOREACH:
                {
                    if (type ==
                          org.apache.xalan.templates.Constants.
                            ELEMNAME_FOREACH) {
                        org.apache.xalan.templates.ElemForEach efe =
                          (org.apache.xalan.templates.ElemForEach)
                            elem;
                        org.apache.xpath.Expression select =
                          efe.
                          getSelect(
                            );
                        select.
                          callVisitors(
                            efe,
                            this);
                    }
                    java.util.Vector savedPaths =
                      m_paths;
                    m_paths =
                      new java.util.Vector(
                        );
                    elem.
                      callChildVisitors(
                        this,
                        false);
                    eleminateRedundentLocals(
                      elem);
                    m_paths =
                      savedPaths;
                    return false;
                }
            case org.apache.xalan.templates.Constants.
                   ELEMNAME_NUMBER:
            case org.apache.xalan.templates.Constants.
                   ELEMNAME_SORT:
                boolean savedIsSame =
                  m_isSameContext;
                m_isSameContext =
                  false;
                elem.
                  callChildVisitors(
                    this);
                m_isSameContext =
                  savedIsSame;
                return false;
            default:
                return true;
        }
    }
    protected void diagnoseNumPaths(java.util.Vector paths,
                                    int numPathsEliminated,
                                    int numUniquePathsEliminated) {
        if (numPathsEliminated >
              0) {
            if (paths ==
                  m_paths) {
                java.lang.System.
                  err.
                  println(
                    "Eliminated " +
                    numPathsEliminated +
                    " total paths!");
                java.lang.System.
                  err.
                  println(
                    "Consolodated " +
                    numUniquePathsEliminated +
                    " redundent paths!");
            }
            else {
                java.lang.System.
                  err.
                  println(
                    "Eliminated " +
                    numPathsEliminated +
                    " total global paths!");
                java.lang.System.
                  err.
                  println(
                    "Consolodated " +
                    numUniquePathsEliminated +
                    " redundent global paths!");
            }
        }
    }
    private final void assertIsLocPathIterator(org.apache.xpath.Expression expr1,
                                               org.apache.xpath.ExpressionOwner eo)
          throws java.lang.RuntimeException {
        if (!(expr1 instanceof org.apache.xpath.axes.LocPathIterator)) {
            java.lang.String errMsg;
            if (expr1 instanceof org.apache.xpath.operations.Variable) {
                errMsg =
                  "Programmer\'s assertion: expr1 not an iterator: " +
                  ((org.apache.xpath.operations.Variable)
                     expr1).
                    getQName(
                      );
            }
            else {
                errMsg =
                  "Programmer\'s assertion: expr1 not an iterator: " +
                  expr1.
                    getClass(
                      ).
                    getName(
                      );
            }
            throw new java.lang.RuntimeException(
              errMsg +
              ", " +
              eo.
                getClass(
                  ).
                getName(
                  ) +
              " " +
              expr1.
                exprGetParent(
                  ));
        }
    }
    private static void validateNewAddition(java.util.Vector paths,
                                            org.apache.xpath.ExpressionOwner owner,
                                            org.apache.xpath.axes.LocPathIterator path)
          throws java.lang.RuntimeException {
        assertion(
          owner.
            getExpression(
              ) ==
            path,
          "owner.getExpression() != path!!!");
        int n =
          paths.
          size(
            );
        for (int i =
               0;
             i <
               n;
             i++) {
            org.apache.xpath.ExpressionOwner ew =
              (org.apache.xpath.ExpressionOwner)
                paths.
                elementAt(
                  i);
            assertion(
              ew !=
                owner,
              "duplicate owner on the list!!!");
            assertion(
              ew.
                getExpression(
                  ) !=
                path,
              "duplicate expression on the list!!!");
        }
    }
    protected static void assertion(boolean b,
                                    java.lang.String msg) {
        if (!b) {
            throw new java.lang.RuntimeException(
              org.apache.xalan.res.XSLMessages.
                createMessage(
                  org.apache.xalan.res.XSLTErrorResources.
                    ER_ASSERT_REDUNDENT_EXPR_ELIMINATOR,
                  new java.lang.Object[] { msg }));
        }
    }
    class MultistepExprHolder implements java.lang.Cloneable {
        org.apache.xpath.ExpressionOwner m_exprOwner;
        final int m_stepCount;
        org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder
          m_next;
        public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
            return super.
              clone(
                );
        }
        MultistepExprHolder(org.apache.xpath.ExpressionOwner exprOwner,
                            int stepCount,
                            org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder next) {
            super(
              );
            m_exprOwner =
              exprOwner;
            assertion(
              null !=
                m_exprOwner,
              "exprOwner can not be null!");
            m_stepCount =
              stepCount;
            m_next =
              next;
        }
        org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder addInSortedOrder(org.apache.xpath.ExpressionOwner exprOwner,
                                                                                                int stepCount) {
            org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder first =
              this;
            org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder next =
              this;
            org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder prev =
              null;
            while (null !=
                     next) {
                if (stepCount >=
                      next.
                        m_stepCount) {
                    org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder newholder =
                      new org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder(
                      exprOwner,
                      stepCount,
                      next);
                    if (null ==
                          prev)
                        first =
                          newholder;
                    else
                        prev.
                          m_next =
                          newholder;
                    return first;
                }
                prev =
                  next;
                next =
                  next.
                    m_next;
            }
            prev.
              m_next =
              new org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder(
                exprOwner,
                stepCount,
                null);
            return first;
        }
        org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder unlink(org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder itemToRemove) {
            org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder first =
              this;
            org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder next =
              this;
            org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder prev =
              null;
            while (null !=
                     next) {
                if (next ==
                      itemToRemove) {
                    if (null ==
                          prev)
                        first =
                          next.
                            m_next;
                    else
                        prev.
                          m_next =
                          next.
                            m_next;
                    next.
                      m_next =
                      null;
                    return first;
                }
                prev =
                  next;
                next =
                  next.
                    m_next;
            }
            assertion(
              false,
              "unlink failed!!!");
            return null;
        }
        int getLength() { int count = 0;
                          org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder next =
                            this;
                          while (null != next) {
                              count++;
                              next =
                                next.
                                  m_next;
                          }
                          return count; }
        protected void diagnose() { java.lang.System.
                                      err.
                                      print(
                                        "Found multistep iterators: " +
                                        this.
                                          getLength(
                                            ) +
                                        "  ");
                                    org.apache.xalan.templates.RedundentExprEliminator.MultistepExprHolder next =
                                      this;
                                    while (null !=
                                             next) {
                                        java.lang.System.
                                          err.
                                          print(
                                            "" +
                                            next.
                                              m_stepCount);
                                        next =
                                          next.
                                            m_next;
                                        if (null !=
                                              next)
                                            java.lang.System.
                                              err.
                                              print(
                                                ", ");
                                    }
                                    java.lang.System.
                                      err.
                                      println(
                                        );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1444739587000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Bg4d/wVgvm52EB0AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1444739587000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "iQ9cyApJAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "40o5///7b43Zl61s+YnDKGoOfCoIY59Y2Y388jedEqjznAUCRvaiYyMjPVd/" +
       "+n3/8wOf/eev+zywsOGhhQUnbZ/a5HcY//Envu3VL/jQb76vWMSBFRwjlr/z" +
       "J/JWP3mLap7D4rxNIKukGEbjYt2lKjmyG3nWy7Z3nd957mijR97br4WD1uHf" +
       "eC53F1O5MpxDAxjGh56bleFMt9rQuIWVGdfjWLbf8xQ+ccfLLEoWErc0lg4W" +
       "brNgxq5GykBS06Tapg1OtnSEL6/1iNlW2I5NtiCnLZtGmWsy04YkKNtgyFbp" +
       "ucvXOzLJz3yfJxa+WYmqi1izyksxm5nTZEFVtWVdFVRXaTYbTSRAtFhtDrEN" +
       "gXDLim05QrdiD7cjNCyvqZmYwnRNwr1yReyP7NVsME+ZYb0CNWQFTt2moJFC" +
       "XxxMh9mUFOpWMMSpbTSbzu2uQBImP8t4K5qu/SmH91xiykesbKOOKZYpy3WG" +
       "FT+pzDluHU7KzUlAthXKoawo3C7XbOoSdLVKVNuWuNwyw9Dv96oIMq+apKXa" +
       "Q0Qwym0h2La7HtZstDfVDcIsnQkvjWSMtORsihOrsTw3pbkzDbrDsrIYzipz" +
       "K8gkkndVv07UdHIJheSSWEGTDRMjMSxXOwmdVFKhjEyJuTStr0U+qGXsfFBD" +
       "NhWuPvfXiIL2fA7nxq7KeVnZGGa0V+n4lb5XofqLgOVXbpmoTEm/i0Je4tfn" +
       "4qBmdZeb6QzuLcdVYTpVVlTKOIK3nKwzRdU6Hl3duqREK0w0iwl73qRaC9KH" +
       "K7P23O93RpS5EltJ2e0M2kZ5rHOtcswmlIhU54O1Y4RG2OUETB+uR0HHbzQo" +
       "R11unZUTJttla0CTfT1dVjrTJmSb7el4uPEdYUgxlNv3VshoFcZVn5j3rZky" +
       "ROK66ZWRQbZg5R7RZgVnFRq62hAGTQ7FOaTX2PraoK4Y296cbZUlryzwVD1Y" +
       "R+vpckkKg1rSmy/4yXrcXfYzcYRzUVnu9aY8GrSWZbPiiTLS4Zmyzq46MFKp" +
       "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" +
       "MwjMkltDR0wCWqz6W1bMejG24MqT1FQ6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("tWHQS5yJxSojyxpjNcjBqk2NbRGdCSOGgkyNslEIFMbKJlTUaUPAtREeYeoq" +
       "MijHwzZG6xwngrne8nsEWBgHIqIQc7dsxSK2xTRPnhGEHcjBCLN7g55edkQQ" +
       "LkNkyCI83KrFa5lWWbvcXaLqgpFbKD+cm1HLLOOSg/W3OqtzTdX2ya0hR+7S" +
       "W87tge2rZFlA51URMTiV6kgEai6kQcUXFYmGo/omGA7FVctdNpKpiUaGt8QE" +
       "ayH7g8kyDe0VoZqkiW/XXYz3WnWiJq3JmEwzYwDWp8R6jEdMvIX6fjoBsdZC" +
       "bXVINbXQtgAsrIyx/ro5b5vCsl9exVVyDc0ydAyC0jaxVtHUgwiInqz4btLT" +
       "xux0WFPnseTBi6FjiZMNi06yCRstwtCdLQbWvGdC8oCm6xO3v0gMCDMNOIU6" +
       "bRZO6MEw6+Co3IZ7Rq3FVhvEelhd1Bs+iNnHgiSWOwvB3rio0aqptA2896CJ" +
       "6/LS4VFKDK101lRnDLtoCIOoS+t6uyY4rJrBeM3H2h7eHzGD5lDTpC06ZNu0" +
       "YcctcT4LpH4/rguYmlhcd1bfupBM61XZ7MKpMOKGaHsZLoihFSS2RVuzujhv" +
       "V+vMmun5gZkFar/TrA7t2oCx1WiOU/pyYbNNzSKMpBdOm+hQ3oCYft4J6ghw" +
       "pnba8dpu0xxk+ngyamTOIKYIQWgLnYRRRbCODnPjsibkgKExE8vSWbjCWssI" +
       "GShLUmBW09WqrcNBuE16HXNOLpiKg2qQ3OqZQr2VludqAov22iBbXHtVHyBN" +
       "QxiKMhfZbJcOvMkKbYFVwph1BpMVQxl8fdPfJjIAzWLJPBQtE67WTXek8/pY" +
       "cIDeGUtqRbE+7mLV7cSKjFqlPNssPGg2l5KJRqZbYUBRLWApWx73ZC82WJLt" +
       "tzaGqQI5Y5l3dL0cOnMQ7VZ0Voqr/hrjs9qAFUHkjOuTlk5uOuUwWnW2W1bq" +
       "aJGLckueHgkBrKeVaJvMDZWYdnm2idoMII6MZ6E36YxZCtense7NM8PSKyuz" +
       "vq4YQrve0mddPfWYYDoFK+YA7Wd9ajoYIGtfWm64ctyaMWZI453yZFCLDT5h" +
       "uIbeJImKBQ2HENTo2OvUddRaYk4XlZUDQhaVFyuwiGKKjAfN+rzSTcnKWpUE" +
       "oxFQba5tKZVVB+Fxf7SlszSdkzUeY2oDD5XcZlYf40bdiHv9lrqMad/gUdfA" +
       "XOADzCoYwE7fIitGR1MJf4YPal2LZluY3xa7CYExM6q2QGkHs4NQCKecQBMD" +
       "dh3gljaw16N+j65K2znWr/TF1tKaV5AmS1XJWs0mEHhWVYGnUocjEWLkmKrN" +
       "J2yt1okyr7/NOBzYOMttyjSbDDZcx7dmk+1gqS8mNg7cYcJ0YKEepVGL7Ux4" +
       "sltmu5MaxXEk7OJDo79QqtgAjzfJtjXgM4OeIta2vm2FdNmZ2JTXr7OTXgMW" +
       "LXqLprX6omnbdRiD+WaL8sQyMU6EPrToJROixqwSW1oMtXCDMGIvHZYbqTKB" +
       "nIxnEmqQRKDVgVNvCFiWRRiNoxIhNjsOEjCV2IcZg6PbSaD12nKE81aKUBym" +
       "A4emL2o+zFVjuRPyVHmk0mY94PSgFqEKHY0UbiM3NWbeUpzVcCbDfX6znM4q" +
       "A49P6ebW668RAp9krO2Nqa6b8mEW9QeTBptmW8bcQlnPbIYjpcOTKMeYmY4k" +
       "YQfZTNtkVlvgceJ24742QAcMEvVqktxTqnBd0RBVgRKMKVcpq2oZxFwqa8N+" +
       "QIvbPt7He7UwYnC05mL8duGbNOQLWp3okbVxHU0zzUVZrlvuVWhusVxzBAxL" +
       "vJqwW7DiVAeNhZnisc3X0hk7mWGanCYIE5etbnU9TZBeO1BWJtWlArrTRcYb" +
       "KHO2rCrOnQSmIIywUakJb2GUNOOOI5lKrG0nVbSGkeqohkbQKKgJ3a2/dePq" +
       "shO66cxUoP5aoSr+HBtXlSjj3UBZR6NmXYOWSB2Va1LaYHAdr0oLaCr2p8NR" +
       "CiQQmWFzCmI7tFsPtJhQVzMMiyS4yi/tHmnOJoSU1crhKOYbFJGaE5KslecQ" +
       "0qB5ga9S0haqQa4Wp5yQZJg53IzIzXZu9DzXWs0grN/G0lWnOfTJulTpGPq2" +
       "4kJ1HnF9SmAsiHKQjVKLwIKGJ+PWyBIcb+OOoF6ZmGBLQulJm1HcIFszUew0" +
       "IGcUJ0i3VV0zFnASil6nVky3iaBb0AGmAOLsKjHZdkhuOSCG/KBpVIcwCJ9D" +
       "FPPEtmQGzTYD1eA+1jbZprxt+cNWq/VV+SOpn7q1R2UPFU8Aj7bJ/z2e/e0u" +
       "vTZPnjx6uFr83VU6tbX6xMPVE7vvSvk+lleftfu92MPyPe/+0McU+nsrh5un" +
       "pKh0b+T5X2GrsWqfaOpJ0NJTZ+/XGReb/4930/3Cu3/vkelXG2+7hT3Cj56S" +
       "83STPzj+xC8Sr5e/5aB0x9HeuuteS7i20tPX7qi7L1CjTeBOr9lX9+pr9+lS" +
       "4BD2zAqnH1sfj911WlA8gv/y3dif2hR6ab/Tev/k+so5T67zN16m+//yc9WN" +
       "iib/8zn7TH8lT34pKr1cBRXyTeDq0dZw0pNFO7zhg9nYM5VjLfzszZ7Jnuy0" +
       "yPjMtbTlT/j1PW3680LbeZuRwILJVkNDVaOJ5+0Y+x/nMPa/8uS/R6VXXM8Y" +
       "YXuSuNP7Xz2m59cvQE/+FkRpCY7tnp7trdADrNEPvEiVI1W5IUsHx5uDnj21" +
       "QZDMO5rcrOfdBsHi9I/P4exP8+T3otLD13N2iqzfvyhZEjg+vBf5w7eqS394" +
       "qyzN8h6+5mZdnmDpb89m6VLRw19GpVcescQZYqAqwNNFpmgX2zhP0fVXF6Dr" +
       "sTwz3w70U3vZf+r20HVnUeDOQ9PDb/01lCfGGzsyw0j18/zdqy45QcX2ymJr" +
       "UVIMRsHa/ecw+mCe3B2VXu2IkWy0XOWwD/UUp5deeMTppXsuwOl9eeYrAT33" +
       "7+rufp8jp6WbaN8Of1Ige+Qc1K/KE8D8Q/4O5CCci0HxfkPB3zHSl17U2GoA" +
       "4SN7pI/cHu055bhfeVJ78u3jV3KVUMN8R1QB9vXnEPFUnrwWuB3FFHXXC9X8" +
       "FbXdlqZr7ejS4xe1oyqQ+Yk9E0/cViaKgS/g1M6BWs8TGEDVzPytPMfx3BaI" +
       "YcL9BrZnj6GWLwA135NeAvAuvWMP9R23B+ppHd9Z9lvPwdvOk6ej0oNmSHlR" +
       "vjMcrDmT/esaJ1T8zRdAWxR7DRD8g3u0H7zdA7sHSp4DlMoTIiq9SAarluhw" +
       "TIuiyTHM/kUt+WVAoO/ew/yu2wPzjuMFTnKUvK0AtTgHsJAnXFR6yaHRHk0G" +
       "5P5lrhN2O70A7lflmRCA8Ok97k/fHtyXiwKXDz3YIyc9mGMX+/vDK2y+x/Sw" +
       "yJPXOTkxBbMjL9qW6eqDSC1epTvFoXIOh6s8uRqVHpAN0dWLyW7qTVTtJh2C" +
       "iD+fEA87PKb5bRelGQGMfWFP8xduu88oNonu5sX4HFaKZB2VXiYHKggBDmHi" +
       "gedwQL2KOEA/Bh1c1FEC13Fwz67u7vd22lQB+iTyd5+D/B/myduj0n25GYW9" +
       "9Ua0T/nJd1x0AmwAkE/twT51e8CeDAWOQ+7iFY+vvllvxyH3pfefQ8y35Mk/" +
       "OVKJa+LOvbs5GRp+80VnkzcCead7uae3h6V9uH3sZg+N/LFzQqejqfL0guYV" +
       "uVCPAun4vZT8Tdj9yPnx28tzIRJEvqJ4zpUuPe6lsupHh8Hbd+fJd4C1dB61" +
       "nAzPdwsDcbc8PDHP3fQ9gpsNwJsApI/voX38eRqAXNCPnkvu9+0l+L6bkPvJ" +
       "s0PCjxcFfjRPfjAqvQqskfDnyOEPXZRDEOkf/NEewR/dVlPPxSveTrr00+cY" +
       "7c/myaeBNytCokPXfRLiT1w0HALr+jse3tW946HbA3EfFuTiqYWGnFKOx/Ju" +
       "Xn+i34fPVo5CuQouPnMOT5/Nk5/PQ8ciCpjm77CBICAveiKE+ncX4OrxPLMM" +
       "ZH18L/Pjt8BVERkWyrmJSveHW1c2As81szPuVZ1E9mvnXPtcnjwLUOtqdOLV" +
       "vVMa8ssXQF2YMXAkd5T3qMu3R0NOBMzPFpaQn+2Cvd++mSPI70pe+o2o9OLd" +
       "RHYEvKvK9qEvfsNN7h0f3iU4ZunzF2UJLIvvGO1ZGt1ulgo7Kv3WsdP40s1Y" +
       "+t958gdgvtmxtLtfew1XeYEvHBPwxYsSUAGirvYErJ4fAp49JuBvbkbA3+XJ" +
       "X4BpeUdAcYv/PPx/eVH8IOC54517/O98/szk0hfyogf33gT/wQvy5HJUelBU" +
       "lD3iqZfr/rW4D+68aOz/SiDhj+1x/9jtwX0qsnr0nPCO8hS1wPuSsx3lwSvy" +
       "5MGodLcZFs/SCm9zTMFDt8NDfm5PweduKwXF0BcYXncOvifz5DXAJeYTQaDG" +
       "h+7tBsP96EVXP08DjH+yx/onzxPWcz4Xc5B/Lubgqaj0yj3W/eM/3owM091/" +
       "M6Fo6RgzdFHMKIhm9re5L9/Kbe7nFga+ocD19DmY88fqB/Wo9BKAOcebr+OP" +
       "TeAU2sYF0D60N+jLj+7RPnqraM99Rrk+dN8HxDloB3nSjvIvybSk0LM30am7" +
       "+Qc3fTX2ZhBB8HZ5/62Ty9d96+TvB/HETZqPHuPkzsE5yxMqKj0Um6FZPIPO" +
       "V4vM/gNxJ+DSF4ULRvGytIcrPT9wd0p89Ry4Yp4IIFot4ALTVUyA+PTQfs0F" +
       "sBbLiKfy9ccea3K7tXfvn6xzYOYO90ADcUcBc+r5ZL5DZLD/GtveXE8A1i86" +
       "uK8FQN+3B/y+5wlwcg7gbZ4EINAoAJ8NNLzoSvUtAODP7YE+c6tAzw2wiv+P" +
       "16fF0u7LD3s5q7fj9enuXkhBxjedQ9R78uQdgKjD2/3UxrnBk+6Dd170rsUE" +
       "iLwPRy7fSjhSPJUvJs933czm31AYfgHrg+cHb48cf2JhsnEj01GvuTF28K15" +
       "8k+j0svEMFSDaBCeujV/ipx/dlFzybXoz/bk/Onfi5zNLahScce2fNjVWV0e" +
       "qdLJqeO7zjTKgw8VBT6eJ/8SRH2xaJsKcKWUmrQU5ejjhidY+84LsPbiPBMr" +
       "le68a1d393srrP3h2ayd2HBS7Hb4pgLZD59jRZ/Kkx+ISvfu9OV6rD94K1hT" +
       "oHhnbM3IP3f48uu+W7z71q78yY89cM/LPjb7teIjmUffw72XLN2jbWz75Nfp" +
       "TpzfBSI2zSx4uLdIX+QXkP71qUdn196wyDcaHp7n8h/8+K7WTwJPcrpWVLqz" +
       "+D1Z7qdBJHVcLirdtTs5WeTfRqU7QJH89Bn/0HBff849lAVHTue5u/eCdGfp" +
       "Lz+pPMWGnYdvNg4n9l6+7podk8U3pQ93N26Y/XfyPvWxIfX1X6p/7+77nrIt" +
       "Zlneyj1k6e7dp0aLRvMdkq89s7XDtu7qv/GvX/Qj9z55uJvzRTuBjxX5hGyP" +
       "3vhjmj3Hj4rPX2Y/8bJ/9ebv/9hvFJ+M+X800Hgm7FsAAA==");
}
