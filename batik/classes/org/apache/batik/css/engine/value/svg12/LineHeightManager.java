package org.apache.batik.css.engine.value.svg12;
public class LineHeightManager extends org.apache.batik.css.engine.value.LengthManager {
    public LineHeightManager() { super(); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_LINE_HEIGHT_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.SVG12CSSConstants.
                                                         CSS_LINE_HEIGHT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                {
                    java.lang.String s =
                      lu.
                      getStringValue(
                        ).
                      toLowerCase(
                        );
                    if (org.apache.batik.util.SVG12CSSConstants.
                          CSS_NORMAL_VALUE.
                          equals(
                            s))
                        return org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                                 NORMAL_VALUE;
                    throw createInvalidIdentifierDOMException(
                            lu.
                              getStringValue(
                                ));
                }
            default:
                return super.
                  createValue(
                    lu,
                    engine);
        }
    }
    protected int getOrientation() { return VERTICAL_ORIENTATION;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getCssValueType(
                ) !=
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE)
            return value;
        switch (value.
                  getPrimitiveType(
                    )) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_NUMBER:
                return new org.apache.batik.css.engine.value.svg12.LineHeightValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  value.
                    getFloatValue(
                      ),
                  true);
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PERCENTAGE:
                {
                    float v =
                      value.
                      getFloatValue(
                        );
                    int fsidx =
                      engine.
                      getFontSizeIndex(
                        );
                    float fs =
                      engine.
                      getComputedStyle(
                        elt,
                        pseudo,
                        fsidx).
                      getFloatValue(
                        );
                    return new org.apache.batik.css.engine.value.FloatValue(
                      org.w3c.dom.css.CSSPrimitiveValue.
                        CSS_NUMBER,
                      v *
                        fs *
                        0.01F);
                }
            default:
                return super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    value);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "re7faWm1X58fAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Zv1/AUtlLxBHKwAA");
}
