package org.sunflow.core.gi;
public class InstantGI implements org.sunflow.core.GIEngine {
    private int numPhotons;
    private int numSets;
    private float c;
    private int numBias;
    private org.sunflow.core.gi.InstantGI.PointLight[][] virtualLights;
    public InstantGI(org.sunflow.core.Options options) { super();
                                                         numPhotons = options.
                                                                        getInt(
                                                                          "gi.igi.samples",
                                                                          64);
                                                         numSets =
                                                           options.
                                                             getInt(
                                                               "gi.igi.sets",
                                                               1);
                                                         c = options.
                                                               getFloat(
                                                                 "gi.igi.c",
                                                                 3.0E-5F);
                                                         numBias =
                                                           options.
                                                             getInt(
                                                               "gi.igi.bias_samples",
                                                               0);
                                                         virtualLights =
                                                           null;
    }
    public org.sunflow.image.Color getGlobalRadiance(org.sunflow.core.ShadingState state) {
        org.sunflow.math.Point3 p =
          state.
          getPoint(
            );
        org.sunflow.math.Vector3 n =
          state.
          getNormal(
            );
        int set =
          (int)
            (state.
               getRandom(
                 0,
                 1,
                 1) *
               numSets);
        float maxAvgPow =
          0;
        float minDist =
          1;
        org.sunflow.image.Color pow =
          null;
        for (org.sunflow.core.gi.InstantGI.PointLight vpl
              :
              virtualLights[set]) {
            maxAvgPow =
              java.lang.Math.
                max(
                  maxAvgPow,
                  vpl.
                    power.
                    getAverage(
                      ));
            if (org.sunflow.math.Vector3.
                  dot(
                    n,
                    vpl.
                      n) >
                  0.9F) {
                float d =
                  vpl.
                    p.
                  distanceToSquared(
                    p);
                if (d <
                      minDist) {
                    pow =
                      vpl.
                        power;
                    minDist =
                      d;
                }
            }
        }
        return pow ==
          null
          ? org.sunflow.image.Color.
              BLACK
          : pow.
          copy1(
            ).
          mul(
            1.0F /
              maxAvgPow);
    }
    public boolean init(org.sunflow.core.Scene scene) {
        if (numSets <
              1)
            numSets =
              1;
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "Instant Global Illumination settings:");
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Samples:     %d",
            numPhotons);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Sets:        %d",
            numSets);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Bias bound:  %f",
            c);
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              LIGHT,
            "  * Bias rays:   %d",
            numBias);
        virtualLights =
          (new org.sunflow.core.gi.InstantGI.PointLight[numSets][]);
        if (numPhotons >
              0) {
            for (int i =
                   0,
                   seed =
                     0;
                 i <
                   virtualLights.
                     length;
                 i++,
                   seed +=
                     numPhotons) {
                org.sunflow.core.gi.InstantGI.PointLightStore map =
                  new org.sunflow.core.gi.InstantGI.PointLightStore(
                  );
                if (!scene.
                      calculatePhotons(
                        map,
                        "virtual",
                        seed))
                    return false;
                virtualLights[i] =
                  map.
                    virtualLights.
                    toArray(
                      new org.sunflow.core.gi.InstantGI.PointLight[map.
                                                                     virtualLights.
                                                                     size(
                                                                       )]);
                org.sunflow.system.UI.
                  printInfo(
                    org.sunflow.system.UI.Module.
                      LIGHT,
                    "Stored %d virtual point lights for set %d of %d",
                    virtualLights[i].
                      length,
                    i +
                      1,
                    numSets);
            }
        }
        else {
            for (int i =
                   0;
                 i <
                   virtualLights.
                     length;
                 i++)
                virtualLights[i] =
                  (new org.sunflow.core.gi.InstantGI.PointLight[0]);
        }
        return true;
    }
    public org.sunflow.image.Color getIrradiance(org.sunflow.core.ShadingState state,
                                                 org.sunflow.image.Color diffuseReflectance) {
        float b =
          (float)
            java.lang.Math.
              PI *
          c /
          diffuseReflectance.
          getMax(
            );
        org.sunflow.image.Color irr =
          org.sunflow.image.Color.
          black(
            );
        org.sunflow.math.Point3 p =
          state.
          getPoint(
            );
        org.sunflow.math.Vector3 n =
          state.
          getNormal(
            );
        int set =
          (int)
            (state.
               getRandom(
                 0,
                 1,
                 1) *
               numSets);
        for (org.sunflow.core.gi.InstantGI.PointLight vpl
              :
              virtualLights[set]) {
            org.sunflow.core.Ray r =
              new org.sunflow.core.Ray(
              p,
              vpl.
                p);
            float dotNlD =
              -(r.
                  dx *
                  vpl.
                    n.
                    x +
                  r.
                    dy *
                  vpl.
                    n.
                    y +
                  r.
                    dz *
                  vpl.
                    n.
                    z);
            float dotND =
              r.
                dx *
              n.
                x +
              r.
                dy *
              n.
                y +
              r.
                dz *
              n.
                z;
            if (dotNlD >
                  0 &&
                  dotND >
                  0) {
                float r2 =
                  r.
                  getMax(
                    ) *
                  r.
                  getMax(
                    );
                org.sunflow.image.Color opacity =
                  state.
                  traceShadow(
                    r);
                org.sunflow.image.Color power =
                  org.sunflow.image.Color.
                  blend(
                    vpl.
                      power,
                    org.sunflow.image.Color.
                      BLACK,
                    opacity);
                float g =
                  dotND *
                  dotNlD /
                  r2;
                irr.
                  madd(
                    0.25F *
                      java.lang.Math.
                      min(
                        g,
                        b),
                    power);
            }
        }
        int nb =
          state.
          getDiffuseDepth(
            ) ==
          0 ||
          numBias <=
          0
          ? numBias
          : 1;
        if (nb <=
              0)
            return irr;
        org.sunflow.math.OrthoNormalBasis onb =
          state.
          getBasis(
            );
        org.sunflow.math.Vector3 w =
          new org.sunflow.math.Vector3(
          );
        float scale =
          (float)
            java.lang.Math.
              PI /
          nb;
        for (int i =
               0;
             i <
               nb;
             i++) {
            float xi =
              (float)
                state.
                getRandom(
                  i,
                  0,
                  nb);
            float xj =
              (float)
                state.
                getRandom(
                  i,
                  1,
                  nb);
            float phi =
              (float)
                (xi *
                   2 *
                   java.lang.Math.
                     PI);
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
            float sinTheta =
              (float)
                java.lang.Math.
                sqrt(
                  xj);
            float cosTheta =
              (float)
                java.lang.Math.
                sqrt(
                  1.0F -
                    xj);
            w.
              x =
              cosPhi *
                sinTheta;
            w.
              y =
              sinPhi *
                sinTheta;
            w.
              z =
              cosTheta;
            onb.
              transform(
                w);
            org.sunflow.core.Ray r =
              new org.sunflow.core.Ray(
              state.
                getPoint(
                  ),
              w);
            r.
              setMax(
                (float)
                  java.lang.Math.
                  sqrt(
                    cosTheta /
                      b));
            org.sunflow.core.ShadingState temp =
              state.
              traceFinalGather(
                r,
                i);
            if (temp !=
                  null) {
                temp.
                  getInstance(
                    ).
                  prepareShadingState(
                    temp);
                if (temp.
                      getShader(
                        ) !=
                      null) {
                    float dist =
                      temp.
                      getRay(
                        ).
                      getMax(
                        );
                    float r2 =
                      dist *
                      dist;
                    float cosThetaY =
                      -org.sunflow.math.Vector3.
                      dot(
                        w,
                        temp.
                          getNormal(
                            ));
                    if (cosThetaY >
                          0) {
                        float g =
                          cosTheta *
                          cosThetaY /
                          r2;
                        if (g >
                              b)
                            irr.
                              madd(
                                scale *
                                  (g -
                                     b) /
                                  g,
                                temp.
                                  getShader(
                                    ).
                                  getRadiance(
                                    temp));
                    }
                }
            }
        }
        return irr;
    }
    private static class PointLight {
        org.sunflow.math.Point3 p;
        org.sunflow.math.Vector3 n;
        org.sunflow.image.Color power;
        public PointLight() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private class PointLightStore implements org.sunflow.core.PhotonStore {
        java.util.ArrayList<org.sunflow.core.gi.InstantGI.PointLight>
          virtualLights =
          new java.util.ArrayList<org.sunflow.core.gi.InstantGI.PointLight>(
          );
        public int numEmit() { return numPhotons;
        }
        public void prepare(org.sunflow.math.BoundingBox sceneBounds) {
            
        }
        public void store(org.sunflow.core.ShadingState state,
                          org.sunflow.math.Vector3 dir,
                          org.sunflow.image.Color power,
                          org.sunflow.image.Color diffuse) {
            state.
              faceforward(
                );
            org.sunflow.core.gi.InstantGI.PointLight vpl =
              new org.sunflow.core.gi.InstantGI.PointLight(
              );
            vpl.
              p =
              state.
                getPoint(
                  );
            vpl.
              n =
              state.
                getNormal(
                  );
            vpl.
              power =
              power;
            synchronized (this)  {
                virtualLights.
                  add(
                    vpl);
            }
        }
        public void init() {  }
        public boolean allowDiffuseBounced() {
            return true;
        }
        public boolean allowReflectionBounced() {
            return true;
        }
        public boolean allowRefractionBounced() {
            return true;
        }
        public PointLightStore() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456093649000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAK16e+zr1n2f7sv3+hHfa7uxXS927OSmraP2UiQlUoLbLnpQ" +
           "4kOURJHUg1t7Q/H9pvgQKaXukgBbghVNjMzxkiH1Xw7SR1IXw7ING7p5G7Yk" +
           "a1qgW7AlRZcU3YAm7bLVGNINy5rukPq97yMJbAE8Is/5nnO+3+/5fj/nex6f" +
           "/XblUhxVqmHgbg03SG5oeXLDdhs3km2oxTfoYWMiR7Gmdl05jgWQd1N5x29d" +
           "/YvvvmBeO1+5R6o8Ivt+kMiJFfjxVIsDd6Opw8rV41zC1bw4qVwb2vJGhtLE" +
           "cqGhFSfPDSv3n6iaVK4PD1mAAAsQYAEqWYDax1Sg0ls0P/W6RQ3ZT+J15Rcr" +
           "54aVe0KlYC+pPHO6kVCOZO+gmUkpAWjhSvE9A0KVlfOo8vSR7HuZbxH441Xo" +
           "xb//89f+4YXKValy1fL5gh0FMJGATqTKA57mrbQobquqpkqVh3xNU3ktsmTX" +
           "2pV8S5WHY8vw5SSNtCMlFZlpqEVln8eae0ApZItSJQmiI/F0S3PVw69Luisb" +
           "QNZHj2XdS9gv8oGA91mAsUiXFe2wykXH8tWk8vazNY5kvM4AAlD1sqclZnDU" +
           "1UVfBhmVh/dj58q+AfFJZPkGIL0UpKCXpPLEHRstdB3KiiMb2s2k8vhZusm+" +
           "CFDdWyqiqJJU3nqWrGwJjNITZ0bpxPh8e/TTH3mfT/rnS55VTXEL/q+ASk+d" +
           "qTTVdC3SfEXbV3zg3cOX5Ed/+8PnKxVA/NYzxHuaf/ILr7/nJ5967Yt7mr92" +
           "G5rxytaU5KbyyurB339b99nWhYKNK2EQW8Xgn5K8NP/JQclzeQg879GjFovC" +
           "G4eFr03/3fL9v6792fnKfVTlHiVwUw/Y0UNK4IWWq0UDzdciOdFUqnKv5qvd" +
           "spyqXAbvQ8vX9rljXY+1hKpcdMuse4LyG6hIB00UKroM3i1fDw7fQzkxy/c8" +
           "rFQqD4Cn0gTPRyv7X/mfVEaQGXgaJCuyb/kBNImCQv4Y0vxkBXRrQnHq626Q" +
           "QXGkQEFkHH0rQaRBhgVRe+8dUDcKuwrf9BbzQoZr2blzQL1vO+vcLvALMnBV" +
           "LbqpvJh2iNd/8+bvnD8y9gPpk8pPgW5uHHRzo+jmhmHdOOrm+iQATja0DDPh" +
           "gaNqlXPnyt5+pOh+P5BgGBzg0ADqHniW/zn6vR9+xwVgQWF2EeiwIIXujLjd" +
           "YwjY96gAO6y89onsA7O/VTtfOX8aOguWQdZ9RfVJAXhHwHb9rMvcrt2rH/rm" +
           "X7z60vPBsfOcwuIDn761ZuGT7zir3ChQNBWg3HHz735a/vzN337++vnKReDo" +
           "ANwSGRgjwI2nzvZxyjefO8S5QpZLQGA9iDzZLYoOwem+xIyC7DinHPUHy/eH" +
           "gI5blYPklPUWpY+ERfojeyspBu2MFCWO/gwf/spXf+9baKnuQ8i9emIS47Xk" +
           "uRNuXjR2tXToh45tQIg0DdD9l09M/t7Hv/2hv1EaAKB45+06vF6kXeDeYAiB" +
           "mv/2F9df+8bXX/nK+WOjScA8l65cS8n3Qv4V+J0Dz/eKpxCuyNi76MPdA5x4" +
           "+ggowqLnHzvmDUCGC5yssKDrou8FqqVb8srVCov9f1ffBX/+v3/k2t4mXJBz" +
           "aFI/+f0bOM7/0U7l/b/z8//7qbKZc0oxZR3r75hsj4OPHLfcjiJ5W/CRf+A/" +
           "PPnJL8i/AhAVoFhs7bQSmCqlPirlANZKXVTLFDpThhTJ2+OTjnDa106EFjeV" +
           "F77y52+Z/fm/eL3k9nRscnLcWTl8bm9qRfJ0Dpp/7KzXk3JsArr6a6O/ec19" +
           "7bugRQm0qIAJOR5HAHnyU1ZyQH3p8h/8q3/z6Ht//0LlfL9ynxvIal8uHa5y" +
           "L7B0LTYBaOXhX3/P3pqzKyC5VopauUX4vYE8Xn5dBAw+e2es6RehxbG7Pv5/" +
           "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" +
           "6Qd3SQ4UUJT+4bGk//XNkPTVA0lfffMl");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("/V93KftOkfyPE5JG8l0k/Z8/jKR5Url65iLbnTHp5HEnmPwfv+XS7P6ip/Kb" +
           "L1+98tjL4n8uL3wdXca8d1i5oqeue/J2xYn3ewCg6/sY6979XYuw/PsesO/b" +
           "cJJUzhtWyepflnTFaem1s3TA5ZVDiQ7ILiaV+0+QAac4eDtJdBlMq4CoeL1S" +
           "jvDP5edOHekea/vh76ftoyonL32dvXHApvu7yTeVV1+mR+97Hfv0/tKZ4sq7" +
           "XdHKlWHl8v7+21F09MwdWzts6x7y2e8++Fv3vuswjHtwz/CxsZ7g7e23v9VF" +
           "eGFSHtHv/ulj/+inP/Py18tj2v8Pi+fjOjIuAAA=");
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
      ("H4sIAAAAAAAAALV6e/Dr2FmY7+/u3nv3Znfv3d3sgyW7SXZvaHYNV7ZlWfZs" +
       "oNiWLT8kS5ZsWRItG70tWS/rbYWFEAaSNp00024gTGH/6ISWMkvCdGDamQ7M" +
       "Mi2FlEcHJuU1A4FOWx4hM1kYQttA6ZH8e9/fvclS6hkdH+l855zv/X3n8foX" +
       "K/eHQaXqe/bOsL3otpZFty0buR3tfC28PSEQWgpCTe3bUhguwLeXled+4saX" +
       "v/Lx9c2DyhWx8pjkul4kRabnhowWenaiqUTlxsnXga05YVS5SVhSIkFxZNoQ" +
       "YYbRS0Tlbae6RpVbxBEKEEABAihAJQpQ9wQKdHpIc2OnX/SQ3CjcVr6zcomo" +
       "XPGVAr2o8u6zg/hSIDmHw9AlBWCEa8U7B4gqO2dB5V3HtO9pvoPgT1ShV3/g" +
       "22/+68uVG2LlhumyBToKQCICk4iVBx3NkbUg7KqqpoqVR1xNU1ktMCXbzEu8" +
       "xcqjoWm4UhQH2jGTio+xrwXlnCece1ApaAtiJfKCY/J0U7PVo7f7dVsyAK1P" +
       "nNC6p3BYfAcEXjcBYoEuKdpRl/s2pqtGlXee73FM460pAABdrzpatPaOp7rP" +
       "lcCHyqN72dmSa0BsFJiuAUDv92IwS1R5+q6DFrz2JWUjGdrLUeWp83D0vglA" +
       "PVAyougSVR4/D1aOBKT09DkpnZLPF2fv+9gH3JF7UOKsaopd4H8NdHr2XCdG" +
       "07VAcxVt3/HBF4nvl5746Y8cVCoA+PFzwHuYf/Mdb37rNz77xi/sYb7+AhhK" +
       "tjQleln5lPzwr76j/0LncoHGNd8LzUL4Zygv1Z8+bHkp84HlPXE8YtF4+6jx" +
       "DeY/Ch/8Me0LB5Xr48oVxbNjB+jRI4rn+KatBbjmaoEUaeq48oDmqv2yfVy5" +
       "CuqE6Wr7r5Suh1o0rtxnl5+ueOU7YJEOhihYdBXUTVf3juq+FK3LeuZXKpWr" +
       "4Km8CJ7HKvtf+R9VZtDaczRIUiTXdD2IDryC/hDS3EgGvF1DYezqtpdCYaBA" +
       "XmAcvyteoEGGCY331ouPbxd65f+tj5gVNNxML10C7H3HeeO2gV2MPFvVgpeV" +
       "V+Pe4M1Pv/yLB8fKfkh9VHkGTHP7cJrbxTS3DfP28TSVS5fK0d9eTLcXHGD7" +
       "BhgwcG0PvsD+/cn7P/LcZaAxfnof4FkBCt3dw/ZPTH4/gwL0rvLGJ9Pv5r6r" +
       "dlA5OOsqCxTBp+tFd7pwcMeO7NZ5E7lo3Bsf/sMvf+b7X/FOjOWM7z204Tt7" +
       "Fjb43HlmBp6iqcCrnQz/4rukn3r5p1+5dVC5Dxg2cGaRBJQP+Ilnz89xxhZf" +
       "OvJrBS33A4J1L3Aku2g6ckbXo3XgpSdfSik/XNYfATx+W6GcbwfP04faWv4X" +
       "rY/5Rfn2vVYUQjtHRek3v5n1f/g3f+WP4JLdRy72xqmgxWrRS6fMuhjsRmnA" +
       "j5zowCLQNAD3O5+k/+knvvjhbysVAEA8f9GEt4qyD8wZiBCw+Xt/Yftbn//d" +
       "T33u4ERpIhDXYtk2leyYyOJ75fo9iASzfcMJPsAt2MCQCq25tXQdTzV1U5Jt" +
       "rdDSv7zxnvpP/cnHbu71wAZfjtToG7/6ACffv65X+eAvfvtfPFsOc0kpwtIJ" +
       "z07A9r7usZORu0Eg7Qo8su/+tWd+8OelHwZeE3iq0My10vlcOjScAqnHgQ+9" +
       "wxwpv0SrlCpUgr1YlrcLjpSdK2UbXBTvDE9bx1kDPJVfvKx8/HNfeoj70s+8" +
       "WZJzNkE5rQyk5L+017+ieFcGhn/yvCsYSeEawDXfmP29m/YbXwEjimBEBUTl" +
       "kAqA+8nOqM4h9P1Xf/tn//0T7//Vy5WDYeW67UnqUCqtsPIAUH8tXAPPlfl/" +
       "91v30k+vgeJmSWrlDuL3WvNU+XYNIPjC3R3QsMgvTmz4qf9N2fKH/uv/vIMJ" +
       "peu5IKye6y9Cr//Q0/1v+ULZ/8QHFL2fze50ySAXO+nb+DHnzw+eu/JzB5Wr" +
       "YuWmcpjocZIdF5YlguQmPMr+QDJ4pv1sorKPyi8d+7h3nPc/p6Y9731OQgGo" +
       "F9BF/fo5h/NgweWvP3Q6R87njMO5VCkr3bLLu8vyVlH8nSP7vuoHZgKi+KGB" +
       "/zX4XQLP/ymeYrDiwz7mPto/DPzvOo78PohS10EyTK+9CLDh3hKmA9MBfis5" +
       "THygVx79/OaH/vDH90nNeXGeA9Y+8uo//OvbH3v14FQq+fwd2dzpPvt0suTX" +
       "Q0UxLAzk3feapewx/IPPvPLvfvSVD++xevRsYjQApP74r//VL93+5O999oJ4" +
       "fRkkvXsHX5TNoujt2Yre1Vred1aWT4Hn8UNZPn4XWbJ3kWVRHZQED4FYAapA" +
       "WUsg4hxSi7eIVKFUTxwi9cRdkBK/FqQuKWX7+FAexR8ZFWrvSecZ921/A8Y9" +
       "eYjjk3fBUf1aGdczpQsZp71FpF44ROwIwYuQ2nwtSD2UmEEUSzZhGuuoMLP3" +
       "3N3Myqi2t5rX/sXzv/Jdrz3/+6Xfv2aGwN10A+OChcypPl96/fNf+LWHnvl0" +
       "mTzdJ0vh3vGcXwHeucA7s24rEX/wLDeeuBc3StCyHmZHAfe998x/b9EewGHP" +
       "kaO4czpiv28/2CGbs4vZfFBU31vooOlK9hG7r9iaa+yXIaUKRH52PMXBvt8R" +
       "jvt0ovD2YDXouVqRmRy17TNz07t9vBIHjdkdyAaVF+8uTbJk6kls+vkP/fHT" +
       "i29Zv/8tpOTvPCfs80P+K/L1z+LfoPyTg8rl40h1xzL9bKeXzsan64EWxYG7" +
       "OBOlntnzv+TfnvlF8Z6SxffIlf7BPdo+WhTfB6SlFKzeS+Ye4B87lZHcXTM+" +
       "fi/NKIoP7NWiKL7jWCWCO1WieP3OovjgnTIu3r/nhCFlHvLhe6D+A/do+8Gi" +
       "+ERR/KM9JveA/WdZ5ZwPs7+qD9t750sgN7i/cRu9XSveX7uYSZcPzedKWG5H" +
       "neJWBJJRW7l1lDJwWhACLb1l2eiRddw8sZz9hs45RIdfM6LAgh4+GYzwXOOl" +
       "j/63j//SP37+88DxTSr3J0VmBgzh1IyzuNgu+77XP/HM2179vY+WCx4gJvb+" +
       "N3+ztPofvRe5RfHPz5D6dEEq68WBohFSGJHlGkVTj6k9F/DuA9r7N6c2uvmO" +
       "UTMcd49+BCf2G6mSMY5G7bRGs6a3WXw3oif5QJF6k2a36S2HA2yyGFJCYAmc" +
       "v9tsN7MMSWQHtWSxUa83kGqWS6SPbf0Ja3NTtjvgja05bg/F8dhQt9u1JA4R" +
       "dqANvPZq2uVby82GiAZzrtYTpWrSzmNUo7UW67cGG3iW6yiU05CEopDbcTAU" +
       "mYrRZtVyFMTSSX+jOlkX2dHL0Ha2fItqJHMXz3xOlmJLDyyjoY5ay/q4xTQ4" +
       "eyvX+16uStvFIBGFBstso1hpGdt8na2JsaKNs1XmLLh+jCee0OKwKBV3/lYI" +
       "prPM8NcGI28nS0MWmZytwQ7FRLVJ3Nss5+ONOY8mzW2CWVDI+oNNlvcdWp+0" +
       "6GQGwb2+ncO215i0GhOUZ/tZMlPq2nhS18ROT4hD0qhH0y0p0qQwpQlRpTpK" +
       "lkqriVKLyNqI2iACRcvhrtFf06Qn+7EyxbVEHIlrS+4tDZdtejVK6mcuX3Oq" +
       "rOOx/mw4ygd2ktq1GuYluMAN+VWzPfXxjqNZKC+n63qMRQvg0Y35JA2xJWIu" +
       "vcRxcRtfk2k6z+uw2tNJj2qwXiCyu2zMdVrVKYomthkJI6lmEThuMx1usGTS" +
       "wZrqp7ueIdoxy+bobOUPB/FssxBUF4OnxITbtjboqFZtNJxo4OdNGiBAG8IM" +
       "2di2tQgzvjng2bxteHAwnbQkZjjPg6ooCXVnPlOpRV3zm5yn9NKlzPUwkrWp" +
       "MdVU7cxAuAWM7ygyY+rECCbNbrceeEqz7ljxbE66yrgriQpYWA46g6w6rM3I" +
       "fI4FC6Pbr1ETW1e4aS1aOtxoscAya2DO4bnVXoO5mSk+74kUFU42gimntWQ3" +
       "t+G8qvG6Z6zjuBbpwZIZ9xxuRtY4rMo42BazhpGI2w6pGqNNMPRFbeI0Enfs" +
       "gkRiPkuZsS/UYAiatoWIRnO05U8ZcTkWHYpw1CmfKZTYVyA970Nr3q23ukJH" +
       "EtfbqtU2KNG0m7XmAvKmE7NHivAQ13vrfJShapU2+SBw9ISp2ZhAbTgLr+ld" +
       "1NwOapmylbbkKlRriD2kluEMMJpcQCsCaVIbLPEm3ErdqZipRuuNPsHIGskx" +
       "gUl3DM9iSIMVtwbR2vppA5brU22oN/rs3PSNXUfsq22EGaEDAvRuSztGgPHt" +
       "cghzlm6ORQmrqusUqJPTyBU5SiboyiKdpszaWdr2ltAuxjNtLM5YtGdO27KF" +
       "DxVHhFpWl18KCrKZdAmHZywN7gGvDq0AN4lVTIyTpCEb1eko8xu8IRBdtGHQ" +
       "WmqNMxHZCMSaJrbEyCTNOTuQaTrTVptmGwupRhfrNseNgLE67S0vd5LFck6y" +
       "wianu+LGkgZtYwOpzVhtDREecxU4yPIWE7k0I9hkNt24rNde5ByJTeMIG/Sp" +
       "MKRFe1mf7LCBVu9D2XwBO1Mymq+627m/JjYUSi/xjCZTd0ghie8oPZKRA7uJ" +
       "LJg55yK7zkyeSKiq6CsJqA7tWZuE6uG9fmc9GiB9otHxRFiVbWQFC3q1iqW5" +
       "HJIy3B7VvJWMLL3mUtC0kIYwZG3znNlaY802FG4j3hnVVs1+1Q2H7W4jCDAp" +
       "XRheuzoUItYerRkKr0uUlFjjiB9geT3AfUwxu8Fs1qHU/gpbmHpIUDquYSbX" +
       "aTcc22zslhiukaE/XnWrRjTKF5GmaQjtZryjBrO+uauqVk5oSI003WmmCoOW" +
       "PEQlmSClLppwMgPJsQ7rMLfG8zmBh/B42mnQAtb1BgSIJroGEVOu02k32z1i" +
       "yUIUJQEceuOts5kwLJO6GLdarmcc1dHmvclsZqANetnB0dV4gXLRYLvAQ2rW" +
       "4UdEOyA1PdZwbr0Z4d6uKfCLlsnqabbpiPMWglQ9j47by9pgvsy3KyW3anm/" +
       "nWUJEq1WjKTOrXBaJ3Z5K1/TNczotbpDVYaVzYDfSEoiIP18TgtEDZ8LHDWe" +
       "yFkrMLvoEl243mA5ILMRnYeqE2uwPlIGs1Y/nmT+UubhbaIpEWplTb5lMMHU" +
       "bafytOe4zRSSB80opRlV0BlpUa2FtUk9Vylrx8Wwx+SYhZM7b94frrF63HXG" +
       "XLeFWUuyGlU7Kj2iAqXD1yhTqjmYGGHLlek3xuJm2FSgkBj3ohT4jUwl0A3E" +
       "z6Ouz7GCu5vMac9QeFtfxHMSddMsbOoqVq+lC3ghN410Ri2VfjqHhkkXWFQX" +
       "4DpLkA4EAYuoKkoVlpHWMubrQ1E2iLYCowjaXyUUAuu7dhbP+y3S5UbmqB3q" +
       "Cdao6jU+YeEmrTA9NEL6ktLs12mxmaNNqAO3aj4ku0tuDDO2x/kZoc2DZRuN" +
       "yWxLI2GU73DJclN6aE128tQOmqbXb888pB42rBHI77x5delQEDVnkoVm9Xtz" +
       "dBBzXd4glPFAhIkeGYElRWOSM5vYiVjRNrbuhJH6m7aw3cAE2+1rg42U9+Y6" +
       "Z8Ahr8x8n274XavOZCCDYRY9v9kJN7BYy5NdL9vgPsIAjZqrnbYExRpvo0p7" +
       "nE7hEUHkE05t8MJuKFc7/Sq3DKp9PjXbdA3W7aE5mmA2N4qhZYeMgGuv46TI" +
       "NXN8Mx9lfBUJUdmCGsZwboxG6VoIRBeGVnqGo8KkPly6xm5lMwtXXyMIBdIl" +
       "gSBFn4skmeF7oS5FKRpVVaoaw9x023H6KpX2KC3u8xDsOWocJa7pL/Ro5eWx" +
       "G4961XS+bpLVjbBVSZdfwUhbgJPZKrR0ozWvBq2IRyLbmK7NjcoL1RZPrdQq" +
       "kXYjlcEYGGNXc7s66Dl8I4WsWr3PxPhwKA3Dcc9qtauY3FwyPtPk53aT70mq" +
       "QdqK2JysUAHHu9UG1eqL3GycJ8xkB1BbOJqdG/5Osnk7IEEkt+eDzlJwZRpz" +
       "TRStcl6rKURdlq/OdNwVu6jbAcFDsVa2MszmPjeUkgHBNFJmy9mjRa++caex" +
       "gjN1kW26SIfjECkf5Es3X+PBmmKnazEgFCxCvKE2nHGYuCPrsFal1zSKJVB1" +
       "iikRxXdJmMWTBLi0eFWHKbJPj0azmtSLXZWrdWF8xaUC4tYXC3XXQdE48EW5" +
       "zQ2XTkfazLZd34iUXWI0YTdpTqIk6fTbrUnXazUUY2XFMg2b6tL15UFgDAaL" +
       "bV0gZrLmrugg7XAwWNW66xnKpDuBj7yqhQvmgGI2lleFuEWTZoKBnCINs2XP" +
       "F12ngc/tyNI2glZva2lVkH172WF2mj6d4pGwoLeZHsJzXJQx1Johhr2aregR" +
       "3l83V6zH1nfTSXcMMiWHNAPWbum6Sid6x5RXPLlj6orSytFek1lARCpAQStV" +
       "Js6QcQMrziES5sWFqq6nbo1craddn9bUKm7UqhFVXyFTsBbJVizCjabi0Fls" +
       "+1VJ73lJlkyXI7Ld3LV4eE2vOmiQjanAHYMo1OJAVDPJtJF5274lctlyLFfR" +
       "iCJwg0cXHJLxVqSj23AZzCx9IpCcI+fDebBrzzh6h46QSGZNkoY6kINrfksm" +
       "EJmRlhYnNjsmWVvLXWTMSsGcTha60xLDMNg67JpIJ2KdY2Rj6dY9NnbQPJX4" +
       "RBySbXGCsF0LCnqGXsNAkjIYpjwne/lQ50VDSxoLScPRPCAYDSUoMRcwmiSt" +
       "ZQ3EYlWwdKa3VLsNe5qMqnIArFxZifw85A1xKRg1ZDJiN0TQWOJtmLWnnpWF" +
       "3XW32MqgCNYHlOCsGuGKzEtLiZXWcW+F7gyFkb22WTUQx8SboruIhQ0vu3DI" +
       "EE6n6tqrtY2NPZJgVvhUQeqWnUxIWOrzq5YhRwS28rqeMg/VZsCxOSI1Mg0Z" +
       "rdGAHi84fl1nFXqOz3hCzhI66kOdUS0NhGApJyFF6YJIwwHLrQZ0o70aiZuO" +
       "0Z62xKrf9DioScxW9b41X6TUPB6YQn2UaraAdBxb8Oc9Oa6by+aUnyaTCcwn" +
       "447FT7x4u6pKcJDv0MlWiar2bDCcLmKlnvNQ2IG4YCHENicNFxs0HWzGmou1" +
       "sMZ0SOoKQ8y2A2LZ2fEqna99TJ31FAqn3WpmLdZ+R+xltCoR7qQJqE1r8zmj" +
       "7exe4gZccziZtjv99UBPe0N9MJKU3SwbDpO2PQX5W9NZWasatkG0BFc0Pu1M" +
       "OYzLahC6QxBWijyVUil3umR2mwzh62k498WVSzbULSx3TK/jjBCnDnf5cGY6" +
       "6bA9IHRyxGF5QjJDncY6daMRwEOznfFYPU9bxAyV7Go3dL3A5LC0DlS235r2" +
       "HUElQ4tjtITFjU1dCYAfj3F460X0QofrM54cMCu2HQeDFAq8PNJXfLobN2ki" +
       "E5OoIfYJZzxU+Fl9J7LVDbtZcHFXobPY2lCTgGkMRhmczzIOb9dibeND86kH" +
       "MUO2Sw76KL3CR5vOWqW7goQxOIwTeQ1TbUufDcYk3LTCtTyh5uuONKr2IlrG" +
       "erMOUL50zcqboRTiJgilPRVVoDZmUxEycxWj2+1+c7FN8JNvbfvikXKn5vge" +
       "jmWjRcOn3sIORXZqg+9407f8Xamcu7txatP31OHg8SHr192x54uPB65hulpx" +
       "fvPM3S7glGc3n/rQq6+p1I/UDw43v2ZR5YHI87/J1hLNPjXZ5f123DGiJbLP" +
       "HT5H9QuO7S9karlR/97som3Nc+fHd17nYNeSarpGcZdLK0f47D228n65KP4D" +
       "kJahRbjtyZIN0mOz2I09muDJ0xOYjmRoxeH54R2uUoY/99V2mU5Peo5LpfSK" +
       "o5XWIZda/1+49MSdXFI0d8+e37oHe36nKD4XFZeJzOiiXbersufZmuSecOO/" +
       "/D9wo9SZZ8FDHXKD+tvhxqm95P9UFP+5hPrjexD+J0Xx36PKQ0AvxkFwqBNl" +
       "3xNS/8dbITUDdnN8zFLcmXjqjtuJ+xt1yqdfu3HtydeWv7E/LDq69fYAUbmm" +
       "x7Z9+gT7VP2KH2i6WeL+wP482y///iyqPHbBiU9UOTDMEsc/3cN9OarcPA8H" +
       "5F78nQb7X1HlbafAgAIc1k4D/WVUuQyAiupf+RfsTO9P8LNLp7zHoSqUbH30" +
       "q7H1uMvpGzjFIU95LfToQCbeXwx9WfnMa5PZB95s/cj+BpBiS3lejHKNqFzd" +
       "X0Y6PtR5911HOxrryuiFrzz8Ew+858gbPrxH+EQtT+H2zouv2wwcPyovyOT/" +
       "9smffN+/fO13y43y/wvGXsDzrysAAA==");
}
