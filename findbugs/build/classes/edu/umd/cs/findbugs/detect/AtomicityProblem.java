package edu.umd.cs.findbugs.detect;
public class AtomicityProblem extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    int priority = IGNORE_PRIORITY;
    int lastQuestionableCheckTarget = -1;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    static final boolean DEBUG = false;
    public AtomicityProblem(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        if (hasInterestingClass(
              classContext.
                getJavaClass(
                  ).
                getConstantPool(
                  ),
              java.util.Collections.
                singleton(
                  "java/util/concurrent/ConcurrentHashMap"))) {
            super.
              visitClassContext(
                classContext);
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { if (DEBUG) {
                                                                java.lang.System.
                                                                  out.
                                                                  println(
                                                                    "Checking " +
                                                                    obj);
                                                            }
                                                            lastQuestionableCheckTarget =
                                                              -1;
                                                            super.
                                                              visit(
                                                                obj);
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (DEBUG) {
                                          java.lang.System.
                                            out.
                                            println(
                                              getPC(
                                                ) +
                                              " " +
                                              OPCODE_NAMES[seen]);
                                      }
                                      switch (seen) {
                                          case IFNE:
                                          case IFEQ:
                                              {
                                                  edu.umd.cs.findbugs.OpcodeStack.Item top =
                                                    stack.
                                                    getStackItem(
                                                      0);
                                                  if (DEBUG) {
                                                      java.lang.System.
                                                        out.
                                                        println(
                                                          "Stack top: " +
                                                          top);
                                                  }
                                                  edu.umd.cs.findbugs.ba.XMethod m =
                                                    top.
                                                    getReturnValueOf(
                                                      );
                                                  if (m !=
                                                        null &&
                                                        "java.util.concurrent.ConcurrentHashMap".
                                                        equals(
                                                          m.
                                                            getClassName(
                                                              )) &&
                                                        "containsKey".
                                                        equals(
                                                          m.
                                                            getName(
                                                              ))) {
                                                      lastQuestionableCheckTarget =
                                                        getBranchTarget(
                                                          );
                                                      if (seen ==
                                                            IFEQ) {
                                                          priority =
                                                            LOW_PRIORITY;
                                                      }
                                                      else
                                                          if (seen ==
                                                                IFNE) {
                                                              priority =
                                                                NORMAL_PRIORITY;
                                                          }
                                                  }
                                                  break;
                                              }
                                          case IFNULL:
                                          case IFNONNULL:
                                              {
                                                  edu.umd.cs.findbugs.OpcodeStack.Item top =
                                                    stack.
                                                    getStackItem(
                                                      0);
                                                  if (DEBUG) {
                                                      java.lang.System.
                                                        out.
                                                        println(
                                                          "Stack top: " +
                                                          top);
                                                  }
                                                  edu.umd.cs.findbugs.ba.XMethod m =
                                                    top.
                                                    getReturnValueOf(
                                                      );
                                                  if (DEBUG) {
                                                      java.lang.System.
                                                        out.
                                                        println(
                                                          "Found null check");
                                                  }
                                                  if (m !=
                                                        null &&
                                                        "java.util.concurrent.ConcurrentHashMap".
                                                        equals(
                                                          m.
                                                            getClassName(
                                                              )) &&
                                                        "get".
                                                        equals(
                                                          m.
                                                            getName(
                                                              ))) {
                                                      lastQuestionableCheckTarget =
                                                        getBranchTarget(
                                                          );
                                                      if (seen ==
                                                            IFNULL) {
                                                          priority =
                                                            LOW_PRIORITY;
                                                      }
                                                      else
                                                          if (seen ==
                                                                IFNONNULL) {
                                                              priority =
                                                                NORMAL_PRIORITY;
                                                          }
                                                  }
                                                  break;
                                              }
                                          case INVOKEVIRTUAL:
                                          case INVOKEINTERFACE:
                                              {
                                                  if ("java.util.concurrent.ConcurrentHashMap".
                                                        equals(
                                                          getDottedClassConstantOperand(
                                                            ))) {
                                                      java.lang.String methodName =
                                                        getNameConstantOperand(
                                                          );
                                                      edu.umd.cs.findbugs.ba.XClass xClass =
                                                        getXClassOperand(
                                                          );
                                                      if (xClass !=
                                                            null &&
                                                            "put".
                                                            equals(
                                                              methodName)) {
                                                          if (getPC(
                                                                ) <
                                                                lastQuestionableCheckTarget &&
                                                                lastQuestionableCheckTarget !=
                                                                -1) {
                                                              bugReporter.
                                                                reportBug(
                                                                  new edu.umd.cs.findbugs.BugInstance(
                                                                    this,
                                                                    "AT_OPERATION_SEQUENCE_ON_CONCURRENT_ABSTRACTION",
                                                                    priority).
                                                                    addClassAndMethod(
                                                                      this).
                                                                    addType(
                                                                      xClass.
                                                                        getClassDescriptor(
                                                                          )).
                                                                    addCalledMethod(
                                                                      this).
                                                                    addSourceLine(
                                                                      this));
                                                          }
                                                      }
                                                  }
                                                  break;
                                              }
                                          default:
                                              break;
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0yvVDx0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8gP3/wXVBV0auScAAA==");
}
