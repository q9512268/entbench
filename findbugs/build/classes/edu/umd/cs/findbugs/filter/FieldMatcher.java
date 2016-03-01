package edu.umd.cs.findbugs.filter;
public class FieldMatcher extends edu.umd.cs.findbugs.filter.MemberMatcher implements edu.umd.cs.findbugs.filter.Matcher {
    public FieldMatcher(java.lang.String name) { super(name); }
    public FieldMatcher(java.lang.String name, java.lang.String type) { this(
                                                                          name,
                                                                          edu.umd.cs.findbugs.filter.SignatureUtil.
                                                                            createFieldSignature(
                                                                              type),
                                                                          null);
    }
    public FieldMatcher(java.lang.String name, java.lang.String type,
                        java.lang.String role) { super(
                                                   name,
                                                   edu.umd.cs.findbugs.filter.SignatureUtil.
                                                     createFieldSignature(
                                                       type),
                                                   role);
    }
    @java.lang.Override
    public java.lang.String toString() { return "Method(" +
                                         super.
                                           toString(
                                             ) +
                                         ")";
    }
    @java.lang.Override
    public boolean match(edu.umd.cs.findbugs.BugInstance bugInstance) {
        edu.umd.cs.findbugs.FieldAnnotation fieldAnnotation =
          null;
        if (role ==
              null ||
              "".
              equals(
                role)) {
            fieldAnnotation =
              bugInstance.
                getPrimaryField(
                  );
        }
        else {
            for (edu.umd.cs.findbugs.BugAnnotation a
                  :
                  bugInstance.
                   getAnnotations(
                     )) {
                if (a instanceof edu.umd.cs.findbugs.FieldAnnotation &&
                      role.
                      equals(
                        a.
                          getDescription(
                            ))) {
                    fieldAnnotation =
                      (edu.umd.cs.findbugs.FieldAnnotation)
                        a;
                    break;
                }
            }
        }
        if (fieldAnnotation ==
              null) {
            return false;
        }
        if (!name.
              match(
                fieldAnnotation.
                  getFieldName(
                    ))) {
            return false;
        }
        if (signature !=
              null &&
              !signature.
              match(
                fieldAnnotation.
                  getFieldSignature(
                    ))) {
            return false;
        }
        return true;
    }
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput,
                         boolean disabled)
          throws java.io.IOException { edu.umd.cs.findbugs.xml.XMLAttributeList attributes =
                                         new edu.umd.cs.findbugs.xml.XMLAttributeList(
                                         ).
                                         addAttribute(
                                           "name",
                                           name.
                                             getSpec(
                                               ));
                                       if (signature !=
                                             null) {
                                           attributes.
                                             addOptionalAttribute(
                                               "signature",
                                               signature.
                                                 getSpec(
                                                   ));
                                       }
                                       attributes.
                                         addOptionalAttribute(
                                           "role",
                                           role);
                                       if (disabled) {
                                           attributes.
                                             addAttribute(
                                               "disabled",
                                               "true");
                                       }
                                       xmlOutput.
                                         openCloseTag(
                                           "Field",
                                           attributes);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gDCrYxoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mfzhPb//ho8+9/Xs+Pz/ABrCCSOAJQAA");
}
