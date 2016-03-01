package org.apache.xml.utils;
public class XML11Char {
    private static final byte[] XML11CHARS = new byte[1 << 16];
    public static final int MASK_XML11_VALID = 1;
    public static final int MASK_XML11_SPACE = 2;
    public static final int MASK_XML11_NAME_START = 4;
    public static final int MASK_XML11_NAME = 8;
    public static final int MASK_XML11_CONTROL = 16;
    public static final int MASK_XML11_CONTENT = 32;
    public static final int MASK_XML11_NCNAME_START = 64;
    public static final int MASK_XML11_NCNAME = 128;
    public static final int MASK_XML11_CONTENT_INTERNAL = MASK_XML11_CONTROL |
      MASK_XML11_CONTENT;
    static { java.util.Arrays.fill(XML11CHARS, 1, 9, (byte) 17);
             XML11CHARS[9] = 35;
             XML11CHARS[10] = 3;
             java.util.Arrays.fill(XML11CHARS, 11, 13, (byte) 17);
             XML11CHARS[13] = 3;
             java.util.Arrays.fill(XML11CHARS, 14, 32, (byte) 17);
             XML11CHARS[32] = 35;
             java.util.Arrays.fill(XML11CHARS, 33, 38, (byte) 33);
             XML11CHARS[38] = 1;
             java.util.Arrays.fill(XML11CHARS, 39, 45, (byte) 33);
             java.util.Arrays.fill(XML11CHARS, 45, 47, (byte) -87);
             XML11CHARS[47] = 33;
             java.util.Arrays.fill(XML11CHARS, 48, 58, (byte) -87);
             XML11CHARS[58] = 45;
             XML11CHARS[59] = 33;
             XML11CHARS[60] = 1;
             java.util.Arrays.fill(XML11CHARS, 61, 65, (byte) 33);
             java.util.Arrays.fill(XML11CHARS, 65, 91, (byte) -19);
             java.util.Arrays.fill(XML11CHARS, 91, 93, (byte) 33);
             XML11CHARS[93] = 1;
             XML11CHARS[94] = 33;
             XML11CHARS[95] = -19;
             XML11CHARS[96] = 33;
             java.util.Arrays.fill(XML11CHARS, 97, 123, (byte) -19);
             java.util.Arrays.fill(XML11CHARS, 123, 127, (byte) 33);
             java.util.Arrays.fill(XML11CHARS, 127, 133, (byte) 17);
             XML11CHARS[133] = 35;
             java.util.Arrays.fill(XML11CHARS, 134, 160, (byte) 17);
             java.util.Arrays.fill(XML11CHARS, 160, 183, (byte) 33);
             XML11CHARS[183] = -87;
             java.util.Arrays.fill(XML11CHARS, 184, 192, (byte) 33);
             java.util.Arrays.fill(XML11CHARS, 192, 215, (byte) -19);
             XML11CHARS[215] = 33;
             java.util.Arrays.fill(XML11CHARS, 216, 247, (byte) -19);
             XML11CHARS[247] = 33;
             java.util.Arrays.fill(XML11CHARS, 248, 768, (byte) -19);
             java.util.Arrays.fill(XML11CHARS, 768, 880, (byte) -87);
             java.util.Arrays.fill(XML11CHARS, 880, 894, (byte) -19);
             XML11CHARS[894] = 33;
             java.util.Arrays.fill(XML11CHARS, 895, 8192, (byte) -19);
             java.util.Arrays.fill(XML11CHARS, 8192, 8204, (byte) 33);
             java.util.Arrays.fill(XML11CHARS, 8204, 8206, (byte) -19);
             java.util.Arrays.fill(XML11CHARS, 8206, 8232, (byte) 33);
             XML11CHARS[8232] = 35;
             java.util.Arrays.fill(XML11CHARS, 8233, 8255, (byte) 33);
             java.util.Arrays.fill(XML11CHARS, 8255, 8257, (byte) -87);
             java.util.Arrays.fill(XML11CHARS, 8257, 8304, (byte) 33);
             java.util.Arrays.fill(XML11CHARS, 8304, 8592, (byte) -19);
             java.util.Arrays.fill(XML11CHARS, 8592, 11264, (byte) 33);
             java.util.Arrays.fill(XML11CHARS, 11264, 12272, (byte) -19);
             java.util.Arrays.fill(XML11CHARS, 12272, 12289, (byte) 33);
             java.util.Arrays.fill(XML11CHARS, 12289, 55296, (byte) -19);
             java.util.Arrays.fill(XML11CHARS, 57344, 63744, (byte) 33);
             java.util.Arrays.fill(XML11CHARS, 63744, 64976, (byte) -19);
             java.util.Arrays.fill(XML11CHARS, 64976, 65008, (byte) 33);
             java.util.Arrays.fill(XML11CHARS, 65008, 65534, (byte) -19);
    }
    public static boolean isXML11Space(int c) { return c < 65536 && (XML11CHARS[c] &
                                                                       MASK_XML11_SPACE) !=
                                                  0; }
    public static boolean isXML11Valid(int c) { return c <
                                                  65536 &&
                                                  (XML11CHARS[c] &
                                                     MASK_XML11_VALID) !=
                                                  0 ||
                                                  65536 <=
                                                  c &&
                                                  c <=
                                                  1114111;
    }
    public static boolean isXML11Invalid(int c) { return !isXML11Valid(
                                                            c);
    }
    public static boolean isXML11ValidLiteral(int c) { return c <
                                                         65536 &&
                                                         ((XML11CHARS[c] &
                                                             MASK_XML11_VALID) !=
                                                            0 &&
                                                            (XML11CHARS[c] &
                                                               MASK_XML11_CONTROL) ==
                                                            0) ||
                                                         65536 <=
                                                         c &&
                                                         c <=
                                                         1114111;
    }
    public static boolean isXML11Content(int c) {
        return c <
          65536 &&
          (XML11CHARS[c] &
             MASK_XML11_CONTENT) !=
          0 ||
          65536 <=
          c &&
          c <=
          1114111;
    }
    public static boolean isXML11InternalEntityContent(int c) {
        return c <
          65536 &&
          (XML11CHARS[c] &
             MASK_XML11_CONTENT_INTERNAL) !=
          0 ||
          65536 <=
          c &&
          c <=
          1114111;
    }
    public static boolean isXML11NameStart(int c) {
        return c <
          65536 &&
          (XML11CHARS[c] &
             MASK_XML11_NAME_START) !=
          0 ||
          65536 <=
          c &&
          c <
          983040;
    }
    public static boolean isXML11Name(int c) {
        return c <
          65536 &&
          (XML11CHARS[c] &
             MASK_XML11_NAME) !=
          0 ||
          c >=
          65536 &&
          c <
          983040;
    }
    public static boolean isXML11NCNameStart(int c) {
        return c <
          65536 &&
          (XML11CHARS[c] &
             MASK_XML11_NCNAME_START) !=
          0 ||
          65536 <=
          c &&
          c <
          983040;
    }
    public static boolean isXML11NCName(int c) {
        return c <
          65536 &&
          (XML11CHARS[c] &
             MASK_XML11_NCNAME) !=
          0 ||
          65536 <=
          c &&
          c <
          983040;
    }
    public static boolean isXML11NameHighSurrogate(int c) {
        return 55296 <=
          c &&
          c <=
          56191;
    }
    public static boolean isXML11ValidName(java.lang.String name) {
        int length =
          name.
          length(
            );
        if (length ==
              0)
            return false;
        int i =
          1;
        char ch =
          name.
          charAt(
            0);
        if (!isXML11NameStart(
               ch)) {
            if (length >
                  1 &&
                  isXML11NameHighSurrogate(
                    ch)) {
                char ch2 =
                  name.
                  charAt(
                    1);
                if (!org.apache.xml.utils.XMLChar.
                      isLowSurrogate(
                        ch2) ||
                      !isXML11NameStart(
                         org.apache.xml.utils.XMLChar.
                           supplemental(
                             ch,
                             ch2))) {
                    return false;
                }
                i =
                  2;
            }
            else {
                return false;
            }
        }
        while (i <
                 length) {
            ch =
              name.
                charAt(
                  i);
            if (!isXML11Name(
                   ch)) {
                if (++i <
                      length &&
                      isXML11NameHighSurrogate(
                        ch)) {
                    char ch2 =
                      name.
                      charAt(
                        i);
                    if (!org.apache.xml.utils.XMLChar.
                          isLowSurrogate(
                            ch2) ||
                          !isXML11Name(
                             org.apache.xml.utils.XMLChar.
                               supplemental(
                                 ch,
                                 ch2))) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            ++i;
        }
        return true;
    }
    public static boolean isXML11ValidNCName(java.lang.String ncName) {
        int length =
          ncName.
          length(
            );
        if (length ==
              0)
            return false;
        int i =
          1;
        char ch =
          ncName.
          charAt(
            0);
        if (!isXML11NCNameStart(
               ch)) {
            if (length >
                  1 &&
                  isXML11NameHighSurrogate(
                    ch)) {
                char ch2 =
                  ncName.
                  charAt(
                    1);
                if (!org.apache.xml.utils.XMLChar.
                      isLowSurrogate(
                        ch2) ||
                      !isXML11NCNameStart(
                         org.apache.xml.utils.XMLChar.
                           supplemental(
                             ch,
                             ch2))) {
                    return false;
                }
                i =
                  2;
            }
            else {
                return false;
            }
        }
        while (i <
                 length) {
            ch =
              ncName.
                charAt(
                  i);
            if (!isXML11NCName(
                   ch)) {
                if (++i <
                      length &&
                      isXML11NameHighSurrogate(
                        ch)) {
                    char ch2 =
                      ncName.
                      charAt(
                        i);
                    if (!org.apache.xml.utils.XMLChar.
                          isLowSurrogate(
                            ch2) ||
                          !isXML11NCName(
                             org.apache.xml.utils.XMLChar.
                               supplemental(
                                 ch,
                                 ch2))) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            ++i;
        }
        return true;
    }
    public static boolean isXML11ValidNmtoken(java.lang.String nmtoken) {
        int length =
          nmtoken.
          length(
            );
        if (length ==
              0)
            return false;
        for (int i =
               0;
             i <
               length;
             ++i) {
            char ch =
              nmtoken.
              charAt(
                i);
            if (!isXML11Name(
                   ch)) {
                if (++i <
                      length &&
                      isXML11NameHighSurrogate(
                        ch)) {
                    char ch2 =
                      nmtoken.
                      charAt(
                        i);
                    if (!org.apache.xml.utils.XMLChar.
                          isLowSurrogate(
                            ch2) ||
                          !isXML11Name(
                             org.apache.xml.utils.XMLChar.
                               supplemental(
                                 ch,
                                 ch2))) {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isXML11ValidQName(java.lang.String str) {
        final int colon =
          str.
          indexOf(
            ':');
        if (colon ==
              0 ||
              colon ==
              str.
              length(
                ) -
              1) {
            return false;
        }
        if (colon >
              0) {
            final java.lang.String prefix =
              str.
              substring(
                0,
                colon);
            final java.lang.String localPart =
              str.
              substring(
                colon +
                  1);
            return isXML11ValidNCName(
                     prefix) &&
              isXML11ValidNCName(
                localPart);
        }
        else {
            return isXML11ValidNCName(
                     str);
        }
    }
    public XML11Char() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6qbWKc68puGkCzyM/0T/B4NvrHbuLgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IaWdlfF227sJStGldzVLYYs8+LAjWS+Tw2TgrrBJOKNgjVz4XUylqDI2a/eR" +
       "usc1udm8qa+rK7przvGAS1eKVlfTbr3erSal1rzX8cykIXBDkVz2l2vBKprz" +
       "cZ12lvJgOLRsYmCgNJ3AiSErnXYyKbfKZcaDHciNHK2oOVqs+KmKTsRidSbC" +
       "E6wKwZPJBIM1hJj1LLNdb6cc2p9a7fp40xx4RYYNE6ym+NSUKG6mlKF49b6J" +
       "uQsHjdD6bIMpzEZsrMaiajA1xCy1KRTxh4u5U5U6S4uhk/6A8ZEhFdQbNlLh" +
       "ZQPq1Kn2aBK0Kc72zGK8adPLcDJFBwFLDRCua40dcKfSag+iMCSnCVeHe/q8" +
       "OV/1LSyueeh8aDLLolHB17LAUWGxq6EGpsRhynSsjpLQzHxUqwmTlsdSTsjJ" +
       "jghJ3hKHzMlIk0irksxNbJMMVKFCcCOJ5xJi2euIaZHQl90WsqDU4WA8VL2o" +
       "wddHQ91n6fVSGbDjYl/mcXmAl2s1jnIXSy5pzUTT5slBp18hkbmmx5SCzITy" +
       "iF41XFttzDvDgHamnjqNBUo0a4rXj9YCQkxwQL/jTMcav5YRrtr2hkQvMty5" +
       "N4sXxqICBZA1pJb62rYlVjCqyMAbcJzd69c8sa/7SjBotFaDcQ3yR06d1CtG" +
       "XFM6CJIEEWP1lqO1MCYpvoVMO43aFFtOOjO+MV1bU54TW3YP5dk1pNjieIaM" +
       "qmFE9sZMFAU1pRaNjC7JhXalvdDbpXo0HiKdCPE7Cz4aSF6IJKsAHZKMbId9" +
       "n0Hr4tLwRmTfby3Glhku68gcC0ioPYCWjaVlGO4S46fEvMZOHJOKGzPfn7fp" +
       "ioYjMZFMhp2Yp6cUz7QDM1CH1lrwedWD+lMX57ROsVKZOPbIMPvkbFoeDFUF" +
       "WpQaDIJuQEBszVDB5UicnydKulaGbOSt9dqcrts1Ge9IPjqbwSt1aUxEcVG2" +
       "Ud9RPaTsamQ4Gg/7RGOOYrIVpBgdsiEV247jt7o9Q9r0rLCCszpfm6JEXUDl" +
       "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" +
       "iO+df/AGDhm9fQfnbpef5175TeYd6t85");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("V7jtcEP+mrOJJxtdObkNfz7QozhwxROb8Y8dSvaRTGLvANdn9iX7md2nyEdz" +
       "d40WnDvSgq0C7Bwn2dsevckfFucV/t0Z502+liVfiQr3mmH+zFnwD7bLd56B" +
       "3qV4nq3L7pE+ffWNnoAeHysv+PK1Avj8vgA+fysF8PUzBPDNLPn9IwGMZNvU" +
       "srJ/f8T0D26W6Y+A65f3mf7yrWT6x2cw/ZMs+a9R4f59pi13dQrX/3azXN8N" +
       "rl/f5/rrt5Lrd8/g+mdZ8npUePPxWWXNSA9ke4fw//xBTO5X9gl/5RYS3jt3" +
       "fcJ7+Qb1XxxNbn74e7uff4zrX94s12xb9Pf2uf7ereR6/xlcs23ivXuiwqOH" +
       "igzm1ZVt2o3MaHMq873zN8v8neD61j7zb91K5o+cwfzRLMn22/aZ82DFESI5" +
       "2GX74M2yfRZcr+2zfe1Wsn3HGWyzfvaejApvOsZ2h+hTN0v0XeD6832if34r" +
       "iRbPIFrKkndHhUsHRGvXm9jLN8v3hwGoO7Ztt9+3iu97z+CbnUDYq0aF+07w" +
       "3aH6126WahHgubRP9dKtpNo+g2q2Z79HR4WHj+lw0zTmQhwEniFHu6wbPwA/" +
       "tffEPusnbg3rL+TMRmewnmRJ/8hP5cvvKXM8+AGY795gn+3gVrJVzmCbhVB7" +
       "P3Zkvlu2p+n0B34AwdXeC/t8X7iVfN0z+GbD7Zk7wRXvRJ6luzuEFzdB+G0H" +
       "E/zSPuGXbiXh9AzCP5ElMfiffZxw/5T5fcODcSdOvIP/v4dv42SvEzx8zXt+" +
       "23fT1C++fOHuh14e/sfteeeD98fuYQt3z2LbPn76+1j+Tj/QZ2ZO/p7tWXA/" +
       "J/M3o8JbTnszKCrckX9nOPde2Nb9CAgoT9aNCreB9HidvxUVzh/ViQp3bjPH" +
       "q/wsaAWqZNmf83M5nDwztD38nmwPTj18XBsyqRYuvZFUjz2CePrEg4P8/cqD" +
       "P/nx9g3Lq+qXXm7zP/565XPb92RUW07TrJe72cJd21d28k6zBwVPXre3g77u" +
       "bD73vft/6Z5nDx5q3L8FfKSZx7C9/fQXUWjHj/JXR9Jffeifvucfvfz1/KTv" +
       "/wUL56XV+DoAAA==");
}
