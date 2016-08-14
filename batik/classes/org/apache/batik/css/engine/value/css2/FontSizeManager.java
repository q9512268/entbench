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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "wFVYOvX6dqdMLlZk308W/HD9scOnhFmacozFWQ/bkuNhRU7vbfKHX734N8fu" +
       "uHtCZgUdhT1bgG/hvwa0+I3v/jNvXYRPmyJjCfAPRx95YFHXhg8Fv+dckLs9" +
       "kx+3wEF7vOseTn0Sbiv/ZZhUDJMGxcmhd2BUgn09DHmj7SbWkGfn9OfmgDLh" +
       "6cw6z5agY/NNG3RrXryEOlJjvS5gg4txCTfAt86xwXVBGwwRUdkqWFaJsgOL" +
       "tWL5SjipMi2Dg5QM8t5yWyTsHCRRdaplsvMIU1lUZB7gFVHbFiwLOVkzfYCX" +
       "GTKYt3TJWH4Zi8vlvOunsufM1HqEsHqOJ6/4V15kb/pMmOA+XVIoaRYJ/5Eb" +
       "Dx5ODBw9TxpxU24i2g3nrEdf//cLkXt//9wUmU4VN8xzNDbONN+cNThlzrbp" +
       "E+cJzwbfnnPnH3/aPrZpJjkJtrVOk3Xg76WgxOrCOzEoyjM3frBo+4bkrhmk" +
       "F0sDcAaH/F7fI89dtkq5MywOT3Jz5B26cpk6c7dEtcXglKhvz9kYK7IG0IwL" +
       "uwK+PscA+oIbwzO6VVh8LdfWq4uwFok9apE+sWSwyeaMwVEjAYsPkZPJBRry" +
       "jJ8VMf4v4MyxYZMp2ndlNZqLfavg2+5otH3mYBRiLaLweJE+UezlZK5q9+pJ" +
       "ZqngfyBFFMf83KQdjX4oHbchwVZTkHSNO0fSdYO7lAPtg3+Se/KsKRgkXfND" +
       "0Vt3vLH7BWG9lbhdsjbj2yqwrXypYgMWEfQLRQJWQJ7o/qZ39jzw3qNSnmB0" +
       "ChCzAwe/9XnktoPSX8hLhxV5534/j7x4CEi3vNgsgqPnz8f3//yh/beEHdyv" +
       "5KQibhgao3p2XULZSD4vF0Up6+Zv1j95e1NJD3iiXlKZ1tW9adabyN2NFXY6" +
       "7oPVu6fw9qYjNWarnIRWu2mEMHprtoz+bPh2Opa7c+ZGX4i1iGHfUaTvLiy+" +
       "Dec+1d6oqynKMXF2rR77rvUguXW2IFkJX9zRKz5zSAqxFlH7cJG+72BxH2RN" +
       "Kt4KCtstAMj9swBIE/Yth091tFJnDkgh1iJKf79I36NYfBcOHxAlXCT6YaO5" +
       "eVWDSNUxu3TyJw+hY7OAUD32tcJnOmqaM0eoEGsRFH5WpO9JLJ7IRSh71N/n" +
       "+Eb8s99Xv4GTEtW5B/f5PPx5s88R/WgWIGzEvmVI5eAwMXMIC7EWgemFIn0v" +
       "YvGMhHAzG6VpTZ5eXCM7e/rk3aMXwD07W8C1wHedo/11MweuEGsAnLAQJOzq" +
       "vxj1nzhfEWrbVInEWEZVqHaFrnKXZmUxjLqGhrpFTYj4VmA2N+A6Iy10Z0sY" +
       "qcjmgb7ujMJMTLAF8x+weJ2TGsVilDOBOza95IH/xmyB3wbfIQfBQzMHvxBr" +
       "AI4SeRSdbv+W2UnDKrCDsTyOxSlR/evUgOPPdwXBJ1i8z0mjBFV60qmg/WC2" +
       "oF0C31EHn6Mzh7YQa0DxciFIuWtpkWlsdohPapiT4OMjpIIeqliccEdpLzYK" +
       "DsGcM/1LqEiIFHZEoXJsPMPxMS9lpqe27s9mK/AvA5PokGPKvwWWQJTBy4b+" +
       "wOVIXZHBigDQVKRvHha18sA4YKmwINS9cz6RhSdU97+AJwOxIPDUgveCC/Me" +
       "fOUjpfLY4frKBYeveEPcTmQfEmvhgDWa1jT/zZWvXm5abFQVyNbKeyxT6NnC" +
       "yaov9hzESSn+QS1CiyXzUk6WT8sMzmPcjVcuY5vj5gswclIuK36elZC7T8UD" +
       "yQWUfsovQaYWpAQpxF8/3RpOqj06mFRW/CQRGB1IsBo13T0YnR6wGPziSWc1" +
       "MzLaLPbbgdhdzdOZj++SbEXOYVj8nwH3tJiW/2tgRDl+eGv/NacvOipfUBSN" +
       "7hMuvQbOiPKdRgyKd0TLC47mjlW+pePMnMerVrqH15wXHL9swohh44nXjkWB" +
       "JwW7Pfuy8OaR9Sd+faD8FTh27yQhysncnfm3tRkzbZElO2P5Z+Ed1BJvHZ0d" +
       "909uWDv6t7fEfTjJuwUP0o8orx276tU7Fx5pDZOaXlIG53KWEdfImyf1bUwZ" +
       "t4ZJnWp3Z0BEvBeiWs5Bew7uL4oRSuDiwFmXbcWnNU7a8q8P8h8kqzVjglmb" +
       "jLSewGHgqF7jtciVCVyzpU0zwOC1OEuJ5U0yVuNqgLmOxPpM032XKm0xhZe5" +
       "uWDoDm0SVax1/RfngoGgTyQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3SDDuxkOWCNBfRryqQi6ehYScFH+n4Z7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("JoIePIEDg+4fToNcB9QBSPH4vH/kLvCdFTYGb5F5OJvpPkA/ftqiS0e4dicz" +
       "OfW5+dwNH4nlbe2jD7rd/r72S8oXXqOY7/tm8/X9TTrFlvK8oPLAGLp/f6mv" +
       "JFp8FD5zS2pHtC6RL3zrkV+6/PzRB+wje4ZPvOsUb++9+VU1zPGj8nJZ/k/f" +
       "9Y+/+++/9tXyMsj/A2f8wuRGLwAA");
}
