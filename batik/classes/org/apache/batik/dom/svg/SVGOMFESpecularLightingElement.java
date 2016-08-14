package org.apache.batik.dom.svg;
public class SVGOMFESpecularLightingElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFESpecularLightingElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_IN_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(null, SVG_SURFACE_SCALE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_SPECULAR_CONSTANT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_SPECULAR_EXPONENT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      surfaceScale;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      specularConstant;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      specularExponent;
    protected SVGOMFESpecularLightingElement() { super(
                                                   );
    }
    public SVGOMFESpecularLightingElement(java.lang.String prefix,
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
        surfaceScale =
          createLiveAnimatedNumber(
            null,
            SVG_SURFACE_SCALE_ATTRIBUTE,
            1.0F);
        specularConstant =
          createLiveAnimatedNumber(
            null,
            SVG_SPECULAR_CONSTANT_ATTRIBUTE,
            1.0F);
        specularExponent =
          createLiveAnimatedNumber(
            null,
            SVG_SPECULAR_EXPONENT_ATTRIBUTE,
            1.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_SPECULAR_LIGHTING_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSurfaceScale() {
        return surfaceScale;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSpecularConstant() {
        return specularConstant;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSpecularExponent() {
        return specularExponent;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFESpecularLightingElement(
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
       "fjaC3nMraSAJ0pOSH9q7xknJCLq4/T8p");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("91wEXTmWA5PG7uakyPOgdSBS3P64f+h3P3mHM5ymE2nB0Q6nAEhHlQP1OJ7I" +
       "LpwIdPfutx2kD9+pJ4+qnDziVwTH25Psh4FsvDvL/pLy9dfowc+8iX9ld8RQ" +
       "ceQ8L1q5n4Hu2512PAqGn7lta4dtXeo994MHf/XyBw8D9wd3Ch8PhRO6PXXr" +
       "w3ztlR9tj9/lv/noP/jI33vtO9sd8f8HQHHf1WIwAAA=");
}
