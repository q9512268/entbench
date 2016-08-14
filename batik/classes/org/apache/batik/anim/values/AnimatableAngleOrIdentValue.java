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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "W/YfSFJ0M4chAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0/J8TP4rb/7FZ/79C18qv3/9Py8AltMGLAAA");
}
