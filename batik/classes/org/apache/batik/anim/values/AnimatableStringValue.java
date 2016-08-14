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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5Nnh3stghwk4Ng2ebY4y28Zuh1KsZXQ9WmbsW9h8g5Nqheq97pVfGfBVJw1D" +
       "Y1QvDkDPfN+8DOZrcWHEHBuwsZuvFGvIRD6tZGH0vTI2fBqb73BSl1Jl3Nok" +
       "bsR81njyMlhDhDssYzVHJW3s1ijFWkbZ58qMPY/Ns5w0wKHqZ5bhi3d5U/z4" +
       "cvkXzFNtRx977KYoxVpG3V+UGTuLzWnABJiiC9JKiJQhB3PmEymWOJlU9HoQ" +
       "S9SpBX9MyMt05fEjTTVTjmx+TSSa+QvvBsgd0llN81cGvvcq02JpVSjXIOsE" +
       "Ga/egMKjXP4DWb58ETq8LpnehHUXZeJkHH75ad+B0jRMCxFbfPvp3gVre3Qw" +
       "rXzxk/weoieQ4Ot7pjzckWBZkN+eSZfaHl8lMTeQEIl/jdycISv/NxpQTh5Z" +
       "u/62C9cdk1dlikb37EEp9ZApyFu7fCI9p6Q0V1bVmgUXxz9RO89NYFrkgj2Q" +
       "T/chsQv8mIlwmBa6RLI78ndJrx9d/uzPDlSdhdRrK4lQTiZsLawzc2YWKpit" +
       "icKMCIoOcbvVueDroysWpf/8G3HpQQrq9zD9gPLq8W2vHJx6tC1K6ntIJeRm" +
       "LCcK4JtG9Y1MGbb6SaNqd+dgiSBFpVog3RqPyKUIeWEXx5yN+V68aOWkvTCF" +
       "LLyertOMEWatMrJ6CsVAwlbv9bgFVaAWyZpmiMHr8aXZX5DhE3cDsDeQWGea" +
       "boZNjpkCg3cVj6XYfiResfn7fwB8cOHyUR4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iW9kp0z/B7QpV7isKAAA");
}
