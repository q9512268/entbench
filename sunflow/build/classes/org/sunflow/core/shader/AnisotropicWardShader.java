package org.sunflow.core.shader;
public class AnisotropicWardShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color rhoD;
    private org.sunflow.image.Color rhoS;
    private float alphaX;
    private float alphaY;
    private int numRays;
    public AnisotropicWardShader() { super();
                                     rhoD = org.sunflow.image.Color.GRAY;
                                     rhoS = org.sunflow.image.Color.GRAY;
                                     alphaX = 1;
                                     alphaY = 1;
                                     numRays = 4; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        rhoD =
          pl.
            getColor(
              "diffuse",
              rhoD);
        rhoS =
          pl.
            getColor(
              "specular",
              rhoS);
        alphaX =
          pl.
            getFloat(
              "roughnessX",
              alphaX);
        alphaY =
          pl.
            getFloat(
              "roughnessY",
              alphaY);
        numRays =
          pl.
            getInt(
              "samples",
              numRays);
        return true;
    }
    protected org.sunflow.image.Color getDiffuse(org.sunflow.core.ShadingState state) {
        return rhoD;
    }
    private float brdf(org.sunflow.math.Vector3 i, org.sunflow.math.Vector3 o,
                       org.sunflow.math.OrthoNormalBasis basis) {
        float fr =
          4 *
          (float)
            java.lang.Math.
              PI *
          alphaX *
          alphaY;
        fr *=
          (float)
            java.lang.Math.
            sqrt(
              basis.
                untransformZ(
                  i) *
                basis.
                untransformZ(
                  o));
        org.sunflow.math.Vector3 h =
          org.sunflow.math.Vector3.
          add(
            i,
            o,
            new org.sunflow.math.Vector3(
              ));
        basis.
          untransform(
            h);
        float hx =
          h.
            x /
          alphaX;
        hx *=
          hx;
        float hy =
          h.
            y /
          alphaY;
        hy *=
          hy;
        float hn =
          h.
            z *
          h.
            z;
        fr =
          (float)
            java.lang.Math.
            exp(
              -(hx +
                  hy) /
                hn) /
            fr;
        return fr;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        state.
          faceforward(
            );
        org.sunflow.math.OrthoNormalBasis onb =
          state.
          getBasis(
            );
        state.
          initLightSamples(
            );
        state.
          initCausticSamples(
            );
        org.sunflow.image.Color lr =
          org.sunflow.image.Color.
          black(
            );
        if (state.
              includeSpecular(
                )) {
            org.sunflow.math.Vector3 in =
              state.
              getRay(
                ).
              getDirection(
                ).
              negate(
                new org.sunflow.math.Vector3(
                  ));
            for (org.sunflow.core.LightSample sample
                  :
                  state) {
                float cosNL =
                  sample.
                  dot(
                    state.
                      getNormal(
                        ));
                float fr =
                  brdf(
                    in,
                    sample.
                      getShadowRay(
                        ).
                      getDirection(
                        ),
                    onb);
                lr.
                  madd(
                    cosNL *
                      fr,
                    sample.
                      getSpecularRadiance(
                        ));
            }
            if (numRays >
                  0) {
                int n =
                  state.
                  getDepth(
                    ) ==
                  0
                  ? numRays
                  : 1;
                for (int i =
                       0;
                     i <
                       n;
                     i++) {
                    double r1 =
                      state.
                      getRandom(
                        i,
                        0,
                        n);
                    double r2 =
                      state.
                      getRandom(
                        i,
                        1,
                        n);
                    float alphaRatio =
                      alphaY /
                      alphaX;
                    float phi =
                      0;
                    if (r1 <
                          0.25) {
                        double val =
                          4 *
                          r1;
                        phi =
                          (float)
                            java.lang.Math.
                            atan(
                              alphaRatio *
                                java.lang.Math.
                                tan(
                                  java.lang.Math.
                                    PI /
                                    2 *
                                    val));
                    }
                    else
                        if (r1 <
                              0.5) {
                            double val =
                              1 -
                              4 *
                              (0.5 -
                                 r1);
                            phi =
                              (float)
                                java.lang.Math.
                                atan(
                                  alphaRatio *
                                    java.lang.Math.
                                    tan(
                                      java.lang.Math.
                                        PI /
                                        2 *
                                        val));
                            phi =
                              (float)
                                java.lang.Math.
                                  PI -
                                phi;
                        }
                        else
                            if (r1 <
                                  0.75) {
                                double val =
                                  4 *
                                  (r1 -
                                     0.5);
                                phi =
                                  (float)
                                    java.lang.Math.
                                    atan(
                                      alphaRatio *
                                        java.lang.Math.
                                        tan(
                                          java.lang.Math.
                                            PI /
                                            2 *
                                            val));
                                phi +=
                                  java.lang.Math.
                                    PI;
                            }
                            else {
                                double val =
                                  1 -
                                  4 *
                                  (1 -
                                     r1);
                                phi =
                                  (float)
                                    java.lang.Math.
                                    atan(
                                      alphaRatio *
                                        java.lang.Math.
                                        tan(
                                          java.lang.Math.
                                            PI /
                                            2 *
                                            val));
                                phi =
                                  2 *
                                    (float)
                                      java.lang.Math.
                                        PI -
                                    phi;
                            }
                    float cosPhi =
                      (float)
                        java.lang.Math.
                        cos(
                          phi);
                    float sinPhi =
                      (float)
                        java.lang.Math.
                        sin(
                          phi);
                    float denom =
                      cosPhi *
                      cosPhi /
                      (alphaX *
                         alphaX) +
                      sinPhi *
                      sinPhi /
                      (alphaY *
                         alphaY);
                    float theta =
                      (float)
                        java.lang.Math.
                        atan(
                          java.lang.Math.
                            sqrt(
                              -java.lang.Math.
                                log(
                                  1 -
                                    r2) /
                                denom));
                    float sinTheta =
                      (float)
                        java.lang.Math.
                        sin(
                          theta);
                    float cosTheta =
                      (float)
                        java.lang.Math.
                        cos(
                          theta);
                    org.sunflow.math.Vector3 h =
                      new org.sunflow.math.Vector3(
                      );
                    h.
                      x =
                      sinTheta *
                        cosPhi;
                    h.
                      y =
                      sinTheta *
                        sinPhi;
                    h.
                      z =
                      cosTheta;
                    onb.
                      transform(
                        h);
                    org.sunflow.math.Vector3 o =
                      new org.sunflow.math.Vector3(
                      );
                    float ih =
                      org.sunflow.math.Vector3.
                      dot(
                        h,
                        in);
                    o.
                      x =
                      2 *
                        ih *
                        h.
                          x -
                        in.
                          x;
                    o.
                      y =
                      2 *
                        ih *
                        h.
                          y -
                        in.
                          y;
                    o.
                      z =
                      2 *
                        ih *
                        h.
                          z -
                        in.
                          z;
                    float no =
                      onb.
                      untransformZ(
                        o);
                    float ni =
                      onb.
                      untransformZ(
                        in);
                    float w =
                      ih *
                      cosTheta *
                      cosTheta *
                      cosTheta *
                      (float)
                        java.lang.Math.
                        sqrt(
                          java.lang.Math.
                            abs(
                              no /
                                ni));
                    org.sunflow.core.Ray r =
                      new org.sunflow.core.Ray(
                      state.
                        getPoint(
                          ),
                      o);
                    lr.
                      madd(
                        w /
                          n,
                        state.
                          traceGlossy(
                            r,
                            i));
                }
            }
            lr.
              mul(
                rhoS);
        }
        lr.
          add(
            state.
              diffuse(
                getDiffuse(
                  state)));
        return lr;
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
          rhoS.
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
                power.
                  mul(
                    rhoS).
                  mul(
                    1 /
                      avgS);
                org.sunflow.math.OrthoNormalBasis basis =
                  state.
                  getBasis(
                    );
                org.sunflow.math.Vector3 in =
                  state.
                  getRay(
                    ).
                  getDirection(
                    ).
                  negate(
                    new org.sunflow.math.Vector3(
                      ));
                double r1 =
                  rnd /
                  avgS;
                double r2 =
                  state.
                  getRandom(
                    0,
                    1,
                    1);
                float alphaRatio =
                  alphaY /
                  alphaX;
                float phi =
                  0;
                if (r1 <
                      0.25) {
                    double val =
                      4 *
                      r1;
                    phi =
                      (float)
                        java.lang.Math.
                        atan(
                          alphaRatio *
                            java.lang.Math.
                            tan(
                              java.lang.Math.
                                PI /
                                2 *
                                val));
                }
                else
                    if (r1 <
                          0.5) {
                        double val =
                          1 -
                          4 *
                          (0.5 -
                             r1);
                        phi =
                          (float)
                            java.lang.Math.
                            atan(
                              alphaRatio *
                                java.lang.Math.
                                tan(
                                  java.lang.Math.
                                    PI /
                                    2 *
                                    val));
                        phi =
                          (float)
                            java.lang.Math.
                              PI -
                            phi;
                    }
                    else
                        if (r1 <
                              0.75) {
                            double val =
                              4 *
                              (r1 -
                                 0.5);
                            phi =
                              (float)
                                java.lang.Math.
                                atan(
                                  alphaRatio *
                                    java.lang.Math.
                                    tan(
                                      java.lang.Math.
                                        PI /
                                        2 *
                                        val));
                            phi +=
                              java.lang.Math.
                                PI;
                        }
                        else {
                            double val =
                              1 -
                              4 *
                              (1 -
                                 r1);
                            phi =
                              (float)
                                java.lang.Math.
                                atan(
                                  alphaRatio *
                                    java.lang.Math.
                                    tan(
                                      java.lang.Math.
                                        PI /
                                        2 *
                                        val));
                            phi =
                              2 *
                                (float)
                                  java.lang.Math.
                                    PI -
                                phi;
                        }
                float cosPhi =
                  (float)
                    java.lang.Math.
                    cos(
                      phi);
                float sinPhi =
                  (float)
                    java.lang.Math.
                    sin(
                      phi);
                float denom =
                  cosPhi *
                  cosPhi /
                  (alphaX *
                     alphaX) +
                  sinPhi *
                  sinPhi /
                  (alphaY *
                     alphaY);
                float theta =
                  (float)
                    java.lang.Math.
                    atan(
                      java.lang.Math.
                        sqrt(
                          -java.lang.Math.
                            log(
                              1 -
                                r2) /
                            denom));
                float sinTheta =
                  (float)
                    java.lang.Math.
                    sin(
                      theta);
                float cosTheta =
                  (float)
                    java.lang.Math.
                    cos(
                      theta);
                org.sunflow.math.Vector3 h =
                  new org.sunflow.math.Vector3(
                  );
                h.
                  x =
                  sinTheta *
                    cosPhi;
                h.
                  y =
                  sinTheta *
                    sinPhi;
                h.
                  z =
                  cosTheta;
                basis.
                  transform(
                    h);
                org.sunflow.math.Vector3 o =
                  new org.sunflow.math.Vector3(
                  );
                float ih =
                  org.sunflow.math.Vector3.
                  dot(
                    h,
                    in);
                o.
                  x =
                  2 *
                    ih *
                    h.
                      x -
                    in.
                      x;
                o.
                  y =
                  2 *
                    ih *
                    h.
                      y -
                    in.
                      y;
                o.
                  z =
                  2 *
                    ih *
                    h.
                      z -
                    in.
                      z;
                org.sunflow.core.Ray r =
                  new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  o);
                state.
                  traceReflectionPhoton(
                    r,
                    power);
            }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "SwJdjY3LdpiuL3zfMVTv3Eo/+432ly6OUhb8+JnaypO658Hz0onaXnonagPm" +
       "FoR+bGixoV+qvSt3Wvpzl1q65S2L+y9G2cOX7qOdf1okX4ihG0sjpizTTKLS" +
       "FJhzVXzxW1BFuVn7JHhePlHFy+/UgshLdXB1D0SnOnj6og5cNV4dy0Zx2IYW" +
       "9f/ilOrFu6iGIXAOvjx/bquRFZVj/cJ9tPXlIvm5GHpgEepmkVfO9fTz34Ke" +
       "Hj/1LuJET8Sfj6ddOSf4RyXBv76PcP+mSH4tht4FTGEMTKgAjANb+PVvQcby" +
       "2P7D4Hn9RMbX/1zRpJSxZLek+sp9BP39IvmtGHo00tQYoIyw8uMTJD7cek59" +
       "Sz8X/7ffifh5DL330islxfn403fdZtvfwNJ+5s2bDz315uTflbcqzm5JPcxB" +
       "D5mJ41w8zryQvxaEhmmVsj28P9wMytdXL1sI97ddinOIMlPy/Ud7+v8aQ7cO" +
       "6YESitdFsreBjVwgA/h5krtI9N9i6CogKrJ/ElxyiLE/1s2vXFhST0ymVPUT" +
       "30jVZ00u3rooluHyOuHpkpnsLxS+qn3hzR7//W/Xf2J/60Nz1N2u6OUhDrq+" +
       "v4Bytuy+eM/eTvu61n3564998eGXTkOEx/YMn5vvBd7ed/kVi44bxOWliN0/" +
       "eeofftdPvvm75ZnK/wUkTG8J5ykAAA==");
}
