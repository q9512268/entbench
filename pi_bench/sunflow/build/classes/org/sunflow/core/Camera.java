package org.sunflow.core;
public class Camera implements org.sunflow.core.RenderObject {
    private final org.sunflow.core.CameraLens lens;
    private org.sunflow.math.Matrix4[] c2w;
    private org.sunflow.math.Matrix4[] w2c;
    public Camera(org.sunflow.core.CameraLens lens) { super();
                                                      this.lens = lens;
                                                      c2w = (w2c = (new org.sunflow.math.Matrix4[1]));
    }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        int n =
          pl.
          getInt(
            "transform.steps",
            0);
        if (n <=
              0) {
            updateCameraMatrix(
              -1,
              pl);
        }
        else {
            c2w =
              (new org.sunflow.math.Matrix4[n]);
            for (int i =
                   0;
                 i <
                   n;
                 i++) {
                if (!updateCameraMatrix(
                       i,
                       pl)) {
                    org.sunflow.system.UI.
                      printError(
                        org.sunflow.system.UI.Module.
                          CAM,
                        "Camera matrix for step %d was not specified!",
                        i +
                          1);
                    return false;
                }
            }
        }
        w2c =
          (new org.sunflow.math.Matrix4[c2w.
                                          length]);
        for (int i =
               0;
             i <
               c2w.
                 length;
             i++) {
            if (c2w[i] !=
                  null) {
                w2c[i] =
                  c2w[i].
                    inverse(
                      );
                if (w2c[i] ==
                      null) {
                    org.sunflow.system.UI.
                      printError(
                        org.sunflow.system.UI.Module.
                          CAM,
                        "Camera matrix is not invertible");
                    return false;
                }
            }
            else
                w2c[i] =
                  null;
        }
        return lens.
          update(
            pl,
            api);
    }
    private boolean updateCameraMatrix(int index, org.sunflow.core.ParameterList pl) {
        java.lang.String offset =
          index <
          0
          ? ""
          : java.lang.String.
          format(
            "[%d]",
            index);
        if (index <
              0)
            index =
              0;
        org.sunflow.math.Matrix4 transform =
          pl.
          getMatrix(
            java.lang.String.
              format(
                "transform%s",
                offset),
            null);
        if (transform ==
              null) {
            org.sunflow.math.Point3 eye =
              pl.
              getPoint(
                java.lang.String.
                  format(
                    "eye%s",
                    offset),
                null);
            org.sunflow.math.Point3 target =
              pl.
              getPoint(
                java.lang.String.
                  format(
                    "target%s",
                    offset),
                null);
            org.sunflow.math.Vector3 up =
              pl.
              getVector(
                java.lang.String.
                  format(
                    "up%s",
                    offset),
                null);
            if (eye !=
                  null &&
                  target !=
                  null &&
                  up !=
                  null) {
                c2w[index] =
                  org.sunflow.math.Matrix4.
                    fromBasis(
                      org.sunflow.math.OrthoNormalBasis.
                        makeFromWV(
                          org.sunflow.math.Point3.
                            sub(
                              eye,
                              target,
                              new org.sunflow.math.Vector3(
                                )),
                          up));
                c2w[index] =
                  org.sunflow.math.Matrix4.
                    translation(
                      eye.
                        x,
                      eye.
                        y,
                      eye.
                        z).
                    multiply(
                      c2w[index]);
            }
            else {
                return offset.
                  length(
                    ) ==
                  0;
            }
        }
        else
            c2w[index] =
              transform;
        return true;
    }
    public org.sunflow.core.Ray getRay(float x, float y,
                                       int imageWidth,
                                       int imageHeight,
                                       double lensX,
                                       double lensY,
                                       double time) {
        org.sunflow.core.Ray r =
          lens.
          getRay(
            x,
            y,
            imageWidth,
            imageHeight,
            lensX,
            lensY,
            time);
        if (r !=
              null) {
            if (c2w.
                  length ==
                  1) {
                r =
                  r.
                    transform(
                      c2w[0]);
            }
            else {
                double nt =
                  time *
                  (c2w.
                     length -
                     1);
                int idx0 =
                  (int)
                    nt;
                int idx1 =
                  java.lang.Math.
                  min(
                    idx0 +
                      1,
                    c2w.
                      length -
                      1);
                r =
                  r.
                    transform(
                      org.sunflow.math.Matrix4.
                        blend(
                          c2w[idx0],
                          c2w[idx1],
                          (float)
                            (nt -
                               idx0)));
            }
            r.
              normalize(
                );
        }
        return r;
    }
    org.sunflow.core.Ray getRay(org.sunflow.math.Point3 p) {
        return new org.sunflow.core.Ray(
          c2w ==
            null
            ? new org.sunflow.math.Point3(
            0,
            0,
            0)
            : c2w[0].
            transformP(
              new org.sunflow.math.Point3(
                0,
                0,
                0)),
          p);
    }
    org.sunflow.math.Matrix4 getCameraToWorld() {
        return c2w ==
          null
          ? org.sunflow.math.Matrix4.
              IDENTITY
          : c2w[0];
    }
    org.sunflow.math.Matrix4 getWorldToCamera() {
        return w2c ==
          null
          ? org.sunflow.math.Matrix4.
              IDENTITY
          : w2c[0];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Wsq72Fv2f4frDUp6IQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "37cf+dKD7zle3R85MHxqX2d4e+edrwAN");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "3CCpLu0Uv/Lk3//A33n1D6oDov8HmmWn3ScsAAA=";
}
