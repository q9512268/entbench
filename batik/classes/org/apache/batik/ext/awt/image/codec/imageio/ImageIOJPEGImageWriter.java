package org.apache.batik.ext.awt.image.codec.imageio;
public class ImageIOJPEGImageWriter extends org.apache.batik.ext.awt.image.codec.imageio.ImageIOImageWriter {
    private static final java.lang.String JPEG_NATIVE_FORMAT = "javax_imageio_jpeg_image_1.0";
    public ImageIOJPEGImageWriter() { super("image/jpeg"); }
    protected javax.imageio.metadata.IIOMetadata updateMetadata(javax.imageio.metadata.IIOMetadata meta,
                                                                org.apache.batik.ext.awt.image.spi.ImageWriterParams params) {
        if (JPEG_NATIVE_FORMAT.
              equals(
                meta.
                  getNativeMetadataFormatName(
                    ))) {
            meta =
              addAdobeTransform(
                meta);
            javax.imageio.metadata.IIOMetadataNode root =
              (javax.imageio.metadata.IIOMetadataNode)
                meta.
                getAsTree(
                  JPEG_NATIVE_FORMAT);
            javax.imageio.metadata.IIOMetadataNode jv =
              getChildNode(
                root,
                "JPEGvariety");
            if (jv ==
                  null) {
                jv =
                  new javax.imageio.metadata.IIOMetadataNode(
                    "JPEGvariety");
                root.
                  appendChild(
                    jv);
            }
            javax.imageio.metadata.IIOMetadataNode child;
            if (params.
                  getResolution(
                    ) !=
                  null) {
                child =
                  getChildNode(
                    jv,
                    "app0JFIF");
                if (child ==
                      null) {
                    child =
                      new javax.imageio.metadata.IIOMetadataNode(
                        "app0JFIF");
                    jv.
                      appendChild(
                        child);
                }
                child.
                  setAttribute(
                    "majorVersion",
                    null);
                child.
                  setAttribute(
                    "minorVersion",
                    null);
                child.
                  setAttribute(
                    "resUnits",
                    "1");
                child.
                  setAttribute(
                    "Xdensity",
                    params.
                      getResolution(
                        ).
                      toString(
                        ));
                child.
                  setAttribute(
                    "Ydensity",
                    params.
                      getResolution(
                        ).
                      toString(
                        ));
                child.
                  setAttribute(
                    "thumbWidth",
                    null);
                child.
                  setAttribute(
                    "thumbHeight",
                    null);
            }
            try {
                meta.
                  setFromTree(
                    JPEG_NATIVE_FORMAT,
                    root);
            }
            catch (javax.imageio.metadata.IIOInvalidTreeException e) {
                throw new java.lang.RuntimeException(
                  "Cannot update image metadata: " +
                  e.
                    getMessage(
                      ),
                  e);
            }
        }
        return meta;
    }
    private static javax.imageio.metadata.IIOMetadata addAdobeTransform(javax.imageio.metadata.IIOMetadata meta) {
        javax.imageio.metadata.IIOMetadataNode root =
          (javax.imageio.metadata.IIOMetadataNode)
            meta.
            getAsTree(
              JPEG_NATIVE_FORMAT);
        javax.imageio.metadata.IIOMetadataNode markerSequence =
          getChildNode(
            root,
            "markerSequence");
        if (markerSequence ==
              null) {
            throw new java.lang.RuntimeException(
              "Invalid metadata!");
        }
        javax.imageio.metadata.IIOMetadataNode adobeTransform =
          getChildNode(
            markerSequence,
            "app14Adobe");
        if (adobeTransform ==
              null) {
            adobeTransform =
              new javax.imageio.metadata.IIOMetadataNode(
                "app14Adobe");
            adobeTransform.
              setAttribute(
                "transform",
                "1");
            adobeTransform.
              setAttribute(
                "version",
                "101");
            adobeTransform.
              setAttribute(
                "flags0",
                "0");
            adobeTransform.
              setAttribute(
                "flags1",
                "0");
            markerSequence.
              appendChild(
                adobeTransform);
        }
        else {
            adobeTransform.
              setAttribute(
                "transform",
                "1");
        }
        try {
            meta.
              setFromTree(
                JPEG_NATIVE_FORMAT,
                root);
        }
        catch (javax.imageio.metadata.IIOInvalidTreeException e) {
            throw new java.lang.RuntimeException(
              "Cannot update image metadata: " +
              e.
                getMessage(
                  ),
              e);
        }
        return meta;
    }
    protected javax.imageio.ImageWriteParam getDefaultWriteParam(javax.imageio.ImageWriter iiowriter,
                                                                 java.awt.image.RenderedImage image,
                                                                 org.apache.batik.ext.awt.image.spi.ImageWriterParams params) {
        javax.imageio.plugins.jpeg.JPEGImageWriteParam param =
          new javax.imageio.plugins.jpeg.JPEGImageWriteParam(
          iiowriter.
            getLocale(
              ));
        return param;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456836489000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "WXP134nWJxZYGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456836489000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "wvC/f3d4zuglAAA=");
}
