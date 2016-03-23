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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Ux4hAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
