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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "DZn/C3KNHcCQLwAA");
}
