package org.apache.batik.util;
public class ParsedURLDefaultProtocolHandler extends org.apache.batik.util.AbstractParsedURLProtocolHandler {
    public ParsedURLDefaultProtocolHandler() { super(null); }
    protected ParsedURLDefaultProtocolHandler(java.lang.String protocol) {
        super(
          protocol);
    }
    protected org.apache.batik.util.ParsedURLData constructParsedURLData() {
        return new org.apache.batik.util.ParsedURLData(
          );
    }
    protected org.apache.batik.util.ParsedURLData constructParsedURLData(java.net.URL url) {
        return new org.apache.batik.util.ParsedURLData(
          url);
    }
    public org.apache.batik.util.ParsedURLData parseURL(java.lang.String urlStr) {
        try {
            java.net.URL url =
              new java.net.URL(
              urlStr);
            return constructParsedURLData(
                     url);
        }
        catch (java.net.MalformedURLException mue) {
            
        }
        org.apache.batik.util.ParsedURLData ret =
          constructParsedURLData(
            );
        if (urlStr ==
              null)
            return ret;
        int pidx =
          0;
        int idx;
        int len =
          urlStr.
          length(
            );
        idx =
          urlStr.
            indexOf(
              '#');
        ret.
          ref =
          null;
        if (idx !=
              -1) {
            if (idx +
                  1 <
                  len)
                ret.
                  ref =
                  urlStr.
                    substring(
                      idx +
                        1);
            urlStr =
              urlStr.
                substring(
                  0,
                  idx);
            len =
              urlStr.
                length(
                  );
        }
        if (len ==
              0)
            return ret;
        idx =
          0;
        char ch =
          urlStr.
          charAt(
            idx);
        while (ch ==
                 '-' ||
                 ch ==
                 '+' ||
                 ch ==
                 '.' ||
                 ch >=
                 'a' &&
                 ch <=
                 'z' ||
                 ch >=
                 'A' &&
                 ch <=
                 'Z') {
            idx++;
            if (idx ==
                  len) {
                ch =
                  0;
                break;
            }
            ch =
              urlStr.
                charAt(
                  idx);
        }
        if (ch ==
              ':') {
            ret.
              protocol =
              urlStr.
                substring(
                  pidx,
                  idx).
                toLowerCase(
                  );
            pidx =
              idx +
                1;
        }
        idx =
          urlStr.
            indexOf(
              '/');
        if (idx ==
              -1 ||
              pidx +
              2 <
              len &&
              urlStr.
              charAt(
                pidx) ==
              '/' &&
              urlStr.
              charAt(
                pidx +
                  1) ==
              '/') {
            if (idx !=
                  -1)
                pidx +=
                  2;
            idx =
              urlStr.
                indexOf(
                  '/',
                  pidx);
            java.lang.String hostPort;
            if (idx ==
                  -1)
                hostPort =
                  urlStr.
                    substring(
                      pidx);
            else
                hostPort =
                  urlStr.
                    substring(
                      pidx,
                      idx);
            int hidx =
              idx;
            idx =
              hostPort.
                indexOf(
                  ':');
            ret.
              port =
              -1;
            if (idx ==
                  -1) {
                if (hostPort.
                      length(
                        ) ==
                      0)
                    ret.
                      host =
                      null;
                else
                    ret.
                      host =
                      hostPort;
            }
            else {
                if (idx ==
                      0)
                    ret.
                      host =
                      null;
                else
                    ret.
                      host =
                      hostPort.
                        substring(
                          0,
                          idx);
                if (idx +
                      1 <
                      hostPort.
                      length(
                        )) {
                    java.lang.String portStr =
                      hostPort.
                      substring(
                        idx +
                          1);
                    try {
                        ret.
                          port =
                          java.lang.Integer.
                            parseInt(
                              portStr);
                    }
                    catch (java.lang.NumberFormatException nfe) {
                        
                    }
                }
            }
            if ((ret.
                   host ==
                   null ||
                   ret.
                     host.
                   indexOf(
                     '.') ==
                   -1) &&
                  ret.
                    port ==
                  -1)
                ret.
                  host =
                  null;
            else
                pidx =
                  hidx;
        }
        if (pidx ==
              -1 ||
              pidx >=
              len)
            return ret;
        ret.
          path =
          urlStr.
            substring(
              pidx);
        return ret;
    }
    public static java.lang.String unescapeStr(java.lang.String str) {
        int idx =
          str.
          indexOf(
            '%');
        if (idx ==
              -1)
            return str;
        int prev =
          0;
        java.lang.StringBuffer ret =
          new java.lang.StringBuffer(
          );
        while (idx !=
                 -1) {
            if (idx !=
                  prev)
                ret.
                  append(
                    str.
                      substring(
                        prev,
                        idx));
            if (idx +
                  2 >=
                  str.
                  length(
                    ))
                break;
            prev =
              idx +
                3;
            idx =
              str.
                indexOf(
                  '%',
                  prev);
            int ch1 =
              charToHex(
                str.
                  charAt(
                    idx +
                      1));
            int ch2 =
              charToHex(
                str.
                  charAt(
                    idx +
                      1));
            if (ch1 ==
                  -1 ||
                  ch2 ==
                  -1)
                continue;
            ret.
              append(
                (char)
                  (ch1 <<
                     4 |
                     ch2));
        }
        return ret.
          toString(
            );
    }
    public static int charToHex(int ch) { switch (ch) { case '0':
                                                        case '1':
                                                        case '2':
                                                        case '3':
                                                        case '4':
                                                        case '5':
                                                        case '6':
                                                        case '7':
                                                        case '8':
                                                        case '9':
                                                            return ch -
                                                              '0';
                                                        case 'a':
                                                        case 'A':
                                                            return 10;
                                                        case 'b':
                                                        case 'B':
                                                            return 11;
                                                        case 'c':
                                                        case 'C':
                                                            return 12;
                                                        case 'd':
                                                        case 'D':
                                                            return 13;
                                                        case 'e':
                                                        case 'E':
                                                            return 14;
                                                        case 'f':
                                                        case 'F':
                                                            return 15;
                                                        default:
                                                            return -1;
                                          } }
    public org.apache.batik.util.ParsedURLData parseURL(org.apache.batik.util.ParsedURL baseURL,
                                                        java.lang.String urlStr) {
        if (urlStr.
              length(
                ) ==
              0)
            return baseURL.
                     data;
        int idx =
          0;
        int len =
          urlStr.
          length(
            );
        if (len ==
              0)
            return baseURL.
                     data;
        char ch =
          urlStr.
          charAt(
            idx);
        while (ch ==
                 '-' ||
                 ch ==
                 '+' ||
                 ch ==
                 '.' ||
                 ch >=
                 'a' &&
                 ch <=
                 'z' ||
                 ch >=
                 'A' &&
                 ch <=
                 'Z') {
            idx++;
            if (idx ==
                  len) {
                ch =
                  0;
                break;
            }
            ch =
              urlStr.
                charAt(
                  idx);
        }
        java.lang.String protocol =
          null;
        if (ch ==
              ':') {
            protocol =
              urlStr.
                substring(
                  0,
                  idx).
                toLowerCase(
                  );
        }
        if (protocol !=
              null) {
            if (!protocol.
                  equals(
                    baseURL.
                      getProtocol(
                        )))
                return parseURL(
                         urlStr);
            idx++;
            if (idx ==
                  urlStr.
                  length(
                    ))
                return parseURL(
                         urlStr);
            if (urlStr.
                  charAt(
                    idx) ==
                  '/')
                return parseURL(
                         urlStr);
            urlStr =
              urlStr.
                substring(
                  idx);
        }
        if (urlStr.
              startsWith(
                "/")) {
            if (urlStr.
                  length(
                    ) >
                  1 &&
                  urlStr.
                  charAt(
                    1) ==
                  '/') {
                return parseURL(
                         baseURL.
                           getProtocol(
                             ) +
                         ":" +
                         urlStr);
            }
            return parseURL(
                     baseURL.
                       getPortStr(
                         ) +
                     urlStr);
        }
        if (urlStr.
              startsWith(
                "#")) {
            java.lang.String base =
              baseURL.
              getPortStr(
                );
            if (baseURL.
                  getPath(
                    ) !=
                  null)
                base +=
                  baseURL.
                    getPath(
                      );
            return parseURL(
                     base +
                     urlStr);
        }
        java.lang.String path =
          baseURL.
          getPath(
            );
        if (path ==
              null)
            path =
              "";
        idx =
          path.
            lastIndexOf(
              '/');
        if (idx ==
              -1)
            path =
              "";
        else
            path =
              path.
                substring(
                  0,
                  idx +
                    1);
        return parseURL(
                 baseURL.
                   getPortStr(
                     ) +
                 path +
                 urlStr);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "aTH79+IVmz/8FyhhVq4dHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AAA=");
}
