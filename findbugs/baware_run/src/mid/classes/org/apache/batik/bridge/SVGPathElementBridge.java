package org.apache.batik.bridge;
public class SVGPathElementBridge extends org.apache.batik.bridge.SVGDecoratedShapeElementBridge implements org.apache.batik.dom.svg.SVGPathContext {
    protected static final java.awt.Shape DEFAULT_SHAPE = new java.awt.geom.GeneralPath(
      );
    public SVGPathElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_PATH_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGPathElementBridge(
                                                            );
    }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        org.apache.batik.dom.svg.SVGOMPathElement pe =
          (org.apache.batik.dom.svg.SVGOMPathElement)
            e;
        org.apache.batik.parser.AWTPathProducer app =
          new org.apache.batik.parser.AWTPathProducer(
          );
        try {
            org.apache.batik.dom.svg.SVGOMAnimatedPathData _d =
              pe.
              getAnimatedPathData(
                );
            _d.
              check(
                );
            org.w3c.dom.svg.SVGPathSegList p =
              _d.
              getAnimatedPathSegList(
                );
            app.
              setWindingRule(
                org.apache.batik.bridge.CSSUtilities.
                  convertFillRule(
                    e));
            org.apache.batik.dom.svg.SVGAnimatedPathDataSupport.
              handlePathSegList(
                p,
                app);
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
        finally {
            shapeNode.
              setShape(
                app.
                  getShape(
                    ));
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null &&
              alav.
              getLocalName(
                ).
              equals(
                SVG_D_ATTRIBUTE)) {
            buildShape(
              ctx,
              e,
              (org.apache.batik.gvt.ShapeNode)
                node);
            handleGeometryChanged(
              );
        }
        else {
            super.
              handleAnimatedAttributeChanged(
                alav);
        }
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
    protected java.awt.Shape pathLengthShape;
    protected org.apache.batik.ext.awt.geom.PathLength
      pathLength;
    protected org.apache.batik.ext.awt.geom.PathLength getPathLengthObj() {
        java.awt.Shape s =
          ((org.apache.batik.gvt.ShapeNode)
             node).
          getShape(
            );
        if (pathLengthShape !=
              s) {
            pathLength =
              new org.apache.batik.ext.awt.geom.PathLength(
                s);
            pathLengthShape =
              s;
        }
        return pathLength;
    }
    public float getTotalLength() { org.apache.batik.ext.awt.geom.PathLength pl =
                                      getPathLengthObj(
                                        );
                                    return pl.
                                      lengthOfPath(
                                        );
    }
    public java.awt.geom.Point2D getPointAtLength(float distance) {
        org.apache.batik.ext.awt.geom.PathLength pl =
          getPathLengthObj(
            );
        return pl.
          pointAtLength(
            distance);
    }
    public int getPathSegAtLength(float distance) {
        org.apache.batik.ext.awt.geom.PathLength pl =
          getPathLengthObj(
            );
        return pl.
          segmentAtLength(
            distance);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "A6xibV4+MT5eR6f7R8Y3tS++NmR/+I3G");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("5/cPwDRX2e0KLg/Q0P37t2gna/EX7sjtmNfl/ovfeuRXrrz3eN/wyF7gU3c+" +
       "I9tzt39tRXlhUr6P2v3DJ//+9/2t136vvFP/P88eXvT7LQAA");
}
