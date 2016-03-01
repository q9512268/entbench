package org.apache.batik.dom.svg;
public class SVGOMPatternElement extends org.apache.batik.dom.svg.SVGStylableElement implements org.w3c.dom.svg.SVGPatternElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGStylableElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_WIDTH_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_HEIGHT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_PATTERN_UNITS_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_PATTERN_CONTENT_UNITS_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_PATTERN_TRANSFORM_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_TRANSFORM_LIST));
             t.put(null, SVG_VIEW_BOX_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_LIST));
             t.put(null, SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_PRESERVE_ASPECT_RATIO_VALUE));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      5);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                    "xMidYMid meet");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XMLSupport.
                                      XMLNS_NAMESPACE_URI,
                                    null,
                                    "xmlns:xlink",
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "type",
                                    "simple");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "show",
                                    "other");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected static final java.lang.String[]
      UNITS_VALUES =
      { "",
    SVG_USER_SPACE_ON_USE_VALUE,
    SVG_OBJECT_BOUNDING_BOX_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      width;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      height;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      patternUnits;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      patternContentUnits;
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      href;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected SVGOMPatternElement() { super(
                                        );
    }
    public SVGOMPatternElement(java.lang.String prefix,
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
          createLiveAnimatedLength(
            null,
            SVG_X_ATTRIBUTE,
            SVG_PATTERN_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_PATTERN_Y_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        width =
          createLiveAnimatedLength(
            null,
            SVG_WIDTH_ATTRIBUTE,
            SVG_PATTERN_WIDTH_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            true);
        height =
          createLiveAnimatedLength(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            SVG_PATTERN_WIDTH_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            true);
        patternUnits =
          createLiveAnimatedEnumeration(
            null,
            SVG_PATTERN_UNITS_ATTRIBUTE,
            UNITS_VALUES,
            (short)
              2);
        patternContentUnits =
          createLiveAnimatedEnumeration(
            null,
            SVG_PATTERN_CONTENT_UNITS_ATTRIBUTE,
            UNITS_VALUES,
            (short)
              1);
        href =
          createLiveAnimatedString(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_ATTRIBUTE);
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
    }
    public java.lang.String getLocalName() {
        return SVG_PATTERN_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedTransformList getPatternTransform() {
        throw new java.lang.UnsupportedOperationException(
          "SVGPatternElement.getPatternTransform is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getPatternUnits() {
        return patternUnits;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getPatternContentUnits() {
        return patternContentUnits;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getWidth() {
        return width;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getHeight() {
        return height;
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public org.w3c.dom.svg.SVGAnimatedString getHref() {
        return href;
    }
    public org.w3c.dom.svg.SVGAnimatedRect getViewBox() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFitToViewBox.getViewBox is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
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
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMPatternElement(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xtF0ieVgFKtEkRskNDzyFl/LyHzws6gTeVf7OjhvcrwNlnGxawWQa8vXQRSr" +
       "BOdWCe0iLN4NjmDQ0Q7wJy8ENwRDcJ7A9bDl7zgwDPG+xPcreHR7QdE3dO53" +
       "X+qdp+ur55/e+xP32Jz3bVZdilQPZnU9eC42cF9pwYpW42qsc0/J8pMv8e2w" +
       "6I96ZchIBZQoebzZrb2TkTmlakNNKIM1W4WmgjUZmcp/g/Uuh8mdX4+RSvcm" +
       "WKUDWocqeNtpeWbYIHvP2cMO6bhr4b1CdLPKYqH5vMHIuIM3zxL8SgNPgfHP" +
       "IL1ok3U/hIT4cvqyjmtee8/t7lciqq6MjWEr01Kkyv1ghTeKp75WRrbmtVXZ" +
       "uu6tGXfXrPFi1UxXYH8cLPadlVwCfm+h0ywKfT/hNOY/o3jytm33P3Ki8vE4" +
       "ie0jMQUcb1/xWeyclbXJ8n2pUmewehWbf9rRVPv8/kff+FlsFv9ogLintpbJ" +
       "OPrVG+5/qmvQsv4tTmrayFQNjzjzg+I7DhndVB2xC450VQ6YWSN//HMGeriC" +
       "cxyuGaHQ6fmn+JURrBOLTz0Wf3lVq5uj1N6OrWMz00Pn5LKWFaRyzX7WTQuo" +
       "aXDD/lS7ZYljn1N+wTVvWTiS4wM8MfwNxFaZF+s8AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GGGSQVlG7KgymzUpeuJKlW7YjoRmqVdxGXrC1DuoYPJ9k2tCMMuR1f5yYmEK" +
       "JQ+HXL9MNnyCKatEh14GPOb0KilfplNZh6XiABdZeDFh2pE0CBYBPoSKVdti" +
       "E401VlWWW+gVodbxJitDDxdLnh7rk9GUWvUSqtnr4jFZ7ZhupWn0bGzUXbiS" +
       "pzXGarVUblYnK95W6VItP0Wq3XF/xPuKzuCDBsp7c9LOY1Xa7qNtt73IFyli" +
       "qCz7cZ/DoTjAJ/WFO9fh7nKWkjZPzeo12eGo/MzoNCp6kZq6iDa1+U5YQIkl" +
       "CYeI1ffrqt/pDuuzRm0w14u+bPQbhajOCc2VrOODbkWrF4R2c1VDHcSX2mHq" +
       "M/NSL8m7bp8OFKY99vV2OQbX0qOwXhxoOkJptA8VbJ1zWuYKcZLe2F5NUAKP" +
       "dWCy2GzpOnIr9GNY5xqaUAAL14Ja6cFKgzBUGKdJE5LFPgzsfT7VHGTuDpXy" +
       "gG55g6WMh7NKVaHdYmWISo4nyQrrzIHLDuAKbUwECOXIBs9GPO8qruBrBVhA" +
       "ocTDWaRAByaDww1GZ6G5b/CdQZOK5kjClvTeRKC7cBpaJk2X85LCF5pdqI0u" +
       "Io1xoTyWjtpCw1A0jsxPxpFfLnOJhRSXTaXJtj2suCgPuhiIzTheML1mi50v" +
       "A6pICHihQHoV2+ebIi0Q3jxyayN92A1obFS09cSrs2jgd0bD4oRB2L7ei41e" +
       "2iFn5oAtI/0h5TfHC8Otx1YdH8OrZrtrlPuVgcU3BY5FB/OYGbZ7zgxftJvG" +
       "gJbwmjToQ7Gz1IZqOgjxaK402EWJbOpEH6NjutW2wrTNpEu0RHfzg5Fh1uU2" +
       "Whml3dpKKMpup1pyR3NTAvoP6/nmzKoufWokUj2ao0V9pM1blFNWRsMFXQyD" +
       "wojRuvE0oPh5Zey4iYCjtI/nhaA6dEfu3LaNYUHApHZkEstVTRmILVgo5f0A" +
       "ZsmOX8K8edJoVtgQT/OJ5S9xatSnQN5FBylFjkLNd2HCA3lulut4ojgN0UBa" +
       "eC5dnCaWaIxxgawVLLeNUkaxJlAjQYf0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/dLJ/wPIc2mzGk0AAA==");
}
