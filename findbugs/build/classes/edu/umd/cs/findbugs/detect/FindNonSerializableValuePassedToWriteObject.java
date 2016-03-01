package edu.umd.cs.findbugs.detect;
public class FindNonSerializableValuePassedToWriteObject implements edu.umd.cs.findbugs.Detector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private static final boolean DEBUG = false;
    public FindNonSerializableValuePassedToWriteObject(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
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
            int pc =
              handle.
              getPosition(
                );
            org.apache.bcel.generic.Instruction ins =
              handle.
              getInstruction(
                );
            if (!(ins instanceof org.apache.bcel.generic.InvokeInstruction)) {
                continue;
            }
            org.apache.bcel.generic.InvokeInstruction invoke =
              (org.apache.bcel.generic.InvokeInstruction)
                ins;
            java.lang.String mName =
              invoke.
              getMethodName(
                cpg);
            if (!"writeObject".
                  equals(
                    mName)) {
                continue;
            }
            java.lang.String cName =
              invoke.
              getClassName(
                cpg);
            if (!"java.io.ObjectOutput".
                  equals(
                    cName) &&
                  !"java.io.ObjectOutputStream".
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
                if (isSerializable >=
                      0.9) {
                    continue;
                }
                org.apache.bcel.generic.ReferenceType problem =
                  edu.umd.cs.findbugs.DeepSubtypeAnalysis.
                  getLeastSerializableTypeComponent(
                    refType);
                double isRemote =
                  edu.umd.cs.findbugs.DeepSubtypeAnalysis.
                  isDeepRemote(
                    refType);
                if (isRemote >=
                      0.9) {
                    continue;
                }
                if (isSerializable <
                      isRemote) {
                    isSerializable =
                      isRemote;
                }
                edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation =
                  edu.umd.cs.findbugs.SourceLineAnnotation.
                  fromVisitedInstruction(
                    classContext,
                    methodGen,
                    sourceFile,
                    handle);
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "DMI_NONSERIALIZABLE_OBJECT_WRITTEN",
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
                          FOUND_ROLE).
                      addSourceLine(
                        sourceLineAnnotation));
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
