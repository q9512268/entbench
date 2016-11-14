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
      1472161813000L;
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
      1472161813000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4VBP248MmAtNe/vVAv1UP933VF8G8GN1KZqO6egAy7vftVfcR6sZui0HewfH" +
       "I9mm0QGybq/TvTWkceLm3gt7QHPq3t/XwBePO+zhp4e9AJakp4ewz7F/59OD" +
       "Fy88PfjkBW0/nxUfDwv3nlLTeZttd5gHN2pyR/6ZN3LKkFd89IiPBw6N6ukD" +
       "Pp4+b9v1+gU7z89so84ZvnZOR4HT5/YdX/SMvNuvXCCOX8+KXwyzmynbywXZ" +
       "t3LM9i/9AGznYM+A5/kDtp9/A2zvHofd1+RdOhryLee7b+HW63Pf7X70Xr4b" +
       "vbfdW37Pc3uZud6imkOC3XvXnqPGBy25Pb9nf3//uZuHVuyeS16+AfubhwcM" +
       "//61+D2aYS7bqqNvb6B8Kiv+rZcc4d89uGdxoPo3H29QY7brqFncP2zb3tkw" +
       "3f2jS1j5pHAepR/dUpoPdsIhz5P/SSP6wgVtX8yK/xwWLskZXVs2LgD/crL9" +
       "//wFMF/Jis+FhTuzIHXuNvnaNU/Y8L/6AWw4nw+evN2gvvX6DOrsXJxXyK6X" +
       "bueFU8epuT3lALZyYGi3tz8D7O3Zm+/YU9ei/cwWdhtX80My0C00zGD7cS5Y" +
       "fnB1CJZ/ZGAH0foE4M0fIDj//oXB+Q8vaPtGVvwuiEaHYsq+/+mxJn/vDR31" +
       "giB/SoDZjYyHb7vcuL2QJ3/mpWtXH3qJ+73tedvhpbm7yMJVLbLtk0efJ94v" +
       "e76qmTnpd20PQrcC+xawwSwYZ+9/7J1zbrU9h012TiRXB6aX8/nAa/F51OXk" +
       "ZZssIcuveB4mT9H2kuct+bMv9an3fa/2y9vLPrItbjYZlqtk4cr23tFRAvbE" +
       "q2I7xHW5++z37/vcXU8fJov3bQk+tpMTtD1+/s0aYumF+V2Yzb976N+881de" +
       "+kZ+jPa3ik3bv3srAAA=");
}
