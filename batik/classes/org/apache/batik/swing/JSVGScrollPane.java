package org.apache.batik.swing;
public class JSVGScrollPane extends javax.swing.JPanel {
    protected org.apache.batik.swing.JSVGCanvas canvas;
    protected javax.swing.JPanel horizontalPanel;
    protected javax.swing.JScrollBar vertical;
    protected javax.swing.JScrollBar horizontal;
    protected java.awt.Component cornerBox;
    protected boolean scrollbarsAlwaysVisible = false;
    protected org.apache.batik.swing.JSVGScrollPane.SBListener hsbListener;
    protected org.apache.batik.swing.JSVGScrollPane.SBListener vsbListener;
    protected java.awt.geom.Rectangle2D viewBox = null;
    protected boolean ignoreScrollChange = false;
    public JSVGScrollPane(org.apache.batik.swing.JSVGCanvas canvas) { super(
                                                                        );
                                                                      this.
                                                                        canvas =
                                                                        canvas;
                                                                      canvas.
                                                                        setRecenterOnResize(
                                                                          false);
                                                                      vertical =
                                                                        new javax.swing.JScrollBar(
                                                                          javax.swing.JScrollBar.
                                                                            VERTICAL,
                                                                          0,
                                                                          0,
                                                                          0,
                                                                          0);
                                                                      horizontal =
                                                                        new javax.swing.JScrollBar(
                                                                          javax.swing.JScrollBar.
                                                                            HORIZONTAL,
                                                                          0,
                                                                          0,
                                                                          0,
                                                                          0);
                                                                      horizontalPanel =
                                                                        new javax.swing.JPanel(
                                                                          new java.awt.BorderLayout(
                                                                            ));
                                                                      horizontalPanel.
                                                                        add(
                                                                          horizontal,
                                                                          java.awt.BorderLayout.
                                                                            CENTER);
                                                                      cornerBox =
                                                                        javax.swing.Box.
                                                                          createRigidArea(
                                                                            new java.awt.Dimension(
                                                                              vertical.
                                                                                getPreferredSize(
                                                                                  ).
                                                                                width,
                                                                              horizontal.
                                                                                getPreferredSize(
                                                                                  ).
                                                                                height));
                                                                      horizontalPanel.
                                                                        add(
                                                                          cornerBox,
                                                                          java.awt.BorderLayout.
                                                                            EAST);
                                                                      hsbListener =
                                                                        createScrollBarListener(
                                                                          false);
                                                                      horizontal.
                                                                        getModel(
                                                                          ).
                                                                        addChangeListener(
                                                                          hsbListener);
                                                                      vsbListener =
                                                                        createScrollBarListener(
                                                                          true);
                                                                      vertical.
                                                                        getModel(
                                                                          ).
                                                                        addChangeListener(
                                                                          vsbListener);
                                                                      updateScrollbarState(
                                                                        false,
                                                                        false);
                                                                      setLayout(
                                                                        new java.awt.BorderLayout(
                                                                          ));
                                                                      add(
                                                                        canvas,
                                                                        java.awt.BorderLayout.
                                                                          CENTER);
                                                                      add(
                                                                        vertical,
                                                                        java.awt.BorderLayout.
                                                                          EAST);
                                                                      add(
                                                                        horizontalPanel,
                                                                        java.awt.BorderLayout.
                                                                          SOUTH);
                                                                      canvas.
                                                                        addSVGDocumentLoaderListener(
                                                                          createLoadListener(
                                                                            ));
                                                                      org.apache.batik.swing.JSVGScrollPane.ScrollListener xlistener =
                                                                        createScrollListener(
                                                                          );
                                                                      addComponentListener(
                                                                        xlistener);
                                                                      canvas.
                                                                        addGVTTreeRendererListener(
                                                                          xlistener);
                                                                      canvas.
                                                                        addJGVTComponentListener(
                                                                          xlistener);
                                                                      canvas.
                                                                        addGVTTreeBuilderListener(
                                                                          xlistener);
                                                                      canvas.
                                                                        addUpdateManagerListener(
                                                                          xlistener);
    }
    public boolean getScrollbarsAlwaysVisible() {
        return scrollbarsAlwaysVisible;
    }
    public void setScrollbarsAlwaysVisible(boolean vis) {
        scrollbarsAlwaysVisible =
          vis;
        resizeScrollBars(
          );
    }
    protected org.apache.batik.swing.JSVGScrollPane.SBListener createScrollBarListener(boolean isVertical) {
        return new org.apache.batik.swing.JSVGScrollPane.SBListener(
          isVertical);
    }
    protected org.apache.batik.swing.JSVGScrollPane.ScrollListener createScrollListener() {
        return new org.apache.batik.swing.JSVGScrollPane.ScrollListener(
          );
    }
    protected org.apache.batik.swing.svg.SVGDocumentLoaderListener createLoadListener() {
        return new org.apache.batik.swing.JSVGScrollPane.SVGScrollDocumentLoaderListener(
          );
    }
    public org.apache.batik.swing.JSVGCanvas getCanvas() {
        return canvas;
    }
    class SVGScrollDocumentLoaderListener extends org.apache.batik.swing.svg.SVGDocumentLoaderAdapter {
        public void documentLoadingCompleted(org.apache.batik.swing.svg.SVGDocumentLoaderEvent e) {
            org.apache.batik.dom.events.NodeEventTarget root =
              (org.apache.batik.dom.events.NodeEventTarget)
                e.
                getSVGDocument(
                  ).
                getRootElement(
                  );
            root.
              addEventListenerNS(
                org.apache.batik.util.XMLConstants.
                  XML_EVENTS_NAMESPACE_URI,
                org.apache.batik.util.SVGConstants.
                  SVG_SVGZOOM_EVENT_TYPE,
                new org.w3c.dom.events.EventListener(
                  ) {
                    public void handleEvent(org.w3c.dom.events.Event evt) {
                        if (!(evt.
                                getTarget(
                                  ) instanceof org.w3c.dom.svg.SVGSVGElement))
                            return;
                        org.w3c.dom.svg.SVGSVGElement svg =
                          (org.w3c.dom.svg.SVGSVGElement)
                            evt.
                            getTarget(
                              );
                        scaleChange(
                          svg.
                            getCurrentScale(
                              ));
                    }
                },
                false,
                null);
        }
        public SVGScrollDocumentLoaderListener() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "fYqze5I/suHp/wDT8Nk8tBQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "xE7/8LW//+bfevabeSHtfwAccuosmx8AAA==");
    }
    public void reset() { viewBox = null;
                          updateScrollbarState(
                            false,
                            false);
                          revalidate(); }
    protected void setScrollPosition() { checkAndSetViewBoxRect(
                                           );
                                         if (viewBox ==
                                               null)
                                             return;
                                         java.awt.geom.AffineTransform crt =
                                           canvas.
                                           getRenderingTransform(
                                             );
                                         java.awt.geom.AffineTransform vbt =
                                           canvas.
                                           getViewBoxTransform(
                                             );
                                         if (crt ==
                                               null)
                                             crt =
                                               new java.awt.geom.AffineTransform(
                                                 );
                                         if (vbt ==
                                               null)
                                             vbt =
                                               new java.awt.geom.AffineTransform(
                                                 );
                                         java.awt.Rectangle r2d =
                                           vbt.
                                           createTransformedShape(
                                             viewBox).
                                           getBounds(
                                             );
                                         int tx =
                                           0;
                                         int ty =
                                           0;
                                         if (r2d.
                                               x <
                                               0)
                                             tx -=
                                               r2d.
                                                 x;
                                         if (r2d.
                                               y <
                                               0)
                                             ty -=
                                               r2d.
                                                 y;
                                         int deltaX =
                                           horizontal.
                                           getValue(
                                             ) -
                                           tx;
                                         int deltaY =
                                           vertical.
                                           getValue(
                                             ) -
                                           ty;
                                         crt.
                                           preConcatenate(
                                             java.awt.geom.AffineTransform.
                                               getTranslateInstance(
                                                 -deltaX,
                                                 -deltaY));
                                         canvas.
                                           setRenderingTransform(
                                             crt);
    }
    protected class SBListener implements javax.swing.event.ChangeListener {
        protected boolean inDrag = false;
        protected int startValue;
        protected boolean isVertical;
        public SBListener(boolean vertical) {
            super(
              );
            isVertical =
              vertical;
        }
        public synchronized void stateChanged(javax.swing.event.ChangeEvent e) {
            if (ignoreScrollChange)
                return;
            java.lang.Object src =
              e.
              getSource(
                );
            if (!(src instanceof javax.swing.BoundedRangeModel))
                return;
            int val =
              isVertical
              ? vertical.
              getValue(
                )
              : horizontal.
              getValue(
                );
            javax.swing.BoundedRangeModel brm =
              (javax.swing.BoundedRangeModel)
                src;
            if (brm.
                  getValueIsAdjusting(
                    )) {
                if (!inDrag) {
                    inDrag =
                      true;
                    startValue =
                      val;
                }
                else {
                    java.awt.geom.AffineTransform at;
                    if (isVertical) {
                        at =
                          java.awt.geom.AffineTransform.
                            getTranslateInstance(
                              0,
                              startValue -
                                val);
                    }
                    else {
                        at =
                          java.awt.geom.AffineTransform.
                            getTranslateInstance(
                              startValue -
                                val,
                              0);
                    }
                    canvas.
                      setPaintingTransform(
                        at);
                }
            }
            else {
                if (inDrag) {
                    inDrag =
                      false;
                    if (val ==
                          startValue) {
                        canvas.
                          setPaintingTransform(
                            new java.awt.geom.AffineTransform(
                              ));
                        return;
                    }
                }
                setScrollPosition(
                  );
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "80d2eeG/7rdu1x4ZAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8ref/WZeGvxfyf0xqGIjAAA=");
    }
    protected class ScrollListener extends java.awt.event.ComponentAdapter implements org.apache.batik.swing.gvt.JGVTComponentListener, org.apache.batik.swing.svg.GVTTreeBuilderListener, org.apache.batik.swing.gvt.GVTTreeRendererListener, org.apache.batik.bridge.UpdateManagerListener {
        protected boolean isReady = false;
        public void componentTransformChanged(java.awt.event.ComponentEvent evt) {
            if (isReady)
                resizeScrollBars(
                  );
        }
        public void componentResized(java.awt.event.ComponentEvent evt) {
            if (isReady)
                resizeScrollBars(
                  );
        }
        public void gvtBuildStarted(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
            isReady =
              false;
            updateScrollbarState(
              false,
              false);
        }
        public void gvtBuildCompleted(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
            isReady =
              true;
            viewBox =
              null;
        }
        public void gvtRenderingCompleted(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
            if (viewBox ==
                  null) {
                resizeScrollBars(
                  );
                return;
            }
            java.awt.geom.Rectangle2D newview =
              getViewBoxRect(
                );
            if (newview.
                  getX(
                    ) !=
                  viewBox.
                  getX(
                    ) ||
                  newview.
                  getY(
                    ) !=
                  viewBox.
                  getY(
                    ) ||
                  newview.
                  getWidth(
                    ) !=
                  viewBox.
                  getWidth(
                    ) ||
                  newview.
                  getHeight(
                    ) !=
                  viewBox.
                  getHeight(
                    )) {
                viewBox =
                  newview;
                resizeScrollBars(
                  );
            }
        }
        public void updateCompleted(org.apache.batik.bridge.UpdateManagerEvent e) {
            if (viewBox ==
                  null) {
                resizeScrollBars(
                  );
                return;
            }
            java.awt.geom.Rectangle2D newview =
              getViewBoxRect(
                );
            if (newview.
                  getX(
                    ) !=
                  viewBox.
                  getX(
                    ) ||
                  newview.
                  getY(
                    ) !=
                  viewBox.
                  getY(
                    ) ||
                  newview.
                  getWidth(
                    ) !=
                  viewBox.
                  getWidth(
                    ) ||
                  newview.
                  getHeight(
                    ) !=
                  viewBox.
                  getHeight(
                    )) {
                viewBox =
                  newview;
                resizeScrollBars(
                  );
            }
        }
        public void gvtBuildCancelled(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
            
        }
        public void gvtBuildFailed(org.apache.batik.swing.svg.GVTTreeBuilderEvent e) {
            
        }
        public void gvtRenderingPrepare(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
            
        }
        public void gvtRenderingStarted(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
            
        }
        public void gvtRenderingCancelled(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
            
        }
        public void gvtRenderingFailed(org.apache.batik.swing.gvt.GVTTreeRendererEvent e) {
            
        }
        public void managerStarted(org.apache.batik.bridge.UpdateManagerEvent e) {
            
        }
        public void managerSuspended(org.apache.batik.bridge.UpdateManagerEvent e) {
            
        }
        public void managerResumed(org.apache.batik.bridge.UpdateManagerEvent e) {
            
        }
        public void managerStopped(org.apache.batik.bridge.UpdateManagerEvent e) {
            
        }
        public void updateStarted(org.apache.batik.bridge.UpdateManagerEvent e) {
            
        }
        public void updateFailed(org.apache.batik.bridge.UpdateManagerEvent e) {
            
        }
        public ScrollListener() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "jB/DTOOwGNizQN/wsMWbAfqFI6BfuEVA");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("8XOAFodBDuon4wneOVLvGpiNmwHzi0cwv3iLYJLnwOwXzftPu20QhtfAfMND" +
           "TW8G5peOYH7pFsHkz4EpFA2TQPft68DrByd7M1B++Qjll28Ryh87B+XzRbNI" +
           "oHv3KK+baKXvBWQOHOPqA+QlCSjS3/OmTp/HEfTYNb9n2f8GQ/38y5fuevTl" +
           "6b8tD1xf+Z3E3Qx0l5G67unTjaeu7wgj3bBLS929P+sYlsitBHrk+hol0MXy" +
           "s1D8wNxTOyB/naUGdOXnaTo/ge45oUugO/YXp0nWCXQbICkuo/DYOE/daNmn" +
           "rclhokf5/l3nsdOuVJY3D73R4FxhOX04u1ihK39cdLyalu5/XvS8+urL9Ogn" +
           "Xm/++v5wuOrKu10h5S4GunN/Tr0UWqzIPX1Dacey7hg88537v3D3e46XDu/f" +
           "K3zi1qd0e+r6p69JL0zK89K73370H73v0y//cXkq8P8DqFKbzfU1AAA=");
    }
    protected void resizeScrollBars() { ignoreScrollChange =
                                          true;
                                        checkAndSetViewBoxRect(
                                          );
                                        if (viewBox ==
                                              null)
                                            return;
                                        java.awt.geom.AffineTransform vbt =
                                          canvas.
                                          getViewBoxTransform(
                                            );
                                        if (vbt ==
                                              null)
                                            vbt =
                                              new java.awt.geom.AffineTransform(
                                                );
                                        java.awt.Rectangle r2d =
                                          vbt.
                                          createTransformedShape(
                                            viewBox).
                                          getBounds(
                                            );
                                        int maxW =
                                          r2d.
                                            width;
                                        int maxH =
                                          r2d.
                                            height;
                                        int tx =
                                          0;
                                        int ty =
                                          0;
                                        if (r2d.
                                              x >
                                              0)
                                            maxW +=
                                              r2d.
                                                x;
                                        else
                                            tx -=
                                              r2d.
                                                x;
                                        if (r2d.
                                              y >
                                              0)
                                            maxH +=
                                              r2d.
                                                y;
                                        else
                                            ty -=
                                              r2d.
                                                y;
                                        java.awt.Dimension vpSize =
                                          updateScrollbarVisibility(
                                            tx,
                                            ty,
                                            maxW,
                                            maxH);
                                        vertical.
                                          setValues(
                                            ty,
                                            vpSize.
                                              height,
                                            0,
                                            maxH);
                                        horizontal.
                                          setValues(
                                            tx,
                                            vpSize.
                                              width,
                                            0,
                                            maxW);
                                        vertical.
                                          setBlockIncrement(
                                            (int)
                                              (0.9F *
                                                 vpSize.
                                                   height));
                                        horizontal.
                                          setBlockIncrement(
                                            (int)
                                              (0.9F *
                                                 vpSize.
                                                   width));
                                        vertical.
                                          setUnitIncrement(
                                            (int)
                                              (0.2F *
                                                 vpSize.
                                                   height));
                                        horizontal.
                                          setUnitIncrement(
                                            (int)
                                              (0.2F *
                                                 vpSize.
                                                   width));
                                        doLayout(
                                          );
                                        horizontalPanel.
                                          doLayout(
                                            );
                                        horizontal.
                                          doLayout(
                                            );
                                        vertical.
                                          doLayout(
                                            );
                                        ignoreScrollChange =
                                          false;
    }
    protected java.awt.Dimension updateScrollbarVisibility(int tx,
                                                           int ty,
                                                           int maxW,
                                                           int maxH) {
        java.awt.Dimension vpSize =
          canvas.
          getSize(
            );
        int maxVPW =
          vpSize.
            width;
        int minVPW =
          vpSize.
            width;
        int maxVPH =
          vpSize.
            height;
        int minVPH =
          vpSize.
            height;
        if (vertical.
              isVisible(
                )) {
            maxVPW +=
              vertical.
                getPreferredSize(
                  ).
                width;
        }
        else {
            minVPW -=
              vertical.
                getPreferredSize(
                  ).
                width;
        }
        if (horizontalPanel.
              isVisible(
                )) {
            maxVPH +=
              horizontal.
                getPreferredSize(
                  ).
                height;
        }
        else {
            minVPH -=
              horizontal.
                getPreferredSize(
                  ).
                height;
        }
        boolean hNeeded;
        boolean vNeeded;
        java.awt.Dimension ret =
          new java.awt.Dimension(
          );
        if (scrollbarsAlwaysVisible) {
            hNeeded =
              maxW >
                minVPW;
            vNeeded =
              maxH >
                minVPH;
            ret.
              width =
              minVPW;
            ret.
              height =
              minVPH;
        }
        else {
            hNeeded =
              maxW >
                maxVPW ||
                tx !=
                0;
            vNeeded =
              maxH >
                maxVPH ||
                ty !=
                0;
            if (vNeeded &&
                  !hNeeded)
                hNeeded =
                  maxW >
                    minVPW;
            else
                if (hNeeded &&
                      !vNeeded)
                    vNeeded =
                      maxH >
                        minVPH;
            ret.
              width =
              hNeeded
                ? minVPW
                : maxVPW;
            ret.
              height =
              vNeeded
                ? minVPH
                : maxVPH;
        }
        updateScrollbarState(
          hNeeded,
          vNeeded);
        return ret;
    }
    protected void updateScrollbarState(boolean hNeeded,
                                        boolean vNeeded) {
        horizontal.
          setEnabled(
            hNeeded);
        vertical.
          setEnabled(
            vNeeded);
        if (scrollbarsAlwaysVisible) {
            horizontalPanel.
              setVisible(
                true);
            vertical.
              setVisible(
                true);
            cornerBox.
              setVisible(
                true);
        }
        else {
            horizontalPanel.
              setVisible(
                hNeeded);
            vertical.
              setVisible(
                vNeeded);
            cornerBox.
              setVisible(
                hNeeded &&
                  vNeeded);
        }
    }
    protected void checkAndSetViewBoxRect() {
        if (viewBox !=
              null)
            return;
        viewBox =
          getViewBoxRect(
            );
    }
    protected java.awt.geom.Rectangle2D getViewBoxRect() {
        org.w3c.dom.svg.SVGDocument doc =
          canvas.
          getSVGDocument(
            );
        if (doc ==
              null)
            return null;
        org.w3c.dom.svg.SVGSVGElement el =
          doc.
          getRootElement(
            );
        if (el ==
              null)
            return null;
        java.lang.String viewBoxStr =
          el.
          getAttributeNS(
            null,
            org.apache.batik.util.SVGConstants.
              SVG_VIEW_BOX_ATTRIBUTE);
        if (viewBoxStr.
              length(
                ) !=
              0) {
            float[] rect =
              org.apache.batik.bridge.ViewBox.
              parseViewBoxAttribute(
                el,
                viewBoxStr,
                null);
            return new java.awt.geom.Rectangle2D.Float(
              rect[0],
              rect[1],
              rect[2],
              rect[3]);
        }
        org.apache.batik.gvt.GraphicsNode gn =
          canvas.
          getGraphicsNode(
            );
        if (gn ==
              null)
            return null;
        java.awt.geom.Rectangle2D bounds =
          gn.
          getBounds(
            );
        if (bounds ==
              null)
            return null;
        return (java.awt.geom.Rectangle2D)
                 bounds.
                 clone(
                   );
    }
    public void scaleChange(float scale) {
        
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4tOP/gfUvGKDtSwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "82zproMj22sutR3v9OLxg9oLvhJGvj0/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("dlz75AFnH8k59hMgvbrH2VdPvns+XLvrv3h+727tT7lr8PVT6r6RZ/8yLD2x" +
       "VkLm+udOxdvrQ+H5jbd6PXp0iqLg149fi8FAem0P7Wt3Bu2ZwwZR0eDfnQL5" +
       "W3n2bwDk4IaQr/uqOHY0+ZAN37wNNuQXg0owSF/aY8OXbpUN3Ztjw++fwob/" +
       "nGffDkuPSb4ihsrBWfKxY6BDvN+5DbxP5oX5Acsbe3jfuDN4j8L5wSl1/z3P" +
       "vheW3n4U6smzO/Qmz+6u7Vzw5w9vgz/vzQv/Akhf2ePPV+48f/70xnVniqn+" +
       "d1i6tOPPyBHlm+VOEK+vAAaBkDCyFDvMuyr+tdz5k9vgzqN54dMgfXWPO1+9" +
       "M0bjKAceOKUuv0x15jxwUcBE4ofXWg7Anbn3di3iYyB9aw/ct+48uMdPqXsi" +
       "zx4JS/f4CjCHeYvfPQT29tsAVhyqvgek7+4B++4dl+kzl0+pe0+ePQ0iogMr" +
       "Pz1yWfIIyGduF+TzgN6v7frufu8sSPiUumqelcPSRbB6WnZow4MTGN9/Gxgf" +
       "zwuB8T7zR3sY/+jOYLy7aHD39VztXVpxG+fMBw+zAu4HTmFFK8+wsPTOyJUP" +
       "bDxw7IVH10wtTPdN2eHVn44GbFawHyEWnGrcrjT0S6WzlV3f3e/tc+ps0eBs" +
       "/m9xi6Dw7WfGpzBjkmckcHgnmJF/R6KckI3+7SIuA9q6e4i7d17++VPqPpRn" +
       "87D0KHBLktGyZUYJud2FkfxmyAmkb3kt7hSkT+SFwE+fnewhndx5pMopdfkl" +
       "hTMvhaUH19cg/BuHCMXb9UQ5QmMPoXGrCE+Nza+n5/eopiOGBT7vFOxxnoGN" +
       "1/2BJJrK4ZWaI0tr3QrwBLDxeFSXXwd//JqPsnYfEkm/8vpD9z72Ovut4iOC" +
       "g4997huV7lUj0zx6J/fI8znXV1StYMh9uxu6boHlZSCs1w+lADuK35zcMx/b" +
       "tf44MO0nW4N2xe/Rdn8lLF04bBeWzu0ejjb5FDCroEn++OliPafJbk0ePyoO" +
       "RbB26a2YeWSj/+5j2/Pi87f9rXS0+wDuqvTl1wfUT/+w/qXd1wySKWZZPsq9" +
       "o9L53YcVxaD5dvzZG462P9Y58oUfPfir9z2//+rgwR3Bh6J5hLanr//pQNdy" +
       "w+Kyf/bVx77ygV98/feKO0f/DwzkuVeXOAAA");
}
