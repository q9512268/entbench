package org.apache.batik.ext.awt.image.renderable;
public class TurbulenceRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.TurbulenceRable {
    int seed = 0;
    int numOctaves = 1;
    double baseFreqX = 0;
    double baseFreqY = 0;
    boolean stitched = false;
    boolean fractalNoise = false;
    java.awt.geom.Rectangle2D region;
    public TurbulenceRable8Bit(java.awt.geom.Rectangle2D region) { super(
                                                                     );
                                                                   this.region =
                                                                     region;
    }
    public TurbulenceRable8Bit(java.awt.geom.Rectangle2D region, int seed,
                               int numOctaves,
                               double baseFreqX,
                               double baseFreqY,
                               boolean stitched,
                               boolean fractalNoise) { super();
                                                       this.seed = seed;
                                                       this.numOctaves = numOctaves;
                                                       this.baseFreqX = baseFreqX;
                                                       this.baseFreqY = baseFreqY;
                                                       this.stitched = stitched;
                                                       this.fractalNoise =
                                                         fractalNoise;
                                                       this.region = region;
    }
    public java.awt.geom.Rectangle2D getTurbulenceRegion() { return (java.awt.geom.Rectangle2D)
                                                                      region.
                                                                      clone(
                                                                        );
    }
    public java.awt.geom.Rectangle2D getBounds2D() { return (java.awt.geom.Rectangle2D)
                                                              region.
                                                              clone(
                                                                );
    }
    public int getSeed() { return seed; }
    public int getNumOctaves() { return numOctaves; }
    public double getBaseFrequencyX() { return baseFreqX;
    }
    public double getBaseFrequencyY() { return baseFreqY;
    }
    public boolean isStitched() { return stitched; }
    public boolean isFractalNoise() { return fractalNoise;
    }
    public void setTurbulenceRegion(java.awt.geom.Rectangle2D turbulenceRegion) {
        touch(
          );
        this.
          region =
          turbulenceRegion;
    }
    public void setSeed(int seed) { touch();
                                    this.seed = seed;
    }
    public void setNumOctaves(int numOctaves) { touch(
                                                  );
                                                this.
                                                  numOctaves =
                                                  numOctaves;
    }
    public void setBaseFrequencyX(double baseFreqX) {
        touch(
          );
        this.
          baseFreqX =
          baseFreqX;
    }
    public void setBaseFrequencyY(double baseFreqY) {
        touch(
          );
        this.
          baseFreqY =
          baseFreqY;
    }
    public void setStitched(boolean stitched) { touch(
                                                  );
                                                this.
                                                  stitched =
                                                  stitched;
    }
    public void setFractalNoise(boolean fractalNoise) {
        touch(
          );
        this.
          fractalNoise =
          fractalNoise;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.geom.Rectangle2D aoiRect;
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        if (aoi ==
              null) {
            aoiRect =
              getBounds2D(
                );
        }
        else {
            java.awt.geom.Rectangle2D rect =
              getBounds2D(
                );
            aoiRect =
              aoi.
                getBounds2D(
                  );
            if (!aoiRect.
                  intersects(
                    rect))
                return null;
            java.awt.geom.Rectangle2D.
              intersect(
                aoiRect,
                rect,
                aoiRect);
        }
        java.awt.geom.AffineTransform usr2dev =
          rc.
          getTransform(
            );
        final java.awt.Rectangle devRect =
          usr2dev.
          createTransformedShape(
            aoiRect).
          getBounds(
            );
        if (devRect.
              width <=
              0 ||
              devRect.
                height <=
              0)
            return null;
        java.awt.color.ColorSpace cs =
          getOperationColorSpace(
            );
        java.awt.geom.Rectangle2D tile =
          null;
        if (stitched)
            tile =
              (java.awt.geom.Rectangle2D)
                region.
                clone(
                  );
        java.awt.geom.AffineTransform patternTxf =
          new java.awt.geom.AffineTransform(
          );
        try {
            patternTxf =
              usr2dev.
                createInverse(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException e) {
            
        }
        return new org.apache.batik.ext.awt.image.rendered.TurbulencePatternRed(
          baseFreqX,
          baseFreqY,
          numOctaves,
          seed,
          fractalNoise,
          tile,
          patternTxf,
          devRect,
          cs,
          true);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4I/r/we6s8g2eSwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5H1o8q2H9q0zyv4kT/5jXHoTgDa5dtPv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("COB/ugmA9+eZ+eaWvQ/QvvUA/+KMsv+WJ38GjH8umvsbdglQws1uH/EI5Ldv" +
       "Bch4H2R860H+9Rllf5Mn//0UkPwJkP/jJkA+kGc+Bq4P74P88C0Hee72M8ou" +
       "5Jnfj/PNf+b4PuchunOlm0WX73m+uI/uxVuP7soZZffnyd1x6V4jIk9umh4h" +
       "vOcmEBYni1rgemkf4Uu3BuG5owrlAsqjZ8B8PE8eAg4xut4hnroXuPYM+Qj/" +
       "wzeLP+fwZ/fxf/aW4y+OuZ2DzsD/bJ68E7iS6NCVnHviCN+7bhZffrziF/fx" +
       "/eIPCV/jDHxYniDAn0Qn/MlxlNWbRVkF1xf2UX7hlqMcFkg6Z6Ak8uR9wN5G" +
       "pziV40h/9FYg/fI+0i//kJBOz0A6y5PBKUj5E0iHt0Jyv7KP9Cu3HGlxzO7c" +
       "j52B9IN5woEYNtfMI/9yHOPiZjHWwPXVfYxf/SFh1M7AaOTJKi5dBhhPeJnj" +
       "OKWbwPnWPPNHwPX1fZxfv6U4i2fw/vyuw5PG170v08Xt/ndHBezojClJ88QF" +
       "UyKFihgru8aGqx0M9OiJgXYVFLmfPx1NmfeGDmUC/3fK5wr52euHr/vKavdl" +
       "kPSrr1y+86FX2H9bnNg//HrnrlHpTjWx7eNHFY/dX/BDRTWK+bxrd3DRL0B/" +
       "NC49/boXIOL8JfvgoTDlH9n18tNx6fGze4lLdxgH83TQ6sW49PCNWsWl20B6" +
       "vPbfiUtvPq02qAnS4zX/Xly6crImGL/4P17vZwGeo3px6cLu5niVT4HeQZX8" +
       "9uf8A0Hov/4Vm9YqinPt6nh2/mVGrISAq8VayW4FZyfFDx9XoCI6v/+1hOiw" +
       "yfGvFXIyik/4DhZZkt1HfM9LX3plMPmJ79Z/afe1hGSL223ey52j0sXdhxtF" +
       "p/lCzZM37O2grwu9p79376/d9Y6DRaV7dwQfKfMx2t52+qcJhOPHxccE2996" +
       "6Nff849e+ePiXNn/AwzXielbOQAA");
}
