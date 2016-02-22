package org.sunflow.core.shader;
public class PhongShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color diff;
    private org.sunflow.image.Color spec;
    private float power;
    private int numRays;
    public PhongShader() { super();
                           diff = org.sunflow.image.Color.GRAY;
                           spec = org.sunflow.image.Color.GRAY;
                           power = 20;
                           numRays = 4; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        diff =
          pl.
            getColor(
              "diffuse",
              diff);
        spec =
          pl.
            getColor(
              "specular",
              spec);
        power =
          pl.
            getFloat(
              "power",
              power);
        numRays =
          pl.
            getInt(
              "samples",
              numRays);
        return true;
    }
    protected org.sunflow.image.Color getDiffuse(org.sunflow.core.ShadingState state) {
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
              state)).
          add(
            state.
              specularPhong(
                spec,
                power,
                numRays));
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        state.
          faceforward(
            );
        org.sunflow.image.Color d =
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
            d);
        float avgD =
          d.
          getAverage(
            );
        float avgS =
          spec.
          getAverage(
            );
        double rnd =
          state.
          getRandom(
            0,
            0,
            1);
        if (rnd <
              avgD) {
            power.
              mul(
                d).
              mul(
                1.0F /
                  avgD);
            org.sunflow.math.OrthoNormalBasis onb =
              state.
              getBasis(
                );
            double u =
              2 *
              java.lang.Math.
                PI *
              rnd /
              avgD;
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
                  1.0F -
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
                  avgD +
                  avgS) {
                float dn =
                  2.0F *
                  state.
                  getCosND(
                    );
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
                      dx;
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
                      dy;
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
                      dz;
                power.
                  mul(
                    spec).
                  mul(
                    1.0F /
                      avgS);
                org.sunflow.math.OrthoNormalBasis onb =
                  state.
                  getBasis(
                    );
                double u =
                  2 *
                  java.lang.Math.
                    PI *
                  (rnd -
                     avgD) /
                  avgS;
                double v =
                  state.
                  getRandom(
                    0,
                    1,
                    1);
                float s =
                  (float)
                    java.lang.Math.
                    pow(
                      v,
                      1 /
                        (this.
                           power +
                           1));
                float s1 =
                  (float)
                    java.lang.Math.
                    sqrt(
                      1 -
                        s *
                        s);
                org.sunflow.math.Vector3 w =
                  new org.sunflow.math.Vector3(
                  (float)
                    java.lang.Math.
                    cos(
                      u) *
                    s1,
                  (float)
                    java.lang.Math.
                    sin(
                      u) *
                    s1,
                  s);
                w =
                  onb.
                    transform(
                      w,
                      new org.sunflow.math.Vector3(
                        ));
                state.
                  traceReflectionPhoton(
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
       "HQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "e/PZO/74tX/09LfzU/v/BQnXVCiCJwAA");
}
