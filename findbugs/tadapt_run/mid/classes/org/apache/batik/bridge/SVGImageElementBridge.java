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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/Aj/FZvu/wC8QJYEZx0AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "1LsruSgAAA==");
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
          ("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" +
           "/wFkwBz2LiIAAA==");
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Oi+Xe/XqOsz4bDMnEIYFboxNN9RufWp2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
