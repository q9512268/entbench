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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gBkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nHxlv/fA517/m899o6h//jdqJTPwsSMAAA==");
}
