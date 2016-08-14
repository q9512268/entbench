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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Py+I9c+LJj6e/i9PzvpmaBYAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "5q8Hmz981e+/8bee/WZe9/tf9rU2eB0hAAA=");
    }
    public XMLInputHandler() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aC5AcRRnu3ctdLpfcI5cnIS+SI5oAu+GtdeFx2dtLNuzd" +
       "rrt753EJbOZm+24nmZ0ZZnrvNsHIQy0iaApjCGhBsMpggOIlJeUDwVgojxKt" +
       "ElBEClBBRYEStAQVEf+/Z2ZndnZnr+7KeFXTNzvdf/f/f//f/6Nn7nmLNBo6" +
       "WUkVFmJ7NGqEogpLCrpBcxFZMIwMPMuKNzcIf7v89YGPB0nTCGnLC0a/KBi0" +
       "T6JyzhghKyTFYIIiUmOA0hxSJHVqUH1CYJKqjJBFkhEraLIkSqxfzVEcMCTo" +
       "cTJfYEyXRouMxqwJGFkRB07CnJNwj7e7O07miaq2xxm+1DU84urBkQVnLYOR" +
       "jvguYUIIF5kkh+OSwbpLOjlNU+U947LKQrTEQrvkcy0ItsXPrYJgzQPt775/" +
       "Y76DQ7BAUBSVcfGMFDVUeYLm4qTdeRqVacG4gnyaNMTJXNdgRrri9qJhWDQM" +
       "i9rSOqOA+1aqFAsRlYvD7JmaNBEZYuSUykk0QRcK1jRJzjPM0Mws2TkxSLu6" +
       "LK0pZZWIN50WPnTz5R0PNpD2EdIuKWlkRwQmGCwyAoDSwijVjZ5cjuZGyHwF" +
       "lJ2muiTI0l5L052GNK4IrAjqt2HBh0WN6nxNByvQI8imF0Wm6mXxxrhBWb8a" +
       "x2RhHGRd7MhqStiHz0HAFgkY08cEsDuLZNZuSckxsspLUZax6xIYAKSzC5Tl" +
       "1fJSsxQBHpBO00RkQRkPp8H0lHEY2qiCAeqMLPOdFLHWBHG3ME6zaJGecUmz" +
       "C0bN4UAgCSOLvMP4TKClZR4tufTz1sCmA1cqW5UgCQDPOSrKyP9cIFrpIUrR" +
       "MapT2Acm4bwN8cPC4kf2BwmBwYs8g80x3/7UOxefvvL4k+aYk2uMSYzuoiLL" +
       "ikdH236+PLL+4w3IRrOmGhIqv0JyvsuSVk93SQMPs7g8I3aG7M7jqccvvfpu" +
       "+kaQtMRIk6jKxQLY0XxRLWiSTPUtVKG6wGguRuZQJRfh/TEyG+7jkkLNp4mx" +
       "MYOyGJkl80dNKv8NEI3BFAhRC9xLyphq32sCy/P7kkYImQ0X2QTXRcT84/8Z" +
       "EcN5tUDDgigokqKGk7qK8hth8DijgG0+PApWvztsqEUdTDCs6uNhAewgT60O" +
       "QdOMsDExPqqrk+ANw8P98ZiiFdlWQcmBaCE0Nu3/s0wJpV0wGQiAIpZ73YAM" +
       "O2irKueonhUPFTdH37kv+xPTxHBbWDgxshFWDpkrh/jKIVw55Kwc8qxMAgG+" +
       "4ELkwNQ66Gw37H5wv/PWpy/btnP/mgYwN21yFgCOQ9dUhKGI4yJsv54V7+9s" +
       "3XvKy2c+FiSz4qRTEFlRkDGq9Ojj4K/E3daWnjcKAcqJE6tdcQIDnK6KNAdu" +
       "yi9eWLM0qxNUx+eMLHTNYEcx3K9h/xhSk39y/JbJa4au2hgkwcrQgEs2gldD" +
       "8iQ69LLj7vK6hFrztl/3+rv3H96nOs6hItbYIbKKEmVY4zUJLzxZccNq4aHs" +
       "I/u6OOxzwHkzATYb+MWV3jUqfE+37cdRlmYQeEzVC4KMXTbGLSwP9uM84bY6" +
       "H5tFptmiCXkY5CHggrR2269+9qezOZJ2tGh3hfk0Zd0uD4WTdXJfNN+xyIxO" +
       "KYx76Zbkl29667rt3BxhxNpaC3ZhGwHPBNoBBD/35BUvvPLy0eeCjgkzCNHF" +
       "Uch0SlyWhR/CXwCu/+CFXgUfmN6lM2K5uNVlH6fhyusc3sDbyeAK0Di6BhUw" +
       "Q2lMEkZlivvn3+2nnvnQmwc6THXL8MS2ltOnnsB5ftJmcvVPLn9vJZ8mIGK0" +
       "dfBzhpkufIEzc4+uC3uQj9I1z6z4yhPCbRAMwAEb0l7KfSrheBCuwHM5Fht5" +
       "e46n73xsTjXcNl65jVxZUVa88bm3W4fefvQdzm1lWuXWe7+gdZtWZGoBFruA" +
       "WE2Fj8fexRq2S0rAwxKvo9oqGHmY7JzjAzs65OPvw7IjsKwIbthI6OAvSxWm" +
       "ZI1unP3rHz62eOfPG0iwj7TIqpDrE/iGI3PA0qmRB1db0i662ORjshmaDo4H" +
       "qUKo6gFqYVVt/UYLGuMa2fudJd/adOzIy9wsNXOOkzl9C3r/Cg/LM3hnk9/9" +
       "7Pm/OPalw5NmDrDe37N56Jb+KyGPXvu7f1Tphfu0GvmJh34kfM+tyyIXvsHp" +
       "HeeC1F2l6ogFDtqhPevuwt+Da5p+HCSzR0iHaGXMQ4JcxH09AlmiYafRkFVX" +
       "9FdmfGZ60112nsu9js21rNetOZES7nE03rd6bHApqnA5XD2WDV7stcEA4Tfb" +
       "OMk63q7H5nSuvga8PQNcjMHzcgYsSIogl8oLcBtZYk9cYwFG2oaHtmT7Y/3R" +
       "bObSZDRdWflhWEsXRw3Gd7eZFu6Y+/gPjK//4UHTJNbUGOzJNe881iy+WHj8" +
       "NZPgpBoE5rhFd4a/OPT8rqe5927GaJ2xcXPFYojqrqjQoeE2PdXfLl2MH/nG" +
       "2p9ddWTtb/mmbZYM0B5MViPBdtG8fc8rbzzTuuI+HuRmIU8WP5WVSXXhUVFP" +
       "cFbbrZ23FCpPvmHRxkJmVVHe1gEr8cHfvZqt/h211R/k6scmwVcIgSXIVBln" +
       "eaPuXk3qUgHi34Sln/C+zld23/r6vaZ+vBvTM5juP3T9h6EDh8woY1ZXa6sK" +
       "HDeNWWGZ2uJcosZOqbcKp+j74/37Hr5z33UmV52VtUIUSuF7f/nB06FbfvNU" +
       "jcS0AdSBP4Y1x2EGTchsFSxwVBCRVYViELT7zPRUUkPlWhY6S1U60smKCtfZ" +
       "zzXu+KGX2g6++t2u8c3TyUvx2copMk/8vQow2eCvYS8rT1z752WZC/M7p5Fi" +
       "rvJoyDvlXf33PLVlnXgwyMtl00FWldmVRN2VbrFFp6yoK5kK57hW4/+Ga1t8" +
       "gFu8aex1coiJOn28gSy1UUS1m1ZSZ/iV1REXH2zWXMHZMYiFlc7N3DK9n2//" +
       "/o2dDX1gBzHSXFSkK4o0lqvEYrZRHHV5O+dcwEHG2jyYLzIS2KBpVi6M7cew" +
       "ucQ00U2+iURvZeDBuNBrxYWIT+D5TL3Ag82A6X6qI07EZ2bYehhx+mLxaDY6" +
       "nIkOpGOJgTR2DXrk+ew05bkEri3Wqn1V8kAmfqG3EKa6ruohRQ2VCnLIYHvA" +
       "BeQpZSENqx3DAMcckqzyyKoWbpgxHn0+nDESiqZSiVR2IJEF/rLpzKXxaHpr" +
       "NJrJJlOJSDSdjg1sycYG0pnUYCQDWPkGEQ98X5gmfN1wbbOYjNWCz1vNW/Ax" +
       "XVAMLOJCapFBL+DJ8AwACQ/PGK6YDydQXppwZVI9A+m+RKo/mxjMJAczgF8m" +
       "mx7agqMOeqC4eZpQ4LB+i4F4LSjOngoKsKBcESpmNC7MXqkZkG6fMR5xH3Yg" +
       "+nrxALPpHYxEe9GiIokB2GKZWqB8bZqg4HlY0uIiUQuUqnMmH/uY1FWwWTP2" +
       "3DljQBI+rEAU8jGQT6YSsJNMX+MF465pgoGFY9riIFULjI21wYBqryiz0Lhd" +
       "4EPoFqlme5dvzhiNlA8vjKw20UhF04PxTHZLdCCa6smAcUSHI9Ek+pNacDw4" +
       "TTgWwTVksTBYC45mfGEQLhn8fPp7MxZz0GcNUPpwOu7jMHlhU0vKh6cp5Xy4" +
       "LrU4GK4lZbnQe2zGEg77zM/IomQ6OtibyPZkMqnY5sFM1FeuH81Arh3Wuttr" +
       "ypXX6Rj+fHrGcm33mb+WXFtT0b5acv20jlxm1zpsWHl1/tdE/M94XEchATuu" +
       "njvlqXb6iqI0Pi5T9/7GomaF34saXtAcvfbQkVzijjODVmZJGZnDVO0MmU5Q" +
       "2cXIHH6vlIXggnwELsESQvCqyIHJIz9Hv6UOaZ3E99U6fb/H5mXI5MapJX+u" +
       "XyrQ8ontoKOzV6ayxfqnW/hgs1YLkY/ClbfEyk8fET/SOlK/Xafvr9i8AaWj" +
       "g0i0BFHfsIssFyRvngBIOrFvNVyqJZc6fUj8SOuI/UGdvg+x+QcjbQBJLzVE" +
       "XSrHuYMOGP88AWAswL6T4JqwJJqYPhh+pB6BA5W+Y559ctAnyRRXCbT4IxRo" +
       "w6aRkSY8QNaYUfs0zXMAc1Zyp7i/K/ma7UZ4bhcyodnpus8xMntUVWUqKF5u" +
       "8edVpbIOAk0nUgf7LCD3TV8HfqT1dbCqyn+br5f5tw2DqTiHflUdtazFZllZ" +
       "LfhrvgPWyScSrAOWxAemD5YfaW2w+C7k0tY5RwlsxGa9HxIbTgASc7EPS+Tb" +
       "LXFunz4SfqQeQYPlM9TAatt2pn6jvQ1KzCGJTlK9TxcK5h7vrm+QrqPGqJ3t" +
       "c7qLsDkP4M3ziFFrC8+aUKWcA/n5JwDyNuwLwfWehdt7dSD3Zn6QHM6BWpdR" +
       "EYoZT9rXWmfO+ogtRDVMni2Gcmoh1KuKxQL4RQ7ZJ+pYK54fBbYx0graE3f3" +
       "KLmkwET8qiMQcRCc8pBsBghi9YPDAqvNOc3//kYb6K8CypfUd/sGUlzonXUA" +
       "GcVmO3hEqL10QWRQIiXLJ1uxyoMtJyQHdvwvICox0u4pgfFV5dKqL87Mr6TE" +
       "+460Ny85Mvi8+aLF/pJpXpw0jxVl2f0yzXXfpEFdInF055mv1vihaGAXlL1T" +
       "7WRGWpwfKEVAMokLUJLUJIbdiP/cYzVGOrxjGWnk/93jgLbFGYcOld+4h0ww" +
       "0gBD8HZSszeC64zPfBlZCrgqBeLEcLJoKqWVSdyfMuCLA/6poJ10FM2PBbPi" +
       "/Ue2DVz5znl3mJ9SiLKwdy/OMjdOZpsfbPBJ8UXBKb6z2XM1bV3/ftsDc061" +
       "U5aKTzncvHHTAfPmnz0s83xbYHSVPzF44eimR3+6v+mZIAlsJwEBXOz26te2" +
       "Ja0IJdn2ePWR/JCg848eutd/dc+Fp4/95UX+YpyYR/jL/cdnxeeOXfbswaVH" +
       "VwbJ3BhphKKOlvj75N49SoqKE/oIaZWMaAlYhFkkQa44729DqxbwpJbjYsHZ" +
       "Wn6Ke5ORNdUv06q/TGqRVYhAm9WiksNpWuNkrvPE1IznXUtR0zwEzhNLldh+" +
       "2gw/qA2wx2y8X9PsD1QaDmt8b19VO51Ew72e3+LdDf8Frgoe0kYsAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qNRP32xM0mrP1JpNO9K4HoiTdkvvr8QC");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "P9odbPi/j9ndMok5AAA=");
}
