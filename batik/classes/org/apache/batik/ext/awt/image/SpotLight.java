package org.apache.batik.ext.awt.image;
public class SpotLight extends org.apache.batik.ext.awt.image.AbstractLight {
    private double lightX;
    private double lightY;
    private double lightZ;
    private double pointAtX;
    private double pointAtY;
    private double pointAtZ;
    private double specularExponent;
    private double limitingConeAngle;
    private double limitingCos;
    private final double[] S = new double[3];
    public double getLightX() { return lightX; }
    public double getLightY() { return lightY; }
    public double getLightZ() { return lightZ; }
    public double getPointAtX() { return pointAtX; }
    public double getPointAtY() { return pointAtY; }
    public double getPointAtZ() { return pointAtZ; }
    public double getSpecularExponent() { return specularExponent; }
    public double getLimitingConeAngle() { return limitingConeAngle; }
    public SpotLight(double lightX, double lightY, double lightZ, double pointAtX,
                     double pointAtY,
                     double pointAtZ,
                     double specularExponent,
                     double limitingConeAngle,
                     java.awt.Color lightColor) { super(lightColor);
                                                  this.lightX = lightX;
                                                  this.lightY = lightY;
                                                  this.lightZ = lightZ;
                                                  this.pointAtX =
                                                    pointAtX;
                                                  this.pointAtY =
                                                    pointAtY;
                                                  this.pointAtZ =
                                                    pointAtZ;
                                                  this.specularExponent =
                                                    specularExponent;
                                                  this.limitingConeAngle =
                                                    limitingConeAngle;
                                                  this.limitingCos =
                                                    java.lang.Math.
                                                      cos(
                                                        java.lang.Math.
                                                          toRadians(
                                                            limitingConeAngle));
                                                  S[0] = pointAtX -
                                                           lightX;
                                                  S[1] = pointAtY -
                                                           lightY;
                                                  S[2] = pointAtZ -
                                                           lightZ;
                                                  double invNorm =
                                                    1 /
                                                    java.lang.Math.
                                                    sqrt(
                                                      S[0] *
                                                        S[0] +
                                                        S[1] *
                                                        S[1] +
                                                        S[2] *
                                                        S[2]);
                                                  S[0] *= invNorm;
                                                  S[1] *= invNorm;
                                                  S[2] *= invNorm;
    }
    public boolean isConstant() { return false; }
    public final double getLightBase(final double x, final double y,
                                     final double z,
                                     final double[] L) { double L0 =
                                                           lightX -
                                                           x;
                                                         double L1 =
                                                           lightY -
                                                           y;
                                                         double L2 =
                                                           lightZ -
                                                           z;
                                                         final double invNorm =
                                                           1.0 /
                                                           java.lang.Math.
                                                           sqrt(
                                                             L0 *
                                                               L0 +
                                                               L1 *
                                                               L1 +
                                                               L2 *
                                                               L2);
                                                         L0 *= invNorm;
                                                         L1 *= invNorm;
                                                         L2 *= invNorm;
                                                         double LS =
                                                           -(L0 *
                                                               S[0] +
                                                               L1 *
                                                               S[1] +
                                                               L2 *
                                                               S[2]);
                                                         L[0] = L0;
                                                         L[1] = L1;
                                                         L[2] = L2;
                                                         if (LS <=
                                                               limitingCos) {
                                                             return 0;
                                                         }
                                                         else {
                                                             double Iatt =
                                                               limitingCos /
                                                               LS;
                                                             Iatt *=
                                                               Iatt;
                                                             Iatt *=
                                                               Iatt;
                                                             Iatt *=
                                                               Iatt;
                                                             Iatt *=
                                                               Iatt;
                                                             Iatt *=
                                                               Iatt;
                                                             Iatt *=
                                                               Iatt;
                                                             Iatt =
                                                               1 -
                                                                 Iatt;
                                                             return Iatt *
                                                               java.lang.Math.
                                                               pow(
                                                                 LS,
                                                                 specularExponent);
                                                         }
    }
    public final void getLight(final double x, final double y,
                               final double z,
                               final double[] L) { final double s =
                                                     getLightBase(
                                                       x,
                                                       y,
                                                       z,
                                                       L);
                                                   L[0] *=
                                                     s;
                                                   L[1] *=
                                                     s;
                                                   L[2] *=
                                                     s; }
    public final void getLight4(final double x, final double y,
                                final double z,
                                final double[] L) { L[3] =
                                                      getLightBase(
                                                        x,
                                                        y,
                                                        z,
                                                        L);
    }
    public double[][] getLightRow4(double x, double y, final double dx,
                                   final int width,
                                   final double[][] z,
                                   final double[][] lightRow) {
        double[][] ret =
          lightRow;
        if (ret ==
              null)
            ret =
              (new double[width][4]);
        for (int i =
               0;
             i <
               width;
             i++) {
            getLight4(
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
      ("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" +
       "xjDSr6qUUoOHhS7/0HWYP+LTkf8BnP6aOdotAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ezLuVqtDqaf02b44X42aCttppEaXDRr+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("bOaOyTWLwmVyLjAlijO1JuYwDXGsuFG73S4OCHz95rbE7i92/w6OLBoWmlf8" +
       "k5vY9UqP7Jge7PcXfxehE8fcjrz5OPJKH8oPHTx2o5OIxcGMz3/45VeU8Rcq" +
       "5/e2S9EIuiNyvR+31I1qHTsdkN9/4fgLmB8D10/ssfETJ1/AHAI9/bXQO9PX" +
       "2wX+wzPqvpEXvw+YXam742uLw5cChWD/4PW2E4/2eCNw7T1w7VsP7ttn1P1x" +
       "XvznI+CEE+D+6FaAI/fAkbce3P84o+4HefHfj4BbngD3vTcLLveI8R648S0H" +
       "dw46o654tfTDCLoLgGOOvuw/hPentwIevwePv/Xw7j6jLj/KdO7SMXgnTPPc" +
       "5VsB7/178N5/6+E9ckbdo3nx4DF4J4zz3ENvFt6z4FL24Cm3Ht7VM+qey4sn" +
       "IuhBAI897RzDIcwn3yzM/OyHuQfTvPUwy2fUVfOiFEEPFQHmtAMRhzjf/SZw" +
       "Prhvrb+wh/MXbj3O95xRVwAA8/WR426nvWu7JLmupYrOIejmmwD9SP4wP07z" +
       "S3ugf+kmQF/34v0EugsF1YVCR8eLTxeIh2dIg86LXgTdvT+tYHvnK45om3gT" +
       "wIvcKz/+8q/3gH/tRwh8fgbwPACfm0bQ5X3gpxnBhY2rK4eCYG+FIP5wTxD/" +
       "/kcoCO0MQeTfgpwTjyQWtfzB+w5Rv+4JuzNQP5w/fBpc39pD/a1b4+wXC4KL" +
       "pwD+XEHz1w84eGc+YN6ku8dB8RtB81v6Acqxb1veqq5350E8z8sFeC4stBec" +
       "odmisI/49tRNCuWGh8p1bka5KbCSgw9f8lP8j1z3Ud3uQzD5S6/cd/ntr8x+" +
       "f3dma/9jrTso6LIWW9bRM8BH7i96garpBco7dieCvQLChyLo8bM/x4mg24vf" +
       "nONzH9y1+nAEPXKjVhF0GyiPUn8ETHynUQNKUB6l/FgEXTlJCcYvfo/SfRxM" +
       "MYd0EXRxd3OU5BOgd0CS335ydxjnbRH07tf58qgthVEgyjslpLvzW48c9b4i" +
       "XX7g9fR6ZKn7zLEjVMXnlPvHneLdB5Uvyl9+ZTD62e83vrD7KEa2xCzLe7lM" +
       "QZd23+cUneZHpp66YW/7fV0k3/XDe79yx7P7i+d7dwwfRoIjvD1x+hcouO1F" +
       "xTcj2T9++z96z9955RvFSZz/B4o4B8vnOgAA");
}
