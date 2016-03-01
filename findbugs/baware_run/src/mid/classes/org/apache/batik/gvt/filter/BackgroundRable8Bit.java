package org.apache.batik.gvt.filter;
public class BackgroundRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable {
    private org.apache.batik.gvt.GraphicsNode node;
    public org.apache.batik.gvt.GraphicsNode getGraphicsNode() { return node;
    }
    public void setGraphicsNode(org.apache.batik.gvt.GraphicsNode node) {
        if (node ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          node =
          node;
    }
    public BackgroundRable8Bit(org.apache.batik.gvt.GraphicsNode node) { super(
                                                                           );
                                                                         if (node ==
                                                                               null)
                                                                             throw new java.lang.IllegalArgumentException(
                                                                               );
                                                                         this.
                                                                           node =
                                                                           node;
    }
    static java.awt.geom.Rectangle2D addBounds(org.apache.batik.gvt.CompositeGraphicsNode cgn,
                                               org.apache.batik.gvt.GraphicsNode child,
                                               java.awt.geom.Rectangle2D init) {
        java.util.List children =
          cgn.
          getChildren(
            );
        java.util.Iterator i =
          children.
          iterator(
            );
        java.awt.geom.Rectangle2D r2d =
          null;
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.gvt.GraphicsNode gn =
              (org.apache.batik.gvt.GraphicsNode)
                i.
                next(
                  );
            if (gn ==
                  child)
                break;
            java.awt.geom.Rectangle2D cr2d =
              gn.
              getBounds(
                );
            java.awt.geom.AffineTransform at =
              gn.
              getTransform(
                );
            if (at !=
                  null)
                cr2d =
                  at.
                    createTransformedShape(
                      cr2d).
                    getBounds2D(
                      );
            if (r2d ==
                  null)
                r2d =
                  (java.awt.geom.Rectangle2D)
                    cr2d.
                    clone(
                      );
            else
                r2d.
                  add(
                    cr2d);
        }
        if (r2d ==
              null) {
            if (init ==
                  null)
                return org.apache.batik.gvt.CompositeGraphicsNode.
                         VIEWPORT;
            return init;
        }
        if (init ==
              null)
            return r2d;
        init.
          add(
            r2d);
        return init;
    }
    static java.awt.geom.Rectangle2D getViewportBounds(org.apache.batik.gvt.GraphicsNode gn,
                                                       org.apache.batik.gvt.GraphicsNode child) {
        java.awt.geom.Rectangle2D r2d =
          null;
        if (gn instanceof org.apache.batik.gvt.CompositeGraphicsNode) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            r2d =
              cgn.
                getBackgroundEnable(
                  );
        }
        if (r2d ==
              null)
            r2d =
              getViewportBounds(
                gn.
                  getParent(
                    ),
                gn);
        if (r2d ==
              null)
            return null;
        if (r2d ==
              org.apache.batik.gvt.CompositeGraphicsNode.
                VIEWPORT) {
            if (child ==
                  null)
                return (java.awt.geom.Rectangle2D)
                         gn.
                         getPrimitiveBounds(
                           ).
                         clone(
                           );
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            return addBounds(
                     cgn,
                     child,
                     null);
        }
        java.awt.geom.AffineTransform at =
          gn.
          getTransform(
            );
        if (at !=
              null) {
            try {
                at =
                  at.
                    createInverse(
                      );
                r2d =
                  at.
                    createTransformedShape(
                      r2d).
                    getBounds2D(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException nte) {
                r2d =
                  null;
            }
        }
        if (child !=
              null) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            r2d =
              addBounds(
                cgn,
                child,
                r2d);
        }
        else {
            java.awt.geom.Rectangle2D gnb =
              gn.
              getPrimitiveBounds(
                );
            if (gnb !=
                  null)
                r2d.
                  add(
                    gnb);
        }
        return r2d;
    }
    static java.awt.geom.Rectangle2D getBoundsRecursive(org.apache.batik.gvt.GraphicsNode gn,
                                                        org.apache.batik.gvt.GraphicsNode child) {
        java.awt.geom.Rectangle2D r2d =
          null;
        if (gn ==
              null) {
            return null;
        }
        if (gn instanceof org.apache.batik.gvt.CompositeGraphicsNode) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            r2d =
              cgn.
                getBackgroundEnable(
                  );
        }
        if (r2d !=
              null)
            return r2d;
        r2d =
          getBoundsRecursive(
            gn.
              getParent(
                ),
            gn);
        if (r2d ==
              null) {
            return new java.awt.geom.Rectangle2D.Float(
              0,
              0,
              0,
              0);
        }
        if (r2d ==
              org.apache.batik.gvt.CompositeGraphicsNode.
                VIEWPORT)
            return r2d;
        java.awt.geom.AffineTransform at =
          gn.
          getTransform(
            );
        if (at !=
              null) {
            try {
                at =
                  at.
                    createInverse(
                      );
                r2d =
                  at.
                    createTransformedShape(
                      r2d).
                    getBounds2D(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException nte) {
                r2d =
                  null;
            }
        }
        return r2d;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        java.awt.geom.Rectangle2D r2d =
          getBoundsRecursive(
            node,
            null);
        if (r2d ==
              org.apache.batik.gvt.CompositeGraphicsNode.
                VIEWPORT) {
            r2d =
              getViewportBounds(
                node,
                null);
        }
        return r2d;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getBackground(org.apache.batik.gvt.GraphicsNode gn,
                                                                          org.apache.batik.gvt.GraphicsNode child,
                                                                          java.awt.geom.Rectangle2D aoi) {
        if (gn ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "BackgroundImage requested yet no parent has " +
              "\'enable-background:new\'");
        }
        java.awt.geom.Rectangle2D r2d =
          null;
        if (gn instanceof org.apache.batik.gvt.CompositeGraphicsNode) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            r2d =
              cgn.
                getBackgroundEnable(
                  );
        }
        java.util.List srcs =
          new java.util.ArrayList(
          );
        if (r2d ==
              null) {
            java.awt.geom.Rectangle2D paoi =
              aoi;
            java.awt.geom.AffineTransform at =
              gn.
              getTransform(
                );
            if (at !=
                  null)
                paoi =
                  at.
                    createTransformedShape(
                      aoi).
                    getBounds2D(
                      );
            org.apache.batik.ext.awt.image.renderable.Filter f =
              getBackground(
                gn.
                  getParent(
                    ),
                gn,
                paoi);
            if (f !=
                  null &&
                  f.
                  getBounds2D(
                    ).
                  intersects(
                    aoi)) {
                srcs.
                  add(
                    f);
            }
        }
        if (child !=
              null) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            java.util.List children =
              cgn.
              getChildren(
                );
            java.util.Iterator i =
              children.
              iterator(
                );
            while (i.
                     hasNext(
                       )) {
                org.apache.batik.gvt.GraphicsNode childGN =
                  (org.apache.batik.gvt.GraphicsNode)
                    i.
                    next(
                      );
                if (childGN ==
                      child)
                    break;
                java.awt.geom.Rectangle2D cbounds =
                  childGN.
                  getBounds(
                    );
                java.awt.geom.AffineTransform at =
                  childGN.
                  getTransform(
                    );
                if (at !=
                      null)
                    cbounds =
                      at.
                        createTransformedShape(
                          cbounds).
                        getBounds2D(
                          );
                if (aoi.
                      intersects(
                        cbounds)) {
                    srcs.
                      add(
                        childGN.
                          getEnableBackgroundGraphicsNodeRable(
                            true));
                }
            }
        }
        if (srcs.
              size(
                ) ==
              0)
            return null;
        org.apache.batik.ext.awt.image.renderable.Filter ret =
          null;
        if (srcs.
              size(
                ) ==
              1)
            ret =
              (org.apache.batik.ext.awt.image.renderable.Filter)
                srcs.
                get(
                  0);
        else
            ret =
              new org.apache.batik.ext.awt.image.renderable.CompositeRable8Bit(
                srcs,
                org.apache.batik.ext.awt.image.CompositeRule.
                  OVER,
                false);
        if (child !=
              null) {
            java.awt.geom.AffineTransform at =
              child.
              getTransform(
                );
            if (at !=
                  null) {
                try {
                    at =
                      at.
                        createInverse(
                          );
                    ret =
                      new org.apache.batik.ext.awt.image.renderable.AffineRable8Bit(
                        ret,
                        at);
                }
                catch (java.awt.geom.NoninvertibleTransformException nte) {
                    ret =
                      null;
                }
            }
        }
        return ret;
    }
    public boolean isDynamic() { return false;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext renderContext) {
        java.awt.geom.Rectangle2D r2d =
          getBounds2D(
            );
        java.awt.Shape aoi =
          renderContext.
          getAreaOfInterest(
            );
        if (aoi !=
              null) {
            java.awt.geom.Rectangle2D aoiR2d =
              aoi.
              getBounds2D(
                );
            if (!r2d.
                  intersects(
                    aoiR2d))
                return null;
            java.awt.geom.Rectangle2D.
              intersect(
                r2d,
                aoiR2d,
                r2d);
        }
        org.apache.batik.ext.awt.image.renderable.Filter background =
          getBackground(
            node,
            null,
            r2d);
        if (background ==
              null)
            return null;
        background =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
            background,
            r2d,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD);
        java.awt.image.RenderedImage ri =
          background.
          createRendering(
            new java.awt.image.renderable.RenderContext(
              renderContext.
                getTransform(
                  ),
              r2d,
              renderContext.
                getRenderingHints(
                  )));
        return ri;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZfZAUxRXv3eP2PuE+kA8BDzxODKi7ghq0jiQeB8jhHlzd" +
       "IVUeiUvvbO/ewOzMMNN7t2AIQlWUWCnLKBqSCH8kWIkUflQqJimNhpQmaoyx" +
       "UCvxo6KJ/qHxI0pV4pmYxLzXPV87+4FXWJWrmt6+6fde93v93u+97jn+Hqm3" +
       "LdJtUj1D43yXyez4EPaHqGWzTL9GbXszvE0pN//l9r2Tzzfti5LYKJkxRu1B" +
       "hdpsncq0jD1KzlF1m1NdYfZGxjLIMWQxm1njlKuGPkpmqfZA3tRUReWDRoYh" +
       "wRZqJUkH5dxS0wXOBhwBnCxMitUkxGoSfWGC3iRpVQxzl88wr4ShPzCGtHl/" +
       "PpuT9uR2Ok4TBa5qiaRq896iRS4wDW1XTjN4nBV5fLt2mWOIDcnLyszQ/UDb" +
       "hx/fOtYuzDCT6rrBhYr2MLMNbZxlkqTNf7tWY3l7J/kaqUuSlgAxJz1Jd9IE" +
       "TJqASV19fSpY/XSmF/L9hlCHu5JipoIL4uTcUiEmtWjeETMk1gwSGrmju2AG" +
       "bRd52rrbHVLxjgsSB799XfuP60jbKGlT9RFcjgKL4DDJKBiU5dPMsvsyGZYZ" +
       "JR06bPgIs1Sqqbud3e601ZxOeQFcwDULviyYzBJz+raCnQTdrILCDctTLyuc" +
       "yvmvPqvRHOg629dVargO34OCzSoszMpS8D2HZdoOVc8IPyrl8HTsuRoIgLUh" +
       "z/iY4U01TafwgnRKF9GonkuMgPPpOSCtN8AFLeFrVYSirU2q7KA5luJkbphu" +
       "SA4BVZMwBLJwMitMJiTBLs0L7VJgf97buOqW6/X1epREYM0Zpmi4/hZg6gox" +
       "DbMssxjEgWRsXZa8k85+5ECUECCeFSKWND/76qkrL+w68aSkmV+BZlN6O1N4" +
       "SjmannFyQf/SK+pwGY2mYau4+SWaiygbckZ6iyYgzWxPIg7G3cETw7+59oZj" +
       "7J0oaR4gMcXQCnnwow7FyJuqxqyrmM4syllmgDQxPdMvxgdIA/STqs7k203Z" +
       "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" +
       "8J8X/gcU/+MK8B8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/otX/7g8mv6/sSBbxu0rAAA=");
}
