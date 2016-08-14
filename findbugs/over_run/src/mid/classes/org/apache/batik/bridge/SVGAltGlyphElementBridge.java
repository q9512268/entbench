package org.apache.batik.bridge;
public class SVGAltGlyphElementBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.ErrorConstants {
    public static final java.text.AttributedCharacterIterator.Attribute PAINT_INFO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PAINT_INFO;
    public SVGAltGlyphElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_ALT_GLYPH_TAG;
    }
    public org.apache.batik.gvt.font.Glyph[] createAltGlyphArray(org.apache.batik.bridge.BridgeContext ctx,
                                                                 org.w3c.dom.Element altGlyphElement,
                                                                 float fontSize,
                                                                 java.text.AttributedCharacterIterator aci) {
        java.lang.String uri =
          org.apache.batik.dom.util.XLinkSupport.
          getXLinkHref(
            altGlyphElement);
        org.w3c.dom.Element refElement =
          null;
        try {
            refElement =
              ctx.
                getReferencedElement(
                  altGlyphElement,
                  uri);
        }
        catch (org.apache.batik.bridge.BridgeException e) {
            if (ERR_URI_UNSECURE.
                  equals(
                    e.
                      getCode(
                        ))) {
                ctx.
                  getUserAgent(
                    ).
                  displayError(
                    e);
            }
        }
        if (refElement ==
              null) {
            return null;
        }
        if (!SVG_NAMESPACE_URI.
              equals(
                refElement.
                  getNamespaceURI(
                    )))
            return null;
        if (refElement.
              getLocalName(
                ).
              equals(
                SVG_GLYPH_TAG)) {
            org.apache.batik.gvt.font.Glyph glyph =
              getGlyph(
                ctx,
                uri,
                altGlyphElement,
                fontSize,
                aci);
            if (glyph ==
                  null) {
                return null;
            }
            org.apache.batik.gvt.font.Glyph[] glyphArray =
              new org.apache.batik.gvt.font.Glyph[1];
            glyphArray[0] =
              glyph;
            return glyphArray;
        }
        if (refElement.
              getLocalName(
                ).
              equals(
                SVG_ALT_GLYPH_DEF_TAG)) {
            org.apache.batik.dom.svg.SVGOMDocument document =
              (org.apache.batik.dom.svg.SVGOMDocument)
                altGlyphElement.
                getOwnerDocument(
                  );
            org.apache.batik.dom.svg.SVGOMDocument refDocument =
              (org.apache.batik.dom.svg.SVGOMDocument)
                refElement.
                getOwnerDocument(
                  );
            boolean isLocal =
              refDocument ==
              document;
            org.w3c.dom.Element localRefElement =
              isLocal
              ? refElement
              : (org.w3c.dom.Element)
                  document.
                  importNode(
                    refElement,
                    true);
            if (!isLocal) {
                java.lang.String base =
                  org.apache.batik.dom.AbstractNode.
                  getBaseURI(
                    altGlyphElement);
                org.w3c.dom.Element g =
                  document.
                  createElementNS(
                    SVG_NAMESPACE_URI,
                    SVG_G_TAG);
                g.
                  appendChild(
                    localRefElement);
                g.
                  setAttributeNS(
                    org.apache.batik.util.XMLConstants.
                      XML_NAMESPACE_URI,
                    "xml:base",
                    base);
                org.apache.batik.bridge.CSSUtilities.
                  computeStyleAndURIs(
                    refElement,
                    localRefElement,
                    uri);
            }
            org.w3c.dom.NodeList altGlyphDefChildren =
              localRefElement.
              getChildNodes(
                );
            boolean containsGlyphRefNodes =
              false;
            int numAltGlyphDefChildren =
              altGlyphDefChildren.
              getLength(
                );
            for (int i =
                   0;
                 i <
                   numAltGlyphDefChildren;
                 i++) {
                org.w3c.dom.Node altGlyphChild =
                  altGlyphDefChildren.
                  item(
                    i);
                if (altGlyphChild.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    org.w3c.dom.Element agc =
                      (org.w3c.dom.Element)
                        altGlyphChild;
                    if (SVG_NAMESPACE_URI.
                          equals(
                            agc.
                              getNamespaceURI(
                                )) &&
                          SVG_GLYPH_REF_TAG.
                          equals(
                            agc.
                              getLocalName(
                                ))) {
                        containsGlyphRefNodes =
                          true;
                        break;
                    }
                }
            }
            if (containsGlyphRefNodes) {
                org.w3c.dom.NodeList glyphRefNodes =
                  localRefElement.
                  getElementsByTagNameNS(
                    SVG_NAMESPACE_URI,
                    SVG_GLYPH_REF_TAG);
                int numGlyphRefNodes =
                  glyphRefNodes.
                  getLength(
                    );
                org.apache.batik.gvt.font.Glyph[] glyphArray =
                  new org.apache.batik.gvt.font.Glyph[numGlyphRefNodes];
                for (int i =
                       0;
                     i <
                       numGlyphRefNodes;
                     i++) {
                    org.w3c.dom.Element glyphRefElement =
                      (org.w3c.dom.Element)
                        glyphRefNodes.
                        item(
                          i);
                    java.lang.String glyphUri =
                      org.apache.batik.dom.util.XLinkSupport.
                      getXLinkHref(
                        glyphRefElement);
                    org.apache.batik.gvt.font.Glyph glyph =
                      getGlyph(
                        ctx,
                        glyphUri,
                        glyphRefElement,
                        fontSize,
                        aci);
                    if (glyph ==
                          null) {
                        return null;
                    }
                    glyphArray[i] =
                      glyph;
                }
                return glyphArray;
            }
            else {
                org.w3c.dom.NodeList altGlyphItemNodes =
                  localRefElement.
                  getElementsByTagNameNS(
                    SVG_NAMESPACE_URI,
                    SVG_ALT_GLYPH_ITEM_TAG);
                int numAltGlyphItemNodes =
                  altGlyphItemNodes.
                  getLength(
                    );
                if (numAltGlyphItemNodes >
                      0) {
                    boolean foundMatchingGlyph =
                      false;
                    org.apache.batik.gvt.font.Glyph[] glyphArray =
                      null;
                    for (int i =
                           0;
                         i <
                           numAltGlyphItemNodes &&
                           !foundMatchingGlyph;
                         i++) {
                        org.w3c.dom.Element altGlyphItemElement =
                          (org.w3c.dom.Element)
                            altGlyphItemNodes.
                            item(
                              i);
                        org.w3c.dom.NodeList altGlyphRefNodes =
                          altGlyphItemElement.
                          getElementsByTagNameNS(
                            SVG_NAMESPACE_URI,
                            SVG_GLYPH_REF_TAG);
                        int numAltGlyphRefNodes =
                          altGlyphRefNodes.
                          getLength(
                            );
                        glyphArray =
                          (new org.apache.batik.gvt.font.Glyph[numAltGlyphRefNodes]);
                        foundMatchingGlyph =
                          true;
                        for (int j =
                               0;
                             j <
                               numAltGlyphRefNodes;
                             j++) {
                            org.w3c.dom.Element glyphRefElement =
                              (org.w3c.dom.Element)
                                altGlyphRefNodes.
                                item(
                                  j);
                            java.lang.String glyphUri =
                              org.apache.batik.dom.util.XLinkSupport.
                              getXLinkHref(
                                glyphRefElement);
                            org.apache.batik.gvt.font.Glyph glyph =
                              getGlyph(
                                ctx,
                                glyphUri,
                                glyphRefElement,
                                fontSize,
                                aci);
                            if (glyph !=
                                  null) {
                                glyphArray[j] =
                                  glyph;
                            }
                            else {
                                foundMatchingGlyph =
                                  false;
                                break;
                            }
                        }
                    }
                    if (!foundMatchingGlyph) {
                        return null;
                    }
                    return glyphArray;
                }
            }
        }
        return null;
    }
    private org.apache.batik.gvt.font.Glyph getGlyph(org.apache.batik.bridge.BridgeContext ctx,
                                                     java.lang.String glyphUri,
                                                     org.w3c.dom.Element altGlyphElement,
                                                     float fontSize,
                                                     java.text.AttributedCharacterIterator aci) {
        org.w3c.dom.Element refGlyphElement =
          null;
        try {
            refGlyphElement =
              ctx.
                getReferencedElement(
                  altGlyphElement,
                  glyphUri);
        }
        catch (org.apache.batik.bridge.BridgeException e) {
            if (ERR_URI_UNSECURE.
                  equals(
                    e.
                      getCode(
                        ))) {
                ctx.
                  getUserAgent(
                    ).
                  displayError(
                    e);
            }
        }
        if (refGlyphElement ==
              null ||
              !SVG_NAMESPACE_URI.
              equals(
                refGlyphElement.
                  getNamespaceURI(
                    )) ||
              !SVG_GLYPH_TAG.
              equals(
                refGlyphElement.
                  getLocalName(
                    )))
            return null;
        org.apache.batik.dom.svg.SVGOMDocument document =
          (org.apache.batik.dom.svg.SVGOMDocument)
            altGlyphElement.
            getOwnerDocument(
              );
        org.apache.batik.dom.svg.SVGOMDocument refDocument =
          (org.apache.batik.dom.svg.SVGOMDocument)
            refGlyphElement.
            getOwnerDocument(
              );
        boolean isLocal =
          refDocument ==
          document;
        org.w3c.dom.Element localGlyphElement =
          null;
        org.w3c.dom.Element localFontFaceElement =
          null;
        org.w3c.dom.Element localFontElement =
          null;
        if (isLocal) {
            localGlyphElement =
              refGlyphElement;
            localFontElement =
              (org.w3c.dom.Element)
                localGlyphElement.
                getParentNode(
                  );
            org.w3c.dom.NodeList fontFaceElements =
              localFontElement.
              getElementsByTagNameNS(
                SVG_NAMESPACE_URI,
                SVG_FONT_FACE_TAG);
            if (fontFaceElements.
                  getLength(
                    ) >
                  0) {
                localFontFaceElement =
                  (org.w3c.dom.Element)
                    fontFaceElements.
                    item(
                      0);
            }
        }
        else {
            localFontElement =
              (org.w3c.dom.Element)
                document.
                importNode(
                  refGlyphElement.
                    getParentNode(
                      ),
                  true);
            java.lang.String base =
              org.apache.batik.dom.AbstractNode.
              getBaseURI(
                altGlyphElement);
            org.w3c.dom.Element g =
              document.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_G_TAG);
            g.
              appendChild(
                localFontElement);
            g.
              setAttributeNS(
                org.apache.batik.util.XMLConstants.
                  XML_NAMESPACE_URI,
                "xml:base",
                base);
            org.apache.batik.bridge.CSSUtilities.
              computeStyleAndURIs(
                (org.w3c.dom.Element)
                  refGlyphElement.
                  getParentNode(
                    ),
                localFontElement,
                glyphUri);
            java.lang.String glyphId =
              refGlyphElement.
              getAttributeNS(
                null,
                SVG_ID_ATTRIBUTE);
            org.w3c.dom.NodeList glyphElements =
              localFontElement.
              getElementsByTagNameNS(
                SVG_NAMESPACE_URI,
                SVG_GLYPH_TAG);
            for (int i =
                   0;
                 i <
                   glyphElements.
                   getLength(
                     );
                 i++) {
                org.w3c.dom.Element glyphElem =
                  (org.w3c.dom.Element)
                    glyphElements.
                    item(
                      i);
                if (glyphElem.
                      getAttributeNS(
                        null,
                        SVG_ID_ATTRIBUTE).
                      equals(
                        glyphId)) {
                    localGlyphElement =
                      glyphElem;
                    break;
                }
            }
            org.w3c.dom.NodeList fontFaceElements =
              localFontElement.
              getElementsByTagNameNS(
                SVG_NAMESPACE_URI,
                SVG_FONT_FACE_TAG);
            if (fontFaceElements.
                  getLength(
                    ) >
                  0) {
                localFontFaceElement =
                  (org.w3c.dom.Element)
                    fontFaceElements.
                    item(
                      0);
            }
        }
        if (localGlyphElement ==
              null ||
              localFontFaceElement ==
              null) {
            return null;
        }
        org.apache.batik.bridge.SVGFontFaceElementBridge fontFaceBridge =
          (org.apache.batik.bridge.SVGFontFaceElementBridge)
            ctx.
            getBridge(
              localFontFaceElement);
        org.apache.batik.bridge.SVGFontFace fontFace =
          fontFaceBridge.
          createFontFace(
            ctx,
            localFontFaceElement);
        org.apache.batik.bridge.SVGGlyphElementBridge glyphBridge =
          (org.apache.batik.bridge.SVGGlyphElementBridge)
            ctx.
            getBridge(
              localGlyphElement);
        aci.
          first(
            );
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            aci.
            getAttribute(
              PAINT_INFO);
        return glyphBridge.
          createGlyph(
            ctx,
            localGlyphElement,
            altGlyphElement,
            -1,
            fontSize,
            fontFace,
            tpi);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/xM7l1YbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
