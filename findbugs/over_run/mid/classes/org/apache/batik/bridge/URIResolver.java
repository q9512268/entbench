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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfWwUxxWfO38bG9sQbMqHAWOQcMhdKaSoNaUBx2CT84ds" +
       "cFVTcuztztkLe7vL7px9hiQE1DS0ldIkQEoaQK0KiooISatEyT+hVFWbpPkS" +
       "NGqToKYf+adtghT+aEhLv96b2a/buzNFkYq0c+OZ997Me/Pe770Zzl4hFbZF" +
       "2kxJV6QYmzKpHRvE/qBk2VTp0iTb3gqjSflbfzy8/9qvaw5ESeUomTku2X2y" +
       "ZNNNKtUUe5QsVHWbSbpM7X5KFeQYtKhNrQmJqYY+Suaodm/G1FRZZX2GQpFg" +
       "RLISpElizFJTWUZ7HQGMLErw3cT5buIbwgSdCVInG+aUzzAvj6ErMIe0GX89" +
       "m5HGxC5pQopnmarFE6rNOnMWudU0tKkxzWAxmmOxXdrtjiG2JG4vMEPbMw0f" +
       "X394vJGbYbak6wbjKtpD1Da0CaokSIM/2q3RjL2H3EfKEmRGgJiR9oS7aBwW" +
       "jcOirr4+Fey+nurZTJfB1WGupEpTxg0xsiRfiClZUsYRM8j3DBKqmaM7ZwZt" +
       "F3vauscdUvHorfEj37278SdlpGGUNKj6MG5Hhk0wWGQUDEozKWrZGxSFKqOk" +
       "SYcDH6aWKmnqXue0Z9nqmC6xLLiAaxYczJrU4mv6toKTBN2srMwMy1MvzZ3K" +
       "+asirUljoGuzr6vQcBOOg4K1KmzMSkvgew5L+W5VV7gf5XN4OrbfBQTAWpWh" +
       "bNzwlirXJRggs4SLaJI+Fh8G59PHgLTCABe0uK+VEIq2NiV5tzRGk4zMDdMN" +
       "iimgquGGQBZG5oTJuCQ4pXmhUwqcz5X+dQ/t03v0KInAnhUqa7j/GcDUGmIa" +
       "omlqUYgDwVjXkXhMan7xUJQQIJ4TIhY0z99z9Y6VrRdeFjTzi9AMpHZRmSXl" +
       "U6mZFxd0rfhCGW6j2jRsFQ8/T3MeZYPOTGfOBKRp9iTiZMydvDD0y6/ef4Z+" +
       "ECW1vaRSNrRsBvyoSTYypqpRazPVqSUxqvSSGqorXXy+l1RBP6HqVIwOpNM2" +
       "Zb2kXONDlQb/G0yUBhFoolroq3racPumxMZ5P2cSQqrgI3XwLSfiH/9lRImP" +
       "Gxkal2RJV3UjPmgZqD8eKMccakNfgVnTiKfA/3fftiq2Nm4bWQscMm5YY3EJ" +
       "vGKcisl4ylKVMRrfNtTrBIEVQ28z/0/r5FDf2ZORCBzFgjAQaBBDPYamUCsp" +
       "H8lu7L56LvmqcDIMDMdSjCyFxWJisRhfLCYWiwUWI5EIX+MWXFQcNRzUbgh5" +
       "wNy6FcM7tuw81FYGPmZOloOVkXR5QQ7q8rHBBfSkfPbi0LU3X689EyVRgI8U" +
       "5CA/EbTnJQKRxyxDpgogUamU4MJivHQSKLoPcuHY5IGR/Z/l+whiOwqsAFhC" +
       "9kFEZG+J9nBMF5Pb8OCfP376sXsNP7rzkoWb4wo4ETTawicaVj4pdyyWnku+" +
       "eG97lJQDEgH6MgmiBYCtNbxGHnh0ukCMulSDwmnDykgaTrnoWcvGLWPSH+Gu" +
       "1sT7t8ARz8Boaoav0wkv/ouzzSa2LcI10WdCWnCg/9KweeLtN/6ympvbzQkN" +
       "gWQ+TFlnAIdQ2CyOOE2+C261KAW63x0bPHz0yoPbuf8BxdJiC7Zj2wX4A0cI" +
       "Zn7g5T3v/P69U29FfZ9lkIizKahpcp6SOE5qp1ES/dzfD+CYBjGOXtO+TQev" +
       "VNOqlNIoBsk/G5ateu7DhxqFH2gw4rrRyhsL8Mc/s5Hc/+rd11q5mIiMedS3" +
       "mU8mwHm2L3mDZUlTuI/cgUsLH39JOgEwD9Bqq3spR8sot0GUaz6XkfmICZOr" +
       "5ZhiZGL2xFhseGTznYaczVCnbAGa5aVwwyVMGBJgD/eDNZwpztvVaEO+HOFz" +
       "X8Sm3Q7GU37IBkqopPzwWx/Vj3x0/io3QH4NFnSfPsnsFB6LzbIciG8JY1eP" +
       "ZI8D3ZoL/V9r1C5cB4mjIFEG/LUHLNx5nrM51BVV7/7s5807L5aR6CZSq4GK" +
       "myQet6QGAoba4wC4OfPLdwh/mayGppGrSgqUxyNaVPzwuzMm48e194WWZ9c9" +
       "efI97qfCMedz9jIbS78wxPL63UeHDy8/8f5Pr/2wSmT/FaUhMcQ39x8DWurg" +
       "nz4pMDIHwyKVSYh/NH72+Lyu9R9wfh+VkHtprjBTAW77vJ87k/lbtK3yF1FS" +
       "NUoaZadWHpG0LMb6KNSHtltAQz2dN59f64nCptND3QVhRAwsG8ZDP0NCH6mx" +
       "Xx+CwJl4isvg63DQoSMMgRHCO3dxluW8XYHNShdxakzLYLBLqoRAp34asYxU" +
       "KzeMxUDgDvS5ESkgGdtObBJi0fUlvbU7X9cl8MWdTcVL6DoidMWmv1ClUtyM" +
       "zHBVgqrD1aqRBwceZkwU7qH9f+Um978SvjXODtaU2H9y2v2X4mZkppKHeji6" +
       "NrTdndNsN+cv2+Ety/9VklAJG0w/Ph4QhLiFpW4Z/IZ06uCRk8rA6VUCDWbl" +
       "V+7dcDF96jf/ei127A+vFCkSa5hh3qbRCaoF1iyHJZcUYFAfv4T5Ab320rWy" +
       "y4/OrSus8FBSa4n6raM0WIUXeOngX+dtXT++8yZKt0UhQ4VF/qjv7Cubl8uP" +
       "Rvk9UuBHwf0zn6kzHzVqLQoXZn1rHna0eUc7G49sIXw9ztH2hP3Rd56QV3hF" +
       "SSnWUK51Ujv+ud2NrNnB/I6vGuC4fMXJ4swuXyuPSJ2yWJ+kYc1IlW1Die6c" +
       "TE3P4iiek6lGrHfAm+Pi92ED1WntGGXOsjiS84PEvlFM52VQHOjiw7pnH07c" +
       "At8Oxz47bt60pVinMS3Xg4v+ZoiqTCRs/PMebO7zqqwAvlE5a6lsKt9c38bm" +
       "64xUgbn6IUg8YAwenzfB7ffAp7bfHBdpHnGM8MgN7FcEJ0uxhiwTEXnQN93j" +
       "09SJT2BzhJEmMIa4zFgbAUwgX/iuzU1w9FObgEdnO3zHHT2O37wJSrH+Ty50" +
       "eho7PInN94Ud8Ow3Tm2ypDE3lL7j2+EHN2+HHCTiwLUfK9S5Be+L4k1MPney" +
       "obrl5Lbf8qun925VB5e2dFbTggVUoF9pWjStcj3qRDll8p9zjLSUuE/AvUx0" +
       "+J6fEvQ/doIgSM9IBf8N0j0LWOPTgSjRCZI8z0gZkGD3BbNI6SHqyFwkP9l6" +
       "Vp5zIysH8vPSvKTG33fdBJQVL7xJ+emTW/r3Xf38aXEzljVp716UMiNBqsQl" +
       "3UtiS0pKc2VV9qy4PvOZmmVRx3WaxIZ9550f8KsuiEQTT3xe6Npot3u3x3dO" +
       "rTv/+qHKS1AhbCcRCZB+e2HFnTOzkGG3J4KVQeB/CfiNtrP2/Z1vfvJuZBa/" +
       "2BDxZNQ6HUdSPnz+8mDaNL8XJTW9pAIKGprj14E7p/QhKk/AFaw6q6t7srRX" +
       "AUdLGVndewqeie4pYQnJLeMYtN4bxZcVRtoKHnmLvDbBnW8SkAelo5j6UNrP" +
       "mmZwNodPpEW0grNZdeLv+7/x9gCET97Gg9Kq7GzKqyCCL81CNraNAnn+A/8i" +
       "8P0bPzxSHMBfuBN1Oa+ui71nV9PMibmyZKLPNB3aaIy7gWlyLHiDC/4VNq/l" +
       "kIKRSIdp/heFEJY7YhoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "U30mAAA=");
}
