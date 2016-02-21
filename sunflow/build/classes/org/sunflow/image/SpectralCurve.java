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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Bj9LJXoMw7nafYFr3TB4PH3K4e6/R5fyIwYfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "wQ//7Td+vzrl/b/XLQ/bkikAAA==");
}
