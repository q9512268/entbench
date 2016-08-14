/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */

package monte_carlo;

import utils.kernel;

import jrapl.EnergyCheckUtils;

modes {low <: mid; mid <: high; }

public class Main {
    static void runBenchmark() {
      ENT_Util.initModeFile();
      int PANDA_RUNS = Integer.parseInt(System.getenv("PANDA_RUNS"));

      double[] energyRuns = new double[11];

      // Loop a few times, to create some more work in each ops.
      for (int k = 0; k < PANDA_RUNS; k++) {
        double[] before = EnergyCheckUtils.getEnergyStats();

        MonteCarlo@mode<?> mcdyn = new MonteCarlo@mode<?>();
        MonteCarlo@mode<*> mc = snapshot mcdyn ?mode[@mode<low>,@mode<high>];

        mc.run();

        double[] after = EnergyCheckUtils.getEnergyStats();
        ENT_Util.writeModeFile(String.format("ERun %d: %f %f %f\n", k, after[0]-before[0], after[1]-before[1], after[2]-before[2]));
        energyRuns[k] = after[2]-before[2];
      }

      double energyTotal = 0.0;
      for (int k = 1; k < PANDA_RUNS; k++) {
        energyTotal += energyRuns[k];
      }
      ENT_Util.writeModeFile(String.format("Energy: %f %f %f\n", 0.0, 0.0, (energyTotal / 10.0)));

    }
    
    public static void main(String[] args) throws Exception {
        runBenchmark();
    }
}
