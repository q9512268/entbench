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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "CkH8k3XgYf6Kb4/8D8X1C/QoLgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV7e+zr1n2f7rV9r33t+F7bie14jmM7zsNWcilSlETCaRpR" +
       "EvUgKVEiJYpsUofiSxTfL5FS4yVNMSddNzdLnSYDWqN/pNhSpE0XtGiBrIWH" +
       "ZmuyFts6BN27CYoBzdZmaLCtC5pt2SGl3+P+7u/+bOfeYPqB3x95nt/POd8X" +
       "zzn8wrdLd0Rhqex79sawvfiqlsVXV3btarzxtejqgK6xchhpasuWo4gHac8p" +
       "T/765b/63ieXV86XLkilB2TX9WI5Nj03mmiRZ681lS5dPkrt2JoTxaUr9Epe" +
       "y1ASmzZEm1H8LF26+1jVuPQUfcACBFiAAAtQwQLUPCoFKr1BcxOnldeQ3TgK" +
       "Sn+zdI4uXfCVnL249MS1jfhyKDv7ZtgCAWjhzvx5BkAVlbOw9Pgh9h3m6wB/" +
       "ugy99Jkfv/Kl20qXpdJl0+VydhTARAw6kUr3OJqz0MKoqaqaKpXuczVN5bTQ" +
       "lG1zW/Atle6PTMOV4yTUDgcpT0x8LSz6PBq5e5QcW5gosRcewtNNzVYPnu7Q" +
       "bdkAWB88wrpDSObpAOAlEzAW6rKiHVS53TJdNS699WSNQ4xPUaAAqHrR0eKl" +
       "d9jV7a4MEkr37+bOll0D4uLQdA1Q9A4vAb3EpUdu2Gg+1r6sWLKhPReXHj5Z" +
       "jt1lgVJ3FQORV4lLbzpZrGgJzNIjJ2bp2Px8e/jeF3/C7bnnC55VTbFz/u8E" +
       "lR47UWmi6VqouYq2q3jPM/TPyw/+zifOl0qg8JtOFN6V+a0Pf+f9737sla/u" +
       "yvyNU8qMFitNiZ9TPre4948ebT2N35azcafvRWY++dcgL8Sf3ec8m/lA8x48" +
       "bDHPvHqQ+crkn4kf/RXtz8+XLvVLFxTPThwgR/cpnuObthZ2NVcL5VhT+6W7" +
       "NFdtFfn90kVwT5uutksd6Xqkxf3S7XaRdMErnsEQ6aCJfIgugnvT1b2De1+O" +
       "l8V95pdKpYvgKj0GrqdLu987cxKXfGjpORokK7Jruh7Ehl6OP4I0N16AsV1C" +
       "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" +
       "hJe4aoS0T8D7yk3Au5wnPgiuD+zhfeDW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("w/v6GXl/nJN/GZcuAnjcwVbfEbR/dbPQHgWXuoem3npo3zwj709z8h/i0hsA" +
       "tOG1G4dHAP/jTQC8P0/MN8jsPUD71gP8izPy/ltO/gwY/1w095t+CVDCzW4v" +
       "8gjkt24FyHgPMr71IL97Rt5f5+S/nwJSPAHyf9wEyAfyxLeA68N7kB++5SDP" +
       "3X5G3oU88ftxfoCAO75XeojuXOlm0eX7pi/s0b1w69FdOSPv/pzcHZfuNSPy" +
       "5MbrEcJ7bgJhcTqpCa4X9whfvDUIzx0VqBRQHj0D5mM5eQg4xOh6h3jqfuLa" +
       "M9Uj/A/fLP58hj+zx/+ZW46/OCp3rnwG/vfk5B3AlUSHruTc40f43nmz+PIj" +
       "Gr+0x/dLPyR8jTPw4TlBgD+JTviT4yirN4uyCq7P71F+/pajpAokrTNQdnLy" +
       "PmBvo1OcynGkP3orkH5pj/RLPySkozOQjnMyOAWpeAIpdSsk98t7pF++5UiL" +
       "o3rnfuwMpB/MyQzEsLlmHvmX4xiFm8VYA9dX9hi/8kPCaJyB0czJIi5dBhhP" +
       "eJnjOJWbwPnmPPFd4PraHufXbinO4hm8P7/z8LTyde/Lk+J2/31SATs6Y0jS" +
       "nLhgSJRQk2NtV9l0jYOOHj3R0a6Apvbzp6Mh817XwU7g/0755CE/v/3wdV9j" +
       "7b4gUn7t5ct3PvTy9N8Up/4Pv/K5iy7dqSe2ffy447H7C36o6WYxnnftDj/6" +
       "BeiPxqWnX/MCRJy/ZB88FKb8I7tWfiouPXZ2K3HpDvNgnA5qvRCXHr5Rrbh0" +
       "G6DHS/90XHrjaaVBSUCPl/w7cenKyZKg/+L/8XI/C/AclYtLF3Y3x4t8CrQO" +
       "iuS3P+cfCEL/ta/YNBdRnGtXy7PzrztiLQSzWqyV7FZwdlL88HEFKqLz+19N" +
       "iA6rHP/iIWej+NTvYJEl2X3s95zyxZcHw5/4Tv2Xd19cKLa83eat3EmXLu4+" +
       "/igazRdqnrhhawdtXeg9/b17f/2utx8sKt27Y/hImY/x9tbTP2/oOH5cfJCw" +
       "/e2HfuO9/+DlPynOpv0/dJIXvYM5AAA=");
}
