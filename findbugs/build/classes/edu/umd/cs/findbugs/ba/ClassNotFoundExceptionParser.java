package edu.umd.cs.findbugs.ba;
public class ClassNotFoundExceptionParser {
    private static final java.util.regex.Pattern BCEL_MISSING_CLASS_PATTERN =
      java.util.regex.Pattern.
      compile(
        "^.*while looking for class ([^:]*):.*$");
    private static final java.util.regex.Pattern TYPE_REPOSITORY_MISSING_CLASS_PATTERN =
      java.util.regex.Pattern.
      compile(
        "^Class ([^ ]*) cannot be resolved.*$");
    private static final java.util.regex.Pattern[] patternList;
    static { java.util.ArrayList<java.util.regex.Pattern> list = new java.util.ArrayList<java.util.regex.Pattern>(
               );
             list.add(BCEL_MISSING_CLASS_PATTERN);
             list.add(TYPE_REPOSITORY_MISSING_CLASS_PATTERN);
             patternList = list.toArray(new java.util.regex.Pattern[list.
                                                                      size(
                                                                        )]);
    }
    @edu.umd.cs.findbugs.internalAnnotations.DottedClassName
    public static java.lang.String getMissingClassName(java.lang.ClassNotFoundException ex) {
        java.lang.Throwable cause =
          ex.
          getCause(
            );
        if (cause instanceof edu.umd.cs.findbugs.classfile.ResourceNotFoundException) {
            java.lang.String resourceName =
              ((edu.umd.cs.findbugs.classfile.ResourceNotFoundException)
                 cause).
              getResourceName(
                );
            if (resourceName !=
                  null) {
                edu.umd.cs.findbugs.classfile.ClassDescriptor classDesc =
                  edu.umd.cs.findbugs.classfile.DescriptorFactory.
                  createClassDescriptorFromResourceName(
                    resourceName);
                return classDesc.
                  toDottedClassName(
                    );
            }
        }
        if (ex.
              getMessage(
                ) ==
              null) {
            return null;
        }
        for (java.util.regex.Pattern pattern
              :
              patternList) {
            java.util.regex.Matcher matcher =
              pattern.
              matcher(
                ex.
                  getMessage(
                    ));
            if (matcher.
                  matches(
                    )) {
                java.lang.String className =
                  matcher.
                  group(
                    1);
                edu.umd.cs.findbugs.util.ClassName.
                  assertIsDotted(
                    className);
                return className;
            }
        }
        return null;
    }
    public ClassNotFoundExceptionParser() {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "w/f/AzSjfE71GQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "x69+Iz9M/R/02gKtfyUAAA==");
}
