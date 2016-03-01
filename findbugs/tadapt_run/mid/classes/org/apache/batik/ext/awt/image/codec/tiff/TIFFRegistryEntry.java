package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFRegistryEntry extends org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry {
    static final byte[] sig1 = { (byte) 73, (byte) 73, 42, 0 };
    static final byte[] sig2 = { (byte) 77, (byte) 77, 0, 42 };
    static org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber[]
      magicNumbers =
      { new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber(
      0,
      sig1),
    new org.apache.batik.ext.awt.image.spi.MagicNumberRegistryEntry.MagicNumber(
      0,
      sig2) };
    static final java.lang.String[] exts = { "tiff", "tif" };
    static final java.lang.String[] mimeTypes = { "image/tiff",
    "image/tif" };
    public TIFFRegistryEntry() { super("TIFF", exts, mimeTypes,
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
              (new java.lang.Object[] { "TIFF",
               origURL });
        }
        else {
            errCode =
              ERR_STREAM_FORMAT_UNREADABLE;
            errParam =
              (new java.lang.Object[] { "TIFF" });
        }
        java.lang.Thread t =
          new java.lang.Thread(
          ) {
            public void run() {
                org.apache.batik.ext.awt.image.renderable.Filter filt;
                try {
                    org.apache.batik.ext.awt.image.codec.tiff.TIFFDecodeParam param =
                      new org.apache.batik.ext.awt.image.codec.tiff.TIFFDecodeParam(
                      );
                    org.apache.batik.ext.awt.image.codec.util.SeekableStream ss =
                      org.apache.batik.ext.awt.image.codec.util.SeekableStream.
                      wrapInputStream(
                        is,
                        true);
                    org.apache.batik.ext.awt.image.rendered.CachableRed cr =
                      new org.apache.batik.ext.awt.image.codec.tiff.TIFFImage(
                      ss,
                      param,
                      0);
                    cr =
                      new org.apache.batik.ext.awt.image.rendered.Any2sRGBRed(
                        cr);
                    filt =
                      new org.apache.batik.ext.awt.image.renderable.RedRable(
                        cr);
                }
                catch (java.io.IOException ioe) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          TIFFRegistryEntry.this,
                          errCode,
                          errParam);
                }
                catch (java.lang.ThreadDeath td) {
                    filt =
                      org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                        getBrokenLinkImage(
                          TIFFRegistryEntry.this,
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
                          TIFFRegistryEntry.this,
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
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "D73r5em/3e/iH53AfJiBHtIT2z596OHU");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8wN+qOlmqfbD+yMQfnn7Zgw994ZPyMXQfcWt1OFP9+3/WwzdfCPtiz3C4n66" +
       "7Wsx9PS924JW5f10q/8eQ0/crVUMXQHlaeo/j6G334kaUBYbC6co/yKGrp+n" +
       "BP2X99N0fxlDV0/oYuiB/cMpkksQ4A5IisdL/pFDvd5BxHttUKWXzkb8sas9" +
       "/nqudgoknj2zqV0e1z7agE72B7ZvK197ech94rXGl/fn4xRbzvOCy0MM9OD+" +
       "qN7xJvZ77srtiNcDg+e+8+gvPfy+I9h5dC/wCWacku2ZOx9GIx0/Lo+P5f/4" +
       "Xf/wwz//8h+Wa9f/BxvGCcZHLwAA");
}
