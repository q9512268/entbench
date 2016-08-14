package org.apache.batik.gvt;
public class MarkerShapePainter implements org.apache.batik.gvt.ShapePainter {
    protected org.apache.batik.ext.awt.geom.ExtendedShape extShape;
    protected org.apache.batik.gvt.Marker startMarker;
    protected org.apache.batik.gvt.Marker middleMarker;
    protected org.apache.batik.gvt.Marker endMarker;
    private org.apache.batik.gvt.ProxyGraphicsNode startMarkerProxy;
    private org.apache.batik.gvt.ProxyGraphicsNode[] middleMarkerProxies;
    private org.apache.batik.gvt.ProxyGraphicsNode endMarkerProxy;
    private org.apache.batik.gvt.CompositeGraphicsNode markerGroup;
    private java.awt.geom.Rectangle2D dPrimitiveBounds;
    private java.awt.geom.Rectangle2D dGeometryBounds;
    public MarkerShapePainter(java.awt.Shape shape) { super();
                                                      if (shape == null) {
                                                          throw new java.lang.IllegalArgumentException(
                                                            );
                                                      }
                                                      if (shape instanceof org.apache.batik.ext.awt.geom.ExtendedShape) {
                                                          this.
                                                            extShape =
                                                            (org.apache.batik.ext.awt.geom.ExtendedShape)
                                                              shape;
                                                      }
                                                      else {
                                                          this.
                                                            extShape =
                                                            new org.apache.batik.ext.awt.geom.ShapeExtender(
                                                              shape);
                                                      }
    }
    public void paint(java.awt.Graphics2D g2d) {
        if (markerGroup ==
              null) {
            buildMarkerGroup(
              );
        }
        if (markerGroup.
              getChildren(
                ).
              size(
                ) >
              0) {
            markerGroup.
              paint(
                g2d);
        }
    }
    public java.awt.Shape getPaintedArea() {
        if (markerGroup ==
              null) {
            buildMarkerGroup(
              );
        }
        return markerGroup.
          getOutline(
            );
    }
    public java.awt.geom.Rectangle2D getPaintedBounds2D() {
        if (markerGroup ==
              null) {
            buildMarkerGroup(
              );
        }
        return markerGroup.
          getPrimitiveBounds(
            );
    }
    public boolean inPaintedArea(java.awt.geom.Point2D pt) {
        if (markerGroup ==
              null) {
            buildMarkerGroup(
              );
        }
        org.apache.batik.gvt.GraphicsNode gn =
          markerGroup.
          nodeHitAt(
            pt);
        return gn !=
          null;
    }
    public java.awt.Shape getSensitiveArea() {
        return null;
    }
    public java.awt.geom.Rectangle2D getSensitiveBounds2D() {
        return null;
    }
    public boolean inSensitiveArea(java.awt.geom.Point2D pt) {
        return false;
    }
    public void setShape(java.awt.Shape shape) {
        if (shape ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (shape instanceof org.apache.batik.ext.awt.geom.ExtendedShape) {
            this.
              extShape =
              (org.apache.batik.ext.awt.geom.ExtendedShape)
                shape;
        }
        else {
            this.
              extShape =
              new org.apache.batik.ext.awt.geom.ShapeExtender(
                shape);
        }
        this.
          startMarkerProxy =
          null;
        this.
          middleMarkerProxies =
          null;
        this.
          endMarkerProxy =
          null;
        this.
          markerGroup =
          null;
    }
    public org.apache.batik.ext.awt.geom.ExtendedShape getExtShape() {
        return extShape;
    }
    public java.awt.Shape getShape() { return extShape;
    }
    public org.apache.batik.gvt.Marker getStartMarker() {
        return startMarker;
    }
    public void setStartMarker(org.apache.batik.gvt.Marker startMarker) {
        this.
          startMarker =
          startMarker;
        this.
          startMarkerProxy =
          null;
        this.
          markerGroup =
          null;
    }
    public org.apache.batik.gvt.Marker getMiddleMarker() {
        return middleMarker;
    }
    public void setMiddleMarker(org.apache.batik.gvt.Marker middleMarker) {
        this.
          middleMarker =
          middleMarker;
        this.
          middleMarkerProxies =
          null;
        this.
          markerGroup =
          null;
    }
    public org.apache.batik.gvt.Marker getEndMarker() {
        return endMarker;
    }
    public void setEndMarker(org.apache.batik.gvt.Marker endMarker) {
        this.
          endMarker =
          endMarker;
        this.
          endMarkerProxy =
          null;
        this.
          markerGroup =
          null;
    }
    protected void buildMarkerGroup() { if (startMarker !=
                                              null &&
                                              startMarkerProxy ==
                                              null) {
                                            startMarkerProxy =
                                              buildStartMarkerProxy(
                                                );
                                        }
                                        if (middleMarker !=
                                              null &&
                                              middleMarkerProxies ==
                                              null) {
                                            middleMarkerProxies =
                                              buildMiddleMarkerProxies(
                                                );
                                        }
                                        if (endMarker !=
                                              null &&
                                              endMarkerProxy ==
                                              null) {
                                            endMarkerProxy =
                                              buildEndMarkerProxy(
                                                );
                                        }
                                        org.apache.batik.gvt.CompositeGraphicsNode group =
                                          new org.apache.batik.gvt.CompositeGraphicsNode(
                                          );
                                        java.util.List children =
                                          group.
                                          getChildren(
                                            );
                                        if (startMarkerProxy !=
                                              null) {
                                            children.
                                              add(
                                                startMarkerProxy);
                                        }
                                        if (middleMarkerProxies !=
                                              null) {
                                            for (int i =
                                                   0;
                                                 i <
                                                   middleMarkerProxies.
                                                     length;
                                                 i++) {
                                                children.
                                                  add(
                                                    middleMarkerProxies[i]);
                                            }
                                        }
                                        if (endMarkerProxy !=
                                              null) {
                                            children.
                                              add(
                                                endMarkerProxy);
                                        }
                                        markerGroup =
                                          group;
    }
    protected org.apache.batik.gvt.ProxyGraphicsNode buildStartMarkerProxy() {
        org.apache.batik.ext.awt.geom.ExtendedPathIterator iter =
          getExtShape(
            ).
          getExtendedPathIterator(
            );
        double[] coords =
          new double[7];
        int segType =
          0;
        if (iter.
              isDone(
                )) {
            return null;
        }
        segType =
          iter.
            currentSegment(
              coords);
        if (segType !=
              org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                SEG_MOVETO) {
            return null;
        }
        iter.
          next(
            );
        java.awt.geom.Point2D markerPosition =
          new java.awt.geom.Point2D.Double(
          coords[0],
          coords[1]);
        double rotation =
          startMarker.
          getOrient(
            );
        if (java.lang.Double.
              isNaN(
                rotation)) {
            if (!iter.
                  isDone(
                    )) {
                double[] next =
                  new double[7];
                int nextSegType =
                  0;
                nextSegType =
                  iter.
                    currentSegment(
                      next);
                if (nextSegType ==
                      java.awt.geom.PathIterator.
                        SEG_CLOSE) {
                    nextSegType =
                      java.awt.geom.PathIterator.
                        SEG_LINETO;
                    next[0] =
                      coords[0];
                    next[1] =
                      coords[1];
                }
                rotation =
                  computeRotation(
                    null,
                    0,
                    coords,
                    segType,
                    next,
                    nextSegType);
            }
        }
        java.awt.geom.AffineTransform markerTxf =
          computeMarkerTransform(
            startMarker,
            markerPosition,
            rotation);
        org.apache.batik.gvt.ProxyGraphicsNode gn =
          new org.apache.batik.gvt.ProxyGraphicsNode(
          );
        gn.
          setSource(
            startMarker.
              getMarkerNode(
                ));
        gn.
          setTransform(
            markerTxf);
        return gn;
    }
    protected org.apache.batik.gvt.ProxyGraphicsNode buildEndMarkerProxy() {
        org.apache.batik.ext.awt.geom.ExtendedPathIterator iter =
          getExtShape(
            ).
          getExtendedPathIterator(
            );
        int nPoints =
          0;
        if (iter.
              isDone(
                )) {
            return null;
        }
        double[] coords =
          new double[7];
        double[] moveTo =
          new double[2];
        int segType =
          0;
        segType =
          iter.
            currentSegment(
              coords);
        if (segType !=
              org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                SEG_MOVETO) {
            return null;
        }
        nPoints++;
        moveTo[0] =
          coords[0];
        moveTo[1] =
          coords[1];
        iter.
          next(
            );
        double[] lastButOne =
          new double[7];
        double[] last =
          { coords[0],
        coords[1],
        coords[2],
        coords[3],
        coords[4],
        coords[5],
        coords[6] };
        double[] tmp =
          null;
        int lastSegType =
          segType;
        int lastButOneSegType =
          0;
        while (!iter.
                 isDone(
                   )) {
            tmp =
              lastButOne;
            lastButOne =
              last;
            last =
              tmp;
            lastButOneSegType =
              lastSegType;
            lastSegType =
              iter.
                currentSegment(
                  last);
            if (lastSegType ==
                  java.awt.geom.PathIterator.
                    SEG_MOVETO) {
                moveTo[0] =
                  last[0];
                moveTo[1] =
                  last[1];
            }
            else
                if (lastSegType ==
                      java.awt.geom.PathIterator.
                        SEG_CLOSE) {
                    lastSegType =
                      java.awt.geom.PathIterator.
                        SEG_LINETO;
                    last[0] =
                      moveTo[0];
                    last[1] =
                      moveTo[1];
                }
            iter.
              next(
                );
            nPoints++;
        }
        if (nPoints <
              2) {
            return null;
        }
        java.awt.geom.Point2D markerPosition =
          getSegmentTerminatingPoint(
            last,
            lastSegType);
        double rotation =
          endMarker.
          getOrient(
            );
        if (java.lang.Double.
              isNaN(
                rotation)) {
            rotation =
              computeRotation(
                lastButOne,
                lastButOneSegType,
                last,
                lastSegType,
                null,
                0);
        }
        java.awt.geom.AffineTransform markerTxf =
          computeMarkerTransform(
            endMarker,
            markerPosition,
            rotation);
        org.apache.batik.gvt.ProxyGraphicsNode gn =
          new org.apache.batik.gvt.ProxyGraphicsNode(
          );
        gn.
          setSource(
            endMarker.
              getMarkerNode(
                ));
        gn.
          setTransform(
            markerTxf);
        return gn;
    }
    protected org.apache.batik.gvt.ProxyGraphicsNode[] buildMiddleMarkerProxies() {
        org.apache.batik.ext.awt.geom.ExtendedPathIterator iter =
          getExtShape(
            ).
          getExtendedPathIterator(
            );
        double[] prev =
          new double[7];
        double[] curr =
          new double[7];
        double[] next =
          new double[7];
        double[] tmp =
          null;
        int prevSegType =
          0;
        int currSegType =
          0;
        int nextSegType =
          0;
        if (iter.
              isDone(
                )) {
            return null;
        }
        prevSegType =
          iter.
            currentSegment(
              prev);
        double[] moveTo =
          new double[2];
        if (prevSegType !=
              java.awt.geom.PathIterator.
                SEG_MOVETO) {
            return null;
        }
        moveTo[0] =
          prev[0];
        moveTo[1] =
          prev[1];
        iter.
          next(
            );
        if (iter.
              isDone(
                )) {
            return null;
        }
        currSegType =
          iter.
            currentSegment(
              curr);
        if (currSegType ==
              java.awt.geom.PathIterator.
                SEG_MOVETO) {
            moveTo[0] =
              curr[0];
            moveTo[1] =
              curr[1];
        }
        else
            if (currSegType ==
                  java.awt.geom.PathIterator.
                    SEG_CLOSE) {
                currSegType =
                  java.awt.geom.PathIterator.
                    SEG_LINETO;
                curr[0] =
                  moveTo[0];
                curr[1] =
                  moveTo[1];
            }
        iter.
          next(
            );
        java.util.List proxies =
          new java.util.ArrayList(
          );
        while (!iter.
                 isDone(
                   )) {
            nextSegType =
              iter.
                currentSegment(
                  next);
            if (nextSegType ==
                  java.awt.geom.PathIterator.
                    SEG_MOVETO) {
                moveTo[0] =
                  next[0];
                moveTo[1] =
                  next[1];
            }
            else
                if (nextSegType ==
                      java.awt.geom.PathIterator.
                        SEG_CLOSE) {
                    nextSegType =
                      java.awt.geom.PathIterator.
                        SEG_LINETO;
                    next[0] =
                      moveTo[0];
                    next[1] =
                      moveTo[1];
                }
            proxies.
              add(
                createMiddleMarker(
                  prev,
                  prevSegType,
                  curr,
                  currSegType,
                  next,
                  nextSegType));
            tmp =
              prev;
            prev =
              curr;
            prevSegType =
              currSegType;
            curr =
              next;
            currSegType =
              nextSegType;
            next =
              tmp;
            iter.
              next(
                );
        }
        org.apache.batik.gvt.ProxyGraphicsNode[] gn =
          new org.apache.batik.gvt.ProxyGraphicsNode[proxies.
                                                       size(
                                                         )];
        proxies.
          toArray(
            gn);
        return gn;
    }
    private org.apache.batik.gvt.ProxyGraphicsNode createMiddleMarker(double[] prev,
                                                                      int prevSegType,
                                                                      double[] curr,
                                                                      int currSegType,
                                                                      double[] next,
                                                                      int nextSegType) {
        java.awt.geom.Point2D markerPosition =
          getSegmentTerminatingPoint(
            curr,
            currSegType);
        double rotation =
          middleMarker.
          getOrient(
            );
        if (java.lang.Double.
              isNaN(
                rotation)) {
            rotation =
              computeRotation(
                prev,
                prevSegType,
                curr,
                currSegType,
                next,
                nextSegType);
        }
        java.awt.geom.AffineTransform markerTxf =
          computeMarkerTransform(
            middleMarker,
            markerPosition,
            rotation);
        org.apache.batik.gvt.ProxyGraphicsNode gn =
          new org.apache.batik.gvt.ProxyGraphicsNode(
          );
        gn.
          setSource(
            middleMarker.
              getMarkerNode(
                ));
        gn.
          setTransform(
            markerTxf);
        return gn;
    }
    private double computeRotation(double[] prev,
                                   int prevSegType,
                                   double[] curr,
                                   int currSegType,
                                   double[] next,
                                   int nextSegType) {
        double[] inSlope =
          computeInSlope(
            prev,
            prevSegType,
            curr,
            currSegType);
        double[] outSlope =
          computeOutSlope(
            curr,
            currSegType,
            next,
            nextSegType);
        if (inSlope ==
              null) {
            inSlope =
              outSlope;
        }
        if (outSlope ==
              null) {
            outSlope =
              inSlope;
        }
        if (inSlope ==
              null) {
            return 0;
        }
        double dx =
          inSlope[0] +
          outSlope[0];
        double dy =
          inSlope[1] +
          outSlope[1];
        if (dx ==
              0 &&
              dy ==
              0) {
            return java.lang.Math.
              toDegrees(
                java.lang.Math.
                  atan2(
                    inSlope[1],
                    inSlope[0])) +
              90;
        }
        else {
            return java.lang.Math.
              toDegrees(
                java.lang.Math.
                  atan2(
                    dy,
                    dx));
        }
    }
    private double[] computeInSlope(double[] prev,
                                    int prevSegType,
                                    double[] curr,
                                    int currSegType) {
        java.awt.geom.Point2D currEndPoint =
          getSegmentTerminatingPoint(
            curr,
            currSegType);
        double dx =
          0;
        double dy =
          0;
        switch (currSegType) {
            case java.awt.geom.PathIterator.
                   SEG_LINETO:
                {
                    java.awt.geom.Point2D prevEndPoint =
                      getSegmentTerminatingPoint(
                        prev,
                        prevSegType);
                    dx =
                      currEndPoint.
                        getX(
                          ) -
                        prevEndPoint.
                        getX(
                          );
                    dy =
                      currEndPoint.
                        getY(
                          ) -
                        prevEndPoint.
                        getY(
                          );
                }
                break;
            case java.awt.geom.PathIterator.
                   SEG_QUADTO:
                dx =
                  currEndPoint.
                    getX(
                      ) -
                    curr[0];
                dy =
                  currEndPoint.
                    getY(
                      ) -
                    curr[1];
                break;
            case java.awt.geom.PathIterator.
                   SEG_CUBICTO:
                dx =
                  currEndPoint.
                    getX(
                      ) -
                    curr[2];
                dy =
                  currEndPoint.
                    getY(
                      ) -
                    curr[3];
                break;
            case org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                   SEG_ARCTO:
                {
                    java.awt.geom.Point2D prevEndPoint =
                      getSegmentTerminatingPoint(
                        prev,
                        prevSegType);
                    boolean large =
                      curr[3] !=
                      0.0;
                    boolean goLeft =
                      curr[4] !=
                      0.0;
                    java.awt.geom.Arc2D arc =
                      org.apache.batik.ext.awt.geom.ExtendedGeneralPath.
                      computeArc(
                        prevEndPoint.
                          getX(
                            ),
                        prevEndPoint.
                          getY(
                            ),
                        curr[0],
                        curr[1],
                        curr[2],
                        large,
                        goLeft,
                        curr[5],
                        curr[6]);
                    double theta =
                      arc.
                      getAngleStart(
                        ) +
                      arc.
                      getAngleExtent(
                        );
                    theta =
                      java.lang.Math.
                        toRadians(
                          theta);
                    dx =
                      -arc.
                        getWidth(
                          ) /
                        2.0 *
                        java.lang.Math.
                        sin(
                          theta);
                    dy =
                      arc.
                        getHeight(
                          ) /
                        2.0 *
                        java.lang.Math.
                        cos(
                          theta);
                    if (curr[2] !=
                          0) {
                        double ang =
                          java.lang.Math.
                          toRadians(
                            -curr[2]);
                        double sinA =
                          java.lang.Math.
                          sin(
                            ang);
                        double cosA =
                          java.lang.Math.
                          cos(
                            ang);
                        double tdx =
                          dx *
                          cosA -
                          dy *
                          sinA;
                        double tdy =
                          dx *
                          sinA +
                          dy *
                          cosA;
                        dx =
                          tdx;
                        dy =
                          tdy;
                    }
                    if (goLeft) {
                        dx =
                          -dx;
                    }
                    else {
                        dy =
                          -dy;
                    }
                }
                break;
            case java.awt.geom.PathIterator.
                   SEG_CLOSE:
                throw new java.lang.Error(
                  "should not have SEG_CLOSE here");
            case java.awt.geom.PathIterator.
                   SEG_MOVETO:
            default:
                return null;
        }
        if (dx ==
              0 &&
              dy ==
              0) {
            return null;
        }
        return normalize(
                 new double[] { dx,
                 dy });
    }
    private double[] computeOutSlope(double[] curr,
                                     int currSegType,
                                     double[] next,
                                     int nextSegType) {
        java.awt.geom.Point2D currEndPoint =
          getSegmentTerminatingPoint(
            curr,
            currSegType);
        double dx =
          0;
        double dy =
          0;
        switch (nextSegType) {
            case java.awt.geom.PathIterator.
                   SEG_CLOSE:
                break;
            case java.awt.geom.PathIterator.
                   SEG_CUBICTO:
            case java.awt.geom.PathIterator.
                   SEG_LINETO:
            case java.awt.geom.PathIterator.
                   SEG_QUADTO:
                dx =
                  next[0] -
                    currEndPoint.
                    getX(
                      );
                dy =
                  next[1] -
                    currEndPoint.
                    getY(
                      );
                break;
            case org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                   SEG_ARCTO:
                {
                    boolean large =
                      next[3] !=
                      0.0;
                    boolean goLeft =
                      next[4] !=
                      0.0;
                    java.awt.geom.Arc2D arc =
                      org.apache.batik.ext.awt.geom.ExtendedGeneralPath.
                      computeArc(
                        currEndPoint.
                          getX(
                            ),
                        currEndPoint.
                          getY(
                            ),
                        next[0],
                        next[1],
                        next[2],
                        large,
                        goLeft,
                        next[5],
                        next[6]);
                    double theta =
                      arc.
                      getAngleStart(
                        );
                    theta =
                      java.lang.Math.
                        toRadians(
                          theta);
                    dx =
                      -arc.
                        getWidth(
                          ) /
                        2.0 *
                        java.lang.Math.
                        sin(
                          theta);
                    dy =
                      arc.
                        getHeight(
                          ) /
                        2.0 *
                        java.lang.Math.
                        cos(
                          theta);
                    if (next[2] !=
                          0) {
                        double ang =
                          java.lang.Math.
                          toRadians(
                            -next[2]);
                        double sinA =
                          java.lang.Math.
                          sin(
                            ang);
                        double cosA =
                          java.lang.Math.
                          cos(
                            ang);
                        double tdx =
                          dx *
                          cosA -
                          dy *
                          sinA;
                        double tdy =
                          dx *
                          sinA +
                          dy *
                          cosA;
                        dx =
                          tdx;
                        dy =
                          tdy;
                    }
                    if (goLeft) {
                        dx =
                          -dx;
                    }
                    else {
                        dy =
                          -dy;
                    }
                }
                break;
            case java.awt.geom.PathIterator.
                   SEG_MOVETO:
            default:
                return null;
        }
        if (dx ==
              0 &&
              dy ==
              0) {
            return null;
        }
        return normalize(
                 new double[] { dx,
                 dy });
    }
    public double[] normalize(double[] v) {
        double n =
          java.lang.Math.
          sqrt(
            v[0] *
              v[0] +
              v[1] *
              v[1]);
        v[0] /=
          n;
        v[1] /=
          n;
        return v;
    }
    private java.awt.geom.AffineTransform computeMarkerTransform(org.apache.batik.gvt.Marker marker,
                                                                 java.awt.geom.Point2D markerPosition,
                                                                 double rotation) {
        java.awt.geom.Point2D ref =
          marker.
          getRef(
            );
        java.awt.geom.AffineTransform txf =
          new java.awt.geom.AffineTransform(
          );
        txf.
          translate(
            markerPosition.
              getX(
                ) -
              ref.
              getX(
                ),
            markerPosition.
              getY(
                ) -
              ref.
              getY(
                ));
        if (!java.lang.Double.
              isNaN(
                rotation)) {
            txf.
              rotate(
                java.lang.Math.
                  toRadians(
                    rotation),
                ref.
                  getX(
                    ),
                ref.
                  getY(
                    ));
        }
        return txf;
    }
    protected java.awt.geom.Point2D getSegmentTerminatingPoint(double[] coords,
                                                               int segType) {
        switch (segType) {
            case java.awt.geom.PathIterator.
                   SEG_CUBICTO:
                return new java.awt.geom.Point2D.Double(
                  coords[4],
                  coords[5]);
            case java.awt.geom.PathIterator.
                   SEG_LINETO:
                return new java.awt.geom.Point2D.Double(
                  coords[0],
                  coords[1]);
            case java.awt.geom.PathIterator.
                   SEG_MOVETO:
                return new java.awt.geom.Point2D.Double(
                  coords[0],
                  coords[1]);
            case java.awt.geom.PathIterator.
                   SEG_QUADTO:
                return new java.awt.geom.Point2D.Double(
                  coords[2],
                  coords[3]);
            case org.apache.batik.ext.awt.geom.ExtendedPathIterator.
                   SEG_ARCTO:
                return new java.awt.geom.Point2D.Double(
                  coords[5],
                  coords[6]);
            case java.awt.geom.PathIterator.
                   SEG_CLOSE:
            default:
                throw new java.lang.Error(
                  "invalid segmentType:" +
                  segType);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVbDXAUx5XuXf2if8SvERJCCBLA7NoEnMJycEAWIGcFKonI" +
       "dQJbjGZbq4HZmfFMr7TCx9mQXJnEjs9xwPalAlVOSHB8YBLXJXHqEoc4CYmP" +
       "XCp2uPw5MXfnxOc723VwqfjucC6597pndmZnd0beulpVTWt2ul/3+75+/fp1" +
       "z/SZt0iVZZIOqrEYmzGoFevT2KBkWjTZq0qWtRuejcmPVUi/u+v1nZuipHqU" +
       "NE1K1oAsWXSbQtWkNUraFc1ikiZTayelSZQYNKlFzSmJKbo2ShYoVn/aUBVZ" +
       "YQN6kmKBEclMkLkSY6YynmG0366AkfYEaBLnmsS3+LN7EqRB1o0Zt/hiT/Fe" +
       "Tw6WTLttWYy0JPZLU1I8wxQ1nlAs1pM1yVpDV2dSqs5iNMti+9WNNgW3JzYW" +
       "UND1pea333l4soVTME/SNJ1xeNYQtXR1iiYTpNl92qfStHU3+QtSkSD1nsKM" +
       "dCecRuPQaBwaddC6pUD7Rqpl0r06h8OcmqoNGRViZHl+JYZkSmm7mkGuM9RQ" +
       "y2zsXBjQdubQCpQFEI+vjR977K6WZypI8yhpVrRhVEcGJRg0MgqE0vQ4Na0t" +
       "ySRNjpK5GnT2MDUVSVUO2j3daikpTWIZ6H6HFnyYMajJ23S5gn4EbGZGZrqZ" +
       "gzfBDcr+VTWhSinAutDFKhBuw+cAsE4BxcwJCezOFqk8oGhJRpb5JXIYuz8E" +
       "BUC0Jk3ZpJ5rqlKT4AFpFSaiSloqPgymp6WgaJUOBmgysiSwUuTakOQDUoqO" +
       "oUX6yg2KLCg1hxOBIows8BfjNUEvLfH1kqd/3tp5y0P3aDu0KImAzkkqq6h/" +
       "PQh1+ISG6AQ1KYwDIdiwJvGotPCbR6OEQOEFvsKizNf+/OoHr+84/wNRpq1I" +
       "mV3j+6nMxuRT400vLu1dvakC1ag1dEvBzs9DzkfZoJ3TkzXAwyzM1YiZMSfz" +
       "/NCFP7vvKfpGlNT1k2pZVzNpsKO5sp42FJWa26lGTYnRZD+ZQ7VkL8/vJzVw" +
       "n1A0Kp7umpiwKOsnlSp/VK3z30DRBFSBFNXBvaJN6M69IbFJfp81CCE1cJH3" +
       "w7WGiD/+n5HR+KSepnFJljRF0+ODpo74rTh4nHHgdjI+DlZ/IG7pGRNMMK6b" +
       "qbgEdjBJ7YzUFIsPSOYBag5PSuATJW6vMbQxo6y1ZxHbvOlIBGhf6h/0KoyX" +
       "HbqapOaYfCyzte/q02MXhUHhILBZYeQ90GBMNBjjDcagwVhhgyQS4e3Mx4ZF" +
       "10LHHIAhDj62YfXwnbfvO9pVATZlTFcCq1i0K2+u6XX9gOO8x+RzrY0Hl79y" +
       "43eipDJBWiWZZSQVp44tZgqcknzAHrcN4zALuZNBp2cywFnM1GWaBF8UNCnY" +
       "tdTqU9TE54zM99TgTFU4KOPBE0VR/cn5x6cPj9x7Q5RE8/0/NlkFrgvFB9Fr" +
       "57xzt3/cF6u3+f7X3z736CHd9QB5E4ozDxZIIoYuvyX46RmT13RKXxn75qFu" +
       "Tvsc8NAMOhmdX4e/jTwH0+M4a8RSC4AndDMtqZjlcFzHJk192n3CTXQuv58P" +
       "ZlGPI64dLmoPQf4fcxcamC4SJo125kPBJ4MPDBsnfv6jf3sfp9uZN5o9E/4w" +
       "ZT0eX4WVtXKvNNc1290mpVDu148Pfur4W/fv4TYLJVYUa7Ab017wUdCFQPNf" +
       "/uDuX1x+5dSlqGvnDCbrzDjEPNkcSHxO6kJAQmurXH3A16ngEdBquj+sgX0q" +
       "E4o0rlIcWH9oXnnjV958qEXYgQpPHDO6fvYK3OfXbSX3Xbzrvzp4NREZ51qX" +
       "M7eYcODz3Jq3mKY0g3pkD7/U/tffl07AVADu11IOUu5RI/ZYR6UWM9LEJaVp" +
       "FuOeg/flRp55A083IA9chPC8TZistLxjIn/YeUKlMfnhS1caR648d5WDyI+1" +
       "vCYwIBk9wuowWZWF6hf5fdYOyZqEchvO79zbop5/B2ochRpl8L/WLhM8ZjbP" +
       "YOzSVTW//PZ3Fu57sYJEt5E6VZeS2yQ+9sgcMHpqTYKzzRq3flD0+XQtJC0c" +
       "KikAX/AAeV9WvEf70gbjfXDw2UV/e8vpk69w4zNEHW1cvg79f56z5RG7O96f" +
       "+sn7//H0Jx+dFnP+6mAn55NbfG2XOn7kX/67gHLu3orEIz750fiZzyzp3fwG" +
       "l3f9DEp3ZwvnLPDVruz6p9K/j3ZVfy9KakZJi2xHyCOSmsHROwpRoeWEzRBF" +
       "5+XnR3ginOnJ+dGlfh/nadbv4dy5Eu6xNN43+pxaE3bhSrji9niP+51ahPCb" +
       "D3GR9/B0DSbrHB8yxzB1BlrSpM+NNIZUy0gtdCAfas4IXFswm2MX44hMUT0d" +
       "68syCKMgmkcZ4WkxvRmThGj5A4EG3JcPeDlcG2zNNgQAHhGAMdlZiCtImpF6" +
       "6A2TiSDEgdYWEqj4oNxRIpQuuDbZymwKgDIWCiVImkEgoiSTKnX13ONTdl+J" +
       "yi6Da7Pd3OYAZSdClQ2SZjzIDtY09e41bXDstdduqzdA03TgkKgxTGUKVgS+" +
       "AVEfUiks/j2GA3FPdsaxnlVFrYcX2W5KxqQiWzshDvQh1kpEjJa8w1ZuRwDi" +
       "rNs3RiG0IGlG5nkNCRVXYLbK29DBQHY4M24xPm2L1d7e+gvfsj732jPC83cV" +
       "KexbQj55ulZ+OX3hN0LguiICotyCJ+OfGPnZ/h/yUKwW4/Pdjnv0RN8Qx3vi" +
       "wJZ8ttrD2AJoK4PnKQ/Ck19Y8aN7T674Zz6J1yoWeHNotcgC2yNz5czlN15q" +
       "bH+ax7+VqLyteP7OROHGQ95+AsfUjMnhbIl2lgsAvBFUn6jKtpOjxUdGFG9j" +
       "DKYpRZNUe3D8Cf4icP0RL2QSH+B/mAl77RV2Z26JbcCyr1qlWopNWqHRwKCp" +
       "pCGOnrJNI36o9fKBz7x+VpiGf+r3FaZHj338T7GHjonIVezXrCjYMvHKiD0b" +
       "YSiYPIg2sDysFS6x7V/PHfq7Jw/dL7Rqzd996NMy6bM//d8fxh7/pxeKLH4r" +
       "oIPxx0cNNySLCpqdDhXRMAYSsV5V1ygG1k6eWAsreiy3OwaZ2YK+NUl7XnA2" +
       "wG3IjXR+3fTIq1/vTm0tZRGMzzpmWebi72XAyZrgHvar8v0j/75k9+bJfSWs" +
       "Z5f5eshf5RcHzrywfZX8SJRvwIkQrGDjLl+oJz/wqjMpy5ja7rzwa4UYLLz3" +
       "XI+6lhtOyJLjVEjeFzB5AoaWjB0t7CKk+BcLo3h80Gt4An7XBObne1IxSG77" +
       "WPM3Hm6t2AY9309qM5pyd4b2J/PR11iZcY9rdfcWXS7s4YKDnpHIGlgc+Oax" +
       "mRLnsXVwDdieeSBgHvty6DwWJA2LxFyMwb0iPmU+dZ8pUd0YXEN2g0MB6j4b" +
       "qm6QNISiaa7rdlPPGM64X1PUyaOjxX0HGhJQfL1EZKvhusPW7Y4AZN8ORRYk" +
       "DbFSMudMt+oZLWk58K7LLeP5omEI1iXg/lS6/jYfmudLRPNeuPba+uwNQPP3" +
       "oWiCpBlpTm4HZSkzZwQYfHzBp+/FEH09YdnaXLv8r5r4dow97XoW4bldkOVF" +
       "rcO7l4oTW3vQ9j+f1E4dOXYyuevzN0ZtX3MMYnOmG+tUOkVVT6Nt/P5EPs2r" +
       "4MrYCmf8NLuU+LBWORwHifpcoW/vZ17OaBzzX38bb+xyiAt9FZNfgsc1kBhe" +
       "5K+EL+P3n2KkckpXkm4PvjybxYXvsgj/7ONsLubhquqwDfzwu+Yst9MXJBqC" +
       "/WpI3u8weRN8ZYoyYTPJLSaV8OlNLhlvlYGMRZiHXucBG9EDpZMRJBoC+I/B" +
       "eRFexf9AJOuSIYa48EcXXEKulYGQeZjXCddxG9Xx0gkJEg0fUQvy3fCgDtDF" +
       "mIrUh9CFC5JINSONiuYxHav44s8XtK8f3Ccf7R78jeN27vUMRt/ArBnXdZVK" +
       "ml97/Hk2m+uTSE25RizuPz1hE/tE6X0SJBrCbGdIXhcmbTCpgpEOU83ipBaO" +
       "2cjSco3ZtXCdtjGdLp2OINEQyOtC8uKYvBdWSF46io/ayOpyjVrc1jtr4zpb" +
       "OiVBosVHLSJp4NhvDuHlFkw2Mv7Rhc9KIq0uJTeVgRL+6g13qb9q4/pq6ZQE" +
       "iQZSQm7isLeHUNKPyVZGai3KcvvSv3W56C0DF9dhXjdcF21AF0vnIkg0BOru" +
       "kLwRTHbBegNGTF/WZWLIZWKwXK4U6bhkw7lUOhNBoiFopZA8GZO9YBApj0F4" +
       "XOidZaChFfM64fqVjeVXpdMQJBoCVQvJQ+GIImLAYXdXG4vuccnYXy5PsR6u" +
       "12xEr5VORpBosKfYw1HfE8LIIUymgBGrgBGPv5gul3lgwHHFhnWldEaCREMA" +
       "Hw3J+zgmH4GZBMxjwP+KyWXjo+WyDyx2zYZ0rXQ2gkRns4/jIZQ8hsnDQIlV" +
       "SInHQD5ZLgPpAE0rRZ3if0mUBIqGIP5sSN4pTE4w0oATSt5rPZeKk+Wyjhjg" +
       "aLLxNJVORZDobNZxLoSPL2PyFPBh+fjwmMbflIEP5+uASJsNqm0WPgrf2AaK" +
       "hsD9Rkjec5h8DRYr4xlFtZngG5w+Op4tAx2dmLcRsNxqY7q1dDqCREMgvxCS" +
       "dxGT78KCm9Mx7HuDjBLM5eR75eLkfQAoawPLls5JkGgI7p+G5P0ckxcZmcc5" +
       "6SvcsncZeakMjODSjdwMcH5sw/px6YwEiYagfjUk77eYvMLIYjFoCl/Go9B9" +
       "Li2Xy0BLB+bdQEi0Q9Qp/ofQUriFHijqg17NFanmvw/lauEOCAOhvPf2jIz8" +
       "Pz9yxsMN0jSL405XvDczrsjO59NlqlkwfgQ76j/5fYR/Llh8r6s6qWec177F" +
       "t7r823d9omLxTiPyB9EhPC14lY/JA7zfHsTkIUweQanfF76Uxp+PY/Lp4s2e" +
       "EM1yafwdEh9EK0LyqjDh+E4LTULK1gTZbuFrUJcwh20OtngxLHUVG6hz7/jD" +
       "KyHKNGKBNxhplU0qMeqPAj1e680y7jpF7QkqOtvcVmR4BokWH57FSMqnK7o4" +
       "hK4lmMyDiBmPYWQYHbJf92MVb+e4is4vA1cLMG8FAJ20AU+WzlWQqA9xJVek" +
       "MpChlSEMYdPRTlhz2gz1a8OqzrckIlddgpaXi6BuQPe8jfL50gkKEi2RoPUh" +
       "BG3AZJ1rQrsyrBhDsTIwhBd+RFZRL+oU/0MYKlxpBIr6EHs2ea9y2LeGULIF" +
       "k5sZmaPx4xHKQT8ZPWUgYynmrQckC21EC0s2l0BRH9YKrkgF/sRPRCMN3F1w" +
       "6IkQWnZisp2RhbalCLe825Q0C8+RcJnFjLTnv/baMjGhaDS/FCdxRxlI5MAh" +
       "vqqI2UzEZiGxMOwMFPUx487o3pG2J4S/OzEZYWQJf6eSSkMEtJuaaUUDl62l" +
       "+OtB3hsuRbN+B/1uKMrCbFp4HAwPLCwuOGcqzkbKT59srl108sM/E59XOucX" +
       "GxKkdiKjqt5P6j331YZJJxROcIP4wJ5/xhTF01rFvqhgpAJS1DqaFCUnYUXr" +
       "L8lIFf/vLQcP69xyEN6JG28RDWqHInir5z77aXE/BRRnCrIi6mrzMshfRC+Y" +
       "jficiPfcEX6dx0/4Om9pM+KM75h87uTtO++5etPnxbknWZUOHsRa6hOkRhzB" +
       "4pXi13jLA2tz6qresfqdpi/NWem8450rFHYNu821OfzCOmJgXy/xHQqyunNn" +
       "g35x6pbn/uFo9UtREtlDIhKsGfcUnr7IGhmTtO9JFH4FNyKZ/LRSz+pPz2y+" +
       "fuI/XubnW4j4am5pcPkx+dLpO3/yyOJTHVFS30+qFC1Js/xYyG0z2hCVp8xR" +
       "0qhYfVlQEWpRJDXvE7smNEsJz/5yXmw6G3NP8dQcI12FX6wWnjWsU/VpavK3" +
       "m1hNY4LUu09Ez/g+aMwYhk/AfWJ3JaZnMHmQr+jBHscSA4bhfNhbec3g4/Ns" +
       "YPAcPcJv8e4j/wet6brB/T8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9swutimzARo306q2pFQ+YtKVhK8qWmeV");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "nHmXh0/Epbu94jMSdnYW4ZMXQPj6PBMsg297dI/w0Vsj2NtOdqfyo7sHlwsT" +
       "LPBcOQdrfiDn8O1x6dG9THf+axwqXpR/RKNo8+q49MTVT6ebhmF7+tW1Cs48" +
       "cwHOFIwAkcBtV/acuXKznLl+1HMy/5xW9Hecw5R35Qkelx4vHrya+YQ61sOl" +
       "7QHf5pnFo/mCxSe46zeDOwVzxrVfhck/cfHYNZ+b2n0iSf3MCw/c9ZoXJv9l" +
       "d4z36DNGd1Olu4zEdU9/euDU/aUg1A274MndRXo5KOARcelV19shjEu3gTQn" +
       "97Czq9kD65azNePSHcX/0/WGcemek3ogvNjdnK7CgN5BlfyWPT7Rd+oQ1e7b" +
       "C+kuFnjstIYUOzgv61SOm5z+Ykp+crX40NfRKdNk96mv59TPvjBgvvUrtR/b" +
       "fbFFdZUsy3u5iyrduft4TNFpflL1jTfs7aivS723/8Xlz939lqOt0ss7gk+0" +
       "9RRtb7j+51GIZRAXHzTJ/uVr/vk7PvnCbxenyP4/IuTi1IFNAAA=");
}
