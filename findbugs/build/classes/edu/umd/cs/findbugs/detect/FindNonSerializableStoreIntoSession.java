package edu.umd.cs.findbugs.detect;
public class FindNonSerializableStoreIntoSession implements edu.umd.cs.findbugs.Detector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    private static final boolean DEBUG = false;
    public FindNonSerializableStoreIntoSession(edu.umd.cs.findbugs.BugReporter bugReporter) {
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
                    "Detector " +
                    this.
                      getClass(
                        ).
                      getName(
                        ) +
                    " caught exception",
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                
            }
            bugAccumulator.
              reportAccumulatedBugs(
                );
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
        java.util.BitSet bytecodeSet =
          classContext.
          getBytecodeSet(
            method);
        if (bytecodeSet ==
              null) {
            return;
        }
        if (bytecodeSet.
              get(
                org.apache.bcel.Constants.
                  INSTANCEOF) ||
              bytecodeSet.
              get(
                org.apache.bcel.Constants.
                  CHECKCAST)) {
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
        org.apache.bcel.generic.ConstantPoolGen cpg =
          classContext.
          getConstantPoolGen(
            );
        java.lang.String sourceFile =
          classContext.
          getJavaClass(
            ).
          getSourceFileName(
            );
        if (DEBUG) {
            java.lang.String methodName =
              methodGen.
              getClassName(
                ) +
            "." +
            methodGen.
              getName(
                );
            java.lang.System.
              out.
              println(
                "Checking " +
                methodName);
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
            if (!(ins instanceof org.apache.bcel.generic.INVOKEINTERFACE)) {
                continue;
            }
            org.apache.bcel.generic.INVOKEINTERFACE invoke =
              (org.apache.bcel.generic.INVOKEINTERFACE)
                ins;
            java.lang.String mName =
              invoke.
              getMethodName(
                cpg);
            if (!"setAttribute".
                  equals(
                    mName)) {
                continue;
            }
            java.lang.String cName =
              invoke.
              getClassName(
                cpg);
            if (!"javax.servlet.http.HttpSession".
                  equals(
                    cName)) {
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
            if (!(operandType instanceof org.apache.bcel.generic.ReferenceType)) {
                continue;
            }
            org.apache.bcel.generic.ReferenceType refType =
              (org.apache.bcel.generic.ReferenceType)
                operandType;
            if (refType.
                  equals(
                    edu.umd.cs.findbugs.ba.type.NullType.
                      instance(
                        ))) {
                continue;
            }
            try {
                double isSerializable =
                  edu.umd.cs.findbugs.DeepSubtypeAnalysis.
                  isDeepSerializable(
                    refType);
                if (isSerializable <
                      0.9) {
                    edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation =
                      edu.umd.cs.findbugs.SourceLineAnnotation.
                      fromVisitedInstruction(
                        classContext,
                        methodGen,
                        sourceFile,
                        handle);
                    org.apache.bcel.generic.ReferenceType problem =
                      edu.umd.cs.findbugs.DeepSubtypeAnalysis.
                      getLeastSerializableTypeComponent(
                        refType);
                    bugAccumulator.
                      accumulateBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "J2EE_STORE_OF_NON_SERIALIZABLE_OBJECT_INTO_SESSION",
                          isSerializable <
                            0.15
                            ? HIGH_PRIORITY
                            : (isSerializable >
                                 0.5
                                 ? LOW_PRIORITY
                                 : NORMAL_PRIORITY)).
                          addClassAndMethod(
                            methodGen,
                            sourceFile).
                          addType(
                            problem).
                          describe(
                            edu.umd.cs.findbugs.TypeAnnotation.
                              FOUND_ROLE),
                        sourceLineAnnotation);
                }
            }
            catch (java.lang.ClassNotFoundException e) {
                
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
      ("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");
}
