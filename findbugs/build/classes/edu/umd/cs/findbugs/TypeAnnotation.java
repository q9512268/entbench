package edu.umd.cs.findbugs;
public class TypeAnnotation extends edu.umd.cs.findbugs.BugAnnotationWithSourceLines {
    private static final long serialVersionUID = 1L;
    public static final java.lang.String DEFAULT_ROLE = "TYPE_DEFAULT";
    public static final java.lang.String EXPECTED_ROLE = "TYPE_EXPECTED";
    public static final java.lang.String FOUND_ROLE = "TYPE_FOUND";
    public static final java.lang.String CLOSEIT_ROLE = "TYPE_CLOSEIT";
    public static final java.lang.String UNHASHABLE_ROLE = "TYPE_UNHASHABLE";
    private final java.lang.String descriptor;
    private java.lang.String roleDescription;
    private java.lang.String typeParameters;
    public TypeAnnotation(java.lang.String typeDescriptor) { this(typeDescriptor,
                                                                  DEFAULT_ROLE);
    }
    public TypeAnnotation(org.apache.bcel.generic.Type objectType) {
        this(
          objectType,
          DEFAULT_ROLE);
    }
    public TypeAnnotation(org.apache.bcel.generic.Type objectType,
                          java.lang.String roleDescription) { this(
                                                                objectType.
                                                                  getSignature(
                                                                    ),
                                                                roleDescription);
                                                              if (objectType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType) {
                                                                  edu.umd.cs.findbugs.ba.generic.GenericObjectType genericObjectType =
                                                                    (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                                                                      objectType;
                                                                  if (genericObjectType.
                                                                        getTypeCategory(
                                                                          ) ==
                                                                        edu.umd.cs.findbugs.ba.generic.GenericUtilities.TypeCategory.
                                                                          PARAMETERIZED) {
                                                                      typeParameters =
                                                                        genericObjectType.
                                                                          getGenericParametersAsString(
                                                                            );
                                                                  }
                                                              }
    }
    public TypeAnnotation(java.lang.String typeDescriptor,
                          java.lang.String roleDescription) {
        super(
          );
        descriptor =
          typeDescriptor;
        this.
          roleDescription =
          roleDescription;
        if (descriptor.
              startsWith(
                "L")) {
            java.lang.String className =
              typeDescriptor.
              substring(
                1,
                typeDescriptor.
                  length(
                    ) -
                  1).
              replace(
                '/',
                '.');
            edu.umd.cs.findbugs.ba.AnalysisContext context =
              edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                );
            if (context !=
                  null) {
                this.
                  sourceFileName =
                  context.
                    lookupSourceFile(
                      className);
                this.
                  sourceLines =
                  edu.umd.cs.findbugs.ClassAnnotation.
                    getSourceLinesForClass(
                      className,
                      sourceFileName);
            }
            else {
                this.
                  sourceFileName =
                  edu.umd.cs.findbugs.SourceLineAnnotation.
                    UNKNOWN_SOURCE_FILE;
            }
        }
    }
    public java.lang.String getTypeDescriptor() {
        return descriptor;
    }
    @java.lang.Override
    public void accept(edu.umd.cs.findbugs.BugAnnotationVisitor visitor) {
        visitor.
          visitTypeAnnotation(
            this);
    }
    @java.lang.Override
    public java.lang.String format(java.lang.String key,
                                   edu.umd.cs.findbugs.ClassAnnotation primaryClass) {
        java.lang.String name =
          new edu.umd.cs.findbugs.ba.SignatureConverter(
          descriptor).
          parseNext(
            ).
          replace(
            "java.lang.",
            "");
        if ("givenClass".
              equals(
                key)) {
            name =
              edu.umd.cs.findbugs.PackageMemberAnnotation.
                shorten(
                  primaryClass.
                    getPackageName(
                      ),
                  name);
        }
        else
            if ("excludingPackage".
                  equals(
                    key)) {
                name =
                  edu.umd.cs.findbugs.PackageMemberAnnotation.
                    removePackage(
                      name);
            }
        if (typeParameters !=
              null &&
              !"hash".
              equals(
                key)) {
            name =
              name +
              typeParameters;
        }
        return name;
    }
    @java.lang.Override
    public void setDescription(java.lang.String roleDescription) {
        this.
          roleDescription =
          roleDescription.
            intern(
              );
    }
    @java.lang.Override
    public java.lang.String getDescription() {
        return roleDescription;
    }
    public void setTypeParameters(java.lang.String typeParameters) {
        this.
          typeParameters =
          typeParameters;
    }
    public java.lang.String getTypeParameters() {
        return typeParameters;
    }
    @java.lang.Override
    public int hashCode() { return descriptor.
                              hashCode(
                                ); }
    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (!(o instanceof edu.umd.cs.findbugs.TypeAnnotation)) {
            return false;
        }
        return descriptor.
          equals(
            ((edu.umd.cs.findbugs.TypeAnnotation)
               o).
              descriptor);
    }
    @java.lang.Override
    public int compareTo(edu.umd.cs.findbugs.BugAnnotation o) {
        if (!(o instanceof edu.umd.cs.findbugs.TypeAnnotation)) {
            return this.
              getClass(
                ).
              getName(
                ).
              compareTo(
                o.
                  getClass(
                    ).
                  getName(
                    ));
        }
        return descriptor.
          compareTo(
            ((edu.umd.cs.findbugs.TypeAnnotation)
               o).
              descriptor);
    }
    @java.lang.Override
    public java.lang.String toString() { java.lang.String pattern =
                                           edu.umd.cs.findbugs.I18N.
                                           instance(
                                             ).
                                           getAnnotationDescription(
                                             roleDescription);
                                         edu.umd.cs.findbugs.FindBugsMessageFormat format =
                                           new edu.umd.cs.findbugs.FindBugsMessageFormat(
                                           pattern);
                                         return format.
                                           format(
                                             new edu.umd.cs.findbugs.BugAnnotation[] { this },
                                             null);
    }
    private static final java.lang.String
      ELEMENT_NAME =
      "Type";
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput)
          throws java.io.IOException { writeXML(
                                         xmlOutput,
                                         false,
                                         false);
    }
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput,
                         boolean addMessages,
                         boolean isPrimary)
          throws java.io.IOException { edu.umd.cs.findbugs.xml.XMLAttributeList attributeList =
                                         new edu.umd.cs.findbugs.xml.XMLAttributeList(
                                         ).
                                         addAttribute(
                                           "descriptor",
                                           descriptor);
                                       java.lang.String role =
                                         getDescription(
                                           );
                                       if (!DEFAULT_ROLE.
                                             equals(
                                               role)) {
                                           attributeList.
                                             addAttribute(
                                               "role",
                                               role);
                                       }
                                       if (typeParameters !=
                                             null) {
                                           attributeList.
                                             addAttribute(
                                               "typeParameters",
                                               typeParameters);
                                       }
                                       edu.umd.cs.findbugs.BugAnnotationUtil.
                                         writeXML(
                                           xmlOutput,
                                           ELEMENT_NAME,
                                           this,
                                           attributeList,
                                           addMessages);
    }
    @java.lang.Override
    public boolean isSignificant() { return true;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mZNYtON/sFd8+/r/iWqRfeUyAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qWJ83UwyRghIZbbG1o2m1I97nWqXM4xm");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ADlzAkMo1tuKyzix42QyncaEH3CtYSYxIjyHu23H5VQ1h5cJtKC2ekavnSSt" +
       "Kxqkrpu7dVJVKKu9gZaLpLOeSjXMYuh2ttQnYFMoC0sXry9lJJuka5ceS1uK" +
       "2DXtaFQ3iHQ6bC2iRlUVO13Vt6GBOZOXQ1rwcXkQ4xGNr2hRtNiRzYykyDHJ" +
       "mbMyO+Os05MId1nbiO3OJoRHbgxEPtjhdTCiLzNSyjJQQupIFYohe76aLI3p" +
       "FkXRnypezf3Zrb0efHX51vLoJuUP8b4yP+/Qvfy7t3Lm9t2JF74nTr0rxZHg" +
       "Gy66IFkeB770vhc+o7O/Wb+8P3Ffp5UH0jB6h2esDe8EqYcBpbdffPRJl/dD" +
       "j0+xv/q+//KE+NPWu2/hKtqbzuA8S/If05/74/5btI9drtx1dKZ9w83V052e" +
       "P32SfSU20iwOxFPn2W84fUBSnEF4e8l6Z1+lH8/d+e/433Yw9ze50PBXN6n7" +
       "j0X2daA4ppEWGHunD1eOdeYbt3zd49+dvu7RLPk6+FvdHibPXOR523kXIrHM" +
       "PL5BNbMTG7BWEvv2TaTy34rsm2nl3uI+VHRwtXt1wnKytHL3OrT1Y/H8zWnx" +
       "PHgkniN0jx7fNmDXRhzbunETK3xFmZaKUxwLrvcyXd8emZ68L3MI/ZnzBFua" +
       "9LFoC2KX7r5YppfuLwq/D2RaXplMT6vXpcqF8iuKv/ejSKrUvuK06v17Sb3/" +
       "tmpfyUjJ4WM34f41RfZwClyakZ45JPzusRSu3jkplPryJEgf2kvhQ7dHCieZ" +
       "fPImdU8X2U8AAZg3COCEGrz+DqsBAtJH9gL4yB1Sg3fcRApQkb0NuNvkwN2e" +
       "PpI9oQnP/Qju9iimfGzP6cdu/1R3b1L3fJE1j2PKmXPnYyZbPwKTV4vC14H0" +
       "yT2Tn7z9TBI3qesX2bvSyv2Wklh4uHfmZ4LEXfb+u6CSXfTOKfdjRWFxLP/i" +
       "Xhov3lblPgwEJ27MHdz0K0UxvYmYpCLjgNc3VpniJecJ6T41DD1DCY4Fxd85" +
       "QZVqU4TNl/aCeumOCOqpV1yKlNIxbyK54mbEJTUtrnIWl+8Nsfgy5tLgWEra" +
       "HQ4WT4D0hb2UvnD7jWt9k7oyWwHjSsODa/RnHEd8h8NEcXvty3vWv/z/T0Fy" +
       "37u2oMdslkbZgWn9ys2pHHyoYIfXBiyRFyvVQ8X6QJH9AhDgJrZTA9BcnQ4v" +
       "v3iHBTgF6St7AX7l9gjwrqON76VfLbKfLbOS2xcuDMmXPlg2+ESR/drF4vjo" +
       "HfbMT4L0tb04vnb7Tekf3KTuN4rsxbTykJ0IthnYS1tTgrSU3TH/n76N/Odg" +
       "jXf6K7Tik5rHb/iu9eBbTO3zn7l6/+s+M/1X5YdYR99LPjCu3L/MPO/klfAT" +
       "z/dGsbG0S7k8cHBBPCqZ/S1gEucYFpj4w8cC7qXPHrT+fFq5ctw6rVzWTlX/" +
       "LghN+2oQyUF+svL3QRGoLB6/GB2aY+0Vvf7cTq397S07MJL8wJIfP6k65Xby" +
       "0VdaGZ141/LMqTck5WfGh28zsoMPja9rX/jMkHnPd9q/efDZmOYpu11B5f5x" +
       "5b6DL9hKosUbkacupHZI617que89/DsPvPnw7c3DB4CP1fgEtjed/40W4Udp" +
       "+VXV7g9e9/vv/Ief+cvyxv3/A318LJ7/PQAA");
}
