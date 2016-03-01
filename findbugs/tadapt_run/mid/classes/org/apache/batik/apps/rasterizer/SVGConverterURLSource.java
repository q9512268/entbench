package org.apache.batik.apps.rasterizer;
public class SVGConverterURLSource implements org.apache.batik.apps.rasterizer.SVGConverterSource {
    protected static final java.lang.String SVG_EXTENSION = ".svg";
    protected static final java.lang.String SVGZ_EXTENSION = ".svgz";
    public static final java.lang.String ERROR_INVALID_URL = "SVGConverterURLSource.error.invalid.url";
    org.apache.batik.util.ParsedURL purl;
    java.lang.String name;
    public SVGConverterURLSource(java.lang.String url) throws org.apache.batik.apps.rasterizer.SVGConverterException {
        super(
          );
        this.
          purl =
          new org.apache.batik.util.ParsedURL(
            url);
        java.lang.String path =
          this.
            purl.
          getPath(
            );
        int n =
          path.
          lastIndexOf(
            '/');
        java.lang.String file =
          path;
        if (n !=
              -1) {
            file =
              path.
                substring(
                  n +
                    1);
        }
        if (file.
              length(
                ) ==
              0) {
            int idx =
              path.
              lastIndexOf(
                '/',
                n -
                  1);
            file =
              path.
                substring(
                  idx +
                    1,
                  n);
        }
        if (file.
              length(
                ) ==
              0) {
            throw new org.apache.batik.apps.rasterizer.SVGConverterException(
              ERROR_INVALID_URL,
              new java.lang.Object[] { url });
        }
        n =
          file.
            indexOf(
              '?');
        java.lang.String args =
          "";
        if (n !=
              -1) {
            args =
              file.
                substring(
                  n +
                    1);
            file =
              file.
                substring(
                  0,
                  n);
        }
        name =
          file;
        java.lang.String ref =
          this.
            purl.
          getRef(
            );
        if (ref !=
              null &&
              ref.
              length(
                ) !=
              0) {
            name +=
              "_" +
              ref.
                hashCode(
                  );
        }
        if (args !=
              null &&
              args.
              length(
                ) !=
              0) {
            name +=
              "_" +
              args.
                hashCode(
                  );
        }
    }
    public java.lang.String toString() { return purl.toString(); }
    public java.lang.String getURI() { return toString(); }
    public boolean equals(java.lang.Object o) { if (o == null || !(o instanceof org.apache.batik.apps.rasterizer.SVGConverterURLSource)) {
                                                    return false;
                                                }
                                                return purl.
                                                  equals(
                                                    ((org.apache.batik.apps.rasterizer.SVGConverterURLSource)
                                                       o).
                                                      purl);
    }
    public int hashCode() { return purl.hashCode(
                                          ); }
    public java.io.InputStream openStream() throws java.io.IOException {
        return purl.
          openStream(
            );
    }
    public boolean isSameAs(java.lang.String srcStr) {
        return toString(
                 ).
          equals(
            srcStr);
    }
    public boolean isReadable() { return true; }
    public java.lang.String getName() { return name;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hxbjy8P/Ax5c/p/oIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "st9u00KVjZGONa8iSTdF2HzeNit9bbZuzy0yd4cuwuJ6Um2OqHW1L1jGcoUJ" +
       "2ESa29ssSus0uZVXgdJv7uJusOgimrbMuPbUqs0UbtKdWXY9cYHke9NJB2GH" +
       "AxJzcYWkzbwXd1mi3930aJ7QR9QoU2iSzCaEV9F8jtebeVtezuGaEy/wntue" +
       "zfpuiPXbM5iqGAzVNuGVPhhyUlxxWpNOBUU7UsfQFborkIPeqknYlF6XFYLo" +
       "mcGaH64SD2s7ZOzKpCkL2KCP1Zs7HOi+73bXG36FtUiuhXs5WvPInhT1hvw2" +
       "R5aqkTajwWKsmQ28UvP7MJutkI2D9Ng1FrVD0a5Qa62urRbjFt/wvEq/08VZ" +
       "Sk97vkkuYUtt1JShgqZdf+wsu7PttpH0e+NhHgl8VzArGu7kjcFqkq/lJEEr" +
       "IlgK4siBsc6AxkMi6jbouY4liz61be+0dYNpmEGrraw5NKpwOYkD0JpZIz7P" +
       "kyEqcZnu016zibQxCpMojGjN19GClDNuLkXVYE4qw267TgtoE5lEjUk/gquj" +
       "HqFKE1tswpi06zQY2a23pHTQRGx/pnuD1bjjNCx82IqnbUdVRSKu95RkXmd2" +
       "aaNjrr3VSmf08aYuk5tulBNuozWcRTm27jdnKykf5zUvFFKiW2Wri2bgG94q" +
       "tjhbmK5MeTQK5ArGymncqHFEpSMtdXzBD5odVG2HC7VaUfrCyttNe20mZie7" +
       "GerHth7tIrI6RsZY7JPSdtdLtv64s6yni7mLYOMtiluYj8VqLcTE0MGt3XQg" +
       "1Oadzigl/SRDGjMBX7R1S/S7fJZ4dTrfYMvVJEKUrkkyjt0RR37mxEaLEqWd" +
       "w8UZ8Ad/PJ2ilWq3wdpzHF3I09xwZpUITgesgHA7LqkoVNvKNjSu4wOV6CSd" +
       "bjaJ0gZMtrzKGA78aXPbpPOka+oOvFgvzVoTweGUyGyRGoyGKS5iTKZ31GQd" +
       "7SwhxZce4/jdFi8hiK4TiIZy6zRf78JGV0a1icFbKuUYvFvtNEcxlyWVPknR" +
       "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" +
       "NW4YlhtNx5cF/gVbTPuqZ4vsHcfbcOXvMnTugPnUNtyp84Hjk5bGazpp2W8j" +
       "FTszT97t/kC5K/OpD774kjr98drFw729fxtDV2PPf7etpZp97pjiXXffgRqX" +
       "1ydOzgp+64N//cT8Pcb7X8PJ6tPn6Dw/5E+NX/7s4JuVH74I3Xd8cnDbxY6z" +
       "nZ4/e15wLdTiJHTnZ04NnjzWyiOFEp4A6X2HWnnf+c3RE73fZkEXSgva2825" +
       "EzPo1Nbpj96j7seK7D/F0JXY25+/lbZ2YmaffLUNr9MDlgWfOMtbsf8uHfIm" +
       "vfG8vXyPuk8X2U/E0GVdi3mWOsfZT74Ozordd+gbQdIOOdPeGM7ufji6P74q" +
       "O/3SPVj+lSL7ecCyFiSSHZVtPnAKLj4YQw/InmdrknsiiV94HZK4XhQ+BpJz" +
       "KAnnjdfxZ+9R97ki+6/Afg0pMnBP1e7E8n3m4e21kt3ffB3sFpxCz4IUHrIb" +
       "vvHs/tG9jWJ/1m56B9T07Mn2HxfZH8TQNc/XXODM2iHOnenj+kl8qq4UyOdf" +
       "rycUB4LpoUDSN9QTSp8tG3zxHhL76yL7C2AEZsQB5MXKRr92wuBfvl4GnwRp" +
       "d8jg7o3X+P+5R91Xi+x/x8VBN6tJanFJ4xx3X369EF0A2QcOufvAG87dBege" +
       "dReLwq8BUAIQPTk63Tth7e9fC2tZDL31jse4xQ2Vx2+7drq/Kql8+qXrVx57" +
       "if/v5b2m4+uMV2noyjqx7dMH/6eeL/uhtjZLzq/urwH4JTtXY+iZV4uYgCpP" +
       "XgomLlzZd34Q0H/HzjF0qfg73fY6WBzOt42h+8v/0+0eKeDguB1YF/YPp5sA" +
       "eLgPNCkeHy11/l+yC6disEOTKdXxyKup47jL6btRRdxW3g0+irGS/e3gW8pn" +
       "XhpOvucrrR/f381SbGlX3he4QkMP7K+JHcdpz951tKOxLpPv/NpDP3v1HUcx" +
       "5UN7gk/M9xRtT9/5IlTf8ePy6tLulx77hW//iZf+tDxb/WexfPadtC0AAA==");
}
