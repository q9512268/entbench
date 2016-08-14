package org.apache.batik.bridge.svg12;
public class DefaultXBLManager implements org.apache.batik.dom.xbl.XBLManager, org.apache.batik.util.XBLConstants {
    protected boolean isProcessing;
    protected org.w3c.dom.Document document;
    protected org.apache.batik.bridge.BridgeContext ctx;
    protected org.apache.batik.util.DoublyIndexedTable definitionLists = new org.apache.batik.util.DoublyIndexedTable(
      );
    protected org.apache.batik.util.DoublyIndexedTable definitions =
      new org.apache.batik.util.DoublyIndexedTable(
      );
    protected java.util.Map contentManagers = new java.util.HashMap(
      );
    protected java.util.Map imports = new java.util.HashMap();
    protected org.apache.batik.bridge.svg12.DefaultXBLManager.DocInsertedListener
      docInsertedListener =
      new org.apache.batik.bridge.svg12.DefaultXBLManager.DocInsertedListener(
      );
    protected org.apache.batik.bridge.svg12.DefaultXBLManager.DocRemovedListener
      docRemovedListener =
      new org.apache.batik.bridge.svg12.DefaultXBLManager.DocRemovedListener(
      );
    protected org.apache.batik.bridge.svg12.DefaultXBLManager.DocSubtreeListener
      docSubtreeListener =
      new org.apache.batik.bridge.svg12.DefaultXBLManager.DocSubtreeListener(
      );
    protected org.apache.batik.bridge.svg12.DefaultXBLManager.ImportAttrListener
      importAttrListener =
      new org.apache.batik.bridge.svg12.DefaultXBLManager.ImportAttrListener(
      );
    protected org.apache.batik.bridge.svg12.DefaultXBLManager.RefAttrListener
      refAttrListener =
      new org.apache.batik.bridge.svg12.DefaultXBLManager.RefAttrListener(
      );
    protected javax.swing.event.EventListenerList bindingListenerList =
      new javax.swing.event.EventListenerList(
      );
    protected javax.swing.event.EventListenerList contentSelectionChangedListenerList =
      new javax.swing.event.EventListenerList(
      );
    public DefaultXBLManager(org.w3c.dom.Document doc,
                             org.apache.batik.bridge.BridgeContext ctx) {
        super(
          );
        document =
          doc;
        this.
          ctx =
          ctx;
        org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord ir =
          new org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord(
          null,
          null);
        imports.
          put(
            null,
            ir);
    }
    public void startProcessing() { if (isProcessing) {
                                        return;
                                    }
                                    org.w3c.dom.NodeList nl =
                                      document.
                                      getElementsByTagNameNS(
                                        XBL_NAMESPACE_URI,
                                        XBL_DEFINITION_TAG);
                                    org.apache.batik.dom.svg12.XBLOMDefinitionElement[] defs =
                                      new org.apache.batik.dom.svg12.XBLOMDefinitionElement[nl.
                                                                                              getLength(
                                                                                                )];
                                    for (int i =
                                           0;
                                         i <
                                           defs.
                                             length;
                                         i++) {
                                        defs[i] =
                                          (org.apache.batik.dom.svg12.XBLOMDefinitionElement)
                                            nl.
                                            item(
                                              i);
                                    }
                                    nl = document.
                                           getElementsByTagNameNS(
                                             XBL_NAMESPACE_URI,
                                             XBL_IMPORT_TAG);
                                    org.w3c.dom.Element[] imports =
                                      new org.w3c.dom.Element[nl.
                                                                getLength(
                                                                  )];
                                    for (int i =
                                           0;
                                         i <
                                           imports.
                                             length;
                                         i++) {
                                        imports[i] =
                                          (org.w3c.dom.Element)
                                            nl.
                                            item(
                                              i);
                                    }
                                    org.apache.batik.dom.AbstractDocument doc =
                                      (org.apache.batik.dom.AbstractDocument)
                                        document;
                                    org.apache.batik.dom.svg12.XBLEventSupport es =
                                      (org.apache.batik.dom.svg12.XBLEventSupport)
                                        doc.
                                        initializeEventSupport(
                                          );
                                    es.addImplementationEventListenerNS(
                                         org.apache.batik.util.XMLConstants.
                                           XML_EVENTS_NAMESPACE_URI,
                                         "DOMNodeRemoved",
                                         docRemovedListener,
                                         true);
                                    es.addImplementationEventListenerNS(
                                         org.apache.batik.util.XMLConstants.
                                           XML_EVENTS_NAMESPACE_URI,
                                         "DOMNodeInserted",
                                         docInsertedListener,
                                         true);
                                    es.addImplementationEventListenerNS(
                                         org.apache.batik.util.XMLConstants.
                                           XML_EVENTS_NAMESPACE_URI,
                                         "DOMSubtreeModified",
                                         docSubtreeListener,
                                         true);
                                    for (int i =
                                           0;
                                         i <
                                           defs.
                                             length;
                                         i++) {
                                        if (defs[i].
                                              getAttributeNS(
                                                null,
                                                XBL_REF_ATTRIBUTE).
                                              length(
                                                ) !=
                                              0) {
                                            addDefinitionRef(
                                              defs[i]);
                                        }
                                        else {
                                            java.lang.String ns =
                                              defs[i].
                                              getElementNamespaceURI(
                                                );
                                            java.lang.String ln =
                                              defs[i].
                                              getElementLocalName(
                                                );
                                            addDefinition(
                                              ns,
                                              ln,
                                              defs[i],
                                              null);
                                        }
                                    }
                                    for (int i =
                                           0;
                                         i <
                                           imports.
                                             length;
                                         i++) {
                                        addImport(
                                          imports[i]);
                                    }
                                    isProcessing =
                                      true;
                                    bind(
                                      document.
                                        getDocumentElement(
                                          ));
    }
    public void stopProcessing() { if (!isProcessing) {
                                       return;
                                   }
                                   isProcessing =
                                     false;
                                   org.apache.batik.dom.AbstractDocument doc =
                                     (org.apache.batik.dom.AbstractDocument)
                                       document;
                                   org.apache.batik.dom.svg12.XBLEventSupport es =
                                     (org.apache.batik.dom.svg12.XBLEventSupport)
                                       doc.
                                       initializeEventSupport(
                                         );
                                   es.removeImplementationEventListenerNS(
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        "DOMNodeRemoved",
                                        docRemovedListener,
                                        true);
                                   es.removeImplementationEventListenerNS(
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        "DOMNodeInserted",
                                        docInsertedListener,
                                        true);
                                   es.removeImplementationEventListenerNS(
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        "DOMSubtreeModified",
                                        docSubtreeListener,
                                        true);
                                   int nSlots =
                                     imports.
                                     values(
                                       ).
                                     size(
                                       );
                                   org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord[] irs =
                                     new org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord[nSlots];
                                   imports.
                                     values(
                                       ).
                                     toArray(
                                       irs);
                                   for (int i =
                                          0;
                                        i <
                                          irs.
                                            length;
                                        i++) {
                                       org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord ir =
                                         irs[i];
                                       if (ir.
                                             importElement.
                                             getLocalName(
                                               ).
                                             equals(
                                               XBL_DEFINITION_TAG)) {
                                           removeDefinitionRef(
                                             ir.
                                               importElement);
                                       }
                                       else {
                                           removeImport(
                                             ir.
                                               importElement);
                                       }
                                   }
                                   java.lang.Object[] defRecs =
                                     definitions.
                                     getValuesArray(
                                       );
                                   definitions.
                                     clear(
                                       );
                                   for (int i =
                                          0;
                                        i <
                                          defRecs.
                                            length;
                                        i++) {
                                       org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec =
                                         (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
                                           defRecs[i];
                                       java.util.TreeSet defs =
                                         (java.util.TreeSet)
                                           definitionLists.
                                           get(
                                             defRec.
                                               namespaceURI,
                                             defRec.
                                               localName);
                                       if (defs !=
                                             null) {
                                           while (!defs.
                                                    isEmpty(
                                                      )) {
                                               defRec =
                                                 (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
                                                   defs.
                                                   first(
                                                     );
                                               defs.
                                                 remove(
                                                   defRec);
                                               removeDefinition(
                                                 defRec);
                                           }
                                           definitionLists.
                                             put(
                                               defRec.
                                                 namespaceURI,
                                               defRec.
                                                 localName,
                                               null);
                                       }
                                   }
                                   definitionLists =
                                     new org.apache.batik.util.DoublyIndexedTable(
                                       );
                                   contentManagers.
                                     clear(
                                       );
    }
    public boolean isProcessing() { return isProcessing;
    }
    protected void addDefinitionRef(org.w3c.dom.Element defRef) {
        java.lang.String ref =
          defRef.
          getAttributeNS(
            null,
            XBL_REF_ATTRIBUTE);
        org.w3c.dom.Element e =
          ctx.
          getReferencedElement(
            defRef,
            ref);
        if (!XBL_NAMESPACE_URI.
              equals(
                e.
                  getNamespaceURI(
                    )) ||
              !XBL_DEFINITION_TAG.
              equals(
                e.
                  getLocalName(
                    ))) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              defRef,
              org.apache.batik.bridge.ErrorConstants.
                ERR_URI_BAD_TARGET,
              new java.lang.Object[] { ref });
        }
        org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord ir =
          new org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord(
          defRef,
          e);
        imports.
          put(
            defRef,
            ir);
        org.apache.batik.dom.events.NodeEventTarget et =
          (org.apache.batik.dom.events.NodeEventTarget)
            defRef;
        et.
          addEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMAttrModified",
            refAttrListener,
            false,
            null);
        org.apache.batik.dom.svg12.XBLOMDefinitionElement d =
          (org.apache.batik.dom.svg12.XBLOMDefinitionElement)
            defRef;
        java.lang.String ns =
          d.
          getElementNamespaceURI(
            );
        java.lang.String ln =
          d.
          getElementLocalName(
            );
        addDefinition(
          ns,
          ln,
          (org.apache.batik.dom.svg12.XBLOMDefinitionElement)
            e,
          defRef);
    }
    protected void removeDefinitionRef(org.w3c.dom.Element defRef) {
        org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord ir =
          (org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord)
            imports.
            get(
              defRef);
        org.apache.batik.dom.events.NodeEventTarget et =
          (org.apache.batik.dom.events.NodeEventTarget)
            defRef;
        et.
          removeEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMAttrModified",
            refAttrListener,
            false);
        org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec =
          (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
            definitions.
            get(
              ir.
                node,
              defRef);
        removeDefinition(
          defRec);
        imports.
          remove(
            defRef);
    }
    protected void addImport(org.w3c.dom.Element imp) {
        java.lang.String bindings =
          imp.
          getAttributeNS(
            null,
            XBL_BINDINGS_ATTRIBUTE);
        org.w3c.dom.Node n =
          ctx.
          getReferencedNode(
            imp,
            bindings);
        if (n.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                ELEMENT_NODE &&
              !(XBL_NAMESPACE_URI.
                  equals(
                    n.
                      getNamespaceURI(
                        )) &&
                  XBL_XBL_TAG.
                  equals(
                    n.
                      getLocalName(
                        )))) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              imp,
              org.apache.batik.bridge.ErrorConstants.
                ERR_URI_BAD_TARGET,
              new java.lang.Object[] { n });
        }
        org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord ir =
          new org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord(
          imp,
          n);
        imports.
          put(
            imp,
            ir);
        org.apache.batik.dom.events.NodeEventTarget et =
          (org.apache.batik.dom.events.NodeEventTarget)
            imp;
        et.
          addEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMAttrModified",
            importAttrListener,
            false,
            null);
        et =
          (org.apache.batik.dom.events.NodeEventTarget)
            n;
        et.
          addEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeInserted",
            ir.
              importInsertedListener,
            false,
            null);
        et.
          addEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            ir.
              importRemovedListener,
            false,
            null);
        et.
          addEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            ir.
              importSubtreeListener,
            false,
            null);
        addImportedDefinitions(
          imp,
          n);
    }
    protected void addImportedDefinitions(org.w3c.dom.Element imp,
                                          org.w3c.dom.Node n) {
        if (n instanceof org.apache.batik.dom.svg12.XBLOMDefinitionElement) {
            org.apache.batik.dom.svg12.XBLOMDefinitionElement def =
              (org.apache.batik.dom.svg12.XBLOMDefinitionElement)
                n;
            java.lang.String ns =
              def.
              getElementNamespaceURI(
                );
            java.lang.String ln =
              def.
              getElementLocalName(
                );
            addDefinition(
              ns,
              ln,
              def,
              imp);
        }
        else {
            n =
              n.
                getFirstChild(
                  );
            while (n !=
                     null) {
                addImportedDefinitions(
                  imp,
                  n);
                n =
                  n.
                    getNextSibling(
                      );
            }
        }
    }
    protected void removeImport(org.w3c.dom.Element imp) {
        org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord ir =
          (org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord)
            imports.
            get(
              imp);
        org.apache.batik.dom.events.NodeEventTarget et =
          (org.apache.batik.dom.events.NodeEventTarget)
            ir.
              node;
        et.
          removeEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeInserted",
            ir.
              importInsertedListener,
            false);
        et.
          removeEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            ir.
              importRemovedListener,
            false);
        et.
          removeEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            ir.
              importSubtreeListener,
            false);
        et =
          (org.apache.batik.dom.events.NodeEventTarget)
            imp;
        et.
          removeEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMAttrModified",
            importAttrListener,
            false);
        java.lang.Object[] defRecs =
          definitions.
          getValuesArray(
            );
        for (int i =
               0;
             i <
               defRecs.
                 length;
             i++) {
            org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec =
              (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
                defRecs[i];
            if (defRec.
                  importElement ==
                  imp) {
                removeDefinition(
                  defRec);
            }
        }
        imports.
          remove(
            imp);
    }
    protected void addDefinition(java.lang.String namespaceURI,
                                 java.lang.String localName,
                                 org.apache.batik.dom.svg12.XBLOMDefinitionElement def,
                                 org.w3c.dom.Element imp) {
        org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord ir =
          (org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord)
            imports.
            get(
              imp);
        org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord oldDefRec =
          null;
        org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec;
        java.util.TreeSet defs =
          (java.util.TreeSet)
            definitionLists.
            get(
              namespaceURI,
              localName);
        if (defs ==
              null) {
            defs =
              new java.util.TreeSet(
                );
            definitionLists.
              put(
                namespaceURI,
                localName,
                defs);
        }
        else
            if (defs.
                  size(
                    ) >
                  0) {
                oldDefRec =
                  (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
                    defs.
                    first(
                      );
            }
        org.apache.batik.dom.svg12.XBLOMTemplateElement template =
          null;
        for (org.w3c.dom.Node n =
               def.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n instanceof org.apache.batik.dom.svg12.XBLOMTemplateElement) {
                template =
                  (org.apache.batik.dom.svg12.XBLOMTemplateElement)
                    n;
                break;
            }
        }
        defRec =
          new org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord(
            namespaceURI,
            localName,
            def,
            template,
            imp);
        defs.
          add(
            defRec);
        definitions.
          put(
            def,
            imp,
            defRec);
        addDefinitionElementListeners(
          def,
          ir);
        if (defs.
              first(
                ) !=
              defRec) {
            return;
        }
        if (oldDefRec !=
              null) {
            org.apache.batik.dom.svg12.XBLOMDefinitionElement oldDef =
              oldDefRec.
                definition;
            org.apache.batik.dom.svg12.XBLOMTemplateElement oldTemplate =
              oldDefRec.
                template;
            if (oldTemplate !=
                  null) {
                removeTemplateElementListeners(
                  oldTemplate,
                  ir);
            }
            removeDefinitionElementListeners(
              oldDef,
              ir);
        }
        if (template !=
              null) {
            addTemplateElementListeners(
              template,
              ir);
        }
        if (isProcessing) {
            rebind(
              namespaceURI,
              localName,
              document.
                getDocumentElement(
                  ));
        }
    }
    protected void addDefinitionElementListeners(org.apache.batik.dom.svg12.XBLOMDefinitionElement def,
                                                 org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord ir) {
        org.apache.batik.dom.svg12.XBLEventSupport es =
          (org.apache.batik.dom.svg12.XBLEventSupport)
            def.
            initializeEventSupport(
              );
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMAttrModified",
            ir.
              defAttrListener,
            false);
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeInserted",
            ir.
              defNodeInsertedListener,
            false);
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            ir.
              defNodeRemovedListener,
            false);
    }
    protected void addTemplateElementListeners(org.apache.batik.dom.svg12.XBLOMTemplateElement template,
                                               org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord ir) {
        org.apache.batik.dom.svg12.XBLEventSupport es =
          (org.apache.batik.dom.svg12.XBLEventSupport)
            template.
            initializeEventSupport(
              );
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMAttrModified",
            ir.
              templateMutationListener,
            false);
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeInserted",
            ir.
              templateMutationListener,
            false);
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            ir.
              templateMutationListener,
            false);
        es.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMCharacterDataModified",
            ir.
              templateMutationListener,
            false);
    }
    protected void removeDefinition(org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec) {
        java.util.TreeSet defs =
          (java.util.TreeSet)
            definitionLists.
            get(
              defRec.
                namespaceURI,
              defRec.
                localName);
        if (defs ==
              null) {
            return;
        }
        org.w3c.dom.Element imp =
          defRec.
            importElement;
        org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord ir =
          (org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord)
            imports.
            get(
              imp);
        org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord activeDefRec =
          (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
            defs.
            first(
              );
        defs.
          remove(
            defRec);
        definitions.
          remove(
            defRec.
              definition,
            imp);
        removeDefinitionElementListeners(
          defRec.
            definition,
          ir);
        if (defRec !=
              activeDefRec) {
            return;
        }
        if (defRec.
              template !=
              null) {
            removeTemplateElementListeners(
              defRec.
                template,
              ir);
        }
        rebind(
          defRec.
            namespaceURI,
          defRec.
            localName,
          document.
            getDocumentElement(
              ));
    }
    protected void removeDefinitionElementListeners(org.apache.batik.dom.svg12.XBLOMDefinitionElement def,
                                                    org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord ir) {
        org.apache.batik.dom.svg12.XBLEventSupport es =
          (org.apache.batik.dom.svg12.XBLEventSupport)
            def.
            initializeEventSupport(
              );
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMAttrModified",
            ir.
              defAttrListener,
            false);
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeInserted",
            ir.
              defNodeInsertedListener,
            false);
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            ir.
              defNodeRemovedListener,
            false);
    }
    protected void removeTemplateElementListeners(org.apache.batik.dom.svg12.XBLOMTemplateElement template,
                                                  org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord ir) {
        org.apache.batik.dom.svg12.XBLEventSupport es =
          (org.apache.batik.dom.svg12.XBLEventSupport)
            template.
            initializeEventSupport(
              );
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMAttrModified",
            ir.
              templateMutationListener,
            false);
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeInserted",
            ir.
              templateMutationListener,
            false);
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            ir.
              templateMutationListener,
            false);
        es.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMCharacterDataModified",
            ir.
              templateMutationListener,
            false);
    }
    protected org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord getActiveDefinition(java.lang.String namespaceURI,
                                                                                                   java.lang.String localName) {
        java.util.TreeSet defs =
          (java.util.TreeSet)
            definitionLists.
            get(
              namespaceURI,
              localName);
        if (defs ==
              null ||
              defs.
              size(
                ) ==
              0) {
            return null;
        }
        return (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
                 defs.
                 first(
                   );
    }
    protected void unbind(org.w3c.dom.Element e) {
        if (e instanceof org.apache.batik.dom.svg12.BindableElement) {
            setActiveDefinition(
              (org.apache.batik.dom.svg12.BindableElement)
                e,
              null);
        }
        else {
            org.w3c.dom.NodeList nl =
              getXblScopedChildNodes(
                e);
            for (int i =
                   0;
                 i <
                   nl.
                   getLength(
                     );
                 i++) {
                org.w3c.dom.Node n =
                  nl.
                  item(
                    i);
                if (n.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    unbind(
                      (org.w3c.dom.Element)
                        n);
                }
            }
        }
    }
    protected void bind(org.w3c.dom.Element e) {
        org.apache.batik.dom.AbstractDocument doc =
          (org.apache.batik.dom.AbstractDocument)
            e.
            getOwnerDocument(
              );
        if (doc !=
              document) {
            org.apache.batik.dom.xbl.XBLManager xm =
              doc.
              getXBLManager(
                );
            if (xm instanceof org.apache.batik.bridge.svg12.DefaultXBLManager) {
                ((org.apache.batik.bridge.svg12.DefaultXBLManager)
                   xm).
                  bind(
                    e);
                return;
            }
        }
        if (e instanceof org.apache.batik.dom.svg12.BindableElement) {
            org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec =
              getActiveDefinition(
                e.
                  getNamespaceURI(
                    ),
                e.
                  getLocalName(
                    ));
            setActiveDefinition(
              (org.apache.batik.dom.svg12.BindableElement)
                e,
              defRec);
        }
        else {
            org.w3c.dom.NodeList nl =
              getXblScopedChildNodes(
                e);
            for (int i =
                   0;
                 i <
                   nl.
                   getLength(
                     );
                 i++) {
                org.w3c.dom.Node n =
                  nl.
                  item(
                    i);
                if (n.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    bind(
                      (org.w3c.dom.Element)
                        n);
                }
            }
        }
    }
    protected void rebind(java.lang.String namespaceURI,
                          java.lang.String localName,
                          org.w3c.dom.Element e) {
        org.apache.batik.dom.AbstractDocument doc =
          (org.apache.batik.dom.AbstractDocument)
            e.
            getOwnerDocument(
              );
        if (doc !=
              document) {
            org.apache.batik.dom.xbl.XBLManager xm =
              doc.
              getXBLManager(
                );
            if (xm instanceof org.apache.batik.bridge.svg12.DefaultXBLManager) {
                ((org.apache.batik.bridge.svg12.DefaultXBLManager)
                   xm).
                  rebind(
                    namespaceURI,
                    localName,
                    e);
                return;
            }
        }
        if (e instanceof org.apache.batik.dom.svg12.BindableElement &&
              namespaceURI.
              equals(
                e.
                  getNamespaceURI(
                    )) &&
              localName.
              equals(
                e.
                  getLocalName(
                    ))) {
            org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec =
              getActiveDefinition(
                e.
                  getNamespaceURI(
                    ),
                e.
                  getLocalName(
                    ));
            setActiveDefinition(
              (org.apache.batik.dom.svg12.BindableElement)
                e,
              defRec);
        }
        else {
            org.w3c.dom.NodeList nl =
              getXblScopedChildNodes(
                e);
            for (int i =
                   0;
                 i <
                   nl.
                   getLength(
                     );
                 i++) {
                org.w3c.dom.Node n =
                  nl.
                  item(
                    i);
                if (n.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    rebind(
                      namespaceURI,
                      localName,
                      (org.w3c.dom.Element)
                        n);
                }
            }
        }
    }
    protected void setActiveDefinition(org.apache.batik.dom.svg12.BindableElement elt,
                                       org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec) {
        org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec =
          getRecord(
            elt);
        rec.
          definitionElement =
          defRec ==
            null
            ? null
            : defRec.
                definition;
        if (defRec !=
              null &&
              defRec.
                definition !=
              null &&
              defRec.
                template !=
              null) {
            setXblShadowTree(
              elt,
              cloneTemplate(
                defRec.
                  template));
        }
        else {
            setXblShadowTree(
              elt,
              null);
        }
    }
    protected void setXblShadowTree(org.apache.batik.dom.svg12.BindableElement elt,
                                    org.apache.batik.dom.svg12.XBLOMShadowTreeElement newShadow) {
        org.apache.batik.dom.svg12.XBLOMShadowTreeElement oldShadow =
          (org.apache.batik.dom.svg12.XBLOMShadowTreeElement)
            getXblShadowTree(
              elt);
        if (oldShadow !=
              null) {
            fireShadowTreeEvent(
              elt,
              XBL_UNBINDING_EVENT_TYPE,
              oldShadow);
            org.apache.batik.bridge.svg12.ContentManager cm =
              getContentManager(
                oldShadow);
            if (cm !=
                  null) {
                cm.
                  dispose(
                    );
            }
            elt.
              setShadowTree(
                null);
            org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec =
              getRecord(
                oldShadow);
            rec.
              boundElement =
              null;
            oldShadow.
              removeEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "DOMSubtreeModified",
                docSubtreeListener,
                false);
        }
        if (newShadow !=
              null) {
            newShadow.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                "DOMSubtreeModified",
                docSubtreeListener,
                false,
                null);
            fireShadowTreeEvent(
              elt,
              XBL_PREBIND_EVENT_TYPE,
              newShadow);
            elt.
              setShadowTree(
                newShadow);
            org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec =
              getRecord(
                newShadow);
            rec.
              boundElement =
              elt;
            org.apache.batik.dom.AbstractDocument doc =
              (org.apache.batik.dom.AbstractDocument)
                elt.
                getOwnerDocument(
                  );
            org.apache.batik.dom.xbl.XBLManager xm =
              doc.
              getXBLManager(
                );
            org.apache.batik.bridge.svg12.ContentManager cm =
              new org.apache.batik.bridge.svg12.ContentManager(
              newShadow,
              xm);
            setContentManager(
              newShadow,
              cm);
        }
        invalidateChildNodes(
          elt);
        if (newShadow !=
              null) {
            org.w3c.dom.NodeList nl =
              getXblScopedChildNodes(
                elt);
            for (int i =
                   0;
                 i <
                   nl.
                   getLength(
                     );
                 i++) {
                org.w3c.dom.Node n =
                  nl.
                  item(
                    i);
                if (n.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    bind(
                      (org.w3c.dom.Element)
                        n);
                }
            }
            dispatchBindingChangedEvent(
              elt,
              newShadow);
            fireShadowTreeEvent(
              elt,
              XBL_BOUND_EVENT_TYPE,
              newShadow);
        }
        else {
            dispatchBindingChangedEvent(
              elt,
              newShadow);
        }
    }
    protected void fireShadowTreeEvent(org.apache.batik.dom.svg12.BindableElement elt,
                                       java.lang.String type,
                                       org.apache.batik.dom.xbl.XBLShadowTreeElement e) {
        org.w3c.dom.events.DocumentEvent de =
          (org.w3c.dom.events.DocumentEvent)
            elt.
            getOwnerDocument(
              );
        org.apache.batik.dom.xbl.ShadowTreeEvent evt =
          (org.apache.batik.dom.xbl.ShadowTreeEvent)
            de.
            createEvent(
              "ShadowTreeEvent");
        evt.
          initShadowTreeEventNS(
            XBL_NAMESPACE_URI,
            type,
            true,
            false,
            e);
        elt.
          dispatchEvent(
            evt);
    }
    protected org.apache.batik.dom.svg12.XBLOMShadowTreeElement cloneTemplate(org.apache.batik.dom.svg12.XBLOMTemplateElement template) {
        org.apache.batik.dom.svg12.XBLOMShadowTreeElement clone =
          (org.apache.batik.dom.svg12.XBLOMShadowTreeElement)
            template.
            getOwnerDocument(
              ).
            createElementNS(
              XBL_NAMESPACE_URI,
              XBL_SHADOW_TREE_TAG);
        org.w3c.dom.NamedNodeMap attrs =
          template.
          getAttributes(
            );
        for (int i =
               0;
             i <
               attrs.
               getLength(
                 );
             i++) {
            org.w3c.dom.Attr attr =
              (org.w3c.dom.Attr)
                attrs.
                item(
                  i);
            if (attr instanceof org.apache.batik.dom.AbstractAttrNS) {
                clone.
                  setAttributeNodeNS(
                    attr);
            }
            else {
                clone.
                  setAttributeNode(
                    attr);
            }
        }
        for (org.w3c.dom.Node n =
               template.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            clone.
              appendChild(
                n.
                  cloneNode(
                    true));
        }
        return clone;
    }
    public org.w3c.dom.Node getXblParentNode(org.w3c.dom.Node n) {
        org.w3c.dom.Node contentElement =
          getXblContentElement(
            n);
        org.w3c.dom.Node parent =
          contentElement ==
          null
          ? n.
          getParentNode(
            )
          : contentElement.
          getParentNode(
            );
        if (parent instanceof org.apache.batik.dom.svg12.XBLOMContentElement) {
            parent =
              parent.
                getParentNode(
                  );
        }
        if (parent instanceof org.apache.batik.dom.svg12.XBLOMShadowTreeElement) {
            parent =
              getXblBoundElement(
                parent);
        }
        return parent;
    }
    public org.w3c.dom.NodeList getXblChildNodes(org.w3c.dom.Node n) {
        org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec =
          getRecord(
            n);
        if (rec.
              childNodes ==
              null) {
            rec.
              childNodes =
              new org.apache.batik.bridge.svg12.DefaultXBLManager.XblChildNodes(
                rec);
        }
        return rec.
                 childNodes;
    }
    public org.w3c.dom.NodeList getXblScopedChildNodes(org.w3c.dom.Node n) {
        org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec =
          getRecord(
            n);
        if (rec.
              scopedChildNodes ==
              null) {
            rec.
              scopedChildNodes =
              new org.apache.batik.bridge.svg12.DefaultXBLManager.XblScopedChildNodes(
                rec);
        }
        return rec.
                 scopedChildNodes;
    }
    public org.w3c.dom.Node getXblFirstChild(org.w3c.dom.Node n) {
        org.w3c.dom.NodeList nl =
          getXblChildNodes(
            n);
        return nl.
          item(
            0);
    }
    public org.w3c.dom.Node getXblLastChild(org.w3c.dom.Node n) {
        org.w3c.dom.NodeList nl =
          getXblChildNodes(
            n);
        return nl.
          item(
            nl.
              getLength(
                ) -
              1);
    }
    public org.w3c.dom.Node getXblPreviousSibling(org.w3c.dom.Node n) {
        org.w3c.dom.Node p =
          getXblParentNode(
            n);
        if (p ==
              null ||
              getRecord(
                p).
                childNodes ==
              null) {
            return n.
              getPreviousSibling(
                );
        }
        org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec =
          getRecord(
            n);
        if (!rec.
               linksValid) {
            updateLinks(
              n);
        }
        return rec.
                 previousSibling;
    }
    public org.w3c.dom.Node getXblNextSibling(org.w3c.dom.Node n) {
        org.w3c.dom.Node p =
          getXblParentNode(
            n);
        if (p ==
              null ||
              getRecord(
                p).
                childNodes ==
              null) {
            return n.
              getNextSibling(
                );
        }
        org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec =
          getRecord(
            n);
        if (!rec.
               linksValid) {
            updateLinks(
              n);
        }
        return rec.
                 nextSibling;
    }
    public org.w3c.dom.Element getXblFirstElementChild(org.w3c.dom.Node n) {
        n =
          getXblFirstChild(
            n);
        while (n !=
                 null &&
                 n.
                 getNodeType(
                   ) !=
                 org.w3c.dom.Node.
                   ELEMENT_NODE) {
            n =
              getXblNextSibling(
                n);
        }
        return (org.w3c.dom.Element)
                 n;
    }
    public org.w3c.dom.Element getXblLastElementChild(org.w3c.dom.Node n) {
        n =
          getXblLastChild(
            n);
        while (n !=
                 null &&
                 n.
                 getNodeType(
                   ) !=
                 org.w3c.dom.Node.
                   ELEMENT_NODE) {
            n =
              getXblPreviousSibling(
                n);
        }
        return (org.w3c.dom.Element)
                 n;
    }
    public org.w3c.dom.Element getXblPreviousElementSibling(org.w3c.dom.Node n) {
        do  {
            n =
              getXblPreviousSibling(
                n);
        }while(n !=
                 null &&
                 n.
                 getNodeType(
                   ) !=
                 org.w3c.dom.Node.
                   ELEMENT_NODE); 
        return (org.w3c.dom.Element)
                 n;
    }
    public org.w3c.dom.Element getXblNextElementSibling(org.w3c.dom.Node n) {
        do  {
            n =
              getXblNextSibling(
                n);
        }while(n !=
                 null &&
                 n.
                 getNodeType(
                   ) !=
                 org.w3c.dom.Node.
                   ELEMENT_NODE); 
        return (org.w3c.dom.Element)
                 n;
    }
    public org.w3c.dom.Element getXblBoundElement(org.w3c.dom.Node n) {
        while (n !=
                 null &&
                 !(n instanceof org.apache.batik.dom.xbl.XBLShadowTreeElement)) {
            org.apache.batik.dom.svg12.XBLOMContentElement content =
              getXblContentElement(
                n);
            if (content !=
                  null) {
                n =
                  content;
            }
            n =
              n.
                getParentNode(
                  );
        }
        if (n ==
              null) {
            return null;
        }
        return getRecord(
                 n).
                 boundElement;
    }
    public org.w3c.dom.Element getXblShadowTree(org.w3c.dom.Node n) {
        if (n instanceof org.apache.batik.dom.svg12.BindableElement) {
            org.apache.batik.dom.svg12.BindableElement elt =
              (org.apache.batik.dom.svg12.BindableElement)
                n;
            return elt.
              getShadowTree(
                );
        }
        return null;
    }
    public org.w3c.dom.NodeList getXblDefinitions(org.w3c.dom.Node n) {
        final java.lang.String namespaceURI =
          n.
          getNamespaceURI(
            );
        final java.lang.String localName =
          n.
          getLocalName(
            );
        return new org.w3c.dom.NodeList(
          ) {
            public org.w3c.dom.Node item(int i) {
                java.util.TreeSet defs =
                  (java.util.TreeSet)
                    definitionLists.
                    get(
                      namespaceURI,
                      localName);
                if (defs !=
                      null &&
                      defs.
                      size(
                        ) !=
                      0 &&
                      i ==
                      0) {
                    org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec =
                      (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
                        defs.
                        first(
                          );
                    return defRec.
                             definition;
                }
                return null;
            }
            public int getLength() {
                java.util.Set defs =
                  (java.util.TreeSet)
                    definitionLists.
                    get(
                      namespaceURI,
                      localName);
                return defs !=
                  null &&
                  defs.
                  size(
                    ) !=
                  0
                  ? 1
                  : 0;
            }
        };
    }
    protected org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord getRecord(org.w3c.dom.Node n) {
        org.apache.batik.dom.xbl.XBLManagerData xmd =
          (org.apache.batik.dom.xbl.XBLManagerData)
            n;
        org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec =
          (org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord)
            xmd.
            getManagerData(
              );
        if (rec ==
              null) {
            rec =
              new org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord(
                );
            rec.
              node =
              n;
            xmd.
              setManagerData(
                rec);
        }
        return rec;
    }
    protected void updateLinks(org.w3c.dom.Node n) {
        org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec =
          getRecord(
            n);
        rec.
          previousSibling =
          null;
        rec.
          nextSibling =
          null;
        rec.
          linksValid =
          true;
        org.w3c.dom.Node p =
          getXblParentNode(
            n);
        if (p !=
              null) {
            org.w3c.dom.NodeList xcn =
              getXblChildNodes(
                p);
            if (xcn instanceof org.apache.batik.bridge.svg12.DefaultXBLManager.XblChildNodes) {
                ((org.apache.batik.bridge.svg12.DefaultXBLManager.XblChildNodes)
                   xcn).
                  update(
                    );
            }
        }
    }
    public org.apache.batik.dom.svg12.XBLOMContentElement getXblContentElement(org.w3c.dom.Node n) {
        return getRecord(
                 n).
                 contentElement;
    }
    public static int computeBubbleLimit(org.w3c.dom.Node from,
                                         org.w3c.dom.Node to) {
        java.util.ArrayList fromList =
          new java.util.ArrayList(
          10);
        java.util.ArrayList toList =
          new java.util.ArrayList(
          10);
        while (from !=
                 null) {
            fromList.
              add(
                from);
            from =
              ((org.apache.batik.dom.xbl.NodeXBL)
                 from).
                getXblParentNode(
                  );
        }
        while (to !=
                 null) {
            toList.
              add(
                to);
            to =
              ((org.apache.batik.dom.xbl.NodeXBL)
                 to).
                getXblParentNode(
                  );
        }
        int fromSize =
          fromList.
          size(
            );
        int toSize =
          toList.
          size(
            );
        for (int i =
               0;
             i <
               fromSize &&
               i <
               toSize;
             i++) {
            org.w3c.dom.Node n1 =
              (org.w3c.dom.Node)
                fromList.
                get(
                  fromSize -
                    i -
                    1);
            org.w3c.dom.Node n2 =
              (org.w3c.dom.Node)
                toList.
                get(
                  toSize -
                    i -
                    1);
            if (n1 !=
                  n2) {
                org.w3c.dom.Node prevBoundElement =
                  ((org.apache.batik.dom.xbl.NodeXBL)
                     n1).
                  getXblBoundElement(
                    );
                while (i >
                         0 &&
                         prevBoundElement !=
                         fromList.
                         get(
                           fromSize -
                             i -
                             1)) {
                    i--;
                }
                return fromSize -
                  i -
                  1;
            }
        }
        return 1;
    }
    public org.apache.batik.bridge.svg12.ContentManager getContentManager(org.w3c.dom.Node n) {
        org.w3c.dom.Node b =
          getXblBoundElement(
            n);
        if (b !=
              null) {
            org.w3c.dom.Element s =
              getXblShadowTree(
                b);
            if (s !=
                  null) {
                org.apache.batik.bridge.svg12.ContentManager cm;
                org.w3c.dom.Document doc =
                  b.
                  getOwnerDocument(
                    );
                if (doc !=
                      document) {
                    org.apache.batik.bridge.svg12.DefaultXBLManager xm =
                      (org.apache.batik.bridge.svg12.DefaultXBLManager)
                        ((org.apache.batik.dom.AbstractDocument)
                           doc).
                        getXBLManager(
                          );
                    cm =
                      (org.apache.batik.bridge.svg12.ContentManager)
                        xm.
                          contentManagers.
                        get(
                          s);
                }
                else {
                    cm =
                      (org.apache.batik.bridge.svg12.ContentManager)
                        contentManagers.
                        get(
                          s);
                }
                return cm;
            }
        }
        return null;
    }
    void setContentManager(org.w3c.dom.Element shadow,
                           org.apache.batik.bridge.svg12.ContentManager cm) {
        if (cm ==
              null) {
            contentManagers.
              remove(
                shadow);
        }
        else {
            contentManagers.
              put(
                shadow,
                cm);
        }
    }
    public void invalidateChildNodes(org.w3c.dom.Node n) {
        org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec =
          getRecord(
            n);
        if (rec.
              childNodes !=
              null) {
            rec.
              childNodes.
              invalidate(
                );
        }
        if (rec.
              scopedChildNodes !=
              null) {
            rec.
              scopedChildNodes.
              invalidate(
                );
        }
    }
    public void addContentSelectionChangedListener(org.apache.batik.bridge.svg12.ContentSelectionChangedListener l) {
        contentSelectionChangedListenerList.
          add(
            org.apache.batik.bridge.svg12.ContentSelectionChangedListener.class,
            l);
    }
    public void removeContentSelectionChangedListener(org.apache.batik.bridge.svg12.ContentSelectionChangedListener l) {
        contentSelectionChangedListenerList.
          remove(
            org.apache.batik.bridge.svg12.ContentSelectionChangedListener.class,
            l);
    }
    protected java.lang.Object[] getContentSelectionChangedListeners() {
        return contentSelectionChangedListenerList.
          getListenerList(
            );
    }
    void shadowTreeSelectedContentChanged(java.util.Set deselected,
                                          java.util.Set selected) {
        java.util.Iterator i =
          deselected.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.w3c.dom.Node n =
              (org.w3c.dom.Node)
                i.
                next(
                  );
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                unbind(
                  (org.w3c.dom.Element)
                    n);
            }
        }
        i =
          selected.
            iterator(
              );
        while (i.
                 hasNext(
                   )) {
            org.w3c.dom.Node n =
              (org.w3c.dom.Node)
                i.
                next(
                  );
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                bind(
                  (org.w3c.dom.Element)
                    n);
            }
        }
    }
    public void addBindingListener(org.apache.batik.bridge.svg12.BindingListener l) {
        bindingListenerList.
          add(
            org.apache.batik.bridge.svg12.BindingListener.class,
            l);
    }
    public void removeBindingListener(org.apache.batik.bridge.svg12.BindingListener l) {
        bindingListenerList.
          remove(
            org.apache.batik.bridge.svg12.BindingListener.class,
            l);
    }
    protected void dispatchBindingChangedEvent(org.w3c.dom.Element bindableElement,
                                               org.w3c.dom.Element shadowTree) {
        java.lang.Object[] ls =
          bindingListenerList.
          getListenerList(
            );
        for (int i =
               ls.
                 length -
               2;
             i >=
               0;
             i -=
               2) {
            org.apache.batik.bridge.svg12.BindingListener l =
              (org.apache.batik.bridge.svg12.BindingListener)
                ls[i +
                     1];
            l.
              bindingChanged(
                bindableElement,
                shadowTree);
        }
    }
    protected boolean isActiveDefinition(org.apache.batik.dom.svg12.XBLOMDefinitionElement def,
                                         org.w3c.dom.Element imp) {
        org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec =
          (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
            definitions.
            get(
              def,
              imp);
        if (defRec ==
              null) {
            return false;
        }
        return defRec ==
          getActiveDefinition(
            defRec.
              namespaceURI,
            defRec.
              localName);
    }
    protected class DefinitionRecord implements java.lang.Comparable {
        public java.lang.String namespaceURI;
        public java.lang.String localName;
        public org.apache.batik.dom.svg12.XBLOMDefinitionElement
          definition;
        public org.apache.batik.dom.svg12.XBLOMTemplateElement
          template;
        public org.w3c.dom.Element importElement;
        public DefinitionRecord(java.lang.String ns,
                                java.lang.String ln,
                                org.apache.batik.dom.svg12.XBLOMDefinitionElement def,
                                org.apache.batik.dom.svg12.XBLOMTemplateElement t,
                                org.w3c.dom.Element imp) {
            super(
              );
            namespaceURI =
              ns;
            localName =
              ln;
            definition =
              def;
            template =
              t;
            importElement =
              imp;
        }
        public boolean equals(java.lang.Object other) {
            return compareTo(
                     other) ==
              0;
        }
        public int compareTo(java.lang.Object other) {
            org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord rec =
              (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
                other;
            org.apache.batik.dom.AbstractNode n1;
            org.apache.batik.dom.AbstractNode n2;
            if (importElement ==
                  null) {
                n1 =
                  definition;
                if (rec.
                      importElement ==
                      null) {
                    n2 =
                      rec.
                        definition;
                }
                else {
                    n2 =
                      (org.apache.batik.dom.AbstractNode)
                        rec.
                          importElement;
                }
            }
            else
                if (rec.
                      importElement ==
                      null) {
                    n1 =
                      (org.apache.batik.dom.AbstractNode)
                        importElement;
                    n2 =
                      rec.
                        definition;
                }
                else
                    if (definition.
                          getOwnerDocument(
                            ) ==
                          rec.
                            definition.
                          getOwnerDocument(
                            )) {
                        n1 =
                          definition;
                        n2 =
                          rec.
                            definition;
                    }
                    else {
                        n1 =
                          (org.apache.batik.dom.AbstractNode)
                            importElement;
                        n2 =
                          (org.apache.batik.dom.AbstractNode)
                            rec.
                              importElement;
                    }
            short comp =
              n1.
              compareDocumentPosition(
                n2);
            if ((comp &
                   org.apache.batik.dom.AbstractNode.
                     DOCUMENT_POSITION_PRECEDING) !=
                  0) {
                return -1;
            }
            if ((comp &
                   org.apache.batik.dom.AbstractNode.
                     DOCUMENT_POSITION_FOLLOWING) !=
                  0) {
                return 1;
            }
            return 0;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "q79dHVT8X4SdkwjBKAAA");
    }
    protected class ImportRecord {
        public org.w3c.dom.Element importElement;
        public org.w3c.dom.Node node;
        public org.apache.batik.bridge.svg12.DefaultXBLManager.DefNodeInsertedListener
          defNodeInsertedListener;
        public org.apache.batik.bridge.svg12.DefaultXBLManager.DefNodeRemovedListener
          defNodeRemovedListener;
        public org.apache.batik.bridge.svg12.DefaultXBLManager.DefAttrListener
          defAttrListener;
        public org.apache.batik.bridge.svg12.DefaultXBLManager.ImportInsertedListener
          importInsertedListener;
        public org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRemovedListener
          importRemovedListener;
        public org.apache.batik.bridge.svg12.DefaultXBLManager.ImportSubtreeListener
          importSubtreeListener;
        public org.apache.batik.bridge.svg12.DefaultXBLManager.TemplateMutationListener
          templateMutationListener;
        public ImportRecord(org.w3c.dom.Element imp,
                            org.w3c.dom.Node n) {
            super(
              );
            importElement =
              imp;
            node =
              n;
            defNodeInsertedListener =
              new org.apache.batik.bridge.svg12.DefaultXBLManager.DefNodeInsertedListener(
                imp);
            defNodeRemovedListener =
              new org.apache.batik.bridge.svg12.DefaultXBLManager.DefNodeRemovedListener(
                imp);
            defAttrListener =
              new org.apache.batik.bridge.svg12.DefaultXBLManager.DefAttrListener(
                imp);
            importInsertedListener =
              new org.apache.batik.bridge.svg12.DefaultXBLManager.ImportInsertedListener(
                imp);
            importRemovedListener =
              new org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRemovedListener(
                );
            importSubtreeListener =
              new org.apache.batik.bridge.svg12.DefaultXBLManager.ImportSubtreeListener(
                imp,
                importRemovedListener);
            templateMutationListener =
              new org.apache.batik.bridge.svg12.DefaultXBLManager.TemplateMutationListener(
                imp);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "OZoIda1t1cUeWa22AxQPYUGbr0J+1q+QLOIUlsRAHjkFC8GrqOsVbDvyrIaP" +
           "uBawYK7PMH112otm/aTDWhS72egrvtRWQk4KcTSoVLV+sVpYekybGvN+G/OG" +
           "i+HCW5VLgSf6zdKqV5xYLdokOiO+I5jLapVzhm55WNErTbm/tCZJr9IgPCRe" +
           "8L7SgvVysKEoGvMaHW08RJZYr9Yb0vOyVsWawOTbZMGte5yTJhzc7BXHYMn0" +
           "qaZuM2JLRfjES8m2DDN8x3DZNjpCKNmJK9S0EfUbQtNpq/JqQTT7rqPjq9l0" +
           "NJ12qVo8XCHLyEQFgexMkMJ0rBrtfsCTpswmUx+bIyszKaWhRZnNSSMWG81W" +
           "XYfX0x4ptETCxlym78NVuYU0RoMJsXYlojYI66y4dKzWBE2BFejlZKH1TSFV" +
           "yMkiFjv8fMUjDD9tUhK67haLs4ArpFpTqTfqfdqy42anlmLFmA7oelBQPH4m" +
           "sTU6cvS+m677DMfSNkbFYSpxvl9CalTZ85oVXd3Uho32MpxrHtLlCRwzurEy" +
           "FFdlz18PJxgaJ+1GxxYlalDv1IllgEmEjSRLISmRi5aAroVqpEw3yNqFSd71" +
           "0kJl3vGtYNLn0EWrVdS6pG4g0zq8bJdYZRI2FD0mA4qMpFW4TJOirEjDFDE0" +
           "sjFQ+/6KrAbC0JqS47Re1SOsu5nGYnkUuUiCu5iFxfWGYbd7VL/JUGnUnAyI" +
           "QEoNFgs8XiPZsjxOBt5sE0fl1QibJs4aXUf90nJWjfVZw5mIFtb22vJM6HLJ" +
           "UJtJorzBUGqAbdJ+3ZytmwVOU+b9loTDuFtCFXRuk64yllqT9bAdK432ghNT" +
           "r+2nfDyDB5MFz2l4scTN59ys0kzY6tRpGTy+akU1KyXLdTZckApMldCljZcL" +
           "pdD2i3KtT6trZxm6NJVsGgLnr0YE+OstwnFQm/N1vjepM62lpDZQgRqm4rLs" +
           "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" +
           "bz/77fx4638AxeF9ljknAAA=");
    }
    protected class ImportInsertedListener implements org.w3c.dom.events.EventListener {
        protected org.w3c.dom.Element importElement;
        public ImportInsertedListener(org.w3c.dom.Element importElement) {
            super(
              );
            this.
              importElement =
              importElement;
        }
        public void handleEvent(org.w3c.dom.events.Event evt) {
            org.w3c.dom.events.EventTarget target =
              evt.
              getTarget(
                );
            if (target instanceof org.apache.batik.dom.svg12.XBLOMDefinitionElement) {
                org.apache.batik.dom.svg12.XBLOMDefinitionElement def =
                  (org.apache.batik.dom.svg12.XBLOMDefinitionElement)
                    target;
                addDefinition(
                  def.
                    getElementNamespaceURI(
                      ),
                  def.
                    getElementLocalName(
                      ),
                  def,
                  importElement);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "nV5fAmE/v87VfY032eMb/wUOIlVRSxcAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected class ImportRemovedListener implements org.w3c.dom.events.EventListener {
        protected java.util.LinkedList toBeRemoved =
          new java.util.LinkedList(
          );
        public void handleEvent(org.w3c.dom.events.Event evt) {
            toBeRemoved.
              add(
                evt.
                  getTarget(
                    ));
        }
        public ImportRemovedListener() { super(
                                           );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "DgX5awOREvJeN3iV2rzgqzAJTZuaF27zcjCpZahYBPDQbJho/nTgADE/F0DI" +
           "jHRcVSRfPqiZxKCvDgt4Edg4EQL5OsYmKeIeYg3UYJVJrMkq4UrWpPVDrwlU" +
           "R5Vh+yhH9tS9M3T86hN25sm7kHiEyf7D3/gsfOCwQLF4DzQv71WMW0e8C3Kf" +
           "dstNlQVm4Rpdfzq/59kze/ZlGWyIouJhXZEdaqCTUMN/UMyxjnYjQ1F9wSt0" +
           "NjCRW7yQw+Ya814AipdW0pMna8tmnNzyBj+zuRdLVXD6EmlVdVcxrudSwyQJ" +
           "hfugStQ0giS/RVHTpGujqIT/8p0cEEqHKJoxgRJgWjy45Y9QFPLLg13+65Y7" +
           "RlGFIwemxINb5PsUFYEIezxuZL0b4omIVYBhUQFmAi4WtMO2XNxIbxLtnIr7" +
           "Csmwz9/aZnkm3Wun4vMn12948PrnHxdXWEnFY2PMSiWkLXFRznHV3AmtZW2V" +
           "rlt4o+ZC+fwsVj1XaPfaOObg1PO75kzfhc5qzd3r3jy18vlf7S99DU7ZVhTA" +
           "FE3bml8rZ4w0JImt0fz0DLzOb5ptC783umpJ4sO3+G0k/w7ilx+QLp/e/vqh" +
           "xlNwI63shpJWk0mGF/FrRrVNRBo2Y6hasToz/IxQBaue3F/DEI3Z+1zuF9ud" +
           "1ble9m6DopZ8tsh/IwQ3txFitutpTbarh0qnx/M6OUv3acPwKTg9rmJ1p6Ag" +
           "UZcWDUR7DCP7ViDwjMFJAfs5mndy7fP8kTUX/g1Z2fWi0RkAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "FruGIwAA");
    }
    protected class ImportSubtreeListener implements org.w3c.dom.events.EventListener {
        protected org.w3c.dom.Element importElement;
        protected org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRemovedListener
          importRemovedListener;
        public ImportSubtreeListener(org.w3c.dom.Element imp,
                                     org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRemovedListener irl) {
            super(
              );
            importElement =
              imp;
            importRemovedListener =
              irl;
        }
        public void handleEvent(org.w3c.dom.events.Event evt) {
            java.lang.Object[] defs =
              importRemovedListener.
                toBeRemoved.
              toArray(
                );
            importRemovedListener.
              toBeRemoved.
              clear(
                );
            for (int i =
                   0;
                 i <
                   defs.
                     length;
                 i++) {
                org.apache.batik.dom.svg12.XBLOMDefinitionElement def =
                  (org.apache.batik.dom.svg12.XBLOMDefinitionElement)
                    defs[i];
                org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec =
                  (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
                    definitions.
                    get(
                      def,
                      importElement);
                removeDefinition(
                  defRec);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "19XpGyMAAA==");
    }
    protected class DocInsertedListener implements org.w3c.dom.events.EventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            org.w3c.dom.events.EventTarget target =
              evt.
              getTarget(
                );
            if (target instanceof org.apache.batik.dom.svg12.XBLOMDefinitionElement) {
                if (getXblBoundElement(
                      (org.w3c.dom.Node)
                        target) ==
                      null) {
                    org.apache.batik.dom.svg12.XBLOMDefinitionElement def =
                      (org.apache.batik.dom.svg12.XBLOMDefinitionElement)
                        target;
                    if (def.
                          getAttributeNS(
                            null,
                            XBL_REF_ATTRIBUTE).
                          length(
                            ) ==
                          0) {
                        addDefinition(
                          def.
                            getElementNamespaceURI(
                              ),
                          def.
                            getElementLocalName(
                              ),
                          def,
                          null);
                    }
                    else {
                        addDefinitionRef(
                          def);
                    }
                }
            }
            else
                if (target instanceof org.apache.batik.dom.svg12.XBLOMImportElement) {
                    if (getXblBoundElement(
                          (org.w3c.dom.Node)
                            target) ==
                          null) {
                        addImport(
                          (org.w3c.dom.Element)
                            target);
                    }
                }
                else {
                    evt =
                      org.apache.batik.dom.svg12.XBLEventSupport.
                        getUltimateOriginalEvent(
                          evt);
                    target =
                      evt.
                        getTarget(
                          );
                    org.w3c.dom.Node parent =
                      getXblParentNode(
                        (org.w3c.dom.Node)
                          target);
                    if (parent !=
                          null) {
                        invalidateChildNodes(
                          parent);
                    }
                    if (target instanceof org.apache.batik.dom.svg12.BindableElement) {
                        for (org.w3c.dom.Node n =
                               ((org.w3c.dom.Node)
                                  target).
                               getParentNode(
                                 );
                             n !=
                               null;
                             n =
                               n.
                                 getParentNode(
                                   )) {
                            if (n instanceof org.apache.batik.dom.svg12.BindableElement &&
                                  getRecord(
                                    n).
                                    definitionElement !=
                                  null) {
                                return;
                            }
                        }
                        bind(
                          (org.w3c.dom.Element)
                            target);
                    }
                }
        }
        public DocInsertedListener() { super(
                                         );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "1H8BCO8PwfkUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "v/3ct4rK3P8C71j9Of4fAAA=");
    }
    protected class DocRemovedListener implements org.w3c.dom.events.EventListener {
        protected java.util.LinkedList defsToBeRemoved =
          new java.util.LinkedList(
          );
        protected java.util.LinkedList importsToBeRemoved =
          new java.util.LinkedList(
          );
        protected java.util.LinkedList nodesToBeInvalidated =
          new java.util.LinkedList(
          );
        public void handleEvent(org.w3c.dom.events.Event evt) {
            org.w3c.dom.events.EventTarget target =
              evt.
              getTarget(
                );
            if (target instanceof org.apache.batik.dom.svg12.XBLOMDefinitionElement) {
                if (getXblBoundElement(
                      (org.w3c.dom.Node)
                        target) ==
                      null) {
                    defsToBeRemoved.
                      add(
                        target);
                }
            }
            else
                if (target instanceof org.apache.batik.dom.svg12.XBLOMImportElement) {
                    if (getXblBoundElement(
                          (org.w3c.dom.Node)
                            target) ==
                          null) {
                        importsToBeRemoved.
                          add(
                            target);
                    }
                }
            org.w3c.dom.Node parent =
              getXblParentNode(
                (org.w3c.dom.Node)
                  target);
            if (parent !=
                  null) {
                nodesToBeInvalidated.
                  add(
                    parent);
            }
        }
        public DocRemovedListener() { super(
                                        );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Bf4rAacx/aIlAAA=");
    }
    protected class DocSubtreeListener implements org.w3c.dom.events.EventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            java.lang.Object[] defs =
              docRemovedListener.
                defsToBeRemoved.
              toArray(
                );
            docRemovedListener.
              defsToBeRemoved.
              clear(
                );
            for (int i =
                   0;
                 i <
                   defs.
                     length;
                 i++) {
                org.apache.batik.dom.svg12.XBLOMDefinitionElement def =
                  (org.apache.batik.dom.svg12.XBLOMDefinitionElement)
                    defs[i];
                if (def.
                      getAttributeNS(
                        null,
                        XBL_REF_ATTRIBUTE).
                      length(
                        ) ==
                      0) {
                    org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec =
                      (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
                        definitions.
                        get(
                          def,
                          null);
                    removeDefinition(
                      defRec);
                }
                else {
                    removeDefinitionRef(
                      def);
                }
            }
            java.lang.Object[] imps =
              docRemovedListener.
                importsToBeRemoved.
              toArray(
                );
            docRemovedListener.
              importsToBeRemoved.
              clear(
                );
            for (int i =
                   0;
                 i <
                   imps.
                     length;
                 i++) {
                removeImport(
                  (org.w3c.dom.Element)
                    imps[i]);
            }
            java.lang.Object[] nodes =
              docRemovedListener.
                nodesToBeInvalidated.
              toArray(
                );
            docRemovedListener.
              nodesToBeInvalidated.
              clear(
                );
            for (int i =
                   0;
                 i <
                   nodes.
                     length;
                 i++) {
                invalidateChildNodes(
                  (org.w3c.dom.Node)
                    nodes[i]);
            }
        }
        public DocSubtreeListener() { super(
                                        );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "fwFAmzl89xQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "3LeLwtz/AiW+0cr8HwAA");
    }
    protected class TemplateMutationListener implements org.w3c.dom.events.EventListener {
        protected org.w3c.dom.Element importElement;
        public TemplateMutationListener(org.w3c.dom.Element imp) {
            super(
              );
            importElement =
              imp;
        }
        public void handleEvent(org.w3c.dom.events.Event evt) {
            org.w3c.dom.Node n =
              (org.w3c.dom.Node)
                evt.
                getTarget(
                  );
            while (n !=
                     null &&
                     !(n instanceof org.apache.batik.dom.svg12.XBLOMDefinitionElement)) {
                n =
                  n.
                    getParentNode(
                      );
            }
            org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec =
              (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
                definitions.
                get(
                  n,
                  importElement);
            if (defRec ==
                  null) {
                return;
            }
            rebind(
              defRec.
                namespaceURI,
              defRec.
                localName,
              document.
                getDocumentElement(
                  ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "6nVmfSWE/fw6F/c1PmSPb/wXQw9r308XAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1ae8wjV3Wf/bK7SZYku0kgSVPyZHkkRt/YHttjK0CxxzP2" +
           "jGfs8WPG9rSwzNtjz/vtgbSA2kKLBFEJFCTIX6C2KDxaFbVSRZWqagGBKlGh" +
           "vqQCqiqVliKRP0pRaUvvjL/37oZGlfpJvr6eOefcc+4953fPPfd7/vvQhcCH" +
           "Sq5jbnXTCffVNNxfm/X9cOuqwT5F11nRD1QFM8UgmIFn1+THv3D5hz9+ZnVl" +
           "D7ooQPeKtu2EYmg4djBRA8eMVYWGLh8/xU3VCkLoCr0WYxGOQsOEaSMIn6Kh" +
           "V5xgDaGr9KEKMFABBirAhQpw+5gKMN2p2pGF5RyiHQYe9IvQORq66Mq5eiH0" +
           "2GkhruiL1oEYtrAASLgt/80Dowrm1IcePbJ9Z/N1Bn+kBD/7m2+/8nu3QJcF" +
           "6LJhT3N1ZKBECAYRoDss1ZJUP2griqoI0N22qipT1TdE08gKvQXonsDQbTGM" +
           "fPVokvKHkav6xZjHM3eHnNvmR3Lo+EfmaYZqKoe/LmimqANb7zu2dWchkT8H" +
           "Bl4ygGK+JsrqIcv5jWErIfTIWY4jG68OAAFgvdVSw5VzNNR5WwQPoHt2a2eK" +
           "tg5PQ9+wdUB6wYnAKCH04E2F5nPtivJG1NVrIfTAWTp29wpQ3V5MRM4SQq86" +
           "S1ZIAqv04JlVOrE+3x++6YPvtPv2XqGzospmrv9tgOnhM0wTVVN91ZbVHeMd" +
           "T9IfFe/70vv3IAgQv+oM8Y7mD9714lvf+PALX9nR/OwNaEbSWpXDa/KnpLu+" +
           "8WrsidYtuRq3uU5g5It/yvLC/dmDN0+lLoi8+44k5i/3D1++MPnz5bs/o35v" +
           "D7pEQhdlx4ws4Ed3y47lGqbq91Rb9cVQVUjodtVWsOI9Cd0K+rRhq7unI00L" +
           "1JCEzpvFo4tO8RtMkQZE5FN0K+gbtuYc9l0xXBX91IUg6C7wgXAIuvhaqPjb" +
           "fYeQBK8cS4VFWbQN24FZ38ntD2DVDiUwtytYAl6/gQMn8oELwo6vwyLwg5V6" +
           "8ELyDUVX4SDWK1W4q2piZIaLDs2INnAHfz/3Nff/ZZQ0t/VKcu4cWIZXnwUB" +
           "E8RP3zEV1b8mPxt18Bc/d+1re0dBcTBLIdQHA+/vBt4vBt7fDbxfDLx/3cBX" +
           "Z6rlmmDlmGgHajkY5osJnTtXKPLKXLOdL4CV3ABMAAR3PDF9G/WO9z9+C3BC" +
           "NzkPliEnhW8O2tgxipAFVsrAlaEXPpa8h/+l8h60dxp9c2vAo0s5O5tj5hE2" +
           "Xj0bdTeSe/l93/3h5z/6tHMcf6fg/AAWrufMw/rxs/PuO7KqAKA8Fv/ko+IX" +
           "r33p6at70HmAFQAfQxH4M4Ceh8+OcSq8nzqEytyWC8BgzfEt0cxfHeLbpXDl" +
           "O8nxk8Ih7ir6d4M5vpz7++uB48MHAVB852/vdfP2lTsHyhftjBUFFL956n7y" +
           "b/7in5Fiug9R+/KJfXCqhk+dQIpc2OUCE+4+9oGZr6qA7u8/xn74I99/388X" +
           "DgAoXnOjAa/mLQYQAiwhmOZf+Yr3t9/+1qe+uXfsNCHYKiPJNOT0yMjboF2o" +
           "39RIMNrrjvUBSGOCOMy95ipnW45iaIYomWrupf95+bWVL/7rB6/s/MAETw7d" +
           "6I0/XcDx85/pQO/+2tv//eFCzDk53+mO5+yYbAef9x5Lbvu+uM31SN/zlw99" +
           "/MviJwEQA/ALjEwt8OzcQeDkSr0qhO7NIzdB5H3FsfbzLAUgS7GgcEHxZNHu" +
           "55NR8EHFOyRvHglOBsbp2DuRrVyTn/nmD+7kf/DHLxaWnE53TvoBI7pP7Vwv" +
           "bx5Ngfj7z6JAXwxWgK72wvAXrpgv/BhIFIBEGUBfMPIBSKWnvOaA+sKtf/cn" +
           "f3rfO75xC7RHQJdMR1QIsQhA6Hbg+WqwAviWuj/31t3KJ7krXClMha4zfucw" +
           "DxS/zgMFn7g59hB5tnIcvg/8x8iU3vsPP7puEgrUucEmfYZfgJ//xIPYW75X" +
           "8B+Hf879cHo9cIPM7pi3+hnr3/Yev/hne9CtAnRFPkgbedGM8qASQKoUHOaS" +
           "ILU89f502rPb4586grdXn4WeE8OeBZ7jDQP0c+q8f+kM1tyTz/IbQPg9eRCG" +
           "T57FmnNQ0WkXLI8V7dW8ef1haN/u+k4ItFSVg+j+Cfg7Bz7/nX9ycfmD3R5+" +
           "D3aQSDx6lEm4YDe707Bcxw8PoiEXUt5BXN7W8qazk43e1GnelDdEeg4odKG6" +
           "j+4XAgY3VvqWvPsGAEpBkVEDDs2wRbOYGiIEQWDKVw8V5UGGDbzm6tpEDyP4" +
           "SuHw+frs79LSM7oS/2tdgUPfdSyMdkCG+4F/fObrH3rNt4HXUdCFOPcI4Gwn" +
           "RhxGedL/q89/5KFXPPudDxQYC1aB/7XfRX6US+VfyuK8GeUNe2jqg7mp0yKX" +
           "ocUgZApYVJXC2pcMNtY3LLB7xAcZLfz0Pd/efOK7n91lq2cj6wyx+v5nf/0n" +
           "+x98du/EGeE116XpJ3l254RC6TsPZtiHHnupUQoO4p8+//Qf/fbT79tpdc/p" +
           "jBcHB7rP/tV/fX3/Y9/56g0SrPOm839Y2PDObr8WkO3DP7qy1OYJl6ZzbYQ0" +
           "Ja2eDc0kXupdYtyly8OpiBnUepJUmf5GwlKG6wflfn+EyohKtxBxgcxsFB1O" +
           "XN2kOlxiTqa6Eba9skeaLj42xxXRCyycX3CU2RenG9uZVDyCH5U1l6tM9IZn" +
           "8XNLil1biBVEatbt7WxbqStV1IpnWhbbaJzxjebacgMM4SY2J7kubgci3RpN" +
           "0I6Jb+fWUonVNjKkSvLGg4daq1JbIiueCNs+vwlm5c2yHjAePpmh7ZnH9+fS" +
           "0ixbrXV7hUXMMliuhn6fYHhuyDqs5bGCng15ft4QsBWOiwlRCdMKuXRDZcLZ" +
           "LtWZJB3CXuA1Q56wpFUe0rFGcMIwsChGVZcqy44EaSmM69K2JDmbdZPsoH3O" +
           "BUauJgtJcRfBsCOWW22LqbsdpzFpO4la6S5rlBIsEZOy9BJqz7vVmpqVxRqm" +
           "CsZiJjt8E1Zn87Tb2yqDPs03ArgsbhWrX2ZGzsBBrRKpuw3HQq2yl3jjqRSF" +
           "boPvdxuCR9ty1ut65aEyleZW1q7jZY2aklOxKjO1CdOk2W6H9jyRQYVECM10" +
           "XiF4b+5pa3we2RtwjlgjjTrmj23Oi7w12tW3fZLGKH2TDBjLNHp8zE+mBkVg" +
           "UjeoqZQgDoaLxaC5mKL+XCjPWFbXQjmQulSMO3HcUDYDuG005gtL6JnCJJ6N" +
           "2cFIWcx4v9tTOhVdVP1yH2tnyxG2njpyhrtroxv13YXLVCbzgakv68baryLt" +
           "Jp4Q3oLMJj5Bq15lTTBOfzkhV/6caZHOimqobYUU2wk9dsDET8Q+UzHEeYpg" +
           "PYow8U606qUdajxcdLpMRxzUdY2KsFlS9gZtE8lK0azRLCmrbkmvtdY4lQjO" +
           "guytY7gPphJbd0MKmI7LejdR1lwvKxEEmtaGZDLGmSaLtyMRRdBq6iN+ZDTg" +
           "gaXPszKWDZD5eNsdu3Y5qsQ0vgktYUbMwl48t5cDe1gy1GVzWxZlU2pg2NjI" +
           "HMyY0JykpHKEanDmTraNcas5cORJl986IpCJy6Fs9jIQX8uw0ld61GrqTjoV" +
           "vFOmZGkBOsp6NPJmwSzw7ZlI2eMxPw+bXijpcZPAxUm3MxuOyWWFZ3sldJl2" +
           "Z3SacDNSGWNwQ9ccxeMNtkQNy5w7mMcbg5yY/iBqAIZlJ2Q1U++knNWVfGqK" +
           "eZ3STMKG8Xi8Gqzc+YRhJh1zrdMDLuSZzXSbZqyP1qfVTTYbifBkVi1R3Tmp" +
           "JMGADCpBBm+3NcKNYtng2yRCtzdYmxTrTHM0roxI4CZs3dcqCKJXQUSRDLXk" +
           "1i7nVHVcmjQXPU6qp3wvkeuTsL/NpKjKMe1mQGRjZNMR9TSzZsPJgBmzjFNS" +
           "ZswYU/skw7Rx0gpFhvXXWTLsRwN9hckNUkSYDhmVowHXTLrdlRZu4IHZikS3" +
           "zmuLOE17lUWfW1tzMU09f8hHYXeALdnRcqOazGDrCgtWkOqeLvtqfbnCk0Xb" +
           "q5C8LM64XonFlzHDZdqQknuBtK0OXNmaC00tc5qRRU1gpYQ6tQRz5XmXFszu" +
           "vK0s09aKIUp4s17TOSbZhPCCDMfNyBacKsvojsd1oto0Wwtdt9wpM6ZINTYI" +
           "HTBsvdWUJa9voeUOSVWMKU60tw1U7xtzsjJSjVFrZPZXk1GvshyJ1YwKF/g6" +
           "4/3eqqt1l6gxXJeUzpyebgmiPIymTn0kx5rUn3e2Qo2eyNts1A6dRIz7rMha" +
           "Fg+3ULKFyIsRuhIlvrLtMXjo2+1MtnwK6c6pYBHaQTB2upGtMOsFgholl2ix" +
           "PbGzDHimB4uJkKTtLp+QQow2vZqmarHmRdNwRTdrLs8qTcz1NmOzT6nGbOyJ" +
           "g2kwDDw0S9rrldvu1CKQcyhlA29WfHXATcyVAYthpa75NowkARlRbT3dIOuh" +
           "pMydNgLXibBB9RctuNQyagG1FRMAtFK2bc+MDOY2EsoFLGOPuMW6nMmNOCZp" +
           "djwqt2Na4gcyuRqNZpvROuQ6ZT7rKSsGwfg+MWUWgljmqI6JNNrCSB4rMBJU" +
           "mUTbjBetGO8bYahVB1zdbcQJ5w/SRqmJoBkCC0ok45XBKJvA/Xa6CsolvG9H" +
           "wcDp1lZcX686/ZAedhVtYdeYtB82N9Wx1cYoxsMqsRxgC6zKTchKd8GzSCMt" +
           "leJRt92rcA5LtsXhmPHbdd0me157iylVwsDqyz66XUT9OjZZDnCx5g3MUUki" +
           "SUEr2YwUIawljNFl5KIYWspKWiZ4WYLNpsRanhCpWR/rdARnsTiFm0OpryFo" +
           "adqQrclATdw1Pe1oegP2TXqaIiVkBg9mTC2VnGVEBZi2wWqlcGpU6zNkhNbw" +
           "Ya1Uc01CrrZ7W7bVrNGRVCKiaggTuFDBJtOJLdUbdEva0iQ3K+OxKPnMMF5o" +
           "lGqZ2oDy9NgYLGl9g9lzWCKZtE5MFr015Q2thCUrQV0GaEy2zJrdWETdbUfA" +
           "tH4bFir20EaRoDnDF9OOy2wbnWTqkXgwmISEj3NDMaiXUczZVFuB7DFtTpOa" +
           "nX6Mr6QUFXSXDqSpyC5FMAVUTWo3qrxdw5tNVdnACA0PTTaN8AAnF0FdWo7p" +
           "doAO0AUFwh1W4PVmPl8syqWQMGhxEbpoS6aHjfpKg+GNXW71WprV6M+8xTwa" +
           "iZxQ5q0pzrHNUoQRlSwIKQSFYQFlwjB02dZKroANossK6GC+Hs8zG2zDSr2u" +
           "YRoRIcJmXUl6dQQvO+1Q3w7g4WKWhlo43041DB7UNjUfDdbmYlAhZBFdluc6" +
           "F61iT97UTZXjbYbcDr3hzF0FNm2JxHYYSAtr6DNj0esYnWkIMFSRamvXFLY6" +
           "gohLzxjxVjBI/dWMFQO5uzK8me1QgahM65syoqFRlWAX9gpPe8G01O7idTWm" +
           "026D7c8ct0YomkzMOWQ2K7HRyN86ZREPZw08TrtNuKa1mAxZrui1FzKqXGqJ" +
           "25ozp4kxR9MCHM77W1qftWQrRjvDhsquOlWUwgyvv1a4lGOG6kTiSp3SoCdE" +
           "pDVeJLzI+Ss1ZBozKR4MOtqktUHwRY81681WteLBzVHSjUtjYSGl/rBMRG48" +
           "Euu6skXQ9TzEV2J9Lji434maodYl+ouRuhYHYmxIYkaGVqdhij2coPS2y2jd" +
           "GVsWJhSus3JsSzNExZ2NyHY3U0oX4I289DydHA/jqtGoOEiydkg+EXVHd+bj" +
           "7pZRMqTXz9ASn9SCALYaQn0cw5vR3OCIenPr0DSiWEqSwEqVNcqNIdgjuNaw" +
           "OW5qMj+2ab1OUESocoLje4jUB6lymGXzQGFGldkkWyZ1jYhXW7bND5Y+FYpE" +
           "b2WiQt2YwHE1kssxrE0cVIjGlhaOMZzNIq8EUjhjqU71ValEqbhGtLAR11LC" +
           "kuiX69EcoMa22qqNK5K60hcu2Cf5ZlIqKSK97rMzQ06ESXc+NgZauyTE0SZ2" +
           "Y7JWWWKY7yuLUrs+NudBV6Qb8aCmbt1hh1rWxTk+Wbcci642uVRAhqkZIgAc" +
           "nWhSX297GVn2UxavWtJGWfLrUWWsSA1pg9VDqcsOrN68C3I0L7IJNVIrtAo7" +
           "izlRayB8UmnzrujUUkUTwPafcvQaLq0tXqiRapp42GjrTwOxPxuyRBK2wRlv" +
           "XWNqg17GM1zD5i1tOsdhLWkQsFxhrSkrwclinLR8pNxcgFPTm/PjlP7yTrR3" +
           "F4f3owsmcJDNX0xexkkuvUmlI+/ixwXMoj5159lripMFzOPK1VHx79GTxT81" +
           "Vu0w2Mfzr8NyfH6wfehmV07FofZT7332OWX06creQWlQCqGLBzeBJwf0oSdv" +
           "fnpniuu243rVl9/7Lw/O3rJ6x8uo0D9yRsmzIn+Hef6rvdfJv7EH3XJUvbru" +
           "IvA001Ona1aXfDWMQGZ9qnL10Okq+ZNg3hsH89+4cZX85ov5hp3PnCm7ninX" +
           "PnCzFSuY3/0SNdtfzpt3htArVqKtmGrBVBC+7YQHiiF0PnYM5dg13/XTigyn" +
           "yqNAwZvd7BxaAL/MqyLgOg9cdzW9u06VP/fc5dvuf4776+JO5OjK83Yauk2L" +
           "TPNkwfFE/6Lrq5pRzMntu/KjW3w9E0IPvaRuIXSh+C4s+dCO6cMhdP9NmEAg" +
           "7Don6T8aQlfO0gO5xfdJuo+H0KVjOiBq1zlJ8okQugWQ5N1PujcoBu6Ktem5" +
           "E3F4ACbFwt7z0xb2iOXkPUseu8X/ExzGWbT7j4Jr8uefo4bvfLHx6d09j2yK" +
           "WZZLuY2Gbt1dOR3F6mM3lXYo62L/iR/f9YXbX3sIKnftFD6OoBO6PXLjSxXc" +
           "csPiGiT7w/t//02/9dy3itrk/wBw2E0i6CEAAA==");
    }
    protected class DefAttrListener implements org.w3c.dom.events.EventListener {
        protected org.w3c.dom.Element importElement;
        public DefAttrListener(org.w3c.dom.Element imp) {
            super(
              );
            importElement =
              imp;
        }
        public void handleEvent(org.w3c.dom.events.Event evt) {
            org.w3c.dom.events.EventTarget target =
              evt.
              getTarget(
                );
            if (!(target instanceof org.apache.batik.dom.svg12.XBLOMDefinitionElement)) {
                return;
            }
            org.apache.batik.dom.svg12.XBLOMDefinitionElement def =
              (org.apache.batik.dom.svg12.XBLOMDefinitionElement)
                target;
            if (!isActiveDefinition(
                   def,
                   importElement)) {
                return;
            }
            org.w3c.dom.events.MutationEvent mevt =
              (org.w3c.dom.events.MutationEvent)
                evt;
            java.lang.String attrName =
              mevt.
              getAttrName(
                );
            if (attrName.
                  equals(
                    XBL_ELEMENT_ATTRIBUTE)) {
                org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec =
                  (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
                    definitions.
                    get(
                      def,
                      importElement);
                removeDefinition(
                  defRec);
                addDefinition(
                  def.
                    getElementNamespaceURI(
                      ),
                  def.
                    getElementLocalName(
                      ),
                  def,
                  importElement);
            }
            else
                if (attrName.
                      equals(
                        XBL_REF_ATTRIBUTE)) {
                    if (mevt.
                          getNewValue(
                            ).
                          length(
                            ) !=
                          0) {
                        org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec =
                          (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
                            definitions.
                            get(
                              def,
                              importElement);
                        removeDefinition(
                          defRec);
                        addDefinitionRef(
                          def);
                    }
                }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwUxxWfO38bf5zNlwvYgDGkGHobkpCKmpDAYQeT84cw" +
           "Qe254ZjbnbtbvLe77M7ZZ6dOA2oFTSVEKSEkCrSqiGgRCVHVqKnaRFRRm0Rp" +
           "KyWhH2kVUrV/lDZFDaqaVqVt+mZm93Zvzzbln1ry7tzMmzfz3vze773ZC9dQ" +
           "lW2hDqLTKJ00iR3t1ekwtmyixDRs27uhLyk/UYH/uvfq4KYwqk6gpiy2B2Rs" +
           "kz6VaIqdQO2qblOsy8QeJERhM4YtYhNrHFPV0BNooWr350xNlVU6YCiECezB" +
           "Vhy1YEotNZWnpN9RQFF7HHYi8Z1IW4PDPXHUIBvmpCfe5hOP+UaYZM5by6Yo" +
           "Et+Px7GUp6omxVWb9hQstM40tMmMZtAoKdDofm2j44Kd8Y1lLuh8vvnDG8ey" +
           "Ee6C+VjXDcrNs3cR29DGiRJHzV5vr0Zy9gH0CKqIo3k+YYq64u6iEiwqwaKu" +
           "tZ4U7L6R6PlczODmUFdTtSmzDVG0slSJiS2cc9QM8z2Dhlrq2M4ng7UritYK" +
           "K8tMfHyddOKJvZFvV6DmBGpW9RG2HRk2QWGRBDiU5FLEsrcqClESqEWHwx4h" +
           "loo1dco56VZbzeiY5uH4XbewzrxJLL6m5ys4R7DNysvUsIrmpTmgnF9VaQ1n" +
           "wNZFnq3Cwj7WDwbWq7AxK40Bd86UyjFVVyhaHpxRtLHrARCAqTU5QrNGcalK" +
           "HUMHahUQ0bCekUYAenoGRKsMAKBF0ZJZlTJfm1gewxmSZIgMyA2LIZCq445g" +
           "UyhaGBTjmuCUlgROyXc+1wY3H31Y36GHUQj2rBBZY/ufB5M6ApN2kTSxCMSB" +
           "mNjQHT+JF710JIwQCC8MCAuZ737u+n3rOy69JmSWziAzlNpPZJqUz6aa3lwW" +
           "W7upgm2j1jRslR1+ieU8yoadkZ6CCQyzqKiRDUbdwUu7fvyZR8+T98Oovh9V" +
           "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" +
           "OdjPr3N1X+NN9vjGfwEt5aAnPRcAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1ae8wjV3Wf/bK7SZYku0kgSVPyZKEkRt/YM/bYVoBij+3x" +
           "Y8aeGXvGnqGwzNtjz8vz8DwgLaC20CJBVAIFCfIXqC0Kj1ZFrVRRpapaQKBK" +
           "VKgvqYCqSqWlSOSPUlTa0jvj7727oVGlfpKvr2fOOfece8/53XPP/Z7/PnQh" +
           "8KGS51qpYbnhvpaE+yurth+mnhbsD8kaLfmBpuKWFAQz8Oya8vgXLv/wx88s" +
           "r+xBF0XoXslx3FAKTdcJWC1wra2mktDl46ddS7ODELpCrqStBEehacGkGYRP" +
           "kdArTrCG0FXyUAUYqAADFeBCBbh1TAWY7tScyMZzDskJgw30i9A5ErroKbl6" +
           "IfTYaSGe5Ev2gRi6sABIuC3/zQOjCubEhx49sn1n83UGf6QEP/ubb7/ye7dA" +
           "l0XosulMc3UUoEQIBhGhO2zNljU/aKmqporQ3Y6mqVPNNyXLzAq9ReiewDQc" +
           "KYx87WiS8oeRp/nFmMczd4eS2+ZHSuj6R+bppmaph78u6JZkAFvvO7Z1Z2Ev" +
           "fw4MvGQCxXxdUrRDlvNr01FD6JGzHEc2Xh0BAsB6q62FS/doqPOOBB5A9+zW" +
           "zpIcA56GvukYgPSCG4FRQujBmwrN59qTlLVkaNdC6IGzdPTuFaC6vZiInCWE" +
           "XnWWrJAEVunBM6t0Yn2+P37jB9/p9J29QmdVU6xc/9sA08NnmFhN13zNUbQd" +
           "4x1Pkh+V7vvS+/cgCBC/6gzxjuYP3vXiW97w8Atf2dH87A1oJvJKU8Jryqfk" +
           "u77xavyJ5i25Grd5bmDmi3/K8sL96YM3TyUeiLz7jiTmL/cPX77A/rnw7s9o" +
           "39uDLg2gi4prRTbwo7sV1/ZMS/MJzdF8KdTUAXS75qh48X4A3Qr6pOlou6cT" +
           "XQ+0cACdt4pHF93iN5giHYjIp+hW0Dcd3T3se1K4LPqJB0HQXeADvRGCLg6h" +
           "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" +
           "XdsLi5uP7A/v//03/tZz3yrKkf8DtpeHetIhAAA=");
    }
    protected class DefNodeInsertedListener implements org.w3c.dom.events.EventListener {
        protected org.w3c.dom.Element importElement;
        public DefNodeInsertedListener(org.w3c.dom.Element imp) {
            super(
              );
            importElement =
              imp;
        }
        public void handleEvent(org.w3c.dom.events.Event evt) {
            org.w3c.dom.events.MutationEvent mevt =
              (org.w3c.dom.events.MutationEvent)
                evt;
            org.w3c.dom.Node parent =
              mevt.
              getRelatedNode(
                );
            if (!(parent instanceof org.apache.batik.dom.svg12.XBLOMDefinitionElement)) {
                return;
            }
            org.w3c.dom.events.EventTarget target =
              evt.
              getTarget(
                );
            if (!(target instanceof org.apache.batik.dom.svg12.XBLOMTemplateElement)) {
                return;
            }
            org.apache.batik.dom.svg12.XBLOMTemplateElement template =
              (org.apache.batik.dom.svg12.XBLOMTemplateElement)
                target;
            org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec =
              (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
                definitions.
                get(
                  parent,
                  importElement);
            if (defRec ==
                  null) {
                return;
            }
            org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord ir =
              (org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord)
                imports.
                get(
                  importElement);
            if (defRec.
                  template !=
                  null) {
                for (org.w3c.dom.Node n =
                       parent.
                       getFirstChild(
                         );
                     n !=
                       null;
                     n =
                       n.
                         getNextSibling(
                           )) {
                    if (n ==
                          template) {
                        removeTemplateElementListeners(
                          defRec.
                            template,
                          ir);
                        defRec.
                          template =
                          template;
                        break;
                    }
                    else
                        if (n ==
                              defRec.
                                template) {
                            return;
                        }
                }
            }
            else {
                defRec.
                  template =
                  template;
            }
            addTemplateElementListeners(
              template,
              ir);
            rebind(
              defRec.
                namespaceURI,
              defRec.
                localName,
              document.
                getDocumentElement(
                  ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwUxxWfO38bf5zNlwvYgDGkGHobkpCKmtBgY4PJ2ViY" +
           "oPZoOOZ25+4W7+0uu3P22amTgKggqYQoJYRWgVYVES0iIaqafqhNRBW1SZS2" +
           "UhL6kVYhVftHaVPUoKppVdqmb2Z2b/f2fKb8U0venZt582bem9/7vTd78Tqq" +
           "si3UQXQapZMmsaP9Oh3Blk2UPg3b9i7oS8hPVeC/7r02vCGMquOoKYPtIRnb" +
           "ZEAlmmLHUbuq2xTrMrGHCVHYjBGL2MQax1Q19Diar9qDWVNTZZUOGQphArux" +
           "FUMtmFJLTeYoGXQUUNQeg51IfCfS5uBwTww1yIY56Ym3+cT7fCNMMuutZVMU" +
           "ie3H41jKUVWTYqpNe/IWWmMa2mRaM2iU5Gl0v7beccH22PoSF3Q+3/zBzeOZ" +
           "CHfBXKzrBuXm2TuJbWjjRImhZq+3XyNZ+wB6BFXE0ByfMEVdMXdRCRaVYFHX" +
           "Wk8Kdt9I9Fy2z+DmUFdTtSmzDVG0vFiJiS2cddSM8D2Dhlrq2M4ng7XLCtYK" +
           "K0tMfHKNdPKpvZFvVqDmOGpW9VG2HRk2QWGRODiUZJPEsjcrClHiqEWHwx4l" +
           "loo1dco56VZbTeuY5uD4XbewzpxJLL6m5ys4R7DNysnUsArmpTignF9VKQ2n" +
           "wdYFnq3CwgHWDwbWq7AxK4UBd86UyjFVVyhaGpxRsLHrARCAqTVZQjNGYalK" +
           "HUMHahUQ0bCelkYBenoaRKsMAKBF0aKySpmvTSyP4TRJMEQG5EbEEEjVcUew" +
           "KRTND4pxTXBKiwKn5Duf68Mbjz2sb9PDKAR7Voissf3PgUkdgUk7SYpYBOJA" +
           "TGzojp3CC148GkYIhOcHhIXMdz574/61HZdfFTKLZ5DZkdxPZJqQzyWb3ljS" +
           "t3pDBdtGrWnYKjv8Ist5lI04Iz15ExhmQUEjG4y6g5d3/vjTj10g74VR/SCq" +
           "lg0tlwUctchG1lQ1Ym0lOrEwJcogqiO60sfHB1ENtGOqTkTvjlTKJnQQVWq8" +
           "q9rgv8FFKVDBXFQPbVVPGW7bxDTD23kTIdQE/2gLQtWPIv4n3hQlpYyRJRKW" +
           "sa7qhjRiGcx+WwLGSYJvM1ISUD8m2UbOAghKhpWWMOAgQ5yBpKUqaSLZ4+l1" +
           "d0lbSArnNPqp3tgQ1gEOVpRhzfy/rJJnts6dCIXgGJYESUCD+NlmaAqxEvLJ" +
           "XG//jecSrwuAsaBwvETRVlg4KhaO8oWjYuEoXzhasnAX9AwDAQMhQ/RAxAPl" +
           "srNEoRDfxzy2MQEFOMgxIdCwevSh7fuOdlYABs2JSjgFJtpZlJv6PN5wyT4h" +
           "X2ptnFp+dd3LYVQZQ61YpjmssVSz2UoDicljTpw3JCFrecljmS95sKxnGTJR" +
           "gLvKJRFHS60xTizWT9E8nwY3tbEglsonlhn3jy6fnji4+9E7wyhcnC/YklVA" +
           "dWz6CGP5Apt3BXliJr3NR659cOnUtOExRlECcvNmyUxmQ2cQKUH3JOTuZfiF" +
           "xIvTXdztdcDoFEMEAll2BNcoIqQel9yZLbVgcMqwslhjQ66P62nGMia8Hg7h" +
           "Ft6eB7BoZhG6CkL1cSdk+ZuNLjDZc6GAPMNZwAqePO4bNc/86md/vJu7280z" +
           "zb4CYZTQHh+3MWWtnMVaPNjusggBuXdOj3zxyetH9nDMgsSKmRbsYs8+4DQ4" +
           "QnDz51498Pa7V89dCXs4p5Dcc0mokfIFI2uRIKeyRsJqq7z9ADdqwBwMNV0P" +
           "6oBPNaXipEZYYP2reeW6F/58LCJwoEGPC6O1t1bg9X+kFz32+t6/d3A1IZnl" +
           "Zs9nnpgg/Lme5s2WhSfZPvIH32z/0iv4DKQOoGtbnSKcgUNOrLNNtVE0l3HN" +
           "xN1yVDGyUVZJQZDxA13PJe7kz3uYM/g8xMc2sMdK2x8YxbHnq68S8vEr7zfu" +
           "fv+lG9yS4gLNj4MhbPYI6LHHqjyoXxgkrm3YzoDcPZeHPxPRLt8EjXHQKANZ" +
           "2zssoNV8EWoc6aqaX//w5QX73qhA4QFUrxlYGcA8AFEdIJ/YGWDkvPnJ+8XJ" +
           "TzAoRLipqMT4kg7m/KUzH2t/1qT8IKa+u/BbG8+fvcoRaAodiwuMu6SIcXmZ" +
           "7wX9hbc+/vPzXzg1IQqF1eWZLjCv7Z87tOSh3/2jxOWc42YoYgLz49LFpxf1" +
           "bXqPz/fIhs3uypcmNiBsb+5dF7J/C3dW/yiMauIoIjtl9W6s5VgIx6GUtN1a" +
           "G0rvovHislDUQD0FMl0SJDrfskGa8xIqtJk0azcGmK2VHeFHIdgPO0F/OMhs" +
           "IcQbD/Apd/BnN3t8zCWSOtMyKOySKAEuaZlFLUWNatY0LOrEG+u8V5Aoe36C" +
           "PWJC330zwVIM3cEew4VVOR4bg5WVn8H8uHOif5k/+sk47AVQyF5uCcGisL1c" +
           "lcwr/HOHTp5VdjyzTkC0tbjy7IeL1bO/+PdPoqd/+9oMhU61c8spjoj2oogY" +
           "4rcHD17vNJ34/fe60r23U36wvo5bFBjs91KwoLt8kAW38sqhPy3atSmz7zYq" +
           "iaUBXwZVfmPo4mtbV8knwvyqJHBfcsUqntRTjPZ6i8CdUN9VhPkVxdm8G+Bx" +
           "3IHJ8ZmzeQFha0pzZLmpgYwRyDRt5bDGV0zPkm74mSYpmpPBuqIRPsmelQ5H" +
           "LDUL1cS4cyeTplvfHXv62rMCo0HuCwiToyef+DB67KTAq7jlrii5aPrniJsu" +
           "32pEeOtD+AvB/3/YP7ODdYibTmufc91aVrhvsaRgoeWzbYsvMfCHS9Pf//r0" +
           "kbDjlzhFleOGqnisIc/CGv9DMmMdfWaeooVlbhTuWUq3eUMB89pKvoiIW7z8" +
           "3Nnm2oVnH/wlD+jCTbsBQjOV0zQ/j/va1aZFUir3QoNgdZO/HqGofda9UVTF" +
           "39ySaTHpIBhcZhJwlGj45Q9TFAnKg17+9ssdoajekwNVouEXeYKiChBhzc+b" +
           "rncjvKBgOTAqcmA+5KNI5+D4ec+/1XkXpviLZRYu/DOWS0I58SEL7nZntw8/" +
           "fOPeZ0SxLmt4aop/9oihGnFvKBDZ8rLaXF3V21bfbHq+bqWL1haxYY9eFvtC" +
           "vA+IwmTF1KJAJWt3FQrat89tfOmnR6vfhMDcg0IYatc9pdVC3sxBBtkT83KI" +
           "7zMoL7F7Vn95ctPa1F9+w+ux0iosKJ+Qr5x/6K0TbeegFJ8ziKogEEmelzFb" +
           "JvWdRB634pDP7f48jxGqYm0Q1eZ09UCODCox1MQQjdkHLu4Xx52NhV521aOo" +
           "s5RgSi/IULtOEKvXyOkKp3ZIOl5P0fc1NxfkTDMwwespHOW8UtsT8pbHm39w" +
           "vLViAKKyyBy/+ho7lyzkGf8nNy/xRNjjQF5QX0UiNmSaLhWGvm0KxJ8RMqyf" +
           "olC30+vLIOznV7m6r/Ame3ztv5NhwcVNFwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected class DefNodeRemovedListener implements org.w3c.dom.events.EventListener {
        protected org.w3c.dom.Element importElement;
        public DefNodeRemovedListener(org.w3c.dom.Element imp) {
            super(
              );
            importElement =
              imp;
        }
        public void handleEvent(org.w3c.dom.events.Event evt) {
            org.w3c.dom.events.MutationEvent mevt =
              (org.w3c.dom.events.MutationEvent)
                evt;
            org.w3c.dom.Node parent =
              mevt.
              getRelatedNode(
                );
            if (!(parent instanceof org.apache.batik.dom.svg12.XBLOMDefinitionElement)) {
                return;
            }
            org.w3c.dom.events.EventTarget target =
              evt.
              getTarget(
                );
            if (!(target instanceof org.apache.batik.dom.svg12.XBLOMTemplateElement)) {
                return;
            }
            org.apache.batik.dom.svg12.XBLOMTemplateElement template =
              (org.apache.batik.dom.svg12.XBLOMTemplateElement)
                target;
            org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord defRec =
              (org.apache.batik.bridge.svg12.DefaultXBLManager.DefinitionRecord)
                definitions.
                get(
                  parent,
                  importElement);
            if (defRec ==
                  null ||
                  defRec.
                    template !=
                  template) {
                return;
            }
            org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord ir =
              (org.apache.batik.bridge.svg12.DefaultXBLManager.ImportRecord)
                imports.
                get(
                  importElement);
            removeTemplateElementListeners(
              template,
              ir);
            defRec.
              template =
              null;
            for (org.w3c.dom.Node n =
                   template.
                   getNextSibling(
                     );
                 n !=
                   null;
                 n =
                   n.
                     getNextSibling(
                       )) {
                if (n instanceof org.apache.batik.dom.svg12.XBLOMTemplateElement) {
                    defRec.
                      template =
                      (org.apache.batik.dom.svg12.XBLOMTemplateElement)
                        n;
                    break;
                }
            }
            addTemplateElementListeners(
              defRec.
                template,
              ir);
            rebind(
              defRec.
                namespaceURI,
              defRec.
                localName,
              document.
                getDocumentElement(
                  ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "oW6n15dA2M9vcHVf5032+OZ/AT1W5btLFwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected class ImportAttrListener implements org.w3c.dom.events.EventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            org.w3c.dom.events.EventTarget target =
              evt.
              getTarget(
                );
            if (target !=
                  evt.
                  getCurrentTarget(
                    )) {
                return;
            }
            org.w3c.dom.events.MutationEvent mevt =
              (org.w3c.dom.events.MutationEvent)
                evt;
            if (mevt.
                  getAttrName(
                    ).
                  equals(
                    XBL_BINDINGS_ATTRIBUTE)) {
                org.w3c.dom.Element imp =
                  (org.w3c.dom.Element)
                    target;
                removeImport(
                  imp);
                addImport(
                  imp);
            }
        }
        public ImportAttrListener() { super(
                                        );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/wIK7aKL9xQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/x++/nee/XZRmPtfSxTCYvwfAAA=");
    }
    protected class RefAttrListener implements org.w3c.dom.events.EventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            org.w3c.dom.events.EventTarget target =
              evt.
              getTarget(
                );
            if (target !=
                  evt.
                  getCurrentTarget(
                    )) {
                return;
            }
            org.w3c.dom.events.MutationEvent mevt =
              (org.w3c.dom.events.MutationEvent)
                evt;
            if (mevt.
                  getAttrName(
                    ).
                  equals(
                    XBL_REF_ATTRIBUTE)) {
                org.w3c.dom.Element defRef =
                  (org.w3c.dom.Element)
                    target;
                removeDefinitionRef(
                  defRef);
                if (mevt.
                      getNewValue(
                        ).
                      length(
                        ) ==
                      0) {
                    org.apache.batik.dom.svg12.XBLOMDefinitionElement def =
                      (org.apache.batik.dom.svg12.XBLOMDefinitionElement)
                        defRef;
                    java.lang.String ns =
                      def.
                      getElementNamespaceURI(
                        );
                    java.lang.String ln =
                      def.
                      getElementLocalName(
                        );
                    addDefinition(
                      ns,
                      ln,
                      (org.apache.batik.dom.svg12.XBLOMDefinitionElement)
                        defRef,
                      null);
                }
                else {
                    addDefinitionRef(
                      defRef);
                }
            }
        }
        public RefAttrListener() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ZuofAAA=");
    }
    protected class XBLRecord {
        public org.w3c.dom.Node node;
        public org.apache.batik.bridge.svg12.DefaultXBLManager.XblChildNodes
          childNodes;
        public org.apache.batik.bridge.svg12.DefaultXBLManager.XblScopedChildNodes
          scopedChildNodes;
        public org.apache.batik.dom.svg12.XBLOMContentElement
          contentElement;
        public org.apache.batik.dom.svg12.XBLOMDefinitionElement
          definitionElement;
        public org.apache.batik.dom.svg12.BindableElement
          boundElement;
        public boolean linksValid;
        public org.w3c.dom.Node nextSibling;
        public org.w3c.dom.Node previousSibling;
        public XBLRecord() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "gs5jy2wwV/FFzn2ZT9lw5b8WGSNdmBsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/SjdXtFu/vCB33/Tbz//7e1B1P8AAJsZ2IEmAAA=");
    }
    protected class XblChildNodes implements org.w3c.dom.NodeList {
        protected org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord
          record;
        protected java.util.List nodes;
        protected int size;
        public XblChildNodes(org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec) {
            super(
              );
            record =
              rec;
            nodes =
              new java.util.ArrayList(
                );
            size =
              -1;
        }
        protected void update() { size = 0;
                                  org.w3c.dom.Node shadowTree =
                                    getXblShadowTree(
                                      record.
                                        node);
                                  org.w3c.dom.Node last =
                                    null;
                                  org.w3c.dom.Node m =
                                    shadowTree ==
                                    null
                                    ? record.
                                        node.
                                    getFirstChild(
                                      )
                                    : shadowTree.
                                    getFirstChild(
                                      );
                                  while (m !=
                                           null) {
                                      last =
                                        collectXblChildNodes(
                                          m,
                                          last);
                                      m =
                                        m.
                                          getNextSibling(
                                            );
                                  }
                                  if (last !=
                                        null) {
                                      org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec =
                                        getRecord(
                                          last);
                                      rec.
                                        nextSibling =
                                        null;
                                      rec.
                                        linksValid =
                                        true;
                                  } }
        protected org.w3c.dom.Node collectXblChildNodes(org.w3c.dom.Node n,
                                                        org.w3c.dom.Node prev) {
            boolean isChild =
              false;
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                if (!XBL_NAMESPACE_URI.
                      equals(
                        n.
                          getNamespaceURI(
                            ))) {
                    isChild =
                      true;
                }
                else
                    if (n instanceof org.apache.batik.dom.svg12.XBLOMContentElement) {
                        org.apache.batik.bridge.svg12.ContentManager cm =
                          getContentManager(
                            n);
                        if (cm !=
                              null) {
                            org.w3c.dom.NodeList selected =
                              cm.
                              getSelectedContent(
                                (org.apache.batik.dom.svg12.XBLOMContentElement)
                                  n);
                            for (int i =
                                   0;
                                 i <
                                   selected.
                                   getLength(
                                     );
                                 i++) {
                                prev =
                                  collectXblChildNodes(
                                    selected.
                                      item(
                                        i),
                                    prev);
                            }
                        }
                    }
            }
            else {
                isChild =
                  true;
            }
            if (isChild) {
                nodes.
                  add(
                    n);
                size++;
                if (prev !=
                      null) {
                    org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec =
                      getRecord(
                        prev);
                    rec.
                      nextSibling =
                      n;
                    rec.
                      linksValid =
                      true;
                }
                org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec =
                  getRecord(
                    n);
                rec.
                  previousSibling =
                  prev;
                rec.
                  linksValid =
                  true;
                prev =
                  n;
            }
            return prev;
        }
        public void invalidate() { for (int i =
                                          0;
                                        i <
                                          size;
                                        i++) {
                                       org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec =
                                         getRecord(
                                           (org.w3c.dom.Node)
                                             nodes.
                                             get(
                                               i));
                                       rec.
                                         previousSibling =
                                         null;
                                       rec.
                                         nextSibling =
                                         null;
                                       rec.
                                         linksValid =
                                         false;
                                   }
                                   nodes.
                                     clear(
                                       );
                                   size =
                                     -1; }
        public org.w3c.dom.Node getFirstNode() {
            if (size ==
                  -1) {
                update(
                  );
            }
            return size ==
              0
              ? null
              : (org.w3c.dom.Node)
                  nodes.
                  get(
                    0);
        }
        public org.w3c.dom.Node getLastNode() {
            if (size ==
                  -1) {
                update(
                  );
            }
            return size ==
              0
              ? null
              : (org.w3c.dom.Node)
                  nodes.
                  get(
                    nodes.
                      size(
                        ) -
                      1);
        }
        public org.w3c.dom.Node item(int index) {
            if (size ==
                  -1) {
                update(
                  );
            }
            if (index <
                  0 ||
                  index >=
                  size) {
                return null;
            }
            return (org.w3c.dom.Node)
                     nodes.
                     get(
                       index);
        }
        public int getLength() { if (size ==
                                       -1) {
                                     update(
                                       );
                                 }
                                 return size;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "1vxfTxItCukhAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "xhyfyV61X00tui/O2j29Z04bWl9FcbzfDiqkPnL70z6Ygpu4v5qiuNXmhrW6" +
           "j7UnWndhYdk479UYtdIwFNGrT/IIddaVZrPncLUmmO+iHGmt9bkj73YwD5sO" +
           "nTeZmZ/ZTpJbU9yKfWdlWrs52lkkmCm19ExKm/rOScKlbKAjWUe1QdjsjzzW" +
           "4Po53e/6a29szZ1dTk0oYqM7PMksOnXMr/VX6SZdcEyMS8hWSVYLMa2vXLOx" +
           "I8ak5wGGTHWfGKJzdLOhiDkauUYvHOK9GBNa88GmYhKIvV3jntMOp1mtibR8" +
           "lbFyiYvrecxixISlJjoumkZOI4bJJHUVi2R9MANrlxzOWHzRqK+nUphja6Vf" +
           "63jAhVsdy2q4OOqkdWaCb8JZLBKbzA3srd5aSOmWGCXNvtpcKsKYqE2dUWwB" +
           "a1OXxKCnD8WQ2xSO0lPX4lTldkG359RQNatV0XbMzm0EbckpDC9Hs/oWCfq5" +
           "xOTTOKNGHZZubOFqvYIaXUF20uFu1lz2e+JkADuphi8HSI2A+bHWqzcXlcWo" +
           "U7OGKGKrrKT2KYsUa2wiTZVNvs10p1lr7YZNo90QRGLeIhcxlwZS3VzW2aqx" +
           "leprIdlpftZrDCRl67qTasrCk4bazrxQEDkwOdUYTEeHI03sYM1gZpMNX+0j" +
           "nKM3Z5loMWs+mdlqF5ZMtj7AeILqUOG0Gzc1pR6zE3TG9WqRhkZN13Z6vaQz" +
           "X2VdVlNWG3fa6S9wAmtL9pqlA7rG9TGtRvbzqd0T68ympq2bI7SOUz02CQxZ" +
           "pTXV2BoyMmQWk0HDnlNhU7HcLb7h+3Dc5biVGJh0J9n2M9QfTcLVZMQy/DIf" +
           "OoifbyRzvW5IerqRKH+5c/mdI46p9TRfr9etZkQ2EczyOoKrUfzMJmJ2NsWa" +
           "GevEKy/tVMIqnAoy3K3mJtsZJmSb0xocQwlwi6/gu101GGnwZiqYYynAAaEM" +
           "+b5NS30h3GaDegds2XK57vH0urNu4YN02KAzMw9ps6ZvKN33h7WF1tgZvQrP" +
           "Cv5qgXJ6m8RVpWXssm0lwVXf2vVE1E6SaC6LvYnbGdLDJZHNxAa/9DQREZRB" +
           "I7F3Gs03Kg01ZTu0O9lQywQZe4afYdv6wFzym85c60a+kiSb7Qivg50Y6tTX" +
           "elXcVdtILHlduit5ar4GlBjLc82ujJqz4RBBBh7v6QAc2a9U6s2YmbVzeLeu" +
           "avYwHcmZ4eOYYXALHo4jneWT+pQOSUzoeDNiZ3bVtJGgCpeGfG/aExTE1g15" +
           "aQttaiVOzJ5Y6/dt1NIRLKVaqZaYrgHzalvoJdZGVOuZYimIZISpyPDAiIUO" +
           "EWXCvMHPtrt6M7VjaTyW0DbOO1KF3AkduL3sVGptOBotc18lYF1CiW2NUqoG" +
           "kYywNVxHNpk5zQYJma4sgiDeVxwj/MBrO954sDzJObmFd1y8yAhewwlGdtsz" +
           "u5MzwPKk/v6Ld7lnL3xOz/BPLkveUlyWbFHtUA+8w+K+srxniSPo8VvdxZcn" +
           "a5/60HMv6NxPIMcnoFoCXTl6InHayF1AzHtufYTIlu8QTk/rf+tDf/zY9Hus" +
           "D7yGW8wnL3TyosifZl/8fO87tH9+AN1xcnZ/wwuJ85WePn9if29kJGnkT8+d" +
           "2z9+/tz1SQD1g0c6/+DFc9fTcb7toettLp0+fpu8f1UEPwqUn4a6khg3PS/b" +
           "BLZ+amjPvdpR2dkmyoSPnaB9pEisAJTPH6F9/o1Be1AWODg527xok0X6T5U1" +
           "f/I2uvjZIvjXwKS1/VXiuVv4UsSpFn78dWihvD1+CqB/6UgLL71WLXzXq475" +
           "Z2+T94tF8JmkeAO0UVy7GPci5ROn6H7hdaB7yzG6Lxyh+8Ibj+7Xb5P3G0Xw" +
           "qwl039JIKDuKkxMDOMX30uvFV3jsl4/wffmNx/fvb5P3H4vgcwn0JoCvOO6+" +
           "CbzPv154jwJYrxzBe+WNgXfptMD+Tc3v3Abjfy+CLwHqsRPDuwDuy68D3JuL" +
           "xOLdxlePwH31jR+7379N3h8UwVcS6J5i7Ax/uX9JpZyC+5+vBVyWQPef46hj" +
           "/oNf4wMGMM0+esP7xv2bPO3nX7h69yMvzP5L+cbm5N3cPQx0t5m67tmr6TPx" +
           "K2FkmHYJ+Z79RXVY/nw9gR6/bd8S6HL5WyL5032lP0ugR25RCcxb+8jZ8t88" +
           "mgDOlgdyy9+z5f4KMOBpOSBqHzlb5K8T6A5QpIj+TXiTm7P9tX526cya5cjm" +
           "ytF86NVG86TK2Xc7xTqnfJR6vCZJ+aP76U+/QI++/xuNn9i/G9JcZbcrpNzN" +
           "QHftnzCdrGvefktpx7Ku9N/9rQc+c8+7jhdgD+w7fGr/Z/r25M0f6XS9MCmf" +
           "1ex+6ZF/+96ffOF3y4u8/wfOKB2KLSwAAA==");
    }
    protected class XblScopedChildNodes extends org.apache.batik.bridge.svg12.DefaultXBLManager.XblChildNodes {
        public XblScopedChildNodes(org.apache.batik.bridge.svg12.DefaultXBLManager.XBLRecord rec) {
            super(
              rec);
        }
        protected void update() { size = 0;
                                  org.w3c.dom.Node shadowTree =
                                    getXblShadowTree(
                                      record.
                                        node);
                                  org.w3c.dom.Node n =
                                    shadowTree ==
                                    null
                                    ? record.
                                        node.
                                    getFirstChild(
                                      )
                                    : shadowTree.
                                    getFirstChild(
                                      );
                                  while (n !=
                                           null) {
                                      collectXblScopedChildNodes(
                                        n);
                                      n =
                                        n.
                                          getNextSibling(
                                            );
                                  } }
        protected void collectXblScopedChildNodes(org.w3c.dom.Node n) {
            boolean isChild =
              false;
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                if (!n.
                      getNamespaceURI(
                        ).
                      equals(
                        XBL_NAMESPACE_URI)) {
                    isChild =
                      true;
                }
                else
                    if (n instanceof org.apache.batik.dom.svg12.XBLOMContentElement) {
                        org.apache.batik.bridge.svg12.ContentManager cm =
                          getContentManager(
                            n);
                        if (cm !=
                              null) {
                            org.w3c.dom.NodeList selected =
                              cm.
                              getSelectedContent(
                                (org.apache.batik.dom.svg12.XBLOMContentElement)
                                  n);
                            for (int i =
                                   0;
                                 i <
                                   selected.
                                   getLength(
                                     );
                                 i++) {
                                collectXblScopedChildNodes(
                                  selected.
                                    item(
                                      i));
                            }
                        }
                    }
            }
            else {
                isChild =
                  true;
            }
            if (isChild) {
                nodes.
                  add(
                    n);
                size++;
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwUxxWfO38bf/NZPgwYQwWht6EJlaghDT7sYHI2FiaI" +
           "moZjbnfubvHe7jI7a59NaBKkCKd/IERJQptg9Q+itFUSoqpRW7VEVJGaRGkr" +
           "JUVt0yqkUv8o/UANqpT8Qdr0zczu7d6ebURU1ZJn92bevDfv6/fe7Is3UI1D" +
           "UScxWYJN2sRJ9JlsGFOHaEkDO85+mEurz1Thfx2+PrQtjmpHUUseO4Mqdki/" +
           "TgzNGUWrdNNh2FSJM0SIxncMU+IQOo6ZbpmjaLHuDBRsQ1d1NmhphBMcwDSF" +
           "2jFjVM+4jAx4DBhalYKTKOIkys7ock8KNamWPRmQLwuRJ0MrnLIQyHIYaksd" +
           "xeNYcZluKCndYT1Fiu6yLWMyZ1gsQYoscdTY6plgT2prhQm6Xmn96NaZfJsw" +
           "wUJsmhYT6jn7iGMZ40RLodZgts8gBecY+jqqSqEFIWKGulO+UAWEKiDU1zag" +
           "gtM3E9MtJC2hDvM51doqPxBDa8uZ2JjigsdmWJwZONQzT3exGbRdU9JWalmh" +
           "4lN3KeeeOdz2gyrUOopadXOEH0eFQzAQMgoGJYUMoc5OTSPaKGo3wdkjhOrY" +
           "0Kc8T3c4es7EzAX3+2bhk65NqJAZ2Ar8CLpRV2UWLamXFQHl/arJGjgHui4J" +
           "dJUa9vN5ULBRh4PRLIa487ZUj+mmxtDq6I6Sjt0PAgFsrSsQlrdKoqpNDBOo" +
           "Q4aIgc2cMgKhZ+aAtMaCAKQMLZ+TKbe1jdUxnCNpHpERumG5BFQNwhB8C0OL" +
           "o2SCE3hpecRLIf/cGNp++ri524yjGJxZI6rBz78ANnVGNu0jWUIJ5IHc2LQp" +
           "9TRecnk6jhAQL44QS5ofPXLz/s2dV96UNCtmodmbOUpUllYvZlreWZncuK2K" +
           "H6PethydO79Mc5Flw95KT9EGhFlS4sgXE/7ilX2/+Opj3yd/j6PGAVSrWoZb" +
           "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" +
           "3mwIavnPGcHugnjlw3f+CxTYjHZeFgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/wbc+8y4liEAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "b/YTfx35P44rYBDRYQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "CdPwqaCJqRO6wFBVjObDIFwUl2ZJb4s+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "kl974N+86mef+Uy2h+//A8Omec7rcAAA");
}
