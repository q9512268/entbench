package org.apache.batik.svggen;
public class SVGRenderingHints extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGRenderingHints(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getRenderingHints(
                     ));
    }
    public static org.apache.batik.svggen.SVGHintsDescriptor toSVG(java.awt.RenderingHints hints) {
        java.lang.String colorInterpolation =
          SVG_AUTO_VALUE;
        java.lang.String colorRendering =
          SVG_AUTO_VALUE;
        java.lang.String textRendering =
          SVG_AUTO_VALUE;
        java.lang.String shapeRendering =
          SVG_AUTO_VALUE;
        java.lang.String imageRendering =
          SVG_AUTO_VALUE;
        if (hints !=
              null) {
            java.lang.Object rendering =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_RENDERING);
            if (rendering ==
                  java.awt.RenderingHints.
                    VALUE_RENDER_DEFAULT) {
                colorInterpolation =
                  SVG_AUTO_VALUE;
                colorRendering =
                  SVG_AUTO_VALUE;
                textRendering =
                  SVG_AUTO_VALUE;
                shapeRendering =
                  SVG_AUTO_VALUE;
                imageRendering =
                  SVG_AUTO_VALUE;
            }
            else
                if (rendering ==
                      java.awt.RenderingHints.
                        VALUE_RENDER_SPEED) {
                    colorInterpolation =
                      SVG_SRGB_VALUE;
                    colorRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                    textRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                    shapeRendering =
                      SVG_GEOMETRIC_PRECISION_VALUE;
                    imageRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                }
                else
                    if (rendering ==
                          java.awt.RenderingHints.
                            VALUE_RENDER_QUALITY) {
                        colorInterpolation =
                          SVG_LINEAR_RGB_VALUE;
                        colorRendering =
                          SVG_OPTIMIZE_QUALITY_VALUE;
                        textRendering =
                          SVG_OPTIMIZE_QUALITY_VALUE;
                        shapeRendering =
                          SVG_GEOMETRIC_PRECISION_VALUE;
                        imageRendering =
                          SVG_OPTIMIZE_QUALITY_VALUE;
                    }
            java.lang.Object fractionalMetrics =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_FRACTIONALMETRICS);
            if (fractionalMetrics ==
                  java.awt.RenderingHints.
                    VALUE_FRACTIONALMETRICS_ON) {
                textRendering =
                  SVG_OPTIMIZE_QUALITY_VALUE;
                shapeRendering =
                  SVG_GEOMETRIC_PRECISION_VALUE;
            }
            else
                if (fractionalMetrics ==
                      java.awt.RenderingHints.
                        VALUE_FRACTIONALMETRICS_OFF) {
                    textRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                    shapeRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                }
                else
                    if (fractionalMetrics ==
                          java.awt.RenderingHints.
                            VALUE_FRACTIONALMETRICS_DEFAULT) {
                        textRendering =
                          SVG_AUTO_VALUE;
                        shapeRendering =
                          SVG_AUTO_VALUE;
                    }
            java.lang.Object antialiasing =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_ANTIALIASING);
            if (antialiasing ==
                  java.awt.RenderingHints.
                    VALUE_ANTIALIAS_ON) {
                textRendering =
                  SVG_OPTIMIZE_LEGIBILITY_VALUE;
                shapeRendering =
                  SVG_AUTO_VALUE;
            }
            else
                if (antialiasing ==
                      java.awt.RenderingHints.
                        VALUE_ANTIALIAS_OFF) {
                    textRendering =
                      SVG_GEOMETRIC_PRECISION_VALUE;
                    shapeRendering =
                      SVG_CRISP_EDGES_VALUE;
                }
                else
                    if (antialiasing ==
                          java.awt.RenderingHints.
                            VALUE_ANTIALIAS_DEFAULT) {
                        textRendering =
                          SVG_AUTO_VALUE;
                        shapeRendering =
                          SVG_AUTO_VALUE;
                    }
            java.lang.Object textAntialiasing =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_TEXT_ANTIALIASING);
            if (textAntialiasing ==
                  java.awt.RenderingHints.
                    VALUE_TEXT_ANTIALIAS_ON)
                textRendering =
                  SVG_GEOMETRIC_PRECISION_VALUE;
            else
                if (textAntialiasing ==
                      java.awt.RenderingHints.
                        VALUE_TEXT_ANTIALIAS_OFF)
                    textRendering =
                      SVG_OPTIMIZE_SPEED_VALUE;
                else
                    if (textAntialiasing ==
                          java.awt.RenderingHints.
                            VALUE_TEXT_ANTIALIAS_DEFAULT)
                        textRendering =
                          SVG_AUTO_VALUE;
            java.lang.Object colorRenderingHint =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_COLOR_RENDERING);
            if (colorRenderingHint ==
                  java.awt.RenderingHints.
                    VALUE_COLOR_RENDER_DEFAULT)
                colorRendering =
                  SVG_AUTO_VALUE;
            else
                if (colorRenderingHint ==
                      java.awt.RenderingHints.
                        VALUE_COLOR_RENDER_QUALITY)
                    colorRendering =
                      SVG_OPTIMIZE_QUALITY_VALUE;
                else
                    if (colorRenderingHint ==
                          java.awt.RenderingHints.
                            VALUE_COLOR_RENDER_SPEED)
                        colorRendering =
                          SVG_OPTIMIZE_SPEED_VALUE;
            java.lang.Object interpolation =
              hints.
              get(
                java.awt.RenderingHints.
                  KEY_INTERPOLATION);
            if (interpolation ==
                  java.awt.RenderingHints.
                    VALUE_INTERPOLATION_NEAREST_NEIGHBOR)
                imageRendering =
                  SVG_OPTIMIZE_SPEED_VALUE;
            else
                if (interpolation ==
                      java.awt.RenderingHints.
                        VALUE_INTERPOLATION_BICUBIC ||
                      interpolation ==
                      java.awt.RenderingHints.
                        VALUE_INTERPOLATION_BILINEAR)
                    imageRendering =
                      SVG_OPTIMIZE_QUALITY_VALUE;
        }
        return new org.apache.batik.svggen.SVGHintsDescriptor(
          colorInterpolation,
          colorRendering,
          textRendering,
          shapeRendering,
          imageRendering);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gX571gOe+Pe6kH9NPOLwzH8Aej/4S1YVAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vPn33v6bL3wrvy78H6X7il/GIAAA");
}
