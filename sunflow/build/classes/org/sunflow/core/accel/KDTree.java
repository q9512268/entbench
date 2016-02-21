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
          1447328137000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "nZ0BVlK5+7+cBlfG8CAAAA==");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "9l++85d/8J++/tVyg/r/AhoIpNxBLAAA");
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
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "QHr8GQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "U9/O7nX+G8mpWHd1JgAA");
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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "g5rd7AzNONKVhcu22SLVqpi9UnFdLRet");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
