package org.apache.batik.svggen;
public class CachedImageHandlerJPEGEncoder extends org.apache.batik.svggen.DefaultCachedImageHandler {
    public static final java.lang.String CACHED_JPEG_PREFIX = "jpegImage";
    public static final java.lang.String CACHED_JPEG_SUFFIX = ".jpg";
    protected java.lang.String refPrefix = "";
    public CachedImageHandlerJPEGEncoder(java.lang.String imageDir, java.lang.String urlRoot)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        super(
          );
        refPrefix =
          urlRoot +
          "/";
        setImageCacher(
          new org.apache.batik.svggen.ImageCacher.External(
            imageDir,
            CACHED_JPEG_PREFIX,
            CACHED_JPEG_SUFFIX));
    }
    public void encodeImage(java.awt.image.BufferedImage buf, java.io.OutputStream os)
          throws java.io.IOException { org.apache.batik.ext.awt.image.spi.ImageWriter writer =
                                         org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.
                                         getInstance(
                                           ).
                                         getWriterFor(
                                           "image/jpeg");
                                       org.apache.batik.ext.awt.image.spi.ImageWriterParams params =
                                         new org.apache.batik.ext.awt.image.spi.ImageWriterParams(
                                         );
                                       params.
                                         setJPEGQuality(
                                           1,
                                           false);
                                       writer.
                                         writeImage(
                                           buf,
                                           os,
                                           params);
    }
    public int getBufferedImageType() { return java.awt.image.BufferedImage.
                                                 TYPE_INT_RGB;
    }
    public java.lang.String getRefPrefix() {
        return refPrefix;
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
       "JgAA");
}
