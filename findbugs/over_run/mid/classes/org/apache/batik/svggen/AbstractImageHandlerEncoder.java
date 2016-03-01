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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "CVSbwFPopRkxtV1dxm883bjMOGdcJmJXDTzHLOWO5cHFP7V43RMIq/Jw9N8X" +
       "At5rAnffImxCEHy7qdkGyEhMsoUOGOHzB8ZxS/Tj5w0MP455FK7L01ePTS0H" +
       "o0Wn2WAsPmcwWPazHJ6TlugnzxsYfhw9CrvS0Q/sKFRqH+xwNTAoVg22plqx" +
       "aTLJSMqupe0Q5V5HkXNGqxq7LoXnE0u3T84bWn4c8ydolelw3SBB1mBYl2aB" +
       "6/N4lYDN92BsV1KSYxnhxzECA+zaoQOWMsnEPP8sgHda47P+i4n/5434yEB5" +
       "8biBa17ntRr7v2NKo6Q4npRl95WL671QSy+MUn4Bw84tgR4Irz6pE96msBfU" +
       "IdDN6dfBUcxLD4dW9ttNB6NLHDpgxV/cJOtNUgAk+Kprg+ZxDTQuJOUMsFKB" +
       "zPOGbRAy6A7pOqLMyKhNsEOoXUdItlgFqL0DK1bddHrR/fyqXZSFfnZuHBkl" +
       "RfzWnzEtyCpmubnZvAqbZp8t2zdipn3oGc0FdhbERMcHMbcJaOgMEzz30EZN" +
       "+jr6zd2Ln3lla+GRIAmsIQEB0uQ12dd3KS2pk6lrorlqu6sFnV2R15a8v/bQ" +
       "528FKtktKeEloSn5RnSK2555uyWuaT8NkhERMhzOdDTF7hYbNiitVOzVM0rF" +
       "hV1qUknXEsvQcwW8GU8X0wDQUemv+K8aJqnOrpxn//tKiaz2UX0pckc2ozzV" +
       "m6SmuXsZsrdi059CpMENO6MrNc26MijaypDXNFypAUZ32/8A2ZziaUUqAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ipA6YHIcw9bloRcsy/O0y4/jASNQYW/Y");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("zliGUDhs28CaHuOPqO3QoEOccWeCRkbWsuePKt1hVdG0fsBBi60/m096C2ce" +
       "Azy3uEU2dTI82nY8O1aceYL5ytxDo1qmmZ4Du4Ra6WmGgnOU2qcUdSAzSwrP" +
       "MriCz+nyKmhkWm3kwJYllwmOxOyQHOPtSgz8dk2Dh5Oat25YgRtYftwIe45Y" +
       "46oIcD4gZYzU0N4wWkdDHbfciYNwzmRYQxAk3k5jmUfptQGmNDJG6/K9piEp" +
       "tGlGInB+qUrQM8SqL6ydGR4mY2AdKNjcZpVNdyzodlIeovLAd5jASx0Iioam" +
       "nNWEWcVT12rNzTLRbkzseBbOw0AzK2D/9iicZhpUQKu1BmWu5K3XndG9rYcJ" +
       "c7gGoVhtnpmyIPgYhv1Yfg32lVu7nru/uHU8CnL8C9w3pufdA0eli/JBBNdx" +
       "AE3xuVw6EzV34k77RPhDKX8/9OiNAhuLF3mf+8iLL2nML1cPX9kEUenuyPV+" +
       "xNIT3Tox1N272+QjMh7Lh8/fj5IHZJBnr9aPpXDze/XzA2DeefQuv3hdvt8G" +
       "joce6FoR1lYM8I1zbqT/ME/+4w3fHT94NPhxLM2x7v7TzW5PT852RkT35YUd" +
       "8HzsQEQfvQUR7QE9eIEb6Wqka9cV0m070zzk474jPgqxHLGXBw9tYHVfc+39" +
       "PFZaPwhrBnXl8wKLdtEVbnAQhlyQ8Mb19ZT/rBcN/leefCsqXTKKYMM+h/eu" +
       "e0+duKZ2LOQ/+UEI+bMHQv7MrQg5z/73NyPdsybI6Y52ZIJ5m+/kyXfzofbu" +
       "vImU9i7lyd4pKeWV3zuSyN6FH4REfvVAIl/6S5HI02ckEhQSyd+MHggnz15P" +
       "PG+9mXgezpPL54nnyvchniJUhgbPbx6I5zduVTzEeeI5Yva1Y46fvBnH+Qx7" +
       "j0alh0I50U+hG+/2DmKpT7D/2PfB/jvywqvgee2A/ddugf3j15Nfu64MTsDu" +
       "3v45dfkOufc0QLilHk0Au2YxWuWYw2d+EBx+84DDb/4lcfij59S9L0+QHYds" +
       "oF/LYeP74PCteSEBntcPOHz9B8jhiffKrx2u9XsPAyByYyz4693MpPM313tY" +
       "VLpHL+LNj4DghBm3vw8RPJkX1sHznQMRfOcHKIIz7scDR0jXNcH2GR5E2O7x" +
       "5+h/licM6KvEpqWdWtLHki2kwN6KFNKo9I5zgvrzCOWHr/m30e4fMuoXX7p8" +
       "8aGXhH+7Czw6/BfL3aPSxUVsWScjP0/k7/SOjPfuXRxoEU+w9zwAqxt4D3lQ" +
       "Z5HJqd/74K69EpWunG0fle4ovk+20wHsH7cDQ+0yJ5sYUek20CTPmt5NXZmu" +
       "vpBj65Sw0r3TLvKhKkoP3EwVJ7zqp06F+hRBIYdhOTF7EHf1yksD+ifeaPzy" +
       "LiJfteQsy0e5OCrdtftzQDFoHtrzxA1HOxzrzv7T37vvS3e/+9BPv29H8LGV" +
       "n6DtXdcPf8dtLyoC1rNfe+ifvO/vv/QHRXTC/wP1d8dMoTcAAA==");
}
