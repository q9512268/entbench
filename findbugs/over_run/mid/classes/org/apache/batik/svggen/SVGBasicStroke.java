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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KQAA");
}
