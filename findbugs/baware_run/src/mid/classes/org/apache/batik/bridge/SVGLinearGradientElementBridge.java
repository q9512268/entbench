package org.apache.batik.bridge;
public class SVGLinearGradientElementBridge extends org.apache.batik.bridge.AbstractSVGGradientElementBridge {
    public SVGLinearGradientElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_LINEAR_GRADIENT_TAG;
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
        java.lang.String x1Str =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_X1_ATTRIBUTE,
            ctx);
        if (x1Str.
              length(
                ) ==
              0) {
            x1Str =
              SVG_LINEAR_GRADIENT_X1_DEFAULT_VALUE;
        }
        java.lang.String y1Str =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_Y1_ATTRIBUTE,
            ctx);
        if (y1Str.
              length(
                ) ==
              0) {
            y1Str =
              SVG_LINEAR_GRADIENT_Y1_DEFAULT_VALUE;
        }
        java.lang.String x2Str =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_X2_ATTRIBUTE,
            ctx);
        if (x2Str.
              length(
                ) ==
              0) {
            x2Str =
              SVG_LINEAR_GRADIENT_X2_DEFAULT_VALUE;
        }
        java.lang.String y2Str =
          org.apache.batik.bridge.SVGUtilities.
          getChainableAttributeNS(
            paintElement,
            null,
            SVG_Y2_ATTRIBUTE,
            ctx);
        if (y2Str.
              length(
                ) ==
              0) {
            y2Str =
              SVG_LINEAR_GRADIENT_Y2_DEFAULT_VALUE;
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
        java.awt.geom.Point2D p1 =
          org.apache.batik.bridge.SVGUtilities.
          convertPoint(
            x1Str,
            SVG_X1_ATTRIBUTE,
            y1Str,
            SVG_Y1_ATTRIBUTE,
            coordSystemType,
            uctx);
        java.awt.geom.Point2D p2 =
          org.apache.batik.bridge.SVGUtilities.
          convertPoint(
            x2Str,
            SVG_X2_ATTRIBUTE,
            y2Str,
            SVG_Y2_ATTRIBUTE,
            coordSystemType,
            uctx);
        if (p1.
              getX(
                ) ==
              p2.
              getX(
                ) &&
              p1.
              getY(
                ) ==
              p2.
              getY(
                )) {
            return colors[colors.
                            length -
                            1];
        }
        else {
            return new org.apache.batik.ext.awt.LinearGradientPaint(
              p1,
              p2,
              offsets,
              colors,
              spreadMethod,
              colorSpace,
              transform);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Z5pOjRV6X2jeNEXknhTA828up7WzPh4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Nr7jhxygN85yebzcWS16LQ2gGWqatmfwoeJFxcEX8JJn7uwl5dHJfkvzpZ99" +
       "+ss/9NLT/608fbjfjkQlRMPlbQ7mz/T55stf+/ofPvj458oTuntVJdrD+OKN" +
       "hlsvLJy7h1Aa74HzqHgUPNUjVFT3u+X+P+jZcHF9BMwZdNuZPj6O/sceMj+2" +
       "6UMnNi1tfgLpS0dnwCc7tR/NL1VKX3nx9l5ycLIWnCwDVxzDW8ZWScmdifjz" +
       "uHKPvXeJHwnykyEPjqLtsRed7uPjju8ZxRHecdv+CNv2D09ux4DG/LbCr/fC" +
       "l4OdWVS+U7T6zF3afrYofiquXNYKufZq3IX8F47i00dOgPdY0fYkeN5yBLy3" +
       "7IFn/IOiADBxodKqKHgr16BjuP3jDJTfzvKXTcdX4jvj7BePcfYr/584K4pP" +
       "FsWniuKztwKq+PnponjpLgj5xZLZZ4vip+9iy9+8S9tvFcWvF8XP7SW5C+0X" +
       "jjABsPzMnW5z7G9tHF0OK3u9/y4cf7sodnHlQTWxHf3Y42918zIGnK6q73s1" +
       "q2oeV564+x2T4sD8Dbfcgtvf3NI+99L1+1//kvCf90H8+HbVVbJyv5k4ztnz" +
       "zTPvV4LQMO1Sxav7086g/Pp3ceX1d5g5EHn2L6UCX9zT//u4cuMiPUBj+X2W" +
       "7j/ElWundIDV/uUsyX8E8QuQFK9fDY5nGLmTGVE1ikNFi8HE3XbK8kvn09YT" +
       "0zzynUxzJtN9+tzKW95WPM4lk/19xee1z780pt73rfbP7G+LaI6y2xVc7geL" +
       "5P7iykk++tQduR3zukI8++2HfvnqM8e580N7gU+zqDOyPXn7qxl9N4jLyxS7" +
       "33j9r37/z730J+X57N8BLFlqs0YqAAA=");
}
