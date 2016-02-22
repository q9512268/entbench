package org.sunflow.core.filter;
public class TriangleFilter implements org.sunflow.core.Filter {
    private float s;
    private float inv;
    public TriangleFilter(float size) { super();
                                        s = size;
                                        inv = 1.0F / (s * 0.5F); }
    public float getSize() { return s; }
    public float get(float x, float y) { return (1.0F - java.lang.Math.abs(
                                                                         x *
                                                                           inv)) *
                                           (1.0F -
                                              java.lang.Math.
                                              abs(
                                                y *
                                                  inv)); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwU1xF/d/7E3zbfXwaMIeLrLqShDTKlgLGDyRksm1D1" +
                                                              "SDHrvXfnxXu7y+5b++yENqGqIJWKSOIATRP+IkqCCKCqUVu1iaiiNomSVkqa" +
                                                              "NkmrkKqtVNoUNahqUpW26cx7+31nI6T2pHu3997MvDfzZn4zs+evkQrLJK1U" +
                                                              "Ywk2blAr0aWxPsm0aKZTlSxrD8wNyqfKpL/tv7prY5xUpknDsGT1ypJFuxWq" +
                                                              "Zqw0WaxoFpM0mVq7KM0gR59JLWqOSkzRtTSZrVg9eUNVZIX16hmKBHslM0Wa" +
                                                              "JcZMZchmtMcRwMjiFJwkyU+S3Bpd7kiROlk3xn3yeQHyzsAKUub9vSxGmlIH" +
                                                              "pVEpaTNFTaYUi3UUTLLG0NXxnKqzBC2wxEF1g2OCnakNRSZou9T48Y0Tw03c" +
                                                              "BDMlTdMZV8/qp5aujtJMijT6s10qzVuHyFdIWYrUBogZaU+5myZh0yRs6mrr" +
                                                              "U8Hp66lm5zt1rg5zJVUaMh6IkWVhIYZkSnlHTB8/M0ioZo7unBm0XeppK7Qs" +
                                                              "UvHxNcnJU/ubvlNGGtOkUdEG8DgyHILBJmkwKM0PUdPamsnQTJo0a3DZA9RU" +
                                                              "JFWZcG66xVJymsRsuH7XLDhpG9Tke/q2gnsE3UxbZrrpqZflDuX8q8iqUg50" +
                                                              "nePrKjTsxnlQsEaBg5lZCfzOYSkfUbQMI0uiHJ6O7fcAAbBW5Skb1r2tyjUJ" +
                                                              "JkiLcBFV0nLJAXA9LQekFTo4oMnIgimFoq0NSR6RcnQQPTJC1yeWgGoGNwSy" +
                                                              "MDI7SsYlwS0tiNxS4H6u7dp0/H5thxYnMThzhsoqnr8WmFojTP00S00KcSAY" +
                                                              "61anTkpzXjwWJwSIZ0eIBc33Hri+ZW3r5VcFzcISNLuHDlKZDcpnhxreXNS5" +
                                                              "amMZHqPa0C0FLz+kOY+yPmelo2AAwszxJOJiwl283P/TLz14jn4YJzU9pFLW" +
                                                              "VTsPftQs63lDUal5N9WoKTGa6SEzqJbp5Os9pAqeU4pGxezubNairIeUq3yq" +
                                                              "Uuf/wURZEIEmqoFnRcvq7rMhsWH+XDAIIVXwJevgW0HEh/8y8sXksJ6nSUmW" +
                                                              "NEXTk32mjvpbSUCcIbDtcNKytayqjyUtU07qZs77L+smTcLe4DfJPRAfWk4F" +
                                                              "rMS/CXQw4/8nuoBazRyLxcDgi6LhrkKk7NDVDDUH5Ul7W9f1C4OvC1dC93fs" +
                                                              "wchK2C/h7JfA/RJiv0R4PxKL8W1m4b7iTuFGRiC2AVzrVg18eeeBY21l4EzG" +
                                                              "WDmYE0nbQkmm0wcAF7UH5Yst9RPLrqx/OU7KU6RFkpktqZgztpo5QCN5xAnY" +
                                                              "uiFIP34WWBrIApi+TF2mGQChqbKBI6VaH6UmzjMyKyDBzVEYjcmpM0TJ85PL" +
                                                              "p8ce2vvV2+MkHgZ+3LICMAvZ+xCuPVhujwZ8KbmNR69+fPHkYd0P/VAmcRNg" +
                                                              "ESfq0BZ1hKh5BuXVS6UXBl883M7NPgOgmUkQSoB6rdE9QsjS4aI06lINCmd1" +
                                                              "My+puOTauIYNm/qYP8M9tJk/zwK3qMVQmw/faif2+C+uzjFwnCs8Gv0sogXP" +
                                                              "Ap8fMJ569+d/+gw3t5swGgOZfoCyjgBIobAWDkfNvtvuMSkFuvdP9z32+LWj" +
                                                              "+7jPAsXyUhu249gJ4ARXCGb++quH3vvgytm3476fM8jS9hAUOwVPSZwnNdMo" +
                                                              "Cbut9M8DIKcCGqDXtN+rgX8qWUUaUikG1r8aV6x/4S/Hm4QfqDDjutHamwvw" +
                                                              "5+dvIw++vv+TVi4mJmOS9W3mkwnknulL3mqa0jieo/DQW4u/9Yr0FOQAwF1L" +
                                                              "maAcSmOlYh3jacAesiAulTxcw6iTle7oOyAfa+/7g8g480swCLrZzya/ufed" +
                                                              "g2/wS67GyMd51Ls+ENeAEAEPaxLG/xQ+Mfj+B79odJwQ6N7S6aSYpV6OMYwC" +
                                                              "nHzVNEVhWIHk4ZYPRp68+rxQIJqDI8T02OQ3Pk0cnxQ3JwqV5UW1QpBHFCtC" +
                                                              "HRw24umWTbcL5+j+48XDP3z28FFxqpZw2u2CqvL5X/37jcTp375WAvshhHRJ" +
                                                              "lJt3hq5zVvh2hErbH2780YmWsm5AjR5SbWvKIZv2ZIIyodKy7KHAdfklEJ8I" +
                                                              "KodXw0hsNdwCn97Aj3G7dxjCD0P42g4cVlhB8AxfVqCYHpRPvP1R/d6PXrrO" +
                                                              "FQ5X40Gs6JUMYe1mHFaitedGk9sOyRoGujsv77qvSb18AySmQaIMJai124TM" +
                                                              "Wgghi0NdUfXrH78858CbZSTeTWrAwpluiYM0mQHoSK1hSMoF4wtbBDiMITo0" +
                                                              "cVVJkfJFExigS0qHflfeYDxYJ74/97ubnjlzhaOUIWQs5PxxrBNCWZn3dH5i" +
                                                              "OPeLz/3ymUdOjglnmiY0Inzz/rlbHTryu38UmZznwRLREuFPJ88/uaBz84ec" +
                                                              "309IyN1eKK5tIKn7vHecy/893lb5kzipSpMm2emh9kqqjTCfhr7Bchsr6LNC" +
                                                              "6+EeQBS8HV7CXRQN18C20VQYjIFyFvJ3P/vVudmv0kkMldHsFyP8Ic1ZbuPj" +
                                                              "ahzWucmmyjAV6LNpJNvUTiMUgowT3yVSK449OOwTMlJTOuKeWz+4jMN9jJQp" +
                                                              "2mipPTPT7CmWbsNhjbezt1uoWA/mUt+7hZrzGJlbVNKKGhZDfPFU/RYH07NH" +
                                                              "Js9kdj+9Pu4AzxYGMasb61Q6StVIIC0OBVIv7zB9r3y/4dHf/6A9t+1WKluc" +
                                                              "a71J7Yr/l0BIrJ46NqNHeeXInxfs2Tx84BaK1CURK0VFPtd7/rW7V8qPxnk7" +
                                                              "LcKlqA0PM3WEg6TGpMw2tXBqWO7dezNe8zz41jv3Xl+6UCzhMl75NRXrNIlm" +
                                                              "Ypq1B3CwIQRzlA1ABcT923ft0ZuF0/S4jhP9Bp8/FLaC9+D+3poVpmKNaBoX" +
                                                              "fu0F7V1c9NFp7PEwDkcg1sEeEVt87X9hiwIjDeEeFJPfvKK3WuJNjHzhTGP1" +
                                                              "3DP3vsMDzntbUgehk7VVNQjPgedKw6RZhatTJ8Da4D+PlAIR0RczfG+FD/zc" +
                                                              "JwT9JCNNUXpGyvEnSHaKkdoAGcNyiT8FiZ4AkwIRPn7bcCGtied8TFMJkaYK" +
                                                              "sQAcOUbktp99M9t7LMGeB0GEv1Z0A94WLxahRT+zc9f91z/7tOi5ZFWamEAp" +
                                                              "tVDrifbPA41lU0pzZVXuWHWj4dKMFS68NosD+068MOBf/YDoBl75gkhDYrV7" +
                                                              "fcl7Zze99LNjlW9B3bCPxCRGZu4rTugFwwa03pcqrmkBYHmn1LHqifHNa7N/" +
                                                              "/Q0vmYiogRdNTQ8Fy2Pv9lwa+WQLf49VAZmDFnilsX1c66fyqBkqkBvQGyV8" +
                                                              "wcjt4Jiv3pvFDp2RtuLuoPi9BpSTY9TcpttahsMmALo/E3q/6eKsbRgRBn8m" +
                                                              "0EFtx2FjAa0P/jeY6jUMt3kyDR6RXdE+gU9y5gv8EYeL/wWzgfBKYRgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9qLi6ib7o3v+4C2/8+y3ihzf/wI8Ne2pZCIAAA==");
}
