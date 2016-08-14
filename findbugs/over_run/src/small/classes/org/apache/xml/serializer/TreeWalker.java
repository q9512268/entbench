package org.apache.xml.serializer;
public final class TreeWalker {
    private final org.xml.sax.ContentHandler m_contentHandler;
    private final org.apache.xml.serializer.SerializationHandler m_Serializer;
    protected final org.apache.xml.serializer.utils.DOM2Helper m_dh;
    private final org.xml.sax.helpers.LocatorImpl m_locator = new org.xml.sax.helpers.LocatorImpl(
      );
    public org.xml.sax.ContentHandler getContentHandler() { return m_contentHandler;
    }
    public TreeWalker(org.xml.sax.ContentHandler ch) { this(
                                                         ch,
                                                         null);
    }
    public TreeWalker(org.xml.sax.ContentHandler contentHandler,
                      java.lang.String systemId) { super(
                                                     );
                                                   m_contentHandler =
                                                     contentHandler;
                                                   if (m_contentHandler instanceof org.apache.xml.serializer.SerializationHandler) {
                                                       m_Serializer =
                                                         (org.apache.xml.serializer.SerializationHandler)
                                                           m_contentHandler;
                                                   }
                                                   else
                                                       m_Serializer =
                                                         null;
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
                                                     new org.apache.xml.serializer.utils.DOM2Helper(
                                                       );
    }
    public void traverse(org.w3c.dom.Node pos)
          throws org.xml.sax.SAXException {
        this.
          m_contentHandler.
          startDocument(
            );
        org.w3c.dom.Node top =
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
        }
        this.
          m_contentHandler.
          endDocument(
            );
    }
    public void traverse(org.w3c.dom.Node pos,
                         org.w3c.dom.Node top)
          throws org.xml.sax.SAXException {
        this.
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
          throws org.xml.sax.SAXException {
        if (m_Serializer !=
              null) {
            this.
              m_Serializer.
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
                org.w3c.dom.Element elem_node =
                  (org.w3c.dom.Element)
                    node;
                {
                    java.lang.String uri =
                      elem_node.
                      getNamespaceURI(
                        );
                    if (uri !=
                          null) {
                        java.lang.String prefix =
                          elem_node.
                          getPrefix(
                            );
                        if (prefix ==
                              null)
                            prefix =
                              "";
                        this.
                          m_contentHandler.
                          startPrefixMapping(
                            prefix,
                            uri);
                    }
                }
                org.w3c.dom.NamedNodeMap atts =
                  elem_node.
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
                    final org.w3c.dom.Node attr =
                      atts.
                      item(
                        i);
                    final java.lang.String attrName =
                      attr.
                      getNodeName(
                        );
                    final int colon =
                      attrName.
                      indexOf(
                        ':');
                    final java.lang.String prefix;
                    if (attrName.
                          equals(
                            "xmlns") ||
                          attrName.
                          startsWith(
                            "xmlns:")) {
                        if (colon <
                              0)
                            prefix =
                              "";
                        else
                            prefix =
                              attrName.
                                substring(
                                  colon +
                                    1);
                        this.
                          m_contentHandler.
                          startPrefixMapping(
                            prefix,
                            attr.
                              getNodeValue(
                                ));
                    }
                    else
                        if (colon >
                              0) {
                            prefix =
                              attrName.
                                substring(
                                  0,
                                  colon);
                            java.lang.String uri =
                              attr.
                              getNamespaceURI(
                                );
                            if (uri !=
                                  null)
                                this.
                                  m_contentHandler.
                                  startPrefixMapping(
                                    prefix,
                                    uri);
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
                    new org.apache.xml.serializer.utils.AttList(
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
                if (m_Serializer ==
                      null) {
                    org.w3c.dom.Element elem_node =
                      (org.w3c.dom.Element)
                        node;
                    org.w3c.dom.NamedNodeMap atts =
                      elem_node.
                      getAttributes(
                        );
                    int nAttrs =
                      atts.
                      getLength(
                        );
                    for (int i =
                           nAttrs -
                           1;
                         0 <=
                           i;
                         i--) {
                        final org.w3c.dom.Node attr =
                          atts.
                          item(
                            i);
                        final java.lang.String attrName =
                          attr.
                          getNodeName(
                            );
                        final int colon =
                          attrName.
                          indexOf(
                            ':');
                        final java.lang.String prefix;
                        if (attrName.
                              equals(
                                "xmlns") ||
                              attrName.
                              startsWith(
                                "xmlns:")) {
                            if (colon <
                                  0)
                                prefix =
                                  "";
                            else
                                prefix =
                                  attrName.
                                    substring(
                                      colon +
                                        1);
                            this.
                              m_contentHandler.
                              endPrefixMapping(
                                prefix);
                        }
                        else
                            if (colon >
                                  0) {
                                prefix =
                                  attrName.
                                    substring(
                                      0,
                                      colon);
                                this.
                                  m_contentHandler.
                                  endPrefixMapping(
                                    prefix);
                            }
                    }
                    {
                        java.lang.String uri =
                          elem_node.
                          getNamespaceURI(
                            );
                        if (uri !=
                              null) {
                            java.lang.String prefix =
                              elem_node.
                              getPrefix(
                                );
                            if (prefix ==
                                  null)
                                prefix =
                                  "";
                            this.
                              m_contentHandler.
                              endPrefixMapping(
                                prefix);
                        }
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
       "jiAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e/Akx13f3k/S6e6QdScZ20KxJVk6A9LCb96zuzkbPDv7" +
       "mNmd3ZndnX3yOM+jZ2d23q/d2SXi4UqwClKOK5HBVEB/mSIYgyEVAlVAohSV" +
       "gIGiQoqQhEowoVKxE+wUTiUkhRNIz+zvffc7SZjKVk3vzPS3u7+fb3/709/p" +
       "7k9/qfRIHJXKge9sl46fHIIsOVw51GGyDUB82BEoSYlioLOOEscyfHdXe/5n" +
       "b/7pVz5m3jooXV2U3q54np8oieV78RDEvrMGulC6efq26QA3Tkq3hJWyVpA0" +
       "sRxEsOLkjlD6mjNFk9Jt4VgFBKqAQBWQQgWEOZWChd4GvNRl8xKKl8Rh6btL" +
       "V4TS1UDL1UtK7z1fSaBEintUjVQggDVcy58nEFRROItKz51g32O+B/DHy8ir" +
       "P/ydt/7hQ6Wbi9JNyxvl6mhQiQQ2sig95gJXBVHM6DrQF6UnPAD0EYgsxbF2" +
       "hd6L0pOxtfSUJI3AiZHyl2kAoqLNU8s9puXYolRL/OgEnmEBRz9+esRwlCXE" +
       "+s5TrHuErfw9BHjDgopFhqKB4yIP25anJ6VnL5Y4wXi7CwVg0UddkJj+SVMP" +
       "ewp8UXpy33eO4i2RURJZ3hKKPuKnsJWk9PSllea2DhTNVpbgblJ66qKctM+C" +
       "UtcLQ+RFktI7LooVNcFeevpCL53pny/13//R7/I476DQWQeak+t/DRZ65kKh" +
       "ITBABDwN7As+9pLwQ8o7f+WVg1IJCr/jgvBe5hf+xpc/+E3PvP7re5m/dh8Z" +
       "UV0BLbmrfVJ9/Hfezb5YeyhX41rgx1be+eeQF+4vHeXcyQI48t55UmOeeXic" +
       "+frwX8y/91Pgjw9KN/jSVc13Uhf60ROa7waWA6I28ECkJEDnS9eBp7NFPl96" +
       "FN4Llgf2b0XDiEHClx52ildX/eIZmsiAVeQmehTeW57hH98HSmIW91lQKpXe" +
       "Bq/Sk/DCS/tf8Z+UAGL6LkAUTfEsz0ekyM/x5x3q6QqSgBje6zA38JFMgU7z" +
       "zau7+N3KXRyJIw3xoyWiQK8wAZK5DhIfjRMQIXIEwFRxbBAd5u4W/P9qKMsR" +
       "39pcuQI7490XqcCBo4jzHR1Ed7VX03rzyz9z9zcPTobGka0gecHWDvetHcLW" +
       "Dk9bOzxtrXTlStHI1+at7nsb9pUNRz3kw8deHH1H50OvPP8QdLNg8zA09AEU" +
       "RS6nZfaUJ/iCDTXorKXXP7H5vsn3oAelg/P8mmsKX93Ii0s5K56w3+2L4+p+" +
       "9d78yBf+9DM/9LJ/OsLOEfbRwL+3ZD5wn79o08jXgA6p8LT6l55Tfv7ur7x8" +
       "+6D0MGQDyICJAj0WksszF9s4N4DvHJNhjuURCNjwI1dx8qxjBruRmJG/OX1T" +
       "dPbjxf0T0MbXc49+O7ykIxcv/vPctwd5+rV758g77QKKgmw/MAp+7N/+9n8h" +
       "CnMf8/LNMzPdCCR3znBBXtnNYtQ/ceoDuYNAuf/wCenvffxLH/m2wgGgxAv3" +
       "a/B2nrKQA2AXQjP/rV8P/93n/uCTv3tw4jRXEjgZpqpjadkJyIMc07UHgISt" +
       "ff2pPpBLHDjMcq+5PfZcX7cMS1EdkHvp/7n5Puznv/jRW3s/cOCbYzf6pjeu" +
       "4PT919VL3/ub3/m/nimquaLlc9mpzU7F9gT59tOamShStrke2ff9q/f8yK8p" +
       "PwapFtJbDAdawVhX9jYokL8DTk35qCyGo5IdFtO1l3CQOyB/Fv2KFIIvFelh" +
       "bpOieKnII/Lk2fjs+Dg/BM+EJXe1j/3un7xt8if/5MsFoPNxzVl36CnBnb0H" +
       "5slzGaz+XRfJgFNiE8qRr/e//Zbz+ldgjQtYowYn81iMIA9l55znSPqRR3//" +
       "n/3qOz/0Ow+VDlqlG46v6C2lGIel63AAgNiEFJYF3/rBff9vcme4VUAt3QO+" +
       "ePH0vSNkduQ8s/uPkDx9b568716/u6zoBfMf7Gkvf0SPu/BWATWPPA73kUfR" +
       "3Acf0HGNPLlTZJF58v49osqbAr+Xfap4ugZ758XL+beVx2SnFPbUn4mO+uE/" +
       "+t/3eEDBvPcJRS6UXyCf/tGn2W/546L8KQXmpZ/J7p2YYPx6Whb/lPs/D56/" +
       "+s8PSo8uSre0o+B4ojhpTiwLGBDGxxEzDKDP5Z8P7vaRzJ0Tin/3Rfo90+xF" +
       "8j2dEOF9Lp3f37jAt4XdUXjRRy5BX/SmK6Xipr93qCK9nSffsHeOpPRoEFlr" +
       "GPkksHnLU5wjnvsL+LsCrz/Pr7zS/MU+XnmSPQqanjuJmgI4Z99y72rnOKFw" +
       "vFNvLrxHfCPv4c9jy0OkO0fY7lyCbX4Jtvx2mCejwmpyAr8s7o5OIonjIXF4" +
       "eaxx7qvjDKozgBZvHlAe+pWehxdzBIi5BJB6aWddDyI/gS4F9HO4Hnbv6uYx" +
       "npcux5NTXHzYEHs4B5zgHizaW+ycvw6vxhGWxiVYnDfdOdfdu46vKcffaRDJ" +
       "s2fnG7PQOD4U9jK8GzgX1HffvPoFlb4bXp8/Uv/zl6if3l/90onSHiQyPh4q" +
       "mwezmxRZLgxZ1kcfSsjLT37O/tEv/PT+I+gilV0QBq+8+gN/cfjRVw/OfHq+" +
       "cM/X39ky+8/PQse3FYrmM+N7H9RKUaL1+c+8/Ev/4OWP7LV68vyHVNNL3Z/+" +
       "vf/7W4ef+MPP3idif1T1fQco3oU+Wb9hn+z1uwIDrUfww8phQRh/8/5Wfyi/" +
       "/UYYkcXFgsE573nXytFuHxPTBDoKHLG3V04lz2YuKCW/aaWg2R4/nTEFH36p" +
       "/+B/+thv/Z0XPgdN0Ck9ss45H9rqzLTaT/PFi+//9Mff8zWv/uEPFpEkDKEk" +
       "Bf37v5jX+rcfBC1PXjkH6+kc1shPIw0ISpz0iuAP6DmyoordGTzfDYnAgSr+" +
       "pdEmN3+ZI2OeOf4J2ALgGy0buoZYNSRRaq46jRZF7ky+N2M4cjILHZEnWXlO" +
       "ZbRG1sUQnfUWFQ2Zu6CSqoTsVZqB37ZbfozYyyG7GOHN1iQcM3F/hSlOYxv6" +
       "Xdyqj4OAVWb2ROm2RoAfdZFWq+cvhmWiugMV0E93G3spiBipIkZlHXhGjaos" +
       "NnhZVpLYqozUCbqT2zrl9VbWLJNsO3HpSaXfjlS33ApGkWdyyJqQ1ziFJL4f" +
       "Dm0rRkFAKLWBS2Mzd6HgZtW0JqpGYcOJq+KDeDXMOlbN67XDvtY3BmbPAVi5" +
       "0oWu5YeVnTFqMC4+ZpP61Fp5zirUSHonNbVGB/WHc3myjTsJqXdEs2s31VaP" +
       "A1SDSaqNBg501FJ1AHbi1BHVrr7qdyqr0FxIYUNdb5213ehLA93H/LpfziS+" +
       "lmBVimhxrQW53oz6qmxgiJzWd0DsL2Ns123TqsfUUb3SVJs9dV62m8qsa0RJ" +
       "f44lVGdtK2HTHbkmZckre2iiK7PX9vUOS5h611nVhK7qxSu8vez1BNsNevWh" +
       "0dxOnTI/UjClPx/a2TCqLx2M6DVTl+GgpQVlGdmNZrta5onKcoppGEKPun0G" +
       "H3acsZGJYz9mlqK92dYHjoO7LQfXd1EftUV7OACNxq4jBIuQxistHKYi3ZG9" +
       "DTPuKnGbExf9xdymZhO83tm0VafVpubD2XJBTmQxKoe9oa0x9G4zC9ERyQXV" +
       "xoaZT1ruwulKFtjsOiuTDj1ziFDi3J+LuznDqI3pwrSN/jyQdzoTSCyboPYY" +
       "DX2kWa9yVK3eXEayytRHhKlsW+xY19zJTB00F6oVsBjvUKP1shuALtNZiB1b" +
       "7dTF0abpC4yjbnHRSOBYJ2YKQdBOc7SUp56rCGbZ1ViU4hl0q0znQ6Uhdtje" +
       "aoF3pmWrWt8Cy2QaGcGwWSB51ISsGVqqjLaaZu80fttnpAZOeey4Gpqk7kgC" +
       "CBZg0pwIoST225vJCtQaQsjHtLoLtkE6UMB80gGCMBU5h+qqhgFcJa2Z6lgX" +
       "BkPcHw+qibOZ15QW249CM9wJ7piOt6ZHy9RohwzRFbEyhnhkSiEXyg1S37aH" +
       "cbZe840mWg1XXFPF6sO6PVpaZrScJePdMOVAwGVjQtT7g3gZp9B8s27KI3UJ" +
       "EacwYyQJpDMy09BXq8rQ4TkSDXtLaserlb6wwVYzCywTUUtkHOt6E1NxZloS" +
       "jMj5nGh2Z6tWl197MRZpetptTg2u33L7s3Eb5WJc8NV04fUnTdDUqosVKjNt" +
       "PmXDMdvoij6WNEa7cRzWiU6AZeVaRxpxeqMpNdDh2BaoZdJxgbCZbjK9oszF" +
       "LO0MewM7KLMxmgTLMEMHtUUdb2OaaKTTrTqUkgmou9R62Rtzg/GoWV13x72a" +
       "6vk+JY3G2toK5Emf89wt2UVDy2622/5gSyVKozHZJHZX7fVMZWy255OJOe64" +
       "K96YLVUh4jsisXLKlQVAFnOTADVIl+G2ueNn8cgmOpnlU8tpB8g4IdfoMgJA" +
       "NQabDbaZVVDfEeyRHG/Uyrgt1+O25/QopyZVxksipn130O6wfX7TydhNs55O" +
       "s662oTQkXYZUW+DGDGB78+k0MMNql1VH9RUWtVMpaZZboZA2qi25tZUYecxF" +
       "4UCeAx5ZB5hHrkyjbKm0zLAwd2K0G8O1UaYlldpEWAv1WRQHYFXhQUfzWgp0" +
       "zKCFTp3NbChVm2mgpzKgkTIgomQTIQwZwWGkxhuhyY1Ndt7sy9WapuPSGulu" +
       "SQCs4aLWj7tmKwVtXyE6LbTVbk76en3R8KkyRfOdSdAUZ35/iM/oMjtRbMXZ" +
       "ZFGDl5w1Sga7yqqMR5hHLwcLiXUplFoPWEIEXmRxM4njJlidNzthZ9mdTTAq" +
       "EDpIY8fBT/ZkOhvMIquPVHRRWCOovx6iW2k6nLXLHa3T2/IY32KIpTJpLkR2" +
       "y8xRLpP0ZUxVeINcGoO04lkaT+J8tUWMLZx3yNrO1kQ3WxuS2UD7vUmwGKge" +
       "4XhYsCC4lZ8ykqd2w2ql1hJ3I8JfNqz1lueocq9uYGMvHtM9WiWklbNwiS1D" +
       "MWS9zk9odhYzg/Vo3q94EkNhOkCFNeGQRATDK9tEpak3aHQCIKNjzfZ8nmkr" +
       "0mCp9l2sXB32A4Tr4OZ0zDgdUB9S47XQJvo6lg5ZRE2QnlH2QqK2qbZnpo4K" +
       "LJl0B2kiZDAOFMxsJAZlaTAFoT9XNnWAThw3Vgwq02PC2k5XATaSuUV3HgVC" +
       "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");
}
