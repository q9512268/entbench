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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "rRpzvaDhpdiJA0emY9ufW+1A4QZkWDfuVukoVT1HCVwY9XdFK+Fbb7NRH1Sb" +
       "K2hAgnSvkWtrwDG8wATIsDhf799HofBHwqfzeNc0DkchK9EUlZNMYE4rd2+h" +
       "8gcYKRrVlZhrpmN3cqj85Y/tvJC4M99SYG00L+NVp3g9J5+drimbO/3QuyIh" +
       "OK/QqgCJ4klV9WZvz3OJYdK4wkWtErlcVKzPw/2ZygPIFg+c7VOC9AwjlR5S" +
       "hmUyf/ISnYNqHIjw8bzhmKfWBXVRmaQK/B6Z1unsO+nU48TNPpzl748dTEyK" +
       "N8gD8rnprdv23frcc6LTllVpYgJPqYTsKJr+NK4uyXmac1bJluW3Z5wvX+qE" +
       "RZ1g2PXp+R5/6gHvNNCMDYE21GpJd6Pvn1j3ys+nSi5DNbCTFEiQ/HZm1nAp" +
       "IwnxujOa2ctADuL9cevyp8fXr4r/7QNeJRORAhfkpoca9cn3Os+PfLyBv7As" +
       "hoinKV5cbh7Xeqg8avoaoxnoYRK+SeZ6sNVXnZ7F9zKMNGX2hJlvs6CDGKPm" +
       "Jj2pxXhmgZznzvheZDupKGkYgQ3ujKew2SwCFbUP/jcQ7TIMp2XeZ/BIa8+d" +
       "Iy7yRxx++j+Gg/87ShoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7H8ApnSRxrUkAAA=");
}
