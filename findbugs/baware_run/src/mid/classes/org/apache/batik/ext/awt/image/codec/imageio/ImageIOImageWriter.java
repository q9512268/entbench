package org.apache.batik.ext.awt.image.codec.imageio;
public class ImageIOImageWriter implements org.apache.batik.ext.awt.image.spi.ImageWriter, javax.imageio.event.IIOWriteWarningListener {
    private java.lang.String targetMIME;
    public ImageIOImageWriter(java.lang.String mime) { super();
                                                       this.targetMIME = mime;
    }
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out)
          throws java.io.IOException { writeImage(image, out, null);
    }
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out,
                           org.apache.batik.ext.awt.image.spi.ImageWriterParams params)
          throws java.io.IOException { java.util.Iterator iter;
                                       iter = javax.imageio.ImageIO.
                                                getImageWritersByMIMEType(
                                                  getMIMEType(
                                                    ));
                                       javax.imageio.ImageWriter iiowriter =
                                         null;
                                       try { iiowriter =
                                               (javax.imageio.ImageWriter)
                                                 iter.
                                                 next(
                                                   );
                                             if (iiowriter !=
                                                   null) {
                                                 iiowriter.
                                                   addIIOWriteWarningListener(
                                                     this);
                                                 javax.imageio.stream.ImageOutputStream imgout =
                                                   null;
                                                 try {
                                                     imgout =
                                                       javax.imageio.ImageIO.
                                                         createImageOutputStream(
                                                           out);
                                                     javax.imageio.ImageWriteParam iwParam =
                                                       getDefaultWriteParam(
                                                         iiowriter,
                                                         image,
                                                         params);
                                                     javax.imageio.ImageTypeSpecifier type;
                                                     if (iwParam.
                                                           getDestinationType(
                                                             ) !=
                                                           null) {
                                                         type =
                                                           iwParam.
                                                             getDestinationType(
                                                               );
                                                     }
                                                     else {
                                                         type =
                                                           javax.imageio.ImageTypeSpecifier.
                                                             createFromRenderedImage(
                                                               image);
                                                     }
                                                     javax.imageio.metadata.IIOMetadata meta =
                                                       iiowriter.
                                                       getDefaultImageMetadata(
                                                         type,
                                                         iwParam);
                                                     if (params !=
                                                           null &&
                                                           meta !=
                                                           null) {
                                                         meta =
                                                           updateMetadata(
                                                             meta,
                                                             params);
                                                     }
                                                     iiowriter.
                                                       setOutput(
                                                         imgout);
                                                     javax.imageio.IIOImage iioimg =
                                                       new javax.imageio.IIOImage(
                                                       image,
                                                       null,
                                                       meta);
                                                     iiowriter.
                                                       write(
                                                         null,
                                                         iioimg,
                                                         iwParam);
                                                 }
                                                 finally {
                                                     if (imgout !=
                                                           null) {
                                                         java.lang.System.
                                                           err.
                                                           println(
                                                             "closing");
                                                         imgout.
                                                           close(
                                                             );
                                                     }
                                                 }
                                             }
                                             else {
                                                 throw new java.lang.UnsupportedOperationException(
                                                   "No ImageIO codec for writing " +
                                                   getMIMEType(
                                                     ) +
                                                   " is available!");
                                             }
                                       }
                                       finally {
                                           if (iiowriter !=
                                                 null) {
                                               java.lang.System.
                                                 err.
                                                 println(
                                                   "disposing");
                                               iiowriter.
                                                 dispose(
                                                   );
                                           }
                                       } }
    protected javax.imageio.ImageWriteParam getDefaultWriteParam(javax.imageio.ImageWriter iiowriter,
                                                                 java.awt.image.RenderedImage image,
                                                                 org.apache.batik.ext.awt.image.spi.ImageWriterParams params) {
        javax.imageio.ImageWriteParam param =
          iiowriter.
          getDefaultWriteParam(
            );
        java.lang.System.
          err.
          println(
            "Param: " +
            params);
        if (params !=
              null &&
              params.
              getCompressionMethod(
                ) !=
              null) {
            param.
              setCompressionMode(
                javax.imageio.ImageWriteParam.
                  MODE_EXPLICIT);
            param.
              setCompressionType(
                params.
                  getCompressionMethod(
                    ));
        }
        return param;
    }
    protected javax.imageio.metadata.IIOMetadata updateMetadata(javax.imageio.metadata.IIOMetadata meta,
                                                                org.apache.batik.ext.awt.image.spi.ImageWriterParams params) {
        final java.lang.String stdmeta =
          "javax_imageio_1.0";
        if (meta.
              isStandardMetadataFormatSupported(
                )) {
            javax.imageio.metadata.IIOMetadataNode root =
              (javax.imageio.metadata.IIOMetadataNode)
                meta.
                getAsTree(
                  stdmeta);
            javax.imageio.metadata.IIOMetadataNode dim =
              getChildNode(
                root,
                "Dimension");
            javax.imageio.metadata.IIOMetadataNode child;
            if (params.
                  getResolution(
                    ) !=
                  null) {
                child =
                  getChildNode(
                    dim,
                    "HorizontalPixelSize");
                if (child ==
                      null) {
                    child =
                      new javax.imageio.metadata.IIOMetadataNode(
                        "HorizontalPixelSize");
                    dim.
                      appendChild(
                        child);
                }
                child.
                  setAttribute(
                    "value",
                    java.lang.Double.
                      toString(
                        params.
                          getResolution(
                            ).
                          doubleValue(
                            ) /
                          25.4));
                child =
                  getChildNode(
                    dim,
                    "VerticalPixelSize");
                if (child ==
                      null) {
                    child =
                      new javax.imageio.metadata.IIOMetadataNode(
                        "VerticalPixelSize");
                    dim.
                      appendChild(
                        child);
                }
                child.
                  setAttribute(
                    "value",
                    java.lang.Double.
                      toString(
                        params.
                          getResolution(
                            ).
                          doubleValue(
                            ) /
                          25.4));
            }
            try {
                meta.
                  mergeTree(
                    stdmeta,
                    root);
            }
            catch (javax.imageio.metadata.IIOInvalidTreeException e) {
                throw new java.lang.RuntimeException(
                  "Cannot update image metadata: " +
                  e.
                    getMessage(
                      ));
            }
        }
        return meta;
    }
    protected static javax.imageio.metadata.IIOMetadataNode getChildNode(org.w3c.dom.Node n,
                                                                         java.lang.String name) {
        org.w3c.dom.NodeList nodes =
          n.
          getChildNodes(
            );
        for (int i =
               0;
             i <
               nodes.
               getLength(
                 );
             i++) {
            org.w3c.dom.Node child =
              nodes.
              item(
                i);
            if (name.
                  equals(
                    child.
                      getNodeName(
                        ))) {
                return (javax.imageio.metadata.IIOMetadataNode)
                         child;
            }
        }
        return null;
    }
    public java.lang.String getMIMEType() {
        return this.
                 targetMIME;
    }
    public void warningOccurred(javax.imageio.ImageWriter source,
                                int imageIndex,
                                java.lang.String warning) {
        java.lang.System.
          err.
          println(
            "Problem while writing image using ImageI/O: " +
            warning);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739551000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1Ze5AUxRnv3TvuxcEdhzxEOPA8qPBwNyjEWEdQOA9Z3OOu" +
       "OMTKkXj0zvbeDczODDM9dwsGFZIIZVLEAiQmCn9EzMPgo6yYxKQkJDFBY4SC" +
       "WD4rPmKqNCpVUql4JiYx39c9szM7+yBX5I9s1fT29nxf99df/75X79GzZJxt" +
       "kTaT6mka49tMZsd6sd9LLZulOzVq2+thdEC58839t43+oX5nlNT0k4lD1O5W" +
       "qM1WqUxL2/1klqrbnOoKs9cylkaOXovZzBqmXDX0fjJFtRNZU1MVlXcbaYYE" +
       "G6iVJJMo55aacjhLuBNwMjsppIkLaeIrwgQdSdKoGOY2n2FGAUNn4B3SZv31" +
       "bE6ak5vpMI07XNXiSdXmHTmLLDQNbdugZvAYy/HYZm2pq4g1yaVFamh7tOnD" +
       "j+8aahZqmEx13eBii/Y6ZhvaMEsnSZM/2qWxrL2V3EqqkmR8gJiT9qS3aBwW" +
       "jcOi3n59KpB+AtOdbKchtsO9mWpMBQXi5NLCSUxq0aw7Ta+QGWao4+7eBTPs" +
       "dk5+t95xh7Z498L4gW/e3PxYFWnqJ02q3ofiKCAEh0X6QaEsm2KWvSKdZul+" +
       "MkmHA+9jlko1dbt72i22OqhT7gAEPLXgoGMyS6zp6wpOEvZmOQo3rPz2MgJU" +
       "7q9xGY0Owl6n+nuVO1yF47DBBhUEszIUsOeyVG9R9bTAUSFHfo/tNwABsNZm" +
       "GR8y8ktV6xQGSIuEiEb1wXgfgE8fBNJxBkDQElgrMynq2qTKFjrIBjiZHqbr" +
       "la+Aql4oAlk4mRImEzPBKc0InVLgfM6uXbb3Fn21HiURkDnNFA3lHw9MrSGm" +
       "dSzDLAZ2IBkbFyQP0qlP7okSAsRTQsSS5idfOnftotbjT0uaS0rQ9KQ2M4UP" +
       "KEdSE0/P7Jx/dRWKUWcatoqHX7BzYWW97puOnAmeZmp+RnwZ814eX/fbz9/+" +
       "IHsvShoSpEYxNCcLOJqkGFlT1Zh1PdOZRTlLJ0g909Od4n2C1EI/qepMjvZk" +
       "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" +
       "vULzpoleJtKAP178D9V3OU2sHwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739551000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
