package org.sunflow.image;
public abstract class SpectralCurve {
    public abstract float sample(float lambda);
    private static final int WAVELENGTH_MIN = 360;
    private static final int WAVELENGTH_MAX = 830;
    private static final double[] CIE_xbar = { 1.299E-4, 2.321E-4, 4.149E-4,
    7.416E-4,
    0.001368,
    0.002236,
    0.004243,
    0.00765,
    0.01431,
    0.02319,
    0.04351,
    0.07763,
    0.13438,
    0.21477,
    0.2839,
    0.3285,
    0.34828,
    0.34806,
    0.3362,
    0.3187,
    0.2908,
    0.2511,
    0.19536,
    0.1421,
    0.09564,
    0.05795001,
    0.03201,
    0.0147,
    0.0049,
    0.0024,
    0.0093,
    0.0291,
    0.06327,
    0.1096,
    0.1655,
    0.2257499,
    0.2904,
    0.3597,
    0.4334499,
    0.5120501,
    0.5945,
    0.6784,
    0.7621,
    0.8425,
    0.9163,
    0.9786,
    1.0263,
    1.0567,
    1.0622,
    1.0456,
    1.0026,
    0.9384,
    0.8544499,
    0.7514,
    0.6424,
    0.5419,
    0.4479,
    0.3608,
    0.2835,
    0.2187,
    0.1649,
    0.1212,
    0.0874,
    0.0636,
    0.04677,
    0.0329,
    0.0227,
    0.01584,
    0.01135916,
    0.008110916,
    0.005790346,
    0.004106457,
    0.002899327,
    0.00204919,
    0.001439971,
    9.999493E-4,
    6.900786E-4,
    4.760213E-4,
    3.323011E-4,
    2.348261E-4,
    1.661505E-4,
    1.17413E-4,
    8.307527E-5,
    5.870652E-5,
    4.150994E-5,
    2.935326E-5,
    2.067383E-5,
    1.455977E-5,
    1.025398E-5,
    7.221456E-6,
    5.085868E-6,
    3.581652E-6,
    2.522525E-6,
    1.776509E-6,
    1.251141E-6 };
    private static final double[] CIE_ybar = { 3.917E-6, 6.965E-6, 1.239E-5,
    2.202E-5,
    3.9E-5,
    6.4E-5,
    1.2E-4,
    2.17E-4,
    3.96E-4,
    6.4E-4,
    0.00121,
    0.00218,
    0.004,
    0.0073,
    0.0116,
    0.01684,
    0.023,
    0.0298,
    0.038,
    0.048,
    0.06,
    0.0739,
    0.09098,
    0.1126,
    0.13902,
    0.1693,
    0.20802,
    0.2586,
    0.323,
    0.4073,
    0.503,
    0.6082,
    0.71,
    0.7932,
    0.862,
    0.9148501,
    0.954,
    0.9803,
    0.9949501,
    1.0,
    0.995,
    0.9786,
    0.952,
    0.9154,
    0.87,
    0.8163,
    0.757,
    0.6949,
    0.631,
    0.5668,
    0.503,
    0.4412,
    0.381,
    0.321,
    0.265,
    0.217,
    0.175,
    0.1382,
    0.107,
    0.0816,
    0.061,
    0.04458,
    0.032,
    0.0232,
    0.017,
    0.01192,
    0.00821,
    0.005723,
    0.004102,
    0.002929,
    0.002091,
    0.001484,
    0.001047,
    7.4E-4,
    5.2E-4,
    3.611E-4,
    2.492E-4,
    1.719E-4,
    1.2E-4,
    8.48E-5,
    6.0E-5,
    4.24E-5,
    3.0E-5,
    2.12E-5,
    1.499E-5,
    1.06E-5,
    7.4657E-6,
    5.2578E-6,
    3.7029E-6,
    2.6078E-6,
    1.8366E-6,
    1.2934E-6,
    9.1093E-7,
    6.4153E-7,
    4.5181E-7 };
    private static final double[] CIE_zbar = { 6.061E-4, 0.001086, 0.001946,
    0.003486,
    0.006450001,
    0.01054999,
    0.02005001,
    0.03621,
    0.06785001,
    0.1102,
    0.2074,
    0.3713,
    0.6456,
    1.0390501,
    1.3856,
    1.62296,
    1.74706,
    1.7826,
    1.77211,
    1.7441,
    1.6692,
    1.5281,
    1.28764,
    1.0419,
    0.8129501,
    0.6162,
    0.46518,
    0.3533,
    0.272,
    0.2123,
    0.1582,
    0.1117,
    0.07824999,
    0.05725001,
    0.04216,
    0.02984,
    0.0203,
    0.0134,
    0.008749999,
    0.005749999,
    0.0039,
    0.002749999,
    0.0021,
    0.0018,
    0.001650001,
    0.0014,
    0.0011,
    0.001,
    8.0E-4,
    6.0E-4,
    3.4E-4,
    2.4E-4,
    1.9E-4,
    1.0E-4,
    4.999999E-5,
    3.0E-5,
    2.0E-5,
    1.0E-5,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0,
    0.0 };
    private static final int WAVELENGTH_STEP = (WAVELENGTH_MAX - WAVELENGTH_MIN) /
      (CIE_xbar.
         length -
         1);
    static { if (WAVELENGTH_STEP * (CIE_xbar.length - 1) != WAVELENGTH_MAX -
                   WAVELENGTH_MIN) { java.lang.String err = java.lang.String.
                                       format(
                                         ("Internal error - spectrum static data is inconsistent!\n  * " +
                                          "min = %d\n  * max = %d\n  * step = %d\n  * num = %d"),
                                         WAVELENGTH_MIN,
                                         WAVELENGTH_MAX,
                                         WAVELENGTH_STEP,
                                         CIE_xbar.
                                           length);
                                     throw new java.lang.RuntimeException(
                                       err); } }
    public final org.sunflow.image.XYZColor toXYZ() {
        float X =
          0;
        float Y =
          0;
        float Z =
          0;
        for (int i =
               0,
               w =
                 WAVELENGTH_MIN;
             i <
               CIE_xbar.
                 length;
             i++,
               w +=
                 WAVELENGTH_STEP) {
            float s =
              sample(
                w);
            X +=
              s *
                CIE_xbar[i];
            Y +=
              s *
                CIE_ybar[i];
            Z +=
              s *
                CIE_zbar[i];
        }
        return new org.sunflow.image.XYZColor(
          X,
          Y,
          Z).
          mul(
            WAVELENGTH_STEP);
    }
    public SpectralCurve() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "He18ZTwsvO5u1Rq3TWYrDH28EY2xlmJQAgoxECs06zDaG7T9Yt9hfEQeKusA" +
       "ZHOzdGFDFh14QXcRRn6nQUV5tEwEot00ZEOb77gdqQF3XexExIsDh51oLMnS" +
       "dgah+Qrn0ZiQtrS7KlpuKHVnroE1sLbLqztvlEi5TZA6OkIae67vkOOmaUD8" +
       "XgJTCYssKWzVJkFwQFsSt53QO4OAuqzJOku5TmXdbrnU//KDbUE8XW2pnNxz" +
       "cVysbPibD7DLkN9vYzepXZWVOAFLsyQ/2aeqftdq9z6EPnNQVytPPp67192W" +
       "6tTjS5967XWN/fnm5aM9yFlSeywJwj/r6jvdPYPqsGucnJDxbIn+RfA8dUTG" +
       "Uxe3y06lcJ996793EOWFTdGzG+EXtnGuGG4gJ1Wvf3KfrdR/Xhb/qDy9Auvf" +
       "w32UN0818mvfa9/nLLq7MV5u9XtHjHvviPHRXRk/y8LX79P2r8via0AaSbAW" +
       "peMdvGfvvFICWkmwqo1Oef9XD8J7ntSePHcrpTxWf/8dV9oO17DUr7x+7er7" +
       "Xl/+28PRyvFVqcfo2lUjdd2zp6Bn6o+EkW7YFVePHc5Ew+rv94F73cEP4Lj6" +
       "rwj9xgHw3ye1d50BTGqPHtXOAr2V1B4CQGX1m+FddjwP57v5pfPOcyK0Z76X" +
       "0M7420vnTkSqW4LHpxfp4Z7gbfWrr4+nn3gb/fnDVRDVlYuixHKVrj16uJVy" +
       "cgLywXtiO8b1CPXyd5/65cc+fOzBTx0IPrXCM7S9cPe7Fn0vTKrbEcU/fN/f" +
       "/5G/+/ofVKfE/xePx6EivikAAA==");
}
