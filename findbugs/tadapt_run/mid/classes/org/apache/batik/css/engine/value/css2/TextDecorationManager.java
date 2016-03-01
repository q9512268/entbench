package org.apache.batik.css.engine.value.css2;
public class TextDecorationManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_BLINK_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BLINK_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LINE_THROUGH_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LINE_THROUGH_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OVERLINE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          OVERLINE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_UNDERLINE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          UNDERLINE_VALUE); }
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT_LIST; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_TEXT_DECORATION_PROPERTY;
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
                org.apache.batik.css.engine.value.ListValue lv =
                  new org.apache.batik.css.engine.value.ListValue(
                  ' ');
                do  {
                    if (lu.
                          getLexicalUnitType(
                            ) ==
                          org.w3c.css.sac.LexicalUnit.
                            SAC_IDENT) {
                        java.lang.String s =
                          lu.
                          getStringValue(
                            ).
                          toLowerCase(
                            ).
                          intern(
                            );
                        java.lang.Object obj =
                          values.
                          get(
                            s);
                        if (obj ==
                              null) {
                            throw createInvalidIdentifierDOMException(
                                    lu.
                                      getStringValue(
                                        ));
                        }
                        lv.
                          append(
                            (org.apache.batik.css.engine.value.Value)
                              obj);
                        lu =
                          lu.
                            getNextLexicalUnit(
                              );
                    }
                    else {
                        throw createInvalidLexicalUnitDOMException(
                                lu.
                                  getLexicalUnitType(
                                    ));
                    }
                }while(lu !=
                         null); 
                return lv;
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
        if (!value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_NONE_VALUE)) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return org.apache.batik.css.engine.value.ValueConstants.
                 NONE_VALUE;
    }
    public TextDecorationManager() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
