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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "22aa/wP2kKnxHRQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "98J+/qpjVzb40lP/fP/47fq7XkFh9KFTQp5m+bv957/SfpP863vQ2aMiwk0v" +
           "YU4uun6ydHDZV8PId8YnCggPHJn1SmYuEny/eGDWL966OHnL4zmT+8PWC05V" +
           "v84cGPCgjFC6TXE7WC/2R3z7ZC2bWINuzjV4iZpanDXZyxHl2GLAMytmWGqo" +
           "bt9Bccc8jwc33TV4PO1c0n25S+6JWhYw/ctU3w/VfeP/qpYPvOu+m94cbt92" +
           "yZ957srF1z83+au8Wn30RuoSDV3UIss6Xho61r/g+apm5Na5tC0UefnP+0Lo" +
           "3ltLFELn899c8Ke21O8PoaunqQFd/nuc7pdC6PKODsTPtnOc5FdC6Cwgybq/" +
           "6h0aB30lvtBURC8EGfSZk+F9dIL3vNwJHkOEx06Ecv5q9zDsou3L3RvyZ5/r" +
           "Me9+sfrJbbVdtsTNJuNykYbu2Bb+j0L3kdtyO+R1ofP4D+/63KU3HmLMXVuB" +
           "dwF1TLaHbl3OJmwvzAvQmz98/e+/9bef+2ZeBPsfiCBCvnMfAAA=");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "CD95w+CJepGX7f8CnXGhn48YAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "plnn/tVRzrym4d4N8c7b/geHfUduYykAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL17e6zk1nkf70q7eljSrtbRI6olWfY6tcT4cmbIGc5Udqrh" +
           "vDgPznBIDueRx5pDHg7f5PA1HKaKYwOOjaRwjURyHCBR/4gTx45s+dGgKQIH" +
           "CoLEDmy0SOE+0qKxW7RI2sRAhKJpWjd1Dzn37n3s7pUM7fYC98wZ8vvO+X7f" +
           "+b7vfOcxL38HOR/4COq51nZlueE+SMJ9wyrvh1sPBPu9QZmV/AAoDUsKAgE+" +
           "uyq/4wsX//q7H9cunUMuLJC3So7jhlKou07AgcC1YqAMkItHT1sWsIMQuTQw" +
           "pFjColC3sIEehM8OkLccYw2RK4NDETAoAgZFwHIRsPoRFWS6HziR3cg4JCcM" +
           "1shPIXsD5IInZ+KFyFMnG/EkX7IPmmFzBLCFu7PvIgSVMyc+8vZr2HeYrwP8" +
           "Ioq98Is/celLdyAXF8hF3eEzcWQoRAg7WSD32cBeAj+oKwpQFsiDDgAKD3xd" +
           "svQ0l3uBXA70lSOFkQ+uKSl7GHnAz/s80tx9cobNj+TQ9a/BU3VgKYffzquW" +
           "tIJYHz7CukPYzp5DgPfqUDBflWRwyHKnqTtKiDx5muMaxit9SABZ77JBqLnX" +
           "urrTkeAD5PJu7CzJWWF86OvOCpKedyPYS4g8dtNGM117kmxKK3A1RB49Tcfu" +
           "XkGqe3JFZCwh8tBpsrwlOEqPnRqlY+PzneF7P/aTDu2cy2VWgGxl8t8NmZ44" +
           "xcQBFfjAkcGO8b5nBp+QHv7KR88hCCR+6BTxjuaf/oPXnvvhJ1792o7m79yA" +
           "ZrQ0gBxelT+1fOCP39Z4unZHJsbdnhvo2eCfQJ6bP3vw5tnEg5738LUWs5f7" +
           "hy9f5f5w/tOfBX9xDrm3i1yQXSuyoR09KLu2p1vA7wAH+FIIlC5yD3CURv6+" +
           "i9wF6wPdAbunI1UNQNhF7rTyRxfc/DtUkQqbyFR0F6zrjuoe1j0p1PJ64iEI" +
           "8gD8R+oIsqch+d+empUhomKaawNMkiVHd1yM9d0MfzagjiJhIQhgXYFvPRdb" +
           "Qvs331PcJ7HAjXxokJjrrzAJWoUGdi+xYAPtCevxYoeXfdeyYCtgP7M37/9b" +
           "T0mG+dJmbw8Ox9tOBwML+hHtWgrwr8ovRFTrtc9f/fq5a85xoK0QIWB3+7vu" +
           "9vPu9vPu9k92d2VXzQJgNoDI3l7e6Q9kUuzGH46eCeMAJLjvaf7He+//6Dvu" +
           "gIbnbe7MBgCSYjcP1I2jyNHN46MMzRd59ZObD4ofKJxDzp2MuJnk8NG9GTub" +
           "xclr8fDKaU+7UbsXP/Lnf/3KJ553j3zuRAg/CAXXc2au/I7TOvZdGSgwOB41" +
           "/8zbpd+6+pXnr5xD7oTxAcbEUII2DMPNE6f7OOHSzx6GxwzLeQhYdX1bsrJX" +
           "hzHt3lDz3c3Rk3zwH8jrD0IdZ3rOij39wOjzz+ztW72s/IGdsWSDdgpFHn7f" +
           "x3u/8m//+X/Fc3UfRuqLx+Y+HoTPHosOWWMX8zjw4JENCD4AkO4/fJL9hRe/" +
           "85EfzQ0AUrzzRh1eycoGjApwCKGaP/y19Z98608/9c1zR0YTwukxWlq6nOxA" +
           "fg/+7cH//5v9Z+CyBzvPvtw4CC9vvxZfvKznHzqSDUYaC/pgZkFXJo7tKrqq" +
           "S0sLZBb7fy6+q/hbf/mxSzubsOCTQ5P64ddv4Oj5D1LIT3/9J/7nE3kze3I2" +
           "0x3p74hsFz7fetRy3felbSZH8sF/+fgvfVX6FRiIYfAL9BTk8QzJ9YHkA1jI" +
           "dYHmJXbqXSkrngyOO8JJXzuWkVyVP/7Nv7pf/KvffS2X9mRKc3zcGcl7dmdq" +
           "WfH2BDb/yGmvp6VAg3TEq8Mfu2S9+l3Y4gK2KMNgFox8GICSE1ZyQH3+rn/3" +
           "e7//8Pv/+A7kXBu513IlpS3lDofcAy0dBBqMXYn395/bmfPmblhcyqEi14Hf" +
           "Gcij+bc7oYBP3zzWtLOM5MhdH/3fI2v5of/0N9cpIY8yN5iIT/EvsJd/+bHG" +
           "j/xFzn/k7hn3E8n1QRlmb0e8pc/a/+PcOy78wTnkrgVyST5IDUXJijInWsB0" +
           "KDjMF2H6eOL9ydRmN48/ey2cve10qDnW7elAczQZwHpGndXvPRVbLmdafga6" +
           "pHEQW4zTsWUPySvP5SxP5eWVrPi7h658j+e7IZQSKHnbT4fIXTrMHiVle/Z4" +
           "sb5uw4ATHyQ+2POXv2X+8p9/bpfUnB6cU8Tgoy/87Pf2P/bCuWOp5Duvy+aO" +
           "8+zSyVzC+3MxM3N/6qxeco72n73y/O/8xvMf2Ul1+WRi1IJ5/+f+9d9+Y/+T" +
           "3/6jG8y/dy1d1wKSs4vOWYlnRX1n05Wb2v+zO/n2oG7Pl/bJ/UL2nb2x/u/I" +
           "qu+G8TTIFwCQQ9UdyTociUcMS75yGEFFuCCADnDFsMi8mYfgEij33czU9ndZ" +
           "9ClZn37DskJtPnDU2MCFCfnP/eePf+MfvfNbUDM95HycGTdU4bEeh1G2RvmZ" +
           "l198/C0vfPvn8ukBGhT7idal57JWf/QsxFkhZMXkEOpjGVQ+T7QGUhAyeRQH" +
           "yjW07WN4eiGcC9w3gTa89DWaCLr1w79BUWqUNnLC2WBE1oZYPUnGITHXyv0x" +
           "TrW6QgWME4bvmTirl1zbGun4CA8rciw7gLQXeGpUlp7e7q7Gmqi3ug2r1ZPW" +
           "43afaVnEmi+I3VmhQegTaEu2O27BQFHv9MTG2tYmA0zFl7hiY7HilQTBn5nV" +
           "mYdjDmajqKSSGIaX9Tna06YdwXKL44nZbQmSPeFZflWTayubHHNdOegw82nU" +
           "DFw8FpwStmBia50OC5s1VTBqQYcq6ESPGm0n6x6xoRizxjcbc7drTEqThVfX" +
           "k4rSscZqa6Gb/dXQ1Gyu4AncoqXPpj4/d5VoNatRmtfSDMGb6VKBJwd1nhnM" +
           "nU1pIlSWlY4Xa9h8bvPSuuRpBtOMaZdhi00WLh/YFsNpnjEioJgLzza17ZAf" +
           "L/wUNUy1VRITYmFaE9HVTLG0pZQl19l2Z4uEHqNxoplVLC5NCVNhNjOxPrFm" +
           "nS6nV4sibbd6dt/cLG1SXM+9eaKWB7o9MIWh7HCWp9fsJmfT4349WRO4WNmA" +
           "1F/3eiNFWslNn6mJU1cXXJ0LcPio2428xgZnZ+mI6HekqaKXGYlS7JboD0gZ" +
           "mgiduhs1ivrLxBQGPNOqS73+hPW2bKNHrRhm1WgVLF6uBMs11+3alKkL9VUM" +
           "OFzsmX0xkcjpsjm1ui1xJY2Dhk1NUXso+SnDlaJ5Y0LZZWJqS55D8GJ50nYw" +
           "kees+VjfhIY2F+a8AqhqvWi6G0YoeONRsuhFE7LHzyhia8y6bpQs+WGhPhyt" +
           "251ZU3IkVzan9U5FWDSp9mLSlXSVo6pbjSr4Yl2jaGh/aXlkTsNhi5ahYfNj" +
           "U3SAauB2F9XEDWHVW4WFDQZhIpBUP0hLfrm9Vo0UhDFcsiyWBb6nd+Yy0e8z" +
           "AYk1mw2JTOm1N7HXk9qK9qJOobekl9pi7tQIubeSiZTt4UPWwMh0bYk8ClSV" +
           "WQZMRak7VTyhRc5coQMNsPhAToPprFjpFCrGVGyxjUSuUamjLAxsarLSCALg" +
           "TBYMmjqLbxYjLI5xR2mpnmYPuZI58ThLYTy9z9iTSdEzzbSoiLwWBZTruvFk" +
           "0phxm0UNN/k1YZhmfwhqkaDPh1vf60ZyEsMZuKpW6m6Dr4xda01YHm9KVs2v" +
           "a7FdTOxhq91l49K42JXa2sapNfjpZsFPJLrI8cPGur/iu65EKm0x6VYHW2NK" +
           "d5yGsuoDqeMWm9ioJodGspUUblxI3daiLYhapdvgmMlmyNU6htjpeqjeieNy" +
           "UZX60dboES7XYYYojg2tboeZVNXmXFyNwKKSTBoddckBixtO6GTMekMQsDOx" +
           "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" +
           "zPKtgPnFA5hfvE0wW2fA7GTFc8fN1vW8");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("62C+7qWkNwLzSwcwv3SbYI7PgMlnxSBE7t/lgTd2TuZWoPzyAcov3yaUP34G" +
           "yqtZMQuR+3Yobxho598PyAQaxskL4DkJTNLf9YZujwc+8uh1v1XZ/b5C/vxL" +
           "F+9+5KXJv8kvTF/7DcQ9A+RuNbKs47cTj9UveD5Q9VxT9+zuKno5ci1EHr6x" +
           "RCFyPv/MBN9b7ahNGL9OU0O6/PM4nRMi9x7RhciFXeU4yTpE7oAkWdX3DpXz" +
           "5M22feqK5IXAT3ZrnUePm1Ke3lx+vcG5xnL8cnW2Q5f/cOhwNy3a/XToqvzK" +
           "S73hT75W+bXd5W7ZktI0a+XuAXLX7p553mi2I/fUTVs7bOsC/fR3H/jCPe86" +
           "3Dp8YCfwkVkfk+3JG9+ebtlemN93Tn/7kX/y3k+/9Kf5rb7/B1FA8C3RNQAA");
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "F/r/AWZ8W248KwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "d+2D4/fu1v6MuwLfOKPum3n2L6PSE7oa");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Ta793qg4fT4Snt98q+PN41MUBb9x8loLAdJr+2hfuz1o944axEWDf3cG5G/n" +
       "2b8BkMPrQr7mUW/imcoRG751C2zIL/aUEJC+vM+GL98sG6gbY8MfnMGG/5xn" +
       "34lKj8mBKkbq4bvgE69xjvB+9xbwPpkX5i9I3tjH+8btwXsczg/PqPvvefb9" +
       "qPT241BPv3vDbvDd29WdC/780S3w57154V8C6av7/Pnq7efPn12/bq+Y6n9H" +
       "pYd3/Ol7onKj3AkT/TJgUMuTY0d1o7yrGlzNnT+9Be48mhc+DdLX9rnztdtj" +
       "NI5z4P4z6vLLUHt3AxcFTGTz6FrKIbi9e27VIj4G0rf3wX379oN7/Iy6J/Ls" +
       "kah0V6ACc5i3+L0jYG+/BWDFS9H3gPS9fWDfu+0yvXfpjLr35NnTICI6tPKj" +
       "Y5cdj4F85lZBPg/o/fqu7+779oJEzqgr5xkUlS6C1TOzIxsensL4/lvA+Hhe" +
       "CIz33h/vY/zj24PxzqLBnddytXeYxW2avZ86ygq4HzyDFXm0vEdEpXfGvnJo" +
       "44FjLzy6aZvR9sCUHV3daZnAZoUHEWLBqdqtSgNTKp1Dd31337fOqXNFg3P5" +
       "z+IWQOHb9wZnMGOYZx3g8E4xI/+PiHpKNphbRQwB2qh9xNTtl//lGXUfzrNp" +
       "VHoUuCXZarjKRI1muwsf+c2OU0jf8lrbGUifyAuBnz433Ec6vP1I1TPq8ksG" +
       "ey9FpQf0qxD+whFC8VY9UY7Q2kdo3SzCM2Pza+n5XZrtiVGBb30G9iTPwMbr" +
       "vlAWbfXoSsyxpXVuBvgGsPFkVJdf5378qj9c7f4kJP/q6w/e89jr/LeLPwEc" +
       "/pHn3n7pHi227eN3ao89n/cDVTMLhty7u2HrF1heBsJ67VAKsKP4zsnd+/iu" +
       "9SeAaT/dGrQrvo+3+2tR6cJRu6h0fvdwvMmngVkFTfLHzxTrOdrs1uTx4+JQ" +
       "BGsPvxUzj230331ie178te1gKx3v/tx2Rf7K6132Z35U/fLu3wiyLWZZPso9" +
       "/dLduz9GFIPm2/FnrzvawVjnOy/8+IFfu/f5g6ODB3YEH4nmMdqevvbVf8rx" +
       "o+Kyfva1x776wV96/feLO0P/D/xJFi5zOAAA");
}
