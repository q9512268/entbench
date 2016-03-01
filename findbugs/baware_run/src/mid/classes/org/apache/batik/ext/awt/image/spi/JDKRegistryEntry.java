package org.apache.batik.ext.awt.image.spi;
public class JDKRegistryEntry extends org.apache.batik.ext.awt.image.spi.AbstractRegistryEntry implements org.apache.batik.ext.awt.image.spi.URLRegistryEntry {
    public static final float PRIORITY = 1000 * org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.
                                                  PRIORITY;
    public JDKRegistryEntry() { super("JDK", PRIORITY, new java.lang.String[0],
                                      new java.lang.String[] { "image/gif" });
    }
    public boolean isCompatibleURL(org.apache.batik.util.ParsedURL purl) {
        try {
            new java.net.URL(
              purl.
                toString(
                  ));
        }
        catch (java.net.MalformedURLException mue) {
            return false;
        }
        return true;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter handleURL(org.apache.batik.util.ParsedURL purl,
                                                                      boolean needRawData) {
        final java.net.URL url;
        try {
            url =
              new java.net.URL(
                purl.
                  toString(
                    ));
        }
        catch (java.net.MalformedURLException mue) {
            return null;
        }
        final org.apache.batik.ext.awt.image.renderable.DeferRable dr =
          new org.apache.batik.ext.awt.image.renderable.DeferRable(
          );
        final java.lang.String errCode;
        final java.lang.Object[] errParam;
        if (purl !=
              null) {
            errCode =
              ERR_URL_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "JDK",
               url });
        }
        else {
            errCode =
              ERR_STREAM_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "JDK" });
        }
        java.lang.Thread t =
          new java.lang.Thread(
          ) {
            public void run() {
                org.apache.batik.ext.awt.image.renderable.Filter filt =
                  null;
                try {
                    java.awt.Toolkit tk =
                      java.awt.Toolkit.
                      getDefaultToolkit(
                        );
                    java.awt.Image img =
                      tk.
                      createImage(
                        url);
                    if (img !=
                          null) {
                        java.awt.image.RenderedImage ri =
                          loadImage(
                            img,
                            dr);
                        if (ri !=
                              null) {
                            filt =
                              new org.apache.batik.ext.awt.image.renderable.RedRable(
                                org.apache.batik.ext.awt.image.GraphicsUtil.
                                  wrap(
                                    ri));
                        }
                    }
                }
                catch (java.lang.ThreadDeath td) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          JDKRegistryEntry.this,
                          errCode,
                          errParam);
                    dr.
                      setSource(
                        filt);
                    throw td;
                }
                catch (java.lang.Throwable t) {
                    
                }
                if (filt ==
                      null)
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          JDKRegistryEntry.this,
                          errCode,
                          errParam);
                dr.
                  setSource(
                    filt);
            }
        };
        t.
          start(
            );
        return dr;
    }
    public java.awt.image.RenderedImage loadImage(java.awt.Image img,
                                                  final org.apache.batik.ext.awt.image.renderable.DeferRable dr) {
        if (img instanceof java.awt.image.RenderedImage)
            return (java.awt.image.RenderedImage)
                     img;
        org.apache.batik.ext.awt.image.spi.JDKRegistryEntry.MyImgObs observer =
          new org.apache.batik.ext.awt.image.spi.JDKRegistryEntry.MyImgObs(
          );
        java.awt.Toolkit.
          getDefaultToolkit(
            ).
          prepareImage(
            img,
            -1,
            -1,
            observer);
        observer.
          waitTilWidthHeightDone(
            );
        if (observer.
              imageError)
            return null;
        int width =
          observer.
            width;
        int height =
          observer.
            height;
        dr.
          setBounds(
            new java.awt.geom.Rectangle2D.Double(
              0,
              0,
              width,
              height));
        java.awt.image.BufferedImage bi =
          new java.awt.image.BufferedImage(
          width,
          height,
          java.awt.image.BufferedImage.
            TYPE_INT_ARGB);
        java.awt.Graphics2D g2d =
          bi.
          createGraphics(
            );
        observer.
          waitTilImageDone(
            );
        if (observer.
              imageError)
            return null;
        dr.
          setProperties(
            new java.util.HashMap(
              ));
        g2d.
          drawImage(
            img,
            0,
            0,
            null);
        g2d.
          dispose(
            );
        return bi;
    }
    public static class MyImgObs implements java.awt.image.ImageObserver {
        boolean widthDone = false;
        boolean heightDone = false;
        boolean imageDone = false;
        int width = -1;
        int height = -1;
        boolean imageError = false;
        int IMG_BITS = ALLBITS | ERROR | ABORT;
        public void clear() { width = -1;
                              height = -1;
                              widthDone =
                                false;
                              heightDone =
                                false;
                              imageDone =
                                false; }
        public boolean imageUpdate(java.awt.Image img,
                                   int infoflags,
                                   int x,
                                   int y,
                                   int width,
                                   int height) {
            synchronized (this)  {
                boolean notify =
                  false;
                if ((infoflags &
                       WIDTH) !=
                      0)
                    this.
                      width =
                      width;
                if ((infoflags &
                       HEIGHT) !=
                      0)
                    this.
                      height =
                      height;
                if ((infoflags &
                       ALLBITS) !=
                      0) {
                    this.
                      width =
                      width;
                    this.
                      height =
                      height;
                }
                if ((infoflags &
                       IMG_BITS) !=
                      0) {
                    if (!widthDone ||
                          !heightDone ||
                          !imageDone) {
                        widthDone =
                          true;
                        heightDone =
                          true;
                        imageDone =
                          true;
                        notify =
                          true;
                    }
                    if ((infoflags &
                           ERROR) !=
                          0) {
                        imageError =
                          true;
                    }
                }
                if (!widthDone &&
                      this.
                        width !=
                      -1) {
                    notify =
                      true;
                    widthDone =
                      true;
                }
                if (!heightDone &&
                      this.
                        height !=
                      -1) {
                    notify =
                      true;
                    heightDone =
                      true;
                }
                if (notify)
                    notifyAll(
                      );
            }
            return true;
        }
        public synchronized void waitTilWidthHeightDone() {
            while (!widthDone ||
                     !heightDone) {
                try {
                    wait(
                      );
                }
                catch (java.lang.InterruptedException ie) {
                    
                }
            }
        }
        public synchronized void waitTilWidthDone() {
            while (!widthDone) {
                try {
                    wait(
                      );
                }
                catch (java.lang.InterruptedException ie) {
                    
                }
            }
        }
        public synchronized void waitTilHeightDone() {
            while (!heightDone) {
                try {
                    wait(
                      );
                }
                catch (java.lang.InterruptedException ie) {
                    
                }
            }
        }
        public synchronized void waitTilImageDone() {
            while (!imageDone) {
                try {
                    wait(
                      );
                }
                catch (java.lang.InterruptedException ie) {
                    
                }
            }
        }
        public MyImgObs() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "m6IY5/O+MIu8otBk4qmj//T+F6zJmt8sIQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "PXPA2HO71w1XsrWMkmo487mQovSUG6XemOVchuVquxESaXC/kWJZQ0MyNYym" +
           "4i7DsHWgN/H1uoItq1tamkacH470nssJamDm8QxuY8g6HEwG401KOd6gXlMC" +
           "2aiP15XdQlhzNJKhOi6k7VqFU9Fkset5NU/u9FaEQkbmajSeZNwmNRsOJ8zD" +
           "Kd/rofO6QPL81NzK3MwhLbvFrN2OjNt20G67tUEoroQuNWPYliv0TIbxrYWN" +
           "mqI8kGlPCzm/S8bBYjYfLTiHl327uqNoxeK8IVM3twTZme/ymThutzrMtOtM" +
           "RFfaSQNXXbaHHuMaUc2BR0ZXZzbteLQ2XIujrXF/Tqeb+kBqMLkjqK4oLvtj" +
           "BZkoDV526n1L6nUryzG1GaVZfx0m3Mi3+4Alc+O1FWVETttuO6p6lQm5yg27" +
           "Lrkgp/YbEYmwLExOa33Gj7rpWKCmvN9j6rNW1ayNRHntCH6fXtbH3hpppqkK" +
           "0xtd7hEYVjGb/qi9yqw2JfPTsYpZ+cgkxSA0w445zpVVddiOKWSMT1m1R2pV" +
           "Sqp1x9aWclLFxUJ3Z4vtlu3mCGOw1izpR6gf91pePlHR7Xiw2C3NuVxvbWE7" +
           "42wpNypU5FRWUSNjwko7N/h2p9135r3WUBY8le2b47EvJI67HTpK1h6xJj/F" +
           "zW6k7lZm6HWsuqlYiM3YBtpehi2DYgy3vWRb3Z4kq2ibY6povu4ts05NZVfO" +
           "bJLq1iSnJG6UdBciFYZRtS/KrLSKhdT1JSJeEctsnVgrab5lTFim+7OmKCBG" +
           "C9mhg9VCoPv9lRVUzT6+HHYmWBtdbmvbWjLqditIV0+QIYwJzmy+q9c0A525" +
           "Pl4Hwu22jD7m/Q6y7M0XjjgU9ErLj3q2yMYtD2vyfXjBZ0m+iCKR9EXFDzdd" +
           "IfOGkxzH4ExZVvOGo6D4lHJHlbmlTEi1PabEZkB16W7dDxN5MXWEdtSNJJsb" +
           "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" +
           "U19430+/8rXy7Ov/Ak5Kg66KLAAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVYa2wU1xW+u8brBwY/AOPwMGAMEgR2Q3m2piFgHjassbUG" +
       "qixJzOzsXXtgdmaYuWuvTV0CUgDRBkXBpLQNVqWSpkUQUNv0kSqUqo8kSimC" +
       "Rm0S1CRNfiRtghR+NE5L2/Sce3d2ZmfXBtQfXWnv3r1zzr3n+Z1z5+wNUmyZ" +
       "pMGQtLgUZP0GtYIdOO+QTIvGm1XJsrbBapd89C/H94/8oeyAnwSiZGKPZLXJ" +
       "kkU3KlSNW1EyU9EsJmkytbZSGkeODpNa1OyVmKJrUTJFsVqThqrICmvT4xQJ" +
       "dkhmmFRLjJlKLMVoa2YDRmaFuTQhLk1orZegKUwqZN3odxim5TA0u54hbdI5" +
       "z2KkKrxb6pVCKaaoobBisaa0Se41dLW/W9VZkKZZcLe6PGOIzeHleWZouFD5" +
       "ya0neqq4GSZJmqYzrqIVoZau9tJ4mFQ6qxtUmrT2kq+QojAZ7yJmpDFsHxqC" +
       "Q0NwqK2vQwXST6BaKtmsc3WYvVPAkFEgRubkbmJIppTMbNPBZYYdSllGd84M" +
       "2s7Oamu726PiiXtDQ19/pOoHRaQySioVrRPFkUEIBodEwaA0GaOmtTYep/Eo" +
       "qdbA4Z3UVCRVGch4u8ZSujWJpSAEbLPgYsqgJj/TsRV4EnQzUzLTzax6CR5U" +
       "mX/FCVXqBl1rHV2FhhtxHRQsV0AwMyFB7GVYxu1RtDiPo1yOrI6NW4AAWEuS" +
       "lPXo2aPGaRIskBoRIqqkdYc6Ifi0biAt1iEETR5ro2yKtjYkeY/UTbsYqfPS" +
       "dYhHQFXGDYEsjEzxkvGdwEvTPF5y+efG1tXH9mktmp/4QOY4lVWUfzww1XuY" +
       "IjRBTQp5IBgrFoafkmpfPOInBIineIgFzU++fPOBRfWXXhY00wvQtMd2U5l1" +
       "yadjE6/OaF7w+SIUo9TQLQWdn6M5z7KOzJOmtAFIU5vdER8G7YeXIr998NEz" +
       "9EM/KW8lAVlXU0mIo2pZTxqKSs1NVKOmxGi8lZRRLd7Mn7eSEpiHFY2K1fZE" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "08+96k/f/EdPfis/Pvo/6QFyQycmAAA=");
}
