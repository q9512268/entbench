package edu.umd.cs.findbugs.detect;
public class UnreadFields extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "unreadfields.debug");
    @java.lang.Deprecated
    public boolean isContainerField(edu.umd.cs.findbugs.ba.XField f) { return data.
                                                                         isContainerField(
                                                                           f);
    }
    boolean hasNativeMethods;
    boolean isSerializable;
    boolean sawSelfCallInConstructor;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    boolean publicOrProtectedConstructor;
    @java.lang.Deprecated
    public java.util.Set<? extends edu.umd.cs.findbugs.ba.XField> getReadFields() {
        return data.
          getReadFields(
            );
    }
    @java.lang.Deprecated
    public java.util.Set<? extends edu.umd.cs.findbugs.ba.XField> getWrittenFields() {
        return data.
          getWrittenFields(
            );
    }
    @java.lang.Deprecated
    public boolean isWrittenOutsideOfInitialization(edu.umd.cs.findbugs.ba.XField f) {
        return data.
          isWrittenOutsideOfInitialization(
            f);
    }
    @java.lang.Deprecated
    public boolean isWrittenDuringInitialization(edu.umd.cs.findbugs.ba.XField f) {
        return data.
          isWrittenDuringInitialization(
            f);
    }
    @java.lang.Deprecated
    public boolean isWrittenInConstructor(edu.umd.cs.findbugs.ba.XField f) {
        return data.
          isWrittenInConstructor(
            f);
    }
    static final int DO_NOT_CONSIDER = ACC_PUBLIC |
      ACC_PROTECTED;
    final edu.umd.cs.findbugs.classfile.ClassDescriptor
      externalizable =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.io.Externalizable.class);
    final edu.umd.cs.findbugs.classfile.ClassDescriptor
      serializable =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.io.Serializable.class);
    final edu.umd.cs.findbugs.classfile.ClassDescriptor
      remote =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.rmi.Remote.class);
    public UnreadFields(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
        edu.umd.cs.findbugs.ba.AnalysisContext context =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            );
        data.
          reflectiveFields.
          add(
            edu.umd.cs.findbugs.ba.XFactory.
              createXField(
                "java.lang.System",
                "in",
                "Ljava/io/InputStream;",
                true));
        data.
          reflectiveFields.
          add(
            edu.umd.cs.findbugs.ba.XFactory.
              createXField(
                "java.lang.System",
                "out",
                "Ljava/io/PrintStream;",
                true));
        data.
          reflectiveFields.
          add(
            edu.umd.cs.findbugs.ba.XFactory.
              createXField(
                "java.lang.System",
                "err",
                "Ljava/io/PrintStream;",
                true));
        data =
          context.
            getUnreadFieldsData(
              );
        context.
          setUnreadFields(
            this);
    }
    @java.lang.Deprecated
    public void strongEvidenceForIntendedSerialization(edu.umd.cs.findbugs.classfile.ClassDescriptor c) {
        data.
          strongEvidenceForIntendedSerialization(
            c);
    }
    @java.lang.Deprecated
    public boolean existsStrongEvidenceForIntendedSerialization(edu.umd.cs.findbugs.classfile.ClassDescriptor c) {
        return data.
          existsStrongEvidenceForIntendedSerialization(
            c);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) {
        data.
          calledFromConstructors.
          clear(
            );
        hasNativeMethods =
          false;
        sawSelfCallInConstructor =
          false;
        publicOrProtectedConstructor =
          false;
        isSerializable =
          false;
        if (obj.
              isAbstract(
                )) {
            data.
              abstractClasses.
              add(
                getDottedClassName(
                  ));
        }
        else {
            java.lang.String superClass =
              obj.
              getSuperclassName(
                );
            if (superClass !=
                  null) {
                data.
                  hasNonAbstractSubClass.
                  add(
                    superClass);
            }
        }
        data.
          classesScanned.
          add(
            getDottedClassName(
              ));
        boolean superClassIsObject =
          "java.lang.Object".
          equals(
            obj.
              getSuperclassName(
                ));
        if (getSuperclassName(
              ).
              indexOf(
                '$') >=
              0 ||
              getSuperclassName(
                ).
              indexOf(
                '+') >=
              0 ||
              withinAnonymousClass.
              matcher(
                getDottedClassName(
                  )).
              find(
                )) {
            data.
              innerClassCannotBeStatic.
              add(
                getDottedClassName(
                  ));
            data.
              innerClassCannotBeStatic.
              add(
                getDottedSuperclassName(
                  ));
        }
        java.lang.String[] interface_names =
          obj.
          getInterfaceNames(
            );
        for (java.lang.String interface_name
              :
              interface_names) {
            if ("java.io.Externalizable".
                  equals(
                    interface_name)) {
                isSerializable =
                  true;
            }
            else
                if ("java.io.Serializable".
                      equals(
                        interface_name)) {
                    isSerializable =
                      true;
                    break;
                }
        }
        if ((!superClassIsObject ||
               interface_names.
                 length >
               0) &&
              !isSerializable) {
            try {
                edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
                  edu.umd.cs.findbugs.ba.AnalysisContext.
                  currentAnalysisContext(
                    ).
                  getSubtypes2(
                    );
                edu.umd.cs.findbugs.classfile.ClassDescriptor desc =
                  edu.umd.cs.findbugs.classfile.DescriptorFactory.
                  createClassDescriptor(
                    obj);
                if (subtypes2.
                      getSubtypes(
                        serializable).
                      contains(
                        desc) ||
                      subtypes2.
                      getSubtypes(
                        externalizable).
                      contains(
                        desc) ||
                      subtypes2.
                      getSubtypes(
                        remote).
                      contains(
                        desc)) {
                    isSerializable =
                      true;
                }
            }
            catch (java.lang.ClassNotFoundException e) {
                bugReporter.
                  reportMissingClass(
                    e);
            }
        }
        super.
          visit(
            obj);
    }
    public static boolean classHasParameter(org.apache.bcel.classfile.JavaClass obj) {
        for (org.apache.bcel.classfile.Attribute a
              :
              obj.
               getAttributes(
                 )) {
            if (a instanceof org.apache.bcel.classfile.Signature) {
                java.lang.String sig =
                  ((org.apache.bcel.classfile.Signature)
                     a).
                  getSignature(
                    );
                return sig.
                  charAt(
                    0) ==
                  '<';
            }
        }
        return false;
    }
    @java.lang.Override
    public void visitAfter(org.apache.bcel.classfile.JavaClass obj) {
        if (hasNativeMethods) {
            data.
              fieldsOfSerializableOrNativeClassed.
              addAll(
                data.
                  myFields);
            data.
              fieldsOfNativeClasses.
              addAll(
                data.
                  myFields);
        }
        if (isSerializable) {
            data.
              fieldsOfSerializableOrNativeClassed.
              addAll(
                data.
                  myFields);
        }
        if (sawSelfCallInConstructor) {
            data.
              myFields.
              removeAll(
                data.
                  writtenInConstructorFields);
            data.
              writtenInInitializationFields.
              addAll(
                data.
                  myFields);
        }
        data.
          myFields.
          clear(
            );
        data.
          allMyFields.
          clear(
            );
        data.
          calledFromConstructors.
          clear(
            );
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Field obj) {
        super.
          visit(
            obj);
        edu.umd.cs.findbugs.ba.XField f =
          edu.umd.cs.findbugs.ba.XFactory.
          createXField(
            this);
        data.
          allMyFields.
          add(
            f);
        java.lang.String signature =
          obj.
          getSignature(
            );
        if (!"serialVersionUID".
              equals(
                getFieldName(
                  ))) {
            data.
              myFields.
              add(
                f);
            if ("_jspx_dependants".
                  equals(
                    obj.
                      getName(
                        ))) {
                data.
                  containerFields.
                  add(
                    f);
            }
        }
        if (isSeleniumWebElement(
              signature)) {
            data.
              containerFields.
              add(
                f);
        }
    }
    public static boolean isSeleniumWebElement(java.lang.String signature) {
        return "Lorg/openqa/selenium/RenderedWebElement;".
          equals(
            signature) ||
          "Lorg/openqa/selenium/WebElement;".
          equals(
            signature);
    }
    @java.lang.Override
    public void visitAnnotation(java.lang.String annotationClass,
                                java.util.Map<java.lang.String,org.apache.bcel.classfile.ElementValue> map,
                                boolean runtimeVisible) {
        if (!visitingField(
               )) {
            return;
        }
        if (isInjectionAttribute(
              annotationClass)) {
            data.
              containerFields.
              add(
                edu.umd.cs.findbugs.ba.XFactory.
                  createXField(
                    this));
        }
        if (!annotationClass.
              startsWith(
                "edu.umd.cs.findbugs") &&
              !annotationClass.
              startsWith(
                "javax.lang")) {
            data.
              unknownAnnotation.
              add(
                edu.umd.cs.findbugs.ba.XFactory.
                  createXField(
                    this),
                annotationClass);
        }
    }
    public static boolean isInjectionAttribute(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                               java.lang.String annotationClass) {
        if (annotationClass.
              startsWith(
                "javax.annotation.") ||
              annotationClass.
              startsWith(
                "javax.ejb") ||
              "org.apache.tapestry5.annotations.Persist".
              equals(
                annotationClass) ||
              "org.jboss.seam.annotations.In".
              equals(
                annotationClass) ||
              annotationClass.
              startsWith(
                "javax.persistence") ||
              annotationClass.
              endsWith(
                "SpringBean") ||
              "com.google.inject.Inject".
              equals(
                annotationClass) ||
              annotationClass.
              startsWith(
                "com.google.") &&
              annotationClass.
              endsWith(
                ".Bind") &&
              annotationClass.
              hashCode(
                ) ==
              -243168318 ||
              annotationClass.
              startsWith(
                "org.nuxeo.common.xmap.annotation") ||
              annotationClass.
              startsWith(
                "com.google.gwt.uibinder.client") ||
              annotationClass.
              startsWith(
                "org.springframework.beans.factory.annotation") ||
              "javax.ws.rs.core.Context".
              equals(
                annotationClass)) {
            return true;
        }
        int lastDot =
          annotationClass.
          lastIndexOf(
            '.');
        java.lang.String lastPart =
          annotationClass.
          substring(
            lastDot +
              1);
        if (lastPart.
              startsWith(
                "Inject")) {
            return true;
        }
        return false;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.ConstantValue obj) {
        edu.umd.cs.findbugs.ba.XField f =
          edu.umd.cs.findbugs.ba.XFactory.
          createXField(
            this);
        data.
          constantFields.
          add(
            f);
        data.
          writtenFields.
          add(
            f);
    }
    int count_aload_1;
    private int previousOpcode;
    private int previousPreviousOpcode;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        count_aload_1 =
          0;
        previousOpcode =
          -1;
        previousPreviousOpcode =
          -1;
        data.
          nullTested.
          clear(
            );
        seenInvokeStatic =
          false;
        seenMonitorEnter =
          getMethod(
            ).
            isSynchronized(
              );
        data.
          staticFieldsReadInThisMethod.
          clear(
            );
        super.
          visit(
            obj);
        if ("<init>".
              equals(
                getMethodName(
                  )) &&
              count_aload_1 >
              1 &&
              (getClassName(
                 ).
                 indexOf(
                   '$') >=
                 0 ||
                 getClassName(
                   ).
                 indexOf(
                   '+') >=
                 0)) {
            data.
              needsOuterObjectInConstructor.
              add(
                getDottedClassName(
                  ));
        }
        bugAccumulator.
          reportAccumulatedBugs(
            );
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Checking " +
                getClassName(
                  ) +
                "." +
                obj.
                  getName(
                    ));
        }
        if ("<init>".
              equals(
                getMethodName(
                  )) &&
              (obj.
                 isPublic(
                   ) ||
                 obj.
                 isProtected(
                   ))) {
            publicOrProtectedConstructor =
              true;
        }
        pendingGetField =
          null;
        saState =
          0;
        super.
          visit(
            obj);
        int flags =
          obj.
          getAccessFlags(
            );
        if ((flags &
               ACC_NATIVE) !=
              0) {
            hasNativeMethods =
              true;
        }
    }
    boolean seenInvokeStatic;
    boolean seenMonitorEnter;
    edu.umd.cs.findbugs.ba.XField pendingGetField;
    edu.umd.cs.findbugs.detect.UnreadFieldsData
      data =
      new edu.umd.cs.findbugs.detect.UnreadFieldsData(
      );
    int saState;
    @java.lang.Override
    public void sawOpcode(int seen) { if (DEBUG) {
                                          java.lang.System.
                                            out.
                                            println(
                                              getPC(
                                                ) +
                                              ": " +
                                              OPCODE_NAMES[seen] +
                                              " " +
                                              saState);
                                      }
                                      if (seen ==
                                            MONITORENTER) {
                                          seenMonitorEnter =
                                            true;
                                      }
                                      switch (saState) {
                                          case 0:
                                              if (seen ==
                                                    ALOAD_0) {
                                                  saState =
                                                    1;
                                              }
                                              break;
                                          case 1:
                                              if (seen ==
                                                    ALOAD_0) {
                                                  saState =
                                                    2;
                                              }
                                              else {
                                                  saState =
                                                    0;
                                              }
                                              break;
                                          case 2:
                                              if (seen ==
                                                    GETFIELD) {
                                                  saState =
                                                    3;
                                              }
                                              else {
                                                  saState =
                                                    0;
                                              }
                                              break;
                                          case 3:
                                              if (seen ==
                                                    PUTFIELD) {
                                                  saState =
                                                    4;
                                              }
                                              else {
                                                  saState =
                                                    0;
                                              }
                                              break;
                                          default:
                                              break;
                                      }
                                      boolean selfAssignment =
                                        false;
                                      if (pendingGetField !=
                                            null) {
                                          if (seen !=
                                                PUTFIELD &&
                                                seen !=
                                                PUTSTATIC) {
                                              data.
                                                readFields.
                                                add(
                                                  pendingGetField);
                                          }
                                          else
                                              if (edu.umd.cs.findbugs.ba.XFactory.
                                                    createReferencedXField(
                                                      this).
                                                    equals(
                                                      pendingGetField) &&
                                                    (saState ==
                                                       4 ||
                                                       seen ==
                                                       PUTSTATIC)) {
                                                  selfAssignment =
                                                    true;
                                              }
                                              else {
                                                  data.
                                                    readFields.
                                                    add(
                                                      pendingGetField);
                                              }
                                          pendingGetField =
                                            null;
                                      }
                                      if (saState ==
                                            4) {
                                          saState =
                                            0;
                                      }
                                      if (seen ==
                                            INVOKESTATIC &&
                                            "java/util/concurrent/atomic/AtomicReferenceFieldUpdater".
                                            equals(
                                              getClassConstantOperand(
                                                )) &&
                                            "newUpdater".
                                            equals(
                                              getNameConstantOperand(
                                                ))) {
                                          java.lang.String fieldName =
                                            (java.lang.String)
                                              stack.
                                              getStackItem(
                                                0).
                                              getConstant(
                                                );
                                          java.lang.String fieldSignature =
                                            (java.lang.String)
                                              stack.
                                              getStackItem(
                                                1).
                                              getConstant(
                                                );
                                          java.lang.String fieldClass =
                                            (java.lang.String)
                                              stack.
                                              getStackItem(
                                                2).
                                              getConstant(
                                                );
                                          if (fieldName !=
                                                null &&
                                                fieldSignature !=
                                                null &&
                                                fieldClass !=
                                                null) {
                                              edu.umd.cs.findbugs.ba.XField f =
                                                edu.umd.cs.findbugs.ba.XFactory.
                                                createXField(
                                                  fieldClass.
                                                    replace(
                                                      '/',
                                                      '.'),
                                                  fieldName,
                                                  edu.umd.cs.findbugs.util.ClassName.
                                                    toSignature(
                                                      fieldSignature),
                                                  false);
                                              data.
                                                reflectiveFields.
                                                add(
                                                  f);
                                          }
                                      }
                                      if (seen ==
                                            INVOKESTATIC &&
                                            "java/util/concurrent/atomic/AtomicIntegerFieldUpdater".
                                            equals(
                                              getClassConstantOperand(
                                                )) &&
                                            "newUpdater".
                                            equals(
                                              getNameConstantOperand(
                                                ))) {
                                          java.lang.String fieldName =
                                            (java.lang.String)
                                              stack.
                                              getStackItem(
                                                0).
                                              getConstant(
                                                );
                                          java.lang.String fieldClass =
                                            (java.lang.String)
                                              stack.
                                              getStackItem(
                                                1).
                                              getConstant(
                                                );
                                          if (fieldName !=
                                                null &&
                                                fieldClass !=
                                                null) {
                                              edu.umd.cs.findbugs.ba.XField f =
                                                edu.umd.cs.findbugs.ba.XFactory.
                                                createXField(
                                                  fieldClass.
                                                    replace(
                                                      '/',
                                                      '.'),
                                                  fieldName,
                                                  "I",
                                                  false);
                                              data.
                                                reflectiveFields.
                                                add(
                                                  f);
                                          }
                                      }
                                      if (seen ==
                                            INVOKESTATIC &&
                                            "java/util/concurrent/atomic/AtomicLongFieldUpdater".
                                            equals(
                                              getClassConstantOperand(
                                                )) &&
                                            "newUpdater".
                                            equals(
                                              getNameConstantOperand(
                                                ))) {
                                          java.lang.String fieldName =
                                            (java.lang.String)
                                              stack.
                                              getStackItem(
                                                0).
                                              getConstant(
                                                );
                                          java.lang.String fieldClass =
                                            (java.lang.String)
                                              stack.
                                              getStackItem(
                                                1).
                                              getConstant(
                                                );
                                          if (fieldName !=
                                                null &&
                                                fieldClass !=
                                                null) {
                                              edu.umd.cs.findbugs.ba.XField f =
                                                edu.umd.cs.findbugs.ba.XFactory.
                                                createXField(
                                                  fieldClass.
                                                    replace(
                                                      '/',
                                                      '.'),
                                                  fieldName,
                                                  "J",
                                                  false);
                                              data.
                                                reflectiveFields.
                                                add(
                                                  f);
                                          }
                                      }
                                      if (seen ==
                                            GETSTATIC) {
                                          edu.umd.cs.findbugs.ba.XField f =
                                            edu.umd.cs.findbugs.ba.XFactory.
                                            createReferencedXField(
                                              this);
                                          data.
                                            staticFieldsReadInThisMethod.
                                            add(
                                              f);
                                      }
                                      else
                                          if (seen ==
                                                INVOKESTATIC) {
                                              seenInvokeStatic =
                                                true;
                                          }
                                          else
                                              if (seen ==
                                                    PUTSTATIC &&
                                                    !getMethod(
                                                       ).
                                                    isStatic(
                                                      )) {
                                                  edu.umd.cs.findbugs.ba.XField f =
                                                    edu.umd.cs.findbugs.ba.XFactory.
                                                    createReferencedXField(
                                                      this);
                                                  edu.umd.cs.findbugs.OpcodeStack.Item valuePut =
                                                    getStack(
                                                      ).
                                                    getStackItem(
                                                      0);
                                                  checkWriteToStaticFromInstanceMethod: if (f.
                                                                                              getName(
                                                                                                ).
                                                                                              indexOf(
                                                                                                "class$") !=
                                                                                              0) {
                                                      int priority =
                                                        LOW_PRIORITY;
                                                      if (f.
                                                            isReferenceType(
                                                              )) {
                                                          try {
                                                              edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow vnaDataflow =
                                                                getClassContext(
                                                                  ).
                                                                getValueNumberDataflow(
                                                                  getMethod(
                                                                    ));
                                                              edu.umd.cs.findbugs.ba.npe.IsNullValueDataflow invDataflow =
                                                                getClassContext(
                                                                  ).
                                                                getIsNullValueDataflow(
                                                                  getMethod(
                                                                    ));
                                                              edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vFrame =
                                                                vnaDataflow.
                                                                getAnalysis(
                                                                  ).
                                                                getFactAtPC(
                                                                  vnaDataflow.
                                                                    getCFG(
                                                                      ),
                                                                  getPC(
                                                                    ));
                                                              edu.umd.cs.findbugs.ba.npe.IsNullValueFrame iFrame =
                                                                invDataflow.
                                                                getAnalysis(
                                                                  ).
                                                                getFactAtPC(
                                                                  invDataflow.
                                                                    getCFG(
                                                                      ),
                                                                  getPC(
                                                                    ));
                                                              edu.umd.cs.findbugs.ba.vna.AvailableLoad l =
                                                                new edu.umd.cs.findbugs.ba.vna.AvailableLoad(
                                                                f);
                                                              edu.umd.cs.findbugs.ba.vna.ValueNumber[] availableLoads =
                                                                vFrame.
                                                                getAvailableLoad(
                                                                  l);
                                                              if (availableLoads !=
                                                                    null &&
                                                                    iFrame.
                                                                    isTrackValueNumbers(
                                                                      )) {
                                                                  for (edu.umd.cs.findbugs.ba.vna.ValueNumber v
                                                                        :
                                                                        availableLoads) {
                                                                      edu.umd.cs.findbugs.ba.npe.IsNullValue knownValue =
                                                                        iFrame.
                                                                        getKnownValue(
                                                                          v);
                                                                      if (knownValue ==
                                                                            null) {
                                                                          continue;
                                                                      }
                                                                      if (knownValue.
                                                                            isDefinitelyNotNull(
                                                                              )) {
                                                                          if (valuePut.
                                                                                isNull(
                                                                                  )) {
                                                                              priority++;
                                                                          }
                                                                          else {
                                                                              priority--;
                                                                          }
                                                                          break;
                                                                      }
                                                                      else
                                                                          if (knownValue.
                                                                                isDefinitelyNull(
                                                                                  )) {
                                                                              break checkWriteToStaticFromInstanceMethod;
                                                                          }
                                                                  }
                                                              }
                                                          }
                                                          catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                                                              edu.umd.cs.findbugs.ba.AnalysisContext.
                                                                logError(
                                                                  "foo",
                                                                  e);
                                                          }
                                                      }
                                                      if (!publicOrProtectedConstructor) {
                                                          priority--;
                                                      }
                                                      if (seenMonitorEnter) {
                                                          priority++;
                                                      }
                                                      if (!seenInvokeStatic &&
                                                            data.
                                                              staticFieldsReadInThisMethod.
                                                            isEmpty(
                                                              )) {
                                                          priority--;
                                                      }
                                                      if (getThisClass(
                                                            ).
                                                            isPublic(
                                                              ) &&
                                                            getMethod(
                                                              ).
                                                            isPublic(
                                                              )) {
                                                          priority--;
                                                      }
                                                      if (getThisClass(
                                                            ).
                                                            isPrivate(
                                                              ) ||
                                                            getMethod(
                                                              ).
                                                            isPrivate(
                                                              )) {
                                                          priority++;
                                                      }
                                                      if (getClassName(
                                                            ).
                                                            indexOf(
                                                              '$') !=
                                                            -1 ||
                                                            edu.umd.cs.findbugs.bcel.BCELUtil.
                                                            isSynthetic(
                                                              getMethod(
                                                                )) ||
                                                            f.
                                                            isSynthetic(
                                                              ) ||
                                                            f.
                                                            getName(
                                                              ).
                                                            indexOf(
                                                              '$') >=
                                                            0) {
                                                          priority++;
                                                      }
                                                      if (f.
                                                            getName(
                                                              ).
                                                            indexOf(
                                                              "DEBUG") >=
                                                            0 ||
                                                            f.
                                                            getName(
                                                              ).
                                                            indexOf(
                                                              "VERBOSE") >=
                                                            0 &&
                                                            "Z".
                                                            equals(
                                                              f.
                                                                getSignature(
                                                                  ))) {
                                                          priority++;
                                                          priority++;
                                                      }
                                                      if (("start".
                                                             equals(
                                                               getMethodName(
                                                                 )) ||
                                                             "stop".
                                                             equals(
                                                               getMethodName(
                                                                 ))) &&
                                                            "(Lorg/osgi/framework/BundleContext;)V".
                                                            equals(
                                                              getMethodSig(
                                                                ))) {
                                                          try {
                                                              org.apache.bcel.classfile.JavaClass bundleClass =
                                                                org.apache.bcel.Repository.
                                                                lookupClass(
                                                                  "org.osgi.framework.BundleActivator");
                                                              if (getThisClass(
                                                                    ).
                                                                    instanceOf(
                                                                      bundleClass)) {
                                                                  priority++;
                                                              }
                                                              if (f.
                                                                    isReferenceType(
                                                                      )) {
                                                                  edu.umd.cs.findbugs.classfile.FieldDescriptor fieldInfo =
                                                                    f.
                                                                    getFieldDescriptor(
                                                                      );
                                                                  java.lang.String dottedClass =
                                                                    edu.umd.cs.findbugs.DeepSubtypeAnalysis.
                                                                    getComponentClass(
                                                                      fieldInfo.
                                                                        getSignature(
                                                                          ));
                                                                  org.apache.bcel.classfile.JavaClass fieldClass =
                                                                    org.apache.bcel.Repository.
                                                                    lookupClass(
                                                                      dottedClass);
                                                                  if (fieldClass !=
                                                                        null &&
                                                                        fieldClass.
                                                                        instanceOf(
                                                                          bundleClass)) {
                                                                      priority =
                                                                        edu.umd.cs.findbugs.Priorities.
                                                                          IGNORE_PRIORITY;
                                                                  }
                                                              }
                                                          }
                                                          catch (java.lang.ClassNotFoundException e) {
                                                              bugReporter.
                                                                reportMissingClass(
                                                                  e);
                                                          }
                                                      }
                                                      bugAccumulator.
                                                        accumulateBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD",
                                                            priority).
                                                            addClassAndMethod(
                                                              this).
                                                            addField(
                                                              f),
                                                          this);
                                                  }
                                              }
                                      if (seen ==
                                            INVOKEVIRTUAL ||
                                            seen ==
                                            INVOKEINTERFACE ||
                                            seen ==
                                            INVOKESPECIAL ||
                                            seen ==
                                            INVOKESTATIC) {
                                          java.lang.String sig =
                                            getSigConstantOperand(
                                              );
                                          java.lang.String invokedClassName =
                                            getClassConstantOperand(
                                              );
                                          if (invokedClassName.
                                                equals(
                                                  getClassName(
                                                    )) &&
                                                ("<init>".
                                                   equals(
                                                     getMethodName(
                                                       )) ||
                                                   "<clinit>".
                                                   equals(
                                                     getMethodName(
                                                       )))) {
                                              data.
                                                calledFromConstructors.
                                                add(
                                                  getNameConstantOperand(
                                                    ) +
                                                  ":" +
                                                  sig);
                                          }
                                          int pos =
                                            edu.umd.cs.findbugs.visitclass.PreorderVisitor.
                                            getNumberArguments(
                                              sig);
                                          if (stack.
                                                getStackDepth(
                                                  ) >
                                                pos) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item item =
                                                stack.
                                                getStackItem(
                                                  pos);
                                              boolean superCall =
                                                seen ==
                                                INVOKESPECIAL &&
                                                !invokedClassName.
                                                equals(
                                                  getClassName(
                                                    ));
                                              if (DEBUG) {
                                                  java.lang.System.
                                                    out.
                                                    println(
                                                      "In " +
                                                      getFullyQualifiedMethodName(
                                                        ) +
                                                      " saw call on " +
                                                      item);
                                              }
                                              boolean selfCall =
                                                item.
                                                getRegisterNumber(
                                                  ) ==
                                                0 &&
                                                !superCall;
                                              if (selfCall &&
                                                    "<init>".
                                                    equals(
                                                      getMethodName(
                                                        ))) {
                                                  sawSelfCallInConstructor =
                                                    true;
                                                  if (DEBUG) {
                                                      java.lang.System.
                                                        out.
                                                        println(
                                                          "Saw self call in " +
                                                          getFullyQualifiedMethodName(
                                                            ) +
                                                          " to " +
                                                          invokedClassName +
                                                          "." +
                                                          getNameConstantOperand(
                                                            ));
                                                  }
                                              }
                                          }
                                      }
                                      if ((seen ==
                                             IFNULL ||
                                             seen ==
                                             IFNONNULL) &&
                                            stack.
                                            getStackDepth(
                                              ) >
                                            0) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item item =
                                            stack.
                                            getStackItem(
                                              0);
                                          edu.umd.cs.findbugs.ba.XField f =
                                            item.
                                            getXField(
                                              );
                                          if (f !=
                                                null) {
                                              data.
                                                nullTested.
                                                add(
                                                  f);
                                              if (DEBUG) {
                                                  java.lang.System.
                                                    out.
                                                    println(
                                                      f +
                                                      " null checked in " +
                                                      getFullyQualifiedMethodName(
                                                        ));
                                              }
                                          }
                                      }
                                      if ((seen ==
                                             IF_ACMPEQ ||
                                             seen ==
                                             IF_ACMPNE) &&
                                            stack.
                                            getStackDepth(
                                              ) >=
                                            2) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item item0 =
                                            stack.
                                            getStackItem(
                                              0);
                                          edu.umd.cs.findbugs.OpcodeStack.Item item1 =
                                            stack.
                                            getStackItem(
                                              1);
                                          edu.umd.cs.findbugs.ba.XField field1 =
                                            item1.
                                            getXField(
                                              );
                                          if (item0.
                                                isNull(
                                                  ) &&
                                                field1 !=
                                                null) {
                                              data.
                                                nullTested.
                                                add(
                                                  field1);
                                          }
                                          else {
                                              edu.umd.cs.findbugs.ba.XField field0 =
                                                item0.
                                                getXField(
                                                  );
                                              if (item1.
                                                    isNull(
                                                      ) &&
                                                    field0 !=
                                                    null) {
                                                  data.
                                                    nullTested.
                                                    add(
                                                      field0);
                                              }
                                          }
                                      }
                                      computePlacesAssumedNonnull: if (seen ==
                                                                         GETFIELD ||
                                                                         seen ==
                                                                         INVOKEVIRTUAL ||
                                                                         seen ==
                                                                         INVOKEINTERFACE ||
                                                                         seen ==
                                                                         INVOKESPECIAL ||
                                                                         seen ==
                                                                         PUTFIELD ||
                                                                         seen ==
                                                                         IALOAD ||
                                                                         seen ==
                                                                         AALOAD ||
                                                                         seen ==
                                                                         BALOAD ||
                                                                         seen ==
                                                                         CALOAD ||
                                                                         seen ==
                                                                         SALOAD ||
                                                                         seen ==
                                                                         IASTORE ||
                                                                         seen ==
                                                                         AASTORE ||
                                                                         seen ==
                                                                         BASTORE ||
                                                                         seen ==
                                                                         CASTORE ||
                                                                         seen ==
                                                                         SASTORE ||
                                                                         seen ==
                                                                         ARRAYLENGTH) {
                                          int pos =
                                            0;
                                          switch (seen) {
                                              case ARRAYLENGTH:
                                              case GETFIELD:
                                                  pos =
                                                    0;
                                                  break;
                                              case INVOKEVIRTUAL:
                                              case INVOKEINTERFACE:
                                              case INVOKESPECIAL:
                                                  java.lang.String sig =
                                                    getSigConstantOperand(
                                                      );
                                                  pos =
                                                    edu.umd.cs.findbugs.visitclass.PreorderVisitor.
                                                      getNumberArguments(
                                                        sig);
                                                  break;
                                              case PUTFIELD:
                                              case IALOAD:
                                              case AALOAD:
                                              case BALOAD:
                                              case CALOAD:
                                              case SALOAD:
                                                  pos =
                                                    1;
                                                  break;
                                              case IASTORE:
                                              case AASTORE:
                                              case BASTORE:
                                              case CASTORE:
                                              case SASTORE:
                                                  pos =
                                                    2;
                                                  break;
                                              default:
                                                  throw new java.lang.RuntimeException(
                                                    "Impossible");
                                          }
                                          if (stack.
                                                getStackDepth(
                                                  ) >=
                                                pos) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item item =
                                                stack.
                                                getStackItem(
                                                  pos);
                                              edu.umd.cs.findbugs.ba.XField f =
                                                item.
                                                getXField(
                                                  );
                                              if (f !=
                                                    null &&
                                                    !f.
                                                    isStatic(
                                                      ) &&
                                                    !data.
                                                       nullTested.
                                                    contains(
                                                      f) &&
                                                    !((data.
                                                         writtenInConstructorFields.
                                                         contains(
                                                           f) ||
                                                         data.
                                                           writtenInInitializationFields.
                                                         contains(
                                                           f)) &&
                                                        data.
                                                          writtenNonNullFields.
                                                        contains(
                                                          f))) {
                                                  try {
                                                      edu.umd.cs.findbugs.ba.npe.IsNullValueDataflow invDataflow =
                                                        getClassContext(
                                                          ).
                                                        getIsNullValueDataflow(
                                                          getMethod(
                                                            ));
                                                      edu.umd.cs.findbugs.ba.npe.IsNullValueFrame iFrame =
                                                        invDataflow.
                                                        getAnalysis(
                                                          ).
                                                        getFactBeforeExceptionCheck(
                                                          invDataflow.
                                                            getCFG(
                                                              ),
                                                          getPC(
                                                            ));
                                                      if (!iFrame.
                                                            isValid(
                                                              ) ||
                                                            iFrame.
                                                            getStackValue(
                                                              pos).
                                                            isDefinitelyNotNull(
                                                              )) {
                                                          break computePlacesAssumedNonnull;
                                                      }
                                                  }
                                                  catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                                                      edu.umd.cs.findbugs.ba.AnalysisContext.
                                                        logError(
                                                          "INV dataflow error when analyzing " +
                                                          getMethodDescriptor(
                                                            ),
                                                          e);
                                                  }
                                                  if (DEBUG) {
                                                      java.lang.System.
                                                        out.
                                                        println(
                                                          "RRR: " +
                                                          f +
                                                          " " +
                                                          data.
                                                            nullTested.
                                                            contains(
                                                              f) +
                                                          " " +
                                                          data.
                                                            writtenInConstructorFields.
                                                            contains(
                                                              f) +
                                                          " " +
                                                          data.
                                                            writtenNonNullFields.
                                                            contains(
                                                              f));
                                                  }
                                                  edu.umd.cs.findbugs.ProgramPoint p =
                                                    new edu.umd.cs.findbugs.ProgramPoint(
                                                    this);
                                                  java.util.Set<edu.umd.cs.findbugs.ProgramPoint> s =
                                                    data.
                                                      assumedNonNull.
                                                    get(
                                                      f);
                                                  if (s ==
                                                        null) {
                                                      s =
                                                        java.util.Collections.
                                                          singleton(
                                                            p);
                                                  }
                                                  else {
                                                      s =
                                                        edu.umd.cs.findbugs.util.Util.
                                                          addTo(
                                                            s,
                                                            p);
                                                  }
                                                  data.
                                                    assumedNonNull.
                                                    put(
                                                      f,
                                                      s);
                                                  if (DEBUG) {
                                                      java.lang.System.
                                                        out.
                                                        println(
                                                          f +
                                                          " assumed non-null in " +
                                                          getFullyQualifiedMethodName(
                                                            ));
                                                  }
                                              }
                                          }
                                      }
                                      if (seen ==
                                            ALOAD_1) {
                                          count_aload_1++;
                                      }
                                      else
                                          if (seen ==
                                                GETFIELD ||
                                                seen ==
                                                GETSTATIC) {
                                              edu.umd.cs.findbugs.ba.XField f =
                                                edu.umd.cs.findbugs.ba.XFactory.
                                                createReferencedXField(
                                                  this);
                                              pendingGetField =
                                                f;
                                              if ("readResolve".
                                                    equals(
                                                      getMethodName(
                                                        )) &&
                                                    seen ==
                                                    GETFIELD) {
                                                  data.
                                                    writtenFields.
                                                    add(
                                                      f);
                                                  data.
                                                    writtenNonNullFields.
                                                    add(
                                                      f);
                                              }
                                              if (DEBUG) {
                                                  java.lang.System.
                                                    out.
                                                    println(
                                                      "get: " +
                                                      f);
                                              }
                                              if (data.
                                                    writtenFields.
                                                    contains(
                                                      f)) {
                                                  data.
                                                    fieldAccess.
                                                    remove(
                                                      f);
                                              }
                                              else
                                                  if (!data.
                                                         fieldAccess.
                                                        containsKey(
                                                          f)) {
                                                      data.
                                                        fieldAccess.
                                                        put(
                                                          f,
                                                          edu.umd.cs.findbugs.SourceLineAnnotation.
                                                            fromVisitedInstruction(
                                                              this));
                                                  }
                                          }
                                          else
                                              if ((seen ==
                                                     PUTFIELD ||
                                                     seen ==
                                                     PUTSTATIC) &&
                                                    !selfAssignment) {
                                                  edu.umd.cs.findbugs.ba.XField f =
                                                    edu.umd.cs.findbugs.ba.XFactory.
                                                    createReferencedXField(
                                                      this);
                                                  edu.umd.cs.findbugs.OpcodeStack.Item item =
                                                    null;
                                                  if (stack.
                                                        getStackDepth(
                                                          ) >
                                                        0) {
                                                      item =
                                                        stack.
                                                          getStackItem(
                                                            0);
                                                      if (!item.
                                                            isNull(
                                                              )) {
                                                          data.
                                                            nullTested.
                                                            add(
                                                              f);
                                                      }
                                                  }
                                                  data.
                                                    writtenFields.
                                                    add(
                                                      f);
                                                  boolean writtingNonNull =
                                                    previousOpcode !=
                                                    ACONST_NULL ||
                                                    previousPreviousOpcode ==
                                                    GOTO;
                                                  if (writtingNonNull) {
                                                      data.
                                                        writtenNonNullFields.
                                                        add(
                                                          f);
                                                      if (DEBUG) {
                                                          java.lang.System.
                                                            out.
                                                            println(
                                                              "put nn: " +
                                                              f);
                                                      }
                                                  }
                                                  else
                                                      if (DEBUG) {
                                                          java.lang.System.
                                                            out.
                                                            println(
                                                              "put: " +
                                                              f);
                                                      }
                                                  if (writtingNonNull &&
                                                        data.
                                                          readFields.
                                                        contains(
                                                          f)) {
                                                      data.
                                                        fieldAccess.
                                                        remove(
                                                          f);
                                                  }
                                                  else
                                                      if (!data.
                                                             fieldAccess.
                                                            containsKey(
                                                              f)) {
                                                          data.
                                                            fieldAccess.
                                                            put(
                                                              f,
                                                              edu.umd.cs.findbugs.SourceLineAnnotation.
                                                                fromVisitedInstruction(
                                                                  this));
                                                      }
                                                  boolean isConstructor =
                                                    "<init>".
                                                    equals(
                                                      getMethodName(
                                                        )) ||
                                                    "<clinit>".
                                                    equals(
                                                      getMethodName(
                                                        ));
                                                  if (getMethod(
                                                        ).
                                                        isStatic(
                                                          ) ==
                                                        f.
                                                        isStatic(
                                                          ) &&
                                                        (isConstructor ||
                                                           data.
                                                             calledFromConstructors.
                                                           contains(
                                                             getMethodName(
                                                               ) +
                                                             ":" +
                                                             getMethodSig(
                                                               )) ||
                                                           "init".
                                                           equals(
                                                             getMethodName(
                                                               )) ||
                                                           "init".
                                                           equals(
                                                             getMethodName(
                                                               )) ||
                                                           "initialize".
                                                           equals(
                                                             getMethodName(
                                                               )) ||
                                                           getMethod(
                                                             ).
                                                           isPrivate(
                                                             ))) {
                                                      if (isConstructor) {
                                                          data.
                                                            writtenInConstructorFields.
                                                            add(
                                                              f);
                                                          if ("Ljava/lang/ThreadLocal;".
                                                                equals(
                                                                  f.
                                                                    getSignature(
                                                                      )) &&
                                                                item !=
                                                                null &&
                                                                item.
                                                                isNewlyAllocated(
                                                                  )) {
                                                              data.
                                                                threadLocalAssignedInConstructor.
                                                                put(
                                                                  f,
                                                                  new edu.umd.cs.findbugs.ProgramPoint(
                                                                    this));
                                                          }
                                                      }
                                                      else {
                                                          data.
                                                            writtenInInitializationFields.
                                                            add(
                                                              f);
                                                      }
                                                      if (writtingNonNull) {
                                                          data.
                                                            assumedNonNull.
                                                            remove(
                                                              f);
                                                      }
                                                  }
                                                  else {
                                                      data.
                                                        writtenOutsideOfInitializationFields.
                                                        add(
                                                          f);
                                                  }
                                              }
                                      previousPreviousOpcode =
                                        previousOpcode;
                                      previousOpcode =
                                        seen;
    }
    @java.lang.Deprecated
    public boolean isReflexive(edu.umd.cs.findbugs.ba.XField f) {
        return data.
          isReflexive(
            f);
    }
    static java.util.regex.Pattern dontComplainAbout =
      java.util.regex.Pattern.
      compile(
        "class[$]");
    static java.util.regex.Pattern withinAnonymousClass =
      java.util.regex.Pattern.
      compile(
        "[$][0-9].*[$]");
    @java.lang.Override
    public void report() { java.util.Set<java.lang.String> fieldNamesSet =
                             new java.util.HashSet<java.lang.String>(
                             );
                           for (edu.umd.cs.findbugs.ba.XField f
                                 :
                                 data.
                                   writtenNonNullFields) {
                               fieldNamesSet.
                                 add(
                                   f.
                                     getName(
                                       ));
                           }
                           if (DEBUG) { java.lang.System.
                                          out.
                                          println(
                                            "read fields:");
                                        for (edu.umd.cs.findbugs.ba.XField f
                                              :
                                              data.
                                                readFields) {
                                            java.lang.System.
                                              out.
                                              println(
                                                "  " +
                                                f);
                                        }
                                        if (!data.
                                               containerFields.
                                              isEmpty(
                                                )) {
                                            java.lang.System.
                                              out.
                                              println(
                                                "ejb3 fields:");
                                            for (edu.umd.cs.findbugs.ba.XField f
                                                  :
                                                  data.
                                                    containerFields) {
                                                java.lang.System.
                                                  out.
                                                  println(
                                                    "  " +
                                                    f);
                                            }
                                        }
                                        if (!data.
                                               reflectiveFields.
                                              isEmpty(
                                                )) {
                                            java.lang.System.
                                              out.
                                              println(
                                                "reflective fields:");
                                            for (edu.umd.cs.findbugs.ba.XField f
                                                  :
                                                  data.
                                                    reflectiveFields) {
                                                java.lang.System.
                                                  out.
                                                  println(
                                                    "  " +
                                                    f);
                                            }
                                        }
                                        java.lang.System.
                                          out.
                                          println(
                                            "written fields:");
                                        for (edu.umd.cs.findbugs.ba.XField f
                                              :
                                              data.
                                                writtenFields) {
                                            java.lang.System.
                                              out.
                                              println(
                                                "  " +
                                                f);
                                        }
                                        java.lang.System.
                                          out.
                                          println(
                                            "written nonnull fields:");
                                        for (edu.umd.cs.findbugs.ba.XField f
                                              :
                                              data.
                                                writtenNonNullFields) {
                                            java.lang.System.
                                              out.
                                              println(
                                                "  " +
                                                f);
                                        }
                                        java.lang.System.
                                          out.
                                          println(
                                            "assumed nonnull fields:");
                                        for (edu.umd.cs.findbugs.ba.XField f
                                              :
                                              data.
                                                assumedNonNull.
                                               keySet(
                                                 )) {
                                            java.lang.System.
                                              out.
                                              println(
                                                "  " +
                                                f);
                                        }
                           }
                           java.util.Set<edu.umd.cs.findbugs.ba.XField> declaredFields =
                             new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
                             );
                           edu.umd.cs.findbugs.ba.AnalysisContext currentAnalysisContext =
                             edu.umd.cs.findbugs.ba.AnalysisContext.
                             currentAnalysisContext(
                               );
                           edu.umd.cs.findbugs.ba.XFactory xFactory =
                             edu.umd.cs.findbugs.ba.AnalysisContext.
                             currentXFactory(
                               );
                           for (edu.umd.cs.findbugs.ba.XField f
                                 :
                                 edu.umd.cs.findbugs.ba.AnalysisContext.
                                  currentXFactory(
                                    ).
                                  allFields(
                                    )) { edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor =
                                           f.
                                           getClassDescriptor(
                                             );
                                         if (currentAnalysisContext.
                                               isApplicationClass(
                                                 classDescriptor) &&
                                               !currentAnalysisContext.
                                               isTooBig(
                                                 classDescriptor) &&
                                               !xFactory.
                                               isReflectiveClass(
                                                 classDescriptor)) {
                                             declaredFields.
                                               add(
                                                 f);
                                         }
                           }
                           java.util.HashSet<edu.umd.cs.findbugs.ba.XField> unknownAnotationAndUnwritten =
                             new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
                             data.
                               unknownAnnotation.
                               keySet(
                                 ));
                           unknownAnotationAndUnwritten.
                             removeAll(
                               data.
                                 writtenFields);
                           declaredFields.
                             removeAll(
                               unknownAnotationAndUnwritten);
                           declaredFields.
                             removeAll(
                               data.
                                 containerFields);
                           declaredFields.
                             removeAll(
                               data.
                                 reflectiveFields);
                           for (java.util.Iterator<edu.umd.cs.findbugs.ba.XField> i =
                                  declaredFields.
                                  iterator(
                                    ); i.
                                         hasNext(
                                           );
                                ) { edu.umd.cs.findbugs.ba.XField f =
                                      i.
                                      next(
                                        );
                                    if (f.
                                          isSynthetic(
                                            ) &&
                                          !f.
                                          getName(
                                            ).
                                          startsWith(
                                            "this$") ||
                                          f.
                                          getName(
                                            ).
                                          startsWith(
                                            "_")) {
                                        i.
                                          remove(
                                            );
                                    } }
                           java.util.TreeSet<edu.umd.cs.findbugs.ba.XField> notInitializedInConstructors =
                             new java.util.TreeSet<edu.umd.cs.findbugs.ba.XField>(
                             declaredFields);
                           notInitializedInConstructors.
                             retainAll(
                               data.
                                 readFields);
                           notInitializedInConstructors.
                             retainAll(
                               data.
                                 writtenNonNullFields);
                           notInitializedInConstructors.
                             retainAll(
                               data.
                                 assumedNonNull.
                                 keySet(
                                   ));
                           notInitializedInConstructors.
                             removeAll(
                               data.
                                 writtenInConstructorFields);
                           notInitializedInConstructors.
                             removeAll(
                               data.
                                 writtenInInitializationFields);
                           for (java.util.Iterator<edu.umd.cs.findbugs.ba.XField> i =
                                  notInitializedInConstructors.
                                  iterator(
                                    ); i.
                                         hasNext(
                                           );
                                ) { if (i.
                                          next(
                                            ).
                                          isStatic(
                                            )) {
                                        i.
                                          remove(
                                            );
                                    } }
                           java.util.TreeSet<edu.umd.cs.findbugs.ba.XField> readOnlyFields =
                             new java.util.TreeSet<edu.umd.cs.findbugs.ba.XField>(
                             declaredFields);
                           readOnlyFields.
                             removeAll(
                               data.
                                 writtenFields);
                           readOnlyFields.
                             retainAll(
                               data.
                                 readFields);
                           java.util.TreeSet<edu.umd.cs.findbugs.ba.XField> nullOnlyFields =
                             new java.util.TreeSet<edu.umd.cs.findbugs.ba.XField>(
                             declaredFields);
                           nullOnlyFields.
                             removeAll(
                               data.
                                 writtenNonNullFields);
                           nullOnlyFields.
                             retainAll(
                               data.
                                 readFields);
                           java.util.Set<edu.umd.cs.findbugs.ba.XField> writeOnlyFields =
                             declaredFields;
                           writeOnlyFields.
                             removeAll(
                               data.
                                 readFields);
                           java.util.Map<java.lang.String,java.lang.Integer> count =
                             new java.util.HashMap<java.lang.String,java.lang.Integer>(
                             );
                           edu.umd.cs.findbugs.util.Bag<java.lang.String> nullOnlyFieldNames =
                             new edu.umd.cs.findbugs.util.Bag<java.lang.String>(
                             );
                           edu.umd.cs.findbugs.util.Bag<edu.umd.cs.findbugs.classfile.ClassDescriptor> classContainingNullOnlyFields =
                             new edu.umd.cs.findbugs.util.Bag<edu.umd.cs.findbugs.classfile.ClassDescriptor>(
                             );
                           for (edu.umd.cs.findbugs.ba.XField f
                                 :
                                 nullOnlyFields) {
                               nullOnlyFieldNames.
                                 add(
                                   f.
                                     getName(
                                       ));
                               classContainingNullOnlyFields.
                                 add(
                                   f.
                                     getClassDescriptor(
                                       ));
                               int increment =
                                 3;
                               java.util.Collection<edu.umd.cs.findbugs.ProgramPoint> assumedNonNullAt =
                                 data.
                                   assumedNonNull.
                                 get(
                                   f);
                               if (assumedNonNullAt !=
                                     null) {
                                   increment +=
                                     assumedNonNullAt.
                                       size(
                                         );
                               }
                               for (java.lang.String s
                                     :
                                     data.
                                       unknownAnnotation.
                                      get(
                                        f)) {
                                   java.lang.Integer value =
                                     count.
                                     get(
                                       s);
                                   if (value ==
                                         null) {
                                       count.
                                         put(
                                           s,
                                           increment);
                                   }
                                   else {
                                       count.
                                         put(
                                           s,
                                           value +
                                             increment);
                                   }
                               }
                           }
                           java.util.Map<edu.umd.cs.findbugs.ba.XField,java.lang.Integer> maxCount =
                             new java.util.HashMap<edu.umd.cs.findbugs.ba.XField,java.lang.Integer>(
                             );
                           java.util.LinkedList<edu.umd.cs.findbugs.ba.XField> assumeReflective =
                             new java.util.LinkedList<edu.umd.cs.findbugs.ba.XField>(
                             );
                           for (edu.umd.cs.findbugs.ba.XField f
                                 :
                                 nullOnlyFields) {
                               int myMaxCount =
                                 0;
                               for (java.lang.String s
                                     :
                                     data.
                                       unknownAnnotation.
                                      get(
                                        f)) {
                                   java.lang.Integer value =
                                     count.
                                     get(
                                       s);
                                   if (value !=
                                         null &&
                                         myMaxCount <
                                         value) {
                                       myMaxCount =
                                         value;
                                   }
                               }
                               if (myMaxCount >
                                     0) {
                                   maxCount.
                                     put(
                                       f,
                                       myMaxCount);
                               }
                               if (myMaxCount >
                                     15) {
                                   assumeReflective.
                                     add(
                                       f);
                               }
                               else
                                   if (nullOnlyFieldNames.
                                         getCount(
                                           f.
                                             getName(
                                               )) >
                                         8) {
                                       assumeReflective.
                                         add(
                                           f);
                                   }
                                   else
                                       if (classContainingNullOnlyFields.
                                             getCount(
                                               f.
                                                 getClassDescriptor(
                                                   )) >
                                             4) {
                                           assumeReflective.
                                             add(
                                               f);
                                       }
                                       else
                                           if (classContainingNullOnlyFields.
                                                 getCount(
                                                   f.
                                                     getClassDescriptor(
                                                       )) >
                                                 2 &&
                                                 f.
                                                 getName(
                                                   ).
                                                 length(
                                                   ) ==
                                                 1) {
                                               assumeReflective.
                                                 add(
                                                   f);
                                           }
                           }
                           readOnlyFields.
                             removeAll(
                               assumeReflective);
                           nullOnlyFields.
                             removeAll(
                               assumeReflective);
                           notInitializedInConstructors.
                             removeAll(
                               assumeReflective);
                           edu.umd.cs.findbugs.util.Bag<java.lang.String> notInitializedUses =
                             new edu.umd.cs.findbugs.util.Bag<java.lang.String>(
                             );
                           for (edu.umd.cs.findbugs.ba.XField f
                                 :
                                 notInitializedInConstructors) {
                               java.lang.String className =
                                 f.
                                 getClassName(
                                   );
                               java.util.Set<edu.umd.cs.findbugs.ProgramPoint> assumedNonnullAt =
                                 data.
                                   assumedNonNull.
                                 get(
                                   f);
                               notInitializedUses.
                                 add(
                                   className,
                                   assumedNonnullAt.
                                     size(
                                       ));
                           }
                           for (edu.umd.cs.findbugs.ba.XField f
                                 :
                                 notInitializedInConstructors) {
                               java.lang.String className =
                                 f.
                                 getClassName(
                                   );
                               if (notInitializedUses.
                                     getCount(
                                       className) >=
                                     8) {
                                   continue;
                               }
                               java.lang.String fieldSignature =
                                 f.
                                 getSignature(
                                   );
                               if (f.
                                     isResolved(
                                       ) &&
                                     !data.
                                        fieldsOfNativeClasses.
                                     contains(
                                       f) &&
                                     (fieldSignature.
                                        charAt(
                                          0) ==
                                        'L' ||
                                        fieldSignature.
                                        charAt(
                                          0) ==
                                        '[')) {
                                   int priority =
                                     LOW_PRIORITY;
                                   java.util.Set<edu.umd.cs.findbugs.ProgramPoint> assumedNonnullAt =
                                     data.
                                       assumedNonNull.
                                     get(
                                       f);
                                   if (assumedNonnullAt.
                                         size(
                                           ) <
                                         4) {
                                       for (edu.umd.cs.findbugs.ProgramPoint p
                                             :
                                             assumedNonnullAt) {
                                           edu.umd.cs.findbugs.BugInstance bug =
                                             new edu.umd.cs.findbugs.BugInstance(
                                             this,
                                             "UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR",
                                             priority).
                                             addClass(
                                               className).
                                             addField(
                                               f).
                                             addMethod(
                                               p.
                                                 getMethodAnnotation(
                                                   ));
                                           bugAccumulator.
                                             accumulateBug(
                                               bug,
                                               p.
                                                 getSourceLineAnnotation(
                                                   ));
                                       }
                                   }
                               }
                           }
                           for (edu.umd.cs.findbugs.ba.XField f
                                 :
                                 readOnlyFields) {
                               java.lang.String fieldSignature =
                                 f.
                                 getSignature(
                                   );
                               if (f.
                                     isResolved(
                                       ) &&
                                     !data.
                                        fieldsOfNativeClasses.
                                     contains(
                                       f)) {
                                   int priority =
                                     NORMAL_PRIORITY;
                                   if (!(fieldSignature.
                                           charAt(
                                             0) ==
                                           'L' ||
                                           fieldSignature.
                                           charAt(
                                             0) ==
                                           '[')) {
                                       priority++;
                                   }
                                   if (maxCount.
                                         containsKey(
                                           f)) {
                                       priority++;
                                   }
                                   java.lang.String pattern =
                                     "UWF_UNWRITTEN_FIELD";
                                   if (f.
                                         isProtected(
                                           ) ||
                                         f.
                                         isPublic(
                                           )) {
                                       pattern =
                                         "UWF_UNWRITTEN_PUBLIC_OR_PROTECTED_FIELD";
                                   }
                                   bugReporter.
                                     reportBug(
                                       addClassFieldAndAccess(
                                         new edu.umd.cs.findbugs.BugInstance(
                                           this,
                                           pattern,
                                           priority),
                                         f));
                               }
                           }
                           for (edu.umd.cs.findbugs.ba.XField f
                                 :
                                 nullOnlyFields) {
                               if (DEBUG) {
                                   java.lang.System.
                                     out.
                                     println(
                                       "Null only: " +
                                       f);
                                   java.lang.System.
                                     out.
                                     println(
                                       "   : " +
                                       data.
                                         assumedNonNull.
                                         containsKey(
                                           f));
                                   java.lang.System.
                                     out.
                                     println(
                                       "   : " +
                                       data.
                                         fieldsOfSerializableOrNativeClassed.
                                         contains(
                                           f));
                                   java.lang.System.
                                     out.
                                     println(
                                       "   : " +
                                       fieldNamesSet.
                                         contains(
                                           f.
                                             getName(
                                               )));
                                   java.lang.System.
                                     out.
                                     println(
                                       "   : " +
                                       data.
                                         abstractClasses.
                                         contains(
                                           f.
                                             getClassName(
                                               )));
                                   java.lang.System.
                                     out.
                                     println(
                                       "   : " +
                                       data.
                                         hasNonAbstractSubClass.
                                         contains(
                                           f.
                                             getClassName(
                                               )));
                                   java.lang.System.
                                     out.
                                     println(
                                       "   : " +
                                       f.
                                         isResolved(
                                           ));
                               }
                               if (!f.
                                     isResolved(
                                       )) {
                                   continue;
                               }
                               if (data.
                                     fieldsOfNativeClasses.
                                     contains(
                                       f)) {
                                   continue;
                               }
                               if (DEBUG) {
                                   java.lang.System.
                                     out.
                                     println(
                                       "Ready to report");
                               }
                               int priority =
                                 NORMAL_PRIORITY;
                               if (maxCount.
                                     containsKey(
                                       f)) {
                                   priority++;
                               }
                               if (data.
                                     abstractClasses.
                                     contains(
                                       f.
                                         getClassName(
                                           ))) {
                                   priority++;
                                   if (!data.
                                          hasNonAbstractSubClass.
                                         contains(
                                           f.
                                             getClassName(
                                               ))) {
                                       priority++;
                                   }
                               }
                               if (data.
                                     assumedNonNull.
                                     containsKey(
                                       f)) {
                                   int npPriority =
                                     priority;
                                   java.util.Set<edu.umd.cs.findbugs.ProgramPoint> assumedNonNullAt =
                                     data.
                                       assumedNonNull.
                                     get(
                                       f);
                                   if (assumedNonNullAt.
                                         size(
                                           ) >
                                         14) {
                                       npPriority +=
                                         2;
                                   }
                                   else
                                       if (assumedNonNullAt.
                                             size(
                                               ) >
                                             6) {
                                           npPriority++;
                                       }
                                       else {
                                           priority--;
                                       }
                                   java.lang.String pattern =
                                     f.
                                     isPublic(
                                       ) ||
                                     f.
                                     isProtected(
                                       )
                                     ? "NP_UNWRITTEN_PUBLIC_OR_PROTECTED_FIELD"
                                     : "NP_UNWRITTEN_FIELD";
                                   for (edu.umd.cs.findbugs.ProgramPoint p
                                         :
                                         assumedNonNullAt) {
                                       bugAccumulator.
                                         accumulateBug(
                                           new edu.umd.cs.findbugs.BugInstance(
                                             this,
                                             pattern,
                                             npPriority).
                                             addClassAndMethod(
                                               p.
                                                 method).
                                             addField(
                                               f),
                                           p.
                                             getSourceLineAnnotation(
                                               ));
                                   }
                               }
                               else {
                                   if (f.
                                         isStatic(
                                           )) {
                                       priority++;
                                   }
                                   if (f.
                                         isFinal(
                                           )) {
                                       priority++;
                                   }
                                   if (data.
                                         fieldsOfSerializableOrNativeClassed.
                                         contains(
                                           f)) {
                                       priority++;
                                   }
                               }
                               if (!readOnlyFields.
                                     contains(
                                       f)) {
                                   bugReporter.
                                     reportBug(
                                       addClassFieldAndAccess(
                                         new edu.umd.cs.findbugs.BugInstance(
                                           this,
                                           "UWF_NULL_FIELD",
                                           priority),
                                         f).
                                         lowerPriorityIfDeprecated(
                                           ));
                               }
                           }
                           writeOnlyFields: for (edu.umd.cs.findbugs.ba.XField f
                                                  :
                                                  writeOnlyFields) {
                               java.lang.String fieldName =
                                 f.
                                 getName(
                                   );
                               java.lang.String className =
                                 f.
                                 getClassName(
                                   );
                               int lastDollar =
                                 java.lang.Math.
                                 max(
                                   className.
                                     lastIndexOf(
                                       '$'),
                                   className.
                                     lastIndexOf(
                                       '+'));
                               boolean isAnonymousInnerClass =
                                 lastDollar >
                                 0 &&
                                 lastDollar <
                                 className.
                                 length(
                                   ) -
                                 1 &&
                                 java.lang.Character.
                                 isDigit(
                                   className.
                                     charAt(
                                       lastDollar +
                                         1));
                               if (DEBUG) {
                                   java.lang.System.
                                     out.
                                     println(
                                       "Checking write only field " +
                                       className +
                                       "." +
                                       fieldName +
                                       "\t" +
                                       data.
                                         constantFields.
                                         contains(
                                           f) +
                                       "\t" +
                                       f.
                                         isStatic(
                                           ));
                               }
                               if (!f.
                                     isResolved(
                                       )) {
                                   continue;
                               }
                               if (dontComplainAbout.
                                     matcher(
                                       fieldName).
                                     find(
                                       )) {
                                   continue;
                               }
                               if (lastDollar >=
                                     0 &&
                                     (fieldName.
                                        startsWith(
                                          "this$") ||
                                        fieldName.
                                        startsWith(
                                          "this+"))) {
                                   java.lang.String outerClassName =
                                     className.
                                     substring(
                                       0,
                                       lastDollar);
                                   try {
                                       edu.umd.cs.findbugs.ba.XClass thisClass =
                                         edu.umd.cs.findbugs.classfile.Global.
                                         getAnalysisCache(
                                           ).
                                         getClassAnalysis(
                                           edu.umd.cs.findbugs.ba.XClass.class,
                                           f.
                                             getClassDescriptor(
                                               ));
                                       if (isAnonymousInnerClass) {
                                           for (edu.umd.cs.findbugs.ba.XField f2
                                                 :
                                                 thisClass.
                                                  getXFields(
                                                    )) {
                                               if (f2 !=
                                                     f &&
                                                     f2.
                                                     isPrivate(
                                                       ) &&
                                                     f2.
                                                     isSynthetic(
                                                       ) &&
                                                     !f2.
                                                     getName(
                                                       ).
                                                     startsWith(
                                                       "this$") &&
                                                     f2.
                                                     getName(
                                                       ).
                                                     contains(
                                                       "$")) {
                                                   continue writeOnlyFields;
                                               }
                                           }
                                       }
                                       org.apache.bcel.classfile.JavaClass outerClass =
                                         org.apache.bcel.Repository.
                                         lookupClass(
                                           outerClassName);
                                       if (classHasParameter(
                                             outerClass)) {
                                           continue;
                                       }
                                       edu.umd.cs.findbugs.classfile.ClassDescriptor cDesc =
                                         edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                         createClassDescriptorFromDottedClassName(
                                           outerClassName);
                                       edu.umd.cs.findbugs.ba.XClass outerXClass =
                                         edu.umd.cs.findbugs.classfile.Global.
                                         getAnalysisCache(
                                           ).
                                         getClassAnalysis(
                                           edu.umd.cs.findbugs.ba.XClass.class,
                                           cDesc);
                                       edu.umd.cs.findbugs.ba.AnalysisContext analysisContext =
                                         edu.umd.cs.findbugs.ba.AnalysisContext.
                                         currentAnalysisContext(
                                           );
                                       edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
                                         analysisContext.
                                         getSubtypes2(
                                           );
                                       for (edu.umd.cs.findbugs.ba.XField of
                                             :
                                             outerXClass.
                                              getXFields(
                                                )) {
                                           if (!of.
                                                 isStatic(
                                                   )) {
                                               java.lang.String sourceSignature =
                                                 of.
                                                 getSourceSignature(
                                                   );
                                               if (sourceSignature !=
                                                     null &&
                                                     "Ljava/lang/ThreadLocal;".
                                                     equals(
                                                       of.
                                                         getSignature(
                                                           ))) {
                                                   org.apache.bcel.generic.Type ofType =
                                                     edu.umd.cs.findbugs.ba.generic.GenericUtilities.
                                                     getType(
                                                       sourceSignature);
                                                   if (ofType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType) {
                                                       edu.umd.cs.findbugs.ba.generic.GenericObjectType gType =
                                                         (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                                                           ofType;
                                                       for (org.apache.bcel.generic.ReferenceType r
                                                             :
                                                             gType.
                                                              getParameters(
                                                                )) {
                                                           if (r instanceof org.apache.bcel.generic.ObjectType) {
                                                               edu.umd.cs.findbugs.classfile.ClassDescriptor c =
                                                                 edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                                 getClassDescriptor(
                                                                   (org.apache.bcel.generic.ObjectType)
                                                                     r);
                                                               if (subtypes2.
                                                                     isSubtype(
                                                                       f.
                                                                         getClassDescriptor(
                                                                           ),
                                                                       c)) {
                                                                   edu.umd.cs.findbugs.ProgramPoint p =
                                                                     data.
                                                                       threadLocalAssignedInConstructor.
                                                                     get(
                                                                       of);
                                                                   int priority =
                                                                     p ==
                                                                     null
                                                                     ? NORMAL_PRIORITY
                                                                     : HIGH_PRIORITY;
                                                                   edu.umd.cs.findbugs.BugInstance bug =
                                                                     new edu.umd.cs.findbugs.BugInstance(
                                                                     this,
                                                                     "SIC_THREADLOCAL_DEADLY_EMBRACE",
                                                                     priority).
                                                                     addClass(
                                                                       className).
                                                                     addField(
                                                                       of);
                                                                   if (p !=
                                                                         null) {
                                                                       bug.
                                                                         addMethod(
                                                                           p.
                                                                             method).
                                                                         add(
                                                                           p.
                                                                             getSourceLineAnnotation(
                                                                               ));
                                                                   }
                                                                   bugReporter.
                                                                     reportBug(
                                                                       bug);
                                                               }
                                                           }
                                                       }
                                                   }
                                               }
                                           }
                                       }
                                       boolean outerClassIsInnerClass =
                                         false;
                                       for (org.apache.bcel.classfile.Field field
                                             :
                                             outerClass.
                                              getFields(
                                                )) {
                                           if ("this$0".
                                                 equals(
                                                   field.
                                                     getName(
                                                       ))) {
                                               outerClassIsInnerClass =
                                                 true;
                                           }
                                       }
                                       if (outerClassIsInnerClass) {
                                           continue;
                                       }
                                   }
                                   catch (java.lang.ClassNotFoundException e) {
                                       bugReporter.
                                         reportMissingClass(
                                           e);
                                   }
                                   catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                                       bugReporter.
                                         logError(
                                           "Error getting outer XClass for " +
                                           outerClassName,
                                           e);
                                   }
                                   if (!data.
                                          innerClassCannotBeStatic.
                                         contains(
                                           className)) {
                                       boolean easyChange =
                                         !data.
                                            needsOuterObjectInConstructor.
                                         contains(
                                           className);
                                       if (easyChange ||
                                             !isAnonymousInnerClass) {
                                           int priority =
                                             LOW_PRIORITY;
                                           if (easyChange &&
                                                 !isAnonymousInnerClass) {
                                               priority =
                                                 NORMAL_PRIORITY;
                                           }
                                           java.lang.String bug =
                                             "SIC_INNER_SHOULD_BE_STATIC";
                                           if (isAnonymousInnerClass) {
                                               bug =
                                                 "SIC_INNER_SHOULD_BE_STATIC_ANON";
                                           }
                                           else
                                               if (!easyChange) {
                                                   bug =
                                                     "SIC_INNER_SHOULD_BE_STATIC_NEEDS_THIS";
                                               }
                                           bugReporter.
                                             reportBug(
                                               new edu.umd.cs.findbugs.BugInstance(
                                                 this,
                                                 bug,
                                                 priority).
                                                 addClass(
                                                   className));
                                       }
                                   }
                               }
                               else
                                   if (f.
                                         isResolved(
                                           )) {
                                       if (data.
                                             constantFields.
                                             contains(
                                               f)) {
                                           if (!f.
                                                 isStatic(
                                                   )) {
                                               bugReporter.
                                                 reportBug(
                                                   addClassFieldAndAccess(
                                                     new edu.umd.cs.findbugs.BugInstance(
                                                       this,
                                                       "SS_SHOULD_BE_STATIC",
                                                       NORMAL_PRIORITY),
                                                     f));
                                           }
                                       }
                                       else
                                           if (data.
                                                 fieldsOfSerializableOrNativeClassed.
                                                 contains(
                                                   f)) {
                                               
                                           }
                                           else
                                               if (!data.
                                                      writtenFields.
                                                     contains(
                                                       f)) {
                                                   bugReporter.
                                                     reportBug(
                                                       new edu.umd.cs.findbugs.BugInstance(
                                                         this,
                                                         f.
                                                           isPublic(
                                                             ) ||
                                                           f.
                                                           isProtected(
                                                             )
                                                           ? "UUF_UNUSED_PUBLIC_OR_PROTECTED_FIELD"
                                                           : "UUF_UNUSED_FIELD",
                                                         NORMAL_PRIORITY).
                                                         addClass(
                                                           className).
                                                         addField(
                                                           f).
                                                         lowerPriorityIfDeprecated(
                                                           ));
                                               }
                                               else
                                                   if (f.
                                                         getName(
                                                           ).
                                                         toLowerCase(
                                                           ).
                                                         indexOf(
                                                           "guardian") <
                                                         0) {
                                                       int priority =
                                                         NORMAL_PRIORITY;
                                                       if (f.
                                                             isStatic(
                                                               )) {
                                                           priority++;
                                                       }
                                                       if (f.
                                                             isFinal(
                                                               )) {
                                                           priority++;
                                                       }
                                                       bugReporter.
                                                         reportBug(
                                                           addClassFieldAndAccess(
                                                             new edu.umd.cs.findbugs.BugInstance(
                                                               this,
                                                               f.
                                                                 isPublic(
                                                                   ) ||
                                                                 f.
                                                                 isProtected(
                                                                   )
                                                                 ? "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD"
                                                                 : "URF_UNREAD_FIELD",
                                                               priority),
                                                             f));
                                                   }
                                   }
                           }
                           bugAccumulator.
                             reportAccumulatedBugs(
                               ); }
    private edu.umd.cs.findbugs.BugInstance addClassFieldAndAccess(edu.umd.cs.findbugs.BugInstance instance,
                                                                   edu.umd.cs.findbugs.ba.XField f) {
        if (data.
              writtenNonNullFields.
              contains(
                f) &&
              data.
                readFields.
              contains(
                f)) {
            throw new java.lang.IllegalArgumentException(
              ("No information for fields that are both read and written non" +
               "null"));
        }
        instance.
          addClass(
            f.
              getClassName(
                )).
          addField(
            f);
        if (data.
              fieldAccess.
              containsKey(
                f)) {
            instance.
              add(
                data.
                  fieldAccess.
                  get(
                    f));
        }
        return instance;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "z/FXfHv+/wGTjhVOy0kAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18CbDs2Flev/dmn/G8WczMMHjGM54Zm3HbT+pNamVY3K1u" +
       "dbda6tbSUneL5Vlbq6XW1tq7zRjbJAyEwqZiG5sAk1TFTsBlMEVwkYQiZZIi" +
       "2AFTBUURIGFNKjGLq3ClsFOQ4Byp+y7vvnvvew/P41bptK7Oou//zv//5z/S" +
       "OfrkF0t3hkGp7Hv2xrC96IqeRVcsu3El2vh6eIWkGowchLqG23IYTsC1q+qb" +
       "fubyl//mh5YPXSzdJZUelV3Xi+TI9NyQ00PPTnSNKl0+utq1dSeMSg9RlpzI" +
       "UByZNkSZYfQSVbr/WNWo9Dx1AAECECAAASogQK2jUqDS63Q3dvC8huxG4br0" +
       "7tIFqnSXr+bwotKz1zbiy4Hs7JthCglAC/fk/4tAqKJyFpSeOZR9J/N1An+4" +
       "DH3oI9/50M9eKl2WSpdNl8/hqABEBG4ilR5wdEfRg7ClabomlR52dV3j9cCU" +
       "bXNb4JZKj4Sm4cpRHOiHJOUXY18PinseMfeAmssWxGrkBYfiLUzd1g7+u3Nh" +
       "ywaQ9bEjWXcSEvl1IOB9JgAWLGRVP6hyx8p0taj0xpM1DmV8fggKgKp3O3q0" +
       "9A5vdYcrgwulR3Z9Z8uuAfFRYLoGKHqnF4O7RKUnz2w059qX1ZVs6Fej0hMn" +
       "yzG7LFDq3oKIvEpU+rqTxYqWQC89eaKXjvXPF0ff9P53uX33YoFZ01U7x38P" +
       "qPT0iUqcvtAD3VX1XcUH3kr9sPzYL37fxVIJFP66E4V3ZX7+u770jrc9/ZnP" +
       "7sp8wyllxoqlq9FV9WPKg7/xBvxF7FIO4x7fC82886+RvFB/Zp/zUuYDy3vs" +
       "sMU888pB5me4/zR/zyf0P79Yum9Qukv17NgBevSw6jm+aetBT3f1QI50bVC6" +
       "V3c1vMgflO4G55Tp6rur48Ui1KNB6Q67uHSXV/wPKFqAJnKK7gbnprvwDs59" +
       "OVoW55lfKpXuBkfpAXBwpd1f8RuVvhNaeo4Oyarsmq4HMYGXyx9CuhspgNsl" +
       "tADKpMRGCIWBChWqo2sxFDsapIZHmZoegWqQ4Aa6rBGFhl/JC/u3/Q5ZLuND" +
       "6YULgP43nDR+G9hN37M1Pbiqfihud7/001d/9eKhMezZiUpvATe8Am54RQ2v" +
       "HNzwyu6GV47fsHThQnGf1+c33nUx6KAVMHXgBB94kf8O8p3f96ZLQLf89A7A" +
       "bl4UOtsX40fOYVC4QBVoaOkzH03fK343fLF08VqnmoMFl+7LqzO5Kzx0ec+f" +
       "NKbT2r38yhe+/Kkfftk7MqtrvPTe2q+vmVvrm07SGngqYCzQj5p/6zPyp6/+" +
       "4svPXyzdAVwAcHuRDNQUeJSnT97jGqt96cAD5rLcCQReeIEj23nWgdu6L1oG" +
       "Xnp0pejvB4vzhwHH9+dq/Dg4fnSv18Vvnvuon6ev3+lH3mknpCg87Dfz/o//" +
       "zq//aa2g+8AZXz42vPF69NIxB5A3drkw9YePdGAS6Doo9/sfZT744S++8m2F" +
       "AoASz512w+fzFAeGD7oQ0PyPPrv+3T/8g4/91sUjpYnACBgrtqlmh0Lm10v3" +
       "nSMkuNubj/AAB2ID1c215nnBdTzNXJiyYuu5lv7fyy9UPv0X739opwc2uHKg" +
       "Rm+7cQNH17++XXrPr37nV54umrmg5gPYEWdHxXZe8dGjlltBIG9yHNl7f/Op" +
       "H/kV+ceBfwU+LTS3euGmLuwNJwf1dWCQO80w27HB6b4XgBGr6FyoKP3WIr2S" +
       "E1O0USryannyxvC4kVxrh8cCkqvqD/3WX75O/Mt//6VCqmsjmuM6Qcv+Szs1" +
       "zJNnMtD84yc9Ql8Ol6Bc/TOjb3/I/szfgBYl0KIKhvFwHAB/lF2jQfvSd979" +
       "e7/0Hx97529cKl0kSvfZHvA7cmGMpXuBFejhEriyzP/Wd+yUIL0HJA8Vopau" +
       "E36nPE8U/z0BAL54th8qfNuRKT/x12Nbed+f/J/rSCg80Cnj8In6EvTJH3sS" +
       "/5Y/L+ofuYK89tPZ9T4aBG9HdaufcP7q4pvu+uWLpbul0kPqPjIUZTvODUwC" +
       "0VB4EC6C6PGa/Gsjm90w/tKhq3vDSTd07LYnndDR2ADO89L5+X0n/M7X5yx/" +
       "Gzj4vUnyJ/3OhVJx0iqqPFukz+fJW4o+uRSV7vYDMwHDPjD4sAhCI4DDdGV7" +
       "b/hfBX8XwPG3+ZG3nl/YjdqP4PvQ4ZnD2MEH49idnW5b6J3f20xgOsCVJfuo" +
       "CXr5kT9c/dgXfmoXEZ3s2hOF9e/70D/+6pX3f+jisTj0uetCweN1drFowd3r" +
       "8qSfG8uz592lqEH8r0+9/As/8fIrO1SPXBtVdcGk4ad++//92pWP/tHnThnM" +
       "71Y8z9Zld+f387SeJ+0dq+iZ1vNN17rbp8Bxdd+3V8/oW+H0vt25nj6YJy3l" +
       "cCTnktFHofjoBDDxFoF9AzjkPTD5DGDffgNgD5rh4aRG2YWPJ2F9xy3CegEc" +
       "6h6WegYs9QawngjllNftBS7b9sA9Fo2cBlC7eYCP5FffCg59D1A/A6B1OsCL" +
       "+Wk3T3oHUO9Xjkah/BJ8At3qFtHB4DD26Iwz0K1vGt2DAF1LVWMntuWDuScY" +
       "Tt90xnB6rOgJMYJb1IIXwWHuxTDPEGN7Ay14wy78GQcgzsxDcDB9P18T3nXz" +
       "IPOj1AbHB/cgP3gdyAuHwV0+klwZgPm3oQeP/Mk//9hX3vtK82Ier9yZ5CMO" +
       "8EwPHZUbxflzg+/95Iefuv9Df/QDRTwHWr4zb/S95/QbcU2/Xe6Mr47Gk6v4" +
       "eMQPOl2uqDLcO878ZxyVLpludIKA9908Afft5C2VPrwn4MNn9NL7Twd94Vo9" +
       "A8OLHrgHfuRAz95+mp4VT3Xyyeputt/RQzUw/etV7gM3L0wR/Lvg+MhemI+c" +
       "IcxHbkaYB8ITLvGDJ5B99BZpVsDxI3tkP3IGsldvBtldge4AUzgN0z+7RQN9" +
       "DLQ92hXd/Z6C6eM3MFAQeMVudFXOA9Srlfzi959A9S9vHlX+TKL0RoCG2aNi" +
       "zkD1yXOY6h4qpB/oienF4dhXPU0/DdtP3SK2t4B77B+a7H5PwfavbwbbYwfY" +
       "mBti/LlbD1YubPYYN2dg/Hc3ClZCXXcHbuKt9N0z0dNc7S/8HYC9aw/sXWcA" +
       "+6WbAUZ7rgl8Rdfdj7cngf2HW4+iLry8B/byGcA+ewNgl33d1UzX6OkRcfhQ" +
       "F7i/p05zf4p8ZVaUOgH8c7cIvAYAf/ce+HefAfw3bgD8Dk2O5AO05Zt8+NUB" +
       "dU5g/81bxA6yLrxnj/09Z2D/vRtgvzuUc/U81Wz+6y0OHTiYh923K3rpvjPw" +
       "/PE5pk0cgHpYA9PcfE5mg7luS/Hi6IDdYw8GAhBHZFcYOcqHzBPI/+QWkQ8B" +
       "4gf2yB84A/mf3Qzy16dmtASYXc/dOMAnFWNznvc/TyD88xsiLFoE8ROYh1av" +
       "oFeKiPhLp2O4lJ9+YwEkTw4HusctW33+YG4r6kFoeu7zlo0esHks3tq9uzgB" +
       "sn/TIEGQ9+BRY5TnGi/9wP/4oV/7wHN/CCI88iDCy0v/Q0AZ/6Lyv9+R//PX" +
       "tybPk7k8vBcHqk7JYUQXT9J07VCkE6HdHbb3NYgUPfmGfj0ctA7+aFHFZ4aa" +
       "SdO4J1Wn0jhJzXmliXvmiGHpLj8wG1LX7RlBd0W1yxTf2cIYya8iN0accl2W" +
       "p5m59TpSqzkyezCNb005s8v0NmuQ9oadUZTdHJB0Ow6DTqtrGFSVbfL1UZzG" +
       "zXaZTyl0Zs8YrQsxYjfaSKNkUdnOomDtz1CoVkGCysxOEWyCeKrT3LhtL84U" +
       "TqrMbbiHVEbhEpmjGi1mlXBc86l1wiZustUh2G0LdoUdrapBxwwIQVwi6HRN" +
       "NqrtlRlI1pKmxckaI3A5W/rYyJ16jDxItxO2t+luR4jamMdraa0Mq5JvLw2v" +
       "OnB5isGdYdUOvawap+xcFuAWWeuPeSXFHAresJwvwFjgEBJkDTF0uWn2+J7c" +
       "jJaNnpO1JZsb2K4jK/1uI+iIsQQiWtJGorinkQwhD1Aiipdu3G6rTse02gOK" +
       "6GzFMkavohSGVSN2hnPJpM2yHnp1xLewNmxYHDJDI9hxuzFZ0XnT4H0sEx0f" +
       "r3LKlh1bqryElQ08A6q/ML1K6K/Gq3rSafr8muIEae5wHM0RVChNaR6RmWaa" +
       "CrK/CsZIk4bNesjjMehrIkObbsYswupoW1FZzuvzw5GD4TQ6tDptj+y2WyTn" +
       "CBFXrUYj31nWjS0rwZpVroyEGejEEKvppMfWFTyMOpguWukck82RA03SNEC6" +
       "U34bbrwtOifrRmWzrDGY2NGDYZc2kE1jJPKUISf1cUvjvFQymmuvr8W2uo4c" +
       "n3Ckbi/lVv1e5IFJKcFHG7FVVdqyvLZYodxty8tB4JlWV0DThUjXZUMmBRJ3" +
       "jC1ta0OC6lWJ/jSgV/xkTfbaqgubOOyP6kLbIATJaXtRxkdtSk3HWGMcL7Ba" +
       "Mq65UyJU5cHKsFJ3CG6TbGcsMmsYQhAgOF4ZztOOoBDLqT6oSppkjeA5aaiD" +
       "basuEo6gQ+Ww39iUVaipsB6NYLSjoQKxXm/8vmeM9Jqb1dSQkUO8KpuVSXfR" +
       "2Zpl3h2UN4yluZJax/HtOGDb3e0ccmkSm2Oa6ooYRtQ8hI+dCh/4Pjoy2vXK" +
       "uqr0YJdbz+DWSDZj2g8SkuitV+PasjxCnDZWB/3F9CparcN68kYRx0FTQGck" +
       "lDbZDjsgl0NjXLNEC6Y30DT1lEbcbJhZm2+lmG/0VK27gOrUZqzUmyNnGc5F" +
       "cdKF0/q2VuWVIdqctOtrtlUt9+sDfDkZWskqa1cUa8aInm6HDBmRWWXW38DZ" +
       "pB3NzF66UYaOvaSd0bzaCUxK59gsdqwVa7UWtSxtjsNUieS57gcyPxMZzZ7N" +
       "2mlztdjMBTzVO2Zat0i416GnRupb62wxoDN42qFrG5zk+gZKo+0lrM5YVoyW" +
       "68E4UkRLhhoCRaFRprIzz7ZEGdeXJqyKBLNedMJUawwaDaFf3UixW+MQRC33" +
       "+KmIa0NzjW8CZLzEqzG8pLvoWnQXzdF60urV7PFc7jNDuVULYVj0Kdzfdpy6" +
       "2AtG3WlgabDklHFrNePm421gqXNpYrvbLCuXjUoPaSKksDazWb3lICnerSvA" +
       "6NsIgQAxap2mjTBKzIw1K0OaynzhT+cDM2tQteVGqAhzhWAFeJD6I8HeVIT+" +
       "alWO1uNRuq0TVEeczHt8uyulC2XIDODhlu5Vq4LPzbt9axJZQ9ISl6g1tqTQ" +
       "QRidQBBzu8iw9npJMHOkWV20m2lWHUJtbStVnPl2OV9bM2+6GgzQ5YxBAiXS" +
       "F0m95pa1tAFV+l4TyrDKuAo7+nZFGFQEoyM3WsfRxiHUNaTVAg1FoRClygKC" +
       "b6ZTuxenHY0eh8SMXbKdLSZgCyhcJzMLStloMlFTaTxuxHgV12bd9hBaoR47" +
       "kHuV7rZSTseKT498Vsa8am+IL6pr3PGBV2qVk5rF62o5XKJxY93tx1ZKylhv" +
       "01Sdeh+GlOW0UXZ0hWmgzEbgBIxa6ZJdz+aq6eqNiaKIibR0t6sgsXP6IUGv" +
       "43badqqjXlWoNqRBuTHnEMUxiGYswdFUmi+mghrDqeputla1Y28RwkdUiybT" +
       "Xn1mu/PZEK9nzVWmMywB03ZFjPTyqCZYCoZCLToWZ122EelkNF9XhLWxJM2F" +
       "YzDb0GsTire1OsIYhcnaulwbslCTtdl+Cx8OV6w+WTdHpMXN/C4RI/JaXkBx" +
       "n6xqGpbQw65dGSEuO5kMZ3h7M5Za63FrHI6MxYyZ6rpKkRyI4GSeNGF/uMSh" +
       "htGuZl4/nWlVIcysyC5DmgOVa5JWxiB3Glvk1KLrkOh6K9oLA1Q1+2GvTjWg" +
       "sjqkNAiyFZk2e4Sxjmrrtu4y5aCiMbNF4kANqbWNK5ojtGyh3zQWsTWOuZqb" +
       "hEmg1+d9GV3YvA/Pe71ygjpuTZogNLVGy6o0ETpky6mwVW208RHCW2xbA56a" +
       "WIi+THBkSDXrWHuUbcM1Pp/AZZnhmmC8Gbmx2qxzFaoOJYJBCmgnSFLBtZAZ" +
       "y7B9lNt0VXJBxaQ4iSmfXmXT5hgJ5sNJL7Sm85nRdysswsBLN/U4Z9i3WlsV" +
       "JmWDX2szOazOiE5oRn0Nm2qTTrAcUexoqob8aCBAQQxvsFCuJRV4YFtmNGEl" +
       "XtEFqOl7cKLMnGm13JY1ehs0t516Da/XVbLZkdskvUgVaJC0m6bR3JgZ1qVG" +
       "Cl9n5S6ehtxA9uF1r95rD6xEZlyxYiWLWGwOusSky/YIpN6oQ+XNpirXm2nQ" +
       "I+VQZldhsph1RZoasHXHaeAoN+1FzfY6qNUaaZZCSVUhJioYTvs4V0u5bQq5" +
       "EJai46yKYXV/lYWiT28mErzmwi7CtdZZZb41oSWBa4uGX69jsSzb884UwRyM" +
       "czp6bUONK2NiE0WWNBqVJwHtoGTdjDfDZaPW4XushA1G6cZflnFp3BVocusP" +
       "5WhdWZLTMkHGq7Vstzaga8mOwU7gZDLsEvholNaDibfplGW01qg15y2sSU8a" +
       "/brODALFx6llbTlR5+jQtnuEpAiyIwuN5dKHebWxMmJs3q1O4HY/EiOBnKbj" +
       "jBoG67S6bbU0SeEXiEdr5rpR66FoPcy2llceuUlrClHeuB+vKhNcp9GNE5EE" +
       "gaG0sqp7OAT6l5XWAtZIWbs8tmgwwAgTAoijDxS14s1XAzuDxjg1MAeDnsFa" +
       "0doPRlJfsBOMxT1tafK85QyzNYvN5yQS2bze4WeUAJvAuy51Uw46XENajnhs" +
       "FGaaiktDuMp4VbNmSRm6JIeJUdXhaoLG3bKwXKZeJ2PXW2Xe5wdVs5JA0bRt" +
       "IZBUVgUvC9viIFvOjK6YNMOgIvX7DXQgdfRKEmAoCMG36brV9EWe4aurLpoM" +
       "sYU/4bs061pKVUpCRKwu0LEVIToUo0TQR5BGLeGo8mxMolDqWYS0RrN4uR0k" +
       "y8VoaklYHV5k26BN8AQ6myg13p8YQTOh+ubKxXyW1dedoNsi2WpzqWzQTRxs" +
       "TBeppUtC0/tZi1TImihM0dGwskDjppDQJNLsMUykdhKNJPsoMKsI5cvTSWUq" +
       "r1LWrRsrui0lmGNE1YkRq+MIXaEknZZ74RpMJ5SuP1FG6bgVZmWlRjrLoeR1" +
       "q9jANOuBSjv1ct/hSF+ZzyeGvG2vDH+8bQzdeqgl7cDCyhCxNevxQGr1YLis" +
       "VyubxRIL1eU4aiow4yLd/tpoNqQRt2W3CMTJQ4NDGixXl70B7rbYUSzEy3qg" +
       "0y0aa6gdTNuskXDk0TMbq5ZpzS4vYpKTerxShVpgKAuTZW9NBp151zIQmwvU" +
       "bO4g9tymu0mqa9tB3E8XLVHxRzO+DWI1iVtOp9VZXZk63pwgkC2lNvHZoIk3" +
       "3X5s9zTgi1C/lUK9uZeilFynBqG8ZivzsoEPo7nZDGU0krbZxHQyptyzW8YQ" +
       "Gwm9NmOUw9l4utFIsQvi6U5bokRpzW6CScummjOyXskItM4iLcnVHaRNr9rT" +
       "RjWerWXPpqGMXq+QtDrpGFpbm0Jov4Opg+E49MasaflcNCTHaay6g6m8CWpc" +
       "WxTWzEqXYVMM6Z4QzUZDGpOmkpQ4UVOuwdVlv9eYkhBOD7yBySxQfO7XukqH" +
       "q1PURCCQJk/OZh2pPMXNcbBVTVqYwyMjM3vydEsZrZrdZVPearPbvrwazyeB" +
       "O5o1Nt6sXw4aXjcKyaa1GPNNiJyAIBbeuPOgrFM9Y5rU0C5U61tpBVmjC8WR" +
       "Vrg1joiJp3nKmqngm5VIsfpQV9xaTOkyNooXeoIqwjgggwG3HEGOhfZFA8IW" +
       "rV4foZPVRvBx0a1s0SrqBtusWlZaJDo2QnzYEslakFThDj1zh5bei6cKPKXE" +
       "cMpOYtTiNzFpO9u1Eq6ziMAhgcJdGKlNwmAzS2djqopsxLa9YGEfylKzMZOS" +
       "Rourb6YYMdsulmMyUvAF3zMtY1oeMhTd6va55SLgZlSSipMEIyboxCXWUYUV" +
       "xjVcCWlaKSsiz/dDod/n6B7btHoLsT/B4Gl/E054yAhZaztP8Dm1RB1p0AoG" +
       "mYzP+HSFZhzNGAvgmdo2kgbldqJXNuvtqhlytSbdaaoug0UZ5PlllJellZyE" +
       "Q3SRmB1j3ps4NsfFo+1QjdtwalXAhH6dSD6KaFpjqLTbRpOeLZrrpA3XoypG" +
       "c+rETPtEJeYGvQSquaOmqziVoOKkhEU5RiYmcDKHMIxmQOzsg3viHaxcF+dM" +
       "ZeY6jXrAIRV3vo2yqSiTGRsxXnc9G6Zk");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
