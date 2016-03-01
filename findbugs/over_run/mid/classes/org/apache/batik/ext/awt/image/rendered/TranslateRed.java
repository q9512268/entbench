package org.apache.batik.ext.awt.image.rendered;
public class TranslateRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    protected int deltaX;
    protected int deltaY;
    public TranslateRed(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                        int xloc,
                        int yloc) { super(cr, new java.awt.Rectangle(xloc,
                                                                     yloc,
                                                                     cr.
                                                                       getWidth(
                                                                         ),
                                                                     cr.
                                                                       getHeight(
                                                                         )),
                                          cr.
                                            getColorModel(
                                              ),
                                          cr.
                                            getSampleModel(
                                              ),
                                          cr.
                                            getTileGridXOffset(
                                              ) +
                                            xloc -
                                            cr.
                                            getMinX(
                                              ),
                                          cr.
                                            getTileGridYOffset(
                                              ) +
                                            yloc -
                                            cr.
                                            getMinY(
                                              ),
                                          null);
                                    deltaX = xloc - cr.getMinX();
                                    deltaY = yloc - cr.getMinY();
    }
    public int getDeltaX() { return deltaX; }
    public int getDeltaY() { return deltaY; }
    public org.apache.batik.ext.awt.image.rendered.CachableRed getSource() {
        return (org.apache.batik.ext.awt.image.rendered.CachableRed)
                 getSources(
                   ).
                 get(
                   0);
    }
    public java.lang.Object getProperty(java.lang.String name) { return getSource(
                                                                          ).
                                                                   getProperty(
                                                                     name);
    }
    public java.lang.String[] getPropertyNames() { return getSource(
                                                            ).
                                                     getPropertyNames(
                                                       );
    }
    public java.awt.image.Raster getTile(int tileX, int tileY) {
        java.awt.image.Raster r =
          getSource(
            ).
          getTile(
            tileX,
            tileY);
        return r.
          createTranslatedChild(
            r.
              getMinX(
                ) +
              deltaX,
            r.
              getMinY(
                ) +
              deltaY);
    }
    public java.awt.image.Raster getData() { java.awt.image.Raster r =
                                               getSource(
                                                 ).
                                               getData(
                                                 );
                                             return r.createTranslatedChild(
                                                        r.
                                                          getMinX(
                                                            ) +
                                                          deltaX,
                                                        r.
                                                          getMinY(
                                                            ) +
                                                          deltaY);
    }
    public java.awt.image.Raster getData(java.awt.Rectangle rect) {
        java.awt.Rectangle r =
          (java.awt.Rectangle)
            rect.
            clone(
              );
        r.
          translate(
            -deltaX,
            -deltaY);
        java.awt.image.Raster ret =
          getSource(
            ).
          getData(
            r);
        return ret.
          createTranslatedChild(
            ret.
              getMinX(
                ) +
              deltaX,
            ret.
              getMinY(
                ) +
              deltaY);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        java.awt.image.WritableRaster wr2 =
          wr.
          createWritableTranslatedChild(
            wr.
              getMinX(
                ) -
              deltaX,
            wr.
              getMinY(
                ) -
              deltaY);
        getSource(
          ).
          copyData(
            wr2);
        return wr;
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
       "u0/d7cy42Mb+/MdffkUd/Vzl4GjDuR2XLsee/8O2ttbsU6wuA07vvvseLF0c" +
       "me83Qn/94//lSe79xke+jzO1d5yR8yzLv0+/+pv4Dyo/dVA6f7Itetth/q2d" +
       "Xrh1M/RKqMVJ6HK3bIk+daLZq7nGngDf9x5p9r1n9x33trvzpuO7dra/x37+" +
       "J+7R9tfz4uNA/0st7u83Uve+8ldeb1fsNMei4mO3g/vAEbgP3H9wP32Pts/k" +
       "xadOgVucAfeTbwBcfhhZug6+/SNw/fsP7u/co+3v5sXf2oHbbXzmFeU9uL/9" +
       "BsA9mlc+Bb7EETji/oA7tyfYHe//g3sg/EJe/HxcehNAOA694srOHbaud8cW" +
       "e9y/8AZwP5ZX5lv/1BFu6v4b9Z/co+1X8uKXAbxTkBmQTCKQCZ+7eyYsjlt3" +
       "h5ev/Pyzv/OxV579j8Xh2SUzmklhJ1ze4RrPqT7ffvVr3/zKm5/6YnGq/4As" +
       "RbtUdfb+0+3Xm265tVQAeOhElW/NQT2Zq+VIlcVvXLp5+/Hne68HiRSZQeLF" +
       "2rt2h+LXdyca14vzjOu704kPvXidHvXRm0yHRtnr77vuapujlo9KjvzShw4P" +
       "D1984XnfLwSRzvrcfgv/teOznF+7sx0PCjvmxcm8etHW3OXuik5xoPPP/PSE" +
       "/8Gu07FnvmXvmT3bc7X8uPq4bXehxPQOT26pgcb0jpJ+bCdpMdipKfn1nOtf" +
       "36PtK3nxr+LSBSWXawfjHuT/5ihciqD68htNJvnZ2vjIE8b3J6gO9tYqjLI7" +
       "2f7qPSB9PS9+Py49CMKLM/d2eaywy/6+wVSKgKfv0f/B/UAvHKEX7n9K+eN7" +
       "tP3XvPijHea+FBdrwT/cQ/vG/YD24hG0F+8PtNNxAKzz6Il1piDRg8ACMZM3" +
       "/ek9UP9ZXvy3u6L+728AdZ7TigWwdoRa+3+C+qkzPimEZlxcfSl8M+dw7uLd" +
       "FXDuSl6ci0uXFM/fHmng3IMnGjh38P1oII1LD52+IJff9nnitsu7uwunyhdf" +
       "uXrp8Vf4f7ebTY4vhV6mSpf0xLZP3xM4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9XzRDzXdLPRyeXdroEjj5x6JSz/0PV4OAliPH3MA567tOLw1Lj19bw4gIxa/" +
       "p3s9HpeeuFuvuHQelKepnwSp/U7UgBKUpymfAnP7WUowfvF7mu56XLqypwMT" +
       "0O7hNMmzgDsgyR9v+Mde8z3fpOrIURxKSgysme587onT7l5EyaOv5yOn3vie" +
       "vWV1Utz/Pn6nSnY3wG8qX3plwHz0O82f293CU2wpy3Iul8BCYnch8Gghcfoq" +
       "1Flux7wuEs9/9+Ffuvzc8TvkwzuB96F3SrZ33PnKG+r4cXFJLfvHj//yj/zC" +
       "K18tLiH8X4ioUdWYLwAA");
}
