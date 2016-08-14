package org.apache.batik.anim.values;
public class AnimatableNumberOptionalNumberValue extends org.apache.batik.anim.values.AnimatableValue {
    protected float number;
    protected boolean hasOptionalNumber;
    protected float optionalNumber;
    protected AnimatableNumberOptionalNumberValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableNumberOptionalNumberValue(org.apache.batik.dom.anim.AnimationTarget target,
                                               float n) {
        super(
          target);
        number =
          n;
    }
    public AnimatableNumberOptionalNumberValue(org.apache.batik.dom.anim.AnimationTarget target,
                                               float n,
                                               float on) {
        super(
          target);
        number =
          n;
        optionalNumber =
          on;
        hasOptionalNumber =
          true;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue)
                result;
        }
        float newNumber;
        float newOptionalNumber;
        boolean newHasOptionalNumber;
        if (to !=
              null &&
              interpolation >=
              0.5) {
            org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue toValue =
              (org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue)
                to;
            newNumber =
              toValue.
                number;
            newOptionalNumber =
              toValue.
                optionalNumber;
            newHasOptionalNumber =
              toValue.
                hasOptionalNumber;
        }
        else {
            newNumber =
              number;
            newOptionalNumber =
              optionalNumber;
            newHasOptionalNumber =
              hasOptionalNumber;
        }
        if (res.
              number !=
              newNumber ||
              res.
                hasOptionalNumber !=
              newHasOptionalNumber ||
              res.
                optionalNumber !=
              newOptionalNumber) {
            res.
              number =
              number;
            res.
              optionalNumber =
              optionalNumber;
            res.
              hasOptionalNumber =
              hasOptionalNumber;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public float getNumber() { return number;
    }
    public boolean hasOptionalNumber() { return hasOptionalNumber;
    }
    public float getOptionalNumber() { return optionalNumber;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        if (hasOptionalNumber) {
            return new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
              target,
              0.0F,
              0.0F);
        }
        return new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
          target,
          0.0F);
    }
    public java.lang.String getCssText() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            formatNumber(
              number));
        if (hasOptionalNumber) {
            sb.
              append(
                ' ');
            sb.
              append(
                formatNumber(
                  optionalNumber));
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
       "EWuffOUf/93hp145OJN4PXtb7nO2zy75KtA/sAP3d+DvEnj+b/7koPKK3eL7" +
       "MHmUAbz7JAUIgtz877lIrGKIzv/40ku//gsvfWIH4+HzeUcbpNW/9J//9quH" +
       "n/3G795hEQNBypd3vk5c4OujvHihaELz4gM7a2FvyV/wI/PiF/hLXnzwds+4" +
       "W9c9CPfsFs7CM/KiUxQF/9kFaMW8mJ6iZd8M2h3t48WvKxe7YydP/09Xvcf/" +
       "D+MsXv5v//u2EFEs1nfw0L3+EvzFn3uC/OA3i/6nq2be++nN7XkO2Cqd9q38" +
       "ovuXB89c+e0D6KoE3VSO9mFFmgLWIgnsPeLjzRnYq51rP7+P2CXNL5xkBU/u" +
       "T5Ezw+6v16euCd5z6vz9+p2W6O8FzzNHPvDMvvtcgooX5S4RJ3/9/oJpFwQf" +
       "r8jHTpzj5qnV1e9m9Y+cl+n7wfO+I5nedxeZrDci00OGHJ9PFwt6smjeCdVP" +
       "oKsL33c02duT2n6TUj8LnuePpH7+LlInb0TqB/1zIt9Jo6vvKtsO4iWwKlyu" +
       "HGKHxaT92J1HL2b1h4AF42LXnocyE4x+LM5jlqPcOo6pAlAhkO2W5WDHicDN" +
       "YoXMXfZwt/Xdk7X7hmUFc/zBU2aUD3bRP/lnn/7qP3n262AiDqDLxYYAzL8z" +
       "I+5U9BNf/MxT73jlGz9ZZGtAncI/+tfYN3KuP3ER4rz40bz4+DHUJ3KobLE9" +
       "ouQ4oYvsSlNP0O45zr2O/xbQJje+0UPjPn78R/MSOVsryHKelvzMYrYqg5os" +
       "Q/Ll9QqdkIbkW+a8za7BzqVHDhC+RDW8ZTXyZtOKFFg1udIkObZr9k1yKHdD" +
       "RrGnHTaeGP2hSfbMUO+PAA95sO20/SlPzOzAIXhfD33W75aaMBxnUaentAWe" +
       "helmCW5iGAZj6RL29Emzb80qUy5cZOSomdBWykYwPZUTO67I6rTSREmlMh5G" +
       "wrzsNVfjVlBeDCJhUw62bjMkyMVCIiQhYq2AdkK3loVmSvfcfmxOdasTMdKI" +
       "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");
}
