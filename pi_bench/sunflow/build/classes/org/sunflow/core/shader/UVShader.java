package org.sunflow.core.shader;
public class UVShader implements org.sunflow.core.Shader {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        if (state.
              getUV(
                ) ==
              null)
            return org.sunflow.image.Color.
                     BLACK;
        return new org.sunflow.image.Color(
          state.
            getUV(
              ).
            x,
          state.
            getUV(
              ).
            y,
          0);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public UVShader() { super(); }
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
