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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AUEswfRnHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
