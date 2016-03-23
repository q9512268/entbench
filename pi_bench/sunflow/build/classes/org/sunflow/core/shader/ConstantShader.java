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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "I69e/y9YqBpKuSMAAA==");
}
