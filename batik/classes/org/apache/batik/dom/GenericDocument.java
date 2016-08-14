package org.apache.batik.dom;
public class GenericDocument extends org.apache.batik.dom.AbstractDocument {
    protected static final java.lang.String ATTR_ID = org.apache.batik.util.XMLConstants.
                                                        XML_ID_ATTRIBUTE;
    protected boolean readonly;
    protected GenericDocument() { super(); }
    public GenericDocument(org.w3c.dom.DocumentType dt, org.w3c.dom.DOMImplementation impl) {
        super(
          dt,
          impl);
    }
    public boolean isReadonly() { return readonly; }
    public void setReadonly(boolean v) { readonly = v; }
    public boolean isId(org.w3c.dom.Attr node) { if (node.
                                                       getNamespaceURI(
                                                         ) !=
                                                       null)
                                                     return false;
                                                 return ATTR_ID.
                                                   equals(
                                                     node.
                                                       getNodeName(
                                                         ));
    }
    public org.w3c.dom.Element createElement(java.lang.String tagName)
          throws org.w3c.dom.DOMException { return new org.apache.batik.dom.GenericElement(
                                              tagName.
                                                intern(
                                                  ),
                                              this);
    }
    public org.w3c.dom.DocumentFragment createDocumentFragment() {
        return new org.apache.batik.dom.GenericDocumentFragment(
          this);
    }
    public org.w3c.dom.Text createTextNode(java.lang.String data) {
        return new org.apache.batik.dom.GenericText(
          data,
          this);
    }
    public org.w3c.dom.Comment createComment(java.lang.String data) {
        return new org.apache.batik.dom.GenericComment(
          data,
          this);
    }
    public org.w3c.dom.CDATASection createCDATASection(java.lang.String data)
          throws org.w3c.dom.DOMException { return new org.apache.batik.dom.GenericCDATASection(
                                              data,
                                              this);
    }
    public org.w3c.dom.ProcessingInstruction createProcessingInstruction(java.lang.String target,
                                                                         java.lang.String data)
          throws org.w3c.dom.DOMException {
        return new org.apache.batik.dom.GenericProcessingInstruction(
          target,
          data,
          this);
    }
    public org.w3c.dom.Attr createAttribute(java.lang.String name)
          throws org.w3c.dom.DOMException {
        return new org.apache.batik.dom.GenericAttr(
          name.
            intern(
              ),
          this);
    }
    public org.w3c.dom.EntityReference createEntityReference(java.lang.String name)
          throws org.w3c.dom.DOMException {
        return new org.apache.batik.dom.GenericEntityReference(
          name,
          this);
    }
    public org.w3c.dom.Element createElementNS(java.lang.String namespaceURI,
                                               java.lang.String qualifiedName)
          throws org.w3c.dom.DOMException {
        if (namespaceURI !=
              null &&
              namespaceURI.
              length(
                ) ==
              0) {
            namespaceURI =
              null;
        }
        if (namespaceURI ==
              null) {
            return new org.apache.batik.dom.GenericElement(
              qualifiedName.
                intern(
                  ),
              this);
        }
        else {
            return new org.apache.batik.dom.GenericElementNS(
              namespaceURI.
                intern(
                  ),
              qualifiedName.
                intern(
                  ),
              this);
        }
    }
    public org.w3c.dom.Attr createAttributeNS(java.lang.String namespaceURI,
                                              java.lang.String qualifiedName)
          throws org.w3c.dom.DOMException {
        if (namespaceURI !=
              null &&
              namespaceURI.
              length(
                ) ==
              0) {
            namespaceURI =
              null;
        }
        if (namespaceURI ==
              null) {
            return new org.apache.batik.dom.GenericAttr(
              qualifiedName.
                intern(
                  ),
              this);
        }
        else {
            return new org.apache.batik.dom.GenericAttrNS(
              namespaceURI.
                intern(
                  ),
              qualifiedName.
                intern(
                  ),
              this);
        }
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.GenericDocument(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "D//jBgUqHPNNopEz7efIW194uvHj3y3aH3vIvPVz2Y3zFghhj9tWfsH7k4OX" +
       "zv/GAXRhDl1W9/GxJLtp7nfmICaMD4NmEEOfqj8d3+2CmWtHM8AzZ73zic+e" +
       "9c3H8yV4zqnz5wfOuOMP5FLuglTe6075rDKeAyp3YGn5i3Bznbwnf/wRoJhx" +
       "EYknoBuWL7t7Bf0z8DsH0v/NU848L9iFLo829vHTC0cBVAim9guUKA6vM/Sh" +
       "/l0ujDOXx9VdvHtsH4VCDe6kUOzp2ed5kGp7uLUb4ELFw8duYX4F1EKGkwS6" +
       "P9JlLfDdze0VU4gsD0xGq32Yi7z26LedL/zRV3Yh7FktPEOsf/KNT/3Z1U+/" +
       "cXBi4fDyDbH7yTa7xUPRxYeKfuY+8cXbfaVo0frDr772q3//tU/sevXo6TC4" +
       "CVZ5X/m3/+e3r37+O791k1jsghIEri77Z8bl+h3HZde/XMPuq1zFr5byd+82" +
       "SvZjeTbOM+lwDJ60XfXKoR5JYN0HTPyK7eJ59fxMhyY/dIeAyB4+1rpeANZY" +
       "P/MfP/Pbf+vlbwP4Xei+VW6qQE4nVJNP82Xn33jrs8++743v/EwRHwB9kf7m" +
       "L+Pfybkm7wzW0zmsURFY9+Q44Yr5XNdyZAUL9QSeRQKiguAGs/jh0SaPPNPB" +
       "YoY6/PUkWa+s1WzoGf0tYifVypQYpV1sPXCpIVGnHKnPzqo2VloJNDH2WpSO" +
       "4f0Kj4/RimbruIrMqrK2pMpd1mMX0pJhyw3ECcbWoluXJq48lqiBvPAazKoZ" +
       "uA12UQuFzZhx5VqDT2qGwQsesiKDdaS0/U6t6q88kHgcqa480jP0gB57vSBk" +
       "SsuoK/AyLwZ4azqLWUrhecduYLOs4UsZYWAWJsPoyuYxcW6N7bAtj9TmrElN" +
       "aNJxx6IZ2mFLGtGNWcDY4zY7rlhZVO/Tcig0xtnIFdsbiWYtUD4ZMg6/bHos" +
       "ZcdNYaws6+q8xM5bHt8Oy+umGdHt2QgT+11NSJW0wjojd1RuSzpRGgk6VnHr" +
       "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" +
       "WkqaFLHcrxyDfeQuwBZXIUogfWEP9gvv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("EdgX7wT25Tx7JoEe38+PfmIlm6N7eIdK8IFT8+RNaAqJPHu3rvIlkL68l8iX" +
       "30sLOXt37Aax5BfIzr1ypAP70IAf5RS/cYwYvluFzx3D1/eIv/5eIr52J8T5" +
       "yvJcDSwnz2j9DvMJvcfvdpTz+2jf2GP+xjvF/CN3iorOtW9Tx+RZPYEu+Pr6" +
       "lvP/UUUBt/GOrpABjTlzLzi/4fjUDf9nsLsbr/7im5fuf/LN8b8rrsYe3V+/" +
       "2IPuN1LXPXmp6sTz+TDSDauQw8XdFauwADdMoPff7KZyAt0D8ryv5wY7yvEe" +
       "8UnKBLqv+HuSbgoWicd0CXR+93CS5CcAd0CSP/5keCjOD970wjSlgClDVpND" +
       "yWS7EP6pk6pSzLSP3knkJ3YdXj61V1D828fhuj7d/ePHdfWrb3b5n/p+7cu7" +
       "i7yqK2+3OZf7e9CF3Z3igmm+N/DiLbkd8jrf+fAPHv6lix883Md4eNfhY7U9" +
       "0bfnb35ltumFSXHJdfuPnvyHH/l7b/5BcYHn/wENgBomjzMAAA==");
}
