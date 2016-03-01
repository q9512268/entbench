package edu.umd.cs.findbugs.ba;
public abstract class ResourceValueFrameModelingVisitor extends edu.umd.cs.findbugs.ba.AbstractFrameModelingVisitor<edu.umd.cs.findbugs.ba.ResourceValue,edu.umd.cs.findbugs.ba.ResourceValueFrame> {
    public ResourceValueFrameModelingVisitor(org.apache.bcel.generic.ConstantPoolGen cpg) {
        super(
          cpg);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.ba.ResourceValue getDefaultValue() {
        return edu.umd.cs.findbugs.ba.ResourceValue.
          notInstance(
            );
    }
    public abstract void transferInstruction(org.apache.bcel.generic.InstructionHandle handle,
                                             edu.umd.cs.findbugs.ba.BasicBlock basicBlock)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException;
    private void handleFieldStore(org.apache.bcel.generic.FieldInstruction ins) {
        try {
            edu.umd.cs.findbugs.ba.ResourceValueFrame frame =
              getFrame(
                );
            edu.umd.cs.findbugs.ba.ResourceValue topValue =
              frame.
              getTopValue(
                );
            if (topValue.
                  equals(
                    edu.umd.cs.findbugs.ba.ResourceValue.
                      instance(
                        ))) {
                frame.
                  setStatus(
                    edu.umd.cs.findbugs.ba.ResourceValueFrame.
                      ESCAPED);
            }
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            throw new edu.umd.cs.findbugs.ba.InvalidBytecodeException(
              "Stack underflow",
              e);
        }
        handleNormalInstruction(
          ins);
    }
    @java.lang.Override
    public void visitPUTFIELD(org.apache.bcel.generic.PUTFIELD putfield) {
        handleFieldStore(
          putfield);
    }
    private void handleArrayStore(org.apache.bcel.generic.ArrayInstruction ins) {
        try {
            edu.umd.cs.findbugs.ba.ResourceValueFrame frame =
              getFrame(
                );
            edu.umd.cs.findbugs.ba.ResourceValue topValue =
              frame.
              getTopValue(
                );
            if (topValue.
                  equals(
                    edu.umd.cs.findbugs.ba.ResourceValue.
                      instance(
                        ))) {
                frame.
                  setStatus(
                    edu.umd.cs.findbugs.ba.ResourceValueFrame.
                      ESCAPED);
            }
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            throw new edu.umd.cs.findbugs.ba.InvalidBytecodeException(
              "Stack underflow",
              e);
        }
        handleNormalInstruction(
          ins);
    }
    @java.lang.Override
    public void visitAASTORE(org.apache.bcel.generic.AASTORE arr) {
        handleArrayStore(
          arr);
    }
    @java.lang.Override
    public void visitPUTSTATIC(org.apache.bcel.generic.PUTSTATIC putstatic) {
        handleFieldStore(
          putstatic);
    }
    protected boolean instanceEscapes(org.apache.bcel.generic.InvokeInstruction inv,
                                      int instanceArgNum) {
        return true;
    }
    private void handleInvoke(org.apache.bcel.generic.InvokeInstruction inv) {
        edu.umd.cs.findbugs.ba.ResourceValueFrame frame =
          getFrame(
            );
        int numSlots =
          frame.
          getNumSlots(
            );
        int numConsumed =
          getNumWordsConsumed(
            inv);
        int instanceArgNum =
          -1;
        for (int i =
               numSlots -
               numConsumed,
               argCount =
                 0;
             i <
               numSlots;
             ++i,
               ++argCount) {
            edu.umd.cs.findbugs.ba.ResourceValue value =
              frame.
              getValue(
                i);
            if (value.
                  equals(
                    edu.umd.cs.findbugs.ba.ResourceValue.
                      instance(
                        ))) {
                instanceArgNum =
                  argCount;
                break;
            }
        }
        if (instanceArgNum >=
              0 &&
              instanceEscapes(
                inv,
                instanceArgNum)) {
            frame.
              setStatus(
                edu.umd.cs.findbugs.ba.ResourceValueFrame.
                  ESCAPED);
        }
        handleNormalInstruction(
          inv);
    }
    @java.lang.Override
    public void visitCHECKCAST(org.apache.bcel.generic.CHECKCAST obj) {
        try {
            edu.umd.cs.findbugs.ba.ResourceValueFrame frame =
              getFrame(
                );
            edu.umd.cs.findbugs.ba.ResourceValue topValue;
            topValue =
              frame.
                getTopValue(
                  );
            if (topValue.
                  equals(
                    edu.umd.cs.findbugs.ba.ResourceValue.
                      instance(
                        ))) {
                frame.
                  setStatus(
                    edu.umd.cs.findbugs.ba.ResourceValueFrame.
                      ESCAPED);
            }
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Analysis error",
                e);
        }
    }
    @java.lang.Override
    public void visitINVOKEVIRTUAL(org.apache.bcel.generic.INVOKEVIRTUAL inv) {
        handleInvoke(
          inv);
    }
    @java.lang.Override
    public void visitINVOKEINTERFACE(org.apache.bcel.generic.INVOKEINTERFACE inv) {
        handleInvoke(
          inv);
    }
    @java.lang.Override
    public void visitINVOKESPECIAL(org.apache.bcel.generic.INVOKESPECIAL inv) {
        handleInvoke(
          inv);
    }
    @java.lang.Override
    public void visitINVOKESTATIC(org.apache.bcel.generic.INVOKESTATIC inv) {
        handleInvoke(
          inv);
    }
    @java.lang.Override
    public void visitARETURN(org.apache.bcel.generic.ARETURN ins) {
        try {
            edu.umd.cs.findbugs.ba.ResourceValueFrame frame =
              getFrame(
                );
            edu.umd.cs.findbugs.ba.ResourceValue topValue =
              frame.
              getTopValue(
                );
            if (topValue.
                  equals(
                    edu.umd.cs.findbugs.ba.ResourceValue.
                      instance(
                        ))) {
                frame.
                  setStatus(
                    edu.umd.cs.findbugs.ba.ResourceValueFrame.
                      ESCAPED);
            }
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            throw new edu.umd.cs.findbugs.ba.InvalidBytecodeException(
              "Stack underflow",
              e);
        }
        handleNormalInstruction(
          ins);
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
       "dsFZtbv3WO2O9/wePNlNGMSa7xuqdomm");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Klb2z1/3T9/1y899tbit8f8BxkERRXY+AAA=");
}
