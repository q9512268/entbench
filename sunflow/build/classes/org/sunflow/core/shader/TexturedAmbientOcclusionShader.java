package org.sunflow.core.shader;
public class TexturedAmbientOcclusionShader extends org.sunflow.core.shader.AmbientOcclusionShader {
    private org.sunflow.core.Texture tex;
    public TexturedAmbientOcclusionShader() { super();
                                              tex = null; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        java.lang.String filename =
          pl.
          getString(
            "texture",
            null);
        if (filename !=
              null)
            tex =
              org.sunflow.core.TextureCache.
                getTexture(
                  api.
                    resolveTextureFilename(
                      filename),
                  false);
        return tex !=
          null &&
          super.
          update(
            pl,
            api);
    }
    public org.sunflow.image.Color getBrightColor(org.sunflow.core.ShadingState state) {
        return tex.
          getPixel(
            state.
              getUV(
                ).
              x,
            state.
              getUV(
                ).
              y);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
