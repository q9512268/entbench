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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "SWmU4CSw0jT/AyJeZX5AGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
