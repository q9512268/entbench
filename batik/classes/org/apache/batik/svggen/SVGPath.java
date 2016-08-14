package org.apache.batik.svggen;
public class SVGPath extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    public SVGPath(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.Shape path) { java.lang.String dAttr =
                                                              toSVGPathData(
                                                                path,
                                                                generatorContext);
                                                            if (dAttr ==
                                                                  null ||
                                                                  dAttr.
                                                                  length(
                                                                    ) ==
                                                                  0) {
                                                                return null;
                                                            }
                                                            org.w3c.dom.Element svgPath =
                                                              generatorContext.
                                                                domFactory.
                                                              createElementNS(
                                                                SVG_NAMESPACE_URI,
                                                                SVG_PATH_TAG);
                                                            svgPath.
                                                              setAttributeNS(
                                                                null,
                                                                SVG_D_ATTRIBUTE,
                                                                dAttr);
                                                            if (path.
                                                                  getPathIterator(
                                                                    null).
                                                                  getWindingRule(
                                                                    ) ==
                                                                  java.awt.geom.GeneralPath.
                                                                    WIND_EVEN_ODD)
                                                                svgPath.
                                                                  setAttributeNS(
                                                                    null,
                                                                    SVG_FILL_RULE_ATTRIBUTE,
                                                                    SVG_EVEN_ODD_VALUE);
                                                            return svgPath;
    }
    public static java.lang.String toSVGPathData(java.awt.Shape path,
                                                 org.apache.batik.svggen.SVGGeneratorContext gc) {
        java.lang.StringBuffer d =
          new java.lang.StringBuffer(
          40);
        java.awt.geom.PathIterator pi =
          path.
          getPathIterator(
            null);
        float[] seg =
          new float[6];
        int segType =
          0;
        while (!pi.
                 isDone(
                   )) {
            segType =
              pi.
                currentSegment(
                  seg);
            switch (segType) {
                case java.awt.geom.PathIterator.
                       SEG_MOVETO:
                    d.
                      append(
                        PATH_MOVE);
                    appendPoint(
                      d,
                      seg[0],
                      seg[1],
                      gc);
                    break;
                case java.awt.geom.PathIterator.
                       SEG_LINETO:
                    d.
                      append(
                        PATH_LINE_TO);
                    appendPoint(
                      d,
                      seg[0],
                      seg[1],
                      gc);
                    break;
                case java.awt.geom.PathIterator.
                       SEG_CLOSE:
                    d.
                      append(
                        PATH_CLOSE);
                    break;
                case java.awt.geom.PathIterator.
                       SEG_QUADTO:
                    d.
                      append(
                        PATH_QUAD_TO);
                    appendPoint(
                      d,
                      seg[0],
                      seg[1],
                      gc);
                    appendPoint(
                      d,
                      seg[2],
                      seg[3],
                      gc);
                    break;
                case java.awt.geom.PathIterator.
                       SEG_CUBICTO:
                    d.
                      append(
                        PATH_CUBIC_TO);
                    appendPoint(
                      d,
                      seg[0],
                      seg[1],
                      gc);
                    appendPoint(
                      d,
                      seg[2],
                      seg[3],
                      gc);
                    appendPoint(
                      d,
                      seg[4],
                      seg[5],
                      gc);
                    break;
                default:
                    throw new java.lang.Error(
                      "invalid segmentType:" +
                      segType);
            }
            pi.
              next(
                );
        }
        if (d.
              length(
                ) >
              0)
            return d.
              toString(
                ).
              trim(
                );
        else {
            return "";
        }
    }
    private static void appendPoint(java.lang.StringBuffer d,
                                    float x,
                                    float y,
                                    org.apache.batik.svggen.SVGGeneratorContext gc) {
        d.
          append(
            gc.
              doubleString(
                x));
        d.
          append(
            SPACE);
        d.
          append(
            gc.
              doubleString(
                y));
        d.
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
      ("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");
}
