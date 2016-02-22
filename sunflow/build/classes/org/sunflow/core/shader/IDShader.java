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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "FwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "DiIAAA==");
}
