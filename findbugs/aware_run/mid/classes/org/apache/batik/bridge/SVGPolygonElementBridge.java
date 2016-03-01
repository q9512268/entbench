package org.apache.batik.bridge;
public class SVGPolygonElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge {
    protected static final java.awt.Shape DEFAULT_SHAPE = new java.awt.geom.GeneralPath(
      );
    public SVGPolygonElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_POLYGON_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGPolygonElementBridge(
                                                            );
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.dom.svg.SVGOMPolygonElement pe =
          (org.apache.batik.dom.svg.SVGOMPolygonElement)
            e;
        try {
            org.apache.batik.dom.svg.SVGOMAnimatedPoints _points =
              pe.
              getSVGOMAnimatedPoints(
                );
            _points.
              check(
                );
            org.w3c.dom.svg.SVGPointList pl =
              _points.
              getAnimatedPoints(
                );
            int size =
              pl.
              getNumberOfItems(
                );
            if (size ==
                  0) {
                shapeNode.
                  setShape(
                    DEFAULT_SHAPE);
            }
            else {
                org.apache.batik.parser.AWTPolygonProducer app =
                  new org.apache.batik.parser.AWTPolygonProducer(
                  );
                app.
                  setWindingRule(
                    org.apache.batik.bridge.CSSUtilities.
                      convertFillRule(
                        e));
                app.
                  startPoints(
                    );
                for (int i =
                       0;
                     i <
                       size;
                     i++) {
                    org.w3c.dom.svg.SVGPoint p =
                      pl.
                      getItem(
                        i);
                    app.
                      point(
                        p.
                          getX(
                            ),
                        p.
                          getY(
                            ));
                }
                app.
                  endPoints(
                    );
                shapeNode.
                  setShape(
                    app.
                      getShape(
                        ));
            }
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null) {
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ln.
                  equals(
                    SVG_POINTS_ATTRIBUTE)) {
                buildShape(
                  ctx,
                  e,
                  (org.apache.batik.gvt.ShapeNode)
                    node);
                handleGeometryChanged(
                  );
                return;
            }
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_RULE_INDEX:
                buildShape(
                  ctx,
                  e,
                  (org.apache.batik.gvt.ShapeNode)
                    node);
                handleGeometryChanged(
                  );
                break;
            default:
                super.
                  handleCSSPropertyChanged(
                    property);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/wIEaCtfzBsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "o09/vTjS+V/hAeytIicAAA==");
}
