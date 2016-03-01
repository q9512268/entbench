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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "004JxY/z5okKl2AoNkTp/wDQhBOs+RMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+l+CzRFr5R8AAA==");
}
