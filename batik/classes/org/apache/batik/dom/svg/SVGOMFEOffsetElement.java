package org.apache.batik.dom.svg;
public class SVGOMFEOffsetElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFEOffsetElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_IN_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_DX_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_DY_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      dx;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      dy;
    protected SVGOMFEOffsetElement() { super(
                                         );
    }
    public SVGOMFEOffsetElement(java.lang.String prefix,
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
        dx =
          createLiveAnimatedNumber(
            null,
            SVG_DX_ATTRIBUTE,
            0.0F);
        dy =
          createLiveAnimatedNumber(
            null,
            SVG_DY_ATTRIBUTE,
            0.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_OFFSET_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getDx() {
        return dx;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getDy() {
        return dy;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEOffsetElement(
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
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/wDjg2pY/y0AAA==");
}
