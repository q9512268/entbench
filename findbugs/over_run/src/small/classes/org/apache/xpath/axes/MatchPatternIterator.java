package org.apache.xpath.axes;
public class MatchPatternIterator extends org.apache.xpath.axes.LocPathIterator {
    static final long serialVersionUID = -5201153767396296474L;
    protected org.apache.xpath.patterns.StepPattern m_pattern;
    protected int m_superAxis = -1;
    protected org.apache.xml.dtm.DTMAxisTraverser m_traverser;
    private static final boolean DEBUG = false;
    MatchPatternIterator(org.apache.xpath.compiler.Compiler compiler, int opPos,
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
        m_pattern =
          org.apache.xpath.axes.WalkerFactory.
            loadSteps(
              this,
              compiler,
              firstStepPos,
              0);
        boolean fromRoot =
          false;
        boolean walkBack =
          false;
        boolean walkDescendants =
          false;
        boolean walkAttributes =
          false;
        if (0 !=
              (analysis &
                 (org.apache.xpath.axes.WalkerFactory.
                    BIT_ROOT |
                    org.apache.xpath.axes.WalkerFactory.
                      BIT_ANY_DESCENDANT_FROM_ROOT)))
            fromRoot =
              true;
        if (0 !=
              (analysis &
                 (org.apache.xpath.axes.WalkerFactory.
                    BIT_ANCESTOR |
                    org.apache.xpath.axes.WalkerFactory.
                      BIT_ANCESTOR_OR_SELF |
                    org.apache.xpath.axes.WalkerFactory.
                      BIT_PRECEDING |
                    org.apache.xpath.axes.WalkerFactory.
                      BIT_PRECEDING_SIBLING |
                    org.apache.xpath.axes.WalkerFactory.
                      BIT_FOLLOWING |
                    org.apache.xpath.axes.WalkerFactory.
                      BIT_FOLLOWING_SIBLING |
                    org.apache.xpath.axes.WalkerFactory.
                      BIT_PARENT |
                    org.apache.xpath.axes.WalkerFactory.
                      BIT_FILTER)))
            walkBack =
              true;
        if (0 !=
              (analysis &
                 (org.apache.xpath.axes.WalkerFactory.
                    BIT_DESCENDANT_OR_SELF |
                    org.apache.xpath.axes.WalkerFactory.
                      BIT_DESCENDANT |
                    org.apache.xpath.axes.WalkerFactory.
                      BIT_CHILD)))
            walkDescendants =
              true;
        if (0 !=
              (analysis &
                 (org.apache.xpath.axes.WalkerFactory.
                    BIT_ATTRIBUTE |
                    org.apache.xpath.axes.WalkerFactory.
                      BIT_NAMESPACE)))
            walkAttributes =
              true;
        if (false ||
              DEBUG) {
            java.lang.System.
              out.
              print(
                "analysis: " +
                java.lang.Integer.
                  toBinaryString(
                    analysis));
            java.lang.System.
              out.
              println(
                ", " +
                org.apache.xpath.axes.WalkerFactory.
                  getAnalysisString(
                    analysis));
        }
        if (fromRoot ||
              walkBack) {
            if (walkAttributes) {
                m_superAxis =
                  org.apache.xml.dtm.Axis.
                    ALL;
            }
            else {
                m_superAxis =
                  org.apache.xml.dtm.Axis.
                    DESCENDANTSFROMROOT;
            }
        }
        else
            if (walkDescendants) {
                if (walkAttributes) {
                    m_superAxis =
                      org.apache.xml.dtm.Axis.
                        ALLFROMNODE;
                }
                else {
                    m_superAxis =
                      org.apache.xml.dtm.Axis.
                        DESCENDANTORSELF;
                }
            }
            else {
                m_superAxis =
                  org.apache.xml.dtm.Axis.
                    ALL;
            }
        if (false ||
              DEBUG) {
            java.lang.System.
              out.
              println(
                "axis: " +
                org.apache.xml.dtm.Axis.
                  getNames(
                    m_superAxis));
        }
    }
    public void setRoot(int context, java.lang.Object environment) {
        super.
          setRoot(
            context,
            environment);
        m_traverser =
          m_cdtm.
            getAxisTraverser(
              m_superAxis);
    }
    public void detach() { if (m_allowDetach) { m_traverser = null;
                                                super.detach(); }
    }
    protected int getNextNode() { m_lastFetched = org.apache.xml.dtm.DTM.
                                                    NULL == m_lastFetched
                                                    ? m_traverser.
                                                    first(
                                                      m_context)
                                                    : m_traverser.
                                                    next(
                                                      m_context,
                                                      m_lastFetched);
                                  return m_lastFetched; }
    public int nextNode() { if (m_foundLast) return org.apache.xml.dtm.DTM.
                                                      NULL;
                            int next;
                            org.apache.xpath.VariableStack vars;
                            int savedStart;
                            if (-1 != m_stackFrame) { vars = m_execContext.
                                                               getVarStack(
                                                                 );
                                                      savedStart =
                                                        vars.
                                                          getStackFrame(
                                                            );
                                                      vars.setStackFrame(
                                                             m_stackFrame);
                            }
                            else {
                                vars =
                                  null;
                                savedStart =
                                  0;
                            }
                            try { if (DEBUG) java.lang.System.out.
                                               println(
                                                 "m_pattern" +
                                                 m_pattern.
                                                   toString(
                                                     ));
                                  do  { next = getNextNode();
                                        if (org.apache.xml.dtm.DTM.
                                              NULL != next) { if (org.apache.xml.dtm.DTMIterator.
                                                                    FILTER_ACCEPT ==
                                                                    acceptNode(
                                                                      next,
                                                                      m_execContext))
                                                                  break;
                                                              else
                                                                  continue;
                                        }
                                        else
                                            break;
                                  }while(next !=
                                           org.apache.xml.dtm.DTM.
                                             NULL); 
                                  if (org.apache.xml.dtm.DTM.
                                        NULL !=
                                        next) {
                                      if (DEBUG) {
                                          java.lang.System.
                                            out.
                                            println(
                                              "next: " +
                                              next);
                                          java.lang.System.
                                            out.
                                            println(
                                              "name: " +
                                              m_cdtm.
                                                getNodeName(
                                                  next));
                                      }
                                      incrementCurrentPos(
                                        );
                                      return next;
                                  }
                                  else {
                                      m_foundLast =
                                        true;
                                      return org.apache.xml.dtm.DTM.
                                               NULL;
                                  } }
                            finally { if (-1 !=
                                            m_stackFrame) {
                                          vars.
                                            setStackFrame(
                                              savedStart);
                                      } }
    }
    public short acceptNode(int n, org.apache.xpath.XPathContext xctxt) {
        try {
            xctxt.
              pushCurrentNode(
                n);
            xctxt.
              pushIteratorRoot(
                m_context);
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "traverser: " +
                    m_traverser);
                java.lang.System.
                  out.
                  print(
                    "node: " +
                    n);
                java.lang.System.
                  out.
                  println(
                    ", " +
                    m_cdtm.
                      getNodeName(
                        n));
                java.lang.System.
                  out.
                  println(
                    "pattern: " +
                    m_pattern.
                      toString(
                        ));
                m_pattern.
                  debugWhatToShow(
                    m_pattern.
                      getWhatToShow(
                        ));
            }
            org.apache.xpath.objects.XObject score =
              m_pattern.
              execute(
                xctxt);
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "score: " +
                    score);
                java.lang.System.
                  out.
                  println(
                    "skip: " +
                    (score ==
                       org.apache.xpath.patterns.NodeTest.
                         SCORE_NONE));
            }
            return score ==
              org.apache.xpath.patterns.NodeTest.
                SCORE_NONE
              ? org.apache.xml.dtm.DTMIterator.
                  FILTER_SKIP
              : org.apache.xml.dtm.DTMIterator.
                  FILTER_ACCEPT;
        }
        catch (javax.xml.transform.TransformerException se) {
            throw new java.lang.RuntimeException(
              se.
                getMessage(
                  ));
        }
        finally {
            xctxt.
              popCurrentNode(
                );
            xctxt.
              popIteratorRoot(
                );
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "uo6XK2mTW5OwPOONVZAiZk/XCXnpqIPZyCjx2yhZs5pANfqU2ilpRN3q81UZ" +
       "nQ6CPuMoQwlWGoE8WbeiWaqRur/RcCwQx+woHQFt9+vdIDMa0dAuO/IsrXdp" +
       "sedkyhAN+upMMm1+uBWSKbJ2V8uNIxDL+jqT5y1n5TNyW8ZwLOpQQ7ilzv1W" +
       "POa1+VBAamJb9LueNGRIc2i3Ey1KDXWGpcrcXtulBVctDbAN4RojfbCwBUcq" +
       "a8PmeiPom/5kSzZNOZgyptRJLbWzsdORUw2QqpRYCCqT3WoDS7ZzHxOjUYy1" +
       "9KHfotSMGE3qVUllY6mbICWhHus6mPdtm5wuEtKkN6ZUZtrt2pjrVwshp+t5" +
       "KyaE9hQjy1jqJm1c6wpTrRrMaNLrGs2aM0nLtE2IAcHy25RezNQ1uukIUbMb" +
       "UUmmMi2OaCcdchhQQsOcBmlPSpKQlToKTZRnq8lS02cEzMCq1GrAKcw2Y0p1" +
       "EbI8XzNNrjpoNXSgC9knF9iM4UA4DILEIlQblsoNyW/ESjzH4xLRmbKMpBhD" +
       "aaICcJgNYRmx2QZar8d8i6ktMm4TprrUp/pNo9OIkAQTDGsk4uugMYkrASlU" +
       "pHF/k/gEwunVWj1hurZfzQzBXWmV+mJYEhR4ScVcI6NQLkyQWnNQmQVkhd66" +
       "Vc9rekLPaTdsH0SGINItFGerzW04bdhIv6qVRkTW9r1KtBwNah698PhNd2v0" +
       "kAplDAlcZaZTVeqOG1VkvJ7y+ioT3GaGMtkSd3UXGSjSupINpFWlkwg1S1zP" +
       "jHGKxjySwdSK6QY+zac6pZNYCe2sB1JjubBGbClOtxPF92TYIGvcJuYsbd3o" +
       "EctqiU45Allps23WbmWcx2Mp5TgjpOWmYsC2pKQ0o7VRpnSwFGl0G62gtFZK" +
       "9bnuCmY2SI1J0OMA4gj9UQ3h0151kPohbRjz2OZr9foArtqehPY9c4Cb1ZFc" +
       "QZsYDKtTsY7WKvbEaJdM1Zs58WDscuyoOvbKa33kyoHdspG00RJmvIZXFZcQ" +
       "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" +
       "cf8WYg2P4BwrAAA=");
}
