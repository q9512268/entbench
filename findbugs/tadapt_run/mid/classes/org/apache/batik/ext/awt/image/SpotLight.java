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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8e7+PNG8JK6D/4rlei56dCYW13sNJFCVLHjwX1tufbMTgkc7KUtqyoYkbY+7" +
       "p4USy0rGXBZzah/+wI0PrQOJYg4YAh8sCm64lA2MjOc+iikHvFc3Oel5vDOS" +
       "AUI4EML72rFpstzRN9vSrvq7T77z9c/Hrf78+WNcW9kFvDvYdEiGMFUNNjPR" +
       "VBO9mW65ZA3CuPP2rrymWt17AmbshRllyNtWpwmJNpUVmuzRY0rf+v0f6te9" +
       "WkTCy0iFqkvxZRKP8qQcwiu1BiFHp4xLLxPRZagMmmoOleSAxwU9LX+oWJow" +
       "GF/cw89M/OVFPx15h0c1EcYmc/IKC/cN3oTMN39OLvn08P0f/O74T0qF7wWs" +
       "JA9dw7871djN73+Zo2SeOvMsLg99b2T3A5PaLjnK6Z0chtQzUrnFDWR5h/ac" +
       "xxL/DDeW/ClMSntJtWxvtFZLahIzQy9sLqz07gs2Y1n92RsFURW3ZHL0md7V" +
       "7WLrzZ7u9VLMstaGkzCxMiVz4Jpu55Lp3oQZIvyml5PM4u1sbOal81OpYSqw" +
       "IaeeBDU2YFKICioWcFdlVl4dJ16BzRoxUYev/60qXHoZm2vSbK/OxzZ+GtgO" +
       "ZrHtzcdWKZDt2XDNstnO8mErisFZ2KzNNYofNcO6Bna9rfnNop0GQXm1oTuM" +
       "8xomeRoYb/Iwzmua4QIZN8E112Y814fxDYGm8aNmUHwYVE6qkrk0Zega1Vg+" +
       "gbcUKPA5trbSWssn8C2BAvtRM1Kj8iJCg+pWo63agNgreyW+9TRI/ENstjIy" +
       "1pHAysf79v+fdy0+nQ/XQpv3Qh/eP8ofJcN4ey2D+KxokuoJlDUB80Ll0uNN" +
       "kplSllfPomb6Td3HT+1fV3pIJMn8xbLn2Ob96w88rL99NBy2S5jzM1JNRiEw" +
       "pC23peK/jMRPyynCANUTkbZkTJHTpxXfCB+spmb6FxMu3Y48OuPlLSMz3uO1" +
       "VZliQcqFjUGewzQXzee7jxw9OG7KE3wDXIz7C1TuOO8pZO4hY9bZIbdLFTb3" +
       "i+I1p4jmbioG2B74cIAHzsfmHj7VBZiUqDbABvnIC/kz4ZiXMFKkiADzkF2u" +
       "IcuwmCddIYtdHBYpzW0qLHEpXeNDnziPUfTmzAEudKZyhMedh7f46+DwnUpq" +
       "0cHjRYfvaqjMPYjB2ab6HLPM8Tesl8GLN38yadUlg+sKOGGZ5rG7d8qfd+ze" +
       "f/ks+a4wP/0VhVvOqXE2UUt2uVZhUpY0tewNTaPjCA85QXkOt1zA1uRXAX3P" +
       "YPMUxCUZTSgsHjD8We5h3a5tgG1K/HdJyhNf7wqIrykXgEzc4X8lxHNU6oqG" +
       "rq0DwfU7xe80m29ad928fSTe+ciCdIC7lMH2Rjfmq3QjVV1TjeP3e7KDPcbA" +
       "C20xLvQGeweoB0HmZMaPNEC5BwL6XsLmBZB/gIqTz6uccMB1/eLJclnWno1b" +
       "0Q91qy16a+Go/UgDkL0R0HcIm4Mu1Fd7UL82eqizUl1hqP1IA5B9END3d2ze" +
       "caHu9aA+MjqocXF12qJ3Fo7ajzQA2T8C+o5h8wkUbYC6y70LcXAfHT3cq23h" +
       "VxeO2480ANuJgL6vsPkiC7fXy4+PHu61tvBrC8ftR+qPLVQa0FeOTTgLt8fP" +
       "Q0Wjg3smXHFb+HjhuP1IA7DVBfRNwGY8lE+Auyffls7BXzU6+HELvN4Gsb5w" +
       "/H6kARinBfRNx2YSlIg8uuXbIToKmHzKCqhLO/7tNorbC1eAH2kAyLkBfViD" +
       "h2Yx9xEgH7cQG7sC91TjpTFdV6mk5a+6HH19+5T11YBdeIyx0wa9M0BfvPXZ" +
       "YmSrsTpgRo+qivlUxdwTspudXH0XB6j2UmwWMVKZzpyL7X2Xy6cuOGUd4Xad" +
       "nz382Ua0b9R0tM9nxgJ1tCJAR1FsljBSltZRPocr3qgrcUdnS0dPZ2/bCA+P" +
       "ms4O+8xYoM56A3R2DTarXBXZefhgpaOgK09ZQfXY1QjXuzacdwMU5BOo/Eg9" +
       "yEq4HCUeTbhjELaPBgSbHfapwIh4pfaQYRj+O8KQwtv+AP0msJFc67ZbH+Iq" +
       "VhwVxwpXcQoslvlUBN9TNeR8oiY+q5KfGKkqmzhy5RvitCb96VNllJT1J1XV" +
       "/RrFdV9imLSfgyOV4qUKV0eIMTI1+AMW2G/zX5Q7ZAmqIUYa/KgYKYLWPXoY" +
       "Emi+0TASWvfIzYxUe0cCf/7rHncjZCRnHCMl4sY95PswOwzB2x+IU4IGRuad" +
       "5Fud1pjFTEkWRkiJA6vMDj5tXTLhZNZ1bfpnZJ3t8I8T0+cwSfF5Yp+8Z2TF" +
       "yuuPnf+I+I5DVqXhYZxlbJSUik9K+KR4ljPdd7b0XCXLZ58Y/2T5zPQxQo0Q" +
       "2FmPkx1XJt3g+gb62iTPRw5WU+Zbh0O7Lnr+pW0lB8MktIag39etyX3jlzKS" +
       "Jpm2JprvFflqyeTfX7RUfLDulS/fCtXyF6tEHKlNDaLok+9+/nBXv2HsDJPy" +
       "dnBDLU5T/HXkkk1aN5U3mllv3EtielLLHFaOx4Uh4YeLXDO2QsdlnuJ3QIw0" +
       "5n5/kPttVIWqD1FzMc6O04zznH4lDcPdyzXbJmITahr8sC/aYRj2hxdj9nPN" +
       "QxRC17yPR57/Ac+4mv6BLAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV7e9Dk2HVXz+zszOx79uH1svG+Zxd7ZY8e/VB31nGsfkrd" +
       "kvoldbdknLXerdb71a1WWDtxYezCxDZ4bUzK2b9sCGH9KCAVKMrUUhTEJqlU" +
       "JZUiAYJtIFWYGBd2FRgKB8KV+nvPN9/usGPzfaUr9b3n3nt+55x77rlXV69+" +
       "r3R7FJYg37O3hu3F17Q0vrayq9fira9F1/p0dSSFkaa2bCmKOJD3ovL0V+/7" +
       "4Y8+tbxyvnRRLD0oua4XS7HpudFEizx7ral06b7D3I6tOVFcukKvpLUEJ7Fp" +
       "w7QZxS/QpbuOVI1LV+l9FmDAAgxYgAsWYOKQClS6R3MTp5XXkNw4CkofLJ2j" +
       "Sxd9JWcvLj11vBFfCiVnr5lRgQC0cDn/PQOgisppWHryAPsO83WAPwPBL/+N" +
       "n7vy924r3SeW7jPdac6OApiIQSdi6W5Hc2QtjAhV1VSxdL+raepUC03JNrOC" +
       "b7H0QGQarhQnoXYgpDwz8bWw6PNQcncrObYwUWIvPICnm5qt7v+6XbclA2B9" +
       "+BDrDmE3zwcA7zQBY6EuKdp+lQuW6apx6YmTNQ4wXh0AAlD1kqPFS++gqwuu" +
       "BDJKD+x0Z0uuAU/j0HQNQHq7l4Be4tKjN2w0l7UvKZZkaC/GpUdO0o12RYDq" +
       "jkIQeZW49JaTZEVLQEuPntDSEf18j333J37eJd3zBc+qptg5/5dBpcdPVJpo" +
       "uhZqrqLtKt79PP1Z6eGvfex8qQSI33KCeEfzG3/xB+995+OvfX1H81On0Azl" +
       "labELypfkO/93be13tG4LWfjsu9FZq78Y8gL8x/tlbyQ+mDkPXzQYl54bb/w" +
       "tcm/EH7h17Tvni/dSZUuKp6dOMCO7lc8xzdtLexprhZKsaZSpTs0V20V5VTp" +
       "EnimTVfb5Q51PdJiqnTBLrIuesVvICIdNJGL6BJ4Nl3d23/2pXhZPKd+qVS6" +
       "BK7S3eB6rLT7K+5xyYSXnqPBkiK5puvBo9DL8ecKdVUJjrUIPKug1PdgGdi/" +
       "9S70Gg5HXhICg4S90IAlYBVLbVdYjFNpE8OmA4wBnvpeTJvGEvggYHL+T7Kz" +
       "NEd+ZXPuHFDK2066BBuMJtKzVS18UXk5aXZ+8OUXf+v8wRDZk1lcejvo8dqu" +
       "x2tFj4U7BT1eK3q8dtBj6dy5oqOH8p53mgd6s4AHAL7x7ndM39//wMeevg2Y" +
       "nL+5AISek8I3dtGtQ59BFZ5RAYZbeu1zm1+cfQg5Xzp/3Nfm3IKsO/Pqo9xD" +
       "HnjCqyfH2Gnt3vfR7/zwK599yTscbcec954TuL5mPoifPinX0FM0FbjFw+af" +
       "f1L69Re/9tLV86ULwDMAbxhLwHqBo3n8ZB/HBvML+44xx3I7AKx7oSPZedG+" +
       "N7szXobe5jCnUPi9xfP9QMZ35db9ELi8PXMv7nnpg36ePrQzkFxpJ1AUjvdn" +
       "pv6v/OHv/OdyIe59H33fkVlvqsUvHPELeWP3FR7g/kMb4EJNA3T/7nOjT3/m" +
       "ex99X2EAgOKZ0zq8mqct4A+ACoGYP/L14F9/65tf+P3zh0YTg4kxkW1TSQ9A" +
       "5vmlO88ACXp77pAf4FdsMNxyq7nKu46nmropybaWW+mf3vcs+uv/5RNXdnZg" +
       "g5x9M3rn6zdwmP/nmqVf+K2f+x+PF82cU/J57VBmh2Q7Z/ngYctEGErbnI/0" +
       "F3/vsb/5m9KvALcLXF1kZlrhve4oZHAHqPSOM2Kb0HSANtZ78wH80gPfsj7/" +
       "nS/tfP3JyeMEsfaxl//Kn137xMvnj8ywz1w3yR2ts5tlCzO6Z6eRPwN/58D1" +
       "f/Ir10SesfOyD7T2XP2TB77e91MA56mz2Cq66P6nr7z0j3/1pY/uYDxwfILp" +
       "gPjpS//qf//2tc99+xuneLCLqgdMpvhdPjspELwlLt1b6CT3cUBbXljAg4vC" +
       "54v0Wo6nUEapKPuZPHkiOuptjuvlSMD3ovKp3//+PbPv/5MfFKwejxiPDi5G" +
       "8neCvTdPnszl9NaTrpWUoiWgq7zG/oUr9ms/Ai2KoEUFTBTRMASePT02FPeo" +
       "b7/0b/7pP3v4A797W+l8t3Sn7UlqVyq8WukO4E60aAkmhdT/2ffuRtPmMkiu" +
       "FFBL14HfjcJHil/3nG2X3TzgO/SJj/yvoS1/+D/8z+uEULjyU0z1RH0RfvXz" +
       "j7be892i/qFPzWs/nl4/24Hg+LAu9mvOfz//9MV/fr50SSxdUfYi75lkJ7mn" +
       "EkG0Ge2H4yA6P1Z+PHLchUkvHMwZbzs5Vo50e9KbH9ooeM6p8+c7TzjwPFQp" +
       "PQ+up/Z821MnHfi5UvEwKKo8VaRX8+TP7/vLS35orsFQK1qugNFg55P14sDo" +
       "rxR13pMn9E6dxA1V3715xqY3YCx/HB7nSTiNJ+7HwJP4xnkST+PpfTfJEwKu" +
       "5/Z4eu4GPElvhCcw04KFEHG69uQfA1fLm+HqVP2ZPwauvJvh6lQN+jfJ1VVw" +
       "QXtcQTfgav1GuLoS+ZqS2FLYSX3P1dz4NO42N8kdtie3ffmdxt1Lb4S7++1i" +
       "3nVBDOZqhGscmTSPsPfBHwN7f+mNsHfXIXvRaYx95I0z9kCe+y5wVfcYq96A" +
       "sY+fztj5grEYuHTTlex9Bs9NwRz47I3nwCLA24Var/ytZ37nQ6888++LKfuy" +
       "GYGZggiNUzYFjtT5/qvf+u7v3fPYl4t1xAVZinZzxsndlOs3S47tgRTM3n0g" +
       "iVxGpXvBZexJorjHpe0tXaXKoanmy9NZrwsCZXedbw0xUhyaab6ZBsZBsyDY" +
       "XyL//+u8kE75INA5t7dWLawnT17eN4zPnWEYb8+TTx7OJJprxDtXihR5Ozut" +
       "xaXbzJ0H+PSeQ8q7PL9rZz8W3a0P8nDjWssGwzJfauyX7ZbapnftYG8OFKbX" +
       "MR+Wnr+xTTKFaRwGR7/54T95lHvP8gM3scZ+4oTJnmzy7zCvfqP3nPLXz5du" +
       "OwiVrtu4O17pheMB0p2hFiehyx0Lkx7b6aOQ304ZefJsIeEzgvW/e0bZl/Lk" +
       "V8GwVnJR7zRzBvlX09IJF/RXX9cF7QzgHIjMbseu4dcKg/j7p9vSbYUtAQOK" +
       "it3ZY0b11pWtXN1fT820MAIqurqy8X3TuHJoNrv9zROMVt4wo8B87j1sjPZc" +
       "44WP//GnfvuTz3wL+K5+6fZ1HhcDKzjSI5vku8d/+dXPPHbXy9/+eLF8B3Y4" +
       "+mznynvzVr92Ftw8+Y1jUB/NoU6LwU1LUcwUK25NPUB7YkxdAKr7f0cbP3CV" +
       "rEQUsf9Ho5K+IGboZA7j24VlIi2oPxgbVIsc133eHTgDdrHtEc1ug+pb3Z6R" +
       "rjBcjvuztRzT4bps8UrkhcKggnLkwPS7GWfMZS0xhvQci73anLOTLu/OOn7F" +
       "F+pzpqYHTQ6SWHNaQxpV8C/Deqzha6StkAxOYvJa1xWljLsuuR4mC7XcwFRr" +
       "1ZtPJ9ZoWrGpDMMm4wC3aByPLKRGp6w934bdxSbuQBAuY3icpnCobx2m5fp9" +
       "jSH7Uty2zW2NG3SD8tCz+ZRjBZ9yeCyy/UXPqrUH/kTB2I7NIqGoMvwgw5aD" +
       "ThBFVK3RXnUJKbIZxA/6jMj0RdGKWUwz+l2fn1bZZSfiJJ0fSpQzndpWmV1Z" +
       "HQunKMxOG8O2vKzTjBAIVa2PYTxlOU7Q73lC2JvbHdfphUFN4tuzOceykSaH" +
       "KDXHKFvsdCHJ83SyH5iNYbltC5k6G/cxR8pWy05QjaUkDCZpMLS2rlObDfi+" +
       "tBlWjcmku52tFkJHkjzHcTpzQiIk0V8zFc8iKwoqDvqsX24LmiNOjY3YnPct" +
       "bS1YS2cyaC0SiTYrWdZt9+ThVumxLc3mezIbKmRlhWZUY71OcLnWReZW4Kv8" +
       "YOaNTHPY7hBbAVhES5r2e5wUoWSgpwt7sDKULh4MbCpY9aM5vp7zhoCY00Wz" +
       "qfaDjaD2jWqg+DUmjFoTg6kyW6SOMGsST2YjERZgfyaNWxt0FQtNpW9DzQ0x" +
       "Mw3DYa01mN7EPrMIu9PyEJ6aMuUN09rYE4jB1G4pXq8x3oaChbWatck8oYxA" +
       "Gg8npEtA8rjVW8Vks8mXEymrcV5QYaezyrqtEtBkGdQruN/pVjZBteITHUtw" +
       "NEpPHaU5sLJ0rsSuG1X5RXnRa8T2hrbSNkUOtK25Hoya0sAng36CWQ22lcRE" +
       "pysPTbUSohxUpvkN1e7jRm+a9eCRj6fbmsyWF+vRqusofiV1ZTIMmKxW7WJp" +
       "XYI0jJPxBOG9ie8s5xtPGm2i6gKbqarVoLdek+KrkNjhEhmponiCQhUokska" +
       "29kEc8Pty4OkvxwZk2y+dVcEb4vBgq9gUicYpardH8YLQ8axuusvCH3GjQPX" +
       "lbEGmvCxyJo2Vw8Q3YW9QR9yiP5sRpBlM5bWPlRnzXF5C1UnzVbL6Zoo12KF" +
       "OTWCcdpsUiLaZBAqcqaA3ZrPrPkOV5dsRlGkqNsgSY8dTag2jNZhHSEzzzPt" +
       "PoJuttQyaVtjq075zcEqrA79eW/emfSNNtvRjK06EefNsWDUKiTdY+tWtFRW" +
       "4dKilgwTiGW/ZWzyPdMgTqW13MeqQ9pOq7iXQITSVhUqlIe9kTVUeps52Y+q" +
       "k7RKGHMmqzZMpcIvW5SCe+3hOKKJBjbf1CdEp7+palstnq7n8jyKCF/Jlp7f" +
       "rHFLZGZVB5LLtiZcADXqDr6AEAiOfLorQN3pxDSn43Rq+czCCemtYS1D38S5" +
       "ITF21pvtZOVTE7i6Hc82ta1a18eclJRdpmwrlFpzSYKZtCwLr1OEOycn1W7Z" +
       "hDQpxtbhpFteJ2Vpg5sZEqq1CbcwKnbqN3sh6jQqo7U1nKt9DlYaMW75HOUt" +
       "mU5nIy6piPSWGY8j9cjp96eZl1BVYUuw27WzsfupVEWYAWoYNQGqtrMlbMtt" +
       "vF4nOhW4mwpgMIRlCWrBGLpcC9ySg0wOX40VcgVHfCP12PV6naXJLAPsTCZV" +
       "JYxH4hRNGGrK2TJNoC22UhmEXMdfllngoVm0kWGqjJbbsJF2svqqG21Cgd0s" +
       "e0KHndS3eIVdVmr1CFqj0XCYtUf9LWMINmd67Y4PcabRGteG2nDUbM9n3VVc" +
       "a8/YGRYaNh/AVDTjTW9tjVA+62ZZozYpzzZGg9f6fcwrW65bb1bhoNytMkIb" +
       "TWv6NlD6W3E5J0WkukHAcsVlHXk1Y6XJaGDJoV/pj/X11mi0uh2dCjC73WW0" +
       "EZNU25EXN3rhIskXKltFjFBzEUw5otNcxxw9deG12RtVhSGN2K6z2FhCMp7N" +
       "IiVco2VImNTLatNJ5PJ2iDFadebUwqHW3kaOvzQG8JLecAsd7rZSjWl3VDbE" +
       "oKyj2IITpcteK5jq5IwYiNaQkgeVRrSuNVdpZdGhtyKaDQU5jiGsobMqtlmg" +
       "y5G9FbZKK+qyFOLxxFiTW2irVuO7ypCZb9uwGulr0XVwZRDMg8yC0GnQ4nUY" +
       "ihc65mp1DYdGbK/eH9TacCW0NbNaU1vCHC1HbL/bmtHkCnQSJ7rMcIal4AM+" +
       "DraeYMkChPsVfrpFwt6iKWbSEoY2FDIKx8O+YFQEYlmPWk6tYhMYsxoqkGla" +
       "5LqrlIeaXV23h1OCpyodhsaxsOtHcTZhG+tpuA5wDsezhgKToY7XoTmrzBtW" +
       "d91eC2rH7DFdnmVXo8msOWw481pVJMqtZDTCwnDrzGMUJxw5Wk5se8vGc3/j" +
       "gPmNnzlJNhGQUIfWiF6Ltcbc4lpbxOwG1joVJ4NRPRgrGzNBm2aXBG6YptPR" +
       "RJQMxnG8oa1NiXTDN+gF5M373qbXhZVNvcHAw1l3lKLVJaKgHUVwFJgatGCF" +
       "LXscw5YbQ3rtIvURosNDvMIhQRffzKM+0VA3eB1H1RWLlyHRw6bacM1EtNFo" +
       "yBhXJqojiV65g5qIKMt4nPGh223PJ9UlWA+mKQ2329ocbtnM1I378Txdx12R" +
       "lpZUNt42IjrIENyIMAF1G9gk6vKTeVkkacRR8Rk+p8NMxJPGjGZARN2zslbK" +
       "mLOs0veTapX2y95YpNZbx66OmEqCRvJQsuvo0BemwYaSNK3Z5jGhO6BapjdX" +
       "uqo9sytqH601s4mX8oK2hmtIsCA90cHWU3kAD9NMhHqxMRRDMs4UdT4Q2zG2" +
       "aLNR7A7rTic0o66IDTKWFTydVYa1pis1Qt1lPR/pjRcO6nEJU0/BOnjiCTJM" +
       "bTInkSpjSmTrHRTFhDpa0dO20HPqEuvw5EaYdWqBFVqIqBkSOjMgQ1b4wYio" +
       "xqE8BW7crbewJrGOJww6WNXNfsuA/LlXK0sGa4Tadg41uAkFdwB7K2qL+iSx" +
       "jXS8sYZ0dYtA7hhejP11ebyEtVHd0/sKW9G2WBsapJ6VeH27zTfrCG0jCcta" +
       "vj21bX3kOXKNU8skB6H6rOxTfcatpzLtYkO5UdvU6yHdaLDNLTatrjIG7bMT" +
       "s7PxW1jZ1wbwipmMtlu3RbA8Z8mixfVJzk8XeqsJRT5ot5sySVmo1IfJyKan" +
       "TFZOhuhMtM2xEnRXfE/bZONFpmn4Kt00hj180Clv2gsqw1solwyHdV8cVpZC" +
       "QxYpWaW7nAwmGwr1KytHNr0e1sQrCkWQWaQ75AqfNUWTD9oy0Vy7VAu2sopo" +
       "LpjuwDKJdmZ1sYRSko3TUlVKiFWyKfjZHAlosuMvNLbtZuaI1zknIzqJOhC3" +
       "S0ZTl7heqUHtjcv7AQLmlImgr6VgxYyEVROT5BpJj5g6p0V2vUez5fpWUnnb" +
       "gKLBsNcTq2EPV+uBrkKZpsNWBEmVzQhGZsvZehgsOhjPx1gyE5e8LyCxtmE5" +
       "abRqEfXqeGENYzQj0GSyIBblkTBi+LTFi9zUiMhVuz7XqsuyVI2NHjqASbW/" +
       "XbI6vgmocGstjE6mVBZ1OyVZvuYFIDRH2hudx1OtjjhYQ1IbWF2fchqkmC2V" +
       "auE2Q2KTle4E5fFqNkO5lTYqa/igPVJkooUhKb0eAwVpXhMhHZGRRmynVW1u" +
       "6Noiop2m2IQNKuCyWqIoTBOFNbqv2O7c9VAZGTfQYIvWJKjnwbzRtmhkgpAK" +
       "5VSYBO2qOE/XMS0wM95Gl8EIpYhqs9Fh22UVyzRFIpOGREDMKvCURRfFgn65" +
       "6+HSKhsTGFdvQV51Wd9YvCy0alscoRUQD5JcWQmw8nKWakOsUkcINukbdG0d" +
       "jSyzheuLbQUakUkNjdfNsFXX4wkUjOjZWEK62pDjDDqu66MxMl8Z5chZkF0Z" +
       "IlfLJOcLb8+a+oTd9IS63YGIZKvrdoQ3Fxlfg8gOvWYrvUiubmCyZhET081p" +
       "U0yY2pRRT5KFTHHewCGzQStY0kMYj1kvBPOcRpCYRWxpq6nPzPYSE9JG2jFI" +
       "XBn38KjVAGrwua46qzlWVYJqJIk2oCqHokJT1ahtimykBoM09fVoIQrONIw4" +
       "35h4UGCuwZJQ3XCRn6gLElk0ayuMdzZzZjYQM39L4wtssa0pybDHq5WFpLpZ" +
       "uY7xEiI3JkjMNNzU6KNxq09M0G5kr5pTOxYnI08Jy4ERKrzqThF1JGKw3CKg" +
       "kRNVhlA9FTymWiPKE6zNSeGiuRA1fWn40tAYIA1xrC8EdLxaJJmkqBuGrzaH" +
       "HtwxGttOUCFbvMbJy1WHlkZNYyqTuuRvqGXF16WxMFlBw/pgvInXEDFCnKjf" +
       "VWq4KJMQFcyWm1m68RfK2ItsgLfJNjhWm9Q9U4CC6kDvDazAyZbb6mRtxi3g" +
       "u2asbfc5tI8uZvAkBEJtmA491Y3tcFYJwBIQ0SiGo1CIYOZYD84W1TEuEk5A" +
       "8YIEDwxhINDz0cITOo4JIRwxna91KhNSXkOUlg7jIekqK7E1cckWY1cioVEd" +
       "RZvhJmtiKUTxFao3SSS12k1U1F91uY41n1hmn6itmfaqGi84eimyIirrviv2" +
       "y3GdqnMIpGymercqgIWLiHHdbZKMXB2iIKrangWLpSCmttyf8qbVGECDScVe" +
       "jVQVl5FFa0GL1boAY1w1G43TsYeMsa4zslJ00Y/L+QRTw0xuNNlU5zwkyktk" +
       "iNNuCGYVxG7WGSumJKPc0OLtoryys8G07ztY3w/XXd0OthqnL/AJr9PtxJ7C" +
       "eitebLu1uEMObLYt0Z4FNSDYbS7WGBm1+6Ot6jbbNF/lYHJhWRYqsVW+7Nj2" +
       "utyJTc2mabIrDVOwmKkIGr1oD7FxpNpu0i+PqQ1SdauwNYrjGTUP2mg3Y5Ta" +
       "EAFLepes2G1lpG6zhdx3KE5ahiBQgyVgK9gyVVcNd8SO00kLxbejSRWHCQWq" +
       "OCD+pAmCyLeLvnFz21j3Fzt2B8cTVzae");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("F/yjm9ipSo/sch7s3xd/F0snjrQdeZNx5BV9KT9E8NiNTh0WBy2+8OGXX1GH" +
       "X0TP721x4nHpjtjz32Vra80+9rY/f/7i8RcqPwWun95j46dPvlA5BHr6a563" +
       "p6+3c/tHZ5R9M0/+ADBraLvjaIvDjfxCsH/4eluAR1u8EThiDxxx68F954yy" +
       "P8mT/3gEnHAC3B/fCnDkHjjy1oP7b2eU/TBP/usRcOIJcN9/s+DyETHcAze8" +
       "5eDOlc4oK14H/Sgu3QXAjY6+vD+E96e3At5sD97s1sO7+4yy/GjSuUvH4J0w" +
       "zXOXbwW89+/Be/+th/fIGWWP5smDx+CdMM5zD71ZeM+CS92Dp956eFfPKHsu" +
       "T56ISw8CeNPTziUcwnzyzcLMz3JYezCtWw8TOaMMyxMoLj1UOJjTDjgc4nzn" +
       "m8D54L61/tIezl+69TjffUZZAQDM10eOr532fuyS7Hm2JrmHoOtvAvQjeWZ+" +
       "POaX90D/8k2Avu5l+Ql0FwqqC4WOjiefLhAPzpAGkyfduHT3/rTS3DsvcUTb" +
       "vTcBvIi98uMs/3IP+Nd/gsDnZwDPHfC5SVy6vA/8NCO4sPZM9VAQ01shiD/a" +
       "E8S//QkKQj9DEPl3H+ekI4FFJc943yHq1z0xdwbqh/PMp8H17T3U3741g/1i" +
       "QXDxFMCfL2j+2gEHb887zKu09zgo7nFJ+zF+XnLsO5afTEe78x2+7+fCPRcV" +
       "mg3P0HqROEfG/cTbFIqPDhXv3oziU2BBBx+55Cf2H7nu47rdB2HKl1+57/Jb" +
       "X+H/YHc+a/+jrTvo0mU9se2j532PPF/0Q003C5R37E7/+gWED8Wlx8/+9CYu" +
       "3V7cc47PfXBX68Nx6ZEb1YpLt4H0KPVHwKR4GjWgBOlRyo/FpSsnKUH/xf0o" +
       "3cfB9HNIF5cu7h6OknwCtA5I8sdP7g7XvCUuvfN1vjIi5CgOJWWnhHR3HuuR" +
       "oyOzCKUfeD29HlkGP3PsSFTxWeX+8aVk92Hli8pXXumzP/+D2hd3H8AotpRl" +
       "eSuX6dKl3bc4RaP5EainbtjaflsXyXf86N6v3vHs/sL63h3Dh17iCG9PnP61" +
       "Scfx4+L7kOwfvvUfvPtvv/LN4mTN/wWFh06Z7zoAAA==");
}
