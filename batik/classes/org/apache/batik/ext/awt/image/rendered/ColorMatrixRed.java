package org.apache.batik.ext.awt.image.rendered;
public class ColorMatrixRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    private float[][] matrix;
    public float[][] getMatrix() { return copyMatrix(matrix); }
    public void setMatrix(float[][] matrix) { float[][] tmp = copyMatrix(
                                                                matrix);
                                              if (tmp == null) { throw new java.lang.IllegalArgumentException(
                                                                   );
                                              }
                                              if (tmp.length != 4) {
                                                  throw new java.lang.IllegalArgumentException(
                                                    );
                                              }
                                              for (int i =
                                                     0; i <
                                                          4;
                                                   i++) {
                                                  if (tmp[i].
                                                        length !=
                                                        5) {
                                                      throw new java.lang.IllegalArgumentException(
                                                        java.lang.String.
                                                          valueOf(
                                                            i) +
                                                        " : " +
                                                        tmp[i].
                                                          length);
                                                  }
                                              }
                                              this.
                                                matrix =
                                                matrix;
    }
    private float[][] copyMatrix(float[][] m) { if (m ==
                                                      null) {
                                                    return null;
                                                }
                                                float[][] cm =
                                                  new float[m.
                                                              length][];
                                                for (int i =
                                                       0;
                                                     i <
                                                       m.
                                                         length;
                                                     i++) {
                                                    if (m[i] !=
                                                          null) {
                                                        cm[i] =
                                                          (new float[m[i].
                                                                       length]);
                                                        java.lang.System.
                                                          arraycopy(
                                                            m[i],
                                                            0,
                                                            cm[i],
                                                            0,
                                                            m[i].
                                                              length);
                                                    }
                                                }
                                                return cm;
    }
    public ColorMatrixRed(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                          float[][] matrix) {
        super(
          );
        setMatrix(
          matrix);
        java.awt.image.ColorModel srcCM =
          src.
          getColorModel(
            );
        java.awt.color.ColorSpace srcCS =
          null;
        if (srcCM !=
              null)
            srcCS =
              srcCM.
                getColorSpace(
                  );
        java.awt.image.ColorModel cm;
        if (srcCS ==
              null)
            cm =
              org.apache.batik.ext.awt.image.GraphicsUtil.
                Linear_sRGB_Unpre;
        else {
            if (srcCS ==
                  java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_LINEAR_RGB))
                cm =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    Linear_sRGB_Unpre;
            else
                cm =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    sRGB_Unpre;
        }
        java.awt.image.SampleModel sm =
          cm.
          createCompatibleSampleModel(
            src.
              getWidth(
                ),
            src.
              getHeight(
                ));
        init(
          src,
          src.
            getBounds(
              ),
          cm,
          sm,
          src.
            getTileGridXOffset(
              ),
          src.
            getTileGridYOffset(
              ),
          null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        wr =
          src.
            copyData(
              wr);
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        org.apache.batik.ext.awt.image.GraphicsUtil.
          coerceData(
            wr,
            cm,
            false);
        final int minX =
          wr.
          getMinX(
            );
        final int minY =
          wr.
          getMinY(
            );
        final int w =
          wr.
          getWidth(
            );
        final int h =
          wr.
          getHeight(
            );
        java.awt.image.DataBufferInt dbf =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int[] pixels =
          dbf.
          getBankData(
            )[0];
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int offset =
          dbf.
          getOffset(
            ) +
          sppsm.
          getOffset(
            minX -
              wr.
              getSampleModelTranslateX(
                ),
            minY -
              wr.
              getSampleModelTranslateY(
                ));
        final int scanStride =
          ((java.awt.image.SinglePixelPackedSampleModel)
             wr.
             getSampleModel(
               )).
          getScanlineStride(
            );
        final int adjust =
          scanStride -
          w;
        int p =
          offset;
        int i =
          0;
        int j =
          0;
        final float a00 =
          matrix[0][0] /
          255.0F;
        final float a01 =
          matrix[0][1] /
          255.0F;
        final float a02 =
          matrix[0][2] /
          255.0F;
        final float a03 =
          matrix[0][3] /
          255.0F;
        final float a04 =
          matrix[0][4] /
          255.0F;
        final float a10 =
          matrix[1][0] /
          255.0F;
        final float a11 =
          matrix[1][1] /
          255.0F;
        final float a12 =
          matrix[1][2] /
          255.0F;
        final float a13 =
          matrix[1][3] /
          255.0F;
        final float a14 =
          matrix[1][4] /
          255.0F;
        final float a20 =
          matrix[2][0] /
          255.0F;
        final float a21 =
          matrix[2][1] /
          255.0F;
        final float a22 =
          matrix[2][2] /
          255.0F;
        final float a23 =
          matrix[2][3] /
          255.0F;
        final float a24 =
          matrix[2][4] /
          255.0F;
        final float a30 =
          matrix[3][0] /
          255.0F;
        final float a31 =
          matrix[3][1] /
          255.0F;
        final float a32 =
          matrix[3][2] /
          255.0F;
        final float a33 =
          matrix[3][3] /
          255.0F;
        final float a34 =
          matrix[3][4] /
          255.0F;
        for (i =
               0;
             i <
               h;
             i++) {
            for (j =
                   0;
                 j <
                   w;
                 j++) {
                int pel =
                  pixels[p];
                int a =
                  pel >>>
                  24;
                int r =
                  pel >>
                  16 &
                  255;
                int g =
                  pel >>
                  8 &
                  255;
                int b =
                  pel &
                  255;
                int dr =
                  (int)
                    ((a00 *
                        r +
                        a01 *
                        g +
                        a02 *
                        b +
                        a03 *
                        a +
                        a04) *
                       255.0F);
                int dg =
                  (int)
                    ((a10 *
                        r +
                        a11 *
                        g +
                        a12 *
                        b +
                        a13 *
                        a +
                        a14) *
                       255.0F);
                int db =
                  (int)
                    ((a20 *
                        r +
                        a21 *
                        g +
                        a22 *
                        b +
                        a23 *
                        a +
                        a24) *
                       255.0F);
                int da =
                  (int)
                    ((a30 *
                        r +
                        a31 *
                        g +
                        a32 *
                        b +
                        a33 *
                        a +
                        a34) *
                       255.0F);
                if ((dr &
                       -256) !=
                      0)
                    dr =
                      (dr &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                if ((dg &
                       -256) !=
                      0)
                    dg =
                      (dg &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                if ((db &
                       -256) !=
                      0)
                    db =
                      (db &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                if ((da &
                       -256) !=
                      0)
                    da =
                      (da &
                         -2147483648) !=
                        0
                        ? 0
                        : 255;
                pixels[p++] =
                  da <<
                    24 |
                    dr <<
                    16 |
                    dg <<
                    8 |
                    db;
            }
            p +=
              adjust;
        }
        return wr;
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
       "Tr4zvD199/M+lBcm1Qmd4u+9829/4K+/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "8jvVJ4f/C1KJKXF/LAAA";
}
