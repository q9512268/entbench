package edu.umd.cs.findbugs.detect;
public final class FindMismatchedWaitOrNotify implements edu.umd.cs.findbugs.Detector, edu.umd.cs.findbugs.StatelessDetector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    public FindMismatchedWaitOrNotify(edu.umd.cs.findbugs.BugReporter bugReporter) {
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
    public java.lang.Object clone() { try { return super.clone();
                                      }
                                      catch (java.lang.CloneNotSupportedException e) {
                                          throw new java.lang.AssertionError(
                                            e);
                                      } }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        org.apache.bcel.classfile.JavaClass jclass =
          classContext.
          getJavaClass(
            );
        org.apache.bcel.classfile.Method[] methodList =
          jclass.
          getMethods(
            );
        for (org.apache.bcel.classfile.Method method
              :
              methodList) {
            org.apache.bcel.generic.MethodGen methodGen =
              classContext.
              getMethodGen(
                method);
            if (methodGen ==
                  null) {
                continue;
            }
            java.util.BitSet bytecodeSet =
              classContext.
              getBytecodeSet(
                method);
            if (bytecodeSet ==
                  null) {
                continue;
            }
            if (!(bytecodeSet.
                    get(
                      org.apache.bcel.Constants.
                        MONITORENTER) &&
                    bytecodeSet.
                    get(
                      org.apache.bcel.Constants.
                        INVOKEVIRTUAL))) {
                continue;
            }
            try {
                analyzeMethod(
                  classContext,
                  method);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                bugReporter.
                  logError(
                    "FindMismatchedWaitOrNotify: caught exception",
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                bugReporter.
                  logError(
                    "FindMismatchedWaitOrNotify: caught exception",
                    e);
            }
        }
    }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        org.apache.bcel.generic.MethodGen methodGen =
          classContext.
          getMethodGen(
            method);
        if (methodGen ==
              null) {
            return;
        }
        org.apache.bcel.generic.ConstantPoolGen cpg =
          methodGen.
          getConstantPool(
            );
        edu.umd.cs.findbugs.ba.CFG cfg =
          classContext.
          getCFG(
            method);
        edu.umd.cs.findbugs.ba.vna.ValueNumberDataflow vnaDataflow =
          classContext.
          getValueNumberDataflow(
            method);
        edu.umd.cs.findbugs.ba.LockDataflow dataflow =
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
            org.apache.bcel.generic.InstructionHandle handle =
              location.
              getHandle(
                );
            org.apache.bcel.generic.Instruction ins =
              handle.
              getInstruction(
                );
            if (!(ins instanceof org.apache.bcel.generic.INVOKEVIRTUAL)) {
                continue;
            }
            org.apache.bcel.generic.INVOKEVIRTUAL inv =
              (org.apache.bcel.generic.INVOKEVIRTUAL)
                ins;
            java.lang.String methodName =
              inv.
              getName(
                cpg);
            java.lang.String methodSig =
              inv.
              getSignature(
                cpg);
            if (edu.umd.cs.findbugs.ba.Hierarchy.
                  isMonitorWait(
                    methodName,
                    methodSig) ||
                  edu.umd.cs.findbugs.ba.Hierarchy.
                  isMonitorNotify(
                    methodName,
                    methodSig)) {
                int numConsumed =
                  inv.
                  consumeStack(
                    cpg);
                if (numConsumed ==
                      org.apache.bcel.Constants.
                        UNPREDICTABLE) {
                    throw new edu.umd.cs.findbugs.ba.DataflowAnalysisException(
                      "Unpredictable stack consumption",
                      methodGen,
                      handle);
                }
                edu.umd.cs.findbugs.ba.vna.ValueNumberFrame frame =
                  vnaDataflow.
                  getFactAtLocation(
                    location);
                if (!frame.
                      isValid(
                        )) {
                    continue;
                }
                if (frame.
                      getStackDepth(
                        ) -
                      numConsumed <
                      0) {
                    throw new edu.umd.cs.findbugs.ba.DataflowAnalysisException(
                      "Stack underflow",
                      methodGen,
                      handle);
                }
                edu.umd.cs.findbugs.ba.vna.ValueNumber ref =
                  frame.
                  getValue(
                    frame.
                      getNumSlots(
                        ) -
                      numConsumed);
                edu.umd.cs.findbugs.ba.LockSet lockSet =
                  dataflow.
                  getFactAtLocation(
                    location);
                int lockCount =
                  lockSet.
                  getLockCount(
                    ref.
                      getNumber(
                        ));
                if (lockCount ==
                      0) {
                    java.util.Collection<edu.umd.cs.findbugs.ba.vna.ValueNumber> lockedValueNumbers =
                      lockSet.
                      getLockedValueNumbers(
                        frame);
                    boolean foundMatch =
                      false;
                    for (edu.umd.cs.findbugs.ba.vna.ValueNumber v
                          :
                          lockedValueNumbers) {
                        if (frame.
                              veryFuzzyMatch(
                                ref,
                                v)) {
                            foundMatch =
                              true;
                            break;
                        }
                    }
                    if (!foundMatch) {
                        java.lang.String type =
                          "wait".
                          equals(
                            methodName)
                          ? "MWN_MISMATCHED_WAIT"
                          : "MWN_MISMATCHED_NOTIFY";
                        java.lang.String sourceFile =
                          classContext.
                          getJavaClass(
                            ).
                          getSourceFileName(
                            );
                        int priority =
                          method.
                          isPublic(
                            )
                          ? NORMAL_PRIORITY
                          : LOW_PRIORITY;
                        bugAccumulator.
                          accumulateBug(
                            new edu.umd.cs.findbugs.BugInstance(
                              this,
                              type,
                              priority).
                              addClassAndMethod(
                                methodGen,
                                sourceFile),
                            edu.umd.cs.findbugs.SourceLineAnnotation.
                              fromVisitedInstruction(
                                classContext,
                                methodGen,
                                sourceFile,
                                handle));
                    }
                }
            }
        }
        bugAccumulator.
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
       "CrRbvY46iP38HZf2Nn9lze//A3bfcIPGHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JwAA");
}
