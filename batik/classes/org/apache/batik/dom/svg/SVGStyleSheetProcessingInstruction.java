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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5o3/AvzqKGYFHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "CScAAA==");
}
