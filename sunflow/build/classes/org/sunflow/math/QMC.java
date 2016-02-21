package org.sunflow.math;
public final class QMC {
    private static final int NUM = 128;
    private static final int[][] SIGMA = new int[NUM][];
    private static final int[] PRIMES = new int[NUM];
    static { org.sunflow.system.UI.printInfo(org.sunflow.system.UI.Module.
                                               QMC, "Initializing Faure scrambling tables ...");
             PRIMES[0] = 2;
             for (int i = 1; i < PRIMES.length; i++) PRIMES[i] = nextPrime(
                                                                   PRIMES[i -
                                                                            1]);
             int[][] table = new int[PRIMES[PRIMES.length - 1] + 1][];
             table[2] = (new int[2]);
             table[2][0] = 0;
             table[2][1] = 1;
             for (int i = 3; i <= PRIMES[PRIMES.length - 1]; i++) { table[i] =
                                                                      (new int[i]);
                                                                    if ((i &
                                                                           1) ==
                                                                          0) {
                                                                        int[] prev =
                                                                          table[i >>
                                                                                  1];
                                                                        for (int j =
                                                                               0;
                                                                             j <
                                                                               prev.
                                                                                 length;
                                                                             j++)
                                                                            table[i][j] =
                                                                              2 *
                                                                                prev[j];
                                                                        for (int j =
                                                                               0;
                                                                             j <
                                                                               prev.
                                                                                 length;
                                                                             j++)
                                                                            table[i][prev.
                                                                                       length +
                                                                                       j] =
                                                                              2 *
                                                                                prev[j] +
                                                                                1;
                                                                    }
                                                                    else {
                                                                        int[] prev =
                                                                          table[i -
                                                                                  1];
                                                                        int med =
                                                                          i -
                                                                          1 >>
                                                                          1;
                                                                        for (int j =
                                                                               0;
                                                                             j <
                                                                               med;
                                                                             j++)
                                                                            table[i][j] =
                                                                              prev[j] +
                                                                                (prev[j] >=
                                                                                   med
                                                                                   ? 1
                                                                                   : 0);
                                                                        table[i][med] =
                                                                          med;
                                                                        for (int j =
                                                                               0;
                                                                             j <
                                                                               med;
                                                                             j++)
                                                                            table[i][med +
                                                                                       j +
                                                                                       1] =
                                                                              prev[j +
                                                                                     med] +
                                                                                (prev[j +
                                                                                        med] >=
                                                                                   med
                                                                                   ? 1
                                                                                   : 0);
                                                                    }
             }
             for (int i = 0; i < PRIMES.length;
                  i++) { int p = PRIMES[i];
                         SIGMA[i] = (new int[p]);
                         java.lang.System.
                           arraycopy(
                             table[p],
                             0,
                             SIGMA[i],
                             0,
                             p); } }
    private static final int nextPrime(int p) {
        p =
          p +
            (p &
               1) +
            1;
        while (true) {
            int div =
              3;
            boolean isPrime =
              true;
            while (isPrime &&
                     div *
                     div <=
                     p) {
                isPrime =
                  p %
                    div !=
                    0;
                div +=
                  2;
            }
            if (isPrime)
                return p;
            p +=
              2;
        }
    }
    private QMC() { super(); }
    public static double riVDC(int bits, int r) {
        bits =
          bits <<
            16 |
            bits >>>
            16;
        bits =
          (bits &
             16711935) <<
            8 |
            (bits &
               -16711936) >>>
            8;
        bits =
          (bits &
             252645135) <<
            4 |
            (bits &
               -252645136) >>>
            4;
        bits =
          (bits &
             858993459) <<
            2 |
            (bits &
               -858993460) >>>
            2;
        bits =
          (bits &
             1431655765) <<
            1 |
            (bits &
               -1431655766) >>>
            1;
        bits ^=
          r;
        return (double)
                 (bits &
                    4294967295L) /
          (double)
            4294967296L;
    }
    public static double riS(int i, int r) {
        for (int v =
               1 <<
               31;
             i !=
               0;
             i >>>=
               1,
               v ^=
                 v >>>
                   1)
            if ((i &
                   1) !=
                  0)
                r ^=
                  v;
        return (double)
                 r /
          (double)
            4294967296L;
    }
    public static double riLP(int i, int r) {
        for (int v =
               1 <<
               31;
             i !=
               0;
             i >>>=
               1,
               v |=
                 v >>>
                   1)
            if ((i &
                   1) !=
                  0)
                r ^=
                  v;
        return (double)
                 r /
          (double)
            4294967296L;
    }
    public static final double halton(int d,
                                      int i) {
        switch (d) {
            case 0:
                {
                    i =
                      i <<
                        16 |
                        i >>>
                        16;
                    i =
                      (i &
                         16711935) <<
                        8 |
                        (i &
                           -16711936) >>>
                        8;
                    i =
                      (i &
                         252645135) <<
                        4 |
                        (i &
                           -252645136) >>>
                        4;
                    i =
                      (i &
                         858993459) <<
                        2 |
                        (i &
                           -858993460) >>>
                        2;
                    i =
                      (i &
                         1431655765) <<
                        1 |
                        (i &
                           -1431655766) >>>
                        1;
                    return (double)
                             (i &
                                4294967295L) /
                      (double)
                        4294967296L;
                }
            case 1:
                {
                    double v =
                      0;
                    double inv =
                      1.0 /
                      3;
                    double p;
                    int n;
                    for (p =
                           inv,
                           n =
                             i;
                         n !=
                           0;
                         p *=
                           inv,
                           n /=
                             3)
                        v +=
                          n %
                            3 *
                            p;
                    return v;
                }
            default:
        }
        int base =
          PRIMES[d];
        int[] perm =
          SIGMA[d];
        double v =
          0;
        double inv =
          1.0 /
          base;
        double p;
        int n;
        for (p =
               inv,
               n =
                 i;
             n !=
               0;
             p *=
               inv,
               n /=
                 base)
            v +=
              perm[n %
                     base] *
                p;
        return v;
    }
    public static final double mod1(double x) {
        return x -
          (int)
            x;
    }
    public static final int[] generateSigmaTable(int n) {
        assert (n &
                  n -
                  1) ==
          0;
        int[] sigma =
          new int[n];
        for (int i =
               0;
             i <
               n;
             i++) {
            int digit =
              n;
            sigma[i] =
              0;
            for (int bits =
                   i;
                 bits !=
                   0;
                 bits >>=
                   1) {
                digit >>=
                  1;
                if ((bits &
                       1) !=
                      0)
                    sigma[i] +=
                      digit;
            }
        }
        return sigma;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GT5I/wUvKV/6+iMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9sLTxsWnzqL5c8egLxy8FtAZsPkRixfn");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("rd5225nm/Tlc47MvXb/61pfk/7o/BHB0VvYaU7k6X7vu6eMxp+4vh7E1t0vc" +
       "1/aHZcISx/W0cuP8Kcli8sBfwdyFw2Y308qbTjVLQajc351u9BbAPGhU3D4a" +
       "3uEb0v7YT3bhbPA+1o6bryaoU/H+qTOfjstD4kefedf7Y+LPGp97ieZ+4tvt" +
       "X94fCzRcLS8/E15lKlf2JxRLosWn4nfeldoRrcvke7/70K9fe/dRBvHQnuET" +
       "lTvF25N3PoLX98K0PDSX/9Zb/+0P/8pLXy0PD/1/qJqq5b0vAAA=");
}
