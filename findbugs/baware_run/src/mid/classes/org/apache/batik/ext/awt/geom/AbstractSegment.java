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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3MI9bxi4vEOL8Z+h/wKfug4RciMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Wl5vSZfrRCJVmEoLljF3iQYymmUbiUSj2ImridLtGBJRD7jO1DaHmY1Myr0p" +
       "JgzQypQZsqIC63OthrXkbNTv6sMJFUebWReD6aFeaQPJahXSQybZULBW9WUr" +
       "GLIh3Jw4CLGRZTwVZy21NmlrnS4j0SqzaIeqQvHyFrIdZ0pMxIpjaM0JHHf0" +
       "HrMNTY6mtVocR1PB6o1VZ7yEEWTslNdaRVoYeBo0CRzl9CqeUDjaw6kEEuee" +
       "LqsKslSxame51jaGRK5WpmeGUXkhrcudpDVqQliHmm7wMjFuuag4EUS7Mdrg" +
       "FVmpMS7JD0QCM/lNNIBmOJUOph5JcisvqAnjRnkeKmA7WrKdLUJYmBR101pZ" +
       "QyW0LMX9TMJUGelzUZ2ejnitkQTjLjsaIcqsmow2FU+quiwkku4WUdXuUCDg" +
       "zRgiXW+xNZzZaNicqFpnGfabHWVspSuysUVbboRuVs0ttp41BzOTbKKQs5bL" +
       "MTN2lLZQDkY2imbItCNQkz65arHrkLB7y7EWUFV71d6mFl8hu6RJTRt9Mpwz" +
       "QWJW+m7Cymzbq7ZXE1ZftNYDWDErWuJvxtOAr7AyN1xnEDsesxI5sZNesPCH" +
       "BrecLrOWyXo4E3CkNmOyNFaSruONuHbY6pvJdtxjGQema4yl2G1p5ayAZvJJ" +
       "6jaW1VmA9OZEtKbrIdLu2nxlskBNwHE0oJtoWWkgquNsFXhu+AQWZvaiJa/H" +
       "ECyEDALNbB0xsw1nh5NRjxXa2KqKgKB41AjWCVUderDWQBweIvG2zuRqa7Sa" +
       "bYgQ+QVE8Iw/YQcsyrK1RGBtiZiPJ5HnMEsz9UZ2WXGwQR8acGs9lR1dMUdh" +
       "eTOZ9jMt3WJuNi3DG24C14gsxqfKeib6tMazaY2W9Q6W+joruxO6WWmFChQt" +
       "fX3BONuwgw4q6y5D+kpzZUfbBWGo6rjMwLGNUmizgWS+ldaWkyoBLbltuyxm" +
       "WLu1WhKdCT7mTIxfyNp60O8La8EZaLLk9ab+us+ym3IvgFcjDxn2aJ4gyGbd" +
       "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" +
       "fRtpvbxLMbmDhE+J+c/PIf07efFnuTnn");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("YiZi0ZD25Pw/3wztaVS6vpeal+cWPXJbhvAuq1X6/KvXr7771fm/2YV/R5mn" +
       "14alq2psWadTQU7Vr3iBohoF+td2iSFe/rpwJSo9du7+E5Uu5a8c6wuXd2Ou" +
       "RaVH7jYGxDKgPA19H4hP7gSdJ3qkZyCvR6Ub+5Bgsyzep+EeBKw/gQOB1a5y" +
       "GgRsqxcBSF592DvaaE/lBeyybdILp76CDpWwkN+D301+x0NOJ8blLCiyv4++" +
       "cuJd/vcL0hde7dM/8kbjF3aJeZIlZFk+y1UQku9yBA9D8tN5JfuzHc11hXru" +
       "2/f/6rVnj77q7t8hfGIQp3B74s6Zbx3bi4pctewfvPvvfeAXX/2DImnn/wI2" +
       "fl4Kli8AAA==");
}
