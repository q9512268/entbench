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
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALVaecwkR3Xv/dbeXRvbuzZgGwffy2EP2p7pOXpGBsJMz9Uz" +
           "PT1Hd8/RAZa+j+n7mu4mDgYpGAXFQYkhJgIrf4CSIHMoCkokBHFEwiFQJBAi" +
           "JFIwQokCIUj4j5CIy6nu2e/cb+11kEeamurqeq9+79U7aqrqqR9D1/oeVHBs" +
           "I1EMO7ggxcEF3aheCBJH8i8MiOqE83xJxAzO92nQdlG47zNnf/rzD6jndqBT" +
           "LPRyzrLsgAs02/Jnkm8bkSQS0Nn91o4hmX4AnSN0LuLgMNAMmND84CECetkB" +
           "0gA6T+xCgAEEGECAcwhwc78XILpRskITyyg4K/Bd6HegEwR0yhEyeAF072Em" +
           "Dudx5iU2k1wCwOFM9jwHQuXEsQfdsyf7VubLBP5gAX78j99+7i9PQmdZ6Kxm" +
           "URkcAYAIwCAsdIMpmbzk+U1RlEQWutmSJJGSPI0ztDTHzUK3+JpicUHoSXtK" +
           "yhpDR/LyMfc1d4OQyeaFQmB7e+LJmmSIu0/XyganAFlv3Zd1K2E3awcCXq8B" +
           "YJ7MCdIuyTVrzRID6O6jFHsynh+CDoD0tCkFqr031DUWBxqgW7ZzZ3CWAlOB" +
           "p1kK6HqtHYJRAuiOKzLNdO1wwppTpIsBdPvRfpPtK9DrulwRGUkAvfJot5wT" +
           "mKU7jszSgfn5MfnGx95p9a2dHLMoCUaG/wwguusI0UySJU+yBGlLeMODxIe4" +
           "Wz//vh0IAp1feaTzts9f//azb3nDXU9/ZdvnN47pM+Z1SQguCh/jb/rGq7EH" +
           "GiczGGcc29eyyT8keW7+k0tvHood4Hm37nHMXl7Yffn07EurRz4h/WgHuh6H" +
           "Tgm2EZrAjm4WbNPRDMnrSZbkcYEk4tB1kiVi+XscOg3qhGZJ29axLPtSgEPX" +
           "GHnTKTt/BiqSAYtMRadBXbNke7fucIGa12MHgqBXgS90FwSd+BmUf7a/AbSE" +
           "VduUYE7gLM2y4YlnZ/L7sGQFPNCtCvuhJRv2BvY9AbY9Ze9ZsD0JdjzNBBJG" +
           "EkwDF7EUQxpJvnohszDnJeQdZ3Kd25w4AVT+6qMObwBf6duGKHkXhcfDVufZ" +
           "T1382s6eA1zSSABVwIAXLg14IRvwwt6AFw4OeH7BGeJuA3TiRD7oKzIU2zkG" +
           "M7QGvg6i4A0PUG8bvON9950ExuVsrsmUDLrCVw7G2H50wPMYKAAThZ5+YvPu" +
           "+buKO9DO4aiaIQdN12fkkywW7sW880e96Ti+Zx/9wU8//aGH7X2/OhSmL7n7" +
           "5ZSZu953VMeeLUgiCID77B+8h/vsxc8/fH4HugbEABD3Ag7YKQgpdx0d45Db" +
           "PrQbAjNZrgUCy7Znckb2ajduXR+onr3Zb8kn/6a8fjPQ8bnMjl8NQTsntoa9" +
           "/c3evtzJyldsjSWbtCNS5CH2TZTz0e/84w/Lubp3o/HZA/mNkoKHDkSAjNnZ" +
           "3Ndv3rcB2pMk0O9fn5j80Qd//Ohv5QYAetx/3IDnsxIDng+mEKj5d7/i/vMz" +
           "3/3Yt3b2jSaATgNTjEBAiPekPJMJdfZ5pATDvXYfEAghBnC1zGzOM5Zpi5qs" +
           "cbwhZWb6i7OvKX32vx47tzUEA7Ts2tEbXpjBfvurWtAjX3v7/9yVszkhZCls" +
           "X2n73bZx8eX7nJuexyUZjvjd37zzw1/mPgoiLIhqvpZKeaDayZWwk0v+ygB6" +
           "3VW6KRjkgedZ9uzSbNMA/PAtz6w/8oNPbtPA0bxypLP0vsd/77kLjz2+cyD5" +
           "3n9Z/jtIs03Aud3duJ3B58DnBPj+KvtmM5c1bAPwLdilLHDPXhpwnBiIc+/z" +
           "wcqH6P7Hpx/+3J8//OhWjFsO554OWFp98tu//PqFJ7731WPC30mwrsgRwjnC" +
           "B/PyQgYp1z+Uv3tTVtztH4wwh1V7YDl3UfjAt35y4/wnX3g2H+3wevCgQ404" +
           "Z6ubm7LinkzU246G0z7nq6Bf5WnyreeMp38OOLKAowAWQf7YA5E9PuR+l3pf" +
           "e/pf/u6Lt77jGyehnS50vWFzYpfLIxl0HQghwEZAUoid33zL1oM2Z3aDRwxd" +
           "JvzW8W7Pn258ftPqZsu5/Th4+8/GBv+e7//vZUrIw/cx1naEnoWf+sgd2Jt/" +
           "lNPvx9GM+q748mwHlr77tMgnzP/eue/UP+xAp1nonHBpXT3njDCLTixYS/q7" +
           "i22w9j70/vC6cLsIemgvT7z6qLkfGPZoBN83M1DPemf1648L2reCWPeLS6uR" +
           "XxwN2iegvDLMSe7Ny/NZ8bptjMyqr8+Z1gLoxDqrVLdxPivfnBXEdhKbV5zw" +
           "7mE49wK2v7wE55dXgDO7Gjg7Vph3QPLnLYp6kGnJ5oIjIKmXAORbrw5klNUW" +
           "R/C87SXAI1wdHvE4POKLxHMe8P3VJTy/ugIe/WrwnOSt8DhA65cAkHuVgI6d" +
           "Me8lABRfJaBjpyz5fwB67hKg564A6F1XBUg4fsoeeQkAvfcqAR07ZY++BIB+" +
           "/yoBHTtlj70goG0oOwHWptciF9ALxez58eOHPBlAp5yQNzSwJjzl57srWfDT" +
           "LM7YxXGbbgjnd9c9c8nzQYI8rxvo7qLvXJ7bs1R0YbtFcQRv7arxgtx90z4z" +
           "wraUh97/bx/4+h/c/wxIsAPo2ihLfiCvHhiRDLMNoPc+9cE7X/b4996fr8uB" +
           "Hqlrn/1O/nf6T68gdVZ9Iis+nBV/sivqHZmolB16gkRwfjDKV9KSuCftkSRx" +
           "jWH/GtIGNz3Sr/h4c/dDMCy32DAl2AoQVed7/XizLKwSHEdDVaW5gbZikHpX" +
           "8ZUVMUanJWyxqhcaK8kcFFk2QDmuRHLTjqtwKx/HGczbYI1pZz3FNNujXAUx" +
           "puaaGjDFuanT06E7c4dVBplOEdc0aLUWSQ0SJVO00xtw66AwhiMzLMDlRjib" +
           "j/xNQlHl+QKfkj2SGnpka2UiM44ka2vK4efNZSDW3Y5Wm9d5r5ZUiWI8HPum" +
           "vfQN16AWBKkFjD4PRXboagsmpdieG9g0Ne71imbA6ewg7XZLqTdYjOYuNXNd" +
           "XAv9+apBt7pKZNJdiqC75jAoOjMj8Jt2PNJXnTVDVQcB1q+EerU3NGmx12+3" +
           "BmW9aaZx1GkTTt3DV+7KCYzIXXO47XA6ZS6GmwLP4l3VrYwbQ6WmNZpFDYkX" +
           "RkMxF60SvzYXmMkJ3gRFCh4qDU0EKzq9da1ScNhaTTPccrHY18ZzNKwMDYoL" +
           "PGmKOpjam1las8eZxJhJ9E17OqRbpWBJaVNZo+eMvzYtLmr3O7ah2htsRBNt" +
           "uk5Nacxw1oilj5RxlzF5L3W6LaSwZvnVYrGg7EJEtWoVst1zHWlI9RjLnVNF" +
           "UZ31W1pnNRqvO0pjsCbTRaBamhDrwSCY8mPelUzctYb2uAxgR06RohbNSEBZ" +
           "v08anS6ZBuNSV1ZmYpukR8GE1Pv2oG+0kQDpDOaS3VoKUjVUbNIsd+QuFi+n" +
           "7WaKM30BofTuIp4Gqa8V8Q7bi1G332y2pmoiOLUGk3q4XcJoFtenymwuDmp2" +
           "WJxKhj1RmiiNT1vkTOONwcpFSG1W1Rqzdpg2tWa5FVTUedNYdtt409ZXFVKx" +
           "WoMKNyeaVIzCyy6SiuM6wrPMYqD1pmOmanQlRm4yWqnJzUokkAez1koHi8x4" +
           "Ux1WSijbSVYdZST0lOZylDQKhcCKVZS3li0hXQPz8MJUpM3lchCjTj+ixwYn" +
           "VhszSu25XJfHdE92Umvi6zxKL8uc0rRTYj2aLYucYBTkBSw7/LiITvX6cB3h" +
           "CyYhXI5a48JcCGpFo8Vwbm3d0xljFo4CB4/dOsUXIpsZqQVpZRu9OEy5mY+p" +
           "Hi4wbjnxZoWlsGGmA9zGrWFlbs06npfyHc030oLVZgh8NlGsYEV1Jppcp8ub" +
           "pO6XbK9aWzOMuSA7S9pGEFOPHJ7hlEp50ebLrjYvqkO3rBZKdNt0zRRhUXQQ" +
           "Fl1VHa6tqY83euOk1Q1atXlgABeu4DNW2agoTbskb8Pd5pCmN2szarpVf+0s" +
           "Kw3aXyuFdc8QBQnte/SsOzKbGDKbqWy7udFJf4SP7Hjd63D19jgs4CBbsJVx" +
           "Z+qkTm8wwwotpR4050kf+GDMp8isJEaIPk4xnCBqWKOHbyY23YVpbokTijHp" +
           "hoUZTVKjPluKJbFdHWnmeD1zBixlDGM1pVaTOSZWsRLSNMTiNA2SsD4o0iW5" +
           "KZq8O7JLbUbwlv3FxnWWtkwue/Ka7kjYGp1swmRUDeurscRY1Q1aRkspXF5G" +
           "2GAcR62RmvTI6WbWg9t1p+gUy8tW08EIPlyGw2pBGnuqKBbDloeOKm26Q3TK" +
           "i1VvmhB236xVJxbt0KToIUlUQVaRUiLIQUcJXHxYms5qBcqYRPNemXFmU4YO" +
           "VZMxiNhYTHQhYL1aVA7bNrzkokq95Q81zCAjTOur65Hara+MKI7Niq7Ksb7s" +
           "LIr4oKxOZRC+RssyjKIGalatKUvVJKuOsvRcqtiLjhupVc7i2qI/XpeGzUKh" +
           "tUFK5GTZQBqKIPjTUTqM+ea4lKzsedjCRsD1PaTQaIz7xqpQ6JVp1WLb6rpd" +
           "iTFyUJ75KjV3tUQZ8Bhf2didOVPo1uyWysDSpqX03EGLcha1xWpBCy6b1Gt1" +
           "uC8N1Q4+DDcVgac3qUIL8Mok2ZHE99KCV13MsJHFiiVECU1MN+xSedjmVk6b" +
           "awo1trh0ItQmpTVONhk7HqwSqm8E7eVIVwnL7MQaW0gbi67ViDfNmU+X5/x6" +
           "pCB+T2UbKBusI5kJ5NI8GCaD8azZKZO6ZesNAYZRMyirjNEbOpt+keE4yup0" +
           "WoP6arY2lu0FLyvERq4HcEewKivWbqdzUrQLnGUalOp0eokkzE3Ma2Brqlwq" +
           "J5Uqu/aIjdJV1sV6s5OW+31dE006akpdZyRZo0S1kaitaojadyvd4aToF+0Y" +
           "n+vkBA5KE06eoGIjqGJuHBTK83prVfCJiEcr87GcWGR5WNQ1omsZq+WqEFvD" +
           "qLiKkEJnqjQKHowvC4g7NN0+HgzawB1YH2S7RTgQtHbPWbhBpBN9CauogVQS" +
           "m7GO06aygSsNFQ9jvciupspSjVplt9xj+aXheWJjbhlmnWoAX9AEvVRuJA3V" +
           "WQK3GEnFgHCRKb4oySAvicGERldYSRzMNbhJ0LVy1em4DTEu2aQy6PYWq9UQ" +
           "KQ082giG9SkitttqBKvzgtznl66l4RRP8aZLwV1TA17EKHy3S+DdseVxhYmT" +
           "MExUo6rFxNRYNjHFYNV2JkmpaM+1KRkbJFofyrqMEkWEGy+leSdt4eVBn6gL" +
           "6iaWOwWxP/WkiTXRxXmjgTZ8sw1TQwbTZr1mD8aqSDRHjRIMrwuLZGnx6aDj" +
           "NeV0XBsZ1kBngkJF10O4SPhSRCGr0SxtNkPUK1rrqD5Ok7hKMklPrOIuQtcw" +
           "j5WZbp/r0rqKLEa1ahuvOlEkF/AKtTIKfgovjeGou27w+FgsVv12LGyWaKVr" +
           "jqeVBMVXjRAEWtL3p5VpYSIMqGqIpTi3HlR9qscX+nEpQrRq2K51ktpIa5H8" +
           "Wuf1kqwYVnOM8KRd4CWKYrCiu2pXw5k/4LVKt5DWgBFNxq0qb7bsOfCl4dqr" +
           "iAumZneNOtYGSDc1kKR4lUEKTYfudIiu2WPpzTJpzETf3bTnnugbnpz4rY1d" +
           "Ixp1hGxGoTdnCHXdV4vtXp9X/Uoap6FJWJ1Jq56OF2wxlibypicFCCIF8GQj" +
           "D4cKAQ9UpRInvNGoyxt1LbeGy34Zk8ZLJAbPlb41q1YjumtP8XrMhVV5gEyS" +
           "qljpURYWbxR9MOPgoU9qNqJRtTVai0bBGCMrgYTTqdgdY3h9wsikAMvtKRqE" +
           "UbMo61ylEmENrU1jwzRYpOaSVvVBgXCSIQoHghEJrdoEgQtzS6QRUiyP3dgr" +
           "c+Nqwtdlv1gbwmk9lWs2pkWo7PUdvGpEbBRW7GadWGAaPrKsRbFQ8JfDcdSG" +
           "Rx7MdtA6UutEUzApPsp7xmAheAzcn5hEvx4mi7bdCrtMXTLJcVtK/PWw18Jr" +
           "LWe6tFsdHqxSa0rcNka6sK7RQ4Ru6cMWSqHl8UZJ/bjF1Zv8vKOO5HLEUkRk" +
           "Ok13kvbmicTWZpgwb/INNg4CVJ3MC4NQcJAKU8SXfYOM7fpEKdTlRsP0OyGC" +
           "ICgvVZVWYzNmjaBgJXZzNmJCySiYgc8YVaECy6OuN2FcwhTYoRCssFSURL+c" +
           "JHChvxAJpR025uWWUOEZGC+YpWa5JxNEXAuIVgkGOaIscRZebhvLKYlbjOu5" +
           "1hxvpMmiR81GYFmOdc3umoSjLp+t84yNNTL6ljn0NoGPVTaMuuwokY61E3gl" +
           "VZJRHW/Gk3aUDBJ4OqN0uIlTE2OT9mljWW/i01Qq0iN0bE6jJLbK7SVCh2gy" +
           "nwzYSCNwuTaIMYMdwh2dHrD1Wmh5ZGAG8phCQxeZzXtq3BlqE6WChWGqD7p8" +
           "kZU4pRaAgJ96dr22pHm+Ni3PpyZYfVIs2vRG7YXTa6loY6DwvuAm1dRZThyE" +
           "HKZRw6AFpTNmZgFO9QbrBs77xWKZozq9MjJrE5Ow1VYK2JKeLFNZTzbgz5pm" +
           "leF1tShohEKZVVzqFxsB3S0FYx42/LHcIFctrThhPTOuVfotdFaajyupzAtd" +
           "O22aAzmJ1SBqkQGMpxgq8Wtg1GjFTvgKrXpkaZIywB6oVbvIYtPyoCwT9fl4" +
           "WdTYmdJq9eW+ULUYomPrCxXWvCRacKo+noj4TEnkOIlSa12Bq3hSXcIbn23H" +
           "Q9ebFcEfzjflJwZPvbi/yDfnuwF7txfAP+PsxUdexL/gK+xX5QO+/sCAe9sq" +
           "+S7/7UdPww9sqxzY/4eyE4o7r3RhIT+I+dh7Hn9SHH+8tHPp3KQRQKcu3SPZ" +
           "57MD2Dx45XOEUX5ZY38z/8vv+c876Der73gR58B3HwF5lOVfjJ76au+1wh/u" +
           "QCf3tvYvu0ZymOihwxv613tSEHoWfWhb/87Dp5QCELW5Vev29+Bu1f6kXjZb" +
           "W9XVjhxHncrfndrdGXrFZceBMy7Z29LaL6q7BPddRoBnF2r87elkdvlHysf9" +
           "4vMcg301K74QQDdou6QtOz529yayNXHfZP/2hTZuDg6UN3zusCpbQIX6JVXq" +
           "v7YqT+47xd/nOsqKL+Vdv/080n8nK74RQNftSZ81fG1fzG++GDFjoMaDNyqy" +
           "90XgGbdfdm9re9dI+NSTZ8/c9iTzT/nFgr37QNcR0Bk5NIyDh00H6qccT5K1" +
           "HP5126MnJ/95JoDuuPKBMpBxr54D/+6W6vsBdO4oFZjs7Odgt38PoJcd6BZA" +
           "py/VDnb6QQCdBJ2y6g+dY/Y7t0dv8YnDAWhP17e8kK4PxKz7DwWb/PrcbmAI" +
           "txfoLgqffnJAvvPZ2se31x8Eg0vTjMsZAjq9vYmxF1zuvSK3XV6n+g/8/KbP" +
           "XPea3Sh40xbwvp0ewHb38VcNOqYT5JcD0r+57a/e+GdPfjfffv0/qB7Notco" +
           "AAA=");
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
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "KAAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "IYcfe0b4kepqfHrrf5dz4El3MQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7C6zsaH3fnLuPe3dZ9gXsLss+2N1LwjJwPS+PZ7oJ4PF4" +
       "Hh4/ZsYznhnTsvg547fHb5sSwrYNqKhAm4UQNVk1FSQNXSCJEkCqEm0VpQQF" +
       "RSJK27RSQ6gqNS1FYitBo9A2/ew5c86559x7dpd7O5K/sf29/s/f///Zn1/8" +
       "Xuk23yuVXcdM16YTXFGS4IpuwleC1FX8KwQJjwXPV2TMFHx/Bu49Kz35G/f8" +
       "8Eef2tx7oXQ7X3qDYNtOIASaY/tTxXfMSJHJ0j3Hd3FTsfygdC+pC5EAhYFm" +
       "QqTmB8+Qpded6BqULpN7EiBAAgRIgAoSIPS4Fej0esUOLSzvIdiBvy39TOmA" +
       "LN3uSjl5QemJqwdxBU+wDocZFxyAES7l1xxgquiceKW3HvG+4/kMw58uQ8//" +
       "wvvv/a1bSvfwpXs0m83JkQARAZiEL91lKZaoeD4qy4rMl+6zFUVmFU8TTC0r" +
       "6OZL9/va2haC0FOOhJTfDF3FK+Y8ltxdUs6bF0qB4x2xp2qKKe+vblNNYQ14" +
       "feCY1x2Hvfw+YPBODRDmqYKk7Lvcami2HJQeP93jiMfLI9AAdL1oKcHGOZrq" +
       "VlsAN0r373RnCvYaYgNPs9eg6W1OCGYJSg9fd9Bc1q4gGcJaeTYoPXS63XhX" +
       "BVrdUQgi7xKU3nS6WTES0NLDp7R0Qj/fo3/qEx+0B/aFgmZZkcyc/kug02On" +
       "Ok0VVfEUW1J2He96B/kZ4YHf/diFUgk0ftOpxrs2X/27L7/3nY+99Ie7Nm+5" +
       "RhtG1BUpeFb6nHj3tx7Bnm7fkpNxyXV8LVf+VZwX5j8+rHkmcYHnPXA0Yl55" +
       "ZV/50vTfrH72C8p3L5TuHJZulxwztIAd3Sc5lquZitdXbMUTAkUelu5QbBkr" +
       "6oeli+Cc1Gxld5dRVV8JhqVbzeLW7U5xDUSkgiFyEV0E55qtOvtzVwg2xXni" +
       "lkqli+Ao1cDxUGn3K/6D0hLaOJYCCZJga7YDjT0n59+HFDsQgWw3kB/aqunE" +
       "kO9JkOOtj64lx1Mg19MswGGkQDPgIvbaVCjF31zJLcz9/zh2kvN1b3xwAET+" +
       "yGmHN4GvDBxTVrxnpefDDv7yl579owtHDnAokaD0k2DCK4cTXsknvHI04ZWT" +
       "E5YODop53phPvFMrUIoB3BsA311Ps3+H+MDHnrwF2JMb3wokmjeFro+/2DEg" +
       "DAvYk4BVll76bPwR7sOVC6ULVwNpTiy4dWfefZzD3xHMXT7tQNca956P/uUP" +
       "v/yZDznHrnQVMh96+NmeuYc+eVqsniMpMsC84+Hf8Vbhd5793Q9dvlC6Fbg9" +
       "gLpAAKYJUOSx03Nc5anP7FEv5+U2wLDqeJZg5lV7qLoz2HhOfHyn0Pfdxfl9" +
       "QMavy033QXA8fWjLxX9e+wY3L9+4s49caae4KFD1p1n3l//sj/9bvRD3HoDv" +
       "ORHSWCV45oTT54PdU7j3fcc2MPMUBbT7T58d//ynv/fR9xUGAFo8da0JL+cl" +
       "BpwdqBCI+R/84fY/fPvPP/enF46NJgBRLxRNTUqOmMzvl+48h0kw208c0wNA" +
       "wwTOlVvN5bltObKmaoJoKrmV/u973lb9nf/xiXt3dmCCO3szeucrD3B8/82d" +
       "0s/+0fv/12PFMAdSHrSOZXbcbIeEbzgeGfU8Ic3pSD7yJ4/+4teFXwaYCnDM" +
       "1zKlgKZSIYNSoTSo4P8dRXnlVF01Lx73Txr/1f51Irl4VvrUn37/9dz3f+/l" +
       "gtqrs5OTuqYE95mdeeXFWxMw/IOnPX0g+BvQrvES/bfvNV/6ERiRByNKICT7" +
       "jAdwJrnKMg5b33bxP/7r33/gA9+6pXShV7rTdAS5JxROVroDWDcAFgBRifue" +
       "9+6UG18Cxb0Fq6UzzO+M4qHi6k5A4NPXx5denlwcu+hDf82Y4nP/+a/OCKFA" +
       "lmvE1FP9eejFX3oYe/d3i/7HLp73fiw5i70gETvuW/uC9YMLT97+BxdKF/nS" +
       "vdJhlscJZpg7Dg8yG3+f+oFM8Kr6q7OUXUh+5gjCHjkNLyemPQ0ux5gPzvPW" +
       "+fmdp/DkDfvY+OZDV3vzaTw5KBUn7ym6PFGUl/PiJwudXAhKF0HwiEAIB47s" +
       "FwnloSP/DfgdgOP/5kc+an5jF3nvxw7D/1uP4r8L4tLdPgBDcx+B/PPVPd6H" +
       "rF16A33o/m8bv/SXX9ylN6d1e6qx8rHn/+HfXPnE8xdOJJVPncnrTvbZJZaF" +
       "8F6fF3juLU+cN0vRo/dfv/yhf/UvPvTRHVX3X50i4WAF8MV/93++eeWzf/GN" +
       "a0Tpi6LjmIpg7wA9L2t58d6deOHrus/fOlLu3fndR8Hx8KFyH76OcqfXVi7A" +
       "5jtczwmACSpywTueo7UD8vJcOW+7vnIK3NvJ+oVffeqPP/zCU98poOOS5gOL" +
       "Rb31NRLhE32+/+K3v/snr3/0S0V4vVUU/J3tnl5BnF0gXJX3FxTfdSSNu3Lm" +
       "wcmFr+2EsfsPSpMbS9XyRZYHsVix2vL2+d/NH3Sn9sGh8eV/ZJA7vCMER6h5" +
       "cJiHFWaQF+/ba1i8jvvmp2/Px9FswTxSsanY62BzrQlvASLPT3k3OZr1wm6o" +
       "4vpNwWH4y+ELrG0cW8kj6b5ul0lqzpWjdSWoTM7Q75XecX3bogoVH4Pt15/7" +
       "7w/P3r35wGtIIR8/ZXqnh/x16sVv9H9C+icXSrccQe+ZRefVnZ65GnDv9BSw" +
       "SrZnV8HuozuVFPLb6SMv3lZI+JzgH51TVxQgrt8m5aLeaeac5h9MSqfghH2N" +
       "cPIYON5yCCdvuQ6c/Mx14CQ/5fZGdkdwhPP5neXV2d/FfWza/wcl6oZcqhNK" +
       "hhIUOcveR2/ugAVf6+u74t/fS+dj57liXig7EeWFWgyaF3/vrMPll0ZeWGc9" +
       "KL92d9MWvfMiOMcwPnlO3T/Oi3+UF+mOknPa/vwZA/vwqzewAqEvg+ORQ80/" +
       "ch0D+8w5BobtDexSbmAgUzVP2Vcxy0PnzbJHq8arXCdfXgimvL/huu5pEfzC" +
       "axTBU6Vd2C7t/68hgl95NSK4aBfrS3/P0LvOMFTgogKiaL5IAYs1EE2Obp3i" +
       "4p+/Ri4eP0SLPWpci4svvBoubgl3CPirpwj6lz8GQY8fEvT4dQj6zVdD0Ovy" +
       "lIPdCMD1T4NXTkIx2+XDiS7vwOvGngfJmu+aQgoNrfVYc5Xu7vLmPGs6Z+xr" +
       "phy3immgXB/mvrqX5O/9WDD3lR8T5r5aDPaVV4K5Pzin7ut58ftHMPeV82Du" +
       "G2dg7rde0Rh3YjwASfVttSvIlUp+/c1rC+mWIyF1T0gqAMtzU7q8XztxwPpA" +
       "mnNZN5G9f997nHrtnm+fIhJ/1USCFOzu48FIx14/8/H/8qlvfvKpb4M8nijd" +
       "FuVrVZBJnZiRDvO3Bz/34qcffd3zf/Hx4gkPUBF728t/VjyL/bevjdWHc1ZZ" +
       "J/QkhRT8gCoeyijyEbenrRKkPz8+t8EbLw0a/hDd/0hO6NYn82RqqWyKEphq" +
       "k1Cl2+gjkzXc6XSEGs1pWLfDVjbEtBPOfdoSCTRAwlYULgcEup2D3J2pzLYs" +
       "yfYsTU2E0XBlVdvNbSCoXXi69bgtudi0V9taTdjWotbYa7Vq2wASm3xdDtuR" +
       "HPYqZVEJEattqaYFRxHdhmplSzbgVrfBC65pDANuhVaDaD4KNoYkCgTNaC2W" +
       "5/xtzKRMyIppOIe85daWxQyrbKZE03aMZrxYiKSzchZbSQhnVcwSEnZKu+bK" +
       "c5f9udBl3KlULWus1awaZn/E8VlsotxigQeKm2ib6YLts2MOtxir4laNgDbD" +
       "NdFv9oexkRoSu1TQSHTSaUMkQm+geDrEzUVoNF9RNbwGqz22x/m6PImmPE3N" +
       "BSpJFiN6xDMSr+jbsglzfFypJFNvsR3TAUaIfdiSO9R4UU7XLagm88uExVfD" +
       "hSVk3qZZtYltc+FAuiQPXT5E2NGcEJI6TGgWZcyIMT8Xt6tK054r6wrmVpo1" +
       "b1tdjWcmh/uWZbNh16aFkU4Ygw6qz7OhSLHTGRvodDDGk0nsmxktyFiDqRnt" +
       "sYBptYwjs6rH6LValefqXHs40gPCFUbVRr1j9FG2O9OdzpzwHHcrVIedpt2a" +
       "w6wn9YygSs8Mbmqus/qM5kV2WzF8TB5H8XDEsytGiPDWcgRvBhWqSqVGXK+U" +
       "vao0ZFIorgdzgVMqg0Vl24wmUndgrRsjE1tnFEIMUMRKp8OFz5ESMiTINr7w" +
       "1WbaRDGts7JHTDSrVCt0hZ0Nh90lNu0B9TdqtXXZdCOuU92ijb7QJdh+e+0A" +
       "uxy2zK1r1oXNVPW2wcrQtt0FhTZwTR9mKVemgpjNuDIwcSqDoqDajGWBqU0x" +
       "f41PN5lNOVvda1EbTGxuCHE2sFy2hVIbZpBY4lCqlAM86KymKMz1y+mWZNbt" +
       "VkNR+762UpSevezDTS3zBj5tctYyIhWk4cyJ2WzMkK3pxuxoTRCRDL6mM5GQ" +
       "0aRlUn0JjZ02Faysfnde3zhlpR8tkVCNTBll3YAwhNRLJ7PVXFz4RJz0XEUw" +
       "uRFjJX2tZU1SfeGlhJkps5WtMaOpw4VS0FS0bGT5xsRcSFxTjaEJPenO2A7u" +
       "qpgvdGvNVi0ZesMW5MYJxnZ7rZTLGrq21OJ6iw9npOCmssMRQ3MmDyoCEboO" +
       "BC96Hc3uI91Aq7qEN1e5TnO0GM3lqp+p7WWbp/s6RxETXGgHtNNBtGF1GwGs" +
       "8Kq0gPX6q/FKXnvVvo5PtEnXwKGY8RqjiKQHHNNdIDBTJzargKkHUVXvopaM" +
       "oiI+F5kN2hARcPgU05eHEl1fwwRBkUh/ZchazeqxnEEi63qLsZN+uc2RXK3M" +
       "L9Z6jUdjCp2zSTNgKYYeG5LT6dZ79TTmvbTLMYwNVXF0arDDbMFmxIjVrJ6+" +
       "lg1yg7FRsKzWlK6MD7vSZDZe4aiTrF0NmTHjzmSOY/EitaflpkWUVynVJmfr" +
       "DWZW0v4mNqg1rNqEA7c61VGzyc8r6IjyDDVM4lEwXGqipK+EhRC2oaDl2SvP" +
       "q0N23KAQEGXCdk3C8VTq84aldc1x2wyxgVsJFYYzmw4TTWfqXGpbAzQzYkyM" +
       "Sc0q69GwQUv9TU2bmtXRhMGV+jwZjjYruE8o6dikVGnANDROzGC4t+5ZS0dc" +
       "jNdMi66NoSbpChQ9o6ShUVkhrZrdQVu9Za1Rl8kMqiM6QF9NtrjBFlNngalP" +
       "m0rs81sGo7mwJoorbjhqc4hYW4qkp7TVCCZFkmZX5jbqKkYqron2GlsPLCRL" +
       "24i7XOrldnsrYVUpFjpMYNBNuDpfGDZFNOcb1iAiHtF1lIdn6wk0EUInqrbQ" +
       "sjmFe01z5TIBD422igpJKBSYK4Kpopsk6+sLQQ5jqqIGcEcqt9Ktnooprw3T" +
       "xDSWFKIIQ6Y1FX2fnPVoQS/Tw6Uqa/VJWTVsvttHu9uAn9AmSbmN6Xoytuws" +
       "VOFM6Xpjrr5SiIAKPKhnl13ZHssTU6xH7nRsjfBGWYZHY3rZ68Aw4vaozban" +
       "LHrpdL0VBmXKdtMFW52oVXgDLF9wR2N1QgT0miClbax52MKaY/R2kpF+3x+T" +
       "KjJrVMrUMqpiQ9ZczXCXW66cyPS0mbHoresS1otHjttojshEmTAm3mETbg7c" +
       "2bV5tosadWJcF0Z4PNNX/aQhtJo+2Q4rcLatU3i/RsEQ2WPHE96jtktYgHUE" +
       "grrKEpLaDUpG01GcxRsLNJJqg1Y0R/w6VF7qJLBfvcyt5LFuME1qIAfz2lJd" +
       "K2ZdIjrC0pu37Q4213mTryFjqNeJZVYj4mAosYprhFWzhbrETBiJsk+yWZ1c" +
       "JF5nnmn6eEmBUD4PdEtHbSAmCkQuNQ3SNUa1V31AqKrE1dg0WoAAWYFTNWJH" +
       "+DibZsaMhpkNM6stsya2WbubcD1apPOVwg96XDsu17ZrQuABbK8jh7OXmO/O" +
       "+VXWZwJWQciVNpDX6FJDarAoRCapcoEYW2KfkLsAC0V5oVaSzXJQ1TMyFef4" +
       "sNYcrBuUbRuE0dY7iDnV2zyEEfFYgcoUN101+NWCnldqQoikim0OZLeyHQya" +
       "veEm3NpmGxHgOrLBR2WsPuVgM6wtkS4fV8Ugjvq9QYgLnE3KozJVw6ShPOu6" +
       "Md2jMSXssWlSLpcxa9kuw82lk2xdj+opLa1Gd2UJms34JKhBkTnUDW4pgfRp" +
       "W52xlWgyYdmyMLVERq92t0bY5sbeKHBtNEmYwJq75NwccERtk40D2tVGbTuw" +
       "Zh2g457gbyvKbN3QDd6IuykprCLXnBGrkVCLKZgUrIDkFqt+Q1b7QSA0K3Rr" +
       "yDVEs4zGXZuiBvP+wIj0sSY53ZqxaDQrIGnCvVaK6qLkt3jUnnuag0CdyOPr" +
       "ZWTZSiakASUiXw/rPUmLYKeRdSs9phoqW6U2pPrVDUMzXVJ2sq1egWxIlOhl" +
       "aEVST5+vTA1lrc6svFx1B64x2yQNSKws03IUwkpYHSqa0NYSG9mOMrpl8Eq1" +
       "HM7TuWWtuy0BKKPRao2yOmVP6uScUIT6DEoRxuXMQI7TKRnV3JGEYR1U7SOd" +
       "Ksjd5mO3wVg9jBO8GnAkKcYMXFd7iR2SlYU2EhsQMqCWW3iNDruB34Sny7HR" +
       "4BejzAnXdFOgyBEVK1HF3lIOscVildY5LOLkrAX742o0ibKawK3r/nSG4OMY" +
       "StlVmbc7m5BSU5MRoSoiSouB2tTj2oCgW3LIRS2QCaIVKRzPmXK4wlTd0SfW" +
       "crE1NHtu4UbbZXmT5cYkQQRurHUbCGp6MTPxQdq9YVtzcdJywzic9KlOiyeq" +
       "3mo616sWQi+XsJbEY9SvdodUraX0aRygP6qrrdkK0tH2Om4H0miwzVi2Pex7" +
       "GuuuqDK8zWiENJpeX1bMaXmAUHCsVOI6rESbMKn2xDWUSXhcwyK1D3fC1qiS" +
       "1fixn0BehTFqkIlEAuKYfqhLdn1SE1uei6VhNuA3LaNG8aNJGMmtiRTxirpd" +
       "gAw6a5ZxJOabEDbpL6R6GwWSH/QAupCTwNVhnA2w5QptGuV5mej2p36tRyvz" +
       "gdGAB12wqEDLk+a2PKmS2mw11ftNdgCnWTq1cRHfOpNGlFmTMTNrNtAxH6Ic" +
       "ETddutGSZHM7hhEsoxmQ0mtUv6ELgapjeMVWuBkyxls9PsA7FD4BUWIAUg+s" +
       "NwnZjaaJCKNyNsTSLVFRV410hvQaVmeVJWUZTTqGkc0dkbSiVRmbiYG6BskA" +
       "p/TaSl1A5N7Ms9O+DJyT7rWFMbN1ZCjJKsoIFBY5rZt6UoF7Wr1Fj5a+aGQg" +
       "Eg/Wvt4RVWg1qpTx0XAszFtCY1bJxsQYV/tyFbi5GUgS0sB79QGhBabf3FDs" +
       "2LcxuAfNlI0C+W0LUSJNKSPDZmYv6ii7TqFQ74muWqnxDUcZtaa4iyukUlew" +
       "rVFLplnUExtSONDwRSV09FZ5O+nZtRk86UP2Uq0J0sZXHZGYNpL5AmarPNzw" +
       "4MGIVM0aEVbHcEuwnKEaz2eERnezdpkZJra7pH1RUfAGIbsjxtCraXdax1GY" +
       "MMcmog3wsNL1R9xQ6fYaeJbEOliQkp1K2mvIfgp12kQjoXh6rTdaDGWPO2wz" +
       "7YmpE2UJNiWrW8UTV2UuHi3KhtTc0m2T93pIi6y5Drzq0FhMpCNMQXyjwksr" +
       "O9nUyzDGLFcTB2fVoTne1GqQXuFbkIn3tVAY4FEGbTBOhuX1WprP03JniPBs" +
       "u5ZFQ645dwJdlOke76/WwyEV8a1Npdxv1qpyKI0zouOEPYaheW88sYj2bFFh" +
       "GQxEY0MyR2UcHaw2RETx20kX9YIOTUtIh91CM8KaVDMq6mRTdTuaqrQUK2RF" +
       "99Zhi+nzuFoWUIEor1EXRilXJiaKpSzStLms1sdNqW8ymaDP9BaPm3VDXavT" +
       "7qgiVvzOwJSmlfkibscuCMLCilC9+twuh75LarDEoP6qhYwa+CRzlwEGwD7r" +
       "Mv0lL1K0tRoA+F20YnrMOisJilsV3+mEuoNHGEx5EYbBldk6bW6s7TIjG+gy" +
       "Sn08rfT4icQvguZ22+rOppP2eDpdbBgMD2BEUzDRtuJZqzyYUbHe4PpDHsEk" +
       "DcQfs1pmxzO442j0sDtcgGA4xWfAAVB5Wwcm4NApxIVdR6ouGD4dhJpWm7lu" +
       "WaKmQNLKQNmmNdSpr1vdDWn22kzMVkh+I8Wt9TBusn2+N4p8qkx5m4pfx4Uu" +
       "Y0Gr1CtPx7V8wp5QTwhW1nxrkZiKaZItelCfDXE0xvxouxrHttitMjY6wpDx" +
       "eDqhB5Lrj9trJWpWElQSfdVIEIxN2vOF");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "1/8DzISBznw/AAA=");
}
