package org.apache.batik.ext.awt.image.rendered;
public class Any2sRGBRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    boolean srcIsLsRGB = false;
    public Any2sRGBRed(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        super(
          src,
          src.
            getBounds(
              ),
          fixColorModel(
            src),
          fixSampleModel(
            src),
          src.
            getTileGridXOffset(
              ),
          src.
            getTileGridYOffset(
              ),
          null);
        java.awt.image.ColorModel srcCM =
          src.
          getColorModel(
            );
        if (srcCM ==
              null)
            return;
        java.awt.color.ColorSpace srcCS =
          srcCM.
          getColorSpace(
            );
        if (srcCS ==
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_LINEAR_RGB))
            srcIsLsRGB =
              true;
    }
    public static boolean is_INT_PACK_COMP(java.awt.image.SampleModel sm) {
        if (!(sm instanceof java.awt.image.SinglePixelPackedSampleModel))
            return false;
        if (sm.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_INT)
            return false;
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            sm;
        int[] masks =
          sppsm.
          getBitMasks(
            );
        if (masks.
              length !=
              3 &&
              masks.
                length !=
              4)
            return false;
        if (masks[0] !=
              16711680)
            return false;
        if (masks[1] !=
              65280)
            return false;
        if (masks[2] !=
              255)
            return false;
        if (masks.
              length ==
              4 &&
              masks[3] !=
              -16777216)
            return false;
        return true;
    }
    private static final double GAMMA = 2.4;
    private static final int[] linearToSRGBLut = new int[256];
    static { final double scale = 1.0 / 255;
             final double exp = 1.0 / GAMMA;
             for (int i = 0; i < 256; i++) { double value = i * scale;
                                             if (value <= 0.0031308)
                                                 value *=
                                                   12.92;
                                             else
                                                 value =
                                                   1.055 *
                                                     java.lang.Math.
                                                     pow(
                                                       value,
                                                       exp) -
                                                     0.055;
                                             linearToSRGBLut[i] =
                                               (int)
                                                 java.lang.Math.
                                                 round(
                                                   value *
                                                     255.0); } }
    public static java.awt.image.WritableRaster applyLut_INT(java.awt.image.WritableRaster wr,
                                                             final int[] lut) {
        java.awt.image.SinglePixelPackedSampleModel sm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int srcBase =
          db.
          getOffset(
            ) +
          sm.
          getOffset(
            wr.
              getMinX(
                ) -
              wr.
              getSampleModelTranslateX(
                ),
            wr.
              getMinY(
                ) -
              wr.
              getSampleModelTranslateY(
                ));
        final int[] pixels =
          db.
          getBankData(
            )[0];
        final int width =
          wr.
          getWidth(
            );
        final int height =
          wr.
          getHeight(
            );
        final int scanStride =
          sm.
          getScanlineStride(
            );
        int end;
        int pix;
        for (int y =
               0;
             y <
               height;
             y++) {
            int sp =
              srcBase +
              y *
              scanStride;
            end =
              sp +
                width;
            while (sp <
                     end) {
                pix =
                  pixels[sp];
                pixels[sp] =
                  pix &
                    -16777216 |
                    lut[pix >>>
                          16 &
                          255] <<
                    16 |
                    lut[pix >>>
                          8 &
                          255] <<
                    8 |
                    lut[pix &
                          255];
                sp++;
            }
        }
        return wr;
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.image.ColorModel srcCM =
          src.
          getColorModel(
            );
        java.awt.image.SampleModel srcSM =
          src.
          getSampleModel(
            );
        if (srcIsLsRGB &&
              is_INT_PACK_COMP(
                wr.
                  getSampleModel(
                    ))) {
            src.
              copyData(
                wr);
            if (srcCM.
                  hasAlpha(
                    ))
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  coerceData(
                    wr,
                    srcCM,
                    false);
            applyLut_INT(
              wr,
              linearToSRGBLut);
            return wr;
        }
        if (srcCM ==
              null) {
            float[][] matrix =
              null;
            switch (srcSM.
                      getNumBands(
                        )) {
                case 1:
                    matrix =
                      (new float[3][1]);
                    matrix[0][0] =
                      1;
                    matrix[1][0] =
                      1;
                    matrix[2][0] =
                      1;
                    break;
                case 2:
                    matrix =
                      (new float[4][2]);
                    matrix[0][0] =
                      1;
                    matrix[1][0] =
                      1;
                    matrix[2][0] =
                      1;
                    matrix[3][1] =
                      1;
                    break;
                case 3:
                    matrix =
                      (new float[3][3]);
                    matrix[0][0] =
                      1;
                    matrix[1][1] =
                      1;
                    matrix[2][2] =
                      1;
                    break;
                default:
                    matrix =
                      (new float[4][srcSM.
                                      getNumBands(
                                        )]);
                    matrix[0][0] =
                      1;
                    matrix[1][1] =
                      1;
                    matrix[2][2] =
                      1;
                    matrix[3][3] =
                      1;
                    break;
            }
            java.awt.image.Raster srcRas =
              src.
              getData(
                wr.
                  getBounds(
                    ));
            java.awt.image.BandCombineOp op =
              new java.awt.image.BandCombineOp(
              matrix,
              null);
            op.
              filter(
                srcRas,
                wr);
            return wr;
        }
        if (srcCM.
              getColorSpace(
                ) ==
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_GRAY)) {
            try {
                float[][] matrix =
                  null;
                switch (srcSM.
                          getNumBands(
                            )) {
                    case 1:
                        matrix =
                          (new float[3][1]);
                        matrix[0][0] =
                          1;
                        matrix[1][0] =
                          1;
                        matrix[2][0] =
                          1;
                        break;
                    case 2:
                    default:
                        matrix =
                          (new float[4][2]);
                        matrix[0][0] =
                          1;
                        matrix[1][0] =
                          1;
                        matrix[2][0] =
                          1;
                        matrix[3][1] =
                          1;
                        break;
                }
                java.awt.image.Raster srcRas =
                  src.
                  getData(
                    wr.
                      getBounds(
                        ));
                java.awt.image.BandCombineOp op =
                  new java.awt.image.BandCombineOp(
                  matrix,
                  null);
                op.
                  filter(
                    srcRas,
                    wr);
            }
            catch (java.lang.Throwable t) {
                t.
                  printStackTrace(
                    );
            }
            return wr;
        }
        java.awt.image.ColorModel dstCM =
          getColorModel(
            );
        if (srcCM.
              getColorSpace(
                ) ==
              dstCM.
              getColorSpace(
                )) {
            if (is_INT_PACK_COMP(
                  srcSM))
                src.
                  copyData(
                    wr);
            else
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  copyData(
                    src.
                      getData(
                        wr.
                          getBounds(
                            )),
                    wr);
            return wr;
        }
        java.awt.image.Raster srcRas =
          src.
          getData(
            wr.
              getBounds(
                ));
        java.awt.image.WritableRaster srcWr =
          (java.awt.image.WritableRaster)
            srcRas;
        java.awt.image.ColorModel srcBICM =
          srcCM;
        if (srcCM.
              hasAlpha(
                ))
            srcBICM =
              org.apache.batik.ext.awt.image.GraphicsUtil.
                coerceData(
                  srcWr,
                  srcCM,
                  false);
        java.awt.image.BufferedImage srcBI;
        java.awt.image.BufferedImage dstBI;
        srcBI =
          new java.awt.image.BufferedImage(
            srcBICM,
            srcWr.
              createWritableTranslatedChild(
                0,
                0),
            false,
            null);
        java.awt.image.ColorConvertOp op =
          new java.awt.image.ColorConvertOp(
          dstCM.
            getColorSpace(
              ),
          null);
        dstBI =
          op.
            filter(
              srcBI,
              null);
        java.awt.image.WritableRaster wr00 =
          wr.
          createWritableTranslatedChild(
            0,
            0);
        for (int i =
               0;
             i <
               dstCM.
               getColorSpace(
                 ).
               getNumComponents(
                 );
             i++)
            copyBand(
              dstBI.
                getRaster(
                  ),
              i,
              wr00,
              i);
        if (dstCM.
              hasAlpha(
                ))
            copyBand(
              srcWr,
              srcSM.
                getNumBands(
                  ) -
                1,
              wr,
              getSampleModel(
                ).
                getNumBands(
                  ) -
                1);
        return wr;
    }
    protected static java.awt.image.ColorModel fixColorModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        if (cm !=
              null) {
            if (cm.
                  hasAlpha(
                    ))
                return org.apache.batik.ext.awt.image.GraphicsUtil.
                         sRGB_Unpre;
            return org.apache.batik.ext.awt.image.GraphicsUtil.
                     sRGB;
        }
        else {
            java.awt.image.SampleModel sm =
              src.
              getSampleModel(
                );
            switch (sm.
                      getNumBands(
                        )) {
                case 1:
                    return org.apache.batik.ext.awt.image.GraphicsUtil.
                             sRGB;
                case 2:
                    return org.apache.batik.ext.awt.image.GraphicsUtil.
                             sRGB_Unpre;
                case 3:
                    return org.apache.batik.ext.awt.image.GraphicsUtil.
                             sRGB;
            }
            return org.apache.batik.ext.awt.image.GraphicsUtil.
                     sRGB_Unpre;
        }
    }
    protected static java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        boolean alpha =
          false;
        if (cm !=
              null)
            alpha =
              cm.
                hasAlpha(
                  );
        else {
            switch (sm.
                      getNumBands(
                        )) {
                case 1:
                case 3:
                    alpha =
                      false;
                    break;
                default:
                    alpha =
                      true;
                    break;
            }
        }
        if (alpha)
            return new java.awt.image.SinglePixelPackedSampleModel(
              java.awt.image.DataBuffer.
                TYPE_INT,
              sm.
                getWidth(
                  ),
              sm.
                getHeight(
                  ),
              new int[] { 16711680,
              65280,
              255,
              -16777216 });
        else
            return new java.awt.image.SinglePixelPackedSampleModel(
              java.awt.image.DataBuffer.
                TYPE_INT,
              sm.
                getWidth(
                  ),
              sm.
                getHeight(
                  ),
              new int[] { 16711680,
              65280,
              255 });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "h2HYd2elS7nmDQMRJNCI/2z5D665Q/L0IQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8YcR9DCwwxmUyFt/+VTXf38vuqYR9KYz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("B7jy0yiP33KydHcaUvrcq9euvO3V6e/uvhIen1h8gIGuqBvLOnsA4Ez9shco" +
       "6i5oH9gdB/CK2zcj6Ae/x8MrwMuPq4X8/3nH4b9E0FN35xBBl4r72V7fjqDH" +
       "79Qrgi6C8iz1/4igt9yOGlCC8izlnwIQ3qcE4xf3s3TfjaCrp3QRdHlXOUNy" +
       "AYTQRUCSVy96x17+vR/HW4VRIEpRftLnwvnV8sRFHn0jFzmzwD5/7otfcTj5" +
       "+OvcZnc8+ab0+Vd7gw9+q/6zu1NikiVmWc7lCgPdvzuwdvKF79k7cjvmdZl6" +
       "4TsPf+GBdx4v2Q/vBD6NsTOyPX37I1kd24uKQ1TZ33/br7znb7/6+8VZgv8D" +
       "ajMU/DUuAAA=");
}
