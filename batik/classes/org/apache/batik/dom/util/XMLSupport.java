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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "A3dpTzZlFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/tnfkiIAAA==");
}
