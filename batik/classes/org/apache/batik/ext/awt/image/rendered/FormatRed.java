package org.apache.batik.ext.awt.image.rendered;
public class FormatRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    public static org.apache.batik.ext.awt.image.rendered.CachableRed construct(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                                                                                java.awt.image.ColorModel cm) {
        java.awt.image.ColorModel srcCM =
          src.
          getColorModel(
            );
        if (cm.
              hasAlpha(
                ) !=
              srcCM.
              hasAlpha(
                ) ||
              cm.
              isAlphaPremultiplied(
                ) !=
              srcCM.
              isAlphaPremultiplied(
                ))
            return new org.apache.batik.ext.awt.image.rendered.FormatRed(
              src,
              cm);
        if (cm.
              getNumComponents(
                ) !=
              srcCM.
              getNumComponents(
                ))
            throw new java.lang.IllegalArgumentException(
              "Incompatible ColorModel given");
        if (srcCM instanceof java.awt.image.ComponentColorModel &&
              cm instanceof java.awt.image.ComponentColorModel)
            return src;
        if (srcCM instanceof java.awt.image.DirectColorModel &&
              cm instanceof java.awt.image.DirectColorModel)
            return src;
        return new org.apache.batik.ext.awt.image.rendered.FormatRed(
          src,
          cm);
    }
    public FormatRed(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                     java.awt.image.SampleModel sm) { super(
                                                        cr,
                                                        cr.
                                                          getBounds(
                                                            ),
                                                        makeColorModel(
                                                          cr,
                                                          sm),
                                                        sm,
                                                        cr.
                                                          getTileGridXOffset(
                                                            ),
                                                        cr.
                                                          getTileGridYOffset(
                                                            ),
                                                        null);
    }
    public FormatRed(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                     java.awt.image.ColorModel cm) { super(
                                                       cr,
                                                       cr.
                                                         getBounds(
                                                           ),
                                                       cm,
                                                       makeSampleModel(
                                                         cr,
                                                         cm),
                                                       cr.
                                                         getTileGridXOffset(
                                                           ),
                                                       cr.
                                                         getTileGridYOffset(
                                                           ),
                                                       null);
    }
    public org.apache.batik.ext.awt.image.rendered.CachableRed getSource() {
        return (org.apache.batik.ext.awt.image.rendered.CachableRed)
                 getSources(
                   ).
                 get(
                   0);
    }
    public java.lang.Object getProperty(java.lang.String name) {
        return getSource(
                 ).
          getProperty(
            name);
    }
    public java.lang.String[] getPropertyNames() { return getSource(
                                                            ).
                                                     getPropertyNames(
                                                       );
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        java.awt.image.ColorModel cm =
          getColorModel(
            );
        org.apache.batik.ext.awt.image.rendered.CachableRed cr =
          getSource(
            );
        java.awt.image.ColorModel srcCM =
          cr.
          getColorModel(
            );
        java.awt.image.SampleModel srcSM =
          cr.
          getSampleModel(
            );
        srcSM =
          srcSM.
            createCompatibleSampleModel(
              wr.
                getWidth(
                  ),
              wr.
                getHeight(
                  ));
        java.awt.image.WritableRaster srcWR;
        srcWR =
          java.awt.image.Raster.
            createWritableRaster(
              srcSM,
              new java.awt.Point(
                wr.
                  getMinX(
                    ),
                wr.
                  getMinY(
                    )));
        getSource(
          ).
          copyData(
            srcWR);
        java.awt.image.BufferedImage srcBI =
          new java.awt.image.BufferedImage(
          srcCM,
          srcWR.
            createWritableTranslatedChild(
              0,
              0),
          srcCM.
            isAlphaPremultiplied(
              ),
          null);
        java.awt.image.BufferedImage dstBI =
          new java.awt.image.BufferedImage(
          cm,
          wr.
            createWritableTranslatedChild(
              0,
              0),
          cm.
            isAlphaPremultiplied(
              ),
          null);
        org.apache.batik.ext.awt.image.GraphicsUtil.
          copyData(
            srcBI,
            dstBI);
        return wr;
    }
    public static java.awt.image.SampleModel makeSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                                                             java.awt.image.ColorModel cm) {
        java.awt.image.SampleModel srcSM =
          cr.
          getSampleModel(
            );
        return cm.
          createCompatibleSampleModel(
            srcSM.
              getWidth(
                ),
            srcSM.
              getHeight(
                ));
    }
    public static java.awt.image.ColorModel makeColorModel(org.apache.batik.ext.awt.image.rendered.CachableRed cr,
                                                           java.awt.image.SampleModel sm) {
        java.awt.image.ColorModel srcCM =
          cr.
          getColorModel(
            );
        java.awt.color.ColorSpace cs =
          srcCM.
          getColorSpace(
            );
        int bands =
          sm.
          getNumBands(
            );
        int bits;
        int dt =
          sm.
          getDataType(
            );
        switch (dt) {
            case java.awt.image.DataBuffer.
                   TYPE_BYTE:
                bits =
                  8;
                break;
            case java.awt.image.DataBuffer.
                   TYPE_SHORT:
                bits =
                  16;
                break;
            case java.awt.image.DataBuffer.
                   TYPE_USHORT:
                bits =
                  16;
                break;
            case java.awt.image.DataBuffer.
                   TYPE_INT:
                bits =
                  32;
                break;
            default:
                throw new java.lang.IllegalArgumentException(
                  "Unsupported DataBuffer type: " +
                  dt);
        }
        boolean hasAlpha =
          srcCM.
          hasAlpha(
            );
        if (hasAlpha) {
            if (bands ==
                  srcCM.
                  getNumComponents(
                    ) -
                  1)
                hasAlpha =
                  false;
            else
                if (bands !=
                      srcCM.
                      getNumComponents(
                        ))
                    throw new java.lang.IllegalArgumentException(
                      "Incompatible number of bands in and out");
        }
        else {
            if (bands ==
                  srcCM.
                  getNumComponents(
                    ) +
                  1)
                hasAlpha =
                  true;
            else
                if (bands !=
                      srcCM.
                      getNumComponents(
                        ))
                    throw new java.lang.IllegalArgumentException(
                      "Incompatible number of bands in and out");
        }
        boolean preMult =
          srcCM.
          isAlphaPremultiplied(
            );
        if (!hasAlpha)
            preMult =
              false;
        if (sm instanceof java.awt.image.ComponentSampleModel) {
            int[] bitsPer =
              new int[bands];
            for (int i =
                   0;
                 i <
                   bands;
                 i++)
                bitsPer[i] =
                  bits;
            return new java.awt.image.ComponentColorModel(
              cs,
              bitsPer,
              hasAlpha,
              preMult,
              hasAlpha
                ? java.awt.Transparency.
                    TRANSLUCENT
                : java.awt.Transparency.
                    OPAQUE,
              dt);
        }
        else
            if (sm instanceof java.awt.image.SinglePixelPackedSampleModel) {
                java.awt.image.SinglePixelPackedSampleModel sppsm;
                sppsm =
                  (java.awt.image.SinglePixelPackedSampleModel)
                    sm;
                int[] masks =
                  sppsm.
                  getBitMasks(
                    );
                if (bands ==
                      4)
                    return new java.awt.image.DirectColorModel(
                      cs,
                      bits,
                      masks[0],
                      masks[1],
                      masks[2],
                      masks[3],
                      preMult,
                      dt);
                else
                    if (bands ==
                          3)
                        return new java.awt.image.DirectColorModel(
                          cs,
                          bits,
                          masks[0],
                          masks[1],
                          masks[2],
                          0,
                          preMult,
                          dt);
                    else
                        throw new java.lang.IllegalArgumentException(
                          "Incompatible number of bands out for ColorModel");
            }
        throw new java.lang.IllegalArgumentException(
          "Unsupported SampleModel Type");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Z4pXfJv1Xz9vOtuvIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "U98RT96yghe3dY8j9XR3X/em+vkXGf4D");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("32p8ZnexSnXkLMu1XAaL7e6O10m0//a7ajvWdYl++jsPfuH+p46/TB7cdXg/" +
       "zU717W13vsVEukFS3DvKfv0tv/LD//zFPy9O2f8PEHO+KkYtAAA=");
}
