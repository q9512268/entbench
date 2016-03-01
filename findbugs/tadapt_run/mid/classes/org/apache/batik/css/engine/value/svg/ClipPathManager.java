package org.apache.batik.css.engine.value.svg;
public class ClipPathManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    public boolean isInheritedProperty() { return false; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_CLIP_PATH_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_URI_OR_IDENT; }
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
    public ClipPathManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Pkde13kq+Ygnt/8Cm+TeeSIdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vuLTr//Yk9/MTjb/D+9671ZYKQAA");
}
