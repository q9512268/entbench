package edu.umd.cs.findbugs.detect;
public class BadAppletConstructor extends edu.umd.cs.findbugs.BytecodeScanningDetector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private final org.apache.bcel.classfile.JavaClass appletClass;
    private boolean inConstructor;
    public BadAppletConstructor(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        org.apache.bcel.classfile.JavaClass appletClass =
          null;
        try {
            appletClass =
              org.apache.bcel.Repository.
                lookupClass(
                  "java.applet.Applet");
        }
        catch (java.lang.ClassNotFoundException cnfe) {
            bugReporter.
              reportMissingClass(
                cnfe);
        }
        this.
          appletClass =
          appletClass;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        if (appletClass ==
              null) {
            return;
        }
        org.apache.bcel.classfile.JavaClass cls =
          classContext.
          getJavaClass(
            );
        try {
            if (cls.
                  instanceOf(
                    appletClass)) {
                cls.
                  accept(
                    this);
            }
        }
        catch (java.lang.ClassNotFoundException cnfe) {
            bugReporter.
              reportMissingClass(
                cnfe);
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) { inConstructor =
                                                                "<init>".
                                                                  equals(
                                                                    obj.
                                                                      getName(
                                                                        ));
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { if (inConstructor) {
                                                                super.
                                                                  visit(
                                                                    obj);
                                                            } }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen == INVOKEVIRTUAL) {
                                          java.lang.String method =
                                            getNameConstantOperand(
                                              );
                                          java.lang.String signature =
                                            getSigConstantOperand(
                                              );
                                          if (("getDocumentBase".
                                                 equals(
                                                   method) ||
                                                 "getCodeBase".
                                                 equals(
                                                   method)) &&
                                                "()Ljava/net/URL;".
                                                equals(
                                                  signature) ||
                                                "getAppletContext".
                                                equals(
                                                  method) &&
                                                "()Ljava/applet/AppletContext;".
                                                equals(
                                                  signature) ||
                                                "getParameter".
                                                equals(
                                                  method) &&
                                                "(Ljava/lang/String;)Ljava/lang/String;".
                                                equals(
                                                  signature)) {
                                              bugReporter.
                                                reportBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "BAC_BAD_APPLET_CONSTRUCTOR",
                                                    NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addSourceLine(
                                                      this));
                                          }
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "39VFUJfIRzheEa84/PW/PRe3fcodAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vysoAAA=");
}
