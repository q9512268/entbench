package org.apache.batik.svggen;
public class SVGTexturePaint extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGTexturePaint(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 (java.awt.TexturePaint)
                   gc.
                   getPaint(
                     ));
    }
    public org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.TexturePaint texture) {
        org.apache.batik.svggen.SVGPaintDescriptor patternDesc =
          (org.apache.batik.svggen.SVGPaintDescriptor)
            descMap.
            get(
              texture);
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        if (patternDesc ==
              null) {
            java.awt.geom.Rectangle2D anchorRect =
              texture.
              getAnchorRect(
                );
            org.w3c.dom.Element patternDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_PATTERN_TAG);
            patternDef.
              setAttributeNS(
                null,
                SVG_PATTERN_UNITS_ATTRIBUTE,
                SVG_USER_SPACE_ON_USE_VALUE);
            patternDef.
              setAttributeNS(
                null,
                SVG_X_ATTRIBUTE,
                doubleString(
                  anchorRect.
                    getX(
                      )));
            patternDef.
              setAttributeNS(
                null,
                SVG_Y_ATTRIBUTE,
                doubleString(
                  anchorRect.
                    getY(
                      )));
            patternDef.
              setAttributeNS(
                null,
                SVG_WIDTH_ATTRIBUTE,
                doubleString(
                  anchorRect.
                    getWidth(
                      )));
            patternDef.
              setAttributeNS(
                null,
                SVG_HEIGHT_ATTRIBUTE,
                doubleString(
                  anchorRect.
                    getHeight(
                      )));
            java.awt.image.BufferedImage textureImage =
              texture.
              getImage(
                );
            if (textureImage.
                  getWidth(
                    ) >
                  0 &&
                  textureImage.
                  getHeight(
                    ) >
                  0) {
                if (textureImage.
                      getWidth(
                        ) !=
                      anchorRect.
                      getWidth(
                        ) ||
                      textureImage.
                      getHeight(
                        ) !=
                      anchorRect.
                      getHeight(
                        )) {
                    if (anchorRect.
                          getWidth(
                            ) >
                          0 &&
                          anchorRect.
                          getHeight(
                            ) >
                          0) {
                        double scaleX =
                          anchorRect.
                          getWidth(
                            ) /
                          textureImage.
                          getWidth(
                            );
                        double scaleY =
                          anchorRect.
                          getHeight(
                            ) /
                          textureImage.
                          getHeight(
                            );
                        java.awt.image.BufferedImage newImage =
                          new java.awt.image.BufferedImage(
                          (int)
                            (scaleX *
                               textureImage.
                               getWidth(
                                 )),
                          (int)
                            (scaleY *
                               textureImage.
                               getHeight(
                                 )),
                          java.awt.image.BufferedImage.
                            TYPE_INT_ARGB);
                        java.awt.Graphics2D g =
                          newImage.
                          createGraphics(
                            );
                        g.
                          scale(
                            scaleX,
                            scaleY);
                        g.
                          drawImage(
                            textureImage,
                            0,
                            0,
                            null);
                        g.
                          dispose(
                            );
                        textureImage =
                          newImage;
                    }
                }
            }
            org.w3c.dom.Element patternContent =
              generatorContext.
                genericImageHandler.
              createElement(
                generatorContext);
            generatorContext.
              genericImageHandler.
              handleImage(
                (java.awt.image.RenderedImage)
                  textureImage,
                patternContent,
                0,
                0,
                textureImage.
                  getWidth(
                    ),
                textureImage.
                  getHeight(
                    ),
                generatorContext);
            patternDef.
              appendChild(
                patternContent);
            patternDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_PATTERN));
            java.lang.String patternAttrBuf =
              URL_PREFIX +
            SIGN_POUND +
            patternDef.
              getAttributeNS(
                null,
                SVG_ID_ATTRIBUTE) +
            URL_SUFFIX;
            patternDesc =
              new org.apache.batik.svggen.SVGPaintDescriptor(
                patternAttrBuf,
                SVG_OPAQUE_VALUE,
                patternDef);
            descMap.
              put(
                texture,
                patternDesc);
            defSet.
              add(
                patternDef);
        }
        return patternDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mikxFQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
