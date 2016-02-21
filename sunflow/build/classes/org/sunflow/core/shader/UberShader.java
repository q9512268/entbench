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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZe5AUxRnv3YN78bgXdyBwJxwnVYdkV0Gx5AwKx+vIclxx" +
       "QJVL5Oid7b0bmJ0ZZnrv9tBLlKpEtCqEJIgkpfyFJVoqVhIrqUqgSKz4KE0q" +
       "PhI1D8zDqhCNFYmJpiBqvq97Zmd2dmepM2arpqd35vu6v1f/+vt6HnuXTLUt" +
       "0sF0HuPjJrNj63Q+QC2bpXs1atvb4NmQcn8VfX/X+f4bo6Q6SWaOUHuzQm22" +
       "XmVa2k6SdlW3OdUVZvczlkaOAYvZzBqlXDX0JGlV7b6sqamKyjcbaYYEO6iV" +
       "IE2Uc0tN5TjrcwbgpD0BksSFJPHVwdc9CTJdMcxxj3yOj7zX9wYps95cNieN" +
       "iT10lMZzXNXiCdXmPXmLXG0a2viwZvAYy/PYHu16xwSbEteXmKDzyYYPLh0e" +
       "aRQmaKG6bnChnr2V2YY2ytIJ0uA9XaexrL2PfIlUJcg0HzEnXQl30jhMGodJ" +
       "XW09KpB+BtNz2V5DqMPdkapNBQXiZGHxICa1aNYZZkDIDCPUckd3wQzaLiho" +
       "K7UsUfG+q+NH7t/V+N0q0pAkDao+iOIoIASHSZJgUJZNMctenU6zdJI06eDs" +
       "QWapVFP3O55uttVhnfIcuN81Cz7MmcwSc3q2Aj+CblZO4YZVUC8jAsr5NzWj" +
       "0WHQtc3TVWq4Hp+DgvUqCGZlKMSdwzJlr6qnObkyyFHQsesLQACsNVnGR4zC" +
       "VFN0Cg9IswwRjerD8UEIPX0YSKcaEIAWJ3NDB0Vbm1TZS4fZEEZkgG5AvgKq" +
       "OmEIZOGkNUgmRgIvzQ14yeefd/tvOnS7vlGPkgjInGaKhvJPA6aOANNWlmEW" +
       "g3UgGacvSRylbacPRgkB4tYAsaT5wR0XblnacfY5STOvDM2W1B6m8CHlRGrm" +
       "S/N7u2+sQjFqTcNW0flFmotVNuC86cmbgDBthRHxZcx9eXbrM7fe+Sh7J0rq" +
       "+0i1Ymi5LMRRk2JkTVVj1gamM4tylu4jdUxP94r3faQG+glVZ/LplkzGZryP" +
       "TNHEo2pD/AcTZWAINFE99FU9Y7h9k/IR0c+bhJAauEg3XA1E/sSdk9viI0aW" +
       "xalCdVU34gOWgfqjQ/U0jXNmQz8Nb00jbuf0jGaMxW1LiRvWcOG/Ylgsbo/Q" +
       "NLPi22HtDIpuDMPM/H9PkEcNW8YiETD+/ODS12DVbDQ0oB1SjuTWrLvwxNAL" +
       "MqxwKTi24aQT5oo5c8VwrpicK+bNRSIRMcUsnFP6FjyzF9Y4gOz07sHbNu0+" +
       "2FkFQWWOTQGzImln0WbT6wGBi95Dyj82/XH5xomVr0RJFLAiBZuNh/kLfJiP" +
       "m5VlKCwNkBOG/S7+xcPRvqwM5Oyxsbt2fPkaIYMfxHHAqYA/yD6A0FuYoiu4" +
       "eMuN23D3+Q9OHZ0wvGVctCu4m1kJJ6JDZ9CRQeWHlCUL6FNDpye6omQKQA7A" +
       "LKewLADBOoJzFKFEj4u4qEstKJwxrCzV8JULk/V8xDLGvCciwppEfxa4dhou" +
       "m1a4rnDWkbjj2zYT29kyIjFWAloIRP/8oPng67/463Jhbhf8G3y79iDjPT7A" +
       "wcGaBbQ0eaG3zWIM6H5/bOBb9717904Rd0CxqNyEXdj2AtCAC8HMX3lu3xtv" +
       "njvxatSLVQ47bi4FiUu+oCQ+J/UVlITZFnvyAGBpsKYxarq26xCVakalKY3h" +
       "4vhPw1XXPvW3Q40yDjR44obR0ssP4D2/Yg2584VdH3aIYSIKbpiezTwyicIt" +
       "3sirLYuOoxz5u15u//az9EHAc8BQW93PBCwSYQMinHad0D8u2uWBdyuw6bL9" +
       "wV+8vnyJzZBy+NX3Zux478wFIW1xZuT39WZq9sjwwuaqPAw/OwgwG6k9AnTX" +
       "ne3/YqN29hKMmIQRFUgH7C0WIFO+KDIc6qk1v/nJ0227X6oi0fWkXjNoej0V" +
       "i4zUQXQzewRAMW/efIt07lgtNI1CVVKiPNrzyvKeWpc1ubDt/h/O/v5NDx8/" +
       "J4JKRtE8wV6LqFyEgyKb9pbxo6/c8KuHv3F0TO7H3eHYFeCbc3GLljrwp3+X" +
       "GFigVplcIcCfjD/2wNzeVe8Ifg8+kHtRvnQnAYD1eJc9mv1XtLP6Z1FSkySN" +
       "ipO97qBaDhdlEjI2201pIcMtel+cfclUo6cAj/OD0OWbNghc3g4GfaTG/owA" +
       "Vk1HD852neve/VgVIaKzQbAsFm03NktdaKgxLRUqHBbAhmkVBuWgjwrJCf6Z" +
       "w8ls/+6qZiFJxCAyLAmT2N6AzUY5w8rQoFxdqlaTI0FTiFpbpVrYbCqVP4wb" +
       "5LdNpmC/PyDk4CSFnA9XszNNc4iQt1YUMowbPINGzlLTtfOckixmG6wi2DQD" +
       "OiQ/hQ4tjhQtITqkKuoQxg06oKFBB/y7KyCn8inknOXMNCtETrWinGHcnNSh" +
       "rddokIUXJ3ZY6A/mUjakZ2oW9utRpxRZNrBbOdg18JaEtSvKMEi61pPxr+14" +
       "bc+LIhuoxQRwm7uUfendamvYl4o0SsE/gV8Ero/xQoHxAd4BY3qdumJBobAw" +
       "TdxcKuBrQIH4RPObex84/7hUIAimAWJ28Mi9n8QOHZFbvKxOF5UUiH4eWaFK" +
       "dbDZh9ItrDSL4Fj/l1MTPzo5cbeUqrm41lqn57KP//qjF2PH/vB8mSQf0NOg" +
       "vLC9RQp5+qxi70iV1t7T8OPDzVXrIb3sI7U5Xd2XY33pYtitsXMpn7u8uteD" +
       "Ykc5dA0nkSXghUCQ7/kUQd7qhGlrSJDfVTHIw7ghyHExiiDHB2ZA0gOTlLQd" +
       "rjZnrrYQSQ9WlDSMm5N68Lptj+uQA5UT9Z5JijqPyO2EuPcyon69oqhh3CAq" +
       "ROUgzZqaI6vuhDvebF9/jJMqVS+JT/w7EQyawxX0y3tyLinIKX7VJFD7++T0" +
       "pWyRsvu22E9kKYxLtT3s+EYs0xMHjhxPb3no2qiTO+chtrhhfk5jo0zzTYVH" +
       "su1F2eFmcWDlpVr1X72mJcHzmdICGUfpCCmBl4TDXHCCZw+8PXfbqpHdk6h+" +
       "rwzoHhzykc2PPb9hsfLNqDhzk5ldyVldMVNPMbDUWwz2bb0YSjoL3hTbKBZk" +
       "Cx1vLgzGrBcvgUAo1HVhrIEKKCr8FHVDoqMkJIRpGGcWlgEuWZufbFDeVw/0" +
       "CbEer1BjfQ+bk1CO5sw0bFqXWy81KcPQGNXLrxlvuTxyOTgoKnfwwc3i8YmC" +
       "2ZpclFjmmG3Z5C0exhqwR6R4EbaXXYSqPoyn1kxM+9MKFn0Gm9MImIyvhRQm" +
       "Z4uI6veMc+azMQ7uSyscDVdM3jhhrOWNg3+fFqP+soLuL2PzAifTQPdB2Nly" +
       "GrUCyr/42Sm/0tFg5eSVD2O9nPK/q6D8OWxek8pvhYBxIdOn/Ov/s/LiKGwV" +
       "XElHg+TklQ9jLQ9EQnmhhxj6fAULvI3NnzmZYSuUA0ANjBjcwfUAjkwZNdS0" +
       "Z5e3Jm8X2ODqvbNiPDGZU/IVSn45UZ443lA7+/j218S5ZeHrxnTI/jM5TfMX" +
       "9b5+tWmxjCrUmi5LfJlI/rPcLi3PrgFFZUeI/L6k/5CTxiA96I83P9lFiBsf" +
       "GZZpsucn+ggSFiDC7seFGrRRHBTh4UZMHm7kI779nvhAufVyVi6w+M81cT8X" +
       "nwHdvTcnPwQOKaeOb+q//cKKh+S5qqLR/ftxlGmQpssj3sL+vTB0NHes6o3d" +
       "l2Y+WXeVm780SYG9YJ7ni7ObYU2a6PK5gUNHu6tw9vjGiZvO/Pxg9ctQluwk" +
       "EcpJy87SY6C8mYN0aGeitByB3EachvZ0f2d81dLM338rztmILF/mh9MPKXUX" +
       "D+1faEdiUVLXR6ZCasby4nxq7bi+lSmjVlFtU50ycnrha+FMjE2KnweFVRxj" +
       "zig8xTN5TjpLy7zS7xT1EDrMWoOj4zAzAtlOzjT9b4VV75BLFK0McTaU2Gya" +
       "bn17WljdNHHpRYRrJv4LxNHI/t8fAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fP8bOPN96wHOwyb/4+hTv97/FuXHjqCLp2clt1wVubnSCzefkFwJtTgJvdlN" +
       "5yRPn0q+3PAujiGfPZb8s4fbdGdje/s9unfudePgkO+oJDg6GatnbhmrUg5a" +
       "rIXFKeIJ2ePnyab7f4yjyx5+8S7HiL9SJP85hi4lgSrF2u12oi7Lvu9oknem" +
       "pT/31fahzvdSFnzmVGwPn+xuosdiQ78xYrtws4o/fVsVtzyjuOaklS187i5i" +
       "+Z9F8qvFrq4WE5auJ1GpA/0zGXz265VBsSHePJZB8xsqg+L18yXB792FxT8o" +
       "ki/E0AOAxWmgKYkjhQc8/tY3gsd3H/P47n8mHv/kLjz+aZF8ac/jBAx/YeUH" +
       "PP7x18FjefXiPeARj3kUv6EuoOSxhFtSvXYXRv+mSP4qht4UKVIMXANn+vGx" +
       "+zzcV059Sz1j/8tvhP0cGMTZXaDiYsOTt9wy3N+MU372lav3PfHK/HfK6zCn" +
       "t9fuZ6D79MRxzp9Dn8tfCkJNt0qG7t+fSgfl3z/eLmTt7yYVJwtlpgT7DyX9" +
       "BSiGrh3SA86Lv/NkF4FinCMrjiH3ufNEl2LoIiAqspdPD1TPHRLsz+PzC+eC" +
       "37GelPJ95KvJ97TK+esyRcAsr3meBLdkf9HzReXTrwzY732t+VP76zqKI+12" +
       "RSv3MdDl/c2h0wD57B1bO2nrEvX8Vx76zP3vOAnmD+0Bn+nsOWxvvf3dmJ4b" +
       "xOVtlt0vPvFz3/7vX/mj8pTk/wM1wpxNfysAAA==");
}
