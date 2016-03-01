package org.apache.batik.bridge;
public class SVGSwitchElementBridge extends org.apache.batik.bridge.SVGGElementBridge {
    protected org.w3c.dom.Element selectedChild;
    public SVGSwitchElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_SWITCH_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGSwitchElementBridge(
                                                            ); }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.GraphicsNode refNode =
          null;
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        selectedChild =
          null;
        for (org.w3c.dom.Node n =
               e.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                org.w3c.dom.Element ref =
                  (org.w3c.dom.Element)
                    n;
                if (n instanceof org.w3c.dom.svg.SVGTests &&
                      org.apache.batik.bridge.SVGUtilities.
                      matchUserAgent(
                        ref,
                        ctx.
                          getUserAgent(
                            ))) {
                    selectedChild =
                      ref;
                    refNode =
                      builder.
                        build(
                          ctx,
                          ref);
                    break;
                }
            }
        }
        if (refNode ==
              null) {
            return null;
        }
        org.apache.batik.gvt.CompositeGraphicsNode group =
          (org.apache.batik.gvt.CompositeGraphicsNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (group ==
              null) {
            return null;
        }
        group.
          add(
            refNode);
        return group;
    }
    public boolean isComposite() { return false; }
    public void dispose() { selectedChild = null;
                            super.dispose(); }
    protected void handleElementAdded(org.apache.batik.gvt.CompositeGraphicsNode gn,
                                      org.w3c.dom.Node parent,
                                      org.w3c.dom.Element childElt) {
        for (org.w3c.dom.Node n =
               childElt.
               getPreviousSibling(
                 );
             n !=
               null;
             n =
               n.
                 getPreviousSibling(
                   )) {
            if (n ==
                  childElt) {
                return;
            }
        }
        if (childElt instanceof org.w3c.dom.svg.SVGTests &&
              org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                childElt,
                ctx.
                  getUserAgent(
                    ))) {
            if (selectedChild !=
                  null) {
                gn.
                  remove(
                    0);
                disposeTree(
                  selectedChild);
            }
            selectedChild =
              childElt;
            org.apache.batik.bridge.GVTBuilder builder =
              ctx.
              getGVTBuilder(
                );
            org.apache.batik.gvt.GraphicsNode refNode =
              builder.
              build(
                ctx,
                childElt);
            if (refNode !=
                  null) {
                gn.
                  add(
                    refNode);
            }
        }
    }
    protected void handleChildElementRemoved(org.w3c.dom.Element e) {
        org.apache.batik.gvt.CompositeGraphicsNode gn =
          (org.apache.batik.gvt.CompositeGraphicsNode)
            node;
        if (selectedChild ==
              e) {
            gn.
              remove(
                0);
            disposeTree(
              selectedChild);
            selectedChild =
              null;
            org.apache.batik.gvt.GraphicsNode refNode =
              null;
            org.apache.batik.bridge.GVTBuilder builder =
              ctx.
              getGVTBuilder(
                );
            for (org.w3c.dom.Node n =
                   e.
                   getNextSibling(
                     );
                 n !=
                   null;
                 n =
                   n.
                     getNextSibling(
                       )) {
                if (n.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    org.w3c.dom.Element ref =
                      (org.w3c.dom.Element)
                        n;
                    if (n instanceof org.w3c.dom.svg.SVGTests &&
                          org.apache.batik.bridge.SVGUtilities.
                          matchUserAgent(
                            ref,
                            ctx.
                              getUserAgent(
                                ))) {
                        refNode =
                          builder.
                            build(
                              ctx,
                              ref);
                        selectedChild =
                          ref;
                        break;
                    }
                }
            }
            if (refNode !=
                  null) {
                gn.
                  add(
                    refNode);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "pFqGHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "N8huBaw/e8cfvuojT30rO6/7XzXO+PH3KAAA");
}
