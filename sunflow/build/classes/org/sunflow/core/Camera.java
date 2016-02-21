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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "rnXDwGMUmsPD4n8A3ITmQnAgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "il98+u9/6G+/9nvVZc//BTpuCMsRLAAA");
}
