package org.apache.batik.ext.awt.image.rendered;
public class FilterAsAlphaRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    public FilterAsAlphaRed(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        super(
          new org.apache.batik.ext.awt.image.rendered.Any2LumRed(
            src),
          src.
            getBounds(
              ),
          new java.awt.image.ComponentColorModel(
            java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_GRAY),
            new int[] { 8 },
            false,
            false,
            java.awt.Transparency.
              OPAQUE,
            java.awt.image.DataBuffer.
              TYPE_BYTE),
          new java.awt.image.PixelInterleavedSampleModel(
            java.awt.image.DataBuffer.
              TYPE_BYTE,
            src.
              getSampleModel(
                ).
              getWidth(
                ),
            src.
              getSampleModel(
                ).
              getHeight(
                ),
            1,
            src.
              getSampleModel(
                ).
              getWidth(
                ),
            new int[] { 0 }),
          src.
            getTileGridXOffset(
              ),
          src.
            getTileGridYOffset(
              ),
          null);
        props.
          put(
            org.apache.batik.ext.awt.ColorSpaceHintKey.
              PROPERTY_COLORSPACE,
            org.apache.batik.ext.awt.ColorSpaceHintKey.
              VALUE_COLORSPACE_ALPHA);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed srcRed =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        java.awt.image.SampleModel sm =
          srcRed.
          getSampleModel(
            );
        if (sm.
              getNumBands(
                ) ==
              1)
            return srcRed.
              copyData(
                wr);
        java.awt.image.Raster srcRas =
          srcRed.
          getData(
            wr.
              getBounds(
                ));
        java.awt.image.PixelInterleavedSampleModel srcSM;
        srcSM =
          (java.awt.image.PixelInterleavedSampleModel)
            srcRas.
            getSampleModel(
              );
        java.awt.image.DataBufferByte srcDB =
          (java.awt.image.DataBufferByte)
            srcRas.
            getDataBuffer(
              );
        byte[] src =
          srcDB.
          getData(
            );
        java.awt.image.PixelInterleavedSampleModel dstSM;
        dstSM =
          (java.awt.image.PixelInterleavedSampleModel)
            wr.
            getSampleModel(
              );
        java.awt.image.DataBufferByte dstDB =
          (java.awt.image.DataBufferByte)
            wr.
            getDataBuffer(
              );
        byte[] dst =
          dstDB.
          getData(
            );
        int srcX0 =
          srcRas.
          getMinX(
            ) -
          srcRas.
          getSampleModelTranslateX(
            );
        int srcY0 =
          srcRas.
          getMinY(
            ) -
          srcRas.
          getSampleModelTranslateY(
            );
        int dstX0 =
          wr.
          getMinX(
            ) -
          wr.
          getSampleModelTranslateX(
            );
        int dstX1 =
          dstX0 +
          wr.
          getWidth(
            ) -
          1;
        int dstY0 =
          wr.
          getMinY(
            ) -
          wr.
          getSampleModelTranslateY(
            );
        int srcStep =
          srcSM.
          getPixelStride(
            );
        int[] offsets =
          srcSM.
          getBandOffsets(
            );
        int srcLOff =
          offsets[0];
        int srcAOff =
          offsets[1];
        if (srcRed.
              getColorModel(
                ).
              isAlphaPremultiplied(
                )) {
            for (int y =
                   0;
                 y <
                   srcRas.
                   getHeight(
                     );
                 y++) {
                int srcI =
                  srcDB.
                  getOffset(
                    ) +
                  srcSM.
                  getOffset(
                    srcX0,
                    srcY0);
                int dstI =
                  dstDB.
                  getOffset(
                    ) +
                  dstSM.
                  getOffset(
                    dstX0,
                    dstY0);
                int dstE =
                  dstDB.
                  getOffset(
                    ) +
                  dstSM.
                  getOffset(
                    dstX1 +
                      1,
                    dstY0);
                srcI +=
                  srcLOff;
                while (dstI <
                         dstE) {
                    dst[dstI++] =
                      src[srcI];
                    srcI +=
                      srcStep;
                }
                srcY0++;
                dstY0++;
            }
        }
        else {
            srcAOff =
              srcAOff -
                srcLOff;
            for (int y =
                   0;
                 y <
                   srcRas.
                   getHeight(
                     );
                 y++) {
                int srcI =
                  srcDB.
                  getOffset(
                    ) +
                  srcSM.
                  getOffset(
                    srcX0,
                    srcY0);
                int dstI =
                  dstDB.
                  getOffset(
                    ) +
                  dstSM.
                  getOffset(
                    dstX0,
                    dstY0);
                int dstE =
                  dstDB.
                  getOffset(
                    ) +
                  dstSM.
                  getOffset(
                    dstX1 +
                      1,
                    dstY0);
                srcI +=
                  srcLOff;
                while (dstI <
                         dstE) {
                    int sl =
                      src[srcI] &
                      255;
                    int sa =
                      src[srcI +
                            srcAOff] &
                      255;
                    dst[dstI++] =
                      (byte)
                        (sl *
                           sa +
                           128 >>
                           8);
                    srcI +=
                      srcStep;
                }
                srcY0++;
                dstY0++;
            }
        }
        return wr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ya2wU1xW+u34bvwFDDTZgDCmP7oASqlKTNGaxg8nauDYh" +
       "6tKw3J256x08OzPM3LHXTtMmkSqIWiFESUIrxb8cRanSJKqaPqQmchWpSZS2" +
       "UlLUNq1CK/VP+kANqpT+oK9z7szszM6uIfRHV5q7s/eee+55fufcfeEaqbMt" +
       "0sd0nuDzJrMTwzqfoJbNlKRGbfsYzGXkp2vo309+ML4/TurTpC1P7TGZ2mxE" +
       "ZZpip0mvqtuc6jKzxxlTcMeExWxmzVKuGnqarFXt0YKpqbLKxwyFIcFxaqVI" +
       "J+XcUrMOZ6MeA056UyCJJCSRhqLLgynSIhvmfEC+PkSeDK0gZSE4y+akI3Wa" +
       "zlLJ4aompVSbDxYtsss0tPlpzeAJVuSJ09o+zwRHUvsqTND/cvtHNy7kO4QJ" +
       "VlNdN7hQz55ktqHNMiVF2oPZYY0V7DPky6QmRVaFiDkZSPmHSnCoBIf62gZU" +
       "IH0r051C0hDqcJ9TvSmjQJxsKWdiUosWPDYTQmbg0Mg93cVm0HZzSVtXywoV" +
       "n9wlXXr6ZMd3a0h7mrSr+hSKI4MQHA5Jg0FZIcsse0hRmJImnTo4e4pZKtXU" +
       "Bc/TXbY6rVPugPt9s+CkYzJLnBnYCvwIulmOzA2rpF5OBJT3qy6n0WnQtTvQ" +
       "1dVwBOdBwWYVBLNyFOLO21I7o+oKJ5uiO0o6DtwPBLC1ocB43igdVatTmCBd" +
       "bohoVJ+WpiD09GkgrTMgAC1OelZkirY2qTxDp1kGIzJCN+EuAVWTMARu4WRt" +
       "lExwAi/1RLwU8s+18QPnH9YP63ESA5kVJmso/yrY1BfZNMlyzGKQB+7Glp2p" +
       "p2j3q+fihADx2gixS/ODL12/d3ff8psuzYYqNEezp5nMM/JStu2djckd+2tQ" +
       "jEbTsFV0fpnmIssmvJXBogkI013iiIsJf3F58qdfePTb7C9x0jxK6mVDcwoQ" +
       "R52yUTBVjVn3MZ1ZlDNllDQxXUmK9VHSAO8pVWfu7NFczmZ8lNRqYqreEL/B" +
       "RDlggSZqhndVzxn+u0l5XrwXTUJIAzykBZ5PEvcjvjmZkfJGgUlUprqqG9KE" +
       "ZaD+tgSIkwXb5qUsRP2MZBuOBSEoGda0RCEO8sxbwMykc1xSC+B+CdyhgE8U" +
       "aUTVIKCG7CHNzNNJpiQw6Mz/73FF1H71XCwGjtkYhQUNMuqwocH2jHzJOTh8" +
       "/cXM227IYZp4duPkMyBBwpUgISQQIAoSJIQECV+CRFQCEouJg9egJG40gC9n" +
       "ABUAllt2TD105NS5/hoIQ3OuFhyBpP1l5SkZQIeP9xn5pa7WhS1X974eJ7Up" +
       "0kVl7lANq82QNQ04Js94qd6ShcIV1I/NofqBhc8yZKYAfK1URzwujcYss3Ce" +
       "kzUhDn51wzyWVq4tVeUny5fnHjv+lT1xEi8vGXhkHaAdbp9AoC8B+kAUKqrx" +
       "bT/7wUcvPfWIEYBGWQ3yS2fFTtShPxoaUfNk5J2b6SuZVx8ZEGZvAlDnFJIQ" +
       "8LIvekYZJg36+I66NILCOcMqUA2XfBs387xlzAUzImY7xfsaCItVmKQb4Nnj" +
       "Za34xtVuE8d1boxjnEW0EPXj7inzmd/84k93CnP7paY91CNMMT4Ygjdk1iWA" +
       "rDMI22MWY0D3/uWJbzx57ewJEbNAsbXagQM4JgHWwIVg5q++eea9319duhIP" +
       "4pxDfXey0CYVS0riPGm+iZJw2vZAHoBHDTADo2bgAR3iU82pNKsxTKx/tm/b" +
       "+8pfz3e4caDBjB9Gu2/NIJj/xEHy6Nsn/9En2MRkLM+BzQIyF/NXB5yHLIvO" +
       "oxzFx97t/eYb9BmoHoDYtrrABAjHvFxHodZzcufHBZckkKCEgCvC4fsEhz1i" +
       "vAuNJfgSsbYfh212OHHKczPUgmXkC1c+bD3+4WvXhablPVw4TsaoOeiGJg7b" +
       "i8B+XRTYDlM7D3R3LY9/sUNbvgEc08BRBhi3j1qgR7Esqjzquobf/uT17lPv" +
       "1JD4CGnWDKqMUJGgpAkyg9l5gOii+bl73cCYa4ShQ6hKKpSvmEDnbKru9uGC" +
       "yYWjFn647nsHnlu8KiLUdHlsCDO8A4ddpVgVn/poGQ3HahkHi/Su1OmILm3p" +
       "8UuLytFn97r9SFd59zAMzfF3fvWvnyUu/+GtKqWpiRvmpzQ2y7TQmVhHesvq" +
       "yJhoAgMse7/t4h9/NDB98HZKCM713aJI4O9NoMTOlUtCVJQ3Hv9zz7F78qdu" +
       "oxpsipgzyvL5sRfeum+7fDEuOl63EFR0yuWbBsOGhUMtBq29jmriTKsI+62l" +
       "AOhBx/bDM+wFwHB1RK4SOyWcW2lrJKsjaNErQjlAhwctlQtQoDZ0HuLY4zfB" +
       "hTQOn+ekEe+Whyin+PtBQfpZHCbdeL/7f8w1nEiaRbiCRjshTMP1Fbcy9yYh" +
       "v7jY3rhu8YFfi2gsdfstEFc5R9NCbgm7qN60WE4VWrW4qGSKrywnd3xMSAU7" +
       "+K9CF+pygFan7+YcOKkT3+FdebgWrLSLkxoYw9Qz0E5VowZKGMOUcN3oiFLC" +
       "+eI7THeGk+aADiqs+xImQe5Agq+Oedv1ZygLjRNABdafWCVGivhZe6v4CYHi" +
       "1jKMEBd7P58d92oPre7ikfGHr3/6Wbd3kTW6sCAugnCvdduoEiZsWZGbz6v+" +
       "8I4bbS83bYt7udDpChxk6oZQoiQh50wM2p5IYbcHSvX9vaUDr/38XP27AMsn" +
       "SIxysvpE6Frt3iGhO3AAjE+kAjgO/TEkOo7BHd+av2d37m+/E+XHg++NK9Nn" +
       "5CvPPfTLi+uXoDNZNQqRCP4ppkmzah+a1yeZPGulSatqDxdBROCiUm2UNDq6" +
       "esZho0qKtGF+UbzyC7t45mwtzWLny0l/xd2+yn0BSvUcsw4ajq4IlAT8DmbK" +
       "/nHwYdUxzciGYKbkyjWVumfkQ0+0//hCV80IYESZOmH2DbaTLUF2+E+IAMM7" +
       "XCD+D3xi8PwbH3Q6Trh34a6kdyHfXLqRQ0/grtVkUmOm6dM2fd90s+gsDk8U" +
       "cZ6T2E5vNoTe+PPr4vyviVcczv8XeXIW+JAUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "32sxCSAAAA==");
}
