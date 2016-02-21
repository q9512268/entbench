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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "FgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "g/ab5iEAAA==");
}
