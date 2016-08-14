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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "d0fDxO127Gpt0Us5xZuOBUSabjouJJH6atYsCySRs8u5nQIfyCbr6cxDKrM5" +
       "Ws/DNTFpRkpl3K/Y7obubhbWIFMTexRkSN8a4Zup0m1W0005SJdjDTI6eL1W" +
       "TWupXdX4UUJ5aA2qCZSzRHK1P2U75KYekk7XaNtJu6IT3SXCrhIyqEChji3X" +
       "Ll7rMS2BHZMDfY2n3kJntKDOLlUnRrsL2mrh+WiSGy5utiGqStldiYOBAIG5" +
       "QCpKjPtRhW72FinDLwRT2iyqkzgKWjIeuWjZsvpEhkuBvtkkSV5vY1DDkZlI" +
       "B/FhwqSq66cBPvLTkJdij5ZqSydpejrrw+qGTmVYhSPfSxuZ7cpildPRskCZ" +
       "7ZEWdzvdNmTUFQZWWJKs43CnDkuKsJnGy2U09tYyNcBGVdw0EYOddvJAxvth" +
       "BzOhHhm1UlrDRWE4Eu2hOK7qrIPGkISW4Rrkh1hUM2x3PGbzSr+6LMNNtVYJ" +
       "BzVHbzVUKEcChe3kZJUGMrRW+UJ1iQTi4zIq2pxQk9cchKlwJ6vI4aQ3bup0" +
       "w8s2DhLibHPC2NWFrCJJReFrk9pkNR9mmJYsVXrMEfPVsK+EwGVzeaUk5ZqE" +
       "tTyiQYd4r53wYhqj9WFaHhDtiqd04BUVZ0u7qcRQg+61KAOrZdJcz7qkx6UK" +
       "CBRgCjIlk8AzAvXLCVxRY2Y0qsX+zJ3VNgwa+7YJZRMor+vyuNf22X4Ly3lT" +
       "hYbNWkxSKDeapjxnT+smx3ToFu8JSkyVx1k7kTJpk1WgvlfLA6zZljGDlVhn" +
       "LYYtGzUHKIoRMY37jGCnSX+2sGs9oapb4XrJrfRl2lgOMdTUlm08cxcjvQYv" +
       "UndAk3LXrMYdG80qOsNZTSTHhj0tmjCUz9VRY0n3Zg0zGi+z+pzOHQ/m10g8" +
       "GGDwspfiOBVvNnOkLihUtzMZaTqvNhkHqie4Wlusy46VMGxgeuhQcvutnjGH" +
       "gznjYEhlBEMgHwSOrbnmqkpCfWBAUEXGHIYfVnK10WD62LITtJN0UsVypdHY" +
       "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" +
       "sz2clvnlROnM0PrK8wd9PJnNOVWM6s5w");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Pk0AAA==");
}
