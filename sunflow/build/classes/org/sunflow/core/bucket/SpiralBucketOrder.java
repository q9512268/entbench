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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "793zO2/8jee/mdfR/xs1Y3UdliMAAA==");
}
