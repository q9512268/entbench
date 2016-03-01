package org.apache.batik.bridge;
public class SVGSVGElementBridge extends org.apache.batik.bridge.SVGGElementBridge implements org.apache.batik.dom.svg.SVGSVGContext {
    public SVGSVGElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_SVG_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGSVGElementBridge(
                                                            ); }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.CanvasGraphicsNode(
          );
    }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        if (!org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                e,
                ctx.
                  getUserAgent(
                    ))) {
            return null;
        }
        org.apache.batik.gvt.CanvasGraphicsNode cgn;
        cgn =
          (org.apache.batik.gvt.CanvasGraphicsNode)
            instantiateGraphicsNode(
              );
        associateSVGContext(
          ctx,
          e,
          cgn);
        try {
            org.w3c.dom.svg.SVGDocument doc =
              (org.w3c.dom.svg.SVGDocument)
                e.
                getOwnerDocument(
                  );
            org.apache.batik.dom.svg.SVGOMSVGElement se =
              (org.apache.batik.dom.svg.SVGOMSVGElement)
                e;
            boolean isOutermost =
              doc.
              getRootElement(
                ) ==
              e;
            float x =
              0;
            float y =
              0;
            if (!isOutermost) {
                org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
                  (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                    se.
                    getX(
                      );
                x =
                  _x.
                    getCheckedValue(
                      );
                org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
                  (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                    se.
                    getY(
                      );
                y =
                  _y.
                    getCheckedValue(
                      );
            }
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _width =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                se.
                getWidth(
                  );
            float w =
              _width.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _height =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                se.
                getHeight(
                  );
            float h =
              _height.
              getCheckedValue(
                );
            cgn.
              setVisible(
                org.apache.batik.bridge.CSSUtilities.
                  convertVisibility(
                    e));
            org.apache.batik.dom.svg.SVGOMAnimatedRect vb =
              (org.apache.batik.dom.svg.SVGOMAnimatedRect)
                se.
                getViewBox(
                  );
            org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio par =
              se.
              getPreserveAspectRatio(
                );
            java.awt.geom.AffineTransform viewingTransform =
              org.apache.batik.bridge.ViewBox.
              getPreserveAspectRatioTransform(
                e,
                vb,
                par,
                w,
                h,
                ctx);
            float actualWidth =
              w;
            float actualHeight =
              h;
            try {
                java.awt.geom.AffineTransform vtInv =
                  viewingTransform.
                  createInverse(
                    );
                actualWidth =
                  (float)
                    (w *
                       vtInv.
                       getScaleX(
                         ));
                actualHeight =
                  (float)
                    (h *
                       vtInv.
                       getScaleY(
                         ));
            }
            catch (java.awt.geom.NoninvertibleTransformException ex) {
                
            }
            java.awt.geom.AffineTransform positionTransform =
              java.awt.geom.AffineTransform.
              getTranslateInstance(
                x,
                y);
            if (!isOutermost) {
                cgn.
                  setPositionTransform(
                    positionTransform);
            }
            else
                if (doc ==
                      ctx.
                      getDocument(
                        )) {
                    ctx.
                      setDocumentSize(
                        new java.awt.Dimension(
                          (int)
                            (w +
                               0.5F),
                          (int)
                            (h +
                               0.5F)));
                }
            cgn.
              setViewingTransform(
                viewingTransform);
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
                    java.awt.geom.AffineTransform at =
                      new java.awt.geom.AffineTransform(
                      positionTransform);
                    at.
                      concatenate(
                        viewingTransform);
                    at =
                      at.
                        createInverse(
                          );
                    clip =
                      at.
                        createTransformedShape(
                          clip);
                    org.apache.batik.ext.awt.image.renderable.Filter filter =
                      cgn.
                      getGraphicsNodeRable(
                        true);
                    cgn.
                      setClip(
                        new org.apache.batik.ext.awt.image.renderable.ClipRable8Bit(
                          filter,
                          clip));
                }
                catch (java.awt.geom.NoninvertibleTransformException ex) {
                    
                }
            }
            java.awt.RenderingHints hints =
              null;
            hints =
              org.apache.batik.bridge.CSSUtilities.
                convertColorRendering(
                  e,
                  hints);
            if (hints !=
                  null)
                cgn.
                  setRenderingHints(
                    hints);
            java.awt.geom.Rectangle2D r =
              org.apache.batik.bridge.CSSUtilities.
              convertEnableBackground(
                e);
            if (r !=
                  null) {
                cgn.
                  setBackgroundEnable(
                    r);
            }
            if (vb.
                  isSpecified(
                    )) {
                org.w3c.dom.svg.SVGRect vbr =
                  vb.
                  getAnimVal(
                    );
                actualWidth =
                  vbr.
                    getWidth(
                      );
                actualHeight =
                  vbr.
                    getHeight(
                      );
            }
            ctx.
              openViewport(
                e,
                new org.apache.batik.bridge.SVGSVGElementBridge.SVGSVGElementViewport(
                  actualWidth,
                  actualHeight));
            return cgn;
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.GraphicsNode node) {
        node.
          setComposite(
            org.apache.batik.bridge.CSSUtilities.
              convertOpacity(
                e));
        node.
          setFilter(
            org.apache.batik.bridge.CSSUtilities.
              convertFilter(
                e,
                node,
                ctx));
        node.
          setMask(
            org.apache.batik.bridge.CSSUtilities.
              convertMask(
                e,
                node,
                ctx));
        node.
          setPointerEventType(
            org.apache.batik.bridge.CSSUtilities.
              convertPointerEvents(
                e));
        initializeDynamicSupport(
          ctx,
          e,
          node);
        ctx.
          closeViewport(
            e);
    }
    public void dispose() { ctx.removeViewport(
                                  e);
                            super.dispose(
                                    ); }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        try {
            boolean rebuild =
              false;
            if (alav.
                  getNamespaceURI(
                    ) ==
                  null) {
                java.lang.String ln =
                  alav.
                  getLocalName(
                    );
                if (ln.
                      equals(
                        SVG_WIDTH_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_HEIGHT_ATTRIBUTE)) {
                    rebuild =
                      true;
                }
                else
                    if (ln.
                          equals(
                            SVG_X_ATTRIBUTE) ||
                          ln.
                          equals(
                            SVG_Y_ATTRIBUTE)) {
                        org.w3c.dom.svg.SVGDocument doc =
                          (org.w3c.dom.svg.SVGDocument)
                            e.
                            getOwnerDocument(
                              );
                        org.apache.batik.dom.svg.SVGOMSVGElement se =
                          (org.apache.batik.dom.svg.SVGOMSVGElement)
                            e;
                        boolean isOutermost =
                          doc.
                          getRootElement(
                            ) ==
                          e;
                        if (!isOutermost) {
                            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                se.
                                getX(
                                  );
                            float x =
                              _x.
                              getCheckedValue(
                                );
                            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                se.
                                getY(
                                  );
                            float y =
                              _y.
                              getCheckedValue(
                                );
                            java.awt.geom.AffineTransform positionTransform =
                              java.awt.geom.AffineTransform.
                              getTranslateInstance(
                                x,
                                y);
                            org.apache.batik.gvt.CanvasGraphicsNode cgn;
                            cgn =
                              (org.apache.batik.gvt.CanvasGraphicsNode)
                                node;
                            cgn.
                              setPositionTransform(
                                positionTransform);
                            return;
                        }
                    }
                    else
                        if (ln.
                              equals(
                                SVG_VIEW_BOX_ATTRIBUTE) ||
                              ln.
                              equals(
                                SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE)) {
                            org.w3c.dom.svg.SVGDocument doc =
                              (org.w3c.dom.svg.SVGDocument)
                                e.
                                getOwnerDocument(
                                  );
                            org.apache.batik.dom.svg.SVGOMSVGElement se =
                              (org.apache.batik.dom.svg.SVGOMSVGElement)
                                e;
                            boolean isOutermost =
                              doc.
                              getRootElement(
                                ) ==
                              e;
                            float x =
                              0;
                            float y =
                              0;
                            if (!isOutermost) {
                                org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
                                  (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                    se.
                                    getX(
                                      );
                                x =
                                  _x.
                                    getCheckedValue(
                                      );
                                org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
                                  (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                    se.
                                    getY(
                                      );
                                y =
                                  _y.
                                    getCheckedValue(
                                      );
                            }
                            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _width =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                se.
                                getWidth(
                                  );
                            float w =
                              _width.
                              getCheckedValue(
                                );
                            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _height =
                              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                                se.
                                getHeight(
                                  );
                            float h =
                              _height.
                              getCheckedValue(
                                );
                            org.apache.batik.gvt.CanvasGraphicsNode cgn;
                            cgn =
                              (org.apache.batik.gvt.CanvasGraphicsNode)
                                node;
                            org.apache.batik.dom.svg.SVGOMAnimatedRect vb =
                              (org.apache.batik.dom.svg.SVGOMAnimatedRect)
                                se.
                                getViewBox(
                                  );
                            org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio par =
                              se.
                              getPreserveAspectRatio(
                                );
                            java.awt.geom.AffineTransform newVT =
                              org.apache.batik.bridge.ViewBox.
                              getPreserveAspectRatioTransform(
                                e,
                                vb,
                                par,
                                w,
                                h,
                                ctx);
                            java.awt.geom.AffineTransform oldVT =
                              cgn.
                              getViewingTransform(
                                );
                            if (newVT.
                                  getScaleX(
                                    ) !=
                                  oldVT.
                                  getScaleX(
                                    ) ||
                                  newVT.
                                  getScaleY(
                                    ) !=
                                  oldVT.
                                  getScaleY(
                                    ) ||
                                  newVT.
                                  getShearX(
                                    ) !=
                                  oldVT.
                                  getShearX(
                                    ) ||
                                  newVT.
                                  getShearY(
                                    ) !=
                                  oldVT.
                                  getShearY(
                                    ))
                                rebuild =
                                  true;
                            else {
                                cgn.
                                  setViewingTransform(
                                    newVT);
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
                                        java.awt.geom.AffineTransform at;
                                        at =
                                          cgn.
                                            getPositionTransform(
                                              );
                                        if (at ==
                                              null)
                                            at =
                                              new java.awt.geom.AffineTransform(
                                                );
                                        else
                                            at =
                                              new java.awt.geom.AffineTransform(
                                                at);
                                        at.
                                          concatenate(
                                            newVT);
                                        at =
                                          at.
                                            createInverse(
                                              );
                                        clip =
                                          at.
                                            createTransformedShape(
                                              clip);
                                        org.apache.batik.ext.awt.image.renderable.Filter filter =
                                          cgn.
                                          getGraphicsNodeRable(
                                            true);
                                        cgn.
                                          setClip(
                                            new org.apache.batik.ext.awt.image.renderable.ClipRable8Bit(
                                              filter,
                                              clip));
                                    }
                                    catch (java.awt.geom.NoninvertibleTransformException ex) {
                                        
                                    }
                                }
                            }
                        }
                if (rebuild) {
                    org.apache.batik.gvt.CompositeGraphicsNode gn =
                      node.
                      getParent(
                        );
                    gn.
                      remove(
                        node);
                    disposeTree(
                      e,
                      false);
                    handleElementAdded(
                      gn,
                      e.
                        getParentNode(
                          ),
                      e);
                    return;
                }
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
    public static class SVGSVGElementViewport implements org.apache.batik.bridge.Viewport {
        private float width;
        private float height;
        public SVGSVGElementViewport(float w,
                                     float h) {
            super(
              );
            this.
              width =
              w;
            this.
              height =
              h;
        }
        public float getWidth() { return width;
        }
        public float getHeight() { return height;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "3L3Ihg3/Ax3eO9SNGAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "fOabP7hj+oM/fCmf9PjR8GiYUIKzNdGdWfFIpvG9J0GyK3gqoMNepN960Xjx" +
           "R4DjAnAUwXbgDV0A3vGxoNqjPn3b3/zRH9/zjm/cAu20ofNAS6kt5PgEnQPA" +
           "IHsqwP3Y+dm3bAMjyiLlYq4qdI3y23i6L/92+uYe1s5Odofodt+/D43le/7u" +
           "364xQg7K13G6E+MXyAsfu7/x5u/l4w/RMRv9UHzthgZOwYdjS8+b/7Lz2Jk/" +
           "2YFuW0AXxb0j9lQwggxzFuBY6e2fu8Ex/Fj/8SPi9jz05AH6P3DS649MexKX" +
           "D70N1DPqrH7+BBTndn8AoNOH91Dqwyeh+BSUV3r5kEfz8nJW/NQ+8t3muFoI" +
           "gibnjAG/jjRpe/ZBtzCelW/KCnK7mj97w5VvHpfrQcD/6p5cV28gF3MDubIq" +
           "tS/SGVXWVqp/PZnGLytTziM+BTQ9XdrFdwvZd/76s96SVd8A5vPya00W45ol" +
           "GPti3Ksb4uV9sJmCaw5wx8u6geds7gYXuzySsoXf3d4NTsiK/Y9lBZFy5yGz" +
           "gQ2uGe//+2e+/sHXfhu4MwmdDjNXA158ZEY6yG5ev/rCRx581dXvvD/f24AZ" +
           "R8+2Lr4l4yreTOOseGtWvG1f1fszVSf5wXEgeD6Vb0eydKBt4Yg+FR9savb/" +
           "Qlv/DqeLeb36/s+gOBdKMRfHM5lfwnTE1DQGXc+pujfR4WRGaqbDktS8ihOq" +
           "PhVL4jhkF45ZG+I+jsmVmoH6VlXut1rDVVOLq3a0woymUu/artAj2kxR8LmN" +
           "0d+MyJbDEj1UIPsqWULiXmnFOEhHEw136ZgLA6+leGmlqGwDg7smS1tpSOEL" +
           "GC93KnqHbjd43efWTZ+uDfVuk2KF0Vyk1skUa5vwojTrFQdjBEvkWbNSiwrd" +
           "VUUttSm0P+/S9UhbLkiCMoR5RVOX5IbbxP2YjjsTsi9phNUiqYXMdqZ0l+N9" +
           "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");
    }
    public java.util.List getIntersectionList(org.w3c.dom.svg.SVGRect svgRect,
                                              org.w3c.dom.Element end) {
        java.util.List ret =
          new java.util.ArrayList(
          );
        java.awt.geom.Rectangle2D rect =
          new java.awt.geom.Rectangle2D.Float(
          svgRect.
            getX(
              ),
          svgRect.
            getY(
              ),
          svgRect.
            getWidth(
              ),
          svgRect.
            getHeight(
              ));
        org.apache.batik.gvt.GraphicsNode svgGN =
          ctx.
          getGraphicsNode(
            e);
        if (svgGN ==
              null)
            return ret;
        java.awt.geom.Rectangle2D svgBounds =
          svgGN.
          getSensitiveBounds(
            );
        if (svgBounds ==
              null)
            return ret;
        if (!rect.
              intersects(
                svgBounds))
            return ret;
        org.w3c.dom.Element base =
          e;
        java.awt.geom.AffineTransform ati =
          svgGN.
          getGlobalTransform(
            );
        try {
            ati =
              ati.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        org.w3c.dom.Element curr;
        org.w3c.dom.Node next =
          base.
          getFirstChild(
            );
        while (next !=
                 null) {
            if (next instanceof org.w3c.dom.Element)
                break;
            next =
              next.
                getNextSibling(
                  );
        }
        if (next ==
              null)
            return ret;
        curr =
          (org.w3c.dom.Element)
            next;
        java.util.Set ancestors =
          null;
        if (end !=
              null) {
            ancestors =
              getAncestors(
                end,
                base);
            if (ancestors ==
                  null)
                end =
                  null;
        }
        while (curr !=
                 null) {
            java.lang.String nsURI =
              curr.
              getNamespaceURI(
                );
            java.lang.String tag =
              curr.
              getLocalName(
                );
            boolean isGroup;
            isGroup =
              SVG_NAMESPACE_URI.
                equals(
                  nsURI) &&
                (SVG_G_TAG.
                   equals(
                     tag) ||
                   SVG_SVG_TAG.
                   equals(
                     tag) ||
                   SVG_A_TAG.
                   equals(
                     tag));
            org.apache.batik.gvt.GraphicsNode gn =
              ctx.
              getGraphicsNode(
                curr);
            if (gn ==
                  null) {
                if (ancestors !=
                      null &&
                      ancestors.
                      contains(
                        curr))
                    break;
                curr =
                  getNext(
                    curr,
                    base,
                    end);
                continue;
            }
            java.awt.geom.AffineTransform at =
              gn.
              getGlobalTransform(
                );
            java.awt.geom.Rectangle2D gnBounds =
              gn.
              getSensitiveBounds(
                );
            at.
              preConcatenate(
                ati);
            if (gnBounds !=
                  null)
                gnBounds =
                  at.
                    createTransformedShape(
                      gnBounds).
                    getBounds2D(
                      );
            if (gnBounds ==
                  null ||
                  !rect.
                  intersects(
                    gnBounds)) {
                if (ancestors !=
                      null &&
                      ancestors.
                      contains(
                        curr))
                    break;
                curr =
                  getNext(
                    curr,
                    base,
                    end);
                continue;
            }
            if (isGroup) {
                next =
                  curr.
                    getFirstChild(
                      );
                while (next !=
                         null) {
                    if (next instanceof org.w3c.dom.Element)
                        break;
                    next =
                      next.
                        getNextSibling(
                          );
                }
                if (next !=
                      null) {
                    curr =
                      (org.w3c.dom.Element)
                        next;
                    continue;
                }
            }
            else {
                if (curr ==
                      end)
                    break;
                if (SVG_NAMESPACE_URI.
                      equals(
                        nsURI) &&
                      SVG_USE_TAG.
                      equals(
                        tag)) {
                    if (rect.
                          contains(
                            gnBounds))
                        ret.
                          add(
                            curr);
                }
                if (gn instanceof org.apache.batik.gvt.ShapeNode) {
                    org.apache.batik.gvt.ShapeNode sn =
                      (org.apache.batik.gvt.ShapeNode)
                        gn;
                    java.awt.Shape sensitive =
                      sn.
                      getSensitiveArea(
                        );
                    if (sensitive !=
                          null) {
                        sensitive =
                          at.
                            createTransformedShape(
                              sensitive);
                        if (sensitive.
                              intersects(
                                rect))
                            ret.
                              add(
                                curr);
                    }
                }
                else
                    if (gn instanceof org.apache.batik.gvt.TextNode) {
                        org.apache.batik.dom.svg.SVGOMElement svgElem =
                          (org.apache.batik.dom.svg.SVGOMElement)
                            curr;
                        org.apache.batik.bridge.SVGTextElementBridge txtBridge;
                        txtBridge =
                          (org.apache.batik.bridge.SVGTextElementBridge)
                            svgElem.
                            getSVGContext(
                              );
                        java.util.Set elems =
                          txtBridge.
                          getTextIntersectionSet(
                            at,
                            rect);
                        if (ancestors !=
                              null &&
                              ancestors.
                              contains(
                                curr))
                            filterChildren(
                              curr,
                              end,
                              elems,
                              ret);
                        else
                            ret.
                              addAll(
                                elems);
                    }
                    else {
                        ret.
                          add(
                            curr);
                    }
            }
            curr =
              getNext(
                curr,
                base,
                end);
        }
        return ret;
    }
    public java.util.List getEnclosureList(org.w3c.dom.svg.SVGRect svgRect,
                                           org.w3c.dom.Element end) {
        java.util.List ret =
          new java.util.ArrayList(
          );
        java.awt.geom.Rectangle2D rect =
          new java.awt.geom.Rectangle2D.Float(
          svgRect.
            getX(
              ),
          svgRect.
            getY(
              ),
          svgRect.
            getWidth(
              ),
          svgRect.
            getHeight(
              ));
        org.apache.batik.gvt.GraphicsNode svgGN =
          ctx.
          getGraphicsNode(
            e);
        if (svgGN ==
              null)
            return ret;
        java.awt.geom.Rectangle2D svgBounds =
          svgGN.
          getSensitiveBounds(
            );
        if (svgBounds ==
              null)
            return ret;
        if (!rect.
              intersects(
                svgBounds))
            return ret;
        org.w3c.dom.Element base =
          e;
        java.awt.geom.AffineTransform ati =
          svgGN.
          getGlobalTransform(
            );
        try {
            ati =
              ati.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        org.w3c.dom.Element curr;
        org.w3c.dom.Node next =
          base.
          getFirstChild(
            );
        while (next !=
                 null) {
            if (next instanceof org.w3c.dom.Element)
                break;
            next =
              next.
                getNextSibling(
                  );
        }
        if (next ==
              null)
            return ret;
        curr =
          (org.w3c.dom.Element)
            next;
        java.util.Set ancestors =
          null;
        if (end !=
              null) {
            ancestors =
              getAncestors(
                end,
                base);
            if (ancestors ==
                  null)
                end =
                  null;
        }
        while (curr !=
                 null) {
            java.lang.String nsURI =
              curr.
              getNamespaceURI(
                );
            java.lang.String tag =
              curr.
              getLocalName(
                );
            boolean isGroup;
            isGroup =
              SVG_NAMESPACE_URI.
                equals(
                  nsURI) &&
                (SVG_G_TAG.
                   equals(
                     tag) ||
                   SVG_SVG_TAG.
                   equals(
                     tag) ||
                   SVG_A_TAG.
                   equals(
                     tag));
            org.apache.batik.gvt.GraphicsNode gn =
              ctx.
              getGraphicsNode(
                curr);
            if (gn ==
                  null) {
                if (ancestors !=
                      null &&
                      ancestors.
                      contains(
                        curr))
                    break;
                curr =
                  getNext(
                    curr,
                    base,
                    end);
                continue;
            }
            java.awt.geom.AffineTransform at =
              gn.
              getGlobalTransform(
                );
            java.awt.geom.Rectangle2D gnBounds =
              gn.
              getSensitiveBounds(
                );
            at.
              preConcatenate(
                ati);
            if (gnBounds !=
                  null)
                gnBounds =
                  at.
                    createTransformedShape(
                      gnBounds).
                    getBounds2D(
                      );
            if (gnBounds ==
                  null ||
                  !rect.
                  intersects(
                    gnBounds)) {
                if (ancestors !=
                      null &&
                      ancestors.
                      contains(
                        curr))
                    break;
                curr =
                  getNext(
                    curr,
                    base,
                    end);
                continue;
            }
            if (isGroup) {
                next =
                  curr.
                    getFirstChild(
                      );
                while (next !=
                         null) {
                    if (next instanceof org.w3c.dom.Element)
                        break;
                    next =
                      next.
                        getNextSibling(
                          );
                }
                if (next !=
                      null) {
                    curr =
                      (org.w3c.dom.Element)
                        next;
                    continue;
                }
            }
            else {
                if (curr ==
                      end)
                    break;
                if (SVG_NAMESPACE_URI.
                      equals(
                        nsURI) &&
                      SVG_USE_TAG.
                      equals(
                        tag)) {
                    if (rect.
                          contains(
                            gnBounds))
                        ret.
                          add(
                            curr);
                }
                else
                    if (gn instanceof org.apache.batik.gvt.TextNode) {
                        org.apache.batik.dom.svg.SVGOMElement svgElem =
                          (org.apache.batik.dom.svg.SVGOMElement)
                            curr;
                        org.apache.batik.bridge.SVGTextElementBridge txtBridge;
                        txtBridge =
                          (org.apache.batik.bridge.SVGTextElementBridge)
                            svgElem.
                            getSVGContext(
                              );
                        java.util.Set elems =
                          txtBridge.
                          getTextEnclosureSet(
                            at,
                            rect);
                        if (ancestors !=
                              null &&
                              ancestors.
                              contains(
                                curr))
                            filterChildren(
                              curr,
                              end,
                              elems,
                              ret);
                        else
                            ret.
                              addAll(
                                elems);
                    }
                    else
                        if (rect.
                              contains(
                                gnBounds)) {
                            ret.
                              add(
                                curr);
                        }
            }
            curr =
              getNext(
                curr,
                base,
                end);
        }
        return ret;
    }
    public boolean checkIntersection(org.w3c.dom.Element element,
                                     org.w3c.dom.svg.SVGRect svgRect) {
        org.apache.batik.gvt.GraphicsNode svgGN =
          ctx.
          getGraphicsNode(
            e);
        if (svgGN ==
              null)
            return false;
        java.awt.geom.Rectangle2D rect =
          new java.awt.geom.Rectangle2D.Float(
          svgRect.
            getX(
              ),
          svgRect.
            getY(
              ),
          svgRect.
            getWidth(
              ),
          svgRect.
            getHeight(
              ));
        java.awt.geom.AffineTransform ati =
          svgGN.
          getGlobalTransform(
            );
        try {
            ati =
              ati.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        org.apache.batik.dom.svg.SVGContext svgctx =
          null;
        if (element instanceof org.apache.batik.dom.svg.SVGOMElement) {
            svgctx =
              ((org.apache.batik.dom.svg.SVGOMElement)
                 element).
                getSVGContext(
                  );
            if (svgctx instanceof org.apache.batik.bridge.SVGTextElementBridge ||
                  svgctx instanceof org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext) {
                return org.apache.batik.bridge.SVGTextElementBridge.
                  getTextIntersection(
                    ctx,
                    element,
                    ati,
                    rect,
                    true);
            }
        }
        java.awt.geom.Rectangle2D gnBounds =
          null;
        org.apache.batik.gvt.GraphicsNode gn =
          ctx.
          getGraphicsNode(
            element);
        if (gn !=
              null)
            gnBounds =
              gn.
                getSensitiveBounds(
                  );
        if (gnBounds ==
              null)
            return false;
        java.awt.geom.AffineTransform at =
          gn.
          getGlobalTransform(
            );
        at.
          preConcatenate(
            ati);
        gnBounds =
          at.
            createTransformedShape(
              gnBounds).
            getBounds2D(
              );
        if (!rect.
              intersects(
                gnBounds))
            return false;
        if (!(gn instanceof org.apache.batik.gvt.ShapeNode))
            return true;
        org.apache.batik.gvt.ShapeNode sn =
          (org.apache.batik.gvt.ShapeNode)
            gn;
        java.awt.Shape sensitive =
          sn.
          getSensitiveArea(
            );
        if (sensitive ==
              null)
            return false;
        sensitive =
          at.
            createTransformedShape(
              sensitive);
        if (sensitive.
              intersects(
                rect))
            return true;
        return false;
    }
    public boolean checkEnclosure(org.w3c.dom.Element element,
                                  org.w3c.dom.svg.SVGRect svgRect) {
        org.apache.batik.gvt.GraphicsNode gn =
          ctx.
          getGraphicsNode(
            element);
        java.awt.geom.Rectangle2D gnBounds =
          null;
        org.apache.batik.dom.svg.SVGContext svgctx =
          null;
        if (element instanceof org.apache.batik.dom.svg.SVGOMElement) {
            svgctx =
              ((org.apache.batik.dom.svg.SVGOMElement)
                 element).
                getSVGContext(
                  );
            if (svgctx instanceof org.apache.batik.bridge.SVGTextElementBridge ||
                  svgctx instanceof org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext) {
                gnBounds =
                  org.apache.batik.bridge.SVGTextElementBridge.
                    getTextBounds(
                      ctx,
                      element,
                      true);
                org.w3c.dom.Element p =
                  (org.w3c.dom.Element)
                    element.
                    getParentNode(
                      );
                while (p !=
                         null &&
                         gn ==
                         null) {
                    gn =
                      ctx.
                        getGraphicsNode(
                          p);
                    p =
                      (org.w3c.dom.Element)
                        p.
                        getParentNode(
                          );
                }
            }
            else
                if (gn !=
                      null)
                    gnBounds =
                      gn.
                        getSensitiveBounds(
                          );
        }
        else
            if (gn !=
                  null)
                gnBounds =
                  gn.
                    getSensitiveBounds(
                      );
        if (gnBounds ==
              null)
            return false;
        org.apache.batik.gvt.GraphicsNode svgGN =
          ctx.
          getGraphicsNode(
            e);
        if (svgGN ==
              null)
            return false;
        java.awt.geom.Rectangle2D rect =
          new java.awt.geom.Rectangle2D.Float(
          svgRect.
            getX(
              ),
          svgRect.
            getY(
              ),
          svgRect.
            getWidth(
              ),
          svgRect.
            getHeight(
              ));
        java.awt.geom.AffineTransform ati =
          svgGN.
          getGlobalTransform(
            );
        try {
            ati =
              ati.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        java.awt.geom.AffineTransform at =
          gn.
          getGlobalTransform(
            );
        at.
          preConcatenate(
            ati);
        gnBounds =
          at.
            createTransformedShape(
              gnBounds).
            getBounds2D(
              );
        return rect.
          contains(
            gnBounds);
    }
    public boolean filterChildren(org.w3c.dom.Element curr,
                                  org.w3c.dom.Element end,
                                  java.util.Set elems,
                                  java.util.List ret) {
        org.w3c.dom.Node child =
          curr.
          getFirstChild(
            );
        while (child !=
                 null) {
            if (child instanceof org.w3c.dom.Element &&
                  filterChildren(
                    (org.w3c.dom.Element)
                      child,
                    end,
                    elems,
                    ret))
                return true;
            child =
              child.
                getNextSibling(
                  );
        }
        if (curr ==
              end)
            return true;
        if (elems.
              contains(
                curr))
            ret.
              add(
                curr);
        return false;
    }
    protected java.util.Set getAncestors(org.w3c.dom.Element end,
                                         org.w3c.dom.Element base) {
        java.util.Set ret =
          new java.util.HashSet(
          );
        org.w3c.dom.Element p =
          end;
        do  {
            ret.
              add(
                p);
            p =
              (org.w3c.dom.Element)
                p.
                getParentNode(
                  );
        }while(p !=
                 null &&
                 p !=
                 base); 
        if (p ==
              null)
            return null;
        return ret;
    }
    protected org.w3c.dom.Element getNext(org.w3c.dom.Element curr,
                                          org.w3c.dom.Element base,
                                          org.w3c.dom.Element end) {
        org.w3c.dom.Node next;
        next =
          curr.
            getNextSibling(
              );
        while (next !=
                 null) {
            if (next instanceof org.w3c.dom.Element)
                break;
            next =
              next.
                getNextSibling(
                  );
        }
        while (next ==
                 null) {
            curr =
              (org.w3c.dom.Element)
                curr.
                getParentNode(
                  );
            if (curr ==
                  end ||
                  curr ==
                  base) {
                next =
                  null;
                break;
            }
            next =
              curr.
                getNextSibling(
                  );
            while (next !=
                     null) {
                if (next instanceof org.w3c.dom.Element)
                    break;
                next =
                  next.
                    getNextSibling(
                      );
            }
        }
        return (org.w3c.dom.Element)
                 next;
    }
    public void deselectAll() { ctx.getUserAgent(
                                      ).deselectAll(
                                          );
    }
    public int suspendRedraw(int max_wait_milliseconds) {
        org.apache.batik.bridge.UpdateManager um =
          ctx.
          getUpdateManager(
            );
        if (um !=
              null)
            return um.
              addRedrawSuspension(
                max_wait_milliseconds);
        return -1;
    }
    public boolean unsuspendRedraw(int suspend_handle_id) {
        org.apache.batik.bridge.UpdateManager um =
          ctx.
          getUpdateManager(
            );
        if (um !=
              null)
            return um.
              releaseRedrawSuspension(
                suspend_handle_id);
        return false;
    }
    public void unsuspendRedrawAll() { org.apache.batik.bridge.UpdateManager um =
                                         ctx.
                                         getUpdateManager(
                                           );
                                       if (um !=
                                             null)
                                           um.
                                             releaseAllRedrawSuspension(
                                               );
    }
    public void forceRedraw() { org.apache.batik.bridge.UpdateManager um =
                                  ctx.
                                  getUpdateManager(
                                    );
                                if (um !=
                                      null)
                                    um.
                                      forceRepaint(
                                        );
    }
    public void pauseAnimations() { ctx.getAnimationEngine(
                                          ).
                                      pause(
                                        );
    }
    public void unpauseAnimations() { ctx.
                                        getAnimationEngine(
                                          ).
                                        unpause(
                                          );
    }
    public boolean animationsPaused() { return ctx.
                                          getAnimationEngine(
                                            ).
                                          isPaused(
                                            );
    }
    public float getCurrentTime() { return ctx.
                                      getAnimationEngine(
                                        ).
                                      getCurrentTime(
                                        );
    }
    public void setCurrentTime(float t) {
        ctx.
          getAnimationEngine(
            ).
          setCurrentTime(
            t);
    }
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
       "bwIffscW/sboxYW8wIVDOE+eLeKdxTos");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("fW9WOkbE3K7tXr7Ie3nhDM5+NiO/EBTuET35FFOznOf3/PrFc/Arf9WgAj7f" +
       "2/HruzeGXxf33ueXM/KZfMx50S+cAfqLGfk14J6EUDelq9RjfMwpzYPCTZGj" +
       "S3s+fO68fPhxAOnCtu72+8bak6+ckfc7GfnNoHCrpPuu4+ci/o09tN86L7Q3" +
       "g1HeuYN2x42BdnDSiyPX9eKYrVvZ2TKtRzIWBJ4uhIGcn4Pn7X7tDLb8u4z8" +
       "W2BSNd6WTPmwpaNWWiBdlaVT3PrqObiVF3sc4Hpxx60X/58YkPuPm4RdqDMC" +
       "5jifK3kDf3IGW/5LRv4IGJbc+wSy529fTcleQjlxrHsythnxcR4wPSP+1vBb" +
       "X/90+uLnt6e2Au/LQaF4vfdfr34FN3uB6skzXgLbvxn5A/KnXvqL/zp752FI" +
       "dudJtbx0FqMPeXXX8fdVtu/2fHsv7P9wXmE/AsSCbutuv2+YsLOf39hL9C/P" +
       "kOj/yMifB4XLQKKELZqOH3r5u0156T+9imtnj/jbp3j0nXPw6N4s8QnQ05d2" +
       "PX7phvModw7fyEv99Rk8+puM/AA4B2BiROO43l/LOdwqOI4p8/aeCz88Lxce" +
       "BeP97o4LN8hPXpMLB7dfnwsHd2bkJjArci4c6UpW9G+PsB7cfAOwXrxvW3f7" +
       "fX6sN+UFbjrC+plTuv1Y1s2ToL/7d/3efz2L8Oq9RRjLmUE4eOBUW2/OqpbP" +
       "ams/T3K2vuYMlj+YkcuA5YpuAqVraSA28WT7FMvvPu9yBizXLr5xN9w3vlKW" +
       "P/d/pV65ITp4wxlYn8rIY9uFG5YtarJrAKeYe1dW+u6XGe3BA3u55Px5/Bz8" +
       "yTUQLPcu7szexVdsqK/Nn2Nh6mdOMal6BpOyzZKDErAxgEl94P722pwjLZ83" +
       "WsuQDndIhzdm8h0fPnZGXisjbwELWxByy9kbr5iZX2bYh1cHbz3v+iyb49Md" +
       "vOmNgXc8GD3lCC7q29XWAXMG7FFGOsCy+KHvyrY0kiWPzzYxDvp74N3zAn8D" +
       "APyOHfB33FDg+UhzJD9zBsp3ZQSw5FJon8Z53JItzqu/EMC3W4BfvEEL8OMw" +
       "tDPyVhkRwbL5FMSr1Vg6L8qnADp1h1K98SiDM/KijDhBfrdAlPdCPAbPPS+8" +
       "LAJwd/DcGw/v/WfkfTAj7wF66vKhv1v1HYZ5xyC+97wQH888wA5ifOMhfuyM" +
       "vOcy8mEQzIb22SA/ct5ILgP5vh3I9914kJ86I+8XM/LzYFXDH6FjM7DSKYPz" +
       "/Dkw5scODwNsH9ph/NCNx/jZM/L+SUZ+GQSHIBZohR6IC4OJbl1zv+pmxXT4" +
       "YA/7H59XfzN/8rEd7I/dGNjH/Mmv5vj+2RnYv5yRLwDs/gnspzT4xVcCMwkK" +
       "917jllp25eaBq67Jbq92il944dJt978w/ZP8otbR9cvb6cJtSmiax29IHHu+" +
       "xfVkRc95cPv2voSbY/oXu82Za+zuBoVbhKMt/IPf3pb/HaDep8sDUeffx8v9" +
       "66Bwx74caGr7cLzIV0GwAopkj7/r5pwBa52nzrjLd5JHyTb8eeC4wuQL33te" +
       "TgBHVY5f8Mq2dfL7y4dnWCG72z168QWq/57vo7+yvWAmmnyaZq3cRhdu3d51" +
       "yxvNzsEevW5rh23d0nnqR3d98fYnDzeI7toOeK+8x8b28LVvcxGWG+T3r9Lf" +
       "vP9Lb/mnL/xZfqXj/wCJJnUYWD4AAA==");
}
