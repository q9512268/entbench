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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "N7NPcv8HTXm0BCssAAA=");
}
