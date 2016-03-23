package org.sunflow.core.accel;
public class KDTree implements org.sunflow.core.AccelerationStructure {
    private int[] tree;
    private int[] primitives;
    private org.sunflow.core.PrimitiveList primitiveList;
    private org.sunflow.math.BoundingBox bounds;
    private int maxPrims;
    private static final float INTERSECT_COST = 0.5F;
    private static final float TRAVERSAL_COST = 1;
    private static final float EMPTY_BONUS = 0.2F;
    private static final int MAX_DEPTH = 64;
    private static boolean dump = false;
    private static java.lang.String dumpPrefix = "kdtree";
    public KDTree() { this(0); }
    public KDTree(int maxPrims) { super();
                                  this.maxPrims = maxPrims; }
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
        BuildStats() { super();
                       numNodes = (numLeaves = 0);
                       sumObjects = 0;
                       minObjects = java.lang.Integer.MAX_VALUE;
                       maxObjects = java.lang.Integer.MIN_VALUE;
                       sumDepth = 0;
                       minDepth = java.lang.Integer.MAX_VALUE;
                       maxDepth = java.lang.Integer.MIN_VALUE;
                       numLeaves0 = 0;
                       numLeaves1 = 0;
                       numLeaves2 = 0;
                       numLeaves3 = 0;
                       numLeaves4 = 0;
                       numLeaves4p = 0; }
        void updateInner() { numNodes++; }
        void updateLeaf(int depth, int n) { numLeaves++;
                                            minDepth = java.lang.Math.min(
                                                                        depth,
                                                                        minDepth);
                                            maxDepth = java.lang.Math.max(
                                                                        depth,
                                                                        maxDepth);
                                            sumDepth += depth;
                                            minObjects = java.lang.Math.min(
                                                                          n,
                                                                          minObjects);
                                            maxObjects = java.lang.Math.max(
                                                                          n,
                                                                          maxObjects);
                                            sumObjects += n;
                                            switch (n) { case 0: numLeaves0++;
                                                                 break; case 1:
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
                                                             break; } }
        void printStats() { org.sunflow.system.UI.printDetailed(org.sunflow.system.UI.Module.
                                                                  ACCEL,
                                                                "KDTree stats:");
                            org.sunflow.system.UI.printDetailed(org.sunflow.system.UI.Module.
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
                                  numLeaves); }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1457076400000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "2SN9qvofIZgzQrIhAAA=");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "rW2GXdeXJXEuLdD5umpGtVnPlRcaUgtm6Hw6SOv1Gjruj7ImCpt+B91uBYxI" +
           "1L5jMdVB4ikCwfk+HC9XttKeDVtoV9YUuCk786zUDjOxlTG42BkNO2YFFyPa" +
           "JHCpMg8JLKlaphzCXRJMsKw62w5WE6VNy1W+TdSYqdij+p4Tyc2wToXYtKuj" +
           "y4EzGPrTcW/Q6rlg5FFFIRh1MBwv1lN02pThBtfnGts608FIeijCJiuBabFt" +
           "txW94pZLcJJI1Wk1c5FOe4ws5jqrZl2mNF6Qc3phTJvNldPddgN0a7eHMexj" +
           "G4fXAyfTGpuxFY2IQR2tDySOta1QnWE1d9qYN0gZ7jZ6PE+MB+aYabm6S+EL" +
           "D4u3bQ+gFpQK2+4k+mgTludeuezH45VCqsOwZlcmWSvoqVTmy8p4Vam0LbS6" +
           "JWlr5pgRtp5GXnvSxpChLyZhJ7ZKdtRTS912W/BigyOp0XbQXfOlVdrncUqA" +
           "R1vW3dRtWlZA04SVVmN9NaK4OqWMkFmzV59kKV+BV3PMYLMwa2/i0J/WWA1J" +
           "AhfovUTgiO1UpS5X7YtVigVhjmtIKVyW4NbcKPkTvYs3tFpH4CYKI62HFVpA" +
           "At6aI82yLLR0Eu7W1S4ZZFm3O8cx1wtFMg2wiqObG2TYmIz720W5C2yw6tY4" +
           "HhZqCz22LLQ0r3M9YkGXkEUVLmU87A1VQZxlOlPGOXjKYzCMyfGyRlawPm9X" +
           "bW4kT5aqjLO0t3FiSe2hGFt3SjM4SakJX6Pro8lM6JusT5b71bZfiR2rvdKt" +
           "jJakypLuqBWbY2gjbRvqbNNebpflJJJ1J7HHiWFn5c6sTk4bvQCM/xRFs+E4" +
           "LWHLZbmZINMWXK1ZsocPN/ONSrF0KsXqlhDSml2m7Y3JVxSqhborq8nRDtq2" +
           "qJR0DU4MKnR5arQ9xBT5ptdbl3gaqbVmvsq7WwPzw1ZlNHPCEa/zlNb05n7K" +
           "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" +
           "e/1rxcb2/wdk00cUWywAAA==");
    }
    public static void setDumpMode(boolean dump, java.lang.String prefix) {
        org.sunflow.core.accel.KDTree.
          dump =
          dump;
        org.sunflow.core.accel.KDTree.
          dumpPrefix =
          prefix;
    }
    public void build(org.sunflow.core.PrimitiveList primitives) {
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              ACCEL,
            "KDTree settings");
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              ACCEL,
            "  * Max Leaf Size:  %d",
            maxPrims);
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              ACCEL,
            "  * Max Depth:      %d",
            MAX_DEPTH);
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              ACCEL,
            "  * Traversal cost: %.2f",
            TRAVERSAL_COST);
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              ACCEL,
            "  * Intersect cost: %.2f",
            INTERSECT_COST);
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              ACCEL,
            "  * Empty bonus:    %.2f",
            EMPTY_BONUS);
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              ACCEL,
            "  * Dump leaves:    %s",
            dump
              ? "enabled"
              : "disabled");
        org.sunflow.system.Timer total =
          new org.sunflow.system.Timer(
          );
        total.
          start(
            );
        this.
          primitiveList =
          primitives;
        bounds =
          primitives.
            getWorldBounds(
              null);
        int nPrim =
          primitiveList.
          getNumPrimitives(
            );
        int nSplits =
          0;
        org.sunflow.core.accel.KDTree.BuildTask task =
          new org.sunflow.core.accel.KDTree.BuildTask(
          nPrim);
        org.sunflow.system.Timer prepare =
          new org.sunflow.system.Timer(
          );
        prepare.
          start(
            );
        for (int i =
               0;
             i <
               nPrim;
             i++) {
            for (int axis =
                   0;
                 axis <
                   3;
                 axis++) {
                float ls =
                  primitiveList.
                  getPrimitiveBound(
                    i,
                    2 *
                      axis +
                      0);
                float rs =
                  primitiveList.
                  getPrimitiveBound(
                    i,
                    2 *
                      axis +
                      1);
                if (ls ==
                      rs) {
                    task.
                      splits[nSplits] =
                      pack(
                        ls,
                        PLANAR,
                        axis,
                        i);
                    nSplits++;
                }
                else {
                    task.
                      splits[nSplits +
                               0] =
                      pack(
                        ls,
                        OPENED,
                        axis,
                        i);
                    task.
                      splits[nSplits +
                               1] =
                      pack(
                        rs,
                        CLOSED,
                        axis,
                        i);
                    nSplits +=
                      2;
                }
            }
        }
        task.
          n =
          nSplits;
        prepare.
          end(
            );
        org.sunflow.system.Timer t =
          new org.sunflow.system.Timer(
          );
        org.sunflow.util.IntArray tempTree =
          new org.sunflow.util.IntArray(
          );
        org.sunflow.util.IntArray tempList =
          new org.sunflow.util.IntArray(
          );
        tempTree.
          add(
            0);
        tempTree.
          add(
            1);
        t.
          start(
            );
        org.sunflow.system.Timer sorting =
          new org.sunflow.system.Timer(
          );
        sorting.
          start(
            );
        radix12(
          task.
            splits,
          task.
            n);
        sorting.
          end(
            );
        org.sunflow.core.accel.KDTree.BuildStats stats =
          new org.sunflow.core.accel.KDTree.BuildStats(
          );
        buildTree(
          bounds.
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
            z,
          task,
          1,
          tempTree,
          0,
          tempList,
          stats);
        t.
          end(
            );
        task =
          null;
        tree =
          tempTree.
            trim(
              );
        tempTree =
          null;
        this.
          primitives =
          tempList.
            trim(
              );
        tempList =
          null;
        total.
          end(
            );
        stats.
          printStats(
            );
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              ACCEL,
            "  * Node memory:    %s",
            org.sunflow.system.Memory.
              sizeof(
                tree));
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              ACCEL,
            "  * Object memory:  %s",
            org.sunflow.system.Memory.
              sizeof(
                this.
                  primitives));
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              ACCEL,
            "  * Prepare time:   %s",
            prepare);
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              ACCEL,
            "  * Sorting time:   %s",
            sorting);
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              ACCEL,
            "  * Tree creation:  %s",
            t);
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              ACCEL,
            "  * Build time:     %s",
            total);
        if (dump) {
            try {
                org.sunflow.system.UI.
                  printInfo(
                    org.sunflow.system.UI.Module.
                      ACCEL,
                    "Dumping mtls to %s.mtl ...",
                    dumpPrefix);
                java.io.FileWriter mtlFile =
                  new java.io.FileWriter(
                  dumpPrefix +
                  ".mtl");
                int maxN =
                  stats.
                    maxObjects;
                for (int n =
                       0;
                     n <=
                       maxN;
                     n++) {
                    float blend =
                      (float)
                        n /
                      (float)
                        maxN;
                    org.sunflow.image.Color nc;
                    if (blend <
                          0.25)
                        nc =
                          org.sunflow.image.Color.
                            blend(
                              org.sunflow.image.Color.
                                BLUE,
                              org.sunflow.image.Color.
                                GREEN,
                              blend /
                                0.25F);
                    else
                        if (blend <
                              0.5)
                            nc =
                              org.sunflow.image.Color.
                                blend(
                                  org.sunflow.image.Color.
                                    GREEN,
                                  org.sunflow.image.Color.
                                    YELLOW,
                                  (blend -
                                     0.25F) /
                                    0.25F);
                        else
                            if (blend <
                                  0.75)
                                nc =
                                  org.sunflow.image.Color.
                                    blend(
                                      org.sunflow.image.Color.
                                        YELLOW,
                                      org.sunflow.image.Color.
                                        RED,
                                      (blend -
                                         0.5F) /
                                        0.25F);
                            else
                                nc =
                                  org.sunflow.image.Color.
                                    MAGENTA;
                    mtlFile.
                      write(
                        java.lang.String.
                          format(
                            "newmtl mtl%d\n",
                            n));
                    float[] rgb =
                      nc.
                      getRGB(
                        );
                    mtlFile.
                      write(
                        "Ka 0.1 0.1 0.1\n");
                    mtlFile.
                      write(
                        java.lang.String.
                          format(
                            "Kd %.12g %.12g %.12g\n",
                            rgb[0],
                            rgb[1],
                            rgb[2]));
                    mtlFile.
                      write(
                        "illum 1\n\n");
                }
                java.io.FileWriter objFile =
                  new java.io.FileWriter(
                  dumpPrefix +
                  ".obj");
                org.sunflow.system.UI.
                  printInfo(
                    org.sunflow.system.UI.Module.
                      ACCEL,
                    "Dumping tree to %s.obj ...",
                    dumpPrefix);
                dumpObj(
                  0,
                  0,
                  maxN,
                  new org.sunflow.math.BoundingBox(
                    bounds),
                  objFile,
                  mtlFile);
                objFile.
                  close(
                    );
                mtlFile.
                  close(
                    );
            }
            catch (java.io.IOException e) {
                e.
                  printStackTrace(
                    );
            }
        }
    }
    private int dumpObj(int offset, int vertOffset,
                        int maxN,
                        org.sunflow.math.BoundingBox bounds,
                        java.io.FileWriter file,
                        java.io.FileWriter mtlFile)
          throws java.io.IOException { if (offset ==
                                             0) file.
                                                  write(
                                                    java.lang.String.
                                                      format(
                                                        "mtllib %s.mtl\n",
                                                        dumpPrefix));
                                       int nextOffset =
                                         tree[offset];
                                       if ((nextOffset &
                                              3 <<
                                              30) ==
                                             3 <<
                                             30) {
                                           int n =
                                             tree[offset +
                                                    1];
                                           if (n >
                                                 0) {
                                               org.sunflow.math.Point3 min =
                                                 bounds.
                                                 getMinimum(
                                                   );
                                               org.sunflow.math.Point3 max =
                                                 bounds.
                                                 getMaximum(
                                                   );
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "o node%d\n",
                                                       offset));
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "v %g %g %g\n",
                                                       max.
                                                         x,
                                                       max.
                                                         y,
                                                       min.
                                                         z));
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "v %g %g %g\n",
                                                       max.
                                                         x,
                                                       min.
                                                         y,
                                                       min.
                                                         z));
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "v %g %g %g\n",
                                                       min.
                                                         x,
                                                       min.
                                                         y,
                                                       min.
                                                         z));
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "v %g %g %g\n",
                                                       min.
                                                         x,
                                                       max.
                                                         y,
                                                       min.
                                                         z));
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "v %g %g %g\n",
                                                       max.
                                                         x,
                                                       max.
                                                         y,
                                                       max.
                                                         z));
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "v %g %g %g\n",
                                                       max.
                                                         x,
                                                       min.
                                                         y,
                                                       max.
                                                         z));
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "v %g %g %g\n",
                                                       min.
                                                         x,
                                                       min.
                                                         y,
                                                       max.
                                                         z));
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "v %g %g %g\n",
                                                       min.
                                                         x,
                                                       max.
                                                         y,
                                                       max.
                                                         z));
                                               int v0 =
                                                 vertOffset;
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "usemtl mtl%d\n",
                                                       n));
                                               file.
                                                 write(
                                                   "s off\n");
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "f %d %d %d %d\n",
                                                       v0 +
                                                         1,
                                                       v0 +
                                                         2,
                                                       v0 +
                                                         3,
                                                       v0 +
                                                         4));
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "f %d %d %d %d\n",
                                                       v0 +
                                                         5,
                                                       v0 +
                                                         8,
                                                       v0 +
                                                         7,
                                                       v0 +
                                                         6));
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "f %d %d %d %d\n",
                                                       v0 +
                                                         1,
                                                       v0 +
                                                         5,
                                                       v0 +
                                                         6,
                                                       v0 +
                                                         2));
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "f %d %d %d %d\n",
                                                       v0 +
                                                         2,
                                                       v0 +
                                                         6,
                                                       v0 +
                                                         7,
                                                       v0 +
                                                         3));
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "f %d %d %d %d\n",
                                                       v0 +
                                                         3,
                                                       v0 +
                                                         7,
                                                       v0 +
                                                         8,
                                                       v0 +
                                                         4));
                                               file.
                                                 write(
                                                   java.lang.String.
                                                     format(
                                                       "f %d %d %d %d\n",
                                                       v0 +
                                                         5,
                                                       v0 +
                                                         1,
                                                       v0 +
                                                         4,
                                                       v0 +
                                                         8));
                                               vertOffset +=
                                                 8;
                                           }
                                           return vertOffset;
                                       }
                                       else {
                                           int axis =
                                             nextOffset &
                                             3 <<
                                             30;
                                           int v0;
                                           float split =
                                             java.lang.Float.
                                             intBitsToFloat(
                                               tree[offset +
                                                      1]);
                                           float min;
                                           float max;
                                           nextOffset &=
                                             ~(3 <<
                                                 30);
                                           switch (axis) {
                                               case 0:
                                                   max =
                                                     bounds.
                                                       getMaximum(
                                                         ).
                                                       x;
                                                   bounds.
                                                     getMaximum(
                                                       ).
                                                     x =
                                                     split;
                                                   v0 =
                                                     dumpObj(
                                                       nextOffset,
                                                       vertOffset,
                                                       maxN,
                                                       bounds,
                                                       file,
                                                       mtlFile);
                                                   bounds.
                                                     getMaximum(
                                                       ).
                                                     x =
                                                     max;
                                                   min =
                                                     bounds.
                                                       getMinimum(
                                                         ).
                                                       x;
                                                   bounds.
                                                     getMinimum(
                                                       ).
                                                     x =
                                                     split;
                                                   v0 =
                                                     dumpObj(
                                                       nextOffset +
                                                         2,
                                                       v0,
                                                       maxN,
                                                       bounds,
                                                       file,
                                                       mtlFile);
                                                   bounds.
                                                     getMinimum(
                                                       ).
                                                     x =
                                                     min;
                                                   break;
                                               case 1 <<
                                                 30:
                                                   max =
                                                     bounds.
                                                       getMaximum(
                                                         ).
                                                       y;
                                                   bounds.
                                                     getMaximum(
                                                       ).
                                                     y =
                                                     split;
                                                   v0 =
                                                     dumpObj(
                                                       nextOffset,
                                                       vertOffset,
                                                       maxN,
                                                       bounds,
                                                       file,
                                                       mtlFile);
                                                   bounds.
                                                     getMaximum(
                                                       ).
                                                     y =
                                                     max;
                                                   min =
                                                     bounds.
                                                       getMinimum(
                                                         ).
                                                       y;
                                                   bounds.
                                                     getMinimum(
                                                       ).
                                                     y =
                                                     split;
                                                   v0 =
                                                     dumpObj(
                                                       nextOffset +
                                                         2,
                                                       v0,
                                                       maxN,
                                                       bounds,
                                                       file,
                                                       mtlFile);
                                                   bounds.
                                                     getMinimum(
                                                       ).
                                                     y =
                                                     min;
                                                   break;
                                               case 2 <<
                                                 30:
                                                   max =
                                                     bounds.
                                                       getMaximum(
                                                         ).
                                                       z;
                                                   bounds.
                                                     getMaximum(
                                                       ).
                                                     z =
                                                     split;
                                                   v0 =
                                                     dumpObj(
                                                       nextOffset,
                                                       vertOffset,
                                                       maxN,
                                                       bounds,
                                                       file,
                                                       mtlFile);
                                                   bounds.
                                                     getMaximum(
                                                       ).
                                                     z =
                                                     max;
                                                   min =
                                                     bounds.
                                                       getMinimum(
                                                         ).
                                                       z;
                                                   bounds.
                                                     getMinimum(
                                                       ).
                                                     z =
                                                     split;
                                                   v0 =
                                                     dumpObj(
                                                       nextOffset +
                                                         2,
                                                       v0,
                                                       maxN,
                                                       bounds,
                                                       file,
                                                       mtlFile);
                                                   bounds.
                                                     getMinimum(
                                                       ).
                                                     z =
                                                     min;
                                                   break;
                                               default:
                                                   v0 =
                                                     vertOffset;
                                                   break;
                                           }
                                           return v0;
                                       } }
    private static final long CLOSED = 0L << 30;
    private static final long PLANAR = 1L << 30;
    private static final long OPENED = 2L << 30;
    private static final long TYPE_MASK = 3L << 30;
    private static long pack(float split, long type,
                             int axis,
                             int object) { int f =
                                             java.lang.Float.
                                             floatToRawIntBits(
                                               split);
                                           int top =
                                             f ^
                                             (f >>
                                                31 |
                                                -2147483648);
                                           long p =
                                             ((long)
                                                top &
                                                4294967295L) <<
                                             32;
                                           p |= type;
                                           p |= (long)
                                                  axis <<
                                                  28;
                                           p |= object &
                                                  268435455L;
                                           return p;
    }
    private static int unpackObject(long p) { return (int)
                                                       (p &
                                                          268435455L);
    }
    private static int unpackAxis(long p) { return (int)
                                                     (p >>>
                                                        28) &
                                              3; }
    private static long unpackSplitType(long p) {
        return p &
          TYPE_MASK;
    }
    private static float unpackSplit(long p) { int f =
                                                 (int)
                                                   (p >>>
                                                      32 &
                                                      4294967295L);
                                               int m =
                                                 (f >>>
                                                    31) -
                                                 1 |
                                                 -2147483648;
                                               return java.lang.Float.
                                                 intBitsToFloat(
                                                   f ^
                                                     m);
    }
    private static void radix12(long[] splits, int n) {
        final int[] hist =
          new int[2048];
        final long[] sorted =
          new long[n];
        for (int i =
               0;
             i <
               n;
             i++) {
            long pi =
              splits[i];
            hist[0 +
                   ((int)
                      (pi >>>
                         28) &
                      511)]++;
            hist[512 +
                   ((int)
                      (pi >>>
                         37) &
                      511)]++;
            hist[1024 +
                   ((int)
                      (pi >>>
                         46) &
                      511)]++;
            hist[1536 +
                   (int)
                     (pi >>>
                        55)]++;
        }
        {
            int sum0 =
              0;
            int sum1 =
              0;
            int sum2 =
              0;
            int sum3 =
              0;
            int tsum;
            for (int i =
                   0;
                 i <
                   512;
                 i++) {
                tsum =
                  hist[0 +
                         i] +
                    sum0;
                hist[0 +
                       i] =
                  sum0 -
                    1;
                sum0 =
                  tsum;
                tsum =
                  hist[512 +
                         i] +
                    sum1;
                hist[512 +
                       i] =
                  sum1 -
                    1;
                sum1 =
                  tsum;
                tsum =
                  hist[1024 +
                         i] +
                    sum2;
                hist[1024 +
                       i] =
                  sum2 -
                    1;
                sum2 =
                  tsum;
                tsum =
                  hist[1536 +
                         i] +
                    sum3;
                hist[1536 +
                       i] =
                  sum3 -
                    1;
                sum3 =
                  tsum;
            }
        }
        for (int i =
               0;
             i <
               n;
             i++) {
            long pi =
              splits[i];
            int pos =
              (int)
                (pi >>>
                   28) &
              511;
            sorted[++hist[0 +
                            pos]] =
              pi;
        }
        for (int i =
               0;
             i <
               n;
             i++) {
            long pi =
              sorted[i];
            int pos =
              (int)
                (pi >>>
                   37) &
              511;
            splits[++hist[512 +
                            pos]] =
              pi;
        }
        for (int i =
               0;
             i <
               n;
             i++) {
            long pi =
              splits[i];
            int pos =
              (int)
                (pi >>>
                   46) &
              511;
            sorted[++hist[1024 +
                            pos]] =
              pi;
        }
        for (int i =
               0;
             i <
               n;
             i++) {
            long pi =
              sorted[i];
            int pos =
              (int)
                (pi >>>
                   55);
            splits[++hist[1536 +
                            pos]] =
              pi;
        }
    }
    private static class BuildTask {
        long[] splits;
        int numObjects;
        int n;
        byte[] leftRightTable;
        BuildTask(int numObjects) { super();
                                    splits = (new long[6 *
                                                         numObjects]);
                                    this.numObjects =
                                      numObjects;
                                    n = 0;
                                    leftRightTable =
                                      (new byte[(numObjects +
                                                   3) /
                                                  4]);
        }
        BuildTask(int numObjects, org.sunflow.core.accel.KDTree.BuildTask parent) {
            super(
              );
            splits =
              (new long[6 *
                          numObjects]);
            this.
              numObjects =
              numObjects;
            n =
              0;
            leftRightTable =
              parent.
                leftRightTable;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "OA2f1wBhT/PVgRPXXuQG+OurjxjvP/TMx5EDh/jO8SZkTkEf4ObhjQg3hz4+" +
           "R7WbPd4qjKPrD+f2fP/Unn1cq2ZvSV0DHeOLv/jnm5Gjv/5JEcwvk61G8l7P" +
           "Zk7y7g03aPXTDT842FzWBVDRjUJZVd6Vxd1Jt0ToocxswrVZTnPDBtym0Y0h" +
           "KLAA9oAN38fUEPLKICup6O+H6GOu6UZM71a52uS4dPCdm3Vbbr5yi5nr7bPd" +
           "ALFB1Lmvm+jjburrKf6KtlY0+4HuvosbH21ULt4GiTGQCFXRNDcZUE9zHjix" +
           "qCsm/PJHr7bseLsMBbtQtaKJyS6RITOqAkjEZj+U4pz+4AqODUMULBqZqajA" +
           "+IIBmp4ziyf+moxOWKqOfG/Kd5adHL3CoElnIloLYXfMgqax4rBLn/PoY2Eh" +
           "qpVi9e1gkJd/+nMpG5z6n/cYTIsvjhMSW+mjl02tpY8+7qv1n9KtdOBhnU9M" +
           "Z4PltJPytC3sZOtUztM/W/rzk18/PMTTbhwQ8fFN/fsmJbH3t38rCE/WKBTB" +
           "FR9/TDhzYlrn8uuM36nYlDucK+z+oOtxeO85nflrsL3yx0E0IYYaJeskuUVU" +
           "srQOxuD0ZNrHSzhteua9JyHe9nfkO5IZfmBzLevvFdx4UU482OBrD1ogyI5Y" +
           "wXbEH6cBxD7S44ZqKW6CKk1dkYnpvebIFyJW9zjsPVpz6YfmN35/ge9zsTLn" +
           "O1idOhmSPshcYmWOLnZ/Xq1ZVIswqLPNUmub3yhQZ27pSHJpNfrNOW89Pjrn" +
           "NwySQrIJ/oaCWOSo6OK5eebq9ct1rWdZr1dO66oF094zduER2nMyZjY10IfG" +
           "82WJVavo6/Ou7+UEGhZNTfvrC/25GpBJR8VnHABimd1/p8wWvds+BQQdtfx7" +
           "tETQ7B43aEpxE1QN1ZSHPuNa6lP1sU+oaj0scsxa7FgJVfeOq2opbqisajEN" +
           "n/qEGraB7OPWGsdLaPj0uBqW4iaoXsEp0iun+8lm2qwyViUvoBZZms3kAvib" +
           "oL5Pe2bW7cZJ2GzIgGEK3gC12D6K/z/Ecl8zc79251RJDBP8X6bKM+PsLp+a" +
           "x54L6OMzvDwTNAFMGIR2mGIiu9xzDjKsOjb7b0H8JX+6XVYN1Frqoop1qmN7" +
           "D40mN72w2EbGB2FJ6/7QLYegqnwjYDcOreM2DrDy1IKLTH75Jp0dbQhNGX3k" +
           "XY569gVZLZwsUllFcdci13elbuCUzJSs5ZVJZ69vwcmpuCYEVbA3U/gUpz5D" +
           "UKOfGnaavtxk5wiqcZER2kWzLzfRBWjWgYh+flu3vdLIWkFakSMclnIB747k" +
           "Q2PynRLftYlzPBWI3SPbJS/Lb5Lj0rnRdRt337r/BX7+lhRxZIRKqYFiwa8C" +
           "8rccs0tKs2VVrp1/u/581Vw7LJq4wk5wT3c1fg9DFOq0DZ7mO6Wa4fxh9f2x" +
           "Za/8dH/lZSiOW1FAJGji1sLeJadnIV63RguPOlBL2fG5Y/7x4eWLUn/+gHXS" +
           "iB+NZpSmh97s2fe6zw98tIJdXFZAxOMca6pWD6u9WBo0POemehqLIr1RZn6w" +
           "3FeXH6W3NQS1Fx4ZC++44JQxhI1VWlZNWiW9xhnxXGhb8V2d1XUfgzPiqvOd" +
           "HKQ49JbFoxt03T5Rx3QGAatLI9Ml9kkfr/0baBlWqFIaAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private void buildTree(float minx, float maxx,
                           float miny,
                           float maxy,
                           float minz,
                           float maxz,
                           org.sunflow.core.accel.KDTree.BuildTask task,
                           int depth,
                           org.sunflow.util.IntArray tempTree,
                           int offset,
                           org.sunflow.util.IntArray tempList,
                           org.sunflow.core.accel.KDTree.BuildStats stats) {
        if (task.
              numObjects >
              maxPrims &&
              depth <
              MAX_DEPTH) {
            float dx =
              maxx -
              minx;
            float dy =
              maxy -
              miny;
            float dz =
              maxz -
              minz;
            float bestCost =
              INTERSECT_COST *
              task.
                numObjects;
            int bestAxis =
              -1;
            int bestOffsetStart =
              -1;
            int bestOffsetEnd =
              -1;
            float bestSplit =
              0;
            boolean bestPlanarLeft =
              false;
            int bnl =
              0;
            int bnr =
              0;
            float area =
              dx *
              dy +
              dy *
              dz +
              dz *
              dx;
            float ISECT_COST =
              INTERSECT_COST /
              area;
            int[] nl =
              { 0,
            0,
            0 };
            int[] nr =
              { task.
                  numObjects,
            task.
              numObjects,
            task.
              numObjects };
            float[] dp =
              { dy *
              dz,
            dz *
              dx,
            dx *
              dy };
            float[] ds =
              { dy +
              dz,
            dz +
              dx,
            dx +
              dy };
            float[] nodeMin =
              { minx,
            miny,
            minz };
            float[] nodeMax =
              { maxx,
            maxy,
            maxz };
            int nSplits =
              task.
                n;
            long[] splits =
              task.
                splits;
            byte[] lrtable =
              task.
                leftRightTable;
            for (int i =
                   0;
                 i <
                   nSplits;
                 ) {
                long ptr =
                  splits[i];
                float split =
                  unpackSplit(
                    ptr);
                int axis =
                  unpackAxis(
                    ptr);
                int currentOffset =
                  i;
                int pClosed =
                  0;
                int pPlanar =
                  0;
                int pOpened =
                  0;
                long ptrMasked =
                  ptr &
                  (~TYPE_MASK &
                     -268435456L);
                long ptrClosed =
                  ptrMasked |
                  CLOSED;
                long ptrPlanar =
                  ptrMasked |
                  PLANAR;
                long ptrOpened =
                  ptrMasked |
                  OPENED;
                while (i <
                         nSplits &&
                         (splits[i] &
                            -268435456L) ==
                         ptrClosed) {
                    int obj =
                      unpackObject(
                        splits[i]);
                    lrtable[obj >>>
                              2] =
                      0;
                    pClosed++;
                    i++;
                }
                while (i <
                         nSplits &&
                         (splits[i] &
                            -268435456L) ==
                         ptrPlanar) {
                    int obj =
                      unpackObject(
                        splits[i]);
                    lrtable[obj >>>
                              2] =
                      0;
                    pPlanar++;
                    i++;
                }
                while (i <
                         nSplits &&
                         (splits[i] &
                            -268435456L) ==
                         ptrOpened) {
                    int obj =
                      unpackObject(
                        splits[i]);
                    lrtable[obj >>>
                              2] =
                      0;
                    pOpened++;
                    i++;
                }
                nr[axis] -=
                  pPlanar +
                    pClosed;
                if (split >=
                      nodeMin[axis] &&
                      split <=
                      nodeMax[axis]) {
                    float dl =
                      split -
                      nodeMin[axis];
                    float dr =
                      nodeMax[axis] -
                      split;
                    float lp =
                      dp[axis] +
                      dl *
                      ds[axis];
                    float rp =
                      dp[axis] +
                      dr *
                      ds[axis];
                    boolean planarLeft =
                      dl <
                      dr;
                    int numLeft =
                      nl[axis] +
                      (planarLeft
                         ? pPlanar
                         : 0);
                    int numRight =
                      nr[axis] +
                      (planarLeft
                         ? 0
                         : pPlanar);
                    float eb =
                      numLeft ==
                      0 &&
                      dl >
                      0 ||
                      numRight ==
                      0 &&
                      dr >
                      0
                      ? EMPTY_BONUS
                      : 0;
                    float cost =
                      TRAVERSAL_COST +
                      ISECT_COST *
                      (1 -
                         eb) *
                      (lp *
                         numLeft +
                         rp *
                         numRight);
                    if (cost <
                          bestCost) {
                        bestCost =
                          cost;
                        bestAxis =
                          axis;
                        bestSplit =
                          split;
                        bestOffsetStart =
                          currentOffset;
                        bestOffsetEnd =
                          i;
                        bnl =
                          numLeft;
                        bnr =
                          numRight;
                        bestPlanarLeft =
                          planarLeft;
                    }
                }
                nl[axis] +=
                  pOpened +
                    pPlanar;
            }
            for (int axis =
                   0;
                 axis <
                   3;
                 axis++) {
                int numLeft =
                  nl[axis];
                int numRight =
                  nr[axis];
                if (numLeft !=
                      task.
                        numObjects ||
                      numRight !=
                      0)
                    org.sunflow.system.UI.
                      printError(
                        org.sunflow.system.UI.Module.
                          ACCEL,
                        ("Didn\'t scan full range of objects @depth=%d. Left overs for" +
                         " axis %d: [L: %d] [R: %d]"),
                        depth,
                        axis,
                        numLeft,
                        numRight);
            }
            if (bestAxis !=
                  -1) {
                org.sunflow.core.accel.KDTree.BuildTask taskL =
                  new org.sunflow.core.accel.KDTree.BuildTask(
                  bnl,
                  task);
                org.sunflow.core.accel.KDTree.BuildTask taskR =
                  new org.sunflow.core.accel.KDTree.BuildTask(
                  bnr,
                  task);
                int lk =
                  0;
                int rk =
                  0;
                for (int i =
                       0;
                     i <
                       bestOffsetStart;
                     i++) {
                    long ptr =
                      splits[i];
                    if (unpackAxis(
                          ptr) ==
                          bestAxis) {
                        if (unpackSplitType(
                              ptr) !=
                              CLOSED) {
                            int obj =
                              unpackObject(
                                ptr);
                            lrtable[obj >>>
                                      2] |=
                              1 <<
                                ((obj &
                                    3) <<
                                   1);
                            lk++;
                        }
                    }
                }
                for (int i =
                       bestOffsetStart;
                     i <
                       bestOffsetEnd;
                     i++) {
                    long ptr =
                      splits[i];
                    assert unpackAxis(
                             ptr) ==
                      bestAxis;
                    if (unpackSplitType(
                          ptr) ==
                          PLANAR) {
                        if (bestPlanarLeft) {
                            int obj =
                              unpackObject(
                                ptr);
                            lrtable[obj >>>
                                      2] |=
                              1 <<
                                ((obj &
                                    3) <<
                                   1);
                            lk++;
                        }
                        else {
                            int obj =
                              unpackObject(
                                ptr);
                            lrtable[obj >>>
                                      2] |=
                              2 <<
                                ((obj &
                                    3) <<
                                   1);
                            rk++;
                        }
                    }
                }
                for (int i =
                       bestOffsetEnd;
                     i <
                       nSplits;
                     i++) {
                    long ptr =
                      splits[i];
                    if (unpackAxis(
                          ptr) ==
                          bestAxis) {
                        if (unpackSplitType(
                              ptr) !=
                              OPENED) {
                            int obj =
                              unpackObject(
                                ptr);
                            lrtable[obj >>>
                                      2] |=
                              2 <<
                                ((obj &
                                    3) <<
                                   1);
                            rk++;
                        }
                    }
                }
                long[] splitsL =
                  taskL.
                    splits;
                long[] splitsR =
                  taskR.
                    splits;
                int nsl =
                  0;
                int nsr =
                  0;
                for (int i =
                       0;
                     i <
                       nSplits;
                     i++) {
                    long ptr =
                      splits[i];
                    int obj =
                      unpackObject(
                        ptr);
                    int idx =
                      obj >>>
                      2;
                    int mask =
                      1 <<
                      ((obj &
                          3) <<
                         1);
                    if ((lrtable[idx] &
                           mask) !=
                          0) {
                        splitsL[nsl] =
                          ptr;
                        nsl++;
                    }
                    if ((lrtable[idx] &
                           mask <<
                           1) !=
                          0) {
                        splitsR[nsr] =
                          ptr;
                        nsr++;
                    }
                }
                taskL.
                  n =
                  nsl;
                taskR.
                  n =
                  nsr;
                task.
                  splits =
                  (splits =
                     (splitsL =
                        (splitsR =
                           null)));
                task =
                  null;
                int nextOffset =
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
                tempTree.
                  add(
                    0);
                tempTree.
                  set(
                    offset +
                      0,
                    bestAxis <<
                      30 |
                      nextOffset);
                tempTree.
                  set(
                    offset +
                      1,
                    java.lang.Float.
                      floatToRawIntBits(
                        bestSplit));
                stats.
                  updateInner(
                    );
                switch (bestAxis) {
                    case 0:
                        buildTree(
                          minx,
                          bestSplit,
                          miny,
                          maxy,
                          minz,
                          maxz,
                          taskL,
                          depth +
                            1,
                          tempTree,
                          nextOffset,
                          tempList,
                          stats);
                        taskL =
                          null;
                        buildTree(
                          bestSplit,
                          maxx,
                          miny,
                          maxy,
                          minz,
                          maxz,
                          taskR,
                          depth +
                            1,
                          tempTree,
                          nextOffset +
                            2,
                          tempList,
                          stats);
                        taskR =
                          null;
                        return;
                    case 1:
                        buildTree(
                          minx,
                          maxx,
                          miny,
                          bestSplit,
                          minz,
                          maxz,
                          taskL,
                          depth +
                            1,
                          tempTree,
                          nextOffset,
                          tempList,
                          stats);
                        taskL =
                          null;
                        buildTree(
                          minx,
                          maxx,
                          bestSplit,
                          maxy,
                          minz,
                          maxz,
                          taskR,
                          depth +
                            1,
                          tempTree,
                          nextOffset +
                            2,
                          tempList,
                          stats);
                        taskR =
                          null;
                        return;
                    case 2:
                        buildTree(
                          minx,
                          maxx,
                          miny,
                          maxy,
                          minz,
                          bestSplit,
                          taskL,
                          depth +
                            1,
                          tempTree,
                          nextOffset,
                          tempList,
                          stats);
                        taskL =
                          null;
                        buildTree(
                          minx,
                          maxx,
                          miny,
                          maxy,
                          bestSplit,
                          maxz,
                          taskR,
                          depth +
                            1,
                          tempTree,
                          nextOffset +
                            2,
                          tempList,
                          stats);
                        taskR =
                          null;
                        return;
                    default:
                        assert false;
                }
            }
        }
        int listOffset =
          tempList.
          getSize(
            );
        int n =
          0;
        for (int i =
               0;
             i <
               task.
                 n;
             i++) {
            long ptr =
              task.
                splits[i];
            if (unpackAxis(
                  ptr) ==
                  0 &&
                  unpackSplitType(
                    ptr) !=
                  CLOSED) {
                tempList.
                  add(
                    unpackObject(
                      ptr));
                n++;
            }
        }
        stats.
          updateLeaf(
            depth,
            n);
        if (n !=
              task.
                numObjects)
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  ACCEL,
                "Error creating leaf node - expecting %d found %d",
                task.
                  numObjects,
                n);
        tempTree.
          set(
            offset +
              0,
            3 <<
              30 |
              listOffset);
        tempTree.
          set(
            offset +
              1,
            task.
              numObjects);
        task.
          splits =
          null;
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
          (java.lang.Float.
             floatToRawIntBits(
               dirX) &
             1 <<
             31) >>>
          30;
        int offsetYFront =
          (java.lang.Float.
             floatToRawIntBits(
               dirY) &
             1 <<
             31) >>>
          30;
        int offsetZFront =
          (java.lang.Float.
             floatToRawIntBits(
               dirZ) &
             1 <<
             31) >>>
          30;
        int offsetXBack =
          offsetXFront ^
          2;
        int offsetYBack =
          offsetYFront ^
          2;
        int offsetZBack =
          offsetZFront ^
          2;
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
            int tn =
              tree[node];
            int axis =
              tn &
              3 <<
              30;
            int offset =
              tn &
              ~(3 <<
                  30);
            switch (axis) {
                case 0:
                    {
                        float d =
                          (java.lang.Float.
                             intBitsToFloat(
                               tree[node +
                                      1]) -
                             orgX) *
                          invDirX;
                        int back =
                          offset +
                          offsetXBack;
                        node =
                          back;
                        if (d <
                              intervalMin)
                            continue;
                        node =
                          offset +
                            offsetXFront;
                        if (d >
                              intervalMax)
                            continue;
                        stack[stackPos].
                          node =
                          back;
                        stack[stackPos].
                          near =
                          d >=
                            intervalMin
                            ? d
                            : intervalMin;
                        stack[stackPos].
                          far =
                          intervalMax;
                        stackPos++;
                        intervalMax =
                          d <=
                            intervalMax
                            ? d
                            : intervalMax;
                        continue;
                    }
                case 1 <<
                  30:
                    {
                        float d =
                          (java.lang.Float.
                             intBitsToFloat(
                               tree[node +
                                      1]) -
                             orgY) *
                          invDirY;
                        int back =
                          offset +
                          offsetYBack;
                        node =
                          back;
                        if (d <
                              intervalMin)
                            continue;
                        node =
                          offset +
                            offsetYFront;
                        if (d >
                              intervalMax)
                            continue;
                        stack[stackPos].
                          node =
                          back;
                        stack[stackPos].
                          near =
                          d >=
                            intervalMin
                            ? d
                            : intervalMin;
                        stack[stackPos].
                          far =
                          intervalMax;
                        stackPos++;
                        intervalMax =
                          d <=
                            intervalMax
                            ? d
                            : intervalMax;
                        continue;
                    }
                case 2 <<
                  30:
                    {
                        float d =
                          (java.lang.Float.
                             intBitsToFloat(
                               tree[node +
                                      1]) -
                             orgZ) *
                          invDirZ;
                        int back =
                          offset +
                          offsetZBack;
                        node =
                          back;
                        if (d <
                              intervalMin)
                            continue;
                        node =
                          offset +
                            offsetZFront;
                        if (d >
                              intervalMax)
                            continue;
                        stack[stackPos].
                          node =
                          back;
                        stack[stackPos].
                          near =
                          d >=
                            intervalMin
                            ? d
                            : intervalMin;
                        stack[stackPos].
                          far =
                          intervalMax;
                        stackPos++;
                        intervalMax =
                          d <=
                            intervalMax
                            ? d
                            : intervalMax;
                        continue;
                    }
                default:
                    {
                        int n =
                          tree[node +
                                 1];
                        while (n >
                                 0) {
                            primitiveList.
                              intersectPrimitive(
                                r,
                                primitives[offset],
                                state);
                            n--;
                            offset++;
                        }
                        if (r.
                              getMax(
                                ) <
                              intervalMax)
                            return;
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
        }
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
      ("H4sIAAAAAAAAALV7e9DzWHmf3293v72w7A32wrJXdrmafrIsW7JZAsjyRbZl" +
       "XSxZslVgkXWxZV2tu0RJWDIBJnQIU5aUtrDTJqQlzAZSpkyTdtJZ2mkSBppp" +
       "MjRtwzSQTGdKSpiBP5pkSlsqye/t8/d+L/uy4BkdSzq33+85z/Oc59jnPP/d" +
       "yk2+V6m6jpmuTCe4oibBlY3ZvBKkrupfGRFNWvJ8VcFMyfe5/N3T8mt+886/" +
       "+sHH1nddqlwWK6+QbNsJpEB3bH+q+o4ZqQpRufPkbc9ULT+o3EVspEgCwkA3" +
       "AUL3g6eIystOVQ0qTxJHEIAcApBDAEoIAHpSKq/0ctUOLayoIdmBv638bOWA" +
       "qFx25QJeUHn86kZcyZOsw2bokkHewi3FM5+TKisnXuWxY+47ztcQ/kQVePbv" +
       "v/uuL95QuVOs3KnbbAFHzkEEeSdi5XZLtZaq56OKoipi5W5bVRVW9XTJ1LMS" +
       "t1i5x9dXthSEnnospOJl6Kpe2eeJ5G6XC25eKAeOd0xP01VTOXq6STOlVc71" +
       "vhOuO4b94n1O8DY9B+ZpkqweVbnR0G0lqDy6X+OY45PjvEBe9WZLDdbOcVc3" +
       "2lL+onLPbuxMyV4BbODp9iovepMT5r0ElQev22gha1eSDWmlPh1UHtgvR++y" +
       "8lK3loIoqgSVe/eLlS3lo/Tg3iidGp/vkm/96Htt3L5UYlZU2Szw35JXemSv" +
       "0lTVVE+1ZXVX8fY3Eb8s3fc7H75UqeSF790rvCvzL//O99/x5kde+P1dmVef" +
       "UYZablQ5eFr+zPKOP3wIe2P7hgLGLa7j68XgX8W8VH/6MOepxM0t777jFovM" +
       "K0eZL0x/d/H+z6nfuVS5bVi5LDtmaOV6dLfsWK5uqt5AtVVPClRlWLlVtRWs" +
       "zB9Wbs7vCd1Wd28pTfPVYFi50SxfXXbK51xEWt5EIaKb83vd1pyje1cK1uV9" +
       "4lYqlZvzq9LIr1dUdp/yO6gMgbVjqYCrA7TnFNR9QLWDZS7WNeCHtmY6MeB7" +
       "MuB4q+Nn2fFUQJJl1QTGXc5T1SuFSrk/ycaSAvld8cFBLtSH9k3azK0Bd0xF" +
       "9Z6Wnw07ve9//umvXjpW8UPOQeXhvJsrh91cKbq5UnZzZddN5eCgbP2VRXe7" +
       "4cqFbeRmmzu029/Ivmv0ng+/5oZcT9z4xlxSl/KiwPX9KnZi6MPSncm5tlVe" +
       "+GT8DP9ztUuVS1c7yAJi/uq2ojpduLVj9/XkvmGc1e6dH/r2X33hl9/nnJjI" +
       "VR730HKvrVlY3mv2hek5sqrkvuyk+Tc9Jn3p6d9535OXKjfm5py7sEDKVS73" +
       "Do/s93GVBT515M0KLjflhDXHsySzyDpyQbcFa8+JT96Uo3xHeX93LuOXFSpZ" +
       "3DxxqKPld5H7CrdIX7nTimLQ9liU3vJnWPfT/+UP/gIqxX3kWO88NVWxavDU" +
       "KWMuGruzNNu7T3SgUI283H/7JP3xT3z3Q3+7VIC8xBNndfhkkWK5EedDmIv5" +
       "F35/+1+/+aef+fqlY6U5CPLZLFyaupwckyzeV247h2Te2+tO8OTOwMwNqdCa" +
       "J2e25Si6pktLUy209P/c+VrwS3/50bt2emDmb47U6M0/uoGT96/qVN7/1Xf/" +
       "9SNlMwdyMRmdyOyk2M7DveKkZdTzpLTAkTzzRw//g9+TPp37ytw/+Xqmli6n" +
       "UsqgUg4aUPJ/U5le2csDi+RR/7TyX21fp4KGp+WPff17L+e/92++X6K9Ouo4" +
       "PdYTyX1qp15F8liSN3//vqXjkr/OyzVeIN95l/nCD/IWxbzF3Ef4PuXl3iW5" +
       "SjMOS9908598+d/d954/vKFyqV+5zXQkpS+VRla5Nddu1V/njilx3/6O3eDG" +
       "t+TJXSXVyjXkyxcPXqv+rz/UjNefrf5F+niRvPZapbpe1T3xH+zUMxfKG8+J" +
       "FT3dyg0lOpxfgffd803jU9/+jd3cuT8Z7xVWP/zsL/7wykefvXQqYnnimqDh" +
       "dJ1d1FJSfPmO1w/zz0F+/b/iKvgUL3az1j3Y4dT52PHc6brFGD9+Hqyyi/7/" +
       "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" +
       "bBowydaiqqwgISNyw3VjuKZ3gWa/zWoI0TbhFtJhQQlnOX1eQ/CRNOvgQrc+" +
       "4EaJCfWWkYA1jKDqjVdJqyqTEwqc2jwlUj16qZngjFmato1AcUDP+yk4xVcG" +
       "EOnUdLVElEFHmTU6U9ThhMagtllnrLRkRgOh5aGNTp/nYiONvGFCbBRcmQue" +
       "0ZrIfmOpZLEEbSedKY/Sc9kKFj7fbgmwsqZcGZlEWzGJ3UFrBLgggjThiARo" +
       "1+4s5Vafl5qjaFSVMhapMsIA3AzMLU4o/WVDTJftmA2r+IABVTWDYoHV4wgc" +
       "oBvXglCqjfVRmpprEDJdttuwXG0TDSnV1rV0sSLpbm+iGL4h6rRu0JPOSKLa" +
       "y2kHWBNrb0DPA7KxWRHV8QIcxl5nIgvdtlvdLnoJ0ISzOQ+hbSMlcAWmN0mH" +
       "2zRbYDRyl9VGazwZjPSF0Ygyd0EtZg2YaaVNXHbCCCMDZuMDdL9qhloOftRG" +
       "4ZlkbJZjgRzFG3TlkbQwoYO5DzCzDAm4CWcP5G4AINE6TTgzaSnbOeT6SZVs" +
       "cEhGBnI8MRWwDWGgkylpe7LJVbVKFP/DOavBmGQQl2vTYjUyIwVA12OcwQjG" +
       "svAabGBDa5rRfs+lxxAUiDVAWM6369w6EZawfMwxqBVTSyfrestKtpt4PBMR" +
       "KQEjnIJMo89mszjvZGmLbBfV4wCaz4PxJLEXdajVaFcHoFJtNw3IEhODmzUb" +
       "1VVfFDOPXbVWm46yks2kOkdcvj3nVikeNpbmZGNlop006rkpm300TSdsKFOY" +
       "VWeVjB/QfrebzK0+vEHTVr05Agg+5uU63VIHcsdOqVDcGBkpeyjUQqpjWrIQ" +
       "bKGtiFibAVG/A2ZUl5Ot+rI/9f2UWeCWs1B9briy/BY4JMab9rYWQNm6gWca" +
       "OsiSJhaQSoi005CyJGieyK3VOlN5mGnCSNepJWFXXyxny9BkpHo8WIN5INHF" +
       "N1VAlNn5fLtZQHNrizflTpsAACiUxCW0aTKL3jCfKxOesZp25iPBoI4w1W24" +
       "1exRsOR7eIbqioulAdtRTUnQMGLaw0Rs0kYoxx9BI3MgIJw/ICc90+lrMpbP" +
       "JshqrfcnQmB5tazjNhqUpYrEBstIiaSb+lAO/dhdOaNkupZyoya9DAJhrdoM" +
       "EW8ZeOMJg8SDXrWtakBoLuSo2oZwlcv6o6iFcSHr0gknthu1/lJQq2nVQfys" +
       "Kyz9zEigHpNya5BDHKg96zcE2eYW/BCejt2+VKs1xpO1a5PhYNEBjToa9IWu" +
       "ZkWTtlIDUDTaGEuRzVLVG3iCCrQQSKIWGxrvibEbJQQisk3ZTyHBUmum1+ms" +
       "yZSSfVCHMXfCIR2rzpOUOZluOFu36kMjD1kYr0OPqojeHJjDfAUpyxqgTWYZ" +
       "nc1DgCK7ET0heiJoQ3OOhoS5DsOmPSD761kTFF1hKYFExswsZz3K5ZIulk3L" +
       "qOEG01/M2GBkzZddZEBF+FbEiBHBTrRGNx7Ol7bVijQAZmk50hY8ubUEFrXi" +
       "jtsHdS8Mt62gWg0UsCrP5i0Ay0LC0Pxg7JtKk1KjxpwSmqsMHBtxTQlCPoHw" +
       "RjQ05j6eeFId17Awn2VzsyJYC8vG02A97FCusWWJWNxYYwZc1zUMDJ2BXVVF" +
       "fpv20NgWmmMXm6hpCgED3tgydVFTuo2BYKEYPm82OxyZ0fxANaOMyKrtRgsc" +
       "mb7tGxwWDcWkb+T9dzaw1OQBBQp4VZPSKI9pKZys1eKpQDX8NhSifFWEQo3R" +
       "KNqUWrSf1ufdVb8pQHyzL24zXVBlty5JPDSyF6pAVeGp4vCYN5x0m9uxhwZN" +
       "ZSMbfAPzdWXDQXqjq4PAmuJkzkOjdcPTA3/RJleyl7hyfxLG7WWXlDXd5oxq" +
       "Fw+7aEOYcTBfDWYga1uzCW9E4JZwkdXWrWLbBrxFejAO8hEGcryHiCPRmvLJ" +
       "bCPhjkOqvL+czOVkk4GaDaNtHa6NNoEOdNS0OWmjatT20KlMbgXDWAT6gICG" +
       "ktHBqdp2OtfY2jblNR6ukY2RtcG1MMwQxlr6WMZ1i35Sc4R19L6tLJ2WHjSh" +
       "5tBJUyEcig2PnE0ZMZC36ybTXERNK8I5L/YUbR5Fytwax3BKMMlmOEYteKvM" +
       "NqALTYTqIqiS7amAQAgsEcuM8vOgKgK6s9mChSx40O0Si/XGAJa0ho8iFG1z" +
       "3Djz6+oqkqpAJNRWULBc0i1su7TQXiLztbDaAHRwMhvYox5I43GH7rUwqdk3" +
       "XZjAwpHYSLs8NiczI9yCERJskJqMeFkcbDo+1t+OFg2+v9zCKraY0MYUgpmq" +
       "ZGAGCtUCJsZEHZx21rZFh3ACqOao3m9GJL/WYlxqqSo3gXEKSEaRParXuXky" +
       "sbbCJtqs6nK/DgQIZ9lRs9OJmtsVI2tdUMBAMOxsal2KiZhmNHetGjNvktZg" +
       "CiutyG6E0XIRT5aYA4F8A5BxYrnZ2HS/tw2D0dy25P4IplKs0QDFRne8Inuo" +
       "Q6xrDOwuahDeC3GeF6xVLgMUGCvYdNsebGHTtJuEtoirZMfaAAsO6w/bgwRi" +
       "4KE190NZ7G+ArGu21G1Ug5hJa7CtUVZrTAOk08yXKU4w5WdGfQ7UcakJIPVo" +
       "DK0GFBx1ku4S7WmcIvW1+azDWVWiHUmQlwB0p+Gse71YNRiyRaOWk3ndGQVP" +
       "UB7fZEQr0ZJ2tc/qErkyW9mqN/TrAcHVHIVeQ3SAiTwVu01rC+PWEPfDQE1d" +
       "y2PaWj7P08t60naRensx97civKJZpYvWw2AdLAb1XFN8S1NdCspDeWmohFhL" +
       "wMNWCPPAIh1wzZW6MPFeoC+Hge+12EZk67CwnZp85gjWsDtN0mXu06BGV+lC" +
       "w0FfEXpANdvyoG6G4zaHaDJpVZtJHmKG7VG7j4ANu+4ZjlYfqNv6ykhxiUq3" +
       "1dlYsdsibwUGuRiv60aTgJuQitiduMXb1X5KENYKG3ljNoNRH3EieJhy1ThR" +
       "Olsutee1TafW0yVvQTnQljBUqaPMW/G8Kc5SvmfANG7LNdJYtFvEIMKmg4bn" +
       "YZOIHaKRmQBprkOtcbRl5G5/g8jZgFz0GZIdsxyZB9Kky86QVZwaVG8Q2ii6" +
       "FnBR0Top6HWdRnc6xPPFbJvfNGsmN+qx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "8xcQzzlT3O1lgdu3Ry77zORownr9uafonuwU0zon+caJseeVXnW6UnmyYmgH" +
       "5Y72slghmI8flX3Di+igOKTrl+L+2DlD8cki+UgeH5axRlF7bzD+7kuNptq5" +
       "Qv38ru7u+yKDcXY0tbfR/JXXSGMqpUeZr7kms9jk6Pm7A1qFkMotVQe/co6Q" +
       "Plskn86FpB9V3RPScxc6rxJULu8Gqjgc9sA1h693B4blzz935y33Pzf7z7sT" +
       "DEeHem8lKrdooWmePrhx6v6yW25gK0vujnG4JYMvBJX7ztaZPMwsvwuYB5/f" +
       "lf5iULlrv3QecRRfp4t9KXdyp4rl9nx4d7rQbwWVG/JCxe1vu0eDcmpj3W56" +
       "T3bB3gOn9ahced3zoyR7XOX0gcPirEB59v1oX3+4O/3+tPyF50bke78P/9ru" +
       "wKNsSllWtHILUbl5d/aybLQ4G/D4dVs7ausy/sYf3PGbt772aJl1xw7wiU6f" +
       "wvbo2acLe5YblOcBs9+6/1+89Z8996fltuL/D9SEB9yUQAAA");
}
