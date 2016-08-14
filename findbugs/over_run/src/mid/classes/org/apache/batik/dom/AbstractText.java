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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "z8KmJniu2/ZfL+B6ziOAqFzj26HqCmi8U2CcLwDLr7H4BcAiGQyOul6W9UTE" +
       "G+OHJQX05b1AwiPTjKw7auteVXp5rLps+tjmd8UlRvrusxIyxHhSUTy5jTfP" +
       "KdENFrciu9I6Veri6yInU3PdZ0GuBaUw93eW5GV7//ZKclIsvr1y73JS4cpx" +
       "UmK9eEWugnYQwddrukPVTQWv1Vr6KX4xYw3lNBXIPiEK6KfdCfp0F+/lCKbH" +
       "4n8DJ4NMWv8cQKo+trH9iZsPv2hdzkgKHREJyUTIG60roPQJaF5ebY6ukg0L" +
       "b096pXy+k85mXA55bRMRATEpLlJm+m4rzMb0pcWV4yvOvrOv5BIk4ltJgHIy" +
       "Zavn1t66om5O6Uk4nm2N5MqQ4XwoLlKaK65vu/DPq4FacfomVk5dX6hHr3To" +
       "7LXOuK6/ECTlraQYsnWW6iEVsrlmWO1i0qCRkXCXRLWkmv6LYRKGLMXNWCBj" +
       "A1qVrsV7O04aso8U2XeZFYo2xIzVqB3VVPnOjEld97YKZGPWbodIQxT2Rtp0" +
       "3b7OKjoskNd1sSb/Ifa7/wHuiyqTHBwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
