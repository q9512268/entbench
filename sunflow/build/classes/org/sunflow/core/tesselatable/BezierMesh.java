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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17e8zk1nXf7LdarXb12NXDkqxYb8m1NO5yhvPgTBUrGQ45" +
       "T5LDIWfI4dixzOfwTQ7fM67qWEBiwwEcI5ZTB0jU/OEkraHYRtGgAdq0Korm" +
       "gQQqkgZNW6CW+0LTuEatP+wUVev0kvO99ttvP1mV3A8fLy/vPffe8zvn3HPP" +
       "Je+8+p3ShTAolX3P3qxsL7qmZtE1025ciza+Gl4bEQ1aDEJV6dpiGM5A2Qvy" +
       "E9+48v23vqBf3SvduizdK7quF4mR4bkho4aenagKUbpyVIrbqhNGpauEKSYi" +
       "FEeGDRFGGD1HlG4/1jQqPUUcsAABFiDAAlSwAHWOqECjO1U3drp5C9GNwnXp" +
       "b5XOEaVbfTlnLyo9fn0nvhiIzn43dIEA9HBb/swBUEXjLCg9doh9h/kGwF8q" +
       "Qy//7Y9f/fvnS1eWpSuGy+bsyICJCAyyLN3hqI6kBmFHUVRlWbrbVVWFVQND" +
       "tI1twfeydE9orFwxigP1UEh5YeyrQTHmkeTukHNsQSxHXnAITzNUWzl4uqDZ" +
       "4gpgvf8I6w5hLy8HAC8bgLFAE2X1oMktluEqUenRky0OMT41BgSg6UVHjXTv" +
       "cKhbXBEUlO7Z6c4W3RXERoHhrgDpBS8Go0Slh27aaS5rX5QtcaW+EJUePElH" +
       "76oA1aVCEHmTqPS+k2RFT0BLD53Q0jH9fIf68c9/0h24ewXPiirbOf+3gUaP" +
       "nGjEqJoaqK6s7hre8Szxi+L9v/PZvVIJEL/vBPGO5h/+zTd/8sOPvPb7O5of" +
       "O4VmIpmqHL0gf0W6648/0H2mfT5n4zbfC41c+dchL8yf3q95LvPBzLv/sMe8" +
       "8tpB5WvM7wo//VX123uly8PSrbJnxw6wo7tlz/ENWw36qqsGYqQqw9Il1VW6" +
       "Rf2wdBHkCcNVd6UTTQvVaFi6xS6KbvWKZyAiDXSRi+giyBuu5h3kfTHSi3zm" +
       "l0qli+AqPQ+uB0q7v+IelWRI9xwVEmXRNVwPogMvx58r1FVEKFJDkFdAre9B" +
       "YexqtpdCYSBDXrA6fJa9QM0pQ9UWI1GyVQhVt4YakGqoX8uNzf//M0yWo72a" +
       "njsHFPGBk27ABjNo4NmKGrwgvxyj+Jtfe+EP9w6nxb6cotKHwIjX9ke8lo94" +
       "7fiI145GLJ07Vwx0Xz7yTttAVxaY9cAf3vEM+1OjT3z2ifPAzPz0FiDoPUAK" +
       "3dwtd4/8xLDwhjIw1tJrX04/zX2qslfau96/5tyCost5czr3iofe76mT8+q0" +
       "fq985s+///VffNE7mmHXOez9iX9jy3ziPnFSroEnqwpwhUfdP/uY+Fsv/M6L" +
       "T+2VbgHeAHjASAQWC5zLIyfHuG4CP3fgDHMsFwBgzQsc0c6rDjzY5UgPvPSo" +
       "pFD4XUX+biDj23OLfh+4Ht438eKe197r5+l9OwPJlXYCReFsP8L6v/JvXv9v" +
       "tULcB375yrGVjlWj5475gryzK8Wsv/vIBmaBqgK6f/9l+otf+s5nPloYAKB4" +
       "8rQBn8rTLvABQIVAzD/z++t/+8Y3v/Kne4dGcy4Ci2Es2YacHYLMy0uXzwAJ" +
       "RvvgET/Al9hgouVW89TcdTzF0IzcknMr/d9Xnq7+1n///NWdHdig5MCMPvz2" +
       "HRyVvx8t/fQffvwvHym6OSfna9mRzI7Idg7y3qOeO0EgbnI+sk//ycO/9Hvi" +
       "rwBXC9xbaGzVwmOVChmUCqVBBf5ni/TaibpqnjwaHjf+6+fXsZjjBfkLf/rd" +
       "O7nv/pM3C26vD1qO65oU/ed25pUnj2Wg+wdOzvSBGOqArv4a9bGr9mtvgR6X" +
       "oEcZrNThJACOJrvOMvapL1z8d//sn9//iT8+X9rrlS7bnqj0xGKSlS4B6waO" +
       "BfiozP+Jn9wpN70NJFcLqKUbwBcFD91o/o/vW8bjp5t/nj6eJ0/faFQ3a3pC" +
       "/Od25gmE8vTNfVqh392y+8qvP/n6p1558j8UIrrNCEHA1glWp8QBx9p899U3" +
       "vv0ndz78tcKN3CKJYeGkL58MoG6Mj64LewrMdxwCfX+O6xFwXdgHemG3Cr7w" +
       "o1ieZiqgjw5WwB/1EDtz+IlDqHfkyEBm77d3SHf3qPTR94gPPw+sA4jtFhF2" +
       "cADzR9l9PgufOWNvExgO8MzJfjwIvXjPG9Yv//lv7mK9k8HjCWL1sy9/7q+u" +
       "ff7lvWMR9pM3BLnH2+yi7MK+7twJ/a/A3zlw/SC/cmHnBTuh39PdD/UeO4z1" +
       "fD+H8/hZbBVD9P7r11/8R3/3xc/sYNxzfYCJg/3Tb/7r//NH1778rT84JZoB" +
       "q5gnRqdM2zOk2Mtn19Fq/uD/mtjSS//xf97gL4sg5BTBnmi/hF795Ye6z3+7" +
       "aH8UDeStH8lujNOAZzhqC3/V+d7eE7f+i73SxWXpqry/T+REO87X2CWY++HB" +
       "5hHsJa+rv36fswvqnzuMdj5wUrPHhj0ZhxxJFORz6sINHa0NvexcqXCSws6z" +
       "FulTefLXdpFfnv1QrgvDFe2iHQnWdVt1V5FeEA+Lst38nUSl88Cj5Vnczw41" +
       "t7cfRObP74v2V9EcGtg5ea6a+4KDul1AanjXDnetoDI7xQaevbkNkIUHPVLE" +
       "7730Fw/Nntc/8Q4i0UdPKPZkl3+PfPUP+h+Uf2GvdP5QLTdsaa9v9Nz1yrgc" +
       "qGAP7s6uU8nDO5UU8ju20hUSPiOGcM6oKzZUJlCgnIt6p5kzyINjK/WBsPPn" +
       "WZ6gB8YSnWUsefKxnaXkyU/lycfzpHOjSeSPUp4oN+o4f17thi1a54l1Buuf" +
       "PKPuxTzZ5Im/4+QM2k9lu/vzZ9B8Ok/aRRWcJ39jx37jh4p8drQPFk8Xd9K9" +
       "ft17cP86yF8XBu2r4GdPVwEIui/6gZEAH30wWS+GsaQYSXioh6tHfH/m7fg+" +
       "wdmPHUQhB/dTOPv8TTjLs5879CCh43mne5CLkufZquieYPXn3yGrD+1fB/nT" +
       "WP3yD8PqhXUs7uKxL55g6ZfeIUuP7EvwQJKnsfR3fhiWLvpiJOs7p9k5wdSv" +
       "vi1TO3GfA6ZyAb6GXKvkz79++rDnixmdq6t4z3hsakdgR2HLTx1EBpwahMCl" +
       "PmXayIErv3rk5ndv6k4wSv7QjAJ3f9dRZ4Tnrp77uf/8hT/6+SffAOvyqHQh" +
       "yddM4LWPjUjF+XvQn331Sw/f/vK3fq7YlAIh0m9t/2nhn75xFtw8+ep1UB/K" +
       "obJeHMgqIYYRWewjVeUQ7QkLvgW42v93tNE92aAeDjsHf0RV7DY684xx49oi" +
       "hmJUo1fbZDXppnSLk3pM2WJQvDlNtzVBHqxGeo0gt4mkYvJ2gmGTdpbV+4PN" +
       "tG9ZnickHcarsvbKa0/LwxU3bgosNsO5Qbs/bfm4ELFDcZ66/TnusbPxeNRI" +
       "ysiytnSWNXlANFGJkirbCgRpNQ2qQeAfZOiUn1hbbDTqtzmhl4XbNcVXZ30y" +
       "20iM51kqR/TDKEFjVtrADBQgenO8JtIm07LwVLDEtMxLhCd7/LrLx9OouxYz" +
       "lqH8SFizOj3EZxOfkauMwTpNylo5Y26ZbOwOx/O9tuoNjVRALcZyzGxk+Bk1" +
       "IduRR5HUUNSXPbyMrwwW2nI1rseOy0nfwcNydU6r9aaNbvyZZLe44bTGzqiu" +
       "36tYGTOsDnpCVFlajcxuTgIhHK+3hO/ri2Uy78LpkLOEZDOcrCB50GxvEYFs" +
       "E50hb/AUXnUXWBZgEldRllPHW89UTYpIn7WDLuLwNs6MTEEVLKHpVWALn3jV" +
       "jl9vVgidJxOvsW5yLL0NOX1mJbbupZjgMLBkTPpL3PPjhiUMtpPKnLRDeGZt" +
       "WSwMxk14SloQ7rTKY4SoVqctChuJwAqoacCbrQlTX6LkRLfwTtdez1bVgOVH" +
       "KF4hLUugbKpKz+Yca/Mw7PthuOSMGY8Gc6TV7RJtsk8tHI0A0SPTwKgZGZEU" +
       "QhsjyUbhedtmubmI2pYbI8Nxd6mZatZNea+POnNrhJANZ6zAodix+0sAKjRH" +
       "8KKD42lvzXhOhm9rS25tuenKnI7wKm5LM5PFmqKLTSnfmdb7Ikaw84BhMmo9" +
       "bZA1lkSrXQOaMdl8ys17XDYcdXvW3C6TUZ0Vx27P3/C05jUjPjCRvgP3eoag" +
       "9weT7sZYT5JUFGA3I0UYWI0+c1Z8N3QZtc0sg1ZzXE+H805rM5dDcYDUdXVC" +
       "NBBZUa1gOuu2O8B6y4bshyxV11wIk80RMjEqUdof8X3JcDwI3Y7K7IaAZwul" +
       "PyVb2wkTGlVz2eCmKp/QeByHdIXQMJ9YL2wybjpWEx3MFmM19Kdc31dnJrdm" +
       "vdRRLYurMsN2QjQXHIm2OarvqUTYdKSp19zw9thtc0FCuavuajRjUby66CYi" +
       "7irxTLaokEjIVND9zjAOV0Y8ns9aZaxlyg6Dz9r94QiPRS92GGfsmNBYnxJs" +
       "r9cnFit61a/qejOr2D5blZQ+0ZtMmpNl2rZdfias5z17bo9Cjuvb9jjauHNk" +
       "TPMsKosONPCVEYWKy7imW+OVgdplqol1sd5aX6f2GgttpFKJFwOpDTVRWxfM" +
       "VSSNUmHCUE2EGCEIOVRjJG0rgdW27O5Q2U4ZNZOALVUj3bZoKVDhEILWNhPV" +
       "oqXacRhbYtOBR466cKPOaoNIrk7oRoulEWljynxA6eXNNNLxlZTggpbWKyLK" +
       "L+veajIgqn1e7HSVOYF69YHZY2t0azHokA2FSvh+KsaTukqnasKHMr5p4eZw" +
       "YFGuO4GNdFtWuggnJRDtqWALH9rV2qi2nLgDrMtndbfsRXCyDdrpChq14OUI" +
       "S1vtOKiYMzxAu8LAXDIjskejvqTVy3KS9aPyBJsvl2McM3xnY48yNhjInLjF" +
       "OVprAh+oRNIQ2ahd0YnSoQV3121e5bVUEzeyxON1RvEcuO5PumXIpNtoVIOA" +
       "APk0rNfwen1Na3hrgYxjsxJ30SioA7OpzPh2xIr2lNYQGCa0hHaFbbKQEQ81" +
       "Zmt8MkGwsKPI2HjFClItW29a0WARJZBg6sF6g/fJ2UrRq1PHyuZsrUGvO92+" +
       "Hm1puSV0iDncK3ttrrIYOyjH+iOUlaczD4GqZKvdLvchxKlPlTXW7bdUsuGX" +
       "Wx1Na0fjhVV2ZBgiJhSVTVhSYJsOYVup0arFm0pCzqs+RqpMrA4aVafVHiuV" +
       "0UBvttZrLvTaGYN7dbQ+9xC3FWp1dd5dtOEeP2CERUzTLldWub4yrCW0Edfm" +
       "GLJtwO6wBVNVbdMMfJoM1j2VxzMqpakZhCMOyrPUdFRpZG1R4XhMjVeYOMCn" +
       "vD/VpxLKO2VMI02HF7jJgpO2m7DRpmuJLnenVjJq82vC4Hm2tmEtdp1KCerW" +
       "UW+brXlCX4xrnEUwKT63VXlouiZJiLC/3DgdGYZheka7aOomcCKLlBFoU8ds" +
       "a8sodigiSTVysMG6W6fBRTrJiVpiEV3XpWYa8CjlNpUZtR6BD1yUm3E0RM2a" +
       "iN9ScddG1bRnLJBRhmxhrrWO/RFU9/pjgRNQtGKVm5Q2qK38ObD6yFaMaV2p" +
       "lel609zGqmc1kAEeYZzd8Ju9urTocrA25g2x027jNl5B5vPmyJqFGOQTURfI" +
       "SqRnKKIgRIRs40HQDquNVRY1fbCUSJ1Jq2uwzMBv1LCs0ShDTrOaRA2yq/fg" +
       "fm0oI3QCTabNEaw58NocCOtFqg+qy+086zCzGVblR4Fvcd7IbYoCRpGj6SLW" +
       "9Gm6QvgBtc5YaStVxxrLhtOAXjVMbOh1ygSyZGrRnKlDZCfkLB2nvaFm9Ot0" +
       "OCUsGV901n1nYCaBu+QoNa1gajkk+bHmKHqwrLmM1cqqAySbzLZIK2zlHhnE" +
       "UWV7sECCilEbGtVKY9NqCPGCaW60rDfDhRU6oLax12s1M4hs0RINZYkS1Qwb" +
       "rzbEOm6HvW4bQTQo0ZZBFKka4nfglZ0tGorQkVpVkpN70/WMSGwCsrZVaiSD" +
       "CMiNRkvOn0VrxpdahDTSjY0tNJDFEAaTmUwScqyL+mq0nZNRo9NeMRbCbkwF" +
       "q422QdoJF5AqqlJ7s+GElezhHa3WntW4ZpINFlCdq9Yrja7tdJa1Zrkjm2i5" +
       "7TU5t0LFSk3e1izXp0czCEEFxGg1surQnRo1G2oZs67XZwUqlLZ1ku17ItnU" +
       "0VbH4cMNyYwW80Zbcogl0mMREnFCk24x8cKv+m1bNTlu444rqUFDyy2pg7u4" +
       "1PG+qjijbLHJXBKTwnYv7uFVdqK0Ost+ZV0VpGW3q4FIDG6UgTccbharptaB" +
       "G3ZvA/eayzpNzZexMhyjXpjVeMoLFbgZTtdMu4+EdqjPe+5w0fO32zFPT6rk" +
       "olz2ErdNysulbUHJsM/DXhB63SXX3sQQWmnFKpkQfLgw+VTO2r7th20Bwqvl" +
       "oAytKg1VGyqtecMNvWnENdRNuTGj4EZ3XYfH81jiY8QSM2XdMIPMx3xZTHvL" +
       "BjRHlVmcwp1GfyjSTZ0QsE0fslBX9EctalsdmjSIKNtwmtVQ39J7/jqdsts6" +
       "upq5vF9NJNocYgu8UqsFqTrPKhvEyWJs2VlRFVRZxGkZ9fhFNjW7Yre9ZlbT" +
       "MmrS8si3O1paE5C+wFVhHESpOmzMNaIR8ppG1yqQg8y9HkRFvMdIa78dL+RG" +
       "eUZE/igmmqnFkyAyGXc0fW4GfAviUGw2VjvMaDwm+UbVCmodeyHxfSHsZ/BU" +
       "M+HNHEu7M1NhF6oCpcNuLeYmNpZsR6zbxxYIw8ZOE2G0hZpsjG1F4bMBp/hL" +
       "Ag5VFlEb203EoFpg650kbg02tkr2N1LLDqbWPBKwxMbLFNlgosgRZYxhxRFL" +
       "o8Pmpo/JoifPLFzp6QFclunUE5ZNacr6GLTx7GTSpmcurHSXLCXzbcRZmCKR" +
       "Vvhg2hZFBpH4sG6iS6JbhWmhOktnNaRtIAQyaAbuRHFpfY16UVib6ZIvUvO2" +
       "sAkY12gFeCbrhJ0qirdRNK9aH494qd+TTWIxTCODV8f+ou7PcCYImqO+sHY0" +
       "qmEirUlrUEkEukcwhkDOIaFR46YzFuIrINKXdUezKHkb9Phqfb0Es0yDyDIG" +
       "O9g2inFk5VZ5EqsMSBbprAXJHPBpZOr1Bt+qgmi3TGzQjI1WnUFvPXWXnZ7a" +
       "U2yH1k2t0UBCoddoL2adSh1ZDGBYH9RMtCkLzZbbmTBCZ2tGwqCzMDfCaNsX" +
       "2YUHmfCM08pRpbHUYkSUPCZw2RoeJwNiUd9yo2qdG1Rkzt62paTnePJYGtpE" +
       "6uMRqfNce6r165M5tQGcdQaQ2uqoGNSt62WySg5kczxIGtPKwnA3toesWRnF" +
       "IVleD2c1MpQ8mYLrzdmwh3RshjMJtpGtMXElrYZ8TzXGEq+BDdp2EFbHg7HV" +
       "XopRStfXQy3ylLJKZ2wPpqssI5RFfoYx04ZdpZl+FNpq6CJZspnxG6i/7Huo" +
       "0s8kysIN2xSmVK2DL+Kh42K9tM2FMN6sUFJ5BQ2wappVV91su9p4aYMTxE7d" +
       "xGZog1tzM3gOAuoaNOhJiGkPuSSaKONxNxNxGjLxoO6JcD+os0S68kJRJj0m" +
       "tSeT+ZBlmGSqYyuhpbt00ohH6dZwzZRs9TgPnypu3YVCdTDd9ni3PrU1NLW3" +
       "ASs4mIJULd0M/CbqmTDt6UrNNKpZa9jXrF5nUi0PO2Ns4OiItxS5oVw1Nise" +
       "pTYhl9XVoNvqDtF6bSpZba1n8kJanYwW5KyBIMyGIcu9zVRY4au6NgyVztzc" +
       "CiAulR1r4QgaGw1meHPhAKdCw+Ox2sfa44xbYUsqnc4JmTFq8xXd2tRAYO/g" +
       "WG3RyrkCig7lWoclFkh3SqoNvEaVq9lYmwzNGlJOEpcYJ0ak4YbsbR25HoF9" +
       "tTPfBGtXQyoupWG2T4z1TZUP+ktx0fX1VbLUNcUyRj0R2ZAghJ/Ok1HSQaGo" +
       "MeRplN60l4aPi1jmakmM1hbGGLOY4SqNwkh3JhmmNst+22S305XpwA2sUV72" +
       "rEqzr46kngqxE6chteAt5662eJTYdcnSISGqERwly0mChzIkx+uoX5Eiezgb" +
       "MaD3dKaO+w12ayAg7Kb4shBMsI3Q4rHFgl9MYWPVR1Bzq1iZrXZXy8CjQTg/" +
       "0QzO0mCV3trQNNTKbT5uxRo2IlhV707TjbZoOO3WcpjCQV1bMFBvMu7IroVC" +
       "kuJKKk0s15o2UThNZ8jWqs5BNIPJ0QKJEY2KrJEicATHtvwVPa9stZ5WDs1e" +
       "hC25wXaZmiY0rC/gNlhmR1YnWvs6VQazlgnJSbyRoP4WX2BOWZSh8hJiuSHt" +
       "zzFSaqp+i0d8P4UwXranNtERNgZGCDDX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("rWy3XeA0oMFEXfdXCpm2u1zLoFs0yfZEvDFddzqdj+SvoP7xO3s1dnfxFvDw" +
       "8J5pI3nFq+/g7Vd22jf94u/W0okDX8felx57h374YemRG44/HX6QzE9qHJA9" +
       "fAPZ7NhX6fy75sM3O+BXfNP8yksvv6JMfq26t/8xgI5KlyLP/+u2mqj2Mb5u" +
       "333COMRUQHgaXM/sY3rm5DvgI6md/gL4Qzup3+Q8wz68B4/Dc8RIv0aKUWBk" +
       "9aLxvzrjq8af5cnrUemulQoCisBWUC92lfCg4w/c0HFRb7gr1MuOdP0v38m3" +
       "kBMiui8vzM8EdfdF1H2nIvrcWSLKH4mC4D+dIYb/kiffBEqV1MANI9UoPkXg" +
       "RwjfeLcInwAXuY+Q/BEh/B9nIHwzT/4CKPoQIaYGRnIC5rffBczie8fPgEvY" +
       "hym8NzAvFQSXCpiHCX5acmC1D9xgtbRnuFHt5tOFU/MjTbVi/LduLsVzBZvf" +
       "j0p3gulC5x9kio5P/SCQeIZyJNi/fBeCff+B/by0L9iX3hsnchzYXWfUXc2T" +
       "S7nH2/eZxTfl3z0Ed+7yuwB3b2kf4ev74F5/b8Dtve06kX/9VyM1OL5O3H+c" +
       "jN3dO/SwEMNDZ4josTwB7W+NfWVfPl88ks/970I+V/LCR8H1g335/OC9V/6z" +
       "Z9R9OE+ejkpXgcVTsXO4uhbEHz/C+MF3gfHufQM/t7dru7u/ZzZQcFokBaLm" +
       "GWhbeVIFIU4+vw+gFkte4XmO4MLvAm5x7pECnN+3D/e+9wbu+V3UdmDL991g" +
       "8oy4OdIaoHjiBophfjYx3J1/zX9nUpwoOIeeIbFBnnwkKt1jHDQ9lFtec/5I" +
       "ZM+/W5EhAP239kX2rfdGZCfiqBvDRFYX82jnSBbMGbLg8gQEyPf6geqLgXq8" +
       "8QlhUO92PfgwYPt7+8L43nvvEj5xRl1+eufcRwFMMElQ0QIIr/cKx1aGj72j" +
       "QzJR6fLR7xXyw9cP3vDbqN3veeSvvXLltgdemf/Z7qztwW9uLhGl27TYto8f" +
       "gDuWvxWoRTMK6Jd2x+H8Ao9xmuKPn1qNSnccf8wZP6fv2trAM55sCxb//Hac" +
       "zItKtx8jK07oFLnjREFUOg+I8mzoH5jksQMOu0OB2c5aHzxuG0WIcc/byfqw" +
       "yfHj/flRuuKHagfH3uLdT9VekL/+yoj65JvNX9v9vEC2xe027+U2onRx90uH" +
       "otP86NzjN+3toK9bB8+8ddc3Lj19sH+6a8fwkZ0e4+3R08/y444fFafvt7/9" +
       "wD/48d945ZvFCY//C1q8bqlBOAAA");
}
