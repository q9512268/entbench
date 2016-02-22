package org.sunflow.core.shader;
public class TexturedWardShader extends org.sunflow.core.shader.AnisotropicWardShader {
    private org.sunflow.core.Texture tex;
    public TexturedWardShader() { super();
                                  tex = null; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        java.lang.String filename =
          pl.
          getString(
            "texture",
            null);
        if (filename !=
              null)
            tex =
              org.sunflow.core.TextureCache.
                getTexture(
                  api.
                    resolveTextureFilename(
                      filename),
                  false);
        return tex !=
          null &&
          super.
          update(
            pl,
            api);
    }
    public org.sunflow.image.Color getDiffuse(org.sunflow.core.ShadingState state) {
        return tex.
          getPixel(
            state.
              getUV(
                ).
              x,
            state.
              getUV(
                ).
              y);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6e+zsaFW9v/u++7h378LusrDvC7pb+HVmOp12XBBmOu/p" +
       "a9ppZzoIl7bTTjvT1/Qx7QyuAkYhYnCjF8QENiaCKFkeMRJNDGaNUSAQEwxR" +
       "NBGIMRFFEvYP0YiKXzu/9713caNO0q9fv55zvnPOd875Ts83z38XOhsGEOx7" +
       "9npme9Gunka7cxvbjda+Hu72KIxTglCfkrYShkMwdl17/LOXv/+DZ80rO9C5" +
       "CXSv4rpepESW54a8Hnr2Sp9S0OXD0aatO2EEXaHmykpB4siyEcoKo6cp6I4j" +
       "qBF0jdpnAQEsIIAFJGcBqR1CAaS7dDd2yAxDcaNwCf0MdIqCzvlaxl4EPXac" +
       "iK8EirNHhsslABQuZM8SECpHTgPo0QPZtzLfJPAHYeTGr739yu+ehi5PoMuW" +
       "K2TsaICJCEwyge50dEfVg7A2nerTCXSPq+tTQQ8sxbY2Od8T6GpozVwligP9" +
       "QEnZYOzrQT7noebu1DLZgliLvOBAPMPS7en+01nDVmZA1vsOZd1K2MrGgYCX" +
       "LMBYYCiavo9yZmG50wh65CTGgYzX+gAAoJ539Mj0DqY64ypgALq6XTtbcWeI" +
       "EAWWOwOgZ70YzBJBD96WaKZrX9EWyky/HkEPnITjtq8A1MVcERlKBL3yJFhO" +
       "CazSgydW6cj6fJd54wfe6XbcnZznqa7ZGf8XANLDJ5B43dAD3dX0LeKdT1Ef" +
       "Uu77/Pt2IAgAv/IE8Bbm93/6xbe8/uEXvriFefUtYFh1rmvRde1j6t1ffQ35" +
       "ZPV0xsYF3wutbPGPSZ6bP7f35unUB5533wHF7OXu/ssX+D+T3/VJ/Ts70KUu" +
       "dE7z7NgBdnSP5jm+ZetBW3f1QIn0aRe6qLtTMn/fhc6DPmW5+naUNYxQj7rQ" +
       "GTsfOuflz0BFBiCRqeg86Fuu4e33fSUy837qQxB0HlzQneC6BG1/+T2C3oqY" +
       "nqMjiqa4lushXOBl8oeI7kYq0K2JhLFr2F6ChIGGeMHs4FnzAh0JTWWqB8gQ" +
       "uA5wh+lICaZCPrSbGZn//0s+zaS7kpw6BRT/mpNubwOP6Xg2gL2u3YjrzRc/" +
       "ff3LOwdusKeXCHoKzLm7N+duNufuds7dm+eETp3Kp3pFNvd2fcHqLICfgwh4" +
       "55PC23rveN/jp4Fh+ckZoNoMFLl9ICYPI0M3j38aME/ohQ8n75Z+trAD7RyP" +
       "qBm/YOhShs5lcfAg3l076Um3onv5vd/+/mc+9Ix36FPHQvSeq9+Mmbnq4yc1" +
       "G3iaPgWqOST/1KPK565//plrO9AZ4P8g5kUKsFEQTh4+Occxl316P/xlspwF" +
       "Ahte4Ch29mo/Zl2KzMBLDkfyJb87798DdHxHZsMPgeuuPaPO79nbe/2sfcXW" +
       "RLJFOyFFHl7fJPgf/fqf/yOaq3s/El8+srcJevT0Ee/PiF3O/fyeQxsYBroO" +
       "4P72w9yvfvC7731rbgAA4olbTXgta0ng9WAJgZp//ovLv/7mNz72tZ1Do4nA" +
       "9hertqWlB0Ke2ffW2wkJZnvdIT8getjAxTKruSa6jje1DEtRbT2z0v+4/Nri" +
       "5/75A1e2dmCDkX0zev2PJnA4/qo69K4vv/1fH87JnNKy3etQZ4dg25B47yHl" +
       "WhAo64yP9N1/8dCvf0H5KAiuIKCF1kbPYxSU6wDKFw3J5X8qb3dPvCtmzSPh" +
       "UeM/7l9Hsozr2rNf+95d0vf+6MWc2+NpytG1phX/6a15Zc2jKSB//0lP7yih" +
       "CeDKLzA/dcV+4QeA4gRQ1MDeHLIBCBHpMcvYgz57/m/++E/ue8dXT0M7LeiS" +
       "7SnTlpI7GXQRWLcemiBKpf6b37Jd3OQCaK7kokI3Cb81igfypzOAwSdvH19a" +
       "WZZx6KIP/Dtrq+/5u3+7SQl5ZLnF5noCf4I8/5EHyZ/8To5/6OIZ9sPpzeEX" +
       "ZGSHuKVPOv+y8/i5P92Bzk+gK9peuicpdpw5zgSkOOF+DghSwmPvj6cr2735" +
       "6YMQ9pqT4eXItCeDy2HYB/0MOutfOhFPsv0RemA/sOzfj8aTU1DeeXOO8lje" +
       "XsuaH9t33/N+YK3AXr7nvz8Ev1Pg+q/syohlA9ud9yq5t/0/erD/+2BHOr2P" +
       "+0qQbNy0O+1tS9uwlrWlrHnLFgO7rRH9RNY00lOAwbOlXXy3kD33by3E6az7" +
       "4yAQhXlmDDAMy1XsXFWNCDiFrV3bZ10CmTKwomtzG9/n+UruANl67W7TyxO8" +
       "Nv7HvAIDv/uQGOWBTPX9f//sV375iW8CK+xBZ1eZhQDjOzIjE2fJ+y88/8GH" +
       "7rjxrffncRWsinD2xa/nqZD0UhJnDZs13L6oD2aiCl4caDqlhBGdh0J9mkv7" +
       "ks7HBZYDdozVXmaKPHP1m4uPfPtT26zzpKedANbfd+MXf7j7gRs7R3L9J25K" +
       "t4/ibPP9nOm79jQcQI+91Cw5RusfPvPMH/72M+/dcnX1eObaBB9mn/rL//zK" +
       "7oe/9aVbpE1nbO9/sbDRXTc65bBb2/9RkmzIqSilI4RGVtV0XK6tYS0OyaRA" +
       "NepDJWiWLMJah20pac3lkJcKyzVWQKcl2YBhpZqiKxTXyrHnSc1EkAWqtar5" +
       "cWow/VKz5aRhkRmUnKaq+tFoEU39kVgKRJ4aCEJ5HTXVka7DCO76dqvpowvU" +
       "MJyVy3Er3dBQxJlqVaRVqcxJplXDxZFDD+N5c94uSpVBrTTsUbGk1n3cU2BZ" +
       "t+m2gQcrJ8Rxr2StrWZBSQQV4bslYVKlbWqAmYy/KCq8bMsWNsNqhfamNWv2" +
       "aFnG5n1nvmxioe90lxrwqOHQsIqMQ9d0leR5uqKKixY96g1stSZKkSCZPbdP" +
       "LFCTgdFJsVmd9J0hOrcIFLVWahkdNih3M5KEYm9AzOhpgvb76+YC6fdilG2X" +
       "rGJgLYYjcTSnJ303HHB9PQpbJWCzZHEz0FQ3TbDQ5bFlmSxN5tJU9BgC0Xgx" +
       "ZdoC5/faQUEPtGWvrel8q9qeiLaIpayzbHD+sL7sCDqdLEds1EtGgboml7a+" +
       "kuKGKxYkwRdKab1FFqh+1E5nY7bkzNrwJKoPhiNUhUdkMl3aQaCS64TmO1Ko" +
       "u5s4BZFOpplBxeTtxXRCx7xcb4o9c0GaWE+zTNMZbnymsGC9kTxmOpbQntcl" +
       "rBDhfsvm2KVvKiFXYkdFy/V5trGBXYxcybzaoENrtGwrxUq7RgSwhLV4rT4J" +
       "VUMKW7xaCsflJGwpbZNfTBqUtTExgVs7S8WzxmZTqTDuhGjVeFOxBabAd1i3" +
       "b2vptF8b1fhma1l1y91mndvIPc8cyDWGNJVRq+sT+Ij1pbbW02h6IbSxmtHs" +
       "++1luVudDaxYaafqzCn1Ry1PQte4hhQ7fMR2Wn10KTXF2XDkWoqQVKdG3ePU" +
       "gdcqLAZJQmpCrV10NXsIcyOsXO00B5QZCy2za7BVqorKUV+trsOInNhN3pmU" +
       "/FpBsJIqhRX7m3EL0WOwj9CUwijFwnqijvGaZmJ2DVFUPEjYBsMtFWewkgmc" +
       "6uMRTHhih8IaqFeZlWaCZw/V1nrWZxxBW/nhok/DZbPfaKY91mstrV4QYzox" +
       "XNaW+gLv9XkWYYe0vGC6nX5riklLo4OU+1162a7FS09yR1rR2wQsWxmYyCYO" +
       "u56wLIuNohaJcwLulayV0eQp0bBGdH8ZtIO0JjLzqh+lci8R4Y68UG1/yUed" +
       "drkim+lQnFeQypjpcs0ND/S9mBBMecCaTa6iVc1uA+nH7Ro7AWFGckvGaMNX" +
       "OJ5upBbBmEGh0VQZWlzUSyN/uWFGJYLgjPVyVh9QtWq4anXGdbfRwjempdJr" +
       "1ZnXx6wldHkuEjUmMORx1ZqKsrnpMkFFkhkDpXBEb2qTWjM0qMQY01GbHdCU" +
       "X9XmNdmomxWpRyWwsF7CkT7vU2vgW/VmMEqSVa8zx5qtCfA2XCejYaG5JOYU" +
       "KdrVttx36QIpCGY8Gq1n65Lt+NG8boVupYtxsyK7cvp8W4CnlLyMO8UCxqLY" +
       "YlM04nm/59E1J+kLcW1VnSc1UZ1SCwk1PRZxGLwtVzV41RlWQlblByQZsLST" +
       "yKSw8QSaNoM6bi5HsW/MJ2Vd46ZoHy0mdUZMUrM+2MgdvzxPGtS04dCbUSWo" +
       "l7upg1ENcjxfwMFSnJtzNa6OSZFZcS47ICnWnJTUca1Y6nS6OJxGSwJX9AEl" +
       "Ndqa2UfNNswJMyPGIxdB02Z1Mx2uel61Pa4OxD5uyMOWTUmJ4gQlmVqp3dpw" +
       "gc4LuMYu+QphlLRwTaZcz2qiyjoy9S4ZyAOU20h2AsNEFZeIUrXNTdLhmjFH" +
       "5GxprNrRIhbpxJfXzZI0qVSSDimWa1K77VXwolZ30V47tZxWSDcqE5jtTzUE" +
       "hkVhmHSbJDeo0MUoVWZTHZEbTIVgpGoHlzYM3+71pA03wSqyzHUmbizrCVEb" +
       "qnUU65bggqGHtlHD17UxmfRFQhgu4y6cNNKhtOJwFR5GqN5BI7ThmCOng2zq" +
       "MNeV+JAT1kMNUZj5JhmEKNxeNuyJhARInKIWOksnS0mXaghVSNkSXsNqbg8d" +
       "V9100GPWmDDxOrU+0/QHQ2xRbozIgjHoytFY6hSXKVwtUQFSHXZFXGSLlqcO" +
       "jcms01a8+rTObOrdWTFAq86iOteIke85geUv6UZ5NsOdMjluRSUsGC4NrTTh" +
       "DBcxpg2xSo9h0SuURywvVAJqVkn6S4RbaSRMcAxurDpNpgBzVrJGlnNBNTWV" +
       "QYgp2xuPCxFKrLSG64YCJfGlOSFyG0tOIpzBcS5F42aymKDYbLVpYuSaQZSY" +
       "xB2EH4ZLI01bksh6gkoF5WFRDiVLbiyajNLwW3Q0pGeGUdcXZZGqFmJZKLML" +
       "zF6V5qSkjxe86y8KeqncDXkt6DJ1wiQULcbgatebIT3OGrDoXAW6LTZsWwSr" +
       "SU/WsiB7caU94QWJVbubstYPyLpdwm2lSU4Djhgp+KjXnG7asmVP0RDsMnGC" +
       "w8tkPRY6+Ihwye6IIou24lv6QIKReC5OO4FbhsNm045JW2+NWG5GVLUIWfEy" +
       "DmPR2PIHNiMNh8W1v5iTFswqTLieNUow6tTxpOOj0oJD4HLHnbpMVGTokMJL" +
       "I2xA4Rwh0P1+MG1YLRuhhMKQiFCqmE64alSsSdQgLtNLJC0hhDTG7dDn+I3t" +
       "p06d6PaGYqc+mKaNcTSQ617fwmuwqeOz3oyJVnI9892k7lF+RbVKjc5mbNmm" +
       "N1kPqkNd5FdDfDCSQfpgaqQ5N1irGxlBqx6OqpN1o24XJGfdwIgyMm14gVpg" +
       "urweNnp2re4URGsiLsZd1vLkFN6kxSJRhyvjuZuwRMswNbEtNBbYvDxBCEWP" +
       "kgqRunrFWXSoqkJw0qxeH29QsVffoLSRWBoHQsxoXQy63HQ2nVRwjePF1bSQ" +
       "Nqj6vDfQaasOx+yoWtD0mBNEmuQYVOjNNBcNvHLVAptWmy57VnXFkmIlJebz" +
       "yCU7jJoUhZIKUjjYiwnOTspIFR6acrGFq5syZ/fmAtOVZsVpCbd6qwCbDadU" +
       "pFQwPWa4zWYiRnJHnmC14kRednC+2zVLTd2XfH+8wcs9tM/pDXVZkmF/PRcw" +
       "gVeGPlauryiCQrtEBZ7zukE0VG+TLFrmopfW3MU0dfSeqLRnfaRcqOFq5PUT" +
       "L5xWRoIUCr1Fy1KLEe+S2Loz6vTbHrNYea25MwzFjaX0cLe43rhaT0msUIVL" +
       "IV3VDR4pawui3hya1kSQxBVNrVy9p26GQqHKMkWDdXAUprCEQtmCVzXb87Zo" +
       "8ki40qoS7LXX2lyrdJY87Eqwk/iTyjz0a5W4W8fxklig4EZTYuSx019HLkMh" +
       "ssePRZjW/MEaQ4hBrM0QmR7o2GbUUeEVNZZivNgCTse2/TAWsIpJ9HpWBQWR" +
       "Rq+sGGI0xrFBxypLxNzVrELKTbssXeTUajWt0LLbSY0OXXDrC4yhhRRtepuZ" +
       "H4d2PBLtaL7E+6oSxZvA10Kia1qOkspktd1aLUByw3jFdKG3PJWlHMXVyzyG" +
       "Iet2C8UqK67LeJRV7Xe7Pth+0LCj0pV0IrbH8dBUk4Y5aCJSZ7TSXd4qYwE9" +
       "RnFmiTKi2GM7mNIscSupVF5RHo+tyliF6JebpIAVxpE9s4strNOe18jeBmT5" +
       "qb7Ge8AYcLXcjjBtilnust8fOsmCmGmd7qRHTJyNRA2ZGTrSh6X6ptJjjVHD" +
       "1x2rVoQZaoyxJAs+VvpmxFbjuLLAHb2Aut3OzB82dWQxw5FGp+huNh2iVptz" +
       "QcGfyeAr7E3Z59ns5X0h35MXAw4OnsCHcfaCfxlfhttXj2XNaw/qMPnv3MnD" +
       "iqMlz8M6GJR97T50u/Ok/Ev3Y++58dyU/XhxZ69+qEbQxcjz3wA+TnT7CKkd" +
       "QOmp23/V0/lx2mFd6wvv+acHhz9pvuNlVOsfOcHnSZK/Qz//pfbrtF/ZgU4f" +
       "VLluOug7jvT08drWpUCP4sAdHqtwPXSg2Xszjb0KXPtqvufWFfNbl7dyK9iu" +
       "/Yny7M6eAveKQA/fVLjK9aBHepDVf/fB7jsKJmzvNa6bz/DMSxSAfy5r0gg6" +
       "F/tTJdqeDbztiKUpEXRe9TxbV9xDK1z/qPrE0VnygfhAbbmWXr1XHNwvEv4f" +
       "qO3U3lHRnj4euklt2dGT5c6yQ2o9p/DsS6jlRta8P4IuzfSoYRlGHOr7lO8/" +
       "ShkEvJme1fn3TqVz9fzSy1EP0P3Vm0/IsnL/Azedv2/PjLVPP3f5wv3PiX+V" +
       "HxIdnOtepKALRmzbR6uzR/rn/EA3rFy4i9tarZ/fPnpCoiMnd1nhMu/kTH9k" +
       "C/8bEXTlJHwEncluR8F+M4LuOAIGrGivdxTotyLoNADKup/w9/X7htudI9Zc" +
       "K/SiwPMt7VBR6anjAexgEa7+qEU4EvOeOBap8n9H7EeVePv/iOvaZ57rMe98" +
       "sfLx7QmXZiubTUblAgWd3x62HUSmx25LbZ/Wuc6TP7j7sxdfux9F794yfGj4" +
       "R3h75NbHSU3wtZofAG3+4P7fe+MnnvtGXqH9b28QLGO2IgAA");
}
