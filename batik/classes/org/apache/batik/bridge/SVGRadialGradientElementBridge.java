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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jlzYvs1fsXnnP50WWS3HHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KgAA");
}
