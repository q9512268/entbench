package org.apache.batik.bridge;
public class URIResolver {
    protected org.apache.batik.dom.svg.SVGOMDocument document;
    protected java.lang.String documentURI;
    protected org.apache.batik.bridge.DocumentLoader documentLoader;
    public URIResolver(org.w3c.dom.svg.SVGDocument doc, org.apache.batik.bridge.DocumentLoader dl) {
        super(
          );
        document =
          (org.apache.batik.dom.svg.SVGOMDocument)
            doc;
        documentLoader =
          dl;
    }
    public org.w3c.dom.Element getElement(java.lang.String uri, org.w3c.dom.Element ref)
          throws java.net.MalformedURLException,
        java.io.IOException { org.w3c.dom.Node n = getNode(
                                                     uri,
                                                     ref);
                              if (n == null) { return null;
                              }
                              else
                                  if (n.
                                        getNodeType(
                                          ) ==
                                        org.w3c.dom.Node.
                                          DOCUMENT_NODE) {
                                      throw new java.lang.IllegalArgumentException(
                                        );
                                  }
                                  else {
                                      return (org.w3c.dom.Element)
                                               n;
                                  } }
    public org.w3c.dom.Node getNode(java.lang.String uri,
                                    org.w3c.dom.Element ref)
          throws java.net.MalformedURLException,
        java.io.IOException,
        java.lang.SecurityException { java.lang.String baseURI =
                                        getRefererBaseURI(
                                          ref);
                                      if (baseURI ==
                                            null &&
                                            uri.
                                            charAt(
                                              0) ==
                                            '#') {
                                          return getNodeByFragment(
                                                   uri.
                                                     substring(
                                                       1),
                                                   ref);
                                      }
                                      org.apache.batik.util.ParsedURL purl =
                                        new org.apache.batik.util.ParsedURL(
                                        baseURI,
                                        uri);
                                      if (documentURI ==
                                            null)
                                          documentURI =
                                            document.
                                              getURL(
                                                );
                                      java.lang.String frag =
                                        purl.
                                        getRef(
                                          );
                                      if (frag !=
                                            null &&
                                            documentURI !=
                                            null) {
                                          org.apache.batik.util.ParsedURL pDocURL =
                                            new org.apache.batik.util.ParsedURL(
                                            documentURI);
                                          if (pDocURL.
                                                sameFile(
                                                  purl)) {
                                              return document.
                                                getElementById(
                                                  frag);
                                          }
                                      }
                                      org.apache.batik.util.ParsedURL pDocURL =
                                        null;
                                      if (documentURI !=
                                            null) {
                                          pDocURL =
                                            new org.apache.batik.util.ParsedURL(
                                              documentURI);
                                      }
                                      org.apache.batik.bridge.UserAgent userAgent =
                                        documentLoader.
                                        getUserAgent(
                                          );
                                      userAgent.
                                        checkLoadExternalResource(
                                          purl,
                                          pDocURL);
                                      java.lang.String purlStr =
                                        purl.
                                        toString(
                                          );
                                      if (frag !=
                                            null) {
                                          purlStr =
                                            purlStr.
                                              substring(
                                                0,
                                                purlStr.
                                                  length(
                                                    ) -
                                                  (frag.
                                                     length(
                                                       ) +
                                                     1));
                                      }
                                      org.w3c.dom.Document doc =
                                        documentLoader.
                                        loadDocument(
                                          purlStr);
                                      if (frag !=
                                            null)
                                          return doc.
                                            getElementById(
                                              frag);
                                      return doc;
    }
    protected java.lang.String getRefererBaseURI(org.w3c.dom.Element ref) {
        return ((org.apache.batik.dom.AbstractNode)
                  ref).
          getBaseURI(
            );
    }
    protected org.w3c.dom.Node getNodeByFragment(java.lang.String frag,
                                                 org.w3c.dom.Element ref) {
        return ref.
          getOwnerDocument(
            ).
          getElementById(
            frag);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8/lv8U/WvPNf2uZlYisbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rGw/u/hdf+bO33/NR575enb4/7/GKxKfnSYAAA==");
}
