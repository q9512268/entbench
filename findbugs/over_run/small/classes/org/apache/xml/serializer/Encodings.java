package org.apache.xml.serializer;
public final class Encodings extends java.lang.Object {
    private static final java.lang.String ENCODINGS_FILE = org.apache.xml.serializer.SerializerBase.
                                                             PKG_PATH +
    "/Encodings.properties";
    static java.io.Writer getWriter(java.io.OutputStream output, java.lang.String encoding)
          throws java.io.UnsupportedEncodingException { for (int i =
                                                               0;
                                                             i <
                                                               _encodings.
                                                                 length;
                                                             ++i) {
                                                            if (_encodings[i].
                                                                  name.
                                                                  equalsIgnoreCase(
                                                                    encoding)) {
                                                                try {
                                                                    java.lang.String javaName =
                                                                      _encodings[i].
                                                                        javaName;
                                                                    java.io.OutputStreamWriter osw =
                                                                      new java.io.OutputStreamWriter(
                                                                      output,
                                                                      javaName);
                                                                    return osw;
                                                                }
                                                                catch (java.lang.IllegalArgumentException iae) {
                                                                    
                                                                }
                                                                catch (java.io.UnsupportedEncodingException usee) {
                                                                    
                                                                }
                                                            }
                                                        }
                                                        try {
                                                            return new java.io.OutputStreamWriter(
                                                              output,
                                                              encoding);
                                                        }
                                                        catch (java.lang.IllegalArgumentException iae) {
                                                            throw new java.io.UnsupportedEncodingException(
                                                              encoding);
                                                        }
    }
    static org.apache.xml.serializer.EncodingInfo getEncodingInfo(java.lang.String encoding) {
        org.apache.xml.serializer.EncodingInfo ei;
        java.lang.String normalizedEncoding =
          toUpperCaseFast(
            encoding);
        ei =
          (org.apache.xml.serializer.EncodingInfo)
            _encodingTableKeyJava.
            get(
              normalizedEncoding);
        if (ei ==
              null)
            ei =
              (org.apache.xml.serializer.EncodingInfo)
                _encodingTableKeyMime.
                get(
                  normalizedEncoding);
        if (ei ==
              null) {
            ei =
              new org.apache.xml.serializer.EncodingInfo(
                null,
                null,
                '\000');
        }
        return ei;
    }
    public static boolean isRecognizedEncoding(java.lang.String encoding) {
        org.apache.xml.serializer.EncodingInfo ei;
        java.lang.String normalizedEncoding =
          encoding.
          toUpperCase(
            );
        ei =
          (org.apache.xml.serializer.EncodingInfo)
            _encodingTableKeyJava.
            get(
              normalizedEncoding);
        if (ei ==
              null)
            ei =
              (org.apache.xml.serializer.EncodingInfo)
                _encodingTableKeyMime.
                get(
                  normalizedEncoding);
        if (ei !=
              null)
            return true;
        return false;
    }
    private static java.lang.String toUpperCaseFast(final java.lang.String s) {
        boolean different =
          false;
        final int mx =
          s.
          length(
            );
        char[] chars =
          new char[mx];
        for (int i =
               0;
             i <
               mx;
             i++) {
            char ch =
              s.
              charAt(
                i);
            if ('a' <=
                  ch &&
                  ch <=
                  'z') {
                ch =
                  (char)
                    (ch +
                       ('A' -
                          'a'));
                different =
                  true;
            }
            chars[i] =
              ch;
        }
        final java.lang.String upper;
        if (different)
            upper =
              java.lang.String.
                valueOf(
                  chars);
        else
            upper =
              s;
        return upper;
    }
    static final java.lang.String DEFAULT_MIME_ENCODING =
      "UTF-8";
    static java.lang.String getMimeEncoding(java.lang.String encoding) {
        if (null ==
              encoding) {
            try {
                encoding =
                  java.lang.System.
                    getProperty(
                      "file.encoding",
                      "UTF8");
                if (null !=
                      encoding) {
                    java.lang.String jencoding =
                      encoding.
                      equalsIgnoreCase(
                        "Cp1252") ||
                      encoding.
                      equalsIgnoreCase(
                        "ISO8859_1") ||
                      encoding.
                      equalsIgnoreCase(
                        "8859_1") ||
                      encoding.
                      equalsIgnoreCase(
                        "UTF8")
                      ? DEFAULT_MIME_ENCODING
                      : convertJava2MimeEncoding(
                          encoding);
                    encoding =
                      null !=
                        jencoding
                        ? jencoding
                        : DEFAULT_MIME_ENCODING;
                }
                else {
                    encoding =
                      DEFAULT_MIME_ENCODING;
                }
            }
            catch (java.lang.SecurityException se) {
                encoding =
                  DEFAULT_MIME_ENCODING;
            }
        }
        else {
            encoding =
              convertJava2MimeEncoding(
                encoding);
        }
        return encoding;
    }
    private static java.lang.String convertJava2MimeEncoding(java.lang.String encoding) {
        org.apache.xml.serializer.EncodingInfo enc =
          (org.apache.xml.serializer.EncodingInfo)
            _encodingTableKeyJava.
            get(
              toUpperCaseFast(
                encoding));
        if (null !=
              enc)
            return enc.
                     name;
        return encoding;
    }
    public static java.lang.String convertMime2JavaEncoding(java.lang.String encoding) {
        for (int i =
               0;
             i <
               _encodings.
                 length;
             ++i) {
            if (_encodings[i].
                  name.
                  equalsIgnoreCase(
                    encoding)) {
                return _encodings[i].
                         javaName;
            }
        }
        return encoding;
    }
    private static org.apache.xml.serializer.EncodingInfo[] loadEncodingInfo() {
        try {
            final java.io.InputStream is;
            is =
              org.apache.xml.serializer.SecuritySupport.
                getResourceAsStream(
                  org.apache.xml.serializer.ObjectFactory.
                    findClassLoader(
                      ),
                  ENCODINGS_FILE);
            java.util.Properties props =
              new java.util.Properties(
              );
            if (is !=
                  null) {
                props.
                  load(
                    is);
                is.
                  close(
                    );
            }
            else {
                
            }
            int totalEntries =
              props.
              size(
                );
            java.util.List encodingInfo_list =
              new java.util.ArrayList(
              );
            java.util.Enumeration keys =
              props.
              keys(
                );
            for (int i =
                   0;
                 i <
                   totalEntries;
                 ++i) {
                java.lang.String javaName =
                  (java.lang.String)
                    keys.
                    nextElement(
                      );
                java.lang.String val =
                  props.
                  getProperty(
                    javaName);
                int len =
                  lengthOfMimeNames(
                    val);
                java.lang.String mimeName;
                char highChar;
                if (len ==
                      0) {
                    mimeName =
                      javaName;
                    highChar =
                      '\000';
                }
                else {
                    try {
                        final java.lang.String highVal =
                          val.
                          substring(
                            len).
                          trim(
                            );
                        highChar =
                          (char)
                            java.lang.Integer.
                            decode(
                              highVal).
                            intValue(
                              );
                    }
                    catch (java.lang.NumberFormatException e) {
                        highChar =
                          0;
                    }
                    java.lang.String mimeNames =
                      val.
                      substring(
                        0,
                        len);
                    java.util.StringTokenizer st =
                      new java.util.StringTokenizer(
                      mimeNames,
                      ",");
                    for (boolean first =
                           true;
                         st.
                           hasMoreTokens(
                             );
                         first =
                           false) {
                        mimeName =
                          st.
                            nextToken(
                              );
                        org.apache.xml.serializer.EncodingInfo ei =
                          new org.apache.xml.serializer.EncodingInfo(
                          mimeName,
                          javaName,
                          highChar);
                        encodingInfo_list.
                          add(
                            ei);
                        _encodingTableKeyMime.
                          put(
                            mimeName.
                              toUpperCase(
                                ),
                            ei);
                        if (first)
                            _encodingTableKeyJava.
                              put(
                                javaName.
                                  toUpperCase(
                                    ),
                                ei);
                    }
                }
            }
            org.apache.xml.serializer.EncodingInfo[] ret_ei =
              new org.apache.xml.serializer.EncodingInfo[encodingInfo_list.
                                                           size(
                                                             )];
            encodingInfo_list.
              toArray(
                ret_ei);
            return ret_ei;
        }
        catch (java.net.MalformedURLException mue) {
            throw new org.apache.xml.serializer.utils.WrappedRuntimeException(
              mue);
        }
        catch (java.io.IOException ioe) {
            throw new org.apache.xml.serializer.utils.WrappedRuntimeException(
              ioe);
        }
    }
    private static int lengthOfMimeNames(java.lang.String val) {
        int len =
          val.
          indexOf(
            ' ');
        if (len <
              0)
            len =
              val.
                length(
                  );
        return len;
    }
    static boolean isHighUTF16Surrogate(char ch) {
        return '\ud800' <=
          ch &&
          ch <=
          '\udbff';
    }
    static boolean isLowUTF16Surrogate(char ch) {
        return '\udc00' <=
          ch &&
          ch <=
          '\udfff';
    }
    static int toCodePoint(char highSurrogate,
                           char lowSurrogate) {
        int codePoint =
          (highSurrogate -
             55296 <<
             10) +
          (lowSurrogate -
             56320) +
          65536;
        return codePoint;
    }
    static int toCodePoint(char ch) { int codePoint =
                                        ch;
                                      return codePoint;
    }
    public static char getHighChar(java.lang.String encoding) {
        final char highCodePoint;
        org.apache.xml.serializer.EncodingInfo ei;
        java.lang.String normalizedEncoding =
          toUpperCaseFast(
            encoding);
        ei =
          (org.apache.xml.serializer.EncodingInfo)
            _encodingTableKeyJava.
            get(
              normalizedEncoding);
        if (ei ==
              null)
            ei =
              (org.apache.xml.serializer.EncodingInfo)
                _encodingTableKeyMime.
                get(
                  normalizedEncoding);
        if (ei !=
              null)
            highCodePoint =
              ei.
                getHighChar(
                  );
        else
            highCodePoint =
              0;
        return highCodePoint;
    }
    private static final java.util.Hashtable
      _encodingTableKeyJava =
      new java.util.Hashtable(
      );
    private static final java.util.Hashtable
      _encodingTableKeyMime =
      new java.util.Hashtable(
      );
    private static final org.apache.xml.serializer.EncodingInfo[]
      _encodings =
      loadEncodingInfo(
        );
    public Encodings() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7Lo1bbAKXRffRqOhXs93alPtYehgEQc5");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("thgh9rivVGnfbeHVSW+arCVzt2WIdSIBP/emIVafrBohOxVhc6rU0F1qyU7X" +
       "7+Gc0u1ts3q6nM4zqY8a+tBuVx15w0UUkEQYSp4G7+SFFVJMHkk65bE1W8bB" +
       "Ihdw1QTFpA2cdI1BaiBr0fEMNDdG7XwaaLuUXhHAArwkVxNYEaXJjG3ZM6zO" +
       "jLd0sEBCQ2yM5YHGm7NZjUuFKqJZ9m6+aNZZZS23kS1ngcBqN9zqfQgsYiPU" +
       "gSGCgUKo6UDAEjTOyoENEwTxnvcUr99+7uZeCz5Yvu08Phv3l3jPmb/6VsTZ" +
       "Yyj3Vc4dszq1VXJqq75S7Aq8+UYn4codgc995NnnDOFnkaONwA8nlXuSIHyX" +
       "a25M91RT+73qjx+LURz0qnw/uIhDMYjrbZY9cH1gB6US9/o79/b63I7C8a6B" +
       "kCZhmoySyNS8Ur1l7S+fq316twfUfuqotuLHaRgGUWIaR7tEVK6bYbFZUDb0" +
       "K0XyJYB9aSaTyE7M6KiN+4/aOJVdGvSXXu1V7umX8ee090iR+QPgig61F313" +
       "tHdwUmCvoH9/webAi0Xy75LKZYD59N5ZkZ2c4PzqLeB89MhBP36I8+M3gfPE" +
       "/b9DsP/5ArC/VyS/DRzKjiVTD5a+vTvxheu9vb9rHoDwT/NPFPE7t6qIp8H1" +
       "04eK+OmbVUTnJhTxRxco4htF8j+A1ZNACUMzIrXY7Gr7A1m9E7D/8xbAltzw" +
       "OLhePAT74vfIu791Ac4/LZJX9t5dbPYf2foczv99q0ZFgUT37+vuv79HRj24" +
       "dGOwB7cXmX+WVB7RA39jRklx4AS9APWf3wLq8gADAkR78hD1k9/DMX1w/wWo" +
       "HyiSe05QF4DRAvr1UR/cewuonziy9Q1PKNyCrU+DevSCZ28qkuLMVnGY7zxl" +
       "n0xNB6+/BaBvKDLfAQD+xCHQn/heOvXbL0BbuMnB4yC+2h+/EBaFfXnt8NzO" +
       "j57AfeIW4JYnT8BMfPAzh3B/5ibgvjpXXW9muV23tKhEiF6AvggiD95VTlg9" +
       "e2kpchdpjNIoCpZaUm78v3SigCu3qoC3A1E/f6iAz39XFVCIh5WAiAvAkkXy" +
       "7qTysB1zQXYh1vfcAtbLRSZg7YMvHWL90ncH66Vj5z/ATgAPLgAsFEkvqbwm" +
       "CcjAMIfB4eGaU17NfDeAfuUQ6Fe+R0ZVL8D4w0UiX4jxVY8GvhpRFcf1fvcQ" +
       "4+/eBMabnofMC4AW88zB+wFQEGoUY5UE47tU0QlQ7WaA5mAdchyaFkfZH7nm" +
       "L2f7v0npX3ju8t1veE75nf1hvKO/Mt3DVe5epK57+uTxqfs7w8hc2CXse/bn" +
       "kMMShp9U3njD03VJ5d6TH4XEB96+1hoskc7WSiq3gfR0mQTUPimTVO7c35wu" +
       "koFaoEhxm+9PNJ09m7w/gp3vCfWR0x5RBjQPvZp+Ty2InzxzwKz809/RYbB0" +
       "eHgQ94vPsfwHXmn87P7fGrqr7XZFK3dzlbv2fxwpGy0OlD1+w9aO2rqz9/S3" +
       "7/+Fe952tMS+fy/wiXeeku2x6/8dgvLCpPwDw+5Lb/jn7/4nz/1+eZTp/wNE" +
       "2UfyjTkAAA==");
}
