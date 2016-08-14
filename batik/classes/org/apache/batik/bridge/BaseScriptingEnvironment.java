package org.apache.batik.bridge;
public class BaseScriptingEnvironment {
    public static final java.lang.String INLINE_SCRIPT_DESCRIPTION = "BaseScriptingEnvironment.constant.inline.script.description";
    public static final java.lang.String EVENT_SCRIPT_DESCRIPTION = "BaseScriptingEnvironment.constant.event.script.description";
    public static boolean isDynamicDocument(org.apache.batik.bridge.BridgeContext ctx,
                                            org.w3c.dom.Document doc) {
        org.w3c.dom.Element elt =
          doc.
          getDocumentElement(
            );
        if (elt !=
              null &&
              org.apache.batik.util.SVGConstants.
                SVG_NAMESPACE_URI.
              equals(
                elt.
                  getNamespaceURI(
                    ))) {
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONABORT_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONERROR_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONRESIZE_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONUNLOAD_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONSCROLL_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONZOOM_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            return isDynamicElement(
                     ctx,
                     doc.
                       getDocumentElement(
                         ));
        }
        return false;
    }
    public static boolean isDynamicElement(org.apache.batik.bridge.BridgeContext ctx,
                                           org.w3c.dom.Element elt) {
        java.util.List bridgeExtensions =
          ctx.
          getBridgeExtensions(
            elt.
              getOwnerDocument(
                ));
        return isDynamicElement(
                 elt,
                 ctx,
                 bridgeExtensions);
    }
    public static boolean isDynamicElement(org.w3c.dom.Element elt,
                                           org.apache.batik.bridge.BridgeContext ctx,
                                           java.util.List bridgeExtensions) {
        java.util.Iterator i =
          bridgeExtensions.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.bridge.BridgeExtension bridgeExtension =
              (org.apache.batik.bridge.BridgeExtension)
                i.
                next(
                  );
            if (bridgeExtension.
                  isDynamicElement(
                    elt)) {
                return true;
            }
        }
        if (org.apache.batik.util.SVGConstants.
              SVG_NAMESPACE_URI.
              equals(
                elt.
                  getNamespaceURI(
                    ))) {
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONKEYUP_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONKEYDOWN_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONKEYPRESS_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONLOAD_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONERROR_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONACTIVATE_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONCLICK_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONFOCUSIN_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONFOCUSOUT_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONMOUSEDOWN_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONMOUSEMOVE_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONMOUSEOUT_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONMOUSEOVER_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
            if (elt.
                  getAttributeNS(
                    null,
                    org.apache.batik.util.SVGConstants.
                      SVG_ONMOUSEUP_ATTRIBUTE).
                  length(
                    ) >
                  0) {
                return true;
            }
        }
        for (org.w3c.dom.Node n =
               elt.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                if (isDynamicElement(
                      ctx,
                      (org.w3c.dom.Element)
                        n)) {
                    return true;
                }
            }
        }
        return false;
    }
    protected static final java.lang.String EVENT_NAME =
      "event";
    protected static final java.lang.String ALTERNATE_EVENT_NAME =
      "evt";
    protected static final java.lang.String APPLICATION_ECMASCRIPT =
      "application/ecmascript";
    protected org.apache.batik.bridge.BridgeContext
      bridgeContext;
    protected org.apache.batik.bridge.UserAgent userAgent;
    protected org.w3c.dom.Document document;
    protected org.apache.batik.util.ParsedURL docPURL;
    protected java.util.Set languages = new java.util.HashSet(
      );
    protected org.apache.batik.script.Interpreter
      interpreter;
    public BaseScriptingEnvironment(org.apache.batik.bridge.BridgeContext ctx) {
        super(
          );
        bridgeContext =
          ctx;
        document =
          ctx.
            getDocument(
              );
        docPURL =
          new org.apache.batik.util.ParsedURL(
            ((org.w3c.dom.svg.SVGDocument)
               document).
              getURL(
                ));
        userAgent =
          bridgeContext.
            getUserAgent(
              );
    }
    public org.apache.batik.script.Window createWindow(org.apache.batik.script.Interpreter interp,
                                                       java.lang.String lang) {
        return new org.apache.batik.bridge.BaseScriptingEnvironment.Window(
          interp,
          lang);
    }
    public org.apache.batik.script.Window createWindow() {
        return createWindow(
                 null,
                 null);
    }
    public org.apache.batik.script.Interpreter getInterpreter() {
        if (interpreter !=
              null)
            return interpreter;
        org.w3c.dom.svg.SVGSVGElement root =
          (org.w3c.dom.svg.SVGSVGElement)
            document.
            getDocumentElement(
              );
        java.lang.String lang =
          root.
          getContentScriptType(
            );
        return getInterpreter(
                 lang);
    }
    public org.apache.batik.script.Interpreter getInterpreter(java.lang.String lang) {
        interpreter =
          bridgeContext.
            getInterpreter(
              lang);
        if (interpreter ==
              null) {
            if (languages.
                  contains(
                    lang)) {
                return null;
            }
            languages.
              add(
                lang);
            return null;
        }
        if (!languages.
              contains(
                lang)) {
            languages.
              add(
                lang);
            initializeEnvironment(
              interpreter,
              lang);
        }
        return interpreter;
    }
    public void initializeEnvironment(org.apache.batik.script.Interpreter interp,
                                      java.lang.String lang) {
        interp.
          bindObject(
            "window",
            createWindow(
              interp,
              lang));
    }
    public void loadScripts() { org.apache.batik.script.Window window =
                                  null;
                                org.w3c.dom.NodeList scripts =
                                  document.
                                  getElementsByTagNameNS(
                                    org.apache.batik.util.SVGConstants.
                                      SVG_NAMESPACE_URI,
                                    org.apache.batik.util.SVGConstants.
                                      SVG_SCRIPT_TAG);
                                int len =
                                  scripts.
                                  getLength(
                                    );
                                if (len ==
                                      0) {
                                    return;
                                }
                                for (int i =
                                       0;
                                     i <
                                       len;
                                     i++) {
                                    org.apache.batik.dom.AbstractElement script =
                                      (org.apache.batik.dom.AbstractElement)
                                        scripts.
                                        item(
                                          i);
                                    java.lang.String type =
                                      script.
                                      getAttributeNS(
                                        null,
                                        org.apache.batik.util.SVGConstants.
                                          SVG_TYPE_ATTRIBUTE);
                                    if (type.
                                          length(
                                            ) ==
                                          0) {
                                        type =
                                          org.apache.batik.util.SVGConstants.
                                            SVG_SCRIPT_TYPE_DEFAULT_VALUE;
                                    }
                                    if (type.
                                          equals(
                                            org.apache.batik.util.SVGConstants.
                                              SVG_SCRIPT_TYPE_JAVA)) {
                                        try {
                                            java.lang.String href =
                                              org.apache.batik.dom.util.XLinkSupport.
                                              getXLinkHref(
                                                script);
                                            org.apache.batik.util.ParsedURL purl =
                                              new org.apache.batik.util.ParsedURL(
                                              script.
                                                getBaseURI(
                                                  ),
                                              href);
                                            checkCompatibleScriptURL(
                                              type,
                                              purl);
                                            org.apache.batik.bridge.DocumentJarClassLoader cll;
                                            java.net.URL docURL =
                                              null;
                                            try {
                                                docURL =
                                                  new java.net.URL(
                                                    docPURL.
                                                      toString(
                                                        ));
                                            }
                                            catch (java.net.MalformedURLException mue) {
                                                
                                            }
                                            cll =
                                              new org.apache.batik.bridge.DocumentJarClassLoader(
                                                new java.net.URL(
                                                  purl.
                                                    toString(
                                                      )),
                                                docURL);
                                            java.net.URL url =
                                              cll.
                                              findResource(
                                                "META-INF/MANIFEST.MF");
                                            if (url ==
                                                  null) {
                                                continue;
                                            }
                                            java.util.jar.Manifest man =
                                              new java.util.jar.Manifest(
                                              url.
                                                openStream(
                                                  ));
                                            java.lang.String sh;
                                            sh =
                                              man.
                                                getMainAttributes(
                                                  ).
                                                getValue(
                                                  "Script-Handler");
                                            if (sh !=
                                                  null) {
                                                org.apache.batik.script.ScriptHandler h;
                                                h =
                                                  (org.apache.batik.script.ScriptHandler)
                                                    cll.
                                                    loadClass(
                                                      sh).
                                                    newInstance(
                                                      );
                                                if (window ==
                                                      null) {
                                                    window =
                                                      createWindow(
                                                        );
                                                }
                                                h.
                                                  run(
                                                    document,
                                                    window);
                                            }
                                            sh =
                                              man.
                                                getMainAttributes(
                                                  ).
                                                getValue(
                                                  "SVG-Handler-Class");
                                            if (sh !=
                                                  null) {
                                                org.w3c.dom.svg.EventListenerInitializer initializer;
                                                initializer =
                                                  (org.w3c.dom.svg.EventListenerInitializer)
                                                    cll.
                                                    loadClass(
                                                      sh).
                                                    newInstance(
                                                      );
                                                if (window ==
                                                      null) {
                                                    window =
                                                      createWindow(
                                                        );
                                                }
                                                initializer.
                                                  initializeEventListeners(
                                                    (org.w3c.dom.svg.SVGDocument)
                                                      document);
                                            }
                                        }
                                        catch (java.lang.Exception e) {
                                            if (userAgent !=
                                                  null) {
                                                userAgent.
                                                  displayError(
                                                    e);
                                            }
                                        }
                                        continue;
                                    }
                                    org.apache.batik.script.Interpreter interpreter =
                                      getInterpreter(
                                        type);
                                    if (interpreter ==
                                          null)
                                        continue;
                                    try {
                                        java.lang.String href =
                                          org.apache.batik.dom.util.XLinkSupport.
                                          getXLinkHref(
                                            script);
                                        java.lang.String desc =
                                          null;
                                        java.io.Reader reader =
                                          null;
                                        if (href.
                                              length(
                                                ) >
                                              0) {
                                            desc =
                                              href;
                                            org.apache.batik.util.ParsedURL purl =
                                              new org.apache.batik.util.ParsedURL(
                                              script.
                                                getBaseURI(
                                                  ),
                                              href);
                                            checkCompatibleScriptURL(
                                              type,
                                              purl);
                                            java.io.InputStream is =
                                              purl.
                                              openStream(
                                                );
                                            java.lang.String mediaType =
                                              purl.
                                              getContentTypeMediaType(
                                                );
                                            java.lang.String enc =
                                              purl.
                                              getContentTypeCharset(
                                                );
                                            if (enc !=
                                                  null) {
                                                try {
                                                    reader =
                                                      new java.io.InputStreamReader(
                                                        is,
                                                        enc);
                                                }
                                                catch (java.io.UnsupportedEncodingException uee) {
                                                    enc =
                                                      null;
                                                }
                                            }
                                            if (reader ==
                                                  null) {
                                                if (APPLICATION_ECMASCRIPT.
                                                      equals(
                                                        mediaType)) {
                                                    if (purl.
                                                          hasContentTypeParameter(
                                                            "version")) {
                                                        continue;
                                                    }
                                                    java.io.PushbackInputStream pbis =
                                                      new java.io.PushbackInputStream(
                                                      is,
                                                      8);
                                                    byte[] buf =
                                                      new byte[4];
                                                    int read =
                                                      pbis.
                                                      read(
                                                        buf);
                                                    if (read >
                                                          0) {
                                                        pbis.
                                                          unread(
                                                            buf,
                                                            0,
                                                            read);
                                                        if (read >=
                                                              2) {
                                                            if (buf[0] ==
                                                                  (byte)
                                                                    255 &&
                                                                  buf[1] ==
                                                                  (byte)
                                                                    254) {
                                                                if (read >=
                                                                      4 &&
                                                                      buf[2] ==
                                                                      0 &&
                                                                      buf[3] ==
                                                                      0) {
                                                                    enc =
                                                                      "UTF32-LE";
                                                                    pbis.
                                                                      skip(
                                                                        4);
                                                                }
                                                                else {
                                                                    enc =
                                                                      "UTF-16LE";
                                                                    pbis.
                                                                      skip(
                                                                        2);
                                                                }
                                                            }
                                                            else
                                                                if (buf[0] ==
                                                                      (byte)
                                                                        254 &&
                                                                      buf[1] ==
                                                                      (byte)
                                                                        255) {
                                                                    enc =
                                                                      "UTF-16BE";
                                                                    pbis.
                                                                      skip(
                                                                        2);
                                                                }
                                                                else
                                                                    if (read >=
                                                                          3 &&
                                                                          buf[0] ==
                                                                          (byte)
                                                                            239 &&
                                                                          buf[1] ==
                                                                          (byte)
                                                                            187 &&
                                                                          buf[2] ==
                                                                          (byte)
                                                                            191) {
                                                                        enc =
                                                                          "UTF-8";
                                                                        pbis.
                                                                          skip(
                                                                            3);
                                                                    }
                                                                    else
                                                                        if (read >=
                                                                              4 &&
                                                                              buf[0] ==
                                                                              0 &&
                                                                              buf[1] ==
                                                                              0 &&
                                                                              buf[2] ==
                                                                              (byte)
                                                                                254 &&
                                                                              buf[3] ==
                                                                              (byte)
                                                                                255) {
                                                                            enc =
                                                                              "UTF-32BE";
                                                                            pbis.
                                                                              skip(
                                                                                4);
                                                                        }
                                                        }
                                                        if (enc ==
                                                              null) {
                                                            enc =
                                                              "UTF-8";
                                                        }
                                                    }
                                                    reader =
                                                      new java.io.InputStreamReader(
                                                        pbis,
                                                        enc);
                                                }
                                                else {
                                                    reader =
                                                      new java.io.InputStreamReader(
                                                        is);
                                                }
                                            }
                                        }
                                        else {
                                            checkCompatibleScriptURL(
                                              type,
                                              docPURL);
                                            org.apache.batik.bridge.DocumentLoader dl =
                                              bridgeContext.
                                              getDocumentLoader(
                                                );
                                            org.w3c.dom.Element e =
                                              script;
                                            org.w3c.dom.svg.SVGDocument d =
                                              (org.w3c.dom.svg.SVGDocument)
                                                e.
                                                getOwnerDocument(
                                                  );
                                            int line =
                                              dl.
                                              getLineNumber(
                                                script);
                                            desc =
                                              org.apache.batik.bridge.Messages.
                                                formatMessage(
                                                  INLINE_SCRIPT_DESCRIPTION,
                                                  new java.lang.Object[] { d.
                                                    getURL(
                                                      ),
                                                  "<" +
                                                  script.
                                                    getNodeName(
                                                      ) +
                                                  ">",
                                                  new java.lang.Integer(
                                                    line) });
                                            org.w3c.dom.Node n =
                                              script.
                                              getFirstChild(
                                                );
                                            if (n !=
                                                  null) {
                                                java.lang.StringBuffer sb =
                                                  new java.lang.StringBuffer(
                                                  );
                                                while (n !=
                                                         null) {
                                                    if (n.
                                                          getNodeType(
                                                            ) ==
                                                          org.w3c.dom.Node.
                                                            CDATA_SECTION_NODE ||
                                                          n.
                                                          getNodeType(
                                                            ) ==
                                                          org.w3c.dom.Node.
                                                            TEXT_NODE)
                                                        sb.
                                                          append(
                                                            n.
                                                              getNodeValue(
                                                                ));
                                                    n =
                                                      n.
                                                        getNextSibling(
                                                          );
                                                }
                                                reader =
                                                  new java.io.StringReader(
                                                    sb.
                                                      toString(
                                                        ));
                                            }
                                            else {
                                                continue;
                                            }
                                        }
                                        interpreter.
                                          evaluate(
                                            reader,
                                            desc);
                                    }
                                    catch (java.io.IOException e) {
                                        if (userAgent !=
                                              null) {
                                            userAgent.
                                              displayError(
                                                e);
                                        }
                                        return;
                                    }
                                    catch (org.apache.batik.script.InterpreterException e) {
                                        java.lang.System.
                                          err.
                                          println(
                                            "InterpExcept: " +
                                            e);
                                        handleInterpreterException(
                                          e);
                                        return;
                                    }
                                    catch (java.lang.SecurityException e) {
                                        if (userAgent !=
                                              null) {
                                            userAgent.
                                              displayError(
                                                e);
                                        }
                                    }
                                } }
    protected void checkCompatibleScriptURL(java.lang.String scriptType,
                                            org.apache.batik.util.ParsedURL scriptPURL) {
        userAgent.
          checkLoadScript(
            scriptType,
            scriptPURL,
            docPURL);
    }
    public void dispatchSVGLoadEvent() { org.w3c.dom.svg.SVGSVGElement root =
                                           (org.w3c.dom.svg.SVGSVGElement)
                                             document.
                                             getDocumentElement(
                                               );
                                         java.lang.String lang =
                                           root.
                                           getContentScriptType(
                                             );
                                         long documentStartTime =
                                           java.lang.System.
                                           currentTimeMillis(
                                             );
                                         bridgeContext.
                                           getAnimationEngine(
                                             ).
                                           start(
                                             documentStartTime);
                                         dispatchSVGLoad(
                                           root,
                                           true,
                                           lang);
    }
    protected void dispatchSVGLoad(org.w3c.dom.Element elt,
                                   boolean checkCanRun,
                                   java.lang.String lang) {
        for (org.w3c.dom.Node n =
               elt.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                dispatchSVGLoad(
                  (org.w3c.dom.Element)
                    n,
                  checkCanRun,
                  lang);
            }
        }
        org.w3c.dom.events.DocumentEvent de =
          (org.w3c.dom.events.DocumentEvent)
            elt.
            getOwnerDocument(
              );
        org.apache.batik.dom.events.AbstractEvent ev =
          (org.apache.batik.dom.events.AbstractEvent)
            de.
            createEvent(
              "SVGEvents");
        java.lang.String type;
        if (bridgeContext.
              isSVG12(
                )) {
            type =
              "load";
        }
        else {
            type =
              "SVGLoad";
        }
        ev.
          initEventNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            type,
            false,
            false);
        org.apache.batik.dom.events.NodeEventTarget t =
          (org.apache.batik.dom.events.NodeEventTarget)
            elt;
        final java.lang.String s =
          elt.
          getAttributeNS(
            null,
            org.apache.batik.util.SVGConstants.
              SVG_ONLOAD_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            t.
              dispatchEvent(
                ev);
            return;
        }
        final org.apache.batik.script.Interpreter interp =
          getInterpreter(
            );
        if (interp ==
              null) {
            t.
              dispatchEvent(
                ev);
            return;
        }
        if (checkCanRun) {
            checkCompatibleScriptURL(
              lang,
              docPURL);
            checkCanRun =
              false;
        }
        org.apache.batik.bridge.DocumentLoader dl =
          bridgeContext.
          getDocumentLoader(
            );
        org.w3c.dom.svg.SVGDocument d =
          (org.w3c.dom.svg.SVGDocument)
            elt.
            getOwnerDocument(
              );
        int line =
          dl.
          getLineNumber(
            elt);
        final java.lang.String desc =
          org.apache.batik.bridge.Messages.
          formatMessage(
            EVENT_SCRIPT_DESCRIPTION,
            new java.lang.Object[] { d.
              getURL(
                ),
            org.apache.batik.util.SVGConstants.
              SVG_ONLOAD_ATTRIBUTE,
            new java.lang.Integer(
              line) });
        org.w3c.dom.events.EventListener l =
          new org.w3c.dom.events.EventListener(
          ) {
            public void handleEvent(org.w3c.dom.events.Event evt) {
                try {
                    java.lang.Object event;
                    if (evt instanceof org.apache.batik.script.ScriptEventWrapper) {
                        event =
                          ((org.apache.batik.script.ScriptEventWrapper)
                             evt).
                            getEventObject(
                              );
                    }
                    else {
                        event =
                          evt;
                    }
                    interp.
                      bindObject(
                        EVENT_NAME,
                        event);
                    interp.
                      bindObject(
                        ALTERNATE_EVENT_NAME,
                        event);
                    interp.
                      evaluate(
                        new java.io.StringReader(
                          s),
                        desc);
                }
                catch (java.io.IOException io) {
                    
                }
                catch (org.apache.batik.script.InterpreterException e) {
                    handleInterpreterException(
                      e);
                }
            }
        };
        t.
          addEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            type,
            l,
            false,
            null);
        t.
          dispatchEvent(
            ev);
        t.
          removeEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            type,
            l,
            false);
    }
    protected void dispatchSVGZoomEvent() {
        if (bridgeContext.
              isSVG12(
                )) {
            dispatchSVGDocEvent(
              "zoom");
        }
        else {
            dispatchSVGDocEvent(
              "SVGZoom");
        }
    }
    protected void dispatchSVGScrollEvent() {
        if (bridgeContext.
              isSVG12(
                )) {
            dispatchSVGDocEvent(
              "scroll");
        }
        else {
            dispatchSVGDocEvent(
              "SVGScroll");
        }
    }
    protected void dispatchSVGResizeEvent() {
        if (bridgeContext.
              isSVG12(
                )) {
            dispatchSVGDocEvent(
              "resize");
        }
        else {
            dispatchSVGDocEvent(
              "SVGResize");
        }
    }
    protected void dispatchSVGDocEvent(java.lang.String eventType) {
        org.w3c.dom.svg.SVGSVGElement root =
          (org.w3c.dom.svg.SVGSVGElement)
            document.
            getDocumentElement(
              );
        org.w3c.dom.events.EventTarget t =
          root;
        org.w3c.dom.events.DocumentEvent de =
          (org.w3c.dom.events.DocumentEvent)
            document;
        org.apache.batik.dom.events.AbstractEvent ev =
          (org.apache.batik.dom.events.AbstractEvent)
            de.
            createEvent(
              "SVGEvents");
        ev.
          initEventNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            eventType,
            false,
            false);
        t.
          dispatchEvent(
            ev);
    }
    protected void handleInterpreterException(org.apache.batik.script.InterpreterException ie) {
        if (userAgent !=
              null) {
            java.lang.Exception ex =
              ie.
              getException(
                );
            userAgent.
              displayError(
                ex ==
                  null
                  ? ie
                  : ex);
        }
    }
    protected void handleSecurityException(java.lang.SecurityException se) {
        if (userAgent !=
              null) {
            userAgent.
              displayError(
                se);
        }
    }
    protected class Window implements org.apache.batik.script.Window {
        protected org.apache.batik.script.Interpreter
          interpreter;
        protected java.lang.String language;
        public Window(org.apache.batik.script.Interpreter interp,
                      java.lang.String lang) {
            super(
              );
            interpreter =
              interp;
            language =
              lang;
        }
        public java.lang.Object setInterval(final java.lang.String script,
                                            long interval) {
            return null;
        }
        public java.lang.Object setInterval(final java.lang.Runnable r,
                                            long interval) {
            return null;
        }
        public void clearInterval(java.lang.Object interval) {
            
        }
        public java.lang.Object setTimeout(final java.lang.String script,
                                           long timeout) {
            return null;
        }
        public java.lang.Object setTimeout(final java.lang.Runnable r,
                                           long timeout) {
            return null;
        }
        public void clearTimeout(java.lang.Object timeout) {
            
        }
        public org.w3c.dom.Node parseXML(java.lang.String text,
                                         org.w3c.dom.Document doc) {
            return null;
        }
        public void getURL(java.lang.String uri,
                           org.apache.batik.script.Window.URLResponseHandler h) {
            getURL(
              uri,
              h,
              "UTF8");
        }
        public void getURL(java.lang.String uri,
                           org.apache.batik.script.Window.URLResponseHandler h,
                           java.lang.String enc) {
            
        }
        public void postURL(java.lang.String uri,
                            java.lang.String content,
                            org.apache.batik.script.Window.URLResponseHandler h) {
            postURL(
              uri,
              content,
              h,
              "text/plain",
              null);
        }
        public void postURL(java.lang.String uri,
                            java.lang.String content,
                            org.apache.batik.script.Window.URLResponseHandler h,
                            java.lang.String mimeType) {
            postURL(
              uri,
              content,
              h,
              mimeType,
              null);
        }
        public void postURL(java.lang.String uri,
                            java.lang.String content,
                            org.apache.batik.script.Window.URLResponseHandler h,
                            java.lang.String mimeType,
                            java.lang.String fEnc) {
            
        }
        public void alert(java.lang.String message) {
            
        }
        public boolean confirm(java.lang.String message) {
            return false;
        }
        public java.lang.String prompt(java.lang.String message) {
            return null;
        }
        public java.lang.String prompt(java.lang.String message,
                                       java.lang.String defVal) {
            return null;
        }
        public org.apache.batik.bridge.BridgeContext getBridgeContext() {
            return bridgeContext;
        }
        public org.apache.batik.script.Interpreter getInterpreter() {
            return interpreter;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "fPr+fwGHaw/PdysAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "IC8cGea522OYO/YhY8Fvf1g8FaL/8wKg");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("38yT/3Ee0K/dKlABqPS9R0BffGuA7tDmogel84EeFC7zrbh0d+BHN0H657eK" +
           "9F1Ap796hLR8e5DeWQjceQbpSb8e3H8B3PxOz8Hd58E9uOdW4b4bwESP4FZu" +
           "D9zLu1s+N4O7x/zEBZifzJO3n4v50VvF/BLA+uoR5ldvD+ZTs9gO39UL8L2Y" +
           "J8/EpcsKoLAz09fBs7eAruDmpwEq4ggd8Rahgy9Al3fyQRn0nup7hhW6N4sz" +
           "7577PpjBvT3s99xqCJbP2tQRbOotgv39F8DG8+Sv5VcpQ98Nil6t7uG9cjvg" +
           "DY7gDW4PvLOR9A4jfQFGNk+652Hs3QLGp/JMQLt3TI8wTm8PxtPaTy54N8sT" +
           "EURRYPpsFTezj365cRybvOvcC9w3SBfGkG7BGN+TZ+Ykde3IGNduvzH0C97l" +
           "95UO3heXHlwcrYlP3ejbI1S+G4QpcJpdFHdsUPi7vREfhaUnbvgRzu6HI+pn" +
           "3rhyz+NvjP5DcRn85Mcd9zKle4y145y+QHnqGXixbliFpe7dXacMCvhBXHr8" +
           "HOUAit1DjuLA38lHR8H3aXlA7sXnabkNWJrt5UBVu4fTIllcugOI5I/boqtf" +
           "S3f7cU+c9pQi0HnkO5n/pMjpe+H5Blvxg6fjzbD17idP19TPvkFxP/L1+id3" +
           "99JVR9lu81ruYUp3767IF5XmG2rPnVvbcV13kS9968FfuPddxzt/D+4U3nvt" +
           "Kd2eufkl8A7gl+La9vafP/5L3/ezb3ypuKL4fwH/jIhtiTYAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1bC3AcxZnuXdmSLFsPy7Zs/JAtWYbyI7uQBBwQmMjy2has" +
       "5Y0klEQY5NnZljRodmaY6ZXW5pwAKYKTShyOmNcFXOHKhEcMToUDkoBTpnKX" +
       "hCO5Kx6HQ3gkIaSABApcriQk3IX7/+6ZndnZnRGbY89V05rt6b+7v6///vvv" +
       "v9tH3iKzLZO0U43F2B6DWrGExlKSadFMrypZ1hDkjcq31EinLn+9/9woqR0h" +
       "TROStUOWLLpVoWrGGiErFM1ikiZTq5/SDEqkTGpRc0piiq6NkEWK1Zc1VEVW" +
       "2A49Q7HAsGQmyXyJMVNJ5xjtsytgZEUSehLnPYn3+D93J8k8WTf2uMWXeIr3" +
       "er5gyazblsVIS/IKaUqK55iixpOKxbrzJllv6OqecVVnMZpnsSvUs20KLkqe" +
       "XUJB53ea//TeDRMtnIIFkqbpjMOzBqilq1M0kyTNbm5CpVnrSvI5UpMkcz2F" +
       "GelKOo3GodE4NOqgdUtB7xuplsv26hwOc2qqNWTsECMdxZUYkill7WpSvM9Q" +
       "Qz2zsXNhQLuqgFagLIF40/r4wVsub/luDWkeIc2KNojdkaETDBoZAUJpNk1N" +
       "qyeToZkRMl+DwR6kpiKpyl57pFstZVyTWA6G36EFM3MGNXmbLlcwjoDNzMlM" +
       "NwvwxrhC2b9mj6nSOGBtc7EKhFsxHwA2KNAxc0wCvbNFZk0qWoaRlX6JAsau" +
       "i6EAiNZlKZvQC03N0iTIIK1CRVRJG48Pgupp41B0tg4KaDKyNLBS5NqQ5Elp" +
       "nI6iRvrKpcQnKDWHE4EijCzyF+M1wSgt9Y2SZ3ze6j//wFXadi1KItDnDJVV" +
       "7P9cEGr3CQ3QMWpSmAdCcN665M1S27H9UUKg8CJfYVHmkX84+ckN7cd/Ksos" +
       "K1NmZ/oKKrNR+XC66anlvWvPrcFu1Bu6peDgFyHnsyxlf+nOG2Bh2go14seY" +
       "8/H4wI8/e/V99A9R0tBHamVdzWVBj+bLetZQVGpuoxo1JUYzfWQO1TK9/Hsf" +
       "qYP3pKJRkbtzbMyirI/MUnlWrc5/A0VjUAVS1ADvijamO++GxCb4e94ghNTB" +
       "Q+bBs5mIf/wvI3J8Qs/SuCRLmqLp8ZSpI34rDhYnDdxOxNOg9ZNxS8+ZoIJx" +
       "3RyPS6AHE9T+kDaVzDiNbwZLOSibisFAoRLalGLqWhbNLSqb8f/TTB7RLpiO" +
       "RGAglvvNgAozaLuuZqg5Kh/MbU6cfGD0SaFiOC1snhg5E1qOiZZjvOWYaDkW" +
       "1DKJRHiDC7EHYtRhzCZh9oP5nbd28LKLdu/vrAF1M6ZnAeFYtLNoGep1TYRj" +
       "10flo62NeztePutHUTIrSVolmeUkFVeVHnMc7JU8aU/peWnolbtOrPKsE7jA" +
       "mbpMM2CmgtYLu5Z6fYqamM/IQk8NziqG8zUevIaU7T85fuv0NcOfPzNKosVL" +
       "AzY5G6waiqfQoBcMd5ffJJSrt/n61/909OZ9umscitYaZ4kskUQMnX6V8NMz" +
       "Kq9bJT00emxfF6d9DhhvJsFkA7vY7m+jyPZ0O3YcsdQD4DHdzEoqfnI4bmAT" +
       "pj7t5nBdnc/fF4JazMXJuBqev9mzk//Fr20GpouFbqOe+VDwdeKCQeOOX/zH" +
       "Gx/jdDtLSrPHFxikrNtjxrCyVm6w5rtqO2RSCuVeujX19Zveuv5SrrNQYnW5" +
       "Brsw7QXzBUMINF/30yuf/9XLh5+NunrOYB3PpcEdyhdAYj5pCAEJrZ3u9gfM" +
       "oAo2ArWm6xIN9FMZU6S0SnFi/XfzmrMeevNAi9ADFXIcNdowcwVu/mmbydVP" +
       "Xv7ndl5NRMZl2OXMLSZs+wK35h7TlPZgP/LXPL3itp9Id8AqAZbZUvZSbmwj" +
       "9lzHTi1hZE2gUeF/bN+DD/HZXOZMnn4c6eE1Ef7tXEzWWN6pUjwbPc7VqHzD" +
       "s+80Dr/zw5McW7F35tWMHZLRLZQRk9PzUP1ivynbLlkTUO7jx/t3tajH34Ma" +
       "R6BGGQy1tdMEi5ov0iO79Oy6Xz7+o7bdT9WQ6FbSoOpSZqvEpySZA3OBWhNg" +
       "jPPGhZ8UqjBdD0kLh0pKwJdk4HCsLD/QiazB+NDs/d7ifzn/7kMvc500RB3L" +
       "uPxcXB+KbDD38V0zcN8zG//r7n+8eVp4CWuDbZ9Pbslfd6rpa195t4RybvXK" +
       "eDA++ZH4kduX9m76A5d3zQ9Kd+VL1zQw4a7sR+/L/jHaWftvUVI3Qlpk26ce" +
       "ltQcTuoR8CMtx9EGv7voe7FPKByg7oJ5Xe43fZ5m/YbPXUvhHUvje6PP1i3B" +
       "IdwOT9I2Axf7bV0ErEd34FLv9D2maOgKxSxeKJah4sU2bxfz9s7g6TpMPsLH" +
       "vgZfY2CcLO72M+i/okmqz0gtdnpVpneMnNbXn+zrT4wO9g70pYZGtyTES9/O" +
       "fmfCt3DdRDpjwsUW1hvT8zBJivYuCNT+RDFb2+D5tN2f4XJsnTczW3QKf5Yn" +
       "6zNhZGGSwuRTZVgaDugVOMqJ4UT/UBmS8PuQj5DPfnBClmHuRnies5t+rhwh" +
       "szlc/C0FYGNkjmHqDHSdZgIhLg1ph5EGAbG/Z0eiHKh0haAuhOeE3diJcqBq" +
       "6BSHNBkyXGOhWIKqB8+vJzmUGOjvGUqMhqNSK0TVAc9LdrMvlkPVJhkYNuGW" +
       "Mk7lrCRUEwuwvxvoiwEtQnM9qVSyr7cHVXE00bujRyhmOai5Dw61CXPXwfOK" +
       "3fArJVAJf9lXHlKEQ/IBaQypj5HGtNd7wMxzfP3/XIX974TnNbu91wL6f53o" +
       "PyZXl/Y2SBomW86iZs84teM8YCQ7gryiS5ySPjhfrBDOKnjetDv0ZgCcA6Fw" +
       "gqQZqc/oci7rQbMQ0Ux/TI5l9Gxsi/3RB+BrfweAk3YXTgYAuCUUQJA0I3UA" +
       "IHXJQNLp/8qS0RARDB4+g3I+KLdWCGUDPKfszpwKgPLNUChB0qBauNDmpHFw" +
       "R02ywnXscAM7mEtbbECa5gGmUXnXGS1tXeee6hSeXXuZsp5I1IFHfzAyckaL" +
       "LAp3lqu4OAJ1z9318gvZH78qBE4rIyDKLbon/tXhE1f8jG/X6nEPP+T4Sp4d" +
       "Ouz1PXvFlgIjGMQhzYREqSBE/GVk1/8xxAJi2ThTsuBAxIeULM1geNcTwqlq" +
       "/XzfUeSTu4P27Um15+1PfOsCQWtHgDvulv/+p3791B17jx4Rm0Okl5H1QQHp" +
       "0ig4xgrWhMQ7XAX547bzjr/x2+HLovYGrQmT+/LOlGp0dyjggmPmdws7mUgh" +
       "GrSwWE1EzVu+1PzYDa01W6NkVh+pz2nKlTnalyl2sOusXNqjN27clWd4leZ9" +
       "+BeB52/4oLJghlCa1l47BrmqEISEzRJ+ZySyDl598/7OCuf96fC8a8/cdwPm" +
       "/WOh8z5ImpG5PDRumBRSh/PVJWbM9nj73LI+SMdCIOXdrq0vdI3/qyW+UKqn" +
       "a569JkHFXhEU7eaR+sPXHjyU2XnXWUK9W4sjyAktl73/uf/5WezWXz9RJlw5" +
       "h+nGR1TwdVVPm63FZhDm0g5+EOBuFl9quvG33+8a31xJeBHz2mcIIOLvlQBi" +
       "XfD08XflJ9f+funQpondFUQKV/ro9Fd5744jT2w7Xb4xyk89xC625LSkWKi7" +
       "eGo1gJ7kTK14Mq0uKAA6mGQ9PLtsBdjl12xXxUo8vSi+ik2Vz92bH1KjLywU" +
       "daviTt/XeYsnQoJHz2PyFCPzFWvLHoCqyI6TYpVf21ImmGqmTNkW6aOp3fL+" +
       "rtSrjq27B5NHULtD4iO+OuL7Wn81efvr99urb0k8tqgw3X/wy+/HDhwUWi/O" +
       "vFaXHDt5ZcS5lzB8hd51hLXCJba+dnTfo/fsu95B9gQ4R2ldV6mk+c01/nw4" +
       "75qOp2eyhuFRLMzoNXj+z4uVC3cS+2xV2PehKVdQjSHK5djVBV731l64eUfe" +
       "DtG5U5i8wUhLQedsScx/0aXx99Wk8Tob9HUfGo1BNfqYqHH3qu+4XN5VvD62" +
       "wnOvXd+9Tn3f5vUdEU3fD0kkUnAqmrzBWR72jtSUV1MO8P3g4YnUYeZfZh6e" +
       "v1ZheHBkyDnQ13pRp/gbMDzFy69zjBAoGqzOj2MyxMG3hhCzEJNGRubJJgWP" +
       "6NNgJPRpZwDagzwMTzGkLdJUTdpabOwtldMWJBpCSEfIt9WYLPeRhXltLhUr" +
       "qkAFRh/JGsCx2MazuHIqgkRD4MZCvp2JyVqYo+OU+fzNx10y1lWTjFU2olWV" +
       "kxEk6gPssTFiJnWHMHIBJufMxMjGKjDCT1S3Qkc32rA2Vs5IkOgHMjDbQ2i5" +
       "CJNeRhYpGvgieLWIemL2XOQlTB4RaH/DyKwpXcm4jG2pFmMrAO4mG/amyhkL" +
       "Eg3h4jMh30YwGYSdHh4fiuMNLBdJukwMVYEJvjJfCEO6VNQZPW0GJkq3rUKk" +
       "jGiw7vDo8+0cNw3hBM+SIrsZWQILkDzJz+CZklbt0x8RqfMSJFVLVWBrH+2w" +
       "UXZUrCqBoiHQzZBv3BPKMrIwo1jAiDwxOLwtCVqTsM+BvJRo1dKZOOCJ2bg2" +
       "VK4zGwJEZ3AsX3SNzudDGLoGk72MNPsY8pFzVbXIWQvIvmAj/ELl5ASJhiD+" +
       "Ssi3A5hcX6wvI7qeLacv+6tFyXrAc8DGdaBySoJEQ2DfFvLtG5gcZKTNQwlY" +
       "FV1Vy5FyUzVJuc1GdlvlpASJhgD/Vsg3jHNE7iwmZYDiTZ9ypPxztUj5BCC6" +
       "00Z2Z+WkBInO5Ns9GMLMQ5g8wMgCDzNbdLkcLUerRQs4eNEHbWwPVk5LkGh5" +
       "Wvhv2AFu+AAx5kRepvx6BafqeAiN/4rJo4wsnZC0jErL1eFj87FqsQn1RY/Z" +
       "lByrnM0g0XA2l3nuylA5ZypsTzF5/xlC3jOY/DsjiwV5JRX4mHvyw2AuD75X" +
       "0HUbvJi2pOR/IIhb8/IDh5rrFx+65ASPuhduts9LkvqxnKp6r0553mtBF8YU" +
       "zv48cZGKn8lEXgDQAQfojNSKF+4r/1KUf5mRFn95Rmbzv95ysNdocMtBVeLF" +
       "W+RVRmqgCL7+znCG0XPlSdwgy4sRXuZlk4eTFs00CJ6Tk9VFsWX+P0CcOHUu" +
       "ZR/3HT10Uf9VJ8+5S1x+lVVp716sZW6S1Il7uLzSmpKjQ29tTl2129e+1/Sd" +
       "OWucWPB80WFX95e5ykd6QYsNHPGlvpuhVlfhgujzh8//4c/31z4dJZFLSUQC" +
       "a3lp6V27vJEzyYpLk6UngcOSya+sdq/9pz2bNoy9/QK/zUjEyeHy4PKj8rN3" +
       "X/bMjUsOt0fJ3D4yW9EyNM8vAW7Zow1QecocIY2KlchDF6EW2IIWHTM2oXJK" +
       "eHGN82LT2VjIxavTjHSWRuNLL5w3qPo0NTfrOY3fsmpM4mbOyREj4zt7yRmG" +
       "T8DNsYcSU1x+YIOMowH6OJrcYRjOseasaww+Vx8ut7A9zHX4Xf6Kb3/5Xzya" +
       "230dNgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18CbDsWHlevzv7/mYYZoYBhhlmBpvp8VV3q9XdYgggtXrX" +
       "0t1qqdUK+KHW0lJrba3dsidmKTa7MqbswYYKUKYKKsaFgYS4nJSDa6gs4LIr" +
       "KRwXxHFsCEkFL1BhyrFNmcTkSN333fvuu/e+9zyP3Cqdls76f9/5z3/+c3R0" +
       "P/Pdwk2BXyh6rrVZWG64r67D/aWF7IcbTw32+yQylPxAVZqWFAQTEHdBfu3n" +
       "7/nrH3xQP79XuFksvExyHDeUQsN1grEauFasKmThnsPYlqXaQVg4Ty6lWIKi" +
       "0LAg0gjCZ8jCHUeKhoUnyAMRICACBESAchEg7DAXKHSX6kR2MyshOWGwKvyj" +
       "wjmycLMnZ+KFhccurcSTfMneVTPMEYAabs2eeQAqL7z2C49exL7FfBngDxWh" +
       "53/5J8//8xsK94iFewyHzcSRgRAhaEQs3Gmr9lz1A0xRVEUs3OuoqsKqviFZ" +
       "RprLLRbuC4yFI4WRr14kKYuMPNXP2zxk7k45w+ZHcuj6F+FphmopB083aZa0" +
       "AFgfOMS6RdjO4gHA2w0gmK9JsnpQ5EbTcJSw8JrjJS5ifGIAMoCit9hqqLsX" +
       "m7rRkUBE4b5t31mSs4DY0DecBch6kxuBVsLCw6dWmnHtSbIpLdQLYeGh4/mG" +
       "2ySQ67aciKxIWHj58Wx5TaCXHj7WS0f657v0G5/7Kafr7OUyK6psZfLfCgo9" +
       "cqzQWNVUX3VkdVvwzqfIX5Ie+OL79woFkPnlxzJv8/zmT7/4lqcfeeEr2zyv" +
       "PCEPM1+qcnhB/uT87q++qvl69IZMjFs9NzCyzr8Eea7+w13KM2sPjLwHLtaY" +
       "Je4fJL4w/vezd/ya+hd7hdt7hZtl14psoEf3yq7tGZbqd1RH9aVQVXqF21RH" +
       "aebpvcIt4J40HHUby2haoIa9wo1WHnWzmz8DijRQRUbRLeDecDT34N6TQj2/" +
       "X3uFQuEWcBXuBBde2P7lv2FBhnTXViFJlhzDcaGh72b4A0h1wjngVofmQOtN" +
       "KHAjH6gg5PoLSAJ6oKu7hLlvKAsVwqVAZWXf8EKgUC0nNnzXsUEd+5myef9/" +
       "mllnaM8n586BjnjVcTNggRHUdS1F9S/Iz0d468XPXvjdvYvDYsdTWCiBlve3" +
       "Le/nLe9vW94/reXCuXN5g/dnEmx7HfSZCUY/sIt3vp59W//t73/tDUDdvORG" +
       "QHiWFTrdPDcP7UUvt4oyUNrCCx9O3sn/TGmvsHepnc2kBlG3Z8WHmXW8aAWf" +
       "OD6+Tqr3nvf96V9/7peedQ9H2iWGe2cALi+ZDeDXHufXd2VVASbxsPqnHpV+" +
       "48IXn31ir3AjsArAEoYS0FxgZB453sYlA/mZA6OYYbkJANZc35asLOnAkt0e" +
       "6r6bHMbkHX93fn8v4PiOTLMfB9ff7VQ9/81SX+Zl4f1bRck67RiK3Oj+A9b7" +
       "2H/+D38G53Qf2Od7jsx4rBo+c8QmZJXdk4/+ew91YOKrKsj3xx8e/uKHvvu+" +
       "f5grAMjx+EkNPpGFTWALQBcCmt/zldUffuNPPvkHe4dKE4JJMZpbhry+CDKL" +
       "L9x+BkjQ2usO5QE2xQIDLtOaJzjHdhVDM6S5pWZa+n/uebL8G9957vxWDywQ" +
       "c6BGT1+5gsP4V+CFd/zuT/7NI3k15+RsTjvk7DDb1lC+7LBmzPelTSbH+p2/" +
       "/+qPfFn6GDC5wMwFRqrmluvcbuBkQr08LDx56gjNf3YTed7FUF7mqTzcz+jJ" +
       "ayrkaXAWvCY4OlQuHY1HPJUL8gf/4Ht38d/77RdzbJe6Okc1g5K8Z7bKmAWP" +
       "rkH1Dx63C10p0EG+6gv0W89bL/wA1CiCGmVg9QLGB+ZpfYke7XLfdMt/+dK/" +
       "eeDtX72hsNcu3G65ktKW8iFZuA2MBTXQgWVbe29+y1YVkltBcD6HWrgM/FaF" +
       "Hsqf7gYCvv50a9TOPJXDAf3Q3zLW/F3f+v5lJOR26IQJ+lh5EfrMRx9uvukv" +
       "8vKHBiEr/cj6cpMNvLrDspVfs/9q77U3/7u9wi1i4by8cxl5yYqyYSYCNyk4" +
       "8COBW3lJ+qUuz3Z+f+aiwXvVcWN0pNnjpuhwqgD3We7s/vZj1uehjOUuuMjd" +
       "wBwctz7nwHh+5tSZ7ED2fcPJZvr9IM+0r6jbm53BwfL2HsvDJ7Lgx/IOvSG7" +
       "/XFgLoLcqw2B/IYjWTuz8UPwdw5cf5ddmVRZxNYNuK+580UeveiMeGA6fEWP" +
       "Jnt06wLbHPeGkwtEa3vTY+iD4Xg+19WM2v2tN7m1rVlYzQJ823b9VN1846XM" +
       "dcA13THHn8TcG67MnBpnjycTx5xFXBa0s6CTd2oXuHstvkVPTsCfpQ+OYR1e" +
       "PdZXZrF1cH1th/VrJ2G9KUeSPU9PETss3Ob5bghUWlUul/72rfQ0RrVOkle4" +
       "RnnfDK6v7+T9+kny3qDGubRvP4Pkt14u5v0YOWmNaWzSunC2wNI1CvwYuP54" +
       "J/B/PUngByTPA9NqbsYgVbalra5kGfRrw/AANhySvSaW6caFVpPCtppyEgrj" +
       "6lHcncU+Ba5v7VB86zIUhfzGO1nac7m0BzLeNT86RWaRpWOira5RtNeC69s7" +
       "0b59imjJ1Yh2WxSoPrZQd9sAwLA8dto8zx3kPCb7+hplfxRc39nJ/p1TZH/H" +
       "1ch+q+LKkX1E9Psz0RNY3ldce5/YJR6T9p1/D2lf3En74inSfuBqpL0FSDvk" +
       "xuSBsK+5jOft0jXfNwH5jsn9s9co99Pg+sud3H95ity/cFUaks0xkbQAfpJf" +
       "eOwUp2UsJflWwgX5X42++dWPpZ/7zNapnYM5IywUT9uVunxjLFvjPHnGOu1w" +
       "v+KvOm944c/+O/+2vZ1jecel+O89C/9BH9x16PABbyaL/Ogx2n/xGml/Hbi+" +
       "v2v2+6fQ/itXQ/sd+f6T56sgPBD38ctUZjfX9g7zHpP/E1eUP29vO+tV9uv7" +
       "uWX69LVN1g8uLfmJA0eGB/ICq/7E0qqfZIS7Vy0QULe7D50c0nUWz/zc//jg" +
       "7/38498AutUv3BRnTiZQlyOeEB1le4jv/cyHXn3H89/8uXwhB3jlP/DP4O9n" +
       "tX7+2mA9nMFi850RUgpCKl97qUqG7Gz/fegbNliixrsNMujZ+75hfvRPf327" +
       "+XXcWT+WWX3/8z/7w/3nnt87suX4+GW7fkfLbLcdc6Hv2jF8dKCe0Epeov3t" +
       "zz37W7/67Pu2Ut136QZay4nsX//a//29/Q9/83dO2K250XIvczivvmPDlz/a" +
       "rQY97OCPLM+bMCavRScSFJsl28FwUxeBdcDC6Wy+6dWjEY4nI5tabiq6FCCz" +
       "kmm1RjOEdkRrOXYVW5rVRGGKeAk2mA0mrL5hbFpuC0x3oLdkauJyhOniE88Z" +
       "CHqTQQbrWncEL8yexGI45oERNDLhnlCHijXRURzRGXfmswbKlxA/rM2L9bgG" +
       "QVAM/tCwCxuDlBSZEleF2xW8Rkz9TmttDViwLqT8jSeWdcJcyiu43DIc0imi" +
       "EJq4q3FJn4wZNuSYKUl6vAsKdYyW36bKhmmIkxUCsURrZU463lgueYaxqtFm" +
       "azooi3KZb/HTClZFR/UuFnRG9kbY9Cme7iPrZRhswoXY4lhVJ53hzIGLBAr3" +
       "G2ZjOtEqETUV1J4Pqz6y2Ejp3Ar4Hgv1BhK3GiCIYaw9ZrCe+2nfsuIas1Jl" +
       "nnco0XMCNuaCSmlAmitV4Po4AqsSBE1UYkyFTq/XNldzb0kxKb4yrFWZKpmb" +
       "CT23kabHOz4b9xDOo0w5rbQ7qjVgXLjjKq0qzawWChfi9XXkWUFcqekJI1dW" +
       "K3o6CYDDpqxFbmYallWfemxMoaNRWkkDgdZHZLRatKUF2WtXS5BfTfggmkNW" +
       "RExNtSdXBrS7VEypNSFwV8S4vkebZXq1USeuaI4pq0gk45rpGQNvYyF1rx2E" +
       "Ir+ZTLFaB6612hRMdWjBnpOWnCxdgk4pi6KTOFn7erMyR+1lzWGZDh7K9dZA" +
       "bwfrboKBBrG1XEqa8Zxui2ZpNXWlsSXU+lggRUathRm0aA3EeNQswXTJmPR6" +
       "g3JzzI/7nWpjuIg8r1rGS+GiOpCIwYYmcRahVyOkZXlOr2aMY3/gySNnQEy7" +
       "rWrLWDbTTbtIlRN2EaKzCivCqVpbQlDSFiTFKA96IeEQfZ6vD1G51fHh5gge" +
       "UYA/G1OaMl2rIVSZrdS7KMcNFo1mX5vxXdsUGtWibNJ1WYEGgRsMyrQtQu5g" +
       "4NPjotCs1STHiqfx0JfbURmPap5KLNqbrhNs1pZWdJhOBdcrC7dcDdRZA+pW" +
       "k14DUiEeRTF0XArxrmTzSjrl8WVxTqqhOOI7XuSu3XKfm6XadMSUJwMU6gba" +
       "ajaEvUF/bM7DdE5tDL8HUZxjTX0ZgbASv+Qwni1jRGwsJZspFjvr5ryqotWF" +
       "Tk/wUXGOB4jd06Ak7gFtHwUQGzXHpL0ivYbIej246hP6zCGUNbOmmQUq0mu2" +
       "URTdXn8NjzdDtoZ1W+ikaBISnxIGPU9EkmGNuRG0MXdMSlaHXE31OU2yq3lD" +
       "gyYTvD4mPYMZd7CFFcf0AnNTiYwicbVABjpEzbmarHWIEiu1DaZZDhx9gbTK" +
       "K8YQxWXMTGcSYU7LBADbNYhmvdWdhWM9bYo66g4RZ65UGuSAVCIo9rF2mQLm" +
       "B1Pbs5Ck3Y7qlSez8bJc0iy3VqHVNFSHUdjlJj2f5V3LVjmzzat816Hkep9r" +
       "SBzkqVPHteYh4w8HQau+xOy5R1GVpr0IZ2SEiDVttpJsCuqNzAadGqtOI+XU" +
       "uCdx9UkD0aK4RMuMNkzpgRvwJJbOkE4tkYyVNnJxmVIQTev3WT+EnFoZQkso" +
       "I6KRHchGOJPEqhmY3IhyhBrfoKl0sELn/UmppNprrV1TUELX437QNrF6PKvb" +
       "xeVmKJYYeCYHyoioEl0lbbkrzelV5zY28Zb1EHFwxZEhrV3tSykl9CN8pcao" +
       "nZoQ1PYrpY7nRu35ilGLPJEo6qA5UhlGgNJuZw0tFSIkWX/Yba8N06fD5dpv" +
       "bni7lgBTvmIqY7YZ8Wq0FMqoGKtRjLC+T49mzhTB/SCpj4QU56ge3Ybg0ibS" +
       "IFQgdaRIR47PzHB46MktZaMr2GyJeE2s1fdFOEIXGuVibgXzp3Zt3aPRNiVy" +
       "NbbEOm0DErTU9ilVjWnMQDGiLfRkWnETOeEjyLbnG4UfCnHdUSyEHlOiVWEE" +
       "imTFoJgMYESvT6yhuBhCpDAkYSP00J7SwFaYOBe5WGTndrJErbQ7Mcq62Kos" +
       "OLUNzekiQUBdUWBEynGqck1tlVtaPRRa6XRK1zxumcyHcp1fdVMiKDZKhA+l" +
       "CULJ03obRsIp1RXJMSmOxiY6TLlh2Yg3DrCP5oRj6ss1FMKhtOzCVUoa1/BO" +
       "Z7QphwrVMhA3LhlMHWU2NSGtF936XJmg01GtPWddxmPFVdzyNqyIwQw+1enF" +
       "cjjs6GKDWy1xhSiZpF7yBklfMavdZkAS0MiQUrxIEwGk1A0tdaC6ScUyUiqN" +
       "cZiMhmtZwIuDOUHADb6UynQj7UCQX3eKDZX3qs1pRMxFdDgPLE2p+Z5URpGw" +
       "Ot7MY2GgElixKHarphIJqF2vYYgCpyN0oBR5spyOkqpUD8ZFiISWXWmqhTHH" +
       "9+CR5ZmVmqxa4UieRO640aTCNdrqxPXYVevt4QDfLOpuHxHUKqyJiA3N5kOB" +
       "i/UuFy/V2hAwCOM9JWEmaK+CrbX6nC+1/JYCV9tkjBIVW2IWgzW7Vgd9Sa8G" +
       "XGW+1lI0qC9qE48aBmQ3XojarNKUSaZeoYoG5Jr2Ki0tQsXxeM9RKYeeC04x" +
       "9SfVhEEX9ZI3EzvhZtJiUYjRbK0ZwoQyJrxlEnDTsh5PGineN+JZ1KQnxTHR" +
       "nleKBBLSFa0q9ANnIqdTeDTQkJlTS2ld7HTYJBpPRH4hEdGCZ6hVv8pNIA63" +
       "2cYwGi0RYqg5eNOyu9HYMdQACYu+nuhBaslQs9SedWhzaXdXRJdVxEVPJxdl" +
       "T0daHWzegcSSagDPrKRLWKQzagtWjL68wlc1nO3SuLkROow+7Q1WeKMY91Ob" +
       "6zDLuMOtKH1Fs4PShMdklFR8KrbMId/XzRkddaaUWbf85phrJVESr2PXSFrh" +
       "yKHQFc9u/Lrc5YVWqTSPluONbjOSgRBJrdwUhkKiMQNYw/w+j/U11BK61qA1" +
       "gnq4NNp4S6TbCWmlnlDrVBvCkNAT0Hp1AmiP0HJC1jQEdocbUbAgMEHjrj1t" +
       "1AwxaFRDlWrMmqP6wt8YLLJhh0td83GCGThLNSTikrhoylitnSxWI3ElQ65s" +
       "1P3RnBqVuDU06SEW2lkHBgSP8SLua4mKmfBMmCxmWNTkuFEfK/VgDut1hf6I" +
       "Jj2osWJLY2xM4NXiAu4VwWwybXY4YjjQgtRLBoshSXNNHS+tcCmiCdvrtpNx" +
       "qbJJHCGQMaput8L5vNWUkEXH5gRH6LDlUFBVtaazqiBEYuAhvXKv3dVSbCOb" +
       "EkliHmytoiqD9cspCpcbi1js1hsrvFX1extiQM5dBwoFvVXWGssOJNSc1nBY" +
       "nFRZr6owUVoGBq9tLXrLDjXS09m4tWLxFtThzTLUWK+xvlGZ6JMgwrF1T+VI" +
       "qrxQaXmSrKwVJKQap7KTqDqs1Dm7jBTLQ40JmqNp2F0QcWTFUNGD62gZLwNj" +
       "VR3bJca0kG55NOp6JWNRXS/8qU6N6gImINX6PF360LpS7JJuPOv4I3sChj5j" +
       "dbySslkuFvbQVpKgbnMLveOzyRSY0ZSPQIvpjJBK5Slwz3m96KUVZ2BNHMna" +
       "WJWAiYDLulrSlbpsTZWqpYpoEVdxpAJVXbK/0K2mVLaqddy3V60e20rH/aK4" +
       "YTeEhaANqM40Iw2tac2G1IBkJRna0JTRGynSs70OMiTGkY2PWR0C+j6dU6iz" +
       "rMNkr8hSSrPHCIq/KsVKD4ZWm2mRG6wcCamhfbPbBr3A1VVpXAyGQne54Sqg" +
       "f6fcAJ1Wg+UGM0OrDkNglkOmajoVUnTctxJELzqdcXmSKDw/tGtwW9QJu7RA" +
       "ii0Gj9oWuoriDgwXGxJcXvdVvJtWbLnXY8jYGuGGoBGlhqBZfVQrapEz8lyw" +
       "yORGAx7yXbStIPVqdTmpJHVhXl1vzAa6btYqCMma04FRVztuedGvm5NBuUqt" +
       "StEAw2p2Z4QOyTDAlaVVrqyFNec2YtYoGmaFT9HKvFseLMlNwilSbExCSFBn" +
       "gTNy+0Co4abdHKbtaUx23eZq06tNZh6vVco92+6s7AltTmsS48EaWfRD1l+u" +
       "KnUcobscGRJVgykyEVmfOo2yqsU+ikb+vGQ2wtUigQUo2RShLqEn3NSAmLgt" +
       "CV0iRESZRawUb+gKUtZJodmfS0XFmWgupAURiuDoYlQdVyyFr9lmUS6VISep" +
       "1pEV41XUjR61xySVurSwLKbViG/CMlusrPnKUNUHvDJast0Boix5nK/DZatW" +
       "VTlNJcIOwiFGI+F0cqQqASuvoZIkrFF0ajYm7hztchqgE6eBp73qduFVVKwK" +
       "NMLHRK2SOEwsKEV04sAaEnNKi4NBr5km52Ar20/x6bheWYYsx5cppjGEF9WZ" +
       "w81UURP1mhqXRV3tAgNNOKMy7I09aDGniLS9qaHpEsfczipllhVqs6Y6sK43" +
       "01af7oyjeb+/mA5rNL3oD8eemBDSIk2oSdoxSaXPTRRPmjNJaCnUtI97Tbal" +
       "9UJ0OiOH6lgXrJDUOX9lYu2xDvU7QXNdoaQ06vZWC3NMVCmxGXuV/oZfzdwi" +
       "wxW1lF6XS5uyNZ0s21zFtaa8uW6ZtcUwCCZto+9Mu1S3h/cjjVpTy85gSTQn" +
       "ZRYemTJc8bEKHyA9k1l0qSUxH1UMpNmngRAzrxMvDJWc9lSbrAjMyJrg1bHU" +
       "hYjNIPEE2a4uOxWvbVM+xlTtDiTZG90kWwtYry4pHS7Nks6MVbp6VTMiCiz7" +
       "lH5kJhQ/a/XjZV9rtpgaT4/E4bTU6Zsr2OcG5rJjJPWYcBvFkkwnsI5TRbbn" +
       "B+J01CNNIu2nxaZoAke/tG6MVxrF9ts8yU9xv1usJJwgcn5zhbtGd5SKeAzj" +
       "wwHl9xK3vMQMIlkzZBI2+dUkoIp43B+7ZWUgMkyzX5kvKvygmnaSfkuEsUCA" +
       "WTqNFKJDuh0TuB/0MJg1vHbKz4XedBT3YhtbQi3SQjC2rxtEkQ0MGEN0WaiB" +
       "dVl9pZKSHBdrYXsj+JjcIDqKhG9Yt98aVQitHZNAgxeyOJjQo8Satfkyv0Ha" +
       "Gy7l+5Fc7ihWbHlZvQsC4oMFvOzSrbqR");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "AC4zI4n1QQAA");
}
