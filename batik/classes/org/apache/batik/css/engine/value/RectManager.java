package org.apache.batik.css.engine.value;
public abstract class RectManager extends org.apache.batik.css.engine.value.LengthManager {
    protected int orientation;
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.getLexicalUnitType(
                                                         )) {
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_FUNCTION:
                                                    if (!lu.
                                                          getFunctionName(
                                                            ).
                                                          equalsIgnoreCase(
                                                            "rect")) {
                                                        break;
                                                    }
                                                case org.w3c.css.sac.LexicalUnit.
                                                       SAC_RECT_FUNCTION:
                                                    lu =
                                                      lu.
                                                        getParameters(
                                                          );
                                                    org.apache.batik.css.engine.value.Value top =
                                                      createRectComponent(
                                                        lu);
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    if (lu ==
                                                          null ||
                                                          lu.
                                                          getLexicalUnitType(
                                                            ) !=
                                                          org.w3c.css.sac.LexicalUnit.
                                                            SAC_OPERATOR_COMMA) {
                                                        throw createMalformedRectDOMException(
                                                                );
                                                    }
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    org.apache.batik.css.engine.value.Value right =
                                                      createRectComponent(
                                                        lu);
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    if (lu ==
                                                          null ||
                                                          lu.
                                                          getLexicalUnitType(
                                                            ) !=
                                                          org.w3c.css.sac.LexicalUnit.
                                                            SAC_OPERATOR_COMMA) {
                                                        throw createMalformedRectDOMException(
                                                                );
                                                    }
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    org.apache.batik.css.engine.value.Value bottom =
                                                      createRectComponent(
                                                        lu);
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    if (lu ==
                                                          null ||
                                                          lu.
                                                          getLexicalUnitType(
                                                            ) !=
                                                          org.w3c.css.sac.LexicalUnit.
                                                            SAC_OPERATOR_COMMA) {
                                                        throw createMalformedRectDOMException(
                                                                );
                                                    }
                                                    lu =
                                                      lu.
                                                        getNextLexicalUnit(
                                                          );
                                                    org.apache.batik.css.engine.value.Value left =
                                                      createRectComponent(
                                                        lu);
                                                    return new org.apache.batik.css.engine.value.RectValue(
                                                      top,
                                                      right,
                                                      bottom,
                                                      left);
                                            }
                                            throw createMalformedRectDOMException(
                                                    );
    }
    private org.apache.batik.css.engine.value.Value createRectComponent(org.w3c.css.sac.LexicalUnit lu)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                if (lu.
                      getStringValue(
                        ).
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_AUTO_VALUE)) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             AUTO_VALUE;
                }
                break;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_EM:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_EMS,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_EX:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_EXS,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_PIXEL:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_PX,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_CENTIMETER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_CM,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_MILLIMETER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_MM,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INCH:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_IN,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_POINT:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_PT,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_PICA:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_PC,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INTEGER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getIntegerValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_REAL:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  lu.
                    getFloatValue(
                      ));
            case org.w3c.css.sac.LexicalUnit.
                   SAC_PERCENTAGE:
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_PERCENTAGE,
                  lu.
                    getFloatValue(
                      ));
        }
        throw createMalformedRectDOMException(
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
                ) !=
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE) {
            return value;
        }
        if (value.
              getPrimitiveType(
                ) !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_RECT) {
            return value;
        }
        org.apache.batik.css.engine.value.RectValue rect =
          (org.apache.batik.css.engine.value.RectValue)
            value;
        orientation =
          VERTICAL_ORIENTATION;
        org.apache.batik.css.engine.value.Value top =
          super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            rect.
              getTop(
                ));
        org.apache.batik.css.engine.value.Value bottom =
          super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            rect.
              getBottom(
                ));
        orientation =
          HORIZONTAL_ORIENTATION;
        org.apache.batik.css.engine.value.Value left =
          super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            rect.
              getLeft(
                ));
        org.apache.batik.css.engine.value.Value right =
          super.
          computeValue(
            elt,
            pseudo,
            engine,
            idx,
            sm,
            rect.
              getRight(
                ));
        if (top !=
              rect.
              getTop(
                ) ||
              right !=
              rect.
              getRight(
                ) ||
              bottom !=
              rect.
              getBottom(
                ) ||
              left !=
              rect.
              getLeft(
                )) {
            return new org.apache.batik.css.engine.value.RectValue(
              top,
              right,
              bottom,
              left);
        }
        else {
            return value;
        }
    }
    protected int getOrientation() { return orientation;
    }
    private org.w3c.dom.DOMException createMalformedRectDOMException() {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "malformed.rect",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            SYNTAX_ERR,
          s);
    }
    public RectManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "aT7Lzs8nAAA=");
}
