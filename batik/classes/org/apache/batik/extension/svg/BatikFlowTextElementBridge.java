package org.apache.batik.extension.svg;
public class BatikFlowTextElementBridge extends org.apache.batik.bridge.SVGTextElementBridge implements org.apache.batik.extension.svg.BatikExtConstants {
    public static final java.text.AttributedCharacterIterator.Attribute FLOW_PARAGRAPH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_PARAGRAPH;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_EMPTY_PARAGRAPH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_EMPTY_PARAGRAPH;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_LINE_BREAK =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_LINE_BREAK;
    public static final java.text.AttributedCharacterIterator.Attribute
      FLOW_REGIONS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        FLOW_REGIONS;
    public static final java.text.AttributedCharacterIterator.Attribute
      PREFORMATTED =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PREFORMATTED;
    public BatikFlowTextElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return BATIK_12_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return BATIK_EXT_FLOW_TEXT_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.extension.svg.BatikFlowTextElementBridge(
                                                            );
    }
    public boolean isComposite() { return false; }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.extension.svg.FlowExtTextNode(
          );
    }
    protected java.awt.geom.Point2D getLocation(org.apache.batik.bridge.BridgeContext ctx,
                                                org.w3c.dom.Element e) {
        return new java.awt.geom.Point2D.Float(
          0,
          0);
    }
    protected void addContextToChild(org.apache.batik.bridge.BridgeContext ctx,
                                     org.w3c.dom.Element e) {
        if (getNamespaceURI(
              ).
              equals(
                e.
                  getNamespaceURI(
                    ))) {
            java.lang.String ln =
              e.
              getLocalName(
                );
            if (ln.
                  equals(
                    BATIK_EXT_FLOW_PARA_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_REGION_BREAK_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_LINE_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_SPAN_TAG) ||
                  ln.
                  equals(
                    SVG_A_TAG) ||
                  ln.
                  equals(
                    SVG_TREF_TAG)) {
                ((org.apache.batik.dom.svg.SVGOMElement)
                   e).
                  setSVGContext(
                    new org.apache.batik.extension.svg.BatikFlowTextElementBridge.BatikFlowContentBridge(
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
    protected java.text.AttributedString buildAttributedString(org.apache.batik.bridge.BridgeContext ctx,
                                                               org.w3c.dom.Element element) {
        java.util.List rgns =
          getRegions(
            ctx,
            element);
        java.text.AttributedString ret =
          getFlowDiv(
            ctx,
            element);
        if (ret ==
              null)
            return ret;
        ret.
          addAttribute(
            FLOW_REGIONS,
            rgns,
            0,
            1);
        return ret;
    }
    protected void addGlyphPositionAttributes(java.text.AttributedString as,
                                              org.w3c.dom.Element element,
                                              org.apache.batik.bridge.BridgeContext ctx) {
        if (element.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                ELEMENT_NODE)
            return;
        java.lang.String eNS =
          element.
          getNamespaceURI(
            );
        if (!eNS.
              equals(
                getNamespaceURI(
                  )) &&
              !eNS.
              equals(
                SVG_NAMESPACE_URI))
            return;
        if (element.
              getLocalName(
                ) !=
              BATIK_EXT_FLOW_TEXT_TAG) {
            super.
              addGlyphPositionAttributes(
                as,
                element,
                ctx);
            return;
        }
        for (org.w3c.dom.Node n =
               element.
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
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE)
                continue;
            java.lang.String nNS =
              n.
              getNamespaceURI(
                );
            if (!getNamespaceURI(
                   ).
                  equals(
                    nNS) &&
                  !SVG_NAMESPACE_URI.
                  equals(
                    nNS)) {
                continue;
            }
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            java.lang.String ln =
              e.
              getLocalName(
                );
            if (ln.
                  equals(
                    BATIK_EXT_FLOW_DIV_TAG)) {
                super.
                  addGlyphPositionAttributes(
                    as,
                    e,
                    ctx);
                return;
            }
        }
    }
    protected void addChildGlyphPositionAttributes(java.text.AttributedString as,
                                                   org.w3c.dom.Element element,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        for (org.w3c.dom.Node child =
               element.
               getFirstChild(
                 );
             child !=
               null;
             child =
               child.
                 getNextSibling(
                   )) {
            if (child.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            java.lang.String cNS =
              child.
              getNamespaceURI(
                );
            if (!getNamespaceURI(
                   ).
                  equals(
                    cNS) &&
                  !SVG_NAMESPACE_URI.
                  equals(
                    cNS)) {
                continue;
            }
            java.lang.String ln =
              child.
              getLocalName(
                );
            if (ln.
                  equals(
                    BATIK_EXT_FLOW_PARA_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_REGION_BREAK_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_LINE_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_SPAN_TAG) ||
                  ln.
                  equals(
                    SVG_A_TAG) ||
                  ln.
                  equals(
                    SVG_TREF_TAG)) {
                addGlyphPositionAttributes(
                  as,
                  (org.w3c.dom.Element)
                    child,
                  ctx);
            }
        }
    }
    protected void addPaintAttributes(java.text.AttributedString as,
                                      org.w3c.dom.Element element,
                                      org.apache.batik.gvt.TextNode node,
                                      org.apache.batik.gvt.text.TextPaintInfo parentPI,
                                      org.apache.batik.bridge.BridgeContext ctx) {
        if (element.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                ELEMENT_NODE)
            return;
        java.lang.String eNS =
          element.
          getNamespaceURI(
            );
        if (!eNS.
              equals(
                getNamespaceURI(
                  )) &&
              !eNS.
              equals(
                SVG_NAMESPACE_URI))
            return;
        if (element.
              getLocalName(
                ) !=
              BATIK_EXT_FLOW_TEXT_TAG) {
            super.
              addPaintAttributes(
                as,
                element,
                node,
                parentPI,
                ctx);
            return;
        }
        for (org.w3c.dom.Node n =
               element.
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
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE)
                continue;
            if (!getNamespaceURI(
                   ).
                  equals(
                    n.
                      getNamespaceURI(
                        )))
                continue;
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            java.lang.String ln =
              e.
              getLocalName(
                );
            if (ln.
                  equals(
                    BATIK_EXT_FLOW_DIV_TAG)) {
                super.
                  addPaintAttributes(
                    as,
                    e,
                    node,
                    parentPI,
                    ctx);
                return;
            }
        }
    }
    protected void addChildPaintAttributes(java.text.AttributedString as,
                                           org.w3c.dom.Element element,
                                           org.apache.batik.gvt.TextNode node,
                                           org.apache.batik.gvt.text.TextPaintInfo parentPI,
                                           org.apache.batik.bridge.BridgeContext ctx) {
        for (org.w3c.dom.Node child =
               element.
               getFirstChild(
                 );
             child !=
               null;
             child =
               child.
                 getNextSibling(
                   )) {
            if (child.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            java.lang.String cNS =
              child.
              getNamespaceURI(
                );
            if (!getNamespaceURI(
                   ).
                  equals(
                    cNS) &&
                  !SVG_NAMESPACE_URI.
                  equals(
                    cNS)) {
                continue;
            }
            java.lang.String ln =
              child.
              getLocalName(
                );
            if (ln.
                  equals(
                    BATIK_EXT_FLOW_PARA_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_REGION_BREAK_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_LINE_TAG) ||
                  ln.
                  equals(
                    BATIK_EXT_FLOW_SPAN_TAG) ||
                  ln.
                  equals(
                    SVG_A_TAG) ||
                  ln.
                  equals(
                    SVG_TREF_TAG)) {
                org.w3c.dom.Element childElement =
                  (org.w3c.dom.Element)
                    child;
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
    protected java.text.AttributedString getFlowDiv(org.apache.batik.bridge.BridgeContext ctx,
                                                    org.w3c.dom.Element element) {
        for (org.w3c.dom.Node n =
               element.
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
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE)
                continue;
            if (!getNamespaceURI(
                   ).
                  equals(
                    n.
                      getNamespaceURI(
                        )))
                continue;
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            java.lang.String ln =
              n.
              getLocalName(
                );
            if (ln.
                  equals(
                    BATIK_EXT_FLOW_DIV_TAG)) {
                return gatherFlowPara(
                         ctx,
                         e);
            }
        }
        return null;
    }
    protected java.text.AttributedString gatherFlowPara(org.apache.batik.bridge.BridgeContext ctx,
                                                        org.w3c.dom.Element div) {
        org.apache.batik.gvt.text.TextPaintInfo divTPI =
          new org.apache.batik.gvt.text.TextPaintInfo(
          );
        divTPI.
          visible =
          true;
        divTPI.
          fillPaint =
          java.awt.Color.
            black;
        elemTPI.
          put(
            div,
            divTPI);
        org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer asb =
          new org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer(
          );
        java.util.List paraEnds =
          new java.util.ArrayList(
          );
        java.util.List paraElems =
          new java.util.ArrayList(
          );
        java.util.List lnLocs =
          new java.util.ArrayList(
          );
        for (org.w3c.dom.Node n =
               div.
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
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE ||
                  !getNamespaceURI(
                     ).
                  equals(
                    n.
                      getNamespaceURI(
                        ))) {
                continue;
            }
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            java.lang.String ln =
              e.
              getLocalName(
                );
            if (ln.
                  equals(
                    BATIK_EXT_FLOW_PARA_TAG)) {
                fillAttributedStringBuffer(
                  ctx,
                  e,
                  true,
                  null,
                  null,
                  asb,
                  lnLocs);
                paraElems.
                  add(
                    e);
                paraEnds.
                  add(
                    new java.lang.Integer(
                      asb.
                        length(
                          )));
            }
            else
                if (ln.
                      equals(
                        BATIK_EXT_FLOW_REGION_BREAK_TAG)) {
                    fillAttributedStringBuffer(
                      ctx,
                      e,
                      true,
                      null,
                      null,
                      asb,
                      lnLocs);
                    paraElems.
                      add(
                        e);
                    paraEnds.
                      add(
                        new java.lang.Integer(
                          asb.
                            length(
                              )));
                }
        }
        divTPI.
          startChar =
          0;
        divTPI.
          endChar =
          asb.
            length(
              ) -
            1;
        java.text.AttributedString ret =
          asb.
          toAttributedString(
            );
        int prevLN =
          0;
        java.util.Iterator lnIter =
          lnLocs.
          iterator(
            );
        while (lnIter.
                 hasNext(
                   )) {
            int nextLN =
              ((java.lang.Integer)
                 lnIter.
                 next(
                   )).
              intValue(
                );
            if (nextLN ==
                  prevLN)
                continue;
            ret.
              addAttribute(
                FLOW_LINE_BREAK,
                new java.lang.Object(
                  ),
                prevLN,
                nextLN);
            prevLN =
              nextLN;
        }
        int start =
          0;
        int end;
        java.util.List emptyPara =
          null;
        for (int i =
               0;
             i <
               paraElems.
               size(
                 );
             i++,
               start =
                 end) {
            org.w3c.dom.Element elem =
              (org.w3c.dom.Element)
                paraElems.
                get(
                  i);
            end =
              ((java.lang.Integer)
                 paraEnds.
                 get(
                   i)).
                intValue(
                  );
            if (start ==
                  end) {
                if (emptyPara ==
                      null)
                    emptyPara =
                      new java.util.LinkedList(
                        );
                emptyPara.
                  add(
                    makeMarginInfo(
                      elem));
                continue;
            }
            ret.
              addAttribute(
                FLOW_PARAGRAPH,
                makeMarginInfo(
                  elem),
                start,
                end);
            if (emptyPara !=
                  null) {
                ret.
                  addAttribute(
                    FLOW_EMPTY_PARAGRAPH,
                    emptyPara,
                    start,
                    end);
                emptyPara =
                  null;
            }
        }
        return ret;
    }
    protected java.util.List getRegions(org.apache.batik.bridge.BridgeContext ctx,
                                        org.w3c.dom.Element element) {
        java.util.List ret =
          new java.util.LinkedList(
          );
        for (org.w3c.dom.Node n =
               element.
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
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE)
                continue;
            if (!getNamespaceURI(
                   ).
                  equals(
                    n.
                      getNamespaceURI(
                        )))
                continue;
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            java.lang.String ln =
              e.
              getLocalName(
                );
            if (!BATIK_EXT_FLOW_REGION_TAG.
                  equals(
                    ln))
                continue;
            float verticalAlignment =
              0.0F;
            java.lang.String verticalAlignmentAttribute =
              e.
              getAttribute(
                BATIK_EXT_VERTICAL_ALIGN_ATTRIBUTE);
            if (verticalAlignmentAttribute !=
                  null &&
                  verticalAlignmentAttribute.
                  length(
                    ) >
                  0) {
                if (BATIK_EXT_ALIGN_TOP_VALUE.
                      equals(
                        verticalAlignmentAttribute)) {
                    verticalAlignment =
                      0.0F;
                }
                else
                    if (BATIK_EXT_ALIGN_MIDDLE_VALUE.
                          equals(
                            verticalAlignmentAttribute)) {
                        verticalAlignment =
                          0.5F;
                    }
                    else
                        if (BATIK_EXT_ALIGN_BOTTOM_VALUE.
                              equals(
                                verticalAlignmentAttribute)) {
                            verticalAlignment =
                              1.0F;
                        }
            }
            gatherRegionInfo(
              ctx,
              e,
              verticalAlignment,
              ret);
        }
        return ret;
    }
    protected void gatherRegionInfo(org.apache.batik.bridge.BridgeContext ctx,
                                    org.w3c.dom.Element rgn,
                                    float verticalAlign,
                                    java.util.List regions) {
        for (org.w3c.dom.Node n =
               rgn.
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
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE)
                continue;
            if (!getNamespaceURI(
                   ).
                  equals(
                    n.
                      getNamespaceURI(
                        )))
                continue;
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                n;
            java.lang.String ln =
              n.
              getLocalName(
                );
            if (ln.
                  equals(
                    org.apache.batik.util.SVGConstants.
                      SVG_RECT_TAG)) {
                org.apache.batik.parser.UnitProcessor.Context uctx;
                uctx =
                  org.apache.batik.bridge.UnitProcessor.
                    createContext(
                      ctx,
                      e);
                org.apache.batik.extension.svg.RegionInfo ri =
                  buildRegion(
                    uctx,
                    e,
                    verticalAlign);
                if (ri !=
                      null)
                    regions.
                      add(
                        ri);
            }
        }
    }
    protected org.apache.batik.extension.svg.RegionInfo buildRegion(org.apache.batik.parser.UnitProcessor.Context uctx,
                                                                    org.w3c.dom.Element e,
                                                                    float verticalAlignment) {
        java.lang.String s;
        s =
          e.
            getAttribute(
              BATIK_EXT_X_ATTRIBUTE);
        float x =
          0;
        if (s.
              length(
                ) !=
              0) {
            x =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalCoordinateToUserSpace(
                  s,
                  BATIK_EXT_X_ATTRIBUTE,
                  uctx);
        }
        s =
          e.
            getAttribute(
              BATIK_EXT_Y_ATTRIBUTE);
        float y =
          0;
        if (s.
              length(
                ) !=
              0) {
            y =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalCoordinateToUserSpace(
                  s,
                  BATIK_EXT_Y_ATTRIBUTE,
                  uctx);
        }
        s =
          e.
            getAttribute(
              BATIK_EXT_WIDTH_ATTRIBUTE);
        float w;
        if (s.
              length(
                ) !=
              0) {
            w =
              org.apache.batik.bridge.UnitProcessor.
                svgHorizontalLengthToUserSpace(
                  s,
                  BATIK_EXT_WIDTH_ATTRIBUTE,
                  uctx);
        }
        else {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { BATIK_EXT_WIDTH_ATTRIBUTE,
              s });
        }
        if (w ==
              0) {
            return null;
        }
        s =
          e.
            getAttribute(
              BATIK_EXT_HEIGHT_ATTRIBUTE);
        float h;
        if (s.
              length(
                ) !=
              0) {
            h =
              org.apache.batik.bridge.UnitProcessor.
                svgVerticalLengthToUserSpace(
                  s,
                  BATIK_EXT_HEIGHT_ATTRIBUTE,
                  uctx);
        }
        else {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { BATIK_EXT_HEIGHT_ATTRIBUTE,
              s });
        }
        if (h ==
              0) {
            return null;
        }
        return new org.apache.batik.extension.svg.RegionInfo(
          x,
          y,
          w,
          h,
          verticalAlignment);
    }
    protected void fillAttributedStringBuffer(org.apache.batik.bridge.BridgeContext ctx,
                                              org.w3c.dom.Element element,
                                              boolean top,
                                              java.lang.Integer bidiLevel,
                                              java.util.Map initialAttributes,
                                              org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer asb,
                                              java.util.List lnLocs) {
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
        if (top)
            endLimit =
              0;
        if (preserve)
            endLimit =
              asb.
                length(
                  );
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
            null,
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
               element.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
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
                    if (!getNamespaceURI(
                           ).
                          equals(
                            n.
                              getNamespaceURI(
                                )) &&
                          !SVG_NAMESPACE_URI.
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
                            BATIK_EXT_FLOW_LINE_TAG)) {
                        int before =
                          asb.
                          length(
                            );
                        fillAttributedStringBuffer(
                          ctx,
                          nodeElement,
                          false,
                          subBidiLevel,
                          initialAttributes,
                          asb,
                          lnLocs);
                        lnLocs.
                          add(
                            new java.lang.Integer(
                              asb.
                                length(
                                  )));
                        if (asb.
                              length(
                                ) !=
                              before) {
                            initialAttributes =
                              null;
                        }
                    }
                    else
                        if (ln.
                              equals(
                                BATIK_EXT_FLOW_SPAN_TAG) ||
                              ln.
                              equals(
                                SVG_ALT_GLYPH_TAG)) {
                            int before =
                              asb.
                              length(
                                );
                            fillAttributedStringBuffer(
                              ctx,
                              nodeElement,
                              false,
                              subBidiLevel,
                              initialAttributes,
                              asb,
                              lnLocs);
                            if (asb.
                                  length(
                                    ) !=
                                  before) {
                                initialAttributes =
                                  null;
                            }
                        }
                        else
                            if (ln.
                                  equals(
                                    SVG_A_TAG)) {
                                if (ctx.
                                      isInteractive(
                                        )) {
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
                                    target.
                                      addEventListenerNS(
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        SVG_EVENT_CLICK,
                                        new org.apache.batik.bridge.SVGAElementBridge.AnchorListener(
                                          ua,
                                          ch),
                                        false,
                                        null);
                                    target.
                                      addEventListenerNS(
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        SVG_EVENT_MOUSEOVER,
                                        new org.apache.batik.bridge.SVGAElementBridge.CursorMouseOverListener(
                                          ua,
                                          ch),
                                        false,
                                        null);
                                    target.
                                      addEventListenerNS(
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        SVG_EVENT_MOUSEOUT,
                                        new org.apache.batik.bridge.SVGAElementBridge.CursorMouseOutListener(
                                          ua,
                                          ch),
                                        false,
                                        null);
                                }
                                int before =
                                  asb.
                                  length(
                                    );
                                fillAttributedStringBuffer(
                                  ctx,
                                  nodeElement,
                                  false,
                                  subBidiLevel,
                                  initialAttributes,
                                  asb,
                                  lnLocs);
                                if (asb.
                                      length(
                                        ) !=
                                      before) {
                                    initialAttributes =
                                      null;
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
                                        java.util.HashMap m =
                                          initialAttributes ==
                                          null
                                          ? new java.util.HashMap(
                                          )
                                          : new java.util.HashMap(
                                          initialAttributes);
                                        getAttributeMap(
                                          ctx,
                                          nodeElement,
                                          null,
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
    protected java.util.Map getAttributeMap(org.apache.batik.bridge.BridgeContext ctx,
                                            org.w3c.dom.Element element,
                                            org.apache.batik.gvt.text.TextPath textPath,
                                            java.lang.Integer bidiLevel,
                                            java.util.Map result) {
        java.util.Map initialMap =
          super.
          getAttributeMap(
            ctx,
            element,
            textPath,
            bidiLevel,
            result);
        java.lang.String s;
        s =
          element.
            getAttribute(
              BATIK_EXT_PREFORMATTED_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            if (s.
                  equals(
                    "true")) {
                result.
                  put(
                    PREFORMATTED,
                    java.lang.Boolean.
                      TRUE);
            }
        }
        return initialMap;
    }
    protected void checkMap(java.util.Map attrs) {
        if (attrs.
              containsKey(
                TEXTPATH)) {
            return;
        }
        if (attrs.
              containsKey(
                ANCHOR_TYPE)) {
            return;
        }
        if (attrs.
              containsKey(
                LETTER_SPACING)) {
            return;
        }
        if (attrs.
              containsKey(
                WORD_SPACING)) {
            return;
        }
        if (attrs.
              containsKey(
                KERNING)) {
            return;
        }
    }
    protected static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      TEXTPATH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXTPATH;
    protected static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      ANCHOR_TYPE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ANCHOR_TYPE;
    protected static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      LETTER_SPACING =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        LETTER_SPACING;
    protected static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      WORD_SPACING =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        WORD_SPACING;
    protected static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      KERNING =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        KERNING;
    public static class LineBreakInfo {
        int breakIdx;
        float lineAdvAdj;
        boolean relative;
        public LineBreakInfo(int breakIdx,
                             float lineAdvAdj,
                             boolean relative) {
            super(
              );
            this.
              breakIdx =
              breakIdx;
            this.
              lineAdvAdj =
              lineAdvAdj;
            this.
              relative =
              relative;
        }
        public int getBreakIdx() { return breakIdx;
        }
        public boolean isRelative() { return relative;
        }
        public float getLineAdvAdj() { return lineAdvAdj;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "nXdR8c/zmci/5Pc2nnpt3WLpYEA8c1gYkPM84mVq9Z78CoPxlKF6M+3CrFNn" +
           "orOawZk3bafe9IenE1EiNpfl1rL5WAtkz68WmNuPzT5OpiQYb3fjhRPWY3c6" +
           "f4UTFg5s18X4F72WWABq3LLVuXX3lsjHWkDbJwrMfQubcY7potd9yB1DHPpf" +
           "GaIFtLhta3P77g2Rj7WAst8tMHcCm29zUgUhEfYis2OL7/w3bJGGTTyPG4Jw" +
           "Fier/uPHEoCwWTlPt9Zzo/Ts0ZqymUcfekugV/ZJsBJwKJ5SFHcCd/VLdYPF" +
           "ZWGYSiud6+LrebikF5YSynpohUrft3jOcNKQn4eT8mzfzfUCJ7V+LqjGxbeb" +
           "7kWIXYcOAN7quEnOgkxAgt2f6Blj14pyEiugoFUBpYu8ySXr9Ol3crorHy30" +
           "QLl4dM/Absp6do9Ip49u2PTI9fuftp4RJIWOjuIqU+ACY71oZKF7Qd7VMmuV" +
           "rl9yo/q58kWZDFdnCeycnjmuEN8OVw8dS+kG3x3bbMletd8+tvrsL8ZKz0NJ" +
           "uo0UUU6mbsutFdN6CnLmtnDuRQ3SnLj8ty755sia5fGrvxPVOLEudo356SPS" +
           "xeMPXzg461hTgEzpJpMgebO0KGLXjqi9TBoy+kmVbHamQURYRaaK5xZYjWFN" +
           "8Tle2MU2Z1V2FB+hOGnOvQDnPt3BzWWYGe1aSo2JZAZp1hnx/Dcgk/1Suu5j" +
           "cEZcjwRrsVmVRm9APEbCG3U98z5QMU0X2NA58UUR2/Oii82FfwOblWIjkBsA" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public org.apache.batik.extension.svg.MarginInfo makeMarginInfo(org.w3c.dom.Element e) {
        java.lang.String s;
        float top =
          0;
        float right =
          0;
        float bottom =
          0;
        float left =
          0;
        s =
          e.
            getAttribute(
              BATIK_EXT_MARGIN_ATTRIBUTE);
        try {
            if (s.
                  length(
                    ) !=
                  0) {
                float f =
                  java.lang.Float.
                  parseFloat(
                    s);
                top =
                  (right =
                     (bottom =
                        (left =
                           f)));
            }
        }
        catch (java.lang.NumberFormatException nfe) {
            
        }
        s =
          e.
            getAttribute(
              BATIK_EXT_TOP_MARGIN_ATTRIBUTE);
        try {
            if (s.
                  length(
                    ) !=
                  0) {
                float f =
                  java.lang.Float.
                  parseFloat(
                    s);
                top =
                  f;
            }
        }
        catch (java.lang.NumberFormatException nfe) {
            
        }
        s =
          e.
            getAttribute(
              BATIK_EXT_RIGHT_MARGIN_ATTRIBUTE);
        try {
            if (s.
                  length(
                    ) !=
                  0) {
                float f =
                  java.lang.Float.
                  parseFloat(
                    s);
                right =
                  f;
            }
        }
        catch (java.lang.NumberFormatException nfe) {
            
        }
        s =
          e.
            getAttribute(
              BATIK_EXT_BOTTOM_MARGIN_ATTRIBUTE);
        try {
            if (s.
                  length(
                    ) !=
                  0) {
                float f =
                  java.lang.Float.
                  parseFloat(
                    s);
                bottom =
                  f;
            }
        }
        catch (java.lang.NumberFormatException nfe) {
            
        }
        s =
          e.
            getAttribute(
              BATIK_EXT_LEFT_MARGIN_ATTRIBUTE);
        try {
            if (s.
                  length(
                    ) !=
                  0) {
                float f =
                  java.lang.Float.
                  parseFloat(
                    s);
                left =
                  f;
            }
        }
        catch (java.lang.NumberFormatException nfe) {
            
        }
        float indent =
          0;
        s =
          e.
            getAttribute(
              BATIK_EXT_INDENT_ATTRIBUTE);
        try {
            if (s.
                  length(
                    ) !=
                  0) {
                float f =
                  java.lang.Float.
                  parseFloat(
                    s);
                indent =
                  f;
            }
        }
        catch (java.lang.NumberFormatException nfe) {
            
        }
        int justification =
          org.apache.batik.extension.svg.MarginInfo.
            JUSTIFY_START;
        s =
          e.
            getAttribute(
              BATIK_EXT_JUSTIFICATION_ATTRIBUTE);
        try {
            if (s.
                  length(
                    ) !=
                  0) {
                if (BATIK_EXT_JUSTIFICATION_START_VALUE.
                      equals(
                        s)) {
                    justification =
                      org.apache.batik.extension.svg.MarginInfo.
                        JUSTIFY_START;
                }
                else
                    if (BATIK_EXT_JUSTIFICATION_MIDDLE_VALUE.
                          equals(
                            s)) {
                        justification =
                          org.apache.batik.extension.svg.MarginInfo.
                            JUSTIFY_MIDDLE;
                    }
                    else
                        if (BATIK_EXT_JUSTIFICATION_END_VALUE.
                              equals(
                                s)) {
                            justification =
                              org.apache.batik.extension.svg.MarginInfo.
                                JUSTIFY_END;
                        }
                        else
                            if (BATIK_EXT_JUSTIFICATION_FULL_VALUE.
                                  equals(
                                    s)) {
                                justification =
                                  org.apache.batik.extension.svg.MarginInfo.
                                    JUSTIFY_FULL;
                            }
            }
        }
        catch (java.lang.NumberFormatException nfe) {
            
        }
        java.lang.String ln =
          e.
          getLocalName(
            );
        boolean rgnBr =
          ln.
          equals(
            BATIK_EXT_FLOW_REGION_BREAK_TAG);
        return new org.apache.batik.extension.svg.MarginInfo(
          top,
          right,
          bottom,
          left,
          indent,
          justification,
          rgnBr);
    }
    protected class BatikFlowContentBridge extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildTextContent {
        public BatikFlowContentBridge(org.apache.batik.bridge.BridgeContext ctx,
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
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/Ltv/82XvlFcZPwPsI5DxvIdAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "dd0+6619X2c+4Lxn7B5czx7xKfQ/i74tkeA6AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "b1pRQ1J63fZiTFsuB0XNMS/52wWk19IxREWYHnoyl2wEj4mM6SbuDXUca047" +
       "AoYOOTc2pz7nLGGhWU0mU60z3rYtvCmsUS9boENpOB2P0wx4ngnScKejDdoT" +
       "arUZuhbxpCanqzS2617X7USp2RxnVq1Jj9tDT5uRc7xFaRNyMbK0qNbt+TUJ" +
       "BE88HYwcazTk5GzVy0Q+nW0hfq0gga/qMrPsblHYi5oVQpSp7lqPB7ajDjLD" +
       "k6tuJ43VMrNlFgYe+dJm63ud1HYCMEGERt/ZiIS0CVZ9VwPh1HYZRquebsZj" +
       "u0+2ZzOlWsORVnUdVPCJ1tcXzYheGCQtE2ORWLY2sYb0OqHhS+2xFXiTUS/s" +
       "zAN7NGdQSumLNuyxPjyFgzZLtdq8pm7LBjXpDsZp3FC3EWdq1dDgXVZeRmOJ" +
       "T9Y43mfngWuIlICQ4+l21ql0iNRW2ibaJenYGlb0al2TujNa8sWha9YqQVlK" +
       "+oTblLyGHIRtwepi8wGq9ly8PFIVCW/KvLHWeHMoB+mk3s2CVDcZdxWvywrr" +
       "did06ExbEeQrnrEa6i1Ym4rpcmpyqRoGk6RNEFommktRj7xJA0xglRnENZf1" +
       "cOFVKNvQMixOqS26SWkF784m20F53ULLK5SxopqBoWE8bhHDWi8C84LTDhx3" +
       "bQvjlRdseGrjh6TEl8twTx9PRlsYraNcxeQqIqRWopBnZskajWPMVeoYoAIV" +
       "IWjLLeRmuVI2Y1lt9amkOVymeC9ajWtzts0RWjRT0X5ZqdRXKeFvszKxGovY" +
       "ZDrrC7PytK+aLTvZavX6erytN1Z4ok7whsKgRG20ohqrjT9xB9OmO6s0mS3G" +
       "SDaBZtuMnowHy6a36jDt2SJWtpM+1+61jRkV+ixVEUTVb4yGONnorcrDrdEr" +
       "MxudGw5aC3MrLgkjksQ+FBs9i9tKW2rFiBHe7M58z+gqhNhJmBhSk2hc7nCy" +
       "VJkuB5WmMkoclPeWipfw3AgdIlg6n1NdZkXZODKbQmxz3Je2rqjVbG0rJaKO" +
       "2D64LYJtaNVat6Ghv8aZfuLrTHfheTWx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("s+ykSydULKDj1lrtAz9PjV14O5/VLc5ZZGTdJ12I0zZue7E0k/oSGBXTJ5fr" +
       "ZJohZiOCmc1koGSDpsMFVcJCR9gaF2OrwsHVVO5XKm6yrmMzYyVrqbQAbp9J" +
       "jFlPJrJYxyexvFBHNiPHThdZVgKFWBPDOibPlYlg1rYiQ2XEyqyEdRteoDWr" +
       "gjDbkS1OCYxhMaQHPEq7qfszxiaktRfWYTmhNsmKH/BcWyqPl5hoNBcAi+ij" +
       "XWDMM0EypBY8Zw0ZRMRll9mQG9ntqkHD1qfhdjEeTFE8rfLrmFtJrAXMpzzT" +
       "rIAno02Ln3hWPPbXU7LWqrThOUSLdkMIp0LUXy/m3XmYGvZ4AEtysw6tbEgY" +
       "4W2+w9Sw9Wo9TbeOFeLYWIZEWsQxrkt4Fb2VrGCuRmodKKh7/CJcskm3t5gk" +
       "tb6pYlJz7FJKWBW0am1RbSygpj7maL6PBM1GTY4GybpNEazRp7WZOQ5UAS6j" +
       "62gg4k5T04d2k4k5bKYLrt3nuGGw1DqmHsSxJSsNepLFVRNOV73OcITWM62t" +
       "hJpTzmIkbrXKkR7R85Sd+JWJmTEa8EJsozbvzCaiVY0ZfrVKJ7VtM10Kq27c" +
       "S2uq7WqhOBxj+GRKBxEV97aTNgxHyyBRt0QM0ViizpOlFk1VjNzE4RSzEUgh" +
       "BFrHVBC0TZszLc5mipzV61jszrB6Um+mPWJcscmgLZd702HNaQ7qbVupJBWh" +
       "J5eVdqMzMCKTmJaxkVGt4qhuIq6xMLUxZaBubTlhssGM622J8iyeMHDQW0Qu" +
       "EbbYMV3ttifjmrmi04FU7lb6w0BVmpxkSUrXpCQXbdSwgdoDEbCd9F0E8YWa" +
       "kmRzei1lssnaSrnPTTnbxhdJ2w1HI9jDSFtKp3WtvjF1o1KRzLQu4Q10jcVS" +
       "pcaBuMS1NIRK5osJZhiVcr1eJSawXkZ6mY+Bu8VthmXdmQA5GJIsTLJOkuTT" +
       "+SPrD13fW4MHixckR4s/5y6WF/zcdTwt3xU9kSdPHr1QKj63l/YLBQ+/T7xQ" +
       "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" +
       "P332i8WuqP8LPph8hppIAAA=");
}
