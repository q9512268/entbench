package org.sunflow.core.shader;
public class TexturedPhongShader extends org.sunflow.core.shader.PhongShader {
    private org.sunflow.core.Texture tex;
    public TexturedPhongShader() { super();
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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "n/96Xoz9b/zaHx6kIgAA");
}
