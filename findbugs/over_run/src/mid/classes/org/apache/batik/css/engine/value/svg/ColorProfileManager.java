package org.apache.batik.css.engine.value.svg;
public class ColorProfileManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return true; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_COLOR_PROFILE_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                java.lang.String s =
                  lu.
                  getStringValue(
                    ).
                  toLowerCase(
                    );
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_AUTO_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             AUTO_VALUE;
                }
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_SRGB_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             SRGB_VALUE;
                }
                return new org.apache.batik.css.engine.value.StringValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_IDENT,
                  s);
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
                java.lang.String s =
                  value.
                  toLowerCase(
                    );
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_AUTO_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             AUTO_VALUE;
                }
                if (s.
                      equals(
                        org.apache.batik.util.CSSConstants.
                          CSS_SRGB_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             SRGB_VALUE;
                }
                return new org.apache.batik.css.engine.value.StringValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_IDENT,
                  s);
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
    public ColorProfileManager() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "V8YvS9brOg8nH/EA91/BNNnGMh0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cNuL8q8LNp99xadf/7HHv5nfcP4f93fPJmwpAAA=");
}
