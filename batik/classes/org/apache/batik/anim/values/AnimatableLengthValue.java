package org.apache.batik.anim.values;
public class AnimatableLengthValue extends org.apache.batik.anim.values.AnimatableValue {
    protected static final java.lang.String[] UNITS = { "", "%", "em", "ex",
    "px",
    "cm",
    "mm",
    "in",
    "pt",
    "pc" };
    protected short lengthType;
    protected float lengthValue;
    protected short percentageInterpretation;
    protected AnimatableLengthValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableLengthValue(org.apache.batik.dom.anim.AnimationTarget target,
                                 short type,
                                 float v,
                                 short pcInterp) { super(
                                                     target);
                                                   lengthType =
                                                     type;
                                                   lengthValue =
                                                     v;
                                                   percentageInterpretation =
                                                     pcInterp;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableLengthValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableLengthValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableLengthValue)
                result;
        }
        short oldLengthType =
          res.
            lengthType;
        float oldLengthValue =
          res.
            lengthValue;
        short oldPercentageInterpretation =
          res.
            percentageInterpretation;
        res.
          lengthType =
          lengthType;
        res.
          lengthValue =
          lengthValue;
        res.
          percentageInterpretation =
          percentageInterpretation;
        if (to !=
              null) {
            org.apache.batik.anim.values.AnimatableLengthValue toLength =
              (org.apache.batik.anim.values.AnimatableLengthValue)
                to;
            float toValue;
            if (!compatibleTypes(
                   res.
                     lengthType,
                   res.
                     percentageInterpretation,
                   toLength.
                     lengthType,
                   toLength.
                     percentageInterpretation)) {
                res.
                  lengthValue =
                  target.
                    svgToUserSpace(
                      res.
                        lengthValue,
                      res.
                        lengthType,
                      res.
                        percentageInterpretation);
                res.
                  lengthType =
                  org.w3c.dom.svg.SVGLength.
                    SVG_LENGTHTYPE_NUMBER;
                toValue =
                  toLength.
                    target.
                    svgToUserSpace(
                      toLength.
                        lengthValue,
                      toLength.
                        lengthType,
                      toLength.
                        percentageInterpretation);
            }
            else {
                toValue =
                  toLength.
                    lengthValue;
            }
            res.
              lengthValue +=
              interpolation *
                (toValue -
                   res.
                     lengthValue);
        }
        if (accumulation !=
              null) {
            org.apache.batik.anim.values.AnimatableLengthValue accLength =
              (org.apache.batik.anim.values.AnimatableLengthValue)
                accumulation;
            float accValue;
            if (!compatibleTypes(
                   res.
                     lengthType,
                   res.
                     percentageInterpretation,
                   accLength.
                     lengthType,
                   accLength.
                     percentageInterpretation)) {
                res.
                  lengthValue =
                  target.
                    svgToUserSpace(
                      res.
                        lengthValue,
                      res.
                        lengthType,
                      res.
                        percentageInterpretation);
                res.
                  lengthType =
                  org.w3c.dom.svg.SVGLength.
                    SVG_LENGTHTYPE_NUMBER;
                accValue =
                  accLength.
                    target.
                    svgToUserSpace(
                      accLength.
                        lengthValue,
                      accLength.
                        lengthType,
                      accLength.
                        percentageInterpretation);
            }
            else {
                accValue =
                  accLength.
                    lengthValue;
            }
            res.
              lengthValue +=
              multiplier *
                accValue;
        }
        if (oldPercentageInterpretation !=
              res.
                percentageInterpretation ||
              oldLengthType !=
              res.
                lengthType ||
              oldLengthValue !=
              res.
                lengthValue) {
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public static boolean compatibleTypes(short t1,
                                          short pi1,
                                          short t2,
                                          short pi2) {
        return t1 ==
          t2 &&
          (t1 !=
             org.w3c.dom.svg.SVGLength.
               SVG_LENGTHTYPE_PERCENTAGE ||
             pi1 ==
             pi2) ||
          t1 ==
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_NUMBER &&
          t2 ==
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_PX ||
          t1 ==
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_PX &&
          t2 ==
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_NUMBER;
    }
    public int getLengthType() { return lengthType;
    }
    public float getLengthValue() { return lengthValue;
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableLengthValue o =
          (org.apache.batik.anim.values.AnimatableLengthValue)
            other;
        float v1 =
          target.
          svgToUserSpace(
            lengthValue,
            lengthType,
            percentageInterpretation);
        float v2 =
          target.
          svgToUserSpace(
            o.
              lengthValue,
            o.
              lengthType,
            o.
              percentageInterpretation);
        return java.lang.Math.
          abs(
            v1 -
              v2);
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableLengthValue(
          target,
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_NUMBER,
          0.0F,
          percentageInterpretation);
    }
    public java.lang.String getCssText() {
        return formatNumber(
                 lengthValue) +
        UNITS[lengthType -
                1];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PoPb4HDx8hONlH9uGca3y/8DByCH7U0kAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Rt93suKPQuiBAwIPT/wPKfzvb4HCh6E9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("1f7qHoVfffsp/NMz+v48K74HFFPk7REv5qR965C019+q8DLv9rU90r729pC2" +
       "cwjw9QxgZ+fu9O3kMeUvQuiqpG+v4BjnhPT+8i2QmPvuHwbfq3skvvq2S2/n" +
       "/jP6rmXF5RC6D+gnJ/vOofM+oG/nylug76GsMXMwv7NH3++8/fT90Bl9786K" +
       "dwDpAfpwEGvlJL9XVg+pe+RNPQUJoUdOfSqZPfp69I5H2tuHxeKXX7p2+V0v" +
       "zf7z9nnA/uPfKxR0WYlM8+gTiSP1i64vK3pO/JXtgwk3p+iZEHr8rEgcQhe3" +
       "lQz5nae3g94D8D51UAidz/4dhX1fCF0/CRtCF/L/R+EKgKuHcGDZbeUoyG4I" +
       "3QNAsirsbs1t53hOdGBED/0gMRxJo549dmufv6Dfv2GPtm/ob4tfeak3+MTr" +
       "9S9uXzqKJp+m2SyXKejS9tFlPml2S//0XWfbn+ti97nvP/ArV96zn5g9sEX4" +
       "UHOP4PbU6W8K25Yb5q8A03/1rq9+8J+89If57eH/AwqZjN/aMAAA");
}
