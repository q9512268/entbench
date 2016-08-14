package org.apache.batik.bridge;
public abstract class SVGShapeElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge {
    protected SVGShapeElementBridge() { super(); }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.ShapeNode shapeNode =
          (org.apache.batik.gvt.ShapeNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (shapeNode ==
              null) {
            return null;
        }
        associateSVGContext(
          ctx,
          e,
          shapeNode);
        buildShape(
          ctx,
          e,
          shapeNode);
        java.awt.RenderingHints hints =
          null;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertColorRendering(
              e,
              hints);
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertShapeRendering(
              e,
              hints);
        if (hints !=
              null)
            shapeNode.
              setRenderingHints(
                hints);
        return shapeNode;
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.ShapeNode(
          );
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.GraphicsNode node) {
        org.apache.batik.gvt.ShapeNode shapeNode =
          (org.apache.batik.gvt.ShapeNode)
            node;
        shapeNode.
          setShapePainter(
            createShapePainter(
              ctx,
              e,
              shapeNode));
        super.
          buildGraphicsNode(
            ctx,
            e,
            node);
    }
    protected org.apache.batik.gvt.ShapePainter createShapePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.apache.batik.gvt.ShapeNode shapeNode) {
        return org.apache.batik.bridge.PaintServer.
          convertFillAndStroke(
            e,
            shapeNode,
            ctx);
    }
    protected abstract void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                                       org.w3c.dom.Element e,
                                       org.apache.batik.gvt.ShapeNode node);
    public boolean isComposite() { return false;
    }
    protected void handleGeometryChanged() {
        super.
          handleGeometryChanged(
            );
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
    protected boolean hasNewShapePainter;
    public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
        hasNewShapePainter =
          false;
        super.
          handleCSSEngineEvent(
            evt);
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_OPACITY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_OPACITY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_WIDTH_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_LINECAP_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_LINEJOIN_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_MITERLIMIT_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_DASHARRAY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_DASHOFFSET_INDEX:
                {
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
                }
            case org.apache.batik.css.engine.SVGCSSEngine.
                   SHAPE_RENDERING_INDEX:
                {
                    java.awt.RenderingHints hints =
                      node.
                      getRenderingHints(
                        );
                    hints =
                      org.apache.batik.bridge.CSSUtilities.
                        convertShapeRendering(
                          e,
                          hints);
                    if (hints !=
                          null) {
                        node.
                          setRenderingHints(
                            hints);
                    }
                    break;
                }
            case org.apache.batik.css.engine.SVGCSSEngine.
                   COLOR_RENDERING_INDEX:
                {
                    java.awt.RenderingHints hints =
                      node.
                      getRenderingHints(
                        );
                    hints =
                      org.apache.batik.bridge.CSSUtilities.
                        convertColorRendering(
                          e,
                          hints);
                    if (hints !=
                          null) {
                        node.
                          setRenderingHints(
                            hints);
                    }
                    break;
                }
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
       "/oEpXHlH6aiDpn2WeMW3+f8FBmOz1E4hAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cWgv4DfZyGd4m5A0ejHaLMfMdGvVdRRnNtl2QccZn9sdqbkLN8Y6Ww2jLR/z" +
       "bN+UgXh7TovrkYKV0KaJLZduP6nssuWI9NCqv8OTUJdGAN1iXg8r7nxerUce" +
       "oaGw3JRUfBTT7jppqe6427M785k/IGqyvp4PLJFurVs+wUQhvsimrbWbMDW2" +
       "16Frq3RDE5lkptXmmGGIGV4fbXXSnEbtobNK0N4AC5a5xRGwn0aZK45cm2JQ" +
       "gmmtgrA3svXApCaySdNVduQanm+PiUwY23Q1l5QJaTIbVXH74nCG9UkH4+fJ" +
       "RBj0MAoYkkz7QdDkul6lAvNaxbSqLrmLctcOlSDYDMj2hHCp+VaaT3adCUax" +
       "bXKn8bpaAbZDYz2sjoY9b8cwBrtYeLpeHy4icoNV457SbyeSGRqi2QiWMVJJ" +
       "CMNbzmYNZxALyWAmGuYw2CRre+dGi104IemdxvWnqtPOxjnFd1UNpp32mN6s" +
       "9I7DSCtrKTDmtIOMXWEwc2ZB7KuNZOv5W6c7yTnNdWrrNakNbW4lrISkmQ0t" +
       "pE5UOmZVEHczAniSTZgSP8bIVjbQapLKdLuIy2F1Xd1KVtRz9aoZcWhzADec" +
       "TsC2mIjssPZsTLRW1nqaEaIJ1yWRdBvYcpSxowRfTVtjxFUWPXTMEp4U8QlJ" +
       "V9Vc4r0oohPd6aVrEZfn4Rbv+b3MU+hpivM7DsaHTuCq8FIa9yarOWrSPTRu" +
       "7Mwl6BzFPO5LCy1tt9aENWtN81CkG/1s5A7mG8XVUiKnpGk2R9wmJbkDdNze" +
       "qcM0UkbojOfMLorWlq2GilCDvNluerM56jVTs+riLEbZa5JzavpyiOOVJbpN" +
       "xzOr26WcwW5jjFLGjkhxxfWTmoAp2syMMQ+nbJ2jaJSdeNSumnRkcbgjsnmo" +
       "9NzpWNvK6tgS/YymzXXALgMnrPR8qi4IMheIokF1moyjSW0tqXTjpjQls13P" +
       "biwFsU9XeU7Kd1xeyVgJm4RTRcvbDY9z0kZTWph5yOMD4K05hjLNOSpXrRba" +
       "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" +
       "H5WnxH8Hh6P+uD4sAAA=");
}
