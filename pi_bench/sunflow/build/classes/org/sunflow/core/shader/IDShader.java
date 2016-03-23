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
