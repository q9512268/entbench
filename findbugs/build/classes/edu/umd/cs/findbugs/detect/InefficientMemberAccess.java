package edu.umd.cs.findbugs.detect;
public class InefficientMemberAccess extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    public static final java.lang.String ACCESS_PREFIX = "access$";
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private java.lang.String clsName;
    public InefficientMemberAccess(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        org.apache.bcel.classfile.JavaClass cls =
          classContext.
          getJavaClass(
            );
        clsName =
          cls.
            getClassName(
              );
        if (clsName.
              indexOf(
                '$') >=
              0) {
            super.
              visitClassContext(
                classContext);
        }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen == INVOKESTATIC) {
                                          java.lang.String methodName =
                                            getNameConstantOperand(
                                              );
                                          if (!methodName.
                                                startsWith(
                                                  ACCESS_PREFIX)) {
                                              return;
                                          }
                                          java.lang.String methodSig =
                                            getSigConstantOperand(
                                              );
                                          org.apache.bcel.generic.Type[] argTypes =
                                            org.apache.bcel.generic.Type.
                                            getArgumentTypes(
                                              methodSig);
                                          if (argTypes.
                                                length <
                                                1 ||
                                                argTypes.
                                                  length >
                                                2) {
                                              return;
                                          }
                                          java.lang.String parCls =
                                            argTypes[0].
                                            getSignature(
                                              );
                                          if (parCls.
                                                length(
                                                  ) <
                                                3) {
                                              return;
                                          }
                                          parCls =
                                            parCls.
                                              substring(
                                                1,
                                                parCls.
                                                  length(
                                                    ) -
                                                  1);
                                          if (!parCls.
                                                equals(
                                                  getClassConstantOperand(
                                                    ))) {
                                              return;
                                          }
                                          if (argTypes.
                                                length ==
                                                2 &&
                                                !argTypes[1].
                                                getSignature(
                                                  ).
                                                equals(
                                                  new edu.umd.cs.findbugs.ba.SignatureParser(
                                                    methodSig).
                                                    getReturnTypeSignature(
                                                      ))) {
                                              return;
                                          }
                                          edu.umd.cs.findbugs.ba.InnerClassAccess access =
                                            null;
                                          try {
                                              java.lang.String dottedClassConstantOperand =
                                                getDottedClassConstantOperand(
                                                  );
                                              access =
                                                edu.umd.cs.findbugs.ba.AnalysisContext.
                                                  currentAnalysisContext(
                                                    ).
                                                  getInnerClassAccessMap(
                                                    ).
                                                  getInnerClassAccess(
                                                    dottedClassConstantOperand,
                                                    methodName);
                                              if (access !=
                                                    null) {
                                                  if (!access.
                                                        getField(
                                                          ).
                                                        getClassName(
                                                          ).
                                                        equals(
                                                          dottedClassConstantOperand)) {
                                                      return;
                                                  }
                                                  if (access.
                                                        getField(
                                                          ).
                                                        isSynthetic(
                                                          )) {
                                                      return;
                                                  }
                                              }
                                          }
                                          catch (java.lang.ClassNotFoundException e) {
                                              
                                          }
                                          edu.umd.cs.findbugs.BugInstance bug =
                                            new edu.umd.cs.findbugs.BugInstance(
                                            this,
                                            "IMA_INEFFICIENT_MEMBER_ACCESS",
                                            LOW_PRIORITY).
                                            addClassAndMethod(
                                              this).
                                            addSourceLine(
                                              this);
                                          if (access !=
                                                null) {
                                              bug.
                                                addField(
                                                  access.
                                                    getField(
                                                      ));
                                          }
                                          bugReporter.
                                            reportBug(
                                              bug);
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
       "3f17T33suW8Uh97/A80hHUuJJQAA");
}
