package edu.umd.cs.findbugs.classfile;
public class CheckedAnalysisException extends java.lang.Exception {
    public CheckedAnalysisException() { super(); }
    public CheckedAnalysisException(edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
        super(
          e.
            getMessage(
              ),
          e.
            getCause(
              ));
    }
    public CheckedAnalysisException(java.lang.String msg) { super(
                                                              msg);
    }
    public CheckedAnalysisException(java.lang.String msg, java.lang.Throwable cause) {
        super(
          msg,
          cause);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2UBpw5/fFuKfE684XP8PA559zZUUAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
