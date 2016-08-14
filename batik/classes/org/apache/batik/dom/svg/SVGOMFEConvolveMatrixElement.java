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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/BXfTv4PXg9u1psxAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "POOZJ3escA/+74kpfOC//tVlBpQL8xUcmFPlOeSln38I+4Gv5+WPFTIr/Uhy" +
       "+UIGvd7jsuVftb5z7rHz/+Zc4VaucK+4d6lZ3gwz3eGgG+kf+tnQ7b4k/VKX" +
       "cOf/PHu0ArzptDqfaPa0Nh8voPA+y53d33FKjl+Xsfx2eCF720FOG+NBIb+Z" +
       "Xtkez2W3T0Gj9HPHfW+UfwP/DuD119mVVZhF7Dyc+7G9m3XhyM9y4fr+QGKZ" +
       "jMdrwdDOl5SjkYJ2+NRldphP1K4D50E6tCWQAInJtO543uSGNnslQxsd0fDG" +
       "LPY8vOZ7GsZXoeHdV6bhppyGLGACOAqazZs50Qs4vXrdfu+58aTbe45tk4se" +
       "Da34yatbca62O/f4xV9+/A9+9MXH/0suWLdpPhzrtqdcwV8/UeZbL3316394" +
       "18Ofydf1mwXe34366Y3O5fuYS7Yned/vPGLntRkZD2Xqs2fnYDeWz10+lt9/" +
       "YRPyvrYJ4YL41E6oLuxM40LOyoWdxLzrPRdyRqj2uEdfeMcFG8T7lPfxlvD8" +
       "uy5evPieZ5923bwj7SNVONhp4G7wsgAcjot6hnm+Iwveezge501gK4F6tpZM" +
       "Pc2C/kO038wgz9//VePn//zXdhuV08JxKjP48As/9TcXP/LCuRPbw8cv26Gd" +
       "LLPbIuYdvCvvZbaMPXpWK3kJ/L+//Pxv/crzH9r16v5LNzs9uJf/tT/6P79/" +
       "8RNf+90r+NM3QQPIfkhucrV14YHjdQEzHRtkM+wwbedQa87Fo804TEwuGyev" +
       "8MzVOR7nBncsmr/zgf/5EPMD6nuvwZN+8ymOTlf5j8cv/W7/LeLHzhVuOpLQ" +
       "y3bqlxZ69lLhvMMDQejZzCXy+fDO9HL+dnaXBW/Ph+6MhfD9Z6R9IAueh9oh" +
       "ZlTvRuaM7B9MCqfE7j2vXuxyF/xJeC3303l5FbH78FV8kFzsDufTOe1IqN96" +
       "9iatbWtWphG7iX6q/z95jf0vwevd+/6/+yr9/7uvpv+3AUkBY0c6sm301aHI" +
       "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" +
       "pDZWJo0JsZ65vLRqOlKjuuQZa0yrDXmM");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
