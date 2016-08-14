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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1dC5gVxZWu2z3MwPAYngPyfisIM+LzE0h0GEBGZ2DCjATx" +
       "MfTcWzNzoae76e47M+AiwXw+syFRfOBuwJjFdXXBR1Y3G4MumqziGjWoa3y7" +
       "UaMxaiLuFzGbKHtOdfXtvn1v1dDe+y3fd2suXXWq6//r1KlTp6vr7vuYDHBs" +
       "Mt3SjJRW4262qFPTjN+bNduhqXpdc5xWuNqWvP43O7cdfWHQdoWUryPDujSn" +
       "Kak5dHma6ilnHZmUNhxXM5LUWUlpCiWabepQu0dz06axjoxJOw3dlp5Opt0m" +
       "M0WxwBrNbiQjNNe10+0ZlzbwClwypZG1ppa1prYuWmBRIxmSNK3NgcD4HIH6" +
       "UB6W7Q7u57hkeOMGrUerzbhpvbYx7biL+mxysmXqmzt1062hfW7NBv0MTsT5" +
       "jWfk0TD9/qrP/vL9ruGMhlGaYZgug+ispo6p99BUI6kKri7TabeziVxB1EYy" +
       "OFTYJTMb/ZvWwk1r4aY+3qAUtH4oNTLd9SaD4/o1lVtJbJBLpuVWYmm21s2r" +
       "aWZthhoGuhw7Ewa0U7No/e6OQLz55Nqbbr1s+I9VUrWOVKWNFmxOEhrhwk3W" +
       "AaG0u53aTl0qRVPryAgDOryF2mlNT2/hvT3SSXcampsBFfBpwYsZi9rsngFX" +
       "0JOAzc4kXdPOwutgSsX/N6BD1zoBa3WA1UO4HK8DwMo0NMzu0ED3uEjZxrSR" +
       "YnqUK5HFOPMCKACiFd3U7TKztyozNLhARnoqomtGZ20LKJ/RCUUHmKCCNtM1" +
       "QaXItaUlN2qdtM0l46Llmr0sKDWIEYEiLhkTLcZqgl4aH+mlUP98vHLxjsuN" +
       "FYZCEtDmFE3q2P7BIDQ5IrSadlCbwjjwBIfMbbxFq37kWoUQKDwmUtgr85O/" +
       "OXLuvMkHD3llJhQos6p9A026bcm97cMOT6yfc7aKzRhomU4aOz8HORtlzTxn" +
       "UZ8FlqY6WyNm1viZB1c/cdG37qEfKqSygZQnTT3TDXo0Iml2W2md2udRg9qa" +
       "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" +
       "xibL4qcYlrHD186xLBzFZey9efp/epZh3y9qAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XpQ5N3CSYDkua0sZTVeNTcqs63psl31S");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("LJJ0TE2ogaYqo2IUayOkLozqdtQbeFWsy09jW0u67do0FiWsNw7tFE3bNhtN" +
       "LFB9l9BojDPA7KIHJswDwqgm5GIIAcGtm1WN0lG6qgv0JsVJMJuWe8Skw40H" +
       "E4xpM5TOuHNCWjUtQcA206pLZ7P+Uh2dEBDeC+OxEpRWnAo8+X6ZiyauwwHj" +
       "v5z5wgp2SRqCjLSDbwaRS6Y2hYWi2g5jX9x0nTk4ZNLDFgmY8NHtWIwWYshi" +
       "q9IUL8prpRqjslZtyUAv2kPEJIYrdTadOSJppERk1nqY0a/GZnMUtUWlW5nK" +
       "tfbELk6aVXUNddtJkzHGmStHTtG+6HZgullv8SWpyQymfZdeocPAiqAAsoGj" +
       "36Crpe5Mg1htomlj0TWR6hTTqeKgZEMeKmMxVEkJl45Trb+A8FgDZrg5YP0g" +
       "aHSHQXOEYxCCKiyMd3BkWbLtKOzYfuCkZBxGAYfilUqPnhXDVlGX8Xq55Tim" +
       "WtEhfM6tvGKEYUAvS0JIAFeoTQ2ZcI3Gbssg8Mmw13XWJbU6a7dXAq9NyqWm" +
       "tQCz1qZiGsi4MdCjSctASTEZrKujvtFdoWObqLlljWuXBujEINHBqqcbpdKG" +
       "7fnDFUZUNi25StFrZBL1ebaPk6leRBNiUi0OVmaVwRv8ykf4sCOTqjvpM92k" +
       "FAKj46YUT/BNTh8Du6UqHBjZy2XSU5chyXGSZkJaDbdGyXqKVePGGgXdNKTx" +
       "tFokZxrnRjDjDTZRhe01sQY7srlp0FLnU8msIKEEo3WZI9HiSrejhSXM1s4a" +
       "w0ewViSZ/qQzVxs1VocX8wHapLsrfMF2FtqggUpMQ1uPGmhX4uhesNGdklus" +
       "xd0OyRgLFMJKljyurUWttOwM6kuqPmIMkd+oyJA2woCYRAEUccpAxmVXwZye" +
       "3aadte4lygLuqyyyIaYuHihoBYH0tbPybVimN1B3Uqwz2LjTiI0BbFELHLFp" +
       "g1mOAonmPbmCrXTXbneAqZII0sPIdlngRFiYx9qkN2D8DjTwjQZSo+ZztF9i" +
       "olQJfag1qy6b5RK3xqsSL9Zxfig1mlM81UE7DjYh8J8mwH/ygFNgChM/QsLQ" +
       "DC2hOe8ihjuZVdeTZqnm1FFd8tu6aMc9BXcwe9UfqG1BFPl12mREYsJxURFh" +
       "iISaOhuzBcsdspvgEe/jHVNCWh7RV+Y9vkTqQ5NFK626PvAnPugZQxsazJcp" +
       "TGPwihitJX0OjwVMWoAJKzRu6vNJgE3WU62sVvx6vFy0aC3r+4bNlLBxbA+N" +
       "mWz4lalBjBy9VoFj0kKGvTBdDlVsBcl8JxGRVWdTLXc2WrPYyXyxaZuQp2iv" +
       "6U6FBo8mkY8lKSzUigKjFku+1UvwNSIiNC7qo2ZPZ7SuqzHMUB7qXK280X1X" +
       "7S8MppRW/A61mIxYrVoLSa+mIuiyPhpBSQWoNxDOQNRDzdRCbBSIC6M2WWtC" +
       "hWt7TbJdo4ZrU40S0+83ZCIMNaTFDzpue7AwXHe1nk7bUr0B89UeTCfqRFRK" +
       "FRYpzXpVs6EUGyHoTgKh9fgeZrcmNotSiSMw42mtk3rcBKMC1iBWOor1OCvF" +
       "FimPBJ15m1OgCitHUQQcUgQHnmbTy7j02XhJBxwp1J3AshsLBU5JOC0ObKUW" +
       "lSXSmrgQgy8bnRllFrEKxaUI4TQjFB/V20UyAX2GttVyZ5YEjSKwigNmNgEj" +
       "u2YmGrUsgulF7HJOYMDCoOL0zKGmV1ssFzSYCNEDB8x314qSWEw/Caoq8O7a" +
       "+HCCtGOtSxbBTDXQZytIMaTejGw3lsOGppaJKWLDyXyEGTTTGyWGNeZqPNuN" +
       "J2qjF7mVeS2tTUWx6kKan5AMJtugOti4RcHFIWEP9WQzBtPuhWkt/JSDNa0k" +
       "ryIwODYiHYckAoFXYrUz9WDKVxLZioRs7I2UfouRqiMTS8OiPPUVYlLiZLse" +
       "Wksy9fD5st+JoYGrLskqiylcw1mSjQY8BH7+AkwmJvU5zltBldlUUpyvSaY0" +
       "ZWEuCEgncddIPfbRnln10rlfFzAUzHPxJsnmdnUQEb4hK0DC0/p8SvUJU6+M" +
       "5H40XiQVRJlJjrWqiJ0ebKLl2bRIttYrgWhVpB4+GK0g1bdawMseRBMwES4j" +
       "yrBbmVdhiiVSDSGKgzVWNYZ21+pYmtujJQ61tGbHJ7ubgUaF/NDC4jTmrWZz" +
       "NenAqRCixdjvBxhVCdNk1mZjUL5orxAK0lW1VZZDLGblRTUaMTa6Ifsrn8OJ" +
       "eDhd4AEGfBZhoBWBI7gqFdce2xhWU86H5am15sv+os06CpQYYPrvC4hPN931" +
       "cokMhs5MbLHT5lhntbFbngDnmFRGQP98ZaEMlvCgyfNaRSOKzSnKFyWCXYDp" +
       "Z326qKkC3qj1p31iQwJ7XKupYlMWsBFwxWE9mYREXWlGglI0rUlKdOCG3hbo" +
       "hQV6jg6EPJiQipuQuiFTTL9Rcwau0ikTYM7DrBdjQ59ozFQXhgO7HJCG2te6" +
       "kJF0iyO25vSnXYJkupYsdJPexhxrK9trUAnmbWymPhAwWG6vpKjqmvWIJU1V" +
       "WhTlkT1S6uxy2APmYejoXuqY3RS433it0Uks2MZ9WvcxFpa0GF6bMtUyuqUA" +
       "5ZCKOms6E8Iu03p3xY31YeZzcyzFV7vMTOmPxl5U7MYqMeSR8ShlmiRS6QzL" +
       "ujiy1yQwycDmiW5XX6Zdk4fXYbSc+pKRCvB4XRRKS89p4yW+xpvOuEVQxGw6" +
       "rmijdbmqV+xmOG3w4ljFe4jvuXN0qDMwlVjLpsNXMSVwJ3YLzO06ddgZTNLO" +
       "QKmoadqqMYnqIktJ0AN5yPAjAjjgihY1qnC7HfnEQGfLCjdAZAbUrZ3VrZkO" +
       "wDjnkIQ1GKw4rCFOKHsZC/gElvH2OvGHNRuXtEanMu50rBbl1lalTiVt0llf" +
       "mRoVZhU5SnljMuK05tOyBNQ9mQRNvFL3hhsPRvp+aeP2vSaudqXVuhk28AkR" +
       "BimY+BfrTm+9qqTVGcSbCsPDkALmqOuepE1KyjyiRGrVKM5mLBsuIphMVkNu" +
       "TfQXYdSk+JVY46W+PhyyNOwZcn1dadJrR+jpTqfHlBvUlJmK3dWi2egVAfdc" +
       "RSLFmGPERhnr88q4Xh7HeFN250a9iA98n1yRy6SryKNQgwTZ4VLV64kNrZo6" +
       "mUb1NxjbgHoirfAsGdYmaNsK4wor6KESUHPIqHEKFY7IhsQWwSRoU1l0Kmiv" +
       "ZGKtiEQ8rN9s4h3BRwXIC/tTEaomDbrW9qF43dD5Kjqu9qL+BGGaem0xGgfT" +
       "gRfrCm1bvMUvioZSWYbV0kzeEPOW3F+YBMP10UZR0SCCCor1hGQFXoSxte32" +
       "9bLpV6jEaHFFsVEH1hgasT0GFwdUSJIOgNQrTr+Bw5VgI1IJpFdXauz1VXQs" +
       "98QSBRv1emWBlNlFURLhASYvNzy5HELUmvTjSRVSKRozqV4X9ctyPG0FyFCs" +
       "AC+5A2HFxB2xo7lph5Hkxqbbm/STfmqs5hTPFbmKpODFWtvhSKoSa0ui6oLB" +
       "2MPRcrMeE+0U4+WkJSsOJDv8Ck5aLoIg+eKHH3lpqyNeni/6OH1I5y+w3GOb" +
       "9WSWvPV0IU3+7/bdUqGTJUPPW5a7Xdp67WR9zKPZ+pgIFs8vizl7niFbD/Ho" +
       "rZ7QyddCfPS9H/iIRH1n+Wi3+PaHgsLLAtt5iyGHwNM6u2AfnOmZW6/7IPMH" +
       "lM4WtP7Me3/nEfaLVu96CU85PH6pnpdP+T3kx36u9wbxG48Kx6fLW5/36NTF" +
       "g569uKj1Lk8ONp7FXlja+ujFhUwlsP3kTv4/eXkh01kL713FtGdt87/dk/dL" +
       "WfKvg8JrtNMVnIhhEFoon67t9PMDP35OvX4wKFwPbU0607tPvpTl0vmOnzkV" +
       "wd3ZziLYfm4ngp97KSIICnc4nhYKgfyCcvj0nrz/nCW/FhQePpPDRSFk+f/+" +
       "DPg/XgH4gWznY2D7zR3wb77UNn/bC7L+7p6838+SzwSFu1U5IGxRMEY7dUXO" +
       "+P7rFfiyB2cKT4Ltt3d8v314vj/ek/d/suS/Ax0FfPMTm/XkTWzWxZW/Z/D/" +
       "4xDwn93Bf/bg8Ndu25N3R5YUtvCLrMCfnnJdu3ZVrqfB9sc7rj8+PNfL9+Q9" +
       "mCV3B4U7AdfsZC3yObZ7rsr2BrD9+Y7tzw/P9uievMez5GEwCAI2/HRR8zm4" +
       "V1/V2gC4a7dtj93+f1i4N+3JK2bJU0HhFQAuf07aChjR05zgZEg8szrXnr4C" +
       "Z/7EUhlU+e4d592H4bx2VgDJgWp7YDOn7FoJwPq3gD0bQq6Vr9qooDdee3AH" +
       "++DhGxXZk9fJkrcGhQfPNWqQGPJN2vRtV21T4B1de2SH+chfUpuSe1ipLMEB" +
       "q39z1nNN2r8Ca96CwCu49uSO9cnDN+liT97bs4QNCl8AmnSqyZFje8HJ4Pmq" +
       "mwye2er3M/IXXI68hzyfhzwDIJ7ZkT9zeHJ1T56WJcug8GpATmuxbHDAB2Rt" +
       "UjMMzZQD2ds6EZc84NsUwxbOSUA8hATKOwmUDy+BcE9enrh7JJB5Etf0M1jv" +
       "qrBvBvVu7WBbh4d97568L8+Sd4MpD4AFxlmWrRz5QoNfwn3B54leDC6yw0UO" +
       "j/u+PXnvz5Kv2Yt7uXW/9qpm7ClQc3yHix8e92/vyfvWLPlgUHg5wOV8ubPx" +
       "PGCwM4N2s058x3L7nNUZ+4euOly1skdgduz0YdjPhqtrH8khv+fmBU7M9cPn" +
       "zTVKkd1YlJ0sEpIf/A+z5KNAQv5lCbkXR7PvvIIoXpXtzByU+U4U88OrwY/s" +
       "yfuxLPmhoHBv5qBc0gEgodfcZEDL8hlHFs8E8I+u2u2fACzv2gngXYcXwE/t" +
       "yfuZLPlEULjvTAAMmOrLl7r6T15V3WFQW32HqB9c3fWc5ZduXeBjeYF/nyU/" +
       "D2D958GeV+h/cwXYV2Q7vxBc9Ut3sF96+Pb8T3vyPp0lv7rzuLeIrAcMlyHs" +
       "glOX+/1Oq2lbs855Kb92BRHcl+18LaD5+E4EHz9oe9/MPh9r23c3XNsTz7r2" +
       "2Sz5TFC4x9/4jmxJE1nyhMyYXfu9M/CrBLRyRa+DKv74DvzHD67ov5eT/MkL" +
       "Kfr/zZL/BRR9Y12GPa/on7sqbDaA//QO9qcPruhHt+/JuzNLrgWFBy4hIoZx" +
       "kfLo6KqUj4IK/8KO8hcOT/nAnrxXZMk9Qf5uIlG+WSMe3XtVPDCBvPYrO7xf" +
       "OTzeY3vynsiSVwM9dYSNL2/jrCd3Ys4hPnJVxNeD2n5qh/ipwyM+syfvzVny" +
       "NHCjNtZ+yDdc1ZvOID+zg/zM4SHre/KaWVIOCvcLp3R0BitlVuYjZ4yVq3pK" +
       "j4Pq/sGO8Q8Oz9jek4dmydsuuIqsZl5ylI6+6Kqq+hZQ2c/tCD93GMLLjtLR" +
       "aA8mnSV9gOlfxjyvrINDuEif32F+/jCYu1dBZZjvPHF1HrmJq3Ny/znj4PdI" +
       "4kuyhNu6Uv3s/Zj+9qVi2evDTs7/ivPnH9mSfJqZi2l6VTGBAfboru2x2/8P" +
       "K6asjm/PYdd7BJENqEcy6N1AEF1LNGx/4+Wg2f53ndEqB4gHHD20o33o0LRH" +
       "eeTynTnRniDXUZ64wGCLK1nUzzf8JWN2leBWjgsG3qPHdriP/WXi7glzHWVh" +
       "rqN3g/6e45427yXWq0S2TnyoozfsWN9wGNbzFHsiW0dZZOvoa4APJcm+nL0Y" +
       "8Pku4lUiWQ+daO5bdnhvOTzenkjWURbJOvog8KFETwaTPGDgtu9bOTFRr76J" +
       "CTxXIue/SjTrlP+tO/63Hp7/u/fkfW+W/P3z/Ofu09+C/9Kd/KOPXtVOvw5w" +
       "75ZGHV1eGnUA/n+yJ+9Hs+QHsw58wo9YqrF3sn9WIKf/oUPQ7965d/S8d+5d" +
       "nf5f7cn76Sz5ifP0eSQjM1//+YzwE4fQ7/GOcHx4wl/ck/fvsuST5/WbFAJP" +
       "O30L1c30+1yJnP/nrzpUPQG437njf+fh+T+1J+83suTXgsI9p/y7F2rtvLwc" +
       "8CrrrB7Odj4DwKQdoHR4wN/Zk/d7WfJfgsIDp4B5xC57deRJG7/2Jm18sVAu" +
       "hc9cVQpVQG/tpGAdRgpnk4+jX85x//ceUfxJlvwPwPt8UWCebW7VOivzB2fQ" +
       "//MQbli0g44ODb1dOHB8/dbQx7dnFJ/fTix3c5N20j99E+CD59t+l39Kf1y4" +
       "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" +
       "/a6PfCr//NT/AwzOhtLDfgAA");
}
