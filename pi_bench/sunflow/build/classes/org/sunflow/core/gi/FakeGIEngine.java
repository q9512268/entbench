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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1PzkWH1RN1SCHlKWVqRDadoT96JhqZGOufbBuThzsNHSGn3OSGCd3RLzrHng" +
       "s8iaDCNV7ssQbNIX5lyhmtd+4lOzNWXNs3e/zctb9mquCkIqkZZldxvpei/R" +
       "dJqQuDVVZlOp8X/fZ6Qhz9UMtHxJiWt70aR7mpFaPx0kCf5zkz3LSKWLjKF3" +
       "+Zub6MfQkQERvj6X7Str+ZkE2+iQ2UZnAq6iT1web7yRx7Ms7kM35gC/u7aD" +
       "JG3eXkfFC7N7+u659rnHzUO/KAtTUyilEkLDvH/IluYVBaXZskp2r70+/2L5" +
       "Kjtm60yFHZBb4oKaTohcDbd6se9EbLRnD8bvnt76wi9mSt6EbBshAQF2ayT3" +
       "wJHR0tATjURyUwDaGH5U71j7vcltGxJ/+y0/0lkps7QwPRyoHnqn5+LYJ9v5" +
       "ZWkxpCPN8JPQnZPKXiqO6558mo9RKOAtNveD5b7q7CxeETHSlosSuRdrcNyd" +
       "oPpOu+GFjKx0ZjyX6HY3k9Y0H4Mz40LSM2YSm6BZFI30apoNou9pPA/P5iuw" +
       "Zznz6/wVh1/+D6dmVVTGGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fffvv+6jT321ONr+f5n/ulAnJQAA");
}
