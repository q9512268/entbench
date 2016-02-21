package org.sunflow.image;
public final class RGBSpace {
    public static final org.sunflow.image.RGBSpace ADOBE = new org.sunflow.image.RGBSpace(
      0.64F,
      0.33F,
      0.21F,
      0.71F,
      0.15F,
      0.06F,
      0.31271F,
      0.32902F,
      2.2F,
      0);
    public static final org.sunflow.image.RGBSpace APPLE = new org.sunflow.image.RGBSpace(
      0.625F,
      0.34F,
      0.28F,
      0.595F,
      0.155F,
      0.07F,
      0.31271F,
      0.32902F,
      1.8F,
      0);
    public static final org.sunflow.image.RGBSpace NTSC =
      new org.sunflow.image.RGBSpace(
      0.67F,
      0.33F,
      0.21F,
      0.71F,
      0.14F,
      0.08F,
      0.3101F,
      0.3162F,
      20.0F /
        9.0F,
      0.018F);
    public static final org.sunflow.image.RGBSpace HDTV =
      new org.sunflow.image.RGBSpace(
      0.64F,
      0.33F,
      0.3F,
      0.6F,
      0.15F,
      0.06F,
      0.31271F,
      0.32902F,
      20.0F /
        9.0F,
      0.018F);
    public static final org.sunflow.image.RGBSpace SRGB =
      new org.sunflow.image.RGBSpace(
      0.64F,
      0.33F,
      0.3F,
      0.6F,
      0.15F,
      0.06F,
      0.31271F,
      0.32902F,
      2.4F,
      0.00304F);
    public static final org.sunflow.image.RGBSpace CIE = new org.sunflow.image.RGBSpace(
      0.735F,
      0.265F,
      0.274F,
      0.717F,
      0.167F,
      0.009F,
      1 /
        3.0F,
      1 /
        3.0F,
      2.2F,
      0);
    public static final org.sunflow.image.RGBSpace
      EBU =
      new org.sunflow.image.RGBSpace(
      0.64F,
      0.33F,
      0.29F,
      0.6F,
      0.15F,
      0.06F,
      0.31271F,
      0.32902F,
      20.0F /
        9.0F,
      0.018F);
    public static final org.sunflow.image.RGBSpace
      SMPTE_C =
      new org.sunflow.image.RGBSpace(
      0.63F,
      0.34F,
      0.31F,
      0.595F,
      0.155F,
      0.07F,
      0.31271F,
      0.32902F,
      20.0F /
        9.0F,
      0.018F);
    public static final org.sunflow.image.RGBSpace
      SMPTE_240M =
      new org.sunflow.image.RGBSpace(
      0.63F,
      0.34F,
      0.31F,
      0.595F,
      0.155F,
      0.07F,
      0.31271F,
      0.32902F,
      20.0F /
        9.0F,
      0.018F);
    public static final org.sunflow.image.RGBSpace
      WIDE_GAMUT =
      new org.sunflow.image.RGBSpace(
      0.7347F,
      0.2653F,
      0.1152F,
      0.8264F,
      0.1566F,
      0.0177F,
      0.3457F,
      0.3585F,
      2.2F,
      0);
    private final float gamma;
    private final float breakPoint;
    private final float slope;
    private final float slopeMatch;
    private final float segmentOffset;
    private final float xr;
    private final float yr;
    private final float zr;
    private final float xg;
    private final float yg;
    private final float zg;
    private final float xb;
    private final float yb;
    private final float zb;
    private final float xw;
    private final float yw;
    private final float zw;
    private final float rx;
    private final float ry;
    private final float rz;
    private final float gx;
    private final float gy;
    private final float gz;
    private final float bx;
    private final float by;
    private final float bz;
    private final float rw;
    private final float gw;
    private final float bw;
    private final int[] GAMMA_CURVE;
    private final int[] INV_GAMMA_CURVE;
    public RGBSpace(float xRed, float yRed, float xGreen,
                    float yGreen,
                    float xBlue,
                    float yBlue,
                    float xWhite,
                    float yWhite,
                    float gamma,
                    float breakPoint) { super();
                                        this.gamma =
                                          gamma;
                                        this.breakPoint =
                                          breakPoint;
                                        if (breakPoint >
                                              0) {
                                            slope =
                                              1 /
                                                (gamma /
                                                   (float)
                                                     java.lang.Math.
                                                     pow(
                                                       breakPoint,
                                                       1 /
                                                         gamma -
                                                         1) -
                                                   gamma *
                                                   breakPoint +
                                                   breakPoint);
                                            slopeMatch =
                                              gamma *
                                                slope /
                                                (float)
                                                  java.lang.Math.
                                                  pow(
                                                    breakPoint,
                                                    1 /
                                                      gamma -
                                                      1);
                                            segmentOffset =
                                              slopeMatch *
                                                (float)
                                                  java.lang.Math.
                                                  pow(
                                                    breakPoint,
                                                    1 /
                                                      gamma) -
                                                slope *
                                                breakPoint;
                                        }
                                        else {
                                            slope =
                                              1;
                                            slopeMatch =
                                              1;
                                            segmentOffset =
                                              0;
                                        }
                                        GAMMA_CURVE =
                                          (new int[256]);
                                        INV_GAMMA_CURVE =
                                          (new int[256]);
                                        for (int i =
                                               0;
                                             i <
                                               256;
                                             i++) {
                                            float c =
                                              i /
                                              255.0F;
                                            GAMMA_CURVE[i] =
                                              org.sunflow.math.MathUtils.
                                                clamp(
                                                  (int)
                                                    (gammaCorrect(
                                                       c) *
                                                       255 +
                                                       0.5F),
                                                  0,
                                                  255);
                                            INV_GAMMA_CURVE[i] =
                                              org.sunflow.math.MathUtils.
                                                clamp(
                                                  (int)
                                                    (ungammaCorrect(
                                                       c) *
                                                       255 +
                                                       0.5F),
                                                  0,
                                                  255);
                                        }
                                        float xr =
                                          xRed;
                                        float yr =
                                          yRed;
                                        float zr =
                                          1 -
                                          (xr +
                                             yr);
                                        float xg =
                                          xGreen;
                                        float yg =
                                          yGreen;
                                        float zg =
                                          1 -
                                          (xg +
                                             yg);
                                        float xb =
                                          xBlue;
                                        float yb =
                                          yBlue;
                                        float zb =
                                          1 -
                                          (xb +
                                             yb);
                                        xw = xWhite;
                                        yw = yWhite;
                                        zw = 1 - (xw +
                                                    yw);
                                        float rx =
                                          yg *
                                          zb -
                                          yb *
                                          zg;
                                        float ry =
                                          xb *
                                          zg -
                                          xg *
                                          zb;
                                        float rz =
                                          xg *
                                          yb -
                                          xb *
                                          yg;
                                        float gx =
                                          yb *
                                          zr -
                                          yr *
                                          zb;
                                        float gy =
                                          xr *
                                          zb -
                                          xb *
                                          zr;
                                        float gz =
                                          xb *
                                          yr -
                                          xr *
                                          yb;
                                        float bx =
                                          yr *
                                          zg -
                                          yg *
                                          zr;
                                        float by =
                                          xg *
                                          zr -
                                          xr *
                                          zg;
                                        float bz =
                                          xr *
                                          yg -
                                          xg *
                                          yr;
                                        rw = (rx *
                                                xw +
                                                ry *
                                                yw +
                                                rz *
                                                zw) /
                                               yw;
                                        gw = (gx *
                                                xw +
                                                gy *
                                                yw +
                                                gz *
                                                zw) /
                                               yw;
                                        bw = (bx *
                                                xw +
                                                by *
                                                yw +
                                                bz *
                                                zw) /
                                               yw;
                                        this.rx =
                                          rx /
                                            rw;
                                        this.ry =
                                          ry /
                                            rw;
                                        this.rz =
                                          rz /
                                            rw;
                                        this.gx =
                                          gx /
                                            gw;
                                        this.gy =
                                          gy /
                                            gw;
                                        this.gz =
                                          gz /
                                            gw;
                                        this.bx =
                                          bx /
                                            bw;
                                        this.by =
                                          by /
                                            bw;
                                        this.bz =
                                          bz /
                                            bw;
                                        float s =
                                          1 /
                                          (this.
                                             rx *
                                             (this.
                                                gy *
                                                this.
                                                  bz -
                                                this.
                                                  by *
                                                this.
                                                  gz) -
                                             this.
                                               ry *
                                             (this.
                                                gx *
                                                this.
                                                  bz -
                                                this.
                                                  bx *
                                                this.
                                                  gz) +
                                             this.
                                               rz *
                                             (this.
                                                gx *
                                                this.
                                                  by -
                                                this.
                                                  bx *
                                                this.
                                                  gy));
                                        this.xr =
                                          s *
                                            (this.
                                               gy *
                                               this.
                                                 bz -
                                               this.
                                                 gz *
                                               this.
                                                 by);
                                        this.xg =
                                          s *
                                            (this.
                                               rz *
                                               this.
                                                 by -
                                               this.
                                                 ry *
                                               this.
                                                 bz);
                                        this.xb =
                                          s *
                                            (this.
                                               ry *
                                               this.
                                                 gz -
                                               this.
                                                 rz *
                                               this.
                                                 gy);
                                        this.yr =
                                          s *
                                            (this.
                                               gz *
                                               this.
                                                 bx -
                                               this.
                                                 gx *
                                               this.
                                                 bz);
                                        this.yg =
                                          s *
                                            (this.
                                               rx *
                                               this.
                                                 bz -
                                               this.
                                                 rz *
                                               this.
                                                 bx);
                                        this.yb =
                                          s *
                                            (this.
                                               rz *
                                               this.
                                                 gx -
                                               this.
                                                 rx *
                                               this.
                                                 gz);
                                        this.zr =
                                          s *
                                            (this.
                                               gx *
                                               this.
                                                 by -
                                               this.
                                                 gy *
                                               this.
                                                 bx);
                                        this.zg =
                                          s *
                                            (this.
                                               ry *
                                               this.
                                                 bx -
                                               this.
                                                 rx *
                                               this.
                                                 by);
                                        this.zb =
                                          s *
                                            (this.
                                               rx *
                                               this.
                                                 gy -
                                               this.
                                                 ry *
                                               this.
                                                 gx);
    }
    public final org.sunflow.image.Color convertXYZtoRGB(org.sunflow.image.XYZColor c) {
        return convertXYZtoRGB(
                 c.
                   getX(
                     ),
                 c.
                   getY(
                     ),
                 c.
                   getZ(
                     ));
    }
    public final org.sunflow.image.Color convertXYZtoRGB(float X,
                                                         float Y,
                                                         float Z) {
        float r =
          rx *
          X +
          ry *
          Y +
          rz *
          Z;
        float g =
          gx *
          X +
          gy *
          Y +
          gz *
          Z;
        float b =
          bx *
          X +
          by *
          Y +
          bz *
          Z;
        return new org.sunflow.image.Color(
          r,
          g,
          b);
    }
    public final org.sunflow.image.XYZColor convertRGBtoXYZ(org.sunflow.image.Color c) {
        float[] rgb =
          c.
          getRGB(
            );
        float X =
          xr *
          rgb[0] +
          xg *
          rgb[1] +
          xb *
          rgb[2];
        float Y =
          yr *
          rgb[0] +
          yg *
          rgb[1] +
          yb *
          rgb[2];
        float Z =
          zr *
          rgb[0] +
          zg *
          rgb[1] +
          zb *
          rgb[2];
        return new org.sunflow.image.XYZColor(
          X,
          Y,
          Z);
    }
    public final boolean insideGamut(float r,
                                     float g,
                                     float b) {
        return r >=
          0 &&
          g >=
          0 &&
          b >=
          0;
    }
    public final float gammaCorrect(float v) {
        if (v <=
              0)
            return 0;
        else
            if (v >=
                  1)
                return 1;
            else
                if (v <=
                      breakPoint)
                    return slope *
                      v;
                else
                    return slopeMatch *
                      (float)
                        java.lang.Math.
                        pow(
                          v,
                          1 /
                            gamma) -
                      segmentOffset;
    }
    public final float ungammaCorrect(float vp) {
        if (vp <=
              0)
            return 0;
        else
            if (vp >=
                  1)
                return 1;
            else
                if (vp <=
                      breakPoint *
                      slope)
                    return vp /
                      slope;
                else
                    return (float)
                             java.lang.Math.
                             pow(
                               (vp +
                                  segmentOffset) /
                                 slopeMatch,
                               gamma);
    }
    public final int rgbToNonLinear(int rgb) {
        int rp =
          GAMMA_CURVE[rgb >>
                        16 &
                        255];
        int gp =
          GAMMA_CURVE[rgb >>
                        8 &
                        255];
        int bp =
          GAMMA_CURVE[rgb &
                        255];
        return rp <<
          16 |
          gp <<
          8 |
          bp;
    }
    public final int rgbToLinear(int rgb) {
        int rp =
          INV_GAMMA_CURVE[rgb >>
                            16 &
                            255];
        int gp =
          INV_GAMMA_CURVE[rgb >>
                            8 &
                            255];
        int bp =
          INV_GAMMA_CURVE[rgb &
                            255];
        return rp <<
          16 |
          gp <<
          8 |
          bp;
    }
    public final java.lang.String toString() {
        java.lang.String info =
          "Gamma function parameters:\n";
        info +=
          java.lang.String.
            format(
              "  * Gamma:          %7.4f\n",
              gamma);
        info +=
          java.lang.String.
            format(
              "  * Breakpoint:     %7.4f\n",
              breakPoint);
        info +=
          java.lang.String.
            format(
              "  * Slope:          %7.4f\n",
              slope);
        info +=
          java.lang.String.
            format(
              "  * Slope Match:    %7.4f\n",
              slopeMatch);
        info +=
          java.lang.String.
            format(
              "  * Segment Offset: %7.4f\n",
              segmentOffset);
        info +=
          "XYZ -> RGB Matrix:\n";
        info +=
          java.lang.String.
            format(
              "| %7.4f %7.4f %7.4f|\n",
              rx,
              ry,
              rz);
        info +=
          java.lang.String.
            format(
              "| %7.4f %7.4f %7.4f|\n",
              gx,
              gy,
              gz);
        info +=
          java.lang.String.
            format(
              "| %7.4f %7.4f %7.4f|\n",
              bx,
              by,
              bz);
        info +=
          "RGB -> XYZ Matrix:\n";
        info +=
          java.lang.String.
            format(
              "| %7.4f %7.4f %7.4f|\n",
              xr,
              xg,
              xb);
        info +=
          java.lang.String.
            format(
              "| %7.4f %7.4f %7.4f|\n",
              yr,
              yg,
              yb);
        info +=
          java.lang.String.
            format(
              "| %7.4f %7.4f %7.4f|\n",
              zr,
              zg,
              zb);
        return info;
    }
    public static void main(java.lang.String[] args) {
        java.lang.System.
          out.
          println(
            SRGB.
              toString(
                ));
        java.lang.System.
          out.
          println(
            HDTV.
              toString(
                ));
        java.lang.System.
          out.
          println(
            WIDE_GAMUT.
              toString(
                ));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "oxjftbb1/wGF+ZwMvzwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Kt6Z1mYhRngmgjWWwDjs0qRZoouFwM775XY3T08D3Ki2VwojauHCQrr5Xjw3" +
       "6mFPryedyZLqOfNBf2DqDX4NjB7qYWIlLsjTQb/Hx4lfU50VBi310XI6FeBa" +
       "z6RwOsK9UoENik0ah5AixWolfTDn8LoO5T1VpOReMh6ZiDEZGAG3aKr6lGhh" +
       "S0ddDhgUUvrVygqWpbU9XdUQn+tVVZ2szfo8rxVa4pJYjIaMGAYVDy5i+rDX" +
       "lAWoVDfGMDC8ZYc3h3xzsqo6/YYLcd0ONrHzZhkq1jg7GNaEVnuVEPJKbQWT" +
       "TouaDbs9LW7pkZCfVxsLyLVGJh0bQ6ZnVXR0OYTzuE32hVCdElh9WULo9aRK" +
       "NikvrJRJBppOhnNEN8rUNG/y1Um/2CyXBHJdhocypOoTG1nZiSfiijIjkqZZ" +
       "mQ8mzbUy0NxKIY6SzoArR8XmHLP6zSa8iIKwVMw3et1JozqdLZCBQdQ6c1Yo" +
       "wpFvs5CqQFODLTb749jOe32DIevVjufWUXvNjpkhPSjYNjZo1FhngCwKxVGQ" +
       "l6qeOa7Xk+Wca5TVaFJRIAwz1WK3bMEUUe+hqDgdLSvVHgwNx1HLUNQQYvId" +
       "Wuctvqw6kjIzqUodmbNyyUfMjoFpTXSUj+gI5pkKTVK0pI1Nr9OSPHIa922n" +
       "Y6GR0kLFEaH6AjnujCxHm1t4Gzf0gCtDiDvFdGVu0nPHbfXbhX7bQ/N9slhZ" +
       "wP0ObtSQ9VQZ4qGoCgXEX9tWGa8iAxVT0ZpComgFbfVMdJAfGZBYQAKcZPGh" +
       "xDgrQvCS8togfKTVrKOwZ5AkXkRCsjpHGuUGE/QWcQWHXQjHF6glUGiP7rLT" +
       "Soin3afaktZEifTG4niA1c3KAgEesKfCzSG4B2l7Cj+VS+MKU2uXYTqAFRrH" +
       "VypcHhoLRtMFg0U6LYXgMD8OoHosTheLmovBgRDBoyrcdgOKnGIs11U4CGfy" +
       "MOZPE4FZLONybMpy0SPqRbgqaoUpyTZWZKFKK2F/VqZKON5ZltarYCJJTL6t" +
       "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" +
       "qkSf8gbUeuEOYmddqyyL9BgdVcpxAcqr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "TQAA");
}
