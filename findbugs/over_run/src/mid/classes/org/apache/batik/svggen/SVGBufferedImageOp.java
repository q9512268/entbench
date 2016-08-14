package org.apache.batik.svggen;
public class SVGBufferedImageOp extends org.apache.batik.svggen.AbstractSVGFilterConverter {
    private org.apache.batik.svggen.SVGLookupOp svgLookupOp;
    private org.apache.batik.svggen.SVGRescaleOp svgRescaleOp;
    private org.apache.batik.svggen.SVGConvolveOp svgConvolveOp;
    private org.apache.batik.svggen.SVGCustomBufferedImageOp svgCustomBufferedImageOp;
    public SVGBufferedImageOp(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
        this.
          svgLookupOp =
          new org.apache.batik.svggen.SVGLookupOp(
            generatorContext);
        this.
          svgRescaleOp =
          new org.apache.batik.svggen.SVGRescaleOp(
            generatorContext);
        this.
          svgConvolveOp =
          new org.apache.batik.svggen.SVGConvolveOp(
            generatorContext);
        this.
          svgCustomBufferedImageOp =
          new org.apache.batik.svggen.SVGCustomBufferedImageOp(
            generatorContext);
    }
    public java.util.List getDefinitionSet() { java.util.List filterSet =
                                                 new java.util.LinkedList(
                                                 svgLookupOp.
                                                   getDefinitionSet(
                                                     ));
                                               filterSet.addAll(svgRescaleOp.
                                                                  getDefinitionSet(
                                                                    ));
                                               filterSet.
                                                 addAll(
                                                   svgConvolveOp.
                                                     getDefinitionSet(
                                                       ));
                                               filterSet.
                                                 addAll(
                                                   svgCustomBufferedImageOp.
                                                     getDefinitionSet(
                                                       ));
                                               return filterSet;
    }
    public org.apache.batik.svggen.SVGLookupOp getLookupOpConverter() {
        return svgLookupOp;
    }
    public org.apache.batik.svggen.SVGRescaleOp getRescaleOpConverter() {
        return svgRescaleOp;
    }
    public org.apache.batik.svggen.SVGConvolveOp getConvolveOpConverter() {
        return svgConvolveOp;
    }
    public org.apache.batik.svggen.SVGCustomBufferedImageOp getCustomBufferedImageOpConverter() {
        return svgCustomBufferedImageOp;
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.BufferedImageOp op,
                                                             java.awt.Rectangle filterRect) {
        org.apache.batik.svggen.SVGFilterDescriptor filterDesc =
          svgCustomBufferedImageOp.
          toSVG(
            op,
            filterRect);
        if (filterDesc ==
              null) {
            if (op instanceof java.awt.image.LookupOp)
                filterDesc =
                  svgLookupOp.
                    toSVG(
                      op,
                      filterRect);
            else
                if (op instanceof java.awt.image.RescaleOp)
                    filterDesc =
                      svgRescaleOp.
                        toSVG(
                          op,
                          filterRect);
                else
                    if (op instanceof java.awt.image.ConvolveOp)
                        filterDesc =
                          svgConvolveOp.
                            toSVG(
                              op,
                              filterRect);
        }
        return filterDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Epv7/wvLfhGqUiAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e6zk1nkf90ralVaydiXbkqJaL2vl2hr7ct6PSnbM4ZCc" +
       "4XBIznCGM8M4WfE9fHP4nGGqJjHa2mgCx0hl1y1s/RMHeUCOgiJGGwQJFASp" +
       "E8Qt4DZokwKJjaZAkzpG4wJ2i7ptesi59869d3evLUjoBXjumfP4zvf7zvd9" +
       "5zuP174F3RMGUMn37K1ue9GhuokOTbtxGG19NTwkqQYrBqGqoLYYhlNQdlN+" +
       "769d++73Pr26fgBdFqB3iq7rRWJkeG44UUPPTlSFgq7tSzFbdcIIuk6ZYiLC" +
       "cWTYMGWE0QsUdP+prhF0gzpmAQYswIAFuGABRvatQKd3qG7soHkP0Y3CNfT3" +
       "oEsUdNmXc/Yi6JmzRHwxEJ0jMmyBAFC4N//NA1BF500APX2CfYf5FsCfKcGv" +
       "/JMfu/7P74KuCdA1w+VydmTARAQGEaAHHNWR1CBEFEVVBOghV1UVTg0M0Tay" +
       "gm8Bejg0dFeM4kA9EVJeGPtqUIy5l9wDco4tiOXIC07gaYZqK8e/7tFsUQdY" +
       "H9lj3SHE83IA8KoBGAs0UVaPu9xtGa4SQU+d73GC8cYQNABdrzhqtPJOhrrb" +
       "FUEB9PBu7mzR1WEuCgxXB03v8WIwSgQ9fkeiuax9UbZEXb0ZQY+db8fuqkCr" +
       "+wpB5F0i6N3nmxWUwCw9fm6WTs3Pt+gXP/Xjbt89KHhWVNnO+b8XdHryXKeJ" +
       "qqmB6srqruMDz1OfFR/5rU8eQBBo/O5zjXdt/sXf/fZHP/jkG7+/a/O3btOG" +
       "kUxVjm7KX5Qe/Np70A907srZuNf3QiOf/DPIC/Vnj2pe2PjA8h45oZhXHh5X" +
       "vjH5V8uf/BX1mwfQ1QF0Wfbs2AF69JDsOb5hqwGhumogRqoygO5TXQUt6gfQ" +
       "FZCnDFfdlTKaFqrRALrbLooue8VvICINkMhFdAXkDVfzjvO+GK2K/MaHIOgK" +
       "+KAHwPd+aPdX/I8gC155jgqLsugargezgZfjzyfUVUQ4UkOQV0Ct78ES0H/r" +
       "Q5XDFhx6cQAUEvYCHRaBVqzUXSUcJrquujDHE91Yy2dHGThALRj/MFc6///v" +
       "cJsc/fX00iUwMe857xZsYFF9z1bU4Kb8StzFvv2rN//w4MRMjuQWQc+DMQ93" +
       "Yx4WYx7uxjy8dUzo0qViqHflY+/mH8yeBfwA8JAPfID7UfKlT773LqB4fno3" +
       "EH3eFL6zo0b3nmNQ+EcZqC/0xufSn+J/onwAHZz1uDm/oOhq3p3N/eSJP7xx" +
       "3tJuR/faJ/7iu69/9mVvb3NnXPiRK7i1Z27K7z0v2cCTVQU4xz35558Wv3zz" +
       "t16+cQDdDfwD8ImRCHQYuJsnz49xxqRfOHaPOZZ7AGDNCxzRzquOfdrVaBV4" +
       "6b6kmPIHi/xDQMb35zr+BPjQI6Uv/ue17/Tz9F07Fckn7RyKwv1+mPO/8Mf/" +
       "5i9rhbiPPfW1U2sfp0YvnPIOObFrhR94aK8D00BVQbs//Rz7jz/zrU/8SKEA" +
       "oMWztxvwRp6iwCuAKQRi/ge/v/6Tr//ZF//oYK80EVgeY8k25M0JyLwcunoB" +
       "SDDa+/b8AO9iA5PLtebGzHU8xdAMUbLVXEv/97XnKl/+q09d3+mBDUqO1eiD" +
       "35/AvvyHutBP/uGP/Y8nCzKX5Hx128ts32znMt+5p4wEgbjN+dj81L994p9+" +
       "RfwCcL7A4YVGphY+7NKR4eRMvTuCShfY5pFL9YKjhb2YaLjo+XyRHuZCKuhB" +
       "RV0tT54KTxvMWZs8FbnclD/9R3/9Dv6vf/vbBcKzoc9p/RiJ/gs7lcyTpzeA" +
       "/KPnvUNfDFegXf0N+mPX7Te+BygKgKIM/F3IBMA9bc5o01Hre678x9/53Ude" +
       "+tpd0AEOXbU9UcHFwjCh+4BFqOEKeLaN/8Mf3SlEei9IrhdQoVvA7xTpseLX" +
       "FcDgB+7sk/A8ctmb9WP/i7Glj/+n/3mLEApvdJsF+1x/AX7t84+jH/lm0X/v" +
       "FvLeT25uddkgytv3rf6K852D917+vQPoigBdl49CSF6049zYBBA2hcdxJQgz" +
       "z9SfDYF26/0LJ27vPedd0qlhzzuk/VIB8nnrPH/1nA/K11zoBvg+eGSeHzzv" +
       "gy5BRQYpujxTpDfy5G8fm/wVPzASEB8c2fzfgL9L4Pu/+ZcTywt2q/nD6FFI" +
       "8fRJTOGDVex+YBiU51mxz/jH1vPsBdZz3HbnHfO0nifdHQOtO+rVi2dRvw98" +
       "lSPUlTugHt0BdZ7FClHiEfQAYA1E1bJoq3sANy4AcNL4HAL6TSLIg6TmEYLm" +
       "HRDwPwiCdwDegEIm+cZgD+G5CyDsW5/DMH+TGD4CvhePMLx4Bww3fxAMj+UY" +
       "4jDynHORzzGc8kVwbtfxHLKXvi+ygpPNJWAT91QPW4fl/Pfq9rzflWffD9bL" +
       "sNjggR6a4Yr2MZhHTVu+cWwtPNjwAcd1w7Rbx1iuFz43dxGHu13SOV7xH5hX" +
       "4FMf3BOjPLDh+un//Omv/uyzXweOj4TuSXKnBPzdqRHpON+D/sPXPvPE/a98" +
       "46eL5R9MBvtZ7PpHc6rhRYjzpNgyOcdQH8+hckUMTYlhNCpWbFUp0F7o79nA" +
       "cEBgkxxtsOCXH/669fm/+NJu83TeuZ9rrH7ylX/0N4efeuXg1Jb12Vt2jaf7" +
       "7LatBdPvOJJwAD1z0ShFD/y/vP7yb/7Sy5/YcfXw2Q0Y5sbOl/79//nq4ee+" +
       "8Qe3ie7vtr23MLHRtZ/p18MBcvxHVQS1gcw2EzepqYza72v9tjDtI7LSTUNa" +
       "aS+xzaQzNRt9or6pluseO0HsyBVqQbISHI1wlGarOx2j/EzkONsmysIKWw/W" +
       "xmwc4Jxl2U40lO0p6XkSlvJuaovr8RrlSL4N5nNsZVttWkuqQtnmm1x7HQNq" +
       "cLMUwFGrMyzBQUlLCZ70m8MJjzW4EUawEj0PMCsxVLzP9QTTt9Npbz6udoYw" +
       "29BaQWLWup21UlZIftLxiS46kmwsbWJrcrtyTLO9neGDEWlYBh0JE8dCGX9W" +
       "Z9fjdDjlh3N2Sg5HgZ86XJPC4mg2miyHtO7X9Xq6IBTUUYTWlMLC3iBAJtpU" +
       "2CZkVJ+QxIq1+v6kIomtHk23e2RVHYlTOtZGgtkb25Fu98ZmxpI9R7WQbL6I" +
       "euTAqvIRrFFDL5kgXhRZzdK2R2GOzM8nBL/WpCRrw71yb6qkIyyd4LOJvSjz" +
       "q36Pn6meb2HiYtLi23pZ6GyGiTVaYw4XrhrGJPLGHXGSOqbMWFFQj3FxU+rj" +
       "i208a/LrNh1y/Fw0kMgQBg3NQCVvHNY5qzQJurpVyeihMqoz1XBTiaSF3Oep" +
       "DTxbZJrZWpZhcYjSrDiZWK6/UeeDENEJC+a647kVTxdzc9BgVs60vl3oRL9T" +
       "IRXMmfir0iISLHbNp9x8tUHTbDlU1GVtrWGtBR93yTJWY41yxve1+ZYdGiG8" +
       "XWdhhLCx1agq01llMXA7HoEqXSSZhimFueFsK9hdbmRuGbi7ZUynXANspHws" +
       "e0QFVdby0kNcbiyYNCZgfd+EFbSNup0xvvbHurlmaQFdDYcRPcNknPV9wyf8" +
       "sbS2mPFkFinpeDuiBj6KCHY6UZ2VlFqhDAudZRzXYje016SlGyEzo3FCkWHc" +
       "X4mIlQUiKa1xVuxueQMesQQyYt1GwuOo3l9xOm1YJZWPhGZHq/WobWhZWTKe" +
       "0NOaJ+G8PWTJVcz0CFNuYxVcMkaEVa6Qfa40rTGlbYOac/2oizQ5oYWZWCro" +
       "HYaiYiXTEsaasJOyreBNi+OnjqZnukg1vcZUGPqJ5635rrzMFtxkvvYtJrHr" +
       "eNMhOmCaZxRTIxthZciExrI6VXlxsYXbODafoF1yve4pZZdcJ2KLDJAubLfG" +
       "KNrn22S3qVINJuvBpW17pWtYjy5LOggJ1taaJaxgTZWaOMowCod00u1IdLx2" +
       "T8NglXG4Ks1vxu1agJHdDa+WWHSD8EhnLJvdqAdrlZmhKfGCmrXd8iIRKH+L" +
       "dZedub7tTZNo7W9jvbNiiMEGT7NBqlMjI/UqYiB70nq4wDUtcYZhuWSbfrha" +
       "dRIsXIUmWu0zTs92zVFbGJXUES53yMEKK1VmnFyFx7BKtMcygiJxv9FtbStB" +
       "FDeiYNlDynWprzPOROm3Jqky9RFPpNuGu2kP7Eqj0oADtTG2sXF31iHTEeW4" +
       "40aSKD2EpStlXhxL+lDdyiGFbftufWvjaZ9Y2KnKagSzbZlNGEFZfR12hxu0" +
       "Y0zRqEfj8xoKVitKUmlNYzN4mzLVdVziO2R91Wl3+c3AH5a7q7LE9+o25adR" +
       "HysDBYoke5B2VYQcCDoZDmZoy44RmbUmftTBBEW0uiuJWbsr2upTg1W0rNNN" +
       "Zp1W2yNTMjewm+px34skCV22XUVU6612nbHdnuJ5gjfRM4Qr10tuKeA7CdyJ" +
       "Oywwf1qatGemUJ8mvrpV9Hbdk7pOz2LN2qQrB5XRUOl3SqO+q8FzLa6GU7O3" +
       "NR3bX6c9JWIQlE8HgtnIfCXRVLXXSUslYsGbdtj3XazT82w6tUeT0sxWCG65" +
       "yZSsjEgmFaqDrRjp5eFkOJ/ZS6487RNTeBhtav7QdDuZIozEbq9XqRJotRQi" +
       "aA1uULZAaxtKVcSYNAbGAGweMmaRYdMQFVtWzy4vonjURINEc1jXXLbJUtpv" +
       "IfMyK46nDjZZbzpGPRa3oWGMoq4+kNbrec3CFZjj3R7LVLfJmMNTtT5ntXQo" +
       "0W2ivoQbrTKJ1f22UK+xm2qtrYwWmTugYcFZ0Fmz2RVrSg+zw8aKR2ByrDPD" +
       "8txECD2ukVZLXTqqOm5zTNozOAoJFMJEMm+u0bg145V5AieGtFUSlse7nhGR" +
       "rpgOHWGG1hqGhbtLjB4vkTmSiIqiSsgUl5Fyeco3ZrPhsl1y8IUYb6MtEbOl" +
       "KksEQ7kdlmCn26lZuuNjNVdi2NG0t0KrAy/rBEpLg0k1a3dKQpSZFU4S4CYq" +
       "j1KqjdU6Qr0k1xJ2gpd5ouGsFoNVm2yzGt7L2uVAY8VyI9NWk5rl2qHH+hji" +
       "4DV1m8I268VVPijPSIXv+JhTHsUcWD+zfqak/bmIr/x2dTzREgKeOKojN8tM" +
       "C2kO0lXDdZyezqjqikWZCquXKK+7cfDhmHb1+bwTwfKkZw48Dlb6xLwkbRR9" +
       "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" +
       "iRTiKwAA");
}
