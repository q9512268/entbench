package edu.umd.cs.findbugs.detect;
public class FindSleepWithLockHeld implements edu.umd.cs.findbugs.Detector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    public FindSleepWithLockHeld(edu.umd.cs.findbugs.BugReporter bugReporter) {
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
            if (!prescreen(
                   classContext,
                   method)) {
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
                    "FindSleepWithLockHeld caught exception",
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                bugReporter.
                  logError(
                    "FindSleepWithLockHeld caught exception",
                    e);
            }
        }
    }
    private boolean prescreen(edu.umd.cs.findbugs.ba.ClassContext classContext,
                              org.apache.bcel.classfile.Method method) {
        java.util.BitSet bytecodeSet =
          classContext.
          getBytecodeSet(
            method);
        if (bytecodeSet ==
              null) {
            return false;
        }
        if (!bytecodeSet.
              get(
                org.apache.bcel.Constants.
                  MONITORENTER) &&
              !method.
              isSynchronized(
                )) {
            return false;
        }
        if (!bytecodeSet.
              get(
                org.apache.bcel.Constants.
                  INVOKESTATIC)) {
            return false;
        }
        return true;
    }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException { edu.umd.cs.findbugs.ba.CFG cfg =
                                                             classContext.
                                                             getCFG(
                                                               method);
                                                           edu.umd.cs.findbugs.ba.LockDataflow lockDataflow =
                                                             classContext.
                                                             getLockDataflow(
                                                               method);
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
                                                               org.apache.bcel.generic.Instruction ins =
                                                                 location.
                                                                 getHandle(
                                                                   ).
                                                                 getInstruction(
                                                                   );
                                                               if (!(ins instanceof org.apache.bcel.generic.INVOKESTATIC)) {
                                                                   continue;
                                                               }
                                                               if (!isSleep(
                                                                      (org.apache.bcel.generic.INVOKESTATIC)
                                                                        ins,
                                                                      classContext.
                                                                        getConstantPoolGen(
                                                                          ))) {
                                                                   continue;
                                                               }
                                                               edu.umd.cs.findbugs.ba.LockSet lockSet =
                                                                 lockDataflow.
                                                                 getFactAtLocation(
                                                                   location);
                                                               if (lockSet.
                                                                     getNumLockedObjects(
                                                                       ) >
                                                                     0) {
                                                                   bugAccumulator.
                                                                     accumulateBug(
                                                                       new edu.umd.cs.findbugs.BugInstance(
                                                                         this,
                                                                         "SWL_SLEEP_WITH_LOCK_HELD",
                                                                         NORMAL_PRIORITY).
                                                                         addClassAndMethod(
                                                                           classContext.
                                                                             getJavaClass(
                                                                               ),
                                                                           method),
                                                                       classContext,
                                                                       method,
                                                                       location);
                                                               }
                                                           }
                                                           bugAccumulator.
                                                             reportAccumulatedBugs(
                                                               );
    }
    private boolean isSleep(org.apache.bcel.generic.INVOKESTATIC ins,
                            org.apache.bcel.generic.ConstantPoolGen cpg) {
        java.lang.String className =
          ins.
          getClassName(
            cpg);
        if (!"java.lang.Thread".
              equals(
                className)) {
            return false;
        }
        java.lang.String methodName =
          ins.
          getMethodName(
            cpg);
        java.lang.String signature =
          ins.
          getSignature(
            cpg);
        return "sleep".
          equals(
            methodName) &&
          ("(J)V".
             equals(
               signature) ||
             "(JI)V".
             equals(
               signature));
    }
    @java.lang.Override
    public void report() {  }
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
       "v3vlj8t7tf8LLwtt6mopAAA=");
}
