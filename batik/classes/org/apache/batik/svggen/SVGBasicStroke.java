package org.apache.batik.svggen;
public class SVGBasicStroke extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGBasicStroke(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        if (gc.
              getStroke(
                ) instanceof java.awt.BasicStroke)
            return toSVG(
                     (java.awt.BasicStroke)
                       gc.
                       getStroke(
                         ));
        else
            return null;
    }
    public final org.apache.batik.svggen.SVGStrokeDescriptor toSVG(java.awt.BasicStroke stroke) {
        java.lang.String strokeWidth =
          doubleString(
            stroke.
              getLineWidth(
                ));
        java.lang.String capStyle =
          endCapToSVG(
            stroke.
              getEndCap(
                ));
        java.lang.String joinStyle =
          joinToSVG(
            stroke.
              getLineJoin(
                ));
        java.lang.String miterLimit =
          doubleString(
            stroke.
              getMiterLimit(
                ));
        float[] array =
          stroke.
          getDashArray(
            );
        java.lang.String dashArray =
          null;
        if (array !=
              null)
            dashArray =
              dashArrayToSVG(
                array);
        else
            dashArray =
              SVG_NONE_VALUE;
        java.lang.String dashOffset =
          doubleString(
            stroke.
              getDashPhase(
                ));
        return new org.apache.batik.svggen.SVGStrokeDescriptor(
          strokeWidth,
          capStyle,
          joinStyle,
          miterLimit,
          dashArray,
          dashOffset);
    }
    private final java.lang.String dashArrayToSVG(float[] dashArray) {
        java.lang.StringBuffer dashArrayBuf =
          new java.lang.StringBuffer(
          dashArray.
            length *
            8);
        if (dashArray.
              length >
              0)
            dashArrayBuf.
              append(
                doubleString(
                  dashArray[0]));
        for (int i =
               1;
             i <
               dashArray.
                 length;
             i++) {
            dashArrayBuf.
              append(
                COMMA);
            dashArrayBuf.
              append(
                doubleString(
                  dashArray[i]));
        }
        return dashArrayBuf.
          toString(
            );
    }
    private static java.lang.String joinToSVG(int lineJoin) {
        switch (lineJoin) {
            case java.awt.BasicStroke.
                   JOIN_BEVEL:
                return SVG_BEVEL_VALUE;
            case java.awt.BasicStroke.
                   JOIN_ROUND:
                return SVG_ROUND_VALUE;
            case java.awt.BasicStroke.
                   JOIN_MITER:
            default:
                return SVG_MITER_VALUE;
        }
    }
    private static java.lang.String endCapToSVG(int endCap) {
        switch (endCap) {
            case java.awt.BasicStroke.
                   CAP_BUTT:
                return SVG_BUTT_VALUE;
            case java.awt.BasicStroke.
                   CAP_ROUND:
                return SVG_ROUND_VALUE;
            default:
            case java.awt.BasicStroke.
                   CAP_SQUARE:
                return SVG_SQUARE_VALUE;
        }
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
      ("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");
}
