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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dDoHRupwmpCjlOUA+e3ahuvqqas1wna/5rVGKKdMawQx3lk5obiolG8RYWT2" +
       "4HnHyObDVBkowgxEc53xYhBhbKpo/QSTLHPnYQI+yDq0xjbsBrNI6qlow5V5" +
       "je+itRm1zruLaIfC3SaRLzKPWToM0h6y9FjSx81AoMgxi1C4uuhMLdbSNTMy" +
       "mpUB0aCE5SBagJXPhtdzRxgkZLXSk+W6vdgyvk1Yk5rQSZ25UqO1gdjywo1W" +
       "Ed0IOOmJNCZkiaATp7uIVXTXZYmkrgk45je3TX9Tm6dmZs1YLo5XM6xV9dZA" +
       "GVmBnzVru4mhV9x+radnvkunWrwz2hHKSxXe92yhslipoThchFhrxflMg4md" +
       "xlAk100WHdQ3rfEEOGZy7e7yWVVag1WWUt/J60krnNR32sp1MUoUlnw99lt1" +
       "KaS34xUfRNVRdafmFaIzo9UlO6NmRmTieq/Pk1HX3tIEUrW2XG+D5u16C09n" +
       "rt5exKZZqSdIHURBnLaionQVrr0e7XPJoFfLFqM2o8wiWPbsUWudzlp4jUOj" +
       "9nomwmOqsTOWhBHCtgZPRDcNkfoy0Js6YyjoKORixuRGgmRSHDFPFSyyyXSx" +
       "8BqLaBlY9WobVkZNDiaoBRFpwA20FA6FWyt8JvrdRs4swUom2uizXa2GdtRK" +
       "hZsMO/xOr1puL7HIFUa0DL9DydvVohJsN6FCrCnb7FV6AtxpTXamhdSJ3dKp" +
       "w30Q1ZBxg5aWelrhl3mtlmUhLurwrk9SnirNxso2llBYblBoCpYaril6SXVs" +
       "ibuBpQ3Hrr9V/NbO8xmLi/X5sl9BaD2chLBRM0ScRoPdBLXBfCi5FS5EasDz" +
       "TQgPeKruaDNaDrNdiIZSqlV6I3XEbF0ZzcYmatvd1qw+onRvBNv+Eh8oKPh3" +
       "HaHFcmPYCGADaZptxuCGHN+fgsX9iy8Wy/5Pv73tiIfKnZejE33TahUFH38b" +
       "Ow77omeK5CNHu1Tl33no1CnwiV2qE9u6ULFx/eTtDurLTesvfvLV1zf0z9bO" +
       "HmwpkxF0MXK9v2spO8U6QeoioPSh2+8QT8t7CsfbtL/7yf/2xPwj+sfexoHn" +
       "06f4PE3yX02/9PujD8g/cRa652jT9qYbFDc2euHGrdpLgRLFgTO/YcP2yaOR" +
       "Lbb+oA+AhzwYWfL0/t+x7G69+ffRvexvfS5yuOP2/Fs8ny73rIs2XzjaQ/zC" +
       "rfax7jGc/SHZv7jDScHPF8nnIuj+8i4KGDQpUo4plpr4+bdzeFBm/PTR0JWK" +
       "+Sh4woOhC+/O0J2E8Et3KPvlIvlyBN2rKdGyHK5jXF+5G7jyA1z53cf1W3co" +
       "e6NIfn2Pa3UK12+8U1w/CJ5PHOD6xN3H9e/vUPa1IvntCLoP4Focbd0fY/ud" +
       "d4qtOFl4+QDby3cf2x/foexPiuTrwI0CbPjxGcAxuD98B+AeOQT3ygG4V+4+" +
       "uD+7Q9mfF8mfRtAFWXKYwxttpxzShbXrWorkHCP+xjsVZ+GaXztA/NrdQXzm" +
       "uMIXygpv3gH2fy+Sb0fQpY2xn1nm7imhfucdQCwnnuI47mcOIP7M3Rfq396h" +
       "7HtF8jcR9ADQWFEJ3OOZ5xjf/3oH+B4uMosw5ecO8P3cXcd35uIdyu4vknvB" +
       "5Be5+zMuVin7/fgRvDPn3tbJeQQ9cot7ZMWNmMdvuru6v28pf+X1y/e9+3X+" +
       "P5ZXqY7uRF6cQPepsWWdPE8+8X7eCxTVKLFf3J8ueyWghyPovXeKIiLo/P6l" +
       "YP3MQ/tGIPR49JaNwPRS/Jys+3gEXTldN4LOlb8n670HmMRxPdDt/uVkladA" +
       "hAKqFK9Pe3trO3NjiHqkYw9/PyGciGrff0MsWl4sPowb4/3V4uvyV18nqY+/" +
       "2fzZ/TUw2ZLyvKBy3wS6sL+RdhR7PnNbaoe0zuPPfffBX7z4Q4dx8oN7ho8V" +
       "9wRvT9/6wtXQ9qLyilT+a+/+5Q//y9e/UR54/j8qbaDs8S0AAA==");
}
