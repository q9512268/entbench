package org.apache.batik.ext.awt.image.renderable;
public abstract class AbstractRable implements org.apache.batik.ext.awt.image.renderable.Filter {
    protected java.util.Vector srcs;
    protected java.util.Map props = new java.util.HashMap();
    protected long stamp = 0;
    protected AbstractRable() { super();
                                srcs = new java.util.Vector(); }
    protected AbstractRable(org.apache.batik.ext.awt.image.renderable.Filter src) {
        super(
          );
        init(
          src,
          null);
    }
    protected AbstractRable(org.apache.batik.ext.awt.image.renderable.Filter src,
                            java.util.Map props) { super(
                                                     );
                                                   init(src,
                                                        props);
    }
    protected AbstractRable(java.util.List srcs) { this(srcs,
                                                        null);
    }
    protected AbstractRable(java.util.List srcs, java.util.Map props) {
        super(
          );
        init(
          srcs,
          props);
    }
    public final void touch() { stamp++; }
    public long getTimeStamp() { return stamp; }
    protected void init(org.apache.batik.ext.awt.image.renderable.Filter src) {
        touch(
          );
        this.
          srcs =
          new java.util.Vector(
            1);
        if (src !=
              null) {
            this.
              srcs.
              add(
                src);
        }
    }
    protected void init(org.apache.batik.ext.awt.image.renderable.Filter src,
                        java.util.Map props) { init(src);
                                               if (props !=
                                                     null) {
                                                   this.
                                                     props.
                                                     putAll(
                                                       props);
                                               } }
    protected void init(java.util.List srcs) { touch();
                                               this.srcs =
                                                 new java.util.Vector(
                                                   srcs);
    }
    protected void init(java.util.List srcs, java.util.Map props) {
        init(
          srcs);
        if (props !=
              null)
            this.
              props.
              putAll(
                props);
    }
    public java.awt.geom.Rectangle2D getBounds2D() { java.awt.geom.Rectangle2D bounds =
                                                       null;
                                                     if (this.
                                                           srcs.
                                                           size(
                                                             ) !=
                                                           0) {
                                                         java.util.Iterator i =
                                                           srcs.
                                                           iterator(
                                                             );
                                                         org.apache.batik.ext.awt.image.renderable.Filter src =
                                                           (org.apache.batik.ext.awt.image.renderable.Filter)
                                                             i.
                                                             next(
                                                               );
                                                         bounds =
                                                           (java.awt.geom.Rectangle2D)
                                                             src.
                                                             getBounds2D(
                                                               ).
                                                             clone(
                                                               );
                                                         java.awt.geom.Rectangle2D r;
                                                         while (i.
                                                                  hasNext(
                                                                    )) {
                                                             src =
                                                               (org.apache.batik.ext.awt.image.renderable.Filter)
                                                                 i.
                                                                 next(
                                                                   );
                                                             r =
                                                               src.
                                                                 getBounds2D(
                                                                   );
                                                             java.awt.geom.Rectangle2D.
                                                               union(
                                                                 bounds,
                                                                 r,
                                                                 bounds);
                                                         }
                                                     }
                                                     return bounds;
    }
    public java.util.Vector getSources() {
        return srcs;
    }
    public java.awt.image.RenderedImage createDefaultRendering() {
        return createScaledRendering(
                 100,
                 100,
                 null);
    }
    public java.awt.image.RenderedImage createScaledRendering(int w,
                                                              int h,
                                                              java.awt.RenderingHints hints) {
        float sX =
          w /
          getWidth(
            );
        float sY =
          h /
          getHeight(
            );
        float scale =
          java.lang.Math.
          min(
            sX,
            sY);
        java.awt.geom.AffineTransform at =
          java.awt.geom.AffineTransform.
          getScaleInstance(
            scale,
            scale);
        java.awt.image.renderable.RenderContext rc =
          new java.awt.image.renderable.RenderContext(
          at,
          hints);
        float dX =
          getWidth(
            ) *
          scale -
          w;
        float dY =
          getHeight(
            ) *
          scale -
          h;
        java.awt.image.RenderedImage ri =
          createRendering(
            rc);
        org.apache.batik.ext.awt.image.rendered.CachableRed cr =
          org.apache.batik.ext.awt.image.rendered.RenderedImageCachableRed.
          wrap(
            ri);
        return new org.apache.batik.ext.awt.image.rendered.PadRed(
          cr,
          new java.awt.Rectangle(
            (int)
              (dX /
                 2),
            (int)
              (dY /
                 2),
            w,
            h),
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD,
          null);
    }
    public float getMinX() { return (float)
                                      getBounds2D(
                                        ).
                                      getX(
                                        );
    }
    public float getMinY() { return (float)
                                      getBounds2D(
                                        ).
                                      getY(
                                        );
    }
    public float getWidth() { return (float)
                                       getBounds2D(
                                         ).
                                       getWidth(
                                         );
    }
    public float getHeight() { return (float)
                                        getBounds2D(
                                          ).
                                        getHeight(
                                          );
    }
    public java.lang.Object getProperty(java.lang.String name) {
        java.lang.Object ret =
          props.
          get(
            name);
        if (ret !=
              null)
            return ret;
        java.util.Iterator i =
          srcs.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            java.awt.image.renderable.RenderableImage ri =
              (java.awt.image.renderable.RenderableImage)
                i.
                next(
                  );
            ret =
              ri.
                getProperty(
                  name);
            if (ret !=
                  null)
                return ret;
        }
        return null;
    }
    public java.lang.String[] getPropertyNames() {
        java.util.Set keys =
          props.
          keySet(
            );
        java.util.Iterator iter =
          keys.
          iterator(
            );
        java.lang.String[] ret =
          new java.lang.String[keys.
                                 size(
                                   )];
        int i =
          0;
        while (iter.
                 hasNext(
                   )) {
            ret[i++] =
              (java.lang.String)
                iter.
                next(
                  );
        }
        iter =
          srcs.
            iterator(
              );
        while (iter.
                 hasNext(
                   )) {
            java.awt.image.renderable.RenderableImage ri =
              (java.awt.image.renderable.RenderableImage)
                iter.
                next(
                  );
            java.lang.String[] srcProps =
              ri.
              getPropertyNames(
                );
            if (srcProps.
                  length !=
                  0) {
                java.lang.String[] tmp =
                  new java.lang.String[ret.
                                         length +
                                         srcProps.
                                           length];
                java.lang.System.
                  arraycopy(
                    ret,
                    0,
                    tmp,
                    0,
                    ret.
                      length);
                java.lang.System.
                  arraycopy(
                    tmp,
                    ret.
                      length,
                    srcProps,
                    0,
                    srcProps.
                      length);
                ret =
                  tmp;
            }
        }
        return ret;
    }
    public boolean isDynamic() { return false;
    }
    public java.awt.Shape getDependencyRegion(int srcIndex,
                                              java.awt.geom.Rectangle2D outputRgn) {
        if (srcIndex <
              0 ||
              srcIndex >
              srcs.
              size(
                ))
            throw new java.lang.IndexOutOfBoundsException(
              "Nonexistant source requested.");
        java.awt.geom.Rectangle2D srect =
          (java.awt.geom.Rectangle2D)
            outputRgn.
            clone(
              );
        java.awt.geom.Rectangle2D bounds =
          getBounds2D(
            );
        if (!bounds.
              intersects(
                srect))
            return new java.awt.geom.Rectangle2D.Float(
              );
        java.awt.geom.Rectangle2D.
          intersect(
            srect,
            bounds,
            srect);
        return srect;
    }
    public java.awt.Shape getDirtyRegion(int srcIndex,
                                         java.awt.geom.Rectangle2D inputRgn) {
        if (srcIndex <
              0 ||
              srcIndex >
              srcs.
              size(
                ))
            throw new java.lang.IndexOutOfBoundsException(
              "Nonexistant source requested.");
        java.awt.geom.Rectangle2D drect =
          (java.awt.geom.Rectangle2D)
            inputRgn.
            clone(
              );
        java.awt.geom.Rectangle2D bounds =
          getBounds2D(
            );
        if (!bounds.
              intersects(
                drect))
            return new java.awt.geom.Rectangle2D.Float(
              );
        java.awt.geom.Rectangle2D.
          intersect(
            drect,
            bounds,
            drect);
        return drect;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "XcJf8W3pfwCz3bt9CzgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rYmt6nZnwHVXy+FcdjWJw4jukqaUvp4E");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "haffeO7cuScef9RxckI+dlzm8u/sBOHeh/cPzu599OR+vGCtIihca8iWujUf" +
       "VBb8Qyc+rP+olw8k886dZLYM25Kz+zoHaduLjrp97vCqNEiMT6T0M1tK88Yu" +
       "S9w+dUra72bBb4PhTMwo3QI7Jfu/2FegXM1+7TLU7M4sErjJe7fsi8YtV17N" +
       "Pn1K2h9kwe8D26n7eGLxpi6eNMhfJ9i2IfPWDvO/utzx4mFA/m37mG+7Mph3" +
       "6xFb0XwkR/ilU9B/OQv+LZBUYGRw2clcOEtMaFk9WIA8vHmTuYlTjXeO+L9f" +
       "uFwWPAjQPLTPgof+X7LghVNY8OdZ8B8BzIwFOjCyW/RZ7B/vsP6nS7rkEhRu" +
       "Pu92c3bY/p4L/s3C9l8DiJ949tbr7352/u+3Jvfg+v4NVOF6JTSMo5c+jrxf" +
       "63iyoucsuGF7BSS3dXvfCAqP/th3B4NsnffgI0Ox9/VtLX8VFB44vRZgKPSD" +
       "2dBBqf8WFO65WCkw/QDh0dz/HdjAk3KDnCA8mvN7YBA8nhO0n/8ezfcDgGeX" +
       "D1jq7cvRLD8EtYMs2etf53b/ffHWxt5zVEzzVaQ7XqzHD4scvY+cwc3/7cbB" +
       "0nw43r+Y+Mlne8Of+271I9v70KLBp2lWy/Vg6Nxezd4fOo9fcjxa20Fd13Yf" +
       "/eEtv3XDIwdbEbdsCd6pzBHaHjz55jFhOkF+Vzj9Z3f/k5/+6LN/lp/w/z/S" +
       "TZ/pD0UAAA==");
}
