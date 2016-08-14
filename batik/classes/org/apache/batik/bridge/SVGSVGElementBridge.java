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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "sdzu9b9l2CLjfo5N6XDlvwxlx3kuGQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALVaeawsWVmvd9+8lZl5bx7M4jg7D2Smya1eq7vzEKiuruqt" +
           "eqnu6u6qEnjUXtW1r13dOArjwggJTOCBGGFMBCJMhkUjkcRgxhgFAjHBELdE" +
           "IMZEFEmYP0QiKp6qvvf2vfct40S9uff06XO+853v+873/c4537nPfx86FfhQ" +
           "znXMlWo64a6chLsLs7Ibrlw52O2SlRHvB7KEmXwQ0KDtqvjY5y/88MfPaBd3" +
           "oNMc9Eretp2QD3XHDsZy4JixLJHQhW0rbspWEEIXyQUf83AU6iZM6kF4hYRe" +
           "cWhoCF0m90WAgQgwEAHORIDRLRUYdIdsRxaWjuDtMPCgX4BOkNBpV0zFC6FH" +
           "jzJxeZ+39tiMMg0Ah7Pp9xlQKhuc+NAjB7pvdL5O4Q/l4Gu//raLv3cSusBB" +
           "F3R7koojAiFCMAkH3W7JliD7ASpJssRBd9myLE1kX+dNfZ3JzUGXAl21+TDy" +
           "5QMjpY2RK/vZnFvL3S6muvmRGDr+gXqKLpvS/rdTismrQNd7trpuNCTSdqDg" +
           "eR0I5iu8KO8Puc3QbSmEHj4+4kDHyz1AAIaeseRQcw6mus3mQQN0abN2Jm+r" +
           "8CT0dVsFpKecCMwSQvfflGlqa5cXDV6Vr4bQfcfpRpsuQHUuM0Q6JITuPk6W" +
           "cQKrdP+xVTq0Pt8fvOF977Db9k4msySLZir/WTDooWODxrIi+7ItypuBtz9B" +
           "fpi/50tP70AQIL77GPGG5g9+/sU3v/6hF76yofnpG9AMhYUshlfFTwh3fuMB" +
           "7PH6yVSMs64T6OniH9E8c//RXs+VxAWRd88Bx7Rzd7/zhfGfse98Tv7eDnS+" +
           "A50WHTOygB/dJTqWq5uy35Jt2edDWepA52RbwrL+DnQG1EndljetQ0UJ5LAD" +
           "3WZmTaed7DswkQJYpCY6A+q6rTj7dZcPtayeuBAEXQJ/EApBJz4AZT+bzxB6" +
           "G6w5lgzzIm/rtgOPfCfVP4BlOxSAbTVYAF5vwIET+cAFYcdXYR74gSbvdQi+" +
           "LqkyPJm1wG8KD2BgI2vbTf3M/X+fIUl1vLg8cQKY/4HjwW+CuGk7piT7V8Vr" +
           "UQN/8bNXv7ZzEAx71gkhFEy6u5l0N5t0dzPp7g0mvXykbabLS9cBkXPiRCbB" +
           "q1KRNosPls4AIADg8fbHJ2/tvv3px04Cr3OXt6XWB6TwzVEa28JGJwNHEfgu" +
           "9MJHlu+a/WJ+B9o5CrepGqDpfDp8lILkARhePh5mN+J74d3f/eHnPvyksw24" +
           "I/i9hwPXj0zj+LHjBvcdUZYAMm7ZP/EI/4WrX3ry8g50GwAHAIghDxwYWOyh" +
           "43Mciecr+9iY6nIKKKw4vsWbadc+oJ0PNd9ZblsyT7gzq98FbHwhdfDLwNa/" +
           "uefx2Wfa+0o3LV+18Zx00Y5pkWHvz07cj/31n/9TKTP3PkxfOLTxTeTwyiFo" +
           "SJldyEDgrq0P0L4sA7q/+8jogx/6/rt/LnMAQPHqG014OS0xAAlgCYGZf+Ur" +
           "3t98+1uf+ObO1mlCsDdGgqmLyYGSZ1Od7ryFkmC2127lAdBiguBLveby1LYc" +
           "SVd0XjDl1Ev/48JrCl/4l/dd3PiBCVr23ej1L81g2/5TDeidX3vbvz2UsTkh" +
           "plvb1mZbsg1evnLLGfV9fpXKkbzrLx78jS/zHwPIC9Au0NdyBmA7mQ12wKDH" +
           "b3G88XULrEa8tyXAT176tvHR735mA/fH949jxPLT197zk933Xds5tMm++rp9" +
           "7vCYzUabudEdmxX5Cfg5Af7+K/1LVyJt2ADtJWwP7R85gHvXTYA6j95KrGwK" +
           "4h8/9+QffurJd2/UuHR0j8HBEeozf/mfX9/9yHe+egNoA57r8NlKljJB4UzQ" +
           "J7JyN5UsMyuU9V1Ji4eDw7hx1MKHTm9XxWe++YM7Zj/4oxezSY8e/w6HSZ93" +
           "Nya6My0eSTW+9zhItvlAA3TlFwZvuWi+8GPAkQMcRbAdBEMfgHdyJKj2qE+d" +
           "+ds//pN73v6Nk9AOAZ0HWkoEn+ETdA4AgxxoAPcT901v3gTGMo2Ui5mq0HXK" +
           "b+LpvuzbqVt7GJGe3rbodt+/D03hqb//0XVGyED5Bk53bDwHP//R+7E3fi8b" +
           "v0XHdPRDyfUbGjjpbscWn7P+deex03+6A53hoIvi3jF6xptRijkcODoG+2dr" +
           "cNQ+0n/0GLg581w5QP8Hjnv9oWmP4/LW20A9pU7r549BcWb3BwA6fXAPpT54" +
           "HIpPQFmlkw15NCsvp8XP7CPfGdfXYxA0Gecy8OulLm3ON6UNjKflG9Kiu1nN" +
           "N9105ZtH5XoQ8L+2J9e1m8hF3USutNrfF+m0JuuqFt5IpvFLypTxSE4ATU8V" +
           "d6u7+fQ7c+NZT6bV14H5guzqksa4bvPmvhj3Lkzx8j7YzMBVBrjj5YVZzdjc" +
           "DS5vWSSlC7+7Of8fk7X8P5YVRMqdW2akA64S7/2HZ77+/ld/G7hzFzoVp64G" +
           "vPjQjIMovV396vMfevAV177z3mxvA2ac/drvln6UchVvpXFavCUt3rqv6v2p" +
           "qpPs4EjyQdjPtiNZOtA2f0gfJASbmvO/0Da844vtctBB93/IGducL6dJMpeH" +
           "cF1t1UO7tVziAjqynGHPllYtYhDoU9ZZDWixrhbF8WxR6yXhWiqFJS2W6pYU" +
           "ivXhhDInWDE/G/fxhqUK054xMfTOxMEszx9oxKyAceO84Xb5wTCPeTY/8WaD" +
           "KTv0XHPmWlWEKwqlekQHC7chaDVmYcW0EseMHStzuJg3ClNO1h10FRiUzhYE" +
           "fIwQdMdAUG5YF3WMlVdYyI7LkUGWkXpZGK5ZfMpMxcGcJdgCOm0OljZLm2ZC" +
           "tKpuQ8On+Dio9tHymLZaUitRldlSNTwfn/Kh0RxS+fm4Y/Y93epjU5ZQKJbX" +
           "2E6enxsTBUO7LKbWNc3BrTk/JuN6sZBPZljOK3rjZhw0iFI04h2OqlRWq6bT" +
           "E1jFIkS96+KG109Wk4Ykj4thwRxX+vrQ73bIdZfsKoyVq7DtMFA4nBy6tYHC" +
           "NKvAE7rRHBs6mOqxMsst6xpVYVqi7rWooO745UqSoM0i3rO6TuhErNNu9kcL" +
           "qqflBW06CHlt6eWFGtYDd+WxRdu4aU5CfUZpqssh2lzHyIgK+tNBn6s0KGq1" +
           "Flr0gI2QsUoK8mrVH7dnedmmc/UwZ5QJLJiNJ0S35TUdvYe3VaOplomhPJk3" +
           "ZWS6soBMA6sxqVQbw2jSwUO6YBRLLUCPs2q3UMxVtQnCt0KBs1gkLjeqjUGY" +
           "n+q8w6zxaK2SZM4zfJJSucCWFXallwInF6psN4/rkemiMjlkPUM0KtSUYuN6" +
           "G50Ky0qthVqYZIp9w0v4oWdS+BxHwxE+NijRxMerZt5EV9TMMyi16TawWtBz" +
           "heq80Sb6qyGKL6aqUho3FdRz+Yq66FEm5tvlpKuaIY+QgVmAS2KJbCfFzqAX" +
           "J10cldCKNp1zyKImWE23Rvf75QUz7csiyiEFhaBVe20vavwY1TvzUgm3h3zV" +
           "ruYK8rTULnBiZc13JoNmROeqRAePyAo3HPkCnfcHhTE1mDv5Atd0KkwQcMBw" +
           "3LCQr9Bzpz/q9/DItJIBUhvGK3qdIIg+qJGO7zRmWNELXKs5bDnzAre0VrOF" +
           "omnzAFtO7IaJhjOzUxfaNXTNdis00Vky9SJHaxHb7DV61qQw83JJLBI4PyZQ" +
           "piAS4jTseSNJxA2LWccdluIdXCl0ClQZHeswrMVqzLWCojMcL2fjKTYmFlTV" +
           "7fmMouMkMWG7cVDHjfGowBaIxqA97Sy9yOM8tJEYfWY+NnvMVDPE9tiWGnHd" +
           "pahmi5wvQyoa9HPVnGL0xOLaNTqNfrMuKFXDXBFxzpxWNGWOD1uFCBFKBXrY" +
           "nbVNNd+arGN8QA2Aj5edMVHkO5TS0s2EH+jrge5r2LRIrFEDt1Bu7U39Wi1q" +
           "e4mHdqjGPGLW1oqDo5xTyc/wNsOPMaYwchtFOcScBDGmkm2O9K4ktDx+zphw" +
           "ldUas8TEyE6jSxuYVZaGAdcjYt3qMlx9aqM9SoxMf6GqUU/0HafckOZeu5Ww" +
           "U8ufivyalljSinSaZXGBHpiOPDF8b4EgssVo5Toalxpmm9KTZn6FOY7gjuv6" +
           "QChQcX6YW4XNnmBpnbWYi9przxn6UwyFjSKucQluhsiIbgM/qGNMe4ZHRK8c" +
           "W01WFopzb6GNO5io5uOo1oW13pSQpIVlh+EEXc7N2XpprEpCt87g8ipa+JpP" +
           "NlVhLqyjMTrvcB7NUvpIKGjdlV2lS4zBt2VlzfakpOIPsaU4tcdVYHx4zbXX" +
           "cKvUyi8mtcUMdxI1H809zhyzGBIK62mVrYadpOG7pbW6kpQRbRlSPuAcQp/z" +
           "RnNZogN14rRmSy2CI5Js1Cu5OuxX+Dxur1UbjTgL93VN6ZO9VjGkymqFWBZV" +
           "t91G9FY/pMjWgtEayaRDr4wQmxpcvkYjs+KiUtRDeBQKeDmPtQg66hfChFPJ" +
           "QW6dcHlkMK8rubrKqh19PB+1uWWZI2Fi3e7bUqRX+tNFadWswmM4njMa2UcJ" +
           "E1Obc6MXVByBa5Y7sj2UKuGwY9GUSiJTkekPy40ZXGrKeXpR5ttKkNMQrjxp" +
           "dldRnbedDjKIq0xuwDCdwZpZIXRUiMThtDBDNUZrzpJKqdaBl+SylsAIVSkM" +
           "ibXaD0djdk5ODBTneVNVBrNalRoxzkBvVAKZUYLaOByJy1GNHeYXiSHbMdzV" +
           "KgOw0mtbzk+WPq/74ohc+WVZoFhqNBMis++usWG8qIujWG+6y7JcnnkFedSq" +
           "EHV/5JbgpAo2Tq5UXU9Uk1UbY7AzIYzvDRtzfSGJ1WJpmS/xuYihmuVcaTYa" +
           "NwpjDR3wrN6mmwnVd0K84KyW+RXiB7FrSjpWXGvIgEU9L4fOkT5ZF4j1SCKt" +
           "ktMg9JbeAttkrl1h+apqu/F6MEO6NXpRqFfiVrsEa7O4z1twXNXLrFomW4xU" +
           "6WsJM60oozo2EOMWYanzklRIcjJf6UUlat4Rux0PrYjcsM2hperKiAmbmfkE" +
           "XEf6s0qugMRUH8/NUCmi42nXJ3qLua6Pi30V44dygS6WrO68hxWcpcXpjtf3" +
           "K446F9xySFZKlZjG+jHryfBAKVYXGjNi5rw9iToJoTHjsJZH1/ISR5B2M1lP" +
           "4RrcJxnaKC31rqONSkkNg5HKNF+W4SgP6+Z6uCQb+CpelMt1glys4KCoUHK5" +
           "JFE602vXavN6c4VVl6VYSaS1orrA1EtEnzPtaZdwYt8EgGpZ4aLW95dVTGHB" +
           "jlXLJVVmuaqN5LLntBBhVJSkBPaTfDffMUWKrqNlPDDDSF1TVZ5vNyd0DW9o" +
           "mJA0bBKgTFlXy0o4JmzT48ga5rdHgdpdT9CpaBewSUzkcgwyDBhKdPqDiNSl" +
           "+UDTSjI3ixuwTRcWNs1xFBMp3XyRAIBImxE66AfmostNDbCdoYlXMeJqz9Bt" +
           "nGt4QVNelle5+bhWyiXljuC4hRomNCuopVZXa2YsOfW+l5eqESsqvbpgN/M5" +
           "ZZIr1ESrRHmWJVC04o/kyiDf5kaqiqwkpExX5VrejhdSvTbkSEahB+GwsFgE" +
           "+SSm4wTM6dV8G6gxM5dVmJdbES2ZdamON0iYr6wweFUsDxkmtIrUYjnmOnXE" +
           "djiivRzWaKIkV3ox3aeJQsIG1dXSK5WKbrs2Hs2rdH0cqUGojZpeOUSi9jDo" +
           "oyOBarajNtJsdKd4vmXUalM8nHZhz6hW5EVfxXFGW8yLgu1LeRQvMuQ4iJhF" +
           "SdAX7aEzdJlKQasmOKJ0gG/bjWZc6HfbzZqYm8HlzrRO8TWzDWDU9XKwHlHr" +
           "bgQOX0ayhhcYlRNXlWkfhkW0mEtGWKGGeFZ7gUdCECUtrC7X5uEgmVtk5A0V" +
           "dklHRn5JD0ikz8waeA7s7mI5noxwiTbcpciyJCxJLbHr2SOHakyUCLdykxlK" +
           "GIOmG65pYTItBijSUltyS7WoXFl3F6bCcK7PyEiI9shcYrYmS7gKTocMxg1g" +
           "Ai92zFo9LMFt1Wdr8IrLNRw96dMz3A2Qdr2CwRPKM7m5yfMkHyFKjgkTS/LN" +
           "ejCLOMOv4nSuY0rlpjE0+CpdnUdatZPY2tIcuVWlLzDwws3LTsnpxNyC6mAU" +
           "MygSVZGRxSLe8mvVGeBGFUxrUZUjk60PBNOj4SCK59SwLROxPHPLuc4MqQZD" +
           "ZYAv4+FyNYjrKuahfrMhSwLYIgtTzcfLfiCN1SKdrxgEYWCdbuDJbQGhGz0J" +
           "G7niMjYXgYB5cb6z7DZscTqyht0RWW8GtNWo60XH6824GjrmwekqV5r7IW9V" +
           "fIstNeZMJ1fzGZo1enIJVVqsjhY8Ky7mvAJiB9I6qgt1s4iRC8WpDBCmacbL" +
           "xExKRtSiUDS9wjkv72p5V3aLPnhSAzfKtOPqy7g9JjeecGc74TaNm6Wh7jr+" +
           "OnM4jbtNUJ3Yv8g/crNXi/1HiTTX9uDNXtqyzOInnrr2rDT8ZGFnLwNYDaHT" +
           "ew+g2wnTnOsTN8+I9bNXxm1a6stP/fP99Bu1t7+Md4qHjwl5nOWn+89/tfVa" +
           "8QM70MmDJNV1759HB105mpo678th5Nv0kQTVgwf2v3s/EfTxPft//MZvBTfP" +
           "Ar1u4zi3yK4+fYu+96TFL4XQWVUO5weJra2f/fJLZSkOM8wa3nlUt4eAmM/t" +
           "6fbc/71u127R9+G0eH8InQO6tbcZsq1yz7wc5ZIQuvuGL3D7UZF7GW95wLHv" +
           "u+7/BTZv3OJnn71w9t5np3+VvVsdvEOfI6GzSmSah7Oeh+qnXV9W9Eztc5sc" +
           "qJt9/FYI3XsTuUDEbSqZAs9u6H87hC4epw+hU9nnYbpPhtD5LR1gtakcJvlU" +
           "CJ0EJGn10+4NcoCb5G9y4lDA77lQtjiXXmpxDoYcftZKQSL7f439gI42/7Fx" +
           "Vfzcs93BO15EPrl5VhNNfr1OuZwloTObF74DUHj0ptz2eZ1uP/7jOz9/7jX7" +
           "6HXnRuCtOx+S7eEbv2Hhlhtmr07rL977+2/4nWe/laUk/xvhKb/YSCMAAA==");
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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "a/FBje/fM7mtJmr0R/wRn87+GxOQozkpMgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "m0pIeOqRTB65QiZGEl2+gjMXy0fOIZb7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "AAA=");
}
