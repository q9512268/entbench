package org.apache.batik.bridge;
public class SVGCircleElementBridge extends org.apache.batik.bridge.SVGShapeElementBridge {
    public SVGCircleElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_CIRCLE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGCircleElementBridge(
                                                            ); }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        try {
            org.apache.batik.dom.svg.SVGOMCircleElement ce =
              (org.apache.batik.dom.svg.SVGOMCircleElement)
                e;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _cx =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ce.
                getCx(
                  );
            float cx =
              _cx.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _cy =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ce.
                getCy(
                  );
            float cy =
              _cy.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _r =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ce.
                getR(
                  );
            float r =
              _r.
              getCheckedValue(
                );
            float x =
              cx -
              r;
            float y =
              cy -
              r;
            float w =
              r *
              2;
            shapeNode.
              setShape(
                new java.awt.geom.Ellipse2D.Float(
                  x,
                  y,
                  w,
                  w));
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
                    SVG_R_ATTRIBUTE)) {
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nhPUjIKi0DrD+C9zl5Qn3BgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/gQuJBglAAA=");
}
