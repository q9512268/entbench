package org.apache.xalan.transformer;
public class TransformerImpl extends javax.xml.transform.Transformer implements java.lang.Runnable, org.apache.xml.dtm.DTMWSFilter, org.apache.xpath.ExtensionsProvider, org.apache.xml.serializer.SerializerTrace {
    private java.lang.Boolean m_reentryGuard = new java.lang.Boolean(true);
    private java.io.FileOutputStream m_outputStream = null;
    private boolean m_parserEventsOnMain = true;
    private java.lang.Thread m_transformThread;
    private java.lang.String m_urlOfSource = null;
    private javax.xml.transform.Result m_outputTarget = null;
    private org.apache.xalan.templates.OutputProperties m_outputFormat;
    org.xml.sax.ContentHandler m_inputContentHandler;
    private org.xml.sax.ContentHandler m_outputContentHandler = null;
    javax.xml.parsers.DocumentBuilder m_docBuilder = null;
    private org.apache.xml.utils.ObjectPool m_textResultHandlerObjectPool =
      new org.apache.xml.utils.ObjectPool(
      org.apache.xml.serializer.ToTextStream.class);
    private org.apache.xml.utils.ObjectPool m_stringWriterObjectPool = new org.apache.xml.utils.ObjectPool(
      java.io.StringWriter.class);
    private org.apache.xalan.templates.OutputProperties m_textformat =
      new org.apache.xalan.templates.OutputProperties(
      org.apache.xml.serializer.Method.
        TEXT);
    org.apache.xml.utils.ObjectStack m_currentTemplateElements = new org.apache.xml.utils.ObjectStack(
      org.apache.xpath.XPathContext.
        RECURSIONLIMIT);
    java.util.Stack m_currentMatchTemplates = new java.util.Stack(
      );
    org.apache.xml.utils.NodeVector m_currentMatchedNodes =
      new org.apache.xml.utils.NodeVector(
      );
    private org.apache.xalan.templates.StylesheetRoot m_stylesheetRoot =
      null;
    private boolean m_quietConflictWarnings = true;
    private org.apache.xpath.XPathContext m_xcontext;
    private org.apache.xalan.transformer.StackGuard m_stackGuard;
    private org.apache.xml.serializer.SerializationHandler
      m_serializationHandler;
    private org.apache.xalan.transformer.KeyManager m_keyManager =
      new org.apache.xalan.transformer.KeyManager(
      );
    java.util.Stack m_attrSetStack = null;
    org.apache.xalan.transformer.CountersTable m_countersTable =
      null;
    org.apache.xml.utils.BoolStack m_currentTemplateRuleIsNull =
      new org.apache.xml.utils.BoolStack(
      );
    org.apache.xml.utils.ObjectStack m_currentFuncResult =
      new org.apache.xml.utils.ObjectStack(
      );
    private org.apache.xalan.transformer.MsgMgr m_msgMgr;
    private boolean m_optimizer = true;
    private boolean m_incremental = false;
    private boolean m_source_location = false;
    private boolean m_debug = false;
    private javax.xml.transform.ErrorListener m_errorHandler =
      new org.apache.xml.utils.DefaultErrorHandler(
      false);
    private org.apache.xalan.trace.TraceManager m_traceManager =
      new org.apache.xalan.trace.TraceManager(
      this);
    private java.lang.Exception m_exceptionThrown = null;
    private javax.xml.transform.Source m_xmlSource;
    private int m_doc;
    private boolean m_isTransformDone = false;
    private boolean m_hasBeenReset = false;
    private boolean m_shouldReset = true;
    public void setShouldReset(boolean shouldReset) { m_shouldReset =
                                                        shouldReset;
    }
    private java.util.Stack m_modes = new java.util.Stack(
      );
    public TransformerImpl(org.apache.xalan.templates.StylesheetRoot stylesheet) {
        super(
          );
        m_optimizer =
          stylesheet.
            getOptimizer(
              );
        m_incremental =
          stylesheet.
            getIncremental(
              );
        m_source_location =
          stylesheet.
            getSource_location(
              );
        setStylesheet(
          stylesheet);
        org.apache.xpath.XPathContext xPath =
          new org.apache.xpath.XPathContext(
          this);
        xPath.
          setIncremental(
            m_incremental);
        xPath.
          getDTMManager(
            ).
          setIncremental(
            m_incremental);
        xPath.
          setSource_location(
            m_source_location);
        xPath.
          getDTMManager(
            ).
          setSource_location(
            m_source_location);
        if (stylesheet.
              isSecureProcessing(
                ))
            xPath.
              setSecureProcessing(
                true);
        setXPathContext(
          xPath);
        getXPathContext(
          ).
          setNamespaceContext(
            stylesheet);
        m_stackGuard =
          new org.apache.xalan.transformer.StackGuard(
            this);
    }
    private org.apache.xalan.extensions.ExtensionsTable
      m_extensionsTable =
      null;
    public org.apache.xalan.extensions.ExtensionsTable getExtensionsTable() {
        return m_extensionsTable;
    }
    void setExtensionsTable(org.apache.xalan.templates.StylesheetRoot sroot)
          throws javax.xml.transform.TransformerException {
        try {
            if (sroot.
                  getExtensions(
                    ) !=
                  null)
                if (!sroot.
                      isSecureProcessing(
                        ))
                    m_extensionsTable =
                      new org.apache.xalan.extensions.ExtensionsTable(
                        sroot);
        }
        catch (javax.xml.transform.TransformerException te) {
            te.
              printStackTrace(
                );
        }
    }
    public boolean functionAvailable(java.lang.String ns,
                                     java.lang.String funcName)
          throws javax.xml.transform.TransformerException {
        return getExtensionsTable(
                 ).
          functionAvailable(
            ns,
            funcName);
    }
    public boolean elementAvailable(java.lang.String ns,
                                    java.lang.String elemName)
          throws javax.xml.transform.TransformerException {
        return getExtensionsTable(
                 ).
          elementAvailable(
            ns,
            elemName);
    }
    public java.lang.Object extFunction(java.lang.String ns,
                                        java.lang.String funcName,
                                        java.util.Vector argVec,
                                        java.lang.Object methodKey)
          throws javax.xml.transform.TransformerException {
        return getExtensionsTable(
                 ).
          extFunction(
            ns,
            funcName,
            argVec,
            methodKey,
            getXPathContext(
              ).
              getExpressionContext(
                ));
    }
    public java.lang.Object extFunction(org.apache.xpath.functions.FuncExtFunction extFunction,
                                        java.util.Vector argVec)
          throws javax.xml.transform.TransformerException {
        return getExtensionsTable(
                 ).
          extFunction(
            extFunction,
            argVec,
            getXPathContext(
              ).
              getExpressionContext(
                ));
    }
    public void reset() { if (!m_hasBeenReset &&
                                m_shouldReset) {
                              m_hasBeenReset =
                                true;
                              if (this.
                                    m_outputStream !=
                                    null) {
                                  try {
                                      m_outputStream.
                                        close(
                                          );
                                  }
                                  catch (java.io.IOException ioe) {
                                      
                                  }
                              }
                              m_outputStream =
                                null;
                              m_countersTable =
                                null;
                              m_xcontext.
                                reset(
                                  );
                              m_xcontext.
                                getVarStack(
                                  ).
                                reset(
                                  );
                              resetUserParameters(
                                );
                              m_currentTemplateElements.
                                removeAllElements(
                                  );
                              m_currentMatchTemplates.
                                removeAllElements(
                                  );
                              m_currentMatchedNodes.
                                removeAllElements(
                                  );
                              m_serializationHandler =
                                null;
                              m_outputTarget =
                                null;
                              m_keyManager =
                                new org.apache.xalan.transformer.KeyManager(
                                  );
                              m_attrSetStack =
                                null;
                              m_countersTable =
                                null;
                              m_currentTemplateRuleIsNull =
                                new org.apache.xml.utils.BoolStack(
                                  );
                              m_xmlSource =
                                null;
                              m_doc =
                                org.apache.xml.dtm.DTM.
                                  NULL;
                              m_isTransformDone =
                                false;
                              m_transformThread =
                                null;
                              m_xcontext.
                                getSourceTreeManager(
                                  ).
                                reset(
                                  );
                          } }
    public boolean getProperty(java.lang.String property) {
        return false;
    }
    public void setProperty(java.lang.String property,
                            java.lang.Object value) {
        
    }
    public boolean isParserEventsOnMain() {
        return m_parserEventsOnMain;
    }
    public java.lang.Thread getTransformThread() {
        return m_transformThread;
    }
    public void setTransformThread(java.lang.Thread t) {
        m_transformThread =
          t;
    }
    private boolean m_hasTransformThreadErrorCatcher =
      false;
    public boolean hasTransformThreadErrorCatcher() {
        return m_hasTransformThreadErrorCatcher;
    }
    public void transform(javax.xml.transform.Source source)
          throws javax.xml.transform.TransformerException {
        transform(
          source,
          true);
    }
    public void transform(javax.xml.transform.Source source,
                          boolean shouldRelease)
          throws javax.xml.transform.TransformerException {
        try {
            if (getXPathContext(
                  ).
                  getNamespaceContext(
                    ) ==
                  null) {
                getXPathContext(
                  ).
                  setNamespaceContext(
                    getStylesheet(
                      ));
            }
            java.lang.String base =
              source.
              getSystemId(
                );
            if (null ==
                  base) {
                base =
                  m_stylesheetRoot.
                    getBaseIdentifier(
                      );
            }
            if (null ==
                  base) {
                java.lang.String currentDir =
                  "";
                try {
                    currentDir =
                      java.lang.System.
                        getProperty(
                          "user.dir");
                }
                catch (java.lang.SecurityException se) {
                    
                }
                if (currentDir.
                      startsWith(
                        java.io.File.
                          separator))
                    base =
                      "file://" +
                      currentDir;
                else
                    base =
                      "file:///" +
                      currentDir;
                base =
                  base +
                  java.io.File.
                    separatorChar +
                  source.
                    getClass(
                      ).
                    getName(
                      );
            }
            setBaseURLOfSource(
              base);
            org.apache.xml.dtm.DTMManager mgr =
              m_xcontext.
              getDTMManager(
                );
            if (source instanceof javax.xml.transform.stream.StreamSource &&
                  source.
                  getSystemId(
                    ) ==
                  null &&
                  ((javax.xml.transform.stream.StreamSource)
                     source).
                  getInputStream(
                    ) ==
                  null &&
                  ((javax.xml.transform.stream.StreamSource)
                     source).
                  getReader(
                    ) ==
                  null ||
                  source instanceof javax.xml.transform.sax.SAXSource &&
                  ((javax.xml.transform.sax.SAXSource)
                     source).
                  getInputSource(
                    ) ==
                  null &&
                  ((javax.xml.transform.sax.SAXSource)
                     source).
                  getXMLReader(
                    ) ==
                  null ||
                  source instanceof javax.xml.transform.dom.DOMSource &&
                  ((javax.xml.transform.dom.DOMSource)
                     source).
                  getNode(
                    ) ==
                  null) {
                try {
                    javax.xml.parsers.DocumentBuilderFactory builderF =
                      javax.xml.parsers.DocumentBuilderFactory.
                      newInstance(
                        );
                    javax.xml.parsers.DocumentBuilder builder =
                      builderF.
                      newDocumentBuilder(
                        );
                    java.lang.String systemID =
                      source.
                      getSystemId(
                        );
                    source =
                      new javax.xml.transform.dom.DOMSource(
                        builder.
                          newDocument(
                            ));
                    if (systemID !=
                          null) {
                        source.
                          setSystemId(
                            systemID);
                    }
                }
                catch (javax.xml.parsers.ParserConfigurationException e) {
                    fatalError(
                      e);
                }
            }
            org.apache.xml.dtm.DTM dtm =
              mgr.
              getDTM(
                source,
                false,
                this,
                true,
                true);
            dtm.
              setDocumentBaseURI(
                base);
            boolean hardDelete =
              true;
            try {
                this.
                  transformNode(
                    dtm.
                      getDocument(
                        ));
            }
            finally {
                if (shouldRelease)
                    mgr.
                      release(
                        dtm,
                        hardDelete);
            }
            java.lang.Exception e =
              getExceptionThrown(
                );
            if (null !=
                  e) {
                if (e instanceof javax.xml.transform.TransformerException) {
                    throw (javax.xml.transform.TransformerException)
                            e;
                }
                else
                    if (e instanceof org.apache.xml.utils.WrappedRuntimeException) {
                        fatalError(
                          ((org.apache.xml.utils.WrappedRuntimeException)
                             e).
                            getException(
                              ));
                    }
                    else {
                        throw new javax.xml.transform.TransformerException(
                          e);
                    }
            }
            else
                if (null !=
                      m_serializationHandler) {
                    m_serializationHandler.
                      endDocument(
                        );
                }
        }
        catch (org.apache.xml.utils.WrappedRuntimeException wre) {
            java.lang.Throwable throwable =
              wre.
              getException(
                );
            while (throwable instanceof org.apache.xml.utils.WrappedRuntimeException) {
                throwable =
                  ((org.apache.xml.utils.WrappedRuntimeException)
                     throwable).
                    getException(
                      );
            }
            fatalError(
              throwable);
        }
        catch (org.xml.sax.SAXParseException spe) {
            fatalError(
              spe);
        }
        catch (org.xml.sax.SAXException se) {
            m_errorHandler.
              fatalError(
                new javax.xml.transform.TransformerException(
                  se));
        }
        finally {
            m_hasTransformThreadErrorCatcher =
              false;
            reset(
              );
        }
    }
    private void fatalError(java.lang.Throwable throwable)
          throws javax.xml.transform.TransformerException {
        if (throwable instanceof org.xml.sax.SAXParseException)
            m_errorHandler.
              fatalError(
                new javax.xml.transform.TransformerException(
                  throwable.
                    getMessage(
                      ),
                  new org.apache.xml.utils.SAXSourceLocator(
                    (org.xml.sax.SAXParseException)
                      throwable)));
        else
            m_errorHandler.
              fatalError(
                new javax.xml.transform.TransformerException(
                  throwable));
    }
    public java.lang.String getBaseURLOfSource() {
        return m_urlOfSource;
    }
    public void setBaseURLOfSource(java.lang.String base) {
        m_urlOfSource =
          base;
    }
    public javax.xml.transform.Result getOutputTarget() {
        return m_outputTarget;
    }
    public void setOutputTarget(javax.xml.transform.Result outputTarget) {
        m_outputTarget =
          outputTarget;
    }
    public java.lang.String getOutputProperty(java.lang.String qnameString)
          throws java.lang.IllegalArgumentException {
        java.lang.String value =
          null;
        org.apache.xalan.templates.OutputProperties props =
          getOutputFormat(
            );
        value =
          props.
            getProperty(
              qnameString);
        if (null ==
              value) {
            if (!org.apache.xalan.templates.OutputProperties.
                  isLegalPropertyKey(
                    qnameString))
                throw new java.lang.IllegalArgumentException(
                  org.apache.xalan.res.XSLMessages.
                    createMessage(
                      org.apache.xalan.res.XSLTErrorResources.
                        ER_OUTPUT_PROPERTY_NOT_RECOGNIZED,
                      new java.lang.Object[] { qnameString }));
        }
        return value;
    }
    public java.lang.String getOutputPropertyNoDefault(java.lang.String qnameString)
          throws java.lang.IllegalArgumentException {
        java.lang.String value =
          null;
        org.apache.xalan.templates.OutputProperties props =
          getOutputFormat(
            );
        value =
          (java.lang.String)
            props.
            getProperties(
              ).
            get(
              qnameString);
        if (null ==
              value) {
            if (!org.apache.xalan.templates.OutputProperties.
                  isLegalPropertyKey(
                    qnameString))
                throw new java.lang.IllegalArgumentException(
                  org.apache.xalan.res.XSLMessages.
                    createMessage(
                      org.apache.xalan.res.XSLTErrorResources.
                        ER_OUTPUT_PROPERTY_NOT_RECOGNIZED,
                      new java.lang.Object[] { qnameString }));
        }
        return value;
    }
    public void setOutputProperty(java.lang.String name,
                                  java.lang.String value)
          throws java.lang.IllegalArgumentException {
        synchronized (m_reentryGuard)  {
            if (null ==
                  m_outputFormat) {
                m_outputFormat =
                  (org.apache.xalan.templates.OutputProperties)
                    getStylesheet(
                      ).
                    getOutputComposed(
                      ).
                    clone(
                      );
            }
            if (!org.apache.xalan.templates.OutputProperties.
                  isLegalPropertyKey(
                    name))
                throw new java.lang.IllegalArgumentException(
                  org.apache.xalan.res.XSLMessages.
                    createMessage(
                      org.apache.xalan.res.XSLTErrorResources.
                        ER_OUTPUT_PROPERTY_NOT_RECOGNIZED,
                      new java.lang.Object[] { name }));
            m_outputFormat.
              setProperty(
                name,
                value);
        }
    }
    public void setOutputProperties(java.util.Properties oformat)
          throws java.lang.IllegalArgumentException {
        synchronized (m_reentryGuard)  {
            if (null !=
                  oformat) {
                java.lang.String method =
                  (java.lang.String)
                    oformat.
                    get(
                      javax.xml.transform.OutputKeys.
                        METHOD);
                if (null !=
                      method)
                    m_outputFormat =
                      new org.apache.xalan.templates.OutputProperties(
                        method);
                else
                    if (m_outputFormat ==
                          null)
                        m_outputFormat =
                          new org.apache.xalan.templates.OutputProperties(
                            );
                m_outputFormat.
                  copyFrom(
                    oformat);
                m_outputFormat.
                  copyFrom(
                    m_stylesheetRoot.
                      getOutputProperties(
                        ));
            }
            else {
                m_outputFormat =
                  null;
            }
        }
    }
    public java.util.Properties getOutputProperties() {
        return (java.util.Properties)
                 getOutputFormat(
                   ).
                 getProperties(
                   ).
                 clone(
                   );
    }
    public org.apache.xml.serializer.SerializationHandler createSerializationHandler(javax.xml.transform.Result outputTarget)
          throws javax.xml.transform.TransformerException {
        org.apache.xml.serializer.SerializationHandler xoh =
          createSerializationHandler(
            outputTarget,
            getOutputFormat(
              ));
        return xoh;
    }
    public org.apache.xml.serializer.SerializationHandler createSerializationHandler(javax.xml.transform.Result outputTarget,
                                                                                     org.apache.xalan.templates.OutputProperties format)
          throws javax.xml.transform.TransformerException {
        org.apache.xml.serializer.SerializationHandler xoh;
        org.w3c.dom.Node outputNode =
          null;
        if (outputTarget instanceof javax.xml.transform.dom.DOMResult) {
            outputNode =
              ((javax.xml.transform.dom.DOMResult)
                 outputTarget).
                getNode(
                  );
            org.w3c.dom.Node nextSibling =
              ((javax.xml.transform.dom.DOMResult)
                 outputTarget).
              getNextSibling(
                );
            org.w3c.dom.Document doc;
            short type;
            if (null !=
                  outputNode) {
                type =
                  outputNode.
                    getNodeType(
                      );
                doc =
                  org.w3c.dom.Node.
                    DOCUMENT_NODE ==
                    type
                    ? (org.w3c.dom.Document)
                        outputNode
                    : outputNode.
                    getOwnerDocument(
                      );
            }
            else {
                boolean isSecureProcessing =
                  m_stylesheetRoot.
                  isSecureProcessing(
                    );
                doc =
                  org.apache.xml.utils.DOMHelper.
                    createDocument(
                      isSecureProcessing);
                outputNode =
                  doc;
                type =
                  outputNode.
                    getNodeType(
                      );
                ((javax.xml.transform.dom.DOMResult)
                   outputTarget).
                  setNode(
                    outputNode);
            }
            org.apache.xml.utils.DOMBuilder handler =
              org.w3c.dom.Node.
                DOCUMENT_FRAGMENT_NODE ==
              type
              ? new org.apache.xml.utils.DOMBuilder(
              doc,
              (org.w3c.dom.DocumentFragment)
                outputNode)
              : new org.apache.xml.utils.DOMBuilder(
              doc,
              outputNode);
            if (nextSibling !=
                  null)
                handler.
                  setNextSibling(
                    nextSibling);
            java.lang.String encoding =
              format.
              getProperty(
                javax.xml.transform.OutputKeys.
                  ENCODING);
            xoh =
              new org.apache.xml.serializer.ToXMLSAXHandler(
                handler,
                (org.xml.sax.ext.LexicalHandler)
                  handler,
                encoding);
        }
        else
            if (outputTarget instanceof javax.xml.transform.sax.SAXResult) {
                org.xml.sax.ContentHandler handler =
                  ((javax.xml.transform.sax.SAXResult)
                     outputTarget).
                  getHandler(
                    );
                if (null ==
                      handler)
                    throw new java.lang.IllegalArgumentException(
                      "handler can not be null for a SAXResult");
                org.xml.sax.ext.LexicalHandler lexHandler;
                if (handler instanceof org.xml.sax.ext.LexicalHandler)
                    lexHandler =
                      (org.xml.sax.ext.LexicalHandler)
                        handler;
                else
                    lexHandler =
                      null;
                java.lang.String encoding =
                  format.
                  getProperty(
                    javax.xml.transform.OutputKeys.
                      ENCODING);
                java.lang.String method =
                  format.
                  getProperty(
                    javax.xml.transform.OutputKeys.
                      METHOD);
                org.apache.xml.serializer.ToXMLSAXHandler toXMLSAXHandler =
                  new org.apache.xml.serializer.ToXMLSAXHandler(
                  handler,
                  lexHandler,
                  encoding);
                toXMLSAXHandler.
                  setShouldOutputNSAttr(
                    false);
                xoh =
                  toXMLSAXHandler;
                java.lang.String publicID =
                  format.
                  getProperty(
                    javax.xml.transform.OutputKeys.
                      DOCTYPE_PUBLIC);
                java.lang.String systemID =
                  format.
                  getProperty(
                    javax.xml.transform.OutputKeys.
                      DOCTYPE_SYSTEM);
                if (systemID !=
                      null)
                    xoh.
                      setDoctypeSystem(
                        systemID);
                if (publicID !=
                      null)
                    xoh.
                      setDoctypePublic(
                        publicID);
                if (handler instanceof org.apache.xalan.transformer.TransformerClient) {
                    org.apache.xalan.transformer.XalanTransformState state =
                      new org.apache.xalan.transformer.XalanTransformState(
                      );
                    ((org.apache.xalan.transformer.TransformerClient)
                       handler).
                      setTransformState(
                        state);
                    ((org.apache.xml.serializer.ToSAXHandler)
                       xoh).
                      setTransformState(
                        state);
                }
            }
            else
                if (outputTarget instanceof javax.xml.transform.stream.StreamResult) {
                    javax.xml.transform.stream.StreamResult sresult =
                      (javax.xml.transform.stream.StreamResult)
                        outputTarget;
                    try {
                        org.apache.xml.serializer.SerializationHandler serializer =
                          (org.apache.xml.serializer.SerializationHandler)
                            org.apache.xml.serializer.SerializerFactory.
                            getSerializer(
                              format.
                                getProperties(
                                  ));
                        if (null !=
                              sresult.
                              getWriter(
                                ))
                            serializer.
                              setWriter(
                                sresult.
                                  getWriter(
                                    ));
                        else
                            if (null !=
                                  sresult.
                                  getOutputStream(
                                    ))
                                serializer.
                                  setOutputStream(
                                    sresult.
                                      getOutputStream(
                                        ));
                            else
                                if (null !=
                                      sresult.
                                      getSystemId(
                                        )) {
                                    java.lang.String fileURL =
                                      sresult.
                                      getSystemId(
                                        );
                                    if (fileURL.
                                          startsWith(
                                            "file:///")) {
                                        if (fileURL.
                                              substring(
                                                8).
                                              indexOf(
                                                ":") >
                                              0)
                                            fileURL =
                                              fileURL.
                                                substring(
                                                  8);
                                        else
                                            fileURL =
                                              fileURL.
                                                substring(
                                                  7);
                                    }
                                    else
                                        if (fileURL.
                                              startsWith(
                                                "file:/")) {
                                            if (fileURL.
                                                  substring(
                                                    6).
                                                  indexOf(
                                                    ":") >
                                                  0)
                                                fileURL =
                                                  fileURL.
                                                    substring(
                                                      6);
                                            else
                                                fileURL =
                                                  fileURL.
                                                    substring(
                                                      5);
                                        }
                                    m_outputStream =
                                      new java.io.FileOutputStream(
                                        fileURL);
                                    serializer.
                                      setOutputStream(
                                        m_outputStream);
                                    xoh =
                                      serializer;
                                }
                                else
                                    throw new javax.xml.transform.TransformerException(
                                      org.apache.xalan.res.XSLMessages.
                                        createMessage(
                                          org.apache.xalan.res.XSLTErrorResources.
                                            ER_NO_OUTPUT_SPECIFIED,
                                          null));
                        xoh =
                          serializer;
                    }
                    catch (java.io.IOException ioe) {
                        throw new javax.xml.transform.TransformerException(
                          ioe);
                    }
                }
                else {
                    throw new javax.xml.transform.TransformerException(
                      org.apache.xalan.res.XSLMessages.
                        createMessage(
                          org.apache.xalan.res.XSLTErrorResources.
                            ER_CANNOT_TRANSFORM_TO_RESULT_TYPE,
                          new java.lang.Object[] { outputTarget.
                            getClass(
                              ).
                            getName(
                              ) }));
                }
        xoh.
          setTransformer(
            this);
        javax.xml.transform.SourceLocator srcLocator =
          getStylesheet(
            );
        xoh.
          setSourceLocator(
            srcLocator);
        return xoh;
    }
    public void transform(javax.xml.transform.Source xmlSource,
                          javax.xml.transform.Result outputTarget)
          throws javax.xml.transform.TransformerException {
        transform(
          xmlSource,
          outputTarget,
          true);
    }
    public void transform(javax.xml.transform.Source xmlSource,
                          javax.xml.transform.Result outputTarget,
                          boolean shouldRelease)
          throws javax.xml.transform.TransformerException {
        synchronized (m_reentryGuard)  {
            org.apache.xml.serializer.SerializationHandler xoh =
              createSerializationHandler(
                outputTarget);
            this.
              setSerializationHandler(
                xoh);
            m_outputTarget =
              outputTarget;
            transform(
              xmlSource,
              shouldRelease);
        }
    }
    public void transformNode(int node, javax.xml.transform.Result outputTarget)
          throws javax.xml.transform.TransformerException {
        org.apache.xml.serializer.SerializationHandler xoh =
          createSerializationHandler(
            outputTarget);
        this.
          setSerializationHandler(
            xoh);
        m_outputTarget =
          outputTarget;
        transformNode(
          node);
    }
    public void transformNode(int node) throws javax.xml.transform.TransformerException {
        setExtensionsTable(
          getStylesheet(
            ));
        synchronized (m_serializationHandler)  {
            m_hasBeenReset =
              false;
            org.apache.xpath.XPathContext xctxt =
              getXPathContext(
                );
            org.apache.xml.dtm.DTM dtm =
              xctxt.
              getDTM(
                node);
            try {
                pushGlobalVars(
                  node);
                org.apache.xalan.templates.StylesheetRoot stylesheet =
                  this.
                  getStylesheet(
                    );
                int n =
                  stylesheet.
                  getGlobalImportCount(
                    );
                for (int i =
                       0;
                     i <
                       n;
                     i++) {
                    org.apache.xalan.templates.StylesheetComposed imported =
                      stylesheet.
                      getGlobalImport(
                        i);
                    int includedCount =
                      imported.
                      getIncludeCountComposed(
                        );
                    for (int j =
                           -1;
                         j <
                           includedCount;
                         j++) {
                        org.apache.xalan.templates.Stylesheet included =
                          imported.
                          getIncludeComposed(
                            j);
                        included.
                          runtimeInit(
                            this);
                        for (org.apache.xalan.templates.ElemTemplateElement child =
                               included.
                               getFirstChildElem(
                                 );
                             child !=
                               null;
                             child =
                               child.
                                 getNextSiblingElem(
                                   )) {
                            child.
                              runtimeInit(
                                this);
                        }
                    }
                }
                org.apache.xml.dtm.DTMIterator dtmIter =
                  new org.apache.xpath.axes.SelfIteratorNoPredicate(
                  );
                dtmIter.
                  setRoot(
                    node,
                    xctxt);
                xctxt.
                  pushContextNodeList(
                    dtmIter);
                try {
                    this.
                      applyTemplateToNode(
                        null,
                        null,
                        node);
                }
                finally {
                    xctxt.
                      popContextNodeList(
                        );
                }
                if (null !=
                      m_serializationHandler) {
                    m_serializationHandler.
                      endDocument(
                        );
                }
            }
            catch (java.lang.Exception se) {
                while (se instanceof org.apache.xml.utils.WrappedRuntimeException) {
                    java.lang.Exception e =
                      ((org.apache.xml.utils.WrappedRuntimeException)
                         se).
                      getException(
                        );
                    if (null !=
                          e)
                        se =
                          e;
                }
                if (null !=
                      m_serializationHandler) {
                    try {
                        if (se instanceof org.xml.sax.SAXParseException)
                            m_serializationHandler.
                              fatalError(
                                (org.xml.sax.SAXParseException)
                                  se);
                        else
                            if (se instanceof javax.xml.transform.TransformerException) {
                                javax.xml.transform.TransformerException te =
                                  (javax.xml.transform.TransformerException)
                                    se;
                                org.apache.xml.utils.SAXSourceLocator sl =
                                  new org.apache.xml.utils.SAXSourceLocator(
                                  te.
                                    getLocator(
                                      ));
                                m_serializationHandler.
                                  fatalError(
                                    new org.xml.sax.SAXParseException(
                                      te.
                                        getMessage(
                                          ),
                                      sl,
                                      te));
                            }
                            else {
                                m_serializationHandler.
                                  fatalError(
                                    new org.xml.sax.SAXParseException(
                                      se.
                                        getMessage(
                                          ),
                                      new org.apache.xml.utils.SAXSourceLocator(
                                        ),
                                      se));
                            }
                    }
                    catch (java.lang.Exception e) {
                        
                    }
                }
                if (se instanceof javax.xml.transform.TransformerException) {
                    m_errorHandler.
                      fatalError(
                        (javax.xml.transform.TransformerException)
                          se);
                }
                else
                    if (se instanceof org.xml.sax.SAXParseException) {
                        m_errorHandler.
                          fatalError(
                            new javax.xml.transform.TransformerException(
                              se.
                                getMessage(
                                  ),
                              new org.apache.xml.utils.SAXSourceLocator(
                                (org.xml.sax.SAXParseException)
                                  se),
                              se));
                    }
                    else {
                        m_errorHandler.
                          fatalError(
                            new javax.xml.transform.TransformerException(
                              se));
                    }
            }
            finally {
                this.
                  reset(
                    );
            }
        }
    }
    public org.xml.sax.ContentHandler getInputContentHandler() {
        return getInputContentHandler(
                 false);
    }
    public org.xml.sax.ContentHandler getInputContentHandler(boolean doDocFrag) {
        if (null ==
              m_inputContentHandler) {
            m_inputContentHandler =
              new org.apache.xalan.transformer.TransformerHandlerImpl(
                this,
                doDocFrag,
                m_urlOfSource);
        }
        return m_inputContentHandler;
    }
    public org.xml.sax.ext.DeclHandler getInputDeclHandler() {
        if (m_inputContentHandler instanceof org.xml.sax.ext.DeclHandler)
            return (org.xml.sax.ext.DeclHandler)
                     m_inputContentHandler;
        else
            return null;
    }
    public org.xml.sax.ext.LexicalHandler getInputLexicalHandler() {
        if (m_inputContentHandler instanceof org.xml.sax.ext.LexicalHandler)
            return (org.xml.sax.ext.LexicalHandler)
                     m_inputContentHandler;
        else
            return null;
    }
    public void setOutputFormat(org.apache.xalan.templates.OutputProperties oformat) {
        m_outputFormat =
          oformat;
    }
    public org.apache.xalan.templates.OutputProperties getOutputFormat() {
        org.apache.xalan.templates.OutputProperties format =
          null ==
          m_outputFormat
          ? getStylesheet(
              ).
          getOutputComposed(
            )
          : m_outputFormat;
        return format;
    }
    public void setParameter(java.lang.String name,
                             java.lang.String namespace,
                             java.lang.Object value) {
        org.apache.xpath.VariableStack varstack =
          getXPathContext(
            ).
          getVarStack(
            );
        org.apache.xml.utils.QName qname =
          new org.apache.xml.utils.QName(
          namespace,
          name);
        org.apache.xpath.objects.XObject xobject =
          org.apache.xpath.objects.XObject.
          create(
            value,
            getXPathContext(
              ));
        org.apache.xalan.templates.StylesheetRoot sroot =
          m_stylesheetRoot;
        java.util.Vector vars =
          sroot.
          getVariablesAndParamsComposed(
            );
        int i =
          vars.
          size(
            );
        while (--i >=
                 0) {
            org.apache.xalan.templates.ElemVariable variable =
              (org.apache.xalan.templates.ElemVariable)
                vars.
                elementAt(
                  i);
            if (variable.
                  getXSLToken(
                    ) ==
                  org.apache.xalan.templates.Constants.
                    ELEMNAME_PARAMVARIABLE &&
                  variable.
                  getName(
                    ).
                  equals(
                    qname)) {
                varstack.
                  setGlobalVariable(
                    i,
                    xobject);
            }
        }
    }
    java.util.Vector m_userParams;
    public void setParameter(java.lang.String name,
                             java.lang.Object value) {
        if (value ==
              null) {
            throw new java.lang.IllegalArgumentException(
              org.apache.xalan.res.XSLMessages.
                createMessage(
                  org.apache.xalan.res.XSLTErrorResources.
                    ER_INVALID_SET_PARAM_VALUE,
                  new java.lang.Object[] { name }));
        }
        java.util.StringTokenizer tokenizer =
          new java.util.StringTokenizer(
          name,
          "{}",
          false);
        try {
            java.lang.String s1 =
              tokenizer.
              nextToken(
                );
            java.lang.String s2 =
              tokenizer.
              hasMoreTokens(
                )
              ? tokenizer.
              nextToken(
                )
              : null;
            if (null ==
                  m_userParams)
                m_userParams =
                  new java.util.Vector(
                    );
            if (null ==
                  s2) {
                replaceOrPushUserParam(
                  new org.apache.xml.utils.QName(
                    s1),
                  org.apache.xpath.objects.XObject.
                    create(
                      value,
                      getXPathContext(
                        )));
                setParameter(
                  s1,
                  null,
                  value);
            }
            else {
                replaceOrPushUserParam(
                  new org.apache.xml.utils.QName(
                    s1,
                    s2),
                  org.apache.xpath.objects.XObject.
                    create(
                      value,
                      getXPathContext(
                        )));
                setParameter(
                  s2,
                  s1,
                  value);
            }
        }
        catch (java.util.NoSuchElementException nsee) {
            
        }
    }
    private void replaceOrPushUserParam(org.apache.xml.utils.QName qname,
                                        org.apache.xpath.objects.XObject xval) {
        int n =
          m_userParams.
          size(
            );
        for (int i =
               n -
               1;
             i >=
               0;
             i--) {
            org.apache.xpath.Arg arg =
              (org.apache.xpath.Arg)
                m_userParams.
                elementAt(
                  i);
            if (arg.
                  getQName(
                    ).
                  equals(
                    qname)) {
                m_userParams.
                  setElementAt(
                    new org.apache.xpath.Arg(
                      qname,
                      xval,
                      true),
                    i);
                return;
            }
        }
        m_userParams.
          addElement(
            new org.apache.xpath.Arg(
              qname,
              xval,
              true));
    }
    public java.lang.Object getParameter(java.lang.String name) {
        try {
            org.apache.xml.utils.QName qname =
              org.apache.xml.utils.QName.
              getQNameFromString(
                name);
            if (null ==
                  m_userParams)
                return null;
            int n =
              m_userParams.
              size(
                );
            for (int i =
                   n -
                   1;
                 i >=
                   0;
                 i--) {
                org.apache.xpath.Arg arg =
                  (org.apache.xpath.Arg)
                    m_userParams.
                    elementAt(
                      i);
                if (arg.
                      getQName(
                        ).
                      equals(
                        qname)) {
                    return arg.
                      getVal(
                        ).
                      object(
                        );
                }
            }
            return null;
        }
        catch (java.util.NoSuchElementException nsee) {
            return null;
        }
    }
    private void resetUserParameters() { try {
                                             if (null ==
                                                   m_userParams)
                                                 return;
                                             int n =
                                               m_userParams.
                                               size(
                                                 );
                                             for (int i =
                                                    n -
                                                    1;
                                                  i >=
                                                    0;
                                                  i--) {
                                                 org.apache.xpath.Arg arg =
                                                   (org.apache.xpath.Arg)
                                                     m_userParams.
                                                     elementAt(
                                                       i);
                                                 org.apache.xml.utils.QName name =
                                                   arg.
                                                   getQName(
                                                     );
                                                 java.lang.String s1 =
                                                   name.
                                                   getNamespace(
                                                     );
                                                 java.lang.String s2 =
                                                   name.
                                                   getLocalPart(
                                                     );
                                                 setParameter(
                                                   s2,
                                                   s1,
                                                   arg.
                                                     getVal(
                                                       ).
                                                     object(
                                                       ));
                                             }
                                         }
                                         catch (java.util.NoSuchElementException nsee) {
                                             
                                         }
    }
    public void setParameters(java.util.Properties params) {
        clearParameters(
          );
        java.util.Enumeration names =
          params.
          propertyNames(
            );
        while (names.
                 hasMoreElements(
                   )) {
            java.lang.String name =
              params.
              getProperty(
                (java.lang.String)
                  names.
                  nextElement(
                    ));
            java.util.StringTokenizer tokenizer =
              new java.util.StringTokenizer(
              name,
              "{}",
              false);
            try {
                java.lang.String s1 =
                  tokenizer.
                  nextToken(
                    );
                java.lang.String s2 =
                  tokenizer.
                  hasMoreTokens(
                    )
                  ? tokenizer.
                  nextToken(
                    )
                  : null;
                if (null ==
                      s2)
                    setParameter(
                      s1,
                      null,
                      params.
                        getProperty(
                          name));
                else
                    setParameter(
                      s2,
                      s1,
                      params.
                        getProperty(
                          name));
            }
            catch (java.util.NoSuchElementException nsee) {
                
            }
        }
    }
    public void clearParameters() { synchronized (m_reentryGuard)  {
                                        org.apache.xpath.VariableStack varstack =
                                          new org.apache.xpath.VariableStack(
                                          );
                                        m_xcontext.
                                          setVarStack(
                                            varstack);
                                        m_userParams =
                                          null;
                                    } }
    protected void pushGlobalVars(int contextNode)
          throws javax.xml.transform.TransformerException {
        org.apache.xpath.XPathContext xctxt =
          m_xcontext;
        org.apache.xpath.VariableStack vs =
          xctxt.
          getVarStack(
            );
        org.apache.xalan.templates.StylesheetRoot sr =
          getStylesheet(
            );
        java.util.Vector vars =
          sr.
          getVariablesAndParamsComposed(
            );
        int i =
          vars.
          size(
            );
        vs.
          link(
            i);
        while (--i >=
                 0) {
            org.apache.xalan.templates.ElemVariable v =
              (org.apache.xalan.templates.ElemVariable)
                vars.
                elementAt(
                  i);
            org.apache.xpath.objects.XObject xobj =
              new org.apache.xalan.templates.XUnresolvedVariable(
              v,
              contextNode,
              this,
              vs.
                getStackFrame(
                  ),
              0,
              true);
            if (null ==
                  vs.
                  elementAt(
                    i))
                vs.
                  setGlobalVariable(
                    i,
                    xobj);
        }
    }
    public void setURIResolver(javax.xml.transform.URIResolver resolver) {
        synchronized (m_reentryGuard)  {
            m_xcontext.
              getSourceTreeManager(
                ).
              setURIResolver(
                resolver);
        }
    }
    public javax.xml.transform.URIResolver getURIResolver() {
        return m_xcontext.
          getSourceTreeManager(
            ).
          getURIResolver(
            );
    }
    public void setContentHandler(org.xml.sax.ContentHandler handler) {
        if (handler ==
              null) {
            throw new java.lang.NullPointerException(
              org.apache.xalan.res.XSLMessages.
                createMessage(
                  org.apache.xalan.res.XSLTErrorResources.
                    ER_NULL_CONTENT_HANDLER,
                  null));
        }
        else {
            m_outputContentHandler =
              handler;
            if (null ==
                  m_serializationHandler) {
                org.apache.xml.serializer.ToXMLSAXHandler h =
                  new org.apache.xml.serializer.ToXMLSAXHandler(
                  );
                h.
                  setContentHandler(
                    handler);
                h.
                  setTransformer(
                    this);
                m_serializationHandler =
                  h;
            }
            else
                m_serializationHandler.
                  setContentHandler(
                    handler);
        }
    }
    public org.xml.sax.ContentHandler getContentHandler() {
        return m_outputContentHandler;
    }
    public int transformToRTF(org.apache.xalan.templates.ElemTemplateElement templateParent)
          throws javax.xml.transform.TransformerException {
        org.apache.xml.dtm.DTM dtmFrag =
          m_xcontext.
          getRTFDTM(
            );
        return transformToRTF(
                 templateParent,
                 dtmFrag);
    }
    public int transformToGlobalRTF(org.apache.xalan.templates.ElemTemplateElement templateParent)
          throws javax.xml.transform.TransformerException {
        org.apache.xml.dtm.DTM dtmFrag =
          m_xcontext.
          getGlobalRTFDTM(
            );
        return transformToRTF(
                 templateParent,
                 dtmFrag);
    }
    private int transformToRTF(org.apache.xalan.templates.ElemTemplateElement templateParent,
                               org.apache.xml.dtm.DTM dtmFrag)
          throws javax.xml.transform.TransformerException {
        org.apache.xpath.XPathContext xctxt =
          m_xcontext;
        org.xml.sax.ContentHandler rtfHandler =
          dtmFrag.
          getContentHandler(
            );
        int resultFragment;
        org.apache.xml.serializer.SerializationHandler savedRTreeHandler =
          this.
            m_serializationHandler;
        org.apache.xml.serializer.ToSAXHandler h =
          new org.apache.xml.serializer.ToXMLSAXHandler(
          );
        h.
          setContentHandler(
            rtfHandler);
        h.
          setTransformer(
            this);
        m_serializationHandler =
          h;
        org.apache.xml.serializer.SerializationHandler rth =
          m_serializationHandler;
        try {
            rth.
              startDocument(
                );
            rth.
              flushPending(
                );
            try {
                executeChildTemplates(
                  templateParent,
                  true);
                rth.
                  flushPending(
                    );
                resultFragment =
                  dtmFrag.
                    getDocument(
                      );
            }
            finally {
                rth.
                  endDocument(
                    );
            }
        }
        catch (org.xml.sax.SAXException se) {
            throw new javax.xml.transform.TransformerException(
              se);
        }
        finally {
            this.
              m_serializationHandler =
              savedRTreeHandler;
        }
        return resultFragment;
    }
    public org.apache.xml.utils.ObjectPool getStringWriterPool() {
        return m_stringWriterObjectPool;
    }
    public java.lang.String transformToString(org.apache.xalan.templates.ElemTemplateElement elem)
          throws javax.xml.transform.TransformerException {
        org.apache.xalan.templates.ElemTemplateElement firstChild =
          elem.
          getFirstChildElem(
            );
        if (null ==
              firstChild)
            return "";
        if (elem.
              hasTextLitOnly(
                ) &&
              m_optimizer) {
            return ((org.apache.xalan.templates.ElemTextLiteral)
                      firstChild).
              getNodeValue(
                );
        }
        org.apache.xml.serializer.SerializationHandler savedRTreeHandler =
          this.
            m_serializationHandler;
        java.io.StringWriter sw =
          (java.io.StringWriter)
            m_stringWriterObjectPool.
            getInstance(
              );
        m_serializationHandler =
          (org.apache.xml.serializer.ToTextStream)
            m_textResultHandlerObjectPool.
            getInstance(
              );
        if (null ==
              m_serializationHandler) {
            org.apache.xml.serializer.Serializer serializer =
              org.apache.xml.serializer.SerializerFactory.
              getSerializer(
                m_textformat.
                  getProperties(
                    ));
            m_serializationHandler =
              (org.apache.xml.serializer.SerializationHandler)
                serializer;
        }
        m_serializationHandler.
          setTransformer(
            this);
        m_serializationHandler.
          setWriter(
            sw);
        java.lang.String result;
        try {
            executeChildTemplates(
              elem,
              true);
            this.
              m_serializationHandler.
              endDocument(
                );
            result =
              sw.
                toString(
                  );
        }
        catch (org.xml.sax.SAXException se) {
            throw new javax.xml.transform.TransformerException(
              se);
        }
        finally {
            sw.
              getBuffer(
                ).
              setLength(
                0);
            try {
                sw.
                  close(
                    );
            }
            catch (java.lang.Exception ioe) {
                
            }
            m_stringWriterObjectPool.
              freeInstance(
                sw);
            m_serializationHandler.
              reset(
                );
            m_textResultHandlerObjectPool.
              freeInstance(
                m_serializationHandler);
            m_serializationHandler =
              savedRTreeHandler;
        }
        return result;
    }
    public boolean applyTemplateToNode(org.apache.xalan.templates.ElemTemplateElement xslInstruction,
                                       org.apache.xalan.templates.ElemTemplate template,
                                       int child)
          throws javax.xml.transform.TransformerException {
        org.apache.xml.dtm.DTM dtm =
          m_xcontext.
          getDTM(
            child);
        short nodeType =
          dtm.
          getNodeType(
            child);
        boolean isDefaultTextRule =
          false;
        boolean isApplyImports =
          false;
        isApplyImports =
          xslInstruction ==
            null
            ? false
            : xslInstruction.
            getXSLToken(
              ) ==
            org.apache.xalan.templates.Constants.
              ELEMNAME_APPLY_IMPORTS;
        if (null ==
              template ||
              isApplyImports) {
            int maxImportLevel;
            int endImportLevel =
              0;
            if (isApplyImports) {
                maxImportLevel =
                  template.
                    getStylesheetComposed(
                      ).
                    getImportCountComposed(
                      ) -
                    1;
                endImportLevel =
                  template.
                    getStylesheetComposed(
                      ).
                    getEndImportCountComposed(
                      );
            }
            else {
                maxImportLevel =
                  -1;
            }
            if (isApplyImports &&
                  maxImportLevel ==
                  -1) {
                template =
                  null;
            }
            else {
                org.apache.xpath.XPathContext xctxt =
                  m_xcontext;
                try {
                    xctxt.
                      pushNamespaceContext(
                        xslInstruction);
                    org.apache.xml.utils.QName mode =
                      this.
                      getMode(
                        );
                    if (isApplyImports)
                        template =
                          m_stylesheetRoot.
                            getTemplateComposed(
                              xctxt,
                              child,
                              mode,
                              maxImportLevel,
                              endImportLevel,
                              m_quietConflictWarnings,
                              dtm);
                    else
                        template =
                          m_stylesheetRoot.
                            getTemplateComposed(
                              xctxt,
                              child,
                              mode,
                              m_quietConflictWarnings,
                              dtm);
                }
                finally {
                    xctxt.
                      popNamespaceContext(
                        );
                }
            }
            if (null ==
                  template) {
                switch (nodeType) {
                    case org.apache.xml.dtm.DTM.
                           DOCUMENT_FRAGMENT_NODE:
                    case org.apache.xml.dtm.DTM.
                           ELEMENT_NODE:
                        template =
                          m_stylesheetRoot.
                            getDefaultRule(
                              );
                        break;
                    case org.apache.xml.dtm.DTM.
                           CDATA_SECTION_NODE:
                    case org.apache.xml.dtm.DTM.
                           TEXT_NODE:
                    case org.apache.xml.dtm.DTM.
                           ATTRIBUTE_NODE:
                        template =
                          m_stylesheetRoot.
                            getDefaultTextRule(
                              );
                        isDefaultTextRule =
                          true;
                        break;
                    case org.apache.xml.dtm.DTM.
                           DOCUMENT_NODE:
                        template =
                          m_stylesheetRoot.
                            getDefaultRootRule(
                              );
                        break;
                    default:
                        return false;
                }
            }
        }
        try {
            pushElemTemplateElement(
              template);
            m_xcontext.
              pushCurrentNode(
                child);
            pushPairCurrentMatched(
              template,
              child);
            if (!isApplyImports) {
                org.apache.xml.dtm.DTMIterator cnl =
                  new org.apache.xpath.NodeSetDTM(
                  child,
                  m_xcontext.
                    getDTMManager(
                      ));
                m_xcontext.
                  pushContextNodeList(
                    cnl);
            }
            if (isDefaultTextRule) {
                switch (nodeType) {
                    case org.apache.xml.dtm.DTM.
                           CDATA_SECTION_NODE:
                    case org.apache.xml.dtm.DTM.
                           TEXT_NODE:
                        org.apache.xalan.transformer.ClonerToResultTree.
                          cloneToResultTree(
                            child,
                            nodeType,
                            dtm,
                            getResultTreeHandler(
                              ),
                            false);
                        break;
                    case org.apache.xml.dtm.DTM.
                           ATTRIBUTE_NODE:
                        dtm.
                          dispatchCharactersEvents(
                            child,
                            getResultTreeHandler(
                              ),
                            false);
                        break;
                }
            }
            else {
                if (m_debug)
                    getTraceManager(
                      ).
                      fireTraceEvent(
                        template);
                m_xcontext.
                  setSAXLocator(
                    template);
                m_xcontext.
                  getVarStack(
                    ).
                  link(
                    template.
                      m_frameSize);
                executeChildTemplates(
                  template,
                  true);
                if (m_debug)
                    getTraceManager(
                      ).
                      fireTraceEndEvent(
                        template);
            }
        }
        catch (org.xml.sax.SAXException se) {
            throw new javax.xml.transform.TransformerException(
              se);
        }
        finally {
            if (!isDefaultTextRule)
                m_xcontext.
                  getVarStack(
                    ).
                  unlink(
                    );
            m_xcontext.
              popCurrentNode(
                );
            if (!isApplyImports) {
                m_xcontext.
                  popContextNodeList(
                    );
            }
            popCurrentMatched(
              );
            popElemTemplateElement(
              );
        }
        return true;
    }
    public void executeChildTemplates(org.apache.xalan.templates.ElemTemplateElement elem,
                                      org.w3c.dom.Node context,
                                      org.apache.xml.utils.QName mode,
                                      org.xml.sax.ContentHandler handler)
          throws javax.xml.transform.TransformerException {
        org.apache.xpath.XPathContext xctxt =
          m_xcontext;
        try {
            if (null !=
                  mode)
                pushMode(
                  mode);
            xctxt.
              pushCurrentNode(
                xctxt.
                  getDTMHandleFromNode(
                    context));
            executeChildTemplates(
              elem,
              handler);
        }
        finally {
            xctxt.
              popCurrentNode(
                );
            if (null !=
                  mode)
                popMode(
                  );
        }
    }
    public void executeChildTemplates(org.apache.xalan.templates.ElemTemplateElement elem,
                                      boolean shouldAddAttrs)
          throws javax.xml.transform.TransformerException {
        org.apache.xalan.templates.ElemTemplateElement t =
          elem.
          getFirstChildElem(
            );
        if (null ==
              t)
            return;
        if (elem.
              hasTextLitOnly(
                ) &&
              m_optimizer) {
            char[] chars =
              ((org.apache.xalan.templates.ElemTextLiteral)
                 t).
              getChars(
                );
            try {
                this.
                  pushElemTemplateElement(
                    t);
                m_serializationHandler.
                  characters(
                    chars,
                    0,
                    chars.
                      length);
            }
            catch (org.xml.sax.SAXException se) {
                throw new javax.xml.transform.TransformerException(
                  se);
            }
            finally {
                this.
                  popElemTemplateElement(
                    );
            }
            return;
        }
        org.apache.xpath.XPathContext xctxt =
          m_xcontext;
        xctxt.
          pushSAXLocatorNull(
            );
        int currentTemplateElementsTop =
          m_currentTemplateElements.
          size(
            );
        m_currentTemplateElements.
          push(
            null);
        try {
            for (;
                 t !=
                   null;
                 t =
                   t.
                     getNextSiblingElem(
                       )) {
                if (!shouldAddAttrs &&
                      t.
                      getXSLToken(
                        ) ==
                      org.apache.xalan.templates.Constants.
                        ELEMNAME_ATTRIBUTE)
                    continue;
                xctxt.
                  setSAXLocator(
                    t);
                m_currentTemplateElements.
                  setElementAt(
                    t,
                    currentTemplateElementsTop);
                t.
                  execute(
                    this);
            }
        }
        catch (java.lang.RuntimeException re) {
            javax.xml.transform.TransformerException te =
              new javax.xml.transform.TransformerException(
              re);
            te.
              setLocator(
                t);
            throw te;
        }
        finally {
            m_currentTemplateElements.
              pop(
                );
            xctxt.
              popSAXLocator(
                );
        }
    }
    public void executeChildTemplates(org.apache.xalan.templates.ElemTemplateElement elem,
                                      org.xml.sax.ContentHandler handler)
          throws javax.xml.transform.TransformerException {
        org.apache.xml.serializer.SerializationHandler xoh =
          this.
          getSerializationHandler(
            );
        org.apache.xml.serializer.SerializationHandler savedHandler =
          xoh;
        try {
            xoh.
              flushPending(
                );
            org.xml.sax.ext.LexicalHandler lex =
              null;
            if (handler instanceof org.xml.sax.ext.LexicalHandler) {
                lex =
                  (org.xml.sax.ext.LexicalHandler)
                    handler;
            }
            m_serializationHandler =
              new org.apache.xml.serializer.ToXMLSAXHandler(
                handler,
                lex,
                savedHandler.
                  getEncoding(
                    ));
            m_serializationHandler.
              setTransformer(
                this);
            executeChildTemplates(
              elem,
              true);
        }
        catch (javax.xml.transform.TransformerException e) {
            throw e;
        }
        catch (org.xml.sax.SAXException se) {
            throw new javax.xml.transform.TransformerException(
              se);
        }
        finally {
            m_serializationHandler =
              savedHandler;
        }
    }
    public java.util.Vector processSortKeys(org.apache.xalan.templates.ElemForEach foreach,
                                            int sourceNodeContext)
          throws javax.xml.transform.TransformerException {
        java.util.Vector keys =
          null;
        org.apache.xpath.XPathContext xctxt =
          m_xcontext;
        int nElems =
          foreach.
          getSortElemCount(
            );
        if (nElems >
              0)
            keys =
              new java.util.Vector(
                );
        for (int i =
               0;
             i <
               nElems;
             i++) {
            org.apache.xalan.templates.ElemSort sort =
              foreach.
              getSortElem(
                i);
            if (m_debug)
                getTraceManager(
                  ).
                  fireTraceEvent(
                    sort);
            java.lang.String langString =
              null !=
              sort.
              getLang(
                )
              ? sort.
              getLang(
                ).
              evaluate(
                xctxt,
                sourceNodeContext,
                foreach)
              : null;
            java.lang.String dataTypeString =
              sort.
              getDataType(
                ).
              evaluate(
                xctxt,
                sourceNodeContext,
                foreach);
            if (dataTypeString.
                  indexOf(
                    ":") >=
                  0)
                java.lang.System.
                  out.
                  println(
                    "TODO: Need to write the hooks for QNAME sort data type");
            else
                if (!dataTypeString.
                      equalsIgnoreCase(
                        org.apache.xalan.templates.Constants.
                          ATTRVAL_DATATYPE_TEXT) &&
                      !dataTypeString.
                      equalsIgnoreCase(
                        org.apache.xalan.templates.Constants.
                          ATTRVAL_DATATYPE_NUMBER))
                    foreach.
                      error(
                        org.apache.xalan.res.XSLTErrorResources.
                          ER_ILLEGAL_ATTRIBUTE_VALUE,
                        new java.lang.Object[] { org.apache.xalan.templates.Constants.
                                                   ATTRNAME_DATATYPE,
                        dataTypeString });
            boolean treatAsNumbers =
              null !=
              dataTypeString &&
              dataTypeString.
              equals(
                org.apache.xalan.templates.Constants.
                  ATTRVAL_DATATYPE_NUMBER)
              ? true
              : false;
            java.lang.String orderString =
              sort.
              getOrder(
                ).
              evaluate(
                xctxt,
                sourceNodeContext,
                foreach);
            if (!orderString.
                  equalsIgnoreCase(
                    org.apache.xalan.templates.Constants.
                      ATTRVAL_ORDER_ASCENDING) &&
                  !orderString.
                  equalsIgnoreCase(
                    org.apache.xalan.templates.Constants.
                      ATTRVAL_ORDER_DESCENDING))
                foreach.
                  error(
                    org.apache.xalan.res.XSLTErrorResources.
                      ER_ILLEGAL_ATTRIBUTE_VALUE,
                    new java.lang.Object[] { org.apache.xalan.templates.Constants.
                                               ATTRNAME_ORDER,
                    orderString });
            boolean descending =
              null !=
              orderString &&
              orderString.
              equals(
                org.apache.xalan.templates.Constants.
                  ATTRVAL_ORDER_DESCENDING)
              ? true
              : false;
            org.apache.xalan.templates.AVT caseOrder =
              sort.
              getCaseOrder(
                );
            boolean caseOrderUpper;
            if (null !=
                  caseOrder) {
                java.lang.String caseOrderString =
                  caseOrder.
                  evaluate(
                    xctxt,
                    sourceNodeContext,
                    foreach);
                if (!caseOrderString.
                      equalsIgnoreCase(
                        org.apache.xalan.templates.Constants.
                          ATTRVAL_CASEORDER_UPPER) &&
                      !caseOrderString.
                      equalsIgnoreCase(
                        org.apache.xalan.templates.Constants.
                          ATTRVAL_CASEORDER_LOWER))
                    foreach.
                      error(
                        org.apache.xalan.res.XSLTErrorResources.
                          ER_ILLEGAL_ATTRIBUTE_VALUE,
                        new java.lang.Object[] { org.apache.xalan.templates.Constants.
                                                   ATTRNAME_CASEORDER,
                        caseOrderString });
                caseOrderUpper =
                  null !=
                    caseOrderString &&
                    caseOrderString.
                    equals(
                      org.apache.xalan.templates.Constants.
                        ATTRVAL_CASEORDER_UPPER)
                    ? true
                    : false;
            }
            else {
                caseOrderUpper =
                  false;
            }
            keys.
              addElement(
                new org.apache.xalan.transformer.NodeSortKey(
                  this,
                  sort.
                    getSelect(
                      ),
                  treatAsNumbers,
                  descending,
                  langString,
                  caseOrderUpper,
                  foreach));
            if (m_debug)
                getTraceManager(
                  ).
                  fireTraceEndEvent(
                    sort);
        }
        return keys;
    }
    public java.util.Vector getElementCallstack() {
        java.util.Vector elems =
          new java.util.Vector(
          );
        int nStackSize =
          m_currentTemplateElements.
          size(
            );
        for (int i =
               0;
             i <
               nStackSize;
             i++) {
            org.apache.xalan.templates.ElemTemplateElement elem =
              (org.apache.xalan.templates.ElemTemplateElement)
                m_currentTemplateElements.
                elementAt(
                  i);
            if (null !=
                  elem) {
                elems.
                  addElement(
                    elem);
            }
        }
        return elems;
    }
    public int getCurrentTemplateElementsCount() {
        return m_currentTemplateElements.
          size(
            );
    }
    public org.apache.xml.utils.ObjectStack getCurrentTemplateElements() {
        return m_currentTemplateElements;
    }
    public void pushElemTemplateElement(org.apache.xalan.templates.ElemTemplateElement elem) {
        m_currentTemplateElements.
          push(
            elem);
    }
    public void popElemTemplateElement() {
        m_currentTemplateElements.
          pop(
            );
    }
    public void setCurrentElement(org.apache.xalan.templates.ElemTemplateElement e) {
        m_currentTemplateElements.
          setTop(
            e);
    }
    public org.apache.xalan.templates.ElemTemplateElement getCurrentElement() {
        return m_currentTemplateElements.
          size(
            ) >
          0
          ? (org.apache.xalan.templates.ElemTemplateElement)
              m_currentTemplateElements.
              peek(
                )
          : null;
    }
    public int getCurrentNode() { return m_xcontext.
                                    getCurrentNode(
                                      ); }
    public java.util.Vector getTemplateCallstack() {
        java.util.Vector elems =
          new java.util.Vector(
          );
        int nStackSize =
          m_currentTemplateElements.
          size(
            );
        for (int i =
               0;
             i <
               nStackSize;
             i++) {
            org.apache.xalan.templates.ElemTemplateElement elem =
              (org.apache.xalan.templates.ElemTemplateElement)
                m_currentTemplateElements.
                elementAt(
                  i);
            if (null !=
                  elem &&
                  elem.
                  getXSLToken(
                    ) !=
                  org.apache.xalan.templates.Constants.
                    ELEMNAME_TEMPLATE) {
                elems.
                  addElement(
                    elem);
            }
        }
        return elems;
    }
    public org.apache.xalan.templates.ElemTemplate getCurrentTemplate() {
        org.apache.xalan.templates.ElemTemplateElement elem =
          getCurrentElement(
            );
        while (null !=
                 elem &&
                 elem.
                 getXSLToken(
                   ) !=
                 org.apache.xalan.templates.Constants.
                   ELEMNAME_TEMPLATE) {
            elem =
              elem.
                getParentElem(
                  );
        }
        return (org.apache.xalan.templates.ElemTemplate)
                 elem;
    }
    public void pushPairCurrentMatched(org.apache.xalan.templates.ElemTemplateElement template,
                                       int child) {
        m_currentMatchTemplates.
          push(
            template);
        m_currentMatchedNodes.
          push(
            child);
    }
    public void popCurrentMatched() { m_currentMatchTemplates.
                                        pop(
                                          );
                                      m_currentMatchedNodes.
                                        pop(
                                          );
    }
    public org.apache.xalan.templates.ElemTemplate getMatchedTemplate() {
        return (org.apache.xalan.templates.ElemTemplate)
                 m_currentMatchTemplates.
                 peek(
                   );
    }
    public int getMatchedNode() { return m_currentMatchedNodes.
                                    peepTail(
                                      ); }
    public org.apache.xml.dtm.DTMIterator getContextNodeList() {
        try {
            org.apache.xml.dtm.DTMIterator cnl =
              m_xcontext.
              getContextNodeList(
                );
            return cnl ==
              null
              ? null
              : (org.apache.xml.dtm.DTMIterator)
                  cnl.
                  cloneWithReset(
                    );
        }
        catch (java.lang.CloneNotSupportedException cnse) {
            return null;
        }
    }
    public javax.xml.transform.Transformer getTransformer() {
        return this;
    }
    public void setStylesheet(org.apache.xalan.templates.StylesheetRoot stylesheetRoot) {
        m_stylesheetRoot =
          stylesheetRoot;
    }
    public final org.apache.xalan.templates.StylesheetRoot getStylesheet() {
        return m_stylesheetRoot;
    }
    public boolean getQuietConflictWarnings() {
        return m_quietConflictWarnings;
    }
    public void setQuietConflictWarnings(boolean b) {
        m_quietConflictWarnings =
          b;
    }
    public void setXPathContext(org.apache.xpath.XPathContext xcontext) {
        m_xcontext =
          xcontext;
    }
    public final org.apache.xpath.XPathContext getXPathContext() {
        return m_xcontext;
    }
    public org.apache.xalan.transformer.StackGuard getStackGuard() {
        return m_stackGuard;
    }
    public int getRecursionLimit() { return m_stackGuard.
                                       getRecursionLimit(
                                         );
    }
    public void setRecursionLimit(int limit) {
        m_stackGuard.
          setRecursionLimit(
            limit);
    }
    public org.apache.xml.serializer.SerializationHandler getResultTreeHandler() {
        return m_serializationHandler;
    }
    public org.apache.xml.serializer.SerializationHandler getSerializationHandler() {
        return m_serializationHandler;
    }
    public org.apache.xalan.transformer.KeyManager getKeyManager() {
        return m_keyManager;
    }
    public boolean isRecursiveAttrSet(org.apache.xalan.templates.ElemAttributeSet attrSet) {
        if (null ==
              m_attrSetStack) {
            m_attrSetStack =
              new java.util.Stack(
                );
        }
        if (!m_attrSetStack.
              empty(
                )) {
            int loc =
              m_attrSetStack.
              search(
                attrSet);
            if (loc >
                  -1) {
                return true;
            }
        }
        return false;
    }
    public void pushElemAttributeSet(org.apache.xalan.templates.ElemAttributeSet attrSet) {
        m_attrSetStack.
          push(
            attrSet);
    }
    public void popElemAttributeSet() { m_attrSetStack.
                                          pop(
                                            );
    }
    public org.apache.xalan.transformer.CountersTable getCountersTable() {
        if (null ==
              m_countersTable)
            m_countersTable =
              new org.apache.xalan.transformer.CountersTable(
                );
        return m_countersTable;
    }
    public boolean currentTemplateRuleIsNull() {
        return !m_currentTemplateRuleIsNull.
          isEmpty(
            ) &&
          m_currentTemplateRuleIsNull.
          peek(
            ) ==
          true;
    }
    public void pushCurrentTemplateRuleIsNull(boolean b) {
        m_currentTemplateRuleIsNull.
          push(
            b);
    }
    public void popCurrentTemplateRuleIsNull() {
        m_currentTemplateRuleIsNull.
          pop(
            );
    }
    public void pushCurrentFuncResult(java.lang.Object val) {
        m_currentFuncResult.
          push(
            val);
    }
    public java.lang.Object popCurrentFuncResult() {
        return m_currentFuncResult.
          pop(
            );
    }
    public boolean currentFuncResultSeen() {
        return !m_currentFuncResult.
          empty(
            ) &&
          m_currentFuncResult.
          peek(
            ) !=
          null;
    }
    public org.apache.xalan.transformer.MsgMgr getMsgMgr() {
        if (null ==
              m_msgMgr)
            m_msgMgr =
              new org.apache.xalan.transformer.MsgMgr(
                this);
        return m_msgMgr;
    }
    public void setErrorListener(javax.xml.transform.ErrorListener listener)
          throws java.lang.IllegalArgumentException {
        synchronized (m_reentryGuard)  {
            if (listener ==
                  null)
                throw new java.lang.IllegalArgumentException(
                  org.apache.xalan.res.XSLMessages.
                    createMessage(
                      org.apache.xalan.res.XSLTErrorResources.
                        ER_NULL_ERROR_HANDLER,
                      null));
            m_errorHandler =
              listener;
        }
    }
    public javax.xml.transform.ErrorListener getErrorListener() {
        return m_errorHandler;
    }
    public org.apache.xalan.trace.TraceManager getTraceManager() {
        return m_traceManager;
    }
    public boolean getFeature(java.lang.String name)
          throws org.xml.sax.SAXNotRecognizedException,
        org.xml.sax.SAXNotSupportedException {
        if ("http://xml.org/trax/features/sax/input".
              equals(
                name))
            return true;
        else
            if ("http://xml.org/trax/features/dom/input".
                  equals(
                    name))
                return true;
        throw new org.xml.sax.SAXNotRecognizedException(
          name);
    }
    public org.apache.xml.utils.QName getMode() {
        return m_modes.
          isEmpty(
            )
          ? null
          : (org.apache.xml.utils.QName)
              m_modes.
              peek(
                );
    }
    public void pushMode(org.apache.xml.utils.QName mode) {
        m_modes.
          push(
            mode);
    }
    public void popMode() { m_modes.pop();
    }
    public void runTransformThread(int priority) {
        java.lang.Thread t =
          org.apache.xml.utils.ThreadControllerWrapper.
          runThread(
            this,
            priority);
        this.
          setTransformThread(
            t);
    }
    public void runTransformThread() { org.apache.xml.utils.ThreadControllerWrapper.
                                         runThread(
                                           this,
                                           -1);
    }
    public static void runTransformThread(java.lang.Runnable runnable) {
        org.apache.xml.utils.ThreadControllerWrapper.
          runThread(
            runnable,
            -1);
    }
    public void waitTransformThread() throws org.xml.sax.SAXException {
        java.lang.Thread transformThread =
          this.
          getTransformThread(
            );
        if (null !=
              transformThread) {
            try {
                org.apache.xml.utils.ThreadControllerWrapper.
                  waitThread(
                    transformThread,
                    this);
                if (!this.
                      hasTransformThreadErrorCatcher(
                        )) {
                    java.lang.Exception e =
                      this.
                      getExceptionThrown(
                        );
                    if (null !=
                          e) {
                        e.
                          printStackTrace(
                            );
                        throw new org.xml.sax.SAXException(
                          e);
                    }
                }
                this.
                  setTransformThread(
                    null);
            }
            catch (java.lang.InterruptedException ie) {
                
            }
        }
    }
    public java.lang.Exception getExceptionThrown() {
        return m_exceptionThrown;
    }
    public void setExceptionThrown(java.lang.Exception e) {
        m_exceptionThrown =
          e;
    }
    public void setSourceTreeDocForThread(int doc) {
        m_doc =
          doc;
    }
    public void setXMLSource(javax.xml.transform.Source source) {
        m_xmlSource =
          source;
    }
    public boolean isTransformDone() { synchronized (this)  {
                                           return m_isTransformDone;
                                       } }
    public void setIsTransformDone(boolean done) {
        synchronized (this)  {
            m_isTransformDone =
              done;
        }
    }
    void postExceptionFromThread(java.lang.Exception e) {
        m_isTransformDone =
          true;
        m_exceptionThrown =
          e;
        ;
        synchronized (this)  {
            notifyAll(
              );
        }
    }
    public void run() { m_hasBeenReset = false;
                        try { try { m_isTransformDone =
                                      false;
                                    transformNode(
                                      m_doc);
                              }
                              catch (java.lang.Exception e) {
                                  if (null !=
                                        m_transformThread)
                                      postExceptionFromThread(
                                        e);
                                  else
                                      throw new java.lang.RuntimeException(
                                        e.
                                          getMessage(
                                            ));
                              }
                              finally {
                                  m_isTransformDone =
                                    true;
                                  if (m_inputContentHandler instanceof org.apache.xalan.transformer.TransformerHandlerImpl) {
                                      ((org.apache.xalan.transformer.TransformerHandlerImpl)
                                         m_inputContentHandler).
                                        clearCoRoutine(
                                          );
                                  }
                              } }
                        catch (java.lang.Exception e) {
                            if (null !=
                                  m_transformThread)
                                postExceptionFromThread(
                                  e);
                            else
                                throw new java.lang.RuntimeException(
                                  e.
                                    getMessage(
                                      ));
                        } }
    public org.apache.xalan.transformer.TransformSnapshot getSnapshot() {
        return new org.apache.xalan.transformer.TransformSnapshotImpl(
          this);
    }
    public void executeFromSnapshot(org.apache.xalan.transformer.TransformSnapshot ts)
          throws javax.xml.transform.TransformerException {
        org.apache.xalan.templates.ElemTemplateElement template =
          getMatchedTemplate(
            );
        int child =
          getMatchedNode(
            );
        pushElemTemplateElement(
          template);
        m_xcontext.
          pushCurrentNode(
            child);
        this.
          executeChildTemplates(
            template,
            true);
    }
    public void resetToStylesheet(org.apache.xalan.transformer.TransformSnapshot ts) {
        ((org.apache.xalan.transformer.TransformSnapshotImpl)
           ts).
          apply(
            this);
    }
    public void stopTransformation() {  }
    public short getShouldStripSpace(int elementHandle,
                                     org.apache.xml.dtm.DTM dtm) {
        try {
            org.apache.xalan.templates.WhiteSpaceInfo info =
              m_stylesheetRoot.
              getWhiteSpaceInfo(
                m_xcontext,
                elementHandle,
                dtm);
            if (null ==
                  info) {
                return org.apache.xml.dtm.DTMWSFilter.
                         INHERIT;
            }
            else {
                return info.
                  getShouldStripSpace(
                    )
                  ? org.apache.xml.dtm.DTMWSFilter.
                      STRIP
                  : org.apache.xml.dtm.DTMWSFilter.
                      NOTSTRIP;
            }
        }
        catch (javax.xml.transform.TransformerException se) {
            return org.apache.xml.dtm.DTMWSFilter.
                     INHERIT;
        }
    }
    public void init(org.apache.xml.serializer.ToXMLSAXHandler h,
                     javax.xml.transform.Transformer transformer,
                     org.xml.sax.ContentHandler realHandler) {
        h.
          setTransformer(
            transformer);
        h.
          setContentHandler(
            realHandler);
    }
    public void setSerializationHandler(org.apache.xml.serializer.SerializationHandler xoh) {
        m_serializationHandler =
          xoh;
    }
    public void fireGenerateEvent(int eventType,
                                  char[] ch,
                                  int start,
                                  int length) {
        org.apache.xalan.trace.GenerateEvent ge =
          new org.apache.xalan.trace.GenerateEvent(
          this,
          eventType,
          ch,
          start,
          length);
        m_traceManager.
          fireGenerateEvent(
            ge);
    }
    public void fireGenerateEvent(int eventType,
                                  java.lang.String name,
                                  org.xml.sax.Attributes atts) {
        org.apache.xalan.trace.GenerateEvent ge =
          new org.apache.xalan.trace.GenerateEvent(
          this,
          eventType,
          name,
          atts);
        m_traceManager.
          fireGenerateEvent(
            ge);
    }
    public void fireGenerateEvent(int eventType,
                                  java.lang.String name,
                                  java.lang.String data) {
        org.apache.xalan.trace.GenerateEvent ge =
          new org.apache.xalan.trace.GenerateEvent(
          this,
          eventType,
          name,
          data);
        m_traceManager.
          fireGenerateEvent(
            ge);
    }
    public void fireGenerateEvent(int eventType,
                                  java.lang.String data) {
        org.apache.xalan.trace.GenerateEvent ge =
          new org.apache.xalan.trace.GenerateEvent(
          this,
          eventType,
          data);
        m_traceManager.
          fireGenerateEvent(
            ge);
    }
    public void fireGenerateEvent(int eventType) {
        org.apache.xalan.trace.GenerateEvent ge =
          new org.apache.xalan.trace.GenerateEvent(
          this,
          eventType);
        m_traceManager.
          fireGenerateEvent(
            ge);
    }
    public boolean hasTraceListeners() { return m_traceManager.
                                           hasTraceListeners(
                                             );
    }
    public boolean getDebug() { return m_debug;
    }
    public void setDebug(boolean b) { m_debug =
                                        b;
    }
    public boolean getIncremental() { return m_incremental;
    }
    public boolean getOptimize() { return m_optimizer;
    }
    public boolean getSource_location() {
        return m_source_location;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cvcQl+x2i/svuvZipMQka3lVXOwa3gTt");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("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" +
       "UE14ywAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5yue1PmR1NnVj9r+qN8tNn/y18Dmz96w+bE72PzHL8PmI8kb1cX77cqwfpLI" +
       "+fwP30L5o6+Ikhtff+EG5V+4A+WfexmUX3g955f69eLtfvctZH/+FfX4nFH+" +
       "9A2yv3YHsr/4Jnr8ZckbTlOO1Xat3riz8xrvOXF5qASfeIESKLXtRLdY/Oev" +
       "yOKceP2dGxZ/5w4W/9WbsPh1j1jwdu0ED6lUTyU2T6ddst1dVh3fcP6i9HM/" +
       "+0dPP/aj13nL3q7G8mBy1wL2s2vo5+WPT79gCefx0uY/3/yGz/+j/1n/Lfdv" +
       "gL/v6Yl494sm4qE0PvC4Dnw0+T99SwI/8YoSgMfXz98M/PN3SOBn3jzePCkB" +
       "zxUy13ukQ893JOcuuneuWW8R+NlXNFFofP3CDYFfuIPA330ZE3397EieXDM4" +
       "Hwdvoft7vwZ0v3SD7pfuQPdzL4Nu1PKiCb1zRDzEoVPv7DIdnd7lom+9BfIf" +
       "vCLIrxxf/+wG5D+7A+QvvAzI9yZv9M7105SH0v/Yk9I/L0s/MMSxvXnmcgv4" +
       "L/4agP/KDfBfuQP4P31J91ydLeqp8vhrXrj2qzzqf4vEL78iibMF/uoNiV+9" +
       "g8S/esmsqXryadWtvO/BLTt82PfM5TmX3WL1K6/IaoxP9+5fd73++yyre/df" +
       "UjSRN/B2avuPubxYNOyj/k+TuPfaKzrHj49g3nND4j13kHjfmzjHsaSw67pU" +
       "vOuAeen3k884/7uHeeTkb3n6e1/46pXFvfffjPL+O8h8yZuQ+cDo6bPm/FSy" +
       "Us8rvg/l8ZkXygN/8pJbLL70FVn8hhH9h25YfOgOFh97Exa//pm8R25ij66E" +
       "Jn6U/n78uVHrvEz2nLzn3sdfPere++gNi4/eweKr34TFhx6xIJvUeVxH/5Vb" +
       "2L7mFS13xHPvEzfYPnEHtm94Gct9T/JGUvm8/8hqv+qFWsJf+t4C/+AVwX96" +
       "BPG1N+C/9g7w8MuAf99YguZ1mJz94/nQrRh7D3lFYCOYe+ANMPAOYL/xZYB9" +
       "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" +
       "SEJWq/FpmcyXLJdoirKPozxa2gSSzkUu");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "aGw57apUbit9LbmCICcCMnUXx2UfSv2c");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "xvmWTqA16T+BZsSj5qJlGDBneD5bkJ/s");
    public static final java.lang.String jlc$ClassType$jl5$3 =
      ("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");
}
