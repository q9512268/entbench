package org.sunflow.core;
public class Geometry implements org.sunflow.core.RenderObject {
    private org.sunflow.core.Tesselatable tesselatable;
    private org.sunflow.core.PrimitiveList primitives;
    private org.sunflow.core.AccelerationStructure accel;
    private int builtAccel;
    private int builtTess;
    private java.lang.String acceltype;
    public Geometry(org.sunflow.core.Tesselatable tesselatable) { super();
                                                                  this.tesselatable =
                                                                    tesselatable;
                                                                  primitives =
                                                                    null;
                                                                  accel =
                                                                    null;
                                                                  builtAccel =
                                                                    0;
                                                                  builtTess =
                                                                    0;
                                                                  acceltype =
                                                                    null;
    }
    public Geometry(org.sunflow.core.PrimitiveList primitives) { super(
                                                                   );
                                                                 tesselatable =
                                                                   null;
                                                                 this.
                                                                   primitives =
                                                                   primitives;
                                                                 accel =
                                                                   null;
                                                                 builtAccel =
                                                                   0;
                                                                 builtTess =
                                                                   1;
    }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        acceltype =
          pl.
            getString(
              "accel",
              acceltype);
        if (tesselatable !=
              null) {
            primitives =
              null;
            builtTess =
              0;
        }
        accel =
          null;
        builtAccel =
          0;
        if (tesselatable !=
              null)
            return tesselatable.
              update(
                pl,
                api);
        return primitives.
          update(
            pl,
            api);
    }
    int getNumPrimitives() { return primitives == null ? 0
                               : primitives.
                               getNumPrimitives(
                                 ); }
    org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        if (primitives ==
              null) {
            org.sunflow.math.BoundingBox b =
              tesselatable.
              getWorldBounds(
                o2w);
            if (b !=
                  null)
                return b;
            if (builtTess ==
                  0)
                tesselate(
                  );
            if (primitives ==
                  null)
                return null;
        }
        return primitives.
          getWorldBounds(
            o2w);
    }
    void intersect(org.sunflow.core.Ray r, org.sunflow.core.IntersectionState state) {
        if (builtTess ==
              0)
            tesselate(
              );
        if (builtAccel ==
              0)
            build(
              );
        accel.
          intersect(
            r,
            state);
    }
    private synchronized void tesselate() { if (builtTess !=
                                                  0)
                                                return;
                                            if (tesselatable !=
                                                  null &&
                                                  primitives ==
                                                  null) {
                                                org.sunflow.system.UI.
                                                  printInfo(
                                                    org.sunflow.system.UI.Module.
                                                      GEOM,
                                                    "Tesselating geometry ...");
                                                primitives =
                                                  tesselatable.
                                                    tesselate(
                                                      );
                                                if (primitives ==
                                                      null)
                                                    org.sunflow.system.UI.
                                                      printError(
                                                        org.sunflow.system.UI.Module.
                                                          GEOM,
                                                        "Tesselation failed - geometry will be discarded");
                                                else
                                                    org.sunflow.system.UI.
                                                      printDetailed(
                                                        org.sunflow.system.UI.Module.
                                                          GEOM,
                                                        "Tesselation produced %d primitives",
                                                        primitives.
                                                          getNumPrimitives(
                                                            ));
                                            }
                                            builtTess =
                                              1;
    }
    private synchronized void build() { if (builtAccel !=
                                              0)
                                            return;
                                        if (primitives !=
                                              null) {
                                            int n =
                                              primitives.
                                              getNumPrimitives(
                                                );
                                            if (n >=
                                                  1000)
                                                org.sunflow.system.UI.
                                                  printInfo(
                                                    org.sunflow.system.UI.Module.
                                                      GEOM,
                                                    "Building acceleration structure for %d primitives ...",
                                                    n);
                                            accel =
                                              org.sunflow.core.AccelerationStructureFactory.
                                                create(
                                                  acceltype,
                                                  n,
                                                  true);
                                            accel.
                                              build(
                                                primitives);
                                        }
                                        else {
                                            accel =
                                              new org.sunflow.core.accel.NullAccelerator(
                                                );
                                        }
                                        builtAccel =
                                          1;
    }
    void prepareShadingState(org.sunflow.core.ShadingState state) {
        primitives.
          prepareShadingState(
            state);
    }
    org.sunflow.core.PrimitiveList getBakingPrimitives() {
        if (builtTess ==
              0)
            tesselate(
              );
        if (primitives ==
              null)
            return null;
        return primitives.
          getBakingPrimitives(
            );
    }
    org.sunflow.core.PrimitiveList getPrimitiveList() {
        return primitives;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALUabWwcxXXu/O34O7HjfNhJHCetA7kLNIFSQyAxDrn0nJzi" +
       "kIIDOHt7c75N9nY3u3P22ZAWkAIBVEQgfLSC/GkQFAWCUFFbtaBUiAKCVoXS" +
       "Am2BfklAKSpRW2hLW/re7O7tx91u5Apb2vF65r037715n7M+8QGpMXTSSxUW" +
       "Y9MaNWLDCksJukEzQ7JgGLtgbly8t0r46zXvbr8gSmrHSEtOMEZEwaBbJCpn" +
       "jDHSIykGExSRGtspzSBGSqcG1ScFJqnKGOmUjERekyVRYiNqhiLAbkFPknaB" +
       "MV1KFxhNWAQY6UkCJ3HOSXyTf3kwSZpEVZt2wLtd4EOuFYTMO3sZjLQl9wmT" +
       "QrzAJDmelAw2WNTJWZoqT0/IKovRIovtkzdYKtiW3FCmgr7HWz/65I5cG1fB" +
       "fEFRVMbFM3ZSQ5UnaSZJWp3ZYZnmjQPkq6QqSea5gBnpT9qbxmHTOGxqS+tA" +
       "AffNVCnkh1QuDrMp1WoiMsTICi8RTdCFvEUmxXkGCvXMkp0jg7TLS9KaUpaJ" +
       "ePdZ8aP3XtP2RBVpHSOtkjKK7IjABINNxkChNJ+murEpk6GZMdKuwGGPUl0S" +
       "ZGnGOukOQ5pQBFaA47fVgpMFjep8T0dXcI4gm14QmaqXxMtyg7L+qsnKwgTI" +
       "2uXIakq4BedBwEYJGNOzAtidhVK9X1IyjCzzY5Rk7P8yAABqXZ6ynFraqloR" +
       "YIJ0mCYiC8pEfBRMT5kA0BoVDFBnZHEgUdS1Joj7hQk6jhbpg0uZSwDVwBWB" +
       "KIx0+sE4JTilxb5Tcp3PB9svvP1aZasSJRHgOUNFGfmfB0i9PqSdNEt1Cn5g" +
       "IjatSd4jdD11OEoIAHf6gE2Y7153+pKze089b8IsqQCzI72PimxcPJ5ueXnp" +
       "0MAFVchGvaYaEh6+R3LuZSlrZbCoQYTpKlHExZi9eGrnj6+8/hH6fpQ0Jkit" +
       "qMqFPNhRu6jmNUmm+mVUobrAaCZBGqiSGeLrCVIH70lJoebsjmzWoCxBqmU+" +
       "Vavyv0FFWSCBKmqEd0nJqva7JrAcfy9qhJA6eMhaeNqI+cN/M7ItnlPzNC6I" +
       "giIpajylqyi/EYeIkwbd5uJGQcnK6lTc0MW4qk+U/hZVncYvo4DM9OkY2pT2" +
       "mVIrIu/zpyIRUOtSv1PL4A9bVTlD9XHxaGHz8OnHxl80DQaN3JKakUWwRcza" +
       "IoZbxOwtSCTCKS/ArczDAlXvB6eFqNk0MHr1tr2H+6rASrSpatBTFED7PNlj" +
       "yPFsOxyPiyc7mmdWvHXOM1FSnSQdgsgKgozJYJM+AWFG3G95YlMa8ooT3pe7" +
       "wjvmJV0VaQaiS1CYt6jUq5NUx3lGFrgo2MkH3SweHPor8k9O3Td1w+6vrYuS" +
       "qDei45Y1EIwQPYVxuBRv+/2eXIlu683vfnTynoOq49OeFGFntjJMlKHPf/Z+" +
       "9YyLa5YLT44/dbCfq70BYi4TwEcgnPX69/CEjEE7/KIs9SBwVtXzgoxLto4b" +
       "WU5Xp5wZbpTt/H0BmMU89KH58PRaTsV/42qXhuNC04jRznxS8PB+0aj2wOs/" +
       "fe8LXN12Jmh1pfBRygZd0QeJdfA40+6Y7S6dUoB7877UXXd/cPMebrMAsbLS" +
       "hv04DkHUgSMENR96/sAbb791/NVoyc4jDNJvIQ1VTLEkJM6TxhAhYbfVDj8Q" +
       "vWTwebSa/ssVsE8pKwlpmaJj/bt11TlP/vn2NtMOZJixzejsMxNw5hdtJte/" +
       "eM3HvZxMRMTs6ejMATND8nyH8iZdF6aRj+INr/R84znhAQjuEFANaYbyGBkx" +
       "dcAl74YqrSx67KKGQWWBITv8aDdw2HV8XI9q4RQIX7sAh1WG20W8XuiqhcbF" +
       "O179sHn3h0+f5jJ5iym3RYwI2qBphDisLgL5hf4QtlUwcgC3/tT2q9rkU58A" +
       "xTGgKEIFYezQIWQWPfZjQdfU/epHz3TtfbmKRLeQRlkVMlsE7oqkAXyAGjmI" +
       "tkXt4ktME5iqtzNIkZQJXzaBx7Cs8gEP5zXGj2Tmewu/c+FDx97itqhxEj3l" +
       "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" +
       "XJY0SSUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZAFwZ1cB5ATh+x4U4Ysg/fQhwp/+viJ8");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+R515Ty7sVvkzjzW2YP30n09xYlLDx+9osyfhD1z24Pr3SNh5ZffuPrwe9+Y" +
       "/EHxkPD4Ie/lYenh5dq2T79KOfV9Eajb0ihQX969UfELKDWAYl+hgWvN/+Qc" +
       "nqvuyJpx6ZFTZCBgOfw6TdSOS+cBUf7Z8Y/M5dQt6mEAfO5UDFs6tehdfydp" +
       "HTc5/XAwj3uLF+xHMep694b9lvLVNyjmR95u/dzu4aJiS1mW9/LwsHRp94by" +
       "OM794F17O+rrIvHydx/72uWXjmLyx3YMn2jYKd5euPMrQQxsZot3fdk/fu+v" +
       "fvzn3/hmcY38/wCXY8NnWjAAAA==");
}
