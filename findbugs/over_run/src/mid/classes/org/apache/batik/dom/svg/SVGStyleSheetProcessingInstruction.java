package org.apache.batik.dom.svg;
public class SVGStyleSheetProcessingInstruction extends org.apache.batik.dom.StyleSheetProcessingInstruction implements org.apache.batik.css.engine.CSSStyleSheetNode {
    protected org.apache.batik.css.engine.StyleSheet styleSheet;
    protected SVGStyleSheetProcessingInstruction() { super(); }
    public SVGStyleSheetProcessingInstruction(java.lang.String data, org.apache.batik.dom.AbstractDocument owner,
                                              org.apache.batik.dom.StyleSheetFactory f) {
        super(
          data,
          owner,
          f);
    }
    public java.lang.String getStyleSheetURI() { org.apache.batik.dom.svg.SVGOMDocument svgDoc =
                                                   (org.apache.batik.dom.svg.SVGOMDocument)
                                                     getOwnerDocument(
                                                       );
                                                 org.apache.batik.util.ParsedURL url =
                                                   svgDoc.
                                                   getParsedURL(
                                                     );
                                                 java.lang.String href =
                                                   (java.lang.String)
                                                     getPseudoAttributes(
                                                       ).
                                                     get(
                                                       "href");
                                                 if (url !=
                                                       null) {
                                                     return new org.apache.batik.util.ParsedURL(
                                                       url,
                                                       href).
                                                       toString(
                                                         );
                                                 }
                                                 return href;
    }
    public org.apache.batik.css.engine.StyleSheet getCSSStyleSheet() {
        if (styleSheet ==
              null) {
            org.apache.batik.dom.util.HashTable attrs =
              getPseudoAttributes(
                );
            java.lang.String type =
              (java.lang.String)
                attrs.
                get(
                  "type");
            if ("text/css".
                  equals(
                    type)) {
                java.lang.String title =
                  (java.lang.String)
                    attrs.
                    get(
                      "title");
                java.lang.String media =
                  (java.lang.String)
                    attrs.
                    get(
                      "media");
                java.lang.String href =
                  (java.lang.String)
                    attrs.
                    get(
                      "href");
                java.lang.String alternate =
                  (java.lang.String)
                    attrs.
                    get(
                      "alternate");
                org.apache.batik.dom.svg.SVGOMDocument doc =
                  (org.apache.batik.dom.svg.SVGOMDocument)
                    getOwnerDocument(
                      );
                org.apache.batik.util.ParsedURL durl =
                  doc.
                  getParsedURL(
                    );
                org.apache.batik.util.ParsedURL burl =
                  new org.apache.batik.util.ParsedURL(
                  durl,
                  href);
                org.apache.batik.css.engine.CSSEngine e =
                  doc.
                  getCSSEngine(
                    );
                styleSheet =
                  e.
                    parseStyleSheet(
                      burl,
                      media);
                styleSheet.
                  setAlternate(
                    "yes".
                      equals(
                        alternate));
                styleSheet.
                  setTitle(
                    title);
            }
        }
        return styleSheet;
    }
    public void setData(java.lang.String data)
          throws org.w3c.dom.DOMException {
        super.
          setData(
            data);
        styleSheet =
          null;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGStyleSheetProcessingInstruction(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AKpyLnUqGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "lQ42f+UmAAA=");
}
