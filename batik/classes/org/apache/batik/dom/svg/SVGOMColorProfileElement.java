package org.apache.batik.dom.svg;
public class SVGOMColorProfileElement extends org.apache.batik.dom.svg.SVGOMURIReferenceElement implements org.w3c.dom.svg.SVGColorProfileElement {
    protected static final org.apache.batik.dom.svg.AttributeInitializer attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      5);
             attributeInitializer.addAttribute(null, null, SVG_RENDERING_INTENT_ATTRIBUTE,
                                               SVG_AUTO_VALUE);
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
                                    "other");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected SVGOMColorProfileElement() {
        super(
          );
    }
    public SVGOMColorProfileElement(java.lang.String prefix,
                                    org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
    }
    public java.lang.String getLocalName() {
        return SVG_COLOR_PROFILE_TAG;
    }
    public java.lang.String getLocal() { return getAttributeNS(
                                                  null,
                                                  SVG_LOCAL_ATTRIBUTE);
    }
    public void setLocal(java.lang.String local)
          throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_LOCAL_ATTRIBUTE,
          local);
    }
    public java.lang.String getName() { return getAttributeNS(
                                                 null,
                                                 SVG_NAME_ATTRIBUTE);
    }
    public void setName(java.lang.String name)
          throws org.w3c.dom.DOMException {
        setAttributeNS(
          null,
          SVG_NAME_ATTRIBUTE,
          name);
    }
    public short getRenderingIntent() { org.w3c.dom.Attr attr =
                                          getAttributeNodeNS(
                                            null,
                                            SVG_RENDERING_INTENT_ATTRIBUTE);
                                        if (attr ==
                                              null) {
                                            return RENDERING_INTENT_AUTO;
                                        }
                                        java.lang.String val =
                                          attr.
                                          getValue(
                                            );
                                        switch (val.
                                                  length(
                                                    )) {
                                            case 4:
                                                if (val.
                                                      equals(
                                                        SVG_AUTO_VALUE)) {
                                                    return RENDERING_INTENT_AUTO;
                                                }
                                                break;
                                            case 10:
                                                if (val.
                                                      equals(
                                                        SVG_PERCEPTUAL_VALUE)) {
                                                    return RENDERING_INTENT_PERCEPTUAL;
                                                }
                                                if (val.
                                                      equals(
                                                        SVG_SATURATE_VALUE)) {
                                                    return RENDERING_INTENT_SATURATION;
                                                }
                                                break;
                                            case 21:
                                                if (val.
                                                      equals(
                                                        SVG_ABSOLUTE_COLORIMETRIC_VALUE)) {
                                                    return RENDERING_INTENT_ABSOLUTE_COLORIMETRIC;
                                                }
                                                if (val.
                                                      equals(
                                                        SVG_RELATIVE_COLORIMETRIC_VALUE)) {
                                                    return RENDERING_INTENT_RELATIVE_COLORIMETRIC;
                                                }
                                        }
                                        return RENDERING_INTENT_UNKNOWN;
    }
    public void setRenderingIntent(short renderingIntent)
          throws org.w3c.dom.DOMException {
        switch (renderingIntent) {
            case RENDERING_INTENT_AUTO:
                setAttributeNS(
                  null,
                  SVG_RENDERING_INTENT_ATTRIBUTE,
                  SVG_AUTO_VALUE);
                break;
            case RENDERING_INTENT_PERCEPTUAL:
                setAttributeNS(
                  null,
                  SVG_RENDERING_INTENT_ATTRIBUTE,
                  SVG_PERCEPTUAL_VALUE);
                break;
            case RENDERING_INTENT_RELATIVE_COLORIMETRIC:
                setAttributeNS(
                  null,
                  SVG_RENDERING_INTENT_ATTRIBUTE,
                  SVG_RELATIVE_COLORIMETRIC_VALUE);
                break;
            case RENDERING_INTENT_SATURATION:
                setAttributeNS(
                  null,
                  SVG_RENDERING_INTENT_ATTRIBUTE,
                  SVG_SATURATE_VALUE);
                break;
            case RENDERING_INTENT_ABSOLUTE_COLORIMETRIC:
                setAttributeNS(
                  null,
                  SVG_RENDERING_INTENT_ATTRIBUTE,
                  SVG_ABSOLUTE_COLORIMETRIC_VALUE);
        }
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMColorProfileElement(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Vg7ZIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Lo+K/waCuNG+riwAAA==");
}
