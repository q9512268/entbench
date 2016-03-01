package edu.umd.cs.findbugs.detect;
public class ComparatorIdiom extends edu.umd.cs.findbugs.visitclass.PreorderVisitor implements edu.umd.cs.findbugs.Detector {
    edu.umd.cs.findbugs.BugReporter bugReporter;
    public ComparatorIdiom(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        classContext.
          getJavaClass(
            ).
          accept(
            this);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) { if (edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                                                       instanceOf(
                                                                         obj,
                                                                         "java.util.Comparator") &&
                                                                       !edu.umd.cs.findbugs.util.ClassName.
                                                                       isAnonymous(
                                                                         getClassName(
                                                                           )) &&
                                                                       !edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                                                       instanceOf(
                                                                         obj,
                                                                         "java.io.Serializable")) {
                                                                     int priority =
                                                                       NORMAL_PRIORITY;
                                                                     if (obj.
                                                                           isInterface(
                                                                             ) ||
                                                                           obj.
                                                                           isAbstract(
                                                                             )) {
                                                                         return;
                                                                     }
                                                                     double easilySerializable =
                                                                       1.0;
                                                                     for (org.apache.bcel.classfile.Field f
                                                                           :
                                                                           obj.
                                                                            getFields(
                                                                              )) {
                                                                         try {
                                                                             if (f.
                                                                                   getName(
                                                                                     ).
                                                                                   startsWith(
                                                                                     "this$")) {
                                                                                 return;
                                                                             }
                                                                             java.lang.String signature =
                                                                               f.
                                                                               getSignature(
                                                                                 );
                                                                             char firstChar =
                                                                               signature.
                                                                               charAt(
                                                                                 0);
                                                                             if (firstChar ==
                                                                                   'L' ||
                                                                                   firstChar ==
                                                                                   '[') {
                                                                                 easilySerializable *=
                                                                                   edu.umd.cs.findbugs.DeepSubtypeAnalysis.
                                                                                     isDeepSerializable(
                                                                                       signature);
                                                                             }
                                                                         }
                                                                         catch (java.lang.ClassNotFoundException e) {
                                                                             easilySerializable =
                                                                               0.0;
                                                                             break;
                                                                         }
                                                                     }
                                                                     if (easilySerializable <
                                                                           0.9) {
                                                                         priority =
                                                                           LOW_PRIORITY;
                                                                     }
                                                                     bugReporter.
                                                                       reportBug(
                                                                         new edu.umd.cs.findbugs.BugInstance(
                                                                           this,
                                                                           "SE_COMPARATOR_SHOULD_BE_SERIALIZABLE",
                                                                           priority).
                                                                           addClass(
                                                                             this));
                                                                 }
    }
    @java.lang.Override
    public void report() {  }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4fR68gn+fEFomxGv2Fz5L+MGBuLVGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
