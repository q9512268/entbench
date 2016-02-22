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
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "AAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/Fs6+g2Ku6EhLODlJdGj8+TvfKPZ7fz7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Aqgj3+Wo9Y8OT0P+692OWk/AfJEsj/T4h7eesRavP1gkH7j10LQc8X23Ze0i" +
       "0e9icX9yl7I/K5L/ViTWnpO70P6P/ZniH542gi+VZf/xLvW+WSRfjYvrpopm" +
       "bs1bDP4P3oLBlzNEG6gl2dfd/9+Lwd9+hjhz1v32W4BwIu8OC5+7pbDExWh/" +
       "k6oAQ73o49yFOyvp3ANFAtzkinlY9bSSzp27FyVlAOHviNHFxa4nbrl7vb8v" +
       "rH7utWuXH39N/Nf7+yWHd3qv0JXLRuI4J+/hnMhfDELdMEs9XtnfyglKoR6J" +
       "K4/dfgYBPlX+F5yfe3hPXRzBnaUGc2vxd5LsibjywAmyuHLpIHeS6Lviyn2A" +
       "qMg+FdzmgG9/Gyk7dyL2ODCt0iIf+VbKPqpy8rJgcYOhvPp+eNsg2V9+f0n9" +
       "/GvU+ENvNj+zv6yoOnKeF61cpiuX9vcmy0aLGwvvvmNrh21dHL73mw/9/JUX" +
       "DmOph/YMH5v5Cd6evf3NwL4bxOVdvvwXH/8H3/fTr/1+ed74fwGYUJ9tkzAA" +
       "AA==");
}
