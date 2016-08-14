package org.apache.batik.dom;
public abstract class AbstractAttrNS extends org.apache.batik.dom.AbstractAttr {
    protected java.lang.String namespaceURI;
    protected AbstractAttrNS() { super(); }
    protected AbstractAttrNS(java.lang.String nsURI, java.lang.String qname,
                             org.apache.batik.dom.AbstractDocument owner)
          throws org.w3c.dom.DOMException { super(qname, owner);
                                            if (nsURI != null && nsURI.length(
                                                                         ) ==
                                                  0) { nsURI = null; }
                                            namespaceURI = nsURI;
                                            java.lang.String prefix = org.apache.batik.dom.util.DOMUtilities.
                                              getPrefix(
                                                qname);
                                            if (!owner.getStrictErrorChecking(
                                                         )) { return;
                                            }
                                            if (prefix != null) {
                                                if (nsURI ==
                                                      null ||
                                                      "xml".
                                                      equals(
                                                        prefix) &&
                                                      !org.apache.batik.dom.util.XMLSupport.
                                                         XML_NAMESPACE_URI.
                                                      equals(
                                                        nsURI) ||
                                                      "xmlns".
                                                      equals(
                                                        prefix) &&
                                                      !org.apache.batik.dom.util.XMLSupport.
                                                         XMLNS_NAMESPACE_URI.
                                                      equals(
                                                        nsURI)) {
                                                    throw createDOMException(
                                                            org.w3c.dom.DOMException.
                                                              NAMESPACE_ERR,
                                                            "namespace.uri",
                                                            new java.lang.Object[] { new java.lang.Integer(
                                                              getNodeType(
                                                                )),
                                                            getNodeName(
                                                              ),
                                                            nsURI });
                                                }
                                            }
                                            else
                                                if ("xmlns".
                                                      equals(
                                                        qname) &&
                                                      !org.apache.batik.dom.util.XMLSupport.
                                                         XMLNS_NAMESPACE_URI.
                                                      equals(
                                                        nsURI)) {
                                                    throw createDOMException(
                                                            org.w3c.dom.DOMException.
                                                              NAMESPACE_ERR,
                                                            "namespace.uri",
                                                            new java.lang.Object[] { new java.lang.Integer(
                                                              getNodeType(
                                                                )),
                                                            getNodeName(
                                                              ),
                                                            nsURI });
                                                }
    }
    public java.lang.String getNamespaceURI() {
        return namespaceURI;
    }
    protected org.w3c.dom.Node export(org.w3c.dom.Node n,
                                      org.apache.batik.dom.AbstractDocument d) {
        super.
          export(
            n,
            d);
        org.apache.batik.dom.AbstractAttrNS aa =
          (org.apache.batik.dom.AbstractAttrNS)
            n;
        aa.
          namespaceURI =
          namespaceURI;
        return n;
    }
    protected org.w3c.dom.Node deepExport(org.w3c.dom.Node n,
                                          org.apache.batik.dom.AbstractDocument d) {
        super.
          deepExport(
            n,
            d);
        org.apache.batik.dom.AbstractAttrNS aa =
          (org.apache.batik.dom.AbstractAttrNS)
            n;
        aa.
          namespaceURI =
          namespaceURI;
        return n;
    }
    protected org.w3c.dom.Node copyInto(org.w3c.dom.Node n) {
        super.
          copyInto(
            n);
        org.apache.batik.dom.AbstractAttrNS aa =
          (org.apache.batik.dom.AbstractAttrNS)
            n;
        aa.
          namespaceURI =
          namespaceURI;
        return n;
    }
    protected org.w3c.dom.Node deepCopyInto(org.w3c.dom.Node n) {
        super.
          deepCopyInto(
            n);
        org.apache.batik.dom.AbstractAttrNS aa =
          (org.apache.batik.dom.AbstractAttrNS)
            n;
        aa.
          namespaceURI =
          namespaceURI;
        return n;
    }
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
      ("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");
}
