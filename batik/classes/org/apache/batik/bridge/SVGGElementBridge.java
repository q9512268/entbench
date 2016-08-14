package org.apache.batik.bridge;
public class SVGGElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge {
    public SVGGElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_G_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGGElementBridge(
                                                            ); }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.CompositeGraphicsNode gn =
          (org.apache.batik.gvt.CompositeGraphicsNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (gn ==
              null)
            return null;
        associateSVGContext(
          ctx,
          e,
          gn);
        java.awt.RenderingHints hints =
          null;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertColorRendering(
              e,
              hints);
        if (hints !=
              null)
            gn.
              setRenderingHints(
                hints);
        java.awt.geom.Rectangle2D r =
          org.apache.batik.bridge.CSSUtilities.
          convertEnableBackground(
            e);
        if (r !=
              null)
            gn.
              setBackgroundEnable(
                r);
        return gn;
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.CompositeGraphicsNode(
          );
    }
    public boolean isComposite() { return true; }
    public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
        if (evt.
              getTarget(
                ) instanceof org.w3c.dom.Element) {
            handleElementAdded(
              (org.apache.batik.gvt.CompositeGraphicsNode)
                node,
              e,
              (org.w3c.dom.Element)
                evt.
                getTarget(
                  ));
        }
        else {
            super.
              handleDOMNodeInsertedEvent(
                evt);
        }
    }
    protected void handleElementAdded(org.apache.batik.gvt.CompositeGraphicsNode gn,
                                      org.w3c.dom.Node parent,
                                      org.w3c.dom.Element childElt) {
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        org.apache.batik.gvt.GraphicsNode childNode =
          builder.
          build(
            ctx,
            childElt);
        if (childNode ==
              null) {
            return;
        }
        int idx =
          -1;
        for (org.w3c.dom.Node ps =
               childElt.
               getPreviousSibling(
                 );
             ps !=
               null;
             ps =
               ps.
                 getPreviousSibling(
                   )) {
            if (ps.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE)
                continue;
            org.w3c.dom.Element pse =
              (org.w3c.dom.Element)
                ps;
            org.apache.batik.gvt.GraphicsNode psgn =
              ctx.
              getGraphicsNode(
                pse);
            while (psgn !=
                     null &&
                     psgn.
                     getParent(
                       ) !=
                     gn) {
                psgn =
                  psgn.
                    getParent(
                      );
            }
            if (psgn ==
                  null)
                continue;
            idx =
              gn.
                indexOf(
                  psgn);
            if (idx ==
                  -1)
                continue;
            break;
        }
        idx++;
        gn.
          add(
            idx,
            childNode);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jhwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hr7yJwAA");
}
