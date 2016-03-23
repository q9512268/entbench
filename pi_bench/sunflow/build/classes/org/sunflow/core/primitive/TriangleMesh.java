package org.sunflow.core.primitive;
public class TriangleMesh implements org.sunflow.core.PrimitiveList {
    private static boolean smallTriangles = false;
    protected float[] points;
    protected int[] triangles;
    private org.sunflow.core.primitive.TriangleMesh.WaldTriangle[] triaccel;
    private org.sunflow.core.ParameterList.FloatParameter normals;
    private org.sunflow.core.ParameterList.FloatParameter uvs;
    private byte[] faceShaders;
    public static void setSmallTriangles(boolean smallTriangles) { if (smallTriangles)
                                                                       org.sunflow.system.UI.
                                                                         printInfo(
                                                                           org.sunflow.system.UI.Module.
                                                                             GEOM,
                                                                           "Small trimesh mode: enabled");
                                                                   else
                                                                       org.sunflow.system.UI.
                                                                         printInfo(
                                                                           org.sunflow.system.UI.Module.
                                                                             GEOM,
                                                                           "Small trimesh mode: disabled");
                                                                   org.sunflow.core.primitive.TriangleMesh.
                                                                     smallTriangles =
                                                                     smallTriangles;
    }
    public TriangleMesh() { super();
                            triangles = null;
                            points = null;
                            normals = (uvs =
                                         new org.sunflow.core.ParameterList.FloatParameter(
                                           ));
                            faceShaders =
                              null; }
    public void writeObj(java.lang.String filename) {
        try {
            java.io.FileWriter file =
              new java.io.FileWriter(
              filename);
            file.
              write(
                java.lang.String.
                  format(
                    "o object\n"));
            for (int i =
                   0;
                 i <
                   points.
                     length;
                 i +=
                   3)
                file.
                  write(
                    java.lang.String.
                      format(
                        "v %g %g %g\n",
                        points[i],
                        points[i +
                                 1],
                        points[i +
                                 2]));
            file.
              write(
                "s off\n");
            for (int i =
                   0;
                 i <
                   triangles.
                     length;
                 i +=
                   3)
                file.
                  write(
                    java.lang.String.
                      format(
                        "f %d %d %d\n",
                        triangles[i] +
                          1,
                        triangles[i +
                                    1] +
                          1,
                        triangles[i +
                                    2] +
                          1));
            file.
              close(
                );
        }
        catch (java.io.IOException e) {
            e.
              printStackTrace(
                );
        }
    }
    public boolean update(org.sunflow.core.ParameterList pl,
                          org.sunflow.SunflowAPI api) {
        boolean updatedTopology =
          false;
        {
            int[] triangles =
              pl.
              getIntArray(
                "triangles");
            if (triangles !=
                  null) {
                this.
                  triangles =
                  triangles;
                updatedTopology =
                  true;
            }
        }
        if (triangles ==
              null) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  GEOM,
                "Unable to update mesh - triangle indices are missing");
            return false;
        }
        if (triangles.
              length %
              3 !=
              0)
            org.sunflow.system.UI.
              printWarning(
                org.sunflow.system.UI.Module.
                  GEOM,
                ("Triangle index data is not a multiple of 3 - triangles may b" +
                 "e missing"));
        pl.
          setFaceCount(
            triangles.
              length /
              3);
        {
            org.sunflow.core.ParameterList.FloatParameter pointsP =
              pl.
              getPointArray(
                "points");
            if (pointsP !=
                  null)
                if (pointsP.
                      interp !=
                      org.sunflow.core.ParameterList.InterpolationType.
                        VERTEX) {
                    org.sunflow.system.UI.
                      printError(
                        org.sunflow.system.UI.Module.
                          GEOM,
                        ("Point interpolation type must be set to \"vertex\" - was \"%" +
                         "s\""),
                        pointsP.
                          interp.
                          name(
                            ).
                          toLowerCase(
                            ));
                }
                else {
                    points =
                      pointsP.
                        data;
                    updatedTopology =
                      true;
                }
        }
        if (points ==
              null) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  GEOM,
                "Unable to update mesh - vertices are missing");
            return false;
        }
        pl.
          setVertexCount(
            points.
              length /
              3);
        pl.
          setFaceVertexCount(
            3 *
              (triangles.
                 length /
                 3));
        org.sunflow.core.ParameterList.FloatParameter normals =
          pl.
          getVectorArray(
            "normals");
        if (normals !=
              null)
            this.
              normals =
              normals;
        org.sunflow.core.ParameterList.FloatParameter uvs =
          pl.
          getTexCoordArray(
            "uvs");
        if (uvs !=
              null)
            this.
              uvs =
              uvs;
        int[] faceShaders =
          pl.
          getIntArray(
            "faceshaders");
        if (faceShaders !=
              null &&
              faceShaders.
                length ==
              triangles.
                length /
              3) {
            this.
              faceShaders =
              (new byte[faceShaders.
                          length]);
            for (int i =
                   0;
                 i <
                   faceShaders.
                     length;
                 i++) {
                int v =
                  faceShaders[i];
                if (v >
                      255)
                    org.sunflow.system.UI.
                      printWarning(
                        org.sunflow.system.UI.Module.
                          GEOM,
                        "Shader index too large on triangle %d",
                        i);
                this.
                  faceShaders[i] =
                  (byte)
                    (v &
                       255);
            }
        }
        if (updatedTopology) {
            init(
              );
        }
        return true;
    }
    public float getPrimitiveBound(int primID,
                                   int i) {
        int tri =
          3 *
          primID;
        int a =
          3 *
          triangles[tri +
                      0];
        int b =
          3 *
          triangles[tri +
                      1];
        int c =
          3 *
          triangles[tri +
                      2];
        int axis =
          i >>>
          1;
        if ((i &
               1) ==
              0)
            return org.sunflow.math.MathUtils.
              min(
                points[a +
                         axis],
                points[b +
                         axis],
                points[c +
                         axis]);
        else
            return org.sunflow.math.MathUtils.
              max(
                points[a +
                         axis],
                points[b +
                         axis],
                points[c +
                         axis]);
    }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        org.sunflow.math.BoundingBox bounds =
          new org.sunflow.math.BoundingBox(
          );
        if (o2w ==
              null) {
            for (int i =
                   0;
                 i <
                   points.
                     length;
                 i +=
                   3)
                bounds.
                  include(
                    points[i],
                    points[i +
                             1],
                    points[i +
                             2]);
        }
        else {
            for (int i =
                   0;
                 i <
                   points.
                     length;
                 i +=
                   3) {
                float x =
                  points[i];
                float y =
                  points[i +
                           1];
                float z =
                  points[i +
                           2];
                float wx =
                  o2w.
                  transformPX(
                    x,
                    y,
                    z);
                float wy =
                  o2w.
                  transformPY(
                    x,
                    y,
                    z);
                float wz =
                  o2w.
                  transformPZ(
                    x,
                    y,
                    z);
                bounds.
                  include(
                    wx,
                    wy,
                    wz);
            }
        }
        return bounds;
    }
    public void intersectPrimitiveRobust(org.sunflow.core.Ray r,
                                         int primID,
                                         org.sunflow.core.IntersectionState state) {
        int tri =
          3 *
          primID;
        int a =
          3 *
          triangles[tri +
                      0];
        int b =
          3 *
          triangles[tri +
                      1];
        int c =
          3 *
          triangles[tri +
                      2];
        final float[] stack =
          state.
          getRobustStack(
            );
        for (int i =
               0,
               i3 =
                 0;
             i <
               3;
             i++,
               i3 +=
                 3) {
            stack[i3 +
                    0] =
              points[a +
                       i];
            stack[i3 +
                    1] =
              points[b +
                       i];
            stack[i3 +
                    2] =
              points[c +
                       i];
        }
        stack[9] =
          java.lang.Float.
            POSITIVE_INFINITY;
        int stackpos =
          0;
        float orgX =
          r.
            ox;
        float dirX =
          r.
            dx;
        float invDirX =
          1 /
          dirX;
        float orgY =
          r.
            oy;
        float dirY =
          r.
            dy;
        float invDirY =
          1 /
          dirY;
        float orgZ =
          r.
            oz;
        float dirZ =
          r.
            dz;
        float invDirZ =
          1 /
          dirZ;
        float t1;
        float t2;
        float minx;
        float maxx;
        float miny;
        float maxy;
        float minz;
        float maxz;
        float mint =
          r.
          getMin(
            );
        float maxt =
          r.
          getMax(
            );
        while (stackpos >=
                 0) {
            float intervalMin =
              mint;
            float intervalMax =
              maxt;
            float p0x =
              stack[stackpos +
                      0];
            float p1x =
              stack[stackpos +
                      1];
            float p2x =
              stack[stackpos +
                      2];
            t1 =
              ((minx =
                  org.sunflow.math.MathUtils.
                    min(
                      p0x,
                      p1x,
                      p2x)) -
                 orgX) *
                invDirX;
            t2 =
              ((maxx =
                  org.sunflow.math.MathUtils.
                    max(
                      p0x,
                      p1x,
                      p2x)) -
                 orgX) *
                invDirX;
            if (invDirX >
                  0) {
                if (t1 >
                      intervalMin)
                    intervalMin =
                      t1;
                if (t2 <
                      intervalMax)
                    intervalMax =
                      t2;
            }
            else {
                if (t2 >
                      intervalMin)
                    intervalMin =
                      t2;
                if (t1 <
                      intervalMax)
                    intervalMax =
                      t1;
            }
            if (intervalMin >
                  intervalMax) {
                stackpos -=
                  10;
                continue;
            }
            float p0y =
              stack[stackpos +
                      3];
            float p1y =
              stack[stackpos +
                      4];
            float p2y =
              stack[stackpos +
                      5];
            t1 =
              ((miny =
                  org.sunflow.math.MathUtils.
                    min(
                      p0y,
                      p1y,
                      p2y)) -
                 orgY) *
                invDirY;
            t2 =
              ((maxy =
                  org.sunflow.math.MathUtils.
                    max(
                      p0y,
                      p1y,
                      p2y)) -
                 orgY) *
                invDirY;
            if (invDirY >
                  0) {
                if (t1 >
                      intervalMin)
                    intervalMin =
                      t1;
                if (t2 <
                      intervalMax)
                    intervalMax =
                      t2;
            }
            else {
                if (t2 >
                      intervalMin)
                    intervalMin =
                      t2;
                if (t1 <
                      intervalMax)
                    intervalMax =
                      t1;
            }
            if (intervalMin >
                  intervalMax) {
                stackpos -=
                  10;
                continue;
            }
            float p0z =
              stack[stackpos +
                      6];
            float p1z =
              stack[stackpos +
                      7];
            float p2z =
              stack[stackpos +
                      8];
            t1 =
              ((minz =
                  org.sunflow.math.MathUtils.
                    min(
                      p0z,
                      p1z,
                      p2z)) -
                 orgZ) *
                invDirZ;
            t2 =
              ((maxz =
                  org.sunflow.math.MathUtils.
                    max(
                      p0z,
                      p1z,
                      p2z)) -
                 orgZ) *
                invDirZ;
            if (invDirZ >
                  0) {
                if (t1 >
                      intervalMin)
                    intervalMin =
                      t1;
                if (t2 <
                      intervalMax)
                    intervalMax =
                      t2;
            }
            else {
                if (t2 >
                      intervalMin)
                    intervalMin =
                      t2;
                if (t1 <
                      intervalMax)
                    intervalMax =
                      t1;
            }
            if (intervalMin >
                  intervalMax) {
                stackpos -=
                  10;
                continue;
            }
            float size =
              maxx -
              minx +
              (maxy -
                 miny) +
              (maxz -
                 minz);
            if (java.lang.Float.
                  floatToRawIntBits(
                    stack[stackpos +
                            9]) ==
                  java.lang.Float.
                  floatToRawIntBits(
                    size)) {
                r.
                  setMax(
                    intervalMin);
                triaccel[primID].
                  intersectBox(
                    r,
                    p0x,
                    p0y,
                    p0z,
                    primID,
                    state);
                return;
            }
            float p01x =
              (p0x +
                 p1x) *
              0.5F;
            float p01y =
              (p0y +
                 p1y) *
              0.5F;
            float p01z =
              (p0z +
                 p1z) *
              0.5F;
            float p12x =
              (p1x +
                 p2x) *
              0.5F;
            float p12y =
              (p1y +
                 p2y) *
              0.5F;
            float p12z =
              (p1z +
                 p2z) *
              0.5F;
            float p20x =
              (p2x +
                 p0x) *
              0.5F;
            float p20y =
              (p2y +
                 p0y) *
              0.5F;
            float p20z =
              (p2z +
                 p0z) *
              0.5F;
            stack[stackpos +
                    0] =
              p0x;
            stack[stackpos +
                    1] =
              p01x;
            stack[stackpos +
                    2] =
              p20x;
            stack[stackpos +
                    3] =
              p0y;
            stack[stackpos +
                    4] =
              p01y;
            stack[stackpos +
                    5] =
              p20y;
            stack[stackpos +
                    6] =
              p0z;
            stack[stackpos +
                    7] =
              p01z;
            stack[stackpos +
                    8] =
              p20z;
            stack[stackpos +
                    9] =
              size;
            stackpos +=
              10;
            stack[stackpos +
                    0] =
              p1x;
            stack[stackpos +
                    1] =
              p12x;
            stack[stackpos +
                    2] =
              p01x;
            stack[stackpos +
                    3] =
              p1y;
            stack[stackpos +
                    4] =
              p12y;
            stack[stackpos +
                    5] =
              p01y;
            stack[stackpos +
                    6] =
              p1z;
            stack[stackpos +
                    7] =
              p12z;
            stack[stackpos +
                    8] =
              p01z;
            stack[stackpos +
                    9] =
              size;
            stackpos +=
              10;
            stack[stackpos +
                    0] =
              p2x;
            stack[stackpos +
                    1] =
              p20x;
            stack[stackpos +
                    2] =
              p12x;
            stack[stackpos +
                    3] =
              p2y;
            stack[stackpos +
                    4] =
              p20y;
            stack[stackpos +
                    5] =
              p12y;
            stack[stackpos +
                    6] =
              p2z;
            stack[stackpos +
                    7] =
              p20z;
            stack[stackpos +
                    8] =
              p12z;
            stack[stackpos +
                    9] =
              size;
            stackpos +=
              10;
            stack[stackpos +
                    0] =
              p20x;
            stack[stackpos +
                    1] =
              p12x;
            stack[stackpos +
                    2] =
              p01x;
            stack[stackpos +
                    3] =
              p20y;
            stack[stackpos +
                    4] =
              p12y;
            stack[stackpos +
                    5] =
              p01y;
            stack[stackpos +
                    6] =
              p20z;
            stack[stackpos +
                    7] =
              p12z;
            stack[stackpos +
                    8] =
              p01z;
            stack[stackpos +
                    9] =
              size;
        }
    }
    private final void intersectTriangleKensler(org.sunflow.core.Ray r,
                                                int primID,
                                                org.sunflow.core.IntersectionState state) {
        int tri =
          3 *
          primID;
        int a =
          3 *
          triangles[tri +
                      0];
        int b =
          3 *
          triangles[tri +
                      1];
        int c =
          3 *
          triangles[tri +
                      2];
        float edge0x =
          points[b +
                   0] -
          points[a +
                   0];
        float edge0y =
          points[b +
                   1] -
          points[a +
                   1];
        float edge0z =
          points[b +
                   2] -
          points[a +
                   2];
        float edge1x =
          points[a +
                   0] -
          points[c +
                   0];
        float edge1y =
          points[a +
                   1] -
          points[c +
                   1];
        float edge1z =
          points[a +
                   2] -
          points[c +
                   2];
        float nx =
          edge0y *
          edge1z -
          edge0z *
          edge1y;
        float ny =
          edge0z *
          edge1x -
          edge0x *
          edge1z;
        float nz =
          edge0x *
          edge1y -
          edge0y *
          edge1x;
        float v =
          r.
          dot(
            nx,
            ny,
            nz);
        float iv =
          1 /
          v;
        float edge2x =
          points[a +
                   0] -
          r.
            ox;
        float edge2y =
          points[a +
                   1] -
          r.
            oy;
        float edge2z =
          points[a +
                   2] -
          r.
            oz;
        float va =
          nx *
          edge2x +
          ny *
          edge2y +
          nz *
          edge2z;
        float t =
          iv *
          va;
        if (!r.
              isInside(
                t))
            return;
        float ix =
          edge2y *
          r.
            dz -
          edge2z *
          r.
            dy;
        float iy =
          edge2z *
          r.
            dx -
          edge2x *
          r.
            dz;
        float iz =
          edge2x *
          r.
            dy -
          edge2y *
          r.
            dx;
        float v1 =
          ix *
          edge1x +
          iy *
          edge1y +
          iz *
          edge1z;
        float beta =
          iv *
          v1;
        if (beta <
              0)
            return;
        float v2 =
          ix *
          edge0x +
          iy *
          edge0y +
          iz *
          edge0z;
        if ((v1 +
               v2) *
              v >
              v *
              v)
            return;
        float gamma =
          iv *
          v2;
        if (gamma <
              0)
            return;
        r.
          setMax(
            t);
        state.
          setIntersection(
            primID,
            beta,
            gamma);
    }
    public void intersectPrimitive(org.sunflow.core.Ray r,
                                   int primID,
                                   org.sunflow.core.IntersectionState state) {
        if (triaccel !=
              null) {
            triaccel[primID].
              intersect(
                r,
                primID,
                state);
            return;
        }
        intersectTriangleKensler(
          r,
          primID,
          state);
    }
    public int getNumPrimitives() { return triangles.
                                             length /
                                      3; }
    public void prepareShadingState(org.sunflow.core.ShadingState state) {
        state.
          init(
            );
        org.sunflow.core.Instance parent =
          state.
          getInstance(
            );
        int primID =
          state.
          getPrimitiveID(
            );
        float u =
          state.
          getU(
            );
        float v =
          state.
          getV(
            );
        float w =
          1 -
          u -
          v;
        state.
          getRay(
            ).
          getPoint(
            state.
              getPoint(
                ));
        int tri =
          3 *
          primID;
        int index0 =
          triangles[tri +
                      0];
        int index1 =
          triangles[tri +
                      1];
        int index2 =
          triangles[tri +
                      2];
        org.sunflow.math.Point3 v0p =
          getPoint(
            index0);
        org.sunflow.math.Point3 v1p =
          getPoint(
            index1);
        org.sunflow.math.Point3 v2p =
          getPoint(
            index2);
        org.sunflow.math.Vector3 ng =
          org.sunflow.math.Point3.
          normal(
            v0p,
            v1p,
            v2p);
        ng =
          parent.
            transformNormalObjectToWorld(
              ng);
        ng.
          normalize(
            );
        state.
          getGeoNormal(
            ).
          set(
            ng);
        switch (normals.
                  interp) {
            case NONE:
            case FACE:
                {
                    state.
                      getNormal(
                        ).
                      set(
                        ng);
                    break;
                }
            case VERTEX:
                {
                    int i30 =
                      3 *
                      index0;
                    int i31 =
                      3 *
                      index1;
                    int i32 =
                      3 *
                      index2;
                    float[] normals =
                      this.
                        normals.
                        data;
                    state.
                      getNormal(
                        ).
                      x =
                      w *
                        normals[i30 +
                                  0] +
                        u *
                        normals[i31 +
                                  0] +
                        v *
                        normals[i32 +
                                  0];
                    state.
                      getNormal(
                        ).
                      y =
                      w *
                        normals[i30 +
                                  1] +
                        u *
                        normals[i31 +
                                  1] +
                        v *
                        normals[i32 +
                                  1];
                    state.
                      getNormal(
                        ).
                      z =
                      w *
                        normals[i30 +
                                  2] +
                        u *
                        normals[i31 +
                                  2] +
                        v *
                        normals[i32 +
                                  2];
                    state.
                      getNormal(
                        ).
                      set(
                        parent.
                          transformNormalObjectToWorld(
                            state.
                              getNormal(
                                )));
                    state.
                      getNormal(
                        ).
                      normalize(
                        );
                    break;
                }
            case FACEVARYING:
                {
                    int idx =
                      3 *
                      tri;
                    float[] normals =
                      this.
                        normals.
                        data;
                    state.
                      getNormal(
                        ).
                      x =
                      w *
                        normals[idx +
                                  0] +
                        u *
                        normals[idx +
                                  3] +
                        v *
                        normals[idx +
                                  6];
                    state.
                      getNormal(
                        ).
                      y =
                      w *
                        normals[idx +
                                  1] +
                        u *
                        normals[idx +
                                  4] +
                        v *
                        normals[idx +
                                  7];
                    state.
                      getNormal(
                        ).
                      z =
                      w *
                        normals[idx +
                                  2] +
                        u *
                        normals[idx +
                                  5] +
                        v *
                        normals[idx +
                                  8];
                    state.
                      getNormal(
                        ).
                      set(
                        parent.
                          transformNormalObjectToWorld(
                            state.
                              getNormal(
                                )));
                    state.
                      getNormal(
                        ).
                      normalize(
                        );
                    break;
                }
        }
        float uv00 =
          0;
        float uv01 =
          0;
        float uv10 =
          0;
        float uv11 =
          0;
        float uv20 =
          0;
        float uv21 =
          0;
        switch (uvs.
                  interp) {
            case NONE:
            case FACE:
                {
                    state.
                      getUV(
                        ).
                      x =
                      0;
                    state.
                      getUV(
                        ).
                      y =
                      0;
                    break;
                }
            case VERTEX:
                {
                    int i20 =
                      2 *
                      index0;
                    int i21 =
                      2 *
                      index1;
                    int i22 =
                      2 *
                      index2;
                    float[] uvs =
                      this.
                        uvs.
                        data;
                    uv00 =
                      uvs[i20 +
                            0];
                    uv01 =
                      uvs[i20 +
                            1];
                    uv10 =
                      uvs[i21 +
                            0];
                    uv11 =
                      uvs[i21 +
                            1];
                    uv20 =
                      uvs[i22 +
                            0];
                    uv21 =
                      uvs[i22 +
                            1];
                    break;
                }
            case FACEVARYING:
                {
                    int idx =
                      tri <<
                      1;
                    float[] uvs =
                      this.
                        uvs.
                        data;
                    uv00 =
                      uvs[idx +
                            0];
                    uv01 =
                      uvs[idx +
                            1];
                    uv10 =
                      uvs[idx +
                            2];
                    uv11 =
                      uvs[idx +
                            3];
                    uv20 =
                      uvs[idx +
                            4];
                    uv21 =
                      uvs[idx +
                            5];
                    break;
                }
        }
        if (uvs.
              interp !=
              org.sunflow.core.ParameterList.InterpolationType.
                NONE) {
            state.
              getUV(
                ).
              x =
              w *
                uv00 +
                u *
                uv10 +
                v *
                uv20;
            state.
              getUV(
                ).
              y =
              w *
                uv01 +
                u *
                uv11 +
                v *
                uv21;
            float du1 =
              uv00 -
              uv20;
            float du2 =
              uv10 -
              uv20;
            float dv1 =
              uv01 -
              uv21;
            float dv2 =
              uv11 -
              uv21;
            org.sunflow.math.Vector3 dp1 =
              org.sunflow.math.Point3.
              sub(
                v0p,
                v2p,
                new org.sunflow.math.Vector3(
                  ));
            org.sunflow.math.Vector3 dp2 =
              org.sunflow.math.Point3.
              sub(
                v1p,
                v2p,
                new org.sunflow.math.Vector3(
                  ));
            float determinant =
              du1 *
              dv2 -
              dv1 *
              du2;
            if (determinant ==
                  0.0F) {
                state.
                  setBasis(
                    org.sunflow.math.OrthoNormalBasis.
                      makeFromW(
                        state.
                          getNormal(
                            )));
            }
            else {
                float invdet =
                  1.0F /
                  determinant;
                org.sunflow.math.Vector3 dpdv =
                  new org.sunflow.math.Vector3(
                  );
                dpdv.
                  x =
                  (-du2 *
                     dp1.
                       x +
                     du1 *
                     dp2.
                       x) *
                    invdet;
                dpdv.
                  y =
                  (-du2 *
                     dp1.
                       y +
                     du1 *
                     dp2.
                       y) *
                    invdet;
                dpdv.
                  z =
                  (-du2 *
                     dp1.
                       z +
                     du1 *
                     dp2.
                       z) *
                    invdet;
                dpdv =
                  parent.
                    transformVectorObjectToWorld(
                      dpdv);
                state.
                  setBasis(
                    org.sunflow.math.OrthoNormalBasis.
                      makeFromWV(
                        state.
                          getNormal(
                            ),
                        dpdv));
            }
        }
        else
            state.
              setBasis(
                org.sunflow.math.OrthoNormalBasis.
                  makeFromW(
                    state.
                      getNormal(
                        )));
        int shaderIndex =
          faceShaders ==
          null
          ? 0
          : faceShaders[primID] &
          255;
        state.
          setShader(
            parent.
              getShader(
                shaderIndex));
        state.
          setModifier(
            parent.
              getModifier(
                shaderIndex));
    }
    public void init() { triaccel = null;
                         int nt = getNumPrimitives(
                                    );
                         if (!smallTriangles) {
                             if (nt >
                                   2000000) {
                                 org.sunflow.system.UI.
                                   printWarning(
                                     org.sunflow.system.UI.Module.
                                       GEOM,
                                     "TRI - Too many triangles -- triaccel generation skipped");
                                 return;
                             }
                             triaccel =
                               (new org.sunflow.core.primitive.TriangleMesh.WaldTriangle[nt]);
                             for (int i =
                                    0;
                                  i <
                                    nt;
                                  i++)
                                 triaccel[i] =
                                   new org.sunflow.core.primitive.TriangleMesh.WaldTriangle(
                                     this,
                                     i);
                         } }
    protected org.sunflow.math.Point3 getPoint(int i) {
        i *=
          3;
        return new org.sunflow.math.Point3(
          points[i],
          points[i +
                   1],
          points[i +
                   2]);
    }
    public void getPoint(int tri, int i, org.sunflow.math.Point3 p) {
        int index =
          3 *
          triangles[3 *
                      tri +
                      i];
        p.
          set(
            points[index],
            points[index +
                     1],
            points[index +
                     2]);
    }
    private static final class WaldTriangle {
        private int k;
        private float nu;
        private float nv;
        private float nd;
        private float bnu;
        private float bnv;
        private float bnd;
        private float cnu;
        private float cnv;
        private float cnd;
        private WaldTriangle(org.sunflow.core.primitive.TriangleMesh mesh,
                             int tri) { super(
                                          );
                                        k =
                                          0;
                                        tri *=
                                          3;
                                        int index0 =
                                          mesh.
                                            triangles[tri +
                                                        0];
                                        int index1 =
                                          mesh.
                                            triangles[tri +
                                                        1];
                                        int index2 =
                                          mesh.
                                            triangles[tri +
                                                        2];
                                        org.sunflow.math.Point3 v0p =
                                          mesh.
                                          getPoint(
                                            index0);
                                        org.sunflow.math.Point3 v1p =
                                          mesh.
                                          getPoint(
                                            index1);
                                        org.sunflow.math.Point3 v2p =
                                          mesh.
                                          getPoint(
                                            index2);
                                        org.sunflow.math.Vector3 ng =
                                          org.sunflow.math.Point3.
                                          normal(
                                            v0p,
                                            v1p,
                                            v2p);
                                        if (java.lang.Math.
                                              abs(
                                                ng.
                                                  x) >
                                              java.lang.Math.
                                              abs(
                                                ng.
                                                  y) &&
                                              java.lang.Math.
                                              abs(
                                                ng.
                                                  x) >
                                              java.lang.Math.
                                              abs(
                                                ng.
                                                  z))
                                            k =
                                              0;
                                        else
                                            if (java.lang.Math.
                                                  abs(
                                                    ng.
                                                      y) >
                                                  java.lang.Math.
                                                  abs(
                                                    ng.
                                                      z))
                                                k =
                                                  1;
                                            else
                                                k =
                                                  2;
                                        float ax;
                                        float ay;
                                        float bx;
                                        float by;
                                        float cx;
                                        float cy;
                                        switch (k) {
                                            case 0:
                                                {
                                                    nu =
                                                      ng.
                                                        y /
                                                        ng.
                                                          x;
                                                    nv =
                                                      ng.
                                                        z /
                                                        ng.
                                                          x;
                                                    nd =
                                                      v0p.
                                                        x +
                                                        nu *
                                                        v0p.
                                                          y +
                                                        nv *
                                                        v0p.
                                                          z;
                                                    ax =
                                                      v0p.
                                                        y;
                                                    ay =
                                                      v0p.
                                                        z;
                                                    bx =
                                                      v2p.
                                                        y -
                                                        ax;
                                                    by =
                                                      v2p.
                                                        z -
                                                        ay;
                                                    cx =
                                                      v1p.
                                                        y -
                                                        ax;
                                                    cy =
                                                      v1p.
                                                        z -
                                                        ay;
                                                    break;
                                                }
                                            case 1:
                                                {
                                                    nu =
                                                      ng.
                                                        z /
                                                        ng.
                                                          y;
                                                    nv =
                                                      ng.
                                                        x /
                                                        ng.
                                                          y;
                                                    nd =
                                                      nv *
                                                        v0p.
                                                          x +
                                                        v0p.
                                                          y +
                                                        nu *
                                                        v0p.
                                                          z;
                                                    ax =
                                                      v0p.
                                                        z;
                                                    ay =
                                                      v0p.
                                                        x;
                                                    bx =
                                                      v2p.
                                                        z -
                                                        ax;
                                                    by =
                                                      v2p.
                                                        x -
                                                        ay;
                                                    cx =
                                                      v1p.
                                                        z -
                                                        ax;
                                                    cy =
                                                      v1p.
                                                        x -
                                                        ay;
                                                    break;
                                                }
                                            case 2:
                                            default:
                                                {
                                                    nu =
                                                      ng.
                                                        x /
                                                        ng.
                                                          z;
                                                    nv =
                                                      ng.
                                                        y /
                                                        ng.
                                                          z;
                                                    nd =
                                                      nu *
                                                        v0p.
                                                          x +
                                                        nv *
                                                        v0p.
                                                          y +
                                                        v0p.
                                                          z;
                                                    ax =
                                                      v0p.
                                                        x;
                                                    ay =
                                                      v0p.
                                                        y;
                                                    bx =
                                                      v2p.
                                                        x -
                                                        ax;
                                                    by =
                                                      v2p.
                                                        y -
                                                        ay;
                                                    cx =
                                                      v1p.
                                                        x -
                                                        ax;
                                                    cy =
                                                      v1p.
                                                        y -
                                                        ay;
                                                }
                                        }
                                        float det =
                                          bx *
                                          cy -
                                          by *
                                          cx;
                                        bnu =
                                          -by /
                                            det;
                                        bnv =
                                          bx /
                                            det;
                                        bnd =
                                          (by *
                                             ax -
                                             bx *
                                             ay) /
                                            det;
                                        cnu =
                                          cy /
                                            det;
                                        cnv =
                                          -cx /
                                            det;
                                        cnd =
                                          (cx *
                                             ay -
                                             cy *
                                             ax) /
                                            det;
        }
        void intersectBox(org.sunflow.core.Ray r,
                          float hx,
                          float hy,
                          float hz,
                          int primID,
                          org.sunflow.core.IntersectionState state) {
            switch (k) {
                case 0:
                    {
                        float hu =
                          hy;
                        float hv =
                          hz;
                        float u =
                          hu *
                          bnu +
                          hv *
                          bnv +
                          bnd;
                        if (u <
                              0.0F)
                            u =
                              0;
                        float v =
                          hu *
                          cnu +
                          hv *
                          cnv +
                          cnd;
                        if (v <
                              0.0F)
                            v =
                              0;
                        state.
                          setIntersection(
                            primID,
                            u,
                            v);
                        return;
                    }
                case 1:
                    {
                        float hu =
                          hz;
                        float hv =
                          hx;
                        float u =
                          hu *
                          bnu +
                          hv *
                          bnv +
                          bnd;
                        if (u <
                              0.0F)
                            u =
                              0;
                        float v =
                          hu *
                          cnu +
                          hv *
                          cnv +
                          cnd;
                        if (v <
                              0.0F)
                            v =
                              0;
                        state.
                          setIntersection(
                            primID,
                            u,
                            v);
                        return;
                    }
                case 2:
                    {
                        float hu =
                          hx;
                        float hv =
                          hy;
                        float u =
                          hu *
                          bnu +
                          hv *
                          bnv +
                          bnd;
                        if (u <
                              0.0F)
                            u =
                              0;
                        float v =
                          hu *
                          cnu +
                          hv *
                          cnv +
                          cnd;
                        if (v <
                              0.0F)
                            v =
                              0;
                        state.
                          setIntersection(
                            primID,
                            u,
                            v);
                        return;
                    }
            }
        }
        void intersect(org.sunflow.core.Ray r,
                       int primID,
                       org.sunflow.core.IntersectionState state) {
            switch (k) {
                case 0:
                    {
                        float det =
                          1.0F /
                          (r.
                             dx +
                             nu *
                             r.
                               dy +
                             nv *
                             r.
                               dz);
                        float t =
                          (nd -
                             r.
                               ox -
                             nu *
                             r.
                               oy -
                             nv *
                             r.
                               oz) *
                          det;
                        if (!r.
                              isInside(
                                t))
                            return;
                        float hu =
                          r.
                            oy +
                          t *
                          r.
                            dy;
                        float hv =
                          r.
                            oz +
                          t *
                          r.
                            dz;
                        float u =
                          hu *
                          bnu +
                          hv *
                          bnv +
                          bnd;
                        if (u <
                              0.0F)
                            return;
                        float v =
                          hu *
                          cnu +
                          hv *
                          cnv +
                          cnd;
                        if (v <
                              0.0F)
                            return;
                        if (u +
                              v >
                              1.0F)
                            return;
                        r.
                          setMax(
                            t);
                        state.
                          setIntersection(
                            primID,
                            u,
                            v);
                        return;
                    }
                case 1:
                    {
                        float det =
                          1.0F /
                          (r.
                             dy +
                             nu *
                             r.
                               dz +
                             nv *
                             r.
                               dx);
                        float t =
                          (nd -
                             r.
                               oy -
                             nu *
                             r.
                               oz -
                             nv *
                             r.
                               ox) *
                          det;
                        if (!r.
                              isInside(
                                t))
                            return;
                        float hu =
                          r.
                            oz +
                          t *
                          r.
                            dz;
                        float hv =
                          r.
                            ox +
                          t *
                          r.
                            dx;
                        float u =
                          hu *
                          bnu +
                          hv *
                          bnv +
                          bnd;
                        if (u <
                              0.0F)
                            return;
                        float v =
                          hu *
                          cnu +
                          hv *
                          cnv +
                          cnd;
                        if (v <
                              0.0F)
                            return;
                        if (u +
                              v >
                              1.0F)
                            return;
                        r.
                          setMax(
                            t);
                        state.
                          setIntersection(
                            primID,
                            u,
                            v);
                        return;
                    }
                case 2:
                    {
                        float det =
                          1.0F /
                          (r.
                             dz +
                             nu *
                             r.
                               dx +
                             nv *
                             r.
                               dy);
                        float t =
                          (nd -
                             r.
                               oz -
                             nu *
                             r.
                               ox -
                             nv *
                             r.
                               oy) *
                          det;
                        if (!r.
                              isInside(
                                t))
                            return;
                        float hu =
                          r.
                            ox +
                          t *
                          r.
                            dx;
                        float hv =
                          r.
                            oy +
                          t *
                          r.
                            dy;
                        float u =
                          hu *
                          bnu +
                          hv *
                          bnv +
                          bnd;
                        if (u <
                              0.0F)
                            return;
                        float v =
                          hu *
                          cnu +
                          hv *
                          cnv +
                          cnd;
                        if (v <
                              0.0F)
                            return;
                        if (u +
                              v >
                              1.0F)
                            return;
                        r.
                          setMax(
                            t);
                        state.
                          setIntersection(
                            primID,
                            u,
                            v);
                        return;
                    }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public org.sunflow.core.PrimitiveList getBakingPrimitives() {
        switch (uvs.
                  interp) {
            case NONE:
            case FACE:
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      GEOM,
                    ("Cannot generate baking surface without texture coordinate da" +
                     "ta"));
                return null;
            default:
                return new org.sunflow.core.primitive.TriangleMesh.BakingSurface(
                  );
        }
    }
    private class BakingSurface implements org.sunflow.core.PrimitiveList {
        public org.sunflow.core.PrimitiveList getBakingPrimitives() {
            return null;
        }
        public int getNumPrimitives() { return TriangleMesh.this.
                                          getNumPrimitives(
                                            );
        }
        public float getPrimitiveBound(int primID,
                                       int i) {
            if (i >
                  3)
                return 0;
            switch (uvs.
                      interp) {
                case NONE:
                case FACE:
                default:
                    {
                        return 0;
                    }
                case VERTEX:
                    {
                        int tri =
                          3 *
                          primID;
                        int index0 =
                          triangles[tri +
                                      0];
                        int index1 =
                          triangles[tri +
                                      1];
                        int index2 =
                          triangles[tri +
                                      2];
                        int i20 =
                          2 *
                          index0;
                        int i21 =
                          2 *
                          index1;
                        int i22 =
                          2 *
                          index2;
                        float[] uvs =
                          TriangleMesh.this.
                            uvs.
                            data;
                        switch (i) {
                            case 0:
                                return org.sunflow.math.MathUtils.
                                  min(
                                    uvs[i20 +
                                          0],
                                    uvs[i21 +
                                          0],
                                    uvs[i22 +
                                          0]);
                            case 1:
                                return org.sunflow.math.MathUtils.
                                  max(
                                    uvs[i20 +
                                          0],
                                    uvs[i21 +
                                          0],
                                    uvs[i22 +
                                          0]);
                            case 2:
                                return org.sunflow.math.MathUtils.
                                  min(
                                    uvs[i20 +
                                          1],
                                    uvs[i21 +
                                          1],
                                    uvs[i22 +
                                          1]);
                            case 3:
                                return org.sunflow.math.MathUtils.
                                  max(
                                    uvs[i20 +
                                          1],
                                    uvs[i21 +
                                          1],
                                    uvs[i22 +
                                          1]);
                            default:
                                return 0;
                        }
                    }
                case FACEVARYING:
                    {
                        int idx =
                          6 *
                          primID;
                        float[] uvs =
                          TriangleMesh.this.
                            uvs.
                            data;
                        switch (i) {
                            case 0:
                                return org.sunflow.math.MathUtils.
                                  min(
                                    uvs[idx +
                                          0],
                                    uvs[idx +
                                          2],
                                    uvs[idx +
                                          4]);
                            case 1:
                                return org.sunflow.math.MathUtils.
                                  max(
                                    uvs[idx +
                                          0],
                                    uvs[idx +
                                          2],
                                    uvs[idx +
                                          4]);
                            case 2:
                                return org.sunflow.math.MathUtils.
                                  min(
                                    uvs[idx +
                                          1],
                                    uvs[idx +
                                          3],
                                    uvs[idx +
                                          5]);
                            case 3:
                                return org.sunflow.math.MathUtils.
                                  max(
                                    uvs[idx +
                                          1],
                                    uvs[idx +
                                          3],
                                    uvs[idx +
                                          5]);
                            default:
                                return 0;
                        }
                    }
            }
        }
        public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
            org.sunflow.math.BoundingBox bounds =
              new org.sunflow.math.BoundingBox(
              );
            if (o2w ==
                  null) {
                for (int i =
                       0;
                     i <
                       uvs.
                         data.
                         length;
                     i +=
                       2)
                    bounds.
                      include(
                        uvs.
                          data[i],
                        uvs.
                          data[i +
                                 1],
                        0);
            }
            else {
                for (int i =
                       0;
                     i <
                       uvs.
                         data.
                         length;
                     i +=
                       2) {
                    float x =
                      uvs.
                        data[i];
                    float y =
                      uvs.
                        data[i +
                               1];
                    float wx =
                      o2w.
                      transformPX(
                        x,
                        y,
                        0);
                    float wy =
                      o2w.
                      transformPY(
                        x,
                        y,
                        0);
                    float wz =
                      o2w.
                      transformPZ(
                        x,
                        y,
                        0);
                    bounds.
                      include(
                        wx,
                        wy,
                        wz);
                }
            }
            return bounds;
        }
        public void intersectPrimitive(org.sunflow.core.Ray r,
                                       int primID,
                                       org.sunflow.core.IntersectionState state) {
            float uv00 =
              0;
            float uv01 =
              0;
            float uv10 =
              0;
            float uv11 =
              0;
            float uv20 =
              0;
            float uv21 =
              0;
            switch (uvs.
                      interp) {
                case NONE:
                case FACE:
                default:
                    return;
                case VERTEX:
                    {
                        int tri =
                          3 *
                          primID;
                        int index0 =
                          triangles[tri +
                                      0];
                        int index1 =
                          triangles[tri +
                                      1];
                        int index2 =
                          triangles[tri +
                                      2];
                        int i20 =
                          2 *
                          index0;
                        int i21 =
                          2 *
                          index1;
                        int i22 =
                          2 *
                          index2;
                        float[] uvs =
                          TriangleMesh.this.
                            uvs.
                            data;
                        uv00 =
                          uvs[i20 +
                                0];
                        uv01 =
                          uvs[i20 +
                                1];
                        uv10 =
                          uvs[i21 +
                                0];
                        uv11 =
                          uvs[i21 +
                                1];
                        uv20 =
                          uvs[i22 +
                                0];
                        uv21 =
                          uvs[i22 +
                                1];
                        break;
                    }
                case FACEVARYING:
                    {
                        int idx =
                          3 *
                          primID <<
                          1;
                        float[] uvs =
                          TriangleMesh.this.
                            uvs.
                            data;
                        uv00 =
                          uvs[idx +
                                0];
                        uv01 =
                          uvs[idx +
                                1];
                        uv10 =
                          uvs[idx +
                                2];
                        uv11 =
                          uvs[idx +
                                3];
                        uv20 =
                          uvs[idx +
                                4];
                        uv21 =
                          uvs[idx +
                                5];
                        break;
                    }
            }
            double edge1x =
              uv10 -
              uv00;
            double edge1y =
              uv11 -
              uv01;
            double edge2x =
              uv20 -
              uv00;
            double edge2y =
              uv21 -
              uv01;
            double pvecx =
              r.
                dy *
              0 -
              r.
                dz *
              edge2y;
            double pvecy =
              r.
                dz *
              edge2x -
              r.
                dx *
              0;
            double pvecz =
              r.
                dx *
              edge2y -
              r.
                dy *
              edge2x;
            double qvecx;
            double qvecy;
            double qvecz;
            double u;
            double v;
            double det =
              edge1x *
              pvecx +
              edge1y *
              pvecy +
              0 *
              pvecz;
            if (det >
                  0) {
                double tvecx =
                  r.
                    ox -
                  uv00;
                double tvecy =
                  r.
                    oy -
                  uv01;
                double tvecz =
                  r.
                    oz;
                u =
                  tvecx *
                    pvecx +
                    tvecy *
                    pvecy +
                    tvecz *
                    pvecz;
                if (u <
                      0.0 ||
                      u >
                      det)
                    return;
                qvecx =
                  tvecy *
                    0 -
                    tvecz *
                    edge1y;
                qvecy =
                  tvecz *
                    edge1x -
                    tvecx *
                    0;
                qvecz =
                  tvecx *
                    edge1y -
                    tvecy *
                    edge1x;
                v =
                  r.
                    dx *
                    qvecx +
                    r.
                      dy *
                    qvecy +
                    r.
                      dz *
                    qvecz;
                if (v <
                      0.0 ||
                      u +
                      v >
                      det)
                    return;
            }
            else
                if (det <
                      0) {
                    double tvecx =
                      r.
                        ox -
                      uv00;
                    double tvecy =
                      r.
                        oy -
                      uv01;
                    double tvecz =
                      r.
                        oz;
                    u =
                      tvecx *
                        pvecx +
                        tvecy *
                        pvecy +
                        tvecz *
                        pvecz;
                    if (u >
                          0.0 ||
                          u <
                          det)
                        return;
                    qvecx =
                      tvecy *
                        0 -
                        tvecz *
                        edge1y;
                    qvecy =
                      tvecz *
                        edge1x -
                        tvecx *
                        0;
                    qvecz =
                      tvecx *
                        edge1y -
                        tvecy *
                        edge1x;
                    v =
                      r.
                        dx *
                        qvecx +
                        r.
                          dy *
                        qvecy +
                        r.
                          dz *
                        qvecz;
                    if (v >
                          0.0 ||
                          u +
                          v <
                          det)
                        return;
                }
                else
                    return;
            double inv_det =
              1.0 /
              det;
            float t =
              (float)
                ((edge2x *
                    qvecx +
                    edge2y *
                    qvecy +
                    0 *
                    qvecz) *
                   inv_det);
            if (r.
                  isInside(
                    t)) {
                r.
                  setMax(
                    t);
                state.
                  setIntersection(
                    primID,
                    (float)
                      (u *
                         inv_det),
                    (float)
                      (v *
                         inv_det));
            }
        }
        public void prepareShadingState(org.sunflow.core.ShadingState state) {
            state.
              init(
                );
            org.sunflow.core.Instance parent =
              state.
              getInstance(
                );
            int primID =
              state.
              getPrimitiveID(
                );
            float u =
              state.
              getU(
                );
            float v =
              state.
              getV(
                );
            float w =
              1 -
              u -
              v;
            int tri =
              3 *
              primID;
            int index0 =
              triangles[tri +
                          0];
            int index1 =
              triangles[tri +
                          1];
            int index2 =
              triangles[tri +
                          2];
            org.sunflow.math.Point3 v0p =
              getPoint(
                index0);
            org.sunflow.math.Point3 v1p =
              getPoint(
                index1);
            org.sunflow.math.Point3 v2p =
              getPoint(
                index2);
            state.
              getPoint(
                ).
              x =
              w *
                v0p.
                  x +
                u *
                v1p.
                  x +
                v *
                v2p.
                  x;
            state.
              getPoint(
                ).
              y =
              w *
                v0p.
                  y +
                u *
                v1p.
                  y +
                v *
                v2p.
                  y;
            state.
              getPoint(
                ).
              z =
              w *
                v0p.
                  z +
                u *
                v1p.
                  z +
                v *
                v2p.
                  z;
            state.
              getPoint(
                ).
              set(
                parent.
                  transformObjectToWorld(
                    state.
                      getPoint(
                        )));
            org.sunflow.math.Vector3 ng =
              org.sunflow.math.Point3.
              normal(
                v0p,
                v1p,
                v2p);
            if (parent !=
                  null)
                ng =
                  parent.
                    transformNormalObjectToWorld(
                      ng);
            ng.
              normalize(
                );
            state.
              getGeoNormal(
                ).
              set(
                ng);
            switch (normals.
                      interp) {
                case NONE:
                case FACE:
                    {
                        state.
                          getNormal(
                            ).
                          set(
                            ng);
                        break;
                    }
                case VERTEX:
                    {
                        int i30 =
                          3 *
                          index0;
                        int i31 =
                          3 *
                          index1;
                        int i32 =
                          3 *
                          index2;
                        float[] normals =
                          TriangleMesh.this.
                            normals.
                            data;
                        state.
                          getNormal(
                            ).
                          x =
                          w *
                            normals[i30 +
                                      0] +
                            u *
                            normals[i31 +
                                      0] +
                            v *
                            normals[i32 +
                                      0];
                        state.
                          getNormal(
                            ).
                          y =
                          w *
                            normals[i30 +
                                      1] +
                            u *
                            normals[i31 +
                                      1] +
                            v *
                            normals[i32 +
                                      1];
                        state.
                          getNormal(
                            ).
                          z =
                          w *
                            normals[i30 +
                                      2] +
                            u *
                            normals[i31 +
                                      2] +
                            v *
                            normals[i32 +
                                      2];
                        if (parent !=
                              null)
                            state.
                              getNormal(
                                ).
                              set(
                                parent.
                                  transformNormalObjectToWorld(
                                    state.
                                      getNormal(
                                        )));
                        state.
                          getNormal(
                            ).
                          normalize(
                            );
                        break;
                    }
                case FACEVARYING:
                    {
                        int idx =
                          3 *
                          tri;
                        float[] normals =
                          TriangleMesh.this.
                            normals.
                            data;
                        state.
                          getNormal(
                            ).
                          x =
                          w *
                            normals[idx +
                                      0] +
                            u *
                            normals[idx +
                                      3] +
                            v *
                            normals[idx +
                                      6];
                        state.
                          getNormal(
                            ).
                          y =
                          w *
                            normals[idx +
                                      1] +
                            u *
                            normals[idx +
                                      4] +
                            v *
                            normals[idx +
                                      7];
                        state.
                          getNormal(
                            ).
                          z =
                          w *
                            normals[idx +
                                      2] +
                            u *
                            normals[idx +
                                      5] +
                            v *
                            normals[idx +
                                      8];
                        if (parent !=
                              null)
                            state.
                              getNormal(
                                ).
                              set(
                                parent.
                                  transformNormalObjectToWorld(
                                    state.
                                      getNormal(
                                        )));
                        state.
                          getNormal(
                            ).
                          normalize(
                            );
                        break;
                    }
            }
            float uv00 =
              0;
            float uv01 =
              0;
            float uv10 =
              0;
            float uv11 =
              0;
            float uv20 =
              0;
            float uv21 =
              0;
            switch (uvs.
                      interp) {
                case NONE:
                case FACE:
                    {
                        state.
                          getUV(
                            ).
                          x =
                          0;
                        state.
                          getUV(
                            ).
                          y =
                          0;
                        break;
                    }
                case VERTEX:
                    {
                        int i20 =
                          2 *
                          index0;
                        int i21 =
                          2 *
                          index1;
                        int i22 =
                          2 *
                          index2;
                        float[] uvs =
                          TriangleMesh.this.
                            uvs.
                            data;
                        uv00 =
                          uvs[i20 +
                                0];
                        uv01 =
                          uvs[i20 +
                                1];
                        uv10 =
                          uvs[i21 +
                                0];
                        uv11 =
                          uvs[i21 +
                                1];
                        uv20 =
                          uvs[i22 +
                                0];
                        uv21 =
                          uvs[i22 +
                                1];
                        break;
                    }
                case FACEVARYING:
                    {
                        int idx =
                          tri <<
                          1;
                        float[] uvs =
                          TriangleMesh.this.
                            uvs.
                            data;
                        uv00 =
                          uvs[idx +
                                0];
                        uv01 =
                          uvs[idx +
                                1];
                        uv10 =
                          uvs[idx +
                                2];
                        uv11 =
                          uvs[idx +
                                3];
                        uv20 =
                          uvs[idx +
                                4];
                        uv21 =
                          uvs[idx +
                                5];
                        break;
                    }
            }
            if (uvs.
                  interp !=
                  org.sunflow.core.ParameterList.InterpolationType.
                    NONE) {
                state.
                  getUV(
                    ).
                  x =
                  w *
                    uv00 +
                    u *
                    uv10 +
                    v *
                    uv20;
                state.
                  getUV(
                    ).
                  y =
                  w *
                    uv01 +
                    u *
                    uv11 +
                    v *
                    uv21;
                float du1 =
                  uv00 -
                  uv20;
                float du2 =
                  uv10 -
                  uv20;
                float dv1 =
                  uv01 -
                  uv21;
                float dv2 =
                  uv11 -
                  uv21;
                org.sunflow.math.Vector3 dp1 =
                  org.sunflow.math.Point3.
                  sub(
                    v0p,
                    v2p,
                    new org.sunflow.math.Vector3(
                      ));
                org.sunflow.math.Vector3 dp2 =
                  org.sunflow.math.Point3.
                  sub(
                    v1p,
                    v2p,
                    new org.sunflow.math.Vector3(
                      ));
                float determinant =
                  du1 *
                  dv2 -
                  dv1 *
                  du2;
                if (determinant ==
                      0.0F) {
                    state.
                      setBasis(
                        org.sunflow.math.OrthoNormalBasis.
                          makeFromW(
                            state.
                              getNormal(
                                )));
                }
                else {
                    float invdet =
                      1.0F /
                      determinant;
                    org.sunflow.math.Vector3 dpdv =
                      new org.sunflow.math.Vector3(
                      );
                    dpdv.
                      x =
                      (-du2 *
                         dp1.
                           x +
                         du1 *
                         dp2.
                           x) *
                        invdet;
                    dpdv.
                      y =
                      (-du2 *
                         dp1.
                           y +
                         du1 *
                         dp2.
                           y) *
                        invdet;
                    dpdv.
                      z =
                      (-du2 *
                         dp1.
                           z +
                         du1 *
                         dp2.
                           z) *
                        invdet;
                    if (parent !=
                          null)
                        dpdv =
                          parent.
                            transformVectorObjectToWorld(
                              dpdv);
                    state.
                      setBasis(
                        org.sunflow.math.OrthoNormalBasis.
                          makeFromWV(
                            state.
                              getNormal(
                                ),
                            dpdv));
                }
            }
            else
                state.
                  setBasis(
                    org.sunflow.math.OrthoNormalBasis.
                      makeFromW(
                        state.
                          getNormal(
                            )));
            int shaderIndex =
              faceShaders ==
              null
              ? 0
              : faceShaders[primID] &
              255;
            state.
              setShader(
                parent.
                  getShader(
                    shaderIndex));
        }
        public boolean update(org.sunflow.core.ParameterList pl,
                              org.sunflow.SunflowAPI api) {
            return true;
        }
        public BakingSurface() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "CD9SXYtPb/0PMt6qgW0xAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1JpvozDWV7gc66m9DFHESCdMnQrBStmT");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
