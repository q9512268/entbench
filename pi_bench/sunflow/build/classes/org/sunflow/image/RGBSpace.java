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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cCBAP93PL/Hq1v8HXcj5+wU+AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mtAsALHrEtGk0iFXA+xKw05XpREvapFy");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Uetqpsv0ElVgFiQHNTnAX8PlXtNCOtPIGJtFgMDHBOGU4LI9gPv2uNOJNKi1" +
       "IHEjFa3XttG1UzRxD4WYYafUTrGqLauOq47SEJeMSbfVKoQYpkrhED5etZiJ" +
       "qGvA0iyjPOJq4069RGtNnA8nbZmjPR8BK3hdAL3QxVytiwxSUzFY3xgvNWak" +
       "yPMWRTgJ3++lTtJBm+Oa75nzoCxFFoY3hRIu0ASkLzotrj/QLEiYdwxgsVhy" +
       "rtKPqIB3DGyQjpIwRJdZcdKXMACxqeKAkFG47XFBtSHbsC+PFhK30uVamIzK" +
       "pkTFvfnSAuOwF5uJMddVk6jhKOD40WBcFImlHKUND1lI6CwI7XLPIpZ9oF3H" +
       "K4gh2FSJTQaDCZWEoiv2HUm3+tNZp20CSyFcIoIg+PE0bNKzSltY93S7xczE" +
       "oJ0gIi0wQjcuCtNINaGoqyeg1MBx220YkcOPPXduUnINHbiqXROCOlSfoHwJ" +
       "muKzoOaQLgczEAS2IKa/XtcQe1ofeTWRXDbxwby1MBdp9xb4UCUaabQ2MDiq" +
       "XMOSctlI7U1Hk1mzBJEDa1DpVLBORXMxUyAnEVptFNFyBMqOLRKcKkvpLxJH" +
       "o4dNm1adZXMID3o1cU1JXlIPZbFBjmbLOaEngWzOK1M8gKSgNiHd9mTu9Eu0" +
       "D4wmAdsQqHI/lhVmHZHpGKuIqho8n+A1pAwI49VQA4YY2Q/sIm/648l8Qrg9" +
       "d0FjrVqE1Np6X4ORCQe2u6DhqLo5L7EdrdIcr4dJxSrFjAVVGXQ6ICE/bfcE" +
       "hVL9CqyPwiqqc/Ne5GNIEqoGlwyXoRfRfsmPYRGIpbgtmpyOsmJcX1XEdATZ" +
       "r6d+GS+qNWUFacWe2YKcZq2OT5LQra3BEepPQFem7LJSstQmgJjDWjmxWhIQ" +
       "GT1AESvFWQcdB80o/QkZ2binu3xlKSZL1Z7J6hLxqGk7DehJ3cL6wKhYY6NJ" +
       "AtWwIjppS/y6oi2VxqwRVtu6qcuL1aq8ArmlJPblxXBKNFlQnhATeIlrrK3V" +
       "wxDrsWQxLo3XmLqYYqw0mhGqVgYrFSleJ5Mlz8d8okmmpFkAivN1Jq7JkK87" +
       "ClwBgzrQMfr2uruCx7qKhO200cojaYgG3nqGBbqwluFBaEIOSojVtghTxpBZ" +
       "tbucJ0vjiI47XgsEzEQObKnsVRgIHUUaYRozyGgs6onCgLEXhrIxGSHgDIGx" +
       "odxK430zKpfd0qxh90oAoIZeMAR1QNGbqi9C7TUCdJsAiMJqdaHhoLSSsKJX" +
       "q0M1rhyjKoEuSsvFsAnH5BpJ2wkDGgsSk6uID7jeWgHrUgualGpjMBrMEnM0" +
       "52ByPUbxVjLqLtJOU2GdskYX4XE0NPsDbrxiyguzWLQ68GDR46dVEGfjhsyt" +
       "QENGXLY6whVCJqsEj5d5FmSWxQhjxvICAVYDgCCIt2V/656wdPakv3Xvz//B" +
       "PnjWemGiWSUfO8U/t/GLzwYdzAXkn2yx/nWP7R6ZC8hzPrKdevC9wmtPerI6" +
       "f0DtUx987nml84vFve0DYmhQuDNw3B821TROHanqUnZ8LjrAyGcq35hu+hZD" +
       "Pz4lcSj/i09zHZs4OTpv9uDOh3fHkynpmE6+0Ofcr95k3uXXsuRzQeFyGugi" +
       "1QvSgoHTq1f36374xrrzig9nQT7/Yn+5H73lSVqytlqyXkEtnT/0yvJhkkv9" +
       "mzfRyG9lyT+/USPZ6X98KPYLL0Ps/EnWpwrZzO3mE7zyzpHj5gL965sI+9Us" +
       "+dKhsKmcgZNKnJ3+wqGwX34Zwv5AdjKbxH/vVtj3/v+x8b+7idhfz5I/CAp3" +
       "6bavK2pdtMJg1xTTHZLjmKpoH2riay/X27M1Fu/fauL9Z2L2rfzfuon8386S" +
       "PwoKd+fPg5CO56nyZpH+oaQvuu71xSR9Mt2e3Ur67FlK+uc3kfR/Z8l/Dwr3" +
       "hvZNZP0fL0PWB/et+omtrJ84m8asZRn2zp8s696FLNtfprJ6c6nvtB07exeG" +
       "6OWFD2X9/suV9Uq6Pb+V9fmzlPXyTWS9P0supS04l3WXoHt3vQxBH9kX9NNb" +
       "QT/9Cgp6VI4fvMm1bFXG3kNB4WLgHEztn/vYoYAPvwwBDx7i+vWtgL/+kgTk" +
       "Xmx8ck46uGW+mjrr+s5tb5nvg8K1G18f8CNXlqHo68vQCdQ3bV4McWXz4POV" +
       "/LHnKxt9vOOdV7gORV9rExwtXHnbFVtdba+8R7SkZ95x9erVdz79lOvGh4rb" +
       "texo76nt+pC9my0tPWrQrD5nuV1ytPemG5ccZdeWWeLfuIYoN8Tmtnnp7Pv6" +
       "Jm5Qvsk1JEuKWQ3v25DcJC8ab/Y/dJM8eJa8ISjcZom6vatHvC1ydOXQBR8/" +
       "jQvGqSvvv1Ume0XGIze8eWrztiT5s89fvvjw84M/2Kyd23+j0Z1s4eIsNM2j" +
       "j9sfOb7d9dSZntvnzs3D97nd98j0F8gNg9igcCHfZ4x71U3GWhpNjmRMe//t" +
       "0dFMjaBwPs2UHTbd/UHykRUxmxcJxBvneuRI29v8ynngxfR15IfJ49etNMtf" +
       "5rW/KizcvM7rmvy555vt93y38oubV7nIprjOl8xeZAt3bN4qk1earSx7/Ym1" +
       "7dd1O/PU9+79/J1P7v/UuXcDfBgHjrC9bvd7U2jLDfI3nax/7eFffeunn/96" +
       "viTo/wH8MtebZU0AAA==");
}
