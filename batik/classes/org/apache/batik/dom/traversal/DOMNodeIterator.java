package org.apache.batik.dom.traversal;
public class DOMNodeIterator implements org.w3c.dom.traversal.NodeIterator {
    protected static final short INITIAL = 0;
    protected static final short INVALID = 1;
    protected static final short FORWARD = 2;
    protected static final short BACKWARD = 3;
    protected org.apache.batik.dom.AbstractDocument document;
    protected org.w3c.dom.Node root;
    protected int whatToShow;
    protected org.w3c.dom.traversal.NodeFilter filter;
    protected boolean expandEntityReferences;
    protected short state;
    protected org.w3c.dom.Node referenceNode;
    public DOMNodeIterator(org.apache.batik.dom.AbstractDocument doc, org.w3c.dom.Node n,
                           int what,
                           org.w3c.dom.traversal.NodeFilter nf,
                           boolean exp) { super();
                                          document = doc;
                                          root = n;
                                          whatToShow = what;
                                          filter = nf;
                                          expandEntityReferences =
                                            exp;
                                          referenceNode = root; }
    public org.w3c.dom.Node getRoot() { return root; }
    public int getWhatToShow() { return whatToShow; }
    public org.w3c.dom.traversal.NodeFilter getFilter() { return filter;
    }
    public boolean getExpandEntityReferences() { return expandEntityReferences;
    }
    public org.w3c.dom.Node nextNode() { switch (state) { case INVALID:
                                                              throw document.
                                                                createDOMException(
                                                                  org.w3c.dom.DOMException.
                                                                    INVALID_STATE_ERR,
                                                                  "detached.iterator",
                                                                  null);
                                                          case BACKWARD:
                                                          case INITIAL:
                                                              state =
                                                                FORWARD;
                                                              return referenceNode;
                                                          case FORWARD:
                                         }
                                         for (;
                                              ;
                                              ) {
                                             unfilteredNextNode(
                                               );
                                             if (referenceNode ==
                                                   null) {
                                                 return null;
                                             }
                                             if ((whatToShow &
                                                    1 <<
                                                    referenceNode.
                                                    getNodeType(
                                                      ) -
                                                    1) !=
                                                   0) {
                                                 if (filter ==
                                                       null ||
                                                       filter.
                                                       acceptNode(
                                                         referenceNode) ==
                                                       org.w3c.dom.traversal.NodeFilter.
                                                         FILTER_ACCEPT) {
                                                     return referenceNode;
                                                 }
                                             }
                                         }
    }
    public org.w3c.dom.Node previousNode() {
        switch (state) {
            case INVALID:
                throw document.
                  createDOMException(
                    org.w3c.dom.DOMException.
                      INVALID_STATE_ERR,
                    "detached.iterator",
                    null);
            case FORWARD:
            case INITIAL:
                state =
                  BACKWARD;
                return referenceNode;
            case BACKWARD:
        }
        for (;
             ;
             ) {
            unfilteredPreviousNode(
              );
            if (referenceNode ==
                  null) {
                return referenceNode;
            }
            if ((whatToShow &
                   1 <<
                   referenceNode.
                   getNodeType(
                     ) -
                   1) !=
                  0) {
                if (filter ==
                      null ||
                      filter.
                      acceptNode(
                        referenceNode) ==
                      org.w3c.dom.traversal.NodeFilter.
                        FILTER_ACCEPT) {
                    return referenceNode;
                }
            }
        }
    }
    public void detach() { state = INVALID;
                           document.detachNodeIterator(
                                      this);
    }
    public void nodeToBeRemoved(org.w3c.dom.Node removedNode) {
        if (state ==
              INVALID) {
            return;
        }
        org.w3c.dom.Node node;
        for (node =
               referenceNode;
             node !=
               null &&
               node !=
               root;
             node =
               node.
                 getParentNode(
                   )) {
            if (node ==
                  removedNode) {
                break;
            }
        }
        if (node ==
              null ||
              node ==
              root) {
            return;
        }
        if (state ==
              BACKWARD) {
            if (node.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ENTITY_REFERENCE_NODE ||
                  expandEntityReferences) {
                org.w3c.dom.Node n =
                  node.
                  getFirstChild(
                    );
                if (n !=
                      null) {
                    referenceNode =
                      n;
                    return;
                }
            }
            org.w3c.dom.Node n =
              node.
              getNextSibling(
                );
            if (n !=
                  null) {
                referenceNode =
                  n;
                return;
            }
            n =
              node;
            while ((n =
                      n.
                        getParentNode(
                          )) !=
                     null &&
                     n !=
                     root) {
                org.w3c.dom.Node t =
                  n.
                  getNextSibling(
                    );
                if (t !=
                      null) {
                    referenceNode =
                      t;
                    return;
                }
            }
            referenceNode =
              null;
        }
        else {
            org.w3c.dom.Node n =
              node.
              getPreviousSibling(
                );
            if (n ==
                  null) {
                referenceNode =
                  node.
                    getParentNode(
                      );
                return;
            }
            if (n.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ENTITY_REFERENCE_NODE ||
                  expandEntityReferences) {
                org.w3c.dom.Node t;
                while ((t =
                          n.
                            getLastChild(
                              )) !=
                         null) {
                    n =
                      t;
                }
            }
            referenceNode =
              n;
        }
    }
    protected void unfilteredNextNode() {
        if (referenceNode ==
              null) {
            return;
        }
        if (referenceNode.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                ENTITY_REFERENCE_NODE ||
              expandEntityReferences) {
            org.w3c.dom.Node n =
              referenceNode.
              getFirstChild(
                );
            if (n !=
                  null) {
                referenceNode =
                  n;
                return;
            }
        }
        org.w3c.dom.Node n =
          referenceNode.
          getNextSibling(
            );
        if (n !=
              null) {
            referenceNode =
              n;
            return;
        }
        n =
          referenceNode;
        while ((n =
                  n.
                    getParentNode(
                      )) !=
                 null &&
                 n !=
                 root) {
            org.w3c.dom.Node t =
              n.
              getNextSibling(
                );
            if (t !=
                  null) {
                referenceNode =
                  t;
                return;
            }
        }
        referenceNode =
          null;
    }
    protected void unfilteredPreviousNode() {
        if (referenceNode ==
              null) {
            return;
        }
        if (referenceNode ==
              root) {
            referenceNode =
              null;
            return;
        }
        org.w3c.dom.Node n =
          referenceNode.
          getPreviousSibling(
            );
        if (n ==
              null) {
            referenceNode =
              referenceNode.
                getParentNode(
                  );
            return;
        }
        if (n.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                ENTITY_REFERENCE_NODE ||
              expandEntityReferences) {
            org.w3c.dom.Node t;
            while ((t =
                      n.
                        getLastChild(
                          )) !=
                     null) {
                n =
                  t;
            }
        }
        referenceNode =
          n;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "blP2x0XyB3HlwtKMhcPdkWOl+vabvaI8");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2V6Z8W+OqF0qMt8HrvyAWv7OU/uPtyn7z0XynbhyP6A2v36b5Zjgd98GwUeK" +
       "zKfA9dIBwZfeeYL//TZlbxTJn4G1AwiSx/s1x+S+/zbIPVxkFpu/Lx+Qe/md" +
       "J/fj25T9RZH8MK78BCBH3Hrj55jsj94G2VKs2Gb83AHZz73jZM9cuE3ZvUVy" +
       "Nq7c4wEjd7RNc8TtzF1vl1uxDL92wO1r7zy3h29T9p4ieSCu3BeEZmr5SXQT" +
       "fpfeBr93Hc7dtw74feud5/fUbcoKr3rm8bhy3jBjVV/ddPMn9S3jmO173y7b" +
       "4qzDtw/YfvudYXvmWKBR0rp6G8rF/t+Z5+LKJQ9M5cTHTMF0/dQ0iuz3H/N8" +
       "/m3wLPdAPwgQPb6vu/++E57ym87qT9+m7CNF0oorDyXefivcNNjjtXmSZfvt" +
       "sqwCwB87YPmxd54leZuyQZGgceWRY5bc9av0JFPsTphugXqcOgxdnOx87Ia/" +
       "Xuz/LqD/xquX7nn01ekfleeBj4703zus3LNIHOfkQa4T9+eBTVlY5RDcuz/W" +
       "FZS8xnHlydsf1C4izsP7AvsZdl9TiCvvvlnNuHIXSE9KTg+Oj56UjCvnyu+T" +
       "clJcuXgsB+zE/uakyCdA60CkuP2Z4DDSPrEhvj8Dtz1zIjQ+UKXS8z30ZvNy" +
       "VOXkEeMinC7/LnMY+ib7P8y8oH/9VZr91Bvtr+yPOOuOmudFK/cMKxf2p62P" +
       "wudnbtnaYVvnB8/9+IFv3PuBw1D/gT3gY7U+ge2pm58nJtwgLk8A5//40d/8" +
       "yN959TvlSbr/C/Sz4sXHNAAA");
}
