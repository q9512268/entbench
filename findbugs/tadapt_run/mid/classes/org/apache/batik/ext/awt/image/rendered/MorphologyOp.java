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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gqkF/ycS/4GRH91TUzllz9rX+L1x7n8q1QlSmcqoqvck2/Nebpg0pXDQqsW5" +
       "Nr/tiVBGvnGK/yqA8Oe8ohmRpJAwzEhjuARGyvi3l2szI1ODuBgpgdJLrcGc" +
       "K0YNlFB6KbcwUuunhP75t5cOWKtcOhhK8eIlGQHpQIKv2dzhUy1fQOCFQ0xc" +
       "OGTFbnq6PZ7uemvSydwgx+K99kYI+P/NnAOcjPjH2YC8f88la3Yc/+aD4tpd" +
       "VqXt21HK2ASpEP8A4ELxEGhOoDRHVvnq+Z+Pf2zMXOcgrE4o7E6p6Z6F91pY" +
       "iHGPbPDdSVvNuavpo3svevrlXeWHoySynkQkRiasL7yayRoZk8xanyh2qblO" +
       "Mvl1eUvVuxsPffpGpJ7fgBFxDdoYxjEg3/X0mz0pw/h+lIzpBFcDF83ye6P2" +
       "bVovlbeaeXek5YP8qIJjlSDjcfpIuFrmyNiAjsvVYoRnpKnwurjwryxVqj5C" +
       "TX4QgmLG+Y7NMobhbeXItmGxNItIg68NJLoMw74nL1/OkTcMjA8Rfhzb/j+V" +
       "EC2ZVCoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "txWFxe5OdGCD6M2xwcXTE/7+00PJ+qYX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("73H827L6N86xwDeL7F/HlcvAAicrHhvg6zdhgHJLEAPpYwcGeO6NGoB9PQZ4" +
       "xxknKDeTaF85YKP7i62F0xKc6AaOWoqUHfzxOSb6z0X2R3HlHtlQZbs8BBOb" +
       "kqNed08i9U3l2Hbfugnbvb0ofBykLxzY7gtvqu2Kn98usu+WUt8/xwD/s8i+" +
       "F1fuKnbmD9EXZR84RvqnN+slCEgvHyB9+c1BeuFYYA/yr84B+ddF9ufXjnJR" +
       "/F+Pcf7FTeB8uCisgvSNA5zfeHPo4ASMC3ecc+9ykV0CwQqY67PyoKDp6UMw" +
       "56NrY4Lr3C/wX7jlZvEXZyi+eYD/m28O/hPj/NUS6APnGOGhIrsXMIIcqmKs" +
       "Hg90T43i/bp6aI1HzpDGIjTj4jzZCanSJvfdhE3eURTCIH3rwCbfenNscmKW" +
       "/1Y51UvwT51jmPcU2WOATK9nmHI5LRs7hv34zcJ+AqRXD2C/+gZgl6hOxt9n" +
       "UF06DtWRo+wDJcjaOQaAi6waV+4wo64ax/vjTMcUd+H9N0txOEh/eYD3L9/o" +
       "ML8mmX+10PHhEskHz0FZnJa7ACL2e6NAlU3RKU/FRtHM355mugvozcIlgGI/" +
       "tq+7//6bgjs8By5ZZHgMnpROwd2fcz+DuHez3PY48LrOvu7++02dxycQz89B" +
       "LBQZExd/9nD2Tnzh4WOM7M1O2scqlVt/tK+7/37zueq3ShwfPQejVGQfOYnx" +
       "JDG95tmwU4coQVxz8rB8cfL3oWv+yLP/84n8ay/ec8eDL/L/oTwvfvQHkTup" +
       "yh1a4jgnzxSeuL4tCFXNLJHfuT9hGJQgzLjy46/zOD8gpcPLAsAFY98CeJp9" +
       "9PwW4sqt5ffJWn5ceehGteLKJZCflA7B3LmeNJAE+UnJJK5cOSsJ+i+/T8oB" +
       "i18+lgODuL84KfIcaB2IFJcfO3phceLc0f7oZ7Z/CnzopLeWQdprLshHVU4e" +
       "dy9MUP7R6/BlQrL/q9ez8ldeJCfP/aD1y/vj9rIj5nnRyh1U5fb9yf+y0eKF" +
       "xBM3bO2wrduG7/3h3b9+57sPX57cvVf4eOac0O2x659t77tBXJ5Gz//pg//k" +
       "g//wxW+XB6/+L2WKH/6BNwAA");
}
