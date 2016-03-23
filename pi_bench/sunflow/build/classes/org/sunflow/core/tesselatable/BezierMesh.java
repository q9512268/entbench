package org.sunflow.core.tesselatable;
public class BezierMesh implements org.sunflow.core.PrimitiveList, org.sunflow.core.Tesselatable {
    private int subdivs;
    private boolean smooth;
    private boolean quads;
    private float[][] patches;
    public BezierMesh() { this(null); }
    public BezierMesh(float[][] patches) { super();
                                           subdivs = 8;
                                           smooth = true;
                                           quads = false;
                                           this.patches = patches; }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        org.sunflow.math.BoundingBox bounds =
          new org.sunflow.math.BoundingBox(
          );
        if (o2w ==
              null) {
            for (int i =
                   0;
                 i <
                   patches.
                     length;
                 i++) {
                float[] patch =
                  patches[i];
                for (int j =
                       0;
                     j <
                       patch.
                         length;
                     j +=
                       3)
                    bounds.
                      include(
                        patch[j],
                        patch[j +
                                1],
                        patch[j +
                                2]);
            }
        }
        else {
            for (int i =
                   0;
                 i <
                   patches.
                     length;
                 i++) {
                float[] patch =
                  patches[i];
                for (int j =
                       0;
                     j <
                       patch.
                         length;
                     j +=
                       3) {
                    float x =
                      patch[j];
                    float y =
                      patch[j +
                              1];
                    float z =
                      patch[j +
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
        }
        return bounds;
    }
    private float[] bernstein(float u) { float[] b = new float[4];
                                         float i = 1 - u;
                                         b[0] = i * i * i;
                                         b[1] = 3 * u * i * i;
                                         b[2] = 3 * u * u * i;
                                         b[3] = u * u * u;
                                         return b; }
    private float[] bernsteinDeriv(float u) { if (!smooth) return null;
                                              float[] b = new float[4];
                                              float i = 1 - u;
                                              b[0] = 3 * (0 - i *
                                                            i);
                                              b[1] = 3 * (i * i -
                                                            2 *
                                                            u *
                                                            i);
                                              b[2] = 3 * (2 * u *
                                                            i -
                                                            u *
                                                            u);
                                              b[3] = 3 * (u * u -
                                                            0);
                                              return b; }
    private void getPatchPoint(float u, float v, float[] ctrl, float[] bu,
                               float[] bv,
                               float[] bdu,
                               float[] bdv,
                               org.sunflow.math.Point3 p,
                               org.sunflow.math.Vector3 n) { float px =
                                                               0;
                                                             float py =
                                                               0;
                                                             float pz =
                                                               0;
                                                             for (int i =
                                                                    0,
                                                                    index =
                                                                      0;
                                                                  i <
                                                                    4;
                                                                  i++) {
                                                                 for (int j =
                                                                        0;
                                                                      j <
                                                                        4;
                                                                      j++,
                                                                        index +=
                                                                          3) {
                                                                     float scale =
                                                                       bu[j] *
                                                                       bv[i];
                                                                     px +=
                                                                       ctrl[index +
                                                                              0] *
                                                                         scale;
                                                                     py +=
                                                                       ctrl[index +
                                                                              1] *
                                                                         scale;
                                                                     pz +=
                                                                       ctrl[index +
                                                                              2] *
                                                                         scale;
                                                                 }
                                                             }
                                                             p.
                                                               x =
                                                               px;
                                                             p.
                                                               y =
                                                               py;
                                                             p.
                                                               z =
                                                               pz;
                                                             if (n !=
                                                                   null) {
                                                                 float dpdux =
                                                                   0;
                                                                 float dpduy =
                                                                   0;
                                                                 float dpduz =
                                                                   0;
                                                                 float dpdvx =
                                                                   0;
                                                                 float dpdvy =
                                                                   0;
                                                                 float dpdvz =
                                                                   0;
                                                                 for (int i =
                                                                        0,
                                                                        index =
                                                                          0;
                                                                      i <
                                                                        4;
                                                                      i++) {
                                                                     for (int j =
                                                                            0;
                                                                          j <
                                                                            4;
                                                                          j++,
                                                                            index +=
                                                                              3) {
                                                                         float scaleu =
                                                                           bdu[j] *
                                                                           bv[i];
                                                                         dpdux +=
                                                                           ctrl[index +
                                                                                  0] *
                                                                             scaleu;
                                                                         dpduy +=
                                                                           ctrl[index +
                                                                                  1] *
                                                                             scaleu;
                                                                         dpduz +=
                                                                           ctrl[index +
                                                                                  2] *
                                                                             scaleu;
                                                                         float scalev =
                                                                           bu[j] *
                                                                           bdv[i];
                                                                         dpdvx +=
                                                                           ctrl[index +
                                                                                  0] *
                                                                             scalev;
                                                                         dpdvy +=
                                                                           ctrl[index +
                                                                                  1] *
                                                                             scalev;
                                                                         dpdvz +=
                                                                           ctrl[index +
                                                                                  2] *
                                                                             scalev;
                                                                     }
                                                                 }
                                                                 n.
                                                                   x =
                                                                   dpduy *
                                                                     dpdvz -
                                                                     dpduz *
                                                                     dpdvy;
                                                                 n.
                                                                   y =
                                                                   dpduz *
                                                                     dpdvx -
                                                                     dpdux *
                                                                     dpdvz;
                                                                 n.
                                                                   z =
                                                                   dpdux *
                                                                     dpdvy -
                                                                     dpduy *
                                                                     dpdvx;
                                                             }
    }
    public org.sunflow.core.PrimitiveList tesselate() {
        float[] vertices =
          new float[patches.
                      length *
                      (subdivs +
                         1) *
                      (subdivs +
                         1) *
                      3];
        float[] normals =
          smooth
          ? (new float[patches.
                         length *
                         (subdivs +
                            1) *
                         (subdivs +
                            1) *
                         3])
          : null;
        float[] uvs =
          new float[patches.
                      length *
                      (subdivs +
                         1) *
                      (subdivs +
                         1) *
                      2];
        int[] indices =
          new int[patches.
                    length *
                    subdivs *
                    subdivs *
                    (quads
                       ? 4
                       : 2 *
                       3)];
        int vidx =
          0;
        int pidx =
          0;
        float step =
          1.0F /
          subdivs;
        int vstride =
          subdivs +
          1;
        org.sunflow.math.Point3 p =
          new org.sunflow.math.Point3(
          );
        org.sunflow.math.Vector3 n =
          smooth
          ? new org.sunflow.math.Vector3(
          )
          : null;
        for (float[] patch
              :
              patches) {
            for (int i =
                   0,
                   voff =
                     0;
                 i <=
                   subdivs;
                 i++) {
                float u =
                  i *
                  step;
                float[] bu =
                  bernstein(
                    u);
                float[] bdu =
                  bernsteinDeriv(
                    u);
                for (int j =
                       0;
                     j <=
                       subdivs;
                     j++,
                       voff +=
                         3) {
                    float v =
                      j *
                      step;
                    float[] bv =
                      bernstein(
                        v);
                    float[] bdv =
                      bernsteinDeriv(
                        v);
                    getPatchPoint(
                      u,
                      v,
                      patch,
                      bu,
                      bv,
                      bdu,
                      bdv,
                      p,
                      n);
                    vertices[vidx +
                               voff +
                               0] =
                      p.
                        x;
                    vertices[vidx +
                               voff +
                               1] =
                      p.
                        y;
                    vertices[vidx +
                               voff +
                               2] =
                      p.
                        z;
                    if (smooth) {
                        normals[vidx +
                                  voff +
                                  0] =
                          n.
                            x;
                        normals[vidx +
                                  voff +
                                  1] =
                          n.
                            y;
                        normals[vidx +
                                  voff +
                                  2] =
                          n.
                            z;
                    }
                    uvs[(vidx +
                           voff) /
                          3 *
                          2 +
                          0] =
                      u;
                    uvs[(vidx +
                           voff) /
                          3 *
                          2 +
                          1] =
                      v;
                }
            }
            for (int i =
                   0,
                   vbase =
                     vidx /
                     3;
                 i <
                   subdivs;
                 i++) {
                for (int j =
                       0;
                     j <
                       subdivs;
                     j++) {
                    int v00 =
                      (i +
                         0) *
                      vstride +
                      (j +
                         0);
                    int v10 =
                      (i +
                         1) *
                      vstride +
                      (j +
                         0);
                    int v01 =
                      (i +
                         0) *
                      vstride +
                      (j +
                         1);
                    int v11 =
                      (i +
                         1) *
                      vstride +
                      (j +
                         1);
                    if (quads) {
                        indices[pidx +
                                  0] =
                          vbase +
                            v01;
                        indices[pidx +
                                  1] =
                          vbase +
                            v00;
                        indices[pidx +
                                  2] =
                          vbase +
                            v10;
                        indices[pidx +
                                  3] =
                          vbase +
                            v11;
                        pidx +=
                          4;
                    }
                    else {
                        indices[pidx +
                                  0] =
                          vbase +
                            v00;
                        indices[pidx +
                                  1] =
                          vbase +
                            v10;
                        indices[pidx +
                                  2] =
                          vbase +
                            v01;
                        indices[pidx +
                                  3] =
                          vbase +
                            v10;
                        indices[pidx +
                                  4] =
                          vbase +
                            v11;
                        indices[pidx +
                                  5] =
                          vbase +
                            v01;
                        pidx +=
                          6;
                    }
                }
            }
            vidx +=
              vstride *
                vstride *
                3;
        }
        org.sunflow.core.ParameterList pl =
          new org.sunflow.core.ParameterList(
          );
        pl.
          addPoints(
            "points",
            org.sunflow.core.ParameterList.InterpolationType.
              VERTEX,
            vertices);
        if (quads)
            pl.
              addIntegerArray(
                "quads",
                indices);
        else
            pl.
              addIntegerArray(
                "triangles",
                indices);
        pl.
          addTexCoords(
            "uvs",
            org.sunflow.core.ParameterList.InterpolationType.
              VERTEX,
            uvs);
        if (smooth)
            pl.
              addVectors(
                "normals",
                org.sunflow.core.ParameterList.InterpolationType.
                  VERTEX,
                normals);
        org.sunflow.core.PrimitiveList m =
          quads
          ? new org.sunflow.core.primitive.QuadMesh(
          )
          : new org.sunflow.core.primitive.TriangleMesh(
          );
        m.
          update(
            pl,
            null);
        pl.
          clear(
            true);
        return m;
    }
    public boolean update(org.sunflow.core.ParameterList pl,
                          org.sunflow.SunflowAPI api) {
        subdivs =
          pl.
            getInt(
              "subdivs",
              subdivs);
        smooth =
          pl.
            getBoolean(
              "smooth",
              smooth);
        quads =
          pl.
            getBoolean(
              "quads",
              quads);
        int nu =
          pl.
          getInt(
            "nu",
            0);
        int nv =
          pl.
          getInt(
            "nv",
            0);
        pl.
          setVertexCount(
            nu *
              nv);
        boolean uwrap =
          pl.
          getBoolean(
            "uwrap",
            false);
        boolean vwrap =
          pl.
          getBoolean(
            "vwrap",
            false);
        org.sunflow.core.ParameterList.FloatParameter points =
          pl.
          getPointArray(
            "points");
        if (points !=
              null &&
              points.
                interp ==
              org.sunflow.core.ParameterList.InterpolationType.
                VERTEX) {
            int numUPatches =
              uwrap
              ? nu /
              3
              : (nu -
                   4) /
              3 +
              1;
            int numVPatches =
              vwrap
              ? nv /
              3
              : (nv -
                   4) /
              3 +
              1;
            if (numUPatches <
                  1 ||
                  numVPatches <
                  1) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      GEOM,
                    "Invalid number of patches for bezier mesh - ignoring");
                return false;
            }
            patches =
              (new float[numUPatches *
                           numVPatches][]);
            for (int v =
                   0,
                   p =
                     0;
                 v <
                   numVPatches;
                 v++) {
                for (int u =
                       0;
                     u <
                       numUPatches;
                     u++,
                       p++) {
                    float[] patch =
                      patches[p] =
                      (new float[16 *
                                   3]);
                    int up =
                      u *
                      3;
                    int vp =
                      v *
                      3;
                    for (int pv =
                           0;
                         pv <
                           4;
                         pv++) {
                        for (int pu =
                               0;
                             pu <
                               4;
                             pu++) {
                            int meshU =
                              (up +
                                 pu) %
                              nu;
                            int meshV =
                              (vp +
                                 pv) %
                              nv;
                            patch[3 *
                                    (pv *
                                       4 +
                                       pu) +
                                    0] =
                              points.
                                data[3 *
                                       (meshU +
                                          nu *
                                          meshV) +
                                       0];
                            patch[3 *
                                    (pv *
                                       4 +
                                       pu) +
                                    1] =
                              points.
                                data[3 *
                                       (meshU +
                                          nu *
                                          meshV) +
                                       1];
                            patch[3 *
                                    (pv *
                                       4 +
                                       pu) +
                                    2] =
                              points.
                                data[3 *
                                       (meshU +
                                          nu *
                                          meshV) +
                                       2];
                        }
                    }
                }
            }
        }
        if (subdivs <
              1) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  GEOM,
                "Invalid subdivisions for bezier mesh - ignoring");
            return false;
        }
        if (patches ==
              null) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  GEOM,
                "No patch data present in bezier mesh - ignoring");
            return false;
        }
        return true;
    }
    public int getNumPrimitives() { return patches.
                                             length;
    }
    public float getPrimitiveBound(int primID,
                                   int i) {
        float[] patch =
          patches[primID];
        int axis =
          i >>>
          1;
        if ((i &
               1) ==
              0) {
            float min =
              patch[axis];
            for (int j =
                   axis +
                   3;
                 j <
                   patch.
                     length;
                 j +=
                   3)
                if (min >
                      patch[j])
                    min =
                      patch[j];
            return min;
        }
        else {
            float max =
              patch[axis];
            for (int j =
                   axis +
                   3;
                 j <
                   patch.
                     length;
                 j +=
                   3)
                if (max <
                      patch[j])
                    max =
                      patch[j];
            return max;
        }
    }
    public void intersectPrimitive(org.sunflow.core.Ray r,
                                   int primID,
                                   org.sunflow.core.IntersectionState state) {
        final float[] stack =
          state.
          getRobustStack(
            );
        final int STACKSIZE =
          64;
        {
            float[] patch =
              patches[primID];
            for (int i =
                   0;
                 i <
                   4 *
                   4 *
                   3;
                 i++)
                stack[i] =
                  patch[i];
            stack[48] =
              java.lang.Float.
                POSITIVE_INFINITY;
            stack[49] =
              0;
            stack[50] =
              0;
            stack[51] =
              1;
            stack[52] =
              1;
        }
        int stackpos =
          0;
        float orgX =
          r.
            ox;
        float invDirX =
          1 /
          r.
            dx;
        float orgY =
          r.
            oy;
        float invDirY =
          1 /
          r.
            dy;
        float orgZ =
          r.
            oz;
        float invDirZ =
          1 /
          r.
            dz;
        float t1;
        float t2;
        while (stackpos >=
                 0) {
            float intervalMin =
              r.
              getMin(
                );
            float intervalMax =
              r.
              getMax(
                );
            float minx =
              stack[stackpos +
                      0];
            float maxx =
              stack[stackpos +
                      0];
            for (int j =
                   1,
                   idx =
                     stackpos +
                     3;
                 j <
                   4 *
                   4;
                 j++,
                   idx +=
                     3) {
                if (minx >
                      stack[idx])
                    minx =
                      stack[idx];
                if (maxx <
                      stack[idx])
                    maxx =
                      stack[idx];
            }
            t1 =
              (minx -
                 orgX) *
                invDirX;
            t2 =
              (maxx -
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
                  STACKSIZE;
                continue;
            }
            float miny =
              stack[stackpos +
                      1];
            float maxy =
              stack[stackpos +
                      1];
            for (int j =
                   1,
                   idx =
                     stackpos +
                     4;
                 j <
                   4 *
                   4;
                 j++,
                   idx +=
                     3) {
                if (miny >
                      stack[idx])
                    miny =
                      stack[idx];
                if (maxy <
                      stack[idx])
                    maxy =
                      stack[idx];
            }
            t1 =
              (miny -
                 orgY) *
                invDirY;
            t2 =
              (maxy -
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
                  STACKSIZE;
                continue;
            }
            float minz =
              stack[stackpos +
                      2];
            float maxz =
              stack[stackpos +
                      2];
            for (int j =
                   1,
                   idx =
                     stackpos +
                     5;
                 j <
                   4 *
                   4;
                 j++,
                   idx +=
                     3) {
                if (minz >
                      stack[idx])
                    minz =
                      stack[idx];
                if (maxz <
                      stack[idx])
                    maxz =
                      stack[idx];
            }
            t1 =
              (minz -
                 orgZ) *
                invDirZ;
            t2 =
              (maxz -
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
                  STACKSIZE;
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
                            48]) ==
                  java.lang.Float.
                  floatToRawIntBits(
                    size)) {
                r.
                  setMax(
                    intervalMin);
                state.
                  setIntersection(
                    primID,
                    stack[stackpos +
                            49],
                    stack[stackpos +
                            50]);
                stackpos -=
                  STACKSIZE;
                continue;
            }
            float sizeu =
              0;
            float sizev =
              0;
            for (int i =
                   0;
                 i <
                   3;
                 i++) {
                sizeu +=
                  java.lang.Math.
                    abs(
                      stack[stackpos +
                              (0 *
                                 4 +
                                 3) *
                              3 +
                              i] -
                        stack[stackpos +
                                i]);
                sizev +=
                  java.lang.Math.
                    abs(
                      stack[stackpos +
                              (3 *
                                 4 +
                                 0) *
                              3 +
                              i] -
                        stack[stackpos +
                                i]);
            }
            if (sizeu >
                  sizev) {
                for (int i =
                       0;
                     i <
                       4;
                     i++) {
                    for (int axis =
                           0;
                         axis <
                           3;
                         axis++) {
                        float p0 =
                          stack[stackpos +
                                  (i *
                                     4 +
                                     0) *
                                  3 +
                                  axis];
                        float p1 =
                          stack[stackpos +
                                  (i *
                                     4 +
                                     1) *
                                  3 +
                                  axis];
                        float p2 =
                          stack[stackpos +
                                  (i *
                                     4 +
                                     2) *
                                  3 +
                                  axis];
                        float p3 =
                          stack[stackpos +
                                  (i *
                                     4 +
                                     3) *
                                  3 +
                                  axis];
                        float q0 =
                          p0;
                        float q1 =
                          (p0 +
                             p1) *
                          0.5F;
                        float q2 =
                          q1 *
                          0.5F +
                          (p1 +
                             p2) *
                          0.25F;
                        float r3 =
                          p3;
                        float r2 =
                          (p2 +
                             p3) *
                          0.5F;
                        float r1 =
                          r2 *
                          0.5F +
                          (p1 +
                             p2) *
                          0.25F;
                        float q3 =
                          (q2 +
                             r1) *
                          0.5F;
                        float r0 =
                          q3;
                        stack[stackpos +
                                (i *
                                   4 +
                                   0) *
                                3 +
                                axis] =
                          q0;
                        stack[stackpos +
                                (i *
                                   4 +
                                   1) *
                                3 +
                                axis] =
                          q1;
                        stack[stackpos +
                                (i *
                                   4 +
                                   2) *
                                3 +
                                axis] =
                          q2;
                        stack[stackpos +
                                (i *
                                   4 +
                                   3) *
                                3 +
                                axis] =
                          q3;
                        stack[stackpos +
                                STACKSIZE +
                                (i *
                                   4 +
                                   0) *
                                3 +
                                axis] =
                          r0;
                        stack[stackpos +
                                STACKSIZE +
                                (i *
                                   4 +
                                   1) *
                                3 +
                                axis] =
                          r1;
                        stack[stackpos +
                                STACKSIZE +
                                (i *
                                   4 +
                                   2) *
                                3 +
                                axis] =
                          r2;
                        stack[stackpos +
                                STACKSIZE +
                                (i *
                                   4 +
                                   3) *
                                3 +
                                axis] =
                          r3;
                    }
                }
                stack[stackpos +
                        48] =
                  (stack[stackpos +
                           STACKSIZE +
                           48] =
                     size);
                float umin =
                  stack[stackpos +
                          49];
                float umax =
                  stack[stackpos +
                          51];
                stack[stackpos +
                        49] =
                  umin;
                stack[stackpos +
                        STACKSIZE +
                        50] =
                  stack[stackpos +
                          50];
                stack[stackpos +
                        51] =
                  (stack[stackpos +
                           STACKSIZE +
                           49] =
                     (umin +
                        umax) *
                       0.5F);
                stack[stackpos +
                        STACKSIZE +
                        51] =
                  umax;
                stack[stackpos +
                        STACKSIZE +
                        52] =
                  stack[stackpos +
                          52];
            }
            else {
                for (int i =
                       0;
                     i <
                       4;
                     i++) {
                    for (int axis =
                           0;
                         axis <
                           3;
                         axis++) {
                        float p0 =
                          stack[stackpos +
                                  (0 *
                                     4 +
                                     i) *
                                  3 +
                                  axis];
                        float p1 =
                          stack[stackpos +
                                  (1 *
                                     4 +
                                     i) *
                                  3 +
                                  axis];
                        float p2 =
                          stack[stackpos +
                                  (2 *
                                     4 +
                                     i) *
                                  3 +
                                  axis];
                        float p3 =
                          stack[stackpos +
                                  (3 *
                                     4 +
                                     i) *
                                  3 +
                                  axis];
                        float q0 =
                          p0;
                        float q1 =
                          (p0 +
                             p1) *
                          0.5F;
                        float q2 =
                          q1 *
                          0.5F +
                          (p1 +
                             p2) *
                          0.25F;
                        float r3 =
                          p3;
                        float r2 =
                          (p2 +
                             p3) *
                          0.5F;
                        float r1 =
                          r2 *
                          0.5F +
                          (p1 +
                             p2) *
                          0.25F;
                        float q3 =
                          (q2 +
                             r1) *
                          0.5F;
                        float r0 =
                          q3;
                        stack[stackpos +
                                (0 *
                                   4 +
                                   i) *
                                3 +
                                axis] =
                          q0;
                        stack[stackpos +
                                (1 *
                                   4 +
                                   i) *
                                3 +
                                axis] =
                          q1;
                        stack[stackpos +
                                (2 *
                                   4 +
                                   i) *
                                3 +
                                axis] =
                          q2;
                        stack[stackpos +
                                (3 *
                                   4 +
                                   i) *
                                3 +
                                axis] =
                          q3;
                        stack[stackpos +
                                STACKSIZE +
                                (0 *
                                   4 +
                                   i) *
                                3 +
                                axis] =
                          r0;
                        stack[stackpos +
                                STACKSIZE +
                                (1 *
                                   4 +
                                   i) *
                                3 +
                                axis] =
                          r1;
                        stack[stackpos +
                                STACKSIZE +
                                (2 *
                                   4 +
                                   i) *
                                3 +
                                axis] =
                          r2;
                        stack[stackpos +
                                STACKSIZE +
                                (3 *
                                   4 +
                                   i) *
                                3 +
                                axis] =
                          r3;
                    }
                }
                stack[stackpos +
                        48] =
                  (stack[stackpos +
                           STACKSIZE +
                           48] =
                     size);
                float vmin =
                  stack[stackpos +
                          50];
                float vmax =
                  stack[stackpos +
                          52];
                stack[stackpos +
                        STACKSIZE +
                        49] =
                  stack[stackpos +
                          49];
                stack[stackpos +
                        50] =
                  vmin;
                stack[stackpos +
                        52] =
                  (stack[stackpos +
                           STACKSIZE +
                           50] =
                     (vmin +
                        vmax) *
                       0.5F);
                stack[stackpos +
                        STACKSIZE +
                        51] =
                  stack[stackpos +
                          51];
                stack[stackpos +
                        STACKSIZE +
                        52] =
                  vmax;
            }
            stackpos +=
              STACKSIZE;
        }
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
        float u =
          state.
          getU(
            );
        float v =
          state.
          getV(
            );
        float[] bu =
          bernstein(
            u);
        float[] bdu =
          bernsteinDeriv(
            u);
        float[] bv =
          bernstein(
            v);
        float[] bdv =
          bernsteinDeriv(
            v);
        getPatchPoint(
          u,
          v,
          patches[state.
                    getPrimitiveID(
                      )],
          bu,
          bv,
          bdu,
          bdv,
          new org.sunflow.math.Point3(
            ),
          state.
            getNormal(
              ));
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
        state.
          getGeoNormal(
            ).
          set(
            state.
              getNormal(
                ));
        state.
          getUV(
            ).
          set(
            u,
            v);
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
        state.
          setBasis(
            org.sunflow.math.OrthoNormalBasis.
              makeFromW(
                state.
                  getNormal(
                    )));
    }
    public org.sunflow.core.PrimitiveList getBakingPrimitives() {
        return null;
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
      ("H4sIAAAAAAAAALV7eezk1n3f7K5Wq10duzosyYp1S66lcZczwzmrxDE5nJPk" +
       "DGd4zTCOZd7D4Tm8h65qW4BjwwEcI5ZTB0jU/OEkraHYRpGgAdoUKormQAIV" +
       "SYOmLVDLvdA0rlHrDztF3Tp95Pyu/f1++5MVbQbgG5Lv+977fr7X+z7y8bXv" +
       "lC4GfqnsudZWt9zwupqG19dW43q49dTg+phoUKIfqErXEoOAAfdelJ/6xtXv" +
       "/+ALq2vnS7cLpftFx3FDMTRcJ5irgWvFqkKUrh7e7VmqHYSla8RajEUoCg0L" +
       "IowgfIEo3XmkaVh6hthnAQIsQIAFqGABQg6pQKO7VSeyu3kL0QmDTenvlc4R" +
       "pds9OWcvLD15Yyee6Iv2XjdUgQD0cEd+zQFQRePULz1xgH2H+QTgL5WhV/7+" +
       "R6/94wulq0LpquHQOTsyYCIEgwilu2zVllQ/QBRFVYTSvY6qKrTqG6JlZAXf" +
       "Qum+wNAdMYx89UBI+c3IU/1izEPJ3SXn2PxIDl3/AJ5mqJayf3VRs0QdYH3w" +
       "EOsOYT+/DwBeMQBjvibK6n6T20zDUcLS48dbHGB8BgcEoOklWw1X7sFQtzki" +
       "uFG6b6c7S3R0iA59w9EB6UU3AqOEpUdu2mkua0+UTVFXXwxLDx+no3ZVgOpy" +
       "IYi8SVh6z3GyoiegpUeOaemIfr4z+fHPf9wZOucLnhVVtnL+7wCNHjvWaK5q" +
       "qq86srpreNfzxC+ID/7OZ8+XSoD4PceIdzT/5O++9eEPPvb67+9ofuwUmqm0" +
       "VuXwRfkr0j1//L7uc50LORt3eG5g5Mq/AXlh/tRezQupBzzvwYMe88rr+5Wv" +
       "z393+cmvqt8+X7oyKt0uu1ZkAzu6V3Ztz7BUf6A6qi+GqjIqXVYdpVvUj0qX" +
       "wDlhOOru7lTTAjUclW6zilu3u8U1EJEGushFdAmcG47m7p97YrgqzlOvVCpd" +
       "AkfpQ+B4qLT7Ff9hiYFWrq1CngFRvptDDyDVCSUg1hUURI5muQkU+DLk+vrB" +
       "tez6KhSqQaBaYihKlgqhamaoPqkGq+u5dXl/Q/2mOZ5ryblzQNTvO+7oFvCR" +
       "oWspqv+i/EqE9t762ot/eP7A8PckEZY+AEa8vjfi9XzE60dHvH44YuncuWKg" +
       "B/KRd/oE2jCBX4OId9dz9E+PP/bZpy4AQ/KS24AozwNS6OaBt3sYCUZFvJOB" +
       "OZZe/3LyKe4TlfOl8zdG0JxbcOtK3pzK495BfHvmuOec1u/Vz/z597/+Cy+5" +
       "hz50Q0jec+2TLXPXfOq4XH1XVhUQ7A67f/4J8bde/J2Xnjlfug34O4hxoQhs" +
       "EoSPx46PcYOLvrAf7nIsFwFgzfVt0cqr9mPUlXDlu8nhnULh9xTn9wIZ35nb" +
       "7HvA8eieERf/ee39Xl4+sDOQXGnHUBTh9Cdo75f/3Rv/Ay7EvR95rx6Zy2g1" +
       "fOGIt+edXS38+t5DG2B8VQV0//HL1Be/9J3P/FRhAIDi6dMGfCYvu8DLgQqB" +
       "mD/9+5t//+Y3v/Kn5w+M5lwIprtIsgw5PQCZ3y9dOQMkGO39h/yAaGEB98qt" +
       "5hnWsV3F0IzcknMr/b9Xn63+1v/8/LWdHVjgzr4ZffDtOzi8/1609Mk//Ohf" +
       "PlZ0c07OZ6tDmR2S7ULg/Yc9I74vbnM+0k/9yaO/+HviL4NgCgJYYGRqEZNK" +
       "hQxKhdKgAv/zRXn9WF01Lx4Pjhr/jf51JKt4Uf7Cn373bu67//ytgtsb05Kj" +
       "uiZF74WdeeXFEyno/qHjnj4UgxWgq78++cg16/UfgB4F0KMM5uJg6oNAk95g" +
       "GXvUFy/9h3/xLx/82B9fKJ3vl65Yrqj0xcLJSpeBdYPAAmJU6v3kh3fKTe4A" +
       "xbUCaukE+OLGIyfN/8k9y3jydPPPyyfz4tmTRnWzpsfEf25nnkAoz948phX6" +
       "3U2sr/7a02984tWn/1MhojuMAKRkiK+fMtMfafPd19789p/c/ejXijBymyQG" +
       "RZC+cjxFOpkB3ZDYFJjvOgD63hzXY+C4uAf04m6eo27JfMSoogeg7M1xt7zP" +
       "ncJ/8gDMXTnv4OT8b++w7P7DEvHXHdjLs2EfortFWuzvA7ml/eWe9NwZKxDf" +
       "sEF0jfeyNuil+940f+nPf2OXkR1P8Y4Rq5995XN/df3zr5w/kgc/fSIVPdpm" +
       "lwsXNnL3Tqx/BX7nwPHD/MjFmd/YifW+7l5C9sRBRuZ5OZwnz2KrGKL/37/+" +
       "0j/9hy99ZgfjvhvTwB5Y5fzGv/1/f3T9y9/6g1MyEjATuWJ4iuudIcV+7iGH" +
       "M/LD/2dqSS//5/99IuYVicQpgj3WXoBe+6VHuh/6dtH+cEbPWz+Wnsy1gHcf" +
       "tq191f7e+adu/1fnS5eE0jV5bzXHiVaUz5MC8N9gf4kHVnw31N+4Gtml3i8c" +
       "ZCzvO67ZI8MezyUOJQrOc+oilBzG9356rlQEuuUuOhblM3nxt3bZW376gVwX" +
       "hiNaRTsSzM2W6ujhqiAeFfd2HjoNSxdAVMpPe156oLnze4lgfv2ecG8mzKGB" +
       "9Y3rqLm379ftkkrDvX6wtgSV6Sk28PzNbYAsouChIn7v5b94hPnQ6mPvIJt8" +
       "/Jhij3f5j8jX/mDwfvnnz5cuHKjlxMLzxkYv3KiMK74KVsoOc4NKHt2ppJDf" +
       "kdmqkPAZeYB9Rl2x7FkDBcq5qHeaOYPcPzLb7gs7v2byAt03lvAsY8mLj+ws" +
       "JS9+Oi8+mhfISZPIL6W8UE7qOL/Wd8MWrfPCPIP1j59R91JebPPC23FyBu0n" +
       "0t3/h86g+VRedIqqWl78nR37jR8pe9nRPlxcXdpJ98aZ7eG9Y//8hlRmTwU/" +
       "c7oKQOJ8yfONGMTofWe9FESSYsTBgR6uHfL9mbfj+xhnP7afSez/n8LZ52/C" +
       "WX76uYMIEtiue3oEuSS5rqWKzjFWf+4dsvrI3rF/fhqrX/5RWL24icRdTvXF" +
       "Yyz94jtk6bE9Ce5L8jSW/sGPwtIlTwzl1S5oIseY+pW3ZWon7nPAVC7Wrreu" +
       "V/LrXzt92AuFR+fqKp4GHnHtEKwKLPmZ/cyAU/0AhNRn1lZrP5RfOwzzu+dp" +
       "xxglf2RGQbi/57AzwnX0F372v37hj37u6TfBvDwuXYzzORNE7SMjTqL8aeXP" +
       "vPalR+985Vs/WywsgRDpD3/a/WTe6zfOgpsXX70B6iM5VNqNfFklxCAki7Wg" +
       "qhygPWbBt4FQ+9dHG973m8N6MEL2fwQndhsIm86dCF5EUIRosZ7F+rQ/mylV" +
       "1kzXXrfea86SDF7KwzW+ZNa2EMcRagvOynPUqMySPdGa9fDQ0EZdyhqPWd1t" +
       "z/pkhJOi1Zu1N/i6g8/EXsbyXd/2ZGE5Mzhws0lD5bJaE2ylpsAZMWj6oDu7" +
       "DJVbZQgqxxAEtRr1RtmoewGb0QzG8ksmmIgmx4t0EtlzYaLgBi3wtV60bjVC" +
       "g/AW1VjlHWVsj5maaVqYGbIWnQqKzyHVpcbTY5PPbJwZV/veUJyNGnVDrG4w" +
       "MyDZxUINLDZVPXKwcQ28mRJMFTGb4yE5wO3FAJty0IpeO4vlcI0x/WVXmFMe" +
       "5dJOJ+PrKbttbdLKltfq9DBuEzNdUEbKtoabhC9MBp5o4KLoVoSVEUhihZbr" +
       "VWW4cFx8k3V7tWyLCdXNDEZr4ZpGkFmIdYRyezKYzGBW1gOb9iKbNGpK6I7F" +
       "CAsnvfWEbgJnYW1/XjPxMuOuDK+9QrLKystQF+66/d6yOh7y3pIQqlUktNRs" +
       "FjFrsik6rDnsd9dkRrQCesZ0LU9JKUeuL9WtZ4bTmjwQVcX2UI5GzVlbHbQq" +
       "yaAqNVf1zcjnO15fmkdOr0ma225CdztIdzXpWBTDe9ao0pvFG0VBgB5Zrjvn" +
       "BhJbhXnE0xt+j92gZTQVAwZ12MZg2uRHPXXGLLMxQynZSIcTBMY1wxVYnEPN" +
       "IS/izWgmYwter3e5rpmRwzGGtOwtX49quGWj5tprr0c1ym+wCOIPuPHWlSpZ" +
       "H+vb+ozzeoOl0fU8vdOPSKwa9norQsFQxGwMB/G4YlTdpSk1AM55R/RG7Yjw" +
       "NsjGHWE6vSUZimfaQgOh65UysXAq7XKzKTCK7DbheWLMenKlMePlRYNL+kxQ" +
       "73hIWtPHLlcdoYbfb3ORJS470bpDdlGU6sx7hG2qZcXx+/VIWjOJLfKM5VZj" +
       "JXYzwjcTCGZgL1ICrUvXvWQQ8QPJsF2om43L9IaobauhOCPbGTEn1x19Kc83" +
       "lASvjEq5vu6MK8lGTUxPwiPPG+tziN866xlrCZsFu6yJvc10zFhjNGRnQ6nc" +
       "NoUForHZbAMiOoX1DVYRxobFqVwzToQRukGIVdeg/dUiRIZKxMjmJGDiSrJc" +
       "eUgSBatt1GSZdhlrrwfNCaZ64wFGs+IEZll4uekGZaCxkWpwpiuxFD/fDBY4" +
       "q1TkDMuIyLTX677LczRrd8SgUgNK6PNejeUDVw8Fi+l3IVGYO21Td9E+RnWM" +
       "TqWvSKOBVZ2wxISiPHSzgBdNXWo4K3SwqivhiByOpmvUSOf1TDfQYWygfXiO" +
       "jvD2cmDXyVXXaXYnLakbJVKfJ8pZuRluwnI1wpNxlzR5HCH1rUlwJuoFEwUa" +
       "tYYtb0pNFJrMnDjUAw3zsNVgAEKKR8+4epvD5RRpm1KmLDYZB83RJozoSTUl" +
       "UXJIC5GZMPURtp3P8JYFjzv22FtmbZ1lks5UI3FuQFa04YKYOukW0lS66dgx" +
       "hTUmSRhSwxEbI4ttvzXsV6upwcPlldLynYbfacFVwLuklJ0oCMr4yGwlXbhr" +
       "YN1qmYUwrLKVY9sIOjClub61nKoJXxdoCSV1nKqWEw2YtB9ipjqwWQ+t94YK" +
       "RnobZW0u+9l4ZaadFIdXE8unWk0V4TlmRXoBzjWmnVasQ6FZz4JxEkmoH2Zd" +
       "ub9OUK25liIVOH2tEtThXjPZUFyvzLfw2jqZdtehX8ebLrxeSGsaTACUtmlp" +
       "fQnzmy0pm8K82F06tRjhjKSVYAO0qw/tmIVClXKq1aQJ9cjWUl2u0FWvVZ01" +
       "cQZodNwR6a0+RpKa5UQaiaEbFZlXQAD1OxhCeSyKzmWN2GwpMVXkNoVAUlNn" +
       "lA3aXfOTgdHWogSvaTW2UaNalJXUJJVh1wNkGhoNbzT2M1hoLWxLZN2WPG95" +
       "zUYjjqLJuEm3EqiMZgTPs/JawaeI2MNrFc+COu2F1TLFVrA0Ep6vQkZWbchO" +
       "T90wEpytuB5MbWRl2u5YtlAdq4uFMp57QUJssyltUnAFgqfismpis6EC2F4s" +
       "uJoDZoeRGm37Q5sbDZtZdRyvB8pYsGqTmSUsoGZVpZhw3VjMSdynRX5D1x2u" +
       "Z3VMD8GDAZysoglfaassN/PNdYPDWJnrj2fUCkFno/a4pW04g52kQU+FVKcy" +
       "3JZbnQ7qw6RLwibHyMhiEtSr/iKqc6vpQuDHiRSSYdvH6pOVS/eFWpur9MOa" +
       "B7lhalexBtpfcBmc0uVgqMGdUQPthdPlqrOVrU6nIRH+ltbKeKjbYxubKegk" +
       "pqGmL9QXYQYTVThooPogSCGHU/tJG0UiKmg6xBYLmJSPBps2zYeVWa+s6UJX" +
       "XkobngbRJ0AhN4MNVWyPhu1Ke4NCzXGrMW7WOxOqPZHCzDJ0do6l2NjkhKba" +
       "qyuaVlMatUgcRgjqogaIecNJFqhYE8DrB3DqB6wxNtKONpNa9GxdFQhdlNRE" +
       "QjVJcVLZSao0XZ9MhwjNLDXbwPB4YXMpNZcUH5fkMF1VOETl++1NawtN5EY4" +
       "EDkNz7D6EEq78rCGgxqQJuHYSq+3Ko2aRC/YCVJRJH6Axva66ip9DWt24lib" +
       "huVgibX5pKeRShWqUz405+v10Qgf1brQBKulQoylRral+V4qLOpqZvfnm77c" +
       "TMvtjhE5nTIsNspLjp3UOn4bn/gaDEEDRthOYQdOmvPtCK9w2wWPtDRyy0ko" +
       "i5t0CyQS9UAa1D1eh6o1M8ZZL0pHFbnZCyvthKNjrgX3Fi2zSXKw0Z912KRn" +
       "bXq8vpouhwI/CAJqNknJZrCOCaiFxYymTI1xj9igyLBTJqFmY1GGtHaZKaMD" +
       "UmbSNGl2tCE8dyG1phgphMLTVk1ItpOaiNn1YdJV6zEqq7RU1yTD6SiCwXaE" +
       "UbPGNBKQZ7H9qdCPJWxDqDI7MoVNEG6ySTs1lI7BbznUKddhnGwmkALNNxtv" +
       "BabbxbBdblQMquuOMcIJYLvRHcVZiiwxaTtxJ3XX3ghZjAfrPoe7k8DoT+FB" +
       "KBFxI1yC5E9DHVWKEXfKZzGnoQ3UJ7NhOpuEUbc5D3vOtFY14CblmnKWohlj" +
       "k55qE0PKq0ctOtVaHM1oUINXQ70Mr2saqi80csmnXtvRp/iiwWhIXGXUBUFR" +
       "qQsTK0icus3ONt1qvGa3oMFwURHleFqJylM5pfjRfI72GnbgOWJg1laVzSwQ" +
       "eF/YwnSZRIyIYjtGAnHSaBrLbBMLB9WV3C0v124T7y/mMx1OFbJBoIanDsfl" +
       "ecIkUwXtzQGKVrNsItZ6OVu3Un407DuJom05d0Pp9XWPbYpDp66NKkvLmawD" +
       "KUJoTOZEIugbtc464DTSQ7AwkdtTjKnbFS/zA33Ugd1+f1qDmqPVUpmFRi1r" +
       "WGmtRa0waVIXpOGMpQVhw0rdgSZZ8ECzqsTSACKXTAkZE6NJb7nSjYhvL/g+" +
       "r7Pt5ZrrjYRwvaLWMLpYULWGLk+2gR4TnbbYTWlNJwa4k5INCNMHVETGfrnS" +
       "H7edAQa3eDqyWy143qRgaNGoE+PyglM9b1ixy4t6hYlN0aAhKesONSbxcave" +
       "lmCSnlpdmobtaZln6tvMMmu1hpdMxmPfctu8M2DL0nreNWQLG9lzpeXFzjJZ" +
       "2LbcrPJlGmKjUWsU82Sjas3s2VocYqtpNqDHETGpbsduV0CDTm2LkhMv3g6X" +
       "TjanqATYw7AXxXEcYONIC5YSWa3Wsy2HWRRHNtub+pzNSKc37wfdamUseC7X" +
       "xgjbb0wCYF7UJHDs2liAdYsxwWQ9GVkkNxkv2vOhhg+QCZyMjU57S9r2LDDC" +
       "KlupVZpbM1wyppIljUo2CThJQhWmFW+gTk1o473yhLC5+sTiV0l1nKYrt7HG" +
       "bA3fNioyM8RhO9a2EVIbh0sHBMUmLtsCarE9rWFjc0kluoSu97d12NPdqO/r" +
       "TX9stVYutKCsZVonfDhZ6GW9C3SHIaSDKl3DjJiMUpVVrzGZDUbySK33m41J" +
       "aBlS6nZGlCVqCcq1RytWNtksVTatLs+tGSQJfD8g+aXplPtKFWsL86TL1pt9" +
       "0qVUXCfxrGN7iMAraNKZRO0610qCYShyKzzCmK2AoBmpbDrpGmlZDobCpjxy" +
       "GjwS6iTBITV4FjTDrlWrDNBGWaEEBxlV2TaCOSs+lXv15SzMlnFSbwyo6nbu" +
       "qmRNMjw32IqOt26sZzEvafVF6sSNkVHt97Bs2N2Kox5HDGamtLXJyCIrDDJg" +
       "wzCooc0qKa0r0BCrseWqjncJw5mFK5rodifVYAqWTgIueKMZA5epbk+oINPp" +
       "JsU4YYl3s2afgta6QcZirUXUTSLV9QhydSRpcUaF5HAqDkDuxMszuBc1t92t" +
       "hAyYelRPq6OxqEh1H2rTA2bdYR05HWj0eADWvcteNUwGoqj43Qo2720wNyUm" +
       "Cd3aAh/vmDiiJpukW4c5I1iKc1Tm9Kw3mBCrZRg1KvRKzfqI3MEHzSlTr8jw" +
       "kF+vBUyUYJglaW8zi6R+gCcTkUppYTBeBfaEphnVszoRxU253lzGpnhbSsCq" +
       "Pl6l27YizqaeqTNS2zDYCjpaI7hdWwANLWvzFtlLI46Ex8vENKwyWGPE/lTu" +
       "acaMGWbtMdZJNoTQLm96/mI1j00voSzcW3vDRAeZojqrtiiNtlzFBM7ZF4lR" +
       "tVNGVktxy7MteK2Y6/68NYSHZZcfotPEV2G5TQzmTFmVrRrJEdZInQ5JCuRw" +
       "LVoy6ZGehLGPkeqm2ckYMOUkznw5oNoBMQ4gxnOblp5siU6LxCgCsxYQ21g1" +
       "A6/NVTUHzoLKxKtWG1k5CWEjSBTBYoVhIKibQddkFjUsYeIBolgtFfa2ZTqU" +
       "A2iwpvWUJRy8msWCkYgdPFsQwRpvD3oYN4fcclkCqWC1XXOQbV1dUJooQeKC" +
       "WlUsl0ys8RKnJb3ZHlXMJd6JaWnZ7sNTpkZvmQ4v9uO6I8BEPwEpReJBzUql" +
       "61db7c6wum1tK7HCNOuQTHIQNt32TI4AJgIp8NBj7ApmLbWJjyqY2UG2Y21b" +
       "XpcnYCGkMhuZpwQS89BOGUeZdrjR52uX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("X9rzUOrRYzBfZcxq2plMB0uRSsRayi1Va01ynMjOtBbejqs2u8zMGItngmYv" +
       "LXmapWUZXTaTAZS2IgxCwFIdGko6niDFY8h/9s4eq91bPEE82J63tlp5xWvv" +
       "4MlZeto7/eJ3e+nYlq4jz1qPPH8/eCn12IntTwcvM/OdGvtkj54gY468s87f" +
       "iT56sy18xfvQr7z8yqvK9Fer5/deJFBh6XLoen/bUmPVOsLXnbvXHweYCgjP" +
       "guO5PUzPHX9+fCi10x8ef2An9ZvsZ9iD9/BReLYYrq6TYugbab1o/G/OeCPy" +
       "Z3nxRli6R1dDHix+FdSNHCXY7/h9Jzou6g1HR930UNf/+p28Rzkmogfym/me" +
       "oO6eiLrvVESfO0tE+SVREPyXM8Tw3/Lim0Cpkuo7QagaxWuM3iHCN98twqfA" +
       "Qe4hJP+GEP6vMxC+lRd/ARR9gBBTfSM+BvPb7wJm8a7k0+BY7sFc3hqYlwuC" +
       "ywXMg6J3WrFvtQ+dsFrKNZwQvrm7cGq+pQkuxv/BzaV4rmDz+2HpbuAuVP4y" +
       "p+j41JcJsWsoh4L9y3ch2Pfu28/Le4J9+dYEkaPA7jmj7lpeXM4j3l7MLN5H" +
       "/+4BuHNX3gW4+0t7CN/YA/fGrQF3/m3niXzngBqq/tF54sGjZPTuH6FGhRge" +
       "OUNET+QFaH975Cl78vnioXwefBfyuZrffBwcP9yTzw9vvfKfP6Pug3nxbFi6" +
       "Bix+EtkHs2tB/NFDjO9/Fxjv3TPwc+d3bXf/t8wGCk6LokDUPANtOy+qIMXJ" +
       "/XsfajHlFZHnEG7tXcAt9j1OAOcP7MF94NbAvbDL2vZt+YETJj8Xt4daAxRP" +
       "naAY5XsTg93+1/xLkmI3wjn0DIkN8+InwtJ9xn7TA7nlNRcORfahdyuyFkD/" +
       "rT2RfevWiOxYHnUyTaRXYp7tHMpifoYsuLwACfL9nq/ma6ajjY8JY/Ju54MP" +
       "Ara/tyeM7936kPCxM+rynT/nfgrABE6CiiZAeGNUODIzfOQdbbAJS1cOv1fI" +
       "N18/fOLrp90XO/LXXr16x0Ovsn+222u7/1XNZaJ0hxZZ1tHNc0fObwdq0YwC" +
       "+uXdVjqvwGOcpvije1rD0l1HL3PGz612bS0QGY+3BZN//neUzA1Ldx4hK3b3" +
       "FGdHifywdAEQ5aeBt2+SRzZH7DYUpjtrffiobRQpxn1vJ+uDJke39+fb8IpP" +
       "0fa3zEW7j9FelL/+6njy8beav7r7vEC2xCzLe7mDKF3afelQdJpvu3vypr3t" +
       "93X78Lkf3PONy8/ur5/u2TF8aKdHeHv89L38PdsLi9332W8/9Js//uuvfrPY" +
       "HfL/ATA32QYjOAAA");
}
