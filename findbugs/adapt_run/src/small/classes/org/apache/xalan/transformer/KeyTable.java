package org.apache.xalan.transformer;
public class KeyTable {
    private int m_docKey;
    private java.util.Vector m_keyDeclarations;
    private java.util.Hashtable m_refsTable = null;
    public int getDocKey() { return m_docKey; }
    private org.apache.xpath.objects.XNodeSet m_keyNodes;
    org.apache.xalan.transformer.KeyIterator getKeyIterator() { return (org.apache.xalan.transformer.KeyIterator)
                                                                         m_keyNodes.
                                                                         getContainedIter(
                                                                           );
    }
    public KeyTable(int doc, org.apache.xml.utils.PrefixResolver nscontext,
                    org.apache.xml.utils.QName name,
                    java.util.Vector keyDeclarations,
                    org.apache.xpath.XPathContext xctxt)
          throws javax.xml.transform.TransformerException {
        super(
          );
        m_docKey =
          doc;
        m_keyDeclarations =
          keyDeclarations;
        org.apache.xalan.transformer.KeyIterator ki =
          new org.apache.xalan.transformer.KeyIterator(
          name,
          keyDeclarations);
        m_keyNodes =
          new org.apache.xpath.objects.XNodeSet(
            ki);
        m_keyNodes.
          allowDetachToRelease(
            false);
        m_keyNodes.
          setRoot(
            doc,
            xctxt);
    }
    public org.apache.xpath.objects.XNodeSet getNodeSetDTMByKey(org.apache.xml.utils.QName name,
                                                                org.apache.xml.utils.XMLString ref) {
        org.apache.xpath.objects.XNodeSet refNodes =
          (org.apache.xpath.objects.XNodeSet)
            getRefsTable(
              ).
            get(
              ref);
        try {
            if (refNodes !=
                  null) {
                refNodes =
                  (org.apache.xpath.objects.XNodeSet)
                    refNodes.
                    cloneWithReset(
                      );
            }
        }
        catch (java.lang.CloneNotSupportedException e) {
            refNodes =
              null;
        }
        if (refNodes ==
              null) {
            org.apache.xalan.transformer.KeyIterator ki =
              (org.apache.xalan.transformer.KeyIterator)
                m_keyNodes.
                getContainedIter(
                  );
            org.apache.xpath.XPathContext xctxt =
              ki.
              getXPathContext(
                );
            refNodes =
              new org.apache.xpath.objects.XNodeSet(
                xctxt.
                  getDTMManager(
                    )) {
                  public void setRoot(int nodeHandle,
                                      java.lang.Object environment) {
                      
                  }
              };
            refNodes.
              reset(
                );
        }
        return refNodes;
    }
    public org.apache.xml.utils.QName getKeyTableName() {
        return getKeyIterator(
                 ).
          getName(
            );
    }
    private java.util.Vector getKeyDeclarations() {
        int nDeclarations =
          m_keyDeclarations.
          size(
            );
        java.util.Vector keyDecls =
          new java.util.Vector(
          nDeclarations);
        for (int i =
               0;
             i <
               nDeclarations;
             i++) {
            org.apache.xalan.templates.KeyDeclaration kd =
              (org.apache.xalan.templates.KeyDeclaration)
                m_keyDeclarations.
                elementAt(
                  i);
            if (kd.
                  getName(
                    ).
                  equals(
                    getKeyTableName(
                      ))) {
                keyDecls.
                  add(
                    kd);
            }
        }
        return keyDecls;
    }
    private java.util.Hashtable getRefsTable() {
        if (m_refsTable ==
              null) {
            m_refsTable =
              new java.util.Hashtable(
                89);
            org.apache.xalan.transformer.KeyIterator ki =
              (org.apache.xalan.transformer.KeyIterator)
                m_keyNodes.
                getContainedIter(
                  );
            org.apache.xpath.XPathContext xctxt =
              ki.
              getXPathContext(
                );
            java.util.Vector keyDecls =
              getKeyDeclarations(
                );
            int nKeyDecls =
              keyDecls.
              size(
                );
            int currentNode;
            m_keyNodes.
              reset(
                );
            while (org.apache.xml.dtm.DTM.
                     NULL !=
                     (currentNode =
                        m_keyNodes.
                          nextNode(
                            ))) {
                try {
                    for (int keyDeclIdx =
                           0;
                         keyDeclIdx <
                           nKeyDecls;
                         keyDeclIdx++) {
                        org.apache.xalan.templates.KeyDeclaration keyDeclaration =
                          (org.apache.xalan.templates.KeyDeclaration)
                            keyDecls.
                            elementAt(
                              keyDeclIdx);
                        org.apache.xpath.objects.XObject xuse =
                          keyDeclaration.
                          getUse(
                            ).
                          execute(
                            xctxt,
                            currentNode,
                            ki.
                              getPrefixResolver(
                                ));
                        if (xuse.
                              getType(
                                ) !=
                              xuse.
                                CLASS_NODESET) {
                            org.apache.xml.utils.XMLString exprResult =
                              xuse.
                              xstr(
                                );
                            addValueInRefsTable(
                              xctxt,
                              exprResult,
                              currentNode);
                        }
                        else {
                            org.apache.xml.dtm.DTMIterator i =
                              ((org.apache.xpath.objects.XNodeSet)
                                 xuse).
                              iterRaw(
                                );
                            int currentNodeInUseClause;
                            while (org.apache.xml.dtm.DTM.
                                     NULL !=
                                     (currentNodeInUseClause =
                                        i.
                                          nextNode(
                                            ))) {
                                org.apache.xml.dtm.DTM dtm =
                                  xctxt.
                                  getDTM(
                                    currentNodeInUseClause);
                                org.apache.xml.utils.XMLString exprResult =
                                  dtm.
                                  getStringValue(
                                    currentNodeInUseClause);
                                addValueInRefsTable(
                                  xctxt,
                                  exprResult,
                                  currentNode);
                            }
                        }
                    }
                }
                catch (javax.xml.transform.TransformerException te) {
                    throw new org.apache.xml.utils.WrappedRuntimeException(
                      te);
                }
            }
        }
        return m_refsTable;
    }
    private void addValueInRefsTable(org.apache.xpath.XPathContext xctxt,
                                     org.apache.xml.utils.XMLString ref,
                                     int node) {
        org.apache.xpath.objects.XNodeSet nodes =
          (org.apache.xpath.objects.XNodeSet)
            m_refsTable.
            get(
              ref);
        if (nodes ==
              null) {
            nodes =
              new org.apache.xpath.objects.XNodeSet(
                node,
                xctxt.
                  getDTMManager(
                    ));
            nodes.
              nextNode(
                );
            m_refsTable.
              put(
                ref,
                nodes);
        }
        else {
            if (nodes.
                  getCurrentNode(
                    ) !=
                  node) {
                nodes.
                  mutableNodeset(
                    ).
                  addNode(
                    node);
                nodes.
                  nextNode(
                    );
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "IM94g4aBuzAwE3+s/i/Zz4eZXSMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "SX9ZJN+KoUcVTSuPnPveaV2dPbRJfVM7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("1sS334wmshi6crgOi8s977zt+u3+yqj6S69eu/L4q9P/VF4JO7rWeT8DXVkl" +
       "jnPyJPtE/nJQ3lMpKffn2kHxd+FyDD15nieIoQdOvBVMX7i0b3l/DF0/2zKG" +
       "LpX/J+kejKGrx3QxdHmfOUlyLYbuASRF9npwh6O//dF+duF0jHWk5kfeSM0n" +
       "wrLnTgVT5UXow8An4Q8u33z+1QH3o99sfXZ/dw1gRp4XvVxhoPv21+iOgqdn" +
       "79rbYV+X6fd+56Ffvv/5w0DvoT3Dx1Z8grd33fmiGOkGcXm1K/+1x//5B37h" +
       "1a+UJ5H/D9tuJQyhLgAA");
}
