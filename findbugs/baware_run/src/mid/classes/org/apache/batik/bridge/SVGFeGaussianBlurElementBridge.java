package org.apache.batik.bridge;
public class SVGFeGaussianBlurElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeGaussianBlurElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_GAUSSIAN_BLUR_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        float[] stdDeviationXY =
          convertStdDeviation(
            filterElement,
            ctx);
        if (stdDeviationXY[0] <
              0 ||
              stdDeviationXY[1] <
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_STD_DEVIATION_ATTRIBUTE,
              java.lang.String.
                valueOf(
                  stdDeviationXY[0]) +
              stdDeviationXY[1] });
        }
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
        java.awt.geom.Rectangle2D defaultRegion =
          in.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        org.apache.batik.ext.awt.image.renderable.PadRable pad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          in,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        org.apache.batik.ext.awt.image.renderable.Filter blur =
          new org.apache.batik.ext.awt.image.renderable.GaussianBlurRable8Bit(
          pad,
          stdDeviationXY[0],
          stdDeviationXY[1]);
        handleColorInterpolationFilters(
          blur,
          filterElement);
        org.apache.batik.ext.awt.image.renderable.PadRable filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          blur,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static float[] convertStdDeviation(org.w3c.dom.Element filterElement,
                                                 org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_STD_DEVIATION_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return new float[] { 0,
            0 };
        }
        float[] stdDevs =
          new float[2];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        try {
            stdDevs[0] =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  tokens.
                    nextToken(
                      ));
            if (tokens.
                  hasMoreTokens(
                    )) {
                stdDevs[1] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
            }
            else {
                stdDevs[1] =
                  stdDevs[0];
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_STD_DEVIATION_ATTRIBUTE,
              s,
              nfEx });
        }
        if (tokens.
              hasMoreTokens(
                )) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_STD_DEVIATION_ATTRIBUTE,
              s });
        }
        return stdDevs;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "wH/lHPAfZhutTeUeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
