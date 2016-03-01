package org.apache.batik.css.engine.value.css2;
public class FontWeightManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BOLD_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BOLD_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_BOLDER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          BOLDER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LIGHTER_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LIGHTER_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NORMAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NORMAL_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_FONT_WEIGHT_VALUE; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_WEIGHT_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INTEGER) {
            int i =
              lu.
              getIntegerValue(
                );
            switch (i) {
                case 100:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_100;
                case 200:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_200;
                case 300:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_300;
                case 400:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_400;
                case 500:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_500;
                case 600:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_600;
                case 700:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_700;
                case 800:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_800;
                case 900:
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_900;
            }
            throw createInvalidFloatValueDOMException(
                    i);
        }
        return super.
          createValue(
            lu,
            engine);
    }
    public org.apache.batik.css.engine.value.Value createFloatValue(short type,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException {
        if (type ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_NUMBER) {
            int i =
              (int)
                floatValue;
            if (floatValue ==
                  i) {
                switch (i) {
                    case 100:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_100;
                    case 200:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_200;
                    case 300:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_300;
                    case 400:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_400;
                    case 500:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_500;
                    case 600:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_600;
                    case 700:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_700;
                    case 800:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_800;
                    case 900:
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_900;
                }
            }
        }
        throw createInvalidFloatValueDOMException(
                floatValue);
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value ==
              org.apache.batik.css.engine.value.ValueConstants.
                BOLDER_VALUE) {
            sm.
              putParentRelative(
                idx,
                true);
            org.apache.batik.css.engine.CSSContext ctx =
              engine.
              getCSSContext(
                );
            org.apache.batik.css.engine.CSSStylableElement p =
              org.apache.batik.css.engine.CSSEngine.
              getParentCSSStylableElement(
                elt);
            float fw;
            if (p ==
                  null) {
                fw =
                  400;
            }
            else {
                org.apache.batik.css.engine.value.Value v =
                  engine.
                  getComputedStyle(
                    p,
                    pseudo,
                    idx);
                fw =
                  v.
                    getFloatValue(
                      );
            }
            return createFontWeight(
                     ctx.
                       getBolderFontWeight(
                         fw));
        }
        else
            if (value ==
                  org.apache.batik.css.engine.value.ValueConstants.
                    LIGHTER_VALUE) {
                sm.
                  putParentRelative(
                    idx,
                    true);
                org.apache.batik.css.engine.CSSContext ctx =
                  engine.
                  getCSSContext(
                    );
                org.apache.batik.css.engine.CSSStylableElement p =
                  org.apache.batik.css.engine.CSSEngine.
                  getParentCSSStylableElement(
                    elt);
                float fw;
                if (p ==
                      null) {
                    fw =
                      400;
                }
                else {
                    org.apache.batik.css.engine.value.Value v =
                      engine.
                      getComputedStyle(
                        p,
                        pseudo,
                        idx);
                    fw =
                      v.
                        getFloatValue(
                          );
                }
                return createFontWeight(
                         ctx.
                           getLighterFontWeight(
                             fw));
            }
            else
                if (value ==
                      org.apache.batik.css.engine.value.ValueConstants.
                        NORMAL_VALUE) {
                    return org.apache.batik.css.engine.value.ValueConstants.
                             NUMBER_400;
                }
                else
                    if (value ==
                          org.apache.batik.css.engine.value.ValueConstants.
                            BOLD_VALUE) {
                        return org.apache.batik.css.engine.value.ValueConstants.
                                 NUMBER_700;
                    }
        return value;
    }
    protected org.apache.batik.css.engine.value.Value createFontWeight(float f) {
        switch ((int)
                  f) {
            case 100:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_100;
            case 200:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_200;
            case 300:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_300;
            case 400:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_400;
            case 500:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_500;
            case 600:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_600;
            case 700:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_700;
            case 800:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_800;
            default:
                return org.apache.batik.css.engine.value.ValueConstants.
                         NUMBER_900;
        }
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FontWeightManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZe2wcxRmfO8fnR+z4lTipkziJ44QmgTtCeJSaUowTY8M5" +
       "duPgqk7Bmdubsxfv7W525+xzIIVQtaSgpogECoXkn4Y+ooSgFlREgYY+eAgo" +
       "4qE2gAptqcS7IqglPNrS75vdvd3bu1vXSqRa2vHeznwz3/eb33zfNzOH3iPl" +
       "pkHadKomaZRP6cyMDuD7ADVMluxSqGluhq8j0o1/2XPtiReqdoZJZJjMGaNm" +
       "n0RN1i0zJWkOk8WyanKqSszcyFgSJQYMZjJjgnJZU4fJPNnsTeuKLMm8T0sy" +
       "bDBEjThpoJwbciLDWa/dASdL4kKbmNAm1ulv0BEnNZKmT7kCLXkCXZ46bJt2" +
       "xzM5qY9fRSdoLMNlJRaXTd6RNcgaXVOmRhWNR1mWR69SzrGBuDR+TgEMbffW" +
       "ffjpzWP1AoYmqqoaFyaam5ipKRMsGSd17tcNCkub28g3SFmczPY05qQ97gwa" +
       "g0FjMKhjr9sKtK9laibdpQlzuNNTRJdQIU6W5XeiU4Om7W4GhM7QQyW3bRfC" +
       "YO3SnLXOdPtMvHVNbO/3r6z/WRmpGyZ1sjqI6kigBIdBhgFQlk4ww+xMJlly" +
       "mDSoMOGDzJCpIm+3Z7vRlEdVyjNAAQcW/JjRmSHGdLGCmQTbjIzENSNnXkqQ" +
       "yv5VnlLoKNja7NpqWdiN38HAahkUM1IUuGeLzBqX1aTgUb5Ezsb2y6ABiFak" +
       "GR/TckPNUil8II0WRRSqjsYGgXzqKDQt14CChuBaiU4Ra51K43SUjXCywN9u" +
       "wKqCVlUCCBThZJ6/megJZqnFN0ue+Xlv4wW7r1Z71DAJgc5JJimo/2wQavUJ" +
       "bWIpZjBYB5Zgzer4bbT54V1hQqDxPF9jq80vrjl+0emtR5+w2iws0qY/cRWT" +
       "+Ih0IDHnuUVdq84vQzUqdc2UcfLzLBerbMCu6cjq4Gmacz1iZdSpPLrpsa9d" +
       "d5C9EybVvSQiaUomDTxqkLS0LivMuISpzKCcJXtJFVOTXaK+l1TAe1xWmfW1" +
       "P5UyGe8lsxTxKaKJ3wBRCrpAiKrhXVZTmvOuUz4m3rM6IaQCHlIDzxpi/Yn/" +
       "nEzFxrQ0i1GJqrKqxQYMDe3HCRU+h5nwnoRaXYslgP/jZ6yNnhcztYwBhIxp" +
       "xmiMAivGmFUZk0wzxtRR0DA2QZUMww9nxboBuK8yeXSM91EVWGJEkYL6/3Pw" +
       "LCLTNBkKwaQt8rsMBVZbj6YkmTEi7c1cvOH4PSNPWXTEJWRjyskXQIOopUFU" +
       "aBCFAaOWBlGhAX44K1qgAQmFxMBzUROLKTDP4+AxwGXXrBq84tKtu9rKgKL6" +
       "5CyYJGy6siCEdbmuxYkHI9Kh5zadePaZ6oNhEgbvk4AQ5saR9rw4YoVBQ5NY" +
       "EhxZqYjieNVY6RhSVA9y9PbJnUPXnin08IYG7LAcvBqKD6BDzw3R7ncJxfqt" +
       "u+HND4/ctkNznUNerHFCZIEk+pw2/zT7jR+RVi+l9488vKM9TGaBIwPnzSnM" +
       "JfjFVv8Yeb6nw/HjaEslGJzSjDRVsMpxvtV8zNAm3S+Cfw1YzLOoiHTwKShC" +
       "wJcG9X3Hfv/WOoGkEy3qPGF+kPEOj4fCzhqFL2pw2bXZYAza/en2gT23vnfD" +
       "FkEtaLG82IDtWHaBZ4LZAQS/9cS2l1579cCLYZeOHEJ0JgHZTlbYMvcz+AvB" +
       "8x980KvgB8u7NHbZLm5pzsfpOPJKVzfwdgoseiRH++UqkE9OyTShMFwL/6pb" +
       "sfb+d3fXW9OtwBeHLadP34H7/XMXk+ueuvJEq+gmJGG0dfFzm1kuvMntudMw" +
       "6BTqkd35/OI7Hqf7IBiAAzbl7Uz4VCLwIGICzxZYxES5zld3Lhbtppfj+cvI" +
       "kxWNSDe/+H7t0PuPHBfa5qdV3nnvo3qHxSJrFmCw84ld5Pl4rG3WsZyfBR3m" +
       "+51ODzXHoLOzj278er1y9FMYdhiGlcDFmv0G+MBsHpXs1uUVLz/6m+atz5WR" +
       "cDepVjSa7KZiwZEqYDozx8B9ZvUvX2TpMVkJRb3AgxQghKAvKT6dG9I6FxOw" +
       "/YH5913w4/2vChZatFuY841LC3yjyNvdZf3uK3e+/qsTP6ywov6q0r7MJ7fg" +
       "k34lcf1fPyqYCeHFimQkPvnh2KG7WroufEfIu+4EpZdnC+MOOFxX9qyD6X+G" +
       "2yK/C5OKYVIv2TnyEEYVWMnDkBeaTuIMeXRefX6OZyU0HTl3ucjvyjzD+h2Z" +
       "G+/gHVvje62PdQtxFi+E50ybdWf6WRci4qVHiKwQ5eexWCOmsIyTKt3QOGjJ" +
       "IK+NmCIh56CJrFIlmxtHsKUlYByQFVHXFCILOFkzfYC2MmAgtOWEsTwPi15r" +
       "3I5iDM4WtyOEr6e7+oq/SMBq9NCY4MpcXCopFgn9gev37k/2373WInFjfqK5" +
       "AfZRh//w76ejt//5ySKZShXX9DMUNsEUz5izYchlBUunT+wZXB6e9/yJsldu" +
       "WVBTmFFgT60l8oXVpdeYf4DHr3+7ZfOFY1tnkCos8QHl7/KnfYeevGSldEtY" +
       "bHss2hdsl/KFOvLJXm0w2N+pm/Mo35ab2iacspXwdNpT2+mnvEunFVgM5bO4" +
       "OkA0II6MBtTJWCQ4aZLNXnUMNqywmCDDEXtSEXk8E41nFIOZhMkHDDkNWcOE" +
       "vYM60nxi228rtq93dkfFRKyWl5l9zz7Y88aImLRKZEUOKg8jOo1RT7ZTj8UZ" +
       "SPQAD+zTKLaj8bXxu948bGnkd7e+xmzX3hs/i+7eay0Aa5e8vGCj6pWxdso+" +
       "7ZYFjSIkut84suOXP9lxQ9jGfpiTioSmKYyqubkJ5cJTsx9HS9vI2n0fX/vt" +
       "Y/2Qa/aSyowqb8uw3mQ+DSvMTMIDrLu1dklp640pFyeh1bodHYUTkwKcWGEY" +
       "xg8Xic9X5hP9NHh6bLb2zJzopUQDyLwzoO6bWFzDyVzZ7FTlNOWY6zlMx7q0" +
       "C8COUwPACnj6bSv6Zw5AKdEAI78bUPc9LHZBkJfxkEows4T53zlp8+uwqhWe" +
       "IduGoZmbX0o0wMQ7AuruxGIv5MKjjDt25/ZV4/Yqxn+q5x22cGWyfcToWZ34" +
       "c9KzYG49acAasWoZPFfYVl8xc8BKiQaAcjCg7hAWd+cDthF8jJMl1YvcG3NF" +
       "Oxty8fjRSePRgFVL4UnaRiVnjkcp0QCbHwioexCLn1t4rGcpmlGstNnB47Tp" +
       "s0a3vYDpvlMD0yJ4xm1bx2cOUylRHxRhoUfYsXYhWju5ThJGmlSKxllWlqhy" +
       "uSpzp82KIES6Bgc3iDeh4mO+0ZwwaPe0wBktqaWj6/v7NmQlpmO2J4SfxuJR" +
       "TmZLBqOcCZTx00Mu1L8+NVDjCr3JxuummUNdSjQA6gDPVA67ZSPINwXJpmDv" +
       "XUJWGHKs+ITgz2dEg79h8QK4AQv0buyvGPIvnhrkF8Nz2Ibv8MyRLyXqszIi" +
       "9Ig4tItOQ+BBPqVgGoEXWkwVh0z3YPEkFvucXtqDesEumL2PfEgY8vcAH/QP" +
       "LN7ieEGU1jPFqf72SQMudqHt8ByzUTsWALgo/dvZuG/7XRvQWWmivSrG+aw0" +
       "HiHR7GOXhLkTcx8mn5w0JvOwajk8H9hmfDBzEpYSDTBwdkBdLRYRTuZAQOpN" +
       "Av/klMysvfRXcqaHKmZuepaThoLLBzxuW1BwSWpd7En37K+rnL//8j+KA/Dc" +
       "5VsN7PFSGUXxngZ53iO6wVKywK3GOhvShV1zOVn5v12RcDIL/6EZoSZLeD4n" +
       "y6YVBv834YRiR7DFjmklBDmJWC9emcWwnSgmA1kjlN6WS4Gj/paghfjvbbec" +
       "k2q3HQxqvXibrITeoQm+nqY7Pmbd9IC5FLFnNGuF19xJUm61zJuOMp7Dp+V5" +
       "e3Jx1+5sWTPWbfuIdGT/pRuvPn7u3dZdhKTQ7duxl9mwUbVuPESneEKzrGRv" +
       "Tl+RnlWfzrm3aoWzh867C/HqJpgMjkTcG7T4DufN9twZ/UsHLnjkmV2R52H3" +
       "v4WEKCdNWwpPQbN6xiBLtsSLbcmHqCHuDTqqX9/67EcvhxrFYTOxNvGtQRIj" +
       "0p5HXhlI6foPwqSql5TLapJlxRHt+il1E5MmjLwdfiShZdTctfwcXGUU826B" +
       "jA1obe4rXlNx0lZ4jlF4dVetaJPMuBh7x25qfWdaGV331gpkJ7aJdAKRBjqO" +
       "xPt03b69KVsokNd19CWhL+KPyf8C8NNmw1AjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "T+lAp/vCWZIPAOmApCj+gHccGRpvbrBT");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("5zga0Wy/PD1x1q/L6fDomznLmU/R5859QJZvt48/9uL96+2XpC+/hlE//t32" +
       "F/av5iRLyPNCyv0EdGX/gK8UWnwwPntLaceyLk9f+P7Dv/LA88cftw/vFT6d" +
       "Y2d0e+/Nn6WNbC8qH5Ll//Jdv/bDv/TaN8qHH/8PNZSE21QvAAA=");
}
