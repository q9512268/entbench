package org.apache.batik.ext.awt.image.renderable;
public class ConvolveMatrixRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.ConvolveMatrixRable {
    java.awt.image.Kernel kernel;
    java.awt.Point target;
    float bias;
    boolean kernelHasNegValues;
    org.apache.batik.ext.awt.image.PadMode edgeMode;
    float[] kernelUnitLength = new float[2];
    boolean preserveAlpha = false;
    public ConvolveMatrixRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter source) {
        super(
          source);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src);
    }
    public java.awt.image.Kernel getKernel() { return kernel;
    }
    public void setKernel(java.awt.image.Kernel k) { touch(
                                                       );
                                                     this.
                                                       kernel =
                                                       k;
                                                     kernelHasNegValues =
                                                       false;
                                                     float[] kv =
                                                       k.
                                                       getKernelData(
                                                         null);
                                                     for (int i =
                                                            0;
                                                          i <
                                                            kv.
                                                              length;
                                                          i++)
                                                         if (kv[i] <
                                                               0) {
                                                             kernelHasNegValues =
                                                               true;
                                                             break;
                                                         }
    }
    public java.awt.Point getTarget() { return (java.awt.Point)
                                                 target.
                                                 clone(
                                                   );
    }
    public void setTarget(java.awt.Point pt) { touch(
                                                 );
                                               this.
                                                 target =
                                                 (java.awt.Point)
                                                   pt.
                                                   clone(
                                                     );
    }
    public double getBias() { return bias; }
    public void setBias(double bias) { touch();
                                       this.bias =
                                         (float)
                                           bias; }
    public org.apache.batik.ext.awt.image.PadMode getEdgeMode() {
        return edgeMode;
    }
    public void setEdgeMode(org.apache.batik.ext.awt.image.PadMode edgeMode) {
        touch(
          );
        this.
          edgeMode =
          edgeMode;
    }
    public double[] getKernelUnitLength() { if (kernelUnitLength ==
                                                  null)
                                                return null;
                                            double[] ret =
                                              new double[2];
                                            ret[0] =
                                              kernelUnitLength[0];
                                            ret[1] =
                                              kernelUnitLength[1];
                                            return ret;
    }
    public void setKernelUnitLength(double[] kernelUnitLength) {
        touch(
          );
        if (kernelUnitLength ==
              null) {
            this.
              kernelUnitLength =
              null;
            return;
        }
        if (this.
              kernelUnitLength ==
              null)
            this.
              kernelUnitLength =
              (new float[2]);
        this.
          kernelUnitLength[0] =
          (float)
            kernelUnitLength[0];
        this.
          kernelUnitLength[1] =
          (float)
            kernelUnitLength[1];
    }
    public boolean getPreserveAlpha() { return preserveAlpha;
    }
    public void setPreserveAlpha(boolean preserveAlpha) {
        touch(
          );
        this.
          preserveAlpha =
          preserveAlpha;
    }
    public void fixAlpha(java.awt.image.BufferedImage bi) {
        if (!bi.
              getColorModel(
                ).
              hasAlpha(
                ) ||
              !bi.
              isAlphaPremultiplied(
                ))
            return;
        if (org.apache.batik.ext.awt.image.GraphicsUtil.
              is_INT_PACK_Data(
                bi.
                  getSampleModel(
                    ),
                true))
            fixAlpha_INT_PACK(
              bi.
                getRaster(
                  ));
        else
            fixAlpha_FALLBACK(
              bi.
                getRaster(
                  ));
    }
    public void fixAlpha_INT_PACK(java.awt.image.WritableRaster wr) {
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int width =
          wr.
          getWidth(
            );
        final int scanStride =
          sppsm.
          getScanlineStride(
            );
        java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int base =
          db.
          getOffset(
            ) +
          sppsm.
          getOffset(
            wr.
              getMinX(
                ) -
              wr.
              getSampleModelTranslateX(
                ),
            wr.
              getMinY(
                ) -
              wr.
              getSampleModelTranslateY(
                ));
        final int[] pixels =
          db.
          getBankData(
            )[0];
        for (int y =
               0;
             y <
               wr.
               getHeight(
                 );
             y++) {
            int sp =
              base +
              y *
              scanStride;
            final int end =
              sp +
              width;
            while (sp <
                     end) {
                int pixel =
                  pixels[sp];
                int a =
                  pixel >>>
                  24;
                int v =
                  pixel >>
                  16 &
                  255;
                if (a <
                      v)
                    a =
                      v;
                v =
                  pixel >>
                    8 &
                    255;
                if (a <
                      v)
                    a =
                      v;
                v =
                  pixel &
                    255;
                if (a <
                      v)
                    a =
                      v;
                pixels[sp] =
                  pixel &
                    16777215 |
                    a <<
                    24;
                sp++;
            }
        }
    }
    public void fixAlpha_FALLBACK(java.awt.image.WritableRaster wr) {
        int x0 =
          wr.
          getMinX(
            );
        int w =
          wr.
          getWidth(
            );
        int y0 =
          wr.
          getMinY(
            );
        int y1 =
          y0 +
          wr.
          getHeight(
            ) -
          1;
        int bands =
          wr.
          getNumBands(
            );
        int a;
        int x;
        int y;
        int b;
        int i;
        int[] pixel =
          null;
        for (y =
               y0;
             y <=
               y1;
             y++) {
            pixel =
              wr.
                getPixels(
                  x0,
                  y,
                  w,
                  1,
                  pixel);
            i =
              0;
            for (x =
                   0;
                 x <
                   w;
                 x++) {
                a =
                  pixel[i];
                for (b =
                       1;
                     b <
                       bands;
                     b++)
                    if (pixel[i +
                                b] >
                          a)
                        a =
                          pixel[i +
                                  b];
                pixel[i +
                        bands -
                        1] =
                  a;
                i +=
                  bands;
            }
            wr.
              setPixels(
                x0,
                y,
                w,
                1,
                pixel);
        }
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.RenderingHints rh =
          rc.
          getRenderingHints(
            );
        if (rh ==
              null)
            rh =
              new java.awt.RenderingHints(
                null);
        java.awt.geom.AffineTransform at =
          rc.
          getTransform(
            );
        double sx =
          at.
          getScaleX(
            );
        double sy =
          at.
          getScaleY(
            );
        double shx =
          at.
          getShearX(
            );
        double shy =
          at.
          getShearY(
            );
        double tx =
          at.
          getTranslateX(
            );
        double ty =
          at.
          getTranslateY(
            );
        double scaleX =
          java.lang.Math.
          sqrt(
            sx *
              sx +
              shy *
              shy);
        double scaleY =
          java.lang.Math.
          sqrt(
            sy *
              sy +
              shx *
              shx);
        if (kernelUnitLength !=
              null) {
            if (kernelUnitLength[0] >
                  0.0)
                scaleX =
                  1 /
                    kernelUnitLength[0];
            if (kernelUnitLength[1] >
                  0.0)
                scaleY =
                  1 /
                    kernelUnitLength[1];
        }
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        if (aoi ==
              null)
            aoi =
              getBounds2D(
                );
        java.awt.geom.Rectangle2D r =
          aoi.
          getBounds2D(
            );
        int kw =
          kernel.
          getWidth(
            );
        int kh =
          kernel.
          getHeight(
            );
        int kx =
          target.
            x;
        int ky =
          target.
            y;
        {
            double rx0 =
              r.
              getX(
                ) -
              kx /
              scaleX;
            double ry0 =
              r.
              getY(
                ) -
              ky /
              scaleY;
            double rx1 =
              rx0 +
              r.
              getWidth(
                ) +
              (kw -
                 1) /
              scaleX;
            double ry1 =
              ry0 +
              r.
              getHeight(
                ) +
              (kh -
                 1) /
              scaleY;
            r =
              new java.awt.geom.Rectangle2D.Double(
                java.lang.Math.
                  floor(
                    rx0),
                java.lang.Math.
                  floor(
                    ry0),
                java.lang.Math.
                  ceil(
                    rx1 -
                      java.lang.Math.
                      floor(
                        rx0)),
                java.lang.Math.
                  ceil(
                    ry1 -
                      java.lang.Math.
                      floor(
                        ry0)));
        }
        java.awt.geom.AffineTransform srcAt =
          java.awt.geom.AffineTransform.
          getScaleInstance(
            scaleX,
            scaleY);
        java.awt.geom.AffineTransform resAt =
          new java.awt.geom.AffineTransform(
          sx /
            scaleX,
          shy /
            scaleX,
          shx /
            scaleY,
          sy /
            scaleY,
          tx,
          ty);
        java.awt.image.RenderedImage ri;
        ri =
          getSource(
            ).
            createRendering(
              new java.awt.image.renderable.RenderContext(
                srcAt,
                r,
                rh));
        if (ri ==
              null)
            return null;
        org.apache.batik.ext.awt.image.rendered.CachableRed cr =
          convertSourceCS(
            ri);
        java.awt.Shape devShape =
          srcAt.
          createTransformedShape(
            aoi);
        java.awt.geom.Rectangle2D devRect =
          devShape.
          getBounds2D(
            );
        r =
          devRect;
        r =
          new java.awt.geom.Rectangle2D.Double(
            java.lang.Math.
              floor(
                r.
                  getX(
                    ) -
                  kx),
            java.lang.Math.
              floor(
                r.
                  getY(
                    ) -
                  ky),
            java.lang.Math.
              ceil(
                r.
                  getX(
                    ) +
                  r.
                  getWidth(
                    )) -
              java.lang.Math.
              floor(
                r.
                  getX(
                    )) +
              (kw -
                 1),
            java.lang.Math.
              ceil(
                r.
                  getY(
                    ) +
                  r.
                  getHeight(
                    )) -
              java.lang.Math.
              floor(
                r.
                  getY(
                    )) +
              (kh -
                 1));
        if (!r.
              getBounds(
                ).
              equals(
                cr.
                  getBounds(
                    ))) {
            if (edgeMode ==
                  org.apache.batik.ext.awt.image.PadMode.
                    WRAP)
                throw new java.lang.IllegalArgumentException(
                  "edgeMode=\"wrap\" is not supported by ConvolveMatrix.");
            cr =
              new org.apache.batik.ext.awt.image.rendered.PadRed(
                cr,
                r.
                  getBounds(
                    ),
                edgeMode,
                rh);
        }
        if (bias !=
              0.0)
            throw new java.lang.IllegalArgumentException(
              "Only bias equal to zero is supported in ConvolveMatrix.");
        java.awt.image.BufferedImageOp op =
          new java.awt.image.ConvolveOp(
          kernel,
          java.awt.image.ConvolveOp.
            EDGE_NO_OP,
          rh);
        java.awt.image.ColorModel cm =
          cr.
          getColorModel(
            );
        java.awt.image.Raster rr =
          cr.
          getData(
            );
        java.awt.image.WritableRaster wr =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          makeRasterWritable(
            rr,
            0,
            0);
        int phaseShiftX =
          target.
            x -
          kernel.
          getXOrigin(
            );
        int phaseShiftY =
          target.
            y -
          kernel.
          getYOrigin(
            );
        int destX =
          (int)
            (r.
               getX(
                 ) +
               phaseShiftX);
        int destY =
          (int)
            (r.
               getY(
                 ) +
               phaseShiftY);
        java.awt.image.BufferedImage destBI;
        if (!preserveAlpha) {
            cm =
              org.apache.batik.ext.awt.image.GraphicsUtil.
                coerceData(
                  wr,
                  cm,
                  true);
            java.awt.image.BufferedImage srcBI;
            srcBI =
              new java.awt.image.BufferedImage(
                cm,
                wr,
                cm.
                  isAlphaPremultiplied(
                    ),
                null);
            destBI =
              op.
                filter(
                  srcBI,
                  null);
            if (kernelHasNegValues) {
                fixAlpha(
                  destBI);
            }
        }
        else {
            java.awt.image.BufferedImage srcBI;
            srcBI =
              new java.awt.image.BufferedImage(
                cm,
                wr,
                cm.
                  isAlphaPremultiplied(
                    ),
                null);
            cm =
              new java.awt.image.DirectColorModel(
                java.awt.color.ColorSpace.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_LINEAR_RGB),
                24,
                16711680,
                65280,
                255,
                0,
                false,
                java.awt.image.DataBuffer.
                  TYPE_INT);
            java.awt.image.BufferedImage tmpSrcBI =
              new java.awt.image.BufferedImage(
              cm,
              cm.
                createCompatibleWritableRaster(
                  wr.
                    getWidth(
                      ),
                  wr.
                    getHeight(
                      )),
              cm.
                isAlphaPremultiplied(
                  ),
              null);
            org.apache.batik.ext.awt.image.GraphicsUtil.
              copyData(
                srcBI,
                tmpSrcBI);
            java.awt.image.ColorModel dstCM =
              org.apache.batik.ext.awt.image.GraphicsUtil.
                Linear_sRGB_Unpre;
            destBI =
              new java.awt.image.BufferedImage(
                dstCM,
                dstCM.
                  createCompatibleWritableRaster(
                    wr.
                      getWidth(
                        ),
                    wr.
                      getHeight(
                        )),
                dstCM.
                  isAlphaPremultiplied(
                    ),
                null);
            java.awt.image.WritableRaster dstWR =
              java.awt.image.Raster.
              createWritableRaster(
                cm.
                  createCompatibleSampleModel(
                    wr.
                      getWidth(
                        ),
                    wr.
                      getHeight(
                        )),
                destBI.
                  getRaster(
                    ).
                  getDataBuffer(
                    ),
                new java.awt.Point(
                  0,
                  0));
            java.awt.image.BufferedImage tmpDstBI =
              new java.awt.image.BufferedImage(
              cm,
              dstWR,
              cm.
                isAlphaPremultiplied(
                  ),
              null);
            tmpDstBI =
              op.
                filter(
                  tmpSrcBI,
                  tmpDstBI);
            java.awt.Rectangle srcRect =
              wr.
              getBounds(
                );
            java.awt.Rectangle dstRect =
              new java.awt.Rectangle(
              srcRect.
                x -
                phaseShiftX,
              srcRect.
                y -
                phaseShiftY,
              srcRect.
                width,
              srcRect.
                height);
            org.apache.batik.ext.awt.image.GraphicsUtil.
              copyBand(
                wr,
                srcRect,
                wr.
                  getNumBands(
                    ) -
                  1,
                destBI.
                  getRaster(
                    ),
                dstRect,
                destBI.
                  getRaster(
                    ).
                  getNumBands(
                    ) -
                  1);
        }
        cr =
          new org.apache.batik.ext.awt.image.rendered.BufferedImageCachableRed(
            destBI,
            destX,
            destY);
        cr =
          new org.apache.batik.ext.awt.image.rendered.PadRed(
            cr,
            devRect.
              getBounds(
                ),
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD,
            rh);
        if (!resAt.
              isIdentity(
                ))
            cr =
              new org.apache.batik.ext.awt.image.rendered.AffineRed(
                cr,
                resAt,
                null);
        return cr;
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
       "M2g8MnDGlyaW2KEIkINX1tNms9G0YFZu");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "H9nlfblKQgAA");
}
