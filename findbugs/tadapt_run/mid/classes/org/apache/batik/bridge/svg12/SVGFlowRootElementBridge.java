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
          ("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" +
           "yO8q0z969x+873df/mZ+//A/wZmMs7cdAAA=");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYbWwcRxmeO3/EdvydxA5p4yTuJSJOeotJmwg5QGJjJ07P" +
           "8WGnETill7ndubuN93Y3u7P22cWkqdQmKiKqGrcERPwrFVClTYWoQEKNjJBo" +
           "qxKqmAr6IVoQPygfkZo/DShAeWdm93Zvz+cCf7B0e+uZd955P5553nfu8g1U" +
           "Y1uo28S6guN0xiR2PMnek9iyiTKgYds+AqMp+fHfnz9161f1p6OodgI157A9" +
           "ImObDKlEU+wJtFHVbYp1mdiHCVHYiqRFbGJNYaoa+gRap9rDeVNTZZWOGAph" +
           "AkexlUBtmFJLTTuUDLsKKNqU4NZI3Bppf1igL4EaZcOc8RdsKFkwEJhjsnl/" +
           "P5ui1sQJPIUlh6qalFBt2lew0A7T0GaymkHjpEDjJ7R73UAcStxbFobuF1o+" +
           "vP1ErpWHYQ3WdYNyF+0xYhvaFFESqMUfHdRI3j6JvoaqEmh1QJiiWMLbVIJN" +
           "JdjU89eXAuubiO7kBwzuDvU01ZoyM4iiLaVKTGzhvKsmyW0GDXXU9Z0vBm83" +
           "F7310h1y8akd0vw3H2z9QRVqmUAtqj7OzJHBCAqbTEBAST5NLHu/ohBlArXp" +
           "kPBxYqlYU2fdbLfbalbH1AEIeGFhg45JLL6nHyvIJPhmOTI1rKJ7GQ4q97+a" +
           "jIaz4GuH76vwcIiNg4MNKhhmZTBgz11SPanqCsdR6Yqij7H7QACWrsoTmjOK" +
           "W1XrGAZQu4CIhvWsNA7g07MgWmMABC2OtQpKWaxNLE/iLElRtD4slxRTIFXP" +
           "A8GWULQuLMY1QZY2hLIUyM+Nw3vPPaQf1KMoAjYrRNaY/athUVdo0RjJEIvA" +
           "ORALG3sST+OOl85GEQLhdSFhIfOjr97ct7Nr8RUhc8cyMqPpE0SmKflSuvn6" +
           "nQPbP1PFzKgzDVtlyS/xnJ+ypDvTVzCBaTqKGtlk3JtcHPv5lx9+lvwlihqG" +
           "Ua1saE4ecNQmG3lT1Yh1gOjEwpQow6ie6MoAnx9Gq+A9oepEjI5mMjahw6ha" +
           "40O1Bv8fQpQBFSxEDfCu6hnDezcxzfH3gokQaoYP2o9Q1TXE/8Q3RdNSzsgT" +
           "CctYV3VDSloG858llHMOseFdgVnTkNKA/8m7e+N7JNtwLACkZFhZCQMqckRM" +
           "SmlLVbJEsqeyvZ+Wxo8eGNKM6THDoIwpiE77+XScAdD8/21dYFFZMx2JQMLu" +
           "DNOFBiftoKEpxErJ807/4M3nU68JKLLj48aTovtg/7jYP873j4v943z/eKX9" +
           "Y2MkC3gYyMHpI4ygWeZRJMJtWcuME8CBtE8CgYBA4/bxrxw6fra7ChBrTldD" +
           "zpjotrKKNuAzjVceUvLl62O3Xr/W8GwURYGM0lDR/LISKykroipahkwU4LVK" +
           "BcYjWalySVnWDrR4Yfr00VOf4nYEKwVTWAMkx5YnGb8Xt4iFGWI5vS1n3v/w" +
           "ytNzhs8VJaXHq5hlKxkFdYczH3Y+Jfdsxi+mXpqLRVE18BpwOcVw9oAmu8J7" +
           "lFBRn0frzJc6cDhjWHmssSmPixtozjKm/REOyTb2WCfQyeAQMpBXhM+Omxff" +
           "/OWfdvFIesWjJVD1xwntCxAWU9bOqanNR9cRixCQ++2F5Pmnbpw5xqEFEnct" +
           "t2GMPQeAqCA7EMFHXzn51nvvXnoj6sORonrTMigcXaIUuDtrP4K/CHz+xT6M" +
           "Z9iA4Jv2AZf0NhdZz2Sbb/PNA/7TQBvDR+x+HfCnZlSc1vh5+UfL1t4X/3qu" +
           "VWRcgxEPMDs/XoE//ol+9PBrD97q4moiMqu/fgh9MUHqa3zN+y0LzzA7CqeX" +
           "Nn7rZXwRygNQsq3OEs6yiIcE8Rzew2Mh8eeu0Nxu9ojZQZiXnqRAn5SSn3jj" +
           "g6ajH1y9ya0tbbSCqR/BZp8AksgCbNaPxKOU9dlsh8menQWwoTPMOwexnQNl" +
           "9ywefqBVW7wN207AtjLQrj1qATMWStDkStesevunP+s4fr0KRYdQg2ZgZQjz" +
           "M4fqAezEzgGpFszP7xOGTNfBo5XHA5VFiAV90/LpHMyblCdg9sedP9z73YV3" +
           "ORAF7O5wl/N/tvLnJ9ljh8Ape91ZKIaGyzatEJqAzgh/X0/RZkb707vkuGLk" +
           "42QKeN2OD7Ivj8tZPDdWam54Y3bpkfkFZfSZXtGCtJc2DIPQDz/363/+In7h" +
           "d68uU3Vq3eY0aJmFtpQVgxHe+PlEtmfpVtU7T65vLK8DTFNXBZbvqczy4Q1e" +
           "fuTPG458Lnf8vyD4TaEohVV+f+Tyqwe2yU9Gee8quL2s5y1d1BeMF2xqEWjS" +
           "deYWG2niZ6O7CIAWlu8eSPySC4Cl8NkQTLw8miAZppOGK5+PKAZp1mdVVBgi" +
           "hEgpttZXwha340srsMkD7PFFilZDW6FohC8CXGxf4eJnqXmoD1Nu6yzNtb83" +
           "+Z33nxOYDPfZIWFydv7xj+Ln5gU+xWXkrrL7QHCNuJBwU1vZ4+4CR+0Ku/AV" +
           "Q3+8MveT782dibpuDlNUPWWo4kKzhz3GRPD7/jNWYQP7ChStXa4J87Kw+39r" +
           "7MCh9WU3T3Fbkp9faKnrXLj/N7yNKN5oGqFKZxxNCwA2CN5a0yIZlfvdKEjd" +
           "5F9wCjauaCJFNfybOzQpFhkUdVZYBDgWL0F5aHFaw/Kgl38H5RyKGnw5UCVe" +
           "giIQ7yoQYa8zphfkVk7u7AoaF/etQqScwfeIduhjMlxcEuxfGN75zwUetzji" +
           "B4OUfGXh0OGHbu5+RvRPsoZnZ/n1Em7Loksr8tOWito8XbUHt99ufqF+q4fP" +
           "kv4taBsHHpx03uhsCHUTdqzYVLx1ae/Va2drl+BkHUMRTNGaY4HLuogUtCQO" +
           "kOexRJD0Az868Uanr+EPx1//29uRdl4d3TLRtdKKlHz+6jvJjGl+O4rqh1EN" +
           "HD9SmEANqv2FGX2MyFNQx+scXT3pkGEF0Jk2HL34y0IzwzRmPyXwyLgBbSqO" +
           "staaou5yjii/bkDjME2sfqadc3aI0R3TDM4W2I17Ga8gN70X/37qsTdH4cyV" +
           "GB7Utsp20sXiEPzhwq8WLl2J1rUqlRgxTbeVjT7Ks2qanFa+wZ3+upBmEhRF" +
           "ekzz3wseP/2AFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8w53+gcP/N7rf+u5b+Zdtv8B8BMgdfwfAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Vo0qKTkutkeye0J/xNZweTSvYDFhde2Z731j7cGrbvo6J36xyzrCKv/dG986" +
       "f2Tv6VN8ZYr0U3Kl2z544eY7blQs9dhssYzow85rz/7qna23+MVachomj49m" +
       "J7ip1uoKlm748G9zqzBfblup0WlIvO6qlUd+t//Aqz1+UhkiNZm0sjsjh+L5" +
       "a4NqMzNosyxrw5c9sJvVp/DPB9cf8EJzwgfcrGa0ic3PRbndT10fxXxKfMvh" +
       "1uFAjpbpQBbBdUBY8gEXB/IMdyCYfK3QT7hJQ0yB0QLzEILy+UVjiqgo5UDy" +
       "D2Ui+TO4HhC6POCC5IeeSNykYS1hMG8HsU46ybZXsC+yqDaNb4+zubdInQ4O" +
       "zpXJwTxC/CLG8ztjvCwHL3hx4CoNvQkrUYOG5bTp5pEjBrgQqgyLMXK68eLu" +
       "H1bv3ZAdf9/E5Cl0Jx6bDY46gvtmvLnrK+99mzsX586Co7B88PD9nwYOHeae" +
       "hb/+WVLwBsYuw18B8aGY026xVytMouPd0/ueObHvPq7VjPyXGe3pTOrb//LJ" +
       "TwKPvfXjIjviFYp4hWfzM/jnGedI/mmZ4cxCCEsGedEKt2Xpm8VDAeKY/is9" +
       "qoKYMiUZSSUd1fRQOi4ztV926P7WOHQXS2r+W0T3dy27fbtQXTdpShq4ur1K" +
       "coi6KvzeOBSOiybjLgr/p6fCbtKUTOcKt2qUailXjf9rHBqL9XiFcz2e1fhD" +
       "T43dpCEg5BqH5YQ7wx+NQ9+EaNFtZ+L3nvq6ScPqDsYw+GFXXT8Zh65iF4X/" +
       "Furqq/DU1U0aRhtOoi2qkky7qeurHIe6Q6LBIRd1az3VdZMGU8DXrl2y12Dz" +
       "TfHQd9Rqd3muXfavijheytraZSXnZX2ZQea7vTdn7vvY3YePxnuOr8xOTK/B" +
       "Sohq+gpVHpZVW1Xz2GTgjHw3s9MC1p702pcuVrz+4Jy6wjeKWNMCl/eFy92n" +
       "QGcDz939H3OjNwzdVsarwoUO/M4qH9986sedV8Qe9LMDD3wLvOCgRL7Quvzg" +
       "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" +
       "/nHm/wBpCxrvIEYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV8C7Dz2F2fv/vtezf7Sja75LW72d1AouSTLVuWzRISS7bl" +
       "h2TLetiW0rDR27Il623Jogkh0CQDkzSFBUKHLG2HtIFZCNNCA8PALNOmwJB2" +
       "JkAf0IGElilQmg4pA7SllB7Jvo/vfvfeL3e/zfTO6FhX5/X7/f/n/M//HJ2j" +
       "F79Suj0MSpDn2lvTdqNrehpdW9rotWjr6eG1AYUychDqGmHLYciDZ8+pb/7p" +
       "B/7irz6xePCgdIdUerW8XruRHFnuOmT10LU3ukaVHjh+2rF1J4xKD1JLeSPD" +
       "cWTZMGWF0bNU6d4TWaPS09QhBBhAgAEEuIAAt45TgUyv0texQ+Q55HUU+qUP" +
       "lK5QpTs8NYcXlZ68vhBPDmRnXwxTMAAl3JX/PwWkisxpUHriiPuO8w2EfwCC" +
       "n/+hb3vwn14tPSCVHrDWXA5HBSAiUIlUus/RHUUPwpam6ZpUemit6xqnB5Zs" +
       "W1mBWyo9HFrmWo7iQD8SUv4w9vSgqPNYcvepObcgViM3OKJnWLqtHf53u2HL" +
       "JuD62mOuO4bd/DkgeI8FgAWGrOqHWW5bWWstKj1+OscRx6eHIAHIeqejRwv3" +
       "qKrb1jJ4UHp4pztbXpswFwXW2gRJb3djUEtUet25heay9mR1JZv6c1HpsdPp" +
       "mF0USHV3IYg8S1R65HSyoiSgpded0tIJ/Xxl9C0f//Z1b31QYNZ01c7x3wUy" +
       "velUJlY39EBfq/ou431vo35Qfu0vfvSgVAKJHzmVeJfmc3/7q+9++5te+tVd" +
       "mtefkWasLHU1ek79MeX+L76BeGvzag7jLs8NrVz51zEvmj+zj3k29UDPe+1R" +
       "iXnktcPIl9h/JX7wJ/Q/OSjd0y/dobp27IB29JDqOp5l6wGpr/VAjnStX7pb" +
       "X2tEEd8v3QnuKWut756ODSPUo37pNrt4dIdb/A9EZIAichHdCe6tteEe3nty" +
       "tCjuU69UKt0JrtJ94JqVdn/Fb1RK4IXr6LCsymtr7cJM4Ob8c4WuNRmO9BDc" +
       "ayDWc2EFtP/VOyrXMDh04wA0SNgNTFgGrWKh7yJhJbA0U4fDjVlBYG5Kdm03" +
       "YV03yu2Gvo7wIvpa3gC9/39Vp7lUHkyuXAEKe8Npc2GDntZzbU0PnlOfj/HO" +
       "V3/quV8/OOo+e3lGpTqo/9qu/mtF/dd29V8r6r92Xv2lK1eKal+T49i1EaDh" +
       "FbAVwIre91buvYP3ffTNV0Hj9JLbgHrypPD5xpw4ti79woaqoImXXvpk8p3T" +
       "7ygflA6ut8o5dvDonjw7k9vSI5v59OneeFa5D3zkj/7isz/4fve4X15n5vfm" +
       "4saceXd/82kpB66qa8CAHhf/tifkn33uF9//9EHpNmBDgN2MZNDOgUl60+k6" +
       "ruv2zx6a0JzL7YCw4QaObOdRh3bvnmgRuMnxk0L99xf3DwEZ35v3g6fA9X37" +
       "jlH85rGv9vLwNbvmkivtFIvCRL+T8z71H/7NH1cLcR9a8wdOjI+cHj17woLk" +
       "hT1Q2IqHjtsAH+g6SPe7n2S+/we+8pH3FA0ApHjqrAqfzkMCWA6gQiDmv/Or" +
       "/m9/6fd+7LcOjhtNBIbQWLEtNT0imT8v3XMBSVDbW47xAAtkg66Yt5qnhbXj" +
       "apZhyYqt5630/zzwTOVn/9vHH9y1Axs8OWxGb795AcfPvwEvffDXv+0v31QU" +
       "c0XNR8BjmR0n25nVVx+X3AoCeZvjSL/zN974w78ifwoYaGAUQyvTCztXKmRQ" +
       "KpQGF/zfVoTXTsVV8uDx8GTjv75/nfBUnlM/8Vt/+qrpn/7SVwu017s6J3VN" +
       "y96zu+aVB0+koPhHT/f0nhwuQLraS6O/9aD90l+BEiVQogpsWjgOgNlJr2sZ" +
       "+9S33/k7v/wvXvu+L14tHXRL99iurHXlopOV7gatWw8XwGKl3rvevVNuchcI" +
       "Hiyolm4gv2sUjxX/PQYAvvV8+9LNPZXjLvrY/x7byof+0/+8QQiFZTljgD6V" +
       "X4Jf/JHXEd/6J0X+4y6e535TeqMpBl7dcV7kJ5w/P3jzHZ8/KN0plR5U9y7j" +
       "VLbjvONIwE0KD/1I4FZeF3+9y7Mb3589MmFvOG1eTlR72rgcDwHgPk+d399z" +
       "yp7ksi+1wfWefVeTTtuTK6Xi5l1FlieL8Ok8+MZCJ1fz228CfTgsHNMIQLDW" +
       "sr3vy38D/q6A6//mV15w/mA3kj9M7N2JJ478CQ+MVPd3qfHsOabFtki2xfSK" +
       "Yh6JSnDRxnKf91orAm6gAhxAjVgAo6ICT7Af6YV1efoobmcE8xDJg3fv8KDn" +
       "Nrlvvl4gA3A9txfIt50jEOoigeQBkQftQt6dqPSagliHZnjxmF4e1zuFlb4k" +
       "1g641D1W5Rys3OWwPlBgpfqjznM422kNz4LJXxImDi5zD9M4B6Z0OZj3FTDZ" +
       "Dtkfj7izML7nkhhb4FrtMS7PwShfDuO9hRR7nT7Z48+CqHztEAuD+K3gcvcQ" +
       "1+dAXFwO4l18Z84zLf6os3Vv8BbNTbTrfOSUv6j/8SDNeX3QuiTTXBnhnmlw" +
       "DlP/kspojYjemH2OF5lO/sg5BTG4JMTcbiZ7iJtzIKaXg3g/1eH5Dvscx7SI" +
       "/og8C+X2kijznvfte5TZOSi/45I9bzZm2xdh/OAlMb4TXN+xx/iBczB++HIY" +
       "7xx22NE58D7ytcO7P3/6ZnB99x7ed58D72NnwwP+7d1e4EZgGNe1IwNr5NMt" +
       "3QTuyMjVgC8VlJ48x7Fh5aRYbnhO/fnJl7/4qeyzL+5cWUUG8+kSdN7K1Y2L" +
       "Z/nM5pkLZmfHaxp/Tn7zS3/8n6fvPdg7n/deL4yHLhLGoQ151bFTCBzC/OEn" +
       "T+ng45fUwRPg+vC+2g+fo4MfOUcH+e3fO7J3uSUrxL7H+sYz7R2/T3UK9qcu" +
       "CbsBro/tYX/sHNif/lpgvyYo2gswumuzmNrkbtMhheHLm+A/zZ5R5inC//iS" +
       "hF9fKh04u6S73zMI/9TXpCfgUgYRpa8vdvuZwHLAXHWzX1eD3//wl1Y/8kc/" +
       "uVszO+3jn0qsf/T57/mbax9//uDESuVTNywWnsyzW60sIL6qwJle13fPqKXI" +
       "0f3Dz77/Fz7z/o/sUD18/bpbZx07P/nv/voL1z755V87Y/HmqrWOTunks5c0" +
       "r48DM6nskl49z0f8xbN1UjoamRw5MK0173r9taYXT//5KVi/9DJg7V3X3e8Z" +
       "sP7lTWA9uIPFWuYiOhfY518GMG0PTDsH2K/fBNhDO2C4G0Wucy6yL7wMZPoe" +
       "mX4Ost+4CbIHdsgo3ThfYr/5MnAZe1znufe/fRNc94KOAkzTuZh+52Vg2k85" +
       "dr9nYPryzVp9Pli0bMtcnwvr918GrMUe1uIcWH94MxXmy+o9/cJG/0c3xbUz" +
       "YFeAi3I7cg27Vs7//++X87IeXdrq04dT+SkYkMBw8vTSxg4HpgcLPyBfy7i2" +
       "e31zCmTnawYJ7Oz9x4VR7tp89nv/4BNf+LtPfQnYzEHp9k2+egKM64kaR3H+" +
       "cuzDL/7AG+99/svfW6w5gkGG+cHOg+/OS/3Ly1F9XU6VKxb0KTmM6GKZUNeO" +
       "2P6zE3w+F5Vus91bYBt9g9arhf3W4R89VdvoREglZ+NMK4iNTBddlOi2YKdK" +
       "EbKZ4Wm/hnNTjMAwCWmLvbnaW3Wmmo5odWkR1T1vEztRuduukMstMxrPV1jK" +
       "V4c4OhbMidBfaWW43LEaus4aYxRfLyfVSpUMm+5o3ChLWEJp5eYgWyw3UN3z" +
       "vTUobx0h9rqMVuNYrvpY3Q8wI8Cwet3f+PIKbU4IWcKdNefNWZWIWs3YScj+" +
       "2jRWk5RfBrq3cmyyptstjEENhuLhWhjzGDzk/XVtqwjmdtRQVwKETqT2NG56" +
       "DMpF/kpYuo7TRLa9jj6wCFIJl51QEKZUEx1J1sIe1mWXE6CFQ3Ho0pQRrsMp" +
       "/EBwRxKPt1GJcM3BsCvK0mhFrnil15nNcNXR+O6oitCDjC7zMsXYouYIFQkd" +
       "cMKo5mWTEOdHgiCOFqnMB6xZ2Xpy3dPRoc+azHbYqobTdmNtjUwRthO8LVQN" +
       "34Dd2rYxHvEtWVoFXtQRJZYazUfLaWXWr/c4pVqJushUgKRYNXWPGNBeFA6F" +
       "UV/PlhN5UeZaZSecBvaEirxG4PFDbyRWwRjiiz4jikNB6dc26UCjfU7wCYXQ" +
       "+qIs+8tW5k5wTO6riJNWx9sWZJDzpDEcV0ebVMPl9WYAT4exCU8tscN18cDD" +
       "y5RdGeKhQ1TTGM82gybDl8fdZuh3+34wmDcZkRbKjjOQXLzTWHKm2chiZ5uM" +
       "LCR2CRV3UHIgqNV+IoSJmw5gXvBdYTFMRrYnjtX+2GjVWnI6nWSdRV/sRYTX" +
       "G85Xbi0bN/z5luyGVXPSnVCTOmCyoDRNkKY+gSMTcpR2p5ylt40Z3qhzE2Et" +
       "czjBBnTFTnxWRitDRaK40G3bdJra7iahCLPisCTe93haXUjLkdDZZPN5eeVX" +
       "YCa2ICxqR3W5Xl7DixaKmapQ6cFDjignRE8YbrXVpCalSWse2K5qrFgfNpo4" +
       "Q+CcjnJLeptlTTRVIaM5I8IMtiRdnA41Oou743FZ7Imh2vXQbXMzq0ojXPZY" +
       "F4kd00OMBbodhe6yP+N136xrXjaa9R2xG6LRWjeaKISW16jBQ15bIn1nKDmC" +
       "g/fKyEjmbE1AdEsoY/2FwK/0vsfYGrUdoaLWH2nbnq3w9BoWVx1foid1lpNE" +
       "yB8xYlUYcK2hR1izYDEvm6tIrzcprb/UlpDfWZF+jcMrKpIs4bRa88jJaixz" +
       "K3RIz1bRgJqZi257Ameiq2brLaGo6bY7r9SGbZGBsKmf0EELkWeh2DKT1GeX" +
       "fdecCvSWT7IxaboNeaKCdssPK2oXAlZH85cyN4QcwZgIqucjYZy0SL8NwU2j" +
       "PKT6W7XBr82kjlXHq3iKL7y55Mp2DcGRcZeW4bg7SGQdrcv9pGwknLqS5Tbc" +
       "QhIoaZrjBjzBAwZqz5hND51R47nLYirrEz2tRm5apKZF9Wxju0i1N9v6rTEj" +
       "sFt/oWNttzuZ8VN0Y0+pfpYI7bDCrHVrC0FCb8PxcGZqibRoBAMHSKVBiixj" +
       "9sXZCmLMJMqclZ/AbSVgeqt5pU+qBonZQR2uwdI8EAfJLFRxqkanHOMSG2ak" +
       "9UKtpXTrPgJjGMLwS2jLY4w6iWrhCi2rxJZnkWyCjpurgWERiDHolqW4jUFo" +
       "0PTwgUpSi2gYdpJWDaqBTkSuI02y4blpDQWyRajl/nbmOYNpJcam5e0IJwPC" +
       "oCFfzqBGbFp1w6S7CVGpjaw5NTAysirQUnUUsNModUkiY9vzJmT35puqF9RR" +
       "RyPV9arqKd1Ra12uCghek6fZjIjlwLNNu9u2/Z5K1prd3jqomXCE0Ezc7qzi" +
       "4UizaJkNa1S8IFwgxx5UgTAVMXrVTVdprsIFu2rQyRIvk+Z40K6tI7ZmltVa" +
       "ZKgt3I9bgzLpy1Gdx4ferNM3EZ8261y1qW7m87VTqalyjCNuA3R21tanQYjX" +
       "YUuPUBpbKxhSM7vzpQV1Okqv63T1kW7I0hQUveB60WTZJLG5F8Cerq/6WQs2" +
       "Ow3EVspbFRt3VAEXvXrFgfp0uNF8NkpkXopGMcysl9tUdNsqB0G0t/EcrJkp" +
       "9NyhFHQlyc0g0yho6cVzzwx74tyXslDjJW3VXpFoZaZjCoJOsmqNHhlSe8l3" +
       "E38mMy3Q0EZ0Y8uO7UGFh7GEb1SqaxkyNybGDRGfMzpja1Le0gsnnGVyLyHJ" +
       "cT0O4SyLql4LGDpTnnb7eI9ZqDOsvkbsTk2KqhvY2Mh8pVrN6jQkCfNO4IRG" +
       "R0JXYq29bvbFDRfIvUa9acCQV4E3jFmtzLfjOaTEmzTdqnC9yqZIA4KqRtdr" +
       "00xXZyGaXlTTRqMpzVCF1xsZNIm6NYrjyiIlpV4Sekroe2OvDVdGU91oeJRv" +
       "jGi2w1LpVFjSNZoJF8SSy0R+0MnmaxRiO1q7As/QabZCBawqzTazurINyQkW" +
       "hzyv89V5bQilSmiScW/Wd5vZpmmLUOKUa45qTikb6W67+oYgglRr8Rgh9TpV" +
       "nJ0J0XBSN+hpGFMyhQciRvr4arbSa1IzannDGWjB4+pAo7rsWJt0HNZZzLqN" +
       "PqWHVqCOTHk8nMxbirukshmNoMwYFekpQnGsMa9NvTmNYIMB0lnOWyMirUQa" +
       "N15mfZPkecnqWHUCZjW2wSW9+jZd1pshwtZ7MtVqZIE6IYa26bg9uS7KPWWC" +
       "a8RYnYw5lq5wLRmv45ap1p2aIY8rkdK0hTa9GUmzgbfgQm+22tbEvjMia2Eo" +
       "eyIVjiYpRVWjtUzqWIBak/HAbjkOLqOaq/gqtepWl7g/7DueQPS7I9GocpVF" +
       "5mNuOE18kuklUx9rcegoGkhIMiPHZFkbVgaJn3Q7vKI0PBIM32iQdthyb7Ve" +
       "bJ0qGZUVt1IfizXX7nWzXsDS4wBXeJks1wSqt1n3+HC6ETZUnMwqcR3BvLpu" +
       "6hayZSKItJhWQ9UknWo5M7wTtYE6Y0ZXdaZvDdwM5y1nocXLsqHopoL2uUrs" +
       "xhgt2q2RPVmRc1WJXHXYoOyWQbZnM8bv2UxL4uoKj4Deu231CJffMtMEY41R" +
       "Ve8Q6LibtpqrtRyh89aQrQvVaBMlMck25LHIupAiUkEv6nEMVxOXC77XasWT" +
       "reIvBNFqo5TZTrocIzsdi4sJeS6gRHmkjjikw08qUyzq21hcRaSJxCCcNQpT" +
       "xDWbnjZqNrGKo7uUXLWSWF64srZxKpEwrzQnm/F6ZWViWO3WGw2jsgkwLTZg" +
       "LEAUCMbCSjRLBba2FaoOutDhCjyPW92QqsSt2aQ9UdLRatbcVshyIE4U1Vob" +
       "vKcqiQ0hRMMeb7WynYg+N5l5K7tvTt2yP+RXcbTSt3p5AKcjKdF5biO2uwvg" +
       "zEtYtbLEVDJQNm59UK2n2ywghhtYI5uNuoHwm/p01JDEoCxUhzaSobWaLmKK" +
       "PQmb2iIMxcxNGmiQwZi/lpEqRE9ldeE6y1rTGWCWB1Q2tB2s1iCbmZ/hhmLH" +
       "Xnlm9zfjum8LGhTBcMvPKpCwWFkjySmHy3C5gChUro18Ohu54TYNElRthoPN" +
       "1IPbDN5UjUZnkCWmoQakXLbUKsMqa42vlI10ng4NerOoxN3W0lO8Ca7gGrDV" +
       "DbMzx+E+rW0J0RhWJzy2GACTiZcnVNbpU1tImC4t33RRob1tI4IF8eNab0HU" +
       "mTFBoH1d50bblQi6CU02eqFQq28VaR4S0NZvyyOlBmWxovXXk9o48+aDhE8J" +
       "mKDIRhYtN0TSo6qLtEa4o81kFQjimATG0UO9zhIPzIlvbil6Pqw3dCruVZRN" +
       "VWppRhPuoIRdHqR1pS3W6uYmcjbUOhhCzaaThXO0USdcDG80mHZznYjjni7r" +
       "CwWGZlMqwUMxTioNvCGTYhmpp9MtmE/GDJiGxfpY6W0YH5sume2c1KsePw4U" +
       "GKYGfDJkNsZ82V9urK7o1RYzI6Ph5ZrUtT7sOFJNTQmiE4J/O8MImXtOY9pu" +
       "6UMRtsKm7w5F2hIkjhO0isFOxlYti6ZNpM5gs3FvMueQAJqV+aq2RTBDiSZz" +
       "XvO4hV+Lg8pQda36cJPpY5wbW1tlSZlgrK0bhBINBX6sgrp8Qbbs+dJoBj3c" +
       "p5pzq6tmiF4xFm2+VtU8omOiuN9DxQmWpNBo0oQ68qgbSRBVXW/8OqcyfjsU" +
       "E4jszud8Q1rUUatbm8PdOPB9uC1UhLLMLqKxayH+arXFfD0Oen29PqlTeJ/V" +
       "KnJWnWoSTQqNNnDkkW0FaWe80ZtoTdbXqk48N+SNtVzo2yiQJW6+luag7+sy" +
       "tuG1NbbZiFVRZ9J1PA4a6ZgfwjjnLnzI9KY9T5rOKvMMIXlz2UuqYZMmKh5W" +
       "Rjw1ngYZVBts68lSH85GNGHDenfbRNYTUm1nzWqzVx0vR0mmTUM5SFxhDNM1" +
       "v9cEnTTUtWljojcput2uJtRmTJgshU3iTWZGkTyRVamP1vSMV1Z6kgrJDE10" +
       "MGlHyqS9tlcI0Pkodv10Vda07iYUdB3Mv2I2IY3K0Gl67SwgZ2KjHI48KqmO" +
       "mIXJ8BiSqSuPScZZN2QqfrcNldlhzYaMZbARJk2VQBKL3li0vRZnEwJzMDCT" +
       "pK3p3KaUralslnKisQTUnawTdVub9Rqhs3AbXRUvT91+fZbVdMVvGY7GomgF" +
       "GW8XXr9eI8ZhynEVpxJXlLrQNcbVTmvQYCpVcgEbPVBqPNDddtCkTUrUqCFe" +
       "xpEpqY/Efk8hXXkz5VIHseqSI9nSKjPt");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2qDsr9NVVZjA5VmWbSOnwyXKspWOBWRt9sxVFyZQYjWG2LkCy7EwbTV9x/Ko" +
       "uj5MN525uJQ0GsEzemZi83JCVcqQwKOW4vfpOdNk8HUwG3oRmJ0ntbZUXo7T" +
       "Jr2chgKucsm8I3gG68CE2VtBEcSxQymc0DN5sPW2PW9SDuho3JApol6XKziw" +
       "Gp2mTtth1hiH0zmudQasNqS7yEpaU7zGtRcVktlQiOgMeBoNtcDX+yYRMHzX" +
       "VO0qRgrosMWG1dYMKk9akMw22lHasSqhGnlwhyXJPgZ3zVrSciBspUxgSCNq" +
       "89aUlNNYSGRXJFftjiiWZ0S6mfltVkW0TpkZdRbLNWPX2vAWoUhbY3FkSbmT" +
       "xay3YU2UbzntSms75TtpjPfa7bQZRxAxNzr0Vgo3SWWyojV93tZSOsINyMXh" +
       "7UY0+jYadlgjiiduKGo1qtnY6mAmq/BTdzSyzBm+IAyiu/Qsqot3K+Jw09/M" +
       "RC6pDUfqRKl4LXXkZS2UD9flZJJMhHHL6k1HIqoQTkogBPBBBjjVaW7JsDWX" +
       "mi19xqCVNQl8/6VIGH6Ml3uMyPRX/FJNgIlxewNZiAfAZCQ9WlcHVq2RdcJR" +
       "ZyjQvG4Pm6ZUD8skUrdEeGih2bavt+p8iLQ8YZnE6IZ07UWIjBYoRLc7Da01" +
       "7FOJmcy3loFnBksb3aTqjnt21kMJbjZaeBm3COgFL+oLT/TZhtq3V40eyRj+" +
       "JEi8znyLGO02yCf10oWpSgrSJ5ZOZ6am8IycwEq8aDmIsu5mbgO1a/UNL2bS" +
       "hHAMgpGA+yEOWGmx7VRnhrzGcKu3NMz6hKEZu+qQgeVIvF5eKLK3sMd01a6K" +
       "sSJlNXyMJhyhQrNCRyO1qTdbbXhcziCymZB4F65NnbhNOwk1YjnK3ECSMyC3" +
       "7TaLTSC85laTYbXD92ibanT1WgMigJPANyeCs0mTYdbrx23e4romPlvCXK1n" +
       "2aDf1AixPjApn5ksW26TgWYr3xlwQn2Ab/qtGYqjHmM2m4HXY8OBQmkmEy+Q" +
       "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" +
       "vaWUv3DY1Ui9MtrY+yWn+L0hL/zxm9V2QqbTC2Qq5cEkKt0FFKuudkerTzZS" +
       "9lbFAnz0q8s90Bu+gXFLYvGPxjrtAoJGHjwHpiTW2ooIjmMCt/hSYXHMrZh9" +
       "n6T7vlug+0hp1+Cvxnu68WXpXrj86l8/vnsXcM4tzcEqKr3KkVc6brvqKh9X" +
       "DrvyU2d25fwLAteuT1tIxL4Fibwmf5hbqc/sJfKZV6YBnLX4cPBEQf0DF4jl" +
       "g3mwBWLJVxWPzjsWeY/5Zpfhm0alx847C59/ueuxGz7HufuEpPpTLzxw16Mv" +
       "CP+++N7b0Wce76ZKdxmxbZ/80NKJ+zu8QDesQiJ3F+H9XsHrI2d9cuDkeX3g" +
       "zhS/Of6DD+8yfU9UevScTFHpDuXoZcxh+o8BT+V0elBu8Xsy3SeAW3mcDhS1" +
       "uzmZ5Puj0lWQJL993jtslbWbfnGggtwwzqc72/jYiea3e13+8M20eOLF91PX" +
       "va4uvrN6+Go5ZvbfyvjsC4PRt3+1/undd+5UW87yJerSXVTpzt0n94pC89fT" +
       "T55b2mFZd/Te+lf3//Tdzxy+Sr9/B/i4K5zA9vjZH5XrOF5UfAYu+7lHf+Zb" +
       "/skLv1ecRf1/00L71wBXAAA=");
}
