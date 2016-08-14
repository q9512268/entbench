package org.apache.batik.anim.values;
public class AnimatableNumberOrPercentageValue extends org.apache.batik.anim.values.AnimatableNumberValue {
    protected boolean isPercentage;
    protected AnimatableNumberOrPercentageValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableNumberOrPercentageValue(org.apache.batik.dom.anim.AnimationTarget target,
                                             float n) { super(
                                                          target,
                                                          n);
    }
    public AnimatableNumberOrPercentageValue(org.apache.batik.dom.anim.AnimationTarget target,
                                             float n,
                                             boolean isPercentage) {
        super(
          target,
          n);
        this.
          isPercentage =
          isPercentage;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableNumberOrPercentageValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableNumberOrPercentageValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableNumberOrPercentageValue)
                result;
        }
        float newValue;
        boolean newIsPercentage;
        org.apache.batik.anim.values.AnimatableNumberOrPercentageValue toValue =
          (org.apache.batik.anim.values.AnimatableNumberOrPercentageValue)
            to;
        org.apache.batik.anim.values.AnimatableNumberOrPercentageValue accValue =
          (org.apache.batik.anim.values.AnimatableNumberOrPercentageValue)
            accumulation;
        if (to !=
              null) {
            if (toValue.
                  isPercentage ==
                  isPercentage) {
                newValue =
                  value +
                    interpolation *
                    (toValue.
                       value -
                       value);
                newIsPercentage =
                  isPercentage;
            }
            else {
                if (interpolation >=
                      0.5) {
                    newValue =
                      toValue.
                        value;
                    newIsPercentage =
                      toValue.
                        isPercentage;
                }
                else {
                    newValue =
                      value;
                    newIsPercentage =
                      isPercentage;
                }
            }
        }
        else {
            newValue =
              value;
            newIsPercentage =
              isPercentage;
        }
        if (accumulation !=
              null &&
              accValue.
                isPercentage ==
              newIsPercentage) {
            newValue +=
              multiplier *
                accValue.
                  value;
        }
        if (res.
              value !=
              newValue ||
              res.
                isPercentage !=
              newIsPercentage) {
            res.
              value =
              newValue;
            res.
              isPercentage =
              newIsPercentage;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public boolean isPercentage() { return isPercentage;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableNumberOrPercentageValue(
          target,
          0,
          isPercentage);
    }
    public java.lang.String getCssText() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            formatNumber(
              value));
        if (isPercentage) {
            sb.
              append(
                '%');
        }
        return sb.
          toString(
            );
    }
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
       "9l9570+/+Ifl952/BeQd7dpVKgAA");
}
