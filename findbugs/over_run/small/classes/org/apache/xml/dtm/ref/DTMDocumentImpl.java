package org.apache.xml.dtm.ref;
public class DTMDocumentImpl implements org.apache.xml.dtm.DTM, org.xml.sax.ContentHandler, org.xml.sax.ext.LexicalHandler {
    protected static final byte DOCHANDLE_SHIFT = 22;
    protected static final int NODEHANDLE_MASK = (1 << DOCHANDLE_SHIFT + 1) -
      1;
    protected static final int DOCHANDLE_MASK = -1 - NODEHANDLE_MASK;
    int m_docHandle = NULL;
    int m_docElement = NULL;
    int currentParent = 0;
    int previousSibling = 0;
    protected int m_currentNode = -1;
    private boolean previousSiblingWasParent = false;
    int[] gotslot = new int[4];
    private boolean done = false;
    boolean m_isError = false;
    private static final boolean DEBUG = false;
    protected java.lang.String m_documentBaseURI;
    private org.apache.xml.dtm.ref.IncrementalSAXSource m_incrSAXSource =
      null;
    org.apache.xml.dtm.ref.ChunkedIntArray nodes = new org.apache.xml.dtm.ref.ChunkedIntArray(
      4);
    private org.apache.xml.utils.FastStringBuffer m_char = new org.apache.xml.utils.FastStringBuffer(
      );
    private int m_char_current_start = 0;
    private org.apache.xml.dtm.ref.DTMStringPool m_localNames =
      new org.apache.xml.dtm.ref.DTMStringPool(
      );
    private org.apache.xml.dtm.ref.DTMStringPool m_nsNames =
      new org.apache.xml.dtm.ref.DTMStringPool(
      );
    private org.apache.xml.dtm.ref.DTMStringPool m_prefixNames =
      new org.apache.xml.dtm.ref.DTMStringPool(
      );
    private org.apache.xml.dtm.ref.ExpandedNameTable m_expandedNames =
      new org.apache.xml.dtm.ref.ExpandedNameTable(
      );
    private org.apache.xml.utils.XMLStringFactory m_xsf;
    public DTMDocumentImpl(org.apache.xml.dtm.DTMManager mgr,
                           int documentNumber,
                           org.apache.xml.dtm.DTMWSFilter whiteSpaceFilter,
                           org.apache.xml.utils.XMLStringFactory xstringfactory) {
        super(
          );
        initDocument(
          documentNumber);
        m_xsf =
          xstringfactory;
    }
    public void setIncrementalSAXSource(org.apache.xml.dtm.ref.IncrementalSAXSource source) {
        m_incrSAXSource =
          source;
        source.
          setContentHandler(
            this);
        source.
          setLexicalHandler(
            this);
    }
    private final int appendNode(int w0, int w1,
                                 int w2,
                                 int w3) {
        int slotnumber =
          nodes.
          appendSlot(
            w0,
            w1,
            w2,
            w3);
        if (DEBUG)
            java.lang.System.
              out.
              println(
                slotnumber +
                ": " +
                w0 +
                " " +
                w1 +
                " " +
                w2 +
                " " +
                w3);
        if (previousSiblingWasParent)
            nodes.
              writeEntry(
                previousSibling,
                2,
                slotnumber);
        previousSiblingWasParent =
          false;
        return slotnumber;
    }
    public void setFeature(java.lang.String featureId,
                           boolean state) {
        
    }
    public void setLocalNameTable(org.apache.xml.dtm.ref.DTMStringPool poolRef) {
        m_localNames =
          poolRef;
    }
    public org.apache.xml.dtm.ref.DTMStringPool getLocalNameTable() {
        return m_localNames;
    }
    public void setNsNameTable(org.apache.xml.dtm.ref.DTMStringPool poolRef) {
        m_nsNames =
          poolRef;
    }
    public org.apache.xml.dtm.ref.DTMStringPool getNsNameTable() {
        return m_nsNames;
    }
    public void setPrefixNameTable(org.apache.xml.dtm.ref.DTMStringPool poolRef) {
        m_prefixNames =
          poolRef;
    }
    public org.apache.xml.dtm.ref.DTMStringPool getPrefixNameTable() {
        return m_prefixNames;
    }
    void setContentBuffer(org.apache.xml.utils.FastStringBuffer buffer) {
        m_char =
          buffer;
    }
    org.apache.xml.utils.FastStringBuffer getContentBuffer() {
        return m_char;
    }
    public org.xml.sax.ContentHandler getContentHandler() {
        if (m_incrSAXSource instanceof org.apache.xml.dtm.ref.IncrementalSAXSource_Filter)
            return (org.xml.sax.ContentHandler)
                     m_incrSAXSource;
        else
            return this;
    }
    public org.xml.sax.ext.LexicalHandler getLexicalHandler() {
        if (m_incrSAXSource instanceof org.apache.xml.dtm.ref.IncrementalSAXSource_Filter)
            return (org.xml.sax.ext.LexicalHandler)
                     m_incrSAXSource;
        else
            return this;
    }
    public org.xml.sax.EntityResolver getEntityResolver() {
        return null;
    }
    public org.xml.sax.DTDHandler getDTDHandler() {
        return null;
    }
    public org.xml.sax.ErrorHandler getErrorHandler() {
        return null;
    }
    public org.xml.sax.ext.DeclHandler getDeclHandler() {
        return null;
    }
    public boolean needsTwoThreads() { return null !=
                                         m_incrSAXSource;
    }
    public void characters(char[] ch, int start,
                           int length) throws org.xml.sax.SAXException {
        m_char.
          append(
            ch,
            start,
            length);
    }
    private void processAccumulatedText() {
        int len =
          m_char.
          length(
            );
        if (len !=
              m_char_current_start) {
            appendTextChild(
              m_char_current_start,
              len -
                m_char_current_start);
            m_char_current_start =
              len;
        }
    }
    public void endDocument() throws org.xml.sax.SAXException {
        appendEndDocument(
          );
    }
    public void endElement(java.lang.String namespaceURI,
                           java.lang.String localName,
                           java.lang.String qName)
          throws org.xml.sax.SAXException {
        processAccumulatedText(
          );
        appendEndElement(
          );
    }
    public void endPrefixMapping(java.lang.String prefix)
          throws org.xml.sax.SAXException {
        
    }
    public void ignorableWhitespace(char[] ch,
                                    int start,
                                    int length)
          throws org.xml.sax.SAXException {
        
    }
    public void processingInstruction(java.lang.String target,
                                      java.lang.String data)
          throws org.xml.sax.SAXException {
        processAccumulatedText(
          );
    }
    public void setDocumentLocator(org.xml.sax.Locator locator) {
        
    }
    public void skippedEntity(java.lang.String name)
          throws org.xml.sax.SAXException {
        processAccumulatedText(
          );
    }
    public void startDocument() throws org.xml.sax.SAXException {
        appendStartDocument(
          );
    }
    public void startElement(java.lang.String namespaceURI,
                             java.lang.String localName,
                             java.lang.String qName,
                             org.xml.sax.Attributes atts)
          throws org.xml.sax.SAXException {
        processAccumulatedText(
          );
        java.lang.String prefix =
          null;
        int colon =
          qName.
          indexOf(
            ':');
        if (colon >
              0)
            prefix =
              qName.
                substring(
                  0,
                  colon);
        java.lang.System.
          out.
          println(
            "Prefix=" +
            prefix +
            " index=" +
            m_prefixNames.
              stringToIndex(
                prefix));
        appendStartElement(
          m_nsNames.
            stringToIndex(
              namespaceURI),
          m_localNames.
            stringToIndex(
              localName),
          m_prefixNames.
            stringToIndex(
              prefix));
        int nAtts =
          atts ==
          null
          ? 0
          : atts.
          getLength(
            );
        for (int i =
               nAtts -
               1;
             i >=
               0;
             --i) {
            qName =
              atts.
                getQName(
                  i);
            if (qName.
                  startsWith(
                    "xmlns:") ||
                  "xmlns".
                  equals(
                    qName)) {
                prefix =
                  null;
                colon =
                  qName.
                    indexOf(
                      ':');
                if (colon >
                      0) {
                    prefix =
                      qName.
                        substring(
                          0,
                          colon);
                }
                else {
                    prefix =
                      null;
                }
                appendNSDeclaration(
                  m_prefixNames.
                    stringToIndex(
                      prefix),
                  m_nsNames.
                    stringToIndex(
                      atts.
                        getValue(
                          i)),
                  atts.
                    getType(
                      i).
                    equalsIgnoreCase(
                      "ID"));
            }
        }
        for (int i =
               nAtts -
               1;
             i >=
               0;
             --i) {
            qName =
              atts.
                getQName(
                  i);
            if (!(qName.
                    startsWith(
                      "xmlns:") ||
                    "xmlns".
                    equals(
                      qName))) {
                prefix =
                  null;
                colon =
                  qName.
                    indexOf(
                      ':');
                if (colon >
                      0) {
                    prefix =
                      qName.
                        substring(
                          0,
                          colon);
                    localName =
                      qName.
                        substring(
                          colon +
                            1);
                }
                else {
                    prefix =
                      "";
                    localName =
                      qName;
                }
                m_char.
                  append(
                    atts.
                      getValue(
                        i));
                int contentEnd =
                  m_char.
                  length(
                    );
                if (!("xmlns".
                        equals(
                          prefix) ||
                        "xmlns".
                        equals(
                          qName)))
                    appendAttribute(
                      m_nsNames.
                        stringToIndex(
                          atts.
                            getURI(
                              i)),
                      m_localNames.
                        stringToIndex(
                          localName),
                      m_prefixNames.
                        stringToIndex(
                          prefix),
                      atts.
                        getType(
                          i).
                        equalsIgnoreCase(
                          "ID"),
                      m_char_current_start,
                      contentEnd -
                        m_char_current_start);
                m_char_current_start =
                  contentEnd;
            }
        }
    }
    public void startPrefixMapping(java.lang.String prefix,
                                   java.lang.String uri)
          throws org.xml.sax.SAXException {
        
    }
    public void comment(char[] ch, int start,
                        int length) throws org.xml.sax.SAXException {
        processAccumulatedText(
          );
        m_char.
          append(
            ch,
            start,
            length);
        appendComment(
          m_char_current_start,
          length);
        m_char_current_start +=
          length;
    }
    public void endCDATA() throws org.xml.sax.SAXException {
        
    }
    public void endDTD() throws org.xml.sax.SAXException {
        
    }
    public void endEntity(java.lang.String name)
          throws org.xml.sax.SAXException {
        
    }
    public void startCDATA() throws org.xml.sax.SAXException {
        
    }
    public void startDTD(java.lang.String name,
                         java.lang.String publicId,
                         java.lang.String systemId)
          throws org.xml.sax.SAXException {
        
    }
    public void startEntity(java.lang.String name)
          throws org.xml.sax.SAXException {
        
    }
    final void initDocument(int documentNumber) {
        m_docHandle =
          documentNumber <<
            DOCHANDLE_SHIFT;
        nodes.
          writeSlot(
            0,
            DOCUMENT_NODE,
            -1,
            -1,
            0);
        done =
          false;
    }
    public boolean hasChildNodes(int nodeHandle) {
        return getFirstChild(
                 nodeHandle) !=
          NULL;
    }
    public int getFirstChild(int nodeHandle) {
        nodeHandle &=
          NODEHANDLE_MASK;
        nodes.
          readSlot(
            nodeHandle,
            gotslot);
        short type =
          (short)
            (gotslot[0] &
               65535);
        if (type ==
              ELEMENT_NODE ||
              type ==
              DOCUMENT_NODE ||
              type ==
              ENTITY_REFERENCE_NODE) {
            int kid =
              nodeHandle +
              1;
            nodes.
              readSlot(
                kid,
                gotslot);
            while (ATTRIBUTE_NODE ==
                     (gotslot[0] &
                        65535)) {
                kid =
                  gotslot[2];
                if (kid ==
                      NULL)
                    return NULL;
                nodes.
                  readSlot(
                    kid,
                    gotslot);
            }
            if (gotslot[1] ==
                  nodeHandle) {
                int firstChild =
                  kid |
                  m_docHandle;
                return firstChild;
            }
        }
        return NULL;
    }
    public int getLastChild(int nodeHandle) {
        nodeHandle &=
          NODEHANDLE_MASK;
        int lastChild =
          NULL;
        for (int nextkid =
               getFirstChild(
                 nodeHandle);
             nextkid !=
               NULL;
             nextkid =
               getNextSibling(
                 nextkid)) {
            lastChild =
              nextkid;
        }
        return lastChild |
          m_docHandle;
    }
    public int getAttributeNode(int nodeHandle,
                                java.lang.String namespaceURI,
                                java.lang.String name) {
        int nsIndex =
          m_nsNames.
          stringToIndex(
            namespaceURI);
        int nameIndex =
          m_localNames.
          stringToIndex(
            name);
        nodeHandle &=
          NODEHANDLE_MASK;
        nodes.
          readSlot(
            nodeHandle,
            gotslot);
        short type =
          (short)
            (gotslot[0] &
               65535);
        if (type ==
              ELEMENT_NODE)
            nodeHandle++;
        while (type ==
                 ATTRIBUTE_NODE) {
            if (nsIndex ==
                  gotslot[0] <<
                  16 &&
                  gotslot[3] ==
                  nameIndex)
                return nodeHandle |
                  m_docHandle;
            nodeHandle =
              gotslot[2];
            nodes.
              readSlot(
                nodeHandle,
                gotslot);
        }
        return NULL;
    }
    public int getFirstAttribute(int nodeHandle) {
        nodeHandle &=
          NODEHANDLE_MASK;
        if (ELEMENT_NODE !=
              (nodes.
                 readEntry(
                   nodeHandle,
                   0) &
                 65535))
            return NULL;
        nodeHandle++;
        return ATTRIBUTE_NODE ==
          (nodes.
             readEntry(
               nodeHandle,
               0) &
             65535)
          ? nodeHandle |
          m_docHandle
          : NULL;
    }
    public int getFirstNamespaceNode(int nodeHandle,
                                     boolean inScope) {
        return NULL;
    }
    public int getNextSibling(int nodeHandle) {
        nodeHandle &=
          NODEHANDLE_MASK;
        if (nodeHandle ==
              0)
            return NULL;
        short type =
          (short)
            (nodes.
               readEntry(
                 nodeHandle,
                 0) &
               65535);
        if (type ==
              ELEMENT_NODE ||
              type ==
              ATTRIBUTE_NODE ||
              type ==
              ENTITY_REFERENCE_NODE) {
            int nextSib =
              nodes.
              readEntry(
                nodeHandle,
                2);
            if (nextSib ==
                  NULL)
                return NULL;
            if (nextSib !=
                  0)
                return m_docHandle |
                  nextSib;
        }
        int thisParent =
          nodes.
          readEntry(
            nodeHandle,
            1);
        if (nodes.
              readEntry(
                ++nodeHandle,
                1) ==
              thisParent)
            return m_docHandle |
              nodeHandle;
        return NULL;
    }
    public int getPreviousSibling(int nodeHandle) {
        nodeHandle &=
          NODEHANDLE_MASK;
        if (nodeHandle ==
              0)
            return NULL;
        int parent =
          nodes.
          readEntry(
            nodeHandle,
            1);
        int kid =
          NULL;
        for (int nextkid =
               getFirstChild(
                 parent);
             nextkid !=
               nodeHandle;
             nextkid =
               getNextSibling(
                 nextkid)) {
            kid =
              nextkid;
        }
        return kid |
          m_docHandle;
    }
    public int getNextAttribute(int nodeHandle) {
        nodeHandle &=
          NODEHANDLE_MASK;
        nodes.
          readSlot(
            nodeHandle,
            gotslot);
        short type =
          (short)
            (gotslot[0] &
               65535);
        if (type ==
              ELEMENT_NODE) {
            return getFirstAttribute(
                     nodeHandle);
        }
        else
            if (type ==
                  ATTRIBUTE_NODE) {
                if (gotslot[2] !=
                      NULL)
                    return m_docHandle |
                      gotslot[2];
            }
        return NULL;
    }
    public int getNextNamespaceNode(int baseHandle,
                                    int namespaceHandle,
                                    boolean inScope) {
        return NULL;
    }
    public int getNextDescendant(int subtreeRootHandle,
                                 int nodeHandle) {
        subtreeRootHandle &=
          NODEHANDLE_MASK;
        nodeHandle &=
          NODEHANDLE_MASK;
        if (nodeHandle ==
              0)
            return NULL;
        while (!m_isError) {
            if (done &&
                  nodeHandle >
                  nodes.
                  slotsUsed(
                    ))
                break;
            if (nodeHandle >
                  subtreeRootHandle) {
                nodes.
                  readSlot(
                    nodeHandle +
                      1,
                    gotslot);
                if (gotslot[2] !=
                      0) {
                    short type =
                      (short)
                        (gotslot[0] &
                           65535);
                    if (type ==
                          ATTRIBUTE_NODE) {
                        nodeHandle +=
                          2;
                    }
                    else {
                        int nextParentPos =
                          gotslot[1];
                        if (nextParentPos >=
                              subtreeRootHandle)
                            return m_docHandle |
                              nodeHandle +
                              1;
                        else
                            break;
                    }
                }
                else
                    if (!done) {
                        
                    }
                    else
                        break;
            }
            else {
                nodeHandle++;
            }
        }
        return NULL;
    }
    public int getNextFollowing(int axisContextHandle,
                                int nodeHandle) {
        return NULL;
    }
    public int getNextPreceding(int axisContextHandle,
                                int nodeHandle) {
        nodeHandle &=
          NODEHANDLE_MASK;
        while (nodeHandle >
                 1) {
            nodeHandle--;
            if (ATTRIBUTE_NODE ==
                  (nodes.
                     readEntry(
                       nodeHandle,
                       0) &
                     65535))
                continue;
            return m_docHandle |
              nodes.
              specialFind(
                axisContextHandle,
                nodeHandle);
        }
        return NULL;
    }
    public int getParent(int nodeHandle) {
        return m_docHandle |
          nodes.
          readEntry(
            nodeHandle,
            1);
    }
    public int getDocumentRoot() { return m_docHandle |
                                     m_docElement;
    }
    public int getDocument() { return m_docHandle;
    }
    public int getOwnerDocument(int nodeHandle) {
        if ((nodeHandle &
               NODEHANDLE_MASK) ==
              0)
            return NULL;
        return nodeHandle &
          DOCHANDLE_MASK;
    }
    public int getDocumentRoot(int nodeHandle) {
        if ((nodeHandle &
               NODEHANDLE_MASK) ==
              0)
            return NULL;
        return nodeHandle &
          DOCHANDLE_MASK;
    }
    public org.apache.xml.utils.XMLString getStringValue(int nodeHandle) {
        nodes.
          readSlot(
            nodeHandle,
            gotslot);
        int nodetype =
          gotslot[0] &
          255;
        java.lang.String value =
          null;
        switch (nodetype) {
            case TEXT_NODE:
            case COMMENT_NODE:
            case CDATA_SECTION_NODE:
                value =
                  m_char.
                    getString(
                      gotslot[2],
                      gotslot[3]);
                break;
            case PROCESSING_INSTRUCTION_NODE:
            case ATTRIBUTE_NODE:
            case ELEMENT_NODE:
            case ENTITY_REFERENCE_NODE:
            default:
                break;
        }
        return m_xsf.
          newstr(
            value);
    }
    public int getStringValueChunkCount(int nodeHandle) {
        return 0;
    }
    public char[] getStringValueChunk(int nodeHandle,
                                      int chunkIndex,
                                      int[] startAndLen) {
        return new char[0];
    }
    public int getExpandedTypeID(int nodeHandle) {
        nodes.
          readSlot(
            nodeHandle,
            gotslot);
        java.lang.String qName =
          m_localNames.
          indexToString(
            gotslot[3]);
        int colonpos =
          qName.
          indexOf(
            ":");
        java.lang.String localName =
          qName.
          substring(
            colonpos +
              1);
        java.lang.String namespace =
          m_nsNames.
          indexToString(
            gotslot[0] <<
              16);
        java.lang.String expandedName =
          namespace +
        ":" +
        localName;
        int expandedNameID =
          m_nsNames.
          stringToIndex(
            expandedName);
        return expandedNameID;
    }
    public int getExpandedTypeID(java.lang.String namespace,
                                 java.lang.String localName,
                                 int type) {
        java.lang.String expandedName =
          namespace +
        ":" +
        localName;
        int expandedNameID =
          m_nsNames.
          stringToIndex(
            expandedName);
        return expandedNameID;
    }
    public java.lang.String getLocalNameFromExpandedNameID(int ExpandedNameID) {
        java.lang.String expandedName =
          m_localNames.
          indexToString(
            ExpandedNameID);
        int colonpos =
          expandedName.
          indexOf(
            ":");
        java.lang.String localName =
          expandedName.
          substring(
            colonpos +
              1);
        return localName;
    }
    public java.lang.String getNamespaceFromExpandedNameID(int ExpandedNameID) {
        java.lang.String expandedName =
          m_localNames.
          indexToString(
            ExpandedNameID);
        int colonpos =
          expandedName.
          indexOf(
            ":");
        java.lang.String nsName =
          expandedName.
          substring(
            0,
            colonpos);
        return nsName;
    }
    private static final java.lang.String[]
      fixednames =
      { null,
    null,
    null,
    "#text",
    "#cdata_section",
    null,
    null,
    null,
    "#comment",
    "#document",
    null,
    "#document-fragment",
    null };
    public java.lang.String getNodeName(int nodeHandle) {
        nodes.
          readSlot(
            nodeHandle,
            gotslot);
        short type =
          (short)
            (gotslot[0] &
               65535);
        java.lang.String name =
          fixednames[type];
        if (null ==
              name) {
            int i =
              gotslot[3];
            java.lang.System.
              out.
              println(
                "got i=" +
                i +
                " " +
                (i >>
                   16) +
                "/" +
                (i &
                   65535));
            name =
              m_localNames.
                indexToString(
                  i &
                    65535);
            java.lang.String prefix =
              m_prefixNames.
              indexToString(
                i >>
                  16);
            if (prefix !=
                  null &&
                  prefix.
                  length(
                    ) >
                  0)
                name =
                  prefix +
                  ":" +
                  name;
        }
        return name;
    }
    public java.lang.String getNodeNameX(int nodeHandle) {
        return null;
    }
    public java.lang.String getLocalName(int nodeHandle) {
        nodes.
          readSlot(
            nodeHandle,
            gotslot);
        short type =
          (short)
            (gotslot[0] &
               65535);
        java.lang.String name =
          "";
        if (type ==
              ELEMENT_NODE ||
              type ==
              ATTRIBUTE_NODE) {
            int i =
              gotslot[3];
            name =
              m_localNames.
                indexToString(
                  i &
                    65535);
            if (name ==
                  null)
                name =
                  "";
        }
        return name;
    }
    public java.lang.String getPrefix(int nodeHandle) {
        nodes.
          readSlot(
            nodeHandle,
            gotslot);
        short type =
          (short)
            (gotslot[0] &
               65535);
        java.lang.String name =
          "";
        if (type ==
              ELEMENT_NODE ||
              type ==
              ATTRIBUTE_NODE) {
            int i =
              gotslot[3];
            name =
              m_prefixNames.
                indexToString(
                  i >>
                    16);
            if (name ==
                  null)
                name =
                  "";
        }
        return name;
    }
    public java.lang.String getNamespaceURI(int nodeHandle) {
        return null;
    }
    public java.lang.String getNodeValue(int nodeHandle) {
        nodes.
          readSlot(
            nodeHandle,
            gotslot);
        int nodetype =
          gotslot[0] &
          255;
        java.lang.String value =
          null;
        switch (nodetype) {
            case ATTRIBUTE_NODE:
                nodes.
                  readSlot(
                    nodeHandle +
                      1,
                    gotslot);
            case TEXT_NODE:
            case COMMENT_NODE:
            case CDATA_SECTION_NODE:
                value =
                  m_char.
                    getString(
                      gotslot[2],
                      gotslot[3]);
                break;
            case PROCESSING_INSTRUCTION_NODE:
            case ELEMENT_NODE:
            case ENTITY_REFERENCE_NODE:
            default:
                break;
        }
        return value;
    }
    public short getNodeType(int nodeHandle) {
        return (short)
                 (nodes.
                    readEntry(
                      nodeHandle,
                      0) &
                    65535);
    }
    public short getLevel(int nodeHandle) {
        short count =
          0;
        while (nodeHandle !=
                 0) {
            count++;
            nodeHandle =
              nodes.
                readEntry(
                  nodeHandle,
                  1);
        }
        return count;
    }
    public boolean isSupported(java.lang.String feature,
                               java.lang.String version) {
        return false;
    }
    public java.lang.String getDocumentBaseURI() {
        return m_documentBaseURI;
    }
    public void setDocumentBaseURI(java.lang.String baseURI) {
        m_documentBaseURI =
          baseURI;
    }
    public java.lang.String getDocumentSystemIdentifier(int nodeHandle) {
        return null;
    }
    public java.lang.String getDocumentEncoding(int nodeHandle) {
        return null;
    }
    public java.lang.String getDocumentStandalone(int nodeHandle) {
        return null;
    }
    public java.lang.String getDocumentVersion(int documentHandle) {
        return null;
    }
    public boolean getDocumentAllDeclarationsProcessed() {
        return false;
    }
    public java.lang.String getDocumentTypeDeclarationSystemIdentifier() {
        return null;
    }
    public java.lang.String getDocumentTypeDeclarationPublicIdentifier() {
        return null;
    }
    public int getElementById(java.lang.String elementId) {
        return 0;
    }
    public java.lang.String getUnparsedEntityURI(java.lang.String name) {
        return null;
    }
    public boolean supportsPreStripping() {
        return false;
    }
    public boolean isNodeAfter(int nodeHandle1,
                               int nodeHandle2) {
        return false;
    }
    public boolean isCharacterElementContentWhitespace(int nodeHandle) {
        return false;
    }
    public boolean isDocumentAllDeclarationsProcessed(int documentHandle) {
        return false;
    }
    public boolean isAttributeSpecified(int attributeHandle) {
        return false;
    }
    public void dispatchCharactersEvents(int nodeHandle,
                                         org.xml.sax.ContentHandler ch,
                                         boolean normalize)
          throws org.xml.sax.SAXException {
        
    }
    public void dispatchToEvents(int nodeHandle,
                                 org.xml.sax.ContentHandler ch)
          throws org.xml.sax.SAXException {
        
    }
    public org.w3c.dom.Node getNode(int nodeHandle) {
        return null;
    }
    public void appendChild(int newChild,
                            boolean clone,
                            boolean cloneDepth) {
        boolean sameDoc =
          (newChild &
             DOCHANDLE_MASK) ==
          m_docHandle;
        if (clone ||
              !sameDoc) {
            
        }
        else {
            
        }
    }
    public void appendTextChild(java.lang.String str) {
        
    }
    void appendTextChild(int m_char_current_start,
                         int contentLength) {
        int w0 =
          TEXT_NODE;
        int w1 =
          currentParent;
        int w2 =
          m_char_current_start;
        int w3 =
          contentLength;
        int ourslot =
          appendNode(
            w0,
            w1,
            w2,
            w3);
        previousSibling =
          ourslot;
    }
    void appendComment(int m_char_current_start,
                       int contentLength) {
        int w0 =
          COMMENT_NODE;
        int w1 =
          currentParent;
        int w2 =
          m_char_current_start;
        int w3 =
          contentLength;
        int ourslot =
          appendNode(
            w0,
            w1,
            w2,
            w3);
        previousSibling =
          ourslot;
    }
    void appendStartElement(int namespaceIndex,
                            int localNameIndex,
                            int prefixIndex) {
        int w0 =
          namespaceIndex <<
          16 |
          ELEMENT_NODE;
        int w1 =
          currentParent;
        int w2 =
          0;
        int w3 =
          localNameIndex |
          prefixIndex <<
          16;
        java.lang.System.
          out.
          println(
            "set w3=" +
            w3 +
            " " +
            (w3 >>
               16) +
            "/" +
            (w3 &
               65535));
        int ourslot =
          appendNode(
            w0,
            w1,
            w2,
            w3);
        currentParent =
          ourslot;
        previousSibling =
          0;
        if (m_docElement ==
              NULL)
            m_docElement =
              ourslot;
    }
    void appendNSDeclaration(int prefixIndex,
                             int namespaceIndex,
                             boolean isID) {
        final int namespaceForNamespaces =
          m_nsNames.
          stringToIndex(
            "http://www.w3.org/2000/xmlns/");
        int w0 =
          NAMESPACE_NODE |
          m_nsNames.
          stringToIndex(
            "http://www.w3.org/2000/xmlns/") <<
          16;
        int w1 =
          currentParent;
        int w2 =
          0;
        int w3 =
          namespaceIndex;
        int ourslot =
          appendNode(
            w0,
            w1,
            w2,
            w3);
        previousSibling =
          ourslot;
        previousSiblingWasParent =
          false;
        return;
    }
    void appendAttribute(int namespaceIndex,
                         int localNameIndex,
                         int prefixIndex,
                         boolean isID,
                         int m_char_current_start,
                         int contentLength) {
        int w0 =
          ATTRIBUTE_NODE |
          namespaceIndex <<
          16;
        int w1 =
          currentParent;
        int w2 =
          0;
        int w3 =
          localNameIndex |
          prefixIndex <<
          16;
        java.lang.System.
          out.
          println(
            "set w3=" +
            w3 +
            " " +
            (w3 >>
               16) +
            "/" +
            (w3 &
               65535));
        int ourslot =
          appendNode(
            w0,
            w1,
            w2,
            w3);
        previousSibling =
          ourslot;
        w0 =
          TEXT_NODE;
        w1 =
          ourslot;
        w2 =
          m_char_current_start;
        w3 =
          contentLength;
        appendNode(
          w0,
          w1,
          w2,
          w3);
        previousSiblingWasParent =
          true;
        return;
    }
    public org.apache.xml.dtm.DTMAxisTraverser getAxisTraverser(final int axis) {
        return null;
    }
    public org.apache.xml.dtm.DTMAxisIterator getAxisIterator(final int axis) {
        return null;
    }
    public org.apache.xml.dtm.DTMAxisIterator getTypedAxisIterator(final int axis,
                                                                   final int type) {
        return null;
    }
    void appendEndElement() { if (previousSiblingWasParent)
                                  nodes.
                                    writeEntry(
                                      previousSibling,
                                      2,
                                      NULL);
                              previousSibling =
                                currentParent;
                              nodes.readSlot(
                                      currentParent,
                                      gotslot);
                              currentParent =
                                gotslot[1] &
                                  65535;
                              previousSiblingWasParent =
                                true; }
    void appendStartDocument() { m_docElement =
                                   NULL;
                                 initDocument(
                                   0); }
    void appendEndDocument() { done = true;
    }
    public void setProperty(java.lang.String property,
                            java.lang.Object value) {
        
    }
    public javax.xml.transform.SourceLocator getSourceLocatorFor(int node) {
        return null;
    }
    public void documentRegistration() { 
    }
    public void documentRelease() {  }
    public void migrateTo(org.apache.xml.dtm.DTMManager manager) {
        
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "om7gJdO1YZyuDV/HFjBy4Fc40Fc+S5tH");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("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" +
       "/xLKfCaDVTT6Ev7T9n83LsyeN58AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VKnxWckuWdgihEyRmZRRLbtkZZUawJqA");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "CXGd5Yo4k0NycaOu4zIhdTooOS91Km4Z");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "WrkP77kV371pcCXK3JW+1Yyodqo3Ah5e3Rfw+QCM3ACSFw/4/FsBPpIGz4ky" +
       "V1MPu0Ns4T10AWbrYPMKjIObXoHxL8PbbocOX3krxvS6hy+NVi+hO6sNOnzZ" +
       "vpgvAnjCBlO4+FLcHkq7iTAdTzt8In1CnhqgsxR1n+GyFeKjAK27QexcDOL5" +
       "3aTD7c0jbyJOd5A8LIKKuW51b9LcW64cuBUvBDg3b1Y4uOnNChekudStKNOV" +
       "FYdV0P9dt6Nn6S62B+j96UEYALobUPd2Qc+e1HIKdNWOHLZ3KHcnDTjgK1iu" +
       "dY77dMjvAfmC9ODjQM/+5/rc9feFluYa8s07IN+SBgPgJJpyiJuWvZqss0p5" +
       "Mtx5ONyD8uFNHT38yw3lX94hyvEOynSX6UNt/USDsoIwWqGuzj2h1PelfDlw" +
       "Wl+9Pnf9fQcod4zBHa6CKVDY9PmcfDbkPiNvK8jHANwbN5BvvBjIU+Z25eKd" +
       "Mrc7ZpkdpmNwh0+vnysf9wNunmt2uM9A3MObOnp58zaeyze9jeeCynXHNLPD" +
       "dOTt8CvWjyRX2ntMu0W6zwDcivS1gHC+IZ1fDOmpnsuqcFez6g53TDk7TAfg" +
       "Dt8dZZ53hLvaXTwdhjqjcPcZhVshvwKgfvUG+avvUOHumHt2mA67HX7rZr6S" +
       "FkenX3B1grnPiNsK81UA7wMbzA/cIcwdE88O03G2w+89nslz07u8TlD3GWQ7" +
       "tlA/s0H9mTuEumM07TCdgXb4o2u7lJboebV1n7G0FehrAODvb0B//2JAt03x" +
       "qSq7YzbaYTob7fCno8xzN8i7auw+89GOzfHGmbh8Qc7EtpFaF/KOmWmHH0+D" +
       "X17b5JSY0EIF9OLkzSvzTnD3mZh2pM5XXro+d/19p3B3TFE7TKeoHX7iRKcp" +
       "z7a9xc2Vd58pase0T25on7yTtDtmrB2mM9YO/+SEFhgsRVNvpt1nxtqK9iWA" +
       "ktrQUhdDe5Op2jFt7TCdtnb411Hm7tQqn7zw8YRwn+lqK8JXArLNyx+v3PTy" +
       "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" +
       "Xsv//wDG762qpboAAA==");
}
