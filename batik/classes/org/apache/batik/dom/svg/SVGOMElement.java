package org.apache.batik.dom.svg;
public abstract class SVGOMElement extends org.apache.batik.dom.svg.AbstractElement implements org.w3c.dom.svg.SVGElement, org.apache.batik.dom.svg.ExtendedTraitAccess, org.apache.batik.dom.anim.AnimationTarget {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               );
             t.put(null, SVG_ID_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(XML_NAMESPACE_URI, XML_BASE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_URI));
             t.put(XML_NAMESPACE_URI, XML_SPACE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(XML_NAMESPACE_URI, XML_ID_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_CDATA));
             t.put(XML_NAMESPACE_URI, XML_LANG_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     false,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LANG));
             xmlTraitInformation = t; }
    protected transient boolean readonly;
    protected java.lang.String prefix;
    protected transient org.apache.batik.dom.svg.SVGContext
      svgContext;
    protected org.apache.batik.util.DoublyIndexedTable
      targetListeners;
    protected org.apache.batik.parser.UnitProcessor.Context
      unitContext;
    protected SVGOMElement() { super(); }
    protected SVGOMElement(java.lang.String prefix,
                           org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
    }
    protected void initializeAllLiveAttributes() {
        
    }
    public java.lang.String getId() { if (((org.apache.batik.dom.svg.SVGOMDocument)
                                             ownerDocument).
                                            isSVG12) {
                                          org.w3c.dom.Attr a =
                                            getAttributeNodeNS(
                                              XML_NAMESPACE_URI,
                                              SVG_ID_ATTRIBUTE);
                                          if (a !=
                                                null) {
                                              return a.
                                                getNodeValue(
                                                  );
                                          }
                                      }
                                      return getAttributeNS(
                                               null,
                                               SVG_ID_ATTRIBUTE);
    }
    public void setId(java.lang.String id) {
        if (((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              isSVG12) {
            setAttributeNS(
              XML_NAMESPACE_URI,
              SVG_ID_ATTRIBUTE,
              id);
            org.w3c.dom.Attr a =
              getAttributeNodeNS(
                null,
                SVG_ID_ATTRIBUTE);
            if (a !=
                  null) {
                a.
                  setNodeValue(
                    id);
            }
        }
        else {
            setAttributeNS(
              null,
              SVG_ID_ATTRIBUTE,
              id);
        }
    }
    public java.lang.String getXMLbase() {
        return getAttributeNS(
                 XML_NAMESPACE_URI,
                 XML_BASE_ATTRIBUTE);
    }
    public void setXMLbase(java.lang.String xmlbase)
          throws org.w3c.dom.DOMException {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_BASE_QNAME,
          xmlbase);
    }
    public org.w3c.dom.svg.SVGSVGElement getOwnerSVGElement() {
        for (org.w3c.dom.Element e =
               org.apache.batik.css.engine.CSSEngine.
               getParentCSSStylableElement(
                 this);
             e !=
               null;
             e =
               org.apache.batik.css.engine.CSSEngine.
                 getParentCSSStylableElement(
                   e)) {
            if (e instanceof org.w3c.dom.svg.SVGSVGElement) {
                return (org.w3c.dom.svg.SVGSVGElement)
                         e;
            }
        }
        return null;
    }
    public org.w3c.dom.svg.SVGElement getViewportElement() {
        for (org.w3c.dom.Element e =
               org.apache.batik.css.engine.CSSEngine.
               getParentCSSStylableElement(
                 this);
             e !=
               null;
             e =
               org.apache.batik.css.engine.CSSEngine.
                 getParentCSSStylableElement(
                   e)) {
            if (e instanceof org.w3c.dom.svg.SVGFitToViewBox) {
                return (org.w3c.dom.svg.SVGElement)
                         e;
            }
        }
        return null;
    }
    public java.lang.String getNodeName() {
        if (prefix ==
              null ||
              prefix.
              equals(
                "")) {
            return getLocalName(
                     );
        }
        return prefix +
        ':' +
        getLocalName(
          );
    }
    public java.lang.String getNamespaceURI() {
        return org.apache.batik.dom.svg.SVGDOMImplementation.
                 SVG_NAMESPACE_URI;
    }
    public void setPrefix(java.lang.String prefix)
          throws org.w3c.dom.DOMException {
        if (isReadonly(
              )) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      NO_MODIFICATION_ALLOWED_ERR,
                    "readonly.node",
                    new java.lang.Object[] { new java.lang.Integer(
                      getNodeType(
                        )),
                    getNodeName(
                      ) });
        }
        if (prefix !=
              null &&
              !prefix.
              equals(
                "") &&
              !org.apache.batik.dom.util.DOMUtilities.
              isValidName(
                prefix)) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      INVALID_CHARACTER_ERR,
                    "prefix",
                    new java.lang.Object[] { new java.lang.Integer(
                      getNodeType(
                        )),
                    getNodeName(
                      ),
                    prefix });
        }
        this.
          prefix =
          prefix;
    }
    protected java.lang.String getCascadedXMLBase(org.w3c.dom.Node node) {
        java.lang.String base =
          null;
        org.w3c.dom.Node n =
          node.
          getParentNode(
            );
        while (n !=
                 null) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                base =
                  getCascadedXMLBase(
                    n);
                break;
            }
            if (n instanceof org.apache.batik.css.engine.CSSNavigableNode) {
                n =
                  ((org.apache.batik.css.engine.CSSNavigableNode)
                     n).
                    getCSSParentNode(
                      );
            }
            else {
                n =
                  n.
                    getParentNode(
                      );
            }
        }
        if (base ==
              null) {
            org.apache.batik.dom.AbstractDocument doc;
            if (node.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    DOCUMENT_NODE) {
                doc =
                  (org.apache.batik.dom.AbstractDocument)
                    node;
            }
            else {
                doc =
                  (org.apache.batik.dom.AbstractDocument)
                    node.
                    getOwnerDocument(
                      );
            }
            base =
              doc.
                getDocumentURI(
                  );
        }
        while (node !=
                 null &&
                 node.
                 getNodeType(
                   ) !=
                 org.w3c.dom.Node.
                   ELEMENT_NODE) {
            node =
              node.
                getParentNode(
                  );
        }
        if (node ==
              null) {
            return base;
        }
        org.w3c.dom.Element e =
          (org.w3c.dom.Element)
            node;
        org.w3c.dom.Attr attr =
          e.
          getAttributeNodeNS(
            XML_NAMESPACE_URI,
            XML_BASE_ATTRIBUTE);
        if (attr !=
              null) {
            if (base ==
                  null) {
                base =
                  attr.
                    getNodeValue(
                      );
            }
            else {
                base =
                  new org.apache.batik.util.ParsedURL(
                    base,
                    attr.
                      getNodeValue(
                        )).
                    toString(
                      );
            }
        }
        return base;
    }
    public void setSVGContext(org.apache.batik.dom.svg.SVGContext ctx) {
        svgContext =
          ctx;
    }
    public org.apache.batik.dom.svg.SVGContext getSVGContext() {
        return svgContext;
    }
    public org.w3c.dom.svg.SVGException createSVGException(short type,
                                                           java.lang.String key,
                                                           java.lang.Object[] args) {
        try {
            return new org.apache.batik.dom.svg.SVGOMException(
              type,
              getCurrentDocument(
                ).
                formatMessage(
                  key,
                  args));
        }
        catch (java.lang.Exception e) {
            return new org.apache.batik.dom.svg.SVGOMException(
              type,
              key);
        }
    }
    public boolean isReadonly() { return readonly;
    }
    public void setReadonly(boolean v) { readonly =
                                           v;
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedTransformList createLiveAnimatedTransformList(java.lang.String ns,
                                                                                                  java.lang.String ln,
                                                                                                  java.lang.String def) {
        org.apache.batik.dom.svg.SVGOMAnimatedTransformList v =
          new org.apache.batik.dom.svg.SVGOMAnimatedTransformList(
          this,
          ns,
          ln,
          def);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean createLiveAnimatedBoolean(java.lang.String ns,
                                                                                      java.lang.String ln,
                                                                                      boolean def) {
        org.apache.batik.dom.svg.SVGOMAnimatedBoolean v =
          new org.apache.batik.dom.svg.SVGOMAnimatedBoolean(
          this,
          ns,
          ln,
          def);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedString createLiveAnimatedString(java.lang.String ns,
                                                                                    java.lang.String ln) {
        org.apache.batik.dom.svg.SVGOMAnimatedString v =
          new org.apache.batik.dom.svg.SVGOMAnimatedString(
          this,
          ns,
          ln);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio createLiveAnimatedPreserveAspectRatio() {
        org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio v =
          new org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio(
          this);
        liveAttributeValues.
          put(
            null,
            SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedMarkerOrientValue createLiveAnimatedMarkerOrientValue(java.lang.String ns,
                                                                                                          java.lang.String ln) {
        org.apache.batik.dom.svg.SVGOMAnimatedMarkerOrientValue v =
          new org.apache.batik.dom.svg.SVGOMAnimatedMarkerOrientValue(
          this,
          ns,
          ln);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedPathData createLiveAnimatedPathData(java.lang.String ns,
                                                                                        java.lang.String ln,
                                                                                        java.lang.String def) {
        org.apache.batik.dom.svg.SVGOMAnimatedPathData v =
          new org.apache.batik.dom.svg.SVGOMAnimatedPathData(
          this,
          ns,
          ln,
          def);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber createLiveAnimatedNumber(java.lang.String ns,
                                                                                    java.lang.String ln,
                                                                                    float def) {
        return createLiveAnimatedNumber(
                 ns,
                 ln,
                 def,
                 false);
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber createLiveAnimatedNumber(java.lang.String ns,
                                                                                    java.lang.String ln,
                                                                                    float def,
                                                                                    boolean allowPercentage) {
        org.apache.batik.dom.svg.SVGOMAnimatedNumber v =
          new org.apache.batik.dom.svg.SVGOMAnimatedNumber(
          this,
          ns,
          ln,
          def,
          allowPercentage);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumberList createLiveAnimatedNumberList(java.lang.String ns,
                                                                                            java.lang.String ln,
                                                                                            java.lang.String def,
                                                                                            boolean canEmpty) {
        org.apache.batik.dom.svg.SVGOMAnimatedNumberList v =
          new org.apache.batik.dom.svg.SVGOMAnimatedNumberList(
          this,
          ns,
          ln,
          def,
          canEmpty);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedPoints createLiveAnimatedPoints(java.lang.String ns,
                                                                                    java.lang.String ln,
                                                                                    java.lang.String def) {
        org.apache.batik.dom.svg.SVGOMAnimatedPoints v =
          new org.apache.batik.dom.svg.SVGOMAnimatedPoints(
          this,
          ns,
          ln,
          def);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLengthList createLiveAnimatedLengthList(java.lang.String ns,
                                                                                            java.lang.String ln,
                                                                                            java.lang.String def,
                                                                                            boolean emptyAllowed,
                                                                                            short dir) {
        org.apache.batik.dom.svg.SVGOMAnimatedLengthList v =
          new org.apache.batik.dom.svg.SVGOMAnimatedLengthList(
          this,
          ns,
          ln,
          def,
          emptyAllowed,
          dir);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedInteger createLiveAnimatedInteger(java.lang.String ns,
                                                                                      java.lang.String ln,
                                                                                      int def) {
        org.apache.batik.dom.svg.SVGOMAnimatedInteger v =
          new org.apache.batik.dom.svg.SVGOMAnimatedInteger(
          this,
          ns,
          ln,
          def);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration createLiveAnimatedEnumeration(java.lang.String ns,
                                                                                              java.lang.String ln,
                                                                                              java.lang.String[] val,
                                                                                              short def) {
        org.apache.batik.dom.svg.SVGOMAnimatedEnumeration v =
          new org.apache.batik.dom.svg.SVGOMAnimatedEnumeration(
          this,
          ns,
          ln,
          val,
          def);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength createLiveAnimatedLength(java.lang.String ns,
                                                                                    java.lang.String ln,
                                                                                    java.lang.String val,
                                                                                    short dir,
                                                                                    boolean nonneg) {
        org.apache.batik.dom.svg.SVGOMAnimatedLength v =
          new org.apache.batik.dom.svg.SVGOMAnimatedLength(
          this,
          ns,
          ln,
          val,
          dir,
          nonneg);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedRect createLiveAnimatedRect(java.lang.String ns,
                                                                                java.lang.String ln,
                                                                                java.lang.String value) {
        org.apache.batik.dom.svg.SVGOMAnimatedRect v =
          new org.apache.batik.dom.svg.SVGOMAnimatedRect(
          this,
          ns,
          ln,
          value);
        liveAttributeValues.
          put(
            ns,
            ln,
            v);
        v.
          addAnimatedAttributeListener(
            ((org.apache.batik.dom.svg.SVGOMDocument)
               ownerDocument).
              getAnimatedAttributeListener(
                ));
        return v;
    }
    public boolean hasProperty(java.lang.String pn) {
        org.apache.batik.dom.AbstractStylableDocument doc =
          (org.apache.batik.dom.AbstractStylableDocument)
            ownerDocument;
        org.apache.batik.css.engine.CSSEngine eng =
          doc.
          getCSSEngine(
            );
        return eng.
          getPropertyIndex(
            pn) !=
          -1 ||
          eng.
          getShorthandIndex(
            pn) !=
          -1;
    }
    public boolean hasTrait(java.lang.String ns,
                            java.lang.String ln) {
        return false;
    }
    public boolean isPropertyAnimatable(java.lang.String pn) {
        org.apache.batik.dom.AbstractStylableDocument doc =
          (org.apache.batik.dom.AbstractStylableDocument)
            ownerDocument;
        org.apache.batik.css.engine.CSSEngine eng =
          doc.
          getCSSEngine(
            );
        int idx =
          eng.
          getPropertyIndex(
            pn);
        if (idx !=
              -1) {
            org.apache.batik.css.engine.value.ValueManager[] vms =
              eng.
              getValueManagers(
                );
            return vms[idx].
              isAnimatableProperty(
                );
        }
        idx =
          eng.
            getShorthandIndex(
              pn);
        if (idx !=
              -1) {
            org.apache.batik.css.engine.value.ShorthandManager[] sms =
              eng.
              getShorthandManagers(
                );
            return sms[idx].
              isAnimatableProperty(
                );
        }
        return false;
    }
    public final boolean isAttributeAnimatable(java.lang.String ns,
                                               java.lang.String ln) {
        org.apache.batik.util.DoublyIndexedTable t =
          getTraitInformationTable(
            );
        org.apache.batik.dom.svg.TraitInformation ti =
          (org.apache.batik.dom.svg.TraitInformation)
            t.
            get(
              ns,
              ln);
        if (ti !=
              null) {
            return ti.
              isAnimatable(
                );
        }
        return false;
    }
    public boolean isPropertyAdditive(java.lang.String pn) {
        org.apache.batik.dom.AbstractStylableDocument doc =
          (org.apache.batik.dom.AbstractStylableDocument)
            ownerDocument;
        org.apache.batik.css.engine.CSSEngine eng =
          doc.
          getCSSEngine(
            );
        int idx =
          eng.
          getPropertyIndex(
            pn);
        if (idx !=
              -1) {
            org.apache.batik.css.engine.value.ValueManager[] vms =
              eng.
              getValueManagers(
                );
            return vms[idx].
              isAdditiveProperty(
                );
        }
        idx =
          eng.
            getShorthandIndex(
              pn);
        if (idx !=
              -1) {
            org.apache.batik.css.engine.value.ShorthandManager[] sms =
              eng.
              getShorthandManagers(
                );
            return sms[idx].
              isAdditiveProperty(
                );
        }
        return false;
    }
    public boolean isAttributeAdditive(java.lang.String ns,
                                       java.lang.String ln) {
        return true;
    }
    public boolean isTraitAnimatable(java.lang.String ns,
                                     java.lang.String tn) {
        return false;
    }
    public boolean isTraitAdditive(java.lang.String ns,
                                   java.lang.String tn) {
        return false;
    }
    public int getPropertyType(java.lang.String pn) {
        org.apache.batik.dom.AbstractStylableDocument doc =
          (org.apache.batik.dom.AbstractStylableDocument)
            ownerDocument;
        org.apache.batik.css.engine.CSSEngine eng =
          doc.
          getCSSEngine(
            );
        int idx =
          eng.
          getPropertyIndex(
            pn);
        if (idx !=
              -1) {
            org.apache.batik.css.engine.value.ValueManager[] vms =
              eng.
              getValueManagers(
                );
            return vms[idx].
              getPropertyType(
                );
        }
        return org.apache.batik.util.SVGTypes.
                 TYPE_UNKNOWN;
    }
    public final int getAttributeType(java.lang.String ns,
                                      java.lang.String ln) {
        org.apache.batik.util.DoublyIndexedTable t =
          getTraitInformationTable(
            );
        org.apache.batik.dom.svg.TraitInformation ti =
          (org.apache.batik.dom.svg.TraitInformation)
            t.
            get(
              ns,
              ln);
        if (ti !=
              null) {
            return ti.
              getType(
                );
        }
        return org.apache.batik.util.SVGTypes.
                 TYPE_UNKNOWN;
    }
    public org.w3c.dom.Element getElement() {
        return this;
    }
    public void updatePropertyValue(java.lang.String pn,
                                    org.apache.batik.anim.values.AnimatableValue val) {
        
    }
    public void updateAttributeValue(java.lang.String ns,
                                     java.lang.String ln,
                                     org.apache.batik.anim.values.AnimatableValue val) {
        org.apache.batik.dom.svg.LiveAttributeValue a =
          getLiveAttributeValue(
            ns,
            ln);
        ((org.apache.batik.dom.svg.AbstractSVGAnimatedValue)
           a).
          updateAnimatedValue(
            val);
    }
    public void updateOtherValue(java.lang.String type,
                                 org.apache.batik.anim.values.AnimatableValue val) {
        
    }
    public org.apache.batik.anim.values.AnimatableValue getUnderlyingValue(java.lang.String ns,
                                                                           java.lang.String ln) {
        org.apache.batik.dom.svg.LiveAttributeValue a =
          getLiveAttributeValue(
            ns,
            ln);
        if (!(a instanceof org.apache.batik.dom.svg.AnimatedLiveAttributeValue)) {
            return null;
        }
        return ((org.apache.batik.dom.svg.AnimatedLiveAttributeValue)
                  a).
          getUnderlyingValue(
            this);
    }
    protected org.apache.batik.anim.values.AnimatableValue getBaseValue(org.w3c.dom.svg.SVGAnimatedInteger n,
                                                                        org.w3c.dom.svg.SVGAnimatedInteger on) {
        return new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
          this,
          n.
            getBaseVal(
              ),
          on.
            getBaseVal(
              ));
    }
    protected org.apache.batik.anim.values.AnimatableValue getBaseValue(org.w3c.dom.svg.SVGAnimatedNumber n,
                                                                        org.w3c.dom.svg.SVGAnimatedNumber on) {
        return new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
          this,
          n.
            getBaseVal(
              ),
          on.
            getBaseVal(
              ));
    }
    public short getPercentageInterpretation(java.lang.String ns,
                                             java.lang.String an,
                                             boolean isCSS) {
        if (isCSS ||
              ns ==
              null) {
            if (an.
                  equals(
                    org.apache.batik.util.CSSConstants.
                      CSS_BASELINE_SHIFT_PROPERTY) ||
                  an.
                  equals(
                    org.apache.batik.util.CSSConstants.
                      CSS_FONT_SIZE_PROPERTY)) {
                return PERCENTAGE_FONT_SIZE;
            }
        }
        if (!isCSS) {
            org.apache.batik.util.DoublyIndexedTable t =
              getTraitInformationTable(
                );
            org.apache.batik.dom.svg.TraitInformation ti =
              (org.apache.batik.dom.svg.TraitInformation)
                t.
                get(
                  ns,
                  an);
            if (ti !=
                  null) {
                return ti.
                  getPercentageInterpretation(
                    );
            }
            return PERCENTAGE_VIEWPORT_SIZE;
        }
        return PERCENTAGE_VIEWPORT_SIZE;
    }
    protected final short getAttributePercentageInterpretation(java.lang.String ns,
                                                               java.lang.String ln) {
        return PERCENTAGE_VIEWPORT_SIZE;
    }
    public boolean useLinearRGBColorInterpolation() {
        return false;
    }
    public float svgToUserSpace(float v, short type,
                                short pcInterp) {
        if (unitContext ==
              null) {
            unitContext =
              new org.apache.batik.dom.svg.SVGOMElement.UnitContext(
                );
        }
        if (pcInterp ==
              PERCENTAGE_FONT_SIZE &&
              type ==
              org.w3c.dom.svg.SVGLength.
                SVG_LENGTHTYPE_PERCENTAGE) {
            return 0.0F;
        }
        else {
            return org.apache.batik.parser.UnitProcessor.
              svgToUserSpace(
                v,
                type,
                (short)
                  (3 -
                     pcInterp),
                unitContext);
        }
    }
    public void addTargetListener(java.lang.String ns,
                                  java.lang.String an,
                                  boolean isCSS,
                                  org.apache.batik.dom.anim.AnimationTargetListener l) {
        if (!isCSS) {
            if (targetListeners ==
                  null) {
                targetListeners =
                  new org.apache.batik.util.DoublyIndexedTable(
                    );
            }
            java.util.LinkedList ll =
              (java.util.LinkedList)
                targetListeners.
                get(
                  ns,
                  an);
            if (ll ==
                  null) {
                ll =
                  new java.util.LinkedList(
                    );
                targetListeners.
                  put(
                    ns,
                    an,
                    ll);
            }
            ll.
              add(
                l);
        }
    }
    public void removeTargetListener(java.lang.String ns,
                                     java.lang.String an,
                                     boolean isCSS,
                                     org.apache.batik.dom.anim.AnimationTargetListener l) {
        if (!isCSS) {
            java.util.LinkedList ll =
              (java.util.LinkedList)
                targetListeners.
                get(
                  ns,
                  an);
            ll.
              remove(
                l);
        }
    }
    void fireBaseAttributeListeners(java.lang.String ns,
                                    java.lang.String ln) {
        if (targetListeners !=
              null) {
            java.util.LinkedList ll =
              (java.util.LinkedList)
                targetListeners.
                get(
                  ns,
                  ln);
            java.util.Iterator it =
              ll.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                org.apache.batik.dom.anim.AnimationTargetListener l =
                  (org.apache.batik.dom.anim.AnimationTargetListener)
                    it.
                    next(
                      );
                l.
                  baseValueChanged(
                    this,
                    ns,
                    ln,
                    false);
            }
        }
    }
    protected org.w3c.dom.Node export(org.w3c.dom.Node n,
                                      org.apache.batik.dom.AbstractDocument d) {
        super.
          export(
            n,
            d);
        org.apache.batik.dom.svg.SVGOMElement e =
          (org.apache.batik.dom.svg.SVGOMElement)
            n;
        e.
          prefix =
          prefix;
        e.
          initializeAllLiveAttributes(
            );
        return n;
    }
    protected org.w3c.dom.Node deepExport(org.w3c.dom.Node n,
                                          org.apache.batik.dom.AbstractDocument d) {
        super.
          deepExport(
            n,
            d);
        org.apache.batik.dom.svg.SVGOMElement e =
          (org.apache.batik.dom.svg.SVGOMElement)
            n;
        e.
          prefix =
          prefix;
        e.
          initializeAllLiveAttributes(
            );
        return n;
    }
    protected org.w3c.dom.Node copyInto(org.w3c.dom.Node n) {
        super.
          copyInto(
            n);
        org.apache.batik.dom.svg.SVGOMElement e =
          (org.apache.batik.dom.svg.SVGOMElement)
            n;
        e.
          prefix =
          prefix;
        e.
          initializeAllLiveAttributes(
            );
        return n;
    }
    protected org.w3c.dom.Node deepCopyInto(org.w3c.dom.Node n) {
        super.
          deepCopyInto(
            n);
        org.apache.batik.dom.svg.SVGOMElement e =
          (org.apache.batik.dom.svg.SVGOMElement)
            n;
        e.
          prefix =
          prefix;
        e.
          initializeAllLiveAttributes(
            );
        return n;
    }
    protected class UnitContext implements org.apache.batik.parser.UnitProcessor.Context {
        public org.w3c.dom.Element getElement() {
            return SVGOMElement.this;
        }
        public float getPixelUnitToMillimeter() {
            return getSVGContext(
                     ).
              getPixelUnitToMillimeter(
                );
        }
        public float getPixelToMM() { return getPixelUnitToMillimeter(
                                               );
        }
        public float getFontSize() { return getSVGContext(
                                              ).
                                       getFontSize(
                                         );
        }
        public float getXHeight() { return 0.5F;
        }
        public float getViewportWidth() {
            return getSVGContext(
                     ).
              getViewportWidth(
                );
        }
        public float getViewportHeight() {
            return getSVGContext(
                     ).
              getViewportHeight(
                );
        }
        public UnitContext() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "HcsN8jve9E9u/+OXf/jx7+T3TP8LA1kkOaYmAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "W/bon3HW7AO////doCq5Cb7A9TiXX4I+/sOPtd7xxTz/qS3Mcj+R3DhEAX/1" +
       "NC/y4/b/PnzDPf/8sPAiqfCQsnOGRdmKMwsjAQcwPPaQgcN8Xfz1ztzWc3n2" +
       "xNa/9rwdPnPb81b4dGgE37PU2ff7zxneV2QsPwcufKc7+Hm1OyjkX3pbzcvl" +
       "05l401aLsq9fFxXuCXOXe2fp/gL8HYDrz7MrKzAL2PomD7d2DtKTJx6SB0bu" +
       "RxLbGgWyEVFOPnictBTQw6+7QQ/zLom78cxKKUfVEk0dZVbttIfkisZ9LUWj" +
       "Tmh4NAt9M7jGOxrGN6FB2k/DfaBrOKFx3C2GUeHeQJNV17HS/crLB4YNhqbV" +
       "zu+F3vvw55Y//Ic/sfVpz2vqucTad37ku/7i2oc+cnhmJvHUDc782Tzb2URe" +
       "xZfk9cws5Ov33SXP0f6DT7z35//ee79jW6uHr/eLCTDt+4l/////+rUf+vxn" +
       "LnDNXjRzXUuTnXNt9I233ka5hXwtuL5p10bfdJM2Mi9uo4O8jY7b5R4v0OZG" +
       "/t87z9VpeZt6k9kreVcn+SZ18vfpTSbefVyx+4G7upu5HneAp/a5tbu05zAE" +
       "t8krDC59h0G/CYbNrfD6YCQHOpjDAM8g6995YvFc5d5zm5UrgcvaVc66SeXe" +
       "fyuVeyB2jOgcuW+7gVwvW14Irgkgbe4jh6EbPH0xzR/4mki23esA+IN3I9dq" +
       "10rZ/991cV2PMq0ENs1QsrAByDE3HNk6rvyrTEt5+th6ioBaYCKfNq3aRSo8" +
       "vOV6gY7/0lMHgHEd/dkP/ucP//p3P/U50Inpwt2rbFACvf2Ml9CLs9WUb//4" +
       "9z/+wEc+/8Hc5wVEi3/9p2ufz0r9vpugy75+KEeWie8+hvVYBmuYTxcZOYzY" +
       "3EfV1AxZXsQ3n8EDDNtdFqjiXxpt9MQfkpWQwo7/GFFtlftKIo0jW2pHyIyK" +
       "ivOiuKoxzWSpI3gAUZ3OQIpCsWtFMtThO4Pxho3kSSvQGolKVYpqB6NQvcki" +
       "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" +
       "UUSK8xZTt1UkwcRqvSF6g2WclAepWAZ9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "LoE9DwRe8FFnh71zG9gLt2EJP7kH7M9m4qeiwmNzI9Cyce/EHF73WoEzkH/6" +
       "svbv1QDq7t0fRze8++NrNffX2ut18PYsDMux/cIe3L+UiX8SFe7REm97iuHg" +
       "7acYP3UFU96j2Q7j7E5i/Fd7MP7rTPwqmPyqmuYRF+H8zBX8cHDk7HA6V4Pz" +
       "dNXm4O05jN/dA/E/ZuK3o8K9iuulYAxzzwH8d5cFmA1dmx3AzR0C+F/2APyD" +
       "THweuKVZG7YuBvmF2wGZgLLOvqEve9fYoze89HP7okrlJ1948N5XvSD8zvbo" +
       "zfHLJO9jCvfOY8s6+9KjM9/PvO7lvly+NP/l/ei/704fX/QLXlQ4AjKr7NGX" +
       "t6m/AgzwRalBSiDPpvxfu8N1Z1NGhbvzz7Pp/hT0hNN0oOtvv5xN8megdJAk" +
       "+/pV73hsvfGdSMdTjeP3c+2oTLY/6j96Vp3y08IPf60GOsly9h142Tmq/KWt" +
       "x8+SiLevbX1e+cQLdO89X6n+2PYdfIolbzZZKfcyhRdtXweYF5o9j+L1Ny3t" +
       "uKx7yDd/9aU/dd8zx8/OeOm2wqeqfaZur7v4bXeE7UX5++k2/+hVP/Pc333h" +
       "s/l7Sv4fvqfE4013AAA=");
}
