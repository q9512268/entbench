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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4/8CDp9MsHQXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
