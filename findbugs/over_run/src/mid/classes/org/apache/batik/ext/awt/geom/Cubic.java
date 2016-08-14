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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jxfeof+s/B9BfdjwJzEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "o0FxBut41+aL7/vvD07ebr37Os51vOGU");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
