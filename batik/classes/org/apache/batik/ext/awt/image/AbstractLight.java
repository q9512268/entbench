package org.apache.batik.ext.awt.image;
public abstract class AbstractLight implements org.apache.batik.ext.awt.image.Light {
    public static final double sRGBToLsRGB(double value) { if (value <= 0.003928)
                                                               return value /
                                                                 12.92;
                                                           return java.lang.Math.
                                                             pow(
                                                               (value +
                                                                  0.055) /
                                                                 1.055,
                                                               2.4);
    }
    private double[] color;
    public double[] getColor(boolean linear) { double[] ret =
                                                 new double[3];
                                               if (linear) {
                                                   ret[0] =
                                                     sRGBToLsRGB(
                                                       color[0]);
                                                   ret[1] =
                                                     sRGBToLsRGB(
                                                       color[1]);
                                                   ret[2] =
                                                     sRGBToLsRGB(
                                                       color[2]);
                                               }
                                               else {
                                                   ret[0] =
                                                     color[0];
                                                   ret[1] =
                                                     color[1];
                                                   ret[2] =
                                                     color[2];
                                               }
                                               return ret;
    }
    public AbstractLight(java.awt.Color color) { super();
                                                 setColor(
                                                   color);
    }
    public void setColor(java.awt.Color newColor) { color =
                                                      (new double[3]);
                                                    color[0] =
                                                      newColor.
                                                        getRed(
                                                          ) /
                                                        255.0;
                                                    color[1] =
                                                      newColor.
                                                        getGreen(
                                                          ) /
                                                        255.0;
                                                    color[2] =
                                                      newColor.
                                                        getBlue(
                                                          ) /
                                                        255.0;
    }
    public boolean isConstant() { return true; }
    public double[][][] getLightMap(double x, double y, final double dx,
                                    final double dy,
                                    final int width,
                                    final int height,
                                    final double[][][] z) {
        double[][][] L =
          new double[height][][];
        for (int i =
               0;
             i <
               height;
             i++) {
            L[i] =
              getLightRow(
                x,
                y,
                dx,
                width,
                z[i],
                null);
            y +=
              dy;
        }
        return L;
    }
    public double[][] getLightRow(double x, double y, final double dx,
                                  final int width,
                                  final double[][] z,
                                  final double[][] lightRow) {
        double[][] ret =
          lightRow;
        if (ret ==
              null)
            ret =
              (new double[width][3]);
        for (int i =
               0;
             i <
               width;
             i++) {
            getLight(
              x,
              y,
              z[i][3],
              ret[i]);
            x +=
              dx;
        }
        return ret;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3YVT6cKhFZb6e/Tb6e8Y5fSdqEIE5c3e");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("o6POeH+395byhZeG4x94tfnZ/Z0sxZbyMj27ykBX9tfDjo9Ln7lrb0d9Xabe" +
       "+62Hf/b+dx2lPw/vCT7xiFO0PX3nC1B9x4/KK0v5L77t373/37z0lfIU7m8A" +
       "aXmDkXItAAA=");
}
