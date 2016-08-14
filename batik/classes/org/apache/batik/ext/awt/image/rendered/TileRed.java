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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+fOP90bFhcLTM7YvfeIPH2c/pr90B5eT");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("njrAeVjkPxi99lv9D0h/40LprpMTt5uuOt6Y6YUbz9muhEqchC57w2nbEyf9" +
       "8vjxucHP7fvl5w63mE97/tab8x/cac7BcevRqcAXC4Gv3eY89g/z6L/GpcuS" +
       "52cdMRaLbKfa9gd3fC791ROC+ZF06T0g/Nqe4K+9PQT3V3Hyn7uj50Lqf92G" +
       "5bfy6H/GpXs0Jc4V9ljLHz68xXO6V1+w/8bbwf5Le/Zf+gtkf3ThfPZHxYWO" +
       "PynYu+z+aOTbpyT/9C2QLHT4gyB8eU/yy287yS/mUbkgcv9tSF7No3vj0v2q" +
       "Ydu7fuyFnnOjOh9deQtc8zPTUg3Afm6Xd/f9ZrkCO+eHXqxIsSK/qWF79F23" +
       "YftEHgEFfmfOdpLEZxT38BBj7RnyaQM88lYb4EWA8SP7BvjIHXb20XveHPPn" +
       "b8P8w3n0XFx65AbmJ0eT+dunTul+4O2gu9rTXf0F0W3chm4zjyo30e1hFNW+" +
       "mW71LdDNDztz1+DolT3dV+6A7oWCbv47viXnw3tDzEFUcL3NjbqjTh59tBje" +
       "KSM6vq2MPHnvMTycn+zdaMgPRYrWuaNbeCmwl/vL1flN0cdu+jfH7h8I0i+9" +
       "+sDlR1/l/kNxv/jkXwL3UqXLamLbZ2/dnHm+5IcKIFJI7u7g+AXLUVz67jfp" +
       "eIEp+/gxx35E7UqYxqUnb19CXLpoHF9SPc7FxKXHzssVl+4C8VlpYFXefStp" +
       "IAnis5LLuHT1UBLUX3yflfv+uHTlVC4uXdo9nBW5DkoHIvnjS/5xt9ferJeK" +
       "raI4FKUY9GZ6dMbN3I+CYh586I3U4yTL2RvUeYXFH4KO3chk95eg69IXXh2O" +
       "P/7Nxs/vbnBLtrjd5qVcpkr37C6Tn7iiT59b2nFZlwYf+s79v3zvc8du8/07" +
       "wKcj8gy2p259Xbrr+HFxwXn7Tx/9Jy/+vVd/vzhN/3/QuBRWqTUAAA==");
}
