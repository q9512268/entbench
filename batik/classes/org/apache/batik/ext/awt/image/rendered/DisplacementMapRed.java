package org.apache.batik.ext.awt.image.rendered;
public class DisplacementMapRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    private static final boolean TIME = false;
    private static final boolean USE_NN = false;
    private float scaleX;
    private float scaleY;
    private org.apache.batik.ext.awt.image.ARGBChannel xChannel;
    private org.apache.batik.ext.awt.image.ARGBChannel yChannel;
    org.apache.batik.ext.awt.image.rendered.CachableRed image;
    org.apache.batik.ext.awt.image.rendered.CachableRed offsets;
    int maxOffX;
    int maxOffY;
    java.awt.RenderingHints hints;
    org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets[]
      xOffsets;
    org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets[]
      yOffsets;
    static class TileOffsets {
        int[] tile;
        int[] off;
        TileOffsets(int len, int base, int stride, int loc, int endLoc, int slop,
                    int tile,
                    int endTile) { super();
                                   this.tile = (new int[len + 1]);
                                   this.off = (new int[len + 1]);
                                   if (tile == endTile) endLoc -=
                                                          slop;
                                   for (int i = 0; i < len; i++) {
                                       this.
                                         tile[i] =
                                         tile;
                                       this.
                                         off[i] =
                                         base +
                                           loc *
                                           stride;
                                       loc++;
                                       if (loc ==
                                             endLoc) {
                                           loc =
                                             0;
                                           tile++;
                                           if (tile ==
                                                 endTile)
                                               endLoc -=
                                                 slop;
                                       }
                                   }
                                   this.tile[len] = this.tile[len -
                                                                1];
                                   this.off[len] = this.off[len -
                                                              1];
        }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YC2wU1xV9u/6w/n/4OYAN2IaIT3dKfiQ1IQFjg8kaHEyQ" +
                                                                  "Yj7L7Ozb3cGzM8PMW3vthHyQWmilIkoJIVGwKoUEgvhEUaK2apM6ikoSJY0U" +
                                                                  "QpumUaA/tbQUFVQ1rUrb9L73ZnY+u2uaqu1K+3b2zX333fvuvefe+05eQWWm" +
                                                                  "gVqwSsJkRMdmuEslfaJh4ninIprmRpiLSk+WiH/admndXUFUPoBqU6LZK4km" +
                                                                  "7paxEjcHULOsmkRUJWyuwzhOV/QZ2MTGkEhkTR1AU2WzJ60rsiSTXi2OKcEm" +
                                                                  "0YigBpEQQ45lCO6xGBDUHAFJBCaJsML/uiOCqiVNH3HIm1zkna43lDLt7GUS" +
                                                                  "VB/ZIQ6JQobIihCRTdKRNdAiXVNGkopGwjhLwjuU260jWBu5Pe8IWl+s+/T6" +
                                                                  "/lQ9O4LJoqpqhKlnbsCmpgzheATVObNdCk6bO9EjqCSCqlzEBLVH7E0F2FSA" +
                                                                  "TW1tHSqQvgarmXSnxtQhNqdyXaICETTXy0QXDTFtseljMgOHELF0Z4tB2zk5" +
                                                                  "bbmWeSo+sUg4+OS2+pdKUN0AqpPVfiqOBEIQ2GQADhSnY9gwV8TjOD6AGlQw" +
                                                                  "dj82ZFGRRy1LN5pyUhVJBsxvHwudzOjYYHs6ZwV2BN2MjEQ0I6degjmU9a8s" +
                                                                  "oYhJ0HWaoyvXsJvOg4KVMghmJETwO2tJ6aCsxgma7V+R07H9PiCApZPSmKS0" +
                                                                  "3FalqggTqJG7iCKqSaEfXE9NAmmZBg5oEDSjKFN61rooDYpJHKUe6aPr46+A" +
                                                                  "qoIdBF1C0FQ/GeMEVprhs5LLPlfWLdv3kLpGDaIAyBzHkkLlr4JFLb5FG3AC" +
                                                                  "GxjigC+sXhg5JE57dW8QISCe6iPmNN9++Nq9i1vG3+I0MwvQrI/twBKJSkdj" +
                                                                  "te/P6lxwVwkVI6RrpkyN79GcRVmf9aYjqwPCTMtxpC/D9svxDWcffOwEvhxE" +
                                                                  "lT2oXNKUTBr8qEHS0rqsYGM1VrEhEhzvQRVYjXey9z1oEjxHZBXz2fWJhIlJ" +
                                                                  "DypV2FS5xv7DESWABT2iSniW1YRmP+siSbHnrI4QqoIvqofvFsQ/7JegtJDS" +
                                                                  "0lgQJVGVVU3oMzSqvykA4sTgbFNCDLx+UDC1jAEuKGhGUhDBD1LYekEjUxwm" +
                                                                  "gpwG8wtgjjjYJC6skk1dAadNA59eUd+A42Hqdvr/e8MsPYHJw4EAGGeWHxoo" +
                                                                  "/RpNAQZR6WBmZde109F3uNvRULHOjqBukCHMZQgzGRiQggxhJkPYliGcL0P7" +
                                                                  "RjAOt5yJAgEmxhQqF/cPsO4g4AQAdfWC/q1rt+9tLQHH1IdLwTSUtNWTsDod" +
                                                                  "MLEzQFQ601gzOvfCkjeCqDSCGkWJZESF5p8VRhKQTRq0gr86BqnMyShzXBmF" +
                                                                  "pkJDk3AcAK1YZrG4hLQhbNB5gqa4ONj5jka2UDzbFJQfjR8efnzTo18MoqA3" +
                                                                  "idAtywD/6PI+Cv05iG/3g0chvnV7Ln165tAuzYERT1ayk2neSqpDq99R/McT" +
                                                                  "lRbOEV+JvrqrnR17BcA8ESEsAUFb/Ht4UKrDRnyqSwgUTmhGWlToK/uMK0nK" +
                                                                  "0IadGebBDex5CrhFiIbtZPhGrThmv/TtNJ2O07nHUz/zacEyyt39+pGfvve7" +
                                                                  "W9lx28mnzlU19GPS4QI8yqyRQVuD47YbDYyB7pPDfd984sqezcxngaKt0Ibt" +
                                                                  "dOwEoAMTwjF/+a2dH128cPR8MOfnKOvVLTSBbrDJfEcMwEkFoIM6S/sDKril" +
                                                                  "nJDFmIJpPP29bt6SV/6wr56bX4EZ23sW35iBM3/TSvTYO9v+0sLYBCSap52j" +
                                                                  "csg4+E92OK8wDHGEypF9/FzzU2+KRyCNAHSb8ihmaBxiqoe8IU7DqD8TMyEc" +
                                                                  "5TSc/pCV2G7p2y7tbe/7NU9aNxVYwOmmHhe+vunDHe8y24ZowNN5qneNK5wB" +
                                                                  "GFyOVc8P/zP4BOD7T/qlh04neIJo7LSy1JxcmtL1LEi+YIK60quAsKvx4uAz" +
                                                                  "l05xBfxp3EeM9x782mfhfQe55Xit05ZXbrjX8HqHq0OHO6l0cyfaha3o/u2Z" +
                                                                  "Xd87vmsPl6rRm7m7oDA99ZN/vBs+/PO3C6SEEtmqV2+lSJ3D6yle23CFVn21" +
                                                                  "7vv7G0u6ASp6UCijyjszuCfu5gilmpmJuYzl1FBswq0aNQxBgYVgAzqxdOKB" +
                                                                  "0dzGJBVy8iIr7uj/1XSYZ7pB1WtNV8Eelfafv1qz6epr19iJeCt+N4ZA7uPm" +
                                                                  "aKDDfGqO6f6kt0Y0U0B32/i6LfXK+HXgOAAcJUj55noD0mnWgzgWddmkn73+" +
                                                                  "xrTt75egYDeqVDQx3i0y8EYVgJrYTEEyz+r33MvRYzhklTwoi/KUz5ugETy7" +
                                                                  "MDZ0pXXConn0O9NfXnZs7AJDL53zmMnWB2l94cnWrG90EsaJD5b++Ng3Dg1z" +
                                                                  "b5sgdnzrmv62Xont/uVf846c5ccC4eRbPyCcfGZG5/LLbL2TqOjq9mx+TQTJ" +
                                                                  "3ll7y4n0n4Ot5T8MokkDqF6y+rRNopKh8D8AvYlpN2/Qy3nee/sMXlR35BLx" +
                                                                  "LH88u7b1p0h3mJQST0j4siJ92Gpljq3+rBhA7OFBtuRmOizKzzvFVhPYGSDQ" +
                                                                  "e4WQQ18G9jzWt1Sd/YH57G9e4lYuhO2+puX4sZD0cfosw3a61R05oWqpDA3w" +
                                                                  "tbyZ/xK0+b9UPyexloa2jaSgkEuSlF2e/y/ZUyCYV9zzXec49nzbe4+Otf2C" +
                                                                  "wUJINsE/IG8VaBxda66evHj5XE3zaVaSldL0Z6Gpt+POb6g9fTKzQh0deO+w" +
                                                                  "NA/m6f9+TmA5VYo7FRsX0uELHBMIKtczMUWGuqEsIauiwjjeCdMKOxT67246" +
                                                                  "JHQHj4IWntD/TcQqKmgUQZOsqZjWJ/Y73knIWjh3QQEvswXyUrMHmXqZuk6Y" +
                                                                  "f1J74FffbU+u/DwtBJ1ruUGTQP/PBpstLG5yvyhv7v79jI3LU9s/Rzcw2+cR" +
                                                                  "fpYv9J58e/V86UCQ3YFw/Mm7O/Eu6vCiTqWBScZQvem4zXGRRGHzB+jjIDf5" +
                                                                  "BBn44QnePUKHLHiPRE3PPWUC8sfzkxqduF935b+AI9sqq1Wg4xo6DHDfua9o" +
                                                                  "Au3Pb0O2Wei0rQjgfmVCwC22GiosLZGgj9t9Mu6ZQMZsEUNAwJnsls9pNdjx" +
                                                                  "VCLfdYi71XByO6K41VzsxorVkkd3HxyLr39uiQ3j98CW1kWimw9BVa4LATuM" +
                                                                  "v/Sf3y+AYE15F578kk46PVYXmj72wIccD+2LtGoI0ERGUdxZ1fVcrhs4ITMd" +
                                                                  "qnmO5XXm0wTd/G+KSVDIfmQaPsU5HIHeeGIO4Ofs173qWwQ1FVsFTgKjm/pZ" +
                                                                  "wMRC1EAJo5vyeYLq/ZSwP/t1071AUKVDB1blD26Sk9RZjSR9PKXbNq13YJsX" +
                                                                  "P9mA16NyDj31RkHncsI2D5KyC3Eb9TL8SjwqnRlbu+6ha3c8xzt8SRFHRymX" +
                                                                  "Kshz/LIhh5xzi3KzeZWvWXC99sWKebZbN3CBnZCc6UKf+yHSdFpFz/D1wWZ7" +
                                                                  "rh3+6Oiy1360t/wc5PXNKCBCetucXyZm9QzE2+ZIfjMFWYY16B0Lnh5Zvjjx" +
                                                                  "x49ZIW4luVnF6aPS+WNbPzjQdBQa+aoecDNwzyyrX1eNqBuwNGQMoBrZ7MqC" +
                                                                  "iMAFcqmnU6ulwSPSq3J2LtZx1uRm6f0QQa35TWr+rRo0LcPYWKll1LhVnVQ5" +
                                                                  "M56bejv5ZHTdt8CZcZUsnSzPZHmNWBKN9Oq63cNXvKwzTFtVPAmMs0c6vP4v" +
                                                                  "nNJkhSwbAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8vV8Z+3/AGuWcfT1JQAA");
    }
    public DisplacementMapRed(org.apache.batik.ext.awt.image.rendered.CachableRed image,
                              org.apache.batik.ext.awt.image.rendered.CachableRed offsets,
                              org.apache.batik.ext.awt.image.ARGBChannel xChannel,
                              org.apache.batik.ext.awt.image.ARGBChannel yChannel,
                              float scaleX,
                              float scaleY,
                              java.awt.RenderingHints rh) {
        super(
          );
        if (xChannel ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "Must provide xChannel");
        }
        if (yChannel ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "Must provide yChannel");
        }
        this.
          offsets =
          offsets;
        this.
          scaleX =
          scaleX;
        this.
          scaleY =
          scaleY;
        this.
          xChannel =
          xChannel;
        this.
          yChannel =
          yChannel;
        this.
          hints =
          rh;
        maxOffX =
          (int)
            java.lang.Math.
            ceil(
              scaleX /
                2);
        maxOffY =
          (int)
            java.lang.Math.
            ceil(
              scaleY /
                2);
        java.awt.Rectangle rect =
          image.
          getBounds(
            );
        java.awt.Rectangle r =
          image.
          getBounds(
            );
        r.
          x -=
          maxOffX;
        r.
          width +=
          2 *
            maxOffX;
        r.
          y -=
          maxOffY;
        r.
          height +=
          2 *
            maxOffY;
        image =
          new org.apache.batik.ext.awt.image.rendered.PadRed(
            image,
            r,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD,
            null);
        image =
          new org.apache.batik.ext.awt.image.rendered.TileCacheRed(
            image);
        this.
          image =
          image;
        java.awt.image.ColorModel cm =
          image.
          getColorModel(
            );
        if (!USE_NN)
            cm =
              org.apache.batik.ext.awt.image.GraphicsUtil.
                coerceColorModel(
                  cm,
                  true);
        init(
          image,
          rect,
          cm,
          image.
            getSampleModel(
              ),
          rect.
            x,
          rect.
            y,
          null);
        xOffsets =
          (new org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets[getNumXTiles(
                                                                                        )]);
        yOffsets =
          (new org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets[getNumYTiles(
                                                                                        )]);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        copyToRaster(
          wr);
        return wr;
    }
    public java.awt.image.Raster getTile(int tileX,
                                         int tileY) {
        java.awt.image.WritableRaster dest =
          makeTile(
            tileX,
            tileY);
        java.awt.Rectangle srcR =
          dest.
          getBounds(
            );
        java.awt.image.Raster mapRas =
          offsets.
          getData(
            srcR);
        java.awt.image.ColorModel mapCM =
          offsets.
          getColorModel(
            );
        org.apache.batik.ext.awt.image.GraphicsUtil.
          coerceData(
            (java.awt.image.WritableRaster)
              mapRas,
            mapCM,
            false);
        org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets xinfo =
          getXOffsets(
            tileX);
        org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets yinfo =
          getYOffsets(
            tileY);
        if (USE_NN)
            filterNN(
              mapRas,
              dest,
              xinfo.
                tile,
              xinfo.
                off,
              yinfo.
                tile,
              yinfo.
                off);
        else
            if (image.
                  getColorModel(
                    ).
                  isAlphaPremultiplied(
                    ))
                filterBL(
                  mapRas,
                  dest,
                  xinfo.
                    tile,
                  xinfo.
                    off,
                  yinfo.
                    tile,
                  yinfo.
                    off);
            else
                filterBLPre(
                  mapRas,
                  dest,
                  xinfo.
                    tile,
                  xinfo.
                    off,
                  yinfo.
                    tile,
                  yinfo.
                    off);
        return dest;
    }
    public org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets getXOffsets(int xTile) {
        org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets ret =
          xOffsets[xTile -
                     getMinTileX(
                       )];
        if (ret !=
              null)
            return ret;
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            getSampleModel(
              );
        int base =
          sppsm.
          getOffset(
            0,
            0);
        int tw =
          sppsm.
          getWidth(
            );
        int width =
          tw +
          2 *
          maxOffX;
        int x0 =
          getTileGridXOffset(
            ) +
          xTile *
          tw -
          maxOffX -
          image.
          getTileGridXOffset(
            );
        int x1 =
          x0 +
          width -
          1;
        int tile =
          (int)
            java.lang.Math.
            floor(
              x0 /
                (double)
                  tw);
        int endTile =
          (int)
            java.lang.Math.
            floor(
              x1 /
                (double)
                  tw);
        int loc =
          x0 -
          tile *
          tw;
        int endLoc =
          tw;
        int slop =
          (endTile +
             1) *
          tw -
          1 -
          x1;
        ret =
          new org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets(
            width,
            base,
            1,
            loc,
            endLoc,
            slop,
            tile,
            endTile);
        xOffsets[xTile -
                   getMinTileX(
                     )] =
          ret;
        return ret;
    }
    public org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets getYOffsets(int yTile) {
        org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets ret =
          yOffsets[yTile -
                     getMinTileY(
                       )];
        if (ret !=
              null)
            return ret;
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            getSampleModel(
              );
        int stride =
          sppsm.
          getScanlineStride(
            );
        int th =
          sppsm.
          getHeight(
            );
        int height =
          th +
          2 *
          maxOffY;
        int y0 =
          getTileGridYOffset(
            ) +
          yTile *
          th -
          maxOffY -
          image.
          getTileGridYOffset(
            );
        int y1 =
          y0 +
          height -
          1;
        int tile =
          (int)
            java.lang.Math.
            floor(
              y0 /
                (double)
                  th);
        int endTile =
          (int)
            java.lang.Math.
            floor(
              y1 /
                (double)
                  th);
        int loc =
          y0 -
          tile *
          th;
        int endLoc =
          th;
        int slop =
          (endTile +
             1) *
          th -
          1 -
          y1;
        ret =
          new org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets(
            height,
            0,
            stride,
            loc,
            endLoc,
            slop,
            tile,
            endTile);
        yOffsets[yTile -
                   getMinTileY(
                     )] =
          ret;
        return ret;
    }
    public void filterBL(java.awt.image.Raster off,
                         java.awt.image.WritableRaster dst,
                         int[] xTile,
                         int[] xOff,
                         int[] yTile,
                         int[] yOff) { final int w =
                                         dst.
                                         getWidth(
                                           );
                                       final int h =
                                         dst.
                                         getHeight(
                                           );
                                       final int xStart =
                                         maxOffX;
                                       final int yStart =
                                         maxOffY;
                                       final int xEnd =
                                         xStart +
                                         w;
                                       final int yEnd =
                                         yStart +
                                         h;
                                       java.awt.image.DataBufferInt dstDB =
                                         (java.awt.image.DataBufferInt)
                                           dst.
                                           getDataBuffer(
                                             );
                                       java.awt.image.DataBufferInt offDB =
                                         (java.awt.image.DataBufferInt)
                                           off.
                                           getDataBuffer(
                                             );
                                       java.awt.image.SinglePixelPackedSampleModel dstSPPSM;
                                       java.awt.image.SinglePixelPackedSampleModel offSPPSM;
                                       dstSPPSM =
                                         (java.awt.image.SinglePixelPackedSampleModel)
                                           dst.
                                           getSampleModel(
                                             );
                                       final int dstOff =
                                         dstDB.
                                         getOffset(
                                           ) +
                                         dstSPPSM.
                                         getOffset(
                                           dst.
                                             getMinX(
                                               ) -
                                             dst.
                                             getSampleModelTranslateX(
                                               ),
                                           dst.
                                             getMinY(
                                               ) -
                                             dst.
                                             getSampleModelTranslateY(
                                               ));
                                       offSPPSM =
                                         (java.awt.image.SinglePixelPackedSampleModel)
                                           off.
                                           getSampleModel(
                                             );
                                       final int offOff =
                                         offDB.
                                         getOffset(
                                           ) +
                                         offSPPSM.
                                         getOffset(
                                           dst.
                                             getMinX(
                                               ) -
                                             off.
                                             getSampleModelTranslateX(
                                               ),
                                           dst.
                                             getMinY(
                                               ) -
                                             off.
                                             getSampleModelTranslateY(
                                               ));
                                       final int dstScanStride =
                                         dstSPPSM.
                                         getScanlineStride(
                                           );
                                       final int offScanStride =
                                         offSPPSM.
                                         getScanlineStride(
                                           );
                                       final int dstAdjust =
                                         dstScanStride -
                                         w;
                                       final int offAdjust =
                                         offScanStride -
                                         w;
                                       final int[] dstPixels =
                                         dstDB.
                                         getBankData(
                                           )[0];
                                       final int[] offPixels =
                                         offDB.
                                         getBankData(
                                           )[0];
                                       final int xShift =
                                         xChannel.
                                         toInt(
                                           ) *
                                         8;
                                       final int yShift =
                                         yChannel.
                                         toInt(
                                           ) *
                                         8;
                                       int dp =
                                         dstOff;
                                       int ip =
                                         offOff;
                                       final int fpScaleX =
                                         (int)
                                           (scaleX /
                                              255.0 *
                                              (1 <<
                                                 15) +
                                              0.5);
                                       final int fpAdjX =
                                         (int)
                                           (-127.5 *
                                              fpScaleX -
                                              0.5);
                                       final int fpScaleY =
                                         (int)
                                           (scaleY /
                                              255.0 *
                                              (1 <<
                                                 15) +
                                              0.5);
                                       final int fpAdjY =
                                         (int)
                                           (-127.5 *
                                              fpScaleY -
                                              0.5);
                                       long start =
                                         java.lang.System.
                                         currentTimeMillis(
                                           );
                                       int pel00;
                                       int pel01;
                                       int pel10;
                                       int pel11;
                                       int xFrac;
                                       int yFrac;
                                       int newPel;
                                       int sp0;
                                       int sp1;
                                       int pel0;
                                       int pel1;
                                       int x;
                                       int y;
                                       int x0;
                                       int y0;
                                       int xDisplace;
                                       int yDisplace;
                                       int dPel;
                                       int xt =
                                         xTile[0] -
                                         1;
                                       int yt =
                                         yTile[0] -
                                         1;
                                       int xt1;
                                       int yt1;
                                       int[] imgPix =
                                         null;
                                       for (y =
                                              yStart;
                                            y <
                                              yEnd;
                                            y++) {
                                           for (x =
                                                  xStart;
                                                x <
                                                  xEnd;
                                                x++,
                                                  dp++,
                                                  ip++) {
                                               dPel =
                                                 offPixels[ip];
                                               xDisplace =
                                                 fpScaleX *
                                                   (dPel >>
                                                      xShift &
                                                      255) +
                                                   fpAdjX;
                                               yDisplace =
                                                 fpScaleY *
                                                   (dPel >>
                                                      yShift &
                                                      255) +
                                                   fpAdjY;
                                               x0 =
                                                 x +
                                                   (xDisplace >>
                                                      15);
                                               y0 =
                                                 y +
                                                   (yDisplace >>
                                                      15);
                                               if (xt !=
                                                     xTile[x0] ||
                                                     yt !=
                                                     yTile[y0]) {
                                                   xt =
                                                     xTile[x0];
                                                   yt =
                                                     yTile[y0];
                                                   imgPix =
                                                     ((java.awt.image.DataBufferInt)
                                                        image.
                                                        getTile(
                                                          xt,
                                                          yt).
                                                        getDataBuffer(
                                                          )).
                                                       getBankData(
                                                         )[0];
                                               }
                                               pel00 =
                                                 imgPix[xOff[x0] +
                                                          yOff[y0]];
                                               xt1 =
                                                 xTile[x0 +
                                                         1];
                                               yt1 =
                                                 yTile[y0 +
                                                         1];
                                               if (yt ==
                                                     yt1) {
                                                   if (xt ==
                                                         xt1) {
                                                       pel10 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0]];
                                                       pel01 =
                                                         imgPix[xOff[x0] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       pel11 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0 +
                                                                         1]];
                                                   }
                                                   else {
                                                       pel01 =
                                                         imgPix[xOff[x0] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt1,
                                                              yt).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel10 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0]];
                                                       pel11 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       xt =
                                                         xt1;
                                                   }
                                               }
                                               else {
                                                   if (xt ==
                                                         xt1) {
                                                       pel10 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0]];
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt,
                                                              yt1).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel01 =
                                                         imgPix[xOff[x0] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       pel11 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       yt =
                                                         yt1;
                                                   }
                                                   else {
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt,
                                                              yt1).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel01 =
                                                         imgPix[xOff[x0] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt1,
                                                              yt1).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel11 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt1,
                                                              yt).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel10 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0]];
                                                       xt =
                                                         xt1;
                                                   }
                                               }
                                               xFrac =
                                                 xDisplace &
                                                   32767;
                                               yFrac =
                                                 yDisplace &
                                                   32767;
                                               sp0 =
                                                 pel00 >>>
                                                   16 &
                                                   65280;
                                               sp1 =
                                                 pel10 >>>
                                                   16 &
                                                   65280;
                                               pel0 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               sp0 =
                                                 pel01 >>>
                                                   16 &
                                                   65280;
                                               sp1 =
                                                 pel11 >>>
                                                   16 &
                                                   65280;
                                               pel1 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               newPel =
                                                 ((pel0 <<
                                                     15) +
                                                    (pel1 -
                                                       pel0) *
                                                    yFrac +
                                                    4194304 &
                                                    2139095040) <<
                                                   1;
                                               sp0 =
                                                 pel00 >>
                                                   8 &
                                                   65280;
                                               sp1 =
                                                 pel10 >>
                                                   8 &
                                                   65280;
                                               pel0 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               sp0 =
                                                 pel01 >>
                                                   8 &
                                                   65280;
                                               sp1 =
                                                 pel11 >>
                                                   8 &
                                                   65280;
                                               pel1 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               newPel |=
                                                 ((pel0 <<
                                                     15) +
                                                    (pel1 -
                                                       pel0) *
                                                    yFrac +
                                                    4194304 &
                                                    2139095040) >>>
                                                   7;
                                               sp0 =
                                                 pel00 &
                                                   65280;
                                               sp1 =
                                                 pel10 &
                                                   65280;
                                               pel0 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               sp0 =
                                                 pel01 &
                                                   65280;
                                               sp1 =
                                                 pel11 &
                                                   65280;
                                               pel1 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               newPel |=
                                                 ((pel0 <<
                                                     15) +
                                                    (pel1 -
                                                       pel0) *
                                                    yFrac +
                                                    4194304 &
                                                    2139095040) >>>
                                                   15;
                                               sp0 =
                                                 pel00 <<
                                                   8 &
                                                   65280;
                                               sp1 =
                                                 pel10 <<
                                                   8 &
                                                   65280;
                                               pel0 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               sp0 =
                                                 pel01 <<
                                                   8 &
                                                   65280;
                                               sp1 =
                                                 pel11 <<
                                                   8 &
                                                   65280;
                                               pel1 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               newPel |=
                                                 ((pel0 <<
                                                     15) +
                                                    (pel1 -
                                                       pel0) *
                                                    yFrac +
                                                    4194304 &
                                                    2139095040) >>>
                                                   23;
                                               dstPixels[dp] =
                                                 newPel;
                                           }
                                           dp +=
                                             dstAdjust;
                                           ip +=
                                             offAdjust;
                                       }
                                       if (TIME) {
                                           long end =
                                             java.lang.System.
                                             currentTimeMillis(
                                               );
                                           java.lang.System.
                                             out.
                                             println(
                                               "Time: " +
                                               (end -
                                                  start));
                                       } }
    public void filterBLPre(java.awt.image.Raster off,
                            java.awt.image.WritableRaster dst,
                            int[] xTile,
                            int[] xOff,
                            int[] yTile,
                            int[] yOff) {
        final int w =
          dst.
          getWidth(
            );
        final int h =
          dst.
          getHeight(
            );
        final int xStart =
          maxOffX;
        final int yStart =
          maxOffY;
        final int xEnd =
          xStart +
          w;
        final int yEnd =
          yStart +
          h;
        java.awt.image.DataBufferInt dstDB =
          (java.awt.image.DataBufferInt)
            dst.
            getDataBuffer(
              );
        java.awt.image.DataBufferInt offDB =
          (java.awt.image.DataBufferInt)
            off.
            getDataBuffer(
              );
        java.awt.image.SinglePixelPackedSampleModel dstSPPSM;
        java.awt.image.SinglePixelPackedSampleModel offSPPSM;
        dstSPPSM =
          (java.awt.image.SinglePixelPackedSampleModel)
            dst.
            getSampleModel(
              );
        final int dstOff =
          dstDB.
          getOffset(
            ) +
          dstSPPSM.
          getOffset(
            dst.
              getMinX(
                ) -
              dst.
              getSampleModelTranslateX(
                ),
            dst.
              getMinY(
                ) -
              dst.
              getSampleModelTranslateY(
                ));
        offSPPSM =
          (java.awt.image.SinglePixelPackedSampleModel)
            off.
            getSampleModel(
              );
        final int offOff =
          offDB.
          getOffset(
            ) +
          offSPPSM.
          getOffset(
            dst.
              getMinX(
                ) -
              off.
              getSampleModelTranslateX(
                ),
            dst.
              getMinY(
                ) -
              off.
              getSampleModelTranslateY(
                ));
        final int dstScanStride =
          dstSPPSM.
          getScanlineStride(
            );
        final int offScanStride =
          offSPPSM.
          getScanlineStride(
            );
        final int dstAdjust =
          dstScanStride -
          w;
        final int offAdjust =
          offScanStride -
          w;
        final int[] dstPixels =
          dstDB.
          getBankData(
            )[0];
        final int[] offPixels =
          offDB.
          getBankData(
            )[0];
        final int xShift =
          xChannel.
          toInt(
            ) *
          8;
        final int yShift =
          yChannel.
          toInt(
            ) *
          8;
        int dp =
          dstOff;
        int ip =
          offOff;
        final int fpScaleX =
          (int)
            (scaleX /
               255.0 *
               (1 <<
                  15) +
               0.5);
        final int fpAdjX =
          (int)
            (-127.5 *
               fpScaleX -
               0.5);
        final int fpScaleY =
          (int)
            (scaleY /
               255.0 *
               (1 <<
                  15) +
               0.5);
        final int fpAdjY =
          (int)
            (-127.5 *
               fpScaleY -
               0.5);
        long start =
          java.lang.System.
          currentTimeMillis(
            );
        int pel00;
        int pel01;
        int pel10;
        int pel11;
        int xFrac;
        int yFrac;
        int newPel;
        int sp0;
        int sp1;
        int pel0;
        int pel1;
        int a00;
        int a01;
        int a10;
        int a11;
        int x;
        int y;
        int x0;
        int y0;
        int xDisplace;
        int yDisplace;
        int dPel;
        final int norm =
          (1 <<
             24) /
          255;
        int xt =
          xTile[0] -
          1;
        int yt =
          yTile[0] -
          1;
        int xt1;
        int yt1;
        int[] imgPix =
          null;
        for (y =
               yStart;
             y <
               yEnd;
             y++) {
            for (x =
                   xStart;
                 x <
                   xEnd;
                 x++,
                   dp++,
                   ip++) {
                dPel =
                  offPixels[ip];
                xDisplace =
                  fpScaleX *
                    (dPel >>
                       xShift &
                       255) +
                    fpAdjX;
                yDisplace =
                  fpScaleY *
                    (dPel >>
                       yShift &
                       255) +
                    fpAdjY;
                x0 =
                  x +
                    (xDisplace >>
                       15);
                y0 =
                  y +
                    (yDisplace >>
                       15);
                if (xt !=
                      xTile[x0] ||
                      yt !=
                      yTile[y0]) {
                    xt =
                      xTile[x0];
                    yt =
                      yTile[y0];
                    imgPix =
                      ((java.awt.image.DataBufferInt)
                         image.
                         getTile(
                           xt,
                           yt).
                         getDataBuffer(
                           )).
                        getBankData(
                          )[0];
                }
                pel00 =
                  imgPix[xOff[x0] +
                           yOff[y0]];
                xt1 =
                  xTile[x0 +
                          1];
                yt1 =
                  yTile[y0 +
                          1];
                if (yt ==
                      yt1) {
                    if (xt ==
                          xt1) {
                        pel10 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0]];
                        pel01 =
                          imgPix[xOff[x0] +
                                   yOff[y0 +
                                          1]];
                        pel11 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0 +
                                          1]];
                    }
                    else {
                        pel01 =
                          imgPix[xOff[x0] +
                                   yOff[y0 +
                                          1]];
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt1,
                               yt).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel10 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0]];
                        pel11 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0 +
                                          1]];
                        xt =
                          xt1;
                    }
                }
                else {
                    if (xt ==
                          xt1) {
                        pel10 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0]];
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt,
                               yt1).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel01 =
                          imgPix[xOff[x0] +
                                   yOff[y0 +
                                          1]];
                        pel11 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0 +
                                          1]];
                        yt =
                          yt1;
                    }
                    else {
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt,
                               yt1).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel01 =
                          imgPix[xOff[x0] +
                                   yOff[y0 +
                                          1]];
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt1,
                               yt1).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel11 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0 +
                                          1]];
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt1,
                               yt).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel10 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0]];
                        xt =
                          xt1;
                    }
                }
                xFrac =
                  xDisplace &
                    32767;
                yFrac =
                  yDisplace &
                    32767;
                sp0 =
                  pel00 >>>
                    16 &
                    65280;
                sp1 =
                  pel10 >>>
                    16 &
                    65280;
                pel0 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                a00 =
                  (sp0 >>
                     8) *
                    norm +
                    128 >>
                    8;
                a10 =
                  (sp1 >>
                     8) *
                    norm +
                    128 >>
                    8;
                sp0 =
                  pel01 >>>
                    16 &
                    65280;
                sp1 =
                  pel11 >>>
                    16 &
                    65280;
                pel1 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                a01 =
                  (sp0 >>
                     8) *
                    norm +
                    128 >>
                    8;
                a11 =
                  (sp1 >>
                     8) *
                    norm +
                    128 >>
                    8;
                newPel =
                  ((pel0 <<
                      15) +
                     (pel1 -
                        pel0) *
                     yFrac +
                     4194304 &
                     2139095040) <<
                    1;
                sp0 =
                  (pel00 >>
                     16 &
                     255) *
                    a00 +
                    128 >>
                    8;
                sp1 =
                  (pel10 >>
                     16 &
                     255) *
                    a10 +
                    128 >>
                    8;
                pel0 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                sp0 =
                  (pel01 >>
                     16 &
                     255) *
                    a01 +
                    128 >>
                    8;
                sp1 =
                  (pel11 >>
                     16 &
                     255) *
                    a11 +
                    128 >>
                    8;
                pel1 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                newPel |=
                  ((pel0 <<
                      15) +
                     (pel1 -
                        pel0) *
                     yFrac +
                     4194304 &
                     2139095040) >>>
                    7;
                sp0 =
                  (pel00 >>
                     8 &
                     255) *
                    a00 +
                    128 >>
                    8;
                sp1 =
                  (pel10 >>
                     8 &
                     255) *
                    a10 +
                    128 >>
                    8;
                pel0 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                sp0 =
                  (pel01 >>
                     8 &
                     255) *
                    a01 +
                    128 >>
                    8;
                sp1 =
                  (pel11 >>
                     8 &
                     255) *
                    a11 +
                    128 >>
                    8;
                pel1 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                newPel |=
                  ((pel0 <<
                      15) +
                     (pel1 -
                        pel0) *
                     yFrac +
                     4194304 &
                     2139095040) >>>
                    15;
                sp0 =
                  (pel00 &
                     255) *
                    a00 +
                    128 >>
                    8;
                sp1 =
                  (pel10 &
                     255) *
                    a10 +
                    128 >>
                    8;
                pel0 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                sp0 =
                  (pel01 &
                     255) *
                    a01 +
                    128 >>
                    8;
                sp1 =
                  (pel11 &
                     255) *
                    a11 +
                    128 >>
                    8;
                pel1 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                newPel |=
                  ((pel0 <<
                      15) +
                     (pel1 -
                        pel0) *
                     yFrac +
                     4194304 &
                     2139095040) >>>
                    23;
                dstPixels[dp] =
                  newPel;
            }
            dp +=
              dstAdjust;
            ip +=
              offAdjust;
        }
        if (TIME) {
            long end =
              java.lang.System.
              currentTimeMillis(
                );
            java.lang.System.
              out.
              println(
                "Time: " +
                (end -
                   start));
        }
    }
    public void filterNN(java.awt.image.Raster off,
                         java.awt.image.WritableRaster dst,
                         int[] xTile,
                         int[] xOff,
                         int[] yTile,
                         int[] yOff) { final int w =
                                         dst.
                                         getWidth(
                                           );
                                       final int h =
                                         dst.
                                         getHeight(
                                           );
                                       final int xStart =
                                         maxOffX;
                                       final int yStart =
                                         maxOffY;
                                       final int xEnd =
                                         xStart +
                                         w;
                                       final int yEnd =
                                         yStart +
                                         h;
                                       java.awt.image.DataBufferInt dstDB =
                                         (java.awt.image.DataBufferInt)
                                           dst.
                                           getDataBuffer(
                                             );
                                       java.awt.image.DataBufferInt offDB =
                                         (java.awt.image.DataBufferInt)
                                           off.
                                           getDataBuffer(
                                             );
                                       java.awt.image.SinglePixelPackedSampleModel dstSPPSM;
                                       java.awt.image.SinglePixelPackedSampleModel offSPPSM;
                                       dstSPPSM =
                                         (java.awt.image.SinglePixelPackedSampleModel)
                                           dst.
                                           getSampleModel(
                                             );
                                       final int dstOff =
                                         dstDB.
                                         getOffset(
                                           ) +
                                         dstSPPSM.
                                         getOffset(
                                           dst.
                                             getMinX(
                                               ) -
                                             dst.
                                             getSampleModelTranslateX(
                                               ),
                                           dst.
                                             getMinY(
                                               ) -
                                             dst.
                                             getSampleModelTranslateY(
                                               ));
                                       offSPPSM =
                                         (java.awt.image.SinglePixelPackedSampleModel)
                                           off.
                                           getSampleModel(
                                             );
                                       final int offOff =
                                         offDB.
                                         getOffset(
                                           ) +
                                         offSPPSM.
                                         getOffset(
                                           off.
                                             getMinX(
                                               ) -
                                             off.
                                             getSampleModelTranslateX(
                                               ),
                                           off.
                                             getMinY(
                                               ) -
                                             off.
                                             getSampleModelTranslateY(
                                               ));
                                       final int dstScanStride =
                                         dstSPPSM.
                                         getScanlineStride(
                                           );
                                       final int offScanStride =
                                         offSPPSM.
                                         getScanlineStride(
                                           );
                                       final int dstAdjust =
                                         dstScanStride -
                                         w;
                                       final int offAdjust =
                                         offScanStride -
                                         w;
                                       final int[] dstPixels =
                                         dstDB.
                                         getBankData(
                                           )[0];
                                       final int[] offPixels =
                                         offDB.
                                         getBankData(
                                           )[0];
                                       final int xShift =
                                         xChannel.
                                         toInt(
                                           ) *
                                         8;
                                       final int yShift =
                                         yChannel.
                                         toInt(
                                           ) *
                                         8;
                                       final int fpScaleX =
                                         (int)
                                           (scaleX /
                                              255.0 *
                                              (1 <<
                                                 15) +
                                              0.5);
                                       final int fpScaleY =
                                         (int)
                                           (scaleY /
                                              255.0 *
                                              (1 <<
                                                 15) +
                                              0.5);
                                       final int fpAdjX =
                                         (int)
                                           (-127.5 *
                                              fpScaleX -
                                              0.5) +
                                         16384;
                                       final int fpAdjY =
                                         (int)
                                           (-127.5 *
                                              fpScaleY -
                                              0.5) +
                                         16384;
                                       int dp =
                                         dstOff;
                                       int ip =
                                         offOff;
                                       long start =
                                         java.lang.System.
                                         currentTimeMillis(
                                           );
                                       int y =
                                         yStart;
                                       int xt =
                                         xTile[0] -
                                         1;
                                       int yt =
                                         yTile[0] -
                                         1;
                                       int[] imgPix =
                                         null;
                                       int x0;
                                       int y0;
                                       int xDisplace;
                                       int yDisplace;
                                       int dPel;
                                       while (y <
                                                yEnd) {
                                           int x =
                                             xStart;
                                           while (x <
                                                    xEnd) {
                                               dPel =
                                                 offPixels[ip];
                                               xDisplace =
                                                 fpScaleX *
                                                   (dPel >>
                                                      xShift &
                                                      255) +
                                                   fpAdjX;
                                               yDisplace =
                                                 fpScaleY *
                                                   (dPel >>
                                                      yShift &
                                                      255) +
                                                   fpAdjY;
                                               x0 =
                                                 x +
                                                   (xDisplace >>
                                                      15);
                                               y0 =
                                                 y +
                                                   (yDisplace >>
                                                      15);
                                               if (xt !=
                                                     xTile[x0] ||
                                                     yt !=
                                                     yTile[y0]) {
                                                   xt =
                                                     xTile[x0];
                                                   yt =
                                                     yTile[y0];
                                                   imgPix =
                                                     ((java.awt.image.DataBufferInt)
                                                        image.
                                                        getTile(
                                                          xt,
                                                          yt).
                                                        getDataBuffer(
                                                          )).
                                                       getBankData(
                                                         )[0];
                                               }
                                               dstPixels[dp] =
                                                 imgPix[xOff[x0] +
                                                          yOff[y0]];
                                               dp++;
                                               ip++;
                                               x++;
                                           }
                                           dp +=
                                             dstAdjust;
                                           ip +=
                                             offAdjust;
                                           y++;
                                       }
                                       if (TIME) {
                                           long end =
                                             java.lang.System.
                                             currentTimeMillis(
                                               );
                                           java.lang.System.
                                             out.
                                             println(
                                               "Time: " +
                                               (end -
                                                  start));
                                       } }
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
      ("H4sIAAAAAAAAAL17Cezk1nnf7EraXcmydiXbkqJIsi4nkcZZznAOkpHthOQc" +
       "PIdzcC429ZrXDDm8r+GQrhrbQGunARyjkRMncIQWcJo0UGS3idECQQoVPZLA" +
       "SeAE6QnUToKiSeO6tYDWNeIm6SPnf+1//7s67QH4hvP4vfd+3/e+6z2+efHr" +
       "lTuisFL1PTtb2158Vd/FVzd262qc+Xp0leFaQzmMdI205SgSQd019YkvXP7m" +
       "tz9lXDlfuSBV3iG7rhfLsem50ViPPHura1zl8nFt19adKK5c4TbyVoaS2LQh" +
       "zoziZ7nK2040jStPcYcQIAABAhCgEgKEH1OBRm/X3cQhixayG0dB5W9XznGV" +
       "C75awIsrj1/fiS+HsnPQzbDkAPRwqfg9A0yVjXdh5bEj3vc838Dwp6vQ8z/z" +
       "wSv/9LbKZaly2XQnBRwVgIjBIFLlbkd3FD2McE3TNalyr6vr2kQPTdk28xK3" +
       "VLkvMteuHCehfiSkojLx9bAc81hyd6sFb2Gixl54xN7K1G3t8NcdK1teA17v" +
       "P+Z1z2GvqAcM3mUCYOFKVvXDJrdbpqvFlXefbnHE41MsIABNLzp6bHhHQ93u" +
       "yqCict9+7mzZXUOTODTdNSC9w0vAKHHloZt2Wsjal1VLXuvX4sqDp+mG+0eA" +
       "6s5SEEWTuPKu02RlT2CWHjo1Syfm5+uD933ywy7lni8xa7pqF/gvgUaPnmo0" +
       "1ld6qLuqvm949zPcT8v3/8YnzlcqgPhdp4j3NP/sb73yI+999OXf2tN87xk0" +
       "grLR1fia+jnlnt9/mHwau62Accn3IrOY/Os4L9V/ePDk2Z0PLO/+ox6Lh1cP" +
       "H748/rfLj/yy/rXzlbvoygXVsxMH6NG9quf4pq2Hfd3VQznWNbpyp+5qZPmc" +
       "rlwE95zp6vtaYbWK9Jiu3G6XVRe88jcQ0Qp0UYjoIrg33ZV3eO/LsVHe7/xK" +
       "pXIRXJW7wfV0Zf8pv+OKAxmeo0OyKrum60HD0Cv4jyDdjRUgWwNSgNZbUOQl" +
       "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" +
       "sZY4SNDgrDSAI1xMxZYPBUy8K1IK1O9I");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ZtWfsdl80MW7nE8sonoz2KCrOqNTyqLdXMxb8MyZIahLy+NqnDbaobWipXlY" +
       "3ZDdeQ7bqIoCvoF83UQNNlnodWuS4UE4ovQGpl4LrNVw1E/IbKX14LSBVwXC" +
       "QGCBJHyz1mxVkXXcMBo1CMXtbr7jLTTCcfz9xRbYl1/f1ty95S7k0YnIjV2+" +
       "Wnv5dey+7R89XhTvOdqnLT8XKqdO0Z3Ypz3xYr5SHB145GYHHcuDFJ/72PMv" +
       "aMIv1M8fbOA+G1fujD3/B219q9snuroIenrm5hvwfLkPfvyi/Tc/9ucPiR8w" +
       "PvQ6joS9+xTO013+Y/7F3+5/n/r3z1duO3rtfsMJ1OsbPXv9y/a7Qj1OQle8" +
       "7pX7I0eSfaiQ2BPgeulAsi+d3gE/nruzXxP+wH7uT50XOXdwsO5g9/mRo7Mm" +
       "+939eWjG5TEgOYr1sOzhv93ixMmfF8Ufx5VLqudnHTmWi99/eqxQf/Jq27kn" +
       "OywrvnIkgfuKyuIl0q8eSOBX3xoJnC8Jzhc/y1dcz5dU//sWXH6zKP5XXLm4" +
       "1uPiFceh8N51Snh7oR1z/403wf0Dh/P/5QPuv/yWzv8R4+fO35zxc7cXlX8Z" +
       "V94GGF+ceJHyhWMe/+qt4PGVAx5f+Q7xeM8teLxSFHfueVyeyeO5u94Ej+Xx" +
       "ygZA885923P3vTU8XigJLhQ/v3VsdC8ejVueNLhcqdw+2I+7/44r6ps8biz7" +
       "fgRF27USemmkh9DA0/ShqVp6OJRd3T481fzdGKaUy/NnerbiLdG5hw9eEp57" +
       "7Gzpli6gjJXHZ3Rs3V3vj4kXvuHc9/q7037j0PjfcfwWjbQ9Vy+85uGz/fFm" +
       "07t69E8J8HB3JtKv7JGWg52IsGdN+Umt/cFbPIOK4pm4coda4NqzcQtyeFcp" +
       "aY6LsvqhWzQpXuSdA3xeWpk28HgEd+brva1nasdGdP+bNaI2ENnvHhjRl75D" +
       "RnRKEMfSwG8hDbIo3gc8yKE0hmEp9fYx8+9/CzzI+U/v257/qe828/wtmBeK" +
       "gjpShfJ820nO6dfD+S6u3HfjsYLiBPSDN/yNaf/XG/WlFy5feuCF6X/Yn5Y4" +
       "/HvMnRwAlNj2ycONJ+4v+KG+Mkup3Lk/6uiXzMziyve/xuMPgOPD24KNc9N9" +
       "D8u48uitezg8JXWy1Y/GlQdv1iqu3AbKk9TXgIM5ixpQgvIkpRJXrpymBOOX" +
       "3yfpAKi7jumAG9zfnCQxQO+ApLg1/UM/95pPl+NKFIeyGoPZ3J27fk1wqCmV" +
       "+15NU04sI568Lvkv/wl3mKgn+//CXVM//wIz+PAr7V/Y/zNBteU8L3q5xFUu" +
       "7v8kcZTsP37T3g77ukA9/e17vnDnew4XJvfsAR8b3gls7z77bwBdx4/Lg/v5" +
       "P3/g1973iy98pTxt8f8B9d4HLqI4AAA=");
}
