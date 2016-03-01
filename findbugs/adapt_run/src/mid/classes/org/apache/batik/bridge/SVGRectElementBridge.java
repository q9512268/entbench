package org.apache.batik.bridge;
public class SVGRectElementBridge extends org.apache.batik.bridge.SVGShapeElementBridge {
    public SVGRectElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_RECT_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGRectElementBridge(
                                                            ); }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        try {
            org.apache.batik.dom.svg.SVGOMRectElement re =
              (org.apache.batik.dom.svg.SVGOMRectElement)
                e;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getX(
                  );
            float x =
              _x.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getY(
                  );
            float y =
              _y.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _width =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getWidth(
                  );
            float w =
              _width.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _height =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getHeight(
                  );
            float h =
              _height.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _rx =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getRx(
                  );
            float rx =
              _rx.
              getCheckedValue(
                );
            if (rx >
                  w /
                  2) {
                rx =
                  w /
                    2;
            }
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _ry =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getRy(
                  );
            float ry =
              _ry.
              getCheckedValue(
                );
            if (ry >
                  h /
                  2) {
                ry =
                  h /
                    2;
            }
            java.awt.Shape shape;
            if (rx ==
                  0 ||
                  ry ==
                  0) {
                shape =
                  new java.awt.geom.Rectangle2D.Float(
                    x,
                    y,
                    w,
                    h);
            }
            else {
                shape =
                  new java.awt.geom.RoundRectangle2D.Float(
                    x,
                    y,
                    w,
                    h,
                    rx *
                      2,
                    ry *
                      2);
            }
            shapeNode.
              setShape(
                shape);
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
                    SVG_X_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_Y_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_WIDTH_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_HEIGHT_ATTRIBUTE) ||
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
        java.awt.Shape shape =
          shapeNode.
          getShape(
            );
        java.awt.geom.Rectangle2D r2d =
          shape.
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
       "p2AotIrS/wIIXfd91BgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3UH8H8fjZeoMJQAA");
}
