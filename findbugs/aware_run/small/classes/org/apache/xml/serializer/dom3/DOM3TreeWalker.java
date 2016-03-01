package org.apache.xml.serializer.dom3;
final class DOM3TreeWalker {
    private org.apache.xml.serializer.SerializationHandler fSerializer = null;
    private org.xml.sax.helpers.LocatorImpl fLocator = new org.xml.sax.helpers.LocatorImpl(
      );
    private org.w3c.dom.DOMErrorHandler fErrorHandler = null;
    private org.w3c.dom.ls.LSSerializerFilter fFilter = null;
    private org.xml.sax.ext.LexicalHandler fLexicalHandler = null;
    private int fWhatToShowFilter;
    private java.lang.String fNewLine = null;
    private java.util.Properties fDOMConfigProperties = null;
    private boolean fInEntityRef = false;
    private java.lang.String fXMLVersion = null;
    private boolean fIsXMLVersion11 = false;
    private boolean fIsLevel3DOM = false;
    private int fFeatures = 0;
    boolean fNextIsRaw = false;
    private static final java.lang.String XMLNS_URI = "http://www.w3.org/2000/xmlns/";
    private static final java.lang.String XMLNS_PREFIX = "xmlns";
    private static final java.lang.String XML_URI = "http://www.w3.org/XML/1998/namespace";
    private static final java.lang.String XML_PREFIX = "xml";
    protected org.apache.xml.serializer.dom3.NamespaceSupport fNSBinder;
    protected org.apache.xml.serializer.dom3.NamespaceSupport fLocalNSBinder;
    private int fElementDepth = 0;
    private static final int CANONICAL = 1 << 0;
    private static final int CDATA = 1 << 1;
    private static final int CHARNORMALIZE = 1 << 2;
    private static final int COMMENTS = 1 << 3;
    private static final int DTNORMALIZE = 1 << 4;
    private static final int ELEM_CONTENT_WHITESPACE = 1 << 5;
    private static final int ENTITIES = 1 << 6;
    private static final int INFOSET = 1 << 7;
    private static final int NAMESPACES = 1 << 8;
    private static final int NAMESPACEDECLS = 1 << 9;
    private static final int NORMALIZECHARS = 1 << 10;
    private static final int SPLITCDATA = 1 << 11;
    private static final int VALIDATE = 1 << 12;
    private static final int SCHEMAVALIDATE = 1 << 13;
    private static final int WELLFORMED = 1 << 14;
    private static final int DISCARDDEFAULT = 1 << 15;
    private static final int PRETTY_PRINT = 1 << 16;
    private static final int IGNORE_CHAR_DENORMALIZE = 1 << 17;
    private static final int XMLDECL = 1 << 18;
    DOM3TreeWalker(org.apache.xml.serializer.SerializationHandler serialHandler,
                   org.w3c.dom.DOMErrorHandler errHandler,
                   org.w3c.dom.ls.LSSerializerFilter filter,
                   java.lang.String newLine) { super();
                                               fSerializer = serialHandler;
                                               fErrorHandler = errHandler;
                                               fFilter = filter;
                                               fLexicalHandler = null;
                                               fNewLine = newLine;
                                               fNSBinder = new org.apache.xml.serializer.dom3.NamespaceSupport(
                                                             );
                                               fLocalNSBinder =
                                                 new org.apache.xml.serializer.dom3.NamespaceSupport(
                                                   );
                                               fDOMConfigProperties =
                                                 fSerializer.
                                                   getOutputFormat(
                                                     );
                                               fSerializer.
                                                 setDocumentLocator(
                                                   fLocator);
                                               initProperties(
                                                 fDOMConfigProperties);
                                               try {
                                                   fLocator.
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
    public void traverse(org.w3c.dom.Node pos)
          throws org.xml.sax.SAXException {
        this.
          fSerializer.
          startDocument(
            );
        if (pos.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                DOCUMENT_NODE) {
            org.w3c.dom.Document ownerDoc =
              pos.
              getOwnerDocument(
                );
            if (ownerDoc !=
                  null &&
                  ownerDoc.
                  getImplementation(
                    ).
                  hasFeature(
                    "Core",
                    "3.0")) {
                fIsLevel3DOM =
                  true;
            }
        }
        else {
            if (((org.w3c.dom.Document)
                   pos).
                  getImplementation(
                    ).
                  hasFeature(
                    "Core",
                    "3.0")) {
                fIsLevel3DOM =
                  true;
            }
        }
        if (fSerializer instanceof org.xml.sax.ext.LexicalHandler) {
            fLexicalHandler =
              (org.xml.sax.ext.LexicalHandler)
                this.
                  fSerializer;
        }
        if (fFilter !=
              null)
            fWhatToShowFilter =
              fFilter.
                getWhatToShow(
                  );
        org.w3c.dom.Node top =
          pos;
        while (null !=
                 pos) {
            startNode(
              pos);
            org.w3c.dom.Node nextNode =
              null;
            nextNode =
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
        }
        this.
          fSerializer.
          endDocument(
            );
    }
    public void traverse(org.w3c.dom.Node pos,
                         org.w3c.dom.Node top)
          throws org.xml.sax.SAXException {
        this.
          fSerializer.
          startDocument(
            );
        if (pos.
              getNodeType(
                ) !=
              org.w3c.dom.Node.
                DOCUMENT_NODE) {
            org.w3c.dom.Document ownerDoc =
              pos.
              getOwnerDocument(
                );
            if (ownerDoc !=
                  null &&
                  ownerDoc.
                  getImplementation(
                    ).
                  hasFeature(
                    "Core",
                    "3.0")) {
                fIsLevel3DOM =
                  true;
            }
        }
        else {
            if (((org.w3c.dom.Document)
                   pos).
                  getImplementation(
                    ).
                  hasFeature(
                    "Core",
                    "3.0")) {
                fIsLevel3DOM =
                  true;
            }
        }
        if (fSerializer instanceof org.xml.sax.ext.LexicalHandler) {
            fLexicalHandler =
              (org.xml.sax.ext.LexicalHandler)
                this.
                  fSerializer;
        }
        if (fFilter !=
              null)
            fWhatToShowFilter =
              fFilter.
                getWhatToShow(
                  );
        while (null !=
                 pos) {
            startNode(
              pos);
            org.w3c.dom.Node nextNode =
              null;
            nextNode =
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
          fSerializer.
          endDocument(
            );
    }
    private final void dispatachChars(org.w3c.dom.Node node)
          throws org.xml.sax.SAXException {
        if (fSerializer !=
              null) {
            this.
              fSerializer.
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
              fSerializer.
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
        if (node instanceof org.xml.sax.Locator) {
            org.xml.sax.Locator loc =
              (org.xml.sax.Locator)
                node;
            fLocator.
              setColumnNumber(
                loc.
                  getColumnNumber(
                    ));
            fLocator.
              setLineNumber(
                loc.
                  getLineNumber(
                    ));
            fLocator.
              setPublicId(
                loc.
                  getPublicId(
                    ));
            fLocator.
              setSystemId(
                loc.
                  getSystemId(
                    ));
        }
        else {
            fLocator.
              setColumnNumber(
                0);
            fLocator.
              setLineNumber(
                0);
        }
        switch (node.
                  getNodeType(
                    )) {
            case org.w3c.dom.Node.
                   DOCUMENT_TYPE_NODE:
                serializeDocType(
                  (org.w3c.dom.DocumentType)
                    node,
                  true);
                break;
            case org.w3c.dom.Node.
                   COMMENT_NODE:
                serializeComment(
                  (org.w3c.dom.Comment)
                    node);
                break;
            case org.w3c.dom.Node.
                   DOCUMENT_FRAGMENT_NODE:
                break;
            case org.w3c.dom.Node.
                   DOCUMENT_NODE:
                break;
            case org.w3c.dom.Node.
                   ELEMENT_NODE:
                serializeElement(
                  (org.w3c.dom.Element)
                    node,
                  true);
                break;
            case org.w3c.dom.Node.
                   PROCESSING_INSTRUCTION_NODE:
                serializePI(
                  (org.w3c.dom.ProcessingInstruction)
                    node);
                break;
            case org.w3c.dom.Node.
                   CDATA_SECTION_NODE:
                serializeCDATASection(
                  (org.w3c.dom.CDATASection)
                    node);
                break;
            case org.w3c.dom.Node.
                   TEXT_NODE:
                serializeText(
                  (org.w3c.dom.Text)
                    node);
                break;
            case org.w3c.dom.Node.
                   ENTITY_REFERENCE_NODE:
                serializeEntityReference(
                  (org.w3c.dom.EntityReference)
                    node,
                  true);
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
                   DOCUMENT_TYPE_NODE:
                serializeDocType(
                  (org.w3c.dom.DocumentType)
                    node,
                  false);
                break;
            case org.w3c.dom.Node.
                   ELEMENT_NODE:
                serializeElement(
                  (org.w3c.dom.Element)
                    node,
                  false);
                break;
            case org.w3c.dom.Node.
                   CDATA_SECTION_NODE:
                break;
            case org.w3c.dom.Node.
                   ENTITY_REFERENCE_NODE:
                serializeEntityReference(
                  (org.w3c.dom.EntityReference)
                    node,
                  false);
                break;
            default:
        }
    }
    protected boolean applyFilter(org.w3c.dom.Node node,
                                  int nodeType) {
        if (fFilter !=
              null &&
              (fWhatToShowFilter &
                 nodeType) !=
              0) {
            short code =
              fFilter.
              acceptNode(
                node);
            switch (code) {
                case org.w3c.dom.traversal.NodeFilter.
                       FILTER_REJECT:
                case org.w3c.dom.traversal.NodeFilter.
                       FILTER_SKIP:
                    return false;
                default:
            }
        }
        return true;
    }
    protected void serializeDocType(org.w3c.dom.DocumentType node,
                                    boolean bStart)
          throws org.xml.sax.SAXException {
        java.lang.String docTypeName =
          node.
          getNodeName(
            );
        java.lang.String publicId =
          node.
          getPublicId(
            );
        java.lang.String systemId =
          node.
          getSystemId(
            );
        java.lang.String internalSubset =
          node.
          getInternalSubset(
            );
        if (internalSubset !=
              null &&
              !"".
              equals(
                internalSubset)) {
            if (bStart) {
                try {
                    java.io.Writer writer =
                      fSerializer.
                      getWriter(
                        );
                    java.lang.StringBuffer dtd =
                      new java.lang.StringBuffer(
                      );
                    dtd.
                      append(
                        "<!DOCTYPE ");
                    dtd.
                      append(
                        docTypeName);
                    if (null !=
                          publicId) {
                        dtd.
                          append(
                            " PUBLIC \"");
                        dtd.
                          append(
                            publicId);
                        dtd.
                          append(
                            '\"');
                    }
                    if (null !=
                          systemId) {
                        if (null ==
                              publicId) {
                            dtd.
                              append(
                                " SYSTEM \"");
                        }
                        else {
                            dtd.
                              append(
                                " \"");
                        }
                        dtd.
                          append(
                            systemId);
                        dtd.
                          append(
                            '\"');
                    }
                    dtd.
                      append(
                        " [ ");
                    dtd.
                      append(
                        fNewLine);
                    dtd.
                      append(
                        internalSubset);
                    dtd.
                      append(
                        "]>");
                    dtd.
                      append(
                        fNewLine);
                    writer.
                      write(
                        dtd.
                          toString(
                            ));
                    writer.
                      flush(
                        );
                }
                catch (java.io.IOException e) {
                    throw new org.xml.sax.SAXException(
                      org.apache.xml.serializer.utils.Utils.
                        messages.
                        createMessage(
                          org.apache.xml.serializer.utils.MsgKey.
                            ER_WRITING_INTERNAL_SUBSET,
                          null),
                      e);
                }
            }
        }
        else {
            if (bStart) {
                if (fLexicalHandler !=
                      null) {
                    fLexicalHandler.
                      startDTD(
                        docTypeName,
                        publicId,
                        systemId);
                }
            }
            else {
                if (fLexicalHandler !=
                      null) {
                    fLexicalHandler.
                      endDTD(
                        );
                }
            }
        }
    }
    protected void serializeComment(org.w3c.dom.Comment node)
          throws org.xml.sax.SAXException {
        if ((fFeatures &
               COMMENTS) !=
              0) {
            java.lang.String data =
              node.
              getData(
                );
            if ((fFeatures &
                   WELLFORMED) !=
                  0) {
                isCommentWellFormed(
                  data);
            }
            if (fLexicalHandler !=
                  null) {
                if (!applyFilter(
                       node,
                       org.w3c.dom.traversal.NodeFilter.
                         SHOW_COMMENT)) {
                    return;
                }
                fLexicalHandler.
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
    }
    protected void serializeElement(org.w3c.dom.Element node,
                                    boolean bStart)
          throws org.xml.sax.SAXException {
        if (bStart) {
            fElementDepth++;
            if ((fFeatures &
                   WELLFORMED) !=
                  0) {
                isElementWellFormed(
                  node);
            }
            if (!applyFilter(
                   node,
                   org.w3c.dom.traversal.NodeFilter.
                     SHOW_ELEMENT)) {
                return;
            }
            if ((fFeatures &
                   NAMESPACES) !=
                  0) {
                fNSBinder.
                  pushContext(
                    );
                fLocalNSBinder.
                  reset(
                    );
                recordLocalNSDecl(
                  node);
                fixupElementNS(
                  node);
            }
            fSerializer.
              startElement(
                node.
                  getNamespaceURI(
                    ),
                node.
                  getLocalName(
                    ),
                node.
                  getNodeName(
                    ));
            serializeAttList(
              node);
        }
        else {
            fElementDepth--;
            if (!applyFilter(
                   node,
                   org.w3c.dom.traversal.NodeFilter.
                     SHOW_ELEMENT)) {
                return;
            }
            this.
              fSerializer.
              endElement(
                node.
                  getNamespaceURI(
                    ),
                node.
                  getLocalName(
                    ),
                node.
                  getNodeName(
                    ));
            if ((fFeatures &
                   NAMESPACES) !=
                  0) {
                fNSBinder.
                  popContext(
                    );
            }
        }
    }
    protected void serializeAttList(org.w3c.dom.Element node)
          throws org.xml.sax.SAXException {
        org.w3c.dom.NamedNodeMap atts =
          node.
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
            java.lang.String localName =
              attr.
              getLocalName(
                );
            java.lang.String attrName =
              attr.
              getNodeName(
                );
            java.lang.String attrPrefix =
              attr.
              getPrefix(
                ) ==
              null
              ? ""
              : attr.
              getPrefix(
                );
            java.lang.String attrValue =
              attr.
              getNodeValue(
                );
            java.lang.String type =
              null;
            if (fIsLevel3DOM) {
                type =
                  ((org.w3c.dom.Attr)
                     attr).
                    getSchemaTypeInfo(
                      ).
                    getTypeName(
                      );
            }
            type =
              type ==
                null
                ? "CDATA"
                : type;
            java.lang.String attrNS =
              attr.
              getNamespaceURI(
                );
            if (attrNS !=
                  null &&
                  attrNS.
                  length(
                    ) ==
                  0) {
                attrNS =
                  null;
                attrName =
                  attr.
                    getLocalName(
                      );
            }
            boolean isSpecified =
              ((org.w3c.dom.Attr)
                 attr).
              getSpecified(
                );
            boolean addAttr =
              true;
            boolean applyFilter =
              false;
            boolean xmlnsAttr =
              attrName.
              equals(
                "xmlns") ||
              attrName.
              startsWith(
                "xmlns:");
            if ((fFeatures &
                   WELLFORMED) !=
                  0) {
                isAttributeWellFormed(
                  attr);
            }
            if ((fFeatures &
                   NAMESPACES) !=
                  0 &&
                  !xmlnsAttr) {
                if (attrNS !=
                      null) {
                    attrPrefix =
                      attrPrefix ==
                        null
                        ? ""
                        : attrPrefix;
                    java.lang.String declAttrPrefix =
                      fNSBinder.
                      getPrefix(
                        attrNS);
                    java.lang.String declAttrNS =
                      fNSBinder.
                      getURI(
                        attrPrefix);
                    if ("".
                          equals(
                            attrPrefix) ||
                          "".
                          equals(
                            declAttrPrefix) ||
                          !attrPrefix.
                          equals(
                            declAttrPrefix)) {
                        if (declAttrPrefix !=
                              null &&
                              !"".
                              equals(
                                declAttrPrefix)) {
                            attrPrefix =
                              declAttrPrefix;
                            if (declAttrPrefix.
                                  length(
                                    ) >
                                  0) {
                                attrName =
                                  declAttrPrefix +
                                  ":" +
                                  localName;
                            }
                            else {
                                attrName =
                                  localName;
                            }
                        }
                        else {
                            if (attrPrefix !=
                                  null &&
                                  !"".
                                  equals(
                                    attrPrefix) &&
                                  declAttrNS ==
                                  null) {
                                if ((fFeatures &
                                       NAMESPACEDECLS) !=
                                      0) {
                                    fSerializer.
                                      addAttribute(
                                        XMLNS_URI,
                                        attrPrefix,
                                        XMLNS_PREFIX +
                                        ":" +
                                        attrPrefix,
                                        "CDATA",
                                        attrNS);
                                    fNSBinder.
                                      declarePrefix(
                                        attrPrefix,
                                        attrNS);
                                    fLocalNSBinder.
                                      declarePrefix(
                                        attrPrefix,
                                        attrNS);
                                }
                            }
                            else {
                                int counter =
                                  1;
                                attrPrefix =
                                  "NS" +
                                  counter++;
                                while (fLocalNSBinder.
                                         getURI(
                                           attrPrefix) !=
                                         null) {
                                    attrPrefix =
                                      "NS" +
                                      counter++;
                                }
                                attrName =
                                  attrPrefix +
                                  ":" +
                                  localName;
                                if ((fFeatures &
                                       NAMESPACEDECLS) !=
                                      0) {
                                    fSerializer.
                                      addAttribute(
                                        XMLNS_URI,
                                        attrPrefix,
                                        XMLNS_PREFIX +
                                        ":" +
                                        attrPrefix,
                                        "CDATA",
                                        attrNS);
                                    fNSBinder.
                                      declarePrefix(
                                        attrPrefix,
                                        attrNS);
                                    fLocalNSBinder.
                                      declarePrefix(
                                        attrPrefix,
                                        attrNS);
                                }
                            }
                        }
                    }
                }
                else {
                    if (localName ==
                          null) {
                        java.lang.String msg =
                          org.apache.xml.serializer.utils.Utils.
                            messages.
                          createMessage(
                            org.apache.xml.serializer.utils.MsgKey.
                              ER_NULL_LOCAL_ELEMENT_NAME,
                            new java.lang.Object[] { attrName });
                        if (fErrorHandler !=
                              null) {
                            fErrorHandler.
                              handleError(
                                new org.apache.xml.serializer.dom3.DOMErrorImpl(
                                  org.w3c.dom.DOMError.
                                    SEVERITY_ERROR,
                                  msg,
                                  org.apache.xml.serializer.utils.MsgKey.
                                    ER_NULL_LOCAL_ELEMENT_NAME,
                                  null,
                                  null,
                                  null));
                        }
                    }
                    else {
                        
                    }
                }
            }
            if ((fFeatures &
                   DISCARDDEFAULT) !=
                  0 &&
                  isSpecified ||
                  (fFeatures &
                     DISCARDDEFAULT) ==
                  0) {
                applyFilter =
                  true;
            }
            else {
                addAttr =
                  false;
            }
            if (applyFilter) {
                if (fFilter !=
                      null &&
                      (fFilter.
                         getWhatToShow(
                           ) &
                         org.w3c.dom.traversal.NodeFilter.
                           SHOW_ATTRIBUTE) !=
                      0) {
                    if (!xmlnsAttr) {
                        short code =
                          fFilter.
                          acceptNode(
                            attr);
                        switch (code) {
                            case org.w3c.dom.traversal.NodeFilter.
                                   FILTER_REJECT:
                            case org.w3c.dom.traversal.NodeFilter.
                                   FILTER_SKIP:
                                addAttr =
                                  false;
                                break;
                            default:
                        }
                    }
                }
            }
            if (addAttr &&
                  xmlnsAttr) {
                if ((fFeatures &
                       NAMESPACEDECLS) !=
                      0) {
                    if (localName !=
                          null &&
                          !"".
                          equals(
                            localName)) {
                        fSerializer.
                          addAttribute(
                            attrNS,
                            localName,
                            attrName,
                            type,
                            attrValue);
                    }
                }
            }
            else
                if (addAttr &&
                      !xmlnsAttr) {
                    if ((fFeatures &
                           NAMESPACEDECLS) !=
                          0 &&
                          attrNS !=
                          null) {
                        fSerializer.
                          addAttribute(
                            attrNS,
                            localName,
                            attrName,
                            type,
                            attrValue);
                    }
                    else {
                        fSerializer.
                          addAttribute(
                            "",
                            localName,
                            attrName,
                            type,
                            attrValue);
                    }
                }
            if (xmlnsAttr &&
                  (fFeatures &
                     NAMESPACEDECLS) !=
                  0) {
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
                if (!"".
                      equals(
                        prefix)) {
                    fSerializer.
                      namespaceAfterStartElement(
                        prefix,
                        attrValue);
                }
            }
        }
    }
    protected void serializePI(org.w3c.dom.ProcessingInstruction node)
          throws org.xml.sax.SAXException {
        org.w3c.dom.ProcessingInstruction pi =
          node;
        java.lang.String name =
          pi.
          getNodeName(
            );
        if ((fFeatures &
               WELLFORMED) !=
              0) {
            isPIWellFormed(
              node);
        }
        if (!applyFilter(
               node,
               org.w3c.dom.traversal.NodeFilter.
                 SHOW_PROCESSING_INSTRUCTION)) {
            return;
        }
        if (name.
              equals(
                "xslt-next-is-raw")) {
            fNextIsRaw =
              true;
        }
        else {
            this.
              fSerializer.
              processingInstruction(
                name,
                pi.
                  getData(
                    ));
        }
    }
    protected void serializeCDATASection(org.w3c.dom.CDATASection node)
          throws org.xml.sax.SAXException {
        if ((fFeatures &
               WELLFORMED) !=
              0) {
            isCDATASectionWellFormed(
              node);
        }
        if ((fFeatures &
               CDATA) !=
              0) {
            java.lang.String nodeValue =
              node.
              getNodeValue(
                );
            int endIndex =
              nodeValue.
              indexOf(
                "]]>");
            if ((fFeatures &
                   SPLITCDATA) !=
                  0) {
                if (endIndex >=
                      0) {
                    java.lang.String relatedData =
                      nodeValue.
                      substring(
                        0,
                        endIndex +
                          2);
                    java.lang.String msg =
                      org.apache.xml.serializer.utils.Utils.
                        messages.
                      createMessage(
                        org.apache.xml.serializer.utils.MsgKey.
                          ER_CDATA_SECTIONS_SPLIT,
                        null);
                    if (fErrorHandler !=
                          null) {
                        fErrorHandler.
                          handleError(
                            new org.apache.xml.serializer.dom3.DOMErrorImpl(
                              org.w3c.dom.DOMError.
                                SEVERITY_WARNING,
                              msg,
                              org.apache.xml.serializer.utils.MsgKey.
                                ER_CDATA_SECTIONS_SPLIT,
                              null,
                              relatedData,
                              null));
                    }
                }
            }
            else {
                if (endIndex >=
                      0) {
                    java.lang.String relatedData =
                      nodeValue.
                      substring(
                        0,
                        endIndex +
                          2);
                    java.lang.String msg =
                      org.apache.xml.serializer.utils.Utils.
                        messages.
                      createMessage(
                        org.apache.xml.serializer.utils.MsgKey.
                          ER_CDATA_SECTIONS_SPLIT,
                        null);
                    if (fErrorHandler !=
                          null) {
                        fErrorHandler.
                          handleError(
                            new org.apache.xml.serializer.dom3.DOMErrorImpl(
                              org.w3c.dom.DOMError.
                                SEVERITY_ERROR,
                              msg,
                              org.apache.xml.serializer.utils.MsgKey.
                                ER_CDATA_SECTIONS_SPLIT));
                    }
                    return;
                }
            }
            if (!applyFilter(
                   node,
                   org.w3c.dom.traversal.NodeFilter.
                     SHOW_CDATA_SECTION)) {
                return;
            }
            if (fLexicalHandler !=
                  null) {
                fLexicalHandler.
                  startCDATA(
                    );
            }
            dispatachChars(
              node);
            if (fLexicalHandler !=
                  null) {
                fLexicalHandler.
                  endCDATA(
                    );
            }
        }
        else {
            dispatachChars(
              node);
        }
    }
    protected void serializeText(org.w3c.dom.Text node)
          throws org.xml.sax.SAXException {
        if (fNextIsRaw) {
            fNextIsRaw =
              false;
            fSerializer.
              processingInstruction(
                javax.xml.transform.Result.
                  PI_DISABLE_OUTPUT_ESCAPING,
                "");
            dispatachChars(
              node);
            fSerializer.
              processingInstruction(
                javax.xml.transform.Result.
                  PI_ENABLE_OUTPUT_ESCAPING,
                "");
        }
        else {
            boolean bDispatch =
              false;
            if ((fFeatures &
                   WELLFORMED) !=
                  0) {
                isTextWellFormed(
                  node);
            }
            boolean isElementContentWhitespace =
              false;
            if (fIsLevel3DOM) {
                isElementContentWhitespace =
                  node.
                    isElementContentWhitespace(
                      );
            }
            if (isElementContentWhitespace) {
                if ((fFeatures &
                       ELEM_CONTENT_WHITESPACE) !=
                      0) {
                    bDispatch =
                      true;
                }
            }
            else {
                bDispatch =
                  true;
            }
            if (!applyFilter(
                   node,
                   org.w3c.dom.traversal.NodeFilter.
                     SHOW_TEXT)) {
                return;
            }
            if (bDispatch) {
                dispatachChars(
                  node);
            }
        }
    }
    protected void serializeEntityReference(org.w3c.dom.EntityReference node,
                                            boolean bStart)
          throws org.xml.sax.SAXException {
        if (bStart) {
            org.w3c.dom.EntityReference eref =
              node;
            if ((fFeatures &
                   ENTITIES) !=
                  0) {
                if ((fFeatures &
                       WELLFORMED) !=
                      0) {
                    isEntityReferneceWellFormed(
                      node);
                }
                if ((fFeatures &
                       NAMESPACES) !=
                      0) {
                    checkUnboundPrefixInEntRef(
                      node);
                }
            }
            if (fLexicalHandler !=
                  null) {
                fLexicalHandler.
                  startEntity(
                    eref.
                      getNodeName(
                        ));
            }
        }
        else {
            org.w3c.dom.EntityReference eref =
              node;
            if (fLexicalHandler !=
                  null) {
                fLexicalHandler.
                  endEntity(
                    eref.
                      getNodeName(
                        ));
            }
        }
    }
    protected boolean isXMLName(java.lang.String s,
                                boolean xml11Version) {
        if (s ==
              null) {
            return false;
        }
        if (!xml11Version)
            return org.apache.xml.serializer.utils.XMLChar.
              isValidName(
                s);
        else
            return org.apache.xml.serializer.utils.XML11Char.
              isXML11ValidName(
                s);
    }
    protected boolean isValidQName(java.lang.String prefix,
                                   java.lang.String local,
                                   boolean xml11Version) {
        if (local ==
              null)
            return false;
        boolean validNCName =
          false;
        if (!xml11Version) {
            validNCName =
              (prefix ==
                 null ||
                 org.apache.xml.serializer.utils.XMLChar.
                 isValidNCName(
                   prefix)) &&
                org.apache.xml.serializer.utils.XMLChar.
                isValidNCName(
                  local);
        }
        else {
            validNCName =
              (prefix ==
                 null ||
                 org.apache.xml.serializer.utils.XML11Char.
                 isXML11ValidNCName(
                   prefix)) &&
                org.apache.xml.serializer.utils.XML11Char.
                isXML11ValidNCName(
                  local);
        }
        return validNCName;
    }
    protected boolean isWFXMLChar(java.lang.String chardata,
                                  java.lang.Character refInvalidChar) {
        if (chardata ==
              null ||
              chardata.
              length(
                ) ==
              0) {
            return true;
        }
        char[] dataarray =
          chardata.
          toCharArray(
            );
        int datalength =
          dataarray.
            length;
        if (fIsXMLVersion11) {
            int i =
              0;
            while (i <
                     datalength) {
                if (org.apache.xml.serializer.utils.XML11Char.
                      isXML11Invalid(
                        dataarray[i++])) {
                    char ch =
                      dataarray[i -
                                  1];
                    if (org.apache.xml.serializer.utils.XMLChar.
                          isHighSurrogate(
                            ch) &&
                          i <
                          datalength) {
                        char ch2 =
                          dataarray[i++];
                        if (org.apache.xml.serializer.utils.XMLChar.
                              isLowSurrogate(
                                ch2) &&
                              org.apache.xml.serializer.utils.XMLChar.
                              isSupplemental(
                                org.apache.xml.serializer.utils.XMLChar.
                                  supplemental(
                                    ch,
                                    ch2))) {
                            continue;
                        }
                    }
                    refInvalidChar =
                      new java.lang.Character(
                        ch);
                    return false;
                }
            }
        }
        else {
            int i =
              0;
            while (i <
                     datalength) {
                if (org.apache.xml.serializer.utils.XMLChar.
                      isInvalid(
                        dataarray[i++])) {
                    char ch =
                      dataarray[i -
                                  1];
                    if (org.apache.xml.serializer.utils.XMLChar.
                          isHighSurrogate(
                            ch) &&
                          i <
                          datalength) {
                        char ch2 =
                          dataarray[i++];
                        if (org.apache.xml.serializer.utils.XMLChar.
                              isLowSurrogate(
                                ch2) &&
                              org.apache.xml.serializer.utils.XMLChar.
                              isSupplemental(
                                org.apache.xml.serializer.utils.XMLChar.
                                  supplemental(
                                    ch,
                                    ch2))) {
                            continue;
                        }
                    }
                    refInvalidChar =
                      new java.lang.Character(
                        ch);
                    return false;
                }
            }
        }
        return true;
    }
    protected java.lang.Character isWFXMLChar(java.lang.String chardata) {
        java.lang.Character refInvalidChar;
        if (chardata ==
              null ||
              chardata.
              length(
                ) ==
              0) {
            return null;
        }
        char[] dataarray =
          chardata.
          toCharArray(
            );
        int datalength =
          dataarray.
            length;
        if (fIsXMLVersion11) {
            int i =
              0;
            while (i <
                     datalength) {
                if (org.apache.xml.serializer.utils.XML11Char.
                      isXML11Invalid(
                        dataarray[i++])) {
                    char ch =
                      dataarray[i -
                                  1];
                    if (org.apache.xml.serializer.utils.XMLChar.
                          isHighSurrogate(
                            ch) &&
                          i <
                          datalength) {
                        char ch2 =
                          dataarray[i++];
                        if (org.apache.xml.serializer.utils.XMLChar.
                              isLowSurrogate(
                                ch2) &&
                              org.apache.xml.serializer.utils.XMLChar.
                              isSupplemental(
                                org.apache.xml.serializer.utils.XMLChar.
                                  supplemental(
                                    ch,
                                    ch2))) {
                            continue;
                        }
                    }
                    refInvalidChar =
                      new java.lang.Character(
                        ch);
                    return refInvalidChar;
                }
            }
        }
        else {
            int i =
              0;
            while (i <
                     datalength) {
                if (org.apache.xml.serializer.utils.XMLChar.
                      isInvalid(
                        dataarray[i++])) {
                    char ch =
                      dataarray[i -
                                  1];
                    if (org.apache.xml.serializer.utils.XMLChar.
                          isHighSurrogate(
                            ch) &&
                          i <
                          datalength) {
                        char ch2 =
                          dataarray[i++];
                        if (org.apache.xml.serializer.utils.XMLChar.
                              isLowSurrogate(
                                ch2) &&
                              org.apache.xml.serializer.utils.XMLChar.
                              isSupplemental(
                                org.apache.xml.serializer.utils.XMLChar.
                                  supplemental(
                                    ch,
                                    ch2))) {
                            continue;
                        }
                    }
                    refInvalidChar =
                      new java.lang.Character(
                        ch);
                    return refInvalidChar;
                }
            }
        }
        return null;
    }
    protected void isCommentWellFormed(java.lang.String data) {
        if (data ==
              null ||
              data.
              length(
                ) ==
              0) {
            return;
        }
        char[] dataarray =
          data.
          toCharArray(
            );
        int datalength =
          dataarray.
            length;
        if (fIsXMLVersion11) {
            int i =
              0;
            while (i <
                     datalength) {
                char c =
                  dataarray[i++];
                if (org.apache.xml.serializer.utils.XML11Char.
                      isXML11Invalid(
                        c)) {
                    if (org.apache.xml.serializer.utils.XMLChar.
                          isHighSurrogate(
                            c) &&
                          i <
                          datalength) {
                        char c2 =
                          dataarray[i++];
                        if (org.apache.xml.serializer.utils.XMLChar.
                              isLowSurrogate(
                                c2) &&
                              org.apache.xml.serializer.utils.XMLChar.
                              isSupplemental(
                                org.apache.xml.serializer.utils.XMLChar.
                                  supplemental(
                                    c,
                                    c2))) {
                            continue;
                        }
                    }
                    java.lang.String msg =
                      org.apache.xml.serializer.utils.Utils.
                        messages.
                      createMessage(
                        org.apache.xml.serializer.utils.MsgKey.
                          ER_WF_INVALID_CHARACTER_IN_COMMENT,
                        new java.lang.Object[] { new java.lang.Character(
                          c) });
                    if (fErrorHandler !=
                          null) {
                        fErrorHandler.
                          handleError(
                            new org.apache.xml.serializer.dom3.DOMErrorImpl(
                              org.w3c.dom.DOMError.
                                SEVERITY_FATAL_ERROR,
                              msg,
                              org.apache.xml.serializer.utils.MsgKey.
                                ER_WF_INVALID_CHARACTER,
                              null,
                              null,
                              null));
                    }
                }
                else
                    if (c ==
                          '-' &&
                          i <
                          datalength &&
                          dataarray[i] ==
                          '-') {
                        java.lang.String msg =
                          org.apache.xml.serializer.utils.Utils.
                            messages.
                          createMessage(
                            org.apache.xml.serializer.utils.MsgKey.
                              ER_WF_DASH_IN_COMMENT,
                            null);
                        if (fErrorHandler !=
                              null) {
                            fErrorHandler.
                              handleError(
                                new org.apache.xml.serializer.dom3.DOMErrorImpl(
                                  org.w3c.dom.DOMError.
                                    SEVERITY_FATAL_ERROR,
                                  msg,
                                  org.apache.xml.serializer.utils.MsgKey.
                                    ER_WF_INVALID_CHARACTER,
                                  null,
                                  null,
                                  null));
                        }
                    }
            }
        }
        else {
            int i =
              0;
            while (i <
                     datalength) {
                char c =
                  dataarray[i++];
                if (org.apache.xml.serializer.utils.XMLChar.
                      isInvalid(
                        c)) {
                    if (org.apache.xml.serializer.utils.XMLChar.
                          isHighSurrogate(
                            c) &&
                          i <
                          datalength) {
                        char c2 =
                          dataarray[i++];
                        if (org.apache.xml.serializer.utils.XMLChar.
                              isLowSurrogate(
                                c2) &&
                              org.apache.xml.serializer.utils.XMLChar.
                              isSupplemental(
                                org.apache.xml.serializer.utils.XMLChar.
                                  supplemental(
                                    c,
                                    c2))) {
                            continue;
                        }
                    }
                    java.lang.String msg =
                      org.apache.xml.serializer.utils.Utils.
                        messages.
                      createMessage(
                        org.apache.xml.serializer.utils.MsgKey.
                          ER_WF_INVALID_CHARACTER_IN_COMMENT,
                        new java.lang.Object[] { new java.lang.Character(
                          c) });
                    if (fErrorHandler !=
                          null) {
                        fErrorHandler.
                          handleError(
                            new org.apache.xml.serializer.dom3.DOMErrorImpl(
                              org.w3c.dom.DOMError.
                                SEVERITY_FATAL_ERROR,
                              msg,
                              org.apache.xml.serializer.utils.MsgKey.
                                ER_WF_INVALID_CHARACTER,
                              null,
                              null,
                              null));
                    }
                }
                else
                    if (c ==
                          '-' &&
                          i <
                          datalength &&
                          dataarray[i] ==
                          '-') {
                        java.lang.String msg =
                          org.apache.xml.serializer.utils.Utils.
                            messages.
                          createMessage(
                            org.apache.xml.serializer.utils.MsgKey.
                              ER_WF_DASH_IN_COMMENT,
                            null);
                        if (fErrorHandler !=
                              null) {
                            fErrorHandler.
                              handleError(
                                new org.apache.xml.serializer.dom3.DOMErrorImpl(
                                  org.w3c.dom.DOMError.
                                    SEVERITY_FATAL_ERROR,
                                  msg,
                                  org.apache.xml.serializer.utils.MsgKey.
                                    ER_WF_INVALID_CHARACTER,
                                  null,
                                  null,
                                  null));
                        }
                    }
            }
        }
        return;
    }
    protected void isElementWellFormed(org.w3c.dom.Node node) {
        boolean isNameWF =
          false;
        if ((fFeatures &
               NAMESPACES) !=
              0) {
            isNameWF =
              isValidQName(
                node.
                  getPrefix(
                    ),
                node.
                  getLocalName(
                    ),
                fIsXMLVersion11);
        }
        else {
            isNameWF =
              isXMLName(
                node.
                  getNodeName(
                    ),
                fIsXMLVersion11);
        }
        if (!isNameWF) {
            java.lang.String msg =
              org.apache.xml.serializer.utils.Utils.
                messages.
              createMessage(
                org.apache.xml.serializer.utils.MsgKey.
                  ER_WF_INVALID_CHARACTER_IN_NODE_NAME,
                new java.lang.Object[] { "Element",
                node.
                  getNodeName(
                    ) });
            if (fErrorHandler !=
                  null) {
                fErrorHandler.
                  handleError(
                    new org.apache.xml.serializer.dom3.DOMErrorImpl(
                      org.w3c.dom.DOMError.
                        SEVERITY_FATAL_ERROR,
                      msg,
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_WF_INVALID_CHARACTER_IN_NODE_NAME,
                      null,
                      null,
                      null));
            }
        }
    }
    protected void isAttributeWellFormed(org.w3c.dom.Node node) {
        boolean isNameWF =
          false;
        if ((fFeatures &
               NAMESPACES) !=
              0) {
            isNameWF =
              isValidQName(
                node.
                  getPrefix(
                    ),
                node.
                  getLocalName(
                    ),
                fIsXMLVersion11);
        }
        else {
            isNameWF =
              isXMLName(
                node.
                  getNodeName(
                    ),
                fIsXMLVersion11);
        }
        if (!isNameWF) {
            java.lang.String msg =
              org.apache.xml.serializer.utils.Utils.
                messages.
              createMessage(
                org.apache.xml.serializer.utils.MsgKey.
                  ER_WF_INVALID_CHARACTER_IN_NODE_NAME,
                new java.lang.Object[] { "Attr",
                node.
                  getNodeName(
                    ) });
            if (fErrorHandler !=
                  null) {
                fErrorHandler.
                  handleError(
                    new org.apache.xml.serializer.dom3.DOMErrorImpl(
                      org.w3c.dom.DOMError.
                        SEVERITY_FATAL_ERROR,
                      msg,
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_WF_INVALID_CHARACTER_IN_NODE_NAME,
                      null,
                      null,
                      null));
            }
        }
        java.lang.String value =
          node.
          getNodeValue(
            );
        if (value.
              indexOf(
                '<') >=
              0) {
            java.lang.String msg =
              org.apache.xml.serializer.utils.Utils.
                messages.
              createMessage(
                org.apache.xml.serializer.utils.MsgKey.
                  ER_WF_LT_IN_ATTVAL,
                new java.lang.Object[] { ((org.w3c.dom.Attr)
                                            node).
                  getOwnerElement(
                    ).
                  getNodeName(
                    ),
                node.
                  getNodeName(
                    ) });
            if (fErrorHandler !=
                  null) {
                fErrorHandler.
                  handleError(
                    new org.apache.xml.serializer.dom3.DOMErrorImpl(
                      org.w3c.dom.DOMError.
                        SEVERITY_FATAL_ERROR,
                      msg,
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_WF_LT_IN_ATTVAL,
                      null,
                      null,
                      null));
            }
        }
        org.w3c.dom.NodeList children =
          node.
          getChildNodes(
            );
        for (int i =
               0;
             i <
               children.
               getLength(
                 );
             i++) {
            org.w3c.dom.Node child =
              children.
              item(
                i);
            if (child ==
                  null) {
                continue;
            }
            switch (child.
                      getNodeType(
                        )) {
                case org.w3c.dom.Node.
                       TEXT_NODE:
                    isTextWellFormed(
                      (org.w3c.dom.Text)
                        child);
                    break;
                case org.w3c.dom.Node.
                       ENTITY_REFERENCE_NODE:
                    isEntityReferneceWellFormed(
                      (org.w3c.dom.EntityReference)
                        child);
                    break;
                default:
            }
        }
    }
    protected void isPIWellFormed(org.w3c.dom.ProcessingInstruction node) {
        if (!isXMLName(
               node.
                 getNodeName(
                   ),
               fIsXMLVersion11)) {
            java.lang.String msg =
              org.apache.xml.serializer.utils.Utils.
                messages.
              createMessage(
                org.apache.xml.serializer.utils.MsgKey.
                  ER_WF_INVALID_CHARACTER_IN_NODE_NAME,
                new java.lang.Object[] { "ProcessingInstruction",
                node.
                  getTarget(
                    ) });
            if (fErrorHandler !=
                  null) {
                fErrorHandler.
                  handleError(
                    new org.apache.xml.serializer.dom3.DOMErrorImpl(
                      org.w3c.dom.DOMError.
                        SEVERITY_FATAL_ERROR,
                      msg,
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_WF_INVALID_CHARACTER_IN_NODE_NAME,
                      null,
                      null,
                      null));
            }
        }
        java.lang.Character invalidChar =
          isWFXMLChar(
            node.
              getData(
                ));
        if (invalidChar !=
              null) {
            java.lang.String msg =
              org.apache.xml.serializer.utils.Utils.
                messages.
              createMessage(
                org.apache.xml.serializer.utils.MsgKey.
                  ER_WF_INVALID_CHARACTER_IN_PI,
                new java.lang.Object[] { java.lang.Integer.
                  toHexString(
                    java.lang.Character.
                      getNumericValue(
                        invalidChar.
                          charValue(
                            ))) });
            if (fErrorHandler !=
                  null) {
                fErrorHandler.
                  handleError(
                    new org.apache.xml.serializer.dom3.DOMErrorImpl(
                      org.w3c.dom.DOMError.
                        SEVERITY_FATAL_ERROR,
                      msg,
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_WF_INVALID_CHARACTER,
                      null,
                      null,
                      null));
            }
        }
    }
    protected void isCDATASectionWellFormed(org.w3c.dom.CDATASection node) {
        java.lang.Character invalidChar =
          isWFXMLChar(
            node.
              getData(
                ));
        if (invalidChar !=
              null) {
            java.lang.String msg =
              org.apache.xml.serializer.utils.Utils.
                messages.
              createMessage(
                org.apache.xml.serializer.utils.MsgKey.
                  ER_WF_INVALID_CHARACTER_IN_CDATA,
                new java.lang.Object[] { java.lang.Integer.
                  toHexString(
                    java.lang.Character.
                      getNumericValue(
                        invalidChar.
                          charValue(
                            ))) });
            if (fErrorHandler !=
                  null) {
                fErrorHandler.
                  handleError(
                    new org.apache.xml.serializer.dom3.DOMErrorImpl(
                      org.w3c.dom.DOMError.
                        SEVERITY_FATAL_ERROR,
                      msg,
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_WF_INVALID_CHARACTER,
                      null,
                      null,
                      null));
            }
        }
    }
    protected void isTextWellFormed(org.w3c.dom.Text node) {
        java.lang.Character invalidChar =
          isWFXMLChar(
            node.
              getData(
                ));
        if (invalidChar !=
              null) {
            java.lang.String msg =
              org.apache.xml.serializer.utils.Utils.
                messages.
              createMessage(
                org.apache.xml.serializer.utils.MsgKey.
                  ER_WF_INVALID_CHARACTER_IN_TEXT,
                new java.lang.Object[] { java.lang.Integer.
                  toHexString(
                    java.lang.Character.
                      getNumericValue(
                        invalidChar.
                          charValue(
                            ))) });
            if (fErrorHandler !=
                  null) {
                fErrorHandler.
                  handleError(
                    new org.apache.xml.serializer.dom3.DOMErrorImpl(
                      org.w3c.dom.DOMError.
                        SEVERITY_FATAL_ERROR,
                      msg,
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_WF_INVALID_CHARACTER,
                      null,
                      null,
                      null));
            }
        }
    }
    protected void isEntityReferneceWellFormed(org.w3c.dom.EntityReference node) {
        if (!isXMLName(
               node.
                 getNodeName(
                   ),
               fIsXMLVersion11)) {
            java.lang.String msg =
              org.apache.xml.serializer.utils.Utils.
                messages.
              createMessage(
                org.apache.xml.serializer.utils.MsgKey.
                  ER_WF_INVALID_CHARACTER_IN_NODE_NAME,
                new java.lang.Object[] { "EntityReference",
                node.
                  getNodeName(
                    ) });
            if (fErrorHandler !=
                  null) {
                fErrorHandler.
                  handleError(
                    new org.apache.xml.serializer.dom3.DOMErrorImpl(
                      org.w3c.dom.DOMError.
                        SEVERITY_FATAL_ERROR,
                      msg,
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_WF_INVALID_CHARACTER_IN_NODE_NAME,
                      null,
                      null,
                      null));
            }
        }
        org.w3c.dom.Node parent =
          node.
          getParentNode(
            );
        org.w3c.dom.DocumentType docType =
          node.
          getOwnerDocument(
            ).
          getDoctype(
            );
        if (docType !=
              null) {
            org.w3c.dom.NamedNodeMap entities =
              docType.
              getEntities(
                );
            for (int i =
                   0;
                 i <
                   entities.
                   getLength(
                     );
                 i++) {
                org.w3c.dom.Entity ent =
                  (org.w3c.dom.Entity)
                    entities.
                    item(
                      i);
                java.lang.String nodeName =
                  node.
                  getNodeName(
                    ) ==
                  null
                  ? ""
                  : node.
                  getNodeName(
                    );
                java.lang.String nodeNamespaceURI =
                  node.
                  getNamespaceURI(
                    ) ==
                  null
                  ? ""
                  : node.
                  getNamespaceURI(
                    );
                java.lang.String entName =
                  ent.
                  getNodeName(
                    ) ==
                  null
                  ? ""
                  : ent.
                  getNodeName(
                    );
                java.lang.String entNamespaceURI =
                  ent.
                  getNamespaceURI(
                    ) ==
                  null
                  ? ""
                  : ent.
                  getNamespaceURI(
                    );
                if (parent.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    if (entNamespaceURI.
                          equals(
                            nodeNamespaceURI) &&
                          entName.
                          equals(
                            nodeName)) {
                        if (ent.
                              getNotationName(
                                ) !=
                              null) {
                            java.lang.String msg =
                              org.apache.xml.serializer.utils.Utils.
                                messages.
                              createMessage(
                                org.apache.xml.serializer.utils.MsgKey.
                                  ER_WF_REF_TO_UNPARSED_ENT,
                                new java.lang.Object[] { node.
                                  getNodeName(
                                    ) });
                            if (fErrorHandler !=
                                  null) {
                                fErrorHandler.
                                  handleError(
                                    new org.apache.xml.serializer.dom3.DOMErrorImpl(
                                      org.w3c.dom.DOMError.
                                        SEVERITY_FATAL_ERROR,
                                      msg,
                                      org.apache.xml.serializer.utils.MsgKey.
                                        ER_WF_REF_TO_UNPARSED_ENT,
                                      null,
                                      null,
                                      null));
                            }
                        }
                    }
                }
                if (parent.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ATTRIBUTE_NODE) {
                    if (entNamespaceURI.
                          equals(
                            nodeNamespaceURI) &&
                          entName.
                          equals(
                            nodeName)) {
                        if (ent.
                              getPublicId(
                                ) !=
                              null ||
                              ent.
                              getSystemId(
                                ) !=
                              null ||
                              ent.
                              getNotationName(
                                ) !=
                              null) {
                            java.lang.String msg =
                              org.apache.xml.serializer.utils.Utils.
                                messages.
                              createMessage(
                                org.apache.xml.serializer.utils.MsgKey.
                                  ER_WF_REF_TO_EXTERNAL_ENT,
                                new java.lang.Object[] { node.
                                  getNodeName(
                                    ) });
                            if (fErrorHandler !=
                                  null) {
                                fErrorHandler.
                                  handleError(
                                    new org.apache.xml.serializer.dom3.DOMErrorImpl(
                                      org.w3c.dom.DOMError.
                                        SEVERITY_FATAL_ERROR,
                                      msg,
                                      org.apache.xml.serializer.utils.MsgKey.
                                        ER_WF_REF_TO_EXTERNAL_ENT,
                                      null,
                                      null,
                                      null));
                            }
                        }
                    }
                }
            }
        }
    }
    protected void checkUnboundPrefixInEntRef(org.w3c.dom.Node node) {
        org.w3c.dom.Node child;
        org.w3c.dom.Node next;
        for (child =
               node.
                 getFirstChild(
                   );
             child !=
               null;
             child =
               next) {
            next =
              child.
                getNextSibling(
                  );
            if (child.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                java.lang.String prefix =
                  child.
                  getPrefix(
                    );
                if (prefix !=
                      null &&
                      fNSBinder.
                      getURI(
                        prefix) ==
                      null) {
                    java.lang.String msg =
                      org.apache.xml.serializer.utils.Utils.
                        messages.
                      createMessage(
                        org.apache.xml.serializer.utils.MsgKey.
                          ER_ELEM_UNBOUND_PREFIX_IN_ENTREF,
                        new java.lang.Object[] { node.
                          getNodeName(
                            ),
                        child.
                          getNodeName(
                            ),
                        prefix });
                    if (fErrorHandler !=
                          null) {
                        fErrorHandler.
                          handleError(
                            new org.apache.xml.serializer.dom3.DOMErrorImpl(
                              org.w3c.dom.DOMError.
                                SEVERITY_FATAL_ERROR,
                              msg,
                              org.apache.xml.serializer.utils.MsgKey.
                                ER_ELEM_UNBOUND_PREFIX_IN_ENTREF,
                              null,
                              null,
                              null));
                    }
                }
                org.w3c.dom.NamedNodeMap attrs =
                  child.
                  getAttributes(
                    );
                for (int i =
                       0;
                     i <
                       attrs.
                       getLength(
                         );
                     i++) {
                    java.lang.String attrPrefix =
                      attrs.
                      item(
                        i).
                      getPrefix(
                        );
                    if (attrPrefix !=
                          null &&
                          fNSBinder.
                          getURI(
                            attrPrefix) ==
                          null) {
                        java.lang.String msg =
                          org.apache.xml.serializer.utils.Utils.
                            messages.
                          createMessage(
                            org.apache.xml.serializer.utils.MsgKey.
                              ER_ATTR_UNBOUND_PREFIX_IN_ENTREF,
                            new java.lang.Object[] { node.
                              getNodeName(
                                ),
                            child.
                              getNodeName(
                                ),
                            attrs.
                              item(
                                i) });
                        if (fErrorHandler !=
                              null) {
                            fErrorHandler.
                              handleError(
                                new org.apache.xml.serializer.dom3.DOMErrorImpl(
                                  org.w3c.dom.DOMError.
                                    SEVERITY_FATAL_ERROR,
                                  msg,
                                  org.apache.xml.serializer.utils.MsgKey.
                                    ER_ATTR_UNBOUND_PREFIX_IN_ENTREF,
                                  null,
                                  null,
                                  null));
                        }
                    }
                }
            }
            if (child.
                  hasChildNodes(
                    )) {
                checkUnboundPrefixInEntRef(
                  child);
            }
        }
    }
    protected void recordLocalNSDecl(org.w3c.dom.Node node) {
        org.w3c.dom.NamedNodeMap atts =
          ((org.w3c.dom.Element)
             node).
          getAttributes(
            );
        int length =
          atts.
          getLength(
            );
        for (int i =
               0;
             i <
               length;
             i++) {
            org.w3c.dom.Node attr =
              atts.
              item(
                i);
            java.lang.String localName =
              attr.
              getLocalName(
                );
            java.lang.String attrPrefix =
              attr.
              getPrefix(
                );
            java.lang.String attrValue =
              attr.
              getNodeValue(
                );
            java.lang.String attrNS =
              attr.
              getNamespaceURI(
                );
            localName =
              localName ==
                null ||
                XMLNS_PREFIX.
                equals(
                  localName)
                ? ""
                : localName;
            attrPrefix =
              attrPrefix ==
                null
                ? ""
                : attrPrefix;
            attrValue =
              attrValue ==
                null
                ? ""
                : attrValue;
            attrNS =
              attrNS ==
                null
                ? ""
                : attrNS;
            if (XMLNS_URI.
                  equals(
                    attrNS)) {
                if (XMLNS_URI.
                      equals(
                        attrValue)) {
                    java.lang.String msg =
                      org.apache.xml.serializer.utils.Utils.
                        messages.
                      createMessage(
                        org.apache.xml.serializer.utils.MsgKey.
                          ER_NS_PREFIX_CANNOT_BE_BOUND,
                        new java.lang.Object[] { attrPrefix,
                        XMLNS_URI });
                    if (fErrorHandler !=
                          null) {
                        fErrorHandler.
                          handleError(
                            new org.apache.xml.serializer.dom3.DOMErrorImpl(
                              org.w3c.dom.DOMError.
                                SEVERITY_ERROR,
                              msg,
                              org.apache.xml.serializer.utils.MsgKey.
                                ER_NS_PREFIX_CANNOT_BE_BOUND,
                              null,
                              null,
                              null));
                    }
                }
                else {
                    if (XMLNS_PREFIX.
                          equals(
                            attrPrefix)) {
                        if (attrValue.
                              length(
                                ) !=
                              0) {
                            fNSBinder.
                              declarePrefix(
                                localName,
                                attrValue);
                        }
                        else {
                            
                        }
                    }
                    else {
                        fNSBinder.
                          declarePrefix(
                            "",
                            attrValue);
                    }
                }
            }
        }
    }
    protected void fixupElementNS(org.w3c.dom.Node node)
          throws org.xml.sax.SAXException {
        java.lang.String namespaceURI =
          ((org.w3c.dom.Element)
             node).
          getNamespaceURI(
            );
        java.lang.String prefix =
          ((org.w3c.dom.Element)
             node).
          getPrefix(
            );
        java.lang.String localName =
          ((org.w3c.dom.Element)
             node).
          getLocalName(
            );
        if (namespaceURI !=
              null) {
            prefix =
              prefix ==
                null
                ? ""
                : prefix;
            java.lang.String inScopeNamespaceURI =
              fNSBinder.
              getURI(
                prefix);
            if (inScopeNamespaceURI !=
                  null &&
                  inScopeNamespaceURI.
                  equals(
                    namespaceURI)) {
                
            }
            else {
                if ((fFeatures &
                       NAMESPACEDECLS) !=
                      0) {
                    if ("".
                          equals(
                            prefix) ||
                          "".
                          equals(
                            namespaceURI)) {
                        ((org.w3c.dom.Element)
                           node).
                          setAttributeNS(
                            XMLNS_URI,
                            XMLNS_PREFIX,
                            namespaceURI);
                    }
                    else {
                        ((org.w3c.dom.Element)
                           node).
                          setAttributeNS(
                            XMLNS_URI,
                            XMLNS_PREFIX +
                            ":" +
                            prefix,
                            namespaceURI);
                    }
                }
                fLocalNSBinder.
                  declarePrefix(
                    prefix,
                    namespaceURI);
                fNSBinder.
                  declarePrefix(
                    prefix,
                    namespaceURI);
            }
        }
        else {
            if (localName ==
                  null ||
                  "".
                  equals(
                    localName)) {
                java.lang.String msg =
                  org.apache.xml.serializer.utils.Utils.
                    messages.
                  createMessage(
                    org.apache.xml.serializer.utils.MsgKey.
                      ER_NULL_LOCAL_ELEMENT_NAME,
                    new java.lang.Object[] { node.
                      getNodeName(
                        ) });
                if (fErrorHandler !=
                      null) {
                    fErrorHandler.
                      handleError(
                        new org.apache.xml.serializer.dom3.DOMErrorImpl(
                          org.w3c.dom.DOMError.
                            SEVERITY_ERROR,
                          msg,
                          org.apache.xml.serializer.utils.MsgKey.
                            ER_NULL_LOCAL_ELEMENT_NAME,
                          null,
                          null,
                          null));
                }
            }
            else {
                namespaceURI =
                  fNSBinder.
                    getURI(
                      "");
                if (namespaceURI !=
                      null &&
                      namespaceURI.
                      length(
                        ) >
                      0) {
                    ((org.w3c.dom.Element)
                       node).
                      setAttributeNS(
                        XMLNS_URI,
                        XMLNS_PREFIX,
                        "");
                    fLocalNSBinder.
                      declarePrefix(
                        "",
                        "");
                    fNSBinder.
                      declarePrefix(
                        "",
                        "");
                }
            }
        }
    }
    private static final java.util.Hashtable
      s_propKeys =
      new java.util.Hashtable(
      );
    static { int i = CDATA;
             java.lang.Integer val = new java.lang.Integer(
               i);
             s_propKeys.put(org.apache.xml.serializer.dom3.DOMConstants.
                              S_DOM3_PROPERTIES_NS +
                            org.apache.xml.serializer.dom3.DOMConstants.
                              DOM_CDATA_SECTIONS,
                            val);
             int i1 = COMMENTS;
             val = new java.lang.Integer(
                     i1);
             s_propKeys.put(org.apache.xml.serializer.dom3.DOMConstants.
                              S_DOM3_PROPERTIES_NS +
                            org.apache.xml.serializer.dom3.DOMConstants.
                              DOM_COMMENTS,
                            val);
             int i2 = ELEM_CONTENT_WHITESPACE;
             val = new java.lang.Integer(
                     i2);
             s_propKeys.put(org.apache.xml.serializer.dom3.DOMConstants.
                              S_DOM3_PROPERTIES_NS +
                            org.apache.xml.serializer.dom3.DOMConstants.
                              DOM_ELEMENT_CONTENT_WHITESPACE,
                            val);
             int i3 = ENTITIES;
             val = new java.lang.Integer(
                     i3);
             s_propKeys.put(org.apache.xml.serializer.dom3.DOMConstants.
                              S_DOM3_PROPERTIES_NS +
                            org.apache.xml.serializer.dom3.DOMConstants.
                              DOM_ENTITIES,
                            val);
             int i4 = NAMESPACES;
             val = new java.lang.Integer(
                     i4);
             s_propKeys.put(org.apache.xml.serializer.dom3.DOMConstants.
                              S_DOM3_PROPERTIES_NS +
                            org.apache.xml.serializer.dom3.DOMConstants.
                              DOM_NAMESPACES,
                            val);
             int i5 = NAMESPACEDECLS;
             val = new java.lang.Integer(
                     i5);
             s_propKeys.put(org.apache.xml.serializer.dom3.DOMConstants.
                              S_DOM3_PROPERTIES_NS +
                            org.apache.xml.serializer.dom3.DOMConstants.
                              DOM_NAMESPACE_DECLARATIONS,
                            val);
             int i6 = SPLITCDATA;
             val = new java.lang.Integer(
                     i6);
             s_propKeys.put(org.apache.xml.serializer.dom3.DOMConstants.
                              S_DOM3_PROPERTIES_NS +
                            org.apache.xml.serializer.dom3.DOMConstants.
                              DOM_SPLIT_CDATA,
                            val);
             int i7 = WELLFORMED;
             val = new java.lang.Integer(
                     i7);
             s_propKeys.put(org.apache.xml.serializer.dom3.DOMConstants.
                              S_DOM3_PROPERTIES_NS +
                            org.apache.xml.serializer.dom3.DOMConstants.
                              DOM_WELLFORMED,
                            val);
             int i8 = DISCARDDEFAULT;
             val = new java.lang.Integer(
                     i8);
             s_propKeys.put(org.apache.xml.serializer.dom3.DOMConstants.
                              S_DOM3_PROPERTIES_NS +
                            org.apache.xml.serializer.dom3.DOMConstants.
                              DOM_DISCARD_DEFAULT_CONTENT,
                            val);
             s_propKeys.put(org.apache.xml.serializer.dom3.DOMConstants.
                              S_DOM3_PROPERTIES_NS +
                            org.apache.xml.serializer.dom3.DOMConstants.
                              DOM_FORMAT_PRETTY_PRINT,
                            "");
             s_propKeys.put(org.apache.xml.serializer.dom3.DOMConstants.
                              S_XSL_OUTPUT_OMIT_XML_DECL,
                            "");
             s_propKeys.put(org.apache.xml.serializer.dom3.DOMConstants.
                              S_XERCES_PROPERTIES_NS +
                            org.apache.xml.serializer.dom3.DOMConstants.
                              S_XML_VERSION,
                            "");
             s_propKeys.put(org.apache.xml.serializer.dom3.DOMConstants.
                              S_XSL_OUTPUT_ENCODING,
                            "");
             s_propKeys.put(org.apache.xml.serializer.dom3.DOMConstants.
                              S_XERCES_PROPERTIES_NS +
                            org.apache.xml.serializer.dom3.DOMConstants.
                              DOM_ENTITIES,
                            ""); }
    protected void initProperties(java.util.Properties properties) {
        for (java.util.Enumeration keys =
               properties.
               keys(
                 );
             keys.
               hasMoreElements(
                 );
             ) {
            final java.lang.String key =
              (java.lang.String)
                keys.
                nextElement(
                  );
            final java.lang.Object iobj =
              s_propKeys.
              get(
                key);
            if (iobj !=
                  null) {
                if (iobj instanceof java.lang.Integer) {
                    final int BITFLAG =
                      ((java.lang.Integer)
                         iobj).
                      intValue(
                        );
                    if (properties.
                          getProperty(
                            key).
                          endsWith(
                            "yes")) {
                        fFeatures =
                          fFeatures |
                            BITFLAG;
                    }
                    else {
                        fFeatures =
                          fFeatures &
                            ~BITFLAG;
                    }
                }
                else {
                    if ((org.apache.xml.serializer.dom3.DOMConstants.
                           S_DOM3_PROPERTIES_NS +
                         org.apache.xml.serializer.dom3.DOMConstants.
                           DOM_FORMAT_PRETTY_PRINT).
                          equals(
                            key)) {
                        if (properties.
                              getProperty(
                                key).
                              endsWith(
                                "yes")) {
                            fSerializer.
                              setIndent(
                                true);
                            fSerializer.
                              setIndentAmount(
                                3);
                        }
                        else {
                            fSerializer.
                              setIndent(
                                false);
                        }
                    }
                    else
                        if (org.apache.xml.serializer.dom3.DOMConstants.
                              S_XSL_OUTPUT_OMIT_XML_DECL.
                              equals(
                                key)) {
                            if (properties.
                                  getProperty(
                                    key).
                                  endsWith(
                                    "yes")) {
                                fSerializer.
                                  setOmitXMLDeclaration(
                                    true);
                            }
                            else {
                                fSerializer.
                                  setOmitXMLDeclaration(
                                    false);
                            }
                        }
                        else
                            if ((org.apache.xml.serializer.dom3.DOMConstants.
                                   S_XERCES_PROPERTIES_NS +
                                 org.apache.xml.serializer.dom3.DOMConstants.
                                   S_XML_VERSION).
                                  equals(
                                    key)) {
                                java.lang.String version =
                                  properties.
                                  getProperty(
                                    key);
                                if ("1.1".
                                      equals(
                                        version)) {
                                    fIsXMLVersion11 =
                                      true;
                                    fSerializer.
                                      setVersion(
                                        version);
                                }
                                else {
                                    fSerializer.
                                      setVersion(
                                        "1.0");
                                }
                            }
                            else
                                if (org.apache.xml.serializer.dom3.DOMConstants.
                                      S_XSL_OUTPUT_ENCODING.
                                      equals(
                                        key)) {
                                    java.lang.String encoding =
                                      properties.
                                      getProperty(
                                        key);
                                    if (encoding !=
                                          null) {
                                        fSerializer.
                                          setEncoding(
                                            encoding);
                                    }
                                }
                                else
                                    if ((org.apache.xml.serializer.dom3.DOMConstants.
                                           S_XERCES_PROPERTIES_NS +
                                         org.apache.xml.serializer.dom3.DOMConstants.
                                           DOM_ENTITIES).
                                          equals(
                                            key)) {
                                        if (properties.
                                              getProperty(
                                                key).
                                              endsWith(
                                                "yes")) {
                                            fSerializer.
                                              setDTDEntityExpansion(
                                                false);
                                        }
                                        else {
                                            fSerializer.
                                              setDTDEntityExpansion(
                                                true);
                                        }
                                    }
                                    else {
                                        
                                    }
                }
            }
        }
        if (fNewLine !=
              null) {
            fSerializer.
              setOutputProperty(
                org.apache.xml.serializer.OutputPropertiesFactory.
                  S_KEY_LINE_SEPARATOR,
                fNewLine);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1cC3Qc1Xm+uytL8ls2YBsbvw2pjdHamKcFjmVphRavpEUr" +
       "P5Abr0e7s9LYszvDzKy1Nhhjnxp8oHVIMI9C7HDAoUAdTGndEkiMc6BACgmF" +
       "kDQ8Qii0AQr0QAMxgTb0/+/c3ZmdnTvrWXSic+buaOb+9/+/7/73v4+5M4c/" +
       "JKN0jcxThVxaaDa2qaLeHMfzuKDpYrpNFnS9D64mUzf++y07T/x89K4gqe8n" +
       "E4YEvSsl6GKHJMppvZ/MlHK6IeRSot4timmUiGuiLmpbBUNScv3kNEmPZlVZ" +
       "SklGl5IWMcNaQYuRSYJhaNJA3hCjrACDzI5Ra8LUmnCrM0NLjIxLKeo2S2B6" +
       "mUCb7R7mzVr6dIM0xTYLW4Vw3pDkcEzSjZaCRs5WFXnboKwYzWLBaN4sn8+I" +
       "uDx2fgUN8x6e+Psvbh5qojScIuRyikEh6r2irshbxXSMTLSuRmQxq19FriWh" +
       "GBlry2yQBbGi0jAoDYPSIl4rF1g/Xszls20KhWMUS6pXU2iQQeaWF6IKmpBl" +
       "xcSpzVBCo8GwU2FAO6eEtljdDoi3nh3ef/vGpkdCZGI/mSjlEmhOCowwQEk/" +
       "ECpmB0RNb02nxXQ/mZSDCk+ImiTI0nZW25N1aTAnGHlwgSIteDGvihrVaXEF" +
       "NQnYtHzKULQSvAx1KvbfqIwsDALWKRZWE2EHXgeAYyQwTMsI4HtMpG6LlEtT" +
       "PyqXKGFcsBoygGhDVjSGlJKqupwAF8hk00VkITcYToDz5QYh6ygFXFCjvsYp" +
       "FLlWhdQWYVBMGmSaM1/cvAW5RlMiUMQgpzmz0ZKglqY7aslWPx92X7Lv6lxn" +
       "LkgCYHNaTMlo/1gQmuUQ6hUzoiZCOzAFxy2K3SZM+dHeICGQ+TRHZjPPP13z" +
       "8crFs44/a+aZ4ZKnZ2CzmDKSqUMDE148o23hxSE0o1FVdAkrvww5bWVxdqel" +
       "oEKkmVIqEW82F28e7336yuseFN8PkjFRUp9S5HwW/GhSSsmqkixql4k5URMM" +
       "MR0lo8Vcuo3ej5IGOI9JOdG82pPJ6KIRJXUyvVSv0P+BogwUgRSNgXMpl1GK" +
       "56pgDNHzgkoIqYeDjIWjnZh/9NcgufCQkhXDQkrISTklHNcUxI8VSmOOqMN5" +
       "Gu6qSrgggNOcszl5bvLC5LlhXUuFFW0wLIBXDInhQlYO66ydiFo4rWSXhdt7" +
       "upb1aaK4TpC3iFoz+p36J9dYQA5OGQ4EoHrOcAYHGdpVpyKnRS2Z2p9fFfn4" +
       "oeRzpuNhY2HsGeQcUNtsqm0Gtc2W2mZU21yulgQCVNupqN50BKjGLRAQICKP" +
       "W5j4xuWb9s4LgQeqw3VQB5j1rIoeqs2KHMVwn0wdfrH3xAs/HfNgkAQhuAxA" +
       "D2V1EwvKugmzl9OUlJiGOMXrMIpBM8zvIlztIMfvGN61ducSaoc98mOBoyBo" +
       "oXgc43VJxQJni3crd+IN7/7+yG07FKvtl3UlxR6wQhJDyjxn3TrBJ1OL5ghH" +
       "kz/asSBI6iBOQWw2BGhLEPZmOXWUhZaWYphGLI0AOKNoWUHGW8XYOsYY0pRh" +
       "6wp1ukn0/FSoYqxmMhmO51njo794d4qK6VTTSdFnHChoN3BpQj3wq5+9t4zS" +
       "XewxJtq6+oRotNiiFBY2mcajSZYLon9Cvl/fEb/l1g9v2ED9D3LMd1O4ANM2" +
       "iE5QhUDznmeveuU3bxx6OVjyWVIox1bngQ3d2zIDgpsMzR2dZcGaHDijlJGE" +
       "AVnEtvG/E89cevSDfU1m9ctwpeg9i6sXYF0/fRW57rmNJ2bRYgIp7Fwtqqxs" +
       "ZsQ+xSq5VdOEbWhHYddLM//6GeEAxH6Itzq0cxpC6yj0Oop8mkGa+UGhbMDQ" +
       "CU0RgnxRbAaKDS9LYeTAwBHRNEVz5JlrzyPrzbFEolR4hyQbVs4maj525s1m" +
       "Z049aRm93UzTc7E6WKXh/5diskC3t8jyRm8boiVTN7/80fi1Hx37mHJZPsaz" +
       "O2CXoLaYPo/JmQUofqoz+nUK+hDkO+949583yce/gBL7ocQUDGz0Hg0icKHM" +
       "XVnuUQ2v/vjJKZteDJFgBxkjK0K6Q6Atn4yGJifqQxC8C+rXV5quN9wISROF" +
       "SirAY23PdvejSFY1aM1vf3TqP1zyNwffoJ5u+vgMKr5Qx6GlM0jT+YEVXz54" +
       "7a63nzhxb4M5uljID6oOuWmf98gDu9/6rIJkGk5dRj4O+f7w4e9Mb1vxPpW3" +
       "4hpKzy9U9noQ+S3Zcx/MfhqcV//PQdLQT5pSbCy+VpDzGC36YfypFwfoMF4v" +
       "u18+ljQHTi2luH2GM6ba1DojqtXbwjnmxvPxjiA6DmvxPDhWs0Cz2hlEA4Se" +
       "dFORs2i6EJPFZj9rkAZVk2DOJjqi11iPQg0I91bjw0vnmbEa0xWY9JiltXKd" +
       "sLMcwvlwxJm2OAfCOhMCJldU2sqTNkhjJqakhOJsA+LDbIwkNDoJheYhUYah" +
       "OYQTMw9OWR1Y1vvEshSOBLMmwcGyyRMLT9og4zP20IgXL3BYK/i0thmOtUzf" +
       "Wo61g57W8qTBtTJmYMZ/L3LYOeTTToxaVzJNV3LszHnayZOGqJ2JiQUpJciO" +
       "LmeW3VEwYJVncyBSfCKaB8cGZtMGDqJhT0Q8aYNMyqwbEow+JTGkDLPOETs3" +
       "W6zGNZlEfkA34pqUhRHSVjZjPDLlxFVPNWxvL84G3UTMnKv1rhce63wnSUdg" +
       "jTjw7itGKduQulUbtA3/mkwQX8JfAI4/4oHG4wX8hfDZxiaAc0ozQFXFvtOj" +
       "63BACO+Y/Jst33n3+yYEZz/hyCzu3X/jl8379pvjK3MZYX7FTN4uYy4lmHAw" +
       "2YnWzfXSQiU63jmy4/H7d9xgWjW5fFIcyeWz3//l/z3ffMebP3GZa4UkthSE" +
       "rSBQmiFNcdaOCal+6YE/7Lz+Vz0wpI+SxnxOuiovRtPlPUqDnh+wVZe1QGH1" +
       "MgwcVo1BAougFhwOX/Dp8PPh2MhcdiPH4b/p6fA8aQzy3eIwLgzg/8sdht7s" +
       "09BlcAhMlcAx9DZPQ3nSBjk1A+NbGD1kpEGYjeHymASDPRZwbLNj66YDzO0+" +
       "wSyEI83MSXPAfNcTDE/aIOMy0VwkZ0jGNpgcUsFrWIvAn1228z3QGwwoiiwK" +
       "Oacj4783OX3rbp8oz4JjkNk5yEH5t54oedI42FnfFVsLIZRNI53uddinrYvh" +
       "2My0bebY+oinrTxp7MqiumXt0qV4+ZDD3r+vwYOyTGOWY+8PPO3lSVMP0mPi" +
       "VlFeBs3CzdjHfBo7Cw6VqVM5xh73NJYnbZDRmQ7RXOPGC9c6LP3xyVtKdc2G" +
       "Q2e6dI6lz1iWLqpcXeBJG2QMhMOCEdV7hWE3Up89eVNPx6sxOLYyZVsrTIVJ" +
       "xMwhw1CXh8PDw8MwR8dVgPC5S5YswfXInB7GfD9zn4CE8LTXIPU6feRgwBxI" +
       "ygmyYzIyzUM/VAs4fHciuaY36tY6X/CJ9UI4tjFd29ywjqKg8P9XvDBh8nNM" +
       "XnYBw1MADcIEE++NdETXu+F51SeeK+C4hqm7xg3Pgsq6AxvCSy+++KIwjhh0" +
       "VUjRbvWtmuHy9EOnAKp4Nfe2T6TYbe9kmna6IQ1BzeF/79cMhFc8tDgEwq+1" +
       "D04eywS8ijF3N1O2uwKLGRw+cYcBQEermmKIKRg7OzCM9ygW41t3YhUMVa0Z" +
       "ULjKIn930T8SeVVVNMOB+lOfqHEyuoeZt4eD+ksrJJ6oBMeTNsgEugwgFxHi" +
       "1S/KzQ2QGmZwe5nCve7mBuo9+xqeNJ3py2JWzBntomo+s3L0N4EGn80Dh1z7" +
       "mL59lc2jtDJOF06jOUMcFLXJb9196MSuGy4K4qrvqK24wgWTF9sCa3cenwxf" +
       "f/jWmWP3v3kTXSIk5pguML7mVsazEjy0rbW7pzva1hpzY2SCT0bQ3b7FdH3L" +
       "hREscyJcDuLJtJrh8FRAV9LW3trX6gbldJ9QLoBjP9Oz3wNKHZ7MrRkKTwX4" +
       "a1tna293T29XayzaH3GDNM8nJFxHu53pu90DUiOeLKoZEk8FzCnberq6It19" +
       "CTc0Z/tEg4u0dzJVd3qgwVl3YFnNaHgqYBbT3udZPef5BITZDjBtBzwAzcGT" +
       "S2oGxFNhkKmRWKQr2dbT3Qd1lFzXGe2LJOKtba7gLq3B9+5mmu/2ALcSTyI1" +
       "g+OpAN8DTNG+aMTV9zp8olkCx71M1b0eaK7DE86TgpNAw1MBo7xod0dPItLn" +
       "BsbHo4LSKO8+puk+PpgAXg+sqxkMTwWM9Lpbu0xPc60cH48LSvONB5iyB/h4" +
       "ghTPpprx8FTAwKiEpz3SFnPF5OOhAsV0ERyHmcLDfEx1FJNUMyaeCsRUDHXY" +
       "Lbli2lxDAD/CFB7hY2qkmLSaMfFUgN8l4rFoH3fEoNcwHHyEKXuEj6eJ4rm6" +
       "Zjw8FRDi1kIFARrXgH1NDR53lKk6ykczh6L5i5rR8FSAxyXaOiNdrV6Y9tTg" +
       "cY8yhY/yMa2kmP6qZkw8FeBx6yKxWAe0pEi7G559NdTRD5myH/LxXEfx3FYz" +
       "Hp4KqKP2aKKttbe9PdLRuibm2hv5WF0vjbufYAqf4GIK0OuB79aMiafCIOPi" +
       "vZG+viuT8d5otysiHyvpFFErHE8ydU9yEQVNRPfXjIinAsZ10csgekeSGLmT" +
       "7RHPQesDNYzrnmaan+aCqzPB/V3N4HgqzPUu7GbdwDzifwTecMjMav6WgTGX" +
       "Hx6rFQO3ZAgLelLVFHW1uE3H7UOuj4h7hWG6fzmZ+st5e3Z9reHjC8znnnNc" +
       "c9u2Oi87ccHEOQ/enzOzuz+ydmxyfuvq5+5RXn8/GGS7uXaUwNBFpanEDKWk" +
       "+GuQoRHcbps2smFNzITb8rqhZM0NZ3FFkYtbe/9kuvAx9IyK7VhWRRx97L4L" +
       "9y5ef4/J7FzO43Qr/w+uePPFA9uPHDafR+PzfYOczXuHofLFCdx/eqbHHlqr" +
       "yj+9bPnx995e+41i/U1Ax33KdMlphn03Im6AM3BjI+Z4nmao8iAx8LhHoyq4" +
       "N46Ao0nQv1HEsU3c1iRozhnFTaAamcnbyU83Ahzavf9guud7S4twrzfIaENR" +
       "z5HxMZitqJl0W4GzPrvo+wvWXrULXzoReu3b08ZVbn/GkmZxNjcv4leMU8Ez" +
       "u/9ret+KoU0+9jXPduB3FvlA1+GfXHZW6ttB+gqGuTWu4tWNcqGW8u0LYzTR" +
       "yGu58g0L80o1hkurdHX2E1ZjnzjDo+Ulbuvn9Wp+QJZSjqg4xqNAmrPZ6ZFF" +
       "F26y713thvpA/YH/8BaaZt99lGhdHymkRBWZp8LvYvJrGEUbmrBVhJZHxRyP" +
       "3Ou2KlLaagtvVOtgyraG4oUO2iO+Uk7sYjByhVmC+cshFkXfrKCQK+pgI0jt" +
       "oEuv/0kTCvuEO2d46z2a4Q+Y/I+NF/z/A4uD331lDnDPOi6pBLYzINt9OFew" +
       "1PE6+9xJHiXyQVNWgnVVWAnW4+kfYQSclnRVMKBDaRsyw4Gdmy+/Mje0w/0a" +
       "qL6JIbnJ2z9cHuFwRauR0FSNhMmYjIVoCyFFM7AZluMPjhsZ/GeC1mMMxDH/" +
       "+Hmi1fCfUQ3/LExwDCrm0i7op31l9FPw1lzQ+TqD8Lp/9DxR7+hArqUI/8yR" +
       "y7bHP7gIk/kGdGGqKm+zNqYeshhYMDL13wHmf8RgfOSfAZ6oOwNlvUXpFQol" +
       "lcdnh8X+8RBl4LxqDoJ7dINh6K5Kj3mhIFaG3VOWjAxPMBkLLjdLMH998cQV" +
       "9e5VT7Hz1KZkkSYKflU1djowudTODhN3sLNiZNiBeXiQba0OVmzMrs4OT9Tb" +
       "i8rYYQ+gLQeKV6MIFyCCq+0UWWXYKYqNnAOxx3fBiieE1SniiXJRBq+gKDdW" +
       "o2ETJlfaaWg1jJj56padhv6RoQEaQGjYLMH89UUDV9S7HZW9jkXfK9R1mI1G" +
       "2XuIbJga3FyNK9xRGYSZ5dgSV/Gog6bMyNDUAhhvYVhv8U8TT/QkBvGlcINr" +
       "9wnRYqdQjR3cThvUDXKaFXNsZTh4MkaGp7MB5G8Z2N/654kn6s1T2QypDyal" +
       "FP711fi5EZNdBhlf4gdlHbzsHhlepgLImWYJdTN882KKuIh6B+SyNyNLW63N" +
       "1S8rMO+vxtMdmHwT3NEKzBVl2SmrumP+5MaCswFvH8Pd558ynih3LGhuuzM5" +
       "ucdjLIj7YYMHYCYg4WbpbrauYBsJHhwZ/PPA+CEGYsg/fp6oA1nIWtJd7iDh" +
       "IQ8SHsbkAYOMk/S14BLpK1x4eHDE5gR1bGdeXcW+vuo88EQ9/KA0oLG2quGM" +
       "V0jBqJ+if8yDmWOYHIU+SdLXdYCDoKSDmH/8ysTgcwJ8JaaOPQmpq3jYUp0Y" +
       "nig3HJDlFOCzHuD/BZMnK8AHH7fAPzUyAXUZIaMCZgnmry/wXNFq4F/2AP9L" +
       "TF4At8E3fOngfp0oyx2KlhXTjhD5ryM2hh2VZ0jy/kngifI7BHOx4E0PEt7C" +
       "5DVKAhu+c0l4feQ84S6G5C7/JPBEq5HwgQcJ/43JOwZ+xqr0PSouDe+ODA2X" +
       "AobPGZbP/dPAE+XSENxCoX7mQcPnmPzOIBMkPR7l4v9kZPCvIKT+HLME89cX" +
       "fq4oH/82LDXkXD214Q/hwmnwSxg4QUCwjbx5TISqbiE/OSaaAcblDM7l/png" +
       "ifKZuIGidS6h2pnA1dPQWBipSzqOsbkMjNAiajuYLzEYkn8GeKJ8Bm6lKJ2L" +
       "qHYGcP00NBXG5BAXrdFzTkxxA0Poq6+pUjIuAiS/YIh+4Z8MnmiV+BjyWE4N" +
       "4XJqaL5BpqeGxNSWNbkBJZ9LxzUxIxXoO6HAjYOLEVpdDRPSMNsswfz1xQVX" +
       "tBoXzsVTOxf4DYZQ2CCTNDGlaGn2nkm7+Zk2OwUjtHC6GOxnr0I3VLxIXZ0C" +
       "nmg1ClbyM9BZZmgVJi34qo1UyKts7NCdcJBwyYi1iUY2BGz0P3rkivJHj3dR" +
       "jDEPP+jG5DLsLHOSUfYCtx1/p3/8Bdy7VvY9Nfxwz7SKzzqanyJMPXRwYuPU" +
       "g2v+jX7Tq/S5wHEx0pjJy7L9uzK283qVNl6a0/zKDH3hP7SGfQeD/xaYATrg" +
       "B20P9ZlC6w1yOlcIdxCV/rFLbQCY5VLmO3v2PBtB2spjkHrzxJ5FACnIgqcD" +
       "KmW0/KNQ5ld5CubaU2nbRrF+yGnV6se202N+2T4K+jXO4p6HfJztozly8PLu" +
       "qz++4Hvml8pSsrB9O5YyNkYazI+m0UJDFXty7KUVy6rvXPjFhIdHn1ncOzLJ" +
       "NNhy9xmWO9LnUCo6ynTH97z0BaXPer1y6JJjP91b/1KQBDaQADB3yobK7xcV" +
       "1LxGZm+IuX1uYq2g0U+NtYx5e9MLn70amFx6B0zHb294SCRTtxx7LZ5R1TuD" +
       "ZHSUjMLX8gr040rt23K9YmqrVvb1inraw5hcxcgE9GoB9z9RZhih40tXcUXa" +
       "IPMqP+RR+fW/MbIyLGqrsHQsZrxjp0leVe13KbO47Eh2FpBp8LVkrEtV2RdM" +
       "6CCBdKgqNtxQHv+56f8BHQ5oN3JXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "FpsMW+pEF7p1sS6FyXJGu50mucTauVvr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Az3kYQVSaAAA");
}
