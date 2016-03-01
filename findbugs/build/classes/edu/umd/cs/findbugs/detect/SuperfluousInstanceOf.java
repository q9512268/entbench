package edu.umd.cs.findbugs.detect;
public class SuperfluousInstanceOf extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private static final int SEEN_NOTHING = 0;
    private static final int SEEN_ALOAD = 1;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private org.apache.bcel.classfile.LocalVariableTable varTable;
    private int state;
    private int register;
    public SuperfluousInstanceOf(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) { state = SEEN_NOTHING;
                                                              varTable = obj.
                                                                           getLocalVariableTable(
                                                                             );
                                                              if (varTable !=
                                                                    null) {
                                                                  super.
                                                                    visit(
                                                                      obj);
                                                              } }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { if (varTable !=
                                                                  null) {
                                                                super.
                                                                  visit(
                                                                    obj);
                                                            } }
    @java.lang.Override
    public void sawOpcode(int seen) { switch (state) { case SEEN_NOTHING:
                                                           if (seen ==
                                                                 ALOAD) {
                                                               register =
                                                                 getRegisterOperand(
                                                                   );
                                                           }
                                                           else
                                                               if (seen >=
                                                                     ALOAD_0 &&
                                                                     seen <=
                                                                     ALOAD_3) {
                                                                   register =
                                                                     seen -
                                                                       ALOAD_0;
                                                               }
                                                               else {
                                                                   return;
                                                               }
                                                           state =
                                                             SEEN_ALOAD;
                                                           break;
                                                       case SEEN_ALOAD:
                                                           try {
                                                               if (seen ==
                                                                     INSTANCEOF) {
                                                                   org.apache.bcel.classfile.LocalVariable lv =
                                                                     edu.umd.cs.findbugs.visitclass.LVTHelper.
                                                                     getLocalVariableAtPC(
                                                                       varTable,
                                                                       register,
                                                                       getPC(
                                                                         ));
                                                                   if (lv !=
                                                                         null) {
                                                                       java.lang.String objSignature =
                                                                         lv.
                                                                         getSignature(
                                                                           );
                                                                       if (objSignature.
                                                                             charAt(
                                                                               0) ==
                                                                             'L') {
                                                                           objSignature =
                                                                             objSignature.
                                                                               substring(
                                                                                 1,
                                                                                 objSignature.
                                                                                   length(
                                                                                     ) -
                                                                                   1).
                                                                               replace(
                                                                                 '/',
                                                                                 '.');
                                                                           java.lang.String clsSignature =
                                                                             getDottedClassConstantOperand(
                                                                               );
                                                                           if (clsSignature.
                                                                                 charAt(
                                                                                   0) !=
                                                                                 '[') {
                                                                               if (org.apache.bcel.Repository.
                                                                                     instanceOf(
                                                                                       objSignature,
                                                                                       clsSignature)) {
                                                                                   bugReporter.
                                                                                     reportBug(
                                                                                       new edu.umd.cs.findbugs.BugInstance(
                                                                                         this,
                                                                                         "SIO_SUPERFLUOUS_INSTANCEOF",
                                                                                         LOW_PRIORITY).
                                                                                         addClassAndMethod(
                                                                                           this).
                                                                                         addSourceLine(
                                                                                           this));
                                                                               }
                                                                           }
                                                                       }
                                                                   }
                                                               }
                                                           }
                                                           catch (java.lang.ClassNotFoundException cnfe) {
                                                               bugReporter.
                                                                 reportMissingClass(
                                                                   cnfe);
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
       "7tXpYvEozQ9/yKc4/PN/aPSTBM8eAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
