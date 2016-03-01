package edu.umd.cs.findbugs.detect;
public class MethodReturnValueStreamFactory implements edu.umd.cs.findbugs.detect.StreamFactory {
    private static final java.util.BitSet invokeOpcodeSet = new java.util.BitSet(
      );
    static { invokeOpcodeSet.set(org.apache.bcel.Constants.INVOKEINTERFACE);
             invokeOpcodeSet.set(org.apache.bcel.Constants.INVOKESPECIAL);
             invokeOpcodeSet.set(org.apache.bcel.Constants.INVOKESTATIC);
             invokeOpcodeSet.set(org.apache.bcel.Constants.INVOKEVIRTUAL);
    }
    private final org.apache.bcel.generic.ObjectType baseClassType;
    private final java.lang.String methodName;
    private final java.lang.String methodSig;
    private final boolean isUninteresting;
    private java.lang.String bugType;
    public MethodReturnValueStreamFactory(java.lang.String baseClass,
                                          java.lang.String methodName,
                                          java.lang.String methodSig) {
        super(
          );
        this.
          baseClassType =
          edu.umd.cs.findbugs.ba.ObjectTypeFactory.
            getInstance(
              baseClass);
        this.
          methodName =
          methodName;
        this.
          methodSig =
          methodSig;
        this.
          isUninteresting =
          true;
    }
    public MethodReturnValueStreamFactory(java.lang.String baseClass,
                                          java.lang.String methodName,
                                          java.lang.String methodSig,
                                          java.lang.String bugType) {
        super(
          );
        this.
          baseClassType =
          edu.umd.cs.findbugs.ba.ObjectTypeFactory.
            getInstance(
              baseClass);
        this.
          methodName =
          methodName;
        this.
          methodSig =
          methodSig;
        this.
          isUninteresting =
          false;
        this.
          bugType =
          bugType;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.detect.Stream createStream(edu.umd.cs.findbugs.ba.Location location,
                                                          org.apache.bcel.generic.ObjectType type,
                                                          org.apache.bcel.generic.ConstantPoolGen cpg,
                                                          edu.umd.cs.findbugs.ba.RepositoryLookupFailureCallback lookupFailureCallback) {
        try {
            org.apache.bcel.generic.Instruction ins =
              location.
              getHandle(
                ).
              getInstruction(
                );
            short opcode =
              ins.
              getOpcode(
                );
            if (!invokeOpcodeSet.
                  get(
                    opcode)) {
                return null;
            }
            org.apache.bcel.generic.InvokeInstruction inv =
              (org.apache.bcel.generic.InvokeInstruction)
                ins;
            org.apache.bcel.generic.ReferenceType classType =
              inv.
              getReferenceType(
                cpg);
            if (!edu.umd.cs.findbugs.ba.Hierarchy.
                  isSubtype(
                    classType,
                    baseClassType)) {
                return null;
            }
            java.lang.String methodName =
              inv.
              getMethodName(
                cpg);
            java.lang.String methodSig =
              inv.
              getSignature(
                cpg);
            if (!this.
                   methodName.
                  equals(
                    methodName) ||
                  !this.
                     methodSig.
                  equals(
                    methodSig)) {
                return null;
            }
            java.lang.String streamClass =
              type.
              getClassName(
                );
            if ("java.sql.CallableStatement".
                  equals(
                    streamClass)) {
                streamClass =
                  "java.sql.PreparedStatement";
            }
            edu.umd.cs.findbugs.detect.Stream result =
              new edu.umd.cs.findbugs.detect.Stream(
              location,
              streamClass,
              streamClass).
              setIgnoreImplicitExceptions(
                true).
              setIsOpenOnCreation(
                true);
            if (!isUninteresting) {
                result.
                  setInteresting(
                    bugType);
            }
            return result;
        }
        catch (java.lang.ClassNotFoundException e) {
            lookupFailureCallback.
              reportMissingClass(
                e);
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "khM6d+FjwUqKT/LNH/FXNlz/L88ofbPCHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
