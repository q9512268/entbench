package org.apache.xpath.axes;
public class WalkerFactory {
    static org.apache.xpath.axes.AxesWalker loadOneWalker(org.apache.xpath.axes.WalkingIterator lpi,
                                                          org.apache.xpath.compiler.Compiler compiler,
                                                          int stepOpCodePos)
          throws javax.xml.transform.TransformerException {
        org.apache.xpath.axes.AxesWalker firstWalker =
          null;
        int stepType =
          compiler.
          getOp(
            stepOpCodePos);
        if (stepType !=
              org.apache.xpath.compiler.OpCodes.
                ENDOP) {
            firstWalker =
              createDefaultWalker(
                compiler,
                stepType,
                lpi,
                0);
            firstWalker.
              init(
                compiler,
                stepOpCodePos,
                stepType);
        }
        return firstWalker;
    }
    static org.apache.xpath.axes.AxesWalker loadWalkers(org.apache.xpath.axes.WalkingIterator lpi,
                                                        org.apache.xpath.compiler.Compiler compiler,
                                                        int stepOpCodePos,
                                                        int stepIndex)
          throws javax.xml.transform.TransformerException {
        int stepType;
        org.apache.xpath.axes.AxesWalker firstWalker =
          null;
        org.apache.xpath.axes.AxesWalker walker;
        org.apache.xpath.axes.AxesWalker prevWalker =
          null;
        int analysis =
          analyze(
            compiler,
            stepOpCodePos,
            stepIndex);
        while (org.apache.xpath.compiler.OpCodes.
                 ENDOP !=
                 (stepType =
                    compiler.
                      getOp(
                        stepOpCodePos))) {
            walker =
              createDefaultWalker(
                compiler,
                stepOpCodePos,
                lpi,
                analysis);
            walker.
              init(
                compiler,
                stepOpCodePos,
                stepType);
            walker.
              exprSetParent(
                lpi);
            if (null ==
                  firstWalker) {
                firstWalker =
                  walker;
            }
            else {
                prevWalker.
                  setNextWalker(
                    walker);
                walker.
                  setPrevWalker(
                    prevWalker);
            }
            prevWalker =
              walker;
            stepOpCodePos =
              compiler.
                getNextStepPos(
                  stepOpCodePos);
            if (stepOpCodePos <
                  0)
                break;
        }
        return firstWalker;
    }
    public static boolean isSet(int analysis,
                                int bits) {
        return 0 !=
          (analysis &
             bits);
    }
    public static void diagnoseIterator(java.lang.String name,
                                        int analysis,
                                        org.apache.xpath.compiler.Compiler compiler) {
        java.lang.System.
          out.
          println(
            compiler.
              toString(
                ) +
            ", " +
            name +
            ", " +
            java.lang.Integer.
              toBinaryString(
                analysis) +
            ", " +
            getAnalysisString(
              analysis));
    }
    public static org.apache.xml.dtm.DTMIterator newDTMIterator(org.apache.xpath.compiler.Compiler compiler,
                                                                int opPos,
                                                                boolean isTopLevel)
          throws javax.xml.transform.TransformerException {
        int firstStepPos =
          org.apache.xpath.compiler.OpMap.
          getFirstChildPos(
            opPos);
        int analysis =
          analyze(
            compiler,
            firstStepPos,
            0);
        boolean isOneStep =
          isOneStep(
            analysis);
        org.apache.xml.dtm.DTMIterator iter;
        if (isOneStep &&
              walksSelfOnly(
                analysis) &&
              isWild(
                analysis) &&
              !hasPredicate(
                 analysis)) {
            if (DEBUG_ITERATOR_CREATION)
                diagnoseIterator(
                  "SelfIteratorNoPredicate",
                  analysis,
                  compiler);
            iter =
              new org.apache.xpath.axes.SelfIteratorNoPredicate(
                compiler,
                opPos,
                analysis);
        }
        else
            if (walksChildrenOnly(
                  analysis) &&
                  isOneStep) {
                if (isWild(
                      analysis) &&
                      !hasPredicate(
                         analysis)) {
                    if (DEBUG_ITERATOR_CREATION)
                        diagnoseIterator(
                          "ChildIterator",
                          analysis,
                          compiler);
                    iter =
                      new org.apache.xpath.axes.ChildIterator(
                        compiler,
                        opPos,
                        analysis);
                }
                else {
                    if (DEBUG_ITERATOR_CREATION)
                        diagnoseIterator(
                          "ChildTestIterator",
                          analysis,
                          compiler);
                    iter =
                      new org.apache.xpath.axes.ChildTestIterator(
                        compiler,
                        opPos,
                        analysis);
                }
            }
            else
                if (isOneStep &&
                      walksAttributes(
                        analysis)) {
                    if (DEBUG_ITERATOR_CREATION)
                        diagnoseIterator(
                          "AttributeIterator",
                          analysis,
                          compiler);
                    iter =
                      new org.apache.xpath.axes.AttributeIterator(
                        compiler,
                        opPos,
                        analysis);
                }
                else
                    if (isOneStep &&
                          !walksFilteredList(
                             analysis)) {
                        if (!walksNamespaces(
                               analysis) &&
                              (walksInDocOrder(
                                 analysis) ||
                                 isSet(
                                   analysis,
                                   BIT_PARENT))) {
                            if (false ||
                                  DEBUG_ITERATOR_CREATION)
                                diagnoseIterator(
                                  "OneStepIteratorForward",
                                  analysis,
                                  compiler);
                            iter =
                              new org.apache.xpath.axes.OneStepIteratorForward(
                                compiler,
                                opPos,
                                analysis);
                        }
                        else {
                            if (false ||
                                  DEBUG_ITERATOR_CREATION)
                                diagnoseIterator(
                                  "OneStepIterator",
                                  analysis,
                                  compiler);
                            iter =
                              new org.apache.xpath.axes.OneStepIterator(
                                compiler,
                                opPos,
                                analysis);
                        }
                    }
                    else
                        if (isOptimizableForDescendantIterator(
                              compiler,
                              firstStepPos,
                              0)) {
                            if (DEBUG_ITERATOR_CREATION)
                                diagnoseIterator(
                                  "DescendantIterator",
                                  analysis,
                                  compiler);
                            iter =
                              new org.apache.xpath.axes.DescendantIterator(
                                compiler,
                                opPos,
                                analysis);
                        }
                        else {
                            if (isNaturalDocOrder(
                                  compiler,
                                  firstStepPos,
                                  0,
                                  analysis)) {
                                if (false ||
                                      DEBUG_ITERATOR_CREATION) {
                                    diagnoseIterator(
                                      "WalkingIterator",
                                      analysis,
                                      compiler);
                                }
                                iter =
                                  new org.apache.xpath.axes.WalkingIterator(
                                    compiler,
                                    opPos,
                                    analysis,
                                    true);
                            }
                            else {
                                if (DEBUG_ITERATOR_CREATION)
                                    diagnoseIterator(
                                      "WalkingIteratorSorted",
                                      analysis,
                                      compiler);
                                iter =
                                  new org.apache.xpath.axes.WalkingIteratorSorted(
                                    compiler,
                                    opPos,
                                    analysis,
                                    true);
                            }
                        }
        if (iter instanceof org.apache.xpath.axes.LocPathIterator)
            ((org.apache.xpath.axes.LocPathIterator)
               iter).
              setIsTopLevel(
                isTopLevel);
        return iter;
    }
    public static int getAxisFromStep(org.apache.xpath.compiler.Compiler compiler,
                                      int stepOpCodePos)
          throws javax.xml.transform.TransformerException {
        int stepType =
          compiler.
          getOp(
            stepOpCodePos);
        switch (stepType) {
            case org.apache.xpath.compiler.OpCodes.
                   FROM_FOLLOWING:
                return org.apache.xml.dtm.Axis.
                         FOLLOWING;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_FOLLOWING_SIBLINGS:
                return org.apache.xml.dtm.Axis.
                         FOLLOWINGSIBLING;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_PRECEDING:
                return org.apache.xml.dtm.Axis.
                         PRECEDING;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_PRECEDING_SIBLINGS:
                return org.apache.xml.dtm.Axis.
                         PRECEDINGSIBLING;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_PARENT:
                return org.apache.xml.dtm.Axis.
                         PARENT;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_NAMESPACE:
                return org.apache.xml.dtm.Axis.
                         NAMESPACE;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_ANCESTORS:
                return org.apache.xml.dtm.Axis.
                         ANCESTOR;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_ANCESTORS_OR_SELF:
                return org.apache.xml.dtm.Axis.
                         ANCESTORORSELF;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_ATTRIBUTES:
                return org.apache.xml.dtm.Axis.
                         ATTRIBUTE;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_ROOT:
                return org.apache.xml.dtm.Axis.
                         ROOT;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_CHILDREN:
                return org.apache.xml.dtm.Axis.
                         CHILD;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_DESCENDANTS_OR_SELF:
                return org.apache.xml.dtm.Axis.
                         DESCENDANTORSELF;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_DESCENDANTS:
                return org.apache.xml.dtm.Axis.
                         DESCENDANT;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_SELF:
                return org.apache.xml.dtm.Axis.
                         SELF;
            case org.apache.xpath.compiler.OpCodes.
                   OP_EXTFUNCTION:
            case org.apache.xpath.compiler.OpCodes.
                   OP_FUNCTION:
            case org.apache.xpath.compiler.OpCodes.
                   OP_GROUP:
            case org.apache.xpath.compiler.OpCodes.
                   OP_VARIABLE:
                return org.apache.xml.dtm.Axis.
                         FILTEREDLIST;
        }
        throw new java.lang.RuntimeException(
          org.apache.xalan.res.XSLMessages.
            createXPATHMessage(
              org.apache.xpath.res.XPATHErrorResources.
                ER_NULL_ERROR_HANDLER,
              new java.lang.Object[] { java.lang.Integer.
                toString(
                  stepType) }));
    }
    public static int getAnalysisBitFromAxes(int axis) {
        switch (axis) {
            case org.apache.xml.dtm.Axis.
                   ANCESTOR:
                return BIT_ANCESTOR;
            case org.apache.xml.dtm.Axis.
                   ANCESTORORSELF:
                return BIT_ANCESTOR_OR_SELF;
            case org.apache.xml.dtm.Axis.
                   ATTRIBUTE:
                return BIT_ATTRIBUTE;
            case org.apache.xml.dtm.Axis.
                   CHILD:
                return BIT_CHILD;
            case org.apache.xml.dtm.Axis.
                   DESCENDANT:
                return BIT_DESCENDANT;
            case org.apache.xml.dtm.Axis.
                   DESCENDANTORSELF:
                return BIT_DESCENDANT_OR_SELF;
            case org.apache.xml.dtm.Axis.
                   FOLLOWING:
                return BIT_FOLLOWING;
            case org.apache.xml.dtm.Axis.
                   FOLLOWINGSIBLING:
                return BIT_FOLLOWING_SIBLING;
            case org.apache.xml.dtm.Axis.
                   NAMESPACE:
            case org.apache.xml.dtm.Axis.
                   NAMESPACEDECLS:
                return BIT_NAMESPACE;
            case org.apache.xml.dtm.Axis.
                   PARENT:
                return BIT_PARENT;
            case org.apache.xml.dtm.Axis.
                   PRECEDING:
                return BIT_PRECEDING;
            case org.apache.xml.dtm.Axis.
                   PRECEDINGSIBLING:
                return BIT_PRECEDING_SIBLING;
            case org.apache.xml.dtm.Axis.
                   SELF:
                return BIT_SELF;
            case org.apache.xml.dtm.Axis.
                   ALLFROMNODE:
                return BIT_DESCENDANT_OR_SELF;
            case org.apache.xml.dtm.Axis.
                   DESCENDANTSFROMROOT:
            case org.apache.xml.dtm.Axis.
                   ALL:
            case org.apache.xml.dtm.Axis.
                   DESCENDANTSORSELFFROMROOT:
                return BIT_ANY_DESCENDANT_FROM_ROOT;
            case org.apache.xml.dtm.Axis.
                   ROOT:
                return BIT_ROOT;
            case org.apache.xml.dtm.Axis.
                   FILTEREDLIST:
                return BIT_FILTER;
            default:
                return BIT_FILTER;
        }
    }
    static boolean functionProximateOrContainsProximate(org.apache.xpath.compiler.Compiler compiler,
                                                        int opPos) {
        int endFunc =
          opPos +
          compiler.
          getOp(
            opPos +
              1) -
          1;
        opPos =
          org.apache.xpath.compiler.OpMap.
            getFirstChildPos(
              opPos);
        int funcID =
          compiler.
          getOp(
            opPos);
        switch (funcID) {
            case org.apache.xpath.compiler.FunctionTable.
                   FUNC_LAST:
            case org.apache.xpath.compiler.FunctionTable.
                   FUNC_POSITION:
                return true;
            default:
                opPos++;
                int i =
                  0;
                for (int p =
                       opPos;
                     p <
                       endFunc;
                     p =
                       compiler.
                         getNextOpPos(
                           p),
                       i++) {
                    int innerExprOpPos =
                      p +
                      2;
                    int argOp =
                      compiler.
                      getOp(
                        innerExprOpPos);
                    boolean prox =
                      isProximateInnerExpr(
                        compiler,
                        innerExprOpPos);
                    if (prox)
                        return true;
                }
        }
        return false;
    }
    static boolean isProximateInnerExpr(org.apache.xpath.compiler.Compiler compiler,
                                        int opPos) {
        int op =
          compiler.
          getOp(
            opPos);
        int innerExprOpPos =
          opPos +
          2;
        switch (op) {
            case org.apache.xpath.compiler.OpCodes.
                   OP_ARGUMENT:
                if (isProximateInnerExpr(
                      compiler,
                      innerExprOpPos))
                    return true;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   OP_VARIABLE:
            case org.apache.xpath.compiler.OpCodes.
                   OP_NUMBERLIT:
            case org.apache.xpath.compiler.OpCodes.
                   OP_LITERAL:
            case org.apache.xpath.compiler.OpCodes.
                   OP_LOCATIONPATH:
                break;
            case org.apache.xpath.compiler.OpCodes.
                   OP_FUNCTION:
                boolean isProx =
                  functionProximateOrContainsProximate(
                    compiler,
                    opPos);
                if (isProx)
                    return true;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   OP_GT:
            case org.apache.xpath.compiler.OpCodes.
                   OP_GTE:
            case org.apache.xpath.compiler.OpCodes.
                   OP_LT:
            case org.apache.xpath.compiler.OpCodes.
                   OP_LTE:
            case org.apache.xpath.compiler.OpCodes.
                   OP_EQUALS:
                int leftPos =
                  org.apache.xpath.compiler.OpMap.
                  getFirstChildPos(
                    op);
                int rightPos =
                  compiler.
                  getNextOpPos(
                    leftPos);
                isProx =
                  isProximateInnerExpr(
                    compiler,
                    leftPos);
                if (isProx)
                    return true;
                isProx =
                  isProximateInnerExpr(
                    compiler,
                    rightPos);
                if (isProx)
                    return true;
                break;
            default:
                return true;
        }
        return false;
    }
    public static boolean mightBeProximate(org.apache.xpath.compiler.Compiler compiler,
                                           int opPos,
                                           int stepType)
          throws javax.xml.transform.TransformerException {
        boolean mightBeProximate =
          false;
        int argLen;
        switch (stepType) {
            case org.apache.xpath.compiler.OpCodes.
                   OP_VARIABLE:
            case org.apache.xpath.compiler.OpCodes.
                   OP_EXTFUNCTION:
            case org.apache.xpath.compiler.OpCodes.
                   OP_FUNCTION:
            case org.apache.xpath.compiler.OpCodes.
                   OP_GROUP:
                argLen =
                  compiler.
                    getArgLength(
                      opPos);
                break;
            default:
                argLen =
                  compiler.
                    getArgLengthOfStep(
                      opPos);
        }
        int predPos =
          compiler.
          getFirstPredicateOpPos(
            opPos);
        int count =
          0;
        while (org.apache.xpath.compiler.OpCodes.
                 OP_PREDICATE ==
                 compiler.
                 getOp(
                   predPos)) {
            count++;
            int innerExprOpPos =
              predPos +
              2;
            int predOp =
              compiler.
              getOp(
                innerExprOpPos);
            switch (predOp) {
                case org.apache.xpath.compiler.OpCodes.
                       OP_VARIABLE:
                    return true;
                case org.apache.xpath.compiler.OpCodes.
                       OP_LOCATIONPATH:
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       OP_NUMBER:
                case org.apache.xpath.compiler.OpCodes.
                       OP_NUMBERLIT:
                    return true;
                case org.apache.xpath.compiler.OpCodes.
                       OP_FUNCTION:
                    boolean isProx =
                      functionProximateOrContainsProximate(
                        compiler,
                        innerExprOpPos);
                    if (isProx)
                        return true;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       OP_GT:
                case org.apache.xpath.compiler.OpCodes.
                       OP_GTE:
                case org.apache.xpath.compiler.OpCodes.
                       OP_LT:
                case org.apache.xpath.compiler.OpCodes.
                       OP_LTE:
                case org.apache.xpath.compiler.OpCodes.
                       OP_EQUALS:
                    int leftPos =
                      org.apache.xpath.compiler.OpMap.
                      getFirstChildPos(
                        innerExprOpPos);
                    int rightPos =
                      compiler.
                      getNextOpPos(
                        leftPos);
                    isProx =
                      isProximateInnerExpr(
                        compiler,
                        leftPos);
                    if (isProx)
                        return true;
                    isProx =
                      isProximateInnerExpr(
                        compiler,
                        rightPos);
                    if (isProx)
                        return true;
                    break;
                default:
                    return true;
            }
            predPos =
              compiler.
                getNextOpPos(
                  predPos);
        }
        return mightBeProximate;
    }
    private static boolean isOptimizableForDescendantIterator(org.apache.xpath.compiler.Compiler compiler,
                                                              int stepOpCodePos,
                                                              int stepIndex)
          throws javax.xml.transform.TransformerException {
        int stepType;
        int stepCount =
          0;
        boolean foundDorDS =
          false;
        boolean foundSelf =
          false;
        boolean foundDS =
          false;
        int nodeTestType =
          org.apache.xpath.compiler.OpCodes.
            NODETYPE_NODE;
        while (org.apache.xpath.compiler.OpCodes.
                 ENDOP !=
                 (stepType =
                    compiler.
                      getOp(
                        stepOpCodePos))) {
            if (nodeTestType !=
                  org.apache.xpath.compiler.OpCodes.
                    NODETYPE_NODE &&
                  nodeTestType !=
                  org.apache.xpath.compiler.OpCodes.
                    NODETYPE_ROOT)
                return false;
            stepCount++;
            if (stepCount >
                  3)
                return false;
            boolean mightBeProximate =
              mightBeProximate(
                compiler,
                stepOpCodePos,
                stepType);
            if (mightBeProximate)
                return false;
            switch (stepType) {
                case org.apache.xpath.compiler.OpCodes.
                       FROM_FOLLOWING:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_FOLLOWING_SIBLINGS:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_PRECEDING:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_PRECEDING_SIBLINGS:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_PARENT:
                case org.apache.xpath.compiler.OpCodes.
                       OP_VARIABLE:
                case org.apache.xpath.compiler.OpCodes.
                       OP_EXTFUNCTION:
                case org.apache.xpath.compiler.OpCodes.
                       OP_FUNCTION:
                case org.apache.xpath.compiler.OpCodes.
                       OP_GROUP:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_NAMESPACE:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_ANCESTORS:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_ANCESTORS_OR_SELF:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_ATTRIBUTES:
                case org.apache.xpath.compiler.OpCodes.
                       MATCH_ATTRIBUTE:
                case org.apache.xpath.compiler.OpCodes.
                       MATCH_ANY_ANCESTOR:
                case org.apache.xpath.compiler.OpCodes.
                       MATCH_IMMEDIATE_ANCESTOR:
                    return false;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_ROOT:
                    if (1 !=
                          stepCount)
                        return false;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_CHILDREN:
                    if (!foundDS &&
                          !(foundDorDS &&
                              foundSelf))
                        return false;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_DESCENDANTS_OR_SELF:
                    foundDS =
                      true;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_DESCENDANTS:
                    if (3 ==
                          stepCount)
                        return false;
                    foundDorDS =
                      true;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_SELF:
                    if (1 !=
                          stepCount)
                        return false;
                    foundSelf =
                      true;
                    break;
                default:
                    throw new java.lang.RuntimeException(
                      org.apache.xalan.res.XSLMessages.
                        createXPATHMessage(
                          org.apache.xpath.res.XPATHErrorResources.
                            ER_NULL_ERROR_HANDLER,
                          new java.lang.Object[] { java.lang.Integer.
                            toString(
                              stepType) }));
            }
            nodeTestType =
              compiler.
                getStepTestType(
                  stepOpCodePos);
            int nextStepOpCodePos =
              compiler.
              getNextStepPos(
                stepOpCodePos);
            if (nextStepOpCodePos <
                  0)
                break;
            if (org.apache.xpath.compiler.OpCodes.
                  ENDOP !=
                  compiler.
                  getOp(
                    nextStepOpCodePos)) {
                if (compiler.
                      countPredicates(
                        stepOpCodePos) >
                      0) {
                    return false;
                }
            }
            stepOpCodePos =
              nextStepOpCodePos;
        }
        return true;
    }
    private static int analyze(org.apache.xpath.compiler.Compiler compiler,
                               int stepOpCodePos,
                               int stepIndex)
          throws javax.xml.transform.TransformerException {
        int stepType;
        int stepCount =
          0;
        int analysisResult =
          0;
        while (org.apache.xpath.compiler.OpCodes.
                 ENDOP !=
                 (stepType =
                    compiler.
                      getOp(
                        stepOpCodePos))) {
            stepCount++;
            boolean predAnalysis =
              analyzePredicate(
                compiler,
                stepOpCodePos,
                stepType);
            if (predAnalysis)
                analysisResult |=
                  BIT_PREDICATE;
            switch (stepType) {
                case org.apache.xpath.compiler.OpCodes.
                       OP_VARIABLE:
                case org.apache.xpath.compiler.OpCodes.
                       OP_EXTFUNCTION:
                case org.apache.xpath.compiler.OpCodes.
                       OP_FUNCTION:
                case org.apache.xpath.compiler.OpCodes.
                       OP_GROUP:
                    analysisResult |=
                      BIT_FILTER;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_ROOT:
                    analysisResult |=
                      BIT_ROOT;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_ANCESTORS:
                    analysisResult |=
                      BIT_ANCESTOR;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_ANCESTORS_OR_SELF:
                    analysisResult |=
                      BIT_ANCESTOR_OR_SELF;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_ATTRIBUTES:
                    analysisResult |=
                      BIT_ATTRIBUTE;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_NAMESPACE:
                    analysisResult |=
                      BIT_NAMESPACE;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_CHILDREN:
                    analysisResult |=
                      BIT_CHILD;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_DESCENDANTS:
                    analysisResult |=
                      BIT_DESCENDANT;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_DESCENDANTS_OR_SELF:
                    if (2 ==
                          stepCount &&
                          BIT_ROOT ==
                          analysisResult) {
                        analysisResult |=
                          BIT_ANY_DESCENDANT_FROM_ROOT;
                    }
                    analysisResult |=
                      BIT_DESCENDANT_OR_SELF;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_FOLLOWING:
                    analysisResult |=
                      BIT_FOLLOWING;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_FOLLOWING_SIBLINGS:
                    analysisResult |=
                      BIT_FOLLOWING_SIBLING;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_PRECEDING:
                    analysisResult |=
                      BIT_PRECEDING;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_PRECEDING_SIBLINGS:
                    analysisResult |=
                      BIT_PRECEDING_SIBLING;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_PARENT:
                    analysisResult |=
                      BIT_PARENT;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_SELF:
                    analysisResult |=
                      BIT_SELF;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       MATCH_ATTRIBUTE:
                    analysisResult |=
                      BIT_MATCH_PATTERN |
                        BIT_ATTRIBUTE;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       MATCH_ANY_ANCESTOR:
                    analysisResult |=
                      BIT_MATCH_PATTERN |
                        BIT_ANCESTOR;
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       MATCH_IMMEDIATE_ANCESTOR:
                    analysisResult |=
                      BIT_MATCH_PATTERN |
                        BIT_PARENT;
                    break;
                default:
                    throw new java.lang.RuntimeException(
                      org.apache.xalan.res.XSLMessages.
                        createXPATHMessage(
                          org.apache.xpath.res.XPATHErrorResources.
                            ER_NULL_ERROR_HANDLER,
                          new java.lang.Object[] { java.lang.Integer.
                            toString(
                              stepType) }));
            }
            if (org.apache.xpath.compiler.OpCodes.
                  NODETYPE_NODE ==
                  compiler.
                  getOp(
                    stepOpCodePos +
                      3)) {
                analysisResult |=
                  BIT_NODETEST_ANY;
            }
            stepOpCodePos =
              compiler.
                getNextStepPos(
                  stepOpCodePos);
            if (stepOpCodePos <
                  0)
                break;
        }
        analysisResult |=
          stepCount &
            BITS_COUNT;
        return analysisResult;
    }
    public static boolean isDownwardAxisOfMany(int axis) {
        return org.apache.xml.dtm.Axis.
                 DESCENDANTORSELF ==
          axis ||
          org.apache.xml.dtm.Axis.
            DESCENDANT ==
          axis ||
          org.apache.xml.dtm.Axis.
            FOLLOWING ==
          axis ||
          org.apache.xml.dtm.Axis.
            PRECEDING ==
          axis;
    }
    static org.apache.xpath.patterns.StepPattern loadSteps(org.apache.xpath.axes.MatchPatternIterator mpi,
                                                           org.apache.xpath.compiler.Compiler compiler,
                                                           int stepOpCodePos,
                                                           int stepIndex)
          throws javax.xml.transform.TransformerException {
        if (DEBUG_PATTERN_CREATION) {
            java.lang.System.
              out.
              println(
                "================");
            java.lang.System.
              out.
              println(
                "loadSteps for: " +
                compiler.
                  getPatternString(
                    ));
        }
        int stepType;
        org.apache.xpath.patterns.StepPattern step =
          null;
        org.apache.xpath.patterns.StepPattern firstStep =
          null;
        org.apache.xpath.patterns.StepPattern prevStep =
          null;
        int analysis =
          analyze(
            compiler,
            stepOpCodePos,
            stepIndex);
        while (org.apache.xpath.compiler.OpCodes.
                 ENDOP !=
                 (stepType =
                    compiler.
                      getOp(
                        stepOpCodePos))) {
            step =
              createDefaultStepPattern(
                compiler,
                stepOpCodePos,
                mpi,
                analysis,
                firstStep,
                prevStep);
            if (null ==
                  firstStep) {
                firstStep =
                  step;
            }
            else {
                step.
                  setRelativePathPattern(
                    prevStep);
            }
            prevStep =
              step;
            stepOpCodePos =
              compiler.
                getNextStepPos(
                  stepOpCodePos);
            if (stepOpCodePos <
                  0)
                break;
        }
        int axis =
          org.apache.xml.dtm.Axis.
            SELF;
        int paxis =
          org.apache.xml.dtm.Axis.
            SELF;
        org.apache.xpath.patterns.StepPattern tail =
          step;
        for (org.apache.xpath.patterns.StepPattern pat =
               step;
             null !=
               pat;
             pat =
               pat.
                 getRelativePathPattern(
                   )) {
            int nextAxis =
              pat.
              getAxis(
                );
            pat.
              setAxis(
                axis);
            int whatToShow =
              pat.
              getWhatToShow(
                );
            if (whatToShow ==
                  org.apache.xml.dtm.DTMFilter.
                    SHOW_ATTRIBUTE ||
                  whatToShow ==
                  org.apache.xml.dtm.DTMFilter.
                    SHOW_NAMESPACE) {
                int newAxis =
                  whatToShow ==
                  org.apache.xml.dtm.DTMFilter.
                    SHOW_ATTRIBUTE
                  ? org.apache.xml.dtm.Axis.
                      ATTRIBUTE
                  : org.apache.xml.dtm.Axis.
                      NAMESPACE;
                if (isDownwardAxisOfMany(
                      axis)) {
                    org.apache.xpath.patterns.StepPattern attrPat =
                      new org.apache.xpath.patterns.StepPattern(
                      whatToShow,
                      pat.
                        getNamespace(
                          ),
                      pat.
                        getLocalName(
                          ),
                      newAxis,
                      0);
                    org.apache.xpath.objects.XNumber score =
                      pat.
                      getStaticScore(
                        );
                    pat.
                      setNamespace(
                        null);
                    pat.
                      setLocalName(
                        org.apache.xpath.patterns.NodeTest.
                          WILD);
                    attrPat.
                      setPredicates(
                        pat.
                          getPredicates(
                            ));
                    pat.
                      setPredicates(
                        null);
                    pat.
                      setWhatToShow(
                        org.apache.xml.dtm.DTMFilter.
                          SHOW_ELEMENT);
                    org.apache.xpath.patterns.StepPattern rel =
                      pat.
                      getRelativePathPattern(
                        );
                    pat.
                      setRelativePathPattern(
                        attrPat);
                    attrPat.
                      setRelativePathPattern(
                        rel);
                    attrPat.
                      setStaticScore(
                        score);
                    if (org.apache.xml.dtm.Axis.
                          PRECEDING ==
                          pat.
                          getAxis(
                            ))
                        pat.
                          setAxis(
                            org.apache.xml.dtm.Axis.
                              PRECEDINGANDANCESTOR);
                    else
                        if (org.apache.xml.dtm.Axis.
                              DESCENDANT ==
                              pat.
                              getAxis(
                                ))
                            pat.
                              setAxis(
                                org.apache.xml.dtm.Axis.
                                  DESCENDANTORSELF);
                    pat =
                      attrPat;
                }
                else
                    if (org.apache.xml.dtm.Axis.
                          CHILD ==
                          pat.
                          getAxis(
                            )) {
                        pat.
                          setAxis(
                            org.apache.xml.dtm.Axis.
                              ATTRIBUTE);
                    }
            }
            axis =
              nextAxis;
            tail =
              pat;
        }
        if (axis <
              org.apache.xml.dtm.Axis.
                ALL) {
            org.apache.xpath.patterns.StepPattern selfPattern =
              new org.apache.xpath.patterns.ContextMatchStepPattern(
              axis,
              paxis);
            org.apache.xpath.objects.XNumber score =
              tail.
              getStaticScore(
                );
            tail.
              setRelativePathPattern(
                selfPattern);
            tail.
              setStaticScore(
                score);
            selfPattern.
              setStaticScore(
                score);
        }
        if (DEBUG_PATTERN_CREATION) {
            java.lang.System.
              out.
              println(
                "Done loading steps: " +
                step.
                  toString(
                    ));
            java.lang.System.
              out.
              println(
                "");
        }
        return step;
    }
    private static org.apache.xpath.patterns.StepPattern createDefaultStepPattern(org.apache.xpath.compiler.Compiler compiler,
                                                                                  int opPos,
                                                                                  org.apache.xpath.axes.MatchPatternIterator mpi,
                                                                                  int analysis,
                                                                                  org.apache.xpath.patterns.StepPattern tail,
                                                                                  org.apache.xpath.patterns.StepPattern head)
          throws javax.xml.transform.TransformerException {
        int stepType =
          compiler.
          getOp(
            opPos);
        boolean simpleInit =
          false;
        boolean prevIsOneStepDown =
          true;
        int whatToShow =
          compiler.
          getWhatToShow(
            opPos);
        org.apache.xpath.patterns.StepPattern ai =
          null;
        int axis;
        int predicateAxis;
        switch (stepType) {
            case org.apache.xpath.compiler.OpCodes.
                   OP_VARIABLE:
            case org.apache.xpath.compiler.OpCodes.
                   OP_EXTFUNCTION:
            case org.apache.xpath.compiler.OpCodes.
                   OP_FUNCTION:
            case org.apache.xpath.compiler.OpCodes.
                   OP_GROUP:
                prevIsOneStepDown =
                  false;
                org.apache.xpath.Expression expr;
                switch (stepType) {
                    case org.apache.xpath.compiler.OpCodes.
                           OP_VARIABLE:
                    case org.apache.xpath.compiler.OpCodes.
                           OP_EXTFUNCTION:
                    case org.apache.xpath.compiler.OpCodes.
                           OP_FUNCTION:
                    case org.apache.xpath.compiler.OpCodes.
                           OP_GROUP:
                        expr =
                          compiler.
                            compile(
                              opPos);
                        break;
                    default:
                        expr =
                          compiler.
                            compile(
                              opPos +
                                2);
                }
                axis =
                  org.apache.xml.dtm.Axis.
                    FILTEREDLIST;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    FILTEREDLIST;
                ai =
                  new org.apache.xpath.patterns.FunctionPattern(
                    expr,
                    axis,
                    predicateAxis);
                simpleInit =
                  true;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_ROOT:
                whatToShow =
                  org.apache.xml.dtm.DTMFilter.
                    SHOW_DOCUMENT |
                    org.apache.xml.dtm.DTMFilter.
                      SHOW_DOCUMENT_FRAGMENT;
                axis =
                  org.apache.xml.dtm.Axis.
                    ROOT;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    ROOT;
                ai =
                  new org.apache.xpath.patterns.StepPattern(
                    org.apache.xml.dtm.DTMFilter.
                      SHOW_DOCUMENT |
                      org.apache.xml.dtm.DTMFilter.
                        SHOW_DOCUMENT_FRAGMENT,
                    axis,
                    predicateAxis);
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_ATTRIBUTES:
                whatToShow =
                  org.apache.xml.dtm.DTMFilter.
                    SHOW_ATTRIBUTE;
                axis =
                  org.apache.xml.dtm.Axis.
                    PARENT;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    ATTRIBUTE;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_NAMESPACE:
                whatToShow =
                  org.apache.xml.dtm.DTMFilter.
                    SHOW_NAMESPACE;
                axis =
                  org.apache.xml.dtm.Axis.
                    PARENT;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    NAMESPACE;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_ANCESTORS:
                axis =
                  org.apache.xml.dtm.Axis.
                    DESCENDANT;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    ANCESTOR;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_CHILDREN:
                axis =
                  org.apache.xml.dtm.Axis.
                    PARENT;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    CHILD;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_ANCESTORS_OR_SELF:
                axis =
                  org.apache.xml.dtm.Axis.
                    DESCENDANTORSELF;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    ANCESTORORSELF;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_SELF:
                axis =
                  org.apache.xml.dtm.Axis.
                    SELF;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    SELF;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_PARENT:
                axis =
                  org.apache.xml.dtm.Axis.
                    CHILD;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    PARENT;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_PRECEDING_SIBLINGS:
                axis =
                  org.apache.xml.dtm.Axis.
                    FOLLOWINGSIBLING;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    PRECEDINGSIBLING;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_PRECEDING:
                axis =
                  org.apache.xml.dtm.Axis.
                    FOLLOWING;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    PRECEDING;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_FOLLOWING_SIBLINGS:
                axis =
                  org.apache.xml.dtm.Axis.
                    PRECEDINGSIBLING;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    FOLLOWINGSIBLING;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_FOLLOWING:
                axis =
                  org.apache.xml.dtm.Axis.
                    PRECEDING;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    FOLLOWING;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_DESCENDANTS_OR_SELF:
                axis =
                  org.apache.xml.dtm.Axis.
                    ANCESTORORSELF;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    DESCENDANTORSELF;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_DESCENDANTS:
                axis =
                  org.apache.xml.dtm.Axis.
                    ANCESTOR;
                predicateAxis =
                  org.apache.xml.dtm.Axis.
                    DESCENDANT;
                break;
            default:
                throw new java.lang.RuntimeException(
                  org.apache.xalan.res.XSLMessages.
                    createXPATHMessage(
                      org.apache.xpath.res.XPATHErrorResources.
                        ER_NULL_ERROR_HANDLER,
                      new java.lang.Object[] { java.lang.Integer.
                        toString(
                          stepType) }));
        }
        if (null ==
              ai) {
            whatToShow =
              compiler.
                getWhatToShow(
                  opPos);
            ai =
              new org.apache.xpath.patterns.StepPattern(
                whatToShow,
                compiler.
                  getStepNS(
                    opPos),
                compiler.
                  getStepLocalName(
                    opPos),
                axis,
                predicateAxis);
        }
        if (false ||
              DEBUG_PATTERN_CREATION) {
            java.lang.System.
              out.
              print(
                "new step: " +
                ai);
            java.lang.System.
              out.
              print(
                ", axis: " +
                org.apache.xml.dtm.Axis.
                  getNames(
                    ai.
                      getAxis(
                        )));
            java.lang.System.
              out.
              print(
                ", predAxis: " +
                org.apache.xml.dtm.Axis.
                  getNames(
                    ai.
                      getAxis(
                        )));
            java.lang.System.
              out.
              print(
                ", what: ");
            java.lang.System.
              out.
              print(
                "    ");
            ai.
              debugWhatToShow(
                ai.
                  getWhatToShow(
                    ));
        }
        int argLen =
          compiler.
          getFirstPredicateOpPos(
            opPos);
        ai.
          setPredicates(
            compiler.
              getCompiledPredicates(
                argLen));
        return ai;
    }
    static boolean analyzePredicate(org.apache.xpath.compiler.Compiler compiler,
                                    int opPos,
                                    int stepType)
          throws javax.xml.transform.TransformerException {
        int argLen;
        switch (stepType) {
            case org.apache.xpath.compiler.OpCodes.
                   OP_VARIABLE:
            case org.apache.xpath.compiler.OpCodes.
                   OP_EXTFUNCTION:
            case org.apache.xpath.compiler.OpCodes.
                   OP_FUNCTION:
            case org.apache.xpath.compiler.OpCodes.
                   OP_GROUP:
                argLen =
                  compiler.
                    getArgLength(
                      opPos);
                break;
            default:
                argLen =
                  compiler.
                    getArgLengthOfStep(
                      opPos);
        }
        int pos =
          compiler.
          getFirstPredicateOpPos(
            opPos);
        int nPredicates =
          compiler.
          countPredicates(
            pos);
        return nPredicates >
          0
          ? true
          : false;
    }
    private static org.apache.xpath.axes.AxesWalker createDefaultWalker(org.apache.xpath.compiler.Compiler compiler,
                                                                        int opPos,
                                                                        org.apache.xpath.axes.WalkingIterator lpi,
                                                                        int analysis) {
        org.apache.xpath.axes.AxesWalker ai =
          null;
        int stepType =
          compiler.
          getOp(
            opPos);
        boolean simpleInit =
          false;
        int totalNumberWalkers =
          analysis &
          BITS_COUNT;
        boolean prevIsOneStepDown =
          true;
        switch (stepType) {
            case org.apache.xpath.compiler.OpCodes.
                   OP_VARIABLE:
            case org.apache.xpath.compiler.OpCodes.
                   OP_EXTFUNCTION:
            case org.apache.xpath.compiler.OpCodes.
                   OP_FUNCTION:
            case org.apache.xpath.compiler.OpCodes.
                   OP_GROUP:
                prevIsOneStepDown =
                  false;
                if (DEBUG_WALKER_CREATION)
                    java.lang.System.
                      out.
                      println(
                        "new walker:  FilterExprWalker: " +
                        analysis +
                        ", " +
                        compiler.
                          toString(
                            ));
                ai =
                  new org.apache.xpath.axes.FilterExprWalker(
                    lpi);
                simpleInit =
                  true;
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_ROOT:
                ai =
                  new org.apache.xpath.axes.AxesWalker(
                    lpi,
                    org.apache.xml.dtm.Axis.
                      ROOT);
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_ANCESTORS:
                prevIsOneStepDown =
                  false;
                ai =
                  new org.apache.xpath.axes.ReverseAxesWalker(
                    lpi,
                    org.apache.xml.dtm.Axis.
                      ANCESTOR);
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_ANCESTORS_OR_SELF:
                prevIsOneStepDown =
                  false;
                ai =
                  new org.apache.xpath.axes.ReverseAxesWalker(
                    lpi,
                    org.apache.xml.dtm.Axis.
                      ANCESTORORSELF);
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_ATTRIBUTES:
                ai =
                  new org.apache.xpath.axes.AxesWalker(
                    lpi,
                    org.apache.xml.dtm.Axis.
                      ATTRIBUTE);
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_NAMESPACE:
                ai =
                  new org.apache.xpath.axes.AxesWalker(
                    lpi,
                    org.apache.xml.dtm.Axis.
                      NAMESPACE);
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_CHILDREN:
                ai =
                  new org.apache.xpath.axes.AxesWalker(
                    lpi,
                    org.apache.xml.dtm.Axis.
                      CHILD);
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_DESCENDANTS:
                prevIsOneStepDown =
                  false;
                ai =
                  new org.apache.xpath.axes.AxesWalker(
                    lpi,
                    org.apache.xml.dtm.Axis.
                      DESCENDANT);
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_DESCENDANTS_OR_SELF:
                prevIsOneStepDown =
                  false;
                ai =
                  new org.apache.xpath.axes.AxesWalker(
                    lpi,
                    org.apache.xml.dtm.Axis.
                      DESCENDANTORSELF);
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_FOLLOWING:
                prevIsOneStepDown =
                  false;
                ai =
                  new org.apache.xpath.axes.AxesWalker(
                    lpi,
                    org.apache.xml.dtm.Axis.
                      FOLLOWING);
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_FOLLOWING_SIBLINGS:
                prevIsOneStepDown =
                  false;
                ai =
                  new org.apache.xpath.axes.AxesWalker(
                    lpi,
                    org.apache.xml.dtm.Axis.
                      FOLLOWINGSIBLING);
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_PRECEDING:
                prevIsOneStepDown =
                  false;
                ai =
                  new org.apache.xpath.axes.ReverseAxesWalker(
                    lpi,
                    org.apache.xml.dtm.Axis.
                      PRECEDING);
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_PRECEDING_SIBLINGS:
                prevIsOneStepDown =
                  false;
                ai =
                  new org.apache.xpath.axes.ReverseAxesWalker(
                    lpi,
                    org.apache.xml.dtm.Axis.
                      PRECEDINGSIBLING);
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_PARENT:
                prevIsOneStepDown =
                  false;
                ai =
                  new org.apache.xpath.axes.ReverseAxesWalker(
                    lpi,
                    org.apache.xml.dtm.Axis.
                      PARENT);
                break;
            case org.apache.xpath.compiler.OpCodes.
                   FROM_SELF:
                ai =
                  new org.apache.xpath.axes.AxesWalker(
                    lpi,
                    org.apache.xml.dtm.Axis.
                      SELF);
                break;
            default:
                throw new java.lang.RuntimeException(
                  org.apache.xalan.res.XSLMessages.
                    createXPATHMessage(
                      org.apache.xpath.res.XPATHErrorResources.
                        ER_NULL_ERROR_HANDLER,
                      new java.lang.Object[] { java.lang.Integer.
                        toString(
                          stepType) }));
        }
        if (simpleInit) {
            ai.
              initNodeTest(
                org.apache.xml.dtm.DTMFilter.
                  SHOW_ALL);
        }
        else {
            int whatToShow =
              compiler.
              getWhatToShow(
                opPos);
            if (0 ==
                  (whatToShow &
                     (org.apache.xml.dtm.DTMFilter.
                        SHOW_ATTRIBUTE |
                        org.apache.xml.dtm.DTMFilter.
                          SHOW_NAMESPACE |
                        org.apache.xml.dtm.DTMFilter.
                          SHOW_ELEMENT |
                        org.apache.xml.dtm.DTMFilter.
                          SHOW_PROCESSING_INSTRUCTION)) ||
                  whatToShow ==
                  org.apache.xml.dtm.DTMFilter.
                    SHOW_ALL)
                ai.
                  initNodeTest(
                    whatToShow);
            else {
                ai.
                  initNodeTest(
                    whatToShow,
                    compiler.
                      getStepNS(
                        opPos),
                    compiler.
                      getStepLocalName(
                        opPos));
            }
        }
        return ai;
    }
    public static java.lang.String getAnalysisString(int analysis) {
        java.lang.StringBuffer buf =
          new java.lang.StringBuffer(
          );
        buf.
          append(
            "count: " +
            getStepCount(
              analysis) +
            " ");
        if ((analysis &
               BIT_NODETEST_ANY) !=
              0) {
            buf.
              append(
                "NTANY|");
        }
        if ((analysis &
               BIT_PREDICATE) !=
              0) {
            buf.
              append(
                "PRED|");
        }
        if ((analysis &
               BIT_ANCESTOR) !=
              0) {
            buf.
              append(
                "ANC|");
        }
        if ((analysis &
               BIT_ANCESTOR_OR_SELF) !=
              0) {
            buf.
              append(
                "ANCOS|");
        }
        if ((analysis &
               BIT_ATTRIBUTE) !=
              0) {
            buf.
              append(
                "ATTR|");
        }
        if ((analysis &
               BIT_CHILD) !=
              0) {
            buf.
              append(
                "CH|");
        }
        if ((analysis &
               BIT_DESCENDANT) !=
              0) {
            buf.
              append(
                "DESC|");
        }
        if ((analysis &
               BIT_DESCENDANT_OR_SELF) !=
              0) {
            buf.
              append(
                "DESCOS|");
        }
        if ((analysis &
               BIT_FOLLOWING) !=
              0) {
            buf.
              append(
                "FOL|");
        }
        if ((analysis &
               BIT_FOLLOWING_SIBLING) !=
              0) {
            buf.
              append(
                "FOLS|");
        }
        if ((analysis &
               BIT_NAMESPACE) !=
              0) {
            buf.
              append(
                "NS|");
        }
        if ((analysis &
               BIT_PARENT) !=
              0) {
            buf.
              append(
                "P|");
        }
        if ((analysis &
               BIT_PRECEDING) !=
              0) {
            buf.
              append(
                "PREC|");
        }
        if ((analysis &
               BIT_PRECEDING_SIBLING) !=
              0) {
            buf.
              append(
                "PRECS|");
        }
        if ((analysis &
               BIT_SELF) !=
              0) {
            buf.
              append(
                ".|");
        }
        if ((analysis &
               BIT_FILTER) !=
              0) {
            buf.
              append(
                "FLT|");
        }
        if ((analysis &
               BIT_ROOT) !=
              0) {
            buf.
              append(
                "R|");
        }
        return buf.
          toString(
            );
    }
    static final boolean DEBUG_PATTERN_CREATION =
      false;
    static final boolean DEBUG_WALKER_CREATION =
      false;
    static final boolean DEBUG_ITERATOR_CREATION =
      false;
    public static boolean hasPredicate(int analysis) {
        return 0 !=
          (analysis &
             BIT_PREDICATE);
    }
    public static boolean isWild(int analysis) {
        return 0 !=
          (analysis &
             BIT_NODETEST_ANY);
    }
    public static boolean walksAncestors(int analysis) {
        return isSet(
                 analysis,
                 BIT_ANCESTOR |
                   BIT_ANCESTOR_OR_SELF);
    }
    public static boolean walksAttributes(int analysis) {
        return 0 !=
          (analysis &
             BIT_ATTRIBUTE);
    }
    public static boolean walksNamespaces(int analysis) {
        return 0 !=
          (analysis &
             BIT_NAMESPACE);
    }
    public static boolean walksChildren(int analysis) {
        return 0 !=
          (analysis &
             BIT_CHILD);
    }
    public static boolean walksDescendants(int analysis) {
        return isSet(
                 analysis,
                 BIT_DESCENDANT |
                   BIT_DESCENDANT_OR_SELF);
    }
    public static boolean walksSubtree(int analysis) {
        return isSet(
                 analysis,
                 BIT_DESCENDANT |
                   BIT_DESCENDANT_OR_SELF |
                   BIT_CHILD);
    }
    public static boolean walksSubtreeOnlyMaybeAbsolute(int analysis) {
        return walksSubtree(
                 analysis) &&
          !walksExtraNodes(
             analysis) &&
          !walksUp(
             analysis) &&
          !walksSideways(
             analysis);
    }
    public static boolean walksSubtreeOnly(int analysis) {
        return walksSubtreeOnlyMaybeAbsolute(
                 analysis) &&
          !isAbsolute(
             analysis);
    }
    public static boolean walksFilteredList(int analysis) {
        return isSet(
                 analysis,
                 BIT_FILTER);
    }
    public static boolean walksSubtreeOnlyFromRootOrContext(int analysis) {
        return walksSubtree(
                 analysis) &&
          !walksExtraNodes(
             analysis) &&
          !walksUp(
             analysis) &&
          !walksSideways(
             analysis) &&
          !isSet(
             analysis,
             BIT_FILTER);
    }
    public static boolean walksInDocOrder(int analysis) {
        return (walksSubtreeOnlyMaybeAbsolute(
                  analysis) ||
                  walksExtraNodesOnly(
                    analysis) ||
                  walksFollowingOnlyMaybeAbsolute(
                    analysis)) &&
          !isSet(
             analysis,
             BIT_FILTER);
    }
    public static boolean walksFollowingOnlyMaybeAbsolute(int analysis) {
        return isSet(
                 analysis,
                 BIT_SELF |
                   BIT_FOLLOWING_SIBLING |
                   BIT_FOLLOWING) &&
          !walksSubtree(
             analysis) &&
          !walksUp(
             analysis) &&
          !walksSideways(
             analysis);
    }
    public static boolean walksUp(int analysis) {
        return isSet(
                 analysis,
                 BIT_PARENT |
                   BIT_ANCESTOR |
                   BIT_ANCESTOR_OR_SELF);
    }
    public static boolean walksSideways(int analysis) {
        return isSet(
                 analysis,
                 BIT_FOLLOWING |
                   BIT_FOLLOWING_SIBLING |
                   BIT_PRECEDING |
                   BIT_PRECEDING_SIBLING);
    }
    public static boolean walksExtraNodes(int analysis) {
        return isSet(
                 analysis,
                 BIT_NAMESPACE |
                   BIT_ATTRIBUTE);
    }
    public static boolean walksExtraNodesOnly(int analysis) {
        return walksExtraNodes(
                 analysis) &&
          !isSet(
             analysis,
             BIT_SELF) &&
          !walksSubtree(
             analysis) &&
          !walksUp(
             analysis) &&
          !walksSideways(
             analysis) &&
          !isAbsolute(
             analysis);
    }
    public static boolean isAbsolute(int analysis) {
        return isSet(
                 analysis,
                 BIT_ROOT |
                   BIT_FILTER);
    }
    public static boolean walksChildrenOnly(int analysis) {
        return walksChildren(
                 analysis) &&
          !isSet(
             analysis,
             BIT_SELF) &&
          !walksExtraNodes(
             analysis) &&
          !walksDescendants(
             analysis) &&
          !walksUp(
             analysis) &&
          !walksSideways(
             analysis) &&
          (!isAbsolute(
              analysis) ||
             isSet(
               analysis,
               BIT_ROOT));
    }
    public static boolean walksChildrenAndExtraAndSelfOnly(int analysis) {
        return walksChildren(
                 analysis) &&
          !walksDescendants(
             analysis) &&
          !walksUp(
             analysis) &&
          !walksSideways(
             analysis) &&
          (!isAbsolute(
              analysis) ||
             isSet(
               analysis,
               BIT_ROOT));
    }
    public static boolean walksDescendantsAndExtraAndSelfOnly(int analysis) {
        return !walksChildren(
                  analysis) &&
          walksDescendants(
            analysis) &&
          !walksUp(
             analysis) &&
          !walksSideways(
             analysis) &&
          (!isAbsolute(
              analysis) ||
             isSet(
               analysis,
               BIT_ROOT));
    }
    public static boolean walksSelfOnly(int analysis) {
        return isSet(
                 analysis,
                 BIT_SELF) &&
          !walksSubtree(
             analysis) &&
          !walksUp(
             analysis) &&
          !walksSideways(
             analysis) &&
          !isAbsolute(
             analysis);
    }
    public static boolean walksUpOnly(int analysis) {
        return !walksSubtree(
                  analysis) &&
          walksUp(
            analysis) &&
          !walksSideways(
             analysis) &&
          !isAbsolute(
             analysis);
    }
    public static boolean walksDownOnly(int analysis) {
        return walksSubtree(
                 analysis) &&
          !walksUp(
             analysis) &&
          !walksSideways(
             analysis) &&
          !isAbsolute(
             analysis);
    }
    public static boolean walksDownExtraOnly(int analysis) {
        return walksSubtree(
                 analysis) &&
          walksExtraNodes(
            analysis) &&
          !walksUp(
             analysis) &&
          !walksSideways(
             analysis) &&
          !isAbsolute(
             analysis);
    }
    public static boolean canSkipSubtrees(int analysis) {
        return isSet(
                 analysis,
                 BIT_CHILD) |
          walksSideways(
            analysis);
    }
    public static boolean canCrissCross(int analysis) {
        if (walksSelfOnly(
              analysis))
            return false;
        else
            if (walksDownOnly(
                  analysis) &&
                  !canSkipSubtrees(
                     analysis))
                return false;
            else
                if (walksChildrenAndExtraAndSelfOnly(
                      analysis))
                    return false;
                else
                    if (walksDescendantsAndExtraAndSelfOnly(
                          analysis))
                        return false;
                    else
                        if (walksUpOnly(
                              analysis))
                            return false;
                        else
                            if (walksExtraNodesOnly(
                                  analysis))
                                return false;
                            else
                                if (walksSubtree(
                                      analysis) &&
                                      (walksSideways(
                                         analysis) ||
                                         walksUp(
                                           analysis) ||
                                         canSkipSubtrees(
                                           analysis)))
                                    return true;
                                else
                                    return false;
    }
    public static boolean isNaturalDocOrder(int analysis) {
        if (canCrissCross(
              analysis) ||
              isSet(
                analysis,
                BIT_NAMESPACE) ||
              walksFilteredList(
                analysis))
            return false;
        if (walksInDocOrder(
              analysis))
            return true;
        return false;
    }
    private static boolean isNaturalDocOrder(org.apache.xpath.compiler.Compiler compiler,
                                             int stepOpCodePos,
                                             int stepIndex,
                                             int analysis)
          throws javax.xml.transform.TransformerException {
        if (canCrissCross(
              analysis))
            return false;
        if (isSet(
              analysis,
              BIT_NAMESPACE))
            return false;
        if (isSet(
              analysis,
              BIT_FOLLOWING |
                BIT_FOLLOWING_SIBLING) &&
              isSet(
                analysis,
                BIT_PRECEDING |
                  BIT_PRECEDING_SIBLING))
            return false;
        int stepType;
        int stepCount =
          0;
        boolean foundWildAttribute =
          false;
        int potentialDuplicateMakingStepCount =
          0;
        while (org.apache.xpath.compiler.OpCodes.
                 ENDOP !=
                 (stepType =
                    compiler.
                      getOp(
                        stepOpCodePos))) {
            stepCount++;
            switch (stepType) {
                case org.apache.xpath.compiler.OpCodes.
                       FROM_ATTRIBUTES:
                case org.apache.xpath.compiler.OpCodes.
                       MATCH_ATTRIBUTE:
                    if (foundWildAttribute)
                        return false;
                    java.lang.String localName =
                      compiler.
                      getStepLocalName(
                        stepOpCodePos);
                    if (localName.
                          equals(
                            "*")) {
                        foundWildAttribute =
                          true;
                    }
                    break;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_FOLLOWING:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_FOLLOWING_SIBLINGS:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_PRECEDING:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_PRECEDING_SIBLINGS:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_PARENT:
                case org.apache.xpath.compiler.OpCodes.
                       OP_VARIABLE:
                case org.apache.xpath.compiler.OpCodes.
                       OP_EXTFUNCTION:
                case org.apache.xpath.compiler.OpCodes.
                       OP_FUNCTION:
                case org.apache.xpath.compiler.OpCodes.
                       OP_GROUP:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_NAMESPACE:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_ANCESTORS:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_ANCESTORS_OR_SELF:
                case org.apache.xpath.compiler.OpCodes.
                       MATCH_ANY_ANCESTOR:
                case org.apache.xpath.compiler.OpCodes.
                       MATCH_IMMEDIATE_ANCESTOR:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_DESCENDANTS_OR_SELF:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_DESCENDANTS:
                    if (potentialDuplicateMakingStepCount >
                          0)
                        return false;
                    potentialDuplicateMakingStepCount++;
                case org.apache.xpath.compiler.OpCodes.
                       FROM_ROOT:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_CHILDREN:
                case org.apache.xpath.compiler.OpCodes.
                       FROM_SELF:
                    if (foundWildAttribute)
                        return false;
                    break;
                default:
                    throw new java.lang.RuntimeException(
                      org.apache.xalan.res.XSLMessages.
                        createXPATHMessage(
                          org.apache.xpath.res.XPATHErrorResources.
                            ER_NULL_ERROR_HANDLER,
                          new java.lang.Object[] { java.lang.Integer.
                            toString(
                              stepType) }));
            }
            int nextStepOpCodePos =
              compiler.
              getNextStepPos(
                stepOpCodePos);
            if (nextStepOpCodePos <
                  0)
                break;
            stepOpCodePos =
              nextStepOpCodePos;
        }
        return true;
    }
    public static boolean isOneStep(int analysis) {
        return (analysis &
                  BITS_COUNT) ==
          1;
    }
    public static int getStepCount(int analysis) {
        return analysis &
          BITS_COUNT;
    }
    public static final int BITS_COUNT = 255;
    public static final int BITS_RESERVED =
      3840;
    public static final int BIT_PREDICATE =
      4096;
    public static final int BIT_ANCESTOR =
      4096 <<
      1;
    public static final int BIT_ANCESTOR_OR_SELF =
      4096 <<
      2;
    public static final int BIT_ATTRIBUTE =
      4096 <<
      3;
    public static final int BIT_CHILD = 4096 <<
      4;
    public static final int BIT_DESCENDANT =
      4096 <<
      5;
    public static final int BIT_DESCENDANT_OR_SELF =
      4096 <<
      6;
    public static final int BIT_FOLLOWING =
      4096 <<
      7;
    public static final int BIT_FOLLOWING_SIBLING =
      4096 <<
      8;
    public static final int BIT_NAMESPACE =
      4096 <<
      9;
    public static final int BIT_PARENT = 4096 <<
      10;
    public static final int BIT_PRECEDING =
      4096 <<
      11;
    public static final int BIT_PRECEDING_SIBLING =
      4096 <<
      12;
    public static final int BIT_SELF = 4096 <<
      13;
    public static final int BIT_FILTER = 4096 <<
      14;
    public static final int BIT_ROOT = 4096 <<
      15;
    public static final int BITMASK_TRAVERSES_OUTSIDE_SUBTREE =
      BIT_NAMESPACE |
      BIT_PRECEDING_SIBLING |
      BIT_PRECEDING |
      BIT_FOLLOWING_SIBLING |
      BIT_FOLLOWING |
      BIT_PARENT |
      BIT_ANCESTOR_OR_SELF |
      BIT_ANCESTOR |
      BIT_FILTER |
      BIT_ROOT;
    public static final int BIT_BACKWARDS_SELF =
      4096 <<
      16;
    public static final int BIT_ANY_DESCENDANT_FROM_ROOT =
      4096 <<
      17;
    public static final int BIT_NODETEST_ANY =
      4096 <<
      18;
    public static final int BIT_MATCH_PATTERN =
      4096 <<
      19;
    public WalkerFactory() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "H2rN+Kd+YwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "TUvRqjVVfavNwKV42KupBRWui4tJ1xYF");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "4Mtum2dyAAA=");
}
