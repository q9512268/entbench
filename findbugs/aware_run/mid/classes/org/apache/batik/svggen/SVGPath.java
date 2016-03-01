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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BizLRea6q8LyliVy8/s4nPwPMVZk9gMXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
