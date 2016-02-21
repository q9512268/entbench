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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "CEjQGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
