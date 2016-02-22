package org.sunflow.system;
public class BenchmarkFramework {
    private org.sunflow.system.Timer[] timers;
    private int timeLimit;
    public BenchmarkFramework(int iterations, int timeLimit) { super();
                                                               this.timeLimit =
                                                                 timeLimit;
                                                               timers = (new org.sunflow.system.Timer[iterations]);
    }
    public void execute(org.sunflow.system.BenchmarkTest test) { for (int i =
                                                                        0;
                                                                      i <
                                                                        timers.
                                                                          length;
                                                                      i++)
                                                                     timers[i] =
                                                                       null;
                                                                 long startTime =
                                                                   java.lang.System.
                                                                   nanoTime(
                                                                     );
                                                                 for (int i =
                                                                        0;
                                                                      i <
                                                                        timers.
                                                                          length &&
                                                                        (java.lang.System.
                                                                           nanoTime(
                                                                             ) -
                                                                           startTime) /
                                                                        1000000000 <
                                                                        timeLimit;
                                                                      i++) {
                                                                     org.sunflow.system.UI.
                                                                       printInfo(
                                                                         org.sunflow.system.UI.Module.
                                                                           BENCH,
                                                                         "Running iteration %d",
                                                                         i +
                                                                           1);
                                                                     timers[i] =
                                                                       new org.sunflow.system.Timer(
                                                                         );
                                                                     test.
                                                                       kernelBegin(
                                                                         );
                                                                     timers[i].
                                                                       start(
                                                                         );
                                                                     test.
                                                                       kernelMain(
                                                                         );
                                                                     timers[i].
                                                                       end(
                                                                         );
                                                                     test.
                                                                       kernelEnd(
                                                                         );
                                                                 }
                                                                 double avg =
                                                                   0;
                                                                 double min =
                                                                   java.lang.Double.
                                                                     POSITIVE_INFINITY;
                                                                 double max =
                                                                   java.lang.Double.
                                                                     NEGATIVE_INFINITY;
                                                                 int n =
                                                                   0;
                                                                 for (org.sunflow.system.Timer t
                                                                       :
                                                                       timers) {
                                                                     if (t ==
                                                                           null)
                                                                         break;
                                                                     double s =
                                                                       t.
                                                                       seconds(
                                                                         );
                                                                     min =
                                                                       java.lang.Math.
                                                                         min(
                                                                           min,
                                                                           s);
                                                                     max =
                                                                       java.lang.Math.
                                                                         max(
                                                                           max,
                                                                           s);
                                                                     avg +=
                                                                       s;
                                                                     n++;
                                                                 }
                                                                 if (n ==
                                                                       0)
                                                                     return;
                                                                 avg /=
                                                                   n;
                                                                 double stdDev =
                                                                   0;
                                                                 for (org.sunflow.system.Timer t
                                                                       :
                                                                       timers) {
                                                                     if (t ==
                                                                           null)
                                                                         break;
                                                                     double s =
                                                                       t.
                                                                       seconds(
                                                                         );
                                                                     stdDev +=
                                                                       (s -
                                                                          avg) *
                                                                         (s -
                                                                            avg);
                                                                 }
                                                                 stdDev =
                                                                   java.lang.Math.
                                                                     sqrt(
                                                                       stdDev /
                                                                         n);
                                                                 org.sunflow.system.UI.
                                                                   printInfo(
                                                                     org.sunflow.system.UI.Module.
                                                                       BENCH,
                                                                     "Benchmark results:");
                                                                 org.sunflow.system.UI.
                                                                   printInfo(
                                                                     org.sunflow.system.UI.Module.
                                                                       BENCH,
                                                                     "  * Iterations: %d",
                                                                     n);
                                                                 org.sunflow.system.UI.
                                                                   printInfo(
                                                                     org.sunflow.system.UI.Module.
                                                                       BENCH,
                                                                     "  * Average:    %s",
                                                                     org.sunflow.system.Timer.
                                                                       toString(
                                                                         avg));
                                                                 org.sunflow.system.UI.
                                                                   printInfo(
                                                                     org.sunflow.system.UI.Module.
                                                                       BENCH,
                                                                     "  * Fastest:    %s",
                                                                     org.sunflow.system.Timer.
                                                                       toString(
                                                                         min));
                                                                 org.sunflow.system.UI.
                                                                   printInfo(
                                                                     org.sunflow.system.UI.Module.
                                                                       BENCH,
                                                                     "  * Longest:    %s",
                                                                     org.sunflow.system.Timer.
                                                                       toString(
                                                                         max));
                                                                 org.sunflow.system.UI.
                                                                   printInfo(
                                                                     org.sunflow.system.UI.Module.
                                                                       BENCH,
                                                                     "  * Deviation:  %s",
                                                                     org.sunflow.system.Timer.
                                                                       toString(
                                                                         stdDev));
                                                                 for (int i =
                                                                        0;
                                                                      i <
                                                                        timers.
                                                                          length &&
                                                                        timers[i] !=
                                                                        null;
                                                                      i++)
                                                                     org.sunflow.system.UI.
                                                                       printDetailed(
                                                                         org.sunflow.system.UI.Module.
                                                                           BENCH,
                                                                         "  * Iteration %d: %s",
                                                                         i +
                                                                           1,
                                                                         timers[i]);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "pXkPunI6cc/x20YItPXxmh8fqi/sgJzRScqSmrIvSTtj3h2hyLKSQx5judUP" +
       "n/CKhoZhpGAV2AAnvsjHdZyXu9IcEc4R4e+24bDc8uZPv708xfSgfOidG9X9" +
       "N165yWX2V+PedNElGULhdTisQIXPD+LbNskaAbp7zu94sFY9fwt2HIAdZShB" +
       "rZ0mYGvKl1xs6uLSD356Yd6etwtJqINUqLoU65B4niblkCCpNQKwnDLu2yTy" +
       "w3gZDLVcVJIhfMYExuiS7NHfnjAYj9fJH8z/3oYTM5d5ojLEHgvTwbrIB8y8" +
       "p3Ox4dQv7/3ViW8dHRf+lCc6AusW/GunOrT/d//MUDmHwiwBE1g/EDn9TEPb" +
       "xmt8vYtJuLollVndAK67a+8+lfhHqKnk5yFSOkBqZbuH6pfUJGb6AegbLKex" +
       "gj7L997fA4iCtzWNuYuCEes5NoiG3kAoYj6ndwEQi06y0MYHByd8AFhA+MMA" +
       "X/I5Pq7C4U4Hb0oNU4E+mwYApzLPpgBSTElAI+fv+9OJl+d5EeYPVl78ifWd" +
       "P74ozJ8trQc6jZMnyuQPExd5WsfD7vXLWpdPVmBneW4H83A1893mtx6Zaf4t" +
       "j74yxQIzAABk6Z08a26cvnLtUnXjGV7kFCGO2GnJ33Rm9pS+VpHLVINDTCh8" +
       "AbQ9WSrmPq7fYC7F/31isW3X0ex2DeFjmIFHKZqk8kPXg9VUqg2LxmUjDsOG" +
       "mw4c7LV5EqiNTgz9o65RLACcd6JmV/RwuneHl6ksib/Rlxi6uBrcKPto1hO/" +
       "/2HL8JbPUqzj3OLblOP4fwnYclVuVwiy8ur+vzT0bRzZ8xnq7iUBTwlu+XzX" +
       "6dfvXyE/EeLXAyL8M64V/Ita/UFfYVKWNDU/3jUL63PrCdPjsJobOA/cTeV5" +
       "9wgOk+ArMhpa+EUe8v2ZCIITPYYHbGwXwL/tdgmOYycOu4SnRHOiVZ8/4huc" +
       "Ot/5zZLdDriqeCgzjeVazQA9IcyiWALxqiHA6XQeTlMe5adP5J8SErgH8Fbq" +
       "LnASzFaNua5qeCl2fP/hmdjO59Y6qXATMqwbd6p0jKqerUReGPN3RavhW2+z" +
       "UR9UmytoQIJ0r5FracAxvIkJMsPSfL1/H4XCHwmfzuNdMzgcAVSiKSonmcg5" +
       "rdy9hcrvY6RoTFdirpmO3s6h8pc/tvMCcGfeUmBttCDj0lNc1MlnZmrK5s88" +
       "8K4ABOcyrQoyUTypql709jyXGCaNK1zUKoHlomJ9Hs7PVB6kbPHA2T4pSE8z" +
       "UukhZVgm8ycv0VmoxoEIH88Zjnlq3aQuKpNUgd8j0zqdezudepy42Zdn+U2y" +
       "kxOT4i55UD47s33Hwze/8JzotGVVmpzEXSoBHUXTn86ry3Lu5uxVsm3lrVnn" +
       "ypc7YVEnGHZ9eqHHn3rAOw00Y0OgDbVa0t3o+8c3vPKL6ZJLUA3sIgUSgN+u" +
       "zBouZSQhXndFM3sZwCDeH7eufHpi45r43z7kVTIRELgoNz3UqE++13lu9JNN" +
       "/OqyGCKepnhxuXVC66HymOlrjGahh0l4p8z1YKuvOj2L9zKMNGX2hJm3WdBB" +
       "jFNzi57UYhxZAPPcGd+VtgNFScMILHBnPIXNVhGoqH3wv8Fol2E4LfMHBo+0" +
       "9twYcYE/4vCz/wFe6VsgVBoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OyIdiTUw1iqrDKzbsjmsNebIaoZNBqt4ISNe0eyvFJ8bK12GrozFtT4tF1Ju" +
       "3ODsJHRHZK/o1zq+KGGbNbnsDQKGVakSTFRnOBHbahrR8iDVJIxnjT7rOrak" +
       "1Xw5aeiSv54jY3fSkQ3fs4eVANFRT4LD9QCXuqrC2c0wxFtm0aKl0sByBNvv" +
       "1wIURftVrDmUEn/kJhy4sa+serFhJrMuLtL9Usr1XcJy7V6DCOoM30SWC4bA" +
       "ypOqx7bRlIuWusBrNppI6yJvuxu3TRIoKpiOtaqIo6jv0Zwmo2YxXclKGsmK" +
       "l1TLguwUuHKy3AwnVaNW41rVelCpEHGqwGgvdcMuz9te2p6xbpPgZiBKRvyk" +
       "QkW1aMMHdsXyecdJPKk+59tOlxAayoognIqPDeNicV4caq0FLxbDiltApcqa" +
       "6VOI0KM4rBKQGsdqdCFKm24ksCN95sidQSUQYhwEU3UlUgnPqNb8aiWtL/kJ" +
       "OW5TmkunFW7VLhRKFStq9GgaHq6SLt5XPEffRDMeRxAisYeWb3ZFXS9aVQ9N" +
       "S/N+tB6aZaqR9gd0d1bWe3ZlKjebZodOjVqdm+sbAWMYqSsX+FCjO6w0ICmi" +
       "6TDkjOb1rrsiKvEa7bhWuV2lVHDeuIViI4zn0rwNV9d4CscdBeEDjW+64GL5" +
       "hjdkV85f/NGuwnfnt/6D99vgBpx1vP1HuO1ujiRwDjIk+ecsdOKd6JEMyZEk" +
       "MpSluR+82WvrPKX/0Xc9+5w8/FhpZy97U8+yJq73E5ayVqwjU22ze+Lxl1oF" +
       "8L2yx8aVk4maQ0FvnKV57eZGSamjucR7QuiRW730nChBmE/ym7dIR/1WVvx6" +
       "CJ1TNooUhcoN0xBr15AP9+Q3Xi4DcSxpH0JXrn8Nm71Tuv+6f3Vs/4kgffK5" +
       "S+fve477q21Cd//fAhco6LwaWdbRTPaR+lnPV1QjF+nCNq/t5T+fAOtfr6Qs" +
       "EZVXcn6f35J+OoRuP0IKdLJXO0r0ByF0GhBl1c94N8hQbbP0m1PHzexAd1de" +
       "TndHLPPxYwnY/K8y+8nSaPtnmWvSp57r0W97CfnY9u2nZIlp7mXnKejc9kXs" +
       "QcL10ZvOtj/XWeLJH9z16QtP7Nv6XVuGDw31CG8P3/hVY9v2wvzlYPpH933m" +
       "9b/z3DfzhNn/ADdzcZ3DJAAA");
}
