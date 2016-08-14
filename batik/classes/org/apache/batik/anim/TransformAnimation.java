package org.apache.batik.anim;
public class TransformAnimation extends org.apache.batik.anim.SimpleAnimation {
    protected short type;
    protected float[] keyTimes2;
    protected float[] keyTimes3;
    public TransformAnimation(org.apache.batik.anim.timing.TimedElement timedElement,
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
                              short type) { super(
                                              timedElement,
                                              animatableElement,
                                              calcMode ==
                                                CALC_MODE_PACED
                                                ? CALC_MODE_LINEAR
                                                : calcMode,
                                              calcMode ==
                                                CALC_MODE_PACED
                                                ? null
                                                : keyTimes,
                                              keySplines,
                                              additive,
                                              cumulative,
                                              values,
                                              from,
                                              to,
                                              by);
                                            this.
                                              calcMode =
                                              calcMode;
                                            this.
                                              type =
                                              type;
                                            if (calcMode !=
                                                  CALC_MODE_PACED) {
                                                return;
                                            }
                                            int count =
                                              this.
                                                values.
                                                length;
                                            float[] cumulativeDistances1;
                                            float[] cumulativeDistances2 =
                                              null;
                                            float[] cumulativeDistances3 =
                                              null;
                                            switch (type) {
                                                case org.w3c.dom.svg.SVGTransform.
                                                       SVG_TRANSFORM_ROTATE:
                                                    cumulativeDistances3 =
                                                      (new float[count]);
                                                    cumulativeDistances3[0] =
                                                      0.0F;
                                                case org.w3c.dom.svg.SVGTransform.
                                                       SVG_TRANSFORM_SCALE:
                                                case org.w3c.dom.svg.SVGTransform.
                                                       SVG_TRANSFORM_TRANSLATE:
                                                    cumulativeDistances2 =
                                                      (new float[count]);
                                                    cumulativeDistances2[0] =
                                                      0.0F;
                                                default:
                                                    cumulativeDistances1 =
                                                      (new float[count]);
                                                    cumulativeDistances1[0] =
                                                      0.0F;
                                            }
                                            for (int i =
                                                   1;
                                                 i <
                                                   this.
                                                     values.
                                                     length;
                                                 i++) {
                                                switch (type) {
                                                    case org.w3c.dom.svg.SVGTransform.
                                                           SVG_TRANSFORM_ROTATE:
                                                        cumulativeDistances3[i] =
                                                          cumulativeDistances3[i -
                                                                                 1] +
                                                            ((org.apache.batik.anim.values.AnimatableTransformListValue)
                                                               this.
                                                                 values[i -
                                                                          1]).
                                                            distanceTo3(
                                                              this.
                                                                values[i]);
                                                    case org.w3c.dom.svg.SVGTransform.
                                                           SVG_TRANSFORM_SCALE:
                                                    case org.w3c.dom.svg.SVGTransform.
                                                           SVG_TRANSFORM_TRANSLATE:
                                                        cumulativeDistances2[i] =
                                                          cumulativeDistances2[i -
                                                                                 1] +
                                                            ((org.apache.batik.anim.values.AnimatableTransformListValue)
                                                               this.
                                                                 values[i -
                                                                          1]).
                                                            distanceTo2(
                                                              this.
                                                                values[i]);
                                                    default:
                                                        cumulativeDistances1[i] =
                                                          cumulativeDistances1[i -
                                                                                 1] +
                                                            ((org.apache.batik.anim.values.AnimatableTransformListValue)
                                                               this.
                                                                 values[i -
                                                                          1]).
                                                            distanceTo1(
                                                              this.
                                                                values[i]);
                                                }
                                            }
                                            switch (type) {
                                                case org.w3c.dom.svg.SVGTransform.
                                                       SVG_TRANSFORM_ROTATE:
                                                    float totalLength =
                                                      cumulativeDistances3[count -
                                                                             1];
                                                    keyTimes3 =
                                                      (new float[count]);
                                                    keyTimes3[0] =
                                                      0.0F;
                                                    for (int i =
                                                           1;
                                                         i <
                                                           count -
                                                           1;
                                                         i++) {
                                                        keyTimes3[i] =
                                                          cumulativeDistances3[i] /
                                                            totalLength;
                                                    }
                                                    keyTimes3[count -
                                                                1] =
                                                      1.0F;
                                                case org.w3c.dom.svg.SVGTransform.
                                                       SVG_TRANSFORM_SCALE:
                                                case org.w3c.dom.svg.SVGTransform.
                                                       SVG_TRANSFORM_TRANSLATE:
                                                    totalLength =
                                                      cumulativeDistances2[count -
                                                                             1];
                                                    keyTimes2 =
                                                      (new float[count]);
                                                    keyTimes2[0] =
                                                      0.0F;
                                                    for (int i =
                                                           1;
                                                         i <
                                                           count -
                                                           1;
                                                         i++) {
                                                        keyTimes2[i] =
                                                          cumulativeDistances2[i] /
                                                            totalLength;
                                                    }
                                                    keyTimes2[count -
                                                                1] =
                                                      1.0F;
                                                default:
                                                    totalLength =
                                                      cumulativeDistances1[count -
                                                                             1];
                                                    this.
                                                      keyTimes =
                                                      (new float[count]);
                                                    this.
                                                      keyTimes[0] =
                                                      0.0F;
                                                    for (int i =
                                                           1;
                                                         i <
                                                           count -
                                                           1;
                                                         i++) {
                                                        this.
                                                          keyTimes[i] =
                                                          cumulativeDistances1[i] /
                                                            totalLength;
                                                    }
                                                    this.
                                                      keyTimes[count -
                                                                 1] =
                                                      1.0F;
                                            }
    }
    protected void sampledAtUnitTime(float unitTime,
                                     int repeatIteration) {
        if (calcMode !=
              CALC_MODE_PACED ||
              type ==
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_SKEWX ||
              type ==
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_SKEWY) {
            super.
              sampledAtUnitTime(
                unitTime,
                repeatIteration);
            return;
        }
        org.apache.batik.anim.values.AnimatableTransformListValue value1;
        org.apache.batik.anim.values.AnimatableTransformListValue value2;
        org.apache.batik.anim.values.AnimatableTransformListValue value3 =
          null;
        org.apache.batik.anim.values.AnimatableTransformListValue nextValue1;
        org.apache.batik.anim.values.AnimatableTransformListValue nextValue2;
        org.apache.batik.anim.values.AnimatableTransformListValue nextValue3 =
          null;
        org.apache.batik.anim.values.AnimatableTransformListValue accumulation;
        float interpolation1 =
          0.0F;
        float interpolation2 =
          0.0F;
        float interpolation3 =
          0.0F;
        if (unitTime !=
              1) {
            switch (type) {
                case org.w3c.dom.svg.SVGTransform.
                       SVG_TRANSFORM_ROTATE:
                    int keyTimeIndex =
                      0;
                    while (keyTimeIndex <
                             keyTimes3.
                               length -
                             1 &&
                             unitTime >=
                             keyTimes3[keyTimeIndex +
                                         1]) {
                        keyTimeIndex++;
                    }
                    value3 =
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          values[keyTimeIndex];
                    nextValue3 =
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          values[keyTimeIndex +
                                   1];
                    interpolation3 =
                      (unitTime -
                         keyTimes3[keyTimeIndex]) /
                        (keyTimes3[keyTimeIndex +
                                     1] -
                           keyTimes3[keyTimeIndex]);
                default:
                    keyTimeIndex =
                      0;
                    while (keyTimeIndex <
                             keyTimes2.
                               length -
                             1 &&
                             unitTime >=
                             keyTimes2[keyTimeIndex +
                                         1]) {
                        keyTimeIndex++;
                    }
                    value2 =
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          values[keyTimeIndex];
                    nextValue2 =
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          values[keyTimeIndex +
                                   1];
                    interpolation2 =
                      (unitTime -
                         keyTimes2[keyTimeIndex]) /
                        (keyTimes2[keyTimeIndex +
                                     1] -
                           keyTimes2[keyTimeIndex]);
                    keyTimeIndex =
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
                    value1 =
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          values[keyTimeIndex];
                    nextValue1 =
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          values[keyTimeIndex +
                                   1];
                    interpolation1 =
                      (unitTime -
                         keyTimes[keyTimeIndex]) /
                        (keyTimes[keyTimeIndex +
                                    1] -
                           keyTimes[keyTimeIndex]);
            }
        }
        else {
            value1 =
              (value2 =
                 (value3 =
                    (org.apache.batik.anim.values.AnimatableTransformListValue)
                      this.
                        values[this.
                                 values.
                                 length -
                                 1]));
            nextValue1 =
              (nextValue2 =
                 (nextValue3 =
                    null));
            interpolation1 =
              (interpolation2 =
                 (interpolation3 =
                    1.0F));
        }
        if (cumulative) {
            accumulation =
              (org.apache.batik.anim.values.AnimatableTransformListValue)
                this.
                  values[this.
                           values.
                           length -
                           1];
        }
        else {
            accumulation =
              null;
        }
        switch (type) {
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_ROTATE:
                this.
                  value =
                  org.apache.batik.anim.values.AnimatableTransformListValue.
                    interpolate(
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          value,
                      value1,
                      value2,
                      value3,
                      nextValue1,
                      nextValue2,
                      nextValue3,
                      interpolation1,
                      interpolation2,
                      interpolation3,
                      accumulation,
                      repeatIteration);
                break;
            default:
                this.
                  value =
                  org.apache.batik.anim.values.AnimatableTransformListValue.
                    interpolate(
                      (org.apache.batik.anim.values.AnimatableTransformListValue)
                        this.
                          value,
                      value1,
                      value2,
                      nextValue1,
                      nextValue2,
                      interpolation1,
                      interpolation2,
                      accumulation,
                      repeatIteration);
                break;
        }
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
       "HgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
