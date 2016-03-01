package edu.umd.cs.findbugs.ba.npe;
public class DerefFinder {
    public static boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.getBoolean(
                                                                         "deref.finder.debug");
    public static edu.umd.cs.findbugs.ba.npe.UsagesRequiringNonNullValues getAnalysis(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                                                                      org.apache.bcel.classfile.Method method) {
        edu.umd.cs.findbugs.ba.XMethod thisMethod =
          classContext.
          getXClass(
            ).
          findMethod(
            method.
              getName(
                ),
            method.
              getSignature(
                ),
            method.
              isStatic(
                ));
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                thisMethod);
        }
        edu.umd.cs.findbugs.ba.npe.UsagesRequiringNonNullValues derefs =
          new edu.umd.cs.findbugs.ba.npe.UsagesRequiringNonNullValues(
          );
        try {
            edu.umd.cs.findbugs.ba.CFG cfg =
              classContext.
              getCFG(
                method);
            edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow vna =
              classContext.
              getValueNumberDataflow(
                method);
            edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow =
              classContext.
              getTypeDataflow(
                method);
            edu.umd.cs.findbugs.ba.INullnessAnnotationDatabase db =
              edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getNullnessAnnotationDatabase(
                );
            edu.umd.cs.findbugs.ba.npe.ParameterNullnessPropertyDatabase unconditionalDerefParamDatabase =
              edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getUnconditionalDerefParamDatabase(
                );
            java.util.Iterator<edu.umd.cs.findbugs.ba.BasicBlock> bbIter =
              cfg.
              blockIterator(
                );
            org.apache.bcel.generic.ConstantPoolGen cpg =
              classContext.
              getConstantPoolGen(
                );
            edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumberForThis =
              null;
            if (!method.
                  isStatic(
                    )) {
                edu.umd.cs.findbugs.ba.vna.ValueNumberFrame frameAtEntry =
                  vna.
                  getStartFact(
                    cfg.
                      getEntry(
                        ));
                valueNumberForThis =
                  frameAtEntry.
                    getValue(
                      0);
            }
            edu.umd.cs.findbugs.ba.NullnessAnnotation methodAnnotation =
              getMethodNullnessAnnotation(
                classContext,
                method);
            while (bbIter.
                     hasNext(
                       )) {
                edu.umd.cs.findbugs.ba.BasicBlock basicBlock =
                  bbIter.
                  next(
                    );
                if (basicBlock.
                      isNullCheck(
                        )) {
                    org.apache.bcel.generic.InstructionHandle exceptionThrowerHandle =
                      basicBlock.
                      getExceptionThrower(
                        );
                    org.apache.bcel.generic.Instruction exceptionThrower =
                      exceptionThrowerHandle.
                      getInstruction(
                        );
                    edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
                      vna.
                      getStartFact(
                        basicBlock);
                    if (!vnaFrame.
                          isValid(
                            )) {
                        continue;
                    }
                    edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
                      vnaFrame.
                      getInstance(
                        exceptionThrower,
                        cpg);
                    edu.umd.cs.findbugs.ba.Location location =
                      new edu.umd.cs.findbugs.ba.Location(
                      exceptionThrowerHandle,
                      basicBlock);
                    if (valueNumberForThis !=
                          valueNumber) {
                        derefs.
                          add(
                            location,
                            valueNumber,
                            edu.umd.cs.findbugs.ba.npe.PointerUsageRequiringNonNullValue.
                              getPointerDereference(
                                ));
                    }
                }
            }
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
                edu.umd.cs.findbugs.ba.vna.ValueNumberFrame valueNumberFrame =
                  vna.
                  getFactAtLocation(
                    location);
                edu.umd.cs.findbugs.ba.type.TypeFrame typeFrame =
                  typeDataflow.
                  getFactAtLocation(
                    location);
                if (ins instanceof org.apache.bcel.generic.InvokeInstruction) {
                    org.apache.bcel.generic.InvokeInstruction inv =
                      (org.apache.bcel.generic.InvokeInstruction)
                        ins;
                    edu.umd.cs.findbugs.ba.XMethod m =
                      edu.umd.cs.findbugs.ba.XFactory.
                      createXMethod(
                        inv,
                        cpg);
                    edu.umd.cs.findbugs.ba.SignatureParser sigParser =
                      new edu.umd.cs.findbugs.ba.SignatureParser(
                      m.
                        getSignature(
                          ));
                    int numParams =
                      sigParser.
                      getNumParameters(
                        );
                    for (int j =
                           0;
                         j <
                           numParams;
                         j++) {
                        if (db.
                              parameterMustBeNonNull(
                                m,
                                j)) {
                            int slot =
                              sigParser.
                              getSlotsFromTopOfStackForParameter(
                                j);
                            edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
                              valueNumberFrame.
                              getStackValue(
                                slot);
                            if (valueNumberForThis !=
                                  valueNumber) {
                                derefs.
                                  add(
                                    location,
                                    valueNumber,
                                    edu.umd.cs.findbugs.ba.npe.PointerUsageRequiringNonNullValue.
                                      getPassedAsNonNullParameter(
                                        m,
                                        j));
                            }
                        }
                    }
                    try {
                        java.util.Set<edu.umd.cs.findbugs.ba.JavaClassAndMethod> targetMethodSet =
                          edu.umd.cs.findbugs.ba.Hierarchy.
                          resolveMethodCallTargets(
                            inv,
                            typeFrame,
                            cpg);
                        java.util.BitSet unconditionallyDereferencedNullArgSet =
                          null;
                        for (edu.umd.cs.findbugs.ba.JavaClassAndMethod targetMethod
                              :
                              targetMethodSet) {
                            edu.umd.cs.findbugs.ba.interproc.ParameterProperty property =
                              unconditionalDerefParamDatabase.
                              getProperty(
                                targetMethod.
                                  toMethodDescriptor(
                                    ));
                            if (property ==
                                  null) {
                                unconditionallyDereferencedNullArgSet =
                                  null;
                                break;
                            }
                            java.util.BitSet foo =
                              property.
                              getAsBitSet(
                                );
                            if (unconditionallyDereferencedNullArgSet ==
                                  null) {
                                unconditionallyDereferencedNullArgSet =
                                  foo;
                            }
                            else {
                                unconditionallyDereferencedNullArgSet.
                                  and(
                                    foo);
                            }
                            if (unconditionallyDereferencedNullArgSet.
                                  isEmpty(
                                    )) {
                                break;
                            }
                        }
                        if (unconditionallyDereferencedNullArgSet !=
                              null &&
                              !unconditionallyDereferencedNullArgSet.
                              isEmpty(
                                ) &&
                              valueNumberFrame.
                              isValid(
                                )) {
                            for (int j =
                                   unconditionallyDereferencedNullArgSet.
                                   nextSetBit(
                                     0);
                                 j >=
                                   0;
                                 j =
                                   unconditionallyDereferencedNullArgSet.
                                     nextSetBit(
                                       j +
                                         1)) {
                                int slot =
                                  sigParser.
                                  getSlotsFromTopOfStackForParameter(
                                    j);
                                edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
                                  valueNumberFrame.
                                  getStackValue(
                                    slot);
                                if (valueNumberForThis !=
                                      valueNumber) {
                                    derefs.
                                      add(
                                        location,
                                        valueNumber,
                                        edu.umd.cs.findbugs.ba.npe.PointerUsageRequiringNonNullValue.
                                          getPassedAsNonNullParameter(
                                            m,
                                            j));
                                }
                            }
                        }
                    }
                    catch (java.lang.ClassNotFoundException e) {
                        edu.umd.cs.findbugs.ba.AnalysisContext.
                          reportMissingClass(
                            e);
                    }
                }
                else
                    if (ins instanceof org.apache.bcel.generic.IFNONNULL &&
                          edu.umd.cs.findbugs.ba.deref.UnconditionalValueDerefAnalysis.
                          isNullCheck(
                            handle,
                            cpg)) {
                        edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
                          valueNumberFrame.
                          getTopValue(
                            );
                        derefs.
                          add(
                            location,
                            valueNumber,
                            edu.umd.cs.findbugs.ba.npe.PointerUsageRequiringNonNullValue.
                              getPointerNullChecked(
                                ));
                    }
                    else
                        if (ins instanceof org.apache.bcel.generic.ARETURN &&
                              methodAnnotation ==
                              edu.umd.cs.findbugs.ba.NullnessAnnotation.
                                NONNULL) {
                            edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
                              valueNumberFrame.
                              getTopValue(
                                );
                            if (valueNumberForThis !=
                                  valueNumber) {
                                derefs.
                                  add(
                                    location,
                                    valueNumber,
                                    edu.umd.cs.findbugs.ba.npe.PointerUsageRequiringNonNullValue.
                                      getReturnFromNonNullMethod(
                                        thisMethod));
                            }
                        }
                        else
                            if (ins instanceof org.apache.bcel.generic.PUTFIELD ||
                                  ins instanceof org.apache.bcel.generic.PUTSTATIC) {
                                org.apache.bcel.generic.FieldInstruction inf =
                                  (org.apache.bcel.generic.FieldInstruction)
                                    ins;
                                edu.umd.cs.findbugs.ba.XField field =
                                  edu.umd.cs.findbugs.ba.XFactory.
                                  createXField(
                                    inf,
                                    cpg);
                                edu.umd.cs.findbugs.ba.NullnessAnnotation annotation =
                                  edu.umd.cs.findbugs.ba.AnalysisContext.
                                  currentAnalysisContext(
                                    ).
                                  getNullnessAnnotationDatabase(
                                    ).
                                  getResolvedAnnotation(
                                    field,
                                    false);
                                if (annotation ==
                                      edu.umd.cs.findbugs.ba.NullnessAnnotation.
                                        NONNULL) {
                                    edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
                                      valueNumberFrame.
                                      getTopValue(
                                        );
                                    if (valueNumberForThis !=
                                          valueNumber) {
                                        derefs.
                                          add(
                                            location,
                                            valueNumber,
                                            edu.umd.cs.findbugs.ba.npe.PointerUsageRequiringNonNullValue.
                                              getStoredIntoNonNullField(
                                                field));
                                    }
                                }
                            }
            }
        }
        catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Error generating derefs for " +
                thisMethod,
                e);
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Error generating derefs for " +
                thisMethod,
                e);
        }
        return derefs;
    }
    public static edu.umd.cs.findbugs.ba.NullnessAnnotation getMethodNullnessAnnotation(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                                                                        org.apache.bcel.classfile.Method method) {
        if (method.
              getSignature(
                ).
              indexOf(
                ")L") >=
              0 ||
              method.
              getSignature(
                ).
              indexOf(
                ")[") >=
              0) {
            edu.umd.cs.findbugs.ba.XMethod m =
              edu.umd.cs.findbugs.ba.XFactory.
              createXMethod(
                classContext.
                  getJavaClass(
                    ),
                method);
            return edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getNullnessAnnotationDatabase(
                ).
              getResolvedAnnotation(
                m,
                false);
        }
        return edu.umd.cs.findbugs.ba.NullnessAnnotation.
                 UNKNOWN_NULLNESS;
    }
    public DerefFinder() { super(); }
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
