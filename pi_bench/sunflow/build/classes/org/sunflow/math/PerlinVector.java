package org.sunflow.math;
public class PerlinVector {
    private static final float P1x = 0.34F;
    private static final float P1y = 0.66F;
    private static final float P1z = 0.237F;
    private static final float P2x = 0.011F;
    private static final float P2y = 0.845F;
    private static final float P2z = 0.037F;
    private static final float P3x = 0.34F;
    private static final float P3y = 0.12F;
    private static final float P3z = 0.9F;
    public static final org.sunflow.math.Vector3 snoise(float x) { return new org.sunflow.math.Vector3(
                                                                     org.sunflow.math.PerlinScalar.
                                                                       snoise(
                                                                         x +
                                                                           P1x),
                                                                     org.sunflow.math.PerlinScalar.
                                                                       snoise(
                                                                         x +
                                                                           P2x),
                                                                     org.sunflow.math.PerlinScalar.
                                                                       snoise(
                                                                         x +
                                                                           P3x));
    }
    public static final org.sunflow.math.Vector3 snoise(float x,
                                                        float y) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P1x,
              y +
                P1y),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P2x,
              y +
                P2y),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P3x,
              y +
                P3y));
    }
    public static final org.sunflow.math.Vector3 snoise(float x,
                                                        float y,
                                                        float z) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z));
    }
    public static final org.sunflow.math.Vector3 snoise(float x,
                                                        float y,
                                                        float z,
                                                        float t) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              t),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              t),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              t));
    }
    public static final org.sunflow.math.Vector3 snoise(org.sunflow.math.Point2 p) {
        return snoise(
                 p.
                   x,
                 p.
                   y);
    }
    public static final org.sunflow.math.Vector3 snoise(org.sunflow.math.Point3 p) {
        return snoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z);
    }
    public static final org.sunflow.math.Vector3 snoise(org.sunflow.math.Point3 p,
                                                        float t) {
        return snoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 t);
    }
    public static final org.sunflow.math.Vector3 noise(float x) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P1x),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P2x),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P3x));
    }
    public static final org.sunflow.math.Vector3 noise(float x,
                                                       float y) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P1x,
              y +
                P1y),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P2x,
              y +
                P2y),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P3x,
              y +
                P3y));
    }
    public static final org.sunflow.math.Vector3 noise(float x,
                                                       float y,
                                                       float z) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z));
    }
    public static final org.sunflow.math.Vector3 noise(float x,
                                                       float y,
                                                       float z,
                                                       float t) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              t),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              t),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              t));
    }
    public static final org.sunflow.math.Vector3 noise(org.sunflow.math.Point2 p) {
        return noise(
                 p.
                   x,
                 p.
                   y);
    }
    public static final org.sunflow.math.Vector3 noise(org.sunflow.math.Point3 p) {
        return noise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z);
    }
    public static final org.sunflow.math.Vector3 noise(org.sunflow.math.Point3 p,
                                                       float t) {
        return noise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 t);
    }
    public static final org.sunflow.math.Vector3 pnoise(float x,
                                                        float period) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P1x,
              period),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P2x,
              period),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P3x,
              period));
    }
    public static final org.sunflow.math.Vector3 pnoise(float x,
                                                        float y,
                                                        float w,
                                                        float h) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P1x,
              y +
                P1y,
              w,
              h),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P2x,
              y +
                P2y,
              w,
              h),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P3x,
              y +
                P3y,
              w,
              h));
    }
    public static final org.sunflow.math.Vector3 pnoise(float x,
                                                        float y,
                                                        float z,
                                                        float w,
                                                        float h,
                                                        float d) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              w,
              h,
              d),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              w,
              h,
              d),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              w,
              h,
              d));
    }
    public static final org.sunflow.math.Vector3 pnoise(float x,
                                                        float y,
                                                        float z,
                                                        float t,
                                                        float w,
                                                        float h,
                                                        float d,
                                                        float p) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              t,
              w,
              h,
              d,
              p),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              t,
              w,
              h,
              d,
              p),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              t,
              w,
              h,
              d,
              p));
    }
    public static final org.sunflow.math.Vector3 pnoise(org.sunflow.math.Point2 p,
                                                        float periodx,
                                                        float periody) {
        return pnoise(
                 p.
                   x,
                 p.
                   y,
                 periodx,
                 periody);
    }
    public static final org.sunflow.math.Vector3 pnoise(org.sunflow.math.Point3 p,
                                                        org.sunflow.math.Vector3 period) {
        return pnoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 period.
                   x,
                 period.
                   y,
                 period.
                   z);
    }
    public static final org.sunflow.math.Vector3 pnoise(org.sunflow.math.Point3 p,
                                                        float t,
                                                        org.sunflow.math.Vector3 pperiod,
                                                        float tperiod) {
        return pnoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 t,
                 pperiod.
                   x,
                 pperiod.
                   y,
                 pperiod.
                   z,
                 tperiod);
    }
    public static final org.sunflow.math.Vector3 spnoise(float x,
                                                         float period) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P1x,
              period),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P2x,
              period),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P3x,
              period));
    }
    public static final org.sunflow.math.Vector3 spnoise(float x,
                                                         float y,
                                                         float w,
                                                         float h) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P1x,
              y +
                P1y,
              w,
              h),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P2x,
              y +
                P2y,
              w,
              h),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P3x,
              y +
                P3y,
              w,
              h));
    }
    public static final org.sunflow.math.Vector3 spnoise(float x,
                                                         float y,
                                                         float z,
                                                         float w,
                                                         float h,
                                                         float d) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              w,
              h,
              d),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              w,
              h,
              d),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              w,
              h,
              d));
    }
    public static final org.sunflow.math.Vector3 spnoise(float x,
                                                         float y,
                                                         float z,
                                                         float t,
                                                         float w,
                                                         float h,
                                                         float d,
                                                         float p) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              t,
              w,
              h,
              d,
              p),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              t,
              w,
              h,
              d,
              p),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              t,
              w,
              h,
              d,
              p));
    }
    public static final org.sunflow.math.Vector3 spnoise(org.sunflow.math.Point2 p,
                                                         float periodx,
                                                         float periody) {
        return spnoise(
                 p.
                   x,
                 p.
                   y,
                 periodx,
                 periody);
    }
    public static final org.sunflow.math.Vector3 spnoise(org.sunflow.math.Point3 p,
                                                         org.sunflow.math.Vector3 period) {
        return spnoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 period.
                   x,
                 period.
                   y,
                 period.
                   z);
    }
    public static final org.sunflow.math.Vector3 spnoise(org.sunflow.math.Point3 p,
                                                         float t,
                                                         org.sunflow.math.Vector3 pperiod,
                                                         float tperiod) {
        return spnoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 t,
                 pperiod.
                   x,
                 pperiod.
                   y,
                 pperiod.
                   z,
                 tperiod);
    }
    public PerlinVector() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jT0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "sbv/e+snJVa72SuBf3bK4wHfzop/nN02");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("dVwjVK/uON933ZM+62d8ioc+9RuvtUN7dKjViW9eT8J9GxLu2zUJ+yvR/YMt" +
       "/TUT/+oUJv5NVrx0wET27TuHaL+7C7QPbNA+sGu0Nx2Ksscg/+4pkH8/K763" +
       "DfK/2wXkhzeQH9415JtXojcfg3yI+7+dgvsPs+IH23D/513gvrzBfflNiu6r" +
       "gXrv9Y/kuYYTrW8Av3oKBz/Kipe3cfDKLjh4z4aD9/z/4WB9Y/Qn2znYWw32" +
       "59s4+PEuOHh8w8Hju+bgMMHt5Q68fu+OU9BeyIpzW9DunX+jaB9ND3CDFnyT" +
       "LH4I9G2nAP2ZrLg7yt1yEs57doGztMFZevOseiSX7T16Cth3Z8XDW8A+sguw" +
       "6AYsumuw22etvcIpiFfIHt+C+Gd3gfjJDeInd434NSatvadOgf3+rEC3wMZ2" +
       "AXvTdv33TYreP1lhoU7BmT0csFfbgrO+C5y1Dc7am4dzb41leApOLis6W3B2" +
       "d4GzscHZ2DXOk+ce8RSwclZ8cAvYD+1iomU2YJk3D+zRSLVPAZu9MLKnZ0+q" +
       "n4TW2AXazgZtZ9doXytDLU/BnT2/thdtwx3vAvdgg3uwa9xnVqJnTsJ9jIFP" +
       "nMLAJ7PiuW0MfGwXDPAbBvhdM3BuJXrudAaOcfHXTuHil7Lir27j4tO74OKD" +
       "Gy4+uGsujqxM/uQY5C+cAvlvZcXnt0H+lV1AfmYD+ZldQz6e07+zQvTlU9D+" +
       "vaz44ja0X9oFWmWDVtk12sM0t5nBVtofWvkbp+D+ZlZ8fRvuv/9Gcb87PfQN" +
       "bv3Ns/JRn/72KWgzUvb+SZQ7G54I91u7gGtt4FpvnplPzl+n7AfuZfuBey9t" +
       "Bf6GNwQz4N4GuLdr4D/9dHbK/uBetj+4972tFLzhDcKMgmhDQbRrCl7PfHbK" +
       "puFetmm494OtZLzhXcN3r0TXn8WuyThlQjtlk3Dvf2bFy1sxv+FdwgzzRzeY" +
       "P7przCfPaH9xCtyfZMWfbYX7v3cB97kN3Od2Dfc1prT989uB79+WFTdvA75/" +
       "y40AX0S524++Fp6913rfdb8hsf7dA/mrL1w4d+8Lw/+wejP64LcJzjO5c1ps" +
       "WUdfQzxSP+MFqmasSDi/Ku/0ViguRbmLx7eCo9zN2Z9My/271mL3RLnbjohl" +
       "qNe1o0L3RbmbUqGs+jZvhfHa9zDWr1cu1nvQ9x21ecZY7tJrMXbk1uk7r7nh" +
       "ufpRjqs3J+P1z3I8LX/tBZr9yKvwl9ZvYsuWmKzeVjnH5M6uXwpfdZrd4Hxk" +
       "a29X+zrTeOzHd379/KNXb8beuVb40P+O6Pb2k191rttetHo5OflH9/7DJ//O" +
       "C3+wek3z/wGpu4vtLUUAAA==");
}
