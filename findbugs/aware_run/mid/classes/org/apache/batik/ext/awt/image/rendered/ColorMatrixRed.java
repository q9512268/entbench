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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "kZWkDnJVaiUV/SSZDI0cs0cMLZUzv3aFrInGamFoFKKSAuEdvYn5OX7fyddY" +
       "eB9D5oVrLH/z5zjYrcUdDHqtGtNSR6G0CDVbU8oQhcCZETUr/roUh+kC+bs4" +
       "3CYJfa+YhDnfoc2zE59qErpY8rHzyU/QTvNK3f2J2mLvjj0TqbX3LXXLrDUc" +
       "FG+YSzQ2yjQfqSp5HoJtRys8nc42OsOq9AQNSZDvTkuhlnHu+8usPYDDj2H/" +
       "w4z3eQr3dH1vGV2X8KaQ1OL24Bx4ljhbX3L6UpdCDUnmO/SXCqqPlhH9MRwe" +
       "AtFtV/RiSbpq1FBTnjr2f251tODSAngcCvK7jDr2FJ6aUqifpo6nyqjjaRx+" +
       "y0kd/rNT1BWe+Nyyi36tDZ6NjgAbT98VSqEWl90tluaJIOpdanzdUrm4y6A2" +
       "9J6C7fNllHMIh2c5qUXlLKdc5MYXPNUcPH3V5DiZFrx4xbw/q+CvIfl3hrJ/" +
       "oqF25sQ1L8te2v3LoT5OatNZTfOXrr73atNiaWnHepmJTPH1Cidnf8ZbH5DZ" +
       "fRWCvCwpHOGktTwFqHfEtx/rKCezSmFBPQyjH/p1qHGLQQMkjH7If3DSGIYE" +
       "/uLbD/cWuLcHBzlGvvhB3gXqAIKvx83TviLrhp7cglwM1sxVBJNK3ldmfJqv" +
       "+PJQe6AcEf8uuuVwVv6/CE3/xJVrrj950X3yelXR6Pg4UpkCPae86c2X1AtL" +
       "UnNpVa/u/GjaI5MXuZmtSW7YO5VzfIciB+fLRKedHbp7tDvyV5Cv7r3syed3" +
       "VR+GwmY9qaDQ0awvbNdyZhYq3vXxYt01NBziWrSr7s0NL374WkWzqHiJ7Gxa" +
       "y2EklNufPNKfNs0fRsjkXvBGsFFO9JLLt+gDTBm1As16ddLI6vk7qWl4wij+" +
       "8yg04yh0an4Wr+c5aSu8uSj8ywIKtDFmLUPqSGZqqAnJmqZ/VWh2QOYg1DS4" +
       "YyLeZ5rOlU31eULzpimCyMc4DP4PexvXN0IgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ysn/1Zv/xbv+6Yt/UH4u+BuTVC4tjywAAA==");
}
