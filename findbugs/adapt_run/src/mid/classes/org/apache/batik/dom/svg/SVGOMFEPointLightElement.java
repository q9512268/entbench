package org.apache.batik.dom.svg;
public class SVGOMFEPointLightElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGFEPointLightElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_Z_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      z;
    protected SVGOMFEPointLightElement() {
        super(
          );
    }
    public SVGOMFEPointLightElement(java.lang.String prefix,
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
        x =
          createLiveAnimatedNumber(
            null,
            SVG_X_ATTRIBUTE,
            0.0F);
        y =
          createLiveAnimatedNumber(
            null,
            SVG_Y_ATTRIBUTE,
            0.0F);
        z =
          createLiveAnimatedNumber(
            null,
            SVG_Z_ATTRIBUTE,
            0.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_POINT_LIGHT_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getZ() {
        return z;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEPointLightElement(
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
       "48flHaP8X7zlZ9//T1/+vfJ88/8B6MvLiVEtAAA=");
}
