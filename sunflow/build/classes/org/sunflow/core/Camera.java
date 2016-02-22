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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "kgk4tJhPcbbk//oODOaEIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UUIoE6G9a02X9azGLZf2ppbVtmimD5lowxjK0u7DrCXwcGuQxt1cXKIR0t5s" +
       "KClax/BmKez8WDF3ziSIOTyeZ46AkrLK5nPVbEzzDZyxON/X7byBtCeNvk5j" +
       "SUOqeTK7ktywb0R6w9CiVFjum+KYaZNWnDqbHKa67nI8r/k47EiOuRLWW9qm" +
       "SaOnZq7lttMhiK1U1YXhcEJOlD4zw7ByO+FTb26b49FqR+fk5sTaQ8qKn3gT" +
       "OxnFmW25k32v6ncVunDafmbf68zpzslB2TO3HZTNjUA34sNZSLlR+8zdrk1U" +
       "m7SfefmVV/XJZxuXj3bulBR6MA2jv+AZW8M7d5xU5tcnzFZ7ct9ztFF3vGF3" +
       "h+PXu+/QfX9xpw3JC5u8z94mXrXDaqRGXB4mHpM9cZaMP/xjU6Ya4XP32Kf8" +
       "Ypl8NoWuZpGupMadNqmuqWHoGUpwOrG/8J22qM6OckFt7ygL3w8e5EhtyJtV" +
       "W/9eaitfb5XJL1ZUX7qH6P+kTH41hR47iH44Xj0caJQ1v3wq7z98C/JeLwvL" +
       "Q+tbR/Le+u6YybWK4NqdJux+MPlKdXjwL0/UcetOhFf1MFMP12D+VZVUI335" +
       "Hjr7Spn8c9DSMtK5sjs5bbjdB48qK/392lvQX0kKPQKe3ZH+dm9Cf9AdVXfh" +
       "pP3J2061pqETpK2q7e/fQxl/VCZfPVFG+favT4X+vbcgdHUA8C7wvHwk9Mtv" +
       "WeizjH/9HnXfKJP/mEI3gFAHlxDCRRh7elkunor3x98N8T5+JN7Hv6vi/dk9" +
       "6v5nmfzXg3iVWEJ4kPKCeP/tzYhXABs49FLe+XjqtruUh/t/2udfvf7Ak6+K" +
       "//Zwent8R+9BFnrAzDzv7PH7mfzVKDbMAyI9eDiMj8q/SxCQ4aLXpdB95V/F" +
       "37cPZFdS6G1nyACaH+XOEl1NoSuAqMxei+5wKnO0lF46sxoezWmlq8e+k65O" +
       "mpy9GVQeN1aXU4+PBrPD9dRb2hdeHY5/9I3uZw83kzRP2e/LXh5goWuHS1In" +
       "x4vvvWtvx31dHXzgW4988cH3Ha/ujxwY");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "PrWvM7y9+87XgPp+lFYXd/a/+uTf/9DfefUPqkOi/weQ/afwNSwAAA==";
}
