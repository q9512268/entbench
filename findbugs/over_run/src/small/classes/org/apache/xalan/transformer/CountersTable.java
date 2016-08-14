package org.apache.xalan.transformer;
public class CountersTable extends java.util.Hashtable {
    static final long serialVersionUID = 2159100770924179875L;
    public CountersTable() { super(); }
    java.util.Vector getCounters(org.apache.xalan.templates.ElemNumber numberElem) {
        java.util.Vector counters =
          (java.util.Vector)
            this.
            get(
              numberElem);
        return null ==
          counters
          ? putElemNumber(
              numberElem)
          : counters;
    }
    java.util.Vector putElemNumber(org.apache.xalan.templates.ElemNumber numberElem) {
        java.util.Vector counters =
          new java.util.Vector(
          );
        this.
          put(
            numberElem,
            counters);
        return counters;
    }
    private transient org.apache.xpath.NodeSetDTM m_newFound;
    void appendBtoFList(org.apache.xpath.NodeSetDTM flist,
                        org.apache.xpath.NodeSetDTM blist) {
        int n =
          blist.
          size(
            );
        for (int i =
               n -
               1;
             i >=
               0;
             i--) {
            flist.
              addElement(
                blist.
                  item(
                    i));
        }
    }
    transient int m_countersMade = 0;
    public int countNode(org.apache.xpath.XPathContext support,
                         org.apache.xalan.templates.ElemNumber numberElem,
                         int node) throws javax.xml.transform.TransformerException {
        int count =
          0;
        java.util.Vector counters =
          getCounters(
            numberElem);
        int nCounters =
          counters.
          size(
            );
        int target =
          numberElem.
          getTargetNode(
            support,
            node);
        if (org.apache.xml.dtm.DTM.
              NULL !=
              target) {
            for (int i =
                   0;
                 i <
                   nCounters;
                 i++) {
                org.apache.xalan.transformer.Counter counter =
                  (org.apache.xalan.transformer.Counter)
                    counters.
                    elementAt(
                      i);
                count =
                  counter.
                    getPreviouslyCounted(
                      support,
                      target);
                if (count >
                      0)
                    return count;
            }
            count =
              0;
            if (m_newFound ==
                  null)
                m_newFound =
                  new org.apache.xpath.NodeSetDTM(
                    support.
                      getDTMManager(
                        ));
            for (;
                 org.apache.xml.dtm.DTM.
                   NULL !=
                   target;
                 target =
                   numberElem.
                     getPreviousNode(
                       support,
                       target)) {
                if (0 !=
                      count) {
                    for (int i =
                           0;
                         i <
                           nCounters;
                         i++) {
                        org.apache.xalan.transformer.Counter counter =
                          (org.apache.xalan.transformer.Counter)
                            counters.
                            elementAt(
                              i);
                        int cacheLen =
                          counter.
                            m_countNodes.
                          size(
                            );
                        if (cacheLen >
                              0 &&
                              counter.
                                m_countNodes.
                              elementAt(
                                cacheLen -
                                  1) ==
                              target) {
                            count +=
                              cacheLen +
                                counter.
                                  m_countNodesStartCount;
                            if (cacheLen >
                                  0)
                                appendBtoFList(
                                  counter.
                                    m_countNodes,
                                  m_newFound);
                            m_newFound.
                              removeAllElements(
                                );
                            return count;
                        }
                    }
                }
                m_newFound.
                  addElement(
                    target);
                count++;
            }
            org.apache.xalan.transformer.Counter counter =
              new org.apache.xalan.transformer.Counter(
              numberElem,
              new org.apache.xpath.NodeSetDTM(
                support.
                  getDTMManager(
                    )));
            m_countersMade++;
            appendBtoFList(
              counter.
                m_countNodes,
              m_newFound);
            m_newFound.
              removeAllElements(
                );
            counters.
              addElement(
                counter);
        }
        return count;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JYEruOYNgzPWOIfafwD8UYRe9R8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
