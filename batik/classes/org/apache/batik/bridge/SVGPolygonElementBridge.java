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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Vrz/H750I82jHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "QicAAA==");
}
