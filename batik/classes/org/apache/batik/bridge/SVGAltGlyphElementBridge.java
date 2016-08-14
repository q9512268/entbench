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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZDYxU1RW+O/vL/rDL8rciLH8LdgFnRKXULlWXdReGDsuG" +
       "RZIu6vDmzZ2dB2/ee7x3Z3cWiyiJEU1rKUWkjW6bFIUaFGtqauNPaUz9idZW" +
       "pLXWqP0xLS0lhTS1TW2159z7/mdmkaTtJu++N/eee+45557znXPvHjtLqi2T" +
       "tFONRdmYQa1or8YGJNOi6R5VsqxN0JeU76+U/nrL6f5rIqRmiEzOStZ6WbJo" +
       "n0LVtDVE5iiaxSRNplY/pWmcMWBSi5ojElN0bYhMV6x4zlAVWWHr9TRFgs2S" +
       "mSBTJMZMJZVnNG4zYGROAiSJcUli3eHhrgRplHVjzCNv85H3+EaQMuetZTHS" +
       "ktgmjUixPFPUWEKxWFfBJEsNXR0bVnUWpQUW3aausE2wLrGiyAQLHm/+4MN9" +
       "2RZugqmSpumMq2dtpJaujtB0gjR7vb0qzVk7yG2kMkEafMSMdCScRWOwaAwW" +
       "dbT1qED6Jqrlcz06V4c5nGoMGQViZH6QiSGZUs5mM8BlBg51zNadTwZt57na" +
       "Ci2LVLxvaezA/be0PFFJmodIs6INojgyCMFgkSEwKM2lqGl1p9M0PUSmaLDZ" +
       "g9RUJFXZae90q6UMaxLLw/Y7ZsHOvEFNvqZnK9hH0M3My0w3XfUy3KHsX9UZ" +
       "VRoGXWd4ugoN+7AfFKxXQDAzI4Hf2VOqtitampG54Rmujh2fBwKYWpujLKu7" +
       "S1VpEnSQVuEiqqQNxwbB9bRhIK3WwQFNRmaVZYq2NiR5uzRMk+iRIboBMQRU" +
       "k7ghcAoj08NknBPs0qzQLvn252z/qntv1dZqEVIBMqeprKL8DTCpPTRpI81Q" +
       "k0IciImNSxIHpRnP7o0QAsTTQ8SC5vtfPH/9svYTLwmaS0vQbEhtozJLyodT" +
       "k1+f3dN5TSWKUWfoloKbH9CcR9mAPdJVMABhZrgccTDqDJ7Y+MIXbn+EnomQ" +
       "+jipkXU1nwM/miLrOUNRqbmGatSUGE3HySSqpXv4eJzUwndC0ajo3ZDJWJTF" +
       "SZXKu2p0/htMlAEWaKJ6+Fa0jO58GxLL8u+CQQiphYdcB08nEX+fwoYROZbV" +
       "czQmyZKmaHpswNRRfysGiJMC22ZjKfD67TFLz5vggjHdHI5J4AdZag+kTCU9" +
       "TGODm9d0q2yNOmZkERVg9mo+EEVnM/4/yxRQ26mjFRWwEbPDMKBCBK3V1TQ1" +
       "k/KB/Ore848lXxEuhmFh24mRK2DlqFg5yleOipWj5VYmFRV8wWkogdh12LPt" +
       "EP0Av42dgzev27p3QSW4mzFaBQZH0gWBNNTjQYSD60n5eGvTzvnvLn8+QqoS" +
       "pFWSWV5SMat0m8OAV/J2O6QbU5CgvDwxz5cnMMGZukzTAFPl8oXNpU4foSb2" +
       "MzLNx8HJYhivsfI5pKT85MSh0Ts2774iQiLB1IBLVgOq4fQBBHQXuDvCkFCK" +
       "b/Ndpz84fnCX7oFDINc4KbJoJuqwIOwSYfMk5SXzpCeTz+7q4GafBODNJAg2" +
       "wMX28BoB7OlycBx1qQOFM7qZk1Qccmxcz7KmPur1cF+dwr+ngVs0YDAuhGe5" +
       "HZ38jaMzDGxnCt9GPwtpwfPE5waNB3/52h+v4uZ2UkqzrxYYpKzLB2PIrJUD" +
       "1hTPbTeZlALdO4cGvnbf2bu2cJ8FioWlFuzAtgfgC7YQzHznSzveeu/dw6ci" +
       "np8zyOP5FJRDBVdJ7Cf1EygJqy325AEYVAEj0Gs6btTAP5WMIqVUioH1r+ZF" +
       "y5/8870twg9U6HHcaNmFGXj9l6wmt79yy9/bOZsKGdOwZzOPTGD7VI9zt2lK" +
       "YyhH4Y6Tc77+ovQgZAlAZkvZSTnYEm4DwjdtBdf/Ct5eHRpbic0iy+/8wfjy" +
       "lUtJed+pc02bzz13nksbrLf8e71eMrqEe2GzuADsZ4bBaa1kZYHu6hP9N7Wo" +
       "Jz4EjkPAUQbotTaYgJGFgGfY1NW1v/rR8zO2vl5JIn2kXtWldJ/Eg4xMAu+m" +
       "VhbgtWBcd73Y3NE6aFq4qqRI+aIONPDc0lvXmzMYN/bOp2Z+b9WR8Xe5lxmC" +
       "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" +
       "ABG8vK8FHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "CsJpfoE3Dbe3antUf8ipzTGIY6MkyIaTjF8b7A7jV4Xf0xcF3A6aA9kgJn1u" +
       "1DXRjF2hOOER7Ym9V4m8HswmFNsOpF19pqpOrhbtsTNNwrpKwVoWwq4pRLV1" +
       "v5tsBjpGSw18K7NFf5C7vbgzmGaxnxlTEstkjmggGLqB02YioctdUIT5eu2P" +
       "C4ZAp8NwtOzXN4upstAlu8tok6Y6SF3FQJUEVUc4ZXmiTSVFNzYNs9dezwq6" +
       "cPki1fUE0bKWark+XuwnU4wazfuEoI3aPaNO7s1RsG+gWJdcC11yWxtELSVe" +
       "dKeYyA4DYWl5dD2EJWqPITjersWZ2Vm2aFqVOYcarLYdu5U5cbuz33cQZSJF" +
       "44E2yaRiMl0M+m1h2Cli1B6v9xu6uW4t1HYb9tKZKXXtrrRLJX7hrkmn2c+2" +
       "WkxoBtKLMZ2e+4ql1qw9jOCZsd3by3ika7Cv1lClKOoNdxcpIWPgeruus2FA" +
       "6uigSLr9SGoqhCzXd9KaTlqbaYdri96oaJLb3bS7nClevJDX5mhAmQNjXefE" +
       "eoqEc7yYoKmNjYYuulvFoq2NENJs5mw3gR1ho5ixSKhau7FucGRLpoJmEMyH" +
       "sDyccNO+WrPTlVOwaw6w7aMSrHTEOb7SMTt3enlrmQRRc+L1ghQNG10j4Tl7" +
       "gSN4LPa9PZNqmERHnR4eu51kSXFtI02mQ58r6F483zUXTh8XgQB7IdbxCoNp" +
       "0uO+1fbqPdWf9ZapYq+mPtMW0TlRrPGtT8vDmN2gtpJLy5Rd+ztuNhB84D57" +
       "QRt0ASZxtAsUhlALab3oF8w8GbAW3gYy55sNbdFjGrLajVdZe8r2k729Nvhg" +
       "OM22RaCpeRzZKFVM4hbOT1uT7oCQ03zuDL0B2Nl244kza29JM8qWW2RG64hh" +
       "D4tGB22YtY63tlYUkoVDuLVp7WvbumT2MsmKa00v37cncZZ3FXptmLKiiUwn" +
       "tIcTZr1OMlT2x/sVEjSo8Rg24rzQkbzj9xgLW6lTXvadVkvaT9jm1rUtR9Jx" +
       "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");
}
