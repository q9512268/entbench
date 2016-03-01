package org.apache.batik.dom.svg;
public class SVGOMFEImageElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFEImageElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             t.put(null, SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_PRESERVE_ASPECT_RATIO_VALUE));
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
             attributeInitializer.addAttribute(org.apache.batik.dom.util.XMLSupport.
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
                                    "embed");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      href;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected SVGOMFEImageElement() { super(
                                        );
    }
    public SVGOMFEImageElement(java.lang.String prefix,
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
        href =
          createLiveAnimatedString(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_ATTRIBUTE);
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_IMAGE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getHref() {
        return href;
    }
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
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
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFEImageElement(
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
       "tKiULDxlsFzKy2VYrLDpWa6lh2E17uFmdYBCzyiGreCM/8+CZTXHgkumiLlk" +
       "siuWFEwNbcMQo8B3V6hiGnMCt3ZjAFG6sbicV12MRZtp+aVfzdn4YJ0pMYc/" +
       "wz3PwrykwjczTjz86NTd7z515v4Kcym0zD8JeORmfdErD+995/M8mvLwX2CZ" +
       "5pEfih67Z3b72g+5vBOHUXpxJj9JQ6ZyZL95NPVpuLn812FSMUQaRGvjsEmQ" +
       "0xjdhmCxbNi7Cdhc5NTnLnzNVV5rNs/M9eYAV7feDOAsDuAeW+N9nSfoT8eh" +
       "WQNXxCJcxMvgEOE31xQmcRhvVwKTDb498TB5WoBiRpoyKXlQFyTWpfBklR0d" +
       "IOw38gjLZ+gVKkwY2FcmaAb2txhFnQnGGbl5Ikb2Zy2cg0874FprWbjWB7pY" +
       "GHoJh47FtQw8LymC7IE/O0A5I9Ncm27IiLhxo7qNf6XvWq6tgJTHCYmv7gSe" +
       "9HGJ3WvZ2evjBHNklmKxPD+V+kkzUgohOWmjmmCF2qZIKdxemLHLA0otElQ7" +
       "XIOWWYM+oMYDQflJA3M181iFthkazM9+pK6N8ZKvhrEvX4MHcKZIwJfBtdky" +
       "ebMP4BsDAftJM3IORFuqA8PxzIBvcfrpjrSk08TEhM2BvV5VZSooHqh7AqBm" +
       "HJPbsybzv3KLujaF8/KkmWVCtomL0MTx1aLbstxNES5S5vlt+flxxZG9Bw8n" +
       "eh9YZWajxtxtdIeSTj30h3//JnLozycL7M+qmKqtlOkYlV3W1UGXi/JyYDc/" +
       "EXESysWvnik5tX9Wbf6eCjXN99kxLfdPlt4Ontv719mDa0e3FrFZWuBxlFfl" +
       "g93HTm5cKu4P80MdM3/lHQblCrXmZq1qnbK0rgzm5K7mXNafD5dqkUD1st61" +
       "+vKhvJ9owCLonoC6w1jcxcgcKRuc22Q5JsE8t8O2YQSuYvp0KQWiY9ZhUXR3" +
       "49vb73n/IZNv3iWLpzHdd/CWLyO3HTS5Zx6/Lc47AXPLmEdw3PQG0zlfwl8I" +
       "rv/ghbjwAf7CwqTdOgdamD0I0rQM52+AWbyLDe89svvxn+y+OWz56QeQGMZU" +
       "KeGEgEPFLyX54wPZMa3FqvOwkTWm4wF0KLAYr9B0aQxAeZJ4TYDGACb8LKDu" +
       "USyOMTLLYUkuRbD+fsc3D03aN41YhRuVmywkN00wVdpznVAdIBoA9KmAuqex" +
       "eIyR2hHKYqooyD3WxO90gD8+aeDzsKoFrlst628tHrifaAC4FwLqXsTiWeAb" +
       "AO90LY4KpafcFZHjmOcm7ZjlWIXS+y10+4t3jJ9oAPg3AupOYfEaIzPAMQWW" +
       "R7afIgF+8hPjTvv91zON5sJ1t4X87uKd5ica4Jj3Auo+wOIdRqrBadd0x3DX" +
       "6JlE704aNj/mwBXWfZbt9xUP20/UAy1kRmMOgWv9RwD2T7H4G2A3crC7Iuff" +
       "v54hxyjyoAXgweKx+4kGQPvSvy7EvfMFIzXmkBuw6PYGzrNfz5jjO5jjlvHH" +
       "i8ftJzrBmIdqAsDXYVEO4I1c8M6ghyomDR4zJbkUrscsBI8VD95PNABbUN05" +
       "WDQyMhcGvWOizVhzQIi0dmCOu5om7a7FtruesTA/M4G7CizE/UQDXLIkoO5c" +
       "LBYyMhPc5Xdiss3xwaJJ+6AJq/DA56QF5GTxPvATDcC5KqBuNRYrYKGh0PEe" +
       "2B7a7GhwsyNbwf2wctJ+wBdI5BK4XrbAvFy8H/xEA7CuC6hrw+JSWG4DF7zn" +
       "jdkzxLjjhNb/4VSbkaYCL1nx/cKsvA89zI8TxIcP11fOPHz1H/mLvuwHBLUx" +
       "UplMy7L78NZ1X67BilHiPqw1j3I1jrET4PmdwDBSAiVaHtpotr6KkWmFWkNL" +
       "KN0teyy6uFsyUsZ/3e2+BVnYacdIuXnjbjII2qEJ3l6t2VxcN8E7a0mGUJfd" +
       "Tw4wPBzRE85OKWOe7syxRsPJgNMnGsSsiPv1Im7H+fc79plG2vyCJy4+cvjK" +
       "nutPX/SA+XpTlIVdu1BLTYxUmG9auVI8F1nkq83WVd657OyU41VL7N3wVNNg" +
       "Z2LMca0E1kFq1JBIsz0v/oyW7Pu/N46sefLFfeWvwsZ/CwkJQMYt+S8RMlpa" +
       "Jwu2xNyHTa6vwPg7ydbqd7e+9PmboUb+tovg4RmeOgRIxMUDT57qS2raj8Kk" +
       "qouUSXg2z99wXLFT6afimN5FKtOKtCNNuxLA32E1rWQ/9ZmCrBdwa8M9Yzm0" +
       "LvsUX49DNss/wsj/ZKBaVsepvh61o5o6z0lSWtPctRn8BKYAKhibVff+84bv" +
       "v94LszLHcLe2CiM9nD2Ucn9JZOrGsgGLIxkcRaB9PNatadZBSulRPqqahpEj" +
       "JPEZMmK2xhaMhJZr2n8B2wDPeBEoAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cb1ihWz+663a/pPg+emdbH767ZfNn56T");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9ud58P0AugfIZs6x+bHTGct/8xbQFfdN8ln053bofu7tQbd3nAHLM+ztXR/i" +
       "XuFF/AWA6J+CeIK8/vJWFZiP8K/tIH7tbVfg3n3npF3Kg7sC6B0HCvRdUTrD" +
       "XXt336oG86ui39zB++b/Iw2+8xyM78qDhwFG/zTGYxXuPXILGPOpB/ogeH5p" +
       "h/GX3n4VvvectPflwTMB9CRQIXWj4/PnzmGp3Zn5sVSevQWpvOdQKr+2k8qv" +
       "3axUbuiJ7VXOSavlwX4APQakcr0bKatjqPAtQH0oj3wCPG/soL7x9kP9yDlp" +
       "+cpl74NggraVmHdk5VDXl0/q+iihgPviLcDNr8BCLfD89g7ub7/9cLlz0vp5" +
       "0AG+JdDs2YtXR5ep5sdYmZu6tRdAD13jOnZ+sfTxq/4ScvA3BukXX71012Ov" +
       "Tv9DcSP56K8Gd7PQXWpomifvsp14v+gCV0ovBHH3wc02t0A3A8Cud8UlgG4D" +
       "Yd7nvelB7kUAPXyt3CAnCE/m/NjOHk7mDKA7iu+T+V4GM91xvgC6ePByMssK" +
       "1A6y5K+Se2hsH7nB7XbdBMx0dO9iHOTX9D35eEGQHMzBj5+0uWJ2ffBG6jsq" +
       "cvIedL66Lf7pc7gSDQ/+6/Oy9I1Xu/yPvln/+YN72JIpZlley10sdOfBlfCi" +
       "0nw1++x1azus62Ln+R/c/82733u48r7/oMPH9n+ib+++9o1nynKD4o5y9k8f" +
       "+8cv/b1Xf6+4p/N/AMUsW26CNQAA");
}
