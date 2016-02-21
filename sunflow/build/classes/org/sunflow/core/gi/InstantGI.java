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
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
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
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1447328137000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "A3d26qLmySPdP5Kr+gnwfXSv+4+efwl8/mwW5rMzmrvcMv7SXeo+mScfA1bh" +
           "xk7PMXaPmDYnrCuLoEvG/nFTYXUvfb+zuZNDFAUfPZL2el5YB99Le2lfemOk" +
           "vXAX23TEaHVQ3AMYrt7xkqKDX72LSj6bJ68UjqL6YqCep5LLG89QjnXyqder" +
           "Ew58n9jr5BNvjE4u7y9X9zp58jZ/ZVdirpL8/Zh6SPX4bZrj1PyKt3ZI8NhJ" +
           "AsMRdTW/ZveK+9PfLvj4p3dR7b/Mk89F0D1hjhL5j1ePlfiPXq8Sczd6Za/E" +
           "V954N/rSXep+L08+H+UPmIzojFxfeB1yPZYXvgt8n97L9ek3Xq6v3KXuD/Lk" +
           "30fQI6INJrxraFocqrkzyapynl9clTzPVkX3WPovv17pfwJ8v76X/tffeOn/" +
           "+C5138yTP4qgRwvpp6q2fw+yV0Be+5+OJf0vb4Skr+4lffWNl/R/3qXuO3ny" +
           "309IGoh3kfR//DCSJhF0/cxjtDtj0skr");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("S7D4P37bY9jdA075N16+fu2xl+f/sXi0dfTI8l4auqbFtn3yhcSJ/BUA6Nou" +
           "xrp3917CL/59D9j3OZxE0EXdKFj9i4Iuv/G8cZYOuLx8KNGe7HIE3X+CDDjF" +
           "PneS6CpYVgFRnr1WzPBPJxdOXcsea/vh76ftoyYnH26dfTUwjHdvjm/Jr748" +
           "GL3328indg/HZFvMsryXazR0dfeG7Sg6euaOvR32dYV49rsP/ua97zgM4x7c" +
           "MXxsrCd4e+v5L7N6jh8V1+zZP3nsH/7kp1/+WnHV+v8AyRKA4QouAAA=");
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
      ("H4sIAAAAAAAAALV6efDk2FlYz292Z2bHuzuzu96Dxbu2d8fg3SajPqRuda0h" +
       "dKsvqdUtqdWtlkTCWndLrftoqWUWjFPBBlPGBWswBewflEmAWmwqBZVUpYCl" +
       "CAGHq6AMCakCO6kcBOMqO6k4hyHkSf275zdjLwldpddPet/33ne/7x2vf6Fy" +
       "fxRWqr5n7wzbi29rWXzbspHb8c7XotsEidBSGGkqZktRtADfXlae+/kbX/7K" +
       "R9c3DypXxMpjkut6sRSbnhvNtcizt5pKVm6cfB3YmhPFlZukJW0lKIlNGyLN" +
       "KH6JrLzlFGpcuUUekQABEiBAAlSSAHVPoADSQ5qbOFiBIblxFFS+s3KJrFzx" +
       "lYK8uPLOs534Uig5h93QJQegh2vFOweYKpGzsPKOY973PN/B8Meq0Ks/8u03" +
       "/8nlyg2xcsN02YIcBRARg0HEyoOO5shaGHVVVVPFyiOupqmsFpqSbeYl3WLl" +
       "0cg0XClOQu1YSMXHxNfCcswTyT2oFLyFiRJ74TF7uqnZ6tHb/botGYDXJ054" +
       "3XM4LL4DBq+bgLBQlxTtCOW+jemqceXt5zGOebw1AQAA9aqjxWvveKj7XAl8" +
       "qDy6150tuQbExqHpGgD0fi8Bo8SVp+/aaSFrX1I2kqG9HFeeOg9H75sA1AOl" +
       "IAqUuPL4ebCyJ6Clp89p6ZR+vjB7z0fe547dg5JmVVPsgv5rAOnZc0hzTddC" +
       "zVW0PeKDL5I/LD3xSx86qFQA8OPngPcw//Q7vvSt3/TsG7+5h/n6C2Ao2dKU" +
       "+GXlE/LDv/827IXO5YKMa74XmYXyz3Bemj992PJS5gPPe+K4x6Lx9lHjG/N/" +
       "Kbz/Z7XPH1Su45UrimcnDrCjRxTP8U1bC0eaq4VSrKl45QHNVbGyHa9cBXXS" +
       "dLX9V0rXIy3GK/fZ5acrXvkORKSDLgoRXQV109W9o7ovxeuynvmVSuUqeCov" +
       "guexyv5X/scVHlp7jgZJiuSargfRoVfwXyjUVSUo1iJQV0Gr70FR4uq2l0JR" +
       "qEBeaBy/K16oQYYJ4Xs/HuG3Cwvz/xb7zgq+bqaXLgGRv+28w9vAV8aerWrh" +
       "y8qrSW/wpU++/FsHxw5wKJG48gwY5vbhMLeLYW4b5u3jYSqXLpW9v7UYbq9M" +
       "oIoNcGoQ7h58gf37xHs/9NxlYEV+eh+QYwEK3T3qYidhYD+CAmyx8sbH0+/m" +
       "vqt2UDk4Gz4LEsGn6wU6XQS94+B267zbXNTvjQ/+2Zc/9cOveCcOdCYeH/r1" +
       "nZiFXz53Xpihp2gqiHQn3b/4DukXX/6lV24dVO4Dzg4CXCwBgwSx49nzY5zx" +
       "z5eOYl3By/2AYd0LHckumo4C1PV4HXrpyZdSyw+X9UeAjN9SGOxbwfP0oQWX" +
       "/0XrY35RvnVvFYXSznFRxtJvZv2f+De/+1+apbiPwu6NUxMZq8UvnXL1orMb" +
       "pVM/cmIDi1DTANyffJz+oY994YPfVhoAgHj+ogFvFSUGXByoEIj5H/5m8Mef" +
       "/dNPfObgxGhiMNclsm0q2TGTxffK9XswCUb7hhN6QKiwgUsVVnNr6Tqeauqm" +
       "JNtaYaV/eeNd9V/8i4/c3NuBDb4cmdE3ffUOTr5/Xa/y/t/69v/xbNnNJaWY" +
       "qk5kdgK2j3+PnfTcDUNpV9CRffcfPPOjvyH9BIikIHpFZq6VAenSoeMURD0O" +
       "4uod7kj5JVmlVqES7MWyvF1IpESulG3Nonh7dNo7zjrgqZzjZeWjn/niQ9wX" +
       "f/lLJTtnk5bTxjCV/Jf29lcU78hA90+eDwVjKVoDOPiN2d+7ab/xFdCjCHpU" +
       "wEwdUSEIP9kZ0zmEvv/qv/3VX3vivb9/uXIwrFy3PUkdSqUXVh4A5q9FaxC5" +
       "Mv/vfute++k1UNwsWa3cwfzeap4q364BAl+4ewAaFjnHiQ8/9b8pW/7Av/+f" +
       "dwihDD0XTLXn8EXo9R9/GvuWz5f4JzGgwH42uzMkg/zsBLfxs85/P3juyq8f" +
       "VK6KlZvKYfLHSXZSeJYIEp7oKCMECeKZ9rPJy36mfuk4xr3tfPw5Nez56HMy" +
       "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" +
       "BRIX2XrTk8UppkGDVjNTJ8Gu116MF/XtrKd6al3e9gkUrK8m8yaMcHqE2uRC" +
       "ZnEWi9sSx0fwMu/nEaZGrK+o2mRCD4iVCBanatNtgzCBwiG8lcjd0I+ZFd9a" +
       "rkAK0tw2SVKwItYcEOKGSEBkNYeJhTX10EE2O9ngqRq59PEWyktVXhwR0yVf" +
       "nRJBbo1kDK5mUlxbuP6EzGYTfofWGMpIpZynrHhaW6dBuB25rTnMcXFtKzBm" +
       "3HfxmjPzA0eDox3wgcTx19mGFXo8jQ77WRLIsKKDFf03F0v9X3hzWxCPlLst" +
       "x/drLLtdNHziTewyZKc26Y43bsvflcq5OxmnNm5PHfAdH5R+3R37tiMQ5AzT" +
       "1YozmGfudrGmPH/5xAdefU2lfqp+cLiBNYsrD8Se/3dsbavZpwa7vN9SOya0" +
       "JPa5w+eofsHR+4VCLTfb351dtDV57gz4zisZ7FpSTdco7mhpZQ+fvsd23O8U" +
       "xb8A2jK0eGR7smTPAXaxo3o0wJOnBzAdydCKA/DDu1mlDn/9q+0UnR70nJRK" +
       "7RXHI61DKbX+VqT0xJ1SUjR3L54/vod4/qQoPhMXl4TM+KKds6uy59ma5J5I" +
       "4w//H6RR2syz4KEOpUH9/5HGqf3gf1UUv1dC/fk9GP+LoviPceUhYBd4GB7a" +
       "RIl7wup/ejOsZsBvjo9KinsPT91x63B/U0755Gs3rj352vJf7w98jm6zPUBW" +
       "rumJbZ8+hT5Vv+KHmm6WtD+wP5P2y7//Flceu+DUJq4cGGZJ43/dw305rtw8" +
       "Dwf0XvydBvtfceUtp8CAARzWTgP9ZVy5DICK6l/5F+wu70/hs0unosehKZRi" +
       "ffSrifUY5fQtmuKgprzueXSokuwvfL6sfOo1Yva+L7V+an+LR7GlPC96uUZW" +
       "ru4vFB0fzLzzrr0d9XVl/MJXHv75B951FA0f3hN8YpanaHv7xVdmBo4fl5dc" +
       "8n/25C+85x+/9qflZvf/BXGjM/+HKwAA");
}
