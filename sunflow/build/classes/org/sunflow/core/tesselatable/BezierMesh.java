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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GKTSdqUxH2Uavkg6694KajoDzlnDYOmM");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("qqys8lErQRiwpqks1xM78CRvxI27Ql2T6LHhDJLugKxNOZC+bieS4Dqx4HEN" +
       "mscwVW+0Wa6uGBZjNiBW79c0ykFrRFY1k6pVRZnyXAIREbJjHMc/8pH8MdZv" +
       "v7vHa/cWTxIPNvE5bjOveP1dPEHLTnvfX/zdXjq28evIM9cjz+EPXk49dmJr" +
       "1MFLzXwXxz7ZoyfIxkfeYufvRh+92Ua/4r3ol1959TVt8Gvw+b0XCnxSupwE" +
       "4d909ZXuHuHrzt1rkANMBYRnwfHcHqbnjj9HPpTa6Q+RP7ST+k32OuzBe/go" +
       "PE9JrOuskkR2Visa/5sz3oz8WV68mZTuMfVkGkSu1gpSX4v3O/7AiY6Lets3" +
       "W0F2qOt//W7epxwT0QP5zXy/ELEnIuLdiuizZ4kov2QKgv98hhj+a158Ayh1" +
       "rkd+nOh28Tqjc4jwrVtF+BQ42D2E7I8I4f88A+HbefGXQNEHCNt6ZK+OwfzW" +
       "LcAs3pn8LDikPZjSewPzckFwuYB5UHROK/at9qETVssHtp9Ub+4uEz3f7lQt" +
       "xv/+zaV4rmDze0npbuAufP5Sp+j41JcKq8DWDgX7V7cg2Pfv288re4J95b0J" +
       "IkeB3XNG3bW8uJxHvL2YWbyX/t0DcOeu3AK4+0t7CN/cA/fmewPu/DvOE/kO" +
       "Aj3Ro6PzxINHyYTdL87ThRgeOUNET+QFaH97Gmp78vnCoXwevAX5XM1vPg6O" +
       "H+zJ5wfvvfKfP6Puw3nxbFK6BiyeS72D2bUg/tghxg/eAsZ79wz83Pld293v" +
       "e2YDBadFUSBqnIEWzQsYpDi5f+9DLaa8IvIcwkVuAW6xJ5IDnD+wB/eB9wbu" +
       "hV3Wtm/LD5ww+ZGyOdQaoHjqBAWd71uMd3tj8+9Nil0J51pnSIzKi48kpfvs" +
       "/aYHcstrLhyK7MVbFVkToP/mnsi++d6I7FgedTJNFCwlz3YOZTE6QxaTvAAJ" +
       "8v1hpIdKpB9tfEwY3K3OBx8GbH93Txjffe9DwsfPqMt3AJ37KQATOElLWQCE" +
       "N0aFIzPDR9/VRpukdOXwW4Z8Y/bDJ76R2n3Xo371tat3PPSa+Ge7fbj7395c" +
       "Zkp3GKnrHt1Ed+T8dqAWwy6gX95tqQsLPPZpij+6yzUp3XX0Mmf8nLVr64LI" +
       "eLwtmPzzn6NkQVK68whZscunODtKFCWlC4AoP43DfZM8sklit7Ew21nrw0dt" +
       "o0gx7nsnWR80Obr1P9+OV3ywtr91Lt19svaS+rXXetwn3m782u7TA9VVttu8" +
       "lzuY0qXdVxBFp/n2uydv2tt+X7dTz33/nq9ffnZ//XTPjuFDOz3C2+On7/Pv" +
       "eGFS7Mzf/tZD/+TH/8Fr3yh2ifw/ePH530k4AAA=");
}
