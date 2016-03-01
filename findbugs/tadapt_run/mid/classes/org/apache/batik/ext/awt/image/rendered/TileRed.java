package org.apache.batik.ext.awt.image.rendered;
public class TileRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed implements org.apache.batik.ext.awt.image.rendered.TileGenerator {
    static final java.awt.geom.AffineTransform IDENTITY = new java.awt.geom.AffineTransform(
      );
    java.awt.Rectangle tiledRegion;
    int xStep;
    int yStep;
    org.apache.batik.ext.awt.image.rendered.TileStore tiles;
    private java.awt.RenderingHints hints;
    final boolean is_INT_PACK;
    java.awt.image.RenderedImage tile = null;
    java.awt.image.WritableRaster raster = null;
    public TileRed(java.awt.image.RenderedImage tile, java.awt.Rectangle tiledRegion) {
        this(
          tile,
          tiledRegion,
          tile.
            getWidth(
              ),
          tile.
            getHeight(
              ),
          null);
    }
    public TileRed(java.awt.image.RenderedImage tile, java.awt.Rectangle tiledRegion,
                   java.awt.RenderingHints hints) {
        this(
          tile,
          tiledRegion,
          tile.
            getWidth(
              ),
          tile.
            getHeight(
              ),
          hints);
    }
    public TileRed(java.awt.image.RenderedImage tile,
                   java.awt.Rectangle tiledRegion,
                   int xStep,
                   int yStep) { this(tile, tiledRegion,
                                     xStep,
                                     yStep,
                                     null); }
    public TileRed(java.awt.image.RenderedImage tile,
                   java.awt.Rectangle tiledRegion,
                   int xStep,
                   int yStep,
                   java.awt.RenderingHints hints) {
        super(
          );
        if (tiledRegion ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (tile ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          tiledRegion =
          tiledRegion;
        this.
          xStep =
          xStep;
        this.
          yStep =
          yStep;
        this.
          hints =
          hints;
        java.awt.image.SampleModel sm =
          fixSampleModel(
            tile,
            xStep,
            yStep,
            tiledRegion.
              width,
            tiledRegion.
              height);
        java.awt.image.ColorModel cm =
          tile.
          getColorModel(
            );
        double smSz =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
        smSz =
          smSz *
            smSz;
        double stepSz =
          xStep *
          (double)
            yStep;
        if (16.1 *
              smSz >
              stepSz) {
            int xSz =
              xStep;
            int ySz =
              yStep;
            if (4 *
                  stepSz <=
                  smSz) {
                int mult =
                  (int)
                    java.lang.Math.
                    ceil(
                      java.lang.Math.
                        sqrt(
                          smSz /
                            stepSz));
                xSz *=
                  mult;
                ySz *=
                  mult;
            }
            sm =
              sm.
                createCompatibleSampleModel(
                  xSz,
                  ySz);
            raster =
              java.awt.image.Raster.
                createWritableRaster(
                  sm,
                  new java.awt.Point(
                    tile.
                      getMinX(
                        ),
                    tile.
                      getMinY(
                        )));
        }
        is_INT_PACK =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            is_INT_PACK_Data(
              sm,
              false);
        init(
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            null,
          tiledRegion,
          cm,
          sm,
          tile.
            getMinX(
              ),
          tile.
            getMinY(
              ),
          null);
        if (raster !=
              null) {
            java.awt.image.WritableRaster fromRaster =
              raster.
              createWritableChild(
                tile.
                  getMinX(
                    ),
                tile.
                  getMinY(
                    ),
                xStep,
                yStep,
                tile.
                  getMinX(
                    ),
                tile.
                  getMinY(
                    ),
                null);
            fillRasterFrom(
              fromRaster,
              tile);
            fillOutRaster(
              raster);
        }
        else {
            this.
              tile =
              new org.apache.batik.ext.awt.image.rendered.TileCacheRed(
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  wrap(
                    tile));
        }
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        int xOff =
          (int)
            java.lang.Math.
            floor(
              wr.
                getMinX(
                  ) /
                xStep) *
          xStep;
        int yOff =
          (int)
            java.lang.Math.
            floor(
              wr.
                getMinY(
                  ) /
                yStep) *
          yStep;
        int x0 =
          wr.
          getMinX(
            ) -
          xOff;
        int y0 =
          wr.
          getMinY(
            ) -
          yOff;
        int tx0 =
          getXTile(
            x0);
        int ty0 =
          getYTile(
            y0);
        int tx1 =
          getXTile(
            x0 +
              wr.
              getWidth(
                ) -
              1);
        int ty1 =
          getYTile(
            y0 +
              wr.
              getHeight(
                ) -
              1);
        for (int y =
               ty0;
             y <=
               ty1;
             y++)
            for (int x =
                   tx0;
                 x <=
                   tx1;
                 x++) {
                java.awt.image.Raster r =
                  getTile(
                    x,
                    y);
                r =
                  r.
                    createChild(
                      r.
                        getMinX(
                          ),
                      r.
                        getMinY(
                          ),
                      r.
                        getWidth(
                          ),
                      r.
                        getHeight(
                          ),
                      r.
                        getMinX(
                          ) +
                        xOff,
                      r.
                        getMinY(
                          ) +
                        yOff,
                      null);
                if (is_INT_PACK)
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      copyData_INT_PACK(
                        r,
                        wr);
                else
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      copyData_FALLBACK(
                        r,
                        wr);
            }
        return wr;
    }
    public java.awt.image.Raster getTile(int x,
                                         int y) {
        if (raster !=
              null) {
            int tx =
              tileGridXOff +
              x *
              tileWidth;
            int ty =
              tileGridYOff +
              y *
              tileHeight;
            return raster.
              createTranslatedChild(
                tx,
                ty);
        }
        return genTile(
                 x,
                 y);
    }
    public java.awt.image.Raster genTile(int x,
                                         int y) {
        int tx =
          tileGridXOff +
          x *
          tileWidth;
        int ty =
          tileGridYOff +
          y *
          tileHeight;
        if (raster !=
              null) {
            return raster.
              createTranslatedChild(
                tx,
                ty);
        }
        java.awt.Point pt =
          new java.awt.Point(
          tx,
          ty);
        java.awt.image.WritableRaster wr =
          java.awt.image.Raster.
          createWritableRaster(
            sm,
            pt);
        fillRasterFrom(
          wr,
          tile);
        return wr;
    }
    public java.awt.image.WritableRaster fillRasterFrom(java.awt.image.WritableRaster wr,
                                                        java.awt.image.RenderedImage src) {
        java.awt.image.ColorModel cm =
          getColorModel(
            );
        java.awt.image.BufferedImage bi =
          new java.awt.image.BufferedImage(
          cm,
          wr.
            createWritableTranslatedChild(
              0,
              0),
          cm.
            isAlphaPremultiplied(
              ),
          null);
        java.awt.Graphics2D g =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          createGraphics(
            bi,
            hints);
        int minX =
          wr.
          getMinX(
            );
        int minY =
          wr.
          getMinY(
            );
        int maxX =
          wr.
          getWidth(
            );
        int maxY =
          wr.
          getHeight(
            );
        g.
          setComposite(
            java.awt.AlphaComposite.
              Clear);
        g.
          setColor(
            new java.awt.Color(
              0,
              0,
              0,
              0));
        g.
          fillRect(
            0,
            0,
            maxX,
            maxY);
        g.
          setComposite(
            java.awt.AlphaComposite.
              SrcOver);
        g.
          translate(
            -minX,
            -minY);
        int x1 =
          src.
          getMinX(
            ) +
          src.
          getWidth(
            ) -
          1;
        int y1 =
          src.
          getMinY(
            ) +
          src.
          getHeight(
            ) -
          1;
        int tileTx =
          (int)
            java.lang.Math.
            ceil(
              (minX -
                 x1) /
                xStep) *
          xStep;
        int tileTy =
          (int)
            java.lang.Math.
            ceil(
              (minY -
                 y1) /
                yStep) *
          yStep;
        g.
          translate(
            tileTx,
            tileTy);
        int curX =
          tileTx -
          wr.
          getMinX(
            ) +
          src.
          getMinX(
            );
        int curY =
          tileTy -
          wr.
          getMinY(
            ) +
          src.
          getMinY(
            );
        minX =
          curX;
        while (curY <
                 maxY) {
            if (org.apache.batik.util.HaltingThread.
                  hasBeenHalted(
                    ))
                return wr;
            while (curX <
                     maxX) {
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  drawImage(
                    g,
                    src);
                curX +=
                  xStep;
                g.
                  translate(
                    xStep,
                    0);
            }
            curY +=
              yStep;
            g.
              translate(
                minX -
                  curX,
                yStep);
            curX =
              minX;
        }
        return wr;
    }
    protected void fillOutRaster(java.awt.image.WritableRaster wr) {
        if (is_INT_PACK)
            fillOutRaster_INT_PACK(
              wr);
        else
            fillOutRaster_FALLBACK(
              wr);
    }
    protected void fillOutRaster_INT_PACK(java.awt.image.WritableRaster wr) {
        int x0 =
          wr.
          getMinX(
            );
        int y0 =
          wr.
          getMinY(
            );
        int width =
          wr.
          getWidth(
            );
        int height =
          wr.
          getHeight(
            );
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int scanStride =
          sppsm.
          getScanlineStride(
            );
        java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int[] pixels =
          db.
          getBankData(
            )[0];
        final int base =
          db.
          getOffset(
            ) +
          sppsm.
          getOffset(
            x0 -
              wr.
              getSampleModelTranslateX(
                ),
            y0 -
              wr.
              getSampleModelTranslateY(
                ));
        int step =
          xStep;
        for (int x =
               xStep;
             x <
               width;
             x +=
               step,
               step *=
                 2) {
            int w =
              step;
            if (x +
                  w >
                  width)
                w =
                  width -
                    x;
            if (w >=
                  128) {
                int srcSP =
                  base;
                int dstSP =
                  base +
                  x;
                for (int y =
                       0;
                     y <
                       yStep;
                     y++) {
                    java.lang.System.
                      arraycopy(
                        pixels,
                        srcSP,
                        pixels,
                        dstSP,
                        w);
                    srcSP +=
                      scanStride;
                    dstSP +=
                      scanStride;
                }
            }
            else {
                int srcSP =
                  base;
                int dstSP =
                  base +
                  x;
                for (int y =
                       0;
                     y <
                       yStep;
                     y++) {
                    int end =
                      srcSP;
                    srcSP +=
                      w -
                        1;
                    dstSP +=
                      w -
                        1;
                    while (srcSP >=
                             end)
                        pixels[dstSP--] =
                          pixels[srcSP--];
                    srcSP +=
                      scanStride +
                        1;
                    dstSP +=
                      scanStride +
                        1;
                }
            }
        }
        step =
          yStep;
        for (int y =
               yStep;
             y <
               height;
             y +=
               step,
               step *=
                 2) {
            int h =
              step;
            if (y +
                  h >
                  height)
                h =
                  height -
                    y;
            int dstSP =
              base +
              y *
              scanStride;
            java.lang.System.
              arraycopy(
                pixels,
                base,
                pixels,
                dstSP,
                h *
                  scanStride);
        }
    }
    protected void fillOutRaster_FALLBACK(java.awt.image.WritableRaster wr) {
        int width =
          wr.
          getWidth(
            );
        int height =
          wr.
          getHeight(
            );
        java.lang.Object data =
          null;
        int step =
          xStep;
        for (int x =
               xStep;
             x <
               width;
             x +=
               step,
               step *=
                 4) {
            int w =
              step;
            if (x +
                  w >
                  width)
                w =
                  width -
                    x;
            data =
              wr.
                getDataElements(
                  0,
                  0,
                  w,
                  yStep,
                  data);
            wr.
              setDataElements(
                x,
                0,
                w,
                yStep,
                data);
            x +=
              w;
            if (x >=
                  width)
                break;
            if (x +
                  w >
                  width)
                w =
                  width -
                    x;
            wr.
              setDataElements(
                x,
                0,
                w,
                yStep,
                data);
            x +=
              w;
            if (x >=
                  width)
                break;
            if (x +
                  w >
                  width)
                w =
                  width -
                    x;
            wr.
              setDataElements(
                x,
                0,
                w,
                yStep,
                data);
        }
        step =
          yStep;
        for (int y =
               yStep;
             y <
               height;
             y +=
               step,
               step *=
                 4) {
            int h =
              step;
            if (y +
                  h >
                  height)
                h =
                  height -
                    y;
            data =
              wr.
                getDataElements(
                  0,
                  0,
                  width,
                  h,
                  data);
            wr.
              setDataElements(
                0,
                y,
                width,
                h,
                data);
            y +=
              h;
            if (h >=
                  height)
                break;
            if (y +
                  h >
                  height)
                h =
                  height -
                    y;
            wr.
              setDataElements(
                0,
                y,
                width,
                h,
                data);
            y +=
              h;
            if (h >=
                  height)
                break;
            if (y +
                  h >
                  height)
                h =
                  height -
                    y;
            wr.
              setDataElements(
                0,
                y,
                width,
                h,
                data);
            y +=
              h;
        }
    }
    protected static java.awt.image.SampleModel fixSampleModel(java.awt.image.RenderedImage src,
                                                               int stepX,
                                                               int stepY,
                                                               int width,
                                                               int height) {
        int defSz =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        int w =
          sm.
          getWidth(
            );
        if (w <
              defSz)
            w =
              defSz;
        if (w >
              stepX)
            w =
              stepX;
        int h =
          sm.
          getHeight(
            );
        if (h <
              defSz)
            h =
              defSz;
        if (h >
              stepY)
            h =
              stepY;
        return sm.
          createCompatibleSampleModel(
            w,
            h);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OuO22fnLuQ+u/tH+V7hTcgrzC+MtZrtirHi84XgODksKvTgI1WevMs5yGf5c" +
       "icMqx+BzPQZHf4B2qxc6OpNPHS1h9T4cuvmrDhzWWSG25uQ0hw+6gtQxaMs0" +
       "OHV1BKH6BCm3SppHHei9nuKGq6ShTMJkA4achmw1bvdwh5smt/2ucme3058V" +
       "Q7EgLzP7nvlV7xtxng2rsAjic5ys1lPeOo1RTyqutwT6FP4EuD7BCwXBB1Y3" +
       "1Nhlt2QLcj2ZrmNwLC6xiMoXIbKr8dWtd715nyWCv2f1AdM9Ezd9Gt47YaU4" +
       "q7E/u6C39uJYzb0lDg4jyN3CUrNwjJ43Du/69Y933Whx1Zjfpq6DVdh9f/7v" +
       "U+Hb//pEkc6nTLYXZ2hawcr8vNf1WccSqWL53f/e/a1j/VBeo6Qqo8rbMjSa" +
       "9NKElYmZSXjM5S4Z+AOvcGgaRoQlYAV8sImPG0vEjYzD5W7cDJ6+uLnKdv6r" +
       "ph43Qag+QaZxPqa5ccNlzg3r+UxGCel5hUy70qtTl97COJM/qzZxQe1vSvmu" +
       "iNtPvfvSna//ZvKHlZZrlQgUH17zf/qVxA2vfVhQqXj7WCR2fPgjkUN3tXSt" +
       "eYfju30cYp+dLezzodN1cT9/MP2vUFvF70OkcoTUS/YOxEZRyWB3NAKrbtPZ" +
       "loiR2rz3+Stoa7nYketT5/mD1zOtv4P0RkQ5y/N+t2lsQNOshet824XO93uf" +
       "QPjNbssB+bgYh6VWfwI9msm3OBjMLqui4uvV6kvQZqQq2r1uw3B0eJNT0Obn" +
       "Ctoo1dLhzhTQpMOGqJrYD7uRwN3vuhO53458XlrgWmnzsjJAzm8Xl5P4xCov" +
       "QYqR6ZD2aHKQjtp98iof49+ZIuMz4Vplz7YqgPF9bobYW8hrEDZYLTvEqJ5L" +
       "Ah4uJ06BywvteS4M4PKOklwGYQOXO4K4vHOKXOLNxfY8Fwdw+f2SXAZhA5do" +
       "d9Px5eVTWdIPQRNLfaL94ORFm4FP2+BabTO3OkC0g8X9G9Zalbohj0NL4vP0" +
       "6SWIgsRjTvVe72P+pyfPPJYw0grXGnueNQHM/zyAebz9ho/v6hL0IEJlMx7d" +
       "MBwf6Oy6jONdicOIReNqz/0WUExC0xQqqv4mBX+msj6xH5yiOy6Eq8tmsytA" +
       "7CMl3TEIm0HWt/fuVvqYfOwUmOy2p+kOYPJoSSaDsKF8GKLJqFFYAKwgudKQ" +
       "GS64BzmUT47HS8iRLdYx8b8K4tum9PDj6U4Eh6WVU4lju7HXDGyc5wftQ/Om" +
       "+cANE/uT/fcuD9ndlchgEavpyxQ6ThUPI1W8Bfe3SX18993tOVY9N1n20i3N" +
       "Mwq37ZBSa8Cm3JLgfso/wdEb3m4ZXjO2ZQr7cWf55PeT/EnfoScuPUe6JcQP" +
       "EKwWp+DgIR+pI7+xqTEoyxhqfnPflrM3VnyeFu+x7X2P33tdjwpqroNQfX2y" +
       "Jyk8xam+VqKR/jsOL0P/g2dx3SITOZrr2K+c4rLihRz7uKIgZ8D1sM3+w1OX" +
       "PAjVJ5i9U4U/rcUEJ/2PEuK/j8NbkFlHKcOgcSJtjn+Ty00NXC1vnz61HLVl" +
       "Ozp1tQShnpRaPi6hlk9wmORqUYft1P1PV/oPP7P0PBw+B9cxW4RjU5c+CDVY" +
       "+qd4CULSQlWw9EINDmWMzEzJimJZvsfQ0vmRIZR/ZiVgm4pQwiKLgvU/QAlF" +
       "+qRq3dAYrMpo0tdx1JageYJkITSVUEwzDnWM1KJi+jPMExW+TqV8XJOTrq7q" +
       "T4+uoOsTltlyLSvtMEJjoUqCUE+kkkUlVHIuDgsYacpTSa6jw7ctrh4Wnj49" +
       "JGxhElPXQxDqifSwvIQeVuCwtEAPPZ2x2NpCPSz7zHrARhB7JmHCFmZiCrGD" +
       "yUCYhb+/7ouc2SUo+qT372Ft8g1cLWtKqOwSHC7kaSY7JKZ1heLmouKUoBZf" +
       "CfKDcEVedAr7XpDW7aNbPHhoLviOxPr2Qbp/f13V3P1X/IUfH+a+T5gRI1Wp" +
       "jKJ4t3Q89xW6QUEcDmlt8PD9TCHKyLkn2bxCL+LcogRCr0UhxkhraQqwBpSd" +
       "MygHq5+R5iAsRspg9EIPMjK7GDRAwuiFvIKRej8kzM//e+GuYqTGhYM1hnXj" +
       "BdkM1AEEb6/WHeOvONlOvzNhMkOUGFgzK3hadXvVwcv1nBM5SQ7Fe0CKE/JP" +
       "kZyWOWN9jBSXDu9fv+Erx79wr3VAKynizp1IZXqMVFpnxbm2e2EgNYdWRe/i" +
       "j2Y+UL3IWXo0WAy7wXumpy2BhaWgo9O2+E4vzfbcIeYLB1Y/+vSeiudCRNhM" +
       "BFjJzNpcuI2Z1TOwJtgcK7azD4sSfrDaUfP6lmc+fFFo5EduxDoLaC2FEZf2" +
       "PfrSQErX7wiR6ih4I9goy/dYu3eog1QaN/IOCioSWkbNfbU0EyNMxHMzrhlb" +
       "obW5p3jAz0hb4ZlJ4UcPNYq2nRprkTqSqfUtVDK67n3LNUut8o2aBneMx/p0" +
       "3T4sqrica17XMXsI/KOb1P8AmhcqHW8oAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "u052y246wnhjphdu3CO7EqhRHDj8DTtl");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("T5zo5fHjNf+f3evlZw+Xh081f+uF9Q/uLOdgq/ToVODLhcA3brOX+od58l8i" +
       "6LLsehtUiqQi26m1/cEd7yl//YRgvp0MvQdcv7Yn+GtvD8H9MZr8cbdtXEj9" +
       "z9uw/E6e/I8IukcHEWu+x7O38ocPT+CcrrMX7L/1drD/yp79V/4C2R9dOJ/9" +
       "UXEY408K9g6/39b441OSf/oWSBY2/EFwfXVP8qtvO8kv50m5IHL/bUhezZN7" +
       "I+h+zbSsnR77gWvfaM5HV94C13y/E6oB2M/t8u5+3yxX4Oe8wI1UOVKVN9Vt" +
       "j77nNmyfyBNgwO/M2VJxdMZwDzcgEtdUThvgkbfaAC8CjB/ZN8BH7lDZR+95" +
       "c8yfvw3zD+fJcxH0yA3MT7YV869PndL9wNtBd7mnu/wLotu4Dd1WnlRuotvv" +
       "jMfdm+lW3wLdfKMyDw2OXtnTfeUO6F4o6ObP0S05H5754Q6SguttTsMdoXny" +
       "0aJ7Z5xke5Y6cZV9xPBwvit3oyM/FCla545O0GXAX+4PRuenPB+76b80dv9Z" +
       "IP/iqw9cfvRV4d8XZ4NPTv/fO4Yua7FlnT0xc+b+kheogEghuTs/4xUsJxH0" +
       "vW8y8AJD9vFtjv1ovCuBjqAnb19CBF00jw+YHufiIuix83JF0F0gPSsNvMq7" +
       "byUNJEF6VnIRQVcPJUH9xe9ZuR+IoCunchF0aXdzVuQ6KB2I5Lcvecdqr73Z" +
       "KLWzDKNAkiOgzezoTJi57wXFOPjQG5nHSZazp5/zCot/9DkOI+Pdv/pcl7/0" +
       "6oj8xLcbP7c7fS1b0nabl3J5DN2zOwh+Eoo+fW5px2VdGn7ou/f/0r3PHYfN" +
       "9+8An/bIM9ieuvVRZ8z2ouJw8vZXH/0nL/79V3+/2An/fw27jqyBNQAA");
}
