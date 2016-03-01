package org.apache.batik.svggen;
public class ImageHandlerBase64Encoder extends org.apache.batik.svggen.DefaultImageHandler {
    public ImageHandlerBase64Encoder() { super(); }
    public void handleHREF(java.awt.Image image, org.w3c.dom.Element imageElement,
                           org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        if (image ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_IMAGE_NULL);
        int width =
          image.
          getWidth(
            null);
        int height =
          image.
          getHeight(
            null);
        if (width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
            if (image instanceof java.awt.image.RenderedImage) {
                handleHREF(
                  (java.awt.image.RenderedImage)
                    image,
                  imageElement,
                  generatorContext);
            }
            else {
                java.awt.image.BufferedImage buf =
                  new java.awt.image.BufferedImage(
                  width,
                  height,
                  java.awt.image.BufferedImage.
                    TYPE_INT_ARGB);
                java.awt.Graphics2D g =
                  buf.
                  createGraphics(
                    );
                g.
                  drawImage(
                    image,
                    0,
                    0,
                    null);
                g.
                  dispose(
                    );
                handleHREF(
                  (java.awt.image.RenderedImage)
                    buf,
                  imageElement,
                  generatorContext);
            }
        }
    }
    public void handleHREF(java.awt.image.renderable.RenderableImage image,
                           org.w3c.dom.Element imageElement,
                           org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        if (image ==
              null) {
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_IMAGE_NULL);
        }
        java.awt.image.RenderedImage r =
          image.
          createDefaultRendering(
            );
        if (r ==
              null) {
            handleEmptyImage(
              imageElement);
        }
        else {
            handleHREF(
              r,
              imageElement,
              generatorContext);
        }
    }
    protected void handleEmptyImage(org.w3c.dom.Element imageElement) {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            DATA_PROTOCOL_PNG_PREFIX);
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            "0");
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            "0");
    }
    public void handleHREF(java.awt.image.RenderedImage image,
                           org.w3c.dom.Element imageElement,
                           org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.io.ByteArrayOutputStream os =
          new java.io.ByteArrayOutputStream(
          );
        org.apache.batik.util.Base64EncoderStream b64Encoder =
          new org.apache.batik.util.Base64EncoderStream(
          os);
        try {
            encodeImage(
              image,
              b64Encoder);
            b64Encoder.
              close(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_UNEXPECTED,
              e);
        }
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            DATA_PROTOCOL_PNG_PREFIX +
            os.
              toString(
                ));
    }
    public void encodeImage(java.awt.image.RenderedImage buf,
                            java.io.OutputStream os)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        try {
            org.apache.batik.ext.awt.image.spi.ImageWriter writer =
              org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.
              getInstance(
                ).
              getWriterFor(
                "image/png");
            writer.
              writeImage(
                buf,
                os);
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_UNEXPECTED);
        }
    }
    public java.awt.image.BufferedImage buildBufferedImage(java.awt.Dimension size) {
        return new java.awt.image.BufferedImage(
          size.
            width,
          size.
            height,
          java.awt.image.BufferedImage.
            TYPE_INT_ARGB);
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
       "ZyB4vSYAAA==");
}
