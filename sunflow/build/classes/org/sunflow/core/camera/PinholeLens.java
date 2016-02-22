package org.sunflow.core.camera;
public class PinholeLens implements org.sunflow.core.CameraLens {
    private float au;
    private float av;
    private float aspect;
    private float fov;
    public PinholeLens() { super();
                           fov = 90;
                           aspect = 1;
                           update(); }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        fov =
          pl.
            getFloat(
              "fov",
              fov);
        aspect =
          pl.
            getFloat(
              "aspect",
              aspect);
        update(
          );
        return true;
    }
    private void update() { au = (float) java.lang.Math.tan(java.lang.Math.
                                                              toRadians(
                                                                fov *
                                                                  0.5F));
                            av = au / aspect; }
    public org.sunflow.core.Ray getRay(float x, float y, int imageWidth,
                                       int imageHeight,
                                       double lensX,
                                       double lensY,
                                       double time) { float du = -au +
                                                        2.0F *
                                                        au *
                                                        x /
                                                        (imageWidth -
                                                           1.0F);
                                                      float dv = -av +
                                                        2.0F *
                                                        av *
                                                        y /
                                                        (imageHeight -
                                                           1.0F);
                                                      return new org.sunflow.core.Ray(
                                                        0,
                                                        0,
                                                        0,
                                                        du,
                                                        dv,
                                                        -1);
    }
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
       "M797/j8nVsOZEyYAAA==");
}
