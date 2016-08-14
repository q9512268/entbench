package org.apache.batik.svggen;
public abstract class DefaultCachedImageHandler implements org.apache.batik.svggen.CachedImageHandler, org.apache.batik.svggen.SVGSyntax, org.apache.batik.svggen.ErrorConstants {
    static final java.lang.String XLINK_NAMESPACE_URI = "http://www.w3.org/1999/xlink";
    static final java.awt.geom.AffineTransform IDENTITY = new java.awt.geom.AffineTransform(
      );
    private static java.lang.reflect.Method createGraphics = null;
    private static boolean initDone = false;
    private static final java.lang.Class[] paramc = new java.lang.Class[] { java.awt.image.BufferedImage.class };
    private static java.lang.Object[] paramo = null;
    protected org.apache.batik.svggen.ImageCacher imageCacher;
    public org.apache.batik.svggen.ImageCacher getImageCacher() {
        return imageCacher;
    }
    void setImageCacher(org.apache.batik.svggen.ImageCacher imageCacher) {
        if (imageCacher ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        org.apache.batik.svggen.DOMTreeManager dtm =
          null;
        if (this.
              imageCacher !=
              null) {
            dtm =
              this.
                imageCacher.
                getDOMTreeManager(
                  );
        }
        this.
          imageCacher =
          imageCacher;
        if (dtm !=
              null) {
            this.
              imageCacher.
              setDOMTreeManager(
                dtm);
        }
    }
    public void setDOMTreeManager(org.apache.batik.svggen.DOMTreeManager domTreeManager) {
        imageCacher.
          setDOMTreeManager(
            domTreeManager);
    }
    private static java.awt.Graphics2D createGraphics(java.awt.image.BufferedImage buf) {
        if (!initDone) {
            try {
                java.lang.Class clazz =
                  java.lang.Class.
                  forName(
                    "org.apache.batik.ext.awt.image.GraphicsUtil");
                createGraphics =
                  clazz.
                    getMethod(
                      "createGraphics",
                      paramc);
                paramo =
                  (new java.lang.Object[1]);
            }
            catch (java.lang.Throwable t) {
                
            }
            finally {
                initDone =
                  true;
            }
        }
        if (createGraphics ==
              null)
            return buf.
              createGraphics(
                );
        else {
            paramo[0] =
              buf;
            java.awt.Graphics2D g2d =
              null;
            try {
                g2d =
                  (java.awt.Graphics2D)
                    createGraphics.
                    invoke(
                      null,
                      paramo);
            }
            catch (java.lang.Exception e) {
                
            }
            return g2d;
        }
    }
    public org.w3c.dom.Element createElement(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        org.w3c.dom.Element imageElement =
          generatorContext.
          getDOMFactory(
            ).
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_IMAGE_TAG);
        return imageElement;
    }
    public java.awt.geom.AffineTransform handleImage(java.awt.Image image,
                                                     org.w3c.dom.Element imageElement,
                                                     int x,
                                                     int y,
                                                     int width,
                                                     int height,
                                                     org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        int imageWidth =
          image.
          getWidth(
            null);
        int imageHeight =
          image.
          getHeight(
            null);
        java.awt.geom.AffineTransform af =
          null;
        if (imageWidth ==
              0 ||
              imageHeight ==
              0 ||
              width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
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
            af =
              handleTransform(
                imageElement,
                x,
                y,
                imageWidth,
                imageHeight,
                width,
                height,
                generatorContext);
        }
        return af;
    }
    public java.awt.geom.AffineTransform handleImage(java.awt.image.RenderedImage image,
                                                     org.w3c.dom.Element imageElement,
                                                     int x,
                                                     int y,
                                                     int width,
                                                     int height,
                                                     org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        int imageWidth =
          image.
          getWidth(
            );
        int imageHeight =
          image.
          getHeight(
            );
        java.awt.geom.AffineTransform af =
          null;
        if (imageWidth ==
              0 ||
              imageHeight ==
              0 ||
              width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
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
            af =
              handleTransform(
                imageElement,
                x,
                y,
                imageWidth,
                imageHeight,
                width,
                height,
                generatorContext);
        }
        return af;
    }
    public java.awt.geom.AffineTransform handleImage(java.awt.image.renderable.RenderableImage image,
                                                     org.w3c.dom.Element imageElement,
                                                     double x,
                                                     double y,
                                                     double width,
                                                     double height,
                                                     org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        double imageWidth =
          image.
          getWidth(
            );
        double imageHeight =
          image.
          getHeight(
            );
        java.awt.geom.AffineTransform af =
          null;
        if (imageWidth ==
              0 ||
              imageHeight ==
              0 ||
              width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
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
            af =
              handleTransform(
                imageElement,
                x,
                y,
                imageWidth,
                imageHeight,
                width,
                height,
                generatorContext);
        }
        return af;
    }
    protected java.awt.geom.AffineTransform handleTransform(org.w3c.dom.Element imageElement,
                                                            double x,
                                                            double y,
                                                            double srcWidth,
                                                            double srcHeight,
                                                            double dstWidth,
                                                            double dstHeight,
                                                            org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        imageElement.
          setAttributeNS(
            null,
            SVG_X_ATTRIBUTE,
            generatorContext.
              doubleString(
                x));
        imageElement.
          setAttributeNS(
            null,
            SVG_Y_ATTRIBUTE,
            generatorContext.
              doubleString(
                y));
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            generatorContext.
              doubleString(
                dstWidth));
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            generatorContext.
              doubleString(
                dstHeight));
        return null;
    }
    protected void handleEmptyImage(org.w3c.dom.Element imageElement) {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            "");
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
    public void handleHREF(java.awt.Image image,
                           org.w3c.dom.Element imageElement,
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
                  buildBufferedImage(
                    new java.awt.Dimension(
                      width,
                      height));
                java.awt.Graphics2D g =
                  createGraphics(
                    buf);
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
    public java.awt.image.BufferedImage buildBufferedImage(java.awt.Dimension size) {
        return new java.awt.image.BufferedImage(
          size.
            width,
          size.
            height,
          getBufferedImageType(
            ));
    }
    protected void handleHREF(java.awt.image.RenderedImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.awt.image.BufferedImage buf =
          null;
        if (image instanceof java.awt.image.BufferedImage &&
              ((java.awt.image.BufferedImage)
                 image).
              getType(
                ) ==
              getBufferedImageType(
                )) {
            buf =
              (java.awt.image.BufferedImage)
                image;
        }
        else {
            java.awt.Dimension size =
              new java.awt.Dimension(
              image.
                getWidth(
                  ),
              image.
                getHeight(
                  ));
            buf =
              buildBufferedImage(
                size);
            java.awt.Graphics2D g =
              createGraphics(
                buf);
            g.
              drawRenderedImage(
                image,
                IDENTITY);
            g.
              dispose(
                );
        }
        cacheBufferedImage(
          imageElement,
          buf,
          generatorContext);
    }
    protected void handleHREF(java.awt.image.renderable.RenderableImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.awt.Dimension size =
          new java.awt.Dimension(
          (int)
            java.lang.Math.
            ceil(
              image.
                getWidth(
                  )),
          (int)
            java.lang.Math.
            ceil(
              image.
                getHeight(
                  )));
        java.awt.image.BufferedImage buf =
          buildBufferedImage(
            size);
        java.awt.Graphics2D g =
          createGraphics(
            buf);
        g.
          drawRenderableImage(
            image,
            IDENTITY);
        g.
          dispose(
            );
        handleHREF(
          (java.awt.image.RenderedImage)
            buf,
          imageElement,
          generatorContext);
    }
    protected void cacheBufferedImage(org.w3c.dom.Element imageElement,
                                      java.awt.image.BufferedImage buf,
                                      org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.io.ByteArrayOutputStream os;
        if (generatorContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_CONTEXT_NULL);
        try {
            os =
              new java.io.ByteArrayOutputStream(
                );
            encodeImage(
              buf,
              os);
            os.
              flush(
                );
            os.
              close(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_UNEXPECTED,
              e);
        }
        java.lang.String ref =
          imageCacher.
          lookup(
            os,
            buf.
              getWidth(
                ),
            buf.
              getHeight(
                ),
            generatorContext);
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            getRefPrefix(
              ) +
            ref);
    }
    public abstract java.lang.String getRefPrefix();
    public abstract void encodeImage(java.awt.image.BufferedImage buf,
                                     java.io.OutputStream os)
          throws java.io.IOException;
    public abstract int getBufferedImageType();
    public DefaultCachedImageHandler() { super(
                                           );
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
       "eKGXbFZ0bzFKmUaXhHCaXTTjljompkuq");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "OEHhji1XBNvBT7DkXgdL+RFZsK3ZmeyxNLkxLJ2Afs+Be2nrYEX198G99wwj" +
       "eV+WPA3aLkPdlI4FRFnJ4a5v5+evdz60gKjv3CPgHTdmPhwxk7eeMJMPnz51" +
       "4rxCdpJu54NnqfyXbwTip/cQ/9wNR0ydQPzJayF+Nks+fhbia54UvBbiPhjw" +
       "Q3uIf/mGI87BXjxE/GvXQvzZLPmHwLrFzB+ctO6jyD99vdHDG8HAv7mH/Ddf" +
       "AvLDA6ffuNaefecLZ5T9kyx5PijcBfbsrKwwnqzoeYfEIcjPXwfIV2SZBAD3" +
       "xT2QX7yBIA+P0u55nKMHvYdh4IbBOAAbCSuH+sLZbvDe/YYnnfy/zJLfBfGP" +
       "bIuOJF/NDL50HQzdn2WChX7ny3sMffknZAb/5oyyr2fJVwB7wAyO2fv+OfL3" +
       "HIL96ksBmwSFV5/6sW/2teL9V/z/A9tv5sXPPXvh/H3PTv7d9iOL/e/ab6cK" +
       "55XQNI9+XHbk/lb3wIBv335qlh+j3vmToHDfKSt89o1YfpPJvvPH2/r/AcQ/" +
       "J+sHhVvyv0frfRO4xcN6oKvtzdEq3w4KN4Eq2e2f5wr9VLK1ufuP2kPGbOGe" +
       "azF70OTop6/Zdwr54fb9bwpCZu+jkeef7Q1+9ofoZ7af3oqmkKZZL+epwm3b" +
       "r4DzTrPvEl53am/7fd1KPPHjuz9/++P7DyXv3gp8aJtHZHv46t+25qFk9jVq" +
       "+jv3feGnf/XZP82PJ/9fHatlIoRDAAA=");
}
