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
          1456093649000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "O5p3sVf7PzFuKIO8IQAA");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "3wO38S2+V42o1tGPlaZ4ZS1mmWsMto11ze0u1uyW2zSJTZJw3ApfdonWmFDG" +
           "ieL3lbLLTwyPraxjLI228bLHTJbzQMdXw/GwajEKLdqJ3ekM8VWwcqVpQjGu" +
           "b9Ay0l0ulLRtroRhkA7bjsiJsjuGU7iPJuhiZplTwUZjtLeowCUThj24VDJL" +
           "U7PR1GhZlgVj5WcuHYVlMq4QKy4WV+5oOuDyVK6Q0RCtV0d86C3slNvUB8uU" +
           "LvexmhptZ/SybIqMNOXkQc1dqm11zNGOup0OwQsvBW0FMTaCW+/6GKkiylh2" +
           "CEkWujNdHXdbbkWQVXxBt5R+bTIgGI5rzoX+uOO3lgur13Hg2GxWhlSHc1B9" +
           "ES6pJrIcG3XUbjuVoOv0JUav4BNE4Dt9sTmqDsOuMmwqS22d6aieOHU7I6PN" +
           "piIgiO1W2gtl6bZxVdVXcFjNgl6iunV8OWXcurIJp5WK5aywSpkUcIlwF3VE" +
           "UONUHSZlh57Ps6wz5gSvMacXCj8ctBacasTDlhlYUj9ZkqicEFHKSSRG4ZQ9" +
           "Wuk1mui7YjlVyuFovd12ifaMK9f6lTlGq6W4zNKtTDHdjI8M1Ok11xktIGJ9" +
           "1WXKXFWbt+Y+OdQXLX880YUystLBhC4HmWutZQYVpcFIImUz1SnEiRlHENbE" +
           "ptbY4kCrCDLYuEo9VtpIm9v2F/0m2l/VTJtwJ7BUmwqBgA1jfTaSZLvai/T2" +
           "WvS7c3oZ4OZ2MAXfH6Fs0SN7hg1Mqo64DbzltnSHUSO5UWKZWFySeAtZLyVR" +
           "MBImrvZCVUJa8kolWrVVf9EqaV0SiQWeTlZKXPE7Zr3eDbtMvaVuW5U2S236" +
           "zYDPXBmXsjSWNzOxJNXiSY+tsZV6uysMh2u67kZUWrXW3bGnNANcbArLqNXo" +
           "VJvE1JY5AZsMer4/bDXkuRmp7VozSSdSVIkHcGnj087QYlRHywxJVvRG5PHV" +
           "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" +
           "AeVXR8VlLAAA");
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
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "alXU8rCf6o0mLjJ8BWpZgUw2kpaJAzFv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "AA==");
}
