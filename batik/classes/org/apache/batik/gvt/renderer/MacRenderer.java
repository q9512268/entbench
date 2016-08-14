package org.apache.batik.gvt.renderer;
public class MacRenderer implements org.apache.batik.gvt.renderer.ImageRenderer, ent.runtime.ENT_Attributable {
    public int ENT_attribute() { return org.apache.batik.apps.rasterizer.EntMode.
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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OAAA");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.gvt.renderer.MacRenderer ENT_ld =
          new org.apache.batik.gvt.renderer.MacRenderer(
          );
        ENT_ld.
          renderingHints =
          this.
            renderingHints;
        ENT_ld.
          usr2dev =
          this.
            usr2dev;
        ENT_ld.
          rootGN =
          this.
            rootGN;
        ENT_ld.
          offScreenWidth =
          this.
            offScreenWidth;
        ENT_ld.
          offScreenHeight =
          this.
            offScreenHeight;
        ENT_ld.
          isDoubleBuffered =
          this.
            isDoubleBuffered;
        ENT_ld.
          currImg =
          this.
            currImg;
        ENT_ld.
          workImg =
          this.
            workImg;
        ENT_ld.
          damagedAreas =
          this.
            damagedAreas;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "YwYmT44QCsAwbXkB1RWyhMJhJXb0SR0R");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "OP7/6B6AfUVJAAA=");
}
