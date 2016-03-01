package org.apache.batik.anim.values;
public class AnimatableNumberListValue extends org.apache.batik.anim.values.AnimatableValue {
    protected float[] numbers;
    protected AnimatableNumberListValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableNumberListValue(org.apache.batik.dom.anim.AnimationTarget target,
                                     float[] numbers) { super(
                                                          target);
                                                        this.
                                                          numbers =
                                                          numbers;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableNumberListValue toNumList =
          (org.apache.batik.anim.values.AnimatableNumberListValue)
            to;
        org.apache.batik.anim.values.AnimatableNumberListValue accNumList =
          (org.apache.batik.anim.values.AnimatableNumberListValue)
            accumulation;
        boolean hasTo =
          to !=
          null;
        boolean hasAcc =
          accumulation !=
          null;
        boolean canInterpolate =
          !(hasTo &&
              toNumList.
                numbers.
                length !=
              numbers.
                length) &&
          !(hasAcc &&
              accNumList.
                numbers.
                length !=
              numbers.
                length);
        float[] baseValues;
        if (!canInterpolate &&
              hasTo &&
              interpolation >=
              0.5) {
            baseValues =
              toNumList.
                numbers;
        }
        else {
            baseValues =
              numbers;
        }
        int len =
          baseValues.
            length;
        org.apache.batik.anim.values.AnimatableNumberListValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableNumberListValue(
                target);
            res.
              numbers =
              (new float[len]);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableNumberListValue)
                result;
            if (res.
                  numbers ==
                  null ||
                  res.
                    numbers.
                    length !=
                  len) {
                res.
                  numbers =
                  (new float[len]);
            }
        }
        for (int i =
               0;
             i <
               len;
             i++) {
            float newValue =
              baseValues[i];
            if (canInterpolate) {
                if (hasTo) {
                    newValue +=
                      interpolation *
                        (toNumList.
                           numbers[i] -
                           newValue);
                }
                if (hasAcc) {
                    newValue +=
                      multiplier *
                        accNumList.
                          numbers[i];
                }
            }
            if (res.
                  numbers[i] !=
                  newValue) {
                res.
                  numbers[i] =
                  newValue;
                res.
                  hasChanged =
                  true;
            }
        }
        return res;
    }
    public float[] getNumbers() { return numbers;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        float[] ns =
          new float[numbers.
                      length];
        return new org.apache.batik.anim.values.AnimatableNumberListValue(
          target,
          ns);
    }
    public java.lang.String getCssText() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            numbers[0]);
        for (int i =
               1;
             i <
               numbers.
                 length;
             i++) {
            sb.
              append(
                ' ');
            sb.
              append(
                numbers[i]);
        }
        return sb.
          toString(
            );
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
      ("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" +
       "k/+Tt/3j9/3Cy18tL1/+DwvcAEWwLAAA");
}
