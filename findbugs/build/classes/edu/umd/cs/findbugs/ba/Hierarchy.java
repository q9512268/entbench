package edu.umd.cs.findbugs.ba;
public class Hierarchy {
    protected static final boolean DEBUG_METHOD_LOOKUP = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "hier.lookup.debug");
    public static edu.umd.cs.findbugs.classfile.ClassDescriptor RUNTIME_EXCEPTION =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.lang.RuntimeException.class);
    public static edu.umd.cs.findbugs.classfile.ClassDescriptor
      EXCEPTION =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.lang.Exception.class);
    public static edu.umd.cs.findbugs.classfile.ClassDescriptor
      ERROR =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.lang.Error.class);
    public static final org.apache.bcel.generic.ObjectType
      EXCEPTION_TYPE =
      edu.umd.cs.findbugs.ba.ObjectTypeFactory.
      getInstance(
        "java.lang.Exception");
    public static final org.apache.bcel.generic.ObjectType
      ERROR_TYPE =
      edu.umd.cs.findbugs.ba.ObjectTypeFactory.
      getInstance(
        "java.lang.Error");
    public static final org.apache.bcel.generic.ObjectType
      RUNTIME_EXCEPTION_TYPE =
      edu.umd.cs.findbugs.ba.ObjectTypeFactory.
      getInstance(
        "java.lang.RuntimeException");
    public static boolean isSubtype(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                    java.lang.String clsName,
                                    @edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                    java.lang.String possibleSupertypeClassName)
          throws java.lang.ClassNotFoundException { edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
                                                      edu.umd.cs.findbugs.classfile.Global.
                                                      getAnalysisCache(
                                                        ).
                                                      getDatabase(
                                                        edu.umd.cs.findbugs.ba.ch.Subtypes2.class);
                                                    return subtypes2.
                                                      isSubtype(
                                                        edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                          createClassDescriptorFromDottedClassName(
                                                            clsName),
                                                        edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                          createClassDescriptorFromDottedClassName(
                                                            possibleSupertypeClassName));
    }
    public static boolean isSubtype(org.apache.bcel.generic.ReferenceType t,
                                    org.apache.bcel.generic.ReferenceType possibleSupertype)
          throws java.lang.ClassNotFoundException {
        return edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          getDatabase(
            edu.umd.cs.findbugs.ba.ch.Subtypes2.class).
          isSubtype(
            t,
            possibleSupertype);
    }
    public static boolean isUniversalExceptionHandler(org.apache.bcel.generic.ObjectType catchType) {
        return catchType ==
          null ||
          catchType.
          equals(
            org.apache.bcel.generic.Type.
              THROWABLE);
    }
    public static boolean isUncheckedException(org.apache.bcel.generic.ObjectType type)
          throws java.lang.ClassNotFoundException {
        if (type.
              equals(
                org.apache.bcel.generic.Type.
                  THROWABLE) ||
              type.
              equals(
                RUNTIME_EXCEPTION_TYPE) ||
              type.
              equals(
                ERROR_TYPE)) {
            return true;
        }
        edu.umd.cs.findbugs.classfile.ClassDescriptor c =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          getClassDescriptor(
            type);
        edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          getDatabase(
            edu.umd.cs.findbugs.ba.ch.Subtypes2.class);
        return subtypes2.
          isSubtype(
            c,
            RUNTIME_EXCEPTION,
            ERROR);
    }
    public static boolean isMonitorWait(java.lang.String methodName,
                                        java.lang.String methodSig) {
        return "wait".
          equals(
            methodName) &&
          ("()V".
             equals(
               methodSig) ||
             "(J)V".
             equals(
               methodSig) ||
             "(JI)V".
             equals(
               methodSig));
    }
    public static boolean isMonitorWait(org.apache.bcel.generic.Instruction ins,
                                        org.apache.bcel.generic.ConstantPoolGen cpg) {
        if (!(ins instanceof org.apache.bcel.generic.InvokeInstruction)) {
            return false;
        }
        if (ins.
              getOpcode(
                ) ==
              org.apache.bcel.Constants.
                INVOKESTATIC) {
            return false;
        }
        org.apache.bcel.generic.InvokeInstruction inv =
          (org.apache.bcel.generic.InvokeInstruction)
            ins;
        java.lang.String methodName =
          inv.
          getMethodName(
            cpg);
        java.lang.String methodSig =
          inv.
          getSignature(
            cpg);
        return isMonitorWait(
                 methodName,
                 methodSig);
    }
    public static boolean isMonitorNotify(java.lang.String methodName,
                                          java.lang.String methodSig) {
        return ("notify".
                  equals(
                    methodName) ||
                  "notifyAll".
                  equals(
                    methodName)) &&
          "()V".
          equals(
            methodSig);
    }
    public static boolean isMonitorNotify(org.apache.bcel.generic.Instruction ins,
                                          org.apache.bcel.generic.ConstantPoolGen cpg) {
        if (!(ins instanceof org.apache.bcel.generic.InvokeInstruction)) {
            return false;
        }
        if (ins.
              getOpcode(
                ) ==
              org.apache.bcel.Constants.
                INVOKESTATIC) {
            return false;
        }
        org.apache.bcel.generic.InvokeInstruction inv =
          (org.apache.bcel.generic.InvokeInstruction)
            ins;
        java.lang.String methodName =
          inv.
          getMethodName(
            cpg);
        java.lang.String methodSig =
          inv.
          getSignature(
            cpg);
        return isMonitorNotify(
                 methodName,
                 methodSig);
    }
    public static edu.umd.cs.findbugs.ba.JavaClassAndMethod findExactMethod(org.apache.bcel.generic.InvokeInstruction inv,
                                                                            org.apache.bcel.generic.ConstantPoolGen cpg)
          throws java.lang.ClassNotFoundException {
        return findExactMethod(
                 inv,
                 cpg,
                 ANY_METHOD);
    }
    public static edu.umd.cs.findbugs.ba.JavaClassAndMethod findExactMethod(org.apache.bcel.generic.InvokeInstruction inv,
                                                                            org.apache.bcel.generic.ConstantPoolGen cpg,
                                                                            edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser chooser)
          throws java.lang.ClassNotFoundException {
        java.lang.String className =
          inv.
          getClassName(
            cpg);
        java.lang.String methodName =
          inv.
          getName(
            cpg);
        java.lang.String methodSig =
          inv.
          getSignature(
            cpg);
        org.apache.bcel.classfile.JavaClass jclass =
          org.apache.bcel.Repository.
          lookupClass(
            className);
        return findMethod(
                 jclass,
                 methodName,
                 methodSig,
                 chooser);
    }
    public static edu.umd.cs.findbugs.ba.JavaClassAndMethod visitSuperClassMethods(edu.umd.cs.findbugs.ba.JavaClassAndMethod method,
                                                                                   edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser chooser)
          throws java.lang.ClassNotFoundException {
        return findMethod(
                 method.
                   getJavaClass(
                     ).
                   getSuperClasses(
                     ),
                 method.
                   getMethod(
                     ).
                   getName(
                     ),
                 method.
                   getMethod(
                     ).
                   getSignature(
                     ),
                 chooser);
    }
    public static edu.umd.cs.findbugs.ba.JavaClassAndMethod visitSuperInterfaceMethods(edu.umd.cs.findbugs.ba.JavaClassAndMethod method,
                                                                                       edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser chooser)
          throws java.lang.ClassNotFoundException {
        return findMethod(
                 method.
                   getJavaClass(
                     ).
                   getAllInterfaces(
                     ),
                 method.
                   getMethod(
                     ).
                   getName(
                     ),
                 method.
                   getMethod(
                     ).
                   getSignature(
                     ),
                 chooser);
    }
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.ba.JavaClassAndMethod findInvocationLeastUpperBound(org.apache.bcel.generic.InvokeInstruction inv,
                                                                                          org.apache.bcel.generic.ConstantPoolGen cpg)
          throws java.lang.ClassNotFoundException {
        return findInvocationLeastUpperBound(
                 inv,
                 cpg,
                 ANY_METHOD);
    }
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.ba.JavaClassAndMethod findInvocationLeastUpperBound(org.apache.bcel.generic.InvokeInstruction inv,
                                                                                          org.apache.bcel.generic.ConstantPoolGen cpg,
                                                                                          edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser methodChooser)
          throws java.lang.ClassNotFoundException {
        if (DEBUG_METHOD_LOOKUP) {
            java.lang.System.
              out.
              println(
                "Find prototype method for " +
                edu.umd.cs.findbugs.ba.SignatureConverter.
                  convertMethodSignature(
                    inv,
                    cpg));
        }
        short opcode =
          inv.
          getOpcode(
            );
        if (opcode ==
              org.apache.bcel.Constants.
                INVOKESTATIC) {
            if (methodChooser ==
                  INSTANCE_METHOD) {
                return null;
            }
        }
        else {
            if (methodChooser ==
                  STATIC_METHOD) {
                return null;
            }
        }
        if (opcode ==
              org.apache.bcel.Constants.
                INVOKESPECIAL) {
            return findExactMethod(
                     inv,
                     cpg,
                     methodChooser);
        }
        else {
            java.lang.String className =
              inv.
              getClassName(
                cpg);
            java.lang.String methodName =
              inv.
              getName(
                cpg);
            java.lang.String methodSig =
              inv.
              getSignature(
                cpg);
            if (DEBUG_METHOD_LOOKUP) {
                java.lang.System.
                  out.
                  println(
                    "[Class name is " +
                    className +
                    "]");
                java.lang.System.
                  out.
                  println(
                    "[Method name is " +
                    methodName +
                    "]");
                java.lang.System.
                  out.
                  println(
                    "[Method signature is " +
                    methodSig +
                    "]");
            }
            if (className.
                  startsWith(
                    "[")) {
                className =
                  "java.lang.Object";
            }
            org.apache.bcel.classfile.JavaClass jClass =
              org.apache.bcel.Repository.
              lookupClass(
                className);
            return findInvocationLeastUpperBound(
                     jClass,
                     methodName,
                     methodSig,
                     methodChooser,
                     opcode ==
                       org.apache.bcel.Constants.
                         INVOKEINTERFACE);
        }
    }
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.ba.JavaClassAndMethod findInvocationLeastUpperBound(org.apache.bcel.classfile.JavaClass jClass,
                                                                                          java.lang.String methodName,
                                                                                          java.lang.String methodSig,
                                                                                          edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser methodChooser,
                                                                                          boolean invokeInterface)
          throws java.lang.ClassNotFoundException {
        edu.umd.cs.findbugs.ba.JavaClassAndMethod result =
          findMethod(
            jClass,
            methodName,
            methodSig,
            methodChooser);
        if (result !=
              null) {
            return result;
        }
        if (invokeInterface) {
            for (org.apache.bcel.classfile.JavaClass i
                  :
                  jClass.
                   getInterfaces(
                     )) {
                result =
                  findInvocationLeastUpperBound(
                    i,
                    methodName,
                    methodSig,
                    methodChooser,
                    invokeInterface);
                if (result !=
                      null) {
                    return null;
                }
            }
        }
        else {
            org.apache.bcel.classfile.JavaClass sClass =
              jClass.
              getSuperClass(
                );
            if (sClass !=
                  null) {
                return findInvocationLeastUpperBound(
                         sClass,
                         methodName,
                         methodSig,
                         methodChooser,
                         invokeInterface);
            }
        }
        return null;
    }
    @java.lang.Deprecated
    public static org.apache.bcel.generic.ObjectType[] findDeclaredExceptions(org.apache.bcel.generic.InvokeInstruction inv,
                                                                              org.apache.bcel.generic.ConstantPoolGen cpg) {
        return edu.umd.cs.findbugs.ba.Hierarchy2.
          findDeclaredExceptions(
            inv,
            cpg);
    }
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.ba.JavaClassAndMethod findMethod(org.apache.bcel.classfile.JavaClass javaClass,
                                                                       java.lang.String methodName,
                                                                       java.lang.String methodSig) {
        return findMethod(
                 javaClass,
                 methodName,
                 methodSig,
                 ANY_METHOD);
    }
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.ba.JavaClassAndMethod findMethod(org.apache.bcel.classfile.JavaClass javaClass,
                                                                       java.lang.String methodName,
                                                                       java.lang.String methodSig,
                                                                       edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser chooser) {
        if (DEBUG_METHOD_LOOKUP) {
            java.lang.System.
              out.
              println(
                "Check " +
                javaClass.
                  getClassName(
                    ));
        }
        org.apache.bcel.classfile.Method[] methodList =
          javaClass.
          getMethods(
            );
        for (org.apache.bcel.classfile.Method method
              :
              methodList) {
            if (method.
                  getName(
                    ).
                  equals(
                    methodName) &&
                  method.
                  getSignature(
                    ).
                  equals(
                    methodSig)) {
                edu.umd.cs.findbugs.ba.JavaClassAndMethod m =
                  new edu.umd.cs.findbugs.ba.JavaClassAndMethod(
                  javaClass,
                  method);
                if (chooser.
                      choose(
                        m)) {
                    if (DEBUG_METHOD_LOOKUP) {
                        java.lang.System.
                          out.
                          println(
                            "\t==> FOUND: " +
                            method);
                    }
                    return m;
                }
            }
        }
        if (DEBUG_METHOD_LOOKUP) {
            java.lang.System.
              out.
              println(
                "\t==> NOT FOUND");
        }
        return null;
    }
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.ba.XMethod findMethod(edu.umd.cs.findbugs.classfile.ClassDescriptor classDesc,
                                                            java.lang.String methodName,
                                                            java.lang.String methodSig,
                                                            boolean isStatic) {
        if (DEBUG_METHOD_LOOKUP) {
            java.lang.System.
              out.
              println(
                "Check " +
                classDesc.
                  getClassName(
                    ));
        }
        try {
            edu.umd.cs.findbugs.ba.XClass xClass =
              edu.umd.cs.findbugs.classfile.Global.
              getAnalysisCache(
                ).
              getClassAnalysis(
                edu.umd.cs.findbugs.ba.XClass.class,
                classDesc);
            return xClass.
              findMethod(
                methodName,
                methodSig,
                isStatic);
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Error looking for " +
                classDesc +
                "." +
                methodName +
                methodSig,
                e);
            return null;
        }
    }
    @java.lang.Deprecated
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.ba.JavaClassAndMethod findConcreteMethod(org.apache.bcel.classfile.JavaClass javaClass,
                                                                               java.lang.String methodName,
                                                                               java.lang.String methodSig) {
        if (DEBUG_METHOD_LOOKUP) {
            java.lang.System.
              out.
              println(
                "Check " +
                javaClass.
                  getClassName(
                    ));
        }
        org.apache.bcel.classfile.Method[] methodList =
          javaClass.
          getMethods(
            );
        for (org.apache.bcel.classfile.Method method
              :
              methodList) {
            if (method.
                  getName(
                    ).
                  equals(
                    methodName) &&
                  method.
                  getSignature(
                    ).
                  equals(
                    methodSig) &&
                  accessFlagsAreConcrete(
                    method.
                      getAccessFlags(
                        ))) {
                edu.umd.cs.findbugs.ba.JavaClassAndMethod m =
                  new edu.umd.cs.findbugs.ba.JavaClassAndMethod(
                  javaClass,
                  method);
                return m;
            }
        }
        if (DEBUG_METHOD_LOOKUP) {
            java.lang.System.
              out.
              println(
                "\t==> NOT FOUND");
        }
        return null;
    }
    @java.lang.Deprecated
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.ba.XMethod findXMethod(org.apache.bcel.classfile.JavaClass javaClass,
                                                             java.lang.String methodName,
                                                             java.lang.String methodSig,
                                                             edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser chooser) {
        edu.umd.cs.findbugs.ba.JavaClassAndMethod result =
          findMethod(
            javaClass,
            methodName,
            methodSig,
            chooser);
        return result ==
          null
          ? null
          : edu.umd.cs.findbugs.ba.XFactory.
          createXMethod(
            result.
              getJavaClass(
                ),
            result.
              getMethod(
                ));
    }
    public static final edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser
      ANY_METHOD =
      new edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser(
      ) {
        @java.lang.Override
        public boolean choose(edu.umd.cs.findbugs.ba.JavaClassAndMethod javaClassAndMethod) {
            return true;
        }
        @java.lang.Override
        public boolean choose(edu.umd.cs.findbugs.ba.XMethod method) {
            return true;
        }
    };
    public static boolean accessFlagsAreConcrete(int accessFlags) {
        return (accessFlags &
                  org.apache.bcel.Constants.
                    ACC_ABSTRACT) ==
          0 &&
          (accessFlags &
             org.apache.bcel.Constants.
               ACC_NATIVE) ==
          0;
    }
    public static final edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser
      CONCRETE_METHOD =
      new edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser(
      ) {
        @java.lang.Override
        public boolean choose(edu.umd.cs.findbugs.ba.JavaClassAndMethod javaClassAndMethod) {
            org.apache.bcel.classfile.Method method =
              javaClassAndMethod.
              getMethod(
                );
            int accessFlags =
              method.
              getAccessFlags(
                );
            return accessFlagsAreConcrete(
                     accessFlags);
        }
        @java.lang.Override
        public boolean choose(edu.umd.cs.findbugs.ba.XMethod method) {
            return accessFlagsAreConcrete(
                     method.
                       getAccessFlags(
                         ));
        }
    };
    public static final edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser
      STATIC_METHOD =
      new edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser(
      ) {
        @java.lang.Override
        public boolean choose(edu.umd.cs.findbugs.ba.JavaClassAndMethod javaClassAndMethod) {
            return javaClassAndMethod.
              getMethod(
                ).
              isStatic(
                );
        }
        @java.lang.Override
        public boolean choose(edu.umd.cs.findbugs.ba.XMethod method) {
            return method.
              isStatic(
                );
        }
    };
    public static final edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser
      INSTANCE_METHOD =
      new edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser(
      ) {
        @java.lang.Override
        public boolean choose(edu.umd.cs.findbugs.ba.JavaClassAndMethod javaClassAndMethod) {
            return !javaClassAndMethod.
              getMethod(
                ).
              isStatic(
                );
        }
        @java.lang.Override
        public boolean choose(edu.umd.cs.findbugs.ba.XMethod method) {
            return !method.
              isStatic(
                );
        }
    };
    @java.lang.Deprecated
    public static edu.umd.cs.findbugs.ba.JavaClassAndMethod findMethod(org.apache.bcel.classfile.JavaClass[] classList,
                                                                       java.lang.String methodName,
                                                                       java.lang.String methodSig) {
        return findMethod(
                 classList,
                 methodName,
                 methodSig,
                 ANY_METHOD);
    }
    public static edu.umd.cs.findbugs.ba.JavaClassAndMethod findMethod(org.apache.bcel.classfile.JavaClass[] classList,
                                                                       java.lang.String methodName,
                                                                       java.lang.String methodSig,
                                                                       edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser chooser) {
        edu.umd.cs.findbugs.ba.JavaClassAndMethod m =
          null;
        for (org.apache.bcel.classfile.JavaClass cls
              :
              classList) {
            if ((m =
                   findMethod(
                     cls,
                     methodName,
                     methodSig,
                     chooser)) !=
                  null) {
                break;
            }
        }
        return m;
    }
    @java.lang.Deprecated
    public static edu.umd.cs.findbugs.ba.XMethod findXMethod(org.apache.bcel.classfile.JavaClass[] classList,
                                                             java.lang.String methodName,
                                                             java.lang.String methodSig) {
        return findXMethod(
                 classList,
                 methodName,
                 methodSig,
                 ANY_METHOD);
    }
    @java.lang.Deprecated
    public static edu.umd.cs.findbugs.ba.XMethod findXMethod(org.apache.bcel.classfile.JavaClass[] classList,
                                                             java.lang.String methodName,
                                                             java.lang.String methodSig,
                                                             edu.umd.cs.findbugs.ba.JavaClassAndMethodChooser chooser) {
        for (org.apache.bcel.classfile.JavaClass cls
              :
              classList) {
            edu.umd.cs.findbugs.ba.JavaClassAndMethod m;
            if ((m =
                   findMethod(
                     cls,
                     methodName,
                     methodSig)) !=
                  null &&
                  chooser.
                  choose(
                    m)) {
                return edu.umd.cs.findbugs.ba.XFactory.
                  createXMethod(
                    cls,
                    m.
                      getMethod(
                        ));
            }
        }
        return null;
    }
    public static java.util.Set<edu.umd.cs.findbugs.ba.JavaClassAndMethod> resolveMethodCallTargets(org.apache.bcel.generic.InvokeInstruction invokeInstruction,
                                                                                                    edu.umd.cs.findbugs.ba.type.TypeFrame typeFrame,
                                                                                                    org.apache.bcel.generic.ConstantPoolGen cpg)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        java.lang.ClassNotFoundException {
        short opcode =
          invokeInstruction.
          getOpcode(
            );
        if (opcode ==
              org.apache.bcel.Constants.
                INVOKESTATIC) {
            java.util.HashSet<edu.umd.cs.findbugs.ba.JavaClassAndMethod> result =
              new java.util.HashSet<edu.umd.cs.findbugs.ba.JavaClassAndMethod>(
              );
            edu.umd.cs.findbugs.ba.JavaClassAndMethod targetMethod =
              findInvocationLeastUpperBound(
                invokeInstruction,
                cpg,
                CONCRETE_METHOD);
            if (targetMethod !=
                  null) {
                result.
                  add(
                    targetMethod);
            }
            return result;
        }
        if (!typeFrame.
              isValid(
                )) {
            return new java.util.HashSet<edu.umd.cs.findbugs.ba.JavaClassAndMethod>(
              );
        }
        org.apache.bcel.generic.Type receiverType;
        boolean receiverTypeIsExact;
        if (opcode ==
              org.apache.bcel.Constants.
                INVOKESPECIAL) {
            receiverType =
              edu.umd.cs.findbugs.ba.ObjectTypeFactory.
                getInstance(
                  invokeInstruction.
                    getClassName(
                      cpg));
            receiverTypeIsExact =
              false;
        }
        else {
            int instanceStackLocation =
              typeFrame.
              getInstanceStackLocation(
                invokeInstruction,
                cpg);
            receiverType =
              typeFrame.
                getStackValue(
                  instanceStackLocation);
            if (!(receiverType instanceof org.apache.bcel.generic.ReferenceType)) {
                return new java.util.HashSet<edu.umd.cs.findbugs.ba.JavaClassAndMethod>(
                  );
            }
            receiverTypeIsExact =
              typeFrame.
                isExact(
                  instanceStackLocation);
        }
        if (DEBUG_METHOD_LOOKUP) {
            java.lang.System.
              out.
              println(
                "[receiver type is " +
                receiverType +
                ", " +
                (receiverTypeIsExact
                   ? "exact]"
                   : " not exact]"));
        }
        return resolveMethodCallTargets(
                 (org.apache.bcel.generic.ReferenceType)
                   receiverType,
                 invokeInstruction,
                 cpg,
                 receiverTypeIsExact);
    }
    public static java.util.Set<edu.umd.cs.findbugs.ba.JavaClassAndMethod> resolveMethodCallTargets(org.apache.bcel.generic.ReferenceType receiverType,
                                                                                                    org.apache.bcel.generic.InvokeInstruction invokeInstruction,
                                                                                                    org.apache.bcel.generic.ConstantPoolGen cpg)
          throws java.lang.ClassNotFoundException {
        return resolveMethodCallTargets(
                 receiverType,
                 invokeInstruction,
                 cpg,
                 false);
    }
    public static java.util.Set<edu.umd.cs.findbugs.ba.JavaClassAndMethod> resolveMethodCallTargets(org.apache.bcel.generic.ReferenceType receiverType,
                                                                                                    org.apache.bcel.generic.InvokeInstruction invokeInstruction,
                                                                                                    org.apache.bcel.generic.ConstantPoolGen cpg,
                                                                                                    boolean receiverTypeIsExact)
          throws java.lang.ClassNotFoundException {
        java.util.HashSet<edu.umd.cs.findbugs.ba.JavaClassAndMethod> result =
          new java.util.HashSet<edu.umd.cs.findbugs.ba.JavaClassAndMethod>(
          );
        if (invokeInstruction.
              getOpcode(
                ) ==
              org.apache.bcel.Constants.
                INVOKESTATIC) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        java.lang.String methodName =
          invokeInstruction.
          getName(
            cpg);
        java.lang.String methodSig =
          invokeInstruction.
          getSignature(
            cpg);
        if (receiverType instanceof org.apache.bcel.generic.ArrayType) {
            org.apache.bcel.classfile.JavaClass javaLangObject =
              edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              lookupClass(
                "java.lang.Object");
            edu.umd.cs.findbugs.ba.JavaClassAndMethod classAndMethod =
              findMethod(
                javaLangObject,
                methodName,
                methodSig,
                INSTANCE_METHOD);
            if (classAndMethod !=
                  null) {
                result.
                  add(
                    classAndMethod);
            }
            return result;
        }
        if (receiverType instanceof edu.umd.cs.findbugs.ba.type.NullType) {
            return java.util.Collections.
              <edu.umd.cs.findbugs.ba.JavaClassAndMethod>
            emptySet(
              );
        }
        edu.umd.cs.findbugs.ba.AnalysisContext analysisContext =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            );
        java.lang.String receiverClassName =
          ((org.apache.bcel.generic.ObjectType)
             receiverType).
          getClassName(
            );
        org.apache.bcel.classfile.JavaClass receiverClass =
          analysisContext.
          lookupClass(
            receiverClassName);
        edu.umd.cs.findbugs.classfile.ClassDescriptor receiverDesc =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          createClassDescriptorFromDottedClassName(
            receiverClassName);
        edu.umd.cs.findbugs.ba.JavaClassAndMethod upperBound =
          findMethod(
            receiverClass,
            methodName,
            methodSig,
            CONCRETE_METHOD);
        if (upperBound ==
              null) {
            upperBound =
              findInvocationLeastUpperBound(
                receiverClass,
                methodName,
                methodSig,
                CONCRETE_METHOD,
                false);
        }
        if (upperBound !=
              null) {
            if (DEBUG_METHOD_LOOKUP) {
                java.lang.System.
                  out.
                  println(
                    "Adding upper bound: " +
                    edu.umd.cs.findbugs.ba.SignatureConverter.
                      convertMethodSignature(
                        upperBound.
                          getJavaClass(
                            ),
                        upperBound.
                          getMethod(
                            )));
            }
            result.
              add(
                upperBound);
        }
        boolean virtualCall =
          (invokeInstruction.
             getOpcode(
               ) ==
             org.apache.bcel.Constants.
               INVOKEVIRTUAL ||
             invokeInstruction.
             getOpcode(
               ) ==
             org.apache.bcel.Constants.
               INVOKEINTERFACE) &&
          (upperBound ==
             null ||
             !upperBound.
             getJavaClass(
               ).
             isFinal(
               ) &&
             !upperBound.
             getMethod(
               ).
             isFinal(
               )) &&
          !receiverTypeIsExact;
        if (virtualCall) {
            if (!"java.lang.Object".
                  equals(
                    receiverClassName)) {
                java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor> subTypeSet =
                  analysisContext.
                  getSubtypes2(
                    ).
                  getSubtypes(
                    receiverDesc);
                for (edu.umd.cs.findbugs.classfile.ClassDescriptor subtype
                      :
                      subTypeSet) {
                    edu.umd.cs.findbugs.ba.XMethod concreteSubtypeMethod =
                      findMethod(
                        subtype,
                        methodName,
                        methodSig,
                        false);
                    if (concreteSubtypeMethod !=
                          null &&
                          (concreteSubtypeMethod.
                             getAccessFlags(
                               ) &
                             org.apache.bcel.Constants.
                               ACC_ABSTRACT) ==
                          0) {
                        result.
                          add(
                            new edu.umd.cs.findbugs.ba.JavaClassAndMethod(
                              concreteSubtypeMethod));
                    }
                }
                if (false &&
                      subTypeSet.
                      size(
                        ) >
                      500) {
                    new java.lang.RuntimeException(
                      receiverClassName +
                      " has " +
                      subTypeSet.
                        size(
                          ) +
                      " subclasses, " +
                      result.
                        size(
                          ) +
                      " of which implement " +
                      methodName +
                      methodSig +
                      " " +
                      invokeInstruction).
                      printStackTrace(
                        java.lang.System.
                          out);
                }
            }
        }
        return result;
    }
    @java.lang.Deprecated
    public static boolean isConcrete(edu.umd.cs.findbugs.ba.XMethod xmethod) {
        int accessFlags =
          xmethod.
          getAccessFlags(
            );
        return (accessFlags &
                  org.apache.bcel.Constants.
                    ACC_ABSTRACT) ==
          0 &&
          (accessFlags &
             org.apache.bcel.Constants.
               ACC_NATIVE) ==
          0;
    }
    public static org.apache.bcel.classfile.Field findField(java.lang.String className,
                                                            java.lang.String fieldName)
          throws java.lang.ClassNotFoundException {
        org.apache.bcel.classfile.JavaClass jclass =
          org.apache.bcel.Repository.
          lookupClass(
            className);
        while (jclass !=
                 null) {
            org.apache.bcel.classfile.Field[] fieldList =
              jclass.
              getFields(
                );
            for (org.apache.bcel.classfile.Field field
                  :
                  fieldList) {
                if (field.
                      getName(
                        ).
                      equals(
                        fieldName)) {
                    return field;
                }
            }
            jclass =
              jclass.
                getSuperClass(
                  );
        }
        return null;
    }
    public static edu.umd.cs.findbugs.ba.XField findXField(java.lang.String className,
                                                           java.lang.String fieldName,
                                                           java.lang.String fieldSig,
                                                           boolean isStatic) {
        return edu.umd.cs.findbugs.ba.XFactory.
          createXField(
            className,
            fieldName,
            fieldSig,
            isStatic);
    }
    @javax.annotation.CheckForNull
    public static edu.umd.cs.findbugs.ba.XField findXField(org.apache.bcel.generic.FieldInstruction fins,
                                                           @javax.annotation.Nonnull
                                                           org.apache.bcel.generic.ConstantPoolGen cpg) {
        java.lang.String className =
          fins.
          getClassName(
            cpg);
        java.lang.String fieldName =
          fins.
          getFieldName(
            cpg);
        java.lang.String fieldSig =
          fins.
          getSignature(
            cpg);
        boolean isStatic =
          fins.
          getOpcode(
            ) ==
          org.apache.bcel.Constants.
            GETSTATIC ||
          fins.
          getOpcode(
            ) ==
          org.apache.bcel.Constants.
            PUTSTATIC;
        edu.umd.cs.findbugs.ba.XField xfield =
          findXField(
            className,
            fieldName,
            fieldSig,
            isStatic);
        short opcode =
          fins.
          getOpcode(
            );
        if (xfield !=
              null &&
              xfield.
              isResolved(
                ) &&
              xfield.
              isStatic(
                ) ==
              (opcode ==
                 org.apache.bcel.Constants.
                   GETSTATIC ||
                 opcode ==
                 org.apache.bcel.Constants.
                   PUTSTATIC)) {
            return xfield;
        }
        else {
            return null;
        }
    }
    public static boolean isInnerClassAccess(org.apache.bcel.generic.INVOKESTATIC inv,
                                             org.apache.bcel.generic.ConstantPoolGen cpg) {
        java.lang.String methodName =
          inv.
          getName(
            cpg);
        return methodName.
          startsWith(
            "access$");
    }
    public static edu.umd.cs.findbugs.ba.InnerClassAccess getInnerClassAccess(org.apache.bcel.generic.INVOKESTATIC inv,
                                                                              org.apache.bcel.generic.ConstantPoolGen cpg)
          throws java.lang.ClassNotFoundException {
        java.lang.String className =
          inv.
          getClassName(
            cpg);
        java.lang.String methodName =
          inv.
          getName(
            cpg);
        java.lang.String methodSig =
          inv.
          getSignature(
            cpg);
        edu.umd.cs.findbugs.ba.InnerClassAccess access =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          getInnerClassAccessMap(
            ).
          getInnerClassAccess(
            className,
            methodName);
        return access !=
          null &&
          access.
          getMethodSignature(
            ).
          equals(
            methodSig)
          ? access
          : null;
    }
    public Hierarchy() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KkVH6ZZ8moV+Fon00Fu86/0/zgKX175VAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "MbQZqmUtIU1f6SGUqEUogmDBCOkJTw/J");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "7v/5b//pZ76YByD7f9lHL9xOYQAA");
}
