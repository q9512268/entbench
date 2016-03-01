package org.apache.batik.anim;
public class SimpleAnimation extends org.apache.batik.anim.InterpolatingAnimation {
    protected org.apache.batik.anim.values.AnimatableValue[] values;
    protected org.apache.batik.anim.values.AnimatableValue from;
    protected org.apache.batik.anim.values.AnimatableValue to;
    protected org.apache.batik.anim.values.AnimatableValue by;
    public SimpleAnimation(org.apache.batik.anim.timing.TimedElement timedElement,
                           org.apache.batik.dom.anim.AnimatableElement animatableElement,
                           int calcMode,
                           float[] keyTimes,
                           float[] keySplines,
                           boolean additive,
                           boolean cumulative,
                           org.apache.batik.anim.values.AnimatableValue[] values,
                           org.apache.batik.anim.values.AnimatableValue from,
                           org.apache.batik.anim.values.AnimatableValue to,
                           org.apache.batik.anim.values.AnimatableValue by) {
        super(
          timedElement,
          animatableElement,
          calcMode,
          keyTimes,
          keySplines,
          additive,
          cumulative);
        this.
          from =
          from;
        this.
          to =
          to;
        this.
          by =
          by;
        if (values ==
              null) {
            if (from !=
                  null) {
                values =
                  (new org.apache.batik.anim.values.AnimatableValue[2]);
                values[0] =
                  from;
                if (to !=
                      null) {
                    values[1] =
                      to;
                }
                else
                    if (by !=
                          null) {
                        values[1] =
                          from.
                            interpolate(
                              null,
                              null,
                              0.0F,
                              by,
                              1);
                    }
                    else {
                        throw timedElement.
                          createException(
                            "values.to.by.missing",
                            new java.lang.Object[] { null });
                    }
            }
            else {
                if (to !=
                      null) {
                    values =
                      (new org.apache.batik.anim.values.AnimatableValue[2]);
                    values[0] =
                      animatableElement.
                        getUnderlyingValue(
                          );
                    values[1] =
                      to;
                    this.
                      cumulative =
                      false;
                    toAnimation =
                      true;
                }
                else
                    if (by !=
                          null) {
                        this.
                          additive =
                          true;
                        values =
                          (new org.apache.batik.anim.values.AnimatableValue[2]);
                        values[0] =
                          by.
                            getZeroValue(
                              );
                        values[1] =
                          by;
                    }
                    else {
                        throw timedElement.
                          createException(
                            "values.to.by.missing",
                            new java.lang.Object[] { null });
                    }
            }
        }
        this.
          values =
          values;
        if (this.
              keyTimes !=
              null &&
              calcMode !=
              CALC_MODE_PACED) {
            if (this.
                  keyTimes.
                  length !=
                  values.
                    length) {
                throw timedElement.
                  createException(
                    "attribute.malformed",
                    new java.lang.Object[] { null,
                    org.apache.batik.util.SMILConstants.
                      SMIL_KEY_TIMES_ATTRIBUTE });
            }
        }
        else {
            if (calcMode ==
                  CALC_MODE_LINEAR ||
                  calcMode ==
                  CALC_MODE_SPLINE ||
                  calcMode ==
                  CALC_MODE_PACED &&
                  !values[0].
                  canPace(
                    )) {
                int count =
                  values.
                    length ==
                  1
                  ? 2
                  : values.
                      length;
                this.
                  keyTimes =
                  (new float[count]);
                for (int i =
                       0;
                     i <
                       count;
                     i++) {
                    this.
                      keyTimes[i] =
                      (float)
                        i /
                        (count -
                           1);
                }
            }
            else
                if (calcMode ==
                      CALC_MODE_DISCRETE) {
                    int count =
                      values.
                        length;
                    this.
                      keyTimes =
                      (new float[count]);
                    for (int i =
                           0;
                         i <
                           count;
                         i++) {
                        this.
                          keyTimes[i] =
                          (float)
                            i /
                            count;
                    }
                }
                else {
                    int count =
                      values.
                        length;
                    float[] cumulativeDistances =
                      new float[count];
                    cumulativeDistances[0] =
                      0;
                    for (int i =
                           1;
                         i <
                           count;
                         i++) {
                        cumulativeDistances[i] =
                          cumulativeDistances[i -
                                                1] +
                            values[i -
                                     1].
                            distanceTo(
                              values[i]);
                    }
                    float totalLength =
                      cumulativeDistances[count -
                                            1];
                    this.
                      keyTimes =
                      (new float[count]);
                    this.
                      keyTimes[0] =
                      0;
                    for (int i =
                           1;
                         i <
                           count -
                           1;
                         i++) {
                        this.
                          keyTimes[i] =
                          cumulativeDistances[i] /
                            totalLength;
                    }
                    this.
                      keyTimes[count -
                                 1] =
                      1;
                }
        }
        if (calcMode ==
              CALC_MODE_SPLINE &&
              keySplines.
                length !=
              (this.
                 keyTimes.
                 length -
                 1) *
              4) {
            throw timedElement.
              createException(
                "attribute.malformed",
                new java.lang.Object[] { null,
                org.apache.batik.util.SMILConstants.
                  SMIL_KEY_SPLINES_ATTRIBUTE });
        }
    }
    protected void sampledAtUnitTime(float unitTime,
                                     int repeatIteration) {
        org.apache.batik.anim.values.AnimatableValue value;
        org.apache.batik.anim.values.AnimatableValue accumulation;
        org.apache.batik.anim.values.AnimatableValue nextValue;
        float interpolation =
          0;
        if (unitTime !=
              1) {
            int keyTimeIndex =
              0;
            while (keyTimeIndex <
                     keyTimes.
                       length -
                     1 &&
                     unitTime >=
                     keyTimes[keyTimeIndex +
                                1]) {
                keyTimeIndex++;
            }
            value =
              values[keyTimeIndex];
            if (calcMode ==
                  CALC_MODE_LINEAR ||
                  calcMode ==
                  CALC_MODE_PACED ||
                  calcMode ==
                  CALC_MODE_SPLINE) {
                nextValue =
                  values[keyTimeIndex +
                           1];
                interpolation =
                  (unitTime -
                     keyTimes[keyTimeIndex]) /
                    (keyTimes[keyTimeIndex +
                                1] -
                       keyTimes[keyTimeIndex]);
                if (calcMode ==
                      CALC_MODE_SPLINE &&
                      unitTime !=
                      0) {
                    org.apache.batik.ext.awt.geom.Cubic c =
                      keySplineCubics[keyTimeIndex];
                    float tolerance =
                      0.001F;
                    float min =
                      0;
                    float max =
                      1;
                    java.awt.geom.Point2D.Double p;
                    for (;
                         ;
                         ) {
                        float t =
                          (min +
                             max) /
                          2;
                        p =
                          c.
                            eval(
                              t);
                        double x =
                          p.
                          getX(
                            );
                        if (java.lang.Math.
                              abs(
                                x -
                                  interpolation) <
                              tolerance) {
                            break;
                        }
                        if (x <
                              interpolation) {
                            min =
                              t;
                        }
                        else {
                            max =
                              t;
                        }
                    }
                    interpolation =
                      (float)
                        p.
                        getY(
                          );
                }
            }
            else {
                nextValue =
                  null;
            }
        }
        else {
            value =
              values[values.
                       length -
                       1];
            nextValue =
              null;
        }
        if (cumulative) {
            accumulation =
              values[values.
                       length -
                       1];
        }
        else {
            accumulation =
              null;
        }
        this.
          value =
          value.
            interpolate(
              this.
                value,
              nextValue,
              interpolation,
              accumulation,
              repeatIteration);
        if (this.
              value.
              hasChanged(
                )) {
            markDirty(
              );
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0Pc/ljVDuZkeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "W5ttS2ViIbOnJkhHZ8RoO7TjgCMTbjktVG2X7nlaXZm+njJsHUChOQpMzzKX" +
       "ZtFYq7NxrTdN92wHS31lqKXutC1Si9GA7LV3mxaexPVps96Cx3IheU2yn/WT" +
       "fa8xWKvklrWTWGTC2jY3nAxM3AfAubfHMk7pGeyF8QrdEHBzEkfj0cxA6vmA" +
       "nOk9G+Eb0TgnprHit2VaWetauwWzbRfhKMPchh1lwhEYp/GF1JkFQmfSKQqz" +
       "ES6IpUcuNMXtwkoUZIGUMp7eTIypgaxqnIF4K4ncqGsL7Lx/pNySf/UHOyp4" +
       "sjoVOf3+Z+VVp7Rf+gFOA/JzB+anR0fV72Ho0jcj546Ozp0ZQuWp5jP3+qyn" +
       "etn4xY+/+prJfgm9enzWejuDHs3C6IOetbW8c0MdHxhfPMGiwPWFYza+cPkE" +
       "60zQ+x5fXTr3PXdyTZYFXlF97T6nw/+6LH4D6DvVyi9BzG4mBm5Wvni+64nM" +
       "NnTNM/X/izc7jLlwHJtBNy59blK+O3/nHV+3Hb7IMr782o1H3vGa+AeHd6Un" +
       "X009SkOP2BvPO//O6tz9w1Fi2Ycz8UcP59NR9ff1DHrbXd8zAJnKv4rbf3Og" +
       "/YMMunmZNoMeqv7P0/1hBl0/o8ughw8350n+KIMeACTl7TeiN3nhQZXvfIEy" +
       "QE2wPFVRfuWiRZ7q/qk30/05I37hwsl/9dXhyXuszeG7w5eNr7w2nv74d1tf" +
       "OnwoYnjavprmERq6dvhm5fRd2PP3HO1krIdHL33viV979MUTt3jiwPCZTZ/j" +
       "7bm7f5XR96Os+o5i/0/e8Y8+9Pdf+0Z19vj/AL08V6MOKgAA");
}
