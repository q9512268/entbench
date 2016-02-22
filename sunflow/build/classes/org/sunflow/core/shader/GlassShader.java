package org.sunflow.core.shader;
public class GlassShader implements org.sunflow.core.Shader {
    private float eta;
    private float f0;
    private org.sunflow.image.Color color;
    private float absorbtionDistance;
    private org.sunflow.image.Color absorbtionColor;
    public GlassShader() { super();
                           eta = 1.3F;
                           color = org.sunflow.image.Color.WHITE;
                           absorbtionDistance = 0;
                           absorbtionColor = org.sunflow.image.Color.GRAY;
    }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        color =
          pl.
            getColor(
              "color",
              color);
        eta =
          pl.
            getFloat(
              "eta",
              eta);
        f0 =
          (1 -
             eta) /
            (1 +
               eta);
        f0 =
          f0 *
            f0;
        absorbtionDistance =
          pl.
            getFloat(
              "absorbtion.distance",
              absorbtionDistance);
        absorbtionColor =
          pl.
            getColor(
              "absorbtion.color",
              absorbtionColor);
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        if (!state.
              includeSpecular(
                ))
            return org.sunflow.image.Color.
                     BLACK;
        org.sunflow.math.Vector3 reflDir =
          new org.sunflow.math.Vector3(
          );
        org.sunflow.math.Vector3 refrDir =
          new org.sunflow.math.Vector3(
          );
        state.
          faceforward(
            );
        float cos =
          state.
          getCosND(
            );
        boolean inside =
          state.
          isBehind(
            );
        float neta =
          inside
          ? eta
          : 1.0F /
          eta;
        float dn =
          2 *
          cos;
        reflDir.
          x =
          dn *
            state.
              getNormal(
                ).
              x +
            state.
              getRay(
                ).
              getDirection(
                ).
              x;
        reflDir.
          y =
          dn *
            state.
              getNormal(
                ).
              y +
            state.
              getRay(
                ).
              getDirection(
                ).
              y;
        reflDir.
          z =
          dn *
            state.
              getNormal(
                ).
              z +
            state.
              getRay(
                ).
              getDirection(
                ).
              z;
        float arg =
          1 -
          neta *
          neta *
          (1 -
             cos *
             cos);
        boolean tir =
          arg <
          0;
        if (tir)
            refrDir.
              x =
              (refrDir.
                 y =
                 (refrDir.
                    z =
                    0));
        else {
            float nK =
              neta *
              cos -
              (float)
                java.lang.Math.
                sqrt(
                  arg);
            refrDir.
              x =
              neta *
                state.
                  getRay(
                    ).
                  dx +
                nK *
                state.
                  getNormal(
                    ).
                  x;
            refrDir.
              y =
              neta *
                state.
                  getRay(
                    ).
                  dy +
                nK *
                state.
                  getNormal(
                    ).
                  y;
            refrDir.
              z =
              neta *
                state.
                  getRay(
                    ).
                  dz +
                nK *
                state.
                  getNormal(
                    ).
                  z;
        }
        float cosTheta1 =
          org.sunflow.math.Vector3.
          dot(
            state.
              getNormal(
                ),
            reflDir);
        float cosTheta2 =
          -org.sunflow.math.Vector3.
          dot(
            state.
              getNormal(
                ),
            refrDir);
        float pPara =
          (cosTheta1 -
             eta *
             cosTheta2) /
          (cosTheta1 +
             eta *
             cosTheta2);
        float pPerp =
          (eta *
             cosTheta1 -
             cosTheta2) /
          (eta *
             cosTheta1 +
             cosTheta2);
        float kr =
          0.5F *
          (pPara *
             pPara +
             pPerp *
             pPerp);
        float kt =
          1 -
          kr;
        org.sunflow.image.Color absorbtion =
          null;
        if (inside &&
              absorbtionDistance >
              0) {
            absorbtion =
              org.sunflow.image.Color.
                mul(
                  -state.
                    getRay(
                      ).
                    getMax(
                      ) /
                    absorbtionDistance,
                  absorbtionColor.
                    copy1(
                      ).
                    opposite(
                      )).
                exp(
                  );
            if (absorbtion.
                  isBlack(
                    ))
                return org.sunflow.image.Color.
                         BLACK;
        }
        org.sunflow.image.Color ret =
          org.sunflow.image.Color.
          black(
            );
        if (!tir) {
            ret.
              madd(
                kt,
                state.
                  traceRefraction(
                    new org.sunflow.core.Ray(
                      state.
                        getPoint(
                          ),
                      refrDir),
                    0)).
              mul(
                color);
        }
        if (!inside ||
              tir)
            ret.
              add(
                org.sunflow.image.Color.
                  mul(
                    kr,
                    state.
                      traceReflection(
                        new org.sunflow.core.Ray(
                          state.
                            getPoint(
                              ),
                          reflDir),
                        0)).
                  mul(
                    color));
        return absorbtion !=
          null
          ? ret.
          mul(
            absorbtion)
          : ret;
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        org.sunflow.image.Color refr =
          org.sunflow.image.Color.
          mul(
            1 -
              f0,
            color);
        org.sunflow.image.Color refl =
          org.sunflow.image.Color.
          mul(
            f0,
            color);
        float avgR =
          refl.
          getAverage(
            );
        float avgT =
          refr.
          getAverage(
            );
        double rnd =
          state.
          getRandom(
            0,
            0,
            1);
        if (rnd <
              avgR) {
            state.
              faceforward(
                );
            if (state.
                  isBehind(
                    ))
                return;
            float cos =
              state.
              getCosND(
                );
            power.
              mul(
                refl).
              mul(
                1.0F /
                  avgR);
            float dn =
              2 *
              cos;
            org.sunflow.math.Vector3 dir =
              new org.sunflow.math.Vector3(
              );
            dir.
              x =
              dn *
                state.
                  getNormal(
                    ).
                  x +
                state.
                  getRay(
                    ).
                  getDirection(
                    ).
                  x;
            dir.
              y =
              dn *
                state.
                  getNormal(
                    ).
                  y +
                state.
                  getRay(
                    ).
                  getDirection(
                    ).
                  y;
            dir.
              z =
              dn *
                state.
                  getNormal(
                    ).
                  z +
                state.
                  getRay(
                    ).
                  getDirection(
                    ).
                  z;
            state.
              traceReflectionPhoton(
                new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  dir),
                power);
        }
        else
            if (rnd <
                  avgR +
                  avgT) {
                state.
                  faceforward(
                    );
                float cos =
                  state.
                  getCosND(
                    );
                float neta =
                  state.
                  isBehind(
                    )
                  ? eta
                  : 1.0F /
                  eta;
                power.
                  mul(
                    refr).
                  mul(
                    1.0F /
                      avgT);
                float wK =
                  -neta;
                float arg =
                  1 -
                  neta *
                  neta *
                  (1 -
                     cos *
                     cos);
                org.sunflow.math.Vector3 dir =
                  new org.sunflow.math.Vector3(
                  );
                if (state.
                      isBehind(
                        ) &&
                      absorbtionDistance >
                      0) {
                    power.
                      mul(
                        org.sunflow.image.Color.
                          mul(
                            -state.
                              getRay(
                                ).
                              getMax(
                                ) /
                              absorbtionDistance,
                            absorbtionColor.
                              copy1(
                                ).
                              opposite(
                                )).
                          exp(
                            ));
                }
                if (arg <
                      0) {
                    float dn =
                      2 *
                      cos;
                    dir.
                      x =
                      dn *
                        state.
                          getNormal(
                            ).
                          x +
                        state.
                          getRay(
                            ).
                          getDirection(
                            ).
                          x;
                    dir.
                      y =
                      dn *
                        state.
                          getNormal(
                            ).
                          y +
                        state.
                          getRay(
                            ).
                          getDirection(
                            ).
                          y;
                    dir.
                      z =
                      dn *
                        state.
                          getNormal(
                            ).
                          z +
                        state.
                          getRay(
                            ).
                          getDirection(
                            ).
                          z;
                    state.
                      traceReflectionPhoton(
                        new org.sunflow.core.Ray(
                          state.
                            getPoint(
                              ),
                          dir),
                        power);
                }
                else {
                    float nK =
                      neta *
                      cos -
                      (float)
                        java.lang.Math.
                        sqrt(
                          arg);
                    dir.
                      x =
                      -wK *
                        state.
                          getRay(
                            ).
                          dx +
                        nK *
                        state.
                          getNormal(
                            ).
                          x;
                    dir.
                      y =
                      -wK *
                        state.
                          getRay(
                            ).
                          dy +
                        nK *
                        state.
                          getNormal(
                            ).
                          y;
                    dir.
                      z =
                      -wK *
                        state.
                          getRay(
                            ).
                          dz +
                        nK *
                        state.
                          getNormal(
                            ).
                          z;
                    state.
                      traceRefractionPhoton(
                        new org.sunflow.core.Ray(
                          state.
                            getPoint(
                              ),
                          dir),
                        power);
                }
            }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "PvgfuZrOxXEcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6eezjWHme3+wcO3vM7Cx7sN17Zym7oT/HceLEXS7buZzY" +
       "iWM7TpwWBp+J4zM+cphuC0gFVCSK2oUuFexfi9qi5SgqalVEu6hqgYKQqGhL" +
       "KxVQVam0FIn9o7Qqbemz87vmNzN7CBrJzy/vfe973/2+956f+z50KgqhQuA7" +
       "m6njx7vGOt6dO5XdeBMY0W6HqXBKGBk65ShRJIK2y9rDnz7/wx99YHZhBzo9" +
       "gW5XPM+PldjyvYg3It9ZGjoDnT9sbTiGG8XQBWauLBU4iS0HZqwofoKBbjoy" +
       "NIYuMfskwIAEGJAA5yTAxCEUGHSL4SUulY1QvDhaQL8MnWCg04GWkRdDD12J" +
       "JFBCxd1Dw+UcAAxns/8SYCofvA6hBw943/J8FcMfLMBP/dZbL3zmJHR+Ap23" +
       "PCEjRwNExGCSCXSza7iqEUaErhv6BLrNMwxdMEJLcaw0p3sCXYysqafESWgc" +
       "CClrTAIjzOc8lNzNWsZbmGixHx6wZ1qGo+//O2U6yhTweuchr1sOm1k7YPCc" +
       "BQgLTUUz9ofcYFueHkMPHB9xwOOlLgAAQ8+4RjzzD6a6wVNAA3RxqztH8aaw" +
       "EIeWNwWgp/wEzBJD91wXaSbrQNFsZWpcjqG7j8Nx2y4AdWMuiGxIDN1xHCzH" +
       "BLR0zzEtHdHP93uvf//bvba3k9OsG5qT0X8WDLr/2CDeMI3Q8DRjO/Dmx5kP" +
       "KXd+/r07EASA7zgGvIX5w1964c2vu//5L21hfuYaMH11bmjxZe1Z9dav30s9" +
       "hp/MyDgb+JGVKf8KznPz5/Z6nlgHwPPuPMCYde7udz7P/4X8jo8b39uBztHQ" +
       "ac13EhfY0W2a7waWY4QtwzNCJTZ0GrrR8HQq76ehM6DOWJ6xbe2bZmTENHSD" +
       "kzed9vP/QEQmQJGJ6AyoW57p79cDJZ7l9XUAQdAZ8ECPg+cmaPvL3zEkwjPf" +
       "NWBFUzzL82Eu9DP+I9jwYhXIdgZHiWc6/gqOQg32w+nBf80PDTiaKboRwq1M" +
       "fUJe382sK/h/wrvO+LmwOnECiPre447uAB9p+w6Avaw9lZCNFz55+Ss7B4a/" +
       "J4kYegRMtrs32W422e52st0jk0EnTuRzvCqbdKtKoAgbuDQIdjc/Jryl87b3" +
       "PnwS2FCwugFIMQOFrx9zqcMgQOehTgOWCD3/9Oqd0q8Ud6CdK4NnRihoOpcN" +
       "57KQdxDaLh13mmvhPf+e7/7wUx960j90nyui8Z5XXz0y88qHj4s09DVDB3Hu" +
       "EP3jDyqfvfz5Jy/tQDcAVwfhLVaAOYLIcf/xOa7wzif2I13GyynAsOmHruJk" +
       "Xfvh6Vw8C/3VYUuu61vz+m375noneC7u2W/+znpvD7LyVVvbyJR2jIs8kr5B" +
       "CD76za/9C5qLez/onj+yjAlG/MQRR8+Qnc9d+rZDGxBDwwBw//A095sf/P57" +
       "fiE3AADxyLUmvJSVFHBwoEIg5l/90uLvvv2tZ7+xc2g0MVjpEtWxtPUBk1k7" +
       "dO5FmASzveaQHhAoHOBUmdVcGnqur1umpaiOkVnpf59/FPnsv73/wtYOHNCy" +
       "b0ave2kEh+2vJqF3fOWt/3F/juaEli1UhzI7BNtGv9sPMRNhqGwyOtbv/Kv7" +
       "PvxF5aMgjoLYFVmpkYcjKJcBlCsNzvl/PC93j/UhWfFAdNT4r/SvIwnFZe0D" +
       "3/jBLdIP/uSFnNorM5KjumaV4ImteWXFg2uA/q7jnt5WohmAKz/f+8ULzvM/" +
       "AhgnAKMGluGoH4IQsb7CMvagT535+y/82Z1v+/pJaKcJnXN8RW8quZNBNwLr" +
       "NqIZCE/r4E1v3ip3dRYUF3JWoauY3xrF3fm/s4DAx64fX5pZQnHoonf/V99R" +
       "3/WP/3mVEPLIco119Nj4CfzcR+6h3vi9fPyhi2ej719fHXdB8nU4tvRx9993" +
       "Hj795zvQmQl0QdvL7CTFSTLHmYBsJtpP90D2d0X/lZnJdhl+4iCE3Xs8vByZ" +
       "9nhwOYz3oJ5BZ/Vzx+LJzfvx5OY9V7v5eDw5AeWVN+VDHsrLS1nxs/vueyYI" +
       "rSVYtvf898fgdwI8/5s9GbKsYbvIXqT2VvoHD5b6ACxFJ41YeXHVcqHlgni0" +
       "3Etx4Ccvftv+yHc/sU1fjuvxGLDx3qd+7ce7739q50jS+MhVedvRMdvEMRfU" +
       "LVlRzzzjoRebJR/R/OdPPfm5333yPVuqLl6ZAjVAhv+Jv/mfr+4+/Z0vX2M1" +
       "BorzlXgburOylBVv3kq0cl1H+fkr1XgHeG7ZU+Mt11Hj4DpqzKpUznI9hnbM" +
       "YlbrHKOHf4X03A2eW/foufU69IxfDj2nQKq4t3O4I4buOpq5WC5It7MA7ofH" +
       "qJVfIbWPguf8HrXnr0Ot8nKovaiokR+qWaypW1vXvJY01VdI38P73fvva9A3" +
       "ezn0nT+k70BubzlGnPWSxG0d4wTw/1Ol3epubjD+tac/mVVfC9b5KN9jZtZu" +
       "eYqzT89dc0e7tB8ZJLDnBIRdmjvVfX1fyNeXLBzubjdqx2itv2xagRvfeoiM" +
       "8cGe733/9IGv/voj3wYu2YFOLbMADHz3yIy9JNsGv/u5D95301PfeV+etgB5" +
       "Cqde+Ga+qUhfjOOsyHvifVbvyVgV/CTUDEaJYjbPNAz9gNvWEX66MchX/J+A" +
       "2/jWp9vliCb2f4w0MeWVuF4PzUJ1ys2XUWue1Opzv9+d49ZgtlD5oRasTbKI" +
       "yO0Wse41rXWyXKNjJkRHEmq2jH7RmtBNgRe6g1LDpsIZgxDCumMqfKMINxyw" +
       "c5Bn9HAj9VyMl4SONOy6pW7LGSCLYajiTGkyNnBM5WvYQm0Vy3A7MlJuuRx7" +
       "qVEo9FK8ZjvqpFkK5n0a3cAbI6VHAdpejEapxOgtdRypc2o05DdLH0VNs9Re" +
       "m25TRGxZJhUXFxYsOloM10xpjNjOIlS9vt+NUi117G4/YaVoMkX4cBZg7Yob" +
       "lebFyRBhJWdU2wynq47uECEf+EGloihpmxmViymxUVayQNKSbQvV6aJWlTG+" +
       "z2op3l46wzbqotUVIkzCDaI2MEX2lkGDRtxECZoyFvb6KDsajVZKaVkppAbB" +
       "O0mfX+rBZr0aqHItYcQeWUjM9rxU01quP+h0nI7eq84GKV7tqg1WlRe2rJh8" +
       "Cyn5kVyozdENIbEiQ/K1dQc8eo9YMLzb5CUk4aiFsJygfqlYKtK6Oq0OK6PA" +
       "b1BaSpW0dXcwSsW5uKbHLNtgezo6GKfdeuwxm9Iwiqwmj0/adXSN9TG3ihiD" +
       "9bwqLPoLvEuXqYFHygFRYzfzTmcSO/qC5xl80nTbolJ1EHuB6AN+gumqykhm" +
       "kK6YUqGgkAMj7YRcww2wWCZxsrcBps5y3UVFG9WTcW1hr8OYxIuqKRUdfpGs" +
       "0OYgasrNlbIqkiqejli5t/AWXRt3yHm46belGkm4VJzOiYLcF8athS62KCIu" +
       "2sPiYqm3jVobwdvlaSiKBCEg/SAw9GYLiYfuaICHbMNwBYKxKiahS2V5MLPL" +
       "I35jN1KWZKIip5LMclmqJGOvWRxwGDlH2IFFppZlK5t5jXR7PiU244nr2Gzq" +
       "N+2wGQ37RUf10prQmQp0Z2XQHa3ILdFKiEy6pS6iOam8EnrNRDAqHtWoLSYT" +
       "lgvZajRGHYOUY0GeLVCrMtN9xq5M0LYnuiJLylKYsgWGsbjlZhNPzCqTwm0u" +
       "WomtoAp8yFJ6NltotlLZ5VlpxI2MhZxaaHeEWe25O6kumgleFerjIrC7fqVv" +
       "jfRe4C5pgy3W+IEjNAvTsiewxEhZkCq2CMollKl0CnLdrxTXlFAf1iZko9Yo" +
       "z2tWC+/H9rA9JzbM0B8vFm6lUa4oZCGO+UFnZZfa8lRxTSRuySxfQhiLD0Ym" +
       "jKGyM42UKTxoMn0LQ9tVwx7C07jimLaaVhzKtLT+rNGZYZMlNVVQstWbTZUi" +
       "pQwbuCcpJVwXmxtR9IV+FbEoG3VXI5afMHSX4Q3eaui41SEHglJMKd6QRitb" +
       "ZldBoyV2EbXEJch8nPTjpkHUK169XKO6Qi8wGs0EW4655dSTqETnBS5l0EJI" +
       "j1clXpsz/GA2MoLZomVtCn670aRb3rinOGXBL5fbcJuEyzIubOr0yCHayy45" +
       "aHrOLJhbTbucRraNrtaJwnbqLapothphV8QwreVVpuvUGM9st9zo4+vNcEF0" +
       "XYGji6FXVKdzg60wqR6XC6zadoplo8esxPGaJFBmNl7TNhYTBk63LGPGdPy6" +
       "VyzVzJSsu+1STa7THkt3iJAMKazCE5SlM3NrzsxHU623WLGOWJcwrKfALjEZ" +
       "rKt0jcbdogTb3pIaJc1AkzGtwCpoKCilITao+pVaMybrUxiTjFrZRcfwMq2U" +
       "RxVUnPMYsVwt5TWQE9HplCK+2xOjxCiWrLQ1NWB9CHPTeW8FLxvzMtPkel1G" +
       "t0hV1KcNdzVzOUeVYAOv4VWELRVanAh7jc4mFbTZWvNsR5ukw/mCtkNGJeyV" +
       "sRIHrDbowkGpi9VNLAgcQUZmUzNEy2jqpGgVwXq94rRWbLXbusK6egeutwKs" +
       "6OIIrMJDV3UpxZZbKaL2FV7QKANjUW0iOUWutuCNAtUbyQVc7NQIjDDKsT7k" +
       "OzNqSJHRIBp5zMysMPw45sq9El5iNyisVUyDqdT6Ekn1TdXl4WGV88KZE1Al" +
       "lvY2VTCh4k26eK3jDgaY663pRrBCh+0phRlYJYLdhagnw1Lam7bZzWLQ12cq" +
       "06CQMd30+j1BQlS4WpKT2ECwJd1vImB1SJWWrzdlg50T5nKylAm6FfZhjl4k" +
       "qlfv6USRkqSObXaaRGk+LSkjVHXRVoVlZLqG94yR2rQxY0ltammFXwFDwd1q" +
       "nWWGzZFdjqsktzRDA4XTSlvn6lE8XYZEzZ2Oy8GyEloVuYZzZdgqrhKtu274" +
       "s/a0Wk4ME4R/vOZzpFprd9m5bgtRXyTq3XYC65WUgSlGHy/5gYuMS7Ywbgro" +
       "GhluCvS6KveKKaqm8tDiKLw8DtzyRix4LFFQgdXOK84UoVxeG/gyPCx1a5zf" +
       "NHQLqSBp1EoorDO26Fl/XgKe25qO5XF/TK1VKVhIlKENKKXenDkNu7IYUVoz" +
       "mojzpouXlEEvGsI9ojfo9QeeiZoNfBO0+gUSdmC7Fq6EetCZ1yTYVPoxrBS6" +
       "PlUkF1zYc3RvXNg0uv11vSbIQW1hriitnY7R9UAiNwNL6jFxpY+nmuupBQv2" +
       "08Aa0G1/NVFRclaAtWFj0eAEjKg3qlrSnYmbXlsszopOfUwsu3QRZWtzbEUF" +
       "9bmCd3uoVpRkvt1fFvS+NxUrZcxozrqI1JWLCtacJiilwnCqJOKwjZQDW9qQ" +
       "7todVsqNqdMocJ3ZOJk7fJDK/R6XoqNh2OiDIMAtNG+BheUIK9pSwTUQb4hi" +
       "cZSEzHxj6hOxHhoNOyZmpQHwBJUp0OlQDaYdxBkqm2qxH3krhFv2WzO8peDj" +
       "oKfPG5u4VEUZzaNFUai20J5AWoq/skR/5K0k1/blDW0UNSniV6hK0cNuA8P7" +
       "wUjsmpXaSEMIW9YJ1ZmS5EBtL1iyZpC+3uBDptuiuIVNVNQ5WLZatirN6LUp" +
       "Fxe0Sg1T05Z5EG7G1aXZGQ6MljS2tXg1wNISX8NlhACLVqsxNjzGTMrLDVZ2" +
       "ek1iPjK51Ex9t+RX2hhTsOcjnpgaUW0hVQd0OZ2tME1cIBVjs4k6LI2P2zQ9" +
       "SFPGL/ZYrYRKxBi4dl3ulV2GsvDuMl6uaoQGY8nM5CaTLqWZIJkhmLIBT4jW" +
       "gtnYveKwI4zrMOIUQkUi0GVryIls3ZkG/f5YdGsYHHkYWQO5EcqGdK2JFF2E" +
       "o5GmTVvhcFRGHIYpi6RhOrhXnqsci1TQNtZZLfqNTUEUC+NuNNUGKNOWi9V6" +
       "wI0q7ZTqsavUWrO4s9lIc3wSwmliLTU6kjHOdnx4FiH8otHdTKY+FS6oTh9r" +
       "9JZVtVqYRzO4OFVmkeK3/XW7UO/ztVV1pBfKDbLb8xJxPpjI4XoGd1sqO0HZ" +
       "QmtSWc82aDxHfXIdrhrd2WrK1haFASl5w1o/oBhaH4s+Pi8T84nX73iDFJ6N" +
       "ym2Oc5L2BCusPZmqkaKwnJUM2wdrbIRbYXsUB17N0Cr+xJULocOrXGeutquE" +
       "oJbiIYEV2mRtlRAsSUw0tVcS/K6GCym8gpnOqJ6apC66Tamnjn3HWRop5Y/F" +
       "1ByJdReHhRLpcZ5aTENi1eZHRXhdWWK4OZH8KBwEPaw0kOhm33eKQZNAHZV0" +
       "9YHuiwOuYhalFETwuFsXzDojonIP51q8pqVrnsU5nAyGhE01UKkwCd0ItUa0" +
       "gFUKdNjGN7SEa7RannOm059FhbRA4XWWXNDLtaNV2GqXW/vCZjEWW6lmJtyo" +
       "GcH0ho/b/oaY99lpQ5Da9tJpmHAykjytYCxKYX2lR5xTMzm937Mj0lRrRlnl" +
       "cDWcTjpJuaKz9d5aKvFwlSoHxbSLVMuVSWvR2xAztChRTqcPoPxwPdlMZipV" +
       "7SKKZjX6drOp+d4ggWMUduylaJoWvtAEWsQrnoMpDYFbVkppYUyKiNIxCkhX" +
       "IJqyGAgrBVbDUcXeTEjJxgeoP+dFWCPJksaux94abi7SuF/yY8ZNaCZFglXT" +
       "VeJe2MGEaABbbGoILMiRRlUi7QTulG2otYmEJwUp4JOkDm8kyy2mYmhOEzC+" +
       "3LFBflVKzSaCRCAbM5NJ2F+PGxrYib4h26K++5VtnW/LTwkO7nbBjjnrWL6C" +
       "3fG266GsePTgaCX/nYaO3QceOVo5cv584ponUPnd2fa+LDsnvO96V7r5GeGz" +
       "73rqGb3/MWRn71yfiaEbYz/4OcdYGs6RqU4CTI9f/zyUzW+0D8+bv/iuf71H" +
       "fOPsba/gFu2BY3QeR/l77HNfbr1G+40d6OTB6fNVd+1XDnriyjPnc6ERJ6En" +
       "XnHyfN+B5G/PBP3qvWe/fo2brOufaL12axvHrk12coCdfV3df5WucjkYsRFm" +
       "9zL7YHceBRO2b4Kj8xmeeZGLmWez4sMxdDoJdCU2rnWKc0b1fcdQvEMr/e2X" +
       "OsM5Okve8KEDseVGey94HtkT2yM/HbGduNLE77umiVveNPtOxMgx/P6LiOWz" +
       "WfFcDN00NWIejNs/BH3LoRA+8RMIIXfSN4JH3hOC/FO1nezvZ3Jyc6g/fRFG" +
       "v5AVfxxDt0SaEgOb4mZ+vOd3xw/zlr6lH7L/uVfC/hpI8si9fHbJePdVH/hs" +
       "P0rRPvnM+bN3PTP82/xq+uDDkRsZ6KyZOM7RO6Ej9dNBaJhWztGN2xuiIH99" +
       "5VrBbvuhQHaem1dyav9yC/+1GLpwHB6wnr2Ogn0d8HMEDPjIXu0o0Ddi6CQA" +
       "yqp/HVzjMHh7N7Y+cSRs7hlKLuCLLyXggyFHr66zUJt/YbUfFpPtN1aXtU89" +
       "0+m9/QXsY9urc81R0jTDcpaBzmxv8Q9C60PXxbaP63T7sR/d+ukbH91fBm7d" +
       "EnxotEdoe+Da99QNN4jzm+X0j+76g9f/zjPfys+m/w/ALpof+iYAAA==");
}
