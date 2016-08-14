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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1bDXQcxX2fO0mnb0uWbPlDWP6SndrGd7HBBVcEYmTZFpxs" +
       "VTLmIT7k1d5It3hvd9mdk852HWPeS6BOwiNgqFOC06SmFNfGtA3kE+KEpMBz" +
       "CYG6DRiKE/KaQIDW9JU4wW3p/z+ze7u3d7vOVXrRezva25n/zP/3/5r/zM4e" +
       "fY9UWSZZZEhaSoqznQa14v143y+ZFk11q5JlbYWnw/L+n92399w/1e6LktgQ" +
       "mZaWrD5ZsugGhaopa4jMUzSLSZpMrc2UppCi36QWNcclpujaEJmpWL0ZQ1Vk" +
       "hfXpKYoNtklmkkyXGDOVkSyjvXYHjMxPcm4SnJvEOn+DriRpkHVjp0swt4Cg" +
       "21OHbTPueBYjzclbpXEpkWWKmkgqFuvKmWSFoas7x1SdxWmOxW9V19iCuCa5" +
       "pkgMix5v+vX5e9LNXAytkqbpjEO0Bqilq+M0lSRN7tMelWas28inSEWS1Hsa" +
       "M9KZdAZNwKAJGNTB67YC7hupls106xwOc3qKGTIyxMjCwk4MyZQydjf9nGfo" +
       "oYbZ2DkxoF2QR+uo2wfx/hWJA392S/PfVZCmIdKkaIPIjgxMMBhkCARKMyPU" +
       "tNalUjQ1RKZroPBBaiqSquyytd1iKWOaxLJgAo5Y8GHWoCYf05UVaBKwmVmZ" +
       "6WYe3ig3KvtX1agqjQHWNherQLgBnwPAOgUYM0clsD2bpHKHoqW4HRVS5DF2" +
       "XgsNgLQ6Q1lazw9VqUnwgLQIE1ElbSwxCManjUHTKh1M0OS2FtApytqQ5B3S" +
       "GB1mZLa/Xb+ogla1XBBIwshMfzPeE2hprk9LHv28t/mKu3drm7QoiQDPKSqr" +
       "yH89EHX4iAboKDUp+IEgbFiefEBqe+quKCHQeKavsWjz9T95/5MXd5x4TrRp" +
       "L9Fmy8itVGbD8uGRaS9d1L1sbQWyUWPoloLKL0DOvazfrunKGRBp2vI9YmXc" +
       "qTwx8A833H6EvhMldb0kJutqNgN2NF3WM4aiUnMj1agpMZrqJbVUS3Xz+l5S" +
       "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" +
       "ori9TY78H/+sqgqWPQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "BktNsryKBI27cZeRGXuM9CCH34xanXC4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
