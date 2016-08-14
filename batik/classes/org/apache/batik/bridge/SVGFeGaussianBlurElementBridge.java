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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "u/8FfQplamYfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
