package org.apache.batik.ext.awt.geom;
public abstract class AbstractSegment implements org.apache.batik.ext.awt.geom.Segment {
    protected abstract int findRoots(double y, double[] roots);
    public org.apache.batik.ext.awt.geom.Segment.SplitResults split(double y) {
        double[] roots =
          { 0,
        0,
        0 };
        int numSol =
          findRoots(
            y,
            roots);
        if (numSol ==
              0)
            return null;
        java.util.Arrays.
          sort(
            roots,
            0,
            numSol);
        double[] segs =
          new double[numSol +
                       2];
        int numSegments =
          0;
        segs[numSegments++] =
          0;
        for (int i =
               0;
             i <
               numSol;
             i++) {
            double r =
              roots[i];
            if (r <=
                  0.0)
                continue;
            if (r >=
                  1.0)
                break;
            if (segs[numSegments -
                       1] !=
                  r)
                segs[numSegments++] =
                  r;
        }
        segs[numSegments++] =
          1.0;
        if (numSegments ==
              2)
            return null;
        org.apache.batik.ext.awt.geom.Segment[] parts =
          new org.apache.batik.ext.awt.geom.Segment[numSegments];
        double pT =
          0.0;
        int pIdx =
          0;
        boolean firstAbove =
          false;
        boolean prevAbove =
          false;
        for (int i =
               1;
             i <
               numSegments;
             i++) {
            parts[pIdx] =
              getSegment(
                segs[i -
                       1],
                segs[i]);
            java.awt.geom.Point2D.Double pt =
              parts[pIdx].
              eval(
                0.5);
            if (pIdx ==
                  0) {
                pIdx++;
                firstAbove =
                  (prevAbove =
                     pt.
                       y <
                       y);
                continue;
            }
            boolean above =
              pt.
                y <
              y;
            if (prevAbove ==
                  above) {
                parts[pIdx -
                        1] =
                  getSegment(
                    pT,
                    segs[i]);
            }
            else {
                pIdx++;
                pT =
                  segs[i -
                         1];
                prevAbove =
                  above;
            }
        }
        if (pIdx ==
              1)
            return null;
        org.apache.batik.ext.awt.geom.Segment[] below;
        org.apache.batik.ext.awt.geom.Segment[] above;
        if (firstAbove) {
            above =
              (new org.apache.batik.ext.awt.geom.Segment[(pIdx +
                                                            1) /
                                                           2]);
            below =
              (new org.apache.batik.ext.awt.geom.Segment[pIdx /
                                                           2]);
        }
        else {
            above =
              (new org.apache.batik.ext.awt.geom.Segment[pIdx /
                                                           2]);
            below =
              (new org.apache.batik.ext.awt.geom.Segment[(pIdx +
                                                            1) /
                                                           2]);
        }
        int ai =
          0;
        int bi =
          0;
        for (int i =
               0;
             i <
               pIdx;
             i++) {
            if (firstAbove)
                above[ai++] =
                  parts[i];
            else
                below[bi++] =
                  parts[i];
            firstAbove =
              !firstAbove;
        }
        return new org.apache.batik.ext.awt.geom.Segment.SplitResults(
          below,
          above);
    }
    public org.apache.batik.ext.awt.geom.Segment splitBefore(double t) { return getSegment(
                                                                                  0.0,
                                                                                  t);
    }
    public org.apache.batik.ext.awt.geom.Segment splitAfter(double t) {
        return getSegment(
                 t,
                 1.0);
    }
    static final double eps = 1 / (double) (1L <<
                                              48);
    static final double tol = 4.0 * eps;
    public static int solveLine(double a, double b,
                                double[] roots) {
        if (a ==
              0) {
            if (b !=
                  0)
                return 0;
            roots[0] =
              0;
            return 1;
        }
        roots[0] =
          -b /
            a;
        return 1;
    }
    public static int solveQuad(double a, double b,
                                double c,
                                double[] roots) {
        if (a ==
              0) {
            return solveLine(
                     b,
                     c,
                     roots);
        }
        double det =
          b *
          b -
          4 *
          a *
          c;
        if (java.lang.Math.
              abs(
                det) <=
              tol *
              b *
              b) {
            roots[0] =
              -b /
                (2 *
                   a);
            return 1;
        }
        if (det <
              0)
            return 0;
        det =
          java.lang.Math.
            sqrt(
              det);
        double w =
          -(b +
              matchSign(
                det,
                b));
        roots[0] =
          2 *
            c /
            w;
        roots[1] =
          w /
            (2 *
               a);
        return 2;
    }
    public static double matchSign(double a, double b) {
        if (b <
              0)
            return a <
              0
              ? a
              : -a;
        return a >
          0
          ? a
          : -a;
    }
    public static int solveCubic(double a3, double a2,
                                 double a1,
                                 double a0,
                                 double[] roots) {
        double[] dRoots =
          { 0,
        0 };
        int dCnt =
          solveQuad(
            3 *
              a3,
            2 *
              a2,
            a1,
            dRoots);
        double[] yVals =
          { 0,
        0,
        0,
        0 };
        double[] tVals =
          { 0,
        0,
        0,
        0 };
        int yCnt =
          0;
        yVals[yCnt] =
          a0;
        tVals[yCnt++] =
          0;
        double r;
        switch (dCnt) {
            case 1:
                r =
                  dRoots[0];
                if (r >
                      0 &&
                      r <
                      1) {
                    yVals[yCnt] =
                      ((a3 *
                          r +
                          a2) *
                         r +
                         a1) *
                        r +
                        a0;
                    tVals[yCnt++] =
                      r;
                }
                break;
            case 2:
                if (dRoots[0] >
                      dRoots[1]) {
                    double t =
                      dRoots[0];
                    dRoots[0] =
                      dRoots[1];
                    dRoots[1] =
                      t;
                }
                r =
                  dRoots[0];
                if (r >
                      0 &&
                      r <
                      1) {
                    yVals[yCnt] =
                      ((a3 *
                          r +
                          a2) *
                         r +
                         a1) *
                        r +
                        a0;
                    tVals[yCnt++] =
                      r;
                }
                r =
                  dRoots[1];
                if (r >
                      0 &&
                      r <
                      1) {
                    yVals[yCnt] =
                      ((a3 *
                          r +
                          a2) *
                         r +
                         a1) *
                        r +
                        a0;
                    tVals[yCnt++] =
                      r;
                }
                break;
            default:
                break;
        }
        yVals[yCnt] =
          a3 +
            a2 +
            a1 +
            a0;
        tVals[yCnt++] =
          1.0;
        int ret =
          0;
        for (int i =
               0;
             i <
               yCnt -
               1;
             i++) {
            double y0 =
              yVals[i];
            double t0 =
              tVals[i];
            double y1 =
              yVals[i +
                      1];
            double t1 =
              tVals[i +
                      1];
            if (y0 <
                  0 &&
                  y1 <
                  0)
                continue;
            if (y0 >
                  0 &&
                  y1 >
                  0)
                continue;
            if (y0 >
                  y1) {
                double t;
                t =
                  y0;
                y0 =
                  y1;
                y1 =
                  t;
                t =
                  t0;
                t0 =
                  t1;
                t1 =
                  t;
            }
            if (-y0 <
                  tol *
                  y1) {
                roots[ret++] =
                  t0;
                continue;
            }
            if (y1 <
                  -tol *
                  y0) {
                roots[ret++] =
                  t1;
                i++;
                continue;
            }
            double epsZero =
              tol *
              (y1 -
                 y0);
            int cnt;
            for (cnt =
                   0;
                 cnt <
                   20;
                 cnt++) {
                double dt =
                  t1 -
                  t0;
                double dy =
                  y1 -
                  y0;
                double t =
                  t0 +
                  (java.lang.Math.
                     abs(
                       y0 /
                         dy) *
                     99 +
                     0.5) *
                  dt /
                  100;
                double v =
                  ((a3 *
                      t +
                      a2) *
                     t +
                     a1) *
                  t +
                  a0;
                if (java.lang.Math.
                      abs(
                        v) <
                      epsZero) {
                    roots[ret++] =
                      t;
                    break;
                }
                if (v <
                      0) {
                    t0 =
                      t;
                    y0 =
                      v;
                }
                else {
                    t1 =
                      t;
                    y1 =
                      v;
                }
            }
            if (cnt ==
                  20)
                roots[ret++] =
                  (t0 +
                     t1) /
                    2;
        }
        return ret;
    }
    public AbstractSegment() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yncQ9cn85Nim3zgH6/8oij8BWMF3sWLy");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("llGeOhodY/3a29Xwk+D61AHWT30HsV7ZH0W5i4ZPqPnPzoH+raL4RuHOhZrJ" +
       "RLaUM3r+328FexpXbpw5wlecQXrkjtPC+xOuymdevXHt3a/O/t0+xTs8hXp9" +
       "WLmmJ45z8sjIieerQajpVsn+9f0BkqC4XbgaVx47d/6JK5eLW8H1hSv7Ntfj" +
       "yiNv1gbkMqA8SX0fyE/uRl0cCElPUd6IKzfPUoLJsryfpHsQiP6YDiRW+4eT" +
       "JGBavQRIiseHg8OJ9sT5gf2pnPTCiS+dAyMs9ffgt9PfUZOTB+gKEZQnwQ+/" +
       "ZJL9WfAXlM++yrA/8kbzF/YH+BRHyvOil2sg7d6fJTxIu0+ePznb22FfV3vP" +
       "ffP+X73+7OGX2/17ho8d4gRvT9z9hBzlBnF5pi3/x+/+h+//xVf/oDzc8/8B" +
       "F73pQKIvAAA=");
}
