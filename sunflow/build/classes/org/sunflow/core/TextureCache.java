package org.sunflow.core;
public final class TextureCache {
    private static java.util.HashMap<java.lang.String,org.sunflow.core.Texture>
      textures =
      new java.util.HashMap<java.lang.String,org.sunflow.core.Texture>(
      );
    private TextureCache() { super(); }
    public static synchronized org.sunflow.core.Texture getTexture(java.lang.String filename,
                                                                   boolean isLinear) {
        if (textures.
              containsKey(
                filename)) {
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  TEX,
                "Using cached copy for file \"%s\" ...",
                filename);
            return textures.
              get(
                filename);
        }
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              TEX,
            "Using file \"%s\" ...",
            filename);
        org.sunflow.core.Texture t =
          new org.sunflow.core.Texture(
          filename,
          isLinear);
        textures.
          put(
            filename,
            t);
        return t;
    }
    public static synchronized void flush() { org.sunflow.system.UI.
                                                printInfo(
                                                  org.sunflow.system.UI.Module.
                                                    TEX,
                                                  "Flushing texture cache");
                                              textures.clear(
                                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vIvNK/8FHWNz1SEdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "krNcqXY0sHcWnC/XyZRwDJTKxzk9hduD0YIuGjypg93395Xb8r/7rZ2MPF4d" +
       "+Jx+F/BtHPXs3uQ4PDjMdXrGXv0ehS5dMZ+/zjp/DpbE0LP3+wqgOvj41Adf" +
       "eVVnfqFxdHxo9mMp9FAaRt/jGbnhnUN19OZH6bPqI4izO4vf/uCfPC18v/2+" +
       "b+Eq9vlLdF5G+cuzT39x+J3aPziCrp7eYLzh84yLQC9dOmaNDZB9BcKF24tn" +
       "TyX7XaXEGuB55liyz1y+vThT6ZsZRwo9muwDzY7DwCkM/WAml67jjs4UfDj1" +
       "LM7ZyPtT6EE1DD1DCSrgT77JXd4/LouPp9DDlpEen6KWLcqZ4f3cNzuKOo+y" +
       "avjZU5E8XzbWjp+T+rchkrL4R/cUxHle/umb9H2mLP5JedbqZYl9L5Fdy0NH" +
       "P2P7F78VtndAZ+c/VigvXp96wzdOh+9ytF999eaNt78q/sfqvv7025mHKOiG" +
       "mXne+Xuyc/XrUWyYTsXKQ4dbs6h6/XoK3bp8HA54KV8Vlf/iMOxfpdAj54YB" +
       "AzmunR/0+RS6CgaV1d+o1HN3d+ViNDiVzhPfTDrnAsg773u7M8sOn4jd1T77" +
       "6oT+kddbv3D4FkDzlKLSzg0KevDwWcKpm794X2wnuK6P3v2Nx37toXedhKTH" +
       "DgSfWdo52p6/97076UdpdVNe/Mu3//Pv/cVXv1Kdfv9fopsClbknAAA=");
}
