package edu.umd.cs.findbugs.filter;
public class SignatureUtil {
    public static java.lang.String createMethodSignature(java.lang.String params,
                                                         java.lang.String returns) {
        if (params ==
              null &&
              returns ==
              null) {
            return null;
        }
        java.lang.String pString;
        java.lang.String rString;
        if (params ==
              null) {
            pString =
              ".*";
        }
        else {
            java.lang.StringBuilder buf =
              new java.lang.StringBuilder(
              );
            java.util.StringTokenizer tok =
              new java.util.StringTokenizer(
              params,
              " \t\n\r\f,");
            while (tok.
                     hasMoreTokens(
                       )) {
                java.lang.String param =
                  typeToSignature(
                    tok.
                      nextToken(
                        ));
                buf.
                  append(
                    param);
            }
            pString =
              buf.
                toString(
                  );
        }
        if (returns ==
              null) {
            rString =
              ".*";
        }
        else {
            rString =
              typeToSignature(
                returns);
        }
        if (params ==
              null ||
              returns ==
              null) {
            java.lang.String result =
              "~\\(" +
            pString +
            "\\)" +
            rString;
            assert java.util.regex.Pattern.
              compile(
                result.
                  substring(
                    1)) !=
              null;
            return result;
        }
        else {
            return "(" +
            pString +
            ")" +
            rString;
        }
    }
    public static java.lang.String createFieldSignature(java.lang.String type) {
        if (type ==
              null) {
            return null;
        }
        return typeToSignature(
                 type);
    }
    private static java.lang.String typeToSignature(java.lang.String type) {
        if (type.
              endsWith(
                "[]")) {
            return "[" +
            typeToSignature(
              type.
                substring(
                  0,
                  type.
                    length(
                      ) -
                    2));
        }
        else {
            return scalarTypeToSiganture(
                     type);
        }
    }
    private static java.lang.String scalarTypeToSiganture(java.lang.String type) {
        if ("boolean".
              equals(
                type)) {
            return "Z";
        }
        else
            if ("byte".
                  equals(
                    type)) {
                return "B";
            }
            else
                if ("char".
                      equals(
                        type)) {
                    return "C";
                }
                else
                    if ("short".
                          equals(
                            type)) {
                        return "S";
                    }
                    else
                        if ("int".
                              equals(
                                type)) {
                            return "I";
                        }
                        else
                            if ("long".
                                  equals(
                                    type)) {
                                return "J";
                            }
                            else
                                if ("float".
                                      equals(
                                        type)) {
                                    return "F";
                                }
                                else
                                    if ("double".
                                          equals(
                                            type)) {
                                        return "D";
                                    }
                                    else
                                        if ("void".
                                              equals(
                                                type)) {
                                            return "V";
                                        }
                                        else {
                                            return "L" +
                                            type.
                                              replace(
                                                '.',
                                                '/') +
                                            ";";
                                        }
    }
    public SignatureUtil() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "dfGKww/+C8qSnXUSFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
