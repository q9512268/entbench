package org.sunflow.core.shader;
public class QuickGrayShader implements org.sunflow.core.Shader {
    public QuickGrayShader() { super(); }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        if (state.
              getNormal(
                ) ==
              null) {
            return state.
              getShader(
                ) !=
              this
              ? state.
              getShader(
                ).
              getRadiance(
                state)
              : org.sunflow.image.Color.
                  BLACK;
        }
        state.
          faceforward(
            );
        state.
          initLightSamples(
            );
        state.
          initCausticSamples(
            );
        return state.
          diffuse(
            org.sunflow.image.Color.
              GRAY);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        org.sunflow.image.Color diffuse;
        if (org.sunflow.math.Vector3.
              dot(
                state.
                  getNormal(
                    ),
                state.
                  getRay(
                    ).
                  getDirection(
                    )) >
              0.0) {
            state.
              getNormal(
                ).
              negate(
                );
            state.
              getGeoNormal(
                ).
              negate(
                );
        }
        diffuse =
          org.sunflow.image.Color.
            GRAY;
        state.
          storePhoton(
            state.
              getRay(
                ).
              getDirection(
                ),
            power,
            diffuse);
        float avg =
          diffuse.
          getAverage(
            );
        double rnd =
          state.
          getRandom(
            0,
            0,
            1);
        if (rnd <
              avg) {
            power.
              mul(
                diffuse).
              mul(
                1.0F /
                  avg);
            org.sunflow.math.OrthoNormalBasis onb =
              state.
              getBasis(
                );
            double u =
              2 *
              java.lang.Math.
                PI *
              rnd /
              avg;
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
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "E7RqFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7//DN3/8ha/lld//A/FzKFFJIgAA");
}
