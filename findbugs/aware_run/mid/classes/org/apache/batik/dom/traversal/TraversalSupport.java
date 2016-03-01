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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "a4l4n2k6J43KK7jnTZPv21M8qv8HR+cTepodAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bs73v/auf/q9P//an1S3Qf8Xedbosx4oAAA=");
}
