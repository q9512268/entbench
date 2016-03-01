package edu.umd.cs.findbugs.detect;
public abstract class TypeReturnNull extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    protected final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    public TypeReturnNull(edu.umd.cs.findbugs.BugReporter bugReporter) { super(
                                                                           );
                                                                         this.
                                                                           bugAccumulator =
                                                                           new edu.umd.cs.findbugs.BugAccumulator(
                                                                             bugReporter);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code code) {
        edu.umd.cs.findbugs.ba.SignatureParser sp =
          new edu.umd.cs.findbugs.ba.SignatureParser(
          getMethodSig(
            ));
        java.lang.String returnSignature =
          sp.
          getReturnTypeSignature(
            );
        if (!matchesReturnSignature(
               returnSignature)) {
            return;
        }
        if (isExplicitlyNullable(
              )) {
            return;
        }
        super.
          visit(
            code);
        bugAccumulator.
          reportAccumulatedBugs(
            );
    }
    private boolean isExplicitlyNullable() { edu.umd.cs.findbugs.ba.AnalysisContext analysisContext =
                                               edu.umd.cs.findbugs.ba.AnalysisContext.
                                               currentAnalysisContext(
                                                 );
                                             edu.umd.cs.findbugs.ba.INullnessAnnotationDatabase nullnessAnnotationDatabase =
                                               analysisContext.
                                               getNullnessAnnotationDatabase(
                                                 );
                                             edu.umd.cs.findbugs.ba.XMethod xMethod =
                                               getXMethod(
                                                 );
                                             edu.umd.cs.findbugs.ba.NullnessAnnotation na =
                                               nullnessAnnotationDatabase.
                                               getResolvedAnnotation(
                                                 xMethod,
                                                 true);
                                             return na !=
                                               null &&
                                               na !=
                                               edu.umd.cs.findbugs.ba.NullnessAnnotation.
                                                 NONNULL;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen ==
                                            ARETURN &&
                                            getPrevOpcode(
                                              1) ==
                                            ACONST_NULL) {
                                          accumulateBug(
                                            );
                                      } }
    protected abstract boolean matchesReturnSignature(java.lang.String returnSignature);
    protected abstract void accumulateBug();
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "lp3XhTuPFI542P5FdLH58D9VgK4OFx0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
