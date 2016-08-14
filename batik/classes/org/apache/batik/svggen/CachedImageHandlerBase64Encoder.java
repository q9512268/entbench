package org.apache.batik.svggen;
public class CachedImageHandlerBase64Encoder extends org.apache.batik.svggen.DefaultCachedImageHandler {
    public CachedImageHandlerBase64Encoder() { super();
                                               setImageCacher(new org.apache.batik.svggen.ImageCacher.Embedded(
                                                                ));
    }
    public org.w3c.dom.Element createElement(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        org.w3c.dom.Element imageElement =
          generatorContext.
          getDOMFactory(
            ).
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_USE_TAG);
        return imageElement;
    }
    public java.lang.String getRefPrefix() { return ""; }
    protected java.awt.geom.AffineTransform handleTransform(org.w3c.dom.Element imageElement,
                                                            double x,
                                                            double y,
                                                            double srcWidth,
                                                            double srcHeight,
                                                            double dstWidth,
                                                            double dstHeight,
                                                            org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        java.awt.geom.AffineTransform af =
          new java.awt.geom.AffineTransform(
          );
        double hRatio =
          dstWidth /
          srcWidth;
        double vRatio =
          dstHeight /
          srcHeight;
        af.
          translate(
            x,
            y);
        if (hRatio !=
              1 ||
              vRatio !=
              1) {
            af.
              scale(
                hRatio,
                vRatio);
        }
        if (!af.
              isIdentity(
                )) {
            return af;
        }
        else {
            return null;
        }
    }
    public void encodeImage(java.awt.image.BufferedImage buf,
                            java.io.OutputStream os)
          throws java.io.IOException { org.apache.batik.util.Base64EncoderStream b64Encoder =
                                         new org.apache.batik.util.Base64EncoderStream(
                                         os);
                                       org.apache.batik.ext.awt.image.spi.ImageWriter writer =
                                         org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.
                                         getInstance(
                                           ).
                                         getWriterFor(
                                           "image/png");
                                       writer.
                                         writeImage(
                                           buf,
                                           b64Encoder);
                                       b64Encoder.
                                         close(
                                           );
    }
    public int getBufferedImageType() { return java.awt.image.BufferedImage.
                                                 TYPE_INT_ARGB;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+zrVn33/bX39t7bx71toe26vnthtIafkzjPlQ0cx07i" +
       "OI4TJ3biDS5+x47fj8QJK6+JwUBi3dYyJkGlSSA2VJ4aG9LEVDYxQKBJTGgv" +
       "aYCmSWNjSPSPsWlsY8fO730fVVW0SD45Oed7vuf7/Z7v+ZyvzzfP/QA6HYUQ" +
       "7Hv22rC9eFdL413LruzGa1+Ldim6wkphpKm4LUXRGLRdVh75zIUf/fip+cUd" +
       "6IwI3Sm5rhdLsem50UiLPHupqTR04bCVsDUniqGLtCUtJSSJTRuhzSh+goZu" +
       "PjI0hi7R+yIgQAQEiIDkIiDYIRUYdKvmJg6ejZDcOAqgt0GnaOiMr2TixdDD" +
       "x5n4Uig5e2zYXAPA4Wz2mwdK5YPTEHroQPetzlco/AyMPP07b774uRugCyJ0" +
       "wXS5TBwFCBGDSUToFkdzZC2MMFXVVBG63dU0ldNCU7LNTS63CN0RmYYrxUmo" +
       "HRgpa0x8LcznPLTcLUqmW5gosRceqKebmq3u/zqt25IBdL3rUNethmTWDhQ8" +
       "bwLBQl1StP0hNy5MV42hB0+OONDxUg8QgKE3OVo89w6mutGVQAN0x3btbMk1" +
       "EC4OTdcApKe9BMwSQ/dek2lma19SFpKhXY6he07SsdsuQHUuN0Q2JIZeeZIs" +
       "5wRW6d4Tq3RkfX7AvP4Db3U77k4us6opdib/WTDogRODRpquhZqraNuBtzxO" +
       "f1C664vv3YEgQPzKE8Rbmj/+lRfe+NoHnv/qluZnr0IzkC1NiS8rH5Vv++Z9" +
       "+GONGzIxzvpeZGaLf0zz3P3ZvZ4nUh/svLsOOGadu/udz4/+YvaOT2jf34HO" +
       "d6EzimcnDvCj2xXP8U1bC9uaq4VSrKld6Jzmqnje34VuAnXadLVt60DXIy3u" +
       "QjfaedMZL/8NTKQDFpmJbgJ109W9/bovxfO8nvoQBN0EHugW8LwG2n7y7xiy" +
       "kLnnaIikSK7peggbepn+EaK5sQxsO0dk4PULJPKSELgg4oUGIgE/mGv7HUvD" +
       "0FwEz5rUrgN8oCO5KlCqKUVatUy4iqdq4W7mc/7/62xppvvF1alTYFnuOwkK" +
       "NthPHc8GtJeVp5Mm8cKnLn9952CT7FkthmpAgN2tALu5ALtbAXZfRADo1Kl8" +
       "3ldkgmxdASzkAkACAMtbHuPeRL3lvY/cAHzQX90IViEjRa6N2fghiHRzqFSA" +
       "J0PPf2j1Tv7thR1o5zj4ZsKDpvPZcDaDzANovHRy012N74X3fO9Hn/7gk97h" +
       "9juG5nuocOXIbFc/ctLMoadoKsDJQ/aPPyR9/vIXn7y0A90IoALAYywBdwbI" +
       "88DJOY7t7if2kTLT5TRQWPdCR7Kzrn14Ox/PQ2912JKv/215/XZg45szd38c" +
       "PK/d8//8O+u908/KV2z9JVu0E1rkSPwLnP+Rv/3Lf0Fzc++D9oUjxyCnxU8c" +
       "AYqM2YUcEm4/9IFxqGmA7h8+xP72Mz94zy/lDgAoHr3ahJeyEgcAAZYQmPnd" +
       "Xw3+7jvf/ui3dg6dJgYnZSLbppIeKJm1Q+evoySY7dWH8gCgscH2y7zm0sR1" +
       "PNXUTUm2tcxL//vCq4qf/7cPXNz6gQ1a9t3otS/O4LD9Z5rQO77+5v94IGdz" +
       "SskOukObHZJt0fPOQ85YGErrTI70nX91/+9+RfoIwGGAfZG50XI4g3IbQPmi" +
       "Ibn+j+fl7om+YlY8GB11/uP760hAcll56ls/vJX/4Z++kEt7PKI5utZ9yX9i" +
       "615Z8VAK2N99cqd3pGgO6MrPM7980X7+x4CjCDgqANWiQQggIj3mGXvUp2/6" +
       "+y/9+V1v+eYN0A4Jnbc9SSWlfJNB54B3a9EcQFbqv+GN28VdnQXFxVxV6Arl" +
       "t05xT/7rBiDgY9fGFzILSA636D3/NbDld/3jf15hhBxZrnIOnxgvIs99+F78" +
       "F7+fjz/c4tnoB9IrsRgEb4djS59w/n3nkTNf3oFuEqGLyl5kyEt2km0cEURD" +
       "0X64CKLHY/3HI5vtMf7EAYTddxJejkx7ElwOzwBQz6iz+vmjePIT8DkFnv/N" +
       "nszcWcP2PL0D3zvUHzo41X0/PQV26+nSbm23kI1/Q87l4by8lBU/t12mrPoa" +
       "sK2jPCQFI3TTlex84jfGwMVs5dI+dx6EqGBNLll2LWfzShCU5+6Uab+7jeu2" +
       "gJaVpZzF1iUq13Sfn99S5SfXbYfMaA+EiO//p6e+8RuPfgesKQWdXmb2Bkt5" +
       "ZEYmyaLmX3vumftvfvq7789RCkAU/+ufrX0340pfT+OsILKC3Ff13kxVLg8C" +
       "aCmK+zmwaGqu7XVdmQ1NB+Dvci8kRJ684zuLD3/vk9tw76TfniDW3vv0+36y" +
       "+4Gnd44E2Y9eEeceHbMNtHOhb92zcAg9fL1Z8hHkP3/6yT/5/Sffs5XqjuMh" +
       "IwHeiD751//zjd0PffdrV4lIbrS9l7Gw8W23dMpRF9v/0MWZLqwmaSroAxQx" +
       "xsiG5Fe4TBcGtCEvh1jbXjjRcNYubAalfg8TYmZlsbpTm8vLGletRYgs4kKB" +
       "a2qk0Au6E2LpjRCza8sTphsUxLg071U8x+MoqTQhKWHBT0ybN8PGECsFNltp" +
       "lhCuUVJReTlG9a4UcgtUTFRYZhxE15as02jAcqVaHeMMYcgT1CHGsNW3WM7T" +
       "KUyiFnGh1xgW1AKjTztB1WIrDaQmqI0yT1XGuOhKorMsjJiiGW0ogRgsiqLI" +
       "jG2eEuRExNfN/mrGiBZlWR1KnJR1asq40Ro2e3TfqU8L0Ypi5rQ1mvuev5Lr" +
       "nkUKItIyKFZoEwZHihSRlOmWOyY5quRW54QGrwhdq43i5tpbo3ZkUzN4ZXQk" +
       "ZmTW4x6DS/KyxYSLllD1F+sF2S12BErstExP7ozYyGwXon6/sybTCF52FnWU" +
       "m/cLBMXzGoOz0/60v+FtC+dNv98Jazw5S62UYBd6bxaMhVE9pbR6qjJYQI8c" +
       "csQXExYPuKVYDfiqKhGDeGPzPZvuNTF3jfTEKsMZ7ZnOeBQmDshROkKVtC2P" +
       "VCdmhWJIYSnPhJ6p6WiMlJdjmusTK0nsTLqpSGI4VqVbXaYpCBLRFsRpNyK4" +
       "VXVEzZWCNvPEPjl1uZJmO5NC1bfJZIVIFTFiWM7hOkKjvSLhlVltizLBcAN3" +
       "anfLNsvwC37k4S6nVmA7kBomjUhNwxqu8fZk0dMTtd8bwXxxOHS5cnejWEGJ" +
       "XQ2JfocX5st2wbaTYNqbDoeiH5PFNnA1b2Boid/j8LjQx5qtSVkgHaEXx5LP" +
       "EP6Y7pa1toTJcVfDAtubYYG66ltqF3hBkzYL/RpFLfVqbYl2NhExFWptczZf" +
       "tNwmhU3tEPiVPCOppGhy7eFmYIxLaWiyJZIqogrn9/Fmi22NWjLTapQbfakl" +
       "NRJnWmN8Mipi/U1zvSAWddovqI6OCuWkxjcqwrxNClUxCsrw1JHMYr9U7aYF" +
       "0eUxp7OoWJYxU4bgvQ9B6/1yo+EgBXvcDqtcT1j0+Fkb6c2pgtWrhq2m1S4O" +
       "xOHYphsUGfimVE2nhu4Mp8s+b9tq0sD6zmKNAn8hVZIPZvayTxKc0MMpKWmq" +
       "vD+Q4Gpl7II9LYiFYd+ItImhs2nZbRAIrHS6aycerumJ5wRR4JPNVYFpjDXL" +
       "aBnWjIkLKsbVdWsUSP6sSc8t3iK5iTGHF844WtkLL2XUgJnOHLjFWpgaeM6w" +
       "t4gNqiQzS84jDHxCTNp6AYGXQYkfNSpyOsHMkjglhmRzWB43omJTsKzCwg65" +
       "OsyQMLUsYdXOvM6lbVNHDQMbCWW8S+BNE0/xynyILcgmHW5AKZMaZo1WJIc1" +
       "+6EdNRosPsCKLL2uY52GTq5L2GQxFctTp+Y10E6ryZoVVepVAZaIRUSarHoz" +
       "eCSafmquvZkUBn2yi8+YQaDUa96I6E/oziJurIYDyw1IisY6M55bdwfkOohb" +
       "pDNr1V0FXSkog7fnm7nE0q1+rwWLrIXCMFNj0bTglPW0bExiAWPG8wZBEvBo" +
       "LcUrNZ2ZEtyaaEt9as0DZSDN03kFU0zGWU02k5luD5V61zGVROXWNl2fLDtO" +
       "eSoG9fZooEzGJo6JfLyyxilWdcfNzlTwMU8YO357jhvVChPU5tKkLzfQgFhv" +
       "JKqxcQ0y5MtDa2kIWqQIepv1EKYgD3SZ9iowGTfxZrfBtjSXXbIszTYK1maA" +
       "tp2hqBtWi9B6CluqNMWogKdU1IjVNOljarHmrzREScJqYYriYpk008mKjh1W" +
       "bolGW1jNHXZJS95U15doWFJia6Osak10FDQ7uCNPUrrGTQoUJbSLvFiuG91C" +
       "r4uJ1bEeaaSejseRXxi1yXLE1sSoQzc4tN4oOlbNGHYb4TyJl+NJK0TghNa4" +
       "lEFkxCuUVvhkMXM2JVkThqUyrZZdOuobharRYdwOWqo1qsGy0B4aKsZoDttf" +
       "ENicmWPrbkmW2CFSqo1kw+yjsyXDxewSYV13XVFbqTS17A3sociy2dtoRMza" +
       "lNOBl3DV1SQ5mjJBsl51KjBBrUuTTZ9Rm4mjotXSRHRgfLTuGFKfGLZXg3a3" +
       "GZTGG1bpGaG4RB2/ojudqRla3VGNm5XMwmS4JGdan+8yaB/w6VFLvoNaQzTe" +
       "pD3HkOZSsBiyDt6yxquF76ChqVlKqROtR8gAQWqOUtIS3ETG8qhKI9gKmUcl" +
       "yaVhalqarFrLsEHP4NaQD2if88zNOKyl/cXGnJFusRFRoykDwwO4WWPleogg" +
       "RTEZF2rFqt6V/YlSKOp+DUv9pSWkrcBmuLrQ6EbRJhpYjZKkwyxK16RFHKf9" +
       "dtRDYnKBs2ghxsxZzYya5UlFnbhImK4aCOpjNa1ZJSK8YqzXCCkj9WpjKawF" +
       "Fe8mk+JQ3hj2ENWLPRet4augTxhMUR2NtbVPlqpIN1EwWjZTDu6IlZaF+b49" +
       "UoeyvhZIPpKc5iQtrj0rhmm4uRjLZDRzrCVjKmQRW7tEk8RreLVJ+Ehb9PCx" +
       "FtnGouWbPUVS2kYgSFHbThN41DUWMYG0WX3Uk4d6vFDZ6tRPu7XEHY+QYmvA" +
       "RIVy0RBZuzSQwzhCpVrbp5QNxnlrO2q5GMeXesrQYia9sluR0tCbSM1e0SBH" +
       "2ipYt/rsEizgUEmGqt6KlM5YmSjdupegmOgXZKYaF4dwH9PN1Qin0CI1Ndoy" +
       "2bcdcjqvoE049dxVX+AYh8LU9dzuNiNJWSTe2Fhpi0CXm2zD8tRY6ROldTVR" +
       "GuSyNkbXEYE2h5VJV28txn6dVTHc0Dv2wKuinRGC0SudWepkE671m0hAcjVX" +
       "9z1JqmBDb4iuBx7HpGEFB17H1OoI7BXDSqlAGga/MKg54+obc1QhLapU8uJg" +
       "GZFDgQxdeDAVXLnqYBtT7ca9mtBzmE4tXSUdHdkoZYmZp8U2OuSrkwKOpTNj" +
       "OsRkW13GfDyRVdjTCDetLGnNJNoNigi4yoQVpNVyAXw3KqRhSivM1EYTT+pa" +
       "DBUoiyLWEZpKjfK8olYfr4TuwmLKAtMM7I5gj0BkUgoc30KTQEt4cVUdRGWr" +
       "N5S7RYrvD81AHa+Fgdcpd6yg2fVTGBuh0sBENzU8c6kIW8w4slti+KoyqYRt" +
       "btleN2ehORPw6RiujjpS3GsnI2y2DElDHc6soTVq+fwgWBeSJltrusGaiPsp" +
       "1o0r07ruDHCtCMJIG3UCdhBWe3q5kU6sqrMeumzDhmGsJi5XNMHXm+YAm6Fy" +
       "jJbSgJsq9XFkp1HFqgN8GxS4zhJDqaLAWqzVJ8fkzBkgnUmcImWNG4clvaMg" +
       "9d5AUOaw7HZEg3TXhkfJYyRxxm44HxMsj7SYWujNF/2pJvMGeLOWh5N0Bo6E" +
       "hPOKhOCR1KhUELDWqlwvO3x9MV8RRFSEia6JyI2mMt9gMogkFkMErValSSVg" +
       "W74hykiZ46rNzYwgpijsJJUqsrTneCxOQLA3XQ0jxh6WJ6QRm1Ei6xJNNsgI" +
       "7y6R7jyURppB67E5AOfygGasyrqPMlYxJBswNzQVdzGJ4hVNNVoVELpRCl/R" +
       "ZHD4rmE4kSOyGk+TpG2uR/JssGnTervMJDzTHVXUWbs37290UTH0MCkppSXS" +
       "7gV1p9BV2bhrYj2ixjIqDvawR7Y0wcapWjfi5/O611mMKZR2q1LKomEBhWuy" +
       "ZjZcGi9qtNnodPx66HR0lDdX/MILBfB6hPHE0J+plCWskymPo4qw6AuDWbEf" +
       "O+NUJJp4ec3rlFkqbQpTL/CdEKdn9Vp1ijc0dIqvl62mQRYr5aFYqLYCtRs1" +
       "OIJIiyEI7OswEGTEjGbJvDors9PywgfLJVoYOsQ7lqJXVRVlxFIAB+Voowsj" +
       "B+23SqZrkRUfRTCmvUDcwbptYFj2Wviml/Zmfnt+CXGQaQIv5FlH5yW8kW67" +
       "Hs6KVx1cXOafMyezE0cvLg9vs6DsLfv+ayWQ8jfsj77r6WfVwceKO3u3gNMY" +
       "Ohd7/utsbanZR1hlydLHr32b0M/zZ4e3U19517/eO/7F+Vtewp37gyfkPMny" +
       "D/rPfa39auW3dqAbDu6qrsjsHR/0xPEbqvOhFiehOz52T3X/gWXvzCz2EHiq" +
       "e5atXv3e+6pecCr3gu3an7hkPbWXudi7fIKvlSnh+PbeRZgX7iVZc37RdS5t" +
       "V1nhxtCtSqhJsZYlnbW9/DCY6s5sqhWq7Kqes3u0L3c978UuQ45OljcsDmx1" +
       "R9b4AHiwPVthPx1bHdXtV6/T9+6seFsM3WJo8UjT2VDTzbyjc6jf21+Gfplq" +
       "0OvAQ+3pR70U/cAe8kMv1pRYU6+q5tmc7mz2c503ckewQIihM6qXyNtc5W9e" +
       "q9g6x1PXMdIzWfG+GLowzxNv41ByoywbtO8e9+eXktIq3jU04CCYrpvuCarc" +
       "kO9/GYbMk0lvAI+5Z0jzp+MoOznBzr4q9x2oYmaZxt1momc5sW3ecZ9om2M0" +
       "vd1BEvtJzMVgzzg599+7/pa9c39gd0CkiuZnSJaP+3hWfDiGbtbybObhbCfW" +
       "88alZ6qHBv3IyzDohazxUfCEewYNf/o774+u0/eFrPgsMCbYecesfJBPPKH7" +
       "DeZR0PncS1E9BQj/IvnjLBl2zxV/ZNn++UL51LMXzt797ORv8hTqwR8kztHQ" +
       "WT2x7aO5iyP1M/4BmJzbZjL8/OvPYujua0B3lojIK7kGX9rSfzmGLp6kj6HT" +
       "+fdRuq/G0PlDOsBqWzlK8nVgRUCSVb/h7ztl8VrnSEvTpcSOrzRceup4bHCw" +
       "KHe82KIcCScePRYE5P802j+wk+1/jS4rn36WYt76QvVj2xSwYkubTcblLA3d" +
       "tM1GHxz6D1+T2z6vM53HfnzbZ869aj9AuW0r8KGTH5HtwavnWwnHj/MM6eYL" +
       "d//h6z/+7LfzpMv/AcRUKuQCJgAA");
}
