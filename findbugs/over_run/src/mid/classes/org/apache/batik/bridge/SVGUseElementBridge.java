package org.apache.batik.bridge;
public class SVGUseElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge {
    protected org.apache.batik.bridge.SVGUseElementBridge.ReferencedElementMutationListener
      l;
    protected org.apache.batik.bridge.BridgeContext subCtx;
    public SVGUseElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_USE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGUseElementBridge(
                                                            );
    }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        if (!org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                e,
                ctx.
                  getUserAgent(
                    )))
            return null;
        org.apache.batik.gvt.CompositeGraphicsNode gn =
          buildCompositeGraphicsNode(
            ctx,
            e,
            null);
        associateSVGContext(
          ctx,
          e,
          gn);
        return gn;
    }
    public org.apache.batik.gvt.CompositeGraphicsNode buildCompositeGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                                 org.w3c.dom.Element e,
                                                                                 org.apache.batik.gvt.CompositeGraphicsNode gn) {
        org.apache.batik.dom.svg.SVGOMUseElement ue =
          (org.apache.batik.dom.svg.SVGOMUseElement)
            e;
        java.lang.String uri =
          ue.
          getHref(
            ).
          getAnimVal(
            );
        if (uri.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { "xlink:href" });
        }
        org.w3c.dom.Element refElement =
          ctx.
          getReferencedElement(
            e,
            uri);
        org.apache.batik.dom.svg.SVGOMDocument document;
        org.apache.batik.dom.svg.SVGOMDocument refDocument;
        document =
          (org.apache.batik.dom.svg.SVGOMDocument)
            e.
            getOwnerDocument(
              );
        refDocument =
          (org.apache.batik.dom.svg.SVGOMDocument)
            refElement.
            getOwnerDocument(
              );
        boolean isLocal =
          refDocument ==
          document;
        org.apache.batik.bridge.BridgeContext theCtx =
          ctx;
        subCtx =
          null;
        if (!isLocal) {
            subCtx =
              (org.apache.batik.bridge.BridgeContext)
                refDocument.
                getCSSEngine(
                  ).
                getCSSContext(
                  );
            theCtx =
              subCtx;
        }
        org.w3c.dom.Element localRefElement;
        localRefElement =
          (org.w3c.dom.Element)
            document.
            importNode(
              refElement,
              true,
              true);
        if (SVG_SYMBOL_TAG.
              equals(
                localRefElement.
                  getLocalName(
                    ))) {
            org.w3c.dom.Element svgElement =
              document.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_SVG_TAG);
            org.w3c.dom.NamedNodeMap attrs =
              localRefElement.
              getAttributes(
                );
            int len =
              attrs.
              getLength(
                );
            for (int i =
                   0;
                 i <
                   len;
                 i++) {
                org.w3c.dom.Attr attr =
                  (org.w3c.dom.Attr)
                    attrs.
                    item(
                      i);
                svgElement.
                  setAttributeNS(
                    attr.
                      getNamespaceURI(
                        ),
                    attr.
                      getName(
                        ),
                    attr.
                      getValue(
                        ));
            }
            for (org.w3c.dom.Node n =
                   localRefElement.
                   getFirstChild(
                     );
                 n !=
                   null;
                 n =
                   localRefElement.
                     getFirstChild(
                       )) {
                svgElement.
                  appendChild(
                    n);
            }
            localRefElement =
              svgElement;
        }
        if (SVG_SVG_TAG.
              equals(
                localRefElement.
                  getLocalName(
                    ))) {
            try {
                org.apache.batik.dom.svg.SVGOMAnimatedLength al =
                  (org.apache.batik.dom.svg.SVGOMAnimatedLength)
                    ue.
                    getWidth(
                      );
                if (al.
                      isSpecified(
                        )) {
                    localRefElement.
                      setAttributeNS(
                        null,
                        SVG_WIDTH_ATTRIBUTE,
                        al.
                          getAnimVal(
                            ).
                          getValueAsString(
                            ));
                }
                al =
                  (org.apache.batik.dom.svg.SVGOMAnimatedLength)
                    ue.
                    getHeight(
                      );
                if (al.
                      isSpecified(
                        )) {
                    localRefElement.
                      setAttributeNS(
                        null,
                        SVG_HEIGHT_ATTRIBUTE,
                        al.
                          getAnimVal(
                            ).
                          getValueAsString(
                            ));
                }
            }
            catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  ex);
            }
        }
        org.apache.batik.dom.svg.SVGOMUseShadowRoot root;
        root =
          new org.apache.batik.dom.svg.SVGOMUseShadowRoot(
            document,
            e,
            isLocal);
        root.
          appendChild(
            localRefElement);
        if (gn ==
              null) {
            gn =
              new org.apache.batik.gvt.CompositeGraphicsNode(
                );
            associateSVGContext(
              ctx,
              e,
              node);
        }
        else {
            int s =
              gn.
              size(
                );
            for (int i =
                   0;
                 i <
                   s;
                 i++)
                gn.
                  remove(
                    0);
        }
        org.w3c.dom.Node oldRoot =
          ue.
          getCSSFirstChild(
            );
        if (oldRoot !=
              null) {
            disposeTree(
              oldRoot);
        }
        ue.
          setUseShadowTree(
            root);
        org.w3c.dom.Element g =
          localRefElement;
        org.apache.batik.bridge.CSSUtilities.
          computeStyleAndURIs(
            refElement,
            localRefElement,
            uri);
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        org.apache.batik.gvt.GraphicsNode refNode =
          builder.
          build(
            ctx,
            g);
        gn.
          getChildren(
            ).
          add(
            refNode);
        gn.
          setTransform(
            computeTransform(
              (org.w3c.dom.svg.SVGTransformable)
                e,
              ctx));
        gn.
          setVisible(
            org.apache.batik.bridge.CSSUtilities.
              convertVisibility(
                e));
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
        if (l !=
              null) {
            org.apache.batik.dom.events.NodeEventTarget target =
              l.
                target;
            target.
              removeEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "DOMAttrModified",
                l,
                true);
            target.
              removeEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "DOMNodeInserted",
                l,
                true);
            target.
              removeEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "DOMNodeRemoved",
                l,
                true);
            target.
              removeEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "DOMCharacterDataModified",
                l,
                true);
            l =
              null;
        }
        if (isLocal &&
              ctx.
              isDynamic(
                )) {
            l =
              new org.apache.batik.bridge.SVGUseElementBridge.ReferencedElementMutationListener(
                );
            org.apache.batik.dom.events.NodeEventTarget target =
              (org.apache.batik.dom.events.NodeEventTarget)
                refElement;
            l.
              target =
              target;
            target.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "DOMAttrModified",
                l,
                true,
                null);
            theCtx.
              storeEventListenerNS(
                target,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "DOMAttrModified",
                l,
                true);
            target.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "DOMNodeInserted",
                l,
                true,
                null);
            theCtx.
              storeEventListenerNS(
                target,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "DOMNodeInserted",
                l,
                true);
            target.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "DOMNodeRemoved",
                l,
                true,
                null);
            theCtx.
              storeEventListenerNS(
                target,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "DOMNodeRemoved",
                l,
                true);
            target.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "DOMCharacterDataModified",
                l,
                true,
                null);
            theCtx.
              storeEventListenerNS(
                target,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "DOMCharacterDataModified",
                l,
                true);
        }
        return gn;
    }
    public void dispose() { if (l != null) {
                                org.apache.batik.dom.events.NodeEventTarget target =
                                  l.
                                    target;
                                target.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    "DOMAttrModified",
                                    l,
                                    true);
                                target.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    "DOMNodeInserted",
                                    l,
                                    true);
                                target.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    "DOMNodeRemoved",
                                    l,
                                    true);
                                target.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    "DOMCharacterDataModified",
                                    l,
                                    true);
                                l =
                                  null;
                            }
                            org.apache.batik.dom.svg.SVGOMUseElement ue =
                              (org.apache.batik.dom.svg.SVGOMUseElement)
                                e;
                            if (ue != null &&
                                  ue.
                                  getCSSFirstChild(
                                    ) !=
                                  null) {
                                disposeTree(
                                  ue.
                                    getCSSFirstChild(
                                      ));
                            }
                            super.dispose(
                                    );
                            subCtx = null;
    }
    protected java.awt.geom.AffineTransform computeTransform(org.w3c.dom.svg.SVGTransformable e,
                                                             org.apache.batik.bridge.BridgeContext ctx) {
        java.awt.geom.AffineTransform at =
          super.
          computeTransform(
            e,
            ctx);
        org.w3c.dom.svg.SVGUseElement ue =
          (org.w3c.dom.svg.SVGUseElement)
            e;
        try {
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ue.
                getX(
                  );
            float x =
              _x.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ue.
                getY(
                  );
            float y =
              _y.
              getCheckedValue(
                );
            java.awt.geom.AffineTransform xy =
              java.awt.geom.AffineTransform.
              getTranslateInstance(
                x,
                y);
            xy.
              preConcatenate(
                at);
            return xy;
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return null;
    }
    public boolean isComposite() { return false;
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.GraphicsNode node) {
        super.
          buildGraphicsNode(
            ctx,
            e,
            node);
        if (ctx.
              isInteractive(
                )) {
            org.apache.batik.dom.events.NodeEventTarget target =
              (org.apache.batik.dom.events.NodeEventTarget)
                e;
            org.w3c.dom.events.EventListener l =
              new org.apache.batik.bridge.SVGUseElementBridge.CursorMouseOverListener(
              ctx);
            target.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEOVER,
                l,
                false,
                null);
            ctx.
              storeEventListenerNS(
                target,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEOVER,
                l,
                false);
        }
    }
    public static class CursorMouseOverListener implements org.w3c.dom.events.EventListener {
        protected org.apache.batik.bridge.BridgeContext
          ctx;
        public CursorMouseOverListener(org.apache.batik.bridge.BridgeContext ctx) {
            super(
              );
            this.
              ctx =
              ctx;
        }
        public void handleEvent(org.w3c.dom.events.Event evt) {
            org.w3c.dom.Element currentTarget =
              (org.w3c.dom.Element)
                evt.
                getCurrentTarget(
                  );
            if (!org.apache.batik.bridge.CSSUtilities.
                  isAutoCursor(
                    currentTarget)) {
                java.awt.Cursor cursor;
                cursor =
                  org.apache.batik.bridge.CSSUtilities.
                    convertCursor(
                      currentTarget,
                      ctx);
                if (cursor !=
                      null) {
                    ctx.
                      getUserAgent(
                        ).
                      setSVGCursor(
                        cursor);
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "bIaYFgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "YnxrErkLTBmklospfXB6kN2WPLEroogoXbOCS0uz79Nm3Yl4a45qTXcwtDQU" +
           "zWq17gTtdLJaOFEqTU1tbGB0RnEeni1Tk+DqAo8MS45tCSoapUNHbsdpCkur" +
           "Uov3LZNS68OOWxJ5e+70ahO6su0Olr7Z3yKcbxI+QrV9pz/tVqdIk5ku5mMV" +
           "3sI8iZikG6GOaVO4h4vDeVyziJGMzaqjht2sIuWS0QvWZb1rJZSFqOPV1BQ3" +
           "8AxnF7UquzHpdokFKIKw2RD3e3V0WA4W1garYWu6mREdzRzpEYhefNkH6Rgu" +
           "qGN5BlPjOCjPKLClXglfVEZzQqvhFIN4FWqszb0qNV0qsNRwNlNW1wdlnM96" +
           "zSHWr4mpXQ+9amrH1bayrgG7OVw3S2SLYxY2SnFy5G5o3slKGLPJMJNpsFKb" +
           "8YgwrmtdnWUbHXHmpl2GiFxUhtHFvDuqVp2gWk/TlKgu2rJpRNl4GNeZLrFa" +
           "8HQ4FCrTSYhbtOSxaQNl6oGJ8pGckE1NXAxpGba8niQu001TbXur+rZVIxZ0" +
           "5o/wUb8sh6xTQVm4VO/q9ni4hvVmIlikPQwTuCGVZmNsixvNZawp/bjJtjFT" +
           "S8MmcBsjYziTQkeziu531hpZqelqwjdWfX82rQLP7C7oRapmhrYm/CWMNLt2" +
           "TSLHczji9NY0FocBL7kMQItwOECasMrISbcBq7VQEmKX7Ww6Nl5foeQklUTB" +
           "pLJWa7iO0bnSkbFmvbSqKC2uvKpqqGiKy43Z7bSB95h9d2VhzDxZeU4owC01" +
           "aejyuuwnpovIa2lGu7i+XJm06hNiR+3Ky9QVOuVxNKUo0yL6U16aZ012PEdg" +
           "JcxWg0HCqQxMTHW7rbVheKuw6KS/xcq+X9GM/jzcCHGdhdF2wrJesq204bDM" +
           "l1ErXflIhQxLmkEiYbLpt0qhHSxtb4S4wXhslOVGm5626mw1Vas1Q+3Y1bIz" +
           "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" +
           "IC5uILZ/eN/vv+m3n/tmUQ78Hzm92yByIQAA");
    }
    protected class ReferencedElementMutationListener implements org.w3c.dom.events.EventListener {
        protected org.apache.batik.dom.events.NodeEventTarget
          target;
        public void handleEvent(org.w3c.dom.events.Event evt) {
            buildCompositeGraphicsNode(
              ctx,
              e,
              (org.apache.batik.gvt.CompositeGraphicsNode)
                node);
        }
        public ReferencedElementMutationListener() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        try {
            java.lang.String ns =
              alav.
              getNamespaceURI(
                );
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ns ==
                  null &&
                  (ln.
                     equals(
                       SVG_X_ATTRIBUTE) ||
                     ln.
                     equals(
                       SVG_Y_ATTRIBUTE) ||
                     ln.
                     equals(
                       SVG_TRANSFORM_ATTRIBUTE))) {
                node.
                  setTransform(
                    computeTransform(
                      (org.w3c.dom.svg.SVGTransformable)
                        e,
                      ctx));
                handleGeometryChanged(
                  );
            }
            else
                if (ns ==
                      null &&
                      (ln.
                         equals(
                           SVG_WIDTH_ATTRIBUTE) ||
                         ln.
                         equals(
                           SVG_HEIGHT_ATTRIBUTE)) ||
                      ns.
                      equals(
                        XLINK_NAMESPACE_URI) &&
                      ln.
                      equals(
                        XLINK_HREF_ATTRIBUTE)) {
                    buildCompositeGraphicsNode(
                      ctx,
                      e,
                      (org.apache.batik.gvt.CompositeGraphicsNode)
                        node);
                }
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dH+J+Zb6xVen5Ee/3frZ/R0z1ZV3u4LK");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("wzh0ZX/drSRarFKevyu1Y1qXx+/9zmNfeuQ9xyuqx/YMnzrDGd7edecLXUMv" +
       "TMorWLtfffKXPvAPX/2D8sbA/wVuOz2tWy4AAA==");
}
