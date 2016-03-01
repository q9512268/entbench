package org.apache.xml.dtm.ref;
public abstract class DTMDefaultBase implements org.apache.xml.dtm.DTM {
    static final boolean JJK_DEBUG = false;
    public static final int ROOTNODE = 0;
    protected int m_size = 0;
    protected org.apache.xml.utils.SuballocatedIntVector m_exptype;
    protected org.apache.xml.utils.SuballocatedIntVector m_firstch;
    protected org.apache.xml.utils.SuballocatedIntVector m_nextsib;
    protected org.apache.xml.utils.SuballocatedIntVector m_prevsib;
    protected org.apache.xml.utils.SuballocatedIntVector m_parent;
    protected java.util.Vector m_namespaceDeclSets = null;
    protected org.apache.xml.utils.SuballocatedIntVector m_namespaceDeclSetElements =
      null;
    protected int[][][] m_elemIndexes;
    public static final int DEFAULT_BLOCKSIZE = 512;
    public static final int DEFAULT_NUMBLOCKS = 32;
    public static final int DEFAULT_NUMBLOCKS_SMALL = 4;
    protected static final int NOTPROCESSED = org.apache.xml.dtm.DTM.
                                                NULL - 1;
    public org.apache.xml.dtm.DTMManager m_mgr;
    protected org.apache.xml.dtm.ref.DTMManagerDefault m_mgrDefault =
      null;
    protected org.apache.xml.utils.SuballocatedIntVector m_dtmIdent;
    protected java.lang.String m_documentBaseURI;
    protected org.apache.xml.dtm.DTMWSFilter m_wsfilter;
    protected boolean m_shouldStripWS = false;
    protected org.apache.xml.utils.BoolStack m_shouldStripWhitespaceStack;
    protected org.apache.xml.utils.XMLStringFactory m_xstrf;
    protected org.apache.xml.dtm.ref.ExpandedNameTable m_expandedNameTable;
    protected boolean m_indexing;
    public DTMDefaultBase(org.apache.xml.dtm.DTMManager mgr, javax.xml.transform.Source source,
                          int dtmIdentity,
                          org.apache.xml.dtm.DTMWSFilter whiteSpaceFilter,
                          org.apache.xml.utils.XMLStringFactory xstringfactory,
                          boolean doIndexing) { this(mgr,
                                                     source,
                                                     dtmIdentity,
                                                     whiteSpaceFilter,
                                                     xstringfactory,
                                                     doIndexing,
                                                     DEFAULT_BLOCKSIZE,
                                                     true,
                                                     false);
    }
    public DTMDefaultBase(org.apache.xml.dtm.DTMManager mgr,
                          javax.xml.transform.Source source,
                          int dtmIdentity,
                          org.apache.xml.dtm.DTMWSFilter whiteSpaceFilter,
                          org.apache.xml.utils.XMLStringFactory xstringfactory,
                          boolean doIndexing,
                          int blocksize,
                          boolean usePrevsib,
                          boolean newNameTable) { super();
                                                  int numblocks;
                                                  if (blocksize <=
                                                        64) {
                                                      numblocks =
                                                        DEFAULT_NUMBLOCKS_SMALL;
                                                      m_dtmIdent =
                                                        new org.apache.xml.utils.SuballocatedIntVector(
                                                          4,
                                                          1);
                                                  }
                                                  else {
                                                      numblocks =
                                                        DEFAULT_NUMBLOCKS;
                                                      m_dtmIdent =
                                                        new org.apache.xml.utils.SuballocatedIntVector(
                                                          32);
                                                  }
                                                  m_exptype =
                                                    new org.apache.xml.utils.SuballocatedIntVector(
                                                      blocksize,
                                                      numblocks);
                                                  m_firstch =
                                                    new org.apache.xml.utils.SuballocatedIntVector(
                                                      blocksize,
                                                      numblocks);
                                                  m_nextsib =
                                                    new org.apache.xml.utils.SuballocatedIntVector(
                                                      blocksize,
                                                      numblocks);
                                                  m_parent =
                                                    new org.apache.xml.utils.SuballocatedIntVector(
                                                      blocksize,
                                                      numblocks);
                                                  if (usePrevsib)
                                                      m_prevsib =
                                                        new org.apache.xml.utils.SuballocatedIntVector(
                                                          blocksize,
                                                          numblocks);
                                                  m_mgr =
                                                    mgr;
                                                  if (mgr instanceof org.apache.xml.dtm.ref.DTMManagerDefault)
                                                      m_mgrDefault =
                                                        (org.apache.xml.dtm.ref.DTMManagerDefault)
                                                          mgr;
                                                  m_documentBaseURI =
                                                    null !=
                                                      source
                                                      ? source.
                                                      getSystemId(
                                                        )
                                                      : null;
                                                  m_dtmIdent.
                                                    setElementAt(
                                                      dtmIdentity,
                                                      0);
                                                  m_wsfilter =
                                                    whiteSpaceFilter;
                                                  m_xstrf =
                                                    xstringfactory;
                                                  m_indexing =
                                                    doIndexing;
                                                  if (doIndexing) {
                                                      m_expandedNameTable =
                                                        new org.apache.xml.dtm.ref.ExpandedNameTable(
                                                          );
                                                  }
                                                  else {
                                                      m_expandedNameTable =
                                                        m_mgrDefault.
                                                          getExpandedNameTable(
                                                            this);
                                                  }
                                                  if (null !=
                                                        whiteSpaceFilter) {
                                                      m_shouldStripWhitespaceStack =
                                                        new org.apache.xml.utils.BoolStack(
                                                          );
                                                      pushShouldStripWhitespace(
                                                        false);
                                                  }
    }
    protected void ensureSizeOfIndex(int namespaceID,
                                     int LocalNameID) {
        if (null ==
              m_elemIndexes) {
            m_elemIndexes =
              (new int[namespaceID +
                         20][][]);
        }
        else
            if (m_elemIndexes.
                  length <=
                  namespaceID) {
                int[][][] indexes =
                  m_elemIndexes;
                m_elemIndexes =
                  (new int[namespaceID +
                             20][][]);
                java.lang.System.
                  arraycopy(
                    indexes,
                    0,
                    m_elemIndexes,
                    0,
                    indexes.
                      length);
            }
        int[][] localNameIndex =
          m_elemIndexes[namespaceID];
        if (null ==
              localNameIndex) {
            localNameIndex =
              (new int[LocalNameID +
                         100][]);
            m_elemIndexes[namespaceID] =
              localNameIndex;
        }
        else
            if (localNameIndex.
                  length <=
                  LocalNameID) {
                int[][] indexes =
                  localNameIndex;
                localNameIndex =
                  (new int[LocalNameID +
                             100][]);
                java.lang.System.
                  arraycopy(
                    indexes,
                    0,
                    localNameIndex,
                    0,
                    indexes.
                      length);
                m_elemIndexes[namespaceID] =
                  localNameIndex;
            }
        int[] elemHandles =
          localNameIndex[LocalNameID];
        if (null ==
              elemHandles) {
            elemHandles =
              (new int[128]);
            localNameIndex[LocalNameID] =
              elemHandles;
            elemHandles[0] =
              1;
        }
        else
            if (elemHandles.
                  length <=
                  elemHandles[0] +
                  1) {
                int[] indexes =
                  elemHandles;
                elemHandles =
                  (new int[elemHandles[0] +
                             1024]);
                java.lang.System.
                  arraycopy(
                    indexes,
                    0,
                    elemHandles,
                    0,
                    indexes.
                      length);
                localNameIndex[LocalNameID] =
                  elemHandles;
            }
    }
    protected void indexNode(int expandedTypeID,
                             int identity) {
        org.apache.xml.dtm.ref.ExpandedNameTable ent =
          m_expandedNameTable;
        short type =
          ent.
          getType(
            expandedTypeID);
        if (org.apache.xml.dtm.DTM.
              ELEMENT_NODE ==
              type) {
            int namespaceID =
              ent.
              getNamespaceID(
                expandedTypeID);
            int localNameID =
              ent.
              getLocalNameID(
                expandedTypeID);
            ensureSizeOfIndex(
              namespaceID,
              localNameID);
            int[] index =
              m_elemIndexes[namespaceID][localNameID];
            index[index[0]] =
              identity;
            index[0]++;
        }
    }
    protected int findGTE(int[] list, int start,
                          int len,
                          int value) { int low =
                                         start;
                                       int high =
                                         start +
                                         (len -
                                            1);
                                       int end =
                                         high;
                                       while (low <=
                                                high) {
                                           int mid =
                                             low +
                                             high >>>
                                             1;
                                           int c =
                                             list[mid];
                                           if (c >
                                                 value)
                                               high =
                                                 mid -
                                                   1;
                                           else
                                               if (c <
                                                     value)
                                                   low =
                                                     mid +
                                                       1;
                                               else
                                                   return mid;
                                       }
                                       return low <=
                                         end &&
                                         list[low] >
                                         value
                                         ? low
                                         : -1;
    }
    int findElementFromIndex(int nsIndex,
                             int lnIndex,
                             int firstPotential) {
        int[][][] indexes =
          m_elemIndexes;
        if (null !=
              indexes &&
              nsIndex <
              indexes.
                length) {
            int[][] lnIndexs =
              indexes[nsIndex];
            if (null !=
                  lnIndexs &&
                  lnIndex <
                  lnIndexs.
                    length) {
                int[] elems =
                  lnIndexs[lnIndex];
                if (null !=
                      elems) {
                    int pos =
                      findGTE(
                        elems,
                        1,
                        elems[0],
                        firstPotential);
                    if (pos >
                          -1) {
                        return elems[pos];
                    }
                }
            }
        }
        return NOTPROCESSED;
    }
    protected abstract int getNextNodeIdentity(int identity);
    protected abstract boolean nextNode();
    protected abstract int getNumberOfNodes();
    protected org.apache.xml.dtm.DTMAxisTraverser[]
      m_traversers;
    protected short _type(int identity) {
        int info =
          _exptype(
            identity);
        if (NULL !=
              info)
            return m_expandedNameTable.
              getType(
                info);
        else
            return NULL;
    }
    protected int _exptype(int identity) {
        if (identity ==
              org.apache.xml.dtm.DTM.
                NULL)
            return NULL;
        while (identity >=
                 m_size) {
            if (!nextNode(
                   ) &&
                  identity >=
                  m_size)
                return NULL;
        }
        return m_exptype.
          elementAt(
            identity);
    }
    protected int _level(int identity) { while (identity >=
                                                  m_size) {
                                             boolean isMore =
                                               nextNode(
                                                 );
                                             if (!isMore &&
                                                   identity >=
                                                   m_size)
                                                 return NULL;
                                         }
                                         int i =
                                           0;
                                         while (NULL !=
                                                  (identity =
                                                     _parent(
                                                       identity)))
                                             ++i;
                                         return i;
    }
    protected int _firstch(int identity) {
        int info =
          identity >=
          m_size
          ? NOTPROCESSED
          : m_firstch.
          elementAt(
            identity);
        while (info ==
                 NOTPROCESSED) {
            boolean isMore =
              nextNode(
                );
            if (identity >=
                  m_size &&
                  !isMore)
                return NULL;
            else {
                info =
                  m_firstch.
                    elementAt(
                      identity);
                if (info ==
                      NOTPROCESSED &&
                      !isMore)
                    return NULL;
            }
        }
        return info;
    }
    protected int _nextsib(int identity) {
        int info =
          identity >=
          m_size
          ? NOTPROCESSED
          : m_nextsib.
          elementAt(
            identity);
        while (info ==
                 NOTPROCESSED) {
            boolean isMore =
              nextNode(
                );
            if (identity >=
                  m_size &&
                  !isMore)
                return NULL;
            else {
                info =
                  m_nextsib.
                    elementAt(
                      identity);
                if (info ==
                      NOTPROCESSED &&
                      !isMore)
                    return NULL;
            }
        }
        return info;
    }
    protected int _prevsib(int identity) {
        if (identity <
              m_size)
            return m_prevsib.
              elementAt(
                identity);
        while (true) {
            boolean isMore =
              nextNode(
                );
            if (identity >=
                  m_size &&
                  !isMore)
                return NULL;
            else
                if (identity <
                      m_size)
                    return m_prevsib.
                      elementAt(
                        identity);
        }
    }
    protected int _parent(int identity) {
        if (identity <
              m_size)
            return m_parent.
              elementAt(
                identity);
        while (true) {
            boolean isMore =
              nextNode(
                );
            if (identity >=
                  m_size &&
                  !isMore)
                return NULL;
            else
                if (identity <
                      m_size)
                    return m_parent.
                      elementAt(
                        identity);
        }
    }
    public void dumpDTM(java.io.OutputStream os) {
        try {
            if (os ==
                  null) {
                java.io.File f =
                  new java.io.File(
                  "DTMDump" +
                  ((java.lang.Object)
                     this).
                    hashCode(
                      ) +
                  ".txt");
                java.lang.System.
                  err.
                  println(
                    "Dumping... " +
                    f.
                      getAbsolutePath(
                        ));
                os =
                  new java.io.FileOutputStream(
                    f);
            }
            java.io.PrintStream ps =
              new java.io.PrintStream(
              os);
            while (nextNode(
                     )) {
                
            }
            int nRecords =
              m_size;
            ps.
              println(
                "Total nodes: " +
                nRecords);
            for (int index =
                   0;
                 index <
                   nRecords;
                 ++index) {
                int i =
                  makeNodeHandle(
                    index);
                ps.
                  println(
                    "=========== index=" +
                    index +
                    " handle=" +
                    i +
                    " ===========");
                ps.
                  println(
                    "NodeName: " +
                    getNodeName(
                      i));
                ps.
                  println(
                    "NodeNameX: " +
                    getNodeNameX(
                      i));
                ps.
                  println(
                    "LocalName: " +
                    getLocalName(
                      i));
                ps.
                  println(
                    "NamespaceURI: " +
                    getNamespaceURI(
                      i));
                ps.
                  println(
                    "Prefix: " +
                    getPrefix(
                      i));
                int exTypeID =
                  _exptype(
                    index);
                ps.
                  println(
                    "Expanded Type ID: " +
                    java.lang.Integer.
                      toHexString(
                        exTypeID));
                int type =
                  _type(
                    index);
                java.lang.String typestring;
                switch (type) {
                    case org.apache.xml.dtm.DTM.
                           ATTRIBUTE_NODE:
                        typestring =
                          "ATTRIBUTE_NODE";
                        break;
                    case org.apache.xml.dtm.DTM.
                           CDATA_SECTION_NODE:
                        typestring =
                          "CDATA_SECTION_NODE";
                        break;
                    case org.apache.xml.dtm.DTM.
                           COMMENT_NODE:
                        typestring =
                          "COMMENT_NODE";
                        break;
                    case org.apache.xml.dtm.DTM.
                           DOCUMENT_FRAGMENT_NODE:
                        typestring =
                          "DOCUMENT_FRAGMENT_NODE";
                        break;
                    case org.apache.xml.dtm.DTM.
                           DOCUMENT_NODE:
                        typestring =
                          "DOCUMENT_NODE";
                        break;
                    case org.apache.xml.dtm.DTM.
                           DOCUMENT_TYPE_NODE:
                        typestring =
                          "DOCUMENT_NODE";
                        break;
                    case org.apache.xml.dtm.DTM.
                           ELEMENT_NODE:
                        typestring =
                          "ELEMENT_NODE";
                        break;
                    case org.apache.xml.dtm.DTM.
                           ENTITY_NODE:
                        typestring =
                          "ENTITY_NODE";
                        break;
                    case org.apache.xml.dtm.DTM.
                           ENTITY_REFERENCE_NODE:
                        typestring =
                          "ENTITY_REFERENCE_NODE";
                        break;
                    case org.apache.xml.dtm.DTM.
                           NAMESPACE_NODE:
                        typestring =
                          "NAMESPACE_NODE";
                        break;
                    case org.apache.xml.dtm.DTM.
                           NOTATION_NODE:
                        typestring =
                          "NOTATION_NODE";
                        break;
                    case org.apache.xml.dtm.DTM.
                           NULL:
                        typestring =
                          "NULL";
                        break;
                    case org.apache.xml.dtm.DTM.
                           PROCESSING_INSTRUCTION_NODE:
                        typestring =
                          "PROCESSING_INSTRUCTION_NODE";
                        break;
                    case org.apache.xml.dtm.DTM.
                           TEXT_NODE:
                        typestring =
                          "TEXT_NODE";
                        break;
                    default:
                        typestring =
                          "Unknown!";
                        break;
                }
                ps.
                  println(
                    "Type: " +
                    typestring);
                int firstChild =
                  _firstch(
                    index);
                if (org.apache.xml.dtm.DTM.
                      NULL ==
                      firstChild)
                    ps.
                      println(
                        "First child: DTM.NULL");
                else
                    if (NOTPROCESSED ==
                          firstChild)
                        ps.
                          println(
                            "First child: NOTPROCESSED");
                    else
                        ps.
                          println(
                            "First child: " +
                            firstChild);
                if (m_prevsib !=
                      null) {
                    int prevSibling =
                      _prevsib(
                        index);
                    if (org.apache.xml.dtm.DTM.
                          NULL ==
                          prevSibling)
                        ps.
                          println(
                            "Prev sibling: DTM.NULL");
                    else
                        if (NOTPROCESSED ==
                              prevSibling)
                            ps.
                              println(
                                "Prev sibling: NOTPROCESSED");
                        else
                            ps.
                              println(
                                "Prev sibling: " +
                                prevSibling);
                }
                int nextSibling =
                  _nextsib(
                    index);
                if (org.apache.xml.dtm.DTM.
                      NULL ==
                      nextSibling)
                    ps.
                      println(
                        "Next sibling: DTM.NULL");
                else
                    if (NOTPROCESSED ==
                          nextSibling)
                        ps.
                          println(
                            "Next sibling: NOTPROCESSED");
                    else
                        ps.
                          println(
                            "Next sibling: " +
                            nextSibling);
                int parent =
                  _parent(
                    index);
                if (org.apache.xml.dtm.DTM.
                      NULL ==
                      parent)
                    ps.
                      println(
                        "Parent: DTM.NULL");
                else
                    if (NOTPROCESSED ==
                          parent)
                        ps.
                          println(
                            "Parent: NOTPROCESSED");
                    else
                        ps.
                          println(
                            "Parent: " +
                            parent);
                int level =
                  _level(
                    index);
                ps.
                  println(
                    "Level: " +
                    level);
                ps.
                  println(
                    "Node Value: " +
                    getNodeValue(
                      i));
                ps.
                  println(
                    "String Value: " +
                    getStringValue(
                      i));
            }
        }
        catch (java.io.IOException ioe) {
            ioe.
              printStackTrace(
                java.lang.System.
                  err);
            throw new java.lang.RuntimeException(
              ioe.
                getMessage(
                  ));
        }
    }
    public java.lang.String dumpNode(int nodeHandle) {
        if (nodeHandle ==
              org.apache.xml.dtm.DTM.
                NULL)
            return "[null]";
        java.lang.String typestring;
        switch (getNodeType(
                  nodeHandle)) {
            case org.apache.xml.dtm.DTM.
                   ATTRIBUTE_NODE:
                typestring =
                  "ATTR";
                break;
            case org.apache.xml.dtm.DTM.
                   CDATA_SECTION_NODE:
                typestring =
                  "CDATA";
                break;
            case org.apache.xml.dtm.DTM.
                   COMMENT_NODE:
                typestring =
                  "COMMENT";
                break;
            case org.apache.xml.dtm.DTM.
                   DOCUMENT_FRAGMENT_NODE:
                typestring =
                  "DOC_FRAG";
                break;
            case org.apache.xml.dtm.DTM.
                   DOCUMENT_NODE:
                typestring =
                  "DOC";
                break;
            case org.apache.xml.dtm.DTM.
                   DOCUMENT_TYPE_NODE:
                typestring =
                  "DOC_TYPE";
                break;
            case org.apache.xml.dtm.DTM.
                   ELEMENT_NODE:
                typestring =
                  "ELEMENT";
                break;
            case org.apache.xml.dtm.DTM.
                   ENTITY_NODE:
                typestring =
                  "ENTITY";
                break;
            case org.apache.xml.dtm.DTM.
                   ENTITY_REFERENCE_NODE:
                typestring =
                  "ENT_REF";
                break;
            case org.apache.xml.dtm.DTM.
                   NAMESPACE_NODE:
                typestring =
                  "NAMESPACE";
                break;
            case org.apache.xml.dtm.DTM.
                   NOTATION_NODE:
                typestring =
                  "NOTATION";
                break;
            case org.apache.xml.dtm.DTM.
                   NULL:
                typestring =
                  "null";
                break;
            case org.apache.xml.dtm.DTM.
                   PROCESSING_INSTRUCTION_NODE:
                typestring =
                  "PI";
                break;
            case org.apache.xml.dtm.DTM.
                   TEXT_NODE:
                typestring =
                  "TEXT";
                break;
            default:
                typestring =
                  "Unknown!";
                break;
        }
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            "[" +
            nodeHandle +
            ": " +
            typestring +
            "(0x" +
            java.lang.Integer.
              toHexString(
                getExpandedTypeID(
                  nodeHandle)) +
            ") " +
            getNodeNameX(
              nodeHandle) +
            " {" +
            getNamespaceURI(
              nodeHandle) +
            "}" +
            "=\"" +
            getNodeValue(
              nodeHandle) +
            "\"]");
        return sb.
          toString(
            );
    }
    public void setFeature(java.lang.String featureId,
                           boolean state) {
        
    }
    public boolean hasChildNodes(int nodeHandle) {
        int identity =
          makeNodeIdentity(
            nodeHandle);
        int firstChild =
          _firstch(
            identity);
        return firstChild !=
          org.apache.xml.dtm.DTM.
            NULL;
    }
    public final int makeNodeHandle(int nodeIdentity) {
        if (NULL ==
              nodeIdentity)
            return NULL;
        if (JJK_DEBUG &&
              nodeIdentity >
              org.apache.xml.dtm.DTMManager.
                IDENT_NODE_DEFAULT)
            java.lang.System.
              err.
              println(
                "GONK! (only useful in limited situations)");
        return m_dtmIdent.
          elementAt(
            nodeIdentity >>>
              org.apache.xml.dtm.DTMManager.
                IDENT_DTM_NODE_BITS) +
          (nodeIdentity &
             org.apache.xml.dtm.DTMManager.
               IDENT_NODE_DEFAULT);
    }
    public final int makeNodeIdentity(int nodeHandle) {
        if (NULL ==
              nodeHandle)
            return NULL;
        if (m_mgrDefault !=
              null) {
            int whichDTMindex =
              nodeHandle >>>
              org.apache.xml.dtm.DTMManager.
                IDENT_DTM_NODE_BITS;
            if (m_mgrDefault.
                  m_dtms[whichDTMindex] !=
                  this)
                return NULL;
            else
                return m_mgrDefault.
                         m_dtm_offsets[whichDTMindex] |
                  nodeHandle &
                  org.apache.xml.dtm.DTMManager.
                    IDENT_NODE_DEFAULT;
        }
        int whichDTMid =
          m_dtmIdent.
          indexOf(
            nodeHandle &
              org.apache.xml.dtm.DTMManager.
                IDENT_DTM_DEFAULT);
        return whichDTMid ==
          NULL
          ? NULL
          : (whichDTMid <<
               org.apache.xml.dtm.DTMManager.
                 IDENT_DTM_NODE_BITS) +
          (nodeHandle &
             org.apache.xml.dtm.DTMManager.
               IDENT_NODE_DEFAULT);
    }
    public int getFirstChild(int nodeHandle) {
        int identity =
          makeNodeIdentity(
            nodeHandle);
        int firstChild =
          _firstch(
            identity);
        return makeNodeHandle(
                 firstChild);
    }
    public int getTypedFirstChild(int nodeHandle,
                                  int nodeType) {
        int firstChild;
        int eType;
        if (nodeType <
              org.apache.xml.dtm.DTM.
                NTYPES) {
            for (firstChild =
                   _firstch(
                     makeNodeIdentity(
                       nodeHandle));
                 firstChild !=
                   org.apache.xml.dtm.DTM.
                     NULL;
                 firstChild =
                   _nextsib(
                     firstChild)) {
                eType =
                  _exptype(
                    firstChild);
                if (eType ==
                      nodeType ||
                      eType >=
                      org.apache.xml.dtm.DTM.
                        NTYPES &&
                      m_expandedNameTable.
                      getType(
                        eType) ==
                      nodeType) {
                    return makeNodeHandle(
                             firstChild);
                }
            }
        }
        else {
            for (firstChild =
                   _firstch(
                     makeNodeIdentity(
                       nodeHandle));
                 firstChild !=
                   org.apache.xml.dtm.DTM.
                     NULL;
                 firstChild =
                   _nextsib(
                     firstChild)) {
                if (_exptype(
                      firstChild) ==
                      nodeType) {
                    return makeNodeHandle(
                             firstChild);
                }
            }
        }
        return org.apache.xml.dtm.DTM.
                 NULL;
    }
    public int getLastChild(int nodeHandle) {
        int identity =
          makeNodeIdentity(
            nodeHandle);
        int child =
          _firstch(
            identity);
        int lastChild =
          org.apache.xml.dtm.DTM.
            NULL;
        while (child !=
                 org.apache.xml.dtm.DTM.
                   NULL) {
            lastChild =
              child;
            child =
              _nextsib(
                child);
        }
        return makeNodeHandle(
                 lastChild);
    }
    public abstract int getAttributeNode(int nodeHandle,
                                         java.lang.String namespaceURI,
                                         java.lang.String name);
    public int getFirstAttribute(int nodeHandle) {
        int nodeID =
          makeNodeIdentity(
            nodeHandle);
        return makeNodeHandle(
                 getFirstAttributeIdentity(
                   nodeID));
    }
    protected int getFirstAttributeIdentity(int identity) {
        int type =
          _type(
            identity);
        if (org.apache.xml.dtm.DTM.
              ELEMENT_NODE ==
              type) {
            while (org.apache.xml.dtm.DTM.
                     NULL !=
                     (identity =
                        getNextNodeIdentity(
                          identity))) {
                type =
                  _type(
                    identity);
                if (type ==
                      org.apache.xml.dtm.DTM.
                        ATTRIBUTE_NODE) {
                    return identity;
                }
                else
                    if (org.apache.xml.dtm.DTM.
                          NAMESPACE_NODE !=
                          type) {
                        break;
                    }
            }
        }
        return org.apache.xml.dtm.DTM.
                 NULL;
    }
    protected int getTypedAttribute(int nodeHandle,
                                    int attType) {
        int type =
          getNodeType(
            nodeHandle);
        if (org.apache.xml.dtm.DTM.
              ELEMENT_NODE ==
              type) {
            int identity =
              makeNodeIdentity(
                nodeHandle);
            while (org.apache.xml.dtm.DTM.
                     NULL !=
                     (identity =
                        getNextNodeIdentity(
                          identity))) {
                type =
                  _type(
                    identity);
                if (type ==
                      org.apache.xml.dtm.DTM.
                        ATTRIBUTE_NODE) {
                    if (_exptype(
                          identity) ==
                          attType)
                        return makeNodeHandle(
                                 identity);
                }
                else
                    if (org.apache.xml.dtm.DTM.
                          NAMESPACE_NODE !=
                          type) {
                        break;
                    }
            }
        }
        return org.apache.xml.dtm.DTM.
                 NULL;
    }
    public int getNextSibling(int nodeHandle) {
        if (nodeHandle ==
              org.apache.xml.dtm.DTM.
                NULL)
            return org.apache.xml.dtm.DTM.
                     NULL;
        return makeNodeHandle(
                 _nextsib(
                   makeNodeIdentity(
                     nodeHandle)));
    }
    public int getTypedNextSibling(int nodeHandle,
                                   int nodeType) {
        if (nodeHandle ==
              org.apache.xml.dtm.DTM.
                NULL)
            return org.apache.xml.dtm.DTM.
                     NULL;
        int node =
          makeNodeIdentity(
            nodeHandle);
        int eType;
        while ((node =
                  _nextsib(
                    node)) !=
                 org.apache.xml.dtm.DTM.
                   NULL &&
                 ((eType =
                     _exptype(
                       node)) !=
                    nodeType &&
                    m_expandedNameTable.
                    getType(
                      eType) !=
                    nodeType))
            ;
        return node ==
          org.apache.xml.dtm.DTM.
            NULL
          ? org.apache.xml.dtm.DTM.
              NULL
          : makeNodeHandle(
              node);
    }
    public int getPreviousSibling(int nodeHandle) {
        if (nodeHandle ==
              org.apache.xml.dtm.DTM.
                NULL)
            return org.apache.xml.dtm.DTM.
                     NULL;
        if (m_prevsib !=
              null)
            return makeNodeHandle(
                     _prevsib(
                       makeNodeIdentity(
                         nodeHandle)));
        else {
            int nodeID =
              makeNodeIdentity(
                nodeHandle);
            int parent =
              _parent(
                nodeID);
            int node =
              _firstch(
                parent);
            int result =
              org.apache.xml.dtm.DTM.
                NULL;
            while (node !=
                     nodeID) {
                result =
                  node;
                node =
                  _nextsib(
                    node);
            }
            return makeNodeHandle(
                     result);
        }
    }
    public int getNextAttribute(int nodeHandle) {
        int nodeID =
          makeNodeIdentity(
            nodeHandle);
        if (_type(
              nodeID) ==
              org.apache.xml.dtm.DTM.
                ATTRIBUTE_NODE) {
            return makeNodeHandle(
                     getNextAttributeIdentity(
                       nodeID));
        }
        return org.apache.xml.dtm.DTM.
                 NULL;
    }
    protected int getNextAttributeIdentity(int identity) {
        while (org.apache.xml.dtm.DTM.
                 NULL !=
                 (identity =
                    getNextNodeIdentity(
                      identity))) {
            int type =
              _type(
                identity);
            if (type ==
                  org.apache.xml.dtm.DTM.
                    ATTRIBUTE_NODE) {
                return identity;
            }
            else
                if (type !=
                      org.apache.xml.dtm.DTM.
                        NAMESPACE_NODE) {
                    break;
                }
        }
        return org.apache.xml.dtm.DTM.
                 NULL;
    }
    private java.util.Vector m_namespaceLists =
      null;
    protected void declareNamespaceInContext(int elementNodeIndex,
                                             int namespaceNodeIndex) {
        org.apache.xml.utils.SuballocatedIntVector nsList =
          null;
        if (m_namespaceDeclSets ==
              null) {
            m_namespaceDeclSetElements =
              new org.apache.xml.utils.SuballocatedIntVector(
                32);
            m_namespaceDeclSetElements.
              addElement(
                elementNodeIndex);
            m_namespaceDeclSets =
              new java.util.Vector(
                );
            nsList =
              new org.apache.xml.utils.SuballocatedIntVector(
                32);
            m_namespaceDeclSets.
              addElement(
                nsList);
        }
        else {
            int last =
              m_namespaceDeclSetElements.
              size(
                ) -
              1;
            if (last >=
                  0 &&
                  elementNodeIndex ==
                  m_namespaceDeclSetElements.
                  elementAt(
                    last)) {
                nsList =
                  (org.apache.xml.utils.SuballocatedIntVector)
                    m_namespaceDeclSets.
                    elementAt(
                      last);
            }
        }
        if (nsList ==
              null) {
            m_namespaceDeclSetElements.
              addElement(
                elementNodeIndex);
            org.apache.xml.utils.SuballocatedIntVector inherited =
              findNamespaceContext(
                _parent(
                  elementNodeIndex));
            if (inherited !=
                  null) {
                int isize =
                  inherited.
                  size(
                    );
                nsList =
                  new org.apache.xml.utils.SuballocatedIntVector(
                    java.lang.Math.
                      max(
                        java.lang.Math.
                          min(
                            isize +
                              16,
                            2048),
                        32));
                for (int i =
                       0;
                     i <
                       isize;
                     ++i) {
                    nsList.
                      addElement(
                        inherited.
                          elementAt(
                            i));
                }
            }
            else {
                nsList =
                  new org.apache.xml.utils.SuballocatedIntVector(
                    32);
            }
            m_namespaceDeclSets.
              addElement(
                nsList);
        }
        int newEType =
          _exptype(
            namespaceNodeIndex);
        for (int i =
               nsList.
               size(
                 ) -
               1;
             i >=
               0;
             --i) {
            if (newEType ==
                  getExpandedTypeID(
                    nsList.
                      elementAt(
                        i))) {
                nsList.
                  setElementAt(
                    makeNodeHandle(
                      namespaceNodeIndex),
                    i);
                return;
            }
        }
        nsList.
          addElement(
            makeNodeHandle(
              namespaceNodeIndex));
    }
    protected org.apache.xml.utils.SuballocatedIntVector findNamespaceContext(int elementNodeIndex) {
        if (null !=
              m_namespaceDeclSetElements) {
            int wouldBeAt =
              findInSortedSuballocatedIntVector(
                m_namespaceDeclSetElements,
                elementNodeIndex);
            if (wouldBeAt >=
                  0)
                return (org.apache.xml.utils.SuballocatedIntVector)
                         m_namespaceDeclSets.
                         elementAt(
                           wouldBeAt);
            if (wouldBeAt ==
                  -1)
                return null;
            wouldBeAt =
              -1 -
                wouldBeAt;
            int candidate =
              m_namespaceDeclSetElements.
              elementAt(
                --wouldBeAt);
            int ancestor =
              _parent(
                elementNodeIndex);
            if (wouldBeAt ==
                  0 &&
                  candidate <
                  ancestor) {
                int rootHandle =
                  getDocumentRoot(
                    makeNodeHandle(
                      elementNodeIndex));
                int rootID =
                  makeNodeIdentity(
                    rootHandle);
                int uppermostNSCandidateID;
                if (getNodeType(
                      rootHandle) ==
                      org.apache.xml.dtm.DTM.
                        DOCUMENT_NODE) {
                    int ch =
                      _firstch(
                        rootID);
                    uppermostNSCandidateID =
                      ch !=
                        org.apache.xml.dtm.DTM.
                          NULL
                        ? ch
                        : rootID;
                }
                else {
                    uppermostNSCandidateID =
                      rootID;
                }
                if (candidate ==
                      uppermostNSCandidateID) {
                    return (org.apache.xml.utils.SuballocatedIntVector)
                             m_namespaceDeclSets.
                             elementAt(
                               wouldBeAt);
                }
            }
            while (wouldBeAt >=
                     0 &&
                     ancestor >
                     0) {
                if (candidate ==
                      ancestor) {
                    return (org.apache.xml.utils.SuballocatedIntVector)
                             m_namespaceDeclSets.
                             elementAt(
                               wouldBeAt);
                }
                else
                    if (candidate <
                          ancestor) {
                        do  {
                            ancestor =
                              _parent(
                                ancestor);
                        }while(candidate <
                                 ancestor); 
                    }
                    else
                        if (wouldBeAt >
                              0) {
                            candidate =
                              m_namespaceDeclSetElements.
                                elementAt(
                                  --wouldBeAt);
                        }
                        else
                            break;
            }
        }
        return null;
    }
    protected int findInSortedSuballocatedIntVector(org.apache.xml.utils.SuballocatedIntVector vector,
                                                    int lookfor) {
        int i =
          0;
        if (vector !=
              null) {
            int first =
              0;
            int last =
              vector.
              size(
                ) -
              1;
            while (first <=
                     last) {
                i =
                  (first +
                     last) /
                    2;
                int test =
                  lookfor -
                  vector.
                  elementAt(
                    i);
                if (test ==
                      0) {
                    return i;
                }
                else
                    if (test <
                          0) {
                        last =
                          i -
                            1;
                    }
                    else {
                        first =
                          i +
                            1;
                    }
            }
            if (first >
                  i) {
                i =
                  first;
            }
        }
        return -1 -
          i;
    }
    public int getFirstNamespaceNode(int nodeHandle,
                                     boolean inScope) {
        if (inScope) {
            int identity =
              makeNodeIdentity(
                nodeHandle);
            if (_type(
                  identity) ==
                  org.apache.xml.dtm.DTM.
                    ELEMENT_NODE) {
                org.apache.xml.utils.SuballocatedIntVector nsContext =
                  findNamespaceContext(
                    identity);
                if (nsContext ==
                      null ||
                      nsContext.
                      size(
                        ) <
                      1)
                    return NULL;
                return nsContext.
                  elementAt(
                    0);
            }
            else
                return NULL;
        }
        else {
            int identity =
              makeNodeIdentity(
                nodeHandle);
            if (_type(
                  identity) ==
                  org.apache.xml.dtm.DTM.
                    ELEMENT_NODE) {
                while (org.apache.xml.dtm.DTM.
                         NULL !=
                         (identity =
                            getNextNodeIdentity(
                              identity))) {
                    int type =
                      _type(
                        identity);
                    if (type ==
                          org.apache.xml.dtm.DTM.
                            NAMESPACE_NODE)
                        return makeNodeHandle(
                                 identity);
                    else
                        if (org.apache.xml.dtm.DTM.
                              ATTRIBUTE_NODE !=
                              type)
                            break;
                }
                return NULL;
            }
            else
                return NULL;
        }
    }
    public int getNextNamespaceNode(int baseHandle,
                                    int nodeHandle,
                                    boolean inScope) {
        if (inScope) {
            org.apache.xml.utils.SuballocatedIntVector nsContext =
              findNamespaceContext(
                makeNodeIdentity(
                  baseHandle));
            if (nsContext ==
                  null)
                return NULL;
            int i =
              1 +
              nsContext.
              indexOf(
                nodeHandle);
            if (i <=
                  0 ||
                  i ==
                  nsContext.
                  size(
                    ))
                return NULL;
            return nsContext.
              elementAt(
                i);
        }
        else {
            int identity =
              makeNodeIdentity(
                nodeHandle);
            while (org.apache.xml.dtm.DTM.
                     NULL !=
                     (identity =
                        getNextNodeIdentity(
                          identity))) {
                int type =
                  _type(
                    identity);
                if (type ==
                      org.apache.xml.dtm.DTM.
                        NAMESPACE_NODE) {
                    return makeNodeHandle(
                             identity);
                }
                else
                    if (type !=
                          org.apache.xml.dtm.DTM.
                            ATTRIBUTE_NODE) {
                        break;
                    }
            }
        }
        return org.apache.xml.dtm.DTM.
                 NULL;
    }
    public int getParent(int nodeHandle) {
        int identity =
          makeNodeIdentity(
            nodeHandle);
        if (identity >
              0)
            return makeNodeHandle(
                     _parent(
                       identity));
        else
            return org.apache.xml.dtm.DTM.
                     NULL;
    }
    public int getDocument() { return m_dtmIdent.
                                 elementAt(
                                   0); }
    public int getOwnerDocument(int nodeHandle) {
        if (org.apache.xml.dtm.DTM.
              DOCUMENT_NODE ==
              getNodeType(
                nodeHandle))
            return org.apache.xml.dtm.DTM.
                     NULL;
        return getDocumentRoot(
                 nodeHandle);
    }
    public int getDocumentRoot(int nodeHandle) {
        return getManager(
                 ).
          getDTM(
            nodeHandle).
          getDocument(
            );
    }
    public abstract org.apache.xml.utils.XMLString getStringValue(int nodeHandle);
    public int getStringValueChunkCount(int nodeHandle) {
        error(
          org.apache.xml.res.XMLMessages.
            createXMLMessage(
              org.apache.xml.res.XMLErrorResources.
                ER_METHOD_NOT_SUPPORTED,
              null));
        return 0;
    }
    public char[] getStringValueChunk(int nodeHandle,
                                      int chunkIndex,
                                      int[] startAndLen) {
        error(
          org.apache.xml.res.XMLMessages.
            createXMLMessage(
              org.apache.xml.res.XMLErrorResources.
                ER_METHOD_NOT_SUPPORTED,
              null));
        return null;
    }
    public int getExpandedTypeID(int nodeHandle) {
        int id =
          makeNodeIdentity(
            nodeHandle);
        if (id ==
              NULL)
            return NULL;
        return _exptype(
                 id);
    }
    public int getExpandedTypeID(java.lang.String namespace,
                                 java.lang.String localName,
                                 int type) {
        org.apache.xml.dtm.ref.ExpandedNameTable ent =
          m_expandedNameTable;
        return ent.
          getExpandedTypeID(
            namespace,
            localName,
            type);
    }
    public java.lang.String getLocalNameFromExpandedNameID(int expandedNameID) {
        return m_expandedNameTable.
          getLocalName(
            expandedNameID);
    }
    public java.lang.String getNamespaceFromExpandedNameID(int expandedNameID) {
        return m_expandedNameTable.
          getNamespace(
            expandedNameID);
    }
    public int getNamespaceType(final int nodeHandle) {
        int identity =
          makeNodeIdentity(
            nodeHandle);
        int expandedNameID =
          _exptype(
            identity);
        return m_expandedNameTable.
          getNamespaceID(
            expandedNameID);
    }
    public abstract java.lang.String getNodeName(int nodeHandle);
    public java.lang.String getNodeNameX(int nodeHandle) {
        error(
          org.apache.xml.res.XMLMessages.
            createXMLMessage(
              org.apache.xml.res.XMLErrorResources.
                ER_METHOD_NOT_SUPPORTED,
              null));
        return null;
    }
    public abstract java.lang.String getLocalName(int nodeHandle);
    public abstract java.lang.String getPrefix(int nodeHandle);
    public abstract java.lang.String getNamespaceURI(int nodeHandle);
    public abstract java.lang.String getNodeValue(int nodeHandle);
    public short getNodeType(int nodeHandle) {
        if (nodeHandle ==
              org.apache.xml.dtm.DTM.
                NULL)
            return org.apache.xml.dtm.DTM.
                     NULL;
        return m_expandedNameTable.
          getType(
            _exptype(
              makeNodeIdentity(
                nodeHandle)));
    }
    public short getLevel(int nodeHandle) {
        int identity =
          makeNodeIdentity(
            nodeHandle);
        return (short)
                 (_level(
                    identity) +
                    1);
    }
    public int getNodeIdent(int nodeHandle) {
        return makeNodeIdentity(
                 nodeHandle);
    }
    public int getNodeHandle(int nodeId) {
        return makeNodeHandle(
                 nodeId);
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
        return m_documentBaseURI;
    }
    public java.lang.String getDocumentEncoding(int nodeHandle) {
        return "UTF-8";
    }
    public java.lang.String getDocumentStandalone(int nodeHandle) {
        return null;
    }
    public java.lang.String getDocumentVersion(int documentHandle) {
        return null;
    }
    public boolean getDocumentAllDeclarationsProcessed() {
        return true;
    }
    public abstract java.lang.String getDocumentTypeDeclarationSystemIdentifier();
    public abstract java.lang.String getDocumentTypeDeclarationPublicIdentifier();
    public abstract int getElementById(java.lang.String elementId);
    public abstract java.lang.String getUnparsedEntityURI(java.lang.String name);
    public boolean supportsPreStripping() {
        return true;
    }
    public boolean isNodeAfter(int nodeHandle1,
                               int nodeHandle2) {
        int index1 =
          makeNodeIdentity(
            nodeHandle1);
        int index2 =
          makeNodeIdentity(
            nodeHandle2);
        return index1 !=
          NULL &&
          index2 !=
          NULL &&
          index1 <=
          index2;
    }
    public boolean isCharacterElementContentWhitespace(int nodeHandle) {
        return false;
    }
    public boolean isDocumentAllDeclarationsProcessed(int documentHandle) {
        return true;
    }
    public abstract boolean isAttributeSpecified(int attributeHandle);
    public abstract void dispatchCharactersEvents(int nodeHandle,
                                                  org.xml.sax.ContentHandler ch,
                                                  boolean normalize)
          throws org.xml.sax.SAXException;
    public abstract void dispatchToEvents(int nodeHandle,
                                          org.xml.sax.ContentHandler ch)
          throws org.xml.sax.SAXException;
    public org.w3c.dom.Node getNode(int nodeHandle) {
        return new org.apache.xml.dtm.ref.DTMNodeProxy(
          this,
          nodeHandle);
    }
    public void appendChild(int newChild,
                            boolean clone,
                            boolean cloneDepth) {
        error(
          org.apache.xml.res.XMLMessages.
            createXMLMessage(
              org.apache.xml.res.XMLErrorResources.
                ER_METHOD_NOT_SUPPORTED,
              null));
    }
    public void appendTextChild(java.lang.String str) {
        error(
          org.apache.xml.res.XMLMessages.
            createXMLMessage(
              org.apache.xml.res.XMLErrorResources.
                ER_METHOD_NOT_SUPPORTED,
              null));
    }
    protected void error(java.lang.String msg) {
        throw new org.apache.xml.dtm.DTMException(
          msg);
    }
    protected boolean getShouldStripWhitespace() {
        return m_shouldStripWS;
    }
    protected void pushShouldStripWhitespace(boolean shouldStrip) {
        m_shouldStripWS =
          shouldStrip;
        if (null !=
              m_shouldStripWhitespaceStack)
            m_shouldStripWhitespaceStack.
              push(
                shouldStrip);
    }
    protected void popShouldStripWhitespace() {
        if (null !=
              m_shouldStripWhitespaceStack)
            m_shouldStripWS =
              m_shouldStripWhitespaceStack.
                popAndTop(
                  );
    }
    protected void setShouldStripWhitespace(boolean shouldStrip) {
        m_shouldStripWS =
          shouldStrip;
        if (null !=
              m_shouldStripWhitespaceStack)
            m_shouldStripWhitespaceStack.
              setTop(
                shouldStrip);
    }
    public void documentRegistration() { 
    }
    public void documentRelease() {  }
    public void migrateTo(org.apache.xml.dtm.DTMManager mgr) {
        m_mgr =
          mgr;
        if (mgr instanceof org.apache.xml.dtm.ref.DTMManagerDefault)
            m_mgrDefault =
              (org.apache.xml.dtm.ref.DTMManagerDefault)
                mgr;
    }
    public org.apache.xml.dtm.DTMManager getManager() {
        return m_mgr;
    }
    public org.apache.xml.utils.SuballocatedIntVector getDTMIDs() {
        if (m_mgr ==
              null)
            return null;
        return m_dtmIdent;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "F1WdXkIIYX9sKQ8CYspBGSNNwVD1uAPBYEWxYA99UYzNyum/1aP+OPs9U1R0" +
       "pkT/ayy/emWpmjJpQNcXBdum+UkCjMKzyo7CEMdpyWQ6xmb+0J11HGUcuK49" +
       "DFwiK/8ug+tmJS6ZNMPVnTBMGmPLCtc7NP3WYWjaIOpqkGj6baWmMmmmaQr8" +
       "vZnoKqfpdw5D00WirkUSTe9QaiqTZppmDH2tRNM7PWo6Gz5Noq4miaZ3KzWV" +
       "SYP7AE01mCvTcoru9qgo+utmUVWzRNH7lIrKpCkZCY0PI5kJ3U1vhFEQRlAT" +
       "47Cy06jl2jq29hiNfW3KVzcfU/neKTxumFw2t22Zcu6hU2om33VnimcvP61z" +
       "LFC+/pV9302/eDAYFNHR6aXB2jyBin1Tov9zlsx47N8GA3N+be5fUxHG6ONK" +
       "4jerCe578Hunbp2z8ruc06MloZuV/6dfevWp7Rt27+KzNZz9UjJbtvNQut2B" +
       "q0nTFStiVmO/v/j0Rw7sP/eCfMsNw2RPYS423ArxLSf+q/KTJUfHud9jx2mE" +
       "T5swkjZJx9mn7DgyaUrGlnYc3OHRxbzX2ecf96j6NPisFJWvlKj+tFJ1mTQl" +
       "Q2HIBVWbUnE9p5vOaUKhQ7IFH96kPx154J69F1U+l2/SnxUrW6NS1lTaja2S" +
       "Hd+b+sSmHVNfY0FvVcKE6Hu+0VNm/8Mm8+6uVw4+PXTC3Wzxkhk1VjrUuXFU" +
       "ui9UtN3DMNVg8hxvpueLg+dKMMgaDo9/U9LzT/ABDb1ZnIdDdMMQ5t3Nv6oq" +
       "Dv3ZAnQ0QYzlAz8Q0H/AoZ/nsz7g+vJQ/1lFi1bF5HXW2PNKFqdYH+QZRPd6" +
       "QzLVwj/ZtGIdK+oMCLWTeqqH7x/Nx+SvYuUJyw+K7Qzh/UZaM5qGZDql49ps" +
       "/hrfGkmk6wpbqHAxV6IpOnvnsLCMWbM1Rz716UOhF64bM6R0TwRLmyjZ8Zgl" +
       "76fOCn59+d/GdpzVe5GHzY5Jjm7sLPL7y3btXTwjdl2Q7b/yKXnJvm2x0Lzi" +
       "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" +
       "HiYOd1o+hc0UHKQMfCGWPRVuLKg+S0CY");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AdXiCajTvQEypil26PINqu2wJBapVZot");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "vunt79aY7y7srW/wVJS7J/L8L7T1hW4f");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "vawAAA==");
}
