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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "d978iee+nidV/xs9KjingCIAAA==");
}
