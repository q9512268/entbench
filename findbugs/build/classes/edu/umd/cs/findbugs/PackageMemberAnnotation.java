package edu.umd.cs.findbugs;
public abstract class PackageMemberAnnotation extends edu.umd.cs.findbugs.BugAnnotationWithSourceLines {
    private static final long serialVersionUID = -8208567669352996892L;
    @edu.umd.cs.findbugs.internalAnnotations.DottedClassName
    protected final java.lang.String className;
    protected java.lang.String description;
    protected PackageMemberAnnotation(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                      java.lang.String className, java.lang.String description) {
        this(
          className,
          description,
          computeSourceFile(
            className));
    }
    private static java.lang.String computeSourceFile(java.lang.String className) {
        edu.umd.cs.findbugs.ba.AnalysisContext context =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            );
        if (context !=
              null) {
            return context.
              lookupSourceFile(
                className);
        }
        return edu.umd.cs.findbugs.SourceLineAnnotation.
                 UNKNOWN_SOURCE_FILE;
    }
    protected PackageMemberAnnotation(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                      java.lang.String className,
                                      java.lang.String description,
                                      java.lang.String sourceFileName) {
        super(
          );
        if (className.
              length(
                ) ==
              0) {
            throw new java.lang.IllegalArgumentException(
              "Empty classname not allowed");
        }
        if (className.
              indexOf(
                '/') >=
              0) {
            assert false: "classname " +
            className +
            " should be dotted";
            className =
              className.
                replace(
                  '/',
                  '.');
        }
        this.
          className =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
            canonicalizeString(
              className);
        this.
          sourceFileName =
          sourceFileName;
        if (description !=
              null) {
            description =
              description.
                intern(
                  );
        }
        this.
          description =
          description;
    }
    @edu.umd.cs.findbugs.internalAnnotations.DottedClassName
    public final java.lang.String getClassName() { return className;
    }
    @edu.umd.cs.findbugs.internalAnnotations.SlashedClassName
    public final java.lang.String getSlashedClassName() {
        return edu.umd.cs.findbugs.util.ClassName.
          toSlashedClassName(
            className);
    }
    public java.lang.String getSimpleClassName() { return edu.umd.cs.findbugs.util.ClassName.
                                                     extractSimpleName(
                                                       className);
    }
    public final edu.umd.cs.findbugs.classfile.ClassDescriptor getClassDescriptor() {
        return edu.umd.cs.findbugs.classfile.DescriptorFactory.
          instance(
            ).
          getClassDescriptorForDottedClassName(
            className);
    }
    @edu.umd.cs.findbugs.internalAnnotations.DottedClassName
    public final java.lang.String getPackageName() {
        int lastDot =
          className.
          lastIndexOf(
            '.');
        if (lastDot <
              0) {
            return "";
        }
        else {
            return className.
              substring(
                0,
                lastDot);
        }
    }
    @java.lang.Override
    public final java.lang.String format(java.lang.String key,
                                         edu.umd.cs.findbugs.ClassAnnotation primaryClass) {
        if ("class.givenClass".
              equals(
                key)) {
            return shorten(
                     primaryClass.
                       getPackageName(
                         ),
                     className);
        }
        if ("simpleClass".
              equals(
                key)) {
            return edu.umd.cs.findbugs.util.ClassName.
              extractSimpleName(
                className);
        }
        if ("class".
              equals(
                key)) {
            return className;
        }
        if ("package".
              equals(
                key)) {
            return getPackageName(
                     );
        }
        if ("".
              equals(
                key) &&
              edu.umd.cs.findbugs.FindBugsDisplayFeatures.
              isAbridgedMessages(
                ) &&
              primaryClass !=
              null) {
            return formatPackageMember(
                     "givenClass",
                     primaryClass);
        }
        return formatPackageMember(
                 key,
                 primaryClass);
    }
    @java.lang.Override
    public void setDescription(java.lang.String description) {
        this.
          description =
          description.
            intern(
              );
    }
    @java.lang.Override
    public java.lang.String getDescription() {
        return description;
    }
    protected static java.lang.String shorten(java.lang.String pkgName,
                                              java.lang.String typeName) {
        int index =
          typeName.
          lastIndexOf(
            '.');
        if (index >=
              0) {
            java.lang.String otherPkg =
              typeName.
              substring(
                0,
                index);
            if (otherPkg.
                  equals(
                    pkgName) ||
                  "java.lang".
                  equals(
                    otherPkg)) {
                typeName =
                  typeName.
                    substring(
                      index +
                        1);
            }
        }
        return typeName;
    }
    protected static java.lang.String removePackage(java.lang.String typeName) {
        int index =
          typeName.
          lastIndexOf(
            '.');
        if (index >=
              0) {
            return typeName.
              substring(
                index +
                  1);
        }
        return typeName;
    }
    protected static java.lang.String removePackageName(java.lang.String typeName) {
        int index =
          typeName.
          lastIndexOf(
            '.');
        if (index >=
              0) {
            typeName =
              typeName.
                substring(
                  index +
                    1);
        }
        return typeName;
    }
    protected abstract java.lang.String formatPackageMember(java.lang.String key,
                                                            edu.umd.cs.findbugs.ClassAnnotation primaryClass);
    @java.lang.Override
    public java.lang.String toString() { return toString(
                                                  null);
    }
    @java.lang.Override
    public java.lang.String toString(edu.umd.cs.findbugs.ClassAnnotation primaryClass) {
        java.lang.String pattern =
          edu.umd.cs.findbugs.I18N.
          instance(
            ).
          getAnnotationDescription(
            description);
        edu.umd.cs.findbugs.FindBugsMessageFormat format =
          new edu.umd.cs.findbugs.FindBugsMessageFormat(
          pattern);
        return format.
          format(
            new edu.umd.cs.findbugs.BugAnnotation[] { this },
            primaryClass);
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
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bLyaF14DSduzUXsDbCykmLwmB3/9nLrf");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("yLNfC0tXcw7qlmsqt2Lgv3wTBpOfGBUXOew9SvttUpZ/e07dK3n2r3dQC5C9" +
       "/enT/v4iUIEP3EwFilO5/CLa9Zv1Knjz9TfrTPLj53jPm/ht4s0fnFP3ap79" +
       "Xli6H/BmfyfsJirw+2+fO3kkL8zdyY/vufDjbyEXDo5bVQ5F/dTNRF0I+NjU" +
       "i8H+9By2/bc8+09h6WJxnSs8w65vvqbLuXp8U4CMFd/X5TflTApVqoH04p6J" +
       "L74BJp7jTG5Ygb93Dk/+Is++C1QpUMLe8flu0ZYvRt+R/UNh6fbY0eVjfv35" +
       "uer139+0m30CpC/sOfOFt4YzJ4BfuOecuvxSw4WLO/vqnTn0PmLAhUtvHwPe" +
       "lRc+BdIv7BnwC2/Uvoq7CjeP0E7a15GSXHjkHH48mmcPhqVLwdrxQ+UsI97x" +
       "JvxpgTS/jPHVPdKvvoVIz1rChWvngHw6zx4PS/f5iuXEyt6vnoH6xJuF+gGQ" +
       "vraH+rW3E2rlHKi1PCuDsPsU1BuXkAvvfxNw8+WhVAXplT3cV74vuH/vdenw" +
       "twpcHzwH84fzrAWCz53zP3WV+gzq9ptAXbiu/AXrG3vU33gDqF+n68LOqRvn" +
       "GQpeqEPnxL3UY2y9t9lr59Bf3UN/9a2BfkK1d2JmzsHP5Rl1a/yztw//g3nh" +
       "EyB9c4//m2+96Ffn1Ml5Btbp+/SA1jVbV3Xp8FumMyv5pZXjmIpoH7PlY28h" +
       "W5Kw9PAtvlTI71w/csNnUbtPeaRfeunynQ+/xPyH4rL+0ec2d+GlO9XINE9e" +
       "Cz3xfNH1FVUv+HbX7pKoWzDDAZZ+k5gRKMbhY073BXvX2g9Ldx+3DksH0qnq" +
       "CLBsXx2WbgP5yUoA9zZQmT+m7mGoWLlZvNqNtGNWcHq43l8W020lSHZR5iMn" +
       "VasIs66+ljM6sQP21Kl9q+IrtcM9pmj3ndpz0pdfGk9/+DvNn9l9WgDelrIs" +
       "H+VOvHRp95VDMWi+T/XkLUc7HOsi9sz37v/KXe893FO7f0fwsZqfoO3xm1/i" +
       "71tuWFy7z/75w7/8wZ996Q+LW7f/Dwd2x4E+OAAA");
}
