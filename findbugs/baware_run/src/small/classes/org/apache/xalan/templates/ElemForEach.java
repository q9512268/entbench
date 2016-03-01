package org.apache.xalan.templates;
public class ElemForEach extends org.apache.xalan.templates.ElemTemplateElement implements org.apache.xpath.ExpressionOwner {
    static final long serialVersionUID = 6018140636363583690L;
    static final boolean DEBUG = false;
    public boolean m_doc_cache_off = false;
    public ElemForEach() { super(); }
    protected org.apache.xpath.Expression m_selectExpression = null;
    protected org.apache.xpath.XPath m_xpath = null;
    public void setSelect(org.apache.xpath.XPath xpath) { m_selectExpression =
                                                            xpath.
                                                              getExpression(
                                                                );
                                                          m_xpath = xpath;
    }
    public org.apache.xpath.Expression getSelect() { return m_selectExpression;
    }
    public void compose(org.apache.xalan.templates.StylesheetRoot sroot) throws javax.xml.transform.TransformerException {
        super.
          compose(
            sroot);
        int length =
          getSortElemCount(
            );
        for (int i =
               0;
             i <
               length;
             i++) {
            getSortElem(
              i).
              compose(
                sroot);
        }
        java.util.Vector vnames =
          sroot.
          getComposeState(
            ).
          getVariableNames(
            );
        if (null !=
              m_selectExpression)
            m_selectExpression.
              fixupVariables(
                vnames,
                sroot.
                  getComposeState(
                    ).
                  getGlobalsSize(
                    ));
        else {
            m_selectExpression =
              getStylesheetRoot(
                ).
                m_selectDefault.
                getExpression(
                  );
        }
    }
    public void endCompose(org.apache.xalan.templates.StylesheetRoot sroot)
          throws javax.xml.transform.TransformerException { int length =
                                                              getSortElemCount(
                                                                );
                                                            for (int i =
                                                                   0;
                                                                 i <
                                                                   length;
                                                                 i++) {
                                                                getSortElem(
                                                                  i).
                                                                  endCompose(
                                                                    sroot);
                                                            }
                                                            super.
                                                              endCompose(
                                                                sroot);
    }
    protected java.util.Vector m_sortElems = null;
    public int getSortElemCount() { return m_sortElems == null ? 0
                                      : m_sortElems.
                                      size(
                                        ); }
    public org.apache.xalan.templates.ElemSort getSortElem(int i) {
        return (org.apache.xalan.templates.ElemSort)
                 m_sortElems.
                 elementAt(
                   i);
    }
    public void setSortElem(org.apache.xalan.templates.ElemSort sortElem) {
        if (null ==
              m_sortElems)
            m_sortElems =
              new java.util.Vector(
                );
        m_sortElems.
          addElement(
            sortElem);
    }
    public int getXSLToken() { return org.apache.xalan.templates.Constants.
                                        ELEMNAME_FOREACH; }
    public java.lang.String getNodeName() { return org.apache.xalan.templates.Constants.
                                                     ELEMNAME_FOREACH_STRING;
    }
    public void execute(org.apache.xalan.transformer.TransformerImpl transformer)
          throws javax.xml.transform.TransformerException {
        transformer.
          pushCurrentTemplateRuleIsNull(
            true);
        if (transformer.
              getDebug(
                ))
            transformer.
              getTraceManager(
                ).
              fireTraceEvent(
                this);
        try {
            transformSelectedNodes(
              transformer);
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
            transformer.
              popCurrentTemplateRuleIsNull(
                );
        }
    }
    protected org.apache.xalan.templates.ElemTemplateElement getTemplateMatch() {
        return this;
    }
    public org.apache.xml.dtm.DTMIterator sortNodes(org.apache.xpath.XPathContext xctxt,
                                                    java.util.Vector keys,
                                                    org.apache.xml.dtm.DTMIterator sourceNodes)
          throws javax.xml.transform.TransformerException {
        org.apache.xalan.transformer.NodeSorter sorter =
          new org.apache.xalan.transformer.NodeSorter(
          xctxt);
        sourceNodes.
          setShouldCacheNodes(
            true);
        sourceNodes.
          runTo(
            -1);
        xctxt.
          pushContextNodeList(
            sourceNodes);
        try {
            sorter.
              sort(
                sourceNodes,
                keys,
                xctxt);
            sourceNodes.
              setCurrentPos(
                0);
        }
        finally {
            xctxt.
              popContextNodeList(
                );
        }
        return sourceNodes;
    }
    public void transformSelectedNodes(org.apache.xalan.transformer.TransformerImpl transformer)
          throws javax.xml.transform.TransformerException {
        final org.apache.xpath.XPathContext xctxt =
          transformer.
          getXPathContext(
            );
        final int sourceNode =
          xctxt.
          getCurrentNode(
            );
        org.apache.xml.dtm.DTMIterator sourceNodes =
          m_selectExpression.
          asIterator(
            xctxt,
            sourceNode);
        try {
            final java.util.Vector keys =
              m_sortElems ==
              null
              ? null
              : transformer.
              processSortKeys(
                this,
                sourceNode);
            if (null !=
                  keys)
                sourceNodes =
                  sortNodes(
                    xctxt,
                    keys,
                    sourceNodes);
            if (transformer.
                  getDebug(
                    )) {
                org.apache.xpath.Expression expr =
                  m_xpath.
                  getExpression(
                    );
                org.apache.xpath.objects.XObject xObject =
                  expr.
                  execute(
                    xctxt);
                int current =
                  xctxt.
                  getCurrentNode(
                    );
                transformer.
                  getTraceManager(
                    ).
                  fireSelectedEvent(
                    current,
                    this,
                    "select",
                    m_xpath,
                    xObject);
            }
            xctxt.
              pushCurrentNode(
                org.apache.xml.dtm.DTM.
                  NULL);
            org.apache.xml.utils.IntStack currentNodes =
              xctxt.
              getCurrentNodeStack(
                );
            xctxt.
              pushCurrentExpressionNode(
                org.apache.xml.dtm.DTM.
                  NULL);
            org.apache.xml.utils.IntStack currentExpressionNodes =
              xctxt.
              getCurrentExpressionNodeStack(
                );
            xctxt.
              pushSAXLocatorNull(
                );
            xctxt.
              pushContextNodeList(
                sourceNodes);
            transformer.
              pushElemTemplateElement(
                null);
            org.apache.xml.dtm.DTM dtm =
              xctxt.
              getDTM(
                sourceNode);
            int docID =
              sourceNode &
              org.apache.xml.dtm.DTMManager.
                IDENT_DTM_DEFAULT;
            int child;
            while (org.apache.xml.dtm.DTM.
                     NULL !=
                     (child =
                        sourceNodes.
                          nextNode(
                            ))) {
                currentNodes.
                  setTop(
                    child);
                currentExpressionNodes.
                  setTop(
                    child);
                if ((child &
                       org.apache.xml.dtm.DTMManager.
                         IDENT_DTM_DEFAULT) !=
                      docID) {
                    dtm =
                      xctxt.
                        getDTM(
                          child);
                    docID =
                      child &
                        org.apache.xml.dtm.DTMManager.
                          IDENT_DTM_DEFAULT;
                }
                final int nodeType =
                  dtm.
                  getNodeType(
                    child);
                if (transformer.
                      getDebug(
                        )) {
                    transformer.
                      getTraceManager(
                        ).
                      fireTraceEvent(
                        this);
                }
                for (org.apache.xalan.templates.ElemTemplateElement t =
                       this.
                         m_firstChild;
                     t !=
                       null;
                     t =
                       t.
                         m_nextSibling) {
                    xctxt.
                      setSAXLocator(
                        t);
                    transformer.
                      setCurrentElement(
                        t);
                    t.
                      execute(
                        transformer);
                }
                if (transformer.
                      getDebug(
                        )) {
                    transformer.
                      setCurrentElement(
                        null);
                    transformer.
                      getTraceManager(
                        ).
                      fireTraceEndEvent(
                        this);
                }
                if (m_doc_cache_off) {
                    if (DEBUG)
                        java.lang.System.
                          out.
                          println(
                            "JJK***** CACHE RELEASE *****\n" +
                            "\tdtm=" +
                            dtm.
                              getDocumentBaseURI(
                                ));
                    xctxt.
                      getSourceTreeManager(
                        ).
                      removeDocumentFromCache(
                        dtm.
                          getDocument(
                            ));
                    xctxt.
                      release(
                        dtm,
                        false);
                }
            }
        }
        finally {
            if (transformer.
                  getDebug(
                    ))
                transformer.
                  getTraceManager(
                    ).
                  fireSelectedEndEvent(
                    sourceNode,
                    this,
                    "select",
                    new org.apache.xpath.XPath(
                      m_selectExpression),
                    new org.apache.xpath.objects.XNodeSet(
                      sourceNodes));
            xctxt.
              popSAXLocator(
                );
            xctxt.
              popContextNodeList(
                );
            transformer.
              popElemTemplateElement(
                );
            xctxt.
              popCurrentExpressionNode(
                );
            xctxt.
              popCurrentNode(
                );
            sourceNodes.
              detach(
                );
        }
    }
    public org.apache.xalan.templates.ElemTemplateElement appendChild(org.apache.xalan.templates.ElemTemplateElement newChild) {
        int type =
          ((org.apache.xalan.templates.ElemTemplateElement)
             newChild).
          getXSLToken(
            );
        if (org.apache.xalan.templates.Constants.
              ELEMNAME_SORT ==
              type) {
            setSortElem(
              (org.apache.xalan.templates.ElemSort)
                newChild);
            return newChild;
        }
        else
            return super.
              appendChild(
                newChild);
    }
    public void callChildVisitors(org.apache.xalan.templates.XSLTVisitor visitor,
                                  boolean callAttributes) {
        if (callAttributes &&
              null !=
              m_selectExpression)
            m_selectExpression.
              callVisitors(
                this,
                visitor);
        int length =
          getSortElemCount(
            );
        for (int i =
               0;
             i <
               length;
             i++) {
            getSortElem(
              i).
              callVisitors(
                visitor);
        }
        super.
          callChildVisitors(
            visitor,
            callAttributes);
    }
    public org.apache.xpath.Expression getExpression() {
        return m_selectExpression;
    }
    public void setExpression(org.apache.xpath.Expression exp) {
        exp.
          exprSetParent(
            this);
        m_selectExpression =
          exp;
    }
    private void readObject(java.io.ObjectInputStream os)
          throws java.io.IOException,
        java.lang.ClassNotFoundException {
        os.
          defaultReadObject(
            );
        m_xpath =
          null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4rF2XbfOcIQXc8nrOjey5/Ef6X8ezQIufTAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "z2elgNpMVAlmaYo0Lb9J9Jbqkii25x5W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
