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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16eewsyX1Xv9/uvj1s73u7ttfL2rv22s+Jdyf8enqunmFD" +
       "cM9M91zd0zN9zXQDee5rpnv6vqaPsCQ2AjsJMhZZO0YkK0C2AOPEAREFCYw2" +
       "QuBEMUiGyHYixbZCBDmwFP9BgjAQqnt+9zuWlSNG6prqqm9963vVp6qr6vPf" +
       "hh6KQqjme3a+tb34WM/i453dPo5zX4+Op2R7IYeRrg1sOYo4UHZbfe8v3Pij" +
       "737CuHkEXZegt8qu68VybHpuxOiRZ+91jYRunJfitu5EMXST3Ml7GU5i04ZJ" +
       "M4pfIqE3XWgaQ7fIUxFgIAIMRIArEWDsnAo0eovuJs6gbCG7cRRAfxW6RkLX" +
       "fbUUL4aev8zEl0PZOWGzqDQAHB4p3wWgVNU4C6H3nOl+0PkOhT9Zg1/56R++" +
       "+c8egG5I0A3TZUtxVCBEDDqRoDc7uqPoYYRpmq5J0BOurmusHpqybRaV3BL0" +
       "ZGRuXTlOQv3MSGVh4uth1ee55d6slrqFiRp74Zl6G1O3tdO3hza2vAW6PnWu" +
       "60FDoiwHCj5mAsHCjazqp00etExXi6F3X21xpuOtGSAATR929Njwzrp60JVB" +
       "AfTkwXe27G5hNg5NdwtIH/IS0EsMPXNPpqWtfVm15K1+O4aevkq3OFQBqkcr" +
       "Q5RNYujtV8kqTsBLz1zx0gX/fHv+gx//EXfsHlUya7pql/I/Aho9d6URo2/0" +
       "UHdV/dDwzS+Sn5Kf+uLHjiAIEL/9CvGB5pf+ync++APPvfYrB5p33oWGVna6" +
       "Gt9WP6M8/pV3DV7oPVCK8YjvRWbp/EuaV+G/OKl5KfPByHvqjGNZeXxa+Rrz" +
       "78Qf+5z+B0fQYxPouurZiQPi6AnVc3zT1sOR7uqhHOvaBHpUd7VBVT+BHgZ5" +
       "0nT1Qym92UR6PIEetKui6171Dky0ASxKEz0M8qa78U7zvhwbVT7zIQi6CR7o" +
       "7eB5P3T4Vf8xpMCG5+iwrMqu6XrwIvRK/SNYd2MF2NaAFRD1Fhx5SQhCEPbC" +
       "LSyDODD0kwo1Kmm3QCZ4L9uJDpPgLTYo2QXhEB6Xseb/f+klK3W9mV67Btzw" +
       "rqsgYIPxM/ZsTQ9vq68kffw7P3/7147OBsWJlWKo7Pj40PFx1fEx6Pj40PFx" +
       "1fHxpY6ha9eq/t5WCnBwOXCYBYY+AMU3v8D+5emHPvbeB0Cs+emDwNolKXxv" +
       "bB6cg8WkgkQVRCz02qfTDws/Wj+Cji6DbCk0KHqsbL4oofEMAm9dHVx343vj" +
       "o7/7R1/41Mve+TC7hNono//OluXofe9V84aeqmsAD8/Zv/ge+Rdvf/HlW0fQ" +
       "gwASAAzGMrAhQJjnrvZxaRS/dIqIpS4PAYU3XujIdll1CmOPxUbopeclld8f" +
       "r/JPABtj0ElyKc7L2rf6Zfq2Q5yUTruiRYW4f571f/br/+H3mpW5T8H5xoXp" +
       "jtXjly4AQsnsRjX0nziPAS7UdUD3W59e/NQnv/3Rv1gFAKB43906vFWmAwAE" +
       "wIXAzH/9V4Lf+OY3PvPrR+dBE4MZMVFsU80OSv4J+F0Dz/8pn1K5suAwmJ8c" +
       "nCDKe84gxS97/r5z2QC42GDolRF0i3cdTzM3pqzYehmx/+vG+5Ff/G8fv3mI" +
       "CRuUnIbUD7w+g/PyP9OHfuzXfviPn6vYXFPLye3cfudkB8R86zlnLAzlvJQj" +
       "+/B/fPbvfEn+WYC9AO8is9ArCIMqe0CVA+uVLWpVCl+pa5TJu6OLA+HyWLuw" +
       "CLmtfuLX//Atwh/+6+9U0l5exVz0OyX7Lx1CrUzekwH277g66sdyBJDBb702" +
       "/0s37de+CzhKgKMKEC2iQ4A92aUoOaF+6OHf/OV/89SHvvIAdERAj9merBFy" +
       "NeCgR0Gk65EBYCvz/8IHD9GcPnKK5Rl0h/KHAHm6ensYCPjCvbGGKBch58P1" +
       "6f9J28pHfvt/3GGECmXuMvdeaS/Bn/+ZZwY/9AdV+/PhXrZ+LrsTj8GC7bxt" +
       "43POfz967/V/ewQ9LEE31ZPVoFCiLRhEElgBRadLRLBivFR/eTVzmLpfOoOz" +
       "d12FmgvdXgWa83kA5EvqMv/YFWwpHwgBz4sn2PLiVWy5BlWZD1ZNnq/SW2Xy" +
       "/ZVPjsBQjqrlZgx6N13Zrjp4AbyxS4Zr3N9li9B0AObsT5Y78MtPftP6md/9" +
       "ucNS5qp/rhDrH3vlJ/7k+OOvHF1YQL7vjjXcxTaHRWQl31sqIcuIf/5+vVQt" +
       "iP/6hZf/5T96+aMHqZ68vBzCwWr/5776v798/Olv/epdZt/rmgdwTj/gc5k2" +
       "ywQ7RHXnniPgpTP/vLMs/XPg+eqJf756h3+unSF1GTLHE7C4BvP4k7/99z7z" +
       "xx/+aPeoBJyHqokeSH/znG6elB8Ff+Pzn3z2Ta986ycrcD5lvby7rx+IoUf9" +
       "0ItBROpaWTwsE/zU4U+NaWYi0XMOI2+DHA4y3ISeV1xGJ/Yu/2Yx9AD4Arhi" +
       "E+YN2qQLnq+d2ORrd7FJmWHLuabM3L6HQmV2facmbxNwhpsMLutR1klXhP7Q" +
       "GxS6BZ6vnwj99fsIfVRmtm9M6Jt9mhu/nsDG6wp8cNQ1MEU/1DhGj+vlu3cf" +
       "ST5wpyTv2NnqrdNpWwAfngB1b+1stGr/9vhiEB6+1q4I+cL/s5Ag8h8/Z0Z6" +
       "4MPvJ3/nE1/+W+/7Jgj76WnYl9QciAThx/8p+q3yJXtj+jxT6sNW63hSjmKq" +
       "Wh/o2plKV4L7Qdv7HlSKb/zOuBVNsNMfiUiDRqpmjKPTBWw2cDeixzhrxUab" +
       "li01NZoGJzUcetKej6nOomG1LNJcrROl3tbbdK+5EprFrqMY2ynroIwgMz61" +
       "xXzWx8Q+zxtLQVu6M8xgljhmTwbCksH7y1joY9ZsOhC0kIXbsLZfN9W07gvg" +
       "04wu1GYN7hbdHezW4HYX7W1HgGGTTe2l3mKoDpXPtZlR2xqRzbpLDylWuMjW" +
       "jaYwHyw0FOW0xkoUqM3UJYigZ4W8NK/nPDJ13CFHBpHjz3ajYofivLpNxWLE" +
       "jUb0KvcjaWo1ioY0Zgjb4fSgw4u4k7uMV1C+lCrqjiRXYreHsZs5pRlTgU6t" +
       "hkF0m0xrF+XM3G0Op0TTndAFsreG5C50hLxuDBVO1bw5FdtTJuA4raNT3V07" +
       "CSRqN9jKOxRTd7VsRYaCEA2FhiziM2HXVuGu7fbromJgocMLayHpDxfjEev4" +
       "Xp4Jk4JPOnNtECUi0qYUll9RyNiZ0CtnTovxSNRwj6T9SQch+6ijFnNp7yOT" +
       "Zas5dfyVr6XLdh518ZrJt+YOOrJG2bRtGIaf5HlHXGqhra+seLaM8f2i2e3M" +
       "lxqdxbWVNQ5aHUYXPC2ls2m0jShTFTAvz1lJXMsWb6bCtDkXqIW4pBpskE/p" +
       "hs/Ec51n7QW2d7QeO9gijjZaTecCom2Z9nCe475KwaTpi8KwodSC+tbTMMFa" +
       "J+RUxl1lR2OGOOsuRrvhktijc2m230xkL+AkfkTvJ3mMpFg/otAJNewEbUkP" +
       "hIFFWbhCMgwb7Cx2nC7WPM4O4nqE9Yd8a2W3U16TEU5edjVx6dZzbKhtF/ws" +
       "GIkzhsXIaR3pUzucW43sLMU9vdYslnFtvBr1lrHsm7hIdf2p6bTgwt/KWysd" +
       "KpM6lZkq1oozJA7FiRJu6xvEWHqD1ozvR/VN0R019P0q1vKu45CSZTHOHrUU" +
       "U8mM8dKidZ3wJSQWEGU7d/x6IXFMbYhOM9ZSonmt3m4ymIOt26MNYWdju63u" +
       "B02k167bZH09DfmeT4SsPUpH8MhM/JFQX63GI4TP7H7CRwg/d6jdWphpaNPq" +
       "u8td1wqiuoLWGw7XZdpsIJqGbDW7fWNli0uf59lmXeJWMb1uaF17zBQ1B7cw" +
       "qcX2qW7QchFcq6nTGb1beRIR8Iyw0lYm1pJHXT9mltPU6ozFurNl982MQmI5" +
       "7ZPGTthNca/PdUVpI5I5z8m4ZnDaJA1WjEiE/dDwUITvr9V0khhhbd+zbaaY" +
       "0U63S2CTgsQagy1GulIrcYDRGWsm5w4a0mOr25ULSxxvfYVtF9vUIMKWaIg0" +
       "NiGZTk5MGqRhjnoGvg2mPV3Z9c2c23bHjXSOj9EpgAeX0xC7iQqIjIU1d2fL" +
       "/RgMWt+sjzRy12p5086S23G0a2eZtK9zojCRJi2Eb9lOIOI7n8JFLJwtez3X" +
       "0W2R89qYPG1Lre1WG8/rA3aFeWlAsEW0WgV1aqVs6cGmWHBUa7JMFzLK1LGB" +
       "09k0ybzYj5S4CRfpDpvWatSAtC3CmigR1to5usYkQ33aj9Zu2EObRS7aQ73g" +
       "16N13s88Z9GXUi/tBlsm5QSrPVyRgb6Y9lGtkYf8wqCXDkKldKtvsk1sPoYH" +
       "dTof0FHMYunInecERqwLqxMmq52xU5Ld1li7Yjy3aiukg8/6w2XYhbvBchN1" +
       "w31z3xQDYjpFOF5vkF2cXsRjdzfIGY/AKQRZrElRxApvHfaKFqkoi57ZXKLb" +
       "HT9Lg9jBwtivY2wD0+r0oOmGaA3hNvR4aAma3RCXzYKemuN5vrSlttul3QwD" +
       "/YrjyZIfkyPDR0kuU9aW3hozqi420HkL6/RFDHPlOeKkfjKbabZjL0XX78FI" +
       "0NPh7g6NC0ls29I2W4xWmjZftCadTdxy1R5d0Byyx+cDfLrsNMJFe0OlSa+N" +
       "RqlmWLir9mttB+lF+yTy9W0Px6z+hm+3LcweTOuYyvTDjO/Q00FdaLH6WG3P" +
       "g3getmB018bdKe9P+vV2bz7eo0yrphHKHmkjjJ7AGrvXmvkkimYRsR1HTLRJ" +
       "6YXS54LGoEmnRkvoe3N/wC2xApZm3Ebo7Xm8XetH+5EoWNPlfBfNUyxRi/Y6" +
       "CpxQ2hdGl1VX6Dgwth6LsnLDrAvLJrEE0zXGLKSa6E1GCA3XfAHZoSO5XaRW" +
       "ThEj0xOXAyBEA92EXkEbPO9s0HEqZftk0cxGyUxICoXAu4Rq1hbRUgi4PWri" +
       "cC0m7T0Kw0ZrMwqX7Dbk2Ly/2a5geb5hNTRH4i6JDiZpyBs5ngwWTAvM34pR" +
       "tJrJoJnyALTQObEUI2xkrnud2c5RaoSAiPCIFYtWwPSjeGGjjEm3iGI84fm6" +
       "y6Qy74QbvVnrSDW+ga7ddN338HlUy5eCUWD5um4xIXAZVaP72jzpd/RYERfh" +
       "ttkRJ+aksJV+ZMl1RTMjvCaSGBqIEwN2IzDb82Cd4iJJi6nTUiISdmeUDNNs" +
       "097m6SgKiKjusdhspGJTahMpi5G5FZosHMv9BRLQKtFi+l6SdMSx10P1TXPf" +
       "ULc0Jg9Jd7jbD/QtFhiN5SIeagbeJXNBVYbYJpiiox4sqrCKDhEXHax9bjvd" +
       "xS4cJu02ofh55sV00BeWvJ9Im3GwtQYJEjOKse7XN00Xb8YwrA71jSYno31T" +
       "UhiVV9JaD57B7sTVazU+Z6SZ1/H50VZcWNw4Ct3lYtFrhJLV2OdaLe6q8qzw" +
       "jP1QWTaCPHCznr1fWfCk1Uy7qbPQfbCQaq5Hq6ZPYX6G2x7ZHfWJ1Sjfp7Qo" +
       "5x2+YU9Yt1g761Vrtlu3FFfS9vbabKdtBKshyWRqwgwWLaW2qM+VXoa2e7TU" +
       "E1rLTCLYadYf80htyPZWqyxfFI1IS5ROR9HhKYpRKy0INjsmoPuW77S9MdZK" +
       "2RqRjgult93QWUJlzmQzjTsMHJmbTXO43uB4PAy3UTvlmrWNMyKXvW3YbSSK" +
       "v+7GU2OVrttZK2xFPZwnV76KcDGxGaixq6GJZwSRSqvIejvdr/pNDXEIm/AG" +
       "VIzGa3ExXEhITdMHKIcPcnRozwzf72QC2rC5GWsoo6KH1lbhfMm6QybqGLBO" +
       "+WBWbcvMzFYHnkKgGKsiRH/Ibmc7MKv73Y7l+n1qyfmpO+CatM+C9cmC1xKH" +
       "C9RO2NtvtB3t1aYpRprOujNIKbDYW7qdgqxxTdOJFvNmp7ZINtsG2ovGml0n" +
       "9zy/CwWKL8YG2hDSMNZX/b27FfxOp83WSKPQaXQXjOuOIS3xfX8GbLbYKBSy" +
       "Sqxtg8iyBkX0vBk64XpckvUEOW2OopYSZD1CgINBjZh2PEXTvPqM0OI8TIkm" +
       "USdTs6U4DSlfziRtvsvpPYHirEZGOLbZI1tWU+zplN2NVXSK26tGUPQbMqKv" +
       "ZjWqYwBYYvB2UpuhAxnvkJHDiO2gs6pzI6bYNHprzpl0HCtK4cxUGoXpW2k6" +
       "isXmJM4KmqwjsKUPWROlWnOmObCpmqyuBhwZSXCL3KgD1wDfcFNOYvNxIRMD" +
       "ui2Y5Ip2qWBkDRxv6NWXqSOJzaEkjAZCy8gXYxOJ2E0vDQbrxriYTAY7SSES" +
       "F4ADpmpwC3wQdvqabTak1tRpEJzfQUk+yPoJmxBG4mtumlER0h7RE27gK5Q+" +
       "3S+QRZp1nWWI7PhsF3fj1DOGdRsMYT9fLRXc0wYJrqNTyt6k3bmptpu+4fZm" +
       "Wc/ZTh19k5LUJJkgTjN1SQLROzK1Er3RMhsZvVRdKtZIGqmx19L4HEXQYdsU" +
       "6LaXpk0HnogDN1gvbGvdb2g1G/ZmlGoksKKrjSmzD3bbXbYOi3To1+hxx/FW" +
       "47hdX7U4ARa5Lok5fCfId3oUj7mwJ85tXyZEko4m8XSGzGFHolb1BuXGLhFG" +
       "cA4meb7XUAe7/oBeTZDNON9jkSQOcZ0dO0ZPmNWGNdVgMQfF5z092XbbwXrt" +
       "i8QobOXr9qyb0tP5rrcaa3TdWXNZK6LpGs5Ou3SDzVGr6Li5EmMA6+NWPewL" +
       "+z1DwNTe8fu+1GnWGsaYM7tzuTbqtnXN7yHg69PXxhNW6jhDK8o7aJS7szye" +
       "FYlCCUrDRhWqPez2VJRlGnsvXqK9Dk6lM8ys74eZOFJoMBQ29XGz4+PzXdGA" +
       "97BPBKTUsPpDW5p3wNdbsnCnHWIxJsYhOawbc4Ze951GDCOemNCd3kTf07og" +
       "5uOaRMyYBTvbJPtax962EjqeMNOxxLQtks5d0pw3uNwY7qZ+MTG5hkJKtkjF" +
       "qZnmwjpDUCbtgg+MvqDvCCHZRPBgp/NjOo/CQUCixTpEVnV1JUX1cBYEWG5Q" +
       "Qbtg2nkdkTaZtOZ7KT2g9UEr12yPGc3q/bWfTHrg61RFESUR8LUM1tkrxhkF" +
       "Fr/Wi0UNK3beQgn64xTDys/9v/bGtiGeqLZVzk7EdzZaVlzdR7vfTsM99j2q" +
       "3aYPxNAjshLFoazG2dmuVfW7Ad376OnC9jxUbqc+e69T8Gor9TMfeeVVjf4s" +
       "cnRyrEHG0KOx5/9ZW9/r9gVWDwJOL95725iqLgGcb7d/6SO//wz3Q8aH3sCB" +
       "4ruvyHmV5T+mPv+ro+9T//YR9MDZ5vsd1xMuN3rp8pb7Y6EeJ6HLXdp4f/by" +
       "xvu7wAOfWBa+uh947tg7PFZtan7gEBhXTo2ODi493Wt7Z3n8mzbV6tQ3ktVj" +
       "UgdfxrLNu2Z8SvP++x0RD1gWr3JVb3/3Sm/XTg6BTzg9fdqb5jnHQ5rCM1X3" +
       "S09Ujf9+mXwqht6khroc69Vxx2nL73/9Y+pz+irQf/r1ttQuHiNVBT912fjP" +
       "g0c7Mb72p2/8K7uCD0WGF8Z3rdnYnhxX/L5wd/OWr/+gIvilMvlcDN08mJAo" +
       "W1Z2Kcs/e26cf/K9GudZ8BQnxin+dIxzvSK4furx49eJOjbO7fIQtryfpR+O" +
       "C6rk1TKRTrncuh+XkoVOyZXUn61k+uX7nLF+qUz+VVzecHL85CQ+r9j1i9+D" +
       "XasTgBfA840Tu37jDdi1wuhq1/9v3tW4FxX5yn3q/lOZfDmGHt/qMR2awLDy" +
       "6Zm/dK7mv38jamYx9JZLV0jKM/Cn77izdrhnpf78qzceecer/NeqWxRnd6Ee" +
       "JaFHNoltXzyyvJC/7of6xqwUePRwgOlXf78ZQ8+/LnDEJ+cAleC/cWj4WyfI" +
       "eI+GMXT9kLnY5lsx9La7tYmhB0B6kfI/gwF6lRJIUf1fpPsvMfTYOR3o9JC5" +
       "SPJ7gDsgKbO/758Gfef1wRI7mcqrID7xS3bt8mx95u4nX8/dFyb4912alqsL" +
       "jKdTaHK4wnhb/cKr0/mPfKfz2cONE9WWi6Lk8ggJPXy4/HI2DT9/T26nvK6P" +
       "X/ju47/w6PtPlwyPHwQ+HyoXZHv33a904I4fV5cwin/xjn/+g//w1W9Uh53/" +
       "F2tlmeBZKgAA");
}
