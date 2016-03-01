package org.apache.batik.bridge;
public class SVGFeConvolveMatrixElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeConvolveMatrixElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_CONVOLVE_MATRIX_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        int[] orderXY =
          convertOrder(
            filterElement,
            ctx);
        float[] kernelMatrix =
          convertKernelMatrix(
            filterElement,
            orderXY,
            ctx);
        float divisor =
          convertDivisor(
            filterElement,
            kernelMatrix,
            ctx);
        float bias =
          convertNumber(
            filterElement,
            SVG_BIAS_ATTRIBUTE,
            0,
            ctx);
        int[] targetXY =
          convertTarget(
            filterElement,
            orderXY,
            ctx);
        org.apache.batik.ext.awt.image.PadMode padMode =
          convertEdgeMode(
            filterElement,
            ctx);
        double[] kernelUnitLength =
          convertKernelUnitLength(
            filterElement,
            ctx);
        boolean preserveAlpha =
          convertPreserveAlpha(
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
        org.apache.batik.ext.awt.image.renderable.ConvolveMatrixRable convolve =
          new org.apache.batik.ext.awt.image.renderable.ConvolveMatrixRable8Bit(
          pad);
        for (int i =
               0;
             i <
               kernelMatrix.
                 length;
             i++) {
            kernelMatrix[i] /=
              divisor;
        }
        convolve.
          setKernel(
            new java.awt.image.Kernel(
              orderXY[0],
              orderXY[1],
              kernelMatrix));
        convolve.
          setTarget(
            new java.awt.Point(
              targetXY[0],
              targetXY[1]));
        convolve.
          setBias(
            bias);
        convolve.
          setEdgeMode(
            padMode);
        convolve.
          setKernelUnitLength(
            kernelUnitLength);
        convolve.
          setPreserveAlpha(
            preserveAlpha);
        handleColorInterpolationFilters(
          convolve,
          filterElement);
        org.apache.batik.ext.awt.image.renderable.PadRable filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          convolve,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static int[] convertOrder(org.w3c.dom.Element filterElement,
                                        org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_ORDER_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return new int[] { 3,
            3 };
        }
        int[] orderXY =
          new int[2];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        try {
            orderXY[0] =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGInteger(
                  tokens.
                    nextToken(
                      ));
            if (tokens.
                  hasMoreTokens(
                    )) {
                orderXY[1] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGInteger(
                      tokens.
                        nextToken(
                          ));
            }
            else {
                orderXY[1] =
                  orderXY[0];
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_ORDER_ATTRIBUTE,
              s,
              nfEx });
        }
        if (tokens.
              hasMoreTokens(
                ) ||
              orderXY[0] <=
              0 ||
              orderXY[1] <=
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_ORDER_ATTRIBUTE,
              s });
        }
        return orderXY;
    }
    protected static float[] convertKernelMatrix(org.w3c.dom.Element filterElement,
                                                 int[] orderXY,
                                                 org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_KERNEL_MATRIX_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { SVG_KERNEL_MATRIX_ATTRIBUTE });
        }
        int size =
          orderXY[0] *
          orderXY[1];
        float[] kernelMatrix =
          new float[size];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        int i =
          0;
        try {
            while (tokens.
                     hasMoreTokens(
                       ) &&
                     i <
                     size) {
                kernelMatrix[i++] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_KERNEL_MATRIX_ATTRIBUTE,
              s,
              nfEx });
        }
        if (i !=
              size) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_KERNEL_MATRIX_ATTRIBUTE,
              s });
        }
        return kernelMatrix;
    }
    protected static float convertDivisor(org.w3c.dom.Element filterElement,
                                          float[] kernelMatrix,
                                          org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_DIVISOR_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            float sum =
              0;
            for (int i =
                   0;
                 i <
                   kernelMatrix.
                     length;
                 ++i) {
                sum +=
                  kernelMatrix[i];
            }
            return sum ==
              0
              ? 1.0F
              : sum;
        }
        else {
            try {
                return org.apache.batik.bridge.SVGUtilities.
                  convertSVGNumber(
                    s);
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_DIVISOR_ATTRIBUTE,
                  s,
                  nfEx });
            }
        }
    }
    protected static int[] convertTarget(org.w3c.dom.Element filterElement,
                                         int[] orderXY,
                                         org.apache.batik.bridge.BridgeContext ctx) {
        int[] targetXY =
          new int[2];
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_TARGET_X_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            targetXY[0] =
              orderXY[0] /
                2;
        }
        else {
            try {
                int v =
                  org.apache.batik.bridge.SVGUtilities.
                  convertSVGInteger(
                    s);
                if (v <
                      0 ||
                      v >=
                      orderXY[0]) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      filterElement,
                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                      new java.lang.Object[] { SVG_TARGET_X_ATTRIBUTE,
                      s });
                }
                targetXY[0] =
                  v;
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_TARGET_X_ATTRIBUTE,
                  s,
                  nfEx });
            }
        }
        s =
          filterElement.
            getAttributeNS(
              null,
              SVG_TARGET_Y_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            targetXY[1] =
              orderXY[1] /
                2;
        }
        else {
            try {
                int v =
                  org.apache.batik.bridge.SVGUtilities.
                  convertSVGInteger(
                    s);
                if (v <
                      0 ||
                      v >=
                      orderXY[1]) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      filterElement,
                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                      new java.lang.Object[] { SVG_TARGET_Y_ATTRIBUTE,
                      s });
                }
                targetXY[1] =
                  v;
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_TARGET_Y_ATTRIBUTE,
                  s,
                  nfEx });
            }
        }
        return targetXY;
    }
    protected static double[] convertKernelUnitLength(org.w3c.dom.Element filterElement,
                                                      org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return null;
        }
        double[] units =
          new double[2];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        try {
            units[0] =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  tokens.
                    nextToken(
                      ));
            if (tokens.
                  hasMoreTokens(
                    )) {
                units[1] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
            }
            else {
                units[1] =
                  units[0];
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE,
              s });
        }
        if (tokens.
              hasMoreTokens(
                ) ||
              units[0] <=
              0 ||
              units[1] <=
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE,
              s });
        }
        return units;
    }
    protected static org.apache.batik.ext.awt.image.PadMode convertEdgeMode(org.w3c.dom.Element filterElement,
                                                                            org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_EDGE_MODE_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return org.apache.batik.ext.awt.image.PadMode.
                     REPLICATE;
        }
        if (SVG_DUPLICATE_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.PadMode.
                     REPLICATE;
        }
        if (SVG_WRAP_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.PadMode.
                     WRAP;
        }
        if (SVG_NONE_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.PadMode.
                     ZERO_PAD;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_EDGE_MODE_ATTRIBUTE,
          s });
    }
    protected static boolean convertPreserveAlpha(org.w3c.dom.Element filterElement,
                                                  org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_PRESERVE_ALPHA_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return false;
        }
        if (SVG_TRUE_VALUE.
              equals(
                s)) {
            return true;
        }
        if (SVG_FALSE_VALUE.
              equals(
                s)) {
            return false;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_PRESERVE_ALPHA_ATTRIBUTE,
          s });
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
       "X/7gC4//YXliersVCXLYDc3rXCk61efb");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("L33tm1+9+8HPlLcKSkMqw9TZu1jXXrW66gZVSfxdx8It7tJULlcqN9N72e6/" +
       "48rmu3qnRQ6CCIq2phL6aaSHUOGXjKXaegjw6c7RRZq//EH3tsafmmoXceUm" +
       "6/AaX6HzC4eXV46PmF7MLlRKu/uHN7C44wn/eK6/1dE9c3+N6ReL4ueD7Kzl" +
       "HQe8k9NGzPE9vYhHR237izaWf3B8kw80Ztel1N5TWg52Kk14rfnnV89p+2dF" +
       "8fm4cota0LVn4xzwLxw6dun+n3oD7v9gUVkDzyuH7v/K63H/4vVnb+z3N53k" +
       "aKXf//yJ8//GOcy9UhS/DrR16PwTPQQWtb8jVXb4u8fkP1A5DMDvPCT/nXsH" +
       "07+7tu5ZbnHTxA+74K3MpY6c6i9noOs60i2G48vnuNKXjlzpq/+PrlQUnzl2" +
       "oy9e60bFz88Vxa+c4xdfKpF9sSj+8TlK/r1z2v5dUfxuUfzanpJzYH//tCf8" +
       "izc6ET4FnlcPTenV76EnfPHEE/7jOcx9oyj+MK7cc+gJuLW1Ir+c/r98wvUf" +
       "vVGu3wUUeGXfd//9vff//3YO1/+9KL4Vl5dzCq5ncgiy8hLBCdP/9Q0wXeTh" +
       "FQQwix8yjX8Xmb5+svPnN+b3Qjny/4orb70q3s09KybLme1MzCsYrdwDHvPQ" +
       "UM2z1F8vWtyq+QmY0IIgOOUvf/ZGZ453A+FZh0K0vtdCvHD5HCHeWxSX4srl" +
       "QyH2wXKHOrVAecdrLFAYWTsGL2Rz4c43Kps6kMmPHcrmx77nsnnwHNk8XBT3" +
       "gxTnUDZMqIOUbat3nWAlX89YblN839Fl70Qab3s90sjiyiOvdb+5uKx5/zX/" +
       "w9j/d0D9zAuXb3/rC/Pf3SfjR/f77yArtxuJ45y+W3fq/dYg1A2rFNkd+5t2" +
       "Qcn9U8CzbrAsBm6xfylYuPCuPfy748qVs/Bgti2/T8NBceXSCRxAtX85DQKD" +
       "dBeAFK+N4MgS33OjNXpXieJQVuNCdOUy7/je11WSy/aT7f2nTa/05vteS0en" +
       "NqYev2ohVf5t5mjrJ2EO19affWFMf+DV1i/sLyyrjpznBZbbwZpnf3f6cM1z" +
       "dp1+GtsRrluHT33nns/d8eTR8vmePcEnbnCKtoevfzu47wZxeZ83/9W3/qMf" +
       "+sUX/qC8Ivh/ATY5CLjPNAAA");
}
