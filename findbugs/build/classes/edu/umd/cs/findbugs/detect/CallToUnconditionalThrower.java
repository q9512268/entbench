package edu.umd.cs.findbugs.detect;
public class CallToUnconditionalThrower extends edu.umd.cs.findbugs.visitclass.PreorderVisitor implements edu.umd.cs.findbugs.Detector {
    static boolean DEBUG = false;
    edu.umd.cs.findbugs.BugReporter bugReporter;
    edu.umd.cs.findbugs.ba.AnalysisContext analysisContext;
    private final boolean testingEnabled;
    public CallToUnconditionalThrower(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        testingEnabled =
          edu.umd.cs.findbugs.SystemProperties.
            getBoolean(
              "report_TESTING_pattern_in_standard_detectors");
    }
    @java.lang.Override
    public void report() {  }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException { if (edu.umd.cs.findbugs.bcel.BCELUtil.
                                                                 isSynthetic(
                                                                   method) ||
                                                                 (method.
                                                                    getAccessFlags(
                                                                      ) &
                                                                    org.apache.bcel.Constants.
                                                                      ACC_BRIDGE) ==
                                                                 org.apache.bcel.Constants.
                                                                   ACC_BRIDGE) {
                                                               return;
                                                           }
                                                           edu.umd.cs.findbugs.ba.CFG cfg =
                                                             classContext.
                                                             getCFG(
                                                               method);
                                                           org.apache.bcel.generic.ConstantPoolGen cpg =
                                                             classContext.
                                                             getConstantPoolGen(
                                                               );
                                                           edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow =
                                                             classContext.
                                                             getTypeDataflow(
                                                               method);
                                                           for (java.util.Iterator<edu.umd.cs.findbugs.ba.BasicBlock> i =
                                                                  cfg.
                                                                  blockIterator(
                                                                    );
                                                                i.
                                                                  hasNext(
                                                                    );
                                                                ) {
                                                               edu.umd.cs.findbugs.ba.BasicBlock basicBlock =
                                                                 i.
                                                                 next(
                                                                   );
                                                               if (!basicBlock.
                                                                     isExceptionThrower(
                                                                       )) {
                                                                   continue;
                                                               }
                                                               org.apache.bcel.generic.InstructionHandle thrower =
                                                                 basicBlock.
                                                                 getExceptionThrower(
                                                                   );
                                                               org.apache.bcel.generic.Instruction ins =
                                                                 thrower.
                                                                 getInstruction(
                                                                   );
                                                               if (!(ins instanceof org.apache.bcel.generic.InvokeInstruction)) {
                                                                   continue;
                                                               }
                                                               org.apache.bcel.generic.InvokeInstruction inv =
                                                                 (org.apache.bcel.generic.InvokeInstruction)
                                                                   ins;
                                                               boolean foundThrower =
                                                                 false;
                                                               boolean foundNonThrower =
                                                                 false;
                                                               if (inv instanceof org.apache.bcel.generic.INVOKEINTERFACE) {
                                                                   continue;
                                                               }
                                                               java.lang.String className =
                                                                 inv.
                                                                 getClassName(
                                                                   cpg);
                                                               edu.umd.cs.findbugs.ba.Location loc =
                                                                 new edu.umd.cs.findbugs.ba.Location(
                                                                 thrower,
                                                                 basicBlock);
                                                               edu.umd.cs.findbugs.ba.type.TypeFrame typeFrame =
                                                                 typeDataflow.
                                                                 getFactAtLocation(
                                                                   loc);
                                                               edu.umd.cs.findbugs.ba.XMethod primaryXMethod =
                                                                 edu.umd.cs.findbugs.ba.XFactory.
                                                                 createXMethod(
                                                                   inv,
                                                                   cpg);
                                                               java.util.Set<edu.umd.cs.findbugs.ba.XMethod> targetSet =
                                                                 null;
                                                               try {
                                                                   if (className.
                                                                         startsWith(
                                                                           "[")) {
                                                                       continue;
                                                                   }
                                                                   java.lang.String methodSig =
                                                                     inv.
                                                                     getSignature(
                                                                       cpg);
                                                                   if (!methodSig.
                                                                         endsWith(
                                                                           "V")) {
                                                                       continue;
                                                                   }
                                                                   targetSet =
                                                                     edu.umd.cs.findbugs.ba.Hierarchy2.
                                                                       resolveMethodCallTargets(
                                                                         inv,
                                                                         typeFrame,
                                                                         cpg);
                                                                   for (edu.umd.cs.findbugs.ba.XMethod xMethod
                                                                         :
                                                                         targetSet) {
                                                                       if (DEBUG) {
                                                                           java.lang.System.
                                                                             out.
                                                                             println(
                                                                               "\tFound " +
                                                                               xMethod);
                                                                       }
                                                                       boolean isUnconditionalThrower =
                                                                         xMethod.
                                                                         isUnconditionalThrower(
                                                                           ) &&
                                                                         !xMethod.
                                                                         isUnsupported(
                                                                           ) &&
                                                                         !xMethod.
                                                                         isSynthetic(
                                                                           );
                                                                       if (isUnconditionalThrower) {
                                                                           foundThrower =
                                                                             true;
                                                                           if (DEBUG) {
                                                                               java.lang.System.
                                                                                 out.
                                                                                 println(
                                                                                   "Found thrower");
                                                                           }
                                                                       }
                                                                       else {
                                                                           foundNonThrower =
                                                                             true;
                                                                           if (DEBUG) {
                                                                               java.lang.System.
                                                                                 out.
                                                                                 println(
                                                                                   "Found non thrower");
                                                                           }
                                                                       }
                                                                   }
                                                               }
                                                               catch (java.lang.ClassNotFoundException e) {
                                                                   analysisContext.
                                                                     getLookupFailureCallback(
                                                                       ).
                                                                     reportMissingClass(
                                                                       e);
                                                               }
                                                               boolean newResult =
                                                                 foundThrower &&
                                                                 !foundNonThrower;
                                                               if (newResult) {
                                                                   bugReporter.
                                                                     reportBug(
                                                                       new edu.umd.cs.findbugs.BugInstance(
                                                                         this,
                                                                         "TESTING",
                                                                         edu.umd.cs.findbugs.Priorities.
                                                                           NORMAL_PRIORITY).
                                                                         addClassAndMethod(
                                                                           classContext.
                                                                             getJavaClass(
                                                                               ),
                                                                           method).
                                                                         addString(
                                                                           "Call to method that always throws Exception").
                                                                         addMethod(
                                                                           primaryXMethod).
                                                                         describe(
                                                                           edu.umd.cs.findbugs.MethodAnnotation.
                                                                             METHOD_CALLED).
                                                                         addSourceLine(
                                                                           classContext,
                                                                           method,
                                                                           loc));
                                                               }
                                                           }
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        if (!testingEnabled) {
            return;
        }
        analysisContext =
          edu.umd.cs.findbugs.ba.AnalysisContext.
            currentAnalysisContext(
              );
        org.apache.bcel.classfile.Method[] methodList =
          classContext.
          getJavaClass(
            ).
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
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                bugReporter.
                  logError(
                    "Error checking for infinite recursive loop in " +
                    edu.umd.cs.findbugs.ba.SignatureConverter.
                      convertMethodSignature(
                        classContext.
                          getJavaClass(
                            ),
                        method),
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                bugReporter.
                  logError(
                    "Error checking for infinite recursive loop in " +
                    edu.umd.cs.findbugs.ba.SignatureConverter.
                      convertMethodSignature(
                        classContext.
                          getJavaClass(
                            ),
                        method),
                    e);
            }
        }
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
       "AAA=");
}
