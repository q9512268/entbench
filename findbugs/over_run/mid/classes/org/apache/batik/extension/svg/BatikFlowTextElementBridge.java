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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYe2wUxxmfO7+NwQ+CTQwYMAYJQu5KE0pSUxLbYDCcsWsD" +
           "Uo80x97unL14b3fZnbMPp5SAlIBQhFIglDbBf6REbREE1DZ9pAql6iOJUoqg" +
           "UZsENWmbP5I2IYE/GqflkX7f7N7t43yHqCr1pJubm/m+me81v++bOXGZlJgG" +
           "adYFVRJCbLtOzVAv9nsFw6RShyKY5gYYjYn7/npw5/gfKnYFSWmUTBkUzG5R" +
           "MGmnTBXJjJJZsmoyQRWpuZ5SCTl6DWpSY1hgsqZGyTTZ7ErqiizKrFuTKBJs" +
           "EowIqRUYM+R4itEuewFGZke4NGEuTbjNT9AaIVWipm93GBo9DB2uOaRNOvuZ" +
           "jNREtgrDQjjFZCUckU3WmjbIXbqmbB9QNBaiaRbaqiy1DbE2sjTHDM2nqz+5" +
           "9uRgDTfDVEFVNcZVNPuoqSnDVIqQamd0lUKT5jbydVIUIZNcxIy0RDKbhmHT" +
           "MGya0dehAuknUzWV7NC4OiyzUqkuokCMzPUuoguGkLSX6eUywwrlzNadM4O2" +
           "c7LaZtztU/Gpu8KHvvlwzQ+KSHWUVMtqP4ojghAMNomCQWkyTg2zTZKoFCW1" +
           "Kji8nxqyoMijtrfrTHlAFVgKQiBjFhxM6dTgezq2Ak+CbkZKZJqRVS/Bg8r+" +
           "V5JQhAHQtd7R1dKwE8dBwUoZBDMSAsSezVI8JKsSjyMvR1bHlnVAAKxlScoG" +
           "texWxaoAA6TOChFFUAfC/RB86gCQlmgQggaPtTyLoq11QRwSBmiMkel+ul5r" +
           "CqgquCGQhZFpfjK+Enip0ecll38ur1++/xF1jRokAZBZoqKC8k8CpiYfUx9N" +
           "UIPCObAYqxZFDgv1L+0NEgLE03zEFs1Pvnb1wcVNZ1+xaGZMQNMT30pFFhOP" +
           "xadcmNmx8P4iFKNc10wZne/RnJ+yXnumNa0D0tRnV8TJUGbybN9vv/LocfpB" +
           "kFR2kVJRU1JJiKNaUUvqskKN1VSlhsCo1EUqqCp18PkuUgb9iKxSa7QnkTAp" +
           "6yLFCh8q1fh/MFEClkATVUJfVhNapq8LbJD30zohpA6+pIGQ4GXCP9YvI6Ph" +
           "QS1Jw4IoqLKqhXsNDfVHh3LMoSb0JZjVtXAc4n/o7iWhZWFTSxkQkGHNGAgL" +
           "EBWD1JrEc0pVEzQOm8MD4XYc61S0kQ0wjmBBVdZuyNIADWEM6v/X3dNom6kj" +
           "gQC4baYfNBQ4b2s0RaJGTDyUal919fnYa1ZA4iGyrcrIahAhZIkQ4iKEsiKE" +
           "QIRQfhFa0LHtBhWGusBlJBDgctyBglmhA/NDACGA4VUL+7+6dsve5iKIWX2k" +
           "GLyGpAtyclqHgzWZBBETT1zoGz9/rvJ4kAQBjuKQ05zE0uJJLFZeNDSRSoBs" +
           "+VJMBmbD+ZPKhHKQs0dGdm3a+TkuhztX4IIlAHPI3osIn92ixY8RE61bvef9" +
           "T04d3qE5aOFJPpmcmcOJINTs97pf+Zi4aI7wQuylHS1BUgzIBmjOBPAbAGWT" +
           "fw8PGLVmgB11KQeFE5qRFBScyqBxJRs0IC6yIzwca3n/DnBxNZ7OmXBMx+3j" +
           "yn9xtl7HtsEKX4wZnxY8cXypXz/6xu//fg83dybHVLuKg37KWl24hovVcQSr" +
           "dUJwg0Ep0P35SO/Bpy7v2czjDyjmTbRhC7YdgGfgQjDzY69se/Odt4+9HnRi" +
           "lkFiT8WhRkpnlSxHnaYUUBLj3JEHcFEBdMCoadmoQlTKCVmIKxQPyfXq+Ute" +
           "+HB/jRUHCoxkwmjxrRdwxu9sJ4++9vB4E18mIGJedmzmkFlgP9VZuc0whO0o" +
           "R3rXxVnfelk4CmkDoNqURylH3yJugyITo9p1brFY7E/FTdZryElwxLCdyk7V" +
           "j2/7ddnoykyamojFolxndp9/cc17Me7ocjzfOI66T3ad3DZjwBVlNZYDPoNP" +
           "AL438YuGxwErKdR12JlpTjY16XoapF9YoJb0qhDeUffO0DPvn7RU8KduHzHd" +
           "e2jfZ6H9hyzvWfXNvJwSw81j1TiWOtjch9LNLbQL5+h879SOn39vxx5Lqjpv" +
           "tl4FxejJP974XejIX16dAOyLZLtGvQfDOQvE9X7vWCqVLjn6r52Pv9EDyNFF" +
           "ylOqvC1FuyT3mlCgmam4y11O5cQH3MqhaxgJLEIv4MhSW2f8+aKrv4LhadeE" +
           "HEHx78pb8pbFNU2hgjoxNxfoXj4XzlIQTkH43JexaTHd0O0NE1f1HxOffP3K" +
           "5E1XzlzlpvZeH9xI1S3olp9rsZmPfm7wp8k1gjkIdPeeXf9QjXL2GqwYhRVF" +
           "KBLMHgOSeNqDazZ1Sdlbv/xV/ZYLRSTYSSrBaFKnwFMEqQBspuYg5P+0/sCD" +
           "FjaNIFjVcFVJjvKIBrMnxplVSZ1xZBj9acOPln937G0OiZbFZ2RRYU5ONudX" +
           "TycRfXjp6Xd/Mf6dMitwCxxDH9/0f/co8d1/+zTHyDzvTnAyffzR8IlnGjtW" +
           "fMD5nQSI3PPSuYUTlAgO7+ePJ/8ZbC79TZCURUmNaF/zNglKCtNKFK42Zubu" +
           "B1dBz7z3mmLV5K3ZBD/TDw2ubf2p133eipnnbNV6E9GdkIA+shPRR/5sGyC8" +
           "E+csC3i7EJvFdgR4lyovsBQDmOZ1n8SFWGblcWz7sLHT48a8cfeQd6sZsMXH" +
           "9lYf55F6qyU1NjRX0HzcDA4F+LpNGm6TtuJIp0/UodsUFQ18xd7sSh5RtxUU" +
           "NR832NSgioBQj//X+QQ1CgiantijQezeDTWLyZ8HHP9yd9f671HumsU52QTB" +
           "ala+qy5PSMd2HxqTep5bErQh9AHY0n6B8CLE3ByE6Oa3e+e4Lbs4XnTpwPSq" +
           "3FIfV2rKU8gvyg8l/g1e3v2Pxg0rBrfcRg0/26e8f8nvd594dfUC8UCQP1BY" +
           "pzvnYcPL1Oo905UGZSlD9WbN5qy7GtANzeCm67a7rvsDz4kVHnWLcqvTfKwF" +
           "MuG+AnNPYPMYI5MGKGt3I4ETsI/f6mR5kg8ORPnwLq/ec0HoG7bwN25f73ys" +
           "BXQ7XGDuCDbfYAj7fe7D6qh94H+jdgvIfNOW/ebtq52PtYBqzxaYO4bNUUYm" +
           "g7sjXjx1NB+7fc3TsKTnEYHTTWfk/v/6UQJgZnrO86n15Cc+P1Zd3jC28U/8" +
           "Jpx9lquCS0cipSjuJOvql+oGTcjcDFVWytX5z0m4QBeWEsptaLlKJyye04w0" +
           "5udhpCLbd3P9kJEaPxfUyPzXTfdjiEuHDkDY6rhJfgYyAQl2X9Qzxq7hVR9W" +
           "KSGrSkkHvAkg6+Jpt3KxK2fM84Ayf/jOAGjKevqGO+LY2vWPXP3Cc9YVX1SE" +
           "0VFcZRJcK6zXhiwIz827Wmat0jULr005XTE/k4VqLYGdszLDFdBRuBDoWPE2" +
           "+u6/Zkv2GvzmseVnzu0tvQhl42YSEBiZujm3nkvrKcgQmyMTXaAgRfGreWvl" +
           "u1vOf/pWoI6XzcS6cjUV4oiJB89c6k3o+reDpKKLlECSpWlebK7crvZRcdjw" +
           "3MdK41pKzb6RT8HAFvBRnFvGNujk7Cg+ETHSnHs1zX02gxvFCDXacXWemHxp" +
           "K6Xr7llu2Q5s7kujpSHWYpFuXbfv5KV7uOV1nZ/9c9is/A+0YRSF3RoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVXa2xcxRWeXT9iL7bXD+KkgZhg1kgJ6d5GgVbIQU28tcmm" +
           "63hlJxG122xm753dvcndeyf3zrXXpjSkUkvUHwgpgaaV4l9BlRAvoaL2D5Er" +
           "JEoFFIWiFqhKi/jTqo1E/pBW6evMzH3ti6r9U0u+Hs+cc+acM9/5zsyz11CX" +
           "Y6Nxik0Np9kqJU46z8d5bDtEyxjYcY7AbEH93kfnz9z4Ve/ZOOpeRAMV7Myq" +
           "2CEzOjE0ZxFt102HYVMlzmFCNK6Rt4lD7GXMdMtcRJt1J1ulhq7qbNbSCBc4" +
           "hu0cGsKM2XrRZSTrGWDojpzwRhHeKAcaBSZzqE+16GqosK1OIRNZ47LVcD+H" +
           "ocHcSbyMFZfphpLTHTZZs9E91DJWy4bF0qTG0ieN+7xEHMrd15SG8ReTn958" +
           "ojIo0jCCTdNiIkRnnjiWsUy0HEqGs9MGqTqn0bdQRw7dEhFmKJXzN1VgUwU2" +
           "9eMNpcD7fmK61YwlwmG+pW6qcocYurPeCMU2rnpm8sJnsNDDvNiFMkS7I4jW" +
           "P+6GEJ+8R7nw/eODL3Wg5CJK6uYCd0cFJxhssggJJdUisZ0Dmka0RTRkwoEv" +
           "EFvHhr7mnfawo5dNzFyAgJ8WPulSYos9w1zBSUJstqsyyw7CKwlQef91lQxc" +
           "hlhHw1hlhDN8HgJM6OCYXcKAPU+l85RuagJH9RpBjKmvggCobqoSVrGCrTpN" +
           "DBNoWELEwGZZWQDwmWUQ7bIAgrbAWhujPNcUq6dwmRQY2tool5dLINUrEsFV" +
           "GNrcKCYswSltazilyPlcO7zv8YfNg2YcxcBnjagG9/8WUBprUJonJWITqAOp" +
           "2Lcr9xQefeVcHCEQ3twgLGV+8s3r+3ePbbwuZW5rITNXPElUVlAvFweu3p7Z" +
           "eX8Hd6OHWo7OD78uclFleW9lskaBaUYDi3wx7S9uzL/2tUefIX+Oo0QWdauW" +
           "4VYBR0OqVaW6QewHiUlszIiWRb3E1DJiPYs2wTinm0TOzpVKDmFZ1GmIqW5L" +
           "/A8pKoEJnqIEjHWzZPljillFjGsUITQAv2gEcSCIH/mXoTWlYlWJglVs6qal" +
           "5G2Lx88PVHAOcWCswSq1lCLg/9Tn96S/pDiWawMgFcsuKxhQUSFykdcpMR2I" +
           "WHGWy8oUn5sxrJUjMM/Jgphsyta1MklzDNL/6+41npuRlVgMju32RtIwoN4O" +
           "WoZG7IJ6wZ2avv584Q0JSF5EXlYZyoMLaelCWriQDlxIgwvp9i6kgiXBPP40" +
           "isWEQ7dyDyWGAAGngEuAzPt2Lnzj0Ilz4x0AXrrSCcfHRe9uam6ZkHT8TlFQ" +
           "n706f+PttxLPxFEceKkIzS3sMKm6DiMbpG2pRAOKa9drfL5V2neXln6gjYsr" +
           "Z4+d+YLwI9o0uMEu4DuunudUH2yRaiSLVnaTj/3x0xeeesQKaaOuC/nNs0mT" +
           "s9F44/E3Bl9Qd+3ALxdeeSQVR51AcUDrDEMZAmOONe5Rx0qTPsPzWHog4JJl" +
           "V7HBl3xaTrCKDQAJZgQuh8T4VjjiJC/TCajXea9uxV++Okr5d4vEMcdMQxSi" +
           "gzywQC+998s/7RXp9ptNMnJLWCBsMkJw3NiwoLKhEIJHbEJA7ncX8+efvPbY" +
           "ksAfSNzVasMU/2aA2OAIIc3fef30+7//8PK78RCzDDq8W4TLUi0IsgdJhmob" +
           "JMd56A8QpAE0wVGTOmoCKvWSjosG4UXy9+TEnpf/8vigxIEBMz6Mdv9nA+H8" +
           "56bQo28cvzEmzMRU3qDDnIVikvVHQssHbBuvcj9qZ9/Z/oOf40vQP4CzHX2N" +
           "CBruEDnoEJFvZWiiiUCKkqEkHXi3El96dzvphWMPNjGMrzTClVb2qmnNqqY9" +
           "CYGZe4WEIr57eb6Fa0is7eOflBOtvfryjtzjCuoT737Sf+yTK9dFsuovglGo" +
           "zWI6KdHNPxM1ML+lkecOYqcCcvduHP76oLFxEywugkUV6N6Zs4GOa3XA9KS7" +
           "Nn3ws1dHT1ztQPEZlDAsrM1gUeOoF4qLOBVg8hr98n4JrhWOtkERKmoKnh/n" +
           "Ha2BMl2lTBzt2k+3/Hjfj9Y/FJiWIL7NUxf/3C2+O/lntw/5XmpbDCwRLUS9" +
           "UOlvbMlR1NeZttH2drcmceO7/O0L69rc03vk3Wa4/iYyDRft5379jzfTF//w" +
           "ixaNrNu79UY3BMy3blI+su7/n7sfxLK16Z4u75bq8+vJni3rR38jmDa4//UB" +
           "R5Vcwwi8jkbA3ww2KekCXH0SYlT8OQoE/dleMijGZcnPR6TOQ3ANbq8DRxmM" +
           "o1pL8Phq1GKoS/yNyh1nKBHKQeblICqCwScQ4cMi9ZOd/W9qP3WgCH0OaoCv" +
           "ZCq6oYmBPMRarBmyD/DPZjne37ZQIlC8q44XxNPMO8hZVz7OCuoL64cOP3z9" +
           "i0/L3gOPurU1cZWHl4lsg0GHv7OtNd9W98GdNwde7J2IewQ1JB2WvS/qGx9P" +
           "Q8lRXsnbGojZSQX8/P7lfVfeOtf9DhTDEopBykeWIg8j+QoAdneBDpZy0StW" +
           "5IEvesZk4uMTb//1g9iwoAPvUjb2WRoF9fyV3+ZLlP4wjnqzqAtql9QW4aXn" +
           "fGXVnCfqMhBXj2vqp12ShUdkd9FyzeAVN8ArAvNnm8iMl9D+YJbfXRgab3qf" +
           "tbjPAVOuEHuKW+dm+utLKuFSGl2t8ddNi6jgbPZc+tuZ7743BxVb53jU2ibH" +
           "LXJpb6PwkSht8++gJMZ/wU8Mfv/Jf/mR8gn5VhnOeA+mHcGLidKaXOso5GYp" +
           "9WT7jgsYUCp4VMJa3AOWa1yCodguSv8NH5As7B0SAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "3v6bL30ju4j4H+HXAJfOHQAA");
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
      ("H4sIAAAAAAAAAMV8e7DrWnmf97nvB/cF3AsE7uXCuSRg7pFlW5bNDQRZkp+y" +
       "LUuybCshF70tW++XJaUkcGcKTNMCTYDQmXD/SEmbZnjkUUI6aTK3pS0kYTJD" +
       "Q9OUToFCJiFQptAMpC1p6JLs/Tj7nL0Pp+cw9YzW1tZ66Pf91vd961vLa/nD" +
       "3yjdFvilsuuYqW464SU1CS+tTeRSmLpqcGlAIbToB6qCm2IQcODZ0/Irfu3+" +
       "73z3PasHLpRuF0rPF23bCcXQcOyAUQPHjFWFKt1//JQ0VSsISw9QazEWoSg0" +
       "TIgygvApqnTPiaph6SJ1CAECECAAASogQNhxKVDpeaodWXheQ7TDwCv9dOmA" +
       "Kt3uyjm8sPT45Y24oi9a+2boQgLQwp35/zwQqqic+KWXH8m+k/kKgd9Xht77" +
       "Cz/5wG/cUrpfKN1v2GwORwYgQvASoXSvpVqS6geYoqiKUHrQVlWFVX1DNI2s" +
       "wC2UHgoM3RbDyFePSMofRq7qF+88Zu5eOZfNj+TQ8Y/E0wzVVA7/u00zRR3I" +
       "+vCxrDsJO/lzIODdBgDma6KsHla5dWPYSlh67HSNIxkvDkEBUPUOSw1XztGr" +
       "brVF8KD00K7vTNHWITb0DVsHRW9zIvCWsPSSMxvNuXZFeSPq6tNh6UWny9G7" +
       "LFDqroKIvEpYeuHpYkVLoJdecqqXTvTPN8Y/+q6fsnv2hQKzospmjv9OUOnR" +
       "U5UYVVN91ZbVXcV7X0O9X3z4d995oVQChV94qvCuzCf+zrfe+NpHn/v0rswP" +
       "XaXMRFqrcvi0/CHpvs++FH9165Ycxp2uExh5518meaH+9D7nqcQFlvfwUYt5" +
       "5qXDzOeYf7d866+qX79Qurtful12zMgCevSg7FiuYap+V7VVXwxVpV+6S7UV" +
       "vMjvl+4A95Rhq7unE00L1LBfutUsHt3uFP8DijTQRE7RHeDesDXn8N4Vw1Vx" +
       "n7ilUukOcJVeDi68tPu08yQsZdDKsVRIlEXbsB2I9p1c/rxDbUWEQjUA9wrI" +
       "dR1IAvq/eRK+hEKBE/lAISHH1yERaMVK3WXmdqraAZAYCmIdaufPOqaz5cDz" +
       "3HWodtj2DUVXL+U66P5/fXuSc/PA9uAAdNtLTzsNE9hbzzEV1X9afm/UJr/1" +
       "0af/8MKREe1ZDUstAOHSDsKlAsKlIwiXAIRLZ0MoHRwUb35BDmWnLKCrN8Bp" +
       "AHd676vZNw3e/M5X3AK01N3eCvopLwqd7dXxYzfTL5ypDHS99NwHtm/jf6Zy" +
       "oXThcvecwweP7s6r07lTPXKeF0+b5dXavf8dX/3Ox97/FufYQC/z93u/cWXN" +
       "3O5fcZpo35FVBXjS4+Zf83Lx40//7lsuXijdCpwJcKChCBQe+KZHT7/jMvt/" +
       "6tCX5rLcBgTWHN8SzTzr0AHeHa580BVHTwoNuK+4fxBwfE9uEE+Aa7G3kOJv" +
       "nvt8N09fsNOYvNNOSVH46tez7gf/9I/+slbQfejW7z8xULJq+NQJV5I3dn/h" +
       "NB481gHOV1VQ7r98gP75933jHT9eKAAo8cqrvfBinuLAhYAuBDT/3U97/+mL" +
       "X/jQ5y4cK00IxtJIMg05ORIyf166+xwhwdtedYwHuCITGGSuNRdntuUohmaI" +
       "kqnmWvo39z8Bf/y/veuBnR6Y4MmhGr322g0cP39xu/TWP/zJv360aOZAzofC" +
       "Y86Oi+386/OPW8Z8X0xzHMnb/v3L/tGnxA8CTw28Y2BkauHwSgUHpaLToEL+" +
       "1xTppVN5cJ48FpxU/svt60TI8rT8ns9983n8N3/vWwXay2Oek309Et2nduqV" +
       "Jy9PQPOPnLb0nhisQLn6c+OfeMB87rugRQG0KAPPFkx84HmSyzRjX/q2Oz7/" +
       "rz758Js/e0vpQqd0t+mISkcsjKx0F9BuNVgBp5W4P/bGXedu7wTJA4WopSuE" +
       "3ynFi4r/ngcAvvps/9LJQ5ZjE33R/56Y0jNf/p9XkFB4lquM1KfqC9CHf/El" +
       "+Bu+XtQ/NvG89qPJld4YhHfHdau/an37witu/7cXSncIpQfkfezIi2aUG44A" +
       "4qXgMKAE8eVl+ZfHPruB/qkjF/bS0+7lxGtPO5fjUQDc56Xz+7tP+ZMX5Sx3" +
       "9lf+IU/7k4NScfNjRZXHi/Rinvxw0Se35Lc/Amw4KCLUEEAwbNHc2/L3wOcA" +
       "XH+bX3nD+YPdkP4Qvo8rXn4UWLhgsLqvQ03mT9MYg3UZjO4VzbwwLEGFjuXB" +
       "7yUsBPGgBCJBBV8BpyKDkLAfqoV3uXiUt3OCeVrNkzfu8CBnqtzrLieEAtdg" +
       "T0jvDEKo8wjJEzxPiIJvMiy9oBCMHNHc8li8PK93CuvoOrF2wTXaY6XOwMpe" +
       "H9b7C6xUf0w+3WZIbHg1mNx1wiTARe9hTs6AKVwfzHsLmAzZ7U/G7NUw/vj/" +
       "A0Z2j5E5A6N4nRhphuxMmBHGcSRxNYzS94+x8IhvKJUu/Odd0QufPwPj6gyM" +
       "Yeku13dC4FFU5Uqod3LkgqMx7sjoOlcEjnoc7oywy3Pn2WEeSZ5li8Z1CowB" +
       "Qb+4F/gLZwjsn9Mp5pWS3oON8d6EeZpb0mT+yD4FMbhOiEBvLnxlD/HLZ0BM" +
       "rw/ifRQJNIZ5mqUxvD/uXg1ldp0owVzqwl/sUf75GSjfen0o751PGOI8jG+7" +
       "ToyvB9i+vsf4tTMwvuP6MN4xJJnxGfDeeU14RSPJAYhSb6teQi9V8v/fdX0u" +
       "4JG1KV88HO141c8nXhfXJnpoZg8UY1s+3F/aLXWcAkl+3yBBfHTfcWOUY+tP" +
       "/eyfvecz737lF0EQMyjdFucBBohdTrxxHOULSW//8Pteds97v/SzRVgOYnL6" +
       "/eQDb8xb/YXrE/UluahsMfOlxCAcFZG0qhTSnhu70b5hgQlHvF8lgd7y0Bc3" +
       "v/jVj+xWQE4HaqcKq+9879/73qV3vffCiXWnV16x9HOyzm7tqQD9vD3Dfunx" +
       "895S1Oj8xcfe8ju/8pZ37FA9dPkqCmlH1kf+5P985tIHvvT7V5mE32o6N9Cx" +
       "4cNurx70scPPiJcIBJvBAgjioRDStQoRrLBpu5NupwNjUHfL1BBxzeqimUZZ" +
       "JCx4RZmGEpjXo4JiRw2rXK9FzXFjNWrzG2rMWo7rZO2yy276bL3a7ZsIsWn1" +
       "B8vBujtosukomoYpbjkm42x4T2CMLEyQGqQ1FE0ZZTU2w+CwxtNzyQ0htBaH" +
       "5RhSW2itFmcJ0rRgdtk2rRVedVljTISRxXTrsa52tgnH+ktXtzaT7VhZNVVk" +
       "gbZCpLWW4ag53MjOeraemtY6NZYzRw6GMzMz8JThhdHQMwwhFoYzpm/V+4LF" +
       "jtjOdM5PemkvE1AS9Q0jG4akQrHmSp8RbcPtdHV40O6NTM5DVvxU3lgjkRmb" +
       "1Q0jxVNeXFps1ZvY0mLZ6ajTQThZmMtxVK0KMMWSVEhYbdzoso5fEVZBxRWD" +
       "KYsuxnMeZcOOw4x8Nm3XhrCQ9q3qYNFp4du6HcNA/m1ZIrtMMGpO+RmcGriI" +
       "y/bMxDZul6VhNFSqzMyTqk3DZnlrlI0clyPNLOvWK7gDdx2elHw4GIaD5toT" +
       "zIrVlPQZFVmsCZMrdiXYZnlArVa4ZcqckLkEocxny6qG6z1R0FtSJOkQWU7L" +
       "NBrHhpv45WiZzQik05ircE+ZMVN9019PwZvMdoMhqBFsCSw7bTDMaorG5jYR" +
       "ZpOpWwvDjOMsE19PiYFFcPqqmQEEW8Bc5OBy20JIxpsv601SFGZaD+KXW2+q" +
       "e9uxby6p5VQptysYHHi6RZCePoGTjTZI5rNKOml6C5nAqlJ9ifc7Hm9GxhJZ" +
       "M7yv+1tdTmGOnDJwh6306gnNzXoMrsOjShevIubIlb0KVfeN6cZZunNVDzuo" +
       "mjqd6bi/HXSGAzumZMHTTUREJpZp0wgSAT1Vy8gsak23+LI3YWfmbEa3hD7F" +
       "zfoIO2UMntDtjo7LiErWQkyk/UFtja1mPaPsom0e2SiQVpbWIiKr0JLnBbvL" +
       "jOzKWqnoRo9Z0uvxVInQVdiSteGsD3sLbmyi9LaJdNNZsjAnLLzscS16A/cN" +
       "geTiTJxQdlirWaQK+nTMVDcVl5llAzcYjruzWQxGh75gC32vOx3ymxBoqDnk" +
       "JDaFLJhrq5VkPlBDv1Y2nKHSiWZeY8shM7GctaZjzOX75Bxu4g3fQfyWr4eV" +
       "NQXbymzQ73DJpsslYUJ7NTAYDl1vsJ6b3hD3hnrqOfM1E4j1QJ4IHNIbRWQL" +
       "l6xGZ1Vpl5OWplQWm6pnuMJ0u02HK8sd9vH5aL4UugtjMuBnZNLuZUtzpuDj" +
       "cgPGK+m0V18HCD6LzO600rBcbC06NApVbWceCZtad+q2Q7gWKIwzXFNyxM3M" +
       "YeLjdQqdJJCc1FZIGSba/R45V/mNU27jqw61mq64vjp0SIzk+3Hd23TwfrjY" +
       "Mp7VF/AaB08IfdwcexkPKXGs2tWYjYdb0ofTBeUM0rThWdhcrE1aRlYxiX7Q" +
       "W6eLCR23ZJQdr0h92Rtjw8wiIn48UcYDRRiJXcMwMUZD1qpb7dfhxro87ozn" +
       "RK8Hb+VQ0zOnmdKLgd1upFtstZWMQGPcLByPe0DL/E6jUYYawMP2eqGxirT6" +
       "SkK9RGhucHYxRYdo1kKxGQQctDBYbVUosCbIGnPbcLMLAS0YjVFszKJw6PZs" +
       "zXQDvo4sPb239bripj2dZxLdktimPAowzsYzMJOMhTKI2xOqndLDchcxp61p" +
       "y4kQjvMsPE0JRogTp9vmkqVQhsSeBimR1EhspeUlrJ2MJi0yqgxklVvO+cyS" +
       "W55CwtvtANsMaS3VoR6K2hBwqLUR5BGkK89EaSRWCG67VPDeFBqbmkSE5aY7" +
       "I6i6oFiN2dacK90+7g8nBpFMGpsx1jeraOQQtom1tXp7XqmlGW4u3XXTxw2c" +
       "WvVpU4JkxydiyLV1iSJWXH3pxkzVHi/qPRRKSSm15jKkLJauly439U0WyNFy" +
       "HrQylKY0iw9G09AbqVW+ElO0zY6aA2LU6WJyJpnDpY3Mm/16f5hxvkXVnTRR" +
       "0KaFtt2xNWpp9WZTWXDBtEL10HKy0CyCQjIEy7jxGtqkUc3vbTpxIG+pDcIL" +
       "Xq/RhludCq4ulyYVe+KkaXcRdt2r4OMpjK/xPsqjBI0154uM6k8WvrdqNETL" +
       "tqp1iN9IeE9k5pUls1k1sW7elQ1EGo00XJhrte4ajpQJvBmz0wnB6j7WR8qL" +
       "zqTstnxm0pUUDowWW70cQbHW5AWTnXdY2Kr7M4uxXVVrrnFlITtQ2SZ5GIGa" +
       "0bbmedlA8+cQBFF9Sktj2uI3rWocdxBiRHdUZjqarulk2iqP+Y7EqbIQDyO8" +
       "0nNZdNLZbCv1Oa9V043GonUQOtD1gBt6XbZP96flcXsq2/q2neLyGK/Uq7O+" +
       "DdFpszJCh3XElflsk/BozVQmAVyzkE2SNpdVs2mX6YTfRkkni+s6BImxVveY" +
       "8YoaJGMhUSjeGibmgje6fjnGGEQPsKGqg2FkaATKgqIwnwr72GAxUwIJkVbR" +
       "JDQUacJ0o6ZR30Quzg0zzF+Xl0YWb7zqetldk0ZviIpLtgmvx5yLmnOi2+q4" +
       "o4ita742qtbHwGS6xLYmM1VUI9cOkfbbm2Z1mfQ9HYWGriUMqS7tV+14jUls" +
       "vWeNNRvjmGnfa0/UnlsPMlKbduJJFyZGblXYLqfJ1KeimrZYrR0fhuWMDOx0" +
       "y6SpUK/7WYdeNYO6ba4b2gS0TQkEGRmxNEF9VIW6A2KjTgkXaVZMrY+P7Eyd" +
       "rkhojOGsKk4gh4XYCqGnFSl1usxgUybHkkwsWZKDV51tCiEY0WnpnTbrJIHY" +
       "lpvWYFFLqP5wuIZG3fVK0z0GceLaTK+tfV3tRxPdwMrjGRmiLRKZtInNlMC9" +
       "Vm1khCQzn296wgbOXL6WLMsLBmtV6t1KTKY+BKx37VqhJlYVbQaiKiUyUG3t" +
       "pht67VbMuo5lhARN5rV43G6qarMpJUMPQuBpX1akTnU0Jki5V26GYhUN0RGw" +
       "n3C4wvo+QmNSPCKhMokjCJquoAG6gOgYJxcKtagOOHLQRtktm2KCg2RCiKZb" +
       "rY+V5TFCwmoTCTrToVMNU6Whce3maIoTpjQbbjJ+opYTbaCSUgcSYs4OkPq8" +
       "1++FgWbLdTzmYMrm4D4xmC/KXXgSLKswhsY1dAZVNW00HDY82UKhVaWBWBVg" +
       "VeUaBE1iSvf45rzKlh1H8MqcS1oDnO9VNXuK0EN8Tok9VKkiutqFKWQbTqBu" +
       "ZyWNKBNERBV4qDFaIEINYlFtYlnUaonjHkFUJxXTH8txkyFMX+uj9FSBqsBl" +
       "QeRwKXEtUZ6v26E1L4OuKrc6ps8SzNrDxshI1YdJKlmOvglWVdkP61a4iMKq" +
       "LyNrLkCGMNmsLEe16pwk1FZGIjjVGbHesIWNpmQdGUeczUmd0MaW5mhUYek5" +
       "6gXooF1vwSgxmWfoapXEAlLXsjKvDzlkSLCuNFkhLQebLG0MGqrbiEnkro8x" +
       "lS3XFueLVhlZdSCdG23HTZzL1gs6TipODzWmIqZmSx3NzJGm1zkKw2u+ElR1" +
       "b9aRLJusukZlrCuK4DaQZVeyqqywknurbkPO6qCuTieNqbIdcp06KSxGkVVd" +
       "irOEEDDZ3uo9j4aFigAUXNuEZGbiEjrQGmsXpUSN38BhsNa2Rt1cDjhVouUm" +
       "VIsX3RE9tmFV3/bYMltPE2nNMDUB0avzsQ6tes2VStfB8D6V6DIWU1RPKg/Q" +
       "1sjSuEWoJBV9vVzEbcyYNJZqjWp6tVYT7lN6bRZvOwOpivoxum3qrXIjGySE" +
       "j0QSpzdxfpGs/VagtnXZ8CnEVTHeXZFJEvWUdZY0+w1066ccERAVWhy4hsE6" +
       "nKF2barmDAwoMX2R57OsAiMwqoXyYhAtFJfw1mkYpDNbTmsNfmEJYAgYINt1" +
       "PZTbTQhmwqWLizWmrCzpbtKFYhVjAjBd8x3G1t0YZkZ4vzkSiP4iVVok05a3" +
       "fQ9P9B66XWziJTSYINMgIBuqN03nsLXpl109sPwaFpbhgblSlLjNzoQxq0Rz" +
       "wrPWGIW0YqU3qUVyZnBxMmURVvP6LD1qYWtp0pG7IF4ta91oYTuqOWip1EZk" +
       "5+u4nXXgachPEFoV9TldQ5zJPJU9IdPbqSdnVSFcCoPubDWYdRVlY/INJBXJ" +
       "KoM3ltW1P9I3M70q00iVHzXCRcNIRLMTs8HWm1Nbazt05svVoJ/Ox9M1NfAY" +
       "dFoNhI3moK1uLGdletRjA8ceE7Yrr+ma7ltIm5pEeiRj7ZqhK120yQy1TiY7" +
       "mGSghNC2limpd8s9vIbXhsYkw3VGnlcHRKUNhhkk6+gMa5e1ba0aKMOl2kx6" +
       "sNwhLB9rEV5icmti3E01B4s8tDvAhqSOm/AwjOGRFo1qQ7KTzIbUoiMao+Zo" +
       "iK6A09mMUB6MIEktId0mNFxPu0HYHaQ9MZ3IfWIVDRx1zFayabOmbbXRYh1B" +
       "tMvTmZC0GKJVH7obtcPWK62xuwQqMt6CqVTN9eORhgQTo7nsyCNbgeNZj4vX" +
       "FjbqQ/ps00tA9Dtp0zAYWTNhvVYxqkM4ME+IJDrodQKDmXF0wpHWaJY0Fnyj" +
       "2qbxtCOM2wYRBmBKYCGIKDTVqo8pm8babisNlasbM5QKGzJeHWBJV+xuOps+" +
       "Ho/EhAUGB1MOaRBjAuvqajVoMxJuKBgBMSLT0dsrfLqdsaaL180K0RtMMWSL" +
       "N1cEML/Mg5llXNciZLaOKKFC0mBE30hYpvcZxSITgXfx6Wylz+uhCVck3p66" +
       "q021viDqkTLXetJC4Hnb97tzVY6GZtBAWr5URokFnCYIMqfmww7cpNS00YwX" +
       "kh3A0AKKx5Vqp5HGAhXLizaNEMF80FrGg4U2avRmvodPFVfCp3yHZjBuEw4W" +
       "1kbioai8bgWEotaNbVydjWuTCZ3VwwaqRJA09+E4oGJF8MAUGyrPOLdeb417" +
       "C8ehFkESVAjWQGtRayyqA3KOJl5IUHqMLCQ0QmqL3qKWteRuqKyguSPWEn3r" +
       "LVsTN5Wq1W03bazUpCIR0savhHSEr80K0kxG8zYMZgMQsiFcuWzpTRSnve5c" +
       "M7l+K1UyNrUHclKfBsOsPDSWJse0O56MNRKdqERQj8DluC4NIGFamRPouBt2" +
       "qsgAy8IMzA+4pAzsRpxKsCZzgzLPebTmUZ16BZWkcMm3yaAx93Qm4i1+KMWw" +
       "4HpiRc4WchgH7IT018M2hBtETOKSBuw5nZfhrdTUpcWiOtkm4kIUtI3ULI/A" +
       "5KfXs6tzfjapOxbLUgJpOKu64bm6youN");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "nL3PfvuRf/6j//TZLxSnm/4vPFJ4MH5IAAA=");
}
