package org.sunflow.core.filter;
public class GaussianFilter implements org.sunflow.core.Filter {
    private float s;
    private float es2;
    public GaussianFilter(float size) { super();
                                        s = size;
                                        es2 = (float) -java.lang.Math.exp(
                                                                        -s *
                                                                          s);
    }
    public float getSize() { return s; }
    public float get(float x, float y) { float gx = (float) java.lang.Math.
                                                      exp(
                                                        -x *
                                                          x) + es2;
                                         float gy = (float) java.lang.Math.
                                                      exp(
                                                        -y *
                                                          y) + es2;
                                         return gx * gy; }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfYxUVxW/M/v9wX4By/cCy4Lha6Zg0ZJFBJZdWJyFzS7F" +
                                                              "OFiWN2/u7D72zXuP9+7bnd2W2pI2UI0EgVJqgL9oWgktaGzUaBtMo23TatJa" +
                                                              "baspNWoiWoklxtaIWs+59715HzOzhEQnmTt37jvn3HPOPed3zn2XbpAKyyRt" +
                                                              "VGMxNmFQK9atsX7JtGi6S5UsazesDclPlEl/23d95/ooqUyShhHJ6pMli/Yo" +
                                                              "VE1bSbJA0SwmaTK1dlKaRo5+k1rUHJOYomtJMlOxerOGqsgK69PTFAn2SGaC" +
                                                              "NEuMmUrKZrTXEcDIggRoEueaxDeHH3cmSL2sGxMe+WwfeZfvCVJmvb0sRpoS" +
                                                              "B6QxKW4zRY0nFIt15kyy0tDViWFVZzGaY7ED6jrHBTsS6wpc0H6l8aNbx0ea" +
                                                              "uAumS5qmM26eNUAtXR2j6QRp9Fa7VZq1DpIHSVmC1PmIGelIuJvGYdM4bOpa" +
                                                              "61GB9tOoZme7dG4OcyVVGjIqxMjioBBDMqWsI6af6wwSqpljO2cGaxflrRVW" +
                                                              "Fpj4+Mr4qSf2NX2njDQmSaOiDaI6MijBYJMkOJRmU9S0NqfTNJ0kzRoc9iA1" +
                                                              "FUlVJp2TbrGUYU1iNhy/6xZctA1q8j09X8E5gm2mLTPdzJuX4QHl/KvIqNIw" +
                                                              "2Nrq2Sos7MF1MLBWAcXMjARx57CUjypampGFYY68jR1fAAJgrcpSNqLntyrX" +
                                                              "JFggLSJEVEkbjg9C6GnDQFqhQwCajMwtKRR9bUjyqDRMhzAiQ3T94hFQ1XBH" +
                                                              "IAsjM8NkXBKc0tzQKfnO58bODcfu17ZrURIBndNUVlH/OmBqCzEN0Aw1KeSB" +
                                                              "YKxfkTgttb5wNEoIEM8MEQua7z1wc9OqtquvCJp5RWh2pQ5QmQ3JF1INb8zv" +
                                                              "Wr6+DNWoNnRLwcMPWM6zrN950pkzAGFa8xLxYcx9eHXgp1966CL9IEpqe0ml" +
                                                              "rKt2FuKoWdazhqJScxvVqCkxmu4lNVRLd/HnvaQK5glFo2J1VyZjUdZLylW+" +
                                                              "VKnz/+CiDIhAF9XCXNEyujs3JDbC5zmDEFIFX7IavhVEfPgvI1+Mj+hZGpdk" +
                                                              "SVM0Pd5v6mi/FQfESYFvR+KWrWVUfTxumXJcN4fz/2XdpHHYG+Imvk2yLUuR" +
                                                              "tB7+N4YBZvz/ROfQqunjkQg4fH443VXIlO26mqbmkHzK3tJ987mh10QoYfg7" +
                                                              "/mBkGewXc/aL4X4xsV8suB+JRPg2M3BfcaZwIqOQ2wCu9csH79ux/2h7GQST" +
                                                              "MV4O7kTS9kCR6fIAwEXtIflyy7TJxdfWvBQl5QnSIsnMllSsGZvNYUAjedRJ" +
                                                              "2PoUlB+vCizyVQEsX6Yu0zSAUKlq4Eip1seoieuMzPBJcGsUZmO8dIUoqj+5" +
                                                              "emb84T1fuStKokHgxy0rALOQvR/hOg/LHeGELya38cj1jy6fPqR7qR+oJG4B" +
                                                              "LOBEG9rDgRB2z5C8YpH0/NALhzq422sAmpkEqQSo1xbeI4AsnS5Koy3VYHBG" +
                                                              "N7OSio9cH9eyEVMf91Z4hDbz+QwIizpMtTnwrXFyj//i01YDx1kiojHOQlbw" +
                                                              "KvC5QePcOz//06e5u92C0eir9IOUdfpACoW1cDhq9sJ2t0kp0L13pv/k4zeO" +
                                                              "7OUxCxRLim3YgWMXgBMcIbj50VcOvvv+tQtvRb04Z1Cl7RQ0O7m8kbhOaqcw" +
                                                              "EnZb5ukDIKcCGmDUdNyrQXwqGUVKqRQT61+NS9c8/5djTSIOVFhxw2jV7QV4" +
                                                              "63O2kIde2/dxGxcTkbHIej7zyARyT/ckbzZNaQL1yD385oInX5bOQQ0A3LWU" +
                                                              "ScqhNFIs1zGfBu2UBXmpZOEYxpyqtLZ/v3y0o/8PouLMKcIg6GY+E//6nrcP" +
                                                              "vM4PuRozH9fR7mm+vAaE8EVYk3D+J/CJwPc/+EWn44JA95Yup8QsytcYw8iB" +
                                                              "5sunaAqDBsQPtbw/evb6s8KAcA0OEdOjp776SezYKXFyolFZUtAr+HlEsyLM" +
                                                              "wWE9ard4ql04R88fLx/64TOHjgitWoJltxu6ymd/9e/XY2d++2oR7IcU0iXR" +
                                                              "bt4dOM4ZwdMRJm19rPFHx1vKegA1ekm1rSkHbdqb9suETsuyU77j8logvuA3" +
                                                              "Do+GkcgKOAW+vI6rcVdeGcKVIfzZdhyWWn7wDB6Wr5keko+/9eG0PR++eJMb" +
                                                              "HOzG/VjRJxnC2804LENvzwoXt+2SNQJ0d1/d+eUm9eotkJgEiTK0oNYuEypr" +
                                                              "LoAsDnVF1a9//FLr/jfKSLSH1IKH0z0SB2lSA+hIrREoyjnj85sEOIxXw9DE" +
                                                              "TSUFxhcsYIIuLJ763VmD8WSd/P6s7254+vw1jlKGkDGP80exTwhUZX6n8wrD" +
                                                              "xV989pdPf+P0uAimKVIjxDf7n7vU1OHf/aPA5bwOFsmWEH8yfuns3K6NH3B+" +
                                                              "ryAhd0eusLeBou7xrr2Y/Xu0vfInUVKVJE2yc4faI6k2wnwS7g2We7GCe1bg" +
                                                              "efAOIBreznzBnR9OV9+24VLoz4FyFoh3r/rV4xHipNIpDJXh6hchfJLkLJ/i" +
                                                              "4wocVrvFpsowFbhn01C1qZtCKCQZJ75HlFYce3HYK2QkSgbi7qDirW7v7P4W" +
                                                              "UVwWiuNwX6GGpbgZKaPW2mI6pqfQMefttTK/V94DgebeX3u9bBBumc3IrIIW" +
                                                              "WPS8CAkLSt3POPheOHzqfHrXU2uiDlBtYpDjurFapWNUDSXegkDi9fEbqRfF" +
                                                              "7zWc+P0POoa33EknjGttt+l18f9CSKEVpXM5rMrLh/88d/fGkf130NQuDHkp" +
                                                              "LPJbfZde3bZMPhHl12+RXgXX9iBTZzCpak3KbFMLlpIl+XNvxmOeDd8G59wb" +
                                                              "whHqRVYoZPLtWinWKQrTA1M8exCHcUjZYcoGoWPi8e2Fdu526Td1HcCFAYOv" +
                                                              "W0Ev4KTFMaXlzr1QijVkaVTEdT5p7+GiH5vCH1/D4RHIdfBHyBeP/i98kWOk" +
                                                              "IXhnxWI5u+AtmHhzIz93vrF61vl73+YJl3+7Ug+pk7FV1Q/nvnmlYdKMws2p" +
                                                              "F+Bu8J+TxUBE3KMZvufCCdf7hKA/zUhTmJ6Rcvzxkz3JSJ2PjGF7xWd+orPg" +
                                                              "UiDC6TnDhbQm3iNgWYuJspaL+ODIcSL3/czb+T7P4r8jIYjw15BuwtviRSRc" +
                                                              "6c/v2Hn/zc88Je5osipNTqKUOugNxXUxDxqLS0pzZVVuX36r4UrNUhdem4XC" +
                                                              "XhDP88XXACC6gUc+N3SBsTry95h3L2x48WdHK9+EPmMviUiMTN9b2ADkDBvQ" +
                                                              "em+isAcGgOU3q87l35zYuCrz19/wFouInnl+aXpocE6+03tl9ONN/L1XBVQO" +
                                                              "muOdydYJbYDKY2agoW7AaJTwhST3g+O+aflVvNEz0l54myh8DwLt5zg1t+i2" +
                                                              "luawCYDurQTeh7o4axtGiMFb8d24tuKwPofeh/gbSvQZhnvZ0gyekd3hewVf" +
                                                              "5MxX+BSHb/8XHs7Ir5EYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/r03/9az385yf/8Nt8R6pXwiAAA=");
}
