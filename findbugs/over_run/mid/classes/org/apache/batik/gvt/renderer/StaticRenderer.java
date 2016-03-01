package org.apache.batik.gvt.renderer;
public class StaticRenderer implements org.apache.batik.gvt.renderer.ImageRenderer, panda.runtime.PANDA_Attributable {
    public int PANDA_attribute() { if (this.nodeCount >= 2000) { return org.apache.batik.apps.rasterizer.PandaMode.
                                                                          HIGH_MODE;
                                   }
                                   else
                                       if (this.
                                             nodeCount >=
                                             500) {
                                           return org.apache.batik.apps.rasterizer.PandaMode.
                                                    MID_MODE;
                                       }
                                       else {
                                           return org.apache.batik.apps.rasterizer.PandaMode.
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
        panda.runtime.PANDA_Util.
          writeModeFile(
            java.lang.String.
              format(
                "NodeCount: %d\n",
                this.
                  nodeCount));
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Lef5yFSL66wH8/fn/x/Zm7GMfj0AAA==");
    public panda.runtime.PANDA_Attributable PANDA_copy() {
        org.apache.batik.gvt.renderer.StaticRenderer PANDA_ld =
          new org.apache.batik.gvt.renderer.StaticRenderer(
          );
        PANDA_ld.
          rootGN =
          this.
            rootGN;
        PANDA_ld.
          rootFilter =
          this.
            rootFilter;
        PANDA_ld.
          rootCR =
          this.
            rootCR;
        PANDA_ld.
          lastCR =
          this.
            lastCR;
        PANDA_ld.
          lastCache =
          this.
            lastCache;
        PANDA_ld.
          nodeCount =
          this.
            nodeCount;
        PANDA_ld.
          isDoubleBuffered =
          this.
            isDoubleBuffered;
        PANDA_ld.
          currentBaseRaster =
          this.
            currentBaseRaster;
        PANDA_ld.
          currentRaster =
          this.
            currentRaster;
        PANDA_ld.
          currentOffScreen =
          this.
            currentOffScreen;
        PANDA_ld.
          workingBaseRaster =
          this.
            workingBaseRaster;
        PANDA_ld.
          workingRaster =
          this.
            workingRaster;
        PANDA_ld.
          workingOffScreen =
          this.
            workingOffScreen;
        PANDA_ld.
          offScreenWidth =
          this.
            offScreenWidth;
        PANDA_ld.
          offScreenHeight =
          this.
            offScreenHeight;
        PANDA_ld.
          renderingHints =
          this.
            renderingHints;
        PANDA_ld.
          usr2dev =
          this.
            usr2dev;
        return PANDA_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18C7Tr2Fme75n3JJk7MyEzk0kmc5NMwswoObJetpUhAduS" +
       "JdmSJb9tQTKRJVmSrffDsp0OEB4li2mBQkjoKslqKZTCCoSWpi9KOyxaAk0W" +
       "XWHRlnQtSBZ08UqhpC00bVroluzz8rnnzL1zLz1raR95P79v///+97+lvfWJ" +
       "PyrcFYUFyPfstWF78aG+ig/nNnEYr309OmzyhKSEka7VbSWK+iDuefUtP3P1" +
       "z776feaDB4W75cJrFdf1YiW2PDfq6pFnL3WNL1w9iaVt3YniwoP8XFkqcBJb" +
       "NsxbUfwcX3jVqaJx4Sn+CAIMIMAAApxDgKsnuUCh1+hu4tSzEoobR0HhmwtX" +
       "+MLdvprBiwtvPluJr4SKs6tGyhmAGu7Nfg8BqbzwKixcO+a+5XyO8A9C8Ic/" +
       "+r4H/+Edhaty4arl9jI4KgARg0bkwqsd3ZnqYVTVNF2TCw+5uq719NBSbGuT" +
       "45YLD0eW4SpxEurHnZRFJr4e5m2e9Nyr1YxbmKixFx7Tm1m6rR39umtmKwbg" +
       "+sgJ1y3DRhYPCN5vAWDhTFH1oyJ3LixXiwtP7pc45vhUC2QARe9x9Nj0jpu6" +
       "01VAROHhrexsxTXgXhxargGy3uUloJW48PiFlWZ97SvqQjH05+PCY/v5pG0S" +
       "yHVf3hFZkbjwuv1seU1ASo/vSemUfP6o/XXf8wGXdQ9yzJqu2hn+e0GhN+0V" +
       "6uozPdRdVd8WfPWz/EeUR37+QweFAsj8ur3M2zz/5K98+Rve8aaXfnmb5w3X" +
       "ySNO57oaP6/+6PSBz72x/gx5RwbjXt+LrEz4Z5jn6i/tUp5b+WDkPXJcY5Z4" +
       "eJT4UveXJt/6k/qXDgr3c4W7Vc9OHKBHD6me41u2HjK6q4dKrGtc4T7d1ep5" +
       "Ole4B9zzlqtvY8XZLNJjrnCnnUfd7eW/QRfNQBVZF90D7i135h3d+0ps5vcr" +
       "v1Ao3AOuwteD612F7V/+Py44sOk5Oqyoimu5HiyFXsY/E6irKXCsR+BeA6m+" +
       "B0+B/i/eiRyW4chLQqCQsBcasAK0wtS3ibCxjGEgEg3IJYS3I6u7+3mYqZ3/" +
       "/7vBVdYDD6ZXrgDhvHHfNNhgVLGeDXI/r344qdFf/unnP3NwPFR2fRcX3gFa" +
       "Pdy2epi3eghaPTxq9fBsq4UrV/LGviZrfasFQIYLYA2AnXz1M733Nt//obfc" +
       "AdTPT+8EAjgAWeGLzXX9xH5wuZVUgRIXXvqh9IPDbykeFA7O2t0MMYi6Pysu" +
       "Zdby2Co+tT/erlfv1e/6/T/75Ede8E5G3hlDvjMI50tmA/ot+30beqquARN5" +
       "Uv2z15RPPf/zLzx1ULgTWAlgGWMFaDIwOm/ab+PMwH7uyEhmXO4ChGde6Ch2" +
       "lnRk2e6PzdBLT2JyoT+Q3z8E+vhVmaa/HlzpTvXz/1nqa/0s/JqtkmRC22OR" +
       "G+F39/yP/cav/gGWd/eRvb56agbs6fFzp2xEVtnV3Bo8dKID/VDXQb7f/CHp" +
       "B37wj77rG3MFADneer0Gn8rCOrANQISgm7/zl4PPf+G3fvTXD46V5koMJslk" +
       "alvq6phkFl+4/xKSoLW3n+ABNsYGwy7TmqcGruNp1sxSpraeaen/ufo25FP/" +
       "5Xse3OqBDWKO1OgdL1/BSfzra4Vv/cz7/ueb8mquqNkcd9JnJ9m2hvO1JzVX" +
       "w1BZZzhWH/y1J/7mp5WPARMMzF5kbfTckh3sBk4G6nVx4dG8pJLGh9shCCY0" +
       "FsyZ0VH6E8fphu45h9XZDGhdP1TcKFOkXPRwnvfZPDzM+y7vzTyNyIIno9ND" +
       "6OwoPeXRPK9+36//yWuGf/Ivv5xzPusSndYYQfGf2yppFlxbgeof3bcXrBKZ" +
       "IB/+UvubHrRf+iqoUQY1qsAKRmIIeK7O6Ncu9133/Kdf+MVH3v+5OwoHjcL9" +
       "tqdoDSUfqoX7wBjRIxNYu5X/9d+wU5F7QfBgTrVwjnwe8fj5QfTBnX598PqD" +
       "KAvfnAVvO6+aFxW9pPtrl6RRWfDuPKmUBe/ZYiZviN4272P5r9eB/n/mYiPc" +
       "yBy2Ezv22P8W7em3/fZXzsk4N7/X8VP2ysvwJ3748fp7vpSXP7GDWek3rc7P" +
       "UsC5PSmL/qTzpwdvufvfHBTukQsPqjvPeajYSWZdZOAtRkfuNPCuz6Sf9fy2" +
       "bs5zx3b+jfs2+FSz+xb4ZHYE91nu7P7+PaP7QNbLXwsubid0bl9frhTym/ZW" +
       "ZfLwqSz42iMbd58fejFAqWs7M/cX4O8KuP48u7LqsoitG/NwfedLXTt2pnww" +
       "dd8del7MtI9swZuvO5MzoeKblhq1PU0/UeJcpcSXUynuLGEIXM0d4eYFhOUL" +
       "CGe33bwXe3Hh/gx4w7KBV34EvngOfKapmWGzHOB67xySzAYfbgvucfnGm+SS" +
       "Ca+149K6gIt6I1xyIdS7RzywG+Kha4d1kCWj09W1PSraK6DC76jwF1Cxb4gK" +
       "WKdkVMLCmy+wF10lzRczz6v/rPPFz31s88lPbKfRqQK89QJ00br4/NI886re" +
       "dolneLJi+lPmXS/9we8M33uws4uvOkv+DZeRPxLKG/KpJDMNoP9nhz1vFh97" +
       "YVmW5Z4EnJuUwLPgEnYghAsksLkRCdyXSyBTnjxfcJ7rhc0c89gn84GbJPNG" +
       "cLV3rbQvIPPtN0TGBSan7iXAXbl0BpJCywG+5XK30oVfePgLix/+/Z/armL3" +
       "p5u9zPqHPvzdf3H4PR8+OPXs4K3nlu+ny2yfH+QYX5MDXZ3R9+u0kpdo/N4n" +
       "X/i5v//Cd21RPXx2JUy7ifNT/+H/fvbwh774K9dZYt0BPLY9oXzHTQoFBldv" +
       "J5TeBUL5/hsRyoNWRHnAu9ZrySwbAdsHKB/a9UT276/FhXumnmfrirsH+gde" +
       "AejxDvT4AtA/fCOgH1KTEAzWuAbMTBeMkJNp48T/3ZrXUWjFuVXNc+3h/9gr" +
       "mO8mO/yTC/D/2I3gf80O/wmqv7MH7e/dJLTM2ZN30OQLoH3ihvRhB02czXoq" +
       "WMa5Rz37xr2ePdIXLvu1h/6nXoFifNMO/TddgP5TN6QYqReCQW+cKMb1Ovcf" +
       "vwK5v3cH770XwPsXNyT3HbyLof38K5D7+3bQ3ncBtF+8IbnvoB3LPYv/B3vo" +
       "/vVNonszuN6/Q/f+C9D92xtB94B3BGtkadsHfS/uYfvMTWJ7C7iUHTblAmyf" +
       "uxFsV4+xsbplmPH1wP3aTYJ7B7hmO3CzC8D9xg11XHjmMUEWW9zD9vmbxPZ2" +
       "cBk7bMYF2L5wI9juSaIQ1fTcP0H3QH3xxkG9LovNnu9aO1DWBaB+9/qgDnJQ" +
       "wNuN8kebR+hep+kzJbHj7st24O+9LNa8ytUVsMq7Cz0sH+YV/PH10dyR3T6d" +
       "BX8Ics8sV7GPED06t9WnjlZ+QzDngWX4U3O7fGShHzzxarevOvZw9m4YJ/CA" +
       "HjipjPdc47kX//P3ffZ73/oF4M00C3ctsyU2cHtOtdhOshdJf/UTP/jEqz78" +
       "xRfzp3dA3tJH6Ae/Iav1Ky/LNgv+2xHVxzOqvfwxOA9spZA/cNO1Y7Z7/smd" +
       "tncLbONH/jaLR1z16I9HptS4qq7kcTJWnR4vkZztQqspI/GCZ9sRHtVQTOec" +
       "9nztoqsmsnAZo4rP56hcHuJtV8YVeezaMe7Vfc403G7HwE1+OQnn3izpiONU" +
       "69gbG+HS2SIguHp9QfFsc1xdmJwY1piWl9rqcCMMMVwrhyXNkV2tqOuj4jDw" +
       "/VEZ7pYxnSzDsxApERUCNmmZIK3FatgS7GbTSNZY0GS9FVZaTqgFgpS4cD7l" +
       "RpgBBTUY2+ChK8Ftl5i57Y6wEFzKisW4ZRBaiNAk0Vl3Ejk0BWHYCbQ2pXQ8" +
       "QnewYMDG9ET2fapJ+U4syvG420aGFuYoTS6i0VVSMQZmvzFlKt4KtRbBROyv" +
       "eYtoLxZJf1wrOopYsWhk3EeT4mZTJ6xS1RoASKNphTR9ng01Z0j3dGXiW3q5" +
       "zekIgaLrFcUjWNfV5KqjyLg7JfVhnZaTku3rnqePfXMBi9Jmrq7bg3TYp4UF" +
       "xnB9k0T6LEr7oc8ZMIm6g9JmY2KLoNQLrGLK0ZTUQ5MB4nhdZkHWPZPU3Wqy" +
       "cAc9cVzuVwlWnA6HjOi3atV5HffCqNudrid+oIeuMKAFjSYNQijVtXGRCrWx" +
       "yuGhPm5WSYgoT5lZybCojrjo9KXSoJsOTYbqrKtVz2YUNhDRqB8MPcWrCYJC" +
       "UVDJiVvTAO3CXXRRatsUN7bTaqcS6xTv0sMYC5RlCzKbKTN1h8xUqY1Nf2r3" +
       "LaRsFUOnUy2l6SzA41Sa4qwhDZQ6o7iNaZVMhy1ysGn3MK7UEjveZLRRqeqU" +
       "GsnWYto24vawG7WW9Vo79FzP8htN0pNWTHdhsCO9XtdCFbF6Qw9U3NVQXxYN" +
       "gytLdY1HEnpYbxO4X20sFMes2Hhfq/FRUSQbojWbY0Eyg2ripCR0mxumIw6G" +
       "Q1Yfzar0ZtNZrMg2jcT1RKrK8maCLEeckEgyPG7UDdYsWW3LhlR96UrYuug6" +
       "7tjt+k607ExrTslV/GjAIpEi8b7YRXm4nLZWirXp0zNqY5H1zUKTw7Xpb5Cl" +
       "oYwmAyXq182GhgcJOZuW3TJDFftNeKT59AQhh+mozFgtxZnEfWWG1hy/M0Lp" +
       "IjJwmcFaGqZqVO71sEWy6VGJA2F+WxBlGV2MEn2pLDYQg/QGpuV3urNRB8HX" +
       "xZI+iM0Otpm1ccts9+sdtFQlNqEFL1l4zvT6KaqMmuZwKPT7VF+aKs2EZ6lk" +
       "AJmboNMvMr7cU9hUIrBxuIiiPu871GJKUU0f9Z1F1Z6s+m2sLjMK3VQa/CCu" +
       "LrWY00ZjzJJTvr1ZBhWmsp7XgmliRSNDhRR6PBFEDw3mQUdCPNZLY3SqoYrK" +
       "jLFpm/L0VrFWnPdK7NBsx4ER6orRmPTHQdLEbbnJC5Opgytxgkyqs6nRX1YZ" +
       "HMcdHiprSzRkYL8TChvSH1LdYqdGcmEvUFwqJmOdJ6ABhUBJAqsbjBzN1isR" +
       "T2qy6dRKlUTnkIAjUh+zpg3Rbo1rvSh26xXCbEKzVWdoEOtS3NCg8lTTuqMx" +
       "B83RSG2ucJ7pLLu6pilME1nWUh7RlimGLWcYDzQYdSS4zhNmYwlZS7PLwj06" +
       "KSuCZNbiEQqpLp+iUzRWh1y7b3iqgLQNjmMlZ6UlXsVaxmwEMSE7qOr1ojJS" +
       "h+wkqqyQUDIdZGPDEIOS6cD1K8y4n9ZqpG9XxLTH4TC8Ijm5EUw2427ccFLH" +
       "xFmpasNBnKJQBYqAVWtjutamO444K7dGkZTUrSjkFmVv7UD1UQlpdUal8QZW" +
       "ILiOSeVwyZddsqqO66qBopPYq4WGU6Lb3UoZj7Gl5EzjFVmWhqUU7VqU2Pew" +
       "mtgQl0a1hxFSqd6seUQZr+Bis8hIQ6+tFDHGqQ9Htt833V7LgLows5rEIuya" +
       "VRxNWH2erubi3FfaY5yH4GkVJSBoPN1E2BxRu0D7m6Q7sxdhDOmlWK+goTLE" +
       "eiY7i8lQheGgpg/STZUytC4SU9BIbNfLDN/xEItgZLchyatuK6nhFKHV2wI6" +
       "IcZSqHXcoOG0Q7rkdpQQRb3Q9ERmxS+h0aI0JcQFMmY11SlvInGxUly92mmZ" +
       "JduY1MAcg6XkpOJOZ0s8mQqqijXoRtibTKNhoOHFwaI4JAKWcNAGEg+bK9Pj" +
       "l+hQgOL5LPArCDWvtnueYbbROLaqAkIuxnizNBYRGBZiSU5SfDwYW6WiQ06t" +
       "wCc73ixwOpV5jQ0oTtxshhE2aziTXq24mHfToNVhpOW4SUAzQrfLg0m5RJPw" +
       "pr+pkTMYlhksGblrJlFG89AnU4vC7C6JOI1SrTdMfF6NJxwchEKpGQlrOdSH" +
       "dLmZLFV8KgXpslfjN746d6ZQGLk1hVIr2qxqWxCMSO4mTCCYrJQdOBwPKDca" +
       "rocr2HLgMcvPwo6kk9DIaTYxwQHKI9fhqtTEcc3RSmkphW1yii/VOizagw0r" +
       "dDflJaLq6xluYYiUFvuOx/ZaQmAbs2mDQsGgALONw7OjjVSlg5a3pKyKNhIJ" +
       "MgKYrVlU6khtc4lW2LRZZYPFSlq7C9TS5giW1twFYbZkxOTwqOvGroOattRA" +
       "xTUiiQt8jU3letXuT0ZqSelxSkTX0NK02V528bEj19BuzTZKyCQlwoAU6lEZ" +
       "icpxGZ12Q5HEnFanB1Fys9WXm1XGhzjJt20uEhyCKZksry9QtjGxWKLk9STG" +
       "Skv0COHr6aYr1RvUHDYFb2pQwwFHwXEarWpplPb1ssymcnttBZuwJDHz8bhW" +
       "LToLv1itLqxyS/RpPtAaOJP0KvNxc8C63Varr3aE0ohfmOKSGnWGEI2uKTLp" +
       "MSzZc8qQ2EwGEsKsy1h5adfKmjcOrUQZ+51SVC1ViLjUNOGQZSlZr8Tjjb3q" +
       "LasaRFYgZU4Em/Zqig3H82hkY+KqCMNreT6tTAm6MWTVaW9ULpqsByZgMpE7" +
       "dH88alB8K4DmwzRBKhIk+IJcVHSBac39YcqQianZ/d7Y5gMBstlJ2nIWidMo" +
       "V8r9TXmjrZcYX8aIoLWManJLXikzuDiEKiocpq4psdi0Kg7VMkfHC3Sgu3qD" +
       "nhLWujlqhWUTZlhKU1RIZ+ApGVoTDcg9ms+W8ynpsHbfgKs1ipcxr02KENNj" +
       "m8vJyG9D05LClyKKcHoowrejSIJVcjbGYqPew31x4KubmIrXMdUeSuxsIIaO" +
       "aTAYkawlaFbnhNJGwq0Ku2lim44H5KkgZpsdtdwJS5hBpb6u2HOx10rbkUWz" +
       "ac8v0gyWatV4WvYnuMWQDHBV5HZxlWI0Yyx1hg/xzmI2rdV7+qxaXEtKyW9w" +
       "0MJaAAc2WbR7VTcppuqqTq5XKzEsIfZEHiCcsTFW3GqjbVazBNVjGfWxictV" +
       "u0WC9mujgCs7WKmvlqkyBvtUIqZOY2g154mEzY2o0qFqJFIjGJzmrY1spct1" +
       "0kxqoV8c+o2og3RCdyRBZRqLYVia6xCy9h0vwGJtIif6ur+ELXi4aknLZbvn" +
       "zNBea4FEhDFh6FmpIqFr0LCTVggpJbllUiK0IpyIXbcHz+Wg21VJRYlalq1g" +
       "TZ+sTpM4sTFTDVMMalRhpzIJusV1f9xTGni/aE3iqh6KHXI0aRZNkub84UrY" +
       "NBsbzTXKmqGoQoMUqCkZCPEsKAfmmkbRlWvQaWDXFzShd6tdwlpRQcNwFvJa" +
       "MNdTQ+arTbXHlwwp9ZuAV6NoTQ2mS8XUwFrM+kRvZC4wpxl0tEVUwhRYsWuB" +
       "Dic6DdRHnlgzCDiCpdJgOEFaSB30lW2w+Kg+mDNUV0HW5X6tgQ4r1joc1xRS" +
       "N4VG1ECRxC7OK3oAnH4HT5k6sxq3fXgJDHEyQIsaEdNoqFq+PFwZFZpTOhFj" +
       "QOSsbriVIPUaY4OSqJhdUJ5bLRcnLV5sOzLP+71x0LfdpsR1So0Viy47wKPG" +
       "Gw3awH0aq1asFahPIJsdmlXnSJ+nwua6siyRHSwYpz494pWJU2GLs1YLEhhS" +
       "8xsjHCzfXJvDeGFouVFDqrndCT2xyqHNqaMx6GrJYaVl0KhhNReMDNUlSvi4" +
       "Ka7KGq4Eo6Y97zVdthIsyUVvBaXVsGFoM6faR52S3LDpFUe2++0WttDaE+CB" +
       "c7CV1gfkauyVN9P1cuX1RN/gYwH3ncpQqUlCOlivm5LPWzQuY5w3qGHIRtZ7" +
       "kUSapTIB1btIc7rkZ1IdbQmd+kbqJ3bL5RAwEVCQZuJlszmiMQkdozFEjpau" +
       "kpQClJUXxUhSZnUnkZv9gFWIamOTcPS4vHTJcgsNTVcbqNUaondMOBE8N/Eg" +
       "OBbpFqnQuLQ2MS2NeSq2eEcLwGLPRdrOgEDXpo5OBwM9dFJ2hiBFNZ5Rq2Q5" +
       "Lerr8siQWyU1SqCBmqzXVlhz+kq/WhkQ/tzp4HED6o7mhKkEDqVGujMsI/N5" +
       "CTHnUbfcaa/w4YQjRqGhykpqhlytPNsYDVgYcPJUNqIaM8BtsWGChZxaStvL" +
       "5ahvuKyBSu3KuOhW4Ko7n2jqsCoIy1HXoUwWa07pdTNgaSD0NV+sjPRJEyws" +
       "hhhNzmtLzhXXnZBohby9sKMy5amuqdPVmh6005HcSrvFtkzbLaxB0IlRHmxq" +
       "lGCiLCwG0ZQFzmKDGHbmkJKMJrKyWcN2WUxnQ7oqwg2/1q7rUwpegMW1WOPQ" +
       "8ZRrqTUqxSVcM3RRW9sDY4IjVbFW62pW5LRTvtSvuUWZd6RZvJwwQm2tCzhX" +
       "Z9SguybndndZ7Rn4hlXoOtVuzuuW0E86");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
