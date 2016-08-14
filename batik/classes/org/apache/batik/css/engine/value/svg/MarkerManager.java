package org.apache.batik.css.engine.value.svg;
public class MarkerManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected java.lang.String property;
    public MarkerManager(java.lang.String prop) { super();
                                                  property = prop; }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT; }
    public java.lang.String getPropertyName() { return property; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() { return org.apache.batik.css.engine.value.ValueConstants.
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vjHSLrrYm/UfVTBli3QgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KwAA");
}
