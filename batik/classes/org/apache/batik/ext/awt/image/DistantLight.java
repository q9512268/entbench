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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "lTQ4MvSWBK+Kdv6Kbwv+D9FDpywTIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "n4T00vkN9cnUPvpGU3tmD/7cuWWzDGk+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("3uVG+6Dml5TPv0pOfuQb7V/cx6MplpSXl9PXwAq3D4072Sk/e9fejvu6Sjz/" +
       "zYe/8MD7jnf1D+8ZPsWCM7y9+87BX7jthWW4Vv4vnvjV7//Hr/5Jef37/wBZ" +
       "dQSfay4AAA==");
}
