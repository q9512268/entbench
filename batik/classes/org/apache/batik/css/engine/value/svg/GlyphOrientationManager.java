package org.apache.batik.css.engine.value.svg;
public abstract class GlyphOrientationManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_ANGLE; }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.getLexicalUnitType(
                                                         )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_DEGREE:
                                                    return new org.apache.batik.css.engine.value.FloatValue(
                                                      org.w3c.dom.css.CSSPrimitiveValue.
                                                        CSS_DEG,
                                                      lu.
                                                        getFloatValue(
                                                          ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_GRADIAN:
                                                    return new org.apache.batik.css.engine.value.FloatValue(
                                                      org.w3c.dom.css.CSSPrimitiveValue.
                                                        CSS_GRAD,
                                                      lu.
                                                        getFloatValue(
                                                          ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_RADIAN:
                                                    return new org.apache.batik.css.engine.value.FloatValue(
                                                      org.w3c.dom.css.CSSPrimitiveValue.
                                                        CSS_RAD,
                                                      lu.
                                                        getFloatValue(
                                                          ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INTEGER:
                                                    {
                                                        int n =
                                                          lu.
                                                          getIntegerValue(
                                                            );
                                                        return new org.apache.batik.css.engine.value.FloatValue(
                                                          org.w3c.dom.css.CSSPrimitiveValue.
                                                            CSS_DEG,
                                                          n);
                                                    }
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_REAL:
                                                    {
                                                        float n =
                                                          lu.
                                                          getFloatValue(
                                                            );
                                                        return new org.apache.batik.css.engine.value.FloatValue(
                                                          org.w3c.dom.css.CSSPrimitiveValue.
                                                            CSS_DEG,
                                                          n);
                                                    }
                                            }
                                            throw createInvalidLexicalUnitDOMException(
                                                    lu.
                                                      getLexicalUnitType(
                                                        ));
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_DEG:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_GRAD:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_RAD:
                return new org.apache.batik.css.engine.value.FloatValue(
                  type,
                  floatValue);
        }
        throw createInvalidFloatValueDOMException(
                floatValue);
    }
    public GlyphOrientationManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "o5wanicAAA==");
}
