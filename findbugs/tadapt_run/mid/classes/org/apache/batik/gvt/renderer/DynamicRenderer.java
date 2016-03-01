package org.apache.batik.gvt.renderer;
public class DynamicRenderer extends org.apache.batik.gvt.renderer.StaticRenderer {
    static final int COPY_OVERHEAD = 1000;
    static final int COPY_LINE_OVERHEAD = 10;
    public DynamicRenderer() { super(); }
    public DynamicRenderer(java.awt.RenderingHints rh, java.awt.geom.AffineTransform at) {
        super(
          rh,
          at);
    }
    org.apache.batik.ext.awt.geom.RectListManager damagedAreas;
    protected org.apache.batik.ext.awt.image.rendered.CachableRed setupCache(org.apache.batik.ext.awt.image.rendered.CachableRed img) {
        return img;
    }
    public void flush(java.awt.Rectangle r) { return; }
    public void flush(java.util.Collection areas) { return;
    }
    protected void updateWorkingBuffers() { if (rootFilter ==
                                                  null) {
                                                rootFilter =
                                                  rootGN.
                                                    getGraphicsNodeRable(
                                                      true);
                                                rootCR =
                                                  null;
                                            }
                                            rootCR = renderGNR(
                                                       );
                                            if (rootCR ==
                                                  null) {
                                                workingRaster =
                                                  null;
                                                workingOffScreen =
                                                  null;
                                                workingBaseRaster =
                                                  null;
                                                currentOffScreen =
                                                  null;
                                                currentBaseRaster =
                                                  null;
                                                currentRaster =
                                                  null;
                                                return;
                                            }
                                            java.awt.image.SampleModel sm =
                                              rootCR.
                                              getSampleModel(
                                                );
                                            int w = offScreenWidth;
                                            int h = offScreenHeight;
                                            if (workingBaseRaster ==
                                                  null ||
                                                  workingBaseRaster.
                                                  getWidth(
                                                    ) <
                                                  w ||
                                                  workingBaseRaster.
                                                  getHeight(
                                                    ) <
                                                  h) { sm =
                                                         sm.
                                                           createCompatibleSampleModel(
                                                             w,
                                                             h);
                                                       workingBaseRaster =
                                                         java.awt.image.Raster.
                                                           createWritableRaster(
                                                             sm,
                                                             new java.awt.Point(
                                                               0,
                                                               0));
                                                       workingRaster =
                                                         workingBaseRaster.
                                                           createWritableChild(
                                                             0,
                                                             0,
                                                             w,
                                                             h,
                                                             0,
                                                             0,
                                                             null);
                                                       workingOffScreen =
                                                         new java.awt.image.BufferedImage(
                                                           rootCR.
                                                             getColorModel(
                                                               ),
                                                           workingRaster,
                                                           rootCR.
                                                             getColorModel(
                                                               ).
                                                             isAlphaPremultiplied(
                                                               ),
                                                           null);
                                            }
                                            if (!isDoubleBuffered) {
                                                currentOffScreen =
                                                  workingOffScreen;
                                                currentBaseRaster =
                                                  workingBaseRaster;
                                                currentRaster =
                                                  workingRaster;
                                            }
    }
    public void repaint(org.apache.batik.ext.awt.geom.RectListManager devRLM) {
        if (devRLM ==
              null)
            return;
        org.apache.batik.ext.awt.image.rendered.CachableRed cr;
        java.awt.image.WritableRaster syncRaster;
        java.awt.image.WritableRaster copyRaster;
        updateWorkingBuffers(
          );
        if (rootCR ==
              null ||
              workingBaseRaster ==
              null) {
            return;
        }
        cr =
          rootCR;
        syncRaster =
          workingBaseRaster;
        copyRaster =
          workingRaster;
        java.awt.Rectangle srcR =
          rootCR.
          getBounds(
            );
        java.awt.Rectangle dstR =
          workingRaster.
          getBounds(
            );
        if (dstR.
              x <
              srcR.
                x ||
              dstR.
                y <
              srcR.
                y ||
              dstR.
                x +
              dstR.
                width >
              srcR.
                x +
              srcR.
                width ||
              dstR.
                y +
              dstR.
                height >
              srcR.
                y +
              srcR.
                height)
            cr =
              new org.apache.batik.ext.awt.image.rendered.PadRed(
                cr,
                dstR,
                org.apache.batik.ext.awt.image.PadMode.
                  ZERO_PAD,
                null);
        boolean repaintAll =
          false;
        java.awt.Rectangle dr =
          copyRaster.
          getBounds(
            );
        synchronized (syncRaster)  {
            if (repaintAll) {
                cr.
                  copyData(
                    copyRaster);
            }
            else {
                java.awt.Graphics2D g2d =
                  null;
                if (false) {
                    java.awt.image.BufferedImage tmpBI =
                      new java.awt.image.BufferedImage(
                      workingOffScreen.
                        getColorModel(
                          ),
                      copyRaster.
                        createWritableTranslatedChild(
                          0,
                          0),
                      workingOffScreen.
                        isAlphaPremultiplied(
                          ),
                      null);
                    g2d =
                      org.apache.batik.ext.awt.image.GraphicsUtil.
                        createGraphics(
                          tmpBI);
                    g2d.
                      translate(
                        -copyRaster.
                          getMinX(
                            ),
                        -copyRaster.
                          getMinY(
                            ));
                }
                if (isDoubleBuffered &&
                      currentRaster !=
                      null &&
                      damagedAreas !=
                      null) {
                    damagedAreas.
                      subtract(
                        devRLM,
                        COPY_OVERHEAD,
                        COPY_LINE_OVERHEAD);
                    damagedAreas.
                      mergeRects(
                        COPY_OVERHEAD,
                        COPY_LINE_OVERHEAD);
                    java.awt.Color fillColor =
                      new java.awt.Color(
                      0,
                      0,
                      255,
                      50);
                    java.awt.Color borderColor =
                      new java.awt.Color(
                      0,
                      0,
                      0,
                      50);
                    java.util.Iterator iter =
                      damagedAreas.
                      iterator(
                        );
                    while (iter.
                             hasNext(
                               )) {
                        java.awt.Rectangle r =
                          (java.awt.Rectangle)
                            iter.
                            next(
                              );
                        if (!dr.
                              intersects(
                                r))
                            continue;
                        r =
                          dr.
                            intersection(
                              r);
                        java.awt.image.Raster src =
                          currentRaster.
                          createWritableChild(
                            r.
                              x,
                            r.
                              y,
                            r.
                              width,
                            r.
                              height,
                            r.
                              x,
                            r.
                              y,
                            null);
                        org.apache.batik.ext.awt.image.GraphicsUtil.
                          copyData(
                            src,
                            copyRaster);
                        if (g2d !=
                              null) {
                            g2d.
                              setPaint(
                                fillColor);
                            g2d.
                              fill(
                                r);
                            g2d.
                              setPaint(
                                borderColor);
                            g2d.
                              draw(
                                r);
                        }
                    }
                }
                java.awt.Color fillColor =
                  new java.awt.Color(
                  255,
                  0,
                  0,
                  50);
                java.awt.Color borderColor =
                  new java.awt.Color(
                  0,
                  0,
                  0,
                  50);
                java.util.Iterator iter =
                  devRLM.
                  iterator(
                    );
                while (iter.
                         hasNext(
                           )) {
                    java.awt.Rectangle r =
                      (java.awt.Rectangle)
                        iter.
                        next(
                          );
                    if (!dr.
                          intersects(
                            r))
                        continue;
                    r =
                      dr.
                        intersection(
                          r);
                    java.awt.image.WritableRaster dst =
                      copyRaster.
                      createWritableChild(
                        r.
                          x,
                        r.
                          y,
                        r.
                          width,
                        r.
                          height,
                        r.
                          x,
                        r.
                          y,
                        null);
                    cr.
                      copyData(
                        dst);
                    if (g2d !=
                          null) {
                        g2d.
                          setPaint(
                            fillColor);
                        g2d.
                          fill(
                            r);
                        g2d.
                          setPaint(
                            borderColor);
                        g2d.
                          draw(
                            r);
                    }
                }
            }
        }
        if (org.apache.batik.util.HaltingThread.
              hasBeenHalted(
                ))
            return;
        java.awt.image.BufferedImage tmpBI =
          workingOffScreen;
        workingBaseRaster =
          currentBaseRaster;
        workingRaster =
          currentRaster;
        workingOffScreen =
          currentOffScreen;
        currentRaster =
          copyRaster;
        currentBaseRaster =
          syncRaster;
        currentOffScreen =
          tmpBI;
        damagedAreas =
          devRLM;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6NC+Sh5B/gNDNM8J6iAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Vuz20vlo4sRij3wri50JQN5yDmfKq6jH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("r/hEOIKzz704GH7/N+o/ub8lpDlKXgZK97PQffsLSydhwtN3HO14rCu9Z7/5" +
       "0M898NZjxHpoz/Cpm5/h7c23v5JDuUFcXqLJf/mNv/B9P/Xil8pz8v8PGO+q" +
       "ZCMsAAA=");
}
