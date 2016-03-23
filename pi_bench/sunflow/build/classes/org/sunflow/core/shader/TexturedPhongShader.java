package org.sunflow.core.shader;
public class TexturedPhongShader extends org.sunflow.core.shader.PhongShader {
    private org.sunflow.core.Texture tex;
    public TexturedPhongShader() { super();
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
      ("H4sIAAAAAAAAALVYfYxUVxW/M/v9xX4Ay/cCy0LDR2dKLdZmEVkWtgzOwoSl" +
       "qEtlufPmzsxj37z3eO++3dlFtJBUsIkEyxawKfsXTSuhBRsbNdoG02jbtJq0" +
       "VttqSo2aiFZiibE1ouK5977vmV0k0UnefW/uO/fce879nd859124hqpMA3UQ" +
       "lcbomE7M2BaVprBhkkyvgk1zF/QNSacr8F/3Xt1+XxRVD6IZeWz2S9gkfTJR" +
       "MuYgWiSrJsWqRMzthGTYiJRBTGKMYCpr6iCaLZuJgq7Ikkz7tQxhAruxkUSt" +
       "mFJDTluUJGwFFC1KwkrifCXxnvDr7iRqlDR9zBOf6xPv9b1hkgVvLpOiluR+" +
       "PILjFpWVeFI2aXfRQKt1TRnLKRqNkSKN7VfW2S7YllxX4oLOS80f3TiRb+Eu" +
       "mIlVVaPcPHMnMTVlhGSSqNnr3aKQgnkAfRlVJFGDT5iirqQzaRwmjcOkjrWe" +
       "FKy+iahWoVfj5lBHU7UusQVRtDSoRMcGLthqUnzNoKGW2rbzwWDtEtdaYWWJ" +
       "iY+tjk+c3tvyXAVqHkTNsjrAliPBIihMMggOJYU0McyeTIZkBlGrCps9QAwZ" +
       "K/K4vdNtppxTMbVg+x23sE5LJwaf0/MV7CPYZlgS1QzXvCwHlP2vKqvgHNja" +
       "7tkqLOxj/WBgvQwLM7IYcGcPqRyW1QxFi8MjXBu7PgsCMLSmQGhec6eqVDF0" +
       "oDYBEQWrufgAQE/NgWiVBgA0KJo/pVLmax1LwzhHhhgiQ3Ip8Qqk6rgj2BCK" +
       "ZofFuCbYpfmhXfLtz7Xt648fVLeqURSBNWeIpLD1N8CgjtCgnSRLDAJxIAY2" +
       "rkqewu0vHIsiBMKzQ8JC5rtfur5xTcflV4TMgjIyO9L7iUSHpHPpGW8s7F15" +
       "XwVbRq2umTLb/IDlPMpS9pvuog4M0+5qZC9jzsvLO3/yhYfOkw+iqD6BqiVN" +
       "sQqAo1ZJK+iyQoz7iUoMTEkmgeqImunl7xOoBp6TskpE745s1iQ0gSoV3lWt" +
       "8f/goiyoYC6qh2dZzWrOs45pnj8XdYRQDVyoEa56JH78TtHn4nmtQOK6HE8Z" +
       "GjPdjAPZpMGt+bhpqVlFG42bhhTXjJz7X9IMEjfzOEOM+C6IGoiETCqvqbkB" +
       "3hdjANP/f6qLzKqZo5EIOHxhONwViJStmgKyQ9KEtWnL9WeHXhNQYvC3/UHR" +
       "apg0Zk8aY5PGxKSxMpOiSITPNYtNLjYWtmUYAhwYtnHlwBe37TvWWQGI0kcr" +
       "wadMtDOQaXo9FnCoe0i62NY0vvTK2peiqDKJ2rBELaywxNFj5ICSpGE7ahvT" +
       "kIO8VLDElwpYDjM0iWRgvVOlBFtLrTZCDNZP0SyfBidRsZCMT50myq4fXT4z" +
       "enj3V+6KomiQ/dmUVUBcbHiKcbbLzV3hqC+nt/no1Y8unjqkefEfSCdOFiwZ" +
       "yWzoDKMh7J4hadUS/PzQC4e6uNvrgJ8phngC6usIzxGgl26HqpkttWBwVjMK" +
       "WGGvHB/X07yhjXo9HKat/HkWwKKBxVsHXE12API7e9uus3aOgDXDWcgKngo+" +
       "PaCffednf/wEd7eTNZp96X6A0G4fUzFlbZyTWj3Y7jIIAbn3zqROPnbt6B6O" +
       "WZBYVm7CLtb2AkPBFoKbH37lwLvvXzn3VtTDOYVUbaWh4im6RlY6zDKVkTDb" +
       "Cm89wHQK8AJDTdcDKuBTzso4rRAWWP9sXr72+T8fbxE4UKDHgdGaWyvw+udt" +
       "Qg+9tvfjDq4mIrFM6/nMExP0PdPT3GMYeIyto3j4zUXffBmfhUQA5GvK44Tz" +
       "KeI+QHzT1nH77+LtPaF397JmuekHfzC+fBXRkHTirQ+bdn/44nW+2mBJ5d/r" +
       "fqx3C3ixZkUR1M8Jk9NWbOZB7p7L2x9sUS7fAI2DoFGCOsLcYQCrFQPIsKWr" +
       "an71o5fa971RgaJ9qF7RcKYP8yBDdYBuYuaBWYv6ZzaKzR2thaaFm4pKjC/p" +
       "YA5eXH7rthR0yp09/r0531n/1OQVjjJd6FjgsurCAKvywtwL7PM/v/cXT33j" +
       "1KhI7SunZrPQuLn/2KGkj/z27yUu5zxWpuwIjR+MX3hifu+GD/h4j1DY6K5i" +
       "aYICUvbG3n2+8LdoZ/WPo6hmELVIdiG8GysWC9NBKP5MpzqGYjnwPljIiaql" +
       "2yXMhWEy800bpjIvMcIzk2bPTSH2YpUDmuvQmHP3s1cE8YcEH3IHb1ex5k6H" +
       "LGp0Q4bDEgmxRcM0SimqcOTnQulVkrPtZC2Ik7WfYs02MaK7HEzFqztYs9pd" +
       "B/9Vh2sjP2t5OEQs2BZNVb7y0vvckYnJzI4n1woktgVLwi1w4nnml/96PXbm" +
       "N6+WqUvqqKbfqZARovjmjLIpA9jv55W9B6T3Zjz6u+935TbdTjHB+jpuUS6w" +
       "/4vBiFVTh1N4KS8f+dP8XRvy+26jLlgccmdY5bf6L7x6/wrp0Sg/xgiElxx/" +
       "goO6g7iuNwgARd0VQPcyFwAz2cbOg6vVBkBr+dxcBjtuxptqaCg3RO0dtTHd" +
       "UYJp7hoCpzHGh45Yu19sQNx7Ugm+LDJN9uEbvw8StaVnIPSClSkDyICVNqGK" +
       "lAtQNIzYB6m7U/ukY12p3wv8ziszQMjNfjr+9d1v73+d73Qtg5brXx+sAIK+" +
       "eqhFOO4m/CJw/ZtdbLWsg92B1nrtU9ES91jEMsG0lB4yIH6o7f3hJ64+IwwI" +
       "83dImBybeORm7PiECEZxtl5Wcrz1jxHna2EOa/jqlk43Cx/R94eLh37w9KGj" +
       "UXtvPg+UmNY0hWDV3buIm+tmBd0u1rr5a80/PNFW0QdhnkC1liofsEgiE4R6" +
       "jWmlffvgHcc94NurZj6nKLLKSbScPPE05Plf5HjW0aPz/gfdGOEhscBOIE4i" +
       "uc3wmmpoCPyOA+24WVQSXuxIJ6uMFSGzMKmvThM+j7DmMEX1OUI3y9msZRJH" +
       "8xy/ZrmAc4RVNPZnHu7JI/8LTxYpmlnmSMpqqbklX7rE1xnp2cnm2jmTD7zN" +
       "k4H7BaURYjRrKYo/2/ueq3WDZGVudaPI/Tq/TYRM9Z2VgVbEA1/8SSF/mqKW" +
       "sDxFlezmF3ucogafGGWw5U9+obOQ/0GIPU7qjuOXTXVy97mnGAlmbHdPZt9q" +
       "T3xJflmAb/jXRycgLfH9EQ7xk9u2H7z+ySfFqUxS8Pg409IAYSgOiG6OWzql" +
       "NkdX9daVN2Zcqlvu8EOrWLAXGgt8yOwBkOsMBfNDRxazyz25vHtu/Ys/PVb9" +
       "JjDbHhTBgKQ9pSVjUbeguNiTLKUbqAf4Wap75eNjG9Zk//JrXpSjklI8LA8l" +
       "8cl3EpeGP97IP3dVAfWRIq9lN4+pO4k0YgS4awYDKGbfIbkfbPc1ub3sDE9R" +
       "Zykjl375gAPLKDE2aZaasdmvwesJfAZ1ygJL10MDvB5f1hoXhCkSVMVQsl/X" +
       "nYR1U+eRejDMQLyTD/42f2TNc/8BgJEmR4gYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gjyTjc5oSmzoDlwtK2V6LMINVB127VlV5cCp683ZcUx9ZSfiu/PD/8ENEzgI" +
       "Zy9mr+AkuH31WNa8/qDukn/OnbyVOFriPKx7Qdnp9qFbXRzlJ9uPvfv689Lk" +
       "46WdvXqhEEG3Ra73Y5a8kq0jpHYApadufYof5fdmh3WsL7z7nx6k36K94xVU" +
       "5x85wedJkr89euFL/TeIv7wDnT6oat1wo3cc6erxWtbFQI7iwKGPVbQeOtDs" +
       "vZnGXgO++2q+++YV8puXs3Ir2K79iXLszp4C94o+D99QqMr1IEdykNV798Hu" +
       "OwpGbZ8gE8xneOZlCr4/mzVJBJ2LPYmPtncBbztiaXwEnRdc15J559AKNz+s" +
       "HnF0lnwgPlBbrqXX7hUD94uC/wdqO7V3NbSnj4duUFt21aQ7anYbLecUnnsZ" +
       "tVzPmvdH0EVVjjq6osShvE/5/qOUdZtX5ayuv3f9nKvnF1+JeoDu773JlVhW" +
       "33/ghpv27e2w+OnnL124//n5X+a3Qgc3uLcR0AUltqyj5dgj/XNeICt6Lt1t" +
       "2+Kslz8+ekKkI3d1WaUy7+Rcf2QL/+sRdPkkfASdyR5HwX4jgm4/AgbMaK93" +
       "FOg3I+g0AMq6n/D2FfzErW4Oj6gnOXU8bh3o/p4fpvsjoe6JYwEq//fDfjCJ" +
       "t/9/uCZ+5vnh+J0v1T++vcgSLT5NMyoXCOj89k7tICA9dktq+7TODZ78/l2f" +
       "ve31+8Hzri3Dh/Z+hLdHbn5r1LW9KL/nSX///t990yee/3peiP1vPzUJz5Yi" +
       "AAA=");
}
