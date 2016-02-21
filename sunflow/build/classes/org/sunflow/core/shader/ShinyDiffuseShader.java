package org.sunflow.core.shader;
public class ShinyDiffuseShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color diff;
    private float refl;
    public ShinyDiffuseShader() { super();
                                  diff = org.sunflow.image.Color.GRAY;
                                  refl = 0.5F; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        diff =
          pl.
            getColor(
              "diffuse",
              diff);
        refl =
          pl.
            getFloat(
              "shiny",
              refl);
        return true;
    }
    public org.sunflow.image.Color getDiffuse(org.sunflow.core.ShadingState state) {
        return diff;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        state.
          faceforward(
            );
        state.
          initLightSamples(
            );
        state.
          initCausticSamples(
            );
        org.sunflow.image.Color d =
          getDiffuse(
            state);
        org.sunflow.image.Color lr =
          state.
          diffuse(
            d);
        if (!state.
              includeSpecular(
                ))
            return lr;
        float cos =
          state.
          getCosND(
            );
        float dn =
          2 *
          cos;
        org.sunflow.math.Vector3 refDir =
          new org.sunflow.math.Vector3(
          );
        refDir.
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
        refDir.
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
        refDir.
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
        org.sunflow.core.Ray refRay =
          new org.sunflow.core.Ray(
          state.
            getPoint(
              ),
          refDir);
        cos =
          1 -
            cos;
        float cos2 =
          cos *
          cos;
        float cos5 =
          cos2 *
          cos2 *
          cos;
        org.sunflow.image.Color ret =
          org.sunflow.image.Color.
          white(
            );
        org.sunflow.image.Color r =
          d.
          copy1(
            ).
          mul(
            refl);
        ret.
          sub(
            r);
        ret.
          mul(
            cos5);
        ret.
          add(
            r);
        return lr.
          add(
            ret.
              mul(
                state.
                  traceReflection(
                    refRay,
                    0)));
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        org.sunflow.image.Color diffuse;
        state.
          faceforward(
            );
        diffuse =
          getDiffuse(
            state);
        state.
          storePhoton(
            state.
              getRay(
                ).
              getDirection(
                ),
            power,
            diffuse);
        float d =
          diffuse.
          getAverage(
            );
        float r =
          d *
          refl;
        double rnd =
          state.
          getRandom(
            0,
            0,
            1);
        if (rnd <
              d) {
            power.
              mul(
                diffuse).
              mul(
                1.0F /
                  d);
            org.sunflow.math.OrthoNormalBasis onb =
              state.
              getBasis(
                );
            double u =
              2 *
              java.lang.Math.
                PI *
              rnd /
              d;
            double v =
              state.
              getRandom(
                0,
                1,
                1);
            float s =
              (float)
                java.lang.Math.
                sqrt(
                  v);
            float s1 =
              (float)
                java.lang.Math.
                sqrt(
                  1.0 -
                    v);
            org.sunflow.math.Vector3 w =
              new org.sunflow.math.Vector3(
              (float)
                java.lang.Math.
                cos(
                  u) *
                s,
              (float)
                java.lang.Math.
                sin(
                  u) *
                s,
              s1);
            w =
              onb.
                transform(
                  w,
                  new org.sunflow.math.Vector3(
                    ));
            state.
              traceDiffusePhoton(
                new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  w),
                power);
        }
        else
            if (rnd <
                  d +
                  r) {
                float cos =
                  -org.sunflow.math.Vector3.
                  dot(
                    state.
                      getNormal(
                        ),
                    state.
                      getRay(
                        ).
                      getDirection(
                        ));
                power.
                  mul(
                    diffuse).
                  mul(
                    1.0F /
                      d);
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
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "wK2u6zwFL/G69x8qnYdjtxoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "X5HzPgTUJQAA");
}
