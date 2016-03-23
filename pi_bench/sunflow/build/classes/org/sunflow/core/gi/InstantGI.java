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
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "nP7+A7/7vt965dv57cb/AOLKrQzpHgAA");
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
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAK16e8zsxnUf70O6Vw/rXkmxpKiWLNnXSWQmH/fFfeCmqblc" +
           "krtckstd7nJ32SbXfO5y+Vy+lktHqW0gsdEgtuDKql04+kuG87CjoKjbIEUa" +
           "pUVru3ECpDVaO2jtIC0QO6nbGIXTom6cDrn7Pe93r21IC3B2OHNm5pwz5/zm" +
           "DGc+/U3onjCAYN+ztwvbiw70NDpY2ehBtPX18IBmUF4OQl3DbTkMx6Dslvq2" +
           "37z2V995YXn9InSvBD0qu64XyZHpueFIDz070TUGunZcSti6E0bQdWYlJzIS" +
           "R6aNMGYY3WSgB040jaAbzCELCGABASwgBQsIdkwFGr1Jd2MHz1vIbhSuoZ+D" +
           "LjDQvb6asxdBz57uxJcD2dl3wxcSgB6u5u8iEKponAbQM0ey72S+TeCPwsiL" +
           "/+hnrv+TS9A1CbpmukLOjgqYiMAgEvSgozuKHoSYpumaBD3s6rom6IEp22ZW" +
           "8C1Bj4TmwpWjONCPlJQXxr4eFGMea+5BNZctiNXIC47EM0zd1g7f7jFseQFk" +
           "fexY1p2EZF4OBLzfBIwFhqzqh00uW6arRdBbz7Y4kvFGHxCAplccPVp6R0Nd" +
           "dmVQAD2ymztbdheIEAWmuwCk93gxGCWCnrxjp7mufVm15IV+K4KeOEvH76oA" +
           "1X2FIvImEfTms2RFT2CWnjwzSyfm55vcT37oPW7XvVjwrOmqnfN/FTR6+kyj" +
           "kW7oge6q+q7hg+9kXpIf+50PXoQgQPzmM8Q7mn/+s996148//drndzR/6xya" +
           "gbLS1eiW+ory0B+9BX+udSln46rvhWY++ackL8yf39fcTH3geY8d9ZhXHhxW" +
           "vjb6t/P3/pr+Fxeh+3vQvapnxw6wo4dVz/FNWw8o3dUDOdK1HnSf7mp4Ud+D" +
           "roA8Y7r6rnRgGKEe9aDLdlF0r1e8AxUZoItcRVdA3nQN7zDvy9GyyKc+BEEP" +
           "ggdqgufD0O5X/EdQD1l6jo74JsIHXi56iOhupAC1LpEwdg3b2yBhoCJesDh6" +
           "V71ARxYm0ts5LtU7yE3KfyM7S3POr28uXABKfctZl7aBN3Q9W9ODW+qLcZv4" +
           "1m/c+v2LRya+lzmCfgIMc7Af5iAf5mBhHhwNc4P3gGsx5mIZCcA9dejChWK0" +
           "H8qH300fUL4F3BgA3IPPCT9Nv/uDb7sE7MbfXAaay0mRO+Msfuz4uxFVYH3Q" +
           "ax/bvE/8+6WL0MXTgJmzDIruz5vzOcwdwdmNs45yXr/XPvD1v3r1pee9Y5c5" +
           "hcB7T769Ze6Jbzur3MBTdQ1g23H373xG/uyt33n+xkXoMnBvAGmRDEwQoMXT" +
           "Z8c45ZE3D9Etl+UeILDhBY5s51WHkHR/tAy8zXFJMesPFfmHgY5b0D45ZbN5" +
           "7aN+nv7QzkrySTsjRYGef1vwf/nLf/iNaqHuQ6C9dmLpEvTo5gnnzju7Vrjx" +
           "w8c2MA50HdD9l4/x//Cj3/zA3y0MAFC8/bwBb+QpDpwaTCFQ889/fv2Vr331" +
           "lS9dPDaaCKxusWKbaroT8m/A7wJ4vps/uXB5wc4xH8H36PDMETz4+cg/cswb" +
           "AAobOFluQTcmruNppmHKiq3nFvv/rr2j/Nn//qHrO5uwQcmhSf349+7guPyH" +
           "29B7f/9n/vfTRTcX1HyhOtbfMdkO/R497hkLAnmb85G+798/9fHPyb8McBRg" +
           "V2hmegFHUKEPqJjAUqELuEiRM3WVPHlreNIRTvvaiYDilvrCl/7yTeJf/stv" +
           "FdyejkhOzjsr+zd3ppYnz6Sg+8fPen1XDpeArvYa9/eu2699B/QogR5VsAyH" +
           "gwAgT3rKSvbU91z549/714+9+48uQRdJ6H7bkzVSLhwOug9Yuh4uAWil/t95" +
           "186aN1dBcr0QFbpN+J2BPFG8XQYMPndnrCHzgOLYXZ/4vwNbef+f/p/blFCg" +
           "zDnr6Jn2EvLpTzyJ/9RfFO2P3T1v/XR6OxqD4Ou4beXXnG9ffNu9/+YidEWC" +
           "rqv7yE6U7Th3IglEM+FhuAeiv1P1pyOT3TJ88wjO3nIWak4MexZojlcBkM+p" +
           "8/z9Z7Al1z1Eg+eFPba8cBZbLkBF5l1Fk2eL9Eae/OgJ83wugt6UmEEUy3ax" +
           "koRgpt5555kSYiWMTsQ6v2S+/Af/7tvX3rcLR05PcRHu7puebfeVL1+qPBDd" +
           "+HCBbJcVOSxEvAr0EOaUEfTMnUPnoq+d+T9wDELQ+SD0w8dOc+TRB0V47vs7" +
           "C31zdK7b51V9oIxnv4cybqk955bw2a98oF6Y27XEBFisa+N9VH8ab47X45un" +
           "Iv1z1XVL/fqrv/T5Z/9cfLQI4XaaydmqAazK/xt7P7xQ+OHF/Zr+jjswvOeo" +
           "gMdb6s9+4rt/8I3nv/qFS9C9YBXLTVQOQPgG4sODO+18TnZwYwxyHdAKmO5D" +
           "u9YgDi8meD+RjxyVHi3IIKC5U9/5xu7sup3vHUDgowdtL3a1wntPu8b9se+f" +
           "rC1M4sHXZxI/B5aX70OBR/LvfQ96pHCAhwpDyv3/gAAbw5OVIJx7FGcwQbg1" +
           "nvPELREb9bA2QxRm5oPKC8ShNV4/7mQHIkd2+mPfbzx4CnyhfZCRp9U8wXa1" +
           "9TvC+M0CGdILYLW/p3LQOCjl79r5MHIpz/4YCAvCYhsKWhimK9uH4PL4ylZv" +
           "HAYCItiWAhy/sbIb5wi728ud4fW575vX8JT6GQ9sC3/xv73wxQ+//WvAMWno" +
           "niTHaDBHJ0bk4nyn/Auf/uhTD7z4J79YRDnAh4R3/bz33rxX724S50mxOzEP" +
           "RX0yF1Xw4kDVGTmM2CIY0bVC2rsuf3xgOiB+S/bbQOT5R75mfeLrn9lh6tm1" +
           "7gyx/sEX/8HfHHzoxYsnNtZvv21ve7LNbnNdMP2mvYZPotw5oxQtyD979fl/" +
           "8SvPf2DH1SOnt4m5sX/mP/71Fw8+9idfOGcfc9n2XsfERte/1K2FPezwx4iS" +
           "MWtPyqMpEiOWhWuWRRA4geHdedvtzpTKFC+bQwKfoguhQjsdTrFRvaplApdU" +
           "qzGsZZo06W+2pRITLXpmr2L6SNQlsZFOl4QVXJraaxe3Z3LJWJPdyjKQmkIi" +
           "riWx0qLXWcNNGkqdR1SctXy72kQUXYXrLbSVZkYMsojUEliPdcej0XI4k3Sv" +
           "JG+EOjkajjWPIQfTMc7ysZnviUWch2uNZNVPZ6jAW+31ciOsRumQja2tqYab" +
           "eY9h7XSK4z2bXtHyJEV7K6/c79RNFrPEkbVYSczI1UaWII3mq3S9EjgsqVOk" +
           "wGS4I9RYfxTEET4ype5c1pb8cjCMq3pNmW/WI1JUlDLHh1y7Glvzobq2Eklp" +
           "C2S55o4xc0nSrGVxy+20HclSRQ1kdwt7QhiabS6EsTos0ExbSHASnnoe74w2" +
           "uOpGG0RURyJLjEakJG6a82xSFrsOkYY9a85rle145M+IVtwzxeUkLi2k9dB2" +
           "SavU7sXUnKPYqDMXG93aVhQZeuxPmU3Wy+xpaCqeOdJ1lOYIYmZF8xKhoK7T" +
           "p4SpQmeS364otiRPmp5K6M3moDHOgjhZGzaNYwvW6uFOK26XRlxILqwhOewT" +
           "pcEkKnurpugpvc6kX+3ME1GYtUlXntPl0mJL2GSPsmv8IpPD7sAmpHKylqN+" +
           "tuxaRJk3J5kYwgwZT0gpaQZm6GPYVDak0PcEJuRggmn3F17VV4fdMHN6fhew" +
           "RuFclrRTiRLjGFvQi2CyFLj1yLG3vtgeLBYdWaa3vb6A81O8Llh0Dy+PN8N2" +
           "eeTMp257VA6GrhnS+GKijHqdcpXoYv21IG5GW5bueajOZhvB5TguE7xGBs86" +
           "tuWUqn02FHmk23YdbmJ3u0hZ7UxQipTHOjfxYaxLOzy3SbB4rgWrKbIlsC61" +
           "WrZMCzYcjq6j83J3vLEIO5OWdVmc88GaNc1atFw0ZoNsYIczG8Yq/dVMtPjO" +
           "ZibRGVOL5r1K2e+M2s7UlaguljrtBRwb8Vp2UthqIBEtjlWfLE9QezhsrJeG" +
           "6OMKLTKw0LeHM6pXLlsle2LOZtvmFBUwvbUUZNJp1P1atY+HDjruJ/1IRZVW" +
           "ezSj5pgtTto6LBC2mjXQAFsmy8bUHBBltt1hvJnLOQzcNGBW6+lUGR9ystjz" +
           "vHXoxUsCD9sWEQ3r5IoeCnZrNrL6FNMTRV7qwszaQju4YFu1Jd4IV3GPXost" +
           "WxrYICgZj9wSPBl4YVBKmBpWZcSxTbVks8aCPrQpjbTa7njGdQhGsqTBUJ/i" +
           "YsC0u5Q0J3p9ydd8U14tpg7hs+qovhmX/Kbh1mSbS3WDrw15t1NjZczLplGi" +
           "teRwJjHqxp2vxpKM+36n5EgzfuCUjHGpUyLJNKG626XrdjM3EcaloOMTxHA6" +
           "WQ/Z8bZU31hY1+3Om2FFHs4XJS7u8NoQg0emr5FTi23258MmGWdi31uJrAaP" +
           "1vO6FJpEryo0JwPgJ10DQQcdzWsYJQOJVB6hGuyoPmMwrjZM5r2ey04XYtxM" +
           "/HJSDTtODYXZRmvtVexGjC/X0pQ2Oua4V9LhanuN1r24i8cq3qnD7HwaJBK9" +
           "YGkW6zfbCyrZBjGBW8qc7QGDtYX2ZsZNxwsv7VCj8iwUSK2riI24353OW5xX" +
           "MbeyRemdLhsm9dYs1uEJ3yg3ME5y2sgcW80STSjHMkb523Ax5/rJtDIyxmt7" +
           "yBtUVSIajSTdNFM/XllYyrdgnNGWFSwcY/U5RiVV3oPXXNJdRo3NFFZYnBUd" +
           "E21jFj+e0abvNgdGB23wTYJsbrDamE69OqPgslOaBB1Jhbetmlqj5yzvIdPS" +
           "rF/G3LmXCgDn+oo35Jsc01klG8xQ6mGW2WvCnW/rzHhVaVdnLardcFFHD2FF" +
           "Z8YwIbBOY44r49541TfmbMMI4gB4A0rBqOFKrWwTVTF907Hba6EdeqOSgZMT" +
           "poaLDUKbEbGyRUorsoJnQ6Yj66OYrzIWVyZTeBMaY72B1HvW2GCMuM3aaLNT" +
           "wcuOLFszqx9yS3O+msQRq4zk0bpSag02S9jWfdKLKYLdVOaTrlhGFTptNnE1" +
           "HGyYnuljDaq/rILFqrKl53E9GDBiNdugil7OaFVAVuSYXi/bCu3ifA/lsXLf" +
           "StsErpQDNF0qDl+a+F49WMBCr06pq2BDDhQLzEvss0rNnGa11BAMJnIyODWB" +
           "ZVbUWnMTpiy6HQoZn05LiYG0ebuxraGIpHmVeUnZlgD3dZgyWhI9bMVwGCNq" +
           "WCcX5bU+ZvkOn3ZkDUbYLEwMFNlUYrNdFTKvOluQeKWRuTy6ala4loqsQmQ9" +
           "Wiw0uS/CyJxRF54GNL7lhcGYIDi40faraAV1vKg/HaktaeaMMmaQkNw4GmxW" +
           "kVBDImu1qZqCxIpNaltVunijvJFaSwYOa3jqNpW56JTEgd5cDkTRtvrW3FmV" +
           "FvW2peoWViU4PrHYeafsAyNOl1E3WC/1aRlpeUilVe4ImL/aqJ2YjlZZqc7y" +
           "eHkQEZYSop0GYXktuO6TZIvhE3FmwRTLYxtnpvN6iVNgu6W2tijVIkwOnZVk" +
           "e7VacITWHLG6H27wGYoZKktt8W29PbPsEVk3J6gTZ1mnD28NsVlfTzx11dIV" +
           "nUylSgdMr+i4VUtrIV1mYbslJMXD1GwZPc2QZxZCBVN1Gc2GprVeyEY07y6o" +
           "iUMPJg1crlUHEkGaTKZNHVRNF7pAqMt6g+zTcbDom3Ml3ioVO8gyxWAbarOx" +
           "1NJROA6lxri80XierNKTTi9liFkwqHFw4ssyWh/4LBcF7jpjtrI5D7ppQ9Wd" +
           "RNORdKQP6WV/Q5eStt0hEFSTzEGwMgfram2AsnYpm/Lugl31Ap7xe/F6lrWW" +
           "Q40tjeYTgq1yKjxouWkZ1eBButlOrS7Zm7Uxv73Mep26v1x4w0AbTEim29hE" +
           "baGGWeR6TME+acTBtD6WLL3BSRQ+1pe6QvVrajMWUsIVqbVWX/i0Ok/LWHko" +
           "Cjan1tDtYGMDlIFR3OgPmHoHC/gNCHEIKkgiWfGnvY3b7q/lUUaw60Ffqi5b" +
           "UUOXuWbZklHPQJJ1I5EHaluvToclyhBLUqlez+iMWvJUUpohsKlNEpkSSlpN" +
           "02cdqTWuym07jgOhsRHhSKkspbZlpa2Kxa7FXrmueVpzG7UwbzPF9H5lMm11" +
           "BXcdYo4z0dlFucQM176LzN3Q52xdGpTXAlPVemitKfHuppVuauqM6ax7rjPs" +
           "lyubVkcNRlV41JOmPm4i2aA7nMZudcFttZVTVeLVulJHsmycpYFKjit6q8km" +
           "iI5INa6cdFUURA6SEpWMSmD6W49Zd6vNYE6phBKNEx1xRMZzWJMWmAonVUyc" +
           "HRtqbd1JqmowrrTqSkUx0AkX0OVOlBldr7RKbCyrNjp2C7WDVSerw4uMHNoo" +
           "HPQzbew0ZzBm00Ic98qJEUmEv26TWW/kLisTc9BIfdOpTGNjTo3qst12RLqF" +
           "D4NoMnEYsmdUSdRqYGioeFMZL229/tZKe9WmQESETdEjiqHUFt+gp1WuJ9Qm" +
           "Vm8ctQPdL484Diln7a5c4TtOk6l2uw1F8OlsW5mIbARvmy2DX0R+xdGkqLoy" +
           "uCxIYpUfSC0vZccdyvAyhe2j5VUlS1ZUikhxld6OlDa7oiUgtZ5irLFBnUAa" +
           "oUZETgYTRsTH89KUomqDlrPKtti8ZFa2WbCdTcQQp+Mo1iTB5MQVkUMxPZlU" +
           "SHzYztY9Py2vnTVcj2pLuqHyTtrYsj6K4w6pClrZdhcAwLfEyjfxgFT4KecK" +
           "jXJL5bJVfdrRt3KcgKWmG9sMPJH6LLxW3CFfTiYsLi9aSWvqULIlD6wk9O1g" +
           "MZMw0xlsHMsHse+0H6+TPtPgNKTpAeysKca8S+FDlKKwzQhpKLMq0uiOfWpL" +
           "JhnJyBV2XJ7NzbJJp13Ty1qEFHU6FLygdWm00btjr8f4A2Y+dFeVabcbOoFH" +
           "4wExIwxm1qsMknmCrVB3i3cooSLWEmoy1CilpyF2p6vWuxy/8tvTztr0x8Ox" +
           "JcJMuRTbI7Sz2vBTw6/Jg/6aYcEySpYMsu02qExJQHxHikPbjmdiJFHWeFRD" +
           "JGFlwwN/slUsq8K7lE1SvaiXmIhZ22rpQDY665k3XFK2wadiH59xAtvJHHm4" +
           "aa7WDEksMCkeNc3OBOl6QUPbqGsfBj9nqjcqc6TJiRi69PmtwmRSGKSzRW3E" +
           "mGjKa8K8VRaaVR4XFwpiV4bWCvEEYopMAZwL4qTbRutDPBoRsdkhrXKvNRmw" +
           "nlQmuq2MiETcW9AE3A6GuK9lSZSZK7rF1ur2gA4TM+FW1eqKKflsmtRAjGrw" +
           "et8e62rML+Fmk8VFZqFwMRZO6HTm0M0kDNx60utnkj5fz1poPUzkkTAMtwPJ" +
           "DTY1KVNaGxjrd2pcDZdcO5S9raioo6Y2RRjCEqp2VmIr8VyptTtmBLb3VYey" +
           "ovZkJjhuOw4lz0+5SDYaHbhpzdKkgVBKzaazqLKxMwAOUZYKibraoC19M4ZR" +
           "26LqgsY3VXfm686kTE60kghPFaSCrkLgDgu061TxrGZ3VWnSiWaVrCJR62qv" +
           "NZxvK53qtDQlGnNrzpY7jfksG6texZG2tXqV0+uJhzirdsv32SpCRoiLtGvZ" +
           "dIyGbG+DYfnnjff+YF+YHi4+ph3dkljZjbzC+gG+rKTnD3ghgq74gZnIkZ4e" +
           "HTAU3w4fuMvh5YlvjBcOv+e95bZPlPzSizy3OKHOvzQ9daeLE8VXplfe/+LL" +
           "2uCT5Yv7r5bviaB79/dZjge7cvczCra4NHJ8pPO59//5k+OfWr77Bzi0fusZ" +
           "Js92+avsp79A/Yj6kYvQpaMDntuus5xudPPMt+tAj+LAHZ863HnqSPeP5qp+" +
           "Ejwf2ev+I+cfHJ8/m4X57IzmLieT//gudZ/Ik48Cq3Bjh3DM3dWm5IR1ZRF0" +
           "ydxfeSqs7qXv9T3v5BBFwUeOpL2WF9bA89Je2pfeGGkv3MU2HTlaHhRnB6a7" +
           "aHtp0cGv3kUln8mTVwpH0X050M9TyeXEM7VjnXzy9epEBM/H9zr5+Bujk8v7" +
           "A9m9Tp66zV+FpZyrJL9Vph9SPXGb5kQ9PxauHhI8fpLAdOSFnh/Ne8WZ6+8W" +
           "fPz2XVT7r/LksxF0T5ijRP7y6rES/9nrVWLuRq/slfjKG+9GX7xL3R/myeei" +
           "/FqTGZ2R6/OvQ67H88J3gudTe7k+9cbL9eW71P1xnvyHCHpUtsGEd0zDiEM9" +
           "dyZV187ziyuK59m67B5L/6XXK/1PgOfX99L/+hsv/Z/dpe4befKnEfRYIf1I" +
           "N/Z3SPYKyGv/87Gk//WNkPTVvaSvvvGS");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("/q+71H07T/7HCUkD+S6S/s8fRNI0gq6ducB2Z0w6ecwJFv8nbrsiu7vWqf7G" +
           "y9euPv7y5D8VF72Orl7ex0BXjdi2T96qOJG/FwC6sYux7tvdsfCLv+8C+z6H" +
           "kwi6uDALVv+6oMtPSa+fpQMurx5KtCe7HEEPnCADTrHPnSS6ApZVQJRnrxYz" +
           "/NPphVNHucfafuR7afuoycnLXmdvGrDx7ibyLfXVl2nuPd+qf3J32Uy15SzL" +
           "e7nKQFd2996OoqNn79jbYV/3dp/7zkO/ed87DsO4h3YMHxvrCd7eev5tLsLx" +
           "o+JoPvutx//pT37q5a8Wx7P/HzlN8+ggLgAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "wTTdG57XTLEJadWqITJHdLE39z83TmiObSAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "G5qx05KqYIN8ejxX463tLDymKrU1ZUOB4FtjXSOpptOQ9/22wco7Au2gPtM1" +
       "uji07eoaGKMzmU9gSKdYv41oCWND+rLdsvJqK15uB6OWA2+EiFDrmJealO90" +
       "JvQwdiYIPI5GrEvWuLBnxiBQT6IG1p5IWXeqg9nf3HJpvcm4qjVquj0ur2JT" +
       "Op84Kwcxu3Mi1yViCnmOv8kWqzmPqVSGmyamrsewhqGz2TglRi7CVTEzYbC1" +
       "tp6MO1FO+BbBC/BkxQ1WMznNcLjaaUjqdjLu9dgWEJe4nU8pY7aGTDXfIdvJ" +
       "RCcRdD6h+0NFnwXUZDjQ6X6jnWONiWNyqlhsBLz3vcUWwU+8ua2LR8pdmuOb" +
       "N5aNFg2fehO7E9mpzb3jDd/yd6Vy7rbGqQ3fUweDxwes33DHfi9J9d2V6RrF" +
       "2c0zd7tyU57bfOpDr76mcz9cOzjc+GLjygOx5/9d20gN+9Rgl/dbcceElsQ+" +
       "d/gc1S84sr9QqOUm/buzi7Y0z50d33mVQ1wruumuittbRonhs/fYxvtPRfGz" +
       "QFsrIyZtT1XsMehd7MQeDfDk6QFMR1kZxcH54a2tUoc/97V2mE4Pek5KpfaK" +
       "Y5XWoZRafytSeuJOKWmGuxfPb95DPL9dFJ+Li+tDZnzRjttV1fNsQ3FPpPFf" +
       "/j+kUdrMs+DhDqXB/c1I49Q+8n8siv9cQv3RPRj/46L4H3HlIWAXVBge2kTZ" +
       "94TV//lmWM2A3xwfsRT3JZ664z7i/g6d9unXblx78rXpr+8Pio7uuT1AV64t" +
       "E9s+fXp9qn7FD42lWdL+wP4s2y///ndceeyC0564crAySxr/1x7uK3Hl5nk4" +
       "oPfi7zTYn8eVt5wCAwZwWDsN9Bdx5TIAKqp/6V+wK70/vc8unYoeh6ZQivXR" +
       "ryXW4y6nb98UBzzlRdCjw5hkfxX0Ze0zrw3ZD3y59cP72z+areR5geUaXbm6" +
       "v4h0fKDzzrtiO8J1ZfDCVx/+8QfedRQNH94TfGKWp2h7+8VXbfqOH5eXY/J/" +
       "9+RPvOdfvfY75Sb5/wP41EKPoSsAAA==");
}
