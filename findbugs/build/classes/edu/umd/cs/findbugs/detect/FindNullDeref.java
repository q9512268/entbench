package edu.umd.cs.findbugs.detect;
public class FindNullDeref implements edu.umd.cs.findbugs.Detector, edu.umd.cs.findbugs.UseAnnotationDatabase, edu.umd.cs.findbugs.ba.npe.NullDerefAndRedundantComparisonCollector {
    public static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fnd.debug");
    private static final boolean DEBUG_NULLARG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fnd.debug.nullarg");
    private static final boolean DEBUG_NULLRETURN = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fnd.debug.nullreturn");
    private static final boolean MARK_DOOMED = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fnd.markdoomed",
        true);
    private static final java.lang.String METHOD =
      edu.umd.cs.findbugs.SystemProperties.
      getProperty(
        "fnd.method");
    private static final java.lang.String CLASS =
      edu.umd.cs.findbugs.SystemProperties.
      getProperty(
        "fnd.class");
    private final edu.umd.cs.findbugs.BugReporter
      bugReporter;
    private final edu.umd.cs.findbugs.BugAccumulator
      bugAccumulator;
    private edu.umd.cs.findbugs.ba.npe.ParameterNullnessPropertyDatabase
      unconditionalDerefParamDatabase;
    private boolean checkedDatabases = false;
    private edu.umd.cs.findbugs.ba.ClassContext classContext;
    private org.apache.bcel.classfile.Method method;
    private edu.umd.cs.findbugs.ba.npe.IsNullValueDataflow
      invDataflow;
    private edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow
      vnaDataflow;
    private java.util.BitSet previouslyDeadBlocks;
    private edu.umd.cs.findbugs.ba.NullnessAnnotation
      methodAnnotation;
    public FindNullDeref(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        this.
          classContext =
          classContext;
        java.lang.String currentMethod =
          null;
        org.apache.bcel.classfile.JavaClass jclass =
          classContext.
          getJavaClass(
            );
        java.lang.String className =
          jclass.
          getClassName(
            );
        if (CLASS !=
              null &&
              !className.
              equals(
                CLASS)) {
            return;
        }
        java.util.List<org.apache.bcel.classfile.Method> methodsInCallOrder =
          classContext.
          getMethodsInCallOrder(
            );
        for (org.apache.bcel.classfile.Method method
              :
              methodsInCallOrder) {
            try {
                if (method.
                      isAbstract(
                        ) ||
                      method.
                      isNative(
                        ) ||
                      method.
                      getCode(
                        ) ==
                      null) {
                    continue;
                }
                currentMethod =
                  edu.umd.cs.findbugs.ba.SignatureConverter.
                    convertMethodSignature(
                      jclass,
                      method);
                if (METHOD !=
                      null &&
                      !method.
                      getName(
                        ).
                      equals(
                        METHOD)) {
                    continue;
                }
                if (DEBUG ||
                      DEBUG_NULLARG) {
                    java.lang.System.
                      out.
                      println(
                        "Checking for NP in " +
                        currentMethod);
                }
                analyzeMethod(
                  classContext,
                  method);
            }
            catch (edu.umd.cs.findbugs.ba.MissingClassException e) {
                bugReporter.
                  reportMissingClass(
                    e.
                      getClassNotFoundException(
                        ));
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                bugReporter.
                  logError(
                    "While analyzing " +
                    currentMethod +
                    ": FindNullDeref caught dae exception",
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                bugReporter.
                  logError(
                    "While analyzing " +
                    currentMethod +
                    ": FindNullDeref caught cfgb exception",
                    e);
            }
            bugAccumulator.
              reportAccumulatedBugs(
                );
        }
    }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        edu.umd.cs.findbugs.ba.CFGBuilderException {
        if (DEBUG ||
              DEBUG_NULLARG) {
            java.lang.System.
              out.
              println(
                "Pre FND ");
        }
        if ((method.
               getAccessFlags(
                 ) &
               org.apache.bcel.Constants.
                 ACC_BRIDGE) !=
              0) {
            return;
        }
        org.apache.bcel.generic.MethodGen methodGen =
          classContext.
          getMethodGen(
            method);
        if (methodGen ==
              null) {
            return;
        }
        if (!checkedDatabases) {
            checkDatabases(
              );
            checkedDatabases =
              true;
        }
        edu.umd.cs.findbugs.ba.XMethod xMethod =
          edu.umd.cs.findbugs.ba.XFactory.
          createXMethod(
            classContext.
              getJavaClass(
                ),
            method);
        edu.umd.cs.findbugs.classfile.ClassDescriptor junitTestAnnotation =
          edu.umd.cs.findbugs.classfile.DescriptorFactory.
          createClassDescriptor(
            "org/junit/Test");
        edu.umd.cs.findbugs.classfile.analysis.AnnotationValue av =
          xMethod.
          getAnnotation(
            junitTestAnnotation);
        if (av !=
              null) {
            java.lang.Object value =
              av.
              getValue(
                "expected");
            if (value instanceof org.objectweb.asm.Type) {
                java.lang.String className =
                  ((org.objectweb.asm.Type)
                     value).
                  getClassName(
                    );
                if ("java.lang.NullPointerException".
                      equals(
                        className)) {
                    return;
                }
            }
        }
        this.
          method =
          method;
        this.
          methodAnnotation =
          getMethodNullnessAnnotation(
            );
        if (DEBUG ||
              DEBUG_NULLARG) {
            java.lang.System.
              out.
              println(
                "FND: " +
                edu.umd.cs.findbugs.ba.SignatureConverter.
                  convertMethodSignature(
                    methodGen));
        }
        this.
          previouslyDeadBlocks =
          findPreviouslyDeadBlocks(
            );
        invDataflow =
          classContext.
            getIsNullValueDataflow(
              method);
        vnaDataflow =
          classContext.
            getValueNumberDataflow(
              method);
        edu.umd.cs.findbugs.ba.npe.NullDerefAndRedundantComparisonFinder worker =
          new edu.umd.cs.findbugs.ba.npe.NullDerefAndRedundantComparisonFinder(
          classContext,
          method,
          this);
        worker.
          execute(
            );
        checkCallSitesAndReturnInstructions(
          );
    }
    private java.util.BitSet findPreviouslyDeadBlocks()
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        edu.umd.cs.findbugs.ba.CFGBuilderException {
        java.util.BitSet deadBlocks =
          new java.util.BitSet(
          );
        edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow vnaDataflow =
          classContext.
          getValueNumberDataflow(
            method);
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.BasicBlock> i =
               vnaDataflow.
               getCFG(
                 ).
               blockIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.BasicBlock block =
              i.
              next(
                );
            edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
              vnaDataflow.
              getStartFact(
                block);
            if (vnaFrame.
                  isTop(
                    )) {
                deadBlocks.
                  set(
                    block.
                      getLabel(
                        ));
            }
        }
        return deadBlocks;
    }
    private void checkDatabases() { edu.umd.cs.findbugs.ba.AnalysisContext analysisContext =
                                      edu.umd.cs.findbugs.ba.AnalysisContext.
                                      currentAnalysisContext(
                                        );
                                    unconditionalDerefParamDatabase =
                                      analysisContext.
                                        getUnconditionalDerefParamDatabase(
                                          );
    }
    private edu.umd.cs.findbugs.ba.NullnessAnnotation getMethodNullnessAnnotation() {
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
            if (DEBUG_NULLRETURN) {
                java.lang.System.
                  out.
                  println(
                    "Checking return annotation for " +
                    edu.umd.cs.findbugs.ba.SignatureConverter.
                      convertMethodSignature(
                        classContext.
                          getJavaClass(
                            ),
                        method));
            }
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
    static class CheckCallSitesAndReturnInstructions {
        public CheckCallSitesAndReturnInstructions() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/VUBvQkFkeIvk9yonIrB+w+Jb8GJSBEAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Xixr65Gj1wXdoUpSAfPWZKNbXiEjawKbviR31UGLGOdWLbEH3sNmYJhM3DPA" +
           "G0YfTZqd9rrsdFrIjA5qnUBazHIaP2yImIsPRTJnU3BgwYzmdRazUJ2tBIUv" +
           "q5LbNxLHwQnfdjW4KKkSSwRlrT0TKmwzmJc4bdgY2aNknfckK4pLxhxWbL6f" +
           "E4u40MMRKhyYHh1ODJQXBXStNLptuBOwjSiGw1arHOCJVMo7YoWftAWSpFE6" +
           "EuYDukDgfH8+d9d0Dc11So2F3xibPk7J7HiNd2Glx1eCWakv1zlcMVklarl4" +
           "vjMurisIZUeO7M+rAx0hSoW5PCrTts4WqlKHdzHwTjDg/rwwG9Iu4Y+MJHJr" +
           "OI5HUm44UKQiaRWLibjutbqkzvboUo5v+t1y3a0JVW6o02CjKozcCkNy7Xc9" +
           "8AoOSuNhzqXhcttG2VWFc4mZtlqM28SMV2N2tXL4abFWqQShUDcwQiE5eLks" +
           "L0GNJthjXAniYhkLBbs2Xkw009DYMjIc1KLuorlQqGiBrxyb8mpwDNOzCkkL" +
           "tQYoUJ96Ki1dP/KTnR7uzg5KB/fc4NCQTpA/QdWc3HzBE9laycF1UXZwPv8e" +
           "10WHjtRQejZ4+FYX2tm54NVPXX9F5r6Q29m7ihiBo+De7wyH5YBTyY9xu7h/" +
           "KvzAj3tlCdR74IZfRTY3+dKXX7lw9v5XBn+dXcgd3LafY6GzKmA/fPo91D/t" +
           "Aql6Zsm5zVnYzf454Hx3a6WAzZtOZoC9YfEC6J6bsARg/b3uYeowgM5vqQNo" +
           "RzoyDRx4Zm86gE6C9vDkM2AITKbdj7s3OVlvrgmSE0d39iCoLv2oo9ihYHjy" +
           "yDE2+91qz+/tcPPL1TXp9VfozjPvlL6wuVGUTHG9zn7nYKEzm8vNg3vbx28p" +
           "bV/W6daVd+9649z798Prro3C27Q4pNujN7+ya1hukF2yrX///t/98G+98u3s" +
           "oP+/OojUsFAcAAA=");
    }
    private void checkCallSitesAndReturnInstructions() {
        edu.umd.cs.findbugs.log.Profiler profiler =
          edu.umd.cs.findbugs.classfile.Global.
          getAnalysisCache(
            ).
          getProfiler(
            );
        profiler.
          start(
            edu.umd.cs.findbugs.detect.FindNullDeref.CheckCallSitesAndReturnInstructions.class);
        try {
            org.apache.bcel.generic.ConstantPoolGen cpg =
              classContext.
              getConstantPoolGen(
                );
            edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow =
              classContext.
              getTypeDataflow(
                method);
            for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
                   classContext.
                   getCFG(
                     method).
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
                org.apache.bcel.generic.Instruction ins =
                  location.
                  getHandle(
                    ).
                  getInstruction(
                    );
                try {
                    edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
                      classContext.
                      getValueNumberDataflow(
                        method).
                      getFactAtLocation(
                        location);
                    if (!vnaFrame.
                          isValid(
                            )) {
                        continue;
                    }
                    if (ins instanceof org.apache.bcel.generic.InvokeInstruction) {
                        examineCallSite(
                          location,
                          cpg,
                          typeDataflow);
                    }
                    else
                        if (methodAnnotation ==
                              edu.umd.cs.findbugs.ba.NullnessAnnotation.
                                NONNULL &&
                              ins.
                              getOpcode(
                                ) ==
                              org.apache.bcel.Constants.
                                ARETURN) {
                            examineReturnInstruction(
                              location);
                        }
                        else
                            if (ins instanceof org.apache.bcel.generic.PUTFIELD) {
                                examinePutfieldInstruction(
                                  location,
                                  (org.apache.bcel.generic.PUTFIELD)
                                    ins,
                                  cpg);
                            }
                }
                catch (java.lang.ClassNotFoundException e) {
                    bugReporter.
                      reportMissingClass(
                        e);
                }
            }
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "error:",
                e);
        }
        finally {
            profiler.
              end(
                edu.umd.cs.findbugs.detect.FindNullDeref.CheckCallSitesAndReturnInstructions.class);
        }
    }
    private void examineCallSite(edu.umd.cs.findbugs.ba.Location location,
                                 org.apache.bcel.generic.ConstantPoolGen cpg,
                                 edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        edu.umd.cs.findbugs.ba.CFGBuilderException,
        java.lang.ClassNotFoundException {
        org.apache.bcel.generic.InvokeInstruction invokeInstruction =
          (org.apache.bcel.generic.InvokeInstruction)
            location.
            getHandle(
              ).
            getInstruction(
              );
        java.lang.String methodName =
          invokeInstruction.
          getName(
            cpg);
        java.lang.String signature =
          invokeInstruction.
          getSignature(
            cpg);
        if ("equals".
              equals(
                methodName) &&
              "(Ljava/lang/Object;)Z".
              equals(
                signature)) {
            return;
        }
        int returnTypeStart =
          signature.
          indexOf(
            ')');
        if (returnTypeStart <
              0) {
            return;
        }
        java.lang.String paramList =
          signature.
          substring(
            0,
            returnTypeStart +
              1);
        if ("()".
              equals(
                paramList) ||
              paramList.
              indexOf(
                'L') <
              0 &&
              paramList.
              indexOf(
                '[') <
              0) {
            return;
        }
        edu.umd.cs.findbugs.ba.npe.IsNullValueFrame frame =
          classContext.
          getIsNullValueDataflow(
            method).
          getFactAtLocation(
            location);
        if (!frame.
              isValid(
                )) {
            return;
        }
        java.util.BitSet nullArgSet =
          frame.
          getArgumentSet(
            invokeInstruction,
            cpg,
            new edu.umd.cs.findbugs.ba.DataflowValueChooser<edu.umd.cs.findbugs.ba.npe.IsNullValue>(
              ) {
                @java.lang.Override
                public boolean choose(edu.umd.cs.findbugs.ba.npe.IsNullValue value) {
                    return value.
                      mightBeNull(
                        ) &&
                      !value.
                      isException(
                        ) &&
                      !value.
                      isReturnValue(
                        );
                }
            });
        java.util.BitSet definitelyNullArgSet =
          frame.
          getArgumentSet(
            invokeInstruction,
            cpg,
            new edu.umd.cs.findbugs.ba.DataflowValueChooser<edu.umd.cs.findbugs.ba.npe.IsNullValue>(
              ) {
                @java.lang.Override
                public boolean choose(edu.umd.cs.findbugs.ba.npe.IsNullValue value) {
                    return value.
                      isDefinitelyNull(
                        );
                }
            });
        nullArgSet.
          and(
            definitelyNullArgSet);
        if (nullArgSet.
              isEmpty(
                )) {
            return;
        }
        if (DEBUG_NULLARG) {
            java.lang.System.
              out.
              println(
                "Null arguments passed: " +
                nullArgSet);
            java.lang.System.
              out.
              println(
                "Frame is: " +
                frame);
            java.lang.System.
              out.
              println(
                "# arguments: " +
                frame.
                  getNumArguments(
                    invokeInstruction,
                    cpg));
            edu.umd.cs.findbugs.ba.XMethod xm =
              edu.umd.cs.findbugs.ba.XFactory.
              createXMethod(
                invokeInstruction,
                cpg);
            java.lang.System.
              out.
              print(
                "Signature: " +
                xm.
                  getSignature(
                    ));
        }
        if (unconditionalDerefParamDatabase !=
              null) {
            checkUnconditionallyDereferencedParam(
              location,
              cpg,
              typeDataflow,
              invokeInstruction,
              nullArgSet,
              definitelyNullArgSet);
        }
        if (DEBUG_NULLARG) {
            java.lang.System.
              out.
              println(
                "Checking nonnull params");
        }
        checkNonNullParam(
          location,
          cpg,
          typeDataflow,
          invokeInstruction,
          nullArgSet,
          definitelyNullArgSet);
    }
    private void examinePutfieldInstruction(edu.umd.cs.findbugs.ba.Location location,
                                            org.apache.bcel.generic.PUTFIELD ins,
                                            org.apache.bcel.generic.ConstantPoolGen cpg)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        edu.umd.cs.findbugs.ba.npe.IsNullValueFrame frame =
          invDataflow.
          getFactAtLocation(
            location);
        if (!frame.
              isValid(
                )) {
            return;
        }
        edu.umd.cs.findbugs.ba.npe.IsNullValue tos =
          frame.
          getTopValue(
            );
        if (tos.
              isDefinitelyNull(
                )) {
            edu.umd.cs.findbugs.ba.XField field =
              edu.umd.cs.findbugs.ba.XFactory.
              createXField(
                ins,
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
                edu.umd.cs.findbugs.BugAnnotation variableAnnotation =
                  null;
                try {
                    edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
                      classContext.
                      getValueNumberDataflow(
                        method).
                      getFactAtLocation(
                        location);
                    edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
                      vnaFrame.
                      getTopValue(
                        );
                    variableAnnotation =
                      edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
                        findAnnotationFromValueNumber(
                          method,
                          location,
                          valueNumber,
                          vnaFrame,
                          "VALUE_OF");
                }
                catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      logError(
                        "error",
                        e);
                }
                catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      logError(
                        "error",
                        e);
                }
                edu.umd.cs.findbugs.BugInstance warning =
                  new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "NP_STORE_INTO_NONNULL_FIELD",
                  tos.
                    isDefinitelyNull(
                      )
                    ? HIGH_PRIORITY
                    : NORMAL_PRIORITY).
                  addClassAndMethod(
                    classContext.
                      getJavaClass(
                        ),
                    method).
                  addField(
                    field).
                  addOptionalAnnotation(
                    variableAnnotation).
                  addSourceLine(
                    classContext,
                    method,
                    location);
                bugReporter.
                  reportBug(
                    warning);
            }
        }
    }
    private void examineReturnInstruction(edu.umd.cs.findbugs.ba.Location location)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        edu.umd.cs.findbugs.ba.CFGBuilderException {
        if (DEBUG_NULLRETURN) {
            java.lang.System.
              out.
              println(
                "Checking null return at " +
                location);
        }
        edu.umd.cs.findbugs.ba.npe.IsNullValueDataflow invDataflow =
          classContext.
          getIsNullValueDataflow(
            method);
        edu.umd.cs.findbugs.ba.npe.IsNullValueFrame frame =
          invDataflow.
          getFactAtLocation(
            location);
        edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
          classContext.
          getValueNumberDataflow(
            method).
          getFactAtLocation(
            location);
        if (!vnaFrame.
              isValid(
                )) {
            return;
        }
        edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
          vnaFrame.
          getTopValue(
            );
        if (!frame.
              isValid(
                )) {
            return;
        }
        edu.umd.cs.findbugs.ba.npe.IsNullValue tos =
          frame.
          getTopValue(
            );
        if (tos.
              isDefinitelyNull(
                )) {
            edu.umd.cs.findbugs.BugAnnotation variable =
              edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
              findAnnotationFromValueNumber(
                method,
                location,
                valueNumber,
                vnaFrame,
                "VALUE_OF");
            java.lang.String bugPattern =
              "NP_NONNULL_RETURN_VIOLATION";
            int priority =
              NORMAL_PRIORITY;
            if (tos.
                  isDefinitelyNull(
                    ) &&
                  !tos.
                  isException(
                    )) {
                priority =
                  HIGH_PRIORITY;
            }
            java.lang.String methodName =
              method.
              getName(
                );
            if ("clone".
                  equals(
                    methodName)) {
                bugPattern =
                  "NP_CLONE_COULD_RETURN_NULL";
                priority =
                  NORMAL_PRIORITY;
            }
            else
                if ("toString".
                      equals(
                        methodName)) {
                    bugPattern =
                      "NP_TOSTRING_COULD_RETURN_NULL";
                    priority =
                      NORMAL_PRIORITY;
                }
            edu.umd.cs.findbugs.BugInstance warning =
              new edu.umd.cs.findbugs.BugInstance(
              this,
              bugPattern,
              priority).
              addClassAndMethod(
                classContext.
                  getJavaClass(
                    ),
                method).
              addOptionalAnnotation(
                variable);
            bugAccumulator.
              accumulateBug(
                warning,
                edu.umd.cs.findbugs.SourceLineAnnotation.
                  fromVisitedInstruction(
                    classContext,
                    method,
                    location));
        }
    }
    private boolean hasManyPreceedingNullTests(int pc) {
        int ifNullTests =
          0;
        java.util.BitSet seen =
          new java.util.BitSet(
          );
        try {
            for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
                   classContext.
                   getCFG(
                     method).
                   locationIterator(
                     );
                 i.
                   hasNext(
                     );
                 ) {
                edu.umd.cs.findbugs.ba.Location loc =
                  i.
                  next(
                    );
                int pc2 =
                  loc.
                  getHandle(
                    ).
                  getPosition(
                    );
                if (pc2 >=
                      pc ||
                      pc2 <
                      pc -
                      30) {
                    continue;
                }
                org.apache.bcel.generic.Instruction ins =
                  loc.
                  getHandle(
                    ).
                  getInstruction(
                    );
                if ((ins instanceof org.apache.bcel.generic.IFNONNULL ||
                       ins instanceof org.apache.bcel.generic.IFNULL ||
                       ins instanceof edu.umd.cs.findbugs.bcel.generic.NullnessConversationInstruction) &&
                      !seen.
                      get(
                        pc2)) {
                    ifNullTests++;
                    seen.
                      set(
                        pc2);
                }
            }
            boolean result =
              ifNullTests >
              2;
            return result;
        }
        catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
            return false;
        }
    }
    @edu.umd.cs.findbugs.internalAnnotations.StaticConstant
    public static final java.util.Set<java.lang.String>
      catchTypesForNull =
      java.util.Collections.
      unmodifiableSet(
        new java.util.HashSet<java.lang.String>(
          java.util.Arrays.
            asList(
              "java/lang/NullPointerException",
              "java/lang/RuntimeException",
              "java/lang/Exception")));
    public static boolean catchesNull(org.apache.bcel.classfile.ConstantPool constantPool,
                                      org.apache.bcel.classfile.Code code,
                                      edu.umd.cs.findbugs.ba.Location location) {
        int position =
          location.
          getHandle(
            ).
          getPosition(
            );
        for (java.lang.String t
              :
              catchTypesForNull) {
            int catchSize =
              edu.umd.cs.findbugs.visitclass.Util.
              getSizeOfSurroundingTryBlock(
                constantPool,
                code,
                t,
                position);
            if (catchSize <
                  java.lang.Integer.
                    MAX_VALUE) {
                return true;
            }
        }
        return false;
    }
    private boolean safeCallToPrimateParseMethod(edu.umd.cs.findbugs.ba.XMethod calledMethod,
                                                 edu.umd.cs.findbugs.ba.Location location) {
        int position =
          location.
          getHandle(
            ).
          getPosition(
            );
        if ("java.lang.Integer".
              equals(
                calledMethod.
                  getClassName(
                    ))) {
            org.apache.bcel.classfile.ConstantPool constantPool =
              classContext.
              getJavaClass(
                ).
              getConstantPool(
                );
            org.apache.bcel.classfile.Code code =
              method.
              getCode(
                );
            int catchSize;
            catchSize =
              edu.umd.cs.findbugs.visitclass.Util.
                getSizeOfSurroundingTryBlock(
                  constantPool,
                  code,
                  "java/lang/NumberFormatException",
                  position);
            if (catchSize <
                  java.lang.Integer.
                    MAX_VALUE) {
                return true;
            }
            catchSize =
              edu.umd.cs.findbugs.visitclass.Util.
                getSizeOfSurroundingTryBlock(
                  constantPool,
                  code,
                  "java/lang/IllegalArgumentException",
                  position);
            if (catchSize <
                  java.lang.Integer.
                    MAX_VALUE) {
                return true;
            }
            catchSize =
              edu.umd.cs.findbugs.visitclass.Util.
                getSizeOfSurroundingTryBlock(
                  constantPool,
                  code,
                  "java/lang/RuntimeException",
                  position);
            if (catchSize <
                  java.lang.Integer.
                    MAX_VALUE) {
                return true;
            }
            catchSize =
              edu.umd.cs.findbugs.visitclass.Util.
                getSizeOfSurroundingTryBlock(
                  constantPool,
                  code,
                  "java/lang/Exception",
                  position);
            if (catchSize <
                  java.lang.Integer.
                    MAX_VALUE) {
                return true;
            }
        }
        return false;
    }
    private void checkUnconditionallyDereferencedParam(edu.umd.cs.findbugs.ba.Location location,
                                                       org.apache.bcel.generic.ConstantPoolGen cpg,
                                                       edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow,
                                                       org.apache.bcel.generic.InvokeInstruction invokeInstruction,
                                                       java.util.BitSet nullArgSet,
                                                       java.util.BitSet definitelyNullArgSet)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        java.lang.ClassNotFoundException {
        if (inExplictCatchNullBlock(
              location)) {
            return;
        }
        boolean caught =
          inIndirectCatchNullBlock(
            location);
        if (caught &&
              skipIfInsideCatchNull(
                )) {
            return;
        }
        edu.umd.cs.findbugs.ba.XMethod calledMethod =
          edu.umd.cs.findbugs.ba.XFactory.
          createXMethod(
            invokeInstruction,
            cpg);
        if (true) {
            nullArgSet =
              (java.util.BitSet)
                nullArgSet.
                clone(
                  );
            definitelyNullArgSet =
              (java.util.BitSet)
                definitelyNullArgSet.
                clone(
                  );
            edu.umd.cs.findbugs.classfile.ClassDescriptor nonnullClassDesc =
              edu.umd.cs.findbugs.classfile.DescriptorFactory.
              createClassDescriptor(
                javax.annotation.Nonnull.class);
            edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue<?> nonnullTypeQualifierValue =
              edu.umd.cs.findbugs.ba.jsr305.TypeQualifierValue.
              getValue(
                nonnullClassDesc,
                null);
            for (int i =
                   nullArgSet.
                   nextSetBit(
                     0);
                 i >=
                   0;
                 i =
                   nullArgSet.
                     nextSetBit(
                       i +
                         1)) {
                edu.umd.cs.findbugs.ba.jsr305.TypeQualifierAnnotation tqa =
                  edu.umd.cs.findbugs.ba.jsr305.TypeQualifierApplications.
                  getEffectiveTypeQualifierAnnotation(
                    calledMethod,
                    i,
                    nonnullTypeQualifierValue);
                if (tqa !=
                      null &&
                      tqa.
                        when ==
                      javax.annotation.meta.When.
                        ALWAYS) {
                    nullArgSet.
                      clear(
                        i);
                    definitelyNullArgSet.
                      clear(
                        i);
                }
            }
        }
        edu.umd.cs.findbugs.ba.type.TypeFrame typeFrame =
          typeDataflow.
          getFactAtLocation(
            location);
        java.util.Set<edu.umd.cs.findbugs.ba.JavaClassAndMethod> targetMethodSet =
          edu.umd.cs.findbugs.ba.Hierarchy.
          resolveMethodCallTargets(
            invokeInstruction,
            typeFrame,
            cpg);
        if (DEBUG_NULLARG) {
            java.lang.System.
              out.
              println(
                "Possibly called methods: " +
                targetMethodSet);
        }
        java.util.BitSet unconditionallyDereferencedNullArgSet =
          new java.util.BitSet(
          );
        java.util.List<edu.umd.cs.findbugs.ba.JavaClassAndMethod> dangerousCallTargetList =
          new java.util.LinkedList<edu.umd.cs.findbugs.ba.JavaClassAndMethod>(
          );
        java.util.List<edu.umd.cs.findbugs.ba.JavaClassAndMethod> veryDangerousCallTargetList =
          new java.util.LinkedList<edu.umd.cs.findbugs.ba.JavaClassAndMethod>(
          );
        for (edu.umd.cs.findbugs.ba.JavaClassAndMethod targetMethod
              :
              targetMethodSet) {
            if (DEBUG_NULLARG) {
                java.lang.System.
                  out.
                  println(
                    "For target method " +
                    targetMethod);
            }
            edu.umd.cs.findbugs.ba.interproc.ParameterProperty property =
              unconditionalDerefParamDatabase.
              getProperty(
                targetMethod.
                  toMethodDescriptor(
                    ));
            if (property ==
                  null) {
                continue;
            }
            if (DEBUG_NULLARG) {
                java.lang.System.
                  out.
                  println(
                    "\tUnconditionally dereferenced params: " +
                    property);
            }
            java.util.BitSet targetUnconditionallyDereferencedNullArgSet =
              property.
              getMatchingParameters(
                nullArgSet);
            if (targetUnconditionallyDereferencedNullArgSet.
                  isEmpty(
                    )) {
                continue;
            }
            dangerousCallTargetList.
              add(
                targetMethod);
            unconditionallyDereferencedNullArgSet.
              or(
                targetUnconditionallyDereferencedNullArgSet);
            if (!property.
                  getMatchingParameters(
                    definitelyNullArgSet).
                  isEmpty(
                    )) {
                veryDangerousCallTargetList.
                  add(
                    targetMethod);
            }
        }
        if (dangerousCallTargetList.
              isEmpty(
                )) {
            return;
        }
        edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty> propertySet =
          new edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty>(
          );
        java.util.Set<edu.umd.cs.findbugs.ba.JavaClassAndMethod> safeCallTargetSet =
          new java.util.HashSet<edu.umd.cs.findbugs.ba.JavaClassAndMethod>(
          );
        safeCallTargetSet.
          addAll(
            targetMethodSet);
        safeCallTargetSet.
          removeAll(
            dangerousCallTargetList);
        if (safeCallTargetSet.
              isEmpty(
                )) {
            propertySet.
              addProperty(
                edu.umd.cs.findbugs.detect.NullArgumentWarningProperty.
                  ALL_DANGEROUS_TARGETS);
            if (dangerousCallTargetList.
                  size(
                    ) ==
                  1) {
                propertySet.
                  addProperty(
                    edu.umd.cs.findbugs.detect.NullArgumentWarningProperty.
                      MONOMORPHIC_CALL_SITE);
            }
        }
        boolean privateCall =
          safeCallTargetSet.
          isEmpty(
            ) &&
          dangerousCallTargetList.
          size(
            ) ==
          1 &&
          dangerousCallTargetList.
          get(
            0).
          getMethod(
            ).
          isPrivate(
            );
        java.lang.String bugType;
        int priority;
        if (privateCall ||
              invokeInstruction.
              getOpcode(
                ) ==
              org.apache.bcel.Constants.
                INVOKESTATIC ||
              invokeInstruction.
              getOpcode(
                ) ==
              org.apache.bcel.Constants.
                INVOKESPECIAL) {
            bugType =
              "NP_NULL_PARAM_DEREF_NONVIRTUAL";
            priority =
              HIGH_PRIORITY;
        }
        else
            if (safeCallTargetSet.
                  isEmpty(
                    )) {
                bugType =
                  "NP_NULL_PARAM_DEREF_ALL_TARGETS_DANGEROUS";
                priority =
                  NORMAL_PRIORITY;
            }
            else {
                return;
            }
        if (caught) {
            priority++;
        }
        if (dangerousCallTargetList.
              size(
                ) >
              veryDangerousCallTargetList.
              size(
                )) {
            priority++;
        }
        else {
            propertySet.
              addProperty(
                edu.umd.cs.findbugs.detect.NullArgumentWarningProperty.
                  ACTUAL_PARAMETER_GUARANTEED_NULL);
        }
        edu.umd.cs.findbugs.ba.XMethod calledFrom =
          edu.umd.cs.findbugs.ba.XFactory.
          createXMethod(
            classContext.
              getJavaClass(
                ),
            method);
        if (safeCallToPrimateParseMethod(
              calledMethod,
              location)) {
            return;
        }
        edu.umd.cs.findbugs.BugInstance warning =
          new edu.umd.cs.findbugs.BugInstance(
          this,
          bugType,
          priority).
          addClassAndMethod(
            classContext.
              getJavaClass(
                ),
            method).
          addMethod(
            calledMethod).
          describe(
            edu.umd.cs.findbugs.MethodAnnotation.
              METHOD_CALLED).
          addSourceLine(
            classContext,
            method,
            location);
        if (!edu.umd.cs.findbugs.ba.AnalysisContext.
              currentXFactory(
                ).
              isCalledDirectlyOrIndirectly(
                calledFrom) &&
              calledFrom.
              isPrivate(
                )) {
            propertySet.
              addProperty(
                edu.umd.cs.findbugs.props.GeneralWarningProperty.
                  IN_UNCALLABLE_METHOD);
        }
        addParamAnnotations(
          location,
          definitelyNullArgSet,
          unconditionallyDereferencedNullArgSet,
          propertySet,
          warning);
        if ("NP_NULL_PARAM_DEREF_ALL_TARGETS_DANGEROUS".
              equals(
                bugType)) {
            for (edu.umd.cs.findbugs.ba.JavaClassAndMethod dangerousCallTarget
                  :
                  veryDangerousCallTargetList) {
                warning.
                  addMethod(
                    dangerousCallTarget).
                  describe(
                    edu.umd.cs.findbugs.MethodAnnotation.
                      METHOD_DANGEROUS_TARGET_ACTUAL_GUARANTEED_NULL);
            }
            dangerousCallTargetList.
              removeAll(
                veryDangerousCallTargetList);
            if (DEBUG_NULLARG) {
                for (edu.umd.cs.findbugs.ba.JavaClassAndMethod dangerousCallTarget
                      :
                      dangerousCallTargetList) {
                    warning.
                      addMethod(
                        dangerousCallTarget).
                      describe(
                        edu.umd.cs.findbugs.MethodAnnotation.
                          METHOD_DANGEROUS_TARGET);
                }
                for (edu.umd.cs.findbugs.ba.JavaClassAndMethod safeMethod
                      :
                      safeCallTargetSet) {
                    warning.
                      addMethod(
                        safeMethod).
                      describe(
                        edu.umd.cs.findbugs.MethodAnnotation.
                          METHOD_SAFE_TARGET);
                }
            }
        }
        decorateWarning(
          location,
          propertySet,
          warning);
        bugReporter.
          reportBug(
            warning);
    }
    private void decorateWarning(edu.umd.cs.findbugs.ba.Location location,
                                 edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty> propertySet,
                                 edu.umd.cs.findbugs.BugInstance warning) {
        if (edu.umd.cs.findbugs.FindBugsAnalysisFeatures.
              isRelaxedMode(
                )) {
            edu.umd.cs.findbugs.props.WarningPropertyUtil.
              addPropertiesForDataMining(
                propertySet,
                classContext,
                method,
                location);
        }
        propertySet.
          decorateBugInstance(
            warning);
    }
    private void addParamAnnotations(edu.umd.cs.findbugs.ba.Location location,
                                     java.util.BitSet definitelyNullArgSet,
                                     java.util.BitSet violatedParamSet,
                                     edu.umd.cs.findbugs.props.WarningPropertySet<? super edu.umd.cs.findbugs.detect.NullArgumentWarningProperty> propertySet,
                                     edu.umd.cs.findbugs.BugInstance warning) {
        edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
          null;
        try {
            vnaFrame =
              classContext.
                getValueNumberDataflow(
                  method).
                getFactAtLocation(
                  location);
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "error",
                e);
        }
        catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "error",
                e);
        }
        org.apache.bcel.generic.InvokeInstruction instruction =
          (org.apache.bcel.generic.InvokeInstruction)
            location.
            getHandle(
              ).
            getInstruction(
              );
        edu.umd.cs.findbugs.ba.SignatureParser sigParser =
          new edu.umd.cs.findbugs.ba.SignatureParser(
          instruction.
            getSignature(
              classContext.
                getConstantPoolGen(
                  )));
        for (int i =
               violatedParamSet.
               nextSetBit(
                 0);
             i >=
               0;
             i =
               violatedParamSet.
                 nextSetBit(
                   i +
                     1)) {
            boolean definitelyNull =
              definitelyNullArgSet.
              get(
                i);
            if (definitelyNull) {
                propertySet.
                  addProperty(
                    edu.umd.cs.findbugs.detect.NullArgumentWarningProperty.
                      ARG_DEFINITELY_NULL);
            }
            edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
              null;
            if (vnaFrame !=
                  null) {
                try {
                    valueNumber =
                      vnaFrame.
                        getArgument(
                          instruction,
                          classContext.
                            getConstantPoolGen(
                              ),
                          i,
                          sigParser);
                    edu.umd.cs.findbugs.BugAnnotation variableAnnotation =
                      edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
                      findAnnotationFromValueNumber(
                        method,
                        location,
                        valueNumber,
                        vnaFrame,
                        "VALUE_OF");
                    warning.
                      addOptionalAnnotation(
                        variableAnnotation);
                }
                catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      logError(
                        "error",
                        e);
                }
            }
            warning.
              addParameterAnnotation(
                i,
                definitelyNull
                  ? "INT_NULL_ARG"
                  : "INT_MAYBE_NULL_ARG");
        }
    }
    private void checkNonNullParam(edu.umd.cs.findbugs.ba.Location location,
                                   org.apache.bcel.generic.ConstantPoolGen cpg,
                                   edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow,
                                   org.apache.bcel.generic.InvokeInstruction invokeInstruction,
                                   java.util.BitSet nullArgSet,
                                   java.util.BitSet definitelyNullArgSet) {
        if (inExplictCatchNullBlock(
              location)) {
            return;
        }
        boolean caught =
          inIndirectCatchNullBlock(
            location);
        if (caught &&
              skipIfInsideCatchNull(
                )) {
            return;
        }
        edu.umd.cs.findbugs.ba.XMethod m =
          edu.umd.cs.findbugs.ba.XFactory.
          createXMethod(
            invokeInstruction,
            cpg);
        edu.umd.cs.findbugs.ba.INullnessAnnotationDatabase db =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          getNullnessAnnotationDatabase(
            );
        edu.umd.cs.findbugs.ba.SignatureParser sigParser =
          new edu.umd.cs.findbugs.ba.SignatureParser(
          invokeInstruction.
            getSignature(
              cpg));
        for (int i =
               nullArgSet.
               nextSetBit(
                 0);
             i >=
               0;
             i =
               nullArgSet.
                 nextSetBit(
                   i +
                     1)) {
            if (db.
                  parameterMustBeNonNull(
                    m,
                    i)) {
                boolean definitelyNull =
                  definitelyNullArgSet.
                  get(
                    i);
                if (DEBUG_NULLARG) {
                    java.lang.System.
                      out.
                      println(
                        "Checking " +
                        m);
                    java.lang.System.
                      out.
                      println(
                        "QQQ2: " +
                        i +
                        " -- " +
                        i +
                        " is null");
                    java.lang.System.
                      out.
                      println(
                        "QQQ nullArgSet: " +
                        nullArgSet);
                    java.lang.System.
                      out.
                      println(
                        "QQQ dnullArgSet: " +
                        definitelyNullArgSet);
                }
                edu.umd.cs.findbugs.BugAnnotation variableAnnotation =
                  null;
                try {
                    edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
                      classContext.
                      getValueNumberDataflow(
                        method).
                      getFactAtLocation(
                        location);
                    edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
                      vnaFrame.
                      getArgument(
                        invokeInstruction,
                        cpg,
                        i,
                        sigParser);
                    variableAnnotation =
                      edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
                        findAnnotationFromValueNumber(
                          method,
                          location,
                          valueNumber,
                          vnaFrame,
                          "VALUE_OF");
                }
                catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      logError(
                        "error",
                        e);
                }
                catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      logError(
                        "error",
                        e);
                }
                int priority =
                  definitelyNull
                  ? HIGH_PRIORITY
                  : NORMAL_PRIORITY;
                if (caught) {
                    priority++;
                }
                if (m.
                      isPrivate(
                        ) &&
                      priority ==
                      HIGH_PRIORITY) {
                    priority =
                      NORMAL_PRIORITY;
                }
                java.lang.String description =
                  definitelyNull
                  ? "INT_NULL_ARG"
                  : "INT_MAYBE_NULL_ARG";
                edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty> propertySet =
                  new edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty>(
                  );
                java.util.Set<edu.umd.cs.findbugs.ba.Location> derefLocationSet =
                  java.util.Collections.
                  singleton(
                    location);
                addPropertiesForDereferenceLocations(
                  propertySet,
                  derefLocationSet,
                  false);
                boolean duplicated =
                  isDuplicated(
                    propertySet,
                    location.
                      getHandle(
                        ).
                      getPosition(
                        ),
                    false);
                if (duplicated) {
                    return;
                }
                edu.umd.cs.findbugs.BugInstance warning =
                  new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "NP_NONNULL_PARAM_VIOLATION",
                  priority).
                  addClassAndMethod(
                    classContext.
                      getJavaClass(
                        ),
                    method).
                  addMethod(
                    m).
                  describe(
                    edu.umd.cs.findbugs.MethodAnnotation.
                      METHOD_CALLED).
                  addParameterAnnotation(
                    i,
                    description).
                  addOptionalAnnotation(
                    variableAnnotation).
                  addSourceLine(
                    classContext,
                    method,
                    location);
                propertySet.
                  decorateBugInstance(
                    warning);
                bugReporter.
                  reportBug(
                    warning);
            }
        }
    }
    @java.lang.Override
    public void report() {  }
    public boolean skipIfInsideCatchNull() {
        return classContext.
          getJavaClass(
            ).
          getClassName(
            ).
          indexOf(
            "Test") >=
          0 ||
          method.
          getName(
            ).
          indexOf(
            "test") >=
          0 ||
          method.
          getName(
            ).
          indexOf(
            "Test") >=
          0;
    }
    @java.lang.Override
    @java.lang.Deprecated
    public void foundNullDeref(edu.umd.cs.findbugs.ba.Location location,
                               edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber,
                               edu.umd.cs.findbugs.ba.npe.IsNullValue refValue,
                               edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame) {
        foundNullDeref(
          location,
          valueNumber,
          refValue,
          vnaFrame,
          true);
    }
    @java.lang.Override
    public void foundNullDeref(edu.umd.cs.findbugs.ba.Location location,
                               edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber,
                               edu.umd.cs.findbugs.ba.npe.IsNullValue refValue,
                               edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame,
                               boolean isConsistent) {
        edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty> propertySet =
          new edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty>(
          );
        if (valueNumber.
              hasFlag(
                edu.umd.cs.findbugs.ba.vna.ValueNumber.
                  CONSTANT_CLASS_OBJECT)) {
            return;
        }
        boolean onExceptionPath =
          refValue.
          isException(
            );
        if (onExceptionPath) {
            propertySet.
              addProperty(
                edu.umd.cs.findbugs.props.GeneralWarningProperty.
                  ON_EXCEPTION_PATH);
        }
        int pc =
          location.
          getHandle(
            ).
          getPosition(
            );
        edu.umd.cs.findbugs.BugAnnotation variable =
          edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
          findAnnotationFromValueNumber(
            method,
            location,
            valueNumber,
            vnaFrame,
            "VALUE_OF");
        addPropertiesForDereferenceLocations(
          propertySet,
          java.util.Collections.
            singleton(
              location),
          isConsistent);
        org.apache.bcel.generic.Instruction ins =
          location.
          getHandle(
            ).
          getInstruction(
            );
        if (ins instanceof org.apache.bcel.generic.InvokeInstruction &&
              refValue.
              isDefinitelyNull(
                )) {
            org.apache.bcel.generic.InvokeInstruction iins =
              (org.apache.bcel.generic.InvokeInstruction)
                ins;
            if ("close".
                  equals(
                    iins.
                      getMethodName(
                        classContext.
                          getConstantPoolGen(
                            ))) &&
                  "()V".
                  equals(
                    iins.
                      getSignature(
                        classContext.
                          getConstantPoolGen(
                            )))) {
                propertySet.
                  addProperty(
                    edu.umd.cs.findbugs.detect.NullDerefProperty.
                      CLOSING_NULL);
            }
        }
        boolean duplicated =
          isDuplicated(
            propertySet,
            pc,
            isConsistent);
        if (inExplictCatchNullBlock(
              location)) {
            return;
        }
        boolean caught =
          inIndirectCatchNullBlock(
            location);
        if (caught &&
              skipIfInsideCatchNull(
                )) {
            return;
        }
        if (refValue.
              isDefinitelyNull(
                )) {
            java.lang.String type =
              "NP_ALWAYS_NULL";
            if (propertySet.
                  containsProperty(
                    edu.umd.cs.findbugs.detect.NullDerefProperty.
                      CLOSING_NULL) &&
                  !propertySet.
                  containsProperty(
                    edu.umd.cs.findbugs.detect.NullDerefProperty.
                      DEREFS_ARE_CLONED)) {
                type =
                  "NP_CLOSING_NULL";
            }
            else
                if (onExceptionPath) {
                    type =
                      "NP_ALWAYS_NULL_EXCEPTION";
                }
                else
                    if (duplicated) {
                        type =
                          "NP_NULL_ON_SOME_PATH";
                    }
            int priority =
              onExceptionPath
              ? NORMAL_PRIORITY
              : HIGH_PRIORITY;
            if (caught) {
                priority++;
            }
            reportNullDeref(
              propertySet,
              location,
              type,
              priority,
              variable);
        }
        else
            if (refValue.
                  mightBeNull(
                    ) &&
                  refValue.
                  isParamValue(
                    )) {
                java.lang.String type;
                int priority =
                  NORMAL_PRIORITY;
                if (caught) {
                    priority++;
                }
                if ("equals".
                      equals(
                        method.
                          getName(
                            )) &&
                      "(Ljava/lang/Object;)Z".
                      equals(
                        method.
                          getSignature(
                            ))) {
                    if (caught) {
                        return;
                    }
                    type =
                      "NP_EQUALS_SHOULD_HANDLE_NULL_ARGUMENT";
                }
                else {
                    type =
                      "NP_ARGUMENT_MIGHT_BE_NULL";
                }
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Reporting null on some path: value=" +
                        refValue);
                }
                reportNullDeref(
                  propertySet,
                  location,
                  type,
                  priority,
                  variable);
            }
    }
    public boolean isDuplicated(edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty> propertySet,
                                int pc,
                                boolean isConsistent) {
        boolean duplicated =
          false;
        if (!isConsistent) {
            if (propertySet.
                  containsProperty(
                    edu.umd.cs.findbugs.detect.NullDerefProperty.
                      DEREFS_ARE_CLONED)) {
                duplicated =
                  true;
            }
            else {
                try {
                    edu.umd.cs.findbugs.ba.CFG cfg =
                      classContext.
                      getCFG(
                        method);
                    if (cfg.
                          getLocationsContainingInstructionWithOffset(
                            pc).
                          size(
                            ) >
                          1) {
                        propertySet.
                          addProperty(
                            edu.umd.cs.findbugs.detect.NullDerefProperty.
                              DEREFS_ARE_INLINED_FINALLY_BLOCKS);
                        duplicated =
                          true;
                    }
                }
                catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                    edu.umd.cs.findbugs.ba.AnalysisContext.
                      logError(
                        "Error while analyzing " +
                        classContext.
                          getFullyQualifiedMethodName(
                            method),
                        e);
                }
            }
        }
        return duplicated;
    }
    private void reportNullDeref(edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty> propertySet,
                                 edu.umd.cs.findbugs.ba.Location location,
                                 java.lang.String type,
                                 int priority,
                                 @javax.annotation.CheckForNull
                                 edu.umd.cs.findbugs.BugAnnotation variable) {
        edu.umd.cs.findbugs.BugInstance bugInstance =
          new edu.umd.cs.findbugs.BugInstance(
          this,
          type,
          priority).
          addClassAndMethod(
            classContext.
              getJavaClass(
                ),
            method);
        if (variable !=
              null) {
            bugInstance.
              add(
                variable);
        }
        else {
            bugInstance.
              add(
                new edu.umd.cs.findbugs.LocalVariableAnnotation(
                  "?",
                  -1,
                  -1));
        }
        bugInstance.
          addSourceLine(
            classContext,
            method,
            location).
          describe(
            "SOURCE_LINE_DEREF");
        if (edu.umd.cs.findbugs.FindBugsAnalysisFeatures.
              isRelaxedMode(
                )) {
            edu.umd.cs.findbugs.props.WarningPropertyUtil.
              addPropertiesForDataMining(
                propertySet,
                classContext,
                method,
                location);
        }
        addPropertiesForDereferenceLocations(
          propertySet,
          java.util.Collections.
            singleton(
              location),
          false);
        propertySet.
          decorateBugInstance(
            bugInstance);
        bugReporter.
          reportBug(
            bugInstance);
    }
    public static boolean isThrower(edu.umd.cs.findbugs.ba.BasicBlock target) {
        org.apache.bcel.generic.InstructionHandle ins =
          target.
          getFirstInstruction(
            );
        int maxCount =
          7;
        while (ins !=
                 null) {
            if (maxCount-- <=
                  0) {
                break;
            }
            org.apache.bcel.generic.Instruction i =
              ins.
              getInstruction(
                );
            if (i instanceof org.apache.bcel.generic.ATHROW) {
                return true;
            }
            if (i instanceof org.apache.bcel.generic.InstructionTargeter ||
                  i instanceof org.apache.bcel.generic.ReturnInstruction) {
                return false;
            }
            ins =
              ins.
                getNext(
                  );
        }
        return false;
    }
    @java.lang.Override
    public void foundRedundantNullCheck(edu.umd.cs.findbugs.ba.Location location,
                                        edu.umd.cs.findbugs.ba.npe.RedundantBranch redundantBranch) {
        boolean isChecked =
          redundantBranch.
            firstValue.
          isChecked(
            );
        boolean wouldHaveBeenAKaboom =
          redundantBranch.
            firstValue.
          wouldHaveBeenAKaboom(
            );
        boolean isParameter =
          redundantBranch.
            firstValue.
          isParamValue(
            );
        edu.umd.cs.findbugs.ba.Location locationOfKaBoom =
          redundantBranch.
            firstValue.
          getLocationOfKaBoom(
            );
        if (isParameter &&
              !wouldHaveBeenAKaboom) {
            return;
        }
        boolean createdDeadCode =
          false;
        boolean infeasibleEdgeSimplyThrowsException =
          false;
        edu.umd.cs.findbugs.ba.Edge infeasibleEdge =
          redundantBranch.
            infeasibleEdge;
        if (infeasibleEdge !=
              null) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Check if " +
                    redundantBranch +
                    " creates dead code");
            }
            edu.umd.cs.findbugs.ba.BasicBlock target =
              infeasibleEdge.
              getTarget(
                );
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Target block is  " +
                    (target.
                       isExceptionThrower(
                         )
                       ? " exception thrower"
                       : " not exception thrower"));
            }
            boolean empty =
              !target.
              isExceptionThrower(
                ) &&
              (target.
                 isEmpty(
                   ) ||
                 isGoto(
                   target.
                     getFirstInstruction(
                       ).
                     getInstruction(
                       )));
            if (!empty) {
                try {
                    if (classContext.
                          getCFG(
                            method).
                          getNumIncomingEdges(
                            target) >
                          1) {
                        if (DEBUG) {
                            java.lang.System.
                              out.
                              println(
                                "Target of infeasible edge has multiple incoming edges");
                        }
                        empty =
                          true;
                    }
                }
                catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                    assert true;
                }
            }
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Target block is  " +
                    (empty
                       ? "empty"
                       : "not empty"));
            }
            if (!empty) {
                if (isThrower(
                      target)) {
                    infeasibleEdgeSimplyThrowsException =
                      true;
                }
            }
            if (!empty &&
                  !previouslyDeadBlocks.
                  get(
                    target.
                      getLabel(
                        ))) {
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "target was alive previously");
                }
                edu.umd.cs.findbugs.ba.npe.IsNullValueFrame invFrame =
                  invDataflow.
                  getStartFact(
                    target);
                createdDeadCode =
                  invFrame.
                    isTop(
                      );
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "target is now " +
                        (createdDeadCode
                           ? "dead"
                           : "alive"));
                }
            }
        }
        int priority;
        boolean valueIsNull =
          true;
        java.lang.String warning;
        int pc =
          location.
          getHandle(
            ).
          getPosition(
            );
        edu.umd.cs.findbugs.OpcodeStack stack =
          null;
        edu.umd.cs.findbugs.OpcodeStack.Item item1 =
          null;
        edu.umd.cs.findbugs.OpcodeStack.Item item2 =
          null;
        try {
            stack =
              edu.umd.cs.findbugs.ba.OpcodeStackScanner.
                getStackAt(
                  classContext.
                    getJavaClass(
                      ),
                  method,
                  pc);
            item1 =
              stack.
                getStackItem(
                  0);
        }
        catch (java.lang.RuntimeException e) {
            if (edu.umd.cs.findbugs.SystemProperties.
                  ASSERTIONS_ENABLED) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "Error getting stack at specific PC",
                    e);
            }
            assert true;
        }
        if (redundantBranch.
              secondValue ==
              null) {
            if (redundantBranch.
                  firstValue.
                  isDefinitelyNull(
                    )) {
                warning =
                  "RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE";
                priority =
                  NORMAL_PRIORITY;
            }
            else {
                warning =
                  "RCN_REDUNDANT_NULLCHECK_OF_NONNULL_VALUE";
                valueIsNull =
                  false;
                priority =
                  isChecked
                    ? HIGH_PRIORITY
                    : NORMAL_PRIORITY;
            }
            if (infeasibleEdgeSimplyThrowsException) {
                priority++;
            }
        }
        else {
            if (stack !=
                  null) {
                item2 =
                  stack.
                    getStackItem(
                      1);
            }
            boolean bothNull =
              redundantBranch.
                firstValue.
              isDefinitelyNull(
                ) &&
              redundantBranch.
                secondValue.
              isDefinitelyNull(
                );
            if (redundantBranch.
                  secondValue.
                  isChecked(
                    )) {
                isChecked =
                  true;
            }
            if (redundantBranch.
                  secondValue.
                  wouldHaveBeenAKaboom(
                    )) {
                wouldHaveBeenAKaboom =
                  true;
                locationOfKaBoom =
                  redundantBranch.
                    secondValue.
                    getLocationOfKaBoom(
                      );
            }
            if (bothNull) {
                warning =
                  "RCN_REDUNDANT_COMPARISON_TWO_NULL_VALUES";
                priority =
                  NORMAL_PRIORITY;
            }
            else {
                warning =
                  "RCN_REDUNDANT_COMPARISON_OF_NULL_AND_NONNULL_VALUE";
                priority =
                  isChecked
                    ? NORMAL_PRIORITY
                    : LOW_PRIORITY;
            }
        }
        if (wouldHaveBeenAKaboom) {
            priority =
              HIGH_PRIORITY;
            warning =
              "RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE";
            if (locationOfKaBoom ==
                  null) {
                throw new java.lang.NullPointerException(
                  "location of KaBoom is null");
            }
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                createdDeadCode +
                " " +
                infeasibleEdgeSimplyThrowsException +
                " " +
                valueIsNull +
                " " +
                priority);
        }
        if (createdDeadCode &&
              !infeasibleEdgeSimplyThrowsException) {
            priority +=
              0;
        }
        else
            if (createdDeadCode &&
                  infeasibleEdgeSimplyThrowsException) {
                if (valueIsNull) {
                    priority +=
                      0;
                }
                else {
                    priority +=
                      1;
                }
            }
            else {
                priority +=
                  1;
            }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "RCN " +
                priority +
                " " +
                redundantBranch.
                  firstValue +
                " =? " +
                redundantBranch.
                  secondValue +
                " : " +
                warning);
            if (isChecked) {
                java.lang.System.
                  out.
                  println(
                    "isChecked");
            }
            if (wouldHaveBeenAKaboom) {
                java.lang.System.
                  out.
                  println(
                    "wouldHaveBeenAKaboom");
            }
            if (createdDeadCode) {
                java.lang.System.
                  out.
                  println(
                    "createdDeadCode");
            }
        }
        if (priority >
              LOW_PRIORITY) {
            return;
        }
        edu.umd.cs.findbugs.BugAnnotation variableAnnotation =
          null;
        try {
            edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
              classContext.
              getValueNumberDataflow(
                method).
              getFactAtLocation(
                location);
            if (vnaFrame.
                  isValid(
                    )) {
                org.apache.bcel.generic.Instruction ins =
                  location.
                  getHandle(
                    ).
                  getInstruction(
                    );
                edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
                  vnaFrame.
                  getInstance(
                    ins,
                    classContext.
                      getConstantPoolGen(
                        ));
                if (valueNumber.
                      hasFlag(
                        edu.umd.cs.findbugs.ba.vna.ValueNumber.
                          CONSTANT_CLASS_OBJECT)) {
                    return;
                }
                variableAnnotation =
                  edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
                    findAnnotationFromValueNumber(
                      method,
                      location,
                      valueNumber,
                      vnaFrame,
                      "VALUE_OF");
                if (variableAnnotation instanceof edu.umd.cs.findbugs.LocalVariableAnnotation) {
                    edu.umd.cs.findbugs.LocalVariableAnnotation local =
                      (edu.umd.cs.findbugs.LocalVariableAnnotation)
                        variableAnnotation;
                    if (!local.
                          isNamed(
                            )) {
                        if ("RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE".
                              equals(
                                warning)) {
                            return;
                        }
                        priority++;
                    }
                }
            }
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            
        }
        catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
            
        }
        edu.umd.cs.findbugs.BugInstance bugInstance =
          new edu.umd.cs.findbugs.BugInstance(
          this,
          warning,
          priority).
          addClassAndMethod(
            classContext.
              getJavaClass(
                ),
            method);
        edu.umd.cs.findbugs.LocalVariableAnnotation fallback =
          new edu.umd.cs.findbugs.LocalVariableAnnotation(
          "?",
          -1,
          -1);
        boolean foundSource =
          bugInstance.
          tryAddingOptionalUniqueAnnotations(
            variableAnnotation,
            edu.umd.cs.findbugs.BugInstance.
              getFieldOrMethodValueSource(
                item1),
            edu.umd.cs.findbugs.BugInstance.
              getFieldOrMethodValueSource(
                item2));
        if (!foundSource) {
            if ("RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE".
                  equals(
                    warning)) {
                return;
            }
            bugInstance.
              setPriority(
                priority +
                  1);
            bugInstance.
              add(
                fallback);
        }
        if (wouldHaveBeenAKaboom) {
            bugInstance.
              addSourceLine(
                classContext,
                method,
                locationOfKaBoom);
        }
        if (edu.umd.cs.findbugs.FindBugsAnalysisFeatures.
              isRelaxedMode(
                )) {
            edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty> propertySet =
              new edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty>(
              );
            edu.umd.cs.findbugs.props.WarningPropertyUtil.
              addPropertiesForDataMining(
                propertySet,
                classContext,
                method,
                location);
            if (isChecked) {
                propertySet.
                  addProperty(
                    edu.umd.cs.findbugs.detect.NullDerefProperty.
                      CHECKED_VALUE);
            }
            if (wouldHaveBeenAKaboom) {
                propertySet.
                  addProperty(
                    edu.umd.cs.findbugs.detect.NullDerefProperty.
                      WOULD_HAVE_BEEN_A_KABOOM);
            }
            if (createdDeadCode) {
                propertySet.
                  addProperty(
                    edu.umd.cs.findbugs.detect.NullDerefProperty.
                      CREATED_DEAD_CODE);
            }
            propertySet.
              decorateBugInstance(
                bugInstance);
        }
        edu.umd.cs.findbugs.SourceLineAnnotation sourceLine =
          edu.umd.cs.findbugs.SourceLineAnnotation.
          fromVisitedInstruction(
            classContext,
            method,
            location);
        sourceLine.
          setDescription(
            "SOURCE_REDUNDANT_NULL_CHECK");
        bugAccumulator.
          accumulateBug(
            bugInstance,
            sourceLine);
    }
    edu.umd.cs.findbugs.BugAnnotation getVariableAnnotation(edu.umd.cs.findbugs.ba.Location location) {
        edu.umd.cs.findbugs.BugAnnotation variableAnnotation =
          null;
        try {
            edu.umd.cs.findbugs.ba.vna.ValueNumberFrame vnaFrame =
              classContext.
              getValueNumberDataflow(
                method).
              getFactAtLocation(
                location);
            if (vnaFrame.
                  isValid(
                    )) {
                org.apache.bcel.generic.Instruction ins =
                  location.
                  getHandle(
                    ).
                  getInstruction(
                    );
                edu.umd.cs.findbugs.ba.vna.ValueNumber valueNumber =
                  vnaFrame.
                  getInstance(
                    ins,
                    classContext.
                      getConstantPoolGen(
                        ));
                if (valueNumber.
                      hasFlag(
                        edu.umd.cs.findbugs.ba.vna.ValueNumber.
                          CONSTANT_CLASS_OBJECT)) {
                    return null;
                }
                variableAnnotation =
                  edu.umd.cs.findbugs.ba.vna.ValueNumberSourceInfo.
                    findAnnotationFromValueNumber(
                      method,
                      location,
                      valueNumber,
                      vnaFrame,
                      "VALUE_OF");
            }
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            
        }
        catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
            
        }
        return variableAnnotation;
    }
    private boolean isGoto(org.apache.bcel.generic.Instruction instruction) {
        return instruction.
          getOpcode(
            ) ==
          org.apache.bcel.Constants.
            GOTO ||
          instruction.
          getOpcode(
            ) ==
          org.apache.bcel.Constants.
            GOTO_W;
    }
    int minPC(java.util.Collection<edu.umd.cs.findbugs.ba.Location> locs) {
        int result =
          1000000;
        for (edu.umd.cs.findbugs.ba.Location l
              :
              locs) {
            if (result >
                  l.
                  getHandle(
                    ).
                  getPosition(
                    )) {
                result =
                  l.
                    getHandle(
                      ).
                    getPosition(
                      );
            }
        }
        return result;
    }
    int maxPC(java.util.Collection<edu.umd.cs.findbugs.ba.Location> locs) {
        int result =
          -1000000;
        for (edu.umd.cs.findbugs.ba.Location l
              :
              locs) {
            if (result <
                  l.
                  getHandle(
                    ).
                  getPosition(
                    )) {
                result =
                  l.
                    getHandle(
                      ).
                    getPosition(
                      );
            }
        }
        return result;
    }
    boolean callToAssertionMethod(edu.umd.cs.findbugs.ba.Location loc) {
        org.apache.bcel.generic.InstructionHandle h =
          loc.
          getHandle(
            );
        int firstPos =
          h.
          getPosition(
            );
        org.apache.bcel.classfile.LineNumberTable ln =
          method.
          getLineNumberTable(
            );
        int firstLine =
          ln ==
          null
          ? -1
          : ln.
          getSourceLine(
            firstPos);
        while (h !=
                 null) {
            int pos =
              h.
              getPosition(
                );
            if (ln ==
                  null) {
                if (pos >
                      firstPos +
                      15) {
                    break;
                }
            }
            else {
                int line =
                  ln.
                  getSourceLine(
                    pos);
                if (line !=
                      firstLine) {
                    break;
                }
            }
            org.apache.bcel.generic.Instruction i =
              h.
              getInstruction(
                );
            if (i instanceof org.apache.bcel.generic.InvokeInstruction) {
                org.apache.bcel.generic.InvokeInstruction ii =
                  (org.apache.bcel.generic.InvokeInstruction)
                    i;
                java.lang.String name =
                  ii.
                  getMethodName(
                    classContext.
                      getConstantPoolGen(
                        ));
                if (name.
                      startsWith(
                        "check") ||
                      name.
                      startsWith(
                        "assert")) {
                    return true;
                }
            }
            h =
              h.
                getNext(
                  );
        }
        return false;
    }
    @java.lang.Override
    public void foundGuaranteedNullDeref(@javax.annotation.Nonnull
                                         java.util.Set<edu.umd.cs.findbugs.ba.Location> assignedNullLocationSet,
                                         @javax.annotation.Nonnull
                                         java.util.Set<edu.umd.cs.findbugs.ba.Location> derefLocationSet,
                                         java.util.SortedSet<edu.umd.cs.findbugs.ba.Location> doomedLocations,
                                         edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow vna,
                                         edu.umd.cs.findbugs.ba.vna.ValueNumber refValue,
                                         @javax.annotation.CheckForNull
                                         edu.umd.cs.findbugs.BugAnnotation variableAnnotation,
                                         edu.umd.cs.findbugs.ba.npe.NullValueUnconditionalDeref deref,
                                         boolean npeIfStatementCovered) {
        if (refValue.
              hasFlag(
                edu.umd.cs.findbugs.ba.vna.ValueNumber.
                  CONSTANT_CLASS_OBJECT)) {
            return;
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Found guaranteed null deref in " +
                method.
                  getName(
                    ));
            for (edu.umd.cs.findbugs.ba.Location loc
                  :
                  doomedLocations) {
                java.lang.System.
                  out.
                  println(
                    "Doomed at " +
                    loc);
            }
        }
        java.lang.String bugType;
        int priority =
          npeIfStatementCovered
          ? HIGH_PRIORITY
          : NORMAL_PRIORITY;
        if (deref.
              isMethodReturnValue(
                )) {
            if (deref.
                  isReadlineValue(
                    )) {
                bugType =
                  "NP_DEREFERENCE_OF_READLINE_VALUE";
            }
            else {
                bugType =
                  "NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE";
            }
        }
        else
            if (derefLocationSet.
                  size(
                    ) >
                  1) {
                if (!deref.
                      isAlwaysOnExceptionPath(
                        )) {
                    bugType =
                      "NP_GUARANTEED_DEREF";
                }
                else {
                    bugType =
                      "NP_GUARANTEED_DEREF_ON_EXCEPTION_PATH";
                }
            }
            else
                if (!deref.
                      isAlwaysOnExceptionPath(
                        )) {
                    bugType =
                      "NP_NULL_ON_SOME_PATH";
                }
                else {
                    bugType =
                      "NP_NULL_ON_SOME_PATH_EXCEPTION";
                }
        boolean allCallToAssertionMethod =
          !doomedLocations.
          isEmpty(
            );
        for (edu.umd.cs.findbugs.ba.Location loc
              :
              doomedLocations) {
            if (!callToAssertionMethod(
                   loc)) {
                allCallToAssertionMethod =
                  false;
            }
        }
        if (allCallToAssertionMethod) {
            return;
        }
        java.util.SortedSet<edu.umd.cs.findbugs.ba.Location> sourceLocations;
        if (doomedLocations.
              isEmpty(
                ) ||
              doomedLocations.
              size(
                ) >
              3 &&
              doomedLocations.
              size(
                ) >
              assignedNullLocationSet.
              size(
                )) {
            sourceLocations =
              new java.util.TreeSet<edu.umd.cs.findbugs.ba.Location>(
                assignedNullLocationSet);
        }
        else {
            sourceLocations =
              doomedLocations;
        }
        if (doomedLocations.
              isEmpty(
                ) ||
              derefLocationSet.
              isEmpty(
                )) {
            return;
        }
        edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty> propertySet =
          new edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty>(
          );
        addPropertiesForDereferenceLocations(
          propertySet,
          derefLocationSet,
          false);
        int minDereferencePC =
          minPC(
            derefLocationSet);
        int distance1 =
          minDereferencePC -
          maxPC(
            assignedNullLocationSet);
        int distance2 =
          minDereferencePC -
          maxPC(
            doomedLocations);
        int distance =
          java.lang.Math.
          max(
            distance1,
            distance2);
        java.util.BitSet knownNull =
          new java.util.BitSet(
          );
        java.util.SortedSet<edu.umd.cs.findbugs.SourceLineAnnotation> knownNullLocations =
          new java.util.TreeSet<edu.umd.cs.findbugs.SourceLineAnnotation>(
          );
        for (edu.umd.cs.findbugs.ba.Location loc
              :
              sourceLocations) {
            edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation =
              edu.umd.cs.findbugs.SourceLineAnnotation.
              fromVisitedInstruction(
                classContext,
                method,
                loc);
            if (sourceLineAnnotation ==
                  null) {
                continue;
            }
            int startLine =
              sourceLineAnnotation.
              getStartLine(
                );
            if (startLine ==
                  -1) {
                knownNullLocations.
                  add(
                    sourceLineAnnotation);
            }
            else
                if (!knownNull.
                      get(
                        startLine)) {
                    knownNull.
                      set(
                        startLine);
                    knownNullLocations.
                      add(
                        sourceLineAnnotation);
                }
        }
        edu.umd.cs.findbugs.FieldAnnotation storedField =
          null;
        edu.umd.cs.findbugs.MethodAnnotation invokedMethod =
          null;
        edu.umd.cs.findbugs.ba.XMethod invokedXMethod =
          null;
        int parameterNumber =
          -1;
        if (derefLocationSet.
              size(
                ) ==
              1) {
            edu.umd.cs.findbugs.ba.Location loc =
              derefLocationSet.
              iterator(
                ).
              next(
                );
            edu.umd.cs.findbugs.ba.npe.PointerUsageRequiringNonNullValue pu =
              null;
            try {
                edu.umd.cs.findbugs.ba.npe.UsagesRequiringNonNullValues usages =
                  classContext.
                  getUsagesRequiringNonNullValues(
                    method);
                pu =
                  usages.
                    get(
                      loc,
                      refValue,
                      vnaDataflow);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "Error getting UsagesRequiringNonNullValues for " +
                    method,
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "Error getting UsagesRequiringNonNullValues for " +
                    method,
                    e);
            }
            if (pu ==
                  null) {
                assert true;
            }
            else
                if (deref.
                      isReadlineValue(
                        )) {
                    bugType =
                      "NP_DEREFERENCE_OF_READLINE_VALUE";
                    priority =
                      NORMAL_PRIORITY;
                }
                else
                    if (deref.
                          isMethodReturnValue(
                            ) &&
                          !deref.
                          isReadlineValue(
                            )) {
                        bugType =
                          "NP_NULL_ON_SOME_PATH_FROM_RETURN_VALUE";
                        priority =
                          NORMAL_PRIORITY;
                    }
                    else
                        if (pu.
                              isReturnFromNonNullMethod(
                                )) {
                            bugType =
                              "NP_NONNULL_RETURN_VIOLATION";
                            java.lang.String methodName =
                              method.
                              getName(
                                );
                            java.lang.String methodSig =
                              method.
                              getSignature(
                                );
                            if ("clone".
                                  equals(
                                    methodName) &&
                                  "()Ljava/lang/Object;".
                                  equals(
                                    methodSig)) {
                                bugType =
                                  "NP_CLONE_COULD_RETURN_NULL";
                                priority =
                                  NORMAL_PRIORITY;
                            }
                            else
                                if ("toString".
                                      equals(
                                        methodName) &&
                                      "()Ljava/lang/String;".
                                      equals(
                                        methodSig)) {
                                    bugType =
                                      "NP_TOSTRING_COULD_RETURN_NULL";
                                    priority =
                                      NORMAL_PRIORITY;
                                }
                        }
                        else {
                            edu.umd.cs.findbugs.ba.XField f =
                              pu.
                              getNonNullField(
                                );
                            if (f !=
                                  null) {
                                storedField =
                                  edu.umd.cs.findbugs.FieldAnnotation.
                                    fromXField(
                                      f);
                                bugType =
                                  "NP_STORE_INTO_NONNULL_FIELD";
                            }
                            else {
                                edu.umd.cs.findbugs.ba.XMethodParameter mp =
                                  pu.
                                  getNonNullParameter(
                                    );
                                if (mp !=
                                      null) {
                                    invokedXMethod =
                                      mp.
                                        getMethod(
                                          );
                                    for (edu.umd.cs.findbugs.ba.Location derefLoc
                                          :
                                          derefLocationSet) {
                                        if (safeCallToPrimateParseMethod(
                                              invokedXMethod,
                                              derefLoc)) {
                                            return;
                                        }
                                    }
                                    invokedMethod =
                                      edu.umd.cs.findbugs.MethodAnnotation.
                                        fromXMethod(
                                          mp.
                                            getMethod(
                                              ));
                                    if (mp.
                                          getParameterNumber(
                                            ) ==
                                          0 &&
                                          edu.umd.cs.findbugs.ba.npe.TypeQualifierNullnessAnnotationDatabase.
                                          assertsFirstParameterIsNonnull(
                                            invokedXMethod)) {
                                        return;
                                    }
                                    parameterNumber =
                                      mp.
                                        getParameterNumber(
                                          );
                                    bugType =
                                      "NP_NULL_PARAM_DEREF";
                                }
                            }
                        }
        }
        boolean hasManyNullTests =
          true;
        for (edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation
              :
              knownNullLocations) {
            if (!hasManyPreceedingNullTests(
                   sourceLineAnnotation.
                     getStartBytecode(
                       ))) {
                hasManyNullTests =
                  false;
            }
        }
        if (hasManyNullTests) {
            if ("NP_NULL_ON_SOME_PATH".
                  equals(
                    bugType) ||
                  "NP_GUARANTEED_DEREF".
                  equals(
                    bugType)) {
                bugType =
                  "NP_NULL_ON_SOME_PATH_MIGHT_BE_INFEASIBLE";
            }
            else {
                priority++;
            }
        }
        edu.umd.cs.findbugs.BugInstance bugInstance =
          new edu.umd.cs.findbugs.BugInstance(
          this,
          bugType,
          priority).
          addClassAndMethod(
            classContext.
              getJavaClass(
                ),
            method);
        if (invokedMethod !=
              null) {
            assert invokedXMethod !=
              null;
            edu.umd.cs.findbugs.ba.XMethod i =
              invokedXMethod.
              resolveAccessMethodForMethod(
                );
            if (i !=
                  invokedXMethod) {
                bugInstance.
                  addMethod(
                    i).
                  describe(
                    edu.umd.cs.findbugs.MethodAnnotation.
                      METHOD_CALLED);
            }
            else {
                bugInstance.
                  addMethod(
                    invokedMethod).
                  describe(
                    edu.umd.cs.findbugs.MethodAnnotation.
                      METHOD_CALLED).
                  addParameterAnnotation(
                    parameterNumber,
                    "INT_MAYBE_NULL_ARG");
            }
        }
        if (storedField !=
              null) {
            bugInstance.
              addField(
                storedField).
              describe(
                "FIELD_STORED");
        }
        bugInstance.
          addOptionalAnnotation(
            variableAnnotation);
        if (variableAnnotation instanceof edu.umd.cs.findbugs.FieldAnnotation) {
            bugInstance.
              describe(
                "FIELD_CONTAINS_VALUE");
        }
        addPropertiesForDereferenceLocations(
          propertySet,
          derefLocationSet,
          false);
        if (deref.
              isAlwaysOnExceptionPath(
                )) {
            propertySet.
              addProperty(
                edu.umd.cs.findbugs.detect.NullDerefProperty.
                  ALWAYS_ON_EXCEPTION_PATH);
        }
        if (!assignedNullLocationSet.
              isEmpty(
                ) &&
              distance >
              100) {
            propertySet.
              addProperty(
                edu.umd.cs.findbugs.detect.NullDerefProperty.
                  LONG_RANGE_NULL_SOURCE);
        }
        propertySet.
          decorateBugInstance(
            bugInstance);
        if ("NP_DEREFERENCE_OF_READLINE_VALUE".
              equals(
                bugType)) {
            int source =
              -9999;
            if (knownNullLocations.
                  size(
                    ) ==
                  1) {
                source =
                  knownNullLocations.
                    iterator(
                      ).
                    next(
                      ).
                    getEndBytecode(
                      );
            }
            for (edu.umd.cs.findbugs.ba.Location loc
                  :
                  derefLocationSet) {
                int pos =
                  loc.
                  getHandle(
                    ).
                  getPosition(
                    );
                if (pos !=
                      source +
                      3) {
                    bugAccumulator.
                      accumulateBug(
                        bugInstance,
                        edu.umd.cs.findbugs.SourceLineAnnotation.
                          fromVisitedInstruction(
                            classContext,
                            method,
                            loc));
                }
            }
        }
        else {
            for (edu.umd.cs.findbugs.ba.Location loc
                  :
                  derefLocationSet) {
                bugInstance.
                  addSourceLine(
                    classContext,
                    method,
                    loc).
                  describe(
                    getDescription(
                      loc,
                      refValue));
            }
            if (sourceLocations ==
                  doomedLocations &&
                  assignedNullLocationSet.
                  size(
                    ) ==
                  1) {
                edu.umd.cs.findbugs.ba.Location assignedNull =
                  assignedNullLocationSet.
                  iterator(
                    ).
                  next(
                    );
                edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation =
                  edu.umd.cs.findbugs.SourceLineAnnotation.
                  fromVisitedInstruction(
                    classContext,
                    method,
                    assignedNull);
                if (sourceLineAnnotation !=
                      null) {
                    int startLine =
                      sourceLineAnnotation.
                      getStartLine(
                        );
                    if (startLine >
                          0 &&
                          !knownNull.
                          get(
                            startLine)) {
                        bugInstance.
                          add(
                            sourceLineAnnotation).
                          describe(
                            "SOURCE_LINE_NULL_VALUE");
                    }
                }
            }
            for (edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation
                  :
                  knownNullLocations) {
                bugInstance.
                  add(
                    sourceLineAnnotation).
                  describe(
                    "SOURCE_LINE_KNOWN_NULL");
            }
            bugReporter.
              reportBug(
                bugInstance);
        }
    }
    private void addPropertiesForDereferenceLocations(edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty> propertySet,
                                                      java.util.Collection<edu.umd.cs.findbugs.ba.Location> derefLocationSet,
                                                      boolean isConsistent) {
        boolean derefOutsideCatchBlock =
          false;
        boolean derefOutsideCatchNullBlock =
          false;
        boolean allDerefsAtDoomedLocations =
          true;
        for (edu.umd.cs.findbugs.ba.Location loc
              :
              derefLocationSet) {
            if (!inExplictCatchNullBlock(
                   loc)) {
                derefOutsideCatchNullBlock =
                  true;
                if (!inIndirectCatchNullBlock(
                       loc)) {
                    derefOutsideCatchBlock =
                      true;
                }
            }
            if (!isDoomed(
                   loc)) {
                allDerefsAtDoomedLocations =
                  false;
            }
        }
        if (!derefOutsideCatchNullBlock) {
            propertySet.
              addProperty(
                edu.umd.cs.findbugs.props.GeneralWarningProperty.
                  FALSE_POSITIVE);
            return;
        }
        if (allDerefsAtDoomedLocations) {
            propertySet.
              addProperty(
                edu.umd.cs.findbugs.detect.DoomedCodeWarningProperty.
                  DOOMED_CODE);
        }
        boolean uniqueDereferenceLocations =
          uniqueLocations(
            derefLocationSet);
        if (!derefOutsideCatchBlock) {
            if (!uniqueDereferenceLocations ||
                  skipIfInsideCatchNull(
                    )) {
                propertySet.
                  addProperty(
                    edu.umd.cs.findbugs.props.GeneralWarningProperty.
                      FALSE_POSITIVE);
            }
            else {
                propertySet.
                  addProperty(
                    edu.umd.cs.findbugs.detect.NullDerefProperty.
                      DEREFS_IN_CATCH_BLOCKS);
            }
        }
        if (!isConsistent &&
              !uniqueDereferenceLocations) {
            propertySet.
              addProperty(
                edu.umd.cs.findbugs.detect.NullDerefProperty.
                  DEREFS_ARE_CLONED);
        }
        addPropertiesForMethodContainingWarning(
          propertySet);
    }
    private boolean uniqueLocations(java.util.Collection<edu.umd.cs.findbugs.ba.Location> derefLocationSet) {
        boolean uniqueDereferenceLocations =
          false;
        org.apache.bcel.classfile.CodeException[] exceptionTable =
          method.
          getCode(
            ).
          getExceptionTable(
            );
        if (exceptionTable ==
              null) {
            return true;
        }
        checkForCatchAll: {
            for (org.apache.bcel.classfile.CodeException e
                  :
                  exceptionTable) {
                if (e.
                      getCatchType(
                        ) ==
                      0) {
                    break checkForCatchAll;
                }
            }
            return true;
        }
        org.apache.bcel.classfile.LineNumberTable table =
          method.
          getLineNumberTable(
            );
        if (table ==
              null) {
            uniqueDereferenceLocations =
              true;
        }
        else {
            java.util.BitSet linesMentionedMultipleTimes =
              classContext.
              linesMentionedMultipleTimes(
                method);
            for (edu.umd.cs.findbugs.ba.Location loc
                  :
                  derefLocationSet) {
                int lineNumber =
                  table.
                  getSourceLine(
                    loc.
                      getHandle(
                        ).
                      getPosition(
                        ));
                if (lineNumber >
                      0 &&
                      !linesMentionedMultipleTimes.
                      get(
                        lineNumber)) {
                    uniqueDereferenceLocations =
                      true;
                }
            }
        }
        return uniqueDereferenceLocations;
    }
    private void addPropertiesForMethodContainingWarning(edu.umd.cs.findbugs.props.WarningPropertySet<edu.umd.cs.findbugs.props.WarningProperty> propertySet) {
        edu.umd.cs.findbugs.ba.XMethod xMethod =
          edu.umd.cs.findbugs.ba.XFactory.
          createXMethod(
            classContext.
              getJavaClass(
                ),
            method);
        boolean uncallable =
          !edu.umd.cs.findbugs.ba.AnalysisContext.
          currentXFactory(
            ).
          isCalledDirectlyOrIndirectly(
            xMethod) &&
          xMethod.
          isPrivate(
            );
        if (uncallable) {
            propertySet.
              addProperty(
                edu.umd.cs.findbugs.props.GeneralWarningProperty.
                  IN_UNCALLABLE_METHOD);
        }
    }
    private boolean isDoomed(edu.umd.cs.findbugs.ba.Location loc) {
        if (!MARK_DOOMED) {
            return false;
        }
        edu.umd.cs.findbugs.ba.npe.ReturnPathTypeDataflow rptDataflow;
        try {
            rptDataflow =
              classContext.
                getReturnPathTypeDataflow(
                  method);
            edu.umd.cs.findbugs.ba.npe.ReturnPathType rpt =
              rptDataflow.
              getFactAtLocation(
                loc);
            return !rpt.
              canReturnNormally(
                );
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Error getting return path type",
                e);
            return false;
        }
    }
    java.lang.String getDescription(edu.umd.cs.findbugs.ba.Location loc,
                                    edu.umd.cs.findbugs.ba.vna.ValueNumber refValue) {
        edu.umd.cs.findbugs.ba.npe.PointerUsageRequiringNonNullValue pu;
        try {
            edu.umd.cs.findbugs.ba.npe.UsagesRequiringNonNullValues usages =
              classContext.
              getUsagesRequiringNonNullValues(
                method);
            pu =
              usages.
                get(
                  loc,
                  refValue,
                  vnaDataflow);
            if (pu ==
                  null) {
                return "SOURCE_LINE_DEREF";
            }
            return pu.
              getDescription(
                );
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Error getting UsagesRequiringNonNullValues for " +
                method,
                e);
            return "SOURCE_LINE_DEREF";
        }
        catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Error getting UsagesRequiringNonNullValues for " +
                method,
                e);
            return "SOURCE_LINE_DEREF";
        }
    }
    boolean inExplictCatchNullBlock(edu.umd.cs.findbugs.ba.Location loc) {
        int pc =
          loc.
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
            "java/lang/NullPointerException",
            pc);
        if (catchSize <
              java.lang.Integer.
                MAX_VALUE) {
            return true;
        }
        return false;
    }
    boolean inIndirectCatchNullBlock(edu.umd.cs.findbugs.ba.Location loc) {
        int pc =
          loc.
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
            "java/lang/Exception",
            pc);
        if (catchSize <
              5) {
            return true;
        }
        catchSize =
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
              "java/lang/RuntimeException",
              pc);
        if (catchSize <
              5) {
            return true;
        }
        catchSize =
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
              "java/lang/Throwable",
              pc);
        if (catchSize <
              5) {
            return true;
        }
        return false;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVcC3QUVZq+3Z0XSUhIeD/kGVAediOOuIg65gnRJglJiBqU" +
       "UKmuJCWdqqbqdmgY8TXHA+MqIoOKLw7HxUFRxN3V47iOrLOe8THq7Oq6KzoD" +
       "Ou6e0dHhjJ7xMUdG3f+/VdVVXV23kkbb5Zy6aaruf+t+3/3v///3v1X1yAlS" +
       "qGtkuqTQMN2ckPRwo0LbBE2XYvVxQdc74VyPeGdI+Mu6D1qWBUlRN6kYEPRV" +
       "oqBLTbIUj+nd5DRZ0amgiJLeIkkxlGjTJF3ShgQqq0o3GS/rzYOJuCzKdJUa" +
       "k7BCl6BFSZVAqSb3JqnUbDZAyWlR6EmE9SRS6768PErKRTWx2a4+yVG93nEF" +
       "aw7a99IpGRO9ShgSIkkqxyNRWafLUxpZmFDjm/vjKg1LKRq+Kn6OScHF0XOy" +
       "KJj9WOXnJ3cOjGEUjBUURaUMnt4u6Wp8SIpFSaV9tjEuDeobyTUkFCVljsqU" +
       "1EStm0bgphG4qYXWrgW9Hy0pycF6lcGhVktFCRE7RMmszEYSgiYMms20sT5D" +
       "CyXUxM6EAe3MNFoDZRbE2xdGdt+5bsw/hUhlN6mUlQ7sjgidoHCTbiBUGuyV" +
       "NL02FpNi3aRKgcHukDRZiMtbzJGu1uV+RaBJGH6LFjyZTEgau6fNFYwjYNOS" +
       "IlW1NLw+plDm/wr74kI/YJ1gYzUQNuF5AFgqQ8e0PgH0zhQp2CArMUpmuCXS" +
       "GGsugQogWjwo0QE1fasCRYATpNpQkbig9Ec6QPWUfqhaqIICapRM4TaKXCcE" +
       "cYPQL/WgRrrqtRmXoNYoRgSKUDLeXY21BKM0xTVKjvE50XL+jh8pK5UgCUCf" +
       "Y5IYx/6XgdB0l1C71CdpEswDQ7B8QfQOYcIz24OEQOXxrspGnSev/uSiRdOf" +
       "fdGoM9WjTmvvVZJIe8T9vRWvTaufvyyE3ShJqLqMg5+BnM2yNvPK8lQCLMyE" +
       "dIt4MWxdfLb9+cuvOyh9FCSlzaRIVOPJQdCjKlEdTMhxSVshKZImUCnWTEZJ" +
       "SqyeXW8mxfA7KiuScba1r0+XaDMpiLNTRSr7P1DUB00gRaXwW1b6VOt3QqAD" +
       "7HcqQQgphoOocNxEjH/sLyU9kQF1UIoIoqDIihpp01TEr0fA4vQCtwORPlCm" +
       "3mS/HtE1McJUR4olI8nBWETU7YsxiYJYpAn+35KMxxtgYPrCWDuR/1ukEOXY" +
       "TYEADMA09/SPw8xZqcZjktYj7k7WNX7yaM/LhmrhdDD5oeQMuGMY7hgW9bB1" +
       "x7Bxx3DGHUkgwG40Du9sjDKM0QaY7WBuy+d3XHnx+u2zQ6BeiU0FQDBWnZ3h" +
       "duptk2DZ8R7xcPXoLbOOn/VckBRESbUg0qQQRy9Sq/WDfRI3mFO4vBccku0X" +
       "Zjr8Ajo0TRUBhibx/IPZSok6JGl4npJxjhYsr4XzM8L3GZ79J8/u2XR917WL" +
       "gySY6QrwloVgxVC8DQ142lDXuE2AV7uV2z74/PAdW1XbGGT4FsslZkkihtlu" +
       "VXDT0yMumCk80fPM1hpG+ygw1lSAyQV2cLr7Hhm2ZrlltxFLCQDuU7VBIY6X" +
       "LI5L6YCmbrLPMB2tYr/HgVqU4eSbBMc/mrOR/cWrExJYTjR0GvXMhYL5hQs6" +
       "Evcd/c0fz2Z0Wy6k0uH7OyS63GG2sLFqZqCqbLXt1CQJ6h3b0/bT209sW8t0" +
       "FmrM8bphDZb1YK5gCIHmG1/c+NY7x/e/EbT1nILfTvZC+JNKg8TzpNQHJNxt" +
       "nt0fMHtxmG6oNTVrFNBPuU8WeuMSTqy/Vc4964k/7Rhj6EEczlhqtGj4Buzz" +
       "k+vIdS+v+2I6ayYgotu1ObOrGbZ8rN1yraYJm7EfqetfP+2uF4T7wCuAJdbl" +
       "LRIzrgFzrmOnJoFr9jImdcn+dimhauBn2eCew2ovZuUPkBjWBmHXlmExV3dO" +
       "ksx56AijesSdb3w8uuvjI58wVJlxmFMnVgmJ5YYaYjEvBc1PdBuxlYI+APV+" +
       "8GzLFWPiz56EFruhRRGCD71VAxuaytAgs3Zh8du/fG7C+tdCJNhESuOqEGsS" +
       "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" +
       "bGpujDJfehMj6V5uiBVoZBX2YXEnJVNMFtuStM96psWcGy5C9+SLUAg7g2VG" +
       "m8bfnAjlivIZ2M4YeHhEnvgQFj8DT2zylGVBXCwdyANLbG0Yhr4tMaEuyZ0l" +
       "nqg3S+z/HViYobQrrA7J5vI2a3HNSPu5j3H+Vyz+GRQPX8gQlM0Q3YiSFJOV" +
       "fnRfnZJuNLzGpvTxPFCKmy9kLvCx2uRltQ+lrHTvgBoJ1ewdUG6L/qZ6Hn+L" +
       "xmmErerT/aqzVaup5S/7DMVrWPyKkjKW45XYxomL++fzpc6LgaF1JlPrcldn" +
       "nqj3nE6zxvFbl9mrDoO13/mw9i4Wb1IyTRf6mPPpVPEZKYFK7N0Ue0PNQePR" +
       "fNnO9YDuGpOLrbnTuJUj6oJfxDpSxPjB4iYsbrZYnc9zS83KkLpByrSV5Bgr" +
       "GJMfDWOBd7Jaf8biD5TMZdHcGufuOq6INGtjIMZSKi5z/H6+iN8Mc3eS0abx" +
       "NyfiuaLDRQEfp5tiL4DgjtA8oynjLyXid/N2RkJTE3rkUkFTjLw0e/wAk8Dm" +
       "SyDfx22MAfkc0f8tvZGxyGsOs2bC2c2ATNAY569Y6bVjgM2H0rTOxMvL3LRi" +
       "na9whAJfM50sZw2zlHRnehqMuGPYRLB4RLlq30i+LtlvZftYr77kW60gbgcF" +
       "PoOoOSaJKj6MavbJNV8+z9d8kUCNZ5pKPyP3+TKDI+pCXMg6UmgZKtPYGDPH" +
       "oUamSrFBHIGKYJUCnb9fdKkcj9ULWszYv3vgm1FzLpr40nks/Zu9LeO3FUPM" +
       "REOdg6yZbrIslfDclTBfcUJPXqv1JwdhOrqUzxLP3kEZ4d5JsIyVk32U7Qws" +
       "xlEyVogZVjlz49yhcMHxefSMoXaTQ7/gjqNwqzmiI/KMWPwp09kFz/bh6xws" +
       "wrjZji6uRVVw/DzcWTCSB7asd5dC5hOhoaxnTR1suUNhXuqf25gPC7U+1+qx" +
       "WE5JkcYegnTRcj43rY8V/47P2bdMH58BAO8ygd41jI4tzOaIJ+rDQ6vPtdVY" +
       "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" +
       "mYU3Wl0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL29C7Ds2lke2Gefe899+t7ra4MvjrkP32tju83ph7pbLa6d" +
       "sbqlVj/0arWkbnUSH+vd6tar9eiWZOwANQmUSYwHjGMCGFdiFzGxMZkZhnnh" +
       "cYqawZ7AzJCCmdgUYBimIDCeiis8UiETZknd+9Vn733O8TnMrtLaammtpf/7" +
       "/3/96/+X1lr67NdLD4dBqex7dmraXnRTT6KbS7t5M0p9Pbw5JJusHIS61rXl" +
       "MOTBtVvqm3/u6T/7i48snjkq3ZiXXie7rhfJkeW5IaeHnr3RNbL09OlV3Nad" +
       "MCo9Qy7ljVyJI8uukFYYvUqWnjhTNCq9Qh6TUAEkVAAJlYKECnqaCxR6je7G" +
       "TjcvIbtRuC59sHSNLN3w1Zy8qPTS+Up8OZCdfTVsgQDU8Gj+WwSgisJJUHrx" +
       "BPsO822Af7Rc+eg/eO8z//n10tPz0tOWO8nJUQEREXjIvPSkozuKHoSopuna" +
       "vPRaV9e1iR5Ysm1lBd3z0rOhZbpyFAf6CZPyi7GvB8UzTzn3pJpjC2I18oIT" +
       "eIal29rxr4cNWzYB1m89xbpD2MuvA4CPW4CwwJBV/bjIQyvL1aLSC4clTjC+" +
       "MgIZQNFHHD1aeCePesiVwYXSszvZ2bJrViZRYLkmyPqwF4OnRKU3Xlppzmtf" +
       "Vleyqd+KSs8d5mN3t0CuxwpG5EWi0rccZitqAlJ644GUzsjn6/S7Pvx+t+8e" +
       "FTRrumrn9D8KCj1/UIjTDT3QXVXfFXzyHeTH5G/9xR84KpVA5m85yLzL8wvf" +
       "/Y33vPP5L35pl+evXZCHUZa6Gt1SP6U89Wtv6r4duZ6T8ajvhVYu/HPIC/Vn" +
       "93deTXzQ8r71pMb85s3jm1/k/ifpe35G/+Oj0uOD0g3Vs2MH6NFrVc/xLVsP" +
       "CN3VAznStUHpMd3VusX9QekRcE5arr67yhhGqEeD0kN2cemGV/wGLDJAFTmL" +
       "HgHnlmt4x+e+HC2K88QvlUqPgKPkgeNDpd1f8T8q3aosPEevyKrsWq5XYQMv" +
       "xx9WdDdSAG8XFQMokxKbYSUM1EqhOroWV2JHq6jh6U1Nj0CxSg/8pmPbxoBg" +
       "jJt5bv+v/hFJjvKZ7bVrQABvOmz+Nmg5fc/W9OCW+tG4g3/jZ2/9i6OT5rDn" +
       "T1R6G3jiTfDEm2p48/iJN3dPvHnuiaVr14oHvT5/8k7KQEYr0NqBHXzy7ZO/" +
       "NXzfD7z5OlAvf/sQYHCetXK5Oe6e2odBYQVVoKSlL358+73i364elY7O29Wc" +
       "WnDp8bw4m1vDE6v3ymF7uqjep7//D//s8x/7gHfass4Z6n2Dv71k3mDffMjX" +
       "wFMBywL9tPp3vCj//K1f/MArR6WHgBUAli+SgaYCo/L84TPONdxXj41gjuVh" +
       "ANjwAke281vHluvxaBF429MrhcCfKs5fC3j8RK7Jz4Hjn+1Vu/if332dn6ev" +
       "3ylILrQDFIWRfffE/8l/9b/8a6hg97E9fvpMDzfRo1fP2IC8sqeL1v7aUx3g" +
       "A10H+X7r4+yP/OjXv/9vFAoAcrx80QNfydMuaPtAhIDNf+dL66/8zm9/6teP" +
       "TpUmAp1grNiWmpyAzK+XHr8CJHjaW0/pATbEBrqba80rgut4mmVYsmLruZb+" +
       "h6ffUvv5//vDz+z0wAZXjtXonXeu4PT6t3VK3/Mv3vvnzxfVXFPzPuyUZ6fZ" +
       "dobxdac1o0Egpzkdyff+y2//sV+WfxKYWGDWQivTC0t1bd9wcqK+BfRzF7XM" +
       "Tmxyuu8FoNMqhFspcr+jSG/mjCnqKBX3oDx5ITzbSM63wzM+yS31I7/+b14j" +
       "/psvfKNAdd6pOasTlOy/ulPDPHkxAdW/4dAi9OVwAfI1vkj/zWfsL/4FqHEO" +
       "alRBTx4yATBIyTkN2ud++JGv/vNf+tb3/dr10lGv9LjtyVpPLhpj6THQCvRw" +
       "AWxZ4v8n79kpwfZRkDxTQC3dBn6nPM8Vv3L1ePvldqiX+ySnTfm5f8/Yyvf9" +
       "3r+7jQmFBbqgKz4oP6989ife2P3rf1yUPzUFeennk9uNNPDfTsvWf8b506M3" +
       "3/gfj0qPzEvPqHvnUJTtOG9gc+AQhcceI3Agz90/79zsevJXT0zdmw7N0JnH" +
       "Hhqh084BnOe58/PHD+xObnJKY3D8vX2T/HuHdudaqThBiyIvFekrefIdhUyu" +
       "56dvA209LFzQCJBgubK9b/N/Cf6ugeM/5kdecX5h12c/2907Di+eeA4+6MMe" +
       "xvCOQFwtaDawHGDFNnufqfKBZ39n9RN/+LmdP3Qo1YPM+g989EN/efPDHz06" +
       "44W+fJsjeLbMzhMt2PaaPCHydvLSVU8pSvT+4PMf+O/+yQe+f0fVs+d9KhyE" +
       "DJ/73//fX7n58a99+YKO/BHF82xddncmP08bedLZcRW+tOG860Ss35ZfVcDx" +
       "4b1YP3yJWPlLxAqI8ANrA8SSX8TzpFfwgIhKrylkdIsWSBLliPwidUCpcI+U" +
       "LsDxkT2lH7mE0r95hQLObifymVMiOZwXOPoiOv/WPdKpguOH93T+8CV0qvdG" +
       "5xMUyo1uYQxD4dhFJGr3SCIPjo/tSfzYJSQu743EGxTO9xnsuDN7prD3uXm6" +
       "uYu9Dihe3SPFHDg+vqf445dQHN4bxQ93SXQyyX94B8RFd0/cs/nVd4Djx/fE" +
       "/fglxGUXE3d0QtypsJXTPj+/VD2g7v33SF0VHD+5p+4nL6Hue++auqcAdaiq" +
       "xk5sy8fBPpD3my9xXs5kPYDxfXcP48n8Kg2OT+5hfPISGB+6GMa1AsYxghdi" +
       "F3SmWuHiyrtYp4gxMDmSFTnUjyG96yJIinzT9fWbRQEQNAV5uOQCPweECcWo" +
       "yHElB2B/8B7Bfic4/tEe7D+6BOyP3A3YZ9SFrgIX7Ry4Q/Px0Xuk7q3g+PSe" +
       "uk9fQt0/vBvqniwGwPZDUsd8f/kSvnfP5D0A8OP3COCN4PjpPYCfvgTAP74b" +
       "ADfOjDwB0l/0AvOm7MuA6TcVVbdvFvjycYubVJHxgO5P3SPd7wTHZ/Z0f+YS" +
       "uj97N3Q/YbmbXCUM29seE3/zCn0fhLmiF77ncbEDKJ/7JqD80z2Uf3oJlJ+/" +
       "KygbV75bKCDrzQIEHedjn5dA+a/uEcrbwPG5PZTPXQLlC3cD5fV+oG8sLw7t" +
       "FNNlrWN76io836MWnmHHikCEcED1/3CPVOfdwuf3VH/+Eqp/+a5MzK4NoOeD" +
       "J0Dx2y+RwrHNPC1xAOVLdw+lCE100FMxu6xH9CVQ/rerQpM8Oe8cvFaVI3VR" +
       "jMT0vMLKA4f+HZeHG5NYCaMzg7t/3/rEr/7Pf/r09+48+/NxSjG+vy96WO4r" +
       "/+p6/YnolR8qxmgeOu5JHgVRW5jnBCbm8ncFRV27IOSJ09CqdHFo9bpzwz47" +
       "Q+X7ybHsXnOqbXtV+81zEc3FDLilDpxbk5//yve3ioDl6Y0VWiBm4/evLs6P" +
       "nJyOJr567nXGhSy6pf7h5//+l176I/F1xTj1jhs5Wc3EL2hu75XlWqEsR6Xd" +
       "iORbLiF4T1Ex0HNL/e6f+I+/+q8/8Ntfvl66QZYez4NoOdBBlA8MyWWvd85W" +
       "8AoPzjBQCgTXT+1KA4e3EOpeeM+eXD0ZToxK33lZ3UX0ejDqmL8gAZZKDzpe" +
       "7BbdyPPng/fHY98/e7dQgye/WTX4YFB6512w7gT53o7kDieQ5VOnzn8exJ69" +
       "CQLX1xV+9y1eYvFbIsoN0A5ZtL3fzEP7a/gFEcRugKNA5J0b7CklB5bj185b" +
       "jidPLMfJKFvrIqNUvHoCzuAZG3bz5HXZ6Tu7Cw3SsUkqDEdy7RoILOo34ZuF" +
       "1/6n92Z03rC01VeOhzxEPQgBIa8sbbgAfoCUuKONPCYoPCcQ0nPNV3/w9z/y" +
       "Kz/08u+ARjosPbzJO0QgtTMM33WPf/ezP/rtT3z0az9YjNcCFk7ervzb9+S1" +
       "/od7g/XGHNbEiwNVJ+UwooohVl3LkRVVDM/goaPSQ7Z3W7h492ijF36u3wgH" +
       "6PEfJapdaCyI83UZmldnE2Ex0LHKihBRXbMYJh6YrabpckPTHlqdtSCMnHjY" +
       "nWrrtbLWHFNq87M+WqbWA48ZkVu4nwg9LqEhsQFbTEAyepvvr2Fm3RplHsbE" +
       "Lb2q9RfLIZxQgkZARrkiaqI4E+vQaqUozXnakuUgNspRGapAm0oFJLVZLUXt" +
       "yZqIVvGaH1N0XV2x3NarkkoHr8+kjZiMNRVuiCmrE9qgTMUtrLaedgSbo1sr" +
       "CWc50Vt3SF4ZCMuyqzUxbl6VHdMakvpgtUpsYskPe9BkYY7X66oHEZNKkEnM" +
       "MO5mI20oyCu407Vbnd5kLqLriQIN166gYHM0ndpcC3dwZMJNWnCrzeLBiOOn" +
       "SV1ulFORQCAX78lbWEaQgU9wDAIeMAHPWycpzU1lgxQSf+70sKVT2SxHZo0c" +
       "cevyyG0xE7Xfq86YdDRcIlNm5g4hlVkSuLDsCAInC5QbNeLW1G9PBn5vIotI" +
       "tMRjTPeUlBdWva5oL8O1UMMnkVNVTH9BNNbSbBqYU6SfVv1U7bVslViIq6jX" +
       "5XCYo5www6WJaUngrF4N+SbWTWdCQrVwVIcouudhc07B64lGaFG5qYTbykJY" +
       "2HTLEewxHC5NS/P6XV6xOgIRpyJNVus9n7YgmRuZaj9eAV5bVKRkQyKuxWKZ" +
       "kztDot8ie8t0zuOmHLcMuidtlxLNTAb2tEaT27JvY05lG8CN1aAiDWumlAlj" +
       "Ou410Z65Hrf1Kmv2q9li7Ne7aEAJvhN3ZxOCCGNz7JnTJVCLMV4z5LDLSSjv" +
       "0/54pVgmgqutMTsVjPVCXg8GXdnnqAYvj2ZdFVcldkxWpiYXBOuIc2YeLXmc" +
       "ORkJGKnPpHqtM6KqCS+Olhu8WZ2R5eWi7Y+agtkVuobUHEhJpTUztU7VrnXh" +
       "Wlfz8XCLjeFOe2yMGUkdZPUGg4+ZWRKEPuFO9E0lnlhc/gpXIzwKmS55Z7MR" +
       "58MBaCjIhptueDk2NmmKA40crsk1ZTbLHZeqp/SGHbXtcZekUlwbRA1qmmgG" +
       "qSBlNd4w6QLpdSd2JnMDkWGHY627HNm4xlOLZCKGi9F84Ahdd8rj8+Fkneqz" +
       "adtJDBQeWfFEVeRaUC3PZIzyLZLmuUkAszVM6FSrJifPttOa0hKZCBqvUQzu" +
       "q+vxGKiVx3gqneDLfiUkUwFZjXs1YeANvDU2sBa+X63xeFA10MZm3I22DMfa" +
       "XQdyJpV+hNcodShwDc8etN3OFOcFWAoTSxpKPuqWoeaISpLIlNigO8VirlKL" +
       "Vzgzk3gJRzEKrSKVCbttJ/O1Ol+uImkJr+ApPYNTmaqQCydYaBjW9PQxFROU" +
       "BC+A0iudWgJ3kgTCiL6wMrdEo4rFSLjEgFDHsgRPO3Fa1qBZ303KcT0btzq6" +
       "JVR7Y6wzdefQQov9aFXH5m0OTlR25pEKw7gVUV11OHyiCGYVcINLkcm6MsUM" +
       "bgA5Paax6ajqKq7O5sugjS69Ks8JnYWlJJUBO594q9aQsBuuP0yWCykMGrOM" +
       "apMQMYeRYbsS12ccUoOnpJlOpNY42NqeaCZit42Na426jc1ivI6KcCzWM7hR" +
       "YVFtWpspBME3emFoz1craxHZsTjD+GpKxU531a4aLFVb+EQ5Nbc1e4KmY7Gu" +
       "kgHcXzj1eWDbUdIju2MsFmCxM5BaM3LQJFtS11ECkqU69UgKKn1TXAsNfaJ0" +
       "KLXiBAxXUacBngwlfslVic2MWkhkczEOW/hG1Spq1cjq8+o0ba2qcR9m0kkL" +
       "Ioh6SPbW83V3rZCzqNYdD1sLSKlWFL5eRcJpO6r2nIBqK/4Cmys1adQ0u4O+" +
       "Q9QqapmW4KSiV3CFr7kD0uA38255SI/MNp/59Lg/pJPIjaoG1Y8Sh2h5NC8G" +
       "PbrDxkJ7qsfUhF+nQFoNpNVYVWBusWzhuJrZi3VELBudOMtW5c1Am5Q35fqg" +
       "JaeS6UVxjVGYgFDm7YCupYEsDR0YN9Z6ZLDletxr8PC2G6NDTbFJbpAFZi8L" +
       "HMYder0AWQ4cTXXLmuUs5Ljj1vWuvq17m3kssKvOctpx+jPbwRMR0phVmDRb" +
       "qLXUw4mmQNt2HG+Wg2Z7Kw7txOlRrmg6w6YkydISB+pUY7VOnNjSoIyyYrlN" +
       "ZGRvylpZs4X3gnjBcUQXg2simsRyGqFmCM0XbS2uGATcLUdad0gv8EnMrHEi" +
       "nNSJ8cqro9MJ66EOjQgNT50Rwnq7Hk9G1Hi7TscjQxsP+pKnQDimMkPLVOxu" +
       "teJWlo3y2Kj3HUN2MEx2qGC1RtDlvLcweiGkdGLMNJowPNtqcVxneHxcoZq1" +
       "ELGRdEXWNssNr7cRRA1T30HajYU4Y0ltJRixKw4rDUGjoKXUHvXqfLqZWxKZ" +
       "RPWJ0O9kbTKz4JY4RwWtSSXeYoVoWzcZ4rCreKakTeLVwjThBgQqJXScCTf8" +
       "wp3K9bLZVOKwrisKtKARiYDKrGavmnS/s6K5LeRsFXMe6GI3weqNZOCoSy/o" +
       "1TvJcBGXcbZBmaARTqWE8cZxOgg5refIVratof6ISJSwPuK7ZcpdN5Z1OcaS" +
       "5ri/FVDG4fqrVaDUGhtZjjbtWkQQ6aLR4ZRKiq3EuAUF2bo3nZcnCOpqNY9i" +
       "sG1cJlp9mEOWGusp5Y6ONuphOyTpxtZb4ut4Q6v9jsMsmrhizMVJoqMpDfyt" +
       "TFHLbXyBNjrAstVFX6/DSsVzNgQDSSJDc+pUDcilPppSIYluG9M+t4DrShPc" +
       "HNJkraIzGx6rw9p8M1kzSxpXvLHYGPUrlXgttodNaFYZDdKGD4u8EHeFQKZQ" +
       "fiJp00bG4skYm7V9djBjWhHG6xjnVO2h4OPAH5o505Fc7sWb4SzU0fo4nE4b" +
       "Gq1jZsNGx9MtZkqVxZJsw90BsfIbqKavaVkWNWykw5K4XLScFZNZmTdoZ91G" +
       "t7foSqwpABMoSmHdTjJpOGTbzQk1dxnTr4s03QuUjTlkA7ffaaltLjNRlWlD" +
       "MKzzqDCrOog4LU/6ZiRkJMFFpF4nHWejCiTfHfap7kCN24kCxyO0PuNHUp6v" +
       "NqqvAwVZ+S2iFs3F5bimM71BsxFbeGMLZ4qrbdVeAqfLRYOU6OYsmkmxMqpt" +
       "Jb+cLDvQkms4CjOezchunCa9KZMkcDbcbBoq1konLtYIgM+2psrTaMOZRrlZ" +
       "lWam7+PLNSVn3XK3AXKzwJ3FI2i17I4kLsYio6lRXqsnb/pT2FrLQBZklC5I" +
       "VFpuNlSMQH1zhs3WAmbSgj/sCF2vp85WEjaIp+wqE0YVwCpMFrRpD9FbnJRC" +
       "/TCtbWGMgSOpjCFcuR2OJUlcGBTlV+oSSYzFboew4F7NcbAVQS+6sUCYqCdN" +
       "ezGcbWYY1HVweyBN5ybKYcvpatQBjtmUiVNlxIvWAPTT/CpVLUlFmuEAjtWt" +
       "Gi7MziA25jrrTiSmiaPqCp9LOjFbav4G4/pY2MYajX7WC8tbxt024IbWXNm8" +
       "EMKTal3p1jtrjZln3Hpm5DBag5VGCWW0IbHKGkUNnoJbkk4Pze2i7ksrNBOQ" +
       "WWtbHXbNET5EGv6Epbam1Bokm4EvajjeXFmMwM3Q9ryvOINxS2hC9UV7xHfa" +
       "oTvCGX8yq2XanMGH5XaqzRdVFxNDfTodxFq3rKLBup8ZDSTD+0DJYE+nR6iy" +
       "MjnO85i1J80DQIHi2NsqW+sv4yVjMsy4riBYv8/1Da2f+N3V3Ea6q4EI3OZN" +
       "n8bmg/G6EQcNU0IoEFlZDanlqMNJbTtbBVza8fAQVvqKTaHGAIbqnfZosgja" +
       "8/Y6rFEY2h2U52kSmilE6r0ugsCDqtKzo+2EiZCpRzjZwmM3YwVx6MXUEEBj" +
       "WVdlGgRPPm5KHkay/bmPDSsLzO4tW0J1lGQwG3uiOJ1BLOItnGk0w7Z2v8nV" +
       "2Eo1gpCyveRGTFpDSD3i3WpjgE/aio5lMGOzhlyt1loMXq7YZdqilJG/QCWo" +
       "ViZWc2IiQjUINqh1TYC0znQ+4yJ0VonghdzmNBhurduVNZzpo8ToIcsmLSiG" +
       "Oq1q2KTte5lcDYlaz9SNOB11XSGczGMcwiBBtJXEW5dRL2KFpmwtg7nrZK7I" +
       "O3IcTyCPnQ7XBqM3yvo0gDKhxTqhlGA1q13vsElCbxRxM7I3sTiGB7FQpzFI" +
       "W2Ku300W9VoUTDK2Tm9qzRHXrwDjTE4qTDnoBCQdV6lyZ5llhGFB7Q3d1VgT" +
       "r+sDrJ92e1RGDV1EGrjL/oYQOWPUHCoI3EhxrG5vmQhPQURdQcqRUFGWUFnw" +
       "TIETVr4fSTgvecDqdD1d2ViZOV8zcW+G");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/YvLdeGosL1/FpVeJ2s7O3d+UfBZffjzB9CBXOf2HLgX3+SeO5A8+Zfn+4Sj" +
       "Z65gwrN58kS+hDjvCWjPzVl9gdU/evI+WHC8Fdz1/TYu12/bxuVOLLh4sPIs" +
       "kDddce/5PHlDVLoRFDuVHCB77tKByDzjd14O+y7Hxt4GAP/YHviPPXjgb7/i" +
       "XjlPXolK3xKuLH9gADNpacBpAj7k7R7k0VvuV8LvBwD3O21cv22njW8O6ENF" +
       "hofWZ+PUt97dfgl3yn6wU8Rx9vLd1d7Lt1QpeNy8gv/526KjalR6ysjt48mL" +
       "kAMFrF2mgEd3UMBjml9/OlyB6T6ItPK9x+5HbwtxvgTEuN/04vrPPBhxHvRh" +
       "R608yUeoj76rUMaCaaMrGJpvBnPUuxNDib/iFg169Ot/sufMnzwYzpxxYL+W" +
       "J58+5cfsCn7M82QSlZ60Qiz2bauQ/EG75u+383oZtMDHd2UfevRe4d7Rmfna" +
       "sTYUb0SvffpYqV+6bJOmk1664IB2BXfyjXaPbgFvb2f3L1OX993vyEPOoOf3" +
       "DHr+Hhh0p5GHgz03L+QIME0dObTU4g1HgTq4giObPHGi0mNWyOe7t+427Tqj" +
       "LO79dgJ/A/BgPxb10D2PRV3cNs7EsCedwGWvwXKrfvKSuROAoGBRAP+eK5jy" +
       "n+bJ+6PSGwqjclI6V5du7hUdqMt3/9VZl2ILtO8ADePbdqV3/++Sg6W7GsM8" +
       "+qErOPGf5cmHgL9g6tHxthnn3rYc6ad8uOM2YXcacQJt52FkDxR5MHbloMW8" +
       "fPkwyskASgH8x69gSv5S9+hjwHu0QsKLvIMG8w/ugwuFMX0NQP/uPRfe/aDE" +
       "Xfzej4FcsaHKGy/aGvi27XVef9H+wzn2zxU57mr04JsmIi/9R8XDdjuu5L+/" +
       "nuzU+XzUVwjrM1cI8hfy5FNR6WHHctnu+qSzKeT46QchR2IvR+IBNtujnymI" +
       "/+dXAMtjvaP/PgcmJ7cB+8UH8Jb74f24+sP3ErvepT361SuA/a958iVgj9Ri" +
       "oBcNQxDyA+24aJT36Mv323V5AOD37IF+9z0AvaLrerTIsJsvlo/SlL5SZPvN" +
       "Irm69eSX/6+L9DzH+tW7bODfdmbHpHyPTu2i7bPO7AJ+kil/yO8+kOZ9JQkn" +
       "rft379S68/P/dn0cM5yEaxeOGp2ZeFaEbMJte2gWqlNw8itXqN/X8+TX8wkl" +
       "uWNAxDLwJyJdvzTu+I2/Os/gePLSjXBX+kZwrwp6x4HzrxXG5pQz/+4Kzvz7" +
       "PPm3UemVfOxsNxJnFZvPnXl5cPbd/lku/cn9+g3A3b7xyT0bPvlg2HBobq8/" +
       "dDn46/mY29FfgrAidq11fA7nGXt0vXS/htcC+L6wx/mFB43z2tcKLFeMDV7P" +
       "xwavPxGVvuNQyDvz291tIG+55oWD6NfvZ8SwkPObAO4v7fF/6YHjL3qf61cM" +
       "G17Phw2vvyEqPQqCa89zDgPr68/db4cDvPsbX90D/Oo9ALy4Zz0bJhWGsgDx" +
       "tisAviNPXo5KTwF3H9NDNbD841eK3inMVx7A+MGNr+9hfv2+Yd4mwsYVCPPO" +
       "4noFhHaWiyf5+Eh0MvpZBMwHEq3eL9RXAMQ/30P98wcP9T1XQO3kyaugs7Lc" +
       "AejsAv0OWN91L1iTqPSacx/cyb8e8txtH/XafYhK/dlPPP3oGz4h/B/FN2dO" +
       "Phb1GFl61Min8J35iMOZ8xs+qNYq+PBYkT5VuAfXB/ksoktfDYGwbHeSk3y9" +
       "vytCAp/mgiKgJR+fns3NRKXHT3NHpSP13G0uKj2yvx2VroP07E0BXAI381Ox" +
       "kPLXk2vn3JYTfpeevRO/T4qc/UDN4f6iVLz7yNot9fOfGNLv/0br07sP5ACH" +
       "KsvyWh4lS4/svtVTVJpPVn/p0tqO67rRf/tfPPVzj73leGL9UzuCTxX2DG0v" +
       "XPw1Gtzxo+L7Mdl//Yb/8l0//YnfLjZi/P8AaKmTz/tuAAA=");
}
