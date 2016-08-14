package org.apache.batik.bridge;
public class SVGFontFace extends org.apache.batik.bridge.FontFace {
    org.w3c.dom.Element fontFaceElement;
    org.apache.batik.gvt.font.GVTFontFamily fontFamily = null;
    public SVGFontFace(org.w3c.dom.Element fontFaceElement, java.util.List srcs,
                       java.lang.String familyName,
                       float unitsPerEm,
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
                       float overlineThickness) { super(srcs, familyName,
                                                        unitsPerEm,
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
                                                  this.fontFaceElement = fontFaceElement;
    }
    public org.apache.batik.gvt.font.GVTFontFamily getFontFamily(org.apache.batik.bridge.BridgeContext ctx) {
        if (fontFamily !=
              null)
            return fontFamily;
        org.w3c.dom.Element fontElt =
          org.apache.batik.bridge.SVGUtilities.
          getParentElement(
            fontFaceElement);
        if (fontElt.
              getNamespaceURI(
                ).
              equals(
                SVG_NAMESPACE_URI) &&
              fontElt.
              getLocalName(
                ).
              equals(
                SVG_FONT_TAG)) {
            return new org.apache.batik.bridge.SVGFontFamily(
              this,
              fontElt,
              ctx);
        }
        fontFamily =
          super.
            getFontFamily(
              ctx);
        return fontFamily;
    }
    public org.w3c.dom.Element getFontFaceElement() { return fontFaceElement;
    }
    protected org.w3c.dom.Element getBaseElement(org.apache.batik.bridge.BridgeContext ctx) {
        if (fontFaceElement !=
              null)
            return fontFaceElement;
        return super.
          getBaseElement(
            ctx);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Oj6XXdOYu/YUPsldYK+0ufhfhK9HTQodAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "H/07b/5edXz9vwEfGfZKuCYAAA==");
}
