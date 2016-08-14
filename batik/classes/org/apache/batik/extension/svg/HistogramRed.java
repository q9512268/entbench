package org.apache.batik.extension.svg;
public class HistogramRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    boolean[] computed;
    int tallied = 0;
    int[] bins = new int[256];
    public HistogramRed(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        super(
          src,
          null);
        int tiles =
          getNumXTiles(
            ) *
          getNumYTiles(
            );
        computed =
          (new boolean[tiles]);
    }
    public void tallyTile(java.awt.image.Raster r) { final int minX =
                                                       r.
                                                       getMinX(
                                                         );
                                                     final int minY =
                                                       r.
                                                       getMinY(
                                                         );
                                                     final int w =
                                                       r.
                                                       getWidth(
                                                         );
                                                     final int h =
                                                       r.
                                                       getHeight(
                                                         );
                                                     int[] samples =
                                                       null;
                                                     int val;
                                                     for (int y =
                                                            minY;
                                                          y <
                                                            minY +
                                                            h;
                                                          y++) { samples =
                                                                   r.
                                                                     getPixels(
                                                                       minX,
                                                                       y,
                                                                       w,
                                                                       1,
                                                                       samples);
                                                                 for (int x =
                                                                        0;
                                                                      x <
                                                                        3 *
                                                                        w;
                                                                      x++) {
                                                                     val =
                                                                       samples[x++] *
                                                                         5;
                                                                     val +=
                                                                       samples[x++] *
                                                                         9;
                                                                     val +=
                                                                       samples[x++] *
                                                                         2;
                                                                     bins[val >>
                                                                            4]++;
                                                                 }
                                                     }
                                                     tallied++;
    }
    public int[] getHistogram() { if (tallied ==
                                        computed.
                                          length)
                                      return bins;
                                  org.apache.batik.ext.awt.image.rendered.CachableRed src =
                                    (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                      getSources(
                                        ).
                                      get(
                                        0);
                                  int yt0 =
                                    src.
                                    getMinTileY(
                                      );
                                  int xtiles =
                                    src.
                                    getNumXTiles(
                                      );
                                  int xt0 =
                                    src.
                                    getMinTileX(
                                      );
                                  for (int y =
                                         0;
                                       y <
                                         src.
                                         getNumYTiles(
                                           );
                                       y++) {
                                      for (int x =
                                             0;
                                           x <
                                             xtiles;
                                           x++) {
                                          int idx =
                                            x +
                                            xt0 +
                                            y *
                                            xtiles;
                                          if (computed[idx])
                                              continue;
                                          java.awt.image.Raster r =
                                            src.
                                            getTile(
                                              x +
                                                xt0,
                                              y +
                                                yt0);
                                          tallyTile(
                                            r);
                                          computed[idx] =
                                            true;
                                      }
                                  }
                                  return bins;
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        copyToRaster(
          wr);
        return wr;
    }
    public java.awt.image.Raster getTile(int tileX,
                                         int tileY) {
        int yt =
          tileY -
          getMinTileY(
            );
        int xt =
          tileX -
          getMinTileX(
            );
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.image.Raster r =
          src.
          getTile(
            tileX,
            tileY);
        int idx =
          xt +
          yt *
          getNumXTiles(
            );
        if (computed[idx])
            return r;
        tallyTile(
          r);
        computed[idx] =
          true;
        return r;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KjJVvOLbtP8B2raUePIhAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3/Z9/kcCPXb3PsDdj/One/1pAt043yuB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7i//T7f78wS6dtIugS7vM6ebfBvQBJoU2b8Ijoz2r3zpBlPiJJLVpLh0c+Es" +
       "TB9r75HX0t4pZH/mzEfV8s7v0QfQdH/r95b6uZeH4/d9q/VT+wtbqiPvdsUo" +
       "Vxnoyv7u2PFH1HfcdbSjsS6Tz337oV944NmjteKhPcEndn+KtifvfDuKcIOk" +
       "vM+0+xdv+2fv/pmX/6D8EPF/AYSK3L2MLQAA");
}
