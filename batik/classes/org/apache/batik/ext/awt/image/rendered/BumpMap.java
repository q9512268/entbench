package org.apache.batik.ext.awt.image.rendered;
public final class BumpMap {
    private java.awt.image.RenderedImage texture;
    private double surfaceScale;
    private double surfaceScaleX;
    private double surfaceScaleY;
    private double scaleX;
    private double scaleY;
    public BumpMap(java.awt.image.RenderedImage texture, double surfaceScale,
                   double scaleX,
                   double scaleY) { super();
                                    this.texture = texture;
                                    this.surfaceScaleX = surfaceScale * scaleX;
                                    this.surfaceScaleY = surfaceScale * scaleY;
                                    this.surfaceScale = surfaceScale;
                                    this.scaleX = scaleX;
                                    this.scaleY = scaleY; }
    public double getSurfaceScale() { return surfaceScale; }
    public double[][][] getNormalArray(final int x, final int y, final int w,
                                       final int h) { final double[][][] N =
                                                        new double[h][w][4];
                                                      java.awt.Rectangle srcRect =
                                                        new java.awt.Rectangle(
                                                        x -
                                                          1,
                                                        y -
                                                          1,
                                                        w +
                                                          2,
                                                        h +
                                                          2);
                                                      java.awt.Rectangle srcBound =
                                                        new java.awt.Rectangle(
                                                        texture.
                                                          getMinX(
                                                            ),
                                                        texture.
                                                          getMinY(
                                                            ),
                                                        texture.
                                                          getWidth(
                                                            ),
                                                        texture.
                                                          getHeight(
                                                            ));
                                                      if (!srcRect.
                                                            intersects(
                                                              srcBound))
                                                          return N;
                                                      srcRect =
                                                        srcRect.
                                                          intersection(
                                                            srcBound);
                                                      final java.awt.image.Raster r =
                                                        texture.
                                                        getData(
                                                          srcRect);
                                                      srcRect =
                                                        r.
                                                          getBounds(
                                                            );
                                                      final java.awt.image.DataBufferInt db =
                                                        (java.awt.image.DataBufferInt)
                                                          r.
                                                          getDataBuffer(
                                                            );
                                                      final int[] pixels =
                                                        db.
                                                        getBankData(
                                                          )[0];
                                                      final java.awt.image.SinglePixelPackedSampleModel sppsm;
                                                      sppsm =
                                                        (java.awt.image.SinglePixelPackedSampleModel)
                                                          r.
                                                          getSampleModel(
                                                            );
                                                      final int scanStride =
                                                        sppsm.
                                                        getScanlineStride(
                                                          );
                                                      final int scanStridePP =
                                                        scanStride +
                                                        1;
                                                      final int scanStrideMM =
                                                        scanStride -
                                                        1;
                                                      double prpc =
                                                        0;
                                                      double prcc =
                                                        0;
                                                      double prnc =
                                                        0;
                                                      double crpc =
                                                        0;
                                                      double crcc =
                                                        0;
                                                      double crnc =
                                                        0;
                                                      double nrpc =
                                                        0;
                                                      double nrcc =
                                                        0;
                                                      double nrnc =
                                                        0;
                                                      double invNorm;
                                                      final double quarterSurfaceScaleX =
                                                        surfaceScaleX /
                                                        4.0F;
                                                      final double quarterSurfaceScaleY =
                                                        surfaceScaleY /
                                                        4.0F;
                                                      final double halfSurfaceScaleX =
                                                        surfaceScaleX /
                                                        2.0F;
                                                      final double halfSurfaceScaleY =
                                                        surfaceScaleY /
                                                        2;
                                                      final double thirdSurfaceScaleX =
                                                        surfaceScaleX /
                                                        3.0F;
                                                      final double thirdSurfaceScaleY =
                                                        surfaceScaleY /
                                                        3.0F;
                                                      final double twoThirdSurfaceScaleX =
                                                        surfaceScaleX *
                                                        2 /
                                                        3.0F;
                                                      final double twoThirdSurfaceScaleY =
                                                        surfaceScaleY *
                                                        2 /
                                                        3.0F;
                                                      final double pixelScale =
                                                        1.0 /
                                                        255;
                                                      if (w <=
                                                            0)
                                                          return N;
                                                      if (h <=
                                                            0)
                                                          return N;
                                                      final int xEnd =
                                                        java.lang.Math.
                                                        min(
                                                          srcRect.
                                                            x +
                                                            srcRect.
                                                              width -
                                                            1,
                                                          x +
                                                            w);
                                                      final int yEnd =
                                                        java.lang.Math.
                                                        min(
                                                          srcRect.
                                                            y +
                                                            srcRect.
                                                              height -
                                                            1,
                                                          y +
                                                            h);
                                                      final int offset =
                                                        db.
                                                        getOffset(
                                                          ) +
                                                        sppsm.
                                                        getOffset(
                                                          srcRect.
                                                            x -
                                                            r.
                                                            getSampleModelTranslateX(
                                                              ),
                                                          srcRect.
                                                            y -
                                                            r.
                                                            getSampleModelTranslateY(
                                                              ));
                                                      int yloc =
                                                        y;
                                                      if (yloc <
                                                            srcRect.
                                                              y) {
                                                          yloc =
                                                            srcRect.
                                                              y;
                                                      }
                                                      if (yloc ==
                                                            srcRect.
                                                              y) {
                                                          if (yloc ==
                                                                yEnd) {
                                                              final double[][] NRow =
                                                                N[yloc -
                                                                    y];
                                                              int xloc =
                                                                x;
                                                              if (xloc <
                                                                    srcRect.
                                                                      x)
                                                                  xloc =
                                                                    srcRect.
                                                                      x;
                                                              int p =
                                                                offset +
                                                                (xloc -
                                                                   srcRect.
                                                                     x) +
                                                                scanStride *
                                                                (yloc -
                                                                   srcRect.
                                                                     y);
                                                              crcc =
                                                                (pixels[p] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              if (xloc !=
                                                                    srcRect.
                                                                      x) {
                                                                  crpc =
                                                                    (pixels[p -
                                                                              1] >>>
                                                                       24) *
                                                                      pixelScale;
                                                              }
                                                              else
                                                                  if (xloc <
                                                                        xEnd) {
                                                                      crnc =
                                                                        (pixels[p +
                                                                                  1] >>>
                                                                           24) *
                                                                          pixelScale;
                                                                      final double[] n =
                                                                        NRow[xloc -
                                                                               x];
                                                                      n[0] =
                                                                        2 *
                                                                          surfaceScaleX *
                                                                          (crcc -
                                                                             crnc);
                                                                      invNorm =
                                                                        1.0 /
                                                                          java.lang.Math.
                                                                          sqrt(
                                                                            n[0] *
                                                                              n[0] +
                                                                              1);
                                                                      n[0] *=
                                                                        invNorm;
                                                                      n[1] =
                                                                        0;
                                                                      n[2] =
                                                                        invNorm;
                                                                      n[3] =
                                                                        crcc *
                                                                          surfaceScale;
                                                                      p++;
                                                                      xloc++;
                                                                      crpc =
                                                                        crcc;
                                                                      crcc =
                                                                        crnc;
                                                                  }
                                                                  else {
                                                                      crpc =
                                                                        crcc;
                                                                  }
                                                              for (;
                                                                   xloc <
                                                                     xEnd;
                                                                   xloc++) {
                                                                  crnc =
                                                                    (pixels[p +
                                                                              1] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  final double[] n =
                                                                    NRow[xloc -
                                                                           x];
                                                                  n[0] =
                                                                    surfaceScaleX *
                                                                      (crpc -
                                                                         crnc);
                                                                  invNorm =
                                                                    1.0 /
                                                                      java.lang.Math.
                                                                      sqrt(
                                                                        n[0] *
                                                                          n[0] +
                                                                          1);
                                                                  n[0] *=
                                                                    invNorm;
                                                                  n[1] =
                                                                    0;
                                                                  n[2] =
                                                                    invNorm;
                                                                  n[3] =
                                                                    crcc *
                                                                      surfaceScale;
                                                                  p++;
                                                                  crpc =
                                                                    crcc;
                                                                  crcc =
                                                                    crnc;
                                                              }
                                                              if (xloc <
                                                                    x +
                                                                    w &&
                                                                    xloc ==
                                                                    srcRect.
                                                                      x +
                                                                    srcRect.
                                                                      width -
                                                                    1) {
                                                                  final double[] n =
                                                                    NRow[xloc -
                                                                           x];
                                                                  n[0] =
                                                                    2 *
                                                                      surfaceScaleX *
                                                                      (crpc -
                                                                         crcc);
                                                                  invNorm =
                                                                    1.0 /
                                                                      java.lang.Math.
                                                                      sqrt(
                                                                        n[0] *
                                                                          n[0] +
                                                                          n[1] *
                                                                          n[1] +
                                                                          1);
                                                                  n[0] *=
                                                                    invNorm;
                                                                  n[1] *=
                                                                    invNorm;
                                                                  n[2] =
                                                                    invNorm;
                                                                  n[3] =
                                                                    crcc *
                                                                      surfaceScale;
                                                              }
                                                              return N;
                                                          }
                                                          final double[][] NRow =
                                                            N[yloc -
                                                                y];
                                                          int p =
                                                            offset +
                                                            scanStride *
                                                            (yloc -
                                                               srcRect.
                                                                 y);
                                                          int xloc =
                                                            x;
                                                          if (xloc <
                                                                srcRect.
                                                                  x)
                                                              xloc =
                                                                srcRect.
                                                                  x;
                                                          p +=
                                                            xloc -
                                                              srcRect.
                                                                x;
                                                          crcc =
                                                            (pixels[p] >>>
                                                               24) *
                                                              pixelScale;
                                                          nrcc =
                                                            (pixels[p +
                                                                      scanStride] >>>
                                                               24) *
                                                              pixelScale;
                                                          if (xloc !=
                                                                srcRect.
                                                                  x) {
                                                              crpc =
                                                                (pixels[p -
                                                                          1] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              nrpc =
                                                                (pixels[p +
                                                                          scanStrideMM] >>>
                                                                   24) *
                                                                  pixelScale;
                                                          }
                                                          else
                                                              if (xloc <
                                                                    xEnd) {
                                                                  crnc =
                                                                    (pixels[p +
                                                                              1] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  nrnc =
                                                                    (pixels[p +
                                                                              scanStridePP] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  final double[] n =
                                                                    NRow[xloc -
                                                                           x];
                                                                  n[0] =
                                                                    -twoThirdSurfaceScaleX *
                                                                      (2 *
                                                                         crnc +
                                                                         nrnc -
                                                                         2 *
                                                                         crcc -
                                                                         nrcc);
                                                                  n[1] =
                                                                    -twoThirdSurfaceScaleY *
                                                                      (2 *
                                                                         nrcc +
                                                                         nrnc -
                                                                         2 *
                                                                         crcc -
                                                                         crnc);
                                                                  invNorm =
                                                                    1.0 /
                                                                      java.lang.Math.
                                                                      sqrt(
                                                                        n[0] *
                                                                          n[0] +
                                                                          n[1] *
                                                                          n[1] +
                                                                          1);
                                                                  n[0] *=
                                                                    invNorm;
                                                                  n[1] *=
                                                                    invNorm;
                                                                  n[2] =
                                                                    invNorm;
                                                                  n[3] =
                                                                    crcc *
                                                                      surfaceScale;
                                                                  p++;
                                                                  xloc++;
                                                                  crpc =
                                                                    crcc;
                                                                  nrpc =
                                                                    nrcc;
                                                                  crcc =
                                                                    crnc;
                                                                  nrcc =
                                                                    nrnc;
                                                              }
                                                              else {
                                                                  crpc =
                                                                    crcc;
                                                                  nrpc =
                                                                    nrcc;
                                                              }
                                                          for (;
                                                               xloc <
                                                                 xEnd;
                                                               xloc++) {
                                                              crnc =
                                                                (pixels[p +
                                                                          1] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              nrnc =
                                                                (pixels[p +
                                                                          scanStridePP] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              final double[] n =
                                                                NRow[xloc -
                                                                       x];
                                                              n[0] =
                                                                -thirdSurfaceScaleX *
                                                                  (2 *
                                                                     crnc +
                                                                     nrnc -
                                                                     (2 *
                                                                        crpc +
                                                                        nrpc));
                                                              n[1] =
                                                                -halfSurfaceScaleY *
                                                                  (nrpc +
                                                                     2 *
                                                                     nrcc +
                                                                     nrnc -
                                                                     (crpc +
                                                                        2 *
                                                                        crcc +
                                                                        crnc));
                                                              invNorm =
                                                                1.0 /
                                                                  java.lang.Math.
                                                                  sqrt(
                                                                    n[0] *
                                                                      n[0] +
                                                                      n[1] *
                                                                      n[1] +
                                                                      1);
                                                              n[0] *=
                                                                invNorm;
                                                              n[1] *=
                                                                invNorm;
                                                              n[2] =
                                                                invNorm;
                                                              n[3] =
                                                                crcc *
                                                                  surfaceScale;
                                                              p++;
                                                              crpc =
                                                                crcc;
                                                              nrpc =
                                                                nrcc;
                                                              crcc =
                                                                crnc;
                                                              nrcc =
                                                                nrnc;
                                                          }
                                                          if (xloc <
                                                                x +
                                                                w &&
                                                                xloc ==
                                                                srcRect.
                                                                  x +
                                                                srcRect.
                                                                  width -
                                                                1) {
                                                              final double[] n =
                                                                NRow[xloc -
                                                                       x];
                                                              n[0] =
                                                                -twoThirdSurfaceScaleX *
                                                                  (2 *
                                                                     crcc +
                                                                     nrcc -
                                                                     (2 *
                                                                        crpc +
                                                                        nrpc));
                                                              n[1] =
                                                                -twoThirdSurfaceScaleY *
                                                                  (2 *
                                                                     nrcc +
                                                                     nrpc -
                                                                     (2 *
                                                                        crcc +
                                                                        crpc));
                                                              invNorm =
                                                                1.0 /
                                                                  java.lang.Math.
                                                                  sqrt(
                                                                    n[0] *
                                                                      n[0] +
                                                                      n[1] *
                                                                      n[1] +
                                                                      1);
                                                              n[0] *=
                                                                invNorm;
                                                              n[1] *=
                                                                invNorm;
                                                              n[2] =
                                                                invNorm;
                                                              n[3] =
                                                                crcc *
                                                                  surfaceScale;
                                                          }
                                                          yloc++;
                                                      }
                                                      for (;
                                                           yloc <
                                                             yEnd;
                                                           yloc++) {
                                                          final double[][] NRow =
                                                            N[yloc -
                                                                y];
                                                          int p =
                                                            offset +
                                                            scanStride *
                                                            (yloc -
                                                               srcRect.
                                                                 y);
                                                          int xloc =
                                                            x;
                                                          if (xloc <
                                                                srcRect.
                                                                  x)
                                                              xloc =
                                                                srcRect.
                                                                  x;
                                                          p +=
                                                            xloc -
                                                              srcRect.
                                                                x;
                                                          prcc =
                                                            (pixels[p -
                                                                      scanStride] >>>
                                                               24) *
                                                              pixelScale;
                                                          crcc =
                                                            (pixels[p] >>>
                                                               24) *
                                                              pixelScale;
                                                          nrcc =
                                                            (pixels[p +
                                                                      scanStride] >>>
                                                               24) *
                                                              pixelScale;
                                                          if (xloc !=
                                                                srcRect.
                                                                  x) {
                                                              prpc =
                                                                (pixels[p -
                                                                          scanStridePP] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              crpc =
                                                                (pixels[p -
                                                                          1] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              nrpc =
                                                                (pixels[p +
                                                                          scanStrideMM] >>>
                                                                   24) *
                                                                  pixelScale;
                                                          }
                                                          else
                                                              if (xloc <
                                                                    xEnd) {
                                                                  crnc =
                                                                    (pixels[p +
                                                                              1] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  prnc =
                                                                    (pixels[p -
                                                                              scanStrideMM] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  nrnc =
                                                                    (pixels[p +
                                                                              scanStridePP] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  final double[] n =
                                                                    NRow[xloc -
                                                                           x];
                                                                  n[0] =
                                                                    -halfSurfaceScaleX *
                                                                      (prnc +
                                                                         2 *
                                                                         crnc +
                                                                         nrnc -
                                                                         (prcc +
                                                                            2 *
                                                                            crcc +
                                                                            nrcc));
                                                                  n[1] =
                                                                    -thirdSurfaceScaleY *
                                                                      (2 *
                                                                         prcc +
                                                                         prnc -
                                                                         (2 *
                                                                            crcc +
                                                                            crnc));
                                                                  invNorm =
                                                                    1.0 /
                                                                      java.lang.Math.
                                                                      sqrt(
                                                                        n[0] *
                                                                          n[0] +
                                                                          n[1] *
                                                                          n[1] +
                                                                          1);
                                                                  n[0] *=
                                                                    invNorm;
                                                                  n[1] *=
                                                                    invNorm;
                                                                  n[2] =
                                                                    invNorm;
                                                                  n[3] =
                                                                    crcc *
                                                                      surfaceScale;
                                                                  p++;
                                                                  xloc++;
                                                                  prpc =
                                                                    prcc;
                                                                  crpc =
                                                                    crcc;
                                                                  nrpc =
                                                                    nrcc;
                                                                  prcc =
                                                                    prnc;
                                                                  crcc =
                                                                    crnc;
                                                                  nrcc =
                                                                    nrnc;
                                                              }
                                                              else {
                                                                  prpc =
                                                                    prcc;
                                                                  crpc =
                                                                    crcc;
                                                                  nrpc =
                                                                    nrcc;
                                                              }
                                                          for (;
                                                               xloc <
                                                                 xEnd;
                                                               xloc++) {
                                                              prnc =
                                                                (pixels[p -
                                                                          scanStrideMM] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              crnc =
                                                                (pixels[p +
                                                                          1] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              nrnc =
                                                                (pixels[p +
                                                                          scanStridePP] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              final double[] n =
                                                                NRow[xloc -
                                                                       x];
                                                              n[0] =
                                                                -quarterSurfaceScaleX *
                                                                  (prnc +
                                                                     2 *
                                                                     crnc +
                                                                     nrnc -
                                                                     (prpc +
                                                                        2 *
                                                                        crpc +
                                                                        nrpc));
                                                              n[1] =
                                                                -quarterSurfaceScaleY *
                                                                  (nrpc +
                                                                     2 *
                                                                     nrcc +
                                                                     nrnc -
                                                                     (prpc +
                                                                        2 *
                                                                        prcc +
                                                                        prnc));
                                                              invNorm =
                                                                1.0 /
                                                                  java.lang.Math.
                                                                  sqrt(
                                                                    n[0] *
                                                                      n[0] +
                                                                      n[1] *
                                                                      n[1] +
                                                                      1);
                                                              n[0] *=
                                                                invNorm;
                                                              n[1] *=
                                                                invNorm;
                                                              n[2] =
                                                                invNorm;
                                                              n[3] =
                                                                crcc *
                                                                  surfaceScale;
                                                              p++;
                                                              prpc =
                                                                prcc;
                                                              crpc =
                                                                crcc;
                                                              nrpc =
                                                                nrcc;
                                                              prcc =
                                                                prnc;
                                                              crcc =
                                                                crnc;
                                                              nrcc =
                                                                nrnc;
                                                          }
                                                          if (xloc <
                                                                x +
                                                                w &&
                                                                xloc ==
                                                                srcRect.
                                                                  x +
                                                                srcRect.
                                                                  width -
                                                                1) {
                                                              final double[] n =
                                                                NRow[xloc -
                                                                       x];
                                                              n[0] =
                                                                -halfSurfaceScaleX *
                                                                  (prcc +
                                                                     2 *
                                                                     crcc +
                                                                     nrcc -
                                                                     (prpc +
                                                                        2 *
                                                                        crpc +
                                                                        nrpc));
                                                              n[1] =
                                                                -thirdSurfaceScaleY *
                                                                  (nrpc +
                                                                     2 *
                                                                     nrcc -
                                                                     (prpc +
                                                                        2 *
                                                                        prcc));
                                                              invNorm =
                                                                1.0 /
                                                                  java.lang.Math.
                                                                  sqrt(
                                                                    n[0] *
                                                                      n[0] +
                                                                      n[1] *
                                                                      n[1] +
                                                                      1);
                                                              n[0] *=
                                                                invNorm;
                                                              n[1] *=
                                                                invNorm;
                                                              n[2] =
                                                                invNorm;
                                                              n[3] =
                                                                crcc *
                                                                  surfaceScale;
                                                          }
                                                      }
                                                      if (yloc <
                                                            y +
                                                            h &&
                                                            yloc ==
                                                            srcRect.
                                                              y +
                                                            srcRect.
                                                              height -
                                                            1) {
                                                          final double[][] NRow =
                                                            N[yloc -
                                                                y];
                                                          int p =
                                                            offset +
                                                            scanStride *
                                                            (yloc -
                                                               srcRect.
                                                                 y);
                                                          int xloc =
                                                            x;
                                                          if (xloc <
                                                                srcRect.
                                                                  x)
                                                              xloc =
                                                                srcRect.
                                                                  x;
                                                          p +=
                                                            xloc -
                                                              srcRect.
                                                                x;
                                                          crcc =
                                                            (pixels[p] >>>
                                                               24) *
                                                              pixelScale;
                                                          prcc =
                                                            (pixels[p -
                                                                      scanStride] >>>
                                                               24) *
                                                              pixelScale;
                                                          if (xloc !=
                                                                srcRect.
                                                                  x) {
                                                              prpc =
                                                                (pixels[p -
                                                                          scanStridePP] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              crpc =
                                                                (pixels[p -
                                                                          1] >>>
                                                                   24) *
                                                                  pixelScale;
                                                          }
                                                          else
                                                              if (xloc <
                                                                    xEnd) {
                                                                  crnc =
                                                                    (pixels[p +
                                                                              1] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  prnc =
                                                                    (pixels[p -
                                                                              scanStrideMM] >>>
                                                                       24) *
                                                                      pixelScale;
                                                                  final double[] n =
                                                                    NRow[xloc -
                                                                           x];
                                                                  n[0] =
                                                                    -twoThirdSurfaceScaleX *
                                                                      (2 *
                                                                         crnc +
                                                                         prnc -
                                                                         2 *
                                                                         crcc -
                                                                         prcc);
                                                                  n[1] =
                                                                    -twoThirdSurfaceScaleY *
                                                                      (2 *
                                                                         crcc +
                                                                         crnc -
                                                                         2 *
                                                                         prcc -
                                                                         prnc);
                                                                  invNorm =
                                                                    1.0 /
                                                                      java.lang.Math.
                                                                      sqrt(
                                                                        n[0] *
                                                                          n[0] +
                                                                          n[1] *
                                                                          n[1] +
                                                                          1);
                                                                  n[0] *=
                                                                    invNorm;
                                                                  n[1] *=
                                                                    invNorm;
                                                                  n[2] =
                                                                    invNorm;
                                                                  n[3] =
                                                                    crcc *
                                                                      surfaceScale;
                                                                  p++;
                                                                  xloc++;
                                                                  crpc =
                                                                    crcc;
                                                                  prpc =
                                                                    prcc;
                                                                  crcc =
                                                                    crnc;
                                                                  prcc =
                                                                    prnc;
                                                              }
                                                              else {
                                                                  crpc =
                                                                    crcc;
                                                                  prpc =
                                                                    prcc;
                                                              }
                                                          for (;
                                                               xloc <
                                                                 xEnd;
                                                               xloc++) {
                                                              crnc =
                                                                (pixels[p +
                                                                          1] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              prnc =
                                                                (pixels[p -
                                                                          scanStrideMM] >>>
                                                                   24) *
                                                                  pixelScale;
                                                              final double[] n =
                                                                NRow[xloc -
                                                                       x];
                                                              n[0] =
                                                                -thirdSurfaceScaleX *
                                                                  (2 *
                                                                     crnc +
                                                                     prnc -
                                                                     (2 *
                                                                        crpc +
                                                                        prpc));
                                                              n[1] =
                                                                -halfSurfaceScaleY *
                                                                  (crpc +
                                                                     2 *
                                                                     crcc +
                                                                     crnc -
                                                                     (prpc +
                                                                        2 *
                                                                        prcc +
                                                                        prnc));
                                                              invNorm =
                                                                1.0 /
                                                                  java.lang.Math.
                                                                  sqrt(
                                                                    n[0] *
                                                                      n[0] +
                                                                      n[1] *
                                                                      n[1] +
                                                                      1);
                                                              n[0] *=
                                                                invNorm;
                                                              n[1] *=
                                                                invNorm;
                                                              n[2] =
                                                                invNorm;
                                                              n[3] =
                                                                crcc *
                                                                  surfaceScale;
                                                              p++;
                                                              crpc =
                                                                crcc;
                                                              prpc =
                                                                prcc;
                                                              crcc =
                                                                crnc;
                                                              prcc =
                                                                prnc;
                                                          }
                                                          if (xloc <
                                                                x +
                                                                w &&
                                                                xloc ==
                                                                srcRect.
                                                                  x +
                                                                srcRect.
                                                                  width -
                                                                1) {
                                                              final double[] n =
                                                                NRow[xloc -
                                                                       x];
                                                              n[0] =
                                                                -twoThirdSurfaceScaleX *
                                                                  (2 *
                                                                     crcc +
                                                                     prcc -
                                                                     (2 *
                                                                        crpc +
                                                                        prpc));
                                                              n[1] =
                                                                -twoThirdSurfaceScaleY *
                                                                  (2 *
                                                                     crcc +
                                                                     crpc -
                                                                     (2 *
                                                                        prcc +
                                                                        prpc));
                                                              invNorm =
                                                                1.0 /
                                                                  java.lang.Math.
                                                                  sqrt(
                                                                    n[0] *
                                                                      n[0] +
                                                                      n[1] *
                                                                      n[1] +
                                                                      1);
                                                              n[0] *=
                                                                invNorm;
                                                              n[1] *=
                                                                invNorm;
                                                              n[2] =
                                                                invNorm;
                                                              n[3] =
                                                                crcc *
                                                                  surfaceScale;
                                                          }
                                                      }
                                                      return N;
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
       "SCwAAA==");
}
