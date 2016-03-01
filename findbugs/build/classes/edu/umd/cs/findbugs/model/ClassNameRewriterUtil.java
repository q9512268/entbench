package edu.umd.cs.findbugs.model;
public abstract class ClassNameRewriterUtil {
    public static java.lang.String rewriteMethodSignature(edu.umd.cs.findbugs.model.ClassNameRewriter classNameRewriter,
                                                          java.lang.String methodSignature) {
        if (classNameRewriter !=
              edu.umd.cs.findbugs.model.IdentityClassNameRewriter.
              instance(
                )) {
            edu.umd.cs.findbugs.ba.SignatureParser parser =
              new edu.umd.cs.findbugs.ba.SignatureParser(
              methodSignature);
            java.lang.StringBuilder buf =
              new java.lang.StringBuilder(
              );
            buf.
              append(
                '(');
            for (java.util.Iterator<java.lang.String> i =
                   parser.
                   parameterSignatureIterator(
                     );
                 i.
                   hasNext(
                     );
                 ) {
                buf.
                  append(
                    rewriteSignature(
                      classNameRewriter,
                      i.
                        next(
                          )));
            }
            buf.
              append(
                ')');
            buf.
              append(
                rewriteSignature(
                  classNameRewriter,
                  parser.
                    getReturnTypeSignature(
                      )));
            methodSignature =
              buf.
                toString(
                  );
        }
        return methodSignature;
    }
    public static java.lang.String rewriteSignature(edu.umd.cs.findbugs.model.ClassNameRewriter classNameRewriter,
                                                    java.lang.String signature) {
        if (classNameRewriter !=
              edu.umd.cs.findbugs.model.IdentityClassNameRewriter.
              instance(
                ) &&
              signature.
              startsWith(
                "L")) {
            java.lang.String className =
              signature.
              substring(
                1,
                signature.
                  length(
                    ) -
                  1).
              replace(
                '/',
                '.');
            className =
              classNameRewriter.
                rewriteClassName(
                  className);
            signature =
              "L" +
              className.
                replace(
                  '.',
                  '/') +
              ";";
        }
        return signature;
    }
    public static edu.umd.cs.findbugs.MethodAnnotation convertMethodAnnotation(edu.umd.cs.findbugs.model.ClassNameRewriter classNameRewriter,
                                                                               edu.umd.cs.findbugs.MethodAnnotation annotation) {
        if (classNameRewriter !=
              edu.umd.cs.findbugs.model.IdentityClassNameRewriter.
              instance(
                )) {
            annotation =
              new edu.umd.cs.findbugs.MethodAnnotation(
                classNameRewriter.
                  rewriteClassName(
                    annotation.
                      getClassName(
                        )),
                annotation.
                  getMethodName(
                    ),
                rewriteMethodSignature(
                  classNameRewriter,
                  annotation.
                    getMethodSignature(
                      )),
                annotation.
                  isStatic(
                    ));
        }
        return annotation;
    }
    public static edu.umd.cs.findbugs.FieldAnnotation convertFieldAnnotation(edu.umd.cs.findbugs.model.ClassNameRewriter classNameRewriter,
                                                                             edu.umd.cs.findbugs.FieldAnnotation annotation) {
        if (classNameRewriter !=
              edu.umd.cs.findbugs.model.IdentityClassNameRewriter.
              instance(
                )) {
            annotation =
              new edu.umd.cs.findbugs.FieldAnnotation(
                classNameRewriter.
                  rewriteClassName(
                    annotation.
                      getClassName(
                        )),
                annotation.
                  getFieldName(
                    ),
                rewriteSignature(
                  classNameRewriter,
                  annotation.
                    getFieldSignature(
                      )),
                annotation.
                  isStatic(
                    ));
        }
        return annotation;
    }
    public ClassNameRewriterUtil() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/wtd8dNy/yIAAA==");
}
