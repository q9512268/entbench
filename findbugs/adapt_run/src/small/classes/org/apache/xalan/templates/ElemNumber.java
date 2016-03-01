package org.apache.xalan.templates;
public class ElemNumber extends org.apache.xalan.templates.ElemTemplateElement {
    static final long serialVersionUID = 8118472298274407610L;
    private org.apache.xml.utils.res.CharArrayWrapper m_alphaCountTable =
      null;
    private class MyPrefixResolver implements org.apache.xml.utils.PrefixResolver {
        org.apache.xml.dtm.DTM dtm;
        int handle;
        boolean handleNullPrefix;
        public MyPrefixResolver(org.w3c.dom.Node xpathExpressionContext, org.apache.xml.dtm.DTM dtm,
                                int handle,
                                boolean handleNullPrefix) { super(
                                                              );
                                                            this.
                                                              dtm =
                                                              dtm;
                                                            this.
                                                              handle =
                                                              handle;
                                                            this.
                                                              handleNullPrefix =
                                                              handleNullPrefix;
        }
        public java.lang.String getNamespaceForPrefix(java.lang.String prefix) {
            return dtm.
              getNamespaceURI(
                handle);
        }
        public java.lang.String getNamespaceForPrefix(java.lang.String prefix,
                                                      org.w3c.dom.Node context) {
            return getNamespaceForPrefix(
                     prefix);
        }
        public java.lang.String getBaseIdentifier() { return ElemNumber.this.
                                                        getBaseIdentifier(
                                                          );
        }
        public boolean handlesNullPrefixes() { return handleNullPrefix;
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
           "lF8Cbz599++9/ref/VqeTP8/RlPonNwmAAA=");
    }
    private org.apache.xpath.XPath m_countMatchPattern = null;
    public void setCount(org.apache.xpath.XPath v) { m_countMatchPattern =
                                                       v;
    }
    public org.apache.xpath.XPath getCount() { return m_countMatchPattern;
    }
    private org.apache.xpath.XPath m_fromMatchPattern = null;
    public void setFrom(org.apache.xpath.XPath v) { m_fromMatchPattern =
                                                      v; }
    public org.apache.xpath.XPath getFrom() { return m_fromMatchPattern;
    }
    private int m_level = org.apache.xalan.templates.Constants.
                            NUMBERLEVEL_SINGLE;
    public void setLevel(int v) { m_level = v; }
    public int getLevel() { return m_level; }
    private org.apache.xpath.XPath m_valueExpr = null;
    public void setValue(org.apache.xpath.XPath v) { m_valueExpr =
                                                       v;
    }
    public org.apache.xpath.XPath getValue() { return m_valueExpr;
    }
    private org.apache.xalan.templates.AVT m_format_avt =
      null;
    public void setFormat(org.apache.xalan.templates.AVT v) {
        m_format_avt =
          v;
    }
    public org.apache.xalan.templates.AVT getFormat() { return m_format_avt;
    }
    private org.apache.xalan.templates.AVT m_lang_avt = null;
    public void setLang(org.apache.xalan.templates.AVT v) {
        m_lang_avt =
          v;
    }
    public org.apache.xalan.templates.AVT getLang() { return m_lang_avt;
    }
    private org.apache.xalan.templates.AVT m_lettervalue_avt =
      null;
    public void setLetterValue(org.apache.xalan.templates.AVT v) {
        m_lettervalue_avt =
          v;
    }
    public org.apache.xalan.templates.AVT getLetterValue() {
        return m_lettervalue_avt;
    }
    private org.apache.xalan.templates.AVT m_groupingSeparator_avt =
      null;
    public void setGroupingSeparator(org.apache.xalan.templates.AVT v) {
        m_groupingSeparator_avt =
          v;
    }
    public org.apache.xalan.templates.AVT getGroupingSeparator() {
        return m_groupingSeparator_avt;
    }
    private org.apache.xalan.templates.AVT m_groupingSize_avt =
      null;
    public void setGroupingSize(org.apache.xalan.templates.AVT v) {
        m_groupingSize_avt =
          v;
    }
    public org.apache.xalan.templates.AVT getGroupingSize() {
        return m_groupingSize_avt;
    }
    private static final org.apache.xalan.transformer.DecimalToRoman[]
      m_romanConvertTable =
      { new org.apache.xalan.transformer.DecimalToRoman(
      1000,
      "M",
      900,
      "CM"),
    new org.apache.xalan.transformer.DecimalToRoman(
      500,
      "D",
      400,
      "CD"),
    new org.apache.xalan.transformer.DecimalToRoman(
      100L,
      "C",
      90L,
      "XC"),
    new org.apache.xalan.transformer.DecimalToRoman(
      50L,
      "L",
      40L,
      "XL"),
    new org.apache.xalan.transformer.DecimalToRoman(
      10L,
      "X",
      9L,
      "IX"),
    new org.apache.xalan.transformer.DecimalToRoman(
      5L,
      "V",
      4L,
      "IV"),
    new org.apache.xalan.transformer.DecimalToRoman(
      1L,
      "I",
      1L,
      "I") };
    public void compose(org.apache.xalan.templates.StylesheetRoot sroot)
          throws javax.xml.transform.TransformerException {
        super.
          compose(
            sroot);
        org.apache.xalan.templates.StylesheetRoot.ComposeState cstate =
          sroot.
          getComposeState(
            );
        java.util.Vector vnames =
          cstate.
          getVariableNames(
            );
        if (null !=
              m_countMatchPattern)
            m_countMatchPattern.
              fixupVariables(
                vnames,
                cstate.
                  getGlobalsSize(
                    ));
        if (null !=
              m_format_avt)
            m_format_avt.
              fixupVariables(
                vnames,
                cstate.
                  getGlobalsSize(
                    ));
        if (null !=
              m_fromMatchPattern)
            m_fromMatchPattern.
              fixupVariables(
                vnames,
                cstate.
                  getGlobalsSize(
                    ));
        if (null !=
              m_groupingSeparator_avt)
            m_groupingSeparator_avt.
              fixupVariables(
                vnames,
                cstate.
                  getGlobalsSize(
                    ));
        if (null !=
              m_groupingSize_avt)
            m_groupingSize_avt.
              fixupVariables(
                vnames,
                cstate.
                  getGlobalsSize(
                    ));
        if (null !=
              m_lang_avt)
            m_lang_avt.
              fixupVariables(
                vnames,
                cstate.
                  getGlobalsSize(
                    ));
        if (null !=
              m_lettervalue_avt)
            m_lettervalue_avt.
              fixupVariables(
                vnames,
                cstate.
                  getGlobalsSize(
                    ));
        if (null !=
              m_valueExpr)
            m_valueExpr.
              fixupVariables(
                vnames,
                cstate.
                  getGlobalsSize(
                    ));
    }
    public int getXSLToken() { return org.apache.xalan.templates.Constants.
                                        ELEMNAME_NUMBER; }
    public java.lang.String getNodeName() { return org.apache.xalan.templates.Constants.
                                                     ELEMNAME_NUMBER_STRING;
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
        java.lang.String countString =
          getCountString(
            transformer,
            sourceNode);
        try {
            transformer.
              getResultTreeHandler(
                ).
              characters(
                countString.
                  toCharArray(
                    ),
                0,
                countString.
                  length(
                    ));
        }
        catch (org.xml.sax.SAXException se) {
            throw new javax.xml.transform.TransformerException(
              se);
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
        }
    }
    public org.apache.xalan.templates.ElemTemplateElement appendChild(org.apache.xalan.templates.ElemTemplateElement newChild) {
        error(
          org.apache.xalan.res.XSLTErrorResources.
            ER_CANNOT_ADD,
          new java.lang.Object[] { newChild.
            getNodeName(
              ),
          this.
            getNodeName(
              ) });
        return null;
    }
    int findAncestor(org.apache.xpath.XPathContext xctxt,
                     org.apache.xpath.XPath fromMatchPattern,
                     org.apache.xpath.XPath countMatchPattern,
                     int context,
                     org.apache.xalan.templates.ElemNumber namespaceContext)
          throws javax.xml.transform.TransformerException {
        org.apache.xml.dtm.DTM dtm =
          xctxt.
          getDTM(
            context);
        while (org.apache.xml.dtm.DTM.
                 NULL !=
                 context) {
            if (null !=
                  fromMatchPattern) {
                if (fromMatchPattern.
                      getMatchScore(
                        xctxt,
                        context) !=
                      org.apache.xpath.XPath.
                        MATCH_SCORE_NONE) {
                    break;
                }
            }
            if (null !=
                  countMatchPattern) {
                if (countMatchPattern.
                      getMatchScore(
                        xctxt,
                        context) !=
                      org.apache.xpath.XPath.
                        MATCH_SCORE_NONE) {
                    break;
                }
            }
            context =
              dtm.
                getParent(
                  context);
        }
        return context;
    }
    private int findPrecedingOrAncestorOrSelf(org.apache.xpath.XPathContext xctxt,
                                              org.apache.xpath.XPath fromMatchPattern,
                                              org.apache.xpath.XPath countMatchPattern,
                                              int context,
                                              org.apache.xalan.templates.ElemNumber namespaceContext)
          throws javax.xml.transform.TransformerException {
        org.apache.xml.dtm.DTM dtm =
          xctxt.
          getDTM(
            context);
        while (org.apache.xml.dtm.DTM.
                 NULL !=
                 context) {
            if (null !=
                  fromMatchPattern) {
                if (fromMatchPattern.
                      getMatchScore(
                        xctxt,
                        context) !=
                      org.apache.xpath.XPath.
                        MATCH_SCORE_NONE) {
                    context =
                      org.apache.xml.dtm.DTM.
                        NULL;
                    break;
                }
            }
            if (null !=
                  countMatchPattern) {
                if (countMatchPattern.
                      getMatchScore(
                        xctxt,
                        context) !=
                      org.apache.xpath.XPath.
                        MATCH_SCORE_NONE) {
                    break;
                }
            }
            int prevSibling =
              dtm.
              getPreviousSibling(
                context);
            if (org.apache.xml.dtm.DTM.
                  NULL ==
                  prevSibling) {
                context =
                  dtm.
                    getParent(
                      context);
            }
            else {
                context =
                  dtm.
                    getLastChild(
                      prevSibling);
                if (context ==
                      org.apache.xml.dtm.DTM.
                        NULL)
                    context =
                      prevSibling;
            }
        }
        return context;
    }
    org.apache.xpath.XPath getCountMatchPattern(org.apache.xpath.XPathContext support,
                                                int contextNode)
          throws javax.xml.transform.TransformerException {
        org.apache.xpath.XPath countMatchPattern =
          m_countMatchPattern;
        org.apache.xml.dtm.DTM dtm =
          support.
          getDTM(
            contextNode);
        if (null ==
              countMatchPattern) {
            switch (dtm.
                      getNodeType(
                        contextNode)) {
                case org.apache.xml.dtm.DTM.
                       ELEMENT_NODE:
                    org.apache.xalan.templates.ElemNumber.MyPrefixResolver resolver;
                    if (dtm.
                          getNamespaceURI(
                            contextNode) ==
                          null) {
                        resolver =
                          new org.apache.xalan.templates.ElemNumber.MyPrefixResolver(
                            dtm.
                              getNode(
                                contextNode),
                            dtm,
                            contextNode,
                            false);
                    }
                    else {
                        resolver =
                          new org.apache.xalan.templates.ElemNumber.MyPrefixResolver(
                            dtm.
                              getNode(
                                contextNode),
                            dtm,
                            contextNode,
                            true);
                    }
                    countMatchPattern =
                      new org.apache.xpath.XPath(
                        dtm.
                          getNodeName(
                            contextNode),
                        this,
                        resolver,
                        org.apache.xpath.XPath.
                          MATCH,
                        support.
                          getErrorListener(
                            ));
                    break;
                case org.apache.xml.dtm.DTM.
                       ATTRIBUTE_NODE:
                    countMatchPattern =
                      new org.apache.xpath.XPath(
                        "@" +
                        dtm.
                          getNodeName(
                            contextNode),
                        this,
                        this,
                        org.apache.xpath.XPath.
                          MATCH,
                        support.
                          getErrorListener(
                            ));
                    break;
                case org.apache.xml.dtm.DTM.
                       CDATA_SECTION_NODE:
                case org.apache.xml.dtm.DTM.
                       TEXT_NODE:
                    countMatchPattern =
                      new org.apache.xpath.XPath(
                        "text()",
                        this,
                        this,
                        org.apache.xpath.XPath.
                          MATCH,
                        support.
                          getErrorListener(
                            ));
                    break;
                case org.apache.xml.dtm.DTM.
                       COMMENT_NODE:
                    countMatchPattern =
                      new org.apache.xpath.XPath(
                        "comment()",
                        this,
                        this,
                        org.apache.xpath.XPath.
                          MATCH,
                        support.
                          getErrorListener(
                            ));
                    break;
                case org.apache.xml.dtm.DTM.
                       DOCUMENT_NODE:
                    countMatchPattern =
                      new org.apache.xpath.XPath(
                        "/",
                        this,
                        this,
                        org.apache.xpath.XPath.
                          MATCH,
                        support.
                          getErrorListener(
                            ));
                    break;
                case org.apache.xml.dtm.DTM.
                       PROCESSING_INSTRUCTION_NODE:
                    countMatchPattern =
                      new org.apache.xpath.XPath(
                        "pi(" +
                        dtm.
                          getNodeName(
                            contextNode) +
                        ")",
                        this,
                        this,
                        org.apache.xpath.XPath.
                          MATCH,
                        support.
                          getErrorListener(
                            ));
                    break;
                default:
                    countMatchPattern =
                      null;
            }
        }
        return countMatchPattern;
    }
    java.lang.String getCountString(org.apache.xalan.transformer.TransformerImpl transformer,
                                    int sourceNode)
          throws javax.xml.transform.TransformerException {
        long[] list =
          null;
        org.apache.xpath.XPathContext xctxt =
          transformer.
          getXPathContext(
            );
        org.apache.xalan.transformer.CountersTable ctable =
          transformer.
          getCountersTable(
            );
        if (null !=
              m_valueExpr) {
            org.apache.xpath.objects.XObject countObj =
              m_valueExpr.
              execute(
                xctxt,
                sourceNode,
                this);
            double d_count =
              java.lang.Math.
              floor(
                countObj.
                  num(
                    ) +
                  0.5);
            if (java.lang.Double.
                  isNaN(
                    d_count))
                return "NaN";
            else
                if (d_count <
                      0 &&
                      java.lang.Double.
                      isInfinite(
                        d_count))
                    return "-Infinity";
                else
                    if (java.lang.Double.
                          isInfinite(
                            d_count))
                        return "Infinity";
                    else
                        if (d_count ==
                              0)
                            return "0";
                        else {
                            long count =
                              (long)
                                d_count;
                            list =
                              (new long[1]);
                            list[0] =
                              count;
                        }
        }
        else {
            if (org.apache.xalan.templates.Constants.
                  NUMBERLEVEL_ANY ==
                  m_level) {
                list =
                  (new long[1]);
                list[0] =
                  ctable.
                    countNode(
                      xctxt,
                      this,
                      sourceNode);
            }
            else {
                org.apache.xml.utils.NodeVector ancestors =
                  getMatchingAncestors(
                    xctxt,
                    sourceNode,
                    org.apache.xalan.templates.Constants.
                      NUMBERLEVEL_SINGLE ==
                      m_level);
                int lastIndex =
                  ancestors.
                  size(
                    ) -
                  1;
                if (lastIndex >=
                      0) {
                    list =
                      (new long[lastIndex +
                                  1]);
                    for (int i =
                           lastIndex;
                         i >=
                           0;
                         i--) {
                        int target =
                          ancestors.
                          elementAt(
                            i);
                        list[lastIndex -
                               i] =
                          ctable.
                            countNode(
                              xctxt,
                              this,
                              target);
                    }
                }
            }
        }
        return null !=
          list
          ? formatNumberList(
              transformer,
              list,
              sourceNode)
          : "";
    }
    public int getPreviousNode(org.apache.xpath.XPathContext xctxt,
                               int pos) throws javax.xml.transform.TransformerException {
        org.apache.xpath.XPath countMatchPattern =
          getCountMatchPattern(
            xctxt,
            pos);
        org.apache.xml.dtm.DTM dtm =
          xctxt.
          getDTM(
            pos);
        if (org.apache.xalan.templates.Constants.
              NUMBERLEVEL_ANY ==
              m_level) {
            org.apache.xpath.XPath fromMatchPattern =
              m_fromMatchPattern;
            while (org.apache.xml.dtm.DTM.
                     NULL !=
                     pos) {
                int next =
                  dtm.
                  getPreviousSibling(
                    pos);
                if (org.apache.xml.dtm.DTM.
                      NULL ==
                      next) {
                    next =
                      dtm.
                        getParent(
                          pos);
                    if (org.apache.xml.dtm.DTM.
                          NULL !=
                          next &&
                          (null !=
                             fromMatchPattern &&
                             fromMatchPattern.
                             getMatchScore(
                               xctxt,
                               next) !=
                             org.apache.xpath.XPath.
                               MATCH_SCORE_NONE ||
                             dtm.
                             getNodeType(
                               next) ==
                             org.apache.xml.dtm.DTM.
                               DOCUMENT_NODE)) {
                        pos =
                          org.apache.xml.dtm.DTM.
                            NULL;
                        break;
                    }
                }
                else {
                    int child =
                      next;
                    while (org.apache.xml.dtm.DTM.
                             NULL !=
                             child) {
                        child =
                          dtm.
                            getLastChild(
                              next);
                        if (org.apache.xml.dtm.DTM.
                              NULL !=
                              child)
                            next =
                              child;
                    }
                }
                pos =
                  next;
                if (org.apache.xml.dtm.DTM.
                      NULL !=
                      pos &&
                      (null ==
                         countMatchPattern ||
                         countMatchPattern.
                         getMatchScore(
                           xctxt,
                           pos) !=
                         org.apache.xpath.XPath.
                           MATCH_SCORE_NONE)) {
                    break;
                }
            }
        }
        else {
            while (org.apache.xml.dtm.DTM.
                     NULL !=
                     pos) {
                pos =
                  dtm.
                    getPreviousSibling(
                      pos);
                if (org.apache.xml.dtm.DTM.
                      NULL !=
                      pos &&
                      (null ==
                         countMatchPattern ||
                         countMatchPattern.
                         getMatchScore(
                           xctxt,
                           pos) !=
                         org.apache.xpath.XPath.
                           MATCH_SCORE_NONE)) {
                    break;
                }
            }
        }
        return pos;
    }
    public int getTargetNode(org.apache.xpath.XPathContext xctxt,
                             int sourceNode)
          throws javax.xml.transform.TransformerException {
        int target =
          org.apache.xml.dtm.DTM.
            NULL;
        org.apache.xpath.XPath countMatchPattern =
          getCountMatchPattern(
            xctxt,
            sourceNode);
        if (org.apache.xalan.templates.Constants.
              NUMBERLEVEL_ANY ==
              m_level) {
            target =
              findPrecedingOrAncestorOrSelf(
                xctxt,
                m_fromMatchPattern,
                countMatchPattern,
                sourceNode,
                this);
        }
        else {
            target =
              findAncestor(
                xctxt,
                m_fromMatchPattern,
                countMatchPattern,
                sourceNode,
                this);
        }
        return target;
    }
    org.apache.xml.utils.NodeVector getMatchingAncestors(org.apache.xpath.XPathContext xctxt,
                                                         int node,
                                                         boolean stopAtFirstFound)
          throws javax.xml.transform.TransformerException {
        org.apache.xpath.NodeSetDTM ancestors =
          new org.apache.xpath.NodeSetDTM(
          xctxt.
            getDTMManager(
              ));
        org.apache.xpath.XPath countMatchPattern =
          getCountMatchPattern(
            xctxt,
            node);
        org.apache.xml.dtm.DTM dtm =
          xctxt.
          getDTM(
            node);
        while (org.apache.xml.dtm.DTM.
                 NULL !=
                 node) {
            if (null !=
                  m_fromMatchPattern &&
                  m_fromMatchPattern.
                  getMatchScore(
                    xctxt,
                    node) !=
                  org.apache.xpath.XPath.
                    MATCH_SCORE_NONE) {
                if (!stopAtFirstFound)
                    break;
            }
            if (null ==
                  countMatchPattern)
                java.lang.System.
                  out.
                  println(
                    "Programmers error! countMatchPattern should never be null!");
            if (countMatchPattern.
                  getMatchScore(
                    xctxt,
                    node) !=
                  org.apache.xpath.XPath.
                    MATCH_SCORE_NONE) {
                ancestors.
                  addElement(
                    node);
                if (stopAtFirstFound)
                    break;
            }
            node =
              dtm.
                getParent(
                  node);
        }
        return ancestors;
    }
    java.util.Locale getLocale(org.apache.xalan.transformer.TransformerImpl transformer,
                               int contextNode)
          throws javax.xml.transform.TransformerException {
        java.util.Locale locale =
          null;
        if (null !=
              m_lang_avt) {
            org.apache.xpath.XPathContext xctxt =
              transformer.
              getXPathContext(
                );
            java.lang.String langValue =
              m_lang_avt.
              evaluate(
                xctxt,
                contextNode,
                this);
            if (null !=
                  langValue) {
                locale =
                  new java.util.Locale(
                    langValue.
                      toUpperCase(
                        ),
                    "");
                if (null ==
                      locale) {
                    transformer.
                      getMsgMgr(
                        ).
                      warn(
                        this,
                        null,
                        xctxt.
                          getDTM(
                            contextNode).
                          getNode(
                            contextNode),
                        org.apache.xalan.res.XSLTErrorResources.
                          WG_LOCALE_NOT_FOUND,
                        new java.lang.Object[] { langValue });
                    locale =
                      java.util.Locale.
                        getDefault(
                          );
                }
            }
        }
        else {
            locale =
              java.util.Locale.
                getDefault(
                  );
        }
        return locale;
    }
    private java.text.DecimalFormat getNumberFormatter(org.apache.xalan.transformer.TransformerImpl transformer,
                                                       int contextNode)
          throws javax.xml.transform.TransformerException {
        java.util.Locale locale =
          (java.util.Locale)
            getLocale(
              transformer,
              contextNode).
            clone(
              );
        java.text.DecimalFormat formatter =
          null;
        java.lang.String digitGroupSepValue =
          null !=
          m_groupingSeparator_avt
          ? m_groupingSeparator_avt.
          evaluate(
            transformer.
              getXPathContext(
                ),
            contextNode,
            this)
          : null;
        if (digitGroupSepValue !=
              null &&
              !m_groupingSeparator_avt.
              isSimple(
                ) &&
              digitGroupSepValue.
              length(
                ) !=
              1) {
            transformer.
              getMsgMgr(
                ).
              warn(
                this,
                org.apache.xalan.res.XSLTErrorResources.
                  WG_ILLEGAL_ATTRIBUTE_VALUE,
                new java.lang.Object[] { org.apache.xalan.templates.Constants.
                                           ATTRNAME_NAME,
                m_groupingSeparator_avt.
                  getName(
                    ) });
        }
        java.lang.String nDigitsPerGroupValue =
          null !=
          m_groupingSize_avt
          ? m_groupingSize_avt.
          evaluate(
            transformer.
              getXPathContext(
                ),
            contextNode,
            this)
          : null;
        if (null !=
              digitGroupSepValue &&
              null !=
              nDigitsPerGroupValue &&
              digitGroupSepValue.
              length(
                ) >
              0) {
            try {
                formatter =
                  (java.text.DecimalFormat)
                    java.text.NumberFormat.
                    getNumberInstance(
                      locale);
                formatter.
                  setGroupingSize(
                    java.lang.Integer.
                      valueOf(
                        nDigitsPerGroupValue).
                      intValue(
                        ));
                java.text.DecimalFormatSymbols symbols =
                  formatter.
                  getDecimalFormatSymbols(
                    );
                symbols.
                  setGroupingSeparator(
                    digitGroupSepValue.
                      charAt(
                        0));
                formatter.
                  setDecimalFormatSymbols(
                    symbols);
                formatter.
                  setGroupingUsed(
                    true);
            }
            catch (java.lang.NumberFormatException ex) {
                formatter.
                  setGroupingUsed(
                    false);
            }
        }
        return formatter;
    }
    java.lang.String formatNumberList(org.apache.xalan.transformer.TransformerImpl transformer,
                                      long[] list,
                                      int contextNode)
          throws javax.xml.transform.TransformerException {
        java.lang.String numStr;
        org.apache.xml.utils.FastStringBuffer formattedNumber =
          org.apache.xml.utils.StringBufferPool.
          get(
            );
        try {
            int nNumbers =
              list.
                length;
            int numberWidth =
              1;
            char numberType =
              '1';
            java.lang.String formatToken;
            java.lang.String lastSepString =
              null;
            java.lang.String formatTokenString =
              null;
            java.lang.String lastSep =
              ".";
            boolean isFirstToken =
              true;
            java.lang.String formatValue =
              null !=
              m_format_avt
              ? m_format_avt.
              evaluate(
                transformer.
                  getXPathContext(
                    ),
                contextNode,
                this)
              : null;
            if (null ==
                  formatValue)
                formatValue =
                  "1";
            org.apache.xalan.templates.ElemNumber.NumberFormatStringTokenizer formatTokenizer =
              new org.apache.xalan.templates.ElemNumber.NumberFormatStringTokenizer(
              formatValue);
            for (int i =
                   0;
                 i <
                   nNumbers;
                 i++) {
                if (formatTokenizer.
                      hasMoreTokens(
                        )) {
                    formatToken =
                      formatTokenizer.
                        nextToken(
                          );
                    if (java.lang.Character.
                          isLetterOrDigit(
                            formatToken.
                              charAt(
                                formatToken.
                                  length(
                                    ) -
                                  1))) {
                        numberWidth =
                          formatToken.
                            length(
                              );
                        numberType =
                          formatToken.
                            charAt(
                              numberWidth -
                                1);
                    }
                    else
                        if (formatTokenizer.
                              isLetterOrDigitAhead(
                                )) {
                            final java.lang.StringBuffer formatTokenStringBuffer =
                              new java.lang.StringBuffer(
                              formatToken);
                            while (formatTokenizer.
                                     nextIsSep(
                                       )) {
                                formatToken =
                                  formatTokenizer.
                                    nextToken(
                                      );
                                formatTokenStringBuffer.
                                  append(
                                    formatToken);
                            }
                            formatTokenString =
                              formatTokenStringBuffer.
                                toString(
                                  );
                            if (!isFirstToken)
                                lastSep =
                                  formatTokenString;
                            formatToken =
                              formatTokenizer.
                                nextToken(
                                  );
                            numberWidth =
                              formatToken.
                                length(
                                  );
                            numberType =
                              formatToken.
                                charAt(
                                  numberWidth -
                                    1);
                        }
                        else {
                            lastSepString =
                              formatToken;
                            while (formatTokenizer.
                                     hasMoreTokens(
                                       )) {
                                formatToken =
                                  formatTokenizer.
                                    nextToken(
                                      );
                                lastSepString +=
                                  formatToken;
                            }
                        }
                }
                if (null !=
                      formatTokenString &&
                      isFirstToken) {
                    formattedNumber.
                      append(
                        formatTokenString);
                }
                else
                    if (null !=
                          lastSep &&
                          !isFirstToken)
                        formattedNumber.
                          append(
                            lastSep);
                getFormattedNumber(
                  transformer,
                  contextNode,
                  numberType,
                  numberWidth,
                  list[i],
                  formattedNumber);
                isFirstToken =
                  false;
            }
            while (formatTokenizer.
                     isLetterOrDigitAhead(
                       )) {
                formatTokenizer.
                  nextToken(
                    );
            }
            if (lastSepString !=
                  null)
                formattedNumber.
                  append(
                    lastSepString);
            while (formatTokenizer.
                     hasMoreTokens(
                       )) {
                formatToken =
                  formatTokenizer.
                    nextToken(
                      );
                formattedNumber.
                  append(
                    formatToken);
            }
            numStr =
              formattedNumber.
                toString(
                  );
        }
        finally {
            org.apache.xml.utils.StringBufferPool.
              free(
                formattedNumber);
        }
        return numStr;
    }
    private void getFormattedNumber(org.apache.xalan.transformer.TransformerImpl transformer,
                                    int contextNode,
                                    char numberType,
                                    int numberWidth,
                                    long listElement,
                                    org.apache.xml.utils.FastStringBuffer formattedNumber)
          throws javax.xml.transform.TransformerException {
        java.lang.String letterVal =
          m_lettervalue_avt !=
          null
          ? m_lettervalue_avt.
          evaluate(
            transformer.
              getXPathContext(
                ),
            contextNode,
            this)
          : null;
        org.apache.xml.utils.res.CharArrayWrapper alphaCountTable =
          null;
        org.apache.xml.utils.res.XResourceBundle thisBundle =
          null;
        switch (numberType) {
            case 'A':
                if (null ==
                      m_alphaCountTable) {
                    thisBundle =
                      (org.apache.xml.utils.res.XResourceBundle)
                        org.apache.xml.utils.res.XResourceBundle.
                        loadResourceBundle(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_BUNDLE_NAME,
                          getLocale(
                            transformer,
                            contextNode));
                    m_alphaCountTable =
                      (org.apache.xml.utils.res.CharArrayWrapper)
                        thisBundle.
                        getObject(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_ALPHABET);
                }
                int2alphaCount(
                  listElement,
                  m_alphaCountTable,
                  formattedNumber);
                break;
            case 'a':
                if (null ==
                      m_alphaCountTable) {
                    thisBundle =
                      (org.apache.xml.utils.res.XResourceBundle)
                        org.apache.xml.utils.res.XResourceBundle.
                        loadResourceBundle(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_BUNDLE_NAME,
                          getLocale(
                            transformer,
                            contextNode));
                    m_alphaCountTable =
                      (org.apache.xml.utils.res.CharArrayWrapper)
                        thisBundle.
                        getObject(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_ALPHABET);
                }
                org.apache.xml.utils.FastStringBuffer stringBuf =
                  org.apache.xml.utils.StringBufferPool.
                  get(
                    );
                try {
                    int2alphaCount(
                      listElement,
                      m_alphaCountTable,
                      stringBuf);
                    formattedNumber.
                      append(
                        stringBuf.
                          toString(
                            ).
                          toLowerCase(
                            getLocale(
                              transformer,
                              contextNode)));
                }
                finally {
                    org.apache.xml.utils.StringBufferPool.
                      free(
                        stringBuf);
                }
                break;
            case 'I':
                formattedNumber.
                  append(
                    long2roman(
                      listElement,
                      true));
                break;
            case 'i':
                formattedNumber.
                  append(
                    long2roman(
                      listElement,
                      true).
                      toLowerCase(
                        getLocale(
                          transformer,
                          contextNode)));
                break;
            case 12354:
                {
                    thisBundle =
                      (org.apache.xml.utils.res.XResourceBundle)
                        org.apache.xml.utils.res.XResourceBundle.
                        loadResourceBundle(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_BUNDLE_NAME,
                          new java.util.Locale(
                            "ja",
                            "JP",
                            "HA"));
                    if (letterVal !=
                          null &&
                          letterVal.
                          equals(
                            org.apache.xalan.templates.Constants.
                              ATTRVAL_TRADITIONAL))
                        formattedNumber.
                          append(
                            tradAlphaCount(
                              listElement,
                              thisBundle));
                    else
                        formattedNumber.
                          append(
                            int2singlealphaCount(
                              listElement,
                              (org.apache.xml.utils.res.CharArrayWrapper)
                                thisBundle.
                                getObject(
                                  org.apache.xml.utils.res.XResourceBundle.
                                    LANG_ALPHABET)));
                    break;
                }
            case 12356:
                {
                    thisBundle =
                      (org.apache.xml.utils.res.XResourceBundle)
                        org.apache.xml.utils.res.XResourceBundle.
                        loadResourceBundle(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_BUNDLE_NAME,
                          new java.util.Locale(
                            "ja",
                            "JP",
                            "HI"));
                    if (letterVal !=
                          null &&
                          letterVal.
                          equals(
                            org.apache.xalan.templates.Constants.
                              ATTRVAL_TRADITIONAL))
                        formattedNumber.
                          append(
                            tradAlphaCount(
                              listElement,
                              thisBundle));
                    else
                        formattedNumber.
                          append(
                            int2singlealphaCount(
                              listElement,
                              (org.apache.xml.utils.res.CharArrayWrapper)
                                thisBundle.
                                getObject(
                                  org.apache.xml.utils.res.XResourceBundle.
                                    LANG_ALPHABET)));
                    break;
                }
            case 12450:
                {
                    thisBundle =
                      (org.apache.xml.utils.res.XResourceBundle)
                        org.apache.xml.utils.res.XResourceBundle.
                        loadResourceBundle(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_BUNDLE_NAME,
                          new java.util.Locale(
                            "ja",
                            "JP",
                            "A"));
                    if (letterVal !=
                          null &&
                          letterVal.
                          equals(
                            org.apache.xalan.templates.Constants.
                              ATTRVAL_TRADITIONAL))
                        formattedNumber.
                          append(
                            tradAlphaCount(
                              listElement,
                              thisBundle));
                    else
                        formattedNumber.
                          append(
                            int2singlealphaCount(
                              listElement,
                              (org.apache.xml.utils.res.CharArrayWrapper)
                                thisBundle.
                                getObject(
                                  org.apache.xml.utils.res.XResourceBundle.
                                    LANG_ALPHABET)));
                    break;
                }
            case 12452:
                {
                    thisBundle =
                      (org.apache.xml.utils.res.XResourceBundle)
                        org.apache.xml.utils.res.XResourceBundle.
                        loadResourceBundle(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_BUNDLE_NAME,
                          new java.util.Locale(
                            "ja",
                            "JP",
                            "I"));
                    if (letterVal !=
                          null &&
                          letterVal.
                          equals(
                            org.apache.xalan.templates.Constants.
                              ATTRVAL_TRADITIONAL))
                        formattedNumber.
                          append(
                            tradAlphaCount(
                              listElement,
                              thisBundle));
                    else
                        formattedNumber.
                          append(
                            int2singlealphaCount(
                              listElement,
                              (org.apache.xml.utils.res.CharArrayWrapper)
                                thisBundle.
                                getObject(
                                  org.apache.xml.utils.res.XResourceBundle.
                                    LANG_ALPHABET)));
                    break;
                }
            case 19968:
                {
                    thisBundle =
                      (org.apache.xml.utils.res.XResourceBundle)
                        org.apache.xml.utils.res.XResourceBundle.
                        loadResourceBundle(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_BUNDLE_NAME,
                          new java.util.Locale(
                            "zh",
                            "CN"));
                    if (letterVal !=
                          null &&
                          letterVal.
                          equals(
                            org.apache.xalan.templates.Constants.
                              ATTRVAL_TRADITIONAL)) {
                        formattedNumber.
                          append(
                            tradAlphaCount(
                              listElement,
                              thisBundle));
                    }
                    else
                        int2alphaCount(
                          listElement,
                          (org.apache.xml.utils.res.CharArrayWrapper)
                            thisBundle.
                            getObject(
                              org.apache.xml.utils.res.XResourceBundle.
                                LANG_ALPHABET),
                          formattedNumber);
                    break;
                }
            case 22777:
                {
                    thisBundle =
                      (org.apache.xml.utils.res.XResourceBundle)
                        org.apache.xml.utils.res.XResourceBundle.
                        loadResourceBundle(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_BUNDLE_NAME,
                          new java.util.Locale(
                            "zh",
                            "TW"));
                    if (letterVal !=
                          null &&
                          letterVal.
                          equals(
                            org.apache.xalan.templates.Constants.
                              ATTRVAL_TRADITIONAL))
                        formattedNumber.
                          append(
                            tradAlphaCount(
                              listElement,
                              thisBundle));
                    else
                        int2alphaCount(
                          listElement,
                          (org.apache.xml.utils.res.CharArrayWrapper)
                            thisBundle.
                            getObject(
                              org.apache.xml.utils.res.XResourceBundle.
                                LANG_ALPHABET),
                          formattedNumber);
                    break;
                }
            case 3665:
                {
                    thisBundle =
                      (org.apache.xml.utils.res.XResourceBundle)
                        org.apache.xml.utils.res.XResourceBundle.
                        loadResourceBundle(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_BUNDLE_NAME,
                          new java.util.Locale(
                            "th",
                            ""));
                    if (letterVal !=
                          null &&
                          letterVal.
                          equals(
                            org.apache.xalan.templates.Constants.
                              ATTRVAL_TRADITIONAL))
                        formattedNumber.
                          append(
                            tradAlphaCount(
                              listElement,
                              thisBundle));
                    else
                        int2alphaCount(
                          listElement,
                          (org.apache.xml.utils.res.CharArrayWrapper)
                            thisBundle.
                            getObject(
                              org.apache.xml.utils.res.XResourceBundle.
                                LANG_ALPHABET),
                          formattedNumber);
                    break;
                }
            case 1488:
                {
                    thisBundle =
                      (org.apache.xml.utils.res.XResourceBundle)
                        org.apache.xml.utils.res.XResourceBundle.
                        loadResourceBundle(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_BUNDLE_NAME,
                          new java.util.Locale(
                            "he",
                            ""));
                    if (letterVal !=
                          null &&
                          letterVal.
                          equals(
                            org.apache.xalan.templates.Constants.
                              ATTRVAL_TRADITIONAL))
                        formattedNumber.
                          append(
                            tradAlphaCount(
                              listElement,
                              thisBundle));
                    else
                        int2alphaCount(
                          listElement,
                          (org.apache.xml.utils.res.CharArrayWrapper)
                            thisBundle.
                            getObject(
                              org.apache.xml.utils.res.XResourceBundle.
                                LANG_ALPHABET),
                          formattedNumber);
                    break;
                }
            case 4304:
                {
                    thisBundle =
                      (org.apache.xml.utils.res.XResourceBundle)
                        org.apache.xml.utils.res.XResourceBundle.
                        loadResourceBundle(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_BUNDLE_NAME,
                          new java.util.Locale(
                            "ka",
                            ""));
                    if (letterVal !=
                          null &&
                          letterVal.
                          equals(
                            org.apache.xalan.templates.Constants.
                              ATTRVAL_TRADITIONAL))
                        formattedNumber.
                          append(
                            tradAlphaCount(
                              listElement,
                              thisBundle));
                    else
                        int2alphaCount(
                          listElement,
                          (org.apache.xml.utils.res.CharArrayWrapper)
                            thisBundle.
                            getObject(
                              org.apache.xml.utils.res.XResourceBundle.
                                LANG_ALPHABET),
                          formattedNumber);
                    break;
                }
            case 945:
                {
                    thisBundle =
                      (org.apache.xml.utils.res.XResourceBundle)
                        org.apache.xml.utils.res.XResourceBundle.
                        loadResourceBundle(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_BUNDLE_NAME,
                          new java.util.Locale(
                            "el",
                            ""));
                    if (letterVal !=
                          null &&
                          letterVal.
                          equals(
                            org.apache.xalan.templates.Constants.
                              ATTRVAL_TRADITIONAL))
                        formattedNumber.
                          append(
                            tradAlphaCount(
                              listElement,
                              thisBundle));
                    else
                        int2alphaCount(
                          listElement,
                          (org.apache.xml.utils.res.CharArrayWrapper)
                            thisBundle.
                            getObject(
                              org.apache.xml.utils.res.XResourceBundle.
                                LANG_ALPHABET),
                          formattedNumber);
                    break;
                }
            case 1072:
                {
                    thisBundle =
                      (org.apache.xml.utils.res.XResourceBundle)
                        org.apache.xml.utils.res.XResourceBundle.
                        loadResourceBundle(
                          org.apache.xml.utils.res.XResourceBundle.
                            LANG_BUNDLE_NAME,
                          new java.util.Locale(
                            "cy",
                            ""));
                    if (letterVal !=
                          null &&
                          letterVal.
                          equals(
                            org.apache.xalan.templates.Constants.
                              ATTRVAL_TRADITIONAL))
                        formattedNumber.
                          append(
                            tradAlphaCount(
                              listElement,
                              thisBundle));
                    else
                        int2alphaCount(
                          listElement,
                          (org.apache.xml.utils.res.CharArrayWrapper)
                            thisBundle.
                            getObject(
                              org.apache.xml.utils.res.XResourceBundle.
                                LANG_ALPHABET),
                          formattedNumber);
                    break;
                }
            default:
                java.text.DecimalFormat formatter =
                  getNumberFormatter(
                    transformer,
                    contextNode);
                java.lang.String padString =
                  formatter ==
                  null
                  ? java.lang.String.
                  valueOf(
                    0)
                  : formatter.
                  format(
                    0);
                java.lang.String numString =
                  formatter ==
                  null
                  ? java.lang.String.
                  valueOf(
                    listElement)
                  : formatter.
                  format(
                    listElement);
                int nPadding =
                  numberWidth -
                  numString.
                  length(
                    );
                for (int k =
                       0;
                     k <
                       nPadding;
                     k++) {
                    formattedNumber.
                      append(
                        padString);
                }
                formattedNumber.
                  append(
                    numString);
        }
    }
    java.lang.String getZeroString() { return "" +
                                       0;
    }
    protected java.lang.String int2singlealphaCount(long val,
                                                    org.apache.xml.utils.res.CharArrayWrapper table) {
        int radix =
          table.
          getLength(
            );
        if (val >
              radix) {
            return getZeroString(
                     );
        }
        else
            return new java.lang.Character(
              table.
                getChar(
                  (int)
                    val -
                    1)).
              toString(
                );
    }
    protected void int2alphaCount(long val,
                                  org.apache.xml.utils.res.CharArrayWrapper aTable,
                                  org.apache.xml.utils.FastStringBuffer stringBuf) {
        int radix =
          aTable.
          getLength(
            );
        char[] table =
          new char[radix];
        int i;
        for (i =
               0;
             i <
               radix -
               1;
             i++) {
            table[i +
                    1] =
              aTable.
                getChar(
                  i);
        }
        table[0] =
          aTable.
            getChar(
              i);
        char[] buf =
          new char[100];
        int charPos;
        charPos =
          buf.
            length -
            1;
        int lookupIndex =
          1;
        long correction =
          0;
        do  {
            correction =
              lookupIndex ==
                0 ||
                correction !=
                0 &&
                lookupIndex ==
                radix -
                1
                ? radix -
                1
                : 0;
            lookupIndex =
              (int)
                (val +
                   correction) %
                radix;
            val =
              val /
                radix;
            if (lookupIndex ==
                  0 &&
                  val ==
                  0)
                break;
            buf[charPos--] =
              table[lookupIndex];
        }while(val >
                 0); 
        stringBuf.
          append(
            buf,
            charPos +
              1,
            buf.
              length -
              charPos -
              1);
    }
    protected java.lang.String tradAlphaCount(long val,
                                              org.apache.xml.utils.res.XResourceBundle thisBundle) {
        if (val >
              java.lang.Long.
                MAX_VALUE) {
            this.
              error(
                org.apache.xalan.res.XSLTErrorResources.
                  ER_NUMBER_TOO_BIG);
            return org.apache.xalan.res.XSLTErrorResources.
                     ERROR_STRING;
        }
        char[] table =
          null;
        int lookupIndex =
          1;
        char[] buf =
          new char[100];
        int charPos;
        charPos =
          0;
        org.apache.xml.utils.res.IntArrayWrapper groups =
          (org.apache.xml.utils.res.IntArrayWrapper)
            thisBundle.
            getObject(
              org.apache.xml.utils.res.XResourceBundle.
                LANG_NUMBERGROUPS);
        org.apache.xml.utils.res.StringArrayWrapper tables =
          (org.apache.xml.utils.res.StringArrayWrapper)
            thisBundle.
            getObject(
              org.apache.xml.utils.res.XResourceBundle.
                LANG_NUM_TABLES);
        java.lang.String numbering =
          thisBundle.
          getString(
            org.apache.xml.utils.res.XResourceBundle.
              LANG_NUMBERING);
        if (numbering.
              equals(
                org.apache.xml.utils.res.XResourceBundle.
                  LANG_MULT_ADD)) {
            java.lang.String mult_order =
              thisBundle.
              getString(
                org.apache.xml.utils.res.XResourceBundle.
                  MULT_ORDER);
            org.apache.xml.utils.res.LongArrayWrapper multiplier =
              (org.apache.xml.utils.res.LongArrayWrapper)
                thisBundle.
                getObject(
                  org.apache.xml.utils.res.XResourceBundle.
                    LANG_MULTIPLIER);
            org.apache.xml.utils.res.CharArrayWrapper zeroChar =
              (org.apache.xml.utils.res.CharArrayWrapper)
                thisBundle.
                getObject(
                  "zero");
            int i =
              0;
            while (i <
                     multiplier.
                     getLength(
                       ) &&
                     val <
                     multiplier.
                     getLong(
                       i)) {
                i++;
            }
            do  {
                if (i >=
                      multiplier.
                      getLength(
                        ))
                    break;
                if (val <
                      multiplier.
                      getLong(
                        i)) {
                    if (zeroChar.
                          getLength(
                            ) ==
                          0) {
                        i++;
                    }
                    else {
                        if (buf[charPos -
                                  1] !=
                              zeroChar.
                              getChar(
                                0))
                            buf[charPos++] =
                              zeroChar.
                                getChar(
                                  0);
                        i++;
                    }
                }
                else
                    if (val >=
                          multiplier.
                          getLong(
                            i)) {
                        long mult =
                          val /
                          multiplier.
                          getLong(
                            i);
                        val =
                          val %
                            multiplier.
                            getLong(
                              i);
                        int k =
                          0;
                        while (k <
                                 groups.
                                 getLength(
                                   )) {
                            lookupIndex =
                              1;
                            if (mult /
                                  groups.
                                  getInt(
                                    k) <=
                                  0)
                                k++;
                            else {
                                org.apache.xml.utils.res.CharArrayWrapper THEletters =
                                  (org.apache.xml.utils.res.CharArrayWrapper)
                                    thisBundle.
                                    getObject(
                                      tables.
                                        getString(
                                          k));
                                table =
                                  (new char[THEletters.
                                              getLength(
                                                ) +
                                              1]);
                                int j;
                                for (j =
                                       0;
                                     j <
                                       THEletters.
                                       getLength(
                                         );
                                     j++) {
                                    table[j +
                                            1] =
                                      THEletters.
                                        getChar(
                                          j);
                                }
                                table[0] =
                                  THEletters.
                                    getChar(
                                      j -
                                        1);
                                lookupIndex =
                                  (int)
                                    mult /
                                    groups.
                                    getInt(
                                      k);
                                if (lookupIndex ==
                                      0 &&
                                      mult ==
                                      0)
                                    break;
                                char multiplierChar =
                                  ((org.apache.xml.utils.res.CharArrayWrapper)
                                     thisBundle.
                                     getObject(
                                       org.apache.xml.utils.res.XResourceBundle.
                                         LANG_MULTIPLIER_CHAR)).
                                  getChar(
                                    i);
                                if (lookupIndex <
                                      table.
                                        length) {
                                    if (mult_order.
                                          equals(
                                            org.apache.xml.utils.res.XResourceBundle.
                                              MULT_PRECEDES)) {
                                        buf[charPos++] =
                                          multiplierChar;
                                        buf[charPos++] =
                                          table[lookupIndex];
                                    }
                                    else {
                                        if (lookupIndex ==
                                              1 &&
                                              i ==
                                              multiplier.
                                              getLength(
                                                ) -
                                              1) {
                                            
                                        }
                                        else
                                            buf[charPos++] =
                                              table[lookupIndex];
                                        buf[charPos++] =
                                          multiplierChar;
                                    }
                                    break;
                                }
                                else
                                    return org.apache.xalan.res.XSLTErrorResources.
                                             ERROR_STRING;
                            }
                        }
                        i++;
                    }
            }while(i <
                     multiplier.
                     getLength(
                       )); 
        }
        int count =
          0;
        java.lang.String tableName;
        while (count <
                 groups.
                 getLength(
                   )) {
            if (val /
                  groups.
                  getInt(
                    count) <=
                  0)
                count++;
            else {
                org.apache.xml.utils.res.CharArrayWrapper theletters =
                  (org.apache.xml.utils.res.CharArrayWrapper)
                    thisBundle.
                    getObject(
                      tables.
                        getString(
                          count));
                table =
                  (new char[theletters.
                              getLength(
                                ) +
                              1]);
                int j;
                for (j =
                       0;
                     j <
                       theletters.
                       getLength(
                         );
                     j++) {
                    table[j +
                            1] =
                      theletters.
                        getChar(
                          j);
                }
                table[0] =
                  theletters.
                    getChar(
                      j -
                        1);
                lookupIndex =
                  (int)
                    val /
                    groups.
                    getInt(
                      count);
                val =
                  val %
                    groups.
                    getInt(
                      count);
                if (lookupIndex ==
                      0 &&
                      val ==
                      0)
                    break;
                if (lookupIndex <
                      table.
                        length) {
                    buf[charPos++] =
                      table[lookupIndex];
                }
                else
                    return org.apache.xalan.res.XSLTErrorResources.
                             ERROR_STRING;
                count++;
            }
        }
        return new java.lang.String(
          buf,
          0,
          charPos);
    }
    protected java.lang.String long2roman(long val,
                                          boolean prefixesAreOK) {
        if (val <=
              0) {
            return getZeroString(
                     );
        }
        final java.lang.String roman;
        int place =
          0;
        if (val <=
              3999L) {
            java.lang.StringBuffer romanBuffer =
              new java.lang.StringBuffer(
              );
            do  {
                while (val >=
                         m_romanConvertTable[place].
                           m_postValue) {
                    romanBuffer.
                      append(
                        m_romanConvertTable[place].
                          m_postLetter);
                    val -=
                      m_romanConvertTable[place].
                        m_postValue;
                }
                if (prefixesAreOK) {
                    if (val >=
                          m_romanConvertTable[place].
                            m_preValue) {
                        romanBuffer.
                          append(
                            m_romanConvertTable[place].
                              m_preLetter);
                        val -=
                          m_romanConvertTable[place].
                            m_preValue;
                    }
                }
                place++;
            }while(val >
                     0); 
            roman =
              romanBuffer.
                toString(
                  );
        }
        else {
            roman =
              org.apache.xalan.res.XSLTErrorResources.
                ERROR_STRING;
        }
        return roman;
    }
    public void callChildVisitors(org.apache.xalan.templates.XSLTVisitor visitor,
                                  boolean callAttrs) {
        if (callAttrs) {
            if (null !=
                  m_countMatchPattern)
                m_countMatchPattern.
                  getExpression(
                    ).
                  callVisitors(
                    m_countMatchPattern,
                    visitor);
            if (null !=
                  m_fromMatchPattern)
                m_fromMatchPattern.
                  getExpression(
                    ).
                  callVisitors(
                    m_fromMatchPattern,
                    visitor);
            if (null !=
                  m_valueExpr)
                m_valueExpr.
                  getExpression(
                    ).
                  callVisitors(
                    m_valueExpr,
                    visitor);
            if (null !=
                  m_format_avt)
                m_format_avt.
                  callVisitors(
                    visitor);
            if (null !=
                  m_groupingSeparator_avt)
                m_groupingSeparator_avt.
                  callVisitors(
                    visitor);
            if (null !=
                  m_groupingSize_avt)
                m_groupingSize_avt.
                  callVisitors(
                    visitor);
            if (null !=
                  m_lang_avt)
                m_lang_avt.
                  callVisitors(
                    visitor);
            if (null !=
                  m_lettervalue_avt)
                m_lettervalue_avt.
                  callVisitors(
                    visitor);
        }
        super.
          callChildVisitors(
            visitor,
            callAttrs);
    }
    class NumberFormatStringTokenizer {
        private int currentPosition;
        private int maxPosition;
        private java.lang.String str;
        public NumberFormatStringTokenizer(java.lang.String str) {
            super(
              );
            this.
              str =
              str;
            maxPosition =
              str.
                length(
                  );
        }
        public void reset() { currentPosition =
                                0; }
        public java.lang.String nextToken() {
            if (currentPosition >=
                  maxPosition) {
                throw new java.util.NoSuchElementException(
                  );
            }
            int start =
              currentPosition;
            while (currentPosition <
                     maxPosition &&
                     java.lang.Character.
                     isLetterOrDigit(
                       str.
                         charAt(
                           currentPosition))) {
                currentPosition++;
            }
            if (start ==
                  currentPosition &&
                  !java.lang.Character.
                  isLetterOrDigit(
                    str.
                      charAt(
                        currentPosition))) {
                currentPosition++;
            }
            return str.
              substring(
                start,
                currentPosition);
        }
        public boolean isLetterOrDigitAhead() {
            int pos =
              currentPosition;
            while (pos <
                     maxPosition) {
                if (java.lang.Character.
                      isLetterOrDigit(
                        str.
                          charAt(
                            pos)))
                    return true;
                pos++;
            }
            return false;
        }
        public boolean nextIsSep() { if (java.lang.Character.
                                           isLetterOrDigit(
                                             str.
                                               charAt(
                                                 currentPosition)))
                                         return false;
                                     else
                                         return true;
        }
        public boolean hasMoreTokens() { return currentPosition >=
                                           maxPosition
                                           ? false
                                           : true;
        }
        public int countTokens() { int count =
                                     0;
                                   int currpos =
                                     currentPosition;
                                   while (currpos <
                                            maxPosition) {
                                       int start =
                                         currpos;
                                       while (currpos <
                                                maxPosition &&
                                                java.lang.Character.
                                                isLetterOrDigit(
                                                  str.
                                                    charAt(
                                                      currpos))) {
                                           currpos++;
                                       }
                                       if (start ==
                                             currpos &&
                                             java.lang.Character.
                                             isLetterOrDigit(
                                               str.
                                                 charAt(
                                                   currpos)) ==
                                             false) {
                                           currpos++;
                                       }
                                       count++;
                                   }
                                   return count;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1444739587000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "qv+rXPOGwSP4b7zY/RclIa4MQx0AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1444739587000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "SGPabAcdlSU6eG8k+2yx4TSllmL04Tk7tsayRA6SlWJZjEk3dQ/L865kcJ2k" +
           "o9U7Hq4V4ImxGMq4QzTXxUDTXFXuoWVPbfTX1UFfR9Q2LTr9wM331mUgbM+r" +
           "D4glyfbH3VZZqRQba19nxcZ4VWlgi6ZvU6YaliMvsKpBFWtEdGNKqgOkQ2gj" +
           "zuWW0rzbJkOuXSH6dpif9yNumCtgcG1BNKvO2Km4Qid2CmyHtZRlzymgnu9y" +
           "NE52exXgIzpJt5mYiUgYk9gtKhV7XfaTGkt1KEyTNS2hbbcTL+vjUY0vCU4d" +
           "QWK4HGBSqPVhQh4vuAGf9FpEQLeNABmOcx09J3YqRbJPMUZ+XCM7nNRUrCkb" +
           "N5lFZHsRMbRdd2RxS5Pgx1qjrJmziciG3KQWzKLqos+wkYjxUVlpkdOwQRne" +
           "YIEiuXqx0e/2S93CstzSaAZFqgYmkhPVyRWKeVEOuRJXma0lQV4OXd4rtaVR" +
           "IUxIDtN9EAoXhC/ihUo4bgRrpeXMS2CiICnOQ2XViOfVVYso4b42WOFddVDo" +
           "l5rFXDWMotJ8ARK+mB8IJhNg1GRcW1MsGy7gTm2wJBUGjhsgkGjNamtCE8hg" +
           "hYachVKFpca2KsScg3u87YVVD7er6mrhkcZwLlkOmsDOgqv0y5OgnPBi0skR" +
           "bBg4Sa89IkcRO0BMPGDGmkv0K2SZ8uMKMjEcTBugrLeaNBOFcZNyZT4jnCqN" +
           "l0WsHCwHxACd+6V5biIMjHwwxOJ1t0aV+uWg6YRCT+/BTdHjupgSGroc94qR" +
           "rVQZTTT8urRm8kR71hpQUY3WFI3qjGDacmieLQzqq6BSn9XL3LIurmiHVls4" +
           "wTk9MmawpGv0fNqcM7q+WER92PKWhaiHx3SdWJucpHuzbr/vdoi5Wg8UR1uy" +
           "Ap3Ua0HSqozRRa+AV7gFOs2RtlEsopyCt0SB60fUSBjVBTgqtbwSHmG5ckGt" +
           "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");
    }
    public ElemNumber() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1cC5AcxXnunXvq9Lg7va0n6IWeu+apOEcw0iGhgz3dRXec" +
       "xfFYze327Y00OzPMzJ5WAlmAMQgImCAJcABVsKU4UOKVRJgQQ7AhNgQwgahk" +
       "CTACjAvzkAuZMoJgTP6/u2dndnZnVlva8lVt79x0/93/9/Xff//d2zN7j5A6" +
       "yySzDFlLyVF7k0GtaDded8umRVPtqmxZvXA3kbzp7e1bj/3viGskUt9PxgzJ" +
       "VmdStuhKhaopq59MVzTLlrUktVZTmkKJbpNa1ByWbUXX+skExerIGKqSVOxO" +
       "PUWxQJ9sxkmrbNumMpC1aYeowCYz40ybGNMmtsxfoC1ORiV1Y5MrMKVAoN2T" +
       "h2UzbnuWTVri6+VhOZa1FTUWVyy7LWeSRYaubkqruh2lOTu6Xj1TEHFB/Mwi" +
       "GmY90vzpF7cNtTAaxsmaptsMorWGWro6TFNx0uzeXaHSjHUF+TapiZORnsI2" +
       "mRN3Go1BozFo1MHrlgLtR1Mtm2nXGRzbqaneSKJCNjm5sBJDNuWMqKab6Qw1" +
       "NNoCOxMGtCfl0Trd7YO4c1Fsx52Xt/xLDWnuJ82K1oPqJEEJGxrpB0JpZoCa" +
       "1rJUiqb6SasGHd5DTUVWlc2it8daSlqT7SyYgEML3swa1GRtulxBTwI2M5u0" +
       "dTMPb5AZlfivblCV04B1oouVI1yJ9wFgkwKKmYMy2J4Qqd2gaClmR4USeYxz" +
       "LoQCINqQofaQnm+qVpPhBhnLTUSVtXSsB4xPS0PROh1M0GS2FlApcm3IyQ1y" +
       "miZsMtlfrptnQakRjAgUsckEfzFWE/TSFF8vefrnyOqzb71SW6VJJAI6p2hS" +
       "Rf1HgtAMn9AaOkhNCuOAC45aGL9DnvjkNokQKDzBV5iX+fFVR89dPOPp53iZ" +
       "qSXKdA2sp0k7kdw9MOaVae0LvlGDajQauqVg5xcgZ6OsW+S05QzwNBPzNWJm" +
       "1Ml8es3PL776AfqhRJo6SH1SV7MZsKPWpJ4xFJWa51ONmrJNUx1kBNVS7Sy/" +
       "gzTAdVzRKL/bNThoUbuD1KrsVr3O/geKBqEKpKgJrhVtUHeuDdkeYtc5gxDS" +
       "AB8yCj4XEv7Hvm0yGBvSMzQmJ2VN0fRYt6kjfuxQ5nOoBdcpyDX0WE4Go1my" +
       "PnFaYmnitJhlJmO6mY7JYBVDlGdCeXCDgMSKoW9YncWhFEV7M/5iLeUQ87iN" +
       "kQh0xzS/M1BhHK3S1RQ1E8kd2eUrjj6UeIEbGg4OwZZN5kJzUd5clDUXzTcX" +
       "dZsjkQhrZTw2yzscumsDDHzwvKMW9Fx2wbpts2rA0oyNtcA1Fp1XNBO1ux7C" +
       "ceuJ5N5X1hx7+aWmByQigRMZgJnInQ7mFEwHfDYz9SRNgT8Kmhgc5xgLngpK" +
       "6kGevmvjNX1bv8708Hp4rLAOnBOKd6Nfzjcxxz+yS9XbfMPvPn34ji26O8YL" +
       "pgxnpiuSRNcxy9+nfvCJ5MKT5H2JJ7fMkUgt+CPwwbYMYwbc2wx/GwUupM1x" +
       "x4ilEQAP6mZGVjHL8aFN9pCpb3TvMGNrxWQCtzs0B5+CzJP/TY9x78Ffvn86" +
       "Y9Jx+s2e2bqH2m0eR4OVjWUupdW1rl6TUij367u6t+88csMlzLSgxOxSDc7B" +
       "tB0cDPQOMPjd5644dPjN3fsl1xxtmGmzAxC05BiW8V/BXwQ+f8YPOge8wZ3E" +
       "2HbhqU7KuyoDW57n6gZOS4XhjMYx5yINjE8ZVOQBleJY+FPz3FP3fXRrC+9u" +
       "Fe441rK4fAXu/a8tJ1e/cPmxGayaSBInTZc/txj3xOPcmpeZprwJ9chd8+r0" +
       "7/9Cvhd8OvhRS9lMmWskjA/COvAMxkWMpaf78s7CZI7ltfHCYeQJbhLJ2/Z/" +
       "PLrv46eOMm0LoyNvv3fKRhu3It4LxPMX935j7kQD00k50GGS3+mskq0hqOyM" +
       "p1df2qI+/QU02w/NJiFusLpMcHi5AlMSpesaXvvpMxPXvVJDpJWkSdXl1EqZ" +
       "DTgyAiydWkPgK3PGN8/lemxshKSF8UGKGELSZ5buzhUZw2YdsPnxSf929o92" +
       "vcmskJvdVCY+ysLIze8bWfjtDuuPXr/7N/957IcNfPJeEOzLfHKT/69LHbj2" +
       "nc+KeoJ5sRKBhU++P7b3nint53zI5F13gtKzc8WTDDhcV/a0BzJ/lGbV/5dE" +
       "GvpJS1KEun2ymsWR3A/hneXEvxAOF+QXhmo8LmnLu8tpflfmadbvyNzJDa6x" +
       "NF6P9lldK/biOfDpFFbX6bc6NtmNYV2MKkXjOsSON79724vfm30YuLmA1A2j" +
       "3kBJi1uIT5XX7905feSOt25mHW88cPdNj3772Sew1lWs/bksnY/JImYPEjgn" +
       "iwXmNkBRNFnN5RVl5tYSoigsgywWsfdBHA/9fFHHeWzQeswLV2k92QHL7jaV" +
       "DDjcYRFDPjzx2BXPNmw+z4kPS4nwkhdanS8/seq9BHPojThF9zrEeibfZWba" +
       "M1G0YLIER2+I8fo0im0Ze3jDPb97kGvkt1RfYbptx01fRW/dwR0tXyfMLgrV" +
       "vTJ8reDT7uSwVpjEyvce3vIf/7zlBq7V2MKodwUs6h488OWL0bveer5EcFWr" +
       "gt3k3UckHxtN9LPNMdWfeu/nW68/2AWTeQdpzGrKFVnakSo06gYrO+Ch312C" +
       "uIYu0OGcZpPIQsMQ8zWmSzHp4BbWFujsluctEMNochZ8eoQF9hQNFcIuUqWt" +
       "G6beBsNUhmEe9Zn1yJBKbdKaSciqMQQxY1aze3FyZNKTbbLAG7BmVNYPVtTE" +
       "+GtINtkE+C1TNgzutTyo6fGjbsK7i+CzTSi4LQC1zlFjks5LS1h4RIi0TcZl" +
       "EklE1inbyaFu2YYVqeYAnOgFiCub6Npusb7xoDEqRLMQPvuEPvsC0ORC0QRJ" +
       "g/POJAZNPeMFgzm2T+VNFap8Jnw+EY1+EqDy1lCVg6TBKDMJlQ5Tlcn0CHeA" +
       "X32e636b1Chit8YzgPHfdf4xdXWF4GZDRRN4Uf5dAtzNYeACpW0yMpNg09OK" +
       "nGGW6oi/q1DXWdDKUtHa0gBdbw/VNUjahvkjwdYedkIetp0hMCNkUbqsr9cH" +
       "Z3uFcE4CRdYKhdYGwLk7FE6QtE2awK4gFkAweOdOn6r3VKjqKdDIVtHY1gBV" +
       "fxCqapA0c7EqxcHKbCVI4x9WqPESaOs+0eZ9ARrfH6pxkLRNJmUSaVPPGoqW" +
       "7qFitRek9wMV6j0fWnxGtPxMgN6PhOodJM38Y15vWIkFqfzo8as8Ce/CBBX5" +
       "vWj0vQCVf1x6Wq7BSzaldGHSnSuEM9GpsUTNbPICby9rEM0PU1PMziaZGxzo" +
       "sVmZxzi7/mn2L7fumv02W7Q1KlYfztnpEvukHpmP9x7+8NXR0x9imxy1GICi" +
       "JqP9G8zF+8cF28LMYzcXUjg3BGjO8UaLir2RKWsWui1qRs+jSQW3TvQ1yIlh" +
       "GMTXrY+HdGsuIGrCy8Vup7C/euLb0fTo6llfEgxrpwdtOrOQdve1O3aluvac" +
       "KonV/iU2rIF1Y4k7I/Kq5rMA2b9U7WScuuu+pa8eq3n99smjinfwsKYZAftz" +
       "C4Otxd/AL679YErvOUPrKtiam+nD76/y/s69z58/L3m7xH4t4MvMol8ZCoXa" +
       "CuPwJpPaWVMrjLxn5XsMow8yEz47RY/t9FuXayXMofy8cAQ2hoj69m08UYnN" +
       "aj0QsrFzEJNXbNJoUZvF1qWCntphXUm5BvxqOb9UsDeCN85lt1/KQ2omYsDt" +
       "EZD2VM5GkGgI2N+G5L2HyVtARFoQwfhzQb99wqCZCcyAj5gYSNG0Uh50kGg5" +
       "EzgagvwTTD6CEBhMYCU4cvz3NRf4ker0NkwhZL/Qfn/lwINEQ3B9GZL3FSaf" +
       "Aea0i9nT2Z9Xp7Onw+dLofiXlWMOEg3u7Ouw1siIYOCRkZjU8vEeR/de2NuR" +
       "uhNGPhqzYA0SaeI18O+KkAeKhgCbEJI3CZMWPrbzoK9zQbdWp7vBvUdmCs1n" +
       "Vg46SLTM2I6cHIJ8NibTeHeznVVfd0+vmiuPLBbqL64ceZBoCLAlIXkxTObz" +
       "7s6Ddkd3ZEHVXHlkmdB8WeWgg0SDu/tOhu4bIcjbMDkDojd05WwV7evvM6sz" +
       "vHE9sFrov7py6EGiIchWhOSdj8m5gDrtRX2ni3pZdTp8GqhMheq0ctRBouU6" +
       "/G9DoPdgEudzd1zW0r7u7qxOd8NFJCu0z1YOPEg0BNdlIXkJTNbyudvB7Ons" +
       "i6vT2bgfd6NQ/MbKMQeJlutsJQT4BkxSNhnD5m7cqSnl0stuax9fn08Fte4Q" +
       "IO6oHH+QaAi8bEjeRkwMgJ4ugu7p+iuq0/ULQO+9Qv+9lUMPEi3X9deE4P8O" +
       "JlfZZDx0/fn+LS+fAWypjgGcDMo9IaA8UTkLQaIhIG8JyfseJtuAgHQAAR4z" +
       "uLE6ZjAHtH9RoHixcgKCRMuZwfdDWLgbkx02afaagbLZ7wJ2VscCcL47KFAc" +
       "rJyAINEQfHtC8n6EyT8C9nQxdk/n31edzse91E8FgE8rxx4kWrrz2f/+nzJ9" +
       "P3P02JtUag1Raq/RdR74Pxpe23x2JJD9Jprfn4z2ujuVK3JJauC+GatsHyZ7" +
       "YVbFk5m65TepB6tjUpOBI7GByb8rojVQNMRsfhqS9wwmP7HJSDCptT3xXn0D" +
       "ZT9UepaGT54wblYYZlNphlB+RuW4g0RDsL0UkvcyJs9x3Kv1FF0tZ/I/p3vO" +
       "r/Aj0i4Xz1dnaM0DIGLFJy2qnItFAaLhg2Fx6J69Z1TgwwyMpNcDHXXkMVbg" +
       "MCYHYMTQHE1mbf+I+dUJs4XbR/g7lNQlIHdVzlaQaDhb0TKHgHvFf3hNNe6N" +
       "3g8xuCOYvAsGh+cwtFT7kKKm8NYHLl2/PWG68PcQMhawrheY14fQxVLPLyzE" +
       "94uXFFKPD2gdq6DO4W566eMa4ikLLOQm1zlCx3fqmnH5WTm7/DMmf7DJqEFF" +
       "Sy3DJ3dEiORxa5+cMNtjMAvGoHSPYOmeMsZZ/AtpoGhpglHvz3384b0vsCWp" +
       "sQwtUhMmNdA/SEu3SZM0Bd6ty3QY6jJ7qDpYyJNUe8I8oQBGUtIBAfZAOE+R" +
       "PxYbYpCoD7LEzw/meWK7wdL4csRMxKSZh9bt/kNIjGqXj5bqTAGTCKmZymvg" +
       "3xXxESgazMcbLh8nleNjFiZT+VqT8cHnQSzwisvEtKrF2DWXCjiXlhlBxe49" +
       "UPS4LGNxOSaimJzCQ24YMcOKnrUwXvANkvnVoWIK4HhM4HmsciqCRI+Lir8q" +
       "R8VfY3K6TUYDFb2yKQInHxFnVG3lXXNIoDlU+egIEvVBrMkf/BBEsJweTEof" +
       "fWsY0HWVyloJksi6HGPpvHI0XojJN7mvYW4GBpbjgC1nMpxZ8kQn8t1H848T" +
       "MsLPrY47gqChtpXXwL8rIjxQ9Ljc0bfKUXYxJmv47nZcT8qqL1Tnz0G4GYyY" +
       "nhMmZjJmLQRU4neK2nI/cRTP74Gix0UMLUcMemRpnU3G4mBk8RHf/Idpy2GI" +
       "PymCcZdzLIcXcYmSq2NBXwOUtwi0t1RuQUGiwUP2Df9TI/kz+p5zUv8+7v1/" +
       "fX5dwyF+VL30UwC+J0nfufKFH+hvfCg5R4F688qyk9/IzHSuLP+2yfpqPduY" +
       "UdljQVbMpFYMH7Dwnt12nqT8C7bGLeNJtJKNjIuLSi6XlvMC/HyddFXp5QUa" +
       "N1mMSTeraolN6lWqpfkx7u+i5GZxgtszIhwzHueuydtVXaPe4+/8CUxFj+af" +
       "1IbMXElNX8pDkTZ7plKmj8/SPIs36caQvJsxud4mdUnUi8MIKX4rH0GeoVV0" +
       "hJoPfqvc4P97TDTwgfywMB//cf54nTdM0094fDtn/+uivIa6cnsWxY6wblGA" +
       "qA9lPdOj3nWE5abk2uSQOEJXmkvXav1rzPy0ulK2RIC7PDs4yNeY0t3l6N+N" +
       "yR3c9zpeN8U7AWXcbRDpzup0AKwY6r/Oa+Dfx+VgawhPAkVDbPWhkLxHMLmf" +
       "R4P91NRLrhDKnjgui3wcZp0CaouJtD5sDva7nAiEDIap2+Aeacq3uzEypM7A" +
       "yZlchMkGRsBPQsh5CpN94JkUzT7NAl4gaMw/uuPj6LET5ohNS22A43KB57Jw" +
       "65AeL6bisgDRwOlXUIHV3ccwPxfCx39j8gysJ5GPAia84+TZ6lgLrB3qfybg" +
       "/KxyJoJEQ4zCcS/zA5/DWotvBcmaSbo8q6VgcsK294cQhmdSpZeBMNuUU8uC" +
       "TOd/qkMYRDEN23kN/LsiwgJFw0eRtIIBfSeEhHcx+bWNTyZr6dPY+XofAW9W" +
       "J3Q9H7QXx0obKj+RGihamgDHWOaF7HfiLzF9iqXwXUtB1e9DqPoDJu/bpBXW" +
       "QCrbWxbilm+MfVA5YznoAXcDFh/0nlz0lh3+ZpjkQ7uaGyftuuhX/KkE5+0t" +
       "o+KkcTCrqt7nkD3X9YZJBxXG8yiWtrKnM6XPbTIlmCM8n+9co+LSZ1zqTxAQ" +
       "+aUgOGPf3nJfASq3HMSi/MJTpEaySQ0UwcsapCLyQY5HkfmnChxayYRytHoe" +
       "RJhdcMyfvdfIWZFk+ZuNEsmHd12w+sqjZ+3hL4xIqvLmzVjLyDhp4K+lYJXi" +
       "sf6TA2tz6qpfteCLMY+MmOusZwpeWOHVjfU2zJrs5Q5TfG9QsObkX6RwaPfZ" +
       "T720rf5ViUQuIREZgvNLih9VzxlZk8y8JF7qsd4+2WQvd2hr+s26lz97LTKW" +
       "PRhOCHsQeEaYRCK5/anXuwcN4x8kMqKD1ClaiubYc/TnbdLW0OSwWfCUcP0A" +
       "eM38wzBj0CBlDFMYM4LQ0fm7+C4Rm8wqfmK6+P0q4JI2UnM51o7VjPY9CJHF" +
       "FZSby5jFM1sQtyLTYFeJeKdhiFdsSDcx5g0DjaxmPP6z7v8BtNovWrxMAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ezt8rbqWLEGYW4xnWM3iKJpWdXjUCih4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("vIzlDRk0kko/LhEEHM6hHuRV4oEPYQvYrM7SkuKINNzqdSiC3JRXTi8kMJEy" +
       "9DKR1Ml6Y17i9fU6G8bkVnc2W9ITSadxoSvQ/LDbLtmSVuwVlTEZVGfSCNIR" +
       "ixlavS6YpVriUGwZEsz3u3o3JrSKwTBqnanoaBLhAyHGgo5RlNchwSPLft9G" +
       "GaFLWWWInXbqKCsPaUNc+4YqlKraMJlQLLVJ241qNCOIPtsq68qq3hpUp7V6" +
       "XaXFqrmkqMHQBsECnlS0le10a1PeRqAWbWtIi1y1CYLbVFpkRWmbg1Ei1ooy" +
       "zYQLGos7bpdjhYGt0sF8DmGh53YMT7e6wBtV0KoEg8hh6gXDdTg2aJtRMIhr" +
       "RxVuTsNNpR5uKkOhviCRVcsTNmCqrqI91B02O+Ow18S0OTZoF0dsIkiCh7st" +
       "hGqna8hWp31krVBVORjRSZ+bGw0phJZMb9FZzRY1acVjHR7v2/ONHetAykmb" +
       "08WUliXKQB1LZRaEOQchy4pH5a4z5NK1GcTtsO8T5dZ0hi+AHwQKkKjVxhhE" +
       "rFSHSQacaNpkig/LVYGWQRzij9ezGGOWsTNxp71+tWvQ1a4dgJANH/WKYHxE" +
       "VyN0ogmVPpg0Ci1CKm/6w57TTQhn0qlYsxnTc1vWuKjqvXY8afr0UoOazXZA" +
       "rlW+7WraNBDg7nSysVxyCbxIt8N6cbcHz9wFySB2LEyrnaYnLXS85NBeMkeX" +
       "QwcNS120ivJ0QLG+UEX0FW6E3my2plC/t0iGDWohw5LWH8+EhLTjKuLMZR5d" +
       "ragS76Rwp9oRNoID5DNfkDY1HI2rjtovOz1IHvEsUu2YCTymqbFMq/bIc8aV" +
       "TtVuLtFRV4N6ircpd3rsxsbluZJSPXkmCza3KjNgnjsYh2sTBjF7NBx3zPWY" +
       "Lbe0Bt+DlmnRq6XjGC0icQnSZjVlvSGKE6oCj9d4kYQdLdL6RLdoxBqu10ZV" +
       "oo6iq82yAfXSLhdRbLG80bwVq0TCWLEWw4lEe4RAd5HW2glLZQeIFkekDqUy" +
       "ZEj2mUUvojizPrNiGoe6G0UhZl5tOBaZkk1zvOqLrsXUrenK05YJEhXNWmee" +
       "6GGQ9ox12o3UaKOEk5nIqtUihOLjhFgURa3Uk+hZ22JmqNda8nPEs/r2AoU4" +
       "thdU6rI4jMkgiZSqrYydsYnSvf6s6nfhjupOJrBBuqy2iuUq20D4Fr/Wtc2a" +
       "bkKQrNWqDq/QMNyoaq3QgYqRGffEuuwE00SoA//UwVZYw2KVwaLiTNs1UVqW" +
       "I244aJMzexnPxLjkp+wGjqx+edTDEbYVVDeMKsBhxaozRWYzqsiN1FMZdIxg" +
       "05ksjVpeGnkw1l8LdR8aiMWWlhQnurg2WGw5aUns1FhSSZembG0EiC0xI8o3" +
       "Wn1noUdmZQ3mOzAuuhEZtmpBKxYRBzPbrZ7olYsgwpBXlShtbzwawTZzSzbo" +
       "ZWcUNNlhYNRwj2lUyeU45REGs6q6SK8hMAVf1Kk2X3MNhiuXsWql36wh5Lpe" +
       "w1SqLpmB3hqtB9Zs3OtOKrK8ZhMN+KnGAtU3AVnrsJgpotUiP69bOuU3Kytt" +
       "I+lQP9mQLtkeVlNc5qAUq0GtqRvGTdkWOclFV/WJLgf9cqMqDw1b4by52qSZ" +
       "aDxGI5wfKNBqSQujVpspV5YMRAXmWieJNayOwl6vqXFq2+jKSVGaMvxm7tcV" +
       "VijOXDDWNqZkZdjoIsNZArtSf1EcdUxDtPVWdzoQCaSrmVRKNMzVbD0bh82S" +
       "2mitWLdFRpDkNWfTIe5L00QyLbtIaxOsJqSOi83kFmFAsGOlsGVUinNvsRwi" +
       "kdjZaGEUGTOov2zXinDoglBM5nF/FSLOsgXiAWFONpNZB92Y09DvO3R9xkp8" +
       "z7JxGnWKDdkF0cG8lK74BBsWxbE+6LBaxSE1jFtVujRnQjTJe21xww2BWcqB" +
       "6OHUZijUukvNdnAjETfCaBN2XXVEGopMb7RY0XrTObEsziOmHdhdpVReF4PV" +
       "Yl6sGFQ16a1iyk4nC2rTMrxqv2gJ5MwMtDqPlcO0DqwvVHEw2SjS9iAK5mtP" +
       "nQ66k4U2LqekH9TAHFLrNIbBQFrO6qO1yGpzHinDvlabmONh1Bu153rMUKbR" +
       "mKSJNV+iG5QkkFWgVIvl6TBWyoZfDMp1K20gFN+fsiNjgHeDodoWhRHer0Gi" +
       "M4vWMlNN0CW96rdKuCWakSTIEO9ICjWFB9x6quFjmYUxFczZ1mlzAeNNq0XQ" +
       "Ag1m2bBmI0W8OrLR9Uqz+/UiC6+qZK88duhayUUmC1Zo4GSXIOactKktCLoU" +
       "DMMNxQuESqp9xTAJJeBaclLT4dZCTGyWradIjDZDxo2nfkJjGPY12Susn76x" +
       "12j352/8jlb3796efewG3p7t1nFkyauvXCt7sbC3IvzEa9ET6wkL2TqtR09b" +
       "tJ+v0frQ297zrDL4cOlgtw5zEBbuDF3vq4/XsGybei1o6enTXyDT+Xvc4/WB" +
       "P/+2P3mE/1rjTTewAvrxPTr3m/wB+rlf7LxG/tcHhVuOVgte9TXFlZWeuXKN" +
       "4F2+Gka+w1+xUvDRI87emXHscXC8d8fZ9+6/cD6W3bXXCrx2K/u9Za4XjgvI" +
       "eYHf3Ctwch3sZ7PkN8LCHYEa5ivNrrWO6NbYNZVjHfqv13sDe7KT/MavHoG+" +
       "t7B71f7hHegP3xzQJzH9rzPyPp8lvw/w6ju8OZuOsf3BObDlAn0MHLv1H4Wr" +
       "1n/cJIH+xRkA/ypLvhgWbgcCBRNhO/v7O8f4/uy8snsQHJ/e4fv0zZfdP5ye" +
       "dyHv6v8AaPoxtBOi+9vziu5RcPz9Dtrf33TRBTmGu87Ad3eW3La1RSrzh1fK" +
       "7sLFcwB8cXbzZYCUu7Z1t+ebKrsLD56R93CW3L+1uyNswTG2B84rPOBILzy+" +
       "w/b4C2N3F151BsCsyQuPboWXrzvfE95jN8FpXnjdDuDrbr7wLp2Rly1AuvDU" +
       "VnhH2I4t78LTN8FpXsB22LCbLry35yD+2RkAX58lNRCKZE4zXwy6J736eU0P" +
       "uM0LzA4hc/OlR5yR180SDIDTT4J7+zG45nnF93JAp7oDp75A4hudgTBbj3uB" +
       "3o55lLhdy3ZCeMx5hfdSQEm0wxfdfOG98Yy8N2WJsB3zDqGdEN38vKLL1ne/" +
       "cwftnS+Q6BZn4MvGgQtqWLgnH/OyJcPXcp7aeSX4lYCg9+1gvu/mSzA+Iy9P" +
       "VgChfhXCE4L0zyvIpwCxz+0QPvcCCfJtZ8DM1iVfeHMI5oNq2NlfXL0nzm86" +
       "rzhfCcj6+A7sx2++ON91Rt67s+SdAKd+Cs4TQv228wr1SUDyp3Y4P/UCCfXf" +
       "ngH2/Vny3rBw70mhmum+eb7vvPLMBpDf2uH8rZsvz+87I+/7s+SDAKJ+NcQT" +
       "ovx35xVltu7+yzuIX76posz/738WtvfNChduLDUwVDUcuW6YA/+xs1t7bf6V" +
       "fP592dHq9kv88Tr3diKrXvaIJW8se8x04YfAMJVtVuAG+wrykfMqyMOFwsFL" +
       "t3W355urIJ88I+9ns+Qnw8KLgILMOIp3l2r+BdiJyctPnQNeXgwMTweP7eA9" +
       "dvPh/coZeb+WJb+4hce4isrsnl997BjeL51X918DYO2mLgfFF0T3X3fmJxkn" +
       "1LYHLCLH/dun+sULP54X+N0s+W9ApdVElaNwX6U/cw6mZA8asg+FDgY7pgxe" +
       "EKZcus7+FPzuX3atOluv8PkzVOVPs+R/AlXJvi11FNwwLSW79cfHXPnDc3Al" +
       "e8hceABwY7HjyuIGuFK4JkNuy/NuO2TIo9f+1HS3q09WSD5K8jr35bi/fD1V" +
       "+dss+VJYuFszHQVzZDXYxQInfMRfnIMz92Q3geEcvH/HmfffqL7MzmJPRt7f" +
       "nIb+4NbroD+4mF3+I+Buhp71VVlVwBg68A8ZMfA51dKuZMdB4RzsyIpmIcPB" +
       "Z3bs+My5FeVg+7n8ESfyh3UH910P+gNZ8qJtMIjvf+CcM/MY8d3n9aIPFQq3" +
       "fOW27vZ8sxD/zjHil18P8WNZ8tB2NpMjPv567HjEOHj4JgSEt3z9DuvX36iy" +
       "X9s5XlvEr70e4Kez5IltfAiUOzbdKMjGyT19fvK8iB8BSD+2Q/yxFxJx9XqI" +
       "61kChYUXA8S86O/igj288E2Ywt3y2R3ez55bm285ejW6g5rn7L3Gul1yXUsV" +
       "84j14A3XY0M7S57Z2nZu1kDND11acDiiPH7NrRgyfk3Uo+3ccoa9/rzmD0bG" +
       "W3cvZLfnF8D8h9djCpcl1PZZIuXK4vGmFPed2OjmOCOHTp8D+sPZzacB5N3j" +
       "4Vtv+PHwtYe+a+O/fD38YpbMw8IDmVXkW7Jsn6gCf3/IiO2OP1lAcfgp8LbI" +
       "MT++7ryq8BWAD9+x48d33Ezb2ca3P3DUW76tSUbZo9vetuewsLhZm7TZVr5z" +
       "UgD5agBlG+Gc3L3kcEu4f8LecgbR+/LP/2efFR+4u0/kD4Jrc/gg98ZZcrQu" +
       "46KlOvp2P5Os9IHjJftaeKg6Lzn+KBu3XEc9uenLdvs40710tM0kyEyuSemv" +
       "binNO8v+P7En8BMx/cFbzsj75ix5c1i4Tc6I2dJ+RvG3J4VjS7KvZ0nfkiUG" +
       "8BvbzTe2xkTtthM7EUqY5zCWw01sbru0rXvbDU8+r+08LuYFLh47j2uNNrfK" +
       "hugfSn2nUy/b2zTwaMQgxGAXSTUjTVP9nEXvvh4PvztLvn3rjQ79kLLlZFbn" +
       "eLZ68K/Oy0UQfF6Et3W353O5nJNq88Ez8v59lrx/G4rMVd+9ZrD5gXNge0l2" +
       "86sApt3wcvGGhhcwDnq+GwJnpCrXGWW22xjMc1QfOQPxj2TJ9wNzN52wHACw" +
       "IGA52gVqD/gPnAN47tmfAYDfuAP+DTdoGgfPXWcw2SHOir4nh/bxM2D/5yz5" +
       "KJhWZLCvBHxCiz92XkmDoPPiJ3eAP3lzAJ8U8aGNv/bUDbpm2a6/2U4XzchR" +
       "rHyvr4OfO4Mvv5QlPw34Evqigp2mCJ88L1/AsH77d23rbs83ly9ZKSzH8+kz" +
       "sH4mS341zPY3dPRyvqPMHs5fO2/g1AH4douzbr9Ji7P2hvDXnPHMLXt6PDED" +
       "c/twaMeR3zuDI3+YJb8TFu4H8bSVP27bVQ/2DOO/3whjEsDi4+1ps/01H75q" +
       "N+ztDs7yR569946Hnh3/5najncNdlu+kCndokWWd3A7xxPVFz1c1M2fWnXl6" +
       "j5ej+UJYeOR07mTrQA+v8zjpT7a1/gyECPu1QEiSn0+W+xJAdVwOhF3bi5NF" +
       "/ios3AKKZJd/ncn8wh8n24Dp4ZMqkzG0cN3lSCcWvD5xxTLVfP/xwyWl0XYH" +
       "8svyDz9LMt/4pfqHt1vGypaYplkrd1CF27e71+aNZstSX3lqa4dtXew+9Xf3" +
       "/Midrz5cQnvPluBj9T1B2+PX3pO1bXthvotq+hMP/cfX/4dnfzffUPL/AeiR" +
       "EJgYXgAA");
}
