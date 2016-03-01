package org.apache.batik.ext.awt.geom;
public class Polyline2D implements java.awt.Shape, java.lang.Cloneable, java.io.Serializable {
    private static final float ASSUME_ZERO = 0.001F;
    public int npoints;
    public float[] xpoints;
    public float[] ypoints;
    protected java.awt.geom.Rectangle2D bounds;
    private java.awt.geom.GeneralPath path;
    private java.awt.geom.GeneralPath closedPath;
    public Polyline2D() { super();
                          xpoints = (new float[4]);
                          ypoints = (new float[4]); }
    public Polyline2D(float[] xpoints, float[] ypoints, int npoints) { super(
                                                                         );
                                                                       if (npoints >
                                                                             xpoints.
                                                                               length ||
                                                                             npoints >
                                                                             ypoints.
                                                                               length) {
                                                                           throw new java.lang.IndexOutOfBoundsException(
                                                                             "npoints > xpoints.length || npoints > ypoints.length");
                                                                       }
                                                                       this.
                                                                         npoints =
                                                                         npoints;
                                                                       this.
                                                                         xpoints =
                                                                         (new float[npoints +
                                                                                      1]);
                                                                       this.
                                                                         ypoints =
                                                                         (new float[npoints +
                                                                                      1]);
                                                                       java.lang.System.
                                                                         arraycopy(
                                                                           xpoints,
                                                                           0,
                                                                           this.
                                                                             xpoints,
                                                                           0,
                                                                           npoints);
                                                                       java.lang.System.
                                                                         arraycopy(
                                                                           ypoints,
                                                                           0,
                                                                           this.
                                                                             ypoints,
                                                                           0,
                                                                           npoints);
                                                                       calculatePath(
                                                                         );
    }
    public Polyline2D(int[] xpoints, int[] ypoints,
                      int npoints) { super(
                                       );
                                     if (npoints >
                                           xpoints.
                                             length ||
                                           npoints >
                                           ypoints.
                                             length) {
                                         throw new java.lang.IndexOutOfBoundsException(
                                           "npoints > xpoints.length || npoints > ypoints.length");
                                     }
                                     this.
                                       npoints =
                                       npoints;
                                     this.
                                       xpoints =
                                       (new float[npoints]);
                                     this.
                                       ypoints =
                                       (new float[npoints]);
                                     for (int i =
                                            0;
                                          i <
                                            npoints;
                                          i++) {
                                         this.
                                           xpoints[i] =
                                           xpoints[i];
                                         this.
                                           ypoints[i] =
                                           ypoints[i];
                                     }
                                     calculatePath(
                                       );
    }
    public Polyline2D(java.awt.geom.Line2D line) {
        super(
          );
        npoints =
          2;
        xpoints =
          (new float[2]);
        ypoints =
          (new float[2]);
        xpoints[0] =
          (float)
            line.
            getX1(
              );
        xpoints[1] =
          (float)
            line.
            getX2(
              );
        ypoints[0] =
          (float)
            line.
            getY1(
              );
        ypoints[1] =
          (float)
            line.
            getY2(
              );
        calculatePath(
          );
    }
    public void reset() { npoints = 0;
                          bounds = null;
                          path = new java.awt.geom.GeneralPath(
                                   );
                          closedPath = null;
    }
    public java.lang.Object clone() { org.apache.batik.ext.awt.geom.Polyline2D pol =
                                        new org.apache.batik.ext.awt.geom.Polyline2D(
                                        );
                                      for (int i =
                                             0;
                                           i <
                                             npoints;
                                           i++) {
                                          pol.
                                            addPoint(
                                              xpoints[i],
                                              ypoints[i]);
                                      }
                                      return pol;
    }
    private void calculatePath() { path =
                                     new java.awt.geom.GeneralPath(
                                       );
                                   path.moveTo(
                                          xpoints[0],
                                          ypoints[0]);
                                   for (int i =
                                          1;
                                        i <
                                          npoints;
                                        i++) {
                                       path.
                                         lineTo(
                                           xpoints[i],
                                           ypoints[i]);
                                   }
                                   bounds =
                                     path.
                                       getBounds2D(
                                         );
                                   closedPath =
                                     null;
    }
    private void updatePath(float x, float y) {
        closedPath =
          null;
        if (path ==
              null) {
            path =
              new java.awt.geom.GeneralPath(
                java.awt.geom.GeneralPath.
                  WIND_EVEN_ODD);
            path.
              moveTo(
                x,
                y);
            bounds =
              new java.awt.geom.Rectangle2D.Float(
                x,
                y,
                0,
                0);
        }
        else {
            path.
              lineTo(
                x,
                y);
            float _xmax =
              (float)
                bounds.
                getMaxX(
                  );
            float _ymax =
              (float)
                bounds.
                getMaxY(
                  );
            float _xmin =
              (float)
                bounds.
                getMinX(
                  );
            float _ymin =
              (float)
                bounds.
                getMinY(
                  );
            if (x <
                  _xmin)
                _xmin =
                  x;
            else
                if (x >
                      _xmax)
                    _xmax =
                      x;
            if (y <
                  _ymin)
                _ymin =
                  y;
            else
                if (y >
                      _ymax)
                    _ymax =
                      y;
            bounds =
              new java.awt.geom.Rectangle2D.Float(
                _xmin,
                _ymin,
                _xmax -
                  _xmin,
                _ymax -
                  _ymin);
        }
    }
    public void addPoint(java.awt.geom.Point2D p) {
        addPoint(
          (float)
            p.
            getX(
              ),
          (float)
            p.
            getY(
              ));
    }
    public void addPoint(float x, float y) {
        if (npoints ==
              xpoints.
                length) {
            float[] tmp;
            tmp =
              (new float[npoints *
                           2]);
            java.lang.System.
              arraycopy(
                xpoints,
                0,
                tmp,
                0,
                npoints);
            xpoints =
              tmp;
            tmp =
              (new float[npoints *
                           2]);
            java.lang.System.
              arraycopy(
                ypoints,
                0,
                tmp,
                0,
                npoints);
            ypoints =
              tmp;
        }
        xpoints[npoints] =
          x;
        ypoints[npoints] =
          y;
        npoints++;
        updatePath(
          x,
          y);
    }
    public java.awt.Rectangle getBounds() {
        if (bounds ==
              null)
            return null;
        else
            return bounds.
              getBounds(
                );
    }
    private void updateComputingPath() { if (npoints >=
                                               1) {
                                             if (closedPath ==
                                                   null) {
                                                 closedPath =
                                                   (java.awt.geom.GeneralPath)
                                                     path.
                                                     clone(
                                                       );
                                                 closedPath.
                                                   closePath(
                                                     );
                                             }
                                         }
    }
    public boolean contains(java.awt.Point p) {
        return false;
    }
    public boolean contains(double x, double y) {
        return false;
    }
    public boolean contains(int x, int y) {
        return false;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        return bounds;
    }
    public boolean contains(java.awt.geom.Point2D p) {
        return false;
    }
    public boolean intersects(double x, double y,
                              double w,
                              double h) {
        if (npoints <=
              0 ||
              !bounds.
              intersects(
                x,
                y,
                w,
                h)) {
            return false;
        }
        updateComputingPath(
          );
        return closedPath.
          intersects(
            x,
            y,
            w,
            h);
    }
    public boolean intersects(java.awt.geom.Rectangle2D r) {
        return intersects(
                 r.
                   getX(
                     ),
                 r.
                   getY(
                     ),
                 r.
                   getWidth(
                     ),
                 r.
                   getHeight(
                     ));
    }
    public boolean contains(double x, double y,
                            double w,
                            double h) { return false;
    }
    public boolean contains(java.awt.geom.Rectangle2D r) {
        return false;
    }
    public java.awt.geom.PathIterator getPathIterator(java.awt.geom.AffineTransform at) {
        if (path ==
              null)
            return null;
        else
            return path.
              getPathIterator(
                at);
    }
    public org.apache.batik.ext.awt.geom.Polygon2D getPolygon2D() {
        org.apache.batik.ext.awt.geom.Polygon2D pol =
          new org.apache.batik.ext.awt.geom.Polygon2D(
          );
        for (int i =
               0;
             i <
               npoints -
               1;
             i++) {
            pol.
              addPoint(
                xpoints[i],
                ypoints[i]);
        }
        java.awt.geom.Point2D.Double p0 =
          new java.awt.geom.Point2D.Double(
          xpoints[0],
          ypoints[0]);
        java.awt.geom.Point2D.Double p1 =
          new java.awt.geom.Point2D.Double(
          xpoints[npoints -
                    1],
          ypoints[npoints -
                    1]);
        if (p0.
              distance(
                p1) >
              ASSUME_ZERO)
            pol.
              addPoint(
                xpoints[npoints -
                          1],
                ypoints[npoints -
                          1]);
        return pol;
    }
    public java.awt.geom.PathIterator getPathIterator(java.awt.geom.AffineTransform at,
                                                      double flatness) {
        return path.
          getPathIterator(
            at);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DQNHdhQ3S8nq/wH7OxIbazgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UC+JtMnOygMn2EzL+Fgq1sCgJcpVj9HU");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
