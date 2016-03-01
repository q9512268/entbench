package edu.umd.cs.findbugs.filter;
public class BugMatcher implements edu.umd.cs.findbugs.filter.Matcher {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "filter.debug");
    private final edu.umd.cs.findbugs.filter.StringSetMatch codes;
    private final edu.umd.cs.findbugs.filter.StringSetMatch patterns;
    private final edu.umd.cs.findbugs.filter.StringSetMatch categories;
    public BugMatcher(java.lang.String codes, java.lang.String patterns, java.lang.String categories) {
        super(
          );
        this.
          codes =
          new edu.umd.cs.findbugs.filter.StringSetMatch(
            codes);
        this.
          patterns =
          new edu.umd.cs.findbugs.filter.StringSetMatch(
            patterns);
        this.
          categories =
          new edu.umd.cs.findbugs.filter.StringSetMatch(
            categories);
    }
    @java.lang.Override
    public boolean match(edu.umd.cs.findbugs.BugInstance bugInstance) {
        boolean result1 =
          codes.
          match(
            bugInstance.
              getAbbrev(
                ));
        boolean result2 =
          patterns.
          match(
            bugInstance.
              getType(
                ));
        boolean result3 =
          categories.
          match(
            bugInstance.
              getBugPattern(
                ).
              getCategory(
                ));
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Matching " +
                bugInstance.
                  getAbbrev(
                    ) +
                "/" +
                bugInstance.
                  getType(
                    ) +
                "/" +
                bugInstance.
                  getBugPattern(
                    ).
                  getCategory(
                    ) +
                " with " +
                this +
                ", result = " +
                result1 +
                "/" +
                result2 +
                "/" +
                result3);
        }
        return result1 ||
          result2 ||
          result3;
    }
    @java.lang.Override
    public int hashCode() { return codes.hashCode() + patterns.hashCode(
                                                                 ) +
                              categories.
                              hashCode(
                                ); }
    @java.lang.Override
    public boolean equals(java.lang.Object o) { if (!(o instanceof edu.umd.cs.findbugs.filter.BugMatcher)) {
                                                    return false;
                                                }
                                                edu.umd.cs.findbugs.filter.BugMatcher other =
                                                  (edu.umd.cs.findbugs.filter.BugMatcher)
                                                    o;
                                                return codes.
                                                  equals(
                                                    other.
                                                      codes) &&
                                                  patterns.
                                                  equals(
                                                    other.
                                                      patterns) &&
                                                  categories.
                                                  equals(
                                                    other.
                                                      categories);
    }
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput,
                         boolean disabled)
          throws java.io.IOException { xmlOutput.
                                         startTag(
                                           "Bug");
                                       if (disabled) {
                                           xmlOutput.
                                             addAttribute(
                                               "disabled",
                                               "true");
                                       }
                                       addAttribute(
                                         xmlOutput,
                                         "code",
                                         codes);
                                       addAttribute(
                                         xmlOutput,
                                         "pattern",
                                         patterns);
                                       addAttribute(
                                         xmlOutput,
                                         "category",
                                         categories);
                                       xmlOutput.
                                         stopTag(
                                           true);
    }
    public void addAttribute(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput,
                             java.lang.String name,
                             edu.umd.cs.findbugs.filter.StringSetMatch matches)
          throws java.io.IOException { java.lang.String value =
                                         matches.
                                         toString(
                                           );
                                       if (value.
                                             length(
                                               ) !=
                                             0) {
                                           xmlOutput.
                                             addAttribute(
                                               name,
                                               value);
                                       } }
    @java.lang.Override
    public java.lang.String toString() { java.lang.StringBuilder buf =
                                           new java.lang.StringBuilder(
                                           "Bug(");
                                         if (!codes.
                                               isEmpty(
                                                 )) {
                                             buf.
                                               append(
                                                 "code = \"").
                                               append(
                                                 codes).
                                               append(
                                                 "\" ");
                                         }
                                         if (!patterns.
                                               isEmpty(
                                                 )) {
                                             buf.
                                               append(
                                                 "pattern = \"").
                                               append(
                                                 patterns).
                                               append(
                                                 "\" ");
                                         }
                                         if (!categories.
                                               isEmpty(
                                                 )) {
                                             buf.
                                               append(
                                                 "category = \"").
                                               append(
                                                 categories).
                                               append(
                                                 "\" ");
                                         }
                                         buf.
                                           setLength(
                                             buf.
                                               length(
                                                 ) -
                                               1);
                                         buf.
                                           append(
                                             ")");
                                         return buf.
                                           toString(
                                             );
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
      ("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");
}
