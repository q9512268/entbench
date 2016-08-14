package org.apache.batik.xml;
public class XMLUtilities extends org.apache.batik.xml.XMLCharacters {
    protected XMLUtilities() { super(); }
    public static boolean isXMLSpace(char c) { return c <= 32 && ((1L << 9 |
                                                                     1L <<
                                                                     10 |
                                                                     1L <<
                                                                     13 |
                                                                     1L <<
                                                                     32) >>
                                                                    c &
                                                                    1L) !=
                                                 0; }
    public static boolean isXMLNameFirstCharacter(char c) { return (NAME_FIRST_CHARACTER[c /
                                                                                           32] &
                                                                      1 <<
                                                                      c %
                                                                      32) !=
                                                              0;
    }
    public static boolean isXML11NameFirstCharacter(char c) {
        return (NAME11_FIRST_CHARACTER[c /
                                         32] &
                  1 <<
                  c %
                  32) !=
          0;
    }
    public static boolean isXMLNameCharacter(char c) { return (NAME_CHARACTER[c /
                                                                                32] &
                                                                 1 <<
                                                                 c %
                                                                 32) !=
                                                         0;
    }
    public static boolean isXML11NameCharacter(char c) {
        return (NAME11_CHARACTER[c /
                                   32] &
                  1 <<
                  c %
                  32) !=
          0;
    }
    public static boolean isXMLCharacter(int c) {
        return (XML_CHARACTER[c >>>
                                5] &
                  1 <<
                  (c &
                     31)) !=
          0 ||
          c >=
          65536 &&
          c <=
          1114111;
    }
    public static boolean isXML11Character(int c) {
        return c >=
          1 &&
          c <=
          55295 ||
          c >=
          57344 &&
          c <=
          65533 ||
          c >=
          65536 &&
          c <=
          1114111;
    }
    public static boolean isXMLPublicIdCharacter(char c) {
        return c <
          128 &&
          (PUBLIC_ID_CHARACTER[c /
                                 32] &
             1 <<
             c %
             32) !=
          0;
    }
    public static boolean isXMLVersionCharacter(char c) {
        return c <
          128 &&
          (VERSION_CHARACTER[c /
                               32] &
             1 <<
             c %
             32) !=
          0;
    }
    public static boolean isXMLAlphabeticCharacter(char c) {
        return c <
          128 &&
          (ALPHABETIC_CHARACTER[c /
                                  32] &
             1 <<
             c %
             32) !=
          0;
    }
    public static java.io.Reader createXMLDocumentReader(java.io.InputStream is)
          throws java.io.IOException { java.io.PushbackInputStream pbis =
                                         new java.io.PushbackInputStream(
                                         is,
                                         128);
                                       byte[] buf =
                                         new byte[4];
                                       int len =
                                         pbis.
                                         read(
                                           buf);
                                       if (len >
                                             0) {
                                           pbis.
                                             unread(
                                               buf,
                                               0,
                                               len);
                                       }
                                       if (len ==
                                             4) {
                                           switch (buf[0] &
                                                     255) {
                                               case 0:
                                                   if (buf[1] ==
                                                         60 &&
                                                         buf[2] ==
                                                         0 &&
                                                         buf[3] ==
                                                         63) {
                                                       return new java.io.InputStreamReader(
                                                         pbis,
                                                         "UnicodeBig");
                                                   }
                                                   break;
                                               case '<':
                                                   switch (buf[1] &
                                                             255) {
                                                       case 0:
                                                           if (buf[2] ==
                                                                 63 &&
                                                                 buf[3] ==
                                                                 0) {
                                                               return new java.io.InputStreamReader(
                                                                 pbis,
                                                                 "UnicodeLittle");
                                                           }
                                                           break;
                                                       case '?':
                                                           if (buf[2] ==
                                                                 'x' &&
                                                                 buf[3] ==
                                                                 'm') {
                                                               java.io.Reader r =
                                                                 createXMLDeclarationReader(
                                                                   pbis,
                                                                   "UTF8");
                                                               java.lang.String enc =
                                                                 getXMLDeclarationEncoding(
                                                                   r,
                                                                   "UTF8");
                                                               return new java.io.InputStreamReader(
                                                                 pbis,
                                                                 enc);
                                                           }
                                                   }
                                                   break;
                                               case 76:
                                                   if (buf[1] ==
                                                         111 &&
                                                         (buf[2] &
                                                            255) ==
                                                         167 &&
                                                         (buf[3] &
                                                            255) ==
                                                         148) {
                                                       java.io.Reader r =
                                                         createXMLDeclarationReader(
                                                           pbis,
                                                           "CP037");
                                                       java.lang.String enc =
                                                         getXMLDeclarationEncoding(
                                                           r,
                                                           "CP037");
                                                       return new java.io.InputStreamReader(
                                                         pbis,
                                                         enc);
                                                   }
                                                   break;
                                               case 254:
                                                   if ((buf[1] &
                                                          255) ==
                                                         255) {
                                                       return new java.io.InputStreamReader(
                                                         pbis,
                                                         "Unicode");
                                                   }
                                                   break;
                                               case 255:
                                                   if ((buf[1] &
                                                          255) ==
                                                         254) {
                                                       return new java.io.InputStreamReader(
                                                         pbis,
                                                         "Unicode");
                                                   }
                                           }
                                       }
                                       return new java.io.InputStreamReader(
                                         pbis,
                                         "UTF8");
    }
    protected static java.io.Reader createXMLDeclarationReader(java.io.PushbackInputStream pbis,
                                                               java.lang.String enc)
          throws java.io.IOException { byte[] buf =
                                         new byte[128];
                                       int len =
                                         pbis.
                                         read(
                                           buf);
                                       if (len >
                                             0) {
                                           pbis.
                                             unread(
                                               buf,
                                               0,
                                               len);
                                       }
                                       return new java.io.InputStreamReader(
                                         new java.io.ByteArrayInputStream(
                                           buf,
                                           4,
                                           len),
                                         enc);
    }
    protected static java.lang.String getXMLDeclarationEncoding(java.io.Reader r,
                                                                java.lang.String e)
          throws java.io.IOException { int c;
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'l') {
                                           return e;
                                       }
                                       if (!isXMLSpace(
                                              (char)
                                                (c =
                                                   r.
                                                     read(
                                                       )))) {
                                           return e;
                                       }
                                       while (isXMLSpace(
                                                (char)
                                                  (c =
                                                     r.
                                                       read(
                                                         ))))
                                           ;
                                       if (c !=
                                             'v') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'e') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'r') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             's') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'i') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'o') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'n') {
                                           return e;
                                       }
                                       c =
                                         r.
                                           read(
                                             );
                                       while (isXMLSpace(
                                                (char)
                                                  c)) {
                                           c =
                                             r.
                                               read(
                                                 );
                                       }
                                       if (c !=
                                             '=') {
                                           return e;
                                       }
                                       while (isXMLSpace(
                                                (char)
                                                  (c =
                                                     r.
                                                       read(
                                                         ))))
                                           ;
                                       if (c !=
                                             '\"' &&
                                             c !=
                                             '\'') {
                                           return e;
                                       }
                                       char sc =
                                         (char)
                                           c;
                                       for (;
                                            ;
                                            ) {
                                           c =
                                             r.
                                               read(
                                                 );
                                           if (c ==
                                                 sc) {
                                               break;
                                           }
                                           if (!isXMLVersionCharacter(
                                                  (char)
                                                    c)) {
                                               return e;
                                           }
                                       }
                                       if (!isXMLSpace(
                                              (char)
                                                (c =
                                                   r.
                                                     read(
                                                       )))) {
                                           return e;
                                       }
                                       while (isXMLSpace(
                                                (char)
                                                  (c =
                                                     r.
                                                       read(
                                                         ))))
                                           ;
                                       if (c !=
                                             'e') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'n') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'c') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'o') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'd') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'i') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'n') {
                                           return e;
                                       }
                                       if ((c =
                                              r.
                                                read(
                                                  )) !=
                                             'g') {
                                           return e;
                                       }
                                       c =
                                         r.
                                           read(
                                             );
                                       while (isXMLSpace(
                                                (char)
                                                  c)) {
                                           c =
                                             r.
                                               read(
                                                 );
                                       }
                                       if (c !=
                                             '=') {
                                           return e;
                                       }
                                       while (isXMLSpace(
                                                (char)
                                                  (c =
                                                     r.
                                                       read(
                                                         ))))
                                           ;
                                       if (c !=
                                             '\"' &&
                                             c !=
                                             '\'') {
                                           return e;
                                       }
                                       sc =
                                         (char)
                                           c;
                                       java.lang.StringBuffer enc =
                                         new java.lang.StringBuffer(
                                         );
                                       for (;
                                            ;
                                            ) {
                                           c =
                                             r.
                                               read(
                                                 );
                                           if (c ==
                                                 -1) {
                                               return e;
                                           }
                                           if (c ==
                                                 sc) {
                                               return encodingToJavaEncoding(
                                                        enc.
                                                          toString(
                                                            ),
                                                        e);
                                           }
                                           enc.
                                             append(
                                               (char)
                                                 c);
                                       } }
    public static java.lang.String encodingToJavaEncoding(java.lang.String e,
                                                          java.lang.String de) {
        java.lang.String result =
          org.apache.batik.util.EncodingUtilities.
          javaEncoding(
            e);
        return result ==
          null
          ? de
          : result;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVae2wUxxmfO+MnfgeDeZmXoYXAHSQhbWSaxBg7GM7g2oAS" +
       "QzB7e3O+xXu7m905c0ChebSCtCqilLyqhvYPEGkVQtQm6jMRUaSEKGkqUpQ0" +
       "bSFVE6lp0qihldJWaZN+38zu7d769lwq30k7tzfzzTfz/b7XPO7xD0i5ZZI2" +
       "qrEI22tQK9KtsX7JtGiiS5UsawvUDcsPlUl/3/nuppvCpGKI1Kckq0+WLNqj" +
       "UDVhDZG5imYxSZOptYnSBPboN6lFzTGJKbo2RFoUqzdtqIqssD49QZFgm2TG" +
       "SJPEmKnEM4z22gwYmRuDmUT5TKKd/uaOGKmVdWOvS97qIe/ytCBl2h3LYqQx" +
       "tlsak6IZpqjRmGKxjqxJrjV0de+IqrMIzbLIbnW1DcGG2OpxECx8suGjj4+m" +
       "GjkE10iapjMunjVALV0do4kYaXBru1Watu4iB0lZjEz1EDPSHnMGjcKgURjU" +
       "kdalgtnXUS2T7tK5OMzhVGHIOCFGFuQzMSRTStts+vmcgUMVs2XnnUHa+Tlp" +
       "hZTjRHzg2ujxh3Y2/rCMNAyRBkUbxOnIMAkGgwwBoDQdp6bVmUjQxBBp0kDZ" +
       "g9RUJFXZZ2u62VJGNIllQP0OLFiZMajJx3SxAj2CbGZGZrqZEy/JDcr+VZ5U" +
       "pRGQdborq5CwB+tBwBoFJmYmJbA7u8uUUUVLMDLP3yMnY/tGIICulWnKUnpu" +
       "qCmaBBWkWZiIKmkj0UEwPW0ESMt1MECTkVmBTBFrQ5JHpRE6jBbpo+sXTUBV" +
       "zYHALoy0+Mk4J9DSLJ+WPPr5YNOaI/u19VqYhGDOCSqrOP+p0KnN12mAJqlJ" +
       "wQ9Ex9plsQel6c8cDhMCxC0+YkHz4y9duXV527nzgmZ2AZrN8d1UZsPyyXj9" +
       "hTldS28qw2lUGbqloPLzJOde1m+3dGQNiDDTcxyxMeI0nht44Y67f0DfD5Oa" +
       "XlIh62omDXbUJOtpQ1GpeRvVqCkxmugl1VRLdPH2XlIJ7zFFo6J2czJpUdZL" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Q87IuC8AAA==");
}
