package org.apache.batik.bridge.svg12;
public class SVGFlowRootElementBridge extends org.apache.batik.bridge.svg12.SVG12TextElementBridge {
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
      LINE_HEIGHT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        LINE_HEIGHT;
    public static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      TEXTPATH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXTPATH;
    public static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      ANCHOR_TYPE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ANCHOR_TYPE;
    public static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      LETTER_SPACING =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        LETTER_SPACING;
    public static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      WORD_SPACING =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        WORD_SPACING;
    public static final org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute
      KERNING =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        KERNING;
    protected java.util.Map flowRegionNodes;
    protected org.apache.batik.gvt.TextNode
      textNode;
    protected org.apache.batik.gvt.TextNode getTextNode() {
        return textNode;
    }
    protected org.apache.batik.bridge.svg12.SVGFlowRootElementBridge.RegionChangeListener
      regionChangeListener;
    public SVGFlowRootElementBridge() { super(
                                          );
    }
    public java.lang.String getNamespaceURI() {
        return org.apache.batik.util.SVG12Constants.
                 SVG_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() {
        return org.apache.batik.util.SVG12Constants.
                 SVG_FLOW_ROOT_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() {
        return new org.apache.batik.bridge.svg12.SVGFlowRootElementBridge(
          );
    }
    public boolean isComposite() { return false;
    }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        if (!org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                e,
                ctx.
                  getUserAgent(
                    ))) {
            return null;
        }
        org.apache.batik.gvt.CompositeGraphicsNode cgn =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        java.lang.String s =
          e.
          getAttributeNS(
            null,
            SVG_TRANSFORM_ATTRIBUTE);
        if (s.
              length(
                ) !=
              0) {
            cgn.
              setTransform(
                org.apache.batik.bridge.SVGUtilities.
                  convertTransform(
                    e,
                    SVG_TRANSFORM_ATTRIBUTE,
                    s,
                    ctx));
        }
        cgn.
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
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertTextRendering(
              e,
              hints);
        if (hints !=
              null) {
            cgn.
              setRenderingHints(
                hints);
        }
        org.apache.batik.gvt.CompositeGraphicsNode cgn2 =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        cgn.
          add(
            cgn2);
        org.apache.batik.gvt.flow.FlowTextNode tn =
          (org.apache.batik.gvt.flow.FlowTextNode)
            instantiateGraphicsNode(
              );
        tn.
          setLocation(
            getLocation(
              ctx,
              e));
        if (ctx.
              getTextPainter(
                ) !=
              null) {
            tn.
              setTextPainter(
                ctx.
                  getTextPainter(
                    ));
        }
        textNode =
          tn;
        cgn.
          add(
            tn);
        associateSVGContext(
          ctx,
          e,
          cgn);
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
        return cgn;
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.flow.FlowTextNode(
          );
    }
    protected java.awt.geom.Point2D getLocation(org.apache.batik.bridge.BridgeContext ctx,
                                                org.w3c.dom.Element e) {
        return new java.awt.geom.Point2D.Float(
          0,
          0);
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
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_DIV_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_LINE_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_PARA_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_REGION_BREAK_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_SPAN_TAG);
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
            org.apache.batik.util.SVG12Constants.
              SVG_A_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_LINE_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_PARA_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_REGION_BREAK_TAG) ||
          nodeName.
          equals(
            org.apache.batik.util.SVG12Constants.
              SVG_FLOW_SPAN_TAG);
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.GraphicsNode node) {
        org.apache.batik.gvt.CompositeGraphicsNode cgn =
          (org.apache.batik.gvt.CompositeGraphicsNode)
            node;
        boolean isStatic =
          !ctx.
          isDynamic(
            );
        if (isStatic) {
            flowRegionNodes =
              new java.util.HashMap(
                );
        }
        else {
            regionChangeListener =
              new org.apache.batik.bridge.svg12.SVGFlowRootElementBridge.RegionChangeListener(
                );
        }
        org.apache.batik.gvt.CompositeGraphicsNode cgn2 =
          (org.apache.batik.gvt.CompositeGraphicsNode)
            cgn.
            get(
              0);
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        for (org.w3c.dom.Node n =
               getFirstChild(
                 e);
             n !=
               null;
             n =
               getNextSibling(
                 n)) {
            if (n instanceof org.apache.batik.dom.svg12.SVGOMFlowRegionElement) {
                for (org.w3c.dom.Node m =
                       getFirstChild(
                         n);
                     m !=
                       null;
                     m =
                       getNextSibling(
                         m)) {
                    if (m.
                          getNodeType(
                            ) !=
                          org.w3c.dom.Node.
                            ELEMENT_NODE) {
                        continue;
                    }
                    org.apache.batik.gvt.GraphicsNode gn =
                      builder.
                      build(
                        ctx,
                        (org.w3c.dom.Element)
                          m);
                    if (gn !=
                          null) {
                        cgn2.
                          add(
                            gn);
                        if (isStatic) {
                            flowRegionNodes.
                              put(
                                m,
                                gn);
                        }
                    }
                }
                if (!isStatic) {
                    org.apache.batik.dom.AbstractNode an =
                      (org.apache.batik.dom.AbstractNode)
                        n;
                    org.apache.batik.dom.svg12.XBLEventSupport es =
                      (org.apache.batik.dom.svg12.XBLEventSupport)
                        an.
                        initializeEventSupport(
                          );
                    es.
                      addImplementationEventListenerNS(
                        SVG_NAMESPACE_URI,
                        "shapechange",
                        regionChangeListener,
                        false);
                }
            }
        }
        org.apache.batik.gvt.GraphicsNode tn =
          (org.apache.batik.gvt.GraphicsNode)
            cgn.
            get(
              1);
        super.
          buildGraphicsNode(
            ctx,
            e,
            tn);
        flowRegionNodes =
          null;
    }
    protected void computeLaidoutText(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Element e,
                                      org.apache.batik.gvt.GraphicsNode node) {
        super.
          computeLaidoutText(
            ctx,
            getFlowDivElement(
              e),
            node);
    }
    protected void addContextToChild(org.apache.batik.bridge.BridgeContext ctx,
                                     org.w3c.dom.Element e) {
        if (SVG_NAMESPACE_URI.
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
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_DIV_TAG) ||
                  ln.
                  equals(
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_LINE_TAG) ||
                  ln.
                  equals(
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_PARA_TAG) ||
                  ln.
                  equals(
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_SPAN_TAG)) {
                ((org.apache.batik.dom.svg.SVGOMElement)
                   e).
                  setSVGContext(
                    new org.apache.batik.bridge.svg12.SVGFlowRootElementBridge.FlowContentBridge(
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
            java.lang.String ln =
              e.
              getLocalName(
                );
            if (ln.
                  equals(
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_DIV_TAG) ||
                  ln.
                  equals(
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_LINE_TAG) ||
                  ln.
                  equals(
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_PARA_TAG) ||
                  ln.
                  equals(
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_SPAN_TAG)) {
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
    protected java.text.AttributedString buildAttributedString(org.apache.batik.bridge.BridgeContext ctx,
                                                               org.w3c.dom.Element element) {
        if (element ==
              null)
            return null;
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
        org.apache.batik.gvt.flow.TextLineBreaks.
          findLineBrk(
            ret);
        return ret;
    }
    protected void dumpACIWord(java.text.AttributedString as) {
        if (as ==
              null)
            return;
        java.lang.StringBuffer chars =
          new java.lang.StringBuffer(
          );
        java.lang.StringBuffer brkStr =
          new java.lang.StringBuffer(
          );
        java.text.AttributedCharacterIterator aci =
          as.
          getIterator(
            );
        java.text.AttributedCharacterIterator.Attribute WORD_LIMIT =
          org.apache.batik.gvt.flow.TextLineBreaks.
            WORD_LIMIT;
        for (char ch =
               aci.
               current(
                 );
             ch !=
               java.text.AttributedCharacterIterator.
                 DONE;
             ch =
               aci.
                 next(
                   )) {
            chars.
              append(
                ch).
              append(
                ' ').
              append(
                ' ');
            int w =
              ((java.lang.Integer)
                 aci.
                 getAttribute(
                   WORD_LIMIT)).
              intValue(
                );
            brkStr.
              append(
                w).
              append(
                ' ');
            if (w <
                  10) {
                brkStr.
                  append(
                    ' ');
            }
        }
        java.lang.System.
          out.
          println(
            chars.
              toString(
                ));
        java.lang.System.
          out.
          println(
            brkStr.
              toString(
                ));
    }
    protected org.w3c.dom.Element getFlowDivElement(org.w3c.dom.Element elem) {
        java.lang.String eNS =
          elem.
          getNamespaceURI(
            );
        if (!eNS.
              equals(
                SVG_NAMESPACE_URI))
            return null;
        java.lang.String nodeName =
          elem.
          getLocalName(
            );
        if (nodeName.
              equals(
                org.apache.batik.util.SVG12Constants.
                  SVG_FLOW_DIV_TAG))
            return elem;
        if (!nodeName.
              equals(
                org.apache.batik.util.SVG12Constants.
                  SVG_FLOW_ROOT_TAG))
            return null;
        for (org.w3c.dom.Node n =
               getFirstChild(
                 elem);
             n !=
               null;
             n =
               getNextSibling(
                 n)) {
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
            if (!SVG_NAMESPACE_URI.
                  equals(
                    nNS))
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
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_DIV_TAG))
                return e;
        }
        return null;
    }
    protected java.text.AttributedString getFlowDiv(org.apache.batik.bridge.BridgeContext ctx,
                                                    org.w3c.dom.Element element) {
        org.w3c.dom.Element flowDiv =
          getFlowDivElement(
            element);
        if (flowDiv ==
              null)
            return null;
        return gatherFlowPara(
                 ctx,
                 flowDiv);
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
               getFirstChild(
                 div);
             n !=
               null;
             n =
               getNextSibling(
                 n)) {
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
                    org.apache.batik.util.SVG12Constants.
                      SVG_FLOW_PARA_TAG)) {
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
                        org.apache.batik.util.SVG12Constants.
                          SVG_FLOW_REGION_BREAK_TAG)) {
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
        if (ret ==
              null)
            return null;
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
                    makeBlockInfo(
                      ctx,
                      elem));
                continue;
            }
            ret.
              addAttribute(
                FLOW_PARAGRAPH,
                makeBlockInfo(
                  ctx,
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
        element =
          (org.w3c.dom.Element)
            element.
            getParentNode(
              );
        java.util.List ret =
          new java.util.LinkedList(
          );
        for (org.w3c.dom.Node n =
               getFirstChild(
                 element);
             n !=
               null;
             n =
               getNextSibling(
                 n)) {
            if (n.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE)
                continue;
            if (!org.apache.batik.util.SVG12Constants.
                   SVG_NAMESPACE_URI.
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
            if (!org.apache.batik.util.SVG12Constants.
                   SVG_FLOW_REGION_TAG.
                  equals(
                    ln))
                continue;
            float verticalAlignment =
              0.0F;
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
        boolean isStatic =
          !ctx.
          isDynamic(
            );
        for (org.w3c.dom.Node n =
               getFirstChild(
                 rgn);
             n !=
               null;
             n =
               getNextSibling(
                 n)) {
            if (n.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.apache.batik.gvt.GraphicsNode gn =
              isStatic
              ? (org.apache.batik.gvt.GraphicsNode)
                  flowRegionNodes.
                  get(
                    n)
              : ctx.
              getGraphicsNode(
                n);
            java.awt.Shape s =
              gn.
              getOutline(
                );
            if (s ==
                  null) {
                continue;
            }
            java.awt.geom.AffineTransform at =
              gn.
              getTransform(
                );
            if (at !=
                  null) {
                s =
                  at.
                    createTransformedShape(
                      s);
            }
            regions.
              add(
                new org.apache.batik.gvt.flow.RegionInfo(
                  s,
                  verticalAlign));
        }
    }
    protected int startLen;
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
        if (top) {
            endLimit =
              (startLen =
                 asb.
                   length(
                     ));
        }
        if (preserve) {
            endLimit =
              startLen;
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
        int lineBreak =
          -1;
        if (lnLocs.
              size(
                ) !=
              0) {
            lineBreak =
              ((java.lang.Integer)
                 lnLocs.
                 get(
                   lnLocs.
                     size(
                       ) -
                     1)).
                intValue(
                  );
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
                int len =
                  asb.
                  length(
                    );
                if (len ==
                      startLen) {
                    prevEndsWithSpace =
                      true;
                }
                else {
                    prevEndsWithSpace =
                      asb.
                        getLastChar(
                          ) ==
                        ' ';
                    int idx =
                      lnLocs.
                      size(
                        ) -
                      1;
                    if (!prevEndsWithSpace &&
                          idx >=
                          0) {
                        java.lang.Integer i =
                          (java.lang.Integer)
                            lnLocs.
                            get(
                              idx);
                        if (i.
                              intValue(
                                ) ==
                              len) {
                            prevEndsWithSpace =
                              true;
                        }
                    }
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
                            org.apache.batik.util.SVG12Constants.
                              SVG_FLOW_LINE_TAG)) {
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
                        lineBreak =
                          asb.
                            length(
                              );
                        lnLocs.
                          add(
                            new java.lang.Integer(
                              lineBreak));
                        if (before !=
                              lineBreak) {
                            initialAttributes =
                              null;
                        }
                    }
                    else
                        if (ln.
                              equals(
                                org.apache.batik.util.SVG12Constants.
                                  SVG_FLOW_SPAN_TAG) ||
                              ln.
                              equals(
                                org.apache.batik.util.SVG12Constants.
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
                                        java.util.Map m =
                                          new java.util.HashMap(
                                          );
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
                int idx =
                  lnLocs.
                  size(
                    ) -
                  1;
                int len =
                  asb.
                  length(
                    );
                if (idx >=
                      0) {
                    java.lang.Integer i =
                      (java.lang.Integer)
                        lnLocs.
                        get(
                          idx);
                    if (i.
                          intValue(
                            ) >=
                          len) {
                        i =
                          new java.lang.Integer(
                            len -
                              1);
                        lnLocs.
                          set(
                            idx,
                            i);
                        idx--;
                        while (idx >=
                                 0) {
                            i =
                              (java.lang.Integer)
                                lnLocs.
                                get(
                                  idx);
                            if (i.
                                  intValue(
                                    ) <
                                  len -
                                  1)
                                break;
                            lnLocs.
                              remove(
                                idx);
                            idx--;
                        }
                    }
                }
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
        java.util.Map inheritingMap =
          super.
          getAttributeMap(
            ctx,
            element,
            textPath,
            bidiLevel,
            result);
        float fontSize =
          org.apache.batik.bridge.TextUtilities.
          convertFontSize(
            element).
          floatValue(
            );
        float lineHeight =
          getLineHeight(
            ctx,
            element,
            fontSize);
        result.
          put(
            LINE_HEIGHT,
            new java.lang.Float(
              lineHeight));
        return inheritingMap;
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
    int marginTopIndex = -1;
    int marginRightIndex = -1;
    int marginBottomIndex = -1;
    int marginLeftIndex = -1;
    int indentIndex = -1;
    int textAlignIndex = -1;
    int lineHeightIndex = -1;
    protected void initCSSPropertyIndexes(org.w3c.dom.Element e) {
        org.apache.batik.css.engine.CSSEngine eng =
          org.apache.batik.bridge.CSSUtilities.
          getCSSEngine(
            e);
        marginTopIndex =
          eng.
            getPropertyIndex(
              org.apache.batik.util.SVG12CSSConstants.
                CSS_MARGIN_TOP_PROPERTY);
        marginRightIndex =
          eng.
            getPropertyIndex(
              org.apache.batik.util.SVG12CSSConstants.
                CSS_MARGIN_RIGHT_PROPERTY);
        marginBottomIndex =
          eng.
            getPropertyIndex(
              org.apache.batik.util.SVG12CSSConstants.
                CSS_MARGIN_BOTTOM_PROPERTY);
        marginLeftIndex =
          eng.
            getPropertyIndex(
              org.apache.batik.util.SVG12CSSConstants.
                CSS_MARGIN_LEFT_PROPERTY);
        indentIndex =
          eng.
            getPropertyIndex(
              org.apache.batik.util.SVG12CSSConstants.
                CSS_INDENT_PROPERTY);
        textAlignIndex =
          eng.
            getPropertyIndex(
              org.apache.batik.util.SVG12CSSConstants.
                CSS_TEXT_ALIGN_PROPERTY);
        lineHeightIndex =
          eng.
            getPropertyIndex(
              org.apache.batik.util.SVG12CSSConstants.
                CSS_LINE_HEIGHT_PROPERTY);
    }
    public org.apache.batik.gvt.flow.BlockInfo makeBlockInfo(org.apache.batik.bridge.BridgeContext ctx,
                                                             org.w3c.dom.Element element) {
        if (marginTopIndex ==
              -1)
            initCSSPropertyIndexes(
              element);
        org.apache.batik.css.engine.value.Value v;
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              marginTopIndex);
        float top =
          v.
          getFloatValue(
            );
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              marginRightIndex);
        float right =
          v.
          getFloatValue(
            );
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              marginBottomIndex);
        float bottom =
          v.
          getFloatValue(
            );
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              marginLeftIndex);
        float left =
          v.
          getFloatValue(
            );
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              indentIndex);
        float indent =
          v.
          getFloatValue(
            );
        v =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              textAlignIndex);
        if (v ==
              org.apache.batik.css.engine.value.ValueConstants.
                INHERIT_VALUE) {
            v =
              org.apache.batik.bridge.CSSUtilities.
                getComputedStyle(
                  element,
                  org.apache.batik.css.engine.SVGCSSEngine.
                    DIRECTION_INDEX);
            if (v ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    LTR_VALUE)
                v =
                  org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                    START_VALUE;
            else
                v =
                  org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                    END_VALUE;
        }
        int textAlign;
        if (v ==
              org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                START_VALUE)
            textAlign =
              org.apache.batik.gvt.flow.BlockInfo.
                ALIGN_START;
        else
            if (v ==
                  org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                    MIDDLE_VALUE)
                textAlign =
                  org.apache.batik.gvt.flow.BlockInfo.
                    ALIGN_MIDDLE;
            else
                if (v ==
                      org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                        END_VALUE)
                    textAlign =
                      org.apache.batik.gvt.flow.BlockInfo.
                        ALIGN_END;
                else
                    textAlign =
                      org.apache.batik.gvt.flow.BlockInfo.
                        ALIGN_FULL;
        java.util.Map fontAttrs =
          new java.util.HashMap(
          20);
        java.util.List fontList =
          getFontList(
            ctx,
            element,
            fontAttrs);
        java.lang.Float fs =
          (java.lang.Float)
            fontAttrs.
            get(
              java.awt.font.TextAttribute.
                SIZE);
        float fontSize =
          fs.
          floatValue(
            );
        float lineHeight =
          getLineHeight(
            ctx,
            element,
            fontSize);
        java.lang.String ln =
          element.
          getLocalName(
            );
        boolean rgnBr;
        rgnBr =
          ln.
            equals(
              org.apache.batik.util.SVG12Constants.
                SVG_FLOW_REGION_BREAK_TAG);
        return new org.apache.batik.gvt.flow.BlockInfo(
          top,
          right,
          bottom,
          left,
          indent,
          textAlign,
          lineHeight,
          fontList,
          fontAttrs,
          rgnBr);
    }
    protected float getLineHeight(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element element,
                                  float fontSize) {
        if (lineHeightIndex ==
              -1)
            initCSSPropertyIndexes(
              element);
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            lineHeightIndex);
        if (v ==
              org.apache.batik.css.engine.value.ValueConstants.
                INHERIT_VALUE ||
              v ==
              org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                NORMAL_VALUE) {
            return fontSize *
              1.1F;
        }
        float lineHeight =
          v.
          getFloatValue(
            );
        if (v instanceof org.apache.batik.css.engine.value.ComputedValue)
            v =
              ((org.apache.batik.css.engine.value.ComputedValue)
                 v).
                getComputedValue(
                  );
        if (v instanceof org.apache.batik.css.engine.value.svg12.LineHeightValue &&
              ((org.apache.batik.css.engine.value.svg12.LineHeightValue)
                 v).
              getFontSizeRelative(
                ))
            lineHeight *=
              fontSize;
        return lineHeight;
    }
    protected class FlowContentBridge extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildTextContent {
        public FlowContentBridge(org.apache.batik.bridge.BridgeContext ctx,
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
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "+Q/e/juvfLW4u/gfNPhI1dcdAAA=");
    }
    protected class RegionChangeListener implements org.w3c.dom.events.EventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            laidoutText =
              null;
            computeLaidoutText(
              ctx,
              e,
              getTextNode(
                ));
        }
        public RegionChangeListener() { super(
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
           "5/kjG574H8CdhTkXFQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "YMZwyXY4aY1nItavINUpq0d0SdlMBiUrmC3Qtq9k1QrSROhGlOil9pacT9dt" +
           "x6ambA1ttfqN0szokf1hieQnZR9FSXYAzxrhaEVPTUE2gkqwnc5lfdKIe4zU" +
           "dToiSdfGtCRofdbUMsEiauiyQ7NLLuspZkn3aHri04jCTyTMb9sitsJoaWLZ" +
           "/YSftofkMhwsrBWLlPuMTyWUwtABijQWzNT1h2i06pdrAYujZWM8bmWN6YRP" +
           "VKrETbB+ZtVLpRY3TyYTPtW72wjlIiOhDWZbq80GvDuI+DnrIgaaCqV5acw5" +
           "qVQqRSzuKjh49VO9lTvvi+J21HBpojOlm4bUHC+1Zccn3TbsWggZE8i2VTFC" +
           "tNwhx+teI1QszpLhaCHEithCm6zaVGtxNTAVZjPj9XJ1s2i0YY+K+5YsiYpv" +
           "UxOszsEUxiOhZVu8Nms628S2ytURzPKzSlvgWb7RbNFuz/W58qZrwKXEa7vc" +
           "RKeVtkBUUaGc8qTJjFqcu0V5t+GKcwCZLmfxjso4Agdzci9N/BlnIeumxxNs" +
           "m6vjG3uqrGnTaY+r9XJEp+XMSAy7Xp6HPapeMuoYryQ1lDV6W3ba8kN1RtYQ" +
           "rBqsByEix63hoNLtDst4U1lmGWNota0yapS7M4mLgLw57RlUqaSFCti92by/" +
           "GGMAgBv1makyQpnM7JomqEKWkKM1eC9W9T43qxouDNCrGhjwFiORqZdQ22Dc" +
           "LU3CLIPLveZaw1Ni3hBLJCkS/aCLt+Np2DIHWckSeAnddGRnHNdGXY6UA0vh" +
           "x2LdmyFiF+33PHqS4owcIapYxdHhkE/YCE3JALUaNMH12EwZmf2NILcIBt2E" +
           "tNozk6qddd2UmbW4oUtpSzPjeS1RSLWFjpubIcd7dWS9nKdtEWShtYoOZxHq" +
           "WeaMhGG2s8raw5SxK0Op11/WXbeSKTOOGvYsounJA7PJy52S1JJm5GBpNKpY" +
           "pQ7bS6reqNFNXFuM7RnI6tv5ceINP92J7t7i8Hp4HQEOcvkA9VOcZNJbTwgO" +
           "1heD0I/B4V3X0sNKXlHTuPtFKnnHqh1nDk7Qj+XV3U1V3dd8d19f614c7Xfy" +
           "n4OSbX6+e/h29xTF2e4Tb3vmWW34SWTvRjlpCo7zN66Pjk8YQk/d/hDbL+5o" +
           "jmocX3zbvzw0ft3iTT9FFffRU0qeFvk7/ee+TL1a/eAedPaw4nHT7dFJpmsn" +
           "6xyXQj1OQm98otrx8OH6X86X+ymw7l+/sf5fv3Ul9dZ7WjjRznVOlerOnNyx" +
           "B2+3YwXz+kXqfFnerGLoJQvZ0xy9YCoI+WOOKIID9xocho88NPxJZ+0TJbUY" +
           "etmtKv8H2qP/u9sE4D0P3nSlubuGUz/z7OULDzw7+euidH54VXaRhS4YieMc" +
           "r1Md658PQt2wimW5uKtaBcXPO2Lo4RdVMYbOFb+FQW/fMb07hh64DROIhV3n" +
           "OP2vx9CV0/RAbvF7nO79MXTpiA6I2nWOk3wwhs4Ckrz7oeAWZbFdjS89cywU" +
           "b8BKsbf3/aS9PWQ5Xo7Pw7e4hz4ItWR3E31d/eyz3cGbX0A/ubsOUB05K5zu" +
           "AgvdubuZOAzXx28r7UDWefrJH93zuYuvOsCVe3YKHwXRMd0evXW9veMGcVEh" +
           "z/7wgd9/7W89+82iSvc/0tzQuSAgAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "XUgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "12k7hLBZiOwW5e2eNEdlQsemFj2dqikO");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Oz69ddp0t8W4rWQ+ENoaulpWdE2wUpweexsF+EUx9eCu1DYUD16VkXkMhdrE" +
       "HtS9JBAHLTUNUXjdlcczQ+kSTriQw5DpLWUWniSe1ZDYQcbpqb+tur4suCaO" +
       "k0EbTSN2jk/raDZbtKqmp1QGq7pdQSO6wVtOW+4a/FT2aFLAg20gtrPaEMlW" +
       "NSockrTenHSgLgRUOE3n3Nia+9sutNlm/hBE5sC1aclY3eBjaDhew/S0HDDB" +
       "qtckBWzrKGRK+62MpsVWhUabCtuazftCNqtNaz1Yg3R8Qwm6znLNVn2gDwca" +
       "zCgzcYDWhoawZhfrrj2qMBLwjgupEk/guayjgySilkBpqG5QRKMsQGURs4PE" +
       "M1KZoseORqxlo8EbDrc1/YlVoeOINzYLvYeZmLBOdJhpZMR0a4+nmsiaw7U3" +
       "HYxbiEUMYMRQFnW6148H5cDxl+imTnQrHYLJWsRmnlGoJNmTdpdraiTCdxAO" +
       "bQdmux9taNFchLWesS7HaNaz6bVlD+sTgydpe7v2mn7kLpVpi56Jaivo4NMo" +
       "hiaNdBStFRwa1mGylgyWjNukXLa7bHZEWofjMT6ZSDxpYcOeFg/jIERdpi1D" +
       "7NabsNtKRzA3dFmnarEGOu9WvTJzEQRR2gHdV7sqxKbDwFKwZb8/HjW0sCc6" +
       "rI144srv2KbehzplO2tlckAJi2Qx6tVkbcNwUz5ZyKC96QI8XbiLhbatzFl9" +
       "w3eIZAFVUKVNrjplZ9Vq5+W8RFF79VDbaOPYoXkRbw6ZOF7O0l4Po1p+VYoa" +
       "CE80mhNSrGLjzpzfyPqUTFRitEVM2WeljSKO8mEwU1kJowYh8TVl1Z1KtXpS" +
       "ayxkwSZlhUCaPkW0RIl1opTlIsjlYXMCb7ZQ7CYqu3Th6pCWDb3bAWMNrYOr" +
       "ajormwLvs0uqu5qVpx6ehKltheUpa/prT6Wlud6ECTqNNoHEWKkDxp/iEuPn" +
       "tSVJWd0Wlo6TbtMSYEduUGOvpZpcm2FArFlGrSTwuL4y7VRdVJ6mBLWYL2yc" +
       "aw4rcae2iWFXT+tU1Vc4ScXMll7z0XJ9CFXDhJyDzt5wSEivCrg20GozVuHq" +
       "MFWWNHHltdK5DffNpMG4Fcsf+eWq325jZWAUkeLF5XKj3Ek29ZZTaaYcExse" +
       "jkIDV2+hGBgdhPSUsWpdUkfmq4jzp/0RVt3q8DqetyBe9SCtBq/AGF2YKAHr" +
       "EOqqt25pWTYOy066xprstLMFDWRYTtLGSKBxs2H2oqUtDPtbs221G/JEcbBA" +
       "jRes1qlhMxuFysxwTsquLkOaB4avZGxHU7HvaEZFlGgONCxvpdW0tYD3rE23" +
       "T6nAa1ezUFlpVDUiy52G1eiL2hCCRkG1rXBc3eARwxyOGxTaguX6pLUdlCdL" +
       "yJ95OoJWMYZOYBBQyVZqQYZnC1IES4RMDlzGmvTFMqn06yrw2AsWsRLPaSxX" +
       "ja4VjIkhxyyGXcNHYdmmlQZWl3s1bOBRJCZVgHGSzHoMjTg18WwGM8ZKG4RH" +
       "lJUyadWmVqRTXzfTlsiso8ANK7AIRZLqiAmVdkBr6a5BqDqclDEss9nlpAw1" +
       "k4HPSLAEgSGLRtWILTcJgkVMLiqB7LeWS6ZPOlxiUi5PzwUwlBZFzkagqtFp" +
       "rVETSgJrwaAW5Mj2MAmMoaowFtHqLcqOh8IjPS2Pw7SLJuOGzooCKppIsIbs" +
       "9piuuMNxqK5W62UMR2TEZgIKZWYXYgTOWQ8wrqmXHb9m8GwLNVqeQS5a1kip" +
       "l9tiFq9X3JJE8Wlluh5WVn4i8GpGCN0q0Zr1KyBmHxgZ1OWbFaY7oeaDsUdy" +
       "1eG6MaLteYv3lqKrSeYcUkNK50bmpBEpU3q6bvZn5XHF4jCakP32UKiwnt9D" +
       "mGQuKlVoUt5iVXfWF5eTJjJEJtAsaaoCbXqZMEzStUlyzNLkenAi1ByJljVI" +
       "1SGG20CBUwn7brPt9OMIZqwVUa5mvBdvVx4mB60Y9J5+u+GxQdjaSLV5QPRh" +
       "ddo2pNEiimctaa3V0+GInGKrpDzIJLmCtHiImcs9Gmo3AnY81xNKHs/TtKU0" +
       "RQsMPZHa2JTEjs3AlLhsesRwMWrDo+22EcRNuem1WkkjbPZjMTXK6Lw81HR7" +
       "WUZA2GRv2guNzFChJtctdNCaC/KQXfXUqKdrfmu12iy7ZVgzF2IfOH3e93Fe" +
       "x4M2EQzH2yreLXezIKxMoGxMmKTQHDBRbV7WvA6FuzWy0lAsWA4gwwHqry5Z" +
       "jYbhHhPZ/dTEDJbDVFOz67TgEh1HSmsaYfjW2FQnZLtN9/tKOnTrqtKjmqi8" +
       "JtYbPSWgJeK784nR6XTe8Y6g9L4rVy/32uih4g3Z0Y6mld3Mb/zJJd4M7ZeQ" +
       "5ckzR68Si787Sqd2wZx4lVjkfGz/2jAKS288b6NSsUDhRz7w/Asq88nq4Zqf" +
       "n4lLd8ee//W2ttbsE1W9HtT0tvMXY9DFPq3jhdC/9IH//jrhm5bvucT2jsdP" +
       "4Txd5Y/SL/4K/hblew5KV4+WRd+wg+z6Qs9evxj6nlCLk9AVrlsS/cYjyT6a" +
       "Syxf8fXhvWQ/fPol7bHuLlzCUtw7cz3/la+54N7r8+Q1celeQ4tPLkL6R0fW" +
       "cuWRm71HPFlnfuHKQ0f0Hs4vPgmOH9jT+4HL0vu6m9J75oJ7X5snT8SlBwC9" +
       "EVBK5EuKNuEGRas4pvjkrVJ8Ezhe2FN84ZWnWL3gXj1P3h6X7gMUwbBIskd7" +
       "4zvB7+tvld8bwfHJPb9PvvL83nHBvXfmSWtnoYdt7PCF/5vOW4m2W3F2LID2" +
       "LQjg1YcKfnEvgBdfeQGQF9yj8wTLV6xE+dqHfLOUdtYagDtlz7M1yT1mjd8C" +
       "68fyi28Dx2f2rD/zyrA+KDIcHGrwmYs1uN9ffJj71XnutK5cUz3n2n5xYSEj" +
       "8QL5vSdPJnHpYSXUpFjDQ8lfmkp0clHmk2cuyrwhZyHU6S0I9fX5xRo4vrwX" +
       "6pcvK9Sbe3v7gnv5FrsrRlx61NxtAjJPySO/LR9TXd4C1dfmF3PP/1d7qn/1" +
       "ylDd20/+sHflybsLYpsLSGd5Eu0cSO4gj0ICoPhHivU7UhpfMzRgUqxnunGt" +
       "dyyB+FYl8BQgc2VXdvd76xK4cpRhT/6DF5D/cJ58e1x6lRnl3fu+zeQXmWOW" +
       "H3gF9Hzlvj3L+75KLL/nApbP58lHCheZs+wuTVs9xfGmK8Av4Fjsg4UBmif3" +
       "HB+/LMezfeHVo1h+b8tF+ysYvXAB23+YJz8Ign05ATxv8FKnuoXb1p6pHsvh" +
       "H9yCHIol121Aid/LYfzK6PoCOfz4BXL4dJ58KnfsoFtMYo2STNVLijA2v/OP" +
       "j0n/6K2SRgH+/eLhKzcsHn4lHdnPXsD35/Lkp4DeJVXdd4yCd2TrJ+j+9K3S" +
       "xQHy79jT/Y6vJt3PXkD3l/Lkpbj02lBzvPVhKICFnnMW51+8Bc6PH7bvH95z" +
       "/uGvJufPX8D51/Pkc6BfKpr28e633XLWw17rdWdtUD2RpRDIv71VI6gDbvuQ" +
       "98qlQ96bOvV/X/D9wgWy+N08+S3g1NXE8TvdwcwLTyv9P99qx/W1AM1n9xw/" +
       "+4pz3On7jy7g+KU8+W+gSYPYJN800zPXJ7rodx8z/f1bNe+3Aky/vWf6219N" +
       "8/7zC+j+7zz5X3HpnmO6hS0c8/yTW+X59QDy7+15/t5XkefB1fN5HtyeZ/vr" +
       "uHS/IcVLLcyp5vNOp7j+za0OSsGo/OAbd2V3v18trg9cwPWhPLlnp9PdDq+o" +
       "yPe913uThy/CeujY7j/5RYji6xkHjxzJ6+DeW/VoGHj2ZI9BeGXkdVuR4bZj" +
       "eZ0Vgt2u254Un5JKOwfwjhOIJmcgOnikSIrTxy9Qwlvy5HVx6cGdwe30MNh9" +
       "1eiEwzx4/a2K8BsA0M0e8A0bpV+eCO8sMtx5LMLgKHJ/JN5/8KPYYTEAAYCx" +
       "34Z4LMcCcRXAWe9h3bA5Ok+LDaEfP6y0e96sAz/FTwyT9vsWT/exaKLrZ8Oo" +
       "nZDO5ibqrFygznxnxkEZdPS6adtnP/6UYt/+CkzSXn3Hruzu99YVe3uR4fZT" +
       "bQOI/83n7/nPpc/uvsB1UD0l4nyavPQMwNfZ4+ycr+lCjL0LRDzMk3fuZoaP" +
       "JExL/lm+66GbyeaEdRXauOknQG7WzN5Syl847J5IvTLa2Mclp/i9Ia/88Zs9" +
       "7YRMpxfIVMyTcVy6CyhWsXZbsU8aKXerYgEx+tXVHugN38y4JbEER32degFB" +
       "PU+eA0MS0zXjLs+zoVd8vbDYFleMvk/Sfc8t0H2ktDP4q8mebnJZuhdOvwbX" +
       "9+/+BZxzT3NgxaVXOZKlobanWHm/ctiUnzqzKedfHLh2fd5CIvYtSOQ1+cXc" +
       "S31qL5FPvTIGcNbkw8ETBfX3XSCW9+fJFogln1U82h9ZlD3mm12G7yYuPXbe" +
       "3vn8S1+P3fCJzt1nJZWfeOGBux59YfIfi+/DHX368W6qdJee2PbJDzOdOL/D" +
       "DzXdLCRyd5He7xe8PnTWJwpO7u8H4Uzxm+M/+OCu0HfFpUfPKRSX7pCPXsYc" +
       "5v8IiFRO5wf1Fr8n830MhJXH+UBVu5OTWb43Ll0FWfLT5/1Dq4Rv+oWCau2G" +
       "fn6z842PnTC/3evyh2+mxRMvvp+67nV18e3Vw1fLCbv/tsanXxiOvvXLjU/u" +
       "voun2FKWT1GX7qJKd+4+0VdUmr+efvLc2g7ruoN461/e/5N3P3P4Kv3+HeDj" +
       "pnAC2+Nnf4Su7/hx8dm47Gce/alv/Kcv/E6xd/X/ATFMRyoUVwAA");
}
