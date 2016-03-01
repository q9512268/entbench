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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "r61gLAAA");
}
