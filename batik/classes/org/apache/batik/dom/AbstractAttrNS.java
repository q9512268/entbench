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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Zjey6z942ade/TvPfC27Dvh/iuRW3DkmAAA=");
}
