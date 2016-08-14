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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
