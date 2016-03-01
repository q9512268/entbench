package org.apache.batik.css.engine.sac;
public class CSSClassCondition extends org.apache.batik.css.engine.sac.CSSAttributeCondition {
    public CSSClassCondition(java.lang.String localName, java.lang.String namespaceURI,
                             java.lang.String value) { super(localName,
                                                             namespaceURI,
                                                             true,
                                                             value);
    }
    public short getConditionType() { return SAC_CLASS_CONDITION;
    }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        if (!(e instanceof org.apache.batik.css.engine.CSSStylableElement))
            return false;
        java.lang.String attr =
          ((org.apache.batik.css.engine.CSSStylableElement)
             e).
          getCSSClass(
            );
        java.lang.String val =
          getValue(
            );
        int attrLen =
          attr.
          length(
            );
        int valLen =
          val.
          length(
            );
        int i =
          attr.
          indexOf(
            val);
        while (i !=
                 -1) {
            if (i ==
                  0 ||
                  java.lang.Character.
                  isSpaceChar(
                    attr.
                      charAt(
                        i -
                          1))) {
                if (i +
                      valLen ==
                      attrLen ||
                      java.lang.Character.
                      isSpaceChar(
                        attr.
                          charAt(
                            i +
                              valLen))) {
                    return true;
                }
            }
            i =
              attr.
                indexOf(
                  val,
                  i +
                    valLen);
        }
        return false;
    }
    public java.lang.String toString() { return '.' + getValue();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVYfWwUxxWfO9vnDwz+AuMaMGAMEk5yW4u4aWTaxjgYG874" +
                                                              "ZBPU2k2Oud053+K93WV3zj6cOoRUKSitaAQmpW3wX0RtIxKiqlGrVkGuWjWJ" +
                                                              "0hRBozYfatKqfyT9QAr/xK1om76Z2dvd2zuboP5RSzu3nnnvzbyv33uzF6+j" +
                                                              "CttC7SbWFRylR01iR+PsPY4tmyh9GrbtAzCbkJ/405lji7+tPh5GkTG0Ko3t" +
                                                              "IRnbpF8lmmKPoQ2qblOsy8TeT4jCOOIWsYk1halq6GNojWoPZkxNlVU6ZCiE" +
                                                              "ERzEVgw1YEotNZmlZNARQNHGGD+NxE8j9QYJemKoVjbMox5DawFDn2+N0Wa8" +
                                                              "/WyK6mOH8RSWslTVpJhq056che4wDe3ohGbQKMnR6GGt2zHE3lh3kRnaX6j7" +
                                                              "6OaT6Xpuhias6wblKtojxDa0KaLEUJ03u1sjGfsIegSVxdAKHzFFHbH8phJs" +
                                                              "KsGmeX09Kjj9SqJnM30GV4fmJUVMmR2Ios2FQkxs4YwjJs7PDBKqqKM7ZwZt" +
                                                              "N7na5t0dUPHsHdLctx6q/2EZqhtDdao+yo4jwyEobDIGBiWZJLHsXkUhyhhq" +
                                                              "0MHho8RSsabOON5utNUJHdMshEDeLGwyaxKL7+nZCjwJullZmRqWq16KB5Xz" +
                                                              "X0VKwxOga7Onq9Cwn82DgjUqHMxKYYg9h6V8UtUVHkeFHK6OHfuAAFgrM4Sm" +
                                                              "DXerch3DBGoUIaJhfUIaheDTJ4C0woAQtHisLSGU2drE8iSeIAmKWoJ0cbEE" +
                                                              "VNXcEIyFojVBMi4JvNQa8JLPP9f37zz1sD6gh1EIzqwQWWPnXwFMbQGmEZIi" +
                                                              "FoE8EIy1nbGncPNLJ8MIAfGaALGg+fFXbtx3Z9vCK4JmXQma4eRhItOEfCG5" +
                                                              "6ur6vu33lrFjVJmGrTLnF2jOsyzurPTkTECaZlciW4zmFxdGfvWlR58lfwuj" +
                                                              "mkEUkQ0tm4E4apCNjKlqxNpDdGJhSpRBVE10pY+vD6JKeI+pOhGzw6mUTegg" +
                                                              "Ktf4VMTg/4OJUiCCmagG3lU9ZeTfTUzT/D1nIoQq4UG18GxE4o//UmRJaSND" +
                                                              "JCxjXdUNKW4ZTH/mUI45xIZ3BVZNQ0pC/E/e1RW9R7KNrAUBKRnWhIQhKtJE" +
                                                              "LEqybUtEn4ATSjaWpb7RUe5ZyC6FGyLKYs/8v+yaY7Zomg6FwE3rgyChQX4N" +
                                                              "GJpCrIQ8l921+8bziddEALKkcaxIURdsHRVbR/nWUdg6KraOwtbRoq1RKMR3" +
                                                              "XM2OIIICXDoJ4ADoXLt99MG9h062l0E0mtPl4A9Guq2oWvV5KJKH/oR88erI" +
                                                              "4pXXa54NozAATRKqlVcyOgpKhqh4liETBTBrqeKRB1Bp6XJR8hxo4dz08YPH" +
                                                              "Ps3P4a8CTGAFABhjjzPsdrfoCGZ/Kbl1Jz746NJTs4aHAwVlJV8NizgZvLQH" +
                                                              "/RtUPiF3bsIvJl6a7QijcsAswGmKwYkAgW3BPQpgpicP2UyXKlA4ZVgZrLGl" +
                                                              "PM7W0LRlTHszPPAa+PtqcPEKlnfr4elwEpH/stVmk41rRaCymAlowUvC50bN" +
                                                              "82/+5i87uLnz1aPOV/ZHCe3xIRYT1sixqcELwQMWIUD3h3PxM2evnxjn8QcU" +
                                                              "W0pt2MHGPkAqcCGY+fFXjrz13rsX3gh7MUuhZGeT0P3kXCXZPKpZRkkW5955" +
                                                              "APE0yH8WNR0P6BCVakrFSY2wJPlX3dauF/9+ql7EgQYz+TC689YCvPlP7UKP" +
                                                              "vvbQYhsXE5JZxfVs5pEJGG/yJPdaFj7KzpE7fm3Dt1/G56EgAAjb6gzhuFrG" +
                                                              "bVDGNW+BBoxzsuIaFcWVzXfzgfv1bk4o8XEHswlnR3zts2zosP35UZiCvuYp" +
                                                              "IT/5xocrD354+QZXqLD78ofDEDZ7RASyYWsOxK8NYtEAttNAd/fC/i/Xaws3" +
                                                              "QeIYSJQBa+1hCzAxVxA8DnVF5ds//0XzoatlKNyPajQDK/2Y5yGqhgQgdhrg" +
                                                              "NGd+4T7h/+kqGOq5qqhIeWbyjaWduTtjUm7+mZ+s/dHO782/y+NOBNo6h53/" +
                                                              "s40NnW4A8r9IsNz5A7BAgoU2LNWR8G7qwmNz88rwM12ib2gsrPK7oYl97nf/" +
                                                              "/nX03B9fLVE0qqlh3qWRKaL59iyDLTcXAf0Qb9g8kLrn2mLZO6dbaosxnklq" +
                                                              "WwLBO5dG8OAGLz/219YDn08fug3w3hgwVFDkD4Yuvrpnm3w6zHtOgdtFvWoh" +
                                                              "U4/fZLCpRaC51plabGYlD99217UNzGWb4Yk6ro2WBtASUeHC0lKsy2TngWXW" +
                                                              "DrJhGLJ/glC39PMKwJLZ52V2OxzNJm0at9QMUE05veul5sUjv6ycuT/fl5Zi" +
                                                              "EZT77KErPx14P8E9VsVCwrWTLxx6rQlf8akXBvgY/kLw/Ic97OxsQnSBjX1O" +
                                                              "K7rJ7UVNk6XF9mUuj4UqSLON700+/cFzQoVgrx4gJifnnvg4empOpIu40Gwp" +
                                                              "ulP4ecSlRqjDhvEcz6BlduEc/e9fmv3Z92dPhB1P7aGoAqDJoq4fQ27j1Rw0" +
                                                              "uzhrpOv8P4997c1h6BQGUVVWV49kyaBSGLKVdjbp84N3B/IC2Dk1szlFoU7T" +
                                                              "AbF72RAX7zs/GVqyiV4+vc+N7Ca21AJPtxPZ3befFEuxBgI/zM8Rzle8JtYT" +
                                                              "T++Qo4qRibIvAkSnXr0zl8kaTjYJDslgKqc5yRcd17KfB33vmKLKpGFoBOtB" +
                                                              "x7F/Uz5bav+zLRvZUis8Q45Bhm7flkuxLmOOry6z9jgbHqGoihq+tsJT+tjt" +
                                                              "K52jqKHousIqcUvRFxRx65efn6+rWjv/wO95y+zezGsBhlJZTfNlgz8zIqZF" +
                                                              "UipXolb0ISb/+QZUhVvcpihUSSzz439dMH2TonXLMEEjKl78PKcpWl2KB6TD" +
                                                              "6Kc8CwAepITo5L9+unMU1Xh0sKl48ZN8F6QDCXt92sxnSvcnuD263wNdl+RC" +
                                                              "xc0O9/maW/nc191sKYBx/iUtj3NZ8S0NatD83v0P3/jMM+JmIWt4ZoZJWQHo" +
                                                              "Ji45bguweUlpeVmRge03V71QvTUPuw3iwF7erPMFdy9ksckirzXQdtsdbvf9" +
                                                              "1oWdl18/GbkGBWMchQAOmsZ937HERxvo3bPQn4zHSuE4NEj8RtBT8+dDV/7x" +
                                                              "dqiRN5IO8rctx5GQz1x+J54yze+EUfUgqoCqQnJjqEa17z+qjxB5yiooC5Gk" +
                                                              "kdXdj26rWJpglrHcMo5BV7qz7GZKUXtx6Su+rUOPPU2sXUy6U2YKmqasafpX" +
                                                              "uWWJgFBR48sSsSHTdGp++Dq3vGlyMLjEQfS/Hulany4XAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "H0ryINGFIgAA");
}
