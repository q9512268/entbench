package org.apache.batik.svggen;
public class CachedImageHandlerPNGEncoder extends org.apache.batik.svggen.DefaultCachedImageHandler {
    public static final java.lang.String CACHED_PNG_PREFIX = "pngImage";
    public static final java.lang.String CACHED_PNG_SUFFIX = ".png";
    protected java.lang.String refPrefix = "";
    public CachedImageHandlerPNGEncoder(java.lang.String imageDir, java.lang.String urlRoot)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        super(
          );
        refPrefix =
          urlRoot +
          "/";
        setImageCacher(
          new org.apache.batik.svggen.ImageCacher.External(
            imageDir,
            CACHED_PNG_PREFIX,
            CACHED_PNG_SUFFIX));
    }
    public void encodeImage(java.awt.image.BufferedImage buf, java.io.OutputStream os)
          throws java.io.IOException { org.apache.batik.ext.awt.image.spi.ImageWriter writer =
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
    public int getBufferedImageType() { return java.awt.image.BufferedImage.
                                                 TYPE_INT_ARGB;
    }
    public java.lang.String getRefPrefix() {
        return refPrefix;
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
       "9/3ua3/9qa8Ul+7/CyZyZdZYJgAA");
}
