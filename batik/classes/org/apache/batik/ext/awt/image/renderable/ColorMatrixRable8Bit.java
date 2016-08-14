package org.apache.batik.ext.awt.image.renderable;
public class ColorMatrixRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.ColorMatrixRable {
    private static float[][] MATRIX_LUMINANCE_TO_ALPHA = { { 0, 0, 0, 0, 0 },
    { 0,
    0,
    0,
    0,
    0 },
    { 0,
    0,
    0,
    0,
    0 },
    { 0.2125F,
    0.7154F,
    0.0721F,
    0,
    0 } };
    private int type;
    private float[][] matrix;
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public int getType() { return type; }
    public float[][] getMatrix() { return matrix; }
    private ColorMatrixRable8Bit() { super(); }
    public static org.apache.batik.ext.awt.image.renderable.ColorMatrixRable buildMatrix(float[][] matrix) {
        if (matrix ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (matrix.
              length !=
              4) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        float[][] newMatrix =
          new float[4][];
        for (int i =
               0;
             i <
               4;
             i++) {
            float[] m =
              matrix[i];
            if (m ==
                  null) {
                throw new java.lang.IllegalArgumentException(
                  );
            }
            if (m.
                  length !=
                  5) {
                throw new java.lang.IllegalArgumentException(
                  );
            }
            newMatrix[i] =
              (new float[5]);
            for (int j =
                   0;
                 j <
                   5;
                 j++) {
                newMatrix[i][j] =
                  m[j];
            }
        }
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit filter =
          new org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit(
          );
        filter.
          type =
          TYPE_MATRIX;
        filter.
          matrix =
          newMatrix;
        return filter;
    }
    public static org.apache.batik.ext.awt.image.renderable.ColorMatrixRable buildSaturate(float s) {
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit filter =
          new org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit(
          );
        filter.
          type =
          TYPE_SATURATE;
        filter.
          matrix =
          (new float[][] { { 0.213F +
             0.787F *
             s,
           0.715F -
             0.715F *
             s,
           0.072F -
             0.072F *
             s,
           0,
           0 },
           { 0.213F -
             0.213F *
             s,
           0.715F +
             0.285F *
             s,
           0.072F -
             0.072F *
             s,
           0,
           0 },
           { 0.213F -
             0.213F *
             s,
           0.715F -
             0.715F *
             s,
           0.072F +
             0.928F *
             s,
           0,
           0 },
           { 0,
           0,
           0,
           1,
           0 } });
        return filter;
    }
    public static org.apache.batik.ext.awt.image.renderable.ColorMatrixRable buildHueRotate(float a) {
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit filter =
          new org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit(
          );
        filter.
          type =
          TYPE_HUE_ROTATE;
        float cos =
          (float)
            java.lang.Math.
            cos(
              a);
        float sin =
          (float)
            java.lang.Math.
            sin(
              a);
        float a00 =
          0.213F +
          cos *
          0.787F -
          sin *
          0.213F;
        float a10 =
          0.213F -
          cos *
          0.212F +
          sin *
          0.143F;
        float a20 =
          0.213F -
          cos *
          0.213F -
          sin *
          0.787F;
        float a01 =
          0.715F -
          cos *
          0.715F -
          sin *
          0.715F;
        float a11 =
          0.715F +
          cos *
          0.285F +
          sin *
          0.14F;
        float a21 =
          0.715F -
          cos *
          0.715F +
          sin *
          0.715F;
        float a02 =
          0.072F -
          cos *
          0.072F +
          sin *
          0.928F;
        float a12 =
          0.072F -
          cos *
          0.072F -
          sin *
          0.283F;
        float a22 =
          0.072F +
          cos *
          0.928F +
          sin *
          0.072F;
        filter.
          matrix =
          (new float[][] { { a00,
           a01,
           a02,
           0,
           0 },
           { a10,
           a11,
           a12,
           0,
           0 },
           { a20,
           a21,
           a22,
           0,
           0 },
           { 0,
           0,
           0,
           1,
           0 } });
        return filter;
    }
    public static org.apache.batik.ext.awt.image.renderable.ColorMatrixRable buildLuminanceToAlpha() {
        org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit filter =
          new org.apache.batik.ext.awt.image.renderable.ColorMatrixRable8Bit(
          );
        filter.
          type =
          TYPE_LUMINANCE_TO_ALPHA;
        filter.
          matrix =
          MATRIX_LUMINANCE_TO_ALPHA;
        return filter;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.image.RenderedImage srcRI =
          getSource(
            ).
          createRendering(
            rc);
        if (srcRI ==
              null)
            return null;
        return new org.apache.batik.ext.awt.image.rendered.ColorMatrixRed(
          convertSourceCS(
            srcRI),
          matrix);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "f52m/FjzxJ2ukFUfaj79oRdeNNifRS4f");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("vTOWUuj+NIy+zzO3pneGmvsPb7FPkJTXJKC3gPTuIyTvPv8y9pRXL+drwKWb" +
       "sddfOvah46VmXE36+Qteiv9amf0KQJmY6eGd5G3fQW5DxzgV9D/6dq8fz65y" +
       "jlOPlJXfAxJxxCniO8Ops6C+fEHbvyizLwLAq2PAZcWvnoL7568A3NWy8lGQ" +
       "qCNw1Hce3O9f0PZvy+xfptC9ANzxN6nnT6H93iuAVn77gJ4EaX4Ebf6dh/Yf" +
       "Lmj7apn90UFu9Om3ilNwf/wKwFWXG8t27Qic9jLAnX4dIy6y4YrcqsN/uwDm" +
       "fy+zr6fQq7TM8YxToL90CvS/vlKgdZA+egT0o98doPOqw5/fGeilatH/lUKv" +
       "roAK5b1oNTXPQf2zVwoVAelTR1A/9V2EeumBC6A+WGb3pNBDFdRxZvLlp+tz" +
       "WC9deaVYOyD9+hHWX/8OYj0L5dEL2h4rs4dT6HUVTCrznaD8Yj4PcS+y1XNo" +
       "H3kFaN9QVr4dpC8dof3Sy0D70jfbt1UfAG+7ufJV8ejyfwX+zRcw5q1l9kQK" +
       "XdVjE8j9MNgJVscLvfHcQocOpkGWT6cse/LlsGyXQq+93W3i8mbkY7f8r8Ph" +
       "fr7+2Rev3vf6F8V/dbiHdXyH/n4Kus/KPO/sRbYz5StRbFoHJ3X/4VpbVKGG" +
       "U+gdLzlcScubFMcPJZhL1w+zNFLoyYtnSaF7nGNGHY9qpdBjdxqVQneB/Gzv" +
       "DuDV7XqDniA/2/O5FLp2vidYv/o92+89AM9pvxS6ciic7YKD2UGXstiLjjWB" +
       "fOnxHa4laazqaSVksrwYB6RaXYg5hLqXzkSrRxZUudRva3gnQ85eJi7JqP6R" +
       "5vgmTXb4V5ob+udenDA/+M32zx4uM+ueWhTlLPdR0L2He9XVpOVtnKfvONvx" +
       "XFfG7/jWQ794/1uOo++HDgSfWvMZ2t50+4vDAz9Kq6u+xa+8/h+8+++++AfV" +
       "1/r/C6ApBcDhNAAA");
}
