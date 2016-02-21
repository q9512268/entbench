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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Cqubpth4HwtI+B95Lyx0Mx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tSY5ojqcwyn1LhZo0rpfKeiIr0wajcQeBC2m3i+taiiF62wQyobJokptkYiY" +
       "oeRWIYGwVWW1kmW611nirD7UEkWzB7Fcqzq6STZprTfE52N3sepwuQpNoVNj" +
       "1hYHybySJ4UVoneXONVBRgtVXtYUXo7qeTEf5DVSCvzpct4wkmqlnzCrmQCr" +
       "yiBWeaWNL1SmVfUac3XtIeWKby77CpbkkCCme5FKzGpUPcY1H/d7frBqzuSB" +
       "xZQnnbDMdQa4IA5641pBkYd1Pl6LwayqKk2F4LoDd7QmxyOR6ufX9ADEkka0" +
       "mOQsk9b6htLu+AzJDs1GiUdWdBeBqxVEnuIWjfl0ZRjTcnVBiG27NrOESFDz" +
       "IUsghkBSQgND5m2ZiXKYZOKAZaiaLclfD0t+uK7r6w6nlmxJQZTBxJhLg1Xd" +
       "KsxKXMOzJuyY7C7FvKf3e8vAjlk/8PFpvVzvqXCRGkt0ZK1LjCvwnBkMZ3Mb" +
       "g2kqhquKCROmOxaFRl2vS222iObUUSWnMFNeKhLEquo16XqzNS5zK6pUpVAz" +
       "Rw5guheXO4teUynakmQpssjl9KHaF3DLm6FxbaY1i51ax6nmw2onR0qmZSM8" +
       "MpPoRR2lYGWKtlnHqJTg/oyoSn5OHrTLy4YAd1WvLOtUoV/kUBAYYLxKDxrD" +
       "ASWb9qAWIEEpUSSkrEurdTOp+m0K14Z41ZyRIl6ct6JlWFV0F8GSfMVhJSN2" +
       "OhJedArDWJgsV60u4NukEYpQmU7StT3MmfYJcbbM49q4O5z27KRgtWBlbNpJ" +
       "V5sUCCUZFeqVoE9Y1Xm9O6FszcRXw1nUH1YIhkGCeW4wmleTQlwaKP2F7VMw" +
       "gecDlUOdVTE/mQWhUhnAMbr2m3jQMThcJysrJRS6BRczsHWQI5LyUC6Ui1Sn" +
       "UlsP3EpQQvpwYyBMV+ao17PcDlrsTTAptEtuw8Q6A2ExnfeKghb4BcwqVJGY" +
       "7S2otTygKoNhi1OLjVaUg+1Obmz24YHNcJK8qJdllZCi1VQjm+5wyVjWpM53" +
       "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" +
       "f/+Zb2U73/8Htx99RLQpAAA=");
}
