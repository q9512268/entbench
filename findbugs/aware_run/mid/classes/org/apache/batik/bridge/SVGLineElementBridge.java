package org.apache.batik.bridge;
public class SVGLineElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge {
    public SVGLineElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_LINE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGLineElementBridge(
                                                            ); }
    protected org.apache.batik.gvt.ShapePainter createFillStrokePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                        org.w3c.dom.Element e,
                                                                        org.apache.batik.gvt.ShapeNode shapeNode) {
        return org.apache.batik.bridge.PaintServer.
          convertStrokePainter(
            e,
            shapeNode,
            ctx);
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        try {
            org.apache.batik.dom.svg.SVGOMLineElement le =
              (org.apache.batik.dom.svg.SVGOMLineElement)
                e;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x1 =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                le.
                getX1(
                  );
            float x1 =
              _x1.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y1 =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                le.
                getY1(
                  );
            float y1 =
              _y1.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x2 =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                le.
                getX2(
                  );
            float x2 =
              _x2.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y2 =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                le.
                getY2(
                  );
            float y2 =
              _y2.
              getCheckedValue(
                );
            shapeNode.
              setShape(
                new java.awt.geom.Line2D.Float(
                  x1,
                  y1,
                  x2,
                  y2));
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
                    SVG_X1_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_Y1_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_X2_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_Y2_ATTRIBUTE)) {
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
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "sCqlAgl+JoSeltScgqHQKkr/C0nRIYjiGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fpW4+aM7/+DNv/38N/Lbif8D0fr/hSYlAAA=");
}
