package org.apache.batik.transcoder.wmf.tosvg;
public class WMFUtilities {
    public static java.lang.String decodeString(org.apache.batik.transcoder.wmf.tosvg.WMFFont wmfFont,
                                                byte[] bstr) { try {
                                                                   switch (wmfFont.
                                                                             charset) {
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_ANSI:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_ANSI);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_DEFAULT:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_DEFAULT);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_SHIFTJIS:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_SHIFTJIS);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_HANGUL:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_HANGUL);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_JOHAB:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_JOHAB);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_GB2312:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_GB2312);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_CHINESEBIG5:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_CHINESEBIG5);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_GREEK:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_GREEK);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_TURKISH:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_TURKISH);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_VIETNAMESE:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_VIETNAMESE);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_HEBREW:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_HEBREW);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_ARABIC:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_ARABIC);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_RUSSIAN:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_CYRILLIC);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_THAI:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_THAI);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_EASTEUROPE:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_EASTEUROPE);
                                                                       case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                              META_CHARSET_OEM:
                                                                           return new java.lang.String(
                                                                             bstr,
                                                                             org.apache.batik.transcoder.wmf.WMFConstants.
                                                                               CHARSET_OEM);
                                                                       default:
                                                                   }
                                                               }
                                                               catch (java.io.UnsupportedEncodingException e) {
                                                                   
                                                               }
                                                               return new java.lang.String(
                                                                 bstr);
    }
    public static int getHorizontalAlignment(int align) {
        int v =
          align;
        v =
          v %
            org.apache.batik.transcoder.wmf.WMFConstants.
              TA_BASELINE;
        v =
          v %
            org.apache.batik.transcoder.wmf.WMFConstants.
              TA_BOTTOM;
        if (v >=
              6)
            return org.apache.batik.transcoder.wmf.WMFConstants.
                     TA_CENTER;
        else
            if (v >=
                  2)
                return org.apache.batik.transcoder.wmf.WMFConstants.
                         TA_RIGHT;
            else
                return org.apache.batik.transcoder.wmf.WMFConstants.
                         TA_LEFT;
    }
    public static int getVerticalAlignment(int align) {
        int v =
          align;
        if (v /
              org.apache.batik.transcoder.wmf.WMFConstants.
                TA_BASELINE !=
              0)
            return org.apache.batik.transcoder.wmf.WMFConstants.
                     TA_BASELINE;
        v =
          v %
            org.apache.batik.transcoder.wmf.WMFConstants.
              TA_BASELINE;
        if (v /
              org.apache.batik.transcoder.wmf.WMFConstants.
                TA_BOTTOM !=
              0)
            return org.apache.batik.transcoder.wmf.WMFConstants.
                     TA_BOTTOM;
        else
            return org.apache.batik.transcoder.wmf.WMFConstants.
                     TA_TOP;
    }
    public WMFUtilities() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "OKxWpHbxZeQh/y7z3IOOjs9nt2ZKmtH05uHfR4dugiogrhSh2M2U5Ylq20uO" +
       "icV0CHOHtN5c88ls5B7L1LM6OrUAPuvN2r/+ljsKOvTk6CbGk+jxgzOSIk8h" +
       "Oj6ax5WH8rjyh3R4Gs49CUw6VF0apltVXipLCVbF6OyI7cCDt8eB8+ATNZcb" +
       "vW0OHE9ibgeylTFlo3ncc5QOz8H2Avf0wnFfEsd3zvO37pw05LDz+oceeKZm" +
       "XUrzi1Tx6EhV6ZSRdX/i5d667KyAriyekmUnXjmeizUdxyW2lgqOXhr7Ok5Q" +
       "y001orCp2TdbwUuc+WXo02/ADIAGo5PpFYKm5WEicILI/HDynYAt7eUDo9i3" +
       "k+41kGDTAdbyByfJ62AVkNDHN7QceMELRtqXfYpkAZ58owA7DolNrlLL/h1h" +
       "dQop/g8J6KJGVq7eeu3+Z/kFjigLw8NUygToD/g1UeYkNXtcaZas4o651ye+" +
       "WNZi9S2uCySnbSzvIP/ZZUu950bDaM5cbFw4vOTE27uLz0EF34B8AlSfDdml" +
       "Na2l4Ji3IZSrE4Liyi5bWss/2njmi/d8teyEjnjj0pCPIyLuP3ExHNe07/tR" +
       "WScqgrYMp1ndf2hIWYPFAd3VWBVH1ZSS6XYn0o0hUNxnnjEdWpl5S+/2CGrM" +
       "7h2z7zvLZXUQ68uodCqm0nP2TGmac5Z5NskRmXoaci0S6tI088qr9CrzvKax" +
       "nX+ewfN/ARTXja9zHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3w9ndx0PNYeWPR5oDo4C0M+gs/4NBxv+cHICOOJJdBffRbL3R3PE+/P2XNa8" +
       "eqv1rPtjwGPDPPUEGDPTka2czsMRsBhLPbfno2OQigIVn1tYeE7mZSD5zq0j" +
       "E2Z3m79tY1XWlrZc5H3sitZwfo9XsPs3HxBjXZAKvvMfnvjiLz/4HNiiNnRy" +
       "lakP7MyhFXtxlh3/wjNP3f2SJ7/xzjwAgejDv5s6+2hGtXM1ibOmkTXUnqh3" +
       "ZqIO8lOdlcOom8cJXculvapl8oFpg9C6upj6wY/d+tzyvd/8yDatO26Gx4D1" +
       "dzz5i9/fffzJnUPJ9IOX5LOHcbYJdc70TRc1HED3X22VHKP5jx977I9++7G3" +
       "b7m69WhqSIFvPh/5y//64u57vvH5y+QZ11ruD7Gx0c1fY8phi9j7644lHV2P" +
       "ksSecXiht+hXKWG9nlZb3KhYLLXJomjLaqOOMg26vU7o3gjlVgpaqVZZHQ9a" +
       "uFSp9ToE5dUH1NgdEQPUkFhl5Axahm72/LmHFEmzvUSEYZ9AZJNG3JFTGDQ7" +
       "ZJ2pIsPlSqm1Y6mkrRhHKAgjeuVVVhK6irRqaaPDeGWVYPXxSOJMd9TnRnad" +
       "MITERQmbwZi6hBDVmSx1qXUxZBWTXQAPLikJXBGikOPN1UpIGLyO1VtNAtdY" +
       "sVWWZqJJe/U5NaL6YdCdlvsLh+QW8po3CWEwnmAIPWxjwABDs9/xqLg3HQVC" +
       "p2DMx2RXcJerfrNLa55BkpIrT3ujpj2ckJ6FEcU56VHjfpzSuqc1aJTjRr4S" +
       "8SOp3hSZnrFsCIt6s91YTpfGZmBHSn9GoeN50kkHRqs8FDpKhY+6fWzdLUkz" +
       "ax5OJ/4Gg1d+AbYDa770CbdjN9leTzKEyohRyZTy47SUoqLaY2VDwTiSagdG" +
       "i5RdThS8xpQdtEizWLSjoTETxyK1tNDiAGXodrsTSZQ8r9fDWpHsUdRk6cvT" +
       "LtuV2m1hoBbQLj2e4h28J3dqqd4elit8aWFgI92fFWXCX3mCJQ+REdOjuq0O" +
       "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");
}
