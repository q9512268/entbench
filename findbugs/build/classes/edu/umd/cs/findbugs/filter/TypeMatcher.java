package edu.umd.cs.findbugs.filter;
public class TypeMatcher implements edu.umd.cs.findbugs.filter.Matcher {
    private final edu.umd.cs.findbugs.filter.NameMatch descriptor;
    private final java.lang.String role;
    private final java.lang.String typeParameters;
    @java.lang.Override
    public java.lang.String toString() { return "Type(descriptor=\"" + descriptor.
                                           getValue(
                                             ) +
                                         "\")"; }
    public TypeMatcher(java.lang.String descriptor, java.lang.String role,
                       java.lang.String typeParameters) { super();
                                                          this.descriptor =
                                                            new edu.umd.cs.findbugs.filter.NameMatch(
                                                              descriptor);
                                                          this.
                                                            role =
                                                            role;
                                                          this.
                                                            typeParameters =
                                                            typeParameters;
    }
    @java.lang.Override
    public boolean match(edu.umd.cs.findbugs.BugInstance bugInstance) {
        edu.umd.cs.findbugs.TypeAnnotation typeAnnotation =
          bugInstance.
          getPrimaryType(
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
                if (a instanceof edu.umd.cs.findbugs.TypeAnnotation &&
                      role.
                      equals(
                        a.
                          getDescription(
                            ))) {
                    typeAnnotation =
                      (edu.umd.cs.findbugs.TypeAnnotation)
                        a;
                    break;
                }
            }
        }
        if (typeAnnotation ==
              null) {
            return false;
        }
        java.lang.String typeDesctiptor =
          typeAnnotation.
          getTypeDescriptor(
            );
        if (!descriptor.
              match(
                typeDesctiptor)) {
            return false;
        }
        if (typeParameters !=
              null &&
              !typeParameters.
              equals(
                typeAnnotation.
                  getTypeParameters(
                    ))) {
            return false;
        }
        return true;
    }
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput,
                         boolean disabled) throws java.io.IOException {
        edu.umd.cs.findbugs.xml.XMLAttributeList attributes =
          new edu.umd.cs.findbugs.xml.XMLAttributeList(
          ).
          addAttribute(
            "descriptor",
            descriptor.
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
            "typeParameters",
            typeParameters);
        attributes.
          addOptionalAttribute(
            "role",
            role);
        xmlOutput.
          openCloseTag(
            "Type",
            attributes);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "r7FX2rz1H7kpBVQtHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
