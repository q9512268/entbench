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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "d6OmJh4bAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6iYAAA==");
}
