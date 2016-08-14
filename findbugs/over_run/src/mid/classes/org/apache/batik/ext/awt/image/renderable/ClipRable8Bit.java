package org.apache.batik.ext.awt.image.renderable;
public class ClipRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable implements org.apache.batik.ext.awt.image.renderable.ClipRable {
    protected boolean useAA;
    protected java.awt.Shape clipPath;
    public ClipRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                         java.awt.Shape clipPath) { super(src, null);
                                                    setClipPath(clipPath);
                                                    setUseAntialiasedClip(
                                                      false); }
    public ClipRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                         java.awt.Shape clipPath,
                         boolean useAA) { super(src, null);
                                          setClipPath(clipPath);
                                          setUseAntialiasedClip(useAA); }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public void setUseAntialiasedClip(boolean useAA) { touch();
                                                       this.useAA =
                                                         useAA; }
    public boolean getUseAntialiasedClip() { return useAA; }
    public void setClipPath(java.awt.Shape clipPath) { touch();
                                                       this.clipPath =
                                                         clipPath;
    }
    public java.awt.Shape getClipPath() { return clipPath; }
    public java.awt.geom.Rectangle2D getBounds2D() { return getSource(
                                                              ).getBounds2D(
                                                                  );
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.geom.AffineTransform usr2dev =
          rc.
          getTransform(
            );
        java.awt.RenderingHints rh =
          rc.
          getRenderingHints(
            );
        if (rh ==
              null)
            rh =
              new java.awt.RenderingHints(
                null);
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        if (aoi ==
              null)
            aoi =
              getBounds2D(
                );
        java.awt.geom.Rectangle2D rect =
          getBounds2D(
            );
        java.awt.geom.Rectangle2D clipRect =
          clipPath.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D aoiRect =
          aoi.
          getBounds2D(
            );
        if (!rect.
              intersects(
                clipRect))
            return null;
        java.awt.geom.Rectangle2D.
          intersect(
            rect,
            clipRect,
            rect);
        if (!rect.
              intersects(
                aoiRect))
            return null;
        java.awt.geom.Rectangle2D.
          intersect(
            rect,
            aoi.
              getBounds2D(
                ),
            rect);
        java.awt.Rectangle devR =
          usr2dev.
          createTransformedShape(
            rect).
          getBounds(
            );
        if (devR.
              width ==
              0 ||
              devR.
                height ==
              0)
            return null;
        java.awt.image.BufferedImage bi =
          new java.awt.image.BufferedImage(
          devR.
            width,
          devR.
            height,
          java.awt.image.BufferedImage.
            TYPE_BYTE_GRAY);
        java.awt.Shape devShape =
          usr2dev.
          createTransformedShape(
            getClipPath(
              ));
        java.awt.Rectangle devAOIR;
        devAOIR =
          usr2dev.
            createTransformedShape(
              aoi).
            getBounds(
              );
        java.awt.Graphics2D g2d =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          createGraphics(
            bi,
            rh);
        if (false) {
            java.util.Set s =
              rh.
              keySet(
                );
            java.util.Iterator i =
              s.
              iterator(
                );
            while (i.
                     hasNext(
                       )) {
                java.lang.Object o =
                  i.
                  next(
                    );
                java.lang.System.
                  out.
                  println(
                    "XXX: " +
                    o +
                    " -> " +
                    rh.
                      get(
                        o));
            }
        }
        g2d.
          translate(
            -devR.
               x,
            -devR.
               y);
        g2d.
          setPaint(
            java.awt.Color.
              white);
        g2d.
          fill(
            devShape);
        g2d.
          dispose(
            );
        java.awt.image.RenderedImage ri;
        ri =
          getSource(
            ).
            createRendering(
              new java.awt.image.renderable.RenderContext(
                usr2dev,
                rect,
                rh));
        org.apache.batik.ext.awt.image.rendered.CachableRed cr;
        org.apache.batik.ext.awt.image.rendered.CachableRed clipCr;
        cr =
          org.apache.batik.ext.awt.image.rendered.RenderedImageCachableRed.
            wrap(
              ri);
        clipCr =
          new org.apache.batik.ext.awt.image.rendered.BufferedImageCachableRed(
            bi,
            devR.
              x,
            devR.
              y);
        org.apache.batik.ext.awt.image.rendered.CachableRed ret =
          new org.apache.batik.ext.awt.image.rendered.MultiplyAlphaRed(
          cr,
          clipCr);
        ret =
          new org.apache.batik.ext.awt.image.rendered.PadRed(
            ret,
            devAOIR,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD,
            rh);
        return ret;
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
       "k/Kj598BTeRcAQ4tAAA=");
}
