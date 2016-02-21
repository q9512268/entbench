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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Pwakp5esJwAA");
}
