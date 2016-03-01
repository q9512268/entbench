package edu.umd.cs.findbugs.filter;
public class ClassMatcher implements edu.umd.cs.findbugs.filter.Matcher {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "filter.debug");
    private final edu.umd.cs.findbugs.filter.NameMatch className;
    private final java.lang.String role;
    @java.lang.Override
    public java.lang.String toString() { return "Class(class=\"" + className.
                                           getValue(
                                             ) +
                                         "\")"; }
    public ClassMatcher(java.lang.String className) { this(className, null);
    }
    public ClassMatcher(java.lang.String className, java.lang.String role) {
        super(
          );
        this.
          className =
          new edu.umd.cs.findbugs.filter.NameMatch(
            className);
        this.
          role =
          role;
    }
    @java.lang.Override
    public boolean match(edu.umd.cs.findbugs.BugInstance bugInstance) { edu.umd.cs.findbugs.ClassAnnotation classAnnotation =
                                                                          bugInstance.
                                                                          getPrimaryClass(
                                                                            );
                                                                        if (role !=
                                                                              null &&
                                                                              !"".
                                                                              equals(
                                                                                role)) {
                                                                            for (edu.umd.cs.findbugs.BugAnnotation a
                                                                                  :
                                                                                  bugInstance.
                                                                                   getAnnotations(
                                                                                     )) {
                                                                                if (a instanceof edu.umd.cs.findbugs.ClassAnnotation &&
                                                                                      role.
                                                                                      equals(
                                                                                        a.
                                                                                          getDescription(
                                                                                            ))) {
                                                                                    classAnnotation =
                                                                                      (edu.umd.cs.findbugs.ClassAnnotation)
                                                                                        a;
                                                                                    break;
                                                                                }
                                                                            }
                                                                        }
                                                                        java.lang.String bugClassName =
                                                                          classAnnotation.
                                                                          getClassName(
                                                                            );
                                                                        boolean result =
                                                                          className.
                                                                          match(
                                                                            bugClassName);
                                                                        if (DEBUG) {
                                                                            java.lang.System.
                                                                              out.
                                                                              println(
                                                                                "Matching " +
                                                                                bugClassName +
                                                                                " with " +
                                                                                className +
                                                                                ", result = " +
                                                                                result);
                                                                        }
                                                                        return result;
    }
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput,
                         boolean disabled)
          throws java.io.IOException { edu.umd.cs.findbugs.xml.XMLAttributeList attributes =
                                         new edu.umd.cs.findbugs.xml.XMLAttributeList(
                                         ).
                                         addAttribute(
                                           "name",
                                           className.
                                             getSpec(
                                               ));
                                       if (disabled) {
                                           attributes.
                                             addAttribute(
                                               "disabled",
                                               "true");
                                       }
                                       attributes.
                                         addOptionalAttribute(
                                           "role",
                                           role);
                                       xmlOutput.
                                         openCloseTag(
                                           "Class",
                                           attributes);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Djf+C5PwllYnHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
