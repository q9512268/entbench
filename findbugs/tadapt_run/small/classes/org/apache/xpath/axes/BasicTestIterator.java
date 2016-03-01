package org.apache.xpath.axes;
public abstract class BasicTestIterator extends org.apache.xpath.axes.LocPathIterator {
    static final long serialVersionUID = 3505378079378096623L;
    protected BasicTestIterator() { super(); }
    protected BasicTestIterator(org.apache.xml.utils.PrefixResolver nscontext) {
        super(
          nscontext);
    }
    protected BasicTestIterator(org.apache.xpath.compiler.Compiler compiler,
                                int opPos,
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
        int whatToShow =
          compiler.
          getWhatToShow(
            firstStepPos);
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
    protected BasicTestIterator(org.apache.xpath.compiler.Compiler compiler,
                                int opPos,
                                int analysis,
                                boolean shouldLoadWalkers) throws javax.xml.transform.TransformerException {
        super(
          compiler,
          opPos,
          analysis,
          shouldLoadWalkers);
    }
    protected abstract int getNextNode();
    public int nextNode() { if (m_foundLast) { m_lastFetched =
                                                 org.apache.xml.dtm.DTM.
                                                   NULL;
                                               return org.apache.xml.dtm.DTM.
                                                        NULL;
                            }
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
                            try { do  { next = getNextNode(
                                                 );
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
    public org.apache.xml.dtm.DTMIterator cloneWithReset()
          throws java.lang.CloneNotSupportedException {
        org.apache.xpath.axes.ChildTestIterator clone =
          (org.apache.xpath.axes.ChildTestIterator)
            super.
            cloneWithReset(
              );
        clone.
          resetProximityPositions(
            );
        return clone;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "40Lzui6i8jIO8X8DoLn4ZhIdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/sPyjuCfAGVS5sp2KAAA");
}
