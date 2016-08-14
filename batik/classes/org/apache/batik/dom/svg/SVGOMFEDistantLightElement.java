package org.apache.batik.dom.svg;
public class SVGOMFEDistantLightElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGFEDistantLightElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_AZIMUTH_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_ELEVATION_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      azimuth;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      elevation;
    protected SVGOMFEDistantLightElement() { super(
                                               );
    }
    public SVGOMFEDistantLightElement(java.lang.String prefix,
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
        azimuth =
          createLiveAnimatedNumber(
            null,
            SVG_AZIMUTH_ATTRIBUTE,
            0.0F);
        elevation =
          createLiveAnimatedNumber(
            null,
            SVG_ELEVATION_ATTRIBUTE,
            0.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_DISTANT_LIGHT_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getAzimuth() {
        return azimuth;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getElevation() {
        return elevation;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEDistantLightElement(
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
       "XKyVv2LT/l//Y6FwoyAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "v/3OX3nhr8sTw/8Hn5aVfgwsAAA=");
}
