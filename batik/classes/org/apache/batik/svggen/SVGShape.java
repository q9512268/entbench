package org.apache.batik.svggen;
public class SVGShape extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    private org.apache.batik.svggen.SVGArc svgArc;
    private org.apache.batik.svggen.SVGEllipse svgEllipse;
    private org.apache.batik.svggen.SVGLine svgLine;
    private org.apache.batik.svggen.SVGPath svgPath;
    private org.apache.batik.svggen.SVGPolygon svgPolygon;
    private org.apache.batik.svggen.SVGRectangle svgRectangle;
    public SVGShape(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
        svgArc =
          new org.apache.batik.svggen.SVGArc(
            generatorContext);
        svgEllipse =
          new org.apache.batik.svggen.SVGEllipse(
            generatorContext);
        svgLine =
          new org.apache.batik.svggen.SVGLine(
            generatorContext);
        svgPath =
          new org.apache.batik.svggen.SVGPath(
            generatorContext);
        svgPolygon =
          new org.apache.batik.svggen.SVGPolygon(
            generatorContext);
        svgRectangle =
          new org.apache.batik.svggen.SVGRectangle(
            generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.Shape shape) { if (shape instanceof java.awt.Polygon)
                                                                 return svgPolygon.
                                                                   toSVG(
                                                                     (java.awt.Polygon)
                                                                       shape);
                                                             else
                                                                 if (shape instanceof java.awt.geom.Rectangle2D)
                                                                     return svgRectangle.
                                                                       toSVG(
                                                                         (java.awt.geom.Rectangle2D)
                                                                           shape);
                                                                 else
                                                                     if (shape instanceof java.awt.geom.RoundRectangle2D)
                                                                         return svgRectangle.
                                                                           toSVG(
                                                                             (java.awt.geom.RoundRectangle2D)
                                                                               shape);
                                                                     else
                                                                         if (shape instanceof java.awt.geom.Ellipse2D)
                                                                             return svgEllipse.
                                                                               toSVG(
                                                                                 (java.awt.geom.Ellipse2D)
                                                                                   shape);
                                                                         else
                                                                             if (shape instanceof java.awt.geom.Line2D)
                                                                                 return svgLine.
                                                                                   toSVG(
                                                                                     (java.awt.geom.Line2D)
                                                                                       shape);
                                                                             else
                                                                                 if (shape instanceof java.awt.geom.Arc2D)
                                                                                     return svgArc.
                                                                                       toSVG(
                                                                                         (java.awt.geom.Arc2D)
                                                                                           shape);
                                                                                 else
                                                                                     return svgPath.
                                                                                       toSVG(
                                                                                         shape);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "9xkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KUhCBT0lAAA=");
}
