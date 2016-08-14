package org.apache.batik.ext.awt.image;
public class SVGComposite implements java.awt.Composite {
    public static final org.apache.batik.ext.awt.image.SVGComposite OVER =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        OVER);
    public static final org.apache.batik.ext.awt.image.SVGComposite IN = new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        IN);
    public static final org.apache.batik.ext.awt.image.SVGComposite
      OUT =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        OUT);
    public static final org.apache.batik.ext.awt.image.SVGComposite
      ATOP =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        ATOP);
    public static final org.apache.batik.ext.awt.image.SVGComposite
      XOR =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        XOR);
    public static final org.apache.batik.ext.awt.image.SVGComposite
      MULTIPLY =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        MULTIPLY);
    public static final org.apache.batik.ext.awt.image.SVGComposite
      SCREEN =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        SCREEN);
    public static final org.apache.batik.ext.awt.image.SVGComposite
      DARKEN =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        DARKEN);
    public static final org.apache.batik.ext.awt.image.SVGComposite
      LIGHTEN =
      new org.apache.batik.ext.awt.image.SVGComposite(
      org.apache.batik.ext.awt.image.CompositeRule.
        LIGHTEN);
    org.apache.batik.ext.awt.image.CompositeRule rule;
    public org.apache.batik.ext.awt.image.CompositeRule getRule() {
        return rule;
    }
    public SVGComposite(org.apache.batik.ext.awt.image.CompositeRule rule) {
        super(
          );
        this.
          rule =
          rule;
    }
    public boolean equals(java.lang.Object o) { if (o instanceof org.apache.batik.ext.awt.image.SVGComposite) {
                                                    org.apache.batik.ext.awt.image.SVGComposite svgc =
                                                      (org.apache.batik.ext.awt.image.SVGComposite)
                                                        o;
                                                    return svgc.
                                                      getRule(
                                                        ) ==
                                                      getRule(
                                                        );
                                                }
                                                else
                                                    if (o instanceof java.awt.AlphaComposite) {
                                                        java.awt.AlphaComposite ac =
                                                          (java.awt.AlphaComposite)
                                                            o;
                                                        switch (getRule(
                                                                  ).
                                                                  getRule(
                                                                    )) {
                                                            case org.apache.batik.ext.awt.image.CompositeRule.
                                                                   RULE_OVER:
                                                                return ac ==
                                                                  java.awt.AlphaComposite.
                                                                    SrcOver;
                                                            case org.apache.batik.ext.awt.image.CompositeRule.
                                                                   RULE_IN:
                                                                return ac ==
                                                                  java.awt.AlphaComposite.
                                                                    SrcIn;
                                                            case org.apache.batik.ext.awt.image.CompositeRule.
                                                                   RULE_OUT:
                                                                return ac ==
                                                                  java.awt.AlphaComposite.
                                                                    SrcOut;
                                                            default:
                                                                return false;
                                                        }
                                                    }
                                                return false;
    }
    public boolean is_INT_PACK(java.awt.image.ColorModel cm) {
        if (!(cm instanceof java.awt.image.PackedColorModel))
            return false;
        java.awt.image.PackedColorModel pcm =
          (java.awt.image.PackedColorModel)
            cm;
        int[] masks =
          pcm.
          getMasks(
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
        return true;
    }
    public java.awt.CompositeContext createContext(java.awt.image.ColorModel srcCM,
                                                   java.awt.image.ColorModel dstCM,
                                                   java.awt.RenderingHints hints) {
        if (false) {
            java.awt.color.ColorSpace srcCS =
              srcCM.
              getColorSpace(
                );
            java.awt.color.ColorSpace dstCS =
              dstCM.
              getColorSpace(
                );
            java.lang.System.
              out.
              println(
                "srcCS: " +
                srcCS);
            java.lang.System.
              out.
              println(
                "dstCS: " +
                dstCS);
            java.lang.System.
              out.
              println(
                "lRGB: " +
                java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_LINEAR_RGB));
            java.lang.System.
              out.
              println(
                "sRGB: " +
                java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_sRGB));
        }
        boolean use_int_pack =
          is_INT_PACK(
            srcCM) &&
          is_INT_PACK(
            dstCM);
        switch (rule.
                  getRule(
                    )) {
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_OVER:
                if (!dstCM.
                      hasAlpha(
                        )) {
                    if (use_int_pack)
                        return new org.apache.batik.ext.awt.image.SVGComposite.OverCompositeContext_INT_PACK_NA(
                          srcCM,
                          dstCM);
                    else
                        return new org.apache.batik.ext.awt.image.SVGComposite.OverCompositeContext_NA(
                          srcCM,
                          dstCM);
                }
                if (!use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.OverCompositeContext(
                      srcCM,
                      dstCM);
                if (srcCM.
                      isAlphaPremultiplied(
                        ))
                    return new org.apache.batik.ext.awt.image.SVGComposite.OverCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.OverCompositeContext_INT_PACK_UNPRE(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_IN:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.InCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.InCompositeContext(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_OUT:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.OutCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.OutCompositeContext(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_ATOP:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.AtopCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.AtopCompositeContext(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_XOR:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.XorCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.XorCompositeContext(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_ARITHMETIC:
                float[] coeff =
                  rule.
                  getCoefficients(
                    );
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.ArithCompositeContext_INT_PACK_LUT(
                      srcCM,
                      dstCM,
                      coeff[0],
                      coeff[1],
                      coeff[2],
                      coeff[3]);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.ArithCompositeContext(
                      srcCM,
                      dstCM,
                      coeff[0],
                      coeff[1],
                      coeff[2],
                      coeff[3]);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_MULTIPLY:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.MultiplyCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.MultiplyCompositeContext(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_SCREEN:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.ScreenCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.ScreenCompositeContext(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_DARKEN:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.DarkenCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.DarkenCompositeContext(
                      srcCM,
                      dstCM);
            case org.apache.batik.ext.awt.image.CompositeRule.
                   RULE_LIGHTEN:
                if (use_int_pack)
                    return new org.apache.batik.ext.awt.image.SVGComposite.LightenCompositeContext_INT_PACK(
                      srcCM,
                      dstCM);
                else
                    return new org.apache.batik.ext.awt.image.SVGComposite.LightenCompositeContext(
                      srcCM,
                      dstCM);
            default:
                throw new java.lang.UnsupportedOperationException(
                  "Unknown composite rule requested.");
        }
    }
    public abstract static class AlphaPreCompositeContext implements java.awt.CompositeContext {
        java.awt.image.ColorModel srcCM;
        java.awt.image.ColorModel dstCM;
        AlphaPreCompositeContext(java.awt.image.ColorModel srcCM,
                                 java.awt.image.ColorModel dstCM) {
            super(
              );
            this.
              srcCM =
              srcCM;
            this.
              dstCM =
              dstCM;
        }
        public void dispose() { srcCM = null;
                                dstCM = null;
        }
        protected abstract void precompose(java.awt.image.Raster src,
                                           java.awt.image.Raster dstIn,
                                           java.awt.image.WritableRaster dstOut);
        public void compose(java.awt.image.Raster src,
                            java.awt.image.Raster dstIn,
                            java.awt.image.WritableRaster dstOut) {
            java.awt.image.ColorModel srcPreCM =
              srcCM;
            if (!srcCM.
                  isAlphaPremultiplied(
                    ))
                srcPreCM =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceData(
                      (java.awt.image.WritableRaster)
                        src,
                      srcCM,
                      true);
            java.awt.image.ColorModel dstPreCM =
              dstCM;
            if (!dstCM.
                  isAlphaPremultiplied(
                    ))
                dstPreCM =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceData(
                      (java.awt.image.WritableRaster)
                        dstIn,
                      dstCM,
                      true);
            precompose(
              src,
              dstIn,
              dstOut);
            if (!srcCM.
                  isAlphaPremultiplied(
                    ))
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  coerceData(
                    (java.awt.image.WritableRaster)
                      src,
                    srcPreCM,
                    false);
            if (!dstCM.
                  isAlphaPremultiplied(
                    )) {
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  coerceData(
                    dstOut,
                    dstPreCM,
                    false);
                if (dstIn !=
                      dstOut)
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      coerceData(
                        (java.awt.image.WritableRaster)
                          dstIn,
                        dstPreCM,
                        false);
            }
        }
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
           "/wfJCA5cTiUAAA==");
    }
    public abstract static class AlphaPreCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        AlphaPreCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                          java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        protected abstract void precompose_INT_PACK(final int width,
                                                    final int height,
                                                    final int[] srcPixels,
                                                    final int srcAdjust,
                                                    int srcSp,
                                                    final int[] dstInPixels,
                                                    final int dstInAdjust,
                                                    int dstInSp,
                                                    final int[] dstOutPixels,
                                                    final int dstOutAdjust,
                                                    int dstOutSp);
        protected void precompose(java.awt.image.Raster src,
                                  java.awt.image.Raster dstIn,
                                  java.awt.image.WritableRaster dstOut) {
            int x0 =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int h =
              dstOut.
              getHeight(
                );
            java.awt.image.SinglePixelPackedSampleModel srcSPPSM;
            srcSPPSM =
              (java.awt.image.SinglePixelPackedSampleModel)
                src.
                getSampleModel(
                  );
            final int srcScanStride =
              srcSPPSM.
              getScanlineStride(
                );
            java.awt.image.DataBufferInt srcDB =
              (java.awt.image.DataBufferInt)
                src.
                getDataBuffer(
                  );
            final int[] srcPixels =
              srcDB.
              getBankData(
                )[0];
            final int srcBase =
              srcDB.
              getOffset(
                ) +
              srcSPPSM.
              getOffset(
                x0 -
                  src.
                  getSampleModelTranslateX(
                    ),
                y0 -
                  src.
                  getSampleModelTranslateY(
                    ));
            java.awt.image.SinglePixelPackedSampleModel dstInSPPSM;
            dstInSPPSM =
              (java.awt.image.SinglePixelPackedSampleModel)
                dstIn.
                getSampleModel(
                  );
            final int dstInScanStride =
              dstInSPPSM.
              getScanlineStride(
                );
            java.awt.image.DataBufferInt dstInDB =
              (java.awt.image.DataBufferInt)
                dstIn.
                getDataBuffer(
                  );
            final int[] dstInPixels =
              dstInDB.
              getBankData(
                )[0];
            final int dstInBase =
              dstInDB.
              getOffset(
                ) +
              dstInSPPSM.
              getOffset(
                x0 -
                  dstIn.
                  getSampleModelTranslateX(
                    ),
                y0 -
                  dstIn.
                  getSampleModelTranslateY(
                    ));
            java.awt.image.SinglePixelPackedSampleModel dstOutSPPSM =
              (java.awt.image.SinglePixelPackedSampleModel)
                dstOut.
                getSampleModel(
                  );
            final int dstOutScanStride =
              dstOutSPPSM.
              getScanlineStride(
                );
            java.awt.image.DataBufferInt dstOutDB =
              (java.awt.image.DataBufferInt)
                dstOut.
                getDataBuffer(
                  );
            final int[] dstOutPixels =
              dstOutDB.
              getBankData(
                )[0];
            final int dstOutBase =
              dstOutDB.
              getOffset(
                ) +
              dstOutSPPSM.
              getOffset(
                x0 -
                  dstOut.
                  getSampleModelTranslateX(
                    ),
                y0 -
                  dstOut.
                  getSampleModelTranslateY(
                    ));
            final int srcAdjust =
              srcScanStride -
              w;
            final int dstInAdjust =
              dstInScanStride -
              w;
            final int dstOutAdjust =
              dstOutScanStride -
              w;
            precompose_INT_PACK(
              w,
              h,
              srcPixels,
              srcAdjust,
              srcBase,
              dstInPixels,
              dstInAdjust,
              dstInBase,
              dstOutPixels,
              dstOutAdjust,
              dstOutBase);
        }
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
          ("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");
    }
    public static class OverCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        OverCompositeContext(java.awt.image.ColorModel srcCM,
                             java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int sp =
                  0;
                int end =
                  w *
                  4;
                while (sp <
                         end) {
                    final int dstM =
                      (255 -
                         srcPix[sp +
                                  3]) *
                      norm;
                    dstPix[sp] =
                      srcPix[sp] +
                        (dstPix[sp] *
                           dstM +
                           pt5 >>>
                           24);
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] +
                        (dstPix[sp] *
                           dstM +
                           pt5 >>>
                           24);
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] +
                        (dstPix[sp] *
                           dstM +
                           pt5 >>>
                           24);
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] +
                        (dstPix[sp] *
                           dstM +
                           pt5 >>>
                           24);
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
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
          ("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");
    }
    public static class OverCompositeContext_NA extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        OverCompositeContext_NA(java.awt.image.ColorModel srcCM,
                                java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int srcSP =
                  0;
                int dstSP =
                  0;
                int end =
                  w *
                  4;
                while (srcSP <
                         end) {
                    final int dstM =
                      (255 -
                         srcPix[srcSP +
                                  3]) *
                      norm;
                    dstPix[dstSP] =
                      srcPix[srcSP] +
                        (dstPix[dstSP] *
                           dstM +
                           pt5 >>>
                           24);
                    ++srcSP;
                    ++dstSP;
                    dstPix[dstSP] =
                      srcPix[srcSP] +
                        (dstPix[dstSP] *
                           dstM +
                           pt5 >>>
                           24);
                    ++srcSP;
                    ++dstSP;
                    dstPix[dstSP] =
                      srcPix[srcSP] +
                        (dstPix[dstSP] *
                           dstM +
                           pt5 >>>
                           24);
                    srcSP +=
                      2;
                    ++dstSP;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
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
           "/dp0s6g5vUqpUShXeGI2rw4DejIdN1dFkVosE09s98WFZVZ6rc2Gnladrj0A" +
           "PSpueuWRTNT6eK1SHyQoJtaASEgcNcSw9Nhx/bWd/O7NDrlH9xvwwJe+6L6G" +
           "E09ya4V7O4W70lpWLrn3dKn8eGltV0hB0sPdw7e7zcgOdp/4wI0X1cEnC3sH" +
           "BSgRnuUPLpl2ctLT9dtuf4Kls5ucXVXkix/414cm7zTe8xoqwY+eGuRpkb9L" +
           "v/Tl1luV39hDzh7VSG66YzrJdO1kZeRiAKJl4ExO1EcePnLrpdRdFWjqMwdu" +
           "ff+tq7G3nKgz2URt4+FUce/sQUXroOBx36n64EgKo22taXVI8vApkllgRmkt" +
           "c0uaKYlfpYL4vrTxI+SiFwAluwjYlp+nx4JQgIfy2DXVXXQGP+48fqJWFyEP" +
           "3Oae4dCI3Gu4s4DB9eBN96LbuzzlMy9euvDAi9O/yarzR/dtd/WRC9rSso4X" +
           "vo71z0PTNTPzxl3bMpiX/TwXIY+8+rgi5Fz2m5nx7JbrgxHy4O24IuQsbI9T" +
           "Px8hb7wVNaSE7XHKX4+Qy6cpof7s9zjdDTiXOzq4PLed4yQfhdIhSdp9wTuc" +
           "guZruTbCLM+Q2ACcntLkzEk4OQqYKz8uYI4h0JMnoCO7KT9c5svtXfl15bMv" +
           "dpn3vlL95PY6Q7GkzSaVcqGP3Lm9WTmCisdvK+1Q1vn2Uz+853N3veUQ0+7Z" +
           "Dni3gI+N7dFbXyKQthdlZf/NHz3wB+/47Re/kZUH/xdCsDZGwiAAAA==");
    }
    public static class OverCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        OverCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                      java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int dstInP;
            int dstM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstInP =
                      dstInPixels[dstInSp++];
                    dstM =
                      (255 -
                         (srcP >>>
                            24)) *
                        norm;
                    dstOutPixels[dstOutSp++] =
                      (srcP &
                         -16777216) +
                        ((dstInP >>>
                            24) *
                           dstM +
                           pt5 &
                           -16777216) |
                        (srcP &
                           16711680) +
                        (((dstInP >>
                             16 &
                             255) *
                            dstM +
                            pt5 &
                            -16777216) >>>
                           8) |
                        (srcP &
                           65280) +
                        (((dstInP >>
                             8 &
                             255) *
                            dstM +
                            pt5 &
                            -16777216) >>>
                           16) |
                        (srcP &
                           255) +
                        ((dstInP &
                            255) *
                           dstM +
                           pt5 >>>
                           24);
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "dqfGwk+ycIB9hT3S4Sf/BWInzOEnGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "TJqLBaPQlj0JfGs9XHQkMWkuxCLOxjQ6THpTfiUkMrNBNXjGMfPQVbwxpcz7" +
           "uGdghjMN+2S/u5kP+WhUnPZ1WqpN9DohS512V24t+/hwQQ29BTlmGuZ0GFGK" +
           "TLYqor9eSCnitzFt7LRdZCFUui4hr3qeP8fXy8FgYmrEwJTaNlOMDHMxmviy" +
           "vVhNuoXewMdY0qmX5RrSFXyj3EYnlDjAalZitrvTVreLh0OvzyhMZM/pFNg2" +
           "4CmiGuqVHm2JK8Lx2AXT7zd6vTm8iCKt1Yu6EzTy9ahfbVjrvuIICuUPZ6TZ" +
           "6rSWRWyNUbjQQJ1lMehscMpyuYY3odRWo07NW6sNPuok5a7YLZo9DZGHKfjK" +
           "wzea1KQyTkQlmARjV26IE54c610KN3vjVr0xQBaNCp/Ijf58EFGNuVTxgoGA" +
           "kwYvslJbqFRoqtZGcZmWRnyPHzD1STcdLHHbELCA1dNNMJq15rwub8burKC3" +
           "aFrc9OtcIod9SwiL86m1pLV5CifGlBkaY6xbQytKDafbKUnX095mqaOFiqoX" +
           "lNRhY7XsdfShVXGdVSLilClTA99RJa1fV0fIkJUU3zUkna32CE3vWAocEWPE" +
           "bLU2obHxUqyF1rR1sZbUarNmb1ZXuPXU5k3f6VaaA9PvaEOpF9rjEsbLQSNs" +
           "p1VPIOSJSepplSm7vc2600tG6yKVYiWatYl00J/2bXLCVuZuy1y7ZhgYQ5ky" +
           "/XgY4uKg51i0wvtzFo46NYPccN3ZlJwljtKR1n5fAAneJoROSxqjtuTHKQFS" +
           "ku6URKUlSa26yjR5ZOM16L7lm0qjwbYNs5Zw6IAgpGZfkpYteMxVca+BieZ4" +
           "RTfSiVP09QLvDiiWjEdlnitSsYrF83o9lFdgDpMzsZFQLWPIZjFQy2F/vlky" +
           "ruE3w2Jr1mQaxXTQMT0DSVpThm2pUV+Om2w8YTbMSqC8aoTM8KmAThcqTA6s" +
           "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" +
           "SZq4CSYAAA==");
    }
    public static class OverCompositeContext_INT_PACK_NA extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        OverCompositeContext_INT_PACK_NA(java.awt.image.ColorModel srcCM,
                                         java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int dstInP;
            int dstM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstInP =
                      dstInPixels[dstInSp++];
                    dstM =
                      (255 -
                         (srcP >>>
                            24)) *
                        norm;
                    dstOutPixels[dstOutSp++] =
                      (srcP &
                         16711680) +
                        (((dstInP >>
                             16 &
                             255) *
                            dstM +
                            pt5 &
                            -16777216) >>>
                           8) |
                        (srcP &
                           65280) +
                        (((dstInP >>
                             8 &
                             255) *
                            dstM +
                            pt5 &
                            -16777216) >>>
                           16) |
                        (srcP &
                           255) +
                        ((dstInP &
                            255) *
                           dstM +
                           pt5 >>>
                           24);
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "qvKSOzUWgRL5Y+wr7JEOP/0vaqJzti0bAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "eF5xPzsRB0IE3WQ6xVl4Aqz7shtbtzjB3h0XPfk7j3zpTU8+8g/F6e5FE3wR" +
           "DdBAv07r88Sc7z71jW9/5fn3f6zoj5xfSuFO/bM942tbwqc6vYVutx9Z63Zo" +
           "Z7Lzw521dp8RJP+YbTnJ80I43OjLwE1CNYCHrqJypmypASc5qn3Y/fv/WCbd" +
           "uebQj+cOEuHobOvx9BxURMZbni15j4Digq06+q5/muTDG730iP+ZPsQLjo85" +
           "u7brqHkz5PDdrgdouvtHPyEAL9PrSursJC0We86he7Kv8a5nePer+fCOCLpZ" +
           "ziXdKfYM5E+k0JEFdma44W1Bv3kGXu/NBx+YywtUuWifqkdd0+ul3PmNayrH" +
           "mBw82ynmqQ5HBD30bG3aQxeVnkPvF2T/vdf8vmT3mwj5Y09eunjPk7Ov7ZL3" +
           "8HcLt9LQRS227ZN9gxPXF4AxNLOwz627LoJXfPx2BD3wzHIBHxafhRq/tZv1" +
           "oQi690azAIaB8ST1h0F4Xo8aUILxJOXvR9Dls5Rg/eLzJN3HIui2YzqQRLuL" +
           "kySfBNwBSX75Ke/QBcxzab+jtmdIXKDe0LfpudPb6lEI3fVsIXRiJ37kFMgX" +
           "Pz063O7i3Y+Prsoff5IavuF7jQ/t2sKyLWVZzuUiwONdh/poy3z4htwOeV0g" +
           "H/3hHZ+49WWHe/sdO4GPN7ITsj14/WYstvaion2a/dE9f/Cq333y60Wb5X8B" +
           "Nhv0BBMmAAA=");
    }
    public static class OverCompositeContext_INT_PACK_UNPRE extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        OverCompositeContext_INT_PACK_UNPRE(java.awt.image.ColorModel srcCM,
                                            java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
            if (srcCM.
                  isAlphaPremultiplied(
                    ))
                throw new java.lang.IllegalArgumentException(
                  "OverCompositeContext_INT_PACK_UNPRE is only for" +
                  "sources with unpremultiplied alpha");
        }
        public void compose(java.awt.image.Raster src,
                            java.awt.image.Raster dstIn,
                            java.awt.image.WritableRaster dstOut) {
            java.awt.image.ColorModel dstPreCM =
              dstCM;
            if (!dstCM.
                  isAlphaPremultiplied(
                    ))
                dstPreCM =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceData(
                      (java.awt.image.WritableRaster)
                        dstIn,
                      dstCM,
                      true);
            precompose(
              src,
              dstIn,
              dstOut);
            if (!dstCM.
                  isAlphaPremultiplied(
                    )) {
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  coerceData(
                    dstOut,
                    dstPreCM,
                    false);
                if (dstIn !=
                      dstOut)
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      coerceData(
                        (java.awt.image.WritableRaster)
                          dstIn,
                        dstPreCM,
                        false);
            }
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcM;
            int dstP;
            int dstM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    srcM =
                      (srcP >>>
                         24) *
                        norm;
                    dstM =
                      (255 -
                         (srcP >>>
                            24)) *
                        norm;
                    dstOutPixels[dstOutSp++] =
                      (srcP &
                         -16777216) +
                        (dstP >>>
                           24) *
                        dstM +
                        pt5 &
                        -16777216 |
                        ((srcP >>
                            16 &
                            255) *
                           srcM +
                           (dstP >>
                              16 &
                              255) *
                           dstM +
                           pt5 &
                           -16777216) >>>
                        8 |
                        ((srcP >>
                            8 &
                            255) *
                           srcM +
                           (dstP >>
                              8 &
                              255) *
                           dstM +
                           pt5 &
                           -16777216) >>>
                        16 |
                        (srcP &
                           255) *
                        srcM +
                        (dstP &
                           255) *
                        dstM +
                        pt5 >>>
                        24;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "bLjyX5U08UiCHAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class InCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        InCompositeContext(java.awt.image.ColorModel srcCM,
                           java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int sp =
                  0;
                int end =
                  w *
                  4;
                while (sp <
                         end) {
                    final int srcM =
                      dstPix[sp +
                               3] *
                      norm;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
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
           "09wIGgynsRJNl1Kz25lTQQ3HTBZdj0k7qRAcRVPumCVTQ41RfWOn5KLWHiNh" +
           "k9YTE+uuCgY8aIVdGLPslQg2Fm9/e7bluP7qdn335hvco2MNsNnLHlCvYrez" +
           "uvWEe7sJd221vFVy7+kO+fG22q6JAmUbu4dvd4iRb+o++YEbL+j9T5X2DppP" +
           "MtjHH5wt7eRkO+u33H73yuQHOLuOyJc+8K8PDd9hvftVdIEfPbXI0yJ/l3nx" +
           "K8Sbtd/Yg84e9UduOlo6yXTtZFfkYmQki8gbnuiNPHxk1kuZuWrAnL0Ds1K3" +
           "7sTe0lFnckdt4+FUY+/sQTfroNlx36neoKDEybbPlB6SPHyKBJRjSdbH3JLm" +
           "kyxfoXv43uwSJtDFIDK0/ARg23oWjwXhBGzIl76t76Iz+kl78RN9ugS6cvPx" +
           "wuH6C6/ilALE1YM3nYRuT++0z75w6cIDL4h/kzflj07Y7qKhC+bCcY73u46N" +
           "zwOtTTs3xF3b7leQ/zybQI+88roS6Fz+m6vxzJbrQwn04O24EugsuB6nfi6B" +
           "Xn8rakB5aJ4Dyl9PoMunKcH8+e9xuhvAjTs6kJnbwXGSjwHpgCQbPh8cuqDz" +
           "ag6KECewFC4yTvtzdeYkkhzFypWfFCvHwOfJE6iRn40fZvhiezp+XfvcCxT7" +
           "npfrn9qeYmiOstlkUi7Q0J3bA5UjlHj8ttIOZZ0nn/rRPZ+/602HcHbPdsG7" +
           "3D22tkdvfXaAuUGSd/s3f/TAH7ztt1/4Zt4V/F+p+kjNtCAAAA==");
    }
    public static class InCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        InCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                    java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcM =
                      (dstInPixels[dstInSp++] >>>
                         24) *
                        norm;
                    srcP =
                      srcPixels[srcSp++];
                    dstOutPixels[dstOutSp++] =
                      (srcP >>>
                         24) *
                        srcM +
                        pt5 &
                        -16777216 |
                        ((srcP >>
                            16 &
                            255) *
                           srcM +
                           pt5 &
                           -16777216) >>>
                        8 |
                        ((srcP >>
                            8 &
                            255) *
                           srcM +
                           pt5 &
                           -16777216) >>>
                        16 |
                        (srcP &
                           255) *
                        srcM +
                        pt5 >>>
                        24;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "koXD6yvskQ4/+S+eYxW6IxsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static class OutCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        OutCompositeContext(java.awt.image.ColorModel srcCM,
                            java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int sp =
                  0;
                int end =
                  w *
                  4;
                while (sp <
                         end) {
                    final int srcM =
                      (255 -
                         dstPix[sp +
                                  3]) *
                      norm;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        pt5 >>>
                        24;
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
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
          ("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");
    }
    public static class OutCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        OutCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                     java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcM =
                      (255 -
                         (dstInPixels[dstInSp++] >>>
                            24)) *
                        norm;
                    srcP =
                      srcPixels[srcSp++];
                    dstOutPixels[dstOutSp++] =
                      (srcP >>>
                         24) *
                        srcM +
                        pt5 &
                        -16777216 |
                        ((srcP >>
                            16 &
                            255) *
                           srcM +
                           pt5 &
                           -16777216) >>>
                        8 |
                        ((srcP >>
                            8 &
                            255) *
                           srcM +
                           pt5 &
                           -16777216) >>>
                        16 |
                        (srcP &
                           255) *
                        srcM +
                        pt5 >>>
                        24;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "xqJPcur4+gp7pMNP/gsmwuMDJRsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1ae+zseFXv/e3du3eX3b13F1iWlX2xF8xS/HVmOs8sIJ1O" +
           "2+n0OZ2281C5dNrOTGf6mr5nYOWRKCgJoC6ICWyiAUVclocSNQazxigQCAmE" +
           "+EoENCaiSAJ/iERU/Lbze997d7MhOsl8p+33nPM953zP9/M9/Z556jvQzWEA" +
           "wb5nb+a2F+2bWbS/tGv70cY3w/0eWxO1IDQN3NbCUAbPruov/+Sl7//wvYvL" +
           "e9CFCfRCzXW9SIsszw0lM/TsxDRY6NLxU8I2nTCCLrNLLdGQOLJshLXC6DEW" +
           "esEJ1gi6wh6qgAAVEKACUqiAYMdUgOkO040dPOfQ3ChcQz8PnWOhC76eqxdB" +
           "D58W4muB5hyIEQsLgISL+b0KjCqYswB66Mj2nc3XGPw+GHni199w+dM3QZcm" +
           "0CXLHeTq6ECJCAwygW53TGdqBiFmGKYxge5yTdMYmIGl2da20HsC3R1ac1eL" +
           "4sA8clL+MPbNoBjz2HO367ltQaxHXnBk3swybePw7uaZrc2Brfcc27qzkMyf" +
           "AwNvs4BiwUzTzUOW8yvLNSLowbMcRzZeYQABYL3FMaOFdzTUeVcDD6C7d3Nn" +
           "a+4cGUSB5c4B6c1eDEaJoPtuKDT3ta/pK21uXo2ge8/SibsuQHVr4YicJYJe" +
           "fJaskARm6b4zs3Rifr7Dv+bdb3K77l6hs2Hqdq7/RcD0wBkmyZyZgenq5o7x" +
           "9lex79fu+ew79yAIEL/4DPGO5g/f/L3Xv/qBZz6/o/mJ69AI06WpR1f1D0/v" +
           "/MrL8EdbN+VqXPS90Mon/5TlRfiLBz2PZT5YefccScw79w87n5H+cvzWj5nf" +
           "3oNuo6ELumfHDoiju3TP8S3bDCjTNQMtMg0autV0Dbzop6FbwDVruebuqTCb" +
           "hWZEQ+ft4tEFr7gHLpoBEbmLbgHXljvzDq99LVoU15kPQdDd4Au9BIL2fh8q" +
           "PrvfCHoDsvAcE9F0zbVcDxEDL7c/REw3mgLfLpApiPoVEnpxAEIQ8YI5ooE4" +
           "WJgHHfnK1NIIsRww/chApXBgVG62uZ/Hmf9/PkKW23g5PXcOuP9lZxe/DdZN" +
           "17MNM7iqPxG3ie89ffWLe0eL4cA7EdQFg+7vBt0vBi2AEwy6Xwy6f3LQK0Ic" +
           "Hd0cwMZVmpevihjOQOfOFYq8KNdsFwNgBlcACwBK3v7o4Od6b3zny28Cween" +
           "54H7c1LkxmCNH6MHXWCkDkIYeuYD6dvUt5T2oL3TqJtbAx7dlrOLOVYeYeKV" +
           "s6vtenIvveNb3//E+x/3jtfdKRg/gINrOfPl/PKzfg883TQAQB6Lf9VD2meu" +
           "fvbxK3vQeYARABcjDcQxgJwHzo5xalk/dgiRuS03A4NnXuBodt51iGu3RYvA" +
           "S4+fFAFxZ3F9F/DxxTzOr4CA/8xB4Be/ee8L/bx90S6A8kk7Y0UBwa8d+B/6" +
           "my//C1q4+xCtL53Y/wZm9NgJhMiFXSqw4K7jGJAD0wR0f/8B8dfe9513/EwR" +
           "AIDikesNeCVv8wADUwjc/AufX//tN77+4a/tHQUNlJ227eKz2AYGeeWxGgBY" +
           "bLD08mC5oriOZ1gzS5vaZh6c/3XpFeXP/Nu7L++m3wZPDqPn1c8t4Pj5S9vQ" +
           "W7/4hv94oBBzTs83tmNXHZPt0PKFx5KxINA2uR7Z2756/298TvsQwF2AdaG1" +
           "NQv42itM3yssf3EEvbTgPF6gQLIXcJ5hFpsFUkzpfkH8aNH+VO6XA+/l95W8" +
           "eTA8uTROr74TecpV/b1f++4d6nf/9HuFUacTnZORwGn+Y7vgy5uHMiD+JWdx" +
           "oKuFC0BXfYb/2cv2Mz8EEidAog6ALxQCAFPZqbg5oL75lr/7sz+/541fuQna" +
           "I6HbbE8zSK1YgtCtIPbNcAEQLvN/+vW7IEjzqLhcmApdY/wudu4t7m4CCj56" +
           "Y/Qh8zzleAHf+5+CPX37P/7gGicUuHOd7fkM/wR56oP34a/7dsF/DAA59wPZ" +
           "tdANcrpj3srHnH/fe/mFv9iDbplAl/WDhFHV7DhfVhOQJIWHWSRIKk/1n054" +
           "drv7Y0cA97Kz4HNi2LPQc7xlgOucOr++7STa/Ah8zoHv/+Tf3N35g902ezd+" +
           "sNc/dLTZ+3527lwE3VzZb+yXcv7XF1IeLtorefOTu2mKQEocT20LrKYLYZGt" +
           "Aq6Z5Wp2MTgWgTCz9SuHI6ggewXzcmVpNw6Xy+UipHIP7O9Svh3k5S1aiNiF" +
           "Rf2GIfTYjqrY2+48FsZ6IHt81z+990vveeQbYF570M1J7nMwnSdG5OM8of7F" +
           "p953/wue+Oa7ChwDO5/6S59Cf5BL5W9gdX5J5g2VN91DU+/LTR0UuQKrhRFX" +
           "YJBpFNY+aziLgeUAhE4OskXk8bu/sfrgtz6+ywTPxu4ZYvOdT/zyj/bf/cTe" +
           "ifz7kWtS4JM8uxy8UPqOAw8H0MPPNkrBQf7zJx7/k48+/o6dVnefziYJ8LL0" +
           "8b/67y/tf+CbX7hOEnPe9n6MiY3u/Gi3GtLY4YdVx3glVbLMMYUsWbaq8cg0" +
           "LGwmdbI6We55eGnjTwmDSjMXrg56vrHEwqmO1spxM2ok4TayXX/bFxmd4Umi" +
           "79HTPmOvvfpiQJuKGiiSVfI1dTBgKGdF8F5p2e+1JLwUSX1VlbVkwCdld5LM" +
           "KvpQX65DbVBDJy6C2C6SIAgSmXrskQ7V8dcp5vVWNsFTTbKyUPoEqncy3l6l" +
           "S6GUktlwxkodOI4jrYV6CBP7XVtx2/U2TWKoQQ/p6hTRFqYyTy0GpyvxkhJK" +
           "mSJ1pWjczTTax4OWRtdWBjMuDSXaLq1HFDcYeQTST9cLgi5p6tiJ28IqJdut" +
           "IVEdjC2jx8sWYqS6FA+ttYdqta4iNJfTLllaT8JE3+CMJzQyilqouDbo0h7b" +
           "dlaCJizVibdepg2GmbtWB3PjlWFOmGg+GPnmch6OR+tlHZ7J7clW7aeDMqbY" +
           "cidbUuhYEdRFF4OXjBtXRvrYH2+QOm55tLelu5xCtUNW9fHOmE81bRh1xqrL" +
           "VnEGthWnGRC0pLn0qrJqb3reehL3evEC3zh9eTzUqU44IuxeKWo7zmjCjGwl" +
           "1miY26xLAuka5SEypPE1bFOqL8qDanWR4hgzbdE8rg/WlKFxdjecZTN7sJyz" +
           "ZCMcVHvhUnKGQTBcYWN1rsltpDfR6pSkpdtgWmqN1UqbXJVanKXMhqGJrShG" +
           "5CNpRQ/bq+4wnmrhiKMFYd7E7ZWfcp3SAhMaXG+sdlYL2tVYEpXUKZWS4/mc" +
           "UbZKbb4qm9lwMfYwom4N+6X+0ObIPltqi1RfHlADD1Nww0snErfWquW+lA7a" +
           "LqXQUa9DwtRszqwJZkzH9NAS7GqWYSAtaZLL3njSnKJSKIhMFqrJlm5XTGFc" +
           "ppzaBu5I/YopGVGKxeEYobGEJZsT0WI5UUZiKbXoGmrRgo6iCboNkEjhyXLD" +
           "5bFkWxJlouXgksSNekNBaVgtfxjg8DzbLIcqIViZa/S2QRqO3Zq/deb9sTlx" +
           "BIMR+2ayXAxLoy4alHpsI5bqQ2NNLJTaqM/oZH+5tmx+FVAwPojGZGoJRp0e" +
           "BJw8rYiGwLcFM60xODzMRNoh5yVvxUzkieqzPVQhCXxIYqqtM1sfl5R6eSUP" +
           "enRrsh0QCo42PXRFw1OYrbQRpDdcjBjGcXRi3m8r6qBMtgm17jal+dyS51nJ" +
           "SbckJqodWuH5etpprxhPXMxlrC8x02594eIWt+oxIwxhumayKkd0u69Sqe5v" +
           "A0mcjXXOHnWHFtfs1m1kZYyqE4TStkxoZt2FIvrlZDqtVXpJ6LSlCdouY7W2" +
           "U+nKNN8sbToT25PoSmfa4+fNGo9ty/7KLWVpSSuFaNTgeXYQLUa1mZDOQ9jt" +
           "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" +
           "GH5BQfCC4l45EQfjCLrJcotz8BR49xU39m5xer07Knrytx/58luefOQfipPd" +
           "i1aoagEWzK9T8jzB892nvvHtr95x/9NFbeQ8eNvdmX+2VnxtKfhUhbew7fYj" +
           "b90O7Vx2nt95a/cbQfqPWY7TfD9EwmQ+Dbw0NAOE9wxTtPSVGYiaa9qHVb//" +
           "j2Gy3dQczuO5g4VwdK71eHYOKiLjbc+1eI+A4oJtuvNd3TTNmzf72ZH8MzWI" +
           "Fx4fceK255p5IeSwb1f/s7z9o78OgM7supq6O02LwZ536J6sabznWfp+JW/e" +
           "FUE367mmO8OehfyJDDrywM4NN7wt6JNnkfX+vFkDd/mBqRd1U/OoXHq9JXc+" +
           "8SzjGJOD5zrBPFXdiKCXPVt59nB64OdR7wUr/95r/lOy+x+E/vSTly6+5Enl" +
           "r3cL9/C/Crey0MVZbNsn6wUnri8AR8yswje37qoHfvHzWxH0wLPrBeav+C3M" +
           "+M0d10ci6N4bcQH8Au1J6o+C0LweNaAE7UnK34ugy2cpwfjF70m6pyPotmM6" +
           "sIB2FydJPgWkA5L88tP+4RRwz6fkjtn+QhMD84YTm507vaUehc/dzxU+J3bh" +
           "R04BfPF3o8OtLt794eiq/okne/ybvlf/yK4crNvadptLuQiweFeZPtouH76h" +
           "tENZF7qP/vDOT976isN9/c6dwseb2AndHrx+EZZw/Kgom27/6CV/8JrfefLr" +
           "RXnlfwFor2DGByYAAA==");
    }
    public static class AtopCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        AtopCompositeContext(java.awt.image.ColorModel srcCM,
                             java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int sp =
                  0;
                int end =
                  w *
                  4;
                while (sp <
                         end) {
                    final int srcM =
                      dstPix[sp +
                               3] *
                      norm;
                    final int dstM =
                      (255 -
                         srcPix[sp +
                                  3]) *
                      norm;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        dstPix[sp] *
                        dstM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        dstPix[sp] *
                        dstM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        dstPix[sp] *
                        dstM +
                        pt5 >>>
                        24;
                    sp +=
                      2;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
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
          ("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");
    }
    public static class AtopCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        AtopCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                      java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcM;
            int dstP;
            int dstM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    srcM =
                      (dstP >>>
                         24) *
                        norm;
                    dstM =
                      (255 -
                         (srcP >>>
                            24)) *
                        norm;
                    dstOutPixels[dstOutSp++] =
                      dstP &
                        -16777216 |
                        ((srcP >>
                            16 &
                            255) *
                           srcM +
                           (dstP >>
                              16 &
                              255) *
                           dstM +
                           pt5 &
                           -16777216) >>>
                        8 |
                        ((srcP >>
                            8 &
                            255) *
                           srcM +
                           (dstP >>
                              8 &
                              255) *
                           dstM +
                           pt5 &
                           -16777216) >>>
                        16 |
                        (srcP &
                           255) *
                        srcM +
                        (dstP &
                           255) *
                        dstM +
                        pt5 >>>
                        24;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVYC2wUxxmeOz/w+8XLPGzANkQ8eleSkBaZ0tiODYazfcLE" +
           "Umzg2Nubu1u8t7vsztlnpzQPKcKJFEQoIbQKlqo6hSIeUdSordqkpFFJoqSR" +
           "QmjTNAr0EbW0FBVUNa1KW/rPzO7t485GVI0lz+3O/vPP/K/v//85dQ0VGTpq" +
           "xAoJkDENG4FOhYQF3cCxDlkwjO0wFxGfKxD+uutK73o/Kh5EVUnB6BEFA3dJ" +
           "WI4Zg6hBUgwiKCI2ejGO0RVhHRtYHxGIpCqDaK5kdKc0WRIl0qPGMCUYEPQQ" +
           "qhUI0aVomuBukwFBDSE4SZCdJNjm/dwaQhWiqo3Z5PUO8g7HF0qZsvcyCKoJ" +
           "7RFGhGCaSHIwJBmkNaOj1ZoqjyVklQRwhgT2yOtMFWwJrctRQdOL1Z/ePJis" +
           "YSqYLSiKSph4xjZsqPIIjoVQtT3bKeOUsRd9FRWEULmDmKCWkLVpEDYNwqaW" +
           "tDYVnL4SK+lUh8rEIRanYk2kByJomZuJJuhCymQTZmcGDiXElJ0tBmmXZqXl" +
           "UuaI+Ozq4OHndtW8VICqB1G1pPTT44hwCAKbDIJCcSqKdaMtFsOxQVSrgLH7" +
           "sS4JsjRuWrrOkBKKQNJgfkstdDKtYZ3taesK7Aiy6WmRqHpWvDhzKPOtKC4L" +
           "CZB1ni0rl7CLzoOAZRIcTI8L4HfmksJhSYkRtMS7Iitjy1YggKWzUpgk1exW" +
           "hYoAE6iOu4gsKIlgP7iekgDSIhUcUCdo4bRMqa41QRwWEjhCPdJDF+afgKqU" +
           "KYIuIWiul4xxAist9FjJYZ9rvRsOPKxsVvzIB2eOYVGm5y+HRY2eRdtwHOsY" +
           "4oAvrFgVOiLMe2XCjxAQz/UQc5rvfeXG/Wsaz73JaRbloemL7sEiiYhT0ar3" +
           "FnesXF9Aj1GiqYZEje+SnEVZ2PzSmtEAYeZlOdKPAevjuW3nH3r0JL7qR2Xd" +
           "qFhU5XQK/KhWVFOaJGN9E1awLhAc60alWIl1sO/daBY8hyQF89m+eNzApBsV" +
           "ymyqWGXvoKI4sKAqKoNnSYmr1rMmkCR7zmgIoTr4R/MR8t9C7I//ErQrmFRT" +
           "OCiIgiIpajCsq1R+IwiIEwXdJoNR8PrhoKGmdXDBoKonggL4QRKbH2hkCqMk" +
           "KKXA/MH+gU0dIBQVGweon2mf+Q4ZKuPsUZ8P1L/YG/wyxM1mVY5hPSIeTrd3" +
           "3jgTeZs7Fg0GUzsEdcOmAb5pgG3KoBI2DbBNA85NW9qIqmXfTNyIdPduj4Tb" +
           "OrYin4+dZA49GncCMOEwgAGgccXK/p1bdk80FYD3aaOFoH9K2uTKSh02Ylgw" +
           "HxHP1lWOL7u09nU/KgyhOkEkaUGmSaZNTwB8icNmhFdEIV/ZaWOpI23QfKer" +
           "Io4Bak2XPkwuJeoI1uk8QXMcHKykRsM3OH1KyXt+dO7o6GMDj3zej/zuTEG3" +
           "LAKQo8vDFN+zON7iRYh8fKv3X/n07JF9qo0VrtRjZcyclVSGJq+veNUTEVct" +
           "FV6OvLKvham9FLCcCBB7AJON3j1cUNRqwTqVpQQEjqt6SpDpJ0vHZSSpq6P2" +
           "DHPiWvY8B9yihMbmcoQKfDxY+S/9Ok+j43zu9NTPPFKwtPGlfu3YL9/94z1M" +
           "3VaGqXaUBv2YtDpQjTKrY/hVa7vtdh1joPv4aPhrz17bP8R8Fiia823YQkca" +
           "E2BCUPMTb+798PKlqYv+rJ+jjFu2khlkg01W2McAMJQBLqiztDyogFtKcUmI" +
           "ypjG07+ql699+c8Harj5ZZixvGfN7RnY8wva0aNv7/p7I2PjE2kytlVlk3GE" +
           "n21zbtN1YYyeI/PYhYavvyEcg1wB+GxI45hBrp+J7meS1xO0gK20QQU4qzqN" +
           "Kpbg1jGT3suIg2y8h+rF1B59/yIdlhvO0HBHn6O2iogHL16vHLj+6g0mlLs4" +
           "c3pCj6C1cuejw4oMsJ/vha7NgpEEunvP9e6okc/dBI6DwFEEsDb6dIDWjMtv" +
           "TOqiWb967fV5u98rQP4uVCarQqxLYCGISsH3sZEEVM5oX76fO8Eo9YoaJirK" +
           "ET5ngtphSX4Ld6Y0wmwy/v35391wfPIS80GN81jkZHgXG1fR4XPcUARKz3QU" +
           "Knh4MFhVaHstW1jrTZ9Or3VtoKOG6SocVp1NPX54Mtb3wlpeh9S5q4ZOKIpP" +
           "/+Lf7wSO/vqtPMmq2KxQ7Q1pFmlwZZEeVvnZSPZx1aHf/aAl0X4nCYTONd4m" +
           "RdD3JSDBqukTgvcobzz+p4XbNyZ330EuWOLRpZfld3pOvbVphXjIz8pcngZy" +
           "ymP3olanVmFTHUM9r1Ax6UwlC4nmrPWrqVV7AKtKTcwqyo/Hef3KRx+7PABY" +
           "ZTHJw8yDAeWMS7m7UqDG609HDcjqUgpAfMQsgu8O7xYnWsKfcMdakGcBp5t7" +
           "Ivj0wAd73mFWKKFmz8ruMDm4hyM/1XARbsGfD/7/Q//p0ekELybrOsyKdmm2" +
           "pKWxp6OVM/SgbgGC++ouDz9/5TQXwFvye4jxxOGnbgUOHOZRwvui5pzWxLmG" +
           "90ZcHDrspKdbNtMubEXXH87u++GJffv9JhZvJahAMltWaiNfNg7nuFXOz/nA" +
           "k9U/OlhX0AXh141K0oq0N427Y24XnGWkow4b2G2U7ZDmiam+CfKtAtXSiR3u" +
           "m42soVl64vvvKD//Y+Nbv3+JKzWfG3l6qRPHS8SPUuc/seQdynpvlQmEyERu" +
           "/kvQ0P+pyk9gNQXdJElC6ZkgSauJ+CzZUxdYPr2DOvQ4+e3mdx+ZbP4NS4El" +
           "kgGQCCGSp591rLl+6vLVC5UNZxj0FtJIMy3svgjI7fNd7TuzQjUdUqbRc11v" +
           "sSsFsHsrGyNPvv+Fnx9/5sgod4EZ4tGzrv6ffXL08d/+I6eOYHCdJ0Q96weD" +
           "p55f2LHxKltv19B0dUsmt2MDjdpr7z6Z+pu/qfinfjRrENWI5j3RgCCnaWU6" +
           "CDozrMujEKp0fXffc/CmvjWbHBZ7McKxrbd6d8ZoIXHFYy23hw8x3B6fpqxg" +
           "8E+AqaQIMlu3E5K4zPyPvkXpoGt2meOpG3nFSeWAIkJVMC1erW+8zZTUQPaK" +
           "Cj5mcnyDvvfZzsPz+F10GGDnmaHqnJjh21N0eAJEE+m5uBgzkD+dW8jRiXbN" +
           "UfP57JSZ5I6eHeRpXxnhQzPs/Awd+kGVmo5F1rrjbMfOFkTMXEB/oPwrHFEl" +
           "Hnjr6bCdf9jwP1arppAENcx4dWDZdPUdXEZA1NfnXHjySzrxzGR1yfzJBz/g" +
           "wGNdpFVAuo+nZdnp1Y7nYtBQXGJKq+A+zpPMJDS9M58L3ID9MjGO8VXfJKh+" +
           "ulWQQWF0Uk+BP+ejBkoYnZTHCarxUsL+7NdJd5KgMpsOoo4/OElOA3cgoY9n" +
           "NMsEPXd0HyRrSSGs42kNm/Hldh/Mr+bezq8c/USzC7HZXbiVw9P8Njwinp3c" +
           "0vvwjfte4H2/KAvj45RLOeQSfgWRraiXTcvN4lW8eeXNqhdLl1sVQC0/sF3n" +
           "LnLEVzuErEa7soWe7thoyTbJH05tePVnE8UXIBEMIZ8AwTiUi9AZLQ2tzFAo" +
           "t4gChGZte+vKb4xtXBP/y0esscvNfF76iHjx+M73D9VPQXtf3g0+qsRwhqWO" +
           "B8aUbVgc0QdRpWR0ZuCIwAVA1FWhVdG4EegtOdOLqc7K7Cy9NSKoKbfmzL1r" +
           "gyZ4FOvtalqJmRVAuT3juqQ3Y7EsrWmeBfaMoyxIcPDidVhBJNSjaVZJXnqf" +
           "xuAnOT3AvsYe6fCT/wLbcA45JxsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "CSYAAA==");
    }
    public static class XorCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        XorCompositeContext(java.awt.image.ColorModel srcCM,
                            java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int sp =
                  0;
                int end =
                  w *
                  4;
                while (sp <
                         end) {
                    final int srcM =
                      (255 -
                         dstPix[sp +
                                  3]) *
                      norm;
                    final int dstM =
                      (255 -
                         srcPix[sp +
                                  3]) *
                      norm;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        dstPix[sp] *
                        dstM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        dstPix[sp] *
                        dstM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        dstPix[sp] *
                        dstM +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] *
                        srcM +
                        dstPix[sp] *
                        dstM +
                        pt5 >>>
                        24;
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
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
          ("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");
    }
    public static class XorCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        XorCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                     java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcM;
            int dstP;
            int dstM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    srcM =
                      (255 -
                         (dstP >>>
                            24)) *
                        norm;
                    dstM =
                      (255 -
                         (srcP >>>
                            24)) *
                        norm;
                    dstOutPixels[dstOutSp++] =
                      (srcP >>>
                         24) *
                        srcM +
                        (dstP >>>
                           24) *
                        dstM +
                        pt5 &
                        -16777216 |
                        ((srcP >>
                            16 &
                            255) *
                           srcM +
                           (dstP >>
                              16 &
                              255) *
                           dstM +
                           pt5 &
                           -16777216) >>>
                        8 |
                        ((srcP >>
                            8 &
                            255) *
                           srcM +
                           (dstP >>
                              8 &
                              255) *
                           dstM +
                           pt5 &
                           -16777216) >>>
                        16 |
                        (srcP &
                           255) *
                        srcM +
                        (dstP &
                           255) *
                        dstM +
                        pt5 >>>
                        24;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVYC2wUxxmeOxvjB37yMg8bsA8iHr0rSWiDTGlsxwbD2T5h" +
           "YiU2cOztzd0t3ttddufss1OahxThRAoilBBaBUtVnUIRjyhq1FZtUtKoJFHS" +
           "SCG0aRoF+ohaWooKqppWpW36z8zu7ePORlSNJc/tzv7zz/z///2vOXUNzTB0" +
           "1IgVEiSjGjaCHQqJCLqB4+2yYBjbYS4qPlsk/HXXlZ71flQygKpSgtEtCgbu" +
           "lLAcNwZQg6QYRFBEbPRgHKcrIjo2sD4sEElVBtBcyehKa7IkSqRbjWNK0C/o" +
           "YVQrEKJLsQzBXSYDghrCcJIQO0mo1fu5JYxmiao2apPXO8jbHV8oZdreyyCo" +
           "JrxHGBZCGSLJobBkkJasjlZrqjyalFUSxFkS3COvM1WwJbwuTwVNL1R/cvNg" +
           "qoapYLagKCph4hnbsKHKwzgeRtX2bIeM08Ze9FVUFEYVDmKCAmFr0xBsGoJN" +
           "LWltKjh9JVYy6XaViUMsTiWaSA9E0DI3E03QhbTJJsLODBxKiSk7WwzSLs1J" +
           "y6XME/GZ1aHDz+6qebEIVQ+gaknpo8cR4RAENhkAheJ0DOtGazyO4wOoVgFj" +
           "92FdEmRpzLR0nSElFYFkwPyWWuhkRsM629PWFdgRZNMzIlH1nHgJBijzbUZC" +
           "FpIg6zxbVi5hJ50HAcslOJieEAB35pLiIUmJE7TEuyInY2ArEMDSmWlMUmpu" +
           "q2JFgAlUxyEiC0oy1AfQU5JAOkMFAOoELZySKdW1JohDQhJHKSI9dBH+CajK" +
           "mCLoEoLmeskYJ7DSQo+VHPa51rPhwEPKZsWPfHDmOBZlev4KWNToWbQNJ7CO" +
           "wQ/4wlmrwkeEeS+P+xEC4rkeYk7zva/cuHdN47k3OM2iAjS9sT1YJFFxMlb1" +
           "7uL2leuL6DFKNdWQqPFdkjMvi5hfWrIaRJh5OY70Y9D6eG7b+QcfOYmv+lF5" +
           "FyoRVTmTBhzVimpak2Ssb8IK1gWC412oDCvxdva9C82E57CkYD7bm0gYmHSh" +
           "YplNlajsHVSUABZUReXwLCkJ1XrWBJJiz1kNIVQH/2g+QkX9iP3xX4J2hVJq" +
           "GocEUVAkRQ1FdJXKb4Qg4sRAt6lQDFA/FDLUjA4QDKl6MiQADlLY/EA9Uxgh" +
           "ISkN5g/19W9qB6Go2DhIcaZ95jtkqYyzR3w+UP9ir/PL4DebVTmO9ah4ONPW" +
           "ceNM9C0OLOoMpnYI2gybBvmmQbYpC5WwaZBtGnRuGnhA1XMvZtiIdvVsj0Za" +
           "27cin48dZA49GccAWHAIYgEE41kr+3Zu2T3eVATg00aKQf2UtMmVlNrtgGFF" +
           "+ah4tq5ybNmlta/5UXEY1QkiyQgyzTGtehKilzhkOvisGKQrO2ssdWQNmu50" +
           "VcRxCFpTZQ+TS6k6jHU6T9AcBwcrp1HvDU2dUQqeH507OvJo/8Of9yO/O1HQ" +
           "LWdAjKPLIzS858J4wBsgCvGt3n/lk7NH9ql2qHBlHith5q2kMjR5oeJVT1Rc" +
           "tVR4KfryvgBTexmEciKA60GUbPTu4YpELVZUp7KUgsAJVU8LMv1k6bicpHR1" +
           "xJ5hGK5lz3MAFqXUNQPgow+Yvsp+6dd5Gh3nc8xTnHmkYFnjS33asV++88e7" +
           "mLqtBFPtqAz6MGlxBDXKrI6Fr1obttt1jIHuo6ORrz1zbf8gwyxQNBfaMEBH" +
           "6hNgQlDz42/s/eDypcmL/hzOUdYtW+k0ssEmK+xjQCyUIVpQsATuVwCWUkIS" +
           "YjKm/vSv6uVrX/rzgRpufhlmLPSsuTUDe35BG3rkrV1/b2RsfCLNxbaqbDIe" +
           "4GfbnFt1XRil58g+eqHh668LxyBVQHg2pDHMIq6fie5nktcTtICttGMKcFZ1" +
           "6lUsv61jJr2bEYfYeBfVi6k9+n4PHZYbTtdwe5+jtIqKBy9er+y//soNJpS7" +
           "NnMioVvQWjj46LAiC+zne0PXZsFIAd3d53p21MjnbgLHAeAoQqw2enWIrFkX" +
           "bkzqGTN/9epr83a/W4T8nahcVoV4p8BcEJUB9rGRgqCc1b58LwfBCEVFDRMV" +
           "5QmfN0HtsKSwhTvSGmE2Gfv+/O9uOD5xiWFQ4zwWORnewcZVdPgcNxSByjMT" +
           "gwIeHgxWFNqoZQtrvdnTiVrXBjpqmKrAYcXZ5GOHJ+K9z6/lZUidu2jogJr4" +
           "9C/+/Xbw6K/fLJCrSswC1d6QZpEGVxbpZoWfHck+qjr0ux8Ekm23k0DoXOMt" +
           "UgR9XwISrJo6IXiP8vpjf1q4fWNq923kgiUeXXpZfqf71JubVoiH/KzK5Wkg" +
           "rzp2L2pxahU21TGU8woVk85UMpdozlm/mlq1G6y+27T+jsLxuCCufPSx0xMA" +
           "qywmBZh5YkAF41LhrhSo8foyMQOyupSGID5s1sB3RnaL44HIxxxYCwos4HRz" +
           "T4Se6n9/z9vMCqXU7DnZHSYHeDjyUw0X4VP488H/f+g/PTqd4LVkXbtZ0C7N" +
           "VbTU93S0cpoW1C1AaF/d5aHnrpzmAngrfg8xHj/85KfBA4e5l/C2qDmvM3Gu" +
           "4a0RF4cOO+nplk23C1vR+Yez+354Yt9+vxmLtxJUJJkdK7WRL+eHc9wq5+e8" +
           "74nqHx2sK+oE9+tCpRlF2pvBXXE3BGcamZjDBnYXZQPSPDHVN0G+VaBaOrHD" +
           "fbGRMzRLT3z/HRXnf2x86/cvcqUWgpGnlTpxvFT8MH3+Y0vewRx6q8xAiMzI" +
           "zX8JGvw/FflJrKahmSQpKD2TJGX1EJ8lewqB5VMD1KHHiW83v/PwRPNvWAos" +
           "lQwIieAiBdpZx5rrpy5fvVDZcIaF3mLqaaaF3fcA+W2+q3tnVqimQ9o0ej70" +
           "FrtSALu2smPkyfe++PPjTx8Z4RCYxh896+r/2SvHHvvtP/LqCBauC7ioZ/1A" +
           "6NRzC9s3XmXr7Rqarg5k8xs20Ki99s6T6b/5m0p+6kczB1CNaF4T9Qtyhlam" +
           "A6Azw7o7CqNK13f3NQfv6VtyyWGxN0Y4tvVW704fLSYuf6zl9vAhFrfHpigr" +
           "WPgnwFRSBJmt2wlJXGb4o28xOuiaXeZ46kZecVI5oIhQFUyLV+sbbzMlNZi7" +
           "oYKP2Txs0PdeGzw8j99Bh352nmmqzvFpvj1Jh8dBNJGei4sxDflT+YUcnWjT" +
           "HDWfz06ZKQ703CBP+coIH5xm56fp0Aeq1HQsstYd5zp2tiBq5gL6A+Vf8bAq" +
           "ccdbT4ft/MOG/7FaNYUE2E13c2CZdPVtXEWA09fnXXfyKzrxzER16fyJ+9/n" +
           "cce6RpsF2T6RkWUnqB3PJaCghMR0NotDnOeYCeh5pz8XoID9MjGO8VXfJKh+" +
           "qlWQQGF0Uk8CnAtRAyWMTsrjBNV4KWF/9uukO0lQuU0HTscfnCSngTuQ0Mcz" +
           "mmWC7tu5DWqVtZQQ0fGUhs368psPBqu5t4KVo51odgVsdhNupfAMvwuPimcn" +
           "tvQ8dOMLz/O2X5SFsTHKpQJSCb+ByBXUy6bkZvEq2bzyZtULZcutAqCWH9gu" +
           "cxc53KsNPFajTdlCT3NsBHI98geTG1752XjJBcgDg8gngC8O5gforJaBTmYw" +
           "nF9DQYBmXXvLym+MblyT+MuHrK/LT3xe+qh48fjO9w7VT0J3X9EFGFXiOMsy" +
           "x32jyjYsDusDqFIyOrJwROACMdRVoFVRvxHoHTnTi6nOytwsvTQiqCm/5My/" +
           "aoMeeATrbWpGiZsFQIU947qiN32xPKNpngX2jKMqSPLYxcuwomi4W9Osirzs" +
           "Ho1Fn9TU8fVV9kiHn/wXXjx99CUbAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AA==");
    }
    public static class ArithCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        float k1;
        float k2;
        float k3;
        float k4;
        ArithCompositeContext(java.awt.image.ColorModel srcCM,
                              java.awt.image.ColorModel dstCM,
                              float k1,
                              float k2,
                              float k3,
                              float k4) {
            super(
              srcCM,
              dstCM);
            this.
              k1 =
              k1;
            this.
              k2 =
              k2;
            this.
              k3 =
              k3;
            this.
              k4 =
              k4;
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int bands =
              dstOut.
              getNumBands(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            float kk1 =
              k1 /
              255.0F;
            float kk4 =
              k4 *
              255.0F +
              0.5F;
            int y;
            int i;
            int b;
            int val;
            int max;
            for (y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                for (i =
                       0;
                     i <
                       srcPix.
                         length;
                     i++) {
                    max =
                      0;
                    for (b =
                           1;
                         b <
                           bands;
                         b++,
                           i++) {
                        val =
                          (int)
                            (kk1 *
                               srcPix[i] *
                               dstPix[i] +
                               k2 *
                               srcPix[i] +
                               k3 *
                               dstPix[i] +
                               kk4);
                        if ((val &
                               -256) !=
                              0)
                            if ((val &
                                   -2147483648) !=
                                  0)
                                val =
                                  0;
                            else
                                val =
                                  255;
                        if (val >
                              max)
                            max =
                              val;
                        dstPix[i] =
                          val;
                    }
                    val =
                      (int)
                        (kk1 *
                           srcPix[i] *
                           dstPix[i] +
                           k2 *
                           srcPix[i] +
                           k3 *
                           dstPix[i] +
                           kk4);
                    if ((val &
                           -256) !=
                          0)
                        if ((val &
                               -2147483648) !=
                              0)
                            val =
                              0;
                        else
                            val =
                              255;
                    if (val >
                          max)
                        dstPix[i] =
                          val;
                    else
                        dstPix[i] =
                          max;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "37LL8/8Hc079GsQZAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ym/x0j+6+w/e/PHnvp6fVv4vBFX0Oo8kAAA=");
    }
    public static class ArithCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        float k1;
        float k2;
        float k3;
        float k4;
        ArithCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                       java.awt.image.ColorModel dstCM,
                                       float k1,
                                       float k2,
                                       float k3,
                                       float k4) {
            super(
              srcCM,
              dstCM);
            this.
              k1 =
              k1 /
                255.0F;
            this.
              k2 =
              k2;
            this.
              k3 =
              k3;
            this.
              k4 =
              k4 *
                255.0F +
                0.5F;
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            int srcP;
            int dstP;
            int a;
            int r;
            int g;
            int b;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    a =
                      (int)
                        ((srcP >>>
                            24) *
                           (dstP >>>
                              24) *
                           k1 +
                           (srcP >>>
                              24) *
                           k2 +
                           (dstP >>>
                              24) *
                           k3 +
                           k4);
                    if ((a &
                           -256) !=
                          0)
                        if ((a &
                               -2147483648) !=
                              0)
                            a =
                              0;
                        else
                            a =
                              255;
                    r =
                      (int)
                        ((srcP >>
                            16 &
                            255) *
                           (dstP >>
                              16 &
                              255) *
                           k1 +
                           (srcP >>
                              16 &
                              255) *
                           k2 +
                           (dstP >>
                              16 &
                              255) *
                           k3 +
                           k4);
                    if ((r &
                           -256) !=
                          0)
                        if ((r &
                               -2147483648) !=
                              0)
                            r =
                              0;
                        else
                            r =
                              255;
                    if (a <
                          r)
                        a =
                          r;
                    g =
                      (int)
                        ((srcP >>
                            8 &
                            255) *
                           (dstP >>
                              8 &
                              255) *
                           k1 +
                           (srcP >>
                              8 &
                              255) *
                           k2 +
                           (dstP >>
                              8 &
                              255) *
                           k3 +
                           k4);
                    if ((g &
                           -256) !=
                          0)
                        if ((g &
                               -2147483648) !=
                              0)
                            g =
                              0;
                        else
                            g =
                              255;
                    if (a <
                          g)
                        a =
                          g;
                    b =
                      (int)
                        ((srcP &
                            255) *
                           (dstP &
                              255) *
                           k1 +
                           (srcP &
                              255) *
                           k2 +
                           (dstP &
                              255) *
                           k3 +
                           k4);
                    if ((b &
                           -256) !=
                          0)
                        if ((b &
                               -2147483648) !=
                              0)
                            b =
                              0;
                        else
                            b =
                              255;
                    if (a <
                          b)
                        a =
                          b;
                    dstOutPixels[dstOutSp++] =
                      a <<
                        24 |
                        r <<
                        16 |
                        g <<
                        8 |
                        b;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
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
           "VV+hU2olC7vJUHZ7+YwaDCITm3nLSPBzbj4RlKXJ1L0pSwrDdLSaiOxQ6DG1" +
           "ySZJyGBX2c6pGcWpK9TCYZyc+xVspmEjcZIj1KSJ2DBNLUYrbL6tWLkxWKJM" +
           "PNvO0J6lxoK1yKbjqNPDNU5m12w3YFk2nG00RTcDfCtXUywY8ZNw1YB5iUlq" +
           "bpwtNLriL/p5NMTnlWS+9YL6jPFgTKjPa/Vc2XECLTHIHF6ulvVqlRhTLZsz" +
           "hU5fDBqDhIJN0SEWAc7l3nAUYiE5oedLkZRWS5AiuUpnyUQOl60pCiMW2VZk" +
           "N+NEkJaiOLMbE3G7RLRYwevxyhlzq53UoyoMKvXabVMiLazXlqdof1Zf1X15" +
           "sV4mlGMS7d56EA7WBLts4mIQ0rWo20hJWEKTbOg1x6vGptI0o0ablSVd8sPQ" +
           "S3TL1OfIbOkGlcBZjuI4RyVrOUFGZrWHtm3Lk+wpPcITBpVtO5y4UrdHWFhi" +
           "1brbTquyXtV20aA+qIeDFdZuJ3Qwnk+FhOksu4Gsc63Rat4fs2OJmqSiLFfR" +
           "6nLlgHE4ejWhZIa1u82WoMZ4K1SzocMNt45HurBMbUazPK/oHTkjNpWZFHQF" +
           "mhyt9TAasHBTaQe8MgmGDXS8qtC6TS9mbmxsXG/ZNKZWu012+A7ZZT2rCTfV" +
           "QX3djPjN1ApqoWhi0kyeiqLoduEV5cIKTnCxNhXXc5EHeTI76qDOKN5tLQNe" +
           "rSm6lcXobgR3+mujs8Nhw9sQfZg2LNPSDGwlJopgtAh73V2IalW25xuOWru9" +
           "2dKZaTNsHbopYeHIhhH69miwDYS4Fu+oZboz3IHbWLtrX0E6PU9skWJt0p9l" +
           "kbiScN/EGMlw82za7iZDBhmG6Xi3Vmlkp8GUttJ3cFCjQm41FYYVXlpmmjIz" +
           "bLNvhxS5iYnufMKjQc6xORNMzFlH6y8ttjuWFLmft/Jw0RXnOGsiiTNGrYTI" +
           "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");
    }
    public static class ArithCompositeContext_INT_PACK_LUT extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        byte[] lut;
        ArithCompositeContext_INT_PACK_LUT(java.awt.image.ColorModel srcCM,
                                           java.awt.image.ColorModel dstCM,
                                           float k1,
                                           float k2,
                                           float k3,
                                           float k4) {
            super(
              srcCM,
              dstCM);
            k1 =
              k1 /
                255.0F;
            k4 =
              k4 *
                255.0F +
                0.5F;
            int sz =
              256 *
              256;
            lut =
              (new byte[sz]);
            int val;
            for (int i =
                   0;
                 i <
                   sz;
                 i++) {
                val =
                  (int)
                    ((i >>
                        8) *
                       (i &
                          255) *
                       k1 +
                       (i >>
                          8) *
                       k2 +
                       (i &
                          255) *
                       k3 +
                       k4);
                if ((val &
                       -256) !=
                      0)
                    if ((val &
                           -2147483648) !=
                          0)
                        val =
                          0;
                    else
                        val =
                          255;
                lut[i] =
                  (byte)
                    val;
            }
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            byte[] workTbl =
              lut;
            int srcP;
            int dstP;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    int a =
                      255 &
                      workTbl[srcP >>
                                16 &
                                65280 |
                                dstP >>>
                                24];
                    int r =
                      255 &
                      workTbl[srcP >>
                                8 &
                                65280 |
                                dstP >>
                                16 &
                                255];
                    int g =
                      255 &
                      workTbl[srcP &
                                65280 |
                                dstP >>
                                8 &
                                255];
                    int b =
                      255 &
                      workTbl[srcP <<
                                8 &
                                65280 |
                                dstP &
                                255];
                    if (r >
                          a)
                        a =
                          r;
                    if (g >
                          a)
                        a =
                          g;
                    if (b >
                          a)
                        a =
                          b;
                    dstOutPixels[dstOutSp++] =
                      a <<
                        24 |
                        r <<
                        16 |
                        g <<
                        8 |
                        b;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
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
           "ZP1/Aw4+Xl6OKQAA");
    }
    public static class MultiplyCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        MultiplyCompositeContext(java.awt.image.ColorModel srcCM,
                                 java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcM;
            int dstM;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int sp =
                  0;
                int end =
                  w *
                  4;
                while (sp <
                         end) {
                    srcM =
                      255 -
                        dstPix[sp +
                                 3];
                    dstM =
                      255 -
                        srcPix[sp +
                                 3];
                    dstPix[sp] =
                      (srcPix[sp] *
                         srcM +
                         dstPix[sp] *
                         dstM +
                         srcPix[sp] *
                         dstPix[sp]) *
                        norm +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      (srcPix[sp] *
                         srcM +
                         dstPix[sp] *
                         dstM +
                         srcPix[sp] *
                         dstPix[sp]) *
                        norm +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      (srcPix[sp] *
                         srcM +
                         dstPix[sp] *
                         dstM +
                         srcPix[sp] *
                         dstPix[sp]) *
                        norm +
                        pt5 >>>
                        24;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] +
                        dstPix[sp] -
                        (dstPix[sp] *
                           srcPix[sp] *
                           norm +
                           pt5 >>>
                           24);
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
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
           "xCAAAA==");
    }
    public static class MultiplyCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        MultiplyCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                          java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcA;
            int srcR;
            int srcG;
            int srcB;
            int srcM;
            int dstP;
            int dstA;
            int dstR;
            int dstG;
            int dstB;
            int dstM;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    srcA =
                      srcP >>>
                        24;
                    dstA =
                      dstP >>>
                        24;
                    srcR =
                      srcP >>
                        16 &
                        255;
                    dstR =
                      dstP >>
                        16 &
                        255;
                    srcG =
                      srcP >>
                        8 &
                        255;
                    dstG =
                      dstP >>
                        8 &
                        255;
                    srcB =
                      srcP &
                        255;
                    dstB =
                      dstP &
                        255;
                    srcM =
                      255 -
                        dstA;
                    dstM =
                      255 -
                        srcA;
                    dstOutPixels[dstOutSp++] =
                      ((srcR *
                          srcM +
                          dstR *
                          dstM +
                          srcR *
                          dstR) *
                         norm +
                         pt5 &
                         -16777216) >>>
                        8 |
                        ((srcG *
                            srcM +
                            dstG *
                            dstM +
                            srcG *
                            dstG) *
                           norm +
                           pt5 &
                           -16777216) >>>
                        16 |
                        (srcB *
                           srcM +
                           dstB *
                           dstM +
                           srcB *
                           dstB) *
                        norm +
                        pt5 >>>
                        24 |
                        srcA +
                        dstA -
                        (srcA *
                           dstA *
                           norm +
                           pt5 >>>
                           24) <<
                        24;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "so0aC0HJwkH2FfZIh5/8F9p3kaEvGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "bZNwVoOFJEhuh44rls00tpV4E3G2O9EFE4Hrk45EmNX6et3z6+xQDjC7tTXS" +
           "9YKsNOilxbWTwNarYWVVZXd5Vl8bLq8tl4Goh3q9093IQsPtI1LONxdrI6hM" +
           "a8NakEsmX6vO+3wH84V1u8mPRNXPnRAxnbBKtlJYdCJ914W5NjxkphmMchMq" +
           "rbnMzGyuva4zSYfmcjPzCUneYSo7w6PZbk03Qtall1ldo9uN2nQIWxgbrcQG" +
           "6VGottPwuQEjib5KRF+cSdxsg6bwBOtVVDjc8JaODRBuayM9pOZNW8p8y+Ax" +
           "ms+i2mYpxoHc8vymJMJmrz6hiU5H1amlV2uZ640x1ONO1rN3M5bTu3RDo6co" +
           "rsGs63ESAStS3exkimalVrO5yfgdGneXqp5bdaSheJ0MSV2UbFAVklwnbo03" +
           "t83YazSqrepOj1F0W41yv8JVp2rd0O2azzJVGgZJ4ACWqAaV2v3lcpVSLUcm" +
           "cGnQkluD2KpTznQ4qEstOdd2pisHlgYjMTzE7UZ1i+gNMkqm7RE3rPA7lXNo" +
           "Xw/wZlscrVGPELbJdE2vp24TnnW6KQJ7MxvuVqfTioNPBsFCwwdMlWok7Hq+" +
           "o9LY7mL9ZajAnpzX0g7H6jAVKN3ZboVPcLw1C1pqNRo6GQxOJqu6YMWq5w8l" +
           "SQN+XelTd1KDN+jCM11z6rcCYmc3K4OtNYvJeBhH44qkaVs953Ikq7JE1vMJ" +
           "EWGpPNpQOrIcVmKAcHQL5ABjomU3klbVaJPzHEbDPjdnZfCdJ+wHrUAcyYlC" +
           "UdFyWfcqYWeuInzb4ZCFXSMYX8jljTXhyXGlHVTw/tRddFWaFuYOvGnBLRhn" +
           "dSGujWd5lhl2P0nQsK65dqbMHbu+VPo2SjS2ImHIDG4u2/gcF8g167aWYo8Q" +
           "VysENiWQDaGiuGp58mYiDJp8zzJMIZWnjURGM9ZhZ1jHiZittdopBKVrcD1V" +
           "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" +
           "JgAA");
    }
    public static class ScreenCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        ScreenCompositeContext(java.awt.image.ColorModel srcCM,
                               java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                int sp =
                  0;
                int end =
                  w *
                  4;
                while (sp <
                         end) {
                    int iSrcPix =
                      srcPix[sp];
                    int iDstPix =
                      dstPix[sp];
                    dstPix[sp] =
                      iSrcPix +
                        iDstPix -
                        (iDstPix *
                           iSrcPix *
                           norm +
                           pt5 >>>
                           24);
                    ++sp;
                    iSrcPix =
                      srcPix[sp];
                    iDstPix =
                      dstPix[sp];
                    dstPix[sp] =
                      iSrcPix +
                        iDstPix -
                        (iDstPix *
                           iSrcPix *
                           norm +
                           pt5 >>>
                           24);
                    ++sp;
                    iSrcPix =
                      srcPix[sp];
                    iDstPix =
                      dstPix[sp];
                    dstPix[sp] =
                      iSrcPix +
                        iDstPix -
                        (iDstPix *
                           iSrcPix *
                           norm +
                           pt5 >>>
                           24);
                    ++sp;
                    iSrcPix =
                      srcPix[sp];
                    iDstPix =
                      dstPix[sp];
                    dstPix[sp] =
                      iSrcPix +
                        iDstPix -
                        (iDstPix *
                           iSrcPix *
                           norm +
                           pt5 >>>
                           24);
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "BcnCSLTEIAAA");
    }
    public static class ScreenCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        ScreenCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                        java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcA;
            int srcR;
            int srcG;
            int srcB;
            int dstP;
            int dstA;
            int dstR;
            int dstG;
            int dstB;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    srcA =
                      srcP >>>
                        24;
                    dstA =
                      dstP >>>
                        24;
                    srcR =
                      srcP >>
                        16 &
                        255;
                    dstR =
                      dstP >>
                        16 &
                        255;
                    srcG =
                      srcP >>
                        8 &
                        255;
                    dstG =
                      dstP >>
                        8 &
                        255;
                    srcB =
                      srcP &
                        255;
                    dstB =
                      dstP &
                        255;
                    dstOutPixels[dstOutSp++] =
                      srcR +
                        dstR -
                        (srcR *
                           dstR *
                           norm +
                           pt5 >>>
                           24) <<
                        16 |
                        srcG +
                        dstG -
                        (srcG *
                           dstG *
                           norm +
                           pt5 >>>
                           24) <<
                        8 |
                        srcB +
                        dstB -
                        (srcB *
                           dstB *
                           norm +
                           pt5 >>>
                           24) |
                        srcA +
                        dstA -
                        (srcA *
                           dstA *
                           norm +
                           pt5 >>>
                           24) <<
                        24;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "JRs1FoCSU4fYl9kjHX7+XwFjlXQrGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "lQsNJgAA");
    }
    public static class DarkenCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        DarkenCompositeContext(java.awt.image.ColorModel srcCM,
                               java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int sp;
            int srcM;
            int dstM;
            int t1;
            int t2;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                sp =
                  0;
                final int end =
                  w *
                  4;
                while (sp <
                         end) {
                    srcM =
                      255 -
                        dstPix[sp +
                                 3];
                    dstM =
                      255 -
                        srcPix[sp +
                                 3];
                    t1 =
                      (srcM *
                         srcPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        dstPix[sp];
                    t2 =
                      (dstM *
                         dstPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        srcPix[sp];
                    if (t1 >
                          t2)
                        dstPix[sp] =
                          t2;
                    else
                        dstPix[sp] =
                          t1;
                    ++sp;
                    t1 =
                      (srcM *
                         srcPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        dstPix[sp];
                    t2 =
                      (dstM *
                         dstPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        srcPix[sp];
                    if (t1 >
                          t2)
                        dstPix[sp] =
                          t2;
                    else
                        dstPix[sp] =
                          t1;
                    ++sp;
                    t1 =
                      (srcM *
                         srcPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        dstPix[sp];
                    t2 =
                      (dstM *
                         dstPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        srcPix[sp];
                    if (t1 >
                          t2)
                        dstPix[sp] =
                          t2;
                    else
                        dstPix[sp] =
                          t1;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] +
                        dstPix[sp] -
                        (dstPix[sp] *
                           srcPix[sp] *
                           norm +
                           pt5 >>>
                           24);
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
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
           "43Miw3Tkgjv36/VYRuQNMSzAlXAapOyoVmku2gpPV4KmuS4zZhSw44XtrDu0" +
           "W+l312SMluSGOzODJNWb+jq2KLXQ73cNn170kzYngdPFO7Jjx43XdvK7Nz/k" +
           "Hl1vgANf9qL9Gk486a0H3NsNuCut5eWSe09Xyo+X1naFFCg73D1yu8uM/GD3" +
           "iQ88/6LW+2Rp76AAJYOz/MEd005Odrp+6+1PsFx+kbOrinzxA//6sPhO8z2v" +
           "oRL86KlJnhb5u9xLX6bfov7GHnT2qEZy0xXTSabrJysjlwI9igNXPFEfeeTI" +
           "rJczc6HAnPccmPXuW1djb+moM7mjtvFwqrh39qCidVDwuP9UfZBXwmhba0oO" +
           "SR45RTIKrCirZW5J80FWr1JBfF/WLCPokh/oan4LsC0/D48F4QQcyleepe2i" +
           "M/hx5/ETtboIeuDW1wyHOhRew40FiK2HbroV3d7kqZ958fKFB18c/k1enD+6" +
           "bbvIQheM2LaP172O9c8DzQ0rN8bFbRXMz3+ejaCrrz6vCDqX/+ZqPLPl+mAE" +
           "PXQ7rgg6C9rj1M9F0BtuRQ0oD81zQPnrEXTlNCUYP/89Tvc8cOWODqzObec4" +
           "yUeBdECSdV/wD13QeC2XRrjtm0o/0E/7Mz1zEk2O4uW+HxcvxwDoyRPIkd+T" +
           "H67yeHtTfkP97Ivt7ntfwT65vc1QbWWzyaRcYKE7txcrR0jx+G2lHco633rq" +
           "h/d87uKbDyHtnu2Ed+v32NwevfUdAuX4UV713/zRg3/w9t9+8Rt5dfB/AR+p" +
           "7e/AIAAA");
    }
    public static class DarkenCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        DarkenCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                        java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcM;
            int dstP;
            int dstM;
            int dstA;
            int dstR;
            int dstG;
            int dstB;
            int srcV;
            int dstV;
            int tmp;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    srcV =
                      srcP >>>
                        24;
                    dstV =
                      dstP >>>
                        24;
                    srcM =
                      (255 -
                         dstV) *
                        norm;
                    dstM =
                      (255 -
                         srcV) *
                        norm;
                    dstA =
                      srcV +
                        dstV -
                        (srcV *
                           dstV *
                           norm +
                           pt5 >>>
                           24);
                    srcV =
                      srcP >>
                        16 &
                        255;
                    dstV =
                      dstP >>
                        16 &
                        255;
                    dstR =
                      (srcM *
                         srcV +
                         pt5 >>>
                         24) +
                        dstV;
                    tmp =
                      (dstM *
                         dstV +
                         pt5 >>>
                         24) +
                        srcV;
                    if (dstR >
                          tmp)
                        dstR =
                          tmp;
                    srcV =
                      srcP >>
                        8 &
                        255;
                    dstV =
                      dstP >>
                        8 &
                        255;
                    dstG =
                      (srcM *
                         srcV +
                         pt5 >>>
                         24) +
                        dstV;
                    tmp =
                      (dstM *
                         dstV +
                         pt5 >>>
                         24) +
                        srcV;
                    if (dstG >
                          tmp)
                        dstG =
                          tmp;
                    srcV =
                      srcP &
                        255;
                    dstV =
                      dstP &
                        255;
                    dstB =
                      (srcM *
                         srcV +
                         pt5 >>>
                         24) +
                        dstV;
                    tmp =
                      (dstM *
                         dstV +
                         pt5 >>>
                         24) +
                        srcV;
                    if (dstB >
                          tmp)
                        dstB =
                          tmp;
                    dstA &=
                      255;
                    dstR &=
                      255;
                    dstG &=
                      255;
                    dstB &=
                      255;
                    dstOutPixels[dstOutSp++] =
                      dstA <<
                        24 |
                        dstR <<
                        16 |
                        dstG <<
                        8 |
                        dstB;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "SzdpLAAlpw6xr7BHOvzkvx9ig5crGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1aecwkaVmv+XZmdnZZdmaXY5eVvdgBshR+1d1VfWURqaOr" +
           "u6rvqu7q7lIZquvoqq776KrqgpUjUVASQF0QE9hEA4q4nJFoYjBrjAKBkECI" +
           "VyKLxkQUSeAPkYiKb1V/98zsZkP0S76363je533O3/v0+/RT34UuhAEEe661" +
           "XVlutK+m0f7aqu5HW08N99ledSQFoaqQlhSGE/DsmvyKT1/+wY/ep1/Zgy6K" +
           "0Iskx3EjKTJcJ+TU0LViVelBl4+ftizVDiPoSm8txRKyiQwL6Rlh9FgPesGJ" +
           "qRF0tXcoAgJEQIAISCECgh9TgUkvVJ2NTeYzJCcKfegXoXM96KIn5+JF0MOn" +
           "mXhSINkHbEaFBoDDpfxeAEoVk9MAeuhI953O1yn8fhh54jffeOWzt0CXReiy" +
           "4fC5ODIQIgKLiNAdtmov1SDEFUVVROguR1UVXg0MyTKyQm4Rujs0Vo4UbQL1" +
           "yEj5w42nBsWax5a7Q851CzZy5AZH6mmGaimHdxc0S1oBXV96rOtOQzp/DhS8" +
           "3QCCBZokq4dTzpuGo0TQg2dnHOl4tQsIwNRbbTXS3aOlzjsSeADdvfOdJTkr" +
           "hI8Cw1kB0gvuBqwSQffdlGlua0+STWmlXouge8/SjXavANVthSHyKRH0krNk" +
           "BSfgpfvOeOmEf747eN173ux0nL1CZkWVrVz+S2DSA2cmcaqmBqojq7uJd7ym" +
           "9wHppZ9/1x4EAeKXnCHe0fzRW77/htc+8PQXdzQ/dQOa4XKtytE1+SPLO7/2" +
           "cvLR5i25GJc8NzRy55/SvAj/0cGbx1IPZN5LjzjmL/cPXz7N/eXibR9Xv7MH" +
           "3c5AF2XX2tggju6SXdszLDVoq44aSJGqMNBtqqOQxXsGuhVc9wxH3T0dalqo" +
           "Rgx03ioeXXSLe2AiDbDITXQruDYczT289qRIL65TD4Kgu8E/dA8EXcCh4m/3" +
           "GUFvRHTXVhFJlhzDcZFR4Ob6h4jqREtgWx1Zgqg3kdDdBCAEETdYIRKIA109" +
           "eJFnppREiGED9yO80CaBUrna6n4eZ97/+QppruOV5Nw5YP6Xn01+C+RNx7UU" +
           "NbgmP7EhWt//5LUv7x0lw4F1IqgLFt3fLbpfLFoAJ1h0v1h0/+SiVykpMFXn" +
           "6P4AOa4xg8m1EU52oXPnCllenAu3CwPgRBPAAQDKOx7lf4F907tecQuIPy85" +
           "DzyQkyI3x2vyGECYAiZlEMXQ0x9M3i68tbQH7Z0G3lwh8Oj2fPooh8sjWLx6" +
           "NuFuxPfyO7/9g0994HH3OPVOIfkBIlw/M8/oV5w1feDKqgIw8pj9ax6SPnft" +
           "849f3YPOA5gA0BhJIJQB6jxwdo1Tmf3YIUrmulwACmtuYEtW/uoQ2m6P9MBN" +
           "jp8UMXFncX0XsPGlPNRfDWKePIj94jN/+yIvH1+8i6HcaWe0KFD4Z3jvw3/z" +
           "1X9BC3MfAvblE1sgr0aPnQCJnNnlAg7uOo6BSaCqgO7vPzj6jfd/950/VwQA" +
           "oHjkRgtezcc8wIALgZl/6Yv+3z7zzY98Y+8oaKD0tG6XnkU3sMirjsUA2GKB" +
           "7MuD5erUsV3F0Axpaal5cP7X5VeWP/dv77myc78FnhxGz2ufm8Hx85cR0Nu+" +
           "/Mb/eKBgc07O97ZjUx2T7QDzRcec8SCQtrkc6du/fv9vfUH6MIBeAHehkakF" +
           "gu0Vqu8Vmr8kgl5WzDzOUcDZDfquohb7BVK4dL8gfrQYfzq3y4H18vtKPjwY" +
           "nkyN09l3olS5Jr/vG997ofC9P/1+odTpWudkJPQl77Fd8OXDQylgf89ZHOhI" +
           "oQ7osKcHP3/FevpHgKMIOMoA+8JhAJAqPRU3B9QXbv27P/vzl77pa7dAezR0" +
           "u+VKCi0VKQjdBmJfDXUAcqn3s2/YBUGSR8WVQlXoOuV3sXNvcXcLEPDRm6MP" +
           "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");
    }
    public static class LightenCompositeContext extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext {
        LightenCompositeContext(java.awt.image.ColorModel srcCM,
                                java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose(java.awt.image.Raster src,
                               java.awt.image.Raster dstIn,
                               java.awt.image.WritableRaster dstOut) {
            int[] srcPix =
              null;
            int[] dstPix =
              null;
            int x =
              dstOut.
              getMinX(
                );
            int w =
              dstOut.
              getWidth(
                );
            int y0 =
              dstOut.
              getMinY(
                );
            int y1 =
              y0 +
              dstOut.
              getHeight(
                );
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int sp;
            int srcM;
            int dstM;
            int t1;
            int t2;
            for (int y =
                   y0;
                 y <
                   y1;
                 y++) {
                srcPix =
                  src.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      srcPix);
                dstPix =
                  dstIn.
                    getPixels(
                      x,
                      y,
                      w,
                      1,
                      dstPix);
                sp =
                  0;
                final int end =
                  w *
                  4;
                while (sp <
                         end) {
                    srcM =
                      255 -
                        dstPix[sp +
                                 3];
                    dstM =
                      255 -
                        srcPix[sp +
                                 3];
                    t1 =
                      (srcM *
                         srcPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        dstPix[sp];
                    t2 =
                      (dstM *
                         dstPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        srcPix[sp];
                    if (t1 >
                          t2)
                        dstPix[sp] =
                          t1;
                    else
                        dstPix[sp] =
                          t2;
                    ++sp;
                    t1 =
                      (srcM *
                         srcPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        dstPix[sp];
                    t2 =
                      (dstM *
                         dstPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        srcPix[sp];
                    if (t1 >
                          t2)
                        dstPix[sp] =
                          t1;
                    else
                        dstPix[sp] =
                          t2;
                    ++sp;
                    t1 =
                      (srcM *
                         srcPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        dstPix[sp];
                    t2 =
                      (dstM *
                         dstPix[sp] *
                         norm +
                         pt5 >>>
                         24) +
                        srcPix[sp];
                    if (t1 >
                          t2)
                        dstPix[sp] =
                          t1;
                    else
                        dstPix[sp] =
                          t2;
                    ++sp;
                    dstPix[sp] =
                      srcPix[sp] +
                        dstPix[sp] -
                        (dstPix[sp] *
                           srcPix[sp] *
                           norm +
                           pt5 >>>
                           24);
                    ++sp;
                }
                dstOut.
                  setPixels(
                    x,
                    y,
                    w,
                    1,
                    dstPix);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "wsYgAAA=");
    }
    public static class LightenCompositeContext_INT_PACK extends org.apache.batik.ext.awt.image.SVGComposite.AlphaPreCompositeContext_INT_PACK {
        LightenCompositeContext_INT_PACK(java.awt.image.ColorModel srcCM,
                                         java.awt.image.ColorModel dstCM) {
            super(
              srcCM,
              dstCM);
        }
        public void precompose_INT_PACK(final int width,
                                        final int height,
                                        final int[] srcPixels,
                                        final int srcAdjust,
                                        int srcSp,
                                        final int[] dstInPixels,
                                        final int dstInAdjust,
                                        int dstInSp,
                                        final int[] dstOutPixels,
                                        final int dstOutAdjust,
                                        int dstOutSp) {
            final int norm =
              (1 <<
                 24) /
              255;
            final int pt5 =
              1 <<
              23;
            int srcP;
            int srcM;
            int dstP;
            int dstM;
            int dstA;
            int dstR;
            int dstG;
            int dstB;
            int srcV;
            int dstV;
            int tmp;
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                final int end =
                  dstOutSp +
                  width;
                while (dstOutSp <
                         end) {
                    srcP =
                      srcPixels[srcSp++];
                    dstP =
                      dstInPixels[dstInSp++];
                    srcV =
                      srcP >>>
                        24;
                    dstV =
                      dstP >>>
                        24;
                    srcM =
                      (255 -
                         dstV) *
                        norm;
                    dstM =
                      (255 -
                         srcV) *
                        norm;
                    dstA =
                      srcV +
                        dstV -
                        (srcV *
                           dstV *
                           norm +
                           pt5 >>>
                           24);
                    srcV =
                      srcP >>
                        16 &
                        255;
                    dstV =
                      dstP >>
                        16 &
                        255;
                    dstR =
                      (srcM *
                         srcV +
                         pt5 >>>
                         24) +
                        dstV;
                    tmp =
                      (dstM *
                         dstV +
                         pt5 >>>
                         24) +
                        srcV;
                    if (dstR <
                          tmp)
                        dstR =
                          tmp;
                    srcV =
                      srcP >>
                        8 &
                        255;
                    dstV =
                      dstP >>
                        8 &
                        255;
                    dstG =
                      (srcM *
                         srcV +
                         pt5 >>>
                         24) +
                        dstV;
                    tmp =
                      (dstM *
                         dstV +
                         pt5 >>>
                         24) +
                        srcV;
                    if (dstG <
                          tmp)
                        dstG =
                          tmp;
                    srcV =
                      srcP &
                        255;
                    dstV =
                      dstP &
                        255;
                    dstB =
                      (srcM *
                         srcV +
                         pt5 >>>
                         24) +
                        dstV;
                    tmp =
                      (dstM *
                         dstV +
                         pt5 >>>
                         24) +
                        srcV;
                    if (dstB <
                          tmp)
                        dstB =
                          tmp;
                    dstA &=
                      255;
                    dstR &=
                      255;
                    dstG &=
                      255;
                    dstB &=
                      255;
                    dstOutPixels[dstOutSp++] =
                      dstA <<
                        24 |
                        dstR <<
                        16 |
                        dstG <<
                        8 |
                        dstB;
                }
                srcSp +=
                  srcAdjust;
                dstInSp +=
                  dstInAdjust;
                dstOutSp +=
                  dstOutAdjust;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "lRe3aiwCJaaPsa+wRzr8+L/Lf3usLRsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "tPjn7/2l7/8nr/1xVWb5v23T+Q4TJgAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "S+pSVmLSpD1gvSq5WzzckfyTFZgLSyBYcPMfjX575J09r3MXrsGYyTuOJ14g" +
       "tjyTkWbLFl/AXwiuz/FCaXEDfyGXxOxp6bL8uBRf78q+p/kUiB5s+WDvg+ee" +
       "tBTwv5T5gOnho9/6InLfUSvLWDP3y4vG3l4ca+5uqYPLKyjd8nJcOEbPn08f" +
       "fP7Rg4fC9tk8DF6bVlWZCkrRgetkXqHZLVlv+WbTT4+0VPRA/oqTGlOR9pk0" +
       "nimM4WrDTHvOwR3TuxFtS402ZyS02nl75hHz/JcVMe1wpW23T08/YoJQy0fM" +
       "wnxhcgYysqqjPWXO8myZ0PkQl3cZqZeMVLx/OJXsim3HrZddW733JdhqMT5b" +
       "BZdpK2xO31ZBqD5tK9xm6QO+OFZrzVttkCoZit+OeiWFGZz1+TI2u4DLOUYa" +
       "RZ1C4Nof24oPI98leCG4ST/6f5g0x0iD96Uex0ltRd8LrW9c4lMnm2paT+54" +
       "h/cE+e9QDZDRxkxZ9g48PPdVmk7HJK5zgzX+0PjPRUbay08bGJnFf7nsn1lY" +
       "nzPSFoQF72aweqBDIUbmlYIGSMeUNmQllAw/JPDnv164akbqXDioFtaNF6QO" +
       "qAMI3tZrwfUo5GnHiCerzL/UseZRvHNpNAH/GuwkQtP6HpwST5/c1n/HhY0P" +
       "W3NxURYOHEAq9ZD+rBF9vmlaHkjNoVXVu+ri7KdrVzp5eY4lsBtml3k8HN5I" +
       "Qhr60yLf0NjoyM+O3z21+cVfHa56EyrKThISGJm7s3j+ltNM6FZ3JorTPDSY" +
       "fJrdueoH+29cO/a33/MJp10WFgfDp8S3H7n9rfvbTrWHSX0c3AxCN8cHg7fs" +
       "VwapOKmPkkbJ6M6BiEBFEuSCGjIbXV/AWOd2sc3ZmN/FryqMrCiujMXfoupk" +
       "dYrqW1RTydhVqN7dcZrngr7T1DQfgrvj6R7etAqX1ShUpBJ9muY0DrUrNR79" +
       "b/lLAd/kPtzOb/Fu6X8BPzYf9ikiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
