package org.apache.batik.ext.awt.image.rendered;
public class BufferedImageCachableRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    java.awt.image.BufferedImage bi;
    public BufferedImageCachableRed(java.awt.image.BufferedImage bi) { super(
                                                                         (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                                                           null,
                                                                         new java.awt.Rectangle(
                                                                           bi.
                                                                             getMinX(
                                                                               ),
                                                                           bi.
                                                                             getMinY(
                                                                               ),
                                                                           bi.
                                                                             getWidth(
                                                                               ),
                                                                           bi.
                                                                             getHeight(
                                                                               )),
                                                                         bi.
                                                                           getColorModel(
                                                                             ),
                                                                         bi.
                                                                           getSampleModel(
                                                                             ),
                                                                         bi.
                                                                           getMinX(
                                                                             ),
                                                                         bi.
                                                                           getMinY(
                                                                             ),
                                                                         null);
                                                                       this.
                                                                         bi =
                                                                         bi;
    }
    public BufferedImageCachableRed(java.awt.image.BufferedImage bi,
                                    int xloc,
                                    int yloc) {
        super(
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            null,
          new java.awt.Rectangle(
            xloc,
            yloc,
            bi.
              getWidth(
                ),
            bi.
              getHeight(
                )),
          bi.
            getColorModel(
              ),
          bi.
            getSampleModel(
              ),
          xloc,
          yloc,
          null);
        this.
          bi =
          bi;
    }
    public java.awt.Rectangle getBounds() {
        return new java.awt.Rectangle(
          getMinX(
            ),
          getMinY(
            ),
          getWidth(
            ),
          getHeight(
            ));
    }
    public java.awt.image.BufferedImage getBufferedImage() {
        return bi;
    }
    public java.lang.Object getProperty(java.lang.String name) {
        return bi.
          getProperty(
            name);
    }
    public java.lang.String[] getPropertyNames() {
        return bi.
          getPropertyNames(
            );
    }
    public java.awt.image.Raster getTile(int tileX,
                                         int tileY) {
        return bi.
          getTile(
            tileX,
            tileY);
    }
    public java.awt.image.Raster getData() {
        java.awt.image.Raster r =
          bi.
          getData(
            );
        return r.
          createTranslatedChild(
            getMinX(
              ),
            getMinY(
              ));
    }
    public java.awt.image.Raster getData(java.awt.Rectangle rect) {
        java.awt.Rectangle r =
          (java.awt.Rectangle)
            rect.
            clone(
              );
        if (!r.
              intersects(
                getBounds(
                  )))
            return null;
        r =
          r.
            intersection(
              getBounds(
                ));
        r.
          translate(
            -getMinX(
               ),
            -getMinY(
               ));
        java.awt.image.Raster ret =
          bi.
          getData(
            r);
        return ret.
          createTranslatedChild(
            ret.
              getMinX(
                ) +
              getMinX(
                ),
            ret.
              getMinY(
                ) +
              getMinY(
                ));
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        java.awt.image.WritableRaster wr2 =
          wr.
          createWritableTranslatedChild(
            wr.
              getMinX(
                ) -
              getMinX(
                ),
            wr.
              getMinY(
                ) -
              getMinY(
                ));
        org.apache.batik.ext.awt.image.GraphicsUtil.
          copyData(
            bi.
              getRaster(
                ),
            wr2);
        return wr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BwjjRDFEIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "r+ydmG49d9uM52Sf3ZSrwPm2Hbi/Bb8L4Pqb/MpB5RW7lPtY5yDvXz9K/J6X" +
       "K/o954lVvKL3Z1986Z//05c+voPx2OnZRhdMpj//7/769/c/+/Uv3SE9XQQz" +
       "yfwPXoj54jmGTebFzaKplhfv32m8+V0Zx472yeLffefrqJfPhI+D/JP/h7al" +
       "l//zX93mIUVuuoPazvQX4Nd+9qnOD3+j6H+cJPLez2xvT+vgq+G4b+VX1v9z" +
       "79lL/2YPekCArskHnyS8aMd56BXANDw8/E4Bny2n2k9PqXfzx5tHSfBdZ+3m" +
       "xGvPpqdjfYHnnDp/vnImIxWj/Di43nvgMu89620XoOKB3zlcUd7Ii+87oeJu" +
       "BO1JRuFHx85ZKHv+nZTNFP23F0Amub+y39wvGHzozi8rPPX7QcoJi68s0EMz" +
       "HNE+FOEJ05ZvHHoDD766gLZvmHbzMD5fK6JYPq77u0+VM7J2v2tZgSE+csyM" +
       "dMFXz0/+l0/9/j987mvAWgjo/k2uSWAkJ95IxfmH4I+/9umnH3rl6z9ZZFCQ" +
       "Oiaf6V57Mee6Og9xXoh5IR1CfSqHyhZTVlIMo3GR9FTlCG37BJ5+BFKn+xbQ" +
       "RtfQQS0ctg9/47IgLTAO0RYxYTArbDLC2gzDDpl12aXT+TDgaR8bGul42F/q" +
       "w9rKk+ymEjfTGbWpVmNUqcvhfOjWuMogRAbd9gRxkcl2Gih8Z8n7iua2yDm/" +
       "qsBYwEasEfFCw52vhV5FXG89ES3VW02kNYDjla/VknEJXjelquMM4lLWdKqD" +
       "WR0nbH0tzsYWyfK9SruBz72eqtElfjaM17G9IEJTakvdUamxLONAGnUd6M5s" +
       "5PZTglmlqj8llnHM+YYY6sLQaBDCjCIs0a+Y1JBbblgR8UlbWbp+jAvYerv0" +
       "bLw3n/YU0fRSvSMR5Jjur7k+TvMCIU3X3UrbYjaGQ4RuPZXEHjNzTWLcmM+U" +
       "StzWM40xFcecdzPJbM6XSXk7KvGRtZmSvQkn9tLtvK/RBCaLceCZHMULK1pY" +
       "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" +
       "Lk/AAdyHjzmYCw/sODwUQc+czwHEweJ+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("stcjAP3dekXQRVCepH4UBPQ7UQNKUJ6kfAfI6GcpwfuL+0m6JyLoyjEdSDu7" +
       "h5MkTwHugCR//F7v0IKq3+1xwbYURoEoR0Cb2wunP3qO7OWx72QvJ76Tnjs1" +
       "JymOVR9+icS7g9W35C++SlAffaPxi7uDa7ItZlnO5TKYPuzO0B19zbznrtwO" +
       "eV0avPDtR371wecPv7we2Ql87IYnZHv3nU+JdddeVJzryn7riV9//z959U+K" +
       "7fj/B3K6ej3vLgAA");
}
