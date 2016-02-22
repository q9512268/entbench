package org.sunflow.core.bucket;
public class SpiralBucketOrder implements org.sunflow.core.BucketOrder {
    public int[] getBucketSequence(int nbw, int nbh) { int[] coords = new int[2 *
                                                                                nbw *
                                                                                nbh];
                                                       for (int i =
                                                              0;
                                                            i <
                                                              nbw *
                                                              nbh;
                                                            i++) {
                                                           int bx;
                                                           int by;
                                                           int center =
                                                             (java.lang.Math.
                                                                min(
                                                                  nbw,
                                                                  nbh) -
                                                                1) /
                                                             2;
                                                           int nx =
                                                             nbw;
                                                           int ny =
                                                             nbh;
                                                           while (i <
                                                                    nx *
                                                                    ny) {
                                                               nx--;
                                                               ny--;
                                                           }
                                                           int nxny =
                                                             nx *
                                                             ny;
                                                           int minnxny =
                                                             java.lang.Math.
                                                             min(
                                                               nx,
                                                               ny);
                                                           if ((minnxny &
                                                                  1) ==
                                                                 1) {
                                                               if (i <=
                                                                     nxny +
                                                                     ny) {
                                                                   bx =
                                                                     nx -
                                                                       minnxny /
                                                                       2;
                                                                   by =
                                                                     -minnxny /
                                                                       2 +
                                                                       i -
                                                                       nxny;
                                                               }
                                                               else {
                                                                   bx =
                                                                     nx -
                                                                       minnxny /
                                                                       2 -
                                                                       (i -
                                                                          (nxny +
                                                                             ny));
                                                                   by =
                                                                     ny -
                                                                       minnxny /
                                                                       2;
                                                               }
                                                           }
                                                           else {
                                                               if (i <=
                                                                     nxny +
                                                                     ny) {
                                                                   bx =
                                                                     -minnxny /
                                                                       2;
                                                                   by =
                                                                     ny -
                                                                       minnxny /
                                                                       2 -
                                                                       (i -
                                                                          nxny);
                                                               }
                                                               else {
                                                                   bx =
                                                                     -minnxny /
                                                                       2 +
                                                                       (i -
                                                                          (nxny +
                                                                             ny));
                                                                   by =
                                                                     -minnxny /
                                                                       2;
                                                               }
                                                           }
                                                           coords[2 *
                                                                    i +
                                                                    0] =
                                                             bx +
                                                               center;
                                                           coords[2 *
                                                                    i +
                                                                    1] =
                                                             by +
                                                               center;
                                                       }
                                                       return coords;
    }
    public SpiralBucketOrder() { super();
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
       "2vzxfX/4ht994Zt5rf1/AWbcoK6mIwAA");
}
