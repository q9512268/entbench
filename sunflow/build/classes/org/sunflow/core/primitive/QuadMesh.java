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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "wPCLXYkPmf8Ac0zUgwspAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "C8LSR9V+0pHNWUhOh5K37tpNzSCXTY2C");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("YIgaDkmvpUqmvMmEJa6rfWUxN8NkKtbEeUOLxxnEBu0Va2w9ZcgioTdvr0cE" +
       "M184o6XeaCnlrWCswaKw1fqhfLvoy69vG+uBYsfu6Iyk7WJ5w6++jp2q7MQ7" +
       "taPt5+J3V+nUuboT+9wnzmwc7HcHnzz7VmD/2rY4HxOFpSdud0KyeKf7+Y+8" +
       "9LI6/PnKhcOdUC4u3R37wfe7Wqq5J0a8e7c3e/OJqefA9e5Dat99elf+WB63" +
       "3pL/vp08T+3KHhwD/GoB8MfnbNv+p7z4D3Hp8jq04vzA5S23EVPfUo/18gev" +
       "tYN4cpBTTBfv+PKjHLVDpmtvDtOn3kvfQqknX/XswR4+Ccbv/lsjqhjh6+dI" +
       "7Zt58dW4dFcSqNLh3v8pmV2Sfd/VJO9YbH/6BsRWWPfT4NIOxaa9qWLLH4uX" +
       "De/PoQ4u3p71gzvzyr8ALmxo8ZGj4H7iFS8dRsfsfvsNsPtIXvksuMJDdsM3" +
       "1TX26n/0pPqXUmxeH0hxaGVowemVc6TwUF7cE5fuB1KY+aGrFhI4etP4+BnE" +
       "RbvlGbifHYno4N43IKIierDg+uihiD765ojo4i5w7zl56xlH4qRNYSl7iKfP" +
       "QFD5QaVod/AwP9FfvJA9eOoccebHIg4ei0sPWvuuR6aVg/+XY5G94w2I7Epe" +
       "mb8G/bNDkf3ZmyOyk5ycc1byID8refB8XLoKjIZNlkcsRsfyLHiE3qhZYOD6" +
       "80Me//x74jlPnFF6/kIY2Pexvl84RxLvzYt6DGgKtUAKtZOdTykcewPCeFte" +
       "+QQg+0O7vrv/1yMM4rVm2F3ApM7htZ8XIOe5nAfM4jThoQwfORMkiubqMe+d" +
       "N8B7cVzyPYDKHz/k/cfffGOfndO2yAuQCj0E2MYlB2j3Znv//WM2+dfDZgYk" +
       "uf8MID/T/OiZb4x238UoX3z5yuVHXhb+ze5Y5f7blbuZ0mU9cd2TR1BP3N8F" +
       "DFK3Csbv3h1IDQpuPhiXHrv9dwnFUdMTzB3c2PVSgK+f7gWyqfzvJJgel+49" +
       "AQZyh8O7k0BWXLoIgPJbO9ib0In3zLsDudnBiYSzdDzVlB58LRkfdTl5Xj4/" +
       "j1d86rU/O5fsPva6oXzpZZr9kW/Uf353Xl9xpe02x3KZKV3afTpQIM3P373r" +
       "ttj2uO7qPfet+3/p7mf3CfT9O4KP7fMEbU/d+nB8ZxnExXH27a888g9/8O+8" +
       "/IfFi/b/B/GMu5GDNwAA");
}
