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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "wVtXX3AgQD/dyy/x6oY/Az3mlbsZPgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5V5iArGu/OKMHVFsh83Xeb9KKXKx3tf8");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "tizo/wEAoEsDfU0AAA==");
}
