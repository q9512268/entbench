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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "EnzwFsB/pCg+AIDHe+DFnu55wG/f+pZ6gvuHXgLuB4rKh8ElHOIWXn5dP3+L" +
       "to8XxUdOdH28jX0C78deArxXFZVfAa6nDuE99WLhfdW58M4eD50OPQWMoh4r" +
       "e/78LcD/UlH8dAJd1NIAWHLx9AsnuH/mpeIu1Goc4jZeVtwlpycYf/MWGD9Z" +
       "FL+aQHermhb0zsP5ay8V5+vBFR3ijF4enKfc9hdKgj+8BcRPFcXvgYVM8YOM" +
       "9BL/DMDff6kAHwXX04cAn/5/AvjpWwAsD0z+NIHuKXTYPR/kn70EkOX52deA" +
       "65lDkM+8/NZ6Xhy9U/Z9R5P2J6x/fwsB/FNR/FUC3auYmrLumpajHi2eP3oi" +
       "gr9+UWeyCfS6m3x7U3xF8OAN3/jtv0tTPv7c5Uuve27+x+XnJ8ffjt1FQZf0" +
       "jeOcPq08dX8xiDTdKqHctT+7DMq/LyTQq887wE6g20BZ8vwve8p/PwxypynB" +
       "Clz+n6b7T+DpJ3QgtO1vTpN8CYwOSMDtBSg4iqC3/jgJJEial5RyL6JreuFU" +
       "QnZoTaUGHvhyGjjucvqblSKJK7+8PEq4NvtvL68pn3huRH/T55sf3n8zozhS" +
       "nhejXKKgO/ef7xwnbW+86WhHY10cvuWL9/7EXU8cJZj37hk+sexTvD16/tcp" +
       "PTdIyu9J8p9/3c987Uee+3R5qvk/1K89GBIrAAA=");
}
