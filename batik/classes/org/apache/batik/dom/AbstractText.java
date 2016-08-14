package org.apache.batik.dom;
public abstract class AbstractText extends org.apache.batik.dom.AbstractCharacterData implements org.w3c.dom.Text {
    public org.w3c.dom.Text splitText(int offset) throws org.w3c.dom.DOMException {
        if (isReadonly(
              )) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.node",
                    new java.lang.Object[] { new java.lang.Integer(
                      getNodeType(
                        )),
                    getNodeName(
                      ) });
        }
        java.lang.String v =
          getNodeValue(
            );
        if (offset <
              0 ||
              offset >=
              v.
              length(
                )) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      INDEX_SIZE_ERR,
                    "offset",
                    new java.lang.Object[] { new java.lang.Integer(
                      offset) });
        }
        org.w3c.dom.Node n =
          getParentNode(
            );
        if (n ==
              null) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      INDEX_SIZE_ERR,
                    "need.parent",
                    new java.lang.Object[] {  });
        }
        java.lang.String t1 =
          v.
          substring(
            offset);
        org.w3c.dom.Text t =
          createTextNode(
            t1);
        org.w3c.dom.Node ns =
          getNextSibling(
            );
        if (ns !=
              null) {
            n.
              insertBefore(
                t,
                ns);
        }
        else {
            n.
              appendChild(
                t);
        }
        setNodeValue(
          v.
            substring(
              0,
              offset));
        return t;
    }
    protected org.w3c.dom.Node getPreviousLogicallyAdjacentTextNode(org.w3c.dom.Node n) {
        org.w3c.dom.Node p =
          n.
          getPreviousSibling(
            );
        org.w3c.dom.Node parent =
          n.
          getParentNode(
            );
        while (p ==
                 null &&
                 parent !=
                 null &&
                 parent.
                 getNodeType(
                   ) ==
                 org.w3c.dom.Node.
                   ENTITY_REFERENCE_NODE) {
            p =
              parent;
            parent =
              p.
                getParentNode(
                  );
            p =
              p.
                getPreviousSibling(
                  );
        }
        while (p !=
                 null &&
                 p.
                 getNodeType(
                   ) ==
                 org.w3c.dom.Node.
                   ENTITY_REFERENCE_NODE) {
            p =
              p.
                getLastChild(
                  );
        }
        if (p ==
              null) {
            return null;
        }
        int nt =
          p.
          getNodeType(
            );
        if (nt ==
              org.w3c.dom.Node.
                TEXT_NODE ||
              nt ==
              org.w3c.dom.Node.
                CDATA_SECTION_NODE) {
            return p;
        }
        return null;
    }
    protected org.w3c.dom.Node getNextLogicallyAdjacentTextNode(org.w3c.dom.Node n) {
        org.w3c.dom.Node p =
          n.
          getNextSibling(
            );
        org.w3c.dom.Node parent =
          n.
          getParentNode(
            );
        while (p ==
                 null &&
                 parent !=
                 null &&
                 parent.
                 getNodeType(
                   ) ==
                 org.w3c.dom.Node.
                   ENTITY_REFERENCE_NODE) {
            p =
              parent;
            parent =
              p.
                getParentNode(
                  );
            p =
              p.
                getNextSibling(
                  );
        }
        while (p !=
                 null &&
                 p.
                 getNodeType(
                   ) ==
                 org.w3c.dom.Node.
                   ENTITY_REFERENCE_NODE) {
            p =
              p.
                getFirstChild(
                  );
        }
        if (p ==
              null) {
            return null;
        }
        int nt =
          p.
          getNodeType(
            );
        if (nt ==
              org.w3c.dom.Node.
                TEXT_NODE ||
              nt ==
              org.w3c.dom.Node.
                CDATA_SECTION_NODE) {
            return p;
        }
        return null;
    }
    public java.lang.String getWholeText() { java.lang.StringBuffer sb =
                                               new java.lang.StringBuffer(
                                               );
                                             for (org.w3c.dom.Node n =
                                                    this;
                                                  n !=
                                                    null;
                                                  n =
                                                    getPreviousLogicallyAdjacentTextNode(
                                                      n)) {
                                                 sb.
                                                   insert(
                                                     0,
                                                     n.
                                                       getNodeValue(
                                                         ));
                                             }
                                             for (org.w3c.dom.Node n =
                                                    getNextLogicallyAdjacentTextNode(
                                                      this);
                                                  n !=
                                                    null;
                                                  n =
                                                    getNextLogicallyAdjacentTextNode(
                                                      n)) {
                                                 sb.
                                                   append(
                                                     n.
                                                       getNodeValue(
                                                         ));
                                             }
                                             return sb.
                                               toString(
                                                 );
    }
    public boolean isElementContentWhitespace() {
        int len =
          nodeValue.
          length(
            );
        for (int i =
               0;
             i <
               len;
             i++) {
            if (!org.apache.batik.xml.XMLUtilities.
                  isXMLSpace(
                    nodeValue.
                      charAt(
                        i))) {
                return false;
            }
        }
        org.w3c.dom.Node p =
          getParentNode(
            );
        if (p.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                ELEMENT_NODE) {
            java.lang.String sp =
              org.apache.batik.dom.util.XMLSupport.
              getXMLSpace(
                (org.w3c.dom.Element)
                  p);
            return !sp.
              equals(
                org.apache.batik.util.XMLConstants.
                  XML_PRESERVE_VALUE);
        }
        return true;
    }
    public org.w3c.dom.Text replaceWholeText(java.lang.String s)
          throws org.w3c.dom.DOMException {
        for (org.w3c.dom.Node n =
               getPreviousLogicallyAdjacentTextNode(
                 this);
             n !=
               null;
             n =
               getPreviousLogicallyAdjacentTextNode(
                 n)) {
            org.apache.batik.dom.AbstractNode an =
              (org.apache.batik.dom.AbstractNode)
                n;
            if (an.
                  isReadonly(
                    )) {
                throw createDOMException(
                        org.w3c.dom.DOMException.
                          NO_MODIFICATION_ALLOWED_ERR,
                        "readonly.node",
                        new java.lang.Object[] { new java.lang.Integer(
                          n.
                            getNodeType(
                              )),
                        n.
                          getNodeName(
                            ) });
            }
        }
        for (org.w3c.dom.Node n =
               getNextLogicallyAdjacentTextNode(
                 this);
             n !=
               null;
             n =
               getNextLogicallyAdjacentTextNode(
                 n)) {
            org.apache.batik.dom.AbstractNode an =
              (org.apache.batik.dom.AbstractNode)
                n;
            if (an.
                  isReadonly(
                    )) {
                throw createDOMException(
                        org.w3c.dom.DOMException.
                          NO_MODIFICATION_ALLOWED_ERR,
                        "readonly.node",
                        new java.lang.Object[] { new java.lang.Integer(
                          n.
                            getNodeType(
                              )),
                        n.
                          getNodeName(
                            ) });
            }
        }
        org.w3c.dom.Node parent =
          getParentNode(
            );
        for (org.w3c.dom.Node n =
               getPreviousLogicallyAdjacentTextNode(
                 this);
             n !=
               null;
             n =
               getPreviousLogicallyAdjacentTextNode(
                 n)) {
            parent.
              removeChild(
                n);
        }
        for (org.w3c.dom.Node n =
               getNextLogicallyAdjacentTextNode(
                 this);
             n !=
               null;
             n =
               getNextLogicallyAdjacentTextNode(
                 n)) {
            parent.
              removeChild(
                n);
        }
        if (isReadonly(
              )) {
            org.w3c.dom.Text t =
              createTextNode(
                s);
            parent.
              replaceChild(
                t,
                this);
            return t;
        }
        setNodeValue(
          s);
        return this;
    }
    public java.lang.String getTextContent() {
        if (isElementContentWhitespace(
              )) {
            return "";
        }
        return getNodeValue(
                 );
    }
    protected abstract org.w3c.dom.Text createTextNode(java.lang.String text);
    public AbstractText() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "e2k3dbMu9myieJjF8u/iE4t//AdKL2FgLR0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
