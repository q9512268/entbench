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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "yzPhfwFzfL3PNxwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
