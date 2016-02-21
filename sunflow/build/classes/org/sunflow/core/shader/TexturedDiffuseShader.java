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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ul5PP62MV/d1e2f2IX9wogQ/atMX/Kv4qtu+ejQtnjjIoWS/cydPIY6mKw9z" +
       "WEj6pfrgzQ6Ksq/Uj7/3uec19hOFnb3cnxIiF0LXe7MFVsA6wmoHcnrq5l/k" +
       "veyc7DAn9cX3/tMDw7fO3vkqMu0Pn5DzJMvf6r3w5dYb1F/aQU4fZKiuO8E7" +
       "3unq8bzURR+Eke8Mj2WnHjyw7N2pxV4Lr30z33njbPeNU1OZF2zn/kRqdWfP" +
       "gHsJnIeuSzpldgAh8NPc7T7ZvUfJhO29ztHZCM+8QvL2Z9IiDpFzkafJ4Tav" +
       "//YjniaHyHnFdS0gO4deuPlhuYWjo2QN0YHZMiu9bi+xt5/g+z8w26m9Y549" +
       "ezx4ndnSYyPTMdLTZ5BxePYVzPJcWnwgRC4aINw7dtrnfN9RzqYtGyDN0e8d" +
       "N2fm+YVXYx5o+3tueMCVZuvvv+5sfXserH7m+Uu33Pf86C+zM56DM9sLDHKL" +
       "HlnW0eTqkfo5zwe6mel3YZtq9bLbx04odeTsLc07ZpVM7o9u6X8tRC6fpA+R" +
       "M+ntKNmvh8itR8igI+3VjhL9RoichkRp9ZPevomfuNlJ4DEDxaeOY9eB/e/6" +
       "YfY/AnePHwOp7D8e9gEl2v7PwzX1s893+u96qfyJ7cGUaslJknK5hUHOb8/I" +
       "DkDp0Zty2+d1rv3ky3d87sIT+wB6x1bgQ58/ItvDNz4FatpemJ3bJL933++8" +
       "5ZPPfyNLrP43AVxne4oiAAA=");
}
