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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "QDv9AX/Ft1v/B8+biNdlKgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "06GLrVZzlVygDX1JQ7ZjNWa879l2czZZ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("baNQFbYeUC3EL7f7prtce+5qyvUntrqmsmy0EDUTghsraNsbtVbMWE3m2wow" +
       "/aAqBktTw5caN93gizRZqZU626eNKVvG64zQbEpDldR4tBm6kxpRV3phWh0A" +
       "ivAJRMXwGiIa5ZnZ1+3eAsfzraavvLktsAeK3b6j85ArG8s7fvVN7HKlJ96z" +
       "HW1TF787S6fO0J3YDz9xZuNgv7P45Nm3B/tXucX5mCgsPXGr05DFe94vfPTl" +
       "V3T+5+ELh7uoYly6K/b877eNtWGfWPGu3b7ujSemngPXew+xfe/p3ftjftx8" +
       "6/77dvw8taN7cAzwqwXAn5yz5fuf8+I/xqUrm9CM88OVN92CXHumfiyXP3yj" +
       "3ceTi5wiunjvlx/lQA+JRt8aok+9q76JUE++EtqDPXwSTNr94wJTrPCNc7j2" +
       "zbz4Wly6M/F19fC9wSmeXZ55nm2o7jHb/uw22FZo99PgMg7ZZrylbMtvixcV" +
       "H8yhDi7emvSDS3njXwITXhjxkaEQXuIWLyyEY3K/fRvkPpI3Pguu8JDc8C01" +
       "jb34Hz0pfkeNl9c5NQ7NtFZQevUcLjyUF3fHpfsAF8ZeaOsFB47eSD5+ZuKi" +
       "33QXhJcesejgnttgUeE9+uD62CGLPvbWsOjiznHvKXn7GUMS1W2hKXuIp89A" +
       "MPlBpWh38DA/vV+8uD146hx25kclDh6LSw+a+6FHqpWD/9djlr3rNlh2NW/M" +
       "X5f++SHL/vytYdlJSs45K3mQn5U8eD4u3Q+Upp84RyRGx/wsaCzfrlpg4PqL" +
       "Qxr/4ntiOU+cEXr+4hjo97G8XziHE+/Pi3oMcAoNXw2Nk4NPCRy7DWa8I298" +
       "AqD94d3Y3f+bYUbrjSLszmEy59DaywuQ81zJHWZxmvCQh4+ccRJFd/WY9vZt" +
       "0F4cl3wfwPLHD2n/8bde2cfn9E3zAqRCDwGyCdUC0r1R33//mEzpzZCZAk7u" +
       "PwPIzzQ/euZ7ot03MNqXXrl65ZFXRv9ud6xy/53KXWzpyjyx7ZNHUE/U7wQK" +
       "OTcLwu/aHUj1C2peikuP3fq7hOKo6QniDl7cjdKArZ8eBbKp/O8k2Dwu3XMC" +
       "DOQOh7WTQGZcugiA8urK36vQiXfUuwO56cGJhLN0HGpKD74Rj4+GnDwvn5/R" +
       "Kz7r2p+nS3Yfdr2offmVbv9HXq///O68vmarWZbPcoUtXd59OlBMmp/Je88t" +
       "Z9vPdSf93Lfu+6W7nt0n0PftED7WzxO4PXXzw/Ftx4+L4+zZrzzyT37w77/y" +
       "R8VL+v8P/DY8/283AAA=");
}
