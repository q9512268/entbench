package org.apache.batik.css.engine.value.css2;
public class FontFamilyManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected static final org.apache.batik.css.engine.value.ListValue DEFAULT_VALUE =
      new org.apache.batik.css.engine.value.ListValue(
      );
    static { DEFAULT_VALUE.append(new org.apache.batik.css.engine.value.StringValue(
                                    org.w3c.dom.css.CSSPrimitiveValue.
                                      CSS_STRING,
                                    "Arial"));
             DEFAULT_VALUE.append(new org.apache.batik.css.engine.value.StringValue(
                                    org.w3c.dom.css.CSSPrimitiveValue.
                                      CSS_STRING,
                                    "Helvetica"));
             DEFAULT_VALUE.append(new org.apache.batik.css.engine.value.StringValue(
                                    org.w3c.dom.css.CSSPrimitiveValue.
                                      CSS_IDENT,
                                    org.apache.batik.util.CSSConstants.
                                      CSS_SANS_SERIF_VALUE));
    }
    protected static final org.apache.batik.css.engine.value.StringMap
      values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.
                          CSS_CURSIVE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          CURSIVE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_FANTASY_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          FANTASY_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_MONOSPACE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          MONOSPACE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_SERIF_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SERIF_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_SANS_SERIF_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SANS_SERIF_VALUE);
    }
    public boolean isInheritedProperty() {
        return true;
    }
    public boolean isAnimatableProperty() {
        return true;
    }
    public boolean isAdditiveProperty() {
        return false;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_FAMILY_VALUE;
    }
    public java.lang.String getPropertyName() {
        return org.apache.batik.util.CSSConstants.
                 CSS_FONT_FAMILY_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return DEFAULT_VALUE;
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
            default:
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
            case org.w3c.css.sac.LexicalUnit.
                   SAC_STRING_VALUE:
        }
        org.apache.batik.css.engine.value.ListValue result =
          new org.apache.batik.css.engine.value.ListValue(
          );
        for (;
             ;
             ) {
            switch (lu.
                      getLexicalUnitType(
                        )) {
                case org.w3c.css.sac.LexicalUnit.
                       SAC_STRING_VALUE:
                    result.
                      append(
                        new org.apache.batik.css.engine.value.StringValue(
                          org.w3c.dom.css.CSSPrimitiveValue.
                            CSS_STRING,
                          lu.
                            getStringValue(
                              )));
                    lu =
                      lu.
                        getNextLexicalUnit(
                          );
                    break;
                case org.w3c.css.sac.LexicalUnit.
                       SAC_IDENT:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      lu.
                        getStringValue(
                          ));
                    lu =
                      lu.
                        getNextLexicalUnit(
                          );
                    if (lu !=
                          null &&
                          lu.
                          getLexicalUnitType(
                            ) ==
                          org.w3c.css.sac.LexicalUnit.
                            SAC_IDENT) {
                        do  {
                            sb.
                              append(
                                ' ');
                            sb.
                              append(
                                lu.
                                  getStringValue(
                                    ));
                            lu =
                              lu.
                                getNextLexicalUnit(
                                  );
                        }while(lu !=
                                 null &&
                                 lu.
                                 getLexicalUnitType(
                                   ) ==
                                 org.w3c.css.sac.LexicalUnit.
                                   SAC_IDENT); 
                        result.
                          append(
                            new org.apache.batik.css.engine.value.StringValue(
                              org.w3c.dom.css.CSSPrimitiveValue.
                                CSS_STRING,
                              sb.
                                toString(
                                  )));
                    }
                    else {
                        java.lang.String id =
                          sb.
                          toString(
                            );
                        java.lang.String s =
                          id.
                          toLowerCase(
                            ).
                          intern(
                            );
                        org.apache.batik.css.engine.value.Value v =
                          (org.apache.batik.css.engine.value.Value)
                            values.
                            get(
                              s);
                        result.
                          append(
                            v !=
                              null
                              ? v
                              : new org.apache.batik.css.engine.value.StringValue(
                              org.w3c.dom.css.CSSPrimitiveValue.
                                CSS_STRING,
                              id));
                    }
            }
            if (lu ==
                  null) {
                return result;
            }
            if (lu.
                  getLexicalUnitType(
                    ) !=
                  org.w3c.css.sac.LexicalUnit.
                    SAC_OPERATOR_COMMA) {
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
            }
            lu =
              lu.
                getNextLexicalUnit(
                  );
            if (lu ==
                  null) {
                throw createMalformedLexicalUnitDOMException(
                        );
            }
        }
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value ==
              DEFAULT_VALUE) {
            org.apache.batik.css.engine.CSSContext ctx =
              engine.
              getCSSContext(
                );
            value =
              ctx.
                getDefaultFontFamily(
                  );
        }
        return value;
    }
    public FontFamilyManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mtha8R8xnmck0CEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "30+99HvlGfbfAuhEh43XLAAA");
}
