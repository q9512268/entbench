package edu.umd.cs.findbugs;
public class Obfuscate {
    static final java.lang.String HASH_SEED = edu.umd.cs.findbugs.SystemProperties.
      getProperty(
        "hashSeed",
        "");
    public static java.lang.String hashData(java.lang.String in) {
        java.security.MessageDigest md;
        try {
            md =
              java.security.MessageDigest.
                getInstance(
                  "SHA-1");
            byte[] hash =
              md.
              digest(
                (HASH_SEED +
                 in).
                  getBytes(
                    "UTF-8"));
            return java.lang.String.
              format(
                "%040x",
                new java.math.BigInteger(
                  1,
                  hash));
        }
        catch (java.lang.RuntimeException e) {
            throw e;
        }
        catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(
              e);
        }
    }
    public static java.lang.String hashFilename(java.lang.String fileName) {
        int lastDot =
          fileName.
          lastIndexOf(
            '.');
        if (lastDot >=
              0) {
            java.lang.String suffix =
              fileName.
              substring(
                lastDot);
            return hashData(
                     fileName.
                       substring(
                         0,
                         lastDot)) +
            suffix;
        }
        return hashData(
                 fileName);
    }
    public static java.lang.String hashClass(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                             java.lang.String className) {
        if (className.
              startsWith(
                "java")) {
            return className;
        }
        return "obfuscated.H" +
        hashData(
          className);
    }
    public static java.lang.String hashSignature(java.lang.String signature) {
        char firstChar =
          signature.
          charAt(
            0);
        switch (firstChar) {
            case '[':
                return '[' +
                hashSignature(
                  signature.
                    substring(
                      1));
            case 'V':
            case 'Z':
            case 'B':
            case 'S':
            case 'C':
            case 'I':
            case 'J':
            case 'D':
            case 'F':
                if (signature.
                      length(
                        ) ==
                      1) {
                    return signature;
                }
                throw new java.lang.IllegalArgumentException(
                  "bad signature: " +
                  signature);
            case 'L':
                if (!signature.
                      endsWith(
                        ";")) {
                    throw new java.lang.IllegalArgumentException(
                      "bad signature: " +
                      signature);
                }
                return hashFieldSignature(
                         signature);
            default:
                throw new java.lang.IllegalArgumentException(
                  "bad signature: " +
                  signature);
        }
    }
    public static java.lang.String hashFieldSignature(java.lang.String signature) {
        signature =
          signature.
            substring(
              1,
              signature.
                length(
                  ) -
                1);
        if (!signature.
              startsWith(
                "java")) {
            signature =
              "obfuscated/H" +
              hashData(
                signature);
        }
        return "L" +
        signature +
        ";";
    }
    public static java.lang.String hashMethodSignature(java.lang.String signature) {
        edu.umd.cs.findbugs.ba.SignatureParser parser =
          new edu.umd.cs.findbugs.ba.SignatureParser(
          signature);
        java.lang.StringBuilder buf =
          new java.lang.StringBuilder(
          "(");
        for (java.util.Iterator<java.lang.String> i =
               parser.
               parameterSignatureIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            java.lang.String param =
              i.
              next(
                );
            buf.
              append(
                hashSignature(
                  param));
        }
        buf.
          append(
            ")");
        buf.
          append(
            hashSignature(
              parser.
                getReturnTypeSignature(
                  )));
        return buf.
          toString(
            );
    }
    static edu.umd.cs.findbugs.MethodAnnotation obfuscate(edu.umd.cs.findbugs.MethodAnnotation m) {
        java.lang.String className =
          m.
          getClassName(
            );
        if (className.
              startsWith(
                "java")) {
            return m;
        }
        java.lang.String methodName =
          m.
          getMethodName(
            );
        java.lang.String methodSignature =
          m.
          getMethodSignature(
            );
        if ("hashCode".
              equals(
                methodName) &&
              "()I".
              equals(
                methodSignature) ||
              "equals".
              equals(
                methodName) &&
              "(Ljava/lang/Object;)Z".
              equals(
                methodSignature) ||
              "compareTo".
              equals(
                methodName) &&
              "(Ljava/lang/Object;)I".
              equals(
                methodSignature) ||
              "<init>".
              equals(
                methodName) ||
              "<clinit>".
              equals(
                methodName)) {
            
        }
        else {
            methodName =
              hashData(
                methodName);
        }
        edu.umd.cs.findbugs.MethodAnnotation result =
          new edu.umd.cs.findbugs.MethodAnnotation(
          hashClass(
            className),
          methodName,
          hashMethodSignature(
            methodSignature),
          m.
            isStatic(
              ));
        result.
          setDescription(
            m.
              getDescription(
                ));
        return result;
    }
    static edu.umd.cs.findbugs.FieldAnnotation obfuscate(edu.umd.cs.findbugs.FieldAnnotation m) {
        edu.umd.cs.findbugs.FieldAnnotation result =
          new edu.umd.cs.findbugs.FieldAnnotation(
          hashClass(
            m.
              getClassName(
                )),
          hashData(
            m.
              getFieldName(
                )),
          hashSignature(
            m.
              getFieldSignature(
                )),
          m.
            isStatic(
              ));
        result.
          setDescription(
            m.
              getDescription(
                ));
        return result;
    }
    static edu.umd.cs.findbugs.ClassAnnotation obfuscate(edu.umd.cs.findbugs.ClassAnnotation m) {
        edu.umd.cs.findbugs.ClassAnnotation result =
          new edu.umd.cs.findbugs.ClassAnnotation(
          hashClass(
            m.
              getClassName(
                )));
        result.
          setDescription(
            m.
              getDescription(
                ));
        return result;
    }
    static edu.umd.cs.findbugs.TypeAnnotation obfuscate(edu.umd.cs.findbugs.TypeAnnotation m) {
        edu.umd.cs.findbugs.TypeAnnotation result =
          new edu.umd.cs.findbugs.TypeAnnotation(
          hashSignature(
            m.
              getTypeDescriptor(
                )));
        result.
          setDescription(
            m.
              getDescription(
                ));
        return result;
    }
    static edu.umd.cs.findbugs.IntAnnotation obfuscate(edu.umd.cs.findbugs.IntAnnotation m) {
        edu.umd.cs.findbugs.IntAnnotation result =
          new edu.umd.cs.findbugs.IntAnnotation(
          m.
            getValue(
              ));
        result.
          setDescription(
            m.
              getDescription(
                ));
        return result;
    }
    static edu.umd.cs.findbugs.StringAnnotation obfuscate(edu.umd.cs.findbugs.StringAnnotation m) {
        edu.umd.cs.findbugs.StringAnnotation result =
          new edu.umd.cs.findbugs.StringAnnotation(
          "obfuscated: " +
          hashData(
            m.
              getValue(
                )));
        result.
          setDescription(
            m.
              getDescription(
                ));
        return result;
    }
    static edu.umd.cs.findbugs.SourceLineAnnotation obfuscate(edu.umd.cs.findbugs.SourceLineAnnotation m) {
        edu.umd.cs.findbugs.SourceLineAnnotation result =
          new edu.umd.cs.findbugs.SourceLineAnnotation(
          hashClass(
            m.
              getClassName(
                )),
          hashFilename(
            m.
              getSourceFile(
                )),
          m.
            getStartLine(
              ),
          m.
            getEndLine(
              ),
          m.
            getStartBytecode(
              ),
          m.
            getEndBytecode(
              ));
        result.
          setDescription(
            m.
              getDescription(
                ));
        return result;
    }
    static edu.umd.cs.findbugs.LocalVariableAnnotation obfuscate(edu.umd.cs.findbugs.LocalVariableAnnotation m) {
        edu.umd.cs.findbugs.LocalVariableAnnotation result =
          new edu.umd.cs.findbugs.LocalVariableAnnotation(
          hashData(
            m.
              getName(
                )),
          m.
            getRegister(
              ),
          m.
            getPC(
              ));
        result.
          setDescription(
            m.
              getDescription(
                ));
        return result;
    }
    public static edu.umd.cs.findbugs.BugInstance obfuscate(edu.umd.cs.findbugs.BugInstance b) {
        final edu.umd.cs.findbugs.BugInstance result =
          new edu.umd.cs.findbugs.BugInstance(
          b.
            getType(
              ),
          b.
            getPriority(
              ));
        edu.umd.cs.findbugs.BugAnnotationVisitor visitor =
          new edu.umd.cs.findbugs.BugAnnotationVisitor(
          ) {
            @java.lang.Override
            public void visitTypeAnnotation(edu.umd.cs.findbugs.TypeAnnotation typeAnnotation) {
                result.
                  add(
                    obfuscate(
                      typeAnnotation));
            }
            @java.lang.Override
            public void visitStringAnnotation(edu.umd.cs.findbugs.StringAnnotation stringAnnotation) {
                result.
                  add(
                    obfuscate(
                      stringAnnotation));
            }
            @java.lang.Override
            public void visitSourceLineAnnotation(edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation) {
                result.
                  add(
                    obfuscate(
                      sourceLineAnnotation));
            }
            @java.lang.Override
            public void visitMethodAnnotation(edu.umd.cs.findbugs.MethodAnnotation methodAnnotation) {
                result.
                  add(
                    obfuscate(
                      methodAnnotation));
            }
            @java.lang.Override
            public void visitLocalVariableAnnotation(edu.umd.cs.findbugs.LocalVariableAnnotation fieldAnnotation) {
                result.
                  add(
                    obfuscate(
                      fieldAnnotation));
            }
            @java.lang.Override
            public void visitIntAnnotation(edu.umd.cs.findbugs.IntAnnotation fieldAnnotation) {
                result.
                  add(
                    obfuscate(
                      fieldAnnotation));
            }
            @java.lang.Override
            public void visitFieldAnnotation(edu.umd.cs.findbugs.FieldAnnotation fieldAnnotation) {
                result.
                  add(
                    obfuscate(
                      fieldAnnotation));
            }
            @java.lang.Override
            public void visitClassAnnotation(edu.umd.cs.findbugs.ClassAnnotation classAnnotation) {
                result.
                  add(
                    obfuscate(
                      classAnnotation));
            }
        };
        for (edu.umd.cs.findbugs.BugAnnotation a
              :
              b.
               getAnnotations(
                 )) {
            a.
              accept(
                visitor);
        }
        result.
          setOldInstanceHash(
            hashData(
              b.
                getInstanceHash(
                  )));
        result.
          setHistory(
            b);
        return result;
    }
    public Obfuscate() { super(); }
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
       "2W/z9x//e+/9W69+Nb/U838BYn6jRJMwAAA=");
}
