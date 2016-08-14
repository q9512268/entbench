package org.apache.batik.bridge;
public abstract class SVGDecoratedShapeElementBridge extends org.apache.batik.bridge.SVGShapeElementBridge {
    protected SVGDecoratedShapeElementBridge() { super(); }
    org.apache.batik.gvt.ShapePainter createFillStrokePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                              org.w3c.dom.Element e,
                                                              org.apache.batik.gvt.ShapeNode shapeNode) {
        return super.
          createShapePainter(
            ctx,
            e,
            shapeNode);
    }
    org.apache.batik.gvt.ShapePainter createMarkerPainter(org.apache.batik.bridge.BridgeContext ctx,
                                                          org.w3c.dom.Element e,
                                                          org.apache.batik.gvt.ShapeNode shapeNode) {
        return org.apache.batik.bridge.PaintServer.
          convertMarkers(
            e,
            shapeNode,
            ctx);
    }
    protected org.apache.batik.gvt.ShapePainter createShapePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.gvt.ShapePainter fillAndStroke;
        fillAndStroke =
          createFillStrokePainter(
            ctx,
            e,
            shapeNode);
        org.apache.batik.gvt.ShapePainter markerPainter =
          createMarkerPainter(
            ctx,
            e,
            shapeNode);
        java.awt.Shape shape =
          shapeNode.
          getShape(
            );
        org.apache.batik.gvt.ShapePainter painter;
        if (markerPainter !=
              null) {
            if (fillAndStroke !=
                  null) {
                org.apache.batik.gvt.CompositeShapePainter cp =
                  new org.apache.batik.gvt.CompositeShapePainter(
                  shape);
                cp.
                  addShapePainter(
                    fillAndStroke);
                cp.
                  addShapePainter(
                    markerPainter);
                painter =
                  cp;
            }
            else {
                painter =
                  markerPainter;
            }
        }
        else {
            painter =
              fillAndStroke;
        }
        return painter;
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   MARKER_START_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   MARKER_MID_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   MARKER_END_INDEX:
                if (!hasNewShapePainter) {
                    hasNewShapePainter =
                      true;
                    org.apache.batik.gvt.ShapeNode shapeNode =
                      (org.apache.batik.gvt.ShapeNode)
                        node;
                    shapeNode.
                      setShapePainter(
                        createShapePainter(
                          ctx,
                          e,
                          shapeNode));
                }
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
       "r33B4OF81g98vJPPfpl/suYn/wZ/usjTSxkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
