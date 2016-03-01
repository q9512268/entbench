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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mrRFkh8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "SeArAAA=");
}
