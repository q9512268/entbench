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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4siF7Tv8FZt3/w3rv4IVxx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7DZ7fWVQaEvTYZpJK5HSOj3ZOymWLOVc9G1CVgtmqGuCK3SYaEys2k4mSOiE" +
       "k5OJiDprynO1SPX2dqZr5n6QLaR6Y0mxg2472cez0MwUzHeRjOEX9jad6WNu" +
       "v4lTtB3tmjLiSI18xGIMN7TyfneKtfJgIe5xMRw0HSgNtSbcn3uwTobwKrZd" +
       "UrEG9GojW23ZS+aFaytLR9KnmwhycWeTIR2T5xG4t13uYqk74a0sHw8kDdJ6" +
       "aQuG9FYW+DjOGsTKXziRAG/21Gy3J1e5ZzZbDu1mUrEfdLEwHWgWPCWaBA07" +
       "dp4OjRFELSW7s0L2Xg/iUQPSTHbbHulOMBdmbs/c49legAZLGBZjotDGi3lA" +
       "b0y3BynsIrVMpzPqwJt2pzka9HUES33OAKmIDuFyp6lCVLLbQaLLFITlhOqw" +
       "017M7J3oRlpdJ2xMBlEpOAsVy+D2cpiQKz/njYAA8wwTt02DUNNgF+2wbSyo" +
       "2pCkpdkGbRhjtJkyq/Zk4pI7JZgGXaig26Okh9EFKmmxtZ7toE6BY+5yyMNy" +
       "0bXm/UDY7USpaQdhgtmBzBLtSZ/e8P35AML2G6LTghYdq62AtXSiNxs4qnAp" +
       "vkdsYzhY0X48Ui2kHaFzuqGRgtqTbaXfSKbpzpwoCpcVclthcR1KJ8250xjz" +
       "rGhHFi+gigpth03bELb0xmh0dtuWx6rrAUtObEDv+2YxRdqpSyYMNUTba81D" +
       "paCVW0sIXkwVONYKqbvMku6MGydkez1fe7mK6SM8QFspgwTLFW7RLVkxV8iY" +
       "QfbKqAPW7W4+a+5ydzV0nW7qwrt2K408mht65B4SCySWmv0w0plsNfKYjZk3" +
       "lxSkuu01NzKVpkEDlYcmTMDr/k52mHVBG0l/mqLugjQxM2REf9vZaI7KjmSI" +
       "6M6Gqd7Mw33Lb3Uw0w4UM0LNGLEMHZpGs+ZgNJfqA7jV9nFLxdddNZIHGxZa" +
       "zrpYsm+nSJSxckvt4xQW4KQ06ZsGPpDFtorj0HiCR7RrZlvYVDeTZhfKoDna" +
       "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" +
       "JioAAA==");
}
