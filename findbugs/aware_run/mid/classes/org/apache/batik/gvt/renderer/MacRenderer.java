package org.apache.batik.gvt.renderer;
public class MacRenderer implements org.apache.batik.gvt.renderer.ImageRenderer, panda.runtime.PANDA_Attributable {
    public int PANDA_attribute() { return org.apache.batik.apps.rasterizer.PandaMode.
                                            HIGH_MODE; }
    static final int COPY_OVERHEAD = 1000;
    static final int COPY_LINE_OVERHEAD = 10;
    static final java.awt.geom.AffineTransform IDENTITY = new java.awt.geom.AffineTransform(
      );
    protected java.awt.RenderingHints renderingHints;
    protected java.awt.geom.AffineTransform usr2dev;
    protected org.apache.batik.gvt.GraphicsNode rootGN;
    protected int offScreenWidth;
    protected int offScreenHeight;
    protected boolean isDoubleBuffered;
    protected java.awt.image.BufferedImage currImg;
    protected java.awt.image.BufferedImage workImg;
    protected org.apache.batik.ext.awt.geom.RectListManager
      damagedAreas;
    public static int IMAGE_TYPE = java.awt.image.BufferedImage.
                                     TYPE_INT_ARGB_PRE;
    public static java.awt.Color TRANSPARENT_WHITE = new java.awt.Color(
      255,
      255,
      255,
      0);
    protected static java.awt.RenderingHints defaultRenderingHints;
    static { defaultRenderingHints = new java.awt.RenderingHints(
                                       null);
             defaultRenderingHints.put(java.awt.RenderingHints.
                                         KEY_ANTIALIASING,
                                       java.awt.RenderingHints.
                                         VALUE_ANTIALIAS_ON);
             defaultRenderingHints.put(java.awt.RenderingHints.
                                         KEY_INTERPOLATION,
                                       java.awt.RenderingHints.
                                         VALUE_INTERPOLATION_BILINEAR);
    }
    public MacRenderer() { super();
                           renderingHints = new java.awt.RenderingHints(
                                              null);
                           renderingHints.add(defaultRenderingHints);
                           usr2dev = new java.awt.geom.AffineTransform(
                                       ); }
    public MacRenderer(java.awt.RenderingHints rh, java.awt.geom.AffineTransform at) {
        super(
          );
        renderingHints =
          new java.awt.RenderingHints(
            null);
        renderingHints.
          add(
            rh);
        if (at ==
              null)
            at =
              new java.awt.geom.AffineTransform(
                );
        else
            at =
              new java.awt.geom.AffineTransform(
                at);
    }
    public void dispose() { rootGN = null;
                            currImg = null;
                            workImg = null;
                            renderingHints = null;
                            usr2dev = null;
                            if (damagedAreas != null) {
                                damagedAreas.
                                  clear(
                                    );
                            }
                            damagedAreas = null; }
    public void setTree(org.apache.batik.gvt.GraphicsNode treeRoot) {
        rootGN =
          treeRoot;
    }
    public org.apache.batik.gvt.GraphicsNode getTree() {
        return rootGN;
    }
    public void setTransform(java.awt.geom.AffineTransform usr2dev) {
        if (usr2dev ==
              null)
            this.
              usr2dev =
              new java.awt.geom.AffineTransform(
                );
        else
            this.
              usr2dev =
              new java.awt.geom.AffineTransform(
                usr2dev);
        if (workImg ==
              null)
            return;
        synchronized (workImg)  {
            java.awt.Graphics2D g2d =
              workImg.
              createGraphics(
                );
            g2d.
              setComposite(
                java.awt.AlphaComposite.
                  Clear);
            g2d.
              fillRect(
                0,
                0,
                workImg.
                  getWidth(
                    ),
                workImg.
                  getHeight(
                    ));
            g2d.
              dispose(
                );
        }
        damagedAreas =
          null;
    }
    public java.awt.geom.AffineTransform getTransform() {
        return usr2dev;
    }
    public void setRenderingHints(java.awt.RenderingHints rh) {
        this.
          renderingHints =
          new java.awt.RenderingHints(
            null);
        this.
          renderingHints.
          add(
            rh);
        damagedAreas =
          null;
    }
    public java.awt.RenderingHints getRenderingHints() {
        return renderingHints;
    }
    public boolean isDoubleBuffered() { return isDoubleBuffered;
    }
    public void setDoubleBuffered(boolean isDoubleBuffered) {
        if (this.
              isDoubleBuffered ==
              isDoubleBuffered)
            return;
        this.
          isDoubleBuffered =
          isDoubleBuffered;
        if (isDoubleBuffered) {
            workImg =
              null;
        }
        else {
            workImg =
              currImg;
            damagedAreas =
              null;
        }
    }
    public void updateOffScreen(int width, int height) {
        offScreenWidth =
          width;
        offScreenHeight =
          height;
    }
    public java.awt.image.BufferedImage getOffScreen() {
        if (rootGN ==
              null)
            return null;
        return currImg;
    }
    public void clearOffScreen() { if (isDoubleBuffered)
                                       return;
                                   updateWorkingBuffers(
                                     );
                                   if (workImg ==
                                         null) return;
                                   synchronized (workImg)  {
                                       java.awt.Graphics2D g2d =
                                         workImg.
                                         createGraphics(
                                           );
                                       g2d.
                                         setComposite(
                                           java.awt.AlphaComposite.
                                             Clear);
                                       g2d.
                                         fillRect(
                                           0,
                                           0,
                                           workImg.
                                             getWidth(
                                               ),
                                           workImg.
                                             getHeight(
                                               ));
                                       g2d.
                                         dispose(
                                           );
                                   }
                                   damagedAreas =
                                     null; }
    public void flush() {  }
    public void flush(java.awt.Rectangle r) {  }
    public void flush(java.util.Collection areas) {
        
    }
    protected void updateWorkingBuffers() { if (rootGN ==
                                                  null) {
                                                currImg =
                                                  null;
                                                workImg =
                                                  null;
                                                return;
                                            }
                                            int w =
                                              offScreenWidth;
                                            int h =
                                              offScreenHeight;
                                            if (workImg ==
                                                  null ||
                                                  workImg.
                                                  getWidth(
                                                    ) <
                                                  w ||
                                                  workImg.
                                                  getHeight(
                                                    ) <
                                                  h) {
                                                workImg =
                                                  new java.awt.image.BufferedImage(
                                                    w,
                                                    h,
                                                    IMAGE_TYPE);
                                            }
                                            if (!isDoubleBuffered) {
                                                currImg =
                                                  workImg;
                                            }
    }
    public void repaint(java.awt.Shape area) {
        if (area ==
              null)
            return;
        org.apache.batik.ext.awt.geom.RectListManager rlm =
          new org.apache.batik.ext.awt.geom.RectListManager(
          );
        rlm.
          add(
            usr2dev.
              createTransformedShape(
                area).
              getBounds(
                ));
        repaint(
          rlm);
    }
    public void repaint(org.apache.batik.ext.awt.geom.RectListManager devRLM) {
        if (devRLM ==
              null)
            return;
        updateWorkingBuffers(
          );
        if (rootGN ==
              null ||
              workImg ==
              null)
            return;
        try {
            synchronized (workImg)  {
                java.awt.Graphics2D g2d =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                  createGraphics(
                    workImg,
                    renderingHints);
                java.awt.Rectangle dr;
                dr =
                  new java.awt.Rectangle(
                    0,
                    0,
                    offScreenWidth,
                    offScreenHeight);
                if (isDoubleBuffered &&
                      currImg !=
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
                    java.util.Iterator iter =
                      damagedAreas.
                      iterator(
                        );
                    g2d.
                      setComposite(
                        java.awt.AlphaComposite.
                          Src);
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
                        g2d.
                          setClip(
                            r.
                              x,
                            r.
                              y,
                            r.
                              width,
                            r.
                              height);
                        g2d.
                          setComposite(
                            java.awt.AlphaComposite.
                              Clear);
                        g2d.
                          fillRect(
                            r.
                              x,
                            r.
                              y,
                            r.
                              width,
                            r.
                              height);
                        g2d.
                          setComposite(
                            java.awt.AlphaComposite.
                              SrcOver);
                        g2d.
                          drawImage(
                            currImg,
                            0,
                            0,
                            null);
                    }
                }
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
                    g2d.
                      setTransform(
                        IDENTITY);
                    g2d.
                      setClip(
                        r.
                          x,
                        r.
                          y,
                        r.
                          width,
                        r.
                          height);
                    g2d.
                      setComposite(
                        java.awt.AlphaComposite.
                          Clear);
                    g2d.
                      fillRect(
                        r.
                          x,
                        r.
                          y,
                        r.
                          width,
                        r.
                          height);
                    g2d.
                      setComposite(
                        java.awt.AlphaComposite.
                          SrcOver);
                    g2d.
                      transform(
                        usr2dev);
                    rootGN.
                      paint(
                        g2d);
                }
                g2d.
                  dispose(
                    );
            }
        }
        catch (java.lang.Throwable t) {
            t.
              printStackTrace(
                );
        }
        if (org.apache.batik.util.HaltingThread.
              hasBeenHalted(
                ))
            return;
        if (isDoubleBuffered) {
            java.awt.image.BufferedImage tmpImg =
              workImg;
            workImg =
              currImg;
            currImg =
              tmpImg;
            damagedAreas =
              devRLM;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Kj/BDBlHbdjLT5HZhpBm7eEr+/8ApYv/8zY3AAA=");
    public panda.runtime.PANDA_Attributable PANDA_copy() {
        org.apache.batik.gvt.renderer.MacRenderer PANDA_ld =
          new org.apache.batik.gvt.renderer.MacRenderer(
          );
        PANDA_ld.
          renderingHints =
          this.
            renderingHints;
        PANDA_ld.
          usr2dev =
          this.
            usr2dev;
        PANDA_ld.
          rootGN =
          this.
            rootGN;
        PANDA_ld.
          offScreenWidth =
          this.
            offScreenWidth;
        PANDA_ld.
          offScreenHeight =
          this.
            offScreenHeight;
        PANDA_ld.
          isDoubleBuffered =
          this.
            isDoubleBuffered;
        PANDA_ld.
          currImg =
          this.
            currImg;
        PANDA_ld.
          workImg =
          this.
            workImg;
        PANDA_ld.
          damagedAreas =
          this.
            damagedAreas;
        return PANDA_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Yo7XhrLJun6zPNYX42rSYXQ47yco3Vgl");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
