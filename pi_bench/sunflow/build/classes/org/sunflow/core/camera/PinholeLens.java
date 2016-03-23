package org.sunflow.core.camera;
public class PinholeLens implements org.sunflow.core.CameraLens {
    private float au;
    private float av;
    private float aspect;
    private float fov;
    public PinholeLens() { super();
                           fov = 90;
                           aspect = 1;
                           update(); }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        fov =
          pl.
            getFloat(
              "fov",
              fov);
        aspect =
          pl.
            getFloat(
              "aspect",
              aspect);
        update(
          );
        return true;
    }
    private void update() { au = (float) java.lang.Math.tan(java.lang.Math.
                                                              toRadians(
                                                                fov *
                                                                  0.5F));
                            av = au / aspect; }
    public org.sunflow.core.Ray getRay(float x, float y, int imageWidth,
                                       int imageHeight,
                                       double lensX,
                                       double lensY,
                                       double time) { float du = -au +
                                                        2.0F *
                                                        au *
                                                        x /
                                                        (imageWidth -
                                                           1.0F);
                                                      float dv = -av +
                                                        2.0F *
                                                        av *
                                                        y /
                                                        (imageHeight -
                                                           1.0F);
                                                      return new org.sunflow.core.Ray(
                                                        0,
                                                        0,
                                                        0,
                                                        du,
                                                        dv,
                                                        -1);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "37Oer8fgsN7z3x+Czynw/G/2ZMiyge3Reqm5d74/cHDAe+Ao2hGil9bswNdt" +
       "EI7ivbwGfvLSN80PfPuj25zluBqPASvvfvrXf7j73qd3jmSKD1+TrB1ds80W" +
       "czm9ImtamWM8+FK75CuIf/74k5/98JPv2lJ16eq8pw3S+o/+9f98eff93/ri" +
       "CYcx0JsrhNvInbWlrHl8K1D0un7ycy9fi8PraDHrNnOWW5k+4qxHHaNn9DLp" +
       "uW8viO8H85Pomf849JwRAg94wUk0Lf4faLry49B0WnVPFNITP5KgrUmdAo5z" +
       "Y2kX2y1mv9WTtzyddV8PBBDkr2SZneiOYO3TcJdhSZf3XWoKXtFAdLtsWFiO" +
       "5g7wUpoH5iyO7G7fa47R2vqxaQUOcOshMtoFr0jv+aenvvybD38TGDMF3Rhn" +
       "kQtY/ZEd+1H21vhrzz9z781Pf+s9+XkPZMg9/k73bRnW1UtxnDVG1pj7rN6T" +
       "scq5kS8ptBCETH5EK/IBt+QRfnohOOjdn4Db8NZOpxJ08f0PPeXV2Xqy2cxU" +
       "tlyHtVYNx9d8wHSFnlFPiH6L649Jm9EqA4rk68Gw63msKpbQKCUULKYxb1OX" +
       "o26pS8+HK3NS7E5wv+IXui6uNfWli0z5qNtve61GrzTpkyVu6pKuPx0LRGvm" +
       "ClZvGkYWxmBRWSmH5dDDOS6Vyn14YKdiEpfLQTpwlLFFmLYgtIUmRmw0ZLVM" +
       "RyuaW/FEGymB1hEX3NruJIUR7HewjS9iWnVUM5m1Yq02ykyk3LBIT5etadfS" +
       "dWHDjfpeuChxS7bStT1OR1dG2+oXRb7FTKqJYvXaqyCgqvXhiNC8Ekdy7X7b" +
       "Zu22WUtLNpMuyBHVaFc4VJcoGV45bNIzp6HQl3i5pi2UWpKyLatplelKNCoE" +
       "S0WYDnseautLne1txm5CWZZRZf2K2Vulbaa0LhIoEgulps93EIXz3AgxykWl" +
       "aKzhqdSYM+ZYZniiBq88VIiMkGov+xzqouHU9umSKRRGpqZ7tRGeFpfopq+V" +
       "W57dWSBUZ+Yt6HFapQQ2nFlSmVysq45kDgjcaKY0P6OAFrmkNBmj9oJoUWLf" +
       "Qitho7Sa8sJiNlG4biHk+Fp9YESFSO5x/aK2mrJFfJywra6sBYyp9SjOroRc" +
       "kV0ylL3UzNbIXSiVpqCvhqs2Jlhkglgc1V+QQRqv8EmnuF4gBb4a+UGT7VIR" +
       "b3lWxAdTWnKVREUn1nRmdnkSSfjRhJMjptIk9HDNdBgPHxX4pOZ1pmSx0WRD" +
       "eDnlSTlQGxq1mHmkLhLGQLRmK27cwEl3Rq+oboloVHCkzpIaPWIaa6lIzswo" +
       "WY4QcWIkemvUXhT00cBfuTbeW/VWle6cobuDVo1H16OZEPN8MmNVux6UOh10" +
       "Uqp2CW7YYp1eM9EjJdYmkzA25/U+MJqm09aIEOhlmYxtq1IjmsO2zqqojs/7" +
       "xqaA1aWWYJnRvCGVdNwY1WsiMuGNDjrtpCWyEmHTEFG1QHH7nRE9VAYOx1QN" +
       "mvQHMjlkhpRu021FarXssQV7cE0yDL5gdoZTWh7WPGs+KTnrbk3gW4jVa7pI" +
       "p9oV+tyUbKclU7dXFG1g6jBZaR2kXeyZImaaNh0sUW4V95aSV4Yby4mlDWer" +
       "VcOv6p44ccTKMph1lHSjt03gwmajUeu5TqVSLzD17qxTHw37ZNGtCJHrRssJ" +
       "GXRt4MFqa2p59Cr2FqUWbQVkheXnMB2ZTotx9HFvMTN0QwhWm+Ew0VbLxcZW" +
       "B0HAcAbh0A0cb3BwaYlJgDyCmG4GE4OxOkU0KJXLbkk2Z5WWv8Locc1ISmRq" +
       "0gjfbEm0LiFNJ0C6XaZVtruR2NTYZsGUNBMnKAGR+mpn7jtmP6QUHN1YmlfF" +
       "UapU7iacJ4nYEG1vCkPaEBnbshCxXlwNrTbfdRMuDXsjXYu04nLdqKKNNsba" +
       "sWGSoZQQ8Eqbp8xUWETF9VAbGx03xKxJdTWYbDoEiTpuhcVNapjUpUGjOBm0" +
       "CqhMUgFcq8blTdFcT5PJJinTeK+xVkbchl3EDUzFXDrgyljU7BtJRbLrY5ll" +
       "6hRZrJYSJKIYf4zGUjN2PL2mrJyiyqZEMheiuu7jC45vlPFWO1SNctIlRy1N" +
       "4SY832u3dM9OLGrDWZ1NfRqU+uNOudGJHK1UG2xUydVEY6WZhXAuaLVZQRLH" +
       "vbXDwRKplhlqPevAzVqfbBcA2RGsUlW/VDNZma8WB2aDXwLKTcI0NmiFREql" +
       "so0Om+V54LhmrSCrA42OqumQJmvFrhiWOotG221TQ6msRnQal5V4PvaLU3lQ" +
       "koYTj91UySSZcQSQHTdYlIZBP+zV0wQXmr6Gd7x+YV3pw0Sf6lldQHOlWU3r" +
       "SK++qMOY2qpL3cG0sdyUSSNM8VSqLWZiwvbnsgNL69Bs80zi+gEqMVpnLCEp" +
       "6wgLz1AYlIljdT6g60iVc3AVb/BNxNIcWqKIdWfZCMMBr8JiiClVNMJaaDC1" +
       "QhWVCgN6AjtttNmP1fHSRysS4KXnpFxJjmkxshZrtjLFFj6zxguwVZD6rj6T" +
       "+rhcKFjitOBNE1huuNXWmiBJJeismHV7xqS2spiy86maRuhUEer+ZjR0adkj" +
       "/Kk34cqbLstMu0R5sg40hm9v4jjBGbayQF2vSus+1U7RGG/MpVm4LNoIQ1Zq" +
       "K0UhOwUjFSTH98lYWg8HDXFTFybdmmG7iRau+1hrAMerQhlNC2W/vTElak5M" +
       "pLSMuQRcQMeVtVqo9Wo1a85IPaShFPqLwTIoyCKLCQWcULF1t+fb2ABtSjZO" +
       "TsvYGHEmcI0JvRlM6sMpOGuVUIsVh+8JGwOXl016IK08rdf1UtRh6L5FyiCe" +
       "NSSsraatVCysOsx4YQxHJT9I4d6SqMDGUm16gcZiiVtXcKmLDeYphZZ1jPQi" +
       "rEM3Xaa9JmhzPlluFkgxbVhUU7ekOuN5q6Qh95Mm0lNMnLVIjPNjJ9KUwrSB" +
       "1dtwE8YDmm40irVatR1jcYqJyJxdoLOFQ8uYawQcXxouW0VtrtdZGHdqDaWV" +
       "DuBU4+YEPm1H/flcpEJjJAbVDjaOos5A6zTNSnk+KmIK26y1a61INlBNYWM/" +
       "HBd7HWPtrYnuHK75qVDCQpIY1Jsdck3WOmPaCyPCLxiFWmVOOWiVHzSXLMIv" +
       "xY1dJWd1Hy3DWBmcJO1CtTZf9cp4UuYoft7WzF6JRSNeGFWMYoVWV6ojmIEw" +
       "FNsOM1hNNn7iV4rYxDEjWyGsBYql7FTpTZN5uJi2iinOzXBk1ibNaSmp6wEy" +
       "r8yL8qjNRlWpqsyDubmI55OJApcK9KhfjsgZ7YDjlyc8Nym1R3x92a5p7KpE" +
       "et0ST1k4MZywKzEhR8m4nPolxupxCB6tNt7STitrv+IBncZJ7IC8oVev9Na1" +
       "Io/LqLpmdD1urmAdUdFZHzE6zbUnR2WTmbdW6z7pjfq1tFqhQE5WN00cQSpJ" +
       "dWpY9DRAipQUeNRELNfcqKzD8yh1YMMY11edfohQ6aJu0OP+pK7qGKFQqTwn" +
       "i7URbIXDPizK1YI0NwYdfhz740pYmDqFYKBK1XUhtKhat2ZJhLkwkrneT4jy" +
       "3Nw4CsJNHQHpdA3FcWZ1h5UUMimKMuzWU38elTeRmSCMnpQRa95oiCGpVYp4" +
       "qAyx9nTC8H2RCCRJF2Jy2KoAMZQCdlCXEE8PxvGCZlTNAGdSs1GWqJVryHQl" +
       "lAZjdT1MhGnSWVVtsyC0p2ptkYgOLttNGxxc8FzqtcYVlh0XeGMhNqNEGS5E" +
       "ot10FmbkFOUWJSiCHbTAm3ZaUjem15G5+bIXiW2+2lywXiI20Ppshvkztqyy" +
       "CzOsry11rSEjsyaOYMqVvInI1QbNRGrIccokxXhcWK7T6oBgx2mHrFfq/Upp" +
       "OQcb9Ae46K42KukoOm+jICmxx2Vi6Qw0xOBHIP8cp16FQMyhXKWDjkFYVEFe" +
       "rSJpgM0NcYFxJV4lZ0FLBHY1jeVZ4iH1yG6BE7lF+COlGPTcgsqkPThpBONe" +
       "myoWeoRKxFzMWHTsrVV4w9Xi0mw23BQHZNAa6wMOHhEiXmuTnfIqItwIBTam" +
       "tmbtRq+8NFPcrLHdRorZqTCuYA06bq8puxNXTKzEUWFHnxg1c+75fKTA4xmB" +
       "VkbjjQ6yeITpUpKwYuO2UHRLxWTtJ0F5ORVRC1HKPFENZ2wLnHyjdNEC+UrH" +
       "h/0GKSFFdtyP46iO8NU66tcxIejTcbqZwLo4CcSwi5PrlEfUAsx5htfsEFjF" +
       "N5FqYWipTmsITvdOZRPPqbhWKMBoixe6iiNvpPmqMkgxdBzAwEZraoWEcX7a" +
       "iIp4AhdaxYofT8eKPGZ6C95xU7lXaBmD+qzpiwgPct9CjSQdOl475mAzaGLz" +
       "KmN7cTGkeLxvNVgE0wxWrYlBq1Rj7eIi1uaRziqlkIjwRslVQR4wq44nDFql" +
       "izbTaTHThcQJWAqSphjewBOxitSdUQBeHN/0puyV8smX96p7W/5Wf1C6BG+4" +
       "2YT9Mt5mt1MPZs1rD64/8s8Z6Fi56+id+uFF66n9G4RXX1MkauZFoqw4lN2K" +
       "3Xu9qmV+I/bcO55+VmY/hOzsXWLTIXQudL2ftZRYsY5sdxpgevT6t39MXrQ9" +
       "vFz9/Dv+9Z7xzy+feBklo/uP0Xkc5R8xz3+RfJ302zvQ6YOr1mvKyVcveuzq" +
       "C9bzvhJGvjO+6pr13gPp375/QXdpT/qXjl8+Her35Jun12/t41iNYCcH2NnX" +
       "133X6CuXgxIqflaE2Ae78ygYt/3GB918h2deogrx+1nzVAidiTxZCJWTbl7O" +
       "iq5rKYJzaKm/9aPuXY7ukg/8xrX3mvfsie2elyu25oliO8rUh19i7iNZ8wcv" +
       "yfANsavLh9w+9xNweyEbvAM89+9xe/9Px0jObqsnB9eV1El8nNad/Ib1MydN" +
       "npHdSNwW1T+bN/k+n34Jyf1Z1nwSrNSUcCQk+5b3ymsMdH8yl94fvxzpbULo" +
       "5iPF6qzydvc1/3XZ/j9D+tizF26669nJ3+T12oP/UJyjoZvUyLKOFkqO9M94" +
       "vqLqOTvntmUTL//6QgjddZ3qOWB428mp/fwW/kshdPE4PDCc7Oso2FcAP0fA" +
       "gC/t9Y4CfRVoCgBl3a95J1z0bgtGm1NHwuueneUCvvSjBHyw5Gg9NwvJ+Z+N" +
       "9sNntP270RXp489S/be+WP3Qtp4sWUKaZlhuoqGz29L2QQh+8LrY9nGd6Tzy" +
       "g1s/ce61+8fFrVuCD23+CG33n1y8bdtemJdb08/c9Sdv/MNnv5HfO/8fLiUs" +
       "gwUmAAA=");
}
