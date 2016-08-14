package org.apache.batik.css.engine.value.svg;
public class MaskManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_MASK_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NONE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.ValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_URI:
                                                    return new org.apache.batik.css.engine.value.URIValue(
                                                      lu.
                                                        getStringValue(
                                                          ),
                                                      resolveURI(
                                                        engine.
                                                          getCSSBaseURI(
                                                            ),
                                                        lu.
                                                          getStringValue(
                                                            )));
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
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                if (value.
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NONE_VALUE)) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NONE_VALUE;
                }
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_URI:
                return new org.apache.batik.css.engine.value.URIValue(
                  value,
                  resolveURI(
                    engine.
                      getCSSBaseURI(
                        ),
                    value));
        }
        throw createInvalidStringTypeDOMException(
                type);
    }
    public MaskManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Rj7jie2/5hUb3xIdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ld9m/h9TmRroQCkAAA==");
}
