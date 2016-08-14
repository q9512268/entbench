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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Kaz4GzvzfFHpcy3JWraq8zpYsbojV+2p");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "ODccbVP2KkeK36k2ungVq1y0ih0tzN1hK9UMLz8gWHS6yRM3Kt2246rDtegz" +
       "LHkvgKXieC3Y1uyJByyJ14elM9DvPnIv1BKsqOEhuPdcYCTvzZPHQVs1Xlr6" +
       "qYAoLzne9e39/AudDyQQ9R0HBLz9+syHE2by02fM5EPnT52kqJCfwtv7wEUq" +
       "/+XrgfjxA8Q/d90RD84g/vizIX4yTz56EeJnPWX4bIj7YMAPHiD+5euOuAB7" +
       "1zHiX382xJ/Ok38IrFvL/cFZ6z6J/JMvNHp4Ixj4cwfIP/c8kB8fVv36s+3Z" +
       "9z5/Qdk/yZOno9IdYM/OGfNRYMyXRYedY5CffQEgX5JndgC4LxyA/MJ1BHl8" +
       "DPfA45w8JD6MIy+O+AhsJOwC6jMXu8F7DhuedfL/Mk9+F8Q/hqO5unEtM/ji" +
       "C2DovjwTLPR7Xzpg6Es/JjP4NxeUfS1PvgzYA2Zwyt4Pz6C/+xjsV54P2DQq" +
       "vfzcD4XzLx3vu+r/J9h9U6995skrl+99Uvx3uw80Dr97v3VQujyPLevkh2kn" +
       "7m/2jgz41t1nasUR7L0/iUr3nrPC59+XFTe57Ht/vKv/H0D8c7Z+VLqp+Huy" +
       "3jeAWzyuB7ra3Zys8q2odAOokt/+eaHQT6Q7m7vvpD3kzJbufjZmj5qc/Gw2" +
       "/8ahOBh/+D1CPDr44OTpJ3vsz/6g9qndZ7uapWRZ3svlQemW3RfERaf5Nw2v" +
       "Pbe3w75u7jz8ozs/e+vrDx9K3rkT+Ng2T8j26mt/F1uEkvmXrNnv3Pv5n/q1" +
       "J/+0ONr8fwHEpIp2pEMAAA==");
}
