package edu.umd.cs.findbugs.detect;
public class CheckCalls implements edu.umd.cs.findbugs.Detector, edu.umd.cs.findbugs.NonReportingDetector {
    private static final java.lang.String METHOD = edu.umd.cs.findbugs.SystemProperties.
      getProperty(
        "checkcalls.method");
    private static final java.lang.String TARGET_METHOD = edu.umd.cs.findbugs.SystemProperties.
      getProperty(
        "checkcalls.targetmethod");
    edu.umd.cs.findbugs.BugReporter bugReporter;
    public CheckCalls(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        org.apache.bcel.classfile.Method[] methodList =
          classContext.
          getJavaClass(
            ).
          getMethods(
            );
        for (org.apache.bcel.classfile.Method method
              :
              methodList) {
            if (method.
                  getCode(
                    ) ==
                  null) {
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
            try {
                java.lang.System.
                  out.
                  println(
                    "Analyzing " +
                    edu.umd.cs.findbugs.ba.SignatureConverter.
                      convertMethodSignature(
                        classContext.
                          getJavaClass(
                            ),
                        method));
                analyzeMethod(
                  classContext,
                  method);
            }
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                bugReporter.
                  logError(
                    "Error",
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                bugReporter.
                  logError(
                    "Error",
                    e);
            }
            catch (java.lang.ClassNotFoundException e) {
                bugReporter.
                  reportMissingClass(
                    e);
            }
        }
    }
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException,
        java.lang.ClassNotFoundException,
        edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        edu.umd.cs.findbugs.ba.CFG cfg =
          classContext.
          getCFG(
            method);
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               cfg.
               locationIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location location =
              i.
              next(
                );
            org.apache.bcel.generic.Instruction ins =
              location.
              getHandle(
                ).
              getInstruction(
                );
            if (ins instanceof org.apache.bcel.generic.InvokeInstruction) {
                if (TARGET_METHOD !=
                      null &&
                      !((org.apache.bcel.generic.InvokeInstruction)
                          ins).
                      getMethodName(
                        classContext.
                          getConstantPoolGen(
                            )).
                      equals(
                        TARGET_METHOD)) {
                    continue;
                }
                java.lang.System.
                  out.
                  println(
                    "\n*******************************************************\n");
                java.lang.System.
                  out.
                  println(
                    "Method invocation: " +
                    location.
                      getHandle(
                        ));
                java.lang.System.
                  out.
                  println(
                    "\tInvoking: " +
                    edu.umd.cs.findbugs.ba.SignatureConverter.
                      convertMethodSignature(
                        (org.apache.bcel.generic.InvokeInstruction)
                          ins,
                        classContext.
                          getConstantPoolGen(
                            )));
                edu.umd.cs.findbugs.ba.JavaClassAndMethod proto =
                  edu.umd.cs.findbugs.ba.Hierarchy.
                  findInvocationLeastUpperBound(
                    (org.apache.bcel.generic.InvokeInstruction)
                      ins,
                    classContext.
                      getConstantPoolGen(
                        ));
                if (proto ==
                      null) {
                    java.lang.System.
                      out.
                      println(
                        "\tUnknown prototype method");
                }
                else {
                    java.lang.System.
                      out.
                      println(
                        "\tPrototype method: class=" +
                        proto.
                          getJavaClass(
                            ).
                          getClassName(
                            ) +
                        ", method=" +
                        proto.
                          getMethod(
                            ));
                }
                java.util.Set<edu.umd.cs.findbugs.ba.JavaClassAndMethod> calledMethodSet =
                  edu.umd.cs.findbugs.ba.Hierarchy.
                  resolveMethodCallTargets(
                    (org.apache.bcel.generic.InvokeInstruction)
                      ins,
                    classContext.
                      getTypeDataflow(
                        method).
                      getFactAtLocation(
                        location),
                    classContext.
                      getConstantPoolGen(
                        ));
                java.lang.System.
                  out.
                  println(
                    "\tTarget method set: " +
                    calledMethodSet);
            }
        }
    }
    @java.lang.Override
    public void report() {  }
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
       "iY89/62siPE/MQrWICgnAAA=");
}
