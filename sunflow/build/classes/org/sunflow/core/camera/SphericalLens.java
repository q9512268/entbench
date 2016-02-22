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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "qnPJJdHF5vJ/ANWIGPbMFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZWsfJ2qBO3sK3Nuvh27Yr1wPWqQFWbFxH+zeo2DD7T/BM/kK0WtUGzdZ40XQ" +
       "udhXpWhblB4cscZxBJ2XPc/WJPfQUv0fdd4/uko+YB+o7XI2eA94bt9T2+3/" +
       "N2o7nwOcv5kAZ4EypLwY/OzNpk+bbj75wZtNnlO9WN7ePz2XN/niz7yGRj+c" +
       "NU8DzLkWDaT1/ga98YZ93J/MVfoLr0elaQTdfuwmJytF33/DxfD2MlP59IuX" +
       "L9z3ovDX+WXGwYXjxQ50QY9t+2jl8Ej/nB9oupkLdHFbR/Tzv9+MoPtucbkE" +
       "RN52cn5/Ywv/YgRdOQkfQWeyv6NgvxVBbzgCBoxur3cU6CWwVwAo637Cv0nR" +
       "cVtBTU8diUN75per+K4fpeIDlKOXHVnsym/m9+NMvL2bv6585kW2+75XK5/Y" +
       "XrYotrTJnelCBzq/vfc5iFWP3pLaPq1z9JM/uOOzF5/Yj6t3bBk+dIUjvD18" +
       "89uMpuNH+f3D5g/v+/13/PaL38hroP8DCEgW/jIhAAA=");
}
