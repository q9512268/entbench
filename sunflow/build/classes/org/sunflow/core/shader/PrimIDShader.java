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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vl6cNv8vBflqdcQnAAA=");
}
