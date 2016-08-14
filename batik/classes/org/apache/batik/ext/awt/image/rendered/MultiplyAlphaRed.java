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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "u6ae6hcM/NgbMPCxovNpoMoTe97993do4MEpPt5teRQ/y+30/SnQP7iLqf+w" +
       "aP4+MNXXl+Xx2Ll92vPYNNA3JeDdNP9V/2tf/nT+6iv7bVhDT+wUqtzp5Zhb" +
       "388pjlTfdZdj4dPXJv6Ce/9rf/qH4x87htQ3nfjxkcKER+/mx+Pkf+jsAdT+" +
       "tO+XT2P5qTcQy7cXne8Gcz9zpMMzf+Ox/Gd3ieXni+azKXS1iCUdZoGVHPvg" +
       "kRMAGNgmwPOZZ5+64NU34IKnis73AdPfc+SC93wXXXBm0e6t/7W7WP/rRfNv" +
       "QLgdd3vxOXBq6xfegK1PFp3PAYXef2Tr+/8mbf0Pd7H1PxXNF1PozcBWJvTC" +
       "uDT1ONjfcwHtL1CUfvjS6/HDNoWuX3wTpDjWfvyWt9L2b1KZn3352v2Pvaz8" +
       "TvkyxMnbTg8I0P1O5nlnDxHP3F+OYhvYU1LujxSj8ut3U+g93+EpOMCx49vS" +
       "iN/ZS/jvKfTU3SWk0H3l91mur6TQ43fiSqF7QHuW+vdT6K23owaUoD1L+UfA" +
       "mxcpwfzl91m6PwYr+ZQuhS7vb86S/BmQDkiK269Hr/uVAcoA/711MwXR3F46" +
       "X+qe5Mkj3y5PzlTH7zwH6eWLjcf1ZyYfPTlefbnT+4lv1n9p/7qJ6el5Xki5" +
       "X4Cu7N98Oalhn7mjtGNZl/n3fuuhzz3wruOHw0N7hU8X4Rndnr79ux2sH6Xl" +
       "2xj5v3zsn3/gH738lfJ89v8BXA4ZRXEqAAA=");
}
