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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "bL4Ce5Yzv85fcfjF/wBJ06ny0BoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
