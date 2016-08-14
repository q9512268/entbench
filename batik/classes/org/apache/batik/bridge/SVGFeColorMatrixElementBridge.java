package org.apache.batik.bridge;
public class SVGFeColorMatrixElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeColorMatrixElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_COLOR_MATRIX_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
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
        int type =
          convertType(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable colorMatrix;
        switch (type) {
            case org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                   TYPE_HUE_ROTATE:
                float a =
                  convertValuesToHueRotate(
                    filterElement,
                    ctx);
                colorMatrix =
                  org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit.
                    buildHueRotate(
                      a);
                break;
            case org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                   TYPE_LUMINANCE_TO_ALPHA:
                colorMatrix =
                  org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit.
                    buildLuminanceToAlpha(
                      );
                break;
            case org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                   TYPE_MATRIX:
                float[][] matrix =
                  convertValuesToMatrix(
                    filterElement,
                    ctx);
                colorMatrix =
                  org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit.
                    buildMatrix(
                      matrix);
                break;
            case org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                   TYPE_SATURATE:
                float s =
                  convertValuesToSaturate(
                    filterElement,
                    ctx);
                colorMatrix =
                  org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit.
                    buildSaturate(
                      s);
                break;
            default:
                throw new java.lang.Error(
                  "invalid convertType:" +
                  type);
        }
        colorMatrix.
          setSource(
            in);
        handleColorInterpolationFilters(
          colorMatrix,
          filterElement);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          colorMatrix,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static float[][] convertValuesToMatrix(org.w3c.dom.Element filterElement,
                                                     org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_VALUES_ATTRIBUTE);
        float[][] matrix =
          new float[4][5];
        if (s.
              length(
                ) ==
              0) {
            matrix[0][0] =
              1;
            matrix[1][1] =
              1;
            matrix[2][2] =
              1;
            matrix[3][3] =
              1;
            return matrix;
        }
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        int n =
          0;
        try {
            while (n <
                     20 &&
                     tokens.
                     hasMoreTokens(
                       )) {
                matrix[n /
                         5][n %
                              5] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
                n++;
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
              s,
              nfEx });
        }
        if (n !=
              20 ||
              tokens.
              hasMoreTokens(
                )) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
              s });
        }
        for (int i =
               0;
             i <
               4;
             ++i) {
            matrix[i][4] *=
              255;
        }
        return matrix;
    }
    protected static float convertValuesToSaturate(org.w3c.dom.Element filterElement,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_VALUES_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0)
            return 1;
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
              new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
              s });
        }
    }
    protected static float convertValuesToHueRotate(org.w3c.dom.Element filterElement,
                                                    org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_VALUES_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0)
            return 0;
        try {
            return (float)
                     java.lang.Math.
                     toRadians(
                       org.apache.batik.bridge.SVGUtilities.
                         convertSVGNumber(
                           s));
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_VALUES_ATTRIBUTE,
              s });
        }
    }
    protected static int convertType(org.w3c.dom.Element filterElement,
                                     org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_TYPE_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_MATRIX;
        }
        if (SVG_HUE_ROTATE_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_HUE_ROTATE;
        }
        if (SVG_LUMINANCE_TO_ALPHA_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_LUMINANCE_TO_ALPHA;
        }
        if (SVG_MATRIX_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_MATRIX;
        }
        if (SVG_SATURATE_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.renderable.ColorMatrixRable.
                     TYPE_SATURATE;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_TYPE_ATTRIBUTE,
          s });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "X/5dvng/d/YA//RUFypOmx671RVqedL0yQ++8KI2/lT14Og0fBFD98Z+8IOO" +
       "vtWdM6wuA07vvPWp2qi8QT49pf38B//ro9MfXb33Ndw9PXFBzossf3X00u/T" +
       "36v+zAF0x8mZ7Q132+c7PXv+pPZKqMdJ6E3Pndc+djKzDxcz9jh4akczW7v5" +
       "/c9NveBS6QV729/msiG6TVtSFF4M3W/qMeOrssMeid47dRf/Ox3knWVaVtg3" +
       "6tc70q/3/0a/u0uCu48PmZ+51X3o/uLzKIHimPoNBXVaVw813z08uiEtmj54" +
       "TPDkDezMbXxIh3KwstSI9TX9mLJyA2XhpnIaH1quDMYPdU/Tw+Ly6ZCynFgP" +
       "jzu+tTykLghNHUjB6yrwHtPRa8S5w9rzTs/LabmSnlP/0eTLr3wi/+xL+7NY" +
       "RY70GIJvlddyY2pNcS36zG2udk8zHr5J/9DLf/6n4nuO1+p9J6Z9orDkU+Bh" +
       "j0zLXjTtsa4PnN4ojeSy7adKXu+/jWP+TFHkwDHVUJdjfT95Rd1PnDrm+16H" +
       "Y5bSN8Dz00fS//RrcMwDAFhB6MfAaLpWovBNnfRgT1y6VlF8oKT6xG20/qWi" +
       "+LkYepPqe1s93F8hRVN/f5kf3dZo5d3k3mgv/srTf/j+F5/+j+X13j1WJMoh" +
       "Fpo3SW050+frL7361S8+8Nhnyivw0qNKvLqYE3Rjys+5TJ5Si/tPZrnI6Shf" +
       "wqNZDm/qI7980uFR6Mg2FzJB5q8zOwN0c5EyLwIDb+W2cJz48d1ivVdNOLPh" +
       "zou7M8eX4xPbXzpKtDi5DvmV7BJUzsynb+F5Jxv/yZ5/2dE9M17dbLQ7rD2w" +
       "fSrILjrlCRaeXpbhju/pBVQdt+3zRCz/8CTHDDRmNxXe3gtfDnYmgvhOW9Pn" +
       "btP2z4riH4MpUwu59mrchvxfZFAQBNApOnz8daDD9xSVxVb8O0du+DuvBR2K" +
       "1194rbDwhdvo9q+L4ndj6C0XYEEoEv0AOhbNv3qq+edfr+Z18LxypPkr33XN" +
       "//g2mv9JUXwxhh65oHkv0fkivLuo+r95");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Haq/tai8Dp6vHKn+le+66n96G9W/UhRfiqH7jlQ/DiF/41TbV1+LtlkMPXbb" +
       "9LAi1+WRGzJU91mV6mdevHrPW16c/fF+ezjOfLyXge4xEsc5m5pw5v1yEOqG" +
       "VWpz7z5RISh//gK48i0iNoBn+5dS/q/u6f9bDF27SA+Aofw9S/ffY+jKKR1g" +
       "tX85S/JNgIqApHj9VnAMdO+6VfiIKVEcympczFsZgZxcm5+buezS+Q+gEwM9" +
       "/J0MdOab6elzW3uZUHz8VZJwR2HfZ18csO/7RutT+3wv1ZHzvOByD9iF96ln" +
       "J182T96S2zGvy713fPvBX7/3mePI7sG9wKc+fka2J26eXEW6QVymQ+W//ZZ/" +
       "+MN/78UvlRkW/xcQX6Uo6S0AAA==");
}
