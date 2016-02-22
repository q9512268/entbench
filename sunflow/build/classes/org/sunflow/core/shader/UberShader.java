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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ayPT+Ngi0cXe4v8B0h+cAc8gAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+Plv/i+v/EG5u/JvAgPuBaMrAAA=");
}
