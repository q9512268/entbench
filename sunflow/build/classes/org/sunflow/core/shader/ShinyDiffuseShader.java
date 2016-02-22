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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xTMstu/yLjbv/Q/XWpN6lRsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
