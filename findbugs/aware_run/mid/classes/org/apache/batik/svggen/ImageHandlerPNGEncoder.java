package org.apache.batik.svggen;
public class ImageHandlerPNGEncoder extends org.apache.batik.svggen.AbstractImageHandlerEncoder {
    public ImageHandlerPNGEncoder(java.lang.String imageDir, java.lang.String urlRoot)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        super(
          imageDir,
          urlRoot);
    }
    public final java.lang.String getSuffix() { return ".png"; }
    public final java.lang.String getPrefix() { return "pngImage";
    }
    public void encodeImage(java.awt.image.BufferedImage buf, java.io.File imageFile)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        try {
            java.io.OutputStream os =
              new java.io.FileOutputStream(
              imageFile);
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
            finally {
                os.
                  close(
                    );
            }
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_WRITE +
              imageFile.
                getName(
                  ));
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
      ("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" +
       "vYaG+4UXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/h9GwSKKeSMAAA==");
}
