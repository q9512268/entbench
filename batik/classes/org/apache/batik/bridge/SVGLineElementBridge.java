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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/vGdf/j63332m/ktx/8B6KwgllIlAAA=");
}
