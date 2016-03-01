package org.apache.batik.anim.values;
public class AnimatableRectValue extends org.apache.batik.anim.values.AnimatableValue {
    protected float x;
    protected float y;
    protected float width;
    protected float height;
    protected AnimatableRectValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableRectValue(org.apache.batik.dom.anim.AnimationTarget target,
                               float x,
                               float y,
                               float w,
                               float h) { super(target);
                                          this.x = x;
                                          this.y = y;
                                          this.width = w;
                                          this.height = h; }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableRectValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableRectValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableRectValue)
                result;
        }
        float newX =
          x;
        float newY =
          y;
        float newWidth =
          width;
        float newHeight =
          height;
        if (to !=
              null) {
            org.apache.batik.anim.values.AnimatableRectValue toValue =
              (org.apache.batik.anim.values.AnimatableRectValue)
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
            newWidth +=
              interpolation *
                (toValue.
                   width -
                   width);
            newHeight +=
              interpolation *
                (toValue.
                   height -
                   height);
        }
        if (accumulation !=
              null &&
              multiplier !=
              0) {
            org.apache.batik.anim.values.AnimatableRectValue accValue =
              (org.apache.batik.anim.values.AnimatableRectValue)
                accumulation;
            newX +=
              multiplier *
                accValue.
                  x;
            newY +=
              multiplier *
                accValue.
                  y;
            newWidth +=
              multiplier *
                accValue.
                  width;
            newHeight +=
              multiplier *
                accValue.
                  height;
        }
        if (res.
              x !=
              newX ||
              res.
                y !=
              newY ||
              res.
                width !=
              newWidth ||
              res.
                height !=
              newHeight) {
            res.
              x =
              newX;
            res.
              y =
              newY;
            res.
              width =
              newWidth;
            res.
              height =
              newHeight;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public float getX() { return x; }
    public float getY() { return y; }
    public float getWidth() { return width;
    }
    public float getHeight() { return height;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableRectValue(
          target,
          0.0F,
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
            x);
        sb.
          append(
            ',');
        sb.
          append(
            y);
        sb.
          append(
            ',');
        sb.
          append(
            width);
        sb.
          append(
            ',');
        sb.
          append(
            height);
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
       "f8L9wMbJLQAA");
}
