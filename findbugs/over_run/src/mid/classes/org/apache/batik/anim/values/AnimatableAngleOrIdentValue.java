package org.apache.batik.anim.values;
public class AnimatableAngleOrIdentValue extends org.apache.batik.anim.values.AnimatableAngleValue {
    protected boolean isIdent;
    protected java.lang.String ident;
    protected AnimatableAngleOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableAngleOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                       float v,
                                       short unit) { super(
                                                       target,
                                                       v,
                                                       unit);
    }
    public AnimatableAngleOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                       java.lang.String ident) {
        super(
          target);
        this.
          ident =
          ident;
        this.
          isIdent =
          true;
    }
    public boolean isIdent() { return isIdent; }
    public java.lang.String getIdent() { return ident;
    }
    public boolean canPace() { return false; }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableAngleOrIdentValue(
          target,
          0,
          org.w3c.dom.svg.SVGAngle.
            SVG_ANGLETYPE_UNSPECIFIED);
    }
    public java.lang.String getCssText() {
        if (isIdent) {
            return ident;
        }
        return super.
          getCssText(
            );
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableAngleOrIdentValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableAngleOrIdentValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableAngleOrIdentValue)
                result;
        }
        if (to ==
              null) {
            if (isIdent) {
                res.
                  hasChanged =
                  !res.
                     isIdent ||
                    !res.
                       ident.
                    equals(
                      ident);
                res.
                  ident =
                  ident;
                res.
                  isIdent =
                  true;
            }
            else {
                short oldUnit =
                  res.
                    unit;
                float oldValue =
                  res.
                    value;
                super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
                if (res.
                      unit !=
                      oldUnit ||
                      res.
                        value !=
                      oldValue) {
                    res.
                      hasChanged =
                      true;
                }
            }
        }
        else {
            org.apache.batik.anim.values.AnimatableAngleOrIdentValue toValue =
              (org.apache.batik.anim.values.AnimatableAngleOrIdentValue)
                to;
            if (isIdent ||
                  toValue.
                    isIdent) {
                if (interpolation >=
                      0.5) {
                    if (res.
                          isIdent !=
                          toValue.
                            isIdent ||
                          res.
                            unit !=
                          toValue.
                            unit ||
                          res.
                            value !=
                          toValue.
                            value ||
                          res.
                            isIdent &&
                          toValue.
                            isIdent &&
                          !toValue.
                             ident.
                          equals(
                            ident)) {
                        res.
                          isIdent =
                          toValue.
                            isIdent;
                        res.
                          ident =
                          toValue.
                            ident;
                        res.
                          unit =
                          toValue.
                            unit;
                        res.
                          value =
                          toValue.
                            value;
                        res.
                          hasChanged =
                          true;
                    }
                }
                else {
                    if (res.
                          isIdent !=
                          isIdent ||
                          res.
                            unit !=
                          unit ||
                          res.
                            value !=
                          value ||
                          res.
                            isIdent &&
                          isIdent &&
                          !res.
                             ident.
                          equals(
                            ident)) {
                        res.
                          isIdent =
                          isIdent;
                        res.
                          ident =
                          ident;
                        res.
                          unit =
                          unit;
                        res.
                          value =
                          value;
                        res.
                          hasChanged =
                          true;
                    }
                }
            }
            else {
                super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
            }
        }
        return res;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "u/wPE42Ah2ggAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PR6r/pTaLhxzLE6oXncmTPoDPByNzYHd6eLLRS8LdWvEjqYZ01o5RM+UphpC" +
       "+DXgt2SsJS7MIJVTedUV+rNcmytUH1Ps9UhpG6ORsNohiGRslLVls1YvUGKn" +
       "MU52bG3IAaPsKQ47DxR8tiZIKq0GFTmTw9Z26I7mxJCoZE1gB2IdY7fcUBus" +
       "uxYxH9dGXbhn9dFlEHNGL45yRYt2O9MYKkmSpIxnyRQ8UtCe646sHbKpeVjA" +
       "8hSVcOus7Q2TltYTFNFhTFNfMFQ2ltBYReCJO0ybauSr6kToNoiptZ5bA7Pl" +
       "OkibGLY4ZjFv8m26PW8vGrI3NLmux/h8v+dz8ay+ihv1WKya8ETE8kDDW13e" +
       "GBIkv9lMmXq7MW/G6IaaIfrcw8m2gPIDh/UiYWQliplygyzvbviKMehm9WbV" +
       "x7xsCpvqzl1rStzhlaFjGcveaNyGRb413KGYpnKbvJNWBlvSqUdTZmX3mOrG" +
       "xVcWWF8yLiO9tBUEPU/sEERqNoaSETZGVjiP52S2WqFTjKPYcaWi1bid1pmx" +
       "+obSEz6aEeyuEjUzv7bLa/lCUJZdVlBxDanpEudUXCyKUxRp0cGICScprKDr" +
       "hdqemjA+MYcjRJR9j7HrpOwMzEVmjdCqmwojVxoIFYd08JplezV7tcoS2sfp" +
       "cCkz2KA/dtMJudWsKjJsLZFlIySqtb45QvXlor6uYJhRG07NdTufzeVaddgM" +
       "Ncc1JpTSn7rmpo0b/lQS9Gzn+Qu23a4sWGQz4E2dIdX+2OxjMdG3p/Ri1Gtx" +
       "ChvJLoZiI2OX7LDFRCUVgWS9KjseUDY1rfVYkhnGTNvbcTAr96tWDanNhlOa" +
       "woXephuY84WrgLWaUbwsTyZ8f7fNWqY+XFicThFmTE9XBs0J2966WVttuISe" +
       "YA5CNWaKoCIhzHDD6WAnyKvc0FpqjyHGUnsWemorR2tri69iXF7niRkhrdvV" +
       "Pr2b4ePpyhJ3yhCt7mIjRJEm1a/kLs5NmG0lr6AwhqhyvbclR7XBMM3rqKrQ" +
       "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");
}
