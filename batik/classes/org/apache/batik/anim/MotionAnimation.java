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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6ZMmUyEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "M2rpNNlaV4cgethHNN0hrXpu9ybhVrfqsbvy1HmTd8U+qzkJSXV0m6TkOTqt" +
       "FevcmtJjJrI7MrOQyKCwASm0gEPNhEOmW3QLewt8Ik8NHmtsMonUOS9sQe15" +
       "PjHCFTegQYzM0TEXLNJB0hi1Jd532L7huam6MJjxsDVrUqjVQ5SFiHVcR94N" +
       "eBPG08VKUzqrJRuOeDutqfDatsPlSBj4GToYE9xqCYI+K2L0jup1Us7G7GBi" +
       "1MOZlnTI5tJfew63GSqrrum1680hRPRXScTsKNRGxIVBbiLFDfUGoxLTdcbY" +
       "WKdmiRHbbc16OQhsA5xn+mQHS3utdhcJxDCb2ewcxFR/tWuMQofmchR3I15Y" +
       "5zsUj+fwZFjTUqM60bc8isBLHW3p7e4CWpmpp0Mx2p3ju8ZkxPud6Yjy+mlu" +
       "xmgrFOEsJpBWBsUQqTlZrYs0NXO99paksjFTGm64ENRs+sFW63Rd1ui5o/V0" +
       "a3dRq+N5VtPtNWb2gN50d5A6aXu1aDGrc2tKEsKFUqtyi5iHkHCWg2wKsv1u" +
       "g69pDrKkWYff8tFQbY3QppMTWyzTlAXMdKsUlEzhLjSjsWXeBdaiKZq127gC" +
       "PGJUmMEhbb3rz1CHJFYU3HanPdxaeGPNh7IujDJ2tNRFftCDFjXbRqSlOIF3" +
       "OrTTO6lhyN5OFqHedhMMm+Ial1aLBqYxjr7Bp4tFrTncMPCuhTg73R5v5ti8" +
       "5feaNtbomlW+S+StLmfFfYJEakjTRbpVd7NJppbr4yD2jvvzbnvsAyrIlmml" +
       "/SQeagOnnW/XQkeDNmGy7AxtO7IQbACBgjGFtxIMVTGj4Uq7NbWEFhaEt5c1" +
       "beN3teZOitVGbWPYkzq7Y2v92byvt8PAWStd0g05iO5T6+rKw9s0q4q7WeLw" +
       "XkbW5knaqAXJSOx1OwORNWakovk7iUSQNmPX8bk6NbxOutySjDKfr2ms3xHE" +
       "tjOYGjuVW03XbcujfFOZi+I6Xc+zDSnObBzICHHZzXZKMgnDyX3OTBcu2cSd" +
       "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" +
       "vySVa2dwSeXK/uY8yH9NKvcBkOL2v4Vv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("sXdHFUcUgDDAG988FVF26aJFnsr+8beS/Tkjfu7C5lJ5EPZkSzbdH4V9Wf3a" +
       "a8PJD32n9dP7c02qK+d50ctDdOXB/RGr023dZ+/a20lfV8gXvvvoz199/sQt" +
       "Ht0TfGbT52h7+s6HiPpemJTHfvJfet8vfN/PvvaH5Trr/wO3m494oSwAAA==");
}
