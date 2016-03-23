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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rPSxHa4Xcj2sSmZINBvqVJJlcy1WfNMmMo8hYltTGrK5EtHcsSf+wnPxemMY" +
       "mdogmWTzWdjIxCWWOIq7QHx/m0nMtqY31uFI0rf4ltIYQcyqFaZVb4iNugs6" +
       "qW7NuGFH0WRC1+b8jpNSf8RM6rWBthDJNdvdin2SsWREHopmN1eJFsY38Hi1" +
       "sbu0XFk6QSBNKWbdwEZ0ZGMCmtQascXyY3uq8bQ9rVLumMy205bv9PjZjmVx" +
       "23YXNNlPxqaJ25QdItqknzfZJFmHFl/HKAJPwkxdxNvZNg8aahSTHCO5vKA4" +
       "Zp0QWNKXcoNHGJmeUNJ4l0uBOI/UabUbUXp7OEuoTCdUZxw2wwC3JQqbMNvm" +
       "ullR2y2qHQ2xrbc28gUyD6m2xmyW/Gxdsc1ql8o5OqMng4mI+cNlH2f7XV5T" +
       "XcFQZt25PKRNt2URybLVEYRBqz8d9+1puz3ms264ayHKFtUNq+7EXE1G0upw" +
       "aLc7mefKjAlnaAtpCy00Dma7HjNp54Nc5b2Y0aIcHnYzZtIimKwViwoO19VN" +
       "jdXjBoGFXVcYkpKdWB2Ew2KaIapG3pNqMMcKS2YaIAFK+nJabW+7CyGvV5F0" +
       "50+G1XrPs0hijcfxblGroFgdm+PMMAunxGokhqY051ZTFB3Yc0pYCy6wZ0Ry" +
       "WM5u9b1BszeD9U6zJbtdna/xroDrNr9W1q3GVO5WY8RMV6OB7bdJYTrl1Fzg" +
       "FgtMrXPbpL/25t0+w853tuRZssVtGeDm6HQ06pm2MBpNw1qnPdfW9mA7E9ty" +
       "FeniYUOtits8XFQjPu4q2zRfdkSni88lbrjy2wtFHClmaIfLRnuhOmQ8TTrU" +
       "rpf0OUafzacxa/KdwFN7E2TblkfmSs5aWDTF+xHiIBU9XSENHhNbfn08puwx" +
       "WpVVZTbGFH666W3dOjtxqbyHz9VlEizXnfFyZe627HjEiSMDjdY4NmRCgkx2" +
       "UduvWo0WS1aCUVpX2VprUon6eajUA5Hg5AFFjO2xrcihOtgJQ25bXeijSa8/" +
       "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" +
       "lecw/xclJe9X/SkAAA==");
}
