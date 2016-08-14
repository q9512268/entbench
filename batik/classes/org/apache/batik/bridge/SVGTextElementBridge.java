package org.apache.batik.bridge;
public class SVGTextElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge implements org.apache.batik.dom.svg.SVGTextContent {
    protected static final java.lang.Integer ZERO = new java.lang.Integer(
      0);
    public static final java.text.AttributedCharacterIterator.Attribute TEXT_COMPOUND_DELIMITER =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_DELIMITER;
    public static final java.text.AttributedCharacterIterator.Attribute
      TEXT_COMPOUND_ID =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_ID;
    public static final java.text.AttributedCharacterIterator.Attribute
      PAINT_INFO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PAINT_INFO;
    public static final java.text.AttributedCharacterIterator.Attribute
      ALT_GLYPH_HANDLER =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ALT_GLYPH_HANDLER;
    public static final java.text.AttributedCharacterIterator.Attribute
      TEXTPATH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXTPATH;
    public static final java.text.AttributedCharacterIterator.Attribute
      ANCHOR_TYPE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ANCHOR_TYPE;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONT_FAMILIES =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONT_FAMILIES;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONTS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONTS;
    public static final java.text.AttributedCharacterIterator.Attribute
      BASELINE_SHIFT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        BASELINE_SHIFT;
    protected java.text.AttributedString laidoutText;
    protected java.util.WeakHashMap elemTPI = new java.util.WeakHashMap(
      );
    protected boolean usingComplexSVGFont = false;
    public SVGTextElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_TEXT_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGTextElementBridge(
                                                            );
    }
    protected org.apache.batik.gvt.TextNode getTextNode() {
        return (org.apache.batik.gvt.TextNode)
                 node;
    }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.TextNode node =
          (org.apache.batik.gvt.TextNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (node ==
              null)
            return null;
        associateSVGContext(
          ctx,
          e,
          node);
        org.w3c.dom.Node child =
          getFirstChild(
            e);
        while (child !=
                 null) {
            if (child.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                addContextToChild(
                  ctx,
                  (org.w3c.dom.Element)
                    child);
            }
            child =
              getNextSibling(
                child);
        }
        if (ctx.
              getTextPainter(
                ) !=
              null)
            node.
              setTextPainter(
                ctx.
                  getTextPainter(
                    ));
        java.awt.RenderingHints hints =
          null;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertColorRendering(
              e,
              hints);
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertTextRendering(
              e,
              hints);
        if (hints !=
              null)
            node.
              setRenderingHints(
                hints);
        node.
          setLocation(
            getLocation(
              ctx,
              e));
        return node;
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.TextNode(
          );
    }
    protected java.awt.geom.Point2D getLocation(org.apache.batik.bridge.BridgeContext ctx,
                                                org.w3c.dom.Element e) {
        try {
            org.apache.batik.dom.svg.SVGOMTextPositioningElement te =
              (org.apache.batik.dom.svg.SVGOMTextPositioningElement)
                e;
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _x =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getX(
                  );
            _x.
              check(
                );
            org.w3c.dom.svg.SVGLengthList xs =
              _x.
              getAnimVal(
                );
            float x =
              0;
            if (xs.
                  getNumberOfItems(
                    ) >
                  0) {
                x =
                  xs.
                    getItem(
                      0).
                    getValue(
                      );
            }
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _y =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getY(
                  );
            _y.
              check(
                );
            org.w3c.dom.svg.SVGLengthList ys =
              _y.
              getAnimVal(
                );
            float y =
              0;
            if (ys.
                  getNumberOfItems(
                    ) >
                  0) {
                y =
                  ys.
                    getItem(
                      0).
                    getValue(
                      );
            }
            return new java.awt.geom.Point2D.Float(
              x,
              y);
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    protected boolean isTextElement(org.w3c.dom.Element e) {
        if (!SVG_NAMESPACE_URI.
              equals(
                e.
                  getNamespaceURI(
                    )))
            return false;
        java.lang.String nodeName =
          e.
          getLocalName(
            );
        return nodeName.
          equals(
            SVG_TEXT_TAG) ||
          nodeName.
          equals(
            SVG_TSPAN_TAG) ||
          nodeName.
          equals(
            SVG_ALT_GLYPH_TAG) ||
          nodeName.
          equals(
            SVG_A_TAG) ||
          nodeName.
          equals(
            SVG_TEXT_PATH_TAG) ||
          nodeName.
          equals(
            SVG_TREF_TAG);
    }
    protected boolean isTextChild(org.w3c.dom.Element e) {
        if (!SVG_NAMESPACE_URI.
              equals(
                e.
                  getNamespaceURI(
                    )))
            return false;
        java.lang.String nodeName =
          e.
          getLocalName(
            );
        return nodeName.
          equals(
            SVG_TSPAN_TAG) ||
          nodeName.
          equals(
            SVG_ALT_GLYPH_TAG) ||
          nodeName.
          equals(
            SVG_A_TAG) ||
          nodeName.
          equals(
            SVG_TEXT_PATH_TAG) ||
          nodeName.
          equals(
            SVG_TREF_TAG);
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.GraphicsNode node) {
        e.
          normalize(
            );
        computeLaidoutText(
          ctx,
          e,
          node);
        node.
          setComposite(
            org.apache.batik.bridge.CSSUtilities.
              convertOpacity(
                e));
        node.
          setFilter(
            org.apache.batik.bridge.CSSUtilities.
              convertFilter(
                e,
                node,
                ctx));
        node.
          setMask(
            org.apache.batik.bridge.CSSUtilities.
              convertMask(
                e,
                node,
                ctx));
        node.
          setClip(
            org.apache.batik.bridge.CSSUtilities.
              convertClipPath(
                e,
                node,
                ctx));
        node.
          setPointerEventType(
            org.apache.batik.bridge.CSSUtilities.
              convertPointerEvents(
                e));
        initializeDynamicSupport(
          ctx,
          e,
          node);
        if (!ctx.
              isDynamic(
                )) {
            elemTPI.
              clear(
                );
        }
    }
    public boolean isComposite() { return false;
    }
    protected org.w3c.dom.Node getFirstChild(org.w3c.dom.Node n) {
        return n.
          getFirstChild(
            );
    }
    protected org.w3c.dom.Node getNextSibling(org.w3c.dom.Node n) {
        return n.
          getNextSibling(
            );
    }
    protected org.w3c.dom.Node getParentNode(org.w3c.dom.Node n) {
        return n.
          getParentNode(
            );
    }
    protected org.apache.batik.bridge.SVGTextElementBridge.DOMChildNodeRemovedEventListener
      childNodeRemovedEventListener;
    protected class DOMChildNodeRemovedEventListener implements org.w3c.dom.events.EventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            handleDOMChildNodeRemovedEvent(
              (org.w3c.dom.events.MutationEvent)
                evt);
        }
        public DOMChildNodeRemovedEventListener() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "1Q8ETYDlFrWaCbjGdSXdXywlUV5U5iJHZLoKj9DBpCJkGaqPNmNyUeFbWR3v" +
           "YXEqBHOrJiYh1p+vh3xzUvcGRKhwWc9XA1ISkGZZC0hT1UeG7iR9OhAri6Qq" +
           "TSoTSohKmWCVstG8NZfq82kVjlpDccwsq3VlbA14oY+tGV+KfaZebiNdbrtA" +
           "+4q97iE1u6X7WWfTao6nWCOV8PakJ2m1aaWPd12MRgyHS8s1YIloPFTm/Qzu" +
           "dqas252sSx1My/ppUsWJzRan+UGdmpmD1tiJmnCrLsHruk+VudUi4seJi7Nl" +
           "utyWppVo3gtigarTKYkPrJZRpbJuuaWOkKq6SYmVFpSQ+QRVzBqe1KjJYmG3" +
           "SmiLbVKVVFqz2wrNp+xaXElku6/0sVmyTeRxjUNxGG6ZcC2NqzS7cJW5acN+" +
           "lQzdsdRbr1tquUPGLNZFgVuVBw2apIZBx4oJScLhWhhXDaOPoI2q1R7P5oN5" +
           "ZzouxaSx3LqpSSyb9VbNb2kzokJI9mzeaRDrXmC2Vg247nVnJitKVE0hkRiB" +
           "tx1jE5HYaiHZsUb7aUhM0F7N0WsualjMsqkTSIjIUyWK5oMNg1ZXE0bnV1FL" +
           "g8OOX6X19Uw3RDuUlI08MDYlGcN6dK2tmRFFO6Y9XktVgL1ky2TUJ5ZbUqCi" +
           "XrkjGXq0nJVKrJA0MS1y5kIk9YeBHtHtMZ4JnhoI4XC9TfxGCXGRzMVXAsXT" +
           "Q2fe5Qm0nnZak3Z1nuiYtVg7UopOTGvLb7QOXqtRfdqeVDd83Uzh0B3VN0h/" +
           "WmJ9tlU2RjCGpvpa7XLyJFK1yVxolrQlY7qN9mys1DKeTkUyqzY4pY0n1gAd" +
           "aSOatMWxqSR2Muqv5uhUWARY6g2EBS/U9IbomFstCmql9YycOG4cuaI/qpZX" +
           "ktUdhysSgVvNOkwx8NYMZ2IgNBAlxubxAq70ucibKxupJboJXDI2htGyppSS" +
           "aXLEOIlTZ5nWEqH0dntWmgVER7GXqgFH7syB422vmi0Go3I/7fTXaCteMEqK" +
           "6P16aYxG9VmF5rJlaJfLPLYJQtxn5Q5ZqTuK0pd79dY0oVep1WkLLWJkSmQm" +
           "b2vShuswtVI96dBTXB3aZd7Qsg14bGoiL3ZpDu/b+CiLTKKdsDDtMBSHd7QB" +
           "r6ipOdMIeraZeg0F6cUayaGV9qweI12x4ielaidx5GiNJ1w3gbnJoONs0Vgc" +
           "16rarE2HpCBKSFUsWwkhqVLT8hkxo6PKVtaUoVaiA3Zcqchw3EXsVYuaTVXD" +
           "75sNxO6Qmm7qwygDDgbXqJZDTyeZ3OaXJbEpdhDTrSDlxhTn61U7rtipUWGM" +
           "xLbCfnNZW41gUF0oa3xQmZiSQxFlZtFZ0A0ynNKmI6SNHkti1tRIF7wmTDYg" +
           "gQdUuKASH6e2gWozRIvtGOggW674oQEeKYSHtgl+oZP8YmPWZlOu1WekrVU1" +
           "ymXGqi9NflFfamiYBKxCddspKFbi+azjrDOhVhl16Vk6WmyUek0bZ2yjDqqI" +
           "kBUiT57Z66VGNJqc567CclRKrNhDZ4pA6Q5aXlcyOK0NDU6IZjGNdPB2X2pt" +
           "W8qkXO0iwjgaaiBlGh2ZQZv8epH01DQlB4SoLBdaglo9rtxf1TbjNUVsm9s2" +
           "0mBqMTKejOCpBYMqC26W9ErNRPggDZUeyoVNFB6M4FFcquM2wqU2yWN1m8RX" +
           "Lu8NA4pc8z4dtRRO41bVaEAuXTGYO2W+MnUaeuSZXtnDh9PhZr6eh1itxHTR" +
           "hlOztmGcuQFj6RhqR32tPWDStlemSMQ0scze+KhfkqjOHOlQQ2LAwD3X4sVa" +
           "0tqWbQr2+82B4VYDv0sPyD6COQFSxZoNsVfBx82kJqmM3WgR20oicF4m+bHa" +
           "qcBbgqSXsOO3TTRlyVK8lbDBaBtW9XoSwFt2K6ulrMWskDlbNifggvCWt+RX" +
           "h7e/stvbvcVF9fBFA7i05RvdV3BrSW99ILhEX/RDLwYXdV1LD7t2Rf/i7pfo" +
           "2h3rbJw5uC0/lvdyN4i6r3nOvp73ZaP9E+3Z/C738O3eQBT3uE+959nntNGn" +
           "K3s3WkciuLrfeDF0/MAQeur2F9ZB8fblqJ/x5ff860PTt5rvfAUd20dPMXma" +
           "5O8Onv9q943qr+9BZw+7Gze9FzqJdO1kT+NSqMdJ6E5PdDYePtT/5VzdTwFR" +
           "lzf0v7x11/TWNi2caOc6p9pyZ05a7MHbWaxAXr9ET2+bD0EMvcqUXc3WC6QC" +
           "kD3miAK4XK89Szvy0PDl7tUn2mfApV6u438gyZteyXsE4D8P3vS6cveKTf3c" +
           "c5cvPPAc/zdFo/zwNdhFBroA0rx9vCt1bH7eD3XDKhRzcdej8ouf98XQA7dh" +
           "DDj2blJI8N4d/Adj6Mpp+Bg6V/weh/u1GLp0BAdI7SbHQT4SQ2cBSD59xr9F" +
           "P2vXnEvPHIurGzmiMNR9L2eoQ5TjffQ8FovXxQdxk+xeGF9XP/9cb/iuFxuf" +
           "3vXxVVveFh50gYHu3L1SOIy9x29L7YDWeerJH9/zhYtvOEgS9+wYPoqIY7w9" +
           "eutGOeH4cdHa3v7RA3/w5t9+7ltFe+1/AZXlhRHHHwAA");
    }
    protected org.apache.batik.bridge.SVGTextElementBridge.DOMSubtreeModifiedEventListener
      subtreeModifiedEventListener;
    protected class DOMSubtreeModifiedEventListener implements org.w3c.dom.events.EventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            handleDOMSubtreeModifiedEvent(
              (org.w3c.dom.events.MutationEvent)
                evt);
        }
        public DOMSubtreeModifiedEventListener() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "7v+DN/32c98uKmv/C4GkKY3BHwAA");
    }
    protected void initializeDynamicSupport(org.apache.batik.bridge.BridgeContext ctx,
                                            org.w3c.dom.Element e,
                                            org.apache.batik.gvt.GraphicsNode node) {
        super.
          initializeDynamicSupport(
            ctx,
            e,
            node);
        if (ctx.
              isDynamic(
                )) {
            addTextEventListeners(
              ctx,
              (org.apache.batik.dom.events.NodeEventTarget)
                e);
        }
    }
    protected void addTextEventListeners(org.apache.batik.bridge.BridgeContext ctx,
                                         org.apache.batik.dom.events.NodeEventTarget e) {
        if (childNodeRemovedEventListener ==
              null) {
            childNodeRemovedEventListener =
              new org.apache.batik.bridge.SVGTextElementBridge.DOMChildNodeRemovedEventListener(
                );
        }
        if (subtreeModifiedEventListener ==
              null) {
            subtreeModifiedEventListener =
              new org.apache.batik.bridge.SVGTextElementBridge.DOMSubtreeModifiedEventListener(
                );
        }
        e.
          addEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true,
            null);
        ctx.
          storeEventListenerNS(
            e,
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        e.
          addEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false,
            null);
        ctx.
          storeEventListenerNS(
            e,
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
    }
    protected void removeTextEventListeners(org.apache.batik.bridge.BridgeContext ctx,
                                            org.apache.batik.dom.events.NodeEventTarget e) {
        e.
          removeEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        e.
          removeEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
    }
    public void dispose() { removeTextEventListeners(
                              ctx,
                              (org.apache.batik.dom.events.NodeEventTarget)
                                e);
                            super.dispose(
                                    ); }
    protected void addContextToChild(org.apache.batik.bridge.BridgeContext ctx,
                                     org.w3c.dom.Element e) {
        if (SVG_NAMESPACE_URI.
              equals(
                e.
                  getNamespaceURI(
                    ))) {
            if (e.
                  getLocalName(
                    ).
                  equals(
                    SVG_TSPAN_TAG)) {
                ((org.apache.batik.dom.svg.SVGOMElement)
                   e).
                  setSVGContext(
                    new org.apache.batik.bridge.SVGTextElementBridge.TspanBridge(
                      ctx,
                      this,
                      e));
            }
            else
                if (e.
                      getLocalName(
                        ).
                      equals(
                        SVG_TEXT_PATH_TAG)) {
                    ((org.apache.batik.dom.svg.SVGOMElement)
                       e).
                      setSVGContext(
                        new org.apache.batik.bridge.SVGTextElementBridge.TextPathBridge(
                          ctx,
                          this,
                          e));
                }
                else
                    if (e.
                          getLocalName(
                            ).
                          equals(
                            SVG_TREF_TAG)) {
                        ((org.apache.batik.dom.svg.SVGOMElement)
                           e).
                          setSVGContext(
                            new org.apache.batik.bridge.SVGTextElementBridge.TRefBridge(
                              ctx,
                              this,
                              e));
                    }
        }
        org.w3c.dom.Node child =
          getFirstChild(
            e);
        while (child !=
                 null) {
            if (child.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                addContextToChild(
                  ctx,
                  (org.w3c.dom.Element)
                    child);
            }
            child =
              getNextSibling(
                child);
        }
    }
    protected void removeContextFromChild(org.apache.batik.bridge.BridgeContext ctx,
                                          org.w3c.dom.Element e) {
        if (SVG_NAMESPACE_URI.
              equals(
                e.
                  getNamespaceURI(
                    ))) {
            if (e.
                  getLocalName(
                    ).
                  equals(
                    SVG_TSPAN_TAG)) {
                ((org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildBridgeUpdateHandler)
                   ((org.apache.batik.dom.svg.SVGOMElement)
                      e).
                   getSVGContext(
                     )).
                  dispose(
                    );
            }
            else
                if (e.
                      getLocalName(
                        ).
                      equals(
                        SVG_TEXT_PATH_TAG)) {
                    ((org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildBridgeUpdateHandler)
                       ((org.apache.batik.dom.svg.SVGOMElement)
                          e).
                       getSVGContext(
                         )).
                      dispose(
                        );
                }
                else
                    if (e.
                          getLocalName(
                            ).
                          equals(
                            SVG_TREF_TAG)) {
                        ((org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildBridgeUpdateHandler)
                           ((org.apache.batik.dom.svg.SVGOMElement)
                              e).
                           getSVGContext(
                             )).
                          dispose(
                            );
                    }
        }
        org.w3c.dom.Node child =
          getFirstChild(
            e);
        while (child !=
                 null) {
            if (child.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                removeContextFromChild(
                  ctx,
                  (org.w3c.dom.Element)
                    child);
            }
            child =
              getNextSibling(
                child);
        }
    }
    public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
        org.w3c.dom.Node childNode =
          (org.w3c.dom.Node)
            evt.
            getTarget(
              );
        switch (childNode.
                  getNodeType(
                    )) {
            case org.w3c.dom.Node.
                   TEXT_NODE:
            case org.w3c.dom.Node.
                   CDATA_SECTION_NODE:
                laidoutText =
                  null;
                break;
            case org.w3c.dom.Node.
                   ELEMENT_NODE:
                {
                    org.w3c.dom.Element childElement =
                      (org.w3c.dom.Element)
                        childNode;
                    if (isTextChild(
                          childElement)) {
                        addContextToChild(
                          ctx,
                          childElement);
                        laidoutText =
                          null;
                    }
                    break;
                }
        }
        if (laidoutText ==
              null) {
            computeLaidoutText(
              ctx,
              e,
              getTextNode(
                ));
        }
    }
    public void handleDOMChildNodeRemovedEvent(org.w3c.dom.events.MutationEvent evt) {
        org.w3c.dom.Node childNode =
          (org.w3c.dom.Node)
            evt.
            getTarget(
              );
        switch (childNode.
                  getNodeType(
                    )) {
            case org.w3c.dom.Node.
                   TEXT_NODE:
            case org.w3c.dom.Node.
                   CDATA_SECTION_NODE:
                if (isParentDisplayed(
                      childNode)) {
                    laidoutText =
                      null;
                }
                break;
            case org.w3c.dom.Node.
                   ELEMENT_NODE:
                {
                    org.w3c.dom.Element childElt =
                      (org.w3c.dom.Element)
                        childNode;
                    if (isTextChild(
                          childElt)) {
                        laidoutText =
                          null;
                        removeContextFromChild(
                          ctx,
                          childElt);
                    }
                    break;
                }
            default:
        }
    }
    public void handleDOMSubtreeModifiedEvent(org.w3c.dom.events.MutationEvent evt) {
        if (laidoutText ==
              null) {
            computeLaidoutText(
              ctx,
              e,
              getTextNode(
                ));
        }
    }
    public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
        org.w3c.dom.Node childNode =
          (org.w3c.dom.Node)
            evt.
            getTarget(
              );
        if (isParentDisplayed(
              childNode)) {
            laidoutText =
              null;
        }
    }
    protected boolean isParentDisplayed(org.w3c.dom.Node childNode) {
        org.w3c.dom.Node parentNode =
          getParentNode(
            childNode);
        return isTextElement(
                 (org.w3c.dom.Element)
                   parentNode);
    }
    protected void computeLaidoutText(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Element e,
                                      org.apache.batik.gvt.GraphicsNode node) {
        org.apache.batik.gvt.TextNode tn =
          (org.apache.batik.gvt.TextNode)
            node;
        elemTPI.
          clear(
            );
        java.text.AttributedString as =
          buildAttributedString(
            ctx,
            e);
        if (as ==
              null) {
            tn.
              setAttributedCharacterIterator(
                null);
            return;
        }
        addGlyphPositionAttributes(
          as,
          e,
          ctx);
        if (ctx.
              isDynamic(
                )) {
            laidoutText =
              new java.text.AttributedString(
                as.
                  getIterator(
                    ));
        }
        tn.
          setAttributedCharacterIterator(
            as.
              getIterator(
                ));
        org.apache.batik.gvt.text.TextPaintInfo pi =
          new org.apache.batik.gvt.text.TextPaintInfo(
          );
        setBaseTextPaintInfo(
          pi,
          e,
          node,
          ctx);
        setDecorationTextPaintInfo(
          pi,
          e);
        addPaintAttributes(
          as,
          e,
          tn,
          pi,
          ctx);
        if (usingComplexSVGFont) {
            tn.
              setAttributedCharacterIterator(
                as.
                  getIterator(
                    ));
        }
        if (ctx.
              isDynamic(
                )) {
            checkBBoxChange(
              );
        }
    }
    private boolean hasNewACI;
    private org.w3c.dom.Element cssProceedElement;
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null) {
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ln.
                  equals(
                    SVG_X_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_Y_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_DX_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_DY_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_ROTATE_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_TEXT_LENGTH_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_LENGTH_ADJUST_ATTRIBUTE)) {
                char c =
                  ln.
                  charAt(
                    0);
                if (c ==
                      'x' ||
                      c ==
                      'y') {
                    getTextNode(
                      ).
                      setLocation(
                        getLocation(
                          ctx,
                          e));
                }
                computeLaidoutText(
                  ctx,
                  e,
                  getTextNode(
                    ));
                return;
            }
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
        hasNewACI =
          false;
        int[] properties =
          evt.
          getProperties(
            );
        for (int i =
               0;
             i <
               properties.
                 length;
             ++i) {
            switch (properties[i]) {
                case org.apache.batik.css.engine.SVGCSSEngine.
                       BASELINE_SHIFT_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       DIRECTION_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       DISPLAY_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_FAMILY_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_SIZE_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_STRETCH_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_STYLE_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_WEIGHT_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       GLYPH_ORIENTATION_HORIZONTAL_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       GLYPH_ORIENTATION_VERTICAL_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       KERNING_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       LETTER_SPACING_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       TEXT_ANCHOR_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       UNICODE_BIDI_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       WORD_SPACING_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       WRITING_MODE_INDEX:
                    {
                        if (!hasNewACI) {
                            hasNewACI =
                              true;
                            computeLaidoutText(
                              ctx,
                              e,
                              getTextNode(
                                ));
                        }
                        break;
                    }
            }
        }
        cssProceedElement =
          evt.
            getElement(
              );
        super.
          handleCSSEngineEvent(
            evt);
        cssProceedElement =
          null;
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_OPACITY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_OPACITY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_WIDTH_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_LINECAP_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_LINEJOIN_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_MITERLIMIT_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_DASHARRAY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_DASHOFFSET_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   TEXT_DECORATION_INDEX:
                rebuildACI(
                  );
                break;
            case org.apache.batik.css.engine.SVGCSSEngine.
                   VISIBILITY_INDEX:
                rebuildACI(
                  );
                super.
                  handleCSSPropertyChanged(
                    property);
                break;
            case org.apache.batik.css.engine.SVGCSSEngine.
                   TEXT_RENDERING_INDEX:
                {
                    java.awt.RenderingHints hints =
                      node.
                      getRenderingHints(
                        );
                    hints =
                      org.apache.batik.bridge.CSSUtilities.
                        convertTextRendering(
                          e,
                          hints);
                    if (hints !=
                          null) {
                        node.
                          setRenderingHints(
                            hints);
                    }
                    break;
                }
            case org.apache.batik.css.engine.SVGCSSEngine.
                   COLOR_RENDERING_INDEX:
                {
                    java.awt.RenderingHints hints =
                      node.
                      getRenderingHints(
                        );
                    hints =
                      org.apache.batik.bridge.CSSUtilities.
                        convertColorRendering(
                          e,
                          hints);
                    if (hints !=
                          null) {
                        node.
                          setRenderingHints(
                            hints);
                    }
                    break;
                }
            default:
                super.
                  handleCSSPropertyChanged(
                    property);
        }
    }
    protected void rebuildACI() { if (hasNewACI)
                                      return;
                                  org.apache.batik.gvt.TextNode textNode =
                                    getTextNode(
                                      );
                                  if (textNode.
                                        getAttributedCharacterIterator(
                                          ) ==
                                        null)
                                      return;
                                  org.apache.batik.gvt.text.TextPaintInfo pi;
                                  org.apache.batik.gvt.text.TextPaintInfo oldPI;
                                  if (cssProceedElement ==
                                        e) {
                                      pi =
                                        new org.apache.batik.gvt.text.TextPaintInfo(
                                          );
                                      setBaseTextPaintInfo(
                                        pi,
                                        e,
                                        node,
                                        ctx);
                                      setDecorationTextPaintInfo(
                                        pi,
                                        e);
                                      oldPI =
                                        (org.apache.batik.gvt.text.TextPaintInfo)
                                          elemTPI.
                                          get(
                                            e);
                                  }
                                  else {
                                      org.apache.batik.gvt.text.TextPaintInfo parentPI;
                                      parentPI =
                                        getParentTextPaintInfo(
                                          cssProceedElement);
                                      pi =
                                        getTextPaintInfo(
                                          cssProceedElement,
                                          textNode,
                                          parentPI,
                                          ctx);
                                      oldPI =
                                        (org.apache.batik.gvt.text.TextPaintInfo)
                                          elemTPI.
                                          get(
                                            cssProceedElement);
                                  }
                                  if (oldPI ==
                                        null)
                                      return;
                                  textNode.
                                    swapTextPaintInfo(
                                      pi,
                                      oldPI);
                                  if (usingComplexSVGFont)
                                      textNode.
                                        setAttributedCharacterIterator(
                                          textNode.
                                            getAttributedCharacterIterator(
                                              ));
    }
    int getElementStartIndex(org.w3c.dom.Element element) {
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            elemTPI.
            get(
              element);
        if (tpi ==
              null)
            return -1;
        return tpi.
                 startChar;
    }
    int getElementEndIndex(org.w3c.dom.Element element) {
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            elemTPI.
            get(
              element);
        if (tpi ==
              null)
            return -1;
        return tpi.
                 endChar;
    }
    protected java.text.AttributedString buildAttributedString(org.apache.batik.bridge.BridgeContext ctx,
                                                               org.w3c.dom.Element element) {
        org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer asb =
          new org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer(
          );
        fillAttributedStringBuffer(
          ctx,
          element,
          true,
          null,
          null,
          null,
          asb);
        return asb.
          toAttributedString(
            );
    }
    protected int endLimit;
    protected void fillAttributedStringBuffer(org.apache.batik.bridge.BridgeContext ctx,
                                              org.w3c.dom.Element element,
                                              boolean top,
                                              org.apache.batik.gvt.text.TextPath textPath,
                                              java.lang.Integer bidiLevel,
                                              java.util.Map initialAttributes,
                                              org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer asb) {
        if (!org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                element,
                ctx.
                  getUserAgent(
                    )) ||
              !org.apache.batik.bridge.CSSUtilities.
              convertDisplay(
                element)) {
            return;
        }
        java.lang.String s =
          org.apache.batik.dom.util.XMLSupport.
          getXMLSpace(
            element);
        boolean preserve =
          s.
          equals(
            SVG_PRESERVE_VALUE);
        boolean prevEndsWithSpace;
        org.w3c.dom.Element nodeElement =
          element;
        int elementStartChar =
          asb.
          length(
            );
        if (top) {
            endLimit =
              0;
        }
        if (preserve) {
            endLimit =
              asb.
                length(
                  );
        }
        java.util.Map map =
          initialAttributes ==
          null
          ? new java.util.HashMap(
          )
          : new java.util.HashMap(
          initialAttributes);
        initialAttributes =
          getAttributeMap(
            ctx,
            element,
            textPath,
            bidiLevel,
            map);
        java.lang.Object o =
          map.
          get(
            java.awt.font.TextAttribute.
              BIDI_EMBEDDING);
        java.lang.Integer subBidiLevel =
          bidiLevel;
        if (o !=
              null) {
            subBidiLevel =
              (java.lang.Integer)
                o;
        }
        for (org.w3c.dom.Node n =
               getFirstChild(
                 element);
             n !=
               null;
             n =
               getNextSibling(
                 n)) {
            if (preserve) {
                prevEndsWithSpace =
                  false;
            }
            else {
                if (asb.
                      length(
                        ) ==
                      0) {
                    prevEndsWithSpace =
                      true;
                }
                else {
                    prevEndsWithSpace =
                      asb.
                        getLastChar(
                          ) ==
                        ' ';
                }
            }
            switch (n.
                      getNodeType(
                        )) {
                case org.w3c.dom.Node.
                       ELEMENT_NODE:
                    if (!SVG_NAMESPACE_URI.
                          equals(
                            n.
                              getNamespaceURI(
                                )))
                        break;
                    nodeElement =
                      (org.w3c.dom.Element)
                        n;
                    java.lang.String ln =
                      n.
                      getLocalName(
                        );
                    if (ln.
                          equals(
                            SVG_TSPAN_TAG) ||
                          ln.
                          equals(
                            SVG_ALT_GLYPH_TAG)) {
                        int before =
                          asb.
                            count;
                        fillAttributedStringBuffer(
                          ctx,
                          nodeElement,
                          false,
                          textPath,
                          subBidiLevel,
                          initialAttributes,
                          asb);
                        if (asb.
                              count !=
                              before) {
                            initialAttributes =
                              null;
                        }
                    }
                    else
                        if (ln.
                              equals(
                                SVG_TEXT_PATH_TAG)) {
                            org.apache.batik.bridge.SVGTextPathElementBridge textPathBridge =
                              (org.apache.batik.bridge.SVGTextPathElementBridge)
                                ctx.
                                getBridge(
                                  nodeElement);
                            org.apache.batik.gvt.text.TextPath newTextPath =
                              textPathBridge.
                              createTextPath(
                                ctx,
                                nodeElement);
                            if (newTextPath !=
                                  null) {
                                int before =
                                  asb.
                                    count;
                                fillAttributedStringBuffer(
                                  ctx,
                                  nodeElement,
                                  false,
                                  newTextPath,
                                  subBidiLevel,
                                  initialAttributes,
                                  asb);
                                if (asb.
                                      count !=
                                      before) {
                                    initialAttributes =
                                      null;
                                }
                            }
                        }
                        else
                            if (ln.
                                  equals(
                                    SVG_TREF_TAG)) {
                                java.lang.String uriStr =
                                  org.apache.batik.dom.util.XLinkSupport.
                                  getXLinkHref(
                                    (org.w3c.dom.Element)
                                      n);
                                org.w3c.dom.Element ref =
                                  ctx.
                                  getReferencedElement(
                                    (org.w3c.dom.Element)
                                      n,
                                    uriStr);
                                s =
                                  org.apache.batik.bridge.TextUtilities.
                                    getElementContent(
                                      ref);
                                s =
                                  normalizeString(
                                    s,
                                    preserve,
                                    prevEndsWithSpace);
                                if (s.
                                      length(
                                        ) !=
                                      0) {
                                    int trefStart =
                                      asb.
                                      length(
                                        );
                                    java.util.Map m =
                                      initialAttributes ==
                                      null
                                      ? new java.util.HashMap(
                                      )
                                      : new java.util.HashMap(
                                      initialAttributes);
                                    getAttributeMap(
                                      ctx,
                                      nodeElement,
                                      textPath,
                                      bidiLevel,
                                      m);
                                    asb.
                                      append(
                                        s,
                                        m);
                                    int trefEnd =
                                      asb.
                                      length(
                                        ) -
                                      1;
                                    org.apache.batik.gvt.text.TextPaintInfo tpi;
                                    tpi =
                                      (org.apache.batik.gvt.text.TextPaintInfo)
                                        elemTPI.
                                        get(
                                          nodeElement);
                                    tpi.
                                      startChar =
                                      trefStart;
                                    tpi.
                                      endChar =
                                      trefEnd;
                                    initialAttributes =
                                      null;
                                }
                            }
                            else
                                if (ln.
                                      equals(
                                        SVG_A_TAG)) {
                                    org.apache.batik.dom.events.NodeEventTarget target =
                                      (org.apache.batik.dom.events.NodeEventTarget)
                                        nodeElement;
                                    org.apache.batik.bridge.UserAgent ua =
                                      ctx.
                                      getUserAgent(
                                        );
                                    org.apache.batik.bridge.SVGAElementBridge.CursorHolder ch;
                                    ch =
                                      new org.apache.batik.bridge.SVGAElementBridge.CursorHolder(
                                        org.apache.batik.bridge.CursorManager.
                                          DEFAULT_CURSOR);
                                    org.w3c.dom.events.EventListener l;
                                    l =
                                      new org.apache.batik.bridge.SVGAElementBridge.AnchorListener(
                                        ua,
                                        ch);
                                    target.
                                      addEventListenerNS(
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        SVG_EVENT_CLICK,
                                        l,
                                        false,
                                        null);
                                    ctx.
                                      storeEventListenerNS(
                                        target,
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        SVG_EVENT_CLICK,
                                        l,
                                        false);
                                    int before =
                                      asb.
                                        count;
                                    fillAttributedStringBuffer(
                                      ctx,
                                      nodeElement,
                                      false,
                                      textPath,
                                      subBidiLevel,
                                      initialAttributes,
                                      asb);
                                    if (asb.
                                          count !=
                                          before) {
                                        initialAttributes =
                                          null;
                                    }
                                }
                    break;
                case org.w3c.dom.Node.
                       TEXT_NODE:
                case org.w3c.dom.Node.
                       CDATA_SECTION_NODE:
                    s =
                      n.
                        getNodeValue(
                          );
                    s =
                      normalizeString(
                        s,
                        preserve,
                        prevEndsWithSpace);
                    if (s.
                          length(
                            ) !=
                          0) {
                        asb.
                          append(
                            s,
                            map);
                        if (preserve) {
                            endLimit =
                              asb.
                                length(
                                  );
                        }
                        initialAttributes =
                          null;
                    }
            }
        }
        if (top) {
            boolean strippedSome =
              false;
            while (endLimit <
                     asb.
                     length(
                       ) &&
                     asb.
                     getLastChar(
                       ) ==
                     ' ') {
                asb.
                  stripLast(
                    );
                strippedSome =
                  true;
            }
            if (strippedSome) {
                java.util.Iterator iter =
                  elemTPI.
                  values(
                    ).
                  iterator(
                    );
                while (iter.
                         hasNext(
                           )) {
                    org.apache.batik.gvt.text.TextPaintInfo tpi =
                      (org.apache.batik.gvt.text.TextPaintInfo)
                        iter.
                        next(
                          );
                    if (tpi.
                          endChar >=
                          asb.
                          length(
                            )) {
                        tpi.
                          endChar =
                          asb.
                            length(
                              ) -
                            1;
                        if (tpi.
                              startChar >
                              tpi.
                                endChar)
                            tpi.
                              startChar =
                              tpi.
                                endChar;
                    }
                }
            }
        }
        int elementEndChar =
          asb.
          length(
            ) -
          1;
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            elemTPI.
            get(
              element);
        tpi.
          startChar =
          elementStartChar;
        tpi.
          endChar =
          elementEndChar;
    }
    protected java.lang.String normalizeString(java.lang.String s,
                                               boolean preserve,
                                               boolean stripfirst) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          s.
            length(
              ));
        if (preserve) {
            for (int i =
                   0;
                 i <
                   s.
                   length(
                     );
                 i++) {
                char c =
                  s.
                  charAt(
                    i);
                switch (c) {
                    case 10:
                    case 13:
                    case '\t':
                        sb.
                          append(
                            ' ');
                        break;
                    default:
                        sb.
                          append(
                            c);
                }
            }
            return sb.
              toString(
                );
        }
        int idx =
          0;
        if (stripfirst) {
            loop: while (idx <
                           s.
                           length(
                             )) {
                switch (s.
                          charAt(
                            idx)) {
                    default:
                        break loop;
                    case 10:
                    case 13:
                    case ' ':
                    case '\t':
                        idx++;
                }
            }
        }
        boolean space =
          false;
        for (int i =
               idx;
             i <
               s.
               length(
                 );
             i++) {
            char c =
              s.
              charAt(
                i);
            switch (c) {
                case 10:
                case 13:
                    break;
                case ' ':
                case '\t':
                    if (!space) {
                        sb.
                          append(
                            ' ');
                        space =
                          true;
                    }
                    break;
                default:
                    sb.
                      append(
                        c);
                    space =
                      false;
            }
        }
        return sb.
          toString(
            );
    }
    protected static class AttributedStringBuffer {
        protected java.util.List strings;
        protected java.util.List attributes;
        protected int count;
        protected int length;
        public AttributedStringBuffer() {
            super(
              );
            strings =
              new java.util.ArrayList(
                );
            attributes =
              new java.util.ArrayList(
                );
            count =
              0;
            length =
              0;
        }
        public boolean isEmpty() { return count ==
                                     0; }
        public int length() { return length;
        }
        public void append(java.lang.String s,
                           java.util.Map m) {
            if (s.
                  length(
                    ) ==
                  0)
                return;
            strings.
              add(
                s);
            attributes.
              add(
                m);
            count++;
            length +=
              s.
                length(
                  );
        }
        public int getLastChar() { if (count ==
                                         0) {
                                       return -1;
                                   }
                                   java.lang.String s =
                                     (java.lang.String)
                                       strings.
                                       get(
                                         count -
                                           1);
                                   return s.
                                     charAt(
                                       s.
                                         length(
                                           ) -
                                         1);
        }
        public void stripFirst() { java.lang.String s =
                                     (java.lang.String)
                                       strings.
                                       get(
                                         0);
                                   if (s.
                                         charAt(
                                           s.
                                             length(
                                               ) -
                                             1) !=
                                         ' ')
                                       return;
                                   length--;
                                   if (s.
                                         length(
                                           ) ==
                                         1) {
                                       attributes.
                                         remove(
                                           0);
                                       strings.
                                         remove(
                                           0);
                                       count--;
                                       return;
                                   }
                                   strings.
                                     set(
                                       0,
                                       s.
                                         substring(
                                           1));
        }
        public void stripLast() { java.lang.String s =
                                    (java.lang.String)
                                      strings.
                                      get(
                                        count -
                                          1);
                                  if (s.charAt(
                                          s.
                                            length(
                                              ) -
                                            1) !=
                                        ' ')
                                      return;
                                  length--;
                                  if (s.length(
                                          ) ==
                                        1) {
                                      attributes.
                                        remove(
                                          --count);
                                      strings.
                                        remove(
                                          count);
                                      return;
                                  }
                                  strings.
                                    set(
                                      count -
                                        1,
                                      s.
                                        substring(
                                          0,
                                          s.
                                            length(
                                              ) -
                                            1));
        }
        public java.text.AttributedString toAttributedString() {
            switch (count) {
                case 0:
                    return null;
                case 1:
                    return new java.text.AttributedString(
                      (java.lang.String)
                        strings.
                        get(
                          0),
                      (java.util.Map)
                        attributes.
                        get(
                          0));
            }
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              strings.
                size(
                  ) *
                5);
            java.util.Iterator it =
              strings.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                sb.
                  append(
                    (java.lang.String)
                      it.
                      next(
                        ));
            }
            java.text.AttributedString result =
              new java.text.AttributedString(
              sb.
                toString(
                  ));
            java.util.Iterator sit =
              strings.
              iterator(
                );
            java.util.Iterator ait =
              attributes.
              iterator(
                );
            int idx =
              0;
            while (sit.
                     hasNext(
                       )) {
                java.lang.String s =
                  (java.lang.String)
                    sit.
                    next(
                      );
                int nidx =
                  idx +
                  s.
                  length(
                    );
                java.util.Map m =
                  (java.util.Map)
                    ait.
                    next(
                      );
                java.util.Iterator kit =
                  m.
                  keySet(
                    ).
                  iterator(
                    );
                java.util.Iterator vit =
                  m.
                  values(
                    ).
                  iterator(
                    );
                while (kit.
                         hasNext(
                           )) {
                    java.text.AttributedCharacterIterator.Attribute attr =
                      (java.text.AttributedCharacterIterator.Attribute)
                        kit.
                        next(
                          );
                    java.lang.Object val =
                      vit.
                      next(
                        );
                    result.
                      addAttribute(
                        attr,
                        val,
                        idx,
                        nidx);
                }
                idx =
                  nidx;
            }
            return result;
        }
        public java.lang.String toString() {
            switch (count) {
                case 0:
                    return "";
                case 1:
                    return (java.lang.String)
                             strings.
                             get(
                               0);
            }
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              strings.
                size(
                  ) *
                5);
            java.util.Iterator it =
              strings.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                sb.
                  append(
                    (java.lang.String)
                      it.
                      next(
                        ));
            }
            return sb.
              toString(
                );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "KV955fgoPdtODm9UfOHlIfOTr7V+cX8r");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("TLHl3a4Y5SoNXdlfUDtO8d59z9GOxrpMve+7j/zaQ88d5aKP7Bk+sedTvD19" +
           "9ytYZe5U3JbY/cbjv/6jv/Ty18pz0f8HPYzJ5QsuAAA=");
    }
    protected boolean nodeAncestorOf(org.w3c.dom.Node node1,
                                     org.w3c.dom.Node node2) {
        if (node2 ==
              null ||
              node1 ==
              null) {
            return false;
        }
        org.w3c.dom.Node parent =
          getParentNode(
            node2);
        while (parent !=
                 null &&
                 parent !=
                 node1) {
            parent =
              getParentNode(
                parent);
        }
        return parent ==
          node1;
    }
    protected void addGlyphPositionAttributes(java.text.AttributedString as,
                                              org.w3c.dom.Element element,
                                              org.apache.batik.bridge.BridgeContext ctx) {
        if (!org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                element,
                ctx.
                  getUserAgent(
                    )) ||
              !org.apache.batik.bridge.CSSUtilities.
              convertDisplay(
                element)) {
            return;
        }
        if (element.
              getLocalName(
                ).
              equals(
                SVG_TEXT_PATH_TAG)) {
            addChildGlyphPositionAttributes(
              as,
              element,
              ctx);
            return;
        }
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return;
        int lastChar =
          getElementEndIndex(
            element);
        if (!(element instanceof org.w3c.dom.svg.SVGTextPositioningElement)) {
            addChildGlyphPositionAttributes(
              as,
              element,
              ctx);
            return;
        }
        org.w3c.dom.svg.SVGTextPositioningElement te =
          (org.w3c.dom.svg.SVGTextPositioningElement)
            element;
        try {
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _x =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getX(
                  );
            _x.
              check(
                );
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _y =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getY(
                  );
            _y.
              check(
                );
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _dx =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getDx(
                  );
            _dx.
              check(
                );
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _dy =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getDy(
                  );
            _dy.
              check(
                );
            org.apache.batik.dom.svg.SVGOMAnimatedNumberList _rotate =
              (org.apache.batik.dom.svg.SVGOMAnimatedNumberList)
                te.
                getRotate(
                  );
            _rotate.
              check(
                );
            org.w3c.dom.svg.SVGLengthList xs =
              _x.
              getAnimVal(
                );
            org.w3c.dom.svg.SVGLengthList ys =
              _y.
              getAnimVal(
                );
            org.w3c.dom.svg.SVGLengthList dxs =
              _dx.
              getAnimVal(
                );
            org.w3c.dom.svg.SVGLengthList dys =
              _dy.
              getAnimVal(
                );
            org.w3c.dom.svg.SVGNumberList rs =
              _rotate.
              getAnimVal(
                );
            int len;
            len =
              xs.
                getNumberOfItems(
                  );
            for (int i =
                   0;
                 i <
                   len &&
                   firstChar +
                   i <=
                   lastChar;
                 i++) {
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      X,
                    new java.lang.Float(
                      xs.
                        getItem(
                          i).
                        getValue(
                          )),
                    firstChar +
                      i,
                    firstChar +
                      i +
                      1);
            }
            len =
              ys.
                getNumberOfItems(
                  );
            for (int i =
                   0;
                 i <
                   len &&
                   firstChar +
                   i <=
                   lastChar;
                 i++) {
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      Y,
                    new java.lang.Float(
                      ys.
                        getItem(
                          i).
                        getValue(
                          )),
                    firstChar +
                      i,
                    firstChar +
                      i +
                      1);
            }
            len =
              dxs.
                getNumberOfItems(
                  );
            for (int i =
                   0;
                 i <
                   len &&
                   firstChar +
                   i <=
                   lastChar;
                 i++) {
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      DX,
                    new java.lang.Float(
                      dxs.
                        getItem(
                          i).
                        getValue(
                          )),
                    firstChar +
                      i,
                    firstChar +
                      i +
                      1);
            }
            len =
              dys.
                getNumberOfItems(
                  );
            for (int i =
                   0;
                 i <
                   len &&
                   firstChar +
                   i <=
                   lastChar;
                 i++) {
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      DY,
                    new java.lang.Float(
                      dys.
                        getItem(
                          i).
                        getValue(
                          )),
                    firstChar +
                      i,
                    firstChar +
                      i +
                      1);
            }
            len =
              rs.
                getNumberOfItems(
                  );
            if (len ==
                  1) {
                java.lang.Float rad =
                  new java.lang.Float(
                  java.lang.Math.
                    toRadians(
                      rs.
                        getItem(
                          0).
                        getValue(
                          )));
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ROTATION,
                    rad,
                    firstChar,
                    lastChar +
                      1);
            }
            else
                if (len >
                      1) {
                    for (int i =
                           0;
                         i <
                           len &&
                           firstChar +
                           i <=
                           lastChar;
                         i++) {
                        java.lang.Float rad =
                          new java.lang.Float(
                          java.lang.Math.
                            toRadians(
                              rs.
                                getItem(
                                  i).
                                getValue(
                                  )));
                        as.
                          addAttribute(
                            org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                              ROTATION,
                            rad,
                            firstChar +
                              i,
                            firstChar +
                              i +
                              1);
                    }
                }
            addChildGlyphPositionAttributes(
              as,
              element,
              ctx);
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    protected void addChildGlyphPositionAttributes(java.text.AttributedString as,
                                                   org.w3c.dom.Element element,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        for (org.w3c.dom.Node child =
               getFirstChild(
                 element);
             child !=
               null;
             child =
               getNextSibling(
                 child)) {
            if (child.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE)
                continue;
            org.w3c.dom.Element childElement =
              (org.w3c.dom.Element)
                child;
            if (isTextChild(
                  childElement)) {
                addGlyphPositionAttributes(
                  as,
                  childElement,
                  ctx);
            }
        }
    }
    protected void addPaintAttributes(java.text.AttributedString as,
                                      org.w3c.dom.Element element,
                                      org.apache.batik.gvt.TextNode node,
                                      org.apache.batik.gvt.text.TextPaintInfo pi,
                                      org.apache.batik.bridge.BridgeContext ctx) {
        if (!org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                element,
                ctx.
                  getUserAgent(
                    )) ||
              !org.apache.batik.bridge.CSSUtilities.
              convertDisplay(
                element)) {
            return;
        }
        java.lang.Object o =
          elemTPI.
          get(
            element);
        if (o !=
              null) {
            node.
              swapTextPaintInfo(
                pi,
                (org.apache.batik.gvt.text.TextPaintInfo)
                  o);
        }
        addChildPaintAttributes(
          as,
          element,
          node,
          pi,
          ctx);
    }
    protected void addChildPaintAttributes(java.text.AttributedString as,
                                           org.w3c.dom.Element element,
                                           org.apache.batik.gvt.TextNode node,
                                           org.apache.batik.gvt.text.TextPaintInfo parentPI,
                                           org.apache.batik.bridge.BridgeContext ctx) {
        for (org.w3c.dom.Node child =
               getFirstChild(
                 element);
             child !=
               null;
             child =
               getNextSibling(
                 child)) {
            if (child.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element childElement =
              (org.w3c.dom.Element)
                child;
            if (isTextChild(
                  childElement)) {
                org.apache.batik.gvt.text.TextPaintInfo pi =
                  getTextPaintInfo(
                    childElement,
                    node,
                    parentPI,
                    ctx);
                addPaintAttributes(
                  as,
                  childElement,
                  node,
                  pi,
                  ctx);
            }
        }
    }
    protected java.util.List getFontList(org.apache.batik.bridge.BridgeContext ctx,
                                         org.w3c.dom.Element element,
                                         java.util.Map result) {
        result.
          put(
            TEXT_COMPOUND_ID,
            new java.lang.ref.SoftReference(
              element));
        java.lang.Float fsFloat =
          org.apache.batik.bridge.TextUtilities.
          convertFontSize(
            element);
        float fontSize =
          fsFloat.
          floatValue(
            );
        result.
          put(
            java.awt.font.TextAttribute.
              SIZE,
            fsFloat);
        result.
          put(
            java.awt.font.TextAttribute.
              WIDTH,
            org.apache.batik.bridge.TextUtilities.
              convertFontStretch(
                element));
        result.
          put(
            java.awt.font.TextAttribute.
              POSTURE,
            org.apache.batik.bridge.TextUtilities.
              convertFontStyle(
                element));
        result.
          put(
            java.awt.font.TextAttribute.
              WEIGHT,
            org.apache.batik.bridge.TextUtilities.
              convertFontWeight(
                element));
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_WEIGHT_INDEX);
        java.lang.String fontWeightString =
          v.
          getCssText(
            );
        java.lang.String fontStyleString =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_STYLE_INDEX).
          getStringValue(
            );
        result.
          put(
            TEXT_COMPOUND_DELIMITER,
            element);
        org.apache.batik.css.engine.value.Value val =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_FAMILY_INDEX);
        java.util.List fontFamilyList =
          new java.util.ArrayList(
          );
        java.util.List fontList =
          new java.util.ArrayList(
          );
        int len =
          val.
          getLength(
            );
        for (int i =
               0;
             i <
               len;
             i++) {
            org.apache.batik.css.engine.value.Value it =
              val.
              item(
                i);
            java.lang.String fontFamilyName =
              it.
              getStringValue(
                );
            org.apache.batik.gvt.font.GVTFontFamily fontFamily;
            fontFamily =
              org.apache.batik.bridge.SVGFontUtilities.
                getFontFamily(
                  element,
                  ctx,
                  fontFamilyName,
                  fontWeightString,
                  fontStyleString);
            if (fontFamily ==
                  null)
                continue;
            if (fontFamily instanceof org.apache.batik.gvt.font.UnresolvedFontFamily) {
                fontFamily =
                  org.apache.batik.gvt.font.FontFamilyResolver.
                    resolve(
                      (org.apache.batik.gvt.font.UnresolvedFontFamily)
                        fontFamily);
                if (fontFamily ==
                      null)
                    continue;
            }
            fontFamilyList.
              add(
                fontFamily);
            if (fontFamily instanceof org.apache.batik.bridge.SVGFontFamily) {
                org.apache.batik.bridge.SVGFontFamily svgFF =
                  (org.apache.batik.bridge.SVGFontFamily)
                    fontFamily;
                if (svgFF.
                      isComplex(
                        )) {
                    usingComplexSVGFont =
                      true;
                }
            }
            org.apache.batik.gvt.font.GVTFont ft =
              fontFamily.
              deriveFont(
                fontSize,
                result);
            fontList.
              add(
                ft);
        }
        result.
          put(
            GVT_FONT_FAMILIES,
            fontFamilyList);
        if (!ctx.
              isDynamic(
                )) {
            result.
              remove(
                TEXT_COMPOUND_DELIMITER);
        }
        return fontList;
    }
    protected java.util.Map getAttributeMap(org.apache.batik.bridge.BridgeContext ctx,
                                            org.w3c.dom.Element element,
                                            org.apache.batik.gvt.text.TextPath textPath,
                                            java.lang.Integer bidiLevel,
                                            java.util.Map result) {
        org.w3c.dom.svg.SVGTextContentElement tce =
          null;
        if (element instanceof org.w3c.dom.svg.SVGTextContentElement) {
            tce =
              (org.w3c.dom.svg.SVGTextContentElement)
                element;
        }
        java.util.Map inheritMap =
          null;
        java.lang.String s;
        if (SVG_NAMESPACE_URI.
              equals(
                element.
                  getNamespaceURI(
                    )) &&
              element.
              getLocalName(
                ).
              equals(
                SVG_ALT_GLYPH_TAG)) {
            result.
              put(
                ALT_GLYPH_HANDLER,
                new org.apache.batik.bridge.SVGAltGlyphHandler(
                  ctx,
                  element));
        }
        org.apache.batik.gvt.text.TextPaintInfo pi =
          new org.apache.batik.gvt.text.TextPaintInfo(
          );
        pi.
          visible =
          true;
        pi.
          fillPaint =
          java.awt.Color.
            black;
        result.
          put(
            PAINT_INFO,
            pi);
        elemTPI.
          put(
            element,
            pi);
        if (textPath !=
              null) {
            result.
              put(
                TEXTPATH,
                textPath);
        }
        org.apache.batik.gvt.TextNode.Anchor a =
          org.apache.batik.bridge.TextUtilities.
          convertTextAnchor(
            element);
        result.
          put(
            ANCHOR_TYPE,
            a);
        java.util.List fontList =
          getFontList(
            ctx,
            element,
            result);
        result.
          put(
            GVT_FONTS,
            fontList);
        java.lang.Object bs =
          org.apache.batik.bridge.TextUtilities.
          convertBaselineShift(
            element);
        if (bs !=
              null) {
            result.
              put(
                BASELINE_SHIFT,
                bs);
        }
        org.apache.batik.css.engine.value.Value val =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              UNICODE_BIDI_INDEX);
        s =
          val.
            getStringValue(
              );
        if (s.
              charAt(
                0) ==
              'n') {
            if (bidiLevel !=
                  null)
                result.
                  put(
                    java.awt.font.TextAttribute.
                      BIDI_EMBEDDING,
                    bidiLevel);
        }
        else {
            val =
              org.apache.batik.bridge.CSSUtilities.
                getComputedStyle(
                  element,
                  org.apache.batik.css.engine.SVGCSSEngine.
                    DIRECTION_INDEX);
            java.lang.String rs =
              val.
              getStringValue(
                );
            int cbidi =
              0;
            if (bidiLevel !=
                  null)
                cbidi =
                  bidiLevel.
                    intValue(
                      );
            if (cbidi <
                  0)
                cbidi =
                  -cbidi;
            switch (rs.
                      charAt(
                        0)) {
                case 'l':
                    result.
                      put(
                        java.awt.font.TextAttribute.
                          RUN_DIRECTION,
                        java.awt.font.TextAttribute.
                          RUN_DIRECTION_LTR);
                    if ((cbidi &
                           1) ==
                          1)
                        cbidi++;
                    else
                        cbidi +=
                          2;
                    break;
                case 'r':
                    result.
                      put(
                        java.awt.font.TextAttribute.
                          RUN_DIRECTION,
                        java.awt.font.TextAttribute.
                          RUN_DIRECTION_RTL);
                    if ((cbidi &
                           1) ==
                          1)
                        cbidi +=
                          2;
                    else
                        cbidi++;
                    break;
            }
            switch (s.
                      charAt(
                        0)) {
                case 'b':
                    cbidi =
                      -cbidi;
                    break;
            }
            result.
              put(
                java.awt.font.TextAttribute.
                  BIDI_EMBEDDING,
                new java.lang.Integer(
                  cbidi));
        }
        val =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              org.apache.batik.css.engine.SVGCSSEngine.
                WRITING_MODE_INDEX);
        s =
          val.
            getStringValue(
              );
        switch (s.
                  charAt(
                    0)) {
            case 'l':
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE_LTR);
                break;
            case 'r':
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE_RTL);
                break;
            case 't':
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE_TTB);
                break;
        }
        val =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              org.apache.batik.css.engine.SVGCSSEngine.
                GLYPH_ORIENTATION_VERTICAL_INDEX);
        int primitiveType =
          val.
          getPrimitiveType(
            );
        switch (primitiveType) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ORIENTATION_AUTO);
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_DEG:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ORIENTATION_ANGLE);
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      val.
                        getFloatValue(
                          )));
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_RAD:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ORIENTATION_ANGLE);
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      java.lang.Math.
                        toDegrees(
                          val.
                            getFloatValue(
                              ))));
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_GRAD:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ORIENTATION_ANGLE);
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      val.
                        getFloatValue(
                          ) *
                        9 /
                        5));
                break;
            default:
                throw new java.lang.IllegalStateException(
                  "unexpected primitiveType (V):" +
                  primitiveType);
        }
        val =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              org.apache.batik.css.engine.SVGCSSEngine.
                GLYPH_ORIENTATION_HORIZONTAL_INDEX);
        primitiveType =
          val.
            getPrimitiveType(
              );
        switch (primitiveType) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_DEG:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      HORIZONTAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      val.
                        getFloatValue(
                          )));
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_RAD:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      HORIZONTAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      java.lang.Math.
                        toDegrees(
                          val.
                            getFloatValue(
                              ))));
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_GRAD:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      HORIZONTAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      val.
                        getFloatValue(
                          ) *
                        9 /
                        5));
                break;
            default:
                throw new java.lang.IllegalStateException(
                  "unexpected primitiveType (H):" +
                  primitiveType);
        }
        java.lang.Float sp =
          org.apache.batik.bridge.TextUtilities.
          convertLetterSpacing(
            element);
        if (sp !=
              null) {
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  LETTER_SPACING,
                sp);
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  CUSTOM_SPACING,
                java.lang.Boolean.
                  TRUE);
        }
        sp =
          org.apache.batik.bridge.TextUtilities.
            convertWordSpacing(
              element);
        if (sp !=
              null) {
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  WORD_SPACING,
                sp);
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  CUSTOM_SPACING,
                java.lang.Boolean.
                  TRUE);
        }
        sp =
          org.apache.batik.bridge.TextUtilities.
            convertKerning(
              element);
        if (sp !=
              null) {
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  KERNING,
                sp);
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  CUSTOM_SPACING,
                java.lang.Boolean.
                  TRUE);
        }
        if (tce ==
              null) {
            return inheritMap;
        }
        try {
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength textLength =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                tce.
                getTextLength(
                  );
            if (textLength.
                  isSpecified(
                    )) {
                if (inheritMap ==
                      null) {
                    inheritMap =
                      new java.util.HashMap(
                        );
                }
                java.lang.Object value =
                  new java.lang.Float(
                  textLength.
                    getCheckedValue(
                      ));
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      BBOX_WIDTH,
                    value);
                inheritMap.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      BBOX_WIDTH,
                    value);
                org.apache.batik.dom.svg.SVGOMAnimatedEnumeration _lengthAdjust =
                  (org.apache.batik.dom.svg.SVGOMAnimatedEnumeration)
                    tce.
                    getLengthAdjust(
                      );
                if (_lengthAdjust.
                      getCheckedVal(
                        ) ==
                      org.w3c.dom.svg.SVGTextContentElement.
                        LENGTHADJUST_SPACINGANDGLYPHS) {
                    result.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          LENGTH_ADJUST,
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          ADJUST_ALL);
                    inheritMap.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          LENGTH_ADJUST,
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          ADJUST_ALL);
                }
                else {
                    result.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          LENGTH_ADJUST,
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          ADJUST_SPACING);
                    inheritMap.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          LENGTH_ADJUST,
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          ADJUST_SPACING);
                    result.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          CUSTOM_SPACING,
                        java.lang.Boolean.
                          TRUE);
                    inheritMap.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          CUSTOM_SPACING,
                        java.lang.Boolean.
                          TRUE);
                }
            }
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
        return inheritMap;
    }
    protected org.apache.batik.gvt.text.TextPaintInfo getParentTextPaintInfo(org.w3c.dom.Element child) {
        org.w3c.dom.Node parent =
          getParentNode(
            child);
        while (parent !=
                 null) {
            org.apache.batik.gvt.text.TextPaintInfo tpi =
              (org.apache.batik.gvt.text.TextPaintInfo)
                elemTPI.
                get(
                  parent);
            if (tpi !=
                  null)
                return tpi;
            parent =
              getParentNode(
                parent);
        }
        return null;
    }
    protected org.apache.batik.gvt.text.TextPaintInfo getTextPaintInfo(org.w3c.dom.Element element,
                                                                       org.apache.batik.gvt.GraphicsNode node,
                                                                       org.apache.batik.gvt.text.TextPaintInfo parentTPI,
                                                                       org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              TEXT_DECORATION_INDEX);
        org.apache.batik.gvt.text.TextPaintInfo pi =
          new org.apache.batik.gvt.text.TextPaintInfo(
          parentTPI);
        org.apache.batik.css.engine.StyleMap sm =
          ((org.apache.batik.css.engine.CSSStylableElement)
             element).
          getComputedStyleMap(
            null);
        if (sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  TEXT_DECORATION_INDEX) &&
              sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  FILL_INDEX) &&
              sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  STROKE_INDEX) &&
              sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  STROKE_WIDTH_INDEX) &&
              sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  OPACITY_INDEX)) {
            return pi;
        }
        setBaseTextPaintInfo(
          pi,
          element,
          node,
          ctx);
        if (!sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  TEXT_DECORATION_INDEX))
            setDecorationTextPaintInfo(
              pi,
              element);
        return pi;
    }
    public void setBaseTextPaintInfo(org.apache.batik.gvt.text.TextPaintInfo pi,
                                     org.w3c.dom.Element element,
                                     org.apache.batik.gvt.GraphicsNode node,
                                     org.apache.batik.bridge.BridgeContext ctx) {
        if (!element.
              getLocalName(
                ).
              equals(
                SVG_TEXT_TAG))
            pi.
              composite =
              org.apache.batik.bridge.CSSUtilities.
                convertOpacity(
                  element);
        else
            pi.
              composite =
              java.awt.AlphaComposite.
                SrcOver;
        pi.
          visible =
          org.apache.batik.bridge.CSSUtilities.
            convertVisibility(
              element);
        pi.
          fillPaint =
          org.apache.batik.bridge.PaintServer.
            convertFillPaint(
              element,
              node,
              ctx);
        pi.
          strokePaint =
          org.apache.batik.bridge.PaintServer.
            convertStrokePaint(
              element,
              node,
              ctx);
        pi.
          strokeStroke =
          org.apache.batik.bridge.PaintServer.
            convertStroke(
              element);
    }
    public void setDecorationTextPaintInfo(org.apache.batik.gvt.text.TextPaintInfo pi,
                                           org.w3c.dom.Element element) {
        org.apache.batik.css.engine.value.Value val =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              TEXT_DECORATION_INDEX);
        switch (val.
                  getCssValueType(
                    )) {
            case org.w3c.dom.css.CSSValue.
                   CSS_VALUE_LIST:
                org.apache.batik.css.engine.value.ListValue lst =
                  (org.apache.batik.css.engine.value.ListValue)
                    val;
                int len =
                  lst.
                  getLength(
                    );
                for (int i =
                       0;
                     i <
                       len;
                     i++) {
                    org.apache.batik.css.engine.value.Value v =
                      lst.
                      item(
                        i);
                    java.lang.String s =
                      v.
                      getStringValue(
                        );
                    switch (s.
                              charAt(
                                0)) {
                        case 'u':
                            if (pi.
                                  fillPaint !=
                                  null) {
                                pi.
                                  underlinePaint =
                                  pi.
                                    fillPaint;
                            }
                            if (pi.
                                  strokePaint !=
                                  null) {
                                pi.
                                  underlineStrokePaint =
                                  pi.
                                    strokePaint;
                            }
                            if (pi.
                                  strokeStroke !=
                                  null) {
                                pi.
                                  underlineStroke =
                                  pi.
                                    strokeStroke;
                            }
                            break;
                        case 'o':
                            if (pi.
                                  fillPaint !=
                                  null) {
                                pi.
                                  overlinePaint =
                                  pi.
                                    fillPaint;
                            }
                            if (pi.
                                  strokePaint !=
                                  null) {
                                pi.
                                  overlineStrokePaint =
                                  pi.
                                    strokePaint;
                            }
                            if (pi.
                                  strokeStroke !=
                                  null) {
                                pi.
                                  overlineStroke =
                                  pi.
                                    strokeStroke;
                            }
                            break;
                        case 'l':
                            if (pi.
                                  fillPaint !=
                                  null) {
                                pi.
                                  strikethroughPaint =
                                  pi.
                                    fillPaint;
                            }
                            if (pi.
                                  strokePaint !=
                                  null) {
                                pi.
                                  strikethroughStrokePaint =
                                  pi.
                                    strokePaint;
                            }
                            if (pi.
                                  strokeStroke !=
                                  null) {
                                pi.
                                  strikethroughStroke =
                                  pi.
                                    strokeStroke;
                            }
                            break;
                    }
                }
                break;
            default:
                pi.
                  underlinePaint =
                  null;
                pi.
                  underlineStrokePaint =
                  null;
                pi.
                  underlineStroke =
                  null;
                pi.
                  overlinePaint =
                  null;
                pi.
                  overlineStrokePaint =
                  null;
                pi.
                  overlineStroke =
                  null;
                pi.
                  strikethroughPaint =
                  null;
                pi.
                  strikethroughStrokePaint =
                  null;
                pi.
                  strikethroughStroke =
                  null;
                break;
        }
    }
    public abstract class AbstractTextChildSVGContext extends org.apache.batik.bridge.AnimatableSVGBridge {
        protected org.apache.batik.bridge.SVGTextElementBridge
          textBridge;
        public AbstractTextChildSVGContext(org.apache.batik.bridge.BridgeContext ctx,
                                           org.apache.batik.bridge.SVGTextElementBridge parent,
                                           org.w3c.dom.Element e) {
            super(
              );
            this.
              ctx =
              ctx;
            this.
              textBridge =
              parent;
            this.
              e =
              e;
        }
        public java.lang.String getNamespaceURI() {
            return null;
        }
        public java.lang.String getLocalName() {
            return null;
        }
        public org.apache.batik.bridge.Bridge getInstance() {
            return null;
        }
        public org.apache.batik.bridge.SVGTextElementBridge getTextBridge() {
            return textBridge;
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
        public java.awt.geom.AffineTransform getCTM() {
            return null;
        }
        public java.awt.geom.AffineTransform getGlobalTransform() {
            return null;
        }
        public java.awt.geom.AffineTransform getScreenTransform() {
            return null;
        }
        public void setScreenTransform(java.awt.geom.AffineTransform at) {
            return;
        }
        public float getViewportWidth() {
            return ctx.
              getBlockWidth(
                e);
        }
        public float getViewportHeight() {
            return ctx.
              getBlockHeight(
                e);
        }
        public float getFontSize() { return org.apache.batik.bridge.CSSUtilities.
                                       getComputedStyle(
                                         e,
                                         org.apache.batik.css.engine.SVGCSSEngine.
                                           FONT_SIZE_INDEX).
                                       getFloatValue(
                                         );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "1/kjPt3wX7xgZgA9JgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "1hl4P/Za4GUp9OZzrloW5HXwivf4DVe+");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("99eUjd985crlN74y/S/ljcPjq8T30dBle+15p+/anHq+FMaW7ZR6uG9/8yYs" +
           "wTVS6I23yIbBAjQ7zocvIHv6NjDos/Qgqyp/T9P9eArdf0IHWO0fTpP8ZArd" +
           "BUiKx3eHR4tc5VapOeY7Kz0t7uIBVe1z2exC2evx02ZTRs2Hf9R0nHohf+t1" +
           "b9Llbfyjt971/j7+i8ZnX6HY93+79en9XUnD0/O84HKZhu7dX9ssmRZvzs/e" +
           "ktsRr0vDd3z/wc/d97ajV/wH9wKfmPAp2Z6++cVEfBWm5VXC/Hfe+M9/4h+/" +
           "8uXy/s3/BTAtdAMmMQAA");
    }
    protected abstract class AbstractTextChildBridgeUpdateHandler extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext implements org.apache.batik.bridge.BridgeUpdateHandler {
        protected AbstractTextChildBridgeUpdateHandler(org.apache.batik.bridge.BridgeContext ctx,
                                                       org.apache.batik.bridge.SVGTextElementBridge parent,
                                                       org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public void handleDOMAttrModifiedEvent(org.w3c.dom.events.MutationEvent evt) {
            
        }
        public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
            textBridge.
              handleDOMNodeInsertedEvent(
                evt);
        }
        public void handleDOMNodeRemovedEvent(org.w3c.dom.events.MutationEvent evt) {
            
        }
        public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
            textBridge.
              handleDOMCharacterDataModified(
                evt);
        }
        public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
            textBridge.
              handleCSSEngineEvent(
                evt);
        }
        public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
            
        }
        public void handleOtherAnimationChanged(java.lang.String type) {
            
        }
        public void dispose() { ((org.apache.batik.dom.svg.SVGOMElement)
                                   e).setSVGContext(
                                        null);
                                elemTPI.remove(
                                          e);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "QXFi5iieKDK0NIob8lBkQc9IxyFDlpLMuYfBg2dveXdjOUX4Ys6WgPNl1jyX" +
           "paetKasFyKrE8+j5/GzS85SFzqmZA1tsaGlgG3nOze4pg+Y9JZ/pfAnU3mDN" +
           "qxQtMlEbogmim9BB3lEYstdmC7IlYO/Tlt1PzxyyYkNLWP9OiXfvsuYiRVWi" +
           "ZECtTzwoXPp/oJCh6L+6GPtytayOFuTd7Ju30cLZ0w2B1tO7PuDFQ/bGuBbK" +
           "gFhKll1ZtDujrtR0EpM4OLVmSarxjw8pai2yMMiTo05h/YEp/zEQ1StPUQX/" +
           "dMtdoajGkQNV5oNb5LcUlYEIe/ydZqPU979dTIKUdYWQ8eVXpXzz599q87ND" +
           "3Hc+LOHmv8jYNU/K/E0mIpw7vX3wwet3PmPeOQkynuR52pwwqjKvv7J10/Ki" +
           "2mxdlX1rbta/VL3KznebzAU752eRi+TbwHlorFpf6LmNMdqzlzIfndn0+i+O" +
           "VL4Pqf0e5MMUzd3j+j3EvPzvzGgpKFj3hJ2S1fWLHr8m6lxzamLzuthfP+YF" +
           "PzKvbxcXl48Il5994JfHF5xp86M5/agCUnmSGUU1krF1QtlBhLQ+iuokoycD" +
           "SwQtEpb7USClSAdSpF8Mo3pGasx8IMfFgrMu28tuLClakV+i5N/z1sjqONG3" +
           "qCmFu8I6qHGdHrt+zik9U5rmGeD0ZLdyXr7tEWHrow0/O9Zc1gsHM8cct/oq" +
           "IxXNlrXuX494h1lRsWZ/hu0znJBIeEDT7GKq4rxmnpS/mzKsnyJfh9XrSQs/" +
           "5+pu8EfW/OM/y2LzyBgeAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected class AbstractTextChildTextContent extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildBridgeUpdateHandler implements org.apache.batik.dom.svg.SVGTextContent {
        protected AbstractTextChildTextContent(org.apache.batik.bridge.BridgeContext ctx,
                                               org.apache.batik.bridge.SVGTextElementBridge parent,
                                               org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public int getNumberOfChars() { return textBridge.
                                          getNumberOfChars(
                                            e);
        }
        public java.awt.geom.Rectangle2D getExtentOfChar(int charnum) {
            return textBridge.
              getExtentOfChar(
                e,
                charnum);
        }
        public java.awt.geom.Point2D getStartPositionOfChar(int charnum) {
            return textBridge.
              getStartPositionOfChar(
                e,
                charnum);
        }
        public java.awt.geom.Point2D getEndPositionOfChar(int charnum) {
            return textBridge.
              getEndPositionOfChar(
                e,
                charnum);
        }
        public void selectSubString(int charnum,
                                    int nchars) {
            textBridge.
              selectSubString(
                e,
                charnum,
                nchars);
        }
        public float getRotationOfChar(int charnum) {
            return textBridge.
              getRotationOfChar(
                e,
                charnum);
        }
        public float getComputedTextLength() {
            return textBridge.
              getComputedTextLength(
                e);
        }
        public float getSubStringLength(int charnum,
                                        int nchars) {
            return textBridge.
              getSubStringLength(
                e,
                charnum,
                nchars);
        }
        public int getCharNumAtPosition(float x,
                                        float y) {
            return textBridge.
              getCharNumAtPosition(
                e,
                x,
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "iTiiT2v1WlLddji+r025fsXoN9x1eVOFhXjb6qdZVJtOBiyYCQvaqlQ7brVq" +
           "zBQRrutee7xYLyu2XoIjAjOX4Hfut5oqLwp+ptMyiOQd11pVu57XwfE1I9cJ" +
           "fj5XZ7U1K67FNKy5otEawwFBN+2sx1WmxCTzYKJRd1XG1VHaZUla4KzaZF4V" +
           "tJqHxXV4zG9mrYZXLqvRVvM60dYoGwzLjIZIR56NOzO3PWBUY9QYObEi0g7w" +
           "lIoWhRPH6S4aKZso/Ea3I0RfRN24LPVGnaZVx0KlRna71MJlOFNldZRLqW1E" +
           "VGQJCaR2rxepsybHbFDN73FYtU9hHU9dtrtDHQ7jbIAmeIDZ60RN9C1a9mic" +
           "arSShJgufLueJLi3oj20KXeWCNufwZTJtatDdxW35yBWo1wKBE2pDa9Z2o7o" +
           "0C1lCExVXSHVBH1pjlNfzOIlZbXUECt5eM1HBMekS/1I4oSBphtJRlcGVdrx" +
           "y/JG31IeF3b6hLaqUeAVssNWEsxlpKSZlddYUh3QQQW4MhKeBeqks5zwaqjS" +
           "WcNfplR/sVQ1N5krWX1O4Ahd16Zhypn4mHE6ztTwlJYhhhopZJIgaqmc4Iax" +
           "ivDyYtOIt5XapA/iyF4G3vGqdRVGlsxig630OqwvdS51FzbCYEI1rsGLgFwq" +
           "tDApJYYxVmuLboNFaKKDsYmRhrMtTaLwiJymoqogJXutjpLNer5BOHfVJEdK" +
           "V8TotbvlJsOWmyD8epJ4Zm9B9gwR4yLaotGetPbLhNKX8Frgl7jyhGSJtU/3" +
           "WtVGiZQqQxDKuExvIEe05KZ1JTZnMt6axsiaaqiNdceISmKph6ktYonotNry" +
           "KIRGmUnaH+os21nJHXRGWyggqEMMFmYz6i1WCOVruJoGyLy/xavBOmzSa6rX" +
           "oM2EXywGDEl7fVqek3CUdQx502SUCN3W+xw/1ztrHOkKHWta7TpMLVkv0t5k" +
           "IdgoRY7rChkTmrGZVeWo5prVepA2ujw6yHhRXQ1bGopm7nhT6tjcqkH4TVZe" +
           "DZdVZDiFDQcr2aU+01ZDooeWScxKcWftuoxPr4Y+u+FQJqPjVEhbi+pouNpS" +
           "y0xKy+PepK5vQ9yewSxFdJlll3RQtKFGhL7MtsIcHagDxmvoVNWOyoPWXKKw" +
           "UmVW8RfDacPnlIavKR1cIRxE72dCNUgUrmpNDa2nwJ0h3UvqlhZhaWVioUuk" +
           "hspIdz7SNbYKrwmyTWCtsMljrlgzOT2SrCbrVtVtK5Iqht0l5uEYvJB6QihJ" +
           "FVG28Upnyy4WNVEEbwKaYQ16YoyaXXm5kFhPb/cXRJUodYUumnUVC/aTan3b" +
           "RHnYmomdabWmMRhRRtZYD5mtwDprykK5MhZqpN4IWsSAWyf+YLyBS5iBjsN5" +
           "LUqGo8l2KJHOqhmOR3Jt7GImoRg9P6iW5EqIZmm5w64RJyPWqFgfV+IWmFlJ" +
           "yIRZDR0MWExnZ6tOlx43p5TccNy6Pq0HkqPOEYLrZUZbSiZcBy/5060l4oE4" +
           "0WOUn4TuqCZN07o1jOaqY7klNBtn/Wk/qK+VjTTRS+sOjPBjW4mDrm3KLIvL" +
           "ODbpybxbVRBvwbfwPmZhbOC6KJ0qeG3SlghjyiNEPdDnxBB4MEeEI5gXRsQw" +
           "zLJqWjIoZIYgje7KpZ1mQxrp/XrQbKHltLZadniMxdHleKGqCN5gKlSLHztK" +
           "ILUwhVcaWQVfzDRGdow1x7oyV000aY4vynWwTvVEtt9znE51UZFspcqrsyra" +
           "xdGKFRhJiZrUBgFCT0LK7gdps8MNHawWBgJbNTREdQWkqfVrMTkRjM6gxAhV" +
           "dSMsK4LkcClJ5q/A+vPbhbi/2HA5OddbOMWGYv95vH3vih7Pk9ec7BMXe3Qv" +
           "Pj4DOv49vU+83727cLy587rrdk3zndBobR5vmx6df+Q7EC+/2fFesfvwgbc/" +
           "/Yze/9nywdEu6bUYunh06rpv9x6g5ombb7N0i6PN/dbdp9/+z48K32q95Xkc" +
           "ibziXCfPq/zF7gf/gH2t9iMH0B0nG3nXHbqerfTk2e27e0MjTkJPOLOJ9/KT" +
           "YXgwt/qrgfk/djQMH7vxscQNKXOhoMyOKLfYgf7uW5R9T56kMXTFNOLd7ll/" +
           "TllKGBXS8ilqvTmG7rCPTugLym2+1obP6baKjPgE9jflmU8AuB8/gv3xrw/s" +
           "C3uBtxYC77oF9h/Kk++PocsAe3OT8/YI+xHbv7HYWFTS+NA0AM1HhgYG2HQM" +
           "lN4b4R23YYRH8sxvBuB/68gIv/UCGeEnbmGEn8yTp2PoYWCEcayE8fF59Vlb" +
           "PHTWFgMfUOG0Hd57u3YoAfyfPLLDJ18gO/z8Lezwi3ny0zH0kpwMnn7WCnnZ" +
           "+/dgf+Y2wF7OM98IQH76COynvz5gDwqBgwLsHvGv3QLxR/Pkw4D+kZEfwY0T" +
           "dbdhf6OZf+fat/W9AT5yGwZ4KM98LQD+mSMDfOYFGu3fuQX2382TT4DFFYz2" +
           "6GiZOEX4c+jvmju+csrz/ebtws893x8fwf/jrw/80+g+d4uyz+fJZ8GEBsjz" +
           "Y5wkNoqbC7zhmbu7Ip/aA/3D2wX6OgDw80dAP/9CEv2vbgH5i3ny5zH0QO7i" +
           "jll+Q7x/cRt4HzzG+4UjvF/4uuP9VJEUUv90C7xfypO/27mynNJgXSdP3Hph" +
           "sj3iv38+iDcx9LJbXXvJ5VEQs730uvt3uztj2oefuXzpkWfELxS3P07udd3D" +
           "Q5fmieOcPvQ89XwxCI25XSC7Z3cEGhQ//xZDj9zkFB8Ek+r+5P65nfy/gyjn" +
           "vDyY28XvabmvxNC9ezmgavdwWuSrIBYCIvnjfwfHS+Tw9q4P7fLFQFdig1M8" +
           "3THCzYVTwfAR4YpRe+BrjdpJldO3S/IAurhAeRzsJrsrlNe0jzzT7n3Xc7Wf" +
           "3d1u0Rwly3Itl3jo7t1Fm5OA+fGbajvWdZF7/Vfv++V7XnMc2d+36/Ce/Kf6" +
           "9oob3yNpukFc3PzIfuORX3/jzz/z18VJ7v8DeduYt9kqAAA=");
    }
    protected class TRefBridge extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildTextContent {
        protected TRefBridge(org.apache.batik.bridge.BridgeContext ctx,
                             org.apache.batik.bridge.SVGTextElementBridge parent,
                             org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
            if (alav.
                  getNamespaceURI(
                    ) ==
                  null) {
                java.lang.String ln =
                  alav.
                  getLocalName(
                    );
                if (ln.
                      equals(
                        SVG_X_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_Y_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_DX_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_DY_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_ROTATE_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_TEXT_LENGTH_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_LENGTH_ADJUST_ATTRIBUTE)) {
                    textBridge.
                      computeLaidoutText(
                        ctx,
                        textBridge.
                          e,
                        textBridge.
                          getTextNode(
                            ));
                    return;
                }
            }
            super.
              handleAnimatedAttributeChanged(
                alav);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "uy9+M6++/S/wrnbaeyAAAA==");
    }
    protected class TextPathBridge extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildTextContent {
        protected TextPathBridge(org.apache.batik.bridge.BridgeContext ctx,
                                 org.apache.batik.bridge.SVGTextElementBridge parent,
                                 org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVXb2wcRxWfu/P/2D77nNghTVzHdYryR7eN2iBVTkOdq51c" +
           "ODunOIngTHOd252723hvdzM7a59dCi0SavhSRSVtA1L9yVUlBG2FWpUPtHJV" +
           "qRQVkFoioCACH4sgohFS+RD+vZnZvd3bs0FF4qTb25t58+a9N7/3e2++dxO1" +
           "OxSNEpOl2YpNnPS0yfKYOkTLGNhxzsJYUX0ugf964aO5++Ooo4D6q9iZVbFD" +
           "ZnRiaE4B7dFNh2FTJc4cIRpfkafEIXQJM90yC2iH7mRrtqGrOpu1NMIFzmOa" +
           "Q4OYMaqXXEayngKG9uTAEkVYokxFpydzqFe17JVAfGdIPBOa4ZK1YC+HoYHc" +
           "RbyEFZfphpLTHTZZp+igbRkrFcNiaVJn6YvGES8Ep3JHWkIw/kryk9tXqgMi" +
           "BEPYNC0m3HPOEMcyloiWQ8lgdNogNecS+ipK5NC2kDBDEzl/UwU2VWBT39tA" +
           "CqzvI6Zby1jCHeZr6rBVbhBDe5uV2JjimqcmL2wGDV3M810sBm/HGt5KL1tc" +
           "fOagcvW5CwM/SKBkASV1c56bo4IRDDYpQEBJrUSoM6VpRCugQRMOe55QHRv6" +
           "qnfSKUevmJi5cPx+WPigaxMq9gxiBecIvlFXZRZtuFcWgPL+tZcNXAFfhwNf" +
           "pYczfBwc7NHBMFrGgDtvSduibmoM3Rld0fBx4gsgAEs7a4RVrcZWbSaGAZSS" +
           "EDGwWVHmAXpmBUTbLQAgZWjXlkp5rG2sLuIKKXJERuTycgqkukUg+BKGdkTF" +
           "hCY4pV2RUwqdz825o089ap404ygGNmtENbj922DRaGTRGVImlEAeyIW9B3LP" +
           "4uE3LscRAuEdEWEp8/pXbj14aHTjXSlzxyYyp0sXicqK6nqp//3dmf33J7gZ" +
           "Xbbl6PzwmzwXWZb3ZibrNjDMcEMjn0z7kxtn3vnS498lf4qjnizqUC3DrQGO" +
           "BlWrZusGoSeISShmRMuibmJqGTGfRZ3wntNNIkdPl8sOYVnUZoihDkv8hxCV" +
           "QQUPUQ+862bZ8t9tzKrivW4jhPrhi4YQ6m5D4iN/GSoqVatGFKxiUzctJU8t" +
           "7r+jAOOUILZVpQSoX1Qcy6UAQcWiFQUDDqrEmyhRXasQZf78ibOQP5wRYOVx" +
           "MZjmQLP//1vUuZdDy7EYHMDuaPobkDknLUMjtKhedY9P33qp+J6EFk8HLz4M" +
           "TcKuablrWuyalrumN9t1go/kIbzyL4rFxN7buTHy4OHYFoEAgIF7988/fOqR" +
           "y+MJQJy9zIPORcebKlEmYAmf2ovqy6m+1b03Dr8dR205lMIqc7HBC8sUrQBl" +
           "qYteVveWoEYFpWIsVCp4jaOWSjRgqq1Khqely1oilI8ztD2kwS9kPGWVrcvI" +
           "pvajjWvLT5z/2j1xFG+uDnzLdiA2vjzPOb3B3RNRVthMb/LJjz55+dnHrIAf" +
           "msqNXyVbVnIfxqPoiIanqB4Yw68V33hsQoS9G/ibYcg3oMbR6B5N9DPpUzn3" +
           "pQscLlu0hg0+5ce4h1WptRyMCNgOivftAIsUz8cxSMxOL0HFL58dtvlzRMKc" +
           "4yzihSgVD8zbz//653+8V4TbryrJUDswT9hkiMm4spTgrMEAtmcpISD3u2v5" +
           "bz1z88kFgVmQuGuzDSf4MwMMBkcIYf7Gu5c+/P2N9evxAOcMddvUYpDrRKs3" +
           "/Ozibg3+Bz9hw7sDk4AMDdDAgTNxzgSI6mUdlwzCc+vvyX2HX/vzUwMSCgaM" +
           "+Eg69N8VBOOfOY4ef+/C30aFmpjKi3EQtkBMMvxQoHmKUrzC7ag/8cGeb/8Y" +
           "Pw+1AvjZ0VeJoNyECENCeL6ToX1bUYxkEa8D8aUPfRpC8hcN8UXL96ppzaql" +
           "PQkBmyNC4h7xvI/HW5iGxNwD/LHPCadfc4aHeraieuX6x33nP37zlghWc9MX" +
           "RtssticlwPnj7jqoH4nS40nsVEHuvo25Lw8YG7dBYwE0qlADnNMUCLvehE1P" +
           "ur3zN2+9PfzI+wkUn0E9hoW1GSzSHHVDfhGnClxftz//oATXMkfbgHAVtTjf" +
           "MsDP987NkTNds5k469Ufjrx69MW1GwLnttRxR1jhZ/njYAPuYqYvWnfDcG/S" +
           "QNGerVoj0datf/3qmnb6hcOygUk1txvT0E1//5f/+Gn62h9+skmN6/Ba2/CG" +
           "DPU3F7P/DX8U7Wzpu2WvqL60luwaWTv3K0GojX6uF6io7BpGw8CwsfwOQElZ" +
           "FwDqlTCyxc85hka2MAz8KwUenJXyX4QrUVSeoXbxG5ZbYKgnkANV8iUscoGh" +
           "BIjw16LtRyn7qdqGqRIUJUArn8lUdUMTLzzvIU1jrVA6xh875PvUlpAOYeeu" +
           "pgwWFybvOGZdeWWCvmLt1Nyjtz73giwUcNVaXRUNNtwXZM1qlOO9W2rzdXWc" +
           "3H+7/5XufXGPSgalwbJQhW3j7yegJNg8xXZFKNSZaDDph+tH3/zZ5Y4PAL0L" +
           "KIaB0RZC1xXZmwMPu5AmC7mghwpduAW3T+7/zsqxQ+W//FZkqddz7d5avqhe" +
           "f/HhXzy9cx1qwLYsaodEI/UC3L2ch1bMM0RdogXUpzvTdTARtMBlMIu6XFO/" +
           "5JIsXPP6Oaoxv0qJuHjh7GuM8jaDofGWO9MmzRkw2jKhxy3X1LiaPuDYYKTp" +
           "JudlSo9r25EFwUjjKLe3+l5UH/pm8kdXUokZyMwmd8LqOx23xKU93cHlTgyI" +
           "cx2QXPcv+MTg+0/+5YfOB+QdI5XxLjpjjZsOUKecSxRzs7bty3Ycs2VuXeIP" +
           "p87HGYod8EY5Wcdkc8H/Lon9XfHKH/V/A/xZYDToEQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "23/r5a8VB/7/BXJyiJryHAAA");
    }
    protected class TspanBridge extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildTextContent {
        protected TspanBridge(org.apache.batik.bridge.BridgeContext ctx,
                              org.apache.batik.bridge.SVGTextElementBridge parent,
                              org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
            if (alav.
                  getNamespaceURI(
                    ) ==
                  null) {
                java.lang.String ln =
                  alav.
                  getLocalName(
                    );
                if (ln.
                      equals(
                        SVG_X_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_Y_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_DX_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_DY_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_ROTATE_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_TEXT_LENGTH_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_LENGTH_ADJUST_ATTRIBUTE)) {
                    textBridge.
                      computeLaidoutText(
                        ctx,
                        textBridge.
                          e,
                        textBridge.
                          getTextNode(
                            ));
                    return;
                }
            }
            super.
              handleAnimatedAttributeChanged(
                alav);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "FQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "EwV00OpbxLoSWUzJGjKNZQ2Bk7HZb7W7tuU7ixkG0yBRYJpKAKuhFEzwYm3d" +
           "HFmlpcCuWZJRkk5S8RsWX5gGS1ce9lIOpLYzcHTIQCecqPO9Ws0mCzqGTwZp" +
           "v0yMGo3s6qG+vtvfvflF9+j5BFz6sonB67j1bKcez5qnjupzeW3k7tMl9+P1" +
           "uV3VBMpucg/f7lUkv8V94v0vvqQOPlncO6g23QAX94PHqh2d7Cr9zO2vq738" +
           "RWhXAvni+//1Ie7txrteR2n50VObPE3yd3svf7nzFuVDe9DZo4LITW9VJ5Gu" +
           "nyyDXAq0KA4c7kQx5OEjsV7OxFUE4nz0QKyP3Lq8e0sTOJObwFbxpyp5Zw4E" +
           "eFDdKN1UNsxKgWEy3284pp2VWhhwx25EUWDKcaTlZaGc7uY1KoTvyZo4gh4x" +
           "JEe1tENKR1RwMD7XtuY7O2Z07wQX8cQ11Z01Jj/uDn6iPhdBbzj2ZpFNo8BQ" +
           "HrzprXT7vqd85qXLFx54if+bvHR/9AZ3kYEu6LFlHa9YHeuf9wJNN3M2L27r" +
           "V17+83wEPXCbEiywYHlXdn1uC/+BCLpyGj6CzuW/x+FeiKBLOzhAats5DvLr" +
           "EXQWgGTdD3mHiqVe11NPQw6jQFKibAY3TEvNO1mF2YnSMyc9+Eg5V3+cco45" +
           "/ZMnvDV/5D70rHj7zH1D+exL3f67X61+cvskoVjSZpNRucBAd25fR4688/Hb" +
           "UjukdZ58+of3fO7iU4dh5J7thnc+c2xvj966+N+2vSgv12/+6IE/eNtvv/SN" +
           "vPz2vyqhynZ9IAAA");
    }
    public int getNumberOfChars() { return getNumberOfChars(
                                             e);
    }
    public java.awt.geom.Rectangle2D getExtentOfChar(int charnum) {
        return getExtentOfChar(
                 e,
                 charnum);
    }
    public java.awt.geom.Point2D getStartPositionOfChar(int charnum) {
        return getStartPositionOfChar(
                 e,
                 charnum);
    }
    public java.awt.geom.Point2D getEndPositionOfChar(int charnum) {
        return getEndPositionOfChar(
                 e,
                 charnum);
    }
    public void selectSubString(int charnum,
                                int nchars) {
        selectSubString(
          e,
          charnum,
          nchars);
    }
    public float getRotationOfChar(int charnum) {
        return getRotationOfChar(
                 e,
                 charnum);
    }
    public float getComputedTextLength() {
        return getComputedTextLength(
                 e);
    }
    public float getSubStringLength(int charnum,
                                    int nchars) {
        return getSubStringLength(
                 e,
                 charnum,
                 nchars);
    }
    public int getCharNumAtPosition(float x,
                                    float y) {
        return getCharNumAtPosition(
                 e,
                 x,
                 y);
    }
    protected int getNumberOfChars(org.w3c.dom.Element element) {
        java.text.AttributedCharacterIterator aci;
        aci =
          getTextNode(
            ).
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return 0;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return 0;
        int lastChar =
          getElementEndIndex(
            element);
        return lastChar -
          firstChar +
          1;
    }
    protected java.awt.geom.Rectangle2D getExtentOfChar(org.w3c.dom.Element element,
                                                        int charnum) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return null;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info;
        info =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        if (info ==
              null)
            return null;
        org.apache.batik.gvt.font.GVTGlyphVector it =
          info.
            layout.
          getGlyphVector(
            );
        java.awt.Shape b =
          null;
        if (info.
              glyphIndexStart ==
              info.
                glyphIndexEnd) {
            if (it.
                  isGlyphVisible(
                    info.
                      glyphIndexStart)) {
                b =
                  it.
                    getGlyphCellBounds(
                      info.
                        glyphIndexStart);
            }
        }
        else {
            java.awt.geom.GeneralPath path =
              null;
            for (int k =
                   info.
                     glyphIndexStart;
                 k <=
                   info.
                     glyphIndexEnd;
                 k++) {
                if (it.
                      isGlyphVisible(
                        k)) {
                    java.awt.geom.Rectangle2D gb =
                      it.
                      getGlyphCellBounds(
                        k);
                    if (path ==
                          null) {
                        path =
                          new java.awt.geom.GeneralPath(
                            gb);
                    }
                    else {
                        path.
                          append(
                            gb,
                            false);
                    }
                }
            }
            b =
              path;
        }
        if (b ==
              null) {
            return null;
        }
        return b.
          getBounds2D(
            );
    }
    protected java.awt.geom.Point2D getStartPositionOfChar(org.w3c.dom.Element element,
                                                           int charnum) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return null;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info;
        info =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        if (info ==
              null)
            return null;
        return getStartPoint(
                 info);
    }
    protected java.awt.geom.Point2D getStartPoint(org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info) {
        org.apache.batik.gvt.font.GVTGlyphVector it =
          info.
            layout.
          getGlyphVector(
            );
        if (!it.
              isGlyphVisible(
                info.
                  glyphIndexStart))
            return null;
        java.awt.geom.Point2D b =
          it.
          getGlyphPosition(
            info.
              glyphIndexStart);
        java.awt.geom.AffineTransform glyphTransform;
        glyphTransform =
          it.
            getGlyphTransform(
              info.
                glyphIndexStart);
        java.awt.geom.Point2D.Float result =
          new java.awt.geom.Point2D.Float(
          0,
          0);
        if (glyphTransform !=
              null)
            glyphTransform.
              transform(
                result,
                result);
        result.
          x +=
          b.
            getX(
              );
        result.
          y +=
          b.
            getY(
              );
        return result;
    }
    protected java.awt.geom.Point2D getEndPositionOfChar(org.w3c.dom.Element element,
                                                         int charnum) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return null;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info;
        info =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        if (info ==
              null)
            return null;
        return getEndPoint(
                 info);
    }
    protected java.awt.geom.Point2D getEndPoint(org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info) {
        org.apache.batik.gvt.font.GVTGlyphVector it =
          info.
            layout.
          getGlyphVector(
            );
        if (!it.
              isGlyphVisible(
                info.
                  glyphIndexEnd))
            return null;
        java.awt.geom.Point2D b =
          it.
          getGlyphPosition(
            info.
              glyphIndexEnd);
        java.awt.geom.AffineTransform glyphTransform;
        glyphTransform =
          it.
            getGlyphTransform(
              info.
                glyphIndexEnd);
        org.apache.batik.gvt.font.GVTGlyphMetrics metrics =
          it.
          getGlyphMetrics(
            info.
              glyphIndexEnd);
        java.awt.geom.Point2D.Float result =
          new java.awt.geom.Point2D.Float(
          metrics.
            getHorizontalAdvance(
              ),
          0);
        if (glyphTransform !=
              null)
            glyphTransform.
              transform(
                result,
                result);
        result.
          x +=
          b.
            getX(
              );
        result.
          y +=
          b.
            getY(
              );
        return result;
    }
    protected float getRotationOfChar(org.w3c.dom.Element element,
                                      int charnum) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return 0;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return 0;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info;
        info =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        double angle =
          0.0;
        int nbGlyphs =
          0;
        if (info !=
              null) {
            org.apache.batik.gvt.font.GVTGlyphVector it =
              info.
                layout.
              getGlyphVector(
                );
            for (int k =
                   info.
                     glyphIndexStart;
                 k <=
                   info.
                     glyphIndexEnd;
                 k++) {
                if (!it.
                      isGlyphVisible(
                        k))
                    continue;
                nbGlyphs++;
                java.awt.geom.AffineTransform glyphTransform =
                  it.
                  getGlyphTransform(
                    k);
                if (glyphTransform ==
                      null)
                    continue;
                double glyphAngle =
                  0.0;
                double cosTheta =
                  glyphTransform.
                  getScaleX(
                    );
                double sinTheta =
                  glyphTransform.
                  getShearX(
                    );
                if (cosTheta ==
                      0.0) {
                    if (sinTheta >
                          0)
                        glyphAngle =
                          java.lang.Math.
                            PI;
                    else
                        glyphAngle =
                          -java.lang.Math.
                             PI;
                }
                else {
                    glyphAngle =
                      java.lang.Math.
                        atan(
                          sinTheta /
                            cosTheta);
                    if (cosTheta <
                          0)
                        glyphAngle +=
                          java.lang.Math.
                            PI;
                }
                glyphAngle =
                  java.lang.Math.
                    toDegrees(
                      -glyphAngle) %
                    360.0;
                angle +=
                  glyphAngle -
                    info.
                    getComputedOrientationAngle(
                      );
            }
        }
        if (nbGlyphs ==
              0)
            return 0;
        return (float)
                 (angle /
                    nbGlyphs);
    }
    protected float getComputedTextLength(org.w3c.dom.Element e) {
        return getSubStringLength(
                 e,
                 0,
                 getNumberOfChars(
                   e));
    }
    protected float getSubStringLength(org.w3c.dom.Element element,
                                       int charnum,
                                       int nchars) {
        if (nchars ==
              0) {
            return 0;
        }
        float length =
          0;
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return -1;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return -1;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation currentInfo;
        currentInfo =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation lastCharacterInRunInfo =
          null;
        int chIndex =
          currentInfo.
            characterIndex +
          1;
        org.apache.batik.gvt.font.GVTGlyphVector vector =
          currentInfo.
            layout.
          getGlyphVector(
            );
        float[] advs =
          currentInfo.
            layout.
          getGlyphAdvances(
            );
        boolean[] glyphTrack =
          new boolean[advs.
                        length];
        for (int k =
               charnum +
               1;
             k <
               charnum +
               nchars;
             k++) {
            if (currentInfo.
                  layout.
                  isOnATextPath(
                    )) {
                for (int gi =
                       currentInfo.
                         glyphIndexStart;
                     gi <=
                       currentInfo.
                         glyphIndexEnd;
                     gi++) {
                    if (vector.
                          isGlyphVisible(
                            gi) &&
                          !glyphTrack[gi])
                        length +=
                          advs[gi +
                                 1] -
                            advs[gi];
                    glyphTrack[gi] =
                      true;
                }
                org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation newInfo;
                newInfo =
                  getCharacterInformation(
                    list,
                    firstChar,
                    k,
                    aci);
                if (newInfo.
                      layout !=
                      currentInfo.
                        layout) {
                    vector =
                      newInfo.
                        layout.
                        getGlyphVector(
                          );
                    advs =
                      newInfo.
                        layout.
                        getGlyphAdvances(
                          );
                    glyphTrack =
                      (new boolean[advs.
                                     length]);
                    chIndex =
                      currentInfo.
                        characterIndex +
                        1;
                }
                currentInfo =
                  newInfo;
            }
            else {
                if (currentInfo.
                      layout.
                      hasCharacterIndex(
                        chIndex)) {
                    chIndex++;
                    continue;
                }
                lastCharacterInRunInfo =
                  getCharacterInformation(
                    list,
                    firstChar,
                    k -
                      1,
                    aci);
                length +=
                  distanceFirstLastCharacterInRun(
                    currentInfo,
                    lastCharacterInRunInfo);
                currentInfo =
                  getCharacterInformation(
                    list,
                    firstChar,
                    k,
                    aci);
                chIndex =
                  currentInfo.
                    characterIndex +
                    1;
                vector =
                  currentInfo.
                    layout.
                    getGlyphVector(
                      );
                advs =
                  currentInfo.
                    layout.
                    getGlyphAdvances(
                      );
                glyphTrack =
                  (new boolean[advs.
                                 length]);
                lastCharacterInRunInfo =
                  null;
            }
        }
        if (currentInfo.
              layout.
              isOnATextPath(
                )) {
            for (int gi =
                   currentInfo.
                     glyphIndexStart;
                 gi <=
                   currentInfo.
                     glyphIndexEnd;
                 gi++) {
                if (vector.
                      isGlyphVisible(
                        gi) &&
                      !glyphTrack[gi])
                    length +=
                      advs[gi +
                             1] -
                        advs[gi];
                glyphTrack[gi] =
                  true;
            }
        }
        else {
            if (lastCharacterInRunInfo ==
                  null) {
                lastCharacterInRunInfo =
                  getCharacterInformation(
                    list,
                    firstChar,
                    charnum +
                      nchars -
                      1,
                    aci);
            }
            length +=
              distanceFirstLastCharacterInRun(
                currentInfo,
                lastCharacterInRunInfo);
        }
        return length;
    }
    protected float distanceFirstLastCharacterInRun(org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation first,
                                                    org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation last) {
        float[] advs =
          first.
            layout.
          getGlyphAdvances(
            );
        int firstStart =
          first.
            glyphIndexStart;
        int firstEnd =
          first.
            glyphIndexEnd;
        int lastStart =
          last.
            glyphIndexStart;
        int lastEnd =
          last.
            glyphIndexEnd;
        int start =
          firstStart <
          lastStart
          ? firstStart
          : lastStart;
        int end =
          firstEnd <
          lastEnd
          ? lastEnd
          : firstEnd;
        return advs[end +
                      1] -
          advs[start];
    }
    protected float distanceBetweenRun(org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation last,
                                       org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation first) {
        float distance;
        java.awt.geom.Point2D startPoint;
        java.awt.geom.Point2D endPoint;
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info =
          new org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation(
          );
        info.
          layout =
          last.
            layout;
        info.
          glyphIndexEnd =
          last.
            layout.
            getGlyphCount(
              ) -
            1;
        startPoint =
          getEndPoint(
            info);
        info.
          layout =
          first.
            layout;
        info.
          glyphIndexStart =
          0;
        endPoint =
          getStartPoint(
            info);
        if (first.
              isVertical(
                )) {
            distance =
              (float)
                (endPoint.
                   getY(
                     ) -
                   startPoint.
                   getY(
                     ));
        }
        else {
            distance =
              (float)
                (endPoint.
                   getX(
                     ) -
                   startPoint.
                   getX(
                     ));
        }
        return distance;
    }
    protected void selectSubString(org.w3c.dom.Element element,
                                   int charnum,
                                   int nchars) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return;
        java.util.List list =
          getTextRuns(
            textNode);
        int lastChar =
          getElementEndIndex(
            element);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation firstInfo;
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation lastInfo;
        firstInfo =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        lastInfo =
          getCharacterInformation(
            list,
            firstChar,
            charnum +
              nchars -
              1,
            aci);
        org.apache.batik.gvt.text.Mark firstMark;
        org.apache.batik.gvt.text.Mark lastMark;
        firstMark =
          textNode.
            getMarkerForChar(
              firstInfo.
                characterIndex,
              true);
        if (lastInfo !=
              null &&
              lastInfo.
                characterIndex <=
              lastChar) {
            lastMark =
              textNode.
                getMarkerForChar(
                  lastInfo.
                    characterIndex,
                  false);
        }
        else {
            lastMark =
              textNode.
                getMarkerForChar(
                  lastChar,
                  false);
        }
        ctx.
          getUserAgent(
            ).
          setTextSelection(
            firstMark,
            lastMark);
    }
    protected int getCharNumAtPosition(org.w3c.dom.Element e,
                                       float x,
                                       float y) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return -1;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.gvt.text.TextHit hit =
          null;
        for (int i =
               list.
               size(
                 ) -
               1;
             i >=
               0 &&
               hit ==
               null;
             i--) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun;
            textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            hit =
              textRun.
                getLayout(
                  ).
                hitTestChar(
                  x,
                  y);
        }
        if (hit ==
              null)
            return -1;
        int first =
          getElementStartIndex(
            e);
        int last =
          getElementEndIndex(
            e);
        int hitIndex =
          hit.
          getCharIndex(
            );
        if (hitIndex >=
              first &&
              hitIndex <=
              last)
            return hitIndex -
              first;
        return -1;
    }
    protected java.util.List getTextRuns(org.apache.batik.gvt.TextNode node) {
        if (node.
              getTextRuns(
                ) ==
              null) {
            node.
              getPrimitiveBounds(
                );
        }
        return node.
          getTextRuns(
            );
    }
    protected org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation getCharacterInformation(java.util.List list,
                                                                                                        int startIndex,
                                                                                                        int charnum,
                                                                                                        java.text.AttributedCharacterIterator aci) {
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info =
          new org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation(
          );
        info.
          characterIndex =
          startIndex +
            charnum;
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            if (!run.
                  getLayout(
                    ).
                  hasCharacterIndex(
                    info.
                      characterIndex))
                continue;
            info.
              layout =
              run.
                getLayout(
                  );
            aci.
              setIndex(
                info.
                  characterIndex);
            if (aci.
                  getAttribute(
                    ALT_GLYPH_HANDLER) !=
                  null) {
                info.
                  glyphIndexStart =
                  0;
                info.
                  glyphIndexEnd =
                  info.
                    layout.
                    getGlyphCount(
                      ) -
                    1;
            }
            else {
                info.
                  glyphIndexStart =
                  info.
                    layout.
                    getGlyphIndex(
                      info.
                        characterIndex);
                if (info.
                      glyphIndexStart ==
                      -1) {
                    info.
                      glyphIndexStart =
                      0;
                    info.
                      glyphIndexEnd =
                      info.
                        layout.
                        getGlyphCount(
                          ) -
                        1;
                }
                else {
                    info.
                      glyphIndexEnd =
                      info.
                        glyphIndexStart;
                }
            }
            return info;
        }
        return null;
    }
    protected static class CharacterInformation {
        org.apache.batik.gvt.text.TextSpanLayout
          layout;
        int glyphIndexStart;
        int glyphIndexEnd;
        int characterIndex;
        public boolean isVertical() { return layout.
                                        isVertical(
                                          );
        }
        public double getComputedOrientationAngle() {
            return layout.
              getComputedOrientationAngle(
                characterIndex);
        }
        public CharacterInformation() { super(
                                          );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "i/0aAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public java.util.Set getTextIntersectionSet(java.awt.geom.AffineTransform at,
                                                java.awt.geom.Rectangle2D rect) {
        java.util.Set elems =
          new java.util.HashSet(
          );
        org.apache.batik.gvt.TextNode tn =
          getTextNode(
            );
        java.util.List list =
          tn.
          getTextRuns(
            );
        if (list ==
              null)
            return elems;
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              run.
              getLayout(
                );
            java.text.AttributedCharacterIterator aci =
              run.
              getACI(
                );
            aci.
              first(
                );
            java.lang.ref.SoftReference sr;
            sr =
              (java.lang.ref.SoftReference)
                aci.
                getAttribute(
                  TEXT_COMPOUND_ID);
            org.w3c.dom.Element elem =
              (org.w3c.dom.Element)
                sr.
                get(
                  );
            if (elem ==
                  null)
                continue;
            if (elems.
                  contains(
                    elem))
                continue;
            if (!isTextSensitive(
                   elem))
                continue;
            java.awt.geom.Rectangle2D glBounds =
              layout.
              getBounds2D(
                );
            if (glBounds !=
                  null) {
                glBounds =
                  at.
                    createTransformedShape(
                      glBounds).
                    getBounds2D(
                      );
                if (!rect.
                      intersects(
                        glBounds)) {
                    continue;
                }
            }
            org.apache.batik.gvt.font.GVTGlyphVector gv =
              layout.
              getGlyphVector(
                );
            for (int g =
                   0;
                 g <
                   gv.
                   getNumGlyphs(
                     );
                 g++) {
                java.awt.Shape gBounds =
                  gv.
                  getGlyphLogicalBounds(
                    g);
                if (gBounds !=
                      null) {
                    gBounds =
                      at.
                        createTransformedShape(
                          gBounds).
                        getBounds2D(
                          );
                    if (gBounds.
                          intersects(
                            rect)) {
                        elems.
                          add(
                            elem);
                        break;
                    }
                }
            }
        }
        return elems;
    }
    public java.util.Set getTextEnclosureSet(java.awt.geom.AffineTransform at,
                                             java.awt.geom.Rectangle2D rect) {
        org.apache.batik.gvt.TextNode tn =
          getTextNode(
            );
        java.util.Set elems =
          new java.util.HashSet(
          );
        java.util.List list =
          tn.
          getTextRuns(
            );
        if (list ==
              null)
            return elems;
        java.util.Set reject =
          new java.util.HashSet(
          );
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              run.
              getLayout(
                );
            java.text.AttributedCharacterIterator aci =
              run.
              getACI(
                );
            aci.
              first(
                );
            java.lang.ref.SoftReference sr;
            sr =
              (java.lang.ref.SoftReference)
                aci.
                getAttribute(
                  TEXT_COMPOUND_ID);
            org.w3c.dom.Element elem =
              (org.w3c.dom.Element)
                sr.
                get(
                  );
            if (elem ==
                  null)
                continue;
            if (reject.
                  contains(
                    elem))
                continue;
            if (!isTextSensitive(
                   elem)) {
                reject.
                  add(
                    elem);
                continue;
            }
            java.awt.geom.Rectangle2D glBounds =
              layout.
              getBounds2D(
                );
            if (glBounds ==
                  null) {
                continue;
            }
            glBounds =
              at.
                createTransformedShape(
                  glBounds).
                getBounds2D(
                  );
            if (rect.
                  contains(
                    glBounds)) {
                elems.
                  add(
                    elem);
            }
            else {
                reject.
                  add(
                    elem);
                elems.
                  remove(
                    elem);
            }
        }
        return elems;
    }
    public static boolean getTextIntersection(org.apache.batik.bridge.BridgeContext ctx,
                                              org.w3c.dom.Element elem,
                                              java.awt.geom.AffineTransform ati,
                                              java.awt.geom.Rectangle2D rect,
                                              boolean checkSensitivity) {
        org.apache.batik.dom.svg.SVGContext svgCtx =
          null;
        if (elem instanceof org.apache.batik.dom.svg.SVGOMElement)
            svgCtx =
              ((org.apache.batik.dom.svg.SVGOMElement)
                 elem).
                getSVGContext(
                  );
        if (svgCtx ==
              null)
            return false;
        org.apache.batik.bridge.SVGTextElementBridge txtBridge =
          null;
        if (svgCtx instanceof org.apache.batik.bridge.SVGTextElementBridge)
            txtBridge =
              (org.apache.batik.bridge.SVGTextElementBridge)
                svgCtx;
        else
            if (svgCtx instanceof org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext) {
                org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext childCtx;
                childCtx =
                  (org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext)
                    svgCtx;
                txtBridge =
                  childCtx.
                    getTextBridge(
                      );
            }
        if (txtBridge ==
              null)
            return false;
        org.apache.batik.gvt.TextNode tn =
          txtBridge.
          getTextNode(
            );
        java.util.List list =
          tn.
          getTextRuns(
            );
        if (list ==
              null)
            return false;
        org.w3c.dom.Element txtElem =
          txtBridge.
            e;
        java.awt.geom.AffineTransform at =
          tn.
          getGlobalTransform(
            );
        at.
          preConcatenate(
            ati);
        java.awt.geom.Rectangle2D tnRect;
        tnRect =
          tn.
            getBounds(
              );
        tnRect =
          at.
            createTransformedShape(
              tnRect).
            getBounds2D(
              );
        if (!rect.
              intersects(
                tnRect))
            return false;
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              run.
              getLayout(
                );
            java.text.AttributedCharacterIterator aci =
              run.
              getACI(
                );
            aci.
              first(
                );
            java.lang.ref.SoftReference sr;
            sr =
              (java.lang.ref.SoftReference)
                aci.
                getAttribute(
                  TEXT_COMPOUND_ID);
            org.w3c.dom.Element runElem =
              (org.w3c.dom.Element)
                sr.
                get(
                  );
            if (runElem ==
                  null)
                continue;
            if (checkSensitivity &&
                  !isTextSensitive(
                     runElem))
                continue;
            org.w3c.dom.Element p =
              runElem;
            while (p !=
                     null &&
                     p !=
                     txtElem &&
                     p !=
                     elem) {
                p =
                  (org.w3c.dom.Element)
                    txtBridge.
                    getParentNode(
                      p);
            }
            if (p !=
                  elem)
                continue;
            java.awt.geom.Rectangle2D glBounds =
              layout.
              getBounds2D(
                );
            if (glBounds ==
                  null)
                continue;
            glBounds =
              at.
                createTransformedShape(
                  glBounds).
                getBounds2D(
                  );
            if (!rect.
                  intersects(
                    glBounds))
                continue;
            org.apache.batik.gvt.font.GVTGlyphVector gv =
              layout.
              getGlyphVector(
                );
            for (int g =
                   0;
                 g <
                   gv.
                   getNumGlyphs(
                     );
                 g++) {
                java.awt.Shape gBounds =
                  gv.
                  getGlyphLogicalBounds(
                    g);
                if (gBounds !=
                      null) {
                    gBounds =
                      at.
                        createTransformedShape(
                          gBounds).
                        getBounds2D(
                          );
                    if (gBounds.
                          intersects(
                            rect)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static java.awt.geom.Rectangle2D getTextBounds(org.apache.batik.bridge.BridgeContext ctx,
                                                          org.w3c.dom.Element elem,
                                                          boolean checkSensitivity) {
        org.apache.batik.dom.svg.SVGContext svgCtx =
          null;
        if (elem instanceof org.apache.batik.dom.svg.SVGOMElement)
            svgCtx =
              ((org.apache.batik.dom.svg.SVGOMElement)
                 elem).
                getSVGContext(
                  );
        if (svgCtx ==
              null)
            return null;
        org.apache.batik.bridge.SVGTextElementBridge txtBridge =
          null;
        if (svgCtx instanceof org.apache.batik.bridge.SVGTextElementBridge)
            txtBridge =
              (org.apache.batik.bridge.SVGTextElementBridge)
                svgCtx;
        else
            if (svgCtx instanceof org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext) {
                org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext childCtx;
                childCtx =
                  (org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext)
                    svgCtx;
                txtBridge =
                  childCtx.
                    getTextBridge(
                      );
            }
        if (txtBridge ==
              null)
            return null;
        org.apache.batik.gvt.TextNode tn =
          txtBridge.
          getTextNode(
            );
        java.util.List list =
          tn.
          getTextRuns(
            );
        if (list ==
              null)
            return null;
        org.w3c.dom.Element txtElem =
          txtBridge.
            e;
        java.awt.geom.Rectangle2D ret =
          null;
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              run.
              getLayout(
                );
            java.text.AttributedCharacterIterator aci =
              run.
              getACI(
                );
            aci.
              first(
                );
            java.lang.ref.SoftReference sr;
            sr =
              (java.lang.ref.SoftReference)
                aci.
                getAttribute(
                  TEXT_COMPOUND_ID);
            org.w3c.dom.Element runElem =
              (org.w3c.dom.Element)
                sr.
                get(
                  );
            if (runElem ==
                  null)
                continue;
            if (checkSensitivity &&
                  !isTextSensitive(
                     runElem))
                continue;
            org.w3c.dom.Element p =
              runElem;
            while (p !=
                     null &&
                     p !=
                     txtElem &&
                     p !=
                     elem) {
                p =
                  (org.w3c.dom.Element)
                    txtBridge.
                    getParentNode(
                      p);
            }
            if (p !=
                  elem)
                continue;
            java.awt.geom.Rectangle2D glBounds =
              layout.
              getBounds2D(
                );
            if (glBounds !=
                  null) {
                if (ret ==
                      null)
                    ret =
                      (java.awt.geom.Rectangle2D)
                        glBounds.
                        clone(
                          );
                else
                    ret.
                      add(
                        glBounds);
            }
        }
        return ret;
    }
    public static boolean isTextSensitive(org.w3c.dom.Element e) {
        int ptrEvts =
          org.apache.batik.bridge.CSSUtilities.
          convertPointerEvents(
            e);
        switch (ptrEvts) {
            case org.apache.batik.gvt.GraphicsNode.
                   VISIBLE_PAINTED:
            case org.apache.batik.gvt.GraphicsNode.
                   VISIBLE_FILL:
            case org.apache.batik.gvt.GraphicsNode.
                   VISIBLE_STROKE:
            case org.apache.batik.gvt.GraphicsNode.
                   VISIBLE:
                return org.apache.batik.bridge.CSSUtilities.
                  convertVisibility(
                    e);
            case org.apache.batik.gvt.GraphicsNode.
                   PAINTED:
            case org.apache.batik.gvt.GraphicsNode.
                   FILL:
            case org.apache.batik.gvt.GraphicsNode.
                   STROKE:
            case org.apache.batik.gvt.GraphicsNode.
                   ALL:
                return true;
            case org.apache.batik.gvt.GraphicsNode.
                   NONE:
            default:
                return false;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4kkRco1+ApOPggrleGrS6W5d96AmiKAr");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("e94J4+zKNwS+N/xTIxOdfBNThF+jGH6N3lYqLhQNIsI6R+jNtIW8TL73RY5U" +
       "VE2Oc4SqWK4hegSTuyY1Qo0GtmpDDcATZfK9P4ZkotKuK7SZYf+GgpdvYfLv" +
       "9ppg0JgwX6TRpuOrAdDBnpmfBVguFpgu9k+HTNSF1vFssNFuTew0rgA2qc+C" +
       "MKp+pKARY7LR45QsFOrlHpkwC2dTel9QASJwG6cdELwcKEFpcYBIKuptu3Mc" +
       "Vhc+12kcHjZSer+ppSzEj8R/npGkiOBGsRlHH+EDX9RD/BiNafHvG/Xp7skn" +
       "bHFVABwWX7kJ575yUzz5JPpLrwm6UCSee8bL33MEfqNBBH5ZRdUCyz8VbP/U" +
       "f0XJROWd7ON2PbyoqIeXMHmOkrmiHlpT8WTaypq6YOxpm5vngwpanQLA3hEA" +
       "31Fww1LHayRsHMO/2uB6oWS2okQXGV7TdQR5+C+bSBz9s4LBv2Lyqs2gU5NZ" +
       "CTaDrwXAIK5eit+LmL6Vl8n3/wgGpSVKe2jnawR42bIyOW9l+N5B9F0em0He" +
       "mtLZFFt5yxEQLCMBBkqniw+TTHd/mOTEGZOVKO2x+WCzbK6Cp/mYzAA3jy/s" +
       "1qenLLbUe6Fulc38RzA1AQ6TV/QNP0W3qOjLwfxrt/EvH5g1deGB859gaxDn" +
       "v0g7PUamDmeTSefH0hy/p2RMfdhgTE9n6Wz2iYGyauhTJXFBSqYM5RdyLVvK" +
       "8y8Xa3k581NSxvbOfCspqbTzQVH8hzPLyZREIAv+XJ3J9SEbZEHK3FcsnAvK" +
       "cbImuLOxxMk1VhGZX6qK8iLOT0yiq8K+7ZxbJDnbI75zcfTA1q7LX33vF/kn" +
       "LuNJbe9eLGVajJTzr22yQiNF38xwlpYra0r7mrdm3luxKrck9Wx+w3ZLWGKr" +
       "JC4JEMqgTix2ff/Rqst/BvKpOzd/7yf7pvwsTEIXk5AG9vHi4u/vTWSyJqm+" +
       "OFb86Yvtmsk+TLlpzaf3nLN++JVfsi8cEv6pjKXy/IPxxw5e+vObFt1ZEybT" +
       "OkiZgS+1sQ8DtuxJ9erxcXMA14xsnWBLAeFSVAXf1ZiJ6qvhKIrxIuickT+K" +
       "C7BTUlv8xYbiz8pWJtO7dZNZNSxmRoxMs4/wmnGtVZ3NZFwC9hFRlZj+Byb3" +
       "sXfrQWMHY52ZTO47HmVHMqwlH/f2c1C1z2I/8dem/weje1d5930AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "La3jfA/akAojW1J9vGqRlYg10dVcDIkW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Wz+yD+ehJD948rsL+Tcqrj5yxOurF4lr");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("5nPsXlko3Pvqbdnt+TLl7dh2OsjH3tMGUT7N4TXgya/bUfC6Z+H6y/Zw/RVZ" +
       "8hgYtgHXj2QTWE9ncf6Fz4J698xjPj9+AT6/LLtYBtbkYFt2e744n097IFff" +
       "uIc7N7LkdWHhJUdvg0/rwYOvHsP91ovCfSOA+bYd3LddDtxreYZrRxoMu1WD" +
       "XW3sQZ8t/riKhIWHd7MZ74S7ctGoUR/gffsOd3pe3GdHjY5x52iPwe9wt/fg" +
       "xrPkO4F/HSghKgTKbWPfsdq++qyfyng27DTA/K4d9tt2dv/msB/bszvsOarh" +
       "HsTZxu9XSWDeAcRtRXL9/LXSPtzUBXA/lF0EY8f1yrbs9nxx3CcRffeee9+T" +
       "JdOtXG83hmXU7FVBnvk4qnB1dtGZyK8F2Bo7jI3LwXg65Hd1uQeokSXSVrl3" +
       "4my5wAmgYJR86a3zK1lFCgVHs5QTcyyvyhe1S14PwO8CZdfPEyg7DxM2e5iQ" +
       "J6utDs/DZIeG+5YXGcVvO4brXxQuGIyv78puz88B3HfugfsjWfKOXXDQkfeC" +
       "/f5LCPdfb+/Ati8H7LHyKvzBMeI98w6vZvMOr74HSHmgZJ8N49biUeThpMa6" +
       "yNzDfBkPsLuuEzuwxHPUsnvmGV79SJZ8MCy8ELQsu1ttc6I/n5pYeo9quUJ4" +
       "DP8iExBz+Jkyo3bwqcuBfxLdP9lz7+ez5KNh4cUAObZ945fPw6IUR8uDhlef" +
       "OQb6MxcFCkzb68Md0OFzKdSf2QP5l7LkU9vY95FEn4n30xcdiTO8u9j39XPH" +
       "vp8N79Vn8iTH9M/34P0XWfIrW7WViTQYl1tHmjpn2THiX72o+5b15O/eIf7u" +
       "8yK+S7fiN/aA/a0s+fyzGyBfuADQJ7KL2di7+9jW9nxxoCdE+XePRfnf7UH7" +
       "f2bJF2+3QrLL1jHY37toZBh4T9c/tQP7qecS7J/sAfsfs+TLd2tt/NElLGC5" +
       "/oUd5i9cqiQf2oitc705Of4Cn5N/ijVDnvPlq3t49vUs+YvtnOsdz7bfsDjJ" +
       "qq9clFVvACz64x2r/vi5FI+/uzPUa1llV//q7qyzv76EdT/X/2aH+G8uVTgy" +
       "8r6WA3pgD9jsM0fX7t1G9HKwt7XqtfsugPFF2cXXFAr3v3Rbdnt+jlr12mN7" +
       "gL40Sx45yzJb3TJWX3v0onCBQr9/N3Ld/xyNXNdevQfpa7Lk5XdniV176qJo" +
       "gcl5v7xDK18O2hOvgLaNe9zCexb2XssW9l57w12YY9cusnw3B40AsJ/dgf7s" +
       "ZUv01a8dd9037cGbbaBwrRYWnpL17TLufGFT9rGbExqeXTunwNcvo8V/awf+" +
       "t55L8N094LO5QtdQ0NiH4FEljBTlDLzYRV9cAUfq/q/v8H79OZdwbg/ocZYM" +
       "ns2LvsZc1PYGLfzAY9uy2/OlIz7hcly7uQexkCWLu3I5rr31Et7OPbAruz1f" +
       "HPaJWcJIDsjcA9bOEvV4ZwIgy9slu7e/XdtL59VHVre8S7umXYAz+UukbwdP" +
       "euvuiW+9HM7sgv+n8F3PKn8BeMpuAH3grAF0h++44+TFsz0P7uqD0zmvkz3t" +
       "8ANZEoaFx3ZCd9pYzjXUMXfXF3XugX30wDM7vM+cl7t3tRnEk7cGkVuqqjsK" +
       "7wtOkIHK8Fg58vfs4cp/lyU/svWaMunMPkvuB0ANAY5wyunXwHno8cF9wA5p" +
       "OzEjDFSTPeQfHPP2712Ut68Cj/7tHQm/fam8zch77zHrPryHdT+VJR8KC4/u" +
       "WNdxJMsN1r6yh2/7iL72D06x6ScuGoT4NvCkv9098W/PwabcAt9u1HQmr856" +
       "Y77jWvZvPmXt2p6w4rUsrHjto8esOyl1eQ3HTLhIUDHbcCj7NPLz+9uy2/Ml" +
       "MeGsBRQ76HvCi9ey8OK1T21d7gw66q6dfBuCExGZaxeJLB6Gn57/zh3od14i" +
       "6Ntclj2RxWtZZPHarwDDZrv7BKc4Qf6F3VMtfK6gYgyshrPiH17gFx4//Ulf" +
       "QTIFTbkp/cIzDz3vsWfG//agcG23vVVW7XWq8Dx1bVkndrE6uaPVvZ6vqHrO" +
       "het5+qCXo/pXYAi5Q2QmLNwrHu2pdO0L2/y/sdvZ4GT+sHBPfj6Z77fDwv3H" +
       "+UBV2x8ns/xuWLgKsmQ/v+gdatryncJELTEIs1Hu5EYYW2bF2xjT4ycEaLvD" +
       "2iPP1hRHRfzCq2/ZsczL9hs73F1sPdx9afuTz/QHb/9q7WfyrcrukSwhTbNa" +
       "nkcV7svH3a3IZzuUvfKOtR3WdS/x+r9+8FPXX3O4m9qDW4KPhfkEbU8djz6Y" +
       "a1lbxRI83bG9MMlmJaX/y2O/+Oaffebf558j/f8BNLsu2oOPAAA=");
}
