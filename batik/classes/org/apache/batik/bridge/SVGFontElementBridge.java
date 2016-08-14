package org.apache.batik.bridge;
public class SVGFontElementBridge extends org.apache.batik.bridge.AbstractSVGBridge {
    public SVGFontElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FONT_TAG; }
    public org.apache.batik.bridge.SVGGVTFont createFont(org.apache.batik.bridge.BridgeContext ctx,
                                                         org.w3c.dom.Element fontElement,
                                                         org.w3c.dom.Element textElement,
                                                         float size,
                                                         org.apache.batik.gvt.font.GVTFontFace fontFace) {
        org.w3c.dom.NodeList glyphElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_GLYPH_TAG);
        int numGlyphs =
          glyphElements.
          getLength(
            );
        java.lang.String[] glyphCodes =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphNames =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphLangs =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphOrientations =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphForms =
          new java.lang.String[numGlyphs];
        org.w3c.dom.Element[] glyphElementArray =
          new org.w3c.dom.Element[numGlyphs];
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            org.w3c.dom.Element glyphElement =
              (org.w3c.dom.Element)
                glyphElements.
                item(
                  i);
            glyphCodes[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_UNICODE_ATTRIBUTE);
            if (glyphCodes[i].
                  length(
                    ) >
                  1) {
                if (org.apache.batik.gvt.text.ArabicTextHandler.
                      arabicChar(
                        glyphCodes[i].
                          charAt(
                            0))) {
                    glyphCodes[i] =
                      new java.lang.StringBuffer(
                        glyphCodes[i]).
                        reverse(
                          ).
                        toString(
                          );
                }
            }
            glyphNames[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_GLYPH_NAME_ATTRIBUTE);
            glyphLangs[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_LANG_ATTRIBUTE);
            glyphOrientations[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_ORIENTATION_ATTRIBUTE);
            glyphForms[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_ARABIC_FORM_ATTRIBUTE);
            glyphElementArray[i] =
              glyphElement;
        }
        org.w3c.dom.NodeList missingGlyphElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_MISSING_GLYPH_TAG);
        org.w3c.dom.Element missingGlyphElement =
          null;
        if (missingGlyphElements.
              getLength(
                ) >
              0) {
            missingGlyphElement =
              (org.w3c.dom.Element)
                missingGlyphElements.
                item(
                  0);
        }
        org.w3c.dom.NodeList hkernElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_HKERN_TAG);
        org.w3c.dom.Element[] hkernElementArray =
          new org.w3c.dom.Element[hkernElements.
                                    getLength(
                                      )];
        for (int i =
               0;
             i <
               hkernElementArray.
                 length;
             i++) {
            org.w3c.dom.Element hkernElement =
              (org.w3c.dom.Element)
                hkernElements.
                item(
                  i);
            hkernElementArray[i] =
              hkernElement;
        }
        org.w3c.dom.NodeList vkernElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_VKERN_TAG);
        org.w3c.dom.Element[] vkernElementArray =
          new org.w3c.dom.Element[vkernElements.
                                    getLength(
                                      )];
        for (int i =
               0;
             i <
               vkernElementArray.
                 length;
             i++) {
            org.w3c.dom.Element vkernElement =
              (org.w3c.dom.Element)
                vkernElements.
                item(
                  i);
            vkernElementArray[i] =
              vkernElement;
        }
        return new org.apache.batik.bridge.SVGGVTFont(
          size,
          fontFace,
          glyphCodes,
          glyphNames,
          glyphLangs,
          glyphOrientations,
          glyphForms,
          ctx,
          glyphElementArray,
          missingGlyphElement,
          hkernElementArray,
          vkernElementArray,
          textElement);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+oLBE3g2SI58kK/+Fn9lj2//B9TpgIujFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
