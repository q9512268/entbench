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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ezsBOVqoLDvTwXy3nUCx7rZhKpqqDdWBUwwzxylhdcZky/C2nWTLh/ASTsR0" +
       "SsBrNuj5+DQIvbi+Cpn2OJbB1GDOTUtJQScdjrRpumy50W4rsDxYm7LWrtO3" +
       "4g7SoIX9jBJ0LxakAl+N4ExB8pGNmpqs7rc4Mehmk33LXtNzXArHMESiHX5I" +
       "K/u2WUyyGc+xTrSXl3bStVm4B1aWJDdVqQzHy+X+lx5sG+Lpalvl5IbL1mmX" +
       "DX/rAXYa8vtt7sa1q+oqikNVi/OTvarqd61274PoM4d1tfL047l73WqpTj6+" +
       "+MnXXteFn29cPtqHFOPaY7Ef/EXHSA3nDKrDznF8QsazJfoXwfPUERlPXdwy" +
       "O5XCffau/+FBlBc2Rs9uhl/YynnEdHw1rnr90/tsp/6LsvjV8gRLdYPDTZQ3" +
       "TzXya99t7+csursxXm73u0eMu2+LcfqujJ9l4Wv3afs3ZfFVII3YXyyV4128" +
       "Z++8VgJaCbC4DU95/9cPwnse1548dzOlPFp/7x2X2Q4XsLQvv37t6nten/27" +
       "w/HK8SWpx9jaVTNxnLMnoWfqV4LQMK2Kq8cO56JB9fcHwL3u4AdwXP1XhP7+" +
       "AfA/xLV3nAGMa48e1c4CvRXXHgJAZfXrwV12PQ9nvPml885zIrRnvpvQzvjb" +
       "S+dORar7gccnGMnhhuBt7SuvM/zHvo39/OE6iOao+32J5Spbe/RwM+XkFOT9" +
       "98R2jOsK9fJ3nvqlxz547MFPHQg+tcIztL1w9/sWAzeIqxsS+195zz/6ob/3" +
       "+h9WJ8X/F5JyKKS4KQAA");
}
