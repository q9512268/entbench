package edu.umd.cs.findbugs.classfile.engine;
@java.lang.Deprecated
public class ClassParserUsingBCEL implements edu.umd.cs.findbugs.classfile.engine.ClassParserInterface {
    private final org.apache.bcel.classfile.JavaClass javaClass;
    private final java.lang.String slashedClassName;
    private final edu.umd.cs.findbugs.classfile.ClassDescriptor expectedClassDescriptor;
    private final edu.umd.cs.findbugs.classfile.ICodeBaseEntry codeBaseEntry;
    public ClassParserUsingBCEL(org.apache.bcel.classfile.JavaClass javaClass,
                                @javax.annotation.CheckForNull
                                edu.umd.cs.findbugs.classfile.ClassDescriptor expectedClassDescriptor,
                                edu.umd.cs.findbugs.classfile.ICodeBaseEntry codeBaseEntry) {
        super(
          );
        this.
          javaClass =
          javaClass;
        this.
          slashedClassName =
          javaClass.
            getClassName(
              ).
            replace(
              '.',
              '/');
        this.
          expectedClassDescriptor =
          expectedClassDescriptor;
        this.
          codeBaseEntry =
          codeBaseEntry;
    }
    @java.lang.Override
    public void parse(final edu.umd.cs.findbugs.classfile.analysis.ClassNameAndSuperclassInfo.Builder builder)
          throws edu.umd.cs.findbugs.classfile.InvalidClassFileFormatException {
        builder.
          setCodeBaseEntry(
            codeBaseEntry);
        builder.
          setAccessFlags(
            javaClass.
              getAccessFlags(
                ));
        edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          createClassDescriptorFromDottedClassName(
            javaClass.
              getClassName(
                ));
        if (expectedClassDescriptor !=
              null &&
              expectedClassDescriptor.
              equals(
                classDescriptor)) {
            throw new edu.umd.cs.findbugs.classfile.InvalidClassFileFormatException(
              "Expected " +
              expectedClassDescriptor,
              classDescriptor,
              codeBaseEntry);
        }
        builder.
          setClassDescriptor(
            classDescriptor);
        builder.
          setSuperclassDescriptor(
            edu.umd.cs.findbugs.classfile.DescriptorFactory.
              createClassDescriptorFromDottedClassName(
                javaClass.
                  getSuperclassName(
                    )));
        java.lang.String[] allInterfaces =
          javaClass.
          getInterfaceNames(
            );
        edu.umd.cs.findbugs.classfile.ClassDescriptor[] allInterfaceDescriptiors;
        if (allInterfaces.
              length ==
              0) {
            allInterfaceDescriptiors =
              edu.umd.cs.findbugs.classfile.ClassDescriptor.
                EMPTY_ARRAY;
        }
        else {
            allInterfaceDescriptiors =
              (new edu.umd.cs.findbugs.classfile.ClassDescriptor[allInterfaces.
                                                                   length]);
            for (int i =
                   0;
                 i <
                   allInterfaces.
                     length;
                 i++) {
                allInterfaceDescriptiors[i] =
                  edu.umd.cs.findbugs.classfile.DescriptorFactory.
                    createClassDescriptorFromDottedClassName(
                      allInterfaces[i]);
            }
        }
        builder.
          setInterfaceDescriptorList(
            allInterfaceDescriptiors);
    }
    @java.lang.Override
    public void parse(edu.umd.cs.findbugs.classfile.analysis.ClassInfo.Builder builder)
          throws edu.umd.cs.findbugs.classfile.InvalidClassFileFormatException {
        parse(
          (edu.umd.cs.findbugs.classfile.analysis.ClassNameAndSuperclassInfo.Builder)
            builder);
        final java.util.List<edu.umd.cs.findbugs.classfile.FieldDescriptor> fieldDescriptorList =
          new java.util.LinkedList<edu.umd.cs.findbugs.classfile.FieldDescriptor>(
          );
        final java.util.List<edu.umd.cs.findbugs.classfile.MethodDescriptor> methodDescriptorList =
          new java.util.LinkedList<edu.umd.cs.findbugs.classfile.MethodDescriptor>(
          );
        final java.util.TreeSet<edu.umd.cs.findbugs.classfile.ClassDescriptor> referencedClassSet =
          new java.util.TreeSet<edu.umd.cs.findbugs.classfile.ClassDescriptor>(
          );
        javaClass.
          accept(
            new edu.umd.cs.findbugs.visitclass.AnnotationVisitor(
              ) {
                @java.lang.Override
                public void visit(org.apache.bcel.classfile.Method obj) {
                    methodDescriptorList.
                      add(
                        parseMethod(
                          obj));
                }
                @java.lang.Override
                public void visit(org.apache.bcel.classfile.Field obj) {
                    fieldDescriptorList.
                      add(
                        parseField(
                          obj));
                }
                @java.lang.Override
                public void visit(org.apache.bcel.classfile.ConstantClass obj) {
                    java.lang.String className =
                      obj.
                      getBytes(
                        javaClass.
                          getConstantPool(
                            ));
                    if (className.
                          indexOf(
                            '[') >=
                          0) {
                        edu.umd.cs.findbugs.classfile.engine.ClassParser.
                          extractReferencedClassesFromSignature(
                            referencedClassSet,
                            className);
                    }
                    else
                        if (edu.umd.cs.findbugs.util.ClassName.
                              isValidClassName(
                                className)) {
                            referencedClassSet.
                              add(
                                edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                  instance(
                                    ).
                                  getClassDescriptor(
                                    className));
                        }
                }
                @java.lang.Override
                public void visit(org.apache.bcel.classfile.ConstantNameAndType obj) {
                    java.lang.String signature =
                      obj.
                      getSignature(
                        javaClass.
                          getConstantPool(
                            ));
                    edu.umd.cs.findbugs.classfile.engine.ClassParser.
                      extractReferencedClassesFromSignature(
                        referencedClassSet,
                        signature);
                }
            });
    }
    protected edu.umd.cs.findbugs.classfile.FieldDescriptor parseField(org.apache.bcel.classfile.Field obj) {
        return new edu.umd.cs.findbugs.classfile.FieldDescriptor(
          slashedClassName,
          obj.
            getName(
              ),
          obj.
            getSignature(
              ),
          obj.
            isStatic(
              ));
    }
    protected edu.umd.cs.findbugs.classfile.MethodDescriptor parseMethod(org.apache.bcel.classfile.Method obj) {
        return new edu.umd.cs.findbugs.classfile.MethodDescriptor(
          slashedClassName,
          obj.
            getName(
              ),
          obj.
            getSignature(
              ),
          obj.
            isStatic(
              ));
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
      ("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");
}
