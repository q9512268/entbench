package org.apache.batik.bridge.svg12;
public class SVGSolidColorElementBridge extends org.apache.batik.bridge.AnimatableGenericSVGBridge implements org.apache.batik.bridge.PaintBridge {
    public SVGSolidColorElementBridge() { super(); }
    public java.lang.String getNamespaceURI() { return org.apache.batik.util.SVG12Constants.
                                                         SVG_NAMESPACE_URI;
    }
    public java.lang.String getLocalName() { return org.apache.batik.util.SVG12Constants.
                                                      SVG_SOLID_COLOR_TAG;
    }
    public java.awt.Paint createPaint(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Element paintElement,
                                      org.w3c.dom.Element paintedElement,
                                      org.apache.batik.gvt.GraphicsNode paintedNode,
                                      float opacity) {
        opacity =
          extractOpacity(
            paintElement,
            opacity,
            ctx);
        return extractColor(
                 paintElement,
                 opacity,
                 ctx);
    }
    protected static float extractOpacity(org.w3c.dom.Element paintElement,
                                          float opacity,
                                          org.apache.batik.bridge.BridgeContext ctx) {
        java.util.Map refs =
          new java.util.HashMap(
          );
        org.apache.batik.css.engine.CSSEngine eng =
          org.apache.batik.bridge.CSSUtilities.
          getCSSEngine(
            paintElement);
        int pidx =
          eng.
          getPropertyIndex(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_SOLID_OPACITY_PROPERTY);
        for (;
             ;
             ) {
            org.apache.batik.css.engine.value.Value opacityVal =
              org.apache.batik.bridge.CSSUtilities.
              getComputedStyle(
                paintElement,
                pidx);
            org.apache.batik.css.engine.StyleMap sm =
              ((org.apache.batik.css.engine.CSSStylableElement)
                 paintElement).
              getComputedStyleMap(
                null);
            if (!sm.
                  isNullCascaded(
                    pidx)) {
                float attr =
                  org.apache.batik.bridge.PaintServer.
                  convertOpacity(
                    opacityVal);
                return opacity *
                  attr;
            }
            java.lang.String uri =
              org.apache.batik.dom.util.XLinkSupport.
              getXLinkHref(
                paintElement);
            if (uri.
                  length(
                    ) ==
                  0) {
                return opacity;
            }
            org.apache.batik.dom.svg.SVGOMDocument doc =
              (org.apache.batik.dom.svg.SVGOMDocument)
                paintElement.
                getOwnerDocument(
                  );
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              doc.
                getURL(
                  ),
              uri);
            if (refs.
                  containsKey(
                    purl)) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintElement,
                  org.apache.batik.bridge.ErrorConstants.
                    ERR_XLINK_HREF_CIRCULAR_DEPENDENCIES,
                  new java.lang.Object[] { uri });
            }
            refs.
              put(
                purl,
                purl);
            paintElement =
              ctx.
                getReferencedElement(
                  paintElement,
                  uri);
        }
    }
    protected static java.awt.Color extractColor(org.w3c.dom.Element paintElement,
                                                 float opacity,
                                                 org.apache.batik.bridge.BridgeContext ctx) {
        java.util.Map refs =
          new java.util.HashMap(
          );
        org.apache.batik.css.engine.CSSEngine eng =
          org.apache.batik.bridge.CSSUtilities.
          getCSSEngine(
            paintElement);
        int pidx =
          eng.
          getPropertyIndex(
            org.apache.batik.util.SVG12CSSConstants.
              CSS_SOLID_COLOR_PROPERTY);
        for (;
             ;
             ) {
            org.apache.batik.css.engine.value.Value colorDef =
              org.apache.batik.bridge.CSSUtilities.
              getComputedStyle(
                paintElement,
                pidx);
            org.apache.batik.css.engine.StyleMap sm =
              ((org.apache.batik.css.engine.CSSStylableElement)
                 paintElement).
              getComputedStyleMap(
                null);
            if (!sm.
                  isNullCascaded(
                    pidx)) {
                if (colorDef.
                      getCssValueType(
                        ) ==
                      org.w3c.dom.css.CSSValue.
                        CSS_PRIMITIVE_VALUE) {
                    return org.apache.batik.bridge.PaintServer.
                      convertColor(
                        colorDef,
                        opacity);
                }
                else {
                    return org.apache.batik.bridge.PaintServer.
                      convertRGBICCColor(
                        paintElement,
                        colorDef.
                          item(
                            0),
                        (org.apache.batik.css.engine.value.svg.ICCColor)
                          colorDef.
                          item(
                            1),
                        opacity,
                        ctx);
                }
            }
            java.lang.String uri =
              org.apache.batik.dom.util.XLinkSupport.
              getXLinkHref(
                paintElement);
            if (uri.
                  length(
                    ) ==
                  0) {
                return new java.awt.Color(
                  0,
                  0,
                  0,
                  opacity);
            }
            org.apache.batik.dom.svg.SVGOMDocument doc =
              (org.apache.batik.dom.svg.SVGOMDocument)
                paintElement.
                getOwnerDocument(
                  );
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              doc.
                getURL(
                  ),
              uri);
            if (refs.
                  containsKey(
                    purl)) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  paintElement,
                  org.apache.batik.bridge.ErrorConstants.
                    ERR_XLINK_HREF_CIRCULAR_DEPENDENCIES,
                  new java.lang.Object[] { uri });
            }
            refs.
              put(
                purl,
                purl);
            paintElement =
              ctx.
                getReferencedElement(
                  paintElement,
                  uri);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hZfpFo/lXoY3Y7Mh52/iV+GkQOft9TeXQ0B8L+VkTbFEMARQYGM+mrSlWGUj" +
       "qrIzDx8/Hd/5zCar/mjOrxZ6oBh+4Zf/fDd06rdvz5GKqrim36KwCaZ45MNj" +
       "TUte3hgQRZ+LXR/VH/vdD9qT264nZWBf6zWSAv5fCUqsL54C/KK8+fCflu26" +
       "O7XvOtB/pc+cfpbfGXj+7b510rGgqHAt4C+ojPMndXoNC4saDEp5FdXEnjoR" +
       "ImtyztKMvtEGj+2+1rsQgefwsxyuFZtaAgFGS4x9CZsvQnAnGR8ERUzwSrZ7" +
       "uN9x1UYRL1jgh6wCXwzcic2wFRCd/2UwYkeXLvoH8i2ElWWfrWbf9Vuo2NQS" +
       "VmAlxpLY7OOkFiwU0SSqDNr7Peaagt4AUzTh2Ap4dtn67Lp+UxSb6lO33A5/" +
       "e8/XFoMnC5ns461DvQCpJ2+TQnEtHbLLVhzKOARtBeySEzzUZ1A9JUvmIIR/" +
       "fr2KgDKSiZlQW8ppKCUm7DPZ5qF90kz70O8tvLtpjgkW3aKz4W+OfrD/XYEM" +
       "lQhFuXj0wBBAlqdKarRs9xn8AvD8Cx+0GXbgG4663fYBa1XuhIX5wSAdJa5E" +
       "8hUIH2r+ePzJSy9YCvhPoD5iNnP80c9CR45b4G0d09cUnJS9c6yjuqUONg+g" +
       "dG2lVhEzev9w7tCPzh46HLT9vZ9jdadRnnOPQO5UsTDf6Jak936j4cdHm8t6" +
       "ISn0k8qMKh/IsP54PjDONzMxzy6453oXJm2Z0eKcBNaDcUW3USI0H8UmzUmN" +
       "ZDDYEJE9Ha+rF8BFJ3nI7Raxqt6AWF2OYx3wRO2Ai5aIVdGux+YWwTQI6Vg3" +
       "NA61CINNrjDFJZKvpF1YgrnPQmWCa5mIQWwOYmMKCZ4oYcwnsTkGhgM3NiC1" +
       "74SIlfmU4OBa77EbZb2b4ZmxFZy5Huvh5wlsTs5hsmIc/3OTnS1hsueweRpS" +
       "g20ycXIvdEC3W5jw2/8LE2Y5WVb8wgAr3aUFl5fWhZv04umGyiWnd38girjc" +
       "pVgtYGUioyieoPUGcIVusIQstK61Cn9dvF7mpKXktQagiXgLRb5nTXqVkyVF" +
       "JoH/Wx9e+h9CHeKnB77i7aU7z0m1SwesrA8vySwnZUCCn6/rzlZtLqZBlyqn" +
       "KcfznAB9WQKT2+V5oPBoIHZ30bV2NzfFe+zF1CHupB10zVi30lHp3Okdgwev" +
       "3PGMdeyWFDo9jVxqAFOtG4BcedtWlJvDq2J7x9X6l6rWOlDfZAnsRtdyj3N3" +
       "AeTr6EjLfGdSsz13NP3wzNbXfjpT8T4kqT0kQKEY2OO5EbauP+Fgm4FzxZ5I" +
       "Ye6Ao4A4LHd2PDF198bEX38jTl12rllRnD4qXXj2/p8fW3oGDtU1/aQcshjL" +
       "jpFq2bx3Sh1m0oQxRupksycLIgIXmSp5iakefZ5iMSvsYpuzLteLlzacrC5M" +
       "toVXXXBCnWTGNi2jxu3UVuP25F2W23FUndF13wS3x1OQfN3Khrgb4LHRyICu" +
       "O7VIxSldgMBhf4IWnWL2BfGJzS/+DYF6VPuvGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
