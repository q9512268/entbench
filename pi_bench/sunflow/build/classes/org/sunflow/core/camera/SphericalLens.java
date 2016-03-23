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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ouhic+k/UE+tQsIWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "f/++3337b77wjfz8838AT76ByyQhAAA=");
}
