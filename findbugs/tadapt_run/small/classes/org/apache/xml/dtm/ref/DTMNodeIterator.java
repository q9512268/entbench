package org.apache.xml.dtm.ref;
public class DTMNodeIterator implements org.w3c.dom.traversal.NodeIterator {
    private org.apache.xml.dtm.DTMIterator dtm_iter;
    private boolean valid = true;
    public DTMNodeIterator(org.apache.xml.dtm.DTMIterator dtmIterator) { super(
                                                                           );
                                                                         try {
                                                                             dtm_iter =
                                                                               (org.apache.xml.dtm.DTMIterator)
                                                                                 dtmIterator.
                                                                                 clone(
                                                                                   );
                                                                         }
                                                                         catch (java.lang.CloneNotSupportedException cnse) {
                                                                             throw new org.apache.xml.utils.WrappedRuntimeException(
                                                                               cnse);
                                                                         }
    }
    public org.apache.xml.dtm.DTMIterator getDTMIterator() {
        return dtm_iter;
    }
    public void detach() { valid = false;
    }
    public boolean getExpandEntityReferences() {
        return false;
    }
    public org.w3c.dom.traversal.NodeFilter getFilter() {
        throw new org.apache.xml.dtm.DTMDOMException(
          org.w3c.dom.DOMException.
            NOT_SUPPORTED_ERR);
    }
    public org.w3c.dom.Node getRoot() { int handle =
                                          dtm_iter.
                                          getRoot(
                                            );
                                        return dtm_iter.
                                          getDTM(
                                            handle).
                                          getNode(
                                            handle);
    }
    public int getWhatToShow() { return dtm_iter.
                                   getWhatToShow(
                                     ); }
    public org.w3c.dom.Node nextNode() throws org.w3c.dom.DOMException {
        if (!valid)
            throw new org.apache.xml.dtm.DTMDOMException(
              org.w3c.dom.DOMException.
                INVALID_STATE_ERR);
        int handle =
          dtm_iter.
          nextNode(
            );
        if (handle ==
              org.apache.xml.dtm.DTM.
                NULL)
            return null;
        return dtm_iter.
          getDTM(
            handle).
          getNode(
            handle);
    }
    public org.w3c.dom.Node previousNode() {
        if (!valid)
            throw new org.apache.xml.dtm.DTMDOMException(
              org.w3c.dom.DOMException.
                INVALID_STATE_ERR);
        int handle =
          dtm_iter.
          previousNode(
            );
        if (handle ==
              org.apache.xml.dtm.DTM.
                NULL)
            return null;
        return dtm_iter.
          getDTM(
            handle).
          getNode(
            handle);
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
      ("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");
}
