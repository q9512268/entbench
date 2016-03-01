package edu.umd.cs.findbugs.detect;
public class CheckImmutableAnnotation extends edu.umd.cs.findbugs.visitclass.PreorderVisitor implements edu.umd.cs.findbugs.Detector {
    edu.umd.cs.findbugs.BugReporter bugReporter;
    public CheckImmutableAnnotation(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitJavaClass(org.apache.bcel.classfile.JavaClass obj) {
        edu.umd.cs.findbugs.ba.JCIPAnnotationDatabase jcipAnotationDatabase =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          getJCIPAnnotationDatabase(
            );
        if (jcipAnotationDatabase.
              hasClassAnnotation(
                obj.
                  getClassName(
                    ).
                  replace(
                    '/',
                    '.'),
                "Immutable")) {
            super.
              visitJavaClass(
                obj);
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Field obj) { if (!obj.
                                                                   isFinal(
                                                                     ) &&
                                                                   !obj.
                                                                   isTransient(
                                                                     ) &&
                                                                   !obj.
                                                                   isVolatile(
                                                                     )) {
                                                                 bugReporter.
                                                                   reportBug(
                                                                     new edu.umd.cs.findbugs.BugInstance(
                                                                       this,
                                                                       "JCIP_FIELD_ISNT_FINAL_IN_IMMUTABLE_CLASS",
                                                                       NORMAL_PRIORITY).
                                                                       addClass(
                                                                         this).
                                                                       addVisitedField(
                                                                         this));
                                                             }
    }
    @java.lang.Override
    public void report() {  }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        classContext.
          getJavaClass(
            ).
          accept(
            this);
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
       "12vqJQAA");
}
