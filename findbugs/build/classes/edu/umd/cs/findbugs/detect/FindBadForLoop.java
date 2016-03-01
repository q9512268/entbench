package edu.umd.cs.findbugs.detect;
public class FindBadForLoop extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector implements edu.umd.cs.findbugs.StatelessDetector {
    edu.umd.cs.findbugs.BugReporter bugReporter;
    public FindBadForLoop(edu.umd.cs.findbugs.BugReporter bugReporter) { super(
                                                                           );
                                                                         this.
                                                                           bugReporter =
                                                                           bugReporter;
    }
    org.apache.bcel.classfile.LineNumberTable lineNumbers;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        lastRegStore =
          -1;
        lineNumbers =
          obj.
            getLineNumberTable(
              );
        super.
          visit(
            obj);
    }
    int lastRegStore;
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen == ISTORE ||
                                            seen ==
                                            ISTORE_0 ||
                                            seen ==
                                            ISTORE_1 ||
                                            seen ==
                                            ISTORE_2 ||
                                            seen ==
                                            ISTORE_3) { lastRegStore =
                                                          getRegisterOperand(
                                                            );
                                      }
                                      if (lineNumbers != null &&
                                            stack.
                                            getStackDepth(
                                              ) >=
                                            2 &&
                                            (seen ==
                                               IF_ICMPGE ||
                                               seen ==
                                               IF_ICMPGT ||
                                               seen ==
                                               IF_ICMPLT ||
                                               seen ==
                                               IF_ICMPLE ||
                                               seen ==
                                               IF_ICMPNE ||
                                               seen ==
                                               IF_ICMPEQ)) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item item0 =
                                            stack.
                                            getStackItem(
                                              0);
                                          edu.umd.cs.findbugs.OpcodeStack.Item item1 =
                                            stack.
                                            getStackItem(
                                              1);
                                          int r0 =
                                            item0.
                                            getRegisterNumber(
                                              );
                                          int r1 =
                                            item1.
                                            getRegisterNumber(
                                              );
                                          int rMin =
                                            java.lang.Math.
                                            min(
                                              r0,
                                              r1);
                                          int rMax =
                                            java.lang.Math.
                                            max(
                                              r0,
                                              r1);
                                          int branchTarget =
                                            getBranchTarget(
                                              );
                                          if (rMin ==
                                                -1 &&
                                                rMax >
                                                0 &&
                                                rMax ==
                                                lastRegStore &&
                                                branchTarget -
                                                6 >
                                                getPC(
                                                  )) {
                                              int beforeTarget =
                                                getCodeByte(
                                                  branchTarget -
                                                    3);
                                              int beforeGoto =
                                                getCodeByte(
                                                  branchTarget -
                                                    6);
                                              if (beforeTarget ==
                                                    GOTO &&
                                                    beforeGoto ==
                                                    IINC) {
                                                  int offset1 =
                                                    (byte)
                                                      getCodeByte(
                                                        branchTarget -
                                                          2);
                                                  int offset2 =
                                                    getCodeByte(
                                                      branchTarget -
                                                        1);
                                                  int offset =
                                                    offset1 <<
                                                    8 |
                                                    offset2;
                                                  int backTarget =
                                                    branchTarget -
                                                    3 +
                                                    offset;
                                                  int reg =
                                                    getCodeByte(
                                                      branchTarget -
                                                        5);
                                                  int testLineNumber =
                                                    lineNumbers.
                                                    getSourceLine(
                                                      getPC(
                                                        ));
                                                  int incLineNumber =
                                                    lineNumbers.
                                                    getSourceLine(
                                                      branchTarget -
                                                        6);
                                                  int beforeIncLineNumber =
                                                    lineNumbers.
                                                    getSourceLine(
                                                      branchTarget -
                                                        7);
                                                  if (backTarget <
                                                        getPC(
                                                          ) &&
                                                        getPC(
                                                          ) -
                                                        8 <
                                                        backTarget &&
                                                        reg !=
                                                        rMax &&
                                                        incLineNumber <
                                                        testLineNumber +
                                                        3 &&
                                                        beforeIncLineNumber >
                                                        incLineNumber) {
                                                      bugReporter.
                                                        reportBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "QF_QUESTIONABLE_FOR_LOOP",
                                                            NORMAL_PRIORITY).
                                                            addClassAndMethod(
                                                              this).
                                                            addSourceLine(
                                                              this));
                                                  }
                                              }
                                          }
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zurnT+BO7uX7wHNpLyUvncSdU1BewXOWS3l5OStetzdDW1E/Bp9T4Pmv7Mna" +
       "s4btAn07sbdLeOhgm+CB5epm+TD+MxGFLcBlZTkrGlvJ1euGyRuOG/EQeF63" +
       "Z8TrrmNE53pGZHUS6JRtTdgo3z/v5+5jrm/sSmDnONd2ZUWzdvPNfbZnyVJk" +
       "j3qUwcoJA7qv0IA7wVPYM6BwHQP4lzHgFqBbONQMHmSb9tLp0vdNG6wF673N" +
       "J/LU7d9efvS7n95uLE/mxgli7X1P/+KPdz/w9M6R7fwjV+2oj/Jst/S5mq/K" +
       "dc3Q5tJLjZJzUH///FNf/O2n3rvV6vbjm1MSvHt9+s//8+u7H/nOV6+xHzoN" +
       "XjxOTMnoZadkq9spsHqdKe1Wd/OglK/t9NNZ9SfBMhfkL2CAA0C7ZO1Pxd0L" +
       "S7m8H/oiCCiAPZcXVnU/ri7msJll+e72LeaEruT/WFfgyVsPhTEueCF6/999" +
       "8Ou/8si3gVc60Jl1hivAfUdG3Ebtzz/3zP03P/2d9+erNliu+Mfkf35zJtV+" +
       "KYuzQs8KY9/UezNTeTfyFY0B8dfLF1pNPbB2csSet4ZguXb/F9aGt/bpctDG" +
       "9z9McaqPYyFJxjqH1s0WCjfgUcMImqTRQts0LnaGZOzC1VZjg3jNsM0KS5sp" +
       "1bnJOkEjzFbrU5hDBXlJeO3VptElWHxVoOG22xng/pSRVssiSclCoyOVBLZV" +
       "4kWTEscVu9Ade4OiNFjJah+drdWoD1c5irBXnoiuUznBaimGVGtFJSLH3Wan" +
       "UBDaY6rUHbYWIkHHa5dEpWZiEvEUFL3mNHAIl0eqsjMLNlbbdNU2Js0NtR0R" +
       "g1FgdQONbcsdUjBiu0u0i5ppsuWyCztDT6ATbeoRXtMjy5vI60pMe8lXivKC" +
       "wq0SMVkJRdzsVUSmN2NGzCxotpfmvE1GEj9ndMyrR6ZHdoRQsGm93WL6XFca" +
       "KKtlgOkNnhYLTopHc7Jgb7SWO2OIkkViY6ni1ji+6zPkcMQwwz5qm/K0pRam" +
       "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");
}
