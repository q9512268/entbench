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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ki2idqdM9WqVqTtNmUoYMrxVm7CaRVTmNNXMYjYLDTuOzQyplmwvFqfjEqOt" +
       "Enhs6XGDri2XQUlSei5Rrodme9wrxZk1VeJtr0qoqDQgWoY5z0R5TaHraoOe" +
       "NnSPtXU+qcIwUqlR9eoIrlX6NIfYw3JrTrUSHZ0anj1jaLSDMmpabQwTzLC7" +
       "JlPGR1WSHEmlsTZY2wTmD2prXYQlocnBzrBDV0srn8VKTRXLUsqe4qGIITXg" +
       "HmlnMp/aqAzPx6RTjglzKosA5IzKVpOUBbuabZG1hLdQbUCio00JF8h+1CAm" +
       "jGwoiwU8COFgLWFC5gYOO+ri1XjMWFNzA8RXOgTGwbBMj1TGTLDmvMQ0mKGP" +
       "0UHZS6IE6dNO0kg1Jc2cmp9UEYpcy/HM8ltavw82hQGj1QZDEh8HWtYdeX3P" +
       "ROpEWwnhOu6MEQrm+8FqPrK77FAftxYaFkhSs6vFlhtHlDRRfGdubxyPNvDV" +
       "BjaJeuQJpcoGG8hTux6XFhLKdlmYVSqzxInmSsvAGXrSihkRTZC1MUdUAiyO" +
       "2O7hM1T0akx3RcGMA2MeZa7jGrwozfoVTytPtjMO52B+4JbDWj3GG4qK4Usm" +
       "9bfOrJKOG/NeHcOkhcTCfdmcwiOn6nJlUquFSjnyR/xqRldIdq7UmhNkFle7" +
       "FalTskiXUlppdcF5bT/olGYRm0pNu9zJVD+jTZ3PttkSX4iSnJL+0tGx0O7M" +
       "GTELV0FZoFLPm7YjCk7g3rLNyl06nPD9UQ1eMVk4oxh+xQUy3uk15DY1HwzQ" +
       "brgcGl0ssohSOZXHQjnmcBfuIFtrzbVLE89pSVW3bEpy08Gy2nC8AJuaFPF8" +
       "HZ+vXQL3R5UqPMb0QKppAtbwFrYiw8QKWbSBO8GwE/RmEsNIGSt0JqRAU9NU" +
       "tuYOp63wzbxew8jyup4pG29Cid3OKqFEt0+16XpvPHIjrTNIkbqERNFaYWui" +
       "1+7MmxVuZk97YlKWFXshdmIrHQ3gBckSURTAbWvhtxZm2W8vGmOVV+kwC+pJ" +
       "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" +
       "GxYnOdnvveJ33vCbT3+zSLL+NwypaFSZIgAA");
}
