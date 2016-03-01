package org.apache.batik.svggen;
public class SVGPolygon extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    public SVGPolygon(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.Polygon polygon) { org.w3c.dom.Element svgPolygon =
                                                                   generatorContext.
                                                                     domFactory.
                                                                   createElementNS(
                                                                     SVG_NAMESPACE_URI,
                                                                     SVG_POLYGON_TAG);
                                                                 java.lang.StringBuffer points =
                                                                   new java.lang.StringBuffer(
                                                                   " ");
                                                                 java.awt.geom.PathIterator pi =
                                                                   polygon.
                                                                   getPathIterator(
                                                                     null);
                                                                 float[] seg =
                                                                   new float[6];
                                                                 while (!pi.
                                                                          isDone(
                                                                            )) {
                                                                     int segType =
                                                                       pi.
                                                                       currentSegment(
                                                                         seg);
                                                                     switch (segType) {
                                                                         case java.awt.geom.PathIterator.
                                                                                SEG_MOVETO:
                                                                             appendPoint(
                                                                               points,
                                                                               seg[0],
                                                                               seg[1]);
                                                                             break;
                                                                         case java.awt.geom.PathIterator.
                                                                                SEG_LINETO:
                                                                             appendPoint(
                                                                               points,
                                                                               seg[0],
                                                                               seg[1]);
                                                                             break;
                                                                         case java.awt.geom.PathIterator.
                                                                                SEG_CLOSE:
                                                                             break;
                                                                         case java.awt.geom.PathIterator.
                                                                                SEG_QUADTO:
                                                                         case java.awt.geom.PathIterator.
                                                                                SEG_CUBICTO:
                                                                         default:
                                                                             throw new java.lang.Error(
                                                                               "invalid segmentType:" +
                                                                               segType);
                                                                     }
                                                                     pi.
                                                                       next(
                                                                         );
                                                                 }
                                                                 svgPolygon.
                                                                   setAttributeNS(
                                                                     null,
                                                                     SVG_POINTS_ATTRIBUTE,
                                                                     points.
                                                                       substring(
                                                                         0,
                                                                         points.
                                                                           length(
                                                                             ) -
                                                                           1));
                                                                 return svgPolygon;
    }
    private void appendPoint(java.lang.StringBuffer points,
                             float x,
                             float y) { points.
                                          append(
                                            doubleString(
                                              x));
                                        points.
                                          append(
                                            SPACE);
                                        points.
                                          append(
                                            doubleString(
                                              y));
                                        points.
                                          append(
                                            SPACE);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IQAA");
}
