package org.apache.xml.utils;
public class DOMHelper {
    public static org.w3c.dom.Document createDocument(boolean isSecureProcessing) {
        try {
            javax.xml.parsers.DocumentBuilderFactory dfactory =
              javax.xml.parsers.DocumentBuilderFactory.
              newInstance(
                );
            dfactory.
              setNamespaceAware(
                true);
            dfactory.
              setValidating(
                true);
            if (isSecureProcessing) {
                try {
                    dfactory.
                      setFeature(
                        javax.xml.XMLConstants.
                          FEATURE_SECURE_PROCESSING,
                        true);
                }
                catch (javax.xml.parsers.ParserConfigurationException pce) {
                    
                }
            }
            javax.xml.parsers.DocumentBuilder docBuilder =
              dfactory.
              newDocumentBuilder(
                );
            org.w3c.dom.Document outNode =
              docBuilder.
              newDocument(
                );
            return outNode;
        }
        catch (javax.xml.parsers.ParserConfigurationException pce) {
            throw new java.lang.RuntimeException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
                    ER_CREATEDOCUMENT_NOT_SUPPORTED,
                  null));
        }
    }
    public static org.w3c.dom.Document createDocument() { return createDocument(
                                                                   false);
    }
    public boolean shouldStripSourceNode(org.w3c.dom.Node textNode)
          throws javax.xml.transform.TransformerException { return false;
    }
    public java.lang.String getUniqueID(org.w3c.dom.Node node) { return "N" +
                                                                 java.lang.Integer.
                                                                   toHexString(
                                                                     node.
                                                                       hashCode(
                                                                         )).
                                                                   toUpperCase(
                                                                     );
    }
    public static boolean isNodeAfter(org.w3c.dom.Node node1,
                                      org.w3c.dom.Node node2) {
        if (node1 ==
              node2 ||
              isNodeTheSame(
                node1,
                node2))
            return true;
        boolean isNodeAfter =
          true;
        org.w3c.dom.Node parent1 =
          getParentOfNode(
            node1);
        org.w3c.dom.Node parent2 =
          getParentOfNode(
            node2);
        if (parent1 ==
              parent2 ||
              isNodeTheSame(
                parent1,
                parent2)) {
            if (null !=
                  parent1)
                isNodeAfter =
                  isNodeAfterSibling(
                    parent1,
                    node1,
                    node2);
            else {
                
            }
        }
        else {
            int nParents1 =
              2;
            int nParents2 =
              2;
            while (parent1 !=
                     null) {
                nParents1++;
                parent1 =
                  getParentOfNode(
                    parent1);
            }
            while (parent2 !=
                     null) {
                nParents2++;
                parent2 =
                  getParentOfNode(
                    parent2);
            }
            org.w3c.dom.Node startNode1 =
              node1;
            org.w3c.dom.Node startNode2 =
              node2;
            if (nParents1 <
                  nParents2) {
                int adjust =
                  nParents2 -
                  nParents1;
                for (int i =
                       0;
                     i <
                       adjust;
                     i++) {
                    startNode2 =
                      getParentOfNode(
                        startNode2);
                }
            }
            else
                if (nParents1 >
                      nParents2) {
                    int adjust =
                      nParents1 -
                      nParents2;
                    for (int i =
                           0;
                         i <
                           adjust;
                         i++) {
                        startNode1 =
                          getParentOfNode(
                            startNode1);
                    }
                }
            org.w3c.dom.Node prevChild1 =
              null;
            org.w3c.dom.Node prevChild2 =
              null;
            while (null !=
                     startNode1) {
                if (startNode1 ==
                      startNode2 ||
                      isNodeTheSame(
                        startNode1,
                        startNode2)) {
                    if (null ==
                          prevChild1) {
                        isNodeAfter =
                          nParents1 <
                            nParents2
                            ? true
                            : false;
                        break;
                    }
                    else {
                        isNodeAfter =
                          isNodeAfterSibling(
                            startNode1,
                            prevChild1,
                            prevChild2);
                        break;
                    }
                }
                prevChild1 =
                  startNode1;
                startNode1 =
                  getParentOfNode(
                    startNode1);
                prevChild2 =
                  startNode2;
                startNode2 =
                  getParentOfNode(
                    startNode2);
            }
        }
        return isNodeAfter;
    }
    public static boolean isNodeTheSame(org.w3c.dom.Node node1,
                                        org.w3c.dom.Node node2) {
        if (node1 instanceof org.apache.xml.dtm.ref.DTMNodeProxy &&
              node2 instanceof org.apache.xml.dtm.ref.DTMNodeProxy)
            return ((org.apache.xml.dtm.ref.DTMNodeProxy)
                      node1).
              equals(
                (org.apache.xml.dtm.ref.DTMNodeProxy)
                  node2);
        else
            return node1 ==
              node2;
    }
    private static boolean isNodeAfterSibling(org.w3c.dom.Node parent,
                                              org.w3c.dom.Node child1,
                                              org.w3c.dom.Node child2) {
        boolean isNodeAfterSibling =
          false;
        short child1type =
          child1.
          getNodeType(
            );
        short child2type =
          child2.
          getNodeType(
            );
        if (org.w3c.dom.Node.
              ATTRIBUTE_NODE !=
              child1type &&
              org.w3c.dom.Node.
                ATTRIBUTE_NODE ==
              child2type) {
            isNodeAfterSibling =
              false;
        }
        else
            if (org.w3c.dom.Node.
                  ATTRIBUTE_NODE ==
                  child1type &&
                  org.w3c.dom.Node.
                    ATTRIBUTE_NODE !=
                  child2type) {
                isNodeAfterSibling =
                  true;
            }
            else
                if (org.w3c.dom.Node.
                      ATTRIBUTE_NODE ==
                      child1type) {
                    org.w3c.dom.NamedNodeMap children =
                      parent.
                      getAttributes(
                        );
                    int nNodes =
                      children.
                      getLength(
                        );
                    boolean found1 =
                      false;
                    boolean found2 =
                      false;
                    for (int i =
                           0;
                         i <
                           nNodes;
                         i++) {
                        org.w3c.dom.Node child =
                          children.
                          item(
                            i);
                        if (child1 ==
                              child ||
                              isNodeTheSame(
                                child1,
                                child)) {
                            if (found2) {
                                isNodeAfterSibling =
                                  false;
                                break;
                            }
                            found1 =
                              true;
                        }
                        else
                            if (child2 ==
                                  child ||
                                  isNodeTheSame(
                                    child2,
                                    child)) {
                                if (found1) {
                                    isNodeAfterSibling =
                                      true;
                                    break;
                                }
                                found2 =
                                  true;
                            }
                    }
                }
                else {
                    org.w3c.dom.Node child =
                      parent.
                      getFirstChild(
                        );
                    boolean found1 =
                      false;
                    boolean found2 =
                      false;
                    while (null !=
                             child) {
                        if (child1 ==
                              child ||
                              isNodeTheSame(
                                child1,
                                child)) {
                            if (found2) {
                                isNodeAfterSibling =
                                  false;
                                break;
                            }
                            found1 =
                              true;
                        }
                        else
                            if (child2 ==
                                  child ||
                                  isNodeTheSame(
                                    child2,
                                    child)) {
                                if (found1) {
                                    isNodeAfterSibling =
                                      true;
                                    break;
                                }
                                found2 =
                                  true;
                            }
                        child =
                          child.
                            getNextSibling(
                              );
                    }
                }
        return isNodeAfterSibling;
    }
    public short getLevel(org.w3c.dom.Node n) { short level =
                                                  1;
                                                while (null !=
                                                         (n =
                                                            getParentOfNode(
                                                              n))) {
                                                    level++;
                                                }
                                                return level;
    }
    public java.lang.String getNamespaceForPrefix(java.lang.String prefix,
                                                  org.w3c.dom.Element namespaceContext) {
        int type;
        org.w3c.dom.Node parent =
          namespaceContext;
        java.lang.String namespace =
          null;
        if (prefix.
              equals(
                "xml")) {
            namespace =
              org.apache.xml.utils.QName.
                S_XMLNAMESPACEURI;
        }
        else
            if (prefix.
                  equals(
                    "xmlns")) {
                namespace =
                  "http://www.w3.org/2000/xmlns/";
            }
            else {
                java.lang.String declname =
                  prefix ==
                  ""
                  ? "xmlns"
                  : "xmlns:" +
                prefix;
                while (null !=
                         parent &&
                         null ==
                         namespace &&
                         ((type =
                             parent.
                               getNodeType(
                                 )) ==
                            org.w3c.dom.Node.
                              ELEMENT_NODE ||
                            type ==
                            org.w3c.dom.Node.
                              ENTITY_REFERENCE_NODE)) {
                    if (type ==
                          org.w3c.dom.Node.
                            ELEMENT_NODE) {
                        org.w3c.dom.Attr attr =
                          ((org.w3c.dom.Element)
                             parent).
                          getAttributeNode(
                            declname);
                        if (attr !=
                              null) {
                            namespace =
                              attr.
                                getNodeValue(
                                  );
                            break;
                        }
                    }
                    parent =
                      getParentOfNode(
                        parent);
                }
            }
        return namespace;
    }
    java.util.Hashtable m_NSInfos = new java.util.Hashtable(
      );
    protected static final org.apache.xml.utils.NSInfo
      m_NSInfoUnProcWithXMLNS =
      new org.apache.xml.utils.NSInfo(
      false,
      true);
    protected static final org.apache.xml.utils.NSInfo
      m_NSInfoUnProcWithoutXMLNS =
      new org.apache.xml.utils.NSInfo(
      false,
      false);
    protected static final org.apache.xml.utils.NSInfo
      m_NSInfoUnProcNoAncestorXMLNS =
      new org.apache.xml.utils.NSInfo(
      false,
      false,
      org.apache.xml.utils.NSInfo.
        ANCESTORNOXMLNS);
    protected static final org.apache.xml.utils.NSInfo
      m_NSInfoNullWithXMLNS =
      new org.apache.xml.utils.NSInfo(
      true,
      true);
    protected static final org.apache.xml.utils.NSInfo
      m_NSInfoNullWithoutXMLNS =
      new org.apache.xml.utils.NSInfo(
      true,
      false);
    protected static final org.apache.xml.utils.NSInfo
      m_NSInfoNullNoAncestorXMLNS =
      new org.apache.xml.utils.NSInfo(
      true,
      false,
      org.apache.xml.utils.NSInfo.
        ANCESTORNOXMLNS);
    protected java.util.Vector m_candidateNoAncestorXMLNS =
      new java.util.Vector(
      );
    public java.lang.String getNamespaceOfNode(org.w3c.dom.Node n) {
        java.lang.String namespaceOfPrefix;
        boolean hasProcessedNS;
        org.apache.xml.utils.NSInfo nsInfo;
        short ntype =
          n.
          getNodeType(
            );
        if (org.w3c.dom.Node.
              ATTRIBUTE_NODE !=
              ntype) {
            java.lang.Object nsObj =
              m_NSInfos.
              get(
                n);
            nsInfo =
              nsObj ==
                null
                ? null
                : (org.apache.xml.utils.NSInfo)
                    nsObj;
            hasProcessedNS =
              nsInfo ==
                null
                ? false
                : nsInfo.
                    m_hasProcessedNS;
        }
        else {
            hasProcessedNS =
              false;
            nsInfo =
              null;
        }
        if (hasProcessedNS) {
            namespaceOfPrefix =
              nsInfo.
                m_namespace;
        }
        else {
            namespaceOfPrefix =
              null;
            java.lang.String nodeName =
              n.
              getNodeName(
                );
            int indexOfNSSep =
              nodeName.
              indexOf(
                ':');
            java.lang.String prefix;
            if (org.w3c.dom.Node.
                  ATTRIBUTE_NODE ==
                  ntype) {
                if (indexOfNSSep >
                      0) {
                    prefix =
                      nodeName.
                        substring(
                          0,
                          indexOfNSSep);
                }
                else {
                    return namespaceOfPrefix;
                }
            }
            else {
                prefix =
                  indexOfNSSep >=
                    0
                    ? nodeName.
                    substring(
                      0,
                      indexOfNSSep)
                    : "";
            }
            boolean ancestorsHaveXMLNS =
              false;
            boolean nHasXMLNS =
              false;
            if (prefix.
                  equals(
                    "xml")) {
                namespaceOfPrefix =
                  org.apache.xml.utils.QName.
                    S_XMLNAMESPACEURI;
            }
            else {
                int parentType;
                org.w3c.dom.Node parent =
                  n;
                while (null !=
                         parent &&
                         null ==
                         namespaceOfPrefix) {
                    if (null !=
                          nsInfo &&
                          nsInfo.
                            m_ancestorHasXMLNSAttrs ==
                          org.apache.xml.utils.NSInfo.
                            ANCESTORNOXMLNS) {
                        break;
                    }
                    parentType =
                      parent.
                        getNodeType(
                          );
                    if (null ==
                          nsInfo ||
                          nsInfo.
                            m_hasXMLNSAttrs) {
                        boolean elementHasXMLNS =
                          false;
                        if (parentType ==
                              org.w3c.dom.Node.
                                ELEMENT_NODE) {
                            org.w3c.dom.NamedNodeMap nnm =
                              parent.
                              getAttributes(
                                );
                            for (int i =
                                   0;
                                 i <
                                   nnm.
                                   getLength(
                                     );
                                 i++) {
                                org.w3c.dom.Node attr =
                                  nnm.
                                  item(
                                    i);
                                java.lang.String aname =
                                  attr.
                                  getNodeName(
                                    );
                                if (aname.
                                      charAt(
                                        0) ==
                                      'x') {
                                    boolean isPrefix =
                                      aname.
                                      startsWith(
                                        "xmlns:");
                                    if (aname.
                                          equals(
                                            "xmlns") ||
                                          isPrefix) {
                                        if (n ==
                                              parent)
                                            nHasXMLNS =
                                              true;
                                        elementHasXMLNS =
                                          true;
                                        ancestorsHaveXMLNS =
                                          true;
                                        java.lang.String p =
                                          isPrefix
                                          ? aname.
                                          substring(
                                            6)
                                          : "";
                                        if (p.
                                              equals(
                                                prefix)) {
                                            namespaceOfPrefix =
                                              attr.
                                                getNodeValue(
                                                  );
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        if (org.w3c.dom.Node.
                              ATTRIBUTE_NODE !=
                              parentType &&
                              null ==
                              nsInfo &&
                              n !=
                              parent) {
                            nsInfo =
                              elementHasXMLNS
                                ? m_NSInfoUnProcWithXMLNS
                                : m_NSInfoUnProcWithoutXMLNS;
                            m_NSInfos.
                              put(
                                parent,
                                nsInfo);
                        }
                    }
                    if (org.w3c.dom.Node.
                          ATTRIBUTE_NODE ==
                          parentType) {
                        parent =
                          getParentOfNode(
                            parent);
                    }
                    else {
                        m_candidateNoAncestorXMLNS.
                          addElement(
                            parent);
                        m_candidateNoAncestorXMLNS.
                          addElement(
                            nsInfo);
                        parent =
                          parent.
                            getParentNode(
                              );
                    }
                    if (null !=
                          parent) {
                        java.lang.Object nsObj =
                          m_NSInfos.
                          get(
                            parent);
                        nsInfo =
                          nsObj ==
                            null
                            ? null
                            : (org.apache.xml.utils.NSInfo)
                                nsObj;
                    }
                }
                int nCandidates =
                  m_candidateNoAncestorXMLNS.
                  size(
                    );
                if (nCandidates >
                      0) {
                    if (false ==
                          ancestorsHaveXMLNS &&
                          null ==
                          parent) {
                        for (int i =
                               0;
                             i <
                               nCandidates;
                             i +=
                               2) {
                            java.lang.Object candidateInfo =
                              m_candidateNoAncestorXMLNS.
                              elementAt(
                                i +
                                  1);
                            if (candidateInfo ==
                                  m_NSInfoUnProcWithoutXMLNS) {
                                m_NSInfos.
                                  put(
                                    m_candidateNoAncestorXMLNS.
                                      elementAt(
                                        i),
                                    m_NSInfoUnProcNoAncestorXMLNS);
                            }
                            else
                                if (candidateInfo ==
                                      m_NSInfoNullWithoutXMLNS) {
                                    m_NSInfos.
                                      put(
                                        m_candidateNoAncestorXMLNS.
                                          elementAt(
                                            i),
                                        m_NSInfoNullNoAncestorXMLNS);
                                }
                        }
                    }
                    m_candidateNoAncestorXMLNS.
                      removeAllElements(
                        );
                }
            }
            if (org.w3c.dom.Node.
                  ATTRIBUTE_NODE !=
                  ntype) {
                if (null ==
                      namespaceOfPrefix) {
                    if (ancestorsHaveXMLNS) {
                        if (nHasXMLNS)
                            m_NSInfos.
                              put(
                                n,
                                m_NSInfoNullWithXMLNS);
                        else
                            m_NSInfos.
                              put(
                                n,
                                m_NSInfoNullWithoutXMLNS);
                    }
                    else {
                        m_NSInfos.
                          put(
                            n,
                            m_NSInfoNullNoAncestorXMLNS);
                    }
                }
                else {
                    m_NSInfos.
                      put(
                        n,
                        new org.apache.xml.utils.NSInfo(
                          namespaceOfPrefix,
                          nHasXMLNS));
                }
            }
        }
        return namespaceOfPrefix;
    }
    public java.lang.String getLocalNameOfNode(org.w3c.dom.Node n) {
        java.lang.String qname =
          n.
          getNodeName(
            );
        int index =
          qname.
          indexOf(
            ':');
        return index <
          0
          ? qname
          : qname.
          substring(
            index +
              1);
    }
    public java.lang.String getExpandedElementName(org.w3c.dom.Element elem) {
        java.lang.String namespace =
          getNamespaceOfNode(
            elem);
        return null !=
          namespace
          ? namespace +
        ":" +
        getLocalNameOfNode(
          elem)
          : getLocalNameOfNode(
              elem);
    }
    public java.lang.String getExpandedAttributeName(org.w3c.dom.Attr attr) {
        java.lang.String namespace =
          getNamespaceOfNode(
            attr);
        return null !=
          namespace
          ? namespace +
        ":" +
        getLocalNameOfNode(
          attr)
          : getLocalNameOfNode(
              attr);
    }
    public boolean isIgnorableWhitespace(org.w3c.dom.Text node) {
        boolean isIgnorable =
          false;
        return isIgnorable;
    }
    public org.w3c.dom.Node getRoot(org.w3c.dom.Node node) {
        org.w3c.dom.Node root =
          null;
        while (node !=
                 null) {
            root =
              node;
            node =
              getParentOfNode(
                node);
        }
        return root;
    }
    public org.w3c.dom.Node getRootNode(org.w3c.dom.Node n) {
        int nt =
          n.
          getNodeType(
            );
        return org.w3c.dom.Node.
                 DOCUMENT_NODE ==
          nt ||
          org.w3c.dom.Node.
            DOCUMENT_FRAGMENT_NODE ==
          nt
          ? n
          : n.
          getOwnerDocument(
            );
    }
    public boolean isNamespaceNode(org.w3c.dom.Node n) {
        if (org.w3c.dom.Node.
              ATTRIBUTE_NODE ==
              n.
              getNodeType(
                )) {
            java.lang.String attrName =
              n.
              getNodeName(
                );
            return attrName.
              startsWith(
                "xmlns:") ||
              attrName.
              equals(
                "xmlns");
        }
        return false;
    }
    public static org.w3c.dom.Node getParentOfNode(org.w3c.dom.Node node)
          throws java.lang.RuntimeException { org.w3c.dom.Node parent;
                                              short nodeType =
                                                node.
                                                getNodeType(
                                                  );
                                              if (org.w3c.dom.Node.
                                                    ATTRIBUTE_NODE ==
                                                    nodeType) {
                                                  org.w3c.dom.Document doc =
                                                    node.
                                                    getOwnerDocument(
                                                      );
                                                  org.w3c.dom.DOMImplementation impl =
                                                    doc.
                                                    getImplementation(
                                                      );
                                                  if (impl !=
                                                        null &&
                                                        impl.
                                                        hasFeature(
                                                          "Core",
                                                          "2.0")) {
                                                      parent =
                                                        ((org.w3c.dom.Attr)
                                                           node).
                                                          getOwnerElement(
                                                            );
                                                      return parent;
                                                  }
                                                  org.w3c.dom.Element rootElem =
                                                    doc.
                                                    getDocumentElement(
                                                      );
                                                  if (null ==
                                                        rootElem) {
                                                      throw new java.lang.RuntimeException(
                                                        org.apache.xml.res.XMLMessages.
                                                          createXMLMessage(
                                                            org.apache.xml.res.XMLErrorResources.
                                                              ER_CHILD_HAS_NO_OWNER_DOCUMENT_ELEMENT,
                                                            null));
                                                  }
                                                  parent =
                                                    locateAttrParent(
                                                      rootElem,
                                                      node);
                                              }
                                              else {
                                                  parent =
                                                    node.
                                                      getParentNode(
                                                        );
                                              }
                                              return parent;
    }
    public org.w3c.dom.Element getElementByID(java.lang.String id,
                                              org.w3c.dom.Document doc) {
        return null;
    }
    public java.lang.String getUnparsedEntityURI(java.lang.String name,
                                                 org.w3c.dom.Document doc) {
        java.lang.String url =
          "";
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
        return url;
    }
    private static org.w3c.dom.Node locateAttrParent(org.w3c.dom.Element elem,
                                                     org.w3c.dom.Node attr) {
        org.w3c.dom.Node parent =
          null;
        org.w3c.dom.Attr check =
          elem.
          getAttributeNode(
            attr.
              getNodeName(
                ));
        if (check ==
              attr)
            parent =
              elem;
        if (null ==
              parent) {
            for (org.w3c.dom.Node node =
                   elem.
                   getFirstChild(
                     );
                 null !=
                   node;
                 node =
                   node.
                     getNextSibling(
                       )) {
                if (org.w3c.dom.Node.
                      ELEMENT_NODE ==
                      node.
                      getNodeType(
                        )) {
                    parent =
                      locateAttrParent(
                        (org.w3c.dom.Element)
                          node,
                        attr);
                    if (null !=
                          parent)
                        break;
                }
            }
        }
        return parent;
    }
    protected org.w3c.dom.Document m_DOMFactory =
      null;
    public void setDOMFactory(org.w3c.dom.Document domFactory) {
        this.
          m_DOMFactory =
          domFactory;
    }
    public org.w3c.dom.Document getDOMFactory() {
        if (null ==
              this.
                m_DOMFactory) {
            this.
              m_DOMFactory =
              createDocument(
                );
        }
        return this.
                 m_DOMFactory;
    }
    public static java.lang.String getNodeData(org.w3c.dom.Node node) {
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
        return s;
    }
    public static void getNodeData(org.w3c.dom.Node node,
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
                buf.
                  append(
                    node.
                      getNodeValue(
                        ));
                break;
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
    public DOMHelper() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "pFKUL3WiDSEI4tH1aE0BghHXxURrS0cwy0hd7isJPBfcXvD9lfhmSH70cFPt" +
       "gsOb/pWf1M991zM3TmpTGVX1Hlv13FcbuT2bueIQKz/3FnVej/thYaSKX3G0" +
       "0QWi7SIIwfltGamA0tumg5F6tw0j1eLG2+QyoIImeNtpOHPjeRUgTu1mRZKU" +
       "e13uYEtaZ8LW84Z9ad7LTv7dm/PiNDNsn5A8dvi2wTvPrv66+MpAVqXdu5HL" +
       "nDipEd8ycKYVBactvdwcXtUbV5xv/FbdMuflZN5XDt6x8SkHm+VfBCz0Hbu3" +
       "unKn7186ctOTz+2rfiFKIltJRGJk/tbC881ZI2OSxVvjxY5NbpZM/kVAT/2b" +
       "257/3cuRFn6MnIhXyR1hFAl5/5OvDKcM40tRUtdPqhRY0mf54eu+aW2EyjvN" +
       "vFOY1RN6Rst9IteIaimhUXFkbEAbck/xYBsjnYUviAs/yqlX9V3UXIfckU2D" +
       "78V9xjC8tRzZ20WwQ6RB1xLxAcNwvss4xJE3DDS66HX4T+L/ARjw2KzcOgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "TWRCqE2kPqcVz9TYXmfICBktyWbNajJW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "kMhERwAA");
}
