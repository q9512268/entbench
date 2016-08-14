package org.apache.batik.anim.values;
public class AnimatableBooleanValue extends org.apache.batik.anim.values.AnimatableValue {
    protected boolean value;
    protected AnimatableBooleanValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableBooleanValue(org.apache.batik.dom.anim.AnimationTarget target,
                                  boolean b) { super(target);
                                               value = b;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableBooleanValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableBooleanValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableBooleanValue)
                result;
        }
        boolean newValue;
        if (to !=
              null &&
              interpolation >=
              0.5) {
            org.apache.batik.anim.values.AnimatableBooleanValue toValue =
              (org.apache.batik.anim.values.AnimatableBooleanValue)
                to;
            newValue =
              toValue.
                value;
        }
        else {
            newValue =
              value;
        }
        if (res.
              value !=
              newValue) {
            res.
              value =
              newValue;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public boolean getValue() { return value;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableBooleanValue(
          target,
          false);
    }
    public java.lang.String getCssText() {
        return value
          ? "true"
          : "false";
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
       "f5EmTG2uKAAA");
}
