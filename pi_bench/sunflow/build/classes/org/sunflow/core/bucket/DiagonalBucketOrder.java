package org.sunflow.core.bucket;
public class DiagonalBucketOrder implements org.sunflow.core.BucketOrder {
    public int[] getBucketSequence(int nbw, int nbh) { int[] coords = new int[2 *
                                                                                nbw *
                                                                                nbh];
                                                       int x =
                                                         0;
                                                       int y =
                                                         0;
                                                       int nx =
                                                         1;
                                                       int ny =
                                                         0;
                                                       for (int i =
                                                              0;
                                                            i <
                                                              nbw *
                                                              nbh;
                                                            i++) {
                                                           coords[2 *
                                                                    i +
                                                                    0] =
                                                             x;
                                                           coords[2 *
                                                                    i +
                                                                    1] =
                                                             y;
                                                           do  {
                                                               if (y ==
                                                                     ny) {
                                                                   y =
                                                                     0;
                                                                   x =
                                                                     nx;
                                                                   ny++;
                                                                   nx++;
                                                               }
                                                               else {
                                                                   x--;
                                                                   y++;
                                                               }
                                                           }while((y >=
                                                                     nbh ||
                                                                     x >=
                                                                     nbw) &&
                                                                    i !=
                                                                    nbw *
                                                                    nbh -
                                                                    1); 
                                                       }
                                                       return coords;
    }
    public DiagonalBucketOrder() { super(); }
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
       "YSIAAA==");
}
