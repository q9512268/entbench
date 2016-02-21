package org.sunflow.core.gi;
public class FakeGIEngine implements org.sunflow.core.GIEngine {
    private org.sunflow.math.Vector3 up;
    private org.sunflow.image.Color sky;
    private org.sunflow.image.Color ground;
    public FakeGIEngine(org.sunflow.core.Options options) { super();
                                                            up = options.
                                                                   getVector(
                                                                     "gi.fake.up",
                                                                     new org.sunflow.math.Vector3(
                                                                       0,
                                                                       1,
                                                                       0)).
                                                                   normalize(
                                                                     );
                                                            sky =
                                                              options.
                                                                getColor(
                                                                  "gi.fake.sky",
                                                                  org.sunflow.image.Color.
                                                                    WHITE).
                                                                copy1(
                                                                  );
                                                            ground =
                                                              options.
                                                                getColor(
                                                                  "gi.fake.ground",
                                                                  org.sunflow.image.Color.
                                                                    BLACK).
                                                                copy1(
                                                                  );
                                                            sky.
                                                              mul(
                                                                (float)
                                                                  java.lang.Math.
                                                                    PI);
                                                            ground.
                                                              mul(
                                                                (float)
                                                                  java.lang.Math.
                                                                    PI);
    }
    public org.sunflow.image.Color getIrradiance(org.sunflow.core.ShadingState state,
                                                 org.sunflow.image.Color diffuseReflectance) {
        float cosTheta =
          org.sunflow.math.Vector3.
          dot(
            up,
            state.
              getNormal(
                ));
        float sin2 =
          1 -
          cosTheta *
          cosTheta;
        float sine =
          sin2 >
          0
          ? (float)
              java.lang.Math.
              sqrt(
                sin2) *
          0.5F
          : 0;
        if (cosTheta >
              0)
            return org.sunflow.image.Color.
              blend(
                sky,
                ground,
                sine);
        else
            return org.sunflow.image.Color.
              blend(
                ground,
                sky,
                sine);
    }
    public org.sunflow.image.Color getGlobalRadiance(org.sunflow.core.ShadingState state) {
        return org.sunflow.image.Color.
                 BLACK;
    }
    public boolean init(org.sunflow.core.Scene scene) {
        return true;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ZFDXs9AorK7rIumu4nD+vxQbOy8EGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
