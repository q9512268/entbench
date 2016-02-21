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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Vm+1Wj+cbxm8cX9bGY8VuzYnN050E8sbvnQfuxXJ+RMeHu0WXeb4IPQ5Idyf" +
       "hBZ/V6AzVxhObY+dOh47ON4+eu6Oo/2T04riKDLwoWfvdhmlOMr48qdfe12c" +
       "/ELl8Oj0kQqhh0LH/agpbSXz1IyXwUgfvvuxzai4i7M/FfvNT/+364sfUT91" +
       "H2f9z5/BeXbIvz9647e7HxD+xiF04eSM7I5bQrd3euX2k7GHfSmMfHtx2/nY" +
       "sycKKLYjfwg8148UcP3s/uRe/+dvTn5oZz9nDncPd5q/h8pyOUih5OcqOyZ7" +
       "8jTZfPfZmvaLGX7jHsfHX8uLXw+hi5ErcqF03s7bJd5xTImz95b8z77fvtvp" +
       "WYqKXzsRW76jC70fPB88EtsH70Nsh8DcXN8JJSGUiq3lr54rwgt7bx3si4L0" +
       "9+8hi3+fF18HstDsQBMLpf/unul/9TaYfiqvfAE8Lx8x/fIPxlZOo//P92j7" +
       "Zl78RyA8RQqLje6C6q/vmfujt8FccfEkv0z10SPmPvqDYe7g9tj17B2OMFe5" +
       "fMc+v7MoFSP8z3uI4Dt58a0QYPIll/Ol053P3W/eOpq4F9D/eLsCGoNneiSg" +
       "6Q9GQEdmfiyg99whIJrbHdgeU7x0B0U/v08Z7K6onMjx4MLd5XjwUF75ZyF0" +
       "TTvuerKE5C1/uhfZ996GyIrFDISKg6PDn4M7Dn/etsMcPH6Ptify4tEQugoc" +
       "ZhxZJywGe3nmPB5ceRs8Fqv4SwDuU0c8PvWD4fFwnzrsA9/B8/fg9sW8uA7y" +
       "GMDtCatFnMip915w8MzbjYEg8B88c8TuM+9ImHj6jpO9ERf6WlIrOC3dQwpw" +
       "XnwghB4FUlg5vimeFykPPng/IkhA6nZ8ZTK///X0Hfexd3eIhV9+/crlp15f" +
       "/pvi1uDJPd+HKOiyHJnm6es6p94vglAma4VQHtpd3nELRuohdP3udziLJfSU" +
       "OR+gu15NYO1ne4EwmH+cJvtYCL3rFBlID47eThN9PIQuAKL89RPuOWeXu8tL" +
       "ycGpjPHIXorIce37yfiky+m7hXmWWVyL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("P84Io93F+FvCV14fjH/02/Vf2N1tFEwuKw6nL1PQpd01y5Os8sW7jnY81sXe" +
       "y9999Fceev9xBvzoDvDedk9he/78i4Sk5YbF1b/sHz/1Dz/2d1//g+Io9f8D" +
       "NXvbgK8wAAA=");
}
