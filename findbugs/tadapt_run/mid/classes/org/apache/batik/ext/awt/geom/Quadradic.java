package org.apache.batik.ext.awt.geom;
public class Quadradic extends org.apache.batik.ext.awt.geom.AbstractSegment {
    public java.awt.geom.Point2D.Double p1;
    public java.awt.geom.Point2D.Double p2;
    public java.awt.geom.Point2D.Double p3;
    public Quadradic() { super();
                         p1 = new java.awt.geom.Point2D.Double();
                         p2 = new java.awt.geom.Point2D.Double();
                         p3 = new java.awt.geom.Point2D.Double(); }
    public Quadradic(double x1, double y1, double x2, double y2, double x3,
                     double y3) { super();
                                  p1 = new java.awt.geom.Point2D.Double(x1,
                                                                        y1);
                                  p2 = new java.awt.geom.Point2D.Double(x2,
                                                                        y2);
                                  p3 = new java.awt.geom.Point2D.Double(x3,
                                                                        y3);
    }
    public Quadradic(java.awt.geom.Point2D.Double p1, java.awt.geom.Point2D.Double p2,
                     java.awt.geom.Point2D.Double p3) { super();
                                                        this.p1 =
                                                          p1;
                                                        this.p2 =
                                                          p2;
                                                        this.p3 =
                                                          p3; }
    public java.lang.Object clone() { return new org.apache.batik.ext.awt.geom.Quadradic(
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
                                            y)); }
    public org.apache.batik.ext.awt.geom.Segment reverse() {
        return new org.apache.batik.ext.awt.geom.Quadradic(
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
                           double[] minMax) { if (p3 > p1) {
                                                  minMax[0] =
                                                    p1;
                                                  minMax[1] =
                                                    p3;
                                              }
                                              else {
                                                  minMax[0] =
                                                    p3;
                                                  minMax[1] =
                                                    p1;
                                              }
                                              double a = p1 -
                                                2 *
                                                p2 +
                                                p3;
                                              double b = p2 -
                                                p1;
                                              if (a == 0)
                                                  return;
                                              double tv =
                                                b /
                                                a;
                                              if (tv <= 0 ||
                                                    tv >=
                                                    1) return;
                                              tv = ((p1 -
                                                       2 *
                                                       p2 +
                                                       p3) *
                                                      tv +
                                                      2 *
                                                      (p2 -
                                                         p1)) *
                                                     tv +
                                                     p1;
                                              if (tv < minMax[0])
                                                  minMax[0] =
                                                    tv;
                                              else
                                                  if (tv >
                                                        minMax[1])
                                                      minMax[1] =
                                                        tv;
    }
    public double minX() { double[] minMax = { 0, 0 };
                           getMinMax(p1.x, p2.x, p3.x, minMax);
                           return minMax[0]; }
    public double maxX() { double[] minMax = { 0, 0 };
                           getMinMax(p1.x, p2.x, p3.x, minMax);
                           return minMax[1]; }
    public double minY() { double[] minMax = { 0, 0 };
                           getMinMax(p1.y, p2.y, p3.y, minMax);
                           return minMax[0]; }
    public double maxY() { double[] minMax = { 0, 0 };
                           getMinMax(p1.y, p2.y, p3.y, minMax);
                           return minMax[1]; }
    public java.awt.geom.Rectangle2D getBounds2D() { double[] minMaxX =
                                                       { 0,
                                                     0 };
                                                     getMinMax(
                                                       p1.
                                                         x,
                                                       p2.
                                                         x,
                                                       p3.
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
        2 *
          (p2.
             y -
             p1.
               y),
        p1.
          y -
          2 *
          p2.
            y +
          p3.
            y };
        return java.awt.geom.QuadCurve2D.
          solveQuadratic(
            eqn,
            roots);
    }
    public java.awt.geom.Point2D.Double evalDt(double t) {
        double x =
          2 *
          (p1.
             x -
             2 *
             p2.
               x +
             p3.
               x) *
          t +
          2 *
          (p2.
             x -
             p1.
               x);
        double y =
          2 *
          (p1.
             y -
             2 *
             p2.
               y +
             p3.
               y) *
          t +
          2 *
          (p2.
             y -
             p1.
               y);
        return new java.awt.geom.Point2D.Double(
          x,
          y);
    }
    public java.awt.geom.Point2D.Double eval(double t) {
        double x =
          ((p1.
              x -
              2 *
              p2.
                x +
              p3.
                x) *
             t +
             2 *
             (p2.
                x -
                p1.
                  x)) *
          t +
          p1.
            x;
        double y =
          ((p1.
              y -
              2 *
              p2.
                y +
              p3.
                y) *
             t +
             2 *
             (p2.
                y -
                p1.
                  y)) *
          t +
          p1.
            y;
        return new java.awt.geom.Point2D.Double(
          x,
          y);
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
            0.5 *
            dt *
            dp1.
              x,
          np1.
            y +
            0.5 *
            dt *
            dp1.
              y);
        java.awt.geom.Point2D.Double np3 =
          eval(
            t1);
        return new org.apache.batik.ext.awt.geom.Quadradic(
          np1,
          np2,
          np3);
    }
    public void subdivide(org.apache.batik.ext.awt.geom.Quadradic q0,
                          org.apache.batik.ext.awt.geom.Quadradic q1) {
        if (q0 ==
              null &&
              q1 ==
              null)
            return;
        double x =
          (p1.
             x -
             2 *
             p2.
               x +
             p3.
               x) *
          0.25 +
          (p2.
             x -
             p1.
               x) +
          p1.
            x;
        double y =
          (p1.
             y -
             2 *
             p2.
               y +
             p3.
               y) *
          0.25 +
          (p2.
             y -
             p1.
               y) +
          p1.
            y;
        double dx =
          (p1.
             x -
             2 *
             p2.
               x +
             p3.
               x) *
          0.25 +
          (p2.
             x -
             p1.
               x) *
          0.5;
        double dy =
          (p1.
             y -
             2 *
             p2.
               y +
             p3.
               y) *
          0.25 +
          (p2.
             y -
             p1.
               y) *
          0.5;
        if (q0 !=
              null) {
            q0.
              p1.
              x =
              p1.
                x;
            q0.
              p1.
              y =
              p1.
                y;
            q0.
              p2.
              x =
              x -
                dx;
            q0.
              p2.
              y =
              y -
                dy;
            q0.
              p3.
              x =
              x;
            q0.
              p3.
              y =
              y;
        }
        if (q1 !=
              null) {
            q1.
              p1.
              x =
              x;
            q1.
              p1.
              y =
              y;
            q1.
              p2.
              x =
              x +
                dx;
            q1.
              p2.
              y =
              y +
                dy;
            q1.
              p3.
              x =
              p3.
                x;
            q1.
              p3.
              y =
              p3.
                y;
        }
    }
    public void subdivide(double t, org.apache.batik.ext.awt.geom.Quadradic q0,
                          org.apache.batik.ext.awt.geom.Quadradic q1) {
        java.awt.geom.Point2D.Double np =
          eval(
            t);
        java.awt.geom.Point2D.Double npd =
          evalDt(
            t);
        if (q0 !=
              null) {
            q0.
              p1.
              x =
              p1.
                x;
            q0.
              p1.
              y =
              p1.
                y;
            q0.
              p2.
              x =
              np.
                x -
                npd.
                  x *
                t *
                0.5;
            q0.
              p2.
              y =
              np.
                y -
                npd.
                  y *
                t *
                0.5;
            q0.
              p3.
              x =
              np.
                x;
            q0.
              p3.
              y =
              np.
                y;
        }
        if (q1 !=
              null) {
            q1.
              p1.
              x =
              np.
                x;
            q1.
              p1.
              y =
              np.
                y;
            q1.
              p2.
              x =
              np.
                x +
                npd.
                  x *
                (1 -
                   t) *
                0.5;
            q1.
              p2.
              y =
              np.
                y +
                npd.
                  y *
                (1 -
                   t) *
                0.5;
            q1.
              p3.
              x =
              p3.
                x;
            q1.
              p3.
              y =
              p3.
                y;
        }
    }
    public void subdivide(org.apache.batik.ext.awt.geom.Segment s0,
                          org.apache.batik.ext.awt.geom.Segment s1) {
        org.apache.batik.ext.awt.geom.Quadradic q0 =
          null;
        org.apache.batik.ext.awt.geom.Quadradic q1 =
          null;
        if (s0 instanceof org.apache.batik.ext.awt.geom.Quadradic)
            q0 =
              (org.apache.batik.ext.awt.geom.Quadradic)
                s0;
        if (s1 instanceof org.apache.batik.ext.awt.geom.Quadradic)
            q1 =
              (org.apache.batik.ext.awt.geom.Quadradic)
                s1;
        subdivide(
          q0,
          q1);
    }
    public void subdivide(double t, org.apache.batik.ext.awt.geom.Segment s0,
                          org.apache.batik.ext.awt.geom.Segment s1) {
        org.apache.batik.ext.awt.geom.Quadradic q0 =
          null;
        org.apache.batik.ext.awt.geom.Quadradic q1 =
          null;
        if (s0 instanceof org.apache.batik.ext.awt.geom.Quadradic)
            q0 =
              (org.apache.batik.ext.awt.geom.Quadradic)
                s0;
        if (s1 instanceof org.apache.batik.ext.awt.geom.Quadradic)
            q1 =
              (org.apache.batik.ext.awt.geom.Quadradic)
                s1;
        subdivide(
          t,
          q0,
          q1);
    }
    static int count = 0;
    protected double subLength(double leftLegLen,
                               double rightLegLen,
                               double maxErr) { count++;
                                                double dx;
                                                double dy;
                                                dx =
                                                  p3.
                                                    x -
                                                    p1.
                                                      x;
                                                dy =
                                                  p3.
                                                    y -
                                                    p1.
                                                      y;
                                                double cordLen =
                                                  java.lang.Math.
                                                  sqrt(
                                                    dx *
                                                      dx +
                                                      dy *
                                                      dy);
                                                double hullLen =
                                                  leftLegLen +
                                                  rightLegLen;
                                                if (hullLen <
                                                      maxErr)
                                                    return (hullLen +
                                                              cordLen) *
                                                      0.5;
                                                double err =
                                                  hullLen -
                                                  cordLen;
                                                if (err <
                                                      maxErr)
                                                    return (hullLen +
                                                              cordLen) *
                                                      0.5;
                                                org.apache.batik.ext.awt.geom.Quadradic q =
                                                  new org.apache.batik.ext.awt.geom.Quadradic(
                                                  );
                                                double x =
                                                  (p1.
                                                     x +
                                                     2 *
                                                     p2.
                                                       x +
                                                     p3.
                                                       x) *
                                                  0.25;
                                                double y =
                                                  (p1.
                                                     y +
                                                     2 *
                                                     p2.
                                                       y +
                                                     p3.
                                                       y) *
                                                  0.25;
                                                dx =
                                                  0.25 *
                                                    dx;
                                                dy =
                                                  0.25 *
                                                    dy;
                                                q.
                                                  p1.
                                                  x =
                                                  p1.
                                                    x;
                                                q.
                                                  p1.
                                                  y =
                                                  p1.
                                                    y;
                                                q.
                                                  p2.
                                                  x =
                                                  x -
                                                    dx;
                                                q.
                                                  p2.
                                                  y =
                                                  y -
                                                    dy;
                                                q.
                                                  p3.
                                                  x =
                                                  x;
                                                q.
                                                  p3.
                                                  y =
                                                  y;
                                                double midLen =
                                                  0.25 *
                                                  cordLen;
                                                double len =
                                                  q.
                                                  subLength(
                                                    leftLegLen *
                                                      0.5,
                                                    midLen,
                                                    maxErr *
                                                      0.5);
                                                q.
                                                  p1.
                                                  x =
                                                  x;
                                                q.
                                                  p1.
                                                  y =
                                                  y;
                                                q.
                                                  p2.
                                                  x =
                                                  x +
                                                    dx;
                                                q.
                                                  p2.
                                                  y =
                                                  y +
                                                    dy;
                                                q.
                                                  p3.
                                                  x =
                                                  p3.
                                                    x;
                                                q.
                                                  p3.
                                                  y =
                                                  p3.
                                                    y;
                                                len +=
                                                  q.
                                                    subLength(
                                                      midLen,
                                                      rightLegLen *
                                                        0.5,
                                                      maxErr *
                                                        0.5);
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
          p3.
            x -
            p2.
              x;
        dy =
          p3.
            y -
            p2.
              y;
        double rightLegLen =
          java.lang.Math.
          sqrt(
            dx *
              dx +
              dy *
              dy);
        double eps =
          maxErr *
          (leftLegLen +
             rightLegLen);
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
                                         'Q' +
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
                                           y;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "E89VVZz1gWP4z4r/AzB+BFxzMQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XRBKk28rFg9RoD/NLktm5phdiimXh50R2yAb9Ra0poYeXZ+WcWRbGWe9FVKH" +
       "FAGbKUSQDapla2mWK1aKiT3CwHUW3wQm1VmYUw/A6dHCbO22QtVGjED38Xaw" +
       "Npm6XhaWZlZZNlK+bzXUarXfqDb1BN+EDBhTg4a2SjwetkXMZmvppKb07BRu" +
       "2sh6jMlV0qyFCqfzWVkeVttmxR8vlr0WFGJCD3VxqJaupTYni5SRLr1yQ3dI" +
       "LKPhkS6DypWlMJSkgOVHZRYeyrUO7HUVdBAYFuY1OihKGDDEN5asSvKurm5A" +
       "z8KUGaKh7/cWYpSJUB3M9HAVZZoj20dthLYhZulrBDZlVT9g0qrYrJQ5tJM0" +
       "63izG+oi27bwKGs1FXWKQ07NE/oDDpvjmYCzYwqaaOSSWXbIeYZ782xoVFDV" +
       "w6VAijBu5XOjKHGa9gCY2UanQYyiTockrKkTYB5baNEFYRepVPpT2TEEpxxR" +
       "ehnuTuZOfa1saIsD09mYaSJmdSbGDQhvbATMVpvjKiqGTYwKxh0MJekG1KG6" +
       "ve3czRy5L0yavaQSdXpNeDmm4u00ijSqU9nW0UajbU4amyVa7jTXQ9nuThOU" +
       "TedznBdV4JSjeaBqHooamB6lFoLV/QVUVyi8LQYcLoGlMay6+hpmw4nFjEVb" +
       "3dQEcT6YLuOK45DVxSqarSJ7OcHFtIm0y1x13JzVhd6iswCxtlwN3ZCrs7bQ" +
       "YgIjzce6s8J0prZZtBwUa2+iUJrwmO16ZTscxSihCT0j6goyw08adAesh7Im" +
       "OwlUbCLo6Mi15sGQF5Z8xZTIITnrQJ4dRmHUncozCZiUNJVbth5bpBCFnkOG" +
       "kqG2m5gozrewMR3Wt/UIwretcquTbZkRjuev137+2l773Vu84Tw8FLR00Lzg" +
       "Q9fwZi87bc+n+F0onThIcuz98LH9lFK+lfbI1c76FNton3ruhRdV7iX43P5e" +
       "Ticp3Zb4wTscbaU5x5rKt7OfuvrWDFMcdTraH/m95/7rQ+N3me+/hiMTj53g" +
       "82STv8a8/PvdH1V+9lzp/OFuyRWHsC6v");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "+4cv/klxHPv/AQtLYI5qPwAA");
}
