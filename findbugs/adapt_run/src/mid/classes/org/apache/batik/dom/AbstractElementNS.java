package org.apache.batik.dom;
public abstract class AbstractElementNS extends org.apache.batik.dom.AbstractElement {
    protected java.lang.String namespaceURI;
    protected AbstractElementNS() { super(); }
    protected AbstractElementNS(java.lang.String nsURI, java.lang.String qname,
                                org.apache.batik.dom.AbstractDocument owner)
          throws org.w3c.dom.DOMException { super(qname, owner);
                                            if (nsURI != null && nsURI.length(
                                                                         ) ==
                                                  0) { nsURI = null; }
                                            namespaceURI = nsURI;
                                            java.lang.String prefix = org.apache.batik.dom.util.DOMUtilities.
                                              getPrefix(
                                                qname);
                                            if (prefix != null) {
                                                if (nsURI ==
                                                      null ||
                                                      "xml".
                                                      equals(
                                                        prefix) &&
                                                      !org.apache.batik.dom.util.XMLSupport.
                                                         XML_NAMESPACE_URI.
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
        org.apache.batik.dom.AbstractElementNS ae =
          (org.apache.batik.dom.AbstractElementNS)
            n;
        ae.
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
        org.apache.batik.dom.AbstractElementNS ae =
          (org.apache.batik.dom.AbstractElementNS)
            n;
        ae.
          namespaceURI =
          namespaceURI;
        return n;
    }
    protected org.w3c.dom.Node copyInto(org.w3c.dom.Node n) {
        super.
          copyInto(
            n);
        org.apache.batik.dom.AbstractElementNS ae =
          (org.apache.batik.dom.AbstractElementNS)
            n;
        ae.
          namespaceURI =
          namespaceURI;
        return n;
    }
    protected org.w3c.dom.Node deepCopyInto(org.w3c.dom.Node n) {
        super.
          deepCopyInto(
            n);
        org.apache.batik.dom.AbstractElementNS ae =
          (org.apache.batik.dom.AbstractElementNS)
            n;
        ae.
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
