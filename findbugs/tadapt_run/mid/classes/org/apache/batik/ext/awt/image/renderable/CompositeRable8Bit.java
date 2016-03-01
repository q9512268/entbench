package org.apache.batik.ext.awt.image.renderable;
public class CompositeRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.CompositeRable, org.apache.batik.ext.awt.image.renderable.PaintRable {
    protected org.apache.batik.ext.awt.image.CompositeRule rule;
    public CompositeRable8Bit(java.util.List srcs, org.apache.batik.ext.awt.image.CompositeRule rule,
                              boolean csIsLinear) { super(srcs);
                                                    setColorSpaceLinear(
                                                      csIsLinear);
                                                    this.rule = rule;
    }
    public void setSources(java.util.List srcs) { init(srcs, null);
    }
    public void setCompositeRule(org.apache.batik.ext.awt.image.CompositeRule cr) {
        touch(
          );
        this.
          rule =
          cr;
    }
    public org.apache.batik.ext.awt.image.CompositeRule getCompositeRule() {
        return this.
                 rule;
    }
    public boolean paintRable(java.awt.Graphics2D g2d) { java.awt.Composite c =
                                                           g2d.
                                                           getComposite(
                                                             );
                                                         if (!org.apache.batik.ext.awt.image.SVGComposite.
                                                                OVER.
                                                               equals(
                                                                 c))
                                                             return false;
                                                         if (getCompositeRule(
                                                               ) !=
                                                               org.apache.batik.ext.awt.image.CompositeRule.
                                                                 OVER)
                                                             return false;
                                                         java.awt.color.ColorSpace crCS =
                                                           getOperationColorSpace(
                                                             );
                                                         java.awt.color.ColorSpace g2dCS =
                                                           org.apache.batik.ext.awt.image.GraphicsUtil.
                                                           getDestinationColorSpace(
                                                             g2d);
                                                         if (g2dCS ==
                                                               null ||
                                                               g2dCS !=
                                                               crCS) {
                                                             return false;
                                                         }
                                                         java.util.Iterator i =
                                                           getSources(
                                                             ).
                                                           iterator(
                                                             );
                                                         while (i.
                                                                  hasNext(
                                                                    )) {
                                                             org.apache.batik.ext.awt.image.GraphicsUtil.
                                                               drawImage(
                                                                 g2d,
                                                                 (org.apache.batik.ext.awt.image.renderable.Filter)
                                                                   i.
                                                                   next(
                                                                     ));
                                                         }
                                                         return true;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        if (srcs.
              size(
                ) ==
              0)
            return null;
        java.awt.RenderingHints rh =
          rc.
          getRenderingHints(
            );
        if (rh ==
              null)
            rh =
              new java.awt.RenderingHints(
                null);
        java.awt.geom.AffineTransform at =
          rc.
          getTransform(
            );
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        java.awt.geom.Rectangle2D aoiR;
        if (aoi ==
              null)
            aoiR =
              getBounds2D(
                );
        else {
            aoiR =
              aoi.
                getBounds2D(
                  );
            java.awt.geom.Rectangle2D bounds2d =
              getBounds2D(
                );
            if (!bounds2d.
                  intersects(
                    aoiR))
                return null;
            java.awt.geom.Rectangle2D.
              intersect(
                aoiR,
                bounds2d,
                aoiR);
        }
        java.awt.Rectangle devRect =
          at.
          createTransformedShape(
            aoiR).
          getBounds(
            );
        rc =
          new java.awt.image.renderable.RenderContext(
            at,
            aoiR,
            rh);
        java.util.List srcs =
          new java.util.ArrayList(
          );
        java.util.Iterator i =
          getSources(
            ).
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.renderable.Filter filt =
              (org.apache.batik.ext.awt.image.renderable.Filter)
                i.
                next(
                  );
            java.awt.image.RenderedImage ri =
              filt.
              createRendering(
                rc);
            if (ri !=
                  null) {
                org.apache.batik.ext.awt.image.rendered.CachableRed cr;
                cr =
                  convertSourceCS(
                    ri);
                srcs.
                  add(
                    cr);
            }
            else {
                switch (rule.
                          getRule(
                            )) {
                    case org.apache.batik.ext.awt.image.CompositeRule.
                           RULE_IN:
                        return null;
                    case org.apache.batik.ext.awt.image.CompositeRule.
                           RULE_OUT:
                        srcs.
                          clear(
                            );
                        break;
                    case org.apache.batik.ext.awt.image.CompositeRule.
                           RULE_ARITHMETIC:
                        srcs.
                          add(
                            new org.apache.batik.ext.awt.image.rendered.FloodRed(
                              devRect));
                        break;
                    default:
                        break;
                }
            }
        }
        if (srcs.
              size(
                ) ==
              0)
            return null;
        org.apache.batik.ext.awt.image.rendered.CachableRed cr =
          new org.apache.batik.ext.awt.image.rendered.CompositeRed(
          srcs,
          rule);
        return cr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "XMktbxjcxfwNm57/AEYD7WMvHwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
