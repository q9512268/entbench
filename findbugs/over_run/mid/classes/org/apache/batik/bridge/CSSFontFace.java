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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4p7/AgYQ89V9IAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
