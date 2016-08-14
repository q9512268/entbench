package org.apache.batik.ext.awt;
abstract class MultipleGradientPaintContext implements java.awt.PaintContext {
    protected static final boolean DEBUG = false;
    protected java.awt.image.ColorModel dataModel;
    protected java.awt.image.ColorModel model;
    private static java.awt.image.ColorModel lrgbmodel_NA = new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_LINEAR_RGB),
      24,
      16711680,
      65280,
      255,
      0,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static java.awt.image.ColorModel srgbmodel_NA = new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      24,
      16711680,
      65280,
      255,
      0,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static java.awt.image.ColorModel lrgbmodel_A =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_LINEAR_RGB),
      32,
      16711680,
      65280,
      255,
      -16777216,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    private static java.awt.image.ColorModel srgbmodel_A =
      new java.awt.image.DirectColorModel(
      java.awt.color.ColorSpace.
        getInstance(
          java.awt.color.ColorSpace.
            CS_sRGB),
      32,
      16711680,
      65280,
      255,
      -16777216,
      false,
      java.awt.image.DataBuffer.
        TYPE_INT);
    protected static java.awt.image.ColorModel cachedModel;
    protected static java.lang.ref.WeakReference cached;
    protected java.awt.image.WritableRaster saved;
    protected org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum
      cycleMethod;
    protected org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum
      colorSpace;
    protected float a00;
    protected float a01;
    protected float a10;
    protected float a11;
    protected float a02;
    protected float a12;
    protected boolean isSimpleLookup = true;
    protected boolean hasDiscontinuity = false;
    protected int fastGradientArraySize;
    protected int[] gradient;
    protected int[][] gradients;
    protected int gradientAverage;
    protected int gradientUnderflow;
    protected int gradientOverflow;
    protected int gradientsLength;
    protected float[] normalizedIntervals;
    protected float[] fractions;
    private int transparencyTest;
    private static final int[] SRGBtoLinearRGB = new int[256];
    private static final int[] LinearRGBtoSRGB = new int[256];
    static { for (int k = 0; k < 256; k++) { SRGBtoLinearRGB[k] =
                                               convertSRGBtoLinearRGB(
                                                 k);
                                             LinearRGBtoSRGB[k] =
                                               convertLinearRGBtoSRGB(
                                                 k); } }
    protected static final int GRADIENT_SIZE = 256;
    protected static final int GRADIENT_SIZE_INDEX = GRADIENT_SIZE -
      1;
    private static final int MAX_GRADIENT_ARRAY_SIZE = 5000;
    protected MultipleGradientPaintContext(java.awt.image.ColorModel cm,
                                           java.awt.Rectangle deviceBounds,
                                           java.awt.geom.Rectangle2D userBounds,
                                           java.awt.geom.AffineTransform t,
                                           java.awt.RenderingHints hints,
                                           float[] fractions,
                                           java.awt.Color[] colors,
                                           org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum cycleMethod,
                                           org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace)
          throws java.awt.geom.NoninvertibleTransformException {
        super(
          );
        boolean fixFirst =
          false;
        boolean fixLast =
          false;
        int len =
          fractions.
            length;
        if (fractions[0] !=
              0.0F) {
            fixFirst =
              true;
            len++;
        }
        if (fractions[fractions.
                        length -
                        1] !=
              1.0F) {
            fixLast =
              true;
            len++;
        }
        for (int i =
               0;
             i <
               fractions.
                 length -
               1;
             i++)
            if (fractions[i] ==
                  fractions[i +
                              1])
                len--;
        this.
          fractions =
          (new float[len]);
        java.awt.Color[] loColors =
          new java.awt.Color[len -
                               1];
        java.awt.Color[] hiColors =
          new java.awt.Color[len -
                               1];
        normalizedIntervals =
          (new float[len -
                       1]);
        gradientUnderflow =
          colors[0].
            getRGB(
              );
        gradientOverflow =
          colors[colors.
                   length -
                   1].
            getRGB(
              );
        int idx =
          0;
        if (fixFirst) {
            this.
              fractions[0] =
              0;
            loColors[0] =
              colors[0];
            hiColors[0] =
              colors[0];
            normalizedIntervals[0] =
              fractions[0];
            idx++;
        }
        for (int i =
               0;
             i <
               fractions.
                 length -
               1;
             i++) {
            if (fractions[i] ==
                  fractions[i +
                              1]) {
                if (!colors[i].
                      equals(
                        colors[i +
                                 1])) {
                    hasDiscontinuity =
                      true;
                }
                continue;
            }
            this.
              fractions[idx] =
              fractions[i];
            loColors[idx] =
              colors[i];
            hiColors[idx] =
              colors[i +
                       1];
            normalizedIntervals[idx] =
              fractions[i +
                          1] -
                fractions[i];
            idx++;
        }
        this.
          fractions[idx] =
          fractions[fractions.
                      length -
                      1];
        if (fixLast) {
            loColors[idx] =
              (hiColors[idx] =
                 colors[colors.
                          length -
                          1]);
            normalizedIntervals[idx] =
              1 -
                fractions[fractions.
                            length -
                            1];
            idx++;
            this.
              fractions[idx] =
              1;
        }
        java.awt.geom.AffineTransform tInv =
          t.
          createInverse(
            );
        double[] m =
          new double[6];
        tInv.
          getMatrix(
            m);
        a00 =
          (float)
            m[0];
        a10 =
          (float)
            m[1];
        a01 =
          (float)
            m[2];
        a11 =
          (float)
            m[3];
        a02 =
          (float)
            m[4];
        a12 =
          (float)
            m[5];
        this.
          cycleMethod =
          cycleMethod;
        this.
          colorSpace =
          colorSpace;
        if (cm.
              getColorSpace(
                ) ==
              lrgbmodel_A.
              getColorSpace(
                ))
            dataModel =
              lrgbmodel_A;
        else
            if (cm.
                  getColorSpace(
                    ) ==
                  srgbmodel_A.
                  getColorSpace(
                    ))
                dataModel =
                  srgbmodel_A;
            else
                throw new java.lang.IllegalArgumentException(
                  "Unsupported ColorSpace for interpolation");
        calculateGradientFractions(
          loColors,
          hiColors);
        model =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            coerceColorModel(
              dataModel,
              cm.
                isAlphaPremultiplied(
                  ));
    }
    protected final void calculateGradientFractions(java.awt.Color[] loColors,
                                                    java.awt.Color[] hiColors) {
        if (colorSpace ==
              org.apache.batik.ext.awt.LinearGradientPaint.
                LINEAR_RGB) {
            int[] workTbl =
              SRGBtoLinearRGB;
            for (int i =
                   0;
                 i <
                   loColors.
                     length;
                 i++) {
                loColors[i] =
                  interpolateColor(
                    workTbl,
                    loColors[i]);
                hiColors[i] =
                  interpolateColor(
                    workTbl,
                    hiColors[i]);
            }
        }
        transparencyTest =
          -16777216;
        if (cycleMethod ==
              org.apache.batik.ext.awt.MultipleGradientPaint.
                NO_CYCLE) {
            transparencyTest &=
              gradientUnderflow;
            transparencyTest &=
              gradientOverflow;
        }
        gradients =
          (new int[fractions.
                     length -
                     1][]);
        gradientsLength =
          gradients.
            length;
        int n =
          normalizedIntervals.
            length;
        float Imin =
          1;
        float[] workTbl =
          normalizedIntervals;
        for (int i =
               0;
             i <
               n;
             i++) {
            Imin =
              Imin >
                workTbl[i]
                ? workTbl[i]
                : Imin;
        }
        int estimatedSize =
          0;
        if (Imin ==
              0) {
            estimatedSize =
              java.lang.Integer.
                MAX_VALUE;
            hasDiscontinuity =
              true;
        }
        else {
            for (int i =
                   0;
                 i <
                   workTbl.
                     length;
                 i++) {
                estimatedSize +=
                  workTbl[i] /
                    Imin *
                    GRADIENT_SIZE;
            }
        }
        if (estimatedSize >
              MAX_GRADIENT_ARRAY_SIZE) {
            calculateMultipleArrayGradient(
              loColors,
              hiColors);
            if (cycleMethod ==
                  org.apache.batik.ext.awt.MultipleGradientPaint.
                    REPEAT &&
                  gradients[0][0] !=
                  gradients[gradients.
                              length -
                              1][GRADIENT_SIZE_INDEX])
                hasDiscontinuity =
                  true;
        }
        else {
            calculateSingleArrayGradient(
              loColors,
              hiColors,
              Imin);
            if (cycleMethod ==
                  org.apache.batik.ext.awt.MultipleGradientPaint.
                    REPEAT &&
                  gradient[0] !=
                  gradient[fastGradientArraySize])
                hasDiscontinuity =
                  true;
        }
        if (transparencyTest >>>
              24 ==
              255) {
            if (dataModel.
                  getColorSpace(
                    ) ==
                  lrgbmodel_NA.
                  getColorSpace(
                    ))
                dataModel =
                  lrgbmodel_NA;
            else
                if (dataModel.
                      getColorSpace(
                        ) ==
                      srgbmodel_NA.
                      getColorSpace(
                        ))
                    dataModel =
                      srgbmodel_NA;
            model =
              dataModel;
        }
    }
    private static java.awt.Color interpolateColor(int[] workTbl,
                                                   java.awt.Color inColor) {
        int oldColor =
          inColor.
          getRGB(
            );
        int newColorValue =
          (workTbl[oldColor >>
                     24 &
                     255] &
             255) <<
          24 |
          (workTbl[oldColor >>
                     16 &
                     255] &
             255) <<
          16 |
          (workTbl[oldColor >>
                     8 &
                     255] &
             255) <<
          8 |
          workTbl[oldColor &
                    255] &
          255;
        return new java.awt.Color(
          newColorValue,
          true);
    }
    private void calculateSingleArrayGradient(java.awt.Color[] loColors,
                                              java.awt.Color[] hiColors,
                                              float Imin) {
        isSimpleLookup =
          true;
        int gradientsTot =
          1;
        int aveA =
          32768;
        int aveR =
          32768;
        int aveG =
          32768;
        int aveB =
          32768;
        for (int i =
               0;
             i <
               gradients.
                 length;
             i++) {
            int nGradients =
              (int)
                (normalizedIntervals[i] /
                   Imin *
                   255.0F);
            gradientsTot +=
              nGradients;
            gradients[i] =
              (new int[nGradients]);
            int rgb1 =
              loColors[i].
              getRGB(
                );
            int rgb2 =
              hiColors[i].
              getRGB(
                );
            interpolate(
              rgb1,
              rgb2,
              gradients[i]);
            int argb =
              gradients[i][GRADIENT_SIZE /
                             2];
            float norm =
              normalizedIntervals[i];
            aveA +=
              (int)
                ((argb >>
                    8 &
                    16711680) *
                   norm);
            aveR +=
              (int)
                ((argb &
                    16711680) *
                   norm);
            aveG +=
              (int)
                ((argb <<
                    8 &
                    16711680) *
                   norm);
            aveB +=
              (int)
                ((argb <<
                    16 &
                    16711680) *
                   norm);
            transparencyTest &=
              rgb1 &
                rgb2;
        }
        gradientAverage =
          (aveA &
             16711680) <<
            8 |
            aveR &
            16711680 |
            (aveG &
               16711680) >>
            8 |
            (aveB &
               16711680) >>
            16;
        gradient =
          (new int[gradientsTot]);
        int curOffset =
          0;
        for (int i =
               0;
             i <
               gradients.
                 length;
             i++) {
            java.lang.System.
              arraycopy(
                gradients[i],
                0,
                gradient,
                curOffset,
                gradients[i].
                  length);
            curOffset +=
              gradients[i].
                length;
        }
        gradient[gradient.
                   length -
                   1] =
          hiColors[hiColors.
                     length -
                     1].
            getRGB(
              );
        if (colorSpace ==
              org.apache.batik.ext.awt.LinearGradientPaint.
                LINEAR_RGB) {
            if (dataModel.
                  getColorSpace(
                    ) ==
                  java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_sRGB)) {
                for (int i =
                       0;
                     i <
                       gradient.
                         length;
                     i++) {
                    gradient[i] =
                      convertEntireColorLinearRGBtoSRGB(
                        gradient[i]);
                }
                gradientAverage =
                  convertEntireColorLinearRGBtoSRGB(
                    gradientAverage);
            }
        }
        else {
            if (dataModel.
                  getColorSpace(
                    ) ==
                  java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_LINEAR_RGB)) {
                for (int i =
                       0;
                     i <
                       gradient.
                         length;
                     i++) {
                    gradient[i] =
                      convertEntireColorSRGBtoLinearRGB(
                        gradient[i]);
                }
                gradientAverage =
                  convertEntireColorSRGBtoLinearRGB(
                    gradientAverage);
            }
        }
        fastGradientArraySize =
          gradient.
            length -
            1;
    }
    private void calculateMultipleArrayGradient(java.awt.Color[] loColors,
                                                java.awt.Color[] hiColors) {
        isSimpleLookup =
          false;
        int rgb1;
        int rgb2;
        int aveA =
          32768;
        int aveR =
          32768;
        int aveG =
          32768;
        int aveB =
          32768;
        for (int i =
               0;
             i <
               gradients.
                 length;
             i++) {
            if (normalizedIntervals[i] ==
                  0)
                continue;
            gradients[i] =
              (new int[GRADIENT_SIZE]);
            rgb1 =
              loColors[i].
                getRGB(
                  );
            rgb2 =
              hiColors[i].
                getRGB(
                  );
            interpolate(
              rgb1,
              rgb2,
              gradients[i]);
            int argb =
              gradients[i][GRADIENT_SIZE /
                             2];
            float norm =
              normalizedIntervals[i];
            aveA +=
              (int)
                ((argb >>
                    8 &
                    16711680) *
                   norm);
            aveR +=
              (int)
                ((argb &
                    16711680) *
                   norm);
            aveG +=
              (int)
                ((argb <<
                    8 &
                    16711680) *
                   norm);
            aveB +=
              (int)
                ((argb <<
                    16 &
                    16711680) *
                   norm);
            transparencyTest &=
              rgb1;
            transparencyTest &=
              rgb2;
        }
        gradientAverage =
          (aveA &
             16711680) <<
            8 |
            aveR &
            16711680 |
            (aveG &
               16711680) >>
            8 |
            (aveB &
               16711680) >>
            16;
        if (colorSpace ==
              org.apache.batik.ext.awt.LinearGradientPaint.
                LINEAR_RGB) {
            if (dataModel.
                  getColorSpace(
                    ) ==
                  java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_sRGB)) {
                for (int j =
                       0;
                     j <
                       gradients.
                         length;
                     j++) {
                    for (int i =
                           0;
                         i <
                           gradients[j].
                             length;
                         i++) {
                        gradients[j][i] =
                          convertEntireColorLinearRGBtoSRGB(
                            gradients[j][i]);
                    }
                }
                gradientAverage =
                  convertEntireColorLinearRGBtoSRGB(
                    gradientAverage);
            }
        }
        else {
            if (dataModel.
                  getColorSpace(
                    ) ==
                  java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_LINEAR_RGB)) {
                for (int j =
                       0;
                     j <
                       gradients.
                         length;
                     j++) {
                    for (int i =
                           0;
                         i <
                           gradients[j].
                             length;
                         i++) {
                        gradients[j][i] =
                          convertEntireColorSRGBtoLinearRGB(
                            gradients[j][i]);
                    }
                }
                gradientAverage =
                  convertEntireColorSRGBtoLinearRGB(
                    gradientAverage);
            }
        }
    }
    private void interpolate(int rgb1, int rgb2,
                             int[] output) {
        int nSteps =
          output.
            length;
        float stepSize =
          1 /
          (float)
            nSteps;
        int a1 =
          rgb1 >>
          24 &
          255;
        int r1 =
          rgb1 >>
          16 &
          255;
        int g1 =
          rgb1 >>
          8 &
          255;
        int b1 =
          rgb1 &
          255;
        int da =
          (rgb2 >>
             24 &
             255) -
          a1;
        int dr =
          (rgb2 >>
             16 &
             255) -
          r1;
        int dg =
          (rgb2 >>
             8 &
             255) -
          g1;
        int db =
          (rgb2 &
             255) -
          b1;
        float tempA =
          2.0F *
          da *
          stepSize;
        float tempR =
          2.0F *
          dr *
          stepSize;
        float tempG =
          2.0F *
          dg *
          stepSize;
        float tempB =
          2.0F *
          db *
          stepSize;
        output[0] =
          rgb1;
        nSteps--;
        output[nSteps] =
          rgb2;
        for (int i =
               1;
             i <
               nSteps;
             i++) {
            float fI =
              i;
            output[i] =
              (a1 +
                 ((int)
                    (fI *
                       tempA) +
                    1 >>
                    1) &
                 255) <<
                24 |
                (r1 +
                   ((int)
                      (fI *
                         tempR) +
                      1 >>
                      1) &
                   255) <<
                16 |
                (g1 +
                   ((int)
                      (fI *
                         tempG) +
                      1 >>
                      1) &
                   255) <<
                8 |
                b1 +
                ((int)
                   (fI *
                      tempB) +
                   1 >>
                   1) &
                255;
        }
    }
    private static int convertEntireColorLinearRGBtoSRGB(int rgb) {
        int a1 =
          rgb >>
          24 &
          255;
        int r1 =
          rgb >>
          16 &
          255;
        int g1 =
          rgb >>
          8 &
          255;
        int b1 =
          rgb &
          255;
        int[] workTbl =
          LinearRGBtoSRGB;
        r1 =
          workTbl[r1];
        g1 =
          workTbl[g1];
        b1 =
          workTbl[b1];
        return a1 <<
          24 |
          r1 <<
          16 |
          g1 <<
          8 |
          b1;
    }
    private static int convertEntireColorSRGBtoLinearRGB(int rgb) {
        int a1 =
          rgb >>
          24 &
          255;
        int r1 =
          rgb >>
          16 &
          255;
        int g1 =
          rgb >>
          8 &
          255;
        int b1 =
          rgb &
          255;
        int[] workTbl =
          SRGBtoLinearRGB;
        r1 =
          workTbl[r1];
        g1 =
          workTbl[g1];
        b1 =
          workTbl[b1];
        return a1 <<
          24 |
          r1 <<
          16 |
          g1 <<
          8 |
          b1;
    }
    protected final int indexIntoGradientsArrays(float position) {
        if (cycleMethod ==
              org.apache.batik.ext.awt.MultipleGradientPaint.
                NO_CYCLE) {
            if (position >=
                  1) {
                return gradientOverflow;
            }
            else
                if (position <=
                      0) {
                    return gradientUnderflow;
                }
        }
        else
            if (cycleMethod ==
                  org.apache.batik.ext.awt.MultipleGradientPaint.
                    REPEAT) {
                position =
                  position -
                    (int)
                      position;
                if (position <
                      0) {
                    position =
                      position +
                        1;
                }
                int w =
                  0;
                int c1 =
                  0;
                int c2 =
                  0;
                if (isSimpleLookup) {
                    position *=
                      gradient.
                        length;
                    int idx1 =
                      (int)
                        position;
                    if (idx1 +
                          1 <
                          gradient.
                            length)
                        return gradient[idx1];
                    w =
                      (int)
                        ((position -
                            idx1) *
                           (1 <<
                              16));
                    c1 =
                      gradient[idx1];
                    c2 =
                      gradient[0];
                }
                else {
                    for (int i =
                           0;
                         i <
                           gradientsLength;
                         i++) {
                        if (position <
                              fractions[i +
                                          1]) {
                            float delta =
                              position -
                              fractions[i];
                            delta =
                              delta /
                                normalizedIntervals[i] *
                                GRADIENT_SIZE;
                            int index =
                              (int)
                                delta;
                            if (index +
                                  1 <
                                  gradients[i].
                                    length ||
                                  i +
                                  1 <
                                  gradientsLength)
                                return gradients[i][index];
                            w =
                              (int)
                                ((delta -
                                    index) *
                                   (1 <<
                                      16));
                            c1 =
                              gradients[i][index];
                            c2 =
                              gradients[0][0];
                            break;
                        }
                    }
                }
                return ((c1 >>
                           8 &
                           16711680) +
                          ((c2 >>>
                              24) -
                             (c1 >>>
                                24)) *
                          w &
                          16711680) <<
                  8 |
                  (c1 &
                     16711680) +
                  ((c2 >>
                      16 &
                      255) -
                     (c1 >>
                        16 &
                        255)) *
                  w &
                  16711680 |
                  ((c1 <<
                      8 &
                      16711680) +
                     ((c2 >>
                         8 &
                         255) -
                        (c1 >>
                           8 &
                           255)) *
                     w &
                     16711680) >>
                  8 |
                  ((c1 <<
                      16 &
                      16711680) +
                     ((c2 &
                         255) -
                        (c1 &
                           255)) *
                     w &
                     16711680) >>
                  16;
            }
            else {
                if (position <
                      0) {
                    position =
                      -position;
                }
                int part =
                  (int)
                    position;
                position =
                  position -
                    part;
                if ((part &
                       1) ==
                      1) {
                    position =
                      1 -
                        position;
                }
            }
        if (isSimpleLookup) {
            return gradient[(int)
                              (position *
                                 fastGradientArraySize)];
        }
        else {
            for (int i =
                   0;
                 i <
                   gradientsLength;
                 i++) {
                if (position <
                      fractions[i +
                                  1]) {
                    float delta =
                      position -
                      fractions[i];
                    int index =
                      (int)
                        (delta /
                           normalizedIntervals[i] *
                           GRADIENT_SIZE_INDEX);
                    return gradients[i][index];
                }
            }
        }
        return gradientOverflow;
    }
    protected final int indexGradientAntiAlias(float position,
                                               float sz) {
        if (cycleMethod ==
              org.apache.batik.ext.awt.MultipleGradientPaint.
                NO_CYCLE) {
            if (DEBUG)
                java.lang.System.
                  out.
                  println(
                    "NO_CYCLE");
            float p1 =
              position -
              sz /
              2;
            float p2 =
              position +
              sz /
              2;
            if (p1 >=
                  1)
                return gradientOverflow;
            if (p2 <=
                  0)
                return gradientUnderflow;
            int interior;
            float top_weight =
              0;
            float bottom_weight =
              0;
            float frac;
            if (p2 >=
                  1) {
                top_weight =
                  (p2 -
                     1) /
                    sz;
                if (p1 <=
                      0) {
                    bottom_weight =
                      -p1 /
                        sz;
                    frac =
                      1;
                    interior =
                      gradientAverage;
                }
                else {
                    frac =
                      1 -
                        p1;
                    interior =
                      getAntiAlias(
                        p1,
                        true,
                        1,
                        false,
                        1 -
                          p1,
                        1);
                }
            }
            else
                if (p1 <=
                      0) {
                    bottom_weight =
                      -p1 /
                        sz;
                    frac =
                      p2;
                    interior =
                      getAntiAlias(
                        0,
                        true,
                        p2,
                        false,
                        p2,
                        1);
                }
                else
                    return getAntiAlias(
                             p1,
                             true,
                             p2,
                             false,
                             sz,
                             1);
            int norm =
              (int)
                ((1 <<
                    16) *
                   frac /
                   sz);
            int pA =
              (interior >>>
                 20 &
                 4080) *
              norm >>
              16;
            int pR =
              (interior >>
                 12 &
                 4080) *
              norm >>
              16;
            int pG =
              (interior >>
                 4 &
                 4080) *
              norm >>
              16;
            int pB =
              (interior <<
                 4 &
                 4080) *
              norm >>
              16;
            if (bottom_weight !=
                  0) {
                int bPix =
                  gradientUnderflow;
                norm =
                  (int)
                    ((1 <<
                        16) *
                       bottom_weight);
                pA +=
                  (bPix >>>
                     20 &
                     4080) *
                    norm >>
                    16;
                pR +=
                  (bPix >>
                     12 &
                     4080) *
                    norm >>
                    16;
                pG +=
                  (bPix >>
                     4 &
                     4080) *
                    norm >>
                    16;
                pB +=
                  (bPix <<
                     4 &
                     4080) *
                    norm >>
                    16;
            }
            if (top_weight !=
                  0) {
                int tPix =
                  gradientOverflow;
                norm =
                  (int)
                    ((1 <<
                        16) *
                       top_weight);
                pA +=
                  (tPix >>>
                     20 &
                     4080) *
                    norm >>
                    16;
                pR +=
                  (tPix >>
                     12 &
                     4080) *
                    norm >>
                    16;
                pG +=
                  (tPix >>
                     4 &
                     4080) *
                    norm >>
                    16;
                pB +=
                  (tPix <<
                     4 &
                     4080) *
                    norm >>
                    16;
            }
            return (pA &
                      4080) <<
              20 |
              (pR &
                 4080) <<
              12 |
              (pG &
                 4080) <<
              4 |
              (pB &
                 4080) >>
              4;
        }
        int intSz =
          (int)
            sz;
        float weight =
          1.0F;
        if (intSz !=
              0) {
            sz -=
              intSz;
            weight =
              sz /
                (intSz +
                   sz);
            if (weight <
                  0.1)
                return gradientAverage;
        }
        if (sz >
              0.99)
            return gradientAverage;
        float p1 =
          position -
          sz /
          2;
        float p2 =
          position +
          sz /
          2;
        if (DEBUG)
            java.lang.System.
              out.
              println(
                "P1: " +
                p1 +
                " P2: " +
                p2);
        boolean p1_up =
          true;
        boolean p2_up =
          false;
        if (cycleMethod ==
              org.apache.batik.ext.awt.MultipleGradientPaint.
                REPEAT) {
            if (DEBUG)
                java.lang.System.
                  out.
                  println(
                    "REPEAT");
            p1 =
              p1 -
                (int)
                  p1;
            p2 =
              p2 -
                (int)
                  p2;
            if (p1 <
                  0)
                p1 +=
                  1;
            if (p2 <
                  0)
                p2 +=
                  1;
        }
        else {
            if (DEBUG)
                java.lang.System.
                  out.
                  println(
                    "REFLECT");
            if (p2 <
                  0) {
                p1 =
                  -p1;
                p1_up =
                  !p1_up;
                p2 =
                  -p2;
                p2_up =
                  !p2_up;
            }
            else
                if (p1 <
                      0) {
                    p1 =
                      -p1;
                    p1_up =
                      !p1_up;
                }
            int part1;
            int part2;
            part1 =
              (int)
                p1;
            p1 =
              p1 -
                part1;
            part2 =
              (int)
                p2;
            p2 =
              p2 -
                part2;
            if ((part1 &
                   1) ==
                  1) {
                p1 =
                  1 -
                    p1;
                p1_up =
                  !p1_up;
            }
            if ((part2 &
                   1) ==
                  1) {
                p2 =
                  1 -
                    p2;
                p2_up =
                  !p2_up;
            }
            if (p1 >
                  p2 &&
                  !p1_up &&
                  p2_up) {
                float t =
                  p1;
                p1 =
                  p2;
                p2 =
                  t;
                p1_up =
                  true;
                p2_up =
                  false;
            }
        }
        return getAntiAlias(
                 p1,
                 p1_up,
                 p2,
                 p2_up,
                 sz,
                 weight);
    }
    private final int getAntiAlias(float p1,
                                   boolean p1_up,
                                   float p2,
                                   boolean p2_up,
                                   float sz,
                                   float weight) {
        int ach =
          0;
        int rch =
          0;
        int gch =
          0;
        int bch =
          0;
        if (isSimpleLookup) {
            p1 *=
              fastGradientArraySize;
            p2 *=
              fastGradientArraySize;
            int idx1 =
              (int)
                p1;
            int idx2 =
              (int)
                p2;
            int i;
            int pix;
            if (p1_up &&
                  !p2_up &&
                  idx1 <=
                  idx2) {
                if (idx1 ==
                      idx2)
                    return gradient[idx1];
                for (i =
                       idx1 +
                         1;
                     i <
                       idx2;
                     i++) {
                    pix =
                      gradient[i];
                    ach +=
                      pix >>>
                        20 &
                        4080;
                    rch +=
                      pix >>>
                        12 &
                        4080;
                    gch +=
                      pix >>>
                        4 &
                        4080;
                    bch +=
                      pix <<
                        4 &
                        4080;
                }
            }
            else {
                int iStart;
                int iEnd;
                if (p1_up) {
                    iStart =
                      idx1 +
                        1;
                    iEnd =
                      fastGradientArraySize;
                }
                else {
                    iStart =
                      0;
                    iEnd =
                      idx1;
                }
                for (i =
                       iStart;
                     i <
                       iEnd;
                     i++) {
                    pix =
                      gradient[i];
                    ach +=
                      pix >>>
                        20 &
                        4080;
                    rch +=
                      pix >>>
                        12 &
                        4080;
                    gch +=
                      pix >>>
                        4 &
                        4080;
                    bch +=
                      pix <<
                        4 &
                        4080;
                }
                if (p2_up) {
                    iStart =
                      idx2 +
                        1;
                    iEnd =
                      fastGradientArraySize;
                }
                else {
                    iStart =
                      0;
                    iEnd =
                      idx2;
                }
                for (i =
                       iStart;
                     i <
                       iEnd;
                     i++) {
                    pix =
                      gradient[i];
                    ach +=
                      pix >>>
                        20 &
                        4080;
                    rch +=
                      pix >>>
                        12 &
                        4080;
                    gch +=
                      pix >>>
                        4 &
                        4080;
                    bch +=
                      pix <<
                        4 &
                        4080;
                }
            }
            int norm;
            int isz;
            isz =
              (int)
                ((1 <<
                    16) /
                   (sz *
                      fastGradientArraySize));
            ach =
              ach *
                isz >>
                16;
            rch =
              rch *
                isz >>
                16;
            gch =
              gch *
                isz >>
                16;
            bch =
              bch *
                isz >>
                16;
            if (p1_up)
                norm =
                  (int)
                    ((1 -
                        (p1 -
                           idx1)) *
                       isz);
            else
                norm =
                  (int)
                    ((p1 -
                        idx1) *
                       isz);
            pix =
              gradient[idx1];
            ach +=
              (pix >>>
                 20 &
                 4080) *
                norm >>
                16;
            rch +=
              (pix >>>
                 12 &
                 4080) *
                norm >>
                16;
            gch +=
              (pix >>>
                 4 &
                 4080) *
                norm >>
                16;
            bch +=
              (pix <<
                 4 &
                 4080) *
                norm >>
                16;
            if (p2_up)
                norm =
                  (int)
                    ((1 -
                        (p2 -
                           idx2)) *
                       isz);
            else
                norm =
                  (int)
                    ((p2 -
                        idx2) *
                       isz);
            pix =
              gradient[idx2];
            ach +=
              (pix >>>
                 20 &
                 4080) *
                norm >>
                16;
            rch +=
              (pix >>>
                 12 &
                 4080) *
                norm >>
                16;
            gch +=
              (pix >>>
                 4 &
                 4080) *
                norm >>
                16;
            bch +=
              (pix <<
                 4 &
                 4080) *
                norm >>
                16;
            ach =
              ach +
                8 >>
                4;
            rch =
              rch +
                8 >>
                4;
            gch =
              gch +
                8 >>
                4;
            bch =
              bch +
                8 >>
                4;
        }
        else {
            int idx1 =
              0;
            int idx2 =
              0;
            int i1 =
              -1;
            int i2 =
              -1;
            float f1 =
              0;
            float f2 =
              0;
            for (int i =
                   0;
                 i <
                   gradientsLength;
                 i++) {
                if (p1 <
                      fractions[i +
                                  1] &&
                      i1 ==
                      -1) {
                    i1 =
                      i;
                    f1 =
                      p1 -
                        fractions[i];
                    f1 =
                      f1 /
                        normalizedIntervals[i] *
                        GRADIENT_SIZE_INDEX;
                    idx1 =
                      (int)
                        f1;
                    if (i2 !=
                          -1)
                        break;
                }
                if (p2 <
                      fractions[i +
                                  1] &&
                      i2 ==
                      -1) {
                    i2 =
                      i;
                    f2 =
                      p2 -
                        fractions[i];
                    f2 =
                      f2 /
                        normalizedIntervals[i] *
                        GRADIENT_SIZE_INDEX;
                    idx2 =
                      (int)
                        f2;
                    if (i1 !=
                          -1)
                        break;
                }
            }
            if (i1 ==
                  -1) {
                i1 =
                  gradients.
                    length -
                    1;
                f1 =
                  (idx1 =
                     GRADIENT_SIZE_INDEX);
            }
            if (i2 ==
                  -1) {
                i2 =
                  gradients.
                    length -
                    1;
                f2 =
                  (idx2 =
                     GRADIENT_SIZE_INDEX);
            }
            if (DEBUG)
                java.lang.System.
                  out.
                  println(
                    "I1: " +
                    i1 +
                    " Idx1: " +
                    idx1 +
                    " I2: " +
                    i2 +
                    " Idx2: " +
                    idx2);
            if (i1 ==
                  i2 &&
                  idx1 <=
                  idx2 &&
                  p1_up &&
                  !p2_up)
                return gradients[i1][idx1 +
                                       idx2 +
                                       1 >>
                                       1];
            int pix;
            int norm;
            int base =
              (int)
                ((1 <<
                    16) /
                   sz);
            if (i1 <
                  i2 &&
                  p1_up &&
                  !p2_up) {
                norm =
                  (int)
                    (base *
                       normalizedIntervals[i1] *
                       (GRADIENT_SIZE_INDEX -
                          f1) /
                       GRADIENT_SIZE_INDEX);
                pix =
                  gradients[i1][idx1 +
                                  GRADIENT_SIZE >>
                                  1];
                ach +=
                  (pix >>>
                     20 &
                     4080) *
                    norm >>
                    16;
                rch +=
                  (pix >>>
                     12 &
                     4080) *
                    norm >>
                    16;
                gch +=
                  (pix >>>
                     4 &
                     4080) *
                    norm >>
                    16;
                bch +=
                  (pix <<
                     4 &
                     4080) *
                    norm >>
                    16;
                for (int i =
                       i1 +
                       1;
                     i <
                       i2;
                     i++) {
                    norm =
                      (int)
                        (base *
                           normalizedIntervals[i]);
                    pix =
                      gradients[i][GRADIENT_SIZE >>
                                     1];
                    ach +=
                      (pix >>>
                         20 &
                         4080) *
                        norm >>
                        16;
                    rch +=
                      (pix >>>
                         12 &
                         4080) *
                        norm >>
                        16;
                    gch +=
                      (pix >>>
                         4 &
                         4080) *
                        norm >>
                        16;
                    bch +=
                      (pix <<
                         4 &
                         4080) *
                        norm >>
                        16;
                }
                norm =
                  (int)
                    (base *
                       normalizedIntervals[i2] *
                       f2 /
                       GRADIENT_SIZE_INDEX);
                pix =
                  gradients[i2][idx2 +
                                  1 >>
                                  1];
                ach +=
                  (pix >>>
                     20 &
                     4080) *
                    norm >>
                    16;
                rch +=
                  (pix >>>
                     12 &
                     4080) *
                    norm >>
                    16;
                gch +=
                  (pix >>>
                     4 &
                     4080) *
                    norm >>
                    16;
                bch +=
                  (pix <<
                     4 &
                     4080) *
                    norm >>
                    16;
            }
            else {
                if (p1_up) {
                    norm =
                      (int)
                        (base *
                           normalizedIntervals[i1] *
                           (GRADIENT_SIZE_INDEX -
                              f1) /
                           GRADIENT_SIZE_INDEX);
                    pix =
                      gradients[i1][idx1 +
                                      GRADIENT_SIZE >>
                                      1];
                }
                else {
                    norm =
                      (int)
                        (base *
                           normalizedIntervals[i1] *
                           f1 /
                           GRADIENT_SIZE_INDEX);
                    pix =
                      gradients[i1][idx1 +
                                      1 >>
                                      1];
                }
                ach +=
                  (pix >>>
                     20 &
                     4080) *
                    norm >>
                    16;
                rch +=
                  (pix >>>
                     12 &
                     4080) *
                    norm >>
                    16;
                gch +=
                  (pix >>>
                     4 &
                     4080) *
                    norm >>
                    16;
                bch +=
                  (pix <<
                     4 &
                     4080) *
                    norm >>
                    16;
                if (p2_up) {
                    norm =
                      (int)
                        (base *
                           normalizedIntervals[i2] *
                           (GRADIENT_SIZE_INDEX -
                              f2) /
                           GRADIENT_SIZE_INDEX);
                    pix =
                      gradients[i2][idx2 +
                                      GRADIENT_SIZE >>
                                      1];
                }
                else {
                    norm =
                      (int)
                        (base *
                           normalizedIntervals[i2] *
                           f2 /
                           GRADIENT_SIZE_INDEX);
                    pix =
                      gradients[i2][idx2 +
                                      1 >>
                                      1];
                }
                ach +=
                  (pix >>>
                     20 &
                     4080) *
                    norm >>
                    16;
                rch +=
                  (pix >>>
                     12 &
                     4080) *
                    norm >>
                    16;
                gch +=
                  (pix >>>
                     4 &
                     4080) *
                    norm >>
                    16;
                bch +=
                  (pix <<
                     4 &
                     4080) *
                    norm >>
                    16;
                int iStart;
                int iEnd;
                if (p1_up) {
                    iStart =
                      i1 +
                        1;
                    iEnd =
                      gradientsLength;
                }
                else {
                    iStart =
                      0;
                    iEnd =
                      i1;
                }
                for (int i =
                       iStart;
                     i <
                       iEnd;
                     i++) {
                    norm =
                      (int)
                        (base *
                           normalizedIntervals[i]);
                    pix =
                      gradients[i][GRADIENT_SIZE >>
                                     1];
                    ach +=
                      (pix >>>
                         20 &
                         4080) *
                        norm >>
                        16;
                    rch +=
                      (pix >>>
                         12 &
                         4080) *
                        norm >>
                        16;
                    gch +=
                      (pix >>>
                         4 &
                         4080) *
                        norm >>
                        16;
                    bch +=
                      (pix <<
                         4 &
                         4080) *
                        norm >>
                        16;
                }
                if (p2_up) {
                    iStart =
                      i2 +
                        1;
                    iEnd =
                      gradientsLength;
                }
                else {
                    iStart =
                      0;
                    iEnd =
                      i2;
                }
                for (int i =
                       iStart;
                     i <
                       iEnd;
                     i++) {
                    norm =
                      (int)
                        (base *
                           normalizedIntervals[i]);
                    pix =
                      gradients[i][GRADIENT_SIZE >>
                                     1];
                    ach +=
                      (pix >>>
                         20 &
                         4080) *
                        norm >>
                        16;
                    rch +=
                      (pix >>>
                         12 &
                         4080) *
                        norm >>
                        16;
                    gch +=
                      (pix >>>
                         4 &
                         4080) *
                        norm >>
                        16;
                    bch +=
                      (pix <<
                         4 &
                         4080) *
                        norm >>
                        16;
                }
            }
            ach =
              ach +
                8 >>
                4;
            rch =
              rch +
                8 >>
                4;
            gch =
              gch +
                8 >>
                4;
            bch =
              bch +
                8 >>
                4;
            if (DEBUG)
                java.lang.System.
                  out.
                  println(
                    "Pix: [" +
                    ach +
                    ", " +
                    rch +
                    ", " +
                    gch +
                    ", " +
                    bch +
                    ']');
        }
        if (weight !=
              1) {
            int aveW =
              (int)
                ((1 <<
                    16) *
                   (1 -
                      weight));
            int aveA =
              (gradientAverage >>>
                 24 &
                 255) *
              aveW;
            int aveR =
              (gradientAverage >>
                 16 &
                 255) *
              aveW;
            int aveG =
              (gradientAverage >>
                 8 &
                 255) *
              aveW;
            int aveB =
              (gradientAverage &
                 255) *
              aveW;
            int iw =
              (int)
                (weight *
                   (1 <<
                      16));
            ach =
              ach *
                iw +
                aveA >>
                16;
            rch =
              rch *
                iw +
                aveR >>
                16;
            gch =
              gch *
                iw +
                aveG >>
                16;
            bch =
              bch *
                iw +
                aveB >>
                16;
        }
        return ach <<
          24 |
          rch <<
          16 |
          gch <<
          8 |
          bch;
    }
    private static int convertSRGBtoLinearRGB(int color) {
        float output;
        float input =
          color /
          255.0F;
        if (input <=
              0.04045F) {
            output =
              input /
                12.92F;
        }
        else {
            output =
              (float)
                java.lang.Math.
                pow(
                  (input +
                     0.055) /
                    1.055,
                  2.4);
        }
        int o =
          java.lang.Math.
          round(
            output *
              255.0F);
        return o;
    }
    private static int convertLinearRGBtoSRGB(int color) {
        float output;
        float input =
          color /
          255.0F;
        if (input <=
              0.0031308F) {
            output =
              input *
                12.92F;
        }
        else {
            output =
              1.055F *
                (float)
                  java.lang.Math.
                  pow(
                    input,
                    1.0 /
                      2.4) -
                0.055F;
        }
        int o =
          java.lang.Math.
          round(
            output *
              255.0F);
        return o;
    }
    public final java.awt.image.Raster getRaster(int x,
                                                 int y,
                                                 int w,
                                                 int h) {
        if (w ==
              0 ||
              h ==
              0) {
            return null;
        }
        java.awt.image.WritableRaster raster =
          saved;
        if (raster ==
              null ||
              raster.
              getWidth(
                ) <
              w ||
              raster.
              getHeight(
                ) <
              h) {
            raster =
              getCachedRaster(
                dataModel,
                w,
                h);
            saved =
              raster;
            raster =
              raster.
                createWritableChild(
                  raster.
                    getMinX(
                      ),
                  raster.
                    getMinY(
                      ),
                  w,
                  h,
                  0,
                  0,
                  null);
        }
        java.awt.image.DataBufferInt rasterDB =
          (java.awt.image.DataBufferInt)
            raster.
            getDataBuffer(
              );
        int[] pixels =
          rasterDB.
          getBankData(
            )[0];
        int off =
          rasterDB.
          getOffset(
            );
        int scanlineStride =
          ((java.awt.image.SinglePixelPackedSampleModel)
             raster.
             getSampleModel(
               )).
          getScanlineStride(
            );
        int adjust =
          scanlineStride -
          w;
        fillRaster(
          pixels,
          off,
          adjust,
          x,
          y,
          w,
          h);
        org.apache.batik.ext.awt.image.GraphicsUtil.
          coerceData(
            raster,
            dataModel,
            model.
              isAlphaPremultiplied(
                ));
        return raster;
    }
    protected abstract void fillRaster(int[] pixels,
                                       int off,
                                       int adjust,
                                       int x,
                                       int y,
                                       int w,
                                       int h);
    protected static final synchronized java.awt.image.WritableRaster getCachedRaster(java.awt.image.ColorModel cm,
                                                                                      int w,
                                                                                      int h) {
        if (cm ==
              cachedModel) {
            if (cached !=
                  null) {
                java.awt.image.WritableRaster ras =
                  (java.awt.image.WritableRaster)
                    cached.
                    get(
                      );
                if (ras !=
                      null &&
                      ras.
                      getWidth(
                        ) >=
                      w &&
                      ras.
                      getHeight(
                        ) >=
                      h) {
                    cached =
                      null;
                    return ras;
                }
            }
        }
        if (w <
              32)
            w =
              32;
        if (h <
              32)
            h =
              32;
        return cm.
          createCompatibleWritableRaster(
            w,
            h);
    }
    protected static final synchronized void putCachedRaster(java.awt.image.ColorModel cm,
                                                             java.awt.image.WritableRaster ras) {
        if (cached !=
              null) {
            java.awt.image.WritableRaster cras =
              (java.awt.image.WritableRaster)
                cached.
                get(
                  );
            if (cras !=
                  null) {
                int cw =
                  cras.
                  getWidth(
                    );
                int ch =
                  cras.
                  getHeight(
                    );
                int iw =
                  ras.
                  getWidth(
                    );
                int ih =
                  ras.
                  getHeight(
                    );
                if (cw >=
                      iw &&
                      ch >=
                      ih) {
                    return;
                }
                if (cw *
                      ch >=
                      iw *
                      ih) {
                    return;
                }
            }
        }
        cachedModel =
          cm;
        cached =
          new java.lang.ref.WeakReference(
            ras);
    }
    public final void dispose() { if (saved !=
                                        null) {
                                      putCachedRaster(
                                        model,
                                        saved);
                                      saved =
                                        null;
                                  } }
    public final java.awt.image.ColorModel getColorModel() {
        return model;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "R4kpMqzZcGB1U8KhIO5KDhQtgc+9rCWh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "YAAA");
}
