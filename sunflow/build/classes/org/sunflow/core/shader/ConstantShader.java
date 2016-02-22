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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4T2/99rfeuYbeQX7fwGX2j1uxyMAAA==");
}
