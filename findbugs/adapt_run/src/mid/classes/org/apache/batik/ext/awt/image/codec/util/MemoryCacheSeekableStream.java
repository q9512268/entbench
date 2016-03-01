package org.apache.batik.ext.awt.image.codec.util;
public final class MemoryCacheSeekableStream extends org.apache.batik.ext.awt.image.codec.util.SeekableStream {
    private java.io.InputStream src;
    private long pointer = 0;
    private static final int SECTOR_SHIFT = 9;
    private static final int SECTOR_SIZE = 1 << SECTOR_SHIFT;
    private static final int SECTOR_MASK = SECTOR_SIZE - 1;
    private java.util.List data = new java.util.ArrayList();
    int sectors = 0;
    int length = 0;
    boolean foundEOS = false;
    public MemoryCacheSeekableStream(java.io.InputStream src) { super();
                                                                this.src =
                                                                  src; }
    private long readUntil(long pos) throws java.io.IOException { if (pos <
                                                                        length) {
                                                                      return pos;
                                                                  }
                                                                  if (foundEOS) {
                                                                      return length;
                                                                  }
                                                                  int sector =
                                                                    (int)
                                                                      (pos >>
                                                                         SECTOR_SHIFT);
                                                                  int startSector =
                                                                    length >>
                                                                    SECTOR_SHIFT;
                                                                  for (int i =
                                                                         startSector;
                                                                       i <=
                                                                         sector;
                                                                       i++) {
                                                                      byte[] buf =
                                                                        new byte[SECTOR_SIZE];
                                                                      data.
                                                                        add(
                                                                          buf);
                                                                      int len =
                                                                        SECTOR_SIZE;
                                                                      int off =
                                                                        0;
                                                                      while (len >
                                                                               0) {
                                                                          int nbytes =
                                                                            src.
                                                                            read(
                                                                              buf,
                                                                              off,
                                                                              len);
                                                                          if (nbytes ==
                                                                                -1) {
                                                                              foundEOS =
                                                                                true;
                                                                              return length;
                                                                          }
                                                                          off +=
                                                                            nbytes;
                                                                          len -=
                                                                            nbytes;
                                                                          length +=
                                                                            nbytes;
                                                                      }
                                                                  }
                                                                  return length;
    }
    public boolean canSeekBackwards() { return true;
    }
    public long getFilePointer() { return pointer;
    }
    public void seek(long pos) throws java.io.IOException {
        if (pos <
              0) {
            throw new java.io.IOException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "MemoryCacheSeekableStream0"));
        }
        pointer =
          pos;
    }
    public int read() throws java.io.IOException {
        long next =
          pointer +
          1;
        long pos =
          readUntil(
            next);
        if (pos >=
              next) {
            byte[] buf =
              (byte[])
                data.
                get(
                  (int)
                    (pointer >>
                       SECTOR_SHIFT));
            return buf[(int)
                         (pointer++ &
                            SECTOR_MASK)] &
              255;
        }
        else {
            return -1;
        }
    }
    public int read(byte[] b, int off, int len)
          throws java.io.IOException { if (b ==
                                             null) {
                                           throw new java.lang.NullPointerException(
                                             );
                                       }
                                       if (off <
                                             0 ||
                                             len <
                                             0 ||
                                             off +
                                             len >
                                             b.
                                               length) {
                                           throw new java.lang.IndexOutOfBoundsException(
                                             );
                                       }
                                       if (len ==
                                             0) {
                                           return 0;
                                       }
                                       long pos =
                                         readUntil(
                                           pointer +
                                             len);
                                       if (pos <=
                                             pointer) {
                                           return -1;
                                       }
                                       byte[] buf =
                                         (byte[])
                                           data.
                                           get(
                                             (int)
                                               (pointer >>
                                                  SECTOR_SHIFT));
                                       int nbytes =
                                         java.lang.Math.
                                         min(
                                           len,
                                           SECTOR_SIZE -
                                             (int)
                                               (pointer &
                                                  SECTOR_MASK));
                                       java.lang.System.
                                         arraycopy(
                                           buf,
                                           (int)
                                             (pointer &
                                                SECTOR_MASK),
                                           b,
                                           off,
                                           nbytes);
                                       pointer +=
                                         nbytes;
                                       return nbytes;
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
       "G+uIvVpbaiITVoeau7XhbPJ2E7WlWX8wmbegAI9gSSZik1x4PrFdQTbe7Drr" +
       "WB7onKZPPdrZzkJ/WLWyDrKRO3Mrplf8crhgrJG0qM8iOkygsN4cTBittmoQ" +
       "oiPqotsUuB4u9hQcrXMhjXbq80nWshZ2A1r3/V3obvpUHY35ycKdGllvOk/V" +
       "RB9JjQxVhxRptLElaWkttdP3GHixsg2bER3M38JMNTViJIH4wXLRki2yvwLi" +
       "hqum3YXCEY2pYRWTIckeZsJAHvYbVT6xuB20QPJ26nAa0pBnaL85Fak2cI6d" +
       "LdbO2tEcAsrtQuSCI0int4Vrs7qydkfzNg6PCTrgFjJMjxoBVucGY4fC66K6" +
       "0po9E7ZzsuozI2k+Se220JhVQzJasVo2d9JcHZBmf27uaiyF5MLOCUcol3Lq" +
       "dIzWaNxyO36UNCOOa1g7fRj0bVcaGPlqNLYMmIaJVAKbZE8fYM3JiPJSYZoJ" +
       "jTVljRquMDRcdoJ0e11UljiN5tN2aKOmFYW9NuJOs4kDnL4sIbA8S1KdIrsI" +
       "KkVdN5OBscxXXXnXRFwHRZWq2/CktEu7QE+5hLd3hlNf+C0PQseDmlRlkgzX" +
       "oBY1ELQ543u7KAR7Akx4/V48TylyusN7dbA32+7ONmcIwu+WNIkzO6o6D4M2" +
       "2oLNejWfszNcD3uiG4j1bkJm1kiU5FSZk8Fiq6iCxEWGpC/RGIK2pKvK7GYX" +
       "i81k2QVe1ay2OMhTqo1ma7LrUjY+q6tTo9/d0Wt7pig8VCP6yA6t5tUMVdSZ" +
       "C+P+hhXo4by+kDlttF5Iy6bXsTwdRaNYXwzW+MLdMlpr1FOIxXDZgni4BWl5" +
       "y1zVsk0DjTcGZ5ujvMb3G0tc6OS9mZ8jcsjkWIZETOw2Vaa1aDltg2l2Bi6L" +
       "mMEkEjJjhkiQA0uWZxhVosksaoKDMYKOeiSf6rHL4lqUOH0PKDLb37jVGl5V" +
       "hcmqK8a+2nQMOGam8ACua1HQy80ogXFzh9Y8DqI9nIgkzeYHHAMhKkaqQdXq" +
       "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" +
       "tIaoCevTdiM1CHWljxAIl/2avWGH7LjT");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("KT5lffH2Pqe9tvw8eJwedvgV7fnb+IqWXTzhpeMJ1ZMkgvKv+BR+JtPo1OfW" +
       "U7fHleLC7LGbJYOVl2XPf+TZ53TuF+pHn9vluHJP7AfvdozEcE4NdRcY6Z03" +
       "/4A/LHPhTm6Dv/SR//Go9L7VB28j/+Ut5+g8P+Q/HL7w5e4PaD97qXLH8d3w" +
       "DVl6Z5GePnsjfG9oxNvQk87cCz92LNlSuo+CRz6UrHz+Q/bJkt7yXuVcUsPB" +
       "CYBYAnzpYoAbsyU4KtOMoJBbifflovjXYIFCQ9FlL7bK3D3xRMd+7eW+1J5O" +
       "MygbfvWY++JCofIkeD56yP1Hb5f7d1zI/emUjv9wi77fLYp/H1euaopXpGvh" +
       "irZOlXCfX/l3Tnj8yvfBYwn2OHh++pDHn371efyDW/T9UVH817jywNKIacsx" +
       "+P2d+7lV/L3vg8P7jjj8uUMOf+7V4fAGHf7mzQH+XQnwv4ripbhyOQKLedGN" +
       "zuXEt/QTrr/+fXD9YOVQgT93yPXnXv11/bOXY/jPi+I7gK/COov6Keb+9NVg" +
       "7qVD5l56dZi7Y7+pRbe8mC0TvfYXs8/9/Sd/68efe/IPynyoK1Y0UcJOuLwg" +
       "2/gUzrde+Oo3fvs1j32+zCcsb42L2e89n6Z9Yxb2meTqkvz7jwVSpO5UngC8" +
       "/Yu9PPbvuLJ5VXNc1dDSlwaEA5pFLbSAF/aWlJdYoe+5hhcfJdb+v580u9CY" +
       "1F1sXLihFJdzB/cf3sEePPzykUY58A2Xwwf3Bdnx+Jf2SGc3rPLKknB8zyhy" +
       "DI/6Xne0mR1n+YPO7EJKf3VPaTnZnsyiePvLGObBE7foe1tRPBZX7tQKuvZs" +
       "3AL87VnliN+KXrZceRmrP/jBorjjQqs/uHw7Vp/FlTfdNGO5SL985IZ/vdj/" +
       "u4D2+ecevPLG5+Tf3RvZUUr/PYPKFXPrOKcz4k7V7wpCw7TKxb5nnx8XlPxc" +
       "jytPveIUa8B28Sp4OXj3Hr8eV669EvxiTYr3adxGXHn81rgAq3yfxsLiyiM3" +
       "w4ord4DyNPQPAZW8CBpAgvI05HtBLHIeEsxfvk/DvT+u3HsCBwxnXzkNQoDR" +
       "AUhRJYMjy2i98kz2s8qQHZwN8Y93mYdeTt9OnQqePOPzy3/+OYq7t/xhzs8X" +
       "nuuPfuzbzV/YZ1VrjpLnxShXgHveJ3gfx+5vveloR2PdxTz13Qe+eM/bj84Z" +
       "D+wJPtm6TtH2lotTmCk3iMuk4/yfvvEfv+cfPPf7ZRbc/wVCW43GlTUAAA==");
}
