package util;
public class PageRankBench implements ent.runtime.ENT_Attributable {
    private double alpha;
    private double[] error = new double[] { 0.01, 0.001, 1.0E-4 };
    public int ENT_attribute() { if (ent.runtime.ENT_Util.Battery.percentRemaining(
                                                                    ) >=
                                       0.75) { return util.EntMode.
                                                        HIGH_MODE;
                                 }
                                 else
                                     if (ent.runtime.ENT_Util.
                                           Battery.
                                           percentRemaining(
                                             ) >=
                                           0.5) {
                                         return util.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return util.EntMode.
                                                  LOW_MODE;
                                     } }
    public PageRankBench(double alpha) { super();
                                         this.alpha = alpha; }
    public double[] pagerank(util.PageRankGraph pg) { int nnodes =
                                                        pg.
                                                          g.
                                                        numNodes(
                                                          );
                                                      double[] s1 =
                                                        new double[nnodes];
                                                      double[] s2 =
                                                        new double[nnodes];
                                                      for (int i =
                                                             0; i <
                                                                  nnodes;
                                                           i++) {
                                                          s1[i] =
                                                            1.0 /
                                                              nnodes;
                                                      }
                                                      double[] step =
                                                        null;
                                                      double[] last =
                                                        null;
                                                      for (int n =
                                                             0; n <
                                                                  200;
                                                           n++) {
                                                          double worst =
                                                            java.lang.Double.
                                                              MIN_VALUE;
                                                          if (n %
                                                                2 ==
                                                                0) {
                                                              last =
                                                                s1;
                                                              step =
                                                                s2;
                                                          }
                                                          else {
                                                              last =
                                                                s2;
                                                              step =
                                                                s1;
                                                          }
                                                          for (int i =
                                                                 0;
                                                               i <
                                                                 nnodes;
                                                               i++) {
                                                              step[i] =
                                                                0;
                                                          }
                                                          double distribute =
                                                            0.0;
                                                          for (int i =
                                                                 0;
                                                               i <
                                                                 nnodes;
                                                               i++) {
                                                              if (pg.
                                                                    g.
                                                                    outdegree(
                                                                      i) ==
                                                                    0) {
                                                                  distribute +=
                                                                    last[i];
                                                              }
                                                              int[] income =
                                                                pg.
                                                                  t.
                                                                successorArray(
                                                                  i);
                                                              for (int j =
                                                                     0;
                                                                   j <
                                                                     income.
                                                                       length;
                                                                   j++) {
                                                                  int e =
                                                                    income[j];
                                                                  step[i] +=
                                                                    last[e] /
                                                                      pg.
                                                                        g.
                                                                      outdegree(
                                                                        e);
                                                              }
                                                          }
                                                          for (int i =
                                                                 0;
                                                               i <
                                                                 nnodes;
                                                               i++) {
                                                              step[i] +=
                                                                distribute /
                                                                  nnodes;
                                                              step[i] =
                                                                1.0 -
                                                                  alpha +
                                                                  alpha *
                                                                  step[i];
                                                              double diff =
                                                                java.lang.Math.
                                                                abs(
                                                                  last[i] -
                                                                    step[i]);
                                                              if (diff >
                                                                    worst) {
                                                                  worst =
                                                                    diff;
                                                              }
                                                          }
                                                          if (worst <=
                                                                error[ent.runtime.ENT_Runtime.
                                                                        getObjMode(
                                                                          this,
                                                                          0)]) {
                                                              break;
                                                          }
                                                      }
                                                      return step;
    }
    public static void main(java.lang.String[] args) {
        if (args.
              length <
              1) {
            java.lang.System.
              err.
              format(
                "usage [INPUT_FILE]\n");
            java.lang.System.
              exit(
                1);
        }
        it.unimi.dsi.webgraph.ImmutableGraph g =
          null;
        try {
            g =
              it.unimi.dsi.webgraph.ImmutableGraph.
                load(
                  args[0]);
        }
        catch (java.lang.Exception e) {
            java.lang.System.
              err.
              println(
                "Caught: " +
                e.
                  getMessage(
                    ));
            e.
              printStackTrace(
                java.lang.System.
                  err);
        }
        it.unimi.dsi.webgraph.ImmutableGraph t =
          it.unimi.dsi.webgraph.Transform.
          transpose(
            g,
            null);
        int PANDA_RUNS =
          java.lang.Integer.
          parseInt(
            java.lang.System.
              getenv(
                "PANDA_RUNS"));
        ent.runtime.ENT_Util.
          initModeFile(
            );
        for (int k =
               0;
             k <
               PANDA_RUNS;
             k++) {
            double[] before =
              jrapl.EnergyCheckUtils.
              getEnergyStats(
                );
            ent.runtime.ENT_Util.
              resetStopwatch(
                );
            ent.runtime.ENT_Util.
              startStopwatch(
                );
            util.PageRankBench b =
              ent.runtime.ENT_Snapshot.
              snapshot(
                (util.PageRankBench)
                  ent.runtime.ENT_Runtime.
                  putObj(
                    new util.PageRankBench(
                      0.85),
                    new java.lang.Integer[] { util.EntMode.
                                                DYNAMIC_MODE }),
                util.EntMode.
                  LOW_MODE,
                util.EntMode.
                  HIGH_MODE,
                true);
            util.PageRankGraph pg =
              new util.PageRankGraph(
              g,
              t);
            double[] r =
              b.
              pagerank(
                pg);
            double[] after =
              jrapl.EnergyCheckUtils.
              getEnergyStats(
                );
            double diff =
              after[2] -
              before[2];
            ent.runtime.ENT_Util.
              stopStopwatch(
                );
            if (diff <
                  0) {
                diff +=
                  jrapl.EnergyCheckUtils.
                    wraparoundValue;
            }
            ent.runtime.ENT_Util.
              writeModeFile(
                java.lang.String.
                  format(
                    "ERun %d: %f %f %f %f\n",
                    k,
                    after[0] -
                      before[0],
                    after[1] -
                      before[1],
                    diff,
                    ent.runtime.ENT_Util.
                      elapsedTime(
                        )));
        }
        ent.runtime.ENT_Util.
          closeModeFile(
            );
        jrapl.EnergyCheckUtils.
          DeallocProfile(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471193671000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "A9i8yyGLf+b+D89D0+2tHAAA");
    public PageRankBench() { super(); }
    public ent.runtime.ENT_Attributable ENT_copy() {
        util.PageRankBench ENT_ld =
          new util.PageRankBench(
          );
        ENT_ld.
          alpha =
          this.
            alpha;
        ENT_ld.
          error =
          this.
            error;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471193671000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Zt31bUMO2q25jHW46RKnySBNi+6qu8b6chzHI6W6NEplrI8PR0R97UBoQ7aq" +
       "uJduhj2+1R0UkeKqpLkVWmpr1siCcKu2jOdmv1XXqvo6HQ8q8hINozoEu8BE" +
       "JKONqkGDGTerWrEbmbWK4o6J0CAUhEbL7MZPajiq4FCzwToEN6GrfbtPYhLL" +
       "xaor2T2NsYt1lkUjXxdX9abe5rlmY6QLpbCyiBuQQoQzE+3xOnCAspx0+3ql" +
       "yqyqtigwWr2zqtAbKcESR28t+NmgX44pqrEwWdgU+1ET5TfGWjWcLmdVbAdL" +
       "ip2F6QsaXHeWkaRryAyt1oHvzsMYW1ktfdOs8ssNUiwv52N83ZEZbAr7Fh+i" +
       "KNSF8M1g0gpXcQMLVL2px11xUdWnrKSV10kcdTa8DOxHHYsobvIUYU+BovtC" +
       "q4RztBFasswCyfZns6paLLed5rrmec2RJ/T52YSFegpXQWFJ7bRdXlvRxCKi" +
       "O1w/YWNoqa67axXSBnUY2Zhzs5t6xZCZ08WyjpY5tm75Y7sz0zuog049GEVH" +
       "qt2LiV5jXAzn81467Ma86UwGXr0TrBpCspqMGwRDI5K/NLTiWC1hHRiYjhTE" +
       "QUCytOi4HiyDDHlSgo3RCm2nAwWyqXWzhakNkqiwYjLuw/EY6q6JOpFgPOPM" +
       "uos2GgUjtqURyrhNzhimhcmuP6Rwg9BK0yRBgHV3kgH4pD2RoBQFbkhOeYgp" +
       "reZs7A0lHB6kwALpPrEkGVoPRlBlYtOrll9abKoJg2prifd9BF9Bc70epS1k" +
       "TcwkwCoXqoZSqq90lhG4UakuVMarxbCFbnRTHNXNIhR0Zhswk9q1YhNh9EVJ" +
       "sGlkXrM13oJ5zpz5TOpuSlW1Jw9QmO4b0sjsUQ1yU2dqEtNcT6N6PNzoG2MG" +
       "RXFNGtdrzWXRXtWXHU8qOzAUzzSms0YXg96wMilNa/EEr8+HYYlG8ARXwMQ/" +
       "R5WS5U2ASagqMm2W3bK/nNUalWZzZK9wLlxwolUU4sYk2sxbgrBmYaVeqxv+" +
       "nONqRsitIm8kd8ttvrfgGyCu9YexxLQldU0yeqwLxCgleVuVKUeZ4OTGDGQI" +
       "Lc51uOU62sbbNGFNXY5XDVf2hhheMVcQO7PJITdY10VmbhsrTYtYZzpKqpBC" +
       "9ip8xZnhfUTCVIiuRabKwrE/hvg6OZp1bYyoudpilEBasczOmlMIs3utjWLJ" +
       "wXqO476KhGuV8DcLxECrwxDkIALZXk7RPjWa8z7TrRfpIWyvGWhoMlylk8xw" +
       "a10L5xEN0WpnVp2WUcmYMiarT7uTekdew8rExCdyrerMIVi11sP1giJbcMoo" +
       "lShWZ7UeFvJtcYYnCC9yC7nUm+kpb7a9ke3ji1JIasEEIaoR2uyVSH6iya32" +
       "UI0mZoIhFpiK4mA5UJbcpjYd88KkUdV4mmkPWqixkDsDYl2Uh4PWCKvMKVnV" +
       "OvKqREqddhUpSlQrxHCJxTr1dA4meR62mo2mOQwcoruqiYMGcE6kHnlU08Jn" +
       "U5sdtNfKcOpoVd5S2otYiGlVbXb52bKWyAnSgeo0SoCQRG9q1U2zBTWH9LA4" +
       "K/sC4TElAbc2cYmEHDDlrad41St5TRitjAfabGVhYxWhNSSZrEQ4VZubNuoR" +
       "RsVo2VVZxrQqktaocTnty76rcmRo8CA1Y8sjG5tFlo6REEglkw6rymOosiKC" +
       "WSLxy7lgj3FIjAyxqiyxlipDhBcyZbE9rHQ2ZRqnInJiDiYTY9E3rKqUqCWp" +
       "olDSxO7GxTISls3hqMZuxDHB1LWk2U653iIxLYjcKKXSvIx5sNpkveJw1W+N" +
       "dYOrsM7C4yitHsnwDKPTGjGfQoHdrzUcGTXhCCzUo1UHL8EKK01jbBOPhTSY" +
       "qHijInU7PklDIlHBVJghSobvdCJRQRtNHBrVV3BP92XYweezcBGQZQPk5DNv" +
       "0bTUKZPWSR+kqmtpNpgQMey0psvypkpr+AChXbmvtqqV0ZBLFDnqs8VAW8pT" +
       "zmQS0h5RDMMTlMEPcKIPt9pYveayMw3XHLUzXFCIHjfLaq+GcniExJwJxUEd" +
       "BOW6PbFaZImLOHGio8NVSZ7PlhYcheGgBYcbhmvas44AwWJ5UVtg7lD0B+Xy" +
       "hFmPML7UX1ilQSXtQUmzhZa7a6ZNxkKVgGWZhMv1uINXU4VctdAgGM/6k5TR" +
       "pWFaN6dkn+hgCkGyaSIkcwpd8Y1lf4MQmwHO2m1xMcVXy7LWSqaWXal3WD2o" +
       "mJ0OR7K6rK+oim1XbUwyXZuHWGPiOwu7VK0GJuSVqWLH7076y2C19ik6xFBv" +
       "0uHsQa/lN5WWA9jRdJ7rahvAethuaHWBngwjMtis/HUcClVKE2I9IBoNc416" +
       "ZZLQfSqCOtURDVYNm5mqWdS44kqksBR6pjrijJJuo6Ysj9glIIvvtFZCLZnD" +
       "LFOyxqJKlIsIPhtiA3/dnWtmE+cogkzZwNlQuKwiVc9n1mhQg3ozkL4J2sSA" +
       "jCXDjVh+2hecUBzSG0OYjanFzCH4AVzG3YCRdGEosWwzROaGSI7aKdOuVaXS" +
       "tFkV14uyGLURrhEOnJbULroi3EnrfIVq1iKkTc4tujf15iPLSaf1Gpk0lgO9" +
       "ZWCoWcTiMlZhNHU26CZpMxYZEYUxA+70nAlRheeDQGoiM0VyIy5aVLmGyBsb" +
       "rb3ZRK6C6LiQ1ItGcdWcrcdWhYi7gt6XGta0KCZum+QHES3B4UDHIsquiIOQ" +
       "UbQJM9JCdS75Aerj2maRdGthgJcMXdEWKco3R7wIzSKQ/lWsYYJSY0JQRw3M" +
       "rKdpm9IgCSLqGFGEkLADlsLZEvm9r23pfl++S3F0YgxW7FmD+xpW58mFO6an" +
       "ThlPnngcb2DuHO6IvFF1wn0/ckJzqe6T9PhmIwx9U4rC7Owi25Z+5OVOi/MN" +
       "+E+9//kXFObTpd2DHVY0LNwZut6P2+patU+MdzvA9JaX3/Ea5BtPx7uWX3n/" +
       "f3t4/A7j2ddwovemM3SeRflrgxe/2n6z/Iu7hduO9jBvOcY/3enG6Z3Lu3w1" +
       "jHxnfGr/8pHT++MPn92wDnemr25/3HTCvUz+4oH81XyP/F2mtvcUUNF7xKX0" +
       "3KGeth8ZMB+a9varCfqpfrrvqb4M4EfqUjQd09EBlne8fa+4j1YzdFsO9g6O" +
       "R7JNowNknW67c3PAEOSNvef2gObUvb+vgS8ed9AlTg97ASzFTA5hn+H+v08P" +
       "nr/w9ODjF7T9alb8Yli455Sazttsu808uFGTO/IvvZZThrziw0d83H9oVE8e" +
       "8PHkeduu1y7YeX5qG3XO8LVzOgqcPrdv+6Jn5N0+c4E4fj0r/mmY3UzZXi7I" +
       "vpVjtv/Zj8B2DvYUeJ49YPvZ18D27nHYfUXepaMhX3+++xZuvjr33e5H7+W7" +
       "0XvbveV3PbOXmetNujEgub237zlqfNCS2/O79vf3n7lxaMXuueTlG7BfPjxg" +
       "+I1X4vdohrlsq46+vYHyiaz4N15yhH/34J7Fgepfd7xBjduuo2Zx/7Bte2fD" +
       "dPePLmHlk8J5lH54S2k+2AmHPE/+J43oKxe0fTUrfi8sXJIzurZsXAD+tWT7" +
       "/6ULYL6eFV8MC7dnQercbfK1a56w4X/5I9hwPh88fqtBfefVGdTZuTivkF0v" +
       "3c4Lp45Tc3vKAWzlwNBubX8K2NvTN966p65F+6kt7Dau5odkoFtomMH241yw" +
       "/ODqECz/yMAOovUJwBs/QnD+kwuD83+6oO1bWfFHIBodiin7/rljTf7xazrq" +
       "BUH+lACzGxkP3XK5cXshT/78C1fvePAF/o+3522Hl+bupAp3aJFtnzz6PPF+" +
       "2fNVzcxJv3N7ELoV2HeADWbBOHv/c++cc6vtOWyycyK5OjC9nM/7X4nPoy4n" +
       "L9tkCVl+xfMweYq2lzxvyl94oUe/5we1T28v+8i2uNlkWO6gCle2946OErDH" +
       "XhbbIa7Lnad/eO8X73zyMFm8d0vwsZ2coO1N59+sIZdemN+F2fzbB//12z7z" +
       "wrfyY7S/A/qCCyB7KwAA");
}
