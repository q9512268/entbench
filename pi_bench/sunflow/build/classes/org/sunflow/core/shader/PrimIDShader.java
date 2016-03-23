package org.sunflow.core.shader;
public class PrimIDShader implements org.sunflow.core.Shader {
    private static final org.sunflow.image.Color[] BORDERS = { org.sunflow.image.Color.
                                                                 RED,
    org.sunflow.image.Color.
      GREEN,
    org.sunflow.image.Color.
      BLUE,
    org.sunflow.image.Color.
      YELLOW,
    org.sunflow.image.Color.
      CYAN,
    org.sunflow.image.Color.
      MAGENTA };
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
        return BORDERS[state.
                         getPrimitiveID(
                           ) %
                         BORDERS.
                           length].
          copy1(
            ).
          mul(
            f);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public PrimIDShader() { super(); }
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
       "AAA=");
}
