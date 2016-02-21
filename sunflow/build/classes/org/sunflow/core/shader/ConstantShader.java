package org.sunflow.core.shader;
public class ConstantShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color c;
    public ConstantShader() { super();
                              this.c = org.sunflow.image.Color.WHITE; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        c =
          pl.
            getColor(
              "color",
              c);
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        return c;
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
