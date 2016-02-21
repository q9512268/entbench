package org.sunflow.core.accel;
public class BoundingIntervalHierarchy implements org.sunflow.core.AccelerationStructure {
    private int[] tree;
    private int[] objects;
    private org.sunflow.core.PrimitiveList primitives;
    private org.sunflow.math.BoundingBox bounds;
    private int maxPrims;
    public BoundingIntervalHierarchy() { super();
                                         maxPrims = 2; }
    public void build(org.sunflow.core.PrimitiveList primitives) { this.primitives =
                                                                     primitives;
                                                                   int n =
                                                                     primitives.
                                                                     getNumPrimitives(
                                                                       );
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "Getting bounding box ...");
                                                                   bounds =
                                                                     primitives.
                                                                       getWorldBounds(
                                                                         null);
                                                                   objects =
                                                                     (new int[n]);
                                                                   for (int i =
                                                                          0;
                                                                        i <
                                                                          n;
                                                                        i++)
                                                                       objects[i] =
                                                                         i;
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "Creating tree ...");
                                                                   int initialSize =
                                                                     3 *
                                                                     (2 *
                                                                        6 *
                                                                        n +
                                                                        1);
                                                                   org.sunflow.util.IntArray tempTree =
                                                                     new org.sunflow.util.IntArray(
                                                                     (initialSize +
                                                                        3) /
                                                                       4);
                                                                   org.sunflow.core.accel.BoundingIntervalHierarchy.BuildStats stats =
                                                                     new org.sunflow.core.accel.BoundingIntervalHierarchy.BuildStats(
                                                                     );
                                                                   org.sunflow.system.Timer t =
                                                                     new org.sunflow.system.Timer(
                                                                     );
                                                                   t.
                                                                     start(
                                                                       );
                                                                   buildHierarchy(
                                                                     tempTree,
                                                                     objects,
                                                                     stats);
                                                                   t.
                                                                     end(
                                                                       );
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "Trimming tree ...");
                                                                   tree =
                                                                     tempTree.
                                                                       trim(
                                                                         );
                                                                   stats.
                                                                     printStats(
                                                                       );
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Creation time:  %s",
                                                                       t);
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Usage of init:  %3d%%",
                                                                       100 *
                                                                         tree.
                                                                           length /
                                                                         initialSize);
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Tree memory:    %s",
                                                                       org.sunflow.system.Memory.
                                                                         sizeof(
                                                                           tree));
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Indices memory: %s",
                                                                       org.sunflow.system.Memory.
                                                                         sizeof(
                                                                           objects));
    }
    private static class BuildStats {
        private int numNodes;
        private int numLeaves;
        private int sumObjects;
        private int minObjects;
        private int maxObjects;
        private int sumDepth;
        private int minDepth;
        private int maxDepth;
        private int numLeaves0;
        private int numLeaves1;
        private int numLeaves2;
        private int numLeaves3;
        private int numLeaves4;
        private int numLeaves4p;
        private int numBVH2;
        BuildStats() { super();
                       numNodes = (numLeaves =
                                     0);
                       sumObjects = 0;
                       minObjects = java.lang.Integer.
                                      MAX_VALUE;
                       maxObjects = java.lang.Integer.
                                      MIN_VALUE;
                       sumDepth = 0;
                       minDepth = java.lang.Integer.
                                    MAX_VALUE;
                       maxDepth = java.lang.Integer.
                                    MIN_VALUE;
                       numLeaves0 = 0;
                       numLeaves1 = 0;
                       numLeaves2 = 0;
                       numLeaves3 = 0;
                       numLeaves4 = 0;
                       numLeaves4p = 0;
                       numBVH2 = 0; }
        void updateInner() { numNodes++; }
        void updateBVH2() { numBVH2++; }
        void updateLeaf(int depth, int n) {
            numLeaves++;
            minDepth =
              java.lang.Math.
                min(
                  depth,
                  minDepth);
            maxDepth =
              java.lang.Math.
                max(
                  depth,
                  maxDepth);
            sumDepth +=
              depth;
            minObjects =
              java.lang.Math.
                min(
                  n,
                  minObjects);
            maxObjects =
              java.lang.Math.
                max(
                  n,
                  maxObjects);
            sumObjects +=
              n;
            switch (n) {
                case 0:
                    numLeaves0++;
                    break;
                case 1:
                    numLeaves1++;
                    break;
                case 2:
                    numLeaves2++;
                    break;
                case 3:
                    numLeaves3++;
                    break;
                case 4:
                    numLeaves4++;
                    break;
                default:
                    numLeaves4p++;
                    break;
            }
        }
        void printStats() { org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "Tree stats:");
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "  * Nodes:          %d",
                                numNodes);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "  * Leaves:         %d",
                                numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "  * Objects: min    %d",
                                minObjects);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "             avg    %.2f",
                                (float)
                                  sumObjects /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "           avg(n>0) %.2f",
                                (float)
                                  sumObjects /
                                  (numLeaves -
                                     numLeaves0));
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "             max    %d",
                                maxObjects);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "  * Depth:   min    %d",
                                minDepth);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "             avg    %.2f",
                                (float)
                                  sumDepth /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "             max    %d",
                                maxDepth);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "  * Leaves w/: N=0  %3d%%",
                                100 *
                                  numLeaves0 /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "               N=1  %3d%%",
                                100 *
                                  numLeaves1 /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "               N=2  %3d%%",
                                100 *
                                  numLeaves2 /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "               N=3  %3d%%",
                                100 *
                                  numLeaves3 /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "               N=4  %3d%%",
                                100 *
                                  numLeaves4 /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "               N>4  %3d%%",
                                100 *
                                  numLeaves4p /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "  * BVH2 nodes:     %d (%3d%%)",
                                numBVH2,
                                100 *
                                  numBVH2 /
                                  (numNodes +
                                     numLeaves -
                                     2 *
                                     numBVH2));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private void buildHierarchy(org.sunflow.util.IntArray tempTree,
                                int[] indices,
                                org.sunflow.core.accel.BoundingIntervalHierarchy.BuildStats stats) {
        tempTree.
          add(
            3 <<
              30);
        tempTree.
          add(
            0);
        tempTree.
          add(
            0);
        if (objects.
              length ==
              0)
            return;
        float[] gridBox =
          { bounds.
              getMinimum(
                ).
              x,
        bounds.
          getMaximum(
            ).
          x,
        bounds.
          getMinimum(
            ).
          y,
        bounds.
          getMaximum(
            ).
          y,
        bounds.
          getMinimum(
            ).
          z,
        bounds.
          getMaximum(
            ).
          z };
        float[] nodeBox =
          { bounds.
              getMinimum(
                ).
              x,
        bounds.
          getMaximum(
            ).
          x,
        bounds.
          getMinimum(
            ).
          y,
        bounds.
          getMaximum(
            ).
          y,
        bounds.
          getMinimum(
            ).
          z,
        bounds.
          getMaximum(
            ).
          z };
        subdivide(
          0,
          objects.
            length -
            1,
          tempTree,
          indices,
          gridBox,
          nodeBox,
          0,
          1,
          stats);
    }
    private void createNode(org.sunflow.util.IntArray tempTree,
                            int nodeIndex,
                            int left,
                            int right) { tempTree.
                                           set(
                                             nodeIndex +
                                               0,
                                             3 <<
                                               30 |
                                               left);
                                         tempTree.
                                           set(
                                             nodeIndex +
                                               1,
                                             right -
                                               left +
                                               1);
    }
    private void subdivide(int left, int right,
                           org.sunflow.util.IntArray tempTree,
                           int[] indices,
                           float[] gridBox,
                           float[] nodeBox,
                           int nodeIndex,
                           int depth,
                           org.sunflow.core.accel.BoundingIntervalHierarchy.BuildStats stats) {
        if (right -
              left +
              1 <=
              maxPrims ||
              depth >=
              64) {
            stats.
              updateLeaf(
                depth,
                right -
                  left +
                  1);
            createNode(
              tempTree,
              nodeIndex,
              left,
              right);
            return;
        }
        int axis =
          -1;
        int prevAxis;
        int rightOrig;
        float clipL =
          java.lang.Float.
            NaN;
        float clipR =
          java.lang.Float.
            NaN;
        float prevClip =
          java.lang.Float.
            NaN;
        float split =
          java.lang.Float.
            NaN;
        float prevSplit;
        boolean wasLeft =
          true;
        while (true) {
            prevAxis =
              axis;
            prevSplit =
              split;
            float[] d =
              { gridBox[1] -
              gridBox[0],
            gridBox[3] -
              gridBox[2],
            gridBox[5] -
              gridBox[4] };
            if (d[0] <
                  0 ||
                  d[1] <
                  0 ||
                  d[2] <
                  0)
                throw new java.lang.IllegalStateException(
                  "negative node extents");
            for (int i =
                   0;
                 i <
                   3;
                 i++) {
                if (nodeBox[2 *
                              i +
                              1] <
                      gridBox[2 *
                                i] ||
                      nodeBox[2 *
                                i] >
                      gridBox[2 *
                                i +
                                1]) {
                    org.sunflow.system.UI.
                      printError(
                        org.sunflow.system.UI.Module.
                          ACCEL,
                        ("Reached tree area in error - discarding node with: %d object" +
                         "s"),
                        right -
                          left +
                          1);
                    throw new java.lang.IllegalStateException(
                      "invalid node overlap");
                }
            }
            if (d[0] >
                  d[1] &&
                  d[0] >
                  d[2])
                axis =
                  0;
            else
                if (d[1] >
                      d[2])
                    axis =
                      1;
                else
                    axis =
                      2;
            split =
              0.5F *
                (gridBox[2 *
                           axis] +
                   gridBox[2 *
                             axis +
                             1]);
            clipL =
              java.lang.Float.
                NEGATIVE_INFINITY;
            clipR =
              java.lang.Float.
                POSITIVE_INFINITY;
            rightOrig =
              right;
            float nodeL =
              java.lang.Float.
                POSITIVE_INFINITY;
            float nodeR =
              java.lang.Float.
                NEGATIVE_INFINITY;
            for (int i =
                   left;
                 i <=
                   right;
                 ) {
                int obj =
                  indices[i];
                float minb =
                  primitives.
                  getPrimitiveBound(
                    obj,
                    2 *
                      axis +
                      0);
                float maxb =
                  primitives.
                  getPrimitiveBound(
                    obj,
                    2 *
                      axis +
                      1);
                float center =
                  (minb +
                     maxb) *
                  0.5F;
                if (center <=
                      split) {
                    i++;
                    if (clipL <
                          maxb)
                        clipL =
                          maxb;
                }
                else {
                    int t =
                      indices[i];
                    indices[i] =
                      indices[right];
                    indices[right] =
                      t;
                    right--;
                    if (clipR >
                          minb)
                        clipR =
                          minb;
                }
                if (nodeL >
                      minb)
                    nodeL =
                      minb;
                if (nodeR <
                      maxb)
                    nodeR =
                      maxb;
            }
            if (nodeL >
                  nodeBox[2 *
                            axis +
                            0] &&
                  nodeR <
                  nodeBox[2 *
                            axis +
                            1]) {
                float nodeBoxW =
                  nodeBox[2 *
                            axis +
                            1] -
                  nodeBox[2 *
                            axis +
                            0];
                float nodeNewW =
                  nodeR -
                  nodeL;
                if (1.3F *
                      nodeNewW <
                      nodeBoxW) {
                    stats.
                      updateBVH2(
                        );
                    int nextIndex =
                      tempTree.
                      getSize(
                        );
                    tempTree.
                      add(
                        0);
                    tempTree.
                      add(
                        0);
                    tempTree.
                      add(
                        0);
                    stats.
                      updateInner(
                        );
                    tempTree.
                      set(
                        nodeIndex +
                          0,
                        axis <<
                          30 |
                          1 <<
                          29 |
                          nextIndex);
                    tempTree.
                      set(
                        nodeIndex +
                          1,
                        java.lang.Float.
                          floatToRawIntBits(
                            nodeL));
                    tempTree.
                      set(
                        nodeIndex +
                          2,
                        java.lang.Float.
                          floatToRawIntBits(
                            nodeR));
                    nodeBox[2 *
                              axis +
                              0] =
                      nodeL;
                    nodeBox[2 *
                              axis +
                              1] =
                      nodeR;
                    subdivide(
                      left,
                      rightOrig,
                      tempTree,
                      indices,
                      gridBox,
                      nodeBox,
                      nextIndex,
                      depth +
                        1,
                      stats);
                    return;
                }
            }
            if (right ==
                  rightOrig) {
                if (clipL <=
                      split) {
                    gridBox[2 *
                              axis +
                              1] =
                      split;
                    prevClip =
                      clipL;
                    wasLeft =
                      true;
                    continue;
                }
                if (prevAxis ==
                      axis &&
                      prevSplit ==
                      split) {
                    stats.
                      updateLeaf(
                        depth,
                        right -
                          left +
                          1);
                    createNode(
                      tempTree,
                      nodeIndex,
                      left,
                      right);
                    return;
                }
                gridBox[2 *
                          axis +
                          1] =
                  split;
                prevClip =
                  java.lang.Float.
                    NaN;
            }
            else
                if (left >
                      right) {
                    right =
                      rightOrig;
                    if (clipR >=
                          split) {
                        gridBox[2 *
                                  axis +
                                  0] =
                          split;
                        prevClip =
                          clipR;
                        wasLeft =
                          false;
                        continue;
                    }
                    if (prevAxis ==
                          axis &&
                          prevSplit ==
                          split) {
                        stats.
                          updateLeaf(
                            depth,
                            right -
                              left +
                              1);
                        createNode(
                          tempTree,
                          nodeIndex,
                          left,
                          right);
                        return;
                    }
                    gridBox[2 *
                              axis +
                              0] =
                      split;
                    prevClip =
                      java.lang.Float.
                        NaN;
                }
                else {
                    if (prevAxis !=
                          -1 &&
                          !java.lang.Float.
                          isNaN(
                            prevClip)) {
                        int nextIndex =
                          tempTree.
                          getSize(
                            );
                        tempTree.
                          add(
                            0);
                        tempTree.
                          add(
                            0);
                        tempTree.
                          add(
                            0);
                        if (wasLeft) {
                            stats.
                              updateInner(
                                );
                            tempTree.
                              set(
                                nodeIndex +
                                  0,
                                prevAxis <<
                                  30 |
                                  nextIndex);
                            tempTree.
                              set(
                                nodeIndex +
                                  1,
                                java.lang.Float.
                                  floatToRawIntBits(
                                    prevClip));
                            tempTree.
                              set(
                                nodeIndex +
                                  2,
                                java.lang.Float.
                                  floatToRawIntBits(
                                    java.lang.Float.
                                      POSITIVE_INFINITY));
                        }
                        else {
                            stats.
                              updateInner(
                                );
                            tempTree.
                              set(
                                nodeIndex +
                                  0,
                                prevAxis <<
                                  30 |
                                  nextIndex -
                                  3);
                            tempTree.
                              set(
                                nodeIndex +
                                  1,
                                java.lang.Float.
                                  floatToRawIntBits(
                                    java.lang.Float.
                                      NEGATIVE_INFINITY));
                            tempTree.
                              set(
                                nodeIndex +
                                  2,
                                java.lang.Float.
                                  floatToRawIntBits(
                                    prevClip));
                        }
                        depth++;
                        stats.
                          updateLeaf(
                            depth,
                            0);
                        nodeIndex =
                          nextIndex;
                    }
                    break;
                }
        }
        int nextIndex =
          tempTree.
          getSize(
            );
        int nl =
          right -
          left +
          1;
        int nr =
          rightOrig -
          (right +
             1) +
          1;
        if (nl >
              0) {
            tempTree.
              add(
                0);
            tempTree.
              add(
                0);
            tempTree.
              add(
                0);
        }
        else
            nextIndex -=
              3;
        if (nr >
              0) {
            tempTree.
              add(
                0);
            tempTree.
              add(
                0);
            tempTree.
              add(
                0);
        }
        stats.
          updateInner(
            );
        tempTree.
          set(
            nodeIndex +
              0,
            axis <<
              30 |
              nextIndex);
        tempTree.
          set(
            nodeIndex +
              1,
            java.lang.Float.
              floatToRawIntBits(
                clipL));
        tempTree.
          set(
            nodeIndex +
              2,
            java.lang.Float.
              floatToRawIntBits(
                clipR));
        float[] gridBoxL =
          new float[6];
        float[] gridBoxR =
          new float[6];
        float[] nodeBoxL =
          new float[6];
        float[] nodeBoxR =
          new float[6];
        for (int i =
               0;
             i <
               6;
             i++) {
            gridBoxL[i] =
              (gridBoxR[i] =
                 gridBox[i]);
            nodeBoxL[i] =
              (nodeBoxR[i] =
                 nodeBox[i]);
        }
        gridBoxL[2 *
                   axis +
                   1] =
          (gridBoxR[2 *
                      axis] =
             split);
        nodeBoxL[2 *
                   axis +
                   1] =
          clipL;
        nodeBoxR[2 *
                   axis +
                   0] =
          clipR;
        gridBox =
          (nodeBox =
             null);
        if (nl >
              0)
            subdivide(
              left,
              right,
              tempTree,
              indices,
              gridBoxL,
              nodeBoxL,
              nextIndex,
              depth +
                1,
              stats);
        else
            stats.
              updateLeaf(
                depth +
                  1,
                0);
        if (nr >
              0)
            subdivide(
              right +
                1,
              rightOrig,
              tempTree,
              indices,
              gridBoxR,
              nodeBoxR,
              nextIndex +
                3,
              depth +
                1,
              stats);
        else
            stats.
              updateLeaf(
                depth +
                  1,
                0);
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
        int offsetXFront =
          java.lang.Float.
          floatToRawIntBits(
            dirX) >>>
          31;
        int offsetYFront =
          java.lang.Float.
          floatToRawIntBits(
            dirY) >>>
          31;
        int offsetZFront =
          java.lang.Float.
          floatToRawIntBits(
            dirZ) >>>
          31;
        int offsetXBack =
          offsetXFront ^
          1;
        int offsetYBack =
          offsetYFront ^
          1;
        int offsetZBack =
          offsetZFront ^
          1;
        int offsetXFront3 =
          offsetXFront *
          3;
        int offsetYFront3 =
          offsetYFront *
          3;
        int offsetZFront3 =
          offsetZFront *
          3;
        int offsetXBack3 =
          offsetXBack *
          3;
        int offsetYBack3 =
          offsetYBack *
          3;
        int offsetZBack3 =
          offsetZBack *
          3;
        offsetXFront++;
        offsetYFront++;
        offsetZFront++;
        offsetXBack++;
        offsetYBack++;
        offsetZBack++;
        org.sunflow.core.IntersectionState.StackNode[] stack =
          state.
          getStack(
            );
        int stackTop =
          state.
          getStackTop(
            );
        int stackPos =
          stackTop;
        int node =
          0;
        while (true) {
            pushloop: while (true) {
                int tn =
                  tree[node];
                int axis =
                  tn &
                  7 <<
                  29;
                int offset =
                  tn &
                  ~(7 <<
                      29);
                switch (axis) {
                    case 0:
                        {
                            float tf =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetXFront]) -
                                 orgX) *
                              invDirX;
                            float tb =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetXBack]) -
                                 orgX) *
                              invDirX;
                            if (tf <
                                  intervalMin &&
                                  tb >
                                  intervalMax)
                                break pushloop;
                            int back =
                              offset +
                              offsetXBack3;
                            node =
                              back;
                            if (tf <
                                  intervalMin) {
                                intervalMin =
                                  tb >=
                                    intervalMin
                                    ? tb
                                    : intervalMin;
                                continue;
                            }
                            node =
                              offset +
                                offsetXFront3;
                            if (tb >
                                  intervalMax) {
                                intervalMax =
                                  tf <=
                                    intervalMax
                                    ? tf
                                    : intervalMax;
                                continue;
                            }
                            stack[stackPos].
                              node =
                              back;
                            stack[stackPos].
                              near =
                              tb >=
                                intervalMin
                                ? tb
                                : intervalMin;
                            stack[stackPos].
                              far =
                              intervalMax;
                            stackPos++;
                            intervalMax =
                              tf <=
                                intervalMax
                                ? tf
                                : intervalMax;
                            continue;
                        }
                    case 1 <<
                      30:
                        {
                            float tf =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetYFront]) -
                                 orgY) *
                              invDirY;
                            float tb =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetYBack]) -
                                 orgY) *
                              invDirY;
                            if (tf <
                                  intervalMin &&
                                  tb >
                                  intervalMax)
                                break pushloop;
                            int back =
                              offset +
                              offsetYBack3;
                            node =
                              back;
                            if (tf <
                                  intervalMin) {
                                intervalMin =
                                  tb >=
                                    intervalMin
                                    ? tb
                                    : intervalMin;
                                continue;
                            }
                            node =
                              offset +
                                offsetYFront3;
                            if (tb >
                                  intervalMax) {
                                intervalMax =
                                  tf <=
                                    intervalMax
                                    ? tf
                                    : intervalMax;
                                continue;
                            }
                            stack[stackPos].
                              node =
                              back;
                            stack[stackPos].
                              near =
                              tb >=
                                intervalMin
                                ? tb
                                : intervalMin;
                            stack[stackPos].
                              far =
                              intervalMax;
                            stackPos++;
                            intervalMax =
                              tf <=
                                intervalMax
                                ? tf
                                : intervalMax;
                            continue;
                        }
                    case 2 <<
                      30:
                        {
                            float tf =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetZFront]) -
                                 orgZ) *
                              invDirZ;
                            float tb =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetZBack]) -
                                 orgZ) *
                              invDirZ;
                            if (tf <
                                  intervalMin &&
                                  tb >
                                  intervalMax)
                                break pushloop;
                            int back =
                              offset +
                              offsetZBack3;
                            node =
                              back;
                            if (tf <
                                  intervalMin) {
                                intervalMin =
                                  tb >=
                                    intervalMin
                                    ? tb
                                    : intervalMin;
                                continue;
                            }
                            node =
                              offset +
                                offsetZFront3;
                            if (tb >
                                  intervalMax) {
                                intervalMax =
                                  tf <=
                                    intervalMax
                                    ? tf
                                    : intervalMax;
                                continue;
                            }
                            stack[stackPos].
                              node =
                              back;
                            stack[stackPos].
                              near =
                              tb >=
                                intervalMin
                                ? tb
                                : intervalMin;
                            stack[stackPos].
                              far =
                              intervalMax;
                            stackPos++;
                            intervalMax =
                              tf <=
                                intervalMax
                                ? tf
                                : intervalMax;
                            continue;
                        }
                    case 3 <<
                      30:
                        {
                            int n =
                              tree[node +
                                     1];
                            while (n >
                                     0) {
                                primitives.
                                  intersectPrimitive(
                                    r,
                                    objects[offset],
                                    state);
                                n--;
                                offset++;
                            }
                            break pushloop;
                        }
                    case 1 <<
                      29:
                        {
                            float tf =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetXFront]) -
                                 orgX) *
                              invDirX;
                            float tb =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetXBack]) -
                                 orgX) *
                              invDirX;
                            node =
                              offset;
                            intervalMin =
                              tf >=
                                intervalMin
                                ? tf
                                : intervalMin;
                            intervalMax =
                              tb <=
                                intervalMax
                                ? tb
                                : intervalMax;
                            if (intervalMin >
                                  intervalMax)
                                break pushloop;
                            continue;
                        }
                    case 3 <<
                      29:
                        {
                            float tf =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetYFront]) -
                                 orgY) *
                              invDirY;
                            float tb =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetYBack]) -
                                 orgY) *
                              invDirY;
                            node =
                              offset;
                            intervalMin =
                              tf >=
                                intervalMin
                                ? tf
                                : intervalMin;
                            intervalMax =
                              tb <=
                                intervalMax
                                ? tb
                                : intervalMax;
                            if (intervalMin >
                                  intervalMax)
                                break pushloop;
                            continue;
                        }
                    case 5 <<
                      29:
                        {
                            float tf =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetZFront]) -
                                 orgZ) *
                              invDirZ;
                            float tb =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetZBack]) -
                                 orgZ) *
                              invDirZ;
                            node =
                              offset;
                            intervalMin =
                              tf >=
                                intervalMin
                                ? tf
                                : intervalMin;
                            intervalMax =
                              tb <=
                                intervalMax
                                ? tb
                                : intervalMax;
                            if (intervalMin >
                                  intervalMax)
                                break pushloop;
                            continue;
                        }
                    default:
                        return;
                }
            }
            do  {
                if (stackPos ==
                      stackTop)
                    return;
                stackPos--;
                intervalMin =
                  stack[stackPos].
                    near;
                if (r.
                      getMax(
                        ) <
                      intervalMin)
                    continue;
                node =
                  stack[stackPos].
                    node;
                intervalMax =
                  stack[stackPos].
                    far;
                break;
            }while(true); 
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZCWwc1Rl+u76PZH3ETuIkTuI4kRLCLjcCU4Jjktjp2nHt" +
       "kBaH4szOvrUnmZ2ZzLy116HmEpT0itI2HK3AlWgoKQoBIWgrFWigLYc4JI4W" +
       "KIJAVRVaoE2ooBVpS///vZmdY4/IKmKleTsz7/3v/df7/v9/c/gDUmGZpJ1q" +
       "LMqmDGpFN2hsUDItmuxRJcvaCu9G5VvLpH9c+e7ABWFSOULmjktWvyxZdKNC" +
       "1aQ1QpYomsUkTabWAKVJpBg0qUXNCYkpujZCWhSrL22oiqywfj1JccA2yYyT" +
       "RokxU0lkGO2zJ2BkSRw4iXFOYt3B7q44qZd1Y8odvsAzvMfTgyPT7loWIw3x" +
       "ndKEFMswRY3FFYt1ZU1ymqGrU2OqzqI0y6I71XNtFWyOn5ungo77Ix+f3D/e" +
       "wFXQLGmazrh41hC1dHWCJuMk4r7doNK0tZtcTcripM4zmJHOuLNoDBaNwaKO" +
       "tO4o4H4O1TLpHp2Lw5yZKg0ZGWJkuX8SQzKltD3NIOcZZqhmtuycGKRdlpNW" +
       "SJkn4s2nxQ7cemXDA2UkMkIiijaM7MjABINFRkChNJ2gptWdTNLkCGnUwNjD" +
       "1FQkVdljW7rJUsY0iWXA/I5a8GXGoCZf09UV2BFkMzMy082ceCnuUPZTRUqV" +
       "xkDWVldWIeFGfA8C1irAmJmSwO9skvJdipZkZGmQIidj5xdhAJBWpSkb13NL" +
       "lWsSvCBNwkVUSRuLDYPraWMwtEIHBzQZaSs6KerakORd0hgdRY8MjBsUXTCq" +
       "hisCSRhpCQ7jM4GV2gJW8tjng4GL9l2l9WphEgKek1RWkf86IGoPEA3RFDUp" +
       "7ANBWL8mfovU+sjeMCEwuCUwWIz5+ddOXLK2/ehTYsyiAmO2JHZSmY3KBxNz" +
       "X1jcs/qCMmSj2tAtBY3vk5zvskG7pytrAMK05mbEzqjTeXToicuvvYe+Fya1" +
       "faRS1tVMGvyoUdbThqJScxPVqCkxmuwjNVRL9vD+PlIF93FFo+LtllTKoqyP" +
       "lKv8VaXOn0FFKZgCVVQL94qW0p17Q2Lj/D5rEEKq4CKb4JpLxI//M7IrNq6n" +
       "aUySJU3R9NigqaP8aFAtKcUYteA+Cb2GHrMyWkrVJ2OWKcd0cyz3LOsmTiBT" +
       "NbZez2hJcKk+dNoJSe1VQDBTHp+KotMZn+9yWZS+eTIUAsMsDsKCCjuqV1eT" +
       "1ByVD2TWbzhxZPQZ4XK4TWy9MXIGrBy1V47iylG+crToyiQU4gvOQw6EF4AN" +
       "dwEaABzXrx7+6uYdezvKwP2MyXIwAA7t8IWlHhcyHJwflT/c/PbZvdMXvhQm" +
       "YUCVBIQlNzos80QHDGumLtMkgFOxKOEgZax4XCjIAzl62+R12645g/PghXuc" +
       "sAKQCskHEaRzS3QGt3mheSM3vfvxfbdM6+6G98UPJ+zlUSKOdATNGhR+VF6z" +
       "THpo9JHpzjApB3ACQGYSbCDAuvbgGj486XKwGWWpBoFTupmWVOxyALWWjZv6" +
       "pPuG+1sjv58Hpq3DDdYJV4u94/g/9rYa2M4X/om+EpCCY/8Xho07Xn3+L2dz" +
       "dTthIuKJ78OUdXmgCSdr4iDU6LreVpNSGPfGbYPfv/mDm7Zzv4MRKwot2Ilt" +
       "D0ASmBDUfONTu1879ubBl8OurzKIzZkEpDjZnJD4ntSWEBJWW+XyA9Cmwn5H" +
       "r+m8TAOvVFKKlFApbo5/R1ae+dD7+xqEH6jwxnGjtaeewH2/cD259pkr/9nO" +
       "pwnJGFpdnbnDBF43uzN3m6Y0hXxkr3txyQ+elO4A5Ae0tZQ9lAMo4Tog3Gjn" +
       "cPljvD070HceNp2W1/n9+8uTAo3K+18+Pmfb8UdPcG79OZTX1v2S0SXcC5uV" +
       "WZh+fhBgeiVrHMadc3Tgigb16EmYcQRmBLSyrC0m4FzW5xn26IqqPzz269Yd" +
       "L5SR8EZSq+pScqPENxmpAe+m1jhAZNZYd4kw7mQ1NA1cVJInPOpzaWFLbUgb" +
       "jOt2zy/mP3jR3TNvcqcSXrSIk2N6vtiHgzzvdrfxPS+d/7u7v3vLpIjcq4tj" +
       "V4BuwSdb1MT1f/xXnoI5ahXIKgL0I7HDt7f1XPwep3fhA6lXZPPjCgCsS3vW" +
       "PemPwh2Vvw2TqhHSINt57jZJzeCmHIHcznKSX8iFff3+PE0kJV05eFwchC7P" +
       "skHgcuMZ3ONovJ8TwKp6tOB8uCL2No4EsSpE+M0mTrKKt6uxWetAQ5VhKlAL" +
       "0QA21JWYlAFDAFD+ygyLp+FMwmJ8Q4q07Yq6J35l/fjPDwjjdxQYHMgFD91d" +
       "Lb+efuJPgmBhAQIxruVQ7DvbXtn5LAfZaoyrWx0NeaJmtznmQfiGnIA8hWqE" +
       "a5Et4CKRUyU+oyQHNJoGbJ+gsa1QgGhjKu2HHemkUp/DKogzK4tvNY+FZn6y" +
       "4vlrZla8zVGnWrHAIUFrBTJ9D83xw8fee3HOkiM8Mpej8m3F+0uk/ArIV9hw" +
       "m0SwGcpahZ1j0JFQrHvW4A55b+cgdw6kGxQG/RR+Ibj+ixcaEl8Igzb12Jn6" +
       "slyqbhi4WgkcCiwam246tuv2d+8VHhkEncBguvfANz+N7jsgQqGo91bklVxe" +
       "GlHzCf/EZgS5W15qFU6x8Z37pn95aPomwVWTv3rZAMX5vb//z7PR2956ukBq" +
       "XKbYNTsGgVAum53nN4AQ6NJvRB7e31S2EUzdR6ozmrI7Q/uSfnCqsjIJz+5z" +
       "60gXsGzR0DCMhNYYdgjxMoDP3cIbbMhSCkNWGG9PZwCWiiapfPoRSHBUqo2J" +
       "umkUmy97lggLOv68gNm5A+IzlK+6RjENcfpE9q/o0dzRAXTmM2uSJb6Y18/9" +
       "2g0gtV8/oznOsqn8tB9nai+S2K8p7pTBBZ68/q9tWy8e3zGLnH5pwKmCU/60" +
       "//DTm1bJ3wvzMwcRr/LOKvxEXX5HqDUpy5ia3/QdwqbcJsKg2KzhZiuRjV1V" +
       "om8amyx4gIzmE9YuMfxa7k3rPJmPbUZ8TNnJPLbnY9MrrH1h0dSp2x9825xu" +
       "579A8L3BFXxzfpQtRg2hWef5Ayf5UoDPG2fJ50o75DmhrxCf3yrJZzFqRmpz" +
       "ochyNlJ7Xv2dA7G4XSF4hPn2LIVZCleTzU5TEWEOlBSmGDUgSQKPCHKCLPYK" +
       "kpbYeO4IYb0e9J2bZynGQriabUaai4hxR0kxilEzUp2WsqhyTnN5gNGZEoxm" +
       "Pbs0tyD/VZLAKZRnQU9JEHJUtyrPB7rxDAbjMEDVMD8WgJIfI96SYueKPNod" +
       "vP7ATHLLXWc6gV9iUOXoxukqnaCqrxjBe+av5GO2oh2FF6jkCwicq4+LkQYA" +
       "xwMp+/msD5RApAexuRcALJFR7HzpCg6IQvc7IL+e0JWka68jp3IsXz3H4S6g" +
       "Cu5vw3Dtt+XZfwpVFHC2YqQBScs4H2WOFyz0egHPT/o0USNwWHOGdc32wK5z" +
       "PSoPvwJYnPfHSij8SWweZmQuV3huCnz7M1fLj3w2Wh6C605bVXfOXsvFSAPi" +
       "lXM+yvHx8dwWFw1f5IUS6ngJm2cBt2WTQk48ALlIQBXPfTaq+BFch2x5Ds1e" +
       "FcVIA6LVcD5q/Fp43PWuAX/hh1jZZs/c5sw8zGfeKsS+DJtj4v4rno0Z2KRQ" +
       "rutSXiqNj6kS+e0xB9nfKZXfYmMnt9ikseGJ7Vv5iS0+8q8Huwsvy8SynBqb" +
       "qRKu8bcSfcexeR+bqwUnJcZ+eOqk602/wX7DX75RYs6PsHmVYYWRSCoTSp7X" +
       "vvZ/ey2PGBcAmxkxg/gv4bX5EaMoaUCyQFUyLw//hqQpp7Mjr5PDoSXO6RAD" +
       "KWfs0+LaC1Xgy09Ae4pDGtDeydlrD5LwhUUBGs8VF+R91RVfIuUjM5Hq+TOX" +
       "vSLOEJyvhfVxUp3KqKr36MtzX2mYNKVwSevFQZjBRatnpLVw+IBNyv+R/1Cd" +
       "GB1hpCE4GiIu/nmHNTFS5xnGsM7ld95BLVBOwyC8bTUcazW4BaY4AMyGPEmK" +
       "nWBxlbecSuU5Eu/ZP1aH/KO6U8llxGf1Ufm+mc0DV5047y7x7UFWpT17cJY6" +
       "KNLFZxA+KVaDy4vO5sxV2bv65Nz7a1Y6SVejYNj1/0WerbkO/N1Ag7cFDuat" +
       "ztz5/GsHL3r0ub2VL4ZJaDsJQQ7XvD3/qDRrZCAb3B7PP4yASpl/Meha/cOp" +
       "i9em/v46P4smohxfXHz8qFzzyb49y61QNExq+kgF5JM0y89wL53Shqg8YfpO" +
       "Nuz0n+spTuaiZ0r4sZ1rxVbmnNxb/G4F2zP/iCf/W14tuA41+W7BaeYEaueM" +
       "YXh7uVapiDeoZfCz0Xi/YThnW7wcXGcYuA9DPHqk/gcHqlhbLSMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/3avI9QT0J8n4pFu/+D2s9P89fvz5H23");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("H4YWVrDrtqidJ+o9rPCP71H2p3ny3/NkvePkHrT/c3dW+AenDeMLRdl/uke9" +
       "N/Lky0F+3XSpGJFxmxP8/rfgBMWs0QRqCXd1d7/34wR3njXOnGG/+TZwnEjp" +
       "YeGztxUWWOnvbk3lAKnmfexduLuS9h7IE+A6V4zDqqeVtLd3P0pKAOrfFbfz" +
       "S1yP33b3endfWP7Mq9cuP/bq7F/t7pIc3um9wpQur0LTPHnn5kT+ouupK6PQ" +
       "45XdDRy3EOpGUHr0zrMK8KniN+d87+EddX60dpYazLf5z0myx4PSAyfIgtKl" +
       "g9xJou8ISucAUZ590r3Dwd3u5lGydyIeOTCtwiJvfCNlH1U5eTEwv5lQXH0/" +
       "vEUQ7i6/vyh/9lVq+IGv1z61u5gom1KW5a1cZkqXdncki0bzmwhvv2trh21d" +
       "7L/rjYd+9srzh/HVQzuGj838BG/P3PkWYMdyg+LeXvbzj/2D7/67r/5ecY74" +
       "/wDycgSPkzAAAA==");
}
