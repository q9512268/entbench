package org.apache.batik.apps.svgbrowser;
public class XMLInputHandler implements org.apache.batik.apps.svgbrowser.SquiggleInputHandler {
    public static final java.lang.String[] XVG_MIME_TYPES = { "image/xml+xsl+svg" };
    public static final java.lang.String[] XVG_FILE_EXTENSIONS = { ".xml",
    ".xsl" };
    public static final java.lang.String ERROR_NO_XML_STYLESHEET_PROCESSING_INSTRUCTION =
      ("XMLInputHandler.error.no.xml.stylesheet.processing.instructi" +
       "on");
    public static final java.lang.String ERROR_TRANSFORM_OUTPUT_NOT_SVG =
      "XMLInputHandler.error.transform.output.not.svg";
    public static final java.lang.String ERROR_TRANSFORM_PRODUCED_NO_CONTENT =
      "XMLInputHandler.error.transform.produced.no.content";
    public static final java.lang.String ERROR_TRANSFORM_OUTPUT_WRONG_NS =
      "XMLInputHandler.error.transform.output.wrong.ns";
    public static final java.lang.String ERROR_RESULT_GENERATED_EXCEPTION =
      "XMLInputHandler.error.result.generated.exception";
    public static final java.lang.String XSL_PROCESSING_INSTRUCTION_TYPE =
      "text/xsl";
    public static final java.lang.String PSEUDO_ATTRIBUTE_TYPE = "type";
    public static final java.lang.String PSEUDO_ATTRIBUTE_HREF = "href";
    public java.lang.String[] getHandledMimeTypes() { return XVG_MIME_TYPES;
    }
    public java.lang.String[] getHandledExtensions() { return XVG_FILE_EXTENSIONS;
    }
    public java.lang.String getDescription() { return "";
    }
    public boolean accept(java.io.File f) { return f.isFile(
                                                       ) &&
                                              accept(
                                                f.
                                                  getPath(
                                                    )); }
    public boolean accept(org.apache.batik.util.ParsedURL purl) {
        if (purl ==
              null) {
            return false;
        }
        java.lang.String path =
          purl.
          getPath(
            );
        return accept(
                 path);
    }
    public boolean accept(java.lang.String path) { if (path ==
                                                         null) {
                                                       return false;
                                                   }
                                                   for (int i =
                                                          0;
                                                        i <
                                                          XVG_FILE_EXTENSIONS.
                                                            length;
                                                        i++) {
                                                       if (path.
                                                             endsWith(
                                                               XVG_FILE_EXTENSIONS[i])) {
                                                           return true;
                                                       }
                                                   }
                                                   return false;
    }
    public void handle(org.apache.batik.util.ParsedURL purl,
                       org.apache.batik.apps.svgbrowser.JSVGViewerFrame svgViewerFrame)
          throws java.lang.Exception { java.lang.String uri =
                                         purl.
                                         toString(
                                           );
                                       javax.xml.transform.TransformerFactory tFactory =
                                         javax.xml.transform.TransformerFactory.
                                         newInstance(
                                           );
                                       javax.xml.parsers.DocumentBuilderFactory dbf =
                                         javax.xml.parsers.DocumentBuilderFactory.
                                         newInstance(
                                           );
                                       dbf.
                                         setValidating(
                                           false);
                                       dbf.
                                         setNamespaceAware(
                                           true);
                                       javax.xml.parsers.DocumentBuilder db =
                                         dbf.
                                         newDocumentBuilder(
                                           );
                                       org.w3c.dom.Document inDoc =
                                         db.
                                         parse(
                                           uri);
                                       java.lang.String xslStyleSheetURI =
                                         extractXSLProcessingInstruction(
                                           inDoc);
                                       if (xslStyleSheetURI ==
                                             null) {
                                           xslStyleSheetURI =
                                             uri;
                                       }
                                       org.apache.batik.util.ParsedURL parsedXSLStyleSheetURI =
                                         new org.apache.batik.util.ParsedURL(
                                         uri,
                                         xslStyleSheetURI);
                                       javax.xml.transform.Transformer transformer =
                                         tFactory.
                                         newTransformer(
                                           new javax.xml.transform.stream.StreamSource(
                                             parsedXSLStyleSheetURI.
                                               toString(
                                                 )));
                                       transformer.
                                         setURIResolver(
                                           new org.apache.batik.apps.svgbrowser.XMLInputHandler.DocumentURIResolver(
                                             parsedXSLStyleSheetURI.
                                               toString(
                                                 )));
                                       java.io.StringWriter sw =
                                         new java.io.StringWriter(
                                         );
                                       javax.xml.transform.stream.StreamResult result =
                                         new javax.xml.transform.stream.StreamResult(
                                         sw);
                                       transformer.
                                         transform(
                                           new javax.xml.transform.dom.DOMSource(
                                             inDoc),
                                           result);
                                       sw.
                                         flush(
                                           );
                                       sw.
                                         close(
                                           );
                                       java.lang.String parser =
                                         org.apache.batik.util.XMLResourceDescriptor.
                                         getXMLParserClassName(
                                           );
                                       org.apache.batik.dom.svg.SAXSVGDocumentFactory f =
                                         new org.apache.batik.dom.svg.SAXSVGDocumentFactory(
                                         parser);
                                       org.w3c.dom.svg.SVGDocument outDoc =
                                         null;
                                       try {
                                           outDoc =
                                             f.
                                               createSVGDocument(
                                                 uri,
                                                 new java.io.StringReader(
                                                   sw.
                                                     toString(
                                                       )));
                                       }
                                       catch (java.lang.Exception e) {
                                           java.lang.System.
                                             err.
                                             println(
                                               "======================================");
                                           java.lang.System.
                                             err.
                                             println(
                                               sw.
                                                 toString(
                                                   ));
                                           java.lang.System.
                                             err.
                                             println(
                                               "======================================");
                                           throw new java.lang.IllegalArgumentException(
                                             org.apache.batik.apps.svgbrowser.Resources.
                                               getString(
                                                 ERROR_RESULT_GENERATED_EXCEPTION));
                                       }
                                       svgViewerFrame.
                                         getJSVGCanvas(
                                           ).
                                         setSVGDocument(
                                           outDoc);
                                       svgViewerFrame.
                                         setSVGDocument(
                                           outDoc,
                                           uri,
                                           outDoc.
                                             getTitle(
                                               ));
    }
    protected void checkAndPatch(org.w3c.dom.Document doc) {
        org.w3c.dom.Element root =
          doc.
          getDocumentElement(
            );
        org.w3c.dom.Node realRoot =
          root.
          getFirstChild(
            );
        java.lang.String svgNS =
          org.apache.batik.dom.svg.SVGDOMImplementation.
            SVG_NAMESPACE_URI;
        if (realRoot ==
              null) {
            throw new java.lang.IllegalArgumentException(
              org.apache.batik.apps.svgbrowser.Resources.
                getString(
                  ERROR_TRANSFORM_PRODUCED_NO_CONTENT));
        }
        if (realRoot.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                ELEMENT_NODE ||
              !org.apache.batik.util.SVGConstants.
                 SVG_SVG_TAG.
              equals(
                realRoot.
                  getLocalName(
                    ))) {
            throw new java.lang.IllegalArgumentException(
              org.apache.batik.apps.svgbrowser.Resources.
                getString(
                  ERROR_TRANSFORM_OUTPUT_NOT_SVG));
        }
        if (!svgNS.
              equals(
                realRoot.
                  getNamespaceURI(
                    ))) {
            throw new java.lang.IllegalArgumentException(
              org.apache.batik.apps.svgbrowser.Resources.
                getString(
                  ERROR_TRANSFORM_OUTPUT_WRONG_NS));
        }
        org.w3c.dom.Node child =
          realRoot.
          getFirstChild(
            );
        while (child !=
                 null) {
            root.
              appendChild(
                child);
            child =
              realRoot.
                getFirstChild(
                  );
        }
        org.w3c.dom.NamedNodeMap attrs =
          realRoot.
          getAttributes(
            );
        int n =
          attrs.
          getLength(
            );
        for (int i =
               0;
             i <
               n;
             i++) {
            root.
              setAttributeNode(
                (org.w3c.dom.Attr)
                  attrs.
                  item(
                    i));
        }
        root.
          removeChild(
            realRoot);
    }
    protected java.lang.String extractXSLProcessingInstruction(org.w3c.dom.Document doc) {
        org.w3c.dom.Node child =
          doc.
          getFirstChild(
            );
        while (child !=
                 null) {
            if (child.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    PROCESSING_INSTRUCTION_NODE) {
                org.w3c.dom.ProcessingInstruction pi =
                  (org.w3c.dom.ProcessingInstruction)
                    child;
                org.apache.batik.dom.util.HashTable table =
                  new org.apache.batik.dom.util.HashTable(
                  );
                org.apache.batik.dom.util.DOMUtilities.
                  parseStyleSheetPIData(
                    pi.
                      getData(
                        ),
                    table);
                java.lang.Object type =
                  table.
                  get(
                    PSEUDO_ATTRIBUTE_TYPE);
                if (XSL_PROCESSING_INSTRUCTION_TYPE.
                      equals(
                        type)) {
                    java.lang.Object href =
                      table.
                      get(
                        PSEUDO_ATTRIBUTE_HREF);
                    if (href !=
                          null) {
                        return href.
                          toString(
                            );
                    }
                    else {
                        return null;
                    }
                }
            }
            child =
              child.
                getNextSibling(
                  );
        }
        return null;
    }
    public class DocumentURIResolver implements javax.xml.transform.URIResolver {
        java.lang.String documentURI;
        public DocumentURIResolver(java.lang.String documentURI) {
            super(
              );
            this.
              documentURI =
              documentURI;
        }
        public javax.xml.transform.Source resolve(java.lang.String href,
                                                  java.lang.String base) {
            if (base ==
                  null ||
                  "".
                  equals(
                    base)) {
                base =
                  documentURI;
            }
            org.apache.batik.util.ParsedURL purl =
              new org.apache.batik.util.ParsedURL(
              base,
              href);
            return new javax.xml.transform.stream.StreamSource(
              purl.
                toString(
                  ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Ir2m+T+ASGD91RUAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ovzmf/OHr/n9N//289/K7+z+F0muSMn1IAAA");
    }
    public XMLInputHandler() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Pkdw0qThXgRleFsbtazmmgPhymZe9KHq");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
