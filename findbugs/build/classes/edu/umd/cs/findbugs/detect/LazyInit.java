package edu.umd.cs.findbugs.detect;
public final class LazyInit extends edu.umd.cs.findbugs.ByteCodePatternDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "lazyinit.debug");
    private static edu.umd.cs.findbugs.ba.bcp.ByteCodePattern pattern = new edu.umd.cs.findbugs.ba.bcp.ByteCodePattern(
      );
    static { pattern.add(new edu.umd.cs.findbugs.ba.bcp.Load("f",
                                                             "val").
                           label(
                             "start")).add(new edu.umd.cs.findbugs.ba.bcp.IfNull(
                                             "val").
                                             label(
                                               "test")).add(
                                                          new edu.umd.cs.findbugs.ba.bcp.Wild(
                                                            1,
                                                            1).
                                                            label(
                                                              "createObject").
                                                            dominatedBy(
                                                              "test")).
               add(
                 new edu.umd.cs.findbugs.ba.bcp.Store(
                   "f",
                   pattern.
                     dummyVariable(
                       )).
                   label(
                     "end").
                   dominatedBy(
                     "createObject")); }
    public LazyInit(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public java.lang.Object clone() { try { return super.
                                              clone(
                                                );
                                      }
                                      catch (java.lang.CloneNotSupportedException e) {
                                          throw new java.lang.AssertionError(
                                            e);
                                      } }
    @java.lang.Override
    public edu.umd.cs.findbugs.BugReporter getBugReporter() {
        return bugReporter;
    }
    java.util.BitSet reported = new java.util.BitSet(
      );
    @java.lang.Override
    public edu.umd.cs.findbugs.ba.bcp.ByteCodePattern getPattern() {
        return pattern;
    }
    @java.lang.Override
    public boolean prescreen(org.apache.bcel.classfile.Method method,
                             edu.umd.cs.findbugs.ba.ClassContext classContext) {
        if ("<clinit>".
              equals(
                method.
                  getName(
                    ))) {
            return false;
        }
        org.apache.bcel.classfile.Code code =
          method.
          getCode(
            );
        if (code.
              getCode(
                ).
              length >
              5000) {
            return false;
        }
        java.util.BitSet bytecodeSet =
          classContext.
          getBytecodeSet(
            method);
        if (bytecodeSet ==
              null) {
            return false;
        }
        boolean hasGetStatic =
          bytecodeSet.
          get(
            org.apache.bcel.Constants.
              GETSTATIC);
        boolean hasPutStatic =
          bytecodeSet.
          get(
            org.apache.bcel.Constants.
              PUTSTATIC);
        if (!hasGetStatic ||
              !hasPutStatic) {
            return false;
        }
        if (method.
              isSynchronized(
                )) {
            return false;
        }
        reported.
          clear(
            );
        return true;
    }
    @java.lang.Override
    public void reportMatch(edu.umd.cs.findbugs.ba.ClassContext classContext,
                            org.apache.bcel.classfile.Method method,
                            edu.umd.cs.findbugs.ba.bcp.ByteCodePatternMatch match)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        org.apache.bcel.classfile.JavaClass javaClass =
          classContext.
          getJavaClass(
            );
        org.apache.bcel.generic.MethodGen methodGen =
          classContext.
          getMethodGen(
            method);
        edu.umd.cs.findbugs.ba.CFG cfg =
          classContext.
          getCFG(
            method);
        edu.umd.cs.findbugs.ba.bcp.BindingSet bindingSet =
          match.
          getBindingSet(
            );
        edu.umd.cs.findbugs.ba.bcp.Binding binding =
          bindingSet.
          lookup(
            "f");
        edu.umd.cs.findbugs.ba.bcp.FieldVariable field =
          (edu.umd.cs.findbugs.ba.bcp.FieldVariable)
            binding.
            getVariable(
              );
        edu.umd.cs.findbugs.ba.XField xfield =
          edu.umd.cs.findbugs.ba.Hierarchy.
          findXField(
            field.
              getClassName(
                ),
            field.
              getFieldName(
                ),
            field.
              getFieldSig(
                ),
            field.
              isStatic(
                ));
        if (!xfield.
              isResolved(
                )) {
            return;
        }
        if (!xfield.
              isStatic(
                )) {
            return;
        }
        if (xfield.
              getName(
                ).
              startsWith(
                "class$") ||
              xfield.
              getName(
                ).
              startsWith(
                "array$")) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Ignoring field " +
                    xfield.
                      getName(
                        ));
            }
            return;
        }
        java.lang.String signature =
          xfield.
          getSignature(
            );
        if (!signature.
              startsWith(
                "[") &&
              !signature.
              startsWith(
                "L")) {
            if (DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Ignoring non-reference field " +
                    xfield.
                      getName(
                        ));
            }
            return;
        }
        if ("Ljava/lang/String;".
              equals(
                signature)) {
            return;
        }
        if (signature.
              charAt(
                0) ==
              'L') {
            edu.umd.cs.findbugs.classfile.ClassDescriptor fieldType =
              edu.umd.cs.findbugs.classfile.DescriptorFactory.
              createClassDescriptorFromFieldSignature(
                signature);
            while (fieldType !=
                     null) {
                edu.umd.cs.findbugs.ba.XClass fieldClass;
                try {
                    fieldClass =
                      edu.umd.cs.findbugs.classfile.Global.
                        getAnalysisCache(
                          ).
                        getClassAnalysis(
                          edu.umd.cs.findbugs.ba.XClass.class,
                          fieldType);
                }
                catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                    break;
                }
                java.lang.String name =
                  fieldClass.
                  getClassDescriptor(
                    ).
                  getClassName(
                    );
                if (name.
                      startsWith(
                        "java/awt") ||
                      name.
                      startsWith(
                        "javax/swing")) {
                    return;
                }
                if ("java/lang/Object".
                      equals(
                        name)) {
                    break;
                }
                fieldType =
                  fieldClass.
                    getSuperclassDescriptor(
                      );
            }
        }
        edu.umd.cs.findbugs.ba.bcp.PatternElementMatch createBegin =
          match.
          getFirstLabeledMatch(
            "createObject");
        edu.umd.cs.findbugs.ba.bcp.PatternElementMatch store =
          match.
          getFirstLabeledMatch(
            "end");
        edu.umd.cs.findbugs.ba.bcp.PatternElementMatch test =
          match.
          getFirstLabeledMatch(
            "test");
        org.apache.bcel.generic.InstructionHandle testInstructionHandle =
          test.
          getMatchedInstructionInstructionHandle(
            );
        if (reported.
              get(
                testInstructionHandle.
                  getPosition(
                    ))) {
            return;
        }
        edu.umd.cs.findbugs.ba.DominatorsAnalysis domAnalysis =
          classContext.
          getNonExceptionDominatorsAnalysis(
            method);
        edu.umd.cs.findbugs.ba.PostDominatorsAnalysis postDomAnalysis =
          classContext.
          getNonExceptionPostDominatorsAnalysis(
            method);
        java.util.BitSet extent =
          domAnalysis.
          getAllDominatedBy(
            createBegin.
              getBasicBlock(
                ));
        java.util.BitSet postDom =
          postDomAnalysis.
          getAllDominatedBy(
            store.
              getBasicBlock(
                ));
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "test  dominates: " +
                extent);
            java.lang.System.
              out.
              println(
                "Field store postdominates " +
                postDom);
        }
        extent.
          and(
            postDom);
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "extent: " +
                extent);
        }
        edu.umd.cs.findbugs.ba.LockDataflow lockDataflow =
          classContext.
          getLockDataflow(
            method);
        edu.umd.cs.findbugs.ba.LockSet lockSet =
          null;
        boolean sawNEW =
          false;
        boolean sawINVOKE =
          false;
        for (edu.umd.cs.findbugs.ba.BasicBlock block
              :
              cfg.
               getBlocks(
                 extent)) {
            for (java.util.Iterator<org.apache.bcel.generic.InstructionHandle> j =
                   block.
                   instructionIterator(
                     );
                 j.
                   hasNext(
                     );
                 ) {
                org.apache.bcel.generic.InstructionHandle handle =
                  j.
                  next(
                    );
                if (handle.
                      equals(
                        store.
                          getMatchedInstructionInstructionHandle(
                            ))) {
                    break;
                }
                edu.umd.cs.findbugs.ba.Location location =
                  new edu.umd.cs.findbugs.ba.Location(
                  handle,
                  block);
                org.apache.bcel.generic.Instruction ins =
                  handle.
                  getInstruction(
                    );
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        location);
                }
                if (ins instanceof org.apache.bcel.generic.AllocationInstruction) {
                    sawNEW =
                      true;
                }
                else
                    if (ins instanceof org.apache.bcel.generic.InvokeInstruction) {
                        if (ins instanceof org.apache.bcel.generic.INVOKESTATIC &&
                              ((org.apache.bcel.generic.INVOKESTATIC)
                                 ins).
                              getMethodName(
                                classContext.
                                  getConstantPoolGen(
                                    )).
                              startsWith(
                                "new")) {
                            sawNEW =
                              true;
                        }
                        sawINVOKE =
                          true;
                    }
                edu.umd.cs.findbugs.ba.LockSet insLockSet =
                  lockDataflow.
                  getFactAtLocation(
                    location);
                if (lockSet ==
                      null) {
                    lockSet =
                      new edu.umd.cs.findbugs.ba.LockSet(
                        );
                    lockSet.
                      copyFrom(
                        insLockSet);
                }
                else {
                    lockSet.
                      intersectWith(
                        insLockSet);
                }
            }
        }
        if (!(sawNEW ||
                sawINVOKE)) {
            return;
        }
        if (lockSet ==
              null) {
            throw new java.lang.IllegalStateException(
              "lock set is null");
        }
        if (!lockSet.
              isEmpty(
                )) {
            return;
        }
        boolean sawGetStaticAfterPutStatic =
          false;
        check: if (signature.
                     startsWith(
                       "[") ||
                     signature.
                     startsWith(
                       "L")) {
            java.util.BitSet postStore =
              domAnalysis.
              getAllDominatedBy(
                store.
                  getBasicBlock(
                    ));
            for (edu.umd.cs.findbugs.ba.BasicBlock block
                  :
                  cfg.
                   getBlocks(
                     postStore)) {
                for (java.util.Iterator<org.apache.bcel.generic.InstructionHandle> j =
                       block.
                       instructionIterator(
                         );
                     j.
                       hasNext(
                         );
                     ) {
                    org.apache.bcel.generic.InstructionHandle handle =
                      j.
                      next(
                        );
                    org.apache.bcel.generic.InstructionHandle nextHandle =
                      handle.
                      getNext(
                        );
                    org.apache.bcel.generic.Instruction ins =
                      handle.
                      getInstruction(
                        );
                    if (ins instanceof org.apache.bcel.generic.GETSTATIC &&
                          potentialInitialization(
                            nextHandle)) {
                        edu.umd.cs.findbugs.ba.XField field2 =
                          edu.umd.cs.findbugs.ba.XFactory.
                          createXField(
                            (org.apache.bcel.generic.FieldInstruction)
                              ins,
                            methodGen.
                              getConstantPool(
                                ));
                        if (xfield.
                              equals(
                                field2)) {
                            sawGetStaticAfterPutStatic =
                              true;
                            break check;
                        }
                    }
                }
            }
        }
        if (!sawGetStaticAfterPutStatic &&
              xfield.
              isVolatile(
                )) {
            return;
        }
        int priority =
          LOW_PRIORITY;
        boolean isDefaultAccess =
          (method.
             getAccessFlags(
               ) &
             (org.apache.bcel.Constants.
                ACC_PUBLIC |
                org.apache.bcel.Constants.
                  ACC_PRIVATE |
                org.apache.bcel.Constants.
                  ACC_PROTECTED)) ==
          0;
        if (method.
              isPublic(
                )) {
            priority =
              NORMAL_PRIORITY;
        }
        else
            if (method.
                  isProtected(
                    ) ||
                  isDefaultAccess) {
                priority =
                  NORMAL_PRIORITY;
            }
        if (signature.
              startsWith(
                "[") ||
              signature.
              startsWith(
                "Ljava/util/")) {
            priority--;
        }
        if (!sawNEW) {
            priority++;
        }
        if (!sawGetStaticAfterPutStatic &&
              priority <
              LOW_PRIORITY) {
            priority =
              LOW_PRIORITY;
        }
        if (classContext.
              getXClass(
                ).
              usesConcurrency(
                )) {
            priority--;
        }
        org.apache.bcel.generic.InstructionHandle start =
          match.
          getLabeledInstruction(
            "start");
        org.apache.bcel.generic.InstructionHandle end =
          match.
          getLabeledInstruction(
            "end");
        java.lang.String sourceFile =
          javaClass.
          getSourceFileName(
            );
        bugReporter.
          reportBug(
            new edu.umd.cs.findbugs.BugInstance(
              this,
              sawGetStaticAfterPutStatic
                ? "LI_LAZY_INIT_UPDATE_STATIC"
                : "LI_LAZY_INIT_STATIC",
              priority).
              addClassAndMethod(
                methodGen,
                sourceFile).
              addField(
                xfield).
              describe(
                "FIELD_ON").
              addSourceLine(
                classContext,
                methodGen,
                sourceFile,
                start,
                end));
        reported.
          set(
            testInstructionHandle.
              getPosition(
                ));
    }
    private boolean potentialInitialization(org.apache.bcel.generic.InstructionHandle nextHandle) {
        if (nextHandle ==
              null) {
            return true;
        }
        org.apache.bcel.generic.Instruction instruction =
          nextHandle.
          getInstruction(
            );
        if (instruction instanceof org.apache.bcel.generic.ReturnInstruction) {
            return false;
        }
        if (instruction instanceof org.apache.bcel.generic.IfInstruction) {
            return false;
        }
        return true;
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
       "/YlfeeR9JynlEweCz3zhHG3vvneZ0dAL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "06owaP8Pnvm77//br/9edSn5/wHF2U3IxSwAAA==";
}
