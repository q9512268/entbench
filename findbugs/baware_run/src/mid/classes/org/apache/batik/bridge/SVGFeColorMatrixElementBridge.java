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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV6C8zsxnXe3ivpSrp63Cs5tmXFkizpKom98c/d5b4YJbG5" +
       "y33wudwll8tl68hcPpbvN3e5dFU7BhobDeA4iew4SKyggJ02gWynRYOkbdyq" +
       "LRoncBpAbtAkBWq5TY0mdYzaBewWddt0yP3f997fEJS0P8BZ/jNnzpwz58w3" +
       "hzPnpa9X7oqjSjXwnd3a8ZMDLUsOLKd1kOwCLT4gqBYrR7Gm9h05jnlQ95zy" +
       "1K9d+/Z3Pmpcv1y5IlXeIHuen8iJ6XvxTIt9Z6OpVOXaSe3A0dw4qVynLHkj" +
       "Q2liOhBlxsmzVOW+U12Tyg3qSAQIiAABEaBSBAg9oQKdHtC81O0XPWQvicPK" +
       "36xcoipXAqUQL6k8eZZJIEeye8iGLTUAHO4p/heAUmXnLKq87Vj3vc43Kfyx" +
       "KvTCz/3Y9X9wR+WaVLlmelwhjgKESMAgUuV+V3NXWhSjqqqpUuUhT9NUTotM" +
       "2THzUm6p8nBsrj05SSPteJKKyjTQonLMk5m7Xyl0i1Il8aNj9XRTc9Sj/+7S" +
       "HXkNdH3Tia57DYdFPVDwqgkEi3RZ0Y663GmbnppUnjjf41jHGyQgAF3vdrXE" +
       "8I+HutOTQUXl4b3tHNlbQ1wSmd4akN7lp2CUpPLobZkWcx3Iii2vteeSyiPn" +
       "6dh9E6C6t5yIoktSeeN5spITsNKj56x0yj5fZ374I+/zxt7lUmZVU5xC/ntA" +
       "p8fPdZppuhZpnqLtO97/Durj8ps+/+HLlQogfuM54j3Nb/yNb777Bx9/+Xf2" +
       "NN97C5rJytKU5DnlU6sHX3lr/+3IHYUY9wR+bBbGP6N56f7sYcuzWQBW3puO" +
       "ORaNB0eNL89+e/mBX9W+drlyFa9cUXwndYEfPaT4bmA6WjTSPC2SE03FK/dq" +
       "ntov2/HK3eCdMj1tXzvR9VhL8MqdTll1xS//B1OkAxbFFN0N3k1P94/eAzkx" +
       "yvcsqFQqd4Oncj94vr+y/yt/k8oGMnxXg2RF9kzPh9jIL/QvDOqpMpRoMXhX" +
       "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" +
       "fOFFdfLp+uXDE20xqdyb+ME7HW2jOadYXQGc3nH7kzG6vCE+OWn9wgf/y6P8" +
       "jxrvfQ33R0+ck/M8y1+hX/rd0fcpP3O5csfxuetNd9dnOz179rT1aqQlaeTx" +
       "Z85cHzue2YeLGXscPI3DmW3c+g7nll5wqfSCve0vuDCIL2hLi8JLKvevtYTy" +
       "FdlhDkUfn7iL/90O404zLSvsm/UbH+o3/svR7+6S4O6jg+Jnbnenub+8PEyQ" +
       "OKJ+Q0G9hZUD1XcPDm85i6YPHhE8eRO79SY5GEVyYJhKzPiqdkRZu4mycFN5" +
       "mxyYrgzGjzRP1aLiAulgaDqJFh11fEt50FwQrjUgxUxTgPesHa2BnTlwPev0" +
       "M3lbrqTnlH80/corn8w/99L+PHUlx1pSqd4ub+Xm1JniavOZC65nTzIavjX6" +
       "oZf/7E+E9xyt1fuOTftEYcmnwMMcmpY5b9ojXR84uRWi5bLtp0pe77/AMX+m" +
       "KHLgmEqkyYm2n7yi7idOHPN9r8MxS+mb4PnpQ+l/+jU45mUAWEHkJ8Bomlqi" +
       "8C2d9PKeuHStovhASfXJC7T+paL4uaTyRsX3Nlq0vwaKeX9/IR9faLTyfnFv" +
       "tBd/+enff/+LT/+H8oruHjMWQAQcrW+RunKqzzdeevVrX3rgsc+W19ilR5V4" +
       "dT7n5+aUnjOZOqUW9x/PcpGzUb5Eh7Mc3dJH/s5xh0crh7Y5l+mh/aXmWwAm" +
       "LlRmOqDgrdwkjhI7/t8MtFebO7UZL4q7MceXk2O/uHSYSHF83fHL2aVKOWuf" +
       "uY1XHgcFx/HAFUfz1olxq9HuMPeg9+kgO++wxzh5chnWd3xPK2DsqG2fB2L6" +
       "B8f5ZaAxu6Xw9l74crBT0cV327Y+f0HbPyuKfwymTCnk2qtxAfm/yCpBEFRO" +
       "kOMTrwM5vreoLLbp3zp00d96LchRvP7Ca4WML16g278uit9OKm8+BxlckeQH" +
       "kLNo/pUTzb/wejWHwfPKoeav/JVr/ocXaP7HRfGlpPLIOc3HqTYrQr/zqv+b" +
       "16H6W4rKG+D56qHqX/0rV/1PLlD9q0Xx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("5aRy36HqR+Hl3z/R9tXXom2WVB67MP2ryGV55Kbs1H1GpfLZF6/d8+YX53+4" +
       "3zqOsh7vpSr36KnjnE49OPV+JYg03Sy1uXefiBCUP38OXPk20RzAs/1LKf/X" +
       "9vT/NalcP08PgKH8PU3335LK1RM6wGr/cprkWwAVAUnx+u3gCOjedbvQEl3F" +
       "SSQrSTFvZXRyfC1+ZuayS2c/jo4N9PB3M9Cp76mnz2z7ZTLx0RdLyh6GhJ97" +
       "kWDe9832p/f5XIoj53nB5R6wQ+9Ty46/ep68LbcjXlfGb//Og7927zNHUd+D" +
       "e4FPfPyUbE/cOnlq4AZJme6U/+ab/+EP/90Xv1xmUPxfcid8UeUtAAA=");
}
