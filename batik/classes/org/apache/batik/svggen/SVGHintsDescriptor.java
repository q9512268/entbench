package org.apache.batik.svggen;
public class SVGHintsDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private java.lang.String colorInterpolation;
    private java.lang.String colorRendering;
    private java.lang.String textRendering;
    private java.lang.String shapeRendering;
    private java.lang.String imageRendering;
    public SVGHintsDescriptor(java.lang.String colorInterpolation, java.lang.String colorRendering,
                              java.lang.String textRendering,
                              java.lang.String shapeRendering,
                              java.lang.String imageRendering) { super(
                                                                   );
                                                                 if (colorInterpolation ==
                                                                       null ||
                                                                       colorRendering ==
                                                                       null ||
                                                                       textRendering ==
                                                                       null ||
                                                                       shapeRendering ==
                                                                       null ||
                                                                       imageRendering ==
                                                                       null)
                                                                     throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                                                                       org.apache.batik.svggen.ErrorConstants.
                                                                         ERR_HINT_NULL);
                                                                 this.
                                                                   colorInterpolation =
                                                                   colorInterpolation;
                                                                 this.
                                                                   colorRendering =
                                                                   colorRendering;
                                                                 this.
                                                                   textRendering =
                                                                   textRendering;
                                                                 this.
                                                                   shapeRendering =
                                                                   shapeRendering;
                                                                 this.
                                                                   imageRendering =
                                                                   imageRendering;
    }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_COLOR_INTERPOLATION_ATTRIBUTE,
            colorInterpolation);
        attrMap.
          put(
            SVG_COLOR_RENDERING_ATTRIBUTE,
            colorRendering);
        attrMap.
          put(
            SVG_TEXT_RENDERING_ATTRIBUTE,
            textRendering);
        attrMap.
          put(
            SVG_SHAPE_RENDERING_ATTRIBUTE,
            shapeRendering);
        attrMap.
          put(
            SVG_IMAGE_RENDERING_ATTRIBUTE,
            imageRendering);
        return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZa2wU1xW+u8bvtwFDeBhs1kYYshvaQEsMNLAYMKyNaxtL" +
       "XR7L7Ozd3cGzM8PMXXvtJC1BSkMfQZQQoFXgR0vKIzREVdM0aYkcRc1DSSuR" +
       "kKZpFIqa/ghNUYKipFXp69w7MzuPfSDSZqW5e/fOOeeec+653zn37rlrqFRT" +
       "UQuWiJ+MK1jzd0ukn1M1HAuKnKYNwViEP1rCfbzz/b4VXlQWRnVJTuvlOQ2v" +
       "F7AY08JoriBphJN4rPVhHKMc/SrWsDrKEUGWwmi6oPWkFFHgBdIrxzAlGObU" +
       "EGrkCFGFaJrgHkMAQXNDoEmAaRJY437dFUI1vKyMW+QzbeRB2xtKmbLm0ghq" +
       "CO3mRrlAmghiICRopCujosWKLI4nRJn4cYb4d4vLDBdsCi3LcUHbk/Wf3jiY" +
       "bGAumMpJkkyYedoA1mRxFMdCqN4a7RZxStuDvo5KQqjaRkyQL2ROGoBJAzCp" +
       "aa1FBdrXYimdCsrMHGJKKlN4qhBBrU4hCqdyKUNMP9MZJFQQw3bGDNbOz1qr" +
       "W5lj4iOLA4eP7mz4aQmqD6N6QRqk6vCgBIFJwuBQnIpiVVsTi+FYGDVKsNiD" +
       "WBU4UZgwVrpJExISR9Kw/KZb6GBawSqb0/IVrCPYpqZ5IqtZ8+IsoIxfpXGR" +
       "S4CtzZatuoXr6TgYWCWAYmqcg7gzWKaMCFKMoHlujqyNvs1AAKzlKUyScnaq" +
       "KRIHA6hJDxGRkxKBQQg9KQGkpTIEoErQrIJCqa8Vjh/hEjhCI9JF16+/AqpK" +
       "5gjKQtB0NxmTBKs0y7VKtvW51rfywD3SRsmLPKBzDPMi1b8amFpcTAM4jlUM" +
       "+0BnrOkMHeGaL+z3IgTE013EOs3T916/e0nL5Ms6zew8NFuiuzFPIvzJaN3F" +
       "OcFFK0qoGhWKrAl08R2Ws13Wb7zpyiiAMM1ZifSl33w5OfDi1/aexR94UVUP" +
       "KuNlMZ2COGrk5ZQiiFjdgCWscgTHelAllmJB9r4HlUM/JEhYH90Sj2uY9KAp" +
       "Ihsqk9lvcFEcRFAXVUFfkOKy2Vc4kmT9jIIQKocHBeFpRfqHfRO0I5CUUzjA" +
       "8ZwkSHKgX5Wp/VoAECcKvk0GohD1IwFNTqsQggFZTQQ4iIMkNl+MJhJYCgwO" +
       "b9gIkaqtwxqvCgrEu5+GmfJ5T5ChFk4d83jA+XPcW1+EXbNRFmNYjfCH02u7" +
       "rz8ReVUPK7oVDN8Q1Alz+vU5/WxOvz6nP3dO5PGwqabRufU1hhUagb0OYFuz" +
       "aHDHpl3720oguJSxKeBeStrmSDpBCxBMFI/w55tqJ1ovL33Bi6aEUBPHkzQn" +
       "0hyyRk0AOvEjxgauiUI6srLCfFtWoOlMlXkcA1AqlB0MKRXyKFbpOEHTbBLM" +
       "nEV3Z6BwxsirP5o8Nnb/8Dfu8CKvMxHQKUsBwyh7P4XvLEz73ACQT279g+9/" +
       "ev7IfbIFBY7MYibEHE5qQ5s7GNzuifCd87mnIhfu8zG3VwJUEw62FqBgi3sO" +
       "B9J0mahNbakAg+OymuJE+sr0cRVJqvKYNcKitJH1p0FYVNOtNxeexcZeZN/0" +
       "bbNC2xl6VNM4c1nBssKqQeX473979YvM3WYCqbdl/kFMumygRYU1MXhqtMJ2" +
       "SMUY6N491v/wI9ce3MZiFigW5JvQR9sggBUsIbj5gZf3vP3Hyycvea04J5C1" +
       "01EofjJZI+k4qipiJMzWYekDoCcCLtCo8W2VID6FuMBFRUw31j/r25c+9dcD" +
       "DXociDBihtGSmwuwxm9bi/a+uvNvLUyMh6dJ1/KZRaYj+VRL8hpV5capHpn7" +
       "X5/7/Ze445ATAIc1YQIzaC1lPihlls+EGoxx0vzq1/MrHV/uatgKL2Msd7D2" +
       "TuodJgixdyto067Zd4pzM9oqqQh/8NJHtcMfPXedmeYsxeyB0cspXXos0qYj" +
       "A+JnuJFsI6clge7Oyb7tDeLkDZAYBok8YLO2RQUozTjCyKAuLf/D8y8077pY" +
       "grzrUZUoc7H1HNuRqBK2AtaSgMIZ5St365EwVgFNAzMV5RifM0BXY17+de5O" +
       "KYStzMQvZvxs5akTl1lIKrqM2cayQGJwQDAr6C0UOPvGl9489b0jY3pJsKgw" +
       "9Ln4Zv5jixjd96e/57icgV6ecsXFHw6ce3RWcPUHjN9CH8rty+QmM0Bwi/cL" +
       "Z1OfeNvKfu1F5WHUwBsF9DAnpumeDkPRqJlVNRTZjvfOAlCvdrqy6DrHjXy2" +
       "ad24ZyVR6FNq2q91QV0NXcIOeNoMFGhzQ50Hsc5mxrKQtZ20ud1ElnJFFeCQ" +
       "hV3QUl1EKBgJRRZNCFDVgkWcCYPLdWCl7V20CelCVxWMzG6nJXSiBcakCwpY" +
       "MqRbQpu+XJULcRNUx1QegFIPO1DDpu7WW1SX1ng+Y0JfAXW3FVW3EDdBtfS8" +
       "VFTb7Z/Bue3GfO0FtI0W1bYQNzhXS3IKLqou/xnU7TAm7CigrlBU3ULcoK6Q" +
       "gtNUUXV3F1E3Y027ODst+5Qh1wnAnpAt1PSayay9SG1slcUmdWsR6sFxQLgM" +
       "TTlzCx3+2MH15L7DJ2JbHluq43GT80DVLaVTP/ndv17zH7vySp5KvpLIyu0i" +
       "HsWiwxaY0pEBetm52ILTd+sOvfeML7H2VupvOtZykwqb/p4HRnQWTipuVV7a" +
       "95dZQ6uTu26hlJ7ncqdb5Jnec69s6OAPedklgI7zOZcHTqYuJ7pXqZikVWnI" +
       "gfELsoFVT+OoBZ7VRmCtdu8GK3RdMZktEguxuiokT/ZYZVtRulSD6ahGBrgx" +
       "FksRfvvChmbfio/b9CBqyUNru3E48Mtnw+GFDbxO3JZPsPOm4fSpCv6d1It/" +
       "1hluy8Og000/HXho+K3dr7HFrKDRk3WhLXIgymynhIasb+qoKxrhuWL4hn0T" +
       "tP1/PFADWypAhBTgSmBISOEYvcajNhgH9s9VPis5HZvRWrTHR8Q1H375x6t0" +
       "t7YW2DQW/TNfvXLx+MT5czoQUPcStLjQxWPubSc9JbYXOelaAfLJhrsmr743" +
       "vMNr1OZ1tPlOxkS9Wqs4hVKYDj6cJ2CnOcNEl7zuW/W/OthUsh6QpwdVpCVh" +
       "Txr3xJy7r1xLR21xY92vWXvRCJr/wMcDz7/pQ4OFDuhB0xQ07prmZy+boE6m" +
       "7wnydEKXyXmgyIHkUdrshfNEApPsnbVh77ettHT/zbJo8VqfDgQVNn5vdicw" +
       "9vnwbDZ2wuZbB5hCrAUAhv7+pnMrNsFzxpByxpTyXSblId2SA7Q5k42LOvvR" +
       "Sj+zPu6eiP48qjv/VBHnn6fND+FsCc5fh+OCxA72UOvT8dOW93/0//B+BsIl" +
       "9+qLHsNm5lyu6xfC/BMn6itmnNj6Fsug2UvbGkC9eFoU7QcFW79MUcEUZl+N" +
       "fmxQ2NfTBM0oUEgQVKZ3mO4/1+mfBb+46QkqZd92ugsEVVl0IErv2EkmCSoB" +
       "Etp9XslzoNfPSxmPrbww/MjcP/1m7s+y2G9aKPSwPzdMeEj3Gwh3/sSmvnuu" +
       "L39Mv+nhRW5igkqpBlDQL52yRUBrQWmmrLKNi27UPVnZboJYo66wtXNm2+It" +
       "CKGp0BWf5boG0XzZ25C3T6587jf7y14H+N2GPBxBU7flniwzShpy9bZQLvhB" +
       "wcTuZ7oW/WB89ZL4h++ws7sBlnMK00f4S6d2vHFo5skWL6ruQaVQMuIMO/Ku" +
       "G5cGMD+qhlGtoHVnQEWQInCiA1nraHBytKhmfjHcWZsdpfeEBLXl/L+R53a1" +
       "SpTHsLpWTksxA5urrRHHvy5mHZVWFBeDNWKrAY7Q5lhGR+6SSKhXUUwkr7qq" +
       "sF16ND+Q0PYS69Lmzf8CPfyEqfgcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4tnOJwAA");
}
