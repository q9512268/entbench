/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * Copyright (c) 1997,1998 Sun Microsystems, Inc. All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */

package monte_carlo;

import java.io.PrintStream;
import utils.Constants;
import utils.Random;
import utils.Stopwatch;
import java.util.logging.Logger;

/**
 * Estimate Pi by approximating the area of a circle.
 *
 * How: generate N random numbers in the unit square, (0,0) to (1,1)
 * and see how are within a radius of 1 or less, i.e.
 * <pre>
 *
 * sqrt(x^2 + y^2) < r
 *
 * </pre>
 * since the radius is 1.0, we can square both sides
 * and avoid a sqrt() computation:
 * <pre>
 *
 * x^2 + y^2 <= 1.0
 *
 * </pre>
 * this area under the curve is (Pi * r^2)/ 4.0,
 * and the area of the unit of square is 1.0,
 * so Pi can be approximated by
 * <pre>
 * # points with x^2+y^2 < 1
 * Pi =~ 		--------------------------  * 4.0
 * total # points
 *
 * </pre>
 *
 */

public class MonteCarlo@mode<?->X> {

private final static Logger LOGGER = Logger.getLogger(MonteCarlo.class.getName());

    //what happens if
    attributor {
      if (ENT_Util.Battery.percentRemaining() >= 0.75) {
        return @mode<high>;
      } else if (ENT_Util.Battery.percentRemaining() >= 0.50) {
        return @mode<high>;
      } else {
        return @mode<high>;
      }
    }

    //TODO use mcase to scale MHz?
    //what will change
    mcase<int> cycles = mcase<int>{low:10000000; mid:16777216; high:20000000; };

    final static int SEED = 113;

    public final double num_flops(int Num_samples) {
        // 3 flops in x^2+y^2 and 1 flop in random routine

        return ((double) Num_samples)* 4.0;

    }

    public final double integrate(int numSamples) {
      System.out.println("numSamples: " + numSamples);
      Random R = new Random(SEED);

      int underCurve = 0;
      for (int count = 0; count < numSamples; count++) {
        double x = R.nextDouble();
        double y = R.nextDouble();

        if ( x*x + y*y <= 1.0) {
          underCurve ++;
        }
      }
      return ((double) underCurve / numSamples) * 4.0;
    }

    public double measureMonteCarlo() {
      double x =0.0;

      //LOGGER.info(cycles); //doesnt work
      x = integrate(cycles);

      System.out.println(x);
      return 0;
    }

    public void run() {
      double res = 0.0;
      res = measureMonteCarlo();
    }

}
