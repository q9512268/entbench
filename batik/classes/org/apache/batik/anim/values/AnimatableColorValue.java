package org.apache.batik.anim.values;
public class AnimatableColorValue extends org.apache.batik.anim.values.AnimatableValue {
    protected float red;
    protected float green;
    protected float blue;
    protected AnimatableColorValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableColorValue(org.apache.batik.dom.anim.AnimationTarget target,
                                float r,
                                float g,
                                float b) { super(target);
                                           red = r;
                                           green = g;
                                           blue = b; }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableColorValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableColorValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableColorValue)
                result;
        }
        float oldRed =
          res.
            red;
        float oldGreen =
          res.
            green;
        float oldBlue =
          res.
            blue;
        res.
          red =
          red;
        res.
          green =
          green;
        res.
          blue =
          blue;
        org.apache.batik.anim.values.AnimatableColorValue toColor =
          (org.apache.batik.anim.values.AnimatableColorValue)
            to;
        org.apache.batik.anim.values.AnimatableColorValue accColor =
          (org.apache.batik.anim.values.AnimatableColorValue)
            accumulation;
        if (to !=
              null) {
            res.
              red +=
              interpolation *
                (toColor.
                   red -
                   res.
                     red);
            res.
              green +=
              interpolation *
                (toColor.
                   green -
                   res.
                     green);
            res.
              blue +=
              interpolation *
                (toColor.
                   blue -
                   res.
                     blue);
        }
        if (accumulation !=
              null) {
            res.
              red +=
              multiplier *
                accColor.
                  red;
            res.
              green +=
              multiplier *
                accColor.
                  green;
            res.
              blue +=
              multiplier *
                accColor.
                  blue;
        }
        if (res.
              red !=
              oldRed ||
              res.
                green !=
              oldGreen ||
              res.
                blue !=
              oldBlue) {
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableColorValue o =
          (org.apache.batik.anim.values.AnimatableColorValue)
            other;
        float dr =
          red -
          o.
            red;
        float dg =
          green -
          o.
            green;
        float db =
          blue -
          o.
            blue;
        return (float)
                 java.lang.Math.
                 sqrt(
                   dr *
                     dr +
                     dg *
                     dg +
                     db *
                     db);
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableColorValue(
          target,
          0.0F,
          0.0F,
          0.0F);
    }
    public java.lang.String getCssText() {
        return "rgb(" +
        java.lang.Math.
          round(
            red *
              255) +
        ',' +
        java.lang.Math.
          round(
            green *
              255) +
        ',' +
        java.lang.Math.
          round(
            blue *
              255) +
        ')';
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Pr3i+A/xisO7/wHPM8Bvlx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "wycpAAA=");
}
