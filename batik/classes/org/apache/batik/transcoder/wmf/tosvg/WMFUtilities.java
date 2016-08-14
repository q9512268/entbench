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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cf6KzYn/ACLzRUsYHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
