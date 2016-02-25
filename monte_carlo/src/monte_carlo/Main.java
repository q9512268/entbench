/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */

package monte_carlo;

import utils.kernel;

public class Main {
    static void runBenchmark() {
        // Loop a few times, to create some more work in each ops.
        for (int i = kernel.MC_LOOPS; i > 0; i --) {
            MonteCarlo.main();
        }
    }
    
    public static void main(String[] args) throws Exception {
        runBenchmark();
    }
}
