package org.sunflow.core.filter;
public class MitchellFilter implements org.sunflow.core.Filter {
    public float getSize() { return 4.0F; }
    public float get(float x, float y) { return mitchell(x) * mitchell(y);
    }
    private float mitchell(float x) { final float B = 1 / 3.0F;
                                      final float C = 1 / 3.0F;
                                      final float SIXTH = 1 / 6.0F;
                                      x = java.lang.Math.abs(x);
                                      float x2 = x * x;
                                      if (x > 1.0F) return ((-B - 6 * C) *
                                                              x *
                                                              x2 +
                                                              (6 *
                                                                 B +
                                                                 30 *
                                                                 C) *
                                                              x2 +
                                                              (-12 *
                                                                 B -
                                                                 48 *
                                                                 C) *
                                                              x +
                                                              (8 *
                                                                 B +
                                                                 24 *
                                                                 C)) * SIXTH;
                                      return ((12 - 9 * B - 6 * C) * x * x2 +
                                                (-18 +
                                                   12 *
                                                   B +
                                                   6 *
                                                   C) *
                                                x2 +
                                                (6 -
                                                   2 *
                                                   B)) * SIXTH; }
    public MitchellFilter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO39/4C8wEALmyyCZwF1oQ9vINAU7djA5YwsT" +
                                                              "1JqWY7w3d7d4b3fZnbXPJrQJagT9CEEECK0a/0XUJEoCqhq1VZuIKlKTKGml" +
                                                              "RKhJWoVUaqXSD9SgSskftE3fm9m9/TjbiKo56eb2Zt68ee/Nb37vzT53jVTZ" +
                                                              "FulgOk/wKZPZiT6dD1PLZplejdr2HuhLK09U0H/uv7rr7jipHiVNeWoPKtRm" +
                                                              "/SrTMvYoWaHqNqe6wuxdjGVwxrDFbGZNUK4a+ihpV+2BgqmpisoHjQxDgb3U" +
                                                              "SpFWyrmljjmcDbgKOFmRAkuSwpLk9uhwd4o0KoY55YsvDYj3BkZQsuCvZXPS" +
                                                              "kjpIJ2jS4aqWTKk27y5a5A7T0KZymsETrMgTB7Utbgh2praUhWDNxeaPbpzM" +
                                                              "t4gQLKS6bnDhnr2b2YY2wTIp0uz39mmsYB8iXycVKdIQEOakM+UtmoRFk7Co" +
                                                              "560vBdYvYLpT6DWEO9zTVG0qaBAnq8NKTGrRgqtmWNgMGmq567uYDN6uKnkr" +
                                                              "vSxz8cwdydNP7G/5UQVpHiXNqj6C5ihgBIdFRiGgrDDGLHt7JsMyo6RVh80e" +
                                                              "YZZKNXXa3ek2W83plDuw/V5YsNMxmSXW9GMF+wi+WY7CDavkXlYAyv1XldVo" +
                                                              "Dnxd7PsqPezHfnCwXgXDrCwF3LlTKsdVPcPJyuiMko+d94MATK0pMJ43SktV" +
                                                              "6hQ6SJuEiEb1XHIEoKfnQLTKAABanCybUynG2qTKOM2xNCIyIjcsh0CqTgQC" +
                                                              "p3DSHhUTmmCXlkV2KbA/13ZtPXFY36HHSQxszjBFQ/sbYFJHZNJulmUWg3Mg" +
                                                              "JzZuSJ2li186HicEhNsjwlLmJw9e37ax49JrUub2WWSGxg4yhaeV82NNby3v" +
                                                              "7bq7As2oNQ1bxc0PeS5O2bA70l00gWEWlzTiYMIbvLT7V1956Fn2tzipHyDV" +
                                                              "iqE5BcBRq2IUTFVj1n1MZxblLDNA6pie6RXjA6QGnlOqzmTvUDZrMz5AKjXR" +
                                                              "VW2I/xCiLKjAENXDs6pnDe/ZpDwvnosmIaQGvmQTfKuI/IhfTnYn80aBJU01" +
                                                              "OWwZ6LqdBLIZg7Dmk7ajZzVjMmlbStKwcqX/imGxJCwLkEkOqlzJM03rF38T" +
                                                              "iC3zU9FaRF8WTsZiEObl0UOuwfnYYWgZZqWV005P3/UX0m9IACHo3Shwsh7W" +
                                                              "S7jrJXC9hFwvEV6PxGJimUW4rtxJ2IdxONFAqY1dI1/beeD4mgqAkDlZCUFE" +
                                                              "0TWh1NLrH3uPq9PKhbYF06uvbH4lTipTpI0q3KEaZortVg44SBl3j2njGCQd" +
                                                              "n/tXBbgfk5ZlKCwD1DNXDnC11BoTzMJ+ThYFNHiZCc9gcu68MKv95NK5yYf3" +
                                                              "fuPOOImH6R6XrAKmwunDSNIlMu6MHvPZ9DYfu/rRhbNHDP/Ah/KHl/bKZqIP" +
                                                              "a6JAiIYnrWxYRV9Mv3SkU4S9DgiZUzhAwHUd0TVCfNLtcTP6UgsOZw2rQDUc" +
                                                              "8mJcz/OWMen3CIS2YtMuwYoQihgoaP2LI+aT7/7mL58VkfQyQHMgdY8w3h1g" +
                                                              "HVTWJvil1UfkHosxkHv/3PDjZ64d2yfgCBJrZ1uwE9teYBvYHYjgI68deu+D" +
                                                              "K+cvx30Ic0i7zhhUL0Xhy6JP4BOD73/wi0yBHZIx2npd2lpV4i0TV17v2wYM" +
                                                              "psGhR3B0PqADDNWsSsc0hufnX83rNr/49xMtcrs16PHQsvHmCvz+23rIQ2/s" +
                                                              "/7hDqIkpmEH9+PlikpYX+pq3WxadQjuKD7+94nuv0ieB4IFUbXWaCZ4kIh5E" +
                                                              "bOAWEYs7RXtXZOzz2KyzgxgPH6NApZNWTl7+cMHeD1++LqwNl0rBfR+kZrdE" +
                                                              "kdwFWCxB3CbE2zi62MR2SRFsWBIlqh3UzoOyuy7t+mqLdukGLDsKyypQRNhD" +
                                                              "FrBkMQQlV7qq5ne/fGXxgbcqSLyf1GsGzfRTceBIHSCd2Xkg2KL5pW3Sjsla" +
                                                              "aFpEPEhZhMo6cBdWzr6/fQWTix2Z/umSH2/94cwVAUtT6rg9qHC9aLuw2Shh" +
                                                              "i4+biqVgiU/1PMEK6IyJ56WcLClLCjILYGBXzFWniBrr/NHTM5mhpzbLaqIt" +
                                                              "nPv7oLR9/rf/fjNx7g+vz5KK6rhhbtLYBNMCNlXgkqFMMihKOJ/N3m869cef" +
                                                              "deZ6biWJYF/HTdIE/l8JTmyYOylETXn16F+X7bknf+AW8sHKSDijKp8ZfO71" +
                                                              "+9Yrp+KiXpWpoKzODU/qDgYWFrUYFOY6uok9C8RpWlsCSCviYakLEg8sodMk" +
                                                              "iVugDZu+0lSBw/p5ps5DFl+eZ2wUmxFOanKMjwALhYsJ3NsRZ8yGxK8WIBlM" +
                                                              "uMXuZ4YPKMc7h/8koXfbLBOkXPvTyUf3vnPwTbFJtYiKUmgCiAD0BFJYCzYJ" +
                                                              "hH/XPFfHsD3JI20fjP/g6vPSnmilHhFmx09/+5PEidPyWMjrzNqyG0VwjrzS" +
                                                              "RKxbPd8qYkb/ny8c+fnTR47F3VjfzzHdGpSXdiJWquAWhWMoLb33W82/ONlW" +
                                                              "0Q/HbYDUOrp6yGEDmTDkamxnLBBU//7jA9C1GXMoJ7ENHrl9AZs98nnr/8ir" +
                                                              "2NFjiv6hMMwXuXj1cHuLMJ9ragTKcWFIHP/uF41Qbc8DeAcbuElVAODFDD8W" +
                                                              "xqcQizYcWwbfJtehpnliUZZg4FyaljoBRU4xHKKGeTRGnI/5uUpG5+g80fkm" +
                                                              "Noc5qS24V5JIiB78f4SoyElT+MqD+Xlp2asTed1XXphprl0y88A7IumUruSN" +
                                                              "QChZR9MCRyF4LKpNi2VV4VOjrGlM8fPd2TKuvIZxfDmCD8Lu70j5xzhpicpz" +
                                                              "Uok/QbFTnDQExDgeS/EUFDoDqAMhfDxrevm/RZQl+D4kIS//xVh56SFi336z" +
                                                              "2JemBOtwpE7x7spjF0e+vYIb4czOXYevf+4peQ9QNDo9jVoagFPkbaOUOFfP" +
                                                              "qc3TVb2j60bTxbp1HtWF7iFB2wQCAI6iZl8WKYztzlJ9/N75rS//+nj120DS" +
                                                              "+0iMcrJwX+DNkYwUVNcOVCz7UuXcCUWGqNi7u74/dc/G7D9+L6o6l2uXzy2f" +
                                                              "VkYff3fg4vjH28TLkipgcVYcJfWqfe+UvpspE1aIiJsQjRTfYok4uOFbUOrF" +
                                                              "CyEna8qTS/k1GireSWb1GI6ecam8we8JvUTzag3HNCMT/J5APs1J9sfoA/7S" +
                                                              "qUHT9G5Tl01xIvOzcUVeTH5GPGLz7H8Bi7jHx8YWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mp/Zaj3r/izw2ChPFgGGbrmSndN5IgYWYyvX9310CpJHoOLrcxvNybwKpMu5" +
       "dWTC7G4zrm2sytrylou8X7ujNdzY5xXs/uVDYowHkrcP/uPTX/vV13wLbFEX" +
       "OrvM1Ad25siKvSTLZ3/l+Y889LJnvv3BPACB6DN+8r3euzKq9N0kzho8a9r7" +
       "oj6YiTr2klDRGCmK2TxOaGou7V0tcxBaDgity71kDX7q2rcWH//OZ7aJ2Ekz" +
       "PAGsvf+ZD/xo90PP7BxJf19zSwZ6FGebAudMv3xPwyH02N1WyTGIf/rcU3/0" +
       "O0+9b8vVtePJXBucVT7zV//9td1nv/2V2+QWZ2zvJ9jY+J5nyUpENfd/zFTQ" +
       "+dUkTXm9X27AFay+ajcZZ73GxBVR8oaNJdVrTlB13qwKq4grdQNeQFdlFVUr" +
       "clkXXXk26IbDrmRwDazdbmN0UYKLs0m37WGBGZSmYkLRNs3RHcce0WaX96YT" +
       "KZiN8cbYGEcLPW6XdafhNGBuLlu0V61pMiLGtbqmwT25jC43XLU8n3IikdhG" +
       "fwGvaHEgWlxNxUsDRvRtba6GCJmYDF1sTIoknCzRMETnlk9a057GewM6Hjnw" +
       "OOTYpeDxEhn0Aq22SlJ13pmu0hAn5I7Ym9AVqWCZ/rSAtIwAOFfkkfNhihty" +
       "eTL2CX4dOvZ87ii4bNB9whk1F8l45TOLRmKu1IpXpD2hWhWiJS7My62FOIwS" +
       "bCnOBuPF3Ke6yHxckQKeoxcIuq5K1SbKFWlx7URtLmQNroVOYtkwET+UJiaP" +
       "91JNGsj+ho0rxpChxzXZxU03RGREEJAVR/nFZFNuOE4ktOrWbK1MaZUatvvS" +
       "gi1MYscbEQsUA0osLluqsBQYn6vhfLvf2HDTTjGQWk03qPdorhOOjCB2+J7B" +
       "dpygWkMTAe/VEtpdhMtxuqkrK3Wt9gZoB65OhlOgy1kvmNewqmUaLUolRlbH" +
       "CHG8w5Ax2o3YtVcbTc16URNEke7NZlJZWyB8vezbeLKCp0AzPTZ1xjO+0WGJ" +
       "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" +
       "iTctIQAA");
}
