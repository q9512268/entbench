package org.apache.batik.anim;
public abstract class InterpolatingAnimation extends org.apache.batik.anim.AbstractAnimation {
    protected int calcMode;
    protected float[] keyTimes;
    protected float[] keySplines;
    protected org.apache.batik.ext.awt.geom.Cubic[] keySplineCubics;
    protected boolean additive;
    protected boolean cumulative;
    public InterpolatingAnimation(org.apache.batik.anim.timing.TimedElement timedElement,
                                  org.apache.batik.dom.anim.AnimatableElement animatableElement,
                                  int calcMode,
                                  float[] keyTimes,
                                  float[] keySplines,
                                  boolean additive,
                                  boolean cumulative) { super(
                                                          timedElement,
                                                          animatableElement);
                                                        this.
                                                          calcMode =
                                                          calcMode;
                                                        this.
                                                          keyTimes =
                                                          keyTimes;
                                                        this.
                                                          keySplines =
                                                          keySplines;
                                                        this.
                                                          additive =
                                                          additive;
                                                        this.
                                                          cumulative =
                                                          cumulative;
                                                        if (calcMode ==
                                                              CALC_MODE_SPLINE) {
                                                            if (keySplines ==
                                                                  null ||
                                                                  keySplines.
                                                                    length %
                                                                  4 !=
                                                                  0) {
                                                                throw timedElement.
                                                                  createException(
                                                                    "attribute.malformed",
                                                                    new java.lang.Object[] { null,
                                                                    org.apache.batik.util.SMILConstants.
                                                                      SMIL_KEY_SPLINES_ATTRIBUTE });
                                                            }
                                                            keySplineCubics =
                                                              (new org.apache.batik.ext.awt.geom.Cubic[keySplines.
                                                                                                         length /
                                                                                                         4]);
                                                            for (int i =
                                                                   0;
                                                                 i <
                                                                   keySplines.
                                                                     length /
                                                                   4;
                                                                 i++) {
                                                                keySplineCubics[i] =
                                                                  new org.apache.batik.ext.awt.geom.Cubic(
                                                                    0,
                                                                    0,
                                                                    keySplines[i *
                                                                                 4],
                                                                    keySplines[i *
                                                                                 4 +
                                                                                 1],
                                                                    keySplines[i *
                                                                                 4 +
                                                                                 2],
                                                                    keySplines[i *
                                                                                 4 +
                                                                                 3],
                                                                    1,
                                                                    1);
                                                            }
                                                        }
                                                        if (keyTimes !=
                                                              null) {
                                                            boolean invalidKeyTimes =
                                                              false;
                                                            if ((calcMode ==
                                                                   CALC_MODE_LINEAR ||
                                                                   calcMode ==
                                                                   CALC_MODE_SPLINE ||
                                                                   calcMode ==
                                                                   CALC_MODE_PACED) &&
                                                                  (keyTimes.
                                                                     length <
                                                                     2 ||
                                                                     keyTimes[0] !=
                                                                     0 ||
                                                                     keyTimes[keyTimes.
                                                                                length -
                                                                                1] !=
                                                                     1) ||
                                                                  calcMode ==
                                                                  CALC_MODE_DISCRETE &&
                                                                  (keyTimes.
                                                                     length ==
                                                                     0 ||
                                                                     keyTimes[0] !=
                                                                     0)) {
                                                                invalidKeyTimes =
                                                                  true;
                                                            }
                                                            if (!invalidKeyTimes) {
                                                                for (int i =
                                                                       1;
                                                                     i <
                                                                       keyTimes.
                                                                         length;
                                                                     i++) {
                                                                    if (keyTimes[i] <
                                                                          0 ||
                                                                          keyTimes[1] >
                                                                          1 ||
                                                                          keyTimes[i] <
                                                                          keyTimes[i -
                                                                                     1]) {
                                                                        invalidKeyTimes =
                                                                          true;
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            if (invalidKeyTimes) {
                                                                throw timedElement.
                                                                  createException(
                                                                    "attribute.malformed",
                                                                    new java.lang.Object[] { null,
                                                                    org.apache.batik.util.SMILConstants.
                                                                      SMIL_KEY_TIMES_ATTRIBUTE });
                                                            }
                                                        }
    }
    protected boolean willReplace() { return !additive;
    }
    protected void sampledLastValue(int repeatIteration) {
        sampledAtUnitTime(
          1.0F,
          repeatIteration);
    }
    protected void sampledAt(float simpleTime,
                             float simpleDur,
                             int repeatIteration) {
        float unitTime;
        if (simpleDur ==
              org.apache.batik.anim.timing.TimedElement.
                INDEFINITE) {
            unitTime =
              0;
        }
        else {
            unitTime =
              simpleTime /
                simpleDur;
        }
        sampledAtUnitTime(
          unitTime,
          repeatIteration);
    }
    protected abstract void sampledAtUnitTime(float unitTime,
                                              int repeatIteration);
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "IgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "PXruwRpguvlfwfSf72j/Atj8WdoAulz8");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("n6DLd+5vHNMF0JVd5STJpQC6CEjy6mXncEf+neef8MEPwPZIO8mF02B6pP1H" +
       "vpv2T+Dvc6c+rRZnjg8/WIe7U8cvyF96pdv/0W83Prc7ESYbUpblo1xjoau7" +
       "w2nFoPlH72fuOdrhWFfo57/z0M9ff/shoj+0Y/jYjE/w9vT5x69I0wmKA1PZ" +
       "v3r8n//QP37l94rvBv8fkEmO9gwuAAA=");
}
