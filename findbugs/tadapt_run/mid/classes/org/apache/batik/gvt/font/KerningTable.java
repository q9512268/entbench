package org.apache.batik.gvt.font;
public class KerningTable {
    private org.apache.batik.gvt.font.Kern[] entries;
    public KerningTable(org.apache.batik.gvt.font.Kern[] entries) { super(
                                                                      );
                                                                    this.
                                                                      entries =
                                                                      entries;
    }
    public float getKerningValue(int glyphCode1, int glyphCode2, java.lang.String glyphUnicode1,
                                 java.lang.String glyphUnicode2) {
        for (int i =
               0;
             i <
               entries.
                 length;
             i++) {
            if (entries[i].
                  matchesFirstGlyph(
                    glyphCode1,
                    glyphUnicode1) &&
                  entries[i].
                  matchesSecondGlyph(
                    glyphCode2,
                    glyphUnicode2)) {
                return entries[i].
                  getAdjustValue(
                    );
            }
        }
        return 0.0F;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye2wUxxmfO9vnJ/hBMISHMbZBhcBtaZJCZEoDDsaGM7Zs" +
                                                              "x1JNk2Nvb+68eG932Z2zD1NKQGpBVKI0GErbYKkptCklELWN+lIofSaIJgga" +
                                                              "tSG0oUn+SFKCBH8kTkvb9JuZ3dvH3TmqVOWk25ub+ebxPX6/75s9fROVmAZq" +
                                                              "0kU1LobJDh2b4R7a7hENE8fbFNE0+6E3Kh14/fDuyT+W7wmi0CCaPiSaXZJo" +
                                                              "4nYZK3FzEM2XVZOIqoTNzRjH6YweA5vYGBGJrKmDaKZsdqZ0RZZk0qXFMRUY" +
                                                              "EI0IqhUJMeRYmuBOawGCFkTYaQR2GmGtX6A1gqokTd/hTJjjmdDmGqOyKWc/" +
                                                              "k6CayDZxRBTSRFaEiGyS1oyB7tE1ZUdS0UgYZ0h4m3K/ZYiNkftzzND0TPX7" +
                                                              "dw4N1TAzzBBVVSNMRbMXm5oyguMRVO30rldwytyOvoiKIqjSJUxQS8TeVIBN" +
                                                              "BdjU1teRgtNPw2o61aYxdYi9UkiX6IEIWuhdRBcNMWUt08PODCuUEUt3Nhm0" +
                                                              "bcxqa7vbp+KRe4Txrz9a88MiVD2IqmW1jx5HgkMQ2GQQDIpTMWyYa+NxHB9E" +
                                                              "tSo4vA8bsqjIY5a360w5qYokDSFgm4V2pnVssD0dW4EnQTcjLRHNyKqXYEFl" +
                                                              "/StJKGISdK13dOUattN+ULBChoMZCRFiz5pSPCyrcRZH3hlZHVs2gQBMLU1h" +
                                                              "MqRltypWRehAdTxEFFFNCn0QfGoSREs0CEGDxVqBRamtdVEaFpM4StBsv1wP" +
                                                              "HwKpcmYIOoWgmX4xthJ4aY7PSy7/3Ny8+uBOtUMNogCcOY4lhZ6/EiY1+Cb1" +
                                                              "4gQ2MOCAT6xaGjkq1j+3P4gQCM/0CXOZn3zh9oPLGs6/wGXm5pHpjm3DEolK" +
                                                              "J2LTL89rW/JAET1Gma6ZMnW+R3OGsh5rpDWjA9PUZ1ekg2F78Hzv7z/32Cl8" +
                                                              "I4gqOlFI0pR0CuKoVtJSuqxgYwNWsSESHO9E5ViNt7HxTlQK7YisYt7bnUiY" +
                                                              "mHSiYoV1hTT2H0yUgCWoiSqgLasJzW7rIhli7YyOECqFL6qCbwPiH/ZLUFIY" +
                                                              "0lJYECVRlVVN6DE0qj91KOMcbEI7DqO6JsQg/oeXrwivFEwtbUBACpqRFESI" +
                                                              "iiHMB4XkCBESYCZhEzZgvWS/GFNwmAac/vFtlaFazxgNBMAh8/x0oACSOjQl" +
                                                              "jo2oNJ5et/72mehFHmoUHpa9CFoM+4X5fmG2Xxj2C9P9wu79UCDAtrmL7st9" +
                                                              "Dh4bBuwD+VYt6Xtk49b9TUUQbPpoMZibii7OSUZtDknYzB6VTl/unbz0YsWp" +
                                                              "IAoCj8QgGTkZocWTEXhCMzQJx4GSCuUGmx+Fwtkg7znQ+WOjewZ2f5Kdw03y" +
                                                              "dMES4Cc6vYdSc3aLFj+4861bve/t988e3aU5MPdkDTvZ5cyk7NHkd6pf+ai0" +
                                                              "tFF8NvrcrpYgKgZKAhomIsAGGK7Bv4eHRVptRqa6lIHCCc1IiQodsmm0ggwZ" +
                                                              "2qjTw6KtlrXvAhdXUljNgu8nLJyxXzpar9PnLB6dNGZ8WjDG/0yffvyVl965" +
                                                              "l5nbTg7Vrqzeh0mri5DoYnWMemqdEOw3MAa5vx7rOXzk5r4tLP5Aojnfhi30" +
                                                              "2QZEBC4EM3/phe1Xr7924uWgE7MEMnI6BsVNJqsk7UcVUyhJ49w5DxCaAkin" +
                                                              "UdPysApRKSdkih4Kkn9VL1rx7LsHa3gcKNBjh9Gyj17A6b97HXrs4qOTDWyZ" +
                                                              "gEQTqmMzR4yz9Axn5bWGIe6g58jsuTL/G8+Lx4HvgWNNeQwz2gxkcdvoxi2t" +
                                                              "8vrSMZOw+Ty3/GzGOz+6sLX0Ks8tLXnFfSnrjZ0Xn9T+ciNop6N8U7jkJrPr" +
                                                              "0s873oqyuCijdED7qammuYC+1ki6grIm668ym/yPWP46wslf+r8ycsyQ40ks" +
                                                              "9A1s2DDQ306p0iL+j2ObDLhoUWFuc/lp4rvNL+2eaH4dQmUQlckmsCPYLU9R" +
                                                              "4ppz6/T1G1emzT/D6KSYmt8yvbeayy3WPDUY80o1fTzAsTQb+GjqRMPE7i0c" +
                                                              "iMyE7JricN+717715i8nv1PKo2pJYaP45s3+Z7cS2/vGBwxDOVSfpwDzzR8U" +
                                                              "Tj8xp23NDTbf4Vw6uzmTm4rB7s7cT51KvRdsCv0uiEoHUY1kXQkGRCVNmWwQ" +
                                                              "LGva9wS4NnjGvSUtr99aszllnp/vXdv62d4pAaBNbHxxgudeCyDGbx1sxmL2" +
                                                              "XEIfy5h3grS5nMCisioqFl1+CJ8AfP9DvxR2tIPDr67NKgAbsxWgDnAJKVhN" +
                                                              "kiFzSt/1GHIKMsCIxSTCrrrrw0+8/TT3ud9RPmG8f/zAh+GD45xz+XWiOaei" +
                                                              "d8/hVwrOKvQRoXBbONUubEb7W2d3/eKpXfv4qeq8xfF6uPs9/ad//yF87G8X" +
                                                              "8lRgRYAl+meNnsmCIMjNbGOH8zh1O1wgNBXTlGCP8YpM1sLZyxsMZvLAaWEO" +
                                                              "nLoYZJ3YXHllsuja47OrcksxulpDgUJraWHf+Td4fu/f5/SvGdr6P9RYC3y2" +
                                                              "9y/5/a7TFzYslh4Pspsfh0LOjdE7qdULgAoDwxVX7ffAoInDgPmFY4A+lrKQ" +
                                                              "YP+FrIURszBisvEpxhL0IQJoJOpC7vEpxGWawBfkLw3Wp3TCkvnYT2f9ePX3" +
                                                              "Jl5jVUwG5fF6vT/XcmSEVhz/x+4vv9INPN+JytKqvD2NO+New5Sa6Zgr+Tr3" +
                                                              "XcdMFkYo0gkKLNX1DOu+bwq9ttNHi+munr1x43pzEpUOvXxr2sCtc7dzqNpb" +
                                                              "LHaJeqtDX4soaGf5byodojkEcved3/z5GuX8HZYVK0UJUpjZbcA1KeMpLS3p" +
                                                              "ktJXf/Wb+q2Xi1CwHVUomhhvF1mVjsqhPMbmENywMvpnH+TVxiitP2qYqihH" +
                                                              "eUaowxyZcy3/0Pa6bPVCCxc0F76NVvXS6C+pLVoey0/LUMGW6oY8AvzqK2Er" +
                                                              "p1iU0Ps3MWTOKKt41U6fLKHt5Cul86mYcSEjux/7hPz3b3fJ7BgAUUfNL/SK" +
                                                              "hDHrib3jE/HukyuCVvj0E7C8pi9X8AhWcmz5SPYYtbaqq6xjrPLb0lHUp0G2" +
                                                              "6C801RfdxewAxWahWtiXlM7WT27/benYQ7ZGKzmG6LPXD2D6V2VDX7P5vsbJ" +
                                                              "BfytFu0/zGS+OgXsjtLHAUBNEhPrYs+KCiZ8yEp19Kfb1e6jKR6CnuQ/lxMl" +
                                                              "X5kiSgoBgaAq9xsGSnezc95p8vdw0pmJ6rJZEw//mZel9ruyKrghJNKK4q5m" +
                                                              "XO2QbuCEzLSv4uSgs58nCbq7YDFKUDH9YYf+Npc/CUk2nzykbni6JZ8C9/gl" +
                                                              "wYTs1y33A4IqHDkohHjDLXIGVgcR2jyr5/E9L/8yAS+asg6Z+VEOcQGw2UPE" +
                                                              "7O2zHcJp/v4ZgnZi4+adtz99kl/XJUUcG6OrVEKW4G8Osgl7YcHV7LVCHUvu" +
                                                              "TH+mfJENgFp+YAePc11xOwzRptPYmOO7y5ot2Svt1ROrz724P3QFKH0LCkCK" +
                                                              "nbElt1DO6GnIp1si+fIhlDPsmt1a8ebWSx+8Gqhj+RTxDNow1YyodPjctZ6E" +
                                                              "rn8ziMo7UQkwFs6wKv6hHWovlkYMT3oNxbS0mr1FTaeBLFIMM8tYBp2W7aWv" +
                                                              "ewhqyi1Yc1+BQWoaxcY6urqVrj0lTlrX3aPMsikOdGppiLVopEvXrYo99B6z" +
                                                              "vK4zpP6agf2/FX8LqGIaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cPwov8ZL//Ce33/Tp5/7Tn7e9j+altskkCQAAA==");
}
