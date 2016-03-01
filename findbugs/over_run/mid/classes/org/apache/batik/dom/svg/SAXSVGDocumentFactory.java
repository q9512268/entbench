package org.apache.batik.dom.svg;
public class SAXSVGDocumentFactory extends org.apache.batik.dom.util.SAXDocumentFactory implements org.apache.batik.dom.svg.SVGDocumentFactory {
    public static final java.lang.Object LOCK = new java.lang.Object();
    public static final java.lang.String KEY_PUBLIC_IDS = "publicIds";
    public static final java.lang.String KEY_SKIPPABLE_PUBLIC_IDS = "skippablePublicIds";
    public static final java.lang.String KEY_SKIP_DTD = "skipDTD";
    public static final java.lang.String KEY_SYSTEM_ID = "systemId.";
    protected static final java.lang.String DTDIDS = "org.apache.batik.dom.svg.resources.dtdids";
    protected static final java.lang.String HTTP_CHARSET = "charset";
    protected static java.lang.String dtdids;
    protected static java.lang.String skippable_dtdids;
    protected static java.lang.String skip_dtd;
    protected static java.util.Properties dtdProps;
    public SAXSVGDocumentFactory(java.lang.String parser) { super(org.apache.batik.dom.svg.SVGDOMImplementation.
                                                                    getDOMImplementation(
                                                                      ),
                                                                  parser);
    }
    public SAXSVGDocumentFactory(java.lang.String parser,
                                 boolean dd) { super(org.apache.batik.dom.svg.SVGDOMImplementation.
                                                       getDOMImplementation(
                                                         ),
                                                     parser,
                                                     dd);
    }
    public org.w3c.dom.svg.SVGDocument createSVGDocument(java.lang.String uri)
          throws java.io.IOException { return (org.w3c.dom.svg.SVGDocument)
                                                createDocument(
                                                  uri);
    }
    public org.w3c.dom.svg.SVGDocument createSVGDocument(java.lang.String uri,
                                                         java.io.InputStream inp)
          throws java.io.IOException { return (org.w3c.dom.svg.SVGDocument)
                                                createDocument(
                                                  uri,
                                                  inp);
    }
    public org.w3c.dom.svg.SVGDocument createSVGDocument(java.lang.String uri,
                                                         java.io.Reader r)
          throws java.io.IOException { return (org.w3c.dom.svg.SVGDocument)
                                                createDocument(
                                                  uri,
                                                  r);
    }
    public org.w3c.dom.Document createDocument(java.lang.String uri)
          throws java.io.IOException { org.apache.batik.util.ParsedURL purl =
                                         new org.apache.batik.util.ParsedURL(
                                         uri);
                                       java.io.InputStream is =
                                         purl.
                                         openStream(
                                           org.apache.batik.util.MimeTypeConstants.
                                             MIME_TYPES_SVG);
                                       org.xml.sax.InputSource isrc =
                                         new org.xml.sax.InputSource(
                                         is);
                                       java.lang.String contentType =
                                         purl.
                                         getContentType(
                                           );
                                       int cindex =
                                         -1;
                                       if (contentType !=
                                             null) {
                                           contentType =
                                             contentType.
                                               toLowerCase(
                                                 );
                                           cindex =
                                             contentType.
                                               indexOf(
                                                 HTTP_CHARSET);
                                       }
                                       java.lang.String charset =
                                         null;
                                       if (cindex !=
                                             -1) {
                                           int i =
                                             cindex +
                                             HTTP_CHARSET.
                                             length(
                                               );
                                           int eqIdx =
                                             contentType.
                                             indexOf(
                                               '=',
                                               i);
                                           if (eqIdx !=
                                                 -1) {
                                               eqIdx++;
                                               int idx =
                                                 contentType.
                                                 indexOf(
                                                   ',',
                                                   eqIdx);
                                               int semiIdx =
                                                 contentType.
                                                 indexOf(
                                                   ';',
                                                   eqIdx);
                                               if (semiIdx !=
                                                     -1 &&
                                                     (semiIdx <
                                                        idx ||
                                                        idx ==
                                                        -1))
                                                   idx =
                                                     semiIdx;
                                               if (idx !=
                                                     -1)
                                                   charset =
                                                     contentType.
                                                       substring(
                                                         eqIdx,
                                                         idx);
                                               else
                                                   charset =
                                                     contentType.
                                                       substring(
                                                         eqIdx);
                                               charset =
                                                 charset.
                                                   trim(
                                                     );
                                               isrc.
                                                 setEncoding(
                                                   charset);
                                           }
                                       }
                                       isrc.
                                         setSystemId(
                                           uri);
                                       org.apache.batik.dom.svg.SVGOMDocument doc =
                                         (org.apache.batik.dom.svg.SVGOMDocument)
                                           super.
                                           createDocument(
                                             org.apache.batik.dom.svg.SVGDOMImplementation.
                                               SVG_NAMESPACE_URI,
                                             "svg",
                                             uri,
                                             isrc);
                                       doc.
                                         setParsedURL(
                                           purl);
                                       doc.
                                         setDocumentInputEncoding(
                                           charset);
                                       doc.
                                         setXmlStandalone(
                                           isStandalone);
                                       doc.
                                         setXmlVersion(
                                           xmlVersion);
                                       return doc;
    }
    public org.w3c.dom.Document createDocument(java.lang.String uri,
                                               java.io.InputStream inp)
          throws java.io.IOException { org.w3c.dom.Document doc;
                                       org.xml.sax.InputSource is =
                                         new org.xml.sax.InputSource(
                                         inp);
                                       is.
                                         setSystemId(
                                           uri);
                                       try {
                                           doc =
                                             super.
                                               createDocument(
                                                 org.apache.batik.dom.svg.SVGDOMImplementation.
                                                   SVG_NAMESPACE_URI,
                                                 "svg",
                                                 uri,
                                                 is);
                                           if (uri !=
                                                 null) {
                                               ((org.apache.batik.dom.svg.SVGOMDocument)
                                                  doc).
                                                 setParsedURL(
                                                   new org.apache.batik.util.ParsedURL(
                                                     uri));
                                           }
                                           org.apache.batik.dom.AbstractDocument d =
                                             (org.apache.batik.dom.AbstractDocument)
                                               doc;
                                           d.
                                             setDocumentURI(
                                               uri);
                                           d.
                                             setXmlStandalone(
                                               isStandalone);
                                           d.
                                             setXmlVersion(
                                               xmlVersion);
                                       }
                                       catch (java.net.MalformedURLException e) {
                                           throw new java.io.IOException(
                                             e.
                                               getMessage(
                                                 ));
                                       }
                                       return doc;
    }
    public org.w3c.dom.Document createDocument(java.lang.String uri,
                                               java.io.Reader r)
          throws java.io.IOException { org.w3c.dom.Document doc;
                                       org.xml.sax.InputSource is =
                                         new org.xml.sax.InputSource(
                                         r);
                                       is.
                                         setSystemId(
                                           uri);
                                       try {
                                           doc =
                                             super.
                                               createDocument(
                                                 org.apache.batik.dom.svg.SVGDOMImplementation.
                                                   SVG_NAMESPACE_URI,
                                                 "svg",
                                                 uri,
                                                 is);
                                           if (uri !=
                                                 null) {
                                               ((org.apache.batik.dom.svg.SVGOMDocument)
                                                  doc).
                                                 setParsedURL(
                                                   new org.apache.batik.util.ParsedURL(
                                                     uri));
                                           }
                                           org.apache.batik.dom.AbstractDocument d =
                                             (org.apache.batik.dom.AbstractDocument)
                                               doc;
                                           d.
                                             setDocumentURI(
                                               uri);
                                           d.
                                             setXmlStandalone(
                                               isStandalone);
                                           d.
                                             setXmlVersion(
                                               xmlVersion);
                                       }
                                       catch (java.net.MalformedURLException e) {
                                           throw new java.io.IOException(
                                             e.
                                               getMessage(
                                                 ));
                                       }
                                       return doc;
    }
    public org.w3c.dom.Document createDocument(java.lang.String ns,
                                               java.lang.String root,
                                               java.lang.String uri)
          throws java.io.IOException { if (!org.apache.batik.dom.svg.SVGDOMImplementation.
                                              SVG_NAMESPACE_URI.
                                             equals(
                                               ns) ||
                                             !"svg".
                                             equals(
                                               root)) {
                                           throw new java.lang.RuntimeException(
                                             "Bad root element");
                                       }
                                       return createDocument(
                                                uri);
    }
    public org.w3c.dom.Document createDocument(java.lang.String ns,
                                               java.lang.String root,
                                               java.lang.String uri,
                                               java.io.InputStream is)
          throws java.io.IOException { if (!org.apache.batik.dom.svg.SVGDOMImplementation.
                                              SVG_NAMESPACE_URI.
                                             equals(
                                               ns) ||
                                             !"svg".
                                             equals(
                                               root)) {
                                           throw new java.lang.RuntimeException(
                                             "Bad root element");
                                       }
                                       return createDocument(
                                                uri,
                                                is);
    }
    public org.w3c.dom.Document createDocument(java.lang.String ns,
                                               java.lang.String root,
                                               java.lang.String uri,
                                               java.io.Reader r)
          throws java.io.IOException { if (!org.apache.batik.dom.svg.SVGDOMImplementation.
                                              SVG_NAMESPACE_URI.
                                             equals(
                                               ns) ||
                                             !"svg".
                                             equals(
                                               root)) {
                                           throw new java.lang.RuntimeException(
                                             "Bad root element");
                                       }
                                       return createDocument(
                                                uri,
                                                r);
    }
    public org.w3c.dom.DOMImplementation getDOMImplementation(java.lang.String ver) {
        if (ver ==
              null ||
              ver.
              length(
                ) ==
              0 ||
              ver.
              equals(
                "1.0") ||
              ver.
              equals(
                "1.1")) {
            return org.apache.batik.dom.svg.SVGDOMImplementation.
              getDOMImplementation(
                );
        }
        else
            if (ver.
                  equals(
                    "1.2")) {
                return org.apache.batik.dom.svg12.SVG12DOMImplementation.
                  getDOMImplementation(
                    );
            }
        throw new java.lang.RuntimeException(
          "Unsupport SVG version \'" +
          ver +
          "\'");
    }
    public void startDocument() throws org.xml.sax.SAXException {
        super.
          startDocument(
            );
    }
    public org.xml.sax.InputSource resolveEntity(java.lang.String publicId,
                                                 java.lang.String systemId)
          throws org.xml.sax.SAXException {
        try {
            synchronized (LOCK)  {
                if (dtdProps ==
                      null) {
                    dtdProps =
                      new java.util.Properties(
                        );
                    try {
                        java.lang.Class cls =
                          org.apache.batik.dom.svg.SAXSVGDocumentFactory.class;
                        java.io.InputStream is =
                          cls.
                          getResourceAsStream(
                            "resources/dtdids.properties");
                        dtdProps.
                          load(
                            is);
                    }
                    catch (java.io.IOException ioe) {
                        throw new org.xml.sax.SAXException(
                          ioe);
                    }
                }
                if (dtdids ==
                      null)
                    dtdids =
                      dtdProps.
                        getProperty(
                          KEY_PUBLIC_IDS);
                if (skippable_dtdids ==
                      null)
                    skippable_dtdids =
                      dtdProps.
                        getProperty(
                          KEY_SKIPPABLE_PUBLIC_IDS);
                if (skip_dtd ==
                      null)
                    skip_dtd =
                      dtdProps.
                        getProperty(
                          KEY_SKIP_DTD);
            }
            if (publicId ==
                  null)
                return null;
            if (!isValidating &&
                  skippable_dtdids.
                  indexOf(
                    publicId) !=
                  -1) {
                return new org.xml.sax.InputSource(
                  new java.io.StringReader(
                    skip_dtd));
            }
            if (dtdids.
                  indexOf(
                    publicId) !=
                  -1) {
                java.lang.String localSystemId =
                  dtdProps.
                  getProperty(
                    KEY_SYSTEM_ID +
                    publicId.
                      replace(
                        ' ',
                        '_'));
                if (localSystemId !=
                      null &&
                      !"".
                      equals(
                        localSystemId)) {
                    return new org.xml.sax.InputSource(
                      getClass(
                        ).
                        getResource(
                          localSystemId).
                        toString(
                          ));
                }
            }
        }
        catch (java.util.MissingResourceException e) {
            throw new org.xml.sax.SAXException(
              e);
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gfvwn+v+B9zmdBW/LAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "v4hefSlv9Vduj9aTOS22cG2kEIRUsaNT5JxZ0UT3BB8MBBwmgPhXZhs++kN4" +
       "PRh2Dz9kVVBqsZQwljrJolq9s0mGaRseshCuK94UJgaI0jfGE3LF4ZmNzzsR" +
       "mnhYw6dVrKPzraixlSdqxBpdwp1VyZmzXiMul7HsuuI5aM+ZzzkB0fxZL+2N" +
       "0Gl53kVqlXZXqaBDu43OCAKBamVLhMWtWBWXaQMNRSZrNuxGw92qYquVf/OT" +
       "5QjhSIKqWMlwYQxHAV/BwtkwUYcdwjVmHC64xmI6mWINeQtJkjxuNMq8So6n" +
       "82HCjoQJawo0OTAr/oyca/35sKF7QsIyYzdcYaxGOSg3cRmpkuis1RwbmjUa" +
       "rAxB0Ec+2VXoGZbEhkhsiCGmcwMOmzkJ5qPiCmPKJi1ZGR5w4lZeCMOIxUwD" +
       "ljcOEsAUOjETc9FX3SZJrbxVJzLagiENHVfY6N5iFIciPyT7c1ieCKRHohxH" +
       "ksx4uTA4aVat8Ex9nK2gubrMrBhbd9waJriY0awnSEhbvtvUtDGDWrLRicyK" +
       "x1bXcMqZ6JIYDGSTMT0dE+barOdgLmO1OR12VBaezwJjYktjzeJXXr9ntBJq" +
       "g8Doikp5lpU3VAJbsuOsfL5GGrEzqE0ZPuDFNYRO0jaFQ1nP3Hqq2cCa0/nI" +
       "Fmh4hTNGM571iWGvNzIq9CwcOxzCOyuiWxH6+BoaM3NivhR5p1N1RuxESAbE" +
       "uquZAtUfmzOC9mVSR4wpE/CGa0WuNRi303G6bWwrftfbTPsLa9pYrJfdsLGm" +
       "u8J61uTXDXKFRzWWNmvMLIwnbW+eYkSwmLbnU3KasrLl2OZ87hvWdMp4A13Q" +
       "2bFGRr0yzTFe3yN6VaoyYWsNML0kqzps27yrUSteUMmFXjd0r7/g0Tqqb6gs" +
       "nkdUGLObccdJWQFOJuJAq9ZqzXARR2yXnjami9m8nLUH2oRvaMAjUv2Zm3Up" +
       "bUFSFcWVKu223ZnORuv2OqH5OW6bmSJtcZ/fYjStb9wMCTkXl12MZ4RlP+6M" +
       "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" +
       "7Hp0pKF88yNH584b5c+fn7rZmbri2fOX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("P/Xa6/LkZ6uXDh4T42HpvtBxP2QqW8U80f0DoKUP3PypL1UcKTx+9Prrn/pv" +
       "T3If0T5xG6eQnjmD82yT/4j6ym9iPyD9+KXSXUcPYs8ddjxd6frpx6/3+0oY" +
       "+TZ36iHsU0ej8Xiu/PeD6+WD0Xj57P/Ux+N9znL2CsvZ2cuZp/B7xwKVQuA/" +
       "XCxwOMC70y66sz+coImkuLneinp/kCe/B6xR8hUhVE4M92HV9+S2EcPSRSZx" +
       "bKe/fzuP/ouMf3teSZ8+UNKn74ySTp0BOacI241CNgSsraLyt26u4W8UAv89" +
       "T/7LRZrKC/7jsSr+6E6o4tUDVbz6/VPFQ4eqYBQhPwuUZ//vW2nhL/Lkf7wF" +
       "LXz3bWjhXXnm8+D6qQMt/NT3Z9bsXbkF3b378uQS0NWO7tm58a6Tc+PcpNi7" +
       "607o4OsHOvj6nbeEPPmTgudjt1LE43ly9Zwi8tx3HBN+5E4Q/u4B4e9+fwj/" +
       "ecHnuVsRfiFP3nsrwk/dAcJ779zV3X2/fcJ3HYcdleOkIPWhW7GG8uT9t2L9" +
       "4p1gfe2A9bU7w/ruQuDuM6yPLbxzK+rX86R+K+qNO0H94ETW3rkTWXea+s7W" +
       "38QN7qhjefLSrah33wb1p/JMEInufeSA+kfuDPVzHn16RuDEccU9Nk9I4LXX" +
       "StifUEPLNZWc53EUCVz6U6dc+oVShTaot6GN4hzsM6X8+OFOG+Sd0cZJsjfe" +
       "PCB8IqeZWOZ+ICT5ewWnosI9IU/4sPQgiHn98NTCdvap/NY5OGhSaOVjbzf2" +
       "Ad5gb3GglcWd0crZBWBnKO5NLWlPLATy86B7BtCBv3vHCrVDPUwP9ff4Sf3t" +
       "YsndIa0jVZi3dRg2LD124dsd+VH1J869Z7Z7N0r6pdcfvvfx12e/X7zgcPT+" +
       "0n1k6V41Ms2Th0RP3F92fUXVC03dtzsy6hZ8Xz4wiou2gWHpLpDmqPeynfQP" +
       "HwQ/Z6WBJEhPSn4yLF09KxmW7im+T8r9nbB0/7FcWLq8uzkp8hnQOhDJbz/r" +
       "Ho7EBy8EXRzbARo9u3ndTYAnTlpgEa4+eqvROqpy8h2KfM9avCt4uL+Mdm8L" +
       "3pC++joxfvk7zZ/dvcMhmUKW5a3cS5au7F4nKRrN96jP3bS1w7Yu4y9+76Gv" +
       "3fe+w/30QzvAx7PhBLZnLn5hArXcsHjFIfunj/+TD//c698oDu/8P/Gc5xrE" +
       "OQAA");
}
