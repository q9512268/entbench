package org.sunflow.core.shader;
public class TexturedShinyDiffuseShader extends org.sunflow.core.shader.ShinyDiffuseShader {
    private org.sunflow.core.Texture tex;
    public TexturedShinyDiffuseShader() { super();
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
    public org.sunflow.image.Color getDiffuse(org.sunflow.core.ShadingState state) {
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
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
