package org.sunflow.core.modifiers;
public class BumpMappingModifier implements org.sunflow.core.Modifier {
    private org.sunflow.core.Texture bumpTexture;
    private float scale;
    public BumpMappingModifier() { super();
                                   bumpTexture = null;
                                   scale = 1; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        java.lang.String filename =
          pl.
          getString(
            "texture",
            null);
        if (filename !=
              null)
            bumpTexture =
              org.sunflow.core.TextureCache.
                getTexture(
                  api.
                    resolveTextureFilename(
                      filename),
                  true);
        scale =
          pl.
            getFloat(
              "scale",
              scale);
        return bumpTexture !=
          null;
    }
    public void modify(org.sunflow.core.ShadingState state) { state.
                                                                getNormal(
                                                                  ).
                                                                set(
                                                                  bumpTexture.
                                                                    getBump(
                                                                      state.
                                                                        getUV(
                                                                          ).
                                                                        x,
                                                                      state.
                                                                        getUV(
                                                                          ).
                                                                        y,
                                                                      state.
                                                                        getBasis(
                                                                          ),
                                                                      scale));
                                                              state.
                                                                setBasis(
                                                                  org.sunflow.math.OrthoNormalBasis.
                                                                    makeFromW(
                                                                      state.
                                                                        getNormal(
                                                                          )));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/L6cUIoZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tR6uN2JLFFWfKvdJdhGUgtXCBkDNVgIcMaS0viw4KS5PQeQz3lRrMWlVRRit" +
       "DmOEDI1Kp6/2wIbhFHvFpr0A0YxSJ8seI5aU0ZpVF75cNdnQDHtm4HbJSoM0" +
       "UwxzCgVOxCMAZjZu+sZmVEqmCV9hwvawljAko9FBsz9qz8bsSp9jjrjsYnhN" +
       "a6bOUHW8hQGHjsyoRWeTOFUC6VUUnnYlcKJ7U3bU81/ZEfTu/LR9cAEHTp7Z" +
       "C/kVnDK3rx7PitceJGbyz1noxKXN0XTvYQ7w1P7J/tU3JIj2by2ytMcjt7p5" +
       "y1MeH3/XM8+pzCeKO3vZVT6CLkSu91OWttKsI5PtgJGeunV6p59fPB5m/b70" +
       "rn96aPwzxttewV3Goyf4PDnkJ/vPf4V6nfLrO9DpgxzgDVeixztdO575uxho" +
       "URw442P5v0cOdH9vpupXg+e+Pd3fdzIpdri6N8+IvX5rHSeS1zt7CtxbrSs3" +
       "rFauBy3Sgiw7vk92/1EybvtdZ+l8hl99ifT4B7LilyPobOypcqTdLB9ybua6" +
       "liY7h3b67pfLhhydJW945/FrmKfA8/Ce2h7+v1HbqeNG/sgNauMMWTUdPbvO" +
       "1/IRPvoSavmtrPgIUEt+pbG+aZpo5ZrqoU6efSU6SSPo3pvcGmZXIA/e8P+E" +
       "7Z268pnnLp1/4Dn+r/KLs4N77ws96Pw8tqyjGesj9bNeoM3NXKQL2/y1l399" +
       "KoIeuvWNJnDqg3rO+ye3vT4dQZdP9gKKyL6Okn0ugm4/QgYsaK92lOj3Iug0" +
       "IMqqn/duknTc5u/TU0dAZc+WcnXf83LqPuhy9HotA6L8byL7oBFv/yhyXfns" +
       "c53B21+sfGJ7vadY8maTjXK+B53b3jQeAM/jtxxtf6yz7Sd/dNfnLrx2HyTv" +
       "2jJ8aNdHeHv05ndpTXDszW+/Nn/wwOff+NvPfSvPgf43jNxy/78jAAA=");
}
