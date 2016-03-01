package edu.umd.cs.findbugs.detect;
public class CallToUnsupportedMethod implements edu.umd.cs.findbugs.Detector {
    edu.umd.cs.findbugs.BugReporter bugReporter;
    public CallToUnsupportedMethod(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
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
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.MethodUnprofitableException,
        edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        if (edu.umd.cs.findbugs.bcel.BCELUtil.
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
        edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow =
          classContext.
          getTypeDataflow(
            method);
        org.apache.bcel.generic.ConstantPoolGen constantPoolGen =
          classContext.
          getConstantPoolGen(
            );
        locationLoop: for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> iter =
                             cfg.
                             locationIterator(
                               );
                           iter.
                             hasNext(
                               );
                           ) {
            edu.umd.cs.findbugs.ba.Location location =
              iter.
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
            if (!(ins instanceof org.apache.bcel.generic.InvokeInstruction)) {
                continue;
            }
            if (ins instanceof org.apache.bcel.generic.INVOKEINTERFACE) {
                continue;
            }
            org.apache.bcel.generic.InvokeInstruction inv =
              (org.apache.bcel.generic.InvokeInstruction)
                ins;
            edu.umd.cs.findbugs.ba.type.TypeFrame frame =
              typeDataflow.
              getFactAtLocation(
                location);
            java.lang.String methodName =
              inv.
              getMethodName(
                constantPoolGen);
            if (methodName.
                  toLowerCase(
                    ).
                  indexOf(
                    "unsupported") >=
                  0) {
                continue;
            }
            java.lang.String methodSig =
              inv.
              getSignature(
                constantPoolGen);
            if ("()Ljava/lang/UnsupportedOperationException;".
                  equals(
                    methodSig)) {
                continue;
            }
            java.util.Set<edu.umd.cs.findbugs.ba.XMethod> targets;
            try {
                targets =
                  edu.umd.cs.findbugs.ba.Hierarchy2.
                    resolveMethodCallTargets(
                      inv,
                      frame,
                      constantPoolGen);
            }
            catch (java.lang.ClassNotFoundException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  reportMissingClass(
                    e);
                continue locationLoop;
            }
            if (targets.
                  isEmpty(
                    )) {
                continue locationLoop;
            }
            int priority =
              targets.
              size(
                ) ==
              1
              ? edu.umd.cs.findbugs.Priorities.
                  HIGH_PRIORITY
              : edu.umd.cs.findbugs.Priorities.
                  NORMAL_PRIORITY;
            for (edu.umd.cs.findbugs.ba.XMethod m
                  :
                  targets) {
                if (!m.
                      isUnsupported(
                        )) {
                    continue locationLoop;
                }
                edu.umd.cs.findbugs.ba.XClass xc =
                  edu.umd.cs.findbugs.ba.AnalysisContext.
                  currentXFactory(
                    ).
                  getXClass(
                    m.
                      getClassDescriptor(
                        ));
                if (!(inv instanceof org.apache.bcel.generic.INVOKESTATIC) &&
                      !(m.
                          isFinal(
                            ) ||
                          xc.
                          isFinal(
                            ))) {
                    priority =
                      edu.umd.cs.findbugs.Priorities.
                        NORMAL_PRIORITY;
                }
                if (xc ==
                      null ||
                      xc.
                      isAbstract(
                        )) {
                    try {
                        if (!edu.umd.cs.findbugs.ba.AnalysisContext.
                              currentAnalysisContext(
                                ).
                              getSubtypes2(
                                ).
                              hasSubtypes(
                                m.
                                  getClassDescriptor(
                                    ))) {
                            continue locationLoop;
                        }
                    }
                    catch (java.lang.ClassNotFoundException e) {
                        edu.umd.cs.findbugs.ba.AnalysisContext.
                          reportMissingClass(
                            e);
                        continue locationLoop;
                    }
                }
            }
            edu.umd.cs.findbugs.BugInstance bug =
              new edu.umd.cs.findbugs.BugInstance(
              this,
              "DMI_UNSUPPORTED_METHOD",
              priority).
              addClassAndMethod(
                classContext.
                  getJavaClass(
                    ),
                method).
              addCalledMethod(
                constantPoolGen,
                inv).
              addSourceLine(
                classContext,
                method,
                location);
            bugReporter.
              reportBug(
                bug);
        }
    }
    @java.lang.Override
    public void report() {  }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xX5e5dpe46+sufYf9gLmKm4aAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
