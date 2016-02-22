package org.sunflow.core.shader;
public class ViewIrradianceShader implements org.sunflow.core.Shader {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        state.
          faceforward(
            );
        return new org.sunflow.image.Color(
          ).
          set(
            state.
              getIrradiance(
                org.sunflow.image.Color.
                  WHITE)).
          mul(
            1.0F /
              (float)
                java.lang.Math.
                  PI);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public ViewIrradianceShader() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hAWRlHUXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fMPvPffNvAT8f6FGGXhGIgAA");
}
