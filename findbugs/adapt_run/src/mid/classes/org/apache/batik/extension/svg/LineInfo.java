package org.apache.batik.extension.svg;
public class LineInfo {
    java.awt.geom.Point2D.Float loc;
    java.text.AttributedCharacterIterator aci;
    org.apache.batik.gvt.font.GVTGlyphVector gv;
    int startIdx;
    int endIdx;
    float advance;
    float visualAdvance;
    float lastCharWidth;
    float lineWidth;
    boolean partial;
    java.awt.geom.Point2D.Float verticalAlignOffset;
    public LineInfo(java.awt.geom.Point2D.Float loc, java.text.AttributedCharacterIterator aci,
                    org.apache.batik.gvt.font.GVTGlyphVector gv,
                    int startIdx,
                    int endIdx,
                    float advance,
                    float visualAdvance,
                    float lastCharWidth,
                    float lineWidth,
                    boolean partial,
                    java.awt.geom.Point2D.Float verticalAlignOffset) {
        super(
          );
        this.
          loc =
          loc;
        this.
          aci =
          aci;
        this.
          gv =
          gv;
        this.
          startIdx =
          startIdx;
        this.
          endIdx =
          endIdx;
        this.
          advance =
          advance;
        this.
          visualAdvance =
          visualAdvance;
        this.
          lastCharWidth =
          lastCharWidth;
        this.
          lineWidth =
          lineWidth;
        this.
          partial =
          partial;
        this.
          verticalAlignOffset =
          verticalAlignOffset;
    }
    public java.awt.geom.Point2D.Float getLocation() { return loc;
    }
    public java.text.AttributedCharacterIterator getACI() { return aci;
    }
    public org.apache.batik.gvt.font.GVTGlyphVector getGlyphVector() {
        return gv;
    }
    public int getStartIdx() { return startIdx; }
    public int getEndIdx() { return endIdx; }
    public float getAdvance() { return advance; }
    public float getVisualAdvance() { return visualAdvance; }
    public float getLastCharWidth() { return lastCharWidth; }
    public float getLineWidth() { return lineWidth; }
    public boolean isPartialLine() { return partial; }
    public java.awt.geom.Point2D.Float getVerticalAlignOffset() {
        return verticalAlignOffset;
    }
    public java.lang.String toString() { return "[LineInfo loc: " +
                                         loc +
                                         " [" +
                                         startIdx +
                                         ',' +
                                         endIdx +
                                         "] " +
                                         " LWidth: " +
                                         lineWidth +
                                         " Adv: " +
                                         advance +
                                         " VAdv: " +
                                         visualAdvance +
                                         " LCW: " +
                                         lastCharWidth +
                                         " Partial: " +
                                         partial +
                                         " verticalAlignOffset: " +
                                         verticalAlignOffset; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1aC5AUxRnu3Xs/4B7IQQ5EOQ6UA3YFIRQ5JeDx2mOPW+7g" +
                                                              "NEfiMTvbuzsyOzPM9N4tGEStUikrsSxBY3yQSoIVtVCsVKykktJgHj7KqCWx" +
                                                              "Eh8VNbESjY8qSVXExKj5/56ZndnZm6HWXOWqpq+3u//u7+v++///7pnjH5Aa" +
                                                              "QyddmqCkhAjbp1EjksB8QtANmuqTBcPYAaVj4s1/PnzwzO8brguT2lEyPSsY" +
                                                              "A6Jg0E0SlVPGKDlXUgwmKCI1tlGaQomETg2qjwtMUpVRMlMyYjlNlkSJDagp" +
                                                              "ig1GBD1O2gTGdCmZZzRmdcDIeXGOJsrRRNd7G/TGSbOoavscgc4SgT5XHbbN" +
                                                              "OeMZjLTGrxLGhWieSXI0Lhmst6CTJZoq78vIKovQAotcJa+yJqI/vqpsGroe" +
                                                              "afnok1uzrXwaZgiKojJO0RiihiqP01SctDilG2WaM/aSa0hVnDS5GjPSHbcH" +
                                                              "jcKgURjU5uu0AvTTqJLP9amcDrN7qtVEBMTI/NJONEEXclY3CY4ZeqhnFncu" +
                                                              "DGzPL7K1l9tD8fYl0SPfubL1x1WkZZS0SMowwhEBBINBRmFCaS5JdWN9KkVT" +
                                                              "o6RNgQUfprokyNJ+a7XbDSmjCCwPKmBPCxbmNarzMZ25gpUEbnpeZKpepJfm" +
                                                              "SmX9qknLQga4djhcTYabsBwINkoATE8LoHuWSPUeSUlxPSqVKHLs3goNQLQu" +
                                                              "R1lWLQ5VrQhQQNpNFZEFJRMdBuVTMtC0RgUV1Lmu+XSKc60J4h4hQ8cYme1t" +
                                                              "lzCroFUDnwgUYWSmtxnvCVap07NKrvX5YNslt1ytbFHCJASYU1SUEX8TCM3z" +
                                                              "CA3RNNUp7ANTsLknfofQ8dihMCHQeKansdnmp988vW7pvJNPm23mTNJmMHkV" +
                                                              "FdmYeCw5/cW5fYvXVCGMek01JFz8EuZ8lyWsmt6CBpamo9gjVkbsypNDT37t" +
                                                              "2gfpe2HSGCO1oirnc6BHbaKa0ySZ6pupQnWB0VSMNFAl1cfrY6QO8nFJoWbp" +
                                                              "YDptUBYj1TIvqlX5b5iiNHSBU9QIeUlJq3ZeE1iW5wsaIaQOHtIMz3xi/vH/" +
                                                              "jGSjWTVHo4IoKJKiRhO6ivxxQbnNoQbkU1CrqdEk6P+eZcsjq6OGmtdBIaOq" +
                                                              "nokKoBVZalbiPqWKAYyjxngmysEDoghqnPZ/HKuAvGdMhEKwJHO9BkGGvbRF" +
                                                              "lVNUHxOP5C/bePrhsWdNZcMNYs0YIxfAgBFzwAgfMFIcMAIDRuwBSSjExzkH" +
                                                              "BzaXHar2wPYH+9u8ePgb/bsPdVWBvmkT1TDj2HRRmT/qc+yEbdzHxOMvDp15" +
                                                              "4bnGB8MkDKYkCf7IcQrdJU7B9Gm6KtIUWCU/92CbyKi/Q5gUBzl558R1Iwcv" +
                                                              "4jjcdh47rAETheIJtM7FIbq9+3uyfltueuejE3ccUJ2dXuI4bH9XJokGpMu7" +
                                                              "ql7yY2LP+cKjY48d6A6TarBKYImZAEsGRm6ed4wSQ9JrG2XkUg+E06qeE2Ss" +
                                                              "si1pI8vq6oRTwtWtjefPgSVuwp01A54V1lbj/7G2Q8N0lqmeqDMeFtzoXzqs" +
                                                              "3fvy83+/mE+37R9aXI59mLJel03Cztq59WlzVHCHTim0+9OdicO3f3DTLq5/" +
                                                              "0GLBZAN2Y9oHtgiWEKb5hqf3vvLG68deCjs6y8Ap55MQ3xSKJLGcNAaQRD13" +
                                                              "8IBNk2Gvo9Z071RAK6W0JCRlipvkPy0Llz/6/i2tph7IUGKr0dKzd+CUf+ky" +
                                                              "cu2zV56Zx7sJiehTnTlzmpmGeobT83pdF/YhjsJ1p8797lPCvWDywcwa0n7K" +
                                                              "LWcTn4Mmznw2I3O4pDDBIhmq5sDEg4NesQHmUBWY3WYhb4MBRaQY4KX6sjC/" +
                                                              "IrjZGKN8ou3WF5ZZmsw4i6RBYSObR3Zslvdp2RHKQwjcWC7TgbHmcD5psIQu" +
                                                              "5UAXxi1PeKLjzN7f1O3fYHu5yUTMlluNgRd+vuXtMa5r9WhisBxxTXMZj/V6" +
                                                              "xqXoraYOfA5/IXg+wwfXHgtMn9LeZzm284ueTdMKgH5xQChaSiF6oP2NPfe8" +
                                                              "85BJwev5PY3poSM3fx655YipQGZ4tKAsQnHLmCGSSQeTtYhuftAoXGLT2ycO" +
                                                              "/OL+AzeZqNpLnf1GiGUf+sOnv4vc+eYzk/iTKskKcS/GHVX0BR3e1TEp1S6/" +
                                                              "918Hb3x5EIxXjNTnFWlvnsZS7j4hvjPySddyOYEXL3CTw6VhJNQDq4AFl3Ic" +
                                                              "vRZx/LfOld/A0OrY2uxCiz/7eQdxJzlbV3VJVZWpoPh3toqnK3mDaLEZ4c0I" +
                                                              "r7sck27D7VZK9cd1qhgTb33pw2kjHz5+mq9B6bHEbUUHBM1UgDZMFqICzPK6" +
                                                              "8C2CkYV2K09u+3qrfPIT6HEUehQhHDEGdQggCiU212pdU/fqE7/u2P1iFQlv" +
                                                              "Io0wkalNAndfpAH8BjWyEHsUtK+uM83mRD0krZwqKSOPluq8yW3gxpzGuNXa" +
                                                              "/7NZP7nkR0df5+banPY5lsXC05A30uBHWsdJvv/a3W/98swP60yNDtifHrnZ" +
                                                              "/x6Uk9f/5eOySeYxwSRb1iM/Gj1+T2ff2ve4vOOcUXpBoTxog/DFkV3xYO6f" +
                                                              "4a7a34ZJ3ShpFa3j44gg59HljcKRybDPlHDELKkvPf6YsX5vMfiY67UZrmG9" +
                                                              "YYF7I1azkk3XVuoku+FZYDnJBd5IIER4JstFFvF0MSZLLQ0o7ao6oCuwMLIq" +
                                                              "8g1lhheYXoGJZPayy1flkuWAu61Run0AayZgTPaUY/STBoyCKGF2tQfj3gox" +
                                                              "IvuF1igLfTBOBGL0k2YknBnH3BoPxEKFEBfDs8gaZJEPxGsCIfpJM1IPSqmz" +
                                                              "WMo05x6gBysEeoH12PnJgN4QCNRPGuJGOLn6wLyxQpgXWo+dnwzmtwJh+kmD" +
                                                              "lxJS47jLi37NhfPbFeKMWGtv68BkOA8H4vSTZmTauGTkBXm9P9ojXwBtjzVe" +
                                                              "jw/auwLR+kkDWlkwGIa9l0sp8y7Ci/buCtHiGEus8Zb4oP1+IFo/aUYa8GLF" +
                                                              "F+kPvoC2LrXGWuqD9P5ApH7SoK1wUmOSwC/GtntwPlAhzpXwLLNGWuaD80Qg" +
                                                              "Tj9pRmaMw3FbEkFfZSmjmBdYWOV1UI8EYC44Y/cUx+Z/tcRzmeUa2xUGEYzs" +
                                                              "zvW7b+Rh/bHrjxxNDd63PGzFmxtBGZiqLZPpOJVdXTXzQ4I3ohrgt6xOeLL6" +
                                                              "1Jmq126b3Vx+bYM9zfO5lOnxD728Azx1/budO9Zmd1dwH3Oeh7+3ywcGjj+z" +
                                                              "eZF4W5hfFJvRUNkFc6lQb2kM1KhTlteV0uNHV3HFOnEl0NXGrBWLeXXN0QnP" +
                                                              "YhdvGvxEA04OTwbUPY3JE4w0ZSiLq6Jg36WschTzV2fbTCXBOhbs5sWPFcFf" +
                                                              "YO+Mfgt8f+W8/UQDuJ0KqHsJk+fANQPv9X0x/LXaofz8/0yZLzWav60W7q2V" +
                                                              "U/YTDaD1ekDdm5i8wsh0oOy6T8HSNQ71V6eGOmp53MIfr5y6n2gAvXcD6t7H" +
                                                              "5K+mlg+7g0aH99+mhjeG5AMW+IHKefuJBnD7KKDuY0xOgyEH3hudGNRh/Y+p" +
                                                              "YY1HnG0W9G2Vs/YT9WcWCgfUVWPhp4w04t52BYkO7c+mhjYGYoMW9sHKafuJ" +
                                                              "BlCbHlCH11yhBkZagfZIWYRcJB9qnDryCYtBonLyfqIBBDsD6uZiMtMkHy8L" +
                                                              "uB3yHVNDHg+j2y0G2ysn7ycaQHBRQN2FmMxnpBnJl8TvDvGuqSGOrnzIQj9U" +
                                                              "OXE/0QByKwLqVmKyDM5YkpEwTwNIH1tud5hHpob5RfAMW/CHK2fuJxrAbm1A" +
                                                              "HV4wh9Yw0oGb3eeA4UzBV6ZmCrrg2Wnx2Fn5FPiJBtDsD6jDw2kITin1TDU/" +
                                                              "4eCtZoMN4JfFeLkZcVXwidhU+UQUYAT7NTdeRc8u+7bG/B5EfPhoS/2sozv/" +
                                                              "yF+1Fr/ZaI6T+nRelt03pa58rabTtMQnr9m8N+VvJ0I7GZkX/O6dkSpIEXRo" +
                                                              "hylzBSOd/jIQBRTzbqldMGFeKUZq+H93uyvBoTrtIHI2M+4mAmCCJphNapOs" +
                                                              "hnnVXAjxquLB1F4cMvNsi+M6yy4oOSnyr6LsU13e/C5qTDxxtH/b1ae/fJ/5" +
                                                              "DlmUhf37sZemOKkzX2fzTvFkON+3N7uv2i2LP5n+SMNC+3TcZgJ2lH6OK+za" +
                                                              "TUhIQ13p9LxgNbqL71lfOXbJ488dqj0VJqFdBGduxq7yS/mClodj6674ZK/H" +
                                                              "4NzM3/32Nr61+4WPXw2183cfxHyhNi9IYkw8/PhribSm3RUmDTFSA4d/WuBv" +
                                                              "DDbsU4aoOK6XvG2rTap5pfgB1XRUbAF3FZ8Za0KnFUvxGwRGuspfPJZ/l9Eo" +
                                                              "qxNUvwx7x26mec7SeU1z1/KZ5Qe1tQWcadC1sfiApllvXGu/x2de03DXhvL4" +
                                                              "o/+/pYq3GPooAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "HzjuyX33Xsnl59TMITnmvpM798ht0h7L");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("gwtx6XI+7k4cFB6zO3fxXtnlx3OjQ3aj+8/umdukfX8ePBmXrgJ205sOQ/cc" +
       "n7ofHNlDjuz95/jybdJeyYPndxzpm45W9xxfuFeO+bWB8SHH8f3neJvrS+fg" +
       "PHgtLj2ac7zhoHbPr3yv/HIXODnkN7n//N64TVo+gzxXj0uP2RG7O/XNWeY5" +
       "8T3Bxr0SrICHOyTI3X+CxG3Scod+DotLT+cD8Yxz5D1T/F6ZvgQe4ZCpcP+Z" +
       "crdJE/KAiUuXYn9/5PzlPbfR3XDLQD1HV6rz+6HP3vQ7jt1vD9RffPvKpWfe" +
       "Fn6nuFV8/PuAh+nSJSNxnJMXuU7ELwShbtgF24d317qCgsLH4tLzt7/nHZce" +
       "AGEO99wP78pcj0vPnV0GOM/j+MlSCjBbp0vFpYeK/yfz6cBB7fOBWeIucjKL" +
       "BTCBLHnUDgpB3nj+v7sJl50rkp49qTuFD3/yTt1yYs308g0rneIXOEerkmT3" +
       "G5zr6tfe7jM/9p36z+yuS6uOvN3mtVyiSxd3N7eLSvOVzYtn1nZU1wXy1e8+" +
       "/ksPv3K0Cnt8B3ivxyewvXDru8ldN4iL28Tbf/jMr3z4597+veI6wv8FAEg2" +
       "FRo1AAA=");
}
