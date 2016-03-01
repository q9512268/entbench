package edu.umd.cs.findbugs;
public abstract class ByteCodePatternDetector implements edu.umd.cs.findbugs.Detector {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "bcpd.debug");
    private static final java.lang.String METHOD = edu.umd.cs.findbugs.SystemProperties.
      getProperty(
        "bcpd.method");
    protected abstract edu.umd.cs.findbugs.BugReporter getBugReporter();
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        try {
            edu.umd.cs.findbugs.ba.bcp.ByteCodePattern pattern =
              getPattern(
                );
            org.apache.bcel.classfile.JavaClass jclass =
              classContext.
              getJavaClass(
                );
            org.apache.bcel.classfile.Method[] methodList =
              jclass.
              getMethods(
                );
            for (org.apache.bcel.classfile.Method method
                  :
                  methodList) {
                if (method.
                      isAbstract(
                        ) ||
                      method.
                      isNative(
                        )) {
                    continue;
                }
                if (METHOD !=
                      null &&
                      !method.
                      getName(
                        ).
                      equals(
                        METHOD)) {
                    continue;
                }
                if (DEBUG) {
                    java.lang.System.
                      out.
                      print(
                        ("============================================================" +
                         "=========\n") +
                        "Method " +
                        jclass.
                          getClassName(
                            ) +
                        "." +
                        method.
                          getName(
                            ) +
                        "\n" +
                        ("============================================================" +
                         "=========\n"));
                }
                if (!prescreen(
                       method,
                       classContext)) {
                    continue;
                }
                org.apache.bcel.generic.MethodGen methodGen =
                  classContext.
                  getMethodGen(
                    method);
                if (methodGen ==
                      null) {
                    continue;
                }
                edu.umd.cs.findbugs.ba.bcp.PatternMatcher matcher =
                  new edu.umd.cs.findbugs.ba.bcp.PatternMatcher(
                  pattern,
                  classContext,
                  method);
                matcher.
                  execute(
                    );
                java.util.Iterator<edu.umd.cs.findbugs.ba.bcp.ByteCodePatternMatch> j =
                  matcher.
                  byteCodePatternMatchIterator(
                    );
                while (j.
                         hasNext(
                           )) {
                    edu.umd.cs.findbugs.ba.bcp.ByteCodePatternMatch match =
                      j.
                      next(
                        );
                    if (DEBUG) {
                        java.lang.System.
                          out.
                          println(
                            "Pattern match:");
                        java.util.Iterator<edu.umd.cs.findbugs.ba.bcp.PatternElementMatch> pemIter =
                          match.
                          patternElementMatchIterator(
                            );
                        while (pemIter.
                                 hasNext(
                                   )) {
                            edu.umd.cs.findbugs.ba.bcp.PatternElementMatch pem =
                              pemIter.
                              next(
                                );
                            java.lang.System.
                              out.
                              println(
                                "\t" +
                                pem.
                                  toString(
                                    ));
                        }
                    }
                    reportMatch(
                      classContext,
                      method,
                      match);
                }
            }
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            getBugReporter(
              ).
              logError(
                getDetectorName(
                  ) +
                " caught exception",
                e);
        }
        catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
            getBugReporter(
              ).
              logError(
                getDetectorName(
                  ) +
                " caught exception",
                e);
        }
    }
    private java.lang.String getDetectorName() {
        java.lang.String className =
          this.
          getClass(
            ).
          getName(
            );
        int lastDot =
          className.
          lastIndexOf(
            '.');
        if (lastDot >=
              0) {
            className =
              className.
                substring(
                  lastDot +
                    1);
        }
        return className;
    }
    @java.lang.Override
    public void report() {  }
    public abstract edu.umd.cs.findbugs.ba.bcp.ByteCodePattern getPattern();
    public abstract boolean prescreen(org.apache.bcel.classfile.Method method,
                                      edu.umd.cs.findbugs.ba.ClassContext classContext);
    public abstract void reportMatch(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                     org.apache.bcel.classfile.Method method,
                                     edu.umd.cs.findbugs.ba.bcp.ByteCodePatternMatch match)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException;
    public ByteCodePatternDetector() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "H8TZeU8hKwAA");
}
