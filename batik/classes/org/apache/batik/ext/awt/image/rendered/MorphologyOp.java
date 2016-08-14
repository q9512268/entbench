package org.apache.batik.ext.awt.image.rendered;
public class MorphologyOp implements java.awt.image.BufferedImageOp, java.awt.image.RasterOp {
    private int radiusX;
    private int radiusY;
    private boolean doDilation;
    private final int rangeX;
    private final int rangeY;
    private final java.awt.color.ColorSpace sRGB = java.awt.color.ColorSpace.
      getInstance(
        java.awt.color.ColorSpace.
          CS_sRGB);
    private final java.awt.color.ColorSpace lRGB = java.awt.color.ColorSpace.
      getInstance(
        java.awt.color.ColorSpace.
          CS_LINEAR_RGB);
    public MorphologyOp(int radiusX, int radiusY, boolean doDilation) { super(
                                                                          );
                                                                        if (radiusX <=
                                                                              0 ||
                                                                              radiusY <=
                                                                              0) {
                                                                            throw new java.lang.IllegalArgumentException(
                                                                              ("The radius of X-axis or Y-axis should not be Zero or Negativ" +
                                                                               "es."));
                                                                        }
                                                                        else {
                                                                            this.
                                                                              radiusX =
                                                                              radiusX;
                                                                            this.
                                                                              radiusY =
                                                                              radiusY;
                                                                            this.
                                                                              doDilation =
                                                                              doDilation;
                                                                            rangeX =
                                                                              2 *
                                                                                radiusX +
                                                                                1;
                                                                            rangeY =
                                                                              2 *
                                                                                radiusY +
                                                                                1;
                                                                        }
    }
    public java.awt.geom.Rectangle2D getBounds2D(java.awt.image.Raster src) {
        checkCompatible(
          src.
            getSampleModel(
              ));
        return new java.awt.Rectangle(
          src.
            getMinX(
              ),
          src.
            getMinY(
              ),
          src.
            getWidth(
              ),
          src.
            getHeight(
              ));
    }
    public java.awt.geom.Rectangle2D getBounds2D(java.awt.image.BufferedImage src) {
        return new java.awt.Rectangle(
          0,
          0,
          src.
            getWidth(
              ),
          src.
            getHeight(
              ));
    }
    public java.awt.geom.Point2D getPoint2D(java.awt.geom.Point2D srcPt,
                                            java.awt.geom.Point2D destPt) {
        if (destPt ==
              null)
            destPt =
              new java.awt.geom.Point2D.Float(
                );
        destPt.
          setLocation(
            srcPt.
              getX(
                ),
            srcPt.
              getY(
                ));
        return destPt;
    }
    private void checkCompatible(java.awt.image.ColorModel colorModel,
                                 java.awt.image.SampleModel sampleModel) {
        java.awt.color.ColorSpace cs =
          colorModel.
          getColorSpace(
            );
        if (!cs.
              equals(
                sRGB) &&
              !cs.
              equals(
                lRGB))
            throw new java.lang.IllegalArgumentException(
              "Expected CS_sRGB or CS_LINEAR_RGB color model");
        if (!(colorModel instanceof java.awt.image.DirectColorModel))
            throw new java.lang.IllegalArgumentException(
              "colorModel should be an instance of DirectColorModel");
        if (sampleModel.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_INT)
            throw new java.lang.IllegalArgumentException(
              "colorModel\'s transferType should be DataBuffer.TYPE_INT");
        java.awt.image.DirectColorModel dcm =
          (java.awt.image.DirectColorModel)
            colorModel;
        if (dcm.
              getRedMask(
                ) !=
              16711680)
            throw new java.lang.IllegalArgumentException(
              "red mask in source should be 0x00ff0000");
        if (dcm.
              getGreenMask(
                ) !=
              65280)
            throw new java.lang.IllegalArgumentException(
              "green mask in source should be 0x0000ff00");
        if (dcm.
              getBlueMask(
                ) !=
              255)
            throw new java.lang.IllegalArgumentException(
              "blue mask in source should be 0x000000ff");
        if (dcm.
              getAlphaMask(
                ) !=
              -16777216)
            throw new java.lang.IllegalArgumentException(
              "alpha mask in source should be 0xff000000");
    }
    private boolean isCompatible(java.awt.image.ColorModel colorModel,
                                 java.awt.image.SampleModel sampleModel) {
        java.awt.color.ColorSpace cs =
          colorModel.
          getColorSpace(
            );
        if (cs !=
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_sRGB) &&
              cs !=
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_LINEAR_RGB))
            return false;
        if (!(colorModel instanceof java.awt.image.DirectColorModel))
            return false;
        if (sampleModel.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_INT)
            return false;
        java.awt.image.DirectColorModel dcm =
          (java.awt.image.DirectColorModel)
            colorModel;
        if (dcm.
              getRedMask(
                ) !=
              16711680)
            return false;
        if (dcm.
              getGreenMask(
                ) !=
              65280)
            return false;
        if (dcm.
              getBlueMask(
                ) !=
              255)
            return false;
        if (dcm.
              getAlphaMask(
                ) !=
              -16777216)
            return false;
        return true;
    }
    private void checkCompatible(java.awt.image.SampleModel model) {
        if (!(model instanceof java.awt.image.SinglePixelPackedSampleModel))
            throw new java.lang.IllegalArgumentException(
              "MorphologyOp only works with Rasters " +
              "using SinglePixelPackedSampleModels");
        int nBands =
          model.
          getNumBands(
            );
        if (nBands !=
              4)
            throw new java.lang.IllegalArgumentException(
              "MorphologyOp only words with Rasters having 4 bands");
        if (model.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_INT)
            throw new java.lang.IllegalArgumentException(
              "MorphologyOp only works with Rasters using DataBufferInt");
        int[] bitOffsets =
          ((java.awt.image.SinglePixelPackedSampleModel)
             model).
          getBitOffsets(
            );
        for (int i =
               0;
             i <
               bitOffsets.
                 length;
             i++) {
            if (bitOffsets[i] %
                  8 !=
                  0)
                throw new java.lang.IllegalArgumentException(
                  "MorphologyOp only works with Rasters using 8 bits " +
                  "per band : " +
                  i +
                  " : " +
                  bitOffsets[i]);
        }
    }
    public java.awt.RenderingHints getRenderingHints() {
        return null;
    }
    public java.awt.image.WritableRaster createCompatibleDestRaster(java.awt.image.Raster src) {
        checkCompatible(
          src.
            getSampleModel(
              ));
        return src.
          createCompatibleWritableRaster(
            );
    }
    public java.awt.image.BufferedImage createCompatibleDestImage(java.awt.image.BufferedImage src,
                                                                  java.awt.image.ColorModel destCM) {
        java.awt.image.BufferedImage dest =
          null;
        if (destCM ==
              null)
            destCM =
              src.
                getColorModel(
                  );
        java.awt.image.WritableRaster wr;
        wr =
          destCM.
            createCompatibleWritableRaster(
              src.
                getWidth(
                  ),
              src.
                getHeight(
                  ));
        checkCompatible(
          destCM,
          wr.
            getSampleModel(
              ));
        dest =
          new java.awt.image.BufferedImage(
            destCM,
            wr,
            destCM.
              isAlphaPremultiplied(
                ),
            null);
        return dest;
    }
    static final boolean isBetter(final int v1,
                                  final int v2,
                                  final boolean doDilation) {
        if (v1 >
              v2)
            return doDilation;
        if (v1 <
              v2)
            return !doDilation;
        return true;
    }
    private void specialProcessRow(java.awt.image.Raster src,
                                   java.awt.image.WritableRaster dest) {
        final int w =
          src.
          getWidth(
            );
        final int h =
          src.
          getHeight(
            );
        java.awt.image.DataBufferInt srcDB =
          (java.awt.image.DataBufferInt)
            src.
            getDataBuffer(
              );
        java.awt.image.DataBufferInt dstDB =
          (java.awt.image.DataBufferInt)
            dest.
            getDataBuffer(
              );
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            src.
            getSampleModel(
              );
        final int srcOff =
          srcDB.
          getOffset(
            ) +
          sppsm.
          getOffset(
            src.
              getMinX(
                ) -
              src.
              getSampleModelTranslateX(
                ),
            src.
              getMinY(
                ) -
              src.
              getSampleModelTranslateY(
                ));
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            dest.
            getSampleModel(
              );
        final int dstOff =
          dstDB.
          getOffset(
            ) +
          sppsm.
          getOffset(
            dest.
              getMinX(
                ) -
              dest.
              getSampleModelTranslateX(
                ),
            dest.
              getMinY(
                ) -
              dest.
              getSampleModelTranslateY(
                ));
        final int srcScanStride =
          ((java.awt.image.SinglePixelPackedSampleModel)
             src.
             getSampleModel(
               )).
          getScanlineStride(
            );
        final int dstScanStride =
          ((java.awt.image.SinglePixelPackedSampleModel)
             dest.
             getSampleModel(
               )).
          getScanlineStride(
            );
        final int[] srcPixels =
          srcDB.
          getBankData(
            )[0];
        final int[] destPixels =
          dstDB.
          getBankData(
            )[0];
        int sp;
        int dp;
        int bufferHead;
        int maxIndexA;
        int maxIndexR;
        int maxIndexG;
        int maxIndexB;
        int pel;
        int currentPixel;
        int lastPixel;
        int a;
        int r;
        int g;
        int b;
        int a1;
        int r1;
        int g1;
        int b1;
        if (w <=
              radiusX) {
            for (int i =
                   0;
                 i <
                   h;
                 i++) {
                sp =
                  srcOff +
                    i *
                    srcScanStride;
                dp =
                  dstOff +
                    i *
                    dstScanStride;
                pel =
                  srcPixels[sp++];
                a =
                  pel >>>
                    24;
                r =
                  pel &
                    16711680;
                g =
                  pel &
                    65280;
                b =
                  pel &
                    255;
                for (int k =
                       1;
                     k <
                       w;
                     k++) {
                    currentPixel =
                      srcPixels[sp++];
                    a1 =
                      currentPixel >>>
                        24;
                    r1 =
                      currentPixel &
                        16711680;
                    g1 =
                      currentPixel &
                        65280;
                    b1 =
                      currentPixel &
                        255;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                    }
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                    }
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                    }
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                    }
                }
                for (int k =
                       0;
                     k <
                       w;
                     k++) {
                    destPixels[dp++] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                }
            }
        }
        else {
            final int[] bufferA =
              new int[w];
            final int[] bufferR =
              new int[w];
            final int[] bufferG =
              new int[w];
            final int[] bufferB =
              new int[w];
            for (int i =
                   0;
                 i <
                   h;
                 i++) {
                sp =
                  srcOff +
                    i *
                    srcScanStride;
                dp =
                  dstOff +
                    i *
                    dstScanStride;
                bufferHead =
                  0;
                maxIndexA =
                  0;
                maxIndexR =
                  0;
                maxIndexG =
                  0;
                maxIndexB =
                  0;
                pel =
                  srcPixels[sp++];
                a =
                  pel >>>
                    24;
                r =
                  pel &
                    16711680;
                g =
                  pel &
                    65280;
                b =
                  pel &
                    255;
                bufferA[0] =
                  a;
                bufferR[0] =
                  r;
                bufferG[0] =
                  g;
                bufferB[0] =
                  b;
                for (int k =
                       1;
                     k <=
                       radiusX;
                     k++) {
                    currentPixel =
                      srcPixels[sp++];
                    a1 =
                      currentPixel >>>
                        24;
                    r1 =
                      currentPixel &
                        16711680;
                    g1 =
                      currentPixel &
                        65280;
                    b1 =
                      currentPixel &
                        255;
                    bufferA[k] =
                      a1;
                    bufferR[k] =
                      r1;
                    bufferG[k] =
                      g1;
                    bufferB[k] =
                      b1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          k;
                    }
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          k;
                    }
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          k;
                    }
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          k;
                    }
                }
                destPixels[dp++] =
                  a <<
                    24 |
                    r |
                    g |
                    b;
                for (int j =
                       1;
                     j <=
                       w -
                       radiusX -
                       1;
                     j++) {
                    lastPixel =
                      srcPixels[sp++];
                    a =
                      bufferA[maxIndexA];
                    a1 =
                      lastPixel >>>
                        24;
                    bufferA[j +
                              radiusX] =
                      a1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          j +
                            radiusX;
                    }
                    r =
                      bufferR[maxIndexR];
                    r1 =
                      lastPixel &
                        16711680;
                    bufferR[j +
                              radiusX] =
                      r1;
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          j +
                            radiusX;
                    }
                    g =
                      bufferG[maxIndexG];
                    g1 =
                      lastPixel &
                        65280;
                    bufferG[j +
                              radiusX] =
                      g1;
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          j +
                            radiusX;
                    }
                    b =
                      bufferB[maxIndexB];
                    b1 =
                      lastPixel &
                        255;
                    bufferB[j +
                              radiusX] =
                      b1;
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          j +
                            radiusX;
                    }
                    destPixels[dp++] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                }
                for (int j =
                       w -
                       radiusX;
                     j <=
                       radiusX;
                     j++) {
                    destPixels[dp] =
                      destPixels[dp -
                                   1];
                    dp++;
                }
                for (int j =
                       radiusX +
                       1;
                     j <
                       w;
                     j++) {
                    if (maxIndexA ==
                          bufferHead) {
                        a =
                          bufferA[bufferHead +
                                    1];
                        maxIndexA =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               w;
                             m++) {
                            a1 =
                              bufferA[m];
                            if (isBetter(
                                  a1,
                                  a,
                                  doDilation)) {
                                a =
                                  a1;
                                maxIndexA =
                                  m;
                            }
                        }
                    }
                    else {
                        a =
                          bufferA[maxIndexA];
                    }
                    if (maxIndexR ==
                          bufferHead) {
                        r =
                          bufferR[bufferHead +
                                    1];
                        maxIndexR =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               w;
                             m++) {
                            r1 =
                              bufferR[m];
                            if (isBetter(
                                  r1,
                                  r,
                                  doDilation)) {
                                r =
                                  r1;
                                maxIndexR =
                                  m;
                            }
                        }
                    }
                    else {
                        r =
                          bufferR[maxIndexR];
                    }
                    if (maxIndexG ==
                          bufferHead) {
                        g =
                          bufferG[bufferHead +
                                    1];
                        maxIndexG =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               w;
                             m++) {
                            g1 =
                              bufferG[m];
                            if (isBetter(
                                  g1,
                                  g,
                                  doDilation)) {
                                g =
                                  g1;
                                maxIndexG =
                                  m;
                            }
                        }
                    }
                    else {
                        g =
                          bufferG[maxIndexG];
                    }
                    if (maxIndexB ==
                          bufferHead) {
                        b =
                          bufferB[bufferHead +
                                    1];
                        maxIndexB =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               w;
                             m++) {
                            b1 =
                              bufferB[m];
                            if (isBetter(
                                  b1,
                                  b,
                                  doDilation)) {
                                b =
                                  b1;
                                maxIndexB =
                                  m;
                            }
                        }
                    }
                    else {
                        b =
                          bufferB[maxIndexB];
                    }
                    bufferHead++;
                    destPixels[dp++] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                }
            }
        }
    }
    private void specialProcessColumn(java.awt.image.Raster src,
                                      java.awt.image.WritableRaster dest) {
        final int w =
          src.
          getWidth(
            );
        final int h =
          src.
          getHeight(
            );
        java.awt.image.DataBufferInt dstDB =
          (java.awt.image.DataBufferInt)
            dest.
            getDataBuffer(
              );
        final int dstOff =
          dstDB.
          getOffset(
            );
        final int dstScanStride =
          ((java.awt.image.SinglePixelPackedSampleModel)
             dest.
             getSampleModel(
               )).
          getScanlineStride(
            );
        final int[] destPixels =
          dstDB.
          getBankData(
            )[0];
        int dp;
        int cp;
        int bufferHead;
        int maxIndexA;
        int maxIndexR;
        int maxIndexG;
        int maxIndexB;
        int pel;
        int currentPixel;
        int lastPixel;
        int a;
        int r;
        int g;
        int b;
        int a1;
        int r1;
        int g1;
        int b1;
        if (h <=
              radiusY) {
            for (int j =
                   0;
                 j <
                   w;
                 j++) {
                dp =
                  dstOff +
                    j;
                cp =
                  dstOff +
                    j;
                pel =
                  destPixels[cp];
                cp +=
                  dstScanStride;
                a =
                  pel >>>
                    24;
                r =
                  pel &
                    16711680;
                g =
                  pel &
                    65280;
                b =
                  pel &
                    255;
                for (int k =
                       1;
                     k <
                       h;
                     k++) {
                    currentPixel =
                      destPixels[cp];
                    cp +=
                      dstScanStride;
                    a1 =
                      currentPixel >>>
                        24;
                    r1 =
                      currentPixel &
                        16711680;
                    g1 =
                      currentPixel &
                        65280;
                    b1 =
                      currentPixel &
                        255;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                    }
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                    }
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                    }
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                    }
                }
                for (int k =
                       0;
                     k <
                       h;
                     k++) {
                    destPixels[dp] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    dp +=
                      dstScanStride;
                }
            }
        }
        else {
            final int[] bufferA =
              new int[h];
            final int[] bufferR =
              new int[h];
            final int[] bufferG =
              new int[h];
            final int[] bufferB =
              new int[h];
            for (int j =
                   0;
                 j <
                   w;
                 j++) {
                dp =
                  dstOff +
                    j;
                cp =
                  dstOff +
                    j;
                bufferHead =
                  0;
                maxIndexA =
                  0;
                maxIndexR =
                  0;
                maxIndexG =
                  0;
                maxIndexB =
                  0;
                pel =
                  destPixels[cp];
                cp +=
                  dstScanStride;
                a =
                  pel >>>
                    24;
                r =
                  pel &
                    16711680;
                g =
                  pel &
                    65280;
                b =
                  pel &
                    255;
                bufferA[0] =
                  a;
                bufferR[0] =
                  r;
                bufferG[0] =
                  g;
                bufferB[0] =
                  b;
                for (int k =
                       1;
                     k <=
                       radiusY;
                     k++) {
                    currentPixel =
                      destPixels[cp];
                    cp +=
                      dstScanStride;
                    a1 =
                      currentPixel >>>
                        24;
                    r1 =
                      currentPixel &
                        16711680;
                    g1 =
                      currentPixel &
                        65280;
                    b1 =
                      currentPixel &
                        255;
                    bufferA[k] =
                      a1;
                    bufferR[k] =
                      r1;
                    bufferG[k] =
                      g1;
                    bufferB[k] =
                      b1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          k;
                    }
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          k;
                    }
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          k;
                    }
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          k;
                    }
                }
                destPixels[dp] =
                  a <<
                    24 |
                    r |
                    g |
                    b;
                dp +=
                  dstScanStride;
                for (int i =
                       1;
                     i <=
                       h -
                       radiusY -
                       1;
                     i++) {
                    lastPixel =
                      destPixels[cp];
                    cp +=
                      dstScanStride;
                    a =
                      bufferA[maxIndexA];
                    a1 =
                      lastPixel >>>
                        24;
                    bufferA[i +
                              radiusY] =
                      a1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          i +
                            radiusY;
                    }
                    r =
                      bufferR[maxIndexR];
                    r1 =
                      lastPixel &
                        16711680;
                    bufferR[i +
                              radiusY] =
                      r1;
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          i +
                            radiusY;
                    }
                    g =
                      bufferG[maxIndexG];
                    g1 =
                      lastPixel &
                        65280;
                    bufferG[i +
                              radiusY] =
                      g1;
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          i +
                            radiusY;
                    }
                    b =
                      bufferB[maxIndexB];
                    b1 =
                      lastPixel &
                        255;
                    bufferB[i +
                              radiusY] =
                      b1;
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          i +
                            radiusY;
                    }
                    destPixels[dp] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    dp +=
                      dstScanStride;
                }
                for (int i =
                       h -
                       radiusY;
                     i <=
                       radiusY;
                     i++) {
                    destPixels[dp] =
                      destPixels[dp -
                                   dstScanStride];
                    dp +=
                      dstScanStride;
                }
                for (int i =
                       radiusY +
                       1;
                     i <
                       h;
                     i++) {
                    if (maxIndexA ==
                          bufferHead) {
                        a =
                          bufferA[bufferHead +
                                    1];
                        maxIndexA =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               h;
                             m++) {
                            a1 =
                              bufferA[m];
                            if (isBetter(
                                  a1,
                                  a,
                                  doDilation)) {
                                a =
                                  a1;
                                maxIndexA =
                                  m;
                            }
                        }
                    }
                    else {
                        a =
                          bufferA[maxIndexA];
                    }
                    if (maxIndexR ==
                          bufferHead) {
                        r =
                          bufferR[bufferHead +
                                    1];
                        maxIndexR =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               h;
                             m++) {
                            r1 =
                              bufferR[m];
                            if (isBetter(
                                  r1,
                                  r,
                                  doDilation)) {
                                r =
                                  r1;
                                maxIndexR =
                                  m;
                            }
                        }
                    }
                    else {
                        r =
                          bufferR[maxIndexR];
                    }
                    if (maxIndexG ==
                          bufferHead) {
                        g =
                          bufferG[bufferHead +
                                    1];
                        maxIndexG =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               h;
                             m++) {
                            g1 =
                              bufferG[m];
                            if (isBetter(
                                  g1,
                                  g,
                                  doDilation)) {
                                g =
                                  g1;
                                maxIndexG =
                                  m;
                            }
                        }
                    }
                    else {
                        g =
                          bufferG[maxIndexG];
                    }
                    if (maxIndexB ==
                          bufferHead) {
                        b =
                          bufferB[bufferHead +
                                    1];
                        maxIndexB =
                          bufferHead +
                            1;
                        for (int m =
                               bufferHead +
                               2;
                             m <
                               h;
                             m++) {
                            b1 =
                              bufferB[m];
                            if (isBetter(
                                  b1,
                                  b,
                                  doDilation)) {
                                b =
                                  b1;
                                maxIndexB =
                                  m;
                            }
                        }
                    }
                    else {
                        b =
                          bufferB[maxIndexB];
                    }
                    bufferHead++;
                    destPixels[dp] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    dp +=
                      dstScanStride;
                }
            }
        }
    }
    public java.awt.image.WritableRaster filter(java.awt.image.Raster src,
                                                java.awt.image.WritableRaster dest) {
        if (dest !=
              null)
            checkCompatible(
              dest.
                getSampleModel(
                  ));
        else {
            if (src ==
                  null)
                throw new java.lang.IllegalArgumentException(
                  "src should not be null when dest is null");
            else
                dest =
                  createCompatibleDestRaster(
                    src);
        }
        final int w =
          src.
          getWidth(
            );
        final int h =
          src.
          getHeight(
            );
        java.awt.image.DataBufferInt srcDB =
          (java.awt.image.DataBufferInt)
            src.
            getDataBuffer(
              );
        java.awt.image.DataBufferInt dstDB =
          (java.awt.image.DataBufferInt)
            dest.
            getDataBuffer(
              );
        final int srcOff =
          srcDB.
          getOffset(
            );
        final int dstOff =
          dstDB.
          getOffset(
            );
        final int srcScanStride =
          ((java.awt.image.SinglePixelPackedSampleModel)
             src.
             getSampleModel(
               )).
          getScanlineStride(
            );
        final int dstScanStride =
          ((java.awt.image.SinglePixelPackedSampleModel)
             dest.
             getSampleModel(
               )).
          getScanlineStride(
            );
        final int[] srcPixels =
          srcDB.
          getBankData(
            )[0];
        final int[] destPixels =
          dstDB.
          getBankData(
            )[0];
        int sp;
        int dp;
        int cp;
        int bufferHead;
        int maxIndexA;
        int maxIndexR;
        int maxIndexG;
        int maxIndexB;
        int pel;
        int currentPixel;
        int lastPixel;
        int a;
        int r;
        int g;
        int b;
        int a1;
        int r1;
        int g1;
        int b1;
        if (w <=
              2 *
              radiusX) {
            specialProcessRow(
              src,
              dest);
        }
        else {
            final int[] bufferA =
              new int[rangeX];
            final int[] bufferR =
              new int[rangeX];
            final int[] bufferG =
              new int[rangeX];
            final int[] bufferB =
              new int[rangeX];
            for (int i =
                   0;
                 i <
                   h;
                 i++) {
                sp =
                  srcOff +
                    i *
                    srcScanStride;
                dp =
                  dstOff +
                    i *
                    dstScanStride;
                bufferHead =
                  0;
                maxIndexA =
                  0;
                maxIndexR =
                  0;
                maxIndexG =
                  0;
                maxIndexB =
                  0;
                pel =
                  srcPixels[sp++];
                a =
                  pel >>>
                    24;
                r =
                  pel &
                    16711680;
                g =
                  pel &
                    65280;
                b =
                  pel &
                    255;
                bufferA[0] =
                  a;
                bufferR[0] =
                  r;
                bufferG[0] =
                  g;
                bufferB[0] =
                  b;
                for (int k =
                       1;
                     k <=
                       radiusX;
                     k++) {
                    currentPixel =
                      srcPixels[sp++];
                    a1 =
                      currentPixel >>>
                        24;
                    r1 =
                      currentPixel &
                        16711680;
                    g1 =
                      currentPixel &
                        65280;
                    b1 =
                      currentPixel &
                        255;
                    bufferA[k] =
                      a1;
                    bufferR[k] =
                      r1;
                    bufferG[k] =
                      g1;
                    bufferB[k] =
                      b1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          k;
                    }
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          k;
                    }
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          k;
                    }
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          k;
                    }
                }
                destPixels[dp++] =
                  a <<
                    24 |
                    r |
                    g |
                    b;
                for (int j =
                       1;
                     j <=
                       radiusX;
                     j++) {
                    lastPixel =
                      srcPixels[sp++];
                    a =
                      bufferA[maxIndexA];
                    a1 =
                      lastPixel >>>
                        24;
                    bufferA[j +
                              radiusX] =
                      a1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          j +
                            radiusX;
                    }
                    r =
                      bufferR[maxIndexR];
                    r1 =
                      lastPixel &
                        16711680;
                    bufferR[j +
                              radiusX] =
                      r1;
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          j +
                            radiusX;
                    }
                    g =
                      bufferG[maxIndexG];
                    g1 =
                      lastPixel &
                        65280;
                    bufferG[j +
                              radiusX] =
                      g1;
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          j +
                            radiusX;
                    }
                    b =
                      bufferB[maxIndexB];
                    b1 =
                      lastPixel &
                        255;
                    bufferB[j +
                              radiusX] =
                      b1;
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          j +
                            radiusX;
                    }
                    destPixels[dp++] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                }
                for (int j =
                       radiusX +
                       1;
                     j <=
                       w -
                       1 -
                       radiusX;
                     j++) {
                    lastPixel =
                      srcPixels[sp++];
                    a1 =
                      lastPixel >>>
                        24;
                    r1 =
                      lastPixel &
                        16711680;
                    g1 =
                      lastPixel &
                        65280;
                    b1 =
                      lastPixel &
                        255;
                    bufferA[bufferHead] =
                      a1;
                    bufferR[bufferHead] =
                      r1;
                    bufferG[bufferHead] =
                      g1;
                    bufferB[bufferHead] =
                      b1;
                    if (maxIndexA ==
                          bufferHead) {
                        a =
                          bufferA[0];
                        maxIndexA =
                          0;
                        for (int m =
                               1;
                             m <
                               rangeX;
                             m++) {
                            a1 =
                              bufferA[m];
                            if (isBetter(
                                  a1,
                                  a,
                                  doDilation)) {
                                a =
                                  a1;
                                maxIndexA =
                                  m;
                            }
                        }
                    }
                    else {
                        a =
                          bufferA[maxIndexA];
                        if (isBetter(
                              a1,
                              a,
                              doDilation)) {
                            a =
                              a1;
                            maxIndexA =
                              bufferHead;
                        }
                    }
                    if (maxIndexR ==
                          bufferHead) {
                        r =
                          bufferR[0];
                        maxIndexR =
                          0;
                        for (int m =
                               1;
                             m <
                               rangeX;
                             m++) {
                            r1 =
                              bufferR[m];
                            if (isBetter(
                                  r1,
                                  r,
                                  doDilation)) {
                                r =
                                  r1;
                                maxIndexR =
                                  m;
                            }
                        }
                    }
                    else {
                        r =
                          bufferR[maxIndexR];
                        if (isBetter(
                              r1,
                              r,
                              doDilation)) {
                            r =
                              r1;
                            maxIndexR =
                              bufferHead;
                        }
                    }
                    if (maxIndexG ==
                          bufferHead) {
                        g =
                          bufferG[0];
                        maxIndexG =
                          0;
                        for (int m =
                               1;
                             m <
                               rangeX;
                             m++) {
                            g1 =
                              bufferG[m];
                            if (isBetter(
                                  g1,
                                  g,
                                  doDilation)) {
                                g =
                                  g1;
                                maxIndexG =
                                  m;
                            }
                        }
                    }
                    else {
                        g =
                          bufferG[maxIndexG];
                        if (isBetter(
                              g1,
                              g,
                              doDilation)) {
                            g =
                              g1;
                            maxIndexG =
                              bufferHead;
                        }
                    }
                    if (maxIndexB ==
                          bufferHead) {
                        b =
                          bufferB[0];
                        maxIndexB =
                          0;
                        for (int m =
                               1;
                             m <
                               rangeX;
                             m++) {
                            b1 =
                              bufferB[m];
                            if (isBetter(
                                  b1,
                                  b,
                                  doDilation)) {
                                b =
                                  b1;
                                maxIndexB =
                                  m;
                            }
                        }
                    }
                    else {
                        b =
                          bufferB[maxIndexB];
                        if (isBetter(
                              b1,
                              b,
                              doDilation)) {
                            b =
                              b1;
                            maxIndexB =
                              bufferHead;
                        }
                    }
                    destPixels[dp++] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    bufferHead =
                      (bufferHead +
                         1) %
                        rangeX;
                }
                int head;
                final int tail =
                  bufferHead ==
                  0
                  ? rangeX -
                  1
                  : bufferHead -
                  1;
                int count =
                  rangeX -
                  1;
                for (int j =
                       w -
                       radiusX;
                     j <
                       w;
                     j++) {
                    head =
                      (bufferHead +
                         1) %
                        rangeX;
                    if (maxIndexA ==
                          bufferHead) {
                        a =
                          bufferA[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            a1 =
                              bufferA[hd];
                            if (isBetter(
                                  a1,
                                  a,
                                  doDilation)) {
                                a =
                                  a1;
                                maxIndexA =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeX;
                        }
                    }
                    if (maxIndexR ==
                          bufferHead) {
                        r =
                          bufferR[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            r1 =
                              bufferR[hd];
                            if (isBetter(
                                  r1,
                                  r,
                                  doDilation)) {
                                r =
                                  r1;
                                maxIndexR =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeX;
                        }
                    }
                    if (maxIndexG ==
                          bufferHead) {
                        g =
                          bufferG[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            g1 =
                              bufferG[hd];
                            if (isBetter(
                                  g1,
                                  g,
                                  doDilation)) {
                                g =
                                  g1;
                                maxIndexG =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeX;
                        }
                    }
                    if (maxIndexB ==
                          bufferHead) {
                        b =
                          bufferB[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            b1 =
                              bufferB[hd];
                            if (isBetter(
                                  b1,
                                  b,
                                  doDilation)) {
                                b =
                                  b1;
                                maxIndexB =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeX;
                        }
                    }
                    destPixels[dp++] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    bufferHead =
                      (bufferHead +
                         1) %
                        rangeX;
                    count--;
                }
            }
        }
        if (h <=
              2 *
              radiusY) {
            specialProcessColumn(
              src,
              dest);
        }
        else {
            final int[] bufferA =
              new int[rangeY];
            final int[] bufferR =
              new int[rangeY];
            final int[] bufferG =
              new int[rangeY];
            final int[] bufferB =
              new int[rangeY];
            for (int j =
                   0;
                 j <
                   w;
                 j++) {
                dp =
                  dstOff +
                    j;
                cp =
                  dstOff +
                    j;
                bufferHead =
                  0;
                maxIndexA =
                  0;
                maxIndexR =
                  0;
                maxIndexG =
                  0;
                maxIndexB =
                  0;
                pel =
                  destPixels[cp];
                cp +=
                  dstScanStride;
                a =
                  pel >>>
                    24;
                r =
                  pel &
                    16711680;
                g =
                  pel &
                    65280;
                b =
                  pel &
                    255;
                bufferA[0] =
                  a;
                bufferR[0] =
                  r;
                bufferG[0] =
                  g;
                bufferB[0] =
                  b;
                for (int k =
                       1;
                     k <=
                       radiusY;
                     k++) {
                    currentPixel =
                      destPixels[cp];
                    cp +=
                      dstScanStride;
                    a1 =
                      currentPixel >>>
                        24;
                    r1 =
                      currentPixel &
                        16711680;
                    g1 =
                      currentPixel &
                        65280;
                    b1 =
                      currentPixel &
                        255;
                    bufferA[k] =
                      a1;
                    bufferR[k] =
                      r1;
                    bufferG[k] =
                      g1;
                    bufferB[k] =
                      b1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          k;
                    }
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          k;
                    }
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          k;
                    }
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          k;
                    }
                }
                destPixels[dp] =
                  a <<
                    24 |
                    r |
                    g |
                    b;
                dp +=
                  dstScanStride;
                for (int i =
                       1;
                     i <=
                       radiusY;
                     i++) {
                    int maxI =
                      i +
                      radiusY;
                    lastPixel =
                      destPixels[cp];
                    cp +=
                      dstScanStride;
                    a =
                      bufferA[maxIndexA];
                    a1 =
                      lastPixel >>>
                        24;
                    bufferA[maxI] =
                      a1;
                    if (isBetter(
                          a1,
                          a,
                          doDilation)) {
                        a =
                          a1;
                        maxIndexA =
                          maxI;
                    }
                    r =
                      bufferR[maxIndexR];
                    r1 =
                      lastPixel &
                        16711680;
                    bufferR[maxI] =
                      r1;
                    if (isBetter(
                          r1,
                          r,
                          doDilation)) {
                        r =
                          r1;
                        maxIndexR =
                          maxI;
                    }
                    g =
                      bufferG[maxIndexG];
                    g1 =
                      lastPixel &
                        65280;
                    bufferG[maxI] =
                      g1;
                    if (isBetter(
                          g1,
                          g,
                          doDilation)) {
                        g =
                          g1;
                        maxIndexG =
                          maxI;
                    }
                    b =
                      bufferB[maxIndexB];
                    b1 =
                      lastPixel &
                        255;
                    bufferB[maxI] =
                      b1;
                    if (isBetter(
                          b1,
                          b,
                          doDilation)) {
                        b =
                          b1;
                        maxIndexB =
                          maxI;
                    }
                    destPixels[dp] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    dp +=
                      dstScanStride;
                }
                for (int i =
                       radiusY +
                       1;
                     i <=
                       h -
                       1 -
                       radiusY;
                     i++) {
                    lastPixel =
                      destPixels[cp];
                    cp +=
                      dstScanStride;
                    a1 =
                      lastPixel >>>
                        24;
                    r1 =
                      lastPixel &
                        16711680;
                    g1 =
                      lastPixel &
                        65280;
                    b1 =
                      lastPixel &
                        255;
                    bufferA[bufferHead] =
                      a1;
                    bufferR[bufferHead] =
                      r1;
                    bufferG[bufferHead] =
                      g1;
                    bufferB[bufferHead] =
                      b1;
                    if (maxIndexA ==
                          bufferHead) {
                        a =
                          bufferA[0];
                        maxIndexA =
                          0;
                        for (int m =
                               1;
                             m <=
                               2 *
                               radiusY;
                             m++) {
                            a1 =
                              bufferA[m];
                            if (isBetter(
                                  a1,
                                  a,
                                  doDilation)) {
                                a =
                                  a1;
                                maxIndexA =
                                  m;
                            }
                        }
                    }
                    else {
                        a =
                          bufferA[maxIndexA];
                        if (isBetter(
                              a1,
                              a,
                              doDilation)) {
                            a =
                              a1;
                            maxIndexA =
                              bufferHead;
                        }
                    }
                    if (maxIndexR ==
                          bufferHead) {
                        r =
                          bufferR[0];
                        maxIndexR =
                          0;
                        for (int m =
                               1;
                             m <=
                               2 *
                               radiusY;
                             m++) {
                            r1 =
                              bufferR[m];
                            if (isBetter(
                                  r1,
                                  r,
                                  doDilation)) {
                                r =
                                  r1;
                                maxIndexR =
                                  m;
                            }
                        }
                    }
                    else {
                        r =
                          bufferR[maxIndexR];
                        if (isBetter(
                              r1,
                              r,
                              doDilation)) {
                            r =
                              r1;
                            maxIndexR =
                              bufferHead;
                        }
                    }
                    if (maxIndexG ==
                          bufferHead) {
                        g =
                          bufferG[0];
                        maxIndexG =
                          0;
                        for (int m =
                               1;
                             m <=
                               2 *
                               radiusY;
                             m++) {
                            g1 =
                              bufferG[m];
                            if (isBetter(
                                  g1,
                                  g,
                                  doDilation)) {
                                g =
                                  g1;
                                maxIndexG =
                                  m;
                            }
                        }
                    }
                    else {
                        g =
                          bufferG[maxIndexG];
                        if (isBetter(
                              g1,
                              g,
                              doDilation)) {
                            g =
                              g1;
                            maxIndexG =
                              bufferHead;
                        }
                    }
                    if (maxIndexB ==
                          bufferHead) {
                        b =
                          bufferB[0];
                        maxIndexB =
                          0;
                        for (int m =
                               1;
                             m <=
                               2 *
                               radiusY;
                             m++) {
                            b1 =
                              bufferB[m];
                            if (isBetter(
                                  b1,
                                  b,
                                  doDilation)) {
                                b =
                                  b1;
                                maxIndexB =
                                  m;
                            }
                        }
                    }
                    else {
                        b =
                          bufferB[maxIndexB];
                        if (isBetter(
                              b1,
                              b,
                              doDilation)) {
                            b =
                              b1;
                            maxIndexB =
                              bufferHead;
                        }
                    }
                    destPixels[dp] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    dp +=
                      dstScanStride;
                    bufferHead =
                      (bufferHead +
                         1) %
                        rangeY;
                }
                int head;
                final int tail =
                  bufferHead ==
                  0
                  ? 2 *
                  radiusY
                  : bufferHead -
                  1;
                int count =
                  rangeY -
                  1;
                for (int i =
                       h -
                       radiusY;
                     i <
                       h -
                       1;
                     i++) {
                    head =
                      (bufferHead +
                         1) %
                        rangeY;
                    if (maxIndexA ==
                          bufferHead) {
                        a =
                          bufferA[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            a1 =
                              bufferA[hd];
                            if (isBetter(
                                  a1,
                                  a,
                                  doDilation)) {
                                a =
                                  a1;
                                maxIndexA =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeY;
                        }
                    }
                    if (maxIndexR ==
                          bufferHead) {
                        r =
                          bufferR[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            r1 =
                              bufferR[hd];
                            if (isBetter(
                                  r1,
                                  r,
                                  doDilation)) {
                                r =
                                  r1;
                                maxIndexR =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeY;
                        }
                    }
                    if (maxIndexG ==
                          bufferHead) {
                        g =
                          bufferG[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            g1 =
                              bufferG[hd];
                            if (isBetter(
                                  g1,
                                  g,
                                  doDilation)) {
                                g =
                                  g1;
                                maxIndexG =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeY;
                        }
                    }
                    if (maxIndexB ==
                          bufferHead) {
                        b =
                          bufferB[tail];
                        int hd =
                          head;
                        for (int m =
                               1;
                             m <
                               count;
                             m++) {
                            b1 =
                              bufferB[hd];
                            if (isBetter(
                                  b1,
                                  b,
                                  doDilation)) {
                                b =
                                  b1;
                                maxIndexB =
                                  hd;
                            }
                            hd =
                              (hd +
                                 1) %
                                rangeY;
                        }
                    }
                    destPixels[dp] =
                      a <<
                        24 |
                        r |
                        g |
                        b;
                    dp +=
                      dstScanStride;
                    bufferHead =
                      (bufferHead +
                         1) %
                        rangeY;
                    count--;
                }
            }
        }
        return dest;
    }
    public java.awt.image.BufferedImage filter(java.awt.image.BufferedImage src,
                                               java.awt.image.BufferedImage dest) {
        if (src ==
              null)
            throw new java.lang.NullPointerException(
              "Source image should not be null");
        java.awt.image.BufferedImage origSrc =
          src;
        java.awt.image.BufferedImage finalDest =
          dest;
        if (!isCompatible(
               src.
                 getColorModel(
                   ),
               src.
                 getSampleModel(
                   ))) {
            src =
              new java.awt.image.BufferedImage(
                src.
                  getWidth(
                    ),
                src.
                  getHeight(
                    ),
                java.awt.image.BufferedImage.
                  TYPE_INT_ARGB_PRE);
            org.apache.batik.ext.awt.image.GraphicsUtil.
              copyData(
                origSrc,
                src);
        }
        else
            if (!src.
                  isAlphaPremultiplied(
                    )) {
                java.awt.image.ColorModel srcCM;
                java.awt.image.ColorModel srcCMPre;
                srcCM =
                  src.
                    getColorModel(
                      );
                srcCMPre =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceColorModel(
                      srcCM,
                      true);
                src =
                  new java.awt.image.BufferedImage(
                    srcCMPre,
                    src.
                      getRaster(
                        ),
                    true,
                    null);
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  copyData(
                    origSrc,
                    src);
            }
        if (dest ==
              null) {
            dest =
              createCompatibleDestImage(
                src,
                null);
            finalDest =
              dest;
        }
        else
            if (!isCompatible(
                   dest.
                     getColorModel(
                       ),
                   dest.
                     getSampleModel(
                       ))) {
                dest =
                  createCompatibleDestImage(
                    src,
                    null);
            }
            else
                if (!dest.
                      isAlphaPremultiplied(
                        )) {
                    java.awt.image.ColorModel dstCM;
                    java.awt.image.ColorModel dstCMPre;
                    dstCM =
                      dest.
                        getColorModel(
                          );
                    dstCMPre =
                      org.apache.batik.ext.awt.image.GraphicsUtil.
                        coerceColorModel(
                          dstCM,
                          true);
                    dest =
                      new java.awt.image.BufferedImage(
                        dstCMPre,
                        finalDest.
                          getRaster(
                            ),
                        true,
                        null);
                }
        filter(
          src.
            getRaster(
              ),
          dest.
            getRaster(
              ));
        if (src.
              getRaster(
                ) ==
              origSrc.
              getRaster(
                ) &&
              src.
              isAlphaPremultiplied(
                ) !=
              origSrc.
              isAlphaPremultiplied(
                )) {
            org.apache.batik.ext.awt.image.GraphicsUtil.
              copyData(
                src,
                origSrc);
        }
        if (dest.
              getRaster(
                ) !=
              finalDest.
              getRaster(
                ) ||
              dest.
              isAlphaPremultiplied(
                ) !=
              finalDest.
              isAlphaPremultiplied(
                )) {
            org.apache.batik.ext.awt.image.GraphicsUtil.
              copyData(
                dest,
                finalDest);
        }
        return finalDest;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "d/f9F96fCerNKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "y4Rfud4y4YFlwr8Ry7z9PGcvC/itcwz0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("O0X0z08bqEj6zWMbfOUWbPCWIrHYHUoObJC8MTa4eLrDP3C6KbnQDtI9jn9b" +
       "Zv/aORb4ehH967RyGVjgZMZjA3z1FgxQbim2QfjIgQGee70G4F6LAd52xgnK" +
       "zahhqB2w0QPF1sRpCUHxI08vRcoK/uQcE/3nIvrjtHJFtXTVLQ/RpPbS02+4" +
       "pwGWTNqx7b5xC7Z7a5H4BAifO7Dd595Q2xW33yyib5dS3z3HAP+ziL6TVu4p" +
       "dvYP0Rdp7ztG+me36iUICC8dIH3pjUF64VhgD/KvzgH510X0F9e3cpH8X49x" +
       "fv8WcD5SJFZB+NoBzq+9MXRwAsaFu855drmILoHJCujrfHnQ0A5MGvT55Po5" +
       "wQ2eF/gv3Har+IszGF8/wP/1Nwb/iXb+cgn0wXOM8HAR3QcYQY11JdWPG5rQ" +
       "k3Q/rh5a49EzpDGL7bQ4j3ZCqrTJ/bdgk7cViTAI3ziwyTfeGJuc6OW/XXb1" +
       "EvzT5xjmXUX0OCDTGxmmHE7Lwo5hP3GrsJ8E4ZUD2K+8DtglqpPz7zOoLh1P" +
       "1ZGj6H0lyNo5BoCLqJpW7rKTrp6m++NQxxR34b23SnE4CH95gPcvX28zvyqZ" +
       "f7nQ8ZESyfvPQVmctrsAZuz3JZGu2opXnqpNEj7MTzPdhdatwiWBYj+yz7v/" +
       "/5uCS58Dt19EeApWSqfg7s/Cn0FM3Cq3PQG8rrPPu/9/Q/vxCcTTcxBLRTRO" +
       "iw9CvL0TX3jkGCN3q5328Url9h/u8+7/33iu+u0Sx4fPwbgsog+dxHiSmF71" +
       "bNmpQ5hgXnPysH1xcvjh6z722X+gov7aC1fueugF8T+U582PPiK5m63cZWSe" +
       "d/JM4onrO6JYN+wS+d37E4pRCcJOKz/6Gj8HAKR0eFkAuGDtSwCr2cfOLyGt" +
       "3F7+n8wVppWHb5YrrVwC8UnpGPSdG0kDSRCflMzSytWzkqD+8v+kHLD45WM5" +
       "0Ij7i5Miz4HSgUhx+ZGjFxYnzi3tj45u9qvAh096azlJe9UB+SjLyePyhQnK" +
       "j8EOXyZk+8/BnlW/9EJ/9Nz3mr+8P66vespuV5RyF1u5c//lQFlo8ULiyZuW" +
       "dljWHfS7f3Dvr9/9zsOXJ/fuFT7uOSd0e/zGZ+N7fpSWp9l3//Shf/L+f/TC" +
       "N8uDW/8XNpzq1aU3AAA=");
}
