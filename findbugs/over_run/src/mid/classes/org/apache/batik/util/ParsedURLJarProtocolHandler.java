package org.apache.batik.util;
public class ParsedURLJarProtocolHandler extends org.apache.batik.util.ParsedURLDefaultProtocolHandler {
    public static final java.lang.String JAR = "jar";
    public ParsedURLJarProtocolHandler() { super(JAR); }
    public org.apache.batik.util.ParsedURLData parseURL(org.apache.batik.util.ParsedURL baseURL,
                                                        java.lang.String urlStr) {
        java.lang.String start =
          urlStr.
          substring(
            0,
            JAR.
              length(
                ) +
              1).
          toLowerCase(
            );
        if (start.
              equals(
                JAR +
                ":"))
            return parseURL(
                     urlStr);
        try {
            java.net.URL context =
              new java.net.URL(
              baseURL.
                toString(
                  ));
            java.net.URL url =
              new java.net.URL(
              context,
              urlStr);
            return constructParsedURLData(
                     url);
        }
        catch (java.net.MalformedURLException mue) {
            return super.
              parseURL(
                baseURL,
                urlStr);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BSH4HB/OZzkFQ4E+Sv8Lq9ufpZIVAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ttwwP5BP//BNv/+O337xm/kZ2v8Ce8RsqXsgAAA=");
}
