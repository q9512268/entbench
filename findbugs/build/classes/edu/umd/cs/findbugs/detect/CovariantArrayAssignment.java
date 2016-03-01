package edu.umd.cs.findbugs.detect;
public class CovariantArrayAssignment extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    private final edu.umd.cs.findbugs.BugAccumulator accumulator;
    public CovariantArrayAssignment(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        accumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { super.
                                                              visit(
                                                                obj);
                                                            accumulator.
                                                              reportAccumulatedBugs(
                                                                );
    }
    private static boolean allImplementationsDerivedFromSubclass(@edu.umd.cs.findbugs.internalAnnotations.SlashedClassName
                                                                 java.lang.String superClass,
                                                                 @edu.umd.cs.findbugs.internalAnnotations.SlashedClassName
                                                                 java.lang.String subClass) {
        edu.umd.cs.findbugs.classfile.ClassDescriptor superDescriptor =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          createClassDescriptor(
            superClass);
        edu.umd.cs.findbugs.ba.XClass xClass =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentXFactory(
            ).
          getXClass(
            superDescriptor);
        if (xClass ==
              null ||
              !xClass.
              isInterface(
                ) &&
              !xClass.
              isAbstract(
                )) {
            return false;
        }
        try {
            edu.umd.cs.findbugs.classfile.ClassDescriptor wantedDescriptor =
              edu.umd.cs.findbugs.classfile.DescriptorFactory.
              createClassDescriptor(
                subClass);
            edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
              edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getSubtypes2(
                );
            for (edu.umd.cs.findbugs.classfile.ClassDescriptor subDescriptor
                  :
                  subtypes2.
                   getSubtypes(
                     superDescriptor)) {
                if (subDescriptor.
                      equals(
                        superDescriptor) ||
                      subDescriptor.
                      equals(
                        wantedDescriptor)) {
                    continue;
                }
                edu.umd.cs.findbugs.ba.XClass xSubClass =
                  edu.umd.cs.findbugs.ba.AnalysisContext.
                  currentXFactory(
                    ).
                  getXClass(
                    subDescriptor);
                if (xSubClass ==
                      null ||
                      !xSubClass.
                      isAbstract(
                        ) &&
                      !xSubClass.
                      isInterface(
                        ) &&
                      !subtypes2.
                      isSubtype(
                        subDescriptor,
                        wantedDescriptor)) {
                    return false;
                }
            }
            return true;
        }
        catch (java.lang.ClassNotFoundException e) {
            
        }
        return false;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (isRegisterStore(
                                            ) &&
                                            !isRegisterLoad(
                                               ) ||
                                            seen ==
                                            PUTFIELD ||
                                            seen ==
                                            PUTSTATIC ||
                                            seen ==
                                            ARETURN) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item valueItem =
                                            getStack(
                                              ).
                                            getStackItem(
                                              0);
                                          if (!valueItem.
                                                isNull(
                                                  ) &&
                                                valueItem.
                                                isNewlyAllocated(
                                                  ) &&
                                                valueItem.
                                                getSignature(
                                                  ).
                                                startsWith(
                                                  "[L") &&
                                                !((java.lang.Integer)
                                                    0).
                                                equals(
                                                  valueItem.
                                                    getConstant(
                                                      ))) {
                                              java.lang.String valueClass =
                                                valueItem.
                                                getSignature(
                                                  ).
                                                substring(
                                                  2,
                                                  valueItem.
                                                    getSignature(
                                                      ).
                                                    length(
                                                      ) -
                                                    1);
                                              java.lang.String arraySignature =
                                                null;
                                              int priority =
                                                LOW_PRIORITY;
                                              java.lang.String pattern =
                                                null;
                                              edu.umd.cs.findbugs.classfile.FieldDescriptor field =
                                                null;
                                              if (seen ==
                                                    PUTFIELD ||
                                                    seen ==
                                                    PUTSTATIC) {
                                                  arraySignature =
                                                    getSigConstantOperand(
                                                      );
                                                  pattern =
                                                    "CAA_COVARIANT_ARRAY_FIELD";
                                                  field =
                                                    getFieldDescriptorOperand(
                                                      );
                                                  if (field instanceof edu.umd.cs.findbugs.ba.XField) {
                                                      edu.umd.cs.findbugs.ba.XField xField =
                                                        (edu.umd.cs.findbugs.ba.XField)
                                                          field;
                                                      if (xField.
                                                            isPublic(
                                                              ) ||
                                                            xField.
                                                            isProtected(
                                                              )) {
                                                          edu.umd.cs.findbugs.ba.XClass xClass =
                                                            edu.umd.cs.findbugs.ba.AnalysisContext.
                                                            currentXFactory(
                                                              ).
                                                            getXClass(
                                                              xField.
                                                                getClassDescriptor(
                                                                  ));
                                                          if (xClass !=
                                                                null &&
                                                                xClass.
                                                                isPublic(
                                                                  )) {
                                                              priority =
                                                                NORMAL_PRIORITY;
                                                          }
                                                      }
                                                  }
                                              }
                                              else
                                                  if (seen ==
                                                        ARETURN) {
                                                      if (getXMethod(
                                                            ).
                                                            bridgeFrom(
                                                              ) ==
                                                            null) {
                                                          pattern =
                                                            "CAA_COVARIANT_ARRAY_RETURN";
                                                          arraySignature =
                                                            new edu.umd.cs.findbugs.ba.SignatureParser(
                                                              getMethodSig(
                                                                )).
                                                              getReturnTypeSignature(
                                                                );
                                                          if (!arraySignature.
                                                                equals(
                                                                  "[Ljava/lang/Object;") &&
                                                                (getXMethod(
                                                                   ).
                                                                   isPublic(
                                                                     ) ||
                                                                   getXMethod(
                                                                     ).
                                                                   isProtected(
                                                                     )) &&
                                                                getXClass(
                                                                  ).
                                                                isPublic(
                                                                  )) {
                                                              priority =
                                                                NORMAL_PRIORITY;
                                                          }
                                                      }
                                                  }
                                                  else {
                                                      org.apache.bcel.classfile.LocalVariableTable lvt =
                                                        getMethod(
                                                          ).
                                                        getLocalVariableTable(
                                                          );
                                                      if (lvt !=
                                                            null) {
                                                          org.apache.bcel.classfile.LocalVariable localVariable =
                                                            lvt.
                                                            getLocalVariable(
                                                              getRegisterOperand(
                                                                ),
                                                              getNextPC(
                                                                ));
                                                          if (localVariable !=
                                                                null) {
                                                              pattern =
                                                                "CAA_COVARIANT_ARRAY_LOCAL";
                                                              arraySignature =
                                                                localVariable.
                                                                  getSignature(
                                                                    );
                                                          }
                                                      }
                                                  }
                                              if (arraySignature !=
                                                    null &&
                                                    arraySignature.
                                                    startsWith(
                                                      "[L")) {
                                                  java.lang.String arrayClass =
                                                    arraySignature.
                                                    substring(
                                                      2,
                                                      arraySignature.
                                                        length(
                                                          ) -
                                                        1);
                                                  if (!valueClass.
                                                        equals(
                                                          arrayClass)) {
                                                      if (priority ==
                                                            NORMAL_PRIORITY &&
                                                            allImplementationsDerivedFromSubclass(
                                                              arrayClass,
                                                              valueClass)) {
                                                          priority =
                                                            LOW_PRIORITY;
                                                      }
                                                      edu.umd.cs.findbugs.BugInstance bug =
                                                        new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        pattern,
                                                        priority).
                                                        addClassAndMethod(
                                                          this).
                                                        addFoundAndExpectedType(
                                                          valueItem.
                                                            getSignature(
                                                              ),
                                                          arraySignature).
                                                        addSourceLine(
                                                          this).
                                                        addValueSource(
                                                          valueItem,
                                                          this);
                                                      if (field !=
                                                            null) {
                                                          bug.
                                                            addField(
                                                              field);
                                                      }
                                                      accumulator.
                                                        accumulateBug(
                                                          bug,
                                                          this);
                                                  }
                                              }
                                          }
                                      }
                                      if (seen ==
                                            AASTORE) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item valueItem =
                                            getStack(
                                              ).
                                            getStackItem(
                                              0);
                                          if (!valueItem.
                                                isNull(
                                                  )) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item arrayItem =
                                                getStack(
                                                  ).
                                                getStackItem(
                                                  2);
                                              java.lang.String arraySignature =
                                                arrayItem.
                                                getSignature(
                                                  );
                                              java.lang.String valueSignature =
                                                valueItem.
                                                getSignature(
                                                  );
                                              if (arraySignature.
                                                    startsWith(
                                                      "[L") &&
                                                    valueSignature.
                                                    startsWith(
                                                      "L") &&
                                                    !valueSignature.
                                                    equals(
                                                      "Ljava/lang/Object;")) {
                                                  java.lang.String arrayClass =
                                                    arraySignature.
                                                    substring(
                                                      2,
                                                      arraySignature.
                                                        length(
                                                          ) -
                                                        1);
                                                  java.lang.String valueClass =
                                                    valueSignature.
                                                    substring(
                                                      1,
                                                      valueSignature.
                                                        length(
                                                          ) -
                                                        1);
                                                  try {
                                                      edu.umd.cs.findbugs.classfile.ClassDescriptor valueClassDescriptor =
                                                        edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                        createClassDescriptor(
                                                          valueClass);
                                                      edu.umd.cs.findbugs.classfile.ClassDescriptor arrayClassDescriptor =
                                                        edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                        createClassDescriptor(
                                                          arrayClass);
                                                      if (!edu.umd.cs.findbugs.ba.AnalysisContext.
                                                            currentAnalysisContext(
                                                              ).
                                                            getSubtypes2(
                                                              ).
                                                            isSubtype(
                                                              valueClassDescriptor,
                                                              arrayClassDescriptor)) {
                                                          int priority =
                                                            HIGH_PRIORITY;
                                                          if (edu.umd.cs.findbugs.ba.AnalysisContext.
                                                                currentAnalysisContext(
                                                                  ).
                                                                getSubtypes2(
                                                                  ).
                                                                isSubtype(
                                                                  arrayClassDescriptor,
                                                                  valueClassDescriptor)) {
                                                              priority =
                                                                NORMAL_PRIORITY;
                                                              if (allImplementationsDerivedFromSubclass(
                                                                    valueClass,
                                                                    arrayClass)) {
                                                                  priority =
                                                                    IGNORE_PRIORITY;
                                                              }
                                                          }
                                                          edu.umd.cs.findbugs.BugInstance bug =
                                                            new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "CAA_COVARIANT_ARRAY_ELEMENT_STORE",
                                                            priority).
                                                            addClassAndMethod(
                                                              this).
                                                            addFoundAndExpectedType(
                                                              valueSignature,
                                                              'L' +
                                                              arrayClass +
                                                              ';').
                                                            addSourceLine(
                                                              this).
                                                            addValueSource(
                                                              valueItem,
                                                              this).
                                                            addValueSource(
                                                              arrayItem,
                                                              this);
                                                          accumulator.
                                                            accumulateBug(
                                                              bug,
                                                              this);
                                                      }
                                                  }
                                                  catch (java.lang.ClassNotFoundException e) {
                                                      
                                                  }
                                              }
                                          }
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mUlJtSEce6IwJ2H5M1HF4vJ/AHBd5oToGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5ouv+d03fuq5b+cn+f8N2lsygkQlAAA=");
}
