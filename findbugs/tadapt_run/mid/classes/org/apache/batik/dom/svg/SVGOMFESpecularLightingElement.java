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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "dCIJntkl0jY1UjCSWKLr/wVnsjjYdCMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vTTtSAuOTia5KL9PGqjH8UR64USge+B+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("xSB98HY9eVTl5NW8PDgubqcfBrLx7n76C8pXX+0Pf/SNxpd2VwMVW8qyvJV7" +
       "aeie3S3Fo2D4qVu2dtjWpd4z373/Vy6//zBwv3+n8PFQOKHbEze/hNd2/Ki4" +
       "Npf9+sP/4sP/9NVvFSfZfwfmdQiLNjAAAA==");
}
