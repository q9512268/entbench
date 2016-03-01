package edu.umd.cs.findbugs.detect;
public class DoInsideDoPrivileged extends edu.umd.cs.findbugs.BytecodeScanningDetector {
    edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    public DoInsideDoPrivileged(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    boolean isDoPrivileged = false;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) { isDoPrivileged =
                                                                   edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                                                     instanceOf(
                                                                       getDottedClassName(
                                                                         ),
                                                                       "java.security.PrivilegedAction") ||
                                                                     edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                                                     instanceOf(
                                                                       getDottedClassName(
                                                                         ),
                                                                       "java.security.PrivilegedExceptionAction");
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        if (isDoPrivileged &&
              "run".
              equals(
                getMethodName(
                  ))) {
            return;
        }
        if (getMethod(
              ).
              isPrivate(
                )) {
            return;
        }
        if (edu.umd.cs.findbugs.detect.DumbMethods.
              isTestMethod(
                getMethod(
                  ))) {
            return;
        }
        super.
          visit(
            obj);
        bugAccumulator.
          reportAccumulatedBugs(
            );
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen ==
                                            INVOKEVIRTUAL &&
                                            "setAccessible".
                                            equals(
                                              getNameConstantOperand(
                                                ))) {
                                          java.lang.String className =
                                            getDottedClassConstantOperand(
                                              );
                                          if ("java.lang.reflect.Field".
                                                equals(
                                                  className) ||
                                                "java.lang.reflect.Method".
                                                equals(
                                                  className)) {
                                              bugAccumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "DP_DO_INSIDE_DO_PRIVILEGED",
                                                    LOW_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addCalledMethod(
                                                      this),
                                                  this);
                                          }
                                      }
                                      if (seen ==
                                            NEW) {
                                          java.lang.String classOfConstructedClass =
                                            getDottedClassConstantOperand(
                                              );
                                          if (edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                                instanceOf(
                                                  classOfConstructedClass,
                                                  "java.lang.ClassLoader") &&
                                                !("main".
                                                    equals(
                                                      getMethodName(
                                                        )) &&
                                                    "([Ljava/lang/String;)V".
                                                    equals(
                                                      getMethodSig(
                                                        )) &&
                                                    getMethod(
                                                      ).
                                                    isStatic(
                                                      ))) {
                                              bugAccumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED",
                                                    NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addClass(
                                                      classOfConstructedClass),
                                                  this);
                                          }
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "a47Gv1VW47h83/9Nt5iyorY6op+EbssRm0G3oy5f9PllhWS/kLpw8K+U48yd" +
       "nkHdZ3H4HuRQQ5gY1EQ7fblU/v1PQeUQdHNLPZ1gL7+w6M3WemcUnzjZVLvg" +
       "5O43efouvAU2QCJOmbLs7jZd82pNpymJS95g9Z5WgbvASFv5dx24qloTLsCT" +
       "FspTjMwpgcLgfHvqhn6akXoHmpGg6Nm+CAXf3gZzwujefBaWYBOnP9Xycbam" +
       "ZJc6CVxiyyZCDZGU9DbOtarnAt4iW7DuvBt1rq663OmpZ/zFPV97TOvNPS6e" +
       "O7lj4K5rnzttvTNA6E9NIZVZ0HtYTx6F+rW8LLU8rertq643nq9bka/0LRbD" +
       "TrgtcvkxBFJAQ39p813CjVDhLv72qU0Xf3Gk+lXotvaQgAD221N8uclpJjQO" +
       "e2LFPRbUev460L3qu5Ob16T++ht+fSRWT7a4PDxc3h54q+/82Ie38SfeKjAW" +
       "zfFb17ZJZScVx3VPw9aIrizg2zvXg62+2YVVfJWCS0pxv1r8lgdX6wmqb1VN" +
       "JckrOPQWzorn6T9f8k1N8yE4K66ePmPlH9Q++GY81q9pdjtf0aTxoJZK5yMc" +
       "X+dTHN74L32BkXd8GwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
