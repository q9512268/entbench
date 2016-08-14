package org.apache.batik.dom.svg;
public abstract class SVGOMGradientElement extends org.apache.batik.dom.svg.SVGStylableElement implements org.w3c.dom.svg.SVGGradientElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGStylableElement.
                 xmlTraitInformation);
             t.put(null, SVG_GRADIENT_UNITS_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_SPREAD_METHOD_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_GRADIENT_TRANSFORM_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_TRANSFORM_LIST));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
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
      UNITS_VALUES =
      { "",
    SVG_USER_SPACE_ON_USE_VALUE,
    SVG_OBJECT_BOUNDING_BOX_VALUE };
    protected static final java.lang.String[]
      SPREAD_METHOD_VALUES =
      { "",
    SVG_PAD_VALUE,
    SVG_REFLECT_VALUE,
    SVG_REPEAT_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      gradientUnits;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      spreadMethod;
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      href;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected SVGOMGradientElement() { super(
                                         );
    }
    protected SVGOMGradientElement(java.lang.String prefix,
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
        gradientUnits =
          createLiveAnimatedEnumeration(
            null,
            SVG_GRADIENT_UNITS_ATTRIBUTE,
            UNITS_VALUES,
            (short)
              2);
        spreadMethod =
          createLiveAnimatedEnumeration(
            null,
            SVG_SPREAD_METHOD_ATTRIBUTE,
            SPREAD_METHOD_VALUES,
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
    }
    public org.w3c.dom.svg.SVGAnimatedTransformList getGradientTransform() {
        throw new java.lang.UnsupportedOperationException(
          "SVGGradientElement.getGradientTransform is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getGradientUnits() {
        return gradientUnits;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getSpreadMethod() {
        return spreadMethod;
    }
    public org.w3c.dom.svg.SVGAnimatedString getHref() {
        return href;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMAElement(
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
       "bcdc9uj/pp3FJ//9/7rOVLYUfAN35Ux9CfrqLz6Gf+h72/rHXFjUfiK/fqkC" +
       "Pu5xXeRX3f9x4amL/+xC6U6pdFk5cKAF2UkLhpGA0xgfetXAyT6Vf9oB3Hk7" +
       "zx1x/TvO8vCJbs+y8PESCZ6L0sXzPWeI962Flj8AAnRgO9BZs9srbR+oneVt" +
       "46tF9JM7Kyoen0lKF+Otm37AdH8O/vZA+L9FKBosEnb+zIP4gVN15cirCsAK" +
       "/lDuOnwkW8nQ2y4eRyMF7PCZ6+xwOyU7frpw1kNP1XJN5QtWO54hW0OjX8vQ" +
       "hkdqeHuR2gUBP1ADfhM1SDdWw21bNRQRm4BRsDzZ2SqaS0oPywmYVQvgvw89" +
       "sPgU+xQtOoR2c8cFu0GtM/g+eov4LoIgHuDjb4JPfU18RfTxQ3D3Tqkhz10T" +
       "MGLa5cD0fNfNp+d2wdh5+S9/5ek//KmXn/53W869y4qBEWORcYNtx4k6P/jq" +
       "q9/7o/se/9rWNbl9Icc7cz67X7t+O3Zql7WV+94jtTxcaOExEPYO1LK3M9Jr" +
       "1xvp+6+EqRxbYQrW9GcCYHmWcmVn81e2w31lx50f/dgVku50r1EY2eWufPCK" +
       "p60Ocj4hu4sXPrq/v/+x594TBFtBPnxEd3s7p2E3akXkHA6If5N5B6bcTopT" +
       "43HR0TwjMc8nSiayXGBT2cG+DHrhwVeXv/jdX9vtuc6y4pnC2qdf+ht/vv+Z" +
       "ly6c2Ok+fd1m82Sd3W53K+B9WymL1fjJ83rZ1uj9x6+/8I9/+YVP7aR68PS+" +
       "reul7q/9y//zB/tf/M43b7AduA0YQfFjGeQ3W/QeOl70cMf3tII+DvN2+wLL" +
       "3z86VwCZ+XVjFZWevbmOya3RHa8Iv/vJ//wY/yHz+VvYELzzjI7ONvkr5Fe/" +
       "2X+38vMXSrcdrQ/XHTqcrvTc6VXhnkhL0sjjT60Nj+/Mb6u/G9veXvEY7Uzu" +
       "nHX/r5+T92IR/RygSqVQ/m6szin+mbx0hvu0vwD3LQ4m+cduwn1/69a472GO" +
       "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" +
       "11qIjXDCYAzh44TfrJpKysgNTcu0JG8K");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("a2i8iqSEJtNaH1/mTJ4Zy/IoqLY3OqKtUcuJRb0TlcPFCFUDEl7N+DkyEXmR" +
       "FpcdodORywasSvUq0pU6qCsidSgVB9UKykODEYk5yRDvt5eST6UaNIKdYDxq" +
       "kEjOjFWTmQ5pD2oDP7O8CSWRqS5tatSHUkt0EdUjh0O/rGgQC6PVlpstWiTu" +
       "REN4ymVewyKg3mwhiLOp2BtuNsF8XKtHY07YUJ2mxggbTCDhynztwmRGTjNo" +
       "hlVGQqMfVBvQNEUjDOV1TqTthJpqcS2bopFregQFGfhAnHlTijBNsZ6rcH1j" +
       "l8mRLTK0bDoxmjNpYwDVRLkxavS9SYhh2AeL46h/cWvHZA9sT/+OLln+Bc79" +
       "8nPecUdJ6S754OrD8X2e7d+l0sFtvcP/J85gT1xf2Ds8SH2qOEhdVZWT56dn" +
       "rqgV78gev9kdzO37sS9/8qWXVfqXKhcOXpGsk9LdiR+8zwG255zo9Z7t8ydP" +
       "nxrDILx4IPGLZ0+NjxV27pHxOa9r/vScvP9QRK8mpbdbR++1McchrEw7euMd" +
       "3/BUM/Mt9XgYv3Mrl0jOqODeIrEMwucOVPC5W1FBUroziKxMTrTX1MN/Pyfv" +
       "R0X0X5PSo8d6OK2EIv+7x4D/2xsAfLVIbILwlQPAX7nVMX/Nt317pXPythPo" +
       "x0npYbDKHxo6H8leXFz1OHXL48ysOHyncFS4uHB2rJM/ewM6Ka5alRAQvn6g" +
       "k6+/+Tq5/5y8y0V0d1K6fEInp17TvfscfZx4N3ekjb173qg2KiB840Ab33jz" +
       "tfGOc/KeKKJHktIloA3u9Eu+vQePIT76BiA+XjqYCb99APG333yIz5yT92wR" +
       "PQ3YA0AcnHhb+OQ543ziPt4W/9U3gP+JIvH9IHzzAP8333z89XPymkVUSUrv" +
       "APi7r/Wu8UZL5JkXjMdaQd6AVp4+1Mq3DrTyrVvVymsuh3udc/J6RfThpPQI" +
       "0MrNrnw9fwz1I28A6kNFYnHZ6dsHUL/95kNlzskrvLW9MZgAnraifPXous3l" +
       "k2N9lLGFS7wBuMW3FKUWCK8ewH31zYf78XPyni+iOVjgwcievdl4dFtROMYq" +
       "3dK12OL6yQ0+bSguaT963RdWu6+ClK+9fOmuR16e/qvdFbrDL3fuJkp36anj" +
       "nLwteuL5ImBj3dpq4u7d3dHt3bU9AyC72YWApHQbiAuh9/RdaRvIe6PSoCSI" +
       "T5Z0DwziZMmkdMf2/8lyQVK657hcUrq4ezhZJAatgyLFYxIcWlv5vFsMXLJ2" +
       "iqE59ML3TjjSBwa2dTwefK2xOqpy8vuB4pLY9iO5wwtd6e4zuWvK118eUZ/4" +
       "Yf2Xdt8vKI682RSt3EWU7tx9SrFttLgU9uRNWzts6+LgPT++/9fvftfhxuD+" +
       "ncDHxn5Ctnfe+EuBrhsk27v9m3/4yD/4wN97+U+2Nxj+H7hXBKO9OAAA");
}
