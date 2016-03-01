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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qTcNAGtio5aE1qZiLqdIO2oMla5Sq04S");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Z+XiNWEAAA==");
}
