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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
