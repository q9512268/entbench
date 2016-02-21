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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8Pxjy/o2vcf5Hfhg3B3p3FQCAOvw3nIu+Xd/e+mP/ahsDNVLVgG7GyspFpRj" +
       "ULSZdlULRW7WfHYBJqqNngw8tnqhy7WtF7icFAZ9Rs36NR6sqraxqtoK42ov" +
       "VvkQ72zjLGt528WadTY0lOmGDJcc4sGGqnkWpaiIUJydAdmlaDQVNSGPyUkA" +
       "tgmrbLslvF+a7Qz/Xpz/0jwMgq75yeDDu9888AqHzXKWKXfZOrvyYK8x7sLs" +
       "eiHyR/Dng+8/7GOisgFR/jT2WTXYqkwRpussCudxRI8CwZnGdw8+duUpoYDX" +
       "6zzEZPb4Fz8KHD0usFBU8h05xbSbR1TzQh3WfJJJt3q+XTjHwB8uznz/yZkj" +
       "QqrG7Lq0H65dT/3i368ETv3mcp5yCNxMwzSDA75MQbMo+3SESlu/UPeDY41F" +
       "A5CHh1B5SpUPpchQLNs/y8xU1HVczh3B8VlLOXY0FPm64RREFmXtHawZFA54" +
       "V0HM6s32+mb4aiwHrSng9Vh4PWu257p3IW6K/PH1rBf2iBhdoIhL4Ku1Nqkt" +
       "IGJiXhELccMhwjXDunUuoWixu8KVk3BVYziuGR4F5AUqsAa+OkuEugIKHJpX" +
       "gULcEJo4ampGlGH6VllAYD6bGwsUud2etn/ziJyeV+RC3JDZHZEz1k165J2a" +
       "R17Xvt2ZfflfKfLc3NyVmJNtfXnPm99oxC2GgceKQpdvDhxnDh8/HdvxxM1+" +
       "q+z5NIWKQdM/ppAJori2KmIrZSX2Yf7c4GTJys+vbwrRdDz3bsNWaStwe+ku" +
       "DLzeDV48/KdluzYl9i/g4rLSo7t3yW8Nn7+8ba30ZT9/MRFJOeelJZupJxvq" +
       "Kg1CU4aaDW7tmdNsYoe31Prsfp7LQx5HyJTkhVg9xaufn5Pfdom2HJfgpiGU" +
       "GKyCs8la3GSj4rc3PMTFemSe8vgka74EN4mUHoM0ymlGrITFfkZd/U9BVRHV" +
       "NIVg1Ztl2L/3pZ1wefhG4Z1VqbKBzXx4NmO2BjbVCl+HZbaOhVu8EKvHHr7s" +
       "IFyRNwhldZy9ORK+7Tfnseg51nydoqpxQncCnx05Scc63/ifrcPBZBN8eywV" +
       "9yzcOoVY8/sj+/cs14Mv/fQ8FvgOay5SVGNKmIKfhhMatcLb407FE5occ+xy" +
       "aeF2SYOhXc897NKzJOctWbx/ShdO15UvPn3Pm/zpIfNGWQ11aTylKO663NUv" +
       "1Q0Sl7le1aJKFyXOXD60Fu9PEE2iw2X+oaB/nqJ6Lz0YgP24yV4AfVxklNVg" +
       "vOcmugyVOhCx7k90223r+V2P3U8C4n6S9rlwH7mCs/lGZs6wuJ8mGK7zx3wb" +
       "g1PiOT8iXTy9feT+a7c/IZ5GJAVPT7NVqqCAFK80GRxfXXA1e63Swa7rtZcq" +
       "1th5rEEI7HjzcpejbYao1dmRL/O8G5idmeeDt85sfO6ns6WvQcG8F/kwRU17" +
       "c29yaT0FaXFvKLdQhhzHHzR6ur42tWld/C+/5ldlJArr1sL0Eaniw6PTq01f" +
       "wI8qhlAJpGiS5lfMrVPqTiJNGFlVd2lUS6mZN/9a5puYPfJzq1jGrMmMsmc1" +
       "itpzLyC5T42V4DrE2MJW53nNk/VSuu6e5Va9V8QoszL4WSQ0rOv2zesCt7qu" +
       "89h7m4P+fwGT8CuTpRsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6eezjWHme3+wcO3vM7Cx7sN17Zym7oT8ncRI7Xa6cduzE" +
       "duLYSdzC4PhOfMVH7JhuC0gFVCSK2oVCBfvXorZoOYqKWhVRFlUtUBASFT2l" +
       "AqoqlZYisX+UVt229Nn5XfObmT0EjeTnl/e+973vft97z8/+ADoV+FDBc62N" +
       "brnhrpqEuwuruhtuPDXYJftVVvIDVWlZUhCMQdtl+eHPnP/RCx8wLuxAp0Xo" +
       "dslx3FAKTdcJRmrgWmtV6UPnD1s7lmoHIXShv5DWEhyFpgX3zSB8og/ddGRo" +
       "CF3q75MAAxJgQAKckwA3DqHAoFtUJ7Jb2QjJCYMV9MvQiT502pMz8kLooSuR" +
       "eJIv2Xto2JwDgOFs9l8ATOWDEx968ID3Lc9XMfzBAvzUb731wmdPQudF6Lzp" +
       "cBk5MiAiBJOI0M22as9VP2goiqqI0G2Oqiqc6puSZaY53SJ0MTB1RwojXz0Q" +
       "UtYYeaqfz3kouZvljDc/kkPXP2BPM1VL2f93SrMkHfB65yGvWw67WTtg8JwJ" +
       "CPM1SVb3h9ywNB0lhB44PuKAx0sUAABDz9hqaLgHU93gSKABurjVnSU5OsyF" +
       "vunoAPSUG4FZQuie6yLNZO1J8lLS1cshdPdxOHbbBaBuzAWRDQmhO46D5ZiA" +
       "lu45pqUj+vkB/fr3v90hnJ2cZkWVrYz+s2DQ/ccGjVRN9VVHVrcDb368/yHp" +
       "zi+8dweCAPAdx4C3MH/4S8+/+XX3P/eVLczPXAOGmS9UObwsPzO/9Zv3th6r" +
       "n8zIOOu5gZkp/wrOc/Nn93qeSDzgeXceYMw6d/c7nxv9+ewdn1C/vwOd60Gn" +
       "ZdeKbGBHt8mu7ZmW6uOqo/pSqCo96EbVUVp5fw86A+p901G3rYymBWrYg26w" +
       "8qbTbv4fiEgDKDIRnQF109Hc/bonhUZeTzwIgs6AB3ocPDdB21/+DqG3woZr" +
       "q7AkS47puDDruxn/mUIdRYJDNQB1BfR6LhxEjma5MRz4Muz6+sF/2fVVODAk" +
       "RfVhPFMkl9d3Mzvz/t9nSDIeL8QnTgDx33vc+S3gN4RrAdjL8lNRs/P8py5/" +
       "befAGfakE0KPgMl29ybbzSbb3U62e2Qy6MSJfI5XZZNu1QuUswRuDgLgzY9x" +
       "byHf9t6HTwK78uIbgGQzUPj6cbh1GBh6efiTgXVCz304fqfwK8UdaOfKgJoR" +
       "CprOZcPZLAwehLtLxx3pWnjPv+d7P/r0h550D13qigi95+lXj8w89eHjIvVd" +
       "WVVA7DtE//iD0ucuf+HJSzvQDcD9QcgLJWCiIJrcf3yOKzz2if3ol/FyCjCs" +
       "ub4tWVnXfsg6Fxq+Gx+25Lq+Na/ftm/Cd4Ln4p5N5++s93YvK1+1tY1Mace4" +
       "yKPrGzjvY3/7jX9BcnHvB+LzR5Y2Tg2fOOL8GbLzuZvfdmgDY19VAdw/fJj9" +
       "zQ/+4D2/kBsAgHjkWhNeysoWcHqgQiDmX/3K6u++8+1nvrVzaDQhWP2iuWXK" +
       "yQGTWTt07kWYBLO95pAeEDws4F6Z1VziHdtVTM2U5paaWel/n3+09Ll/e/+F" +
       "rR1YoGXfjF730ggO21/dhN7xtbf+x/05mhNytngdyuwQbBsRbz/E3PB9aZPR" +
       "kbzzL+/7yJelj4HYCuJZYKZqHqKgXAZQrjQ45//xvNw91lfKigeCo8Z/pX8d" +
       "STIuyx/41g9vEX74J8/n1F6ZpRzV9UDyntiaV1Y8mAD0dx33dEIKDABXeY7+" +
       "xQvWcy8AjCLAKIOlOWB8ECKSKyxjD/rUmb//0p/e+bZvnoR2utA5y5WUrpQ7" +
       "GXQjsG41MEB4Srw3vXmr3PgsKC7krEJXMb81irvzf2cBgY9dP750syTj0EXv" +
       "/i/Gmr/rH//zKiHkkeUaa+ux8SL87Efvab3x+/n4QxfPRt+fXB13QUJ2OLb8" +
       "Cfvfdx4+/Wc70BkRuiDvZXuCZEWZ44ggwwn2U0CQEV7Rf2W2sl2anzgIYfce" +
       "Dy9Hpj0eXA7jPahn0Fn93LF4cvN+PLl5z9VuPh5PTkB55U35kIfy8lJW/Oy+" +
       "+57xfHMNlvI9//0x+J0Az/9mT4Ysa9guvBdbe6v/gwfLvweWopNqKL24alnf" +
       "tEE8Wu+lPfCTF7+z/Oj3PrlNaY7r8Riw+t6nfu3Hu+9/audIIvnIVbnc0THb" +
       "ZDIX1C1Z0c4846EXmyUf0f3nTz/5+d998j1bqi5emRZ1QNb/yb/+n6/vfvi7" +
       "X73GagwU50rhNnRnZTkr3ryVaPW6jvLzV6rxDvDcsqfGW66jxuF11JhVWznL" +
       "7RDa0YpZjTxGz+gV0nM3eG7do+fW69AzfTn0nALp495u4o4Quuto5mLaIAXP" +
       "ArjrH6N29gqpfRQ85/eoPX8daqWXQ+1FaR64/jyLNW1z65rXkub8FdL38H73" +
       "/vsa9Bkvh77zh/QdyO0tx4gzX5K4rWOcAP5/qryL7uYG4157+pNZ9bVgnQ/y" +
       "fWdm7aYjWfv03LWw5Ev7kUEA+1BA2KWFhe7r+0K+vmThcHe7eTtGa/tl0wrc" +
       "+NZDZH0X7APf908f+PqvP/Id4JIkdGqdBWDgu0dmpKNsa/zuZz94301Pffd9" +
       "edoC5Mm+kH7xtRnW9MU4zoq8J9xn9Z6MVc6NfFntS0E4yDMNVTngFj/CDxWC" +
       "fMX9CbgNb1WIStBr7P/6wqw9ieVRMlEZGPywKeMUBsvQYMm5b/RtuOYq/GLF" +
       "EPNAJiSGaSAdacqI5eo6nc8pJKrbSoBhkbEQOZPvFDmzSzdsd6ELJOcuOJJv" +
       "hL0iTvLFsVTssTzBLbthg+uMqGaHNns9ye1vxPIcUcpomIqtToAqSaXql8V6" +
       "vYbV0SIiw5UVtejQpY7I46vmmFl02jDn0jNssAzGla5dmEV4L+yRlXWMwKKC" +
       "z53xougTPF5s2diAowO7MSa5GTMTJxvKIwPOHckVbogzgx6ODZeJzoE9hMS4" +
       "k7lIdPyVaaak0jX7HV6K8SQwSr2GR6sj1/R6BmihBHfUWJqtKUkvfEetkO7E" +
       "I4s1WcZMPsIW6LRN0QPGicQuPSHaUYMkOsloMrRxkWTLXqNUXNYqHl9gqJE+" +
       "WI6HA8Kig6BTjllEFBf6Wuwro7rMViW3uhHdeLVa8VJNjURmZi/I5szs8tVK" +
       "WqY2I49YUtqI5w2B4U1vpacijklGp9wOKDv0+UG3GMpDWpwGRVSvlbo1TyDV" +
       "2bDJhalV7SSxyEyCqBPJm3i4sEtgRz1wmfJq0RdbmyQWCLQIdlfpcr321t0a" +
       "XhsIQ2dVowdEw+64/TaJN02epNjOgAgXg1FvPoyLK4KduYMJF2xodsKNVQnz" +
       "TUoarhgknfXxYuolTBNlfKklx2NlQY46NMcspl6MWqygcULarNSavllj/CLR" +
       "aixmTMsa93piMEwKJNLlnWQo2APe10YbkRgHcGM4bOChuAxbHSu0V5MBH+vN" +
       "VdfcGDNiWGD0KPIqxabkup02bgxDCtXdAJ0w3oyuOB1uNkLAXsruUavWqtIb" +
       "6f2RXFIHfoVz6N4m3djVNNJWm4G0qNei9sqAq0NmNluOhraW8HE4tWeK16sM" +
       "houOPmkFQLxK3ELYdA0MIyLtNorrBbXq+GG57ttIRPJ4yjZgehHpzV6I95SW" +
       "KBXKnj+tq8qI3wxkq5iK03llIvop1Qjng7TkEaOWTc4Hph2nsyUyQKf1RRq3" +
       "nY1j1IX2qstxAs1xWmvRXFr9mk+2FnipQw4lm2xLHcrVpVqBTYc1fVAwuyI5" +
       "IYujNIk6i1XHNPiCQPkJjHU7smC2wCLJFfyeVCpsCgvbbtXrg9pwpQ/YcEhP" +
       "E57T4M3UdZCmQc6WQy4xBEEqzejF0GbRYEjzs7ZFmsMFhgeoO6G79GpKd2y9" +
       "NjOaY2HBsgzsNZdLqSXGi+aiOVdjfYQs4ZhNBjAKr5f4rEYvkZqGtwuCDcdU" +
       "0kD0qtsKm4Sn4l4fRvn+UlS7M7SrB1TS5odK0PUb5RbaBvGFSnU8SKssm7Aj" +
       "KRnL0ySOOrLRbhAOCEm4X1oXYFSsm/2YQsobvJX2OTpKsWVZ02O+rHfU5bqM" +
       "wuhs3rTnoVrfDOC4w/OYW2wXaqEcDOCNJXVJsiG5fLwozIf6oKvPsXWb0iOB" +
       "GbcLaAEh3EhP1kR51rMaHXzAyumQRumulyoFrFaaK4Ux1UwUNsUNhsRlq7mI" +
       "tOq0sdHxBeKsRtPCbMGvhy7cQayyFzKsqXdLDXzpGYEO0K1T1Ot0u+1iudYm" +
       "lc2SMCJ8tgxkyp5TXOA1rLaNjPCoF5QwtmIyCClV8Kg4dB04CJcTZz7pG3yw" +
       "mcJdN+aJeqXG1ioojJVHGCIT7LzQhR0u3CwMVqoMenJYChYjT+4ma6GI9/g2" +
       "Ul85sZDU6qo9XNfTSK8NTGTGKX4hbvqVxqKZNgp1hTFDpY5VscpcwwSe4say" +
       "YCiu5Qg4t5BYShW5DqLMapjetKlRW0jxoIaWiCZVmFQW1ICayUTio26JTuG0" +
       "WmNLsY7xeJ9QJLpMd5E2bpWrzTa6wdCkHmpN4HoEZc9Shhg3mskSpTd+mdAp" +
       "TiQKATEVnLQ00uLKsO03Vi2L7VQAxXTQwHgGtdRAqzJFPK2noc8swYJS0wih" +
       "EJXNmUlM1wtY9BU0rSMLPppPR5tqirizWoq01gJYCHSk34dnrbTVKHeKTaRW" +
       "T3trbUohhDCTh8nEohrmgJBneif1+oNCvOqsKW09WVRL6/K6tOrADcblw248" +
       "b7TTXmcgVGikM240Vt56SiuVddvhNoTn1UDyQvEiLMq2VlgWvEGtOpcUOERN" +
       "L1VVVisyysY3RnJQZWoROkHpeNnU+LFhaipcZpxqvV4dcEtuYCnGnOjHqLaM" +
       "kxJVZ9tr2LMWs15VUmW324brM4xNFhvYLa9lrUpoho40EQ/pDlsNBqydTi8q" +
       "TBVYLdgsLBlBmxb6go6j+Cbwut5owfc5UbH4/miCTjRi1iRXK9rRYyx0VsYG" +
       "nYRd1JS7DbE+CpAaPaoFK19KVqFLVcruWlgvh2g5XfTxsFrGJpIynhUtxsbb" +
       "pCxXAhxfOcuJJ5k9ntwoDcW2pPYQRDic3fDLRqjb/rwfWOtuQUKHKTz1Uri4" +
       "iAf6Cq1u1HY7qmMY1lgR6ZSaUFNNZPz1ZkZhCRr0A9UkNiO47egFDEZxxgz0" +
       "7ghejMuT8XS2WsYjLwqCVqQkox7WikUHV2KsoES8587a01qadkR2XummGEW0" +
       "i1HQbfKYUawmc24+Ko3ToYFMNJIkQ2RVmI4XRNzEotRJ4Y24XAxXPo72V0Wi" +
       "VlXGMGIiNawzXiO27FU3LToZxCnXbqDVwXA+cAsI1+GsCOZZtT2rlLqNaosw" +
       "Ss0q5/GsJxvDPh3AGyzhS4QgpwbSxASrz0xnxS5r1yqjUadrT0NCikUwsCIU" +
       "iUEtQMoFe16RzJjwOUevC0aFnUTlKuohvUmNglmi5De1stkE3toz+hUqKtGr" +
       "ZdjDSXNqdPqyPDDixbQdOXzkTswkwihhiTSFWWpG+KjSrTb4VdCQCswS5A96" +
       "jyJIb6rzfblDuhXJ9nALJ2qCZTVm7docjwM+Uspq6MCpSW5UoTBqIWRbJMRO" +
       "WlqWalWyLI1K6HQdlkVNszRK68sIvRFskg61qcPa9bqbtMq4LqvU0FPWbSNx" +
       "2gYGE8o6SQalwqqQVunehBoqA9jzGqTrm2XK7vkiNy3PNFSu4GNyExTW89gf" +
       "Ke0UmQf0ROLCWC0so3Y/VdtCBYMpxYrSmVU3Yb3i9zkXDZHNBKMdtIDNJaQo" +
       "juvwYNQlGVW1SDHyyGS9ovRSi69IUnuChrZCBzNXRUqsH2ge2h8mVWJDjpeG" +
       "oNcTKdKcKqsprl0mSE33TJzHqU0rwCwJAWGy4ssIOxh3VZtTsbW+lNBKh67Y" +
       "POEOihvbwv3euKstRQXm601hRAh0T9BLYmiV+zDiiaVY1Qy8IpaE1ZxqptOk" +
       "QttMubmYCy2rQIhziTGECOtQa4Lw0aDX3Yzo2LAUcVNnRlQBHWtOoOrVkrNR" +
       "3JWXDB255STFKifLNQQ2NV9mm2KTxtRNLNQ3qcy4wgyDg0UBloNSZbCGtSHW" +
       "XeuMtKlyAk4DsVOaYQykUO7PK0W026m6slxINpLaLYPs25jKIJ2nqZRk5HAy" +
       "T2DOUJhSlV+zDsLacOr1NBqfDEslabyxKKZWQ2h+XRoWOQtE8JJEUt3NlJm2" +
       "a8VuVGc7nbIZl6cFV2rCzoqs9dPiTGfLlY1QaWhCsrRoQV8zsh3pG4ExWgm6" +
       "rBfLZcQvCGUW4bFWxalxdd+KCdRuBbCFi0EtjkjMxik0TZB4rpdYkxlj5nS8" +
       "qWvqGAQeGe6JVZxsCOwYpYXVqtXoUlgRHyXadNooqTWEiyXUD0V5VQqNqt/p" +
       "9FBikcqeupjPJLek2KM+zGB41VRsVW2HWDXQmJoT1CbroYxjXRgEI76EyuX6" +
       "RhoXu9K0u6b6ytAwUoJIR7XIr5TDiaXArQJctRSLbPh+KegXO5JjxjV2vCqW" +
       "tLiHrQyrQXq4yVUtbeAL7GpskjTetQSlbPFczRZpuC5VvWjGamS6Ki1wf2AP" +
       "AlsumaGX9jet6rhSFiptv1MekJMq4tBLWOCiqKZWBakuYEM3SPuVCTcs+sy6" +
       "nKpBK0RXEVY3ULvCFrQYH2OtaOyNArCpfMMbsu3mu1/ZNvi2fMd/cHcLdr9Z" +
       "x/oV7HS3XQ9lxaMHxyT57zR07L7vyDHJkbPkE9c8TcrvwbZ3X9mZ333Xu7LN" +
       "z/ueeddTTyvMx0s7e2f0/RC6MXS9n7PUtWodmeokwPT49c82B/mN9eHZ8Zff" +
       "9a/3jN9ovO0V3Ig9cIzO4yh/b/DsV/HXyL+xA508OEm+6i79ykFPXHl+fM5X" +
       "w8h3xlecIt93IPnbM0G/eu/Zr1/jVur6p1Ov3drGsSuQnRxgZ19X91+lq1wO" +
       "aqj62R3LPtidR8G47bvB9vIZnn6RS5ZnsuIjIXQ68hQpVK91InNm7rqWKjmH" +
       "VvrbL3Uec3SWvOFDB2LLjfZe8DyyJ7ZHfjpiO3Glid93TRM3HT37DkTNMfz+" +
       "i4jlc1nxbAjdpKvhCIzbP9B8y6EQPvkTCCF30jeCZ7YnhNlP1Xayv5/Nyc2h" +
       "vvgijH4pK/44hG4JZCkENsUabrjnd8cP5tauqRyy//lXwn4CJHnkjj27MLz7" +
       "qg94th+dyJ96+vzZu57m/ya/Zj74MOTGPnRWiyzr6P3Okfppz1c1M+foxu1t" +
       "j5e/vnatYLe99M/OZvNKTu1fbOG/EUIXjsMD1rPXUbBvAn6OgAEf2asdBfpW" +
       "CJ0EQFn1r7xrHOxu77mSE0fC5p6h5AK++FICPhhy9Bo6C7X5F1T7YTHafkN1" +
       "Wf700yT99udrH99eg8uWlKYZlrN96Mz2Rv4gtD50XWz7uE4Tj71w62dufHR/" +
       "Gbh1S/Ch0R6h7YFr3zl3bC/Mb4nTP7rrD17/O09/Oz9n/j+LRfN+2iYAAA==");
}
