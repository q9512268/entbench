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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "LZCLglC+NAQmrGO8nParqQDSZ304FyRSTBYUUcMWdpL2hh2cCSm1EvXj6RZf" +
           "j1oSD4+UbidRMz01R9t6rKfBYoMlGiFNprQ54Pq0Ww91fszIsOOPeY0kKq3O" +
           "she6amup5nAd3liI1QJC8jUY4Xg3UtasDoc9bRxNG46ermx42uNWCLskpDX4" +
           "nNVNt74iZ9KsKZi61K5yaymlnGlvKA2MDdZYul6XISbmyJ2kpOKqdjxT4DVL" +
           "bIYMYg7TWiwQWjRAZnq4kefkIAhMIlJxy1Xa5I5Uqjg/aWc1GxfntRHW5jlu" +
           "Em7JOs/y+GiIblWZqiWs3N2JK72J5v4ah61aawe3NYeO7K0wMNrt4jP/x+9v" +
           "++Hxcqfl+M6A7eBFxz+6jx2G7M4ED04IZsc7VeVuU1E57wTu1CnFhaPNnmfL" +
           "rZeTY9dBUY5XsRalWlTsQ7/jvGsE5R70pz/y8ivq+KeRg8N9LjqBLh3e7jgh" +
           "dgkM897zN9vZ8grFybnEb3zkT57hf8D84H2cvL7zDJNnh/yX7Ku/2f8+5Z8d" +
           "QA8cn1LcdrnjVqQXbz2buBKBWRV5/C0nFO841v3VQtXfA54vHur+i2d3CU+M" +
           "fps1L5TW3DvNXY7XXr1L32eK4mcS6KLiaIc3dc7ubaW+pZ443c/ea1vrNIWy" +
           "4dPHwhYb2uU++xuHwr7xVyPspUNvOXTNx45ds3TK423Ts0U51i/fRTn/uii+" +
           "kECPlC4+D1Q52W/sn6jjl74LdTxbNBbXPr5+qI6v34c6Dg73ah8F64ZiRr5n" +
           "7TT1nq7w7+7S9+Wi+DcJ9ORWthLecsTi5IC65Yzl9RPBf/27FRwFz58dCv5n" +
           "9y14UXzpnuL+7l36fq8ovpJA106LewdBf/u7FbQOnjcPBX3zr0nQP7xL3x8V" +
           "xe+DReVQ0HNN+tW/ApNeeGSPu3//NUj63+7S982i+PqJSQenT+NOCfon9yNo" +
           "lkCXj64PHUUY9C9xBwmsZU/fdv9xf2dP+cwrVy8/9cr8P5SXb47v1T3MQJf1" +
           "jeOcPuk+Vb8URJpulYI/vD/3DsrX/0yg5+/NXwI9AMpSoG/v8f4igZ67Ox5Y" +
           "Jsr3aaw3E+jp87AADVCegr5wkEBvuxM0gATlaciLwIxnIQH98n0a7nICXTmB" +
           "A1nEvnIa5BEwOgApqo8Gdzis2l9DyC6cyjwO/bv0lifu5S3HKKdvDBUqKG/F" +
           "HmUWm/292JvKa6/Qox/6FvbT+xtLiiPvdsUolxnoof3lqePs5N3njnY01iXq" +
           "he889vrD33uURj22Z/hkrp3i7Z13vhLUc4OkvMSz++JTn3/fz7zy1fLs7P8C" +
           "0uyO0a4sAAA=");
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
       "jv/gvqQu729cwZNHSy/D4OqclFr7Kp5UM8AhxqVKxxRYvG218JG/+qVP/fUH" +
       "n+selQl9X1qqDrxy65xulpSLzp/67Mff+prn//Jnq4KHbg7eVwr9wWr4J6v2" +
       "dtn8kyq+95S3/xTgQVStX2NgjulK9gku/D34XAPX/y2vUsmy4zDhP4KdrDre" +
       "drbs8MGU9wCzoOYLaiW8fN4woekAsEtP1lzws4981frk1z53WE9dTZIrxNqH" +
       "n/+Zvz/+6PNHF1axb79jIXmR57CSraLwurIhy7J78uVGqTjw//6FZ3/93z77" +
       "3EGrRy6vyUbgleNzf/R/fvf4E3/5O3eZ+kFWeFJ8mBfKtlE27zu4tf2SVfjP" +
       "DtpdAwB9X+MYPUbK39zLRa5s8LIhKvPIGMCJrdw+DQ4PXkFA/d3e2WjF/8b4" +
       "Yroc1u1XlCS/ayWBEx86Fzb1wCvAz/63j/3uv3j7V4FDxqcJWlIPwJzD//S/" +
       "b/5N+eP9r86ex0p7ltVqbipFMV3NFJp6ZtLkgtLzGMw33j/ApPih/0K2Iqp/" +
       "+pnWheE64/Kc09zuqNGOdAIeW3C/K7DdjUJiy8XI360IdmjstwQ3xDl9UMyb" +
       "swYbo0k3TVwScXzWpiYSy9v4tLY2cI7nlpZNsd7ECYLZmA0kn/YkievLok9Q" +
       "PC4FMutL9pD3MT9GYNVRnR6MOnlfctNloTRnqesWTT9qNuHYKXrIdttoTGdD" +
       "TF00HX2vFR7mN5qcEjsdXpo1UrFDzGNu5+urtNHppak8wCY2ZRmkWsc7O26c" +
       "xPzYWcf+zIqCUHbn3iTqKXs7EkR5IRWOyg+TdegtV2Mi1mYiV6d5W+rmyDbD" +
       "ZzYVspy4LEykbmt0hJq7rUhS2JSyxssGFbcUfYatxjStZLUVWmjjHhporcly" +
       "ve7GTpuRclKW2AbdDp0gN4iwaIc53vZNoh5rNrEqJt3dvrPhU8sgBnXBxhfY" +
       "INBD2LXqAZmsDQLj+NVmuESVqJeI8nrbm46R7UxFPcyr26jYtPYdtssKcscY" +
       "2v4yNKe5M1wQWBFoSTze6puhI6JTMDNipNYOgl2fn1HmSuJG9jjkgQRyNXYy" +
       "YshvlC5fpwdOzcXDPb8xpLZGLuYovctDmUvt8VwaT+xFj20hi2y0m2P7pUFh" +
       "e5nyRdWKOoU6HtP2hCy09ta2vLoqagXSXDcaAb9yPSZWu3NsWzir9Xo8m9al" +
       "bFfDZJuft4TFRtm3zJGStmaFYyJYM1M7sBUw/H7cqg22MRsQ64U10TSVJuTF" +
       "sK7OlVXfZSbMTuj1t1Q2W02mc0ZdOITPrgK8z1Muhyx3mq1F/fqYQbPpImMF" +
       "y6M3Y4Ps8EKQz4Jkv91I2YouKKu+F/StyrIj1lSyyBGi8Y4dTCOEkhfTNAVl" +
       "sJHHGafX+U0wsilyJkmiJzE91pmxrBOv5nSUm0oftXKCKEZd3WuM9eYi2w5a" +
       "q5EhLN0i28OqThhJ1tlsfLoYjXbTkIsTMdslPNKxFjJSD1yd385FfyEugobp" +
       "R3oX3yvRTnaXG0YbUKy47mHUsMMkGZLGTA9Garjb4IQFlyMOLjhmezpfLZb0" +
       "hnKCkAgpTSzMYrJe+XNj1+81l4GWI5bdG8yDIll5iVUQ4i6fDxzbDGiKhff4" +
       "iOCxASUFRBr47nCqplzcimuusxrh1HhTUHiazimYLnDDn9HhLKUiw+CDCRos" +
       "gmJGxwN4nkmU1ZoKaqQuLYZDhVBaRPs+LrRkUOVzdtBr0prQdy1Y3jvjAEcF" +
       "WPQNX071/UKNBbxFMPW+4ks6T9IzmIFjm9L0Bcqv6wLRKEb+sC9I7mTGG77o" +
       "8IG6H0/VKFea7jyusaYgkVnLWo9hfdCyibaGs9E06K9wrzbJpXmmDZcg86xw" +
       "1EjmC5OxehHjoGxf6I9tIyqCRjjrNFJ0pHQjNCLZ5WLRIwHG1YOePMQGujFv" +
       "bwq1izdXoVlvjTmKGHNbld+Yc8k2tHWQJX2sbRvNecPorLeca+FCJ0gFArOj" +
       "bI/7LJHWzEjZ+ULgtVRxTqNjadwl4nZhZEKzvkHyScPqJq62UyOYyGuL0RJT" +
       "BWpDUlk2iOcyMrOm+0GLy7fyMnHixkbvWTBDqkakLbfLyc6OQrMhmcNW0wj7" +
       "JunX5yIj8lqHzNtqm6Zq+aCvcKhR7+P9mbfaYNSAjbLU64wifj7O8hAr+O54" +
       "JLcaoSYvnF7TM6h6mzCZPFwKpqntPTfbaJnCwcR01dWkBtVZdYR6G0/HGE4V" +
       "jCoaDKxJGx3NGWOWxNMVV+Pi4UCb0kxRH4guhyUWj0phqAh91AVOXPS6NXOm" +
       "izFeeNNRD6emM4eUsd2WWGeGoSeTuqvVunqtidQFc9POs4lmtvAUM3RlMCWX" +
       "OtdfReOALupov9+ts/2QdgJhNk+WrmPj/tKZtSKmLdINZmCsuno45tseTVAO" +
       "IhZyB+4DD8O7YVHLY5EhWkuJ3m7CaKEUK2SPwZjBKK3YRlYdhEJht5ss0pQL" +
       "9K1LDUZEI0zaRn+zHJssvXSmi2mtyPU4i7FigGKioCcrpmnW9One5wob6WmM" +
       "QRS1mobPBGK/0OCwrrHduuPwqFDQ+yFAWEPBfRxdd9h10/DRhRrGXNJkCXo5" +
       "w7x+xggdrNHfk90tvWj6WXvdg2tRKMjrGm91jQkXIOJs2lia1owwrEGDRiN5" +
       "NBRTPW0Ziez0eHXIYbY6tvQZ3s9324m0bsrWZt3GpkJSbym9Fm2LSFsd1W1n" +
       "aSArrLPtTAQs2IZtdACnkc2qNVUT5Lzp2X1xxzPtAG/HG1hoN9aNNDWarRib" +
       "ulg0GFrjAiRH4TcUZBoiVEHq/XypNEU2ndpsfx+jitbtOXAu+iFjiAbOOkup" +
       "aSLz9YynU4PmEGwhL9ThtsHN0353yShW3LCS/lyy6PGubW/rQ4dXtp4ALxuD" +
       "rsYGvU6TpgR93msOU8mkyWA8Mq0CsxqT3CNVdUeEaMSkLtNGChTFR6ustm2m" +
       "rEoZk3CpNWdeuSuTujurpWnJchi2nNm42ExJa2IrMtllpIm6U5CuxYZ2g0Kw" +
       "WmxiLXKWLXprH7cmhiJ1FmOhsP1JEDNyJ2Hkdo1DB4KAkNF+wkeTSR7gLobk" +
       "DWLbQ8WYg4VmrNe1cay3Rsbcao4NV9gqjTRs9lYCueR5s1NHo0FvwTsThqiN" +
       "7FGI6i2acTYZvFJrCN9SrNE+CeO1YdXpqT6gmLw1EEmX2sZhmsALxA2Lbkiy" +
       "YAk/MgV0Be/rSs0ctHpUZ7zeWImN97IpTJJWboF5uZutETn2+0FrK07gXqan" +
       "6rSogfVKpxFg9WmEb7ChzsgbuOkVWjIZ1pEomyuGsYXBRO+zPEeMEYXUrGU3" +
       "0UPGzT053Nv8sNHqsIHfiVBlv9eGpgj7Yn1ak+VpUmu3Bt1xPgw1wkKnYtRP" +
       "9hIxR4lxytPbRF4ihKWTLDNz6Umy9Gr4sh2qTbiHq3Nmq5ppWtDrpDPqjdZY" +
       "nmDzVQ1NFFNFWqmuU4G+7Pi5OnJnk7rNMgFRE7o7ncuKtUrM196EZUaSsmjW" +
       "lXmjNxJUuNeZO6HDN7NGPQ/nowY62MCrFk47ah2Yq860zSZ191K06QU9dNn2" +
       "Ov6CtWkqSFHdac4jgGfsfNFdqetsnCAi0ptPrLZDuDye0O1lBjv1dIGtvALD" +
       "CXOEAuAc1yXe9zwbCWxQz4FMBFQgKuTIsSfcmpk0JvVOnR1JY0OPCG+YoJFG" +
       "9vlwsO9vdGsS9nMHM0f1ImW3w5qsM0js4ktnOJrt+H5XNtyuCt5d53yj0+82" +
       "ORLvs+TaynLZEE3e0xlrbLmuuLXRAlVgDpkZS88cUu62WW8KDCZyZL7dejhM" +
       "iruakhOdwEfrbGajszRDwHoKwaVBZy9I/YhwtDXe5Vw4UxfkvAvmzZGL9/WE" +
       "8cLeaomoi5XCUtlSZGl915lu0ZQZzlsorYTNMG4MeMI18i2DdqbFhhSG+xW5" +
       "1TkHV/ZsLU5wPRFWo3AEd9UapYudVSMdhFiy2vS4Tbqc8yijrdtcwfMtpB1r" +
       "eLRVElJtFMN+3crnCJzRyExLaayx5oSNnO1Z3WY2CYlps7jT65P9AA9Yj0lN" +
       "2HUFVe5Fw8Kb7ENj029HdXTrTzvwWu4TMYn6WHtPT01uZsXDzpivjQhKsIVN" +
       "M++0VdQUZ8Eqa3t+rWgtlh1MNYYD1OrRs7y7biLEQt6SjjTCe0NcDmi7lo9X" +
       "aEY052gds+muCvsKv8mNGInFwm3vwvpqXiaX6pNyD4Vjcu96hIHYGWZ7HIa3" +
       "58mMtRylHnQbfF3HA9tpLnYZLFIiwCdxskWRgunhTRP3+g2uSdczx8BQXeWn" +
       "RjNtzjp7hdfRSa01nC1Seu/sXKqQNmRh7MWo3cIm8qi75oY1c6gNGJaZp7LO" +
       "pa6YovswzEUcR6wMnqj7mCvWnZYS7mB1hOHDliJgKbWzc64eaSKsFT6rTRCH" +
       "CGBpwoy31NpeBgN9Z2HDXMJntZ6JblutRa4RNNfk3EHHjGyku4m6CYk2aScR" +
       "LZVZbU22r+s40Q/g2oaXFnS3yQ4IeKTWcGqvTqZJhrcbbVsQ2mGyWTNU0hH7" +
       "xIRHSEVuRIlhKjUOHkXyDNkgMnhr/f7yddZ8da/ZD1fbBmdnf+Dtunwgvoo3" +
       "6cOjJ8vmHWd7XdXn+uk50en3xW3l873Ga6dbFN/NuQm3mF46Nym3dN76UseB" +
       "1XbOpz70/Avq/NP1o5P9XSaGHow9/722lmr2BTXuAZLe/dJbV3R1Gnq+7/jl" +
       "D/3Px1Y/YHzgVZymPHFFz6si/x392d8h3qn83BF0z9ku5B3ntJeZnr6893gj" +
       "1OIkdFeXdiDfehaV15dBeApc5ElUyLufaNw1g65VGXTImyvb59cux/GJO+J4" +
       "OM6sztJBACsZH3yZLfifLJsfi6Gb5d6t4wMRsq0Bxrtt/Nwvg4lFk9zzZH32" +
       "lbZ9Lg5XdezPPPRI2Vme+YgnHhL/cTx0VBEclT8/VDbPVVQ/9zI+eL5sPgJy" +
       "1ZBc9dx64F7kFcok1FxVC8tDlWPctGMtPHfNR/8Brvme0+T5yIlrPvKP6ppT" +
       "6w5bi6U1VGnNaXfruzd6WB4DLsrbarxfehkn/3LZ/AJwcnlwcmm8t5ypcZC/" +
       "qORrF4gqh37y1Tg0j6FbV899y0OsR+/408nhjxLK51+4+cCbX+D+uDr6PPsz" +
       "w4NT6AE9se2LZw4X7q/7oaablXkPHk4g/OrrCzH01CsDbAxw0D/MIZ8/8P1q" +
       "DD3+8nwxdJ955pYTri/G0KMvxQXGAO1F6l+LoTfcjRpQgvYi5a8DH16lBONX" +
       "3xfpfjOGbpzTxdD1w81Fki8B6YCkvP1P/mncu9/FHNSXQfgkJb48EV27MJec" +
       "FE+VIo+8UoqcsVw81y1Hrf6ydDpXJIc/LT2jfOGF8exHv9X59OFcWbGloiil" +
       "PDCF7j8ccZ/NN0++pLRTWdfJd33noV958B2nc+NDB4XPC/mCbk/c/RB35Phx" +
       "dexa/Nqb/8P3/ZsX/qI6fvp/CAt3TksmAAA=");
}
