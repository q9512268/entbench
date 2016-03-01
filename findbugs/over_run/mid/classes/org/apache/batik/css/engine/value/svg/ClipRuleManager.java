package org.apache.batik.css.engine.value.svg;
public class ClipRuleManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_EVENODD_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          EVENODD_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NONZERO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          NONZERO_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_CLIP_RULE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NONZERO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ClipRuleManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVZe3BU1Rk/uyGbB4E8IIEGCCQkUF67pYhMDaWEAGZxQ7YJ" +
                                                              "Mja0LHfvnt1ccvfey71nkyWaInRaqDOljgSLVfin0AeD4rQ6dexIsQ/FscpA" +
                                                              "bYsyxap/aKvMyB8aW9ra75xzd+9jH2mGzjQz9+Tmnu873+t3vu87J2euo1JD" +
                                                              "Ry2aoMQEP9mrYcMfpu9hQTdwrFMWDGMbfI2ID7x1ZN/47yv2e5GvH00fEIxu" +
                                                              "UTDwZgnLMaMfzZMUgwiKiI2tGMcoR1jHBtaHBCKpSj+ql4xgUpMlUSLdagxT" +
                                                              "gu2CHkK1AiG6FE0RHDQXIGh+iGkTYNoEOtwE7SFUJaraXouh0cHQaZujtElL" +
                                                              "nkFQTWi3MCQEUkSSAyHJIO1pHS3TVHlvQlaJH6eJf7e82nTEltDqHDe0PFn9" +
                                                              "8c0HB2qYG2YIiqISZqLRiw1VHsKxEKq2vm6ScdLYg76OSkJoqo2YoNZQRmgA" +
                                                              "hAZAaMZeiwq0n4aVVLJTZeaQzEo+TaQKEdTsXEQTdCFpLhNmOsMK5cS0nTGD" +
                                                              "tQuy1mbC7TLx6LLA2Pd21vy0BFX3o2pJ6aPqiKAEASH94FCcjGLd6IjFcKwf" +
                                                              "1SoQ8D6sS4IsjZjRrjOkhCKQFEAg4xb6MaVhncm0fAWRBNv0lEhUPWtenIHK" +
                                                              "/Ks0LgsJsLXBspVbuJl+BwMrJVBMjwuAPZNlyqCkxBiOnBxZG1vvAgJgLUti" +
                                                              "MqBmRU1RBPiA6jhEZEFJBPoAfEoCSEtVgKDOsFZgUeprTRAHhQSOEDTbTRfm" +
                                                              "U0BVwRxBWQiqd5OxlSBKja4o2eJzfevaw/cqXYoXeUDnGBZlqv9UYGpyMfXi" +
                                                              "ONYx7APOWLU09LDQ8NwhL0JAXO8i5jQ/v+/G+uVN5y9wmjl5aHqiu7FIIuLJ" +
                                                              "6PRLczuXfKGEqlGuqYZEg++wnO2ysDnTntYg0zRkV6ST/szk+d4XvnL/afy+" +
                                                              "F1UGkU9U5VQScFQrqklNkrF+J1awLhAcC6IKrMQ62XwQlcF7SFIw/9oTjxuY" +
                                                              "BNEUmX3yqexvcFEclqAuqoR3SYmrmXdNIAPsPa0hhMrgQVXwtCD+w34TNBQY" +
                                                              "UJM4IIiCIilqIKyr1H4aUJZzsAHvMZjV1EAU8D+4YqV/TcBQUzoAMqDqiYAA" +
                                                              "qBjAfDIgGkYAKwnQMDAkyCkcMIYSgCFJ603JuFtQACK6n+JP+79JTlOfzBj2" +
                                                              "eCBcc93JQoZ91qXKMaxHxLHUhk03noi8zIFIN4/pTYJWg3g/F+9n4v0g3s/F" +
                                                              "+5l4P4j3u8Qjj4dJnUnV4ACB8A5CooBMXbWk72tbdh1qKQFkasNTIDaUdFFO" +
                                                              "5eq0MkqmDETEM5d6xy++Unnai7yQdKJQuazy0eooH7z66aqIY5C/ChWSTDIN" +
                                                              "FC4defVA548N79++73NMD3tFoAuWQjKj7GGax7MiWt2ZIN+61Qff+/jsw6Oq" +
                                                              "lRMcJSZTGXM4aappccfYbXxEXLpAeDry3GirF02B/AU5mwgQSEiHTW4ZjpTT" +
                                                              "nknf1JZyMDiu6klBplOZnFtJBnR12PrCwFdLh3qOQwoHl4Is83+xTzt+5dW/" +
                                                              "rmKezBSJalt178Ok3ZaY6GJ1LAXVWujapmMMdH8+Fj5y9PrBHQxaQLEwn8BW" +
                                                              "OnZCQoLogAe/eWHP629eO/ma14IjgcqcikKTk2a2zPwUfjzw/Js+NJnQDzyp" +
                                                              "1HWamW1BNrVpVPIiSzdIcjJsdwqO1rsVAJ8Ul4SojOle+Gd128qnPzhcw8Mt" +
                                                              "w5cMWpZPvID1/TMb0P0v7xxvYst4RFpkLf9ZZDxzz7BW7tB1YS/VI73/8rxH" +
                                                              "XhSOQw2AvGtII5ilUsT8gVgAb2O+CLBxlWvudjq0GnaMO7eRrRmKiA++9uG0" +
                                                              "7R+eu8G0dXZT9rh3C1o7RxGPAghbg8zBkdrpbINGx1lp0GGWO+l0CcYALHbb" +
                                                              "+a1frZHP3wSx/SBWhORq9OiQANMOKJnUpWVvPP/rhl2XSpB3M6qUVSG2WWAb" +
                                                              "DlUA0rExALkzrX1pPddjuByGGuYPlOMh6vT5+cO5KakRFoCRZ2Y9tfZHJ64x" +
                                                              "FHLYzcnmxgU5uZG169a2/uDqo+/8cvwHZbzYLymcy1x8s//RI0cPvP1JTiRY" +
                                                              "FsvTiLj4+wNnHmvsXPc+47fSCeVemM4tOpBwLd7Pn05+5G3x/daLyvpRjWi2" +
                                                              "xttpSYGd3A/toJHpl6F9dsw7Wzvex7Rn0+VcdyqziXUnMqvYwTulpu/TXKib" +
                                                              "Q6O4Dp7FJuoWu1HnQeyli7G0sfGzdFjGQlhCUIWmqwS0xNDO+gzWhxPQRFIE" +
                                                              "OZ2Vw9DSWEQO8LKSazCW2QQtm7g688YXAM2TMB3X0CHI5bbnQ3A6vx0e+rrc" +
                                                              "0pf9+IrsRhuMEd2Z8wr1wqyPP3lg7ESs59RKDuI6Z3+5CY5Pj//xX7/zH/vL" +
                                                              "S3nalAqiaitkPIRlm8wyENmcs3W62VHBwuGay+MlVx+aXZXbUdCVmgr0C0sL" +
                                                              "7zG3gBcP/K1x27qBXZNoFea7HOVe8ifdZ166c5H4kJeddjjsc05JTqZ2J9gr" +
                                                              "dQzHOmWbA/It2dDOoCFbBM8qM7Sr3JC34NRGh+1OFFcWYS1SRxJF5iQ6RAma" +
                                                              "IRlBZQDOqbCZoMNhR1FWeWyBplcTfamoQcK6lISuYcg8OJ1tGN/zm7KRjZlD" +
                                                              "UT4WTnmX0X3x2a53Iyxo5RQVWVfZENGhJ2zdTg0dVlCgF8nALo0Co3VvDj72" +
                                                              "3uNcI3e6dRHjQ2MPfOo/PMY3AD8cL8w5n9p5+AHZpV1zMSmMY/O7Z0d/8ePR" +
                                                              "g17T9/0ElUVVVcaCko2NJ1ueGtx+5Nr6Vh7/+75vXemBXjOIylOKtCeFgzEn" +
                                                              "DMuMVNTmWOtEbYHS1Ju2XAR5lmpmdWRJTCySxHLLMP2wnn3e6QQ6zbN3mGi9" +
                                                              "Y/JAL8RaBMz7i8x9gw73ETRTMjoUKSkQ2utlkE7nkpYDRv83DmiDp8O0omPy" +
                                                              "DijEWsTI7xSZ+y4dDkGRl+jdFENmAfO/fcvmV9OpJni6TBu6Jm9+IdYiJj5S" +
                                                              "ZO5ROoxBL5zAJGN39lw1aO5i+kuxvcMRrkQybxZtu5P+OWzbMEdv2WF1dKoZ" +
                                                              "nrBpdXjyDivEWsQpp4vMnaHDKafDtkKOyXRJNaz3pr2i2Q1Z/vjhLfujlk4t" +
                                                              "gOce06h7Ju+PQqxFbH6myNyzdPgZ98dGHBdSMm+bM/5YPHHXaNEzNz11y26q" +
                                                              "p1ML4YmYtkYm76ZCrEVc8UKRuQt0eJ6g6eCmYAwrBI7VmHd4X7ZM/9XkTU+D" +
                                                              "610XYvQIODvnvp7fMYtPnKgun3Xi7j+xS5nsPXAV9B3xlCzbTyi2d5+m47jE" +
                                                              "DKni5xWN/bpIUNt/dWcHCQNGZsKrnPUyQc0TssKxZSgLDpPxDwTNKcIIxxb+" +
                                                              "Yue5AgUuHw+oBaOd8irsYDclaMF+2+muEVRp0YFQ/mIneQtWBxL6+raW2Q6r" +
                                                              "JnaXBQ8znmmP82yThUv9RHCxHYcWOrpE9k+fTBOV4v/2gY71xJat9964/RS/" +
                                                              "HRNlYWSErjIVWid+B5c9MzQXXC2zlq9ryc3pT1a0Zbo6x+2cXTeGYqge7Car" +
                                                              "0XVdZLRmb41eP7n23CuHfJehH92BPAL05jtyz+VpLQUHmh2hfE0inKjYTVZ7" +
                                                              "5Tu7Ln7yhqeOXX8g3lY2FeOIiEfOXQ3HNe37XlQRRKXQtOI0uzTYuFfpxeKQ" +
                                                              "7ug5fVE1pWT/PzSd7jGBVgLmGdOh07Jf6cUpQS25nXXuZXKlrA5jfQNdnS4z" +
                                                              "zXXKSmmafZZ5doiXbeppgGMk1K1p5n1iSSvzvKaxPPIRK97/AaVUF0XZHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "G8T5JYDNH972udf97pPfzg/t/g8za2KCBykAAA==");
}
