package org.apache.batik.ext.awt.geom;
public class ExtendedGeneralPath implements org.apache.batik.ext.awt.geom.ExtendedShape, java.lang.Cloneable {
    protected java.awt.geom.GeneralPath path;
    int numVals = 0;
    int numSeg = 0;
    float[] values = null;
    int[] types = null;
    float mx;
    float my;
    float cx;
    float cy;
    public ExtendedGeneralPath() { super();
                                   path = new java.awt.geom.GeneralPath();
    }
    public ExtendedGeneralPath(int rule) { super();
                                           path = new java.awt.geom.GeneralPath(
                                                    rule); }
    public ExtendedGeneralPath(int rule, int initialCapacity) { super();
                                                                path = new java.awt.geom.GeneralPath(
                                                                         rule,
                                                                         initialCapacity);
    }
    public ExtendedGeneralPath(java.awt.Shape s) { this();
                                                   append(
                                                     s,
                                                     false);
    }
    public synchronized void arcTo(float rx, float ry, float angle,
                                   boolean largeArcFlag,
                                   boolean sweepFlag,
                                   float x,
                                   float y) { if (rx == 0 ||
                                                    ry ==
                                                    0) { lineTo(
                                                           x,
                                                           y);
                                                         return;
                                              }
                                              checkMoveTo(
                                                );
                                              double x0 =
                                                cx;
                                              double y0 =
                                                cy;
                                              if (x0 == x &&
                                                    y0 ==
                                                    y) { return;
                                              }
                                              java.awt.geom.Arc2D arc =
                                                computeArc(
                                                  x0,
                                                  y0,
                                                  rx,
                                                  ry,
                                                  angle,
                                                  largeArcFlag,
                                                  sweepFlag,
                                                  x,
                                                  y);
                                              if (arc == null)
                                                  return;
                                              java.awt.geom.AffineTransform t =
                                                java.awt.geom.AffineTransform.
                                                getRotateInstance(
                                                  java.lang.Math.
                                                    toRadians(
                                                      angle),
                                                  arc.
                                                    getCenterX(
                                                      ),
                                                  arc.
                                                    getCenterY(
                                                      ));
                                              java.awt.Shape s =
                                                t.
                                                createTransformedShape(
                                                  arc);
                                              path.append(
                                                     s,
                                                     true);
                                              makeRoom(7);
                                              types[numSeg++] =
                                                org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                                                  SEG_ARCTO;
                                              values[numVals++] =
                                                rx;
                                              values[numVals++] =
                                                ry;
                                              values[numVals++] =
                                                angle;
                                              values[numVals++] =
                                                largeArcFlag
                                                  ? 1
                                                  : 0;
                                              values[numVals++] =
                                                sweepFlag
                                                  ? 1
                                                  : 0;
                                              cx =
                                                (values[numVals++] =
                                                   x);
                                              cy =
                                                (values[numVals++] =
                                                   y);
    }
    public static java.awt.geom.Arc2D computeArc(double x0,
                                                 double y0,
                                                 double rx,
                                                 double ry,
                                                 double angle,
                                                 boolean largeArcFlag,
                                                 boolean sweepFlag,
                                                 double x,
                                                 double y) {
        double dx2 =
          (x0 -
             x) /
          2.0;
        double dy2 =
          (y0 -
             y) /
          2.0;
        angle =
          java.lang.Math.
            toRadians(
              angle %
                360.0);
        double cosAngle =
          java.lang.Math.
          cos(
            angle);
        double sinAngle =
          java.lang.Math.
          sin(
            angle);
        double x1 =
          cosAngle *
          dx2 +
          sinAngle *
          dy2;
        double y1 =
          -sinAngle *
          dx2 +
          cosAngle *
          dy2;
        rx =
          java.lang.Math.
            abs(
              rx);
        ry =
          java.lang.Math.
            abs(
              ry);
        double Prx =
          rx *
          rx;
        double Pry =
          ry *
          ry;
        double Px1 =
          x1 *
          x1;
        double Py1 =
          y1 *
          y1;
        double radiiCheck =
          Px1 /
          Prx +
          Py1 /
          Pry;
        if (radiiCheck >
              1) {
            rx =
              java.lang.Math.
                sqrt(
                  radiiCheck) *
                rx;
            ry =
              java.lang.Math.
                sqrt(
                  radiiCheck) *
                ry;
            Prx =
              rx *
                rx;
            Pry =
              ry *
                ry;
        }
        double sign =
          largeArcFlag ==
          sweepFlag
          ? -1
          : 1;
        double sq =
          (Prx *
             Pry -
             Prx *
             Py1 -
             Pry *
             Px1) /
          (Prx *
             Py1 +
             Pry *
             Px1);
        sq =
          sq <
            0
            ? 0
            : sq;
        double coef =
          sign *
          java.lang.Math.
          sqrt(
            sq);
        double cx1 =
          coef *
          (rx *
             y1 /
             ry);
        double cy1 =
          coef *
          -(ry *
              x1 /
              rx);
        double sx2 =
          (x0 +
             x) /
          2.0;
        double sy2 =
          (y0 +
             y) /
          2.0;
        double cx =
          sx2 +
          (cosAngle *
             cx1 -
             sinAngle *
             cy1);
        double cy =
          sy2 +
          (sinAngle *
             cx1 +
             cosAngle *
             cy1);
        double ux =
          (x1 -
             cx1) /
          rx;
        double uy =
          (y1 -
             cy1) /
          ry;
        double vx =
          (-x1 -
             cx1) /
          rx;
        double vy =
          (-y1 -
             cy1) /
          ry;
        double p;
        double n;
        n =
          java.lang.Math.
            sqrt(
              ux *
                ux +
                uy *
                uy);
        p =
          ux;
        sign =
          uy <
            0
            ? -1.0
            : 1.0;
        double angleStart =
          java.lang.Math.
          toDegrees(
            sign *
              java.lang.Math.
              acos(
                p /
                  n));
        n =
          java.lang.Math.
            sqrt(
              (ux *
                 ux +
                 uy *
                 uy) *
                (vx *
                   vx +
                   vy *
                   vy));
        p =
          ux *
            vx +
            uy *
            vy;
        sign =
          ux *
            vy -
            uy *
            vx <
            0
            ? -1.0
            : 1.0;
        double angleExtent =
          java.lang.Math.
          toDegrees(
            sign *
              java.lang.Math.
              acos(
                p /
                  n));
        if (!sweepFlag &&
              angleExtent >
              0) {
            angleExtent -=
              360.0F;
        }
        else
            if (sweepFlag &&
                  angleExtent <
                  0) {
                angleExtent +=
                  360.0F;
            }
        angleExtent %=
          360.0F;
        angleStart %=
          360.0F;
        java.awt.geom.Arc2D.Double arc =
          new java.awt.geom.Arc2D.Double(
          );
        arc.
          x =
          cx -
            rx;
        arc.
          y =
          cy -
            ry;
        arc.
          width =
          rx *
            2.0;
        arc.
          height =
          ry *
            2.0;
        arc.
          start =
          -angleStart;
        arc.
          extent =
          -angleExtent;
        return arc;
    }
    public synchronized void moveTo(float x, float y) {
        makeRoom(
          2);
        types[numSeg++] =
          java.awt.geom.PathIterator.
            SEG_MOVETO;
        cx =
          (mx =
             (values[numVals++] =
                x));
        cy =
          (my =
             (values[numVals++] =
                y));
    }
    public synchronized void lineTo(float x, float y) {
        checkMoveTo(
          );
        path.
          lineTo(
            x,
            y);
        makeRoom(
          2);
        types[numSeg++] =
          java.awt.geom.PathIterator.
            SEG_LINETO;
        cx =
          (values[numVals++] =
             x);
        cy =
          (values[numVals++] =
             y);
    }
    public synchronized void quadTo(float x1, float y1,
                                    float x2,
                                    float y2) { checkMoveTo(
                                                  );
                                                path.
                                                  quadTo(
                                                    x1,
                                                    y1,
                                                    x2,
                                                    y2);
                                                makeRoom(
                                                  4);
                                                types[numSeg++] =
                                                  java.awt.geom.PathIterator.
                                                    SEG_QUADTO;
                                                values[numVals++] =
                                                  x1;
                                                values[numVals++] =
                                                  y1;
                                                cx =
                                                  (values[numVals++] =
                                                     x2);
                                                cy =
                                                  (values[numVals++] =
                                                     y2);
    }
    public synchronized void curveTo(float x1, float y1,
                                     float x2,
                                     float y2,
                                     float x3,
                                     float y3) { checkMoveTo(
                                                   );
                                                 path.
                                                   curveTo(
                                                     x1,
                                                     y1,
                                                     x2,
                                                     y2,
                                                     x3,
                                                     y3);
                                                 makeRoom(
                                                   6);
                                                 types[numSeg++] =
                                                   java.awt.geom.PathIterator.
                                                     SEG_CUBICTO;
                                                 values[numVals++] =
                                                   x1;
                                                 values[numVals++] =
                                                   y1;
                                                 values[numVals++] =
                                                   x2;
                                                 values[numVals++] =
                                                   y2;
                                                 cx =
                                                   (values[numVals++] =
                                                      x3);
                                                 cy =
                                                   (values[numVals++] =
                                                      y3);
    }
    public synchronized void closePath() { if (numSeg !=
                                                 0 &&
                                                 types[numSeg -
                                                         1] ==
                                                 java.awt.geom.PathIterator.
                                                   SEG_CLOSE)
                                               return;
                                           if (numSeg !=
                                                 0 &&
                                                 types[numSeg -
                                                         1] !=
                                                 java.awt.geom.PathIterator.
                                                   SEG_MOVETO)
                                               path.
                                                 closePath(
                                                   );
                                           makeRoom(
                                             0);
                                           types[numSeg++] =
                                             java.awt.geom.PathIterator.
                                               SEG_CLOSE;
                                           cx = mx;
                                           cy = my;
    }
    protected void checkMoveTo() { if (numSeg == 0)
                                       return;
                                   switch (types[numSeg -
                                                   1]) {
                                       case java.awt.geom.PathIterator.
                                              SEG_MOVETO:
                                           path.
                                             moveTo(
                                               values[numVals -
                                                        2],
                                               values[numVals -
                                                        1]);
                                           break;
                                       case java.awt.geom.PathIterator.
                                              SEG_CLOSE:
                                           if (numSeg ==
                                                 1)
                                               return;
                                           if (types[numSeg -
                                                       2] ==
                                                 java.awt.geom.PathIterator.
                                                   SEG_MOVETO)
                                               path.
                                                 moveTo(
                                                   values[numVals -
                                                            2],
                                                   values[numVals -
                                                            1]);
                                           break;
                                       default:
                                           break;
                                   } }
    public void append(java.awt.Shape s, boolean connect) {
        append(
          s.
            getPathIterator(
              new java.awt.geom.AffineTransform(
                )),
          connect);
    }
    public void append(java.awt.geom.PathIterator pi,
                       boolean connect) { double[] vals =
                                            new double[6];
                                          while (!pi.
                                                   isDone(
                                                     )) {
                                              java.util.Arrays.
                                                fill(
                                                  vals,
                                                  0);
                                              int type =
                                                pi.
                                                currentSegment(
                                                  vals);
                                              pi.
                                                next(
                                                  );
                                              if (connect &&
                                                    numVals !=
                                                    0) {
                                                  if (type ==
                                                        java.awt.geom.PathIterator.
                                                          SEG_MOVETO) {
                                                      double x =
                                                        vals[0];
                                                      double y =
                                                        vals[1];
                                                      if (x !=
                                                            cx ||
                                                            y !=
                                                            cy) {
                                                          type =
                                                            java.awt.geom.PathIterator.
                                                              SEG_LINETO;
                                                      }
                                                      else {
                                                          if (pi.
                                                                isDone(
                                                                  ))
                                                              break;
                                                          type =
                                                            pi.
                                                              currentSegment(
                                                                vals);
                                                          pi.
                                                            next(
                                                              );
                                                      }
                                                  }
                                                  connect =
                                                    false;
                                              }
                                              switch (type) {
                                                  case java.awt.geom.PathIterator.
                                                         SEG_CLOSE:
                                                      closePath(
                                                        );
                                                      break;
                                                  case java.awt.geom.PathIterator.
                                                         SEG_MOVETO:
                                                      moveTo(
                                                        (float)
                                                          vals[0],
                                                        (float)
                                                          vals[1]);
                                                      break;
                                                  case java.awt.geom.PathIterator.
                                                         SEG_LINETO:
                                                      lineTo(
                                                        (float)
                                                          vals[0],
                                                        (float)
                                                          vals[1]);
                                                      break;
                                                  case java.awt.geom.PathIterator.
                                                         SEG_QUADTO:
                                                      quadTo(
                                                        (float)
                                                          vals[0],
                                                        (float)
                                                          vals[1],
                                                        (float)
                                                          vals[2],
                                                        (float)
                                                          vals[3]);
                                                      break;
                                                  case java.awt.geom.PathIterator.
                                                         SEG_CUBICTO:
                                                      curveTo(
                                                        (float)
                                                          vals[0],
                                                        (float)
                                                          vals[1],
                                                        (float)
                                                          vals[2],
                                                        (float)
                                                          vals[3],
                                                        (float)
                                                          vals[4],
                                                        (float)
                                                          vals[5]);
                                                      break;
                                              }
                                          }
    }
    public void append(org.apache.batik.ext.awt.geom.ExtendedPathIterator epi,
                       boolean connect) {
        float[] vals =
          new float[7];
        while (!epi.
                 isDone(
                   )) {
            java.util.Arrays.
              fill(
                vals,
                0);
            int type =
              epi.
              currentSegment(
                vals);
            epi.
              next(
                );
            if (connect &&
                  numVals !=
                  0) {
                if (type ==
                      java.awt.geom.PathIterator.
                        SEG_MOVETO) {
                    float x =
                      vals[0];
                    float y =
                      vals[1];
                    if (x !=
                          cx ||
                          y !=
                          cy) {
                        type =
                          java.awt.geom.PathIterator.
                            SEG_LINETO;
                    }
                    else {
                        if (epi.
                              isDone(
                                ))
                            break;
                        type =
                          epi.
                            currentSegment(
                              vals);
                        epi.
                          next(
                            );
                    }
                }
                connect =
                  false;
            }
            switch (type) {
                case java.awt.geom.PathIterator.
                       SEG_CLOSE:
                    closePath(
                      );
                    break;
                case java.awt.geom.PathIterator.
                       SEG_MOVETO:
                    moveTo(
                      vals[0],
                      vals[1]);
                    break;
                case java.awt.geom.PathIterator.
                       SEG_LINETO:
                    lineTo(
                      vals[0],
                      vals[1]);
                    break;
                case java.awt.geom.PathIterator.
                       SEG_QUADTO:
                    quadTo(
                      vals[0],
                      vals[1],
                      vals[2],
                      vals[3]);
                    break;
                case java.awt.geom.PathIterator.
                       SEG_CUBICTO:
                    curveTo(
                      vals[0],
                      vals[1],
                      vals[2],
                      vals[3],
                      vals[4],
                      vals[5]);
                    break;
                case org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                       SEG_ARCTO:
                    arcTo(
                      vals[0],
                      vals[1],
                      vals[2],
                      vals[3] !=
                        0,
                      vals[4] !=
                        0,
                      vals[5],
                      vals[6]);
                    break;
            }
        }
    }
    public synchronized int getWindingRule() {
        return path.
          getWindingRule(
            );
    }
    public void setWindingRule(int rule) {
        path.
          setWindingRule(
            rule);
    }
    public synchronized java.awt.geom.Point2D getCurrentPoint() {
        if (numVals ==
              0)
            return null;
        return new java.awt.geom.Point2D.Double(
          cx,
          cy);
    }
    public synchronized void reset() { path.
                                         reset(
                                           );
                                       numSeg =
                                         0;
                                       numVals =
                                         0;
                                       values =
                                         null;
                                       types =
                                         null;
    }
    public void transform(java.awt.geom.AffineTransform at) {
        if (at.
              getType(
                ) !=
              java.awt.geom.AffineTransform.
                TYPE_IDENTITY)
            throw new java.lang.IllegalArgumentException(
              "ExtendedGeneralPaths can not be transformed");
    }
    public synchronized java.awt.Shape createTransformedShape(java.awt.geom.AffineTransform at) {
        return path.
          createTransformedShape(
            at);
    }
    public synchronized java.awt.Rectangle getBounds() {
        return path.
          getBounds(
            );
    }
    public synchronized java.awt.geom.Rectangle2D getBounds2D() {
        return path.
          getBounds2D(
            );
    }
    public boolean contains(double x, double y) {
        return path.
          contains(
            x,
            y);
    }
    public boolean contains(java.awt.geom.Point2D p) {
        return path.
          contains(
            p);
    }
    public boolean contains(double x, double y,
                            double w,
                            double h) { return path.
                                          contains(
                                            x,
                                            y,
                                            w,
                                            h);
    }
    public boolean contains(java.awt.geom.Rectangle2D r) {
        return path.
          contains(
            r);
    }
    public boolean intersects(double x, double y,
                              double w,
                              double h) {
        return path.
          intersects(
            x,
            y,
            w,
            h);
    }
    public boolean intersects(java.awt.geom.Rectangle2D r) {
        return path.
          intersects(
            r);
    }
    public java.awt.geom.PathIterator getPathIterator(java.awt.geom.AffineTransform at) {
        return path.
          getPathIterator(
            at);
    }
    public java.awt.geom.PathIterator getPathIterator(java.awt.geom.AffineTransform at,
                                                      double flatness) {
        return path.
          getPathIterator(
            at,
            flatness);
    }
    public org.apache.batik.ext.awt.geom.ExtendedPathIterator getExtendedPathIterator() {
        return new org.apache.batik.ext.awt.geom.ExtendedGeneralPath.EPI(
          );
    }
    class EPI implements org.apache.batik.ext.awt.geom.ExtendedPathIterator {
        int segNum = 0;
        int valsIdx = 0;
        public int currentSegment() { return types[segNum];
        }
        public int currentSegment(double[] coords) {
            int ret =
              types[segNum];
            switch (ret) {
                case SEG_CLOSE:
                    break;
                case SEG_MOVETO:
                case SEG_LINETO:
                    coords[0] =
                      values[valsIdx];
                    coords[1] =
                      values[valsIdx +
                               1];
                    break;
                case SEG_QUADTO:
                    coords[0] =
                      values[valsIdx];
                    coords[1] =
                      values[valsIdx +
                               1];
                    coords[2] =
                      values[valsIdx +
                               2];
                    coords[3] =
                      values[valsIdx +
                               3];
                    break;
                case SEG_CUBICTO:
                    coords[0] =
                      values[valsIdx];
                    coords[1] =
                      values[valsIdx +
                               1];
                    coords[2] =
                      values[valsIdx +
                               2];
                    coords[3] =
                      values[valsIdx +
                               3];
                    coords[4] =
                      values[valsIdx +
                               4];
                    coords[5] =
                      values[valsIdx +
                               5];
                    break;
                case SEG_ARCTO:
                    coords[0] =
                      values[valsIdx];
                    coords[1] =
                      values[valsIdx +
                               1];
                    coords[2] =
                      values[valsIdx +
                               2];
                    coords[3] =
                      values[valsIdx +
                               3];
                    coords[4] =
                      values[valsIdx +
                               4];
                    coords[5] =
                      values[valsIdx +
                               5];
                    coords[6] =
                      values[valsIdx +
                               6];
                    break;
            }
            return ret;
        }
        public int currentSegment(float[] coords) {
            int ret =
              types[segNum];
            switch (ret) {
                case SEG_CLOSE:
                    break;
                case SEG_MOVETO:
                case SEG_LINETO:
                    coords[0] =
                      values[valsIdx];
                    coords[1] =
                      values[valsIdx +
                               1];
                    break;
                case SEG_QUADTO:
                    java.lang.System.
                      arraycopy(
                        values,
                        valsIdx,
                        coords,
                        0,
                        4);
                    break;
                case SEG_CUBICTO:
                    java.lang.System.
                      arraycopy(
                        values,
                        valsIdx,
                        coords,
                        0,
                        6);
                    break;
                case SEG_ARCTO:
                    java.lang.System.
                      arraycopy(
                        values,
                        valsIdx,
                        coords,
                        0,
                        7);
                    break;
            }
            return ret;
        }
        public int getWindingRule() { return path.
                                        getWindingRule(
                                          );
        }
        public boolean isDone() { return segNum ==
                                    numSeg;
        }
        public void next() { int type = types[segNum++];
                             switch (type) {
                                 case SEG_CLOSE:
                                     break;
                                 case SEG_MOVETO:
                                 case SEG_LINETO:
                                     valsIdx +=
                                       2;
                                     break;
                                 case SEG_QUADTO:
                                     valsIdx +=
                                       4;
                                     break;
                                 case SEG_CUBICTO:
                                     valsIdx +=
                                       6;
                                     break;
                                 case SEG_ARCTO:
                                     valsIdx +=
                                       7;
                                     break;
                             } }
        public EPI() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "6n8BXL0ojtEiAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "CGgdZFErqsrT60ajw/aWEyTXzdlQ4Wl2CyNbvS9N6HZn0TabkjlbY8ESLGpN" +
           "x5nujBphU/56t9nZvQafmOZ21lDbNhY2J9kSGbUVftBa72r4glnPp5A4rqKa" +
           "I8roREPiZUYR+giBSQqitUEst6NcMuqh5ozTVZ+DjL7QVMUVHPlK1BRW0GBb" +
           "3fQlwgmo1qCx3aINfUHISs9n0z7fjXuCQnvKSs2MGU9gHSsJx04zaLUlrho6" +
           "accmCOIHi20E/81tbzxc7uScHNo6HlZU/Mib2MHI77ZndbL9Vf6955JzjjN7" +
           "wVeOt5Bq39kpV3G8xaRGeSBRbAM+ebcz3XIL8LMffvkVffgLyMHRlhqbVq4f" +
           "HbWfinAdsHnf3fc6B+V59ume8G98+L8/Mf2h5QffxKnX0xeEvMjylwav/mbv" +
           "+7SfOahcPdkhvu2k/Xyj58/vCz8QG2kWB9Nzu8NPnljk0cIAzwBLTI4sMrnz" +
           "ydMdLXuldKW9A11ytPFTl9R9tCg+lFYe0rI4NoJ0Yli+sd9hpU+97sNvtG92" +
           "lm354qXbNZwfaTh/azS8cnI6+p67u0h5OrTf3X7l7z371R9/5dk/Kg9Y7rMT" +
           "UYkJMNndfvngTJtvvfq1b/zO2578XHkgeY+qJHsbXry1cfuljHN3LUrxHzy/" +
           "B/0Q+Fr7Adn/ppXtW3oIrsa2bhnwROx1DTIM1sUVlIGSxmAV5hmFidslwfEJ" +
           "/F9c5/mdNm+v62GmesZtxj7Zo/3k8Ub9Z+7sOAcnKHsCsNc9I7D2dyDKHftP" +
           "RPkJ/4N9o2PIe/R0D5v0wsBQjmUBdftjezs8PLkGBCrzO0r60l7SsrOiePaS" +
           "QPylS+r+QVH8Ylq5phXC7GW/hPxz+f73Zy6h+UJR/M03ivuPvRVx/9JR3L/0" +
           "1sZ98f9nT3p7omD+NPi+9yio3rsPKuMt9WvAxC8Oo8OYAE/l5HIcQP9/Orpj" +
           "sFwzvVBJ7x4rv3ocK7/+HcZKUfydkzj50u1xUvz9u0Xx2Usc/1dLZl96I8f/" +
           "15fUfaUovlwUr+4luYT2q0de/88uofk3RfHFN/L6f/xWeP3LR17/8lvj9We1" +
           "+P1L6v5jUfxboKFlpHOQZ9mBNc72F8LOaPh734WGjxUvnwSafepIw0+99Rr+" +
           "l0vqvl4UfwTg3E4ogIZ3Coh71TD0DCU4VfiPvwuFb1T2+HLwc0cK/9xbr/Cf" +
           "XFL3Z0XxrRRklSC9ueNJ5zq09VNdX38zuuZp5WpHYI4nN+RN32gD+dfjt92x" +
           "3d8L1T73yo37Hntl9u/26dPx3c37ucp9ZuZ5Zy9PnHm+HsWGaZea37+/ShEV" +
           "P1euppUnL5UODETxU6hy5WDf5npaefxubYDioDxLfT+Y3O9EDSiPRv6Y8sG0" +
           "cvMiJcDh8vcs3Y208sApHfDZ/cNZkkcAd0BSPD4aHZvhzBn6/n5KfuXMsujI" +
           "Q0tjP/JGxj5pcvYqWTEE5f3p42VPtr9B");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("/YL2+VdY/sdeb/7C/iqb5im7XcHlPpDS7m/VnSydnrkrt2Ne1+nnvv3QF+5/" +
           "z/Ea76G9wKfRcka2p+98V6zjR2l5u2v3Tx/7R+//xVf+oLxE8P8AQgjtttgu" +
           "AAA=");
    }
    public java.lang.Object clone() { try {
                                          org.apache.batik.ext.awt.geom.ExtendedGeneralPath result =
                                            (org.apache.batik.ext.awt.geom.ExtendedGeneralPath)
                                              super.
                                              clone(
                                                );
                                          result.
                                            path =
                                            (java.awt.geom.GeneralPath)
                                              path.
                                              clone(
                                                );
                                          if (values !=
                                                null) {
                                              result.
                                                values =
                                                (new float[values.
                                                             length]);
                                              java.lang.System.
                                                arraycopy(
                                                  values,
                                                  0,
                                                  result.
                                                    values,
                                                  0,
                                                  values.
                                                    length);
                                          }
                                          result.
                                            numVals =
                                            numVals;
                                          if (types !=
                                                null) {
                                              result.
                                                types =
                                                (new int[types.
                                                           length]);
                                              java.lang.System.
                                                arraycopy(
                                                  types,
                                                  0,
                                                  result.
                                                    types,
                                                  0,
                                                  types.
                                                    length);
                                          }
                                          result.
                                            numSeg =
                                            numSeg;
                                          return result;
                                      }
                                      catch (java.lang.CloneNotSupportedException ex) {
                                          
                                      }
                                      return null;
    }
    private void makeRoom(int numValues) {
        if (values ==
              null) {
            values =
              (new float[2 *
                           numValues]);
            types =
              (new int[2]);
            numVals =
              0;
            numSeg =
              0;
            return;
        }
        int newSize =
          numVals +
          numValues;
        if (newSize >
              values.
                length) {
            int nlen =
              values.
                length *
              2;
            if (nlen <
                  newSize)
                nlen =
                  newSize;
            float[] nvals =
              new float[nlen];
            java.lang.System.
              arraycopy(
                values,
                0,
                nvals,
                0,
                numVals);
            values =
              nvals;
        }
        if (numSeg ==
              types.
                length) {
            int[] ntypes =
              new int[types.
                        length *
                        2];
            java.lang.System.
              arraycopy(
                types,
                0,
                ntypes,
                0,
                types.
                  length);
            types =
              ntypes;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OMXjP8Qvm/4fU6vb/ktEAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "My2UBFNJhxDf6bqMt7EdXYbbqxWFcjWPVNdotmWF8ry9qVVmTD2pihEyaczd" +
       "Lbf1Ug9OdDCjruKNMgoNackThK1hMdxS4vVYx7WgmcwgPJy1TUQFmsVkaaTh" +
       "fZqr1gUoroqw3RjU4VY1GW7NxQrudtG4Vp/SFRPqoFUZ65LIulyxcJnA+nJX" +
       "FtqtRaDLzWnkbzPDmvjZJOFgXOpx043cd2oKMsInrtPAW2IVRn0tSyg3Rt0m" +
       "r8xMJ51E5rDabjXgcMNqa7gF6UvF6PQ2QqM37dQWQ4MNJGU9H6jTzroztaZl" +
       "BUFCAR2XebmNlWspPMUbLgUvh+LGmady35PnZBR3uhN6lJgjdqkvDZvUPBCH" +
       "TYzlivW6s36XqC/VarlZEZLI9aVOpw/P2yNV7wejLGgLq7hDuP1Npccmg8Ra" +
       "jjMi2MZhO64zIc8SW27Q7oQD0WsYYr+NNSe9+VIH8eB6g/EVvIzDCSdLNjYd" +
       "TRiEzmgVa2+rIA7Uqxy0bHCbmIDncrgVqzHPmhi08BMKHjtmN4Ico8vU/Nip" +
       "xyaJYf2267bmZWm5JBoO0K7JEg7pJJslFKSo87bmZJkc2EzYalsjeCQoOu1K" +
       "CQ1VljKbVEMUW8U4s82obtQeDiGCa6cGRyQ0W+aW3WqviTCb6pbyVhE2jxM0" +
       "6aImMhjahpN2kxoI6i203JHoOR51E6KiNF1TVEDkOeWnPZSbwoZjBVNzNTZm" +
       "nm45iCybYnU47FCDRh9JV4FWWzf8jjIBTpKxM4qcJpkId0dOxwxF0y7bOiOH" +
       "9UmMp6EOUUptlsA8Go00ptWq+X57uQJa4ZWhBBnyOFSvSdqwmlbj3pBwRHTO" +
       "cgnmJ+oGxxuh2Ee5ZAmRxDzoIBSB0ehSDbbVxkhaNXrsWpu7AcxRMdfdYJMx" +
       "qw8Ni/RDfSyOcKPM+FiTEc1qi9VIvkrCkjZCenhlrGZ4FW9mfXjSXlXnZsgr" +
       "dEXvwP32rNlt8ZkdYisfM3imN5clAhErPIqzCK6oNoctXYdgBQgEfNaQQCmM" +
       "Z8vTddJOMZ2j2S43RgSOIlWqQbY34xYau60124GW1Q4TJMRKixqNqOYK/Y3K" +
       "jHRo2bMahCD06yzSt7bdNR07PRoqb0dzBMv6cohKVJnjgpWOKFV/Pda6vqxi" +
       "pouYsW54LmRp/XltOBt6rQZUr3IeFqhDG2aMbTDUR74GZbAgWlwft1r1bCRH" +
       "c8hWCb0PrbR2UGsQ00wqA/8NJUAfcM/DRZNnKMdMqsgmxRM6iGAYo4VyOOi7" +
       "re2GgBZ1vq3EQnnFTPmaM1jEKIjnq+0pZWgsvAj7MlqeT7otrIJ2baMxoN0F" +
       "SLRFjO5I6/WSrbRgeSvOlfVsGmvkZBGMK2u326xWhbUkUTwXy+NtH5+bpDaa" +
       "taoa1ORnFAaCjrJPQOKMq5PeGq0YG8Wj6F6AmE4zTtJMHJhb3Gi1vBDyhvUl" +
       "tOmSUx/vUrzsb7bLkKqNK0sQUZsmg4dpUxBXPGKuk2FrYFFDyXTYLtPW0ZlT" +
       "oyr+xHV5BFIopjfxx3AstSczcTmJmyujOvIGSL/mVSrd1jZ1VqN1RNFmR8Vx" +
       "fhmhY6rSF2YbsrlwgwU0WuomCEqzITobj+u86UcEWbG9Lc8ysLtRnF6LrMej" +
       "BqmolVZvGgIjleam2KouuBDvsD185TJjH++REdXA1RjNkBq14lMBmYxHWhpu" +
       "K0t/FICJSDoYVpU2sYzby42gtKeVdFiJ2gMuGE1dYkoJdFiml3W5OebcCreZ" +
       "NtrMllhli44f9ZrVsZ32FN6MZiLmMK2IXQAPPRV4iUFskQFz3kCa0o14MOiP" +
       "k/Jiq7UbEW4b2KpWq/MqtWJoK3MzIRpTAwYlqEbLtDRmodWwgNHIpYmCwGGk" +
       "U1OaH8TQmuuhs1ZFNuNkifQaGKlNKz3ZNPjJYGOrW5tWSZZuulZcGfUsvm10" +
       "simRoXInaS56KzEkWhxlpHjQMTJtMplJmM121eEqHicuTllIVdv2vPJk3esj" +
       "4zGGzSdCn50oRG2L5arlr1M/ooV+uwYthTAV9XDZo0Nyo5Y7wlyGnJbbDiaU" +
       "2KJNPXQ7EEVSoqKTFb7DkrWQBXFDeVlu");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("LpYkonjlbRYixDiSyEEHpoZIzZmvKiqDkBKSirWskW34ZAz8oq43MSelyzWY" +
       "D+MNjSSIboHABYY4C6cTmnQ4mtusGfA7c9paf7BybdJhF0yVVZbbVd3QmPV4" +
       "mLQY3Nv4ggdX62x9QPFN34eWFiWK6CDDORCQytKIIht4wMBWRZzWSAkEUAg1" +
       "pWqdcNqt9fQlmdIsmvGc7ciTeVN2dMeSoRm9WW2lUNJbK2Ukor6DQ8PMYsob" +
       "la9YWwxFqaWezVp2tWxqxIrT0dThnEZZVjIFGVR0rTMSyrjRKdN0122N2UXN" +
       "UiwRNteDchcoEEc7g4RVGc+pjq2+P6+F47A2AdObpF11tKS5Mrdpyx8OSSKh" +
       "tJbrtwaCZEBZC/i/bQ9Ghsmov0VHCu71lGiTepJC1uoG6w8rjJ6ASJcV1Pm4" +
       "rpuT6oLokChnkB28Ra5AeOovO4rpmuiYcGO6xuojaK17mDGMmTlsaJMF5skr" +
       "HpPZ6mwUOkad6UYJ012pKTXedkd+2EGRtoyFDR8xKmOc2pKeL417SQwirVRY" +
       "YxmxrGAhradOpzLgMb3ddjyRtueQWe96IMrAO8qcRLC1PGFEfOlkZVcbjk1+" +
       "Djfh7nBlxAO57YomQXT6gpJy3XJvUjGpzXoBO5W41211Qqlu9Dc9D41nI367" +
       "rpJhS9DKUZtnRKQv4n7VxxaMDK9Emo6kyoTQEGbRY9rmKHDoGrdkZpCaxF7c" +
       "FyvTgQWVMaGvJ4rsLoDur1k0lT2m0a548bqXBlt7ME0QkaW3VHtGUJi6BFjq" +
       "k5kybzBBWzecHl/rQQif9soNopfG8xGpDgxv6Hku09v4ZcJHNsm8nI6MGUYY" +
       "IBSHe+mK8AdBv5/KVnXgg0mqzI6qy1HL3dhjE9i81l2P14sm3iAzjxGVtqyk" +
       "yqDTHKOuTcstgrZixQg6KzJbhsttjHZCZYiiit9tx4k6h2hKV8m4lSV01uxy" +
       "skP6IFypeOIWWAzdh/qx0UurfGfRwVctHKLNssny46HVHWrlAcKYMdoGOjjb" +
       "BpOKPWuMVLU8G/QbbjNusGJtvE3poV4e8HzEdOmKMl9WoB5PlOO1bzYUfAhZ" +
       "/ApySU3pTqZM1aGoaSOFPTfEQDy0oiml4RI02YiBO+FGowauGJmwknvYCI6W" +
       "ZWwuj1FTpPxFpyL3RrQf0LX2ylu3JYEYriIQ6iGdRtmJW2AaVpUbm2Yo1BBc" +
       "N6Q+3dhME2MueSO/rA9SBtdm4bBXWzQCuOoO8Clbm1XyBVKMb9Qsgk/1jDNg" +
       "ui6SOhi/Kaysuu1BHIXA1MUFRy/8Nd4fupJp692uYFlqM572MHM+GK7bIj3F" +
       "5mtijA8gslHVh8rQEdzWgtYcnlZV207pzKkZg2yOuiunMnN7XDdo1GvtOc2X" +
       "a77WpoaLpcZ3emlzVcNinfAsqTZm2ThxxEGrLXRDe5VhcW0qZ7gv83qW8lK5" +
       "ySFA97u1ajZlonJ5QS8DSGA74WKpTPvqWFn4bLO8hajOYGlWJJkc01k/AzNM" +
       "r1MeSFMFFVYkTle7ejonuqno4G0JpqaY3NXG8WLGOYRQ3trbZT2K/S2vd9Y9" +
       "eabig2CzbGG+mIGh3KqHoVEpUz4URmHa6OjBxq0BmWKLITtfctgocSBEF+qJ" +
       "DK0istlsviNfVv+Lm1vuf3XxZOP4/MXSbuQJf3QTK/qb8/acFZ+7S2f27J96" +
       "8nNqn9fxRoLyF7dHvdiGlhf54XxD41MXnccoNjN+4F0vvawOP1g93D9LoqLS" +
       "vZHnv93WEs0+xcPTuyegx/w/kbObP+6O9/yvzz65OpHQhTsq7g+3rmIGnmtl" +
       "R5ulzjwKvVLkv3L8bGtHznvOckX2PFuT8j3ZBw+cZM1rPbj/4gesB6/Oyd1R" +
       "6S4pUHjv3Cc4iWepx119cOWmNymekdobwfeDe6l98KalVmjoubK6t8h173kQ" +
       "7la9WC6Okhw8cw554Jjs7hWCefoSoT2bk9dGpfvyYy5xpDUD5drNLsc6CVJq" +
       "7RPhPXmrwkNLpYP7dmV3vzcrvIP7zhXeqS0ApxTnkk3nB/mm84O3Adk6XqLx" +
       "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" +
       "di5njFMAAA==");
}
