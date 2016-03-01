package org.apache.batik.ext.awt.image.rendered;
public class DisplacementMapRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    private static final boolean TIME = false;
    private static final boolean USE_NN = false;
    private float scaleX;
    private float scaleY;
    private org.apache.batik.ext.awt.image.ARGBChannel xChannel;
    private org.apache.batik.ext.awt.image.ARGBChannel yChannel;
    org.apache.batik.ext.awt.image.rendered.CachableRed image;
    org.apache.batik.ext.awt.image.rendered.CachableRed offsets;
    int maxOffX;
    int maxOffY;
    java.awt.RenderingHints hints;
    org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets[]
      xOffsets;
    org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets[]
      yOffsets;
    static class TileOffsets {
        int[] tile;
        int[] off;
        TileOffsets(int len, int base, int stride, int loc, int endLoc, int slop,
                    int tile,
                    int endTile) { super();
                                   this.tile = (new int[len + 1]);
                                   this.off = (new int[len + 1]);
                                   if (tile == endTile) endLoc -=
                                                          slop;
                                   for (int i = 0; i < len; i++) {
                                       this.
                                         tile[i] =
                                         tile;
                                       this.
                                         off[i] =
                                         base +
                                           loc *
                                           stride;
                                       loc++;
                                       if (loc ==
                                             endLoc) {
                                           loc =
                                             0;
                                           tile++;
                                           if (tile ==
                                                 endTile)
                                               endLoc -=
                                                 slop;
                                       }
                                   }
                                   this.tile[len] = this.tile[len -
                                                                1];
                                   this.off[len] = this.off[len -
                                                              1];
        }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVYfZAURxXv3fvaOw7ug3CcfBxwd2BBcFcSCaWHGDg4OLLH" +
                                                                  "be4I6hFYZmd6dwdmZ4aZ3rvlCBLwAyp/UKlACMZwZRkSDUUgpab8KhDLj4TC" +
                                                                  "hAJTGoIGk/yRREIV/GEuihpfd8/sfOxH1Cp1q7a3t/v16/f6vf699/rEdVRl" +
                                                                  "GqhdF1RJCJMdOjbDMdqPCYaJpW5FMM31MBoXH3rj4O7x39TuCaLqITQpLZh9" +
                                                                  "omDiHhkrkjmEZsqqSQRVxOY6jCW6ImZgExvDApE1dQhNkc3ejK7Iokz6NAlT" +
                                                                  "gg2CEUVNAiGGnMgS3GsxIGhWlEkTYdJElvsJuqKoXtT0Hc6CaZ4F3a45Sptx" +
                                                                  "9jMJaoxuFYaFSJbISiQqm6QrZ6DbdU3ZkVI0EsY5Et6qLLYOYm10ccExtD/X" +
                                                                  "8P6th9ON7BgmC6qqEaaiOYBNTRnGUhQ1OKOrFJwxt6MvoYoomuAiJqgzam8a" +
                                                                  "gU0jsKmtr0MF0k/EajbTrTF1iM2pWhepQATN8TLRBUPIWGxiTGbgECKW7mwx" +
                                                                  "aDs7r61tbp+Kj94eOfTY5sbvVqCGIdQgq4NUHBGEILDJEBwoziSwYS6XJCwN" +
                                                                  "oSYVDD6IDVlQ5FHL2s2mnFIFkgUXsI+FDmZ1bLA9nbMCS4JuRlYkmpFXL8mc" +
                                                                  "yvpXlVSEFOja4ujKNeyh46BgnQyCGUkBfM9aUrlNViXmR94VeR077wECWFqT" +
                                                                  "wSSt5beqVAUYQM3cRRRBTUUGwfnUFJBWaeCCBvO1EkzpWeuCuE1I4ThBrX66" +
                                                                  "GJ8Cqlp2EHQJQVP8ZIwTWGmaz0ou+1xft/TATnWNGkQBkFnCokLlnwCL2nyL" +
                                                                  "BnASGxjuAV9YvyB6WGg5vT+IEBBP8RFzmh88cPPuhW1nX+Q004vQ9Ce2YpHE" +
                                                                  "xWOJSRdndM//dAUVI6RrpkyN79Gc3bKYNdOV0wFpWvIc6WTYnjw78KsvPngc" +
                                                                  "Xwuiul5ULWpKNgN+1CRqGV1WsLEaq9gQCJZ6US1WpW4234tqoB+VVcxH+5NJ" +
                                                                  "E5NeVKmwoWqN/YcjSgILekR10JfVpGb3dYGkWT+nI4QmwBc1wvd+xD/sl6Cd" +
                                                                  "kbSWwRFBFFRZ1SIxQ6P6U4MyzMEm9CWY1bVIAvx/2ycWhZdETC1rgENGNCMV" +
                                                                  "EcAr0phPsnsqjJCInAFniIBxJLCQFFkpm7oCLpzBKukT9AEshakT6v/f7XP0" +
                                                                  "dCaPBAJguBl+2KD0azQFGMTFQ9kVq26ejJ/nLkmvkXWuBPWADGEuQ5jJwEAW" +
                                                                  "ZAgzGcK2DOFCGTrXg+G4VU0UCDAxbqNycd8By28DDAEQr58/uGntlv3tFeC0" +
                                                                  "+kglmI2SzisIat0O2NgRIi6euDgwfuGluuNBFAQ8SkBQcyJLpyey8MBoaCKW" +
                                                                  "ANpKxRgbZyOlo0pROdDZIyN7Nuz+JJPDHSwowyrAObo8RiE+v0WnHySK8W3Y" +
                                                                  "9877pw7v0hy48EQfO2gWrKQo1O43ul/5uLhgtvB8/PSuziCqBGgDOCcCXD9A" +
                                                                  "yjb/Hh406rKRneoSAoWTmpERFDplw3EdSRvaiDPCvLGJ9W8DE4fo9ZwM37h1" +
                                                                  "X9kvnW3RaTuVey/1GZ8WLHJ8dlA/+urL797JjtsOMg2u7GAQky4XsFFmzQzC" +
                                                                  "mhwXXG9gDHR/OBI7+Oj1fRuZ/wFFR7ENO2nbDYAGJoRj/uqL2y9fff3YK8G8" +
                                                                  "z6KcV7dQGd2oeztiAB4qAArUWTrvU8EZ5aQsJBRM78bfGuYuev69A43c/AqM" +
                                                                  "2N6z8KMZOOMfW4EePL95vI2xCYg0HjtH5ZBxkJ/scF5uGMIOKkduz6WZX39B" +
                                                                  "OArhAiDalEcxQ90QUz1kUmd2XVeaJA5mEyaJGXIGzn/YCmGnWsa3/6JmdKUd" +
                                                                  "noot4ZT3mH0Xfrzm7Tizb4heazpOdZ/ourDLjZTLuRq5AT6ETwC+/6BfevB0" +
                                                                  "gAeD5m4rIs3OhyRdz4H088vkkF4VIruar2574p1nuQr+kO0jxvsPPfRh+MAh" +
                                                                  "bj2e13QUpBbuNTy34erQZgmVbk65XdiKnrdP7frJd3bt41I1e6P0KkhCn/3t" +
                                                                  "338dPvLHc0UgvkK2ctM7KPLm8bfFbx2uUvWio3/Z/bVX+wEwelEoq8rbs7hX" +
                                                                  "cvOExMzMJlzmcjImNuBWjpqGoMACsAIduKt8w2juZLKG8xIj6/bR/z206TTd" +
                                                                  "0Oq1pys9j4sPv3Jj4oYbZ26yM/Hm924kgWjGDdJEm7nUIFP9YWyNYKaB7lNn" +
                                                                  "193fqJy9BRyHgKMIQdzsNyBA5jy4Y1FX1bz2s5+3bLlYgYI9qE7RBKlHYBCO" +
                                                                  "agE7sZmG8JzTP3c3x5CRkJXgoBwqUJ5e21nFAWFVRifsCo/+cOr3l3577HUG" +
                                                                  "WRysprPlQZOWFf5oy2pDJ1C8d+Ubb/10/Mka7mFl7otvXetf+5XE3jc/KDhk" +
                                                                  "FheLXCHf+qHIiSemdS+7xtY7AYqu7sgV5jUQwp21dxzP/DnYXv3LIKoZQo2i" +
                                                                  "VYdtEJQshf0hqD1MuziDWs0z760jeNLclQ/AM/x32LWtPzS6L0Yl8VwCXzSk" +
                                                                  "nU1WxNjkj4YBxDqfZ0vm0WZBYbwptZrAzgB7fjvnMZfBPL/fP5r87vfObam5" +
                                                                  "zO1cHNV9hcmbO89/S/v9tWDQuoWL84JNonI0wdfyYf5LkPxfyYpTWMsAC5KO" +
                                                                  "YjVF0nYK/r/bjELD3NI3w3XKY093vLx7rOMNBhQh2QT/gVhWpHB0rblx4uq1" +
                                                                  "SxNnnmSpWiUNiRa+eivuwoLaUyczCzXQJs4htwD66f97OYHldEnudKydT5uF" +
                                                                  "HDcIqtazCUWGfKIqKauCwjgugWGFHQr9t5Q2koU3dJughTn0fyuxkg16y6BI" +
                                                                  "1lRM8xZ7jlcLshbOP1DAZK5IrJpTgF59TGUHCpZcGq+48khrfWGZQLm1lSgC" +
                                                                  "FpQ2pn+DF/b+adr6Zekt/0b+P8tnaz/LZ/pOnFs9T3wkyF43OPIUvIp4F3V5" +
                                                                  "8abOwCRrqN7Q2+4YXypu2ADtytyYZaLtaJm5B2gzDH4hUqNyHyhDvpv5Wb8r" +
                                                                  "sgUcSbqtUoC2q2nzBe4Da0uGxnsLy4zNFgJtLgGsXy4LrKVWQ/akJZO0u9kn" +
                                                                  "41fKyJgrcexwcUz2WueUEuyI6pDvWcNdSjhxHFH8mVnq5Ynlicf2HhqT+p9a" +
                                                                  "ZEP1MtjSehB08yFogqt4t6/jZ/7ztwAQrLXg4ZI/toknxxpCU8fu+x3HNftB" +
                                                                  "rB7S/mRWUdzR09Wv1g2c5C5az2MpzyAfI+jj/6KYBIXsLtPwMOfwONS+5TmA" +
                                                                  "V7Nf96qjBLWWWgVOAq2b+puAbcWogRJaN+WTBDX6KWF/9uume5qgOocOrMo7" +
                                                                  "bpJnqLMaKdo9rts2bXTglyc5uYDXo/IOPeWjLp3LCTs8uMketm2My/KnbagF" +
                                                                  "x9au23nzrqd4BS8qwugo5TIB4hV/TMjj5JyS3Gxe1Wvm35r0XO1c262buMDO" +
                                                                  "lZzuwpp+uGk6TZin+epcszNf7l4+tvTMS/urL0F83ogCAoSpjYXpYE7PAohv" +
                                                                  "jBYrlCCKsBK8q+6tLRc+eC3QzLJuK1y1lVsRFw+euRJL6vrjQVTbC64GLppj" +
                                                                  "uerKHeoAFocNT91VndCyaj74T6LXR6CP3uxkrAOdmB+lL0AEtReWoIWvYlCQ" +
                                                                  "jGBjBeVu5RmeyJLVdfcsO9kVLGLkeI5XEY/26bpVe9ezhKJf1xlonWao/k9E" +
                                                                  "xnJ9vRoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMVae+zsWF3v/d29d+/efdy7D3bXlX1fIMvAr/PszLCAtJ22" +
           "005nOo/OdKbCXvqe6Xv6ms7AyiNRiBgkuiAmcE0MKOKyIJFoYjBrjAKBkECI" +
           "r0QWjYkokrB/iEZUPO383vexQIxOMqenPd9zzvd7vt/v5/s9p332u9CZMIAK" +
           "vmevDduLdrU02jXt2m609rVwl2FrfSkINRW3pTDkwbPLymOfufD9H3xgfnEH" +
           "OitCd0uu60VStPDccKiFnp1oKgtdOHxK2JoTRtBF1pQSCY6jhQ2zizB6koVu" +
           "PdI1gi6x+yzAgAUYsADnLMDoIRXodLvmxg6e9ZDcKFxCPwedYqGzvpKxF0GP" +
           "Hh/ElwLJ2Rumn0sARjiX3U+AUHnnNIAeOZB9K/NVAn+wAD/za09d/Oxp6III" +
           "XVi4o4wdBTARgUlE6DZHc2QtCFFV1VQRutPVNHWkBQvJXmxyvkXornBhuFIU" +
           "B9rBImUPY18L8jkPV+42JZMtiJXICw7E0xeare7fndFtyQCy3nso61ZCMnsO" +
           "BDy/AIwFuqRo+11ushauGkEPn+xxIOOlDiAAXW92tGjuHUx1kyuBB9BdW93Z" +
           "kmvAoyhYuAYgPePFYJYIeuC6g2Zr7UuKJRna5Qi6/yRdf9sEqG7JFyLrEkEv" +
           "O0mWjwS09MAJLR3Rz3d7r3//29y2u5PzrGqKnfF/DnR66ESnoaZrgeYq2rbj" +
           "ba9mPyTd+/n37kAQIH7ZCeItzR+8/cU3veah57+4pfnpa9Bwsqkp0WXlY/Id" +
           "X3s5/kTzdMbGOd8LF5nyj0mem39/r+XJ1Aeed+/BiFnj7n7j88M/n73zk9p3" +
           "dqDzNHRW8ezYAXZ0p+I5/sLWAkpztUCKNJWGbtFcFc/baehmUGcXrrZ9yul6" +
           "qEU0dJOdPzrr5fdgiXQwRLZEN4P6wtW9/bovRfO8nvoQBN0K/tBF8H8ztP3l" +
           "1wh6Gzz3HA2WFMlduB7cD7xM/kyhrirBkRaCugpafQ+Wgf1bry3t1uHQiwNg" +
           "kLAXGLAErGKubRtzP5VWEbxwgDHAQDkq0JAKtxahbwMTdjQ36kr+UFN3MyP0" +
           "/3+nT7PVubg6dQoo7uUnYSOjb3s2GOCy8kyMES8+d/nLOwdutLeuEUQCHna3" +
           "POzmPOSQC3jYzXnY3edh92oeLvFAcVuthtCpUzkb92R8bW0HaN4CGALQ9bYn" +
           "Rm9h3vrex04Do/VXNwG1ZaTw9UEeP0QdOsdWBZg+9PyHV++avKO4A+0cR+tM" +
           "FvDofNa9n2HsAZZeOuml1xr3wnu+/f1Pf+hp79Bfj8H/Hoxc3TODgcdOrnrg" +
           "KZoKgPVw+Fc/In3u8uefvrQD3QSwBeBpJAH7B1D10Mk5jsHBk/vQmslyBgis" +
           "e4Ej2VnTPh6ej+aBtzp8kpvDHXn9TrDG5zL/uBv8L+85TH7NWu/2s/Kerflk" +
           "SjshRQ7dbxj5H/2rr/5TJV/ufZS/cCRujrToySPIkg12IceQOw9tgA80DdD9" +
           "7Yf7v/rB777nZ3MDABSPX2vCS1mJA0QBKgTL/PNfXP71C9/82Dd2DowGSo/L" +
           "du4GsoFJXnnIBgAkG3hlZiyXxq7jqQt9Icm2lhnnf154Relz//L+i1v12+DJ" +
           "vvW85qUHOHz+Uxj0zi8/9W8P5cOcUrKAeLhUh2RblL37cGQ0CKR1xkf6rq8/" +
           "+OtfkD4K8BpgZLjYaDnsnctFPwc6PXGDpChYOEAJyV4ggZ++6wXrI9/+1DZI" +
           "nIw6J4i19z7ziz/cff8zO0dC8+NXRcejfbbhObee27ca+SH4nQL//87+mSay" +
           "B1t4vgvfixGPHAQJ30+BOI/eiK18CvIfP/30H33i6fdsxbjreGQiQOL1qb/4" +
           "r6/sfvhbX7oGrJ0GWUd2U75xkQuxmwvxRF6+NuN6z9qy+9dlxcPhUSg5vvpH" +
           "8sHLyge+8b3bJ9/74xdzho4nlEc9B8DndvnuyIpHstW47yRutqVwDuiqz/fe" +
           "fNF+/gdgRBGMqICoEXIBQOT0mJ/tUZ+5+W/+5E/vfevXTkM7JHTe9iSVlHLI" +
           "gm4BWKGFcxAPUv9n3rT1mdW5vYgKpdBVwm997f787syNrY/M8sFDwLv/Pzhb" +
           "fvff//tVi5Dj9DUM8kR/EX72Iw/gb/xO3v8QMLPeD6VXBzqQOx/2LX/S+ded" +
           "x87+2Q50swhdVPYS84lkxxkMiSAZDfezdZC8H2s/nlhus6gnDwLCy096xJFp" +
           "T0L1oSWCekad1c9fC53vAf+37CHYW06i8ykor7TzLo/m5aWseNUR86xEYAbg" +
           "XUBBr7i+gnKM2Xr7ld96/KvvuPL43+X2dG4RAjHQwLhGQnukz/eefeE7X7/9" +
           "wefyCHaTLIVbgU7uBK5O9I/l7zm/tx3If1smwwUIuqm3FX97jaDl/2o+Jfl+" +
           "CIeJIYNAGWoB3PNUrb9QLC0A42n2fhL3fz9pvhrlA687tZcVZfd4VvT31c9f" +
           "W/07EdhmxrK9AJHmjL5wJXvfHs7ammtsE+cc4zg/PZhmZ9s3v39ZtBeGMnsH" +
           "+xfP1bKItt+2TeQW3u7B3hE0plcxHECvvr7ddXP1H3rnF979zw/wb5y/9cfI" +
           "4B4+YZYnh/yd7rNfol6p/MoOdPrAV6/aWB7v9ORxDz0faGAn7PLH/PTBrQ7y" +
           "9bu2Ak5lVWG76DeIH8YN2hZZkelPyRZ/q6sbkNsptE3YsvLJrKC3+njjdQEd" +
           "vzoZfGoPbp66Dtx4LwE3p8G2LWf1BC/+S/KSD5CeOgUELu/Wd4vZfXLt2U7n" +
           "iwtsOczPNrK76T4D95m2cmk/qZhoQQgM6JJp1/cN9+KhUW9PB04wWvmRGQXG" +
           "fcfhYKznGk++7x8+8JVffvwFgJ4MdCbJwgaw0SMz9uLs7OUXnv3gg7c+8633" +
           "5akrMJX+h4iLb8pGfeeNxM2KzTFRH8hEHeUww0ph1M3TTrDv2pcWPiJPDUQC" +
           "YEY/ubTRHdN2NaTR/V93MtNFdDxMp0lFTyRuVY+NCq7oWLpSyximkMoIl4Q2" +
           "1TKqHMu2Za1KI3NyJjoqoq5UR6xKYiVIbBxjV+jah8cdG8W74kocWqPWeGz4" +
           "ktzozFusWeXxOcrwlEdTFrweDgl6AlNEvJj7utqAQ51L2yXcLy3rUiWCkxIC" +
           "60iiI80mHBDqZGhTy7lKloYMznRVzpRbXXXZx2cS4ws1stutlLqYN21XArPK" +
           "1dNKk49xiV3S/MBnxXnTc1qL9twKLNMhxHC5HA2Gk5SbISYuILQjGkSatFCf" +
           "KKmDec9SKprZqdOetUF6qM0bRhknxpMeuqAot2uMKlSY0tRcsAmLn6kMYSch" +
           "Ey873jTii20FwSWxSlakam3kR2nT7DKSl8bkTCJHjEyPFoOlgwwCEWnJ6rgi" +
           "WhO6SISzGhEhS5adcTOnVFQUIo1a8LTRR6J5k+vVMcPBkeWSkKQFN8N6/NCl" +
           "xvNBietwAcms0gjpJt7M85wYXTBLYyM5DckYF82w40RBsUsWLZiQTJkPeLK0" +
           "6JZ9Ya75A5TvNXh2iI37tEClC56SDQLvCHVnlUqtsB4gpUj2Cx2zWQX7fn5W" +
           "C+VkssQpWh0Yy2pv3MYogmZbDIGtvM1itJqNkCmDr3reaDZptRC6NbEHNbLN" +
           "lsOy45I0aRnjaUgXyJYjlmQWbbpyFx9VmXhozyzHJ6dsw1HWiT+1JyOC5Eyp" +
           "GpudnraeVxHMcAdrnBpbmN5tSuPA7k0WU2fYrE60YbFeXxG4QC751WgU1WRt" +
           "OUHHs0G3ogyHQ4wfj6mV7o5JBhMkDcexhCsR1sYXtBiPiRJd5edYMEUQimng" +
           "S9svE+0BM5j0GyK94gXKkTZFLy6UUj2CeZR3hR5lDTCLdHHPYm13hbNld81i" +
           "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" +
           "r//tK9/MT8f+B0qNxf/xJQAA");
    }
    public DisplacementMapRed(org.apache.batik.ext.awt.image.rendered.CachableRed image,
                              org.apache.batik.ext.awt.image.rendered.CachableRed offsets,
                              org.apache.batik.ext.awt.image.ARGBChannel xChannel,
                              org.apache.batik.ext.awt.image.ARGBChannel yChannel,
                              float scaleX,
                              float scaleY,
                              java.awt.RenderingHints rh) {
        super(
          );
        if (xChannel ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "Must provide xChannel");
        }
        if (yChannel ==
              null) {
            throw new java.lang.IllegalArgumentException(
              "Must provide yChannel");
        }
        this.
          offsets =
          offsets;
        this.
          scaleX =
          scaleX;
        this.
          scaleY =
          scaleY;
        this.
          xChannel =
          xChannel;
        this.
          yChannel =
          yChannel;
        this.
          hints =
          rh;
        maxOffX =
          (int)
            java.lang.Math.
            ceil(
              scaleX /
                2);
        maxOffY =
          (int)
            java.lang.Math.
            ceil(
              scaleY /
                2);
        java.awt.Rectangle rect =
          image.
          getBounds(
            );
        java.awt.Rectangle r =
          image.
          getBounds(
            );
        r.
          x -=
          maxOffX;
        r.
          width +=
          2 *
            maxOffX;
        r.
          y -=
          maxOffY;
        r.
          height +=
          2 *
            maxOffY;
        image =
          new org.apache.batik.ext.awt.image.rendered.PadRed(
            image,
            r,
            org.apache.batik.ext.awt.image.PadMode.
              ZERO_PAD,
            null);
        image =
          new org.apache.batik.ext.awt.image.rendered.TileCacheRed(
            image);
        this.
          image =
          image;
        java.awt.image.ColorModel cm =
          image.
          getColorModel(
            );
        if (!USE_NN)
            cm =
              org.apache.batik.ext.awt.image.GraphicsUtil.
                coerceColorModel(
                  cm,
                  true);
        init(
          image,
          rect,
          cm,
          image.
            getSampleModel(
              ),
          rect.
            x,
          rect.
            y,
          null);
        xOffsets =
          (new org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets[getNumXTiles(
                                                                                        )]);
        yOffsets =
          (new org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets[getNumYTiles(
                                                                                        )]);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        copyToRaster(
          wr);
        return wr;
    }
    public java.awt.image.Raster getTile(int tileX,
                                         int tileY) {
        java.awt.image.WritableRaster dest =
          makeTile(
            tileX,
            tileY);
        java.awt.Rectangle srcR =
          dest.
          getBounds(
            );
        java.awt.image.Raster mapRas =
          offsets.
          getData(
            srcR);
        java.awt.image.ColorModel mapCM =
          offsets.
          getColorModel(
            );
        org.apache.batik.ext.awt.image.GraphicsUtil.
          coerceData(
            (java.awt.image.WritableRaster)
              mapRas,
            mapCM,
            false);
        org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets xinfo =
          getXOffsets(
            tileX);
        org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets yinfo =
          getYOffsets(
            tileY);
        if (USE_NN)
            filterNN(
              mapRas,
              dest,
              xinfo.
                tile,
              xinfo.
                off,
              yinfo.
                tile,
              yinfo.
                off);
        else
            if (image.
                  getColorModel(
                    ).
                  isAlphaPremultiplied(
                    ))
                filterBL(
                  mapRas,
                  dest,
                  xinfo.
                    tile,
                  xinfo.
                    off,
                  yinfo.
                    tile,
                  yinfo.
                    off);
            else
                filterBLPre(
                  mapRas,
                  dest,
                  xinfo.
                    tile,
                  xinfo.
                    off,
                  yinfo.
                    tile,
                  yinfo.
                    off);
        return dest;
    }
    public org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets getXOffsets(int xTile) {
        org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets ret =
          xOffsets[xTile -
                     getMinTileX(
                       )];
        if (ret !=
              null)
            return ret;
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            getSampleModel(
              );
        int base =
          sppsm.
          getOffset(
            0,
            0);
        int tw =
          sppsm.
          getWidth(
            );
        int width =
          tw +
          2 *
          maxOffX;
        int x0 =
          getTileGridXOffset(
            ) +
          xTile *
          tw -
          maxOffX -
          image.
          getTileGridXOffset(
            );
        int x1 =
          x0 +
          width -
          1;
        int tile =
          (int)
            java.lang.Math.
            floor(
              x0 /
                (double)
                  tw);
        int endTile =
          (int)
            java.lang.Math.
            floor(
              x1 /
                (double)
                  tw);
        int loc =
          x0 -
          tile *
          tw;
        int endLoc =
          tw;
        int slop =
          (endTile +
             1) *
          tw -
          1 -
          x1;
        ret =
          new org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets(
            width,
            base,
            1,
            loc,
            endLoc,
            slop,
            tile,
            endTile);
        xOffsets[xTile -
                   getMinTileX(
                     )] =
          ret;
        return ret;
    }
    public org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets getYOffsets(int yTile) {
        org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets ret =
          yOffsets[yTile -
                     getMinTileY(
                       )];
        if (ret !=
              null)
            return ret;
        java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            getSampleModel(
              );
        int stride =
          sppsm.
          getScanlineStride(
            );
        int th =
          sppsm.
          getHeight(
            );
        int height =
          th +
          2 *
          maxOffY;
        int y0 =
          getTileGridYOffset(
            ) +
          yTile *
          th -
          maxOffY -
          image.
          getTileGridYOffset(
            );
        int y1 =
          y0 +
          height -
          1;
        int tile =
          (int)
            java.lang.Math.
            floor(
              y0 /
                (double)
                  th);
        int endTile =
          (int)
            java.lang.Math.
            floor(
              y1 /
                (double)
                  th);
        int loc =
          y0 -
          tile *
          th;
        int endLoc =
          th;
        int slop =
          (endTile +
             1) *
          th -
          1 -
          y1;
        ret =
          new org.apache.batik.ext.awt.image.rendered.DisplacementMapRed.TileOffsets(
            height,
            0,
            stride,
            loc,
            endLoc,
            slop,
            tile,
            endTile);
        yOffsets[yTile -
                   getMinTileY(
                     )] =
          ret;
        return ret;
    }
    public void filterBL(java.awt.image.Raster off,
                         java.awt.image.WritableRaster dst,
                         int[] xTile,
                         int[] xOff,
                         int[] yTile,
                         int[] yOff) { final int w =
                                         dst.
                                         getWidth(
                                           );
                                       final int h =
                                         dst.
                                         getHeight(
                                           );
                                       final int xStart =
                                         maxOffX;
                                       final int yStart =
                                         maxOffY;
                                       final int xEnd =
                                         xStart +
                                         w;
                                       final int yEnd =
                                         yStart +
                                         h;
                                       java.awt.image.DataBufferInt dstDB =
                                         (java.awt.image.DataBufferInt)
                                           dst.
                                           getDataBuffer(
                                             );
                                       java.awt.image.DataBufferInt offDB =
                                         (java.awt.image.DataBufferInt)
                                           off.
                                           getDataBuffer(
                                             );
                                       java.awt.image.SinglePixelPackedSampleModel dstSPPSM;
                                       java.awt.image.SinglePixelPackedSampleModel offSPPSM;
                                       dstSPPSM =
                                         (java.awt.image.SinglePixelPackedSampleModel)
                                           dst.
                                           getSampleModel(
                                             );
                                       final int dstOff =
                                         dstDB.
                                         getOffset(
                                           ) +
                                         dstSPPSM.
                                         getOffset(
                                           dst.
                                             getMinX(
                                               ) -
                                             dst.
                                             getSampleModelTranslateX(
                                               ),
                                           dst.
                                             getMinY(
                                               ) -
                                             dst.
                                             getSampleModelTranslateY(
                                               ));
                                       offSPPSM =
                                         (java.awt.image.SinglePixelPackedSampleModel)
                                           off.
                                           getSampleModel(
                                             );
                                       final int offOff =
                                         offDB.
                                         getOffset(
                                           ) +
                                         offSPPSM.
                                         getOffset(
                                           dst.
                                             getMinX(
                                               ) -
                                             off.
                                             getSampleModelTranslateX(
                                               ),
                                           dst.
                                             getMinY(
                                               ) -
                                             off.
                                             getSampleModelTranslateY(
                                               ));
                                       final int dstScanStride =
                                         dstSPPSM.
                                         getScanlineStride(
                                           );
                                       final int offScanStride =
                                         offSPPSM.
                                         getScanlineStride(
                                           );
                                       final int dstAdjust =
                                         dstScanStride -
                                         w;
                                       final int offAdjust =
                                         offScanStride -
                                         w;
                                       final int[] dstPixels =
                                         dstDB.
                                         getBankData(
                                           )[0];
                                       final int[] offPixels =
                                         offDB.
                                         getBankData(
                                           )[0];
                                       final int xShift =
                                         xChannel.
                                         toInt(
                                           ) *
                                         8;
                                       final int yShift =
                                         yChannel.
                                         toInt(
                                           ) *
                                         8;
                                       int dp =
                                         dstOff;
                                       int ip =
                                         offOff;
                                       final int fpScaleX =
                                         (int)
                                           (scaleX /
                                              255.0 *
                                              (1 <<
                                                 15) +
                                              0.5);
                                       final int fpAdjX =
                                         (int)
                                           (-127.5 *
                                              fpScaleX -
                                              0.5);
                                       final int fpScaleY =
                                         (int)
                                           (scaleY /
                                              255.0 *
                                              (1 <<
                                                 15) +
                                              0.5);
                                       final int fpAdjY =
                                         (int)
                                           (-127.5 *
                                              fpScaleY -
                                              0.5);
                                       long start =
                                         java.lang.System.
                                         currentTimeMillis(
                                           );
                                       int pel00;
                                       int pel01;
                                       int pel10;
                                       int pel11;
                                       int xFrac;
                                       int yFrac;
                                       int newPel;
                                       int sp0;
                                       int sp1;
                                       int pel0;
                                       int pel1;
                                       int x;
                                       int y;
                                       int x0;
                                       int y0;
                                       int xDisplace;
                                       int yDisplace;
                                       int dPel;
                                       int xt =
                                         xTile[0] -
                                         1;
                                       int yt =
                                         yTile[0] -
                                         1;
                                       int xt1;
                                       int yt1;
                                       int[] imgPix =
                                         null;
                                       for (y =
                                              yStart;
                                            y <
                                              yEnd;
                                            y++) {
                                           for (x =
                                                  xStart;
                                                x <
                                                  xEnd;
                                                x++,
                                                  dp++,
                                                  ip++) {
                                               dPel =
                                                 offPixels[ip];
                                               xDisplace =
                                                 fpScaleX *
                                                   (dPel >>
                                                      xShift &
                                                      255) +
                                                   fpAdjX;
                                               yDisplace =
                                                 fpScaleY *
                                                   (dPel >>
                                                      yShift &
                                                      255) +
                                                   fpAdjY;
                                               x0 =
                                                 x +
                                                   (xDisplace >>
                                                      15);
                                               y0 =
                                                 y +
                                                   (yDisplace >>
                                                      15);
                                               if (xt !=
                                                     xTile[x0] ||
                                                     yt !=
                                                     yTile[y0]) {
                                                   xt =
                                                     xTile[x0];
                                                   yt =
                                                     yTile[y0];
                                                   imgPix =
                                                     ((java.awt.image.DataBufferInt)
                                                        image.
                                                        getTile(
                                                          xt,
                                                          yt).
                                                        getDataBuffer(
                                                          )).
                                                       getBankData(
                                                         )[0];
                                               }
                                               pel00 =
                                                 imgPix[xOff[x0] +
                                                          yOff[y0]];
                                               xt1 =
                                                 xTile[x0 +
                                                         1];
                                               yt1 =
                                                 yTile[y0 +
                                                         1];
                                               if (yt ==
                                                     yt1) {
                                                   if (xt ==
                                                         xt1) {
                                                       pel10 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0]];
                                                       pel01 =
                                                         imgPix[xOff[x0] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       pel11 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0 +
                                                                         1]];
                                                   }
                                                   else {
                                                       pel01 =
                                                         imgPix[xOff[x0] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt1,
                                                              yt).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel10 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0]];
                                                       pel11 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       xt =
                                                         xt1;
                                                   }
                                               }
                                               else {
                                                   if (xt ==
                                                         xt1) {
                                                       pel10 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0]];
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt,
                                                              yt1).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel01 =
                                                         imgPix[xOff[x0] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       pel11 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       yt =
                                                         yt1;
                                                   }
                                                   else {
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt,
                                                              yt1).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel01 =
                                                         imgPix[xOff[x0] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt1,
                                                              yt1).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel11 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0 +
                                                                         1]];
                                                       imgPix =
                                                         ((java.awt.image.DataBufferInt)
                                                            image.
                                                            getTile(
                                                              xt1,
                                                              yt).
                                                            getDataBuffer(
                                                              )).
                                                           getBankData(
                                                             )[0];
                                                       pel10 =
                                                         imgPix[xOff[x0 +
                                                                       1] +
                                                                  yOff[y0]];
                                                       xt =
                                                         xt1;
                                                   }
                                               }
                                               xFrac =
                                                 xDisplace &
                                                   32767;
                                               yFrac =
                                                 yDisplace &
                                                   32767;
                                               sp0 =
                                                 pel00 >>>
                                                   16 &
                                                   65280;
                                               sp1 =
                                                 pel10 >>>
                                                   16 &
                                                   65280;
                                               pel0 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               sp0 =
                                                 pel01 >>>
                                                   16 &
                                                   65280;
                                               sp1 =
                                                 pel11 >>>
                                                   16 &
                                                   65280;
                                               pel1 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               newPel =
                                                 ((pel0 <<
                                                     15) +
                                                    (pel1 -
                                                       pel0) *
                                                    yFrac +
                                                    4194304 &
                                                    2139095040) <<
                                                   1;
                                               sp0 =
                                                 pel00 >>
                                                   8 &
                                                   65280;
                                               sp1 =
                                                 pel10 >>
                                                   8 &
                                                   65280;
                                               pel0 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               sp0 =
                                                 pel01 >>
                                                   8 &
                                                   65280;
                                               sp1 =
                                                 pel11 >>
                                                   8 &
                                                   65280;
                                               pel1 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               newPel |=
                                                 ((pel0 <<
                                                     15) +
                                                    (pel1 -
                                                       pel0) *
                                                    yFrac +
                                                    4194304 &
                                                    2139095040) >>>
                                                   7;
                                               sp0 =
                                                 pel00 &
                                                   65280;
                                               sp1 =
                                                 pel10 &
                                                   65280;
                                               pel0 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               sp0 =
                                                 pel01 &
                                                   65280;
                                               sp1 =
                                                 pel11 &
                                                   65280;
                                               pel1 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               newPel |=
                                                 ((pel0 <<
                                                     15) +
                                                    (pel1 -
                                                       pel0) *
                                                    yFrac +
                                                    4194304 &
                                                    2139095040) >>>
                                                   15;
                                               sp0 =
                                                 pel00 <<
                                                   8 &
                                                   65280;
                                               sp1 =
                                                 pel10 <<
                                                   8 &
                                                   65280;
                                               pel0 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               sp0 =
                                                 pel01 <<
                                                   8 &
                                                   65280;
                                               sp1 =
                                                 pel11 <<
                                                   8 &
                                                   65280;
                                               pel1 =
                                                 sp0 +
                                                   ((sp1 -
                                                       sp0) *
                                                      xFrac +
                                                      16384 >>
                                                      15) &
                                                   65535;
                                               newPel |=
                                                 ((pel0 <<
                                                     15) +
                                                    (pel1 -
                                                       pel0) *
                                                    yFrac +
                                                    4194304 &
                                                    2139095040) >>>
                                                   23;
                                               dstPixels[dp] =
                                                 newPel;
                                           }
                                           dp +=
                                             dstAdjust;
                                           ip +=
                                             offAdjust;
                                       }
                                       if (TIME) {
                                           long end =
                                             java.lang.System.
                                             currentTimeMillis(
                                               );
                                           java.lang.System.
                                             out.
                                             println(
                                               "Time: " +
                                               (end -
                                                  start));
                                       } }
    public void filterBLPre(java.awt.image.Raster off,
                            java.awt.image.WritableRaster dst,
                            int[] xTile,
                            int[] xOff,
                            int[] yTile,
                            int[] yOff) {
        final int w =
          dst.
          getWidth(
            );
        final int h =
          dst.
          getHeight(
            );
        final int xStart =
          maxOffX;
        final int yStart =
          maxOffY;
        final int xEnd =
          xStart +
          w;
        final int yEnd =
          yStart +
          h;
        java.awt.image.DataBufferInt dstDB =
          (java.awt.image.DataBufferInt)
            dst.
            getDataBuffer(
              );
        java.awt.image.DataBufferInt offDB =
          (java.awt.image.DataBufferInt)
            off.
            getDataBuffer(
              );
        java.awt.image.SinglePixelPackedSampleModel dstSPPSM;
        java.awt.image.SinglePixelPackedSampleModel offSPPSM;
        dstSPPSM =
          (java.awt.image.SinglePixelPackedSampleModel)
            dst.
            getSampleModel(
              );
        final int dstOff =
          dstDB.
          getOffset(
            ) +
          dstSPPSM.
          getOffset(
            dst.
              getMinX(
                ) -
              dst.
              getSampleModelTranslateX(
                ),
            dst.
              getMinY(
                ) -
              dst.
              getSampleModelTranslateY(
                ));
        offSPPSM =
          (java.awt.image.SinglePixelPackedSampleModel)
            off.
            getSampleModel(
              );
        final int offOff =
          offDB.
          getOffset(
            ) +
          offSPPSM.
          getOffset(
            dst.
              getMinX(
                ) -
              off.
              getSampleModelTranslateX(
                ),
            dst.
              getMinY(
                ) -
              off.
              getSampleModelTranslateY(
                ));
        final int dstScanStride =
          dstSPPSM.
          getScanlineStride(
            );
        final int offScanStride =
          offSPPSM.
          getScanlineStride(
            );
        final int dstAdjust =
          dstScanStride -
          w;
        final int offAdjust =
          offScanStride -
          w;
        final int[] dstPixels =
          dstDB.
          getBankData(
            )[0];
        final int[] offPixels =
          offDB.
          getBankData(
            )[0];
        final int xShift =
          xChannel.
          toInt(
            ) *
          8;
        final int yShift =
          yChannel.
          toInt(
            ) *
          8;
        int dp =
          dstOff;
        int ip =
          offOff;
        final int fpScaleX =
          (int)
            (scaleX /
               255.0 *
               (1 <<
                  15) +
               0.5);
        final int fpAdjX =
          (int)
            (-127.5 *
               fpScaleX -
               0.5);
        final int fpScaleY =
          (int)
            (scaleY /
               255.0 *
               (1 <<
                  15) +
               0.5);
        final int fpAdjY =
          (int)
            (-127.5 *
               fpScaleY -
               0.5);
        long start =
          java.lang.System.
          currentTimeMillis(
            );
        int pel00;
        int pel01;
        int pel10;
        int pel11;
        int xFrac;
        int yFrac;
        int newPel;
        int sp0;
        int sp1;
        int pel0;
        int pel1;
        int a00;
        int a01;
        int a10;
        int a11;
        int x;
        int y;
        int x0;
        int y0;
        int xDisplace;
        int yDisplace;
        int dPel;
        final int norm =
          (1 <<
             24) /
          255;
        int xt =
          xTile[0] -
          1;
        int yt =
          yTile[0] -
          1;
        int xt1;
        int yt1;
        int[] imgPix =
          null;
        for (y =
               yStart;
             y <
               yEnd;
             y++) {
            for (x =
                   xStart;
                 x <
                   xEnd;
                 x++,
                   dp++,
                   ip++) {
                dPel =
                  offPixels[ip];
                xDisplace =
                  fpScaleX *
                    (dPel >>
                       xShift &
                       255) +
                    fpAdjX;
                yDisplace =
                  fpScaleY *
                    (dPel >>
                       yShift &
                       255) +
                    fpAdjY;
                x0 =
                  x +
                    (xDisplace >>
                       15);
                y0 =
                  y +
                    (yDisplace >>
                       15);
                if (xt !=
                      xTile[x0] ||
                      yt !=
                      yTile[y0]) {
                    xt =
                      xTile[x0];
                    yt =
                      yTile[y0];
                    imgPix =
                      ((java.awt.image.DataBufferInt)
                         image.
                         getTile(
                           xt,
                           yt).
                         getDataBuffer(
                           )).
                        getBankData(
                          )[0];
                }
                pel00 =
                  imgPix[xOff[x0] +
                           yOff[y0]];
                xt1 =
                  xTile[x0 +
                          1];
                yt1 =
                  yTile[y0 +
                          1];
                if (yt ==
                      yt1) {
                    if (xt ==
                          xt1) {
                        pel10 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0]];
                        pel01 =
                          imgPix[xOff[x0] +
                                   yOff[y0 +
                                          1]];
                        pel11 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0 +
                                          1]];
                    }
                    else {
                        pel01 =
                          imgPix[xOff[x0] +
                                   yOff[y0 +
                                          1]];
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt1,
                               yt).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel10 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0]];
                        pel11 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0 +
                                          1]];
                        xt =
                          xt1;
                    }
                }
                else {
                    if (xt ==
                          xt1) {
                        pel10 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0]];
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt,
                               yt1).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel01 =
                          imgPix[xOff[x0] +
                                   yOff[y0 +
                                          1]];
                        pel11 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0 +
                                          1]];
                        yt =
                          yt1;
                    }
                    else {
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt,
                               yt1).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel01 =
                          imgPix[xOff[x0] +
                                   yOff[y0 +
                                          1]];
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt1,
                               yt1).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel11 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0 +
                                          1]];
                        imgPix =
                          ((java.awt.image.DataBufferInt)
                             image.
                             getTile(
                               xt1,
                               yt).
                             getDataBuffer(
                               )).
                            getBankData(
                              )[0];
                        pel10 =
                          imgPix[xOff[x0 +
                                        1] +
                                   yOff[y0]];
                        xt =
                          xt1;
                    }
                }
                xFrac =
                  xDisplace &
                    32767;
                yFrac =
                  yDisplace &
                    32767;
                sp0 =
                  pel00 >>>
                    16 &
                    65280;
                sp1 =
                  pel10 >>>
                    16 &
                    65280;
                pel0 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                a00 =
                  (sp0 >>
                     8) *
                    norm +
                    128 >>
                    8;
                a10 =
                  (sp1 >>
                     8) *
                    norm +
                    128 >>
                    8;
                sp0 =
                  pel01 >>>
                    16 &
                    65280;
                sp1 =
                  pel11 >>>
                    16 &
                    65280;
                pel1 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                a01 =
                  (sp0 >>
                     8) *
                    norm +
                    128 >>
                    8;
                a11 =
                  (sp1 >>
                     8) *
                    norm +
                    128 >>
                    8;
                newPel =
                  ((pel0 <<
                      15) +
                     (pel1 -
                        pel0) *
                     yFrac +
                     4194304 &
                     2139095040) <<
                    1;
                sp0 =
                  (pel00 >>
                     16 &
                     255) *
                    a00 +
                    128 >>
                    8;
                sp1 =
                  (pel10 >>
                     16 &
                     255) *
                    a10 +
                    128 >>
                    8;
                pel0 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                sp0 =
                  (pel01 >>
                     16 &
                     255) *
                    a01 +
                    128 >>
                    8;
                sp1 =
                  (pel11 >>
                     16 &
                     255) *
                    a11 +
                    128 >>
                    8;
                pel1 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                newPel |=
                  ((pel0 <<
                      15) +
                     (pel1 -
                        pel0) *
                     yFrac +
                     4194304 &
                     2139095040) >>>
                    7;
                sp0 =
                  (pel00 >>
                     8 &
                     255) *
                    a00 +
                    128 >>
                    8;
                sp1 =
                  (pel10 >>
                     8 &
                     255) *
                    a10 +
                    128 >>
                    8;
                pel0 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                sp0 =
                  (pel01 >>
                     8 &
                     255) *
                    a01 +
                    128 >>
                    8;
                sp1 =
                  (pel11 >>
                     8 &
                     255) *
                    a11 +
                    128 >>
                    8;
                pel1 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                newPel |=
                  ((pel0 <<
                      15) +
                     (pel1 -
                        pel0) *
                     yFrac +
                     4194304 &
                     2139095040) >>>
                    15;
                sp0 =
                  (pel00 &
                     255) *
                    a00 +
                    128 >>
                    8;
                sp1 =
                  (pel10 &
                     255) *
                    a10 +
                    128 >>
                    8;
                pel0 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                sp0 =
                  (pel01 &
                     255) *
                    a01 +
                    128 >>
                    8;
                sp1 =
                  (pel11 &
                     255) *
                    a11 +
                    128 >>
                    8;
                pel1 =
                  sp0 +
                    ((sp1 -
                        sp0) *
                       xFrac +
                       16384 >>
                       15) &
                    65535;
                newPel |=
                  ((pel0 <<
                      15) +
                     (pel1 -
                        pel0) *
                     yFrac +
                     4194304 &
                     2139095040) >>>
                    23;
                dstPixels[dp] =
                  newPel;
            }
            dp +=
              dstAdjust;
            ip +=
              offAdjust;
        }
        if (TIME) {
            long end =
              java.lang.System.
              currentTimeMillis(
                );
            java.lang.System.
              out.
              println(
                "Time: " +
                (end -
                   start));
        }
    }
    public void filterNN(java.awt.image.Raster off,
                         java.awt.image.WritableRaster dst,
                         int[] xTile,
                         int[] xOff,
                         int[] yTile,
                         int[] yOff) { final int w =
                                         dst.
                                         getWidth(
                                           );
                                       final int h =
                                         dst.
                                         getHeight(
                                           );
                                       final int xStart =
                                         maxOffX;
                                       final int yStart =
                                         maxOffY;
                                       final int xEnd =
                                         xStart +
                                         w;
                                       final int yEnd =
                                         yStart +
                                         h;
                                       java.awt.image.DataBufferInt dstDB =
                                         (java.awt.image.DataBufferInt)
                                           dst.
                                           getDataBuffer(
                                             );
                                       java.awt.image.DataBufferInt offDB =
                                         (java.awt.image.DataBufferInt)
                                           off.
                                           getDataBuffer(
                                             );
                                       java.awt.image.SinglePixelPackedSampleModel dstSPPSM;
                                       java.awt.image.SinglePixelPackedSampleModel offSPPSM;
                                       dstSPPSM =
                                         (java.awt.image.SinglePixelPackedSampleModel)
                                           dst.
                                           getSampleModel(
                                             );
                                       final int dstOff =
                                         dstDB.
                                         getOffset(
                                           ) +
                                         dstSPPSM.
                                         getOffset(
                                           dst.
                                             getMinX(
                                               ) -
                                             dst.
                                             getSampleModelTranslateX(
                                               ),
                                           dst.
                                             getMinY(
                                               ) -
                                             dst.
                                             getSampleModelTranslateY(
                                               ));
                                       offSPPSM =
                                         (java.awt.image.SinglePixelPackedSampleModel)
                                           off.
                                           getSampleModel(
                                             );
                                       final int offOff =
                                         offDB.
                                         getOffset(
                                           ) +
                                         offSPPSM.
                                         getOffset(
                                           off.
                                             getMinX(
                                               ) -
                                             off.
                                             getSampleModelTranslateX(
                                               ),
                                           off.
                                             getMinY(
                                               ) -
                                             off.
                                             getSampleModelTranslateY(
                                               ));
                                       final int dstScanStride =
                                         dstSPPSM.
                                         getScanlineStride(
                                           );
                                       final int offScanStride =
                                         offSPPSM.
                                         getScanlineStride(
                                           );
                                       final int dstAdjust =
                                         dstScanStride -
                                         w;
                                       final int offAdjust =
                                         offScanStride -
                                         w;
                                       final int[] dstPixels =
                                         dstDB.
                                         getBankData(
                                           )[0];
                                       final int[] offPixels =
                                         offDB.
                                         getBankData(
                                           )[0];
                                       final int xShift =
                                         xChannel.
                                         toInt(
                                           ) *
                                         8;
                                       final int yShift =
                                         yChannel.
                                         toInt(
                                           ) *
                                         8;
                                       final int fpScaleX =
                                         (int)
                                           (scaleX /
                                              255.0 *
                                              (1 <<
                                                 15) +
                                              0.5);
                                       final int fpScaleY =
                                         (int)
                                           (scaleY /
                                              255.0 *
                                              (1 <<
                                                 15) +
                                              0.5);
                                       final int fpAdjX =
                                         (int)
                                           (-127.5 *
                                              fpScaleX -
                                              0.5) +
                                         16384;
                                       final int fpAdjY =
                                         (int)
                                           (-127.5 *
                                              fpScaleY -
                                              0.5) +
                                         16384;
                                       int dp =
                                         dstOff;
                                       int ip =
                                         offOff;
                                       long start =
                                         java.lang.System.
                                         currentTimeMillis(
                                           );
                                       int y =
                                         yStart;
                                       int xt =
                                         xTile[0] -
                                         1;
                                       int yt =
                                         yTile[0] -
                                         1;
                                       int[] imgPix =
                                         null;
                                       int x0;
                                       int y0;
                                       int xDisplace;
                                       int yDisplace;
                                       int dPel;
                                       while (y <
                                                yEnd) {
                                           int x =
                                             xStart;
                                           while (x <
                                                    xEnd) {
                                               dPel =
                                                 offPixels[ip];
                                               xDisplace =
                                                 fpScaleX *
                                                   (dPel >>
                                                      xShift &
                                                      255) +
                                                   fpAdjX;
                                               yDisplace =
                                                 fpScaleY *
                                                   (dPel >>
                                                      yShift &
                                                      255) +
                                                   fpAdjY;
                                               x0 =
                                                 x +
                                                   (xDisplace >>
                                                      15);
                                               y0 =
                                                 y +
                                                   (yDisplace >>
                                                      15);
                                               if (xt !=
                                                     xTile[x0] ||
                                                     yt !=
                                                     yTile[y0]) {
                                                   xt =
                                                     xTile[x0];
                                                   yt =
                                                     yTile[y0];
                                                   imgPix =
                                                     ((java.awt.image.DataBufferInt)
                                                        image.
                                                        getTile(
                                                          xt,
                                                          yt).
                                                        getDataBuffer(
                                                          )).
                                                       getBankData(
                                                         )[0];
                                               }
                                               dstPixels[dp] =
                                                 imgPix[xOff[x0] +
                                                          yOff[y0]];
                                               dp++;
                                               ip++;
                                               x++;
                                           }
                                           dp +=
                                             dstAdjust;
                                           ip +=
                                             offAdjust;
                                           y++;
                                       }
                                       if (TIME) {
                                           long end =
                                             java.lang.System.
                                             currentTimeMillis(
                                               );
                                           java.lang.System.
                                             out.
                                             println(
                                               "Time: " +
                                               (end -
                                                  start));
                                       } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WKPKhpeN4bK/hoVZ7KprSNIEU0HWMzdi");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("0lmS4OqcG+iBSA8r2DpKiaw7Kc/nazVshSraWg40tTzRMKYjxulAwadI7BDM" +
       "CLWdqOKpJjOPpkK5bQfMOEPXNLqarev1LYTT1jCqsZvthkFEvj+jAgzD3pdv" +
       "X33t9W2rPVzsIB6edFzaxWuxV1/Hztnu0TN58a7DPdbic6504nTcsT3WYy/V" +
       "S/lr/ydvd4CxOATxhY+/+JLG/mx5b3/z9XpUeiDy/PfY+ka3j3V1HvT0wu03" +
       "z5liD/voJfmvfvyPH5+83/zQ6zjO9c4TOE92+Y+Zl3+990Pq390r3Xf4yvyW" +
       "k6U3N7p+84vyi4EexYE7uel1+ZOHkn08l9iz4HplX7KvnNy9Ppq701/x/chu" +
       "7k+c9Tizfyhuf+f4ycNzIrud+VlgRcURHjmM9KDo4b/e4bTIH+fF70elC6rn" +
       "p4QcyfnvPzxSqD+421bs8Q6Liq8fSuBKXpm/APqlfQn80psjgb2CYC//Wbye" +
       "erGg+l934PI7efE/o9J5Q4/y1xMHwnvHCeHthHbE/be/B+4fPZj/r+1z/7U3" +
       "df4PGT+zd3vGz5zNK/8sKr0FMC4eewnypSMe//zN4PG1fR5f+z7x+NAdeLyc" +
       "Fw/seJyfyuOZi98Dj8XRyCpA8/Zd2zNX3hwezxUE5/Kff3JkdC8fjlucErhU" +
       "Kp0d7sbdfUel9Zt6cFj2/RAON4YSeNtQD+Chp+kjS13pAehPtw9OK//lD1rI" +
       "7MVTvV7+9ufME/sv/848fbrkC/dQxNGjsze27hq7o+G53zjzg35y0qccOIa3" +
       "Hb0dw23P1XOPevBsd2zZ8q4d/jsCPExORfr1HdJisGPR9zR1OK7R77nDMzgv" +
       "XohK96s5rh0bdyCvJKWC5qgoqh+/Q5P8Bd0ZwOeFhWUDb9imT31tt/Es7cjA" +
       "HvleDawBRPab+wb21e+TgZ0QxJE0sDtIA8+L9wLvciCNUVBIvXHE/PveBO+y" +
       "95ld272f+stmnrkD82xekIeqUJxbO8459Xo4T6LSlVuPC+Qnmx+75a9Lu7/b" +
       "qK+8dOnCoy8J/353CuLgLzEP0ABQbNvHDy0euz/nB/rCKqTywO4Io18wM41K" +
       "P3yPxxoAxwe3ORtnhF0P86j01J17ODj9dLzVj0Wlx27XKirdB8rj1DeAgzmN" +
       "GlCC8jilEpUun6QE4xffx+kAqItHdMAN7m6Ok5igd0CS31r+gZ+751PjmBJG" +
       "gaxGYDaTMzevFw40pXTlbppybInx3E0Lg+LfbwdJfLz7/9sN9Ysv9Ycffq3x" +
       "s7t/HKi2nGV5Lxfo0vndnx8OFwLP3La3g77Okc9/96EvPfCug0XLQzvAR4Z3" +
       "DNs7Tz/e33H8qDiQn/2zR7/83p976evFKYr/B5bWYd2WOAAA");
}
