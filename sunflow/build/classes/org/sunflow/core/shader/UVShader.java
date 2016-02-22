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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
