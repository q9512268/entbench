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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "j/bput0zBCeF5XVdJPlVHL76X0j0IH/UGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bgKgnlFn9TNH8eT74HMCPP+TPdlyZw3b7fZ2Ym/Pf/Bg0/e89ASI1lOl3dpu" +
       "MRv/5pzLQ3l5PitetzVTVv1RENZhnrGCETPTUax84ici4GKWen6fuwgyWGCT" +
       "8wurlrN5NcjZc3fKtN/dpn1bQMvKUs5i6xKVq7rPj22p8p3r1kNmtAsyyPf+" +
       "4zNf/qVHvg5sSkGnVtl6A1MembEfZ0n1z73wvvtuevYb781RCkAU9/7WuScy" +
       "rvS1NM6KVla091W9J1NVyNMAWgkjJgcWXcu1vaYrc4FpA/xd7WWM8JO3f335" +
       "gW9+bJsNHvfbY8T6U8/+wvd3n35250gO/shlafDRMds8PBf6lr0VDqCHrjVL" +
       "PqL9T5948tO/9eR7tlLdfmlG2QIvTB/7q//+8u5z3/jiFVKS6yz3FRg2uuUz" +
       "HTTsYvsfRpwopWSEpONCXJ8GeDKBsVa/QjYJcu0OQ2tOGMF4SbEkxijlyCIb" +
       "gjKPpbjWL2uGZssTXYlXktwjRL4v+oJptTTCrxOc6c8jHCOR4aDgGf5c6U8s" +
       "wfTxgY3qSsT6nIcVlnVCL7o2Ut14JdnRLLm2nrjW2PNqbm3FzWZqHd6wscQV" +
       "KH9Zamq9eLQRqaScqnJpgs7jeqp4RlhSEL6YrsnSdFEsUQ22QweNUi1o8oOu" +
       "0h0yG4RdD33GLq2XKWWb/eVSWStOzxUYOJSFQo+1mTYju6lA2yufoJYLu4bI" +
       "ktyy7JnmCZNJK64aA0otjdRin600F0E0sJJwYfhed9lVhN4UxgbaSOsaysxH" +
       "41K7UJzI8SYNBDkqb4atquKuVm6vW17GvbTlBjQVw10yHs0kiyOL7qqVrGEu" +
       "4exxNJ0souJ0ZMm2CSPcouCo6maodpmwavqKtXYVDF2PkD45HlI9MirLNB/Q" +
       "tjHrisW5aLU25VaHE1rSiF2oxLw1XIyKmm5hseUwzbFU05QWG23m7X7XanfN" +
       "oaeKjEYGfMAUbcrmyWYgqYiFhLhdktr0ACmzyLCu8Y2l3OdqtlOdzUWvQ5D9" +
       "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" +
       "8quS/wV2ei7+1yUAAA==");
}
