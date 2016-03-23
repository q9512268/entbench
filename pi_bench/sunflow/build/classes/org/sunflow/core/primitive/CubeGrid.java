package org.sunflow.core.primitive;
public abstract class CubeGrid implements org.sunflow.core.PrimitiveList {
    private int nx;
    private int ny;
    private int nz;
    private float voxelwx;
    private float voxelwy;
    private float voxelwz;
    private float invVoxelwx;
    private float invVoxelwy;
    private float invVoxelwz;
    private org.sunflow.math.BoundingBox bounds;
    public CubeGrid() { super();
                        nx = (ny = (nz = 1));
                        bounds = new org.sunflow.math.BoundingBox(1); }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        nx =
          pl.
            getInt(
              "resolutionX",
              nx);
        ny =
          pl.
            getInt(
              "resolutionY",
              ny);
        nz =
          pl.
            getInt(
              "resolutionZ",
              nz);
        voxelwx =
          2.0F /
            nx;
        voxelwy =
          2.0F /
            ny;
        voxelwz =
          2.0F /
            nz;
        invVoxelwx =
          1 /
            voxelwx;
        invVoxelwy =
          1 /
            voxelwy;
        invVoxelwz =
          1 /
            voxelwz;
        return true;
    }
    protected abstract boolean inside(int x, int y, int z);
    public org.sunflow.math.BoundingBox getBounds() { return bounds;
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
        org.sunflow.core.Instance parent =
          state.
          getInstance(
            );
        org.sunflow.math.Vector3 normal;
        switch (state.
                  getPrimitiveID(
                    )) {
            case 0:
                normal =
                  new org.sunflow.math.Vector3(
                    -1,
                    0,
                    0);
                break;
            case 1:
                normal =
                  new org.sunflow.math.Vector3(
                    1,
                    0,
                    0);
                break;
            case 2:
                normal =
                  new org.sunflow.math.Vector3(
                    0,
                    -1,
                    0);
                break;
            case 3:
                normal =
                  new org.sunflow.math.Vector3(
                    0,
                    1,
                    0);
                break;
            case 4:
                normal =
                  new org.sunflow.math.Vector3(
                    0,
                    0,
                    -1);
                break;
            case 5:
                normal =
                  new org.sunflow.math.Vector3(
                    0,
                    0,
                    1);
                break;
            default:
                normal =
                  new org.sunflow.math.Vector3(
                    0,
                    0,
                    0);
                break;
        }
        state.
          getNormal(
            ).
          set(
            parent.
              transformNormalObjectToWorld(
                normal));
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
            parent.
              getShader(
                0));
        state.
          setModifier(
            parent.
              getModifier(
                0));
    }
    public void intersectPrimitive(org.sunflow.core.Ray r, int primID,
                                   org.sunflow.core.IntersectionState state) {
        float intervalMin =
          r.
          getMin(
            );
        float intervalMax =
          r.
          getMax(
            );
        float orgX =
          r.
            ox;
        float orgY =
          r.
            oy;
        float orgZ =
          r.
            oz;
        float dirX =
          r.
            dx;
        float invDirX =
          1 /
          dirX;
        float dirY =
          r.
            dy;
        float invDirY =
          1 /
          dirY;
        float dirZ =
          r.
            dz;
        float invDirZ =
          1 /
          dirZ;
        float t1;
        float t2;
        t1 =
          (-1 -
             orgX) *
            invDirX;
        t2 =
          (+1 -
             orgX) *
            invDirX;
        int curr =
          -1;
        if (invDirX >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                curr =
                  0;
            }
            if (t2 <
                  intervalMax)
                intervalMax =
                  t2;
            if (intervalMin >
                  intervalMax)
                return;
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                curr =
                  1;
            }
            if (t1 <
                  intervalMax)
                intervalMax =
                  t1;
            if (intervalMin >
                  intervalMax)
                return;
        }
        t1 =
          (-1 -
             orgY) *
            invDirY;
        t2 =
          (+1 -
             orgY) *
            invDirY;
        if (invDirY >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                curr =
                  2;
            }
            if (t2 <
                  intervalMax)
                intervalMax =
                  t2;
            if (intervalMin >
                  intervalMax)
                return;
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                curr =
                  3;
            }
            if (t1 <
                  intervalMax)
                intervalMax =
                  t1;
            if (intervalMin >
                  intervalMax)
                return;
        }
        t1 =
          (-1 -
             orgZ) *
            invDirZ;
        t2 =
          (+1 -
             orgZ) *
            invDirZ;
        if (invDirZ >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                curr =
                  4;
            }
            if (t2 <
                  intervalMax)
                intervalMax =
                  t2;
            if (intervalMin >
                  intervalMax)
                return;
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                curr =
                  5;
            }
            if (t1 <
                  intervalMax)
                intervalMax =
                  t1;
            if (intervalMin >
                  intervalMax)
                return;
        }
        orgX +=
          intervalMin *
            dirX;
        orgY +=
          intervalMin *
            dirY;
        orgZ +=
          intervalMin *
            dirZ;
        int indxX;
        int indxY;
        int indxZ;
        int stepX;
        int stepY;
        int stepZ;
        int stopX;
        int stopY;
        int stopZ;
        float deltaX;
        float deltaY;
        float deltaZ;
        float tnextX;
        float tnextY;
        float tnextZ;
        indxX =
          (int)
            ((orgX +
                1) *
               invVoxelwx);
        if (indxX <
              0)
            indxX =
              0;
        else
            if (indxX >=
                  nx)
                indxX =
                  nx -
                    1;
        if (java.lang.Math.
              abs(
                dirX) <
              1.0E-6F) {
            stepX =
              0;
            stopX =
              indxX;
            deltaX =
              0;
            tnextX =
              java.lang.Float.
                POSITIVE_INFINITY;
        }
        else
            if (dirX >
                  0) {
                stepX =
                  1;
                stopX =
                  nx;
                deltaX =
                  voxelwx *
                    invDirX;
                tnextX =
                  intervalMin +
                    ((indxX +
                        1) *
                       voxelwx -
                       1 -
                       orgX) *
                    invDirX;
            }
            else {
                stepX =
                  -1;
                stopX =
                  -1;
                deltaX =
                  -voxelwx *
                    invDirX;
                tnextX =
                  intervalMin +
                    (indxX *
                       voxelwx -
                       1 -
                       orgX) *
                    invDirX;
            }
        indxY =
          (int)
            ((orgY +
                1) *
               invVoxelwy);
        if (indxY <
              0)
            indxY =
              0;
        else
            if (indxY >=
                  ny)
                indxY =
                  ny -
                    1;
        if (java.lang.Math.
              abs(
                dirY) <
              1.0E-6F) {
            stepY =
              0;
            stopY =
              indxY;
            deltaY =
              0;
            tnextY =
              java.lang.Float.
                POSITIVE_INFINITY;
        }
        else
            if (dirY >
                  0) {
                stepY =
                  1;
                stopY =
                  ny;
                deltaY =
                  voxelwy *
                    invDirY;
                tnextY =
                  intervalMin +
                    ((indxY +
                        1) *
                       voxelwy -
                       1 -
                       orgY) *
                    invDirY;
            }
            else {
                stepY =
                  -1;
                stopY =
                  -1;
                deltaY =
                  -voxelwy *
                    invDirY;
                tnextY =
                  intervalMin +
                    (indxY *
                       voxelwy -
                       1 -
                       orgY) *
                    invDirY;
            }
        indxZ =
          (int)
            ((orgZ +
                1) *
               invVoxelwz);
        if (indxZ <
              0)
            indxZ =
              0;
        else
            if (indxZ >=
                  nz)
                indxZ =
                  nz -
                    1;
        if (java.lang.Math.
              abs(
                dirZ) <
              1.0E-6F) {
            stepZ =
              0;
            stopZ =
              indxZ;
            deltaZ =
              0;
            tnextZ =
              java.lang.Float.
                POSITIVE_INFINITY;
        }
        else
            if (dirZ >
                  0) {
                stepZ =
                  1;
                stopZ =
                  nz;
                deltaZ =
                  voxelwz *
                    invDirZ;
                tnextZ =
                  intervalMin +
                    ((indxZ +
                        1) *
                       voxelwz -
                       1 -
                       orgZ) *
                    invDirZ;
            }
            else {
                stepZ =
                  -1;
                stopZ =
                  -1;
                deltaZ =
                  -voxelwz *
                    invDirZ;
                tnextZ =
                  intervalMin +
                    (indxZ *
                       voxelwz -
                       1 -
                       orgZ) *
                    invDirZ;
            }
        boolean isInside =
          inside(
            indxX,
            indxY,
            indxZ) &&
          bounds.
          contains(
            r.
              ox,
            r.
              oy,
            r.
              oz);
        for (;
             ;
             ) {
            if (inside(
                  indxX,
                  indxY,
                  indxZ) !=
                  isInside) {
                r.
                  setMax(
                    intervalMin);
                if (isInside)
                    curr ^=
                      1;
                state.
                  setIntersection(
                    curr,
                    0,
                    0);
                return;
            }
            if (tnextX <
                  tnextY &&
                  tnextX <
                  tnextZ) {
                curr =
                  dirX >
                    0
                    ? 0
                    : 1;
                intervalMin =
                  tnextX;
                if (intervalMin >
                      intervalMax)
                    return;
                indxX +=
                  stepX;
                if (indxX ==
                      stopX)
                    return;
                tnextX +=
                  deltaX;
            }
            else
                if (tnextY <
                      tnextZ) {
                    curr =
                      dirY >
                        0
                        ? 2
                        : 3;
                    intervalMin =
                      tnextY;
                    if (intervalMin >
                          intervalMax)
                        return;
                    indxY +=
                      stepY;
                    if (indxY ==
                          stopY)
                        return;
                    tnextY +=
                      deltaY;
                }
                else {
                    curr =
                      dirZ >
                        0
                        ? 4
                        : 5;
                    intervalMin =
                      tnextZ;
                    if (intervalMin >
                          intervalMax)
                        return;
                    indxZ +=
                      stepZ;
                    if (indxZ ==
                          stopZ)
                        return;
                    tnextZ +=
                      deltaZ;
                }
        }
    }
    public int getNumPrimitives() { return 1; }
    public float getPrimitiveBound(int primID, int i) { return (i &
                                                                  1) ==
                                                          0
                                                          ? -1
                                                          : 1; }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        if (o2w ==
              null)
            return bounds;
        return o2w.
          transform(
            bounds);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "QHetGsDaz7YCYTC/nSb7eFh6zykykB4c");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("PZ0m+kRYugCI8seXvXP2O3cHnpKDUxnjkb0UkePaD5LxSZPT5xHzLLM4LH+c" +
       "EUa74/KvqF99vcf+xHewX9ydh1QtJSs2tC8zpUu7o5knWeXzd+ztuK+L1Ivf" +
       "e/hXH/jgcQb88A7w3nZPYXv2/MOHbdsLi+OC2T954h99/O+9/ofF9uv/BxxK" +
       "N0vFMAAA");
}
