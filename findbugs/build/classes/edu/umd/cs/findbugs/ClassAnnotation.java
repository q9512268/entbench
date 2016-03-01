package edu.umd.cs.findbugs;
public class ClassAnnotation extends edu.umd.cs.findbugs.PackageMemberAnnotation {
    private static final long serialVersionUID = 1L;
    private static final java.lang.String DEFAULT_ROLE = "CLASS_DEFAULT";
    public static final java.lang.String SUBCLASS_ROLE = "CLASS_SUBCLASS";
    public static final java.lang.String SUPERCLASS_ROLE = "CLASS_SUPERCLASS";
    public static final java.lang.String RECOMMENDED_SUPERCLASS_ROLE = "CLASS_RECOMMENDED_SUPERCLASS";
    public static final java.lang.String IMPLEMENTED_INTERFACE_ROLE = "CLASS_IMPLEMENTED_INTERFACE";
    public static final java.lang.String INTERFACE_ROLE = "INTERFACE_TYPE";
    public static final java.lang.String ANNOTATION_ROLE = "CLASS_ANNOTATION";
    public static final java.lang.String TYPE_QUALIFIER_ROLE = "CLASS_TYPE_QUALIFIER";
    public ClassAnnotation(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                           java.lang.String className) { super(className,
                                                               DEFAULT_ROLE);
    }
    public ClassAnnotation(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                           java.lang.String className, java.lang.String sourceFileName) {
        super(
          className,
          DEFAULT_ROLE,
          sourceFileName);
    }
    @java.lang.Override
    public boolean isSignificant() { return !SUBCLASS_ROLE.equals(
                                                             description);
    }
    public static edu.umd.cs.findbugs.ClassAnnotation fromClassDescriptor(edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor) {
        return new edu.umd.cs.findbugs.ClassAnnotation(
          classDescriptor.
            toDottedClassName(
              ));
    }
    @java.lang.Override
    public void accept(edu.umd.cs.findbugs.BugAnnotationVisitor visitor) {
        visitor.
          visitClassAnnotation(
            this);
    }
    @java.lang.Override
    protected java.lang.String formatPackageMember(java.lang.String key,
                                                   edu.umd.cs.findbugs.ClassAnnotation primaryClass) {
        if ("".
              equals(
                key) ||
              "hash".
              equals(
                key)) {
            return className;
        }
        else
            if ("givenClass".
                  equals(
                    key)) {
                return shorten(
                         primaryClass.
                           getPackageName(
                             ),
                         className);
            }
            else
                if ("excludingPackage".
                      equals(
                        key)) {
                    return shorten(
                             getPackageName(
                               ),
                             className);
                }
                else
                    if ("simpleClass".
                          equals(
                            key) ||
                          "simpleName".
                          equals(
                            key)) {
                        return edu.umd.cs.findbugs.util.ClassName.
                          extractSimpleName(
                            className);
                    }
                    else {
                        throw new java.lang.IllegalArgumentException(
                          "unknown key " +
                          key);
                    }
    }
    @java.lang.Override
    public int hashCode() { return className.hashCode(
                                               );
    }
    @java.lang.Override
    public boolean equals(java.lang.Object o) { if (!(o instanceof edu.umd.cs.findbugs.ClassAnnotation)) {
                                                    return false;
                                                }
                                                edu.umd.cs.findbugs.ClassAnnotation other =
                                                  (edu.umd.cs.findbugs.ClassAnnotation)
                                                    o;
                                                return className.
                                                  equals(
                                                    other.
                                                      className);
    }
    public boolean contains(edu.umd.cs.findbugs.ClassAnnotation other) {
        return other.
                 className.
          startsWith(
            className);
    }
    public edu.umd.cs.findbugs.ClassAnnotation getTopLevelClass() {
        int firstDollar =
          className.
          indexOf(
            '$');
        if (firstDollar <=
              0) {
            return this;
        }
        return new edu.umd.cs.findbugs.ClassAnnotation(
          className.
            substring(
              0,
              firstDollar));
    }
    @java.lang.Override
    public int compareTo(edu.umd.cs.findbugs.BugAnnotation o) {
        if (!(o instanceof edu.umd.cs.findbugs.ClassAnnotation)) {
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
        edu.umd.cs.findbugs.ClassAnnotation other =
          (edu.umd.cs.findbugs.ClassAnnotation)
            o;
        return className.
          compareTo(
            other.
              className);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.SourceLineAnnotation getSourceLines() {
        if (sourceLines ==
              null) {
            this.
              sourceLines =
              getSourceLinesForClass(
                className,
                sourceFileName);
        }
        return sourceLines;
    }
    public static edu.umd.cs.findbugs.SourceLineAnnotation getSourceLinesForClass(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                                                                  java.lang.String className,
                                                                                  java.lang.String sourceFileName) {
        edu.umd.cs.findbugs.ba.AnalysisContext currentAnalysisContext =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            );
        if (currentAnalysisContext ==
              null) {
            return new edu.umd.cs.findbugs.SourceLineAnnotation(
              className,
              sourceFileName,
              -1,
              -1,
              -1,
              -1);
        }
        edu.umd.cs.findbugs.ba.SourceInfoMap.SourceLineRange classLine =
          currentAnalysisContext.
          getSourceInfoMap(
            ).
          getClassLine(
            className);
        if (classLine ==
              null) {
            return edu.umd.cs.findbugs.SourceLineAnnotation.
              getSourceAnnotationForClass(
                className,
                sourceFileName);
        }
        else {
            return new edu.umd.cs.findbugs.SourceLineAnnotation(
              className,
              sourceFileName,
              classLine.
                getStart(
                  ),
              classLine.
                getEnd(
                  ),
              -1,
              -1);
        }
    }
    private static final java.lang.String
      ELEMENT_NAME =
      "Class";
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
                                           "classname",
                                           getClassName(
                                             ));
                                       if (isPrimary) {
                                           attributeList.
                                             addAttribute(
                                               "primary",
                                               "true");
                                       }
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
                                       xmlOutput.
                                         openTag(
                                           ELEMENT_NAME,
                                           attributeList);
                                       getSourceLines(
                                         ).
                                         writeXML(
                                           xmlOutput,
                                           addMessages,
                                           false);
                                       if (addMessages) {
                                           xmlOutput.
                                             openTag(
                                               edu.umd.cs.findbugs.BugAnnotation.
                                                 MESSAGE_TAG);
                                           xmlOutput.
                                             writeText(
                                               this.
                                                 toString(
                                                   ));
                                           xmlOutput.
                                             closeTag(
                                               edu.umd.cs.findbugs.BugAnnotation.
                                                 MESSAGE_TAG);
                                       }
                                       xmlOutput.
                                         closeTag(
                                           ELEMENT_NAME);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "pjBP476pF9oRmMcrr/BXfPvN/wCi3iautzAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4ahCSmt70dVDZrlaJKQurdUZbdQyZrtp");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("si7SmoV2KmB1pzxdVdYMz00oEOk3MH9C1NBOBlw1O1ZEEPSvw+GW4CZbst4b" +
       "+pzFRI4vl/0lNqo16j7Z8jiHUYMAwubGaDOEEtxCLDmOsvyB2rvfnT9q+9LV" +
       "Hvc9WjyFPM3m+3M8f0wve8Vf/N1bupABduYJ7pl37KX8BeQbb5ekV7x8/PxH" +
       "Xvycxv4MfG3/fv99UemByPPfaesbcG96IJW/rn/u9i9amSJH8fDO/Ksf+f0n" +
       "Jz9ovv8KuVBvvsDnRZJ/n/nCr1Hfr/7Na6W7Tt+g35I9eX7S8+ffmz8Y6FEc" +
       "uJNzb8/feIrs4zliT4HS3yPbv/hs/LB3t2hB8Sb87bu9v0P6xL++Q9/X8+pf" +
       "RqWHrZC3Fq5lWOpJPq14RlV+OCrdp3iercvuQY2+dl6NHjpVo9N8nMcO7/PZ" +
       "jR4A/6jfQfNuk6Ty1VOw3po3oqBM92BNrwDWtYPJXIrYhVSid16W31dkF+dJ" +
       "kzuF7uihGlh+5AUFxf90B5z/a179x6j0uBF4zoXJF6zzt6+S3XIBoSKNJ38d" +
       "J+0Rkl4edboAztsvAweLF4dkqZkVWie4/M874PKHefX7UenePPXJv1Tx7t54" +
       "lnaA55u31bq8+be+F/16Td6Yp6/c3KN38yroASfmB16kq5GuXQrixcSnG/mo" +
       "o2u3R+fo7rzxT3KtyfMco32mNFOkmRdkDrD86SsHy/W88XWguHtY3JdHqc5K" +
       "ev0OfY/m1YNR6X5TDk3c2/uQC1pyl7V3WzkaR6965dAoPHb+SjPcoxG+IiZ2" +
       "JhVql8JVQPHmO8D0dF49CUxJX8fy7hj9jQMir3+FEXk9KB/YI/KBlxWRg6kc" +
       "30H63KKOngVKss+zuyj/c9+DV81lK5VB+dBewA+9/AbwF+7Q9668QoFOLPRo" +
       "4vl0Hiadvi0/nBxH9e9BxsLI81SDH9vL+GOviFq/5SVPjkJi8g5o9POqHeUZ" +
       "lXlatD7JP1s4evwAA/bKqfpTeWPe/5k9Sp95+TVheoc+Ia9GUekRoAn7t/qW" +
       "q4d3PJcP49rnQ+ICrPErB1Zxk/BuUH56D9ZPXwGslwrXLs0iPtLugJ2RVzej" +
       "0mvPY0d6wYktHYkHXN7/vUZh7wTll/eC//L/P1tKHft4ztBsHPnx7szw70xl" +
       "l21vecc9lkjzGOzEBvNM/6MV8KhJYEU6oJlP+KMDQvYrpzkFgHlw/5U9gF95" +
       "eQC86/Tm+Widt/1GURXSfvi2h89RXAz40bz64O3heOFlhCONStcvfEuUfxjx" +
       "xC0fKO4+qlN//nPX73/d56b/rvic5vTDtwfo0v1GbNtns7jPXN/rB7phFTg9" +
       "sMvp9gtBPw504hLNApKfXBa28uO70Z+ISg8eRkela+q57r8Bbhz33SBGA/XZ" +
       "zhdBE+jMLz/ln+hj+TKtPhf5njkrdlr8xFktKqLhx17Kes88q3j63BOG4lPR" +
       "k6cB8e5j0ZvqFz/XH37g2/Wf2X33A24Dsyyncj9dum/3CVJBNH+i8JbbUjuh" +
       "dW/32e888gsPvO3k6ccjO4YPGn2Gtzdf/pEN4fhR8VlM9o9f9w/f9Xc/9ztF" +
       "fvz/A050+HrDOwAA");
}
