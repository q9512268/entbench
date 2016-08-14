package org.apache.batik.ext.awt.image;
public class PointLight extends org.apache.batik.ext.awt.image.AbstractLight {
    private double lightX;
    private double lightY;
    private double lightZ;
    public double getLightX() { return lightX; }
    public double getLightY() { return lightY; }
    public double getLightZ() { return lightZ; }
    public PointLight(double lightX, double lightY, double lightZ, java.awt.Color lightColor) {
        super(
          lightColor);
        this.
          lightX =
          lightX;
        this.
          lightY =
          lightY;
        this.
          lightZ =
          lightZ;
    }
    public boolean isConstant() { return false; }
    public final void getLight(final double x, final double y, final double z,
                               final double[] L) { double L0 = lightX -
                                                     x;
                                                   double L1 = lightY -
                                                     y;
                                                   double L2 = lightZ -
                                                     z;
                                                   final double norm =
                                                     java.lang.Math.
                                                     sqrt(
                                                       L0 *
                                                         L0 +
                                                         L1 *
                                                         L1 +
                                                         L2 *
                                                         L2);
                                                   if (norm > 0) {
                                                       final double invNorm =
                                                         1.0 /
                                                         norm;
                                                       L0 *=
                                                         invNorm;
                                                       L1 *=
                                                         invNorm;
                                                       L2 *=
                                                         invNorm;
                                                   }
                                                   L[0] = L0;
                                                   L[1] = L1;
                                                   L[2] = L2; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZC5AUxRnu2zuO4x7cg6fAHa8Di9cuGlCpMyochxwucMXh" +
                                                              "lSzIMTvbuzvc7Mw403u3nCE+qlKQVEIRAqiJXlUSFGIhWEbLvCSkKF+lsUrE" +
                                                              "GLXEPKwEo5SSlMbEJOb/u2d2HvugqJKt2t7Z7r//7v/v//++7p6j58koyyRt" +
                                                              "VGNhtsOgVrhLYz2SadFEpypZ1kao65fvq5T+sfXcumUhUh0jY9OStVaWLLpK" +
                                                              "oWrCipFWRbOYpMnUWkdpAnv0mNSi5qDEFF2LkQmK1Z0xVEVW2Fo9QVGgTzKj" +
                                                              "pFlizFTiWUa7bQWMtEZhJhE+k8jyYHNHlNTLurHDFZ/sEe/0tKBkxh3LYqQp" +
                                                              "ul0alCJZpqiRqGKxjpxJFhi6uiOl6ixMcyy8XV1qu2BNdGmBC2Y93vjp53vT" +
                                                              "TdwF4yRN0xk3z9pALV0dpIkoaXRru1Sase4gXyeVUVLnEWakPeoMGoFBIzCo" +
                                                              "Y60rBbNvoFo206lzc5ijqdqQcUKMzPQrMSRTythqevicQUMNs23nncHaGXlr" +
                                                              "hZUFJh5YENl/39amJypJY4w0KlovTkeGSTAYJAYOpZk4Na3liQRNxEizBovd" +
                                                              "S01FUpVhe6VbLCWlSSwLy++4BSuzBjX5mK6vYB3BNjMrM93Mm5fkAWX/G5VU" +
                                                              "pRTYOtG1VVi4CuvBwFoFJmYmJYg7u0vVgKIlGJke7JG3sf0WEICuozOUpfX8" +
                                                              "UFWaBBWkRYSIKmmpSC+EnpYC0VE6BKDJyJSSStHXhiQPSCnajxEZkOsRTSA1" +
                                                              "hjsCuzAyISjGNcEqTQmskmd9zq+7fs+d2motRCpgzgkqqzj/OujUFui0gSap" +
                                                              "SSEPRMf6+dGD0sRndocIAeEJAWEh8/TXLty0sO3kC0JmahGZ9fHtVGb98qH4" +
                                                              "2Fendc5bVonTqDF0S8HF91nOs6zHbunIGYAwE/MasTHsNJ7c8Nymux+lH4RI" +
                                                              "bTeplnU1m4E4apb1jKGo1LyZatSUGE10kzFUS3Ty9m4yGp6jikZF7fpk0qKs" +
                                                              "m1SpvKpa5//BRUlQgS6qhWdFS+rOsyGxNH/OGYSQ0fAl9fBtJeLDfxnZEknr" +
                                                              "GRqRZElTND3SY+povxUBxImDb9OROET9QMTSsyaEYEQ3UxEJ4iBN7QbMTGmI" +
                                                              "RZQMLD94A8I1qqTSADQQZcZl1p9D+8YNVVSA66cFE1+FnFmtqwlq9sv7syu6" +
                                                              "Lhzrf0kEFSaC7RlG5sGQYTFkmA/JYRKGDPMhw+6QpKKCjzQehxYLDMszAIkO" +
                                                              "SFs/r/f2Ndt2z6qEyDKGqsC3KDrLxzidLho4EN4vH29pGJ559qpTIVIVJS2S" +
                                                              "zLKSigSy3EwBNMkDdvbWx4GLXEqY4aEE5DJTl2kCEKkUNdhaavRBamI9I+M9" +
                                                              "GhzCwtSMlKaLovMnJ+8fuqfvrsUhEvKzAA45CgAMu/cgducxuj2Y/cX0Nu46" +
                                                              "9+nxgzt1Fwd8tOKwYUFPtGFWMBaC7umX58+Qnup/Zmc7d/sYwGkmQV4BBLYF" +
                                                              "x/DBTIcD2WhLDRic1M2MpGKT4+Naljb1IbeGB2kzfx4PYVGHeTcBvtfZich/" +
                                                              "sXWigeUkEdQYZwErOCV8tdd46PevvP8V7m6HPRo9tN9LWYcHsVBZC8emZjds" +
                                                              "N5qUgtw79/d878D5XZt5zILE7GIDtmPZCUgFSwhu/sYLd7z57tlDZ0JunDOg" +
                                                              "7Gwcdj65vJFYT2rLGAmjzXXnA4inAipg1LTfqkF8KklFiqsUE+s/jXOueurD" +
                                                              "PU0iDlSoccJo4cUVuPVXrCB3v7T1n21cTYWMjOv6zBUTMD7O1bzcNKUdOI/c" +
                                                              "PadbH3heeggIAUDYUoYpx9Uq7oMqf65jPvVm4xbkpZKBZRi0Kerqnm3y7vae" +
                                                              "9wT9XFGkg5CbcCTynb43tr/MF7kGMx/r0e4GT14DQngirEk4/wv4VMD3f/hF" +
                                                              "p2OFgPqWTptvZuQJxzByMPN5ZXaIfgMiO1veHXjw3GPCgCAhB4Tp7v3f+iK8" +
                                                              "Z79YObFrmV2wcfD2ETsXYQ4Wy3B2M8uNwnus+uvxnb88snOXmFWLn4O7YIv5" +
                                                              "2O/++3L4/j+8WAT+qxM6xK5I1SUYzXnsHu9fHmHTym82/mpvS+UqgI1uUpPV" +
                                                              "lDuytDvhVQr7Lisb96yXuyHiFV7rcG2AVubDMmDFdbzgU5nMyFgehEhEEJ66" +
                                                              "ySWW8sbF+dkSPlvC29ZgMcfywqt/OT17735575mPG/o+PnGBu8S/efeiyVrJ" +
                                                              "EOvRjMVcXI9JQfpbLVlpkFtyct2WJvXk56AxBhploHNrvQn0m/Nhjy09avRb" +
                                                              "vzk1cdurlSS0itSqupRYJXEYJ2MAP6mVBubOGTfeJOBjqAaKJm4qKTC+oAJT" +
                                                              "eHpxcOjKGIyn8/DPJj15/eGRsxzHDKFjKu9fiZsJH2/zI6BLHY++du3rh797" +
                                                              "cEiEW5nkCfSb/O/1avzeP31W4HLOlEXyKdA/Fjn64JTOGz7g/V3Kwt7tucIN" +
                                                              "ENC+2/fqRzOfhGZVPxsio2OkSbaPXH2SmkUiiMExw3LOYXAs87X7jwxif9yR" +
                                                              "p+RpwYT2DBskS2+SVDFfQrj8iHtUMh++M23qmBnkxwrCH7bwLlfycj4Wixw6" +
                                                              "Gm2YChzLaYCP6sooBSBQcY93Wz4Px/HOt2Bxu1C0rmQ09l367LntW51hNxUb" +
                                                              "NnkZht3uGzZWbNiBMsOKpiuxWJAfnH+qSeBo4SV7N7kIIkhrqdMfR/ND9+4f" +
                                                              "Sax/+KqQjWs3MYAE3Vik0kGqelThjU6rL0/X8vOuG/TvjN3355+3p1ZcytYa" +
                                                              "69ousnnG/9Mh4+aXTv3gVJ6/929TNt6Q3nYJu+TpAS8FVf5k7dEXb54r7wvx" +
                                                              "w73IxoJLAX+nDn8O1pqUZU3NT02z8+vagus1Fb5z7XWdGwwqN3ICIZHf/5Xq" +
                                                              "WobH7irTdg8WwxAQKSrOZLe5lMmD986L5Ux54sCKjQavHyz0wyLbmEWX7odS" +
                                                              "XcvY+u0ybXuw2OXxw6aAH3ZfTj8ssY1Zcul+KNW1jK0PlGn7ARb7PX6IBfxw" +
                                                              "4DL4YRy2IcZ12sZ0XrofSnUtY+sjZdqOYPFD5qVxLncNFsuEYR2e5xuBJOO6" +
                                                              "rlJJC+588W9XzvXgjy6DB5uxbTF8e2w3rC/jwSDBh/AxzGBroWiSGuD4JkdZ" +
                                                              "EaUB/9knNx4wbuF/TZA/l/FjoDgCbKl77tfWj//yhNj+FTv1BS4mjxyukd/O" +
                                                              "PPeeQ2jX5qeMycSperU9Zf7LSN+XdGmWonom0pmNK7JzHXeZNCOrzynNhh7v" +
                                                              "jTwy+5W7Rmb/kZ8SahQL+BXouMiVsKfPx0ff/eB0Q+sxzuNVyNacroJ36YVX" +
                                                              "5b4bcO77RixO5FyU8J758H+fELC3S8+WC0EsnuaqluGGimopli6WaZUwL3w8" +
                                                              "Zbj5ERJ6nLOeuHDADTZshnSNSs6RFNrEdaOih/OvIaAxV3Tyg651pzzww6dT" +
                                                              "Bj1eL9P2BhanIdtknJcwo4z4W6UQwAMWPqDhvX5RRuNZLH7KSI0D8cVcXDWo" +
                                                              "KwkXs578MjArB3DqXv7imXJywbsl8T5EPjbSWDNp5NY3RIA67yzqYcuYzKqq" +
                                                              "99Tjea42TJpUuI314gwkbgHeZ6St/J00rAb/5TM/J3p9yMjkUr0gBKH0Sn8E" +
                                                              "YVVMGiSh9Er+nZGmoCSMz3+9cp+At1w5yAfx4BX5DLSDCD7+y3Cie+FFrt+X" +
                                                              "A56asHXni5Cr8B8l8gs+4WIL7jl9zPbhFH+r6AB4VrxX7JePj6xZd+eFax4W" +
                                                              "t6yyKg0Po5Y6gBRx4Zvfpc8sqc3RVb163udjHx8zx4H/ZjFhl+GmeqJ9IySG" +
                                                              "gbE2JXAFabXnbyLfPHT9id/urj4NELqZVEiAHpsLD+g5IwvHo83RwkssQFx+" +
                                                              "N9ox7/s7bliY/OhtfgVCxKXXtNLy/fKZw7e/tm/yobYQqeuGENQSNMdvDlbu" +
                                                              "0DZQedCMkQbF6srBFEELQJXvhmwspoWE7xu5X2x3NuRr8Y6ekVmF94OFbzZq" +
                                                              "VX2Imiv0rJawiaDOrXGw33fQyRpGoINb42GHlQJVBAlX9kfXGoZzfVqVMjgu" +
                                                              "dBWHMSgr6vkjPjX8H9KNoltxIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
