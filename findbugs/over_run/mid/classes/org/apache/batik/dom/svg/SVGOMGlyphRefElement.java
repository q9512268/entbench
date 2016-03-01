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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+VnQCk3DpRzah/9c/A/fkR0sVioAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3/Lo2wCmfxLmCQ7/y3XALBZBD4LwU3uY");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("P3XjOfzTq+cdFE39LzCXAg7nV5pkb9HAajk4Bvsn18tp7pQ+vwf7+RvN6cGF" +
       "AtXd1+D04GIe3Q5gA07np+k8uONG0Plze4Q/d8PpPPiBc/LelkcP7OhcFPo4" +
       "xvXgjWDuK3tcX/k+MffOazH37jx6csfc4gxzT10vcw+B8Ct7hL9y45lDzslD" +
       "8+gZMN4Ac63kDHXvu17q8ktjX90D++r3ibrnrkXdj+RRA0D09xBPcte8Edz9" +
       "+h7ir9947uhz8vI7DQetPXfpGe7aN4K71/fAXv8+cTe5FnezPBL23KVnuLvm" +
       "BalzIL4jT/whEH5nD/F33izEa24+D8Rz8uQ8+tGg9DDg7mp3wRbHUD94HVDf" +
       "mic+CsIf7KH+wY2Hap2Tl/+r4EAHexJbjTlH2e0n82ucJxexRxkFXONN3bgM" +
       "Sg9c6S59fiv4kTf8pWf3NxT5S69evP3hVyf/srhOfvRXkTuY0u1aaJonLyKe" +
       "eL7VBVsqo1DGHbtriW6BMNmvyK90TS4o3QTivNMH8U76I6C/V5IGkiA+KfnR" +
       "vZJOSoKxUHyflPt4ULrzWC4o3bp7OCnyF0HtQCR//DH3kAHovLt9oyA18/vY" +
       "h0dbu83HIydtrFiZ3X8tro6KnLywnp9oFf/KOjx9Cnf/y3pe/vKrPe4j36n9" +
       "9O7CvGyKWZbXcjtTum13d7+oND/BeuqqtR3WdWv3Pd+952fveOfhads9uw4f" +
       "2/uJvj1x5avpbcsNisvk2Vce/oX3/91Xf7e42Pd/AZwxa30uNwAA");
}
