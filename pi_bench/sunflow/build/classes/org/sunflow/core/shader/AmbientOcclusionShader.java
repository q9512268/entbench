package org.sunflow.core.shader;
public class AmbientOcclusionShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color bright;
    private org.sunflow.image.Color dark;
    private int samples;
    private float maxDist;
    public AmbientOcclusionShader() { super();
                                      bright = org.sunflow.image.Color.WHITE;
                                      dark = org.sunflow.image.Color.BLACK;
                                      samples = 32;
                                      maxDist = java.lang.Float.POSITIVE_INFINITY;
    }
    public AmbientOcclusionShader(org.sunflow.image.Color c, float d) {
        this(
          );
        bright =
          c;
        maxDist =
          d;
    }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        bright =
          pl.
            getColor(
              "bright",
              bright);
        dark =
          pl.
            getColor(
              "dark",
              dark);
        samples =
          pl.
            getInt(
              "samples",
              samples);
        maxDist =
          pl.
            getFloat(
              "maxdist",
              maxDist);
        if (maxDist <=
              0)
            maxDist =
              java.lang.Float.
                POSITIVE_INFINITY;
        return true;
    }
    public org.sunflow.image.Color getBrightColor(org.sunflow.core.ShadingState state) {
        return bright;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        return state.
          occlusion(
            samples,
            maxDist,
            getBrightColor(
              state),
            dark);
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
       "+r4oAAA=");
}
