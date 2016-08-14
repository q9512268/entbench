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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3kJLZS/37wf5Ld4d/x8PK0yZJi4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C6zryHmezt33er17d+31btfel32dei37UCL1IHP9kihK" +
       "fEmkRJES5dbXfIsSX+JbcjeNjTp2Y8A1knXqNInRAg6SBk7sFg1SoEjhImiT" +
       "IEGBtEHitojtFkWT1jEaA3Xaxk3TIXVe95xz9+6NrytgRtTwn5nv++eff/4R" +
       "h1/8VuW+KKxUA9/ZWo4fHxp5fLhymofxNjCiQ5pt8koYGTruKFE0BWU3tLd+" +
       "+bE//e5nllevVO5fVN6geJ4fK7Hte9HEiHwnNXS28thpKeEYbhRXrrIrJVWg" +
       "JLYdiLWj+Dpbed2ZqnHlGnsMAQIQIAABKiFAnVMpUOn1hpe4eFFD8eJoU/mh" +
       "ygFbuT/QCnhx5cWbGwmUUHGPmuFLBqCFB4vfEiBVVs7Dygsn3PecLxD+bBV6" +
       "5e9+6Oo/vqfy2KLymO0JBRwNgIhBJ4vKI67hqkYYdXTd0BeVxz3D0AUjtBXH" +
       "3pW4F5UnItvylDgJjRMlFYVJYIRln6eae0QruIWJFvvhCT3TNhz9+Nd9pqNY" +
       "gOubTrnuGfaLckDwYRsAC01FM46r3Lu2PT2uPH++xgnHawwQAFUfcI146Z90" +
       "da+ngILKE/uxcxTPgoQ4tD0LiN7nJ6CXuPLMLRstdB0o2lqxjBtx5enzcvz+" +
       "FpB6qFREUSWuPHlerGwJjNIz50bpzPh8a/SeT3/EI70rJWbd0JwC/4Og0nPn" +
       "Kk0M0wgNTzP2FR95J/sTypt+9ZNXKhUg/OQ54b3Mr/yNb3/gXc995Tf2Mm++" +
       "RIZTV4YW39C+oD76O2/BX8LuKWA8GPiRXQz+TcxL8+eP7lzPAzDz3nTSYnHz" +
       "8PjmVyb/Sv7hXzC+eaXyMFW5X/OdxAV29Ljmu4HtGOHA8IxQiQ2dqjxkeDpe" +
       "3qcqD4Br1vaMfSlnmpERU5V7nbLofr/8DVRkgiYKFT0Arm3P9I+vAyVeltd5" +
       "UKlUHgCp8iJISGX/qRdZXFGgpe8akKIpnu35EB/6Bf8IMrxYBbpdQiqw+jUU" +
       "+UkITBDyQwtSgB0sjaMbuu9CUQpMqTMXpEHP1xIXVO0rhclvDwtTC/5/dJIX" +
       "TK9mBwdgEN5y3gU4YPaQvqMb4Q3tlaRLfPuXbvzWlZMpcaSjuHII+j3c93tY" +
       "9nsI+j0E/R5e2m/l4KDs7o1F//vxBqO1BvMeeMRHXhL+Ov3hT771HmBoQXYv" +
       "UPUVIArd2jHjp56CKv2hBsy18pXPZR+V/mbtSuXKzR62wAyKHi6q84VfPPF/" +
       "187PrMvafewTf/SnX/qJl/3TOXaTyz6a+hdrFlP3ree1G/qaoQNneNr8O19Q" +
       "fvnGr7587UrlXuAPgA+MFWCzwL08d76Pm6bw9WN3WHC5DxA2/dBVnOLWsQ97" +
       "OF6GfnZaUg77o+X140DHryts+gWQvCMjL7+Lu28IivyNezMpBu0ci9LdvlcI" +
       "fuar//q/IqW6jz3zY2fWOsGIr5/xBkVjj5Xz/vFTG5iGhgHk/uBz/I9/9luf" +
       "+GBpAEDibZd1eK3IceAFwBACNX/8Nzb/7utf+8LvXjkxmoMYLIeJ6thafkKy" +
       "KK88/CokQW8/cIoHeBMHTLbCaq6JnuvrtmkrqmMUVvp/Hnt7/Zf/+NNX93bg" +
       "gJJjM3rX7Rs4Lf8r3coP/9aH/udzZTMHWrGanersVGzvIt9w2nInDJVtgSP/" +
       "6L959id/XfkZ4GyBg4vsnVH6rIO9DkrmT4Koo6xZLFyH+4WrHE2ovP3OMj8s" +
       "NFFWqpT3kCJ7Pjo7K26eeGfCkRvaZ373T14v/ck//3ZJ4+Z45qwRDJXg+t7u" +
       "iuyFHDT/1HkXQCrREsg1vjL6a1edr3wXtLgALWrAuUVcCPxQfpPJHEnf98C/" +
       "/xe/9qYP/849lSv9ysOOr+h7TwP8PzB7I1oCF5YH7//AftSzB0F2taRauUC+" +
       "LHjm4rzIjkwmu3xeFPmLRfb2i9Z2q6rn1H9l7+yKnzWgmZdeJRQNbRdMo/Ro" +
       "+YZefuLr65/+o1/cL83n1/pzwsYnX/nRvzj89CtXzgREb7sQk5ytsw+KSp6v" +
       "35P7C/A5AOn/FqkgVRTsF8Un8KOV+YWTpTkIioF+8dVglV30//BLL/+zn3/5" +
       "E3saT9wcDxAg3P3F3/vz3z783Dd+85IF6AHV9x1D8UqUH3gVu2aL7Hp5q1Fk" +
       "79kPePs12cZe9uny16OvPkT9IlQ99etP/xnnqB/7T//rwgQpl6NLRu1c/QX0" +
       "xZ9+Bn/fN8v6p+tCUfu5/OK6DcL607rwL7jfufLW+//llcoDi8pV7WjPIClO" +
       "UnjbBYiTo+ONBNhX3HT/5ph3H+BdP1n33nLebM50e35FOh0ucF1IF9cPn1uE" +
       "nq4cRVnNoxnTPD/ZDirlhbSfb2V+rcj+ajkm9xSX7wCOPyp3JjGAYHuKU/ZC" +
       "xGBJ5XDmEpe453U6j0vDmN3OMMY3w34PSD94BPsHL8AGq9FD+9WI2u8qlFdj" +
       "UGSLIvvgMfRHGUK+wYtdlsJvUD2h9BHnAKt3CJgD6f1HgN9/GeAnorUdBMV6" +
       "xZ9Fbt8Z8qcL5AJD8XynyxK34bC6Qw4oSL0jDr3LODxQcOhNe0XJ5s6AP3IM" +
       "/MZR/fNgwzsEex0k6ggsdamFRNsoNlxKPyzKtncG9/UlXFmYEkOg3cvw7l47" +
       "3jcXpY0jIyk+o8vwvnTLqB8sufsNyaEe6/bebj56Cz7FzAj9GMxAQ79I636g" +
       "/FsYy8fukE+h/+kRn+mlxqIti788Sk/wo6+i/R+5xFjI6ZS/gZOdiUBMLwP7" +
       "qdcO9smi9G0gyUdg5Qtg917wxy7HeOUU44kWT4fhPLAfv0Ng7wbpQ0fAPnQL" +
       "YD/5moFdPfExN24N8e/dIcS3g6QdQdRuAfHvv2aIDxYQC3SXQfsHdwjtJZCW" +
       "R9CWt4D2c68dGkAFNpFBdLyondlQF+Vg42jvt3tnIP/8bSGXrZcz4j74sH1Y" +
       "cv7ynXmjp1aOdu04FJSMMAKxzrWV075Mh8RrBgRCrkdPl23W96zrn/rPn/nt" +
       "v/O2r4O4iK7clxYxCwiHzqzto6T4T/JHvvjZZ1/3yjc+VW4Pwb5I+tv/qP2N" +
       "otVfuTNazxS0hNK1sUoUD8sdnaEXzMomOmf4DEDA4QCIf2m28RNfIBsR1Tn+" +
       "sHXFgDMtn7gmt0vgBmRJTXgmcATqqZO2RoiMJRNLSqU0jdPMOdyZRmO8Habq" +
       "ANvq7SRaxZ7X5FweFxSHCQK/08ctczfproklMRJw2N+QYkzMCHYsrCBKrI3o" +
       "WTCWRH+5UNaqWqvCKqymJqx6tSaOmcJuU/dSuFqtmojrgm9XR1Zks087a88V" +
       "ZbgPM8tuKOFk7jIC2I8R7jZYSBYk5obY3m4EqI0soW1D6opxn2z58npT52Ys" +
       "G0z8WYi3bH5ku3IuLLggludCdxAS00Ew0epL29606+uJy/TFtbKxqTDsj0BQ" +
       "MZXpwJkMHcne9actsZEP2h1ZVuQmPkUZlK6SdQR4dlGiVi1U8SmsvSZcbMeL" +
       "JB0MeFbejJfJOlKciAqCzWq5GTB5PZzQ0tJucauN37Jzorbd1oR6fSUi3aZO" +
       "1IyuHBkbE6phzGDZXbe7I8Kb6kN1OZMS4NHS3qhLOJjYjJe1zbQeztet1jgS" +
       "Nkpj2XUCe6YMl1HfH1C5W+sFQo2Plc1mJqjTDZntqFiaWFvdtydL1R0NaCqg" +
       "jborhzu+RlBS1O7vFiLepqh45g+3PWOUMChHtPXVFN1QOxFr9lsTIx20o9UY" +
       "Hy8GVb87dpOtF4Rida3gNL+iJQslk2Aj2xvNN4zWWGVn0nhdt5jlCuvhdcXt" +
       "DYKtmzXnQ6rV2Yk7etozdmhHaYwxD5pOgnEgkh0u5rtgiJOc9Dszpt7J0ayL" +
       "mztOsj0znFn0JFm0Ryolz3ZKr8MsZ7S9Vmsh525XIs2s7ZXW7Us1S+0hRrcF" +
       "2zg1jdluR6wPFmkE206mrsNcHWwmOUbY/JzI0M7Go73OUpRnwkBqbJEuM6zB" +
       "uxETpmRTGab9LqRv3PbYwkXcJOqTWWRi0/HANSbwOiSVjrucr63+IJlN4Op8" +
       "sWo2KcKi8CGU4Z1k4SG7uM6IYbNZR6VoNWSE3rSuVtmtnSVkNUkNpJ/AbYrd" +
       "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" +
       "7YK2G51O573vLf6u+rU7+xvt8fLfwZND");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("d3+J/wXzyx64l5/7K0cHtI6/z/zDeubx7cnRiOqtjy5dOLdUPMd+9lbn78pn" +
       "2F/42Cuf17mfrV85etxMxpWHYj94t2OkhnOm+0dAS++89dPjYXn88PQR7q9/" +
       "7L89M33f8sN3cJrp+XM4zzf5D4df/M3BD2g/dqVyz8kD3QsHI2+udP3mx7gP" +
       "h0achN70poe5z56MxlOF8t8B0keORuMj5//vPh3vC5ZzUFrO3l7OPc0/OBWo" +
       "lQL/4XKB4wHen5qx/UOKI3LNCAq9lfX+oMh+D1ijFhpKbJwZ7uOqby5sI0O0" +
       "y0zi1E5//06OEJQF//aikj5+pKSP3x0l3XSW5IIivCCJhRiwdsvK37y1hr9W" +
       "Cvz3Ivsvl2mquPEfT1Xxh3dDFZ85UsVnvn+qePRYFRNDKc4UFcX/+3Za+PMi" +
       "+x+vQQvf+R608Mai8K0g/dSRFn7q+zNrDh64Dd2Dh4rsCtDVnu75ufHGs3Pj" +
       "wqQ4uOdu6OCrRzr46t23hCL745Lnk7dTxFNFdvWCIorS150SfvxuEP7OEeHv" +
       "fH8I/1nJ58XbEX5bkb3ldoSfvQuED96wr7v//t4J33MadtROs5LUu2/HGiqy" +
       "d9yO9Ut3g/W1I9bX7g7re0uBe8+xPrVw7HbUrxdZ43bUm3eD+tHJroMLJ7vu" +
       "NvW9rb+KG9xTHxTZB25HvfM9UH+2KASR6MH7jqi/7+5Qv+DRx+cEzhx7PBCK" +
       "jAVe2zLiHjek3MAxCp6nUSRw6c/e5NIvlSq1MfwetFGep32+Uhxj3GuDvTva" +
       "OEv2xqsHhE8XNHPXOYyUvHg/4aao8EApskVceT2IecP4poXt/NP91D86sFJq" +
       "5YPfa+wDvMHB7Egrs7ujlfMLwN5Qglta0oFaChTnSg/WQAfh/n0swovteHus" +
       "v6fO6m8fS+4Pe52owrmjQ7Vx5clL3xIpjrw/feGdtP17VNovff6xB5/6vPj7" +
       "5YsSJ+86PcRWHjQTxzl72PTM9f1BaJh2qamH9kdPg5LvR46M4rJtYFy5B+QF" +
       "6oPdXvqHjoKf89JAEuRnJT8aV66el4wr95XfZ+X+Vlx5+FQurty/vzgr8gnQ" +
       "OhApLj8ZHI/Euy4FXR7/ARo9v3ndT4Cnz1pgGa4+cbvROqly9l2MYs9avld4" +
       "vL9M9m8W3tC+9Hl69JFvt352/y6I5ii7XdHKg2zlgf1rKWWjxR71xVu2dtzW" +
       "/eRL3330yw+9/Xg//ege8OlsOIPt+ctfvCDcIC5fldj906f+yXt+7vNfKw8B" +
       "/T+O8z1W8DkAAA==");
}
