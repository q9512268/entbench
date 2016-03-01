package edu.umd.cs.findbugs.detect;
public class FindNakedNotify extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    int stage = 0;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    boolean synchronizedMethod;
    private int notifyPC;
    public FindNakedNotify(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) { int flags =
                                                                obj.
                                                                getAccessFlags(
                                                                  );
                                                              synchronizedMethod =
                                                                (flags &
                                                                   ACC_SYNCHRONIZED) !=
                                                                  0;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        stage =
          synchronizedMethod
            ? 1
            : 0;
        super.
          visit(
            obj);
        if (synchronizedMethod &&
              stage ==
              4) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "NN_NAKED_NOTIFY",
                  NORMAL_PRIORITY).
                  addClassAndMethod(
                    this).
                  addSourceLine(
                    this,
                    notifyPC));
        }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { switch (stage) { case 0:
                                                           if (seen ==
                                                                 MONITORENTER) {
                                                               stage =
                                                                 1;
                                                           }
                                                           break;
                                                       case 1:
                                                           stage =
                                                             2;
                                                           break;
                                                       case 2:
                                                           if (seen ==
                                                                 INVOKEVIRTUAL &&
                                                                 ("notify".
                                                                    equals(
                                                                      getNameConstantOperand(
                                                                        )) ||
                                                                    "notifyAll".
                                                                    equals(
                                                                      getNameConstantOperand(
                                                                        ))) &&
                                                                 "()V".
                                                                 equals(
                                                                   getSigConstantOperand(
                                                                     ))) {
                                                               stage =
                                                                 3;
                                                               notifyPC =
                                                                 getPC(
                                                                   );
                                                           }
                                                           else {
                                                               stage =
                                                                 0;
                                                           }
                                                           break;
                                                       case 3:
                                                           stage =
                                                             4;
                                                           break;
                                                       case 4:
                                                           if (seen ==
                                                                 MONITOREXIT) {
                                                               bugReporter.
                                                                 reportBug(
                                                                   new edu.umd.cs.findbugs.BugInstance(
                                                                     this,
                                                                     "NN_NAKED_NOTIFY",
                                                                     NORMAL_PRIORITY).
                                                                     addClassAndMethod(
                                                                       this).
                                                                     addSourceLine(
                                                                       this,
                                                                       notifyPC));
                                                               stage =
                                                                 5;
                                                           }
                                                           else {
                                                               stage =
                                                                 0;
                                                           }
                                                           break;
                                                       case 5:
                                                           break;
                                                       default:
                                                           assert false;
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GiKed5RufN8Rrzhc/h9Xh2h77hwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/0p2zP6/3NdOY3QnAAA=");
}
