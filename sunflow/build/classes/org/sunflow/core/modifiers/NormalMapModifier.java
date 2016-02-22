package org.sunflow.core.modifiers;
public class NormalMapModifier implements org.sunflow.core.Modifier {
    private org.sunflow.core.Texture normalMap;
    public NormalMapModifier() { super();
                                 normalMap = null; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        java.lang.String filename =
          pl.
          getString(
            "texture",
            null);
        if (filename !=
              null)
            normalMap =
              org.sunflow.core.TextureCache.
                getTexture(
                  api.
                    resolveTextureFilename(
                      filename),
                  true);
        return normalMap !=
          null;
    }
    public void modify(org.sunflow.core.ShadingState state) { state.
                                                                getNormal(
                                                                  ).
                                                                set(
                                                                  normalMap.
                                                                    getNormal(
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
                                                                          )));
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
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8NvPfSMvzv43NruZjb0iAAA=");
}
