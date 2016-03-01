package edu.umd.cs.findbugs.detect;
public class WaitInLoop extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    boolean sawWait = false;
    boolean sawAwait = false;
    boolean waitHasTimeout = false;
    boolean sawNotify = false;
    int notifyPC;
    int earliestJump = 0;
    int waitAt = 0;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    public WaitInLoop(edu.umd.cs.findbugs.BugReporter bugReporter) { super(
                                                                       );
                                                                     this.
                                                                       bugReporter =
                                                                       bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        sawWait =
          false;
        sawAwait =
          false;
        waitHasTimeout =
          false;
        sawNotify =
          false;
        earliestJump =
          9999999;
        super.
          visit(
            obj);
        if ((sawWait ||
               sawAwait) &&
              waitAt <
              earliestJump) {
            java.lang.String bugType =
              sawWait
              ? "WA_NOT_IN_LOOP"
              : "WA_AWAIT_NOT_IN_LOOP";
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  bugType,
                  waitHasTimeout
                    ? LOW_PRIORITY
                    : NORMAL_PRIORITY).
                  addClassAndMethod(
                    this).
                  addSourceLine(
                    this,
                    waitAt));
        }
        if (sawNotify) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "NO_NOTIFY_NOT_NOTIFYALL",
                  LOW_PRIORITY).
                  addClassAndMethod(
                    this).
                  addSourceLine(
                    this,
                    notifyPC));
        }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if ((seen == INVOKEVIRTUAL ||
                                             seen ==
                                             INVOKEINTERFACE) &&
                                            "notify".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            "()V".
                                            equals(
                                              getSigConstantOperand(
                                                ))) { sawNotify =
                                                        true;
                                                      notifyPC =
                                                        getPC(
                                                          );
                                      }
                                      if (!(sawWait || sawAwait) &&
                                            (seen ==
                                               INVOKEVIRTUAL ||
                                               seen ==
                                               INVOKEINTERFACE) &&
                                            (isMonitorWait(
                                               ) ||
                                               isConditionAwait(
                                                 ))) { if ("wait".
                                                             equals(
                                                               getNameConstantOperand(
                                                                 ))) {
                                                           sawWait =
                                                             true;
                                                       }
                                                       else {
                                                           sawAwait =
                                                             true;
                                                       }
                                                       waitHasTimeout =
                                                         !"()V".
                                                           equals(
                                                             getSigConstantOperand(
                                                               ));
                                                       waitAt =
                                                         getPC(
                                                           );
                                                       earliestJump =
                                                         getPC(
                                                           ) +
                                                           1;
                                                       return;
                                      }
                                      if (seen >=
                                            IFEQ &&
                                            seen <=
                                            GOTO ||
                                            seen >=
                                            IFNULL &&
                                            seen <=
                                            GOTO_W) {
                                          earliestJump =
                                            java.lang.Math.
                                              min(
                                                earliestJump,
                                                getBranchTarget(
                                                  ));
                                      } }
    private boolean isConditionAwait() { java.lang.String className =
                                           getClassConstantOperand(
                                             );
                                         java.lang.String name =
                                           getNameConstantOperand(
                                             );
                                         java.lang.String sig =
                                           getSigConstantOperand(
                                             );
                                         if (!"java/util/concurrent/locks/Condition".
                                               equals(
                                                 className)) {
                                             return false;
                                         }
                                         if (!name.
                                               startsWith(
                                                 "await")) {
                                             return false;
                                         }
                                         if ("await".
                                               equals(
                                                 name) &&
                                               ("()V".
                                                  equals(
                                                    sig) ||
                                                  "(JLjava/util/concurrent/TimeUnit;)V".
                                                  equals(
                                                    sig))) {
                                             return true;
                                         }
                                         if ("awaitNanos".
                                               equals(
                                                 name) &&
                                               "(J)V".
                                               equals(
                                                 sig)) {
                                             return true;
                                         }
                                         if ("awaitUninterruptibly".
                                               equals(
                                                 name) &&
                                               "()V".
                                               equals(
                                                 sig)) {
                                             return true;
                                         }
                                         if ("awaitUntil".
                                               equals(
                                                 name) &&
                                               "(Ljava/util/Date;)V".
                                               equals(
                                                 sig)) {
                                             return true;
                                         }
                                         return false;
    }
    private boolean isMonitorWait() { java.lang.String name =
                                        getNameConstantOperand(
                                          );
                                      java.lang.String sig =
                                        getSigConstantOperand(
                                          );
                                      return "wait".
                                        equals(
                                          name) &&
                                        ("()V".
                                           equals(
                                             sig) ||
                                           "(J)V".
                                           equals(
                                             sig) ||
                                           "(JI)V".
                                           equals(
                                             sig));
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "bUNbp9KT41zrObpu/L0YkuOq8FQfZOWp6/82f8+m4cEptNeLA1oKkvxR9/3P" +
       "7Dhfui0qbgTtArDoJtGP1OFPrbUG45ah+pPpcn+Li1XaOscK1gXN2rWzIpsW" +
       "gSpWopUMIxZopgINWatmDMWoTqVhFktJTImJi2W8L4OOIs0EJyfL9GMP4XAc" +
       "vGtUhoa6VLCtHNXktOszP/b7TH3BZwostYimBuvwWC8YhiGnWRk3+yydEk50" +
       "6mL+h/5TwOy8w1Hcjs/jFMKIlT4FER/FPk+W0fHTOJyyM3GvLjmO8lNXp4+H" +
       "6hSnH/kitCeiWRs8g47Ag1PV3pGA9urKECujnJfKrL2Mw285aRJ9X1pc+Lgl" +
       "oqu/350rJf2/CsIqddKRabKMgnB4oVgdYahlRH6zzNpbOLzOSYNsdmuqDEnj" +
       "imJdnP48dJHjpNa9GMabinlF35zs7yTSg0cba+YevfxlkUsK3zLqIStkLEXx" +
       "9tKe9yrdYBlZCFVvd9Z2a/IuJ/PD76qhLLFfBNvv2CjvczKzBApUk/lXL/Tf" +
       "QTAXmpOo5Fv+EAoOZxmqTBi9i5/AFCzi6z/1fLBbU/JCbBy4xGZbgoQmq0OF" +
       "HB/xpGlH++LQZp/r0Aoo3ltMTK7ii2E+EVr2N8OkdOLorp6rz1x8j32LCilh" +
       "YgKp1EHXaF/oFpLp0lBqeVpVO9vPzjg5fUW+7Gi2GXatf4HHRDshOAh7mR+4" +
       "YjTbCjeNrx7b+NivD1a9AH3yPhKhcH77iq9ucroFVcy+RHF3DIWHuPvsaP/B" +
       "+KY1mff/KC7HiN1NLwyHT0oDt7/SdXLk483iE9U0OCyWE3dKl46ru5k0avha" +
       "7RloyhS/HQo9OOprKMzinTsny4pvGoq/VNQq2hgztmqWmkYy0KzXuTP5IspX" +
       "f1i6HkBwZ5yjwzFpZ2rUPthmMtGt685FTMVrunDlwdA2KVIvXvGt4X+V2WgN" +
       "PCAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
