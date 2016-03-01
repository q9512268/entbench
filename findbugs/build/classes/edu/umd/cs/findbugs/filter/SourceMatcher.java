package edu.umd.cs.findbugs.filter;
public class SourceMatcher implements edu.umd.cs.findbugs.filter.Matcher {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "filter.debug");
    private final edu.umd.cs.findbugs.filter.NameMatch fileName;
    @java.lang.Override
    public java.lang.String toString() { return "Source(file=\"" + fileName.
                                           getValue(
                                             ) +
                                         "\")"; }
    public SourceMatcher(java.lang.String fileName) { super();
                                                      this.fileName = new edu.umd.cs.findbugs.filter.NameMatch(
                                                                        fileName);
    }
    @java.lang.Override
    public boolean match(edu.umd.cs.findbugs.BugInstance bugInstance) {
        edu.umd.cs.findbugs.ClassAnnotation primaryClassAnnotation =
          bugInstance.
          getPrimaryClass(
            );
        if (primaryClassAnnotation ==
              null) {
            return false;
        }
        java.lang.String bugFileName =
          primaryClassAnnotation.
          getSourceFileName(
            );
        if (bugFileName ==
              null ||
              bugFileName.
              isEmpty(
                )) {
            return false;
        }
        boolean result =
          fileName.
          match(
            bugFileName);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Matching " +
                bugFileName +
                " with " +
                fileName +
                ", result = " +
                result);
        }
        return result;
    }
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput,
                         boolean disabled) throws java.io.IOException {
        edu.umd.cs.findbugs.xml.XMLAttributeList attributes =
          new edu.umd.cs.findbugs.xml.XMLAttributeList(
          ).
          addAttribute(
            "name",
            fileName.
              getSpec(
                ));
        if (disabled) {
            attributes.
              addAttribute(
                "disabled",
                "true");
        }
        xmlOutput.
          openCloseTag(
            "Source",
            attributes);
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
       "phPk16Lpp+/541d9+Nlv5Kff/ws2ILcH0iUAAA==");
}
