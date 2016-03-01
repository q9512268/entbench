package edu.umd.cs.findbugs.workflow;
public class Churn {
    edu.umd.cs.findbugs.BugCollection bugCollection;
    int fixRate = -1;
    public Churn() { super(); }
    public Churn(edu.umd.cs.findbugs.BugCollection bugCollection) { super(
                                                                      );
                                                                    this.
                                                                      bugCollection =
                                                                      bugCollection;
    }
    public void setBugCollection(edu.umd.cs.findbugs.BugCollection bugCollection) {
        this.
          bugCollection =
          bugCollection;
    }
    java.lang.String getKey(edu.umd.cs.findbugs.BugInstance b) {
        if (false) {
            return b.
              getType(
                );
        }
        java.lang.String result =
          b.
          getCategoryAbbrev(
            );
        if ("C".
              equals(
                result) ||
              "N".
              equals(
                result)) {
            return result;
        }
        return "O";
    }
    static class Data {
        int persist;
        int fixed;
        int maxRemovedAtOnce() { int count = 0;
                                 for (int c : lastCount.
                                        values(
                                          )) { if (count <
                                                     c) {
                                                   count =
                                                     c;
                                               } }
                                 return count; }
        java.util.Map<java.lang.Long,java.lang.Integer>
          lastCount =
          new java.util.HashMap<java.lang.Long,java.lang.Integer>(
          );
        void update(edu.umd.cs.findbugs.BugInstance bug) {
            if (bug.
                  isDead(
                    )) {
                fixed++;
            }
            else {
                persist++;
            }
            final long lastVersion =
              bug.
              getLastVersion(
                );
            if (lastVersion !=
                  -1) {
                java.lang.Integer v =
                  lastCount.
                  get(
                    lastVersion);
                if (v ==
                      null) {
                    lastCount.
                      put(
                        lastVersion,
                        0);
                }
                else {
                    lastCount.
                      put(
                        lastVersion,
                        v +
                          1);
                }
            }
        }
        public Data() { super(); }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "1ptK1xXvsS5t/vRv7a4MPUweAAA=");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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");
    }
    java.util.Map<java.lang.String,edu.umd.cs.findbugs.workflow.Churn.Data>
      data =
      new java.util.TreeMap<java.lang.String,edu.umd.cs.findbugs.workflow.Churn.Data>(
      );
    edu.umd.cs.findbugs.workflow.Churn.Data
      all =
      new edu.umd.cs.findbugs.workflow.Churn.Data(
      );
    int[] aliveAt;
    int[] diedAfter;
    public edu.umd.cs.findbugs.workflow.Churn execute() {
        data.
          put(
            "all",
            all);
        aliveAt =
          (new int[(int)
                     bugCollection.
                     getSequenceNumber(
                       ) +
                     1]);
        diedAfter =
          (new int[(int)
                     bugCollection.
                     getSequenceNumber(
                       ) +
                     1]);
        for (java.util.Iterator<edu.umd.cs.findbugs.BugInstance> j =
               bugCollection.
               iterator(
                 );
             j.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.BugInstance bugInstance =
              j.
              next(
                );
            java.lang.String key =
              getKey(
                bugInstance);
            edu.umd.cs.findbugs.workflow.Churn.Data d =
              data.
              get(
                key);
            if (d ==
                  null) {
                data.
                  put(
                    key,
                    d =
                      new edu.umd.cs.findbugs.workflow.Churn.Data(
                        ));
            }
            d.
              update(
                bugInstance);
            all.
              update(
                bugInstance);
            long first =
              bugInstance.
              getFirstVersion(
                );
            long last =
              bugInstance.
              getLastVersion(
                );
            if (last !=
                  -1) {
                java.lang.System.
                  out.
                  printf(
                    "%3d #fixed %s%n",
                    last,
                    key);
            }
            if (first !=
                  0 &&
                  last !=
                  -1) {
                int lifespan =
                  (int)
                    (last -
                       first +
                       1);
                java.lang.System.
                  out.
                  printf(
                    "%3d #age %s%n",
                    lifespan,
                    key);
                java.lang.System.
                  out.
                  printf(
                    "%3d %3d #spread %s%n",
                    first,
                    last,
                    key);
                diedAfter[lifespan]++;
                for (int t =
                       1;
                     t <
                       lifespan;
                     t++) {
                    aliveAt[t]++;
                }
            }
            else
                if (first !=
                      0) {
                    int lifespan =
                      (int)
                        (bugCollection.
                           getSequenceNumber(
                             ) -
                           first +
                           1);
                    for (int t =
                           1;
                         t <
                           lifespan;
                         t++) {
                        aliveAt[t]++;
                    }
                }
        }
        return this;
    }
    public void dump(java.io.PrintStream out) {
        for (int t =
               1;
             t <
               aliveAt.
                 length;
             t++) {
            if (aliveAt[t] !=
                  0) {
                java.lang.System.
                  out.
                  printf(
                    "%3d%% %4d %5d %3d #decay%n",
                    diedAfter[t] *
                      100 /
                      aliveAt[t],
                    diedAfter[t],
                    aliveAt[t],
                    t);
            }
        }
        java.lang.System.
          out.
          printf(
            "%7s %3s %5s %5s %5s  %s%n",
            "chi",
            "%",
            "const",
            "fix",
            "max",
            "kind");
        double fixRate;
        if (this.
              fixRate ==
              -1) {
            fixRate =
              (double)
                all.
                  fixed /
                (all.
                   fixed +
                   all.
                     persist);
        }
        else {
            fixRate =
              this.
                fixRate /
                100.0;
        }
        double highFixRate =
          fixRate +
          0.05;
        double lowFixRate =
          fixRate -
          0.05;
        for (java.util.Map.Entry<java.lang.String,edu.umd.cs.findbugs.workflow.Churn.Data> e
              :
              data.
               entrySet(
                 )) {
            edu.umd.cs.findbugs.workflow.Churn.Data d =
              e.
              getValue(
                );
            int total =
              d.
                persist +
              d.
                fixed;
            if (total <
                  2) {
                continue;
            }
            double rawFixRate =
              (double)
                d.
                  fixed /
              total;
            double chiValue;
            if (lowFixRate <=
                  rawFixRate &&
                  rawFixRate <=
                  highFixRate) {
                chiValue =
                  0;
            }
            else {
                double baseFixRate;
                if (rawFixRate <
                      lowFixRate) {
                    baseFixRate =
                      lowFixRate;
                }
                else {
                    baseFixRate =
                      highFixRate;
                }
                double expectedFixed =
                  baseFixRate *
                  total;
                double expectedPersist =
                  (1 -
                     baseFixRate) *
                  total;
                chiValue =
                  (d.
                     fixed -
                     expectedFixed) *
                    (d.
                       fixed -
                       expectedFixed) /
                    expectedFixed +
                    (d.
                       persist -
                       expectedPersist) *
                    (d.
                       persist -
                       expectedPersist) /
                    expectedPersist;
                if (rawFixRate <
                      lowFixRate) {
                    chiValue =
                      -chiValue;
                }
            }
            java.lang.System.
              out.
              printf(
                "%7d %3d %5d %5d %5d %s%n",
                (int)
                  chiValue,
                d.
                  fixed *
                  100 /
                  total,
                d.
                  persist,
                d.
                  fixed,
                d.
                  maxRemovedAtOnce(
                    ),
                e.
                  getKey(
                    ));
        }
    }
    class ChurnCommandLine extends edu.umd.cs.findbugs.config.CommandLine {
        ChurnCommandLine() { super();
                             this.addOption(
                                    "-fixRate",
                                    "percentage",
                                    "expected fix rate for chi test");
        }
        @java.lang.Override
        public void handleOption(java.lang.String option,
                                 java.lang.String optionalExtraPart) {
            throw new java.lang.IllegalArgumentException(
              "unknown option: " +
              option);
        }
        @java.lang.Override
        public void handleOptionWithArgument(java.lang.String option,
                                             java.lang.String argument) {
            if ("-fixRate".
                  equals(
                    option)) {
                fixRate =
                  java.lang.Integer.
                    parseInt(
                      argument);
            }
            else {
                throw new java.lang.IllegalArgumentException(
                  "unknown option: " +
                  option);
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "eOXDt/8DzYXKyiAWAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "//6bfvvFb6VXmP8HWX1GpCUhAAA=");
    }
    public static void main(java.lang.String[] args)
          throws java.lang.Exception { edu.umd.cs.findbugs.DetectorFactoryCollection.
                                         instance(
                                           );
                                       edu.umd.cs.findbugs.workflow.Churn churn =
                                         new edu.umd.cs.findbugs.workflow.Churn(
                                         );
                                       edu.umd.cs.findbugs.workflow.Churn.ChurnCommandLine commandLine =
                                         churn.new ChurnCommandLine(
                                         );
                                       int argCount =
                                         commandLine.
                                         parse(
                                           args,
                                           0,
                                           2,
                                           "Usage: " +
                                           edu.umd.cs.findbugs.workflow.Churn.class.
                                             getName(
                                               ) +
                                           " [options] [<xml results> [<history]] ");
                                       edu.umd.cs.findbugs.SortedBugCollection bugCollection =
                                         new edu.umd.cs.findbugs.SortedBugCollection(
                                         );
                                       if (argCount <
                                             args.
                                               length) {
                                           bugCollection.
                                             readXML(
                                               args[argCount++]);
                                       }
                                       else {
                                           bugCollection.
                                             readXML(
                                               java.lang.System.
                                                 in);
                                       }
                                       churn.
                                         setBugCollection(
                                           bugCollection);
                                       churn.
                                         execute(
                                           );
                                       java.io.PrintStream out =
                                         java.lang.System.
                                           out;
                                       try {
                                           if (argCount <
                                                 args.
                                                   length) {
                                               out =
                                                 edu.umd.cs.findbugs.charsets.UTF8.
                                                   printStream(
                                                     new java.io.FileOutputStream(
                                                       args[argCount++]),
                                                     true);
                                           }
                                           churn.
                                             dump(
                                               out);
                                       }
                                       finally {
                                           out.
                                             close(
                                               );
                                       } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pSYaubE0ZZiiUGxOnUmLRdP+YgLPbKW8");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("WscCJ5m605OCEDhot5KgYMs995LIC4uksGrK6Lq1UMKoWdmULXlVwQRBQsrt" +
       "dbOjrwai0DfLYcK0mQktzmgj1G2l0O+RZg/dELMesHbRXMHwfIbzJj4vL4Op" +
       "kWiCpHQ5BoGX2IIJ2rzWwEbuWCqkSIz6sVBMmxjq2LNaQaJLDapnb8hhX2KY" +
       "2nBZsfBpEhKjYN2cdKelZbSpmUuSi5FpvQGA4foSMxWU76QzbzwUxoat8Y35" +
       "LN4MZ8SGCOp1Gik4nEamwai/MdZu5NRbcigJMxQZga0qUqvbHFaFVbVBwXWh" +
       "zBGh0qm1pGVMYmm74NBoO3EmTDAaxVJUreKCLveLYyFkuaXOlxPc4R1h2fE4" +
       "sjP02uYUXcVVeTAZd1dNDWmDldwWETuodksqWeZIts7IlRBmC6MSS/YROe3S" +
       "2qgQRBG/xquq0vaXMzjuRzVjOKjOVqItUKiosC6+4DUL7sNqz8VDjFj3CEoI" +
       "C2CHt1E9sJmteO2Yw7oYHc79sddLyOmMRYxyoz1BSD9QWnjAR2ORK/ONyKih" +
       "Edu347HqDDZSNyZWjmTO5ZFiB6zIpsuNRLbBFpU2y2uKrMKrKpKuJ0xILgiC" +
       "eO657Ajs39/e0dwD+YnjwbvYH+GsMT3tIU3+dw468ZbyyMHssYurMIAevdFz" +
       "1/x2/lMffPkVTfh06czeie21CLoQef47bH2l20eGujMvf+b4U6DnQEL20EBO" +
       "ng8fEnody3ZylqWnnYXvHAK8Kwf4rzc54f56lv1pBKbRo2OPgU49+1x5pnbI" +
       "+D+7nec/pxGfFfA94vHbIB66Gd37dyeP3+C90/4NRD7Gd2/Cmv+VZd+OoHOG" +
       "HnH6Ole9Q+K/82MQnyvhwyDt3+s6PxnJH8F+5+xN2u7MKr8fQXfpqa7GkX7C" +
       "oH7w48r1aZA+vkfax3+iSn380sz0sscybiRGgS47OWmXbkL2Q1l2MXuLEjs5" +
       "Mt84oHnn7h+D5uw+OH+m9Poeza/fBs1nDn3fLQn/xMGU2bVSfie+szdl/htB" +
       "165/ofUzl5exHJrL2Iv0t20fql7e3u5czq8sL2+v69/z/GVeoBrXOgTfEC8/" +
       "d9nVk72W98uO8sJ7dnd3n7/6jO+nh3Zw2n3pzuN7t1o7T96K3j03n2X/IMuy" +
       "i9Kdx66/KM0+P51lv379zWcuiO20ee/s+3M3UYFnbtJWyLK3Zi3/ZIvJTWDf" +
       "kW5/H/1h1HT7iiNVdX//leUOnGUPA1V0ZNM9oYo/dVuvKiPozvy5RvZu9+Hr" +
       "/nlm+w8f6udeuXT+za8M/+P2IcD+P2VcaEPnZ7FtH31deKR8zg/0mZkL6cL2" +
       "rWEu/J1qBL3lZs9HIuj8fjFDdwffdrsK2HFKNwC9XzwK/c4IungIHUFn1GPN" +
       "ROa8ts0RdBbkRxspUAUas2IjN8AX053jS/qBq3vwVrw+EgU8dcPnVXy8/Yem" +
       "a+rnX2l13v8d7NPb5+mqLW822Sjn29Bd25fyB3fqT9xwtP2xzrHPfO++L1x4" +
       "ej+uuG+L8KEvOYLb46e/BW84fpS/3t785pv/6c/++iuv55el/w9XzJDTZzYA" +
       "AA==");
}
