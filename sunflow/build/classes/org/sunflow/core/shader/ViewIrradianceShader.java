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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "B2xMFtypFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "CmXzh/d8/s2/++w38zTu/wF4MZW5HiIAAA==");
}
