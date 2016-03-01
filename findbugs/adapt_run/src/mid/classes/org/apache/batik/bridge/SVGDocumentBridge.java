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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "rA8DoZc585qGizD0R8wW/Q/OdEYK3C8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "YztTPOfG9P3nlH0wJ+9LSvebejIEUsdg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("bHVhTBZWfGzAP/+DjplPtltk/NxpiI+BxO0hchcP8V+dU/arOflwUroXQKR9" +
       "VXaG+9E5ge8jt4rvUZCme3zTi8f3qXPKPp2TX0tKLwL4Do3w0F8fO9/HjxXw" +
       "67eggPwdjKLc2CvAuBgFXC4YLuc/5znpF1yfPUcVn8vJv09KD6pg+ZHoZ68d" +
       "uWO8n7kFvMWLJy2Qnt3jffvF4L1yPNPs8BYyF6xfOAf0F3Pyh2AqUlLL0U5i" +
       "Ltj9ExNQnJRuW/nWCcP/o1vVw5tBevdeD+++GD1c2r9Ctbfhx09egIMZwktA" +
       "nE7376vmP4tGvnqOhr6eky8npUcWxWyGswyaJNHhzWLRRs7xpWO1fOUi1PLe" +
       "vVree6FqyX9+rWD483Mg/7ecvHAScm4QIDzoUXJjyN+6VchvAulX9pB/5UcE" +
       "+bvnQP5fOfl2UnrFKchj3fVXN0b8l7eKGAXp43vEH/8RIf7bcxD/XU7+GkT5" +
       "I8TYAixv1ESPcDmRDw38DOy/uYjQ96k97E/9SFz+qeumLTWOD3TPtDz9AJtM" +
       "usXTkfNfuuvmSrp0b06uJKWX7pR0uvZp1Vy67VZVw4L0W3vV/NaPRDW1m67A" +
       "Uc9y87eIaGul5/HNUtJEL16kKvTw8nN09EhOHjgypMOWjloBZuWZZw3p0oMX" +
       "YUi/u9fW7164/2gFtGvnwH59Tl6dlF65g80mCz3aYQdTy40xP36rmF8B0u/v" +
       "Mf/+xWA+CalyTlkBoJyU7tSsOPBj/Qy0N9wCtGLPmu9Rv7iH9sWLh/amc8re" +
       "khMkKT0M1sCclemO4FkJ7zOW41iunuw3sGeWQrcbji8nxwpo3aoC8k3AV/YK" +
       "+MrFK2BwThmTk95uk1MoAIAv8t56jK9/C/geyjPzTdxX9/i+evH4pueU5Qvi" +
       "S2NguwBfp+Mfvbn3iuI1NHmdHJg6iINjXQX7H9PRq/gx7skt4H5lnvlGkL62" +
       "x/21i8etn1OWv+916W1gRwNwT8CuRvf4SPbi/GX5QxU8eloFqGGA2e00V6EG" +
       "+VZDVxOkr+/V8PWLUcNxuL5kFXjjc3SR5sQDuoiv08WZUObf6ojnJzLf2EP9" +
       "xsWP+E+dU/aOnGyT0h1gxDG+8GHrGNnbL8KWv7lH9s2LR/aec8p+Lic/u7Pl" +
       "vuMrsnNy/E6ifNetRuJ8/F7Yo3zh4lF+8JyyX8rJLySlqwClaOnrwI+SqaUV" +
       "32qdjMa/eKsYXwPSt/YYv3XxGH/1nLKP5eT5pPTACYyEbpmL5AzIX75VkPnZ" +
       "0p/tQf7ZxYP89Dll/yYnn9idq/V8L5lYW/0MvH/9w8DLgL6u+64s/0jm4es+" +
       "ad19hqn+xvP33/XQ88LXik+rjj6VvJsu3WWkjnPym4YTz3cEkW4UwbR09+4L" +
       "h6CA8ztJ6aGbnAaCYKMcnQde+syO/7PAhM/ygzVT8f8k3+8lpXuO+UBTu4eT" +
       "LH+QlK4AlvzxD4PDaevEC+S7Tzuy3R7n4ZPWUGxYf+A+46jKyS+v8uuC4pPi" +
       "w6P9dPdR8TPqp5+nhm//XvNjuy+/VEfebvNW7qJLd+4+Qisaza8Hnrhpa4dt" +
       "3UE8+f37fvPu1x1eZdy3E/jYMk/I9uobf2bVdYOk+DBq+zsP/bs3ffz5bxZv" +
       "0P8/09kmWOs9AAA=");
}
