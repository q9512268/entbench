package edu.umd.cs.findbugs.detect;
public class FindSpinLoop extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "findspinloop.debug");
    int stage = 0;
    int start;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private edu.umd.cs.findbugs.FieldAnnotation lastFieldSeen;
    public FindSpinLoop(edu.umd.cs.findbugs.BugReporter bugReporter) { super(
                                                                         );
                                                                       this.
                                                                         bugReporter =
                                                                         bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Saw " +
                getFullyQualifiedMethodName(
                  ));
        }
        stage =
          0;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { switch (seen) { case ALOAD_0:
                                                      case ALOAD_1:
                                                      case ALOAD_2:
                                                      case ALOAD_3:
                                                      case ALOAD:
                                                          if (DEBUG) {
                                                              java.lang.System.
                                                                out.
                                                                println(
                                                                  "   ALOAD at PC " +
                                                                  getPC(
                                                                    ));
                                                          }
                                                          start =
                                                            getPC(
                                                              );
                                                          stage =
                                                            1;
                                                          break;
                                                      case GETSTATIC:
                                                          if (DEBUG) {
                                                              java.lang.System.
                                                                out.
                                                                println(
                                                                  "   getfield in stage " +
                                                                  stage);
                                                          }
                                                          lastFieldSeen =
                                                            edu.umd.cs.findbugs.FieldAnnotation.
                                                              fromReferencedField(
                                                                this);
                                                          start =
                                                            getPC(
                                                              );
                                                          stage =
                                                            2;
                                                          break;
                                                      case GETFIELD:
                                                          if (DEBUG) {
                                                              java.lang.System.
                                                                out.
                                                                println(
                                                                  "   getfield in stage " +
                                                                  stage);
                                                          }
                                                          lastFieldSeen =
                                                            edu.umd.cs.findbugs.FieldAnnotation.
                                                              fromReferencedField(
                                                                this);
                                                          if (stage ==
                                                                1 ||
                                                                stage ==
                                                                2) {
                                                              stage =
                                                                2;
                                                          }
                                                          else {
                                                              stage =
                                                                0;
                                                          }
                                                          break;
                                                      case GOTO:
                                                      case IFNE:
                                                      case IFEQ:
                                                      case IFNULL:
                                                      case IFNONNULL:
                                                          if (DEBUG) {
                                                              java.lang.System.
                                                                out.
                                                                println(
                                                                  "   conditional branch in stage " +
                                                                  stage +
                                                                  " to " +
                                                                  getBranchTarget(
                                                                    ));
                                                          }
                                                          if (stage ==
                                                                2 &&
                                                                getBranchTarget(
                                                                  ) ==
                                                                start) {
                                                              bugReporter.
                                                                reportBug(
                                                                  new edu.umd.cs.findbugs.BugInstance(
                                                                    this,
                                                                    "SP_SPIN_ON_FIELD",
                                                                    NORMAL_PRIORITY).
                                                                    addClassAndMethod(
                                                                      this).
                                                                    addReferencedField(
                                                                      lastFieldSeen).
                                                                    addSourceLine(
                                                                      this,
                                                                      start));
                                                              stage =
                                                                0;
                                                          }
                                                          else
                                                              if (getBranchTarget(
                                                                    ) <
                                                                    getPC(
                                                                      )) {
                                                                  stage =
                                                                    0;
                                                              }
                                                          break;
                                                      default:
                                                          stage =
                                                            0;
                                                          break;
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7YNZyS6dBbNUvF3+PXulw3v/A5NwBIxrHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALVaeezkVn33/jZ7ZHPsZgNJSCHnJiQZ+vPcnlEoxR7PjGfG" +
       "Y4894/GMadn4nLHH1/gYHzQtILWgIlHUBkpVSP8oiILCIVpEq4oqqAdQKBIV" +
       "6iUVUFWptBSJqCqtSlv67PnduxsStR3Jb57f+773vufnXX7uu9AZ34MKrmMm" +
       "C9MJdtU42DXM2m6QuKq/2ydrI9HzVaVlir4/AWVX5Yc+dfH7P3jP8tIOdFaA" +
       "7hRt2wnEQHdsn1V9x9yoCgldPCxtm6rlB9Al0hA3IhwGugmTuh88SUK3HGka" +
       "QFfIfRZgwAIMWIBzFmD0kAo0uk21Q6uVtRDtwF9DPwudIqGzrpyxF0APHu/E" +
       "FT3R2utmlEsAejifvU+BUHnj2IMeOJB9K/M1Ar+3AD/zq2++9OnT0EUBuqjb" +
       "44wdGTARgEEE6FZLtSTV81FFURUBusNWVWWserpo6mnOtwBd9vWFLQahpx4o" +
       "KSsMXdXLxzzU3K1yJpsXyoHjHYin6aqp7L+d0UxxAWS961DWrYSdrBwIeEEH" +
       "jHmaKKv7TW5a6bYSQPefbHEg45UBIABNz1lqsHQOhrrJFkEBdHlrO1O0F/A4" +
       "8HR7AUjPOCEYJYDuvWGnma5dUV6JC/VqAN1zkm60rQJUN+eKyJoE0CtPkuU9" +
       "ASvde8JKR+zzXer1736LTdg7Oc+KKpsZ/+dBo/tONGJVTfVUW1a3DW99gnyf" +
       "eNfn3rkDQYD4lSeItzSf/ZkX3vi6+57/4pbmx65DQ0uGKgdX5Q9Jt3/t1a3H" +
       "m6czNs67jq9nxj8mee7+o72aJ2MXRN5dBz1mlbv7lc+zfzJ/68fU7+xAF3rQ" +
       "WdkxQwv40R2yY7m6qXpd1VY9MVCVHnSzaiutvL4HnQN5UrfVbSmtab4a9KCb" +
       "zLzorJO/AxVpoItMRedAXrc1Zz/visEyz8cuBEHnwAPx4Lkf2v7y/wB6M7x0" +
       "LBUWZdHWbQceeU4mvw+rdiAB3S5hDTiTFC582PdkOHcdVQnh0FJg2T+sVNQA" +
       "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" +
       "CScAAA==");
}
