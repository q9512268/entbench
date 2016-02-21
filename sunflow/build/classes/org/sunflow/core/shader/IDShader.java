package org.sunflow.core.shader;
public class IDShader implements org.sunflow.core.Shader {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        org.sunflow.math.Vector3 n =
          state.
          getNormal(
            );
        float f =
          n ==
          null
          ? 1.0F
          : java.lang.Math.
          abs(
            state.
              getRay(
                ).
              dot(
                n));
        return new org.sunflow.image.Color(
          state.
            getInstance(
              ).
            hashCode(
              )).
          mul(
            f);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public IDShader() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AH26MqXmIQAA");
}
