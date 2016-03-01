package org.apache.batik.bridge;
public class SVGPolylineElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge {
    protected static final java.awt.Shape DEFAULT_SHAPE = new java.awt.geom.GeneralPath(
      );
    public SVGPolylineElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_POLYLINE_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGPolylineElementBridge(
                                                            );
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.dom.svg.SVGOMPolylineElement pe =
          (org.apache.batik.dom.svg.SVGOMPolylineElement)
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
                org.apache.batik.parser.AWTPolylineProducer app =
                  new org.apache.batik.parser.AWTPolylineProducer(
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
       "4oX/ApRgVnPQGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
