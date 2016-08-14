package org.apache.batik.css.engine.value.css2;
public class CursorManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_CROSSHAIR_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          CROSSHAIR_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_DEFAULT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          DEFAULT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_E_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          E_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_HELP_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          HELP_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_MOVE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          MOVE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_N_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          N_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NE_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NE_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NW_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NW_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_POINTER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          POINTER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_S_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          S_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SE_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SE_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SW_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SW_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_TEXT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          TEXT_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_W_RESIZE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          W_RESIZE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_WAIT_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          WAIT_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_CURSOR_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_CURSOR_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { org.apache.batik.css.engine.value.ListValue result =
                                              new org.apache.batik.css.engine.value.ListValue(
                                              );
                                            switch (lu.
                                                      getLexicalUnitType(
                                                        )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_INHERIT:
                                                    return org.apache.batik.css.engine.value.ValueConstants.
                                                             INHERIT_VALUE;
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_URI:
                                                    do  {
                                                        result.
                                                          append(
                                                            new org.apache.batik.css.engine.value.URIValue(
                                                              lu.
                                                                getStringValue(
                                                                  ),
                                                              resolveURI(
                                                                engine.
                                                                  getCSSBaseURI(
                                                                    ),
                                                                lu.
                                                                  getStringValue(
                                                                    ))));
                                                        lu =
                                                          lu.
                                                            getNextLexicalUnit(
                                                              );
                                                        if (lu ==
                                                              null) {
                                                            throw createMalformedLexicalUnitDOMException(
                                                                    );
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
                                                    }while(lu.
                                                             getLexicalUnitType(
                                                               ) ==
                                                             org.w3c.css.sac.LexicalUnit.
                                                               SAC_URI); 
                                                    if (lu.
                                                          getLexicalUnitType(
                                                            ) !=
                                                          org.w3c.css.sac.LexicalUnit.
                                                            SAC_IDENT) {
                                                        throw createInvalidLexicalUnitDOMException(
                                                                lu.
                                                                  getLexicalUnitType(
                                                                    ));
                                                    }
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_IDENT:
                                                    java.lang.String s =
                                                      lu.
                                                      getStringValue(
                                                        ).
                                                      toLowerCase(
                                                        ).
                                                      intern(
                                                        );
                                                    java.lang.Object v =
                                                      values.
                                                      get(
                                                        s);
                                                    if (v ==
                                                          null) {
                                                        throw createInvalidIdentifierDOMException(
                                                                lu.
                                                                  getStringValue(
                                                                    ));
                                                    }
                                                    result.
                                                      append(
                                                        (org.apache.batik.css.engine.value.Value)
                                                          v);
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                            }
                                            if (lu !=
                                                  null) {
                                                throw createInvalidLexicalUnitDOMException(
                                                        lu.
                                                          getLexicalUnitType(
                                                            ));
                                            }
                                            return result;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_VALUE_LIST) {
            org.apache.batik.css.engine.value.ListValue lv =
              (org.apache.batik.css.engine.value.ListValue)
                value;
            int len =
              lv.
              getLength(
                );
            org.apache.batik.css.engine.value.ListValue result =
              new org.apache.batik.css.engine.value.ListValue(
              ' ');
            for (int i =
                   0;
                 i <
                   len;
                 i++) {
                org.apache.batik.css.engine.value.Value v =
                  lv.
                  item(
                    0);
                if (v.
                      getPrimitiveType(
                        ) ==
                      org.w3c.dom.css.CSSPrimitiveValue.
                        CSS_URI) {
                    result.
                      append(
                        new org.apache.batik.css.engine.value.URIValue(
                          v.
                            getStringValue(
                              ),
                          v.
                            getStringValue(
                              )));
                }
                else {
                    result.
                      append(
                        v);
                }
            }
            return result;
        }
        return super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            value);
    }
    public CursorManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
