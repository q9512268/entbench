package org.apache.batik.css.engine.value.svg;
public class EnableBackgroundManager extends org.apache.batik.css.engine.value.LengthManager {
    protected int orientation;
    public boolean isInheritedProperty() { return false; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_ENABLE_BACKGROUND_VALUE;
    }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_ENABLE_BACKGROUND_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 ACCUMULATE_VALUE;
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
            default:
                throw createInvalidLexicalUnitDOMException(
                        lu.
                          getLexicalUnitType(
                            ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                java.lang.String id =
                  lu.
                  getStringValue(
                    ).
                  toLowerCase(
                    ).
                  intern(
                    );
                if (id ==
                      org.apache.batik.util.CSSConstants.
                        CSS_ACCUMULATE_VALUE) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             ACCUMULATE_VALUE;
                }
                if (id !=
                      org.apache.batik.util.CSSConstants.
                        CSS_NEW_VALUE) {
                    throw createInvalidIdentifierDOMException(
                            id);
                }
                org.apache.batik.css.engine.value.ListValue result =
                  new org.apache.batik.css.engine.value.ListValue(
                  ' ');
                result.
                  append(
                    org.apache.batik.css.engine.value.svg.SVGValueConstants.
                      NEW_VALUE);
                lu =
                  lu.
                    getNextLexicalUnit(
                      );
                if (lu ==
                      null) {
                    return result;
                }
                result.
                  append(
                    super.
                      createValue(
                        lu,
                        engine));
                for (int i =
                       1;
                     i <
                       4;
                     i++) {
                    lu =
                      lu.
                        getNextLexicalUnit(
                          );
                    if (lu ==
                          null) {
                        throw createMalformedLexicalUnitDOMException(
                                );
                    }
                    result.
                      append(
                        super.
                          createValue(
                            lu,
                            engine));
                }
                return result;
        }
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine) {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidStringTypeDOMException(
                    type);
        }
        if (!value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_ACCUMULATE_VALUE)) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 ACCUMULATE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short unitType,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        throw createDOMException(
                );
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
            if (lv.
                  getLength(
                    ) ==
                  5) {
                org.apache.batik.css.engine.value.Value lv1 =
                  lv.
                  item(
                    1);
                orientation =
                  HORIZONTAL_ORIENTATION;
                org.apache.batik.css.engine.value.Value v1 =
                  super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    lv1);
                org.apache.batik.css.engine.value.Value lv2 =
                  lv.
                  item(
                    2);
                orientation =
                  VERTICAL_ORIENTATION;
                org.apache.batik.css.engine.value.Value v2 =
                  super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    lv2);
                org.apache.batik.css.engine.value.Value lv3 =
                  lv.
                  item(
                    3);
                orientation =
                  HORIZONTAL_ORIENTATION;
                org.apache.batik.css.engine.value.Value v3 =
                  super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    lv3);
                org.apache.batik.css.engine.value.Value lv4 =
                  lv.
                  item(
                    4);
                orientation =
                  VERTICAL_ORIENTATION;
                org.apache.batik.css.engine.value.Value v4 =
                  super.
                  computeValue(
                    elt,
                    pseudo,
                    engine,
                    idx,
                    sm,
                    lv4);
                if (lv1 !=
                      v1 ||
                      lv2 !=
                      v2 ||
                      lv3 !=
                      v3 ||
                      lv4 !=
                      v4) {
                    org.apache.batik.css.engine.value.ListValue result =
                      new org.apache.batik.css.engine.value.ListValue(
                      ' ');
                    result.
                      append(
                        lv.
                          item(
                            0));
                    result.
                      append(
                        v1);
                    result.
                      append(
                        v2);
                    result.
                      append(
                        v3);
                    result.
                      append(
                        v4);
                    return result;
                }
            }
        }
        return value;
    }
    protected int getOrientation() { return orientation;
    }
    public EnableBackgroundManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1vUfD+dQiWAkAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "QgIuyv+TcK8klUvHcKDT/ctJkFcBdQBS");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("vH4gPHIa6O7qosFXsjocy3w/Uz1z0q5Ld7h6N2M5sQR9/6mFY3lT+2iRl+7v" +
       "ar+ufenN0eSHvt3+qf2FOc1Vd7uCysN05aH93b2SaLFQfPm21I5oXSRe++7j" +
       "X37k1aNF7eN7ho997ARvL976RtrQC5PyDtnuV57+J9//M2/+UXlT4v8C/UaI" +
       "yEIvAAA=");
}
