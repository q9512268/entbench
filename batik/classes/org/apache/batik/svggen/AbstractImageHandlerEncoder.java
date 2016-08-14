package org.apache.batik.svggen;
public abstract class AbstractImageHandlerEncoder extends org.apache.batik.svggen.DefaultImageHandler {
    private static final java.awt.geom.AffineTransform IDENTITY = new java.awt.geom.AffineTransform(
      );
    private java.lang.String imageDir = "";
    private java.lang.String urlRoot = "";
    private static java.lang.reflect.Method createGraphics = null;
    private static boolean initDone = false;
    private static final java.lang.Class[] paramc = new java.lang.Class[] { java.awt.image.BufferedImage.class };
    private static java.lang.Object[] paramo = null;
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
            catch (java.lang.ThreadDeath td) {
                throw td;
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
    public AbstractImageHandlerEncoder(java.lang.String imageDir,
                                       java.lang.String urlRoot)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        super(
          );
        if (imageDir ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_IMAGE_DIR_NULL);
        java.io.File imageDirFile =
          new java.io.File(
          imageDir);
        if (!imageDirFile.
              exists(
                ))
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_IMAGE_DIR_DOES_NOT_EXIST);
        this.
          imageDir =
          imageDir;
        if (urlRoot !=
              null)
            this.
              urlRoot =
              urlRoot;
        else {
            try {
                this.
                  urlRoot =
                  imageDirFile.
                    toURL(
                      ).
                    toString(
                      );
            }
            catch (java.net.MalformedURLException e) {
                throw new org.apache.batik.svggen.SVGGraphics2DIOException(
                  ERR_CANNOT_USE_IMAGE_DIR +
                  e.
                    getMessage(
                      ),
                  e);
            }
        }
    }
    protected void handleHREF(java.awt.Image image, org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.awt.Dimension size =
          new java.awt.Dimension(
          image.
            getWidth(
              null),
          image.
            getHeight(
              null));
        java.awt.image.BufferedImage buf =
          buildBufferedImage(
            size);
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
        saveBufferedImageToFile(
          imageElement,
          buf,
          generatorContext);
    }
    protected void handleHREF(java.awt.image.RenderedImage image,
                              org.w3c.dom.Element imageElement,
                              org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.awt.Dimension size =
          new java.awt.Dimension(
          image.
            getWidth(
              ),
          image.
            getHeight(
              ));
        java.awt.image.BufferedImage buf =
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
        saveBufferedImageToFile(
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
        saveBufferedImageToFile(
          imageElement,
          buf,
          generatorContext);
    }
    private void saveBufferedImageToFile(org.w3c.dom.Element imageElement,
                                         java.awt.image.BufferedImage buf,
                                         org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        if (generatorContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_CONTEXT_NULL);
        java.io.File imageFile =
          null;
        while (imageFile ==
                 null) {
            java.lang.String fileId =
              generatorContext.
                idGenerator.
              generateID(
                getPrefix(
                  ));
            imageFile =
              new java.io.File(
                imageDir,
                fileId +
                getSuffix(
                  ));
            if (imageFile.
                  exists(
                    ))
                imageFile =
                  null;
        }
        encodeImage(
          buf,
          imageFile);
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            urlRoot +
            "/" +
            imageFile.
              getName(
                ));
    }
    public abstract java.lang.String getSuffix();
    public abstract java.lang.String getPrefix();
    public abstract void encodeImage(java.awt.image.BufferedImage buf,
                                     java.io.File imageFile)
          throws org.apache.batik.svggen.SVGGraphics2DIOException;
    public abstract java.awt.image.BufferedImage buildBufferedImage(java.awt.Dimension size);
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AmARCTTwTWeK9Tt5y2pvbSLgbURw69Bm");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("UwTRxqzRtgSb5RHRo5kc6q/zBYNmCrfImBnlBr3mLiKb+XYRiDTDcu4O5hk6" +
       "6SlLia7DnpfOyGiNNEwio8mOiBj1IeIWJ8shm7UTze12YzXhHLa5GJGoDkZN" +
       "W9hGEoUv1o4u9rf9DbYAzSQxOEgxOXnZBJIZ4EzgrpGvuzOKxFkK7SPNsGV2" +
       "ITLbiNPVFl6Ztud0IFH24QGHuPYEgOBgo+i5FPfWIFMfDOWc73XkLd4CImgb" +
       "tvNm2NmQqJNQCWumDVeCWaVhbLaiFE3620UyEe0FhtsCzgTkKkibrNMZGuh2" +
       "xQpcOMc5JJI02RpntusutPaojbXpSX0cIm3RmDeVCWs6k5mLE0UMB2G0LnRc" +
       "PPDsDofNZsWJUF2pMisuhUEyCPgAlyWYTCTfHLC5LplLdjD3xiNcCynZYLbh" +
       "FtSjNKgj9A5BysdoX7yzx3uvqZ5aniRC/jmeV6aXPUeOa1eVowyw0wSc6nO9" +
       "diGz7swz8TPpE7Xy/dJjt0p+rF4EfvL9L7yocb8CHr/yCePa/bEf/GVH3+rO" +
       "maHu3z+NPmHj8XL48v0qecQGefHR/KkWbv9c/vIEmjef5AJUr9sP+4lRJm5p" +
       "VVpcNcBXL3mi/Ydl8R9u+e75kZPBT3NxTm33H2/39PXsbBdU9GBZiRbXB49U" +
       "9IE7UNFBYYcg9GNdjXXtpkq6a++ax3I8eCJHpZYT8crkox2kHmq+e1jmU+tH" +
       "qc9FW/2yxKR9dkaxae5TlSsWvn1zO5U/WxXB/yyLb8S1a2aVrDgc48RNn3Nv" +
       "fUs7VfKf/CCU/IkjJX/8TpRc3v63V6Ldiy441j3txAVLmu+UxXfLoQ7uvY2W" +
       "Dq6VxcE5LZWN3zvRyMGVH4RGPn+kkc/9hWjk6QsaCSuNlG9Wj5RT3t5MPa+9" +
       "nXoeLYvrl6nnoe9DPVWqDVtcv3mknt+4U/UMLlPPibBfO5X4idtJXM5w8Fhc" +
       "e0OkbPVz6Cb5xFG+9RnxH/8+xH9TWflUcX3tSPyv3YH4p683v3xTHZyB3YPD" +
       "S9rKHfLg6QLhVnosFuJa1WiNUwmf+UFI+PUjCb/+FyThj1zS9q6yaO8l5EP9" +
       "Rgk734eEry0rB8X1zSMJv/kDlPDMe+mvHa/1B44TKEpnrOQjbufS5ZvvAySu" +
       "vUqv8tVPgOCMG/e/DxU8UVa2ius7Ryr4zg9QBRfCj4dPkA6ziu0zOsrQPZAu" +
       "sb9cFlzRd5lYjnZuSZ9qttICfydaSOPamy75U0CZ4fzoDf9I2v+LRv3Mi9ev" +
       "vuHFyb/ZJy4d/9PlfqZ21Ugc52zm6Jn7e4MT571/n0da5SMcPF+A1S2ihzIp" +
       "tLopuT94z55+Gdceukgf1+6pvs/S6QXsn9IVQ+1vzpKYce2ugqS8tYLbhjKY" +
       "biiJc05Z6cH5EPnYFLWHb2eKM1H1k+dShaqkkuO0noQ/ytv67IsU++Pf7vzK" +
       "PqNfdZQ8L0e5ytTu2/+5oBq0TA162y1HOx7r3uHT33vwc/e//ThOf3DP8KmX" +
       "n+HtLTdPn8fdIK4S3vNfe8M/ftffe/EPquyG/we5YKxKxTcAAA==");
}
