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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BzHP9psKJQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "poC9jguRbnGguFqa4Y2v/etP/fWHXmgdFAZ9MS1EB7Ny/YROTIqi8B+9/PEn" +
       "3vTin/xc6fGA8wcLpj9aDv/Osr1ZNN9f6ve+4vQHYqDnsr6MARzL05zDuPB3" +
       "4HcBHP+3OAohixv7hHyDOqwK3nFcFgQgqd0njnv3NhkptFwQ6NLDcgh6/sZX" +
       "15/8s9/Ylzrn7eMcsfmRF//J39366IsHpwrMp2+r8U732ReZpQIeKhq28Lh3" +
       "3muUsgf9Pz/z/O/86vMv7KW6cbZc6oC3gd/4o//z+7c+8Sefv0Nevw+UwvuM" +
       "ULRI0bx/P5/Nu7rfPzhrHC1wXDk0jiu3GUelPBnfS6FFQxcNU0JngV5HHNMj" +
       "APh33101ZeTcz/RLv/z0H/z0S0//jzL4XLEiYPNEuLxDSXyqzzdf/urXv/TQ" +
       "E58uM/T9cy3aW//5d4nbXxXOvAGUAj94e/Z99HA+Ht3b3+j/t47T/bDoppsO" +
       "NPasohpgQss4Kg+/F2z3ylfPptrLt0PqvaGxyURfm3GZII7AfHcZlooRj7PF" +
       "hcMCtDTfotGOLNO8s2UegCgTJHPH0s8Y5iXH9Jb7VwCxaJ4L8uMxDvYdy+u3" +
       "xIdJvox0lON7ZlEvHD3bF8yWf+v4LRg8zG+TNqy87+723yvN8CSlfO7Df/G4" +
       "/COr515HpfzUOfc4z/LXei9/nnmP/i8OKvcdJ5jbXpHPdnrmbFp5IDTBO70n" +
       "n0kuT+wVUM7fnWf/QnG62k/6PYqe7B7PtkUD6pmLejH5e13dg/ynTpUWtxnL" +
       "jx8ZywfuYiyluKcMpWisYyP5sduNpLhcF417u9aL62A/bNm7aOJ7iP6z93j2" +
       "QtH8TNHs9pLcg/Yf55VzmUB5nZmgCY6rh2Hi6l0ywT99fZngkjTkep1Rqb9z" +
       "0v2z15Run0MvgFeIi8gt7FatuP75e4y/un38t9qOfvOoelDMMAIeddN2sCNP" +
       "PlXP7Bd+zgnJfsdCAm9/+ISZ4HvLZ37uTz/2+//86a+CtMYfVVAFNQmsZHTx" +
       "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" +
       "KjVwfOAQ5ge+hzBLfV64dHeYF64UzYW4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("cmN5uE9jZC1dTS4+jxbkzx2DvnDwekDnwOcHParYe/W22/Yy7/ff6p9+6dqV" +
       "t740/q/7DQFHe2SvCpUriwS8bp7aKnPq/FIQmgurxH11v3EmKHFciyvXz++Y" +
       "LJQH/grhLhyS3YgrbzpFFoNUuT87TfQWIDwgKk4fC+7w3Wm/BSi/cDZ5H1vH" +
       "jdeaqFP5/ukzn5vLzeFHn4aT/fbwZ/XPvMSLP/kq+kv7LYK6o+3KT4tXhMrl" +
       "/W7Fkmnxefmdd+V2xOsS+95vP/ybV999VEE8vBf4xOROyfbUnbfjddwgLjfQ" +
       "7f79W//tD/3KS18pNxL9P4Q5cVi1LwAA");
}
