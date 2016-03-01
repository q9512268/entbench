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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "HiUAAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1ZfWwUxxWfO38bG38QjGPAgG2QDPSukKS0Mk0x5stwtk82" +
           "cRUTcsztzfkW9naX3Tn7MKUEpBSaSigNJCVpcKsW+oH4apsobSooVT8SRBME" +
           "jdoQ2tAkfyQpQYI/GqelbfpmZvd2b+9sitTG0u3tzbx5M++93/zem/Gx66jI" +
           "NFCTjtUYDtBtOjEDYfYexoZJYh0KNs310BqRHntr/86x35ft8qPiATQ5gc0u" +
           "CZtklUyUmDmAZsqqSbEqEbObkBgbETaISYwhTGVNHUBTZbMzqSuyJNMuLUaY" +
           "QD82QqgGU2rI0RQlnZYCimaF+GqCfDXBdq9AWwhVSJq+zRnQkDWgw9XHZJPO" +
           "fCZF1aHNeAgHU1RWgiHZpG1pAy3QNWXboKLRAEnTwGblPssRa0P35bih6VTV" +
           "h7ceT1RzN0zBqqpRbqLZS0xNGSKxEKpyWlcqJGluRV9GBSE0ySVMUUvInjQI" +
           "kwZhUtteRwpWX0nUVLJD4+ZQW1OxLrEFUTQnW4mODZy01IT5mkFDKbVs54PB" +
           "2tkZa+1we0x8ckHwwDcerv5xAaoaQFWy2seWI8EiKEwyAA4lySgxzPZYjMQG" +
           "UI0KAe8jhowVecSKdq0pD6qYpgACtltYY0onBp/T8RVEEmwzUhLVjIx5cQ4q" +
           "61dRXMGDYGudY6uwcBVrBwPLZViYEceAPWtI4RZZjXEcZY/I2NiyDgRgaEmS" +
           "0ISWmapQxdCAagVEFKwOBvsAfOogiBZpAEGDY20cpczXOpa24EESoajeKxcW" +
           "XSBVxh3BhlA01SvGNUGUGjxRcsXnevfSfdvVNaof+WDNMSIpbP2TYFCjZ1Av" +
           "iRODwD4QAyvmh57Cdaf3+hEC4akeYSHzwpduLlvYePZlITM9j0xPdDORaEQ6" +
           "HJ18cUZH6+cK2DJKdc2UWfCzLOe7LGz1tKV1YJq6jEbWGbA7z/b+9sFHjpJr" +
           "flTeiYolTUklAUc1kpbUZYUYq4lKDExJrBOVETXWwfs7UQm8h2SViNaeeNwk" +
           "tBMVKrypWOO/wUVxUMFcVA7vshrX7Hcd0wR/T+sIoenwQbMR8hUh/ie+KVKC" +
           "CS1JgljCqqxqwbChMftZQDnnEBPeY9Cra8Eo4H/LpxYFlgRNLWUAIIOaMRjE" +
           "gIoEEZ18n+JhGpSTAIZgX//qDjCROYEEGOr0T3i+NLN/yrDPB6GZ4SUGBfbU" +
           "Gk2JESMiHUgtX3nzROS8AB3bKJbnKOqCSQNi0gCflNMoTBrgkwbck7a0K3oC" +
           "Q27ItFi8EunsXh8Jt3esQz4fX81dbHkCJBDiLUAWwNYVrX0b127a21QA6NSH" +
           "C1mUQHReTvbqcFjFTgUR6djF3rELr5Qf9SM/EE8UspeTQlqyUojIgIYmkRhw" +
           "2HjJxCbU4PjpI+860NmDw7v6d36ar8OdFZjCIiA0NjzMuDwzRYuXDfLprdrz" +
           "3ocnn9qhObyQlWbs7JgzktFNkzf2XuMj0vzZ+PnI6R0tflQIHAa8TTHsM6DE" +
           "Ru8cWbTTZlM4s6UUDI5rRhIrrMvm3XKaMLRhp4WDsoa/3wUhLmX7sBVCXWpt" +
           "TP7Neut09pwmQMww47GCp4jP9+mHXn/1/Xu4u+1sUuUqA/oIbXMxGFNWy7mq" +
           "xoHgeoMQkPvzwfD+J6/v2cDxBxLN+SZsYU+GbwghuPnRl7devvrm4df8Gcyi" +
           "dLZtpRPYxuDtLAOITwEyYGBpeUAFMMpxGUcVwvbGP6vmLnr+g33VIvwKtNjo" +
           "WXh7BU773cvRI+cfHmvkanwSS7yOqxwxweZTHM3thoG3sXWkd12a+fRL+BDk" +
           "BeBiUx4hnF793HQ/t7yeorv5SIckQLNmsNKQJ7N7eUjv4cIB/lzM/GJ5j/1e" +
           "wh4tpntrZO8+Vx0VkR5/7UZl/40zN7lR2YWYGwldWG8T4GOPuWlQP81LQ2uw" +
           "mQC5e892P1StnL0FGgdAowTka/YYQJXpLNxY0kUlb/zyV3WbLhYg/ypUrmg4" +
           "tgrzLYjKAPvETADLpvUvLBMgGGYgqOamohzjmdtn5Q/oyqROeQhGfjrtuaXf" +
           "H32TQ06AbbobefP4s5U9FvL2AgpFZSoK9TlFpTgKDAHLgzaTl34OXLmOBm+O" +
           "dMM1ay4DzRyvjOEl2OHdB0ZjPUcWiWKjNrs0WAmV7/E//Ot3gYN/OZcn6xRb" +
           "ZagzoR/mm5OTCrp4iefQ2JJLYwVXnqivyM0CTFPjOBw/f3yO907w0u6/Nqy/" +
           "P7HpDuh9lsdLXpU/7Dp2bvU86Qk/r1IFs+dUt9mD2tz+gkkNAuW4ysxiLZUc" +
           "5U2ZuPLapwviWW3FtSI/xeYFj5+iMt3QKMCQxFjzSg+/NdgK8yj2bPFJXOMk" +
           "vq9dkWTE0JcCXIYNOQksPWRVtCfrxrb+umRkhV2t5hsiJNeZXRdeXPNuhEel" +
           "lIU94wtXyNuNQVcKqhZmfAx/Pvj8m33Y8lmDqA1rO6wCdXamQtV1hvvWCY6U" +
           "2SYEd9Re3fLse8eFCd4K3iNM9h547OPAvgNiP4hjTnPOScM9Rhx1hDnssTHN" +
           "d8kEs/ARq949uePnP9ixx2/R7VqKCmTrBMri5MsUX3Vep4uVFi869PedX3m9" +
           "B6qFTlSaUuWtKdIZywZliZmKuqLgnIsciFprZh6nyDcfnMsaHjLZMTZfsHkW" +
           "Eiv42ZT3f3JuU8ll4dj8cPIckN7efv472p+u+W2rN2RwPJnFuwY+FkWLb4rk" +
           "/0uxPki0JKigiRBRB2nCPhl8cpMxkMwdH8IuL49+r/nVnaPNb/E8WCqbQJqw" +
           "ifIcYF1jbhy7eu1S5cwTvJIsZHvRQkD2yT/3YJ91XucRqmKPpAWKXHDOzkkH" +
           "/MLKYdYPrnzznV+MfbdEgGSCXesZV/+PHiW6++2PcgoKTvJ5NrJn/EDw2LMN" +
           "Hfdf4+OdYpqNbk7nHsXAq87YxUeTf/M3Ff/Gj0oGULVkXQ71YyXFStQB8Jtp" +
           "3xiFUGVWf/blhjjJt2VSygwvk7im9Zbx7n1cSLP2bI2IiQ9xhh8ZJ2mw1xUU" +
           "lMoqVvi4jZDUFY5B9ivKHoZVvSzOLSBF6cnsgKJCUwmrYu0+cXaUtUDmXgo6" +
           "0zn4YL+7HQAZ+Vfq4ysVK5ygIP3qBH1fY49HwViJrVQYNoH4Pu64Za7iz+es" +
           "JCHAnnko4/7kgg9OMM/X2aMXXKkbROLncZI5hvMBEStjsC+oDAuHNFlsvs+y" +
           "R5/oaPvvylZuknB5hlVrWVc7GDbFqg5q76Ds4N7o95QaNbaSPMo8nigQla+N" +
           "mameA0kvNqnYkN+2RWZ6RL5oyJQhS4jytX5rAncfYY+nKSp33M1a9jsefebO" +
           "PZqmaM5t71RsAxbcwU0NsGd9zk2xuN2UToxWlU4bfeCPgsDtG8gKKKziKUVx" +
           "M4PrvRjMjsvcExWCJ0QyP0FR48Trgo3Dv7kZx8WoH1FUP94oqFXg6ZZ+Djgh" +
           "nzRIwtMt+QJF1V5JmJ9/u+VehDg6csBc4sUtchq0gwh7PaPbIVjxv7gsS/ty" +
           "z3QcQFNvByDX0aw5K9nx/x3Y5VFK/PcA6uvRtd3bb37miLg7kRQ8MsK0TIJU" +
           "LK5xMkeYOeNqs3UVr2m9NflU2Vy7uKoRC3Z2+HTXXoH1+3R21G3w3DCYLZmL" +
           "hsuHl555ZW/xJcihG5APA49tyE1uaT0F56sNoXxVKqQ3fvnRVv7OpgsfveGr" +
           "5edlq3RonGhERNp/5ko4ruvP+FFZJ8BTjZE0z7wrtqm9RBoysore4qiWUjN1" +
           "zWS2YTD7vwL3jOXQykwru3ujqCm3rM+9jyxXtGFiLGfaef71HPpSuu7u5Z4d" +
           "FJwuyteCSKhL163zTNEp7nld58xykSeb/wB1Ih33IBwAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1aCczs1lX2+5P38pKmeS8JbUNo0qR5BaVDf8+MZ1UodPbN" +
           "9ngZe8ZmefW+7+sMhNIiaAWiFEhLQW0EUssaWgRURaCioLIKhARCbBIUEBJL" +
           "qdRKbKJs155/f0sVgfil/459fe6555x7zneP7/FLn4MuRyFU8T17q9lefKjk" +
           "8aFpNw/jra9Eh3O0SQhhpMgDW4iiFei7Kb3xZ6/9yxffp18/gK7w0KOC63qx" +
           "EBueG1FK5NmpIqPQtdPeka04UQxdR00hFeAkNmwYNaL4ORR61ZmhMXQDPRYB" +
           "BiLAQAS4FAHunVKBQa9W3MQZFCMEN44C6FuhSyh0xZcK8WLo6fNMfCEUnCM2" +
           "RKkB4HC1uGeBUuXgPISeOtF9r/MtCr+/Ar/wg990/efuga7x0DXDpQtxJCBE" +
           "DCbhoQcdxRGVMOrJsiLz0MOuosi0EhqCbexKuXnokcjQXCFOQuXESEVn4ith" +
           "Oeep5R6UCt3CRIq98EQ91VBs+fjusmoLGtD1tae67jUcF/1AwQcMIFioCpJy" +
           "PORey3DlGHrDxREnOt5YAAIw9D5HiXXvZKp7XQF0QI/s184WXA2m49BwNUB6" +
           "2UvALDH0+B2ZFrb2BckSNOVmDD12kY7YPwJU95eGKIbE0GsukpWcwCo9fmGV" +
           "zqzP5/Cvee83u1P3oJRZViS7kP8qGPTkhUGUoiqh4krKfuCDb0Y/ILz2U+85" +
           "gCBA/JoLxHuaT37LF9721U++/Ft7mq+4Dc1SNBUpvil9RHzo918/eLZ7TyHG" +
           "Vd+LjGLxz2leuj9x9OS53AeR99oTjsXDw+OHL1O/wX3bTymfPYAemEFXJM9O" +
           "HOBHD0ue4xu2Ek4UVwmFWJFn0P2KKw/K5zPoPnCNGq6y712qaqTEM+heu+y6" +
           "4pX3wEQqYFGY6D5wbbiqd3ztC7FeXuc+BEFfAf6hpyDo0mWo/Nv/xpAN656j" +
           "wIIkuIbrwUToFfoXC+rKAhwrEbiWwVPfg0Xg/9ZbaodtOPKSEDgk7IUaLACv" +
           "0JX9wzJOhSyGDQc4A0yzkwFQsTCCclh4nf//PF9e6H89u3QJLM3rLwKDDWJq" +
           "6tmyEt6UXkj6oy987ObvHJwEypHlYggDkx7uJz0sJy1BFUx6WE56eHbSGz3b" +
           "1wUiVE56jnDl5gxf3SR6gwV06VIpzZcV4u2dBCyxBcACwOiDz9LfOH/7e954" +
           "D/BOP7u3WCVACt8ZzQen8DIrQVQCPg69/MHsnew7qgfQwXlYLlQCXQ8Uw4kC" +
           "TE9A88bFcLwd32vv/rt/+fgHnvdOA/Mczh/hxa0ji3h/40Xjh56kyABBT9m/" +
           "+SnhEzc/9fyNA+heACIAOGMBODrApCcvznEu7p87xtBCl8tAYdULHcEuHh0D" +
           "3wOxHnrZaU/pFQ+V1w8DG18tAuFZYOurR5FR/hZPH/WL9sv2XlQs2gUtSox+" +
           "K+1/+E9+7++R0tzHcH7tzAZJK/FzZyCkYHatBIuHT31gFSoKoPvzDxI/8P7P" +
           "vfvrSwcAFM/cbsIbRVs4GFhCYObv+K3gTz/zFx/5w4MTp4Hy87pdvYtuYJKv" +
           "PBUDII8NorFwlhuM63iyoRqCaCuFc/7HtTfVPvGP772+X34b9Bx7z1d/aQan" +
           "/V/eh77td77pX58s2VySip3v1FSnZHs4ffSUcy8MhW0hR/7OP3jih35T+DAA" +
           "ZgCGkbFTSnw7KFU/KDV/TQx9eTnyNEoBZy/EPFkpdxO4XNLDkvjZsn1LYZcj" +
           "6xX39aJ5Q3Q2NM5H35lE5qb0vj/8/KvZz//KF0qlzmdCZz0BE/zn9s5XNE/l" +
           "gP3rLuLAVIh0QNd4Gf+G6/bLXwQcecBRAugXLUOAVfk5vzmivnzfn/3qp1/7" +
           "9t+/BzoYQw/YniCPhTIEofuB7yuRDmAu97/ubXsnyAonuF6qCt2i/N53Hivv" +
           "7gECPntn9BkXicxpAD/270tbfNdf/9stRihx5zb794XxPPzShx4ffO1ny/Gn" +
           "AFCMfjK/Fb9B0nc6tv5Tzj8fvPHKrx9A9/HQdekoo2QFOynCigdZVHScZoKs" +
           "89zz8xnRfvt/7gTgXn8RfM5MexF6TvcNcF1QF9cPnEWb/wZ/l8D/fxX/hbmL" +
           "jv0+/MjgKBl46iQb8P380qUYulw/bB9Wi/FvK7k8XbY3iuar9ssUg5w5EW0D" +
           "RNOVqExnwSjVcAW7nLwXAzezpRvHM7AgvQXrcsO028fhcr10qcICh/uccA95" +
           "RYuULPZu0bqjCz23pyr3todOmaEeSC+/+2/e97vf+8xnwLrOoctpYXOwnGdm" +
           "xJMi4/7Ol97/xKte+MvvLnEMIBXxgdH1txVc8TtoXVyOi2ZSNNNjVR8vVKXL" +
           "hAEVohgrMUiRS23v6s5EaDgAodOjdBJ+/pHPWB/6u5/Zp4oXffcCsfKeF77r" +
           "vw/f+8LBmQT9mVty5LNj9kl6KfSrjywcQk/fbZZyxPhvP/78L//E8+/eS/XI" +
           "+XRzBN6mfuaP/vN3Dz/4l799m0zmXtv7Xyxs/NA/TRvRrHf8h9Z4dZ0xeb5W" +
           "l0hHnCAd0pwQPW1SJ4cEnVgLuopZ1bwZxVlsdeoSxaykaBfvVGvddYUNsnLb" +
           "2IIZ+X1aoA0Nnw9YX1pE64o3bQh+5Im057GrDk31sZEpe2Q97lnqlvRJbgZP" +
           "AsUWVd/hU7kuVrpgX11NqgkS78S8iVUqXQTeKQ48yVstc4aPByszZrhh3I+X" +
           "5mjIqZySe/yc06sLPEJq1X5ATd04hDutHGmqcScgjN6KbGpSNRnwsWUzW8YZ" +
           "Oj0+CgJaHAUjcSlafU0crYQZzWX6asLiU6a/4kVsF9DJdo5jCcoIHDns1MlA" +
           "mzD1cFalSNvluQHYisaVSTBQh5u+HHR760xn6XlQ2VEuaQ3XWtbdTPk5sVQH" +
           "/LgmTHGlp02ZGrXWjCnvT2p+b4uQ+HojeguU6o3cVTYRbSKKKKFKIE3R0Fvs" +
           "itXbIC+qUTu8uusHgU+JAcrT1Ryf0It8tPC3a1sK5hM7odjupE+PqluaxRgm" +
           "nbkmObMyXmfiWKEyf72pugyLzoeNCk+ua8scDUdjZkW664azHPLbam22ajrW" +
           "eLgQ2ajZIPr12OKFSi1TqnlHsqZZNpSUMG3mPcETyPF6W4+U9awzMhajbNvr" +
           "NewtreU7gudMjJwws+qip3RM3ctYRaIXclD1h62A87XeILZjjqt6bt+HVx2K" +
           "HY2cbMfoKGvO8qZENoJWTaY22GTITRKZayWZ1GfDfkagPGtwI0npEet41qB4" +
           "3tyMJJ6DZ3Xc2A41ShNGDl2d0WtH8MlcHvQEjR2NF9myn0Y9delpRp/3eyPA" +
           "t16VfGm3WfpCvTEa0Z5gKotcWm/oPpvrSF+3e9UanU5wZsJMzJySoo2rpCqt" +
           "yimLC55aWQ9xjJ75IlFfceOBydd6qUEth9mwQfa2qaM32wNZUJGKPho0BEvh" +
           "6Oku8+UEtVNOIXh7tsK6ZjUn5OGSEkZkazqvdSSGn7Yq0qI+nC9kqc6s1cEO" +
           "XSptdLKrxQu2xs2DljkS1xOx197BRYSMp6Y/D1V7pRicZ68Yy+4xUs3yRYbn" +
           "GC5o2IvhKJ+H/SU7Wm3WmRq1GdLp6HWaNXBBUfDMivsYuwi3/nq5hDOGzRls" +
           "LLG9dhrp4aY9leRqRsGrSjTzFDcjRYzq6IwOG0plwS4GA7o212xzEAR5kIkD" +
           "HVNjnhy67qhPKFx3EAqdkdeYwqifc2Nbo3B0zfRms6WAUeZIm3mjEV/ruJW5" +
           "PvHpVW/GaxsYDobmgFpyo9FkGVZXiFHBURzehkOi35rwDZqZ9FWRmVj1+YjG" +
           "jCmjxRvE3VFLutPrI+JiLrqLZTCgSdyoagPVxjFv1Q81KxMlqy1UF4g3IOvt" +
           "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" +
           "hVUDECTsornVZgQS9Kc1lWt0pxlrzEOW5HCQuxNJq8ELbWNXUaL5YNpzXctr" +
           "wG1L07pLDIM3dQHbbBaWSC1RV+JnTT3F+iM6NqNBxRv2kik+tqM0qmwBLHoC" +
           "kaZbm08st9/UbTZcs1J7MhTHgdYM2q1h1MDbXrdJCrgo0ATmdVxDI22hgjvg" +
           "radXtVI8cDkLr9SpNd+i0Ka3nZM63TC38aYZ9lxJ5biKu6B9BAEQ1TUjRVXE" +
           "JcEHjoA143aNinq5KGVMFY8mcndn1fMErzMrL1/bTENUlQGhRcN40tEWi8XO" +
           "WICcCGsQYUqZmBml0ihfD+ZVcktUx1Sjswo1DxmmbYvPO2tvWhszRLfhBeON" +
           "1uL5ytDUdJCdzLIYiyvkfFxjm3Nn3oWTCqvoQ60lRX2pETGxpAdVLdPbhECI" +
           "M9bM07YW0eDlcoeQEjnG0/52uKkKWXPRdXM4R7gmO17AhNRrJSkVy4goIm3H" +
           "QLW2RZEdLFpUV7M5gy6aOQbSzqWCBxHCsGHd6eKqzdTZbTtZeNQA4euV6Wqz" +
           "AVJXEKpemyAZMhxwKO+gepRM7Wazya/hfC4Z+qTZI3qNbrwd1RJhVR03WxHu" +
           "bXJ2EZCImroUm7aXvhapqTIJm4psBwjluRN9ROE+3ARuEiYpURmP+XmnvzL5" +
           "UXXXzsI4cLpU39tGXqg0AmPNmHhtt6br3GrYTjMUMZcbcmtlYYIkZjBwkBCr" +
           "dM1tvoknYwOdqIKitmtTwqeTpJ00+YY8nmfJNlYG9EJHay1kt8JHftu15WYn" +
           "31q0IsJZvzbTEWTWz8BL7lvfWrz+3nxlJxAPl4ctJ9U4024XD+av4M07v9uE" +
           "MXRVEKM4FKTyBHZyetpbnuA9frHGc/a09/RsDyrOG564UxmuPGv4yLteeFFe" +
           "frR2cHQmysfQlaPq6CmfA8DmzXc+VMHKEuTpQd1vvusfHl99rf72V1CceMMF" +
           "IS+y/Enspd+efKX0/QfQPSfHdrcUR88Peu78Yd0DoRInobs6d2T3xIlZy9IZ" +
           "Bsx5/cisD96+QHDbNTuIofv90IsVKVbkolvfu8mFs+dXlcSvKu+ZM+7BxdA9" +
           "hlsu9BZY+k13tnR5QL4/jXrxx575vXe8+MxflYfHV42IFcJeqN2m7HpmzOdf" +
           "+sxn/+DVT3ysLL/cKwrR3hQX69W3lqPPVZlL3R48sVxpqGvAMfG95fa/MRT8" +
           "nxYBBd+P4CjVxNDLIiWEcU9WCEOylBDwU+zjyuP//6T5ftmO1/jSUUnv5Fjt" +
           "HfklqPSgb7+D75wAzAm2XLEVV9vXdbdF861+fsL/Qgnk0dMT1oHtuUpRhzl+" +
           "ti8/Gt7hyacN4GF+W0m9vaTlZLcX81Ip5m3d+mxJ5fvu8uwHiuZ7YuiyVEi6" +
           "V+wu5B/IoRML7M1wx9uSPr8Lrw8WTQjM5YeKVJZtlZNq7e3C8d7UM+RTGI++" +
           "1AHq2fn2Bj0Jj0eKzh4w4KNHwPLIKwCW0urpba1+z1H15mixX3OhFkYJUbyv" +
           "q/zYMckTF0jWoREXLrEnLSf56F1s+NNF8yMx9MCpDYueHz4104++EjPlMfT0" +
           "l6ykH4teeQX1eYCgj93yfdD+mxbpYy9eu/q6F5k/3gPg8Xcn96PQVTWx7bOl" +
           "nTPXV4DCqlHa4P59occvf34hhp68u1zA18vfUo2f34/6ZAw9dqdRYB8A7Vnq" +
           "XwJhfDtqQAnas5SfiqHrFynB/OXvWbqXwQqe0gGw2V+cJfk04A5Iistf84+X" +
           "YPh/8YlEful8dnLiOo98Kdc5k9A8c25/LL8YO84akv03Yzelj784x7/5C62P" +
           "7gv2ki3sdgWXq2Ar2387cJJ5PH1Hbse8rkyf/eJDP3v/m45TpIf2Ap+G7RnZ" +
           "3nD7MvnI8eOysL37xdf9wtf8+It/URbA/gfPAxA0yicAAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "sWWXniAAAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "grvsFPO8pjF6Oc348b+t4ZwaphoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "xQoZjMSZoiCYZaJH9koyIVTGIuEhNrUWmkxdWHbUGhEzgy5KV2q0O0OkSb1d" +
           "RhuuG5hqYC4oMqBc0ukSG3mk87y3XMx1OAy6K9eZd2G/TpnunOJrM3MeYqXF" +
           "oOW2edIuheWyQy0LziKS+/SUmrPEuBdSfRlPLKpVU62x4jfjYFQs4+HALoot" +
           "ejidS1LYK6tRQ6Ji1MBXK41oVxBkKUkAH9t1ilpMHKJeJ1r4mB9jAtU2R0Gh" +
           "L/URX8DkNenbUqcZ17npyOWDIb4p2+Vun+LJXpPho/4K48pSMaSZmio2Wj0G" +
           "L3MCI4haQXbKgsnEMGWH5LJFS+UyIq+xhiEg5ZYZ8zxdrDGYxKDaaO5HFO92" +
           "SRjkm2Rx2i3izZmj2MzIDRLFoTo8XvAxicVFh5/5dKPZrjkYPqRFEjM3YWs8" +
           "wLxSLCjkEiX5+YwYVYMxjWJ1fuFSrI8zpJtIolTzTWHOoKMJjdfghdsx4grF" +
           "RiIH0y131pcc1qsHKGaKUcHkgg3O+nJj2TTGdNOHQegYlWRKYKTg6ZJQ2+CF" +
           "wtTjHDtWNnSFlV1etPWkr0ajmVUNOtWKJsoVPoFHODUZKW4ws4U2glAaolJk" +
           "ecrKJakVuB6jKGOjWZ9v1AaSIsRm0Q1hZzDlLdGqLzSBZ9muPSqFI3tdiqez" +
           "lh5hS8nmF1GP8oO0NCs1OxypOS2DTVPNtc2RTTpaGI0Qj6pEnY4gtloTke9v" +
           "apQgUiVvKDSDRrARcbzXR8mCSxZ4xIpNA16LZHuhjvrNKuUvWqQ1WzB1bFHy" +
           "lspI46vlattupbKvzJtcYbYpbPp0E1UoUyb4pixy45nfxHyhS+hrQwkYfIGN" +
           "ZmETZzdGtKiqQ2rALptdik1KQ89q0IiM1utpv6V05Zo16nY5VdSdQV+aV22C" +
           "qafjSns5YNFGa7DRqfrQxfh5KzBxVJF6zLrri71meSOYBCfM4+ogZA19iNd7" +
           "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" +
           "Zmheo6Z5ZMwPnn3xe9+8/YHn8vrGaVWJtuqfLAZfXes9VsLNdbvtwFq3QVuT" +
           "ne5vrbX9jaHF/2uFTQmCCI5SUw39ZaSHcN+f6pyl2XoI+OnOflnvJz/pauu2" +
           "fR+f2lskB+dWT65OQXnUvPvlFvYBiJx1dM/cFk2XWfPOYHXA/0SN4e7DI0zM" +
           "8T09K3Ts923re5a/e/C/AdC5uqak3lbSfLJXHNZHaxYfvEHfr2bN+2PojJZJ" +
           "ulXsBuRPraADC2zNcN3bnD69Aa+ns2YBzBWEupbXRfWDcui1luPp1Lemh3gd" +
           "vtwJ5bHqRQw9cMP6675/Cq+gogtg4b6r/lGy/ReE9twzF87d+8zor7arev+f" +
           "CrfQ0DkjcZyjBYEj12eBJQwrN84t2/JAkP/8dgw9eGO5gAPz31yN39qO+kQM" +
           "3Xe9UQDcQHuU+pMgNq9FDShBe5TyMzF08SQlmD//PUr3XAydP6QDK2h7cZTk" +
           "9wB3QJJdfj7YdwHzSorqTSeYKVyoX9exq1PH99uD+Lnr5eLnyBb92DH0z/9s" +
           "tL8PJtu/G13Rnn+m13/HS/VPbOu9mqNsNhmXcwCot6Xng730kety2+d1lnji" +
           "R3d87pbH9zf9O7YCH+5wR2R76NpVVtwN4rwuuvmje//gTb/7zLfz+sn/AknW" +
           "GbcFJgAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "qFvTzJq75AXmeU1jDHOCUeR/AefoWAWsGgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "L5ihJAd4YNyktHlszHef+sa3v/LC+58uahxnF3K4E/90TfjGku+JSm4h252H" +
           "2roT2qns7GCnrd1vBPn/r4U22fNCONwYi8BNQi2AB66q8aay1gLAT7MOqns/" +
           "+knTndkObHzmepAcnl09lp6BCq95+3MF9iGInAfvbMaudprkzVu99JD/qTrD" +
           "i46OMVuW62h5seOgb1fjM939w78PgM70pit1distJnvebn28bvHeZ+n75bx5" +
           "dwSdU/KV7gR7FvLHU+hQAzs13PK2oN88C68n8sYH6vICTSnKo9phVfRm4Xh2" +
           "45rqEV4Hz3VKeaKCEUEPPVcZ9sBEpedR2wXIcO8N/y3Z/R9CefrJSxde9uT4" +
           "a7vAPvjPwh0MdEGPLet4XeDY9XmgDN0s9HPHrkrgFT+/GUEPPPu6gA2L30KM" +
           "39iN+kgE3XurUQDfQHuc+qPAPW9GDShBe5zydyPo8mlKMH/xe5zu6Qi6eEQH" +
           "gmh3cZzk9wB3QJJffso7MAH7fMrruOUtZT7Qbmnb9MzJLffQhe55Lhc6tks/" +
           "fGIDKP52dLAVxrs/Hl1TPvFkb/CW79U/siv7KpacZTmXCwCrdxXow+30lbfk" +
           "dsDrPPXID+765B2vPtj379ot+GiTO7a2B29ebO3YXlSUR7M/fNnvv+G3n/x6" +
           "UUb5X/0/KFUPJgAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "JHOeMeL/AHsomDzvGwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ZrVU5GSh3tDUtOsiq/HAFXgNJB/gYPCud2VHhuuv7dR2b35APbqyAIe17AX7" +
           "Gk4r6a0n3NtNuCuL5aWOe09Xv4+XxXZFECg7mD18uwuK/FD2qQ/deFHrfrq4" +
           "d1A8moJz+MG90Y5PdjJ+2+1Pn+38cmZX0fjyh/7loeG7rfe+hiruo6cWeZrl" +
           "77Zf+ir1VvU39qCzR/WNm66NTg66drKqcTHSk0XkD0/UNh4+UuulTF0oUCd3" +
           "oFb21pXUWxrqTG6orT+cKsydPahGHRQr7jtV2xuAY/62TrQ6JHn4FIkU2UlW" +
           "h9yS5pMsX6X69/7sMU+gi2Gkq3kFf1s6Fo854QQcqJeBre28M/pJZ+kTdbYE" +
           "unLz9cDh+uHXcMsA/OrBm245tzdz6udevHThgRfFv86L6ke3Z3fx0AVj4brH" +
           "61XH2ueB1IadK+KubfUqzH+eS6BHXn1dCXQu/83FeHY76sMJ9ODtRiXQWfA8" +
           "Tv18Ar3xVtSA8lA9B5S/nkCXT1OC+fPf43Q3gBl3dCAyt43jJB8H3AFJ1nwh" +
           "PDRB87Vc9OBuaMm9SD9tz/TMSSQ58pUrP8lXjoHPkydQI7/3Pozwxfbm+7r6" +
           "+RfZzvteqX56ewuhuvJmk3G5wEN3bi9EjlDi8dtyO+R1nn7qR/d84a63HMLZ" +
           "PdsF72L32NoevXXtv+WFSV6t3/zhA7//zt9+8Vt5Ve9/AaOPRMOQIAAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ye2wUxxmfO7+N3wTj8DBgGyQevSskKa1MU4x5HZzx1SZU" +
           "OTc57+3N+Rbv7S67c/ZhSglEDVYqoSiQlKTBqhqSNohA1DZKH4JS9ZEgmiBo" +
           "1IbQhib5I0kJEvzROC1t029mdm8fd+eUPxpLnt3b+eab+b7vN7/vmzl+DZUZ" +
           "OmrTBCUhBMhODRuBCH2PCLqBE92yYBhb4WtMfPjtg3sm/1C114/Ko6guJRg9" +
           "omDg9RKWE0YUzZUUgwiKiI0tGCfoiIiODayPCERSlSiaIRmhtCZLokR61ASm" +
           "AtsEPYwaBUJ0KZ4hOGQqIGhemK0myFYT7PIKdIZRjahqO+0Bs1wDuh19VDZt" +
           "z2cQ1BDeLowIwQyR5GBYMkhnVkdLNVXeOSSrJICzJLBdvst0xKbwXXluaHuh" +
           "/qObj6QamBumC4qiEmai0YcNVR7BiTCqt7+uk3Ha2IG+iUrCaJpDmKCOsDVp" +
           "ECYNwqSWvbYUrL4WK5l0t8rMIZamck2kCyJogVuJJuhC2lQTYWsGDZXEtJ0N" +
           "Bmvn56y1wu0x8bGlwUPfub/hRyWoPorqJaWfLkeERRCYJAoOxek41o2uRAIn" +
           "oqhRgYD3Y10SZGnMjHaTIQ0pAskABCy30I8ZDetsTttXEEmwTc+IRNVz5iUZ" +
           "qMxfZUlZGAJbm21buYXr6XcwsFqChelJAbBnDikdlpQEw5F7RM7Gjs0gAEMr" +
           "0pik1NxUpYoAH1ATh4gsKEPBfgCfMgSiZSpAUGdYK6KU+loTxGFhCMcIavHK" +
           "RXgXSFUxR9AhBM3wijFNEKVZnig54nNty6oDu5SNih/5YM0JLMp0/dNgUKtn" +
           "UB9OYh3DPuADa5aEHxeaT437EQLhGR5hLvPSN26sXtZ65hUuM7uATG98OxZJ" +
           "TDwar7swp3vxl0roMio11ZBo8F2Ws10WMXs6sxowTXNOI+0MWJ1n+n537wPH" +
           "8FU/qg6hclGVM2nAUaOopjVJxvoGrGBdIDgRQlVYSXSz/hCqgPewpGD+tTeZ" +
           "NDAJoVKZfSpX2W9wURJUUBdVw7ukJFXrXRNIir1nNYRQE/yjmQj5tyP2x58E" +
           "ycGUmsZBQRQUSVGDEV2l9tOAMs7BBrwnoFdTg3HA//DnlgdWBg01owMgg6o+" +
           "FBQAFSnMO9k+FUZJUEoDGIL92zZ0g4nUCThAUad9xvNlqf3TR30+CM0cLzHI" +
           "sKc2qnIC6zHxUGbNuhsnYuc46OhGMT1H0AaYNMAnDbBJGY3CpAE2acA5aUdI" +
           "yb2bjBILbdkai3R1b0Y+H1vHbXRhHB4Q3GGgCeDpmsX9920aHG8rAVxqo6UQ" +
           "GSq6KC9vddt8YiWBmHj8Qt/k+Verj/mRHygnDnnLTh4druTBc5+uijgB7FUs" +
           "jVhUGiyeOAquA505PLp3257Ps3U48wFVWAZURodHKIvnpujw8kAhvfX73//o" +
           "5OO7VZsRXAnGyot5IynRtHmj7jU+Ji6ZL7wYO7W7w49Kgb2AsYkAOwzIsNU7" +
           "h4twOi3yprZUgsFJVU8LMu2yGLeapHR11P7C4NjI3m+DEFfSHdgOW1E2tyR7" +
           "0t5mjbYzOXwpZjxWsOTw5X7tyBuvfXAHc7eVR+odBUA/Jp0O7qLKmhhLNdoQ" +
           "3KpjDHJ/ORw5+Ni1/QMMfyDRXmjCDtpSfEMIwc3femXHpStvHX3dn8Msyrpt" +
           "q5zCNgpvexlAeTLQAAVLxz0KgFFKSkJcxnRv/Kt+4fIXPzzQwMMvwxcLPcs+" +
           "XYH9/fY16IFz90+2MjU+kaZc21W2GOfx6bbmLl0XdtJ1ZPdenPvEy8IRyAjA" +
           "woY0hhmx+pnpfmZ5C0G3s5E2PYBmVadFIUtjd7KQ3sGEA6xdQf1ieo/+Xkmb" +
           "DsO5Ndy7z1FBxcRHXr9eu+366RvMKHcJ5kRCj6B1cvDRZmEW1M/00tBGwUiB" +
           "3J1ntny9QT5zEzRGQaMItGv06kCSWRduTOmyijd/9evmwQslyL8eVcuqkFgv" +
           "sC2IqgD72EgBv2a1r6zmIBilqGhgpqI846nb5xUO6Lq0RlgIxn468yerfjDx" +
           "FoMcB9tsJ/IWsXYxbZbxsBAoJzNxqMzhxWCVno1RNrDRmxKdGHVNoKO5xaoW" +
           "VnEd3XdoItH7zHJeWzS5K4F1UOg+/8d//z5w+K9nCySZcrPqtCek/L8gj/97" +
           "WEVnc9fKi5Mllx9tqcmnfqqptQixLylO7N4JXt73t1lb704N3gKnz/N4yavy" +
           "uZ7jZzcsEh/1s6KU03leMese1On0F0yqY6i+FWoW/VLLoN2Wi2s9jVcPCz6P" +
           "q1aYVwsixkdf13qIrM5SUkCZZy9PY1qmsQ3siB5lgP5M3CARXUoDHY+YRevJ" +
           "5skdv6kYW2sVpIWGcMnNRs/5n298L8YiUUlDnbPfEeYufciRaxq4GZ/Anw/+" +
           "/0P/6fLpB17+NXWbNej8XBGqaRTri6c4NbpNCO5uujL81PvPcxO8RbpHGI8f" +
           "eviTwIFDfA/wk0x73mHCOYafZrg5tBnIsp0xxSxsxPr3Tu7+xQ937/ebvBoi" +
           "qEQyD5k0Tr7cLmv2Op2vtHz5kX/seeiNXigLQqgyo0g7MjiUcAOxwsjEHVGw" +
           "jz42LM01U48T5FsCzqUfogY9qRYKNks3fAU/m/7Bj88OVlziji0MJ88Z6J1d" +
           "576v/vmq37L63hyO60yyQyYX8ydB0v+lHh/CahpUkFQYK0MkZRX/n91kFCQL" +
           "i0PY4eWJZ9tf2zPR/jZLeJWSAUQJm6jAGdUx5vrxK1cv1s49wUrGUroXTQS4" +
           "D/f5Z3fXkZxFqJ42wyYo8sE5Py8FsDspm00/vPzdd385+XQFB8kUu9YzruWf" +
           "vXJ83zsf51UOjNgLbGTP+Gjw+FOzuu++ysbbVTMd3Z7NP22BV+2xK46l/+5v" +
           "K/+tH1VEUYNo3v9sE+QMrUWj4DfDuhQKo1pXv/v+gh/WO3NpZI6XSRzTeut1" +
           "5z4uJa4928hj4kOM4YuVFixREFAqKYLMxg1AIpcZBumvQdpoZpmyIr9S5DUm" +
           "tQMKCVXBtFy1+vghUVIDuasn6Mzm4YP+7rEBpPGV0mYrW88UdeZDU/SN0+ZB" +
           "ME2k6+JmTCH+beam1Y6azmen0iSHdq7ZXvQnE/zaFPMcoM1XwXGajkV2zMa5" +
           "0zUbcJ+ZH+hDIKh0RJX4Vvsibfp4R+f/Vo1ykwiaPcWR3orW0lu4IoA93ZJ3" +
           "Rcmv1cQTE/WVMyfu+ROnFevqqwbSfTIjy068Ot7LwRtJiTmohqOXp5gn4QA7" +
           "9bogwOzJzHiCjzpCUEuxUZBBoXVKfw+QWkgaJKF1Sj5NUINXEuZnT6fcswRV" +
           "23Kwn/iLU+Q50A4i9PWYZoWg51ZuabpkLSVEdFw0sFlf/tmCYWjGp2HIcVpo" +
           "d3Exu722sneG319D+TexacuuG194hp/hRVkYG6NapkGm4NcJuap6QVFtlq7y" +
           "jYtv1r1QtdDK/Y18wXatO9uxl2D9Po0euWZ5TrpGR+7Ae+noqtOvjpdfBIof" +
           "QD7YUNMH8rk3q2Wg5B8IFyqigH3ZIbyz+t3B8x+/6Wti5zYzs7VONSImHjx9" +
           "OZLUtCf9qCoEOFUSOMsSw9qdSh8WR3RXTVYeVzNKLu3W0Z0j0Jtt5hnTobW5" +
           "r/QOiKC2/Koz/14MjrSjWF9DtZsZ3nUOyWias5d5FnMS4tVVSSzco2lmuV32" +
           "EvO8pjFyOcXY8b/YRmv8ohoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "OFb6XP0lAAA=");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwUxxWfu7ON7Rh/gT8CwYA5kAz0tjShtDJtAIPB9Iyv" +
           "NiGtaXLM7c75Fu/tLruz9tnUIURKQZFK09hJaVX8F1HbiISoatRIVZCrSk2i" +
           "NI2gUZsPNWnVP5p+IIV/Qivapm9mdm/39s5O+acn3d7e7Jv35r33m997s5eu" +
           "o2rbQt0m1hWcoFMmsRMpdp/Clk2UPg3b9mEYTcuP/XH21M3f1J2OoppR1JjD" +
           "9qCMbdKvEk2xR9EaVbcp1mViHyJEYTNSFrGJNYGpauijqE21B/KmpsoqHTQU" +
           "wgSOYCuJWjCllppxKBlwFVC0NslXI/HVSLvDAr1J1CAb5pQ/YVXJhL7AMyab" +
           "9+3ZFDUnj+MJLDlU1aSkatPegoW2mIY2NaYZNEEKNHFc2+4G4mBye1kYup9v" +
           "+ujW47lmHoYVWNcNyl20h4ltaBNESaImf3SfRvL2CfQQiiXRHQFhiuJJz6gE" +
           "RiUw6vnrS8HqlxPdyfcZ3B3qaaoxZbYgitaXKjGxhfOumhRfM2iopa7vfDJ4" +
           "u67orZfukItPbpHmvvNg849jqGkUNan6CFuODIugYGQUAkryGWLZuxWFKKOo" +
           "RYeEjxBLxZo67Wa71VbHdEwdgIAXFjbomMTiNv1YQSbBN8uRqWEV3ctyULn/" +
           "qrMaHgNf231fhYf9bBwcrFdhYVYWA/bcKVXjqq5wHJXOKPoY/xIIwNRleUJz" +
           "RtFUlY5hALUKiGhYH5NGAHz6GIhWGwBBi2NtEaUs1iaWx/EYSVPUGZZLiUcg" +
           "VccDwaZQ1BYW45ogS6tCWQrk5/qhnedO6gf0KIrAmhUia2z9d8CkrtCkYZIl" +
           "FoF9ICY2bE4+hdtfOhtFCITbQsJC5qdfv7Fra9fCK0JmdQWZocxxItO0fDHT" +
           "ePWuvp7Px9gyak3DVlnySzznuyzlPuktmMA07UWN7GHCe7gw/MuvPvwM+VsU" +
           "1Q+gGtnQnDzgqEU28qaqEWs/0YmFKVEGUB3RlT7+fAAtg/ukqhMxOpTN2oQO" +
           "oCqND9UY/D+EKAsqWIjq4V7Vs4Z3b2Ka4/cFEyHUCl/UgVD0m4h/xC9FmpQz" +
           "8kTCMtZV3ZBSlsH8ZwnlnENsuFfgqWlIGcD/+Ke2JXZItuFYAEjJsMYkDKjI" +
           "EfGQ71M8SSU1D2CQRo7s7wMXWRBIgqHO/D/bKzD/V0xGIpCau8LEoMGeOmBo" +
           "CrHS8pyzZ9+N59KvCdCxjeJGjqJ7wWhCGE1wo5xGwWiCG00EjcaHHFr841IK" +
           "ikS4/ZVsQQIWkNRxoAfg54aekQcOHjvbHQM8mpNVkBEmuqmsXvX5POKRf1q+" +
           "dHX45huv1z8TRVGgmgzUK79oxEuKhqh5liETBVhrsfLhUai0eMGouA60cH7y" +
           "9JFTn+brCNYBprAaKIxNTzH2LpqIh/d/Jb1NZz746PJTM4bPBCWFxauHZTMZ" +
           "wXSHsx12Pi1vXodfSL80E4+iKmAtYGqKYWcBCXaFbZQQTa9H2syXWnA4a1h5" +
           "rLFHHtPW05xlTPojHIYt/H4lpLiW7bzVsAW/5W5F/suetpvs2iFgyzAT8oIX" +
           "hS+MmBfe+vVf7ubh9upHU6DwjxDaG+AspqyVs1OLD8HDFiEg9/vzqdknr585" +
           "yvEHEhsqGYyzK4M1pBDC/OgrJ95+/72Lb0aLmEWFUt9ql/CNwdtfBlCdBtuf" +
           "gSV+nw5gVLMqzmiE7Y1/NW3c9sLfzzWL9Gsw4qFn6ycr8Mfv3IMefu3Bm11c" +
           "TURmpdYPlS8m+HuFr3m3ZeEpto7C6WtrvvsyvgCVANjXVqcJJ9Qodz3KPe+k" +
           "6E4+06cF0GxYrBnk5esentK7uXCCXz/D4uJGj/3fwS5xO7g1SndfoHNKy4+/" +
           "+eHyIx9eucGdKm29gkgYxGavAB+7bCyA+o4wDR3Adg7k7lk49LVmbeEWaBwF" +
           "jTLQrT1kATkWSnDjSlcve+fnv2g/djWGov2oXjOw0o/5FkR1gH1i54BXC+a9" +
           "uwQIJhkqmrmrqMx5Fva1lRO6L29SnoLpFzt+svMH8+9xyAmwrQ4ibxO/9rDL" +
           "VpEWCm2kk4GOHG5s3uH5GOUTW8KlMIjREgMWWrNYt8I7rYuPzM0rQ09vEz1F" +
           "a2kHsA8a3Gd/++9fJc7/4dUKxaXG7TZ9g4z/15fx/yDv5Hzu2nHtZuzdJzob" +
           "yqmfaepahNg3L07sYQMvP/LXVYe/mDt2G5y+NhSlsMofDV56df8m+Ykob0YF" +
           "nZc1saWTeoPxAqMWga5bZ26xkeUc2t3FvDaxfG2HfM65eZ2tzKsVERNht3tD" +
           "RNboKamgLLSXY1xLzKODthAdDGMbGmz28CueyJqQyP2WShl1CVG+1vuXIIwH" +
           "2OXLFNWbFpF5z0EAOj1LHPYsNQ8FYcJtl6WZ1vfHv//BswK24d46JEzOzj32" +
           "ceLcnICwOIBsKDsDBOeIQwhfabMI6sfwicD3P+zL3GADoglt7XM74XXFVtg0" +
           "C3wnLLEsbqL/z5dnfvbDmTNRNywDFFVNGKo49XyOXYZFUnv/NzZiA7uga1tR" +
           "oZXzMrflNlpCcKKz7EgqjlHyc/NNtR3z9/2OdyDFo04D1O6so2kB4Ac3QQ3k" +
           "O6tyXxsEt5v8x4DGZel1UVTNf7kbupgF7U7nYrMoisE1KO1QtLKSNEh64XEl" +
           "IYLNYUmwz3+DcicBwL4cEKK4CYo8BNpBhN2eMr0U7L2drny3Zuag/SXhfBYi" +
           "5aWEQ6btkyATKA4bSnYcf0nhEaAjXlOk5cvzBw+dvPHZp0XLJmt4epofauGM" +
           "LrrHIomuX1Sbp6vmQM+txufrNnqAbxEL9qltdYAkYP0Rk1XYVaHGxo4X+5u3" +
           "L+688vrZmmuwt4+iCAboHw28IhDnYeiOHGD4o8lgZQq86uI9V2/9n4698Y93" +
           "Iq28TLu1rGupGWl59sq7qaxpfi+K6gYAnrpCCqOoXrX3TunDRJ6AhqLW0dUT" +
           "DhlQAPoZw9GL7zMa2YbB7AUGj4wb0OXFUdbyU9RdzlLlxyDoYCaJtYdp54Ul" +
           "VHYc0ww+LbBzfgWvIDfbLvzz1DfeGoINXbLwoLZltpMpVrDg6xK/pDWzi1wQ" +
           "3BhLJwdN0+XK6hd5Vk2T89Qsd/rbQppJwGFzs2n+F3Z9JWP2FAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "LcWwr+ouj9qMgHKiMOcIosPRpIwWylTZbm5UZClEXj0uRAu+jFk27QpTnpO5" +
           "jYUWjbIVik2OGImMrZVG2jBmUVwbDExzNqQHpGFG7XZa1YmhOVlXY8cf1eiV" +
           "lfSVjSbPS83SShTdZC4Jugk82FlQiaH1ItsYal3UdD0Ri7VWuxxVMdefa9GS" +
           "CfuSR9txzOm1cn2xopYTTnSqOBn1WkykC9Rg0lj6G4pn51HCk51Ozx0KKrFI" +
           "mmwyd6sYL2LIVKIVYq3oTGNGLiTX7o5NLkaEwUhqcrVouOKJaUkONxPWgVd+" +
           "V6R1TkNLiGYIWl1qrmWfVAxhKvANWJI709litaqs6fas1+m7ApwwzJobWuqk" +
           "nQ5DcmIJFaPBTjomZQh0haMadFqlGIOn1s2miXIhIU4CxBT5BCaE0bQ/oeZz" +
           "1pzI+lSWW2txPkCaAl+uuPqoGuL8wF9W4JXhqEqvqmvFDuM3bGNiimhaV2r4" +
           "0g/xpTBnLNIl6wwuoBJRLhhKqPWMkMSZsTQI2nhlpWgxRvpiXcM7xbatDPi5" +
           "KycJE/aKWoseq30+ij2sn9T1jbgstaaWsxmlqRNtUqsfLUO72yhiE57DKBpX" +
           "MX0Nd6O4H6+7hWkwQQYFnQqdgdNK9RUxQWsrcUXwAVwUbLIzJahJszS0xlhB" +
           "azRCHY6WK6Ob9Lwxh7qDnouvuFZ9IsCtAtFpBCueWazKU2walOclCe2IZVgm" +
           "iQ09wS14ok9bRbtswAleJ21vkNaWY7wbzqeleXNkBXRtvnYsh+CCiNT0FW8x" +
           "lNyCCx0Vbc/mTBiRQoNYtIOusGx1FgyhUQMM6dZGownSQvHB0MUCbN2d8cMm" +
           "o6/oHtyCpU7agqfFhGI8XIxqLOF2KbVnN13cp0c1b5PO6wWuUu/EuIInC7VN" +
           "LVZtbM0bOEUga7eSUGvexKlikVjIIk2Tfq2MMB1zOSrD82kwGDD8khsmbkPT" +
           "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");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "b5ecYp7XNMYupxk9/hfBgGFHpBoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/C8LjBM1AyYAAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "5JK+5IuDQZF3DZzRrH5HIwrw1BmtMSaadSRRnwvgZPDO7Mhw7bWd2u7MD6hH" +
           "lxbgsJa96LyG00py4wH3dgPuymJ5qePO0/Xv42WxXREEyg5mD97siiI/lH3i" +
           "6edfVNlPFvcOikcSOIcf3Bzt5GQn47fe/PTZy69ndhWNLz79L/fz7zLe8xqq" +
           "uA+fUvK0yN/vvfTl9luU39qDzh7VN667ODrJdPVkVeNioEWrwOVP1DYePHLr" +
           "pcxdFeDObx249e9vXEm94USdySdqGw+nCnNnD6pRB8WKu0/V9obgmL+tE8WH" +
           "JA+eIhkHZpTVIbek+SDrV6n+vS9rlhF00Q80Ja/gb0vHwrEgnIID9doz1V10" +
           "Bj/tLH2izhZBb7zRBcGhBfBruGkAkXXfdTed29s55TMvXrpw74vC3+Rl9aMb" +
           "tNsY6IK+su3jFatj/fPAbt3MXXHbtn7l5z/PRtBDr65XBJ3Lf3MzntlyfTCC" +
           "7rsZVwSdBe1x6ueAY25EDSgP3XNA+ZsRdPk0JRg//z1O9zyYyB0dWJvbznGS" +
           "jwLpgCTrvuAfTkHjNV322L4hc4F2ej6TMyex5Cha7vpp0XIMfh4/gRv53ffh" +
           "Gl9tb7+vKZ99sdN/7yvVT27vIRQb5POZlAsMdOv2SuQIJx69qbRDWeepJ358" +
           "x+due/MhoN2xVXi3eo/p9vCNq/9Nx4/yen36x/f+4Tt+98Vv53W9/wU5r3Iw" +
           "lCAAAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "wV32CvO8pjF6Ocn48b8RlrLaphoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AUX9vCwFJgAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Yb2wUxxWfu7ON7Rj/A/8JBAPmQDLQu7gJpZVpAxgMpmd8" +
           "tQlJTZNjbnfOt3hvd9ids8+mDiFSCsoHlAYnpVXxJ6K2EQlR1aiV2iBXlZpE" +
           "aRpBozZ/1KRVPzT9gxS+hFa0Td/M7N7u7Z2d8qUn3d7e7Jv35r33m997s5eu" +
           "o2rbQt0UGyqOsWlK7FiS3yexZRO1X8e2fQhGU8oTfzx38uZv6k6FUc0Yasxi" +
           "e0jBNhnQiK7aY2iNZtgMGwqxDxKi8hlJi9jEmsRMM40x1KbZgzmqa4rGhkyV" +
           "cIHD2EqgFsyYpaXzjAw6ChhamxCriYvVxHcFBfoSqEEx6bQ3YVXJhH7fMy6b" +
           "8+zZDDUnjuFJHM8zTY8nNJv1FSy0hZr69LhushgpsNgxfZsTiAOJbWVh6H6x" +
           "6eNbT2abRRhWYMMwmXDRHiG2qU8SNYGavNG9OsnZx9EjKJJAd/iEGYomXKNx" +
           "MBoHo66/nhSsfjkx8rl+U7jDXE01VOELYmh9qRKKLZxz1CTFmkFDLXN8F5PB" +
           "23VFb910B1x8ekt87lsPN/8wgprGUJNmjPLlKLAIBkbGIKAklyaWvUtViTqG" +
           "WgxI+CixNKxrM062W21t3MAsDxBww8IH85RYwqYXK8gk+GblFWZaRfcyAlTO" +
           "v+qMjsfB13bPV+nhAB8HB+s1WJiVwYA9Z0rVhGaoAkelM4o+Rr8MAjB1WY6w" +
           "rFk0VWVgGECtEiI6NsbjowA+YxxEq02AoCWwtohSHmuKlQk8TlIMdQblkvIR" +
           "SNWJQPApDLUFxYQmyNKqQJZ8+bl+cMfZE8Z+I4xCsGaVKDpf/x0wqSswaYRk" +
           "iEVgH8iJDZsTz+D2l8+EEQLhtoCwlPnx12/s3Nq18KqUWV1BZjh9jCgspVxM" +
           "N169q7/nCxG+jFpq2hpPfonnYpclnSd9BQpM017UyB/G3IcLI7/86qPPkb+F" +
           "Uf0gqlFMPZ8DHLUoZo5qOrH2EYNYmBF1ENURQ+0XzwfRMrhPaAaRo8OZjE3Y" +
           "IKrSxVCNKf5DiDKggoeoHu41I2O69xSzrLgvUIRQK3xRB0KRHiQ+8pchPZ41" +
           "cySOFWxohhlPWib3nydUcA6x4V6Fp9SMpwH/E5/pjW2P22beAkDGTWs8jgEV" +
           "WSIfin2Kp1hcywEY4qOH9/WDizwIJMZRR//P9grc/xVToRCk5q4gMeiwp/ab" +
           "ukqslDKX3733xgup1yXo+EZxIsfQfWA0Jo3GhFFBo2A0JozG/EajD5pW8Y9D" +
           "KSgUEvZX8gVJWEBSJ4AegJ8bekYfOnD0THcE8EinqiAjXHRTWb3q93jEJf+U" +
           "cunqyM0336h/LozCQDVpqFde0YiWFA1Z8yxTISqw1mLlw6XQ+OIFo+I60ML5" +
           "qVOHT94t1uGvA1xhNVAYn57k7F00EQ3u/0p6m05/+PHlZ2ZNjwlKCotbD8tm" +
           "coLpDmY76HxK2bwOv5R6eTYaRlXAWsDUDMPOAhLsCtooIZo+l7S5L7XgcMa0" +
           "cljnj1ymrWdZy5zyRgQMW8T9SkhxLd95q2ELbnW2ovjlT9spv3ZI2HLMBLwQ" +
           "ReGLo/TC27/+yz0i3G79aPIV/lHC+nycxZW1CnZq8SB4yCIE5H5/Pnnu6eun" +
           "jwj8gcSGSgaj/MphDSmEMD/+6vF3Pnj/4lvhImZRodS32iV84/D2lgFUp8P2" +
           "52CJ3m8AGLWMhtM64XvjX00be1/6+9lmmX4dRlz0bP10Bd74nbvRo68/fLNL" +
           "qAkpvNR6ofLEJH+v8DTvsiw8zddROHVtzbdfwRegEgD72toMEYQaFq6Hheed" +
           "DN0pZnq0AJpNizeDonzdK1J6jxCOietneVyc6PH/2/klavu3Runu83VOKeXJ" +
           "tz5afvijKzeEU6Wtlx8JQ5j2SfDxy8YCqO8I0tB+bGdB7t6Fg19r1hdugcYx" +
           "0KgA3drDFpBjoQQ3jnT1snd//ov2o1cjKDyA6nUTqwNYbEFUB9gndhZ4tUDv" +
           "2ylBMMVR0SxcRWXO87CvrZzQvTnKRApmftLxox3fm39fQE6CbbUfeZvEtYdf" +
           "tsq0MGgj82noyOHGFh2eh1ExsSVYCv0YLTFgoTWLdSui07r42Ny8Ovxsr+wp" +
           "Wks7gL3Q4D7/23//Knb+D69VKC41TrfpGeT8v76M/4dEJ+dx1/ZrNyPvPdXZ" +
           "UE79XFPXIsS+eXFiDxp45bG/rjr0pezR2+D0tYEoBVX+YOjSa/s2KU+FRTMq" +
           "6bysiS2d1OePFxi1CHTdBneLjywX0O4u5rWJ52sb5LPXyevdlXm1ImJC/HZP" +
           "gMgaXSUVlAX2ckRoibh00BaggxFsQ4PNHz7oiqwJiDxgaYxTlxQVa31gCcJ4" +
           "iF++wlA9tYgieg4C0OlZ4rBnaTkoCJNOuxyfbf1g4rsfPi9hG+ytA8LkzNwT" +
           "n8TOzkkIywPIhrIzgH+OPISIlTbLoH4CnxB8/8O/3A0+IJvQ1n6nE15XbIUp" +
           "LYidsMSyhImBP1+e/en3Z0+HnbAMMlQ1aWry1PN5fhmRSe3739iID+yErm1F" +
           "hVbOzdyW22gJwYnOsiOpPEYpL8w31XbM3/870YEUjzoNULszeV33Ad+/CWog" +
           "3xlN+NoguZ2KHxMal6XXxVC1+BVuGHIWtDudi81iKAJXv3SeoZWVpEHSDY8j" +
           "CRFsDkqCffHrlzsBAPbkgBDljV/kEdAOIvz2JHVTsOd2uvJdOs1C+0uC+SyE" +
           "ykuJgEzbp0HGVxw2lOw48ZLCJcC8fE2RUi7PHzh44sbnnpUtm6LjmRlxqIUz" +
           "uuweiyS6flFtrq6a/T23Gl+s2+gCvkUu2KO21T6SgPWHKK+wqwKNjR0t9jfv" +
           "XNxx5Y0zNddgbx9BIQzQP+J7RSDPw9Ad5YHhjyT8lcn3qkv0XH31fzr65j/e" +
           "DbWKMu3Usq6lZqSUc1feS2Yo/U4Y1Q0CPA2VFMZQvWbvmTZGiDIJDUVt3tCO" +
           "58mgCtBPm3mj+D6jkW8YzF9giMg4AV1eHOUtP0Pd5SxVfgyCDmaKWLu5dlFY" +
           "AmUnT6n/aYGf8yt4BbnpvfDPk994exg2dMnC/dqW2fl0sYL5X5d4Ja2ZX5SC" +
           "5MZIKjFEqcOV1T8TWaVU8NQ54fQ3pTSXgMPmZkr/C2gXQGf2FAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "6MNkqcsugB/8z56rfOgf/uMGI+S4c5Md+xS/hLz0yYeod30/598BQMb9SHoj" +
           "YoM0b8eLf9b7t70nzv/ZHnS7BF1WD3JIUXYXWVhJIG+KDxNLkGeeeH8yB9pu" +
           "+FePAO7Np8Hn2LCnoWe3U4B+Rp31Lx5Hm5+Azxnw/Z/sm5k7e7Ddee+hDrb/" +
           "x472/zBMz5xJoHP4fnkfzfifzqU8nrdXsuZntsuUgCx5obg2iKbzcZ7AAi7D" +
           "9mU3H7yaADdz1SuHI4ggoQXrcsVxy4fhcjl3qcwC+9sscAt5WUvkIrZuUbql" +
           "C13dUuV72107YWwAEsqP/ONHv/FrT34HrGsbOrfMbA6W89iI3UWWY//KSx97" +
           "+HXXv/uRHMfAzsd/nL78dCa1ewutsy6TNY2saR6q+lCmqpCnCKwcJ1yOQbqW" +
           "a/uq7sxHtgcQenmQQCLP3POd2Se/97ltcnjad08R689d/9Wf7D9/fe9YSv7k" +
           "DVnxcZ5tWp5P+vUHFo6gx19tlJyD+acvPPNHv/PMs9tZ3XMywaTB+elzf/Xf" +
           "39h/4btfu0nucpsb/B8WNrnzZ5uFuFU9/LDYVMFXozQdG4tyr1seOEgVIdu1" +
           "Ku/162x/UTbboSSG1dTkQk8jk77bHkpdR/GNXkJYS61iazEJe3WbEag4aLrV" +
           "qR+Kk7Rd6uB03x1gsi3idm3iSiEtD8JasJEQrDMQ+c2wYqYCbDEyOtQQrtwt" +
           "L8oSrpHzkU9oZb3cXhLFiCC8SqUcF/VFgEdKP0FHjfW8F4/dTpmxBWKtp9Kg" +
           "h01IHTf6VmNEBkNjkxLkQlqWZiVmpKJTOU5tHXVqXcvv252yPMXtrpSYXGM1" +
           "T+tpxyYtt21XHNqLBxxXQFOso0jmxpvLhahhzdai2mrWcXpuMvF6GsqTjVNd" +
           "lSjLkr2UiuzpUkybKlMzAmFO02lJ6RNTcdK2mmWDW5cUEt5I9frIdxZMu8mR" +
           "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" +
           "IAAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "3i45yTyvaYxd2Eviv0W1uUikGgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "7cwjOD94/qXvffO2B17IextnloK/Ff9kH/jqNu+x7m0u260H2roV2qrsDL3V" +
           "1vY3gNz/1+aa4Dg+7Efq0rNjX/Zg2pZkRhN12QP0ZGO/o/eTXzTZmm3fxqf2" +
           "guTgzOrp5BSUe817XimwD5LIOfC+pm77pXE2vNNJDuif6C/cdXh8iRu2JWdN" +
           "jv25bW9Ps3cP/jIAJpNrcmptOc0Xe9VufbRf8aEbzP1KNnwggM6KGadbwW4A" +
           "/kwCHWhgq4br3ubw0Q1oPZsNLlCX48li3hOVD1qh1wrHM5GtSYf52nul08lj" +
           "nYsAuv9Grdd98xReRS8XZIV7r/ovyfb/D+ILz108f89zk7/aBvX+fxRuHkDn" +
           "ldAwjvYCjlyfA4pQtFw3N287A07+81sB9OCN+QL2y39zMX5zi/XJALr3elgg" +
           "t4HxKPSngGteCxpAgvEo5O8F0KWTkGD9/Pco3AsBdOEQDgTQ9uIoyO8D6gAk" +
           "u/y8s28C6tW005uGsxIYT76uYZNTx7fbA/e585Xc58gO/dix5J//zWh/Gwy3" +
           "fzS6In72OZJ+x8u1T25bvaIhpGlG5TzI09uu88FW+sh1qe3TOtd9/Ee3f+7m" +
           "1+/v+bdvGT7c4I7w9tC1G6xt0wnylmj6R/f8wVt+57lv562T/wU6iL4p/yUA" +
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ya2xUxxWeXdvrBwY/wMbhYcAYJB7dLa+mkWmCMQ+brPHG" +
           "JlRZ2iyzd2e9F9+993LvrL04dQghKTQ/aBRMSptgqSqoLSIhqho1ahVK1UcS" +
           "pSmCRm0S1KRtfiRtghR+NE5L2/TMzL17H7s24ke60s7enTmPOXPO+c6Ze+4a" +
           "qjAN1KZjNYXD9IBOzHCMPcewYZJUl4JNcxfMJqTH/nL84OTvqw8FUSiOZmWw" +
           "2Sthk2yTiZIy42ihrJoUqxIxdxKSYhwxg5jEGMZU1tQ4apLNnqyuyJJMe7UU" +
           "YQS7sRFFDZhSQ07mKOmxBFC0KMp3E+G7iXT6CTqiqFbS9AMOwzwPQ5drjdFm" +
           "HX0mRfXRfXgYR3JUViJR2aQdeQOt0jXlwKCi0TDJ0/A+ZYN1EDuiG4qOoe25" +
           "uo9vPJ6p58cwG6uqRrmJZj8xNWWYpKKozpndqpCsuR89iMqiaIaLmKL2qK00" +
           "AkojoNS216GC3c8kai7bpXFzqC0ppEtsQxQt8QrRsYGzlpgY3zNIqKKW7ZwZ" +
           "rF1csNZ2t8/EE6si49+6v/5HZagujupkdYBtR4JNUFAShwMl2SQxzM5UiqTi" +
           "qEEFhw8QQ8aKPGp5u9GUB1VMcxAC9rGwyZxODK7TOSvwJNhm5CSqGQXz0jyo" +
           "rH8VaQUPgq3Njq3Cwm1sHgyskWFjRhpD7Fks5UOymuJx5OUo2Nh+NxAAa2WW" +
           "0IxWUFWuYphAjSJEFKwORgYg+NRBIK3QIAQNHmtTCGVnrWNpCA+SBEUtfrqY" +
           "WAKqan4QjIWiJj8ZlwRemufzkss/13ZuPPaA2q0GUQD2nCKSwvY/A5hafUz9" +
           "JE0MAnkgGGtXRp/EzS8eDSIExE0+YkHzk69d37S69eLLgmZ+CZq+5D4i0YR0" +
           "Ojnr8oKuFXeUsW1U6ZopM+d7LOdZFrNWOvI6IE1zQSJbDNuLF/t/c99DZ8kH" +
           "QVTTg0KSpuSyEEcNkpbVZYUY24lKDExJqgdVEzXVxdd7UCU8R2WViNm+dNok" +
           "tAeVK3wqpPH/cERpEMGOqAaeZTWt2c86phn+nNcRQo3wRXMRKjuE+Ef8UqRE" +
           "MlqWRLCEVVnVIjFDY/Yzh3LMISY8p2BV1yJJiP+hz60J3x4xtZwBARnRjMEI" +
           "hqjIELHI8xSP0IichWCIDOze3gUmskMgYRZ1+v9ZX57ZP3skEADXLPADgwI5" +
           "1a0pKWIkpPHc5q3Xn028KoKOJYp1chR1gtKwUBrmSjmMgtIwVxp2K23vNGSa" +
           "Kfy1QAUFAnwHc9iWRGCAW4cAIACha1cMfHXH3qNtZRCR+kg5+ISRLi+qWF0O" +
           "ktjwn5DOXe6fvPRazdkgCgLYJKFiOWWj3VM2RNUzNImkALemKiA2iEamLhkl" +
           "94Eunhw5tPvg5/k+3JWACawAEGPsMYbfBRXtfgQoJbfuyPsfn39yTHOwwFNa" +
           "7IpYxMkgps3vb7/xCWnlYvx84sWx9iAqB9wCrKYYcgtgsNWvwwM1HTZsM1uq" +
           "wOC0ZmSxwpZsrK2hGUMbcWZ4IDbw5zng4iqWewshCR+xkpH/stVmnY1zReCy" +
           "mPFZwcvClwb0U2/87m/r+HHbFaTOVfoHCO1woRYT1sjxqcEJwV0GIUD3p5Ox" +
           "4yeuHdnD4w8olpZS2M5GFtbgQjjmR1/e/+Y7b59+PViIWZT32lY1jW0svJ1t" +
           "ANgpAAAsWNrvVSEY5bSMkwphufHvumVrnv/wWL1wvwIzdvSsvrkAZ/62zeih" +
           "V++fbOViAhIrts5ROWQCwWc7kjsNAx9g+8gfurLw2y/hU1ALAH9NeZRwSA1x" +
           "00Pc8haKbuOcDjCAZM1g7SAvYOtNFvOurGYrA7mkSWOGnAU3DVtl7Hzz5P5f" +
           "VY5usUtUKRZBebfZe+mn3e8leBhUsexn80zZTFdedxqDrhisF376FD4B+P6X" +
           "fZl/2IQoCI1dVlVaXChLup6H3a+Ypo/0mhAZa3xn6On3nxEm+Mu2j5gcHX/s" +
           "0/CxceFk0dssLWov3DyivxHmsOEOtrsl02nhHNveOz/2sx+MHRG7avRW6q3Q" +
           "iD7zh//8Nnzyz6+UKAKQZBoWHepaBtEFoG72+0cYFVpz6p8Hv/5GHyBLD6rK" +
           "qfL+HOlJuaVCe2bmki6HOX0Tn3Cbx5wDVWQl+IFNfNEZ+P91fF/hwu6QlZLs" +
           "fzcb2k033nq952rIE9Ljr380c/dHF67zE/B29G546cW6OP4GNixjxz/XX9u6" +
           "sZkBuvUXd36lXrl4AyTGQaIEVdzsM6Dm5j1gZFFXVL71i182771choLbUA0c" +
           "eWob5riOqgFQiZmBcp3X79okkGWEQU09NxUVGc9yeVFplNia1SnP69EX5v54" +
           "4/cn3uY4JhBsPmcvN9lFwl+C+W3QqR4fXn3q3Z9Pfq9SxNM02eHja/lXn5J8" +
           "+K+fFB0yL5YlEsbHH4+ce3pe150fcH6najHupfniPgfqusO79mz2H8G20K+D" +
           "qDKO6iXr5rUbKzlWC+Jw2zDt6xjczjzr3puDaJM7ClV5gT9jXWr99dKdBOXU" +
           "E/AlSuRhq4wc9pfIAOIP93GW5WxYWVyEpuKmKDi0ppBHszljDxviIg6iUwbZ" +
           "wK1vcS8b9jCVa0upxJ+BSlJQua6UyvRnoHJfQeX6UiqHplEplpbzcQUbVvM0" +
           "DFIU0nNJRYaaHTL5Pd3pM3iaN/gvNO4+w8lnxCBq4VR3Tl4dTj88PpHqO7Mm" +
           "aAHnJlBpvQpw5AR4ofHjQi+/ZjtJdvuVybKrT7TUFnflTFLrFD33yqkBxK/g" +
           "pYf/Pm/XnZm9t9BuL/IZ7xf5w95zr2xfLj0R5G8KRE4XvWHwMnV4M7nGIDRn" +
           "qN4C1lZwVx1zwwZw0zctdx3zh5ETL0WBEGCP+3095ixbSAlhvopYxqWU2Z1a" +
           "k69T68cmFQD6iE2y0EfyZbjYsa5SkPK9Hp6m7H6DDWMU1egGkfh1UFwEOqx+" +
           "hf3cRVH5sCannBR58GZZ6SlwbOIeuF02lbx02oasuoXrK0R3S9HrM/HKR3p2" +
           "oq5q7sS9f+R3pcJrmVpoPNM5RXEjuus5BOanZX4itQLfRQdzAq5Y0+8LWi7+" +
           "y80YF1wnKWqZiouiMhjd1E9RNKcUNVDax2NRTlBU76cE/fzXTfdd8KdDB/gg" +
           "Htwkp0E6kLDHM7rtgi239AZB0TNwUSd+f+YDXjwrBE3TzYLGBYFLPRjDX6ja" +
           "eJATr1Th/jGxY+cD179wRlwuJQWPjjIpM6BhFffcAqYsmVKaLSvUveLGrOeq" +
           "l9mg2iA27GT6fFfO3AN5rrO2bZ7vCma2F25ib57eeOG1o6Er0PvsQQFM0ew9" +
           "xU1JXs8B4O2JlmrNAXH57bCj5t29lz55K9DIez8L2lun40hIxy9cjaV1/TtB" +
           "VN0D4ammSJ53TFsOqP1EGjY8nX4oqeXUwrvXWSxhMHvZyk/GOtCZhVn2coKi" +
           "tuJrT/ELG2iLR4ixmUnnOOtD4Zyuu1f5yW4RqMNOGuIzEe3Vdeu+V3GBn7yu" +
           "czR5gQ1b/wfoqWX+NRkAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1afawjV3WffZtsNkuS3QTyQUq+F6ow8ObL4w8FKGN77LFn" +
           "7LFnbI89bdmMxzOesef7wzM2DS3QFlSkkLZJSlXIX1BaFCBqS6lUUaWqWkCg" +
           "SlSoX1IBVZVKS5HIH6VVaUvvjN97fu/tbtKootZ713funHvuOfee8zv3nuvn" +
           "vwvdGAYQ7LnWem650b6WRvsLi9yP1p4W7rc5sqcEoTarWUoYDkDbFfXhFy5+" +
           "/wdPGZf2oHMy9FrFcdxIiUzXCQUtdK2VNuOgi7tW2tLsMIIucQtlpSBxZFoI" +
           "Z4bRYxz0mmNdI+gydygCAkRAgAhILgJC7ahAp1s1J7ZrWQ/FiUIfeg90hoPO" +
           "eWomXgQ9dJKJpwSKfcCml2sAOJzPnkdAqbxzGkAPHum+1fkqhZ+Bkad/7V2X" +
           "fucsdFGGLpqOmImjAiEiMIgM3WJr9lQLQmo202YydLujaTNRC0zFMje53DJ0" +
           "R2jOHSWKA+1okrLG2NOCfMzdzN2iZroFsRq5wZF6uqlZs8OnG3VLmQNd79rp" +
           "utWwkbUDBS+YQLBAV1TtsMsNS9OZRdADp3sc6XiZBQSg6022Fhnu0VA3OApo" +
           "gO7Yrp2lOHNEjALTmQPSG90YjBJB916XaTbXnqIulbl2JYLuOU3X274CVDfn" +
           "E5F1iaA7T5PlnMAq3XtqlY6tz3e7b3vy3Q7j7OUyzzTVyuQ/Dzrdf6qToOla" +
           "oDmqtu14y5u5Z5W7vvDBPQgCxHeeIt7SfP5nXnrnW+5/8Utbmh+7Bg0/XWhq" +
           "dEX9+PS2r72h9mjlbCbGec8NzWzxT2iem3/v4M1jqQc8764jjtnL/cOXLwp/" +
           "Nvm5T2nf2YMutKBzqmvFNrCj21XX9kxLC5qaowVKpM1a0M2aM6vl71vQTaDO" +
           "mY62beV1PdSiFnSDlTedc/NnMEU6YJFN0U2gbjq6e1j3lMjI66kHQdAd4B+6" +
           "G4LOvhfKP9vvCLIQw7U1RFEVx3RcpBe4mf7ZgjozBYm0ENRn4K3nIlNg/8u3" +
           "YvslJHTjABgk4gZzRAFWYWjbl7mfKkmEmDYwBkQcNWtAxWwStP3M6rz/5/HS" +
           "TP9LyZkzYGnecBoYLOBTjGvNtOCK+nRcpV/6zJWv7B05ysHMRRAFBt3fDrqf" +
           "D5qDKhh0Px90//igl6nAjIyjxwNQgc6cySV4XSbS1jDAsi4BQADovOVR8afb" +
           "j3/w4bPAIr3kBrAmGSlyfQSv7SCllQOnCuwaevEjyXtHP4vuQXsnoThTAzRd" +
           "yLr3MgA9AsrLp13wWnwvfuDb3//ss0+4O2c8ge0HGHF1z8zHHz494YGrajOA" +
           "mjv2b35Q+dyVLzxxeQ+6AQAHAMtIAcYNcOj+02Oc8PXHDnEz0+VGoLDuBrZi" +
           "Za8Owe5CZARusmvJLeG2vH47mOPzmfHfB7zg5w+8If/O3r7Wy8rXbS0nW7RT" +
           "WuS4/HbR+9hf//k/Efl0H0L4xWNBUdSix47BRsbsYg4Qt+9sYBBoGqD7u4/0" +
           "fvWZ737gJ3MDABSPXGvAy1mZ2RVYQjDNv/Al/2+++Y2Pf33vyGig9KRu519G" +
           "NzDIm3ZiALSxgAdmxnJ56NjuzNRNZWppmXH+58U3Yp/7lycvbZffAi2H1vOW" +
           "V2awa399Ffq5r7zr3+7P2ZxRs2i3m6od2RZCX7vjTAWBss7kSN/7F/f9+heV" +
           "jwEwBgAYmhstx7Rzuerncs3vjKDX5z13ngk4u0HHnWl5BEEA70dfZmMUmDZY" +
           "q9VBMEGeuOOby49++9PbQHE68pwi1j749C/9cP/Jp/eOhedHroqQx/tsQ3Ru" +
           "ZLduF+6H4HMG/P939p8tWNawheg7agdx4sGjQOF5KVDnoZcTKx+i8Y+ffeIP" +
           "f+uJD2zVuONkdKLB5uvTf/lfX93/yLe+fA3gA3btKvmCF3ZFLvJ+LvKjefnW" +
           "TMYDE8ye35YVD4TH8eXkXB/bAV5Rn/r6924dfe+PXsqHP7mFPO5OHcXbTtZt" +
           "WfFgpvvdp8GUUUID0BVe7P7UJevFHwCOMuCogrAR8gEA+fSE8x1Q33jT3/7x" +
           "n9z1+NfOQnsN6ALQd9ZQchyDbgYAooUGiA+p9xPv3HpSkrnWpVxV6Crltw54" +
           "T/5008vbWiPbAe5Q8J7/4K3p+/7+36+ahBy8r2F+p/rLyPMfvbf2ju/k/Xco" +
           "mvW+P7068IHd8q4v/in7X/cePvene9BNMnRJPdiKjxQrzrBJBtvP8HB/Drbr" +
           "J96f3Epu902PHUWJN5y2/2PDnsbvnd2Bekad1S9cD7LffwBr7z8N2WegvNLO" +
           "uzyUl5ez4sePmScZQXtL7MieL+VUb88KdruA77zuYtOvXpT+K4qCX0sU4Ucg" +
           "yvgVRSGuJcrkRyDKlVcUpXAtUR5/RVHy/umZMwC78P3SPpo969ce7GwEzpnx" +
           "1DJBNDoX5kfADPFMR7EOxbh7YamXD6F3BI6EwCUvL6zSYbi5lKNJZvz723PU" +
           "KXnJ/7W8AC1u2zHjXHAk+9A/PPXVDz/yTeDSbejGVeZuwJOPjdiNs1PqLz7/" +
           "zH2vefpbH8r3AWDn2HuWvvTOjGtwHa2z6iIrlllxpOq9mapivsnmlDDq5DFc" +
           "mx1pix3TpxSBnYD7f9A2uvUFphC2qMMPh00UPB2mqaSNZ6ugmkyQpDM1Jio1" +
           "aVdLM06B7aVk1zp9eBr0mGbbEmTcXG9muFZpVOBKheBWAYcWZv25wQ76iFIV" +
           "OqIXzX3RdzmxZfiGiynGiMWGquiJdk2wURFjhUg3hWhuCHCXJjkcGXQ2HFZi" +
           "SiFeWGpFNCxpzsDu8eMeD6tFWYMLir+guhgrL7qTcb3SqvIbptbpqVoykdtD" +
           "q9DuqqneafsDBnG4coEfrPyk3BiKJi/bUoKLkbHE1wNTbq0LuGkEbXfop610" +
           "lrLixEjSObmgmx15iEX9guJxXcdfx+t2u6OVhsNJXyyFQqNRlw2xj5ZslrfT" +
           "aqOGsh2PoOFmyRwPirWBb/qNqVihOnyySXp9chYsZg2bGaO2oI/B33wiEO3h" +
           "yGwLuNKfaX0+QhdjK2FrJjqot1GEguVJF6Prsdks+Lyr4WTsVla9dtEjy2rS" +
           "LMa+ENhteVFOu5I08VjW3XjOzPdqYSyUK2bHN5WWwtksh/ssilJLd+F2RRwr" +
           "NmuEWl4qZmnqjRsbv4Z6Hh2F/bQflfuBEE6aG8ubT4hNt+WzrFSSEzloYGrY" +
           "lfGojNB0MTQLFbi4QkhGVubxIvaWs0k1EsB8DxuUaCQdCxf76aZDDk1/YPo0" +
           "3TCScr9fVthe0yPjSnNYxUYdNaVqlaCZrOWUr7OlAS+uknbXsMma6Df74w26" +
           "WLsBUx4p/WFv7hPdhU/UEhsLmfk6XEqNhWB49VJjGZJDfm3H7ZTkhy7eNeBu" +
           "SlEKLkloK5WGDSmeeAa1ENt0g014YT6Zw12h2mKJfovqdxk7GtSaIyeQul6N" +
           "gsUqPYz0wJ9IFOsrTqG/aElme1GWrUTQ7FjfLMMQwQg57vUUCvfR5rBfx50a" +
           "KyarCUKRhqIPN5U2jXYoZzlvNqOx4CH0RixrdbFFpzQKT5bMZlmszIiSWKxo" +
           "HDe3Zbgm+zBZL5joRED5hROUXTZujLVhKGHDoux6HXhW4viZ3Ai6Er9qFVs0" +
           "tumL7Wm9G3MNJELUSqUul5dMfzQYzFFW9GJxTdNqd+lNR/JkOMELFlun07Y/" +
           "n43ozXiUzmalYW1YFnBpZHZteNZ1lxGljVgi8b0eg6i04NGdJu9TiiYPpAhX" +
           "y0XPcGCnqwp9l0iEcUdgFzEN03p56At0x/IlgavRo5Ezai0a9Qky2RgE12mJ" +
           "k7KHV0cYcBqzBxubItom0kIayUmVEhxh0aEBECxaNMe0yqnYQ1umaki1Vp3f" +
           "aMR8aIfLDnAQGYNXFXlMluQeES5pqj7melR9nrRITEE9Vmotgcwq6RNjB8XL" +
           "rMvy7YmHqYaAzSM2GVYDW1zYnXnUSkaph7M4seo2RYXV11ifAtbqJIxaMSWh" +
           "WaOkgkq1qJqhYGpHZ8YM4XcjWagJ8HJOwi1R4EzYlxoov4wWiUPW+bFW1Fc9" +
           "QdnMlvPanJu02YbJS9KCGHVwoTsE3mMvKU6zWZPCTVqxOWNpVQp07BgJGfVW" +
           "cxJZwkRbompKQtHNXtiZTPWqMI70ed9tT/V43Qt1h6isBwyfJI2uUmp5k7Sz" +
           "nHshsZqWkLQmOdZklZYLoZRWTMqvVpJawE4m6jyah11plSQdjBnIYQeL/YSv" +
           "obItpoknhwGLG81hZ6pKcqFVnybkxpkXTF/SktAA2qZLj0HCaGQ7E2wjaLW1" +
           "3WvIibqqWckUHeJIuWQjAcww04Yy4Ee6y9R4LHGFyQALF6mv0u1khDZbwzrh" +
           "kXxaWGsxM3PqhaTsWp4s4h2y2Yim8/5iYQsYoiHwpDQlK3BvZLYkeUDg1gRb" +
           "SGi4amMR1Z17IBKFUjdYjUR6Qk7FzjLxjFhnVrE9CpwVkkgclqyS1ma2EsNV" +
           "sKRkpIhvNNMYwbA+5UcmZbSCKCQFXurXEkktLRdhl0orc7g81+OAS/A1Ygwx" +
           "iqOYSleThUSksBRFe2rZUNhpzKv1RY2SO9i8JFKrCR91Gys+DpqTgCrZS1Hi" +
           "mw41JOqjyCoxmw3ZI/XRhIzDYTRkBbmqTXUQo2yH0MqWVjWGoZY6ZXQjDxoz" +
           "bZb69cAwwwZRKjbqhSrcK4512ULwVt+ttbDZyBop45rBxV6RIRR44rkIahuU" +
           "rBCpU+QdwklpG+7E+IKcq8wYCVGklqpaY4nOwpCT3BVRX5urlLFDnuajILRQ" +
           "3DGY7krjNwgepnCHEZolZSVIRZ/om/XSxkCQctfZrDdFeMhSbF+uuhKjeUo1" +
           "ohtus4TDqDppjLxN0SszAPebzLrK1YsB6+sczPBWO1ZGNQ2f2kuzyPBjdOAQ" +
           "tWlKJvWR1LfgVqOrd2kZ7lUwvYEYSVzsWzIX6ht1ii9RgnD8CokHLbrCLQKi" +
           "jKrIjGkUSxsaqeKVJlkoqlKR7xWaXTNdpBtkPK7ExVBeVuPVcDwjitY4sArU" +
           "etDsKy16NNuEnWLdJhfYXG40xiOuhJlYGS+VACS43HRIoaomuVMyMHl/3uib" +
           "sl1VPWJcqrjLZVOi+0O00k2Ho6ZaWWujhmd1TQUTnV6xQo/JFVkoIKpDxJNC" +
           "26iGPVtddStWI7HgGiwRfV8o6GOH8Am50tP9iph2OyiuMQtwFhs7ZLsMs7De" +
           "qKJrjpxYdDhlmAKsaoSnYSSqq0zRURZM7OmO2ZvrfhzypYq9wZlyE0dZuO7X" +
           "Wb5ojgMyGE7ZjSXV4HaCb+pRMV2om8UmILy4rrQ7pZo1IueDymIsBZXKjJ1V" +
           "+fGQRihLjAXDLyRqxdNbFN/qVYimRErpRBqtaS9mbbZugk1AlQk31qKerszW" +
           "vGgOk6mcsNhKFcvTyqI2UtDYS9twVbTa/VgpDtcrwXGZtt7XxkUQ6BnPoj3L" +
           "m27U/nA6WnXQeqM1RJ1uW5goCjPgyN6M8DqEqXSR+arLF+CkbDlpreoXRgIx" +
           "sAqzwaJc7nmMz5c6tkIxTtuqequ+l5CUUHB1ZtE3YUReRO3ZKh6tp2wwKA2G" +
           "DUe3Bg0uaNQJYu0vqymLzL2JjvRsZOzIdiWqVGMOacmlVCeTCrkJ8FTnFqhA" +
           "NsusQBfGK4lJOs6o0Ck5zVZdcPxuoYZZMogV2CZJ5ATdqNEsJTYGSQ84VKrS" +
           "zVoPJtAKaaZTkbKMlQsw2ZeGuIwpIK4PimXVbvTrRZPG1yitr+XpYhIqpLjs" +
           "sRXGK9olplivS50hps2bS93Aho2E5v0UNnRCFUYMGdYUx6kKZLkpy0URIC7f" +
           "0uIGilvTFMVdJYzdccCiAiFWmKCDMKxAeLjrk34pFCs6DJ7UdmCPPLfX7ZDC" +
           "mF7EcUhWecWRxwUz6nO60J9tKJ+coHCZk8wSvC6jkwaWOKzky6Ybmx1jMcPo" +
           "itBl1WF3VFdSvCsMrOqwVFRpRN+MB/psVmZn9SoynzNRsvRQurjk6kynFERz" +
           "EycqlFxFB91kKM5gHZ7Ux4skqNLEYDPhmtVJg+sJi/q4uFC0NjUIsIGBLJrp" +
           "BFbrWKmSCFYSt/tSb7FoeZ1i1Wjoukr5k9AesQonroYrjWsGvOZbFXuOg5ha" +
           "ag6KekPnCapLBgGPT+XSqmYreAMnzSlZ0jS+iblFOkB7q7Dfb3RQLamkQ6w9" +
           "DsvVAo+3LTvoUmOGLE1rCzLCK9aGJNlKvaVtyhxuxU4BNVrpuqIulBGGDKLq" +
           "qIvWC4pti22SGDRC3u9hdHMxKTvjgutr42ESrMaSmBodZiWvl0iTj2qyMXJw" +
           "1WXNKG4HA4TmmrjJCQUztYeOw/NRvSCv4xjTybVUEPxOl2/GrQ2tEaOZFsMj" +
           "oll1SutY3QjkvI9NkUR3fWkMtq9LEBbfnh/w3vPqjpS356fnoytJcJLMXjiv" +
           "4tSYXnvAvd2Au5x3nj+4/fTt1rHcw7HkHJSlD++73gVknjb9+Puefm7GfwLb" +
           "O0hKlCPo3MG98I5Pdmx/8/WTfJ388nWXafvi+/753sE7jMdfxRXNA6eEPM3y" +
           "tzvPf7n5JvVX9qCzR3m3q66FT3Z67GS27UKgRXHgDE7k3O47mtaL2XSRYDo/" +
           "fDCtT55O6ezW86qFOpMv1NYeTiWMz25N5zCTcuepxL2ghNE2f/nsIcl9p0ik" +
           "wIyyS4YtaT7IMy+Tlf6NrHgqgi54gabm13PaNRMbK9ec7azzl18pp3Ei/wv0" +
           "uOb136EK8Ku4SASmdc9VP2TYXr6rn3nu4vm7nxv+VX5pdnRBfjMHnddjyzqe" +
           "Sj1WPwcU1818Lm7eJla9/OuTEXT/y8sVQTfm37kav7nt9akIuud6vSLoLCiP" +
           "U386gl53LWpAeTg9B5QvRNCl05Rg/Pz7ON3vgpXc0QHn3FaOk/w+4A5Isurn" +
           "vcMlqL+qu1zLM5ReoJ1ez/TMSTA5Mpc7XslcjuHPIyeAI/9py6GTx9sft1xR" +
           "P/tcu/vul4qf2N4yqpay2WRcznPQTdsLzyOgeOi63A55nWMe/cFtL9z8xkNE" +
           "u20r8M59j8n2wLXv9mjbi/LbuM0f3P17b/vkc9/Is47/AxEqMwdzJAAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "rhis5n76Av4F4O9/9I/6h37glaG21SxPk+36pGk5WP30IRpKrwmRrbWXep7+" +
           "+AVugr9++4jxrr2PfhHevZc7mTc5TXl9hpuHNzrcHDosoKubMpQWxrH8oyNb" +
           "X/n51p18VbXekr0MOtIX/vzfP4b3/f1kgWoASaYKvFWdQyHaBuo6v3+4UaHZ" +
           "+/+17bvn1wCytKOKrCJtzuL2pFsq9GlGNuFymNNAsQ9u86hzCArMAD/QD19z" +
           "BvY+l60rbK8OmSlJ39vo0Gy48dbrPVdnHhcfe+fqyPVXj11jO+Bt7d3w0iFo" +
           "fPtr6DCVbv9Yf21rE4w00M07sfob1fKJGyCxCySKUM6NNToU35wHjEzqsvJ3" +
           "X/td3cazJSi4HFXClieXCwzX0TAAVGykoW7ntHsXcWTpo1BTzUxFecbTXJ5U" +
           "GCWWZTTC8nrg5bEvLfzZ4HsMxziCjWfspQY9UfhLMDsWOtXj04s//vD49WfK" +
           "eTwNkR0+vvp/r5ETD3/wed4ms2JZIGF8/F2RQ0+Pa73nMuN3qhblbsrlNzxQ" +
           "1x3eOQcz/ww2ht4IovIuVC2aR7D1gpyltaALjh2GdS6DY5pn3nuE4P1yi12V" +
           "J/gz1qXWXy/dSVBKPAHvK5EToXwcM8vIMX+JDCD28ABjmUaHGflFqBg3QcGe" +
           "2XYejWaM7XTo4nEQLRpknbe+xI102EBVzimkUrgNKrGtcm4hlanboHKTrXJe" +
           "IZU9Q6jkU9PYOJ0Os1gaBgkKadmELEHNDhnswO70GSzNa/wnG3ef4eQzohA1" +
           "sdjhk1WHAw/vHUyueXZ20ATORaDSvBNw5ARYofHjQgc7bztJNv/c9ZKLT9SP" +
           "yO/KqaSGIj33jOIA4lfw5sP/GLfunvTGW2i3J/mM94t8vuPQyRXTxCeC7MqA" +
           "53TeVYOXqcWbyZU6Jlld8RawRttdVdQNHeCm06a7/uAPIyde8gIhQB83+3rM" +
           "UZaQAsJ8FXE4kzKcvd9ttgz0p8X1fC9BJZKSV+Pp6zK2tu/4i4LdjrFGkRf+" +
           "X4/+5JcnN5Zf4EWhcMPnu8D4YMupn6p/vRy0Im++beYoM8SRmTL8lyDpthym" +
           "u7GaAREkHcVKN0lbJ/cvTxlN0qnFs8C1y4PPNZ3eNtj0PusqKiQD8gja3AIX" +
           "TC6eq4cuXT43cuJhdtgrpVlpNl7em7n8izfPfRrzUBUdvm8Ghb8nZOjJCUxg" +
           "3FME3VhQ095SUgSZSVsAoCOzDaFvj9DhcbMxoSqCnM86cPCjCi3HgGWqgump" +
           "x5rjdw2SGrYvMWEyV3Cx/Y41jzu1dDtbzxCd5U+GmHuGDoNgmkjXxc0Ygvw5" +
           "tk33ubq4/OSzh+8VfWWE3x5Cz/N02Aobp+lYZLc12L6kKYQHpb2qlHQq2EM3" +
           "K5qe/pObRFDD0JdDlsNm3sJ9E+RJfd59N7+jFQ8PVlWMHbz/LzzMrXvUEXBA" +
           "TGVl2d15uZ5DsCEpie3RCN6H8ZPGUVj+0OsCH7NfZsZLnOtlguqLcQHIwuim" +
           "fgWCtRA1UMLopjxGULWfEvSzXzfdawRVOnSQUvzBTfI6SAcS+viGZrmg45au" +
           "/GQtLcR0XNSxuYC3AbHDaMzNwsjVszR54JD9V4hVTbL8P0Pi4pHBlau3XLv7" +
           "WX4bJMrCwACVMhyQi19M2U3AlKLSLFmhtuk3Rr04bKpVi2r4gp3SPN6VTvdB" +
           "hmr0nDXOd2diNNtXJxcOLDz29q7QOUDqDSggQO5tyD9F5LQsdCgbooXO0gDt" +
           "7DqnpfLDjWc+fzdQyw5rZi/WMBRHXNxz7GIspWk/CqJh7RCnShLn2BFnab+y" +
           "Fou9uudoHkqoWcUuA6No5gj0v0nYzpgbOtL+Sm8TCWrMv6fIv2GFc2wf1pdQ" +
           "6WbF8bRNWU1zz7KdXcpxiFf7kni0Q9PMC5qy42znNY3hy3kGkP8Hf6fRYO8c" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "U9PMe5sRg0zzUHTS50UGkv8FLHk7YwodAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Nj0YoikAAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8zjWHX3fLMzOzssO7MD+2DLvgeqxfA5zjsaoOskthPH" +
           "SZzYzqstg+N3/IzfMWwLSHRXRdrSdoCtBPsXqC1aHqqKWqmi2qpqAYEqUaG+" +
           "pAKqKpWWIrF/lFalLb12vu/L930zs2hVqZHi3Fyfc+455577u+ee+9IPoHO+" +
           "B8GuY25U0wn25STYX5mV/WDjyv4+RVcYwfNlqWUKvs+BvuviE1+89KMff1S7" +
           "vAedX0BvEGzbCYRAd2x/LPuOGckSDV3a9eKmbPkBdJleCZGAhIFuIrTuB9do" +
           "6HXHWAPoKn2oAgJUQIAKSK4Cgu2oANPrZTu0WhmHYAf+Gvol6AwNnXfFTL0A" +
           "evykEFfwBOtADJNbACRcyP5PgFE5c+JBjx3ZvrX5JoM/BiM3PvGey793Frq0" +
           "gC7pNpupIwIlAjDIArrbkq2l7PmYJMnSArrXlmWJlT1dMPU013sBXfF11RaC" +
           "0JOPnJR1hq7s5WPuPHe3mNnmhWLgeEfmKbpsSof/zimmoAJb79/ZurWQyPqB" +
           "gRd1oJinCKJ8yHKHodtSAD16muPIxqs9QABY77TkQHOOhrrDFkAHdGU7d6Zg" +
           "qwgbeLqtAtJzTghGCaCHbis087UriIagytcD6MHTdMz2FaC6K3dExhJA950m" +
           "yyWBWXro1Cwdm58fDN75/Pvsjr2X6yzJopnpfwEwPXKKaSwrsifborxlvPtt" +
           "9MeF+7/83B4EAeL7ThFvaf7g/a88/fZHXv7qluZnbkEzXK5kMbgufnp5zzff" +
           "3HqqcTZT44Lr+Ho2+Scsz8OfOXhzLXHByrv/SGL2cv/w5cvjP59/4LPy9/eg" +
           "i13ovOiYoQXi6F7RsVzdlD1StmVPCGSpC90l21Irf9+F7gRtWrflbe9QUXw5" +
           "6EJ3mHnXeSf/D1ykABGZi+4Ebd1WnMO2KwRa3k5cCIKugC/0AATd0YDyz/Y3" +
           "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" +
           "us+z7qiymnhgJ+Z1r1t1kxj2AtYyIkyf9VNXqROqu0Z1DJuA08G7smPD9dd2" +
           "crs3P6QeXV6AA1v2gnoNJ5bk1gPu7Qbclcbycse9p+vgx0tju0IIlB3OHr7d" +
           "VUV+MPv0h268KA0/g+4dFJAW4Cx+cIO0k5Odjt92+xNoP7+m2VU1vvKhf3mI" +
           "e7f23tdQyX30lJKnRf5u/6WvkW8Vf2MPOntU47jpAukk07WTlY2LnhyEns2d" +
           "qG88fOTWS5m7KsCd2IFbn751NfWWE3Umn6htPJwqzp09qEgdFCzuO1XfG4Oj" +
           "/rZWFB+SPHyKZOqB9GxpylvSfJDoVSqA788e6wC66HqymFfxt+Vj/lgQzsGh" +
           "OnJ0aRed3k87T5+otQXQg7e7KDi0An4Ntw4guh686dZze1Mnfv7FSxceeJH/" +
           "67y8fnSbdhcNXVBC0zxeuTrWPg9sV/TcHXdt61hu/vNcAD3y6noF0Ln8Nzfj" +
           "2S3XR4C5t+MKoLPgeZz6+QB6462oAeWhew4ofz2ALp+mBOPnv8fpboDJ3NGB" +
           "9bltHCf5BJAOSLLmC+7hFLymix/MdDWB8eTT85mcOYknRxFz5adFzDEIevIE" +
           "duT34IfrPNzehF8Xv/AiNXjfK9XPbO8jRFNI00zKBRq6c3s1coQVj99W2qGs" +
           "852nfnzPF+96yyGo3bNVeLeCj+n26K1vAXDLDfK6ffqHD/z+O3/7xW/n9b3/" +
           "BSkT4/GgIAAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "08yiu+RXzPOaxijmJOPI/wLSn2ztrhoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "LOoo/ws+3NzFESYAAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "L0pRx8OcIAAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ye2wUxxmfO7+N3wTj8DBgGyoevSskKa1MU4x5Gc74ahOq" +
           "nJuc9/bmfIv3dpfdOfswpQSqBpRKKAokJWmwqoQkDSIQtY36EpSqaRNEEwSN" +
           "Wh4tNOSPJCVI8EfjtLRNv5nZvX3cnSl/NJY8t7vzzTfzfd9vft83c+Q6KjF0" +
           "1KIJSlwIkK0aNgJh+hwWdAPHO2XBMDbC16j42Lv7doz/oWKnH5VGUE1SMLpF" +
           "wcCrJSzHjQiaKSkGERQRGxswjtMRYR0bWB8WiKQqETRFMrpSmiyJEulW45gK" +
           "bBL0EKoXCNGlWJrgLlMBQbNCbDVBtppgh1egPYSqRFXbag+Y5hrQ6eijsil7" +
           "PoOgutBmYVgIpokkB0OSQdozOlqoqfLWQVklAZwhgc3yfaYj1oXuy3FDy6u1" +
           "H996PFnH3DBZUBSVMBONXmyo8jCOh1Ct/XWVjFPGFvQtVBRCkxzCBLWFrEmD" +
           "MGkQJrXstaVg9dVYSac6VWYOsTSVaiJdEEFz3Eo0QRdSppowWzNoKCem7Www" +
           "WDs7a60Vbo+JTy4M7v/ew3U/KkK1EVQrKX10OSIsgsAkEXAoTsWwbnTE4zge" +
           "QfUKBLwP65IgS6NmtBsMaVARSBogYLmFfkxrWGdz2r6CSIJtelokqp41L8FA" +
           "Zb6VJGRhEGxttG3lFq6m38HASgkWpicEwJ45pHhIUuIMR+4RWRvb1oMADC1L" +
           "YZJUs1MVKwJ8QA0cIrKgDAb7AHzKIIiWqABBnWGtgFLqa00Qh4RBHCWoySsX" +
           "5l0gVcEcQYcQNMUrxjRBlKZ5ouSIz/UNy/ZuU9YqfuSDNcexKNP1T4JBzZ5B" +
           "vTiBdQz7gA+sWhB6Smg8vsePEAhP8QhzmZ9+8+byRc0n3+Qy0/PI9MQ2Y5FE" +
           "xUOxmrMzOud/uYguo1xTDYkG32U522Vhs6c9owHTNGY10s6A1Xmy93cPPnIY" +
           "X/Ojyi5UKqpyOgU4qhfVlCbJWF+DFawLBMe7UAVW4p2svwuVwXNIUjD/2pNI" +
           "GJh0oWKZfSpV2Tu4KAEqqIsq4VlSEqr1rAkkyZ4zGkKoAf7RVISKzyP2x38J" +
           "koNJNYWDgigokqIGw7pK7acBZZyDDXiOQ6+mBmOA/6HPLw4sDRpqWgdABlV9" +
           "MCgAKpKYd7J9KoyQoJQCMAT7Nq3pBBOpE3CAok77jOfLUPsnj/h8EJoZXmKQ" +
           "YU+tVeU41qPi/vSKVTePRk9z0NGNYnqOoPUwaYBPGmCTMhqFSQNs0oBz0rY+" +
           "UcdYyb6brBLt2rAxGu7oXI98PraWu+jiOEQgwENAFcDVVfP7Hlo3sKelCLCp" +
           "jRRDdKjovJzc1WlzipUIouKRs73jZ96qPOxHfqCdGOQuO4G0uRIIz3+6KuI4" +
           "MFihVGLRabBw8si7DnTywMjOTTu+wNbhzAlUYQnQGR0epkyenaLNywX59Nbu" +
           "/uDjY09tV21WcCUZKzfmjKRk0+KNvNf4qLhgtvBa9Pj2Nj8qBgYD1iYC7DIg" +
           "xGbvHC7SabcInNpSDgYnVD0lyLTLYt1KktTVEfsLg2Q9e74LQlxOd+HnYDte" +
           "NLcl+6W9jRptp3IIU8x4rGAJ4it92sHzb394D3O3lUtqHUVAHybtDv6iyhoY" +
           "U9XbENwImAW5vxwI73vy+u5+hj+QaM03YRttKb4hhODm77y55cKVy4fe8Wcx" +
           "izJu28onsI3C214G0J4MVEDB0vaAAmCUEpIQkzHdG/+qnbv4tY/21vHwy/DF" +
           "Qs+i2yuwv9+9Aj1y+uHxZqbGJ9K0a7vKFuNcPtnW3KHrwla6jszOczOffkM4" +
           "CFkBmNiQRjEjVz8z3c8sbyLobjbSpgjQrOq0MGSp7F4W0nuYcIC1S6hfTO/R" +
           "96W0aTOcW8O9+xxVVFR8/J0b1ZtunLjJjHKXYU4kdAtaOwcfbeZmQP1ULw2t" +
           "FYwkyN17csM36uSTt0BjBDSKQL1Gjw5EmXHhxpQuKbv46980DpwtQv7VqFJW" +
           "hfhqgW1BVAHYx0YSODajfXU5B8EIRUUdMxXlGE/dPit/QFelNMJCMPqzqT9Z" +
           "9tLYZQY5DrbpTuTNY+182iziYSFQUqZjUJ3Dg8GqPRujbGC9Ny06MeqaQEcz" +
           "C1UurOo6tGv/WLznhcW8vmhwVwOroNh95Y///n3gwF9P5Uk0pWblaU9I+X9O" +
           "Dv93s6rO5q6l58aLLj3RVJVL/VRTcwFiX1CY2L0TvLHrb9M23p8cuANOn+Xx" +
           "klfly91HTq2ZJz7hZ4Upp/OcgtY9qN3pL5hUx1CBK9Qs+qWaQbslG9daGq9u" +
           "iOdVM66X8/NqXsT46ONKD5HVWEryKPPs5UlMyyS2gR3RowzQl44ZJKxLKaDj" +
           "YbNwPdY4vuX1stGVVlGabwiXXG90n/nF2vejLBLlNNRZ+x1h7tAHHbmmjpvx" +
           "Kfz54P8/9J8un37gJWBDp1mHzs4WoppGsT5/gpOj24Tg9oYrQ89+8Ao3wVuo" +
           "e4Txnv2PfRrYu5/vAX6aac05UDjH8BMNN4c2/Rm2MyaYhY1Y/f6x7b/84fbd" +
           "fpNXuwgqksyDJo2TL7vLGr1O5ystXXzwHzsePd8DZUEXKk8r0pY07oq7gVhm" +
           "pGOOKNjHHxuW5pqpxwnyLQDn0g8Rg55W8wWbpRu+gp9P/vDHpwbKLnDH5oeT" +
           "5xx0ddvp59Q/X/NbVj+YxXGNSXbI5GL+S5D0f6nJB7GaAhUkGcLKIElaB4DP" +
           "bjIKkrmFIezw8tiLrW/vGGt9lyW8cskAooRNlOec6hhz48iVa+eqZx5lJWMx" +
           "3YsmAtwH/Nzzu+tYziJUS5shExS54JydkwLYvZTNph9d+v57vxp/voyDZIJd" +
           "6xnX9M8eObbr6ic5lQMj9jwb2TM+Ejzy7LTO+6+x8XbVTEe3ZnJPXOBVe+yS" +
           "w6m/+1tKf+tHZRFUJ5p3QJsEOU1r0Qj4zbAuhkKo2tXvvsPgB/b2bBqZ4WUS" +
           "x7Teet25j4uJa8/W85j4EGP4QqUFSxQElEqKILNx/ZDIZYZB+jZAG80sU5bk" +
           "Voq8xqR2QCGhKpiWq1YfPyRKaiB7/QSdmRx80PduG0AaXyltNrL1TFBnPjpB" +
           "3x7afBtME+m6uBkTiH+XuWm5o6bz2ak0waGdbTYXfGWCX59gnr20+Ro4TtOx" +
           "yI7ZOHu6ZgMeMvMD/REIKh5WJb7VvkSbXt7R/r9Vo9wkqExuc6y3IrbwDq4K" +
           "YF835VxV8us18ehYbfnUsQf+xKnFugKrgpSfSMuyE7OO51LwSEJiTqriCOZp" +
           "5hk4xE68Lggy+2VmPM1HHSSoqdAoyKLQOqV/AGjNJw2S0DolnyeozisJ87Nf" +
           "p9yLBFXacrCn+INT5GXQDiL08bBmhaD7Tm5rOmQtKYR1XDCwGV/u+YLhaMrt" +
           "cOQ4MbS6+JjdYlsZPM3vsaEEHFu3YdvNL77Az/GiLIyOUi2TIFvwK4VsZT2n" +
           "oDZLV+na+bdqXq2Ya+X/er5gu96d7thPsH6fRo9d0zynXaMte+i9cGjZibf2" +
           "lJ4Dmu9HPthUk/tz+TejpaHs7w/lK6SAgdlBvL3yvYEzn1z0NbCzm5ndmica" +
           "ERX3nbgUTmjaM35U0QU4VeI4w5LDyq1KLxaHdVddVhpT00o29dbQnSPQG27m" +
           "GdOh1dmv9B6IoJbcyjP3bgyOtSNYX0G1m1nedRZJa5qzl3kWcyLiFVZRNNSt" +
           "aWbJXfI687ymMYI5zhjyv9KA7I6qGgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "q+ig/C+zIr7OCSYAAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "wnuzmCAAAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Vsld8hL3vK5zgjnJGfK/XKuw9qoaAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "NRhGdWNrZHJctxqJMG+bq3Q19bkKV8JYhlE3oonFHNttJLAZGAhMIIQTJWyr" +
           "YbTqcwabr6jIoBpRlfQqnTrfNxvrdW8+03msXW83BBSeCCxhTkKVFKRMQTm1" +
           "aiJoiZQ3JZpvG31VGvIVQ+jptGiLrX6i1jajDeEkZEsQSit205NRr8M0WpHu" +
           "r9v6gsmWZZEZTYCdiDUf2aqcNQw4cbPygq9yPcu3SVyX5rpWinUCIwZYdzRJ" +
           "KlsPnbtMykx4PQ2njGu0SLhlLGAcTrxNVTWmLU8sE33eN5iNJdvpsL5euSm7" +
           "rOOctaJWVjNps41tc8WOW/P6ArXiFDbXaKmLWU1OL3dUyYk2uMWmQ53sDpqZ" +
           "xc5LQqOWkVLaXVSiCiIm6spoWJGC4XaFq1O2y0b+0LN7w0USL2W43OSpGapq" +
           "cGykFtbwrYgyuyjv8X2nYXkTd9VtxcMtk/HZTK3VmvisumK2oyHXnsq4irn9" +
           "cTDSeDPuuSDli0XKYGHEzKoqQLgalWUysSw1VQxsbjEGz2Fv7ci9BFPWjT4z" +
           "VaSBmNLZDOs1VyWHtJpLwQq4cm/WDQfDsjRttsYRQhJdEGqtzHJQo++5FVQx" +
           "NHGDxc2aNKdJq+Uo1KCDVti5S6z6tFNCORxpjDpNycYcPWnj5ljHPQ9rYhky" +
           "0H0+EvCea25ahrei19x6VHL6uII1GRJBYIQvMYzTsmdsoxcZKSXBmr3KxjrW" +
           "9HoqqhKDVUz2sBq8AlloXS7P+0iPbeihFEl1Uophf0mvRuFwPq+VYUMz1ZK3" +
           "MkM7xjGerFjIBCQ/S6GDyG2ktm2IqdWhoirWX62Gw1l7NavOp66CuuqkAgwF" +
           "PAheiGkEmHI2afa7xLxul/2B1zEDSppykdFbw2Sf6oloB8OVNpE0Qw41XN4P" +
           "zcydViYzwgxFXQiRmTqylYGwccogFNQqnsHxSo3byw4qbAI/MfAqWyGXY1aj" +
           "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" +
           "qW8WFZT/BU+SWMIJJgAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "eXnvfwElM5GjniAAAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "bk0za+6SM8zzmsYY5hSjyP8Cw+XN5KwaAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/C+5QljODyYAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HNQ0+4CveZhbXtMwuiPt+M+v/w0UHL91ZCEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "QGREcSwAAA==");
}
