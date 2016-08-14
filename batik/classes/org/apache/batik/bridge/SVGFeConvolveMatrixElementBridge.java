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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C+zr5nWf7rV9/fa1nSZx3PhtJ7GV/UmKkijVXROKelKk" +
       "RFF8SVvq8C2KT/EhUsy8pEHbZCuQBp3TZljjYai7bp2bZMWydSsyuBvWukkR" +
       "IEGxrhvapN2wpcsyxMPadc3W7iP1f93/vffvGbeuAH6i+J3v8Jzz/c75zvfQ" +
       "y9+u3BKFlWrgOzvT8eMDPYsP1k7jIN4FenRAUg1GDiNdIxw5ijjw7Dn18c9f" +
       "/qPvfnJ178XKpWXlLbLn+bEcW74XsXrkO1tdoyqXT572HN2N4sq91FreylAS" +
       "Ww5EWVH8LFW581TTuPIkdSQCBESAgAhQKQKEn1CBRnfrXuISRQvZi6NN5a9X" +
       "LlCVS4FaiBdXHruSSSCHsnvIhik1ABxuK34LQKmycRZWHj3Wfa/zVQp/qgq9" +
       "8FM/eO8v3lS5vKxctrx5IY4KhIjBS5aVu1zdVfQwwjVN15aV+zxd1+Z6aMmO" +
       "lZdyLyv3R5bpyXES6sdGKh4mgR6W7zyx3F1qoVuYqLEfHqtnWLqjHf26xXBk" +
       "E+j6thNd9xr2i+dAwTssIFhoyKp+1ORm2/K0uPLI2RbHOj45BgSg6a2uHq/8" +
       "41fd7MngQeX+fd85smdC8zi0PBOQ3uIn4C1x5cHrMi1sHciqLZv6c3HlgbN0" +
       "zL4KUN1eGqJoElfeepas5AR66cEzvXSqf749+f5PfMgbehdLmTVddQr5bwON" +
       "Hj7TiNUNPdQ9Vd83vOsZ6iflt33x4xcrFUD81jPEe5p/9tdee/97H37l1T3N" +
       "916DZqqsdTV+Tn1Jueer7ySebt9UiHFb4EdW0flXaF7CnzmseTYLgOe97Zhj" +
       "UXlwVPkK+6uLj/y8/q2LlTtGlUuq7yQuwNF9qu8GlqOHA93TQznWtVHldt3T" +
       "iLJ+VLkV3FOWp++fTg0j0uNR5WanfHTJL38DExmARWGiW8G95Rn+0X0gx6vy" +
       "Pgsqlcqt4KrcBa5nKvtP+R1XbGjluzokq7JneT7EhH6hfwTpXqwA264gBaDe" +
       "hiI/CQEEIT80IRngYKUfViihpZk6NBcGfR040bZAPi0DXGVFrABcOiXBQQG6" +
       "4C/2dVmh/b3phQugY955Niw4wKOGvqPp4XPqC0mn99pnn/vyxWM3ObRbXGkB" +
       "CQ72EhyUEhzsJTh4PQkqFy6UL/6eQpI9GkBf2iAqgHh519PzD5Af/PjjNwEY" +
       "BunNoCMKUuj6YZs4iSOjMlqqAMyVVz6d/pDwYfhi5eKV8beQHjy6o2jOFFHz" +
       "ODo+edbvrsX38se++Uef+8nn/RMPvCKgHwaGq1sWjv34WTuHvqprIFSesH/m" +
       "UfkLz33x+ScvVm4G0QJEyFgGiAbB5+Gz77jCwZ89CpaFLrcAhQ0/dGWnqDqK" +
       "cHfEq9BPT56UALinvL8P2PjOAvFVcCGHLlB+F7VvCYrye/aAKTrtjBZlMP7L" +
       "8+Az/+4rf4CW5j6K25dPjYRzPX72VKwomF0uo8J9JxjgQl0HdL/zaeZvferb" +
       "H/srJQAAxRPXeuGTRUmAGAG6EJj5R17d/PbXf/el37x4ApoYDJaJ4lhqdqxk" +
       "8bxyxzlKgre960QeEGsc4IAFap7kPdfXLMOSFUcvUPp/Lj+FfOG/feLePQ4c" +
       "8OQIRu99fQYnz9/RqXzkyz/4vx4u2VxQi7HuxGYnZPsA+pYTzngYyrtCjuyH" +
       "vvbQ3/41+TMgFIPwF1m5Xka0SmmDStlpUKn/M2V5cKYOKYpHotPgv9K/TuUk" +
       "z6mf/M3v3C1851++Vkp7ZVJzuq9pOXh2D6+ieDQD7N9+1tOHcrQCdPVXJn/1" +
       "XueV7wKOS8BRBXEtmoYg8GRXIOOQ+pZb//2v/Ou3ffCrN1Uu9it3OL6s9eXS" +
       "ySq3A3Tr0QrErCx43/v3nZveBop7S1UrVym/B8UD5a+bgIBPXz++9Iuc5MRF" +
       "H/iTqaN89Pf/+CojlJHlGkPxmfZL6OWffpD4gW+V7U9cvGj9cHZ1MAb520nb" +
       "2s+7f3jx8Uv/5mLl1mXlXvUwORRkJykcZwkSougoYwQJ5BX1VyY3+5H82eMQ" +
       "9s6z4eXUa88Gl5NBANwX1MX9HafjyZ+BzwVw/WlxFeYuHuyH1PuJw3H90eOB" +
       "PQiyC8Bbb6kdYAdw0f59JZfHyvLJonj3vpuK2/cAt47KrBS0MCxPdsoXvz8G" +
       "EHPUJ4+4CyBLBX3y5NrBSjZvBXl5CadC+4N9arcPaEVZK1nsIdG4Lny+b09V" +
       "jlz3nDCjfJAl/th/+uRv/PgTXwd9SlZu2Rb2Bl156o2TpEicf/TlTz105wvf" +
       "+LEySoEQJfyNf4z+ccGVOk/jougVRf9I1QcLVedlGkDJUUyXgUXXSm3PhTIT" +
       "Wi6Iv9vDrBB6/v6v2z/9zV/YZ3xncXuGWP/4C3/zzw4+8cLFU3n2E1eluqfb" +
       "7HPtUui7Dy0cVh477y1li/5/+dzzv/wPnv/YXqr7r8wae2BS9Av/9v/+xsGn" +
       "v/Hr10hJbnb8G+jY+P7PD+vRCD/6UIjcXeJ8xkoJuphidWy9NraW4FWZrcl0" +
       "19TGMhvbFFuHUJdRVqk+ttVdt4fVMBVFpzlNTyZYXMNHMunOXdxfdUY9Ww34" +
       "DYcMuovAWbA+Ml7YfDZwaJ9gA2oy6ffWyqAXrVmR63JbTYWinMaqQ8KSwmWo" +
       "13RMUqBN20jaWNiGorphkDwd2bHArkeK0vf7S3+jLmVyMrUifilEmx0CT9QV" +
       "tqvOmThP801Imc153Vvkvr3JXFGhfNoXN7ScaFx/BFuwK3NjRHDoZcr6MUmJ" +
       "YW3ey9lYWuzEcCD3fHmzw4MQcWme0HybhscbUl3S5DKwY9pxU9qyiXFq5311" +
       "rmxxBoG1USKniojkO5XFdmzUGvGWoi4BA6HH1+YcMp/SNj9hM5bqywYdOeoM" +
       "0dGsL2or0RqvODkgarAQjtIo71OdGFc3DNSANUQVhFZ/NNcmcBaJOeJ0KAGN" +
       "fao32qBa0xnbyMJtuei8P+h1GXVGIyNJZevyytcHdXkwjYm6EFJNQo6cnt/C" +
       "+otZ01vYzKDD9XaT5ZQcLZ156ipcGqv0sLdZUlxidCfkdM5HYUCn85YiN+oK" +
       "ik2QWVvszTY12HX8ULJUl110RtNhPJoQ8pwcc2DU6m+mmeaM41SUUd6ZssJA" +
       "DLcajTgrSiJJuYdJBm8GCGk2wpYrN5NFp92ZrOmAbiO01TbIrhpWJwrLOfrI" +
       "bGYrSbCGKzpJh7ga8SK5Xo4XQ60mTAcaEctrckhCKycY6EnSmY0XYjA2w17M" +
       "MLXNiLR7ww3bc307kJlJOg42Rt+U5n7XXPr0elSlEIaP50MSFcaqtun0q8lK" +
       "zjqdWVefjlPCpdeMzKl8M51XJ+2kyi09SJMkZRh23Fq/b8064nBK76xNYuQr" +
       "erMVJqJNYxve63RbXK+1dllDGy8yVB0Qs6EFcw1rZjDppNVW6SZUa3b7HXrX" +
       "G+Z66JPWJu+GNjRNqHpGK0snM1a07U9QgUxbOW03EExc+BAfpBnudvvBem0u" +
       "VFNmQs9rDvItmF63+nPB5sbLJTJZ2vi0uRHbi/lqM2FVbi1s5n4+cCMz3US8" +
       "XJVMDtgPs8YkCytJM2pPrXBk07zkSJHagMy63zRn4maD50lfRjitWp9YkpRV" +
       "G2yHINyO1eC6k4U+6kJtN+hu1WCu+SI5cjhtCKujJPChTBx0cI8Iw5iwjU4z" +
       "3HadoA6nM66brGxmXsOHkjbTLTIYUz2sG4oo5SD91F81YWiwIDFi02/iHbXv" +
       "TYleZ6O1jHZbwjfOsG0rBN0dcAzXNU1fj3lSWrS5yGZUt78DRkWhodqibLiH" +
       "RFuuvxvIqUkClNetaGSxYq/j+B1ixtVN2FjN/RmS9hs1fOfjFGkwSohUG6qs" +
       "wfUQ745QfaTg7Lzrx6M8RZK4u6oPa0NjPHcXyZbn00QngtGqJ4zWu3kabNhV" +
       "PIjSep1cq4oSN3V2RjhZBAXe2uqkiyrf0ILuFA+lbJclS27DaFzPsJcDnTPr" +
       "8AxtT8kUihNWZXKn6TPGIE7Q3NzNFwOOSm2e7mBSp0mkZHsQd0OoT7BWDXIo" +
       "vd0yBpwxieH+epEuGiNuGpK2n+ZzSDbWArwbMu581EaYYT1eb5K228ObdkqQ" +
       "wI1DhodG6ZRrrpAWizjjmd6Zonw2Gpv1xtRqrCVZ0ZvQMnWbqNtuMjg1ktd2" +
       "q9mX68M4NlKFbamL2qguTPxGrRFMiazeCsV6rUthUIpFgoryTX9jcCAm1nhE" +
       "2prdpSeoBBFqEVILeTuAKaTmT8VhjCHQLg+SCMYzRlO7TawTd/pWl5rNEAPa" +
       "LhpgJs60BWiUrOXpgql7fka4ATsm6l47GO9wmyFgV28AqDSEFN/BbhiGE6rD" +
       "BMKU9a2gn0EB01ik/S6E5EJDTPFMaA67U3mS490YqhKZyA3VbFsV1O2yM5jR" +
       "eRObSt1xpzqfaLlZc8ci2tFkNjGGw/m60WS7NgXj9LzmAL3MvLuaWp0WnC13" +
       "Vd3I2yvKqI2lRU4RrSyAAqlRhzc2AyarJMxq24BsYSkiKu5Ca7aVQKZ1t6/X" +
       "6IzGjSQzvI48EhxtNjRIWJDCTXu+9lJqqCW4j2essoFRfOfMB0ttzc/gbRUE" +
       "CS9z05Zkz4kdbC03dpItWRIF8YwOyViWZkQ+1pmN3OLcdrAk+JbQJwWPWKKi" +
       "aVqGh4Ybh1hMsqUItRvaypCGAx/L5ihtM6k77ThTPFES0cHqjbZl7NZwzYkG" +
       "ncaELpbvWr1dCDXltqEMBW1Xn015YbI05bTfodQqhMFoVet22o36xNbqA3UJ" +
       "1+Gx0Ha6QquVraq0RYuTLt3LbWmN1JVINyZsNbSsVsvpDjoGNuvga6zlmVkn" +
       "b0XTprHzGJSZMy0x2TbjoN71zWpN1qZMK8ZcswUl6M7dEsYoQhadhuMtlUS2" +
       "9U3bqss9d2Ww6iwfZEF9rEDGHMY1zsxihYhVs2b2xAbPiUNMnmfjGOJxp9mO" +
       "o85ikMvhYO4yM7jp7RrjJrHhVs6UMQVa1fAuU7Pp9aKqdpwaNRsRTQgy42Z/" +
       "OIMHGNaqiTnMii0FjPuRhyJzg7DD+sz21Zlo2Dts2eNc3oBX+cbm15qO9VQr" +
       "cUmbRFp1gfBmOY5YSK21qoui26DYQF2L43WnvkLJat/i5W3MUYAXsV7zK2Lq" +
       "4sbKtGdRxPcXjXEezajqZGEuljkxjhf4lO7VNsbcIpfOdD3Blq6fycoI5XfV" +
       "wXqG1KFNLaBRnTe41bTOL5Mu4tGb2lZa+FU0jpqBPQOjf7/K0HC7q63g0BGy" +
       "CbPd8a5EdtbmBlcMyajrNdib5CgDKSqPgwxrwjZTfNDNGoQmNA1YN7VY6Wqq" +
       "0vawXIEV0WjZ8LCpdHihTZrj2hDZ+eQgnKJI7gy6RAANV3bemhhaTLaRTQoD" +
       "PCqSw49jHmLMoLeFdhNDnw4babMx7OLbmN0ucjoXVHUnY6PFsN70YWKKseGI" +
       "bSWQvuU0MFIn3fYGp82RMq5KC3nBK7Nd3wKdN5HnKh30WqafUxN22NFbATqW" +
       "qrVkLPiDVJZJ4BjIUprOJxG/A9r25vairSWMiPfzerxAXRUye3XGp6l8JmKd" +
       "zoBvT3yvrnsBDvV6dCPzyCE+pNaOMZ0R46GfT1YRzooil3rcahNb6I6X6LXd" +
       "x3Pcrk/MJDHiaFI1I5N0IW8xpFfLbNOb0HiqzUD4H0xnQydpjaYCtYZVYTFt" +
       "cPN+J23w1ohbpJDRa3ViHe03HGWwQ8QZwRF603Eb9ML1EnqUImYbqtpeuA5b" +
       "UJO0VHsGU7GP9Sc7JtxuOMUPIxzxF6zcouNekhCLmqtqnOvT5DrqsbOxPiaH" +
       "lISgnNRe6W0I3kJdOxHm2WjSI6p0xrYZip5KaL1taHpIrmAGhvxpL194Abuk" +
       "1DTpuApfZcxEGJD5aCA569UoJn1c59EgQrGmv5SnraiJOZSoUpPaNMd3BkM5" +
       "OJInMxZ1lFzfGjHWzrwMG0QwOhvQWq3RbivMDNvWiHXKO2oeiKrQw7KMzdnZ" +
       "zHYwDemRTJ2bilsJsWu1Capg274tpo0RLI4lkauZHayKktgYX/AcnY5wI/XM" +
       "5WaNbj0uGKZQe9GvbnuUi2+8PM+2CBazm3ZTrhpLEuV1aqzO0KRa1dFViumM" +
       "guUbhsOMkGdMjAp4LehRFF3V9PagDcBGwPUAGuxmDiaz49jfJspyLGeTSXva" +
       "tsSGwFmj5sxa5LtcJtJNwEgBMtxZBhS11pAgzag0W6RrysIhIXXr3dWIkW0u" +
       "W4BpxKpjpwInUI1tB8bdeYjyUIZ08sVwvZwZXY1u+I14PGlumux64KitZW/D" +
       "Y+ys6jSZNHNrqTw0wv4CWneYYZRLfNrxh7tW2rZmtXWd9OlNg7L6AxzqGo1Z" +
       "QHuWKynTURVHs1qP6JpkVi1cOxtAA8brmcNMW6k1tNVi21syaxOuZ1E0yDUB" +
       "WkQsqsJ0h2GxYcOx0253W5P4eLKWN5ZPRx7WS7ZyN5u6bjbUwSx+hnBYdeuM" +
       "QCqFCJyq1Ef1rrli2I6fIL0p7NXIdNZG4VqcUBKXoyikr6KN1dQoibIwNOpJ" +
       "7UTgMmG3FFO9P2zSuQpxjJfuanUja8DMgunn+Jhvp0tLz3Q5x+NtNU4na6VG" +
       "7chcGGS2OYYxtJFNoFxbEKIVVXvNRWPruwbjrrZ2vZsQAwpzkuqw12GkJpGL" +
       "zoCNV0nS4wJ+vtNYTJakpagN5jvBmEm1AA7T/gTyZjWhMV3WEdUUB42+tvQ7" +
       "JsbU6JawYcaIHbgeMyJ2w4a0aLQYM5LTSW8mmk5GKYwrel190tAnYCzV1VkP" +
       "7iwXKBEEYDrJ2qnRqLk0OVxXm4Q+aAl80lcWQlSFBqKNeTudzlyWt9maPdxx" +
       "UyrGh5lZH7VpPmN0z54hHr4E4JiRuLjpWFE+GOlMb5cpPN1Q2rK4rk6AJlsV" +
       "j5c1EGjywdiFQxEJqF5TYXRp4IJRf4Aktkhu1DEKchrCqeGLFRQ1awO3VVUW" +
       "20nGENs+stJmGEjRqRHLo4IcQawa1Ta4LGkk3nDgOSKJwjwOcCHMfYMwsUy1" +
       "eNOor02iimau1JZgr5XBcnXbrO60QW5oc60/V7uNIZw1ViRbIx1J0OvYDu2o" +
       "CpkgfJWWBQuZCqkh1noBvuVqsIb2MdUn5h3SHhp5zxK8rD6fGVgciPEqoHcg" +
       "2ihWZm/nhKltR/RQiRfKGu8b3hiaoSyBuPM12UWM4UYyAhvMtBoOva7TMbZr" +
       "SSaqb4h2C8vBmN3IlESDKJQZk6otJmgDCwaQs1ltpxQVcNveQBJELxSS2Y7p" +
       "keOMjlt5OPM3mRI1dCUdO/Ws2qbZbrpT6suZvYlEQppXlXrPHQ0iPO1y81lL" +
       "waQdstSqFpqPIURimCHmqfy2YzvmcOaM1NFq6aDIlMsc0oYzud+yE0wdNTwF" +
       "QsMAatd3iAQCaqvel6p4INgIB7XaHXRn8Yy0xVhPGrZjG8+2YBooUPyS246I" +
       "dDlKaqvIby/XScCPd85YMC11NFhrPUXTcTDL9+fbSFnpIBUUg+E2gzKd5ugo" +
       "IVwJkpsCjUhJkAgrRl73bT7rrdI2rEfctNqvT8CMpzNRh9soVLmamI4a7ATf" +
       "Nn0THtSXXJA1m7UqnmzXMLoeE1oG2THqSe1uW+nVrHZzbOJ4sXT1gTe2enhf" +
       "uVB6vCG+drCiYvgGVs32VY8VxVPHmyvl59LZTdTTmysnK+6VYiXwoevtc5er" +
       "gC999IUXtenPIhcPdyqkuHJ77Ad/ydG3unOK1e2A0zPXX/Gky23+kxX0X/vo" +
       "f32Q+4HVB9/AvuAjZ+Q8y/If0i//+uBd6k9crNx0vJ5+1QGEKxs9e+Uq+h2h" +
       "Hiehx12xlv7QsWXvLyz2MLiah5ZtXntv7poouFCiYN/352wERefUJUXhxZW7" +
       "TD2mfFV2JoeiD0/g4r/eIutppuUD+2r9qEP9qD8f/W4tCW492gB46nrb1ftN" +
       "6cNTLkfUbymoU1Q90Hz34HD3uqj66BHBY1exM7fxwSCUg5WlRhNf048o4aso" +
       "C5jKaXxguTJ4f6h7IHEsNgYP+pYT6+FRw3eUGwgFoakDKVhdBegxHb3WvWIh" +
       "/UrQs3JaetJz6j+ffeOrn8k/9/J+nVyRIz2uVK93+Ojq80/FlvVT52y7nxxL" +
       "+cPB973yB/9R+MCRr9553LWPFD35OLjYw65lz3btka53n+z20XJZ9+Mlrw+f" +
       "A8yfKIocAFMNdTnW98Yrnv3oCTA/dAPA/N7i4bvB9dKh9C+9AWBeBAErCP0Y" +
       "dJqulVH4miC9uCcuoVUUHympPnOO1n+3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("KH4qLg9QbfUwLvdLo3P7qtwu3vfVi3//ia98+MUnfq/ccb3NigQ5xEPzGseO" +
       "TrX5zstf/9bX7n7os+WphBJIZZg6e17r6uNYV5yyKoW/69i4xXmbyuVK5ebJ" +
       "3rb777ii3uApGDkIIijamkrop5EeQoUnMmDSp4eM7OnO0WGbv4jX7PE0PzWc" +
       "inHlJuvwOF/RrxcOD7gcb0O9lF2olNj6R9dB1fGgfjyeX3J0z9wfZ/q5oviZ" +
       "IDuLruOgdrIjSTi+pxcx56hufxjH8g+OT/SByuyaktp7ScuXnUoFXm+M+aVz" +
       "6v5FUXwhrtyiFnLt1TiH/IuHzlu6+KdvwMUfKh7C4Hr10MVffSMuXtz+nev7" +
       "9k0neVjp2z9z4uC/eo5yrxbFr4DeOnTwsR4CRO3PUZUN/t6x+A9WDoPsuw/F" +
       "f/feicQbRTeY8BbnT/wQB3dlhnTkOG8W62s6yy2G48vnuMuXj9zla/+f7lIU" +
       "nz12lS9d7SrFz88XxS+eg/0vl8y+VBT/9JyO/O1z6v5DUfxWUfzyXpJzaH/n" +
       "NNr/1Y0OaE+D67VDuLz2JqL9Sydo/8/nKPfNovi9uHLPIdq71taK/HIY/8qJ" +
       "1r9/o1q/B3Tgvfu2++8338f/xzla/8+i+HZcHtIptObkEGTXJYMTpf/7DShd" +
       "5NOVBlC2e6h0989R6WsnLX96fX0vlG/+33Hl7VfENN6zYqocvc7EtULRyj3g" +
       "Mg+Bap6V/lrR4pLmJ2DQCoLglL/8yY2ODu8FxrMOjWi92Ua8cPkcI95XFHfE" +
       "lcuHRuyBaQt9aqLxrteZaDCydkxe2ObCnTdqGwTY5IcPbfPDb7ptHjrHNo8U" +
       "xQMgjTm0DRPqIC3b6rgTrORrgeVWxfcdXfZOrPGON2KNLK48+nrnnItDmw9c" +
       "9Z+L/f8E1M++ePm2t7/I/9Y+qT46y387VbnNSBzn9Bm7U/eXglA3rNJkt+9P" +
       "3AWl9k8Dz7rO9Ba4xf6mUOHCe/b0740r956lB6Nt+X2aDoord5zQAVb7m9Mk" +
       "NZDSApLiFg2OkPi+6821cSWKQ1mNC9OV07Xj819XWC7bD7YPnIZe6c33v14f" +
       "nVpgeuKKCVH5F5mjJZyEOZwjf+5FcvKh15o/uz+4rDpynhdcbgNzl/0Z6sO5" +
       "y9n59mluR7wuDZ/+7j2fv/2po2nwPXuBT9zglGyPXPuUcM8N4vJcb/5Lb/8n" +
       "3/9zL/5ueVTw/wEaRfd6uzQAAA==");
}
