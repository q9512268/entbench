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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "wA34z/h/AVvAvvC2KQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "QOgPYthdhmGMWbXM3G4n2Xo47rCobxsutg0qobxEIw/J2rKBNNPlpmHU/Bpg" +
           "GpxRJind06qorRvIdJnW2vWZkbC4Yk3agqWni7WojjXaHZUTVRgpCqSkLX5F" +
           "b3tinaBTbgbhvXqjWt7GXBsyW6uaOo5trKFS1a41rA6QxDTUFbuIYT7ZxNx6" +
           "RXDDUVxvExI51YmQ8KatiuqtYBJN6m3RrdcGVkt3h2nk1JumNacbm2ZnGQRk" +
           "L13KSKY3F35jKywxSegO+8i8xTB9Rl8QXWIrpStOaImDANOl1XwGM3NmQUey" +
           "tuEl32/FDr9yYpJmiaw6W01Eioo31mCpUwlf2SBifTDyTZsxworU3HYojF/Q" +
           "qKU2cMCpQ5of0unMR4c1qByIAz9uVfsVUUg7rMs4cZMpI+gynJJYh7Tkqq7O" +
           "kpVaX6jk0rUVaJuo+gSaq0zaNNRK5jozcVSeBhsmcrcIBLlTpGbEZSaZTqRh" +
           "yLkJVNeXfI+hI4q0GomYJrVW1uPVNmtT1SxrZI2NPR7ocLDlCE7Q1Xba3qBs" +
           "M4GI5hAWe3FrPVB1qQlTJKIL7WSmG4kzJI1+PFZaUD/qJvNqPKM0nWcjO9g0" +
           "JM5XVFhR46rUauqLaKJ34Rkk1ZdtnqWhgR42sk0kKlybq05GdjBgNTlZLm28" +
           "swV0KnH0PKk6M4+jfXKitzQ4wHmrTml8uS05msNik/6UmvJKEjYhtYXJs1W1" +
           "PKqG1e42IELZpT2yXV1j2KJsNlsdo9fs9WCqg8FUUmmnkdLqCBKhLUyPiJsT" +
           "tiFOet1aC06aihs0jRBDCV3VtoKDbiCtTLgeWBW7TXUGGzaBTpe+OHG2NjrZ" +
           "hNseZ/R6jaU6cKtKWlGgtsCmm1a/KaUgSOpUG5o/rtprtNlvLFMVbswoIWuV" +
           "G2zQRMyUg8d4oo8bPucshxMPLAhGWV6HfHdL9OgmjiAYJsDOyiWJDu10xaQt" +
           "tVp+EoRYZyEzoxgrszCYg0ImKX01FvppBE9To9viO6ShsawYEd0swe0mRMb2" +
           "NJ0nFX04JcdMAM8J3m0PKlNsnUremC2jFSNwmnht1SnzkLlOWiy1UVjHFNoC" +
           "tZhUkSaLJrzaoKoNi3IyWEAGg2SkAo/rGabKRz1yINsCuV7F9HpL1oIyOcOR" +
           "FOJtxexlenVayzyqQ7eI0brGcmujz7XHbrD0GVUGHW0htLZYLCO9MxPqYAiB" +
           "Z9QnLDJFK6jb9jzWgrVOtw1ocVhupL3NqtNCezCbemgLZeuwzIl9dCDMeG9h" +
           "pOJkgLrr4XQ6DwiD6kDLUEhw2V2usgEBCX0C4kbuclKDpG7DEx0Qy3RbWiLp" +
           "nlitm2kr2tL9viZkOFEDy3CEyeIMWc5TT2ulni6vqotWanTmgCE9XoEnzeGa" +
           "g9tVR+gMtLXf0PEVePuZmoqiZJHPszZpeNBsJPpuK0IUJmbbGEstepygeGi/" +
           "QwzMICwH7DIrAx2p1XDFzsaKRcVaQxa8ubAhN1jb2WB1BSy+A3Y20UN6XSeE" +
           "qVxzY5JN2DZioIvaUgVrwSJrjaYzuj3ArHrb29j+lNmgA7YyW837vekGsrQW" +
           "zi7mFtLKZo7o8WZ/CC1nVay7wbdqA1G5TeLOKZtYD2KR4dUlMhBR3ma75KTe" +
           "SrvehtQN3aA2ZW0KvHrWCbUBXqmuGr16RfesuorxGWs5gxaDjytlsotKNR0V" +
           "rFbWiRjH9DJ7wYw5vN23fYk1SX3dbnSChYpknW2LsUypP+zqQ1duzkYRWasq" +
           "aBOGKz1XsROkGZGmXrMZNIlUom3WRqbmoUhCxb40BhFivJFbRlObKvZcElNx" +
           "rIXmMILx5VKe6+mEZ6auQ5bDCMcTBaukQdonQdyUbRt0TbPb846o25LZqMS9" +
           "SkCQG3E7qYIgvQLi2Ewbpbq3bJLmYlQOxlCtzZuAbcVyK6BxdlMO5tTKi1s+" +
           "rmKiX6OqfUPoVYFtqvNmn6RX6QAbKZsYpppaJkttHLw/1vlsLCRMZT12qxKT" +
           "jTp6QA8kXJGXk4rtZv2EN+drjUW4Whg48soIF+VUXdTXor7o1ecMIZCMr5pb" +
           "GkmNGePxiSNwwliAhugQWvh9gxmlYwSoAleBriIB25lf7fNDjRva66bPD7bL" +
           "UY2tVDyXGTfUGWap6GA2sb223aFntQU2QQcSprdFPSpzsJkKA6OswxW4bzQp" +
           "rheEk55iMtPVlPQWXllYCfi6NlxElF4j6tGCZious6VXALZIJjyCL6pi2Wo0" +
           "6YowGkLDeTA0W82EILYjQS9rg3INkSRe1lrlJs7LJsaRFqLoQ6mRUNA0pLSR" +
           "WJ/LttseQwJF19S0J5PoBBaJlJnaA0qG2c4GS3BYbgQieIXUN2yr4uMUgSDO" +
           "nBG34wk1H48H3GA7grFRw/Tn8IzTlcRCx00hqsSOkQrxOoGXPMIayQREf7bB" +
           "T8gUHyUOSHkFQcD4N/pzbSORvVnb7wxUp6HUUQ2SE96D7JkxSkhWznxLrwQD" +
           "CFr7RLs+3Sz81Xae0g3WCAUjRVCOSMy5ODWpirTmRZh2nHijlVMnjiN84Mzm" +
           "sSKosFBmWv1xxxlLhlWRGj2VLptjKKzTGwUNm/NNB6ltIRPq8EknSbowCLM6" +
           "+baL+73tfD1SbOgdH5//Jbby0nM3MI83RIt99IdOH8KePJHZ77AfHJ1QPH3W" +
           "acbudDHf/nrqrOP0Yuvrkx98/Q2N+VT1wuEBhhWV7jm85bDv7gpo5uWz9/jo" +
           "4irBflf9Nz74J09O32d+4Hs4cHzmlJKnm/wn9Kd/C39R/XsXSncd77HfdMnh" +
           "xkqv3Liz/kCgR3HgTm/YX3/q2PqP5cZ+Dlj9y4fW//KtD/3OHsp37zzm1OHQ" +
           "4enTsc/sjpA+dM4R0t/Jkw9GpbflJ/r5dnsi27c4kNqdOOw98G9+tz3Hk/0U" +
           "BT9+M/ivHoL/6h0Ff6T9lb32k9h18+O/vUk+do5JfiZPPnqjSfKi1/bw/+5t" +
           "wC8OfGGg6J8dwv+zOwP/YC/wWiHwj87B+Kk8eSMqPaTaen5WdGLgtRMMY0al" +
           "uxPP0vbI/+HtDvyzAPE3D5F/8630+l86B/4v58lnotIDYIinlqN7cXRqhD97" +
           "J3B+5xDnd+44zo/vcf7aOTjfzJN/fh7Of3G7nlwBi9nFXd3d51vgyf/mHIhf" +
           "zJNfj0oPFp58AuTP70F+/jZAPpoXvhOAe/gQ5MN33mmPKOvRfH3dIOo1zXOu" +
           "9Tw1zq/uFLV/7xwL/H6efCnKL8UFoS7S1DF/n2xu5Gn63iK/c7vD/sPAEo8f" +
           "WuTxt84i1fMjjquzCQVetHyw2uuE7Gq2HhRNf/Ucc/1JnvxnEHgs9AhUP+Uq" +
           "f3i7hnkRGOSFQ8M8d2cMc9c+ZCz47Y+KXCH6P84B+q08+e9nAf367QJlgUrf" +
           "fwj0xbcG6A5tLnpQOhvoQeEy345K9/pe");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("eAukf367SN8FdPqBQ6TlO4P07kLg7lNIj8f14MFz4Ob3cg7uPQvuwX23C/fd" +
           "AGb9EG71zsC9uLupcyu4e8xPnIP5yTx5+5mYH71dzC8BrO89xPzeO4P5xCq2" +
           "w3f1HHwv5skzUemiDCjs1PJ18OxtoCu4+WmAqnuIrvsWoaucgy4f5IMyGD3V" +
           "cw0rcG4VZ96reB5Ywd097PfcbgiWr9rkIWzyLYL9Q+fAzjcADv5qfh0y8By/" +
           "GFV4D++VOwFvfAhvfGfgnY6kdxiH52Ck8wQ7CyN+GxifygsB7d4lHmIU7wzG" +
           "k9oL5zyb58kERFFg+USL29WHv8w4ik3edeYl7JukC2Nwt2GM78sLc5K6fmiM" +
           "63feGPo5z/I7RwcfiEoPLw7fiU/cytsjlL8XhClwml0Ud2TQyvd6qz0MSk/c" +
           "9COb3Q9D1M++cem+x9+Y/fviQvfxjzfup0r3GbFtn7wEeSIPvFg3rMJS9++u" +
           "RPoFfD8qPX6GcgDFLpOjOPB28uFh8H1SHpB78XlSLgGvZns50NQuc1Iki0p3" +
           "AZE8uy2G+rV0tx/3xElPKQKdK9/N/MdVTt7tzjfYih80HW2GxbufNF1XP/cG" +
           "OfqxbzQ+tbtbrtrydpu3ch9Vund3zb1oNN9Qe+7M1o7auod46dsP/+L97zra" +
           "+Xt4p/Dea0/o9sytL3L3Ab8UV6+3/+zxX/7Bn3/jy8U1w/8L4h8OHGk2AAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "NAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2mJkauOmhc1FvrOY+a479LkR0RwhbNtH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Mvj/AWVsDW7RQQAA");
}
