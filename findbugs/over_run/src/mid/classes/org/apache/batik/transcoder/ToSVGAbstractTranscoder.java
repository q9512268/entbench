package org.apache.batik.transcoder;
public abstract class ToSVGAbstractTranscoder extends org.apache.batik.transcoder.AbstractTranscoder implements org.apache.batik.util.SVGConstants, panda.runtime.PANDA_Attributable {
    public static float PIXEL_TO_MILLIMETERS;
    public static float PIXEL_PER_INCH;
    static { PIXEL_TO_MILLIMETERS = 25.4F / (float) java.awt.Toolkit.getDefaultToolkit(
                                                                       ).
                                              getScreenResolution(
                                                );
             PIXEL_PER_INCH = java.awt.Toolkit.getDefaultToolkit(
                                                 ).getScreenResolution(
                                                     ); }
    public static final int TRANSCODER_ERROR_BASE = 65280;
    public static final int ERROR_NULL_INPUT = TRANSCODER_ERROR_BASE +
      0;
    public static final int ERROR_INCOMPATIBLE_INPUT_TYPE = TRANSCODER_ERROR_BASE +
      1;
    public static final int ERROR_INCOMPATIBLE_OUTPUT_TYPE =
      TRANSCODER_ERROR_BASE +
      2;
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_WIDTH =
      new org.apache.batik.transcoder.keys.FloatKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_HEIGHT =
      new org.apache.batik.transcoder.keys.FloatKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_INPUT_WIDTH =
      new org.apache.batik.transcoder.keys.IntegerKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_INPUT_HEIGHT =
      new org.apache.batik.transcoder.keys.IntegerKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_XOFFSET =
      new org.apache.batik.transcoder.keys.IntegerKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_YOFFSET =
      new org.apache.batik.transcoder.keys.IntegerKey(
      );
    public static final org.apache.batik.transcoder.TranscodingHints.Key
      KEY_ESCAPED =
      new org.apache.batik.transcoder.keys.BooleanKey(
      );
    protected org.apache.batik.svggen.SVGGraphics2D svgGenerator;
    protected org.w3c.dom.Document createDocument(org.apache.batik.transcoder.TranscoderOutput output) {
        org.w3c.dom.Document doc;
        if (output.
              getDocument(
                ) ==
              null) {
            org.w3c.dom.DOMImplementation domImpl =
              org.apache.batik.dom.svg.SVGDOMImplementation.
              getDOMImplementation(
                );
            doc =
              domImpl.
                createDocument(
                  SVG_NAMESPACE_URI,
                  SVG_SVG_TAG,
                  null);
        }
        else
            doc =
              output.
                getDocument(
                  );
        return doc;
    }
    public org.apache.batik.svggen.SVGGraphics2D getGraphics2D() {
        return svgGenerator;
    }
    protected void writeSVGToOutput(org.apache.batik.svggen.SVGGraphics2D svgGenerator,
                                    org.w3c.dom.Element svgRoot,
                                    org.apache.batik.transcoder.TranscoderOutput output)
          throws org.apache.batik.transcoder.TranscoderException {
        org.w3c.dom.Document doc =
          output.
          getDocument(
            );
        if (doc !=
              null)
            return;
        org.xml.sax.XMLFilter xmlFilter =
          output.
          getXMLFilter(
            );
        if (xmlFilter !=
              null) {
            handler.
              fatalError(
                new org.apache.batik.transcoder.TranscoderException(
                  "" +
                  ERROR_INCOMPATIBLE_OUTPUT_TYPE));
        }
        try {
            boolean escaped =
              false;
            if (hints.
                  containsKey(
                    KEY_ESCAPED))
                escaped =
                  ((java.lang.Boolean)
                     hints.
                     get(
                       KEY_ESCAPED)).
                    booleanValue(
                      );
            java.io.OutputStream os =
              output.
              getOutputStream(
                );
            if (os !=
                  null) {
                svgGenerator.
                  stream(
                    svgRoot,
                    new java.io.OutputStreamWriter(
                      os),
                    false,
                    escaped);
                return;
            }
            java.io.Writer wr =
              output.
              getWriter(
                );
            if (wr !=
                  null) {
                svgGenerator.
                  stream(
                    svgRoot,
                    wr,
                    false,
                    escaped);
                return;
            }
            java.lang.String uri =
              output.
              getURI(
                );
            if (uri !=
                  null) {
                try {
                    java.net.URL url =
                      new java.net.URL(
                      uri);
                    java.net.URLConnection urlCnx =
                      url.
                      openConnection(
                        );
                    os =
                      urlCnx.
                        getOutputStream(
                          );
                    svgGenerator.
                      stream(
                        svgRoot,
                        new java.io.OutputStreamWriter(
                          os),
                        false,
                        escaped);
                    return;
                }
                catch (java.net.MalformedURLException e) {
                    handler.
                      fatalError(
                        new org.apache.batik.transcoder.TranscoderException(
                          e));
                }
                catch (java.io.IOException e) {
                    handler.
                      fatalError(
                        new org.apache.batik.transcoder.TranscoderException(
                          e));
                }
            }
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.transcoder.TranscoderException(
              e);
        }
        throw new org.apache.batik.transcoder.TranscoderException(
          "" +
          ERROR_INCOMPATIBLE_OUTPUT_TYPE);
    }
    public ToSVGAbstractTranscoder() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVaa3Ab1RW+kuNnHNtxEifkRXCctAmJRAiPdkwpji3HIrKl" +
       "WoohAqKsV1fyxqvdze6VLZumISkQHpkMAw6lFNLONJSWMYTplNJpB0inLY+h" +
       "hQmFlpYpUNoZoJAO+VEMpYWee3dXu1pplVj8qGf2+vo+zjnfOeeecx+ePoWq" +
       "NRW1K5yU5HxkQsGaL0LrEU7VcLJb5DQtBq0J/ra/3rVv5vf1+72oJo6aRjit" +
       "n+c03CtgManF0QpB0ggn8VgbwDhJZ0RUrGF1jCOCLMXRIkELZhRR4AXSLycx" +
       "HTDEqSE0nyNEFYazBAcNAgSdG2LS+Jk0/i7ngM4QauRlZcKasLRgQretj47N" +
       "WPw0glpCu7kxzp8lgugPCRrpzKnofEUWJ9KiTHw4R3y7xYsNRVwZurhIDe2P" +
       "Nn/4yR0jLUwNCzhJkgmDqA1iTRbHcDKEmq3WgIgz2h70DVQVQnNtgwnqCJlM" +
       "/cDUD0xNvNYokH4elrKZbpnBISalGoWnAhF0XiERhVO5jEEmwmQGCnXEwM4m" +
       "A9pVebSmuR0Qj5zvn/rWzpYfV6HmOGoWpCgVhwchCDCJg0JxZhirWlcyiZNx" +
       "NF8Cg0exKnCiMGlYu1UT0hJHsuACplpoY1bBKuNp6QosCdjULE9kNQ8vxZzK" +
       "+Ks6JXJpwNpmYdUR9tJ2ANgggGBqigPfM6bMGRWkJPOjwhl5jB3bYABMrc1g" +
       "MiLnWc2ROGhArbqLiJyU9kfB+aQ0DK2WwQVV5msuRKmuFY4f5dI4QdAS57iI" +
       "3gWj6pki6BSCFjmHMUpgpaUOK9nsc2rgssPXS32SF3lA5iTmRSr/XJi00jFp" +
       "EKewimEd6BMb14fu5tqeuMWLEAxe5Bisj3n866ev2LDyxLP6mGUlxoSHd2Oe" +
       "JPhjw00nl3ev+3IVFaNOkTWBGr8AOVtlEaOnM6dApGnLU6SdPrPzxODTO254" +
       "CL/nRQ1BVMPLYjYDfjSflzOKIGJ1K5awyhGcDKJ6LCW7WX8Q1UI9JEhYbw2n" +
       "UhomQTRHZE01MvsbVJQCElRFDVAXpJRs1hWOjLB6TkEItcCHlsF3DdJ/4rQg" +
       "iPhH5Az2czwnCZLsj6gyxU8NymIO1qCehF5F9g+D/49u3OS71K/JWRUc0i+r" +
       "aT8HXjGC9U4/UTlJ4yEkqf6YHB3a2jUM7s/xJJZv91HvU/5PfHNUHwvGPR4w" +
       "1XJnoBBhjfXJIoxN8FPZLYHTjySe152QLhxDkwRtBuY+nbmPMfdZzH0uzJHH" +
       "w3gupELorgGGHYUQATG6cV30uit33dJeBT6pjM8Bq9Cha4tyVrcVS8wEkOCn" +
       "Tw7OvPi7hoe8yAvhZhhylpU4OgoSh573VJnHSYhcbinEDKN+96RRUg504p7x" +
       "/UP7LmBy2HMBJVgNYYxOj9AInmfR4YwBpeg2H3znw+N375WtaFCQXMycWDST" +
       "Bpl2p4Wd4BP8+lXcY4kn9nZ40RyIXBCtCQerCwLhSiePgmDTaQZuiqUOAKdk" +
       "NcOJtMuMtg1kRJXHrRbmevNpsUj3QuoODgFZzP9KVLn/1Rfe3cw0aaaHZlte" +
       "j2LSaQtJlFgrCz7zLe+KqRjDuL/cE7nryKmD1zDXghGrSzHsoGU3hCKwDmjw" +
       "pmf3/OmN14+97LXckUBOzg7D9ibHsCz8DH488H1KPxpGaIMeTlq7jZi2Kh/U" +
       "FMp5rSUbhDcRljp1jo7tEjifkBK4YRHTtfCf5jWbHnv/cItubhFaTG/ZcGYC" +
       "Vvs5W9ANz++cWcnIeHiaXi39WcP0mL3AotylqtwElSO3/6UV336Gux+iP0Rc" +
       "TZjELIgipg/EDHgR04WflZsdfZfQokOz+3jhMrJtgxL8HS9/MG/ogydPM2kL" +
       "91F2u/dzSqfuRboVgNlyZBRmUGe/aW+bQsvFOZBhsTPo9HHaCBC76MTAtS3i" +
       "iU+AbRzY8hBYtbAK0SpX4ErG6OraP//yV227TlYhby9qEGUu2cuxBYfqwdOx" +
       "NgKRM6d89QpdjvE6M+XkUJGGqNLPLW3OQEYhzACTP1v8k8sePPo680Ld7Zax" +
       "6U0a3eM5YyPbqFvL+v3XvvO3p2a+X6un+XXuscwxb8m/w+Lwgbc+KrIEi2Il" +
       "tiCO+XH/9H1Luy9/j823wgmdvTpXnHIg4FpzL3wo8y9ve81vvKg2jlp4Y1M8" +
       "xIlZupLjsBHUzJ0ybJwL+gs3dfoOpjMfLpc7Q5mNrTOQWakO6nQ0rc9zeF0r" +
       "teJG+K4zvO46p9d5EKv0sSlrWPlFWpzPTOil1Q0QVDS29c7lCTP3mF+GMEEL" +
       "I8GrA6FELJzoD4ZCwf5ALDAYZQvN5hL0DBbNQhaOqEIGguSYsUM83jaz59e1" +
       "kz3m7q/UFH3kNq3/xZ/3vZ1gQbiOptWYqQxbwuxS07bg3kKLjXTFlXE4h0T+" +
       "va1vjN73zsO6RE7vcgzGt0zd9pnv8JQeHPVTwOqijbh9jn4ScEh3XjkubEbv" +
       "28f3/uKHew/qUrUW7mkDcGR7+A///a3vnjefK7E9AneSOZJf8578hqbNqW4d" +
       "VM2m+z/ed/OrYcjAQVSXlYQ9WRxMFnpirZYdtunfOmFY3mnAo4mIIM96RTGS" +
       "LC0vpUVQd7NO1wi1pdC/vwDfTsMNd7r4965y/k2LUAnfdiNKUJPu25HAYCI4" +
       "0N1HW7/mQMGdPYoltLUTvqTBMFmEwpPfNNDA4QvCSTON1da3vndsZv/BL3lp" +
       "7qseowEGvKDFGjeQpSfkm6ePrJg79ebtLELDFoCRHimtkSpLI9RDBIkTHZpZ" +
       "XEZQOEfGBrsGot3hHlBNYHAwPJjY0hUNMAphw6/pr0FbfYigKkEqckT657VO" +
       "3xBmqdUgfNgQFpfQKq3sNlUycUaV0EIuoQ83FgS16EoY2B4KgatEtsdou+pA" +
       "NTlLVEPwpQyWqTKomA4PVIzKjQVBK3RU4Pvh/khXLLglFNDRJWI7IoFSEL85" +
       "S4hXwZc2+KfLQGQr+PaKIbqxgGNFCYjh7bFyGA/NEuM58ImGAKNFGPXANVUx" +
       "tFEXygTVbwvsSFwV7InpWX8JQReUPSkbVUFK99F12rENTziQH6kA+R5DPsUF" +
       "+dGKkSsulAlqoMj7AsGtfWwd3uuA8d1ZwqCXNGMGs6wLjB9UDCPrQhnOGhSG" +
       "vt6YGUthebACLNcbHCddsDxSMZZJF8oQIC0s7oY5XgGYGwyW+1zA/LRiMPtc" +
       "KBM0l4K5OtzbGw2UxPF4BThuMrjd6ILjyYpx3OhC2cCxwx3HUxXguM3gdqsL" +
       "jqcrxnGrC2UDRyDa3RUJ9JTC8czZ42imrevhO2RwO+SC44XSODwQdxVVJnDg" +
       "w0kHiHllyBLUqI2ljSsa420CIvaaoogNo9JY8kWHtm5VOWVE4LULexxwXywD" +
       "N1f+BFjHGVellujsh6olbtTjDtFtdwEeU+72IrnZUQWkzj8u0ZPPCrdXB3bq" +
       "OXZg6mgy/MAmr3GJcxXolsjKRhGPYdHGtYqdoZw3EP3srcU6zl/60kzVa3cu" +
       "aSy+mKWUVrpcu653Pzk6GTxz4B9LY5eP7JrFjeu5DvxOkj/qn35u61r+Ti97" +
       "LtJvD4qemQondRae1BpUTLKqVHg2a88bl64rtAa+I4Zxjzjd3fKtNbQ4WezS" +
       "blMd13GeQg/ZcDZ7EayGs0TJEibFKQdB+/3eaVq8Ayc2XsUcwT0yn81g47AB" +
       "zBZSZuObeV9SzvgKOtmCefdM8aHgsow2XMGa/55XBt3poLXwHTOUcayMHoti" +
       "Blt8jmDRUIZYGUV86t7nYSQ+ImheGpPC4PGKpYuPP7cummjXKvgeNsSfnr1P" +
       "TbtMdaCrsnLHK6atF9htTR/EwdS0659MBw3lvdJ/dl4ZyPFYoWub0WyiRTXs" +
       "ccZVgWCIcTFZd1tG1XEGnjMmC8m8uj01s1d3jqDFLs9a9CJ3SdF7u/5GzD9y" +
       "tLlu8dHtf2RPK/l33MYQqktlRdF+z2ir1ygqTgnMYo36rSO7yPEsJWhZGV3B" +
       "Htz6g+LwnKPPWwFqcs4jqJr9to9bBRSscQTV6BX7kNUEVcEQWu1QTAP6yhmw" +
       "WGE5jy2PGMmRLYNFZ7JLfor9EYfmCPZfEWY8z+r/F5Hgjx+9cuD605c8oD8i" +
       "8SI3OUmpzA2hWv2pKp8TznOlZtKq6Vv3SdOj9WvMvFjwiGWXjbkLVBSlyN/p" +
       "3WaJ6z9IfezlJsHf9eRrkZSi3OtF9UFUDdkY59iVd8+ENIj5MbXgbrBmWM5K" +
       "+f9raKK+xdF/ZGACGzjn5Vvpsx9sEYovSoufQhtEeRyrWyh1lr4cyS2rKPZe" +
       "Bvgafb1RBRDkuVphx0MPQnWPlwyYCxS6qjybaf3a3P8AS5eO/aAkAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV6eawr13kf333aLes9ydZiWZvlZycy7Tskhytekno4HM5w" +
       "OPtGclLreTgznIWzcRYOSVeJbSSRm6Su0UquizpC0SpoY8ixWyRp0SKtiqBN" +
       "ggQBUgTd0MaB0SWN6yL+I04Rp03PkLzLu+/dJ12lQC9wzj086+9bzne+c+Z7" +
       "49ulu5O4VI5Cb215YXportJD12scpuvITA5JqsFpcWIaqKcliQTqbujPf/3K" +
       "d7/3BfvqQeketfQeLQjCVEudMEgEMwm9pWlQpSsntZhn+klaukq52lKDstTx" +
       "IMpJ0utU6V2nhqala9QRBAhAgAAEaAsBQk56gUHvNoPMR4sRWpAmi9KPlC5R" +
       "pXsivYCXlj5w8ySRFmv+fhpuSwGY4b7itwKI2g5exaXnjmnf0XwLwa+WoVf+" +
       "xotX/+Hl0hW1dMUJxAKODkCkYBG19KBv+lMzThDDMA219HBgmoZoxo7mOZst" +
       "brX0SOJYgZZmsXnMpKIyi8x4u+YJ5x7UC9riTE/D+Ji8mWN6xtGvu2eeZgFa" +
       "HzuhdUdhv6gHBD7gAGDxTNPNoyF3zZ3ASEvPnh1xTOO1IegAht7rm6kdHi91" +
       "V6CBitIjO9l5WmBBYho7gQW63h1mYJW09OS5kxa8jjR9rlnmjbT0xNl+3K4J" +
       "9Lp/y4hiSFp69Gy37UxASk+ekdIp+Xyb+YHPfyoggoMtZsPUvQL/fWDQM2cG" +
       "CebMjM1AN3cDH/wI9UXtsV/+3EGpBDo/eqbzrs8/+kvf+fhHn3nz13Z93n+b" +
       "PuzUNfX0hv769KHffgp9oXO5gHFfFCZOIfybKN+qP7dvub6KwM577HjGovHw" +
       "qPFN4V9NPv0V81sHpQcGpXv00Mt8oEcP66EfOZ4Z42ZgxlpqGoPS/WZgoNv2" +
       "QeleUKacwNzVsrNZYqaD0l3etuqecPsbsGgGpihYdC8oO8EsPCpHWmpvy6uo" +
       "VCpdBan0fpB+uLT7U4ssLaWQHfompOla4AQhxMVhQX8h0MDQoNRMQNkArVEI" +
       "TYH+zz9WPWxBSZjFQCGhMLYgDWiFbe4aoTTWgkQPDTOGpFBUcGQK1F/TU+m4" +
       "/rDQvuj/07qrgh9X80uXgKieOmsoPLDHiNADfW/or2Rd7Ds/f+M3Do43zp6T" +
       "aQkGix/uFj/cLn54svjhOYuXLl3arvneAsRONYBg58BEAOP54AviJ8hPfu75" +
       "y0Ano/wuIJWiK3S+DUdPjMpgazp1oNmlN7+Uf0b50cpB6eBmY1wAB1UPFMO5" +
       "woQem8prZzfh7ea98vLvf/drX3wpPNmON1n3vZW4dWSxy58/y+I41E0D2M2T" +
       "6T/ynPaLN375pWsHpbuA6QDmMtWAegNL9MzZNW7a7dePLGdBy92A4FkY+5pX" +
       "NB2ZuwdSOw7zk5qt7B/alh8GPH6qtM+O9sP2f9H6nqjI37vTlUJoZ6jYWuYf" +
       "FKOf+Xe/9d/hLbuPjPiVU8eiaKbXTxmOYrIrWxPx8IkOSLFpgn7/6UvcX3/1" +
       "2y//8FYBQI8P3m7Ba0WOAoMBRAjY/OO/tvj33/jd13/n4ERpUnByZlPP0Vc7" +
       "Iv8M/F0C6f8UqSCuqNht+kfQveV57tj0RMXKHz7BBoyQBzZkoUHX5MAPDWfm" +
       "aFPPLDT2T698qPqL/+PzV3c64YGaI5X66FtPcFL/vm7p07/x4h8/s53mkl4c" +
       "gif8O+m2s6zvOZkZiWNtXeBYfeZfP/03f1X7GWCjgV1MnI25NXWlLT9KWwFW" +
       "trwob3PoTFutyJ5NTm+Em/faKWflhv6F3/nDdyt/+M++s0V7s7dzWu60Fl3f" +
       "qVqRPbcC0z9+dtcTWmKDfvU3mb941Xvze2BGFcyoA8uWsDEwF6ubtGTf++57" +
       "/8O/+JXHPvnbl0sH/dIDXqgZfW274Ur3A003ExuYrlX0Fz6+0+b8viObvyrd" +
       "QvxOQZ7Y/noYAHzhfFvTL5yVk+36xJ+w3vSz3/xftzBha2Vuc0afGa9Cb3z5" +
       "SfSHvrUdf7Ldi9HPrG61ycCxOxlb+4r/RwfP3/MvD0r3qqWr+t5rVDQvKzaR" +
       "Cjyl5MiVBJ7lTe03ez27I/76sTl76qypObXsWUNzchaActG7KD9wxrY8UnD5" +
       "YyB9Ym9bPnHWtlwqbQsf3w75wDa/VmTft5XJQVH8frCfk61vup39hbT0Xm4w" +
       "xqgbEnuDHlDUgMYkTBDvLD4udnxgf5Z7Fwl66ZFvzL/8+1/duT9nZXWms/m5" +
       "V37yzw4//8rBKafzg7f4fafH7BzPLdx3bzEX2v+BO62yHdH/b1976Z/+/Zde" +
       "3qF65GYXCgM3hK/+m//9m4df+r1fv81pDIQTaunOVBc5XGTITsGb526G6zeL" +
       "6vtAenEvqhfPERV3J1EVWe9ITA/txMRhwo0BgxJF7eAMQP7tA3yiqL0OkrEH" +
       "aNwC8NLxqVKo9+EAXBgsM37km3/79T/+zMvtg8I43r0stgHg7tWTfkxWXHR+" +
       "4o1Xn37XK7/3U9uDBJwR26lHtyf28gmxBeedQPOOiH5UEhBGRNkeoBoTBFa4" +
       "0UVEbDtBf68KxT8yLV0GF5oz7BhfkB0DkMw9O8zbsKMoTI5oMd+SliJ78YiQ" +
       "qzv0jExRQHycLBX1nzwDeHZBwApIsz3g2R0AXyoK/sUAP70DDFSNpTlEGnQp" +
       "bAf8hjThsNuhDy6IfgSStUdv3QH9di9kF0P/zG3Qs7J0J/jLC8J/H0jeHv78" +
       "nN390sVQ3z/EJjdGg55EbEc8mpYqd7wV7Ivgrk0A7U+uDc31GaJ+5B0QtdgT" +
       "FZ1D1E9cjKgHCqIIbIATW53/7BmEL18QYXHXXO4RZucg/CsXQ3ilQLjT7S3z" +
       "bwfz8+8A5qf2MDfnwHzlgibkBOb57Hz1HeD89B7nj56D829dDOe7Cpxjtt8X" +
       "sdtC/PI7gPjje4g/dg7Ev/MOIE7Oh/h33wHEn9xD/MvnQPy5dwARE1GEw3q3" +
       "g/iVtw/xSlH7EZB+eg/xp8+B+PXbQwRXwPujOEyBd2saR/geTJbW/pa3f4QE" +
       "5upDt5gr0Msyg0NRwfFYi2xHT2q9M5T8g7ekZLskOBKAd1A7bB1Wit//5GLs" +
       "fNz19GtH11PFjBNwu7jmeq0j5KccmN3r5RmQL7xtkMBreuhkMioMrOs/9Z+/" +
       "8Jt/9YPfAC4TeeQyFb1VwFrui9jVjxc/fuVi9DxZ0CNu360oLUnp7T3YNI5J" +
       "OuMd3eWFfw6S0qv/kagnA+Toj1Y0DUamVWFUnmdMQDDpCnNmc2GM6inikwLi" +
       "cMY8j1wHJgbx0BuFoY0sholSna1Xi6WxMZsKpWb+QJzzRDSnkbzp9RmKZUhx" +
       "RE+kyGPIqFtxAmpStm3e73vRJJKZUA1JhC0rGB1NRqYJG+OsGkWe4rYX+KxW" +
       "XobljRvMWNM09VXZ5MLRghFG1WFjLTeI1ZxPcI2qUDEmtxSdIqeNHp92FxUS" +
       "ijUIjpVlYzmrllu1kAybmuA6aVDWKzCaWrQW9Cs8gGNZQVuxpnnPJtWKIMd4" +
       "v+qiLErRY2EwxyjVFoQ6Mhaptb4ipB62ELFKsGaw/kTbdBGdQSzRwGuUWCbn" +
       "FchpBRZd57VM8FR9qCWUYPGxmbr1FjPi8orlRWjWmq82UduzMotDhTjaDINw" +
       "hskjsjN0JCKvC/C6tZokjKDkahbbg55Z45gAqq+FikvJOYNubHJu+b0FUnUk" +
       "YUrovSHmL+CRNbA2NbtV6Sm8wgdMauXBAiU9GtJ7cq+yYpbMJJwTddOLh+o0" +
       "CroDUfPwcBQgdr8ydjDBVtiGi2F+7vM4GoyxnK77SCdSzKnoZ0KFdxubZQDF" +
       "o000mSlNwmfB4Ai1FDvXbbSHklaFXKm2E488fe2ozIrpt1GrYq6GAerQuDfJ" +
       "qrJUsUkiyRA08qJwUp12hxkTNfkwQQ1XprDOnOHby5W6GZaHSZMck1HORP7E" +
       "kIVOStYQxrIsvLtwLG5GN6c0LozmJMe6ue013C48nSBdOtarFu1QwUivCSxu" +
       "I/F0QTnkWu7MZ92yxld6w9oo5xWl4SeZMPSz/qQ+axiDOm8gYqPlDGBr5Daj" +
       "udPsimjf9QlajqxIk9lhB7hjtdhKEm4swjWxD3tIw5F8QYyhMelUKm4/woZm" +
       "7viY0ezS02p9ljXShZnRIwpDVmaj6yQuHLSbTXNZo3rrFcU1fVz2VqFIGDXW" +
       "JDnbzSuVwIPNZRkeKH2NYefSqIvHbYRVUg/T2IBuGkiEB5TcFA0u5jYrtiex" +
       "tUYdpaBA4KtdheaoiTvpzVxx5m3Y4QAnwR7R8rWNAxUhmxQ6ao3Gbb4qDzok" +
       "Zk+meS2Q7dDnJYFQsUqVXiZTheRRzBP6PQUZR6SQVO0R61LdpjTHBqmOEl7S" +
       "h3sGCdVj3nI4m2ggm5q+yQNUpRK3aa1XcptZ+wO2ukBNu9/od6xyD6p3MpgV" +
       "W9UhRI4EWa845ViT2sTYxdGOXIdkySPra2y+mDUnRBfWaq5MtxJoRZLqslMl" +
       "ljLU4GYEIxP5EueEel4dk0HY7drubEwOwhXT7nMqNSEkdy2a1UaNp+xVb54L" +
       "aTeblIOpz9EzQ90QlWxDEkQOW1mEUeAsw3FiIvOIhDd1Ba5kTgrDBml2pWbk" +
       "0u3uooPaWj1dK7GuiO0cm7NoIOUtdsk5LTs022tkaau2vfYiuc5aoWg3WrBC" +
       "BoQ4sfWpE2C9IVPuNAVBthqVetRaQTLXovzuukbQXVKxmMlkxbodZBD4M6E+" +
       "ybuRadUIeBPkZQZuNUap1kf5Mb3WRz1R6kZeLaqPjHqXa5e9sT6pz4NOoNYr" +
       "wnow7qIpypsxmlO26JgcMAuSxquZs5BZZGjMGZ0lUzqjU6s6F8gxEQtT31wy" +
       "USK7MJ+FbM/qqxuuM1SoAKoKMxPW84qmaYTqpaYLbJrGp6TXt2J009pQZnm4" +
       "ENxeRkE61gri9dDvVTe9sWXjsbghkhCXYRsd5j3fzSN/BkOsz1Tr5U6LGutz" +
       "ucturFav40yJBN20e0S93SaqQ24V4dqANiVv0XJVpza0IblPR41YlKd2Txc8" +
       "N6q6YSvFXHAIdYf1iUBI6QydNdzRlAiWkD5Is6nd1yQcUnV8girLpDHqIMym" +
       "XNZHejAwCUcbO3BnpHMVn4KRMF17izTHPJGFoaaswHATz1Zlh6sIuqS6GDWw" +
       "nMiCsB5hCZX6aOapiTFTZ3w4Zzdl2LXpmEytFdUmxA5E41BorQ2Ors2pTrVf" +
       "yyBjIy5mmTANgYS9tdoVfBk3IW1UnvLJss+qXTuRuLBDEBraRVtNWkJSEXYc" +
       "uYxMhc2kbXcn6RQZVsRoXMdivMnGGgdBa6VWa0nexJ6uOwsMl7Oanq26k9ki" +
       "N9gVYw0FYBfaHT4y3CXWpMvjuUzi+IKhOGoEszw2sTcIKnHVZXveTkyOC5vt" +
       "CmW0VG3VlCsabNKNyZqbLvpLqryEx8slC0c1rTxuZkF5PM4SPV9N2z6Ul6nc" +
       "murlYTzAnNrASx2ULY8JqENUqWzdgdx2Dc4t31hK0TggBla9H20oOA/b687S" +
       "bFeXy6FVc72oPqnS7dXAU7OIcpMuIW/IynpK5lTZSmBjFrJg882oSG/xDZ+J" +
       "JZYfaXO2GfCVWO9szH4lTk0SLw/rmyVbb0Ydo4ENl5VE9OIR5/VH0YaTWMer" +
       "8hVe6Ym1jt7yAOWw3y/jNAZE28ZjpNnHKHIT9uoqms8aCNVDJiq/ZBo2Vel1" +
       "pwxva+wC3MCsTJwkMt2GXW3T6JjV+Qb2WwugmwQ8ZxYwtFIheKlWLX7qsFE6" +
       "miz41TTPVmKlNbXg+ZByx1LfG2N1uyKVl1p16TIteJOwTQFrLXVrg6eVjdGJ" +
       "gmWb5E2CU6ScXTju1O64QV3UMRseu/Nsik2XtTbYR9mQMHNoIcfyqOXPezou" +
       "tMoIBEEavAxcczZsYR0kMEVWJWftRqttL6bMYlQ3FLrmlzeQaUBsPNFdhFfE" +
       "sTfhOyNhRfeDyInViZFmwK/y+xPYD5Cw7g8GNLBaEi5SaGUZyQpvtBi2mjvV" +
       "yEChZd6bSQnNGK243mk21tC8RslIMDMcZiiTXFZrEMgEHdQrTJUYtSCfp3GD" +
       "m4ReSsnSciF16b6P5RE3Y5geUueXqCixTNUoiDASdQl1KdiLWovEDHMMXw57" +
       "fdw1+Uiczf2mycWk1eqY05TCqF4/RAXC8dO5GFGDjtDrDuYSoUbqGFN5Fpvh" +
       "3TjBwxS2Ca/LTAgk50h3UrFlhkYiO29CUVzpT2cTxxrOsYU+l5qNlsLCq66/" +
       "MGRrxlh8P5rxwwWcMJ681mVNqWCDLOTbcN8Sq00snNS69aGlpViaGGFWjhBG" +
       "8igF4/KIX48W0jD0kTqnDDZDl1e6Q1iQ69zShub2mKIs4Av3BHI0aA1CcD+l" +
       "2g2xbo9zVa+VhzOKx/m4zGnDwXSxsnCmj05cuzXtr3EEYrCMbrQHPo4MmT7O" +
       "jRFGkVdpHxuvLUmZ5stE7OdKaxBE4HwnecGUOXE+VeT+sNPpV2sxxkgbhyea" +
       "c6QsNHpcIvfLBj6ci0nmId4ipN0WkuDpbJQbcJYhbaOq5gt0zOA0njRzyu12" +
       "5B7KxbwdAJdKxJdpc4LLqW1OEZRi9CmBGkbSW4m0qpL9dsgP0ErSCieNsYVP" +
       "8Hw9Klc3CEQJDs2l+rBLV7z6sMGmmyme1+QV1693JTujY9doDih3PYlWMGuj" +
       "NR1d5SuYkFdjK6Nhy1gklLvQ41WAx2hN7gnrngZYS3ZICW3rG7Vec/zYXNps" +
       "TcjZsojW62OR7eW8sVLAsdyz8sqccAjPW3cpeTGoea6YaPVaBR0sNS0MLSbs" +
       "kJP2fESkfkNhRwpWp2TKXK3y8TrvMdVZudt3CVwxPS9zE7sZetNUcntpPzVy" +
       "zJTB5WIQB6rMj+Ybt51VVI5DY2MMXNIFO1atpm+tIRrxYxgn9dU49BJ3KNg4" +
       "NzEIPJ0sjFDNYYyDk1iXmxsPalbmG0WD9UwT12V/OJKVONKzZgPmNvMmLq02" +
       "9W6HmjRMrkXGfdfMGr3lip270CKAG1mzGpclBxy5Kbns1Remz4eBIWhmtRvJ" +
       "EjVcKIRV09rtqdesxymilQd1deVuXAOeDVNmytdH5kacerRRhXGTt8CZ2lNb" +
       "mLbGk4pEYs60P+SNbhmCTU1ZtJG1Xhsnsp5LlXXQrlr1FtLddFVRzdipqXTE" +
       "zdIasqmPmjODbmuElYR5bUzjGtRojLspHIXUOCckVta1NU2EqdP10rbr9wR5" +
       "oAL9UtrNtBVMRL488G0Tjzi0zuHDaJJxXEvPfN8dD5eWySTiLIirnDRNaUND" +
       "4ySgiGFTS/sdO5UECMsNsdJsdOhuDntL4LcaXl1dc/1JOMqmldHaEaRxouuq" +
       "Yo3QgS71VaOa4tUxhgcu7aNtv525lWpSNWB30etTSUfroCQsGv1WBjXwTa+z" +
       "TikvaxtEOqsJ3BDyYJie8It56glGv7ypOXF1bS0kK6AnIdyMRba15rCEHNkq" +
       "rsBdIt00LXCuBkOOG+X9hZ7U3QUZd9KwM+0KYqLzktLsjltzRsYUHeNHWZWX" +
       "EK65tv18hGMNd13jcNoXqAnTV1skNQvjDjaZ+SinzrDRpL0px1C/QVjuqtzR" +
       "s16z0tDbYa/ttMUBzMp+tEFq9mhZi4ZRW9oErKemw0VTWQL6gGs6WtLLvps7" +
       "+GjsTueU0hW9NQNF8Egjm5vOYGZuPDIhZh1TiOeq6MAsYLncl3vGfNLoOIrR" +
       "LmPMwG3Q07E1jbv+iG4My7NOrA2H5ZXRh1QcQXFwqW8oyyhZdRJsEi7FMJvx" +
       "doqZwjoere2qF9f1tViLh5xqdpeWNptWha7Qm2dKZK8qNMcH4NTP1xN0JTYX" +
       "7nqqzWAN5trgImeykIbMEQT5weKZ47cu9vzy8PY56TgyzvVaRcM/v8ALy+rO" +
       "32jv0/bRPqvjZ7ztX/GWp+7L6plnvG3P3ef3g6N3redveZHbfv4UFfw4PvKo" +
       "63NRESN1GGdB6vjmIYeAI/gGkqaxM83SIsSi+Oz69HkRdttPrq9/9pXXDPZn" +
       "qwf7UIhhWro/DaOPeebS9E7Buwxm+sj5n5fpbYDhySf6X/3sHzwp/ZD9yQsE" +
       "IT17BufZKX+OfuPX8Q/rf+2gdPn4g/0toY83D7p+82f6B2IzzeJAuulj/dPH" +
       "0nq8EM6HQHp1L61Xzz66nijLrS+uRfEXdsq2bTuJNLm0D+XaC+2jb+cDkRmz" +
       "WRpl6XbCPzgz4enQlf9ZZP8lLT2kx6aWmr0QGFFzH0ILFntvsVgO64dG6B/e" +
       "1LhV9//6Vg+Kp5fbVnzzmF3Fh6fSh0F6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("fc+u1y/Kru+/LbtOU/cnd2j70yL7o7T0bstMb36p/qUTAr/75yDwoaLyOZC+" +
       "uifwjf83+nD5xE790pGc3nNaTkVstbn7Nv6tYoZL99xZo6C3p1HYSjejYhNu" +
       "53ygyC6lpat57KQmsC5SuFO52z5GL0PHOObqpYOLcHWVlh4/JxqyCOd64pYw" +
       "7V1osf7zr1257/HX5H+7DQg8Dv+9nyrdN8s873T0zanyPVFszpwt2+/fxeJE" +
       "W2ofS0vvvwOXUmCQjn8UFFx6dDfufYBBZ8elpbu3/0/3ewrMcNIvLd2zK5zu" +
       "8mxaugy6FMXnoiPRHd5JdLcybHXplEneK+xWzx95K4kcDzkdVViY8W0w/ZHJ" +
       "zXbh9Df0r71GMp/6TvNnd1GNuqdtNsUs91Gle3cBlsdm+wPnznY01z3EC997" +
       "6Ov3f+joiHloB/hk85zC9uztwwYxP0q3gX6bf/z4L/zA33vtd7dBKv8X9Rq3" +
       "5+UwAAA=");
}
