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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
