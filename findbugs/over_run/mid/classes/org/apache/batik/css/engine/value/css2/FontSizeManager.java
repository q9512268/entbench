package org.apache.batik.css.engine.value.css2;
public class FontSizeManager extends org.apache.batik.css.engine.value.LengthManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LARGE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LARGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LARGER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LARGER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_MEDIUM_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          MEDIUM_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SMALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SMALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_SMALLER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          SMALLER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_X_LARGE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          X_LARGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_X_SMALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          X_SMALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_XX_LARGE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          XX_LARGE_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_XX_SMALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          XX_SMALL_VALUE); }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_SIZE_PROPERTY;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_SIZE_VALUE;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 MEDIUM_VALUE;
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
                                                                s);
                                                    }
                                                    return (org.apache.batik.css.engine.value.Value)
                                                             v;
                                                default:
                                                    break;
                                            }
                                            return super.
                                              createValue(
                                                lu,
                                                engine);
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
        java.lang.Object v =
          values.
          get(
            value.
              toLowerCase(
                ).
              intern(
                ));
        if (v ==
              null) {
            throw createInvalidIdentifierDOMException(
                    value);
        }
        return (org.apache.batik.css.engine.value.Value)
                 v;
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        float scale =
          1.0F;
        boolean doParentRelative =
          false;
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
                doParentRelative =
                  true;
                scale =
                  value.
                    getFloatValue(
                      );
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_EXS:
                doParentRelative =
                  true;
                scale =
                  value.
                    getFloatValue(
                      ) *
                    0.5F;
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_PERCENTAGE:
                doParentRelative =
                  true;
                scale =
                  value.
                    getFloatValue(
                      ) *
                    0.01F;
                break;
            default:
        }
        if (value ==
              org.apache.batik.css.engine.value.ValueConstants.
                LARGER_VALUE) {
            doParentRelative =
              true;
            scale =
              1.2F;
        }
        else
            if (value ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    SMALLER_VALUE) {
                doParentRelative =
                  true;
                scale =
                  1 /
                    1.2F;
            }
        if (doParentRelative) {
            sm.
              putParentRelative(
                idx,
                true);
            org.apache.batik.css.engine.CSSStylableElement p;
            p =
              org.apache.batik.css.engine.CSSEngine.
                getParentCSSStylableElement(
                  elt);
            float fs;
            if (p ==
                  null) {
                org.apache.batik.css.engine.CSSContext ctx1 =
                  engine.
                  getCSSContext(
                    );
                fs =
                  ctx1.
                    getMediumFontSize(
                      );
            }
            else {
                fs =
                  engine.
                    getComputedStyle(
                      p,
                      null,
                      idx).
                    getFloatValue(
                      );
            }
            return new org.apache.batik.css.engine.value.FloatValue(
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER,
              fs *
                scale);
        }
        org.apache.batik.css.engine.CSSContext ctx2 =
          engine.
          getCSSContext(
            );
        float fs =
          ctx2.
          getMediumFontSize(
            );
        java.lang.String s =
          value.
          getStringValue(
            );
        switch (s.
                  charAt(
                    0)) {
            case 'm':
                break;
            case 's':
                fs =
                  (float)
                    (fs /
                       1.2);
                break;
            case 'l':
                fs =
                  (float)
                    (fs *
                       1.2);
                break;
            default:
                switch (s.
                          charAt(
                            1)) {
                    case 'x':
                        switch (s.
                                  charAt(
                                    3)) {
                            case 's':
                                fs =
                                  (float)
                                    (fs /
                                       1.2 /
                                       1.2 /
                                       1.2);
                                break;
                            default:
                                fs =
                                  (float)
                                    (fs *
                                       1.2 *
                                       1.2 *
                                       1.2);
                        }
                        break;
                    default:
                        switch (s.
                                  charAt(
                                    2)) {
                            case 's':
                                fs =
                                  (float)
                                    (fs /
                                       1.2 /
                                       1.2);
                                break;
                            default:
                                fs =
                                  (float)
                                    (fs *
                                       1.2 *
                                       1.2);
                        }
                }
        }
        return new org.apache.batik.css.engine.value.FloatValue(
          org.w3c.dom.css.CSSPrimitiveValue.
            CSS_NUMBER,
          fs);
    }
    protected int getOrientation() { return VERTICAL_ORIENTATION;
    }
    public FontSizeManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5U0TvUjkYhFV/wswtTHHDCMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "f+Qu8J0VRoCvyDgczXQfoB8/bdGlI1y7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("k5mcWm4+d8MisbyNfbSgi/f3sV+Sv/TaZPZ930Jf39+Gk20pzwsqDxDQ/fuL" +
       "eSXRYlH4zC2pHdG6hL/w7Ud+6fLzRwvYR/YMn3jXKd7ee/PrZgPHj8oLYvk/" +
       "fdc//u6fe+3r5YWO/wfOWz3eJi8AAA==");
}
