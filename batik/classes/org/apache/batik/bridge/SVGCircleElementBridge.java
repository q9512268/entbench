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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ikLrHKovu7C/P+PiLvNP1rz1HxiAIGC7GQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2W9ktxn/B57JMYxAJQAA");
}
