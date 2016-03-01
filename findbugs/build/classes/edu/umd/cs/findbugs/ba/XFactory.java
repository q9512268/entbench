package edu.umd.cs.findbugs.ba;
public class XFactory {
    public static final boolean DEBUG_UNRESOLVED = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "findbugs.xfactory.debugunresolved");
    private final java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor>
      reflectiveClasses =
      new java.util.HashSet<edu.umd.cs.findbugs.classfile.ClassDescriptor>(
      );
    private final java.util.Map<edu.umd.cs.findbugs.classfile.MethodDescriptor,edu.umd.cs.findbugs.ba.XMethod>
      methods =
      new java.util.HashMap<edu.umd.cs.findbugs.classfile.MethodDescriptor,edu.umd.cs.findbugs.ba.XMethod>(
      );
    private final java.util.Map<edu.umd.cs.findbugs.classfile.FieldDescriptor,edu.umd.cs.findbugs.ba.XField>
      fields =
      new java.util.HashMap<edu.umd.cs.findbugs.classfile.FieldDescriptor,edu.umd.cs.findbugs.ba.XField>(
      );
    private final java.util.Set<edu.umd.cs.findbugs.ba.XMethod>
      calledMethods =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XMethod>(
      );
    private final java.util.Set<edu.umd.cs.findbugs.ba.XField>
      emptyArrays =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    private final java.util.Set<java.lang.String>
      calledMethodSignatures =
      new java.util.HashSet<java.lang.String>(
      );
    private final java.util.Set<edu.umd.cs.findbugs.classfile.MethodDescriptor>
      functionsThatMightBeMistakenForProcedures =
      new java.util.HashSet<edu.umd.cs.findbugs.classfile.MethodDescriptor>(
      );
    public void canonicalizeAll() { edu.umd.cs.findbugs.classfile.DescriptorFactory descriptorFactory =
                                      edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                      instance(
                                        );
                                    for (edu.umd.cs.findbugs.ba.XMethod m
                                          :
                                          methods.
                                           values(
                                             )) {
                                        if (m instanceof edu.umd.cs.findbugs.classfile.MethodDescriptor) {
                                            descriptorFactory.
                                              canonicalize(
                                                (edu.umd.cs.findbugs.classfile.MethodDescriptor)
                                                  m);
                                        }
                                    }
                                    for (edu.umd.cs.findbugs.ba.XField f
                                          :
                                          fields.
                                           values(
                                             )) {
                                        if (f instanceof edu.umd.cs.findbugs.classfile.FieldDescriptor) {
                                            descriptorFactory.
                                              canonicalize(
                                                (edu.umd.cs.findbugs.classfile.FieldDescriptor)
                                                  f);
                                        }
                                    } }
    public XFactory() { super(); }
    public void intern(edu.umd.cs.findbugs.ba.XClass c) {
        for (edu.umd.cs.findbugs.ba.XMethod m
              :
              c.
               getXMethods(
                 )) {
            edu.umd.cs.findbugs.classfile.analysis.MethodInfo mi =
              (edu.umd.cs.findbugs.classfile.analysis.MethodInfo)
                m;
            methods.
              put(
                mi,
                mi);
        }
        for (edu.umd.cs.findbugs.ba.XField f
              :
              c.
               getXFields(
                 )) {
            edu.umd.cs.findbugs.classfile.analysis.FieldInfo fi =
              (edu.umd.cs.findbugs.classfile.analysis.FieldInfo)
                f;
            fields.
              put(
                fi,
                fi);
        }
    }
    public java.util.Collection<edu.umd.cs.findbugs.ba.XField> allFields() {
        return fields.
          values(
            );
    }
    public void addCalledMethod(edu.umd.cs.findbugs.classfile.MethodDescriptor m) {
        assert m.
          getClassDescriptor(
            ).
          getClassName(
            ).
          indexOf(
            '.') ==
          -1;
        calledMethods.
          add(
            createXMethod(
              m));
    }
    public void addEmptyArrayField(edu.umd.cs.findbugs.ba.XField f) {
        emptyArrays.
          add(
            f);
    }
    public boolean isEmptyArrayField(@javax.annotation.CheckForNull
                                     edu.umd.cs.findbugs.ba.XField f) {
        return emptyArrays.
          contains(
            f);
    }
    public boolean isCalled(edu.umd.cs.findbugs.ba.XMethod m) {
        if ("<clinit>".
              equals(
                m.
                  getName(
                    ))) {
            return true;
        }
        return calledMethods.
          contains(
            m);
    }
    public java.util.Set<edu.umd.cs.findbugs.ba.XMethod> getCalledMethods() {
        return calledMethods;
    }
    public void addFunctionThatMightBeMistakenForProcedures(edu.umd.cs.findbugs.classfile.MethodDescriptor m) {
        functionsThatMightBeMistakenForProcedures.
          add(
            m);
    }
    public boolean isFunctionshatMightBeMistakenForProcedures(edu.umd.cs.findbugs.classfile.MethodDescriptor m) {
        return functionsThatMightBeMistakenForProcedures.
          contains(
            m);
    }
    public java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor> getReflectiveClasses() {
        return reflectiveClasses;
    }
    public boolean isReflectiveClass(edu.umd.cs.findbugs.classfile.ClassDescriptor c) {
        return reflectiveClasses.
          contains(
            c);
    }
    public boolean addReflectiveClasses(edu.umd.cs.findbugs.classfile.ClassDescriptor c) {
        return reflectiveClasses.
          add(
            c);
    }
    public boolean isCalledDirectlyOrIndirectly(edu.umd.cs.findbugs.ba.XMethod m) {
        if (isCalled(
              m)) {
            return true;
        }
        if (m.
              isStatic(
                ) ||
              m.
              isPrivate(
                ) ||
              "<init>".
              equals(
                m.
                  getName(
                    ))) {
            return false;
        }
        try {
            edu.umd.cs.findbugs.classfile.IAnalysisCache analysisCache =
              edu.umd.cs.findbugs.classfile.Global.
              getAnalysisCache(
                );
            edu.umd.cs.findbugs.ba.XClass clazz =
              analysisCache.
              getClassAnalysis(
                edu.umd.cs.findbugs.ba.XClass.class,
                m.
                  getClassDescriptor(
                    ));
            if (isCalledDirectlyOrIndirectly(
                  clazz.
                    getSuperclassDescriptor(
                      ),
                  m)) {
                return true;
            }
            for (edu.umd.cs.findbugs.classfile.ClassDescriptor i
                  :
                  clazz.
                   getInterfaceDescriptorList(
                     )) {
                if (isCalledDirectlyOrIndirectly(
                      i,
                      m)) {
                    return true;
                }
            }
            return false;
        }
        catch (edu.umd.cs.findbugs.classfile.MissingClassException e) {
            return false;
        }
        catch (edu.umd.cs.findbugs.ba.MissingClassException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              reportMissingClass(
                e.
                  getClassNotFoundException(
                    ));
            return false;
        }
        catch (java.lang.Exception e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Error checking to see if " +
                m +
                " is called (" +
                e.
                  getClass(
                    ).
                  getCanonicalName(
                    ) +
                ")",
                e);
            return false;
        }
    }
    private boolean isCalledDirectlyOrIndirectly(@javax.annotation.CheckForNull
                                                 edu.umd.cs.findbugs.classfile.ClassDescriptor clazzDescriptor,
                                                 edu.umd.cs.findbugs.ba.XMethod m)
          throws edu.umd.cs.findbugs.classfile.CheckedAnalysisException {
        if (clazzDescriptor ==
              null) {
            return false;
        }
        edu.umd.cs.findbugs.classfile.IAnalysisCache analysisCache =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            );
        edu.umd.cs.findbugs.ba.XClass clazz =
          analysisCache.
          getClassAnalysis(
            edu.umd.cs.findbugs.ba.XClass.class,
            clazzDescriptor);
        edu.umd.cs.findbugs.ba.XMethod m2 =
          clazz.
          findMethod(
            m.
              getName(
                ),
            m.
              getSignature(
                ),
            m.
              isStatic(
                ));
        if (m2 !=
              null &&
              isCalled(
                m2)) {
            return true;
        }
        if (isCalledDirectlyOrIndirectly(
              clazz.
                getSuperclassDescriptor(
                  ),
              m)) {
            return true;
        }
        for (edu.umd.cs.findbugs.classfile.ClassDescriptor i
              :
              clazz.
               getInterfaceDescriptorList(
                 )) {
            if (isCalledDirectlyOrIndirectly(
                  i,
                  m)) {
                return true;
            }
        }
        return false;
    }
    public boolean nameAndSignatureIsCalled(edu.umd.cs.findbugs.ba.XMethod m) {
        return calledMethodSignatures.
          contains(
            getDetailedSignature(
              m));
    }
    private static java.lang.String getDetailedSignature(edu.umd.cs.findbugs.ba.XMethod m2) {
        return m2.
          getName(
            ) +
        m2.
          getSignature(
            ) +
        m2.
          isStatic(
            );
    }
    @java.lang.Deprecated
    public boolean isInterned(edu.umd.cs.findbugs.ba.XMethod m) {
        return m.
          isResolved(
            );
    }
    public static java.lang.String canonicalizeString(java.lang.String s) {
        return edu.umd.cs.findbugs.classfile.DescriptorFactory.
          canonicalizeString(
            s);
    }
    public static edu.umd.cs.findbugs.ba.XMethod createXMethod(java.lang.String className,
                                                               org.apache.bcel.classfile.Method method) {
        java.lang.String methodName =
          method.
          getName(
            );
        java.lang.String methodSig =
          method.
          getSignature(
            );
        int accessFlags =
          method.
          getAccessFlags(
            );
        return createXMethod(
                 className,
                 methodName,
                 methodSig,
                 accessFlags);
    }
    private static edu.umd.cs.findbugs.ba.XMethod createXMethod(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                                                java.lang.String className,
                                                                java.lang.String methodName,
                                                                java.lang.String methodSig,
                                                                int accessFlags) {
        return createXMethod(
                 className,
                 methodName,
                 methodSig,
                 (accessFlags &
                    org.apache.bcel.Constants.
                      ACC_STATIC) !=
                   0);
    }
    public static edu.umd.cs.findbugs.ba.XMethod createXMethod(org.apache.bcel.classfile.JavaClass javaClass,
                                                               org.apache.bcel.classfile.Method method) {
        if (method ==
              null) {
            throw new java.lang.NullPointerException(
              "method must not be null");
        }
        edu.umd.cs.findbugs.ba.XMethod xmethod =
          createXMethod(
            javaClass.
              getClassName(
                ),
            method);
        assert xmethod.
          isResolved(
            );
        return xmethod;
    }
    public static void assertDottedClassName(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                             java.lang.String className) {
        assert className.
          indexOf(
            '/') ==
          -1;
    }
    public static void assertSlashedClassName(@edu.umd.cs.findbugs.internalAnnotations.SlashedClassName
                                              java.lang.String className) {
        assert className.
          indexOf(
            '.') ==
          -1;
    }
    public static edu.umd.cs.findbugs.ba.XMethod createXMethodUsingSlashedClassName(@edu.umd.cs.findbugs.internalAnnotations.SlashedClassName
                                                                                    java.lang.String className,
                                                                                    java.lang.String methodName,
                                                                                    java.lang.String methodSig,
                                                                                    boolean isStatic) {
        assertSlashedClassName(
          className);
        edu.umd.cs.findbugs.classfile.MethodDescriptor desc =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          instance(
            ).
          getMethodDescriptor(
            className,
            methodName,
            methodSig,
            isStatic);
        return createXMethod(
                 desc);
    }
    public static edu.umd.cs.findbugs.ba.XMethod createXMethod(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                                               java.lang.String className,
                                                               java.lang.String methodName,
                                                               java.lang.String methodSig,
                                                               boolean isStatic) {
        assertDottedClassName(
          className);
        edu.umd.cs.findbugs.classfile.MethodDescriptor desc =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          instance(
            ).
          getMethodDescriptor(
            edu.umd.cs.findbugs.util.ClassName.
              toSlashedClassName(
                className),
            methodName,
            methodSig,
            isStatic);
        return createXMethod(
                 desc);
    }
    public static edu.umd.cs.findbugs.ba.XMethod createXMethod(edu.umd.cs.findbugs.classfile.MethodDescriptor desc) {
        edu.umd.cs.findbugs.ba.XFactory xFactory =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentXFactory(
            );
        edu.umd.cs.findbugs.ba.XMethod m =
          xFactory.
            methods.
          get(
            desc);
        if (m !=
              null) {
            return m;
        }
        m =
          xFactory.
            resolveXMethod(
              desc);
        if (m instanceof edu.umd.cs.findbugs.classfile.MethodDescriptor) {
            xFactory.
              methods.
              put(
                (edu.umd.cs.findbugs.classfile.MethodDescriptor)
                  m,
                m);
            edu.umd.cs.findbugs.classfile.DescriptorFactory.
              instance(
                ).
              canonicalize(
                (edu.umd.cs.findbugs.classfile.MethodDescriptor)
                  m);
        }
        else {
            xFactory.
              methods.
              put(
                desc,
                m);
        }
        return m;
    }
    public static void profile() { edu.umd.cs.findbugs.ba.XFactory xFactory =
                                     edu.umd.cs.findbugs.ba.AnalysisContext.
                                     currentXFactory(
                                       );
                                   int count =
                                     0;
                                   for (edu.umd.cs.findbugs.ba.XMethod m
                                         :
                                         xFactory.
                                           methods.
                                          values(
                                            )) {
                                       if (m instanceof edu.umd.cs.findbugs.classfile.analysis.MethodInfo) {
                                           count++;
                                       }
                                   }
                                   java.lang.System.
                                     out.
                                     printf(
                                       "XFactory cached methods: %d/%d%n",
                                       count,
                                       xFactory.
                                         methods.
                                         size(
                                           ));
                                   edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                     instance(
                                       ).
                                     profile(
                                       );
    }
    private edu.umd.cs.findbugs.ba.XMethod resolveXMethod(edu.umd.cs.findbugs.classfile.MethodDescriptor originalDescriptor) {
        edu.umd.cs.findbugs.classfile.MethodDescriptor desc =
          originalDescriptor;
        try {
            while (true) {
                edu.umd.cs.findbugs.ba.XMethod m =
                  methods.
                  get(
                    desc);
                if (m !=
                      null) {
                    return m;
                }
                edu.umd.cs.findbugs.ba.XClass xClass =
                  edu.umd.cs.findbugs.classfile.Global.
                  getAnalysisCache(
                    ).
                  getClassAnalysis(
                    edu.umd.cs.findbugs.ba.XClass.class,
                    desc.
                      getClassDescriptor(
                        ));
                if (xClass ==
                      null) {
                    break;
                }
                edu.umd.cs.findbugs.classfile.ClassDescriptor superClass =
                  xClass.
                  getSuperclassDescriptor(
                    );
                if (superClass ==
                      null) {
                    break;
                }
                desc =
                  edu.umd.cs.findbugs.classfile.DescriptorFactory.
                    instance(
                      ).
                    getMethodDescriptor(
                      superClass.
                        getClassName(
                          ),
                      desc.
                        getName(
                          ),
                      desc.
                        getSignature(
                          ),
                      desc.
                        isStatic(
                          ));
            }
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            assert true;
        }
        catch (java.lang.RuntimeException e) {
            assert true;
        }
        edu.umd.cs.findbugs.ba.UnresolvedXMethod xmethod =
          new edu.umd.cs.findbugs.ba.UnresolvedXMethod(
          originalDescriptor);
        edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabase database =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          getOptionalDatabase(
            edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabase.class);
        if (edu.umd.cs.findbugs.detect.BuildObligationPolicyDatabase.
              INFER_CLOSE_METHODS &&
              database !=
              null &&
              !xmethod.
              getClassName(
                ).
              startsWith(
                "java")) {
            boolean methodHasCloseInName =
              false;
            java.lang.String methodName =
              xmethod.
              getName(
                );
            edu.umd.cs.findbugs.util.SplitCamelCaseIdentifier splitter =
              new edu.umd.cs.findbugs.util.SplitCamelCaseIdentifier(
              methodName);
            methodHasCloseInName =
              splitter.
                split(
                  ).
                contains(
                  "close");
            edu.umd.cs.findbugs.ba.obl.Obligation[] paramObligationTypes =
              database.
              getFactory(
                ).
              getParameterObligationTypes(
                xmethod);
            for (int i =
                   0;
                 i <
                   xmethod.
                   getNumParams(
                     );
                 i++) {
                edu.umd.cs.findbugs.ba.obl.Obligation obligationType =
                  paramObligationTypes[i];
                if (obligationType ==
                      null) {
                    continue;
                }
                if (methodHasCloseInName) {
                    edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntry entry =
                      database.
                      addParameterDeletesObligationDatabaseEntry(
                        xmethod,
                        obligationType,
                        edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                          STRONG);
                }
                else {
                    if ("<init>".
                          equals(
                            methodName) ||
                          methodName.
                          startsWith(
                            "access$") ||
                          xmethod.
                          isStatic(
                            ) ||
                          methodName.
                          toLowerCase(
                            ).
                          indexOf(
                            "close") >=
                          0 ||
                          xmethod.
                          getSignature(
                            ).
                          toLowerCase(
                            ).
                          indexOf(
                            "Closeable") >=
                          0) {
                        edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntry entry =
                          database.
                          addParameterDeletesObligationDatabaseEntry(
                            xmethod,
                            obligationType,
                            edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType.
                              WEAK);
                    }
                }
            }
        }
        return xmethod;
    }
    public static edu.umd.cs.findbugs.ba.XMethod createXMethod(edu.umd.cs.findbugs.MethodAnnotation ma) {
        return createXMethod(
                 ma.
                   getClassName(
                     ),
                 ma.
                   getMethodName(
                     ),
                 ma.
                   getMethodSignature(
                     ),
                 ma.
                   isStatic(
                     ));
    }
    public static edu.umd.cs.findbugs.ba.XField createXFieldUsingSlashedClassName(@edu.umd.cs.findbugs.internalAnnotations.SlashedClassName
                                                                                  java.lang.String className,
                                                                                  java.lang.String fieldName,
                                                                                  java.lang.String fieldSignature,
                                                                                  boolean isStatic) {
        edu.umd.cs.findbugs.classfile.FieldDescriptor fieldDesc =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          instance(
            ).
          getFieldDescriptor(
            className,
            fieldName,
            fieldSignature,
            isStatic);
        return createXField(
                 fieldDesc);
    }
    public static edu.umd.cs.findbugs.ba.XField createXField(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                                             java.lang.String className,
                                                             java.lang.String fieldName,
                                                             java.lang.String fieldSignature,
                                                             boolean isStatic) {
        edu.umd.cs.findbugs.classfile.FieldDescriptor fieldDesc =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          instance(
            ).
          getFieldDescriptor(
            edu.umd.cs.findbugs.util.ClassName.
              toSlashedClassName(
                className),
            fieldName,
            fieldSignature,
            isStatic);
        return createXField(
                 fieldDesc);
    }
    public static final boolean DEBUG_CIRCULARITY =
      edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "circularity.debug");
    public static edu.umd.cs.findbugs.ba.XField createXField(org.apache.bcel.generic.FieldInstruction fieldInstruction,
                                                             org.apache.bcel.generic.ConstantPoolGen cpg) {
        java.lang.String className =
          fieldInstruction.
          getClassName(
            cpg);
        java.lang.String fieldName =
          fieldInstruction.
          getName(
            cpg);
        java.lang.String fieldSig =
          fieldInstruction.
          getSignature(
            cpg);
        int opcode =
          fieldInstruction.
          getOpcode(
            );
        return createXField(
                 className,
                 fieldName,
                 fieldSig,
                 opcode ==
                   org.apache.bcel.Constants.
                     GETSTATIC ||
                   opcode ==
                   org.apache.bcel.Constants.
                     PUTSTATIC);
    }
    public static edu.umd.cs.findbugs.ba.XField createReferencedXField(edu.umd.cs.findbugs.visitclass.DismantleBytecode visitor) {
        int seen =
          visitor.
          getOpcode(
            );
        if (seen !=
              org.objectweb.asm.Opcodes.
                GETFIELD &&
              seen !=
              org.objectweb.asm.Opcodes.
                GETSTATIC &&
              seen !=
              org.objectweb.asm.Opcodes.
                PUTFIELD &&
              seen !=
              org.objectweb.asm.Opcodes.
                PUTSTATIC) {
            throw new java.lang.IllegalArgumentException(
              "Not at a field reference");
        }
        return createXFieldUsingSlashedClassName(
                 visitor.
                   getClassConstantOperand(
                     ),
                 visitor.
                   getNameConstantOperand(
                     ),
                 visitor.
                   getSigConstantOperand(
                     ),
                 visitor.
                   getRefFieldIsStatic(
                     ));
    }
    public static edu.umd.cs.findbugs.ba.XMethod createReferencedXMethod(edu.umd.cs.findbugs.visitclass.DismantleBytecode visitor) {
        edu.umd.cs.findbugs.ba.XMethod m =
          createXMethodUsingSlashedClassName(
            visitor.
              getClassConstantOperand(
                ),
            visitor.
              getNameConstantOperand(
                ),
            visitor.
              getSigConstantOperand(
                ),
            visitor.
              getOpcode(
                ) ==
              org.apache.bcel.Constants.
                INVOKESTATIC);
        return m.
          resolveAccessMethodForMethod(
            );
    }
    public static edu.umd.cs.findbugs.ba.XField createXField(edu.umd.cs.findbugs.FieldAnnotation f) {
        return createXField(
                 f.
                   getClassName(
                     ),
                 f.
                   getFieldName(
                     ),
                 f.
                   getFieldSignature(
                     ),
                 f.
                   isStatic(
                     ));
    }
    public static edu.umd.cs.findbugs.ba.XField createXField(org.apache.bcel.classfile.JavaClass javaClass,
                                                             org.apache.bcel.classfile.Field field) {
        return createXField(
                 javaClass.
                   getClassName(
                     ),
                 field);
    }
    public static edu.umd.cs.findbugs.ba.XField createXField(java.lang.String className,
                                                             org.apache.bcel.classfile.Field field) {
        java.lang.String fieldName =
          field.
          getName(
            );
        java.lang.String fieldSig =
          field.
          getSignature(
            );
        edu.umd.cs.findbugs.ba.XField xfield =
          getExactXField(
            className,
            fieldName,
            fieldSig,
            field.
              isStatic(
                ));
        assert xfield.
          isResolved(
            ): "Could not exactly resolve " +
        xfield;
        return xfield;
    }
    public static edu.umd.cs.findbugs.ba.XField getExactXField(@edu.umd.cs.findbugs.internalAnnotations.SlashedClassName
                                                               java.lang.String className,
                                                               java.lang.String name,
                                                               java.lang.String signature,
                                                               boolean isStatic) {
        edu.umd.cs.findbugs.classfile.FieldDescriptor fieldDesc =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          instance(
            ).
          getFieldDescriptor(
            edu.umd.cs.findbugs.util.ClassName.
              toSlashedClassName(
                className),
            name,
            signature,
            isStatic);
        return getExactXField(
                 fieldDesc);
    }
    @javax.annotation.Nonnull
    public static edu.umd.cs.findbugs.ba.XField getExactXField(@edu.umd.cs.findbugs.internalAnnotations.SlashedClassName
                                                               java.lang.String className,
                                                               org.apache.bcel.classfile.Field f) {
        edu.umd.cs.findbugs.classfile.FieldDescriptor fd =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          instance(
            ).
          getFieldDescriptor(
            className,
            f);
        return getExactXField(
                 fd);
    }
    @javax.annotation.Nonnull
    public static edu.umd.cs.findbugs.ba.XField getExactXField(edu.umd.cs.findbugs.classfile.FieldDescriptor desc) {
        edu.umd.cs.findbugs.ba.XFactory xFactory =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentXFactory(
            );
        edu.umd.cs.findbugs.ba.XField f =
          xFactory.
            fields.
          get(
            desc);
        if (f ==
              null) {
            return new edu.umd.cs.findbugs.ba.UnresolvedXField(
              desc);
        }
        return f;
    }
    public static edu.umd.cs.findbugs.ba.XField createXField(edu.umd.cs.findbugs.classfile.FieldDescriptor desc) {
        edu.umd.cs.findbugs.ba.XFactory xFactory =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentXFactory(
            );
        edu.umd.cs.findbugs.ba.XField m =
          xFactory.
            fields.
          get(
            desc);
        if (m !=
              null) {
            return m;
        }
        m =
          xFactory.
            resolveXField(
              desc);
        xFactory.
          fields.
          put(
            desc,
            m);
        return m;
    }
    private edu.umd.cs.findbugs.ba.XField resolveXField(edu.umd.cs.findbugs.classfile.FieldDescriptor originalDescriptor) {
        edu.umd.cs.findbugs.classfile.FieldDescriptor desc =
          originalDescriptor;
        java.util.LinkedList<edu.umd.cs.findbugs.classfile.ClassDescriptor> worklist =
          new java.util.LinkedList<edu.umd.cs.findbugs.classfile.ClassDescriptor>(
          );
        edu.umd.cs.findbugs.classfile.ClassDescriptor originalClassDescriptor =
          desc.
          getClassDescriptor(
            );
        worklist.
          add(
            originalClassDescriptor);
        try {
            while (!worklist.
                     isEmpty(
                       )) {
                edu.umd.cs.findbugs.classfile.ClassDescriptor d =
                  worklist.
                  removeFirst(
                    );
                if (!d.
                      equals(
                        originalClassDescriptor)) {
                    desc =
                      edu.umd.cs.findbugs.classfile.DescriptorFactory.
                        instance(
                          ).
                        getFieldDescriptor(
                          d.
                            getClassName(
                              ),
                          desc.
                            getName(
                              ),
                          desc.
                            getSignature(
                              ),
                          desc.
                            isStatic(
                              ));
                }
                edu.umd.cs.findbugs.ba.XField f =
                  fields.
                  get(
                    desc);
                if (f !=
                      null) {
                    return f;
                }
                edu.umd.cs.findbugs.ba.XClass xClass =
                  edu.umd.cs.findbugs.classfile.Global.
                  getAnalysisCache(
                    ).
                  getClassAnalysis(
                    edu.umd.cs.findbugs.ba.XClass.class,
                    d);
                if (xClass ==
                      null) {
                    break;
                }
                edu.umd.cs.findbugs.classfile.ClassDescriptor superClass =
                  xClass.
                  getSuperclassDescriptor(
                    );
                if (superClass !=
                      null) {
                    worklist.
                      add(
                        superClass);
                }
                if (originalDescriptor.
                      isStatic(
                        )) {
                    for (edu.umd.cs.findbugs.classfile.ClassDescriptor i
                          :
                          xClass.
                           getInterfaceDescriptorList(
                             )) {
                        worklist.
                          add(
                            i);
                    }
                }
            }
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Error resolving " +
                originalDescriptor,
                e);
        }
        return new edu.umd.cs.findbugs.ba.UnresolvedXField(
          originalDescriptor);
    }
    public static edu.umd.cs.findbugs.ba.XMethod createXMethod(org.apache.bcel.generic.InvokeInstruction invokeInstruction,
                                                               org.apache.bcel.generic.ConstantPoolGen cpg) {
        java.lang.String className =
          invokeInstruction.
          getClassName(
            cpg);
        java.lang.String methodName =
          invokeInstruction.
          getName(
            cpg);
        java.lang.String methodSig =
          invokeInstruction.
          getSignature(
            cpg);
        return createXMethod(
                 className,
                 methodName,
                 methodSig,
                 invokeInstruction.
                   getOpcode(
                     ) ==
                   org.apache.bcel.Constants.
                     INVOKESTATIC);
    }
    public static edu.umd.cs.findbugs.ba.XMethod createXMethod(edu.umd.cs.findbugs.visitclass.PreorderVisitor visitor) {
        org.apache.bcel.classfile.JavaClass javaClass =
          visitor.
          getThisClass(
            );
        org.apache.bcel.classfile.Method method =
          visitor.
          getMethod(
            );
        edu.umd.cs.findbugs.ba.XMethod m =
          createXMethod(
            javaClass,
            method);
        return m;
    }
    public static edu.umd.cs.findbugs.ba.XField createXField(edu.umd.cs.findbugs.visitclass.PreorderVisitor visitor) {
        org.apache.bcel.classfile.JavaClass javaClass =
          visitor.
          getThisClass(
            );
        org.apache.bcel.classfile.Field field =
          visitor.
          getField(
            );
        edu.umd.cs.findbugs.ba.XField f =
          createXField(
            javaClass,
            field);
        return f;
    }
    public static edu.umd.cs.findbugs.ba.XMethod createXMethod(org.apache.bcel.generic.MethodGen methodGen) {
        java.lang.String className =
          methodGen.
          getClassName(
            );
        java.lang.String methodName =
          methodGen.
          getName(
            );
        java.lang.String methodSig =
          methodGen.
          getSignature(
            );
        int accessFlags =
          methodGen.
          getAccessFlags(
            );
        return createXMethod(
                 className,
                 methodName,
                 methodSig,
                 accessFlags);
    }
    public static edu.umd.cs.findbugs.ba.XMethod createXMethod(edu.umd.cs.findbugs.ba.JavaClassAndMethod classAndMethod) {
        return createXMethod(
                 classAndMethod.
                   getJavaClass(
                     ),
                 classAndMethod.
                   getMethod(
                     ));
    }
    @javax.annotation.CheckForNull
    public edu.umd.cs.findbugs.ba.XClass getXClass(edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor) {
        try {
            edu.umd.cs.findbugs.classfile.IAnalysisCache analysisCache =
              edu.umd.cs.findbugs.classfile.Global.
              getAnalysisCache(
                );
            return analysisCache.
              getClassAnalysis(
                edu.umd.cs.findbugs.ba.XClass.class,
                classDescriptor);
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            return null;
        }
    }
    public static <E extends edu.umd.cs.findbugs.ba.ClassMember> int compare(E lhs,
                                                                             E rhs) {
        int cmp;
        cmp =
          lhs.
            getClassName(
              ).
            compareTo(
              rhs.
                getClassName(
                  ));
        if (cmp !=
              0) {
            return cmp;
        }
        cmp =
          lhs.
            getName(
              ).
            compareTo(
              rhs.
                getName(
                  ));
        if (cmp !=
              0) {
            return cmp;
        }
        cmp =
          lhs.
            getSignature(
              ).
            compareTo(
              rhs.
                getSignature(
                  ));
        if (cmp !=
              0) {
            return cmp;
        }
        return (lhs.
                  isStatic(
                    )
                  ? 1
                  : 0) -
          (rhs.
             isStatic(
               )
             ? 1
             : 0);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "nZTNoad4Vvv/z784225jAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL19C9TzaF1nv/edO8PMMDPMjANzZRCGyJdekqZlQOktTdom" +
       "bZo2baPykSZp7ve0SQsjl2WFlRVGHQU5OHo8KC6L4qq4nt1lF3XFG7LqYRfc" +
       "XZHD8YjCskfWg6h42Sdp3+v3vv2+j/f9fM/J86Z5Lnl+v//l+T/p86Qf/krm" +
       "xsDPQK5jLhXTCS/KcXhRN9GL4dKVg4utDtoT/ECWaqYQBANw7ZL4+M/f+dff" +
       "eEa9aydzE5+5R7BtJxRCzbGDvhw45kKWOpk7D642TNkKwsxdHV1YCPA81Ey4" +
       "owXhU53M8w5VDTNPdPa6AIMuwKALcNoFuHJQClR6vmzPrVpSQ7DDwMt8T+ZC" +
       "J3OTKybdCzOPHW3EFXzB2jTTSxGAFm5JPnMAVFo59jOP7mNfY74M8A9D8LPv" +
       "ed1dv7CbuZPP3KnZbNIdEXQiBDfhM7dbsjWV/aAiSbLEZ15gy7LEyr4mmNoq" +
       "7TefuTvQFFsI5768T1Jyce7KfnrPA+ZuFxNs/lwMHX8f3kyTTWnv040zU1AA" +
       "1vsOsK4R4sl1APA2DXTMnwmivFflBkOzpTDzyPEa+xifaIMCoOrNlhyqzv6t" +
       "brAFcCFz91p2pmArMBv6mq2Aojc6c3CXMPPgqY0mXLuCaAiKfCnMPHC8XG+d" +
       "BUrdmhKRVAkzLzxeLG0JSOnBY1I6JJ+v0K9+1xtswt5J+yzJopn0/xZQ6eFj" +
       "lfryTPZlW5TXFW9/RedHhPs+9o6dTAYUfuGxwusy//6NX33ttz388d9al3nR" +
       "CWW6U10Ww0viB6Z3/MGLa0+Wd5Nu3OI6gZYI/wjyVP17m5ynYhdY3n37LSaZ" +
       "F/cyP97/xOTNH5K/vJO5jczcJDrm3AJ69ALRsVzNlP2mbMu+EMoSmblVtqVa" +
       "mk9mbgbnHc2W11e7s1kgh2TmBjO9dJOTfgYUzUATCUU3g3PNnjl7564Qqul5" +
       "7GYymZvBkbkdHM3M+i/9H2Y4WHUsGRZEwdZsB+75ToI/gGU7nAJuVXgGlGk6" +
       "VwI48EU4VR1ZmsNzS4LF4CBzKsBjXEj0fHkxKeRet5bjBNNd0YULgO4XHzd2" +
       "E9gJ4ZiS7F8Sn51XG1/9uUu/u7Ov/Bs2gO2AG10EN7ooBhf3bnRxKlzcu1Hm" +
       "woW0/XuTG65FCQRhAJMGzu72J9nvbr3+HY/vAh1yoxsAi0lR+HSfWztwAmTq" +
       "6kSgiZmPvzd6C/em7E5m56jzTDoJLt2WVO8lLm/ftT1x3GhOavfOt//5X3/k" +
       "R552DszniDfeWPXlNROrfPw4nb4jAqZ8+aD5VzwqfPTSx55+YidzAzB14N5C" +
       "Aagj8BwPH7/HEet8as/TJVhuBIBnjm8JZpK1555uC1XfiQ6upHK+Iz1/AeD4" +
       "eYm63gMObaO/6f8k9x43Se9d60UitGMoUk/6Gtb9sc9+6i8KKd17TvfOQ8MY" +
       "K4dPHTL0pLE7U5N+wYEODHxZBuX++L29H/rhr7z9O1MFACVectINn0jSGjBw" +
       "IEJA87/8Le+P/uRzH/j0zoHShGCkm09NTYz3QSbXM7dtAQnu9q0H/QGOwgQm" +
       "lWjNE0PbciRtpglTU0609O/vfGnuo//nXXet9cAEV/bU6Nuu3MDB9W+pZt78" +
       "u6/7+sNpMxfEZKA64Oyg2Nr73XPQcsX3hWXSj/gtf/jQj/6m8GPAjwLfFWgr" +
       "OXVHmZSDTCo0OMX/ijS9eCwvlySPBIeV/6h9HQooLonPfPovn8/95X/+atrb" +
       "oxHJYVlTgvvUWr2S5NEYNH//cUsnhEAF5ZCP0991l/nxb4AWedCiCIbhoOsD" +
       "/xIf0YxN6Rtv/p+/+uv3vf4PdjM7eOY20xGktUMBHhxotxyowDXF7ne8di3c" +
       "6BaQ3JVCzVwGfq0UD6SfbgcdfPJ0/4InAcWBiT7wd11z+tYv/M1lJKSe5YRx" +
       "9Fh9Hv7w+x+sffuX0/oHJp7Ufji+3OeC4Ougbv5D1td2Hr/pN3YyN/OZu8RN" +
       "ZMcJ5jwxHB5EM8FeuAeivyP5RyOT9TD81L4Le/Fx93Lotsedy4GvB+dJ6eT8" +
       "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" +
       "Gih+W6Wg+iQa8oU+3GxHo4U3HdLTYn3Z");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
