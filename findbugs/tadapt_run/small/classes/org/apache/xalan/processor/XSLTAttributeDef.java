package org.apache.xalan.processor;
public class XSLTAttributeDef {
    static final int FATAL = 0;
    static final int ERROR = 1;
    static final int WARNING = 2;
    XSLTAttributeDef(java.lang.String namespace, java.lang.String name, int type,
                     boolean required,
                     boolean supportsAVT,
                     int errorType) { super();
                                      this.m_namespace = namespace;
                                      this.m_name = name;
                                      this.m_type = type;
                                      this.m_required = required;
                                      this.m_supportsAVT = supportsAVT;
                                      this.m_errorType = errorType;
    }
    XSLTAttributeDef(java.lang.String namespace, java.lang.String name,
                     int type,
                     boolean supportsAVT,
                     int errorType,
                     java.lang.String defaultVal) { super();
                                                    this.m_namespace =
                                                      namespace;
                                                    this.m_name =
                                                      name;
                                                    this.m_type =
                                                      type;
                                                    this.m_required =
                                                      false;
                                                    this.m_supportsAVT =
                                                      supportsAVT;
                                                    this.m_errorType =
                                                      errorType;
                                                    this.m_default =
                                                      defaultVal;
    }
    XSLTAttributeDef(java.lang.String namespace, java.lang.String name,
                     boolean required,
                     boolean supportsAVT,
                     boolean prefixedQNameValAllowed,
                     int errorType,
                     java.lang.String k1,
                     int v1,
                     java.lang.String k2,
                     int v2) { super();
                               this.m_namespace = namespace;
                               this.m_name = name;
                               this.m_type = prefixedQNameValAllowed
                                               ? this.
                                                   T_ENUM_OR_PQNAME
                                               : this.
                                                   T_ENUM;
                               this.m_required = required;
                               this.m_supportsAVT = supportsAVT;
                               this.m_errorType = errorType;
                               m_enums = new org.apache.xml.utils.StringToIntTable(
                                           2);
                               m_enums.put(k1, v1);
                               m_enums.put(k2, v2); }
    XSLTAttributeDef(java.lang.String namespace, java.lang.String name,
                     boolean required,
                     boolean supportsAVT,
                     boolean prefixedQNameValAllowed,
                     int errorType,
                     java.lang.String k1,
                     int v1,
                     java.lang.String k2,
                     int v2,
                     java.lang.String k3,
                     int v3) { super();
                               this.m_namespace = namespace;
                               this.m_name = name;
                               this.m_type = prefixedQNameValAllowed
                                               ? this.
                                                   T_ENUM_OR_PQNAME
                                               : this.
                                                   T_ENUM;
                               this.m_required = required;
                               this.m_supportsAVT = supportsAVT;
                               this.m_errorType = errorType;
                               m_enums = new org.apache.xml.utils.StringToIntTable(
                                           3);
                               m_enums.put(k1, v1);
                               m_enums.put(k2, v2);
                               m_enums.put(k3, v3);
    }
    XSLTAttributeDef(java.lang.String namespace, java.lang.String name,
                     boolean required,
                     boolean supportsAVT,
                     boolean prefixedQNameValAllowed,
                     int errorType,
                     java.lang.String k1,
                     int v1,
                     java.lang.String k2,
                     int v2,
                     java.lang.String k3,
                     int v3,
                     java.lang.String k4,
                     int v4) { super();
                               this.m_namespace =
                                 namespace;
                               this.m_name = name;
                               this.m_type = prefixedQNameValAllowed
                                               ? this.
                                                   T_ENUM_OR_PQNAME
                                               : this.
                                                   T_ENUM;
                               this.m_required = required;
                               this.m_supportsAVT =
                                 supportsAVT;
                               this.m_errorType =
                                 errorType;
                               m_enums = new org.apache.xml.utils.StringToIntTable(
                                           4);
                               m_enums.put(
                                         k1,
                                         v1);
                               m_enums.put(
                                         k2,
                                         v2);
                               m_enums.put(
                                         k3,
                                         v3);
                               m_enums.put(
                                         k4,
                                         v4);
    }
    static final int T_CDATA = 1;
    static final int T_URL = 2;
    static final int T_AVT = 3;
    static final int T_PATTERN = 4;
    static final int T_EXPR = 5;
    static final int T_CHAR = 6;
    static final int T_NUMBER = 7;
    static final int T_YESNO = 8;
    static final int T_QNAME = 9;
    static final int T_QNAMES = 10;
    static final int T_ENUM = 11;
    static final int T_SIMPLEPATTERNLIST =
      12;
    static final int T_NMTOKEN = 13;
    static final int T_STRINGLIST = 14;
    static final int T_PREFIX_URLLIST = 15;
    static final int T_ENUM_OR_PQNAME = 16;
    static final int T_NCNAME = 17;
    static final int T_AVT_QNAME = 18;
    static final int T_QNAMES_RESOLVE_NULL =
      19;
    static final int T_PREFIXLIST = 20;
    static final org.apache.xalan.processor.XSLTAttributeDef
      m_foreignAttr =
      new org.apache.xalan.processor.XSLTAttributeDef(
      "*",
      "*",
      org.apache.xalan.processor.XSLTAttributeDef.
        T_CDATA,
      false,
      false,
      WARNING);
    static final java.lang.String S_FOREIGNATTR_SETTER =
      "setForeignAttr";
    private java.lang.String m_namespace;
    java.lang.String getNamespace() { return m_namespace;
    }
    private java.lang.String m_name;
    java.lang.String getName() { return m_name;
    }
    private int m_type;
    int getType() { return m_type; }
    private org.apache.xml.utils.StringToIntTable
      m_enums;
    private int getEnum(java.lang.String key) {
        return m_enums.
          get(
            key);
    }
    private java.lang.String[] getEnumNames() {
        return m_enums.
          keys(
            );
    }
    private java.lang.String m_default;
    java.lang.String getDefault() { return m_default;
    }
    void setDefault(java.lang.String def) {
        m_default =
          def;
    }
    private boolean m_required;
    boolean getRequired() { return m_required;
    }
    private boolean m_supportsAVT;
    boolean getSupportsAVT() { return m_supportsAVT;
    }
    int m_errorType = this.WARNING;
    int getErrorType() { return m_errorType;
    }
    java.lang.String m_setterString = null;
    public java.lang.String getSetterMethodName() {
        if (null ==
              m_setterString) {
            if (m_foreignAttr ==
                  this) {
                return S_FOREIGNATTR_SETTER;
            }
            else
                if (m_name.
                      equals(
                        "*")) {
                    m_setterString =
                      "addLiteralResultAttribute";
                    return m_setterString;
                }
            java.lang.StringBuffer outBuf =
              new java.lang.StringBuffer(
              );
            outBuf.
              append(
                "set");
            if (m_namespace !=
                  null &&
                  m_namespace.
                  equals(
                    org.apache.xalan.templates.Constants.
                      S_XMLNAMESPACEURI)) {
                outBuf.
                  append(
                    "Xml");
            }
            int n =
              m_name.
              length(
                );
            for (int i =
                   0;
                 i <
                   n;
                 i++) {
                char c =
                  m_name.
                  charAt(
                    i);
                if ('-' ==
                      c) {
                    i++;
                    c =
                      m_name.
                        charAt(
                          i);
                    c =
                      java.lang.Character.
                        toUpperCase(
                          c);
                }
                else
                    if (0 ==
                          i) {
                        c =
                          java.lang.Character.
                            toUpperCase(
                              c);
                    }
                outBuf.
                  append(
                    c);
            }
            m_setterString =
              outBuf.
                toString(
                  );
        }
        return m_setterString;
    }
    org.apache.xalan.templates.AVT processAVT(org.apache.xalan.processor.StylesheetHandler handler,
                                              java.lang.String uri,
                                              java.lang.String name,
                                              java.lang.String rawName,
                                              java.lang.String value,
                                              org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        try {
            org.apache.xalan.templates.AVT avt =
              new org.apache.xalan.templates.AVT(
              handler,
              uri,
              name,
              rawName,
              value,
              owner);
            return avt;
        }
        catch (javax.xml.transform.TransformerException te) {
            throw new org.xml.sax.SAXException(
              te);
        }
    }
    java.lang.Object processCDATA(org.apache.xalan.processor.StylesheetHandler handler,
                                  java.lang.String uri,
                                  java.lang.String name,
                                  java.lang.String rawName,
                                  java.lang.String value,
                                  org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        if (getSupportsAVT(
              )) {
            try {
                org.apache.xalan.templates.AVT avt =
                  new org.apache.xalan.templates.AVT(
                  handler,
                  uri,
                  name,
                  rawName,
                  value,
                  owner);
                return avt;
            }
            catch (javax.xml.transform.TransformerException te) {
                throw new org.xml.sax.SAXException(
                  te);
            }
        }
        else {
            return value;
        }
    }
    java.lang.Object processCHAR(org.apache.xalan.processor.StylesheetHandler handler,
                                 java.lang.String uri,
                                 java.lang.String name,
                                 java.lang.String rawName,
                                 java.lang.String value,
                                 org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        if (getSupportsAVT(
              )) {
            try {
                org.apache.xalan.templates.AVT avt =
                  new org.apache.xalan.templates.AVT(
                  handler,
                  uri,
                  name,
                  rawName,
                  value,
                  owner);
                if (avt.
                      isSimple(
                        ) &&
                      value.
                      length(
                        ) !=
                      1) {
                    handleError(
                      handler,
                      org.apache.xalan.res.XSLTErrorResources.
                        INVALID_TCHAR,
                      new java.lang.Object[] { name,
                      value },
                      null);
                    return null;
                }
                return avt;
            }
            catch (javax.xml.transform.TransformerException te) {
                throw new org.xml.sax.SAXException(
                  te);
            }
        }
        else {
            if (value.
                  length(
                    ) !=
                  1) {
                handleError(
                  handler,
                  org.apache.xalan.res.XSLTErrorResources.
                    INVALID_TCHAR,
                  new java.lang.Object[] { name,
                  value },
                  null);
                return null;
            }
            return new java.lang.Character(
              value.
                charAt(
                  0));
        }
    }
    java.lang.Object processENUM(org.apache.xalan.processor.StylesheetHandler handler,
                                 java.lang.String uri,
                                 java.lang.String name,
                                 java.lang.String rawName,
                                 java.lang.String value,
                                 org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        org.apache.xalan.templates.AVT avt =
          null;
        if (getSupportsAVT(
              )) {
            try {
                avt =
                  new org.apache.xalan.templates.AVT(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                if (!avt.
                      isSimple(
                        ))
                    return avt;
            }
            catch (javax.xml.transform.TransformerException te) {
                throw new org.xml.sax.SAXException(
                  te);
            }
        }
        int retVal =
          this.
          getEnum(
            value);
        if (retVal ==
              org.apache.xml.utils.StringToIntTable.
                INVALID_KEY) {
            java.lang.StringBuffer enumNamesList =
              getListOfEnums(
                );
            handleError(
              handler,
              org.apache.xalan.res.XSLTErrorResources.
                INVALID_ENUM,
              new java.lang.Object[] { name,
              value,
              enumNamesList.
                toString(
                  ) },
              null);
            return null;
        }
        if (getSupportsAVT(
              ))
            return avt;
        else
            return new java.lang.Integer(
              retVal);
    }
    java.lang.Object processENUM_OR_PQNAME(org.apache.xalan.processor.StylesheetHandler handler,
                                           java.lang.String uri,
                                           java.lang.String name,
                                           java.lang.String rawName,
                                           java.lang.String value,
                                           org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        java.lang.Object objToReturn =
          null;
        if (getSupportsAVT(
              )) {
            try {
                org.apache.xalan.templates.AVT avt =
                  new org.apache.xalan.templates.AVT(
                  handler,
                  uri,
                  name,
                  rawName,
                  value,
                  owner);
                if (!avt.
                      isSimple(
                        ))
                    return avt;
                else
                    objToReturn =
                      avt;
            }
            catch (javax.xml.transform.TransformerException te) {
                throw new org.xml.sax.SAXException(
                  te);
            }
        }
        int key =
          this.
          getEnum(
            value);
        if (key !=
              org.apache.xml.utils.StringToIntTable.
                INVALID_KEY) {
            if (objToReturn ==
                  null)
                objToReturn =
                  new java.lang.Integer(
                    key);
        }
        else {
            try {
                org.apache.xml.utils.QName qname =
                  new org.apache.xml.utils.QName(
                  value,
                  handler,
                  true);
                if (objToReturn ==
                      null)
                    objToReturn =
                      qname;
                if (qname.
                      getPrefix(
                        ) ==
                      null) {
                    java.lang.StringBuffer enumNamesList =
                      getListOfEnums(
                        );
                    enumNamesList.
                      append(
                        " <qname-but-not-ncname>");
                    handleError(
                      handler,
                      org.apache.xalan.res.XSLTErrorResources.
                        INVALID_ENUM,
                      new java.lang.Object[] { name,
                      value,
                      enumNamesList.
                        toString(
                          ) },
                      null);
                    return null;
                }
            }
            catch (java.lang.IllegalArgumentException ie) {
                java.lang.StringBuffer enumNamesList =
                  getListOfEnums(
                    );
                enumNamesList.
                  append(
                    " <qname-but-not-ncname>");
                handleError(
                  handler,
                  org.apache.xalan.res.XSLTErrorResources.
                    INVALID_ENUM,
                  new java.lang.Object[] { name,
                  value,
                  enumNamesList.
                    toString(
                      ) },
                  ie);
                return null;
            }
            catch (java.lang.RuntimeException re) {
                java.lang.StringBuffer enumNamesList =
                  getListOfEnums(
                    );
                enumNamesList.
                  append(
                    " <qname-but-not-ncname>");
                handleError(
                  handler,
                  org.apache.xalan.res.XSLTErrorResources.
                    INVALID_ENUM,
                  new java.lang.Object[] { name,
                  value,
                  enumNamesList.
                    toString(
                      ) },
                  re);
                return null;
            }
        }
        return objToReturn;
    }
    java.lang.Object processEXPR(org.apache.xalan.processor.StylesheetHandler handler,
                                 java.lang.String uri,
                                 java.lang.String name,
                                 java.lang.String rawName,
                                 java.lang.String value,
                                 org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        try {
            org.apache.xpath.XPath expr =
              handler.
              createXPath(
                value,
                owner);
            return expr;
        }
        catch (javax.xml.transform.TransformerException te) {
            throw new org.xml.sax.SAXException(
              te);
        }
    }
    java.lang.Object processNMTOKEN(org.apache.xalan.processor.StylesheetHandler handler,
                                    java.lang.String uri,
                                    java.lang.String name,
                                    java.lang.String rawName,
                                    java.lang.String value,
                                    org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        if (getSupportsAVT(
              )) {
            try {
                org.apache.xalan.templates.AVT avt =
                  new org.apache.xalan.templates.AVT(
                  handler,
                  uri,
                  name,
                  rawName,
                  value,
                  owner);
                if (avt.
                      isSimple(
                        ) &&
                      !org.apache.xml.utils.XML11Char.
                      isXML11ValidNmtoken(
                        value)) {
                    handleError(
                      handler,
                      org.apache.xalan.res.XSLTErrorResources.
                        INVALID_NMTOKEN,
                      new java.lang.Object[] { name,
                      value },
                      null);
                    return null;
                }
                return avt;
            }
            catch (javax.xml.transform.TransformerException te) {
                throw new org.xml.sax.SAXException(
                  te);
            }
        }
        else {
            if (!org.apache.xml.utils.XML11Char.
                  isXML11ValidNmtoken(
                    value)) {
                handleError(
                  handler,
                  org.apache.xalan.res.XSLTErrorResources.
                    INVALID_NMTOKEN,
                  new java.lang.Object[] { name,
                  value },
                  null);
                return null;
            }
        }
        return value;
    }
    java.lang.Object processPATTERN(org.apache.xalan.processor.StylesheetHandler handler,
                                    java.lang.String uri,
                                    java.lang.String name,
                                    java.lang.String rawName,
                                    java.lang.String value,
                                    org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        try {
            org.apache.xpath.XPath pattern =
              handler.
              createMatchPatternXPath(
                value,
                owner);
            return pattern;
        }
        catch (javax.xml.transform.TransformerException te) {
            throw new org.xml.sax.SAXException(
              te);
        }
    }
    java.lang.Object processNUMBER(org.apache.xalan.processor.StylesheetHandler handler,
                                   java.lang.String uri,
                                   java.lang.String name,
                                   java.lang.String rawName,
                                   java.lang.String value,
                                   org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        if (getSupportsAVT(
              )) {
            java.lang.Double val;
            org.apache.xalan.templates.AVT avt =
              null;
            try {
                avt =
                  new org.apache.xalan.templates.AVT(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                if (avt.
                      isSimple(
                        )) {
                    val =
                      java.lang.Double.
                        valueOf(
                          value);
                }
            }
            catch (javax.xml.transform.TransformerException te) {
                throw new org.xml.sax.SAXException(
                  te);
            }
            catch (java.lang.NumberFormatException nfe) {
                handleError(
                  handler,
                  org.apache.xalan.res.XSLTErrorResources.
                    INVALID_NUMBER,
                  new java.lang.Object[] { name,
                  value },
                  nfe);
                return null;
            }
            return avt;
        }
        else {
            try {
                return java.lang.Double.
                  valueOf(
                    value);
            }
            catch (java.lang.NumberFormatException nfe) {
                handleError(
                  handler,
                  org.apache.xalan.res.XSLTErrorResources.
                    INVALID_NUMBER,
                  new java.lang.Object[] { name,
                  value },
                  nfe);
                return null;
            }
        }
    }
    java.lang.Object processQNAME(org.apache.xalan.processor.StylesheetHandler handler,
                                  java.lang.String uri,
                                  java.lang.String name,
                                  java.lang.String rawName,
                                  java.lang.String value,
                                  org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        try {
            org.apache.xml.utils.QName qname =
              new org.apache.xml.utils.QName(
              value,
              handler,
              true);
            return qname;
        }
        catch (java.lang.IllegalArgumentException ie) {
            handleError(
              handler,
              org.apache.xalan.res.XSLTErrorResources.
                INVALID_QNAME,
              new java.lang.Object[] { name,
              value },
              ie);
            return null;
        }
        catch (java.lang.RuntimeException re) {
            handleError(
              handler,
              org.apache.xalan.res.XSLTErrorResources.
                INVALID_QNAME,
              new java.lang.Object[] { name,
              value },
              re);
            return null;
        }
    }
    java.lang.Object processAVT_QNAME(org.apache.xalan.processor.StylesheetHandler handler,
                                      java.lang.String uri,
                                      java.lang.String name,
                                      java.lang.String rawName,
                                      java.lang.String value,
                                      org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        org.apache.xalan.templates.AVT avt =
          null;
        try {
            avt =
              new org.apache.xalan.templates.AVT(
                handler,
                uri,
                name,
                rawName,
                value,
                owner);
            if (avt.
                  isSimple(
                    )) {
                int indexOfNSSep =
                  value.
                  indexOf(
                    ':');
                if (indexOfNSSep >=
                      0) {
                    java.lang.String prefix =
                      value.
                      substring(
                        0,
                        indexOfNSSep);
                    if (!org.apache.xml.utils.XML11Char.
                          isXML11ValidNCName(
                            prefix)) {
                        handleError(
                          handler,
                          org.apache.xalan.res.XSLTErrorResources.
                            INVALID_QNAME,
                          new java.lang.Object[] { name,
                          value },
                          null);
                        return null;
                    }
                }
                java.lang.String localName =
                  indexOfNSSep <
                  0
                  ? value
                  : value.
                  substring(
                    indexOfNSSep +
                      1);
                if (localName ==
                      null ||
                      localName.
                      length(
                        ) ==
                      0 ||
                      !org.apache.xml.utils.XML11Char.
                      isXML11ValidNCName(
                        localName)) {
                    handleError(
                      handler,
                      org.apache.xalan.res.XSLTErrorResources.
                        INVALID_QNAME,
                      new java.lang.Object[] { name,
                      value },
                      null);
                    return null;
                }
            }
        }
        catch (javax.xml.transform.TransformerException te) {
            throw new org.xml.sax.SAXException(
              te);
        }
        return avt;
    }
    java.lang.Object processNCNAME(org.apache.xalan.processor.StylesheetHandler handler,
                                   java.lang.String uri,
                                   java.lang.String name,
                                   java.lang.String rawName,
                                   java.lang.String value,
                                   org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        if (getSupportsAVT(
              )) {
            org.apache.xalan.templates.AVT avt =
              null;
            try {
                avt =
                  new org.apache.xalan.templates.AVT(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                if (avt.
                      isSimple(
                        ) &&
                      !org.apache.xml.utils.XML11Char.
                      isXML11ValidNCName(
                        value)) {
                    handleError(
                      handler,
                      org.apache.xalan.res.XSLTErrorResources.
                        INVALID_NCNAME,
                      new java.lang.Object[] { name,
                      value },
                      null);
                    return null;
                }
                return avt;
            }
            catch (javax.xml.transform.TransformerException te) {
                throw new org.xml.sax.SAXException(
                  te);
            }
        }
        else {
            if (!org.apache.xml.utils.XML11Char.
                  isXML11ValidNCName(
                    value)) {
                handleError(
                  handler,
                  org.apache.xalan.res.XSLTErrorResources.
                    INVALID_NCNAME,
                  new java.lang.Object[] { name,
                  value },
                  null);
                return null;
            }
            return value;
        }
    }
    java.util.Vector processQNAMES(org.apache.xalan.processor.StylesheetHandler handler,
                                   java.lang.String uri,
                                   java.lang.String name,
                                   java.lang.String rawName,
                                   java.lang.String value)
          throws org.xml.sax.SAXException {
        java.util.StringTokenizer tokenizer =
          new java.util.StringTokenizer(
          value,
          " \t\n\r\f");
        int nQNames =
          tokenizer.
          countTokens(
            );
        java.util.Vector qnames =
          new java.util.Vector(
          nQNames);
        for (int i =
               0;
             i <
               nQNames;
             i++) {
            qnames.
              addElement(
                new org.apache.xml.utils.QName(
                  tokenizer.
                    nextToken(
                      ),
                  handler));
        }
        return qnames;
    }
    final java.util.Vector processQNAMESRNU(org.apache.xalan.processor.StylesheetHandler handler,
                                            java.lang.String uri,
                                            java.lang.String name,
                                            java.lang.String rawName,
                                            java.lang.String value)
          throws org.xml.sax.SAXException {
        java.util.StringTokenizer tokenizer =
          new java.util.StringTokenizer(
          value,
          " \t\n\r\f");
        int nQNames =
          tokenizer.
          countTokens(
            );
        java.util.Vector qnames =
          new java.util.Vector(
          nQNames);
        java.lang.String defaultURI =
          handler.
          getNamespaceForPrefix(
            "");
        for (int i =
               0;
             i <
               nQNames;
             i++) {
            java.lang.String tok =
              tokenizer.
              nextToken(
                );
            if (tok.
                  indexOf(
                    ':') ==
                  -1) {
                qnames.
                  addElement(
                    new org.apache.xml.utils.QName(
                      defaultURI,
                      tok));
            }
            else {
                qnames.
                  addElement(
                    new org.apache.xml.utils.QName(
                      tok,
                      handler));
            }
        }
        return qnames;
    }
    java.util.Vector processSIMPLEPATTERNLIST(org.apache.xalan.processor.StylesheetHandler handler,
                                              java.lang.String uri,
                                              java.lang.String name,
                                              java.lang.String rawName,
                                              java.lang.String value,
                                              org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        try {
            java.util.StringTokenizer tokenizer =
              new java.util.StringTokenizer(
              value,
              " \t\n\r\f");
            int nPatterns =
              tokenizer.
              countTokens(
                );
            java.util.Vector patterns =
              new java.util.Vector(
              nPatterns);
            for (int i =
                   0;
                 i <
                   nPatterns;
                 i++) {
                org.apache.xpath.XPath pattern =
                  handler.
                  createMatchPatternXPath(
                    tokenizer.
                      nextToken(
                        ),
                    owner);
                patterns.
                  addElement(
                    pattern);
            }
            return patterns;
        }
        catch (javax.xml.transform.TransformerException te) {
            throw new org.xml.sax.SAXException(
              te);
        }
    }
    org.apache.xml.utils.StringVector processSTRINGLIST(org.apache.xalan.processor.StylesheetHandler handler,
                                                        java.lang.String uri,
                                                        java.lang.String name,
                                                        java.lang.String rawName,
                                                        java.lang.String value) {
        java.util.StringTokenizer tokenizer =
          new java.util.StringTokenizer(
          value,
          " \t\n\r\f");
        int nStrings =
          tokenizer.
          countTokens(
            );
        org.apache.xml.utils.StringVector strings =
          new org.apache.xml.utils.StringVector(
          nStrings);
        for (int i =
               0;
             i <
               nStrings;
             i++) {
            strings.
              addElement(
                tokenizer.
                  nextToken(
                    ));
        }
        return strings;
    }
    org.apache.xml.utils.StringVector processPREFIX_URLLIST(org.apache.xalan.processor.StylesheetHandler handler,
                                                            java.lang.String uri,
                                                            java.lang.String name,
                                                            java.lang.String rawName,
                                                            java.lang.String value)
          throws org.xml.sax.SAXException {
        java.util.StringTokenizer tokenizer =
          new java.util.StringTokenizer(
          value,
          " \t\n\r\f");
        int nStrings =
          tokenizer.
          countTokens(
            );
        org.apache.xml.utils.StringVector strings =
          new org.apache.xml.utils.StringVector(
          nStrings);
        for (int i =
               0;
             i <
               nStrings;
             i++) {
            java.lang.String prefix =
              tokenizer.
              nextToken(
                );
            java.lang.String url =
              handler.
              getNamespaceForPrefix(
                prefix);
            if (url !=
                  null)
                strings.
                  addElement(
                    url);
            else
                throw new org.xml.sax.SAXException(
                  org.apache.xalan.res.XSLMessages.
                    createMessage(
                      org.apache.xalan.res.XSLTErrorResources.
                        ER_CANT_RESOLVE_NSPREFIX,
                      new java.lang.Object[] { prefix }));
        }
        return strings;
    }
    org.apache.xml.utils.StringVector processPREFIX_LIST(org.apache.xalan.processor.StylesheetHandler handler,
                                                         java.lang.String uri,
                                                         java.lang.String name,
                                                         java.lang.String rawName,
                                                         java.lang.String value)
          throws org.xml.sax.SAXException {
        java.util.StringTokenizer tokenizer =
          new java.util.StringTokenizer(
          value,
          " \t\n\r\f");
        int nStrings =
          tokenizer.
          countTokens(
            );
        org.apache.xml.utils.StringVector strings =
          new org.apache.xml.utils.StringVector(
          nStrings);
        for (int i =
               0;
             i <
               nStrings;
             i++) {
            java.lang.String prefix =
              tokenizer.
              nextToken(
                );
            java.lang.String url =
              handler.
              getNamespaceForPrefix(
                prefix);
            if (prefix.
                  equals(
                    org.apache.xalan.templates.Constants.
                      ATTRVAL_DEFAULT_PREFIX) ||
                  url !=
                  null)
                strings.
                  addElement(
                    prefix);
            else
                throw new org.xml.sax.SAXException(
                  org.apache.xalan.res.XSLMessages.
                    createMessage(
                      org.apache.xalan.res.XSLTErrorResources.
                        ER_CANT_RESOLVE_NSPREFIX,
                      new java.lang.Object[] { prefix }));
        }
        return strings;
    }
    java.lang.Object processURL(org.apache.xalan.processor.StylesheetHandler handler,
                                java.lang.String uri,
                                java.lang.String name,
                                java.lang.String rawName,
                                java.lang.String value,
                                org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        if (getSupportsAVT(
              )) {
            try {
                org.apache.xalan.templates.AVT avt =
                  new org.apache.xalan.templates.AVT(
                  handler,
                  uri,
                  name,
                  rawName,
                  value,
                  owner);
                return avt;
            }
            catch (javax.xml.transform.TransformerException te) {
                throw new org.xml.sax.SAXException(
                  te);
            }
        }
        else {
            return value;
        }
    }
    private java.lang.Boolean processYESNO(org.apache.xalan.processor.StylesheetHandler handler,
                                           java.lang.String uri,
                                           java.lang.String name,
                                           java.lang.String rawName,
                                           java.lang.String value)
          throws org.xml.sax.SAXException {
        if (!(value.
                equals(
                  "yes") ||
                value.
                equals(
                  "no"))) {
            handleError(
              handler,
              org.apache.xalan.res.XSLTErrorResources.
                INVALID_BOOLEAN,
              new java.lang.Object[] { name,
              value },
              null);
            return null;
        }
        return new java.lang.Boolean(
          value.
            equals(
              "yes")
            ? true
            : false);
    }
    java.lang.Object processValue(org.apache.xalan.processor.StylesheetHandler handler,
                                  java.lang.String uri,
                                  java.lang.String name,
                                  java.lang.String rawName,
                                  java.lang.String value,
                                  org.apache.xalan.templates.ElemTemplateElement owner)
          throws org.xml.sax.SAXException {
        int type =
          getType(
            );
        java.lang.Object processedValue =
          null;
        switch (type) {
            case T_AVT:
                processedValue =
                  processAVT(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                break;
            case T_CDATA:
                processedValue =
                  processCDATA(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                break;
            case T_CHAR:
                processedValue =
                  processCHAR(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                break;
            case T_ENUM:
                processedValue =
                  processENUM(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                break;
            case T_EXPR:
                processedValue =
                  processEXPR(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                break;
            case T_NMTOKEN:
                processedValue =
                  processNMTOKEN(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                break;
            case T_PATTERN:
                processedValue =
                  processPATTERN(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                break;
            case T_NUMBER:
                processedValue =
                  processNUMBER(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                break;
            case T_QNAME:
                processedValue =
                  processQNAME(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                break;
            case T_QNAMES:
                processedValue =
                  processQNAMES(
                    handler,
                    uri,
                    name,
                    rawName,
                    value);
                break;
            case T_QNAMES_RESOLVE_NULL:
                processedValue =
                  processQNAMESRNU(
                    handler,
                    uri,
                    name,
                    rawName,
                    value);
                break;
            case T_SIMPLEPATTERNLIST:
                processedValue =
                  processSIMPLEPATTERNLIST(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                break;
            case T_URL:
                processedValue =
                  processURL(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                break;
            case T_YESNO:
                processedValue =
                  processYESNO(
                    handler,
                    uri,
                    name,
                    rawName,
                    value);
                break;
            case T_STRINGLIST:
                processedValue =
                  processSTRINGLIST(
                    handler,
                    uri,
                    name,
                    rawName,
                    value);
                break;
            case T_PREFIX_URLLIST:
                processedValue =
                  processPREFIX_URLLIST(
                    handler,
                    uri,
                    name,
                    rawName,
                    value);
                break;
            case T_ENUM_OR_PQNAME:
                processedValue =
                  processENUM_OR_PQNAME(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                break;
            case T_NCNAME:
                processedValue =
                  processNCNAME(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                break;
            case T_AVT_QNAME:
                processedValue =
                  processAVT_QNAME(
                    handler,
                    uri,
                    name,
                    rawName,
                    value,
                    owner);
                break;
            case T_PREFIXLIST:
                processedValue =
                  processPREFIX_LIST(
                    handler,
                    uri,
                    name,
                    rawName,
                    value);
                break;
            default:
        }
        return processedValue;
    }
    void setDefAttrValue(org.apache.xalan.processor.StylesheetHandler handler,
                         org.apache.xalan.templates.ElemTemplateElement elem)
          throws org.xml.sax.SAXException {
        setAttrValue(
          handler,
          this.
            getNamespace(
              ),
          this.
            getName(
              ),
          this.
            getName(
              ),
          this.
            getDefault(
              ),
          elem);
    }
    private java.lang.Class getPrimativeClass(java.lang.Object obj) {
        if (obj instanceof org.apache.xpath.XPath)
            return org.apache.xpath.XPath.class;
        java.lang.Class cl =
          obj.
          getClass(
            );
        if (cl ==
              java.lang.Double.class) {
            cl =
              double.class;
        }
        if (cl ==
              java.lang.Float.class) {
            cl =
              float.class;
        }
        else
            if (cl ==
                  java.lang.Boolean.class) {
                cl =
                  boolean.class;
            }
            else
                if (cl ==
                      java.lang.Byte.class) {
                    cl =
                      byte.class;
                }
                else
                    if (cl ==
                          java.lang.Character.class) {
                        cl =
                          char.class;
                    }
                    else
                        if (cl ==
                              java.lang.Short.class) {
                            cl =
                              short.class;
                        }
                        else
                            if (cl ==
                                  java.lang.Integer.class) {
                                cl =
                                  int.class;
                            }
                            else
                                if (cl ==
                                      java.lang.Long.class) {
                                    cl =
                                      long.class;
                                }
        return cl;
    }
    private java.lang.StringBuffer getListOfEnums() {
        java.lang.StringBuffer enumNamesList =
          new java.lang.StringBuffer(
          );
        java.lang.String[] enumValues =
          this.
          getEnumNames(
            );
        for (int i =
               0;
             i <
               enumValues.
                 length;
             i++) {
            if (i >
                  0) {
                enumNamesList.
                  append(
                    ' ');
            }
            enumNamesList.
              append(
                enumValues[i]);
        }
        return enumNamesList;
    }
    boolean setAttrValue(org.apache.xalan.processor.StylesheetHandler handler,
                         java.lang.String attrUri,
                         java.lang.String attrLocalName,
                         java.lang.String attrRawName,
                         java.lang.String attrValue,
                         org.apache.xalan.templates.ElemTemplateElement elem)
          throws org.xml.sax.SAXException {
        if (attrRawName.
              equals(
                "xmlns") ||
              attrRawName.
              startsWith(
                "xmlns:"))
            return true;
        java.lang.String setterString =
          getSetterMethodName(
            );
        if (null !=
              setterString) {
            try {
                java.lang.reflect.Method meth;
                java.lang.Object[] args;
                if (setterString.
                      equals(
                        S_FOREIGNATTR_SETTER)) {
                    if (attrUri ==
                          null)
                        attrUri =
                          "";
                    java.lang.Class sclass =
                      attrUri.
                      getClass(
                        );
                    java.lang.Class[] argTypes =
                      new java.lang.Class[] { sclass,
                    sclass,
                    sclass,
                    sclass };
                    meth =
                      elem.
                        getClass(
                          ).
                        getMethod(
                          setterString,
                          argTypes);
                    args =
                      (new java.lang.Object[] { attrUri,
                       attrLocalName,
                       attrRawName,
                       attrValue });
                }
                else {
                    java.lang.Object value =
                      processValue(
                        handler,
                        attrUri,
                        attrLocalName,
                        attrRawName,
                        attrValue,
                        elem);
                    if (null ==
                          value)
                        return false;
                    java.lang.Class[] argTypes =
                      new java.lang.Class[] { getPrimativeClass(
                                                value) };
                    try {
                        meth =
                          elem.
                            getClass(
                              ).
                            getMethod(
                              setterString,
                              argTypes);
                    }
                    catch (java.lang.NoSuchMethodException nsme) {
                        java.lang.Class cl =
                          ((java.lang.Object)
                             value).
                          getClass(
                            );
                        argTypes[0] =
                          cl;
                        meth =
                          elem.
                            getClass(
                              ).
                            getMethod(
                              setterString,
                              argTypes);
                    }
                    args =
                      (new java.lang.Object[] { value });
                }
                meth.
                  invoke(
                    elem,
                    args);
            }
            catch (java.lang.NoSuchMethodException nsme) {
                if (!setterString.
                      equals(
                        S_FOREIGNATTR_SETTER)) {
                    handler.
                      error(
                        org.apache.xalan.res.XSLTErrorResources.
                          ER_FAILED_CALLING_METHOD,
                        new java.lang.Object[] { setterString },
                        nsme);
                    return false;
                }
            }
            catch (java.lang.IllegalAccessException iae) {
                handler.
                  error(
                    org.apache.xalan.res.XSLTErrorResources.
                      ER_FAILED_CALLING_METHOD,
                    new java.lang.Object[] { setterString },
                    iae);
                return false;
            }
            catch (java.lang.reflect.InvocationTargetException nsme) {
                handleError(
                  handler,
                  org.apache.xalan.res.XSLTErrorResources.
                    WG_ILLEGAL_ATTRIBUTE_VALUE,
                  new java.lang.Object[] { org.apache.xalan.templates.Constants.
                                             ATTRNAME_NAME,
                  getName(
                    ) },
                  nsme);
                return false;
            }
        }
        return true;
    }
    private void handleError(org.apache.xalan.processor.StylesheetHandler handler,
                             java.lang.String msg,
                             java.lang.Object[] args,
                             java.lang.Exception exc)
          throws org.xml.sax.SAXException {
        switch (getErrorType(
                  )) {
            case FATAL:
            case ERROR:
                handler.
                  error(
                    msg,
                    args,
                    exc);
                break;
            case WARNING:
                handler.
                  warn(
                    msg,
                    args);
            default:
                break;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "amT0/JnQ/wNn5oebVV8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fQvnW2Q5O+jVQGnaw6q+wvqYzVRKVdAx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
