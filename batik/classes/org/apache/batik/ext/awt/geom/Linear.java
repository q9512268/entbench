package org.apache.batik.ext.awt.geom;
public class Linear implements org.apache.batik.ext.awt.geom.Segment {
    public java.awt.geom.Point2D.Double p1;
    public java.awt.geom.Point2D.Double p2;
    public Linear() { super();
                      p1 = new java.awt.geom.Point2D.Double();
                      p2 = new java.awt.geom.Point2D.Double(); }
    public Linear(double x1, double y1, double x2, double y2) { super();
                                                                p1 = new java.awt.geom.Point2D.Double(
                                                                       x1,
                                                                       y1);
                                                                p2 =
                                                                  new java.awt.geom.Point2D.Double(
                                                                    x2,
                                                                    y2);
    }
    public Linear(java.awt.geom.Point2D.Double p1, java.awt.geom.Point2D.Double p2) {
        super(
          );
        this.
          p1 =
          p1;
        this.
          p2 =
          p2;
    }
    public java.lang.Object clone() { return new org.apache.batik.ext.awt.geom.Linear(
                                        new java.awt.geom.Point2D.Double(
                                          p1.
                                            x,
                                          p1.
                                            y),
                                        new java.awt.geom.Point2D.Double(
                                          p2.
                                            x,
                                          p2.
                                            y));
    }
    public org.apache.batik.ext.awt.geom.Segment reverse() {
        return new org.apache.batik.ext.awt.geom.Linear(
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
    public double minX() { if (p1.x < p2.
                                        x)
                               return p1.
                                        x;
                           return p2.x; }
    public double maxX() { if (p1.x > p2.
                                        x)
                               return p1.
                                        x;
                           return p2.x; }
    public double minY() { if (p1.y < p2.
                                        y)
                               return p1.
                                        y;
                           return p2.y; }
    public double maxY() { if (p1.y > p2.
                                        y)
                               return p2.
                                        y;
                           return p1.y; }
    public java.awt.geom.Rectangle2D getBounds2D() {
        double x;
        double y;
        double w;
        double h;
        if (p1.
              x <
              p2.
                x) {
            x =
              p1.
                x;
            w =
              p2.
                x -
                p1.
                  x;
        }
        else {
            x =
              p2.
                x;
            w =
              p1.
                x -
                p2.
                  x;
        }
        if (p1.
              y <
              p2.
                y) {
            y =
              p1.
                y;
            h =
              p2.
                y -
                p1.
                  y;
        }
        else {
            y =
              p2.
                y;
            h =
              p1.
                y -
                p2.
                  y;
        }
        return new java.awt.geom.Rectangle2D.Double(
          x,
          y,
          w,
          h);
    }
    public java.awt.geom.Point2D.Double evalDt(double t) {
        double x =
          p2.
            x -
          p1.
            x;
        double y =
          p2.
            y -
          p1.
            y;
        return new java.awt.geom.Point2D.Double(
          x,
          y);
    }
    public java.awt.geom.Point2D.Double eval(double t) {
        double x =
          p1.
            x +
          t *
          (p2.
             x -
             p1.
               x);
        double y =
          p1.
            y +
          t *
          (p2.
             y -
             p1.
               y);
        return new java.awt.geom.Point2D.Double(
          x,
          y);
    }
    public org.apache.batik.ext.awt.geom.Segment.SplitResults split(double y) {
        if (y ==
              p1.
                y ||
              y ==
              p2.
                y)
            return null;
        if (y <=
              p1.
                y &&
              y <=
              p2.
                y)
            return null;
        if (y >=
              p1.
                y &&
              y >=
              p2.
                y)
            return null;
        double t =
          (y -
             p1.
               y) /
          (p2.
             y -
             p1.
               y);
        org.apache.batik.ext.awt.geom.Segment[] t0 =
          { getSegment(
              0,
              t) };
        org.apache.batik.ext.awt.geom.Segment[] t1 =
          { getSegment(
              t,
              1) };
        if (p2.
              y <
              y)
            return new org.apache.batik.ext.awt.geom.Segment.SplitResults(
              t0,
              t1);
        return new org.apache.batik.ext.awt.geom.Segment.SplitResults(
          t1,
          t0);
    }
    public org.apache.batik.ext.awt.geom.Segment getSegment(double t0,
                                                            double t1) {
        java.awt.geom.Point2D.Double np1 =
          eval(
            t0);
        java.awt.geom.Point2D.Double np2 =
          eval(
            t1);
        return new org.apache.batik.ext.awt.geom.Linear(
          np1,
          np2);
    }
    public org.apache.batik.ext.awt.geom.Segment splitBefore(double t) {
        return new org.apache.batik.ext.awt.geom.Linear(
          p1,
          eval(
            t));
    }
    public org.apache.batik.ext.awt.geom.Segment splitAfter(double t) {
        return new org.apache.batik.ext.awt.geom.Linear(
          eval(
            t),
          p2);
    }
    public void subdivide(org.apache.batik.ext.awt.geom.Segment s0,
                          org.apache.batik.ext.awt.geom.Segment s1) {
        org.apache.batik.ext.awt.geom.Linear l0 =
          null;
        org.apache.batik.ext.awt.geom.Linear l1 =
          null;
        if (s0 instanceof org.apache.batik.ext.awt.geom.Linear)
            l0 =
              (org.apache.batik.ext.awt.geom.Linear)
                s0;
        if (s1 instanceof org.apache.batik.ext.awt.geom.Linear)
            l1 =
              (org.apache.batik.ext.awt.geom.Linear)
                s1;
        subdivide(
          l0,
          l1);
    }
    public void subdivide(double t, org.apache.batik.ext.awt.geom.Segment s0,
                          org.apache.batik.ext.awt.geom.Segment s1) {
        org.apache.batik.ext.awt.geom.Linear l0 =
          null;
        org.apache.batik.ext.awt.geom.Linear l1 =
          null;
        if (s0 instanceof org.apache.batik.ext.awt.geom.Linear)
            l0 =
              (org.apache.batik.ext.awt.geom.Linear)
                s0;
        if (s1 instanceof org.apache.batik.ext.awt.geom.Linear)
            l1 =
              (org.apache.batik.ext.awt.geom.Linear)
                s1;
        subdivide(
          t,
          l0,
          l1);
    }
    public void subdivide(org.apache.batik.ext.awt.geom.Linear l0,
                          org.apache.batik.ext.awt.geom.Linear l1) {
        if (l0 ==
              null &&
              l1 ==
              null)
            return;
        double x =
          (p1.
             x +
             p2.
               x) *
          0.5;
        double y =
          (p1.
             y +
             p2.
               y) *
          0.5;
        if (l0 !=
              null) {
            l0.
              p1.
              x =
              p1.
                x;
            l0.
              p1.
              y =
              p1.
                y;
            l0.
              p2.
              x =
              x;
            l0.
              p2.
              y =
              y;
        }
        if (l1 !=
              null) {
            l1.
              p1.
              x =
              x;
            l1.
              p1.
              y =
              y;
            l1.
              p2.
              x =
              p2.
                x;
            l1.
              p2.
              y =
              p2.
                y;
        }
    }
    public void subdivide(double t, org.apache.batik.ext.awt.geom.Linear l0,
                          org.apache.batik.ext.awt.geom.Linear l1) {
        if (l0 ==
              null &&
              l1 ==
              null)
            return;
        double x =
          p1.
            x +
          t *
          (p2.
             x -
             p1.
               x);
        double y =
          p1.
            y +
          t *
          (p2.
             y -
             p1.
               y);
        if (l0 !=
              null) {
            l0.
              p1.
              x =
              p1.
                x;
            l0.
              p1.
              y =
              p1.
                y;
            l0.
              p2.
              x =
              x;
            l0.
              p2.
              y =
              y;
        }
        if (l1 !=
              null) {
            l1.
              p1.
              x =
              x;
            l1.
              p1.
              y =
              y;
            l1.
              p2.
              x =
              p2.
                x;
            l1.
              p2.
              y =
              p2.
                y;
        }
    }
    public double getLength() { double dx =
                                  p2.
                                    x -
                                  p1.
                                    x;
                                double dy =
                                  p2.
                                    y -
                                  p1.
                                    y;
                                return java.lang.Math.
                                  sqrt(
                                    dx *
                                      dx +
                                      dy *
                                      dy);
    }
    public double getLength(double maxErr) {
        return getLength(
                 );
    }
    public java.lang.String toString() { return "M" +
                                         p1.
                                           x +
                                         ',' +
                                         p1.
                                           y +
                                         'L' +
                                         p2.
                                           x +
                                         ',' +
                                         p2.
                                           y;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "oULjXn9Dvlh9A7fhM/wV3576Pw+YcwNgLgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OVLGNN12tw63TFYZF5U3FNloKYuwKq/q4YyRiaxsGjRDQMNRTdAqtSkbs0q8" +
       "qortEC9n40qw1CatkbBgJ4NhTRsv+jWsgRjYlkK7y6i7JFvk1NUaftMFCzFB" +
       "qVQ0PvRor7eh6FF5UFea6MwEqXayhPwG1BCicdpOJK88YelUnpkbwqUSiONY" +
       "X++x42ZApsJ0IVJikk40Wa9KNEUuari6NS0uGRHADlw+qmB8D0weomxTdEtn" +
       "siAY9A2Mn654pwnVcCysVvvO0ghEkDn4Igt3R71Yhu3Mz8IuMQ5UAW2tG4Iq" +
       "rHhtqaYsOt7iQ0lrz5TVeOOgqS8xi4nXbG8cq4ljM2sAJTJSw+rDpDzVE3bO" +
       "zHE838L56OvbWrqv2EU7OQ6xcLC8YPM6do/SG22OF38XSmdeoZ/dHN/tPh8c" +
       "79g9df6LZsGcu6YX5+8lHn2tMxHFO4nPf+SFlwzuV+HDo31yKi7dHfvB33XM" +
       "jemc6jh/N/j0a297D4ojIfu959/7yJ8/LD5rvf91vH9+x5lxnm3yHw9e/oPO" +
       "u/SfOyzddrITfd1hlWsrPXPt/vPF0IzXoSdeswv96Ike7s/F/iC4Kkd6qJzz" +
       "fuO8Ld9zXkO8dE7Zr+TkF+PSHbrje+YNtmZ3+/B7S/ul1/0y59MnYN+aP3wY" +
       "XLUjsLVbD/blc8q+kJNfi0t3hsDQwqhQyPN7aL9+E9AKPT4ArvccQXvPrYf2" +
       "pXPK/kVO/llcut21vUl+39rj+u1bgevZI1zP3npc/+6cst/Nyb/OcanpWVyv" +
       "3ApcrSNcrVuP6z+eU/aHOfnKTl/TM7i+eitwUUe4qFuP6z+fU/bNnPzxTl9n" +
       "cf3JTeDKXWTpSXD1jnD1bj2ub59T9uc5+W9x6U1zM275a8+Iqu1jb/lD174p" +
       "HgF/CTynYx5xFNj/7Caw5x6zODajHGFXbg32gz3D7qX+d88RQPFa7NW4dMHc" +
       "qE67OHkj7uH9r5uFl7/svHoE7+obA+/g8LXhHdyeP/xrYLc5vDPg/uYmwOVq" +
       "K06nmEfgzDcI3D3ngLuUk7tBkI8Cx46P");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("zbb6A2Vzl4W8zsiM1k4cncjk4OLNpgF5vpkcySS5NTI5OsBRyGQvmEfOEcxj" +
       "OXkwLl0Es/oIb862zwkOHrpZnLlhf/AI5wffIN3/yDkQn87JO4HjKnTfMmd+" +
       "eCbvObh8K3T5oSOMH3qDMKLnYKznBAJqLDDis3h3WOUUxMpNQCwOZsDg+sQR" +
       "xE/ccnN9viAFlvedgzO36oNn4vxYumbYG9vYJexnTxdsfNvYQ3/vzUJ/Blwv" +
       "HkF/8dZAv22/5G2dwc+dg5/PSe80/vzBPsoe9G8WKwSuzx1h/dwtV/OlghRQ" +
       "fvwcmD+ZE/kcmOObhdkE15ePYH75jVHpKazzc7DaOdHOwarfbDL8w+D62hHW" +
       "r90arKcBROeUrXPiAXAgvDCmN999w7DPiA/8WwHu60fgvn5rwF3neT90DsIP" +
       "5yQ7B+EHbhZhnh1+4wjhN269+j55Ttk/zMlH49Jdsb8/oLbZY/vY6zrOCVLn" +
       "3ZcY+bHyh677smv3NZL+hZfuvevBl6Q/Lj5GOPli6G6mdNds7TinzzWeur8Q" +
       "hObMLrDevTvlGBQAXohLj56b5IFgkf/LB3vw87s6vxCXHnqtOnHpNkBPc/9S" +
       "XHrbjbgBJ6CnOT8bly6d5QQZafH/NN+vgDC+5wNC292cZvlHoHXAkt9+vjCE" +
       "z6W7LcqHTttRkbrf//1UdFLl9DcPOdziC73jXcH17hu9q/oXX+qxH3i1/qu7" +
       "by50R82yvJW7mNKdu88/ikbzncUnXrO147Yu0O/+3j2/dfdTx7ug9+wGvLfp" +
       "U2N7x40/cCDdIC4+Sci+9OBvv/fXXvpmcZDx/wPqrBRJOjkAAA==");
}
