package org.apache.batik.dom.svg;
public class SVGOMSVGElement extends org.apache.batik.dom.svg.SVGStylableElement implements org.w3c.dom.svg.SVGSVGElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGStylableElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_WIDTH_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_HEIGHT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_PRESERVE_ASPECT_RATIO_VALUE));
             t.put(null, SVG_VIEW_BOX_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_RECT));
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      7);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XMLSupport.
                                      XMLNS_NAMESPACE_URI,
                                    null,
                                    "xmlns",
                                    SVG_NAMESPACE_URI);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XMLSupport.
                                      XMLNS_NAMESPACE_URI,
                                    "xmlns",
                                    "xlink",
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                    "xMidYMid meet");
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_ZOOM_AND_PAN_ATTRIBUTE,
                                    SVG_MAGNIFY_VALUE);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_VERSION_ATTRIBUTE,
                                    SVG_VERSION);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_CONTENT_SCRIPT_TYPE_ATTRIBUTE,
                                    "text/ecmascript");
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_CONTENT_STYLE_TYPE_ATTRIBUTE,
                                    "text/css");
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      width;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      height;
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean
      externalResourcesRequired;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected org.apache.batik.dom.svg.SVGOMAnimatedRect
      viewBox;
    protected SVGOMSVGElement() { super();
    }
    public SVGOMSVGElement(java.lang.String prefix,
                           org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        x =
          createLiveAnimatedLength(
            null,
            SVG_X_ATTRIBUTE,
            SVG_SVG_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_SVG_Y_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        width =
          createLiveAnimatedLength(
            null,
            SVG_WIDTH_ATTRIBUTE,
            SVG_SVG_WIDTH_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            true);
        height =
          createLiveAnimatedLength(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            SVG_SVG_HEIGHT_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            true);
        externalResourcesRequired =
          createLiveAnimatedBoolean(
            null,
            SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
            false);
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
        viewBox =
          createLiveAnimatedRect(
            null,
            SVG_VIEW_BOX_ATTRIBUTE,
            null);
    }
    public java.lang.String getLocalName() {
        return SVG_SVG_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getWidth() {
        return width;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getHeight() {
        return height;
    }
    public java.lang.String getContentScriptType() {
        return getAttributeNS(
                 null,
                 SVG_CONTENT_SCRIPT_TYPE_ATTRIBUTE);
    }
    public void setContentScriptType(java.lang.String type) {
        setAttributeNS(
          null,
          SVG_CONTENT_SCRIPT_TYPE_ATTRIBUTE,
          type);
    }
    public java.lang.String getContentStyleType() {
        return getAttributeNS(
                 null,
                 SVG_CONTENT_STYLE_TYPE_ATTRIBUTE);
    }
    public void setContentStyleType(java.lang.String type) {
        setAttributeNS(
          null,
          SVG_CONTENT_STYLE_TYPE_ATTRIBUTE,
          type);
    }
    public org.w3c.dom.svg.SVGRect getViewport() {
        org.apache.batik.dom.svg.SVGContext ctx =
          getSVGContext(
            );
        return new org.apache.batik.dom.svg.SVGOMRect(
          0,
          0,
          ctx.
            getViewportWidth(
              ),
          ctx.
            getViewportHeight(
              ));
    }
    public float getPixelUnitToMillimeterX() {
        return getSVGContext(
                 ).
          getPixelUnitToMillimeter(
            );
    }
    public float getPixelUnitToMillimeterY() {
        return getSVGContext(
                 ).
          getPixelUnitToMillimeter(
            );
    }
    public float getScreenPixelToMillimeterX() {
        return getSVGContext(
                 ).
          getPixelUnitToMillimeter(
            );
    }
    public float getScreenPixelToMillimeterY() {
        return getSVGContext(
                 ).
          getPixelUnitToMillimeter(
            );
    }
    public boolean getUseCurrentView() { throw new java.lang.UnsupportedOperationException(
                                           "SVGSVGElement.getUseCurrentView is not implemented");
    }
    public void setUseCurrentView(boolean useCurrentView)
          throws org.w3c.dom.DOMException {
        throw new java.lang.UnsupportedOperationException(
          "SVGSVGElement.setUseCurrentView is not implemented");
    }
    public org.w3c.dom.svg.SVGViewSpec getCurrentView() {
        throw new java.lang.UnsupportedOperationException(
          "SVGSVGElement.getCurrentView is not implemented");
    }
    public float getCurrentScale() { java.awt.geom.AffineTransform scrnTrans =
                                       getSVGContext(
                                         ).
                                       getScreenTransform(
                                         );
                                     if (scrnTrans !=
                                           null) {
                                         return (float)
                                                  java.lang.Math.
                                                  sqrt(
                                                    scrnTrans.
                                                      getDeterminant(
                                                        ));
                                     }
                                     return 1;
    }
    public void setCurrentScale(float currentScale)
          throws org.w3c.dom.DOMException {
        org.apache.batik.dom.svg.SVGContext context =
          getSVGContext(
            );
        java.awt.geom.AffineTransform scrnTrans =
          context.
          getScreenTransform(
            );
        float scale =
          1;
        if (scrnTrans !=
              null) {
            scale =
              (float)
                java.lang.Math.
                sqrt(
                  scrnTrans.
                    getDeterminant(
                      ));
        }
        float delta =
          currentScale /
          scale;
        scrnTrans =
          new java.awt.geom.AffineTransform(
            scrnTrans.
              getScaleX(
                ) *
              delta,
            scrnTrans.
              getShearY(
                ) *
              delta,
            scrnTrans.
              getShearX(
                ) *
              delta,
            scrnTrans.
              getScaleY(
                ) *
              delta,
            scrnTrans.
              getTranslateX(
                ),
            scrnTrans.
              getTranslateY(
                ));
        context.
          setScreenTransform(
            scrnTrans);
    }
    public org.w3c.dom.svg.SVGPoint getCurrentTranslate() {
        return new org.w3c.dom.svg.SVGPoint(
          ) {
            protected java.awt.geom.AffineTransform getScreenTransform() {
                org.apache.batik.dom.svg.SVGContext context =
                  getSVGContext(
                    );
                return context.
                  getScreenTransform(
                    );
            }
            public float getX() {
                java.awt.geom.AffineTransform scrnTrans =
                  getScreenTransform(
                    );
                return (float)
                         scrnTrans.
                         getTranslateX(
                           );
            }
            public float getY() {
                java.awt.geom.AffineTransform scrnTrans =
                  getScreenTransform(
                    );
                return (float)
                         scrnTrans.
                         getTranslateY(
                           );
            }
            public void setX(float newX) {
                org.apache.batik.dom.svg.SVGContext context =
                  getSVGContext(
                    );
                java.awt.geom.AffineTransform scrnTrans =
                  context.
                  getScreenTransform(
                    );
                scrnTrans =
                  new java.awt.geom.AffineTransform(
                    scrnTrans.
                      getScaleX(
                        ),
                    scrnTrans.
                      getShearY(
                        ),
                    scrnTrans.
                      getShearX(
                        ),
                    scrnTrans.
                      getScaleY(
                        ),
                    newX,
                    scrnTrans.
                      getTranslateY(
                        ));
                context.
                  setScreenTransform(
                    scrnTrans);
            }
            public void setY(float newY) {
                org.apache.batik.dom.svg.SVGContext context =
                  getSVGContext(
                    );
                java.awt.geom.AffineTransform scrnTrans =
                  context.
                  getScreenTransform(
                    );
                scrnTrans =
                  new java.awt.geom.AffineTransform(
                    scrnTrans.
                      getScaleX(
                        ),
                    scrnTrans.
                      getShearY(
                        ),
                    scrnTrans.
                      getShearX(
                        ),
                    scrnTrans.
                      getScaleY(
                        ),
                    scrnTrans.
                      getTranslateX(
                        ),
                    newY);
                context.
                  setScreenTransform(
                    scrnTrans);
            }
            public org.w3c.dom.svg.SVGPoint matrixTransform(org.w3c.dom.svg.SVGMatrix mat) {
                java.awt.geom.AffineTransform scrnTrans =
                  getScreenTransform(
                    );
                float x =
                  (float)
                    scrnTrans.
                    getTranslateX(
                      );
                float y =
                  (float)
                    scrnTrans.
                    getTranslateY(
                      );
                float newX =
                  mat.
                  getA(
                    ) *
                  x +
                  mat.
                  getC(
                    ) *
                  y +
                  mat.
                  getE(
                    );
                float newY =
                  mat.
                  getB(
                    ) *
                  x +
                  mat.
                  getD(
                    ) *
                  y +
                  mat.
                  getF(
                    );
                return new org.apache.batik.dom.svg.SVGOMPoint(
                  newX,
                  newY);
            }
        };
    }
    public int suspendRedraw(int max_wait_milliseconds) {
        if (max_wait_milliseconds >
              60000) {
            max_wait_milliseconds =
              60000;
        }
        else
            if (max_wait_milliseconds <
                  0) {
                max_wait_milliseconds =
                  0;
            }
        org.apache.batik.dom.svg.SVGSVGContext ctx =
          (org.apache.batik.dom.svg.SVGSVGContext)
            getSVGContext(
              );
        return ctx.
          suspendRedraw(
            max_wait_milliseconds);
    }
    public void unsuspendRedraw(int suspend_handle_id)
          throws org.w3c.dom.DOMException {
        org.apache.batik.dom.svg.SVGSVGContext ctx =
          (org.apache.batik.dom.svg.SVGSVGContext)
            getSVGContext(
              );
        if (!ctx.
              unsuspendRedraw(
                suspend_handle_id)) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      NOT_FOUND_ERR,
                    "invalid.suspend.handle",
                    new java.lang.Object[] { new java.lang.Integer(
                      suspend_handle_id) });
        }
    }
    public void unsuspendRedrawAll() { org.apache.batik.dom.svg.SVGSVGContext ctx =
                                         (org.apache.batik.dom.svg.SVGSVGContext)
                                           getSVGContext(
                                             );
                                       ctx.
                                         unsuspendRedrawAll(
                                           );
    }
    public void forceRedraw() { org.apache.batik.dom.svg.SVGSVGContext ctx =
                                  (org.apache.batik.dom.svg.SVGSVGContext)
                                    getSVGContext(
                                      );
                                ctx.forceRedraw(
                                      ); }
    public void pauseAnimations() { org.apache.batik.dom.svg.SVGSVGContext ctx =
                                      (org.apache.batik.dom.svg.SVGSVGContext)
                                        getSVGContext(
                                          );
                                    ctx.pauseAnimations(
                                          );
    }
    public void unpauseAnimations() { org.apache.batik.dom.svg.SVGSVGContext ctx =
                                        (org.apache.batik.dom.svg.SVGSVGContext)
                                          getSVGContext(
                                            );
                                      ctx.
                                        unpauseAnimations(
                                          );
    }
    public boolean animationsPaused() { org.apache.batik.dom.svg.SVGSVGContext ctx =
                                          (org.apache.batik.dom.svg.SVGSVGContext)
                                            getSVGContext(
                                              );
                                        return ctx.
                                          animationsPaused(
                                            );
    }
    public float getCurrentTime() { org.apache.batik.dom.svg.SVGSVGContext ctx =
                                      (org.apache.batik.dom.svg.SVGSVGContext)
                                        getSVGContext(
                                          );
                                    return ctx.
                                      getCurrentTime(
                                        );
    }
    public void setCurrentTime(float seconds) {
        org.apache.batik.dom.svg.SVGSVGContext ctx =
          (org.apache.batik.dom.svg.SVGSVGContext)
            getSVGContext(
              );
        ctx.
          setCurrentTime(
            seconds);
    }
    public org.w3c.dom.NodeList getIntersectionList(org.w3c.dom.svg.SVGRect rect,
                                                    org.w3c.dom.svg.SVGElement referenceElement) {
        org.apache.batik.dom.svg.SVGSVGContext ctx =
          (org.apache.batik.dom.svg.SVGSVGContext)
            getSVGContext(
              );
        java.util.List list =
          ctx.
          getIntersectionList(
            rect,
            referenceElement);
        return new org.apache.batik.dom.util.ListNodeList(
          list);
    }
    public org.w3c.dom.NodeList getEnclosureList(org.w3c.dom.svg.SVGRect rect,
                                                 org.w3c.dom.svg.SVGElement referenceElement) {
        org.apache.batik.dom.svg.SVGSVGContext ctx =
          (org.apache.batik.dom.svg.SVGSVGContext)
            getSVGContext(
              );
        java.util.List list =
          ctx.
          getEnclosureList(
            rect,
            referenceElement);
        return new org.apache.batik.dom.util.ListNodeList(
          list);
    }
    public boolean checkIntersection(org.w3c.dom.svg.SVGElement element,
                                     org.w3c.dom.svg.SVGRect rect) {
        org.apache.batik.dom.svg.SVGSVGContext ctx =
          (org.apache.batik.dom.svg.SVGSVGContext)
            getSVGContext(
              );
        return ctx.
          checkIntersection(
            element,
            rect);
    }
    public boolean checkEnclosure(org.w3c.dom.svg.SVGElement element,
                                  org.w3c.dom.svg.SVGRect rect) {
        org.apache.batik.dom.svg.SVGSVGContext ctx =
          (org.apache.batik.dom.svg.SVGSVGContext)
            getSVGContext(
              );
        return ctx.
          checkEnclosure(
            element,
            rect);
    }
    public void deselectAll() { ((org.apache.batik.dom.svg.SVGSVGContext)
                                   getSVGContext(
                                     )).deselectAll(
                                          );
    }
    public org.w3c.dom.svg.SVGNumber createSVGNumber() {
        return new org.w3c.dom.svg.SVGNumber(
          ) {
            protected float
              value;
            public float getValue() {
                return value;
            }
            public void setValue(float f) {
                value =
                  f;
            }
        };
    }
    public org.w3c.dom.svg.SVGLength createSVGLength() {
        return new org.apache.batik.dom.svg.SVGOMLength(
          this);
    }
    public org.w3c.dom.svg.SVGAngle createSVGAngle() {
        return new org.apache.batik.dom.svg.SVGOMAngle(
          );
    }
    public org.w3c.dom.svg.SVGPoint createSVGPoint() {
        return new org.apache.batik.dom.svg.SVGOMPoint(
          0,
          0);
    }
    public org.w3c.dom.svg.SVGMatrix createSVGMatrix() {
        return new org.apache.batik.dom.svg.AbstractSVGMatrix(
          ) {
            protected java.awt.geom.AffineTransform
              at =
              new java.awt.geom.AffineTransform(
              );
            protected java.awt.geom.AffineTransform getAffineTransform() {
                return at;
            }
        };
    }
    public org.w3c.dom.svg.SVGRect createSVGRect() {
        return new org.apache.batik.dom.svg.SVGOMRect(
          0,
          0,
          0,
          0);
    }
    public org.w3c.dom.svg.SVGTransform createSVGTransform() {
        org.apache.batik.dom.svg.SVGOMTransform ret =
          new org.apache.batik.dom.svg.SVGOMTransform(
          );
        ret.
          setType(
            org.w3c.dom.svg.SVGTransform.
              SVG_TRANSFORM_MATRIX);
        return ret;
    }
    public org.w3c.dom.svg.SVGTransform createSVGTransformFromMatrix(org.w3c.dom.svg.SVGMatrix matrix) {
        org.apache.batik.dom.svg.SVGOMTransform tr =
          new org.apache.batik.dom.svg.SVGOMTransform(
          );
        tr.
          setMatrix(
            matrix);
        return tr;
    }
    public org.w3c.dom.Element getElementById(java.lang.String elementId) {
        return ownerDocument.
          getChildElementById(
            this,
            elementId);
    }
    public org.w3c.dom.svg.SVGElement getNearestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getNearestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGElement getFarthestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getFarthestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGRect getBBox() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getBBox(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getScreenCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getScreenCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getTransformToElement(org.w3c.dom.svg.SVGElement element)
          throws org.w3c.dom.svg.SVGException {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getTransformToElement(
            this,
            element);
    }
    public org.w3c.dom.views.DocumentView getDocument() {
        return (org.w3c.dom.views.DocumentView)
                 getOwnerDocument(
                   );
    }
    public org.w3c.dom.css.CSSStyleDeclaration getComputedStyle(org.w3c.dom.Element elt,
                                                                java.lang.String pseudoElt) {
        org.w3c.dom.views.AbstractView av =
          ((org.w3c.dom.views.DocumentView)
             getOwnerDocument(
               )).
          getDefaultView(
            );
        return ((org.w3c.dom.css.ViewCSS)
                  av).
          getComputedStyle(
            elt,
            pseudoElt);
    }
    public org.w3c.dom.events.Event createEvent(java.lang.String eventType)
          throws org.w3c.dom.DOMException {
        return ((org.w3c.dom.events.DocumentEvent)
                  getOwnerDocument(
                    )).
          createEvent(
            eventType);
    }
    public boolean canDispatch(java.lang.String namespaceURI,
                               java.lang.String type)
          throws org.w3c.dom.DOMException {
        org.apache.batik.dom.AbstractDocument doc =
          (org.apache.batik.dom.AbstractDocument)
            getOwnerDocument(
              );
        return doc.
          canDispatch(
            namespaceURI,
            type);
    }
    public org.w3c.dom.stylesheets.StyleSheetList getStyleSheets() {
        return ((org.w3c.dom.stylesheets.DocumentStyle)
                  getOwnerDocument(
                    )).
          getStyleSheets(
            );
    }
    public org.w3c.dom.css.CSSStyleDeclaration getOverrideStyle(org.w3c.dom.Element elt,
                                                                java.lang.String pseudoElt) {
        return ((org.w3c.dom.css.DocumentCSS)
                  getOwnerDocument(
                    )).
          getOverrideStyle(
            elt,
            pseudoElt);
    }
    public java.lang.String getXMLlang() {
        return org.apache.batik.dom.util.XMLSupport.
          getXMLLang(
            this);
    }
    public void setXMLlang(java.lang.String lang) {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_LANG_QNAME,
          lang);
    }
    public java.lang.String getXMLspace() {
        return org.apache.batik.dom.util.XMLSupport.
          getXMLSpace(
            this);
    }
    public void setXMLspace(java.lang.String space) {
        setAttributeNS(
          XML_NAMESPACE_URI,
          XML_SPACE_QNAME,
          space);
    }
    public short getZoomAndPan() { return org.apache.batik.dom.svg.SVGZoomAndPanSupport.
                                     getZoomAndPan(
                                       this);
    }
    public void setZoomAndPan(short val) {
        org.apache.batik.dom.svg.SVGZoomAndPanSupport.
          setZoomAndPan(
            this,
            val);
    }
    public org.w3c.dom.svg.SVGAnimatedRect getViewBox() {
        return viewBox;
    }
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    public org.w3c.dom.svg.SVGStringList getRequiredFeatures() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredFeatures(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getRequiredExtensions() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredExtensions(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getSystemLanguage() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getSystemLanguage(
            this);
    }
    public boolean hasExtension(java.lang.String extension) {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          hasExtension(
            this,
            extension);
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMSVGElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
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
       "e1Gy25Z9OP/rbtC4b7q1ee5mLtqZhXv4TylLeu/v/J/nKVBumG/imVw6XoA+" +
       "9uFHsC/5/fz4MwuZHf3Y+vljF3Bnz46tfK/9v49ed/vPHBXuEAr3yztfeSpa" +
       "UWZ3BOAfBicONPCnL+Rf9PW2js2zpyPAay9b53OXvWybz8ZM8Dsrnf2+65I5" +
       "fiiT8lvBRux0h7isjNcK+Q/65vp4lP18I1DKIPfId0r5efDvGtj+ItuyE2Y7" +
       "tq7LA9jOf3ri1IHywJD+4Nq2WF/Uw76TDymnLfXQzYb7vKO2XdAP0r6jqGtV" +
       "YTNbd9ZvckUbv5CiDU7F8JrCzskydmIwbiGGd9xcDMe5GLKEDUEr6I5o5YLm" +
       "wsIrxBD0Kgm46n0HDEnZlET1T9DecktPpnWToy7xvfPF8+Wj7lNge/+O7/23" +
       "4NNuYXZyvhOka+uT+r95vyfWcnQ7a2FSdRZbv/Zc9Rd/iep/y67633KL6rsv" +
       "qvpp9sO8VB3vJVbnjWD70K46H7pFdeIXU53bEl3ZCudylZKXWKU3ge3bd1X6" +
       "9ltU6d0vpkq3L1V9sQxvVqe/8RLr9DawfceuTt9xizp95Yup06uBwVd90LGy" +
       "mXo+8Zioq0j3VeWFO9MFZURd11JF5xLXV71Ermwm9l07ru+6Bdc3vBiuBz3g" +
       "Tah+rLYCD9j6SWb6ToiaL46Ifv4ZLtG9/y+h3B/b0X3sFnTf+mLo7oh1NUHd" +
       "U4PxzIsjmgCOSwh/+wUR8kuurwEX6bbKjcaNUvb339tjr9+W2+sseddJdV9l" +
       "WPJTJyPUFNhpMAw9ZViNLLt1qULci64Q8FvuPXOySNdZPPv1v/uNv/i3Xv9p" +
       "4FwQhdvibOAHPsU5T2wUZQGtr/7YBx/9og/89tfnsw0g2un7fqDx29lZ/9FL" +
       "w3okw2LyXkOKQTjMZweqkpHt96loX7fB8BPvojXQux/4tPnh//rxbSTmsgN1" +
       "qbD6tR/4us/feP8Hjs7Fv17/vBDU+WO2MbC80vfsJOwXntx3lfyI7n/5/nf/" +
       "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" +
       "zktIWNtYgrFg5bmtLqZ0XxGLaqnUqLjz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "85taF2VtZBb0jBZdV3zfmdRhjDfgpD5PU3GCN3l01ERTBwKzUN1jEBzqiYgK" +
       "zRt+WEmaUIOvaiEYZie0UqalJWGbqTuvcsV2cZ3ocddCOpEZzmfl7qypyjPJ" +
       "bMCpZDkJFrY8zaXbpNGpNrsx0+5T7UWpxuJQ3G1Xmh4ylyHNIc0NHai0ZTRn" +
       "hGAq3mCI+g6/iQkNXS/XmF4X4gYVQgRXpjYMD61ZorKcaVUtRst8JYbaGsSO" +
       "Yz0uErbjrxEDanRYVS5qAR/0k7IwXPWmRhtPllqMCEk8azSmi7YhgetQBLpY" +
       "c6UO46JjYpNqYUJEfE2aAEtvLOJFUCfWIg2vNvp47qlQKPFICLM9G5onoFEF" +
       "dBxozrBfrZtJ34CWPBHPi9U5aaxbG6xfJBjYNwbxBk4WltzmyZnjK+X1wgeu" +
       "nAet5hhEM+g8Lg0UKJEgPSxqxXY1YEqEtpCSVr5g40de2kqJl+cLQE4fyvlL" +
       "LP3YZj2ZJW89XVST/7t9t2zoZPnQ85bobpe5XjtZK/NotlYmqcrnl8icPduQ" +
       "rY149FZP5OTrIj763g98RKG+s3y0W4j7g2HhZaHrvcVSY9U6d8E+ONMzt14D" +
       "MswfSDpb3Ppz7/1vj7BfsnzXS3ji4fFL9bx8yu8ZfuwXem+Qv/mocHy61PV5" +
       "j0pdPOjZiwtc7/LVMPId9sIy10cvLmoqge2nd/L/6cuLms5aeO+Kpj3rnP/t" +
       "nrxfyZJ/HRZeo5+u5mxZFqnH6uk6zyA/8OPn1OsHwsL12NWVM7375EtZOp3v" +
       "+LlTEdyd7SyC7Rd2IviFlyKCsHCH5+uxGKovKIdP78n7T1nym2Hh4TM5XBRC" +
       "lv/vzoD/wxWAH8h2Pga239kB/85LbfO3vSDr7+/J+8Ms+UxYuHuhhqQri9Zo" +
       "p66tM77/cgW+7CGawpNg+70d3+8dnu9P9uT93yz5H0BHAR9/YrOevInNurgK" +
       "+Az+fx4C/rM7+M8eHP7abXvy7siSwhZ+nhX4s1Oua9euyvU02P5kx/Unh+d6" +
       "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" +
       "0Vf90Fu/6yOfyj9F9f8B6U9QJbN+AAA=");
}
