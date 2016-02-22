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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "R621ShVQorFKynqzb4xrljsaD/zeDO0Krj4t6OViGyfppLvq0yxiiohIYymy" +
       "7s7tRakfjQzwAvamN2WvZsYrezu+Jy8EHFxGgZfi7MHoFbwVbh89njVPHdRg" +
       "8r9zJy8wjpY7D2tgUPam+/Dt7pjyt9yPvvvG8yrzscLOXu1QjqCLkef/mK2t" +
       "NPsIqx3A6Znbv9HT+RXbYU3r8+/+p4f4nzDf/goq9Y+ekPMky9+hX/hi5/XK" +
       "r+xApw8qXDdd/h2fdO14XetSoEVx4PLHqlsPH1j2vsxirwGffTPfc+tq+a1L" +
       "W7kXbPf+RGl2Z8+AewWgR24qWuV20CItyGq/+2T3HyXjtt8E28tXePZlir8/" +
       "lzVJBJ2LfVWKtvcCbz3iaVIEnZc9z9Yk99ALNz+sNnF0lXwgPjBbbqXX7hUG" +
       "9wuE/wdmO7V3TbRnj4dvMlt27WS5RnZxreUcnnsZs9zImvdF0CVDi/aurfY5" +
       "P3CUM8AvQ8tq/Hs31bl5fumVmAfY/qHb35JlJf8Hb7qb394nK596/vKFB54X" +
       "/iq/KDq4871IQRf02LaPVmiP9M/5gaZbuZIXt/VaP//6yAnNjtziZcXLvJML" +
       "/+Et/W9E0JWT9BF0Jvs6SvabEXTHETLgTXu9o0S/FUGnAVHW/bi/b+dnbnen" +
       "eLOVklPHUexgJ+79YTtxBPiePAZX+b9N7ENLvP3HievKp5/vD97xUuVj2ysu" +
       "xZbSNONygYLOb2/bDuDp8dty2+d1rvv09+/+zMWn9qH07q3Ah95/RLZHb32f" +
       "1HL8KL8BSv/ggd9748ef/3peov1v/q4cr88iAAA=");
}
