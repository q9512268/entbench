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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RCZi3abp3HGWNQnkTRMpJVQjmO1/9swYEYIeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Yvy/F31T8cUqAAA=");
}
