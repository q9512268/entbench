package org.apache.batik.ext.awt.image.renderable;
public class RedRable extends org.apache.batik.ext.awt.image.renderable.AbstractRable {
    org.apache.batik.ext.awt.image.rendered.CachableRed src;
    public RedRable(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        super(
          (org.apache.batik.ext.awt.image.renderable.Filter)
            null);
        this.
          src =
          src;
    }
    public org.apache.batik.ext.awt.image.rendered.CachableRed getSource() {
        return src;
    }
    public java.lang.Object getProperty(java.lang.String name) { return src.
                                                                   getProperty(
                                                                     name);
    }
    public java.lang.String[] getPropertyNames() { return src.getPropertyNames(
                                                                ); }
    public java.awt.geom.Rectangle2D getBounds2D() { return getSource().getBounds(
                                                                          );
    }
    public java.awt.image.RenderedImage createDefaultRendering() {
        return getSource(
                 );
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
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
        java.awt.Rectangle aoiR;
        if (aoi !=
              null)
            aoiR =
              aoi.
                getBounds(
                  );
        else
            aoiR =
              getBounds2D(
                ).
                getBounds(
                  );
        java.awt.geom.AffineTransform at =
          rc.
          getTransform(
            );
        org.apache.batik.ext.awt.image.rendered.CachableRed cr =
          getSource(
            );
        if (!aoiR.
              intersects(
                cr.
                  getBounds(
                    )))
            return null;
        if (at.
              isIdentity(
                )) {
            return cr;
        }
        if (at.
              getScaleX(
                ) ==
              1.0 &&
              at.
              getScaleY(
                ) ==
              1.0 &&
              at.
              getShearX(
                ) ==
              0.0 &&
              at.
              getShearY(
                ) ==
              0.0) {
            int xloc =
              (int)
                (cr.
                   getMinX(
                     ) +
                   at.
                   getTranslateX(
                     ));
            int yloc =
              (int)
                (cr.
                   getMinY(
                     ) +
                   at.
                   getTranslateY(
                     ));
            double dx =
              xloc -
              (cr.
                 getMinX(
                   ) +
                 at.
                 getTranslateX(
                   ));
            double dy =
              yloc -
              (cr.
                 getMinY(
                   ) +
                 at.
                 getTranslateY(
                   ));
            if (dx >
                  -1.0E-4 &&
                  dx <
                  1.0E-4 &&
                  (dy >
                     -1.0E-4 &&
                     dy <
                     1.0E-4)) {
                return new org.apache.batik.ext.awt.image.rendered.TranslateRed(
                  cr,
                  xloc,
                  yloc);
            }
        }
        return new org.apache.batik.ext.awt.image.rendered.AffineRed(
          cr,
          at,
          rh);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "yOSDyB2p4V3s1f4XovZArgwgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "svvH7/iH7/u1V75eHkD/P0zPaEnHKwAA");
}
