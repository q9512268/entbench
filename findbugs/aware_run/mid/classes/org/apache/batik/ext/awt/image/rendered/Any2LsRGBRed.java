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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "CCGhevyx/l+EG8S7qyEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JPGb9yKJLIEeOHvdKr878tgtV0F31xfV");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("L716/eqjr4r/avet7PiK4f0sdNVIHefs5/oz9ctBpANuCsjdx/ug+Pt2Av3g" +
       "W7xqApzguFow8K0dhv+aQE/eHUMC3Vf8nx313xLosTuNSqCLoDwL/XsJ9I7b" +
       "QQNIUJ6F/IMEurEPCeYv/s/CvZFA107hEujyrnIW5A8BdgCSV78fHOv+Ld/L" +
       "IeZgx6aoSX4v58L59ePERh55Mxs5s+Q8d+67V3Gb+PgbVbq7T/yS+uVXu/yP" +
       "fa/2xd2dLtVRttscy1UWurK7XnbyneuZO2I7xnWZfv6Nh37u/vceL2IP7Qg+" +
       "dcEztD11+wtUbTdIiitP21949Oc/+Nde/a3i0///BgJKpbXmLQAA");
}
