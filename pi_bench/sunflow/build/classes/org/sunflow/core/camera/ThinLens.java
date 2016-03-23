package org.sunflow.core.camera;
public class ThinLens implements org.sunflow.core.CameraLens {
    private float au;
    private float av;
    private float aspect;
    private float fov;
    private float focusDistance;
    private float lensRadius;
    private int lensSides;
    private float lensRotation;
    private float lensRotationRadians;
    public ThinLens() { super();
                        focusDistance = 1;
                        lensRadius = 0;
                        fov = 90;
                        aspect = 1;
                        lensSides = 0;
                        lensRotation = (lensRotationRadians = 0); }
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
        focusDistance =
          pl.
            getFloat(
              "focus.distance",
              focusDistance);
        lensRadius =
          pl.
            getFloat(
              "lens.radius",
              lensRadius);
        lensSides =
          pl.
            getInt(
              "lens.sides",
              lensSides);
        lensRotation =
          pl.
            getFloat(
              "lens.rotation",
              lensRotation);
        update(
          );
        return true;
    }
    private void update() { au = (float) java.lang.Math.tan(java.lang.Math.
                                                              toRadians(
                                                                fov *
                                                                  0.5F)) *
                                   focusDistance;
                            av = au / aspect;
                            lensRotationRadians = (float) java.lang.Math.
                                                    toRadians(
                                                      lensRotation);
    }
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
                                                      float eyeX;
                                                      float eyeY;
                                                      if (lensSides <
                                                            3) { double angle;
                                                                 double r;
                                                                 double r1 =
                                                                   2 *
                                                                   lensX -
                                                                   1;
                                                                 double r2 =
                                                                   2 *
                                                                   lensY -
                                                                   1;
                                                                 if (r1 >
                                                                       -r2) {
                                                                     if (r1 >
                                                                           r2) {
                                                                         r =
                                                                           r1;
                                                                         angle =
                                                                           0.25 *
                                                                             java.lang.Math.
                                                                               PI *
                                                                             r2 /
                                                                             r1;
                                                                     }
                                                                     else {
                                                                         r =
                                                                           r2;
                                                                         angle =
                                                                           0.25 *
                                                                             java.lang.Math.
                                                                               PI *
                                                                             (2 -
                                                                                r1 /
                                                                                r2);
                                                                     }
                                                                 }
                                                                 else {
                                                                     if (r1 <
                                                                           r2) {
                                                                         r =
                                                                           -r1;
                                                                         angle =
                                                                           0.25 *
                                                                             java.lang.Math.
                                                                               PI *
                                                                             (4 +
                                                                                r2 /
                                                                                r1);
                                                                     }
                                                                     else {
                                                                         r =
                                                                           -r2;
                                                                         if (r2 !=
                                                                               0)
                                                                             angle =
                                                                               0.25 *
                                                                                 java.lang.Math.
                                                                                   PI *
                                                                                 (6 -
                                                                                    r1 /
                                                                                    r2);
                                                                         else
                                                                             angle =
                                                                               0;
                                                                     }
                                                                 }
                                                                 r *=
                                                                   lensRadius;
                                                                 eyeX =
                                                                   (float)
                                                                     (java.lang.Math.
                                                                        cos(
                                                                          angle) *
                                                                        r);
                                                                 eyeY =
                                                                   (float)
                                                                     (java.lang.Math.
                                                                        sin(
                                                                          angle) *
                                                                        r);
                                                      }
                                                      else {
                                                          lensY *=
                                                            lensSides;
                                                          float side =
                                                            (int)
                                                              lensY;
                                                          float offs =
                                                            (float)
                                                              lensY -
                                                            side;
                                                          float dist =
                                                            (float)
                                                              java.lang.Math.
                                                              sqrt(
                                                                lensX);
                                                          float a0 =
                                                            (float)
                                                              (side *
                                                                 java.lang.Math.
                                                                   PI *
                                                                 2.0F /
                                                                 lensSides +
                                                                 lensRotationRadians);
                                                          float a1 =
                                                            (float)
                                                              ((side +
                                                                  1.0F) *
                                                                 java.lang.Math.
                                                                   PI *
                                                                 2.0F /
                                                                 lensSides +
                                                                 lensRotationRadians);
                                                          eyeX =
                                                            (float)
                                                              ((java.lang.Math.
                                                                  cos(
                                                                    a0) *
                                                                  (1.0F -
                                                                     offs) +
                                                                  java.lang.Math.
                                                                  cos(
                                                                    a1) *
                                                                  offs) *
                                                                 dist);
                                                          eyeY =
                                                            (float)
                                                              ((java.lang.Math.
                                                                  sin(
                                                                    a0) *
                                                                  (1.0F -
                                                                     offs) +
                                                                  java.lang.Math.
                                                                  sin(
                                                                    a1) *
                                                                  offs) *
                                                                 dist);
                                                          eyeX *=
                                                            lensRadius;
                                                          eyeY *=
                                                            lensRadius;
                                                      }
                                                      float eyeZ =
                                                        0;
                                                      float dirX =
                                                        du;
                                                      float dirY =
                                                        dv;
                                                      float dirZ =
                                                        -focusDistance;
                                                      return new org.sunflow.core.Ray(
                                                        eyeX,
                                                        eyeY,
                                                        eyeZ,
                                                        dirX -
                                                          eyeX,
                                                        dirY -
                                                          eyeY,
                                                        dirZ -
                                                          eyeZ);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DxZsgoT1HgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KQAA");
}
