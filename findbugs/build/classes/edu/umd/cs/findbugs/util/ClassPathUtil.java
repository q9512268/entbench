package edu.umd.cs.findbugs.util;
public class ClassPathUtil {
    public static java.lang.String findCodeBaseInClassPath(@javax.annotation.Nonnull
                                                           java.lang.String codeBaseName,
                                                           java.lang.String classPath) {
        if (classPath ==
              null) {
            return null;
        }
        java.util.StringTokenizer tok =
          new java.util.StringTokenizer(
          classPath,
          java.io.File.
            pathSeparator);
        while (tok.
                 hasMoreTokens(
                   )) {
            java.lang.String t =
              tok.
              nextToken(
                );
            java.io.File f =
              new java.io.File(
              t);
            if (f.
                  getName(
                    ).
                  equals(
                    codeBaseName)) {
                return t;
            }
        }
        return null;
    }
    public static java.lang.String findCodeBaseInClassPath(java.util.regex.Pattern codeBaseNamePattern,
                                                           java.lang.String classPath) {
        if (classPath ==
              null) {
            return null;
        }
        java.util.StringTokenizer tok =
          new java.util.StringTokenizer(
          classPath,
          java.io.File.
            pathSeparator);
        while (tok.
                 hasMoreTokens(
                   )) {
            java.lang.String t =
              tok.
              nextToken(
                );
            java.io.File f =
              new java.io.File(
              t);
            java.util.regex.Matcher m =
              codeBaseNamePattern.
              matcher(
                f.
                  getName(
                    ));
            if (m.
                  matches(
                    )) {
                return t;
            }
        }
        return null;
    }
    public static java.lang.String[] getJavaClassPath() {
        return java.lang.System.
          getProperty(
            "java.class.path").
          split(
            ":");
    }
    public ClassPathUtil() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
