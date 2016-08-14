package org.apache.batik.bridge;
public class SVGDocumentBridge implements org.apache.batik.bridge.DocumentBridge, org.apache.batik.bridge.BridgeUpdateHandler, org.apache.batik.dom.svg.SVGContext {
    protected org.w3c.dom.Document document;
    protected org.apache.batik.gvt.RootGraphicsNode node;
    protected org.apache.batik.bridge.BridgeContext ctx;
    public SVGDocumentBridge() { super(); }
    public java.lang.String getNamespaceURI() { return null; }
    public java.lang.String getLocalName() { return null; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGDocumentBridge(
                                                            ); }
    public org.apache.batik.gvt.RootGraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                    org.w3c.dom.Document doc) {
        org.apache.batik.gvt.RootGraphicsNode gn =
          new org.apache.batik.gvt.RootGraphicsNode(
          );
        this.
          document =
          doc;
        this.
          node =
          gn;
        this.
          ctx =
          ctx;
        ((org.apache.batik.dom.svg.SVGOMDocument)
           doc).
          setSVGContext(
            this);
        return gn;
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Document doc,
                                  org.apache.batik.gvt.RootGraphicsNode node) {
        if (ctx.
              isDynamic(
                )) {
            ctx.
              bind(
                doc,
                node);
        }
    }
    public void handleDOMAttrModifiedEvent(org.w3c.dom.events.MutationEvent evt) {
        
    }
    public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
        if (evt.
              getTarget(
                ) instanceof org.w3c.dom.Element) {
            org.w3c.dom.Element childElt =
              (org.w3c.dom.Element)
                evt.
                getTarget(
                  );
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
            node.
              add(
                childNode);
        }
    }
    public void handleDOMNodeRemovedEvent(org.w3c.dom.events.MutationEvent evt) {
        
    }
    public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
        
    }
    public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
        
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        
    }
    public void handleOtherAnimationChanged(java.lang.String type) {
        
    }
    public void dispose() { ((org.apache.batik.dom.svg.SVGOMDocument)
                               document).
                              setSVGContext(
                                null);
                            ctx.unbind(document);
    }
    public float getPixelUnitToMillimeter() {
        return ctx.
          getUserAgent(
            ).
          getPixelUnitToMillimeter(
            );
    }
    public float getPixelToMM() { return getPixelUnitToMillimeter(
                                           );
    }
    public java.awt.geom.Rectangle2D getBBox() {
        return null;
    }
    public java.awt.geom.AffineTransform getScreenTransform() {
        return ctx.
          getUserAgent(
            ).
          getTransform(
            );
    }
    public void setScreenTransform(java.awt.geom.AffineTransform at) {
        ctx.
          getUserAgent(
            ).
          setTransform(
            at);
    }
    public java.awt.geom.AffineTransform getCTM() {
        return null;
    }
    public java.awt.geom.AffineTransform getGlobalTransform() {
        return null;
    }
    public float getViewportWidth() { return 0.0F;
    }
    public float getViewportHeight() { return 0.0F;
    }
    public float getFontSize() { return 0;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XXWXr4Vb356curR65GiiH8jn9QmQhvuJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "AAA=");
}
