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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hL37PLyc6vY8uJzMA+C5oC6er57Dk+KCcHA9dxhqz53Hk0tQ+fB9ZZP3lOXN" +
       "ovgbpU0ug/ANyzQ0Ar0bjmQdhvFfgd8lcP2f4ip4Fi/28/bjxGHycOM4e/DA" +
       "TAWiYlMFJn7f3U1chtM+HXr5Hz37G598+dnfKz3yISMEA4EHmzvkZ6fafOuV" +
       "r3/jt9761FdK1L6ylsL9kJxPbC/mrWfS0XIEHzkewQKMoRsAyP7NfgD39wiS" +
       "/x9zhXVgKCBJ6AApeTkwvAiku11nZwSuYwMeRynJd6Ob9N6BxwaGDWaL3WEy" +
       "i7zw+NfNn/qjL+8T1fNRdo5Y/cyLP/JXB5998fKp5cGzFzL00232S4TSCG8t" +
       "im4h3Xvu1UvZoveHX33hX//jFz69l+rxs8luF6zlvvyf/vLXD1763V+9Qw51" +
       "ZZ1F6jE0XTpMdor/HyoK6ihGFneJkeLxA0VBlmJ3QcxYqrOJ9JJycqhFceMi" +
       "6D7gfcXjyEuPu7y851P+f0d0OMEUAAFWH66jFnPVUd0+VzPcg+OVH6hMLwgf" +
       "QM/f3aDj0ttP4OyXP/UnT86+V//4m0jSnjlnkPMsf3b8yq/23y//2GXovmNw" +
       "u7AsPNvo1llIuxqoYB3rzM4A21N7e5TjtzdGUbyvHOF7TK/be9SVa7gNQDe5" +
       "GOq9Ze5B7qbQPgMrylpRfGQ/+s27zncfuojGzx+i8fN3QePgHp5GnPG0AlVL" +
       "MUbnxArfuFhl0vlhcB0civXBu4iV3VmsS6VYRxI9AtYdhjyJy72KknRwNvO7" +
       "Bq7gsKdgD6b/fxdeoWeA5OdYiO/CUu91e0yP4rf/Ous1wOngbpxunqq4O1x9" +
       "8shaP/wG4aooxKL4aFH8wEVcKv7eLgrpItAU/5V9t2XrotDvET9/7x51ny2K" +
       "HykKey/JPWg/dyEO8zcZhxi4KoduWLmLw//4G49DYMbz3v72guuTxTAddnNp" +
       "7+23LyZIH7rhx1Jo+LEbqR/Yr5du7POuG2XWdWO/H/bRj90YM2T39gQfd/kb" +
       "33PDUZPDmk9I9vqFjx4cHHzs1nOed+xu10+mkj3d3f3mC0dKv/wd+c1L36Hf" +
       "fKFk9tLr+c2X7lH3M0XxD4/95qV7+c3PXvCbF9+k35Dgqh4atHoXv3nlDfvN" +
       "w7Zhq8fbAS+dk+3LrytbySa9BJbZ99cO0INK8f+f3bn3+44NeFaEd20t+eaR" +
       "S84BtICp/+bWQovqf3BOoO4bFgikII+eOB/tOptbP/oHn/v1v//s10EGNoLu" +
       "3xWrIZBJnPLQPbL9nVc+/9RbXvzdHy33EICrzP/uP6n/ecH1X705tZ4s1OJL" +
       "/KalMBqXy35VKTS7U152BUz/m+9Y2+j6FweNcIgf/eiqKC1xOeWW8VK2WyJX" +
       "bySRkdFyxPCirtjNmJ+iRE8cR2K28qy4YYzNheKodW3geBVRdHzLWpnNWa/b" +
       "8LpDbtVqCK2unIRSd+wZ+pDHF0OhOm0YPkMNs34XJ81Rh9ATQcf9kTHYKTIS" +
       "Dga7oe76dcnxbLXdRJE5Wm/BcLtaZ91pTk/Gprmuzo3ujNsKxo7z191NRouB" +
       "K/BLurbR2y4yinrKEKHrUR0bDhOfc/VKm+EnfIfuxdWZP/ITLtQxbs2svLEj" +
       "9P1pZcOl5ChYuAy/SjlF6WfdvNcKsZVvDIN1t8MKxGxFj8y0YgxT0QhSmmLb" +
       "0abTb4YKbmbb5Yh2fZh2UU73zLqoJ5mqNLJBiK2beNZoNK2xMpRrWWvCK91Q" +
       "aHPujO6tFKxhemncYrwer3CSznBrMfCa2xnWb9VIsye0SXg1YZy01qQmyNhj" +
       "ukt+MqqmWCuZVCf0fCz6Q5OX6lFVtfpqlMnGwjNGvRaZd7eDWc+pEJtx3513" +
       "BotIoSICNheBOBsiTL7oMx7hkZwrrBbqdLkyDduiBz1y0FemwnAS1upO3iej" +
       "JMiqSegS3RrWZNfBLgpjadByNzOeMXml3xe4imj18STD9TE1rnf9hR3xBueu" +
       "XL4i0eQqaXPCqLcUJald8VsLczIErqHZiiQPmKDbm7D+Cp2jBLMaxaIlWnEz" +
       "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" +
       "6BlWdPjRobT3f3y9nbEzhzyAF104fFac");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("pHniwonY/SlO+SsvX3voXS8L/3n/Jf/opOXDNPSQFlvW6YMPp54f8AJVM0q1" +
       "H94fg/DK2zci6Lk3fEougq4Ut1KHP9m3/x8RdPONtC++IRb3021fi6Cn790W" +
       "tCrvp1v9zwh64m6tIug+UJ6m/rMIevudqAFl8VHiFOVfRND185Sg//J+mu4v" +
       "I+jqCV0EPbB/OEVyCQLcAUnxeMk7cqjXO4x4r49b6aWzEX/sao+/nqudAoln" +
       "z3z0Lo9lH32gjvcHs2/LX315NPnEa60v7c/IyZaU5wWXh2jowf1xveOP3O+5" +
       "K7cjXg8Mnvv2oz//8PuOYOfRvcAnmHFKtmfufCCta3tReYQs/5fv+ucf/pmX" +
       "f6fc9/6/fVrdsy8vAAA=");
}
