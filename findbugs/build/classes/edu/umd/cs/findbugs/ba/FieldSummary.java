package edu.umd.cs.findbugs.ba;
public class FieldSummary {
    private final java.util.Set<edu.umd.cs.findbugs.ba.XField> writtenOutsideOfConstructor =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    private final java.util.Map<edu.umd.cs.findbugs.ba.XField,edu.umd.cs.findbugs.OpcodeStack.Item>
      summary =
      new java.util.HashMap<edu.umd.cs.findbugs.ba.XField,edu.umd.cs.findbugs.OpcodeStack.Item>(
      );
    private final java.util.Map<edu.umd.cs.findbugs.ba.XMethod,java.util.Set<edu.umd.cs.findbugs.ba.XField>>
      fieldsWritten =
      new java.util.HashMap<edu.umd.cs.findbugs.ba.XMethod,java.util.Set<edu.umd.cs.findbugs.ba.XField>>(
      );
    private final java.util.Map<edu.umd.cs.findbugs.ba.XMethod,edu.umd.cs.findbugs.ba.XMethod>
      nonVoidSuperConstructorsCalled =
      new java.util.HashMap<edu.umd.cs.findbugs.ba.XMethod,edu.umd.cs.findbugs.ba.XMethod>(
      );
    private final java.util.Map<edu.umd.cs.findbugs.ba.XMethod,java.util.Set<edu.umd.cs.findbugs.ProgramPoint>>
      selfMethodsCalledFromConstructor =
      new java.util.HashMap<edu.umd.cs.findbugs.ba.XMethod,java.util.Set<edu.umd.cs.findbugs.ProgramPoint>>(
      );
    private final java.util.Set<edu.umd.cs.findbugs.classfile.ClassDescriptor>
      callsOverriddenMethodsFromConstructor =
      new java.util.HashSet<edu.umd.cs.findbugs.classfile.ClassDescriptor>(
      );
    private boolean complete = false;
    public edu.umd.cs.findbugs.OpcodeStack.Item getSummary(edu.umd.cs.findbugs.ba.XField field) {
        if (field ==
              null) {
            return new edu.umd.cs.findbugs.OpcodeStack.Item(
              );
        }
        edu.umd.cs.findbugs.OpcodeStack.Item result =
          summary.
          get(
            field);
        if (result ==
              null ||
              field.
              isVolatile(
                )) {
            java.lang.String signature =
              field.
              getSignature(
                );
            return new edu.umd.cs.findbugs.OpcodeStack.Item(
              signature);
        }
        return result;
    }
    public boolean callsOverriddenMethodsFromConstructor(edu.umd.cs.findbugs.classfile.ClassDescriptor c) {
        return callsOverriddenMethodsFromConstructor.
          contains(
            c);
    }
    public boolean callsOverriddenMethodsFromSuperConstructor(edu.umd.cs.findbugs.classfile.ClassDescriptor c) {
        try {
            while (true) {
                edu.umd.cs.findbugs.ba.XClass cx =
                  edu.umd.cs.findbugs.classfile.Global.
                  getAnalysisCache(
                    ).
                  getClassAnalysis(
                    edu.umd.cs.findbugs.ba.XClass.class,
                    c);
                c =
                  cx.
                    getSuperclassDescriptor(
                      );
                if (c ==
                      null) {
                    return false;
                }
                if (callsOverriddenMethodsFromConstructor(
                      c)) {
                    return true;
                }
            }
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            return false;
        }
    }
    public void setCalledFromSuperConstructor(edu.umd.cs.findbugs.ProgramPoint from,
                                              edu.umd.cs.findbugs.ba.XMethod calledFromConstructor) {
        java.util.Set<edu.umd.cs.findbugs.ProgramPoint> set =
          selfMethodsCalledFromConstructor.
          get(
            calledFromConstructor);
        if (set ==
              null) {
            set =
              new java.util.HashSet<edu.umd.cs.findbugs.ProgramPoint>(
                );
            selfMethodsCalledFromConstructor.
              put(
                calledFromConstructor,
                set);
        }
        set.
          add(
            from);
        callsOverriddenMethodsFromConstructor.
          add(
            from.
              method.
              getClassDescriptor(
                ));
    }
    public java.util.Set<edu.umd.cs.findbugs.ProgramPoint> getCalledFromSuperConstructor(edu.umd.cs.findbugs.classfile.ClassDescriptor superClass,
                                                                                         edu.umd.cs.findbugs.ba.XMethod calledFromConstructor) {
        if (!callsOverriddenMethodsFromConstructor.
              contains(
                superClass)) {
            return java.util.Collections.
              emptySet(
                );
        }
        for (java.util.Map.Entry<edu.umd.cs.findbugs.ba.XMethod,java.util.Set<edu.umd.cs.findbugs.ProgramPoint>> e
              :
              selfMethodsCalledFromConstructor.
               entrySet(
                 )) {
            edu.umd.cs.findbugs.ba.XMethod m =
              e.
              getKey(
                );
            if (m.
                  getName(
                    ).
                  equals(
                    calledFromConstructor.
                      getName(
                        )) &&
                  m.
                  getClassDescriptor(
                    ).
                  equals(
                    calledFromConstructor.
                      getClassDescriptor(
                        ))) {
                java.lang.String sig1 =
                  m.
                  getSignature(
                    );
                java.lang.String sig2 =
                  calledFromConstructor.
                  getSignature(
                    );
                sig1 =
                  sig1.
                    substring(
                      0,
                      sig1.
                        indexOf(
                          ')'));
                sig2 =
                  sig2.
                    substring(
                      0,
                      sig2.
                        indexOf(
                          ')'));
                if (sig1.
                      equals(
                        sig2)) {
                    return e.
                      getValue(
                        );
                }
            }
        }
        return java.util.Collections.
          emptySet(
            );
    }
    public void setFieldsWritten(edu.umd.cs.findbugs.ba.XMethod method,
                                 java.util.Collection<edu.umd.cs.findbugs.ba.XField> fields) {
        if (fields.
              isEmpty(
                )) {
            return;
        }
        if (fields.
              size(
                ) ==
              1) {
            fieldsWritten.
              put(
                method,
                java.util.Collections.
                  singleton(
                    edu.umd.cs.findbugs.util.Util.
                      first(
                        fields)));
            return;
        }
        fieldsWritten.
          put(
            method,
            edu.umd.cs.findbugs.util.Util.
              makeSmallHashSet(
                fields));
    }
    public java.util.Set<edu.umd.cs.findbugs.ba.XField> getFieldsWritten(@javax.annotation.Nullable
                                                                         edu.umd.cs.findbugs.ba.XMethod method) {
        java.util.Set<edu.umd.cs.findbugs.ba.XField> result =
          fieldsWritten.
          get(
            method);
        if (result ==
              null) {
            return java.util.Collections.
              <edu.umd.cs.findbugs.ba.XField>
            emptySet(
              );
        }
        return result;
    }
    public boolean isWrittenOutsideOfConstructor(edu.umd.cs.findbugs.ba.XField field) {
        if (field.
              isFinal(
                )) {
            return false;
        }
        if (writtenOutsideOfConstructor.
              contains(
                field)) {
            return true;
        }
        if (!edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              unreadFieldsAvailable(
                )) {
            return true;
        }
        edu.umd.cs.findbugs.detect.UnreadFieldsData unreadFields =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          getUnreadFieldsData(
            );
        if (unreadFields.
              isReflexive(
                field)) {
            return true;
        }
        return false;
    }
    public boolean addWrittenOutsideOfConstructor(edu.umd.cs.findbugs.ba.XField field) {
        return writtenOutsideOfConstructor.
          add(
            field);
    }
    public void mergeSummary(edu.umd.cs.findbugs.ba.XField fieldOperand,
                             edu.umd.cs.findbugs.OpcodeStack.Item mergeValue) {
        if (edu.umd.cs.findbugs.SystemProperties.
              ASSERTIONS_ENABLED) {
            java.lang.String mSignature =
              mergeValue.
              getSignature(
                );
            org.apache.bcel.generic.Type mergeType =
              org.apache.bcel.generic.Type.
              getType(
                mSignature);
            org.apache.bcel.generic.Type fieldType =
              org.apache.bcel.generic.Type.
              getType(
                fieldOperand.
                  getSignature(
                    ));
            edu.umd.cs.findbugs.ba.IncompatibleTypes check =
              edu.umd.cs.findbugs.ba.IncompatibleTypes.
              getPriorityForAssumingCompatible(
                mergeType,
                fieldType,
                false);
            if (check.
                  getPriority(
                    ) <=
                  edu.umd.cs.findbugs.Priorities.
                    NORMAL_PRIORITY) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    fieldOperand +
                    " not compatible with " +
                    mergeValue,
                    new java.lang.IllegalArgumentException(
                      check.
                        toString(
                          )));
            }
        }
        edu.umd.cs.findbugs.OpcodeStack.Item oldSummary =
          summary.
          get(
            fieldOperand);
        if (oldSummary !=
              null) {
            edu.umd.cs.findbugs.OpcodeStack.Item newValue =
              edu.umd.cs.findbugs.OpcodeStack.Item.
              merge(
                mergeValue,
                oldSummary);
            newValue.
              clearNewlyAllocated(
                );
            summary.
              put(
                fieldOperand,
                newValue);
        }
        else {
            if (mergeValue.
                  isNewlyAllocated(
                    )) {
                mergeValue =
                  new edu.umd.cs.findbugs.OpcodeStack.Item(
                    mergeValue);
                mergeValue.
                  clearNewlyAllocated(
                    );
            }
            summary.
              put(
                fieldOperand,
                mergeValue);
        }
    }
    public void setComplete(boolean complete) {
        int fields =
          0;
        int removed =
          0;
        int retained =
          0;
        this.
          complete =
          complete;
        if (isComplete(
              )) {
            for (java.util.Iterator<java.util.Map.Entry<edu.umd.cs.findbugs.ba.XField,edu.umd.cs.findbugs.OpcodeStack.Item>> i =
                   summary.
                   entrySet(
                     ).
                   iterator(
                     );
                 i.
                   hasNext(
                     );
                 ) {
                java.util.Map.Entry<edu.umd.cs.findbugs.ba.XField,edu.umd.cs.findbugs.OpcodeStack.Item> entry =
                  i.
                  next(
                    );
                edu.umd.cs.findbugs.ba.XField f =
                  entry.
                  getKey(
                    );
                if (edu.umd.cs.findbugs.ba.AnalysisContext.
                      currentXFactory(
                        ).
                      isReflectiveClass(
                        f.
                          getClassDescriptor(
                            ))) {
                    i.
                      remove(
                        );
                    removed++;
                    continue;
                }
                edu.umd.cs.findbugs.OpcodeStack.Item defaultItem =
                  new edu.umd.cs.findbugs.OpcodeStack.Item(
                  f.
                    getSignature(
                      ));
                fields++;
                edu.umd.cs.findbugs.OpcodeStack.Item value =
                  entry.
                  getValue(
                    );
                value.
                  makeCrossMethod(
                    );
                if (defaultItem.
                      equals(
                        value)) {
                    i.
                      remove(
                        );
                    removed++;
                }
                else {
                    retained++;
                }
            }
        }
    }
    public boolean isComplete() { return complete;
    }
    public void sawSuperCall(edu.umd.cs.findbugs.ba.XMethod from,
                             edu.umd.cs.findbugs.ba.XMethod constructorInSuperClass) {
        if (constructorInSuperClass ==
              null ||
              from ==
              null) {
            return;
        }
        if ("()V".
              equals(
                constructorInSuperClass.
                  getSignature(
                    ))) {
            return;
        }
        nonVoidSuperConstructorsCalled.
          put(
            from,
            constructorInSuperClass);
    }
    @javax.annotation.CheckForNull
    public edu.umd.cs.findbugs.ba.XMethod getSuperCall(edu.umd.cs.findbugs.ba.XMethod from) {
        return nonVoidSuperConstructorsCalled.
          get(
            from);
    }
    public FieldSummary() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "r/j2+v8A7xW/S1I0AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "WDbhc019ImzQ+XC4RqciPZ8SzCTFHb+7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
