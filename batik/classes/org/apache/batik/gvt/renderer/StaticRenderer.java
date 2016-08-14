package org.apache.batik.gvt.renderer;
public class StaticRenderer implements org.apache.batik.gvt.renderer.ImageRenderer, ent.runtime.ENT_Attributable {
    public int ENT_attribute() { if (this.nodeCount >= 2000) { return org.apache.batik.apps.rasterizer.EntMode.
                                                                        HIGH_MODE;
                                 }
                                 else
                                     if (this.
                                           nodeCount >=
                                           500) {
                                         return org.apache.batik.apps.rasterizer.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return org.apache.batik.apps.rasterizer.EntMode.
                                                  LOW_MODE;
                                     } }
    protected org.apache.batik.gvt.GraphicsNode
      rootGN;
    protected org.apache.batik.ext.awt.image.renderable.Filter
      rootFilter;
    protected org.apache.batik.ext.awt.image.rendered.CachableRed
      rootCR;
    protected java.lang.ref.SoftReference
      lastCR;
    protected java.lang.ref.SoftReference
      lastCache;
    protected int nodeCount;
    protected boolean isDoubleBuffered = false;
    protected java.awt.image.WritableRaster
      currentBaseRaster;
    protected java.awt.image.WritableRaster
      currentRaster;
    protected java.awt.image.BufferedImage
      currentOffScreen;
    protected java.awt.image.WritableRaster
      workingBaseRaster;
    protected java.awt.image.WritableRaster
      workingRaster;
    protected java.awt.image.BufferedImage
      workingOffScreen;
    protected int offScreenWidth;
    protected int offScreenHeight;
    protected java.awt.RenderingHints renderingHints;
    protected java.awt.geom.AffineTransform
      usr2dev;
    protected static java.awt.RenderingHints
      defaultRenderingHints;
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
    public StaticRenderer(java.awt.RenderingHints rh,
                          java.awt.geom.AffineTransform at) {
        super(
          );
        renderingHints =
          new java.awt.RenderingHints(
            null);
        renderingHints.
          add(
            rh);
        usr2dev =
          new java.awt.geom.AffineTransform(
            at);
    }
    public StaticRenderer() { super();
                              renderingHints =
                                new java.awt.RenderingHints(
                                  null);
                              renderingHints.
                                add(
                                  defaultRenderingHints);
                              usr2dev = new java.awt.geom.AffineTransform(
                                          );
    }
    public void dispose() { rootGN = null;
                            rootFilter = null;
                            rootCR = null;
                            workingOffScreen =
                              null;
                            workingBaseRaster =
                              null;
                            workingRaster =
                              null;
                            currentOffScreen =
                              null;
                            currentBaseRaster =
                              null;
                            currentRaster =
                              null;
                            renderingHints =
                              null;
                            lastCache = null;
                            lastCR = null;
    }
    public void setTree(org.apache.batik.gvt.GraphicsNode rootGN) {
        this.
          rootGN =
          rootGN;
        rootFilter =
          null;
        rootCR =
          null;
        workingOffScreen =
          null;
        workingRaster =
          null;
        currentOffScreen =
          null;
        currentRaster =
          null;
        this.
          nodeCount =
          this.
            countNodes(
              rootGN);
    }
    private int countNodes(org.apache.batik.gvt.GraphicsNode node) {
        int c =
          0;
        if (node instanceof org.apache.batik.gvt.CompositeGraphicsNode) {
            org.apache.batik.gvt.CompositeGraphicsNode cn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                node;
            if (cn.
                  children ==
                  null) {
                return c;
            }
            c +=
              cn.
                children.
                length;
            for (int i =
                   0;
                 i <
                   cn.
                     children.
                     length;
                 i++) {
                if (cn.
                      children[i] !=
                      null) {
                    c +=
                      this.
                        countNodes(
                          cn.
                            children[i]);
                }
            }
        }
        return c;
    }
    public org.apache.batik.gvt.GraphicsNode getTree() {
        return rootGN;
    }
    public void setRenderingHints(java.awt.RenderingHints rh) {
        renderingHints =
          new java.awt.RenderingHints(
            null);
        renderingHints.
          add(
            rh);
        rootFilter =
          null;
        rootCR =
          null;
        workingOffScreen =
          null;
        workingRaster =
          null;
        currentOffScreen =
          null;
        currentRaster =
          null;
    }
    public java.awt.RenderingHints getRenderingHints() {
        return renderingHints;
    }
    public void setTransform(java.awt.geom.AffineTransform usr2dev) {
        if (this.
              usr2dev.
              equals(
                usr2dev))
            return;
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
        rootCR =
          null;
    }
    public java.awt.geom.AffineTransform getTransform() {
        return usr2dev;
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
            currentOffScreen =
              null;
            currentBaseRaster =
              null;
            currentRaster =
              null;
        }
        else {
            currentOffScreen =
              workingOffScreen;
            currentBaseRaster =
              workingBaseRaster;
            currentRaster =
              workingRaster;
        }
    }
    public void updateOffScreen(int width,
                                int height) {
        offScreenWidth =
          width;
        offScreenHeight =
          height;
    }
    public java.awt.image.BufferedImage getOffScreen() {
        if (rootGN ==
              null)
            return null;
        return currentOffScreen;
    }
    public void clearOffScreen() { if (isDoubleBuffered)
                                       return;
                                   updateWorkingBuffers(
                                     );
                                   if (rootCR ==
                                         null ||
                                         workingBaseRaster ==
                                         null)
                                       return;
                                   java.awt.image.ColorModel cm =
                                     rootCR.
                                     getColorModel(
                                       );
                                   java.awt.image.WritableRaster syncRaster =
                                     workingBaseRaster;
                                   synchronized (syncRaster)  {
                                       java.awt.image.BufferedImage bi =
                                         new java.awt.image.BufferedImage(
                                         cm,
                                         workingBaseRaster,
                                         cm.
                                           isAlphaPremultiplied(
                                             ),
                                         null);
                                       java.awt.Graphics2D g2d =
                                         bi.
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
                                           bi.
                                             getWidth(
                                               ),
                                           bi.
                                             getHeight(
                                               ));
                                       g2d.
                                         dispose(
                                           );
                                   } }
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
    public void repaint(org.apache.batik.ext.awt.geom.RectListManager areas) {
        if (areas ==
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
              null)
            return;
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
        synchronized (syncRaster)  {
            cr.
              copyData(
                copyRaster);
        }
        if (!org.apache.batik.util.HaltingThread.
              hasBeenHalted(
                )) {
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
        }
    }
    public void flush() { if (lastCache ==
                                null) return;
                          java.lang.Object o =
                            lastCache.
                            get(
                              );
                          if (o == null) return;
                          org.apache.batik.ext.awt.image.rendered.TileCacheRed tcr =
                            (org.apache.batik.ext.awt.image.rendered.TileCacheRed)
                              o;
                          tcr.flushCache(
                                tcr.
                                  getBounds(
                                    )); }
    public void flush(java.util.Collection areas) {
        java.awt.geom.AffineTransform at =
          getTransform(
            );
        java.util.Iterator i =
          areas.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            java.awt.Shape s =
              (java.awt.Shape)
                i.
                next(
                  );
            java.awt.Rectangle r =
              at.
              createTransformedShape(
                s).
              getBounds(
                );
            flush(
              r);
        }
    }
    public void flush(java.awt.Rectangle r) {
        if (lastCache ==
              null)
            return;
        java.lang.Object o =
          lastCache.
          get(
            );
        if (o ==
              null)
            return;
        org.apache.batik.ext.awt.image.rendered.TileCacheRed tcr =
          (org.apache.batik.ext.awt.image.rendered.TileCacheRed)
            o;
        r =
          (java.awt.Rectangle)
            r.
            clone(
              );
        r.
          x -=
          java.lang.Math.
            round(
              (float)
                usr2dev.
                getTranslateX(
                  ));
        r.
          y -=
          java.lang.Math.
            round(
              (float)
                usr2dev.
                getTranslateY(
                  ));
        tcr.
          flushCache(
            r);
    }
    protected org.apache.batik.ext.awt.image.rendered.CachableRed setupCache(org.apache.batik.ext.awt.image.rendered.CachableRed img) {
        if (lastCR ==
              null ||
              img !=
              lastCR.
              get(
                )) {
            lastCR =
              new java.lang.ref.SoftReference(
                img);
            lastCache =
              null;
        }
        java.lang.Object o =
          null;
        if (lastCache !=
              null)
            o =
              lastCache.
                get(
                  );
        if (o !=
              null)
            return (org.apache.batik.ext.awt.image.rendered.CachableRed)
                     o;
        img =
          new org.apache.batik.ext.awt.image.rendered.TileCacheRed(
            img);
        lastCache =
          new java.lang.ref.SoftReference(
            img);
        return img;
    }
    protected org.apache.batik.ext.awt.image.rendered.CachableRed renderGNR() {
        java.awt.geom.AffineTransform at;
        java.awt.geom.AffineTransform rcAT;
        at =
          usr2dev;
        rcAT =
          new java.awt.geom.AffineTransform(
            at.
              getScaleX(
                ),
            at.
              getShearY(
                ),
            at.
              getShearX(
                ),
            at.
              getScaleY(
                ),
            0,
            0);
        java.awt.image.renderable.RenderContext rc =
          new java.awt.image.renderable.RenderContext(
          rcAT,
          null,
          renderingHints);
        java.awt.image.RenderedImage ri =
          rootFilter.
          createRendering(
            rc);
        if (ri ==
              null)
            return null;
        org.apache.batik.ext.awt.image.rendered.CachableRed ret;
        ret =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            wrap(
              ri);
        ret =
          setupCache(
            ret);
        int dx =
          java.lang.Math.
          round(
            (float)
              at.
              getTranslateX(
                ));
        int dy =
          java.lang.Math.
          round(
            (float)
              at.
              getTranslateY(
                ));
        ret =
          new org.apache.batik.ext.awt.image.rendered.TranslateRed(
            ret,
            ret.
              getMinX(
                ) +
              dx,
            ret.
              getMinY(
                ) +
              dy);
        ret =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            convertTosRGB(
              ret);
        return ret;
    }
    protected void updateWorkingBuffers() {
        if (rootFilter ==
              null) {
            rootFilter =
              rootGN.
                getGraphicsNodeRable(
                  true);
            rootCR =
              null;
        }
        rootCR =
          renderGNR(
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
        int w =
          offScreenWidth;
        int h =
          offScreenHeight;
        int tw =
          sm.
          getWidth(
            );
        int th =
          sm.
          getHeight(
            );
        w =
          ((w +
              tw -
              1) /
             tw +
             1) *
            tw;
        h =
          ((h +
              th -
              1) /
             th +
             1) *
            th;
        if (workingBaseRaster ==
              null ||
              workingBaseRaster.
              getWidth(
                ) <
              w ||
              workingBaseRaster.
              getHeight(
                ) <
              h) {
            sm =
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
        }
        int tgx =
          -rootCR.
          getTileGridXOffset(
            );
        int tgy =
          -rootCR.
          getTileGridYOffset(
            );
        int xt;
        int yt;
        if (tgx >=
              0)
            xt =
              tgx /
                tw;
        else
            xt =
              (tgx -
                 tw +
                 1) /
                tw;
        if (tgy >=
              0)
            yt =
              tgy /
                th;
        else
            yt =
              (tgy -
                 th +
                 1) /
                th;
        int xloc =
          xt *
          tw -
          tgx;
        int yloc =
          yt *
          th -
          tgy;
        workingRaster =
          workingBaseRaster.
            createWritableChild(
              0,
              0,
              w,
              h,
              xloc,
              yloc,
              null);
        workingOffScreen =
          new java.awt.image.BufferedImage(
            rootCR.
              getColorModel(
                ),
            workingRaster.
              createWritableChild(
                0,
                0,
                offScreenWidth,
                offScreenHeight,
                0,
                0,
                null),
            rootCR.
              getColorModel(
                ).
              isAlphaPremultiplied(
                ),
            null);
        if (!isDoubleBuffered) {
            currentOffScreen =
              workingOffScreen;
            currentBaseRaster =
              workingBaseRaster;
            currentRaster =
              workingRaster;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PpIcyCGuiPiWxLf7+M/c/wGuIKLxKD8AAA==");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.apache.batik.gvt.renderer.StaticRenderer ENT_ld =
          new org.apache.batik.gvt.renderer.StaticRenderer(
          );
        ENT_ld.
          rootGN =
          this.
            rootGN;
        ENT_ld.
          rootFilter =
          this.
            rootFilter;
        ENT_ld.
          rootCR =
          this.
            rootCR;
        ENT_ld.
          lastCR =
          this.
            lastCR;
        ENT_ld.
          lastCache =
          this.
            lastCache;
        ENT_ld.
          nodeCount =
          this.
            nodeCount;
        ENT_ld.
          isDoubleBuffered =
          this.
            isDoubleBuffered;
        ENT_ld.
          currentBaseRaster =
          this.
            currentBaseRaster;
        ENT_ld.
          currentRaster =
          this.
            currentRaster;
        ENT_ld.
          currentOffScreen =
          this.
            currentOffScreen;
        ENT_ld.
          workingBaseRaster =
          this.
            workingBaseRaster;
        ENT_ld.
          workingRaster =
          this.
            workingRaster;
        ENT_ld.
          workingOffScreen =
          this.
            workingOffScreen;
        ENT_ld.
          offScreenWidth =
          this.
            offScreenWidth;
        ENT_ld.
          offScreenHeight =
          this.
            offScreenHeight;
        ENT_ld.
          renderingHints =
          this.
            renderingHints;
        ENT_ld.
          usr2dev =
          this.
            usr2dev;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV8CbDs2Flevzv72LPanhmPPZ5ne2zPuM1Vb+pWe7ChV7Va" +
       "arVa6lZ3C+yxWrta+9JanAHMYhwmAQdsTCrYVSEmBMpgnMTZCMQUYbUrKVMk" +
       "QKqwXUAFDIHgJDgQEsiRuu/W79477817vlU6V33Of875vvP/59cv6Rx94k8K" +
       "d/heoejYRqIYdnAoxcGhbsCHQeJI/uGQgCne8yWxY/C+PwV5zwlv+OkHvvpX" +
       "H1QfPCjcyRVewVuWHfCBZls+Lfm2sZFEovDASW7PkEw/KDxI6PyGh8JAMyBC" +
       "84NnicLLTlUNCk8RRxAgAAECEKAcAtQ6kQKV7pOs0OxkNXgr8N3CtxSuEIU7" +
       "HSGDFxRef7YRh/d4c9cMlTMALdyd/WYBqbxy7BWuHnPfcr6G8IeL0Ic+8u4H" +
       "/+lthQe4wgOaxWRwBAAiAJ1whZebkrmSPL8lipLIFR6yJElkJE/jDS3NcXOF" +
       "h31Nsfgg9KTjQcoyQ0fy8j5PRu7lQsbNC4XA9o7pyZpkiEe/7pANXgFcHznh" +
       "umXYz/IBwXs1AMyTeUE6qnL7WrPEoPDkfo1jjk/hQABUvcuUAtU+7up2iwcZ" +
       "hYe3ujN4S4GYwNMsBYjeYYegl6Dw+IWNZmPt8MKaV6TngsJj+3LUtghI3ZMP" +
       "RFYlKLxqXyxvCWjp8T0tndLPn5Bf/73vtQbWQY5ZlAQjw383qPS6vUq0JEue" +
       "ZAnStuLL30r8IP/Iz37goFAAwq/aE97K/Mu/9ZVvfNvrPvMrW5nXnCMzXumS" +
       "EDwnfHx1/+df23mmeVsG427H9rVM+WeY5+ZP7UqejR0w8x45bjErPDwq/Az9" +
       "S8tv+wnpjw8K92KFOwXbCE1gRw8JtulohuShkiV5fCCJWOEeyRI7eTlWuAuc" +
       "E5olbXPHsuxLAVa43ciz7rTz32CIZNBENkR3gXPNku2jc4cP1Pw8dgqFwl3g" +
       "KHwDON5e2P7l/4PCc5BqmxLEC7ylWTZEeXbG34ckK1iBsVWhFbD6NeTboQdM" +
       "ELI9BeKBHajSrkDZBBBQggg04UHbuUTvfh5mhuZ87buIM5YPRleuAAW8dn/6" +
       "G2DmDGwDSD8nfChs977yU8999uB4OuzGJyi8DfR6uO31MO/1EPR6eNTr4dle" +
       "C1eu5J29Mut9q2mgpzWY8cAXvvwZ5l3D93zgDbcBE3Oi28EgHwBR6GKX3Dnx" +
       "EVjuCQVgqIXP/FD0PvZbSweFg7O+NUMMsu7NqlOZRzz2fE/tz6nz2n3gu//w" +
       "q5/8weftk9l1xlnvJv21NbNJ+4b9sfVsQRKBGzxp/q1X+U8/97PPP3VQuB14" +
       "AuD9Ah5YK3Asr9vv48zkffbIEWZc7gCEZdszeSMrOvJe9waqZ0cnObnS78/P" +
       "HwJj/LLMml8Njmhn3vn/rPQVTpa+cmskmdL2WOSO9h2M89Hf+g9frubDfeST" +
       "Hzh1lWOk4NlTfiBr7IF8xj90YgNTT5KA3O/8EPUDH/6T7/6m3ACAxBvP6/Cp" +
       "LO2A+Q9UCIb5u37F/e0vfuHjv3FwbDRXAnAhDFeGJsTHJLP8wr2XkAS9vfkE" +
       "D/AjBphomdU8NbNMW9RkjV8ZUmal//eBN5U//d++98GtHRgg58iM3vbiDZzk" +
       "v7pd+LbPvvt/vy5v5oqQXcdOxuxEbOscX3HScsvz+CTDEb/v15/4+7/MfxS4" +
       "WeDafC2Vcm91sJs4GahXBYVH85p8FBxupyC4aA3AddE/Kn/iuFyRbPOwJcvA" +
       "6qYeb/mZIeWqh3LZt+bpYT52+WjmZXCWPOmfnkJnZ+mpqOU54YO/8Wf3sX/2" +
       "c1/JOZ8Ne05bzIh3nt0aaZZcjUHzj+77iwHvq0Cu9hnymx80PvNXoEUOtCgA" +
       "L+iPPcAzPmNfO+k77vovP/8Lj7zn87cVDvqFew2bF/t8PlUL94A5Ivkq8Hax" +
       "8w3fuDORu0HyYE61cA35POPxayfR+3b29b7zJ1GWvj5L3nStaV5U9ZLhb19S" +
       "1s2Sd+RF9Sx55xZz87robWUfy3+9Coz/Mxc74X4WlJ34scf+z9hYffvv/sU1" +
       "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" +
       "Wm8YkMxQBuDTCGkaHM6Iqw5Sq03qTjVB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "f/2PfewL+a60/w9OiBSxGlIAAA==");
}
