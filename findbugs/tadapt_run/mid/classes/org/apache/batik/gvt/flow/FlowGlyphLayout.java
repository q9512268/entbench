package org.apache.batik.gvt.flow;
public class FlowGlyphLayout extends org.apache.batik.gvt.text.GlyphLayout {
    public static final char SOFT_HYPHEN = 173;
    public static final char ZERO_WIDTH_SPACE = 8203;
    public static final char ZERO_WIDTH_JOINER = 8205;
    public static final char SPACE = ' ';
    public FlowGlyphLayout(java.text.AttributedCharacterIterator aci, int[] charMap,
                           java.awt.geom.Point2D offset,
                           java.awt.font.FontRenderContext frc) {
        super(
          aci,
          charMap,
          offset,
          frc);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0Za2wcxXl8dmzHj/gR4gRDXo4TcAh3DY8CMqUJFzu+cLZP" +
                                                              "dkiL03LZ25u722Rvd7M7Z58DaUiqkggkhEhC0wJW1SZ9RIGgtpSWKjQVtIAo" +
                                                              "IFJUCLQ8fwANSORHMS1t6ffN7N7u7d0ZgSos3dzczPeY7zHfY3zsfTLLMkmX" +
                                                              "IWlJKcgmDWoFYziPSaZFk2FVsqyNsBqXb3tj/67pP8/eHSC1Y2RORrIGZcmi" +
                                                              "/QpVk9YYWahoFpM0mVpDlCYRI2ZSi5rjElN0bYzMU6xI1lAVWWGDepIiwCbJ" +
                                                              "jJI2iTFTSeQYjdgEGFkc5acJ8dOE1voBeqOkSdaNSRehswgh7NlD2KzLz2Kk" +
                                                              "NbpVGpdCOaaooahisd68SS4ydHUyreosSPMsuFW93FbEhujlJWroerDlw4/v" +
                                                              "zLRyNcyVNE1nXERrhFq6Ok6TUdLirvapNGttJ98i1VHS6AFmpDvqMA0B0xAw" +
                                                              "deR1oeD0zVTLZcM6F4c5lGoNGQ/EyNJiIoZkSlmbTIyfGSjUM1t2jgzSLilI" +
                                                              "65jbJ+LBi0IHvntj68+rScsYaVG0UTyODIdgwGQMFEqzCWpaa5NJmhwjbRoY" +
                                                              "fJSaiqQqO2xrt1tKWpNYDlzAUQsu5gxqcp6ursCSIJuZk5luFsRLcaeyf81K" +
                                                              "qVIaZO1wZRUS9uM6CNigwMHMlAS+Z6PUbFO0JPejYoyCjN3XAQCg1mUpy+gF" +
                                                              "VjWaBAukXbiIKmnp0Cg4n5YG0Fk6uKDJfa0CUdS1IcnbpDSNM7LADxcTWwA1" +
                                                              "mysCURiZ5wfjlMBKnT4reezz/tDVd9ykDWgBUgVnTlJZxfM3AtIiH9IITVGT" +
                                                              "wj0QiE0ro3dLHSf2BQgB4Hk+YAHz8M1n16xadPJJAXNeGZjhxFYqs7h8ODHn" +
                                                              "+fPDPVdV4zHqDd1S0PhFkvNbFrN3evMGRJqOAkXcDDqbJ0f+eMMtR+mZAGmI" +
                                                              "kFpZV3NZ8KM2Wc8aikrN9VSjpsRoMkJmUy0Z5vsRUgfzqKJRsTqcSlmURUiN" +
                                                              "ypdqdf4bVJQCEqiiBpgrWkp35obEMnyeNwghdfAhTfDpJuKPfzOyNZTRszQk" +
                                                              "yZKmaHooZuooPxqUxxxqwTwJu4YeSoD/b7t4dfCKkKXnTHDIkG6mQxJ4RYaK" +
                                                              "zVB6nIVSqj4B7qtPrFcnjUxUmgTfCqLPGV8otzzKPneiqgrMcr4/KKhwnwZ0" +
                                                              "NUnNuHwgd23f2QfiTwuHw0tia42RHmAZFCyDnGUQWAaRZdDHklRVcU7nIGth" +
                                                              "fDDdNggCEIWbeka/uWHLvq5q8Dpjogb0jqArSrJS2I0WToiPy8eeH5l+7pmG" +
                                                              "owESgICSgKzkpobuotQgMpupyzQJsalSknACZahyWih7DnLy0MTuTbu+xM/h" +
                                                              "jfZIcBYEKkSPYYwusOj23/JydFv2vvPh8bt36u59L0ofTtYrwcQw0uW3q1/4" +
                                                              "uLxyifRQ/MTO7gCpgdgE8ZhJcH8g1C3y8ygKJ71OaEZZ6kHglG5mJRW3nHja" +
                                                              "wDKmPuGucIdr4/NzwMSNeL864bPKvnD8G3c7DBznCwdFn/FJwUP/V0aN+156" +
                                                              "9t1LubqdLNHiSe+jlPV6IhMSa+cxqM11wY0mpQD3t0Ox/Qff37uZ+x9ALCvH" +
                                                              "sBvHMEQkMCGo+TtPbj/92quHXwi4PssgNecSUOXkC0LiOmmYQUj0c/c8ENlU" +
                                                              "uO/oNd3Xa+CVSkqREirFS/LvluWrH3rvjlbhByqsOG606tMJuOvnXktuefrG" +
                                                              "6UWcTJWMmdXVmQsmwvVcl/Ja05Qm8Rz53acWfu8J6T4I/BBsLWUH5fGzhuug" +
                                                              "hku+gJHlHBNLhmChhEuGM6A7GRJphFGuRAvrEc8tx+JwNJewGOcmUtJv5r77" +
                                                              "i6e21J0WKam7LLgv071509M/1P96JuBksXIoAvI6a/C5RwbejnMvqsfggeso" +
                                                              "Q7MnLKw10x4Xbi1Ydw4asw0+a2zrrhE5Q/m/RnGs7aQJFkpTPQskWCZKtTTL" +
                                                              "OCnji2OWB3MtrxwVPTab+vGyZ3dNLXsDnGyM1CsWxFXQYZm6xoPzwbHXzpxq" +
                                                              "XvgAD0Q1aArbDMUFYWm9V1TGcQu14NCLxy3vLjFTyUJQGLfd5XjH9PbH63as" +
                                                              "Q3dBzKuEgT+Bvyr4/Bc/aFhcEAZuD9uVyZJCaWIYyK9nhl6imGloZ/tr2+59" +
                                                              "537ho/7SzQdM9x247ZPgHQfE3Rf17bKSEtOLI2pc4a84hPF0S2fiwjH63z6+" +
                                                              "87c/3blXnKq9uFrrg2bk/r/850/BQ68/VaYYqFbsHuVSDIaFNN7hN4EQqXb1" +
                                                              "ff/cdetLw2DuCKnPacr2HI0kvTTBslYu4bmPbuXMF7zCoWmgxliJVig9wpKS" +
                                                              "SoI3rm4SfO+Ve9763fSP6oTYMxjRh7fgX8NqYs+bH3FtlOT8Mnb14Y+Fjt3b" +
                                                              "Gb7mDMd3ky9iL8uXlmVwjVzcS45m/xHoqv1DgNSNkVbZbhI3SWoOU9oYXBTL" +
                                                              "6RyhkSzaL25yREXfWyguzvc7loetP+17rVXDiizTJi5hFeGJ7uscYwUfe3BY" +
                                                              "xa0TwOnFDIgqmqRyvDCkUZUHHfw1gMMaj1UDAs/JMyJDoRzQI+kaxWTn7Ila" +
                                                              "U9GDhf4UNsv5x9IS/xjkIcVV9hWnpqtfuWtBU2mRidQWVSghV1Z2JD+DJ/b8" +
                                                              "vXPjNZktn6F6XOzzDj/Jnw0ee2r9CvmuAG9uhW1LmuJipN5iizaYFLp4rfjG" +
                                                              "dQm7crsIo+KwkpuO/w4VNEy4hkVQ3TrDHu9g0+AFMppQWHwGcB1Lk8Xli56+" +
                                                              "rMF4mbLj1/N/efVPpl7l9Vme+K2OP4fzjqfM48Qg7wUx70FbCqHsknXO7uLC" +
                                                              "bgpuaLAfhhFoOKlpP4rwQ102w4H50G15C/5ih/C8+sTlO1/4oHnTB4+eLQkq" +
                                                              "xfXtoGT0uhdtOcb3+f7makCyMgB32cmhb7SqJz/m6bhRkiF3WsMmCJAvqoZt" +
                                                              "6Fl1L//+sY4tz1eTQD9pUHUp2S/xxoLMhoqeWhnoC/PGV+2aZ6IehlYuKikR" +
                                                              "nl/97ULN53kKxJFCCbUA4a6Ezwq7hFrh7wJ429jmXvMI6DxNzfY3f3B4evfe" +
                                                              "KwNYhs4ax7AG0rS6cEM5fKe69djBhY0HXr+duwFQvh+J7i4fjKrtYFRr8Scv" +
                                                              "/LXZV8rPn+GkjDSODvdvjA/cEBvoG+J4a+3Ui199nnmEkRo5Y0eKEq8UfQ+O" +
                                                              "kzjsETg3V9R4GW1eYJ/xgjLaxMm3CVnSiJO7ZlIFDvsqqaESC0Zax/pGhuNf" +
                                                              "i6zbOBAfja0Nc8lv90m1/3NIdaHN8sIZpGrGyT2fW6pKLBhp80i1YTgy1DdS" +
                                                              "Tqx7P6NYl8Onx+bZU9b1vRnO6Z8uu3396W2dK/Lg/GHH+Q2yBLEOf27RKx0D" +
                                                              "4nJFKx6ZQdy8JzsUuPG/WuJ7ZvNw88QKgjFtYaWXUF6vHt5zYCo5fGS1U7pv" +
                                                              "YBCkdONilY5TtYgUBE/fkxRmkQUlr+HiBVd+YKqlfv7U9S+KbsR5ZW2CJjGV" +
                                                              "U1Vv1eOZ1xomTSn8IE0iNBv862FGzq34UgahAL/4YX8l4B+B2qUcPNTYMHoh" +
                                                              "T8Bt80OCvfi3F+4kIw0uHIQ4MfGCPAbUAQSnjxuFNr7ssXlb79FkvqrYagX3" +
                                                              "mPdpt8Fj6GVFuZH/M8MpbHLi3xnQqU1tGLrp7JePiEcfWZV27EAqjdAqiPen" +
                                                              "QnG0tCI1h1btQM/Hcx6cvdxxnTZxYNfBz/Nk8O0QnA10mE7fi4jVXXgYOX34" +
                                                              "6kef2Vd7Ci7lZlIlQW26ubTKzhs5qF02R8s1RVA68sea3oa3tjz30ctV7U7S" +
                                                              "wjCwaCaMuLz/0VdiKcP4foDMhnQIN4PmeQuwblIbofK4WdRj1Sb0nFboqOeg" +
                                                              "d0v4jw6uGVuhzYVVfDRkpKu03Sx9SIVqYYKa1yJ1JNPsKydzhuHd5ZodEmkR" +
                                                              "NQ0OGI8OGobdZzcluOYNgweGF3lu/B9aZ55JsRwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
