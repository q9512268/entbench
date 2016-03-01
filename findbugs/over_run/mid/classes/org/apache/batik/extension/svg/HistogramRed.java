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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "d2QW/sj8D4mEoSpFIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+Q7gCXQpbv8sOHbav/Bhm7YaJ5GiJcVh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("m0vnYfrEeo+8nvXOIPsz5z6YlueAjz9upvuTwC9qX3iFGX7g282f2R/U0hwl" +
       "zwsq1zjo6v7M2MkH0nfdldoxrSv9577z0C898OzxWvHQnuFTvz/D25N3PhVF" +
       "ukFSnmPK/8k7/tF7f+6V3y8/JPxfm0BMzaAtAAA=");
}
