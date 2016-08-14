package org.apache.batik.ext.awt.image.rendered;
public class Any2LsRGBRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    boolean srcIssRGB = false;
    public Any2LsRGBRed(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
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
                  CS_sRGB))
            srcIssRGB =
              true;
    }
    private static final double GAMMA = 2.4;
    private static final double LFACT = 1.0 / 12.92;
    public static final double sRGBToLsRGB(double value) { if (value <=
                                                                 0.003928)
                                                               return value *
                                                                 LFACT;
                                                           return java.lang.Math.
                                                             pow(
                                                               (value +
                                                                  0.055) /
                                                                 1.055,
                                                               GAMMA);
    }
    private static final int[] sRGBToLsRGBLut = new int[256];
    static { final double scale = 1.0 / 255;
             for (int i = 0; i < 256; i++) { double value =
                                               sRGBToLsRGB(
                                                 i *
                                                   scale);
                                             sRGBToLsRGBLut[i] =
                                               (int)
                                                 java.lang.Math.
                                                 round(
                                                   value *
                                                     255.0);
             } }
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
        if (srcIssRGB &&
              org.apache.batik.ext.awt.image.rendered.Any2sRGBRed.
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
            org.apache.batik.ext.awt.image.rendered.Any2sRGBRed.
              applyLut_INT(
                wr,
                sRGBToLsRGBLut);
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
                      (new float[1][3]);
                    matrix[0][0] =
                      1;
                    matrix[0][1] =
                      1;
                    matrix[0][2] =
                      1;
                    break;
                case 2:
                    matrix =
                      (new float[2][4]);
                    matrix[0][0] =
                      1;
                    matrix[0][1] =
                      1;
                    matrix[0][2] =
                      1;
                    matrix[1][3] =
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
                      (new float[srcSM.
                                   getNumBands(
                                     )][4]);
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
        }
        else {
            java.awt.image.ColorModel dstCM =
              getColorModel(
                );
            java.awt.image.BufferedImage dstBI;
            if (!dstCM.
                  hasAlpha(
                    )) {
                dstBI =
                  new java.awt.image.BufferedImage(
                    dstCM,
                    wr.
                      createWritableTranslatedChild(
                        0,
                        0),
                    dstCM.
                      isAlphaPremultiplied(
                        ),
                    null);
            }
            else {
                java.awt.image.SinglePixelPackedSampleModel dstSM;
                dstSM =
                  (java.awt.image.SinglePixelPackedSampleModel)
                    wr.
                    getSampleModel(
                      );
                int[] masks =
                  dstSM.
                  getBitMasks(
                    );
                java.awt.image.SampleModel dstSMNoA =
                  new java.awt.image.SinglePixelPackedSampleModel(
                  dstSM.
                    getDataType(
                      ),
                  dstSM.
                    getWidth(
                      ),
                  dstSM.
                    getHeight(
                      ),
                  dstSM.
                    getScanlineStride(
                      ),
                  new int[] { masks[0],
                  masks[1],
                  masks[2] });
                java.awt.image.ColorModel dstCMNoA =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    Linear_sRGB;
                java.awt.image.WritableRaster dstWr;
                dstWr =
                  java.awt.image.Raster.
                    createWritableRaster(
                      dstSMNoA,
                      wr.
                        getDataBuffer(
                          ),
                      new java.awt.Point(
                        0,
                        0));
                dstWr =
                  dstWr.
                    createWritableChild(
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
                          ),
                      wr.
                        getWidth(
                          ),
                      wr.
                        getHeight(
                          ),
                      0,
                      0,
                      null);
                dstBI =
                  new java.awt.image.BufferedImage(
                    dstCMNoA,
                    dstWr,
                    false,
                    null);
            }
            java.awt.image.ColorModel srcBICM =
              srcCM;
            java.awt.image.WritableRaster srcWr;
            if (srcCM.
                  hasAlpha(
                    ) &&
                  srcCM.
                  isAlphaPremultiplied(
                    )) {
                java.awt.Rectangle wrR =
                  wr.
                  getBounds(
                    );
                java.awt.image.SampleModel sm =
                  srcCM.
                  createCompatibleSampleModel(
                    wrR.
                      width,
                    wrR.
                      height);
                srcWr =
                  java.awt.image.Raster.
                    createWritableRaster(
                      sm,
                      new java.awt.Point(
                        wrR.
                          x,
                        wrR.
                          y));
                src.
                  copyData(
                    srcWr);
                srcBICM =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceData(
                      srcWr,
                      srcCM,
                      false);
            }
            else {
                java.awt.image.Raster srcRas =
                  src.
                  getData(
                    wr.
                      getBounds(
                        ));
                srcWr =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    makeRasterWritable(
                      srcRas);
            }
            java.awt.image.BufferedImage srcBI;
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
              null);
            op.
              filter(
                srcBI,
                dstBI);
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
        }
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
                         Linear_sRGB_Unpre;
            return org.apache.batik.ext.awt.image.GraphicsUtil.
                     Linear_sRGB;
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
                             Linear_sRGB;
                case 2:
                    return org.apache.batik.ext.awt.image.GraphicsUtil.
                             Linear_sRGB_Unpre;
                case 3:
                    return org.apache.batik.ext.awt.image.GraphicsUtil.
                             Linear_sRGB;
            }
            return org.apache.batik.ext.awt.image.GraphicsUtil.
                     Linear_sRGB_Unpre;
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
       "UDOvYq3lv+qY+6FiIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cviDW8jhPxXFf4igB4EceNnxbf2CIB47");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("EMQhSCmJ370dSaQRdP/5q1jFvZJHr7sKur++qH7+lav3PPKK8G/239FOrhje" +
       "O4buMWLbPv8p/1z9ih/ogJsScv9h3y//vhFB3/8mr6EAJziplgx8fY/hv0fQ" +
       "E7fGEEF3lf/nR/2PCHr0ZqMi6A5Qnof+owh6242gASQoz0N+J4KuHUKC+cv/" +
       "83CvR9B9Z3ARdGVfOQ/yJwA7ACmq3/VPdP+m7+zgShgFshoVd3YuXVw/Tm3k" +
       "4TeykXNLzrMXvpeVt4lPvm3F+/vEL6lfeGXE/Ni3G5/b3/dSbTnPCyz3jKG7" +
       "91fPTr+PPX1TbCe4rhDPv/7gL9377pNF7ME9wWcueI62J298uarv+FF5HSr/" +
       "lUd++X1/45XfK68F/D9HRCAq5i0AAA==");
}
