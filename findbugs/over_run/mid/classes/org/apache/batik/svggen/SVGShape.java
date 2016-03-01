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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "a45QFSUAAA==");
}
