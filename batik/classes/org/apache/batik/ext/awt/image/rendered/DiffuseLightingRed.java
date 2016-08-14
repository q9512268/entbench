package org.apache.batik.ext.awt.image.rendered;
public class DiffuseLightingRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    private double kd;
    private org.apache.batik.ext.awt.image.Light light;
    private org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap;
    private double scaleX;
    private double scaleY;
    private java.awt.Rectangle litRegion;
    private boolean linear;
    public DiffuseLightingRed(double kd, org.apache.batik.ext.awt.image.Light light,
                              org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap,
                              java.awt.Rectangle litRegion,
                              double scaleX,
                              double scaleY,
                              boolean linear) { super();
                                                this.kd =
                                                  kd;
                                                this.light =
                                                  light;
                                                this.bumpMap =
                                                  bumpMap;
                                                this.litRegion =
                                                  litRegion;
                                                this.scaleX =
                                                  scaleX;
                                                this.scaleY =
                                                  scaleY;
                                                this.linear =
                                                  linear;
                                                java.awt.image.ColorModel cm;
                                                if (linear)
                                                    cm =
                                                      org.apache.batik.ext.awt.image.GraphicsUtil.
                                                        Linear_sRGB_Pre;
                                                else
                                                    cm =
                                                      org.apache.batik.ext.awt.image.GraphicsUtil.
                                                        sRGB_Pre;
                                                java.awt.image.SampleModel sm =
                                                  cm.
                                                  createCompatibleSampleModel(
                                                    litRegion.
                                                      width,
                                                    litRegion.
                                                      height);
                                                init(
                                                  (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                                    null,
                                                  litRegion,
                                                  cm,
                                                  sm,
                                                  litRegion.
                                                    x,
                                                  litRegion.
                                                    y,
                                                  null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        final double[] lightColor =
          light.
          getColor(
            linear);
        final int w =
          wr.
          getWidth(
            );
        final int h =
          wr.
          getHeight(
            );
        final int minX =
          wr.
          getMinX(
            );
        final int minY =
          wr.
          getMinY(
            );
        final java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int[] pixels =
          db.
          getBankData(
            )[0];
        final java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int offset =
          db.
          getOffset(
            ) +
          sppsm.
          getOffset(
            minX -
              wr.
              getSampleModelTranslateX(
                ),
            minY -
              wr.
              getSampleModelTranslateY(
                ));
        final int scanStride =
          sppsm.
          getScanlineStride(
            );
        final int adjust =
          scanStride -
          w;
        int p =
          offset;
        int r =
          0;
        int g =
          0;
        int b =
          0;
        int i =
          0;
        int j =
          0;
        double x =
          scaleX *
          minX;
        double y =
          scaleY *
          minY;
        double NL =
          0;
        final double[][][] NA =
          bumpMap.
          getNormalArray(
            minX,
            minY,
            w,
            h);
        if (!light.
              isConstant(
                )) {
            final double[][] LA =
              new double[w][3];
            for (i =
                   0;
                 i <
                   h;
                 i++) {
                final double[][] NR =
                  NA[i];
                light.
                  getLightRow(
                    x,
                    y +
                      i *
                      scaleY,
                    scaleX,
                    w,
                    NR,
                    LA);
                for (j =
                       0;
                     j <
                       w;
                     j++) {
                    final double[] N =
                      NR[j];
                    final double[] L =
                      LA[j];
                    NL =
                      255.0 *
                        kd *
                        (N[0] *
                           L[0] +
                           N[1] *
                           L[1] +
                           N[2] *
                           L[2]);
                    r =
                      (int)
                        (NL *
                           lightColor[0]);
                    g =
                      (int)
                        (NL *
                           lightColor[1]);
                    b =
                      (int)
                        (NL *
                           lightColor[2]);
                    if ((r &
                           -256) !=
                          0)
                        r =
                          (r &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    if ((g &
                           -256) !=
                          0)
                        g =
                          (g &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    if ((b &
                           -256) !=
                          0)
                        b =
                          (b &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    pixels[p++] =
                      -16777216 |
                        r <<
                        16 |
                        g <<
                        8 |
                        b;
                }
                p +=
                  adjust;
            }
        }
        else {
            final double[] L =
              new double[3];
            light.
              getLight(
                0,
                0,
                0,
                L);
            for (i =
                   0;
                 i <
                   h;
                 i++) {
                final double[][] NR =
                  NA[i];
                for (j =
                       0;
                     j <
                       w;
                     j++) {
                    final double[] N =
                      NR[j];
                    NL =
                      255.0 *
                        kd *
                        (N[0] *
                           L[0] +
                           N[1] *
                           L[1] +
                           N[2] *
                           L[2]);
                    r =
                      (int)
                        (NL *
                           lightColor[0]);
                    g =
                      (int)
                        (NL *
                           lightColor[1]);
                    b =
                      (int)
                        (NL *
                           lightColor[2]);
                    if ((r &
                           -256) !=
                          0)
                        r =
                          (r &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    if ((g &
                           -256) !=
                          0)
                        g =
                          (g &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    if ((b &
                           -256) !=
                          0)
                        b =
                          (b &
                             -2147483648) !=
                            0
                            ? 0
                            : 255;
                    pixels[p++] =
                      -16777216 |
                        r <<
                        16 |
                        g <<
                        8 |
                        b;
                }
                p +=
                  adjust;
            }
        }
        return wr;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hhwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nUY4HJq1htsVuzO6JHccwqf9MHJ4dDgWLddJbIemQ8aSFJWh+7xu+d2xuED6" +
       "das0w5UGzbvd4cTY1LCUdFS/b1UGesNpY+a0soqaYlBEeRKX8CjxmzQqTinR" +
       "VFTXavMOwfbqqKhpnJeQ3hpue6ozYTycruBI2Bn3iKI+QFx7VbNaHtdhbGqM" +
       "ynNuU0hdfyl1Q2qkoO14g3EB6ywSel7mqrzj11bMGklrKDWrNDyiIaK+PpnP" +
       "ByHDs5P1VPQ4oxILHZdjWhpj8QARPy9KqrJAmmK5wRljTGzoNN3HwoQdFe26" +
       "YIIN6FyNzbSQ+n3bH5S5MZ0sVwN6MR92FcqwyAbfCS3bcToR3xFnEkMjy1Y7" +
       "rrd4Bsi32PfFqKsJpo3V2U1cDBojIXINe8Ej6XRGTrgNS9vB0C5Xo3bdKxXR" +
       "6mRJEXQ/EnhUlFeBgBMrALzbnFmSPFdXlU7cokR+Sq47+HpoV9o1dl6vo10v" +
       "xFMrSmocbis0KcmMOuy0l0JrVZ+SVbUeEWlrYc5Xiot41nCIbpZjI7a4UbnR" +
       "NmKiXCGr9fEIEeYjU+HrDtEU/LmvWUYHdkMFaxPVBMOWhWTcbFqEa/e6gk/A" +
       "E6uxJEZtNNxwm1Z31FiM59gAK894F/WnOMfVGXxUD0RDTxZ1fyxgUalUwmaS" +
       "2OXkbhoPi0zSIlWCK1W1ojjV+xN71JXHsu+snUV13ufMdbJU2BQptXm2ixIp" +
       "BTcMdFCq+HDBqREp6raRMc1zBd8ieGrt0XpP8KWxr4zFZbroLLqeWLY0IcSE" +
       "MaPjmNVd4rwVL6trDRONvoNvMKvd6jidgEuJ2OvUEUsgBbTaXAeSgtZQ0x2Y" +
       "fU3h56Zv0ImwUsf9ClPAlVKnJ8pcaKItZhl0lqnudQlNwGalRmotCZlvrpjp" +
       "oqp0N1O23tC6kiJyC5rWRWaxqY/6/CLpzNz6dJNW60pHbjCdQGzxSyWyqlPb" +
       "41ZtqhC5y5FZdvUKPF002y1/jkzsWSv1LZGfI51hb1zmObLZ1BwOVe1aWXZJ" +
       "pyLLM2mOx/HACqsNAu3PjI4758zhEDfrnuaZ+AARaG1EOeKk7a2rDltpUAbS" +
       "atME09fKGteTK7V1MSgjikuRepvTHa7XLHJMe1k1OrQDCzziOU5TThyXgpGR" +
       "N+qapa7TcVtsxzY2YyMirG7Rmo30ebnEcEmwWnajaDqUiWpLDEhgK6RpC7yB" +
       "LMe9kO66fdUKvUJzUuiuHGdAdarrGcx0Nwu8WkgGFhshQ5qh5rjSdVNr0OUS" +
       "DuZ1vhxFuMKntoGUYVUr9IFHUYuSvfGatjKPvPpk1iF7cpFwm2XLpqtFnRdw" +
       "Z6oGChuNVUKKFYEzWmvRifCF0HDKbnMz6PqjBtdxe6MeS+kbqxyYLXGVRigT" +
       "DqdR6LmmRkxqQ3PJynVUw8ggWCzQslVeRL2QRRS4iVjGMjQ7dR1jgIMupGhM" +
       "xVGxKRTggKrPZhW4bvdH/ITpMaJX0IrOatOq98tECseFqragknFMblYsibHk" +
       "RO5qabNEy06DEOD+dKqWNpXqYDMM0/Zgs7EFbRQymzEds2u+b5W8ERcyyx62" +
       "qHIMI9Ctwhyt8HowY+C144iMMWnN9UlSiMOpqwcbeC7LRDqaKSrmlcyQr/al" +
       "pLzmBgmoxdCQcniaMSsjt7uCu5tkzQ+6y4CYDeIhUVoTFZivhti0zPQ4bt1I" +
       "HJiOxaVqerNBZ9ZJF4M6OhsNB6YQlpstQVKWgYTLpRgJKlhSw2QqdvBuoxHF" +
       "66ifBsVSQYYjeRUa49bAwhcYM6h2BVSsm7qxmc7WSVXQnfEK5pRkTPj9Ym9i" +
       "LJXQF+TBpicEU6VKlJIG0xPHzXqxX3YIXNPjQTNkhSZueFq9KJeIKWwhcVLg" +
       "ZN6pIKItI60EV7TUSdNZ2yhOaUxMR8uV2Y2mVTzUE8rH9CSS7WXTlyM5BtMG" +
       "xuykVugMkrLcq0peIwXWO91MiWgqI0yyiafRGiHWRb4VaksdTueSvI7EelGz" +
       "TOB6vArbk/iq0afGYRGxFqWKxhcFZ9BgjYps+K1VwZlTrmO2qalEFsxpYNVD" +
       "LY58A53YTs0uePHUH6xknA8aFa1diqi470sdjiPUynKuy2mxUNqE+FJIl07Y" +
       "8Vr2TExc2TXaBpuyqlw1GiTXIFKZa7bLCApTnFF2J7WpJdb77gDFV7E04NHq" +
       "yJ5H8QhOGaI42mDSbGikCSdLErWEh2XJmdUrwWzT2lR0j1mXiAbXnks0qc+c" +
       "EsLV0RJH+4hHalPYCWy0IMYxFikGI46KnrCQ5IlgU9GImFjaRHS8/oAuT7Uw" +
       "DAaK1BC6hMAIgtmorrih49g2kA4RB90ShUYuugo4nSVqxRKb0hFenm66pusy" +
       "TqNmMaEcIB0V3qgbeGMWe8pgUfOHwohtcdiiB9fWHjPQqzWjSnUMhdJn6xVR" +
       "IAepXyrN3GC69qpkYqsiKYe1cc3Eualu4iO84Cao7HcwE+VMv93kelbQFzFy" +
       "NW6CGEe31nO+rbWbw6S/GuhzMVzEMJGsXWXQVXqVlB3GcVkvzdqhQihaPFa0" +
       "dWE9HuGySy8xEjO6dqmV0n114uACjq0UKvDHIUpjpUabXi1b68k4bnaa2hAf" +
       "c4VxU2FSEsH9FmLWUh5NyRFXLUo4tViybHPTjCdY2sLaNMUyM4KJ+SoXOJ12" +
       "KlIFZhQjs1isdtAiZbvKkIwDkVGocNDqtWR32N5ETZ0sKR5ajcIWilK2Lw3J" +
       "Qnu9YMQNFXaopjNsTIux3OomSQSv+rOpMl0A8chaKMo1ZCHE/TSOKaUM1hle" +
       "GJcLlur5hoJ2ojW71gne6VVsxOCNQmloldxVb+oHvbFo9PqJrY2QFjHzKFYv" +
       "jzt8AzOacgNZrhwQ4yelhs4nq+WotYAraNIfrxWaCvuTmaUgnlstx7HOWSrf" +
       "8gGLbqNTayZ8pzctGitLmuFmn5qOKdbr84hpdX0Wq8HdQXtewSrCIBqWWDES" +
       "3VZcW7mzMVZUG9Vs6UEvqcnUjjalgiOjS7E4nfUKNUakR0VqNC0ntZKFoREy" +
       "b8/WNLkxK2FjpGD1ybDvsbbfFecYwQozoov3ivC0PCkLApivvf6adGONnDY7" +
       "ML5etlpOwGAEPsXK5ELu2pjRll2NrhpKLa3Xxn2eK8ak0KtGiMqpaQFUUrwx" +
       "0RVpbTqFNtytwsC5NEN+tBgyfbk33gh9muWLk5VZ9OJ+UytuNpJdwivCGEEq" +
       "SqJWVga8KeE1FAc6HaHtqqpWsGmHlNkmwsZgV7hcFtgiYvflYNMxjBDBebwj" +
       "yaVE2Cyo0STym3a9lqrFQY2j3Y0yWfWbThvh4BptanyK0y2wkqtZHaUkcQax" +
       "SgKz4qkVR+xKxApfOzo2b8AWI9QVTm+v0KQa47WJjzHlyMCLUT2cN4JSuGwu" +
       "R0nCjftxiWwVZELBrOaUnK7QeEglRXeFMGVlNOxvdEUvuEW/kG4o0jFibGbY" +
       "42CWRHa7nzhht6N4PVGdpLpfstdKYYoVa86mmi12ahMGWFVpEpFtodyPMQRp" +
       "toiiiMPSxsDUgeu7hWKg1VWp3Cxaiza9loTIACLgWWHRnhQ6FNiR0F6fRbzi" +
       "QIswKU4Itwb8GYvN+vyqpUwMpEaLeC3SdXVerbUnzY4b1YUqWSgMSaSCOv7K" +
       "q6RDamGRa26j4UpYNwSx45G1sM53ZdyD55ZR63c8BWEKlAUb/ZYVDOqkN2Bj" +
       "0lVnXnfjoaN0qrLx2pQqRXHVrs5lp4OqRJHEuxhYqroTnK2HRm1WtxGM1LCp" +
       "Ohg1/cHSYYe9bq0WziYprFP0quLC87gZ0F5qGCuweX388Wxb+1svbrt9W36y" +
       "sP8NANhlZxXvfRE76m3VA1nyqv1TmPx3Gjp2b3zoFObQCTSUnZHfc72r/fzO" +
       "4mPveupptf9x9OTuyX0lgs5Fnv86W0s0+1BX2fHFo9c/zO7mXzYcnCh/+V3/" +
       "chf/RuOtL+IS9L5jOI93+bvdZ77aerXyayehm/bPl6/65uJoo8eOniqfD7Qo" +
       "Dlz+yNnyPfuSvWvvKFDalax0/HzrQHfXPtx6eKv7YxcjJ3YFuHuidM/+rcv2" +
       "dmYSmFF2NTeUwkgL8h4++zxXK5/Pkmci6Kzi+WtCiqTs/XMHBvXJFzqiOXJd" +
       "EUGXrr4kz2787rzqs53tpybKp56+cPaOp4W/zu+J9z8HOcdCZ/XYtg+f4R/K" +
       "n/YDTTdz/Oe2J/p+/veHEfSaG7y8AhzvZXM2vrDt4Y8j6N7n7yGCTuX/h1v9" +
       "aQTdeb1WEXQTSA9TfymCXn4takAJ0sOUX4mgi8cpwfj5/2G6r0XQ+QO6CDq9" +
       "zRwm+QboHZBk2b/Yv7HDbvSmry6HEdh0R0Cb6YmjHmHfUi69kKUcciIPHZn6" +
       "+Zdfe9M03n77dUX59NNM723PlT++vYlXbGmzyXo5y0Jnth8F7E/1B67b215f" +
       "p9uP/OTWz5x71Z5bunUL+GACHsJ237WvvUnHj/KL6s0f3PF7b/jtp7+dn5/+" +
       "D/PYvN+SJwAA");
}
