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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVYfXBVRxXfvIR8EUgI5UM+AoRAhcJ70BarE6SFl4QEXsgz" +
       "AdSgfdzcty+5cN+9l3v3Jg8qUnAU7IzIFIqoBZ0R/GBo6VTrN4jjR9upFcGO" +
       "tmVs1f7RastM+cNSRa3n7N777sf7qIx/mJm7b7N7ztk9Z8/+zjl75ioZZ5mk" +
       "1ZC0tBRlOw1qRZPYT0qmRdNxVbKsjTCakh/40+E9139btzdCqgfJxBHJ6pUl" +
       "i3YpVE1bg2S2ollM0mRqbaA0jRxJk1rUHJWYomuDZIpi9WQNVZEV1qunKRJs" +
       "lswEmSQxZipDNqM9jgBG5iT4bmJ8N7HVYYL2BGmQdWOnxzAjwBD3zSFt1lvP" +
       "YqQpsU0alWI2U9RYQrFYe84ktxm6unNY1VmU5lh0m7rCMcS6xIoCM7Q+1vjW" +
       "jUMjTdwMkyVN0xlX0eqnlq6O0nSCNHqjnSrNWjvIJ0llgoz3ETPSlnAXjcGi" +
       "MVjU1dejgt1PoJqdjetcHeZKqjZk3BAj84JCDMmUso6YJN8zSKhlju6cGbSd" +
       "m9fWPe6Qig/dFjvyhXubHq8kjYOkUdEGcDsybILBIoNgUJodoqa1Op2m6UEy" +
       "SYMDH6CmIqnKLue0my1lWJOYDS7gmgUHbYOafE3PVnCSoJtpy0w38+pluFM5" +
       "/43LqNIw6DrV01Vo2IXjoGC9AhszMxL4nsNStV3R0tyPghx5HdvWAwGw1mQp" +
       "G9HzS1VpEgyQZuEiqqQNxwbA+bRhIB2ngwua3NdKCEVbG5K8XRqmKUamh+mS" +
       "Ygqo6rghkIWRKWEyLglOaUbolHznc3XDyoP3ad1ahFTAntNUVnH/44GpJcTU" +
       "TzPUpHAPBGPD4sRRaeq5AxFCgHhKiFjQfO8T1+5Z0nLhKUEzswhN39A2KrOU" +
       "fHJo4qVZ8UUfqMRt1Bq6peDhBzTntyzpzLTnDECaqXmJOBl1Jy/0//Kj95+m" +
       "r0dIfQ+plnXVzoIfTZL1rKGo1FxLNWpKjKZ7SB3V0nE+30NqoJ9QNCpG+zIZ" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "689+Lb9x/1/Wo0SEWyYAAA==");
}
