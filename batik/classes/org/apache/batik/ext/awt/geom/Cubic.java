package org.apache.batik.ext.awt.geom;
public class Cubic extends org.apache.batik.ext.awt.geom.AbstractSegment {
    public java.awt.geom.Point2D.Double p1;
    public java.awt.geom.Point2D.Double p2;
    public java.awt.geom.Point2D.Double p3;
    public java.awt.geom.Point2D.Double p4;
    public Cubic() { super();
                     p1 = new java.awt.geom.Point2D.Double();
                     p2 = new java.awt.geom.Point2D.Double();
                     p3 = new java.awt.geom.Point2D.Double();
                     p4 = new java.awt.geom.Point2D.Double(); }
    public Cubic(double x1, double y1, double x2, double y2, double x3, double y3,
                 double x4,
                 double y4) { super();
                              p1 = new java.awt.geom.Point2D.Double(
                                     x1,
                                     y1);
                              p2 = new java.awt.geom.Point2D.Double(
                                     x2,
                                     y2);
                              p3 = new java.awt.geom.Point2D.Double(
                                     x3,
                                     y3);
                              p4 = new java.awt.geom.Point2D.Double(
                                     x4,
                                     y4); }
    public Cubic(java.awt.geom.Point2D.Double p1, java.awt.geom.Point2D.Double p2,
                 java.awt.geom.Point2D.Double p3,
                 java.awt.geom.Point2D.Double p4) { super(
                                                      );
                                                    this.
                                                      p1 =
                                                      p1;
                                                    this.
                                                      p2 =
                                                      p2;
                                                    this.
                                                      p3 =
                                                      p3;
                                                    this.
                                                      p4 =
                                                      p4;
    }
    public java.lang.Object clone() { return new org.apache.batik.ext.awt.geom.Cubic(
                                        new java.awt.geom.Point2D.Double(
                                          p1.
                                            x,
                                          p1.
                                            y),
                                        new java.awt.geom.Point2D.Double(
                                          p2.
                                            x,
                                          p2.
                                            y),
                                        new java.awt.geom.Point2D.Double(
                                          p3.
                                            x,
                                          p3.
                                            y),
                                        new java.awt.geom.Point2D.Double(
                                          p4.
                                            x,
                                          p4.
                                            y)); }
    public org.apache.batik.ext.awt.geom.Segment reverse() {
        return new org.apache.batik.ext.awt.geom.Cubic(
          new java.awt.geom.Point2D.Double(
            p4.
              x,
            p4.
              y),
          new java.awt.geom.Point2D.Double(
            p3.
              x,
            p3.
              y),
          new java.awt.geom.Point2D.Double(
            p2.
              x,
            p2.
              y),
          new java.awt.geom.Point2D.Double(
            p1.
              x,
            p1.
              y));
    }
    private void getMinMax(double p1, double p2, double p3,
                           double p4,
                           double[] minMax) { if (p4 >
                                                    p1) {
                                                  minMax[0] =
                                                    p1;
                                                  minMax[1] =
                                                    p4;
                                              }
                                              else {
                                                  minMax[0] =
                                                    p4;
                                                  minMax[1] =
                                                    p1;
                                              }
                                              double c0 =
                                                3 *
                                                (p2 -
                                                   p1);
                                              double c1 =
                                                6 *
                                                (p3 -
                                                   p2);
                                              double c2 =
                                                3 *
                                                (p4 -
                                                   p3);
                                              double[] eqn =
                                                { c0,
                                              c1 -
                                                2 *
                                                c0,
                                              c2 -
                                                c1 +
                                                c0 };
                                              int roots =
                                                java.awt.geom.QuadCurve2D.
                                                solveQuadratic(
                                                  eqn);
                                              for (int r =
                                                     0;
                                                   r <
                                                     roots;
                                                   r++) {
                                                  double tv =
                                                    eqn[r];
                                                  if (tv <=
                                                        0 ||
                                                        tv >=
                                                        1)
                                                      continue;
                                                  tv =
                                                    (1 -
                                                       tv) *
                                                      (1 -
                                                         tv) *
                                                      (1 -
                                                         tv) *
                                                      p1 +
                                                      3 *
                                                      tv *
                                                      (1 -
                                                         tv) *
                                                      (1 -
                                                         tv) *
                                                      p2 +
                                                      3 *
                                                      tv *
                                                      tv *
                                                      (1 -
                                                         tv) *
                                                      p3 +
                                                      tv *
                                                      tv *
                                                      tv *
                                                      p4;
                                                  if (tv <
                                                        minMax[0])
                                                      minMax[0] =
                                                        tv;
                                                  else
                                                      if (tv >
                                                            minMax[1])
                                                          minMax[1] =
                                                            tv;
                                              } }
    public double minX() { double[] minMax = { 0,
                           0 };
                           getMinMax(p1.x, p2.x, p3.
                                                   x,
                                     p4.
                                       x,
                                     minMax);
                           return minMax[0]; }
    public double maxX() { double[] minMax = { 0,
                           0 };
                           getMinMax(p1.x, p2.x, p3.
                                                   x,
                                     p4.
                                       x,
                                     minMax);
                           return minMax[1]; }
    public double minY() { double[] minMax = { 0,
                           0 };
                           getMinMax(p1.y, p2.y, p3.
                                                   y,
                                     p4.
                                       y,
                                     minMax);
                           return minMax[0]; }
    public double maxY() { double[] minMax = { 0,
                           0 };
                           getMinMax(p1.y, p2.y, p3.
                                                   y,
                                     p4.
                                       y,
                                     minMax);
                           return minMax[1]; }
    public java.awt.geom.Rectangle2D getBounds2D() {
        double[] minMaxX =
          { 0,
        0 };
        getMinMax(
          p1.
            x,
          p2.
            x,
          p3.
            x,
          p4.
            x,
          minMaxX);
        double[] minMaxY =
          { 0,
        0 };
        getMinMax(
          p1.
            y,
          p2.
            y,
          p3.
            y,
          p4.
            y,
          minMaxY);
        return new java.awt.geom.Rectangle2D.Double(
          minMaxX[0],
          minMaxY[0],
          minMaxX[1] -
            minMaxX[0],
          minMaxY[1] -
            minMaxY[0]);
    }
    protected int findRoots(double y, double[] roots) {
        double[] eqn =
          { p1.
              y -
          y,
        3 *
          (p2.
             y -
             p1.
               y),
        3 *
          (p1.
             y -
             2 *
             p2.
               y +
             p3.
               y),
        3 *
          p2.
            y -
          p1.
            y +
          p4.
            y -
          3 *
          p3.
            y };
        return java.awt.geom.CubicCurve2D.
          solveCubic(
            eqn,
            roots);
    }
    public java.awt.geom.Point2D.Double evalDt(double t) {
        double x =
          3 *
          ((p2.
              x -
              p1.
                x) *
             (1 -
                t) *
             (1 -
                t) +
             2 *
             (p3.
                x -
                p2.
                  x) *
             (1 -
                t) *
             t +
             (p4.
                x -
                p3.
                  x) *
             t *
             t);
        double y =
          3 *
          ((p2.
              y -
              p1.
                y) *
             (1 -
                t) *
             (1 -
                t) +
             2 *
             (p3.
                y -
                p2.
                  y) *
             (1 -
                t) *
             t +
             (p4.
                y -
                p3.
                  y) *
             t *
             t);
        return new java.awt.geom.Point2D.Double(
          x,
          y);
    }
    public java.awt.geom.Point2D.Double eval(double t) {
        double x =
          (1 -
             t) *
          (1 -
             t) *
          (1 -
             t) *
          p1.
            x +
          3 *
          (t *
             (1 -
                t) *
             (1 -
                t) *
             p2.
               x +
             t *
             t *
             (1 -
                t) *
             p3.
               x) +
          t *
          t *
          t *
          p4.
            x;
        double y =
          (1 -
             t) *
          (1 -
             t) *
          (1 -
             t) *
          p1.
            y +
          3 *
          (t *
             (1 -
                t) *
             (1 -
                t) *
             p2.
               y +
             t *
             t *
             (1 -
                t) *
             p3.
               y) +
          t *
          t *
          t *
          p4.
            y;
        return new java.awt.geom.Point2D.Double(
          x,
          y);
    }
    public void subdivide(org.apache.batik.ext.awt.geom.Segment s0,
                          org.apache.batik.ext.awt.geom.Segment s1) {
        org.apache.batik.ext.awt.geom.Cubic c0 =
          null;
        org.apache.batik.ext.awt.geom.Cubic c1 =
          null;
        if (s0 instanceof org.apache.batik.ext.awt.geom.Cubic)
            c0 =
              (org.apache.batik.ext.awt.geom.Cubic)
                s0;
        if (s1 instanceof org.apache.batik.ext.awt.geom.Cubic)
            c1 =
              (org.apache.batik.ext.awt.geom.Cubic)
                s1;
        subdivide(
          c0,
          c1);
    }
    public void subdivide(double t, org.apache.batik.ext.awt.geom.Segment s0,
                          org.apache.batik.ext.awt.geom.Segment s1) {
        org.apache.batik.ext.awt.geom.Cubic c0 =
          null;
        org.apache.batik.ext.awt.geom.Cubic c1 =
          null;
        if (s0 instanceof org.apache.batik.ext.awt.geom.Cubic)
            c0 =
              (org.apache.batik.ext.awt.geom.Cubic)
                s0;
        if (s1 instanceof org.apache.batik.ext.awt.geom.Cubic)
            c1 =
              (org.apache.batik.ext.awt.geom.Cubic)
                s1;
        subdivide(
          t,
          c0,
          c1);
    }
    public void subdivide(org.apache.batik.ext.awt.geom.Cubic c0,
                          org.apache.batik.ext.awt.geom.Cubic c1) {
        if (c0 ==
              null &&
              c1 ==
              null)
            return;
        double npX =
          (p1.
             x +
             3 *
             (p2.
                x +
                p3.
                  x) +
             p4.
               x) *
          0.125;
        double npY =
          (p1.
             y +
             3 *
             (p2.
                y +
                p3.
                  y) +
             p4.
               y) *
          0.125;
        double npdx =
          (p2.
             x -
             p1.
               x +
             2 *
             (p3.
                x -
                p2.
                  x) +
             (p4.
                x -
                p3.
                  x)) *
          0.125;
        double npdy =
          (p2.
             y -
             p1.
               y +
             2 *
             (p3.
                y -
                p2.
                  y) +
             (p4.
                y -
                p3.
                  y)) *
          0.125;
        if (c0 !=
              null) {
            c0.
              p1.
              x =
              p1.
                x;
            c0.
              p1.
              y =
              p1.
                y;
            c0.
              p2.
              x =
              (p2.
                 x +
                 p1.
                   x) *
                0.5;
            c0.
              p2.
              y =
              (p2.
                 y +
                 p1.
                   y) *
                0.5;
            c0.
              p3.
              x =
              npX -
                npdx;
            c0.
              p3.
              y =
              npY -
                npdy;
            c0.
              p4.
              x =
              npX;
            c0.
              p4.
              y =
              npY;
        }
        if (c1 !=
              null) {
            c1.
              p1.
              x =
              npX;
            c1.
              p1.
              y =
              npY;
            c1.
              p2.
              x =
              npX +
                npdx;
            c1.
              p2.
              y =
              npY +
                npdy;
            c1.
              p3.
              x =
              (p4.
                 x +
                 p3.
                   x) *
                0.5;
            c1.
              p3.
              y =
              (p4.
                 y +
                 p3.
                   y) *
                0.5;
            c1.
              p4.
              x =
              p4.
                x;
            c1.
              p4.
              y =
              p4.
                y;
        }
    }
    public void subdivide(double t, org.apache.batik.ext.awt.geom.Cubic c0,
                          org.apache.batik.ext.awt.geom.Cubic c1) {
        if (c0 ==
              null &&
              c1 ==
              null)
            return;
        java.awt.geom.Point2D.Double np =
          eval(
            t);
        java.awt.geom.Point2D.Double npd =
          evalDt(
            t);
        if (c0 !=
              null) {
            c0.
              p1.
              x =
              p1.
                x;
            c0.
              p1.
              y =
              p1.
                y;
            c0.
              p2.
              x =
              (p2.
                 x +
                 p1.
                   x) *
                t;
            c0.
              p2.
              y =
              (p2.
                 y +
                 p1.
                   y) *
                t;
            c0.
              p3.
              x =
              np.
                x -
                npd.
                  x *
                t /
                3;
            c0.
              p3.
              y =
              np.
                y -
                npd.
                  y *
                t /
                3;
            c0.
              p4.
              x =
              np.
                x;
            c0.
              p4.
              y =
              np.
                y;
        }
        if (c1 !=
              null) {
            c1.
              p1.
              x =
              np.
                x;
            c1.
              p1.
              y =
              np.
                y;
            c1.
              p2.
              x =
              np.
                x +
                npd.
                  x *
                (1 -
                   t) /
                3;
            c1.
              p2.
              y =
              np.
                y +
                npd.
                  y *
                (1 -
                   t) /
                3;
            c1.
              p3.
              x =
              (p4.
                 x +
                 p3.
                   x) *
                (1 -
                   t);
            c1.
              p3.
              y =
              (p4.
                 y +
                 p3.
                   y) *
                (1 -
                   t);
            c1.
              p4.
              x =
              p4.
                x;
            c1.
              p4.
              y =
              p4.
                y;
        }
    }
    public org.apache.batik.ext.awt.geom.Segment getSegment(double t0,
                                                            double t1) {
        double dt =
          t1 -
          t0;
        java.awt.geom.Point2D.Double np1 =
          eval(
            t0);
        java.awt.geom.Point2D.Double dp1 =
          evalDt(
            t0);
        java.awt.geom.Point2D.Double np2 =
          new java.awt.geom.Point2D.Double(
          np1.
            x +
            dt *
            dp1.
              x /
            3,
          np1.
            y +
            dt *
            dp1.
              y /
            3);
        java.awt.geom.Point2D.Double np4 =
          eval(
            t1);
        java.awt.geom.Point2D.Double dp4 =
          evalDt(
            t1);
        java.awt.geom.Point2D.Double np3 =
          new java.awt.geom.Point2D.Double(
          np4.
            x -
            dt *
            dp4.
              x /
            3,
          np4.
            y -
            dt *
            dp4.
              y /
            3);
        return new org.apache.batik.ext.awt.geom.Cubic(
          np1,
          np2,
          np3,
          np4);
    }
    private static int count = 0;
    protected double subLength(double leftLegLen,
                               double rightLegLen,
                               double maxErr) { count++;
                                                double cldx;
                                                double cldy;
                                                double cdx;
                                                double cdy;
                                                cldx =
                                                  p3.
                                                    x -
                                                    p2.
                                                      x;
                                                cldy =
                                                  p3.
                                                    y -
                                                    p2.
                                                      y;
                                                double crossLegLen =
                                                  java.lang.Math.
                                                  sqrt(
                                                    cldx *
                                                      cldx +
                                                      cldy *
                                                      cldy);
                                                cdx =
                                                  p4.
                                                    x -
                                                    p1.
                                                      x;
                                                cdy =
                                                  p4.
                                                    y -
                                                    p1.
                                                      y;
                                                double cordLen =
                                                  java.lang.Math.
                                                  sqrt(
                                                    cdx *
                                                      cdx +
                                                      cdy *
                                                      cdy);
                                                double hullLen =
                                                  leftLegLen +
                                                  rightLegLen +
                                                  crossLegLen;
                                                if (hullLen <
                                                      maxErr)
                                                    return (hullLen +
                                                              cordLen) /
                                                      2;
                                                double err =
                                                  hullLen -
                                                  cordLen;
                                                if (err <
                                                      maxErr)
                                                    return (hullLen +
                                                              cordLen) /
                                                      2;
                                                org.apache.batik.ext.awt.geom.Cubic c =
                                                  new org.apache.batik.ext.awt.geom.Cubic(
                                                  );
                                                double npX =
                                                  (p1.
                                                     x +
                                                     3 *
                                                     (p2.
                                                        x +
                                                        p3.
                                                          x) +
                                                     p4.
                                                       x) *
                                                  0.125;
                                                double npY =
                                                  (p1.
                                                     y +
                                                     3 *
                                                     (p2.
                                                        y +
                                                        p3.
                                                          y) +
                                                     p4.
                                                       y) *
                                                  0.125;
                                                double npdx =
                                                  (cldx +
                                                     cdx) *
                                                  0.125;
                                                double npdy =
                                                  (cldy +
                                                     cdy) *
                                                  0.125;
                                                c.
                                                  p1.
                                                  x =
                                                  p1.
                                                    x;
                                                c.
                                                  p1.
                                                  y =
                                                  p1.
                                                    y;
                                                c.
                                                  p2.
                                                  x =
                                                  (p2.
                                                     x +
                                                     p1.
                                                       x) *
                                                    0.5;
                                                c.
                                                  p2.
                                                  y =
                                                  (p2.
                                                     y +
                                                     p1.
                                                       y) *
                                                    0.5;
                                                c.
                                                  p3.
                                                  x =
                                                  npX -
                                                    npdx;
                                                c.
                                                  p3.
                                                  y =
                                                  npY -
                                                    npdy;
                                                c.
                                                  p4.
                                                  x =
                                                  npX;
                                                c.
                                                  p4.
                                                  y =
                                                  npY;
                                                double midLen =
                                                  java.lang.Math.
                                                  sqrt(
                                                    npdx *
                                                      npdx +
                                                      npdy *
                                                      npdy);
                                                double len =
                                                  c.
                                                  subLength(
                                                    leftLegLen /
                                                      2,
                                                    midLen,
                                                    maxErr /
                                                      2);
                                                c.
                                                  p1.
                                                  x =
                                                  npX;
                                                c.
                                                  p1.
                                                  y =
                                                  npY;
                                                c.
                                                  p2.
                                                  x =
                                                  npX +
                                                    npdx;
                                                c.
                                                  p2.
                                                  y =
                                                  npY +
                                                    npdy;
                                                c.
                                                  p3.
                                                  x =
                                                  (p4.
                                                     x +
                                                     p3.
                                                       x) *
                                                    0.5;
                                                c.
                                                  p3.
                                                  y =
                                                  (p4.
                                                     y +
                                                     p3.
                                                       y) *
                                                    0.5;
                                                c.
                                                  p4.
                                                  x =
                                                  p4.
                                                    x;
                                                c.
                                                  p4.
                                                  y =
                                                  p4.
                                                    y;
                                                len +=
                                                  c.
                                                    subLength(
                                                      midLen,
                                                      rightLegLen /
                                                        2,
                                                      maxErr /
                                                        2);
                                                return len;
    }
    public double getLength() { return getLength(
                                         1.0E-6);
    }
    public double getLength(double maxErr) {
        double dx;
        double dy;
        dx =
          p2.
            x -
            p1.
              x;
        dy =
          p2.
            y -
            p1.
              y;
        double leftLegLen =
          java.lang.Math.
          sqrt(
            dx *
              dx +
              dy *
              dy);
        dx =
          p4.
            x -
            p3.
              x;
        dy =
          p4.
            y -
            p3.
              y;
        double rightLegLen =
          java.lang.Math.
          sqrt(
            dx *
              dx +
              dy *
              dy);
        dx =
          p3.
            x -
            p2.
              x;
        dy =
          p3.
            y -
            p2.
              y;
        double crossLegLen =
          java.lang.Math.
          sqrt(
            dx *
              dx +
              dy *
              dy);
        double eps =
          maxErr *
          (leftLegLen +
             rightLegLen +
             crossLegLen);
        return subLength(
                 leftLegLen,
                 rightLegLen,
                 eps);
    }
    public java.lang.String toString() { return "M" +
                                         p1.
                                           x +
                                         ',' +
                                         p1.
                                           y +
                                         'C' +
                                         p2.
                                           x +
                                         ',' +
                                         p2.
                                           y +
                                         ' ' +
                                         p3.
                                           x +
                                         ',' +
                                         p3.
                                           y +
                                         ' ' +
                                         p4.
                                           x +
                                         ',' +
                                         p4.
                                           y;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaDZAUxRXu3fvhuOO4445/OH4PIgi3gBC0zohwgBzswQkK" +
       "8RCOudm+u4HZmWGm925BCWqVQLSkFFGJpZQpIahBsIxWjKJirCiWRMufRI0R" +
       "YqQi0ViRpGKsYDTvdc/uzM7uzLkpd6umd7b7ve5+X7+/7u3Dn5ESyyRjqMYa" +
       "2BaDWg2LNNYqmRaNNamSZV0Fde3yPUXSP9efXX5JmJS2kYHdktUiSxZdrFA1" +
       "ZrWROkWzmKTJ1FpOaQw5Wk1qUbNHYoqutZEhitUcN1RFVliLHqNIsFoyo2SQ" +
       "xJipdCQYbbY7YKQuCjOJ8JlE5nubG6NkgKwbWxzy4S7yJlcLUsadsSxGqqMb" +
       "pR4pkmCKGokqFmtMmuRCQ1e3dKk6a6BJ1rBRnWNDsDQ6JwuCCY9VfXH+9u5q" +
       "DkGtpGk64+JZK6mlqz00FiVVTu0ilcatzeRHpChKKlzEjNRHU4NGYNAIDJqS" +
       "1qGC2VdSLRFv0rk4LNVTqSHjhBgZn9mJIZlS3O6mlc8ZeihjtuycGaQdl5ZW" +
       "SJkl4l0XRvbes7768SJS1UaqFG0VTkeGSTAYpA0ApfEOalrzYzEaayODNFjs" +
       "VdRUJFXZaq90jaV0aRJLwPKnYMHKhEFNPqaDFawjyGYmZKabafE6uULZv0o6" +
       "VakLZB3qyCokXIz1IGC5AhMzOyXQO5uleJOixRgZ6+VIy1i/DAiAtV+csm49" +
       "PVSxJkEFqREqokpaV2QVqJ7WBaQlOiigychI304Ra0OSN0ldtB010kPXKpqA" +
       "qj8HAlkYGeIl4z3BKo30rJJrfT5bfunu67QlWpiEYM4xKqs4/wpgGuNhWkk7" +
       "qUnBDgTjgKnRu6Whz+4KEwLEQzzEguaX15+7fNqY4ycEzagcNCs6NlKZtcsH" +
       "Oga+MbppyiVFOI0yQ7cUXPwMybmVtdotjUkDPMzQdI/Y2JBqPL7ypWtueIR+" +
       "GiblzaRU1tVEHPRokKzHDUWl5hVUo6bEaKyZ9KdarIm3N5N+8B5VNCpqV3R2" +
       "WpQ1k2KVV5Xq/DdA1AldIETl8K5onXrq3ZBYN39PGoSQfvCQAfCMJeLDvxlZ" +
       "HenW4zQiyZKmaHqk1dRRfisCHqcDsO2OdIDWb4pYesIEFYzoZldEAj3opnYD" +
       "WqbUyyJdVI9HmhIdityA+mUUrOckylTbGwoB3KO9xq6CnSzR1Rg12+W9iQWL" +
       "zh1pf1UoEiq/jQYjE2GwBjFYAx+Mu0YYrAEHa+CDkVCIjzEYBxXLCYuxCcwa" +
       "/OqAKavWLd2wa0IR6JHRWwxIFgHphIz40uTYfspht8tHayq3jj8188UwKY6S" +
       "GklmCUnFcDHf7AJHJG+ybXVAB0QeJwCMcwUAjFymLtMY+B+/QGD3Uqb3UBPr" +
       "GRns6iEVntAQI/7BIef8yfF9vTeu3j4jTMKZPh+HLAF3heyt6KnTHrnea+u5" +
       "+q3aefaLo3dv0x2rzwgiqdiXxYkyTPBqgReednnqOOnJ9me31XPY+4NXZhJY" +
       "ETi8Md4xMpxKY8pBoyxlIHCnbsYlFZtSGJezblPvdWq4eg7i74NBLSrQyqrh" +
       "mWCbHf/G1qEGlsOEOqOeeaTgAeAHq4z7333trxdxuFOxosoV5FdR1ujyT9hZ" +
       "DfdEgxy1vcqkFOg+2Nd6512f7VzLdRYoJuYasB7LJvBLsIQA880nNr93+tSB" +
       "t8NpPQ8xCNCJDshzkmkhsZ6UBwgJo0125gP+TQVPgFpTf7UG+ql0KlKHStGw" +
       "vqqaNPPJv+2uFnqgQk1Kjab13YFTP2IBueHV9f8ew7sJyRhfHcwcMuG0a52e" +
       "55umtAXnkbzxzbqfvCzdD+4fXK6lbKXcixKOAeGLNofLP4OXsz1tc7GYZLmV" +
       "P9O+XHlQu3z7259Xrv78uXN8tpmJlHutWySjUagXFpOT0P0wr3NaIlndQDf7" +
       "+PJrq9Xj56HHNuhRBgdrrTDBLSYzNMOmLun3hxdeHLrhjSISXkzKVV2KLZa4" +
       "kZH+oN3U6gaPmjTmXS4Wt7fMVmmSJFnCZ1UgwGNzL92iuME42FufGvbEpYf2" +
       "n+JaZvAu6rIt6AJbuS7IbUFYfg+LC7P10o/Vs4JlfM5lmZ4cveWqRIcFXleJ" +
       "g5H12OnGrNYN8q761jMilRiRg0HQDXkoctvqdzae5CZchn4d63HISpfXBv/v" +
       "8h/VQoRv4BOC52t8cOpYIcJ2TZOdO4xLJw+GgRoxJSDbzxQgsq3m9Kb7zj4q" +
       "BPAmVx5iumvvLd807N4r7FJkoBOzkkA3j8hChThYLMPZjQ8ahXMs/vjotmce" +
       "2rZTzKomM59aBNuFR3//35MN+/70So6wXhrTwTPR9HqGhMdC55q5PEKmhT+u" +
       "OnZ7TdFiCArNpCyhKZsTtDnm7hRyaCvR4VovJ7nlFW7pcG0YCU2FZcCKpcEF" +
       "p7kiwIO0YbGAN12MRZMwrcb/0wqxYr6vac2w7WNG/qblx+oRrZhPpJj/Hs7I" +
       "aO4R0glXqw67nFkL6xfy9UMaV8EnEQuAime57Q5UG74LqETDKF6JZwejM3I7" +
       "fijgpBePvDX3d4fuuLtXKG2ACXr4hv9nhdpx05+/zHL8PJvKYZUe/rbI4ftG" +
       "Nl32Ked30hrkrk9mp8eQGjq8sx6J/ys8ofQ3YdKvjVTL9iZ8taQmMFlog42n" +
       "ldqZw0Y9oz1zEyl2TI3ptG201y24hvUmVG5TK2YZZuXJoabAM97WtfFeNQ0R" +
       "/sICNdWPm5GwMTOtbrWOHiX60iMt/yleh0UPDjkr15DXF2DIG9JDXpRryBsL" +
       "MOTN6SFn5xpyx7cfstYeJjRIkIrvHEPeItael1OxmM5NN8xIP8NUeiBAQnyw" +
       "+FmPJ3GtCeidkRJZT9hnU0vsMIZfLa73KxkpUmwaV9jBn2uSHtFvDRA9mUt9" +
       "+aeUePbtXkc7KuXNTFLnd7TCw+uBm/buj604ODNs+86VDHI83Ziu0h6quroa" +
       "jD1luLwWfpjk+I8PBu756Ff1XQvy2cli3Zg+9qr4eyw4r6n+XtQ7lZdv+mTk" +
       "VZd1b8hjUzrWg5K3y4dbDr9yxWR5T5ifnAnHlnXilsnUmOnOyk3KEqaWmStM" +
       "TK9rDa7XMHguttf1Yq9i9x17/VgDYuXDAW0/x+IAqryqazQVqqt5qEZP3yA8" +
       "vaPMB7+znOSBTIMfCc88W7h5+ePixxog+1MBbU9j8QtwJCYYiWmlkZkUfIq0" +
       "inbFqeaC64kCwIUnemQaPEtsmRcHwOV1jtxF7fa4w4pUJzk684BUIrIj/OnN" +
       "bzP/bUlvifj+WmTf11a89Lz14F8eFzlTrg2X53z3oUNl8vvxl86kXFdzet6j" +
       "cJrjXSAs8YIA05nk709cs9r/s4mvbd8/8UO+cS5TLPBQ4NBynFi7eD4/fPrT" +
       "NyvrjnBPWIz+jhu896g/+yQ/44Cey1SFxUmxgcjaxvDIKAjsoPeGT9DD1wYw" +
       "5E5Fk1Te2zKIfirVusSR8J1YvG44ShYWfCnNrnVsvgl9gZTaVUGbOA9V9Ib0" +
       "vyLQmMw52QccaV53GSyfT4C9nQ5o+xCLP6Z8lBAjgPyMb3pPvDPGn2uSnOtE" +
       "QI9nsfg1RM0uyloUrUXKmQ8U9+hKzLH8Fwtg+TyADIWn3Vb69vwdpR9rgPxf" +
       "BLR9icU5kD6uaD90dJhD8I9CQhCz5YjlD4Efq7+YoaKANu4Mv0YIpKQXgm8K" +
       "CYFiy6HkD4Efa4CY1QFtNVhUCC24JhOC0IBCQqDZcmj5Q+DHGiBmXUDbWCyG" +
       "Cy3wQjCiABBgHskP3ZktB8sfAj/WADGnBrRNw2ISIxXgJxfAFipmzVqYCiEj" +
       "Mk9/VkJSCaFGpTYFh2lyoTQFk4XttqzbA2DKSpbA5xumzmCyNObJmSoD+vRg" +
       "FHYiNM+UXuVoNQYg+QMsZsPoEM1jK3VdZJR7HKjmFAAqzMDJOHh22GLtyF+j" +
       "/Fg9srriLz8WDS0JAAMxCzVBMkN7JHUh/3OIOkgsLBQSY+C5wxbnjvyR8GPt" +
       "C4mrA5BYg0Ur+BhEwoPDlQXAgR/+zITnQVuYB/PHwY/V30aO8YIL3BEARgyL" +
       "dQzP5ztiSo8ijhE+cRBZXyhEGuE5aot1NH9E/Fg9shaJOwZpr+GCRQ+AZTMW" +
       "GwNg2VQoWKbDc8yW7Vj+sPix5laUVFz5Ntc6UOptHJzrA4DDM9NQbwBwyUIB" +
       "Nxeej2zpP8ofOD/WYH0KbXNguTUAltuw2BEAy85CnQjVgV8Miz7Fd16w+LL2" +
       "EZyFF94XgMi9WNzJSDmkOfaBDzdNB5K9BYBkCLZBTArV2nLVBkMSmpuVr/iy" +
       "9uF5XLgcDMDlEBYPCE2Jps8dXGnwTwuY34Xsc6BQ1jlQ35rixxog6+MBbU9g" +
       "8ag4LsiJw5FC4hC1hYnmj4Mfa18py/MBYLyAxdMBYDxTKDAgiQutsyValz8Y" +
       "fqwBsp4MaHsNi5cZKWO6uIGbCmCus3ZXA4fmxHfypzYjJTwK4q2c4Vk3pcXt" +
       "XvnI/qqyYfuvfkecZ6Zu4A6IkrLOhKq6/7F1vZcaJu1UOJYDxP+3/B5E6F1G" +
       "6gLDMmSw+IVTDr0jeN5nZLgfDyNFULqpTzEyOBc1UELppvwQEPZSAiL82013" +
       "Bvy5QwebDfHiJvkYegcSfD1rpJZvenD+Mb/DYqYkp+JEUhySjnKvGT8nGtLX" +
       "Urv+7ZuYcarNr8injtET4pJ8u3x0/9Ll1537/kFxiVBWpa1bsZeKKOkn7jPy" +
       "TvFfsfG+vaX6Kl0y5fzAx/pPSh3CDxITdkxolKPnZD6YjIGqNtJzw86qT1+0" +
       "e+/Apc/9dlfpm2ESWktCEiO1a7PvFiSNhEnq1kazb/Gslkx+9a9xyr1bLpvW" +
       "+ff3+R0yIm79jPanb5ffPrTurT3DD4wJk4pmUgJba5rklx4WbtFWUrnHbCOV" +
       "irUoCVOEXhRJzbgiNBCtQkIL5bjYcFama/EKKiMTsi9IZV/cLVf1XmryIxLs" +
       "pjJKKpwasTKePxYThuFhcGrspcRyNRbLkrgaoKzt0RbDSN0fI/MM7hHW5PLj" +
       "/D/r0Hn+im9f/Q+GgDH/PjMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UrFX+PH3PvOsPPxEdf9gh4qMSndErvcW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "2W+++l/+8K89+6fFUe3/D67PR4wHQAAA");
}
