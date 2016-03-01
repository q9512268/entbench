package edu.umd.cs.findbugs.ba.type;
public class TypeFrameModelingVisitor extends edu.umd.cs.findbugs.ba.AbstractFrameModelingVisitor<org.apache.bcel.generic.Type,edu.umd.cs.findbugs.ba.type.TypeFrame> implements org.apache.bcel.Constants, edu.umd.cs.findbugs.ba.Debug {
    private edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow valueNumberDataflow;
    private boolean instanceOfFollowedByBranch;
    private org.apache.bcel.generic.ReferenceType instanceOfType;
    private edu.umd.cs.findbugs.ba.vna.ValueNumber instanceOfValueNumber;
    private final java.util.Set<org.apache.bcel.generic.ReferenceType> typesComputedFromGenerics =
      edu.umd.cs.findbugs.util.Util.
      newSetFromMap(
        new java.util.IdentityHashMap<org.apache.bcel.generic.ReferenceType,java.lang.Boolean>(
          ));
    protected final edu.umd.cs.findbugs.ba.type.TypeMerger
      typeMerger;
    protected org.apache.bcel.classfile.LocalVariableTypeTable
      localTypeTable;
    protected java.util.BitSet genericLocalVariables;
    public TypeFrameModelingVisitor(org.apache.bcel.generic.ConstantPoolGen cpg,
                                    edu.umd.cs.findbugs.ba.type.TypeMerger typeMerger) {
        super(
          cpg);
        this.
          typeMerger =
          typeMerger;
    }
    public void setValueNumberDataflow(edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow valueNumberDataflow) {
        this.
          valueNumberDataflow =
          valueNumberDataflow;
    }
    public void setLocalTypeTable(org.apache.bcel.classfile.LocalVariableTypeTable localTypeTable) {
        this.
          localTypeTable =
          localTypeTable;
        if (localTypeTable ==
              null) {
            genericLocalVariables =
              null;
        }
        else {
            genericLocalVariables =
              new java.util.BitSet(
                );
            for (org.apache.bcel.classfile.LocalVariable lv
                  :
                  localTypeTable.
                   getLocalVariableTypeTable(
                     )) {
                if (lv.
                      getSignature(
                        ).
                      indexOf(
                        '<') >
                      0) {
                    genericLocalVariables.
                      set(
                        lv.
                          getIndex(
                            ));
                }
            }
        }
    }
    public boolean isInstanceOfFollowedByBranch() {
        return instanceOfFollowedByBranch;
    }
    public org.apache.bcel.generic.Type getInstanceOfType() {
        return instanceOfType;
    }
    public edu.umd.cs.findbugs.ba.vna.ValueNumber getInstanceOfValueNumber() {
        return instanceOfValueNumber;
    }
    public void setFieldStoreTypeDatabase(edu.umd.cs.findbugs.ba.type.FieldStoreTypeDatabase database) {
        
    }
    @java.lang.Override
    public org.apache.bcel.generic.Type getDefaultValue() {
        return edu.umd.cs.findbugs.ba.type.TypeFrame.
          getBottomType(
            );
    }
    boolean sawEffectiveInstanceOf;
    boolean previousWasEffectiveInstanceOf;
    @java.lang.Override
    public void analyzeInstruction(org.apache.bcel.generic.Instruction ins)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        instanceOfFollowedByBranch =
          false;
        sawEffectiveInstanceOf =
          false;
        super.
          analyzeInstruction(
            ins);
        previousWasEffectiveInstanceOf =
          sawEffectiveInstanceOf;
    }
    public void startBasicBlock() { instanceOfType =
                                      null;
                                    instanceOfValueNumber =
                                      null;
    }
    protected void consumeStack(org.apache.bcel.generic.Instruction ins) {
        org.apache.bcel.generic.ConstantPoolGen cpg =
          getCPG(
            );
        edu.umd.cs.findbugs.ba.type.TypeFrame frame =
          getFrame(
            );
        int numWordsConsumed =
          ins.
          consumeStack(
            cpg);
        if (numWordsConsumed ==
              org.apache.bcel.Constants.
                UNPREDICTABLE) {
            throw new edu.umd.cs.findbugs.ba.InvalidBytecodeException(
              "Unpredictable stack consumption for " +
              ins);
        }
        if (numWordsConsumed >
              frame.
              getStackDepth(
                )) {
            throw new edu.umd.cs.findbugs.ba.InvalidBytecodeException(
              "Stack underflow for " +
              ins +
              ", " +
              numWordsConsumed +
              " needed, " +
              frame.
                getStackDepth(
                  ) +
              " avail, frame is " +
              frame);
        }
        try {
            while (numWordsConsumed-- >
                     0) {
                frame.
                  popValue(
                    );
            }
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            throw new edu.umd.cs.findbugs.ba.InvalidBytecodeException(
              "Stack underflow for " +
              ins +
              ": " +
              e.
                getMessage(
                  ));
        }
    }
    protected void pushValue(org.apache.bcel.generic.Type type) {
        if (type.
              getType(
                ) ==
              T_VOID) {
            throw new java.lang.IllegalArgumentException(
              "Can\'t push void");
        }
        edu.umd.cs.findbugs.ba.type.TypeFrame frame =
          getFrame(
            );
        if (type.
              getType(
                ) ==
              T_LONG) {
            frame.
              pushValue(
                org.apache.bcel.generic.Type.
                  LONG);
            frame.
              pushValue(
                edu.umd.cs.findbugs.ba.type.TypeFrame.
                  getLongExtraType(
                    ));
        }
        else
            if (type.
                  getType(
                    ) ==
                  T_DOUBLE) {
                frame.
                  pushValue(
                    org.apache.bcel.generic.Type.
                      DOUBLE);
                frame.
                  pushValue(
                    edu.umd.cs.findbugs.ba.type.TypeFrame.
                      getDoubleExtraType(
                        ));
            }
            else {
                frame.
                  pushValue(
                    type);
            }
    }
    protected void pushReturnType(org.apache.bcel.generic.InvokeInstruction ins) {
        org.apache.bcel.generic.ConstantPoolGen cpg =
          getCPG(
            );
        org.apache.bcel.generic.Type type =
          ins.
          getType(
            cpg);
        if (type.
              getType(
                ) !=
              T_VOID) {
            pushValue(
              type);
        }
    }
    @java.lang.Override
    public void modelNormalInstruction(org.apache.bcel.generic.Instruction ins,
                                       int numWordsConsumed,
                                       int numWordsProduced) {
        if (VERIFY_INTEGRITY) {
            if (numWordsProduced >
                  0) {
                throw new edu.umd.cs.findbugs.ba.InvalidBytecodeException(
                  "missing visitor method for " +
                  ins);
            }
        }
        super.
          modelNormalInstruction(
            ins,
            numWordsConsumed,
            numWordsProduced);
    }
    @java.lang.Override
    public void visitATHROW(org.apache.bcel.generic.ATHROW obj) {
        
    }
    @java.lang.Override
    public void visitACONST_NULL(org.apache.bcel.generic.ACONST_NULL obj) {
        pushValue(
          edu.umd.cs.findbugs.ba.type.TypeFrame.
            getNullType(
              ));
    }
    @java.lang.Override
    public void visitDCONST(org.apache.bcel.generic.DCONST obj) {
        pushValue(
          org.apache.bcel.generic.Type.
            DOUBLE);
    }
    @java.lang.Override
    public void visitFCONST(org.apache.bcel.generic.FCONST obj) {
        pushValue(
          org.apache.bcel.generic.Type.
            FLOAT);
    }
    @java.lang.Override
    public void visitICONST(org.apache.bcel.generic.ICONST obj) {
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitLCONST(org.apache.bcel.generic.LCONST obj) {
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitLDC(org.apache.bcel.generic.LDC obj) {
        pushValue(
          obj.
            getType(
              getCPG(
                )));
    }
    @java.lang.Override
    public void visitLDC2_W(org.apache.bcel.generic.LDC2_W obj) {
        pushValue(
          obj.
            getType(
              getCPG(
                )));
    }
    @java.lang.Override
    public void visitBIPUSH(org.apache.bcel.generic.BIPUSH obj) {
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitSIPUSH(org.apache.bcel.generic.SIPUSH obj) {
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitGETSTATIC(org.apache.bcel.generic.GETSTATIC obj) {
        modelFieldLoad(
          obj);
    }
    @java.lang.Override
    public void visitGETFIELD(org.apache.bcel.generic.GETFIELD obj) {
        modelFieldLoad(
          obj);
    }
    public void modelFieldLoad(org.apache.bcel.generic.FieldInstruction obj) {
        consumeStack(
          obj);
        org.apache.bcel.generic.Type loadType =
          obj.
          getFieldType(
            cpg);
        edu.umd.cs.findbugs.ba.XField xfield =
          edu.umd.cs.findbugs.ba.Hierarchy.
          findXField(
            obj,
            getCPG(
              ));
        if (xfield !=
              null) {
            loadType =
              getType(
                xfield);
        }
        pushValue(
          loadType);
    }
    public static org.apache.bcel.generic.Type getType(edu.umd.cs.findbugs.ba.XField xfield) {
        org.apache.bcel.generic.Type t =
          org.apache.bcel.generic.Type.
          getType(
            xfield.
              getSignature(
                ));
        if (!(t instanceof org.apache.bcel.generic.ReferenceType)) {
            return t;
        }
        org.apache.bcel.generic.ReferenceType loadType =
          (org.apache.bcel.generic.ReferenceType)
            t;
        useDatabase: {
            edu.umd.cs.findbugs.ba.type.FieldStoreTypeDatabase database =
              edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getFieldStoreTypeDatabase(
                );
            if (database !=
                  null) {
                edu.umd.cs.findbugs.ba.type.FieldStoreType property =
                  database.
                  getProperty(
                    xfield.
                      getFieldDescriptor(
                        ));
                if (property !=
                      null) {
                    loadType =
                      property.
                        getLoadType(
                          loadType);
                    break useDatabase;
                }
            }
            edu.umd.cs.findbugs.ba.FieldSummary fieldSummary =
              edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getFieldSummary(
                );
            if (fieldSummary !=
                  null) {
                edu.umd.cs.findbugs.OpcodeStack.Item summary =
                  fieldSummary.
                  getSummary(
                    xfield);
                if (summary !=
                      null) {
                    if (xfield.
                          isFinal(
                            ) &&
                          summary.
                          isNull(
                            )) {
                        return edu.umd.cs.findbugs.ba.type.TypeFrame.
                          getNullType(
                            );
                    }
                    if (!"Ljava/lang/Object;".
                          equals(
                            summary.
                              getSignature(
                                ))) {
                        loadType =
                          (org.apache.bcel.generic.ReferenceType)
                            org.apache.bcel.generic.Type.
                            getType(
                              summary.
                                getSignature(
                                  ));
                    }
                }
            }
        }
        java.lang.String sourceSignature =
          xfield.
          getSourceSignature(
            );
        if (sourceSignature !=
              null &&
              loadType instanceof org.apache.bcel.generic.ObjectType) {
            loadType =
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.
                merge(
                  edu.umd.cs.findbugs.ba.generic.GenericUtilities.
                    getType(
                      sourceSignature),
                  (org.apache.bcel.generic.ObjectType)
                    loadType);
        }
        return loadType;
    }
    @java.lang.Override
    public void visitINVOKESTATIC(org.apache.bcel.generic.INVOKESTATIC obj) {
        java.lang.String methodName =
          obj.
          getMethodName(
            cpg);
        java.lang.String signature =
          obj.
          getSignature(
            cpg);
        java.lang.String className =
          obj.
          getClassName(
            cpg);
        if ("asList".
              equals(
                methodName) &&
              "java.util.Arrays".
              equals(
                className) &&
              "([Ljava/lang/Object;)Ljava/util/List;".
              equals(
                signature)) {
            consumeStack(
              obj);
            org.apache.bcel.generic.Type returnType =
              org.apache.bcel.generic.Type.
              getType(
                "Ljava/util/Arrays$ArrayList;");
            pushValue(
              returnType);
            return;
        }
        visitInvokeInstructionCommon(
          obj);
    }
    @java.lang.Override
    public void visitINVOKESPECIAL(org.apache.bcel.generic.INVOKESPECIAL obj) {
        visitInvokeInstructionCommon(
          obj);
    }
    @java.lang.Override
    public void visitINVOKEINTERFACE(org.apache.bcel.generic.INVOKEINTERFACE obj) {
        visitInvokeInstructionCommon(
          obj);
    }
    @java.lang.Override
    public void visitINVOKEVIRTUAL(org.apache.bcel.generic.INVOKEVIRTUAL obj) {
        visitInvokeInstructionCommon(
          obj);
    }
    private boolean getResultTypeFromGenericType(edu.umd.cs.findbugs.ba.type.TypeFrame frame,
                                                 int index,
                                                 int expectedParameters) {
        try {
            org.apache.bcel.generic.Type mapType =
              frame.
              getStackValue(
                0);
            if (mapType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType) {
                edu.umd.cs.findbugs.ba.generic.GenericObjectType genericMapType =
                  (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                    mapType;
                java.util.List<? extends org.apache.bcel.generic.ReferenceType> parameters =
                  genericMapType.
                  getParameters(
                    );
                if (parameters !=
                      null &&
                      parameters.
                      size(
                        ) ==
                      expectedParameters) {
                    org.apache.bcel.generic.ReferenceType resultType =
                      parameters.
                      get(
                        index);
                    if (resultType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType) {
                        resultType =
                          ((edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                             resultType).
                            produce(
                              );
                    }
                    typesComputedFromGenerics.
                      add(
                        resultType);
                    frame.
                      popValue(
                        );
                    frame.
                      pushValue(
                        resultType);
                    return true;
                }
            }
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "oops",
                e);
        }
        return false;
    }
    private boolean handleGetMapView(edu.umd.cs.findbugs.ba.type.TypeFrame frame,
                                     java.lang.String typeName,
                                     int index,
                                     int expectedNumberOfTypeParameters) {
        try {
            org.apache.bcel.generic.Type mapType =
              frame.
              getStackValue(
                0);
            if (mapType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType) {
                edu.umd.cs.findbugs.ba.generic.GenericObjectType genericMapType =
                  (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                    mapType;
                java.util.List<? extends org.apache.bcel.generic.ReferenceType> parameters =
                  genericMapType.
                  getParameters(
                    );
                if (parameters ==
                      null) {
                    return false;
                }
                if (parameters.
                      size(
                        ) ==
                      expectedNumberOfTypeParameters) {
                    org.apache.bcel.generic.ReferenceType keyType =
                      parameters.
                      get(
                        index);
                    frame.
                      popValue(
                        );
                    typesComputedFromGenerics.
                      add(
                        keyType);
                    edu.umd.cs.findbugs.ba.generic.GenericObjectType keySetType =
                      edu.umd.cs.findbugs.ba.generic.GenericUtilities.
                      getType(
                        typeName,
                        java.util.Collections.
                          singletonList(
                            keyType));
                    typesComputedFromGenerics.
                      add(
                        keySetType);
                    frame.
                      pushValue(
                        keySetType);
                    return true;
                }
            }
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "oops",
                e);
        }
        return false;
    }
    public static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "tfmv.debug");
    public void visitInvokeInstructionCommon(org.apache.bcel.generic.InvokeInstruction obj) {
        edu.umd.cs.findbugs.ba.type.TypeFrame frame =
          getFrame(
            );
        java.lang.String methodName =
          obj.
          getMethodName(
            cpg);
        java.lang.String signature =
          obj.
          getSignature(
            cpg);
        java.lang.String className =
          obj.
          getClassName(
            cpg);
        java.lang.String returnValueSignature =
          new edu.umd.cs.findbugs.ba.SignatureParser(
          signature).
          getReturnTypeSignature(
            );
        if ("V".
              equals(
                returnValueSignature)) {
            consumeStack(
              obj);
            return;
        }
        if ("isInstance".
              equals(
                methodName)) {
            if ("java.lang.Class".
                  equals(
                    className) &&
                  valueNumberDataflow !=
                  null) {
                try {
                    edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
                      valueNumberDataflow.
                      getFactAtLocation(
                        getLocation(
                          ));
                    if (vnaFrame.
                          isValid(
                            )) {
                        edu.umd.cs.findbugs.ba.vna.ValueNumber stackValue =
                          vnaFrame.
                          getStackValue(
                            1);
                        if (stackValue.
                              hasFlag(
                                edu.umd.cs.findbugs.ba.vna.ValueNumber.
                                  CONSTANT_CLASS_OBJECT)) {
                            java.lang.String c =
                              valueNumberDataflow.
                              getClassName(
                                stackValue);
                            if (c !=
                                  null) {
                                if (c.
                                      charAt(
                                        0) !=
                                      '[' &&
                                      !c.
                                      endsWith(
                                        ";")) {
                                    c =
                                      "L" +
                                      c.
                                        replace(
                                          '.',
                                          '/') +
                                      ";";
                                }
                                org.apache.bcel.generic.Type type =
                                  org.apache.bcel.generic.Type.
                                  getType(
                                    c);
                                if (type instanceof org.apache.bcel.generic.ReferenceType) {
                                    instanceOfValueNumber =
                                      vnaFrame.
                                        getTopValue(
                                          );
                                    instanceOfType =
                                      (org.apache.bcel.generic.ReferenceType)
                                        type;
                                    sawEffectiveInstanceOf =
                                      true;
                                }
                            }
                        }
                    }
                }
                catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                    
                }
            }
        }
        org.apache.bcel.generic.Type returnTypeOfMethod =
          obj.
          getType(
            cpg);
        if (!(returnTypeOfMethod instanceof org.apache.bcel.generic.ReferenceType)) {
            consumeStack(
              obj);
            pushReturnType(
              obj);
            return;
        }
        if ("cast".
              equals(
                methodName) &&
              "java.lang.Class".
              equals(
                className)) {
            try {
                org.apache.bcel.generic.Type resultType =
                  frame.
                  popValue(
                    );
                frame.
                  popValue(
                    );
                frame.
                  pushValue(
                    resultType);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "oops",
                    e);
            }
            return;
        }
        mapGetCheck: if ("get".
                           equals(
                             methodName) &&
                           "(Ljava/lang/Object;)Ljava/lang/Object;".
                           equals(
                             signature) &&
                           className.
                           endsWith(
                             "Map") &&
                           edu.umd.cs.findbugs.ba.ch.Subtypes2.
                           instanceOf(
                             className,
                             "java.util.Map") &&
                           frame.
                           getStackDepth(
                             ) >=
                           2) {
            try {
                org.apache.bcel.generic.Type mapType =
                  frame.
                  getStackValue(
                    1);
                if (mapType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType) {
                    edu.umd.cs.findbugs.ba.generic.GenericObjectType genericMapType =
                      (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                        mapType;
                    java.util.List<? extends org.apache.bcel.generic.ReferenceType> parameters =
                      genericMapType.
                      getParameters(
                        );
                    if (parameters ==
                          null ||
                          parameters.
                          size(
                            ) !=
                          2) {
                        break mapGetCheck;
                    }
                    edu.umd.cs.findbugs.classfile.ClassDescriptor c =
                      edu.umd.cs.findbugs.classfile.DescriptorFactory.
                      getClassDescriptor(
                        genericMapType);
                    if (!edu.umd.cs.findbugs.ba.ch.Subtypes2.
                          instanceOf(
                            c,
                            java.util.Map.class)) {
                        break mapGetCheck;
                    }
                    if (!isStraightGenericMap(
                           c)) {
                        break mapGetCheck;
                    }
                    org.apache.bcel.generic.ReferenceType valueType =
                      parameters.
                      get(
                        1);
                    consumeStack(
                      obj);
                    frame.
                      pushValue(
                        valueType);
                    return;
                }
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "oops",
                    e);
            }
        }
        if ("java.util.Map$Entry".
              equals(
                className)) {
            if ("getKey".
                  equals(
                    methodName) &&
                  getResultTypeFromGenericType(
                    frame,
                    0,
                    2) ||
                  "getValue".
                  equals(
                    methodName) &&
                  getResultTypeFromGenericType(
                    frame,
                    1,
                    2)) {
                return;
            }
        }
        if ("entrySet".
              equals(
                methodName) &&
              "()Ljava/util/Set;".
              equals(
                signature) &&
              className.
              startsWith(
                "java.util") &&
              className.
              endsWith(
                "Map")) {
            org.apache.bcel.generic.Type argType;
            try {
                argType =
                  frame.
                    popValue(
                      );
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "oops",
                    e);
                return;
            }
            org.apache.bcel.generic.ObjectType mapType =
              (org.apache.bcel.generic.ObjectType)
                org.apache.bcel.generic.Type.
                getType(
                  "Ljava/util/Map$Entry;");
            if (argType instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType) {
                edu.umd.cs.findbugs.ba.generic.GenericObjectType genericArgType =
                  (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                    argType;
                java.util.List<? extends org.apache.bcel.generic.ReferenceType> parameters =
                  genericArgType.
                  getParameters(
                    );
                if (parameters !=
                      null &&
                      parameters.
                      size(
                        ) ==
                      2) {
                    mapType =
                      edu.umd.cs.findbugs.ba.generic.GenericUtilities.
                        getType(
                          "java.util.Map$Entry",
                          parameters);
                }
            }
            edu.umd.cs.findbugs.ba.generic.GenericObjectType entrySetType =
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.
              getType(
                "java.util.Set",
                java.util.Collections.
                  singletonList(
                    mapType));
            frame.
              pushValue(
                entrySetType);
            return;
        }
        if (className.
              startsWith(
                "java.util") &&
              className.
              endsWith(
                "Map")) {
            if ("keySet".
                  equals(
                    methodName) &&
                  "()Ljava/util/Set;".
                  equals(
                    signature) &&
                  handleGetMapView(
                    frame,
                    "java.util.Set",
                    0,
                    2) ||
                  "values".
                  equals(
                    methodName) &&
                  "()Ljava/util/Collection;".
                  equals(
                    signature) &&
                  handleGetMapView(
                    frame,
                    "java.util.Collection",
                    1,
                    2)) {
                return;
            }
        }
        if ("iterator".
              equals(
                methodName) &&
              "()Ljava/util/Iterator;".
              equals(
                signature) &&
              className.
              startsWith(
                "java.util") &&
              handleGetMapView(
                frame,
                "java.util.Iterator",
                0,
                1)) {
            return;
        }
        if ("java.util.Iterator".
              equals(
                className) &&
              "next".
              equals(
                methodName) &&
              "()Ljava/lang/Object;".
              equals(
                signature) &&
              getResultTypeFromGenericType(
                frame,
                0,
                1)) {
            return;
        }
        if ("initCause".
              equals(
                methodName) &&
              "(Ljava/lang/Throwable;)Ljava/lang/Throwable;".
              equals(
                signature) &&
              (className.
                 endsWith(
                   "Exception") ||
                 className.
                 endsWith(
                   "Error"))) {
            try {
                frame.
                  popValue(
                    );
                return;
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "Ooops",
                    e);
            }
        }
        if (handleToArray(
              obj)) {
            return;
        }
        org.apache.bcel.generic.Type result =
          edu.umd.cs.findbugs.ba.type.TopType.
          instance(
            );
        try {
            java.util.Set<edu.umd.cs.findbugs.ba.XMethod> targets =
              edu.umd.cs.findbugs.ba.Hierarchy2.
              resolveMethodCallTargets(
                obj,
                frame,
                cpg);
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    " For call to " +
                    className +
                    "." +
                    methodName +
                    signature);
                java.lang.System.
                  out.
                  println(
                    "   for " +
                    targets.
                      size(
                        ) +
                    " targets: " +
                    targets);
            }
            for (edu.umd.cs.findbugs.ba.XMethod m
                  :
                  targets) {
                m =
                  m.
                    resolveAccessMethodForMethod(
                      );
                java.lang.String sourceSignature =
                  m.
                  getSourceSignature(
                    );
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        " Call target: " +
                        m);
                    if (sourceSignature !=
                          null) {
                        java.lang.System.
                          out.
                          println(
                            "  source signature: " +
                            sourceSignature);
                    }
                }
                boolean foundSomething =
                  false;
                edu.umd.cs.findbugs.ba.XMethod m2 =
                  m.
                  bridgeTo(
                    );
                if (m2 !=
                      null) {
                    m =
                      m2;
                }
                if (sourceSignature !=
                      null &&
                      !sourceSignature.
                      equals(
                        m.
                          getSignature(
                            ))) {
                    edu.umd.cs.findbugs.ba.generic.GenericSignatureParser p =
                      new edu.umd.cs.findbugs.ba.generic.GenericSignatureParser(
                      sourceSignature);
                    java.lang.String rv =
                      p.
                      getReturnTypeSignature(
                        );
                    if (rv.
                          charAt(
                            0) !=
                          'T') {
                        try {
                            org.apache.bcel.generic.Type t =
                              edu.umd.cs.findbugs.ba.generic.GenericUtilities.
                              getType(
                                rv);
                            if (t !=
                                  null) {
                                assert t.
                                  getType(
                                    ) !=
                                  T_VOID;
                                result =
                                  merge(
                                    result,
                                    t);
                                foundSomething =
                                  true;
                            }
                        }
                        catch (java.lang.RuntimeException e) {
                            edu.umd.cs.findbugs.ba.AnalysisContext.
                              logError(
                                "Problem analyzing call to " +
                                m +
                                " with source signature" +
                                sourceSignature,
                                e);
                            break;
                        }
                    }
                }
                if (m ==
                      m2) {
                    edu.umd.cs.findbugs.ba.SignatureParser p =
                      new edu.umd.cs.findbugs.ba.SignatureParser(
                      m.
                        getSignature(
                          ));
                    java.lang.String rv =
                      p.
                      getReturnTypeSignature(
                        );
                    org.apache.bcel.generic.Type t =
                      org.apache.bcel.generic.Type.
                      getType(
                        rv);
                    result =
                      merge(
                        result,
                        t);
                    foundSomething =
                      true;
                }
                if (!foundSomething) {
                    result =
                      edu.umd.cs.findbugs.ba.type.TopType.
                        instance(
                          );
                    if (DEBUG) {
                        java.lang.System.
                          out.
                          println(
                            " giving up");
                    }
                    break;
                }
            }
        }
        catch (java.lang.RuntimeException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Problem analyzing call to " +
                className +
                "." +
                methodName +
                signature,
                e);
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Problem analyzing call to " +
                className +
                "." +
                methodName +
                signature,
                e);
        }
        catch (java.lang.ClassNotFoundException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Problem analyzing call to " +
                className +
                "." +
                methodName +
                signature,
                e);
        }
        consumeStack(
          obj);
        if (result instanceof edu.umd.cs.findbugs.ba.type.TopType) {
            pushReturnType(
              obj);
        }
        else {
            pushValue(
              result);
        }
    }
    public static final java.util.regex.Pattern
      mapSignaturePattern =
      java.util.regex.Pattern.
      compile(
        ("<(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*):" +
         "L[^;]*;(\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPa" +
         "rt}*):L[^;]*;>.*Ljava/util/(\\p{javaJavaIdentifierStart}(\\p" +
         "{javaJavaIdentifierPart}|/)*)?Map<T\\1;T\\2;>;.*"));
    public static boolean isStraightGenericMap(edu.umd.cs.findbugs.classfile.ClassDescriptor c) {
        if (c.
              matches(
                java.util.Map.class)) {
            return true;
        }
        edu.umd.cs.findbugs.ba.XClass xc;
        try {
            xc =
              c.
                getXClass(
                  );
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            return false;
        }
        java.lang.String sourceSignature =
          xc.
          getSourceSignature(
            );
        if (sourceSignature ==
              null) {
            return false;
        }
        if (sourceSignature.
              startsWith(
                "<")) {
            java.util.regex.Matcher matcher =
              mapSignaturePattern.
              matcher(
                sourceSignature);
            if (!matcher.
                  matches(
                    )) {
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        c +
                        " has a complex generic signature: " +
                        sourceSignature);
                }
                return false;
            }
        }
        return true;
    }
    private org.apache.bcel.generic.Type merge(org.apache.bcel.generic.Type prevType,
                                               org.apache.bcel.generic.Type newType)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        if (prevType.
              equals(
                edu.umd.cs.findbugs.ba.type.TopType.
                  instance(
                    ))) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Got " +
                    newType);
            }
            return newType;
        }
        else
            if (prevType.
                  equals(
                    newType)) {
                return prevType;
            }
            else {
                org.apache.bcel.generic.Type result =
                  typeMerger.
                  mergeTypes(
                    prevType,
                    newType);
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Merged " +
                        newType +
                        ", got " +
                        result);
                }
                return result;
            }
    }
    private boolean handleToArray(org.apache.bcel.generic.InvokeInstruction obj) {
        try {
            edu.umd.cs.findbugs.ba.type.TypeFrame frame =
              getFrame(
                );
            if (frame.
                  getStackDepth(
                    ) ==
                  0) {
                return false;
            }
            org.apache.bcel.generic.Type topValue =
              frame.
              getTopValue(
                );
            if ("toArray".
                  equals(
                    obj.
                      getName(
                        getCPG(
                          )))) {
                org.apache.bcel.generic.ReferenceType target =
                  obj.
                  getReferenceType(
                    getCPG(
                      ));
                java.lang.String signature =
                  obj.
                  getSignature(
                    getCPG(
                      ));
                if ("([Ljava/lang/Object;)[Ljava/lang/Object;".
                      equals(
                        signature) &&
                      edu.umd.cs.findbugs.ba.ch.Subtypes2.
                      isCollection(
                        target)) {
                    boolean topIsExact =
                      frame.
                      isExact(
                        frame.
                          getStackLocation(
                            0));
                    org.apache.bcel.generic.Type resultType =
                      frame.
                      popValue(
                        );
                    frame.
                      popValue(
                        );
                    frame.
                      pushValue(
                        resultType);
                    frame.
                      setExact(
                        frame.
                          getStackLocation(
                            0),
                        topIsExact);
                    return true;
                }
                else
                    if ("()[Ljava/lang/Object;".
                          equals(
                            signature) &&
                          edu.umd.cs.findbugs.ba.ch.Subtypes2.
                          isCollection(
                            target) &&
                          !"Ljava/util/Arrays$ArrayList;".
                          equals(
                            topValue.
                              getSignature(
                                ))) {
                        consumeStack(
                          obj);
                        pushReturnType(
                          obj);
                        frame.
                          setExact(
                            frame.
                              getStackLocation(
                                0),
                            true);
                        return true;
                    }
            }
            return false;
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            return false;
        }
        catch (java.lang.ClassNotFoundException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              reportMissingClass(
                e);
            return false;
        }
    }
    @javax.annotation.CheckForNull
    edu.umd.cs.findbugs.ba.generic.GenericObjectType getLocalVariable(int index,
                                                                      int pos) {
        if (genericLocalVariables ==
              null ||
              !genericLocalVariables.
              get(
                index)) {
            return null;
        }
        for (org.apache.bcel.classfile.LocalVariable local
              :
              localTypeTable.
               getLocalVariableTypeTable(
                 )) {
            if (local.
                  getIndex(
                    ) ==
                  index &&
                  local.
                  getStartPC(
                    ) <=
                  pos &&
                  pos <
                  +local.
                  getStartPC(
                    ) +
                  local.
                  getLength(
                    )) {
                java.lang.String signature =
                  local.
                  getSignature(
                    );
                if (signature.
                      indexOf(
                        '<') <
                      0) {
                    continue;
                }
                org.apache.bcel.generic.Type t;
                try {
                    t =
                      edu.umd.cs.findbugs.ba.generic.GenericUtilities.
                        getType(
                          signature);
                    if (t instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType) {
                        return (edu.umd.cs.findbugs.ba.generic.GenericObjectType)
                                 t;
                    }
                }
                catch (java.lang.RuntimeException e) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      logError(
                        "Bad signature " +
                        signature +
                        " for " +
                        local.
                          getName(
                            ),
                        e);
                }
                return null;
            }
        }
        return null;
    }
    @java.lang.Override
    public void handleStoreInstruction(org.apache.bcel.generic.StoreInstruction obj) {
        try {
            int numConsumed =
              obj.
              consumeStack(
                cpg);
            if (numConsumed ==
                  1) {
                boolean isExact =
                  isTopOfStackExact(
                    );
                edu.umd.cs.findbugs.ba.type.TypeFrame frame =
                  getFrame(
                    );
                org.apache.bcel.generic.Type value =
                  frame.
                  popValue(
                    );
                int index =
                  obj.
                  getIndex(
                    );
                if (value instanceof org.apache.bcel.generic.ReferenceType &&
                      !(value instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType)) {
                    edu.umd.cs.findbugs.ba.generic.GenericObjectType gType =
                      getLocalVariable(
                        index,
                        getLocation(
                          ).
                          getHandle(
                            ).
                          getPosition(
                            ));
                    value =
                      edu.umd.cs.findbugs.ba.generic.GenericUtilities.
                        merge(
                          gType,
                          value);
                }
                frame.
                  setValue(
                    index,
                    value);
                frame.
                  setExact(
                    index,
                    isExact);
            }
            else {
                super.
                  handleStoreInstruction(
                    obj);
            }
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            throw new edu.umd.cs.findbugs.ba.InvalidBytecodeException(
              "error handling store instruction ",
              e);
        }
    }
    @java.lang.Override
    public void handleLoadInstruction(org.apache.bcel.generic.LoadInstruction obj) {
        int numProduced =
          obj.
          produceStack(
            cpg);
        if (numProduced ==
              org.apache.bcel.Constants.
                UNPREDICTABLE) {
            throw new edu.umd.cs.findbugs.ba.InvalidBytecodeException(
              "Unpredictable stack production");
        }
        if (numProduced !=
              1) {
            super.
              handleLoadInstruction(
                obj);
            return;
        }
        int index =
          obj.
          getIndex(
            );
        edu.umd.cs.findbugs.ba.type.TypeFrame frame =
          getFrame(
            );
        org.apache.bcel.generic.Type value =
          frame.
          getValue(
            index);
        if (value instanceof org.apache.bcel.generic.ReferenceType &&
              !(value instanceof edu.umd.cs.findbugs.ba.generic.GenericObjectType)) {
            edu.umd.cs.findbugs.ba.generic.GenericObjectType gType =
              getLocalVariable(
                index,
                getLocation(
                  ).
                  getHandle(
                    ).
                  getPosition(
                    ));
            value =
              edu.umd.cs.findbugs.ba.generic.GenericUtilities.
                merge(
                  gType,
                  value);
        }
        boolean isExact =
          frame.
          isExact(
            index);
        frame.
          pushValue(
            value);
        if (isExact) {
            setTopOfStackIsExact(
              );
        }
    }
    @java.lang.Override
    public void visitCHECKCAST(org.apache.bcel.generic.CHECKCAST obj) {
        try {
            org.apache.bcel.generic.Type t =
              getFrame(
                ).
              popValue(
                );
            if (t instanceof edu.umd.cs.findbugs.ba.type.NullType) {
                pushValue(
                  t);
            }
            else {
                pushValue(
                  obj.
                    getType(
                      getCPG(
                        )));
            }
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            throw new edu.umd.cs.findbugs.ba.InvalidBytecodeException(
              "Stack underflow for " +
              obj +
              ": " +
              e.
                getMessage(
                  ));
        }
    }
    @java.lang.Override
    public void visitINSTANCEOF(org.apache.bcel.generic.INSTANCEOF obj) {
        if (valueNumberDataflow !=
              null) {
            try {
                edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
                  valueNumberDataflow.
                  getFactAtLocation(
                    getLocation(
                      ));
                if (vnaFrame.
                      isValid(
                        )) {
                    final org.apache.bcel.generic.Type type =
                      obj.
                      getType(
                        getCPG(
                          ));
                    if (type instanceof org.apache.bcel.generic.ReferenceType) {
                        instanceOfValueNumber =
                          vnaFrame.
                            getTopValue(
                              );
                        instanceOfType =
                          (org.apache.bcel.generic.ReferenceType)
                            type;
                        sawEffectiveInstanceOf =
                          true;
                    }
                }
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                
            }
        }
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitIFNULL(org.apache.bcel.generic.IFNULL obj) {
        if (valueNumberDataflow !=
              null) {
            try {
                edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
                  valueNumberDataflow.
                  getFactAtLocation(
                    getLocation(
                      ));
                if (vnaFrame.
                      isValid(
                        )) {
                    instanceOfValueNumber =
                      vnaFrame.
                        getTopValue(
                          );
                    instanceOfType =
                      edu.umd.cs.findbugs.ba.type.NullType.
                        instance(
                          );
                    instanceOfFollowedByBranch =
                      true;
                }
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                
            }
        }
        consumeStack(
          obj);
    }
    @java.lang.Override
    public void visitIFNONNULL(org.apache.bcel.generic.IFNONNULL obj) {
        if (valueNumberDataflow !=
              null) {
            try {
                edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
                  valueNumberDataflow.
                  getFactAtLocation(
                    getLocation(
                      ));
                if (vnaFrame.
                      isValid(
                        )) {
                    instanceOfValueNumber =
                      vnaFrame.
                        getTopValue(
                          );
                    instanceOfType =
                      edu.umd.cs.findbugs.ba.type.NullType.
                        instance(
                          );
                    instanceOfFollowedByBranch =
                      true;
                }
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                
            }
        }
        consumeStack(
          obj);
    }
    @java.lang.Override
    public void visitFCMPL(org.apache.bcel.generic.FCMPL obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitFCMPG(org.apache.bcel.generic.FCMPG obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitDCMPL(org.apache.bcel.generic.DCMPL obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitDCMPG(org.apache.bcel.generic.DCMPG obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitLCMP(org.apache.bcel.generic.LCMP obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitD2F(org.apache.bcel.generic.D2F obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            FLOAT);
    }
    @java.lang.Override
    public void visitD2I(org.apache.bcel.generic.D2I obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitD2L(org.apache.bcel.generic.D2L obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitF2D(org.apache.bcel.generic.F2D obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            DOUBLE);
    }
    @java.lang.Override
    public void visitF2I(org.apache.bcel.generic.F2I obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitF2L(org.apache.bcel.generic.F2L obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitI2B(org.apache.bcel.generic.I2B obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            BYTE);
    }
    @java.lang.Override
    public void visitI2C(org.apache.bcel.generic.I2C obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            CHAR);
    }
    @java.lang.Override
    public void visitI2D(org.apache.bcel.generic.I2D obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            DOUBLE);
    }
    @java.lang.Override
    public void visitI2F(org.apache.bcel.generic.I2F obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            FLOAT);
    }
    @java.lang.Override
    public void visitI2L(org.apache.bcel.generic.I2L obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitI2S(org.apache.bcel.generic.I2S obj) {
        
    }
    @java.lang.Override
    public void visitL2D(org.apache.bcel.generic.L2D obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            DOUBLE);
    }
    @java.lang.Override
    public void visitL2F(org.apache.bcel.generic.L2F obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            FLOAT);
    }
    @java.lang.Override
    public void visitL2I(org.apache.bcel.generic.L2I obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitIAND(org.apache.bcel.generic.IAND obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitLAND(org.apache.bcel.generic.LAND obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitIOR(org.apache.bcel.generic.IOR obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitLOR(org.apache.bcel.generic.LOR obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitIXOR(org.apache.bcel.generic.IXOR obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitLXOR(org.apache.bcel.generic.LXOR obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitISHR(org.apache.bcel.generic.ISHR obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitIUSHR(org.apache.bcel.generic.IUSHR obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitLSHR(org.apache.bcel.generic.LSHR obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitLUSHR(org.apache.bcel.generic.LUSHR obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitISHL(org.apache.bcel.generic.ISHL obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitLSHL(org.apache.bcel.generic.LSHL obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitDADD(org.apache.bcel.generic.DADD obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            DOUBLE);
    }
    @java.lang.Override
    public void visitFADD(org.apache.bcel.generic.FADD obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            FLOAT);
    }
    @java.lang.Override
    public void visitIADD(org.apache.bcel.generic.IADD obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitLADD(org.apache.bcel.generic.LADD obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitDSUB(org.apache.bcel.generic.DSUB obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            DOUBLE);
    }
    @java.lang.Override
    public void visitDUP(org.apache.bcel.generic.DUP obj) {
        try {
            edu.umd.cs.findbugs.ba.type.TypeFrame frame =
              getFrame(
                );
            boolean isExact =
              isTopOfStackExact(
                );
            org.apache.bcel.generic.Type value =
              frame.
              popValue(
                );
            frame.
              pushValue(
                value);
            if (isExact) {
                setTopOfStackIsExact(
                  );
            }
            frame.
              pushValue(
                value);
            if (isExact) {
                setTopOfStackIsExact(
                  );
            }
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            throw new edu.umd.cs.findbugs.ba.InvalidBytecodeException(
              e.
                toString(
                  ));
        }
    }
    @java.lang.Override
    public void visitFSUB(org.apache.bcel.generic.FSUB obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            FLOAT);
    }
    @java.lang.Override
    public void visitISUB(org.apache.bcel.generic.ISUB obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitLSUB(org.apache.bcel.generic.LSUB obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitDMUL(org.apache.bcel.generic.DMUL obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            DOUBLE);
    }
    @java.lang.Override
    public void visitFMUL(org.apache.bcel.generic.FMUL obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            FLOAT);
    }
    @java.lang.Override
    public void visitIMUL(org.apache.bcel.generic.IMUL obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitLMUL(org.apache.bcel.generic.LMUL obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitDDIV(org.apache.bcel.generic.DDIV obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            DOUBLE);
    }
    @java.lang.Override
    public void visitFDIV(org.apache.bcel.generic.FDIV obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            FLOAT);
    }
    @java.lang.Override
    public void visitIDIV(org.apache.bcel.generic.IDIV obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitLDIV(org.apache.bcel.generic.LDIV obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitDREM(org.apache.bcel.generic.DREM obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            DOUBLE);
    }
    @java.lang.Override
    public void visitFREM(org.apache.bcel.generic.FREM obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            FLOAT);
    }
    @java.lang.Override
    public void visitIREM(org.apache.bcel.generic.IREM obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitLREM(org.apache.bcel.generic.LREM obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitIINC(org.apache.bcel.generic.IINC obj) {
        
    }
    @java.lang.Override
    public void visitDNEG(org.apache.bcel.generic.DNEG obj) {
        
    }
    @java.lang.Override
    public void visitFNEG(org.apache.bcel.generic.FNEG obj) {
        
    }
    @java.lang.Override
    public void visitINEG(org.apache.bcel.generic.INEG obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitLNEG(org.apache.bcel.generic.LNEG obj) {
        
    }
    @java.lang.Override
    public void visitARRAYLENGTH(org.apache.bcel.generic.ARRAYLENGTH obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitAALOAD(org.apache.bcel.generic.AALOAD obj) {
        edu.umd.cs.findbugs.ba.type.TypeFrame frame =
          getFrame(
            );
        try {
            frame.
              popValue(
                );
            org.apache.bcel.generic.Type arrayType =
              frame.
              popValue(
                );
            if (arrayType instanceof org.apache.bcel.generic.ArrayType) {
                org.apache.bcel.generic.ArrayType arr =
                  (org.apache.bcel.generic.ArrayType)
                    arrayType;
                pushValue(
                  arr.
                    getElementType(
                      ));
            }
            else {
                pushValue(
                  edu.umd.cs.findbugs.ba.type.TypeFrame.
                    getBottomType(
                      ));
            }
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            throw new edu.umd.cs.findbugs.ba.InvalidBytecodeException(
              "Stack underflow: " +
              e.
                getMessage(
                  ));
        }
    }
    @java.lang.Override
    public void visitBALOAD(org.apache.bcel.generic.BALOAD obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            BYTE);
    }
    @java.lang.Override
    public void visitCALOAD(org.apache.bcel.generic.CALOAD obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            CHAR);
    }
    @java.lang.Override
    public void visitDALOAD(org.apache.bcel.generic.DALOAD obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            DOUBLE);
    }
    @java.lang.Override
    public void visitFALOAD(org.apache.bcel.generic.FALOAD obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            FLOAT);
    }
    @java.lang.Override
    public void visitIALOAD(org.apache.bcel.generic.IALOAD obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            INT);
    }
    @java.lang.Override
    public void visitLALOAD(org.apache.bcel.generic.LALOAD obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            LONG);
    }
    @java.lang.Override
    public void visitSALOAD(org.apache.bcel.generic.SALOAD obj) {
        consumeStack(
          obj);
        pushValue(
          org.apache.bcel.generic.Type.
            SHORT);
    }
    @java.lang.Override
    public void visitNEW(org.apache.bcel.generic.NEW obj) {
        pushValue(
          obj.
            getType(
              getCPG(
                )));
        setTopOfStackIsExact(
          );
    }
    @java.lang.Override
    public void visitNEWARRAY(org.apache.bcel.generic.NEWARRAY obj) {
        consumeStack(
          obj);
        org.apache.bcel.generic.Type elementType =
          obj.
          getType(
            );
        pushValue(
          elementType);
        setTopOfStackIsExact(
          );
    }
    @java.lang.Override
    public void visitANEWARRAY(org.apache.bcel.generic.ANEWARRAY obj) {
        consumeStack(
          obj);
        org.apache.bcel.generic.Type elementType =
          obj.
          getType(
            getCPG(
              ));
        pushValue(
          new org.apache.bcel.generic.ArrayType(
            elementType,
            1));
        setTopOfStackIsExact(
          );
    }
    @java.lang.Override
    public void visitMULTIANEWARRAY(org.apache.bcel.generic.MULTIANEWARRAY obj) {
        consumeStack(
          obj);
        org.apache.bcel.generic.Type elementType =
          obj.
          getType(
            getCPG(
              ));
        pushValue(
          elementType);
        setTopOfStackIsExact(
          );
    }
    private void setTopOfStackIsExact() {
        edu.umd.cs.findbugs.ba.type.TypeFrame frame =
          getFrame(
            );
        frame.
          setExact(
            frame.
              getNumSlots(
                ) -
              1,
            true);
    }
    private boolean isTopOfStackExact() {
        edu.umd.cs.findbugs.ba.type.TypeFrame frame =
          getFrame(
            );
        return frame.
          isExact(
            frame.
              getNumSlots(
                ) -
              1);
    }
    @java.lang.Override
    public void visitJSR(org.apache.bcel.generic.JSR obj) {
        pushValue(
          org.apache.bcel.generic.ReturnaddressType.
            NO_TARGET);
    }
    @java.lang.Override
    public void visitJSR_W(org.apache.bcel.generic.JSR_W obj) {
        pushValue(
          org.apache.bcel.generic.ReturnaddressType.
            NO_TARGET);
    }
    @java.lang.Override
    public void visitRET(org.apache.bcel.generic.RET obj) {
        
    }
    @java.lang.Override
    public void visitIFEQ(org.apache.bcel.generic.IFEQ obj) {
        if (previousWasEffectiveInstanceOf) {
            instanceOfFollowedByBranch =
              true;
        }
        super.
          visitIFEQ(
            obj);
    }
    @java.lang.Override
    public void visitIFGT(org.apache.bcel.generic.IFGT obj) {
        if (previousWasEffectiveInstanceOf) {
            instanceOfFollowedByBranch =
              true;
        }
        super.
          visitIFGT(
            obj);
    }
    @java.lang.Override
    public void visitIFLE(org.apache.bcel.generic.IFLE obj) {
        if (previousWasEffectiveInstanceOf) {
            instanceOfFollowedByBranch =
              true;
        }
        super.
          visitIFLE(
            obj);
    }
    @java.lang.Override
    public void visitIFNE(org.apache.bcel.generic.IFNE obj) {
        if (previousWasEffectiveInstanceOf) {
            instanceOfFollowedByBranch =
              true;
        }
        super.
          visitIFNE(
            obj);
    }
    public boolean isImpliedByGenericTypes(org.apache.bcel.generic.ReferenceType t) {
        return typesComputedFromGenerics.
          contains(
            t);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "93IQF5rrFYgOw/ciD6P3bIrkbDf48ow5");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("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" +
       "jcSv0AAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/YkHSVM/N77Zz4PQ8CRt8Sesv734wqv/7mLu2ix3j7S1DU4ww7RdzkCs5R8Z" +
       "DIhNbzh/Y9y0CRIeOPaQz971Xqduu+u7TvoX8D29Ov3+uB139YSUcgl8etuW" +
       "3Nt1Vxdy2Rc0S/KCTN6XipcceYdrrqevQFCxdQ//CP5dAJ8vp580s/TAJgR4" +
       "MrqNQ55/HIi4oOu7d5UqTodpOIwJgTA3neioAV0/owGtbOE6d3OyjW9NZSUV" +
       "2KZM9TNN7atuBAGBD7sFwZ4BgjkDRPq1ndHtgPBW31YKM28B5+NEitxcNz1w" +
       "RNtvxKynW8Cxr7ahJvTQkz+5eNun37UJI3ctdudi5Vvf8m3/eP1Nb7l4Knh/" +
       "0U3x8+k0mwA+K/QTs5KnPuAF++6SpWj9+Xseet+PPfTGTamefGMoioOR1rv+" +
       "4Esfuv59n/rgLeKcayLwkIpg79QU+yhr6mXgM9jW1OCMmnrNI6mpu05q6rhP" +
       "B3Z3/1mO/oZwYUeJBx+lEqmjG22VGJ2hhPpIlHjqiRKnGsXDdUI7bWhHGe2R" +
       "K/Pk9Og3gw+3VYY7Qxn31spczJQJgPvSbcE8UuorMvNLXQYYMsotz7Hamzrw" +
       "gZG+/OwmNAxFPzg1zvsO/e0f/p2/vfv1G2u9se1lQ/1t0t10H//YpeLjg/u+" +
       "MwvFLouCn1X3HcDL+umVQe75Z08bZHltGtbjT9xi7tZu8d4borvr2aSE68ZH" +
       "1ffEk/4VnE4Pfv0NrfTWAB6UCOvB4Xs//sZK1gjvXqUjBkUebWcxbgyQTgYN" +
       "D9wws3FLRA9Kn37Pd/z2Cz7D3ZsNWTc00mJV4039vmprMhcyk7mY2ww87j+j" +
       "wNsSZfHcg9LXv+3LH/6Lhz7xwUu5qyDUTjs9wQPDVTAevn7WTM/pDO4bgW8Y" +
       "SAU6w7s2qcFoKavUbeU9+fjo8aghyL3yrLwzj7wzuEjnSlKP7jWd0JazeODG" +
       "zvZxoeuePpuZwRP+T83gdSASfgTojjXfNsG0UYK6vCsznjSWyBzz6ZNpz4tS" +
       "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" +
       "1yCoPq907aXXRJiwIcosIiUSBhl1DGHr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "B9MF+9+91fS7HxtNTyvynD3nnpeKZ4Dm");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "aV7u/wYQ2yb4DdwAAA==");
}
