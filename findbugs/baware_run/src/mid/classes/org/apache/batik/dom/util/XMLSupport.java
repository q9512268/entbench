package org.apache.batik.dom.util;
public final class XMLSupport implements org.apache.batik.util.XMLConstants {
    private XMLSupport() { super(); }
    public static java.lang.String getXMLLang(org.w3c.dom.Element elt) { org.w3c.dom.Attr attr =
                                                                           elt.
                                                                           getAttributeNodeNS(
                                                                             XML_NAMESPACE_URI,
                                                                             "lang");
                                                                         if (attr !=
                                                                               null) {
                                                                             return attr.
                                                                               getNodeValue(
                                                                                 );
                                                                         }
                                                                         for (org.w3c.dom.Node n =
                                                                                elt.
                                                                                getParentNode(
                                                                                  );
                                                                              n !=
                                                                                null;
                                                                              n =
                                                                                n.
                                                                                  getParentNode(
                                                                                    )) {
                                                                             if (n.
                                                                                   getNodeType(
                                                                                     ) ==
                                                                                   org.w3c.dom.Node.
                                                                                     ELEMENT_NODE) {
                                                                                 attr =
                                                                                   ((org.w3c.dom.Element)
                                                                                      n).
                                                                                     getAttributeNodeNS(
                                                                                       XML_NAMESPACE_URI,
                                                                                       "lang");
                                                                                 if (attr !=
                                                                                       null) {
                                                                                     return attr.
                                                                                       getNodeValue(
                                                                                         );
                                                                                 }
                                                                             }
                                                                         }
                                                                         return "en";
    }
    public static java.lang.String getXMLSpace(org.w3c.dom.Element elt) {
        org.w3c.dom.Attr attr =
          elt.
          getAttributeNodeNS(
            XML_NAMESPACE_URI,
            "space");
        if (attr !=
              null) {
            return attr.
              getNodeValue(
                );
        }
        for (org.w3c.dom.Node n =
               elt.
               getParentNode(
                 );
             n !=
               null;
             n =
               n.
                 getParentNode(
                   )) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                attr =
                  ((org.w3c.dom.Element)
                     n).
                    getAttributeNodeNS(
                      XML_NAMESPACE_URI,
                      "space");
                if (attr !=
                      null) {
                    return attr.
                      getNodeValue(
                        );
                }
            }
        }
        return "default";
    }
    public static java.lang.String defaultXMLSpace(java.lang.String data) {
        int nChars =
          data.
          length(
            );
        java.lang.StringBuffer result =
          new java.lang.StringBuffer(
          nChars);
        boolean space =
          false;
        for (int i =
               0;
             i <
               nChars;
             i++) {
            char c =
              data.
              charAt(
                i);
            switch (c) {
                case 10:
                case 13:
                    space =
                      false;
                    break;
                case ' ':
                case '\t':
                    if (!space) {
                        result.
                          append(
                            ' ');
                        space =
                          true;
                    }
                    break;
                default:
                    result.
                      append(
                        c);
                    space =
                      false;
            }
        }
        return result.
          toString(
            ).
          trim(
            );
    }
    public static java.lang.String preserveXMLSpace(java.lang.String data) {
        int nChars =
          data.
          length(
            );
        java.lang.StringBuffer result =
          new java.lang.StringBuffer(
          nChars);
        for (int i =
               0;
             i <
               data.
               length(
                 );
             i++) {
            char c =
              data.
              charAt(
                i);
            switch (c) {
                case 10:
                case 13:
                case '\t':
                    result.
                      append(
                        ' ');
                    break;
                default:
                    result.
                      append(
                        c);
            }
        }
        return result.
          toString(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "T5gWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "atZ/+Jrff9PvPPeN7OD3fwGHM5HobiIAAA==");
}
