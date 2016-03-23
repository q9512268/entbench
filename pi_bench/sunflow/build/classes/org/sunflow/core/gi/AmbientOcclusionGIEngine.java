package org.sunflow.core.gi;
public class AmbientOcclusionGIEngine implements org.sunflow.core.GIEngine {
    private org.sunflow.image.Color bright;
    private org.sunflow.image.Color dark;
    private int samples;
    private float maxDist;
    public AmbientOcclusionGIEngine(org.sunflow.core.Options options) { super(
                                                                          );
                                                                        bright =
                                                                          options.
                                                                            getColor(
                                                                              "gi.ambocc.bright",
                                                                              org.sunflow.image.Color.
                                                                                WHITE);
                                                                        dark =
                                                                          options.
                                                                            getColor(
                                                                              "gi.ambocc.dark",
                                                                              org.sunflow.image.Color.
                                                                                BLACK);
                                                                        samples =
                                                                          options.
                                                                            getInt(
                                                                              "gi.ambocc.samples",
                                                                              32);
                                                                        maxDist =
                                                                          options.
                                                                            getFloat(
                                                                              "gi.ambocc.maxdist",
                                                                              0);
                                                                        maxDist =
                                                                          maxDist <=
                                                                            0
                                                                            ? java.lang.Float.
                                                                                POSITIVE_INFINITY
                                                                            : maxDist;
    }
    public org.sunflow.image.Color getGlobalRadiance(org.sunflow.core.ShadingState state) {
        return org.sunflow.image.Color.
                 BLACK;
    }
    public boolean init(org.sunflow.core.Scene scene) {
        return true;
    }
    public org.sunflow.image.Color getIrradiance(org.sunflow.core.ShadingState state,
                                                 org.sunflow.image.Color diffuseReflectance) {
        org.sunflow.math.OrthoNormalBasis onb =
          state.
          getBasis(
            );
        org.sunflow.math.Vector3 w =
          new org.sunflow.math.Vector3(
          );
        org.sunflow.image.Color result =
          org.sunflow.image.Color.
          black(
            );
        for (int i =
               0;
             i <
               samples;
             i++) {
            float xi =
              (float)
                state.
                getRandom(
                  i,
                  0,
                  samples);
            float xj =
              (float)
                state.
                getRandom(
                  i,
                  1,
                  samples);
            float phi =
              (float)
                (2 *
                   java.lang.Math.
                     PI *
                   xi);
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
                maxDist);
            result.
              add(
                org.sunflow.image.Color.
                  blend(
                    bright,
                    dark,
                    state.
                      traceShadow(
                        r)));
        }
        return result.
          mul(
            (float)
              java.lang.Math.
                PI /
              samples);
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
      ("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");
}
