package org.apache.batik.ext.awt.image.codec.util;
public abstract class ImageDecoderImpl implements org.apache.batik.ext.awt.image.codec.util.ImageDecoder {
    protected org.apache.batik.ext.awt.image.codec.util.SeekableStream input;
    protected org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam param;
    public ImageDecoderImpl(org.apache.batik.ext.awt.image.codec.util.SeekableStream input,
                            org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam param) {
        super(
          );
        this.
          input =
          input;
        this.
          param =
          param;
    }
    public ImageDecoderImpl(java.io.InputStream input, org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam param) {
        super(
          );
        this.
          input =
          new org.apache.batik.ext.awt.image.codec.util.ForwardSeekableStream(
            input);
        this.
          param =
          param;
    }
    public org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam getParam() {
        return param;
    }
    public void setParam(org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam param) {
        this.
          param =
          param;
    }
    public org.apache.batik.ext.awt.image.codec.util.SeekableStream getInputStream() {
        return input;
    }
    public int getNumPages() throws java.io.IOException {
        return 1;
    }
    public java.awt.image.Raster decodeAsRaster()
          throws java.io.IOException { return decodeAsRaster(
                                                0);
    }
    public java.awt.image.Raster decodeAsRaster(int page)
          throws java.io.IOException { java.awt.image.RenderedImage im =
                                         decodeAsRenderedImage(
                                           page);
                                       return im.
                                         getData(
                                           );
    }
    public java.awt.image.RenderedImage decodeAsRenderedImage()
          throws java.io.IOException { return decodeAsRenderedImage(
                                                0);
    }
    public abstract java.awt.image.RenderedImage decodeAsRenderedImage(int page)
          throws java.io.IOException;
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
       "V2/7+e/+5y/9UXlQ/P8Aagj4MYwtAAA=");
}
