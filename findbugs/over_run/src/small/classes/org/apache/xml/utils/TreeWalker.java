package org.apache.xml.utils;
public class TreeWalker {
    private org.xml.sax.ContentHandler m_contentHandler = null;
    protected org.apache.xml.utils.DOMHelper m_dh;
    private org.xml.sax.helpers.LocatorImpl m_locator = new org.xml.sax.helpers.LocatorImpl(
      );
    public org.xml.sax.ContentHandler getContentHandler() { return m_contentHandler;
    }
    public void setContentHandler(org.xml.sax.ContentHandler ch) {
        m_contentHandler =
          ch;
    }
    public TreeWalker(org.xml.sax.ContentHandler contentHandler,
                      org.apache.xml.utils.DOMHelper dh,
                      java.lang.String systemId) { super(
                                                     );
                                                   this.m_contentHandler =
                                                     contentHandler;
                                                   m_contentHandler.
                                                     setDocumentLocator(
                                                       m_locator);
                                                   if (systemId !=
                                                         null)
                                                       m_locator.
                                                         setSystemId(
                                                           systemId);
                                                   else {
                                                       try {
                                                           m_locator.
                                                             setSystemId(
                                                               java.lang.System.
                                                                 getProperty(
                                                                   "user.dir") +
                                                               java.io.File.
                                                                 separator +
                                                               "dummy.xsl");
                                                       }
                                                       catch (java.lang.SecurityException se) {
                                                           
                                                       }
                                                   }
                                                   m_dh =
                                                     dh;
    }
    public TreeWalker(org.xml.sax.ContentHandler contentHandler,
                      org.apache.xml.utils.DOMHelper dh) {
        super(
          );
        this.
          m_contentHandler =
          contentHandler;
        m_contentHandler.
          setDocumentLocator(
            m_locator);
        try {
            m_locator.
              setSystemId(
                java.lang.System.
                  getProperty(
                    "user.dir") +
                java.io.File.
                  separator +
                "dummy.xsl");
        }
        catch (java.lang.SecurityException se) {
            
        }
        m_dh =
          dh;
    }
    public TreeWalker(org.xml.sax.ContentHandler contentHandler) {
        super(
          );
        this.
          m_contentHandler =
          contentHandler;
        if (m_contentHandler !=
              null)
            m_contentHandler.
              setDocumentLocator(
                m_locator);
        try {
            m_locator.
              setSystemId(
                java.lang.System.
                  getProperty(
                    "user.dir") +
                java.io.File.
                  separator +
                "dummy.xsl");
        }
        catch (java.lang.SecurityException se) {
            
        }
        m_dh =
          new org.apache.xml.utils.DOM2Helper(
            );
    }
    public void traverse(org.w3c.dom.Node pos) throws org.xml.sax.SAXException {
        this.
          m_contentHandler.
          startDocument(
            );
        traverseFragment(
          pos);
        this.
          m_contentHandler.
          endDocument(
            );
    }
    public void traverseFragment(org.w3c.dom.Node pos)
          throws org.xml.sax.SAXException { org.w3c.dom.Node top =
                                              pos;
                                            while (null !=
                                                     pos) {
                                                startNode(
                                                  pos);
                                                org.w3c.dom.Node nextNode =
                                                  pos.
                                                  getFirstChild(
                                                    );
                                                while (null ==
                                                         nextNode) {
                                                    endNode(
                                                      pos);
                                                    if (top.
                                                          equals(
                                                            pos))
                                                        break;
                                                    nextNode =
                                                      pos.
                                                        getNextSibling(
                                                          );
                                                    if (null ==
                                                          nextNode) {
                                                        pos =
                                                          pos.
                                                            getParentNode(
                                                              );
                                                        if (null ==
                                                              pos ||
                                                              top.
                                                              equals(
                                                                pos)) {
                                                            if (null !=
                                                                  pos)
                                                                endNode(
                                                                  pos);
                                                            nextNode =
                                                              null;
                                                            break;
                                                        }
                                                    }
                                                }
                                                pos =
                                                  nextNode;
                                            } }
    public void traverse(org.w3c.dom.Node pos, org.w3c.dom.Node top)
          throws org.xml.sax.SAXException { this.
                                              m_contentHandler.
                                              startDocument(
                                                );
                                            while (null !=
                                                     pos) {
                                                startNode(
                                                  pos);
                                                org.w3c.dom.Node nextNode =
                                                  pos.
                                                  getFirstChild(
                                                    );
                                                while (null ==
                                                         nextNode) {
                                                    endNode(
                                                      pos);
                                                    if (null !=
                                                          top &&
                                                          top.
                                                          equals(
                                                            pos))
                                                        break;
                                                    nextNode =
                                                      pos.
                                                        getNextSibling(
                                                          );
                                                    if (null ==
                                                          nextNode) {
                                                        pos =
                                                          pos.
                                                            getParentNode(
                                                              );
                                                        if (null ==
                                                              pos ||
                                                              null !=
                                                              top &&
                                                              top.
                                                              equals(
                                                                pos)) {
                                                            nextNode =
                                                              null;
                                                            break;
                                                        }
                                                    }
                                                }
                                                pos =
                                                  nextNode;
                                            }
                                            this.
                                              m_contentHandler.
                                              endDocument(
                                                );
    }
    boolean nextIsRaw = false;
    private final void dispatachChars(org.w3c.dom.Node node)
          throws org.xml.sax.SAXException { if (m_contentHandler instanceof org.apache.xml.dtm.ref.dom2dtm.DOM2DTM.CharacterNodeHandler) {
                                                ((org.apache.xml.dtm.ref.dom2dtm.DOM2DTM.CharacterNodeHandler)
                                                   m_contentHandler).
                                                  characters(
                                                    node);
                                            }
                                            else {
                                                java.lang.String data =
                                                  ((org.w3c.dom.Text)
                                                     node).
                                                  getData(
                                                    );
                                                this.
                                                  m_contentHandler.
                                                  characters(
                                                    data.
                                                      toCharArray(
                                                        ),
                                                    0,
                                                    data.
                                                      length(
                                                        ));
                                            }
    }
    protected void startNode(org.w3c.dom.Node node)
          throws org.xml.sax.SAXException {
        if (m_contentHandler instanceof org.apache.xml.utils.NodeConsumer) {
            ((org.apache.xml.utils.NodeConsumer)
               m_contentHandler).
              setOriginatingNode(
                node);
        }
        if (node instanceof org.xml.sax.Locator) {
            org.xml.sax.Locator loc =
              (org.xml.sax.Locator)
                node;
            m_locator.
              setColumnNumber(
                loc.
                  getColumnNumber(
                    ));
            m_locator.
              setLineNumber(
                loc.
                  getLineNumber(
                    ));
            m_locator.
              setPublicId(
                loc.
                  getPublicId(
                    ));
            m_locator.
              setSystemId(
                loc.
                  getSystemId(
                    ));
        }
        else {
            m_locator.
              setColumnNumber(
                0);
            m_locator.
              setLineNumber(
                0);
        }
        switch (node.
                  getNodeType(
                    )) {
            case org.w3c.dom.Node.
                   COMMENT_NODE:
                {
                    java.lang.String data =
                      ((org.w3c.dom.Comment)
                         node).
                      getData(
                        );
                    if (m_contentHandler instanceof org.xml.sax.ext.LexicalHandler) {
                        org.xml.sax.ext.LexicalHandler lh =
                          (org.xml.sax.ext.LexicalHandler)
                            this.
                              m_contentHandler;
                        lh.
                          comment(
                            data.
                              toCharArray(
                                ),
                            0,
                            data.
                              length(
                                ));
                    }
                }
                break;
            case org.w3c.dom.Node.
                   DOCUMENT_FRAGMENT_NODE:
                break;
            case org.w3c.dom.Node.
                   DOCUMENT_NODE:
                break;
            case org.w3c.dom.Node.
                   ELEMENT_NODE:
                org.w3c.dom.NamedNodeMap atts =
                  ((org.w3c.dom.Element)
                     node).
                  getAttributes(
                    );
                int nAttrs =
                  atts.
                  getLength(
                    );
                for (int i =
                       0;
                     i <
                       nAttrs;
                     i++) {
                    org.w3c.dom.Node attr =
                      atts.
                      item(
                        i);
                    java.lang.String attrName =
                      attr.
                      getNodeName(
                        );
                    if (attrName.
                          equals(
                            "xmlns") ||
                          attrName.
                          startsWith(
                            "xmlns:")) {
                        int index;
                        java.lang.String prefix =
                          (index =
                             attrName.
                               indexOf(
                                 ":")) <
                          0
                          ? ""
                          : attrName.
                          substring(
                            index +
                              1);
                        this.
                          m_contentHandler.
                          startPrefixMapping(
                            prefix,
                            attr.
                              getNodeValue(
                                ));
                    }
                }
                java.lang.String ns =
                  m_dh.
                  getNamespaceOfNode(
                    node);
                if (null ==
                      ns)
                    ns =
                      "";
                this.
                  m_contentHandler.
                  startElement(
                    ns,
                    m_dh.
                      getLocalNameOfNode(
                        node),
                    node.
                      getNodeName(
                        ),
                    new org.apache.xml.utils.AttList(
                      atts,
                      m_dh));
                break;
            case org.w3c.dom.Node.
                   PROCESSING_INSTRUCTION_NODE:
                {
                    org.w3c.dom.ProcessingInstruction pi =
                      (org.w3c.dom.ProcessingInstruction)
                        node;
                    java.lang.String name =
                      pi.
                      getNodeName(
                        );
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
                            pi.
                              getNodeName(
                                ),
                            pi.
                              getData(
                                ));
                    }
                }
                break;
            case org.w3c.dom.Node.
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
            case org.w3c.dom.Node.
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
            case org.w3c.dom.Node.
                   ENTITY_REFERENCE_NODE:
                {
                    org.w3c.dom.EntityReference eref =
                      (org.w3c.dom.EntityReference)
                        node;
                    if (m_contentHandler instanceof org.xml.sax.ext.LexicalHandler) {
                        ((org.xml.sax.ext.LexicalHandler)
                           this.
                             m_contentHandler).
                          startEntity(
                            eref.
                              getNodeName(
                                ));
                    }
                    else {
                        
                    }
                }
                break;
            default:
        }
    }
    protected void endNode(org.w3c.dom.Node node)
          throws org.xml.sax.SAXException {
        switch (node.
                  getNodeType(
                    )) {
            case org.w3c.dom.Node.
                   DOCUMENT_NODE:
                break;
            case org.w3c.dom.Node.
                   ELEMENT_NODE:
                java.lang.String ns =
                  m_dh.
                  getNamespaceOfNode(
                    node);
                if (null ==
                      ns)
                    ns =
                      "";
                this.
                  m_contentHandler.
                  endElement(
                    ns,
                    m_dh.
                      getLocalNameOfNode(
                        node),
                    node.
                      getNodeName(
                        ));
                org.w3c.dom.NamedNodeMap atts =
                  ((org.w3c.dom.Element)
                     node).
                  getAttributes(
                    );
                int nAttrs =
                  atts.
                  getLength(
                    );
                for (int i =
                       0;
                     i <
                       nAttrs;
                     i++) {
                    org.w3c.dom.Node attr =
                      atts.
                      item(
                        i);
                    java.lang.String attrName =
                      attr.
                      getNodeName(
                        );
                    if (attrName.
                          equals(
                            "xmlns") ||
                          attrName.
                          startsWith(
                            "xmlns:")) {
                        int index;
                        java.lang.String prefix =
                          (index =
                             attrName.
                               indexOf(
                                 ":")) <
                          0
                          ? ""
                          : attrName.
                          substring(
                            index +
                              1);
                        this.
                          m_contentHandler.
                          endPrefixMapping(
                            prefix);
                    }
                }
                break;
            case org.w3c.dom.Node.
                   CDATA_SECTION_NODE:
                break;
            case org.w3c.dom.Node.
                   ENTITY_REFERENCE_NODE:
                {
                    org.w3c.dom.EntityReference eref =
                      (org.w3c.dom.EntityReference)
                        node;
                    if (m_contentHandler instanceof org.xml.sax.ext.LexicalHandler) {
                        org.xml.sax.ext.LexicalHandler lh =
                          (org.xml.sax.ext.LexicalHandler)
                            this.
                              m_contentHandler;
                        lh.
                          endEntity(
                            eref.
                              getNodeName(
                                ));
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
       "14U68J+9/wPPxWbNJyIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7D79tfs/d+U9RwHl/TuGTxTyFG/vuv21");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "rpbjx8VFrOzzD/+nb/sPL/1RcWr4fwEib4qpPS4AAA==";
}
