package org.sunflow.core.gi;
public class PathTracingGIEngine implements org.sunflow.core.GIEngine {
    private int samples;
    public PathTracingGIEngine(org.sunflow.core.Options options) { super(
                                                                     );
                                                                   samples =
                                                                     options.
                                                                       getInt(
                                                                         "gi.path.samples",
                                                                         16);
    }
    public boolean requiresPhotons() { return false; }
    public boolean init(org.sunflow.core.Scene scene) { samples =
                                                          java.lang.Math.
                                                            max(
                                                              0,
                                                              samples);
                                                        org.sunflow.system.UI.
                                                          printInfo(
                                                            org.sunflow.system.UI.Module.
                                                              LIGHT,
                                                            "Path tracer settings:");
                                                        org.sunflow.system.UI.
                                                          printInfo(
                                                            org.sunflow.system.UI.Module.
                                                              LIGHT,
                                                            "  * Samples: %d",
                                                            samples);
                                                        return true;
    }
    public org.sunflow.image.Color getIrradiance(org.sunflow.core.ShadingState state,
                                                 org.sunflow.image.Color diffuseReflectance) {
        if (samples <=
              0)
            return org.sunflow.image.Color.
                     BLACK;
        org.sunflow.image.Color irr =
          org.sunflow.image.Color.
          black(
            );
        org.sunflow.math.OrthoNormalBasis onb =
          state.
          getBasis(
            );
        org.sunflow.math.Vector3 w =
          new org.sunflow.math.Vector3(
          );
        int n =
          state.
          getDiffuseDepth(
            ) ==
          0
          ? samples
          : 1;
        for (int i =
               0;
             i <
               n;
             i++) {
            float xi =
              (float)
                state.
                getRandom(
                  i,
                  0,
                  n);
            float xj =
              (float)
                state.
                getRandom(
                  i,
                  1,
                  n);
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
            org.sunflow.core.ShadingState temp =
              state.
              traceFinalGather(
                new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  w),
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
                      null)
                    irr.
                      add(
                        temp.
                          getShader(
                            ).
                          getRadiance(
                            temp));
            }
        }
        irr.
          mul(
            (float)
              java.lang.Math.
                PI /
              n);
        return irr;
    }
    public org.sunflow.image.Color getGlobalRadiance(org.sunflow.core.ShadingState state) {
        return org.sunflow.image.Color.
                 BLACK;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "uC6OI82fe3H8uXjF4dJ/AW7Bb27NGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1/I94Dq774tnTwacU1BxQxYoDxft+bx59YF/n/FDYw32+H0H/x74nQLX/+RX" +
       "Tizv2O3Itzf204KHDvMCH+xXZyLR8W1gUVdd3lFoOCBorfdzIviJ279mve8b" +
       "H97lOyfX8gSw8o6nfuF7F9711N6xLPMVlyV6x3F2mWahrFvypp17x8NXm6XA" +
       "aP/Tc0988vefePuOq9svzZla4JXgw3/931+88N6vf/4K2/ZpkA/vonveYnlD" +
       "7XSKv6irvHbH2ymwDNciF/AL5fyZu/JSnc5vfxTE46h4LwAYquGKdiFjOwau" +
       "b0vnDxZoDt4TgK+cN238IHidK9w8t8oLu+T6BK/t/zOvQJO3HhHreyBPf+c/" +
       "vvuLv/yKrwGtMNC169wPgPqOzThM8leXtz379P03PfX1dxbbC7A97toXvlIk" +
       "gm+8msR5w+fN4kDU+3JROS8JJaUvRvGg2BEU+VBa+pg8gxjsK94PIG18a7mL" +
       "RTR58OvPlyqfzjabmepm8CZOEaQ0nXY6FKkm48iPe7TT6lLRoGmb23QlOvo4" +
       "izMZjVF9LdcdOSJKTkzaPapnzSb0sMkxa6xfITlOY3oOLkzG5fE8njmzuOH7" +
       "iMHF4yBAZo49rfQaATdfiH4CD/EYT3ChMrSWgd1V4OF6LTtopBKoG2d1w/OH" +
       "Gspl7bFS7QxqA4yVe0nJ1CPH6I69SjYpp8PtuD63TDhO1F7dnVEzk6EDfTTD" +
       "mY63XfmWb02H4xVDzq0KO186ArJx+rSlqEBqx2yTiVjyNFFoDvGAS7ZMf6Dg" +
       "Y2+MMXKFNKZsFFTpmcy53cWKNHWhRYuyPpiwY39NuPV102/3uXqzs1D7Ync9" +
       "GGUU50xx23MYfKGrC66l24w0txgdUaaxuGSjSnNu93tVbzQwuVFfH/F8slq2" +
       "Y2y1xBg+ghdqN6vzPYZ3OqQzn/PDBrwYqI4QbDWjr1vOkK0nftTjqi66nbdp" +
       "gdGXytLCxTRCNLqtoZTn1ZC+vojWXuAHPNdl4qluBmNuIdFDaUV7PKazTSEo" +
       "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" +
       "J6/9vWe+Whx+/y8C6EDaDyUAAA==");
}
