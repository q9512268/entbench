package org.apache.batik.svggen;
public class SVGFontDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private org.w3c.dom.Element def;
    private java.lang.String fontSize;
    private java.lang.String fontWeight;
    private java.lang.String fontStyle;
    private java.lang.String fontFamily;
    public SVGFontDescriptor(java.lang.String fontSize, java.lang.String fontWeight,
                             java.lang.String fontStyle,
                             java.lang.String fontFamily,
                             org.w3c.dom.Element def) { super();
                                                        if (fontSize ==
                                                              null ||
                                                              fontWeight ==
                                                              null ||
                                                              fontStyle ==
                                                              null ||
                                                              fontFamily ==
                                                              null)
                                                            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
                                                              org.apache.batik.svggen.ErrorConstants.
                                                                ERR_FONT_NULL);
                                                        this.
                                                          fontSize =
                                                          fontSize;
                                                        this.
                                                          fontWeight =
                                                          fontWeight;
                                                        this.
                                                          fontStyle =
                                                          fontStyle;
                                                        this.
                                                          fontFamily =
                                                          fontFamily;
                                                        this.
                                                          def =
                                                          def;
    }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_FONT_SIZE_ATTRIBUTE,
            fontSize);
        attrMap.
          put(
            SVG_FONT_WEIGHT_ATTRIBUTE,
            fontWeight);
        attrMap.
          put(
            SVG_FONT_STYLE_ATTRIBUTE,
            fontStyle);
        attrMap.
          put(
            SVG_FONT_FAMILY_ATTRIBUTE,
            fontFamily);
        return attrMap;
    }
    public org.w3c.dom.Element getDef() { return def;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        if (def !=
              null &&
              !defSet.
              contains(
                def))
            defSet.
              add(
                def);
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZeWxUxxmfXeMT44twhMMYs4aYY7eUAGpMIWAwGNbYxeC2" +
       "Jsny9u3s+sHb9x7vzeI1JOWQSFCaoigQQtuAVErSgAhEaWgbpFBHPUhKUwSN" +
       "2iS0lIY/2pQghT8S0tLrm5l37dsDuUcsvfF45rvnm998Mz5xAxUbOmrUBCUm" +
       "BMmAho1gF+13CbqBY62yYBhrYTQiPv7Hfdtv/bp8px+V9KKqPsHoEAUDt0lY" +
       "jhm9aKKkGERQRGysxjhGObp0bGB9i0AkVelFoySjPanJkiiRDjWGKUGPoIdR" +
       "rUCILkVTBLebAgiaFGbWhJg1ocVegpYwqhRVbcBhGJfB0Oqao7RJR59BUE14" +
       "o7BFCKWIJIfCkkFa0jqaoanyQEJWSRCnSXCjPNcMxMrw3KwwNL5U/cntJ/tq" +
       "WBhGCoqiEuaisQYbqrwFx8Ko2hldJuOksRl9DRWF0XAXMUGBsKU0BEpDoNTy" +
       "16EC60dgJZVsVZk7xJJUoonUIIImZwrRBF1ImmK6mM0goYyYvjNm8LbB9tZa" +
       "bo+LT88I7X/moZqXi1B1L6qWlG5qjghGEFDSCwHFySjWjcWxGI71oloFFrwb" +
       "65IgS1vN1a4zpIQikBSkgBUWOpjSsM50OrGClQTf9JRIVN12L86SyvyrOC4L" +
       "CfB1tOMr97CNjoODFRIYpscFyD2TZdgmSYmxPMrksH0MrAICYC1NYtKn2qqG" +
       "KQIMoDqeIrKgJELdkHxKAkiLVUhBneVaHqE01pogbhISOELQWC9dF58CqnIW" +
       "CMpC0CgvGZMEqzTOs0qu9bmxesHebcoKxY98YHMMizK1fzgw1XuY1uA41jHs" +
       "A85YOT18QBj92h4/QkA8ykPMaX748M37Z9YPvsFpxueg6YxuxCKJiEejVRcn" +
       "tDZ/oYiaUaaphkQXP8Nztsu6zJmWtAZIM9qWSCeD1uTgmp9/dcdxfN2PKtpR" +
       "iajKqSTkUa2oJjVJxvpyrGBdIDjWjsqxEmtl8+2oFPphScF8tDMeNzBpR8Nk" +
       "NlSisr8hRHEQQUNUAX1JiatWXxNIH+unNYRQKXxoCXxTEP9hvwnaGOpTkzgk" +
       "iIIiKWqoS1ep/3RBGeZgA/oxmNXUUBTyf9Os2cH5IUNN6ZCQIVVPhATIij7M" +
       "J0PGlkQCK6HunuVtEKyl2BB1SYPkD9Kc0z5TbWnq+8h+nw+WZYIXFGTYTytU" +
       "OYb1iLg/tWTZzZOR8zzh6CYxo0ZQM6gMcpVBpjLIVQazVCKfj2m6i6rmiw9L" +
       "twlAAFC4srn7wZUb9jQWQdZp/cMg7pR0atap1OqghQXxEfHExTW3LrxVcdyP" +
       "/AAoUTiVnKMhkHE08JNNV0UcA2zKd0hYQBnKfyzktAMNHuzf2bP9c8wON9pT" +
       "gcUAVJS9i2K0rSLg3eW55FY/9udPTh14RHX2e8bxYZ16WZwURhq96+p1PiJO" +
       "bxBOR157JOBHwwCbAI+JAPsHoK7eqyMDTlosaKa+lIHDcVVPCjKdsvC0gvTp" +
       "ar8zwhKulvXvgiUeTvfXBPhmmRuO/aazozXajuEJSnPG4wWD/i92a4fe+dUH" +
       "c1i4rVOi2nW8d2PS4kImKqyOYVCtk4JrdYyB7vcHu/Y9feOx9Sz/gGJKLoUB" +
       "2rYCIsESQph3v7H53T9cOfq238lZAkdzKgpVTtp2ko6jigJO0jx37AFkk2G/" +
       "06wJrFMgK6W4JERlTDfJ36ubZp/+cG8NzwMZRqw0mnlnAc743UvQjvMP3apn" +
       "YnwiPVmdmDlkHK5HOpIX67owQO1I77w08ZvnhEMA/AC2hrQVM/wsZjEoZp6P" +
       "hUKLcdJDNMgPUTo+12ksupEUQfrniMGYmgzSegkrhC38vYwixNo5NGhMPmJz" +
       "99EmYLg3UOYedVVREfHJtz8a0fPR2ZvM48wyzJ0vHYLWwlOUNk1pED/GC1Yr" +
       "BKMP6O4dXP1AjTx4GyT2gkQRwNfo1AEs0xnZZVIXl773+k9Gb7hYhPxtqEJW" +
       "hVibwDYqKocdgo0+wNm0tuh+niD9ZdDUMFdRlvN0TSblXu1lSY2w9dn6ozGv" +
       "LPje4SssMXkmjjfXhlZ/XkxlJbwDBx9e/va1H9/6bikvAJrzY6CHb+zfOuXo" +
       "rvc/zQoyQ78cxYmHvzd04tlxrQuvM34Hhij3lHT2AQVA7fB+/njyY39jyc/8" +
       "qLQX1YhmudwjyCm6uXuhRDSsGhpK6oz5zHKP1zYtNsxO8EKgS60XAJ2DEfqU" +
       "mvZHeDCvkq7iWPgCJhwEvJjnQ6yzirFMZW0zbWZaEFOq6RJcq7AHY4YXEEpQ" +
       "UQzHaXc+h1TattAmzKUszJt8yzJNp3DdZGppymP6Wm46bVZn25iPm6CyOCx6" +
       "N8CJDRIuQ9cN0dB6+KaaqqbmMXR9QUPzcRNUQQ39MpYSfSSXqQ8M0dSJ8E0z" +
       "lU3LY2q0oKn5uAkqZzElA3LOoIr/QVDvMXXdk8dSqaCl+bjNoLYJSUkeyGXq" +
       "xgKmph2V022V7KcEecp598HrAKPfOoyaCpSzTilrUU8uQN09AACWpmfIxHw3" +
       "OXYLPbpr/+FY53OzOdzWZd6OlsHl/8Xf/OOXwYNX38xRfJcTVZsl4y1YdvlS" +
       "BConZ4F8B7voOog5/9KtostPja3MrpmppPo8FfH0/KeBV8G5XX8Zt3Zh34Yh" +
       "FMOTPIHyijzWceLN5VPFp/zsrs4BOuuOn8nUkgnLFTomKV1ZmwHOjXbKVFs5" +
       "vshMmUXeHHeS0pNtdpmXj9VTzPjsS84k91rRt7HuVNQga4R+licR8YnG3Tun" +
       "ld6cxxOkISe163Fgzq151Q3HX1A4eSC38Mxngfe3nT+i/u6637ry52LhlKuM" +
       "jgtnVvwpwha1jGaNHUpXxizWE656v8aOURUNSS18V80Ysd//6ysvCEmGiJSE" +
       "ijO0VkrimFlT/n8u2AW10d0/PmsrOkt7+szz8/fM/MoRHvjJeTaXQ//ql65e" +
       "PLT11AkOBTT8BM3I946Y/XhJ74NNBe60ThJ9vPy+wQ+u9TzoN8vtKtp8PW3h" +
       "3ginAIXqlg7uy5HYo72JxGWXzD701+2PvtMJ1812VJZSpM0p3B7L3KelRirq" +
       "yiznwczZtWZa/Qt+fPD9k340negAT6u6VvPxqMF+PdK0NJ0nyDcdukzO7gK3" +
       "jGdpswMuCQlM7Gdo0+PHnaNp551O0YwCng60suGH7Z0xkk7dDd8qc2esGjrw" +
       "5GMt4N/zBeZeoM134EILvi81a0fH5SP/tcuMuAG+TtPuzqG7nI81D9bSvx/N" +
       "RKM6+I6ZUo5ZUp5gUr7BXdxLm1fs1K9yXwj5BfwHXkX0z2d4dr1cIMJnaPMi" +
       "XJR5hCWFvVLAfYWOf9+J9cmhxzpNUG3WAxy9Oo7Nevvn79XiycPVZWMOr/st" +
       "ewSy35QrAeXjKVl232xc/RJNB7uZM5X8nqOxX68TNCZPaQQJxTvM8kFO/1MI" +
       "gpeeoGL22013DqpEhw5E8Y6b5Bdw1QES2j2v5XiK4Be8tM9VMJnlI4v1qDvF" +
       "2mZxvxFRKGX/e7HALtVlIvapwytXb7s57zn+RiXKwtatVMpwgDj+XGYXP5Pz" +
       "SrNklaxovl31UnmTBcq13GBnm4x3JVcr5KFGV3yc5wHHCNjvOO8eXXD2rT0l" +
       "l+A4WY98AkEj12dfhdNaCmqU9eFcYA6lIXtbaqm4tuHCp+/56tiLA+LwX1+I" +
       "IyLuO3u5K65p3/Kj8nZUDIUwTrN7+tIBZQ0Wt+gZZ0NJVE0p9r9pqmh6CvRJ" +
       "iUXGDOgIe5S+cRLUmPUPmBzvvhWy2o/1JVS6edZklIspTXPPssgeoM3BNI00" +
       "5Fok3KFp5plT+iqLvKaxTXiFwcC/AS/81o5gHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
