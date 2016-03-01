package org.apache.batik.gvt;
public class UpdateTracker extends org.apache.batik.gvt.event.GraphicsNodeChangeAdapter {
    java.util.Map dirtyNodes = null;
    java.util.Map fromBounds = new java.util.HashMap();
    protected static java.awt.geom.Rectangle2D NULL_RECT = new java.awt.Rectangle(
      );
    public UpdateTracker() { super(); }
    public boolean hasChanged() { return dirtyNodes != null; }
    public java.util.List getDirtyAreas() { if (dirtyNodes == null)
                                                return null;
                                            java.util.List ret = new java.util.LinkedList(
                                              );
                                            java.util.Set keys =
                                              dirtyNodes.
                                              keySet(
                                                );
                                            java.util.Iterator i =
                                              keys.
                                              iterator(
                                                );
                                            while (i.hasNext(
                                                       )) {
                                                java.lang.ref.WeakReference gnWRef =
                                                  (java.lang.ref.WeakReference)
                                                    i.
                                                    next(
                                                      );
                                                org.apache.batik.gvt.GraphicsNode gn =
                                                  (org.apache.batik.gvt.GraphicsNode)
                                                    gnWRef.
                                                    get(
                                                      );
                                                if (gn ==
                                                      null)
                                                    continue;
                                                java.awt.geom.AffineTransform oat;
                                                oat =
                                                  (java.awt.geom.AffineTransform)
                                                    dirtyNodes.
                                                    get(
                                                      gnWRef);
                                                if (oat !=
                                                      null) {
                                                    oat =
                                                      new java.awt.geom.AffineTransform(
                                                        oat);
                                                }
                                                java.awt.geom.Rectangle2D srcORgn =
                                                  (java.awt.geom.Rectangle2D)
                                                    fromBounds.
                                                    remove(
                                                      gnWRef);
                                                java.awt.geom.Rectangle2D srcNRgn =
                                                  null;
                                                java.awt.geom.AffineTransform nat =
                                                  null;
                                                if (!(srcORgn instanceof org.apache.batik.gvt.UpdateTracker.ChngSrcRect)) {
                                                    srcNRgn =
                                                      gn.
                                                        getBounds(
                                                          );
                                                    nat =
                                                      gn.
                                                        getTransform(
                                                          );
                                                    if (nat !=
                                                          null)
                                                        nat =
                                                          new java.awt.geom.AffineTransform(
                                                            nat);
                                                }
                                                do  {
                                                    gn =
                                                      gn.
                                                        getParent(
                                                          );
                                                    if (gn ==
                                                          null)
                                                        break;
                                                    org.apache.batik.ext.awt.image.renderable.Filter f =
                                                      gn.
                                                      getFilter(
                                                        );
                                                    if (f !=
                                                          null) {
                                                        srcNRgn =
                                                          f.
                                                            getBounds2D(
                                                              );
                                                        nat =
                                                          null;
                                                    }
                                                    java.awt.geom.AffineTransform at =
                                                      gn.
                                                      getTransform(
                                                        );
                                                    gnWRef =
                                                      gn.
                                                        getWeakReference(
                                                          );
                                                    java.awt.geom.AffineTransform poat =
                                                      (java.awt.geom.AffineTransform)
                                                        dirtyNodes.
                                                        get(
                                                          gnWRef);
                                                    if (poat ==
                                                          null)
                                                        poat =
                                                          at;
                                                    if (poat !=
                                                          null) {
                                                        if (oat !=
                                                              null)
                                                            oat.
                                                              preConcatenate(
                                                                poat);
                                                        else
                                                            oat =
                                                              new java.awt.geom.AffineTransform(
                                                                poat);
                                                    }
                                                    if (at !=
                                                          null) {
                                                        if (nat !=
                                                              null)
                                                            nat.
                                                              preConcatenate(
                                                                at);
                                                        else
                                                            nat =
                                                              new java.awt.geom.AffineTransform(
                                                                at);
                                                    }
                                                }while(true); 
                                                if (gn ==
                                                      null) {
                                                    java.awt.Shape oRgn =
                                                      srcORgn;
                                                    if (oRgn !=
                                                          null &&
                                                          oRgn !=
                                                          NULL_RECT) {
                                                        if (oat !=
                                                              null)
                                                            oRgn =
                                                              oat.
                                                                createTransformedShape(
                                                                  srcORgn);
                                                        ret.
                                                          add(
                                                            oRgn);
                                                    }
                                                    if (srcNRgn !=
                                                          null) {
                                                        java.awt.Shape nRgn =
                                                          srcNRgn;
                                                        if (nat !=
                                                              null)
                                                            nRgn =
                                                              nat.
                                                                createTransformedShape(
                                                                  srcNRgn);
                                                        if (nRgn !=
                                                              null)
                                                            ret.
                                                              add(
                                                                nRgn);
                                                    }
                                                }
                                            }
                                            fromBounds.
                                              clear(
                                                );
                                            dirtyNodes.
                                              clear(
                                                );
                                            return ret;
    }
    public java.awt.geom.Rectangle2D getNodeDirtyRegion(org.apache.batik.gvt.GraphicsNode gn,
                                                        java.awt.geom.AffineTransform at) {
        java.lang.ref.WeakReference gnWRef =
          gn.
          getWeakReference(
            );
        java.awt.geom.AffineTransform nat =
          (java.awt.geom.AffineTransform)
            dirtyNodes.
            get(
              gnWRef);
        if (nat ==
              null)
            nat =
              gn.
                getTransform(
                  );
        if (nat !=
              null) {
            at =
              new java.awt.geom.AffineTransform(
                at);
            at.
              concatenate(
                nat);
        }
        org.apache.batik.ext.awt.image.renderable.Filter f =
          gn.
          getFilter(
            );
        java.awt.geom.Rectangle2D ret =
          null;
        if (gn instanceof org.apache.batik.gvt.CompositeGraphicsNode) {
            org.apache.batik.gvt.CompositeGraphicsNode cgn =
              (org.apache.batik.gvt.CompositeGraphicsNode)
                gn;
            java.util.Iterator iter =
              cgn.
              iterator(
                );
            while (iter.
                     hasNext(
                       )) {
                org.apache.batik.gvt.GraphicsNode childGN =
                  (org.apache.batik.gvt.GraphicsNode)
                    iter.
                    next(
                      );
                java.awt.geom.Rectangle2D r2d =
                  getNodeDirtyRegion(
                    childGN,
                    at);
                if (r2d !=
                      null) {
                    if (f !=
                          null) {
                        java.awt.Shape s =
                          at.
                          createTransformedShape(
                            f.
                              getBounds2D(
                                ));
                        ret =
                          s.
                            getBounds2D(
                              );
                        break;
                    }
                    if (ret ==
                          null ||
                          ret ==
                          NULL_RECT)
                        ret =
                          r2d;
                    else
                        ret.
                          add(
                            r2d);
                }
            }
        }
        else {
            ret =
              (java.awt.geom.Rectangle2D)
                fromBounds.
                remove(
                  gnWRef);
            if (ret ==
                  null) {
                if (f !=
                      null)
                    ret =
                      f.
                        getBounds2D(
                          );
                else
                    ret =
                      gn.
                        getBounds(
                          );
            }
            else
                if (ret ==
                      NULL_RECT)
                    ret =
                      null;
            if (ret !=
                  null)
                ret =
                  at.
                    createTransformedShape(
                      ret).
                    getBounds2D(
                      );
        }
        return ret;
    }
    public java.awt.geom.Rectangle2D getNodeDirtyRegion(org.apache.batik.gvt.GraphicsNode gn) {
        return getNodeDirtyRegion(
                 gn,
                 new java.awt.geom.AffineTransform(
                   ));
    }
    public void changeStarted(org.apache.batik.gvt.event.GraphicsNodeChangeEvent gnce) {
        org.apache.batik.gvt.GraphicsNode gn =
          gnce.
          getGraphicsNode(
            );
        java.lang.ref.WeakReference gnWRef =
          gn.
          getWeakReference(
            );
        boolean doPut =
          false;
        if (dirtyNodes ==
              null) {
            dirtyNodes =
              new java.util.HashMap(
                );
            doPut =
              true;
        }
        else
            if (!dirtyNodes.
                  containsKey(
                    gnWRef))
                doPut =
                  true;
        if (doPut) {
            java.awt.geom.AffineTransform at =
              gn.
              getTransform(
                );
            if (at !=
                  null)
                at =
                  (java.awt.geom.AffineTransform)
                    at.
                    clone(
                      );
            else
                at =
                  new java.awt.geom.AffineTransform(
                    );
            dirtyNodes.
              put(
                gnWRef,
                at);
        }
        org.apache.batik.gvt.GraphicsNode chngSrc =
          gnce.
          getChangeSrc(
            );
        java.awt.geom.Rectangle2D rgn =
          null;
        if (chngSrc !=
              null) {
            java.awt.geom.Rectangle2D drgn =
              getNodeDirtyRegion(
                chngSrc);
            if (drgn !=
                  null)
                rgn =
                  new org.apache.batik.gvt.UpdateTracker.ChngSrcRect(
                    drgn);
        }
        else {
            rgn =
              gn.
                getBounds(
                  );
        }
        java.awt.geom.Rectangle2D r2d =
          (java.awt.geom.Rectangle2D)
            fromBounds.
            remove(
              gnWRef);
        if (rgn !=
              null) {
            if (r2d !=
                  null &&
                  r2d !=
                  NULL_RECT) {
                r2d.
                  add(
                    rgn);
            }
            else
                r2d =
                  rgn;
        }
        if (r2d ==
              null)
            r2d =
              NULL_RECT;
        fromBounds.
          put(
            gnWRef,
            r2d);
    }
    class ChngSrcRect extends java.awt.geom.Rectangle2D.Float {
        ChngSrcRect(java.awt.geom.Rectangle2D r2d) {
            super(
              (float)
                r2d.
                getX(
                  ),
              (float)
                r2d.
                getY(
                  ),
              (float)
                r2d.
                getWidth(
                  ),
              (float)
                r2d.
                getHeight(
                  ));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public void clear() { dirtyNodes = null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3y2PBf8fhJ8dmX0rAAA=");
}
