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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3T/+5u+UZzH/F+hGGj4LKgAA");
}
