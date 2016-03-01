package org.apache.batik.svggen;
public class SVGArc extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    private org.apache.batik.svggen.SVGLine svgLine;
    private org.apache.batik.svggen.SVGEllipse svgEllipse;
    public SVGArc(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.Arc2D arc) { double ext =
                                                                  arc.
                                                                  getAngleExtent(
                                                                    );
                                                                double width =
                                                                  arc.
                                                                  getWidth(
                                                                    );
                                                                double height =
                                                                  arc.
                                                                  getHeight(
                                                                    );
                                                                if (width ==
                                                                      0 ||
                                                                      height ==
                                                                      0) {
                                                                    java.awt.geom.Line2D line =
                                                                      new java.awt.geom.Line2D.Double(
                                                                      arc.
                                                                        getX(
                                                                          ),
                                                                      arc.
                                                                        getY(
                                                                          ),
                                                                      arc.
                                                                        getX(
                                                                          ) +
                                                                        width,
                                                                      arc.
                                                                        getY(
                                                                          ) +
                                                                        height);
                                                                    if (svgLine ==
                                                                          null) {
                                                                        svgLine =
                                                                          new org.apache.batik.svggen.SVGLine(
                                                                            generatorContext);
                                                                    }
                                                                    return svgLine.
                                                                      toSVG(
                                                                        line);
                                                                }
                                                                if (ext >=
                                                                      360 ||
                                                                      ext <=
                                                                      -360) {
                                                                    java.awt.geom.Ellipse2D ellipse =
                                                                      new java.awt.geom.Ellipse2D.Double(
                                                                      arc.
                                                                        getX(
                                                                          ),
                                                                      arc.
                                                                        getY(
                                                                          ),
                                                                      width,
                                                                      height);
                                                                    if (svgEllipse ==
                                                                          null) {
                                                                        svgEllipse =
                                                                          new org.apache.batik.svggen.SVGEllipse(
                                                                            generatorContext);
                                                                    }
                                                                    return svgEllipse.
                                                                      toSVG(
                                                                        ellipse);
                                                                }
                                                                org.w3c.dom.Element svgPath =
                                                                  generatorContext.
                                                                    domFactory.
                                                                  createElementNS(
                                                                    SVG_NAMESPACE_URI,
                                                                    SVG_PATH_TAG);
                                                                java.lang.StringBuffer d =
                                                                  new java.lang.StringBuffer(
                                                                  64);
                                                                java.awt.geom.Point2D startPt =
                                                                  arc.
                                                                  getStartPoint(
                                                                    );
                                                                java.awt.geom.Point2D endPt =
                                                                  arc.
                                                                  getEndPoint(
                                                                    );
                                                                int type =
                                                                  arc.
                                                                  getArcType(
                                                                    );
                                                                d.
                                                                  append(
                                                                    PATH_MOVE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      startPt.
                                                                        getX(
                                                                          )));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      startPt.
                                                                        getY(
                                                                          )));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    PATH_ARC);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      width /
                                                                        2));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      height /
                                                                        2));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    '0');
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                if (ext >
                                                                      0) {
                                                                    if (ext >
                                                                          180)
                                                                        d.
                                                                          append(
                                                                            '1');
                                                                    else
                                                                        d.
                                                                          append(
                                                                            '0');
                                                                    d.
                                                                      append(
                                                                        SPACE);
                                                                    d.
                                                                      append(
                                                                        '0');
                                                                }
                                                                else {
                                                                    if (ext <
                                                                          -180)
                                                                        d.
                                                                          append(
                                                                            '1');
                                                                    else
                                                                        d.
                                                                          append(
                                                                            '0');
                                                                    d.
                                                                      append(
                                                                        SPACE);
                                                                    d.
                                                                      append(
                                                                        '1');
                                                                }
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      endPt.
                                                                        getX(
                                                                          )));
                                                                d.
                                                                  append(
                                                                    SPACE);
                                                                d.
                                                                  append(
                                                                    doubleString(
                                                                      endPt.
                                                                        getY(
                                                                          )));
                                                                if (type ==
                                                                      java.awt.geom.Arc2D.
                                                                        CHORD) {
                                                                    d.
                                                                      append(
                                                                        PATH_CLOSE);
                                                                }
                                                                else
                                                                    if (type ==
                                                                          java.awt.geom.Arc2D.
                                                                            PIE) {
                                                                        double cx =
                                                                          arc.
                                                                          getX(
                                                                            ) +
                                                                          width /
                                                                          2;
                                                                        double cy =
                                                                          arc.
                                                                          getY(
                                                                            ) +
                                                                          height /
                                                                          2;
                                                                        d.
                                                                          append(
                                                                            PATH_LINE_TO);
                                                                        d.
                                                                          append(
                                                                            SPACE);
                                                                        d.
                                                                          append(
                                                                            doubleString(
                                                                              cx));
                                                                        d.
                                                                          append(
                                                                            SPACE);
                                                                        d.
                                                                          append(
                                                                            doubleString(
                                                                              cy));
                                                                        d.
                                                                          append(
                                                                            SPACE);
                                                                        d.
                                                                          append(
                                                                            PATH_CLOSE);
                                                                    }
                                                                svgPath.
                                                                  setAttributeNS(
                                                                    null,
                                                                    SVG_D_ATTRIBUTE,
                                                                    d.
                                                                      toString(
                                                                        ));
                                                                return svgPath;
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
       "+WwhAAA=");
}
