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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3xfVL71CsT/6evtnDvexVFsuqtDtfhq6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ergadnIc+uwdWztu68r4fd955BceeM9xaPTIQeBTjzgj2zO3v/w0cPyouq5U" +
       "/Mo7/ukH/skrX6tO2f4PXIv+fIotAAA=");
}
