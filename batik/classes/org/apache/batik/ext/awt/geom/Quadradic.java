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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "f8W3f/4XMm7rTG4zAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "R7JxrKp8C/ypq2/nUMURqKM9ld977r8/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("NH+X+v5rOGbx2Ak+T1b5q9TLv9//YfFnzpXOH+6wXHE46/JCT1++r3K7Jweh" +
       "Z80v21155FCy9+USewBczX3JNk+u1h/13ZlbB2dsr336jLzP5smv5Gv8hm3J" +
       "pyye7/aXjnTnV695p/KlQ7D35y8fAtc798G+88aD/dwZeZ/Pk98KSrd4QNE8" +
       "/xDuk2cfFWLkjSlbx2Tw29chgzsPOhnblwF6LTIAvDueFvHAUZ4miJsKqpvy" +
       "x2O70cCKnry6FRWnN3ab9S/+0uNf/YkXH/+z4gDErZrP8l7H25xypO9YmW+/" +
       "/Mo3v3bXI58pDgndJPD+Ts1PnoW88qjjZScYCzR3Hgopl2fpbnBt9oVU/Acl" +
       "/TqPnAmeJm1kiGH7PRm1rSg/yknxgacl+eFXUEu3IDg44fa32Vyy66qDntzb" +
       "9ffR3sxXD7btvna6apw7HBEOB4MLhmxtducEP5Anf7i/i5jXf25X6MAC7j8y" +
       "eDR3BPnBoIO83cE4zb50eFQWZCancvrSjtOisWPjyGvZ7Ctn5P1ZnvzHAwe1" +
       "g3EG+Z8nu/9/fQbNf8mTfwnGnI0cUJpF8cmp22iRrUlHNv+l67D5wsm/AVyr" +
       "fXVe3Xi/97/OyPvLPPkfAJKpWasjPStw/c8bgeu9+7jee+Nxfe/qeXtFFX+T" +
       "4+KTk7i+eyNwCfu4hBuOa++OM/LuypMLu/5aX45r75Ybgesyt3pjcT1wRt4b" +
       "8+S+XX+dxHX/deDK46fSW8Bl7OMybjyux8/Iyx3c3qNB6Q7gUMBs1pJ8BDvw" +
       "nm+8/IzUDAwgwMsa8j5Fgf2x6+3TH8qz97HH14IdOEHHswPAlCydKoJzR4NL" +
       "EUz8YQEYOUMYtTx5O6hYAZH+zLZ3cdMHjtC+4zrQ5sFj6U3genYf7bM3pqf3" +
       "jgiKw3t7Zxze23tPnrTB+CpHvIEVB2DmR/Cu/SjfCXj53Oq5fXjP/YDgDc+A" +
       "R+ZJPgDm8E6A611v9P8IuJ7fB/f8jQF3UkV3CNkzEOZjxd40KN0O7HU/uM/J" +
       "vnCEc3YdOIsDWHVwfWIf5yduOM6LRVJgEc7AKeXJe4P8sx1B0iJNKuKnbxzB" +
       "fN/1wnw3uD63D/NzNwbm+aMFju4JrNYZWPM297QzsG6vF2sFXF/fx/r1G96l" +
       "XyiSAkp2Bsw8kN8Lz4AZXS/Mp8H1F/sw/+IH06XHsP70GVifz5MPnoH1uevA" +
       "+vr8Ze5qX93H+uo1Yt2Dvy+sx1zSz5yB9YU8+Yc7rOThtO1YfPSRGxAj7D24" +
       "K7v7v/5+PQ7gxTPy/kme/PxuwnUquE/cCHAP74N7+MaAu2LM/NQZCF/Ok5fO" +
       "QPhL14sQhAZ7T+0jfOrGd99vnZH3O3ny60Hp1sA+Okr7oSNsv3FNx/WBkA6/" +
       "vcs/JHrwio96dx+iip958Z5bH3hx8e92K0sHH4veRpZuVULDOH50/dj9BceT" +
       "Fa2Ae9vuILtTYPhCUHrkzFU+EO/kfzm/e7+7K/PPg9KDVysTlM6D9Dj1l4LS" +
       "606jBpQgPU755aB08SRlULq5+D9O9xUQoRzRgXhzd3Oc5KugdkCS3/6b3bII" +
       "mHK84+zlzI7gBx4vHkQ+yW7p5sHjulfMoO97rW49tt7/+GXri8XX3Acr6uHu" +
       "e+5nxM++OBz/+HcaL+0+yxMNPiv2Lm4lS7fsvhAsKs1X5d981doO6roweNt3" +
       "7/6125482EG4e8fwkR0c4+2x07+Bw00nKL5ay37ngX/6o7/84p8Ux7T/PwvV" +
       "CXtmPwAA");
}
