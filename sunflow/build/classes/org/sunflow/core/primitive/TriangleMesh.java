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
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL0Za3BUV/ns5kESAnkAAQIECAEnFHfbQu3QIBLSpAQ3kEko" +
           "jkFZ7t49m9xw997LvWeTTWr68kHaGRE1UHQKf6QDMrxGZXSmj4k62lZqZ2ip" +
           "tTq26jgjWhmLjtXh6feds7v3sQ+kMzEzOXv33O/9PmdPXiYllkkaqMYCbMSg" +
           "VqBdY92SadFomypZ1jbYC8vPFEn/3Hlpy1o/Ke0jMwckq0uWLNqhUDVq9ZFF" +
           "imYxSZOptYXSKGJ0m9Si5pDEFF3rI3MUqzNuqIqssC49ShFgu2SGSI3EmKlE" +
           "Eox2pggwsigEkgS5JMFW7+uWEKmUdWPEBp/nAG9zvEHIuM3LYqQ6NCgNScEE" +
           "U9RgSLFYS9Ikdxm6OtKv6ixAkywwqN6XMsHm0H1ZJmg8W/Xhtf0D1dwEsyRN" +
           "0xlXz+qhlq4O0WiIVNm77SqNW3vIo6QoRKY7gBlpCqWZBoFpEJimtbWhQPoZ" +
           "VEvE23SuDktTKjVkFIiRpW4ihmRK8RSZbi4zUChjKd05Mmi7JKOt0DJLxQN3" +
           "BSee2Vn9vSJS1UeqFK0XxZFBCAZM+sCgNB6hptUajdJoH6nRwNm91FQkVRlN" +
           "ebrWUvo1iSXA/Wmz4GbCoCbnadsK/Ai6mQmZ6WZGvRgPqNS3kpgq9YOudbau" +
           "QsMO3AcFKxQQzIxJEHcplOLdihZlZLEXI6Nj06cBAFCnxSkb0DOsijUJNkit" +
           "CBFV0vqDvRB6Wj+AlugQgCYj9XmJoq0NSd4t9dMwRqQHrlu8AqhybghEYWSO" +
           "F4xTAi/Ve7zk8M/lLev2PaJt0vzEBzJHqayi/NMBqcGD1ENj1KSQBwKxcmXo" +
           "oFT34rifEACe4wEWMD/8wpUNqxomXxEwC3LAbI0MUpmF5aORmRcWtjWvLUIx" +
           "ygzdUtD5Ls15lnWn3rQkDagwdRmK+DKQfjnZ8/PPPn6Cvu8nFZ2kVNbVRBzi" +
           "qEbW44aiUvMhqlFTYjTaScqpFm3j7zvJNHgOKRoVu1tjMYuyTlKs8q1SnX8H" +
           "E8WABJqoAp4VLaannw2JDfDnpEEImQ//pIEQ31XC/8QnI5HggB6nQUmWNEXT" +
           "g92mjvqjQ7WoFGTUgucovDX0oJXQYqo+HLRMOaib/Znvsm7SoGEqcdB1iAa3" +
           "QbJo/SrtotZAAGPN+L9wSaKus4Z9PnDDQm8RUCF/NulqlJpheSKxsf3K6fB5" +
           "EWCYFCkrMbIGGAZSDAPIMJBhGHAybPqMpEbTG8Tn40xnoxTC7+C13ZD/UIAr" +
           "m3s/v3nXeGMRBJwxXIyGB9BGVyNqs4tEurKH5X9s/sPqTWMPvOknfqgjEWhE" +
           "dj9Y4ugH2MhMXaZRKEf5+kK6Ngbzd4KcMpDJQ8NPbH/sbi6Ds8AjwRKoTYje" +
           "jWU5w6LJm9i56FbtvfThmYNjup3iro6RbnRZmFg5Gr2u9Sofllcukc6FXxxr" +
           "8pNiKEdQgpkEKQPVrcHLw1VBWtLVGHUpA4VjuhmXVHyVLqEVbMDUh+0dHnM1" +
           "/Hk2uLYaU2ohIX6fyDHxiW/rDFznihjFWPFowav9J3uNw79+/S+rubnTjaHK" +
           "0dF7KWtxFCMkVsvLTo0dettMSgHud4e6v3ng8t4dPO4AYlkuhk24tkERAheC" +
           "mb/8yp533nv36EW/HauMTIMMgBGHJjNalqFSVQW0BHYrbIGgmqmQ6xg2TQ9r" +
           "EJZKTJEiKsXsuF61/J5zf9tXLQJBhZ10HK26PQF7f/5G8vj5nf9u4GR8MnZT" +
           "22g2mCjRs2zKraYpjaAcySfeWPStl6XDUOyhwFrKKOU108+N4Oeaz2PkY/9j" +
           "dXAnOA6DvYmIBWmaAhat6N7uXfJ4U/efRCuanwNBwM05Hvzq9rcHX+NRUYaF" +
           "APdRpBmONG81+x0hWS2cdQv+fPB/E//RSbghyn5tW6r3LMk0H8NIguTNBaZF" +
           "twLBsdr3dj976ZRQwNucPcB0fOLpW4F9E8LTYoJZljVEOHHEFCPUweUBlG5p" +
           "IS4co+PPZ8aePz62V0hV6+7H7TBunvrVjdcCh37/ao7yX6SkptDVGPuZaj3b" +
           "7Ruh0INPVb2wv7aoA4pMJylLaMqeBO2MOinCAGYlIg5n2ZMR33Cqho5hxLcS" +
           "fMC313AxghlhCBeG8HeduDRZzlrrdpVjxg7L+y9+MGP7By9d4eq6h3RnaemS" +
           "DGHrGlyWo63nevvZJskaALg1k1s+V61OXgOKfUBRhsnU2mpCa026ClEKumTa" +
           "b37807pdF4qIv4NUqLoU7ZB4TSflUEwhW6ArJ41PbRC1ZLgsXUaTJEt5zN7F" +
           "uetCe9xgPJNHfzT3B+uOHXmX1zBRsxZw9AocC1xtlx/s7K5x4s373zr29YPD" +
           "InAKpIEHb97VrWrkyT/+J8vAvEnmyAwPfl/w5LP1bevf5/h2t0LsZcnsUQb6" +
           "uY1774n4v/yNpT/zk2l9pFpOHaS2S2oCe0AfHB6s9OkKDluu9+6DgJh6WzLd" +
           "eKE3NR1svX3SGfHFzBXdntZYB/l0PTV+Xve2Rh/hD30cZQUuK7NaTl5syJ3d" +
           "+LBWNFhcN+OyQ4RAV9742uaWcCnQvpHicSOPhFJBCfNhM+LXEhz8/lQ1w491" +
           "jucNDO2qS1klCL92JD2aRaZAszguMko6hE8xD0ttCliaGZbRXCytO2TZBKxu" +
           "pljezMNyuKD/8mFDd4hoiVwyJqdAxkdxGeE8c7risSng+UWbZ05ffOkj8LyV" +
           "4nkrD8/xgr7Ihw0yyrl98dQUyPg1XJ7mPHP6Yv8U8Jyweeb0xYECPMWrFXxt" +
           "xmUVLyNF+PhxRkotfuGFxUbRJNWe63mTnee9IXAI5+imBAeERfkucfggdvTJ" +
           "iSPRrc/d40+NLa3AOnW3ZtPxIxlXV+7id1Z2i6v4yt2zQiwZyz4HI5WGPCfd" +
           "lfnbt5fBy0/+tX7b+oFdd3DIXexR3Evyu10nX31ohfwNP792Ex0167rOjdTi" +
           "7qMVJmUJU3PPio3uDJHBfK3CVeLTGUd2vGQFAvEc5coK0PGMoaWcQGn6QDQ7" +
           "60DUI41kwtVe1qYRGrMQOvF20xJjHN7EUi75qQLj7/dxOcZIpZJG3ajnbKbF" +
           "Q7oStVPm+O3S1DVq4kYP3/6O21obwUqDKWsNFrA6LieyDZ0P1aNwkZ2yp7kF" +
           "cTnL6U8WsM1PcHmekfKMbXDjnG2EF+7cCEkwtfO66yOchudl3cmLe2T59JGq" +
           "srlHHn6b39Rk7nor4ZwbS6iqc650PJcaJo0pXN9KMWUa/OM8I/X5ZQKjZJ65" +
           "Cr8QWK8zUu3FgtjBDyfYBUamO8AYnu34kxPoIhRsAMLHt4y0nar5iQWn7ICY" +
           "spM+dyHNOGfO7ZzjqL3LXAWO/zSSLkYJ8eNIWD5zZPOWR6584jlxnySr0ugo" +
           "UpkOB1NxtZUpaEvzUkvTKt3UfG3m2fLl6WpeIwS2A36BIwx7oHkYeFqr99y1" +
           "WE2ZK5d3jq576ZfjpW/AsWcH8UmMzNqRfR5JGgnoDztC2QdwKPb8Eqil+dsj" +
           "61fF/v5bfuAj4sC+MD98WC6/um90qeUL+El5JymBRkWT/KD04IjWQ+Uh03Wa" +
           "L43oCS3zC8pMjFAJfzLhVkkZc0ZmF+8iochlX2tk38/CSXiYmhuROi/wnvKf" +
           "MAznW27VdlHe0MoQZ+FQl2Gk73MOc6sbBs/YS7h0/BfPKYIj8xwAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/wUx9jEysygAAA==");
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
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Rhz90xsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "T73udx/7enZj9z/c79BJCCgAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DHTByG/wz9r/AVV7XcuvLwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "83KtoQ9rS0aBkEUtzszEryyN9mTCxGA9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("kzmLlJ+DsDPU+nA7XXaUxjgcL5QGClLQZiJW2rjeySqDEdrdgnDEDLgU4rpV" +
       "AiPQHonjdhd15Qk+2dIy1awiZRDIFSibmEusghl9c7GYT0fajEwJa1CGu012" +
       "5AdQbOoddos4zohajlp5ILD9JhI3ath60QG5HDofyBSFjRpoebFmGxltiqhQ" +
       "YyAJ4pLe3OL4cYV3XUlvWXhLbtZskNCsEWZEo7IqQDEbNdsTk1XxQT9pyKav" +
       "1qyAMtQOKU3GLgoWY6Ik0qxYI+FVyGI0bkPUuGtulNrcJScozISrftnTo5iy" +
       "KzWlTOG13lbyK7bQ1CxFJY2pYabTTZeq2FMcibKy4WmjGMlcvkHbsRfGXY5s" +
       "yZveqFGv0t1MZZcpD3VN3ed6AeUwaJ2Gm41aDSRGmzTkDDJoddiWkqZTDa2Z" +
       "AcfSa4exHTMmoP5sHdpjOpuBHgxSXWxjHUOYdsOdNDhro/fbWNtxJmIWwlNs" +
       "YTRnna0/WNMzatKZ6iAERHpFkqo8ZgrZxkfnKkRZbU+dOnjabdVmyQglqZSV" +
       "7TWdyuMuUD/aV9xEqhEJQiV9zrVnltPedJtqJRRXgSZwEG9T3WA67AlJiNbQ" +
       "EO6g4jZBa2EFafenxLYHJVkzgPDZDJsr8YZKcDx/pPftV/ao8f7iqerxlmTT" +
       "wvKKb76Cp4npqbe+x68Hit/tpYNtrKfeQ5zaFnVh/wT38bNvbfavoYotaGFQ" +
       "eux6G5KL3Sqfev6FF9XRp6sXj55U0/kbWdd7m6Vtjt6O7WbcbR/yjql9ICcu" +
       "Z+3JI2qfPHxrciKPcx7qt3dCPXh0fuHkxcqwaPDDc56t/0VefB+oJdQi7urN" +
       "RNd68LtxDfVES//zpZ75np7tQATFvsx8m2LlSASVVyCCgrk3vxT338wbXLjt" +
       "+txfuJQXpah0B1gURPkW77zRXx4zeOHCDTBYvHDPN4e944jBd9wcBg82ilzD" +
       "hk+/edw3e/B0M273j48HhRTuP0dCD+XF3VHp9thTpajYGzE8kc+rb0A+hdc+" +
       "BY7NkXw2N1U++WXxjmJZ8PHkOTw+nRePAh9YatExABBu7Kh563efsPvYDbCb" +
       "b0EuvQkczx+x+/xNtfe9nh8+rWdbilZXaCkKjBQtOH3bOVLId8xeeHNUugdI" +
       "QXADSy0kcPyG+9EzAxf1hrMk3PRERM/cKCRMwfGJIxF94uaI6JZdQNpz8toz" +
       "HsNKxUvI5b7FU2daDPJ9c+Fuz3L+YVARzi789DnibOVFAyjE2Hc9Ni3WlePd" +
       "tupTUNO8AcEV4eRdQAb1Xd/d/8sUXOEpObX7GH1t6eU0vn3vVBfeWfBIn8P/" +
       "KC/6p/nfR5ah5oTWbhPEKf4HN2o4DOD73Uf8v/umGs61WF+cw/q78mIalR44" +
       "q/oDpvkbYPre/OYTgH7ziGnz5jB9mhPtnLpCGO+JSvcBvGBi+5jF8MSVCh6l" +
       "G1UsBsh1jnh0bg6PB6D52Bl/z/egAGg7cXX/HEnEeWFFgKZA86RAO935QOH2" +
       "jQrjQUD2t4+E8e2br/D3n1P3gbzIovxjMuMQvd57A3y9Lr/5GCDxe0d8fe+V" +
       "8jV7qUxwlwN8+Bzm8l14F34OZIJ5DlDs1z6yjYfOxL2iGjnh/YM3qlMYUPmD" +
       "I95/cHN0eoJcR0lQTuhHC05/8Rwp/OO8eOGUFA7U/PEbYLX4TuKtIN78+q7v" +
       "7v/mmu+nz6n7tbz4J8BLAW+EtAYOejVkfeeEzV95JWymUenu03sW8w+aHj7z" +
       "sfHuA1nl8y/ee8dDL/L/brdPf/8R651U6Q49tqzT35+cOr8d4IpuFMzfufsa" +
       "xSs4+nxUeuT6GymLTxFOMXjhc7tevwkg+7AXcOr873Sz345KrzrVLCpdOjo7" +
       "3ehLUekW0Cg//bK395hTu5R2X+OkO6B9+LRdFOvHB15KzsddTn8sl+9lL775" +
       "3u87j3dffT+nfOFFknnv9+uf3n2sp1hSluWj3EGVLu2+GywGzfeuP3nd0fZj" +
       "3d5/5kf3/Madb9ov7e/ZEXxio6doe+LaX8Z1bC8qvmXLvvzQb//Ur734p8U2" +
       "rf8HdjVAVIw/AAA=");
}
