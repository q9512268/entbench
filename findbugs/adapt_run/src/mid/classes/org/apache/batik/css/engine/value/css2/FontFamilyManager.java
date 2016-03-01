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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "XUd3EpqN/+z/L9S9IxDDIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
