package org.apache.batik.bridge;
public class SVGImageElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge {
    protected org.w3c.dom.svg.SVGDocument imgDocument;
    protected org.w3c.dom.events.EventListener listener = null;
    protected org.apache.batik.bridge.BridgeContext subCtx = null;
    protected boolean hitCheckChildren = false;
    public SVGImageElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_IMAGE_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGImageElementBridge(
                                                            ); }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.ImageNode imageNode =
          (org.apache.batik.gvt.ImageNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (imageNode ==
              null) {
            return null;
        }
        associateSVGContext(
          ctx,
          e,
          imageNode);
        hitCheckChildren =
          false;
        org.apache.batik.gvt.GraphicsNode node =
          buildImageGraphicsNode(
            ctx,
            e);
        if (node ==
              null) {
            org.w3c.dom.svg.SVGImageElement ie =
              (org.w3c.dom.svg.SVGImageElement)
                e;
            java.lang.String uriStr =
              ie.
              getHref(
                ).
              getAnimVal(
                );
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_URI_IMAGE_INVALID,
              new java.lang.Object[] { uriStr });
        }
        imageNode.
          setImage(
            node);
        imageNode.
          setHitCheckChildren(
            hitCheckChildren);
        java.awt.RenderingHints hints =
          null;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertImageRendering(
              e,
              hints);
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertColorRendering(
              e,
              hints);
        if (hints !=
              null)
            imageNode.
              setRenderingHints(
                hints);
        return imageNode;
    }
    protected org.apache.batik.gvt.GraphicsNode buildImageGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                       org.w3c.dom.Element e) {
        org.w3c.dom.svg.SVGImageElement ie =
          (org.w3c.dom.svg.SVGImageElement)
            e;
        java.lang.String uriStr =
          ie.
          getHref(
            ).
          getAnimVal(
            );
        if (uriStr.
              length(
                ) ==
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_MISSING,
              new java.lang.Object[] { "xlink:href" });
        }
        if (uriStr.
              indexOf(
                '#') !=
              -1) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { "xlink:href",
              uriStr });
        }
        java.lang.String baseURI =
          org.apache.batik.dom.AbstractNode.
          getBaseURI(
            e);
        org.apache.batik.util.ParsedURL purl;
        if (baseURI ==
              null) {
            purl =
              new org.apache.batik.util.ParsedURL(
                uriStr);
        }
        else {
            purl =
              new org.apache.batik.util.ParsedURL(
                baseURI,
                uriStr);
        }
        return createImageGraphicsNode(
                 ctx,
                 e,
                 purl);
    }
    protected org.apache.batik.gvt.GraphicsNode createImageGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                        org.w3c.dom.Element e,
                                                                        org.apache.batik.util.ParsedURL purl) {
        java.awt.geom.Rectangle2D bounds =
          getImageBounds(
            ctx,
            e);
        if (bounds.
              getWidth(
                ) ==
              0 ||
              bounds.
              getHeight(
                ) ==
              0) {
            org.apache.batik.gvt.ShapeNode sn =
              new org.apache.batik.gvt.ShapeNode(
              );
            sn.
              setShape(
                bounds);
            return sn;
        }
        org.w3c.dom.svg.SVGDocument svgDoc =
          (org.w3c.dom.svg.SVGDocument)
            e.
            getOwnerDocument(
              );
        java.lang.String docURL =
          svgDoc.
          getURL(
            );
        org.apache.batik.util.ParsedURL pDocURL =
          null;
        if (docURL !=
              null)
            pDocURL =
              new org.apache.batik.util.ParsedURL(
                docURL);
        org.apache.batik.bridge.UserAgent userAgent =
          ctx.
          getUserAgent(
            );
        try {
            userAgent.
              checkLoadExternalResource(
                purl,
                pDocURL);
        }
        catch (java.lang.SecurityException secEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              secEx,
              ERR_URI_UNSECURE,
              new java.lang.Object[] { purl });
        }
        org.apache.batik.bridge.DocumentLoader loader =
          ctx.
          getDocumentLoader(
            );
        org.apache.batik.ext.awt.image.spi.ImageTagRegistry reg =
          org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
          getRegistry(
            );
        org.apache.batik.ext.awt.color.ICCColorSpaceExt colorspace =
          extractColorSpace(
            e,
            ctx);
        {
            try {
                org.w3c.dom.Document doc =
                  loader.
                  checkCache(
                    purl.
                      toString(
                        ));
                if (doc !=
                      null) {
                    imgDocument =
                      (org.w3c.dom.svg.SVGDocument)
                        doc;
                    return createSVGImageNode(
                             ctx,
                             e,
                             imgDocument);
                }
            }
            catch (org.apache.batik.bridge.BridgeException ex) {
                throw ex;
            }
            catch (java.lang.Exception ex) {
                
            }
            org.apache.batik.ext.awt.image.renderable.Filter img =
              reg.
              checkCache(
                purl,
                colorspace);
            if (img !=
                  null) {
                return createRasterImageNode(
                         ctx,
                         e,
                         img,
                         purl);
            }
        }
        org.apache.batik.bridge.SVGImageElementBridge.ProtectedStream reference =
          null;
        try {
            reference =
              openStream(
                e,
                purl);
        }
        catch (java.lang.SecurityException secEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              secEx,
              ERR_URI_UNSECURE,
              new java.lang.Object[] { purl });
        }
        catch (java.io.IOException ioe) {
            return createBrokenImageNode(
                     ctx,
                     e,
                     purl.
                       toString(
                         ),
                     ioe.
                       getLocalizedMessage(
                         ));
        }
        {
            org.apache.batik.ext.awt.image.renderable.Filter img =
              reg.
              readURL(
                reference,
                purl,
                colorspace,
                false,
                false);
            if (img !=
                  null) {
                return createRasterImageNode(
                         ctx,
                         e,
                         img,
                         purl);
            }
        }
        try {
            reference.
              retry(
                );
        }
        catch (java.io.IOException ioe) {
            reference.
              release(
                );
            reference =
              null;
            try {
                reference =
                  openStream(
                    e,
                    purl);
            }
            catch (java.io.IOException ioe2) {
                return createBrokenImageNode(
                         ctx,
                         e,
                         purl.
                           toString(
                             ),
                         ioe2.
                           getLocalizedMessage(
                             ));
            }
        }
        try {
            org.w3c.dom.Document doc =
              loader.
              loadDocument(
                purl.
                  toString(
                    ),
                reference);
            imgDocument =
              (org.w3c.dom.svg.SVGDocument)
                doc;
            return createSVGImageNode(
                     ctx,
                     e,
                     imgDocument);
        }
        catch (org.apache.batik.bridge.BridgeException ex) {
            throw ex;
        }
        catch (java.lang.SecurityException secEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              e,
              secEx,
              ERR_URI_UNSECURE,
              new java.lang.Object[] { purl });
        }
        catch (java.io.InterruptedIOException iioe) {
            if (org.apache.batik.util.HaltingThread.
                  hasBeenHalted(
                    ))
                throw new org.apache.batik.bridge.InterruptedBridgeException(
                  );
        }
        catch (org.apache.batik.bridge.InterruptedBridgeException ibe) {
            throw ibe;
        }
        catch (java.lang.Exception ex) {
            
        }
        try {
            reference.
              retry(
                );
        }
        catch (java.io.IOException ioe) {
            reference.
              release(
                );
            reference =
              null;
            try {
                reference =
                  openStream(
                    e,
                    purl);
            }
            catch (java.io.IOException ioe2) {
                return createBrokenImageNode(
                         ctx,
                         e,
                         purl.
                           toString(
                             ),
                         ioe2.
                           getLocalizedMessage(
                             ));
            }
        }
        try {
            org.apache.batik.ext.awt.image.renderable.Filter img =
              reg.
              readURL(
                reference,
                purl,
                colorspace,
                true,
                true);
            if (img !=
                  null) {
                return createRasterImageNode(
                         ctx,
                         e,
                         img,
                         purl);
            }
        }
        finally {
            reference.
              release(
                );
        }
        return null;
    }
    public static class ProtectedStream extends java.io.BufferedInputStream {
        static final int BUFFER_SIZE = 8192;
        ProtectedStream(java.io.InputStream is) {
            super(
              is,
              BUFFER_SIZE);
            super.
              mark(
                BUFFER_SIZE);
        }
        ProtectedStream(java.io.InputStream is,
                        int size) { super(
                                      is,
                                      size);
                                    super.
                                      mark(
                                        size);
        }
        public boolean markSupported() { return false;
        }
        public void mark(int sz) {  }
        public void reset() throws java.io.IOException {
            throw new java.io.IOException(
              "Reset unsupported");
        }
        public void retry() throws java.io.IOException {
            super.
              reset(
                );
        }
        public void close() throws java.io.IOException {
            
        }
        public void release() { try { super.
                                        close(
                                          );
                                }
                                catch (java.io.IOException ioe) {
                                    
                                } }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "a4bjGT7F4ZP/AlAZha5iHgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "TtkoAAA=");
    }
    protected org.apache.batik.bridge.SVGImageElementBridge.ProtectedStream openStream(org.w3c.dom.Element e,
                                                                                       org.apache.batik.util.ParsedURL purl)
          throws java.io.IOException { java.util.List mimeTypes =
                                         new java.util.ArrayList(
                                         org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
                                           getRegistry(
                                             ).
                                           getRegisteredMimeTypes(
                                             ));
                                       mimeTypes.
                                         add(
                                           org.apache.batik.util.MimeTypeConstants.
                                             MIME_TYPES_SVG);
                                       java.io.InputStream reference =
                                         purl.
                                         openStream(
                                           mimeTypes.
                                             iterator(
                                               ));
                                       return new org.apache.batik.bridge.SVGImageElementBridge.ProtectedStream(
                                         reference);
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.ImageNode(
          );
    }
    public boolean isComposite() { return false;
    }
    protected void initializeDynamicSupport(org.apache.batik.bridge.BridgeContext ctx,
                                            org.w3c.dom.Element e,
                                            org.apache.batik.gvt.GraphicsNode node) {
        if (!ctx.
              isInteractive(
                ))
            return;
        ctx.
          bind(
            e,
            node);
        if (ctx.
              isDynamic(
                )) {
            this.
              e =
              e;
            this.
              node =
              node;
            this.
              ctx =
              ctx;
            ((org.apache.batik.dom.svg.SVGOMElement)
               e).
              setSVGContext(
                this);
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        try {
            java.lang.String ns =
              alav.
              getNamespaceURI(
                );
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ns ==
                  null) {
                if (ln.
                      equals(
                        SVG_X_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_Y_ATTRIBUTE)) {
                    updateImageBounds(
                      );
                    return;
                }
                else
                    if (ln.
                          equals(
                            SVG_WIDTH_ATTRIBUTE) ||
                          ln.
                          equals(
                            SVG_HEIGHT_ATTRIBUTE)) {
                        org.w3c.dom.svg.SVGImageElement ie =
                          (org.w3c.dom.svg.SVGImageElement)
                            e;
                        org.apache.batik.gvt.ImageNode imageNode =
                          (org.apache.batik.gvt.ImageNode)
                            node;
                        org.apache.batik.dom.svg.AbstractSVGAnimatedLength _attr;
                        if (ln.
                              charAt(
                                0) ==
                              'w') {
                            _attr =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                ie.
                                getWidth(
                                  );
                        }
                        else {
                            _attr =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                ie.
                                getHeight(
                                  );
                        }
                        float val =
                          _attr.
                          getCheckedValue(
                            );
                        if (val ==
                              0 ||
                              imageNode.
                              getImage(
                                ) instanceof org.apache.batik.gvt.ShapeNode) {
                            rebuildImageNode(
                              );
                        }
                        else {
                            updateImageBounds(
                              );
                        }
                        return;
                    }
                    else
                        if (ln.
                              equals(
                                SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE)) {
                            updateImageBounds(
                              );
                            return;
                        }
            }
            else
                if (ns.
                      equals(
                        XLINK_NAMESPACE_URI) &&
                      ln.
                      equals(
                        XLINK_HREF_ATTRIBUTE)) {
                    rebuildImageNode(
                      );
                    return;
                }
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    protected void updateImageBounds() { java.awt.geom.Rectangle2D bounds =
                                           getImageBounds(
                                             ctx,
                                             e);
                                         org.apache.batik.gvt.GraphicsNode imageNode =
                                           ((org.apache.batik.gvt.ImageNode)
                                              node).
                                           getImage(
                                             );
                                         float[] vb =
                                           null;
                                         if (imageNode instanceof org.apache.batik.gvt.RasterImageNode) {
                                             java.awt.geom.Rectangle2D imgBounds =
                                               ((org.apache.batik.gvt.RasterImageNode)
                                                  imageNode).
                                               getImageBounds(
                                                 );
                                             vb =
                                               (new float[4]);
                                             vb[0] =
                                               0;
                                             vb[1] =
                                               0;
                                             vb[2] =
                                               (float)
                                                 imgBounds.
                                                 getWidth(
                                                   );
                                             vb[3] =
                                               (float)
                                                 imgBounds.
                                                 getHeight(
                                                   );
                                         }
                                         else {
                                             if (imgDocument !=
                                                   null) {
                                                 org.w3c.dom.Element svgElement =
                                                   imgDocument.
                                                   getRootElement(
                                                     );
                                                 java.lang.String viewBox =
                                                   svgElement.
                                                   getAttributeNS(
                                                     null,
                                                     SVG_VIEW_BOX_ATTRIBUTE);
                                                 vb =
                                                   org.apache.batik.bridge.ViewBox.
                                                     parseViewBoxAttribute(
                                                       e,
                                                       viewBox,
                                                       ctx);
                                             }
                                         }
                                         if (imageNode !=
                                               null) {
                                             initializeViewport(
                                               ctx,
                                               e,
                                               imageNode,
                                               vb,
                                               bounds);
                                         }
    }
    protected void rebuildImageNode() { if (imgDocument !=
                                              null &&
                                              listener !=
                                              null) {
                                            org.apache.batik.dom.events.NodeEventTarget tgt =
                                              (org.apache.batik.dom.events.NodeEventTarget)
                                                imgDocument.
                                                getRootElement(
                                                  );
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_CLICK,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_KEYDOWN,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_KEYPRESS,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_KEYUP,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEDOWN,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEMOVE,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEOUT,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEOVER,
                                                listener,
                                                false);
                                            tgt.
                                              removeEventListenerNS(
                                                org.apache.batik.util.XMLConstants.
                                                  XML_EVENTS_NAMESPACE_URI,
                                                SVG_EVENT_MOUSEUP,
                                                listener,
                                                false);
                                            listener =
                                              null;
                                        }
                                        if (imgDocument !=
                                              null) {
                                            org.w3c.dom.svg.SVGSVGElement svgElement =
                                              imgDocument.
                                              getRootElement(
                                                );
                                            disposeTree(
                                              svgElement);
                                        }
                                        imgDocument =
                                          null;
                                        subCtx =
                                          null;
                                        org.apache.batik.gvt.GraphicsNode inode =
                                          buildImageGraphicsNode(
                                            ctx,
                                            e);
                                        org.apache.batik.gvt.ImageNode imgNode =
                                          (org.apache.batik.gvt.ImageNode)
                                            node;
                                        imgNode.
                                          setImage(
                                            inode);
                                        if (inode ==
                                              null) {
                                            org.w3c.dom.svg.SVGImageElement ie =
                                              (org.w3c.dom.svg.SVGImageElement)
                                                e;
                                            java.lang.String uriStr =
                                              ie.
                                              getHref(
                                                ).
                                              getAnimVal(
                                                );
                                            throw new org.apache.batik.bridge.BridgeException(
                                              ctx,
                                              e,
                                              ERR_URI_IMAGE_INVALID,
                                              new java.lang.Object[] { uriStr });
                                        }
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   IMAGE_RENDERING_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   COLOR_INTERPOLATION_INDEX:
                java.awt.RenderingHints hints =
                  org.apache.batik.bridge.CSSUtilities.
                  convertImageRendering(
                    e,
                    null);
                hints =
                  org.apache.batik.bridge.CSSUtilities.
                    convertColorRendering(
                      e,
                      hints);
                if (hints !=
                      null) {
                    node.
                      setRenderingHints(
                        hints);
                }
                break;
            default:
                super.
                  handleCSSPropertyChanged(
                    property);
        }
    }
    protected org.apache.batik.gvt.GraphicsNode createRasterImageNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                      org.w3c.dom.Element e,
                                                                      org.apache.batik.ext.awt.image.renderable.Filter img,
                                                                      org.apache.batik.util.ParsedURL purl) {
        java.awt.geom.Rectangle2D bounds =
          getImageBounds(
            ctx,
            e);
        if (bounds.
              getWidth(
                ) ==
              0 ||
              bounds.
              getHeight(
                ) ==
              0) {
            org.apache.batik.gvt.ShapeNode sn =
              new org.apache.batik.gvt.ShapeNode(
              );
            sn.
              setShape(
                bounds);
            return sn;
        }
        if (org.apache.batik.ext.awt.image.spi.BrokenLinkProvider.
              hasBrokenLinkProperty(
                img)) {
            java.lang.Object o =
              img.
              getProperty(
                org.apache.batik.ext.awt.image.spi.BrokenLinkProvider.
                  BROKEN_LINK_PROPERTY);
            java.lang.String msg =
              "unknown";
            if (o instanceof java.lang.String)
                msg =
                  (java.lang.String)
                    o;
            org.w3c.dom.svg.SVGDocument doc =
              ctx.
              getUserAgent(
                ).
              getBrokenLinkDocument(
                e,
                purl.
                  toString(
                    ),
                msg);
            return createSVGImageNode(
                     ctx,
                     e,
                     doc);
        }
        org.apache.batik.gvt.RasterImageNode node =
          new org.apache.batik.gvt.RasterImageNode(
          );
        node.
          setImage(
            img);
        java.awt.geom.Rectangle2D imgBounds =
          img.
          getBounds2D(
            );
        float[] vb =
          new float[4];
        vb[0] =
          0;
        vb[1] =
          0;
        vb[2] =
          (float)
            imgBounds.
            getWidth(
              );
        vb[3] =
          (float)
            imgBounds.
            getHeight(
              );
        initializeViewport(
          ctx,
          e,
          node,
          vb,
          bounds);
        return node;
    }
    protected org.apache.batik.gvt.GraphicsNode createSVGImageNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.w3c.dom.svg.SVGDocument imgDocument) {
        org.apache.batik.css.engine.CSSEngine eng =
          ((org.apache.batik.dom.svg.SVGOMDocument)
             imgDocument).
          getCSSEngine(
            );
        subCtx =
          ctx.
            createSubBridgeContext(
              (org.apache.batik.dom.svg.SVGOMDocument)
                imgDocument);
        org.apache.batik.gvt.CompositeGraphicsNode result =
          new org.apache.batik.gvt.CompositeGraphicsNode(
          );
        java.awt.geom.Rectangle2D bounds =
          getImageBounds(
            ctx,
            e);
        if (bounds.
              getWidth(
                ) ==
              0 ||
              bounds.
              getHeight(
                ) ==
              0) {
            org.apache.batik.gvt.ShapeNode sn =
              new org.apache.batik.gvt.ShapeNode(
              );
            sn.
              setShape(
                bounds);
            result.
              getChildren(
                ).
              add(
                sn);
            return result;
        }
        java.awt.geom.Rectangle2D r =
          org.apache.batik.bridge.CSSUtilities.
          convertEnableBackground(
            e);
        if (r !=
              null) {
            result.
              setBackgroundEnable(
                r);
        }
        org.w3c.dom.svg.SVGSVGElement svgElement =
          imgDocument.
          getRootElement(
            );
        org.apache.batik.gvt.CanvasGraphicsNode node;
        node =
          (org.apache.batik.gvt.CanvasGraphicsNode)
            subCtx.
            getGVTBuilder(
              ).
            build(
              subCtx,
              svgElement);
        if (eng ==
              null &&
              ctx.
              isInteractive(
                )) {
            subCtx.
              addUIEventListeners(
                imgDocument);
        }
        node.
          setClip(
            null);
        node.
          setViewingTransform(
            new java.awt.geom.AffineTransform(
              ));
        result.
          getChildren(
            ).
          add(
            node);
        java.lang.String viewBox =
          svgElement.
          getAttributeNS(
            null,
            SVG_VIEW_BOX_ATTRIBUTE);
        float[] vb =
          org.apache.batik.bridge.ViewBox.
          parseViewBoxAttribute(
            e,
            viewBox,
            ctx);
        initializeViewport(
          ctx,
          e,
          result,
          vb,
          bounds);
        if (ctx.
              isInteractive(
                )) {
            listener =
              new org.apache.batik.bridge.SVGImageElementBridge.ForwardEventListener(
                svgElement,
                e);
            org.apache.batik.dom.events.NodeEventTarget tgt =
              (org.apache.batik.dom.events.NodeEventTarget)
                svgElement;
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_CLICK,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_CLICK,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYDOWN,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYDOWN,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYPRESS,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYPRESS,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYUP,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_KEYUP,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEDOWN,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEDOWN,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEMOVE,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEMOVE,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEOUT,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEOUT,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEOVER,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEOVER,
                listener,
                false);
            tgt.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEUP,
                listener,
                false,
                null);
            subCtx.
              storeEventListenerNS(
                tgt,
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                SVG_EVENT_MOUSEUP,
                listener,
                false);
        }
        return result;
    }
    public void dispose() { if (imgDocument !=
                                  null &&
                                  listener !=
                                  null) {
                                org.apache.batik.dom.events.NodeEventTarget tgt =
                                  (org.apache.batik.dom.events.NodeEventTarget)
                                    imgDocument.
                                    getRootElement(
                                      );
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_CLICK,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_KEYDOWN,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_KEYPRESS,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_KEYUP,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEDOWN,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEMOVE,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEOUT,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEOVER,
                                    listener,
                                    false);
                                tgt.
                                  removeEventListenerNS(
                                    org.apache.batik.util.XMLConstants.
                                      XML_EVENTS_NAMESPACE_URI,
                                    SVG_EVENT_MOUSEUP,
                                    listener,
                                    false);
                                listener =
                                  null;
                            }
                            if (imgDocument !=
                                  null) {
                                org.w3c.dom.svg.SVGSVGElement svgElement =
                                  imgDocument.
                                  getRootElement(
                                    );
                                disposeTree(
                                  svgElement);
                                imgDocument =
                                  null;
                                subCtx =
                                  null;
                            }
                            super.dispose(
                                    ); }
    protected static class ForwardEventListener implements org.w3c.dom.events.EventListener {
        protected org.w3c.dom.Element svgElement;
        protected org.w3c.dom.Element imgElement;
        public ForwardEventListener(org.w3c.dom.Element svgElement,
                                    org.w3c.dom.Element imgElement) {
            super(
              );
            this.
              svgElement =
              svgElement;
            this.
              imgElement =
              imgElement;
        }
        public void handleEvent(org.w3c.dom.events.Event e) {
            org.apache.batik.dom.events.DOMMouseEvent evt =
              (org.apache.batik.dom.events.DOMMouseEvent)
                e;
            org.apache.batik.dom.events.DOMMouseEvent newMouseEvent =
              (org.apache.batik.dom.events.DOMMouseEvent)
                ((org.w3c.dom.events.DocumentEvent)
                   imgElement.
                   getOwnerDocument(
                     )).
                createEvent(
                  "MouseEvents");
            newMouseEvent.
              initMouseEventNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                evt.
                  getType(
                    ),
                evt.
                  getBubbles(
                    ),
                evt.
                  getCancelable(
                    ),
                evt.
                  getView(
                    ),
                evt.
                  getDetail(
                    ),
                evt.
                  getScreenX(
                    ),
                evt.
                  getScreenY(
                    ),
                evt.
                  getClientX(
                    ),
                evt.
                  getClientY(
                    ),
                evt.
                  getButton(
                    ),
                (org.w3c.dom.events.EventTarget)
                  imgElement,
                evt.
                  getModifiersString(
                    ));
            ((org.w3c.dom.events.EventTarget)
               imgElement).
              dispatchEvent(
                newMouseEvent);
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
           "LFoiAAA=");
    }
    protected static void initializeViewport(org.apache.batik.bridge.BridgeContext ctx,
                                             org.w3c.dom.Element e,
                                             org.apache.batik.gvt.GraphicsNode node,
                                             float[] vb,
                                             java.awt.geom.Rectangle2D bounds) {
        float x =
          (float)
            bounds.
            getX(
              );
        float y =
          (float)
            bounds.
            getY(
              );
        float w =
          (float)
            bounds.
            getWidth(
              );
        float h =
          (float)
            bounds.
            getHeight(
              );
        try {
            org.w3c.dom.svg.SVGImageElement ie =
              (org.w3c.dom.svg.SVGImageElement)
                e;
            org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio _par =
              (org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio)
                ie.
                getPreserveAspectRatio(
                  );
            _par.
              check(
                );
            java.awt.geom.AffineTransform at =
              org.apache.batik.bridge.ViewBox.
              getPreserveAspectRatioTransform(
                e,
                vb,
                w,
                h,
                _par,
                ctx);
            at.
              preConcatenate(
                java.awt.geom.AffineTransform.
                  getTranslateInstance(
                    x,
                    y));
            node.
              setTransform(
                at);
            java.awt.Shape clip =
              null;
            if (org.apache.batik.bridge.CSSUtilities.
                  convertOverflow(
                    e)) {
                float[] offsets =
                  org.apache.batik.bridge.CSSUtilities.
                  convertClip(
                    e);
                if (offsets ==
                      null) {
                    clip =
                      new java.awt.geom.Rectangle2D.Float(
                        x,
                        y,
                        w,
                        h);
                }
                else {
                    clip =
                      new java.awt.geom.Rectangle2D.Float(
                        x +
                          offsets[3],
                        y +
                          offsets[0],
                        w -
                          offsets[1] -
                          offsets[3],
                        h -
                          offsets[2] -
                          offsets[0]);
                }
            }
            if (clip !=
                  null) {
                try {
                    at =
                      at.
                        createInverse(
                          );
                    org.apache.batik.ext.awt.image.renderable.Filter filter =
                      node.
                      getGraphicsNodeRable(
                        true);
                    clip =
                      at.
                        createTransformedShape(
                          clip);
                    node.
                      setClip(
                        new org.apache.batik.ext.awt.image.renderable.ClipRable8Bit(
                          filter,
                          clip));
                }
                catch (java.awt.geom.NoninvertibleTransformException ex) {
                    
                }
            }
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    protected static org.apache.batik.ext.awt.color.ICCColorSpaceExt extractColorSpace(org.w3c.dom.Element element,
                                                                                       org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String colorProfileProperty =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              COLOR_PROFILE_INDEX).
          getStringValue(
            );
        org.apache.batik.ext.awt.color.ICCColorSpaceExt colorSpace =
          null;
        if (CSS_SRGB_VALUE.
              equalsIgnoreCase(
                colorProfileProperty)) {
            colorSpace =
              new org.apache.batik.ext.awt.color.ICCColorSpaceExt(
                java.awt.color.ICC_Profile.
                  getInstance(
                    java.awt.color.ColorSpace.
                      CS_sRGB),
                org.apache.batik.ext.awt.color.ICCColorSpaceExt.
                  AUTO);
        }
        else
            if (!CSS_AUTO_VALUE.
                  equalsIgnoreCase(
                    colorProfileProperty) &&
                  !"".
                  equalsIgnoreCase(
                    colorProfileProperty)) {
                org.apache.batik.bridge.SVGColorProfileElementBridge profileBridge =
                  (org.apache.batik.bridge.SVGColorProfileElementBridge)
                    ctx.
                    getBridge(
                      SVG_NAMESPACE_URI,
                      SVG_COLOR_PROFILE_TAG);
                if (profileBridge !=
                      null) {
                    colorSpace =
                      profileBridge.
                        createICCColorSpaceExt(
                          ctx,
                          element,
                          colorProfileProperty);
                }
            }
        return colorSpace;
    }
    protected static java.awt.geom.Rectangle2D getImageBounds(org.apache.batik.bridge.BridgeContext ctx,
                                                              org.w3c.dom.Element element) {
        try {
            org.w3c.dom.svg.SVGImageElement ie =
              (org.w3c.dom.svg.SVGImageElement)
                element;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ie.
                getX(
                  );
            float x =
              _x.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ie.
                getY(
                  );
            float y =
              _y.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _width =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ie.
                getWidth(
                  );
            float w =
              _width.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _height =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                ie.
                getHeight(
                  );
            float h =
              _height.
              getCheckedValue(
                );
            return new java.awt.geom.Rectangle2D.Float(
              x,
              y,
              w,
              h);
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    org.apache.batik.gvt.GraphicsNode createBrokenImageNode(org.apache.batik.bridge.BridgeContext ctx,
                                                            org.w3c.dom.Element e,
                                                            java.lang.String uri,
                                                            java.lang.String message) {
        org.w3c.dom.svg.SVGDocument doc =
          ctx.
          getUserAgent(
            ).
          getBrokenLinkDocument(
            e,
            uri,
            org.apache.batik.bridge.Messages.
              formatMessage(
                URI_IMAGE_ERROR,
                new java.lang.Object[] { message }));
        return createSVGImageNode(
                 ctx,
                 e,
                 doc);
    }
    static org.apache.batik.bridge.SVGBrokenLinkProvider
      brokenLinkProvider =
      new org.apache.batik.bridge.SVGBrokenLinkProvider(
      );
    static { org.apache.batik.ext.awt.image.spi.ImageTagRegistry.
               setBrokenLinkProvider(
                 brokenLinkProvider); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7CJq8DralcjullCzLNlU6IzuowMQdXcI");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
