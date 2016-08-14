package util;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Set;
import java.util.TreeSet;

import it.unimi.dsi.webgraph.ImmutableGraph;
import it.unimi.dsi.webgraph.Transform;

import jrapl.EnergyCheckUtils;

modes { low <: mid; mid <: high; }

public class PageRankBench { 
  private double alpha;
  private double error = 0.0000001;

  private boolean tadapt = false;

  public PageRankBench(double alpha) {
    this.alpha = alpha;

    String tadaptstr = System.getenv("PANDA_TADAPT");
    if (tadaptstr != null && tadaptstr.equals("true")) {
      this.tadapt = true;
    } else {
      this.tadapt = false;
    }
  }

  public double[] pagerank(PageRankGraph pg) {
    int nnodes = pg.g.numNodes();
    double[] s1 = new double[nnodes];
    double[] s2 = new double[nnodes];
    for (int i = 0; i < nnodes; i++) {
      s1[i] = 1.0/nnodes;
    }

    double[] step = null;
    double[] last = null;
    for (int n = 0; n < 200; n++) {
      // Pass
      double worst = Double.MIN_VALUE;

      if (n % 2 == 0) {
        last = s1;
        step = s2;
      } else {
        last = s2;
        step = s1;
      }

      for (int i = 0; i < nnodes; i++) {
        step[i] = 0;
      }

      double distribute = 0.0;
      for (int i = 0; i < nnodes; i++) {
        // Grab rank distributed across graph when
        if (pg.g.outdegree(i) == 0) {
          distribute += last[i];  
        }

        // Grab all incomming edges
        int[] income = pg.t.successorArray(i); 
        for (int j = 0; j < income.length; j++) {
          int e = income[j];
          step[i] += (last[e]/pg.g.outdegree(e));
        } 
      }

      for (int i = 0; i < nnodes; i++) {
        step[i] += distribute / nnodes;
        step[i] = (1.0 - alpha) + alpha * step[i];

        double diff = Math.abs(last[i] - step[i]);
        if (diff > worst) {
          worst = diff;
        }
      }

      if (worst <= error) {
        break; 
      }

      TemperatureContext@mode<?> dtemp = new TemperatureContext(tadapt);
      TemperatureContext@mode<*> temp = snapshot dtemp ?mode[@mode<low>,@mode<high>];
      temp.sleep();
    }

    return step;
  }

  public static void main(String[] args) {
    if (args.length < 1) {
      System.err.format("usage [INPUT_FILE]\n");
      System.exit(1);
    }

    ImmutableGraph g = null;
    try {
      g = ImmutableGraph.load(args[0]);
    } catch (Exception e) {
      System.err.println("Caught: " + e.getMessage());
      e.printStackTrace(System.err);
    }

    ImmutableGraph t = Transform.transpose(g, null);

    // Ent part
    ENT_Util.initModeFile();

    double[] before = EnergyCheckUtils.getEnergyStats();

    PageRankBench b = new PageRankBench(0.85);
    PageRankGraph pg = new PageRankGraph(g,t);
    double[] r = b.pagerank(pg);

    double[] after = EnergyCheckUtils.getEnergyStats();
    ENT_Util.writeModeFile(String.format("Energy: %f %f %f\n", after[0]-before[0], after[1]-before[1], after[2]-before[2]));

    ENT_Util.closeModeFile();
    EnergyCheckUtils.DeallocProfile();

    /*
    JungAdapter jg = new JungAdapter(g, t);


    PageRank<Integer,Long> pr = new PageRank<Integer,Long>(jg, 0.85);
    //HITS<Integer,Long> pr = new HITS<Integer,Long>(jg, 0.15);

    double tolerence = Double.parseDouble(System.getenv("PANDA_PAGERANK_ALPHA"));
    int iters = Integer.parseInt(System.getenv("PANDA_PAGERANK_ITERATIONS"));

    pr.setMaxIterations(2);
    pr.evaluate();

    double sum = 0;
    Set<Integer> sortedVerticesSet = new TreeSet<Integer>(jg.getVertices());
    for (Integer v : sortedVerticesSet) {
      double score = pr.getVertexScore(v);
      sum += score;
      System.out.println(v + " = " + score);
    }
    System.out.println("s = " + sum * g.numNodes());
    System.out.println("normalizd = " + sum);
    */

  }
}
