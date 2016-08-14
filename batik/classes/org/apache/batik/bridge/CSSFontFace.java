package org.apache.batik.bridge;
public class CSSFontFace extends org.apache.batik.bridge.FontFace implements org.apache.batik.util.SVGConstants {
    org.apache.batik.gvt.font.GVTFontFamily fontFamily = null;
    public CSSFontFace(java.util.List srcs, java.lang.String familyName, float unitsPerEm,
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
    }
    protected CSSFontFace(java.lang.String familyName) { super(familyName);
    }
    public static org.apache.batik.bridge.CSSFontFace createCSSFontFace(org.apache.batik.css.engine.CSSEngine eng,
                                                                        org.apache.batik.css.engine.FontFaceRule ffr) {
        org.apache.batik.css.engine.StyleMap sm =
          ffr.
          getStyleMap(
            );
        java.lang.String familyName =
          getStringProp(
            sm,
            eng,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_FAMILY_INDEX);
        org.apache.batik.bridge.CSSFontFace ret =
          new org.apache.batik.bridge.CSSFontFace(
          familyName);
        org.apache.batik.css.engine.value.Value v;
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                FONT_WEIGHT_INDEX);
        if (v !=
              null)
            ret.
              fontWeight =
              v.
                getCssText(
                  );
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                FONT_STYLE_INDEX);
        if (v !=
              null)
            ret.
              fontStyle =
              v.
                getCssText(
                  );
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                FONT_VARIANT_INDEX);
        if (v !=
              null)
            ret.
              fontVariant =
              v.
                getCssText(
                  );
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                FONT_STRETCH_INDEX);
        if (v !=
              null)
            ret.
              fontStretch =
              v.
                getCssText(
                  );
        v =
          sm.
            getValue(
              org.apache.batik.css.engine.SVGCSSEngine.
                SRC_INDEX);
        org.apache.batik.util.ParsedURL base =
          ffr.
          getURL(
            );
        if (v !=
              null &&
              v !=
              org.apache.batik.css.engine.value.ValueConstants.
                NONE_VALUE) {
            if (v.
                  getCssValueType(
                    ) ==
                  org.w3c.dom.css.CSSValue.
                    CSS_PRIMITIVE_VALUE) {
                ret.
                  srcs =
                  new java.util.LinkedList(
                    );
                ret.
                  srcs.
                  add(
                    getSrcValue(
                      v,
                      base));
            }
            else
                if (v.
                      getCssValueType(
                        ) ==
                      org.w3c.dom.css.CSSValue.
                        CSS_VALUE_LIST) {
                    ret.
                      srcs =
                      new java.util.LinkedList(
                        );
                    for (int i =
                           0;
                         i <
                           v.
                           getLength(
                             );
                         i++) {
                        ret.
                          srcs.
                          add(
                            getSrcValue(
                              v.
                                item(
                                  i),
                              base));
                    }
                }
        }
        return ret;
    }
    public static java.lang.Object getSrcValue(org.apache.batik.css.engine.value.Value v,
                                               org.apache.batik.util.ParsedURL base) {
        if (v.
              getCssValueType(
                ) !=
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE)
            return null;
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_URI) {
            if (base !=
                  null)
                return new org.apache.batik.util.ParsedURL(
                  base,
                  v.
                    getStringValue(
                      ));
            return new org.apache.batik.util.ParsedURL(
              v.
                getStringValue(
                  ));
        }
        if (v.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_STRING)
            return v.
              getStringValue(
                );
        return null;
    }
    public static java.lang.String getStringProp(org.apache.batik.css.engine.StyleMap sm,
                                                 org.apache.batik.css.engine.CSSEngine eng,
                                                 int pidx) {
        org.apache.batik.css.engine.value.Value v =
          sm.
          getValue(
            pidx);
        org.apache.batik.css.engine.value.ValueManager[] vms =
          eng.
          getValueManagers(
            );
        if (v ==
              null) {
            org.apache.batik.css.engine.value.ValueManager vm =
              vms[pidx];
            v =
              vm.
                getDefaultValue(
                  );
        }
        while (v.
                 getCssValueType(
                   ) ==
                 org.w3c.dom.css.CSSValue.
                   CSS_VALUE_LIST) {
            v =
              v.
                item(
                  0);
        }
        return v.
          getStringValue(
            );
    }
    public static float getFloatProp(org.apache.batik.css.engine.StyleMap sm,
                                     org.apache.batik.css.engine.CSSEngine eng,
                                     int pidx) {
        org.apache.batik.css.engine.value.Value v =
          sm.
          getValue(
            pidx);
        org.apache.batik.css.engine.value.ValueManager[] vms =
          eng.
          getValueManagers(
            );
        if (v ==
              null) {
            org.apache.batik.css.engine.value.ValueManager vm =
              vms[pidx];
            v =
              vm.
                getDefaultValue(
                  );
        }
        while (v.
                 getCssValueType(
                   ) ==
                 org.w3c.dom.css.CSSValue.
                   CSS_VALUE_LIST) {
            v =
              v.
                item(
                  0);
        }
        return v.
          getFloatValue(
            );
    }
    public org.apache.batik.gvt.font.GVTFontFamily getFontFamily(org.apache.batik.bridge.BridgeContext ctx) {
        if (fontFamily !=
              null)
            return fontFamily;
        fontFamily =
          super.
            getFontFamily(
              ctx);
        return fontFamily;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "X7lMsnNAIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
