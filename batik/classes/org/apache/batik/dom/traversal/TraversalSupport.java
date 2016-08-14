package org.apache.batik.dom.traversal;
public class TraversalSupport {
    protected java.util.List iterators;
    public TraversalSupport() { super(); }
    public static org.w3c.dom.traversal.TreeWalker createTreeWalker(org.apache.batik.dom.AbstractDocument doc,
                                                                    org.w3c.dom.Node root,
                                                                    int whatToShow,
                                                                    org.w3c.dom.traversal.NodeFilter filter,
                                                                    boolean entityReferenceExpansion) {
        if (root ==
              null) {
            throw doc.
              createDOMException(
                org.w3c.dom.DOMException.
                  NOT_SUPPORTED_ERR,
                "null.root",
                null);
        }
        return new org.apache.batik.dom.traversal.DOMTreeWalker(
          root,
          whatToShow,
          filter,
          entityReferenceExpansion);
    }
    public org.w3c.dom.traversal.NodeIterator createNodeIterator(org.apache.batik.dom.AbstractDocument doc,
                                                                 org.w3c.dom.Node root,
                                                                 int whatToShow,
                                                                 org.w3c.dom.traversal.NodeFilter filter,
                                                                 boolean entityReferenceExpansion)
          throws org.w3c.dom.DOMException {
        if (root ==
              null) {
            throw doc.
              createDOMException(
                org.w3c.dom.DOMException.
                  NOT_SUPPORTED_ERR,
                "null.root",
                null);
        }
        org.w3c.dom.traversal.NodeIterator result =
          new org.apache.batik.dom.traversal.DOMNodeIterator(
          doc,
          root,
          whatToShow,
          filter,
          entityReferenceExpansion);
        if (iterators ==
              null) {
            iterators =
              new java.util.LinkedList(
                );
        }
        iterators.
          add(
            result);
        return result;
    }
    public void nodeToBeRemoved(org.w3c.dom.Node removedNode) {
        if (iterators !=
              null) {
            java.util.Iterator it =
              iterators.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                ((org.apache.batik.dom.traversal.DOMNodeIterator)
                   it.
                   next(
                     )).
                  nodeToBeRemoved(
                    removedNode);
            }
        }
    }
    public void detachNodeIterator(org.w3c.dom.traversal.NodeIterator it) {
        iterators.
          remove(
            it);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "maZb+UTaTXGuaelkAtt3RReb9/4NBsjjgjkeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+uXv/NnX/rg6Sfq/g1NSzz4oAAA=");
}
