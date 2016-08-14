package org.apache.batik.ext.awt.image.codec.png;
public class PNGRegistryEntry extends org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry {
    static final byte[] signature = { (byte) 137, 80, 78, 71, 13, 10, 26,
    10 };
    public PNGRegistryEntry() { super("PNG", "png", "image/png", 0, signature);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter handleStream(java.io.InputStream inIS,
                                                                         org.apache.batik.util.ParsedURL origURL,
                                                                         boolean needRawData) {
        final org.apache.batik.ext.awt.image.renderable.DeferRable dr =
          new org.apache.batik.ext.awt.image.renderable.DeferRable(
          );
        final java.io.InputStream is =
          inIS;
        final boolean raw =
          needRawData;
        final java.lang.String errCode;
        final java.lang.Object[] errParam;
        if (origURL !=
              null) {
            errCode =
              ERR_URL_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "PNG",
               origURL });
        }
        else {
            errCode =
              ERR_STREAM_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "PNG" });
        }
        java.lang.Thread t =
          new java.lang.Thread(
          ) {
            public void run() {
                org.apache.batik.ext.awt.image.renderable.Filter filt;
                try {
                    org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam param =
                      new org.apache.batik.ext.awt.image.codec.png.PNGDecodeParam(
                      );
                    param.
                      setExpandPalette(
                        true);
                    if (raw)
                        param.
                          setPerformGammaCorrection(
                            false);
                    else {
                        param.
                          setPerformGammaCorrection(
                            true);
                        param.
                          setDisplayExponent(
                            2.2F);
                    }
                    org.apache.batik.ext.awt.image.rendered.CachableRed cr =
                      new org.apache.batik.ext.awt.image.codec.png.PNGRed(
                      is,
                      param);
                    dr.
                      setBounds(
                        new java.awt.geom.Rectangle2D.Double(
                          0,
                          0,
                          cr.
                            getWidth(
                              ),
                          cr.
                            getHeight(
                              )));
                    cr =
                      new org.apache.batik.ext.awt.image.rendered.Any2sRGBRed(
                        cr);
                    cr =
                      new org.apache.batik.ext.awt.image.rendered.FormatRed(
                        cr,
                        org.apache.batik.ext.awt.image.GraphicsUtil.
                          sRGB_Unpre);
                    java.awt.image.WritableRaster wr =
                      (java.awt.image.WritableRaster)
                        cr.
                        getData(
                          );
                    java.awt.image.ColorModel cm =
                      cr.
                      getColorModel(
                        );
                    java.awt.image.BufferedImage image;
                    image =
                      new java.awt.image.BufferedImage(
                        cm,
                        wr,
                        cm.
                          isAlphaPremultiplied(
                            ),
                        null);
                    cr =
                      org.apache.batik.ext.awt.image.GraphicsUtil.
                        wrap(
                          image);
                    filt =
                      new org.apache.batik.ext.awt.image.renderable.RedRable(
                        cr);
                }
                catch (java.io.IOException ioe) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          PNGRegistryEntry.this,
                          errCode,
                          errParam);
                }
                catch (java.lang.ThreadDeath td) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          PNGRegistryEntry.this,
                          errCode,
                          errParam);
                    dr.
                      setSource(
                        filt);
                    throw td;
                }
                catch (java.lang.Throwable t) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          PNGRegistryEntry.this,
                          errCode,
                          errParam);
                }
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "XBwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OS0Sdkbv1Xo9z9ruxkCERHCipo31bbuP9dA6bFvYkPacoZj7VuHKLcnGcFWD" +
       "U7jWrqn80GiPwZzpWo4ibAzLlydoLcCWrVwSQF6rqak0XovC1iJwHpeJVcvU" +
       "YLfR0wemkGTOFKBSHBjzpD9I2dBiNJSR/SVRo7saM2sF2rQbdCQvaXcRTY0L" +
       "ZD9oh8WgJiOL2WY3pjDSsHMTn6mRSgjhst7s0JsgF1PN32e01RPJ8boersVA" +
       "ElNfo9BuL0FGKwlb9gBMNTfsit3rO2daCPWJ0Nqn8c5LgsDOonZjV1NUt4t4" +
       "ea/P8LtglVqbRW3ah8f1zZRBewMjkvtNpm2bySJD6yrD7EVr6ospuunE5LbR" +
       "b1NwoWnbRrMzau9YboSEQWNkBM0tMVeFcSIOkDHKhLs50kXlGZjgdWrRk0EI" +
       "t92lgDUJYu1JTrFHdGUvM/XVEGON6TYoWEwS7S6jb9DhnuSb+cIfyMygb3c3" +
       "U9u2W+O85fvDTE93IAnzqAZMqw6hh3Z/5NLhSPYScRR4dUJOdSoQw4TMlCYc" +
       "4RvHaNYcra31CHK5HaxqQkYWOJw7TZamloGKui18QHVhq8uTUpQNPFUYCWD1" +
       "jRM4sWMTRUXynqA6bkHWDTiN2PY06e/RQbRqaKKKNLAByIpSfsDlkxk7iU0n" +
       "9Hw6j0M4SIPWOpdbrcZ8ks5mimqiPWVr70S4VWjbIozRdqjhxDTSZg1hrzOu" +
       "K0SjHcoO2Ahpo9YiWBWzSbzuz1KU0rf9ngnyckIfUVNmumow/Q5lufYYx2tG" +
       "gFN7tqMm5kgUaJpqs9Z0ySniTAnrFKcrxqRo5rLTcmQGmTtFHvMdKUsybtru" +
       "5N6s07U7O2nU8Uf1+sqWWt5i0e0QuxY7lzuriWjWW5Y5GhTsKt87vOUtoy2I" +
       "2KUnO7HTbwVeywpYJTZXxaaHBk1D2i2wdIz7DNeDGzsarG6bSqPpREUNh9vN" +
       "XbppSS2lPc9n4zq9IujlljBbzXCKusSYkqZ0zC1lez9BhYmwLiiBafoI05cM" +
       "AWThqyEncEE4o2RpydrdwYawh/02VoflabJsC85cr/tct71IBX1vJ5OexOzd" +
       "3ZTcLkcG0u5jbL3v1xFVmONeMx52d8LYXSx5GFWH+82QTDAY7a66nXHRwbf4" +
       "2h7kIkss27bq5w29PqKBGrQpN9HYpBYSwXTkZbu2Go5k3bAdrCbkWDF2THHE" +
       "g8lBshiybdWbXs+LU7XHkHM8zHY4HkpCu81mEmqwktCyVG3agfm+yuTcIsUM" +
       "mhUXJJHAA0dDBVPReqOpsESadbM36ErsbuHjSUM3lirXxIqkh0+n2Vwlm6Eh" +
       "KJOhInQSVKW3AL8bMslw8aY7M3csr04VJHNGMcyvvbRl73OPJhRzrvUxOWnm" +
       "yd6dZiCXwElx7rdjx4gRo1Okk0mxoocNp5mLos2itlav2foE768pHiFDeLSO" +
       "U6SRI1NujS28bZvK4prD9zF3Ou6o+I5Nh63VvD+vT3zSTmk24vek7PFST524" +
       "1HpV6wn0wJtNWzk7H7bcSG5Od629h+84N9oziEbTbKOWK/wQnfr6nKUzkSC4" +
       "5cjCxXoDbXVJjHFXHZxRaLw1FetdgpJ3XteibYJss3x3uq2LnO5bPXM7M+Et" +
       "UxT1tYgstcBqzZ0mcJs138FTTWu3N11Ds4t8E1tJf6R6tL1hgjWNupxMpF5g" +
       "+l0qDnvEosuGc2ScUY19v+5Ou37bnCg2DnKByXbgYUgwHg44vkgj3cKdSGPn" +
       "KWYJXYzjSLCureN93mzr0wXSbhMWniv+zOP3QgjzPAGaZvW26Qd+Imozn9iR" +
       "rjNAhLq3bLSbbu7rAUW4nQjli4yMHC5Euh6tb7Aoo2qR4m47CzprBRzGBNvc" +
       "CrERkfJCAg/VxKvjw4ZLoMluoc+ZKBwsdhYiwpjdUQ2iueecqDZqdrUC2ey9" +
       "2Rifj8ShjnoWN27iRc4h0QyzZakmDrHcgvPauqXa+rSzA4vmD36wXE5//Ntb" +
       "5j9R7WicfRcAVvdlxe7bWMnnF3aAzrZrq99N6MpZ8sUDpvNTB6jcWnzmQcf9" +
       "1bbi5z/2yqtm/wvo0cn2j5pCj6Zh9Dc9a2t5F0QdtgvNMzWeLMU/C64Pnajx" +
       "oaub7+eG3tNl16ouy++3q3X90KeXdwrd8JgLoixV09g62aMDdc/dczh8OPev" +
       "PjrRhuL9NlMeXoShZ+lB1fY/fYNtsH9WFp9OoceWemB61uWWkTc5lo6twLTi" +
       "cuPymHG91IrPx/szb7Zzc+kEKYXuXD3YLk/pnrrnO5vDtyHGF1+9/ci7XtX+" +
       "0+GA4PT7jUdF6BE787yLhyoXnm9GsWW7ldWPHo5Your2Wgp997d6/p5C10FZ" +
       "GfCvD9xfSqG73wp3uTFZ3i/y/kwKPfvGvICrul/k+nIKPfUgLqAfKC9S/2wK" +
       "vf1+1IASlBcpfw6MwlVK0H51v0j3Cyl065wuhW4eHi6S/CKQDkjKx/8QnXrT" +
       "i2/STUnkHku64xqHbchL3pBfuxzuZ3725Jv52QWEeOHSTnr1qdfprnd2+Njr" +
       "JeNLr/LyR7/R/MLh9N3w9KIopTwiQg8fPgQ42zl/zwOlncq6yb7/m4//9KPv" +
       "O8Wcxw8KnwPGBd2eu/9RN+1HaXU4Xfzsu/7t9/2LV3+v2pT9v37ZDXSDJwAA");
}
