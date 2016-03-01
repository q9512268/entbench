package org.apache.batik.anim.values;
public class AnimatableStringValue extends org.apache.batik.anim.values.AnimatableValue {
    protected java.lang.String string;
    protected AnimatableStringValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableStringValue(org.apache.batik.dom.anim.AnimationTarget target,
                                 java.lang.String s) { super(
                                                         target);
                                                       string =
                                                         s;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableStringValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableStringValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableStringValue)
                result;
        }
        java.lang.String newString;
        if (to !=
              null &&
              interpolation >=
              0.5) {
            org.apache.batik.anim.values.AnimatableStringValue toValue =
              (org.apache.batik.anim.values.AnimatableStringValue)
                to;
            newString =
              toValue.
                string;
        }
        else {
            newString =
              string;
        }
        if (res.
              string ==
              null ||
              !res.
                 string.
              equals(
                newString)) {
            res.
              string =
              newString;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public java.lang.String getString() {
        return string;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableStringValue(
          target,
          "");
    }
    public java.lang.String getCssText() {
        return string;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gKtYtFvX7Zp2Gbe8rnOQ/ZUntf8AyeRQjlYdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dTaff/o1P/2mH37uz6uTov8Fz7YKKowoAAA=");
}
