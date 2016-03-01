package edu.umd.cs.findbugs.detect;
public class PublicSemaphores extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private static final int SEEN_NOTHING = 0;
    private static final int SEEN_ALOAD_0 = 1;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private int state;
    private boolean alreadyReported;
    public PublicSemaphores(edu.umd.cs.findbugs.BugReporter bugReporter) {
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
        if (!cls.
              isPublic(
                ) ||
              cls.
              getClassName(
                ).
              indexOf(
                '$') >=
              0) {
            return;
        }
        alreadyReported =
          false;
        super.
          visitClassContext(
            classContext);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { org.apache.bcel.classfile.Method m =
                                                              getMethod(
                                                                );
                                                            if (m.
                                                                  isStatic(
                                                                    ) ||
                                                                  alreadyReported) {
                                                                return;
                                                            }
                                                            state =
                                                              SEEN_NOTHING;
                                                            super.
                                                              visit(
                                                                obj);
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (alreadyReported) {
                                          return;
                                      }
                                      switch (state) {
                                          case SEEN_NOTHING:
                                              if (seen ==
                                                    ALOAD_0) {
                                                  state =
                                                    SEEN_ALOAD_0;
                                              }
                                              break;
                                          case SEEN_ALOAD_0:
                                              if (seen ==
                                                    INVOKEVIRTUAL &&
                                                    "java/lang/Object".
                                                    equals(
                                                      getClassConstantOperand(
                                                        ))) {
                                                  java.lang.String methodName =
                                                    getNameConstantOperand(
                                                      );
                                                  if ("wait".
                                                        equals(
                                                          methodName) ||
                                                        "notify".
                                                        equals(
                                                          methodName) ||
                                                        "notifyAll".
                                                        equals(
                                                          methodName)) {
                                                      bugReporter.
                                                        reportBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "PS_PUBLIC_SEMAPHORES",
                                                            NORMAL_PRIORITY).
                                                            addClassAndMethod(
                                                              this).
                                                            addSourceLine(
                                                              this));
                                                      alreadyReported =
                                                        true;
                                                  }
                                              }
                                              state =
                                                SEEN_NOTHING;
                                              break;
                                          default:
                                              break;
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Mx4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9NyDN36Z8rLB6fb95z78Z08K32584HUcXj59gc+LJH+S+cznB9+q/MeDytWT" +
       "zfz7rkGc7/TC+S38m6EWJ6EnnNvIf/v5A8T3ggc5mgfk4v7d6Uxfvnn3nr2l" +
       "XDiFunCS9cxlMydL+3k5uolS0nnlNU6zfqJIfgSYZGpGZny266WbValvqqcW" +
       "+qPnLfTREws94fHO6X7bONXC0FS11zDq+8+cyoJPndfs0+DBjjSL/bNo9ik/" +
       "1A+lQFIM7VBWNOewvEpU3JA4xH11v0X4i6+h1F8qkp+LK9dKpRYvnz5V2s8/" +
       "UGlF8Wf/0ep5BjzMkXqYf1L1FK+TssHnXkP4zxfJfwfeH0nZOABxnnZBAb/6" +
       "T6iAPK7cvnilojgffut997f2d46Un3751sNveXn2u+WtgpN7QY/QlYfXieOc" +
       "PaY7k78ehNraLKV7ZH9oF5R/X4grTz74rkdcub7PlFz/j32XL8aVN13SJQbj" +
       "H2XPtv7duHLztHVcOVDOVf9+XLlxVB1XroL0bOUfgCJQWWS/FBxb9vOXnn5v" +
       "AZdgnngF4Kvp6Segf+UMbh8ZWzmDd77e/vRJl7NXFgqsL2/fHeNysr9/d0/5" +
       "7MsU+91fbf/Y/soEcLbdrqDyMF25sb+9cYLt73wgtWNa18lnv/bYzzzy7uN1" +
       "6LE9w6eGf4a3py+/n9Bzg7i8UbD7xbf8/Ht//OUvlSem/wCCjs+uFikAAA==");
}
