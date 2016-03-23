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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "FUqar/1UtpJpgsqyS4k1KBm7W19KVkFab7BiT+AzZV2J6jAES3KtNe5DYQWd" +
       "gl00dpPGptOjK67veJicv/G9oXgVfNOP9zZ+Z9l4ODwDyl/CixvIj/EWurv1" +
       "aDE8cdhsLT/nX6HZeqwhdeagyfHANf31Yx314vX7wRud/5Sv3h975/MvaPTH" +
       "a3v73T4pAm6JPP9nbH2j2yf2C4CnbtxmIMvjr6Mu1Off+U/3829cvuXH6LM/" +
       "fIrP0yR/h3zxi8hr1V/dA2467EldczB3Eunpk52oWwM9igOXP9GPevBQ/aUJ" +
       "Hts3wYEprtPrvq6rnCldZecgp5qpeyXAXnnNHnMMMQJuMt2yKRyXiNErdGHT" +
       "YvBy1zP0/SMTTl/HRaM/N8wTNzZM2QXetXNe+M3Hv/K2Fx7/27KResEMRSXo" +
       "BsZ1TgiP4Xz3xZe//bXbH/xUefBwdq6EO82dPlq99uT0xIFoKcFth4oupSoO" +
       "ye7eV/Tdu347+j89xbrOidj/Ga2S99j3feAosv0f1V860UaOgLuuPesqmvX3" +
       "XXN+vjvzVT/1wsUL974g/MVO6wfnsrcQwIVFbNvHe6vH5uf9QF+YJbu37Dqt" +
       "fvnz7gi49wZncBFwfjcpmX7XDv6XIuDSafgIOFv8HAf7lQh41TGwCLh5f3Yc" +
       "6AO5i+dAxfQ5/zpt2V2PeXvmWKLZT42lnu/6UXo+RDl+HFTEQPkHhoNEEu/+" +
       "wnBV/fQLY+qt32t9fHccpdpKlhVULuTuujsZO0xGj96Q2gGt8+iTP7jjM7c8" +
       "cZA479gxfJQijvH28PXPe4aOH5UnNNkf3Pt7r/+tF75Rdon/G7lOAX9ZIgAA");
}
