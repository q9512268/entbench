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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7CQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "a+qLaImGBN7B8aQP1bcyrCByFnP5OFrtVp2VrbS5ektihyyyI3fdPrzstjZc" +
       "bzoQETraxstaXYzqnq44qNerb6vzdS6jVrj2NhDaASno2EIhXXEZbhjP7XW+" +
       "AjkVF60kjxlzVgfuN7m0atWAS7O2idvsVhUp5pI+m/VJl5PXUQ8Epxky9kxm" +
       "UU07eNXeyE1ot6rZTWNYb0wNc0xqfYge8+1RpLEJIVG+HYwyKJ+ReGdqNdi8" +
       "U3frWtD2Zx65ykzG6HJoddtaLutdz/TysQtbMr+h9JG2rTVDfr31sM5WRQMd" +
       "qiryImjXcAF4fqwX5C0Wni801awPOCEg8vHcaGRpl5AXi4EvQ+5qnVtb20Na" +
       "YSPHh1uyw0DcGMm0NtKoBs0Fl8h51/K6PD0yCFdtaM6CVakoqFITJFyn3qiv" +
       "kmYf4lY9nR4vN8ym0YwMfN1B6K0QMlBNUrHIQbvJPBCUte2iPqJOrURech3c" +
       "Y0e1Rip4GT8yHItVZLJOdPEhVLU5w3XnBmlyEimrlDnp2JY0n2VGKEApW09p" +
       "fotgk16v9/73F1sev/L6tmIeKbeWjo8QrRykaPjk69htyV57O/J4g678Fd8i" +
       "zpxGObVBd+qbaaX4xvTE3Q4Mld+XPv3hl142uF+uHxxuHo7jytXYD/6OY25N" +
       "5xSry/vtzGMxnijYvweUW4di3Dq/T3iC/3vcJDy3pXnhZAeZLQl+6x57np8r" +
       "qn8HZPfMLC6+opU7xezJ9P/ma212neZ4Dmu5J/okKId99//fI9aTRRzcEeap" +
       "jWT2BOvn74H1C0X1n+LK/aEt9bE77fZdMvzk6CtFif633yj6t4NCHqInf+Do" +
       "/+Ae6P+wqL4UVy6Gdrmb/MUTlF9+oygLpZ4copz8wFF+7R4o/6So/iiu3Bfa" +
       "9PgczK+8AZhPFQ/fDYp8CFN+vWZ7mwP8nrD+73tg/VZR/SnQ2qXqxPtjR6fQ" +
       "/tkbRfs0KPkh2vz7jfaUk/piSfCX9wD6V0X152BRXd+on4P5nTcAs3BNlRoo" +
       "HziE+YEfIMxyPS9cujvMC1eK6kJcuWEd");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("nscQbMtVp8Wn0YL8+WPQFw5eD+gM2PyEwYozVm+77aTy/nSt/pmXr11568vi" +
       "f91/+D86AXuVrlxZJI5z+kjMqetLQWgu7BL31f0BmaDEcS2uXD9/MrJYPPBX" +
       "CHfhkOxGXHnTKbIYhMr91WmitwDhAVFx+Vhwh29O+6M+2YWzwftYO2681kSd" +
       "ivdPn/nUXB79PvosnOwPfz+nf/Zlkv3pb7d/eX8UUHfUXflZ8Qpdubw/lVgy" +
       "LT4tv/Ou3I54XRq+97sP//rVdx9lEA/vBT5RuVOyPXXnY3e4G8TlQbndv3/r" +
       "v/3RX3n5K+WBof8P+n3EaZMvAAA=");
}
