package org.apache.batik.ext.awt.geom;
public class Polygon2D implements java.awt.Shape, java.lang.Cloneable, java.io.Serializable {
    public int npoints;
    public float[] xpoints;
    public float[] ypoints;
    protected java.awt.geom.Rectangle2D bounds;
    private java.awt.geom.GeneralPath path;
    private java.awt.geom.GeneralPath closedPath;
    public Polygon2D() { super();
                         xpoints = (new float[4]);
                         ypoints = (new float[4]); }
    public Polygon2D(java.awt.geom.Rectangle2D rec) { super();
                                                      if (rec == null) { throw new java.lang.IndexOutOfBoundsException(
                                                                           "null Rectangle");
                                                      }
                                                      npoints =
                                                        4;
                                                      xpoints =
                                                        (new float[4]);
                                                      ypoints =
                                                        (new float[4]);
                                                      xpoints[0] =
                                                        (float)
                                                          rec.
                                                          getMinX(
                                                            );
                                                      ypoints[0] =
                                                        (float)
                                                          rec.
                                                          getMinY(
                                                            );
                                                      xpoints[1] =
                                                        (float)
                                                          rec.
                                                          getMaxX(
                                                            );
                                                      ypoints[1] =
                                                        (float)
                                                          rec.
                                                          getMinY(
                                                            );
                                                      xpoints[2] =
                                                        (float)
                                                          rec.
                                                          getMaxX(
                                                            );
                                                      ypoints[2] =
                                                        (float)
                                                          rec.
                                                          getMaxY(
                                                            );
                                                      xpoints[3] =
                                                        (float)
                                                          rec.
                                                          getMinX(
                                                            );
                                                      ypoints[3] =
                                                        (float)
                                                          rec.
                                                          getMaxY(
                                                            );
                                                      calculatePath(
                                                        );
    }
    public Polygon2D(java.awt.Polygon pol) { super();
                                             if (pol == null) {
                                                 throw new java.lang.IndexOutOfBoundsException(
                                                   "null Polygon");
                                             }
                                             this.
                                               npoints =
                                               pol.
                                                 npoints;
                                             this.
                                               xpoints =
                                               (new float[pol.
                                                            npoints]);
                                             this.
                                               ypoints =
                                               (new float[pol.
                                                            npoints]);
                                             for (int i =
                                                    0;
                                                  i <
                                                    pol.
                                                      npoints;
                                                  i++) {
                                                 xpoints[i] =
                                                   pol.
                                                     xpoints[i];
                                                 ypoints[i] =
                                                   pol.
                                                     ypoints[i];
                                             }
                                             calculatePath(
                                               );
    }
    public Polygon2D(float[] xpoints, float[] ypoints,
                     int npoints) { super();
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
                                      ); }
    public Polygon2D(int[] xpoints, int[] ypoints,
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
                                      ); }
    public void reset() { npoints = 0;
                          bounds = null;
                          path = new java.awt.geom.GeneralPath(
                                   );
                          closedPath = null;
    }
    public java.lang.Object clone() { org.apache.batik.ext.awt.geom.Polygon2D pol =
                                        new org.apache.batik.ext.awt.geom.Polygon2D(
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
    public org.apache.batik.ext.awt.geom.Polyline2D getPolyline2D() {
        org.apache.batik.ext.awt.geom.Polyline2D pol =
          new org.apache.batik.ext.awt.geom.Polyline2D(
          xpoints,
          ypoints,
          npoints);
        pol.
          addPoint(
            xpoints[0],
            ypoints[0]);
        return pol;
    }
    public java.awt.Polygon getPolygon() {
        int[] _xpoints =
          new int[npoints];
        int[] _ypoints =
          new int[npoints];
        for (int i =
               0;
             i <
               npoints;
             i++) {
            _xpoints[i] =
              (int)
                xpoints[i];
            _ypoints[i] =
              (int)
                ypoints[i];
        }
        return new java.awt.Polygon(
          _xpoints,
          _ypoints,
          npoints);
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
    public boolean contains(java.awt.Point p) {
        return contains(
                 p.
                   x,
                 p.
                   y);
    }
    public boolean contains(int x, int y) {
        return contains(
                 (double)
                   x,
                 (double)
                   y);
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        return bounds;
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
    public boolean contains(double x, double y) {
        if (npoints <=
              2 ||
              !bounds.
              contains(
                x,
                y)) {
            return false;
        }
        updateComputingPath(
          );
        return closedPath.
          contains(
            x,
            y);
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
    public boolean contains(java.awt.geom.Point2D p) {
        return contains(
                 p.
                   getX(
                     ),
                 p.
                   getY(
                     ));
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
                            double h) { if (npoints <=
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
                                          contains(
                                            x,
                                            y,
                                            w,
                                            h);
    }
    public boolean contains(java.awt.geom.Rectangle2D r) {
        return contains(
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
    public java.awt.geom.PathIterator getPathIterator(java.awt.geom.AffineTransform at) {
        updateComputingPath(
          );
        if (closedPath ==
              null)
            return null;
        else
            return closedPath.
              getPathIterator(
                at);
    }
    public java.awt.geom.PathIterator getPathIterator(java.awt.geom.AffineTransform at,
                                                      double flatness) {
        return getPathIterator(
                 at);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "n0CsjTXu9PC5VsZQJgr09VJzyn2fb3W7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "feo7+Qnq/w/UPY5luEcAAA==");
}
