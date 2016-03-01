package edu.umd.cs.findbugs.detect;
public class FindUselessControlFlow extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private static final java.util.BitSet ifInstructionSet = new java.util.BitSet(
      );
    static { ifInstructionSet.set(org.apache.bcel.Constants.IF_ACMPEQ);
             ifInstructionSet.set(org.apache.bcel.Constants.IF_ACMPNE);
             ifInstructionSet.set(org.apache.bcel.Constants.IF_ICMPEQ);
             ifInstructionSet.set(org.apache.bcel.Constants.IF_ICMPNE);
             ifInstructionSet.set(org.apache.bcel.Constants.IF_ICMPLT);
             ifInstructionSet.set(org.apache.bcel.Constants.IF_ICMPLE);
             ifInstructionSet.set(org.apache.bcel.Constants.IF_ICMPGT);
             ifInstructionSet.set(org.apache.bcel.Constants.IF_ICMPGE);
             ifInstructionSet.set(org.apache.bcel.Constants.IFEQ);
             ifInstructionSet.set(org.apache.bcel.Constants.IFNE);
             ifInstructionSet.set(org.apache.bcel.Constants.IFLT);
             ifInstructionSet.set(org.apache.bcel.Constants.IFLE);
             ifInstructionSet.set(org.apache.bcel.Constants.IFGT);
             ifInstructionSet.set(org.apache.bcel.Constants.IFGE);
             ifInstructionSet.set(org.apache.bcel.Constants.IFNULL);
             ifInstructionSet.set(org.apache.bcel.Constants.IFNONNULL);
    }
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    public FindUselessControlFlow(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { super.
                                                              visit(
                                                                obj);
                                                            bugAccumulator.
                                                              reportAccumulatedBugs(
                                                                );
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (ifInstructionSet.
                                            get(
                                              seen)) { if (getBranchTarget(
                                                             ) ==
                                                             getBranchFallThrough(
                                                               )) {
                                                           int priority =
                                                             NORMAL_PRIORITY;
                                                           org.apache.bcel.classfile.LineNumberTable lineNumbers =
                                                             getCode(
                                                               ).
                                                             getLineNumberTable(
                                                               );
                                                           if (lineNumbers !=
                                                                 null) {
                                                               int branchLineNumber =
                                                                 lineNumbers.
                                                                 getSourceLine(
                                                                   getPC(
                                                                     ));
                                                               int targetLineNumber =
                                                                 lineNumbers.
                                                                 getSourceLine(
                                                                   getBranchFallThrough(
                                                                     ));
                                                               int nextLine =
                                                                 getNextSourceLine(
                                                                   lineNumbers,
                                                                   branchLineNumber);
                                                               if (branchLineNumber +
                                                                     1 ==
                                                                     targetLineNumber ||
                                                                     branchLineNumber ==
                                                                     targetLineNumber &&
                                                                     nextLine ==
                                                                     branchLineNumber +
                                                                     1) {
                                                                   priority =
                                                                     HIGH_PRIORITY;
                                                               }
                                                               else
                                                                   if (branchLineNumber +
                                                                         2 <
                                                                         java.lang.Math.
                                                                         max(
                                                                           targetLineNumber,
                                                                           nextLine)) {
                                                                       priority =
                                                                         LOW_PRIORITY;
                                                                   }
                                                           }
                                                           else {
                                                               priority =
                                                                 LOW_PRIORITY;
                                                           }
                                                           bugAccumulator.
                                                             accumulateBug(
                                                               new edu.umd.cs.findbugs.BugInstance(
                                                                 this,
                                                                 priority ==
                                                                   HIGH_PRIORITY
                                                                   ? "UCF_USELESS_CONTROL_FLOW_NEXT_LINE"
                                                                   : "UCF_USELESS_CONTROL_FLOW",
                                                                 priority).
                                                                 addClassAndMethod(
                                                                   this),
                                                               this);
                                                       }
                                      } }
    public static int getNextSourceLine(org.apache.bcel.classfile.LineNumberTable lineNumbers,
                                        int sourceLine) {
        int result =
          java.lang.Integer.
            MAX_VALUE;
        for (org.apache.bcel.classfile.LineNumber ln
              :
              lineNumbers.
               getLineNumberTable(
                 )) {
            int thisLine =
              ln.
              getLineNumber(
                );
            if (sourceLine <
                  thisLine &&
                  thisLine <
                  result) {
                result =
                  thisLine;
            }
        }
        return result;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ZoDZLr4bAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
