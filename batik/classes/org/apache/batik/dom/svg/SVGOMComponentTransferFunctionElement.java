package org.apache.batik.dom.svg;
public abstract class SVGOMComponentTransferFunctionElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGComponentTransferFunctionElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_TYPE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_TABLE_VALUES_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             t.put(null, SVG_SLOPE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_INTERCEPT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_AMPLITUDE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_EXPONENT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_OFFSET_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      TYPE_VALUES =
      { "",
    SVG_IDENTITY_VALUE,
    SVG_TABLE_VALUE,
    SVG_DISCRETE_VALUE,
    SVG_LINEAR_VALUE,
    SVG_GAMMA_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      type;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumberList
      tableValues;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      slope;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      intercept;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      amplitude;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      exponent;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      offset;
    protected SVGOMComponentTransferFunctionElement() {
        super(
          );
    }
    protected SVGOMComponentTransferFunctionElement(java.lang.String prefix,
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
        type =
          createLiveAnimatedEnumeration(
            null,
            SVG_TYPE_ATTRIBUTE,
            TYPE_VALUES,
            (short)
              1);
        tableValues =
          createLiveAnimatedNumberList(
            null,
            SVG_TABLE_VALUES_ATTRIBUTE,
            SVG_COMPONENT_TRANSFER_FUNCTION_TABLE_VALUES_DEFAULT_VALUE,
            false);
        slope =
          createLiveAnimatedNumber(
            null,
            SVG_SLOPE_ATTRIBUTE,
            1.0F);
        intercept =
          createLiveAnimatedNumber(
            null,
            SVG_INTERCEPT_ATTRIBUTE,
            0.0F);
        amplitude =
          createLiveAnimatedNumber(
            null,
            SVG_AMPLITUDE_ATTRIBUTE,
            1.0F);
        exponent =
          createLiveAnimatedNumber(
            null,
            SVG_EXPONENT_ATTRIBUTE,
            1.0F);
        offset =
          createLiveAnimatedNumber(
            null,
            SVG_EXPONENT_ATTRIBUTE,
            0.0F);
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getType() {
        return type;
    }
    public org.w3c.dom.svg.SVGAnimatedNumberList getTableValues() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGComponentTransferFunctionElement.getTableValues is not im" +
           "plemented"));
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSlope() {
        return slope;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getIntercept() {
        return intercept;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getAmplitude() {
        return amplitude;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getExponent() {
        return exponent;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getOffset() {
        return offset;
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "DaimDsh2J4mDihVtOLm9JHxaHW7EQQnV");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("HQmrpUwPWi7nPs1B5lgvC0UoCJojbt4mKY53Bl0GFv06YxRDV0LdSsunGIEK" +
       "uva4aE3aS2cZ9fhNJYSasQ/hpZQWGgECLdvNqhfjft0w56W03Zz2OB7MB8Xx" +
       "ujsyoZKsW9OB2UkmvaZeHhGjVSBxxEh1+jExDIuKTgphtR2MKF2l7NZUnM4T" +
       "EMD2ahVSwSMVRHi073UG/MzbrMxlGE6SDoix4YGX2EPYHhCldpVIhdqKS9Jw" +
       "3evUloOgRWjwILQsCRI2puhWenGc0uN2hxr25pxaodqVBh81IsiEyL7TQuSq" +
       "j6LoB7KlqDfubInskXzl7/Bg5vex5pecsQFuhIWL0u5cxNFhn/zvUmF3wu/g" +
       "/7G102NnG/YO1uYr2dr8uqIcX5K/1YG2bL/wqdMOcuZ7hV/8xCuvqsOfK5/b" +
       "bRe5YeHe0HH/kqnFmnlMjPvy+831y78lcP3oDsKPnlz+PdLgmWu/Z2xd/ckZ" +
       "ed/Kkj8KC+80bCPMdxo11DQpI9bQMPQNMH3ebc6cXOKMHUM9sut/vJMjJydU" +
       "8MDBuvyndyr49J2oICzc4/pGLIXaLfXwv87I+16W/New8MSRHq5XQpb/7SPA" +
       "/+1NAH7mYMn/CzvAX7hTm99y53Pv/Bl592RJAShuoYXjY1uJ771Jz7jJ/uGh" +
       "Evb23oQSns4eQuD60k4JX3rrlfDYGXmPZ8lDYeGhTAk3bkQ+d4YujnYfj1Rx" +
       "6U2o4qns4XPg+tpOFV9761Xx9Bl5z2bJuwDDAlVwx7cxn76lEo4U8NSbVUDW" +
       "IX5lp4BfeesVcMYRyb3siOTei2HhAaAA4tgm6N5zR/iKbwW+X9vh+7W3Ht/V" +
       "M/Ky8XyvtsWHHttNPY6v/mbxZVvpv73D99tvPb7eGXnZ1tleKyzcD/B1jrZl" +
       "j8PD3iy87GOCN3bw3njr4Z2VN8mSAQgoALzhwf7ucXC3PId3Kx5uguvrO3Bf" +
       "v1NwtwxA9q6dkSdliQgG3oyHT5xPPDxzyB9hveWpm+sOtwIiv60vFrKz10/c" +
       "8D3V9hsg5SuvXrr4jlcn/3p77u/gO517qcLFeWSaxw+BHru/4PrafGv3e7dH" +
       "QvMDd3s6gHra6ZCwcBdIMxR7i23pVVh4281Kg5IgPV7SDgsPnywZFs7n/4+X" +
       "88LCfUflwsKF7c3xIiFoHRTJbiP3ugHx9CMtB4Hy3rFYd+drebz06K3Mdljl" +
       "+AcB2Zm2/GO4g/Nn0fZzuGvKV18lBx/7bu3nth8kKKaUplkrF6nCPdtvI/JG" +
       "szNsT5/a2kFbF/AXvvfQL9z73EHs/tBW4CO/Pybbe25+9L9juWF+WD/95Xf8" +
       "w/d/6dU/zE8c/H/U4XW7pTgAAA==");
}
