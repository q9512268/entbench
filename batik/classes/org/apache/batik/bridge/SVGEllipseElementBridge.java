package org.apache.batik.bridge;
public class SVGEllipseElementBridge extends org.apache.batik.bridge.SVGShapeElementBridge {
    public SVGEllipseElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_ELLIPSE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGEllipseElementBridge(
                                                            ); }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        try {
            org.apache.batik.dom.svg.SVGOMEllipseElement ee =
              (org.apache.batik.dom.svg.SVGOMEllipseElement)
                e;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _cx =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ee.
                getCx(
                  );
            float cx =
              _cx.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _cy =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ee.
                getCy(
                  );
            float cy =
              _cy.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _rx =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ee.
                getRx(
                  );
            float rx =
              _rx.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _ry =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ee.
                getRy(
                  );
            float ry =
              _ry.
              getCheckedValue(
                );
            shapeNode.
              setShape(
                new java.awt.geom.Ellipse2D.Float(
                  cx -
                    rx,
                  cy -
                    ry,
                  rx *
                    2,
                  ry *
                    2));
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
                    SVG_CX_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_CY_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_RX_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_RY_ATTRIBUTE)) {
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
    protected org.apache.batik.gvt.ShapePainter createShapePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.apache.batik.gvt.ShapeNode shapeNode) {
        java.awt.geom.Rectangle2D r2d =
          shapeNode.
          getShape(
            ).
          getBounds2D(
            );
        if (r2d.
              getWidth(
                ) ==
              0 ||
              r2d.
              getHeight(
                ) ==
              0)
            return null;
        return super.
          createShapePainter(
            ctx,
            e,
            shapeNode);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OkWhDQ7Vl17Y359xcZf5J2ve/g92DYEdvxkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LHo0OkglAAA=");
}
