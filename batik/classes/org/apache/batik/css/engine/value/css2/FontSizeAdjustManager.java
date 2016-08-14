package org.apache.batik.css.engine.value.css2;
public class FontSizeAdjustManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_SIZE_ADJUST_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_SIZE_ADJUST_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NONE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.ValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INTEGER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getIntegerValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_REAL:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                if (lu.
                      getStringValue(
                        ).
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NONE_VALUE)) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NONE_VALUE;
                }
                throw createInvalidIdentifierDOMException(
                        lu.
                          getStringValue(
                            ));
        }
        throw createInvalidLexicalUnitDOMException(
                lu.
                  getLexicalUnitType(
                    ));
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidStringTypeDOMException(
                    type);
        }
        if (value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_NONE_VALUE)) {
            return org.apache.batik.css.engine.value.ValueConstants.
                     NONE_VALUE;
        }
        throw createInvalidIdentifierDOMException(
                value);
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER) {
            return new org.apache.batik.css.engine.value.FloatValue(
              type,
              floatValue);
        }
        throw createInvalidFloatTypeDOMException(
                type);
    }
    public FontSizeAdjustManager() { super(
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
      ("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");
}
