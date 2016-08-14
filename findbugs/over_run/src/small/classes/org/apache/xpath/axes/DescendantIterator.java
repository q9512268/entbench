package org.apache.xpath.axes;
public class DescendantIterator extends org.apache.xpath.axes.LocPathIterator {
    static final long serialVersionUID = -1190338607743976938L;
    DescendantIterator(org.apache.xpath.compiler.Compiler compiler, int opPos,
                       int analysis) throws javax.xml.transform.TransformerException {
        super(
          compiler,
          opPos,
          analysis,
          false);
        int firstStepPos =
          org.apache.xpath.compiler.OpMap.
          getFirstChildPos(
            opPos);
        int stepType =
          compiler.
          getOp(
            firstStepPos);
        boolean orSelf =
          org.apache.xpath.compiler.OpCodes.
            FROM_DESCENDANTS_OR_SELF ==
          stepType;
        boolean fromRoot =
          false;
        if (org.apache.xpath.compiler.OpCodes.
              FROM_SELF ==
              stepType) {
            orSelf =
              true;
        }
        else
            if (org.apache.xpath.compiler.OpCodes.
                  FROM_ROOT ==
                  stepType) {
                fromRoot =
                  true;
                int nextStepPos =
                  compiler.
                  getNextStepPos(
                    firstStepPos);
                if (compiler.
                      getOp(
                        nextStepPos) ==
                      org.apache.xpath.compiler.OpCodes.
                        FROM_DESCENDANTS_OR_SELF)
                    orSelf =
                      true;
            }
        int nextStepPos =
          firstStepPos;
        while (true) {
            nextStepPos =
              compiler.
                getNextStepPos(
                  nextStepPos);
            if (nextStepPos >
                  0) {
                int stepOp =
                  compiler.
                  getOp(
                    nextStepPos);
                if (org.apache.xpath.compiler.OpCodes.
                      ENDOP !=
                      stepOp)
                    firstStepPos =
                      nextStepPos;
                else
                    break;
            }
            else
                break;
        }
        if ((analysis &
               org.apache.xpath.axes.WalkerFactory.
                 BIT_CHILD) !=
              0)
            orSelf =
              false;
        if (fromRoot) {
            if (orSelf)
                m_axis =
                  org.apache.xml.dtm.Axis.
                    DESCENDANTSORSELFFROMROOT;
            else
                m_axis =
                  org.apache.xml.dtm.Axis.
                    DESCENDANTSFROMROOT;
        }
        else
            if (orSelf)
                m_axis =
                  org.apache.xml.dtm.Axis.
                    DESCENDANTORSELF;
            else
                m_axis =
                  org.apache.xml.dtm.Axis.
                    DESCENDANT;
        int whatToShow =
          compiler.
          getWhatToShow(
            firstStepPos);
        if (0 ==
              (whatToShow &
                 (org.apache.xml.dtm.DTMFilter.
                    SHOW_ATTRIBUTE |
                    org.apache.xml.dtm.DTMFilter.
                      SHOW_ELEMENT |
                    org.apache.xml.dtm.DTMFilter.
                      SHOW_PROCESSING_INSTRUCTION)) ||
              whatToShow ==
              org.apache.xml.dtm.DTMFilter.
                SHOW_ALL)
            initNodeTest(
              whatToShow);
        else {
            initNodeTest(
              whatToShow,
              compiler.
                getStepNS(
                  firstStepPos),
              compiler.
                getStepLocalName(
                  firstStepPos));
        }
        initPredicateInfo(
          compiler,
          firstStepPos);
    }
    public DescendantIterator() { super(null);
                                  m_axis = org.apache.xml.dtm.Axis.
                                             DESCENDANTSORSELFFROMROOT;
                                  int whatToShow = org.apache.xml.dtm.DTMFilter.
                                                     SHOW_ALL;
                                  initNodeTest(whatToShow); }
    public org.apache.xml.dtm.DTMIterator cloneWithReset() throws java.lang.CloneNotSupportedException {
        org.apache.xpath.axes.DescendantIterator clone =
          (org.apache.xpath.axes.DescendantIterator)
            super.
            cloneWithReset(
              );
        clone.
          m_traverser =
          m_traverser;
        clone.
          resetProximityPositions(
            );
        return clone;
    }
    public int nextNode() { if (m_foundLast) return org.apache.xml.dtm.DTM.
                                                      NULL;
                            if (org.apache.xml.dtm.DTM.NULL ==
                                  m_lastFetched) { resetProximityPositions(
                                                     ); }
                            int next;
                            org.apache.xpath.VariableStack vars;
                            int savedStart;
                            if (-1 != m_stackFrame) { vars =
                                                        m_execContext.
                                                          getVarStack(
                                                            );
                                                      savedStart =
                                                        vars.
                                                          getStackFrame(
                                                            );
                                                      vars.
                                                        setStackFrame(
                                                          m_stackFrame);
                            }
                            else {
                                vars =
                                  null;
                                savedStart =
                                  0;
                            }
                            try { do  { if (0 == m_extendedTypeID) {
                                            next =
                                              (m_lastFetched =
                                                 org.apache.xml.dtm.DTM.
                                                   NULL ==
                                                   m_lastFetched
                                                   ? m_traverser.
                                                   first(
                                                     m_context)
                                                   : m_traverser.
                                                   next(
                                                     m_context,
                                                     m_lastFetched));
                                        }
                                        else {
                                            next =
                                              (m_lastFetched =
                                                 org.apache.xml.dtm.DTM.
                                                   NULL ==
                                                   m_lastFetched
                                                   ? m_traverser.
                                                   first(
                                                     m_context,
                                                     m_extendedTypeID)
                                                   : m_traverser.
                                                   next(
                                                     m_context,
                                                     m_lastFetched,
                                                     m_extendedTypeID));
                                        }
                                        if (org.apache.xml.dtm.DTM.
                                              NULL != next) {
                                            if (org.apache.xml.dtm.DTMIterator.
                                                  FILTER_ACCEPT ==
                                                  acceptNode(
                                                    next))
                                                break;
                                            else
                                                continue;
                                        }
                                        else
                                            break; }while(next !=
                                                            org.apache.xml.dtm.DTM.
                                                              NULL); 
                                  if (org.apache.xml.dtm.DTM.
                                        NULL != next) {
                                      m_pos++;
                                      return next;
                                  }
                                  else {
                                      m_foundLast =
                                        true;
                                      return org.apache.xml.dtm.DTM.
                                               NULL;
                                  } }
                            finally { if (-1 != m_stackFrame) {
                                          vars.
                                            setStackFrame(
                                              savedStart);
                                      } } }
    public void setRoot(int context, java.lang.Object environment) {
        super.
          setRoot(
            context,
            environment);
        m_traverser =
          m_cdtm.
            getAxisTraverser(
              m_axis);
        java.lang.String localName =
          getLocalName(
            );
        java.lang.String namespace =
          getNamespace(
            );
        int what =
          m_whatToShow;
        if (org.apache.xml.dtm.DTMFilter.
              SHOW_ALL ==
              what ||
              org.apache.xpath.patterns.NodeTest.
                WILD.
              equals(
                localName) ||
              org.apache.xpath.patterns.NodeTest.
                WILD.
              equals(
                namespace)) {
            m_extendedTypeID =
              0;
        }
        else {
            int type =
              getNodeTypeTest(
                what);
            m_extendedTypeID =
              m_cdtm.
                getExpandedTypeID(
                  namespace,
                  localName,
                  type);
        }
    }
    public int asNode(org.apache.xpath.XPathContext xctxt)
          throws javax.xml.transform.TransformerException {
        if (getPredicateCount(
              ) >
              0)
            return super.
              asNode(
                xctxt);
        int current =
          xctxt.
          getCurrentNode(
            );
        org.apache.xml.dtm.DTM dtm =
          xctxt.
          getDTM(
            current);
        org.apache.xml.dtm.DTMAxisTraverser traverser =
          dtm.
          getAxisTraverser(
            m_axis);
        java.lang.String localName =
          getLocalName(
            );
        java.lang.String namespace =
          getNamespace(
            );
        int what =
          m_whatToShow;
        if (org.apache.xml.dtm.DTMFilter.
              SHOW_ALL ==
              what ||
              localName ==
              org.apache.xpath.patterns.NodeTest.
                WILD ||
              namespace ==
              org.apache.xpath.patterns.NodeTest.
                WILD) {
            return traverser.
              first(
                current);
        }
        else {
            int type =
              getNodeTypeTest(
                what);
            int extendedType =
              dtm.
              getExpandedTypeID(
                namespace,
                localName,
                type);
            return traverser.
              first(
                current,
                extendedType);
        }
    }
    public void detach() { if (m_allowDetach) { m_traverser =
                                                  null;
                                                m_extendedTypeID =
                                                  0;
                                                super.
                                                  detach(
                                                    );
                           } }
    public int getAxis() { return m_axis; }
    protected transient org.apache.xml.dtm.DTMAxisTraverser
      m_traverser;
    protected int m_axis;
    protected int m_extendedTypeID;
    public boolean deepEquals(org.apache.xpath.Expression expr) {
        if (!super.
              deepEquals(
                expr))
            return false;
        if (m_axis !=
              ((org.apache.xpath.axes.DescendantIterator)
                 expr).
                m_axis)
            return false;
        return true;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "M62nzjFkHLEDF3WB0/SJqJ06+DafLJc71gM4MNttOC9ayDjKspLI7SZ+RMUz" +
       "VdxgpEAEi4rKpwbXyIJ2mlr1hk1Wc2HdHhAiN7NtMpOt5bzfmyU8OuxFOhok" +
       "NO0YZn9BrFHUYvskNWPmIdOuJu0Im6w7pmQ5ZD+lA3UiBhu9QmCWacoIXY3a" +
       "Y8/z3A3sYpMecLJmgPENOp+sW9o8pKeu2qNotI9JuyXK8r5Ct5q8rQXoKq4D" +
       "vNrWJC/Td8YIN0hJ7vHJoIpPBL/RGyKwXTNWJJyHK9NkG8JCiBp6Z+C20qrT" +
       "6gnj6aQTdhdbMRy02Bm9oRvZtKPVp+O1M+mN0bGqpYnc89htNWyRA2peZenN" +
       "OInVXiquOF4aE4N+sJp1W/xyMWcGU3pXs7fNoE3S2pyxWhnSiptLw9STlZyH" +
       "Axuvc2TQnKMwX2Hac6PS5Xgzzxau7lB4tDMaq3xgtJq4ozCyi45WUl8jaz2X" +
       "QZGmuZjWOzrSbSd9nq5Yo1GnPhwidU7uDwh8WiUQeMEmdNjJuk3asWhXoRin" +
       "0gCc62M608eTPkMwqzWJpUi7NhlOV+ug2llhGol060zWqXm1bafuZo0RjNq9" +
       "MaK0dpolbCuJuB3WRCTiGDyoo5N1PlKTjZTusDblJa1sTqILfeVR6zB3200i" +
       "4aqrqNdBCUuYuyNM20X4KJhj44anxZRkoRprDc12R25TmgErdcliVu7cppbd" +
       "rNXnm2pMs5KstQU3RyStIVoUO7DX9WyEdfNlq9WSGXExnuKjWLZQMLn53KSj" +
       "znROLjGNne0y05zwJjrIgblhYPuWvGGAJ9Gp7zTiKjfZ8vTOEWhWDXGmoyDR" +
       "ZsYi7W5Wo3teK0YyMm80llEFSxqKmnvqyMXaWN0fdrJdaNMDMTWUrkO2skSa" +
       "4ytK2g6YsBVlcNQgJaqmqObKMpb1MPcqZrdLLkKkBtYOzUGdWPSM5a5LkKgx" +
       "6FjjVcAliDxyZqZuGHAYhpWlMEPpKcG7tYETTtczfr5sTSzJVZKhoXdcZz1d" +
       "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" +
       "GZAU2UeCY3M9f/f7cLSvFXhzrJvs0vml");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("1IneH/l2ej+z+nru3JqpvPl7vL5J9nd/b2tfeJViPv6N9k/s72hpjprnRS/X" +
       "aeja/rrYyRrpmTfs7bivq4MXvvXQz93//PF67qE9w6defoa39939ZhTuBnF5" +
       "lyn/pcf/yYd+8tWvlIfp/wcRInh9ki0AAA==");
}
