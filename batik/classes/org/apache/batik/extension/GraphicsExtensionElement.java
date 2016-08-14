package org.apache.batik.extension;
public abstract class GraphicsExtensionElement extends org.apache.batik.extension.StylableExtensionElement implements org.w3c.dom.svg.SVGTransformable {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.extension.StylableExtensionElement.
                 xmlTraitInformation);
             t.put(null, SVG_TRANSFORM_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_TRANSFORM_LIST));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             t.put(null, SVG_REQUIRED_EXTENSIONS_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_URI_LIST));
             t.put(null, SVG_REQUIRED_FEATURES_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_URI_LIST));
             t.put(null, SVG_SYSTEM_LANGUAGE_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LANG_LIST));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedTransformList
      transform =
      createLiveAnimatedTransformList(
        null,
        SVG_TRANSFORM_ATTRIBUTE,
        "");
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired =
      createLiveAnimatedBoolean(
        null,
        SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
        false);
    protected GraphicsExtensionElement() { super(
                                             ); }
    protected GraphicsExtensionElement(java.lang.String name,
                                       org.apache.batik.dom.AbstractDocument owner) {
        super(
          name,
          owner);
    }
    public org.w3c.dom.svg.SVGElement getNearestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getNearestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGElement getFarthestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getFarthestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGRect getBBox() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getBBox(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getScreenCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getScreenCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getTransformToElement(org.w3c.dom.svg.SVGElement element)
          throws org.w3c.dom.svg.SVGException {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getTransformToElement(
            this,
            element);
    }
    public org.w3c.dom.svg.SVGAnimatedTransformList getTransform() {
        return transform;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    public java.lang.String getXMLlang() {
        return org.apache.batik.dom.util.XMLSupport.
          getXMLLang(
            this);
    }
    public void setXMLlang(java.lang.String lang) {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_LANG_QNAME,
          lang);
    }
    public java.lang.String getXMLspace() {
        return org.apache.batik.dom.util.XMLSupport.
          getXMLSpace(
            this);
    }
    public void setXMLspace(java.lang.String space) {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_SPACE_QNAME,
          space);
    }
    public org.w3c.dom.svg.SVGStringList getRequiredFeatures() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredFeatures(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getRequiredExtensions() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredExtensions(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getSystemLanguage() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getSystemLanguage(
            this);
    }
    public boolean hasExtension(java.lang.String extension) {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          hasExtension(
            this,
            extension);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3s8/Mbv3P0xori/PKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yA7UfP8V1Dwu7vkcov7qNaDeHiz+FAgv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7aN+6fqj/sYZef++iH49Kd0MUGMCdQD6wSuAppQksrMj2F+/VthPgPDyPuyX" +
       "rz/s3z0j7/eK6NtJ6XYAm1cjXfcB+CLtW0f4futa8T0Dwqv7+F69Pvj2jgq8" +
       "vi3w+1cucKDHh6/EUZmqh8U0sG3gD4roO0npXiCJw1lLCI6N72Mi+e41iORi" +
       "kViw2a/si+RXrr/Kf3hG3n8voh/sVC6cPnh+3xXkdMXT5iNZ/PE1yOLRIvED" +
       "IHxhXxZfuP6y+LOr5+1tX/W/gXkAWfTe6tj6yTNks39WfSSVP70GqdxdJD4M" +
       "wlf3pfLV6y6VvdvPyCtuQe2dT0q3AamIFFmcQBfFnjtEt3fLNaB7R5H4XhC+" +
       "to/ua9edEp7bwnjgDIgPFdE9AGJ8CHFb7me3Le+6/GJSunEV2NoR7Hddq1If" +
       "AeHr+7C/fv2V+t4z8p4uoieT0jt2So1DRdVPafWpa9Xq0yB8cx/eN/+StFo/" +
       "A2OziC4BjPEJjHsPH2GErgHjg0Xi+0H4nX2Mv3P9VfjcGXnF6nHvA0npHqDC" +
       "A3Lq67vvFQ5I6pErkNTumt4J1t579lrlUOR/Z18O37n+cqDOyGOKaLibqg/k" +
       "cHhpu6ixhx0Bxa8VaOG9/OE+0D+8/kClM/I+UkRCUrqr8M42caJ7JCCqVDH1" +
       "UyAn17reeAyEN/dBvvmXNHL1M5AWE8zex4BTYinxCVWeZuTz81Mz7Z7ytu6H" +
       "JqUHrnbPv7ix/MBlHxntPoxRv/jahVvuf23yH7dX3Q8/XrmVLN1ipK57/Ork" +
       "seebw0g37K10bt1dpNyKam+5v2i+8ocISelW/YQ1h7taSVK683StpHTT9v/x" +
       "cmswrR2VA0ua3cPxInlSugEUKR4/Hh5Qx1nfRvDJxi22cE7LLNt52A8cN62t" +
       "/3P3W2nlsMrxK/PFTs72a7CDXZd09z3Y8+qXXiPoj/+o9au7K/uqq+R50cot" +
       "ZOn87uuBbaPFzs0TV23toK2bh0//+I4v3/rug12mO3YdPjLzY3177MqX43te" +
       "mGyvs+f//P5/+sF/+Np3t3fy/h9RxBtSpjcAAA==");
}
