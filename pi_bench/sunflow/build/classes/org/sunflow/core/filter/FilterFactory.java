package org.sunflow.core.filter;
public final class FilterFactory {
    public static final org.sunflow.core.Filter get(java.lang.String filter) {
        if (filter.
              equals(
                "box"))
            return new org.sunflow.core.filter.BoxFilter(
              1);
        else
            if (filter.
                  equals(
                    "gaussian"))
                return new org.sunflow.core.filter.GaussianFilter(
                  3);
            else
                if (filter.
                      equals(
                        "mitchell"))
                    return new org.sunflow.core.filter.MitchellFilter(
                      );
                else
                    if (filter.
                          equals(
                            "catmull-rom"))
                        return new org.sunflow.core.filter.CatmullRomFilter(
                          );
                    else
                        if (filter.
                              equals(
                                "blackman-harris"))
                            return new org.sunflow.core.filter.BlackmanHarrisFilter(
                              4);
                        else
                            if (filter.
                                  equals(
                                    "sinc"))
                                return new org.sunflow.core.filter.SincFilter(
                                  4);
                            else
                                if (filter.
                                      equals(
                                        "lanczos"))
                                    return new org.sunflow.core.filter.LanczosFilter(
                                      );
                                else
                                    if (filter.
                                          equals(
                                            "triangle"))
                                        return new org.sunflow.core.filter.TriangleFilter(
                                          2);
                                    else
                                        return null;
    }
    public FilterFactory() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mpPQbmfWg1/4+T3B7VHxisOZ/wKgzOsXVRMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rZ52fxZGrJ9linCGZtiymfF5PIAeYypX9mN0DDNHaOIrC7OSsXkHzJUz70iV" +
       "2d2mW1usSltsK0XWx2/qDVf3ZYW7f+chM9aBmdsn//G5b/zao6/DLWKQM+vU" +
       "fHBnjqzIhWky+yuvvHD/bc9/55MZAEH0GTzxCeeplGvnzTROm3ra0Puq3peq" +
       "OnBCTwGs7AfdDCeAmmn7pp4peIYFoXW9l6mhT15+ffnp735+m4WddMMTxOCZ" +
       "53/1x7vPPr9zJPd99Lr08+icbf6bCX3HnoU95OE3WyWb0finV5/8o9958umt" +
       "VJePZ3I0PKh8/q/++xu7L37nazdILW4xnf/Dxga3zVslv03s/9jxVBMjJe6L" +
       "WljprgNLqFTowHCTZpGuAqZM1kODduVlg5eL3IIugaSkOgvaBb0k2KhYgLZA" +
       "xZKwzQKf5fX2mNHyrX6f0Nt8E9VNwqPMxrhAtUnFGY967GDc6+icN9K9Wh/F" +
       "aUl06HXS17w85mNaBeYA9LizMm01VIEmgHUH1UCOn3guaRUTtjbkFWZt9RJ+" +
       "0wyrsbkqDiLMNVszQXc3TSBKlIC1jFHOqkTGUGbcfGO1rLljajaU592kZrr5" +
       "lbbiVgCPwtiN7U5pWpUMzuuKnYbCCaN8caVJy0Ttj/pgPOw7pXk0bKzckY6V" +
       "1XjgFyc8M883bWFglqg+o0jsMgL1ZNBe5TsluVxmmHXNpQR4Puz54bDjL2x3" +
       "4BYNatOXyquVOOwsiy3cnJabs2GemXYsnx563fbQrfRrC33Ju+hsbIn1aBom" +
       "G7kI2InSppu4ETYLiSNVq0mxRogiVW5Mw4ofdqVOzbKTWZ9hltoITJd4c2SK" +
       "80GfkslOYzwb51d8K9/KV0OzO+KdCA8VZyVTZI5ZhuUcMxgU4Bti0TXq3fo8" +
       "noU4VSrqldlMDtwOC4KRxntWmTXtoT2s8TRjyH1mWBsuqwu90ypRxLLek0x3" +
       "kGwqbb7c6obmYKbwG7e8MJdOQVXtWOVikdp4pjQh0cIgKolDWWLEAR7obVS3" +
       "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" +
       "MUtiLWmWMPjOcxkJK9a05TgcjYVhv+ppnIFX8YguJDnVH1e4OU3QLDCCZpUp" +
       "0LXKqiE1hcoqQqsFzZ6aOYIjMbvdc5g45EERn+RNpjfv+gToqkM27JfRRdWg" +
       "1ut2tcWxaq7CoCiGEetINbgE5+xCczCslWWNNVBeacVtcdUcU/JYZaLxbLYW" +
       "A8a2Zm1iLIem1wntpBgNZmFTbbbzo3wem8K8TOsX82IuL/FkGIYBUcRnA6Nr" +
       "VCOZU1x8aBDCtNOulCqBM8abqxmzIuug3N1MRjMcm3CdlloT0BlenMyXxILt" +
       "uCV8IvT6UaDLdcwLMaMUqDzVW/l2kZUazNA1zaCc4FLXp9BO3owsV+jNLE3U" +
       "C2gpN8TIyrgVGz4voVFH3/D+ZNzvwsT6fe9LU+4PvLVTz13ZAe+guA4PO+mD" +
       "5lvI9uMbL7hzsCAdH9S6st/tb1LrOlIPQNKDzf03K6Vnh5qXP/b8Syr/2cLO" +
       "Xh1FDJBbA8f9OROsgXmEVXq4fPfND3Dd7EvC4fn+Kx/7l/uG759/6C1UMB88" +
       "IedJlr/bfeVrzXcpv76DnD447V/3jeP4pKvHz/gXPBCEnj08dtK//8CyD6YW" +
       "ewReZ/cse/bGVcS34BwnClantqbM3CMj8N+kohWmjR0gp3UQ7NcK7rmuQr0t" +
       "TR+6mfOTDpXHakcBcsex2nZanLv3ug9k2486yhdeunj+npdGf52Vdw8+vNzK" +
       "Iue10DSP1lKO9M+6HtCMTKFbt5UVN/v7yI2U2Zbbg/QT2IFWT27pPxogl07S" +
       "w2N1+neU7OMBctsRsgA5t9c7SvQ0NCokSrvPuDcow2xrSvGp45F0YOLLP8nE" +
       "R4Lv0WMhk32h3HfvcPuN8pry6ksM9+E38M9uy8+KKW82KZfzLHJuWwk/CJGH" +
       "b8ptn9fZ1uM/uvOLtz62H853bgU+dNwjsj144/oubblBVpHd/OE9v//e337p" +
       "21lV6H8BZpHFEDoeAAA=");
}
