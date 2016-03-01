package edu.umd.cs.findbugs.detect;
public class CbeckMustOverrideSuperAnnotation extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    edu.umd.cs.findbugs.BugReporter bugReporter;
    edu.umd.cs.findbugs.classfile.ClassDescriptor mustOverrideAnnotation =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        javax.annotation.OverridingMethodsMustInvokeSuper.class);
    private final boolean testingEnabled;
    public CbeckMustOverrideSuperAnnotation(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        testingEnabled =
          edu.umd.cs.findbugs.SystemProperties.
            getBoolean(
              "report_TESTING_pattern_in_standard_detectors");
    }
    private boolean sawCallToSuper;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code code) { if (!testingEnabled) {
                                                                 return;
                                                             }
                                                             if (getMethod(
                                                                   ).
                                                                   isStatic(
                                                                     ) ||
                                                                   getMethod(
                                                                     ).
                                                                   isPrivate(
                                                                     )) {
                                                                 return;
                                                             }
                                                             edu.umd.cs.findbugs.ba.XMethod overrides =
                                                               edu.umd.cs.findbugs.Lookup.
                                                               findSuperImplementorAsXMethod(
                                                                 getThisClass(
                                                                   ),
                                                                 getMethodName(
                                                                   ),
                                                                 getMethodSig(
                                                                   ),
                                                                 bugReporter);
                                                             if (overrides ==
                                                                   null) {
                                                                 return;
                                                             }
                                                             edu.umd.cs.findbugs.classfile.analysis.AnnotationValue annotation =
                                                               overrides.
                                                               getAnnotation(
                                                                 mustOverrideAnnotation);
                                                             if (annotation ==
                                                                   null) {
                                                                 return;
                                                             }
                                                             sawCallToSuper =
                                                               false;
                                                             super.
                                                               visit(
                                                                 code);
                                                             if (!sawCallToSuper) {
                                                                 bugReporter.
                                                                   reportBug(
                                                                     new edu.umd.cs.findbugs.BugInstance(
                                                                       this,
                                                                       "TESTING",
                                                                       NORMAL_PRIORITY).
                                                                       addClassAndMethod(
                                                                         this).
                                                                       addString(
                                                                         "Method must invoke override method in superclass"));
                                                             }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen !=
                                            INVOKESPECIAL) {
                                          return;
                                      }
                                      java.lang.String calledClassName =
                                        getClassConstantOperand(
                                          );
                                      java.lang.String calledMethodName =
                                        getNameConstantOperand(
                                          );
                                      java.lang.String calledMethodSig =
                                        getSigConstantOperand(
                                          );
                                      if (calledClassName.
                                            equals(
                                              getSuperclassName(
                                                )) &&
                                            calledMethodName.
                                            equals(
                                              getMethodName(
                                                )) &&
                                            calledMethodSig.
                                            equals(
                                              getMethodSig(
                                                ))) {
                                          sawCallToSuper =
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
      ("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");
}
