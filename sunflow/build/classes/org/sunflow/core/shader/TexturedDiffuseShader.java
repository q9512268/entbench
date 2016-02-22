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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "u7dcyd3FiClEg6LjayLSqRZaMQ63B+xar8F0C+xd5U6ry9Q7XjwDX15vyT7J" +
       "9Ff3VXxnXgA4OHUCH8PZi9Gr+Brcvno0a544qL3kv3MnTyqOljkPa19Q9oX7" +
       "4M0Ok/Kv24+99/kX1MHHkZ29mqEcQhdC13sT+CDRrCOkdgClp27+Jd/Lz9IO" +
       "a1lfeO8/PcC/dfHOV1Ghf/gEnydJ/k7vxS+Rb1B+ZQc6fVDZuu6U7zjS1eP1" +
       "rIu+Fka+wx+raj14oNm7M429Flz7ar7zxlXyG5e0civYrv2JkuzOngL3Cj8P" +
       "XVesyvWghZqf1Xz3we49CsZt7w2Wymd45hWKvj+XNUkInYs8VQq35wFvP2Jp" +
       "Ugidl13X0iTn0Ao3P6omcXSWfCA6UFuupdftFQT3C4P/B2o7tXc8tKePB69T" +
       "W3bcZDh6dkKt5RSeewW1PJ817w+hi7oW7h1X7VO+7yhlw5Z0Lavt7x1J5+r5" +
       "pVejHqD7e254MJZV+e+/7vx9e2asfPqFS7fc98L4r/KzoYNz3QsMdMs8sqyj" +
       "Rdkj/XOer82NXL4L2xKtl98+ekKoI2d2Wb0y7+R8f2QL/xshdPkkfAidyW5H" +
       "wX4zhG49AgYMaa93FOi3Qug0AMq6n/D2VfzEzU4QjykoOXU8dh3o/64fpf8j" +
       "4e7xY0Eq/1fEfkCJtv+LuKZ85gW6/66Xqx/fHmgplpSmGZVbGOj89mztICg9" +
       "elNq+7TOdZ78wR2fvfDEfgC9Y8vwoc0f4e3hG58etWwvzM970j+47/fe/IkX" +
       "vpEXZP8bddbQ+a4iAAA=");
}
