package org.apache.batik.dom.svg;
public class SVGOMTextPathElement extends org.apache.batik.dom.svg.SVGOMTextContentElement implements org.w3c.dom.svg.SVGTextPathElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMTextContentElement.
                 xmlTraitInformation);
             t.put(null, SVG_METHOD_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_SPACING_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_START_OFFSET_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH));
             t.put(XLINK_NAMESPACE_URI, XLINK_HREF_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_URI));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      4);
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
      METHOD_VALUES =
      { "",
    SVG_ALIGN_VALUE,
    SVG_STRETCH_VALUE };
    protected static final java.lang.String[]
      SPACING_VALUES =
      { "",
    SVG_AUTO_VALUE,
    SVG_EXACT_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      method;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      spacing;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      startOffset;
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      href;
    protected SVGOMTextPathElement() { super(
                                         );
    }
    public SVGOMTextPathElement(java.lang.String prefix,
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
        method =
          createLiveAnimatedEnumeration(
            null,
            SVG_METHOD_ATTRIBUTE,
            METHOD_VALUES,
            (short)
              1);
        spacing =
          createLiveAnimatedEnumeration(
            null,
            SVG_SPACING_ATTRIBUTE,
            SPACING_VALUES,
            (short)
              2);
        startOffset =
          createLiveAnimatedLength(
            null,
            SVG_START_OFFSET_ATTRIBUTE,
            SVG_TEXT_PATH_START_OFFSET_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              OTHER_LENGTH,
            true);
        href =
          createLiveAnimatedString(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_ATTRIBUTE);
    }
    public java.lang.String getLocalName() {
        return SVG_TEXT_PATH_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getStartOffset() {
        return startOffset;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getMethod() {
        return method;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getSpacing() {
        return spacing;
    }
    public org.w3c.dom.svg.SVGAnimatedString getHref() {
        return href;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMTextPathElement(
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
      ("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" +
       "P36p+KEGcN4TMNeLXScYkEJHOqAQtg2o2m1AmQkuma5zIBn8NoJcCu2kxd7J" +
       "8UvGDzWAezFgDsN3aBNkOmAv3lv5zE37gCOW/k/lTRAjU/J98YDv6WbkfFxl" +
       "fhAkPjhaVTJ9dMNJ82bU/minIkZKEilZdr/1cD0XaeAuJC7WCvMdCL+mCCWB" +
       "Y7/ShpEC6JH2kGxCa0BvPmiAhN4NaVg25YZkpJD/d8MNg1d34KCoNx/cINth" +
       "dQDBxx2abbDLx/6ChH9mpjC79jELpVlujfA8bepYisyguF/U4z0e/0jOvlVK" +
       "mZ/J9YtHRtd1XHv6c/eZHwqIsrCDX6KUx0ix+c0CXxTv7eb5rmavVbR20ZmJ" +
       "R0sX2OXYJJNg53DMciyYNEFtoKHlzPS8QjcaMm/SX9m/8vFf7Sl6MUxCG0lI" +
       "YGTyxtzXbWktBXXixljunVmvoPN3+42Lvr398qWJf7zKXxIT845ttj98v/jy" +
       "gWteunXG/rowKW8jhRK+weLvAVdvV9ZTcVjvI5WS0ZIGEmEVcNFZF3IT0cgF" +
       "DGNcLpY4KzOj+JkJFMC5d9u5H+eUyeoI1VepKSWOy1TGSLkzYmrGc/WZ0jQP" +
       "gjNiqRL7/djdmEZtgL32x9o1zX4FUNKg8fN+X8YNWBeTfJDb+E38EZ/2/g/d" +
       "H6WdQCsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "lySnOyqFE3gwmXa7jIFUCFo1N1OmRUZe");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("rwMswaHDhSrTDsRNGg6ErshZnbNrNJ/g7ZJNTdvjTRKlE0W0ouZkYib2InYF" +
       "Z+WxTAVMH/1VUGmgS7E7q6e9SUKN0SoSRYsGuoIWG0OM9NgFc1HgrXsiupiP" +
       "esW13l9hgrYSGtJYFRYrChG5kkS1W05LUBlSIivUuKQaJNFm1L4/rfbSwaLY" +
       "BUtBGkc0MLd0ijq/0T2qLOh+jxMHm/K4zfUtMBcHbRUSpdICBHwLxlyO+nVI" +
       "W2hOS4qMPoidGl45nVRJnukZ6IwpTtApIzb18axLKMVWBW1JEAwZkNapidoQ" +
       "DzEMez7fEfs3N7dldn++E3h4aPJH2ANMjr3IONxczf/O7zZYDzZarzkz8eix" +
       "t3IPR4Wns23TdUU9vlt66sRZ9n7r8Rsdm8zfbX3x4y+/og1+uXxu98IjjQp3" +
       "Rp7/Pltf6faxXi/k93/35HZwCVwv7SR+6fR28JFOztwLPuPly5+ekfdnWfIn" +
       "UeHt5uELacy2++ZKP3xVHV53E3PlmdqRpb51M6c/Tqng7uxhEVyf3qng0zej" +
       "gqhwux+YKznSX1cP/+2MvP+eJX8RFR490sNJJWT5/+kI8PfeBOAHsodPgOsL" +
       "O8BfuFmbP/+6WP/6xnl7eVf/OyrcbehR31Nlm9m9P8SO8P3Vm8D3+IFBv7TD" +
       "96W3HN/ehTPy7s6S26LCvQAfd+2LnqeuM95Pvt05VMPe+TehhqcP1PDVnRq+" +
       "+tar4dEz8h7LkgcBDwE10CfeJr7rDA0ce4V4pIaH3qwa3guur+3U8LW3Xg3v" +
       "OiMve/G791RUuJB5w+G7yL13HKF7+s36+mVwfX2H7utvPTr4jLxqlrwPkCBA" +
       "1zn2LvAsJz92HjDHv/8m8D+TPXw/uL6xw/+Nm8X/uvPX3hnHEPeaWXIlKjwC" +
       "8N/ocJVyBPW5NwH1wexhdqroD3ZQ/+Cth9o/I4/JkjYwtauvGU87PNty33FT" +
       "H2bkcDtvAm72vUKhAa5v7uB+862HK52R96EsAaHio8Cyp88QHp4LnBxhFW7q" +
       "AGpUeOh6nxZkh6QfveYrpu2XN+qXX7l4xyOv8N/cnlU7+Drmzn7hjlls28fP" +
       "ZR67P++DUWnmmrhze0ozPySWndR+9Ebv66PCLSDNhN5TtqVnQN7rlQYlQXq8" +
       "pLlziOMlo8Jt+f/j5WzAiEflosL57c3xIh5oHRTJbn3/wNtKr/+pRv49lxsd" +
       "xM57x8LfnZflIcYDr2ewwyrHD/Fnx7Lyr9EOjlDF2+/RrqpfeaXLfPQHtV/e" +
       "fkSg2nKaZq3c0S/cvv2eIW80O4b11A1bO2jrfOfZH9771TvfeRDO37sV+Mjj" +
       "j8n25PWP67ccP8oP2Kf/9JF/8tw/fuVb+TGD/wcVr+MRJjgAAA==");
}
