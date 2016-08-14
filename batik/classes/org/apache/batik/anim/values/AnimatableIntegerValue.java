package org.apache.batik.anim.values;
public class AnimatableIntegerValue extends org.apache.batik.anim.values.AnimatableValue {
    protected int value;
    protected AnimatableIntegerValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableIntegerValue(org.apache.batik.dom.anim.AnimationTarget target,
                                  int v) { super(target);
                                           value = v; }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableIntegerValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableIntegerValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableIntegerValue)
                result;
        }
        int v =
          value;
        if (to !=
              null) {
            org.apache.batik.anim.values.AnimatableIntegerValue toInteger =
              (org.apache.batik.anim.values.AnimatableIntegerValue)
                to;
            v +=
              value +
                interpolation *
                (toInteger.
                   getValue(
                     ) -
                   value);
        }
        if (accumulation !=
              null) {
            org.apache.batik.anim.values.AnimatableIntegerValue accInteger =
              (org.apache.batik.anim.values.AnimatableIntegerValue)
                accumulation;
            v +=
              multiplier *
                accInteger.
                getValue(
                  );
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
    public int getValue() { return value;
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableIntegerValue o =
          (org.apache.batik.anim.values.AnimatableIntegerValue)
            other;
        return java.lang.Math.
          abs(
            value -
              o.
                value);
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableIntegerValue(
          target,
          0);
    }
    public java.lang.String getCssText() {
        return java.lang.Integer.
          toString(
            value);
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
      ("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");
}
