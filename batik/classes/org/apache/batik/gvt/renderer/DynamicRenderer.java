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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Tf8BarvAg60hAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+VO6FLqyr5wl+V9gdEBSVv93dByLb7/7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Ga79Uc9jxRaXzmcTJxZ75OtZ7EwC8pZzOLM7onr8is9GR3D2qRcH3Hd/tf3T" +
       "+5NFmqdud4nS/Qx03/6Q00ma8PQdRzse6wr97Nce+oUH3nqMWA/tGT518zO8" +
       "vfn2x3hIkL3vDt5sf/WNn/6On3nx87u99X8ATCkjSTssAAA=");
}
