package org.apache.batik.dom.svg;
public class SVGOMFECompositeElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFECompositeElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_IN_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_IN2_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_OPERATOR_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_K1_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_K2_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_K3_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_K4_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      OPERATOR_VALUES =
      { "",
    SVG_OVER_VALUE,
    SVG_IN_VALUE,
    SVG_OUT_VALUE,
    SVG_ATOP_VALUE,
    SVG_XOR_VALUE,
    SVG_ARITHMETIC_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in2;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      operator;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      k1;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      k2;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      k3;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      k4;
    protected SVGOMFECompositeElement() {
        super(
          );
    }
    public SVGOMFECompositeElement(java.lang.String prefix,
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
        in2 =
          createLiveAnimatedString(
            null,
            SVG_IN2_ATTRIBUTE);
        operator =
          createLiveAnimatedEnumeration(
            null,
            SVG_OPERATOR_ATTRIBUTE,
            OPERATOR_VALUES,
            (short)
              1);
        k1 =
          createLiveAnimatedNumber(
            null,
            SVG_K1_ATTRIBUTE,
            0.0F);
        k2 =
          createLiveAnimatedNumber(
            null,
            SVG_K2_ATTRIBUTE,
            0.0F);
        k3 =
          createLiveAnimatedNumber(
            null,
            SVG_K3_ATTRIBUTE,
            0.0F);
        k4 =
          createLiveAnimatedNumber(
            null,
            SVG_K4_ATTRIBUTE,
            0.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_COMPOSITE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn2() {
        return in2;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getOperator() {
        return operator;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getK1() {
        return k1;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getK2() {
        return k2;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getK3() {
        return k3;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getK4() {
        return k4;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFECompositeElement(
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
       "JnW0Kq3RsGSYlZQ3MEE2FoSMy+k6GXo9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("tTQQBd8ex12DXLJ4DDRuFhNkPl1zMY9R/qijqQIhDhbWmpAH4kiXNuU6n9qL" +
       "RaVl+JAONiRoHy6amyqE93wNrSuUwiMLvDTk8CIkSai2GQ/YqIWwo4FBMbEv" +
       "IxAFO4Fa7uHJhGj0Nu1KjWwOxMlqth7RXC2Y0S3CXvmdztQ1EV2DxjTeWxbh" +
       "qtFIGYM2QWSz9EymHTLj4grpjBuuBVamESREi86C73VX8WamBzOZCfBNirPF" +
       "6ai84aWqSKB1WmpAsTTnorhV1QMMw57Nn3x94/oejd2XP/E7OGP5Jp71JUfe" +
       "1hw8Es3/zuwei+4/Hr3s9MRDR1497h+NiGHp6FPsy4+fZe/xHrnaQcv8Hd7n" +
       "PvLyKzLzq+XTuxc7Xli4PXTc95nKWjEvOfqQ3W8uf+XwEzuhf+L4c9xDtZz4" +
       "EPeEl0x/cULZX2XJn4eFd+q2HuZvABXMNPv6WsHC0NcXUagEV3xeuXZ0+dBY" +
       "/+V6joIcU8GdWWYRXB/fqeDj16OCsHCr6+trMVTeUA9/c0LZ/86S18PCQ4d6" +
       "uFQJWfm3DwH/j7cA+P4s81Fw/dIO8C9dr82ffSOsp246oeyWLPNvw8KdqhL2" +
       "HUk0B7v3pNghvu+/BXyPZJlPguuzO3yfvfH47jmh7L4sORsWzgB8pH3w5urx" +
       "K0z1S19lHsA/dceNgP/5HfzP33j4j5xQ9liWPLQPP4fzwCGyH3gLyLKzboX3" +
       "gevLO2RfvvHInj6hrJgl58PCHQAZc+zl6rtPsO6RN6qHinjqrZo408ZXdor4" +
       "yo1XBHpCWSNLKmHhFqCI3jU5+Pbl1iF6+Eag/+oO/VdvPPrOCWXdLHluhz5H" +
       "c+EQGHYjgH1tB+xrNx7Y8ISyUZb0d8DgY8DoGwHs6ztgX7/xwF44oexilsx2" +
       "wKrHgM3fArAHsszsRNsf74D98fUCe8Pw6ZR+QtkqS2QQg9hKPHDkg3NV9x6d" +
       "igcFOVzlLcB9PMtsgOubO7jfvPFw4xPK0izxQZQE7Hj8kOfBwc3ZIdbguk4I" +
       "h4UHr/L5R3aQ/aHLPkfbfkIlffGVe2578JXxv98eldz/zOn2fuG2ZWSaR8/O" +
       "Hrk/4/rKUs+Vcfv2JG1+RvHUhwG4q51wCQs3gTST+9SHtrX/flh425Vqg5og" +
       "PVrzp3Y+cbQmmA/5/0fr/XRYOHtYDyzi25ujVT4OegdVstufdfcd7kfe4Isa" +
       "3QwV/+Do4SjMPg/y5cPwNtnuiB466nd5IHj/G5nwoMnR7y6yQ4L5V4b7B/qi" +
       "7XeGF6UvvUINPvB67Ve3331IprjZZL3c1i/cuv0EJe80OxT4+FV72+/rDPH0" +
       "9+7+8u1P7W+67t4KfDgHjsj22JW/sOhYbph/E7H5rQf/xfv/ySt/mp/7+P8f" +
       "I7Q+/jkAAA==");
}
