package edu.umd.cs.findbugs.ba;
public class JavaClassAndMethod {
    private final org.apache.bcel.classfile.JavaClass javaClass;
    private final org.apache.bcel.classfile.Method method;
    public JavaClassAndMethod(org.apache.bcel.classfile.JavaClass javaClass,
                              org.apache.bcel.classfile.Method method) { super(
                                                                           );
                                                                         this.
                                                                           javaClass =
                                                                           javaClass;
                                                                         this.
                                                                           method =
                                                                           method;
    }
    public JavaClassAndMethod(edu.umd.cs.findbugs.ba.XMethod method)
          throws java.lang.ClassNotFoundException {
        super(
          );
        this.
          javaClass =
          org.apache.bcel.Repository.
            lookupClass(
              method.
                getClassName(
                  ));
        for (org.apache.bcel.classfile.Method m
              :
              javaClass.
               getMethods(
                 )) {
            if (m.
                  getName(
                    ).
                  equals(
                    method.
                      getName(
                        )) &&
                  m.
                  getSignature(
                    ).
                  equals(
                    method.
                      getSignature(
                        )) &&
                  m.
                  isStatic(
                    ) ==
                  method.
                  isStatic(
                    )) {
                this.
                  method =
                  m;
                return;
            }
        }
        throw new java.lang.IllegalArgumentException(
          "Can\'t find " +
          method);
    }
    public org.apache.bcel.classfile.JavaClass getJavaClass() {
        return javaClass;
    }
    public org.apache.bcel.classfile.Method getMethod() {
        return method;
    }
    public edu.umd.cs.findbugs.ba.XMethod toXMethod() {
        return edu.umd.cs.findbugs.ba.XFactory.
          createXMethod(
            javaClass,
            method);
    }
    public edu.umd.cs.findbugs.classfile.MethodDescriptor toMethodDescriptor() {
        return edu.umd.cs.findbugs.classfile.DescriptorFactory.
          instance(
            ).
          getMethodDescriptor(
            getSlashedClassName(
              ),
            method.
              getName(
                ),
            method.
              getSignature(
                ),
            method.
              isStatic(
                ));
    }
    private java.lang.String getSlashedClassName() {
        return javaClass.
          getConstantPool(
            ).
          getConstantString(
            javaClass.
              getClassNameIndex(
                ),
            org.apache.bcel.Constants.
              CONSTANT_Class);
    }
    @java.lang.Override
    public int hashCode() { return javaClass.hashCode(
                                               ) +
                              method.
                              hashCode(
                                ); }
    @java.lang.Override
    public boolean equals(java.lang.Object obj) {
        if (obj ==
              null ||
              obj.
              getClass(
                ) !=
              this.
              getClass(
                )) {
            return false;
        }
        edu.umd.cs.findbugs.ba.JavaClassAndMethod other =
          (edu.umd.cs.findbugs.ba.JavaClassAndMethod)
            obj;
        return javaClass.
          equals(
            other.
              javaClass) &&
          method.
          equals(
            other.
              method);
    }
    @java.lang.Override
    public java.lang.String toString() { return edu.umd.cs.findbugs.ba.SignatureConverter.
                                           convertMethodSignature(
                                             javaClass,
                                             method);
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
      ("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" +
       "y/c5u3/8xJe//x+89vvlpen/A+7QzExeLAAA");
}
