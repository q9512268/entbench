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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zY/tu+95zzfWYGff898fgt8pcP1XdmXEsoHtPnw3uZcMPHKQDXhgZzq9j/tq" +
       "kHrcsEvtbU/bsJa1xax5ZotRvqUR/WTWNJJTgMGzxd3KbiF7pm4uxOms++Mg" +
       "EAV5ngwwVMMRrFxVjRA4hSVd3Wd9CvJmYEVXTauyz/OV3AGy9drdJpsneG38" +
       "j3kFBn7nITHaBXnr+//+ua/+0uPfBFbYg86uMwsBxndkxn6UpfK/8MKHHrzt" +
       "+rfen8dVsCrjZ97jvjOjOn05ibOGzZrBvqgPZKKO3ciXFFoIQiYPhYqcS/uy" +
       "zjfwDRvsGOu9PBV59u5vLj/67U9vc9CTnnYCWHnf9V/84e4Hr+8cyfwfvyH5" +
       "Poqzzf5zpu/Y07APPfpys+QYrX/47LN/8FvPvnfL1d3H89gm+Ez79F/851d3" +
       "P/KtL98kfTpjuf+LhQ3v+ECnFHSJ/R89XaizmEuSmcpiNaQ0RAiNaDYSva6n" +
       "raLmzqzl2Gy262VmM+sZGroaLyKxWI6q00pUXUd+p1D0hmiXnozGzWGBLZBm" +
       "ica7S4MYCv3Zyu/rrSlK8qPC0usVUt5rTSnU4laiq/HTieCP+05hE9RqGF/y" +
       "Occfb5RKf40FSaWKRUituFjPl9LUczuCwXmm3Ow6vJ36Y01JFnyP80u9vrRR" +
       "CyanO+m6rtZQTJRmVW46xM3Z1AoaS3PR6xRSbkrbTMsNVqnYWi0nTGcxXha7" +
       "el0rA8GYPoeGI73fkoowxgLOg7Qj18c64QQxtyD7sz7VmFgeJ/fWFF53pWFv" +
       "1owk31CV5hyTHI4uLvERq8CdVFUoZN3gB4wyZ/lWg7MaEZF0aMX1meEkWNqV" +
       "aswL/mxNjZriSOhuloKSEkFYLsaq2IS17lxuJRHCmnY6iydytRX4lCuUFYGP" +
       "SoZHzZilxZH9eVSb6cqE0WCTXpFpHXc2ZKvD2U7TMZn2Uuo5s6AmjLTaEG2G" +
       "c6rWNpUO67krebEMDapnDccc3nca7NQcdNE4FlYrK2STKoMaZdQfTWctzyzh" +
       "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" +
       "A2nHZrNVjnuay+JaxYjChUbUR6gcN+QULRCb9kKMYjLi9YDYSNONlHSCqG6v" +
       "0X59KLqmwBY9M/ILRKEWo/Vu2TWJqhxMBaTYI0u1eFOsFmejttgdYIhZW1Ja" +
       "OBjO9BaeMG2ObPvUsDcVxpKG9/RNoyz7o7VEJ9i6A4w6ZmGwxbJNrJ86pRBZ" +
       "VBGhjiIWO9303UitoPHQ1XAq6tjuxBy4LbVOlZGgFIWWM4vZWl3wMZSbRSvF" +
       "mmq23euMh7HYbFSU6gDxS+FMaRKzDtzQ7EkJZQZq0q0w4xnJjdKSlSiSoqJm" +
       "QrVEm2GEte9ZTBUjR8ikVpJpvbNJULhlcpi3HhApZ/e5gj7rzDE6ou3ItOph" +
       "KULFtYWX4tog9CbokDcxt+jR1rAmeI3qVO+sgMjTGgyTcmGCaUU8tAcryS1E" +
       "3HK2xBWFEFOErKUDdu0W5g4CAJhqr74QSJAJljsS7xjTtu6Sa7hPsMXSrFUa" +
       "ztka3aPsfislEwa3g43OIA2/YZHcrNjmBmEXbxtKuSYFZYxsB12/jazFxmDu" +
       "FFS40xs0p6HHwbZPjYU5QkwnnbS85HFZXKVKH8GI4iZ2olZtjhstrlAWDLjH" +
       "wpWKNe4XdKEciHMj6RHliuItmRm83LCxgZla34vHVVtyBc2nOXTCig6eJKmx" +
       "qpaskW5V4HJdwutFjiDpTkeQsURFFQ+kA7qFUKPFAOwCRWBSc7ELnuf1mtFR" +
       "8XohDpmxk5r6uAHXVEnR2+UaPPQ2ox4xHUzMbiiPSK7kmy7vJ1ZP5MoR8AJf" +
       "dMs4RvdJVwrtYEauuTqPM32vUagrfLHukgmqbZoVrDMYRPCwsEbWo1KZXxMS" +
       "Fo7qLaagFGs6wTtzeqyhNWNBpUNlRWB4ilsVtMhM2n3FRpDeao5ThsYQCD0s" +
       "taq4h8Epzqgi3FMTckWQTVuZVnixF47kUd3dEMu4aMBNLijAU4yAi3DiS3NH" +
       "MDzcMJe9Kr0uDYjqbCa1ewE6LmD8vGU6teEYthpeS1vNfXfYUswU7kyGPt5i" +
       "7ZVIDhOXDYuw6zXlEY7p1V41aazLpTayGdUW1VoCt4rSKl4lGvj4etObss8y" +
       "7ZV9Gd+VFwEOjp/AB3H2YvQKvgi3rx7NmicO6i/579zJI4ujpc7D+heUfeU+" +
       "eKtTpfwL9+Pvvv68zH4C3dmrG4ohdDF0vZ+wlLViHSG1Ayg9deuveSY/VDus" +
       "Z33x3f/0wOTN+ttfQZX+4RN8niT528wLX26/XvrlHej0QXXrhuO+40hPH69p" +
       "XfIVkIU4k2OVrQcPNHtPprHXgGtfzXfdvFJ+87JWbgXbtT9Rlt3ZU+Be8eeh" +
       "GwpWuR6UUPGzuu8+2L1HwcbbOzHo5jM8+zKF35/PmiSEzkWeLITbM4G3HrE0" +
       "IYTOi65rKYJzaIXpj6pLHJ0lH4gO1JZr6bV7RcH94uD/gdpO7R0R7enjwRvU" +
       "lh05GY6WHVUrOYXnXkYt17Pm/SF0SVPCvSOrfcr3HaVs2IKmZPX9vbPpXD0f" +
       "eCXqAbp/4NYnZFm5//4bTuO3J8jSZ56/fOG+57m/zA+JDk55L9LQBTWyrKPV" +
       "2SP9c56vqEYu5MVtrdbLbx87IdmRE7yscJl3cuY/uoX/9RC6chI+hM5kt6Ng" +
       "vxFCtx0BA9a01zsK9JshdBoAZd1Pevt6fupW54k3aik5dTyKHazE3T9qJY4E" +
       "vsePhav8jxL7oSXa/lXimvTZ53v9d7yEf2J7vCVZwmaTUblAQ+e3J20H4enR" +
       "W1Lbp3Wu8+QP7vzcxSf2Q+mdW4YPrf8Ibw/f/CypaXthfvqz+f37fveNn3z+" +
       "G3l59r8BANABEsEiAAA=");
}
