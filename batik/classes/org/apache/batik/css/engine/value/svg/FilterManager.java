package org.apache.batik.css.engine.value.svg;
public class FilterManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return false; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FILTER_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NONE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
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
                                                        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
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
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            if (value.
                  equalsIgnoreCase(
                    org.apache.batik.util.CSSConstants.
                      CSS_NONE_VALUE)) {
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         NONE_VALUE;
            }
            throw createInvalidIdentifierDOMException(
                    value);
        }
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_URI) {
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
    public FilterManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "yt4K/wPHKBTKKx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Rx//Rn4X+n9TPzSVaCkAAA==");
}
