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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaC5AcRRnu3Xvkco/cI3eXkPfjEioh7AISEQ+Ry5GQC3vJ" +
       "eZdcwQWzmZvtvZtkdmaY6b3bO4w8SisRlYoQQlQ4LQ0GU4EgSvngFYsyQIGU" +
       "RBQQAV+laKBMfIBlUPz/7pmd1+7GK72rmp7Z7v77f/Tf3/939x15m1RYJllA" +
       "NRZjYwa1Yms11iOZFk11qpJlbYa6pHxXmfTXbW9uvDRKKgfIjGHJ6pYli65T" +
       "qJqyBsh8RbOYpMnU2khpCil6TGpRc0Riiq4NkBbF6soYqiIrrFtPUezQL5kJ" +
       "0igxZiqDWUa77AEYmZ8ASeJcknhHsLk9QWpl3Rhzu8/2dO/0tGDPjMvLYqQh" +
       "sUMakeJZpqjxhGKx9pxJzjN0dWxI1VmM5lhsh7raNsGGxOqQCZY8WP/Omb3D" +
       "DdwEMyVN0xlXz+qllq6O0FSC1Lu1a1Wasa4nnyRlCVLj6cxIW8JhGgemcWDq" +
       "aOv2AunrqJbNdOpcHeaMVGnIKBAji/2DGJIpZexherjMMEIVs3XnxKDtory2" +
       "QsuQineeF99317aGh8pI/QCpV7Q+FEcGIRgwGQCD0swgNa2OVIqmBkijBpPd" +
       "R01FUpVxe6abLGVIk1gWpt8xC1ZmDWpynq6tYB5BNzMrM93Mq5fmDmX/qkir" +
       "0hDo2urqKjRch/WgYLUCgplpCfzOJinfqWgpRhYGKfI6tl0NHYB0WoayYT3P" +
       "qlyToII0CRdRJW0o3geupw1B1wodHNBkZE7RQdHWhiTvlIZoEj0y0K9HNEGv" +
       "6dwQSMJIS7AbHwlmaU5gljzz8/bGy267QVuvRUkEZE5RWUX5a4BoQYCol6ap" +
       "SWEdCMLalYn9Uutje6KEQOeWQGfR57ufOH3FqgXHnhZ95hbos2lwB5VZUj44" +
       "OOOFeZ0rLi1DMaoM3VJw8n2a81XWY7e05wxAmNb8iNgYcxqP9R6/9qbD9GSU" +
       "VHeRSllXsxnwo0ZZzxiKSs2rqEZNidFUF5lOtVQnb+8i0+A7oWhU1G5Kpy3K" +
       "uki5yqsqdf4bTJSGIdBE1fCtaGnd+TYkNsy/cwYhpA4e8lF46on4429G+uLD" +
       "eobGJVnSFE2P95g66m/FAXEGwbbDcSurpVV9NG6Zclw3h/K/Zd1EMpmq8S2a" +
       "ktbNzFWmkoqhcxlTM2wOtZk5GomAoecFl7kKK2S9rqaomZT3ZdesPf1A8lnh" +
       "Quj2th0YWQK8YjavGPKKcV4xDy8SiXAWzchTzCPMwk5YzwCotSv6Pr5h+54l" +
       "ZeBAxmg5mBC7LvEFlk530TtInZSPNtWNL379wiejpDxBmiSZZSUV40SHOQQI" +
       "JO+0F2ntIIQcF/kXeZAfQ5apyzQFwFMsAtijVOkj1MR6Rpo9IzhxCVdgvHhU" +
       "KCg/OXZg9Ob+Gy+Ikqgf7JFlBeAUkvcgROehuC24yAuNW7/7zXeO7t+lu8vd" +
       "Fz2coBeiRB2WBJ0gaJ6kvHKR9HDysV1t3OzTAY6ZBMsHkG5BkIcPTdodZEZd" +
       "qkBhdA5JxSbHxtVs2NRH3RrunY38uxncogaXVys8s+z1xt/Y2mpgOUt4M/pZ" +
       "QAuO/B/pM+55+fk/foCb2wkS9Z7o3kdZuweYcLAmDkGNrttuNimFfq8d6Lnj" +
       "zrd3b+U+Cz2WFmLYhmUnABJMIZj5009f/8obrx98Mer6OYPInB2EBCeXVxLr" +
       "SXUJJYHbclceADYVUAC9pm2LBv6ppBVpUKW4sN6rX3bhw2/d1iD8QIUax41W" +
       "nX0At/6cNeSmZ7e9u4APE5ExsLo2c7sJtJ7pjtxhmtIYypG7+cT8Lz4l3QO4" +
       "D1hrKeOUwyfhNiB80lZz/S/g5cWBtkuwWGZ5nd+/vjwJUFLe++Kpuv5Tj5/m" +
       "0vozKO9cd0tGu3AvLJbnYPhZQXBaL1nD0O/iYxuva1CPnYERB2BEwDbL2mQC" +
       "KuZ8nmH3rpj2ix8+2br9hTISXUeqVV1KrZP4IiPTwbupNQyAmjM+eoWY3NEq" +
       "KBq4qiSkfKgCDbyw8NStzRiMG3v8e7O+c9mhide5lxlijLmcvhYx3oeqPA93" +
       "F/bhn17ys0Nf2D8qIvmK4mgWoJv9z03q4C2/+UfI5BzHCmQZAfqB+JG753Re" +
       "fpLTu4CC1G25cFwCUHZpLzqc+Xt0SeWPomTaAGmQ7by3X1KzuEwHINeznGQY" +
       "cmNfuz9vE0lKex4w5wXBzMM2CGVuPIRv7I3fdQH0qsUpnOtMt/P2oleE8I8u" +
       "TnIuL1dicb4DFtMMU4G9EQ2gRU2JQRmJajl/OMWQ1ZcdtCD0KRlAuhE72buo" +
       "Z7u8p63nd2L6zylAIPq13Bf/fP9LO57jOFqFwXWzo7IndEIQ9oB4g5D4ffiL" +
       "wPNvfFBSrBBJU1Onnbktyqdu6L4l/TCgQHxX0xs7737zfqFA0OkCnemefbe+" +
       "H7ttnwBHkf8vDaXgXhqxBxDqYNGH0i0uxYVTrPvD0V2P3Ldrt5CqyZ/NroXN" +
       "2v0//9dzsQO/eqZAalWm2Hs4RIFIPjdq9s+NUOjKz9Q/urepbB2E5S5SldWU" +
       "67O0K+V3zmlWdtAzWe6+wnVYWzWcGEYiK2EORFDF8kNYbBDe114Uwjon7/Iy" +
       "Flejr47hV2+AZWoKWA7nWY4XYqlMkuUyeBptlo1FWIo07lwsEuEVXIyakWrD" +
       "cSqLk82GVCuUc+cdL2HHeY8y2iSVWQhPky1OUxFlRkoqU4waEp5BPaul8orM" +
       "8yqSge1VbA22wxZ6jR70vNFJqjEHnpm2IDOLqHFjSTWKUTNSATsc1fIfgOVx" +
       "kmc+YlVeV3P8Cevrv39IrP5CKBzYct93qEp+NXOcozDy+phfp/pSOoE4y4qj" +
       "pUeqiW8sff7GiaW/5ilNlWJBbAO8LnCI4KE5deSNkyfq5j/A0/5yhH0bRfyn" +
       "L+HDFd+ZCdepHovdYjb35PWb4Xj/XFs//mbkmv9p35tfO/HNpgKBXqXdkIQ5" +
       "e+opG5vr2RvCbu6lWHzOccC9haN9FD9j4GdpRZNUPlofLB6VakPiCOIaLD5r" +
       "uEliVNA5C0sk4pjaxDpVXaOY0zttYhuu6LH8KRw05kLCmmS+L13s5vPo5l6v" +
       "zbj9t99vG1ozmf031i04yw4bfy8EZ1xZ3JeDojx1y5/mbL58ePskttILA64e" +
       "HPKb3UeeuWq5fHuUH/SJpDB0QOgnavdH22qTsqyp+ePrUjH7fPZc7DmPT3CJ" +
       "TdDXSrQdxOIriEk40cIvSnQ/FN5XYEWH4dmChPx1t+Ovh0v5KxZ3CGfFYl/e" +
       "UW8NOyr+3I/FgbDn4e8vC7acGouvllDpWyXavo3FUSzuFZKU6Pvwf28a/JkM" +
       "RqibJhmhVsHTbKNdc5EI9YOSEaoYNWwWRvQcVe2Y2cPnRHxv8XxfiwgDm9RQ" +
       "lllQvUemQL3jWDyaF5fnf08E+D41BXyf9fMdL8T3uUnyXQ1Pi823pQjfn5Sc" +
       "zmLUDOPqSL+Y0UKivjAFor6ExQkv64Kz8/IUsP5liHXBCXqtBOvc2YEqLxf/" +
       "Q+F8J/keuTzHKBEnii4P5eAdeO6Ne1eIPH38cDVrUszK5he7m+E7xIO37JtI" +
       "bbr3QiflG2BkOtON81U6QlUP5zKBi/7z0DgR+Tpx3l5ruuYSUSZ8yliMNACS" +
       "HlQw+ainSqDoX7A4CcgymFXsxDCAOeUjupJyp/Gts3lQ6VMxAdGFjHMpPGlb" +
       "w/TkjVOMNKB7IPNqDvlFrzTmNIYvS7owX7bEOR5enFIULEKK2zdSiZVnwEkU" +
       "hxQr/uba870psCdfuh3gA4vFmOJdwp5hdCtKGtC1nAtSnl/wouDNn8LCmz2F" +
       "Qha3UGMJ67VgUctI7RBleDfVpaW4yT0GjNT9PwyYY6TGcweGh7ezQzfp4vZX" +
       "fmCivmrWxJaXxObKuaGthaQ4nVVV7/Gi57vSMGla4bLXisNGflgTmc9Ia+E7" +
       "OViT/I0iR+aJ3osYaQj2hhWKL2+3paCNpxvDsyT+5e20nJEy6ISf5xqOyze4" +
       "OxFxyJqLeEDNth/325azmT1P4r1xwc0B/0cGJ5HPin9lSMpHJzZsvOH0B+8V" +
       "Nz6yKo3zKFIDe1Jx+ZTfDCwuOpozVuX6FWdmPDh9mQPSjUJg1+nnehAQ14mB" +
       "Ez4ncB1iteVvRV45eNnjP95TeQL24FtJRIId29bwcXTOyEL02JoIH/jBxonf" +
       "07Sv+NLY5avSf36VH/gTsW+bV7x/Uh644+WuB3e+ewW/Oa9Q0P35OfmVY1ov" +
       "lUdM3+nhDPRFCf+lgdvBNl9dvhbvBwHVwgen4VvVanAWavLjHRymDjZqbo2z" +
       "CfTtn7KGESBwa+ypw3KbCC5offC/ZKLbMJxz5X6DL8Zk0fQ28mH+iV/t/wHO" +
       "Sobq0yQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Cjj6Px1PLpWKmw8VTZ4pyufz4m8cue8V1zdiOGcf+u9fwt8leP1FfuWd5S/2" +
       "M+xD9OE0/97jed6FM9GBnd5as2PfsGA4ig/TG+SVh761/dy3f3WfupxX4zli" +
       "8MlXf/Ivr3/q1YNTCeNzN+Rsp9vsk8ZCTvfnRStH98ytRiladP7rl1/5zX/y" +
       "yif2qB46m/60YXb/q3/0f79+/bN/8nsXzMV3wNR2H7fzEsuLD+/FSdzUS/7W" +
       "7euQv4kO81u6YLiVa2OX3/XP4Zm8A3iWbw9PdhGe1W3ieQFeDx7iefAmeF5+" +
       "O3judY9UHxSEj8JJ/4ZU6tg82MMZ5xTyj9wm8qfh9dAh8oduglx/O8jvkp3I" +
       "Vo9Rv+c0agumyNepvB4ugygnPYfZuE3MT8Dr4UPMD98Es/d2MF+GKakZQAd8" +
       "4ebhoZhk997+2q889/sfe+25/1TMU3cbAQyPTX99wTLrVJvvvf6t73zj/ie/" +
       "VORyd8pSsA+U59enNy4/z6wqC8D3nZXC1VtJoSCNz+Y8V843CEvDv9LygYqU" +
       "LQiLmfpoPfLX22HBdv942r50uBAoTCIvPnqk7Y9drO2D/PaHoJ41w5bMY0s1" +
       "gb3er9kKv8/c9HiIg327IyveJ1v5ZAmXzo4N8rztqG6/bjGc68fbFrAyvQGs" +
       "X3r/zY1rWOj4ZGr/nY//9ydmP6J/5DYWLE+fs73zXf7T4eu/132f8rMHpTuO" +
       "J/ob9jTONnrp7PR+rw/CyLdnZyb5J/fyL+S3F35evFCI+Bap5qdvUfezefHT" +
       "uVfmot5r5hbknzmV0N1gGbsjy/iFW1lGXnx8bxZ58Q+OTSK90STyx5/Ii0/c" +
       "qOP8+Sf3wxat8+JTt4D+2i3qfjkvPpcXP7dHcgvaf5SWzoVS/zZD6Qfg9chh" +
       "THjkJqH0C28nlF6JnRSYyX74bvFyfz/I3Q9m6ecnql95B5B++TaQFnnIF8+B" +
       "+so7AOpf3Aao7CJQv36boAh4PXoI6tGbgPrq20pGDDsW9mq9CNdvvQO4/vXt" +
       "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" +
       "zU6k3VHljQcSmfyLa7A/WpUfTgaFYO6/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("hdAezou7oZqNo6b5i4NjIV26568gpGIrugn5fWbfdv9/O0KiLxTSnQXBnccb" +
       "0idFVjD15C0YfjovHg9L961BmB/ZhLn+XkqneP6B2+E5DUvvOnUEND/P9vgN" +
       "B8n3h5+VL7129e53vzb/t/sv50cHlO9hS3drkWmePn506v4u1weaUQjinv1h" +
       "JLcA/L6w9NjFR1KhDxT/OdZLL+ypXwxL185TQ4/I/06TfQByc4osLF05vDtN" +
       "hISlOyBRfou6F+zA7w9hpZdORYxD2yj87qG3Eu9xk9NnJPMPzcU5/qOPwtH+" +
       "JP/Lypdf648++mbtC/szmoopZcW3irvZ0pX9cdGi0/zD8jM37e2or7t6L37/" +
       "ga/c88JRBHxgD/jETk9he/riA5Ftyw2LI4zZb7z7n//wP37tj4sPAv8PulOh" +
       "lmAxAAA=");
}
