package org.apache.xalan.templates;
public class ElemCopyOf extends org.apache.xalan.templates.ElemTemplateElement {
    static final long serialVersionUID = -7433828829497411127L;
    public org.apache.xpath.XPath m_selectExpression = null;
    public void setSelect(org.apache.xpath.XPath expr) { m_selectExpression =
                                                           expr; }
    public org.apache.xpath.XPath getSelect() { return m_selectExpression;
    }
    public void compose(org.apache.xalan.templates.StylesheetRoot sroot) throws javax.xml.transform.TransformerException {
        super.
          compose(
            sroot);
        org.apache.xalan.templates.StylesheetRoot.ComposeState cstate =
          sroot.
          getComposeState(
            );
        m_selectExpression.
          fixupVariables(
            cstate.
              getVariableNames(
                ),
            cstate.
              getGlobalsSize(
                ));
    }
    public int getXSLToken() { return org.apache.xalan.templates.Constants.
                                        ELEMNAME_COPY_OF; }
    public java.lang.String getNodeName() { return org.apache.xalan.templates.Constants.
                                                     ELEMNAME_COPY_OF_STRING;
    }
    public void execute(org.apache.xalan.transformer.TransformerImpl transformer)
          throws javax.xml.transform.TransformerException {
        if (transformer.
              getDebug(
                ))
            transformer.
              getTraceManager(
                ).
              fireTraceEvent(
                this);
        try {
            org.apache.xpath.XPathContext xctxt =
              transformer.
              getXPathContext(
                );
            int sourceNode =
              xctxt.
              getCurrentNode(
                );
            org.apache.xpath.objects.XObject value =
              m_selectExpression.
              execute(
                xctxt,
                sourceNode,
                this);
            if (transformer.
                  getDebug(
                    ))
                transformer.
                  getTraceManager(
                    ).
                  fireSelectedEvent(
                    sourceNode,
                    this,
                    "select",
                    m_selectExpression,
                    value);
            org.apache.xml.serializer.SerializationHandler handler =
              transformer.
              getSerializationHandler(
                );
            if (null !=
                  value) {
                int type =
                  value.
                  getType(
                    );
                java.lang.String s;
                switch (type) {
                    case org.apache.xpath.objects.XObject.
                           CLASS_BOOLEAN:
                    case org.apache.xpath.objects.XObject.
                           CLASS_NUMBER:
                    case org.apache.xpath.objects.XObject.
                           CLASS_STRING:
                        s =
                          value.
                            str(
                              );
                        handler.
                          characters(
                            s.
                              toCharArray(
                                ),
                            0,
                            s.
                              length(
                                ));
                        break;
                    case org.apache.xpath.objects.XObject.
                           CLASS_NODESET:
                        org.apache.xml.dtm.DTMIterator nl =
                          value.
                          iter(
                            );
                        org.apache.xml.dtm.ref.DTMTreeWalker tw =
                          new org.apache.xalan.transformer.TreeWalker2Result(
                          transformer,
                          handler);
                        int pos;
                        while (org.apache.xml.dtm.DTM.
                                 NULL !=
                                 (pos =
                                    nl.
                                      nextNode(
                                        ))) {
                            org.apache.xml.dtm.DTM dtm =
                              xctxt.
                              getDTMManager(
                                ).
                              getDTM(
                                pos);
                            short t =
                              dtm.
                              getNodeType(
                                pos);
                            if (t ==
                                  org.apache.xml.dtm.DTM.
                                    DOCUMENT_NODE) {
                                for (int child =
                                       dtm.
                                       getFirstChild(
                                         pos);
                                     child !=
                                       org.apache.xml.dtm.DTM.
                                         NULL;
                                     child =
                                       dtm.
                                         getNextSibling(
                                           child)) {
                                    tw.
                                      traverse(
                                        child);
                                }
                            }
                            else
                                if (t ==
                                      org.apache.xml.dtm.DTM.
                                        ATTRIBUTE_NODE) {
                                    org.apache.xalan.serialize.SerializerUtils.
                                      addAttribute(
                                        handler,
                                        pos);
                                }
                                else {
                                    tw.
                                      traverse(
                                        pos);
                                }
                        }
                        break;
                    case org.apache.xpath.objects.XObject.
                           CLASS_RTREEFRAG:
                        org.apache.xalan.serialize.SerializerUtils.
                          outputResultTreeFragment(
                            handler,
                            value,
                            transformer.
                              getXPathContext(
                                ));
                        break;
                    default:
                        s =
                          value.
                            str(
                              );
                        handler.
                          characters(
                            s.
                              toCharArray(
                                ),
                            0,
                            s.
                              length(
                                ));
                        break;
                }
            }
        }
        catch (org.xml.sax.SAXException se) {
            throw new javax.xml.transform.TransformerException(
              se);
        }
        finally {
            if (transformer.
                  getDebug(
                    ))
                transformer.
                  getTraceManager(
                    ).
                  fireTraceEndEvent(
                    this);
        }
    }
    public org.apache.xalan.templates.ElemTemplateElement appendChild(org.apache.xalan.templates.ElemTemplateElement newChild) {
        error(
          org.apache.xalan.res.XSLTErrorResources.
            ER_CANNOT_ADD,
          new java.lang.Object[] { newChild.
            getNodeName(
              ),
          this.
            getNodeName(
              ) });
        return null;
    }
    protected void callChildVisitors(org.apache.xalan.templates.XSLTVisitor visitor,
                                     boolean callAttrs) {
        if (callAttrs)
            m_selectExpression.
              getExpression(
                ).
              callVisitors(
                m_selectExpression,
                visitor);
        super.
          callChildVisitors(
            visitor,
            callAttrs);
    }
    public ElemCopyOf() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "lmfdfwGVPv5Jyh8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8fk3/73v+pmXfrs6gP+/9Wl8gkgrAAA=");
}
