package org.sunflow.math;
public final class Solvers {
    public static final double[] solveQuadric(double a, double b, double c) {
        double disc =
          b *
          b -
          4 *
          a *
          c;
        if (disc <
              0)
            return null;
        disc =
          java.lang.Math.
            sqrt(
              disc);
        double q =
          b <
          0
          ? -0.5 *
          (b -
             disc)
          : -0.5 *
          (b +
             disc);
        double t0 =
          q /
          a;
        double t1 =
          c /
          q;
        return t0 >
          t1
          ? (new double[] { t1,
             t0 })
          : (new double[] { t0,
             t1 });
    }
    public static double[] solveQuartic(double a, double b, double c, double d,
                                        double e) { double inva = 1 / a;
                                                    double c1 = b * inva;
                                                    double c2 = c * inva;
                                                    double c3 = d * inva;
                                                    double c4 = e * inva;
                                                    double c12 = c1 * c1;
                                                    double p = -0.375 * c12 +
                                                      c2;
                                                    double q = 0.125 * c12 *
                                                      c1 -
                                                      0.5 *
                                                      c1 *
                                                      c2 +
                                                      c3;
                                                    double r = -0.01171875 *
                                                      c12 *
                                                      c12 +
                                                      0.0625 *
                                                      c12 *
                                                      c2 -
                                                      0.25 *
                                                      c1 *
                                                      c3 +
                                                      c4;
                                                    double z = solveCubicForQuartic(
                                                                 -0.5 *
                                                                   p,
                                                                 -r,
                                                                 0.5 *
                                                                   r *
                                                                   p -
                                                                   0.125 *
                                                                   q *
                                                                   q);
                                                    double d1 = 2.0 *
                                                      z -
                                                      p;
                                                    if (d1 < 0) {
                                                        if (d1 >
                                                              1.0E-10)
                                                            d1 =
                                                              0;
                                                        else
                                                            return null;
                                                    }
                                                    double d2;
                                                    if (d1 < 1.0E-10) {
                                                        d2 =
                                                          z *
                                                            z -
                                                            r;
                                                        if (d2 <
                                                              0)
                                                            return null;
                                                        d2 =
                                                          java.lang.Math.
                                                            sqrt(
                                                              d2);
                                                    }
                                                    else {
                                                        d1 =
                                                          java.lang.Math.
                                                            sqrt(
                                                              d1);
                                                        d2 =
                                                          0.5 *
                                                            q /
                                                            d1;
                                                    }
                                                    double q1 = d1 *
                                                      d1;
                                                    double q2 = -0.25 *
                                                      c1;
                                                    double pm = q1 -
                                                      4 *
                                                      (z -
                                                         d2);
                                                    double pp = q1 -
                                                      4 *
                                                      (z +
                                                         d2);
                                                    if (pm >= 0 &&
                                                          pp >=
                                                          0) { pm =
                                                                 java.lang.Math.
                                                                   sqrt(
                                                                     pm);
                                                               pp =
                                                                 java.lang.Math.
                                                                   sqrt(
                                                                     pp);
                                                               double[] results =
                                                                 new double[4];
                                                               results[0] =
                                                                 -0.5 *
                                                                   (d1 +
                                                                      pm) +
                                                                   q2;
                                                               results[1] =
                                                                 -0.5 *
                                                                   (d1 -
                                                                      pm) +
                                                                   q2;
                                                               results[2] =
                                                                 0.5 *
                                                                   (d1 +
                                                                      pp) +
                                                                   q2;
                                                               results[3] =
                                                                 0.5 *
                                                                   (d1 -
                                                                      pp) +
                                                                   q2;
                                                               for (int i =
                                                                      1;
                                                                    i <
                                                                      4;
                                                                    i++) {
                                                                   for (int j =
                                                                          i;
                                                                        j >
                                                                          0 &&
                                                                          results[j -
                                                                                    1] >
                                                                          results[j];
                                                                        j--) {
                                                                       double t =
                                                                         results[j];
                                                                       results[j] =
                                                                         results[j -
                                                                                   1];
                                                                       results[j -
                                                                                 1] =
                                                                         t;
                                                                   }
                                                               }
                                                               return results;
                                                    }
                                                    else
                                                        if (pm >=
                                                              0) {
                                                            pm =
                                                              java.lang.Math.
                                                                sqrt(
                                                                  pm);
                                                            double[] results =
                                                              new double[2];
                                                            results[0] =
                                                              -0.5 *
                                                                (d1 +
                                                                   pm) +
                                                                q2;
                                                            results[1] =
                                                              -0.5 *
                                                                (d1 -
                                                                   pm) +
                                                                q2;
                                                            return results;
                                                        }
                                                        else
                                                            if (pp >=
                                                                  0) {
                                                                pp =
                                                                  java.lang.Math.
                                                                    sqrt(
                                                                      pp);
                                                                double[] results =
                                                                  new double[2];
                                                                results[0] =
                                                                  0.5 *
                                                                    (d1 -
                                                                       pp) +
                                                                    q2;
                                                                results[1] =
                                                                  0.5 *
                                                                    (d1 +
                                                                       pp) +
                                                                    q2;
                                                                return results;
                                                            }
                                                    return null;
    }
    private static final double solveCubicForQuartic(double p,
                                                     double q,
                                                     double r) {
        double A2 =
          p *
          p;
        double Q =
          (A2 -
             3.0 *
             q) /
          9.0;
        double R =
          (p *
             (A2 -
                4.5 *
                q) +
             13.5 *
             r) /
          27.0;
        double Q3 =
          Q *
          Q *
          Q;
        double R2 =
          R *
          R;
        double d =
          Q3 -
          R2;
        double an =
          p /
          3.0;
        if (d >=
              0) {
            d =
              R /
                java.lang.Math.
                sqrt(
                  Q3);
            double theta =
              java.lang.Math.
              acos(
                d) /
              3.0;
            double sQ =
              -2.0 *
              java.lang.Math.
              sqrt(
                Q);
            return sQ *
              java.lang.Math.
              cos(
                theta) -
              an;
        }
        else {
            double sQ =
              java.lang.Math.
              pow(
                java.lang.Math.
                  sqrt(
                    R2 -
                      Q3) +
                  java.lang.Math.
                  abs(
                    R),
                1.0 /
                  3.0);
            if (R <
                  0)
                return sQ +
                  Q /
                  sQ -
                  an;
            else
                return -(sQ +
                           Q /
                           sQ) -
                  an;
        }
    }
    public Solvers() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/wKEIGjhxxoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qSCVnNW8BKfdjUxzBbRQ8E2+oBCFhW4vSRScwGrJ7dAev4h4URmU1pFrk0ZF" +
       "clIr6UnoAhGQmA/sebuOLpVJg9+ICySye0ifVzllWvSduCmjyDQiu91gpjak" +
       "ZeKo/iayalpVlAWWFMdmGvPtVHILcclolOTyYFVLs4vXUX0Dr2mc7M7NJHFB" +
       "XvemN2WvmW99cW/6d+SXGvt1JPCCn010X8QbbnLtBXf2F8ST/fvd/HPrDe53" +
       "D92BQdnL/H3XqxrlL/Iff+9TV9TBJ5Cd3bvDSQjdHLreG2wt1uxj12mvu/6l" +
       "RT8vmh3caX3lvf967/jN5ttfxK39A8f4PE7y9/rPfK37qPLBHejk/g3XVeW8" +
       "o0iXjt5r3eJrYeQ74yO3W/fta/ahTGNvAN/bdzV7+7Vvzl+EcRy7pD25q8rs" +
       "mT1kFEIInVHdSN6WpPJL5zAnENzgljdvnBC6Na+bjiJJ9S0F7NKrr79L+QXz" +
       "9qboyicf+ea7rjzyD/kd7VkrECS/5RvXKDIewvnRM8/94Nu33feZvKZxSpaC" +
       "rRqPV2evLr4eqanmfN+6r/VXZAI9sFtm2yu3QSEk/uy1MPDabWgw5wE8X7Kx" +
       "yI+1vUrbz5F6Ll+4v2Unditf+5dYjycnoNye3vPTvX43wpyxNccIzWvZzUmg" +
       "7Kz7Ti/ZX3JnS2fvUvWugytOzHYdLStW7M1tC3eWe3G/Wg8mk2syv9gyny+W" +
       "NY/cwDafvMHcB7PmiRA6rWTMbHm/AfjTuxeAeRB1f9o14WHsLddHC2OvAd9H" +
       "dw3t0Rfh3geb0r6mZ5/OoU4fuO+xJke6cgMxfztrPnLIm/3QUnLlHEj/Wz+D" +
       "9A9mg5Xcs7af8MUEtxC6yfOtWAq1/1+Eu5b0v38D6T+dNZ8A5phLj0WypXRc" +
       "/5AWwgMtfPLFaCEBnO/WqrNi2z1X/c9l+98M5TNXzp19+RX+r7ehbe//Ezf3" +
       "oLN6ZNuHayOH+mc8X9OtXICbt5USL//5fAidP14xD6FT2U/O4B9uwb4YQi85" +
       "BAY43e0dBvpj4OIAKOt+ybtGmWRb80lOHD3195V1509T1qFE4ZEjB0f+x6G9" +
       "ozja/nXosvLZKxTzjudrn9iWhxVbStOMylkQ47eV6v3j/KHrUtujdYZ47IXb" +
       "P3fzq/dSj9u3DB/Y4SHeHrh2/RVfemFeMU3/6OWff+PvXPluXrX5P/O6plnR" +
       "JQAA");
}
