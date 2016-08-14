package org.apache.batik.ext.awt.image.rendered;
public class SpecularLightingRed extends org.apache.batik.ext.awt.image.rendered.AbstractTiledRed {
    private double ks;
    private double specularExponent;
    private org.apache.batik.ext.awt.image.Light light;
    private org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap;
    private double scaleX;
    private double scaleY;
    private java.awt.Rectangle litRegion;
    private boolean linear;
    public SpecularLightingRed(double ks, double specularExponent, org.apache.batik.ext.awt.image.Light light,
                               org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap,
                               java.awt.Rectangle litRegion,
                               double scaleX,
                               double scaleY,
                               boolean linear) { super();
                                                 this.ks =
                                                   ks;
                                                 this.specularExponent =
                                                   specularExponent;
                                                 this.light =
                                                   light;
                                                 this.bumpMap =
                                                   bumpMap;
                                                 this.litRegion =
                                                   litRegion;
                                                 this.scaleX =
                                                   scaleX;
                                                 this.scaleY =
                                                   scaleY;
                                                 this.linear =
                                                   linear;
                                                 java.awt.image.ColorModel cm;
                                                 if (linear)
                                                     cm =
                                                       org.apache.batik.ext.awt.image.GraphicsUtil.
                                                         Linear_sRGB_Unpre;
                                                 else
                                                     cm =
                                                       org.apache.batik.ext.awt.image.GraphicsUtil.
                                                         sRGB_Unpre;
                                                 int tw =
                                                   litRegion.
                                                     width;
                                                 int th =
                                                   litRegion.
                                                     height;
                                                 int defSz =
                                                   org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
                                                   getDefaultTileSize(
                                                     );
                                                 if (tw >
                                                       defSz)
                                                     tw =
                                                       defSz;
                                                 if (th >
                                                       defSz)
                                                     th =
                                                       defSz;
                                                 java.awt.image.SampleModel sm =
                                                   cm.
                                                   createCompatibleSampleModel(
                                                     tw,
                                                     th);
                                                 init(
                                                   (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                                     null,
                                                   litRegion,
                                                   cm,
                                                   sm,
                                                   litRegion.
                                                     x,
                                                   litRegion.
                                                     y,
                                                   null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        copyToRaster(
          wr);
        return wr;
    }
    public void genRect(java.awt.image.WritableRaster wr) {
        final double scaleX =
          this.
            scaleX;
        final double scaleY =
          this.
            scaleY;
        final double[] lightColor =
          light.
          getColor(
            linear);
        final int w =
          wr.
          getWidth(
            );
        final int h =
          wr.
          getHeight(
            );
        final int minX =
          wr.
          getMinX(
            );
        final int minY =
          wr.
          getMinY(
            );
        final java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int[] pixels =
          db.
          getBankData(
            )[0];
        final java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int offset =
          db.
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
          sppsm.
          getScanlineStride(
            );
        final int adjust =
          scanStride -
          w;
        int p =
          offset;
        int a =
          0;
        int i =
          0;
        int j =
          0;
        double x =
          scaleX *
          minX;
        double y =
          scaleY *
          minY;
        double norm =
          0;
        int pixel =
          0;
        int tmp;
        double mult;
        mult =
          lightColor[0] >
            lightColor[1]
            ? lightColor[0]
            : lightColor[1];
        mult =
          mult >
            lightColor[2]
            ? mult
            : lightColor[2];
        double scale =
          255 /
          mult;
        pixel =
          (int)
            (lightColor[0] *
               scale +
               0.5);
        tmp =
          (int)
            (lightColor[1] *
               scale +
               0.5);
        pixel =
          pixel <<
            8 |
            tmp;
        tmp =
          (int)
            (lightColor[2] *
               scale +
               0.5);
        pixel =
          pixel <<
            8 |
            tmp;
        mult *=
          255 *
            ks;
        final double[][][] NA =
          bumpMap.
          getNormalArray(
            minX,
            minY,
            w,
            h);
        if (light instanceof org.apache.batik.ext.awt.image.SpotLight) {
            org.apache.batik.ext.awt.image.SpotLight slight =
              (org.apache.batik.ext.awt.image.SpotLight)
                light;
            final double[][] LA =
              new double[w][4];
            for (i =
                   0;
                 i <
                   h;
                 i++) {
                final double[][] NR =
                  NA[i];
                slight.
                  getLightRow4(
                    x,
                    y +
                      i *
                      scaleY,
                    scaleX,
                    w,
                    NR,
                    LA);
                for (j =
                       0;
                     j <
                       w;
                     j++) {
                    final double[] N =
                      NR[j];
                    final double[] L =
                      LA[j];
                    double vs =
                      L[3];
                    if (vs ==
                          0) {
                        a =
                          0;
                    }
                    else {
                        L[2] +=
                          1;
                        norm =
                          L[0] *
                            L[0] +
                            L[1] *
                            L[1] +
                            L[2] *
                            L[2];
                        norm =
                          java.lang.Math.
                            sqrt(
                              norm);
                        double dot =
                          N[0] *
                          L[0] +
                          N[1] *
                          L[1] +
                          N[2] *
                          L[2];
                        vs =
                          vs *
                            java.lang.Math.
                            pow(
                              dot /
                                norm,
                              specularExponent);
                        a =
                          (int)
                            (mult *
                               vs +
                               0.5);
                        if ((a &
                               -256) !=
                              0)
                            a =
                              (a &
                                 -2147483648) !=
                                0
                                ? 0
                                : 255;
                    }
                    pixels[p++] =
                      a <<
                        24 |
                        pixel;
                }
                p +=
                  adjust;
            }
        }
        else
            if (!light.
                  isConstant(
                    )) {
                final double[][] LA =
                  new double[w][4];
                for (i =
                       0;
                     i <
                       h;
                     i++) {
                    final double[][] NR =
                      NA[i];
                    light.
                      getLightRow(
                        x,
                        y +
                          i *
                          scaleY,
                        scaleX,
                        w,
                        NR,
                        LA);
                    for (j =
                           0;
                         j <
                           w;
                         j++) {
                        final double[] N =
                          NR[j];
                        final double[] L =
                          LA[j];
                        L[2] +=
                          1;
                        norm =
                          L[0] *
                            L[0] +
                            L[1] *
                            L[1] +
                            L[2] *
                            L[2];
                        norm =
                          java.lang.Math.
                            sqrt(
                              norm);
                        double dot =
                          N[0] *
                          L[0] +
                          N[1] *
                          L[1] +
                          N[2] *
                          L[2];
                        norm =
                          java.lang.Math.
                            pow(
                              dot /
                                norm,
                              specularExponent);
                        a =
                          (int)
                            (mult *
                               norm +
                               0.5);
                        if ((a &
                               -256) !=
                              0)
                            a =
                              (a &
                                 -2147483648) !=
                                0
                                ? 0
                                : 255;
                        pixels[p++] =
                          a <<
                            24 |
                            pixel;
                    }
                    p +=
                      adjust;
                }
            }
            else {
                final double[] L =
                  new double[3];
                light.
                  getLight(
                    0,
                    0,
                    0,
                    L);
                L[2] +=
                  1;
                norm =
                  java.lang.Math.
                    sqrt(
                      L[0] *
                        L[0] +
                        L[1] *
                        L[1] +
                        L[2] *
                        L[2]);
                if (norm >
                      0) {
                    L[0] /=
                      norm;
                    L[1] /=
                      norm;
                    L[2] /=
                      norm;
                }
                for (i =
                       0;
                     i <
                       h;
                     i++) {
                    final double[][] NR =
                      NA[i];
                    for (j =
                           0;
                         j <
                           w;
                         j++) {
                        final double[] N =
                          NR[j];
                        a =
                          (int)
                            (mult *
                               java.lang.Math.
                               pow(
                                 N[0] *
                                   L[0] +
                                   N[1] *
                                   L[1] +
                                   N[2] *
                                   L[2],
                                 specularExponent) +
                               0.5);
                        if ((a &
                               -256) !=
                              0)
                            a =
                              (a &
                                 -2147483648) !=
                                0
                                ? 0
                                : 255;
                        pixels[p++] =
                          a <<
                            24 |
                            pixel;
                    }
                    p +=
                      adjust;
                }
            }
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
      ("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");
}
