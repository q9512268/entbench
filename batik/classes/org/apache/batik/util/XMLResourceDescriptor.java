package org.apache.batik.util;
public class XMLResourceDescriptor {
    public static final java.lang.String XML_PARSER_CLASS_NAME_KEY = "org.xml.sax.driver";
    public static final java.lang.String CSS_PARSER_CLASS_NAME_KEY = "org.w3c.css.sac.driver";
    public static final java.lang.String RESOURCES = "resources/XMLResourceDescriptor.properties";
    protected static java.util.Properties parserProps = null;
    protected static java.lang.String xmlParserClassName;
    protected static java.lang.String cssParserClassName;
    protected static synchronized java.util.Properties getParserProps() {
        if (parserProps !=
              null)
            return parserProps;
        parserProps =
          new java.util.Properties(
            );
        try {
            java.lang.Class cls =
              org.apache.batik.util.XMLResourceDescriptor.class;
            java.io.InputStream is =
              cls.
              getResourceAsStream(
                RESOURCES);
            parserProps.
              load(
                is);
        }
        catch (java.io.IOException ioe) {
            throw new java.util.MissingResourceException(
              ioe.
                getMessage(
                  ),
              RESOURCES,
              null);
        }
        return parserProps;
    }
    public static java.lang.String getXMLParserClassName() { if (xmlParserClassName ==
                                                                   null) {
                                                                 xmlParserClassName =
                                                                   getParserProps(
                                                                     ).
                                                                     getProperty(
                                                                       XML_PARSER_CLASS_NAME_KEY);
                                                             }
                                                             return xmlParserClassName;
    }
    public static void setXMLParserClassName(java.lang.String xmlParserClassName) {
        org.apache.batik.util.XMLResourceDescriptor.
          xmlParserClassName =
          xmlParserClassName;
    }
    public static java.lang.String getCSSParserClassName() {
        if (cssParserClassName ==
              null) {
            cssParserClassName =
              getParserProps(
                ).
                getProperty(
                  CSS_PARSER_CLASS_NAME_KEY);
        }
        return cssParserClassName;
    }
    public static void setCSSParserClassName(java.lang.String cssParserClassName) {
        org.apache.batik.util.XMLResourceDescriptor.
          cssParserClassName =
          cssParserClassName;
    }
    public XMLResourceDescriptor() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "yLPQ7HXCloeHyU32Shvv/wHwwZOStB8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "a0SdhdGtNhvkruskEjMeqspYdoSp6YnMtFsNFv3+ajKc53izPXL7gzY5kFgN" +
       "HfZk1yWniup4GO7o4lAlE74DpnKJmY9i0u2IkTDZ+q2MRgG92EynM9vke9ON" +
       "TEShtbR5es4LZo/NiTYP+61KxPVg2zBqPXzM1/1W4o/5tYIPyKVCjrE8s+mR" +
       "1tkSmDtm89UKRB6NmlLfbJTJqj5vSbyrDXKXs5N8LJPa2CUiVzOm/QmrUKqv" +
       "dDSxs970RgxSb0WeaQiT1rBB4Sg5rItoc2K0GQYx1KSqGrNOXoRU7eEyqfUH" +
       "m6WfaPDcbQl+l7XtzqTSbtR6TcmxWcaIwpZRGWg7HelJfWuVKZQXt40kW1Qc" +
       "eh47ZjSntrP1MtQxjHHRxJARyu+kkgMsqAOjrkwF5LSNt4g+JttSoM3h+rJZ" +
       "x+ydQqsx4pqDZlsMTDlUaialOCa1qIybU3ZLEBTam1CkWl2ISC9JM1zRuqLv" +
       "cNLMQwngiiTFXnsdWVjgux4er0Wvgwn5NJ8PmVHYJIl2StAkzM/XddLTHbPK" +
       "M2DWVjKkjoiLXlWtDtZVvu3VYLqDjONOaqzEHpMRdbjdEbpds9tpu5WFLeLL" +
       "GfDBLN8mIrvqbRHTV8mVu6rPeKmlIepmolfgMTf3p/O60s1NfYbUx6P+BK5o" +
       "KD6Jd8O6W6ddOILd/jyIF/0x0l43+8ygOWvU80q35u2s9sonGimbJIvFWtut" +
       "rESZNTcqslopJgKixmakJFNF02xUItZ634YnfQozxh0h9tlkvOnnFUz20yzB" +
       "qXAT0Q5j8mLbqDczchLARtcj9YhU/Y6g9meUstsudq5bFdsjxKIGq3Cx7NS0" +
       "aUyyoyWsjWJ8tmvx69EujlnAlWpGSUc0hznwdm6/o3T0rZl4Ib6QuVFsJCHK" +
       "N9FGVCXpphxu66i4qKl0puo9KnAHwmAxEhm/kah1I0LQaCcJsNdRFU4esAJM" +
       "inanqfFxhdlWW7OGRw8HOyHGYWQaJznHLTyXp1pkeztQ+Ea7OtjW29O40jH4" +
       "qlihp9G2UWvPOF/Vd33a2SDe2u+uFQ/v0G530IQ33lCsVaT6mK31Fy3MZ4e8" +
       "KAXybNHfrNyWxC64UZY0JWI8tVxS43cVaTmuaiu2vgMm5K70Dtdpk83EZdVR" +
       "mrVgqdWmM52Yk5VVzHGtFj/c7nR2ZHe7WuiEnaSOOvBwRki1NYtyul1fDvKs" +
       "IXaW2XA02NiBNxh5nZEVCVWng9FWX80yOl/1KyskbjEjvj4YkkuvN60EcrLz" +
       "1q0eVnNiDcF3VbPlVQYbvYs101F9xac9dw6rYVjHhE29NcYauQNHw15nIqKo" +
       "3eXmGydZGLkEe4JU2Ul23N5WmvN6qIiaziosq1WczWJjp1N4YUr8NKsvqxyX" +
       "dpUOvMs7C150JZfuKYHPT7AVjIGot7Gbus1gYYghUmmz+tyJtnYwHwyVVRzU" +
       "pB2OVhU7QV2tuYoTtrYVHKQ1X29qbbimggktxfx5kxhQ5FquRTmzpoW5MR7m" +
       "csfYMEhNn3ftmjTYrtjKOCQ6wH4MFRGlaYPQd1GdA/OiRmdmt9GqDrBqLiWu" +
       "SuPWhMiVZV+JZODgdCsft4yxP1vTmCCifIJbWJ0SabyxqdINsu1beNWZyO6E" +
       "7nAu0WXVGljKVtyYreKxK9lmp9WqLIjVIGKa5FRYR2vCGHbltWi3gtpgLlqT" +
       "eKTgrVzrEsPxrj3pUptm1098r4JEDPC3u7GSZ1HeyXCfC/B4WllK3RrCsdJi" +
       "rlFd3PLn3ZHgdHBxyG+4CtVp9rWqlzPcpD1YYCAqH+SzOiKY2y2cDtJ0ORbi" +
       "Xgcsij/wgWK5/LcfbMfiqXIj5uRo/i+wBbMverFI3neyfVX+rkL3PvI6cywA" +
       "FbsPz9/rxL3cefj8x197XR1/oXZwdJzyiRi6FvvBDzvaVnPONFXcLnn/vXdZ" +
       "2PLCwek2/298/L89N/2g+dEHOMh8zwU+Lzb5j9kv/Rb5/crPHEAPnWz633UV" +
       "4nyl2+e3+h8PtTgJvem5Df/nTyRb7n/fBg9+JFn84sbg6dhdrgX7XcEYeiLK" +
       "PcUMfc/aaepeH+5zgvUP7lP2hSL5XAw9aWgxd7p/W+SuTpXo9Tfb7jnbbJnx" +
       "909Qv6vILI4APnyE+sMPgPrgVPffFOaX71P2S0XyxRh6GsBcsMxle6mnaP/J" +
       "/wfam0UmCR7rCK31XUR7ZX+EW7JbEvzqfSB/pUj+OYAcXQa5rPLxMw7iJ2Po" +
       "4a1vqadi+JXvxqCnR2JIv0eD/m/vU/bVIvm1/aBjgnD/Qf/178ag/8QR2p/4" +
       "Xg76790H8u8Xydf2g3455H91Cvl3HgRyBhq99FyrOHZ/9q6rcfvrXMovvH79" +
       "sXe+Pvv35cWNkytX1xjoMT1xnLOnpGferwahplslnmv7M9Og/PsGYOHS6zRA" +
       "dYu/kuev72n/MIZuXKSNoUfK/7N0/yWGHj+li6Gr+5ezJN+MoYcASfH6R8Hx" +
       "wdaZc4j9QXF25fy8eCLlm28m5TNT6cvnJsDyWuLxZJXsLybeUb78+nD0sW+3" +
       "vrC/U6I48m5XtPIYAz26v95yMuG9eM/Wjtu6OnjlO0/+4rX3HU/OT+4ZPtXW" +
       "M7y95/JLG7gbxOU1i92/eOc/+5F/+PrXy4OY/weGaaTkLyoAAA==");
}
