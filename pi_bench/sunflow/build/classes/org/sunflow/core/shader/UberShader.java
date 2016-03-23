package org.sunflow.core.shader;
public class UberShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color diff;
    private org.sunflow.image.Color spec;
    private org.sunflow.core.Texture diffmap;
    private org.sunflow.core.Texture specmap;
    private float diffBlend;
    private float specBlend;
    private float glossyness;
    private int numSamples;
    public UberShader() { super();
                          diff = (spec = org.sunflow.image.Color.GRAY);
                          diffmap = (specmap = null);
                          diffBlend = (specBlend = 1);
                          glossyness = 0;
                          numSamples = 4; }
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
        java.lang.String filename;
        filename =
          pl.
            getString(
              "diffuse.texture",
              null);
        if (filename !=
              null)
            diffmap =
              org.sunflow.core.TextureCache.
                getTexture(
                  api.
                    resolveTextureFilename(
                      filename),
                  false);
        filename =
          pl.
            getString(
              "specular.texture",
              null);
        if (filename !=
              null)
            specmap =
              org.sunflow.core.TextureCache.
                getTexture(
                  api.
                    resolveTextureFilename(
                      filename),
                  false);
        diffBlend =
          org.sunflow.math.MathUtils.
            clamp(
              pl.
                getFloat(
                  "diffuse.blend",
                  diffBlend),
              0,
              1);
        specBlend =
          org.sunflow.math.MathUtils.
            clamp(
              pl.
                getFloat(
                  "specular.blend",
                  diffBlend),
              0,
              1);
        glossyness =
          org.sunflow.math.MathUtils.
            clamp(
              pl.
                getFloat(
                  "glossyness",
                  glossyness),
              0,
              1);
        numSamples =
          pl.
            getInt(
              "samples",
              numSamples);
        return true;
    }
    public org.sunflow.image.Color getDiffuse(org.sunflow.core.ShadingState state) {
        return diffmap ==
          null
          ? diff
          : org.sunflow.image.Color.
          blend(
            diff,
            diffmap.
              getPixel(
                state.
                  getUV(
                    ).
                  x,
                state.
                  getUV(
                    ).
                  y),
            diffBlend);
    }
    public org.sunflow.image.Color getSpecular(org.sunflow.core.ShadingState state) {
        return specmap ==
          null
          ? spec
          : org.sunflow.image.Color.
          blend(
            spec,
            specmap.
              getPixel(
                state.
                  getUV(
                    ).
                  x,
                state.
                  getUV(
                    ).
                  y),
            specBlend);
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
        if (glossyness ==
              0) {
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
            ret.
              sub(
                spec);
            ret.
              mul(
                cos5);
            ret.
              add(
                spec);
            return lr.
              add(
                ret.
                  mul(
                    state.
                      traceReflection(
                        refRay,
                        0)));
        }
        else
            return lr.
              add(
                state.
                  specularPhong(
                    getSpecular(
                      state),
                    2 /
                      glossyness,
                    numSamples));
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        org.sunflow.image.Color diffuse;
        org.sunflow.image.Color specular;
        state.
          faceforward(
            );
        diffuse =
          getDiffuse(
            state);
        specular =
          getSpecular(
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
          specular.
          getAverage(
            );
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
                if (glossyness ==
                      0) {
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
                else {
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
                          r);
                    org.sunflow.math.OrthoNormalBasis onb =
                      state.
                      getBasis(
                        );
                    double u =
                      2 *
                      java.lang.Math.
                        PI *
                      (rnd -
                         r) /
                      r;
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
                            (1.0F /
                               glossyness +
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
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ND4ym3exN+f/2a98VsUgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "q39U7qz8E6GZ4VOVKwAA");
}
