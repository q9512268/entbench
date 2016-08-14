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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1cC5QVxZmu23deDI9hGHnI+zEQQZkrwUcQRIdhgNGBGQcY" +
       "3QEz9NzbM3Oh53bT3Ze5QFAxJ8qaDb6Ij43MnqNkTQyKWXUTNRpiNIqPGIwb" +
       "Na4aTbKGgHt0sxEN67r/X119u2/frprbzj3LOf1Pc6v+6vq++uuvv6qr6+AH" +
       "pNQ0yExdTiXkOmu7rph1rXjfKhumkmhQZdNcB792xm9499arT/562G6JlHWQ" +
       "Ub2yuToum8qKpKImzA4yJZkyLTkVV8w1ipJAjVZDMRVjm2wltVQHGZs0m/p0" +
       "NRlPWqu1hIIZ2mWjmVTLlmUku9KW0sQKsMi0ZlqbGK1NrN6fYXEzGRHX9O2u" +
       "wsQchQZPGubtc59nWmR082Z5mxxLW0k11pw0rcUZg5ypa+r2HlWz6pSMVbdZ" +
       "PZcRcUnzuXk0zHyw6uNTN/WOpjTUyKmUZlGIZptiauo2JdFMqtxfG1Wlz9xK" +
       "riLRZjLck9kitc3OQ2Pw0Bg81MHr5oLaj1RS6b4GjcKxnJLK9DhWyCIzcgvR" +
       "ZUPuY8W00jpDCRUWw06VAe30LFqnuX0Qv31mbN/tXx39L1FS1UGqkqm1WJ04" +
       "VMKCh3QAoUpfl2KY9YmEkugg1Slo8LWKkZTV5A7W2mPMZE9KttJgAg4t+GNa" +
       "Vwz6TJcraEnAZqTjlmZk4XVTo2L/K+1W5R7AOs7FaiNcgb8DwMokVMzolsH2" +
       "mErJlmQqQe0oVyOLsfZSyACq5X2K1atlH1WSkuEHMsY2EVVO9cTWgvGleiBr" +
       "qQYmaFBb4xSKXOtyfIvco3RaZII/X6udBLmGUSJQxSJj/dloSdBKE32t5Gmf" +
       "D9Ys2bsztSolkQjUOaHEVaz/cFCa6lNqU7oVQ4F+YCuOmNd8mzzuiT0SIZB5" +
       "rC+znedHX/vo4rOmHn7OzjMpIE9L12YlbnXGD3SNOjq5Ye6iKFajQtfMJDZ+" +
       "DnLay1pZyuKMDp5mXLZETKxzEg+3/eLvrrlPOS6RyiZSFtfUdB/YUXVc69OT" +
       "qmKsVFKKIVtKookMU1KJBpreRMrhvjmZUuxfW7q7TcVqIiUq/alMo/8Hirqh" +
       "CKSoEu6TqW7Nuddlq5feZ3RCyGi4yFS4LiL2v8UoLNId69X6lJgcl1PJlBZr" +
       "NTTEjw1KfY5iwn0CUnUt1gX2v2X+grrzY6aWNsAgY5rRE5PBKnoVOzGW0Ppi" +
       "5jYwrPaVLavRPSgpcDlgb/r/25MyiLmmPxKB5pjsdwYq9KNVmppQjM74vvSy" +
       "xo8e6HzBNjTsHIwti8yGx9XZj6ujj6uDx9XB4+q8jyORCH3KafhYu8GhubZA" +
       "xwfPO2Lu2isv2bRnZhQsTe8vAa4lyDonbyRqcD2E49Y74wePtp18+aXK+yQi" +
       "gRPpgpHIHQ5qc4YDezQztLiSAH/EGxgc5xjjDwWB9SCH7+jf3X712bQeXg+P" +
       "BZaCc0L1VvTL2UfU+nt2ULlV1//p40O37dLcPp4zZDgjXZ4muo6Z/jb1g++M" +
       "z5suP9L5xK5aiZSAPwIfbMnQZ8C9TfU/I8eFLHbcMWKpAMDdmtEnq5jk+NBK" +
       "q9fQ+t1fqLFV0/vToIlHYZ+aCNdW1sm22uIqcAwox9vGiTbjQ0Hd/YVr9f2v" +
       "//LYQkq3MzJUeYb0tYq12OONsLAx1O9Uuya4zlAUyPfWHa23fvuD6zdQ+4Mc" +
       "s4IeWIuyAbwQNCHQ/I3ntr7xztsHXpWyNhuxyDDd0CzoqEoik8WJSWSkACea" +
       "ulslcGgqlICGU7s+BYaZ7E7KXaqC/eR/qmYveOTE3tG2Kajwi2NJZw1egPv7" +
       "6cvINS989eRUWkwkjgOqS5ubzfbSNW7J9YYhb8d6ZHa/MuXOZ+X94O/Bx5rJ" +
       "HQp1m4TSQGi7nUPxx6hc6Es7D0Wt6bX/3C7mCXw64ze9+uHI9g+f/IjWNjdy" +
       "8jb3allfbFsYitkZKH6839esks1eyHfO4TUbR6uHT0GJHVBiHHym2WKAn8vk" +
       "GAfLXVr+25/9fNymo1EirSCVqiYnVsi0n5FhYOCK2QsuMqNfdLHduP0VzviR" +
       "IXngkc9pwS3V2KdblNsdPx7/8JJ7B96mdkVLmJLfZbYzU9oe3GVQzkExL98K" +
       "eaq+9pKYG8b/T4BYmdYa46A6Ow5yEoK9f30XeCNgabkWT6P3p/VqFJjEpSgu" +
       "pknno6i3+88FhdGKP1xka0yiv5WZGNz6hw86Q3E934k3v/P7n568p9yOb+by" +
       "3b1Pb8LfWtSua9/7JM8gqaMPiL18+h2xg3dNbFh6nOq7Hhe1Z2Xyx2EYk1zd" +
       "L9/X91dpZtkzEinvIKPjbDbQLqtp9GMdEAGbzhQBZgw56bnRrB26Lc6OKJP9" +
       "3t7zWL+vd8d/uMfceD/S597HYtMsgWs5M7jlfluNEHrTbpsrlXNRnGWbHt7O" +
       "t6Ap6ZzD509PExRskZpMn7rOkJNWU4oOS9nWAYM9I89gaV9crqW7VJgsJpQM" +
       "TFrRX7pdiVrk5YNZZGu2hhPw17lwXc5qeDkHuiyGPgz6UMpMYv/JRT9eULZF" +
       "KgxFTmgpdTv1sJ5OgNPttWnomq1Gsg8GxW1sMnBo3MmtT5fvWO4E+kEqds5L" +
       "zdUvP7bq/U466FZgrLXOaX5PFFVv9HhG/NF23T+HfxG4/hcvrDP+gH/BLhtY" +
       "bD89G9zrOjpwQZ/0QYjtGvPOlrv+dL8Nwd8BfZmVPftu+Lxu7z57GLVniLPy" +
       "JmleHXuWaMNBsQVrN0P0FKqx4v1Dux7/3q7r7VqNyZ3vNMJ0/v7ffPZi3R2/" +
       "OxIQVpd3aZqqyKmst4vYQQadOPlayIZVtmD/p1df93oLRHJNpCKdSm5NK02J" +
       "3O5abqa7PE3mzj/dLswAYvNA1D4PWsLXE7oK7wl0wJoM10ZmrRs5PWGncMzi" +
       "aYN30A2lO0lruMJXza+F7LB1cMnsQTKnmteKOiwKJaCn8gq1SCXMkthiiuOe" +
       "ZolmUyyvD+jXQ7bHArh6WJ16OED/QdgePG2IyCzZ6IGZNgQy2JWp6pW++n4r" +
       "ZH3PhktlT1Q59b1VWF+etkWGQzexfE0wP68JdFwXM+rWQ146gzJNzagNbox9" +
       "AnAZjvWgGcPok4RIvEJmkZNrR/RfFWGLEM5fDwpP3BN1MExEDP0L417rYTNx" +
       "J8tZXEtrzEDjJWAYxCG0nobHjtLcQCU5lYSYDwQdaddRE0APOYW3ckW944Fr" +
       "9w0kWr67QGIxoIEjnqbPV5VtiuoBtYT6Wn8wt5qu17mR0fmvnIy+ecuEEfnL" +
       "AFjSVM4kfx5/hPE/4Nlr/zxx3dLeTSHm99N8+P1Ffn/1wSMr58RvkeiSox2I" +
       "5S1V5iotzvXnlYZipY1Urgefmd9/djPb2e3vP6758joPT1UQzT8iSPsRigct" +
       "MikJvYmuFCv1qtoMw2Z2ed+2tj420OKfrRYp2aYlE24/+2H4CQL9+WAW4BhM" +
       "Qv98MwN4s4Abf5+N4O2Az9lXCgoTMPKMIO1ZFD+1SCn0qKYEHeZcDg4PmYPh" +
       "mDQdrgFW7YFB7OOpfMQ8VR+qiMvbClrqUQHsX6N4EWCbDuxHXdgvFafpMSy5" +
       "n9X9/vCweaoCVG8J0t5B8TqEBNDQV6xuRv/la+03itPa8+B6mNX94fCweaqD" +
       "tfax4AzOuDLBO14tb1ndmIkrOnpXqnwcxR8wXsohx2MTfxwyOadj0plwPc4Q" +
       "Ph6eHJ6qoN1PCtI+RfFfMD8Cm2jph3AqfxCfEjDO+3JRfv4yZH7GYdIZcB1h" +
       "II+E54enyucgUipIK0dBbH7ak0q/rhkWQ47Z787Cj0SK4zKmwPUaw/BaePg8" +
       "VQHEakFaDYoREMMC/DUQ26xhYYHrMyIji4N7Blzvscq/Fx43T1WAbYogbRoK" +
       "sP0qxA2YTQhHlfVtTT7spxfHX6LJH2MAjoXHzlMdxF9G5vIznKAZzkRRCyEz" +
       "+MTW7CTYdYmR2UPGT5fwvgRPjdgl2H8F+POjR66qeDgY7XVraNsU8rkCo1iE" +
       "4mzbFzTIZlyG+QsMFcvyxtHIguLYxXyo7gIGbkFou+Cq8pt9D8XZIOCgEcVS" +
       "i4wEk8hdLfCYxUXFGQlmQa2+wjB8JTx8nqoAXYsg7TIUlwDyHj/yPS7yS4eM" +
       "nK4TQQAVqWfVrw+PnKfqQxf1zOfpzgQ2E/LNikrNXhj0gsyl314U878IyS7o" +
       "0pd59sLhozXHHjqyqfwNe5kyeMnYt3/kvZ0v3K39+3HJmbsn6XrtbP5s2vO4" +
       "gX+e9curB2a9S1+/VSRNmI/XGz0BG108Oh8efOf4KyOnPEDfUpc4AeBI/w6h" +
       "/A1AOft6aFWr9EzWzbhvtez3IYH+qFVnq0yRzXbLUulf/huAxuhOpmSVPmSL" +
       "RcpUJdVj9Qa1WjRJI5RIN6tKwAu3GrdqDaqWUvCNhJNm76FIanXZvVaQmAms" +
       "+0G6ehvp9pgkrYqgL+0UpO1CkQGkcayTDUGQ/Rr2Zo4EGyjNs0Gg/3UU7eDU" +
       "44YiWwoGts68wOFictBCV04m2vcHfXszaN+vwSQIACMtrAO3hO/7PFUBBTcK" +
       "0m5GcYOFL/3a2CsfzLbZhf3N4ox1c6DO7azu7eFh81T5Y91miu87Auz7UdwG" +
       "wS+MdV7wnpHu9iGDx7iXLII6XckQXDkI+IAAiKcqwHavIO37KO6GCTOMdP5X" +
       "nNnXlle6JNwzZBLwRSZZBQgUhkQJTwJPNXjQw/+ucAXF/ZCAk0dQPGCRabab" +
       "oGuJdDGaLmGnTCQI30g4PmOheMcaX5cyemjIjM7CpCXoohktZnhGeaqFMGr3" +
       "rp8JGP05ip9Y5PR8Rpd5XksGviwJ5NKrRVl8YsgszsSkC4ACtkAdCb+2zVX1" +
       "USO5w7zHJF8WEHgUxfPQTfMJzN0/w38Lk8OfR4nS98KQ6RuBSTD7iNzEOLgp" +
       "PH03MtUbxfR5iRGsgUZwDTTyukVm55PGPiFQ6k0dwrQ2dHcOg4sKY5BXAqVz" +
       "6GurlM4YcMGWwyODraQH0Lmfqe7/ItZ4XEDsByj+wyKz8oldLRtbFKPFwF0m" +
       "dJuQQ+v5hdEarE9Jfb84pGLwcZAxczA8qT9gqj8QkyoYej4VMHsKxX9bZGKA" +
       "ycpW73LZkh1C6wq0U68a5fGvxXOVjzIyHg3PI091MB5pimgG261qMmcGi9WS" +
       "yvn0S6NQSIFudk2afpoSzs16lJB6KVo86p9i/D0Vnnqeqo+YElqPkhwTlirw" +
       "jg740kQBkZNRjBUQiemjXWLGDZmYOZi0DFD9iqH7VXhieKoFEOOJhKQ5AmLO" +
       "QDED5pk8YryB5dlhrCwnqpRmFs/S3masvB2eUJ5qwc5SEuz7lnDftxQLNLJW" +
       "LZmysrtMCuytHiXK4dnFM8oTjIgT4TnkqfqIKaX1KA0yShCRjZSxZQI2l6O4" +
       "MNAym+nK0xewTJ8iZXVp8eY7pxg1p8KzylMNM/wgr5pgpGkVsL0OxaWBM6Km" +
       "lKX0uENNgTMirxbluXnIPH8Jk5ZDaDjMLsH+G4pnrupgLhVTIrK9nhlJBC6x" +
       "euYw3CVWia1UUpm3xIpl99nrq3ibog2KWl35C6mYRiuTFq2MSl2YZbug4fsE" +
       "afTZtCpX2bUQ5N0qXgt1+/wmQSG4aixtsMiUfCvE7cS4d9qzNrqgMEv0a1Jr" +
       "3Fi08Ugaz0xqfHhr5KkW6ksjG6lDpdxdI+D1WhQ7A0emZncVv/CRyaNE2Rx0" +
       "L/KgbE7HpPOAitmMktnh2eSpFj667xVweBOKv7fIuHwO25xXK8DgvMIYzKpQ" +
       "/m4ozvL9VAC/kJGwcBD+8texuao+Uvzv8qW7BKyhT5Nut8jwXtlsNTT6WTy1" +
       "WRf8HcUBPwlqfiFDcGF48DxVH7bAxQnpewIG7kNxj0UqgAG6ou2Df6A48GFw" +
       "lBoZhsbw8Hmqg7X9wwLk/4rikEVOS2ab3jZ/Zx3fw8KDxdngVgcQrmBQrhCw" +
       "IBp/c8kZLSixINsQrENLuA4tPW7hmSHZ3cFcin5SHEMB7yglGKBEeEPhqQ5m" +
       "KC8JaHgZxXMWGeMxlESCfmvk4+BIcTiYg43FgPSH54CnWpA9vCEg4k0Ur1qk" +
       "xmsPwUz8W3GYqIUKXsXgXBWeCZ5qQUz8UcDE+yh+Z5HqpO00ub3i3eLwANGc" +
       "dB0Dc114HniqBfHwkYCHv6A4YZEqh4dga/hgyCzgFzg0gNjLoOwNzwJPdTDf" +
       "8JmAgM9RfGLvhnScA/scRLrMJeDT4uwGROfIXlNI/tcUX3z84JVYiHVEK/nk" +
       "REegKIFZKJCTdRj57ERLi7Y9RGLvGyT/+4YCzIOnKgA4TpA2AUW1/UmBb9t4" +
       "jXfXjH+zeHRMcXaNNAAU9rmAFP5LA66qwCgcePmzNPqF2jb6fqrOdZX0hRXl" +
       "qlbAIy4BR6cBaWk9AVMTp5NRZczvbjmJTi8Oc4sAEPuWQHosPHOPcVR9GIPm" +
       "edHZFPKXBXScg2I+RK02HdluFcRHXXH4WAZgnmagng7PB09V7F4YFUsFVFyM" +
       "YhG4F5uKFqtXMYJouGDINEzCpPlQu+cZlufD08BTLcjLXiKgoRlFo733en0q" +
       "oRjq9mSqxyEiOtslYsWQicBTuXALrsQ+ppAG+w4jYB2EpxpMhONUZgbsNPQt" +
       "5iLEyykl7QK6OlBcZpERQBfuTw8iqq14RL3L0L4bniieqpioGQKisi8To7bf" +
       "TQh4wlX7aKeYp01D5qkak86C6h9nYI+H71k81QIcrr04GTUEPOCCSLTPIpMw" +
       "wlOMOIzVco+CJmfohmJ/hLwV1zpdWlJDpgVPGSJLobaSXYL9l0NLYLSH5yHk" +
       "RXs1ghIL8kNXC4jajWK7RWq90V6BjO0oTgS4AHANZ/iGhzYkrqoA9DcFad9C" +
       "cZ1FpqZNBQ9HlI22lcsaNBUPiUMuNNWhwjNXil5fnD41DXBMYHgmhKeCp8rt" +
       "U3SrA13wt1+kRG8XMHMnilssMgr80zptvakYa/ErMlqMy8StxQlflkAF5zE4" +
       "c8MzMZej6oMXuMths+OUg98FBR3c4JzdQXm6R8DhvSgGLFItJxK5qpjbE/78" +
       "U3FovAg4WMK48J+BUQCNizmqBdGIMA5Q1D8UMPIQioMQGhtKn7ZNEZJy/5BJ" +
       "oUkwVYiuZMhWCkjxu2jic8wlgnIKcsxPCng5jOLHFpnYnTQUHMqz3jnnoBgP" +
       "O48Wxx2fDmjYQVnRvEO4fCaTH/9wVbmEROjRhqso6OcFhLyI4hmLlCkZ/GiZ" +
       "arrgf1G01YhoF0PQFR48T7Ug8L8RgH8dxVGLVCYURW8MIuCVor3xiqYYilR4" +
       "AniqPmjual3kPIrvPQH2P6B4yyIV9rHlluZD/nZxkOPYu4NVf0d45DzVwZD/" +
       "pwD5hyiOQTSPrd4QjP7PX+DURyjRe84wHrE5Ie9Yc/so7vgDA1UV4wfWv2Z/" +
       "Regclz2imVR0p1XVe6qh595zxNgIKqvpzpHoSXZqRdC7bItEQWKVox/buf8G" +
       "o0JQbsgJ0pvzM/b5szenRUrpX0++EgI9yM0HvsS+8WaJQumQBW9LdCcSyD8A" +
       "0ZmnOad2Mioz9kaZSd7xgh4mMXawZsqqeI/SxU9C6bH0zqelaftg+s74oYFL" +
       "1uz86Lzv2kf5xlV5xw4sZXgzKbdPFaaF4oFKM7ilOWWVrZp7atSDw2Y7H6ZW" +
       "2xV2bX6Sa5MYUUR0tJiJvkNuzdrsWbdvHFjy5Et7yl6RSGQDicgWqdmQf4xm" +
       "Rk8bZNqG5qCD+dplg56/u7jy95te/uS3kTH0ZFdiH+U3VaTRGb/1yTdbu3X9" +
       "HyUyrImUJvF0SnrG5/LtqTYlvs3IOeevrEtLp7Kfwo5C85ZxxxVlhhE6Mvsr" +
       "HmRmkZn5xx7mH49dqWr9irEMS8diRvqOoErrujeVMrsNxZYMMg022Nm8WtfZ" +
       "eY8ld1LmdR37b8l4/E///wHhQaMye2IAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0fzXfaAa33pzQ9zJ/LNTW/boX7Dm/IN/+P/doCq5Cb7ALTmXXoQ++bHHWu/8" +
       "cp7+1BZmqZ9IbuyigC97mrbyU9Z/OXzTPf/ksPASsfCQvHOUJ5IZZRZGBM5h" +
       "cOw9A2f6uvDrHb2tV/Psia1//Xk7fOa2563wadcIzrPY2fn95wzvqzKWnwNH" +
       "e6c77fNqd1DIT5it5uXy6Uy8ZatF2ek3hYV7gtwd31m6vwJ/B+D4y+zIMswu" +
       "bP2Wh1s75+nJE+/JBT33I4lljnzJCLt23nmc1BTQw2+6QQ/zJtl2orm56dqK" +
       "mqjKKLNqpy0kVzT2Gyla94SGR7OrbwXHdEfD9CY0iPtpuA80DTswjpvFMCzc" +
       "66uS4tjmZr/ycr5hga5pvfOJofc9/IXVx/74p7f+7nlNPRdZ/d6Pft9fXfvw" +
       "Rw/PjDKeusHRP5tmO9LIi/iyvJyZhXzjvrvkKTp/9Kn3/eLfe9/3bEv18PU+" +
       "Mw6GhD/9b/7/37z2Y1/83AWu2UvmjmOqkn2ujr711usot5CvB8e37ero225S" +
       "R8uL6+ggr6PjernH9VXNyH+961yZVrepN5m9knZlkm5SJm+f3mTiPccFux+4" +
       "q7tR7XEDeGqfW7uLew6Df5u8lsGh7zDoN8GQ3gqvD4aSr4PxDfAMsvadR56c" +
       "K9x7b7NwJXCYu8KZNyncB26lcA9EthGeI/cdN5DrZlMP/rUxiJv7yEHg+E9f" +
       "TPMHvyGSbfM6AP7g3ZVr9Wul7Pf3XVzWo0wrgU0z5OzaAKTQDFsyjwv/mqUp" +
       "P31sPSeAWmAin16a9YtUeHjL5QIN/+WnDgDl2PqzH/r3H/nN73/qC6AR9wp3" +
       "r7NOCbT2M14CE2UzLd/9yR9+/IGPfvFDuc8LiOZ+BH/oW7Jcf+gm6LLTD+fI" +
       "MvH9x7Aey2AN8+EiJQUhnfuoqpIhy7P49jN4gGG7ywRF/GujDZ/4GAkH3cbx" +
       "H1WWWwg/SUQrqlQVtd3FFgRpd4spzvPiyo/HMj/oKgudIZoEL8+qPJ5iTDqn" +
       "q+wCqc5HVVFF+E4j6aGe1J7Xuku4Stsesxrxm/5UGI+YgWswXY8juvGckWBp" +
       "NO8TOhmWggRnanUfEsplLKpAmu/683RZpVitzMm1dbG29orFKFqva55fKzZI" +
       "l+FLGzxRRoawYq2o7ruLsi8stf4islbWghcVRm7WsUpiYTCGSf4IQmoVotYz" +
       "ySk/nlc20ciJLNTru/2ulTbgTU9cbajRajJB47Lh9hrLidimB5OlVYnNcMKT" +
       "hBiULMgtMQOTm3pRedHtihVrurQmI8q0xqsI609LAd8PaKMkmt6c6JcZn6lp" +
       "MwFPiQEpYGwligNeBiXjiGgeyghmT61BCa2IiJUk1LS0KpfduOTLY1FHNq5U" +
       "9CukOU1r7pCezBWRE+WBPLbTSFiVUnIT1yJmxEBT1l2Oxpu+NRZNoiu6oSFF" +
       "TqWndGgvTDSiPDVTLOn7BjUQl5S8wlZGKFdZvsLFpaaOlmnSRxxKWpYHw9oc" +
       "JpZyP7F7VB9rL6abVjeV9fVAHHPRDJ2WSku33RqMp3GpNmmo1RLV8exIKPHr" +
       "atmaM1AoJFWMKneG5THhrTyrPO2V4Andby2qfMMZu5pZ6c+wmYWvIl0vD00H" +
       "pab9lTiaII36tGJxtIhj/TDs6Q0dDosEI03itDbqyb6E2w3RGy1NS1zBwmTk" +
       "VCioXyxPkUG9wQb1jmQwsj5H2zHtrCZ06pgBWbFwv2davMerJWeyYalAE4eb" +
       "RstDhEq/LIUmWZ4OVxFO0sGsgk8mLCaPpvqaMFWj6Xv8zJI6zTmcDPsCG260" +
       "7lp2qgNJ7HYhoRYpTcoixsMenwx7S0gxnaHS7OPVSogQltbGZkFlHqTh0DFX" +
       "/HLMSiQ+kVJI7rSkmsl447oz4eFOcdaKWItRUCtNI2NUGnbFJuK3iqkNhmAC" +
       "tHZgn7VIu86mS9rt4oDWysyc2wLRrg4ZdukhM7Vm9DvSkg81utcWi22bkjZl" +
       "V9xEfbrtIpZAifion6S4XqxCKrX2fZNjh7XBxhCHnVAbK01oNhYmcg1jR57V" +
       "Dyadfr87CfuOs6LH5X6vCRyBAe0v1ktLHEeJNq179ZE88brG2IMkk3YglDR8" +
       "b9HqDx08qo28aZ2JFMX0EE0Vq4PWhjDgTWcIUwZVWaNjh2K6Sg0TamZPl80y" +
       "1zObos+MRvgyLve1GWLEdqk1tsdhWRcq64pQ1H0/ndWkKRM09BniD3CEa/Zt" +
       "Z8KmxLTEuQaynMU+J00oaT3ghrort019DvlQBaE3BmVZXNJvIu4yUOKZh/WZ" +
       "ieW6/JKuw+v1cJM4qFoj0yazHAVkNw4NdEMkmCAua9ESHG1w3oSLHrrcsIMW" +
       "We1L2mIWocQimouNJNY4tkJFFSNYV+YDW1zwwUhF1w0JNjdtx55vBp7cruAw" +
       "NqvDscqFbhktSkK/uOENfcC5ukt2SR7xZHjWVlM+BS7BsEFCOJHoMpIsl+14" +
       "2sSGLbJeXGpVoV6uzHlV0ItcU5RacokqT9YjqjLWxkU7rIwpc1KGIBcusdW6" +
       "QsmcC6diW18KImxFTk2ElvOyXizSKRJEHEYhSR+RQPU3uLirzWmbF9EWNtLG" +
       "UBdVOxQ5l+lp323QbcUKcdtDlqsi0+x7mMYXw7LmUZ1JCVqPnK5JzsSi1GKU" +
       "aTmwKpWo68mN2EmwNWGM5ku+RCrQbOJjWmUNQdSMX3lVOu2N1dm8FM68coVl" +
       "mYBqJGUWG0cbCU7NxnjDaVNSqlS1ddSupQpfhGk5gLvqtBttGvOYZ1okD3Wr" +
       "dujXkzQMSMGdbphFlGzabaXUSh0Pd4wVOu0NQZNutFQpMgNTJnTP7LaIcT0o" +
       "NmeSWMfrfUHyWpA6gDxrtlbZEV4NiUpfWsZGhemJcVnVuXW9Jq+7zBBDMRUY" +
       "ulW8WuqsN0SiearNh8y03sNms8UcVWoiKUF0JLBiUcBgFmomiN8jebdswaMh" +
       "Txh1e8wlSW0h1/Cg3i5Nw9pcgKqtutUS4hqcqlgxIruYXtSg7nLKLJUNupxX" +
       "JdPU5p1gZoQrsU/W0CqmBqugrG5IjYVH4/mgFpGjEtEjJ02DJDdWZdpv2Oh6" +
       "RTQ0Spj4xQoCYRqzsZwybvjD1sQzZvYkMEo20lnM2Fa/wgcR7TGaQpFKxJUm" +
       "6doYdAVbX8mYGw+rk0pfmZtMoHBJHUJ7vXoTq1nKakJZPUoT57N0jDlqlZjw" +
       "6QpPKAztq5JXxNz+jEDn0AhuzixlJsG1Ro2NkQ3u9DGtWhLUFqNL89V0VOOq" +
       "LjTxOr0l7g71yF3ZtlMzqkUU7SwUos+Vk5VU2hhrZCoSTFpbxGiNr+JYFV5V" +
       "1xBXt5Ea6mIbdl6cb6rzMjdHKW0aDiMJg+o9GtU9ieYMCrS1RSXRqwoz7yxq" +
       "NuvVyYVaFivCJqngs1U5VSgMErCy4orhKsUNe93tc8t5e85TXuhiBK3gDWKe" +
       "LvimqMdIbW4P/GalRsk1tt/jsGpYT6dUca2gChTRmqy2oSGC1clZSAf6NEDo" +
       "+tLUzIjBSX80dwPfFJiBTUznZFhnw1rDrYlpGylhHJ4MgpXo0nbdZ1c9ZjqG" +
       "HXYIXIHGjMa6KKZLE0z2gUGd9PSg5/L0qOMPhLqrGBN/hcwYUSSiymLBxeW6" +
       "GQsy4qntFRkZG4LT09qYdunZGuoNRpg6psROX086I0t3ldG6HPQQVme4MJza" +
       "juWViUBHiQS0YtpuOlXaCkeItp6yMF5c4Z4SIFSqjNdcfe5BY7hW64i6Twms" +
       "JCBcpzNZY+SCgJhOpToqklpCwNBCXvttrqiTUJNahLN5G8UILPXZpRvzIlTi" +
       "Z8uQWHOs6a+LCoUysYI2NdGacFoYFakkqqdInaAmtkFxm55lqqQQTSWaaQb8" +
       "xGdKXKnT9xJ4XW5HQDerXt2vTzxmI1bXDN0DZqmuaZxoVAcViE26/MRVqpLo" +
       "ecAnCkJ4PeN5SWE5U9p0xUlotSG3rGhY1aEGZI9xW31laCFMv1TpVVlEmntS" +
       "ncOrVgp6diqIG7M10yi3YW4aUAJed/r12CzFPYcul0TLHwQINyVsmU4NacZU" +
       "S42KyZZMP6J7QioVO3WqWZZpO+BHfdsK1T5rxP2e1LKBtpaHLYFehQvDiFhV" +
       "dID3uNms28WlwNfnZMNf1Ka9co3F2xCv6CpHVLqbVirWuoTI6Pym0pu6NXda" +
       "LNqwL5JVbrEKzVGZR7B5eTLtFNVwNSX4VE00vBRzNRS4grFAF/0pX4Zretpj" +
       "Ukln5sBiN4BbtVxPdULmnBU86K7xnrUSGX8ADbTOlKBwGtHasctVm0yZxhO8" +
       "zZUouFz3ZyMG+PahKOChn+LtZQ9obtIiSrYzJ5chJfOtMWLOhrN2zCuSogzw" +
       "UoNjZ9OqvJpiMNzxsbi0mvq1Ok90E6eLL21vzk2QSWhETjOcjWpTG41DBDjY" +
       "deAca9ba7m6KqhzhuGZTjc5yOKHhlZYg0ILDIZgxfShNkqpCqaMhaWEYgxa5" +
       "ckezoXI8pH0EHaxXqjF0kkoXGZYniOGE6VqwzZlouLPyGIzKNUvBIGXJzStq" +
       "dc3V6gi6dLhRecynI9QYcsHA0OWQNla99cyKOq112QsdOq6IFVUpVsIlXCmx" +
       "fc0fzNyKNDPxCgwVKyTc4imsOG1M4eaC5tcYSscMHMCNuYYUGZitNFLMFFq6" +
       "M6K5Pt1ly2KnXQQ6YZe8/gwnVVFu6zBnzbiF1eYVX+9M67NOs86yrkbz6GRQ" +
       "9Ax6PW+ZvjfmyUCoMTA+bc1B4yAFRV93JM2lhxvExgQMWrdiVXJaEwLtlUKk" +
       "iY48vMm0+UktiQZryJSKpSoY0EtosVmzGNCXaVl8rx1qUgI3UjZqU022DIfz" +
       "sq1Y3ZXP2q7g2bGcDNBYCJxFUqFHWhJvWElZllwz5mSY5xY1lezVPIcpc62w" +
       "WwTapNFttGVVlu6i2vC0pKXhyzZbrPYG2hreiGSdmCldUW5mQ6oijsCqvYlk" +
       "fWy43X5Jac7JurQqeZC/WE15uC7W0XprWRr24bRvxdxYiqGmpHI6CoZouLTq" +
       "SO2ZM8BpugW1x3yllixmM9KnN92lATP1ppmuA9mDOglcHZWnjfnM0ecDpx9w" +
       "JS9pVGYjfkGa2iQcjeqBm2ikUKN6ZIVuLB2BTE1aSToYgay7qd1viOlqABxd" +
       "PC3So2m9NZopM2tQGXMEsKPxGjh7S0U3KyTaKXLsclCrATutz+qgo5aYYIz6" +
       "q5ZTNnDYSueddNQVzQ1R5AO6I683SUh29YiaJcLGqetdYr7qOFGx5aFuiLVR" +
       "QeyyLR2XJ0MDjvEVulAorTVLxkKH4MGIR6oU42UT7Y0S1PachjAL9PqoOzbj" +
       "9oZcQhtuWN8MYZW2+/CI5xsTb6pN/LjI2X3N4xOtnLKam+p8BYcoxlj5jLBY" +
       "lvRgY1bL8Bito93NsO6UXAXBAmrhpAJJLr2Np8WMiqw2INdZWIVWa7G0rvar" +
       "WLFK9qx5YNcEP5xzSFBZs7AuFFVMjkC3KmHDchGaDAeMBYZVRFpqEuUSyi5Q" +
       "VWM1uL9hbQ5va2NXhhtqswvFtQXUKDdYLaxJnamP4ek0nS/WoZpWuzOy6HUm" +
       "tlfaDFJhTo0jU4MWUSOJFqxrDSecNaQGsjvuKZMlxkvl6XLQ6yKDLlML+3Ej" +
       "qhK+4rUlbzpet5hFj7HqtU5XsgVxPZF4q2EFxRJRUxdrF3P1lT/zdKpYGrts" +
       "ubXiiZUsbUbtMcFDA78iOjBObJZMUCJ0qDoe19X2GIZnxjR2iDCooTHbMeSw" +
       "2ZqUYKuylklNCFKJKa7jId9ttOjQb7DVBQvVuc642RzJ/ZKFEPKM7VBQVaq0" +
       "Ai2l5uJCqzKwk5TlWputS2lUVzsLtDxCZljZMiK03ojS+liJiXhYpJVJPbZd" +
       "MsIMop3UDYHqdmuCvOKF9qpb7DYaRl/2YlJad8Hwoc/WiNaIpRUOEWzGFkxT" +
       "rfWYOBWbVDwYimKT18eLFd8bxT2OEZZ8DBUjuSF0ILHVWJUUniNaA2kuzR0i" +
       "6iltQgJDZHvU4rvVUmbI2IVKy8B1kDeqteyCcVjLbQmOAzou0V4QwN50aMKv" +
       "+i7aI7gSYrjYDOEG6ADombAKiLUR90AP7Q8mJgrUOUiD4aoFN1rhqqG05sVK" +
       "OhHK4yGLxPWU7HXQKU7q40Tj+BEYGqdMCYqrKLVCWW0A28Cz7/O1QdQcjtp1" +
       "g0lxltJdjixV6XA8T7QBYgyAWzQW4/Zo");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("tIlWEwtBOIIzOnwNgIx9vqKQMqvDQX+GNIWGN0lrROSbNDyTaWIKrGDbl3iy" +
       "RFmap9ahbijCAt4OmptlMd70U9QxFWoQzjt9rhN3SpbSi3i+uEYWCi75ONbT" +
       "5ijsElQsg2GmnDZQb4Tp3hLlVxtnpi7hCU0G/UTA5iLRb2xkd1qvUuJqUW7V" +
       "Yq80rqESohHrRGAny7S7IfUq1y1hZRqMgg1LJyq1skdbMmFg0+FmbZeGNYYf" +
       "djuRsqqA3sIZpkEZjM2btf7EQWsuZkDt0sS2PdVzijPc9LjVIh6Zhh8v9Tpc" +
       "WvFN4CcMls0xb4AKFaYU0RatGSsapXanjRkeWZ8IC0PtOx2cZXuLPo80LIrl" +
       "23gbcVfozN80EcVc+K3Y9tyB1QmgYdWSgnWzoo57iBfLyBAHemzabS1MeIqh" +
       "elNKtDaBH9KtaBOShtCHFbtDo85o2dVH8MheeZrX7UtCud8obYaL1mApDhOR" +
       "71bMGgvTTGNjFe1+KVHjUQ81RGHiouqs7iZ62UX76cakGRqKdR8Bw3NiNQmo" +
       "EptI0yZd61tmXyhFOMPoI9rwk7kZCXaXI9HeChHbUntJUwFZJGDX9iNXpxaT" +
       "UdfvY/YCMNmqJWo0i6utydSQyuOxa1WTrmtimO17VWPu6JX+1KwirZo1GxjR" +
       "qONV6KFZmYnzSIe1AJe0kRi2XKEyH/MIU/IEPQTWMrb4IQFLRhIGtDHWWmu8" +
       "Lg9hBfNSxvd0Gl+XpHLPr3aMEjrWpbSUeBq58JH+alpbBUuiZrZdJVG6xXZ5" +
       "uuDrjZJqibY8WUOtwUZi8MogKVFQX5/jddLl2IYRWsBHtRcVdeh2lrVaPZnE" +
       "apPtA3e7G5ExW0ESoY+29TXdnaV9l4cs2EnXFDZptKBVj4jlZruIhmoSSU5x" +
       "vE7XKBjTNPubxQhhohBdxkJoBswI+HujTXk60FBSHje52PQ0o9OWiQ6MtpMJ" +
       "WZ83Et521bhL1FdMsiyNPb1B1Jyo0tZqDRglOrHZdMRFMI9R0vL0uoDFMbWC" +
       "YN9Y4RN2WJHm1aUIiUlVi9F+O1FsfaLLvG81eX/RirtNF5LRlUgNjaTLBLyP" +
       "M1TUgENuWl9YQ1Ksyh3ZsJEhidPN+kY3iX4TV3Fu4fGI1W+hPYnUxUSgp4RK" +
       "JyY+bAF3dQUXm115ZMx0uNrRuSGJwC176jawdQvX4VVp7Je9VWIFXDxO0WmV" +
       "mHndcV8IBF1oTtWWiHg8uD6W23hxsyiKCOm5bKkUzatGVaXiBkPISrPUlstl" +
       "mLQNr6mR8WrWIteAi5mIewtY0SVooYPxgt5J9ZLOLCmHjZkU2G1l1NbQntXQ" +
       "aWygEdR6YQ/lBhTIA8qne2p7BEcxMWC1rmAyXSiUx0I1ReHeZGaQE7wP2asB" +
       "rur9bkfs91ojZbBE6viAMuozbADyIjYjqAjPWmmXtft6Ax65jUpjPC1DY6s5" +
       "x0J4KWjCkiymKjmgZUFimEZjjPlWo8MhVAP4RnFLl1XOShnO61SW85rm+awi" +
       "CqXFQDA9c97obuDmoCY3pekKa0zokYswA1FO1/Ol1RsZKCvDQQPnoilPOgFH" +
       "spw8GWBEl7NUhRQ7XF9oCkNZrwBfFAz0SMWMOvKAFAQSnjZE3bYk3dbrXLOE" +
       "TeodeNYZB51JZ0PPFgTcQaJ+xwsFetZzIqLdZfC05XImHxVl0Yy0dgltjih5" +
       "SQlGX3cGZsepV6sqcOOdwdLDrKGXbHCDDQNzFkx5Q26OIqFB+QFfdN0GUYzh" +
       "5axZwd3EpRcsMxb1ecBwfIgYFL7ZrMw636+xZlMWXXzAN7VoFKOG55XhAVWl" +
       "wEhsbhuG6rmGQ/B9IzDQkVOfa8B/hWNTqEt9deaWym3EW0krtNaqLTB71i2S" +
       "9fIKLfNd2fdLMDEa4xzbag2pEdd16Tg2WZrtphPZKbZ6luYsrB60oOJJOXWV" +
       "qdlru/qEI4Y9yplLQ2FGYWaJoWYU0O8NuRoIQVlfdCl0xQgteCktp/36YOph" +
       "pUmtuWRLzkgfwg2ywYiQQSzS2coHvinWljuSgrVksdxxPZFp8hhpdisVUw4k" +
       "pjnmjDEdMcx0ES8ZwTARzW7D5bbQpGekbi36astF/XBcHfqNcjUG1nE1IFCB" +
       "JmnbMIOA1n20lLrhWlrNJAj3adOjN+gQdCemZq4aHSTFYRmlU1pUlzWHFiI6" +
       "XARFdqxjaKc5qMpwL1V4waoN0PZiPdQJqtMNe0kf8dzlHIfq6LjacdYNHZ7S" +
       "fRjtFUFP2GKM1PKaCtGlGwhfbqNjmuvyhkPzxCLs23WRwcXeBkKaPWe8ikGr" +
       "ikR6MW2tlklUWRoyGpu63e3LQcK1bB1ZshTZce2ZPeLHJO2l1aVtO02dY2F0" +
       "miQVrW0tZ/zEHqxxFgzZpBEJYfFkbuEDMNRYeIFTY+XOgtp04YVFma2VCBGG" +
       "KPm+rpWJUnm2cDolju8MYHRUH+sohQ50ElWSCUFNWrPxYIrS3ag1cfxqYniz" +
       "mWEO4AawNZy1jCSzuuK6/prjyQpXa8KbTXeC+aRpRmIbssVkxXKzCGYmWkmB" +
       "kXY6icFlN24ji43B8qMh5yswv+TqnFBsjweb5UBF4Zj0caSrYjMZCpz6Wm83" +
       "yuMJHGvTdUWEBqoum2nFsCaDklsWJmrNWyAYkiaM3u17azd1SWcoiN5AadXn" +
       "3RDnp8CDSaB5pKGEU+rx80Dvldx1SkNzJEhVezD2XaFULOJ6F9vQJXIdDIvo" +
       "VOrxkcU3pxiltOThpo02SqJlgzFthTacFFtJ4lCpJ/oCtmhBisXA89QuNEzG" +
       "WKs2J0upp5qSFurFoA47sw5VjlK0RqXrykpDEnOCJDEciIKe9ucK15GkDux0" +
       "+nTdMNnpdOKLbl0Kh+24MquTNXFaSSaVuVAbSgg9G48HpbBn9NYrJkoVP5jO" +
       "lTXZWW4QPKxvzNpgSPBtQ9annmLxGpxYgxU6FxmPQLxWu6i4po7UoKi+3GBI" +
       "qELRsLoakSWxoxhkcVydSKMBMYfKm5Eyj6oCRm7GG79rjXvrTmlo+wQCUaE3" +
       "mpnroNplVXXt4yHl1vta7CAtFBGTJJmYiwVeo9eBT1oDayXaSJLULRLGFA8M" +
       "zwwfp4eoYgzWHuvgvh8t1QntB0wizmhaL1UqjIVOQ01UZ6iplClLGVTrc9SE" +
       "IRyCoJhc8BK9USvZI+nnn88eU//E7T0+f0W+KuBkC8FfYz1AsmdpyofDwr3S" +
       "bsHf6SrW/O/Bwm4t+vH/M4syzizaOzpeZ/FYts4irspn167sFmQfR3n7Tde5" +
       "4Emo2oqq5EvEGvkizeNEb70wkWQb1jXQlLcryUb5mpRskdPjN9vAkC9w+vgH" +
       "P/qiwv5k+XC3dFHNVnQ57jtMda2aZ0A9B3J6280Xc9H5/o3T5YC/9sH/57HR" +
       "Oxfffhurwd9wrpzns/z79Cc/R7xZ/sHDwtHJ4sAbdpZcn+jZ65cE3u+rYeTb" +
       "o+sWBj5+48KbD+zq+APnF96cqtjeVTd7VoZ+Zk/Y/5mJfxQWXmfYRpjv4lEb" +
       "pkkZa7URhr4xj0I1uHB9yNoxlFPF/4XbWWyaX/j0CQUPZxdfA44f2FHwA7dL" +
       "wYe/IQW/uSfstzLxa2HhbqC7XSVv1qfAfv0SwB7ILj4Jjhd3wF68GmAHpxHe" +
       "lUf4t3vQ/UEm/hVAFxyj+6VTdL972WrL1gn+9A7dT199tf37PWH/IRNfCAv3" +
       "g2oTaGouBeq5uvviZevubeD4uR26n7tDdfenF0c4NruPnjXnbZbGE1l1M6OW" +
       "J/5PmfhytpjxOg7O1PBXLsHBa7OLRXD84o6DX7z6Gv7Lm4cd5Lf6r2HhYVDD" +
       "bGyr/o1d2eMX9HbnYuU0/MUlaHh1dvGbwPG5HQ2fu3IaDl66JyzbXHHwki0N" +
       "E0ONXccPdwCz6J84QXlw72Wb8+Pg+L0dyt+7epSP7gl7LBOPhIUHAErGUVRm" +
       "14WetueDV14W3hvB8Yc7eH949fCe3hP25ky8ISw8mMED0ALgSanjQfccxCcv" +
       "a7IyPf2THcQ/uRqI503WQenmEf5zHiGHUgROHTBL3Mn671OrdPD2S8DMt1K8" +
       "BdzvYJt2+/92YF7sMZ0zvA+dtSyZQubInttTxdmq3IP6tp22pECWgCMNjHLz" +
       "ho7pAL1sLb8DFLS8g1++8lpe53B6e6BSmcDDwstABV+/Nv5MJXcua3OfAuVB" +
       "dyjRq2+ukz1hQiZ4AFA/D3B9CnBwCYD5jgbgXxw0dgAbVwPw6Mxo8JzLfnew" +
       "AD3HVhX9wjM3H1flew63e15e/F+e+q3vePGpL+Xb9u41gonkN3z9gh3qZ9L8" +
       "6Se/8OXfednjP5Pvbr3r2Ce5//zW/ht37l+3IT9H91I3OWmPpwvjt7u1Lmy4" +
       "XXe3UeHAvJi67XA7EydD+3tM1dbDxUWUHRl5H3uw2JXjgm19j5yWq2U6tppt" +
       "kDoO2+58NpxrJ29IAIHJhQX/tJvr3eJSGv2+PWHfkYkN0AI5K+UW1J7oH0y2" +
       "/+d74vytTLwbGDzZV6VQzfyuY+/0mIHXXzQbcV2kvCW95xIt6ZHsInBcDthd" +
       "S2Kv3lR8ZE/YD2biQ2G22XCw24OWRZNP0f1PlzX3bwYFnezQTa4G3RlzL+cw" +
       "PrYH4ouZ+FHgmwFzfxbjGWP/Y5fAmLllBQyU5t07jO++XYzfcA7k4O/tCfup" +
       "TPxdMNYCxv785siTDY+TU6wfvwTWbPNjgQTFVndY1avBenQ6e/muU5HD+7k9" +
       "0P9hJj4VFt6wbcL5vE8+m5fPAdpBxkO2x+y4PVf3v/nh5mlz4n72EsQ9lV18" +
       "LjOXO+KCO0jctkn88h7ifjUTnwkLr72RuOZ2B+YxZTdufLuQsrOpcrL+8SXI" +
       "elN28ZsB7t2s4sEVzSoenvahZxTst/fw9DuZ+A3Qtm7k6fpd8DeflL6OpjOJ" +
       "cpZ+8xIsvTS7CNzng4/sWPrI1dudz+8J+2Imfj8sPHMjN2DUFKg++B24wNUZ" +
       "ZKbomCjs1oi6WQ45a39wWdYgQMBuVvPgtmc1b0e3vrKHv/+YiT8KC0/dyB8t" +
       "+SvVZ/1si3i+3/+YvfqtsXdx+py7P74sd1lv/skdd5+8g0ZsS+Bf7CHwv2Xi" +
       "v4SFxy5QQClctKVQOubt2i1q3dlkOV1/dhVm7Bd2dP3CHaIrDzk/XNJMR8rf" +
       "L3B47805PMw29h8eXWjgtht4b9PAnUmU8Xd411Xw98s7/n75avi7K49w13Xq" +
       "dnifd9xxHr52D1+vy8Qr9/CVhT94iv9Vl8D/5uxiE0D57R3+375z+M84DofP" +
       "7MH/lkw8CUZGN8N/1t0q3Y7OXOdrHb7xKvTm8zvePn+nzdRhdQ9lSCauXagy" +
       "nANG6CfPqG+xiZ1JlFMFXYWKfWVH1Veuhqq78wh3X6RimVXd6lljD2mtTDx3" +
       "oZ5R+XzHX0PPziXMyXv+Knz6r+/I+/qd07ODfILlkN1DGZ+J3oU+fdcOVf3U" +
       "lt+iT382VU5W/xJkvSW72AYe0n3btNv/d8CYZSEH2sl9X5ndJntj1m6+ffs/" +
       "LLxw4xuGvvlJL5ICw4ucUP2m7Ss2nty+sOjJ/BUbT269929995M028ZfYBo0" +
       "Pnzy+SdtNd6FvFey5u/71mvXrr372be6eYXt+uYb5vkyNl/YzfUdzi8GfcNc" +
       "XwbMyXUhS/WeGyf1srB8wm99k1m67W3z1Fm0dI82GXvCVpnIXq9x8J3bkuyJ" +
       "ayWF0xb/7j0RM2SHQlh4/Eb1zV4alFXRmZm58q2p8PmUuRrPrqBvOXzNTo1f" +
       "c4cN5kH+mpctfe/dQ9/7MrG+sJehTieIb72XOZMoJy2+BGlPZhdrgKxndqQ9" +
       "c+cM5a5D/tt7qPpQJv5WWHj1jVQNjmfmAVFvuzWiTpLkNH3XZaeCnwD0VHc0" +
       "VW+Xplt7Anr4o3vI+TuZ+MGw8MBCCjjfyd96nGvgKcYfuizG1wFsz+8wPn81" +
       "GC8cfh/+3T1AfzITL4aFewHQfNr0HMqfuCxK0OMd4juU+B2qyU/tAfgPMvFT" +
       "YeGVxklFbnX2eE74DNhPXHadDQg/FHZghdsAe0Mnd0v1+ot7YH8mE/8wLLzK" +
       "CE7WAN4U989ftpKBJTtUdriVO1TJv7YH7ecy8cth4eEzlawo+Qv5zkH9lctC" +
       "fXNWGzuo8Z1stf9qD95/nYnfCguPnK3diwH/i8sCfhoU7f07wO+/k4C/sAfw" +
       "lzLxB2HhFcbWSt1Ulf/dZeEC1+bwu3dwv/tOwv3yHrhfzcR/CAsPHsO9uG7/" +
       "6BJgsyXpeTf74R3YD9+hdvvne3D+10z8p+2CquOGu1tkfeCe4vzPl11plNmn" +
       "H9/h/PHbwPnXsstHRzdHfJT5tod/GRYeAohPmu4FkP/qCh6mH35iB/kTV1O1" +
       "Z3E8uCfsFZm4f7uo99xSz0fOLiU4v8Dz6IHLPmNvAbC7tb6HV7TW92wVH6O4" +
       "cfCQb6HIX/8YXDu1TflDh5ySx/fQlb2h+uhRwE3kKsCVPm4HeeIs/ukD+qPX" +
       "XpYgDEDZLQQ+/N+vhqCLhh9HT+TIintQvyMTbwZ+2Rb1SVu4CPZbLgu7CeD+" +
       "6g72r169Xpwiru9BjGWiApr+FjEbLlT/IrTVS6B9XXbxHaBc/2yH9p/dEbQ7" +
       "Q9fagxbPxDu3CynHtqL65saw9WO8R0+c4n3XJfBmH/vIVuAd7hY8H972gue9" +
       "zzGPG/ybLlgBdW5+MEPC5cj3zE4eDTPRCwsvBaxka0ov4uMy84snfHxpx8eX" +
       "7ggfb9zDx8kDoKP8Nc1He2a7jqRMCPvpuMw8Vb4B7+2g4F/e0fHlq2kON19v" +
       "crTaA9fKhBYWXpe5O6ovg85P0tVMgXzXV7f73LxssusUvX4J9Nl8b+GdoJyH" +
       "27Tb/7eI/vRt27fj+sR70GcTKEd+WHj6rOtzizQEl3WHygD+AzsaHrgaJTiL" +
       "7W/uCfuuTLw/LDwRBWr2qSPJHxDNlmNmX5zJIDvmMeIzvv3Rd1xW7d8AkD66" +
       "Q/zoVat9/qD44PQp1tH37yHgBzLxfWHh5cBSjJxxoPrDbONEns0p4A9dtpN/" +
       "DhTtbTvAb70awBc+I5aPreDFs+8X7aY9fsN7Tsf/vIeqn8jEj4BxrqQo1yfN" +
       "Yp9xEn70smy9C7D03I6t81uSr5StrLQfy8H9/T3AP5GJjwN30FctZ63uxf6T" +
       "l8CeXwRe8BGxw07cBvbCbVjCT+8B+/OZ+Nmw8Jhm+GrW752Yw+s+BXAG8j+4" +
       "rP17LYC6+17H0Q3f6/hG1f2N1nod5JvxGzm2X9qD+1cy8X+EhXvUxN3uYjh4" +
       "/hTjZ65gyHs032Gc30mM/3wPxn+RiV8Hg19FVV38Ipyfu4IHB0f2Dqd9NThP" +
       "Z20Ons9h/P4eiP8uE78bFu6VHXcD+jDnHMB/fVmAWdeV7gCmdwjg/70H4B9l" +
       "4ovALc3qsHUxyC/dDsgE5HX2q3rZ98EeveEjntsPT8o/8+KD977mxfHvbbfe" +
       "HH8c8j6qcK8WmebZDxWdOT/ziZb7cvny/Mn70X/c7T6+6AleWDgCMivs0Ve3" +
       "sb8GDPBFsUFMIM/G/H93m+vOxgwLd+f/z8b7c9ASTuOBpr89ORvlL0DuIEp2" +
       "+nX3uG+98TtGx0ON429q7ahMtg/1Hz2rTvlu4Ye/UQWdJDn73bpsH1X+Edbj" +
       "d0lE28+wviB/6sUe896v1X5y+9082ZTSNMvlXqrwku0n/PJMs/dRvPGmuR3n" +
       "dQ/51q+//Gfve+b43Rkv3xb4VLXPlO0NF3+hDrfcMP+mXPqPXvNzz/2vL34+" +
       "/7bIfwdgjDysHXcAAA==");
}
