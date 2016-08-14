package org.apache.batik.svggen;
public class SVGFontDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private org.w3c.dom.Element def;
    private java.lang.String fontSize;
    private java.lang.String fontWeight;
    private java.lang.String fontStyle;
    private java.lang.String fontFamily;
    public SVGFontDescriptor(java.lang.String fontSize, java.lang.String fontWeight,
                             java.lang.String fontStyle,
                             java.lang.String fontFamily,
                             org.w3c.dom.Element def) { super();
                                                        if (fontSize ==
                                                              null ||
                                                              fontWeight ==
                                                              null ||
                                                              fontStyle ==
                                                              null ||
                                                              fontFamily ==
                                                              null)
                                                            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                                                              org.apache.batik.svggen.ErrorConstants.
                                                                ERR_FONT_NULL);
                                                        this.
                                                          fontSize =
                                                          fontSize;
                                                        this.
                                                          fontWeight =
                                                          fontWeight;
                                                        this.
                                                          fontStyle =
                                                          fontStyle;
                                                        this.
                                                          fontFamily =
                                                          fontFamily;
                                                        this.
                                                          def =
                                                          def;
    }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_FONT_SIZE_ATTRIBUTE,
            fontSize);
        attrMap.
          put(
            SVG_FONT_WEIGHT_ATTRIBUTE,
            fontWeight);
        attrMap.
          put(
            SVG_FONT_STYLE_ATTRIBUTE,
            fontStyle);
        attrMap.
          put(
            SVG_FONT_FAMILY_ATTRIBUTE,
            fontFamily);
        return attrMap;
    }
    public org.w3c.dom.Element getDef() { return def;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        if (def !=
              null &&
              !defSet.
              contains(
                def))
            defSet.
              add(
                def);
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GE42q/6zwTfpgfw4gu1Z/orNO/8FyTb1Ae8dAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "DZFcd6iNKWuRntcYZ6iGk0E4tBVFCRzFspNFcyjKCzlbRcKUlGah5czqkWso" +
       "amqOkQlDdo3KKFU3zZneErZRA2/KjBctdmrYrNrTqMk76krSWbPjKyE3mOuT" +
       "AboKp4SI5oQX4vVo0o26ojjcRDM+FTdzpVrtpyALStnEHzpTIcsZc0xt1u2x" +
       "uaNdgql5ZDMbVuxAZtXU73qJL8PVqWvLC5jp5Dlbr7NGp70kxIqFrXqLoGby" +
       "MRVgYk+csaZEB0oYKVXeavptwQorHr7tNu1QZIJcUTqVpCk53MJzF0tHT2td" +
       "vxZhnt8ZVQlls6oNFE9WFHW2HIojppfMaxI9lSI8nnDaDJ0Rdd0cdd1FHNC2" +
       "7OC9TKUXYYAGM7kmGA7OxYtOwo0xPCFEnxHWk2RKDCv4JKSSjSlMdUZ0xn1q" +
       "JFbocCA1u0yPzvkcH6fk3LLFkeg4TavblwM+mY8r3elWqHVZajvsNeitqHaZ" +
       "ZMPHDcJb9nZKVid5NnVR1hHYMS81XGI5W2OKMsO4oecBfax5xRwMsrmw1ulh" +
       "o6WTItW3GY20sTnnVNuIjtRz1xqu8TBi251epWfAztDKxN6mPl/vcl9rO9VQ" +
       "sQahQqi43YR3dQbOkTh1gJ9gYJCoPBG67RGPUi5Htzo1uD2qIAIetmzSTaKm" +
       "J2275ERljKElTr0sCwSnRlfm5ihSaGVN86NOA2MMqh0NrFlnufD6wtQZeQqb" +
       "xz6jI5vFnJawfhaZSt2S0mCyXluJMIDJ9YCiBGnTH802LD+2MQSRPSGW+8Ko" +
       "sjAdsRHZTZmApcqyFY9Nc7fqobo9zntEHxnEZCXFHGvAkZzcF3G+a1u7pLsY" +
       "Ol41H/bMzGtsdtUwyhXZHrM2OdSiIVu14G5WU3m3IWJRc9nv7FAGQE9HBf4F" +
       "K2NQ0ZzoRkNAQVw7A2LQJms9nGMXw2jj9dhhuMlZRhs2pAYj9letCUdvFbaH" +
       "JbvcSvR+T6nZUq+2U5MaV1XwkHBX/Xa3ntNACGSlA1RH+z3UIfMkmzXyjZ7N" +
       "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");
}
