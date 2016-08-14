package org.apache.batik.anim.values;
public class AnimatableMotionPointValue extends org.apache.batik.anim.values.AnimatableValue {
    protected float x;
    protected float y;
    protected float angle;
    protected AnimatableMotionPointValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableMotionPointValue(org.apache.batik.dom.anim.AnimationTarget target,
                                      float x,
                                      float y,
                                      float angle) { super(
                                                       target);
                                                     this.
                                                       x =
                                                       x;
                                                     this.
                                                       y =
                                                       y;
                                                     this.
                                                       angle =
                                                       angle;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableMotionPointValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableMotionPointValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableMotionPointValue)
                result;
        }
        float newX =
          x;
        float newY =
          y;
        float newAngle =
          angle;
        int angleCount =
          1;
        if (to !=
              null) {
            org.apache.batik.anim.values.AnimatableMotionPointValue toValue =
              (org.apache.batik.anim.values.AnimatableMotionPointValue)
                to;
            newX +=
              interpolation *
                (toValue.
                   x -
                   x);
            newY +=
              interpolation *
                (toValue.
                   y -
                   y);
            newAngle +=
              toValue.
                angle;
            angleCount++;
        }
        if (accumulation !=
              null &&
              multiplier !=
              0) {
            org.apache.batik.anim.values.AnimatableMotionPointValue accValue =
              (org.apache.batik.anim.values.AnimatableMotionPointValue)
                accumulation;
            newX +=
              multiplier *
                accValue.
                  x;
            newY +=
              multiplier *
                accValue.
                  y;
            newAngle +=
              accValue.
                angle;
            angleCount++;
        }
        newAngle /=
          angleCount;
        if (res.
              x !=
              newX ||
              res.
                y !=
              newY ||
              res.
                angle !=
              newAngle) {
            res.
              x =
              newX;
            res.
              y =
              newY;
            res.
              angle =
              newAngle;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public float getX() { return x; }
    public float getY() { return y; }
    public float getAngle() { return angle;
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableMotionPointValue o =
          (org.apache.batik.anim.values.AnimatableMotionPointValue)
            other;
        float dx =
          x -
          o.
            x;
        float dy =
          y -
          o.
            y;
        return (float)
                 java.lang.Math.
                 sqrt(
                   dx *
                     dx +
                     dy *
                     dy);
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableMotionPointValue(
          target,
          0.0F,
          0.0F,
          0.0F);
    }
    public java.lang.String toStringRep() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            formatNumber(
              x));
        sb.
          append(
            ',');
        sb.
          append(
            formatNumber(
              y));
        sb.
          append(
            ',');
        sb.
          append(
            formatNumber(
              angle));
        sb.
          append(
            "rad");
        return sb.
          toString(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "20KSMoUNbi2fZdFIF4tXfFvyX6swESG4IQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/+Qd//hDP/vK18pXef8PECeA4kcsAAA=");
}
