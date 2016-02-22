package org.sunflow.core.primitive;
public class Box implements org.sunflow.core.PrimitiveList {
    private float minX;
    private float minY;
    private float minZ;
    private float maxX;
    private float maxY;
    private float maxZ;
    public Box() { super();
                   minX = (minY = (minZ = -1));
                   maxX = (maxY = (maxZ = +1)); }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        org.sunflow.core.ParameterList.FloatParameter pts =
          pl.
          getPointArray(
            "points");
        if (pts !=
              null) {
            org.sunflow.math.BoundingBox bounds =
              new org.sunflow.math.BoundingBox(
              );
            for (int i =
                   0;
                 i <
                   pts.
                     data.
                     length;
                 i +=
                   3)
                bounds.
                  include(
                    pts.
                      data[i],
                    pts.
                      data[i +
                             1],
                    pts.
                      data[i +
                             2]);
            minX =
              bounds.
                getMinimum(
                  ).
                x;
            minY =
              bounds.
                getMinimum(
                  ).
                y;
            minZ =
              bounds.
                getMinimum(
                  ).
                z;
            maxX =
              bounds.
                getMaximum(
                  ).
                x;
            maxY =
              bounds.
                getMaximum(
                  ).
                y;
            maxZ =
              bounds.
                getMaximum(
                  ).
                z;
        }
        return true;
    }
    public void prepareShadingState(org.sunflow.core.ShadingState state) {
        state.
          init(
            );
        state.
          getRay(
            ).
          getPoint(
            state.
              getPoint(
                ));
        int n =
          state.
          getPrimitiveID(
            );
        switch (n) {
            case 0:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      1,
                      0,
                      0));
                break;
            case 1:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      -1,
                      0,
                      0));
                break;
            case 2:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      1,
                      0));
                break;
            case 3:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      -1,
                      0));
                break;
            case 4:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      0,
                      1));
                break;
            case 5:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      0,
                      -1));
                break;
            default:
                state.
                  getNormal(
                    ).
                  set(
                    new org.sunflow.math.Vector3(
                      0,
                      0,
                      0));
                break;
        }
        state.
          getGeoNormal(
            ).
          set(
            state.
              getNormal(
                ));
        state.
          setBasis(
            org.sunflow.math.OrthoNormalBasis.
              makeFromW(
                state.
                  getNormal(
                    )));
        state.
          setShader(
            state.
              getInstance(
                ).
              getShader(
                0));
        state.
          setModifier(
            state.
              getInstance(
                ).
              getModifier(
                0));
    }
    public void intersectPrimitive(org.sunflow.core.Ray r, int primID,
                                   org.sunflow.core.IntersectionState state) {
        float intervalMin =
          java.lang.Float.
            NEGATIVE_INFINITY;
        float intervalMax =
          java.lang.Float.
            POSITIVE_INFINITY;
        float orgX =
          r.
            ox;
        float invDirX =
          1 /
          r.
            dx;
        float t1;
        float t2;
        t1 =
          (minX -
             orgX) *
            invDirX;
        t2 =
          (maxX -
             orgX) *
            invDirX;
        int sideIn =
          -1;
        int sideOut =
          -1;
        if (invDirX >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                sideIn =
                  0;
            }
            if (t2 <
                  intervalMax) {
                intervalMax =
                  t2;
                sideOut =
                  1;
            }
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                sideIn =
                  1;
            }
            if (t1 <
                  intervalMax) {
                intervalMax =
                  t1;
                sideOut =
                  0;
            }
        }
        if (intervalMin >
              intervalMax)
            return;
        float orgY =
          r.
            oy;
        float invDirY =
          1 /
          r.
            dy;
        t1 =
          (minY -
             orgY) *
            invDirY;
        t2 =
          (maxY -
             orgY) *
            invDirY;
        if (invDirY >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                sideIn =
                  2;
            }
            if (t2 <
                  intervalMax) {
                intervalMax =
                  t2;
                sideOut =
                  3;
            }
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                sideIn =
                  3;
            }
            if (t1 <
                  intervalMax) {
                intervalMax =
                  t1;
                sideOut =
                  2;
            }
        }
        if (intervalMin >
              intervalMax)
            return;
        float orgZ =
          r.
            oz;
        float invDirZ =
          1 /
          r.
            dz;
        t1 =
          (minZ -
             orgZ) *
            invDirZ;
        t2 =
          (maxZ -
             orgZ) *
            invDirZ;
        if (invDirZ >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                sideIn =
                  4;
            }
            if (t2 <
                  intervalMax) {
                intervalMax =
                  t2;
                sideOut =
                  5;
            }
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                sideIn =
                  5;
            }
            if (t1 <
                  intervalMax) {
                intervalMax =
                  t1;
                sideOut =
                  4;
            }
        }
        if (intervalMin >
              intervalMax)
            return;
        if (r.
              isInside(
                intervalMin)) {
            r.
              setMax(
                intervalMin);
            state.
              setIntersection(
                sideIn,
                0,
                0);
        }
        else
            if (r.
                  isInside(
                    intervalMax)) {
                r.
                  setMax(
                    intervalMax);
                state.
                  setIntersection(
                    sideOut,
                    0,
                    0);
            }
    }
    public int getNumPrimitives() { return 1; }
    public float getPrimitiveBound(int primID, int i) { switch (i) {
                                                            case 0:
                                                                return minX;
                                                            case 1:
                                                                return maxX;
                                                            case 2:
                                                                return minY;
                                                            case 3:
                                                                return maxY;
                                                            case 4:
                                                                return minZ;
                                                            case 5:
                                                                return maxZ;
                                                            default:
                                                                return 0;
                                                        } }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        org.sunflow.math.BoundingBox bounds =
          new org.sunflow.math.BoundingBox(
          minX,
          minY,
          minZ);
        bounds.
          include(
            maxX,
            maxY,
            maxZ);
        if (o2w ==
              null)
            return bounds;
        return o2w.
          transform(
            bounds);
    }
    public org.sunflow.core.PrimitiveList getBakingPrimitives() {
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "26Y5uighAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
