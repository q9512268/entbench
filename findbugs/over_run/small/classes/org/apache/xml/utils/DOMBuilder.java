package org.apache.xml.utils;
public class DOMBuilder implements org.xml.sax.ContentHandler, org.xml.sax.ext.LexicalHandler {
    public org.w3c.dom.Document m_doc;
    protected org.w3c.dom.Node m_currentNode = null;
    protected org.w3c.dom.Node m_root = null;
    protected org.w3c.dom.Node m_nextSibling = null;
    public org.w3c.dom.DocumentFragment m_docFrag = null;
    protected java.util.Stack m_elemStack = new java.util.Stack();
    protected java.util.Vector m_prefixMappings = new java.util.Vector();
    public DOMBuilder(org.w3c.dom.Document doc, org.w3c.dom.Node node) { super(
                                                                           );
                                                                         m_doc =
                                                                           doc;
                                                                         m_currentNode =
                                                                           (m_root =
                                                                              node);
                                                                         if (node instanceof org.w3c.dom.Element)
                                                                             m_elemStack.
                                                                               push(
                                                                                 node);
    }
    public DOMBuilder(org.w3c.dom.Document doc,
                      org.w3c.dom.DocumentFragment docFrag) {
        super(
          );
        m_doc =
          doc;
        m_docFrag =
          docFrag;
    }
    public DOMBuilder(org.w3c.dom.Document doc) {
        super(
          );
        m_doc =
          doc;
    }
    public org.w3c.dom.Node getRootDocument() {
        return null !=
          m_docFrag
          ? (org.w3c.dom.Node)
              m_docFrag
          : (org.w3c.dom.Node)
              m_doc;
    }
    public org.w3c.dom.Node getRootNode() {
        return m_root;
    }
    public org.w3c.dom.Node getCurrentNode() {
        return m_currentNode;
    }
    public void setNextSibling(org.w3c.dom.Node nextSibling) {
        m_nextSibling =
          nextSibling;
    }
    public org.w3c.dom.Node getNextSibling() {
        return m_nextSibling;
    }
    public java.io.Writer getWriter() { return null;
    }
    protected void append(org.w3c.dom.Node newNode)
          throws org.xml.sax.SAXException {
        org.w3c.dom.Node currentNode =
          m_currentNode;
        if (null !=
              currentNode) {
            if (currentNode ==
                  m_root &&
                  m_nextSibling !=
                  null)
                currentNode.
                  insertBefore(
                    newNode,
                    m_nextSibling);
            else
                currentNode.
                  appendChild(
                    newNode);
        }
        else
            if (null !=
                  m_docFrag) {
                if (m_nextSibling !=
                      null)
                    m_docFrag.
                      insertBefore(
                        newNode,
                        m_nextSibling);
                else
                    m_docFrag.
                      appendChild(
                        newNode);
            }
            else {
                boolean ok =
                  true;
                short type =
                  newNode.
                  getNodeType(
                    );
                if (type ==
                      org.w3c.dom.Node.
                        TEXT_NODE) {
                    java.lang.String data =
                      newNode.
                      getNodeValue(
                        );
                    if (null !=
                          data &&
                          data.
                          trim(
                            ).
                          length(
                            ) >
                          0) {
                        throw new org.xml.sax.SAXException(
                          org.apache.xml.res.XMLMessages.
                            createXMLMessage(
                              org.apache.xml.res.XMLErrorResources.
                                ER_CANT_OUTPUT_TEXT_BEFORE_DOC,
                              null));
                    }
                    ok =
                      false;
                }
                else
                    if (type ==
                          org.w3c.dom.Node.
                            ELEMENT_NODE) {
                        if (m_doc.
                              getDocumentElement(
                                ) !=
                              null) {
                            ok =
                              false;
                            throw new org.xml.sax.SAXException(
                              org.apache.xml.res.XMLMessages.
                                createXMLMessage(
                                  org.apache.xml.res.XMLErrorResources.
                                    ER_CANT_HAVE_MORE_THAN_ONE_ROOT,
                                  null));
                        }
                    }
                if (ok) {
                    if (m_nextSibling !=
                          null)
                        m_doc.
                          insertBefore(
                            newNode,
                            m_nextSibling);
                    else
                        m_doc.
                          appendChild(
                            newNode);
                }
            }
    }
    public void setDocumentLocator(org.xml.sax.Locator locator) {
        
    }
    public void startDocument() throws org.xml.sax.SAXException {
        
    }
    public void endDocument() throws org.xml.sax.SAXException {
        
    }
    public void startElement(java.lang.String ns,
                             java.lang.String localName,
                             java.lang.String name,
                             org.xml.sax.Attributes atts)
          throws org.xml.sax.SAXException {
        org.w3c.dom.Element elem;
        if (null ==
              ns ||
              ns.
              length(
                ) ==
              0)
            elem =
              m_doc.
                createElementNS(
                  null,
                  name);
        else
            elem =
              m_doc.
                createElementNS(
                  ns,
                  name);
        append(
          elem);
        try {
            int nAtts =
              atts.
              getLength(
                );
            if (0 !=
                  nAtts) {
                for (int i =
                       0;
                     i <
                       nAtts;
                     i++) {
                    if (atts.
                          getType(
                            i).
                          equalsIgnoreCase(
                            "ID"))
                        setIDAttribute(
                          atts.
                            getValue(
                              i),
                          elem);
                    java.lang.String attrNS =
                      atts.
                      getURI(
                        i);
                    if ("".
                          equals(
                            attrNS))
                        attrNS =
                          null;
                    java.lang.String attrQName =
                      atts.
                      getQName(
                        i);
                    if (attrQName.
                          startsWith(
                            "xmlns:") ||
                          attrQName.
                          equals(
                            "xmlns")) {
                        attrNS =
                          "http://www.w3.org/2000/xmlns/";
                    }
                    elem.
                      setAttributeNS(
                        attrNS,
                        attrQName,
                        atts.
                          getValue(
                            i));
                }
            }
            int nDecls =
              m_prefixMappings.
              size(
                );
            java.lang.String prefix;
            java.lang.String declURL;
            for (int i =
                   0;
                 i <
                   nDecls;
                 i +=
                   2) {
                prefix =
                  (java.lang.String)
                    m_prefixMappings.
                    elementAt(
                      i);
                if (prefix ==
                      null)
                    continue;
                declURL =
                  (java.lang.String)
                    m_prefixMappings.
                    elementAt(
                      i +
                        1);
                elem.
                  setAttributeNS(
                    "http://www.w3.org/2000/xmlns/",
                    prefix,
                    declURL);
            }
            m_prefixMappings.
              clear(
                );
            m_elemStack.
              push(
                elem);
            m_currentNode =
              elem;
        }
        catch (java.lang.Exception de) {
            throw new org.xml.sax.SAXException(
              de);
        }
    }
    public void endElement(java.lang.String ns,
                           java.lang.String localName,
                           java.lang.String name)
          throws org.xml.sax.SAXException {
        m_elemStack.
          pop(
            );
        m_currentNode =
          m_elemStack.
            isEmpty(
              )
            ? null
            : (org.w3c.dom.Node)
                m_elemStack.
                peek(
                  );
    }
    public void setIDAttribute(java.lang.String id,
                               org.w3c.dom.Element elem) {
        
    }
    public void characters(char[] ch, int start,
                           int length) throws org.xml.sax.SAXException {
        if (isOutsideDocElem(
              ) &&
              org.apache.xml.utils.XMLCharacterRecognizer.
              isWhiteSpace(
                ch,
                start,
                length))
            return;
        if (m_inCData) {
            cdata(
              ch,
              start,
              length);
            return;
        }
        java.lang.String s =
          new java.lang.String(
          ch,
          start,
          length);
        org.w3c.dom.Node childNode;
        childNode =
          m_currentNode !=
            null
            ? m_currentNode.
            getLastChild(
              )
            : null;
        if (childNode !=
              null &&
              childNode.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                TEXT_NODE) {
            ((org.w3c.dom.Text)
               childNode).
              appendData(
                s);
        }
        else {
            org.w3c.dom.Text text =
              m_doc.
              createTextNode(
                s);
            append(
              text);
        }
    }
    public void charactersRaw(char[] ch, int start,
                              int length)
          throws org.xml.sax.SAXException {
        if (isOutsideDocElem(
              ) &&
              org.apache.xml.utils.XMLCharacterRecognizer.
              isWhiteSpace(
                ch,
                start,
                length))
            return;
        java.lang.String s =
          new java.lang.String(
          ch,
          start,
          length);
        append(
          m_doc.
            createProcessingInstruction(
              "xslt-next-is-raw",
              "formatter-to-dom"));
        append(
          m_doc.
            createTextNode(
              s));
    }
    public void startEntity(java.lang.String name)
          throws org.xml.sax.SAXException {
        
    }
    public void endEntity(java.lang.String name)
          throws org.xml.sax.SAXException {
        
    }
    public void entityReference(java.lang.String name)
          throws org.xml.sax.SAXException {
        append(
          m_doc.
            createEntityReference(
              name));
    }
    public void ignorableWhitespace(char[] ch,
                                    int start,
                                    int length)
          throws org.xml.sax.SAXException {
        if (isOutsideDocElem(
              ))
            return;
        java.lang.String s =
          new java.lang.String(
          ch,
          start,
          length);
        append(
          m_doc.
            createTextNode(
              s));
    }
    private boolean isOutsideDocElem() { return null ==
                                           m_docFrag &&
                                           m_elemStack.
                                           size(
                                             ) ==
                                           0 &&
                                           (null ==
                                              m_currentNode ||
                                              m_currentNode.
                                              getNodeType(
                                                ) ==
                                              org.w3c.dom.Node.
                                                DOCUMENT_NODE);
    }
    public void processingInstruction(java.lang.String target,
                                      java.lang.String data)
          throws org.xml.sax.SAXException {
        append(
          m_doc.
            createProcessingInstruction(
              target,
              data));
    }
    public void comment(char[] ch, int start,
                        int length) throws org.xml.sax.SAXException {
        append(
          m_doc.
            createComment(
              new java.lang.String(
                ch,
                start,
                length)));
    }
    protected boolean m_inCData = false;
    public void startCDATA() throws org.xml.sax.SAXException {
        m_inCData =
          true;
        append(
          m_doc.
            createCDATASection(
              ""));
    }
    public void endCDATA() throws org.xml.sax.SAXException {
        m_inCData =
          false;
    }
    public void cdata(char[] ch, int start,
                      int length) throws org.xml.sax.SAXException {
        if (isOutsideDocElem(
              ) &&
              org.apache.xml.utils.XMLCharacterRecognizer.
              isWhiteSpace(
                ch,
                start,
                length))
            return;
        java.lang.String s =
          new java.lang.String(
          ch,
          start,
          length);
        org.w3c.dom.CDATASection section =
          (org.w3c.dom.CDATASection)
            m_currentNode.
            getLastChild(
              );
        section.
          appendData(
            s);
    }
    public void startDTD(java.lang.String name,
                         java.lang.String publicId,
                         java.lang.String systemId)
          throws org.xml.sax.SAXException {
        
    }
    public void endDTD() throws org.xml.sax.SAXException {
        
    }
    public void startPrefixMapping(java.lang.String prefix,
                                   java.lang.String uri)
          throws org.xml.sax.SAXException {
        if (null ==
              prefix ||
              prefix.
              length(
                ) ==
              0)
            prefix =
              "xmlns";
        else
            prefix =
              "xmlns:" +
              prefix;
        m_prefixMappings.
          addElement(
            prefix);
        m_prefixMappings.
          addElement(
            uri);
    }
    public void endPrefixMapping(java.lang.String prefix)
          throws org.xml.sax.SAXException {
        
    }
    public void skippedEntity(java.lang.String name)
          throws org.xml.sax.SAXException {
        
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1bDXAcxZXuHf3L1o9lLBT5X5ZNbMxujME+kDHYkozlrGQh" +
       "GcHJh9ej2ZE09u7MeKZXWht8xhQBJ3VHCBiOC1hJETsBx7FTl5AjXAV8dSE/" +
       "RRJiw10g3PETKgcJUIWPik2OI9x7PT07s7M7s17YRFXTO5ru193f169fv37T" +
       "c+wdUmEapE0X1bgYprt12Qz3432/aJhyvDMhmuYWeBqTvvDavfvOPVezXyCV" +
       "w6R+XDR7JdGUNyhyIm4Ok7mKalJRlWSzT5bjKNFvyKZsTIhU0dRhMksxe5J6" +
       "QpEU2qvFZSwwJBpRMkOk1FBGUlTu4RVQMj/KehNhvYms8xboiJLpkqbvdgRa" +
       "swQ6XXlYNum0Z1LSGN0hToiRFFUSkahi0o60QS7WtcTusYRGw3KahnckLudE" +
       "bIpenkND27cbzn5w93gjo2GmqKoaZRDNAdnUEhNyPEoanKfdCTlp7iJ/S8qi" +
       "ZJqrMCXtUbvRCDQagUZtvE4p6H2drKaSnRqDQ+2aKnUJO0TJwuxKdNEQk7ya" +
       "ftZnqKGacuxMGNAuyKC1h9sD8b6LIwf/YVvjP5WRhmHSoKiD2B0JOkGhkWEg" +
       "VE6OyIa5Lh6X48NkhgoDPigbiphQ9vDRbjKVMVWkKVABmxZ8mNJlg7XpcAUj" +
       "CdiMlEQ1IwNvlCkV/69iNCGOAdZmB6uFcAM+B4C1CnTMGBVB97hI+U5FjTM9" +
       "ypbIYGz/LBQA0aqkTMe1TFPlqggPSJOlIglRHYsMgvKpY1C0QgMVNJiu+VSK" +
       "XOuitFMck2OUtHjL9VtZUKqGEYEilMzyFmM1wSi1ekbJNT7v9K2562Z1oyqQ" +
       "EPQ5LksJ7P80EJrnERqQR2VDhnlgCU5fFr1fbP7BAYEQKDzLU9gq88+3nLlm" +
       "+byTP7HKzM5TZvPIDlmiMenwSP2pOZ1LryjDblTrmqng4GchZ7Osn+d0pHWw" +
       "NM2ZGjEzbGeeHPjRX996VH5LILU9pFLSEqkk6NEMSUvqSkI2rpVV2RCpHO8h" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Bo40proZheNLWuJVk5NMdTWZLNy0r/ZVN5CoDQYTZoT1NGSkbRfrKgz8A7qO" +
       "B+K4PQyXSqc52HYDFoOFvhdPk8Vm4ZJCtVmGprhSRettt8doCay6MRU2rOqU" +
       "WPU3OlURybIFbzNgjuBsQBrSRmlA8mSjQq32iqTmct9oeVum0kNoseIs0Kxi" +
       "iWIKoTMDSXVjtWI67ZhSJpRQy2KCXYh9XF33EX5N6vVwGqJob+I7fZjCeu1g" +
       "tjQZjXf7GGTQiTB0J4soMbIOWkbrVizQW1aU8BmzlWAHQc2OEkXQZtvWzMjd" +
       "zNgqTEBTpoupLYjTNnpD8OrdIY7P5zUrLEcNqdGa6FA3oGJHm+JjZYJEsW6Q" +
       "JI762IBdtJt6xa+aDQjId0QMppNpuxJ1V2QrwHXgAWA8HrRrQVcmQk6KEF+Y" +
       "zby0GXnIvIY6BpQ4bRiDGvF2trKzVFl5kJrovAx5xnbu8kgV3RoRGs3NWCOX" +
       "kEBtm+rQkEZy2ZDjut2MygMTG/Qroal2ZJRa6GWPr7fLRBytvLZIwULbd9JU" +
       "lQiLCeIhh9eGZQXz5xS21KSy5paT8tTXXH4K454Oq6gYknqsbtdGwhhjvVue" +
       "KVUnNKeRI9Z1cbas0MRsvmiPV4q3HTld1ZnP+sO5vlg2NvWRN1tadSVaVZgM" +
       "MWi/G3anmOdMmqkG25g0dMZCX1FkuMEqrjlJ+sLCc8V0uuzADjty5jA9aJHl" +
       "Ts0ctHBYQ+fDdUREUjMZoCYqVq1Wk61sCNTFYonrWQoiMdsR21+lLsQvIhrp" +
       "sajQC+ox2grToN+EKXFKNnA7NC3ZWpRnAdqEvKrjeuts1ta2WoIiK71aXjMw" +
       "QjRlltICZlDrlXsdIWjo1a7qhWq4mDZRZVqGhMqo00mNeDARiLRXp8bAQozX" +
       "QlPtIlNYZqYj2G37WWPeqm0EJfd3KbJoVKHGYMU0omiD+qaCeDMPdJ+IE7ZT" +
       "q5V9J+wiEDvzQliBmlV2u91EkK4pZlgRthvNdowNsChpRGSpYeMElPCrKg/H" +
       "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" +
       "NdtMnDH4wuIXrTGvNHB3Qs4hzsZrIdn1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
