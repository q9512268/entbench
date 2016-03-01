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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "oKGXKQAA");
}
