package org.apache.batik.dom.svg;
public class SVGOMFEDiffuseLightingElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFEDiffuseLightingElement {
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
             t.put(null, SVG_MODE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      in;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      surfaceScale;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      diffuseConstant;
    protected SVGOMFEDiffuseLightingElement() {
        super(
          );
    }
    public SVGOMFEDiffuseLightingElement(java.lang.String prefix,
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
        diffuseConstant =
          createLiveAnimatedNumber(
            null,
            SVG_DIFFUSE_CONSTANT_ATTRIBUTE,
            1.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_DIFFUSE_LIGHTING_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getIn1() {
        return in;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSurfaceScale() {
        return surfaceScale;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getDiffuseConstant() {
        return diffuseConstant;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getKernelUnitLengthX() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGFEDiffuseLightingElement.getKernelUnitLengthX is not impl" +
           "emented"));
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getKernelUnitLengthY() {
        throw new java.lang.UnsupportedOperationException(
          ("SVGFEDiffuseLightingElement.getKernelUnitLengthY is not impl" +
           "emented"));
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEDiffuseLightingElement(
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
       "IwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bq954w3Zbi/7VPnrQTC4H7ozPVNFoHfCcE/975GjfPI//dEtDlQS823im3P1" +
       "JfgrP/M08QO/X9Y/Ycii9rPZrSsZCIpP6ta+7P7Pg/dd/hcH0IMSdE09jLhF" +
       "2UkK3pFAlBkdheEgKj9TfjZi3IdHN49XgHefZ+dT3Z7n5pMVFLwX0sX7lXN0" +
       "/M7Cyh85pOQjaj7jjJeg8oW/vT8eFK8fBE4ZlXH9oVP+Kfi7BJ4/KZ6iwSJj" +
       "HwA9ThxGYe89DsMCsMA/kbnONJStmPXKJeV4pIAffvAWPywnKumDeZCznqZn" +
       "ujYtuO5k3pSONr6bo/XPrkrPg+fmoRlu3sEMP3SHaVmaobTtLIYOrGPdP3xx" +
       "4IJ7lluYYD/xzun/w/eoPwyeQ9H9/9vor78R/R+JknILJKiyo98jkmFS7OfO" +
       "ITHuEUkNPN1DJN07IPHeCJKr2j4uPJptRbZ9Tjn/rsqVjWWXAPc+ULuB3agW" +
       "v5Pbd39f8frRIpkCacPyZOdIlydtR71+5P0i2PMCF79uO1hRjJ/TafaGdQKc" +
       "+OgJgXM+2F/+5H/+3K//9Pu/BYirBz2wLUgF8NUplt8P0V/+yuefedvL3/7J" +
       "MpIBduNf6V77WNHqS3dFViT5EaynC1hCuU3g5CgelJGHrhXILuZrPrRcEKNt" +
       "D/eT8EuPf2v9M7/78/u94nlyPiesf+bln/jTG599+eDUDv39t2yST9fZ79JL" +
       "pd9+aOEQeu6iXsoa1H/76kv/+Ode+vReq8fP7je7XuL+/L/941+/8YVvf+M2" +
       "m5b7Hf+WOf3GBza+VmXqEYsf/Q1EmailajZx9RHW2k6TtL7LlW53oPdydoCl" +
       "1ogdWbNlVl2ruxUsseO+11A43VNGC2yEJJprxEJzxU3woCtSnf54bSoqFSGy" +
       "sO6TOTVe5L2hqMxxvSP2+8vWnFivYk4eW+IsrsdDEvZQVEfjmqtY7ETWlXll" +
       "13Zhr1KpGG1Y8vg63V/npNa3iKa/7g3XI08Ke7y3S7ppPhXMWn/Z2yh1GqG3" +
       "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" +
       "JEF6WrJy6BmnJWPogfL/abkbMXTlRA6s");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("jfuX0yIIaB2IFK+14MjtfvAutzstJ9bD42+zQlxcWA21k7Apu3Qqnj/0vnKO" +
       "Pn63gTyucvr2X7EHKG+/H8Xryf7++4vqV1/tDX/09eaX9rcPVUfe7YpWHuKg" +
       "B/cXIY9j/ufu2NpRW5eZD33v0a89/PzR/uTRvcInM+GUbu+5/T2/rhvE5c28" +
       "3S89+Q8+8nde/Wb5Lf//AmfDMWKWMAAA");
}
