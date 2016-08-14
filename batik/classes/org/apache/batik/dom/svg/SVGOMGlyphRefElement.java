package org.apache.batik.dom.svg;
public class SVGOMGlyphRefElement extends org.apache.batik.dom.svg.SVGStylableElement implements org.w3c.dom.svg.SVGGlyphRefElement {
    protected static final org.apache.batik.dom.svg.AttributeInitializer attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      4);
             attributeInitializer.addAttribute(org.apache.batik.dom.util.XMLSupport.
                                                 XMLNS_NAMESPACE_URI,
                                               null,
                                               "xmlns:xlink",
                                               org.apache.batik.dom.util.XLinkSupport.
                                                 XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(org.apache.batik.dom.util.XLinkSupport.
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
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      href;
    protected SVGOMGlyphRefElement() { super(
                                         );
    }
    public SVGOMGlyphRefElement(java.lang.String prefix,
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
    }
    public java.lang.String getLocalName() {
        return SVG_GLYPH_REF_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedString getHref() {
        return href;
    }
    public java.lang.String getGlyphRef() {
        return getAttributeNS(
                 null,
                 SVG_GLYPH_REF_ATTRIBUTE);
    }
    public void setGlyphRef(java.lang.String glyphRef)
          throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_GLYPH_REF_ATTRIBUTE,
          glyphRef);
    }
    public java.lang.String getFormat() {
        return getAttributeNS(
                 null,
                 SVG_FORMAT_ATTRIBUTE);
    }
    public void setFormat(java.lang.String format)
          throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_FORMAT_ATTRIBUTE,
          format);
    }
    public float getX() { return java.lang.Float.
                            parseFloat(
                              getAttributeNS(
                                null,
                                SVG_X_ATTRIBUTE));
    }
    public void setX(float x) throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_X_ATTRIBUTE,
          java.lang.String.
            valueOf(
              x));
    }
    public float getY() { return java.lang.Float.
                            parseFloat(
                              getAttributeNS(
                                null,
                                SVG_Y_ATTRIBUTE));
    }
    public void setY(float y) throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_Y_ATTRIBUTE,
          java.lang.String.
            valueOf(
              y));
    }
    public float getDx() { return java.lang.Float.
                             parseFloat(
                               getAttributeNS(
                                 null,
                                 SVG_DX_ATTRIBUTE));
    }
    public void setDx(float dx) throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_DX_ATTRIBUTE,
          java.lang.String.
            valueOf(
              dx));
    }
    public float getDy() { return java.lang.Float.
                             parseFloat(
                               getAttributeNS(
                                 null,
                                 SVG_DY_ATTRIBUTE));
    }
    public void setDy(float dy) throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_DY_ATTRIBUTE,
          java.lang.String.
            valueOf(
              dy));
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMGlyphRefElement(
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
       "nq6jQXc2D8JZVKn1B4Y7rQ82+KTKi2MKhr31WEPFviRUu75pptGWDOiaPs1Q" +
       "h7J67YQdcopBqV4g1O3lxB2pFV6aMibW0CSFkAKOVf1eWKMzakFzxFaTcNkI" +
       "NzOmI1ft8gSexfW2Oho3pgxJZ+myLrIYRm9m601mamasA9diTmV1u5pICjSG" +
       "ZZiK52N0bgdkYIv0lmGMrQAP4szFmf6C2uAaPnCafEbD2tbDZFTqWhWsLg9m" +
       "E5sRt/NgYuAwGL/C3FoZ9ZmITh2Zz/CNx1crScuYDmGjA9NIP5wwSGO9rLlE" +
       "g9Q7/aaXjmop50ZI36PMal1bW+PlQNY9CErr04UC0w7NJZzfnQq+BPMYtdlG" +
       "TqQFuJHUltnKSSd6ba1XoLFnuFlVGs81RHBcGBXdtEXgIdL3h6IMV43GZr1e" +
       "exOb76H9dtq1AnGV0B6yxm3X7mBTdqXPGGwrKgLbJoEN0cQWSd1VZ94dkiyP" +
       "kLgorMqd+YJvA8LKtFaWDHpIr6e2LTO1xnIQQd5E2mrNRbjuLIhN2yVwAo2j" +
       "qhs1HEYX6h0lSBK0Oq5b0WwUZnK7PPCMSbScYCQ9ksRwS2NJHZ9aelxP6lCi" +
       "bzs2sWjNycgx4jE01FrucDTFjcF6MuHJhtr1skbmrCq1dUxmMsyO/JCV0ajv" +
       "MssxtkjGkxkTYQLSqlMWpGrzbUWHUhIfEALDCGaLCdpjejZkkGWTSlq9OtXq" +
       "dOR1s8anARERCbeV/GmTGda9Rp/t9pbVjYm3yXAahhkBqy0Cc91VMoyc6WRF" +
       "93pyWi93xOrGmuHWDO5UCVJfrFvL+kKpV3rTMoPRw8WYq2f4sI50Y2XqCV7q" +
       "CY5cVa1oWydrKBFPloGTpEkszuq9ZC1UJYKvQ1R7LHlo0huJC2oudhx2GmWN" +
       "wKjZgiH5WLXajM1Bj6YWtRrcg2fNCPe8AEvS5gxZwGu/mgltVRYDck4aQ95f" +
       "s7bBQd2Ot2knRtiHoE0qrxPPYsNVf6GxCuHwkNrwsk1zC62hzO9uZmlHHFrb" +
       "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" +
       "/HXuy3slvHzjOf4PZ+R9K4/+HZg3Acf9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/FZQfIrh379ehn8QhE/vwX36+8Twf7t6gX9TFPjvefRtADM6CfMEh//1OmAW" +
       "i6AHQPiZPcyfufEc/unV8w6Krv43mEsBh4srTbK36I4vxcdg/+R6Oc2d0mf3" +
       "YD97ozk9OFeguusanB5cyKPbAGzA6eJyOg9uvxF0fmmP8Es3nM6DHzgj7y15" +
       "dP+OTqHQxzGuB24Ec1/e4/ry94m5t1+LuXfm0RM75oRTzD15vcw9CMKv7hH+" +
       "6o1nrnpGHpxHT4PxBpjrbU5R957rpS6/fPaVPbCvfJ+oe/Za1P1IHrUBxGgP" +
       "8SR3nRvB3W/sIf7GjeeOOCMvvxtx0Ntztz3FHXYjuHttD+y17xN33LW4m+fR" +
       "ZM/d9hR317xodQbEt+WJPwTC7+4h/u4bhXjNzeeBdEaekkc/GpceAtxd7U6Z" +
       "cAz1/dcB9c154iMg/MEe6h/ceKjuGXn5PxAODLAn8bR05Ku7/WR+HfTkIvYo" +
       "o4BrvqGbm3Hp/ivdyc9vFz/8ur//7P6yonzhlQu3PfQK96+Ka+lHfyu5nSrd" +
       "pieOc/JC44nn8wHYUpmFMm7fXW8MCoSb/Yr8Stft4tJNIM6FPkh3pT8E5L1S" +
       "aVASxCdLfnivpJMlwVgovk+W+2hcuuO4XFw6v3s4WeQvg9ZBkfzxx4JDBspn" +
       "3RFk462T3+s+PNrabT4ePmljxcrsvmtxdVTl5MX3/ESr+AfX4elTsvsP13PK" +
       "F18hRx/6TvNndxfvFUfKsryV26jSrbv/ABSN5idYT161tcO2zg/e9d27f/72" +
       "tx+ett29E/jY3k/I9viVr7hjbhAXl9KzLz/0i+/9e6/8XnFB8P8BqRm8Olo3" +
       "AAA=");
}
