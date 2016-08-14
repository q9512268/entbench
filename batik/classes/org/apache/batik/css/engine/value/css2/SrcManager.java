package org.apache.batik.css.engine.value.css2;
public class SrcManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_NONE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NONE_VALUE); }
    public SrcManager() { super(); }
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_DESCRIPTOR_SRC_VALUE;
    }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_SRC_PROPERTY;
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
                                                default:
                                                    throw createInvalidLexicalUnitDOMException(
                                                            lu.
                                                              getLexicalUnitType(
                                                                ));
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_STRING_VALUE:
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_URI:
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
                                                           SAC_URI:
                                                        java.lang.String uri =
                                                          resolveURI(
                                                            engine.
                                                              getCSSBaseURI(
                                                                ),
                                                            lu.
                                                              getStringValue(
                                                                ));
                                                        result.
                                                          append(
                                                            new org.apache.batik.css.engine.value.URIValue(
                                                              lu.
                                                                getStringValue(
                                                                  ),
                                                              uri));
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
                                                                SAC_FUNCTION) {
                                                            if (!lu.
                                                                  getFunctionName(
                                                                    ).
                                                                  equalsIgnoreCase(
                                                                    "format")) {
                                                                break;
                                                            }
                                                            lu =
                                                              lu.
                                                                getNextLexicalUnit(
                                                                  );
                                                        }
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
                                                        break;
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
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HCzmv6GG/wLuMttYVSAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
