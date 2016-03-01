package org.apache.xalan.templates;
public class ElemVariable extends org.apache.xalan.templates.ElemTemplateElement {
    static final long serialVersionUID = 9111131075322790061L;
    public ElemVariable() { super(); }
    protected int m_index;
    int m_frameSize = -1;
    public void setIndex(int index) { m_index = index; }
    public int getIndex() { return m_index; }
    private org.apache.xpath.XPath m_selectPattern;
    public void setSelect(org.apache.xpath.XPath v) { m_selectPattern = v;
    }
    public org.apache.xpath.XPath getSelect() { return m_selectPattern; }
    protected org.apache.xml.utils.QName m_qname;
    public void setName(org.apache.xml.utils.QName v) { m_qname = v; }
    public org.apache.xml.utils.QName getName() { return m_qname; }
    private boolean m_isTopLevel = false;
    public void setIsTopLevel(boolean v) { m_isTopLevel = v; }
    public boolean getIsTopLevel() { return m_isTopLevel; }
    public int getXSLToken() { return org.apache.xalan.templates.Constants.
                                        ELEMNAME_VARIABLE; }
    public java.lang.String getNodeName() { return org.apache.xalan.templates.Constants.
                                                     ELEMNAME_VARIABLE_STRING;
    }
    public ElemVariable(org.apache.xalan.templates.ElemVariable param)
          throws javax.xml.transform.TransformerException { super(
                                                              );
                                                            m_selectPattern =
                                                              param.
                                                                m_selectPattern;
                                                            m_qname =
                                                              param.
                                                                m_qname;
                                                            m_isTopLevel =
                                                              param.
                                                                m_isTopLevel;
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
        int sourceNode =
          transformer.
          getXPathContext(
            ).
          getCurrentNode(
            );
        org.apache.xpath.objects.XObject var =
          getValue(
            transformer,
            sourceNode);
        transformer.
          getXPathContext(
            ).
          getVarStack(
            ).
          setLocalVariable(
            m_index,
            var);
        if (transformer.
              getDebug(
                ))
            transformer.
              getTraceManager(
                ).
              fireTraceEndEvent(
                this);
    }
    public org.apache.xpath.objects.XObject getValue(org.apache.xalan.transformer.TransformerImpl transformer,
                                                     int sourceNode)
          throws javax.xml.transform.TransformerException {
        org.apache.xpath.objects.XObject var;
        org.apache.xpath.XPathContext xctxt =
          transformer.
          getXPathContext(
            );
        xctxt.
          pushCurrentNode(
            sourceNode);
        try {
            if (null !=
                  m_selectPattern) {
                var =
                  m_selectPattern.
                    execute(
                      xctxt,
                      sourceNode,
                      this);
                var.
                  allowDetachToRelease(
                    false);
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
                        m_selectPattern,
                        var);
            }
            else
                if (null ==
                      getFirstChildElem(
                        )) {
                    var =
                      org.apache.xpath.objects.XString.
                        EMPTYSTRING;
                }
                else {
                    int df;
                    try {
                        if (m_parentNode instanceof org.apache.xalan.templates.Stylesheet)
                            df =
                              transformer.
                                transformToGlobalRTF(
                                  this);
                        else
                            df =
                              transformer.
                                transformToRTF(
                                  this);
                    }
                    finally {
                        
                    }
                    var =
                      new org.apache.xpath.objects.XRTreeFrag(
                        df,
                        xctxt,
                        this);
                }
        }
        finally {
            xctxt.
              popCurrentNode(
                );
        }
        return var;
    }
    public void compose(org.apache.xalan.templates.StylesheetRoot sroot)
          throws javax.xml.transform.TransformerException {
        if (null ==
              m_selectPattern &&
              sroot.
              getOptimizer(
                )) {
            org.apache.xpath.XPath newSelect =
              rewriteChildToExpression(
                this);
            if (null !=
                  newSelect)
                m_selectPattern =
                  newSelect;
        }
        org.apache.xalan.templates.StylesheetRoot.ComposeState cstate =
          sroot.
          getComposeState(
            );
        java.util.Vector vnames =
          cstate.
          getVariableNames(
            );
        if (null !=
              m_selectPattern)
            m_selectPattern.
              fixupVariables(
                vnames,
                cstate.
                  getGlobalsSize(
                    ));
        if (!(m_parentNode instanceof org.apache.xalan.templates.Stylesheet) &&
              m_qname !=
              null) {
            m_index =
              cstate.
                addVariableName(
                  m_qname) -
                cstate.
                getGlobalsSize(
                  );
        }
        else
            if (m_parentNode instanceof org.apache.xalan.templates.Stylesheet) {
                cstate.
                  resetStackFrameSize(
                    );
            }
        super.
          compose(
            sroot);
    }
    public void endCompose(org.apache.xalan.templates.StylesheetRoot sroot)
          throws javax.xml.transform.TransformerException {
        super.
          endCompose(
            sroot);
        if (m_parentNode instanceof org.apache.xalan.templates.Stylesheet) {
            org.apache.xalan.templates.StylesheetRoot.ComposeState cstate =
              sroot.
              getComposeState(
                );
            m_frameSize =
              cstate.
                getFrameSize(
                  );
            cstate.
              resetStackFrameSize(
                );
        }
    }
    static org.apache.xpath.XPath rewriteChildToExpression(org.apache.xalan.templates.ElemTemplateElement varElem)
          throws javax.xml.transform.TransformerException {
        org.apache.xalan.templates.ElemTemplateElement t =
          varElem.
          getFirstChildElem(
            );
        if (null !=
              t &&
              null ==
              t.
              getNextSiblingElem(
                )) {
            int etype =
              t.
              getXSLToken(
                );
            if (org.apache.xalan.templates.Constants.
                  ELEMNAME_VALUEOF ==
                  etype) {
                org.apache.xalan.templates.ElemValueOf valueof =
                  (org.apache.xalan.templates.ElemValueOf)
                    t;
                if (valueof.
                      getDisableOutputEscaping(
                        ) ==
                      false &&
                      valueof.
                      getDOMBackPointer(
                        ) ==
                      null) {
                    varElem.
                      m_firstChild =
                      null;
                    return new org.apache.xpath.XPath(
                      new org.apache.xpath.objects.XRTreeFragSelectWrapper(
                        valueof.
                          getSelect(
                            ).
                          getExpression(
                            )));
                }
            }
            else
                if (org.apache.xalan.templates.Constants.
                      ELEMNAME_TEXTLITERALRESULT ==
                      etype) {
                    org.apache.xalan.templates.ElemTextLiteral lit =
                      (org.apache.xalan.templates.ElemTextLiteral)
                        t;
                    if (lit.
                          getDisableOutputEscaping(
                            ) ==
                          false &&
                          lit.
                          getDOMBackPointer(
                            ) ==
                          null) {
                        java.lang.String str =
                          lit.
                          getNodeValue(
                            );
                        org.apache.xpath.objects.XString xstr =
                          new org.apache.xpath.objects.XString(
                          str);
                        varElem.
                          m_firstChild =
                          null;
                        return new org.apache.xpath.XPath(
                          new org.apache.xpath.objects.XRTreeFragSelectWrapper(
                            xstr));
                    }
                }
        }
        return null;
    }
    public void recompose(org.apache.xalan.templates.StylesheetRoot root) {
        root.
          recomposeVariables(
            this);
    }
    public void setParentElem(org.apache.xalan.templates.ElemTemplateElement p) {
        super.
          setParentElem(
            p);
        p.
          m_hasVariableDecl =
          true;
    }
    protected boolean accept(org.apache.xalan.templates.XSLTVisitor visitor) {
        return visitor.
          visitVariableOrParamDecl(
            this);
    }
    protected void callChildVisitors(org.apache.xalan.templates.XSLTVisitor visitor,
                                     boolean callAttrs) {
        if (null !=
              m_selectPattern)
            m_selectPattern.
              getExpression(
                ).
              callVisitors(
                m_selectPattern,
                visitor);
        super.
          callChildVisitors(
            visitor,
            callAttrs);
    }
    public boolean isPsuedoVar() { java.lang.String ns =
                                     m_qname.
                                     getNamespaceURI(
                                       );
                                   if (null !=
                                         ns &&
                                         ns.
                                         equals(
                                           org.apache.xalan.templates.RedundentExprEliminator.
                                             PSUEDOVARNAMESPACE)) {
                                       if (m_qname.
                                             getLocalName(
                                               ).
                                             startsWith(
                                               "#"))
                                           return true;
                                   }
                                   return false;
    }
    public org.apache.xalan.templates.ElemTemplateElement appendChild(org.apache.xalan.templates.ElemTemplateElement elem) {
        if (m_selectPattern !=
              null) {
            error(
              org.apache.xalan.res.XSLTErrorResources.
                ER_CANT_HAVE_CONTENT_AND_SELECT,
              new java.lang.Object[] { "xsl:" +
              this.
                getNodeName(
                  ) });
            return null;
        }
        return super.
          appendChild(
            elem);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "psOiV1s2u/xQJPWlT9Nwo6nUJSZ059TC");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
