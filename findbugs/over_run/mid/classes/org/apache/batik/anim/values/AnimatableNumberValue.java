package org.apache.batik.anim.values;
public class AnimatableNumberValue extends org.apache.batik.anim.values.AnimatableValue {
    protected float value;
    protected AnimatableNumberValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableNumberValue(org.apache.batik.dom.anim.AnimationTarget target,
                                 float v) { super(target);
                                            value = v; }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableNumberValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableNumberValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableNumberValue)
                result;
        }
        float v =
          value;
        if (to !=
              null) {
            org.apache.batik.anim.values.AnimatableNumberValue toNumber =
              (org.apache.batik.anim.values.AnimatableNumberValue)
                to;
            v +=
              interpolation *
                (toNumber.
                   value -
                   value);
        }
        if (accumulation !=
              null) {
            org.apache.batik.anim.values.AnimatableNumberValue accNumber =
              (org.apache.batik.anim.values.AnimatableNumberValue)
                accumulation;
            v +=
              multiplier *
                accNumber.
                  value;
        }
        if (res.
              value !=
              v) {
            res.
              value =
              v;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public float getValue() { return value;
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableNumberValue o =
          (org.apache.batik.anim.values.AnimatableNumberValue)
            other;
        return java.lang.Math.
          abs(
            value -
              o.
                value);
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableNumberValue(
          target,
          0);
    }
    public java.lang.String getCssText() {
        return formatNumber(
                 value);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cNWf7DQM90ZgPve8YXCQ/ZVvdP8BjIBpxlQdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fjO/+fRtn3z9bz/1jfyi5P8A+kSukYooAAA=");
}
