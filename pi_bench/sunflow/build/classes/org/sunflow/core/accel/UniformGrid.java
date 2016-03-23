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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vyQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "o8objyCSxTfWaH+YqjiErJWCuf8WQnu4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("KO4B02wdNS1eHBwL6dK9/x9CKrehO4DfZ/Zt9/+3I6TehUK6syS483gz+qTI" +
       "S6aevAXDTxfF43HlPkOLi0OapKvupXSK5x+6HZ6zuPKOU4c+ixNsj99wYHx/" +
       "yFn50mtX73nna/y/2X8rPzqIfC9TuUdPHOf0gaNT93f7oaZbpSDu3R8/8kvA" +
       "74krj118CBXYQPlfYL30wp76xbhy7Tw1sIji7zTZ+wA3p8jiyuXDu9NEUFy5" +
       "AxAVt7B/we77/thVdumUxzjUjdLuHnoz8R43OX0qsvjIXJ7XP/ognOxP7L+s" +
       "fPk1iv3w95pf2J/KVBwpL79T3MNULu8PiJadFh+Vn7lpb0d93T188fsPfOXe" +
       "F4484AN7wCd6egrb0xcfgRxs/Lg8tJj/1jv/2Y/949f+tPwY8P8Ap34Crkgx" +
       "AAA=");
}
