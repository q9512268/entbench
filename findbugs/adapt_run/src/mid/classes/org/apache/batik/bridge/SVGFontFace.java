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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6dA088gauM4sr2nMHV+nTdt/AQkMmct9HAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "v3/777zlN577Zn4E/d9oEqGOmCYAAA==");
}
