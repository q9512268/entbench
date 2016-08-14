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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Py6vLuS/8MTPve+/vPxn5bnI/wf5+YZ8VikAAA==");
}
