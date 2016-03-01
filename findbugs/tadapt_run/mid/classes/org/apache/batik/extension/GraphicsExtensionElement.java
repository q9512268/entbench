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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVaD3AU1Rl/dwn5RyAhSPgfMAQqCHdS/B8QQ0ggcoGYxFBD" +
       "a9jbe5cs2dtddt8lB0pBpxbG6TCMoKVWaWfE/nFAHUdtpxZLW1t18M9o1fqn" +
       "alvraFVmpDMVW6v2+97u3u7t3S5eyUwz895t3nvfe+/7vd/7vu/t2yMnyThD" +
       "J42aoCSECNumUSPShc9dgm7QRKssGEYvlA6It/xl/87Tf6i8MUzK+snEIcHo" +
       "FAWDtktUThj9ZLakGExQRGqspzSBEl06Nag+IjBJVfrJFMnoSGmyJEqsU01Q" +
       "bNAn6DEySWBMl+JpRjusDhiZE+OzifLZRFu8DZpjpFpUtW2OwIwcgVZXHbZN" +
       "OeMZjNTGtggjQjTNJDkakwzWnNHJ+ZoqbxuUVRahGRbZIl9kAXFV7KI8GBof" +
       "qPn4031DtRyGyYKiqIyraHRTQ5VHaCJGapzSNpmmjK3km6QkRsa7GjPSFLMH" +
       "jcKgURjU1tdpBbOfQJV0qlXl6jC7pzJNxAkxcm5uJ5qgCymrmy4+Z+ihglm6" +
       "c2HQdm5WW3u5PSredn70wHevq32whNT0kxpJ6cHpiDAJBoP0A6A0Fae60ZJI" +
       "0EQ/maTAgvdQXRJkabu12nWGNKgILA0UsGHBwrRGdT6mgxWsJOimp0Wm6ln1" +
       "kpxU1n/jkrIwCLrWO7qaGrZjOShYJcHE9KQA3LNESoclJcF5lCuR1bFpHTQA" +
       "0fIUZUNqdqhSRYACUmdSRBaUwWgPkE8ZhKbjVKCgzrnm0ylirQnisDBIBxiZ" +
       "5m3XZVZBq0oOBIowMsXbjPcEqzTDs0qu9Tm5fvne65W1SpiEYM4JKso4//Eg" +
       "1OAR6qZJqlPYB6Zg9aLY7UL9sT1hQqDxFE9js83Pbjh15eKG40+abWYWaLMh" +
       "voWKbEA8HJ/4/KzWhZeV4DQqNNWQcPFzNOe7rMuqac5oYGnqsz1iZcSuPN79" +
       "+2t33Us/CJOqDlImqnI6BTyaJKopTZKpvoYqVBcYTXSQSqokWnl9BymH55ik" +
       "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" +
       "1zTctKGbMRP+C5Xz3o0gKgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gLrN0wegH7wCaFqKQzM7gv3Na4X9BHAv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7cN+6frD/r0z4n4/974bl+4AsDk5VMHygKfzsO8c4fvta8X3DHCv7ON75frg" +
       "2ztK8FqR4A+vnOBAjw9fiaMyWfXzYaAo4I9y73tx6V4gicNRi/eO9e9jIvn+" +
       "NYjkYh6Ys9mv7ovkV6+/yn98Rtx/z70f7VTOnz5Afs8V5HTFU+MjWfzJNcji" +
       "0Tzw/cB9aV8WX7r+svjzq8ftFVX9b2AeQBbdNzt+fvIM2eyfOR9J5c+uQSp3" +
       "54EPA/f1fal8/bpLZe+OM+Ly20x7t8Sl24FUZvQwP0nOkz13iG7v1mtA97Y8" +
       "8N3AfWMf3TeuOyU8V8B44AyID+XePQBidAixSPfzRcm7Jr8Ql25ce6ZyBPsd" +
       "16rUR4D75j7sb15/pb77jLinc+/JuPS2nVIjX5LVU1p96lq1+jRw396H9+2/" +
       "Iq2iZ2DEcu8SwBidwLj38BFG6BowPpgHvhe4393H+LvXX4XPnRGXrx733h+X" +
       "7gEqPCCnnrr7JuGApB65AkntrtudYO29Z69VDnn89/bl8L3rLwf6jLhR7pG7" +
       "ofpADoeXr/Mce+0joP1rBZrPXv54H+gfX3+g8zPiPpJ7fFy6K5+dbaJYdYaA" +
       "qBJJV0+BnF7reuMx4N7YB/nGX1HPVc9Amg8wex8DkxJDik6o8jQj37I8NdLu" +
       "SW/pnmdceuBq9/Xzm8cPXPYh0e7jF/nLr56/9f5Xp/+xuLJ++IHKbcPSrVpi" +
       "28evQB57vtkPVc0spHPb7kJkIaq9YH/RfOUPCuLSbeoJa/Z3ueK4dOF0rrh0" +
       "U/F/PF0KhrWjdGBJs3s4nmQbl24ASfLHj/sH1HHWNw5cvLHzLZzTMst2M+wH" +
       "jptWMf+5+820cpjl+NX3fCen+OLrYNcl2X3z9bz8lVcp5uM/qf3a7uq9bEvb" +
       "bV7KrcPSLbuvAIpC852bJ65a2kFZN5NP//TOr972zoNdpjt3DT4y82Nte+zK" +
       "l9y7jh8X19K3//z+f/qBf/Tq94u7df8PsM7q24o3AAA=");
}
