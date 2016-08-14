package org.apache.batik.svggen;
public class DefaultImageHandler implements org.apache.batik.svggen.ImageHandler, org.apache.batik.svggen.ErrorConstants, org.apache.batik.util.XMLConstants {
    public DefaultImageHandler() { super(); }
    public void handleImage(java.awt.Image image, org.w3c.dom.Element imageElement,
                            org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getWidth(
                    null)));
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getHeight(
                    null)));
        try {
            handleHREF(
              image,
              imageElement,
              generatorContext);
        }
        catch (org.apache.batik.svggen.SVGGraphics2DIOException e) {
            try {
                generatorContext.
                  errorHandler.
                  handleError(
                    e);
            }
            catch (org.apache.batik.svggen.SVGGraphics2DIOException io) {
                throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                  io);
            }
        }
    }
    public void handleImage(java.awt.image.RenderedImage image,
                            org.w3c.dom.Element imageElement,
                            org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getWidth(
                    )));
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getHeight(
                    )));
        try {
            handleHREF(
              image,
              imageElement,
              generatorContext);
        }
        catch (org.apache.batik.svggen.SVGGraphics2DIOException e) {
            try {
                generatorContext.
                  errorHandler.
                  handleError(
                    e);
            }
            catch (org.apache.batik.svggen.SVGGraphics2DIOException io) {
                throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                  io);
            }
        }
    }
    public void handleImage(java.awt.image.renderable.RenderableImage image,
                            org.w3c.dom.Element imageElement,
                            org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getWidth(
                    )));
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            java.lang.String.
              valueOf(
                image.
                  getHeight(
                    )));
        try {
            handleHREF(
              image,
              imageElement,
              generatorContext);
        }
        catch (org.apache.batik.svggen.SVGGraphics2DIOException e) {
            try {
                generatorContext.
                  errorHandler.
                  handleError(
                    e);
            }
            catch (org.apache.batik.svggen.SVGGraphics2DIOException io) {
                throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                  io);
            }
        }
    }
    protected void handleHREF(java.awt.Image image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            image.
              toString(
                ));
    }
    protected void handleHREF(java.awt.image.RenderedImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            image.
              toString(
                ));
    }
    protected void handleHREF(java.awt.image.renderable.RenderableImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            image.
              toString(
                ));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "FOo+EI/YXPsvhvHC0jEbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
