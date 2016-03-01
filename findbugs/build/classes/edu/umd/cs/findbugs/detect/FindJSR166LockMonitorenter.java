package edu.umd.cs.findbugs.detect;
public final class FindJSR166LockMonitorenter implements edu.umd.cs.findbugs.Detector, edu.umd.cs.findbugs.StatelessDetector {
    private static final java.lang.String UTIL_CONCURRRENT_SIG_PREFIX = "Ljava/util/concurrent/";
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private static final org.apache.bcel.generic.ObjectType LOCK_TYPE = edu.umd.cs.findbugs.ba.ObjectTypeFactory.
      getInstance(
        "java.util.concurrent.locks.Lock");
    public FindJSR166LockMonitorenter(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public java.lang.Object clone() { try { return super.
                                              clone(
                                                ); }
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
        if (jclass.
              getClassName(
                ).
              startsWith(
                "java.util.concurrent.")) {
            return;
        }
        org.apache.bcel.classfile.Method[] methodList =
          jclass.
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
            java.util.BitSet bytecodeSet =
              classContext.
              getBytecodeSet(
                method);
            if (bytecodeSet ==
                  null) {
                continue;
            }
            if (false &&
                  !bytecodeSet.
                  get(
                    org.apache.bcel.Constants.
                      MONITORENTER)) {
                continue;
            }
            analyzeMethod(
              classContext,
              method);
        }
    }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method) {
        org.apache.bcel.generic.ConstantPoolGen cpg =
          classContext.
          getConstantPoolGen(
            );
        edu.umd.cs.findbugs.ba.CFG cfg;
        try {
            cfg =
              classContext.
                getCFG(
                  method);
        }
        catch (edu.umd.cs.findbugs.ba.CFGBuilderException e1) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Coult not get CFG",
                e1);
            return;
        }
        edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow;
        try {
            typeDataflow =
              classContext.
                getTypeDataflow(
                  method);
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e1) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Coult not get Type dataflow",
                e1);
            return;
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
            if (ins.
                  getOpcode(
                    ) ==
                  org.apache.bcel.Constants.
                    INVOKEVIRTUAL) {
                org.apache.bcel.generic.INVOKEVIRTUAL iv =
                  (org.apache.bcel.generic.INVOKEVIRTUAL)
                    ins;
                java.lang.String methodName =
                  iv.
                  getMethodName(
                    cpg);
                java.lang.String methodSig =
                  iv.
                  getSignature(
                    cpg);
                if ("wait".
                      equals(
                        methodName) &&
                      ("()V".
                         equals(
                           methodSig) ||
                         "(J)V".
                         equals(
                           methodSig) ||
                         "(JI)V".
                         equals(
                           methodSig)) ||
                      ("notify".
                         equals(
                           methodName) ||
                         "notifyAll".
                         equals(
                           methodName)) &&
                      "()V".
                      equals(
                        methodSig)) {
                    try {
                        edu.umd.cs.findbugs.ba.type.TypeFrame frame =
                          typeDataflow.
                          getFactAtLocation(
                            location);
                        if (!frame.
                              isValid(
                                )) {
                            continue;
                        }
                        org.apache.bcel.generic.Type type =
                          frame.
                          getInstance(
                            ins,
                            cpg);
                        if (!(type instanceof org.apache.bcel.generic.ReferenceType)) {
                            continue;
                        }
                        edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor =
                          edu.umd.cs.findbugs.classfile.DescriptorFactory.
                          createClassDescriptorFromSignature(
                            type.
                              getSignature(
                                ));
                        if (classDescriptor.
                              equals(
                                classContext.
                                  getClassDescriptor(
                                    ))) {
                            continue;
                        }
                        if (!classDescriptor.
                              getClassName(
                                ).
                              startsWith(
                                "java/util/concurrent")) {
                            continue;
                        }
                        edu.umd.cs.findbugs.ba.XClass c =
                          edu.umd.cs.findbugs.Lookup.
                          getXClass(
                            classDescriptor);
                        edu.umd.cs.findbugs.ba.XMethod m;
                        int priority =
                          NORMAL_PRIORITY;
                        if ("wait".
                              equals(
                                methodName)) {
                            m =
                              c.
                                findMethod(
                                  "await",
                                  "()V",
                                  false);
                            priority =
                              HIGH_PRIORITY;
                        }
                        else
                            if ("notify".
                                  equals(
                                    methodName)) {
                                m =
                                  c.
                                    findMethod(
                                      "signal",
                                      "()V",
                                      false);
                                if (m ==
                                      null) {
                                    m =
                                      c.
                                        findMethod(
                                          "countDown",
                                          "()V",
                                          false);
                                }
                            }
                            else
                                if ("notifyAll".
                                      equals(
                                        methodName)) {
                                    m =
                                      c.
                                        findMethod(
                                          "signalAll",
                                          "()V",
                                          false);
                                    if (m ==
                                          null) {
                                        m =
                                          c.
                                            findMethod(
                                              "countDown",
                                              "()V",
                                              false);
                                    }
                                }
                                else {
                                    throw new java.lang.IllegalStateException(
                                      "Unexpected methodName: " +
                                      methodName);
                                }
                        if (m !=
                              null &&
                              m.
                              isPublic(
                                ) &&
                              c.
                              isPublic(
                                )) {
                            bugReporter.
                              reportBug(
                                new edu.umd.cs.findbugs.BugInstance(
                                  this,
                                  "JML_JSR166_CALLING_WAIT_RATHER_THAN_AWAIT",
                                  priority).
                                  addClassAndMethod(
                                    classContext.
                                      getJavaClass(
                                        ),
                                    method).
                                  addCalledMethod(
                                    cpg,
                                    iv).
                                  addMethod(
                                    m).
                                  describe(
                                    edu.umd.cs.findbugs.MethodAnnotation.
                                      METHOD_ALTERNATIVE_TARGET).
                                  addType(
                                    classDescriptor).
                                  describe(
                                    edu.umd.cs.findbugs.TypeAnnotation.
                                      FOUND_ROLE).
                                  addSourceLine(
                                    classContext,
                                    method,
                                    location));
                        }
                    }
                    catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                        edu.umd.cs.findbugs.ba.AnalysisContext.
                          logError(
                            "Coult not get Type dataflow",
                            e);
                        continue;
                    }
                }
            }
            if (ins.
                  getOpcode(
                    ) !=
                  org.apache.bcel.Constants.
                    MONITORENTER) {
                continue;
            }
            org.apache.bcel.generic.Type type;
            try {
                edu.umd.cs.findbugs.ba.type.TypeFrame frame =
                  typeDataflow.
                  getFactAtLocation(
                    location);
                if (!frame.
                      isValid(
                        )) {
                    continue;
                }
                type =
                  frame.
                    getInstance(
                      ins,
                      cpg);
            }
            catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  logError(
                    "Coult not get Type dataflow",
                    e);
                continue;
            }
            if (!(type instanceof org.apache.bcel.generic.ReferenceType)) {
                continue;
            }
            boolean isSubtype =
              false;
            try {
                isSubtype =
                  edu.umd.cs.findbugs.ba.Hierarchy.
                    isSubtype(
                      (org.apache.bcel.generic.ReferenceType)
                        type,
                      LOCK_TYPE);
            }
            catch (java.lang.ClassNotFoundException e) {
                bugReporter.
                  reportMissingClass(
                    e);
            }
            java.lang.String sig =
              type.
              getSignature(
                );
            boolean isUtilConcurrentSig =
              sig.
              startsWith(
                UTIL_CONCURRRENT_SIG_PREFIX);
            if (isSubtype) {
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "JLM_JSR166_LOCK_MONITORENTER",
                      isUtilConcurrentSig
                        ? HIGH_PRIORITY
                        : NORMAL_PRIORITY).
                      addClassAndMethod(
                        classContext.
                          getJavaClass(
                            ),
                        method).
                      addType(
                        sig).
                      addSourceForTopStackValue(
                        classContext,
                        method,
                        location).
                      addSourceLine(
                        classContext,
                        method,
                        location));
            }
            else
                if (isUtilConcurrentSig) {
                    int priority =
                      "Ljava/util/concurrent/CopyOnWriteArrayList;".
                      equals(
                        sig)
                      ? HIGH_PRIORITY
                      : NORMAL_PRIORITY;
                    bugReporter.
                      reportBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "JLM_JSR166_UTILCONCURRENT_MONITORENTER",
                          priority).
                          addClassAndMethod(
                            classContext.
                              getJavaClass(
                                ),
                            method).
                          addType(
                            sig).
                          addSourceForTopStackValue(
                            classContext,
                            method,
                            location).
                          addSourceLine(
                            classContext,
                            method,
                            location));
                }
        }
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
       "f1Ddw/wfekQdp3QoAAA=");
}
