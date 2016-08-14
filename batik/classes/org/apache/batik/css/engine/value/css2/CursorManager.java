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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VCrWwNh1kEmTkKrhbKNkrVbAK+g20dkE6cH8mFKIOdwdDhotyzeU1lqaIObG" +
       "mI2GZuisBJD7xuaE8pFYNEdET4km6y2ynoltDt4MmVbSDUbbpjaVBnmqyuTM" +
       "byntrszRk1lIj5JpQiEgN64S1myJyrO6Q/dTLV6E0WJCLfuaRFYb4KsTKBeu" +
       "e4tdF9VCL+/TQc+edAdg5rCa7BPuUh7NY3Q1QjcbPKB6Xak+VBaKOaghUTjl" +
       "5oZhzIM0GNNjoGHKBk12N+RDrbuZtPsrEBxMi6kylpJF8C6x5zOmNqekqV2v" +
       "wvFk1NQiiRGHTQWmwv5uoEQYTLSy1TYhJnm8mnIB124J0YSN5olCm0SqwfmK" +
       "ZXBB9+OaWEcXcYSjGDKrOk5LW83cFokIXDLvc+hozXgcTkgm3Jq0At/eDBwJ" +
       "bS1tk5uDBUuqeM1Br7aLeT+Aa6RmTr3askqBIZirm1qtLQMAVdAUxhay25es" +
       "cYcxGR6sKWsR1bh8mYrTxCd0LMPqy87A6fMOs+05zpqVrCFJg+zYjEnKqNbC" +
       "FVzPKbKRb7oWPKp0XbHbm/EiIYqp4+iiH3htSa8O1n2z2iYr/fFsVdtF6mIx" +
       "I2u8h4u6zMykIK56/moah2ZlnPJ5Nl9Ut1VzoMAOorcq003WzXbFh/o73lF8" +
       "wmsvbRfl3nLD6OTs0rKbRcP8Jewe7JseLYrHTjbnyr/LN9n4P7M5ChU7Ig/d" +
       "6Eiy3A352PueeVahP145ONpUFiPozsjzv95WE9U+I+oOIOntN975ocoT2dPN" +
       "zs++7+8fZN9pPPUSjnPedEHPiyJ/mvrE7w7fKv/AAXTLydbnC86KzzM9cX7D" +
       "865AjeLAZc9tez504tn7C4+9FTzrI8+ur3+kct0ouFRGwX7sb7Jn/+6btH17" +
       "UaQRdL8Zjl1DDcxIVWaBV56+lwzffCZgnoqg2yXPs1XRPQ2m7MW2os52WVZE" +
       "561/G3ieOrL+qVfe+g/epO37iuK7I+g1Zoi7piNGxWHLsflF23tO7Xz/y7Xz" +
       "MfDoR3bqr7ydP3yTth8pih+IoPvM4ipGuTV5Ayt/8GVYeaWofBg87pGV7itv" +
       "5U/cpO3jRfFsBF3R1ejYvJOzzAtxfIt5dEemtPrHX4bV9xWVj4InPrI6fuWt" +
       "/vmbtP1CUXzyvNXTI/yZn5r4qZdhYrkEPAKedx+Z+O5X3sRfv0nbc0Xxy3sT" +
       "e6omxvb+iOr4GORtL36Mc0pfeuNXXq433gie7zzyxne+Mt44KAkOjo16Q2FU" +
       "WpVLW0JRPiTVzJRFe+ma0THNYzczvMsw/fKt7O3zF3q7dHRr4kjSA8e9KZ5z" +
       "2KOpfiarfrF4lsx/VBSfjaBXyYEqRmrpzKLqN089+rmX69GHwPOZI49+5pXx" +
       "6OWS4PKxjYcv4i0m2tnFAlDcy1Pd8ny+zJz+oCh+8ljKtZtJKUSoR4eFv1nq" +
       "9IWbxPVfF8WfR8XNNsePr+/Xv3gpfs0i6NXnLtEUtwAeeMElvv3FM/lTz165" +
       "4/XPLv+0vEdycjnsThK6Q4tt++yh7Zn3y36gamap/p37I1y//PflCHrr/+2a" +
       "TwTdWvwrlf/7PfM/RtCjL8ocHZ1CnmV8/mie3IAxgi7vX87y/DNY76/HAxYF" +
       "UJ6l/LcIunqREmhR/j9L9x8RdNcpHeh0/3KW5L+AdEBSvP63fxxKjRd3GC6F" +
       "USDKe7w7GtTs0vl0+yRW7nuxWDmTob/lXF5dXgc9zoHj/YXQJ+VPP0tMv+35" +
       "xsf3F3ZkW8zzQsodJHT7/u7QSR796A2lHcu6PHr8q/f87J2PHef89+wVPp3Y" +
       "Z3R70/VvxPQdPyrvsOS/9Ppf+IaffPYL5Znz/wJa/OQBpysAAA==");
}
