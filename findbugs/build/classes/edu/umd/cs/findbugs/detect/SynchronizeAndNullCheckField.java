package edu.umd.cs.findbugs.detect;
public class SynchronizeAndNullCheckField extends edu.umd.cs.findbugs.BytecodeScanningDetector {
    edu.umd.cs.findbugs.BugReporter bugReporter;
    public SynchronizeAndNullCheckField(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) { gottenField =
                                                                null;
                                                              currState =
                                                                0;
                                                              syncField =
                                                                null;
    }
    edu.umd.cs.findbugs.FieldAnnotation gottenField;
    edu.umd.cs.findbugs.FieldAnnotation syncField;
    int currState;
    @java.lang.Override
    public void sawOpcode(int seen) { switch (currState) { case 0:
                                                               if (seen ==
                                                                     GETFIELD ||
                                                                     seen ==
                                                                     GETSTATIC) {
                                                                   syncField =
                                                                     edu.umd.cs.findbugs.FieldAnnotation.
                                                                       fromReferencedField(
                                                                         this);
                                                                   currState =
                                                                     1;
                                                               }
                                                               break;
                                                           case 1:
                                                               if (seen ==
                                                                     DUP) {
                                                                   currState =
                                                                     2;
                                                               }
                                                               else {
                                                                   currState =
                                                                     0;
                                                               }
                                                               break;
                                                           case 2:
                                                               if (seen ==
                                                                     ASTORE ||
                                                                     seen ==
                                                                     ASTORE_0 ||
                                                                     seen ==
                                                                     ASTORE_1 ||
                                                                     seen ==
                                                                     ASTORE_2 ||
                                                                     seen ==
                                                                     ASTORE_3) {
                                                                   currState =
                                                                     3;
                                                               }
                                                               else {
                                                                   currState =
                                                                     0;
                                                               }
                                                               break;
                                                           case 3:
                                                               if (seen ==
                                                                     MONITORENTER) {
                                                                   currState =
                                                                     4;
                                                               }
                                                               else {
                                                                   currState =
                                                                     0;
                                                               }
                                                               break;
                                                           case 4:
                                                               if (seen ==
                                                                     GETFIELD ||
                                                                     seen ==
                                                                     GETSTATIC) {
                                                                   gottenField =
                                                                     edu.umd.cs.findbugs.FieldAnnotation.
                                                                       fromReferencedField(
                                                                         this);
                                                                   currState =
                                                                     5;
                                                               }
                                                               else {
                                                                   currState =
                                                                     0;
                                                               }
                                                               break;
                                                           case 5:
                                                               if ((seen ==
                                                                      IFNONNULL ||
                                                                      seen ==
                                                                      IFNULL) &&
                                                                     gottenField.
                                                                     equals(
                                                                       syncField)) {
                                                                   edu.umd.cs.findbugs.BugInstance bug =
                                                                     new edu.umd.cs.findbugs.BugInstance(
                                                                     this,
                                                                     "NP_SYNC_AND_NULL_CHECK_FIELD",
                                                                     NORMAL_PRIORITY).
                                                                     addClass(
                                                                       this).
                                                                     addMethod(
                                                                       this).
                                                                     addField(
                                                                       syncField).
                                                                     addSourceLine(
                                                                       this);
                                                                   bugReporter.
                                                                     reportBug(
                                                                       bug);
                                                               }
                                                               else {
                                                                   currState =
                                                                     0;
                                                               }
                                                               break;
                                                           default:
                                                               currState =
                                                                 0;
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "9rHspzpP7slCsDTJmV/hn/h69b8nCRXgUxsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "40f55Wf6e/d95g2/+fw38mPb/wZqG3FI5SUAAA==");
}
