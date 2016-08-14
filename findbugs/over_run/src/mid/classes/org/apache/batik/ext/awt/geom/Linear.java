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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fbWmoVcHfoI/Nv8Pu6VCjFcsAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "2+7KC9OhA96NCUxlhPJqgW2d+tbvEAGF1dy5kaouvrSrRkzU60EVQtZyQgpU" +
       "0hnD3UY/XAVlwZps6WW7CWZ/GiSJtIbLgpnGVHuZygzEYWAqhR29Q7l4bS6Z" +
       "kKw0XF4hW1B/IvENjXAh0SBZCLHaDRdtZto2wymam4iL1ZoRmAZCx4yAqpzn" +
       "weJQdBdRQLecQQhhHbLJs2YqbSi8JRCVLOws1TmxEg1W8LUpWyEW4XDiu7ps" +
       "GTjb6TcbrMVzboLCXSWOiI4MMKAbwiRDUUTdBKqABx+bVbg1Egx7A4tTLK1L" +
       "eOuy3A7lEOsxhA4pQM52y0/aNRIPEyLlmGQJZhXp4DUaLTebWdpKqjDtrOIo" +
       "6chzM61QiLjJUsjEWLWOdGU0JniGAquqtlKpaTaaVkdbZEnjRqXGqThEbCeD" +
       "uRGtk9heGWJEE1sYHVRC0hBVqteAB9Jinva2sIyu7BFf1m2HXPgggBKr1J9W" +
       "uiDHmLArQ8WyZN1JgT/jkJC40kRg4zLiKBKGOaswMvV+Q1GpjteukxyS0qaH" +
       "O6ux0MMYAm85QF5okVjdJU7ItWzcDWarsLUi8brriAs6w+v1KVEnuLx3o80T" +
       "PU3xe+FI7/k9cmYSmJVRCbxQWxkaUl133hzZGy9IJaayWCGbqmJ6aAoHaLPP" +
       "tMdcl6W1bjlgEajNECzQbZvvVdKGPGIrsr7ldYtvVZtc3arVTH0lbycJq24b" +
       "WNRyF8ORsTI6LX7kL5SsOtp0XYtx/JrnUHZNRqBaJM/CSFV8Y7ymvd5UVDUv" +
       "Lo/b89HIY+Oh4W+XTG1jzX0ZLU/iZQ1bzxYY09VmUKquy2rT7EwaLQ6bor7A" +
       "qWbLhJNogmYCz4XBRuc7ijXojFpQexzrYzZqr+B+h9umPIAOseMBs2pM8Vin" +
       "NLpFV2DVaZWzqIc7EMf0eKQhpHOLQ9dzNEhTm/NEru7POz5ptlqMPxrVs3YT" +
       "J7eeu3DxZlRdZGWu3+DwTYfDx60519BsdSPMG8O4LbXpOZ9miygbbFmkvuYi" +
       "DzEsu1IXO7Na5C4FZDxtpDYOi3ZruyHJdeYraoXQyrKHdiNviCa0AQearenR" +
       "QJoayjaCF0ONM5V+bLZW69kSmW+W800AK0Nc1ZqhU/c1QTTLYyBrla+AucJx" +
       "EQZ3M1+M+Snvy97GqvqB0LTImm/Ger1aIakFlMJ6K/RZXzIa7MZVZklmrXFH" +
       "7G1ST2+ZlGZpnjbaMMh80DDMWVlZDxSTIRSxocHmxBnWtRDMyQacrbyQmrle" +
       "V+MCGkpFLYG1pWC7M5nU3D402rSYuDHDTUIOURT94Xz75aOvb1vovmIH7PiY" +
       "g2k184rN69j5SW+2sV38XSydejV+emN7t3N8cLTb9tTZL4mnqm6rTpS/U3j0" +
       "tc46FO8TPveRF15Sxr+EXDjc4yai0t2R6/2QpW5U68TA+Xu9p197y5oujnrs" +
       "943/4CN/+TD37Or9r+Pd8TtOyXm6y39Ov/xHvXfJ//RC6bbjXeQbDqFc3+iZ" +
       "6/eOLwVqFAcOd90O8qPHdrg/V/uD4IIP7QCf8W7irO3aM14hvHRG3S/m5Oei" +
       "0h2y5TrqTbZVd3voe0/7+df9IuZTx2Dfmhc+DK76Idj6+YN9+Yy6z+fkl6PS" +
       "nSADVIOwMMjze2i/cgvQCjs+AK73HEJ7z/lD+50z6v5lTn4jKt1uG848v8f2" +
       "uH7zPHA9e4jr2fPH9W/PqPv9nPxejktKT+N65TxwYYe4sPPH9R/OqPvjnHxp" +
       "Z6/FKVxfPg9cxCEu4vxx/acz6r6ekz/d2es0rj+7BVx5iCw9Ca7BIa7B+eP6" +
       "5hl1f5mT/xqV3qSrEebGjhJWOkfR8vuuf8s7AfESRE5LPeQosP/FLWDPI2Zx" +
       "5EU8xC6eD/aDPcPuhfy3z1DA3+Tk1ah0Ud1IVqc4NcPt4f3PW4WXv6i8dgjv" +
       "2hsD7+DCa8M7uD0v/Fvgtzm8U+D+7hbA5WYrTpaoh+DUNwjcPWeAu5yTu8Ei" +
       "H3qWER25beV7yuauTPM2EzWMrSg81snBpVtNA/J8MznUSXI+Ojk8fFHoZK+Y" +
       "R85QzGM5eTAqXQKz+hBvzrbPCQ4eulWc");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("uWN/8BDnB98g2//AGRCfzsk7QeAqbI+pmhucynsOrpyHLT90iPFDbxDG2hkY" +
       "GzmBgBkLjKgW7Q6anIAI3wLE4lAFAq6fPoT40+furs8XpMDyvjNw5l598EyU" +
       "HzdfKsbGUHYJ++mTARvXUPbQ33ur0J8B14uH0F88H+i37R95sVP4x2fgZ3My" +
       "OIk/L9ivsgfDW8UKgeuzh1g/e+5mvlyQAsqPngHzx3MyOwOmcKsw2+D64iHM" +
       "L74xJj2BVT8Dq5GT5RlY5VtNhr8fXF85xPqV88F6EkB4Rl2cEweAA8sLpTr6" +
       "7tuEfUZ84J4HuK8egvvq+YC7IfJ+6AyEH87J9gyEH7hVhHl2+LVDhF87f/N9" +
       "4oy6f5yTj0aluyJ3f7hss8f2sdd1FBOkzruvKPIj4Q/d8MXW7isj+fMv3XvX" +
       "gy/xf1p8SHD8JdDdVOkuLbask2cST9xf9AJVMwqsd+9OKHoFgBei0qNnJnlg" +
       "scj/5cIe/Myuzc9GpYdeq01Uug3Qk9w/H5XedjNuwAnoSc7PRKXLpzlBRlr8" +
       "P8n3i2AZ3/MBpe1uTrL8M9A7YMlvP1c4wmfT3RblQyf9qEjd7/9uJjpucvJ7" +
       "hRxu8eXd0a5gvPv27pr8hZcGow+82vil3fcSsiVtt3kvd1GlO3efbhSd5juL" +
       "T7xmb0d9XSTf/Z17fv3up452Qe/ZCbz36ROyvePmHyd0bS8qPifY/s6Dv/ne" +
       "X37p68UhxP8HhsINFRI5AAA=");
}
