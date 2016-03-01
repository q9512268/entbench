package edu.umd.cs.findbugs.detect;
public class IteratorIdioms extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private final edu.umd.cs.findbugs.classfile.ClassDescriptor iteratorDescriptor =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        java.util.Iterator.class);
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private boolean sawNoSuchElement;
    private boolean sawCall;
    private boolean shouldVisitCode;
    public IteratorIdioms(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          getSubtypes2(
            );
        try {
            if (subtypes2.
                  isSubtype(
                    classContext.
                      getClassDescriptor(
                        ),
                    iteratorDescriptor)) {
                super.
                  visitClassContext(
                    classContext);
            }
        }
        catch (java.lang.ClassNotFoundException e) {
            bugReporter.
              reportMissingClass(
                e);
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method method) {
        if (method.
              isPublic(
                ) &&
              "next".
              equals(
                method.
                  getName(
                    )) &&
              method.
                getArgumentTypes(
                  ).
                length ==
              0) {
            shouldVisitCode =
              true;
            super.
              visit(
                method);
        }
        else {
            shouldVisitCode =
              false;
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        if (!shouldVisitCode) {
            return;
        }
        sawNoSuchElement =
          false;
        sawCall =
          false;
        super.
          visit(
            obj);
        if (!sawNoSuchElement) {
            edu.umd.cs.findbugs.BugInstance bug =
              new edu.umd.cs.findbugs.BugInstance(
              this,
              "IT_NO_SUCH_ELEMENT",
              sawCall
                ? LOW_PRIORITY
                : NORMAL_PRIORITY);
            bug.
              addClassAndMethod(
                this);
            bugReporter.
              reportBug(
                bug);
        }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen == NEW && "java/util/NoSuchElementException".
                                            equals(
                                              getClassConstantOperand(
                                                ))) {
                                          sawNoSuchElement =
                                            true;
                                      }
                                      else
                                          if (seen ==
                                                INVOKESPECIAL ||
                                                seen ==
                                                INVOKEVIRTUAL ||
                                                seen ==
                                                INVOKEINTERFACE) {
                                              sawCall =
                                                true;
                                              java.lang.String name =
                                                getNameConstantOperand(
                                                  ).
                                                toLowerCase(
                                                  );
                                              if (name.
                                                    indexOf(
                                                      "next") >=
                                                    0 ||
                                                    name.
                                                    indexOf(
                                                      "previous") >=
                                                    0) {
                                                  sawNoSuchElement =
                                                    true;
                                              }
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
