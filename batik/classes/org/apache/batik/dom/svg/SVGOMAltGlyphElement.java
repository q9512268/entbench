package org.apache.batik.dom.svg;
public class SVGOMAltGlyphElement extends org.apache.batik.dom.svg.SVGURIReferenceTextPositioningElement implements org.w3c.dom.svg.SVGAltGlyphElement {
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
    protected SVGOMAltGlyphElement() { super(
                                         );
    }
    public SVGOMAltGlyphElement(java.lang.String prefix,
                                org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
    }
    public java.lang.String getLocalName() {
        return SVG_ALT_GLYPH_TAG;
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
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMAltGlyphElement(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9N02QQ4qAAA=");
}
