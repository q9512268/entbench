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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6XDxfzC/lyOtGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
