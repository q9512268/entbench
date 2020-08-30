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

        System.out.println("getRemainingCapacity(): " + getRemainingCapacity());
        System.out.println("getPercentRemaining(): " + getPercentRemaining());
        // Loop a few times, to create some more work in each ops.
        for (int k = 0; k < PANDA_RUNS; k++) {
          //double[] before = EnergyCheckUtils.getEnergyStats();

          ENT_Util.resetStopwatch();
          ENT_Util.startStopwatch();

          MonteCarlo@mode<?> mcdyn = new MonteCarlo@mode<?>();
          MonteCarlo@mode<*> mc = snapshot mcdyn ?mode[@mode<low>,@mode<low>];

          mc.run();

          //double[] after = EnergyCheckUtils.getEnergyStats();

          //double diff = after[2]-before[2];

          /*
          if (diff < 0) {
            diff += EnergyCheckUtils.wraparoundValue;
          }
          */

          ENT_Util.writeModeFile(String.format("ERun %d: %f %f %f %f\n", k, 0.0, 0.0, 0.0, ENT_Util.elapsedTime()));
          //ENT_Util.writeModeFile(String.format("ERun %d: %f %f %f %f\n", k, after[0]-before[0], after[1]-before[1], diff, ENT_Util.elapsedTime()));
        }

        ENT_Util.closeModeFile();
        //EnergyCheckUtils.DeallocProfile();
    }

    public static void main(String[] args) throws Exception {
        runBenchmark();
    }

    static int getRemainingCapacity(){
        return ENT_Util.Battery.getRemainingCapacity();
    }

    static float getPercentRemaining(){
        return ENT_Util.Battery.percentRemaining();
    }

}
