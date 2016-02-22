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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "u88+9unv+ImXvlBm/f8NLW3A4tAoAAA=");
}
