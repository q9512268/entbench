package org.apache.batik.svggen;
public class SVGConvolveOp extends org.apache.batik.svggen.AbstractSVGFilterConverter {
    public SVGConvolveOp(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.BufferedImageOp filter,
                                                             java.awt.Rectangle filterRect) {
        if (filter instanceof java.awt.image.ConvolveOp)
            return toSVG(
                     (java.awt.image.ConvolveOp)
                       filter);
        else
            return null;
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.ConvolveOp convolveOp) {
        org.apache.batik.svggen.SVGFilterDescriptor filterDesc =
          (org.apache.batik.svggen.SVGFilterDescriptor)
            descMap.
            get(
              convolveOp);
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        if (filterDesc ==
              null) {
            java.awt.image.Kernel kernel =
              convolveOp.
              getKernel(
                );
            org.w3c.dom.Element filterDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FILTER_TAG);
            org.w3c.dom.Element feConvolveMatrixDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_FE_CONVOLVE_MATRIX_TAG);
            feConvolveMatrixDef.
              setAttributeNS(
                null,
                SVG_ORDER_ATTRIBUTE,
                kernel.
                  getWidth(
                    ) +
                SPACE +
                kernel.
                  getHeight(
                    ));
            float[] data =
              kernel.
              getKernelData(
                null);
            java.lang.StringBuffer kernelMatrixBuf =
              new java.lang.StringBuffer(
              data.
                length *
                8);
            for (int i =
                   0;
                 i <
                   data.
                     length;
                 i++) {
                kernelMatrixBuf.
                  append(
                    doubleString(
                      data[i]));
                kernelMatrixBuf.
                  append(
                    SPACE);
            }
            feConvolveMatrixDef.
              setAttributeNS(
                null,
                SVG_KERNEL_MATRIX_ATTRIBUTE,
                kernelMatrixBuf.
                  toString(
                    ).
                  trim(
                    ));
            filterDef.
              appendChild(
                feConvolveMatrixDef);
            filterDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_FE_CONVOLVE_MATRIX));
            if (convolveOp.
                  getEdgeCondition(
                    ) ==
                  java.awt.image.ConvolveOp.
                    EDGE_NO_OP)
                feConvolveMatrixDef.
                  setAttributeNS(
                    null,
                    SVG_EDGE_MODE_ATTRIBUTE,
                    SVG_DUPLICATE_VALUE);
            else
                feConvolveMatrixDef.
                  setAttributeNS(
                    null,
                    SVG_EDGE_MODE_ATTRIBUTE,
                    SVG_NONE_VALUE);
            java.lang.StringBuffer filterAttrBuf =
              new java.lang.StringBuffer(
              URL_PREFIX);
            filterAttrBuf.
              append(
                SIGN_POUND);
            filterAttrBuf.
              append(
                filterDef.
                  getAttributeNS(
                    null,
                    SVG_ID_ATTRIBUTE));
            filterAttrBuf.
              append(
                URL_SUFFIX);
            filterDesc =
              new org.apache.batik.svggen.SVGFilterDescriptor(
                filterAttrBuf.
                  toString(
                    ),
                filterDef);
            defSet.
              add(
                filterDef);
            descMap.
              put(
                convolveOp,
                filterDesc);
        }
        return filterDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2DCl/wOlHshlcBQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5Af16e/f/7tv+82XvpGf4/03YSkoPW8gAAA=");
}
