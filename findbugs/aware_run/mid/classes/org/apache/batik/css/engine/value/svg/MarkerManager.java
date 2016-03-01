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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "q7pSaN40EUhCdQLa/gdNz+EuZx8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/O/v+bnnf788y/0XKGHM6wsrAAA=");
}
