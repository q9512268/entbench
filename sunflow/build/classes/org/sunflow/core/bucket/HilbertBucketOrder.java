package org.sunflow.core.bucket;
public class HilbertBucketOrder implements org.sunflow.core.BucketOrder {
    public int[] getBucketSequence(int nbw, int nbh) { int hi = 0;
                                                       int hn = 0;
                                                       while ((1 << hn < nbw ||
                                                                 1 <<
                                                                 hn <
                                                                 nbh) && hn <
                                                                16) hn++;
                                                       int hN = 1 << 2 * hn;
                                                       int n = nbw * nbh;
                                                       int[] coords = new int[2 *
                                                                                n];
                                                       for (int i =
                                                              0; i <
                                                                   n;
                                                            i++) {
                                                           int hx;
                                                           int hy;
                                                           do  {
                                                               int s =
                                                                 hi;
                                                               int comp;
                                                               int swap;
                                                               int cs;
                                                               int t;
                                                               int sr;
                                                               s =
                                                                 s |
                                                                   1431655765 <<
                                                                   2 *
                                                                   hn;
                                                               sr =
                                                                 s >>>
                                                                   1 &
                                                                   1431655765;
                                                               cs =
                                                                 (s &
                                                                    1431655765) +
                                                                   sr ^
                                                                   1431655765;
                                                               cs =
                                                                 cs ^
                                                                   cs >>>
                                                                   2;
                                                               cs =
                                                                 cs ^
                                                                   cs >>>
                                                                   4;
                                                               cs =
                                                                 cs ^
                                                                   cs >>>
                                                                   8;
                                                               cs =
                                                                 cs ^
                                                                   cs >>>
                                                                   16;
                                                               swap =
                                                                 cs &
                                                                   1431655765;
                                                               comp =
                                                                 cs >>>
                                                                   1 &
                                                                   1431655765;
                                                               t =
                                                                 s &
                                                                   swap ^
                                                                   comp;
                                                               s =
                                                                 s ^
                                                                   sr ^
                                                                   t ^
                                                                   t <<
                                                                   1;
                                                               s =
                                                                 s &
                                                                   (1 <<
                                                                      2 *
                                                                      hn) -
                                                                   1;
                                                               t =
                                                                 (s ^
                                                                    s >>>
                                                                    1) &
                                                                   572662306;
                                                               s =
                                                                 s ^
                                                                   t ^
                                                                   t <<
                                                                   1;
                                                               t =
                                                                 (s ^
                                                                    s >>>
                                                                    2) &
                                                                   202116108;
                                                               s =
                                                                 s ^
                                                                   t ^
                                                                   t <<
                                                                   2;
                                                               t =
                                                                 (s ^
                                                                    s >>>
                                                                    4) &
                                                                   15728880;
                                                               s =
                                                                 s ^
                                                                   t ^
                                                                   t <<
                                                                   4;
                                                               t =
                                                                 (s ^
                                                                    s >>>
                                                                    8) &
                                                                   65280;
                                                               s =
                                                                 s ^
                                                                   t ^
                                                                   t <<
                                                                   8;
                                                               hx =
                                                                 s >>>
                                                                   16;
                                                               hy =
                                                                 s &
                                                                   65535;
                                                               hi++;
                                                           }while((hx >=
                                                                     nbw ||
                                                                     hy >=
                                                                     nbh ||
                                                                     hx <
                                                                     0 ||
                                                                     hy <
                                                                     0) &&
                                                                    hi <
                                                                    hN); 
                                                           coords[2 *
                                                                    i +
                                                                    0] =
                                                             hx;
                                                           coords[2 *
                                                                    i +
                                                                    1] =
                                                             hy;
                                                       }
                                                       return coords;
    }
    public HilbertBucketOrder() { super(); }
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
       "m9+793fe8BvPfTOvCf83VTVoM2UiAAA=");
}
