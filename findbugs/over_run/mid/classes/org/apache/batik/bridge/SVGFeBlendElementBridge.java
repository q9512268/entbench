package org.apache.batik.bridge;
public class SVGFeBlendElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeBlendElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_BLEND_TAG; }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        org.apache.batik.ext.awt.image.CompositeRule rule =
          convertMode(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        org.apache.batik.ext.awt.image.renderable.Filter in2 =
          getIn2(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in2 ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion;
        defaultRegion =
          (java.awt.geom.Rectangle2D)
            in.
            getBounds2D(
              ).
            clone(
              );
        defaultRegion.
          add(
            in2.
              getBounds2D(
                ));
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        java.util.List srcs =
          new java.util.ArrayList(
          2);
        srcs.
          add(
            in2);
        srcs.
          add(
            in);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.CompositeRable8Bit(
          srcs,
          rule,
          true);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            filter,
            primitiveRegion,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static org.apache.batik.ext.awt.image.CompositeRule convertMode(org.w3c.dom.Element filterElement,
                                                                              org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String rule =
          filterElement.
          getAttributeNS(
            null,
            SVG_MODE_ATTRIBUTE);
        if (rule.
              length(
                ) ==
              0) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     OVER;
        }
        if (SVG_NORMAL_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     OVER;
        }
        if (SVG_MULTIPLY_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     MULTIPLY;
        }
        if (SVG_SCREEN_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     SCREEN;
        }
        if (SVG_DARKEN_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     DARKEN;
        }
        if (SVG_LIGHTEN_VALUE.
              equals(
                rule)) {
            return org.apache.batik.ext.awt.image.CompositeRule.
                     LIGHTEN;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_MODE_ATTRIBUTE,
          rule });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVYfWwUxxWfO+NPjL8AQyAYMIaWj9yFQkCNaQk4GEzO5moT" +
       "1Jokx9zu3N3C3u6yO2cfJpQQKQFFFUKBpKQqVKKkH4iGqCr9iBTkqlKTiKYU" +
       "GrX5aFPa/NGmKVL4o6EV/Xpvdvd2b+/OFLVqLe3ceubNm3nv/eY37+3Za6Ta" +
       "MkmnQTWZRvgeg1mROL7HqWkxuUellrUVehPSU789uv/Gz+sPhEnNMGnKUKtf" +
       "ohbrVZgqW8NkjqJZnGoSswYYk3FG3GQWM0coV3RtmExXrL6soSqSwvt1maHA" +
       "NmrGSCvl3FSSOc76HAWczI2J3UTFbqLrggLdMdIo6cYeb8Ksogk9vjGUzXrr" +
       "WZy0xHbSERrNcUWNxhSLd+dNstTQ1T1pVecRlueRneo9jiM2x+4pcUPni80f" +
       "3TySaRFumEo1TefCRGuQWbo6wuQYafZ6N6gsa+0mnydVMTLZJ8xJV8xdNAqL" +
       "RmFR115PCnY/hWm5bI8uzOGuphpDwg1xMr9YiUFNmnXUxMWeQUMdd2wXk8Ha" +
       "eQVr3XAHTHxmafTYFx9p+XYVaR4mzYo2hNuRYBMcFhkGh7JskpnWOllm8jBp" +
       "1SDgQ8xUqKqMOdFus5S0RnkOIOC6BTtzBjPFmp6vIJJgm5mTuG4WzEsJUDn/" +
       "VadUmgZb2z1bbQt7sR8MbFBgY2aKAvacKZN2KZoscFQ8o2Bj1wMgAFNrs4xn" +
       "9MJSkzQKHaTNhohKtXR0CMCnpUG0WgcImgJrFZSirw0q7aJpluBkZlAubg+B" +
       "VL1wBE7hZHpQTGiCKM0KRMkXn2sDaw7v1TZpYRKCPctMUnH/k2FSR2DSIEsx" +
       "k8E5sCc2Lok9S9tfPhQmBISnB4Rtme89ev2+ZR3jr9oys8vIbEnuZBJPSKeT" +
       "TZfv7Fn8ySrcRp2hWwoGv8hyccrizkh33gCmaS9oxMGIOzg++OPPPXaGfRAm" +
       "DX2kRtLVXBZw1CrpWUNRmbmRacyknMl9pJ5pco8Y7yO18B5TNGb3bkmlLMb7" +
       "yCRVdNXo4n9wUQpUoIsa4F3RUrr7blCeEe95gxBSCw9phOfjxP4Tv5wY0Yye" +
       "ZVEqUU3R9Gjc1NF+DKjgHGbBuwyjhh5NAv533bU8sjpq6TkTABnVzXSUAioy" +
       "zB6MJk1FTrPo0LaNvWy9CrtGimAaXy/6I4g84/+wZh79MHU0FIIQ3RkkCBXO" +
       "1iZdlZmZkI7l1m+4/kLiog0+PDCOBznBhSP2whGxcMReOFJhYRIKifWm4QZs" +
       "OEAwdwEtAC83Lh56ePOOQ51VgENjdBJEAkUXldxTPR5/uKSfkM5eHrxx6fWG" +
       "M2ESBopJwj3lXRZdRZeFfdeZusRkYKtK14ZLndHKF0XZfZDx46MHtu2/W+zD" +
       "z/+osBqoC6fHkbULS3QFz305vc0H//DRuWf36R4DFF0o7j1YMhOJpTMY3aDx" +
       "CWnJPHo+8fK+rjCZBGwFDM0pnCggv47gGkUE0+2SNdpSBwandDNLVRxyGbaB" +
       "Z0x91OsRsGsV79MgxJPxxHXCE3WOoPjF0XYD2xk2TBEzASvEZfCpIePEmz99" +
       "f4Vwt3tvNPsu/CHGu31chcraBCu1ehDcajIGcr8+Hj/6zLWD2wX+QGJBuQW7" +
       "sO0BjoIQgpufeHX3W7959/QbYQ+zHC7rXBLynnzBSOwnDRMYiTj39gNcp8LZ" +
       "R9R0PagBKpWUQpMqw0Pyt+aFy8//6XCLjQMVelwYLbu1Aq//jvXksYuP3OgQ" +
       "akIS3rWezzwxm8CneprXmSbdg/vIH7gy57lX6Am4CoB+LWWMCUYlwgdEBG2l" +
       "sD8q2hWBsVXYdFl+8BefL19OlJCOvPHhlG0fXrgudlucVPlj3U+Nbhte2CzM" +
       "g/oZQaLZRK0MyK0cH3ioRR2/CRqHQaMEJGptMYHu8kXIcKSra9/+4Y/ad1yu" +
       "IuFe0qDqVO6l4pCRekA3szLAlHlj7X12cEfroGkRppIS49Gfc8tHakPW4MK3" +
       "Y9+f8Z01Xz/5rgCVjaLZznTxzyJslhTQJf5qgreYH11FGkwyp1KiIZKk048f" +
       "OylveX65nQ60FV/eGyA3/dYv/v6TyPGrr5W5D+q5btylshGm+tasgiXnl7B4" +
       "v8jDPAZafeVG1TtPz2wsJXDU1FGBnpdUpufgAq88/sdZWz+d2XEbzDw34Kig" +
       "ym/2n31t4yLp6bBIJW1SLklBiyd1+10Gi5oMcmYNzcKeKQK+nYXQtmHIOuBZ" +
       "6YR2ZXl2LIOKAudUmjrB6RycYGwrNv2cNKYh0dIlqg6ANUJyJpRaAtmYRkfs" +
       "NFoMrMZmwMbuvf/eKcGOtaK7r9QZmx2LNt++MypNDRhcK/ZR65q1sFKaY2c1" +
       "Tp3kSk9F6dEVUkTWsxEn/cEhyRWYX6IuPcIjG01qZBTJGgCYu5J3l0gizOko" +
       "jyhZqCwicBEDZyG1R3oVFaoVd+IdIhAomGawi0HgGAiKyj5xP/KP/zBibT6U" +
       "S1p8kI4KIkhIX+h84sDHaq+vshlgXllpX3Gy4saq5nlnvqHZ4l3llReXJb/b" +
       "e/GU/qsPwm7JUW6KLfmA1X/ppU2/T4hTW4e0UDgrPkpYZ6Z92UVLIe5NGOZW" +
       "eK46cRe/nOz8rybboARqcCULeI9uVbLMzXnd1P5/uBrS++wSrvVCe/6lr60+" +
       "tOyzp2zHz6/Anp78Dz5z9fKJsXNnba5H93OytNJ3jNKPJ5h9Lpwgg/ZA9OeN" +
       "946//962h8MOzTRh41x+gOcp3pUJ9zF25guHNVSoFdqDQLJ11yw/8df9T765" +
       "BZLbPlKX05TdOdYnFxNxrZVL+pDlFeweLTuw+if8heD5Bz4IJ+ywYdXW4xSv" +
       "8wrVq2HkcZyT0BJ4FXp2TMCuB7DZDuwqmQym24ca+3xM+tB/zKQLcCgCzxHn" +
       "WByZgElFuxibZUJnGK55w9Q5QJjJkOxa4ltRINmdNoHygPlhW6tgSGzswvTw" +
       "BE46gs2TnEyGOmUEipR+H2MuuwVjYoSwFmCDOZV5Pj14+z7NczKjQpmLSd7M" +
       "km9u9nci6YWTzXUzTj74S1FqFb7lNAK7pXKq6oOkH541hslSirC+0U5xDfHz" +
       "HGyiwuUEobFfxP6P2/Jfhjs6KM9Jtfj1y32FkwZPDlTZL36RU5xUgQi+ftVw" +
       "3b+20k25DhjdhKQZPSZAHTeBwrgywoo8lw+VprsiQNNvFSBffrugiHHEJ1KX" +
       "E3Jxh9jOndw8sPf6quftwlFS6dgYapkMTGDXsIUkcH5Fba6umk2Lbza9WL/Q" +
       "5a5We8PeGZrtA+9aoCoDATIrUFVZXYXi6q3Tay68fqjmCrDudhKikFJs932g" +
       "tL/GQWmWg6t8e6wc50GKLAq+7ob3dlz6y9uhNlFKOCzZMdGMhHT0wjvxlGF8" +
       "KUzq+0g1FAQsP0waFOv+PRqkESNmEYXWJPWcVvia2oRoppj3Cc84Dp1S6MUP" +
       "D5x0lnwnLfMxBqqsUWauR+0OJRelzTnD8I8Kz+7FZl/epuKqRKzfMBxqDv1M" +
       "eN4wxMn9LjaP/gsC0XinBxkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
