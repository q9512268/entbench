package org.apache.batik.transcoder.wmf.tosvg;
public class WMFFont {
    public java.awt.Font font;
    public int charset;
    public int underline = 0;
    public int strikeOut = 0;
    public int italic = 0;
    public int weight = 0;
    public int orientation = 0;
    public int escape = 0;
    public WMFFont(java.awt.Font font, int charset) { super();
                                                      this.font = font;
                                                      this.charset = charset;
    }
    public WMFFont(java.awt.Font font, int charset, int underline, int strikeOut,
                   int italic,
                   int weight,
                   int orient,
                   int escape) { super();
                                 this.font = font;
                                 this.charset = charset;
                                 this.underline = underline;
                                 this.strikeOut = strikeOut;
                                 this.italic = italic;
                                 this.weight = weight;
                                 this.orientation = orient;
                                 this.escape = escape; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwcxRWfO39/xR+Jk5DEju2cQfngllBCRZ1SEmMTh4tt" +
                                                              "xYmrXiCXub0538Z7u5vdWd/Z1BQQKOlXlEIIAUH+CkoaBYJQo1K1oFSoLRWh" +
                                                              "EpCWUtRQVZWaikYlqkqrpi19M7t3+3G3l5I/amnn1rPvzfu9N2/ex5y+jGoM" +
                                                              "HXUThUbprEaM6JBCx7FukNSgjA1jB8wlxKeq8F93Xxq9I4xq42hBBhvbRGyQ" +
                                                              "YYnIKSOOuiTFoFgRiTFKSIpxjOvEIPoMppKqxFGnZIxkNVkSJbpNTRFGMIn1" +
                                                              "GGrHlOpS0qRkxF6Aoq4YIBE4EmGT//NADDWLqjbrkC91kQ+6vjDKrCPLoKgt" +
                                                              "thfPYMGkkizEJIMO5HW0VlPl2SlZpVGSp9G98gbbBFtjG0pM0PdS6ydXD2Xa" +
                                                              "uAkWYkVRKVfP2E4MVZ4hqRhqdWaHZJI19qEHUVUMNbmIKYrECkIFECqA0IK2" +
                                                              "DhWgbyGKmR1UuTq0sFKtJjJAFPV6F9GwjrP2MuMcM6xQT23dOTNo21PU1tKy" +
                                                              "RMUn1wqHn9rd9nIVao2jVkmZYHBEAEFBSBwMSrJJohubUimSiqN2BTZ7gugS" +
                                                              "lqU5e6c7DGlKwdSE7S+YhU2aGtG5TMdWsI+gm26KVNWL6qW5Q9n/1aRlPAW6" +
                                                              "LnZ0tTQcZvOgYKMEwPQ0Br+zWaqnJSVF0Uo/R1HHyL1AAKx1WUIzalFUtYJh" +
                                                              "AnVYLiJjZUqYANdTpoC0RgUH1ClaFrgos7WGxWk8RRLMI31049YnoGrghmAs" +
                                                              "FHX6yfhKsEvLfLvk2p/LoxsPPqBsUcIoBJhTRJQZ/iZg6vYxbSdpohM4BxZj" +
                                                              "85rYEbz41QNhhIC400ds0Xz/q1fuWtd97g2LZnkZmrHkXiLShHg8ueDtFYOr" +
                                                              "76hiMOo11ZDY5ns056ds3P4ykNcgwiwursg+Rgsfz23/6VceOkU+CqPGEVQr" +
                                                              "qrKZBT9qF9WsJslEv4coRMeUpEZQA1FSg/z7CKqD95ikEGt2LJ02CB1B1TKf" +
                                                              "qlX5/2CiNCzBTNQI75KSVgvvGqYZ/p7XEEJ18KBmeLqQ9cd/KdojZNQsEbCI" +
                                                              "FUlRhXFdZfobAkScJNg2IyTB66cFQzV1cEFB1acEDH6QIfYHqmPFECEI6UIu" +
                                                              "mxaoasxMCV/eNjwMxooyT9P+DzLyTM+FuVAItmCFPwDIcHa2qDJwJ8TD5uah" +
                                                              "Ky8m3rScix0I20IU3Qxio5bYKBcbdcRGQWyUi43aYlEoxKUtYuKtzYatmoZD" +
                                                              "D1G3efXE/Vv3HOirAi/TctVg5zCQ9nmyz6ATGQrhPCGe6WiZ6724/vUwqo6h" +
                                                              "DixSE8ssmWzSpyBMidP2SW5OQl5y0kOPKz2wvKarIklBdApKE/Yq9eoM0dk8" +
                                                              "RYtcKxSSFzumQnDqKIsfnTuae3jya7eEUdibEZjIGghmjH2cxfFivI74I0G5" +
                                                              "dVv3X/rkzJF51YkJnhRTyIwlnEyHPr8/+M2TENf04LOJV+cj3OwNELMphjMG" +
                                                              "4bDbL8MTcgYK4ZvpUg8Kp1U9i2X2qWDjRprR1Zwzwx21nb8vArdoYmewA56b" +
                                                              "7EPJf9nXxRobl1iOzfzMpwVPD1+c0J779S/+9Dlu7kImaXWVABOEDriiF1us" +
                                                              "g8epdsdtd+iEAN1vj44/8eTl/bu4zwLFqnICI2wchKgFWwhmfuyNfe9/ePH4" +
                                                              "hXDRz0MU0reZhCooX1SSzaPGCkqCtBsdPBD9ZIgOzGsiOxXwTykt4aRM2MH6" +
                                                              "V2v/+rN/Pthm+YEMMwU3WnftBZz5Gzajh97c/fduvkxIZNnXsZlDZoX0hc7K" +
                                                              "m3QdzzIc+Yff6Xr6Z/g5SA4QkA1pjvAYG7bPOgO1lKIWzolzNMoihjcCsFM2" +
                                                              "YSYNOK1SFjZnxk5it47vEQ9Exv9gJagbyjBYdJ0nhW9Pvrf3PN/6ehYP2DwT" +
                                                              "3OI67RA3XH7XZm3Jp/AXguc/7GFbwSasZNAxaGeknmJK0rQ8IF9doYb0KiDM" +
                                                              "d3w4/eylFywF/CnbR0wOHP7Gp9GDh639tOqaVSWlhZvHqm0sddgwwND1VpLC" +
                                                              "OYb/eGb+hyfn91uoOrxZegiK0Bd+9e/z0aO/+3mZxFAl2bXpbczBLTdnJ9K7" +
                                                              "N5ZCd3+99UeHOqqGIZKMoHpTkfaZZCTlXhHKMsNMujbLqZf4hFs1tjGQadbA" +
                                                              "HvDpDRzGLUUwiINB/NtWNvQb7oDq3SpX5Z0QD134uGXy49eucHW9pbs7fmzD" +
                                                              "mmXrdjbcyGy9xJ/wtmAjA3S3nRu9r00+dxVWjMOKIiRyY0yH3Jn3RBubuqbu" +
                                                              "Nz9+ffGet6tQeBg1yipODWMeuFEDRExiZCBf57Uv3WUFjFw9DG1cVVSifMkE" +
                                                              "O7Qry4eDoaxG+QGee2XJ9zaeOHaRRy6NL9FVGpXX2QFrXfmozMab2LC2NNYF" +
                                                              "sfp2sJ5jrmf/3s6GL1QeuOB4BS+4jw07+ad72TBpmWf0Oi3JJnZo1oflFlRW" +
                                                              "YXkKGd4fO7n01Luf/+WJ7xzJWSetQtzw8S3955icfOT3/yjxSF46lAklPv64" +
                                                              "cPrZZYN3fsT5nRzOuCP50qoQ6iCH99ZT2b+F+2p/EkZ1cdQm2v3oJJZNlhnj" +
                                                              "0IMZhSYVelbPd28/ZTUPA8UaZYU/lrnE+qsHd4iopp5w4CsYOuHptv2r2++a" +
                                                              "IcRfMhW9M4ibQjcBliu640LHk6RreVLSC3IJPCttMSsDQKoVQQZxU1QnZlhX" +
                                                              "T4sHw4VT+4w4WRvUY0vqCcA5UxFnEDdFDaYCAZD1a+WQ5q4Daa8tqzcA6XxF" +
                                                              "pEHcgBQqZ2majJllbfrgZ0S6DJ4+W1ZfANJHKyIN4obyUqIYystyMB+7Dpir" +
                                                              "bEGrAmB+syLMIG6AmSPSVKasNb/1GWEy/4/YgiIBMB+vCDOIm6ImVZcgmuNC" +
                                                              "d+DH+sR1mLTfltYfgPXpiliDuMGkxBCxVvYoPVMBZr6cOP5Xi3y3IS5xrpSH" +
                                                              "WNnTFXRhxcvL448cPpYae3592E7Dm+FEUVW7WSYzRPYsBcHLvkFgZcrSkstK" +
                                                              "64JNfPFYa/2SYzvf4x1p8RKsGUr9tCnL7kzheq/VdJKWOIBmK29o/Oe7FPX/" +
                                                              "T5cbFNXwX474pMV8mqKV12CGEhlGN9MZipZXYKLQFxf/cfO9TFGbnw9A8V83" +
                                                              "3VlYwaED17Be3CSvACogYa8/0AodWRsvC1mqjlqpOh/ybnTRozqv5fgu31jl" +
                                                              "KXL4NXWhMTCti+qEeObY1tEHrtz+vNWqizKem2OrNEE7YN0aFC9EegNXK6xV" +
                                                              "u2X11QUvNfQXvK3dAuycieWuinAHdCsa87Vlvj7WiBTb2fePb3ztrQO170Dt" +
                                                              "tAuFMEULd5UWNXnNhGOwK1ba9kBRwxvsgdXPzN65Lv2XD3hVjaw2aUUwfUK8" +
                                                              "cOL+dx9fehwa8aYRVAMHieR5tXX3rLKdiDN6HLVIxlAeIMIqEpY9PdUCdiww" +
                                                              "u8DmdrHN2VKcZRc9FPWVtpOl12PQgeSIvlmFfM2Wga6syZnx3J/bR63R1DQf" +
                                                              "gzPjarmH2TCQZ7sB/piIbdO0Qrfd9IHGQ809/t6ST3Lu8/yVDW/9FzUhWE/C" +
                                                              "GgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "CmQiNKjYxUlu1aK0joIuWt1Vtz5qVRLFotd1txTymp0WKbRIjUuD1PYrqkQ3" +
       "NVXXhu2BuB7b5ZIiOYSf0sAlEjreSErs+nKrhbRLhjkhYGFZ6vTtsGHDIy0W" +
       "ppUNDtzPXW+qjVF7EFoc3jaqoi1Xa2gZXo5XC79qteyUJ+pR5IobPlg3GVvn" +
       "UF6s9AdOZV2c9zl6g66WNJjSz52m3ghoApYWmOEzRR34mhRrdMrz5CZxB15r" +
       "QVOR6Y0SxSjN1krNIMa6rRLyjGoDL5x1UC01SXtJ1cpUsV3RAdYJHM43XbKC" +
       "SPOuZw1Ha2rleMS6w4V1uMCgI4I1i+VevysUtFmpv2KJHhNYM6ZdVltqr86M" +
       "NDCKyvIyGE/rdICMMRudoAuxNRsG4RCRV5tViiKeWl82Qt2XXGPVqFTVGsF1" +
       "TcybpENfdRC7vzE3TLASuBZS0IrdWg3j4QLWcpLanHKViSg0mn2iFdo2iSTR" +
       "tG4EeqTHesEmGiyynJXLcN0YObCalDerHrnwKJxCV5pFT0lxZblmsmZNA4MN" +
       "rlO2Jq3hpsiMi6EhW7jvTxCe3yhcG58v8LgZ6VyzhcnUtL9pR3Y/naxG63lc" +
       "VoYMynSqArqECyELc7HlFiSCYVbjkuiZcVPeVNobZWZhNQ029WQ5TymZ9SaR" +
       "7LRkf1K0tBrtlgb6ZkNpBck0q5OwKsPTCt8oD+YNJJgtG1K7pnL9aR9xaErc" +
       "+M6GZXzbmml4RDKoxEtsn0Z4ciZ76bxix+XakhhgRLrEpl0FhN9ZU9K7Rc8S" +
       "MW4ZmiWOhauGJXFoazUq9alqbdgoTTq1ieyWugHcmEwTDa61SXXFK5HMNlKl" +
       "bcw9t0sXw0GdIjHQSWqRtluMXlqVYWPtkOsVCeOeOiyu+h2u1ga5pGVVS1jc" +
       "XygCLzqWvATjrxjp+nS1YluIEPTwvqTCRlstWGvTw5DE74epbExtutjUC5gB" +
       "b4pKHy6UXDklGw6qTgJV2zR7I93rYnSNrci4Xipg2Njo9BeLNiXTjN8JRnNT" +
       "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");
}
