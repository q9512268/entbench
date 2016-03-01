package edu.umd.cs.findbugs;
public class SloppyBugComparator implements edu.umd.cs.findbugs.WarningComparator {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "sloppyComparator.debug");
    private edu.umd.cs.findbugs.model.ClassNameRewriter classNameRewriter =
      edu.umd.cs.findbugs.model.IdentityClassNameRewriter.
      instance(
        );
    public SloppyBugComparator() { super(); }
    @java.lang.Override
    public void setClassNameRewriter(edu.umd.cs.findbugs.model.ClassNameRewriter classNameRewriter) {
        this.
          classNameRewriter =
          classNameRewriter;
    }
    private int compareNullElements(java.lang.Object lhs, java.lang.Object rhs) {
        if (lhs ==
              null &&
              rhs ==
              null) {
            return 0;
        }
        else {
            return lhs ==
              null
              ? -1
              : 1;
        }
    }
    private int compareClassesAllowingNull(edu.umd.cs.findbugs.ClassAnnotation lhs,
                                           edu.umd.cs.findbugs.ClassAnnotation rhs) {
        if (lhs ==
              null ||
              rhs ==
              null) {
            return compareNullElements(
                     lhs,
                     rhs);
        }
        java.lang.String lhsClassName =
          classNameRewriter.
          rewriteClassName(
            lhs.
              getClassName(
                ));
        java.lang.String rhsClassName =
          classNameRewriter.
          rewriteClassName(
            rhs.
              getClassName(
                ));
        if (DEBUG) {
            java.lang.System.
              err.
              println(
                "Comparing " +
                lhsClassName +
                " and " +
                rhsClassName);
        }
        int cmp =
          lhsClassName.
          compareTo(
            rhsClassName);
        if (DEBUG) {
            java.lang.System.
              err.
              println(
                "\t==> " +
                cmp);
        }
        return cmp;
    }
    private int compareMethodsAllowingNull(edu.umd.cs.findbugs.MethodAnnotation lhs,
                                           edu.umd.cs.findbugs.MethodAnnotation rhs) {
        if (lhs ==
              null ||
              rhs ==
              null) {
            return compareNullElements(
                     lhs,
                     rhs);
        }
        lhs =
          convertMethod(
            lhs);
        rhs =
          convertMethod(
            rhs);
        return lhs.
          compareTo(
            rhs);
    }
    private int compareFieldsAllowingNull(edu.umd.cs.findbugs.FieldAnnotation lhs,
                                          edu.umd.cs.findbugs.FieldAnnotation rhs) {
        if (lhs ==
              null ||
              rhs ==
              null) {
            return compareNullElements(
                     lhs,
                     rhs);
        }
        lhs =
          convertField(
            lhs);
        rhs =
          convertField(
            rhs);
        if (DEBUG) {
            java.lang.System.
              err.
              println(
                "Compare fields: " +
                lhs +
                " and " +
                rhs);
        }
        return lhs.
          compareTo(
            rhs);
    }
    private edu.umd.cs.findbugs.MethodAnnotation convertMethod(edu.umd.cs.findbugs.MethodAnnotation methodAnnotation) {
        return edu.umd.cs.findbugs.model.ClassNameRewriterUtil.
          convertMethodAnnotation(
            classNameRewriter,
            methodAnnotation);
    }
    private edu.umd.cs.findbugs.FieldAnnotation convertField(edu.umd.cs.findbugs.FieldAnnotation fieldAnnotation) {
        return edu.umd.cs.findbugs.model.ClassNameRewriterUtil.
          convertFieldAnnotation(
            classNameRewriter,
            fieldAnnotation);
    }
    @java.lang.Override
    public int compare(edu.umd.cs.findbugs.BugInstance lhs,
                       edu.umd.cs.findbugs.BugInstance rhs) {
        int cmp;
        edu.umd.cs.findbugs.BugPattern lhsPattern =
          lhs.
          getBugPattern(
            );
        edu.umd.cs.findbugs.BugPattern rhsPattern =
          rhs.
          getBugPattern(
            );
        java.lang.String lhsAbbrev;
        java.lang.String rhsAbbrev;
        lhsAbbrev =
          lhsPattern.
            getAbbrev(
              );
        rhsAbbrev =
          rhsPattern.
            getAbbrev(
              );
        cmp =
          lhsAbbrev.
            compareTo(
              rhsAbbrev);
        if (cmp !=
              0) {
            if (DEBUG) {
                java.lang.System.
                  err.
                  println(
                    "bug abbrevs do not match");
            }
            return cmp;
        }
        cmp =
          compareClassesAllowingNull(
            lhs.
              getPrimaryClass(
                ),
            rhs.
              getPrimaryClass(
                ));
        if (cmp !=
              0) {
            return cmp;
        }
        boolean havePrimaryMethods =
          lhs.
          getPrimaryMethod(
            ) !=
          null &&
          rhs.
          getPrimaryMethod(
            ) !=
          null;
        cmp =
          compareMethodsAllowingNull(
            lhs.
              getPrimaryMethod(
                ),
            rhs.
              getPrimaryMethod(
                ));
        if (cmp !=
              0) {
            if (DEBUG) {
                java.lang.System.
                  err.
                  println(
                    "primary methods do not match");
            }
            return cmp;
        }
        if (!havePrimaryMethods) {
            cmp =
              compareFieldsAllowingNull(
                lhs.
                  getPrimaryField(
                    ),
                rhs.
                  getPrimaryField(
                    ));
            if (cmp !=
                  0) {
                if (DEBUG) {
                    java.lang.System.
                      err.
                      println(
                        "primary fields do not match");
                }
                return cmp;
            }
        }
        return 0;
    }
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
      ("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" +
       "1do31b31fd9Z67vvxPpOLOfB/Q7bZK2FoalqtzHYm88dior3nqBWED4FnsMj" +
       "1A5fKWrYhagdFAQHF+xE7nb+8/qPFz1//DZw/mRefDQuvU4pfEIbJ46TX13R" +
       "vDi6CM07zKPrJwWYP/pyG34vh0tuQW8/wuXtXxdcnrooDhSGsz/3ykk/WTB7" +
       "8TZQfTovfjYuPXwEVcFEixDH8TcgqOTI5RQ/vYfn574W8DBH8DBfF3iuXwTP" +
       "LkicxedXC27/5Tb4/HpefGaPz47L7fD5z68Wn6fB884jfN7572c+xXHfWXg+" +
       "VzD77G3g+Xxe/EZcetMRPAWT26Hz314FOo8cW49xhI7xtUHnVKjeGcTv3kbj" +
       "38uLL8TFKSUIpPHOIIq+ey1/+1Vo+ea88m3gsY+0tL/mWu7m9Y9uo+Uf58Uf" +
       "xMUNtlzLYl6Lrnslv/gqlLyaVz4EnuBIyeCVKnnxqnvO0B+7yNDRxDhOFXKy" +
       "/1cw+r+3AeP/58WfxaXLR0Z+zqT//JaLb179w69omU3BonXBxaP8FsUbb7rZ" +
       "uLuNp/ziC1fvecMLs/9V3L05uTF3L1W6Rwf+d/rQ+9T73UGo6Wah3r27I/Cg" +
       "+PcPQIALQIsBs6PXQua/31H/U1y6sqeOSwfK6eZLJYDZUTNYZEF5uvEOUAUa" +
       "89c7izn/eHrpVOp5ZDIFwg++nKWddDl96yZPV4tLo8epZbK7NnpD+dQLg/F3" +
       "fqX5M7tbP4ojbbc5l3uo0uXdBaST9PSJW3I75nU3+fRX7//0vW85TqXv3wm8" +
       "N99Tsj128RUb3A3i4lLM9lfe8J++9Wdf+GJx6vmvKvjFFs0rAAA=");
}
