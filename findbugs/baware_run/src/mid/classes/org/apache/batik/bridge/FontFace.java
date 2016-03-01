package org.apache.batik.bridge;
public abstract class FontFace extends org.apache.batik.gvt.font.GVTFontFace implements org.apache.batik.bridge.ErrorConstants {
    java.util.List srcs;
    public FontFace(java.util.List srcs, java.lang.String familyName, float unitsPerEm,
                    java.lang.String fontWeight,
                    java.lang.String fontStyle,
                    java.lang.String fontVariant,
                    java.lang.String fontStretch,
                    float slope,
                    java.lang.String panose1,
                    float ascent,
                    float descent,
                    float strikethroughPosition,
                    float strikethroughThickness,
                    float underlinePosition,
                    float underlineThickness,
                    float overlinePosition,
                    float overlineThickness) { super(familyName, unitsPerEm,
                                                     fontWeight,
                                                     fontStyle,
                                                     fontVariant,
                                                     fontStretch,
                                                     slope,
                                                     panose1,
                                                     ascent,
                                                     descent,
                                                     strikethroughPosition,
                                                     strikethroughThickness,
                                                     underlinePosition,
                                                     underlineThickness,
                                                     overlinePosition,
                                                     overlineThickness);
                                               this.srcs = srcs; }
    protected FontFace(java.lang.String familyName) { super(familyName);
    }
    public static org.apache.batik.bridge.CSSFontFace createFontFace(java.lang.String familyName,
                                                                     org.apache.batik.bridge.FontFace src) {
        return new org.apache.batik.bridge.CSSFontFace(
          new java.util.LinkedList(
            src.
              srcs),
          familyName,
          src.
            unitsPerEm,
          src.
            fontWeight,
          src.
            fontStyle,
          src.
            fontVariant,
          src.
            fontStretch,
          src.
            slope,
          src.
            panose1,
          src.
            ascent,
          src.
            descent,
          src.
            strikethroughPosition,
          src.
            strikethroughThickness,
          src.
            underlinePosition,
          src.
            underlineThickness,
          src.
            overlinePosition,
          src.
            overlineThickness);
    }
    public org.apache.batik.gvt.font.GVTFontFamily getFontFamily(org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String name =
          org.apache.batik.gvt.font.FontFamilyResolver.
          lookup(
            familyName);
        if (name !=
              null) {
            org.apache.batik.gvt.font.GVTFontFace ff =
              createFontFace(
                name,
                this);
            return new org.apache.batik.gvt.font.AWTFontFamily(
              ff);
        }
        java.util.Iterator iter =
          srcs.
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            java.lang.Object o =
              iter.
              next(
                );
            if (o instanceof java.lang.String) {
                java.lang.String str =
                  (java.lang.String)
                    o;
                name =
                  org.apache.batik.gvt.font.FontFamilyResolver.
                    lookup(
                      str);
                if (name !=
                      null) {
                    org.apache.batik.gvt.font.GVTFontFace ff =
                      createFontFace(
                        str,
                        this);
                    return new org.apache.batik.gvt.font.AWTFontFamily(
                      ff);
                }
            }
            else
                if (o instanceof org.apache.batik.util.ParsedURL) {
                    try {
                        org.apache.batik.gvt.font.GVTFontFamily ff =
                          getFontFamily(
                            ctx,
                            (org.apache.batik.util.ParsedURL)
                              o);
                        if (ff !=
                              null)
                            return ff;
                    }
                    catch (java.lang.SecurityException ex) {
                        ctx.
                          getUserAgent(
                            ).
                          displayError(
                            ex);
                    }
                    catch (org.apache.batik.bridge.BridgeException ex) {
                        if (ERR_URI_UNSECURE.
                              equals(
                                ex.
                                  getCode(
                                    )))
                            ctx.
                              getUserAgent(
                                ).
                              displayError(
                                ex);
                    }
                    catch (java.lang.Exception ex) {
                        
                    }
                }
        }
        return new org.apache.batik.gvt.font.AWTFontFamily(
          this);
    }
    protected org.apache.batik.gvt.font.GVTFontFamily getFontFamily(org.apache.batik.bridge.BridgeContext ctx,
                                                                    org.apache.batik.util.ParsedURL purl) {
        java.lang.String purlStr =
          purl.
          toString(
            );
        org.w3c.dom.Element e =
          getBaseElement(
            ctx);
        org.w3c.dom.svg.SVGDocument svgDoc =
          (org.w3c.dom.svg.SVGDocument)
            e.
            getOwnerDocument(
              );
        java.lang.String docURL =
          svgDoc.
          getURL(
            );
        org.apache.batik.util.ParsedURL pDocURL =
          null;
        if (docURL !=
              null)
            pDocURL =
              new org.apache.batik.util.ParsedURL(
                docURL);
        java.lang.String baseURI =
          org.apache.batik.dom.AbstractNode.
          getBaseURI(
            e);
        purl =
          new org.apache.batik.util.ParsedURL(
            baseURI,
            purlStr);
        org.apache.batik.bridge.UserAgent userAgent =
          ctx.
          getUserAgent(
            );
        try {
            userAgent.
              checkLoadExternalResource(
                purl,
                pDocURL);
        }
        catch (java.lang.SecurityException ex) {
            userAgent.
              displayError(
                ex);
            return null;
        }
        if (purl.
              getRef(
                ) !=
              null) {
            org.w3c.dom.Element ref =
              ctx.
              getReferencedElement(
                e,
                purlStr);
            if (!ref.
                  getNamespaceURI(
                    ).
                  equals(
                    SVG_NAMESPACE_URI) ||
                  !ref.
                  getLocalName(
                    ).
                  equals(
                    SVG_FONT_TAG)) {
                return null;
            }
            org.w3c.dom.svg.SVGDocument doc =
              (org.w3c.dom.svg.SVGDocument)
                e.
                getOwnerDocument(
                  );
            org.w3c.dom.svg.SVGDocument rdoc =
              (org.w3c.dom.svg.SVGDocument)
                ref.
                getOwnerDocument(
                  );
            org.w3c.dom.Element fontElt =
              ref;
            if (doc !=
                  rdoc) {
                fontElt =
                  (org.w3c.dom.Element)
                    doc.
                    importNode(
                      ref,
                      true);
                java.lang.String base =
                  org.apache.batik.dom.AbstractNode.
                  getBaseURI(
                    ref);
                org.w3c.dom.Element g =
                  doc.
                  createElementNS(
                    SVG_NAMESPACE_URI,
                    SVG_G_TAG);
                g.
                  appendChild(
                    fontElt);
                g.
                  setAttributeNS(
                    org.apache.batik.util.XMLConstants.
                      XML_NAMESPACE_URI,
                    "xml:base",
                    base);
                org.apache.batik.bridge.CSSUtilities.
                  computeStyleAndURIs(
                    ref,
                    fontElt,
                    purlStr);
            }
            org.w3c.dom.Element fontFaceElt =
              null;
            for (org.w3c.dom.Node n =
                   fontElt.
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
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE &&
                      n.
                      getNamespaceURI(
                        ).
                      equals(
                        SVG_NAMESPACE_URI) &&
                      n.
                      getLocalName(
                        ).
                      equals(
                        SVG_FONT_FACE_TAG)) {
                    fontFaceElt =
                      (org.w3c.dom.Element)
                        n;
                    break;
                }
            }
            org.apache.batik.bridge.SVGFontFaceElementBridge fontFaceBridge;
            fontFaceBridge =
              (org.apache.batik.bridge.SVGFontFaceElementBridge)
                ctx.
                getBridge(
                  SVG_NAMESPACE_URI,
                  SVG_FONT_FACE_TAG);
            org.apache.batik.gvt.font.GVTFontFace gff =
              fontFaceBridge.
              createFontFace(
                ctx,
                fontFaceElt);
            return new org.apache.batik.bridge.SVGFontFamily(
              gff,
              fontElt,
              ctx);
        }
        try {
            java.awt.Font font =
              java.awt.Font.
              createFont(
                java.awt.Font.
                  TRUETYPE_FONT,
                purl.
                  openStream(
                    ));
            return new org.apache.batik.gvt.font.AWTFontFamily(
              this,
              font);
        }
        catch (java.lang.Exception ex) {
            
        }
        return null;
    }
    protected org.w3c.dom.Element getBaseElement(org.apache.batik.bridge.BridgeContext ctx) {
        org.w3c.dom.svg.SVGDocument d =
          (org.w3c.dom.svg.SVGDocument)
            ctx.
            getDocument(
              );
        return d.
          getRootElement(
            );
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
       "g/wXn/j59/7YS39Rnmv8X7UBz9AyKQAA");
}
