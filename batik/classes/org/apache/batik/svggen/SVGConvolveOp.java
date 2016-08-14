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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vyRueXPl3xVSsdAZFQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/n2/+7bfeOlrWQ3wvwHXGYXDjyAAAA==");
}
