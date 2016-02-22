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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KpEbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
