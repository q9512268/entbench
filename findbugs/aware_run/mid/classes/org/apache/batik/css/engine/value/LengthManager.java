package org.apache.batik.css.engine.value;
public abstract class LengthManager extends org.apache.batik.css.engine.value.AbstractValueManager {
    static final double SQRT2 = java.lang.Math.sqrt(2.0);
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.getLexicalUnitType(
                                                         )) {
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
                                            throw createInvalidLexicalUnitDOMException(
                                                    lu.
                                                      getLexicalUnitType(
                                                        ));
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        switch (type) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PERCENTAGE:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_EMS:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_EXS:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PX:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_CM:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_MM:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IN:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PT:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PC:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_NUMBER:
                return new org.apache.batik.css.engine.value.FloatValue(
                  type,
                  floatValue);
        }
        throw createInvalidFloatTypeDOMException(
                type);
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
        switch (value.
                  getPrimitiveType(
                    )) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_NUMBER:
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PX:
                return value;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_MM:
                org.apache.batik.css.engine.CSSContext ctx =
                  engine.
                  getCSSContext(
                    );
                float v =
                  value.
                  getFloatValue(
                    );
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  v /
                    ctx.
                    getPixelUnitToMillimeter(
                      ));
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_CM:
                ctx =
                  engine.
                    getCSSContext(
                      );
                v =
                  value.
                    getFloatValue(
                      );
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  v *
                    10.0F /
                    ctx.
                    getPixelUnitToMillimeter(
                      ));
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IN:
                ctx =
                  engine.
                    getCSSContext(
                      );
                v =
                  value.
                    getFloatValue(
                      );
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  v *
                    25.4F /
                    ctx.
                    getPixelUnitToMillimeter(
                      ));
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PT:
                ctx =
                  engine.
                    getCSSContext(
                      );
                v =
                  value.
                    getFloatValue(
                      );
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  v *
                    25.4F /
                    (72.0F *
                       ctx.
                       getPixelUnitToMillimeter(
                         )));
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PC:
                ctx =
                  engine.
                    getCSSContext(
                      );
                v =
                  value.
                    getFloatValue(
                      );
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  v *
                    25.4F /
                    (6.0F *
                       ctx.
                       getPixelUnitToMillimeter(
                         )));
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_EMS:
                sm.
                  putFontSizeRelative(
                    idx,
                    true);
                v =
                  value.
                    getFloatValue(
                      );
                int fsidx =
                  engine.
                  getFontSizeIndex(
                    );
                float fs;
                fs =
                  engine.
                    getComputedStyle(
                      elt,
                      pseudo,
                      fsidx).
                    getFloatValue(
                      );
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  v *
                    fs);
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_EXS:
                sm.
                  putFontSizeRelative(
                    idx,
                    true);
                v =
                  value.
                    getFloatValue(
                      );
                fsidx =
                  engine.
                    getFontSizeIndex(
                      );
                fs =
                  engine.
                    getComputedStyle(
                      elt,
                      pseudo,
                      fsidx).
                    getFloatValue(
                      );
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  v *
                    fs *
                    0.5F);
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PERCENTAGE:
                ctx =
                  engine.
                    getCSSContext(
                      );
                switch (getOrientation(
                          )) {
                    case HORIZONTAL_ORIENTATION:
                        sm.
                          putBlockWidthRelative(
                            idx,
                            true);
                        fs =
                          value.
                            getFloatValue(
                              ) *
                            ctx.
                            getBlockWidth(
                              elt) /
                            100.0F;
                        break;
                    case VERTICAL_ORIENTATION:
                        sm.
                          putBlockHeightRelative(
                            idx,
                            true);
                        fs =
                          value.
                            getFloatValue(
                              ) *
                            ctx.
                            getBlockHeight(
                              elt) /
                            100.0F;
                        break;
                    default:
                        sm.
                          putBlockWidthRelative(
                            idx,
                            true);
                        sm.
                          putBlockHeightRelative(
                            idx,
                            true);
                        double w =
                          ctx.
                          getBlockWidth(
                            elt);
                        double h =
                          ctx.
                          getBlockHeight(
                            elt);
                        fs =
                          (float)
                            (value.
                               getFloatValue(
                                 ) *
                               (java.lang.Math.
                                  sqrt(
                                    w *
                                      w +
                                      h *
                                      h) /
                                  SQRT2) /
                               100.0);
                }
                return new org.apache.batik.css.engine.value.FloatValue(
                  org.w3c.dom.css.CSSPrimitiveValue.
                    CSS_NUMBER,
                  fs);
        }
        return value;
    }
    protected static final int HORIZONTAL_ORIENTATION =
      0;
    protected static final int VERTICAL_ORIENTATION =
      1;
    protected static final int BOTH_ORIENTATION =
      2;
    protected abstract int getOrientation();
    public LengthManager() { super(); }
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
      ("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" +
       "qCj++Tv+2Y/8w1e/WR1c/l+pYTUdQSoAAA==");
}
