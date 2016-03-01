package org.apache.batik.svggen;
public class ImageHandlerJPEGEncoder extends org.apache.batik.svggen.AbstractImageHandlerEncoder {
    public ImageHandlerJPEGEncoder(java.lang.String imageDir, java.lang.String urlRoot)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        super(
          imageDir,
          urlRoot);
    }
    public final java.lang.String getSuffix() { return ".jpg"; }
    public final java.lang.String getPrefix() { return "jpegImage";
    }
    public void encodeImage(java.awt.image.BufferedImage buf, java.io.File imageFile)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        try {
            java.io.OutputStream os =
              new java.io.FileOutputStream(
              imageFile);
            try {
                org.apache.batik.ext.awt.image.spi.ImageWriter writer =
                  org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.
                  getInstance(
                    ).
                  getWriterFor(
                    "image/jpeg");
                org.apache.batik.ext.awt.image.spi.ImageWriterParams params =
                  new org.apache.batik.ext.awt.image.spi.ImageWriterParams(
                  );
                params.
                  setJPEGQuality(
                    1,
                    false);
                writer.
                  writeImage(
                    buf,
                    os,
                    params);
            }
            finally {
                os.
                  close(
                    );
            }
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_WRITE +
              imageFile.
                getName(
                  ));
        }
    }
    public java.awt.image.BufferedImage buildBufferedImage(java.awt.Dimension size) {
        return new java.awt.image.BufferedImage(
          size.
            width,
          size.
            height,
          java.awt.image.BufferedImage.
            TYPE_INT_RGB);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVYa2xUxxWeXb+NjR8Em/AwYAwSr91QoGlkoAHjx9I13tqA" +
       "WtNmmb131nvh7r3DvbP2QuoSIiUgfqAomIQ+cP8QtY1ISB9RK1VBVJWaRGka" +
       "QaM2DzVp1R9NH0jhT2hF2/TMzL177971boryoyvt7N2ZM2fOOfPNd87cyzdR" +
       "jW2hbooNFUfYMUrsSII/J7BlE7VPx7a9D3qTypk/njtx+zcNJ8OodhzNz2B7" +
       "WME2GdCIrtrjaJlm2AwbCrH3EqLyGQmL2MSaxEwzjXG0ULNjWaprisaGTZVw" +
       "gQPYiqM2zJilpXKMxBwFDC2PC2uiwprozqBAbxw1KSY95k1YXDShzzfGZbPe" +
       "ejZDrfHDeBJHc0zTo3HNZr15C62npn5sQjdZhORZ5LC+1QnEnvjWkjB0v9Dy" +
       "0Z0nMq0iDAuwYZhMuGiPEtvUJ4kaRy1eb79OsvZR9HVUFUfzfMIM9cTdRaOw" +
       "aBQWdf31pMD6ZmLksn2mcIe5mmqpwg1iaGWxEootnHXUJITNoKGeOb6LyeDt" +
       "ioK37nYHXDy/Pjrz9EOtP6xCLeOoRTPGuDkKGMFgkXEIKMmmiGXvVFWijqM2" +
       "AzZ8jFga1rXjzm6329qEgVkOIOCGhXfmKLHEml6sYCfBNyunMNMquJcWoHL+" +
       "1aR1PAG+dni+Sg8HeD842KiBYVYaA/acKdVHNEMVOCqeUfCx5wsgAFPrsoRl" +
       "zMJS1QaGDtQuIaJjYyI6BuAzJkC0xgQIWgJrZZTyWFOsHMETJMnQoqBcQg6B" +
       "VIMIBJ/C0MKgmNAEu7Q4sEu+/bm5d9vZh40hI4xCYLNKFJ3bPw8mdQUmjZI0" +
       "sQicAzmxaV38Kdzx0ukwQiC8MCAsZX7ytVsPbui69oqUWTKHzEjqMFFYUrmU" +
       "mn99ad/aB6q4GfXUtDW++UWei1OWcEZ68xSYpqOgkQ9G3MFro7/88iPPkr+F" +
       "UWMM1SqmnssCjtoUM0s1nViDxCAWZkSNoQZiqH1iPIbq4DmuGUT2jqTTNmEx" +
       "VK2LrlpT/IcQpUEFD1EjPGtG2nSfKWYZ8ZynCKE6+KIm+G5A8iN+GaLRjJkl" +
       "UaxgQzPMaMIyuf98QwXnEBueVRilZjQF+D+ycVPk/qht5iwAZNS0JqIYUJEh" +
       "cjBqT05MECMaywIWhkADOLcn0T/YbyhAU1aEI4/+H9bM8zgsmAqFYIuWBglC" +
       "h7M1ZOogm1Rmcrv6bz2ffE2Cjx8YJ4IM8YUjcuGIWDgiF46UWRiFQmK9e7gB" +
       "Eg6wmUeAFoCXm9aOfXXPodPdVYBDOlUNO8FF15TkqT6PP1zSTyqXr4/efuP1" +
       "xmfDKAwUk4I85SWLnqJkIXOdZSpEBbYqlzZc6oyWTxRz2oGuXZg6eeDEfcIO" +
       "P/9zhTVAXXx6grN2YYme4LmfS2/LqQ8+uvLUtOkxQFFCcfNgyUxOLN3B3Q06" +
       "n1TWrcAvJl+a7gmjamArYGiG4UQB+XUF1ygimF6XrLkv9eBw2rSyWOdDLsM2" +
       "soxlTnk9AnZt4vke2OJ5/MR1w3eLcwTFLx/toLztlDDlmAl4IZLB9jF68a1f" +
       "/2WzCLebN1p8CX+MsF4fV3Fl7YKV2jwI7rMIAbnfX0icO3/z1EGBP5BYNdeC" +
       "PbztA46CLYQwP/bK0bfff+/Sm2EPswySdS4FdU++4CTvR40VnOQ49+wBrtPh" +
       "7HPU9Ow3AJVaWsMpnfBD8q+W1Zte/PvZVokDHXpcGG34ZAVe/7270COvPXS7" +
       "S6gJKTzXejHzxCSBL/A077QsfIzbkT95Y9k3XsYXIRUA/dracSIYNSxiEBae" +
       "L4LSS8zkaTUi0yrv3yq2dIuQiYp2M4+bc+KdmfeVY5axA4ODFqYZTbE/szs2" +
       "0p9XCOWmCqWf402P7T9TxcfWV2ollSfe/LD5wIdXb4kgFNdqfggNY9orUcub" +
       "1XlQ3xnkryFsZ0Buy7W9X2nVr90BjeOgUQFutkcsIL58EeAc6Zq6d37+i45D" +
       "16tQeAA16iZWB7A4u6gBDg2xM0DAefr5ByVmpuqhaeVPeVSIGhJRk3hdPjcA" +
       "+rOUiS07/tPOH2/77ux7AqsSnEuc6eLPGt6sK4BWfGqDydEP2iINFlpWrn4R" +
       "tdelR2dm1ZFnNskqo724JuiHkve53/77V5ELf3h1jjTTwEy6USeTRPetWQ1L" +
       "rixJDsOivPOI7f4bt6vefXJRU2le4Jq6yrD+uvKsH1zg5Uf/unjfjsyhuyD8" +
       "5YFABVV+f/jyq4NrlCfDokKVXF9S2RZP6vWHDBa1CJTiBneL9zQL+HYXtnYR" +
       "37KV8N3ubO32uUlXoEK0a3mzQR5u/riRAdtqBtYDJNdaQWngwLvQ5f+/VGFs" +
       "nDdfBBBMEDaWS6c10btVyPbyZlTasON/Oyi8o090D5fGo98xvf+u48Gb/XME" +
       "o5zGCg6TCmOCQJMyGHDdLg3GoU8dDJGRd8B32DF9uEIwiimjkOfKTQ14FsgW" +
       "SwWB4SkW0Xj5GNkFuw21hiqKSVeoSQhpZmQASnxhytG5Mwn/+4AQmOINnKF5" +
       "RFShUp2F1lZ4B2BpWagXJp1bVHS6/f0j3/7gOcldwStXQJicnjnzceTsjOQx" +
       "eS9dVXI19M+Rd1NhaquM5cfwCcH3P/zLY8g7+C9cVfucC9KKwg2J0rzgwgpm" +
       "iSUG/nxl+mffmz4VdsAUY6h60tRUDz3ZT42ee/nQeviqDgTUu0dPuamVK4b2" +
       "Anp2a1li2G5NcKbCcTrLm8dgbiqn6WoR3viI5UXm8buPTJ6hzjL3IJ6uF5W8" +
       "lJEvEpTnZ1vqO2f3/07U4oXLfhNUsemcrvtY3s/4tbTABk2yWKHi5zwYUaaU" +
       "gkJVPgj7Z6T8BSjagvLA9eLXL/cthho9OVAlH/wiswxVgQh//A51d2lzubpu" +
       "ZwquLlD++CPmRCsfKi1WxKYs/KRN8VUnq4pOu3hv5qbfnHxzllSuzO7Z+/Ct" +
       "zz4jbxOKjo8f51rmxVGdvNgUUvjKstpcXbVDa+/Mf6FhtXvY2qTBHvqX+HDY" +
       "BzimHBSLA6W23VOouN++tO3q66drbwCvHEQhzNCCg763VvIVDdTrOagvDsb9" +
       "dZHv7au4BfQ2/unQG/94J9QuCkEkr9ldlWYklXNX302kKf1mGDXEUA1wCcmP" +
       "o0bN3n3MGCXKJJSs9TlDO5ojMRWwmDJzRuEV23yOYMyLfxEZJ6DNhV5+G2Wo" +
       "u5QhS2/oUCNPEWsX187VNAeKnhyl/tE8f/U0h1ewN5su/vPE42+NwAkrMtyv" +
       "rc7OpQr1k/8NntQtyJo303nJy1XJ+DClDk/XzYpdpVQwwY+E0z+Q0lyCodA6" +
       "Sv8LiNUXs4kXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "p978G899JT+s/h949nBYgSMAAA==");
}
