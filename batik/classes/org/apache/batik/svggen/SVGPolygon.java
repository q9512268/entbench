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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LcsN8muLzR/d/wdv/O0Xv55XNf8XZc4lrFghAAA=");
}
