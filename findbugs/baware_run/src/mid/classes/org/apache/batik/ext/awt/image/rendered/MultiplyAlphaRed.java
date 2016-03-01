package org.apache.batik.ext.awt.image.rendered;
public class MultiplyAlphaRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    public MultiplyAlphaRed(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                            org.apache.batik.ext.awt.image.rendered.CachableRed alpha) {
        super(
          makeList(
            src,
            alpha),
          makeBounds(
            src,
            alpha),
          fixColorModel(
            src),
          fixSampleModel(
            src),
          src.
            getTileGridXOffset(
              ),
          src.
            getTileGridYOffset(
              ),
          null);
    }
    public boolean is_INT_PACK_BYTE_COMP(java.awt.image.SampleModel srcSM,
                                         java.awt.image.SampleModel alpSM) {
        if (!(srcSM instanceof java.awt.image.SinglePixelPackedSampleModel))
            return false;
        if (!(alpSM instanceof java.awt.image.ComponentSampleModel))
            return false;
        if (srcSM.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_INT)
            return false;
        if (alpSM.
              getDataType(
                ) !=
              java.awt.image.DataBuffer.
                TYPE_BYTE)
            return false;
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            srcSM;
        int[] masks =
          sppsm.
          getBitMasks(
            );
        if (masks.
              length !=
              4)
            return false;
        if (masks[0] !=
              16711680)
            return false;
        if (masks[1] !=
              65280)
            return false;
        if (masks[2] !=
              255)
            return false;
        if (masks[3] !=
              -16777216)
            return false;
        java.awt.image.ComponentSampleModel csm;
        csm =
          (java.awt.image.ComponentSampleModel)
            alpSM;
        if (csm.
              getNumBands(
                ) !=
              1)
            return false;
        if (csm.
              getPixelStride(
                ) !=
              1)
            return false;
        return true;
    }
    public java.awt.image.WritableRaster INT_PACK_BYTE_COMP_Impl(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed srcRed =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        org.apache.batik.ext.awt.image.rendered.CachableRed alphaRed =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              1);
        srcRed.
          copyData(
            wr);
        java.awt.Rectangle rgn =
          wr.
          getBounds(
            );
        rgn =
          rgn.
            intersection(
              alphaRed.
                getBounds(
                  ));
        java.awt.image.Raster r =
          alphaRed.
          getData(
            rgn);
        java.awt.image.ComponentSampleModel csm;
        csm =
          (java.awt.image.ComponentSampleModel)
            r.
            getSampleModel(
              );
        final int alpScanStride =
          csm.
          getScanlineStride(
            );
        java.awt.image.DataBufferByte alpDB =
          (java.awt.image.DataBufferByte)
            r.
            getDataBuffer(
              );
        final int alpBase =
          alpDB.
          getOffset(
            ) +
          csm.
          getOffset(
            rgn.
              x -
              r.
              getSampleModelTranslateX(
                ),
            rgn.
              y -
              r.
              getSampleModelTranslateY(
                ));
        final byte[] alpPixels =
          alpDB.
          getBankData(
            )[0];
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int srcScanStride =
          sppsm.
          getScanlineStride(
            );
        java.awt.image.DataBufferInt srcDB =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int srcBase =
          srcDB.
          getOffset(
            ) +
          sppsm.
          getOffset(
            rgn.
              x -
              wr.
              getSampleModelTranslateX(
                ),
            rgn.
              y -
              wr.
              getSampleModelTranslateY(
                ));
        final int[] srcPixels =
          srcDB.
          getBankData(
            )[0];
        java.awt.image.ColorModel cm =
          srcRed.
          getColorModel(
            );
        if (cm.
              isAlphaPremultiplied(
                )) {
            for (int y =
                   0;
                 y <
                   rgn.
                     height;
                 y++) {
                int sp =
                  srcBase +
                  y *
                  srcScanStride;
                int ap =
                  alpBase +
                  y *
                  alpScanStride;
                int end =
                  sp +
                  rgn.
                    width;
                while (sp <
                         end) {
                    int a =
                      (int)
                        alpPixels[ap++] &
                      255;
                    final int pix =
                      srcPixels[sp];
                    srcPixels[sp] =
                      ((pix >>>
                          24) *
                         a &
                         65280) <<
                        16 |
                        ((pix >>>
                            16 &
                            255) *
                           a &
                           65280) <<
                        8 |
                        (pix >>>
                           8 &
                           255) *
                        a &
                        65280 |
                        ((pix &
                            255) *
                           a &
                           65280) >>
                        8;
                    sp++;
                }
            }
        }
        else {
            for (int y =
                   0;
                 y <
                   rgn.
                     height;
                 y++) {
                int sp =
                  srcBase +
                  y *
                  srcScanStride;
                int ap =
                  alpBase +
                  y *
                  alpScanStride;
                int end =
                  sp +
                  rgn.
                    width;
                while (sp <
                         end) {
                    int a =
                      (int)
                        alpPixels[ap++] &
                      255;
                    int sa =
                      srcPixels[sp] >>>
                      24;
                    srcPixels[sp] =
                      (sa *
                         a &
                         65280) <<
                        16 |
                        srcPixels[sp] &
                        16777215;
                    sp++;
                }
            }
        }
        return wr;
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.CachableRed srcRed =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              0);
        org.apache.batik.ext.awt.image.rendered.CachableRed alphaRed =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            getSources(
              ).
            get(
              1);
        if (is_INT_PACK_BYTE_COMP(
              srcRed.
                getSampleModel(
                  ),
              alphaRed.
                getSampleModel(
                  )))
            return INT_PACK_BYTE_COMP_Impl(
                     wr);
        java.awt.image.ColorModel cm =
          srcRed.
          getColorModel(
            );
        if (cm.
              hasAlpha(
                )) {
            srcRed.
              copyData(
                wr);
            java.awt.Rectangle rgn =
              wr.
              getBounds(
                );
            if (rgn.
                  intersects(
                    alphaRed.
                      getBounds(
                        )))
                rgn =
                  rgn.
                    intersection(
                      alphaRed.
                        getBounds(
                          ));
            else
                return wr;
            int[] wrData =
              null;
            int[] alphaData =
              null;
            java.awt.image.Raster r =
              alphaRed.
              getData(
                rgn);
            int w =
              rgn.
                width;
            final int bands =
              wr.
              getSampleModel(
                ).
              getNumBands(
                );
            if (cm.
                  isAlphaPremultiplied(
                    )) {
                for (int y =
                       rgn.
                         y;
                     y <
                       rgn.
                         y +
                       rgn.
                         height;
                     y++) {
                    wrData =
                      wr.
                        getPixels(
                          rgn.
                            x,
                          y,
                          w,
                          1,
                          wrData);
                    alphaData =
                      r.
                        getSamples(
                          rgn.
                            x,
                          y,
                          w,
                          1,
                          0,
                          alphaData);
                    int i =
                      0;
                    int a;
                    int b;
                    switch (bands) {
                        case 2:
                            for (int x =
                                   0;
                                 x <
                                   alphaData.
                                     length;
                                 x++) {
                                a =
                                  alphaData[x] &
                                    255;
                                wrData[i] =
                                  (wrData[i] &
                                     255) *
                                    a >>
                                    8;
                                ++i;
                                wrData[i] =
                                  (wrData[i] &
                                     255) *
                                    a >>
                                    8;
                                ++i;
                            }
                            break;
                        case 4:
                            for (int x =
                                   0;
                                 x <
                                   alphaData.
                                     length;
                                 x++) {
                                a =
                                  alphaData[x] &
                                    255;
                                wrData[i] =
                                  (wrData[i] &
                                     255) *
                                    a >>
                                    8;
                                ++i;
                                wrData[i] =
                                  (wrData[i] &
                                     255) *
                                    a >>
                                    8;
                                ++i;
                                wrData[i] =
                                  (wrData[i] &
                                     255) *
                                    a >>
                                    8;
                                ++i;
                                wrData[i] =
                                  (wrData[i] &
                                     255) *
                                    a >>
                                    8;
                                ++i;
                            }
                            break;
                        default:
                            for (int x =
                                   0;
                                 x <
                                   alphaData.
                                     length;
                                 x++) {
                                a =
                                  alphaData[x] &
                                    255;
                                for (b =
                                       0;
                                     b <
                                       bands;
                                     b++) {
                                    wrData[i] =
                                      (wrData[i] &
                                         255) *
                                        a >>
                                        8;
                                    ++i;
                                }
                            }
                    }
                    wr.
                      setPixels(
                        rgn.
                          x,
                        y,
                        w,
                        1,
                        wrData);
                }
            }
            else {
                int b =
                  srcRed.
                  getSampleModel(
                    ).
                  getNumBands(
                    ) -
                  1;
                for (int y =
                       rgn.
                         y;
                     y <
                       rgn.
                         y +
                       rgn.
                         height;
                     y++) {
                    wrData =
                      wr.
                        getSamples(
                          rgn.
                            x,
                          y,
                          w,
                          1,
                          b,
                          wrData);
                    alphaData =
                      r.
                        getSamples(
                          rgn.
                            x,
                          y,
                          w,
                          1,
                          0,
                          alphaData);
                    for (int i =
                           0;
                         i <
                           wrData.
                             length;
                         i++) {
                        wrData[i] =
                          (wrData[i] &
                             255) *
                            (alphaData[i] &
                               255) >>
                            8;
                    }
                    wr.
                      setSamples(
                        rgn.
                          x,
                        y,
                        w,
                        1,
                        b,
                        wrData);
                }
            }
            return wr;
        }
        int[] bands =
          new int[wr.
                    getNumBands(
                      ) -
                    1];
        for (int i =
               0;
             i <
               bands.
                 length;
             i++)
            bands[i] =
              i;
        java.awt.image.WritableRaster subWr;
        subWr =
          wr.
            createWritableChild(
              wr.
                getMinX(
                  ),
              wr.
                getMinY(
                  ),
              wr.
                getWidth(
                  ),
              wr.
                getHeight(
                  ),
              wr.
                getMinX(
                  ),
              wr.
                getMinY(
                  ),
              bands);
        srcRed.
          copyData(
            subWr);
        java.awt.Rectangle rgn =
          wr.
          getBounds(
            );
        rgn =
          rgn.
            intersection(
              alphaRed.
                getBounds(
                  ));
        bands =
          (new int[] { wr.
             getNumBands(
               ) -
             1 });
        subWr =
          wr.
            createWritableChild(
              rgn.
                x,
              rgn.
                y,
              rgn.
                width,
              rgn.
                height,
              rgn.
                x,
              rgn.
                y,
              bands);
        alphaRed.
          copyData(
            subWr);
        return wr;
    }
    public static java.util.List makeList(org.apache.batik.ext.awt.image.rendered.CachableRed src1,
                                          org.apache.batik.ext.awt.image.rendered.CachableRed src2) {
        java.util.List ret =
          new java.util.ArrayList(
          2);
        ret.
          add(
            src1);
        ret.
          add(
            src2);
        return ret;
    }
    public static java.awt.Rectangle makeBounds(org.apache.batik.ext.awt.image.rendered.CachableRed src1,
                                                org.apache.batik.ext.awt.image.rendered.CachableRed src2) {
        java.awt.Rectangle r1 =
          src1.
          getBounds(
            );
        java.awt.Rectangle r2 =
          src2.
          getBounds(
            );
        return r1.
          intersection(
            r2);
    }
    public static java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        java.awt.image.SampleModel srcSM =
          src.
          getSampleModel(
            );
        if (cm.
              hasAlpha(
                ))
            return srcSM;
        int w =
          srcSM.
          getWidth(
            );
        int h =
          srcSM.
          getHeight(
            );
        int b =
          srcSM.
          getNumBands(
            ) +
          1;
        int[] offsets =
          new int[b];
        for (int i =
               0;
             i <
               b;
             i++)
            offsets[i] =
              i;
        return new java.awt.image.PixelInterleavedSampleModel(
          java.awt.image.DataBuffer.
            TYPE_BYTE,
          w,
          h,
          b,
          w *
            b,
          offsets);
    }
    public static java.awt.image.ColorModel fixColorModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        if (cm.
              hasAlpha(
                ))
            return cm;
        int b =
          src.
          getSampleModel(
            ).
          getNumBands(
            ) +
          1;
        int[] bits =
          new int[b];
        for (int i =
               0;
             i <
               b;
             i++)
            bits[i] =
              8;
        java.awt.color.ColorSpace cs =
          cm.
          getColorSpace(
            );
        return new java.awt.image.ComponentColorModel(
          cs,
          bits,
          true,
          false,
          java.awt.Transparency.
            TRANSLUCENT,
          java.awt.image.DataBuffer.
            TYPE_BYTE);
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
       "7KuK5E9u/aM3/N4zX8n2Wf8PJdoD/lUqAAA=");
}
