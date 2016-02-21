package org.sunflow.core.camera;
public class SphericalLens implements org.sunflow.core.CameraLens {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.core.Ray getRay(float x, float y, int imageWidth,
                                       int imageHeight,
                                       double lensX,
                                       double lensY,
                                       double time) { double theta =
                                                        2 *
                                                        java.lang.Math.
                                                          PI *
                                                        x /
                                                        imageWidth +
                                                        java.lang.Math.
                                                          PI /
                                                        2;
                                                      double phi =
                                                        java.lang.Math.
                                                          PI *
                                                        (imageHeight -
                                                           1 -
                                                           y) /
                                                        imageHeight;
                                                      return new org.sunflow.core.Ray(
                                                        0,
                                                        0,
                                                        0,
                                                        (float)
                                                          (java.lang.Math.
                                                             cos(
                                                               theta) *
                                                             java.lang.Math.
                                                             sin(
                                                               phi)),
                                                        (float)
                                                          java.lang.Math.
                                                          cos(
                                                            phi),
                                                        (float)
                                                          (java.lang.Math.
                                                             sin(
                                                               theta) *
                                                             java.lang.Math.
                                                             sin(
                                                               phi)));
    }
    public SphericalLens() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2/6lRuDFTtsW2fdtgQv/BQYbfjASFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
