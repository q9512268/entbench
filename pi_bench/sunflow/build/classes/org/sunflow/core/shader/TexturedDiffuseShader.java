package org.sunflow.core.shader;
public class TexturedDiffuseShader extends org.sunflow.core.shader.DiffuseShader {
    private org.sunflow.core.Texture tex;
    public TexturedDiffuseShader() { super();
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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "TtL6WOfReijMQryTD/4Of2TNs/8BVmSkMJIYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rm6gIgAA");
}
