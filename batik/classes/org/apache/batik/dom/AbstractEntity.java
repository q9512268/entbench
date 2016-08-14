package org.apache.batik.dom;
public abstract class AbstractEntity extends org.apache.batik.dom.AbstractParentNode implements org.w3c.dom.Entity {
    protected java.lang.String nodeName;
    protected java.lang.String publicId;
    protected java.lang.String systemId;
    public short getNodeType() { return ENTITY_NODE; }
    public void setNodeName(java.lang.String v) { nodeName = v; }
    public java.lang.String getNodeName() { return nodeName; }
    public java.lang.String getPublicId() { return publicId; }
    public void setPublicId(java.lang.String id) { publicId = id; }
    public java.lang.String getSystemId() { return systemId; }
    public void setSystemId(java.lang.String id) { systemId = id; }
    public java.lang.String getNotationName() { return getNodeName(); }
    public void setNotationName(java.lang.String name) { setNodeName(name);
    }
    public java.lang.String getInputEncoding() { return null; }
    public java.lang.String getXmlEncoding() { return null; }
    public java.lang.String getXmlVersion() { return null; }
    protected org.w3c.dom.Node export(org.w3c.dom.Node n, org.apache.batik.dom.AbstractDocument d) {
        super.
          export(
            n,
            d);
        org.apache.batik.dom.AbstractEntity ae =
          (org.apache.batik.dom.AbstractEntity)
            n;
        ae.
          nodeName =
          nodeName;
        ae.
          publicId =
          publicId;
        ae.
          systemId =
          systemId;
        return n;
    }
    protected org.w3c.dom.Node deepExport(org.w3c.dom.Node n, org.apache.batik.dom.AbstractDocument d) {
        super.
          deepExport(
            n,
            d);
        org.apache.batik.dom.AbstractEntity ae =
          (org.apache.batik.dom.AbstractEntity)
            n;
        ae.
          nodeName =
          nodeName;
        ae.
          publicId =
          publicId;
        ae.
          systemId =
          systemId;
        return n;
    }
    protected org.w3c.dom.Node copyInto(org.w3c.dom.Node n) {
        super.
          copyInto(
            n);
        org.apache.batik.dom.AbstractEntity ae =
          (org.apache.batik.dom.AbstractEntity)
            n;
        ae.
          nodeName =
          nodeName;
        ae.
          publicId =
          publicId;
        ae.
          systemId =
          systemId;
        return n;
    }
    protected org.w3c.dom.Node deepCopyInto(org.w3c.dom.Node n) {
        super.
          deepCopyInto(
            n);
        org.apache.batik.dom.AbstractEntity ae =
          (org.apache.batik.dom.AbstractEntity)
            n;
        ae.
          nodeName =
          nodeName;
        ae.
          publicId =
          publicId;
        ae.
          systemId =
          systemId;
        return n;
    }
    protected void checkChildType(org.w3c.dom.Node n, boolean replace) {
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
    public AbstractEntity() { super(); }
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
       "DZ7PH3B+/vbgPInLF54pYXzwHIgfKkgb");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("LHA1P8hpL/bPAPz+WwVYuPKXDgC/9BYBZM4ByBWkH1fuL3TYuzFI4hZAlleZ" +
       "vh88bxxAvnH7rbVMPLPQunvh+46heiXIyTkC+MGCjEDIBg6v2T3TcvSj1fXJ" +
       "wHvhTa9JXXPLELR27TXo4h7nI9f9T8X+/wC0n33t8j3vfk3+V+VN4OO7+vdy" +
       "lXuWieOcvnZ36v1SEBpLqxTNvftLeEEJZxFX3nmjCBZX7gC0YPWCui9pHILg" +
       "6ZJgZV7+PV3OBA5+Ug5EtP3L6SKg3h2gSPHqBEeB9HvODaSCGoIwWgTebL/7" +
       "88hp+yknAm86ihxXOX1zuNjXKf/J5WgPJtn/m8uL2hdfYwY/8s3m5/Y3lzVH" +
       "3e2KVu7hKnfvL1GXjRb7OE/dtLWjti5Rz3/rgZ+797mjPacH9gyf2PIp3p64" +
       "8dXgvhvE5WXe3S+9+0s/8PnXfre8h/b/AThmqfJ9NAAA");
}
