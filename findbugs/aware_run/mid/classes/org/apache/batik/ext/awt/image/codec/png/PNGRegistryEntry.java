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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "s3snAAA=");
}
