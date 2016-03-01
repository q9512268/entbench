package org.apache.batik.dom;
public abstract class AbstractEntityReference extends org.apache.batik.dom.AbstractParentChildNode implements org.w3c.dom.EntityReference {
    protected java.lang.String nodeName;
    protected AbstractEntityReference() { super(); }
    protected AbstractEntityReference(java.lang.String name, org.apache.batik.dom.AbstractDocument owner)
          throws org.w3c.dom.DOMException { super();
                                            ownerDocument = owner;
                                            if (owner.getStrictErrorChecking(
                                                        ) && !org.apache.batik.dom.util.DOMUtilities.
                                                  isValidName(
                                                    name)) {
                                                throw createDOMException(
                                                        org.w3c.dom.DOMException.
                                                          INVALID_CHARACTER_ERR,
                                                        "xml.name",
                                                        new java.lang.Object[] { name });
                                            }
                                            nodeName =
                                              name;
    }
    public short getNodeType() { return ENTITY_REFERENCE_NODE;
    }
    public void setNodeName(java.lang.String v) {
        nodeName =
          v;
    }
    public java.lang.String getNodeName() {
        return nodeName;
    }
    protected org.w3c.dom.Node export(org.w3c.dom.Node n,
                                      org.apache.batik.dom.AbstractDocument d) {
        super.
          export(
            n,
            d);
        org.apache.batik.dom.AbstractEntityReference ae =
          (org.apache.batik.dom.AbstractEntityReference)
            n;
        ae.
          nodeName =
          nodeName;
        return n;
    }
    protected org.w3c.dom.Node deepExport(org.w3c.dom.Node n,
                                          org.apache.batik.dom.AbstractDocument d) {
        super.
          deepExport(
            n,
            d);
        org.apache.batik.dom.AbstractEntityReference ae =
          (org.apache.batik.dom.AbstractEntityReference)
            n;
        ae.
          nodeName =
          nodeName;
        return n;
    }
    protected org.w3c.dom.Node copyInto(org.w3c.dom.Node n) {
        super.
          copyInto(
            n);
        org.apache.batik.dom.AbstractEntityReference ae =
          (org.apache.batik.dom.AbstractEntityReference)
            n;
        ae.
          nodeName =
          nodeName;
        return n;
    }
    protected org.w3c.dom.Node deepCopyInto(org.w3c.dom.Node n) {
        super.
          deepCopyInto(
            n);
        org.apache.batik.dom.AbstractEntityReference ae =
          (org.apache.batik.dom.AbstractEntityReference)
            n;
        ae.
          nodeName =
          nodeName;
        return n;
    }
    protected void checkChildType(org.w3c.dom.Node n,
                                  boolean replace) {
        switch (n.
                  getNodeType(
                    )) {
            case ELEMENT_NODE:
            case PROCESSING_INSTRUCTION_NODE:
            case COMMENT_NODE:
            case TEXT_NODE:
            case CDATA_SECTION_NODE:
            case ENTITY_REFERENCE_NODE:
            case DOCUMENT_FRAGMENT_NODE:
                break;
            default:
                throw createDOMException(
                        org.w3c.dom.DOMException.
                          HIERARCHY_REQUEST_ERR,
                        "child.type",
                        new java.lang.Object[] { new java.lang.Integer(
                          getNodeType(
                            )),
                        getNodeName(
                          ),
                        new java.lang.Integer(
                          n.
                            getNodeType(
                              )),
                        n.
                          getNodeName(
                            ) });
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "h+FQm6ZZfUnBHi55TUMH9ZXzAPEffqpKGF4fAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
