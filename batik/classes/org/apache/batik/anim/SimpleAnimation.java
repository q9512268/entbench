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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "u26ydG39Ln/F4b3/AV96Ka4sHwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "udj/43f8ww/93de+Xu1h/j8pVCpGHioAAA==");
}
