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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "K3sr/Q/ArGCAIx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
