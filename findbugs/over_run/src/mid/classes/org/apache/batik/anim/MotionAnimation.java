package org.apache.batik.anim;
public class MotionAnimation extends org.apache.batik.anim.InterpolatingAnimation {
    protected org.apache.batik.ext.awt.geom.ExtendedGeneralPath path;
    protected org.apache.batik.ext.awt.geom.PathLength pathLength;
    protected float[] keyPoints;
    protected boolean rotateAuto;
    protected boolean rotateAutoReverse;
    protected float rotateAngle;
    public MotionAnimation(org.apache.batik.anim.timing.TimedElement timedElement,
                           org.apache.batik.dom.anim.AnimatableElement animatableElement,
                           int calcMode,
                           float[] keyTimes,
                           float[] keySplines,
                           boolean additive,
                           boolean cumulative,
                           org.apache.batik.anim.values.AnimatableValue[] values,
                           org.apache.batik.anim.values.AnimatableValue from,
                           org.apache.batik.anim.values.AnimatableValue to,
                           org.apache.batik.anim.values.AnimatableValue by,
                           org.apache.batik.ext.awt.geom.ExtendedGeneralPath path,
                           float[] keyPoints,
                           boolean rotateAuto,
                           boolean rotateAutoReverse,
                           float rotateAngle,
                           short rotateAngleUnit) {
        super(
          timedElement,
          animatableElement,
          calcMode,
          keyTimes,
          keySplines,
          additive,
          cumulative);
        this.
          rotateAuto =
          rotateAuto;
        this.
          rotateAutoReverse =
          rotateAutoReverse;
        this.
          rotateAngle =
          org.apache.batik.anim.values.AnimatableAngleValue.
            rad(
              rotateAngle,
              rotateAngleUnit);
        if (path ==
              null) {
            path =
              new org.apache.batik.ext.awt.geom.ExtendedGeneralPath(
                );
            if (values ==
                  null ||
                  values.
                    length ==
                  0) {
                if (from !=
                      null) {
                    org.apache.batik.anim.values.AnimatableMotionPointValue fromPt =
                      (org.apache.batik.anim.values.AnimatableMotionPointValue)
                        from;
                    float x =
                      fromPt.
                      getX(
                        );
                    float y =
                      fromPt.
                      getY(
                        );
                    path.
                      moveTo(
                        x,
                        y);
                    if (to !=
                          null) {
                        org.apache.batik.anim.values.AnimatableMotionPointValue toPt =
                          (org.apache.batik.anim.values.AnimatableMotionPointValue)
                            to;
                        path.
                          lineTo(
                            toPt.
                              getX(
                                ),
                            toPt.
                              getY(
                                ));
                    }
                    else
                        if (by !=
                              null) {
                            org.apache.batik.anim.values.AnimatableMotionPointValue byPt =
                              (org.apache.batik.anim.values.AnimatableMotionPointValue)
                                by;
                            path.
                              lineTo(
                                x +
                                  byPt.
                                  getX(
                                    ),
                                y +
                                  byPt.
                                  getY(
                                    ));
                        }
                        else {
                            throw timedElement.
                              createException(
                                "values.to.by.path.missing",
                                new java.lang.Object[] { null });
                        }
                }
                else {
                    if (to !=
                          null) {
                        org.apache.batik.anim.values.AnimatableMotionPointValue unPt =
                          (org.apache.batik.anim.values.AnimatableMotionPointValue)
                            animatableElement.
                            getUnderlyingValue(
                              );
                        org.apache.batik.anim.values.AnimatableMotionPointValue toPt =
                          (org.apache.batik.anim.values.AnimatableMotionPointValue)
                            to;
                        path.
                          moveTo(
                            unPt.
                              getX(
                                ),
                            unPt.
                              getY(
                                ));
                        path.
                          lineTo(
                            toPt.
                              getX(
                                ),
                            toPt.
                              getY(
                                ));
                        this.
                          cumulative =
                          false;
                    }
                    else
                        if (by !=
                              null) {
                            org.apache.batik.anim.values.AnimatableMotionPointValue byPt =
                              (org.apache.batik.anim.values.AnimatableMotionPointValue)
                                by;
                            path.
                              moveTo(
                                0,
                                0);
                            path.
                              lineTo(
                                byPt.
                                  getX(
                                    ),
                                byPt.
                                  getY(
                                    ));
                            this.
                              additive =
                              true;
                        }
                        else {
                            throw timedElement.
                              createException(
                                "values.to.by.path.missing",
                                new java.lang.Object[] { null });
                        }
                }
            }
            else {
                org.apache.batik.anim.values.AnimatableMotionPointValue pt =
                  (org.apache.batik.anim.values.AnimatableMotionPointValue)
                    values[0];
                path.
                  moveTo(
                    pt.
                      getX(
                        ),
                    pt.
                      getY(
                        ));
                for (int i =
                       1;
                     i <
                       values.
                         length;
                     i++) {
                    pt =
                      (org.apache.batik.anim.values.AnimatableMotionPointValue)
                        values[i];
                    path.
                      lineTo(
                        pt.
                          getX(
                            ),
                        pt.
                          getY(
                            ));
                }
            }
        }
        this.
          path =
          path;
        pathLength =
          new org.apache.batik.ext.awt.geom.PathLength(
            path);
        int segments =
          0;
        org.apache.batik.ext.awt.geom.ExtendedPathIterator epi =
          path.
          getExtendedPathIterator(
            );
        while (!epi.
                 isDone(
                   )) {
            int type =
              epi.
              currentSegment(
                );
            if (type !=
                  org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                    SEG_MOVETO) {
                segments++;
            }
            epi.
              next(
                );
        }
        int count =
          keyPoints ==
          null
          ? segments +
          1
          : keyPoints.
              length;
        float totalLength =
          pathLength.
          lengthOfPath(
            );
        if (this.
              keyTimes !=
              null &&
              calcMode !=
              CALC_MODE_PACED) {
            if (this.
                  keyTimes.
                  length !=
                  count) {
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
                  CALC_MODE_SPLINE) {
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
                    epi =
                      path.
                        getExtendedPathIterator(
                          );
                    this.
                      keyTimes =
                      (new float[count]);
                    int j =
                      0;
                    for (int i =
                           0;
                         i <
                           count -
                           1;
                         i++) {
                        while (epi.
                                 currentSegment(
                                   ) ==
                                 org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                                   SEG_MOVETO) {
                            j++;
                            epi.
                              next(
                                );
                        }
                        this.
                          keyTimes[i] =
                          pathLength.
                            getLengthAtSegment(
                              j) /
                            totalLength;
                        j++;
                        epi.
                          next(
                            );
                    }
                    this.
                      keyTimes[count -
                                 1] =
                      1.0F;
                }
        }
        if (keyPoints !=
              null) {
            if (keyPoints.
                  length !=
                  this.
                    keyTimes.
                    length) {
                throw timedElement.
                  createException(
                    "attribute.malformed",
                    new java.lang.Object[] { null,
                    org.apache.batik.util.SMILConstants.
                      SMIL_KEY_POINTS_ATTRIBUTE });
            }
        }
        else {
            epi =
              path.
                getExtendedPathIterator(
                  );
            keyPoints =
              (new float[count]);
            int j =
              0;
            for (int i =
                   0;
                 i <
                   count -
                   1;
                 i++) {
                while (epi.
                         currentSegment(
                           ) ==
                         org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                           SEG_MOVETO) {
                    j++;
                    epi.
                      next(
                        );
                }
                keyPoints[i] =
                  pathLength.
                    getLengthAtSegment(
                      j) /
                    totalLength;
                j++;
                epi.
                  next(
                    );
            }
            keyPoints[count -
                        1] =
              1.0F;
        }
        this.
          keyPoints =
          keyPoints;
    }
    protected void sampledAtUnitTime(float unitTime,
                                     int repeatIteration) {
        org.apache.batik.anim.values.AnimatableValue value;
        org.apache.batik.anim.values.AnimatableValue accumulation;
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
            if (keyTimeIndex ==
                  keyTimes.
                    length -
                  1 &&
                  calcMode ==
                  CALC_MODE_DISCRETE) {
                keyTimeIndex =
                  keyTimes.
                    length -
                    2;
                interpolation =
                  1;
            }
            else {
                if (calcMode ==
                      CALC_MODE_LINEAR ||
                      calcMode ==
                      CALC_MODE_PACED ||
                      calcMode ==
                      CALC_MODE_SPLINE) {
                    if (unitTime ==
                          0) {
                        interpolation =
                          0;
                    }
                    else {
                        interpolation =
                          (unitTime -
                             keyTimes[keyTimeIndex]) /
                            (keyTimes[keyTimeIndex +
                                        1] -
                               keyTimes[keyTimeIndex]);
                    }
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
            }
            float point =
              keyPoints[keyTimeIndex];
            if (interpolation !=
                  0) {
                point +=
                  interpolation *
                    (keyPoints[keyTimeIndex +
                                 1] -
                       keyPoints[keyTimeIndex]);
            }
            point *=
              pathLength.
                lengthOfPath(
                  );
            java.awt.geom.Point2D p =
              pathLength.
              pointAtLength(
                point);
            float ang;
            if (rotateAuto) {
                ang =
                  pathLength.
                    angleAtLength(
                      point);
                if (rotateAutoReverse) {
                    ang +=
                      java.lang.Math.
                        PI;
                }
            }
            else {
                ang =
                  rotateAngle;
            }
            value =
              new org.apache.batik.anim.values.AnimatableMotionPointValue(
                null,
                (float)
                  p.
                  getX(
                    ),
                (float)
                  p.
                  getY(
                    ),
                ang);
        }
        else {
            java.awt.geom.Point2D p =
              pathLength.
              pointAtLength(
                pathLength.
                  lengthOfPath(
                    ));
            float ang;
            if (rotateAuto) {
                ang =
                  pathLength.
                    angleAtLength(
                      pathLength.
                        lengthOfPath(
                          ));
                if (rotateAutoReverse) {
                    ang +=
                      java.lang.Math.
                        PI;
                }
            }
            else {
                ang =
                  rotateAngle;
            }
            value =
              new org.apache.batik.anim.values.AnimatableMotionPointValue(
                null,
                (float)
                  p.
                  getX(
                    ),
                (float)
                  p.
                  getY(
                    ),
                ang);
        }
        if (cumulative) {
            java.awt.geom.Point2D p =
              pathLength.
              pointAtLength(
                pathLength.
                  lengthOfPath(
                    ));
            float ang;
            if (rotateAuto) {
                ang =
                  pathLength.
                    angleAtLength(
                      pathLength.
                        lengthOfPath(
                          ));
                if (rotateAutoReverse) {
                    ang +=
                      java.lang.Math.
                        PI;
                }
            }
            else {
                ang =
                  rotateAngle;
            }
            accumulation =
              new org.apache.batik.anim.values.AnimatableMotionPointValue(
                null,
                (float)
                  p.
                  getX(
                    ),
                (float)
                  p.
                  getY(
                    ),
                ang);
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
              null,
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
       "IAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xM9d+DBUHn49+Zya7I+/vqR87VWa+4Fv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("139qf15JceQ8L3p5iIEe3B+dOv0k++xdezvp60r/he88+nNXnz9xi0f3DJ/Z" +
       "9Dnenr7z4aCOG8TlcZ78F9/z89/zM6/+SblH+v8ACv5zfJUsAAA=");
}
