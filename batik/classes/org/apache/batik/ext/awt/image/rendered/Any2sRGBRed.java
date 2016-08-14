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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "582Yb3CE2VKwig618y72Fv8P6p9anr0iAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "FcW/SqEHTSejQy+My+A48pm3n/OZcxSl");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Ob783fo/DITlD83B363///5d2OFP7mCHPyuKP06hh4AdTqFEUfsrJ7r+x7vR" +
       "NUuhN5064FWcVnnsptOl+xOR2mdevXbf216d/P7+K+LRqcX7Oeg+c+15pw8I" +
       "nHq+EsWGuQ/a+/fHBaLy9vUU+t7v8HAL8PKjx1L+/7rn8N9S6Mk7c0ihe8r7" +
       "6VbfTKHHbtcqhS6B8jT1/0yht9yKGlCC8jTlXwAQPk8J+i/vp+m+nUJXT+hS" +
       "6Mr+4RTJBRBClwBJ8XgpOvLy7/y43iJJY1VLi5NAF87Olscu8sgbucipCfa5" +
       "M18LywPKR1/21vsjyje0z77KDD7wjcbP7U+RaZ6a5wWX+zjo3v2BtuOvg8/c" +
       "ltsRryu9F7710Ofuf+fRlP3QXuCTGDsl21O3PrLV9qO0PGSV/8O3/dq7/96r" +
       "f1ieNfi/3JdRrzkuAAA=");
}
