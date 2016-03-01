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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
