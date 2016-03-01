package org.apache.batik.css.engine.value.svg;
public class ColorRenderingManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZEQUALITY_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZEQUALITY_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZESPEED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZESPEED_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_COLOR_RENDERING_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ColorRenderingManager() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "U83w9Zla903cYIVYixjlTJG5s6w57TbYFogxVpVUw2tvViua1ZBtjx/etj1q" +
       "2dQ8+CKmUpGJ26MQaxGdny0y9xxrfmbYYwNJ4LRklM2WPRaOXzXa9NxMT9+2" +
       "merZ1Hz4sKkrnriZCrEWMcWLReYusuYFiqaCmbriRKZwrSZGhfcVW/VfTVz1" +
       "DEX1eZ/F2EVwZs47vvH2LDx5srp8xsl7/8SfZrLvw1VQfSTSkuS8pzj6AVUj" +
       "CZGrU2XcWlT+6xJFbf/V+x2EDWi5Iq8ZrFcoah6XFS4vQ1mImIx/oGhWEUa4" +
       "vBgdJ89VSHP5eEAsaJ2U1+AceylBCv7bSXedokqbDjY1Ok6St2F1IGHdd1Tr" +
       "UKwY31w2SEx/ZnzuG04WNPXjgcZxKZrvqhX5P4OsUipt/DsI6taTm7fcd/PO" +
       "08YbmSDhkRG2ymQooIyXuOzNobngatZagc5Ft6Y+VdFm1XauNzqnbBzLkEP4" +
       "e1aj59FIb82+Hb1xavX5Vw8HrkBVuh35MFTo23Nv5xk1Ddea7eF8pSLcq/h7" +
       "Vnvluzsvffqmr44/giCjuGwqxhEVjp6/1ptQ1e/7UUUXKoXSlWT408GGPXIf" +
       "EYY0V+UZiClpOft/o6nsjGF2PLllTINOyY6y51OKWnLr69wn5UpJGSbaerY6" +
       "W2aK566VVlXnLLfskJG8maUBjtFwt6qar4oli7jlVZVHk495Cv8P7jDlp/Ed" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "KmWYtN9gzIY/rxSxSUcYU2Qv4YujTjeqy6iOsXTAFbtGVBVaySgEnkF2p5w2" +
       "idzmUOhba0ZsrmaBt5RH2LCtFqWmrcZRzZSYOVUO/XVU6QpIkZXLnQaM4OEq" +
       "xAguClaqbM60UJoBd1OHKJOWI4byw1RoRxRhtvsbVNJ6SIB28ElLqmNYGV1X" +
       "ChWk7LuNWnkGtw22F00DWUX7ZjIXeLi1qhcKDDpgNLD0dJpjsEzUNoRaptM4" +
       "4OjlpmkGyBDDJxRVJFchj/IjTLFarXSK0QHNrDeRVa7207rsTQG4i2RH4wWz" +
       "sm6oq3IjYpY+bI5Lq+k84e16e+JbRdiqrztViQlMSXLJEG1X+6oYtWm7yGcw" +
       "ofbwjlkSF9Ok0vEqzLhVrrTKIqFTsh+3+2XRErgQ6YqKmIrumGJlUittCkIQ" +
       "Iav6Rq6GQ7S2juzy0lsj5Fpdx01sWV7M+6k2D5DZur0OHZ7kW5q2UhyJ7Daa" +
       "LQGt1Hszv8F1CARthRq14JxW04MlB6dFsCXT+VKPM5comtQqgmQWo5GSDj2z" +
       "NRLLlWlVZfucSk30drGJbwRNmVtxp88lw+kIKbfqXoq3mVqZ2UTlrjbpzZXm" +
       "mu5vbBNtOFVmPhw5A6Rf7qUBXx0uyTEBt5FAQRPEYmLYpoMWwpEFs8EOu3y1" +
       "QC4LTlHuUfONXUxTpo7pM3czTeu4hPFpI0aJ1aYpy+UksVe2C3en0+JIJMsy" +
       "Xa12FTmNMWUzW9UdHcBCAmAupGmqOVlUwezUlsR0xJZ61aqEEjbXXoYImBhI" +
       "GveoQVhrVi2p7rUZjzBhXZVKQVWdl+pYuYhPpZEOe0pHKw9XJk0idXhTdcxy" +
       "hzUJYuZYRrc1UTvE0mjb5tQgJuyIn1TtgNGScMXOkSZXk2VqPuy7Q70rM2Bp" +
       "7rMto7kc8XrJA+7Cy5sl2Na0LCWtFQit7E2KMZwY7HBRHJIYMFsksp5TrfJz" +
       "2KsMV125D7vVkdCpNRKuWhQqbLucpmW4QdurOr2G7R638LxeJzLq6sgYp6gZ" +
       "kLPN1KTcaqhQViL6vrPmbDqs8CYXjVliVrPcEY0kEdPk6wiaFAMSHsyqUh9t" +
       "bZreHJt3ClqMxwWXiYN1WYzxFgosAKiVSJTBaHpScdAwvEGCc0w58jAFj2eh" +
       "NFys02UzbHSLKOvEVbJYCZeEZaUxYbLcQi9MxnwXrxpTNtU9oSu7Yr05YC0K" +
       "ExyRWZkmKcpajeEXRQ4eesvp3Cj1RxKb8ETN3KxmfVSpDhBRJWtVj13VZ2qM" +
       "K3Ecj0Ww9o1Rf7zWHC/wxuvOrCealMQN27No1heac11syjpLo7WwIijMptFN" +
       "1t14SM1GxWS42qCVmdLueBTeXA3jNdxNll6VoaJ2F3XJIApVsCwwUzmaI3CB" +
       "IQujMjptaGRvbfV6HQ0P+HJ5ta4JdsurS+2Z0V4X4bqiFMp+zDd9ySLW4XAd" +
       "tcNBFHUjsrt0a/yqHTALCUkEszcV/WiyWtPccoD29bZFNA19OLMWUyExVTgW" +
       "m0MplWyua7rzaboBUK/TKmM2jaVBzejh3IksPTYqM7aqr2dBAxu6IY2MlosG" +
       "Wk9HrbBOCYsZNe6XRxg16xhuwa2vRKlkbshur74mav4QxEkeA4dISYAto1hK" +
       "lgpfIqlNOmDjlHDxlJXpTbtMWibpaPwQn9mujZZm7apuWjEypqhaNekKdLUU" +
       "qRVb3jALUW4N58tlywNToF5OGrwpNIplcdEBY5+uzGmXrAa1pIpOlwvCUVPO" +
       "5dgECWNOj4QS3wpXKSyHq5KHSKN6AYSNrEt2kVp/JKSkZK+L60aa+oq1XCyS" +
       "QbdCjw2zj8yYsTCcb+ZCY5D2p40CYsk+X6I2laBn+Lav85iPz/rijB7LiyiI" +
       "FgTwO8xa+vq4xyf+hCc1ReRmMKdMuU2pjc9LMg8TCM4lfFBB45hC6HZaDXy3" +
       "ngYmCtcnCu/TcVLiRspkOjGiSd3drGpNjl1hPOmzyFycmdNCLe0SSwXmCimC" +
       "t2d6tePVeZ8QHUGrzYlJJR6VrI7VSWGH1GY4K1Tilip16w1uQjFVGW8GQhdh" +
       "S4WmKK/NFhajy8lclhzDW7ZXi9LQqE1ChCh1SEqSSlOf7SWLcilBJngK8/Ym" +
       "AlNuNmDmK1Xk0x7vx542rzKVYcDqbgi3g04tFKYW2LFIMDMs1hdLa9LWjDGJ" +
       "rK2R43TW82i4GTgAmYSQF1SxSoS1RYGTCKs0F6LBxrOXrQ1t4ExFLgmraoPo" +
       "LOtIgVqWUiGeV7mkTvlGi4s0sF4SUwcpD+JqapTakiygMlF3J7TowRrK2bEZ" +
       "bYJYUTzLr1RgVcdWEZl4qYZzK7cGl9xwVJJhlAVxas+ZT8zZtFKskyQz7yj4" +
       "AqBDgeV1zHSHSgg7NTtYkQTC0KY57QyG60VtXS0NezOb9gFW2lXW7ZKTpSD7" +
       "i9oMEXrVWo3jzLlN00pgdMm6JbCtVUgkYc0T/Ipj6ujK5HiOMiqNKhaDDcaq" +
       "bbowLoGd6xuyLa3ywk4Vbs4PUPYv/1YmmlWMXsBuelt1b5Y8sH9Ylf+duspB" +
       "+KHDQig7IXj1le708tOBT7zzyaek4SdLJ3cPWYUQuiF03Nebciybh5o6DVp6" +
       "7ZVPQvr5lebB4d9X3vmvd07fqD32Aq437j4m5/Em/6D/9FfJ14jvPwlds38U" +
       "eMll61Gmi0cPAM/4chj59vTIMeCr9y17S2ax14CvumvZ6uWvGC7rBSdyL9iO" +
       "/VXOsN96lbq3ZUkSQrfoQcfWZF8PZYnxnfz6Omd40yGHeSyETi8dx5QF+8CZ" +
       "0uc7mjncZV4QHtU+O/h8eFf7h1967d9zlbrfypJ3hdAr9KBp65YQZpcPe+pn" +
       "dW8/0POJF6vnA+DDdvXEXno9P3yVuo9myftD6LyevWXIj+quoOUHXoSWZ7PC" +
       "u8DX3dWy+9Jr+btXqftkljwVQmdVOdxTb/9u75gfX6PvPjLJtf6dF6H1+azw" +
       "XvCNd7Uev/Raf/4qdV/Ikk8f1Xqwiz+jAxU/8yJUzJeAe8DH76rIv/Qqfvkq" +
       "dc9kyR9vVWzLihCZ2yubvWuBB5//WuOAPrfGn7wIa9yaFd4PPmHXGsJLb42v" +
       "X6XuG1nylRC6CVijI8l2mF0cbJ8UUQcaPvtCNExD6NbLPkrIblXvuOQV1fbl" +
       "j/iZp85ef/tT7N/m9/L7r3NuoKHrlcg0D1+CHcqfcn1Z0XNFbtheibn5v78O" +
       "oQd+odcTYO6CNFfhW1vWb4fQvc/LGu7e6Rxm/IcQeuVVGEPo1DZzmOc7YLW4" +
       "HA8QC6SHKf8phM4dpwRS5P8P030/hM4c0IFOt5nDJD8ArQOSLPtDd8/ry89v" +
       "rgP32B3P9MTRSG3fXc4/n7scCu7uPxKS5U/x9sKnaPsY71Hxs091B295rvbJ" +
       "7dsH0RQ2m6yV62no9PYZxn4Idu8VW9tr6xT10M9u+twND+yFizdtBT6YZYdk" +
       "u/vyjwtwyw3z5wCbP7r9Cw//3lPfya/v/g8BZSsBIykAAA==");
}
