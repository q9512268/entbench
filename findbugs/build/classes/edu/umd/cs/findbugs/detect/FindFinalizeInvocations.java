package edu.umd.cs.findbugs.detect;
public class FindFinalizeInvocations extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "ffi.debug");
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    public FindFinalizeInvocations(edu.umd.cs.findbugs.BugReporter bugReporter) {
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
    boolean sawSuperFinalize;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) { if (DEBUG) {
                                                                  java.lang.System.
                                                                    out.
                                                                    println(
                                                                      "FFI: visiting " +
                                                                      getFullyQualifiedMethodName(
                                                                        ));
                                                              }
                                                              if ("finalize".
                                                                    equals(
                                                                      getMethodName(
                                                                        )) &&
                                                                    "()V".
                                                                    equals(
                                                                      getMethodSig(
                                                                        )) &&
                                                                    (obj.
                                                                       getAccessFlags(
                                                                         ) &
                                                                       ACC_PUBLIC) !=
                                                                    0) {
                                                                  bugReporter.
                                                                    reportBug(
                                                                      new edu.umd.cs.findbugs.BugInstance(
                                                                        this,
                                                                        "FI_PUBLIC_SHOULD_BE_PROTECTED",
                                                                        NORMAL_PRIORITY).
                                                                        addClassAndMethod(
                                                                          this));
                                                              }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        sawSuperFinalize =
          false;
        super.
          visit(
            obj);
        bugAccumulator.
          reportAccumulatedBugs(
            );
        if (!"finalize".
              equals(
                getMethodName(
                  )) ||
              !"()V".
              equals(
                getMethodSig(
                  ))) {
            return;
        }
        java.lang.String overridesFinalizeIn =
          edu.umd.cs.findbugs.Lookup.
          findSuperImplementor(
            getDottedClassName(
              ),
            "finalize",
            "()V",
            bugReporter);
        boolean superHasNoFinalizer =
          "java.lang.Object".
          equals(
            overridesFinalizeIn);
        if (obj.
              getCode(
                ).
              length ==
              1) {
            if (superHasNoFinalizer) {
                if (!getMethod(
                       ).
                      isFinal(
                        )) {
                    bugReporter.
                      reportBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "FI_EMPTY",
                          NORMAL_PRIORITY).
                          addClassAndMethod(
                            this));
                }
            }
            else {
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "FI_NULLIFY_SUPER",
                      NORMAL_PRIORITY).
                      addClassAndMethod(
                        this).
                      addClass(
                        overridesFinalizeIn));
            }
        }
        else
            if (obj.
                  getCode(
                    ).
                  length ==
                  5 &&
                  sawSuperFinalize) {
                bugReporter.
                  reportBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "FI_USELESS",
                      NORMAL_PRIORITY).
                      addClassAndMethod(
                        this));
            }
            else
                if (!sawSuperFinalize &&
                      !superHasNoFinalizer) {
                    bugReporter.
                      reportBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          this,
                          "FI_MISSING_SUPER_CALL",
                          NORMAL_PRIORITY).
                          addClassAndMethod(
                            this).
                          addClass(
                            overridesFinalizeIn));
                }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen ==
                                            INVOKEVIRTUAL &&
                                            "finalize".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            "()V".
                                            equals(
                                              getSigConstantOperand(
                                                ))) {
                                          bugAccumulator.
                                            accumulateBug(
                                              new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                "FI_EXPLICIT_INVOCATION",
                                                "finalize".
                                                  equals(
                                                    getMethodName(
                                                      )) &&
                                                  "()V".
                                                  equals(
                                                    getMethodSig(
                                                      ))
                                                  ? HIGH_PRIORITY
                                                  : NORMAL_PRIORITY).
                                                addClassAndMethod(
                                                  this).
                                                addCalledMethod(
                                                  this),
                                              this);
                                      }
                                      if (seen ==
                                            INVOKESPECIAL &&
                                            "finalize".
                                            equals(
                                              getNameConstantOperand(
                                                ))) {
                                          sawSuperFinalize =
                                            true;
                                      } }
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
