package edu.umd.cs.findbugs.detect;
public class DontUseEnum extends edu.umd.cs.findbugs.bcel.PreorderDetector {
    edu.umd.cs.findbugs.BugReporter bugReporter;
    public DontUseEnum(edu.umd.cs.findbugs.BugReporter bugReporter) { super(
                                                                        );
                                                                      this.
                                                                        bugReporter =
                                                                        bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        if (isReservedName(
              obj.
                getName(
                  ))) {
            edu.umd.cs.findbugs.BugInstance bug =
              new edu.umd.cs.findbugs.BugInstance(
              this,
              "NM_FUTURE_KEYWORD_USED_AS_MEMBER_IDENTIFIER",
              isVisible(
                obj)
                ? HIGH_PRIORITY
                : NORMAL_PRIORITY).
              addClassAndMethod(
                this);
            bugReporter.
              reportBug(
                bug);
        }
    }
    private boolean isVisible(org.apache.bcel.classfile.FieldOrMethod obj) {
        return (obj.
                  getAccessFlags(
                    ) &
                  ACC_PUBLIC) !=
          0 ||
          (obj.
             getAccessFlags(
               ) &
             ACC_PROTECTED) !=
          0;
    }
    private boolean isReservedName(java.lang.String name) {
        return "enum".
          equals(
            name) ||
          "assert".
          equals(
            name);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Field obj) {
        if (isReservedName(
              obj.
                getName(
                  ))) {
            edu.umd.cs.findbugs.BugInstance bug =
              new edu.umd.cs.findbugs.BugInstance(
              this,
              "NM_FUTURE_KEYWORD_USED_AS_MEMBER_IDENTIFIER",
              isVisible(
                obj)
                ? HIGH_PRIORITY
                : NORMAL_PRIORITY).
              addClass(
                this).
              addField(
                this);
            bugReporter.
              reportBug(
                bug);
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.LocalVariable obj) {
        if (isReservedName(
              obj.
                getName(
                  ))) {
            edu.umd.cs.findbugs.LocalVariableAnnotation var =
              new edu.umd.cs.findbugs.LocalVariableAnnotation(
              obj.
                getName(
                  ),
              obj.
                getIndex(
                  ),
              obj.
                getStartPC(
                  ));
            edu.umd.cs.findbugs.SourceLineAnnotation source =
              edu.umd.cs.findbugs.SourceLineAnnotation.
              fromVisitedInstruction(
                getClassContext(
                  ),
                this,
                obj.
                  getStartPC(
                    ));
            edu.umd.cs.findbugs.BugInstance bug =
              new edu.umd.cs.findbugs.BugInstance(
              this,
              "NM_FUTURE_KEYWORD_USED_AS_IDENTIFIER",
              NORMAL_PRIORITY).
              addClassAndMethod(
                this).
              add(
                var).
              add(
                source);
            bugReporter.
              reportBug(
                bug);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3sgnv8urWLz3L1l0QfriHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gdD/AeakNpUvJwAA");
}
