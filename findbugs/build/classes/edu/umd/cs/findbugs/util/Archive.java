package edu.umd.cs.findbugs.util;
public class Archive {
    @edu.umd.cs.findbugs.internalAnnotations.StaticConstant
    public static final java.util.Set<java.lang.String> ARCHIVE_EXTENSION_SET =
      new java.util.HashSet<java.lang.String>(
      );
    static { ARCHIVE_EXTENSION_SET.add(".jar");
             ARCHIVE_EXTENSION_SET.add(".zip");
             ARCHIVE_EXTENSION_SET.add(".war");
             ARCHIVE_EXTENSION_SET.add(".ear");
             ARCHIVE_EXTENSION_SET.add(".sar"); }
    public static boolean isArchiveFileName(java.lang.String fileName) { java.lang.String extension =
                                                                           getExtension(
                                                                             fileName);
                                                                         return ARCHIVE_EXTENSION_SET.
                                                                           contains(
                                                                             extension);
    }
    private static java.lang.String getExtension(java.lang.String fileName) {
        int lastDot =
          fileName.
          lastIndexOf(
            '.');
        if (lastDot <
              0) {
            return fileName;
        }
        java.lang.String extension =
          fileName.
          substring(
            lastDot).
          toLowerCase(
            java.util.Locale.
              ENGLISH);
        return extension;
    }
    public static boolean isLibraryFileName(java.lang.String fileName) {
        java.lang.String extension =
          getExtension(
            fileName);
        return ".jar".
          equals(
            extension);
    }
    public Archive() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZfXBU1RW/uwlJCCFfEEA+AoQAEz52xSqUCVJCSGBxE7bZ" +
       "EOtiWd6+vZs88va9x3t3kw2KVWccsDNQqqi0o/zRwfoxCExHpq1fQ4dWRaFT" +
       "ra1QK9rWTlHLVKajdkqrPffe9/Z97G4iHd2Zd/ftveeee8+55/zOOXePXELj" +
       "DB01YoUEyIiGjUCHQiKCbuBkuywYRi/0xcWHSoR/br3YvdKPymKoekAwukTB" +
       "wJ0SlpNGDM2SFIMIioiNboyTdEZExwbWhwQiqUoMNUhGKK3JkiiRLjWJKUGf" +
       "oIdRnUCILiUyBIdMBgTNCsNOgmwnwTbvcGsYVYmqNmKTT3OQtztGKGXaXssg" +
       "qDa8XRgSghkiycGwZJDWrI4Wa6o80i+rJICzJLBdvsFUwcbwDXkqaDpe88mV" +
       "/QO1TAWTBEVRCRPP6MGGKg/hZBjV2L0dMk4bO9AdqCSMJjiICWoOW4sGYdEg" +
       "LGpJa1PB7idiJZNuV5k4xOJUpol0QwTNdTPRBF1Im2wibM/AoYKYsrPJIO2c" +
       "nLRcyjwRH1gcPPDQ1tqflKCaGKqRlCjdjgibILBIDBSK0wmsG23JJE7GUJ0C" +
       "hx3FuiTI0k7zpOsNqV8RSAaO31IL7cxoWGdr2rqCcwTZ9IxIVD0nXooZlPlr" +
       "XEoW+kHWKbasXMJO2g8CVkqwMT0lgN2ZU0oHJSVJ0GzvjJyMzTcBAUwtT2My" +
       "oOaWKlUE6ED13ERkQekPRsH0lH4gHaeCAeoETS/KlOpaE8RBoR/HqUV66CJ8" +
       "CKjGM0XQKQQ1eMkYJzil6Z5TcpzPpe5V+25TNih+5IM9J7Eo0/1PgEmNnkk9" +
       "OIV1DH7AJ1YtCj8oTHl+jx8hIG7wEHOan95+ec2SxpMvc5oZBWg2JbZjkcTF" +
       "w4nq12a2t6wsoduo0FRDoofvkpx5WcQcac1qgDBTchzpYMAaPNnz4i13Pok/" +
       "9KPKECoTVTmTBjuqE9W0JslYX48VrAsEJ0NoPFaS7Ww8hMrhPSwpmPduSqUM" +
       "TEKoVGZdZSr7DSpKAQuqokp4l5SUar1rAhlg71kNIVQOD6qCZy7iH/ZN0M3B" +
       "ATWNg4IoKJKiBiO6SuU3goA4CdDtQDAFxpTI9BtBQxeDzHRwMhPMpJNB0bAH" +
       "mS7adHFAGsIBSqV9dayzVKpJwz4fKHym191l8JQNqpzEelw8kFnbcflo/FVu" +
       "StT8TX0QNAdWCsBKAdEIWCvxMzNXQj4fW2AyXZGPwFkMglcDrFa1RL+9cdue" +
       "phIwI224FBRJSZtc4aXddn0Lr+PisfqJO+deWHbKj0rDqF4QSUaQabRo0/sB" +
       "h8RB01WrEhB4bPyf48B/Grh0VYTt67hYHDC5VKhDWKf9BE12cLCiE/XDYPHY" +
       "UHD/6OTB4bv6vnOtH/ndkE+XHAdoRadHKFDnALnZ6+qF+NbsvvjJsQd3qbbT" +
       "u2KIFfryZlIZmrwm4FVPXFw0RzgRf35XM1P7eABlIoATAd41etdwYUqrhc9U" +
       "lgoQOKXqaUGmQ5aOK8mArg7bPcw262jTwM2UmpBngwzab4xqj5z79ftfY5q0" +
       "okCNI3xHMWl1IA9lVs8wps62yF4dY6B7+2Dk/gcu7d7CzBEo5hVasJm27YA4" +
       "cDqgwXte3nH+nQuH3/DbJkwg9GYSkMFkmSyTP4ePD57P6EPRgnZw1KhvN6Fr" +
       "Tg67NLryAntvgGIyuDs1jubNCpihlJKEhIyp//ynZv6yE3/fV8uPW4Yey1qW" +
       "jM3A7r9mLbrz1a2fNjI2PpFGUVt/NhmH5kk25zZdF0boPrJ3vT7rBy8JjwDI" +
       "A7Aa0k7MsBIxfSB2gDcwXVzL2us9YytoM99w2rjbjRzZTlzc/8ZHE/s+euEy" +
       "2607XXKee5egtXIr4qcAizUgs3FhNx2dotF2ahb2MNULVBsEYwCYXX+y+9Za" +
       "+eQVWDYGy4qQSBibdMDHrMuUTOpx5X/4xakp214rQf5OVCmrQrJTYA6HxoOl" +
       "Y2MAoDWrfWMN38dwBTS1TB8oT0N5HfQUZhc+3460RtiJ7PzZ1KdXPXboAjNL" +
       "jfOYkUPYmS6EZZm57eRP/nbF7x77/oPDPLa3FEc2z7xp/94kJ+7+87/yzoVh" +
       "WoG8wzM/Fjzy8PT21R+y+Ta40NnN2fwIBQBtz73uyfTH/qayX/lReQzVimYm" +
       "3CfIGerXMcj+DCs9hmzZNe7O5Hja0poDz5leYHMs64U1OzLCO6Wm7xM9NjiN" +
       "HmEPPAtNG1zotUEfYi8b2ZQFrG2hzRJ2fCX0dSlAjMHybQJbkBRBzuYWYDYy" +
       "dZQFIJ1s62nfEOrriHd8q7ejOxra1B2PdvRSwLPtgka3aCZhENY48kr11roJ" +
       "Pzoaxdw8GgvMcBDve/aZWGxhrciJmwoQe5LPxx+rEN9Kv/gen3BNgQmcruHx" +
       "4N6+N7efYbBfQcN8r6VwRxCHdMARTmptOEaF4XiSK2wEWP1EvUdHs1we4xXz" +
       "T90zK9XBSB3f9aLiLuOduFc6dPaVj2vuKuRrrE4zp3rnnT9Xct0E0vw9Jn4p" +
       "FZ8l92CQBqWkqU7Rmo/x4tBYTZubue1MI2iiDSogPu3cSsNuvuhxMdvQO7ml" +
       "6pvv8o3PHUPiuBhKx6Mnzu9ezpy7ZkiCYMyLf15vT3HV21Z62OqqQwvqJC5e" +
       "PLb35bkf9E1iBQYXn+58JcAk/b7RxFgfw1i/CYAzXDKZ+2BRMS6eWSKtqPjj" +
       "G09w0eYXEc095/aHPzv7/q4Lp0tQGeQyFDoEHcoQqHMCxSp4J4PmXnhbB7MA" +
       "Uqr5bKgn2Xmb51qf682lZQQtLcabXkkUSG4hDg1jfa2aUZIMVd2QVZnRNOco" +
       "s5Ca/9dn7oAc5AuoLie5CVaonmm9mlkiRWQ4n0zaOQhFx6T2cFs0Gu+9JdIR" +
       "72vrCbWtDXcwa9Vg0NdhmXOtzYTDerbACC/ds84I6Qi5vlzInOyGIu6G6+6t" +
       "eW5/fUkn5MMhVJFRpB0ZHEq61VoOJunAJrust6NDLW0CWapT2P8i0B5PeWn7" +
       "ddrcxHe0yrTlqly+4LMkWl6oDmNXHhAcHOlTIHdNY98VrSqUhmRNLeQFIB8L" +
       "QHa8YZ+yUZIqt2YBSovdWbD7lsN3HziU3PToMu599e57AGoLT/3+v2cCB989" +
       "XaAYHU9UbamMh7DsWLMkD7272HWOnTy8XX3fX37e3L/2aopJ2tc4RrlIf88e" +
       "PR54t/LS3R9M7109sO0q6sLZHnV6WT7RdeT0+gXifX52d8Wzmrw7L/ekVg8w" +
       "ANZkdMVts/NyBjCdHuxieFaaBrDSm9HY1pxnTX5mTbTp9qQwdaNw9NQSPtsw" +
       "CVvs/lGKjQdos5egOskwryg6oQDrBnGNwhlKRJfSUDoOmT5/XWSbuKc5wjIU" +
       "ymozd15j1FTZwyO4q/6dwYcvPmXmUHmFt4sY7znw3c8D+w5wg+eXlvPy7g2d" +
       "c/jFpRNaDGeMLrAKm9H5t2O7nn18125LsnsIKk+oqowFpZCqR7I2QO3LFkeS" +
       "L1DQ0I61PF7f67arBfCsNq1g9dXYFexd06UhqKgLGVf9KGzHMq4joxjXUdo8" +
       "SlBVPyYdWYIVw7xyILaufvxV6Yr64HpTqPVfmg8W4ziWmp4ZRU3P0eZp5oNh" +
       "KaEL+ojlg3TgoK2rE1+GrrJgC6ar09J5Wt4/G/w2Xjx6qKZi6qHNb7I4kLsx" +
       "rwJET2Vk2VncOd7LNB2nJCZVFS/1ePT+JUHTit2NElRKv9h+T3HylyCrKUBO" +
       "YG3z1Un9CkGVNjVBftE1fBYENocJKoHWOfgb6IJB+vqaVjxV8uUnROxEGsY6" +
       "EUekn1c0d+/K8H+e4uKxQxu7b7u8/FF+fwfZ486dlAukvOX8ljAX6OYW5Wbx" +
       "KtvQcqX6+Pj5FoC57g+de2N2AdbK7tqmey60jObcvdb5w6teOLun7HWA3i3I" +
       "J8AZbcm/K8hqGcgwtoTzE0QryW1t+eHI6iWpf7zFbmNQ3h2Mlz4uxu4/Fzo+" +
       "+Oka9kfHOLAAnGWXGOtGlB4sDumubLNwxTDRVTEQ1JQfMsasECBfnWD3uP4A" +
       "s3IDd9FAJ9g9jto7y+MQ1T7YXzzcpWlmCVEa05ifjhSOMbR9j73S5q//A+AA" +
       "4zaCHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6C6zj2Hke587s7MPrndnd2N5u7fWuPba7VnIpUpQoYVLX" +
       "JEWJpEiKkijq0TbXfEqU+BIfIkV709hAaqNBbCNZJw7qLNDCQZrA8QZtjQRI" +
       "024TpLGbpECKoI0L1A6KAnWSGohRJA3qNukhde/VvXdm1l0XEaAj6jz+8z+/" +
       "8x+e84VvQg9FIVQJfGe3cPz42Mzi45VTP453gRkdc3xdUsPINChHjSIZ1J3o" +
       "7/rFW3/27U8vbx9BN+fQ06rn+bEa274XDc3Id7amwUO3DrW0Y7pRDN3mV+pW" +
       "hZPYdmDejuK7PPSmC0Nj6A5/xgIMWIABC3DJAkwceoFBbza9xKWKEaoXRxvo" +
       "B6FrPHQz0Av2YuiFy0QCNVTdUzJSKQGg8EjxXwFClYOzEHr+XPa9zPcI/JkK" +
       "/PJP/sDtf3odujWHbtneqGBHB0zEYJI59LhrupoZRoRhmMYcetIzTWNkhrbq" +
       "2HnJ9xx6KrIXnhonoXmupKIyCcywnPOgucf1QrYw0WM/PBfPsk3HOPv3kOWo" +
       "CyDrWw+y7iXsFPVAwMdswFhoqbp5NuTG2vaMGHrn1RHnMt7pgQ5g6MOuGS/9" +
       "86lueCqogJ7a285RvQU8ikPbW4CuD/kJmCWGnn0g0ULXgaqv1YV5EkPPXO0n" +
       "7ZtAr0dLRRRDYugtV7uVlICVnr1ipQv2+ab4/Z/8sMd4RyXPhqk7Bf+PgEHP" +
       "XRk0NC0zND3d3A98/P38T6hv/dVPHEEQ6PyWK533fX7pI9/64Pc+99qX933+" +
       "+n369LWVqccn+ue1J3737dSLresFG48EfmQXxr8keen+0mnL3SwAkffWc4pF" +
       "4/FZ42vDfzP7oZ83//gIeoyFbuq+k7jAj57UfTewHTPsmp4ZqrFpsNCjpmdQ" +
       "ZTsLPQyeedsz97V9y4rMmIVuOGXVTb/8D1RkARKFih4Gz7Zn+WfPgRovy+cs" +
       "gCDoYfCFHgffF6D9p/yNoQm89F0TVnXVsz0flkK/kD+CTS/WgG6XsAWcSUsW" +
       "ERyFOly6jmkkcOIasB4dGktdEKG+tLfmcdEr+KsjnRVS3U6vXQMKf/vVcHdA" +
       "pDC+Y5jhif5yQtLf+uLJbx2du/+pPmLoeTDTMZjpWI+Oz2ba2+x0JujatXKC" +
       "7ylm3LcAW6xBVAO8e/zF0d/lPvSJd10HbhSkN4Aii67wg2GXOuAAW6KdDpwR" +
       "eu2z6UeVv1c9go4u42fBJah6rBguFah3jm53rsbN/eje+vg3/uzVn3jJP0TQ" +
       "JUA+Dex7RxaB+a6r+gx9HagqNA/k3/+8+qWTX33pzhF0A0Q7QLhYBR4JwOO5" +
       "q3NcCtC7Z2BXyPIQENjyQ1d1iqYzhHosXoZ+eqgpDf1E+fwk0PFboNPikgsX" +
       "rU8HRfk9e8cojHZFihJM/+Yo+Onf/3d/WCvVfYa7ty6sZCMzvnsh1gtit8qo" +
       "fvLgA3JomqDff/6s9OOf+ebH/3bpAKDHu+834Z2ipECMAxMCNf/wlzdf/frX" +
       "Pv97RwenicFil2iOrWd7If8SfK6B718U30K4omIfp09Rp2Dx/DlaBMXM7z3w" +
       "BnDDAQFWeNCdsef6hm3ZquaYhcf+71vvQb703z95e+8TDqg5c6nv/c4EDvV/" +
       "jYR+6Ld+4H8+V5K5phfr1kF/h257MHz6QJkIQ3VX8JF99N+/46d+U/1pAKsA" +
       "yiI7N0t0gkp9QKUBq6UuKmUJX2lDi+Kd0cVAuBxrF/KLE/3Tv/cnb1b+5F9+" +
       "q+T2coJy0e6CGtzdu1pRPJ8B8m+7GvWMGi1BP+w18e/cdl77NqA4BxR1sCpH" +
       "/RCATXbJS057P/Twf/rXv/7WD/3udeioAz3m+KrRUcuAgx4Fnm5GS4BTWfC3" +
       "Prj35vQRUNwuRYXuEX7vIM+U/24ABl98MNZ0ivziEK7P/K++o33sv/z5PUoo" +
       "UeY+y+qV8XP4C597lvrAH5fjD+FejH4uuxeAQS52GIv+vPunR++6+RtH0MNz" +
       "6LZ+mugpqpMUQTQHyU10lv2BZPBS++VEZb8q3z2Hs7dfhZoL014FmgPwg+ei" +
       "d/H82BVseabQ8hB833eKLe+7ii3XoPLhg+WQF8ryTlG8r7TJ9eLxb4B4jsp0" +
       "MgYs2J7qlLO8CBIhYkgxrEKf0FOZFkdsXzwZ0TKw4/sfbMdRokXxhcToR+1X" +
       "fuff/umtj+5zl8sOUObGp0Ovjvvq719H3xTf+VSJezc0NSoV8AjQUlT0BGvh" +
       "g/PsktY+ON50gCjo/hD19CUoPS6z+CDYe+5bYujNh/gAzUWlABTwwndQwInO" +
       "uiejL331443SAW9tbYDOpiGfpv2XEeiwQt+9tBW4r4pO9G+8+qNffuGPlKfL" +
       "HG+vjYItDKBX8YufRua1MjKPTlf59zyA4VOOSsA80T/yub/4nT986WtfuQ7d" +
       "BOta4bRqCPI7kEAeP2hrdJHAHRk8tcEo4MxP7EeDRL006qnxnjqvPV+iY+j7" +
       "HkS72PldXcmLzYXjp2ZI+olnlPF8OVgeS4LgYmvpBo9/t27wg2Cp+X9Q3bnk" +
       "p3EIPVW6+xOl8xRYcEyDPePFRpDNPU3xxGh0Is8k+kQhhixB8nTpYAFovEaf" +
       "eeDtA5E9oGT3adnviS4BLnSaWBRlrSiIfWvj1EEeP4fua2cEG/fLL8utHECF" +
       "C4vU8fn287AHbtxvRThdE+6WgJJdA6nDQ+gxflwt/tuvh0lF0S4K+gyM3rZy" +
       "9Dtn6YQC9rqAkTsrBy+a1SuSvpg9mKXLDEWXjMT7YF/5I//107/9qXd/HQQu" +
       "Bz20LVAdWPKCqsWk2Gr//S985h1vevkPfqTMi4AKRy9q/+ODBdXgjYn1bCHW" +
       "yE9C3eTVKBbK9MU0Cslef8GUQtsFGd/2dB8Jv/TU19ef+8Yv7HH26up4pbP5" +
       "iZf/wV8ef/Llows783ffszm+OGa/Oy+ZfvOphi+i4H1mKUd0/turL/3KP3np" +
       "43uunrq8zyxC4hf+w//57ePP/sFX7rPZueEAa3zXho1v/TmDRSxx9uGVuTUl" +
       "x8hwAiepw1FUx6JpokL4A4LO62g22owphaNGXTKjcW1O92N7YjQq23nUbG7V" +
       "VlaLa+sU7SkTXY/a4mCzsas+nA9Ty88oOmOCDWINMGMyVDtyqCKDXiucyA7D" +
       "Kz11Zaw3oWRZZguet/AuZjMGOjdgK96a4NOs1Otw3u9PTWlK86s2WUVm/pje" +
       "sXZ3NaaYgd2jtIRcJ7t0NrThaqZPmJE/hLWwNtsaPWnn9nxzTaTJWiZTrjpy" +
       "ArHbFtBRhxVY27dFzd/JBj2ns1SbLNOBvRn7gjhednu9Gre27SG/mnC9cdfy" +
       "WWPojSmWt8c7kjUEciGLVCT2F27qpbK21bvRTJm5G9HtyXKtP4jzuNvrTtVp" +
       "FC02bbU5HS5Gi+Xa3unddM61JyGLTdSG36zalZBjqZzjSWMbdcaprqXt6Xqj" +
       "tgOz2XQVeNBHZGIik7QypIaS1BC63d4CXs7JlYLyVUNYY1q/RRgbaiRwK5ul" +
       "Jn5/gkXdmUEv+G7AqYhE4rZhc3MxUeprLOtzY+Bl1UEqi4YsDckOwrpoamsC" +
       "TPiz3iwKJY7to7rHD/XdKh0yyEKXpPYAiTeW06PUbm8zdKiVsVrYGsuTbJsc" +
       "9aqpG3XRGsfReHfMVallVusktsxW13ge9CNxozSHI0Lt1xCWx/XMn3SNEA03" +
       "lJ7K8xabsUq76k19f+5ITjil/UllzUx6IKOZClwfXTQpZb1JBbnqLER0Pq76" +
       "DDdSuGo33664nZDLOkmM01hGhZ3fVyc9Z0w36DZSo4frgbmWhhFTdRhswagm" +
       "RZg+LY/gntMPVLo5JIGbMJux0mhQXJPqrbpCdTroDQaIKaxnXG47jXld1oNc" +
       "Csy6UkHrsmgvK3VWaHE47VdhRFrQruit160+qyBtBic4ZBZTq6YvM05llTWX" +
       "bBdPaaaveq16xdTRURYIW73uz8nJAuW0+Wqty50U8zYIqqJxI418I/GrnWHb" +
       "963tOsjqE32gqzqyWbRJWV/mwUwgVEn0csxGapK/hls9qUdTvqzIrkyukg3d" +
       "mlS5yJlNsaYSEhHNVUVf6qgjfJI2l0K4lEZp4EpGAkJZkOmer3TnxnwU4u1R" +
       "0CMGycZfB5hTH43VEAmJpbPAkbXIKoN+u7Gh5jvcZuC5WBVqJCFPxAXG+j2u" +
       "Z5N2vzFKxrWFT2CU0Y4HbaKTBTLbImNykJntnBmmwlISAk4kqxrBuCNcNZgO" +
       "0Y1YcrRRWoa6y5VewKU5ZvWYnYu0EKfJDcRNkNOmkzbXHU/TLceHO0oyiuWm" +
       "PK0ORMKYUBHZIwyanVDbTMjF6WCFWROU2E3nXSntrIWFo7fDjooM+UpLNxIz" +
       "WLIpi6JYhxxyo3msY+rUMLwqH1YkO7I2XL9imBNG662qYXvTwQZACwNVGwI7" +
       "R+QS+EoVmYT0ksQ0aWdhTRLuhsuqMpPjBr6cMW2qrvSW7UnPapE0guo8ZdPw" +
       "tD2TmNmYacONvgwGbhtbrx8zsGes6cqUIQx/CDTR67Q9gvfmjcqmUxG1aAu8" +
       "OhoYtY2myQnaYztWuJs77NwNUxfrKNK0k1aH+WJo1epTAZFwkyAd1idkwsAQ" +
       "MzbS2XgTLvXW2Fn4g35vulHHXXdQV/u9pkuEC1yT9BRtoCs5FdCxG5DeIs1V" +
       "Dcs2q3qOt6zYmtU3VX9NiWwtY4SJg7BEy1GiZhpEDXTXwYxZg8QraHsNL/QE" +
       "N3AqJ2m/vlTUiHNRfEZgenuzSKexWfOYijdImBrc1rh1umh1Z6O10Fm7o50s" +
       "YabUruNSg5aGC2+eIr3lVmx0QnnRwEU+3BFevF102V3SjpBVoolUYC8drkcv" +
       "2V0Awztvvm3s6BpsKc1EmmAzc4dsJiuhRuBhy+W1MEdU1BJXLCoFne5YiWFx" +
       "6TL19Rqt53OjU9V8KeRqWxkPyV2TW6VtlsAJFWCVEJFsZo1IdNHW06mS82gS" +
       "tWa72BdarRQNV9pqmM9lJ9fh5pyh4ahiJvQObVTx6bRnmnVzEU/ZENvohJ2P" +
       "F1GtsxQz1PDjDqouNRQsKrxCRvQspWbTaWVXac3VijlQJu1Zd4dtBiPS1gyh" +
       "zYRCMpb7IPinMJap6wBFsHBg1fsK5YaDkJNnRIPJ/L4zQwXCB8uINRHEWtNI" +
       "SXmEyCTAnqpYZ6zBeL7UKzWsUR3GNodL+RzpGVNpqvnESuRXVn+2Hkszd9Sg" +
       "53O3jptDCfa0Dp7hOOxLbYlXax1aR3M8C+AWtuYqeKWJw7vcV5YTv9tMcwHu" +
       "rPJdU5JRZAhkkVWsKnoiaqUsOSDjHK8lO0tm4I26m8LO0Bzkiu3O3BplsV0z" +
       "nAr6qtKmotbSzeeiiffrzEqtBn47rzvmjBGiBjZG+jlP9RsTF8+ElriyRcal" +
       "JYmIxS6S+/GYtmZ2U0Png07YRZf5kEMtalo1Rg6xEpidNuC0NTkk82Q2mbVn" +
       "OwP0YzkEeLBn0f0wBAlGc4Obq34GMhESlYztcJTyUrxYqzWVmi9pcYY11yGC" +
       "hD4n5b6aGWmzu9gKOtnemrA6n3SzZajbnJv6A7POS1lWCWmx1dvCC9OrkeJi" +
       "4OphwmSY2KiIuGnNNNIa6GIzbCjpMKMYQyCGshvEfVrtYFN71ENTeiIh9HZs" +
       "MBGSmlg2zeVWNe+1puSIrFktlbf5pG8kHb1hSKqyQrdJLxmGIY3lQS30PLk1" +
       "1eMqXd2mLc7Dgs686bRQakBuJuvNGB+6PpxhMTmT54mWmIjAorbdHvkLKanp" +
       "o0hMtskyE4ztoI+7TiPYbpt+TWLGkp2Qy17WELw8aZl5sMPna5uaCTveQupb" +
       "ucYoKDJvoP3NZpBuNxxVNyVeq9W1tdWiEZsczKZepd7kdGINa/gw6yysFLFh" +
       "akbk03ZvXkHJoTBqmJNRL95Iq1W32kqr5mxK69VWHVYZKd/i8Abjg2o86JqD" +
       "Xaft04zuDzaMQGWjAOMwyZ16S43EBQJAXl3rLTx06mp1ZGM1mqgzHwxiXle1" +
       "6Xo9HnWxZXuBrCwVVcdzVlAMdKDMvaHY1/2oTqlwy/Bwn9DrROLztlmnFNX3" +
       "XLflOmt7OBlgXjVX+4NlJ2vIqN6Jqt2k0uIMdoij25DSJnF7qqdqS1lURWPp" +
       "TvtxPpPbZqgRFAUbURNjGwO7vnVy1uvvumzS6DYqjdic1GFrvPbqgrBUuM4w" +
       "IKsAVDYNRPH7XOIRXJhEcUNs85MqNVEDGZWadpWsS+bEww0j1DPGrO5C2dk4" +
       "uwrGC+uJ0/DbrjhlloTO9B2ZZQxx1gJ5AFjsl+5Q5E0QA2STHzBqczav7IAe" +
       "NjE6I0f+1phobdyJxBqT2+OaJPtCUm+1zDpOdH1ehmuVLapTZKvZmqrEjBm3" +
       "xprqCku8HU3AvG0cxVFm0vfkXXM6rVnTGm7WeBhV/YBDwTI7DB3WajZNaVjH" +
       "Ypgf1YYtAUeqrahf3TQifs54SmMi40PDlKuVxdS2pnXUaE5ysN7hPGyulUUz" +
       "JcT52hCUOILFHbmiDCbJbLOjqmTYHrktZoYEmSdP666syUELeKOhimlLHIyk" +
       "OEopZRvBTre3GhjA1uaiH63TcLdo+IN2SHpdMV06vSFnjcZtv+/KdXg6GWlJ" +
       "T6+nK3a8c/3cQOorpCPP010f28ANsMDqW+B57phxOzEWzfDcS2t6s11J6+mi" +
       "Yk6drbTDF6ihw6tOMBTVdtcU+JDoAT7rMdrHPQ9pImidj7yI7a0r/sZPO8Gc" +
       "2gxxFh30a3xnbY54pD2osg1E6uBWA1dD0gI7jQ2yaBnTWcfMjGpjvNz0QHqv" +
       "WK1eN2eEDbbys9V0bPjNkUMq0m5mTGaskuLZjuXVxNpmSmMWNjAmkDeSYrmL" +
       "5gTL7YkbYPMhsHjVnAd1X1z2VJqv+CtnUZMXfg8NaaTSDUNuQTXUsNri6pMY" +
       "g7twik5XWWPTm9uNDSNqOIut+SgLU46WUWWNKp7eN3BeJFGPo+ZKZwQjpiRX" +
       "uDEj2zEq0s6wt20tKwA/ds6OCntjsj/r1nJk7LWodVcRVwppxTRikTNa9HWu" +
       "5wPnshZag+XIynYDwC8Dy/7YG/YzGmy5GvTYXHuIXjUqcK/JVEws6WWDLME1" +
       "PGnCnU7FSq051mwYDpGst/1p01kR00Z/NqlPtKwXbwf6ZtqoSKt6x6fq+AIk" +
       "gaiIEobWw+ONa+4a1VVf07eGVk9ByPb5xMOZCVGzayzXJOaa7oJJl5uuvkhj" +
       "X87p6iDcTZC4YjJsw54EFp53NFcc1Jao4ORYkiUY3Mn9SqW/Vltri+nzBOF1" +
       "J9NuP+46JBa1EzfReDHN5PZQkekBwg0sIVIjmiItb9KuJRJGRDW2bbQ6BNda" +
       "tFaxj+8qwgCR8dk0z/Vg4riUQqvVum2tlqO+oA1bK7w2qm9gGOzkCSxXKWZB" +
       "EMUrgI++sbcwT5Yvl86vInwXr5X2TS8UxXvO38+Xn5uvc/Z36XVdFELveNAN" +
       "g/Jtyuc/9vIrRv9nkKPTd3sfiaFHYz/4Psfcms4FUtdf/xW9UF6wOJx3/ObH" +
       "/uhZ+QPLD72BE913XuHzKsmfE77wle579R87gq6fn37cc/Xj8qC7V17jhmac" +
       "hJ586eTjHeeafbbQWAV8W6eabV09+TjY7h4vODp4wd4BrpzdXdufc5YuUHb4" +
       "ydc53Pupovgx4EJ2dHoI37EdUwSSlN3TC47z4Rh6WPN9x1S9g1P9+Hd6pXVx" +
       "wrLiU5e18F7w/cCpFj7wRrQAuAlCe6vG5htQxc++jip+rij+UQw9vjBjOotN" +
       "Lzo9kFYP4v7j/19xC6N3T8Xt/lUa/Z+9jqRfKoovlkbnbS1Uw92Z0YuGf3gQ" +
       "99U3Im4GLHLqQ8VJ9DP3XArbX2TSv/jKrUfe9sr4P5Z3Gc4vGz3KQ49YieNc" +
       "PDi88HwzCE3LLrl/dH+MGJQ//yKGnnnQtZIYulH8lIz+yr77v4qhp+/TPQZz" +
       "nz5e7P1rMfTYoXcMHemXmn8DCHzaHEPXQXmx8cugCjQWj18pzXuSXbuMl+da" +
       "fuo7afkCxL77gedrQrK/oHeiv/oKJ374W42f2V+60B01zwsqj/DQw/v7H+dA" +
       "+MIDqZ3Rusm8+O0nfvHR95yB9hN7hg+eeoG3d97/VgMNNlPlPYT8l9/2z7//" +
       "Z1/5Wnno8H8BJ1Y/izcpAAA=");
}
