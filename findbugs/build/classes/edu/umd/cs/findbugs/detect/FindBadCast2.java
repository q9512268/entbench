package edu.umd.cs.findbugs.detect;
public class FindBadCast2 implements edu.umd.cs.findbugs.Detector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private final java.util.Set<java.lang.String> concreteCollectionClasses =
      new java.util.HashSet<java.lang.String>(
      );
    private final java.util.Set<java.lang.String> abstractCollectionClasses =
      new java.util.HashSet<java.lang.String>(
      );
    private final java.util.Set<java.lang.String> veryAbstractCollectionClasses =
      new java.util.HashSet<java.lang.String>(
      );
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "bc.debug");
    public FindBadCast2(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        veryAbstractCollectionClasses.
          add(
            "java.util.Collection");
        veryAbstractCollectionClasses.
          add(
            "java.util.Iterable");
        abstractCollectionClasses.
          add(
            "java.util.Collection");
        abstractCollectionClasses.
          add(
            "java.util.List");
        abstractCollectionClasses.
          add(
            "java.util.Set");
        abstractCollectionClasses.
          add(
            "java.util.SortedSet");
        abstractCollectionClasses.
          add(
            "java.util.SortedMap");
        abstractCollectionClasses.
          add(
            "java.util.Map");
        concreteCollectionClasses.
          add(
            "java.util.LinkedHashMap");
        concreteCollectionClasses.
          add(
            "java.util.LinkedHashSet");
        concreteCollectionClasses.
          add(
            "java.util.HashMap");
        concreteCollectionClasses.
          add(
            "java.util.HashSet");
        concreteCollectionClasses.
          add(
            "java.util.TreeMap");
        concreteCollectionClasses.
          add(
            "java.util.TreeSet");
        concreteCollectionClasses.
          add(
            "java.util.ArrayList");
        concreteCollectionClasses.
          add(
            "java.util.LinkedList");
        concreteCollectionClasses.
          add(
            "java.util.Hashtable");
        concreteCollectionClasses.
          add(
            "java.util.Vector");
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        org.apache.bcel.classfile.JavaClass javaClass =
          classContext.
          getJavaClass(
            );
        org.apache.bcel.classfile.Method[] methodList =
          javaClass.
          getMethods(
            );
        for (org.apache.bcel.classfile.Method method
              :
              methodList) {
            if (method.
                  getCode(
                    ) ==
                  null) {
                continue;
            }
            try {
                analyzeMethod(
                  classContext,
                  method);
            }
            catch (edu.umd.cs.findbugs.ba.MethodUnprofitableException e) {
                assert true;
            }
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                java.lang.String msg =
                  "Detector " +
                this.
                  getClass(
                    ).
                  getName(
                    ) +
                " caught exception while analyzing " +
                javaClass.
                  getClassName(
                    ) +
                "." +
                method.
                  getName(
                    ) +
                " : " +
                method.
                  getSignature(
                    );
                bugReporter.
                  logError(
                    msg,
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                java.lang.String msg =
                  "Detector " +
                this.
                  getClass(
                    ).
                  getName(
                    ) +
                " caught exception while analyzing " +
                javaClass.
                  getClassName(
                    ) +
                "." +
                method.
                  getName(
                    ) +
                " : " +
                method.
                  getSignature(
                    );
                bugReporter.
                  logError(
                    msg,
                    e);
            }
        }
    }
    public boolean prescreen(edu.umd.cs.findbugs.ba.ClassContext classContext,
                             org.apache.bcel.classfile.Method method) {
        java.util.BitSet bytecodeSet =
          classContext.
          getBytecodeSet(
            method);
        return bytecodeSet !=
          null &&
          (bytecodeSet.
             get(
               org.apache.bcel.Constants.
                 CHECKCAST) ||
             bytecodeSet.
             get(
               org.apache.bcel.Constants.
                 INSTANCEOF));
    }
    private java.util.Set<edu.umd.cs.findbugs.ba.vna.ValueNumber> getParameterValueNumbers(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                                                                           org.apache.bcel.classfile.Method method,
                                                                                           edu.umd.cs.findbugs.ba.CFG cfg)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        edu.umd.cs.findbugs.ba.CFGBuilderException {
        edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow vnaDataflow =
          classContext.
          getValueNumberDataflow(
            method);
        edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrameAtEntry =
          vnaDataflow.
          getStartFact(
            cfg.
              getEntry(
                ));
        java.util.Set<edu.umd.cs.findbugs.ba.vna.ValueNumber> paramValueNumberSet =
          new java.util.HashSet<edu.umd.cs.findbugs.ba.vna.ValueNumber>(
          );
        int firstParam =
          method.
          isStatic(
            )
          ? 0
          : 1;
        for (int i =
               firstParam;
             i <
               vnaFrameAtEntry.
               getNumLocals(
                 );
             ++i) {
            paramValueNumberSet.
              add(
                vnaFrameAtEntry.
                  getValue(
                    i));
        }
        return paramValueNumberSet;
    }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        if (edu.umd.cs.findbugs.bcel.BCELUtil.
              isSynthetic(
                method) ||
              !prescreen(
                 classContext,
                 method)) {
            return;
        }
        edu.umd.cs.findbugs.BugAccumulator accumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
          bugReporter);
        edu.umd.cs.findbugs.ba.CFG cfg =
          classContext.
          getCFG(
            method);
        edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow =
          classContext.
          getTypeDataflow(
            method);
        edu.umd.cs.findbugs.ba.npe.IsNullValueDataflow isNullDataflow =
          classContext.
          getIsNullValueDataflow(
            method);
        java.util.Set<edu.umd.cs.findbugs.ba.vna.ValueNumber> paramValueNumberSet =
          null;
        edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow vnaDataflow =
          null;
        org.apache.bcel.generic.ConstantPoolGen cpg =
          classContext.
          getConstantPoolGen(
            );
        org.apache.bcel.generic.MethodGen methodGen =
          classContext.
          getMethodGen(
            method);
        if (methodGen ==
              null) {
            return;
        }
        java.lang.String methodName =
          methodGen.
          getClassName(
            ) +
        "." +
        methodGen.
          getName(
            );
        java.lang.String sourceFile =
          classContext.
          getJavaClass(
            ).
          getSourceFileName(
            );
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Checking " +
                methodName);
        }
        java.util.Set<edu.umd.cs.findbugs.SourceLineAnnotation> haveInstanceOf =
          new java.util.HashSet<edu.umd.cs.findbugs.SourceLineAnnotation>(
          );
        java.util.Set<edu.umd.cs.findbugs.SourceLineAnnotation> haveCast =
          new java.util.HashSet<edu.umd.cs.findbugs.SourceLineAnnotation>(
          );
        java.util.Set<edu.umd.cs.findbugs.SourceLineAnnotation> haveMultipleInstanceOf =
          new java.util.HashSet<edu.umd.cs.findbugs.SourceLineAnnotation>(
          );
        java.util.Set<edu.umd.cs.findbugs.SourceLineAnnotation> haveMultipleCast =
          new java.util.HashSet<edu.umd.cs.findbugs.SourceLineAnnotation>(
          );
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               cfg.
               locationIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location location =
              i.
              next(
                );
            org.apache.bcel.generic.InstructionHandle handle =
              location.
              getHandle(
                );
            org.apache.bcel.generic.Instruction ins =
              handle.
              getInstruction(
                );
            if (!(ins instanceof org.apache.bcel.generic.CHECKCAST) &&
                  !(ins instanceof org.apache.bcel.generic.INSTANCEOF)) {
                continue;
            }
            edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation =
              edu.umd.cs.findbugs.SourceLineAnnotation.
              fromVisitedInstruction(
                classContext,
                methodGen,
                sourceFile,
                handle);
            if (ins instanceof org.apache.bcel.generic.CHECKCAST) {
                if (!haveCast.
                      add(
                        sourceLineAnnotation)) {
                    haveMultipleCast.
                      add(
                        sourceLineAnnotation);
                    if (DEBUG) {
                        java.lang.System.
                          out.
                          println(
                            "Have multiple casts for " +
                            sourceLineAnnotation);
                    }
                }
            }
            else {
                if (!haveInstanceOf.
                      add(
                        sourceLineAnnotation)) {
                    haveMultipleInstanceOf.
                      add(
                        sourceLineAnnotation);
                    if (DEBUG) {
                        java.lang.System.
                          out.
                          println(
                            "Have multiple instanceof for " +
                            sourceLineAnnotation);
                    }
                }
            }
        }
        java.util.BitSet linesMentionedMultipleTimes =
          classContext.
          linesMentionedMultipleTimes(
            method);
        org.apache.bcel.classfile.LineNumberTable lineNumberTable =
          methodGen.
          getLineNumberTable(
            methodGen.
              getConstantPool(
                ));
        java.util.Map<edu.umd.cs.findbugs.BugAnnotation,java.lang.String> instanceOfChecks =
          new java.util.HashMap<edu.umd.cs.findbugs.BugAnnotation,java.lang.String>(
          );
        java.lang.String constantClass =
          null;
        boolean methodInvocationWasGeneric =
          false;
        int pcForConstantClass =
          -1;
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               cfg.
               locationIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location location =
              i.
              next(
                );
            org.apache.bcel.generic.InstructionHandle handle =
              location.
              getHandle(
                );
            int pc =
              handle.
              getPosition(
                );
            org.apache.bcel.generic.Instruction ins =
              handle.
              getInstruction(
                );
            boolean wasMethodInvocationWasGeneric =
              methodInvocationWasGeneric;
            methodInvocationWasGeneric =
              false;
            if (ins instanceof org.apache.bcel.generic.InvokeInstruction) {
                org.apache.bcel.generic.InvokeInstruction iinv =
                  (org.apache.bcel.generic.InvokeInstruction)
                    ins;
                edu.umd.cs.findbugs.ba.XMethod m =
                  edu.umd.cs.findbugs.ba.XFactory.
                  createXMethod(
                    iinv,
                    cpg);
                if (m !=
                      null) {
                    java.lang.String sourceSignature =
                      m.
                      getSourceSignature(
                        );
                    methodInvocationWasGeneric =
                      sourceSignature !=
                        null &&
                        (sourceSignature.
                           startsWith(
                             "<") ||
                           sourceSignature.
                           indexOf(
                             "java/lang/Class") >=
                           0);
                    if (DEBUG &&
                          methodInvocationWasGeneric) {
                        java.lang.System.
                          out.
                          println(
                            m +
                            " has source signature " +
                            sourceSignature);
                    }
                }
            }
            if (ins instanceof org.apache.bcel.generic.LDC) {
                org.apache.bcel.generic.LDC ldc =
                  (org.apache.bcel.generic.LDC)
                    ins;
                java.lang.Object value =
                  ldc.
                  getValue(
                    cpg);
                if (value instanceof org.apache.bcel.classfile.ConstantClass) {
                    org.apache.bcel.classfile.ConstantClass cc =
                      (org.apache.bcel.classfile.ConstantClass)
                        value;
                    constantClass =
                      cc.
                        getBytes(
                          classContext.
                            getJavaClass(
                              ).
                            getConstantPool(
                              ));
                    pcForConstantClass =
                      pc;
                }
            }
            if (!(ins instanceof org.apache.bcel.generic.CHECKCAST) &&
                  !(ins instanceof org.apache.bcel.generic.INSTANCEOF)) {
                continue;
            }
            boolean isCast =
              ins instanceof org.apache.bcel.generic.CHECKCAST;
            int occurrences =
              cfg.
              getLocationsContainingInstructionWithOffset(
                pc).
              size(
                );
            boolean split =
              occurrences >
              1;
            if (lineNumberTable !=
                  null) {
                int line =
                  lineNumberTable.
                  getSourceLine(
                    handle.
                      getPosition(
                        ));
                if (line >
                      0 &&
                      linesMentionedMultipleTimes.
                      get(
                        line)) {
                    split =
                      true;
                }
            }
            edu.umd.cs.findbugs.ba.npe.IsNullValueFrame nullFrame =
              isNullDataflow.
              getFactAtLocation(
                location);
            if (!nullFrame.
                  isValid(
                    )) {
                continue;
            }
            edu.umd.cs.findbugs.ba.npe.IsNullValue operandNullness =
              nullFrame.
              getTopValue(
                );
            if (DEBUG) {
                java.lang.String kind =
                  isCast
                  ? "checkedCast"
                  : "instanceof";
                java.lang.System.
                  out.
                  println(
                    kind +
                    " at pc: " +
                    pc +
                    " in " +
                    methodName);
                java.lang.System.
                  out.
                  println(
                    " occurrences: " +
                    occurrences);
                java.lang.System.
                  out.
                  println(
                    "XXX: " +
                    operandNullness);
            }
            if (split &&
                  !isCast) {
                continue;
            }
            edu.umd.cs.findbugs.ba.type.TypeFrame frame =
              typeDataflow.
              getFactAtLocation(
                location);
            if (!frame.
                  isValid(
                    )) {
                continue;
            }
            org.apache.bcel.generic.Type operandType =
              frame.
              getTopValue(
                );
            if (operandType.
                  equals(
                    edu.umd.cs.findbugs.ba.type.TopType.
                      instance(
                        ))) {
                continue;
            }
            boolean operandTypeIsExact =
              frame.
              isExact(
                frame.
                  getStackLocation(
                    0));
            final org.apache.bcel.generic.Type castType =
              ((org.apache.bcel.generic.TypedInstruction)
                 ins).
              getType(
                cpg);
            if (!(castType instanceof org.apache.bcel.generic.ReferenceType)) {
                continue;
            }
            java.lang.String castSig =
              castType.
              getSignature(
                );
            if (operandType.
                  equals(
                    edu.umd.cs.findbugs.ba.type.NullType.
                      instance(
                        )) ||
                  operandNullness.
                  isDefinitelyNull(
                    )) {
                edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation =
                  edu.umd.cs.findbugs.SourceLineAnnotation.
                  fromVisitedInstruction(
                    classContext,
                    methodGen,
                    sourceFile,
                    handle);
                assert castSig.
                  length(
                    ) >
                  1;
                if (!isCast) {
                    accumulator.
                      accumulateBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "NP_NULL_INSTANCEOF",
                          split
                            ? LOW_PRIORITY
                            : NORMAL_PRIORITY).
                          addClassAndMethod(
                            methodGen,
                            sourceFile).
                          addType(
                            castSig),
                        sourceLineAnnotation);
                }
                continue;
            }
            if (!(operandType instanceof org.apache.bcel.generic.ReferenceType)) {
                continue;
            }
            final org.apache.bcel.generic.ReferenceType refType =
              (org.apache.bcel.generic.ReferenceType)
                operandType;
            boolean impliesByGenerics =
              typeDataflow.
              getAnalysis(
                ).
              isImpliedByGenericTypes(
                refType);
            if (impliesByGenerics &&
                  !isCast) {
                continue;
            }
            final boolean typesAreEqual =
              refType.
              equals(
                castType);
            if (isCast &&
                  typesAreEqual) {
                continue;
            }
            java.lang.String refSig =
              refType.
              getSignature(
                );
            java.lang.String castSig2 =
              castSig;
            java.lang.String refSig2 =
              refSig;
            while (castSig2.
                     charAt(
                       0) ==
                     '[' &&
                     refSig2.
                     charAt(
                       0) ==
                     '[') {
                castSig2 =
                  castSig2.
                    substring(
                      1);
                refSig2 =
                  refSig2.
                    substring(
                      1);
            }
            edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation =
              edu.umd.cs.findbugs.SourceLineAnnotation.
              fromVisitedInstruction(
                classContext,
                methodGen,
                sourceFile,
                handle);
            if (refSig2.
                  charAt(
                    0) !=
                  'L' ||
                  castSig2.
                  charAt(
                    0) !=
                  'L') {
                if (castSig2.
                      charAt(
                        0) ==
                      '[' &&
                      ("Ljava/io/Serializable;".
                         equals(
                           refSig2) ||
                         "Ljava/lang/Object;".
                         equals(
                           refSig2) ||
                         "Ljava/lang/Cloneable;".
                         equals(
                           refSig2))) {
                    continue;
                }
                if (refSig2.
                      charAt(
                        0) ==
                      '[' &&
                      ("Ljava/io/Serializable;".
                         equals(
                           castSig2) ||
                         "Ljava/lang/Object;".
                         equals(
                           castSig2) ||
                         "Ljava/lang/Cloneable;".
                         equals(
                           castSig2))) {
                    continue;
                }
                int priority =
                  HIGH_PRIORITY;
                if (split &&
                      (castSig2.
                         endsWith(
                           "Error;") ||
                         castSig2.
                         endsWith(
                           "Exception;"))) {
                    priority =
                      LOW_PRIORITY;
                }
                if (!typesAreEqual) {
                    bugReporter.
                      reportBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          isCast
                            ? "BC_IMPOSSIBLE_CAST"
                            : "BC_IMPOSSIBLE_INSTANCEOF",
                          priority).
                          addClassAndMethod(
                            methodGen,
                            sourceFile).
                          addFoundAndExpectedType(
                            refType,
                            castType).
                          addSourceLine(
                            sourceLineAnnotation));
                }
                continue;
            }
            if (!operandTypeIsExact &&
                  "Ljava/lang/Object;".
                  equals(
                    refSig2)) {
                continue;
            }
            java.lang.String castName =
              castSig2.
              substring(
                1,
                castSig2.
                  length(
                    ) -
                  1).
              replace(
                '/',
                '.');
            java.lang.String refName =
              refSig2.
              substring(
                1,
                refSig2.
                  length(
                    ) -
                  1).
              replace(
                '/',
                '.');
            if (vnaDataflow ==
                  null) {
                vnaDataflow =
                  classContext.
                    getValueNumberDataflow(
                      method);
            }
            edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vFrame =
              vnaDataflow.
              getFactAtLocation(
                location);
            if (paramValueNumberSet ==
                  null) {
                paramValueNumberSet =
                  getParameterValueNumbers(
                    classContext,
                    method,
                    cfg);
            }
            edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
              vFrame.
              getTopValue(
                );
            edu.umd.cs.findbugs.BugAnnotation valueSource =
              edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
              findAnnotationFromValueNumber(
                method,
                location,
                valueNumber,
                vFrame,
                "VALUE_OF");
            edu.umd.cs.findbugs.BugAnnotation source =
              edu.umd.cs.findbugs.BugInstance.
              getSourceForTopStackValue(
                classContext,
                method,
                location);
            boolean isParameter =
              paramValueNumberSet.
              contains(
                valueNumber) &&
              source instanceof edu.umd.cs.findbugs.LocalVariableAnnotation;
            try {
                org.apache.bcel.classfile.JavaClass castJavaClass =
                  org.apache.bcel.Repository.
                  lookupClass(
                    castName);
                org.apache.bcel.classfile.JavaClass refJavaClass =
                  org.apache.bcel.Repository.
                  lookupClass(
                    refName);
                boolean upcast =
                  org.apache.bcel.Repository.
                  instanceOf(
                    refJavaClass,
                    castJavaClass);
                if (upcast ||
                      typesAreEqual) {
                    if (!isCast) {
                        accumulator.
                          accumulateBug(
                            new edu.umd.cs.findbugs.BugInstance(
                              this,
                              "BC_VACUOUS_INSTANCEOF",
                              NORMAL_PRIORITY).
                              addClassAndMethod(
                                methodGen,
                                sourceFile).
                              addFoundAndExpectedType(
                                refType,
                                castType),
                            sourceLineAnnotation);
                    }
                }
                else {
                    boolean castMayThrow =
                      !org.apache.bcel.Repository.
                      instanceOf(
                        refJavaClass,
                        castJavaClass);
                    boolean downCast =
                      org.apache.bcel.Repository.
                      instanceOf(
                        castJavaClass,
                        refJavaClass);
                    if (!operandTypeIsExact &&
                          "java.lang.Object".
                          equals(
                            refName)) {
                        continue;
                    }
                    double rank =
                      0.0;
                    boolean castToConcreteCollection =
                      concreteCollectionClasses.
                      contains(
                        castName) &&
                      abstractCollectionClasses.
                      contains(
                        refName);
                    boolean castToAbstractCollection =
                      abstractCollectionClasses.
                      contains(
                        castName) &&
                      veryAbstractCollectionClasses.
                      contains(
                        refName);
                    int position =
                      location.
                      getHandle(
                        ).
                      getPosition(
                        );
                    int catchSize =
                      edu.umd.cs.findbugs.visitclass.Util.
                      getSizeOfSurroundingTryBlock(
                        classContext.
                          getJavaClass(
                            ).
                          getConstantPool(
                            ),
                        method.
                          getCode(
                            ),
                        "java/lang/ClassCastException",
                        position);
                    if (!operandTypeIsExact) {
                        rank =
                          edu.umd.cs.findbugs.Analyze.
                            deepInstanceOf(
                              refJavaClass,
                              castJavaClass);
                        if (castToConcreteCollection &&
                              rank >
                              0.6) {
                            rank =
                              (rank +
                                 0.6) /
                                2;
                        }
                        else
                            if (castToAbstractCollection &&
                                  rank >
                                  0.3) {
                                rank =
                                  (rank +
                                     0.3) /
                                    2;
                            }
                    }
                    boolean completeInformation =
                      !castJavaClass.
                      isInterface(
                        ) &&
                      !refJavaClass.
                      isInterface(
                        ) ||
                      refJavaClass.
                      isFinal(
                        ) ||
                      castJavaClass.
                      isFinal(
                        );
                    if (DEBUG) {
                        java.lang.System.
                          out.
                          println(
                            " In " +
                            classContext.
                              getFullyQualifiedMethodName(
                                method));
                        java.lang.System.
                          out.
                          println(
                            "At pc: " +
                            handle.
                              getPosition(
                                ));
                        java.lang.System.
                          out.
                          println(
                            "cast from " +
                            refName +
                            " to " +
                            castName);
                        java.lang.System.
                          out.
                          println(
                            "  cast may throw: " +
                            castMayThrow);
                        java.lang.System.
                          out.
                          println(
                            "  is downcast: " +
                            downCast);
                        java.lang.System.
                          out.
                          println(
                            "  operand type is exact: " +
                            operandTypeIsExact);
                        java.lang.System.
                          out.
                          println(
                            "  complete information: " +
                            completeInformation);
                        java.lang.System.
                          out.
                          println(
                            "  isParameter: " +
                            valueNumber);
                        java.lang.System.
                          out.
                          println(
                            "  score: " +
                            rank);
                        java.lang.System.
                          out.
                          println(
                            "  source is: " +
                            valueSource);
                        if (catchSize <
                              java.lang.Integer.
                                MAX_VALUE) {
                            java.lang.System.
                              out.
                              println(
                                "  catch block size is: " +
                                catchSize);
                        }
                        if (constantClass !=
                              null) {
                            java.lang.System.
                              out.
                              println(
                                "  constant class " +
                                constantClass +
                                " at " +
                                pcForConstantClass);
                        }
                        if (handle.
                              getPrev(
                                ) ==
                              null) {
                            java.lang.System.
                              out.
                              println(
                                "  prev is null");
                        }
                        else {
                            java.lang.System.
                              out.
                              println(
                                "  prev is " +
                                handle.
                                  getPrev(
                                    ));
                        }
                    }
                    if (!isCast &&
                          castMayThrow &&
                          valueSource !=
                          null) {
                        java.lang.String oldCheck =
                          instanceOfChecks.
                          get(
                            valueSource);
                        if (oldCheck ==
                              null) {
                            instanceOfChecks.
                              put(
                                valueSource,
                                castName);
                        }
                        else
                            if (!oldCheck.
                                  equals(
                                    castName)) {
                                instanceOfChecks.
                                  put(
                                    valueSource,
                                    "");
                            }
                    }
                    if (!downCast &&
                          completeInformation ||
                          operandTypeIsExact) {
                        java.lang.String bugPattern;
                        if (isCast) {
                            if (downCast &&
                                  operandTypeIsExact) {
                                if ("[Ljava/lang/Object;".
                                      equals(
                                        refSig) &&
                                      source instanceof edu.umd.cs.findbugs.MethodAnnotation &&
                                      "toArray".
                                      equals(
                                        ((edu.umd.cs.findbugs.MethodAnnotation)
                                           source).
                                          getMethodName(
                                            )) &&
                                      "()[Ljava/lang/Object;".
                                      equals(
                                        ((edu.umd.cs.findbugs.MethodAnnotation)
                                           source).
                                          getMethodSignature(
                                            ))) {
                                    bugPattern =
                                      "BC_IMPOSSIBLE_DOWNCAST_OF_TOARRAY";
                                }
                                else {
                                    bugPattern =
                                      "BC_IMPOSSIBLE_DOWNCAST";
                                }
                            }
                            else {
                                bugPattern =
                                  "BC_IMPOSSIBLE_CAST";
                            }
                        }
                        else {
                            bugPattern =
                              "BC_IMPOSSIBLE_INSTANCEOF";
                        }
                        bugReporter.
                          reportBug(
                            new edu.umd.cs.findbugs.BugInstance(
                              this,
                              bugPattern,
                              isCast
                                ? HIGH_PRIORITY
                                : NORMAL_PRIORITY).
                              addClassAndMethod(
                                methodGen,
                                sourceFile).
                              addFoundAndExpectedType(
                                refType,
                                castType).
                              addOptionalUniqueAnnotations(
                                valueSource,
                                source).
                              addSourceLine(
                                sourceLineAnnotation));
                    }
                    else
                        if (isCast &&
                              rank <
                              0.9 &&
                              !valueNumber.
                              hasFlag(
                                edu.umd.cs.findbugs.ba.vna.ValueNumber.
                                  ARRAY_VALUE)) {
                            int priority =
                              NORMAL_PRIORITY;
                            java.lang.String oldCheck =
                              instanceOfChecks.
                              get(
                                valueSource);
                            if (DEBUG) {
                                java.lang.System.
                                  out.
                                  println(
                                    "Old check: " +
                                    oldCheck);
                            }
                            if (castName.
                                  equals(
                                    oldCheck)) {
                                priority +=
                                  1;
                            }
                            else
                                if ("".
                                      equals(
                                        oldCheck)) {
                                    priority +=
                                      1;
                                    if (!(source instanceof edu.umd.cs.findbugs.LocalVariableAnnotation)) {
                                        continue;
                                    }
                                }
                            if (rank >
                                  0.75) {
                                priority +=
                                  2;
                            }
                            else
                                if (rank >
                                      0.5) {
                                    priority +=
                                      1;
                                }
                                else
                                    if (rank >
                                          0.25) {
                                        priority +=
                                          0;
                                    }
                                    else {
                                        priority--;
                                    }
                            if (DEBUG) {
                                java.lang.System.
                                  out.
                                  println(
                                    " priority a: " +
                                    priority);
                            }
                            if (methodGen.
                                  getClassName(
                                    ).
                                  startsWith(
                                    refName) ||
                                  methodGen.
                                  getClassName(
                                    ).
                                  startsWith(
                                    castName)) {
                                priority +=
                                  1;
                            }
                            if (DEBUG) {
                                java.lang.System.
                                  out.
                                  println(
                                    " priority b: " +
                                    priority);
                            }
                            if (castJavaClass.
                                  isInterface(
                                    ) &&
                                  !castToAbstractCollection) {
                                priority++;
                            }
                            if (DEBUG) {
                                java.lang.System.
                                  out.
                                  println(
                                    " priority c: " +
                                    priority);
                            }
                            if (castToConcreteCollection &&
                                  veryAbstractCollectionClasses.
                                  contains(
                                    refName)) {
                                priority--;
                            }
                            if (DEBUG) {
                                java.lang.System.
                                  out.
                                  println(
                                    " priority d: " +
                                    priority);
                            }
                            if (priority <=
                                  LOW_PRIORITY &&
                                  !castToAbstractCollection &&
                                  !castToConcreteCollection &&
                                  (refJavaClass.
                                     isInterface(
                                       ) ||
                                     refJavaClass.
                                     isAbstract(
                                       ))) {
                                priority++;
                            }
                            if (DEBUG) {
                                java.lang.System.
                                  out.
                                  println(
                                    " priority e: " +
                                    priority);
                            }
                            if (DEBUG) {
                                java.lang.System.
                                  out.
                                  println(
                                    " ref name: " +
                                    refName);
                            }
                            if ("compareTo".
                                  equals(
                                    methodGen.
                                      getName(
                                        ))) {
                                priority++;
                            }
                            else
                                if (methodGen.
                                      isPublic(
                                        ) &&
                                      isParameter &&
                                      !castName.
                                      equals(
                                        oldCheck)) {
                                    priority--;
                                }
                            if (wasMethodInvocationWasGeneric &&
                                  valueNumber.
                                  hasFlag(
                                    edu.umd.cs.findbugs.ba.vna.ValueNumber.
                                      RETURN_VALUE)) {
                                continue;
                            }
                            if (constantClass !=
                                  null &&
                                  pcForConstantClass +
                                  20 >=
                                  pc &&
                                  valueNumber.
                                  hasFlag(
                                    edu.umd.cs.findbugs.ba.vna.ValueNumber.
                                      RETURN_VALUE) &&
                                  edu.umd.cs.findbugs.util.ClassName.
                                  toDottedClassName(
                                    constantClass).
                                  equals(
                                    castName)) {
                                priority +=
                                  2;
                            }
                            if (DEBUG) {
                                java.lang.System.
                                  out.
                                  println(
                                    " priority f: " +
                                    priority);
                            }
                            if (source instanceof edu.umd.cs.findbugs.MethodAnnotation) {
                                edu.umd.cs.findbugs.MethodAnnotation m =
                                  (edu.umd.cs.findbugs.MethodAnnotation)
                                    source;
                                edu.umd.cs.findbugs.ba.XMethod xm =
                                  m.
                                  toXMethod(
                                    );
                                if (xm !=
                                      null &&
                                      (xm.
                                         isPrivate(
                                           ) ||
                                         xm.
                                         isStatic(
                                           )) &&
                                      priority ==
                                      edu.umd.cs.findbugs.Priorities.
                                        LOW_PRIORITY) {
                                    continue;
                                }
                            }
                            if (valueNumber.
                                  hasFlag(
                                    edu.umd.cs.findbugs.ba.vna.ValueNumber.
                                      RETURN_VALUE) &&
                                  priority <
                                  edu.umd.cs.findbugs.Priorities.
                                    LOW_PRIORITY) {
                                priority =
                                  edu.umd.cs.findbugs.Priorities.
                                    LOW_PRIORITY;
                            }
                            if (DEBUG) {
                                java.lang.System.
                                  out.
                                  println(
                                    " priority g: " +
                                    priority);
                            }
                            if (DEBUG) {
                                java.lang.System.
                                  out.
                                  println(
                                    " priority h: " +
                                    priority);
                            }
                            if (catchSize <
                                  15) {
                                return;
                            }
                            if (catchSize <
                                  25) {
                                priority++;
                            }
                            if (DEBUG) {
                                java.lang.System.
                                  out.
                                  println(
                                    " priority i: " +
                                    priority);
                            }
                            if (priority <
                                  HIGH_PRIORITY) {
                                priority =
                                  HIGH_PRIORITY;
                            }
                            if (priority <=
                                  LOW_PRIORITY) {
                                java.lang.String bug =
                                  "BC_UNCONFIRMED_CAST";
                                if (valueNumber.
                                      hasFlag(
                                        edu.umd.cs.findbugs.ba.vna.ValueNumber.
                                          RETURN_VALUE) ||
                                      valueSource instanceof edu.umd.cs.findbugs.MethodAnnotation) {
                                    bug =
                                      "BC_UNCONFIRMED_CAST_OF_RETURN_VALUE";
                                }
                                else
                                    if (castToConcreteCollection) {
                                        bug =
                                          "BC_BAD_CAST_TO_CONCRETE_COLLECTION";
                                    }
                                    else
                                        if (castToAbstractCollection) {
                                            bug =
                                              "BC_BAD_CAST_TO_ABSTRACT_COLLECTION";
                                        }
                                edu.umd.cs.findbugs.BugInstance bugInstance =
                                  new edu.umd.cs.findbugs.BugInstance(
                                  this,
                                  bug,
                                  priority).
                                  addClassAndMethod(
                                    methodGen,
                                    sourceFile).
                                  addFoundAndExpectedType(
                                    refType,
                                    castType).
                                  addOptionalAnnotation(
                                    valueSource);
                                accumulator.
                                  accumulateBug(
                                    bugInstance,
                                    sourceLineAnnotation);
                            }
                        }
                }
            }
            catch (java.lang.ClassNotFoundException e) {
                if (DEBUG) {
                    e.
                      printStackTrace(
                        java.lang.System.
                          out);
                }
                if (isCast &&
                      "[Ljava/lang/Object;".
                      equals(
                        refSig) &&
                      source instanceof edu.umd.cs.findbugs.MethodAnnotation &&
                      "toArray".
                      equals(
                        ((edu.umd.cs.findbugs.MethodAnnotation)
                           source).
                          getMethodName(
                            )) &&
                      "()[Ljava/lang/Object;".
                      equals(
                        ((edu.umd.cs.findbugs.MethodAnnotation)
                           source).
                          getMethodSignature(
                            ))) {
                    bugReporter.
                      reportBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "BC_IMPOSSIBLE_DOWNCAST_OF_TOARRAY",
                          HIGH_PRIORITY).
                          addClassAndMethod(
                            methodGen,
                            sourceFile).
                          addFoundAndExpectedType(
                            refType,
                            castType).
                          addOptionalUniqueAnnotations(
                            valueSource,
                            source).
                          addSourceLine(
                            sourceLineAnnotation));
                }
            }
        }
        accumulator.
          reportAccumulatedBugs(
            );
    }
    @java.lang.Override
    public void report() {  }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Cn2Tv+Lbiv8C46YnvMslAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dE6d6J46lT/+SP7k7T6Sd8vbK35YHJI+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ddFtq/KA9NMvvfqazv0CfPnwnP9vx5V7Yj94v2NsDefUfHe+8ec6trxsdvIp" +
       "99df+sMnxB+xPvw2LrK86xyf54f8R+xnvki+T/vZy5Urxx92b7kGd5bohXOf" +
       "dEIjBjtt8cxH3afOXib5AHj0Q/Xr5w/UTwx8i6tcKl1l7yDnbiScu9XwntsZ" +
       "TFX2djm8iViO88/f4GbD54viV4Enll8ET5Pe9hx169v6iWN+7qxj3n/smMc8" +
       "Xj/1rWhrhKGtG2/gy7fePygr/vGxZh8pKp8Ez4uHmn3xL0azl08+vPzaEevP" +
       "+OHyQAkUzTIOVM1w9p/gimtyhx5VjvSlN9Dtl4viCyAOgtCItNAwyi8AL5/o" +
       "74tvdgT9Bqp4qqhEwfPSoSpeeruq6N1WFVdOAOvXiuK3jvTxxEXu1ifLgf7z" +
       "7XV6RF67gLyrxIrp+CnmKU4e2VEv04zgOMIB4fMXz4sndnEp75ik5ONrRfE7" +
       "ceXxpRGXwAAgLCzvduw/Qey//U6KYloSzMqirF1c9MW6qFaOOHrfBRxtPeXg" +
       "1ETnPn6emP13vw+z319UFh8UXzk0+yt/MWY/HQGl2ctef3Jxr98viq+Xvb5d" +
       "FP8jrjygFDbcGfvwKCr/1YnQ//P7ELoE1MfBxP6edv/7+w/708H63YvbLpVD" +
       "/FlcuSssr8eck+w7F6JgUf1v3xbeZXHl/tNXRYt7b4/fchd9f39a++XXrt39" +
       "2GvT3y1vSx7fcb5nWLnbTBzn9PWjU+93ATAy7VLke/aXkYJSxnsuiPD9/VUg" +
       "+/6l4PjS3XuS++PKI7chicH8h6+ne1+LK/ee9I4rl7UzzdfjytXD5rhyBZSn" +
       "G0HQXQGNxeujpcXt7NIFwXX9zfzsmOT01crzV1vYZP+/ATe1z77GjH70W81f" +
       "2F/tBGvAbleMcvewcnV/y/Q473j2wtGOxrqLeu47D/7KPe89ypEe3DN84ryn" +
       "eHvX7e9R9twgLm8+7v7ZY7/6gX/w2lfLL6n/D2HobluyMQAA");
}
