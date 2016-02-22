package org.sunflow.core.shader;
public class DiffuseShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color diff;
    public DiffuseShader() { super();
                             diff = org.sunflow.image.Color.WHITE; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        diff =
          pl.
            getColor(
              "diffuse",
              diff);
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
        return state.
          diffuse(
            getDiffuse(
              state));
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
       "t6UaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
