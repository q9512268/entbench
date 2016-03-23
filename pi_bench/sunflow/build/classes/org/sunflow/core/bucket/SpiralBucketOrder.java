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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vTf91ovfyLPr/w1BQvCNjiMAAA==");
}
