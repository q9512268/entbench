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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVXbWwcxRmeu7Md27Fz/kicEBLHMQ6Vk+i2IVA1cgokF7u5" +
           "cLZPcRKJS8kxtzt3t/He7np21j6b8lWpIv2DojZAQMK/jJAQX0Kg9kdBrpCA" +
           "irYSNGpLK0J/UrVRiZDgR1rgnZnd2709u/zqSbe3N/POO+/H8z7vzIvXUKtD" +
           "0SAxWYot2sRJjZssh6lDtLSBHecUjBXUpxL483OfTh2Ko7Y82lTBzqSKHTKh" +
           "E0Nz8minbjoMmypxpgjR+IocJQ6h85jplplHW3QnU7UNXdXZpKURLnAG0yzq" +
           "xYxRvegykvEUMLQzC5YowhLlSHR6LIu6VMteDMS3hcTToRkuWQ32chjqyZ7H" +
           "81hxmW4oWd1hYzWK9tmWsVg2LJYiNZY6b9zhheBE9o6mEAy/mvzixsVKjwhB" +
           "PzZNiwn3nJPEsYx5omVRMhgdN0jVmUMPoUQWbQwJMzSS9TdVYFMFNvW9DaTA" +
           "+m5iutW0JdxhvqY2W+UGMbS7UYmNKa56anLCZtDQzjzfxWLwdqjurfSyycUn" +
           "9imXnjrX81oCJfMoqZsz3BwVjGCwSR4CSqpFQp0jmka0POo1IdkzhOrY0Je8" +
           "TPc5etnEzIX0+2Hhg65NqNgziBXkEXyjrsosWnevJADl/WstGbgMvg4EvkoP" +
           "J/g4ONipg2G0hAF33pKWWd3UGNoVXVH3ceQeEIClG6qEVaz6Vi0mhgHUJyFi" +
           "YLOszAD0zDKItloAQMrQ9nWV8ljbWJ3FZVLgiIzI5eQUSHWIQPAlDG2JiglN" +
           "kKXtkSyF8nNt6vDjD5jHzTiKgc0aUQ1u/0ZYNBhZdJKUCCVQB3Jh197sk3jg" +
           "zQtxhEB4S0RYyvzyx9fv3j+4+p6UuXkNmenieaKygrpS3PTBjvTooQQ3o922" +
           "HJ0nv8FzUWU5b2asZgPDDNQ18smUP7l68p17H3mB/DOOOjOoTbUMtwo46lWt" +
           "qq0bhP6QmIRiRrQM6iCmlhbzGbQB3rO6SeTodKnkEJZBLYYYarPEfwhRCVTw" +
           "EHXCu26WLP/dxqwi3ms2QqgFvqgDodgQEh/5y9BppWJViYJVbOqmpeSoxf13" +
           "FGCcIsS2ohQB9bOKY7kUIKhYtKxgwEGFeBPleaactjWw/hQFDBCa4vCy/1+K" +
           "a9yj/oVYDIK9I1rqBlTJccvQCC2ol9yj49dfLrwvYcSh78WCoRTslZJ7pcRe" +
           "Kdgr1bDXSLpilmeoehJMRrGY2G4z31/mFbIyC/UNBNs1OnPfifsvDCcAUPYC" +
           "DzIXHW5oNOmABHzmLqiv9HUv7b564O04asmiPqwyFxu8bxyhZWAkddYr2q4i" +
           "tKCgEwyFOgFvYdRSiQZEtF5H8LS0W/OE8nGGNoc0+H2KV6SyfpdY0360ennh" +
           "0TMPfzeO4o3kz7dsBd7iy3OcsuvUPBIt+rX0Jh/79ItXnnzQCsq/oZv4TbBp" +
           "JfdhOAqIaHgK6t4h/EbhzQdHRNg7gJ4ZhnIC5huM7tHALmM+U3Nf2sHhkkWr" +
           "2OBTfow7WYVaC8GIQGqveN8MsGjn5dYP8Njt1Z/45bMDNn9ulcjmOIt4ITrB" +
           "D2bsZ//yh38cFOH2m0Yy1O1nCBsLERVX1icoqTeA7SlKCMh9fDn3iyeuPXZW" +
           "YBYkbllrwxH+TANBQQohzD99b+6jT66uXInXcY5qjb61/w/fYJNbAzOA3wyo" +
           "Kw6WkdMmwFIv6bhoEF5P/0nuOfDGvx7vkek3YMRHz/5vVxCM33QUPfL+uS8H" +
           "hZqYyvtrEKpATJJ2f6D5CKV4kdtRe/TDnU+/i58F+gfKdfQlIlg05pU4N2ob" +
           "QzeJlXiBpcrEqqY4W0BbNchtx0Q2bxdyinge5CHxAsf/f58/9jjhqmgsvNBJ" +
           "qaBevPJZ95nP3rou/Gk8aoVBMIntMYk7/ri1Buq3RlnrOHYqIHf76tSPeozV" +
           "G6AxDxpV4GBnmgJ11hog40m3bvjrb94euP+DBIpPoE7DwtoEFtWHOgD2xKkA" +
           "69bsu+6W+V/ggOgRrqIm55sGeAp2rZ3c8arNRDqWfrX19cPPL18V8LOljpvD" +
           "Cr/DH/vqiBQzLdFuF0ZkgwaKdq53IBGHqZWfXFrWpp87II8NfY1NfhzOsC/9" +
           "6b+/S13++2/X6DZt3oEyvCFDG0MNxkfT8Lf3JbB0W9MBVx7K1JeXk+1bl0//" +
           "WVBb/eDUBaRQcg2jblPYPn7YpqSkC8x0SeTY4icHnWItcxhKwFNYPC0lZ+DW" +
           "EZVkqFX8huXOMNQZyEFc5EtY5F7QDiL8NW/7Udm1bo0BRVmY1WLNaDjEH1vk" +
           "++F1URlK/y0NRShuGl54J11514COvXxi6oHr33tOUjDcUZaWxMkUDtqyG9Qb" +
           "3e51tfm62o6P3tj0aseeuMcGvdJg2QLCtvH3o4Bfm1fJ9ghROSN1vvpo5fBb" +
           "v7/Q9iEA8CyKYYb6z4bO+fJQC2znAtLPZoPTSeimKhh0bPSZxTv3l/79N1Fo" +
           "3mlmx/ryBfXK8/f98efbVoBpN2ZQK9QKqeXh0uIcWzQhVfM0j7p1Z7wGJoIW" +
           "uEVlULtr6nMuycD9aBNHKeZ3EBEXL5zd9VHewKEumi4baxx7gJQWCD1quabG" +
           "1XQDTQYjDVcgD/mdrm1HFgQj9VRubva9oB77WfLXF/sSE1BpDe6E1W9w3CKX" +
           "9nQHtyIxIPLaI+nqa/jE4PsV//Kk8wF5OO9LezeEofoVAdhPziUK2Unb9mU7" +
           "R21ZMaLozRofh5PrXm/0YNC7+N85sb9gwjn+cL4BoLe+RiERAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "IC6u4LI/fNPvv+O3X/xWcV7/X+aBIeInHAAA");
    }
    public void clear() { dirtyNodes = null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "TzR2fLflT3yg9dWwV/pW+18l3+XwKyEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
