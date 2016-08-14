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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "YxgSd7q67Jy+GSqxVlH1O1XGTmBzDycNCtWHvMu9KthryBiGxqheHn+++Y6f" +
       "KxThls65NshN33yVWCMmCmi1X0h9tIoNv4/NSU6asqoMUtuNCJgeOQfWELEN" +
       "D6y6q5I+fWtUYq2i7FNVxp7G5nFOWmBPpZll+MHNN8UT58AUnTi2CB7H1ceZ" +
       "vikqsVZR98UqY7/A5jnABJiiD0oDSK9eamgXZ0QswhLy3ts3zs8+kxqYk9ll" +
       "LwfxgDqv5G8JeZWuPHy8rXHu8eteFZVG8bq7BWqGnKNpwYIv8F5vWiynCoVb" +
       "ZPlniq/XoZ6slgDhrCpfhA6vSaY3YN1lmTipxa8g7dtgxigtVITiO0j3DnjA" +
       "p4Np5UuQ5PeQUIEEX9815YaPhcu9ontmf5p7AhXi8lBlJf4z8qogR/5rNKqc" +
       "PL558MYza+6VF2WKRvfuRSnNcOSSd3bFSmpZRWmerPpNK8/OfGTG+V7N2SEX" +
       "7AN/YQCdfRDbTITDgsgVkt1TvEl67cQVT/78QP3LcErZQWKUk1k7So8PBdOB" +
       "EnZHqvRoCVWnuNvqXfntPVetzv35N+LKg5Qcy6L0o8rp+65/5a55J7ripHmA" +
       "1EE5zQriXHPNHn0bUyatNGlV7f4CLBGkqFQLnVtnInIp7iphF9ecrcVevGbl" +
       "pLv00F56Od2kGVPMWm84ehbFwMm32e/xKupQMeqYZoTB7wlcbKRlSkVvAPZG" +
       "U1tM07vTIHlTYHBH+fyK7cfiFZu//wd8ohegTx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5S8/8ZXiouX/ALbRbhmuKAAA");
}
