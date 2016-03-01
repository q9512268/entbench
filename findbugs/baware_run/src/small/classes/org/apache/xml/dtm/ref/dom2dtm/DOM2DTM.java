package org.apache.xml.dtm.ref.dom2dtm;
public class DOM2DTM extends org.apache.xml.dtm.ref.DTMDefaultBaseIterators {
    static final boolean JJK_DEBUG = false;
    static final boolean JJK_NEWCODE = true;
    static final java.lang.String NAMESPACE_DECL_NS = "http://www.w3.org/XML/1998/namespace";
    private transient org.w3c.dom.Node m_pos;
    private int m_last_parent = 0;
    private int m_last_kid = NULL;
    private transient org.w3c.dom.Node m_root;
    boolean m_processedFirstElement = false;
    private transient boolean m_nodesAreProcessed;
    protected java.util.Vector m_nodes = new java.util.Vector();
    public DOM2DTM(org.apache.xml.dtm.DTMManager mgr, javax.xml.transform.dom.DOMSource domSource,
                   int dtmIdentity,
                   org.apache.xml.dtm.DTMWSFilter whiteSpaceFilter,
                   org.apache.xml.utils.XMLStringFactory xstringfactory,
                   boolean doIndexing) { super(mgr, domSource, dtmIdentity,
                                               whiteSpaceFilter,
                                               xstringfactory,
                                               doIndexing);
                                         m_pos = (m_root = domSource.
                                                             getNode(
                                                               ));
                                         m_last_parent = (m_last_kid =
                                                            NULL);
                                         m_last_kid = addNode(m_root,
                                                              m_last_parent,
                                                              m_last_kid,
                                                              NULL);
                                         if (ELEMENT_NODE == m_root.
                                               getNodeType(
                                                 )) { org.w3c.dom.NamedNodeMap attrs =
                                                        m_root.
                                                        getAttributes(
                                                          );
                                                      int attrsize =
                                                        attrs ==
                                                        null
                                                        ? 0
                                                        : attrs.
                                                        getLength(
                                                          );
                                                      if (attrsize >
                                                            0) {
                                                          int attrIndex =
                                                            NULL;
                                                          for (int i =
                                                                 0;
                                                               i <
                                                                 attrsize;
                                                               ++i) {
                                                              attrIndex =
                                                                addNode(
                                                                  attrs.
                                                                    item(
                                                                      i),
                                                                  0,
                                                                  attrIndex,
                                                                  NULL);
                                                              m_firstch.
                                                                setElementAt(
                                                                  org.apache.xml.dtm.DTM.
                                                                    NULL,
                                                                  attrIndex);
                                                          }
                                                          m_nextsib.
                                                            setElementAt(
                                                              org.apache.xml.dtm.DTM.
                                                                NULL,
                                                              attrIndex);
                                                      }
                                         }
                                         m_nodesAreProcessed =
                                           false;
    }
    protected int addNode(org.w3c.dom.Node node,
                          int parentIndex,
                          int previousSibling,
                          int forceNodeType) {
        int nodeIndex =
          m_nodes.
          size(
            );
        if (m_dtmIdent.
              size(
                ) ==
              nodeIndex >>>
              org.apache.xml.dtm.DTMManager.
                IDENT_DTM_NODE_BITS) {
            try {
                if (m_mgr ==
                      null)
                    throw new java.lang.ClassCastException(
                      );
                org.apache.xml.dtm.ref.DTMManagerDefault mgrD =
                  (org.apache.xml.dtm.ref.DTMManagerDefault)
                    m_mgr;
                int id =
                  mgrD.
                  getFirstFreeDTMID(
                    );
                mgrD.
                  addDTM(
                    this,
                    id,
                    nodeIndex);
                m_dtmIdent.
                  addElement(
                    id <<
                      org.apache.xml.dtm.DTMManager.
                        IDENT_DTM_NODE_BITS);
            }
            catch (java.lang.ClassCastException e) {
                error(
                  org.apache.xml.res.XMLMessages.
                    createXMLMessage(
                      org.apache.xml.res.XMLErrorResources.
                        ER_NO_DTMIDS_AVAIL,
                      null));
            }
        }
        m_size++;
        int type;
        if (NULL ==
              forceNodeType)
            type =
              node.
                getNodeType(
                  );
        else
            type =
              forceNodeType;
        if (org.w3c.dom.Node.
              ATTRIBUTE_NODE ==
              type) {
            java.lang.String name =
              node.
              getNodeName(
                );
            if (name.
                  startsWith(
                    "xmlns:") ||
                  name.
                  equals(
                    "xmlns")) {
                type =
                  org.apache.xml.dtm.DTM.
                    NAMESPACE_NODE;
            }
        }
        m_nodes.
          addElement(
            node);
        m_firstch.
          setElementAt(
            NOTPROCESSED,
            nodeIndex);
        m_nextsib.
          setElementAt(
            NOTPROCESSED,
            nodeIndex);
        m_prevsib.
          setElementAt(
            previousSibling,
            nodeIndex);
        m_parent.
          setElementAt(
            parentIndex,
            nodeIndex);
        if (org.apache.xml.dtm.DTM.
              NULL !=
              parentIndex &&
              type !=
              org.apache.xml.dtm.DTM.
                ATTRIBUTE_NODE &&
              type !=
              org.apache.xml.dtm.DTM.
                NAMESPACE_NODE) {
            if (NOTPROCESSED ==
                  m_firstch.
                  elementAt(
                    parentIndex))
                m_firstch.
                  setElementAt(
                    nodeIndex,
                    parentIndex);
        }
        java.lang.String nsURI =
          node.
          getNamespaceURI(
            );
        java.lang.String localName =
          type ==
          org.w3c.dom.Node.
            PROCESSING_INSTRUCTION_NODE
          ? node.
          getNodeName(
            )
          : node.
          getLocalName(
            );
        if ((type ==
               org.w3c.dom.Node.
                 ELEMENT_NODE ||
               type ==
               org.w3c.dom.Node.
                 ATTRIBUTE_NODE) &&
              null ==
              localName)
            localName =
              node.
                getNodeName(
                  );
        org.apache.xml.dtm.ref.ExpandedNameTable exnt =
          m_expandedNameTable;
        if (node.
              getLocalName(
                ) ==
              null &&
              (type ==
                 org.w3c.dom.Node.
                   ELEMENT_NODE ||
                 type ==
                 org.w3c.dom.Node.
                   ATTRIBUTE_NODE)) {
            
        }
        int expandedNameID =
          null !=
          localName
          ? exnt.
          getExpandedTypeID(
            nsURI,
            localName,
            type)
          : exnt.
          getExpandedTypeID(
            type);
        m_exptype.
          setElementAt(
            expandedNameID,
            nodeIndex);
        indexNode(
          expandedNameID,
          nodeIndex);
        if (org.apache.xml.dtm.DTM.
              NULL !=
              previousSibling)
            m_nextsib.
              setElementAt(
                nodeIndex,
                previousSibling);
        if (type ==
              org.apache.xml.dtm.DTM.
                NAMESPACE_NODE)
            declareNamespaceInContext(
              parentIndex,
              nodeIndex);
        return nodeIndex;
    }
    public int getNumberOfNodes() { return m_nodes.
                                      size(
                                        );
    }
    protected boolean nextNode() { if (m_nodesAreProcessed)
                                       return false;
                                   org.w3c.dom.Node pos =
                                     m_pos;
                                   org.w3c.dom.Node next =
                                     null;
                                   int nexttype =
                                     NULL;
                                   do  { if (pos.
                                               hasChildNodes(
                                                 )) {
                                             next =
                                               pos.
                                                 getFirstChild(
                                                   );
                                             if (next !=
                                                   null &&
                                                   DOCUMENT_TYPE_NODE ==
                                                   next.
                                                   getNodeType(
                                                     ))
                                                 next =
                                                   next.
                                                     getNextSibling(
                                                       );
                                             if (ENTITY_REFERENCE_NODE !=
                                                   pos.
                                                   getNodeType(
                                                     )) {
                                                 m_last_parent =
                                                   m_last_kid;
                                                 m_last_kid =
                                                   NULL;
                                                 if (null !=
                                                       m_wsfilter) {
                                                     short wsv =
                                                       m_wsfilter.
                                                       getShouldStripSpace(
                                                         makeNodeHandle(
                                                           m_last_parent),
                                                         this);
                                                     boolean shouldStrip =
                                                       org.apache.xml.dtm.DTMWSFilter.
                                                         INHERIT ==
                                                       wsv
                                                       ? getShouldStripWhitespace(
                                                           )
                                                       : org.apache.xml.dtm.DTMWSFilter.
                                                           STRIP ==
                                                       wsv;
                                                     pushShouldStripWhitespace(
                                                       shouldStrip);
                                                 }
                                             }
                                         }
                                         else {
                                             if (m_last_kid !=
                                                   NULL) {
                                                 if (m_firstch.
                                                       elementAt(
                                                         m_last_kid) ==
                                                       NOTPROCESSED)
                                                     m_firstch.
                                                       setElementAt(
                                                         NULL,
                                                         m_last_kid);
                                             }
                                             while (m_last_parent !=
                                                      NULL) {
                                                 next =
                                                   pos.
                                                     getNextSibling(
                                                       );
                                                 if (next !=
                                                       null &&
                                                       DOCUMENT_TYPE_NODE ==
                                                       next.
                                                       getNodeType(
                                                         ))
                                                     next =
                                                       next.
                                                         getNextSibling(
                                                           );
                                                 if (next !=
                                                       null)
                                                     break;
                                                 pos =
                                                   pos.
                                                     getParentNode(
                                                       );
                                                 if (pos ==
                                                       null) {
                                                     if (JJK_DEBUG) {
                                                         java.lang.System.
                                                           out.
                                                           println(
                                                             "***** DOM2DTM Pop Control Flow problem");
                                                         for (;
                                                              ;
                                                              )
                                                             ;
                                                     }
                                                 }
                                                 if (pos !=
                                                       null &&
                                                       ENTITY_REFERENCE_NODE ==
                                                       pos.
                                                       getNodeType(
                                                         )) {
                                                     if (JJK_DEBUG)
                                                         java.lang.System.
                                                           out.
                                                           println(
                                                             "***** DOM2DTM popping EntRef");
                                                 }
                                                 else {
                                                     popShouldStripWhitespace(
                                                       );
                                                     if (m_last_kid ==
                                                           NULL)
                                                         m_firstch.
                                                           setElementAt(
                                                             NULL,
                                                             m_last_parent);
                                                     else
                                                         m_nextsib.
                                                           setElementAt(
                                                             NULL,
                                                             m_last_kid);
                                                     m_last_parent =
                                                       m_parent.
                                                         elementAt(
                                                           m_last_kid =
                                                             m_last_parent);
                                                 }
                                             }
                                             if (m_last_parent ==
                                                   NULL)
                                                 next =
                                                   null;
                                         }
                                         if (next !=
                                               null)
                                             nexttype =
                                               next.
                                                 getNodeType(
                                                   );
                                         if (ENTITY_REFERENCE_NODE ==
                                               nexttype)
                                             pos =
                                               next;
                                   }while(ENTITY_REFERENCE_NODE ==
                                            nexttype); 
                                   if (next ==
                                         null) {
                                       m_nextsib.
                                         setElementAt(
                                           NULL,
                                           0);
                                       m_nodesAreProcessed =
                                         true;
                                       m_pos =
                                         null;
                                       if (JJK_DEBUG) {
                                           java.lang.System.
                                             out.
                                             println(
                                               "***** DOM2DTM Crosscheck:");
                                           for (int i =
                                                  0;
                                                i <
                                                  m_nodes.
                                                  size(
                                                    );
                                                ++i)
                                               java.lang.System.
                                                 out.
                                                 println(
                                                   i +
                                                   ":\t" +
                                                   m_firstch.
                                                     elementAt(
                                                       i) +
                                                   "\t" +
                                                   m_nextsib.
                                                     elementAt(
                                                       i));
                                       }
                                       return false;
                                   }
                                   boolean suppressNode =
                                     false;
                                   org.w3c.dom.Node lastTextNode =
                                     null;
                                   nexttype =
                                     next.
                                       getNodeType(
                                         );
                                   if (TEXT_NODE ==
                                         nexttype ||
                                         CDATA_SECTION_NODE ==
                                         nexttype) {
                                       suppressNode =
                                         null !=
                                           m_wsfilter &&
                                           getShouldStripWhitespace(
                                             );
                                       org.w3c.dom.Node n =
                                         next;
                                       while (n !=
                                                null) {
                                           lastTextNode =
                                             n;
                                           if (TEXT_NODE ==
                                                 n.
                                                 getNodeType(
                                                   ))
                                               nexttype =
                                                 TEXT_NODE;
                                           suppressNode &=
                                             org.apache.xml.utils.XMLCharacterRecognizer.
                                               isWhiteSpace(
                                                 n.
                                                   getNodeValue(
                                                     ));
                                           n =
                                             logicalNextDOMTextNode(
                                               n);
                                       }
                                   }
                                   else
                                       if (PROCESSING_INSTRUCTION_NODE ==
                                             nexttype) {
                                           suppressNode =
                                             pos.
                                               getNodeName(
                                                 ).
                                               toLowerCase(
                                                 ).
                                               equals(
                                                 "xml");
                                       }
                                   if (!suppressNode) {
                                       int nextindex =
                                         addNode(
                                           next,
                                           m_last_parent,
                                           m_last_kid,
                                           nexttype);
                                       m_last_kid =
                                         nextindex;
                                       if (ELEMENT_NODE ==
                                             nexttype) {
                                           int attrIndex =
                                             NULL;
                                           org.w3c.dom.NamedNodeMap attrs =
                                             next.
                                             getAttributes(
                                               );
                                           int attrsize =
                                             attrs ==
                                             null
                                             ? 0
                                             : attrs.
                                             getLength(
                                               );
                                           if (attrsize >
                                                 0) {
                                               for (int i =
                                                      0;
                                                    i <
                                                      attrsize;
                                                    ++i) {
                                                   attrIndex =
                                                     addNode(
                                                       attrs.
                                                         item(
                                                           i),
                                                       nextindex,
                                                       attrIndex,
                                                       NULL);
                                                   m_firstch.
                                                     setElementAt(
                                                       org.apache.xml.dtm.DTM.
                                                         NULL,
                                                       attrIndex);
                                                   if (!m_processedFirstElement &&
                                                         "xmlns:xml".
                                                         equals(
                                                           attrs.
                                                             item(
                                                               i).
                                                             getNodeName(
                                                               )))
                                                       m_processedFirstElement =
                                                         true;
                                               }
                                           }
                                           if (!m_processedFirstElement) {
                                               attrIndex =
                                                 addNode(
                                                   new org.apache.xml.dtm.ref.dom2dtm.DOM2DTMdefaultNamespaceDeclarationNode(
                                                     (org.w3c.dom.Element)
                                                       next,
                                                     "xml",
                                                     NAMESPACE_DECL_NS,
                                                     makeNodeHandle(
                                                       (attrIndex ==
                                                          NULL
                                                          ? nextindex
                                                          : attrIndex) +
                                                         1)),
                                                   nextindex,
                                                   attrIndex,
                                                   NULL);
                                               m_firstch.
                                                 setElementAt(
                                                   org.apache.xml.dtm.DTM.
                                                     NULL,
                                                   attrIndex);
                                               m_processedFirstElement =
                                                 true;
                                           }
                                           if (attrIndex !=
                                                 NULL)
                                               m_nextsib.
                                                 setElementAt(
                                                   org.apache.xml.dtm.DTM.
                                                     NULL,
                                                   attrIndex);
                                       }
                                   }
                                   if (TEXT_NODE ==
                                         nexttype ||
                                         CDATA_SECTION_NODE ==
                                         nexttype) {
                                       next =
                                         lastTextNode;
                                   }
                                   m_pos =
                                     next;
                                   return true;
    }
    public org.w3c.dom.Node getNode(int nodeHandle) {
        int identity =
          makeNodeIdentity(
            nodeHandle);
        return (org.w3c.dom.Node)
                 m_nodes.
                 elementAt(
                   identity);
    }
    protected org.w3c.dom.Node lookupNode(int nodeIdentity) {
        return (org.w3c.dom.Node)
                 m_nodes.
                 elementAt(
                   nodeIdentity);
    }
    protected int getNextNodeIdentity(int identity) {
        identity +=
          1;
        if (identity >=
              m_nodes.
              size(
                )) {
            if (!nextNode(
                   ))
                identity =
                  org.apache.xml.dtm.DTM.
                    NULL;
        }
        return identity;
    }
    private int getHandleFromNode(org.w3c.dom.Node node) {
        if (null !=
              node) {
            int len =
              m_nodes.
              size(
                );
            boolean isMore;
            int i =
              0;
            do  {
                for (;
                     i <
                       len;
                     i++) {
                    if (m_nodes.
                          elementAt(
                            i) ==
                          node)
                        return makeNodeHandle(
                                 i);
                }
                isMore =
                  nextNode(
                    );
                len =
                  m_nodes.
                    size(
                      );
            }while(isMore ||
                     i <
                     len); 
        }
        return org.apache.xml.dtm.DTM.
                 NULL;
    }
    public int getHandleOfNode(org.w3c.dom.Node node) {
        if (null !=
              node) {
            if (m_root ==
                  node ||
                  m_root.
                  getNodeType(
                    ) ==
                  DOCUMENT_NODE &&
                  m_root ==
                  node.
                  getOwnerDocument(
                    ) ||
                  m_root.
                  getNodeType(
                    ) !=
                  DOCUMENT_NODE &&
                  m_root.
                  getOwnerDocument(
                    ) ==
                  node.
                  getOwnerDocument(
                    )) {
                for (org.w3c.dom.Node cursor =
                       node;
                     cursor !=
                       null;
                     cursor =
                       cursor.
                         getNodeType(
                           ) !=
                         ATTRIBUTE_NODE
                         ? cursor.
                         getParentNode(
                           )
                         : ((org.w3c.dom.Attr)
                              cursor).
                         getOwnerElement(
                           )) {
                    if (cursor ==
                          m_root)
                        return getHandleFromNode(
                                 node);
                }
            }
        }
        return org.apache.xml.dtm.DTM.
                 NULL;
    }
    public int getAttributeNode(int nodeHandle,
                                java.lang.String namespaceURI,
                                java.lang.String name) {
        if (null ==
              namespaceURI)
            namespaceURI =
              "";
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
                        ATTRIBUTE_NODE ||
                      type ==
                      org.apache.xml.dtm.DTM.
                        NAMESPACE_NODE) {
                    org.w3c.dom.Node node =
                      lookupNode(
                        identity);
                    java.lang.String nodeuri =
                      node.
                      getNamespaceURI(
                        );
                    if (null ==
                          nodeuri)
                        nodeuri =
                          "";
                    java.lang.String nodelocalname =
                      node.
                      getLocalName(
                        );
                    if (nodeuri.
                          equals(
                            namespaceURI) &&
                          name.
                          equals(
                            nodelocalname))
                        return makeNodeHandle(
                                 identity);
                }
                else {
                    break;
                }
            }
        }
        return org.apache.xml.dtm.DTM.
                 NULL;
    }
    public org.apache.xml.utils.XMLString getStringValue(int nodeHandle) {
        int type =
          getNodeType(
            nodeHandle);
        org.w3c.dom.Node node =
          getNode(
            nodeHandle);
        if (org.apache.xml.dtm.DTM.
              ELEMENT_NODE ==
              type ||
              org.apache.xml.dtm.DTM.
                DOCUMENT_NODE ==
              type ||
              org.apache.xml.dtm.DTM.
                DOCUMENT_FRAGMENT_NODE ==
              type) {
            org.apache.xml.utils.FastStringBuffer buf =
              org.apache.xml.utils.StringBufferPool.
              get(
                );
            java.lang.String s;
            try {
                getNodeData(
                  node,
                  buf);
                s =
                  buf.
                    length(
                      ) >
                    0
                    ? buf.
                    toString(
                      )
                    : "";
            }
            finally {
                org.apache.xml.utils.StringBufferPool.
                  free(
                    buf);
            }
            return m_xstrf.
              newstr(
                s);
        }
        else
            if (TEXT_NODE ==
                  type ||
                  CDATA_SECTION_NODE ==
                  type) {
                org.apache.xml.utils.FastStringBuffer buf =
                  org.apache.xml.utils.StringBufferPool.
                  get(
                    );
                while (node !=
                         null) {
                    buf.
                      append(
                        node.
                          getNodeValue(
                            ));
                    node =
                      logicalNextDOMTextNode(
                        node);
                }
                java.lang.String s =
                  buf.
                  length(
                    ) >
                  0
                  ? buf.
                  toString(
                    )
                  : "";
                org.apache.xml.utils.StringBufferPool.
                  free(
                    buf);
                return m_xstrf.
                  newstr(
                    s);
            }
            else
                return m_xstrf.
                  newstr(
                    node.
                      getNodeValue(
                        ));
    }
    public boolean isWhitespace(int nodeHandle) {
        int type =
          getNodeType(
            nodeHandle);
        org.w3c.dom.Node node =
          getNode(
            nodeHandle);
        if (TEXT_NODE ==
              type ||
              CDATA_SECTION_NODE ==
              type) {
            org.apache.xml.utils.FastStringBuffer buf =
              org.apache.xml.utils.StringBufferPool.
              get(
                );
            while (node !=
                     null) {
                buf.
                  append(
                    node.
                      getNodeValue(
                        ));
                node =
                  logicalNextDOMTextNode(
                    node);
            }
            boolean b =
              buf.
              isWhitespace(
                0,
                buf.
                  length(
                    ));
            org.apache.xml.utils.StringBufferPool.
              free(
                buf);
            return b;
        }
        return false;
    }
    protected static void getNodeData(org.w3c.dom.Node node,
                                      org.apache.xml.utils.FastStringBuffer buf) {
        switch (node.
                  getNodeType(
                    )) {
            case org.w3c.dom.Node.
                   DOCUMENT_FRAGMENT_NODE:
            case org.w3c.dom.Node.
                   DOCUMENT_NODE:
            case org.w3c.dom.Node.
                   ELEMENT_NODE:
                {
                    for (org.w3c.dom.Node child =
                           node.
                           getFirstChild(
                             );
                         null !=
                           child;
                         child =
                           child.
                             getNextSibling(
                               )) {
                        getNodeData(
                          child,
                          buf);
                    }
                }
                break;
            case org.w3c.dom.Node.
                   TEXT_NODE:
            case org.w3c.dom.Node.
                   CDATA_SECTION_NODE:
            case org.w3c.dom.Node.
                   ATTRIBUTE_NODE:
                buf.
                  append(
                    node.
                      getNodeValue(
                        ));
                break;
            case org.w3c.dom.Node.
                   PROCESSING_INSTRUCTION_NODE:
                break;
            default:
                break;
        }
    }
    public java.lang.String getNodeName(int nodeHandle) {
        org.w3c.dom.Node node =
          getNode(
            nodeHandle);
        return node.
          getNodeName(
            );
    }
    public java.lang.String getNodeNameX(int nodeHandle) {
        java.lang.String name;
        short type =
          getNodeType(
            nodeHandle);
        switch (type) {
            case org.apache.xml.dtm.DTM.
                   NAMESPACE_NODE:
                {
                    org.w3c.dom.Node node =
                      getNode(
                        nodeHandle);
                    name =
                      node.
                        getNodeName(
                          );
                    if (name.
                          startsWith(
                            "xmlns:")) {
                        name =
                          org.apache.xml.utils.QName.
                            getLocalPart(
                              name);
                    }
                    else
                        if (name.
                              equals(
                                "xmlns")) {
                            name =
                              "";
                        }
                }
                break;
            case org.apache.xml.dtm.DTM.
                   ATTRIBUTE_NODE:
            case org.apache.xml.dtm.DTM.
                   ELEMENT_NODE:
            case org.apache.xml.dtm.DTM.
                   ENTITY_REFERENCE_NODE:
            case org.apache.xml.dtm.DTM.
                   PROCESSING_INSTRUCTION_NODE:
                {
                    org.w3c.dom.Node node =
                      getNode(
                        nodeHandle);
                    name =
                      node.
                        getNodeName(
                          );
                }
                break;
            default:
                name =
                  "";
        }
        return name;
    }
    public java.lang.String getLocalName(int nodeHandle) {
        if (JJK_NEWCODE) {
            int id =
              makeNodeIdentity(
                nodeHandle);
            if (NULL ==
                  id)
                return null;
            org.w3c.dom.Node newnode =
              (org.w3c.dom.Node)
                m_nodes.
                elementAt(
                  id);
            java.lang.String newname =
              newnode.
              getLocalName(
                );
            if (null ==
                  newname) {
                java.lang.String qname =
                  newnode.
                  getNodeName(
                    );
                if ('#' ==
                      qname.
                      charAt(
                        0)) {
                    newname =
                      "";
                }
                else {
                    int index =
                      qname.
                      indexOf(
                        ':');
                    newname =
                      index <
                        0
                        ? qname
                        : qname.
                        substring(
                          index +
                            1);
                }
            }
            return newname;
        }
        else {
            java.lang.String name;
            short type =
              getNodeType(
                nodeHandle);
            switch (type) {
                case org.apache.xml.dtm.DTM.
                       ATTRIBUTE_NODE:
                case org.apache.xml.dtm.DTM.
                       ELEMENT_NODE:
                case org.apache.xml.dtm.DTM.
                       ENTITY_REFERENCE_NODE:
                case org.apache.xml.dtm.DTM.
                       NAMESPACE_NODE:
                case org.apache.xml.dtm.DTM.
                       PROCESSING_INSTRUCTION_NODE:
                    {
                        org.w3c.dom.Node node =
                          getNode(
                            nodeHandle);
                        name =
                          node.
                            getLocalName(
                              );
                        if (null ==
                              name) {
                            java.lang.String qname =
                              node.
                              getNodeName(
                                );
                            int index =
                              qname.
                              indexOf(
                                ':');
                            name =
                              index <
                                0
                                ? qname
                                : qname.
                                substring(
                                  index +
                                    1);
                        }
                    }
                    break;
                default:
                    name =
                      "";
            }
            return name;
        }
    }
    public java.lang.String getPrefix(int nodeHandle) {
        java.lang.String prefix;
        short type =
          getNodeType(
            nodeHandle);
        switch (type) {
            case org.apache.xml.dtm.DTM.
                   NAMESPACE_NODE:
                {
                    org.w3c.dom.Node node =
                      getNode(
                        nodeHandle);
                    java.lang.String qname =
                      node.
                      getNodeName(
                        );
                    int index =
                      qname.
                      indexOf(
                        ':');
                    prefix =
                      index <
                        0
                        ? ""
                        : qname.
                        substring(
                          index +
                            1);
                }
                break;
            case org.apache.xml.dtm.DTM.
                   ATTRIBUTE_NODE:
            case org.apache.xml.dtm.DTM.
                   ELEMENT_NODE:
                {
                    org.w3c.dom.Node node =
                      getNode(
                        nodeHandle);
                    java.lang.String qname =
                      node.
                      getNodeName(
                        );
                    int index =
                      qname.
                      indexOf(
                        ':');
                    prefix =
                      index <
                        0
                        ? ""
                        : qname.
                        substring(
                          0,
                          index);
                }
                break;
            default:
                prefix =
                  "";
        }
        return prefix;
    }
    public java.lang.String getNamespaceURI(int nodeHandle) {
        if (JJK_NEWCODE) {
            int id =
              makeNodeIdentity(
                nodeHandle);
            if (id ==
                  NULL)
                return null;
            org.w3c.dom.Node node =
              (org.w3c.dom.Node)
                m_nodes.
                elementAt(
                  id);
            return node.
              getNamespaceURI(
                );
        }
        else {
            java.lang.String nsuri;
            short type =
              getNodeType(
                nodeHandle);
            switch (type) {
                case org.apache.xml.dtm.DTM.
                       ATTRIBUTE_NODE:
                case org.apache.xml.dtm.DTM.
                       ELEMENT_NODE:
                case org.apache.xml.dtm.DTM.
                       ENTITY_REFERENCE_NODE:
                case org.apache.xml.dtm.DTM.
                       NAMESPACE_NODE:
                case org.apache.xml.dtm.DTM.
                       PROCESSING_INSTRUCTION_NODE:
                    {
                        org.w3c.dom.Node node =
                          getNode(
                            nodeHandle);
                        nsuri =
                          node.
                            getNamespaceURI(
                              );
                    }
                    break;
                default:
                    nsuri =
                      null;
            }
            return nsuri;
        }
    }
    private org.w3c.dom.Node logicalNextDOMTextNode(org.w3c.dom.Node n) {
        org.w3c.dom.Node p =
          n.
          getNextSibling(
            );
        if (p ==
              null) {
            for (n =
                   n.
                     getParentNode(
                       );
                 n !=
                   null &&
                   ENTITY_REFERENCE_NODE ==
                   n.
                   getNodeType(
                     );
                 n =
                   n.
                     getParentNode(
                       )) {
                p =
                  n.
                    getNextSibling(
                      );
                if (p !=
                      null)
                    break;
            }
        }
        n =
          p;
        while (n !=
                 null &&
                 ENTITY_REFERENCE_NODE ==
                 n.
                 getNodeType(
                   )) {
            if (n.
                  hasChildNodes(
                    ))
                n =
                  n.
                    getFirstChild(
                      );
            else
                n =
                  n.
                    getNextSibling(
                      );
        }
        if (n !=
              null) {
            int ntype =
              n.
              getNodeType(
                );
            if (TEXT_NODE !=
                  ntype &&
                  CDATA_SECTION_NODE !=
                  ntype)
                n =
                  null;
        }
        return n;
    }
    public java.lang.String getNodeValue(int nodeHandle) {
        int type =
          _exptype(
            makeNodeIdentity(
              nodeHandle));
        type =
          NULL !=
            type
            ? getNodeType(
                nodeHandle)
            : NULL;
        if (TEXT_NODE !=
              type &&
              CDATA_SECTION_NODE !=
              type)
            return getNode(
                     nodeHandle).
              getNodeValue(
                );
        org.w3c.dom.Node node =
          getNode(
            nodeHandle);
        org.w3c.dom.Node n =
          logicalNextDOMTextNode(
            node);
        if (n ==
              null)
            return node.
              getNodeValue(
                );
        org.apache.xml.utils.FastStringBuffer buf =
          org.apache.xml.utils.StringBufferPool.
          get(
            );
        buf.
          append(
            node.
              getNodeValue(
                ));
        while (n !=
                 null) {
            buf.
              append(
                n.
                  getNodeValue(
                    ));
            n =
              logicalNextDOMTextNode(
                n);
        }
        java.lang.String s =
          buf.
          length(
            ) >
          0
          ? buf.
          toString(
            )
          : "";
        org.apache.xml.utils.StringBufferPool.
          free(
            buf);
        return s;
    }
    public java.lang.String getDocumentTypeDeclarationSystemIdentifier() {
        org.w3c.dom.Document doc;
        if (m_root.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                DOCUMENT_NODE)
            doc =
              (org.w3c.dom.Document)
                m_root;
        else
            doc =
              m_root.
                getOwnerDocument(
                  );
        if (null !=
              doc) {
            org.w3c.dom.DocumentType dtd =
              doc.
              getDoctype(
                );
            if (null !=
                  dtd) {
                return dtd.
                  getSystemId(
                    );
            }
        }
        return null;
    }
    public java.lang.String getDocumentTypeDeclarationPublicIdentifier() {
        org.w3c.dom.Document doc;
        if (m_root.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                DOCUMENT_NODE)
            doc =
              (org.w3c.dom.Document)
                m_root;
        else
            doc =
              m_root.
                getOwnerDocument(
                  );
        if (null !=
              doc) {
            org.w3c.dom.DocumentType dtd =
              doc.
              getDoctype(
                );
            if (null !=
                  dtd) {
                return dtd.
                  getPublicId(
                    );
            }
        }
        return null;
    }
    public int getElementById(java.lang.String elementId) {
        org.w3c.dom.Document doc =
          m_root.
          getNodeType(
            ) ==
          org.w3c.dom.Node.
            DOCUMENT_NODE
          ? (org.w3c.dom.Document)
              m_root
          : m_root.
          getOwnerDocument(
            );
        if (null !=
              doc) {
            org.w3c.dom.Node elem =
              doc.
              getElementById(
                elementId);
            if (null !=
                  elem) {
                int elemHandle =
                  getHandleFromNode(
                    elem);
                if (org.apache.xml.dtm.DTM.
                      NULL ==
                      elemHandle) {
                    int identity =
                      m_nodes.
                      size(
                        ) -
                      1;
                    while (org.apache.xml.dtm.DTM.
                             NULL !=
                             (identity =
                                getNextNodeIdentity(
                                  identity))) {
                        org.w3c.dom.Node node =
                          getNode(
                            identity);
                        if (node ==
                              elem) {
                            elemHandle =
                              getHandleFromNode(
                                elem);
                            break;
                        }
                    }
                }
                return elemHandle;
            }
        }
        return org.apache.xml.dtm.DTM.
                 NULL;
    }
    public java.lang.String getUnparsedEntityURI(java.lang.String name) {
        java.lang.String url =
          "";
        org.w3c.dom.Document doc =
          m_root.
          getNodeType(
            ) ==
          org.w3c.dom.Node.
            DOCUMENT_NODE
          ? (org.w3c.dom.Document)
              m_root
          : m_root.
          getOwnerDocument(
            );
        if (null !=
              doc) {
            org.w3c.dom.DocumentType doctype =
              doc.
              getDoctype(
                );
            if (null !=
                  doctype) {
                org.w3c.dom.NamedNodeMap entities =
                  doctype.
                  getEntities(
                    );
                if (null ==
                      entities)
                    return url;
                org.w3c.dom.Entity entity =
                  (org.w3c.dom.Entity)
                    entities.
                    getNamedItem(
                      name);
                if (null ==
                      entity)
                    return url;
                java.lang.String notationName =
                  entity.
                  getNotationName(
                    );
                if (null !=
                      notationName) {
                    url =
                      entity.
                        getSystemId(
                          );
                    if (null ==
                          url) {
                        url =
                          entity.
                            getPublicId(
                              );
                    }
                    else {
                        
                    }
                }
            }
        }
        return url;
    }
    public boolean isAttributeSpecified(int attributeHandle) {
        int type =
          getNodeType(
            attributeHandle);
        if (org.apache.xml.dtm.DTM.
              ATTRIBUTE_NODE ==
              type) {
            org.w3c.dom.Attr attr =
              (org.w3c.dom.Attr)
                getNode(
                  attributeHandle);
            return attr.
              getSpecified(
                );
        }
        return false;
    }
    public void setIncrementalSAXSource(org.apache.xml.dtm.ref.IncrementalSAXSource source) {
        
    }
    public org.xml.sax.ContentHandler getContentHandler() {
        return null;
    }
    public org.xml.sax.ext.LexicalHandler getLexicalHandler() {
        return null;
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
    public boolean needsTwoThreads() { return false;
    }
    private static boolean isSpace(char ch) {
        return org.apache.xml.utils.XMLCharacterRecognizer.
          isWhiteSpace(
            ch);
    }
    public void dispatchCharactersEvents(int nodeHandle,
                                         org.xml.sax.ContentHandler ch,
                                         boolean normalize)
          throws org.xml.sax.SAXException {
        if (normalize) {
            org.apache.xml.utils.XMLString str =
              getStringValue(
                nodeHandle);
            str =
              str.
                fixWhiteSpace(
                  true,
                  true,
                  false);
            str.
              dispatchCharactersEvents(
                ch);
        }
        else {
            int type =
              getNodeType(
                nodeHandle);
            org.w3c.dom.Node node =
              getNode(
                nodeHandle);
            dispatchNodeData(
              node,
              ch,
              0);
            if (TEXT_NODE ==
                  type ||
                  CDATA_SECTION_NODE ==
                  type) {
                while (null !=
                         (node =
                            logicalNextDOMTextNode(
                              node))) {
                    dispatchNodeData(
                      node,
                      ch,
                      0);
                }
            }
        }
    }
    protected static void dispatchNodeData(org.w3c.dom.Node node,
                                           org.xml.sax.ContentHandler ch,
                                           int depth)
          throws org.xml.sax.SAXException {
        switch (node.
                  getNodeType(
                    )) {
            case org.w3c.dom.Node.
                   DOCUMENT_FRAGMENT_NODE:
            case org.w3c.dom.Node.
                   DOCUMENT_NODE:
            case org.w3c.dom.Node.
                   ELEMENT_NODE:
                {
                    for (org.w3c.dom.Node child =
                           node.
                           getFirstChild(
                             );
                         null !=
                           child;
                         child =
                           child.
                             getNextSibling(
                               )) {
                        dispatchNodeData(
                          child,
                          ch,
                          depth +
                            1);
                    }
                }
                break;
            case org.w3c.dom.Node.
                   PROCESSING_INSTRUCTION_NODE:
            case org.w3c.dom.Node.
                   COMMENT_NODE:
                if (0 !=
                      depth)
                    break;
            case org.w3c.dom.Node.
                   TEXT_NODE:
            case org.w3c.dom.Node.
                   CDATA_SECTION_NODE:
            case org.w3c.dom.Node.
                   ATTRIBUTE_NODE:
                java.lang.String str =
                  node.
                  getNodeValue(
                    );
                if (ch instanceof org.apache.xml.dtm.ref.dom2dtm.DOM2DTM.CharacterNodeHandler) {
                    ((org.apache.xml.dtm.ref.dom2dtm.DOM2DTM.CharacterNodeHandler)
                       ch).
                      characters(
                        node);
                }
                else {
                    ch.
                      characters(
                        str.
                          toCharArray(
                            ),
                        0,
                        str.
                          length(
                            ));
                }
                break;
            default:
                break;
        }
    }
    org.apache.xml.utils.TreeWalker m_walker =
      new org.apache.xml.utils.TreeWalker(
      null);
    public void dispatchToEvents(int nodeHandle,
                                 org.xml.sax.ContentHandler ch)
          throws org.xml.sax.SAXException {
        org.apache.xml.utils.TreeWalker treeWalker =
          m_walker;
        org.xml.sax.ContentHandler prevCH =
          treeWalker.
          getContentHandler(
            );
        if (null !=
              prevCH) {
            treeWalker =
              new org.apache.xml.utils.TreeWalker(
                null);
        }
        treeWalker.
          setContentHandler(
            ch);
        try {
            org.w3c.dom.Node node =
              getNode(
                nodeHandle);
            treeWalker.
              traverseFragment(
                node);
        }
        finally {
            treeWalker.
              setContentHandler(
                null);
        }
    }
    public static interface CharacterNodeHandler {
        public void characters(org.w3c.dom.Node node)
              throws org.xml.sax.SAXException;
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1444739587000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "2IgBQ/c80/w/MbvsLTkiAAA=");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1444739587000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "obO0E4zuHHFvH84+loG/nIEPZODvZODv7oa4lxdbd8LZXSb7ubv0/f2zk/7I" +
           "S+XynfD5sxn4RAaeB+FTFwKdAMnvdnnqnHF4ZeqVCO0fZ+CTGfhUBv5hBj79" +
           "MoV2617ktsl5q+wM/tJdGPnMyxRaTu7tJ/L6pxn4Zxn4ZZAVFS8SzNtm9XtF" +
           "xzEVwX7FEvt8Bn4lA/88A7+agc+9ShLbnedLd+n719+jsL6YgV/LwL8BxhU6" +
           "J+f4xVcsl9/MwL/LaWXgyxn4jT8r9/uPd+n76ssUzp23MP8hA7+dga9lOy0n" +
           "NNRN9u+VG89/zcDv5rQy8J8y8F/+rIT0jbv0ffMVC+nrGfiDDPx38Da6FVLd" +
           "NF8dOX0rAy8ey+l/ZOB/vppy2olNjRzhj+7+ZvH4STruZC/efuSCbdnp94s/" +
           "fsUy/b8Z+HYGvgPeQ2LBCF8Vce5dyMD+kTj3Mgb27nmVYtb+CVYjA5/KZ7zv" +
           "zvL+kxzhNd91kjw4ltPe5Qzcn4EHTlb2");
        java.lang.String jlc$ClassType$jl5$1 =
          ("iqX02tNSejADD736kX3v+15KNq9/JbJ5NAOPZeANr6Jsnjwtmzdl4IkkhF57" +
           "u/uPR07zlpd3hxLsUx+95dL29qKx9AvPXbn4yHPT38wrMceXgS/1oItqZJq7" +
           "F/x22hdcMIuRi+TStviSv1jv/Tngx3dnCewTDlvZGvbesh33NrCZvf04sAsD" +
           "cBf3HSF07VZcgHeGZjGEHjiNB3AA3MVBQ+jyCQ5IRdvGLkoVjAIoWRPL7ifm" +
           "or91S33tpbS+Uzl86o7vkf1oe+3+pvTJ52jmPS9WP7694Aj29Wn+2g9e1O7d" +
           "1sNyollt6Yk7UjuidYF667cf+NSlp49qkQ9sGT5xth3e3nT7ShVpuWFeW0p/" +
           "8ZF/9P1/77mv5pfs/h+C6s3xDTEAAA==");
    }
    public void setProperty(java.lang.String property,
                            java.lang.Object value) {
        
    }
    public javax.xml.transform.SourceLocator getSourceLocatorFor(int node) {
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1cC5QU1Zm+0zPTMwyPmUF5CMhz0IAwHSCoMGjCPIDBeYXh" +
       "FQg2NdU1M8VUV5VVt2caDKuYQ0RPcBPFBF8c42I0LirZxKyJq+LmpUddRM2a" +
       "aIwYd090jaucE0Miidn/v/d2V3V1VTXtzGbO6ds1de9/7/2++9///vfVR94j" +
       "5bZFZpuSnpDq6U5Tseu78LlLsmwl0aRJtr0e3sblG9+85ZrTL43aEyHRLWRc" +
       "v2S3y5KtrFIVLWFvIeeruk0lXVbsDkVJoESXpdiKNShR1dC3kAmq3Zo0NVVW" +
       "abuRUDDBRslqI7USpZbak6JKq8iAkhltrDYxVpvYSm+ChjYyRjbMnY7AlByB" +
       "Jlccpk065dmU1LTtkAalWIqqWqxNtWlD2iIXmYa2s08zaL2SpvU7tKWCiLVt" +
       "S/NomH20+o9nvtZfw2g4R9J1gzKI9jrFNrRBJdFGqp23LZqStK8i/0BK28ho" +
       "V2JK6toyhcag0BgUmsHrpILaj1X0VLLJYHBoJqeoKWOFKJmVm4kpWVJSZNPF" +
       "6gw5VFKBnQkD2plZtJnm9kC89aLYgW9eWfMvpaR6C6lW9W6sjgyVoFDIFiBU" +
       "SfYolr0ykVASW0itDg3erViqpKm7RGuPt9U+XaIpUIEMLfgyZSoWK9PhCloS" +
       "sFkpmRpWFl4vUyrxX3mvJvUB1okOVo5wFb4HgFUqVMzqlUD3hEjZgKonmB7l" +
       "SmQx1l0BCUC0IqnQfiNbVJkuwQsynquIJul9sW5QPr0PkpYboIIW07WATJFr" +
       "U5IHpD4lTslkb7ouHgWpRjEiUISSCd5kLCdopSmeVnK1z3sdK266Wl+jR0gJ" +
       "1DmhyBrWfzQITfcIrVN6FUuBfsAFx8xv+4Y08fF9EUIg8QRPYp7mX7906nML" +
       "ph97mqeZ6pOms2eHItO4fLhn3IlpTfOWlWI1Kk3DVrHxc5CzXtYlYhrSJlia" +
       "idkcMbI+E3ls3c++cO0DyrsRUtVKorKhpZKgR7WykTRVTbFWK7piSVRJtJJR" +
       "ip5oYvGtpAKe21Rd4W87e3tthbaSMo29ihrsf6CoF7JAiqrgWdV7jcyzKdF+" +
       "9pw2CSEV8CFj4NNI+B/7pqQv1m8klZgkS7qqG7Euy0D82KDM5ig2PCcg1jRi" +
       "aQmUZuGO+OL4JfHFMduSY4bVF5NAK/qVWDqpxRI0GbOU3ljCSC7G5+bO9sXN" +
       "69vrUeHMv19RaUR9zlBJCTTINK850KAnrTG0hGLF5QOpxpZTD8Wf5aqG3UPw" +
       "RckFUF49L68eyquHMuqhvHpRXr0oj5SUsGLOxXJ5m0OLDUDfB+M7Zl73trXb" +
       "980uBWUzh8qAbkx6Qd5g1OQYiYxlj8tHTqw7ffz5qgciJAJ2pAcGI2dEqMsZ" +
       "EfiAZhmykgCTFDQ2ZOxjLHg08K0HOXZwaM/Gaz7N6uE28phhOdgnFO9C05wt" +
       "os7buf3yrb7+7T8+/I3dhtPNc0aNzGCXJ4nWY7a3Ub3g4/L8mdIj8cd310VI" +
       "GZgkMMNUgm4DFm66t4wcK9KQsciIpRIA9xpWUtIwKmNGq2i/ZQw5b5i21bLn" +
       "c6GJR2G3qoHPoOhn7BtjJ5oYTuLaiTrjQcEs/mXd5l2//I93ljC6M4NDtWtU" +
       "71Zog8sgYWbjmempdVRwvaUokO71g1233Pre9VuZ/kGKOX4F1mHYBIYImhBo" +
       "3vv0Vb964zeHX444OkthRE71gHOTzoKMIKbKEJCo5059wKBp0NNRa+o26KCV" +
       "aq8q9WgKdpK/VM9d9Mjvb6rheqDBm4waLSicgfP+vEZy7bNXnp7OsimRcUB1" +
       "OHOScSt9jpPzSsuSdmI90ntePP+2n0t3gb0HG2uruxRmNqOMgyhDPpmS833M" +
       "ApiBdkmHwc/KpJrFrBBLQC1Jt1GJ0HKg1eg2UhaM5dhLXHYAvcbuVI9Nuyw1" +
       "CQ07KMa0hyeevuonFbuaM+OVnwhPeYXdfvxHa34XZ4pTifYC32OFxroswUqr" +
       "z6W1NbxB/wZ/JfD5GD/YkPiCjw7jm8QQNTM7RplmGmo/L8SpzIUQ2z3+jYE7" +
       "336QQ/CO4Z7Eyr4DN/6t/qYDXBu4ozMnz9dwy3Bnh8PBYAXWblZYKUxi1e8e" +
       "3v3Y/buv57Uanztst4BX+uB//vW5+oMnn/EZG0pV4awuwe6RNewTva3DIUUX" +
       "3fXna77yy06wRK2kMqWrV6WU1oQ7T/DU7FSPq7kcF4q9cIPDpqGkZD62gtC2" +
       "6f46ual7lapRRynnepIhUrt+c3sbdwJXSWhld7LUywSR+HW567mRkooew9AU" +
       "Sffix3/XpFlNP8PiYtkUhKUgLG49BnW2e4zI1R/X/CAuf+3lD8Zu/OCJU6wN" +
       "cicYbpPYLplcAWoxmIsKMMk7Hq+R7H5I95ljHV+s0Y6dgRy3QI4y9ES70wJn" +
       "IJ1jQEXq8opXn/rxxO0nSklkFanSDCnBWQKHDAYBxe4HPyJtfvZz3AYOVQrL" +
       "T9IkDzyanRn+Bq0laVJmgnY9Oun7K+479BtmeznjU5n4aBvnNV63gU1OnRHv" +
       "96/d8daTp/+pgmt0SP/0yE3+qFPrue63f8ojmQ3wPl3WI78lduTOKU2Xv8vk" +
       "nZEWpeek8x0w8EUc2cUPJD+MzI7+NEIqtpAaWUwEN0paCsevLTD5sTOzQ5gs" +
       "5sTnTmS4196Q9SSmeW2Gq1jvGO/uiGU0p9M5w3o1tuKF8GkWI16zd1hnfiDX" +
       "IaxSfSPvKM/PtK79xZ0f/S/TuPJBrDoMLCjC/YcLWDgPgwWssSMw3tpsTkqh" +
       "nqouaZ5xd1xILSgZtXbtFfHmlsYNq/FFB3c2MNyAQS/Pa3OgzsZzEX8KPi2i" +
       "rBYfxPjQxzr/VQFo8HEAAz8YQVlTMhphdLRsaupsbvEDYhUJpBM+raK01nwg" +
       "4Hv2U2ouj8WGhobqh5bU43QDbGNs0bJll8ZQQWywnEwzdn0SoEFFU1LbsbK9" +
       "pbtrZVMLtFpTW7yjO2Owaxxd4ibaQ8HVZ08BfsgM+LSLerTnUUDYw95Anaww" +
       "LXUQxn/QMObTqIpOPUDPCSkAdDkZB6c1Cw5Ho6ElMnOLOmCw9ID7ytmDq8K3" +
       "00UbZ9raD9zX/cEx9b3Bg2VUSH6UjE3GNcmmcXCagQZ82eCp/82foP7rRHnr" +
       "Aup/G68/BgfyaxskTUmVqO2AmvCr6u1F6tFM+GwShW0KqOrdIZ3kBgxu9NGd" +
       "oEzBICbjlmEwovd7av+ts689Kwgt2lZR0NaA2t/vX3viqXMkJCtKJoG+47zU" +
       "tpXEKtWyKa6WCm3xWrPvFNkEn4bPdlHy9gAQRz9JEwRlSsk5ybgO3dReaSld" +
       "GVh+UL579lBwNYrMh0+/KLU/AMqjAR0XbBFQTGHkVxIeMKNDsgVjJsCgU+Y7" +
       "p1onDbElybj81dl791xYcepi7lbN9E3tWr1ccvri6pkP3K/z5P5zPM+65W+v" +
       "fvYe49fvRiLCR16eP81uEEjYNyXK/8NCGswY+CjTBX5LZsXu71MQOuxT89xb" +
       "pwke+dG3L9m3YPM9nNNZAZ6tk/6Hnz954q5dDx/hUzecClNyUdCGRP4uCK4w" +
       "zQ1ZJXMa+8PVy4+989bGbZmWG4fBj7MTsxrH39+o4LwB3z/rP3Py9KIfFmnV" +
       "FhIS/TZPyr99etELzvDxz3mGLFCakspkfEjSBpyZ5AzfmSQuOm1i6TxYToRg" +
       "STt1mp+tE68I8SxVu+rkmhoRVJ7zg3YT2FT/8HUHDiU6712UaaUmdGEMc6Gm" +
       "DCqaK6sL2MKBVw3b2R6KM2W55MXTpa/dPHlM/ros5jQ9YNV1frA+eQv4+XX/" +
       "M2X95f3bi1hwneHB783yO+1Hnll9gXxzhG0D8RlS3vZRrlBD7ryoylJoytJz" +
       "lyRmZ1uMteYk+PxAtNgPvDro6ARr7MfyrXWQqGc1oYy1VVnWFWhwAlbIOyGr" +
       "D+9i8F9g/qVEIuNzNjiK+t+FOl3OhB5fbGOvT2bBjMWo86FTL+c58O8QHubn" +
       "2fpA0RBcH4bEncbgAzBGfQrtSOHWZmcvYrc94E8NGzzrutOg5qsFgtVFK0Gg" +
       "aDBAMQn1jyvFl38BE6ZDt8u0eIcD+q/DBo2TOzIBEHyR58C/i2rxQFEPMNd4" +
       "wVS9ZGwI8moMKkHVsdkF8P1Z4CWjhg28FqOmQq0HRO0Him7tQNFCwM8LAT4V" +
       "g3MpLtcZAynTB/uEYWNniedAxYcEgKHisQeJFsI+NwT7hRjMBF8dG11ofGsC" +
       "5hwq3Znb3UtmjYzmzwAEBwWSgwVIyJ+zBooGk7CfAV0UQsISDBZQUgskrIER" +
       "XFNWWUYy39yXLBwZcw8WL/KkwPFkAQp8On+QaCEKLguh4LMYXEpJdZYCbvM9" +
       "BCwbsfEu8r5A8X7xBASJevCVsnowg85G+z0sYHBbQ6i4AoNmPvxlz1r5cNEy" +
       "bC5w+kxmQRUX8Bz4d1FcBIoWMgobQhjYhEEXJeOAAT7xYuvnGWfeu3vk2RZy" +
       "GPr8yAwZoC2lCQEzUTxDQaKFGJJDGEJdKLmSkjGqvalfpc5Sr+MplMRHRj+a" +
       "oeoHBIQDIehZ6F21+TcMBjwLHeNDcvRgjjhZ7c80v/+u4CrJFrrSmOrtVSxG" +
       "kxlCIa5qleygZLRwN5olKrGEnu3DskFDTTisDozMUAxuSOljgoPHitepINFC" +
       "OrUnhJAvY/Alh5AOMZfa44DfPTLgYfwpfU4geK548EGihcDvDwH/jxjsgw7l" +
       "Ar/Zg/6GkUP/sYDwcfHog0QLob8tBP0dGBzg6NsMWdJ82v7WkUF/HsyExR5a" +
       "Wd72XEH0gaKF0N8bgv4+DO6mZBSg77KUXjXtgV5wwf7soIPnWSZOH5UFHLEK" +
       "gx4kWgj6d0Ogfw+DI9zt6shsGW5Y1+oh4MFhE8B2NOdC7Q8LFIcLEJDvegeK" +
       "FvI7Hw8h4EkMHqVkomb0qaj4MAdp7mxf75p8u+ZhBdc4z9oClB0XYI4XrwhB" +
       "ooUU4ZkQHp7F4CeO/WMOl0cLfjoy6JdD1T8SED4qHn2QaAi4X4TEvYLBC5TM" +
       "B+DNhpzC/S5cM2xWZA3PF6qG3r3TpkqSz0p7Vb5Y7KIlbLG4OFrKz+M58O+i" +
       "aAkUDYH+ZkjcWxj8OpSWLnbCMpCW10dmqgaOUvlKgW1l8bQEiQb3FT5Bey+E" +
       "m/cxeJtPT8QOaePOVr5R7eB/Z2TUog4qv1eA2Fs8/iDRQvj/HIL/DAZ/oORc" +
       "wL9BN9lWVAtbsckfOT4cmSkYjBzlTwkoTxXPQpBoAYsZKQ9mIVKBAQEWVDs7" +
       "S+82FRn7At9mzrIQKRk2C+yMdiNAeElAeal4FoJE/Vlg/8N066KAawWtumwx" +
       "3Ze07pWb+RlhRkxtCGkTMBhDoUyF+mWAKjPo8DZ22LzVYdRSAH1SgD9ZPG9B" +
       "oiE4Z4TEzcJgCl/tY3e4dLHild2tnIKUI9e2lK73ScK4mTpsbvBcCVkGwMR6" +
       "VnnxS2GBoiH4F4bExTD4FOemTUmjR+bhZrqbG9yZ9EnG+Jk3crpzRoA8Uzw/" +
       "QaIhHDSExF2GwcWcH25yxc09f93xScK4uWTY3MzEKNzCj/Ic+HdR3ASKhuAP" +
       "WTeN4LpppJmSseiyrG/26M1ENy+eaMbJ8JdTZ2PUIgBUK4DVFs9JkGgI7k0h" +
       "cV/AYB2f37VYlmF5WJmcoy3eBIyX7mHzMhejIFV0mgA3rXhegkRDsCshcXgw" +
       "NbKdu3Do0npomeo1Mt40jBlpZHwb6ErRCwW8C4tnJkg0BL0dEpfCQAeNwVvE" +
       "9vohY32/pUh8AdTl0RjDxn5eBvtSAWBpCHYW+h4J9C4u14TkGOLohNwfKZP7" +
       "xbEY38sjkWtD2Lweg12UVKh2d/4SfaTgeeiz8wuhU0TFce1ooRMMPhq0OkDU" +
       "g8uznRWZw8AwmF8PdyFzrAz4ei1pWTFxCsmEb8Hgq5AqodqmROX+JuBbkvEe" +
       "UMugwu8tuZ3C/SOzr4EGaadAHrYZ7qt6Qfsa0aGAHIO53J/lks857vbnEqMO" +
       "sAT3YHA7JTUZvjK7Fx6e7hgZ5WoHNEcFqqPFK1eQqAela6OHKxeDeqQQFw9h" +
       "cJ+Li/WGr87cPzJcXApAXhaAXi6eiyDRYC72ZLqQ62YFvzjE4D8aYnpQRSPf" +
       "o2S0javaBvulBw8r3x82K3iADs9DR98Q0N4onpUg0cC2Fx3lZyHgn8bgKX6s" +
       "hM8scVuDGtYqI/zKa05ih6l/L56pNFh9ceUeb9JNzvuRD/7DFPJDh6orJx3a" +
       "8Aq79p398YgxbaSyN6Vp7oterueomd2nGMOvfZkM9wn/u5WunwGAWoknrHfk" +
       "BS73snCQ8+UoKYXQnfYVSsbnp4V0njxfBfcqNx2kgdCd5nVKqpw0lET5gzvJ" +
       "SZCCJPj4pplpu/oAkEB2s9IrpTTaiMdcqcJuiNtpPhRlz99m2pUUPFjlOrI7" +
       "J+dALPtpl8zh1VSXOMf98KG1HVefuvhefhde1qRduzCX0W2kgl/LZ5mW5p0J" +
       "d+eWySu6Zt6ZcUdHzc0cAq7lFXY61FRH4ck26Bom6tkUz0Vxuy57X/xXh1c8" +
       "8fy+6IsRUrKVlEjQO7bm30dMmymLzNja5nczeKNksTvsDVVvbT/+p1dLxrNr" +
       "n4TfJZ4eJhGXb3nita5e07w9Qka1knJVTyhpdlmyeae+TpEHrZyLxtEeI6Vn" +
       "fwVmXIItOqt6H2NGEDo2+xYvd1AyO//Odf7vS1RpxpBiNWLumM1Yz5HhlGm6" +
       "Yxmz7FLiijQyDZoYb2s3zcxlc9ZTt5kmdvjIH/CfNf8HeInJMr9JAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/Kg9WpYVX/fbJDukWN2UG0y1Up6oPLlM");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
