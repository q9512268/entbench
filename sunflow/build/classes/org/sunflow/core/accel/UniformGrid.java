package org.sunflow.core.accel;
public final class UniformGrid implements org.sunflow.core.AccelerationStructure {
    private int nx;
    private int ny;
    private int nz;
    private org.sunflow.core.PrimitiveList primitives;
    private org.sunflow.math.BoundingBox bounds;
    private int[][] cells;
    private float voxelwx;
    private float voxelwy;
    private float voxelwz;
    private float invVoxelwx;
    private float invVoxelwy;
    private float invVoxelwz;
    public UniformGrid() { super();
                           nx = (ny = (nz = 0));
                           bounds = null;
                           cells = null;
                           voxelwx = (voxelwy = (voxelwz = 0));
                           invVoxelwx = (invVoxelwy = (invVoxelwz = 0)); }
    public void build(org.sunflow.core.PrimitiveList primitives) { org.sunflow.system.Timer t =
                                                                     new org.sunflow.system.Timer(
                                                                     );
                                                                   t.
                                                                     start(
                                                                       );
                                                                   this.
                                                                     primitives =
                                                                     primitives;
                                                                   int n =
                                                                     primitives.
                                                                     getNumPrimitives(
                                                                       );
                                                                   bounds =
                                                                     primitives.
                                                                       getWorldBounds(
                                                                         null);
                                                                   bounds.
                                                                     enlargeUlps(
                                                                       );
                                                                   org.sunflow.math.Vector3 w =
                                                                     bounds.
                                                                     getExtents(
                                                                       );
                                                                   double s =
                                                                     java.lang.Math.
                                                                     pow(
                                                                       w.
                                                                         x *
                                                                         w.
                                                                           y *
                                                                         w.
                                                                           z /
                                                                         n,
                                                                       1 /
                                                                         3.0);
                                                                   nx =
                                                                     org.sunflow.math.MathUtils.
                                                                       clamp(
                                                                         (int)
                                                                           (w.
                                                                              x /
                                                                              s +
                                                                              0.5),
                                                                         1,
                                                                         128);
                                                                   ny =
                                                                     org.sunflow.math.MathUtils.
                                                                       clamp(
                                                                         (int)
                                                                           (w.
                                                                              y /
                                                                              s +
                                                                              0.5),
                                                                         1,
                                                                         128);
                                                                   nz =
                                                                     org.sunflow.math.MathUtils.
                                                                       clamp(
                                                                         (int)
                                                                           (w.
                                                                              z /
                                                                              s +
                                                                              0.5),
                                                                         1,
                                                                         128);
                                                                   voxelwx =
                                                                     w.
                                                                       x /
                                                                       nx;
                                                                   voxelwy =
                                                                     w.
                                                                       y /
                                                                       ny;
                                                                   voxelwz =
                                                                     w.
                                                                       z /
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
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "Creating grid: %dx%dx%d ...",
                                                                       nx,
                                                                       ny,
                                                                       nz);
                                                                   org.sunflow.util.IntArray[] buildCells =
                                                                     new org.sunflow.util.IntArray[nx *
                                                                                                     ny *
                                                                                                     nz];
                                                                   int[] imin =
                                                                     new int[3];
                                                                   int[] imax =
                                                                     new int[3];
                                                                   int numCellsPerObject =
                                                                     0;
                                                                   for (int i =
                                                                          0;
                                                                        i <
                                                                          n;
                                                                        i++) {
                                                                       getGridIndex(
                                                                         primitives.
                                                                           getPrimitiveBound(
                                                                             i,
                                                                             0),
                                                                         primitives.
                                                                           getPrimitiveBound(
                                                                             i,
                                                                             2),
                                                                         primitives.
                                                                           getPrimitiveBound(
                                                                             i,
                                                                             4),
                                                                         imin);
                                                                       getGridIndex(
                                                                         primitives.
                                                                           getPrimitiveBound(
                                                                             i,
                                                                             1),
                                                                         primitives.
                                                                           getPrimitiveBound(
                                                                             i,
                                                                             3),
                                                                         primitives.
                                                                           getPrimitiveBound(
                                                                             i,
                                                                             5),
                                                                         imax);
                                                                       for (int ix =
                                                                              imin[0];
                                                                            ix <=
                                                                              imax[0];
                                                                            ix++) {
                                                                           for (int iy =
                                                                                  imin[1];
                                                                                iy <=
                                                                                  imax[1];
                                                                                iy++) {
                                                                               for (int iz =
                                                                                      imin[2];
                                                                                    iz <=
                                                                                      imax[2];
                                                                                    iz++) {
                                                                                   int idx =
                                                                                     ix +
                                                                                     nx *
                                                                                     iy +
                                                                                     nx *
                                                                                     ny *
                                                                                     iz;
                                                                                   if (buildCells[idx] ==
                                                                                         null)
                                                                                       buildCells[idx] =
                                                                                         new org.sunflow.util.IntArray(
                                                                                           );
                                                                                   buildCells[idx].
                                                                                     add(
                                                                                       i);
                                                                                   numCellsPerObject++;
                                                                               }
                                                                           }
                                                                       }
                                                                   }
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "Building cells ...");
                                                                   int numEmpty =
                                                                     0;
                                                                   int numInFull =
                                                                     0;
                                                                   cells =
                                                                     (new int[nx *
                                                                                ny *
                                                                                nz][]);
                                                                   int i =
                                                                     0;
                                                                   for (org.sunflow.util.IntArray cell
                                                                         :
                                                                         buildCells) {
                                                                       if (cell !=
                                                                             null) {
                                                                           if (cell.
                                                                                 getSize(
                                                                                   ) ==
                                                                                 0) {
                                                                               numEmpty++;
                                                                               cell =
                                                                                 null;
                                                                           }
                                                                           else {
                                                                               cells[i] =
                                                                                 cell.
                                                                                   trim(
                                                                                     );
                                                                               numInFull +=
                                                                                 cell.
                                                                                   getSize(
                                                                                     );
                                                                           }
                                                                       }
                                                                       else
                                                                           numEmpty++;
                                                                       i++;
                                                                   }
                                                                   t.
                                                                     end(
                                                                       );
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "Uniform grid statistics:");
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Grid cells:          %d",
                                                                       cells.
                                                                         length);
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Used cells:          %d",
                                                                       cells.
                                                                         length -
                                                                         numEmpty);
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Empty cells:         %d",
                                                                       numEmpty);
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Occupancy:           %.2f%%",
                                                                       100.0 *
                                                                         (cells.
                                                                            length -
                                                                            numEmpty) /
                                                                         cells.
                                                                           length);
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Objects/Cell:        %.2f",
                                                                       (double)
                                                                         numInFull /
                                                                         (double)
                                                                           cells.
                                                                             length);
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Objects/Used Cell:   %.2f",
                                                                       (double)
                                                                         numInFull /
                                                                         (double)
                                                                           (cells.
                                                                              length -
                                                                              numEmpty));
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Cells/Object:        %.2f",
                                                                       (double)
                                                                         numCellsPerObject /
                                                                         (double)
                                                                           n);
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Build time:          %s",
                                                                       t.
                                                                         toString(
                                                                           ));
    }
    public void intersect(org.sunflow.core.Ray r,
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
        float dirX =
          r.
            dx;
        float invDirX =
          1 /
          dirX;
        float t1;
        float t2;
        t1 =
          (bounds.
             getMinimum(
               ).
             x -
             orgX) *
            invDirX;
        t2 =
          (bounds.
             getMaximum(
               ).
             x -
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
              intervalMax)
            return;
        float orgY =
          r.
            oy;
        float dirY =
          r.
            dy;
        float invDirY =
          1 /
          dirY;
        t1 =
          (bounds.
             getMinimum(
               ).
             y -
             orgY) *
            invDirY;
        t2 =
          (bounds.
             getMaximum(
               ).
             y -
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
              intervalMax)
            return;
        float orgZ =
          r.
            oz;
        float dirZ =
          r.
            dz;
        float invDirZ =
          1 /
          dirZ;
        t1 =
          (bounds.
             getMinimum(
               ).
             z -
             orgZ) *
            invDirZ;
        t2 =
          (bounds.
             getMaximum(
               ).
             z -
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
              intervalMax)
            return;
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
            ((orgX -
                bounds.
                  getMinimum(
                    ).
                  x) *
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
                       voxelwx +
                       bounds.
                         getMinimum(
                           ).
                         x -
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
                       voxelwx +
                       bounds.
                         getMinimum(
                           ).
                         x -
                       orgX) *
                    invDirX;
            }
        indxY =
          (int)
            ((orgY -
                bounds.
                  getMinimum(
                    ).
                  y) *
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
                       voxelwy +
                       bounds.
                         getMinimum(
                           ).
                         y -
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
                       voxelwy +
                       bounds.
                         getMinimum(
                           ).
                         y -
                       orgY) *
                    invDirY;
            }
        indxZ =
          (int)
            ((orgZ -
                bounds.
                  getMinimum(
                    ).
                  z) *
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
                       voxelwz +
                       bounds.
                         getMinimum(
                           ).
                         z -
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
                       voxelwz +
                       bounds.
                         getMinimum(
                           ).
                         z -
                       orgZ) *
                    invDirZ;
            }
        int cellstepX =
          stepX;
        int cellstepY =
          stepY *
          nx;
        int cellstepZ =
          stepZ *
          ny *
          nx;
        int cell =
          indxX +
          indxY *
          nx +
          indxZ *
          ny *
          nx;
        for (;
             ;
             ) {
            if (tnextX <
                  tnextY &&
                  tnextX <
                  tnextZ) {
                if (cells[cell] !=
                      null) {
                    for (int i
                          :
                          cells[cell])
                        primitives.
                          intersectPrimitive(
                            r,
                            i,
                            state);
                    if (state.
                          hit(
                            ) &&
                          (r.
                             getMax(
                               ) <
                             tnextX &&
                             r.
                             getMax(
                               ) <
                             intervalMax))
                        return;
                }
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
                cell +=
                  cellstepX;
            }
            else
                if (tnextY <
                      tnextZ) {
                    if (cells[cell] !=
                          null) {
                        for (int i
                              :
                              cells[cell])
                            primitives.
                              intersectPrimitive(
                                r,
                                i,
                                state);
                        if (state.
                              hit(
                                ) &&
                              (r.
                                 getMax(
                                   ) <
                                 tnextY &&
                                 r.
                                 getMax(
                                   ) <
                                 intervalMax))
                            return;
                    }
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
                    cell +=
                      cellstepY;
                }
                else {
                    if (cells[cell] !=
                          null) {
                        for (int i
                              :
                              cells[cell])
                            primitives.
                              intersectPrimitive(
                                r,
                                i,
                                state);
                        if (state.
                              hit(
                                ) &&
                              (r.
                                 getMax(
                                   ) <
                                 tnextZ &&
                                 r.
                                 getMax(
                                   ) <
                                 intervalMax))
                            return;
                    }
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
                    cell +=
                      cellstepZ;
                }
        }
    }
    private void getGridIndex(float x, float y,
                              float z,
                              int[] i) { i[0] =
                                           org.sunflow.math.MathUtils.
                                             clamp(
                                               (int)
                                                 ((x -
                                                     bounds.
                                                       getMinimum(
                                                         ).
                                                       x) *
                                                    invVoxelwx),
                                               0,
                                               nx -
                                                 1);
                                         i[1] =
                                           org.sunflow.math.MathUtils.
                                             clamp(
                                               (int)
                                                 ((y -
                                                     bounds.
                                                       getMinimum(
                                                         ).
                                                       y) *
                                                    invVoxelwy),
                                               0,
                                               ny -
                                                 1);
                                         i[2] =
                                           org.sunflow.math.MathUtils.
                                             clamp(
                                               (int)
                                                 ((z -
                                                     bounds.
                                                       getMinimum(
                                                         ).
                                                       z) *
                                                    invVoxelwz),
                                               0,
                                               nz -
                                                 1);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7f219yMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "kC7c//8hpGI7uQ34fW7Xdvd/L0Lqniuk");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("SwXBpaNN5eNiWzD19F0YfjYvnoxLD+hqnB/FJFxlJ6UTPH/PvfCcxqV3nDja" +
       "mZ9Te/K2Q+O7g87yF167fvWdr83+/e6L+OFh5Pvp0lUtse2Tx4pO3N/nh6pm" +
       "FIK4f3fIyC8AvycuPXH+UVNgA8V/jvXCizvql+LSjbPUwCLyv5Nk7wPcnCCL" +
       "S1cO7k4SwXHpIiDKb8v+Obvou8NV6YUTHuNANwq7e+TNxHvU5OTZx/xjcXFm" +
       "//DDbrI7tX9L/uJr5PDD32l8bnf2UrbFbfG94SpdurI7Blp0mn8cfu6OvR32" +
       "dd/gpe8+9KX7Xzz0gA/tAB/r6Qlsz55/0LHn+HFxNHH7a+/8pR/4F6/9SbGp" +
       "/38BH+n8ikwxAAA=");
}
