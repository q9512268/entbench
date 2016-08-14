package org.apache.batik.ext.awt.image.codec.jpeg;
public class JPEGRegistryEntry extends org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry {
    static final byte[] sigJPEG = { (byte) 255, (byte) 216, (byte) 255 };
    static final java.lang.String[] exts = { "jpeg", "jpg" };
    static final java.lang.String[] mimeTypes = { "image/jpeg", "image/jpg" };
    static final org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[]
      magicNumbers =
      { new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber(
      0,
      sigJPEG) };
    public JPEGRegistryEntry() { super("JPEG", exts, mimeTypes,
                                       magicNumbers); }
    public org.apache.batik.ext.awt.image.renderable.Filter handleStream(java.io.InputStream inIS,
                                                                         org.apache.batik.util.ParsedURL origURL,
                                                                         boolean needRawData) {
        final org.apache.batik.ext.awt.image.renderable.DeferRable dr =
          new org.apache.batik.ext.awt.image.renderable.DeferRable(
          );
        final java.io.InputStream is =
          inIS;
        final java.lang.String errCode;
        final java.lang.Object[] errParam;
        if (origURL !=
              null) {
            errCode =
              ERR_URL_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "JPEG",
               origURL });
        }
        else {
            errCode =
              ERR_STREAM_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "JPEG" });
        }
        java.lang.Thread t =
          new java.lang.Thread(
          ) {
            public void run() {
                org.apache.batik.ext.awt.image.renderable.Filter filt;
                try {
                    com.sun.image.codec.jpeg.JPEGImageDecoder decoder;
                    decoder =
                      com.sun.image.codec.jpeg.JPEGCodec.
                        createJPEGDecoder(
                          is);
                    java.awt.image.BufferedImage image;
                    try {
                        image =
                          decoder.
                            decodeAsBufferedImage(
                              );
                    }
                    catch (com.sun.image.codec.jpeg.TruncatedFileException tfe) {
                        image =
                          tfe.
                            getBufferedImage(
                              );
                        if (image ==
                              null)
                            throw new java.io.IOException(
                              "JPEG File was truncated");
                    }
                    dr.
                      setBounds(
                        new java.awt.geom.Rectangle2D.Double(
                          0,
                          0,
                          image.
                            getWidth(
                              ),
                          image.
                            getHeight(
                              )));
                    org.apache.batik.ext.awt.image.rendered.CachableRed cr;
                    cr =
                      org.apache.batik.ext.awt.image.GraphicsUtil.
                        wrap(
                          image);
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
                          JPEGRegistryEntry.this,
                          errCode,
                          errParam);
                }
                catch (java.lang.ThreadDeath td) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          JPEGRegistryEntry.this,
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
                          JPEGRegistryEntry.this,
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
       "BeL7rxw7/wOsj1ks+x4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "87Mv/2m5P/x/AH9qy78eLAAA");
}
