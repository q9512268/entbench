package org.apache.batik.dom.svg;
public class SVGOMFEConvolveMatrixElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFEConvolveMatrixElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_IN_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_ORDER_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_OPTIONAL_NUMBER));
             t.put(null, SVG_KERNEL_UNIT_LENGTH_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_OPTIONAL_NUMBER));
             t.put(null, SVG_KERNEL_MATRIX_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             t.put(null, SVG_DIVISOR_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_BIAS_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_TARGET_X_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_INTEGER));
             t.put(null, SVG_TARGET_Y_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_INTEGER));
             t.put(null, SVG_EDGE_MODE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_PRESERVE_ALPHA_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      EDGE_MODE_VALUES =
      { "",
    SVG_DUPLICATE_VALUE,
    SVG_WRAP_VALUE,
    SVG_NONE_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      edgeMode;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      bias;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      preserveAlpha;
    protected SVGOMFEConvolveMatrixElement() {
        super(
          );
    }
    public SVGOMFEConvolveMatrixElement(java.lang.String prefix,
                                        org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        in =
          createLiveAnimatedString(
            null,
            SVG_IN_ATTRIBUTE);
        edgeMode =
          createLiveAnimatedEnumeration(
            null,
            SVG_EDGE_MODE_ATTRIBUTE,
            EDGE_MODE_VALUES,
            (short)
              1);
        bias =
          createLiveAnimatedNumber(
            null,
            SVG_BIAS_ATTRIBUTE,
            0.0F);
        preserveAlpha =
          createLiveAnimatedBoolean(
            null,
            SVG_PRESERVE_ALPHA_ATTRIBUTE,
            false);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_CONVOLVE_MATRIX_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getEdgeMode() {
        return edgeMode;
    }
    public org.w3c.dom.svg.SVGAnimatedNumberList getKernelMatrix() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGFEConvolveMatrixElement.getKernelMatrix is not implemente" +
           "d"));
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getOrderX() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getOrderX is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getOrderY() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getOrderY is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getTargetX() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getTargetX is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getTargetY() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getTargetY is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getDivisor() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFEConvolveMatrixElement.getDivisor is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getBias() {
        return bias;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getKernelUnitLengthX() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGFEConvolveMatrixElement.getKernelUnitLengthX is not imple" +
           "mented"));
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getKernelUnitLengthY() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGFEConvolveMatrixElement.getKernelUnitLengthY is not imple" +
           "mented"));
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getPreserveAlpha() {
        return preserveAlpha;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEConvolveMatrixElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
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
       "4aFmebYTO5kySxZmfU4LUm1mIgNXxsb1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
