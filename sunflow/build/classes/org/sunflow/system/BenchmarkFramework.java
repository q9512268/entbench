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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ye2wUxxmfO79f+MEzBhuwDZKB3CUhbxMSMBibnOFkE9SY" +
       "lGNub85evLe77M7ZZ1M3BDWFViqiCQGSJv6nUCglEEWNWqlNQlWVJEoaKSRt" +
       "mkQNTVW1tBQVWjWtQtv0m5nd28c9UP/pSTe3N/PNzPf8fd+3p6+gMtNArUSl" +
       "ITqhEzO0XqVRbJgk0a1g09wCczHpSAn+2/ZLm+4JovIhNGMEm/0SNkmPTJSE" +
       "OYRaZNWkWJWIuYmQBNsRNYhJjDFMZU0dQrNlsy+lK7Ik034tQRjBVmxEUCOm" +
       "1JDjaUr6rAMoaokAJ2HOSXiNf7krgmolTZ9wyOe5yLtdK4wy5dxlUtQQ2YnH" +
       "cDhNZSUckU3alTHQcl1TJoYVjYZIhoZ2KndYKtgYuSNHBW0v1H96/eBIA1fB" +
       "TKyqGuXimQPE1JQxkoigemd2vUJS5i70ZVQSQTUuYoo6IvalYbg0DJfa0jpU" +
       "wH0dUdOpbo2LQ+2TynWJMUTRYu8hOjZwyjomynmGEyqpJTvfDNIuykorpMwR" +
       "8anl4UNHtje8WILqh1C9rA4ydiRggsIlQ6BQkooTw1yTSJDEEGpUwdiDxJCx" +
       "Ik9alm4y5WEV0zSY31YLm0zrxOB3OroCO4JsRlqimpEVL8kdyvpXllTwMMg6" +
       "x5FVSNjD5kHAahkYM5IY/M7aUjoqqwmKFvp3ZGXseBAIYGtFitARLXtVqYph" +
       "AjUJF1GwOhweBNdTh4G0TAMHNChqLngo07WOpVE8TGLMI310UbEEVFVcEWwL" +
       "RbP9ZPwksFKzz0ou+1zZtOrAbrVXDaIA8JwgksL4r4FNrb5NAyRJDAJxIDbW" +
       "LoscxnNe3h9ECIhn+4gFzQ++dO2BFa3nXhc08/PQbI7vJBKNScfiM95Z0N15" +
       "Twljo1LXTJkZ3yM5j7KotdKV0QFh5mRPZIshe/HcwPmH95wil4Ooug+VS5qS" +
       "ToEfNUpaSpcVYmwgKjEwJYk+VEXURDdf70MV8ByRVSJmNyeTJqF9qFThU+Ua" +
       "/w8qSsIRTEXV8CyrSc1+1jEd4c8ZHSFUAV9UC98qJD78l6Id4REtRcJYwqqs" +
       "auGooTH5mUHVBA5TYsJzAlZ1LWym1aSijYdNQwprxrDzf8KkJBVeC6YYSWFj" +
       "tAfilIxrxmiIeZr+f7gjw+ScOR4IgAkW+AFAgdjp1ZQEMWLSofTa9dfOxN4U" +
       "zsUCwtIQRUvgupB1XUhcF8q9DgUC/JZZ7FphZDDRKAQ7oG1t5+AXN+7Y31YC" +
       "3qWPl4J+GWmbJ+t0O4hgw3hM+uvGT1b2Tt37bhAFATTikHUc8F/kAn+WtQxN" +
       "IgnAnkJJwAbCcGHYz8sDOnd0/LGtj97CeXCjOTuwDICIbY8yDM5e0eGP4nzn" +
       "1u+79OnZw1OaE8+e9GBntZydDCba/Lb0Cx+Tli3CL8VenuoIolLAHsBbiiE+" +
       "AMpa/Xd44KLLhl4mSyUInNSMFFbYko2X1XTE0MadGe5kjfx5Fpi2hsVPC3zr" +
       "rIDiv2x1js7GucIpma/4pODQft+g/tyv3v7jSq5uOwvUu9L3IKFdLuRhhzVx" +
       "jGl0XG+LQQjQ/fpo9Mmnruzbxv0OKNrzXdjBxm5AHDAhqPnx13d9cPHjY+8F" +
       "HV+lkHrTcahgMlkh2TyqLiIk3LbU4QeQS4HIZl7T8ZAKXiknZRxXCAuOf9Uv" +
       "ufWlPx9oEH6gwIztRitufIAzf9NatOfN7f9o5ccEJJY5HZ05ZAKOZzonrzEM" +
       "PMH4yDx2oeXp1/BzAOwApqY8STg+BrkOgt54ZYXcYDpuQtTJKTDDmJVqbovu" +
       "kPZ3RH8n0shNeTYIutknw9/Y+v7Ot7iRK1lcs3kmd50ratcYwy4PaxDK/xw+" +
       "Afj+h32Z0tmEgOymbitvLMomDl3PAOedRSo9rwDhqaaLo89eel4I4E+sPmKy" +
       "/9DXPw8dOCQsJ6qP9pwCwL1HVCBCHDbczbhbXOwWvqPnD2enfnRyap/gqsmb" +
       "S9dDqfj8L//9Vujob97IA98lslVBrmSunAXfWV7bCIHWfa3+xwebSnoAM/pQ" +
       "ZVqVd6VJX8J9IhRPZjruMpZT1fAJt2jMMBQFloEN2MRdfLyd8xLOcoQ4R4iv" +
       "bWBDh+nGT6+9XEVyTDr43tW6rVdfucZl9lbZbrjox7pQeCMbljCFz/XnqF5s" +
       "jgDd7ec2PdKgnLsOJw7BiRKUluZmA/JjxgMuFnVZxYc/+emcHe+UoGAPqlY0" +
       "nOjBHKdRFQAkMUcgtWb0+x8Q+DBeCUMDFxXlCM9CcmH+YF+f0ikPz8kfzv3+" +
       "qhPTH3NcEkA0PxuaCzyplHdmTiY49e5dvzjxzcPjwnuKxIJv37zPNivxvb/9" +
       "Z46CeeLLEx6+/UPh0882d6++zPc7GYjtbs/k1iOQo529t51K/T3YVv6zIKoY" +
       "Qg2S1QltxUqa4foQVP+m3R5Bt+RZ91byomztymbYBf74dF3rz31uty+lHhd3" +
       "0h0rHdF8KxvYWcGT7gKIP3yBb1nKx042rLCzS4VuyNAtE196qSlyKKQkKqeg" +
       "HfN271mY5agugvqRmvOvmt/+/YvC/PlA3NcvnDxRKX2UOs9BnF12p1fWxmKy" +
       "AjtLCjuYi6vp77S//eh0+yc81iplE8wAcJ+nA3LtuXr64uULdS1neElTyrKG" +
       "BULe1jG3M/Q0fFymejbEhcLnQfOSp8bdwvXrR072f0Bstuwq57drkD3eTMGj" +
       "ZBUr/NK7wWoKUYdF+3EfG4gVyitdmdbiSeRo5sTQBWoqYeneXhNVtqyFsh04" +
       "LGbywHyLBxj6uRqcKKv+6i0zIzSTzC2v2UmtBQroZYUN7L/gtb1/at6yemTH" +
       "/1A7L/TZ33/kd/tPv7FhqfREkLfuIqhzWn7vpi5vKFcbhKYN1Zuz2oRNuU2E" +
       "QdmwjJutSMraXWRtig0Z8ACJmU9Yuwj5Hu5NUVd6sMzI/q6zimY29rLhYWHt" +
       "BwvmlwFv1Dbblbn9mwehvuIIvi0XigrtppDvIFQirGjhed7H6eNFOM24VJ29" +
       "kX/Kka8jd9fWTvJDDHFaCr004cXTsb2HphObj99qw9n9jGFNv1khY0RxHSVi" +
       "m3r7mOXwbbLYaPKrzRHUJ0G2Oyi01ecGbnCB6F5UrOPeQqBUZ4RHivjSt9jw" +
       "BGQWkiFSmgqPvleUZfx5NUWlY5qccMz05I0cylOwCFeFVJv7JoAVM/NyXjaK" +
       "F2TSmen6yrnTD70vINx+iVULTUAyrSjufOt6LtcNkpS5YLUi+4qK8jjcn6sq" +
       "AFnxwLk+JkhPUlTjIqWsjOVPbqLvQbUMROzxtG4bo8GBYVFLZAJe/8tqcPaN" +
       "NOhy2XYPhvI3uDbepcU73Jh0dnrjpt3X7jwuOmFJwZOT7JQayGeiKc9i5uKC" +
       "p9lnlfd2Xp/xQtUSOwgaBcOOB893eU8UfFFnZmz2tYlmR7Zb/ODYqld+vr/8" +
       "AuTvbSiAIV1ty626MnoaonNbJLfXgHzC+9euzmcmVq9I/uUjXtZaSWtBYfqY" +
       "VPXZgcnFZiAURFV9qAzim2R4ObhuQh0g0pjhaVzK41pazRYGM5i/YfZml2vF" +
       "UmZddpa9RaGoLbeDy32zBPX+ODHWstOtGsSTYdK67l7lWu0W4ce0DH4Wi/Tr" +
       "ut26fsi1rus8rF7leP9fNYw9s5oZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qHjJt/2DV3z2Db/19DeLxNf/ADq3ciafJAAA");
}
