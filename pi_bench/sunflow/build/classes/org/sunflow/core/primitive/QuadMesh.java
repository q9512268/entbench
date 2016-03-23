package org.sunflow.core.primitive;
public class QuadMesh implements org.sunflow.core.PrimitiveList {
    protected float[] points;
    protected int[] quads;
    private org.sunflow.core.ParameterList.FloatParameter normals;
    private org.sunflow.core.ParameterList.FloatParameter uvs;
    private byte[] faceShaders;
    public QuadMesh() { super();
                        quads = null;
                        points = null;
                        normals = (uvs = new org.sunflow.core.ParameterList.FloatParameter(
                                           ));
                        faceShaders = null; }
    public void writeObj(java.lang.String filename) { try { java.io.FileWriter file =
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
                                                                   quads.
                                                                     length;
                                                                 i +=
                                                                   4)
                                                                file.
                                                                  write(
                                                                    java.lang.String.
                                                                      format(
                                                                        "f %d %d %d %d\n",
                                                                        quads[i] +
                                                                          1,
                                                                        quads[i +
                                                                                1] +
                                                                          1,
                                                                        quads[i +
                                                                                2] +
                                                                          1,
                                                                        quads[i +
                                                                                3] +
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
        {
            int[] quads =
              pl.
              getIntArray(
                "quads");
            if (quads !=
                  null) {
                this.
                  quads =
                  quads;
            }
        }
        if (quads ==
              null) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  GEOM,
                "Unable to update mesh - quad indices are missing");
            return false;
        }
        if (quads.
              length %
              4 !=
              0)
            org.sunflow.system.UI.
              printWarning(
                org.sunflow.system.UI.Module.
                  GEOM,
                ("Quad index data is not a multiple of 4 - some quads may be m" +
                 "issing"));
        pl.
          setFaceCount(
            quads.
              length /
              4);
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
                        VERTEX)
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
                else {
                    points =
                      pointsP.
                        data;
                }
        }
        if (points ==
              null) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  GEOM,
                "Unabled to update mesh - vertices are missing");
            return false;
        }
        pl.
          setVertexCount(
            points.
              length /
              3);
        pl.
          setFaceVertexCount(
            4 *
              (quads.
                 length /
                 4));
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
              quads.
                length /
              4) {
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
                        "Shader index too large on quad %d",
                        i);
                this.
                  faceShaders[i] =
                  (byte)
                    (v &
                       255);
            }
        }
        return true;
    }
    public float getPrimitiveBound(int primID,
                                   int i) {
        int quad =
          4 *
          primID;
        int a =
          3 *
          quads[quad +
                  0];
        int b =
          3 *
          quads[quad +
                  1];
        int c =
          3 *
          quads[quad +
                  2];
        int d =
          3 *
          quads[quad +
                  3];
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
                         axis],
                points[d +
                         axis]);
        else
            return org.sunflow.math.MathUtils.
              max(
                points[a +
                         axis],
                points[b +
                         axis],
                points[c +
                         axis],
                points[d +
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
    public void intersectPrimitive(org.sunflow.core.Ray r,
                                   int primID,
                                   org.sunflow.core.IntersectionState state) {
        int quad =
          4 *
          primID;
        int p0 =
          3 *
          quads[quad +
                  0];
        int p1 =
          3 *
          quads[quad +
                  1];
        int p2 =
          3 *
          quads[quad +
                  2];
        int p3 =
          3 *
          quads[quad +
                  3];
        final float[] A =
          { points[p2 +
                     0] -
          points[p3 +
                   0] -
          points[p1 +
                   0] +
          points[p0 +
                   0],
        points[p2 +
                 1] -
          points[p3 +
                   1] -
          points[p1 +
                   1] +
          points[p0 +
                   1],
        points[p2 +
                 2] -
          points[p3 +
                   2] -
          points[p1 +
                   2] +
          points[p0 +
                   2] };
        final float[] B =
          { points[p1 +
                     0] -
          points[p0 +
                   0],
        points[p1 +
                 1] -
          points[p0 +
                   1],
        points[p1 +
                 2] -
          points[p0 +
                   2] };
        final float[] C =
          { points[p3 +
                     0] -
          points[p0 +
                   0],
        points[p3 +
                 1] -
          points[p0 +
                   1],
        points[p3 +
                 2] -
          points[p0 +
                   2] };
        final float[] R =
          { r.
              ox -
          points[p0 +
                   0],
        r.
          oy -
          points[p0 +
                   1],
        r.
          oz -
          points[p0 +
                   2] };
        final float[] Q =
          { r.
              dx,
        r.
          dy,
        r.
          dz };
        float absqx =
          java.lang.Math.
          abs(
            r.
              dx);
        float absqy =
          java.lang.Math.
          abs(
            r.
              dy);
        float absqz =
          java.lang.Math.
          abs(
            r.
              dz);
        int X =
          0;
        int Y =
          1;
        int Z =
          2;
        if (absqx >
              absqy &&
              absqx >
              absqz) {
            
        }
        else
            if (absqy >
                  absqz) {
                X =
                  1;
                Y =
                  0;
            }
            else {
                X =
                  2;
                Z =
                  0;
            }
        float Cxz =
          C[X] *
          Q[Z] -
          C[Z] *
          Q[X];
        float Cyx =
          C[Y] *
          Q[X] -
          C[X] *
          Q[Y];
        float Czy =
          C[Z] *
          Q[Y] -
          C[Y] *
          Q[Z];
        float Rxz =
          R[X] *
          Q[Z] -
          R[Z] *
          Q[X];
        float Ryx =
          R[Y] *
          Q[X] -
          R[X] *
          Q[Y];
        float Rzy =
          R[Z] *
          Q[Y] -
          R[Y] *
          Q[Z];
        float Bxy =
          B[X] *
          Q[Y] -
          B[Y] *
          Q[X];
        float Byz =
          B[Y] *
          Q[Z] -
          B[Z] *
          Q[Y];
        float Bzx =
          B[Z] *
          Q[X] -
          B[X] *
          Q[Z];
        float a =
          A[X] *
          Byz +
          A[Y] *
          Bzx +
          A[Z] *
          Bxy;
        if (a ==
              0) {
            float b =
              B[X] *
              Czy +
              B[Y] *
              Cxz +
              B[Z] *
              Cyx;
            float c =
              C[X] *
              Rzy +
              C[Y] *
              Rxz +
              C[Z] *
              Ryx;
            float u =
              -c /
              b;
            if (u >=
                  0 &&
                  u <=
                  1) {
                float v =
                  (u *
                     Bxy +
                     Ryx) /
                  Cyx;
                if (v >=
                      0 &&
                      v <=
                      1) {
                    float t =
                      (B[X] *
                         u +
                         C[X] *
                         v -
                         R[X]) /
                      Q[X];
                    if (r.
                          isInside(
                            t)) {
                        r.
                          setMax(
                            t);
                        state.
                          setIntersection(
                            primID,
                            u,
                            v);
                    }
                }
            }
        }
        else {
            float b =
              A[X] *
              Rzy +
              A[Y] *
              Rxz +
              A[Z] *
              Ryx +
              B[X] *
              Czy +
              B[Y] *
              Cxz +
              B[Z] *
              Cyx;
            float c =
              C[X] *
              Rzy +
              C[Y] *
              Rxz +
              C[Z] *
              Ryx;
            float discrim =
              b *
              b -
              4 *
              a *
              c;
            if (c *
                  (a +
                     b +
                     c) >
                  0 &&
                  (discrim <
                     0 ||
                     a *
                     c <
                     0 ||
                     b /
                     a >
                     0 ||
                     b /
                     a <
                     -2))
                return;
            float q =
              b >
              0
              ? -0.5F *
              (b +
                 (float)
                   java.lang.Math.
                   sqrt(
                     discrim))
              : -0.5F *
              (b -
                 (float)
                   java.lang.Math.
                   sqrt(
                     discrim));
            float Axy =
              A[X] *
              Q[Y] -
              A[Y] *
              Q[X];
            float u =
              q /
              a;
            if (u >=
                  0 &&
                  u <=
                  1) {
                float d =
                  u *
                  Axy -
                  Cyx;
                float v =
                  -(u *
                      Bxy +
                      Ryx) /
                  d;
                if (v >=
                      0 &&
                      v <=
                      1) {
                    float t =
                      (A[X] *
                         u *
                         v +
                         B[X] *
                         u +
                         C[X] *
                         v -
                         R[X]) /
                      Q[X];
                    if (r.
                          isInside(
                            t)) {
                        r.
                          setMax(
                            t);
                        state.
                          setIntersection(
                            primID,
                            u,
                            v);
                    }
                }
            }
            u =
              c /
                q;
            if (u >=
                  0 &&
                  u <=
                  1) {
                float d =
                  u *
                  Axy -
                  Cyx;
                float v =
                  -(u *
                      Bxy +
                      Ryx) /
                  d;
                if (v >=
                      0 &&
                      v <=
                      1) {
                    float t =
                      (A[X] *
                         u *
                         v +
                         B[X] *
                         u +
                         C[X] *
                         v -
                         R[X]) /
                      Q[X];
                    if (r.
                          isInside(
                            t)) {
                        r.
                          setMax(
                            t);
                        state.
                          setIntersection(
                            primID,
                            u,
                            v);
                    }
                }
            }
        }
    }
    public int getNumPrimitives() { return quads.
                                             length /
                                      4; }
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
        state.
          getRay(
            ).
          getPoint(
            state.
              getPoint(
                ));
        int quad =
          4 *
          primID;
        int index0 =
          quads[quad +
                  0];
        int index1 =
          quads[quad +
                  1];
        int index2 =
          quads[quad +
                  2];
        int index3 =
          quads[quad +
                  3];
        org.sunflow.math.Point3 v0p =
          getPoint(
            index0);
        org.sunflow.math.Point3 v1p =
          getPoint(
            index1);
        org.sunflow.math.Point3 v2p =
          getPoint(
            index2);
        org.sunflow.math.Point3 v3p =
          getPoint(
            index2);
        float tanux =
          (1 -
             v) *
          (v1p.
             x -
             v0p.
               x) +
          v *
          (v2p.
             x -
             v3p.
               x);
        float tanuy =
          (1 -
             v) *
          (v1p.
             y -
             v0p.
               y) +
          v *
          (v2p.
             y -
             v3p.
               y);
        float tanuz =
          (1 -
             v) *
          (v1p.
             z -
             v0p.
               z) +
          v *
          (v2p.
             z -
             v3p.
               z);
        float tanvx =
          (1 -
             u) *
          (v3p.
             x -
             v0p.
               x) +
          u *
          (v2p.
             x -
             v1p.
               x);
        float tanvy =
          (1 -
             u) *
          (v3p.
             y -
             v0p.
               y) +
          u *
          (v2p.
             y -
             v1p.
               y);
        float tanvz =
          (1 -
             u) *
          (v3p.
             z -
             v0p.
               z) +
          u *
          (v2p.
             z -
             v1p.
               z);
        float nx =
          tanuy *
          tanvz -
          tanuz *
          tanvy;
        float ny =
          tanuz *
          tanvx -
          tanux *
          tanvz;
        float nz =
          tanux *
          tanvy -
          tanuy *
          tanvx;
        org.sunflow.math.Vector3 ng =
          new org.sunflow.math.Vector3(
          nx,
          ny,
          nz);
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
        float k00 =
          (1 -
             u) *
          (1 -
             v);
        float k10 =
          u *
          (1 -
             v);
        float k01 =
          (1 -
             u) *
          v;
        float k11 =
          u *
          v;
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
                    int i33 =
                      3 *
                      index3;
                    float[] normals =
                      this.
                        normals.
                        data;
                    state.
                      getNormal(
                        ).
                      x =
                      k00 *
                        normals[i30 +
                                  0] +
                        k10 *
                        normals[i31 +
                                  0] +
                        k11 *
                        normals[i32 +
                                  0] +
                        k01 *
                        normals[i33 +
                                  0];
                    state.
                      getNormal(
                        ).
                      y =
                      k00 *
                        normals[i30 +
                                  1] +
                        k10 *
                        normals[i31 +
                                  1] +
                        k11 *
                        normals[i32 +
                                  1] +
                        k01 *
                        normals[i33 +
                                  1];
                    state.
                      getNormal(
                        ).
                      z =
                      k00 *
                        normals[i30 +
                                  2] +
                        k10 *
                        normals[i31 +
                                  2] +
                        k11 *
                        normals[i32 +
                                  2] +
                        k01 *
                        normals[i33 +
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
                      quad;
                    float[] normals =
                      this.
                        normals.
                        data;
                    state.
                      getNormal(
                        ).
                      x =
                      k00 *
                        normals[idx +
                                  0] +
                        k10 *
                        normals[idx +
                                  3] +
                        k11 *
                        normals[idx +
                                  6] +
                        k01 *
                        normals[idx +
                                  9];
                    state.
                      getNormal(
                        ).
                      y =
                      k00 *
                        normals[idx +
                                  1] +
                        k10 *
                        normals[idx +
                                  4] +
                        k11 *
                        normals[idx +
                                  7] +
                        k01 *
                        normals[idx +
                                  10];
                    state.
                      getNormal(
                        ).
                      z =
                      k00 *
                        normals[idx +
                                  2] +
                        k10 *
                        normals[idx +
                                  5] +
                        k11 *
                        normals[idx +
                                  8] +
                        k01 *
                        normals[idx +
                                  11];
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
        float uv30 =
          0;
        float uv31 =
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
                    int i23 =
                      2 *
                      index3;
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
                    uv20 =
                      uvs[i23 +
                            0];
                    uv21 =
                      uvs[i23 +
                            1];
                    break;
                }
            case FACEVARYING:
                {
                    int idx =
                      quad <<
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
                    uv30 =
                      uvs[idx +
                            6];
                    uv31 =
                      uvs[idx +
                            7];
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
              k00 *
                uv00 +
                k10 *
                uv10 +
                k11 *
                uv20 +
                k01 *
                uv30;
            state.
              getUV(
                ).
              y =
              k00 *
                uv01 +
                k10 *
                uv11 +
                k11 *
                uv21 +
                k01 *
                uv31;
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
    public org.sunflow.core.PrimitiveList getBakingPrimitives() {
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/opvt/4P/hNtYlEqAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "amfC1UeNaN3n50K56Yy1AdLsQTTD0YSh");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("DXq4qqxXgcqINRvnHQIOK114pcYdAY8qbOYElSk9TTyBIMtk2ycz0+ws1G4c" +
       "VcAU01wo9dZ0bNT7Da8soPNmOBtJ/bA1mtAzfQjh2jpown6wjmF0BJuDeO6Q" +
       "KxzHfyjfZvrqa9v+eqDY6Tu647h06nnFr72GHa70xHna0cZ08burdOpe3Ikd" +
       "8BM3Mg72u4pPnj0v2B/ZFrdforD0xO1uOBbnuV/86IsvacNfqFw43EHl4tLd" +
       "sR98v6OvdedEj3fv9nRvvg/1HHjefUjtu0/v1x/L49ab9d+3k+ep3dyDY4Bf" +
       "KwD+5Jzt3v+cJ/8xLl3ehFacX5i85fbj2re043H5w1fbeTzZySmmi/O9/KIG" +
       "dsg09uYwfepM+haDevIQaA/28EkwfvfGR1TRwzfPkdq38+TrcemuJNDkwzOD" +
       "UzK7pPi+o8vesdj+7A2IrdDup8GjH4pNf1PFln8WhxTvz6EOLt6e9YM788K/" +
       "BCa80OMjQ2n5iVccVoyO2f3uG2D3kbzwWfCEh+yGb6pp7If/0ZPD78qxeZ2V" +
       "49BK0YLTK+dI4aE8uScu3Q+kIPihoxUSODqDfPwM4qLe8hYtPz0S0cG9b0BE" +
       "hfcYgOfjhyL6+Jsjoos7x73n5K1nDImTt4Wm7CGePgNB5deQot21wvxGfnFU" +
       "e/DUOeLMr0QcPBaXHrT2TY9UKwf/r8cie8cbENmVvDA/IP3zQ5H9+ZsjspOc" +
       "nHMT8iC/CXnwfFy6CpRmkLhHLEbH8ix4hN6oWtTB8xeHPP7FX4nlPHFm0POj" +
       "YqDfx+P9wjmSeG+e1GJAU6gHcqifbHxqwOtvQBhvywufAGR/aNd2934twiBe" +
       "bYbdOUzqHF77eQJinsu5wyzuCh7K8JEzTqKoRo55J98A78VlyPcAKn/ykPef" +
       "fPOVXTinbp4nIBR6CLDdkm0wujfr+x8cs8m/FjZTIMn9Jf/8xvKjZ/4jtPtf" +
       "i/rll65cfuSl6b/dXZrc//fkbqZ02Ugc5+QF0xP5u4BCGlbB+N2766ZBwc0H" +
       "4tJjt//XQXGR9ARzBzd2rVRg66dbgWgqf50EM+LSvSfAQOxwmDsJZMWliwAo" +
       "zy6DvQqdOJ/eXbdND04EnKXjqab04KvJ+KjJydvw+V284q9a+3tzye7PWjfU" +
       "r7xED37sW7Vf2N3GVx05y3Isl5nSpd0fAwqk+d27d90W2x7XXb3nvnP/L9/9" +
       "7D6Avn9H8LF+nqDtqVtffSfdIC4uq2e/+sg//sG/99IfFQf0/x8RqF3NQzcA" +
       "AA==");
}
