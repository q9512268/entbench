package org.apache.batik.anim.values;
public class AnimatableLengthOrIdentValue extends org.apache.batik.anim.values.AnimatableLengthValue {
    protected boolean isIdent;
    protected java.lang.String ident;
    protected AnimatableLengthOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableLengthOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        short type,
                                        float v,
                                        short pcInterp) {
        super(
          target,
          type,
          v,
          pcInterp);
    }
    public AnimatableLengthOrIdentValue(org.apache.batik.dom.anim.AnimationTarget target,
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
        return new org.apache.batik.anim.values.AnimatableLengthOrIdentValue(
          target,
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_NUMBER,
          0.0F,
          percentageInterpretation);
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
        org.apache.batik.anim.values.AnimatableLengthOrIdentValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableLengthOrIdentValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableLengthOrIdentValue)
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
                short oldLengthType =
                  res.
                    lengthType;
                float oldLengthValue =
                  res.
                    lengthValue;
                short oldPercentageInterpretation =
                  res.
                    percentageInterpretation;
                super.
                  interpolate(
                    res,
                    to,
                    interpolation,
                    accumulation,
                    multiplier);
                if (res.
                      lengthType !=
                      oldLengthType ||
                      res.
                        lengthValue !=
                      oldLengthValue ||
                      res.
                        percentageInterpretation !=
                      oldPercentageInterpretation) {
                    res.
                      hasChanged =
                      true;
                }
            }
        }
        else {
            org.apache.batik.anim.values.AnimatableLengthOrIdentValue toValue =
              (org.apache.batik.anim.values.AnimatableLengthOrIdentValue)
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
                            lengthType !=
                          toValue.
                            lengthType ||
                          res.
                            lengthValue !=
                          toValue.
                            lengthValue ||
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
                          lengthType =
                          toValue.
                            lengthType;
                        res.
                          lengthValue =
                          toValue.
                            lengthValue;
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
                            lengthType !=
                          lengthType ||
                          res.
                            lengthValue !=
                          lengthValue ||
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
                          ident =
                          ident;
                        res.
                          lengthType =
                          lengthType;
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
       "I6eJ/PI/xk+fGnIgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
