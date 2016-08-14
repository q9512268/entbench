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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "NfmvFHD8kr/icOI/1pHVweAfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "udvBqlhZPJOejafn1Xtmyntb+9Tv/vFbpD/+lW9UPZ6fM58NH6wSHfTzaFm8" +
       "uxT3nReTB6mkawDXfn3yl294r38TUJQBRQ2kzJRLQDLangs2R9APPvTv/sk/" +
       "e8eHv3yldnlUu+aFij5SqrhdewQETCNdg1S4jX7ogwe3LB4GxY1K1Nodwh98" +
       "9Inq7YH7u9eonPKeRv0n/gfnqR/9/T+7QwlVsrqLx13Al6FXP/sk+oN/VOGf" +
       "Zo0S++ntnTkeLA9OcVtf8P/k8nNX//nl2kNy7YZ2tPaQFC8vY7EM5tvp8YIE" +
       "rE/OfT8/dz5MFF88yYrvuujyZ7q9mK9OXQ3US+iyfu1Cinq01PKz4OkcBYnO" +
       "xSBxqVZV+Arl2aq8WRbff5wRHomSMANcGnpF+wNZ7YEkP8wWkUN+K0u8LISD" +
       "Ocl7mp6tKGwvAbIPtm4htxrlu3z3rq+U1R8AGSmtFlcAw7QDxTtm4p2Op908" +
       "HtYSWGwB2990POQ4sN2o3LbU8q3DCuUCrx/4lnkFbvnoKTEmBIudT/znT/3W" +
       "T7znq8B3qNqDm9KuwGXO9DjJy/Xfj7/66afe9PLXPlElWKBL6W/8ffjPSqrG" +
       "/SQuiw+Vxe1jUZ8sRRWqmSyjpBlb5URDP5G2f0aeHwLm8cLvQNrs+r8k2+l4" +
       "cPzHNGS0M5hvVWmD9DZD0wwgzLGmuxlpoG6IY+1mAackRfr7vEdH2pqYtLKN" +
       "nucTX9YUFVYdF6Ndj17Zi/lc4m1aluYrCcVWnru1zZG4oBSoETmo2OdXoUeA" +
       "aTyxmEcrdyTTqz4SBbqDIAOZsSQX3qhTHUn6fQRSu/31vu11ZJnyY4doZeuW" +
       "1YyygI8ZIZZH+LYFSlddLTqDTTyZ132G4evZco2vR85kxgmSMmVGfkPojuIi" +
       "jPnWKvLZuS/G6sJoWLzN4814vpzgqzDOt9ra3RoRRyihTXe3pNgc4F3KZFHC" +
       "nxEYJxlUwqtROhgjrFPg/krbUsZI2uZOZ0ClfifVe0RgaANkiqZjf8nA6dqO" +
       "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");
}
