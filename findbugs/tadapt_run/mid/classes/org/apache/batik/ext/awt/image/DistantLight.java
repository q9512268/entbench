package org.apache.batik.ext.awt.image;
public class DistantLight extends org.apache.batik.ext.awt.image.AbstractLight {
    private double azimuth;
    private double elevation;
    private double Lx;
    private double Ly;
    private double Lz;
    public double getAzimuth() { return azimuth; }
    public double getElevation() { return elevation; }
    public DistantLight(double azimuth, double elevation, java.awt.Color color) {
        super(
          color);
        this.
          azimuth =
          azimuth;
        this.
          elevation =
          elevation;
        Lx =
          java.lang.Math.
            cos(
              java.lang.Math.
                toRadians(
                  azimuth)) *
            java.lang.Math.
            cos(
              java.lang.Math.
                toRadians(
                  elevation));
        Ly =
          java.lang.Math.
            sin(
              java.lang.Math.
                toRadians(
                  azimuth)) *
            java.lang.Math.
            cos(
              java.lang.Math.
                toRadians(
                  elevation));
        Lz =
          java.lang.Math.
            sin(
              java.lang.Math.
                toRadians(
                  elevation));
    }
    public boolean isConstant() { return true; }
    public void getLight(final double x, final double y, final double z,
                         final double[] L) { L[0] = Lx;
                                             L[1] = Ly;
                                             L[2] = Lz; }
    public double[][] getLightRow(double x, double y, final double dx,
                                  final int width,
                                  final double[][] z,
                                  final double[][] lightRow) { double[][] ret =
                                                                 lightRow;
                                                               if (ret ==
                                                                     null) {
                                                                   ret =
                                                                     (new double[width][]);
                                                                   double[] CL =
                                                                     new double[3];
                                                                   CL[0] =
                                                                     Lx;
                                                                   CL[1] =
                                                                     Ly;
                                                                   CL[2] =
                                                                     Lz;
                                                                   for (int i =
                                                                          0;
                                                                        i <
                                                                          width;
                                                                        i++) {
                                                                       ret[i] =
                                                                         CL;
                                                                   }
                                                               }
                                                               else {
                                                                   final double lx =
                                                                     Lx;
                                                                   final double ly =
                                                                     Ly;
                                                                   final double lz =
                                                                     Lz;
                                                                   for (int i =
                                                                          0;
                                                                        i <
                                                                          width;
                                                                        i++) {
                                                                       ret[i][0] =
                                                                         lx;
                                                                       ret[i][1] =
                                                                         ly;
                                                                       ret[i][2] =
                                                                         lz;
                                                                   }
                                                               }
                                                               return ret;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zsXxlLuF5wGHMDRbBfb8HwEn4zpKIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9oVXh8xPfLP1C/tYNM1RduXF9A2wM+7D");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("4k487Gfv2ttxX9fJ57/18BcfeN/x18DDe4ZPceIMb+++PPALd4OkDNXa/fMn" +
       "fvmH/9Grf1Re/f4/El4bMYMuAAA=");
}
