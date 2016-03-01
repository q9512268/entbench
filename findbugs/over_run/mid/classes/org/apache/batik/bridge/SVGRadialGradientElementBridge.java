package org.apache.batik.bridge;
public class SVGRadialGradientElementBridge extends org.apache.batik.bridge.AbstractSVGGradientElementBridge {
    public SVGRadialGradientElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_RADIAL_GRADIENT_TAG;
    }
    protected java.awt.Paint buildGradient(org.w3c.dom.Element paintElement,
                                           org.w3c.dom.Element paintedElement,
                                           org.apache.batik.gvt.GraphicsNode paintedNode,
                                           org.apache.batik.ext.awt.MultipleGradientPaint.CycleMethodEnum spreadMethod,
                                           org.apache.batik.ext.awt.MultipleGradientPaint.ColorSpaceEnum colorSpace,
                                           java.awt.geom.AffineTransform transform,
                                           java.awt.Color[] colors,
                                           float[] offsets,
                                           org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String cxStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_CX_ATTRIBUTE,
            ctx);
        if (cxStr.
              length(
                ) ==
              0) {
            cxStr =
              SVG_RADIAL_GRADIENT_CX_DEFAULT_VALUE;
        }
        java.lang.String cyStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_CY_ATTRIBUTE,
            ctx);
        if (cyStr.
              length(
                ) ==
              0) {
            cyStr =
              SVG_RADIAL_GRADIENT_CY_DEFAULT_VALUE;
        }
        java.lang.String rStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_R_ATTRIBUTE,
            ctx);
        if (rStr.
              length(
                ) ==
              0) {
            rStr =
              SVG_RADIAL_GRADIENT_R_DEFAULT_VALUE;
        }
        java.lang.String fxStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_FX_ATTRIBUTE,
            ctx);
        if (fxStr.
              length(
                ) ==
              0) {
            fxStr =
              cxStr;
        }
        java.lang.String fyStr =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_FY_ATTRIBUTE,
            ctx);
        if (fyStr.
              length(
                ) ==
              0) {
            fyStr =
              cyStr;
        }
        short coordSystemType;
        java.lang.String s =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_GRADIENT_UNITS_ATTRIBUTE,
            ctx);
        if (s.
              length(
                ) ==
              0) {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX;
        }
        else {
            coordSystemType =
              org.apache.batik.bridge.SVGUtilities.
                parseCoordinateSystem(
                  paintElement,
                  SVG_GRADIENT_UNITS_ATTRIBUTE,
                  s,
                  ctx);
        }
        org.apache.batik.dom.svg.SVGContext bridge =
          org.apache.batik.bridge.BridgeContext.
          getSVGContext(
            paintedElement);
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX &&
              bridge instanceof org.apache.batik.bridge.AbstractGraphicsNodeBridge) {
            java.awt.geom.Rectangle2D bbox =
              ((org.apache.batik.bridge.AbstractGraphicsNodeBridge)
                 bridge).
              getBBox(
                );
            if (bbox !=
                  null &&
                  bbox.
                  getWidth(
                    ) ==
                  0 ||
                  bbox.
                  getHeight(
                    ) ==
                  0) {
                return null;
            }
        }
        if (coordSystemType ==
              org.apache.batik.bridge.SVGUtilities.
                OBJECT_BOUNDING_BOX) {
            transform =
              org.apache.batik.bridge.SVGUtilities.
                toObjectBBox(
                  transform,
                  paintedNode);
        }
        org.apache.batik.parser.UnitProcessor.Context uctx =
          org.apache.batik.bridge.UnitProcessor.
          createContext(
            ctx,
            paintElement);
        float r =
          org.apache.batik.bridge.SVGUtilities.
          convertLength(
            rStr,
            SVG_R_ATTRIBUTE,
            coordSystemType,
            uctx);
        if (r ==
              0) {
            return colors[colors.
                            length -
                            1];
        }
        else {
            java.awt.geom.Point2D c =
              org.apache.batik.bridge.SVGUtilities.
              convertPoint(
                cxStr,
                SVG_CX_ATTRIBUTE,
                cyStr,
                SVG_CY_ATTRIBUTE,
                coordSystemType,
                uctx);
            java.awt.geom.Point2D f =
              org.apache.batik.bridge.SVGUtilities.
              convertPoint(
                fxStr,
                SVG_FX_ATTRIBUTE,
                fyStr,
                SVG_FY_ATTRIBUTE,
                coordSystemType,
                uctx);
            return new org.apache.batik.ext.awt.RadialGradientPaint(
              c,
              r,
              f,
              offsets,
              colors,
              spreadMethod,
              org.apache.batik.ext.awt.RadialGradientPaint.
                SRGB,
              transform);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6TEMu8YKfMQ1bxg8cs9w4Pk3VRNZuD4eAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5fns3wHBKNf0RioAAA==");
}
