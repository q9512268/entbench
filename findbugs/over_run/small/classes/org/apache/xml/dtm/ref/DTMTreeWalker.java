package org.apache.xml.dtm.ref;
public class DTMTreeWalker {
    private org.xml.sax.ContentHandler m_contentHandler = null;
    protected org.apache.xml.dtm.DTM m_dtm;
    public void setDTM(org.apache.xml.dtm.DTM dtm) { m_dtm = dtm; }
    public org.xml.sax.ContentHandler getcontentHandler() { return m_contentHandler;
    }
    public void setcontentHandler(org.xml.sax.ContentHandler ch) {
        m_contentHandler =
          ch;
    }
    public DTMTreeWalker() { super(); }
    public DTMTreeWalker(org.xml.sax.ContentHandler contentHandler,
                         org.apache.xml.dtm.DTM dtm) { super();
                                                       this.m_contentHandler =
                                                         contentHandler;
                                                       m_dtm = dtm;
    }
    public void traverse(int pos) throws org.xml.sax.SAXException {
        int top =
          pos;
        while (org.apache.xml.dtm.DTM.
                 NULL !=
                 pos) {
            startNode(
              pos);
            int nextNode =
              m_dtm.
              getFirstChild(
                pos);
            while (org.apache.xml.dtm.DTM.
                     NULL ==
                     nextNode) {
                endNode(
                  pos);
                if (top ==
                      pos)
                    break;
                nextNode =
                  m_dtm.
                    getNextSibling(
                      pos);
                if (org.apache.xml.dtm.DTM.
                      NULL ==
                      nextNode) {
                    pos =
                      m_dtm.
                        getParent(
                          pos);
                    if (org.apache.xml.dtm.DTM.
                          NULL ==
                          pos ||
                          top ==
                          pos) {
                        if (org.apache.xml.dtm.DTM.
                              NULL !=
                              pos)
                            endNode(
                              pos);
                        nextNode =
                          org.apache.xml.dtm.DTM.
                            NULL;
                        break;
                    }
                }
            }
            pos =
              nextNode;
        }
    }
    public void traverse(int pos, int top) throws org.xml.sax.SAXException {
        while (org.apache.xml.dtm.DTM.
                 NULL !=
                 pos) {
            startNode(
              pos);
            int nextNode =
              m_dtm.
              getFirstChild(
                pos);
            while (org.apache.xml.dtm.DTM.
                     NULL ==
                     nextNode) {
                endNode(
                  pos);
                if (org.apache.xml.dtm.DTM.
                      NULL !=
                      top &&
                      top ==
                      pos)
                    break;
                nextNode =
                  m_dtm.
                    getNextSibling(
                      pos);
                if (org.apache.xml.dtm.DTM.
                      NULL ==
                      nextNode) {
                    pos =
                      m_dtm.
                        getParent(
                          pos);
                    if (org.apache.xml.dtm.DTM.
                          NULL ==
                          pos ||
                          org.apache.xml.dtm.DTM.
                            NULL !=
                          top &&
                          top ==
                          pos) {
                        nextNode =
                          org.apache.xml.dtm.DTM.
                            NULL;
                        break;
                    }
                }
            }
            pos =
              nextNode;
        }
    }
    boolean nextIsRaw = false;
    private final void dispatachChars(int node) throws org.xml.sax.SAXException {
        m_dtm.
          dispatchCharactersEvents(
            node,
            m_contentHandler,
            false);
    }
    protected void startNode(int node) throws org.xml.sax.SAXException {
        if (m_contentHandler instanceof org.apache.xml.utils.NodeConsumer) {
            
        }
        switch (m_dtm.
                  getNodeType(
                    node)) {
            case org.apache.xml.dtm.DTM.
                   COMMENT_NODE:
                {
                    org.apache.xml.utils.XMLString data =
                      m_dtm.
                      getStringValue(
                        node);
                    if (m_contentHandler instanceof org.xml.sax.ext.LexicalHandler) {
                        org.xml.sax.ext.LexicalHandler lh =
                          (org.xml.sax.ext.LexicalHandler)
                            this.
                              m_contentHandler;
                        data.
                          dispatchAsComment(
                            lh);
                    }
                }
                break;
            case org.apache.xml.dtm.DTM.
                   DOCUMENT_FRAGMENT_NODE:
                break;
            case org.apache.xml.dtm.DTM.
                   DOCUMENT_NODE:
                this.
                  m_contentHandler.
                  startDocument(
                    );
                break;
            case org.apache.xml.dtm.DTM.
                   ELEMENT_NODE:
                org.apache.xml.dtm.DTM dtm =
                  m_dtm;
                for (int nsn =
                       dtm.
                       getFirstNamespaceNode(
                         node,
                         true);
                     org.apache.xml.dtm.DTM.
                       NULL !=
                       nsn;
                     nsn =
                       dtm.
                         getNextNamespaceNode(
                           node,
                           nsn,
                           true)) {
                    java.lang.String prefix =
                      dtm.
                      getNodeNameX(
                        nsn);
                    this.
                      m_contentHandler.
                      startPrefixMapping(
                        prefix,
                        dtm.
                          getNodeValue(
                            nsn));
                }
                java.lang.String ns =
                  dtm.
                  getNamespaceURI(
                    node);
                if (null ==
                      ns)
                    ns =
                      "";
                org.xml.sax.helpers.AttributesImpl attrs =
                  new org.xml.sax.helpers.AttributesImpl(
                  );
                for (int i =
                       dtm.
                       getFirstAttribute(
                         node);
                     i !=
                       org.apache.xml.dtm.DTM.
                         NULL;
                     i =
                       dtm.
                         getNextAttribute(
                           i)) {
                    attrs.
                      addAttribute(
                        dtm.
                          getNamespaceURI(
                            i),
                        dtm.
                          getLocalName(
                            i),
                        dtm.
                          getNodeName(
                            i),
                        "CDATA",
                        dtm.
                          getNodeValue(
                            i));
                }
                this.
                  m_contentHandler.
                  startElement(
                    ns,
                    m_dtm.
                      getLocalName(
                        node),
                    m_dtm.
                      getNodeName(
                        node),
                    attrs);
                break;
            case org.apache.xml.dtm.DTM.
                   PROCESSING_INSTRUCTION_NODE:
                {
                    java.lang.String name =
                      m_dtm.
                      getNodeName(
                        node);
                    if (name.
                          equals(
                            "xslt-next-is-raw")) {
                        nextIsRaw =
                          true;
                    }
                    else {
                        this.
                          m_contentHandler.
                          processingInstruction(
                            name,
                            m_dtm.
                              getNodeValue(
                                node));
                    }
                }
                break;
            case org.apache.xml.dtm.DTM.
                   CDATA_SECTION_NODE:
                {
                    boolean isLexH =
                      m_contentHandler instanceof org.xml.sax.ext.LexicalHandler;
                    org.xml.sax.ext.LexicalHandler lh =
                      isLexH
                      ? (org.xml.sax.ext.LexicalHandler)
                          this.
                            m_contentHandler
                      : null;
                    if (isLexH) {
                        lh.
                          startCDATA(
                            );
                    }
                    dispatachChars(
                      node);
                    {
                        if (isLexH) {
                            lh.
                              endCDATA(
                                );
                        }
                    }
                }
                break;
            case org.apache.xml.dtm.DTM.
                   TEXT_NODE:
                {
                    if (nextIsRaw) {
                        nextIsRaw =
                          false;
                        m_contentHandler.
                          processingInstruction(
                            javax.xml.transform.Result.
                              PI_DISABLE_OUTPUT_ESCAPING,
                            "");
                        dispatachChars(
                          node);
                        m_contentHandler.
                          processingInstruction(
                            javax.xml.transform.Result.
                              PI_ENABLE_OUTPUT_ESCAPING,
                            "");
                    }
                    else {
                        dispatachChars(
                          node);
                    }
                }
                break;
            case org.apache.xml.dtm.DTM.
                   ENTITY_REFERENCE_NODE:
                {
                    if (m_contentHandler instanceof org.xml.sax.ext.LexicalHandler) {
                        ((org.xml.sax.ext.LexicalHandler)
                           this.
                             m_contentHandler).
                          startEntity(
                            m_dtm.
                              getNodeName(
                                node));
                    }
                    else {
                        
                    }
                }
                break;
            default:
        }
    }
    protected void endNode(int node) throws org.xml.sax.SAXException {
        switch (m_dtm.
                  getNodeType(
                    node)) {
            case org.apache.xml.dtm.DTM.
                   DOCUMENT_NODE:
                this.
                  m_contentHandler.
                  endDocument(
                    );
                break;
            case org.apache.xml.dtm.DTM.
                   ELEMENT_NODE:
                java.lang.String ns =
                  m_dtm.
                  getNamespaceURI(
                    node);
                if (null ==
                      ns)
                    ns =
                      "";
                this.
                  m_contentHandler.
                  endElement(
                    ns,
                    m_dtm.
                      getLocalName(
                        node),
                    m_dtm.
                      getNodeName(
                        node));
                for (int nsn =
                       m_dtm.
                       getFirstNamespaceNode(
                         node,
                         true);
                     org.apache.xml.dtm.DTM.
                       NULL !=
                       nsn;
                     nsn =
                       m_dtm.
                         getNextNamespaceNode(
                           node,
                           nsn,
                           true)) {
                    java.lang.String prefix =
                      m_dtm.
                      getNodeNameX(
                        nsn);
                    this.
                      m_contentHandler.
                      endPrefixMapping(
                        prefix);
                }
                break;
            case org.apache.xml.dtm.DTM.
                   CDATA_SECTION_NODE:
                break;
            case org.apache.xml.dtm.DTM.
                   ENTITY_REFERENCE_NODE:
                {
                    if (m_contentHandler instanceof org.xml.sax.ext.LexicalHandler) {
                        org.xml.sax.ext.LexicalHandler lh =
                          (org.xml.sax.ext.LexicalHandler)
                            this.
                              m_contentHandler;
                        lh.
                          endEntity(
                            m_dtm.
                              getNodeName(
                                node));
                    }
                }
                break;
            default:
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "twjN6zpu0NA0fBj+L684dOqSIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nEo61j8sAAA=");
}
