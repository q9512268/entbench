package edu.umd.cs.findbugs.detect;
public class InfiniteRecursiveLoop extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private boolean seenTransferOfControl;
    private boolean seenReturn;
    private boolean seenStateChange;
    private int largestBranchTarget;
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "irl.debug");
    public InfiniteRecursiveLoop(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) { seenTransferOfControl =
                                                                false;
                                                              seenStateChange =
                                                                false;
                                                              seenReturn =
                                                                false;
                                                              largestBranchTarget =
                                                                -1;
                                                              if (DEBUG) {
                                                                  java.lang.System.
                                                                    out.
                                                                    println(
                                                                      );
                                                                  java.lang.System.
                                                                    out.
                                                                    println(
                                                                      " --- " +
                                                                      getFullyQualifiedMethodName(
                                                                        ));
                                                                  java.lang.System.
                                                                    out.
                                                                    println(
                                                                      );
                                                              }
    }
    @java.lang.Override
    public void sawBranchTo(int target) {
        if (target ==
              getNextPC(
                )) {
            return;
        }
        if (largestBranchTarget <
              target) {
            largestBranchTarget =
              target;
        }
        seenTransferOfControl =
          true;
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seenReturn &&
                                            seenTransferOfControl &&
                                            seenStateChange) {
                                          return;
                                      }
                                      if (DEBUG) {
                                          java.lang.System.
                                            out.
                                            println(
                                              stack);
                                          java.lang.System.
                                            out.
                                            println(
                                              getPC(
                                                ) +
                                              " : " +
                                              OPCODE_NAMES[seen]);
                                      }
                                      if ((seen ==
                                             INVOKEVIRTUAL ||
                                             seen ==
                                             INVOKEINTERFACE) &&
                                            "add".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            "(Ljava/lang/Object;)Z".
                                            equals(
                                              getSigConstantOperand(
                                                )) &&
                                            stack.
                                            getStackDepth(
                                              ) >=
                                            2) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item it0 =
                                            stack.
                                            getStackItem(
                                              0);
                                          int r0 =
                                            it0.
                                            getRegisterNumber(
                                              );
                                          edu.umd.cs.findbugs.OpcodeStack.Item it1 =
                                            stack.
                                            getStackItem(
                                              1);
                                          int r1 =
                                            it1.
                                            getRegisterNumber(
                                              );
                                          if (r0 ==
                                                r1 &&
                                                r0 >
                                                0) {
                                              bugReporter.
                                                reportBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "IL_CONTAINER_ADDED_TO_ITSELF",
                                                    NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addSourceLine(
                                                      this));
                                          }
                                      }
                                      if ((seen ==
                                             INVOKEVIRTUAL ||
                                             seen ==
                                             INVOKESPECIAL ||
                                             seen ==
                                             INVOKEINTERFACE ||
                                             seen ==
                                             INVOKESTATIC) &&
                                            getNameConstantOperand(
                                              ).
                                            equals(
                                              getMethodName(
                                                )) &&
                                            getSigConstantOperand(
                                              ).
                                            equals(
                                              getMethodSig(
                                                )) &&
                                            seen ==
                                            INVOKESTATIC ==
                                            getMethod(
                                              ).
                                            isStatic(
                                              ) &&
                                            seen ==
                                            INVOKESPECIAL ==
                                            (getMethod(
                                               ).
                                               isPrivate(
                                                 ) &&
                                               !getMethod(
                                                  ).
                                               isStatic(
                                                 ) ||
                                               "<init>".
                                               equals(
                                                 getMethodName(
                                                   )))) {
                                          org.apache.bcel.generic.Type[] arguments =
                                            getMethod(
                                              ).
                                            getArgumentTypes(
                                              );
                                          int parameters =
                                            arguments.
                                              length;
                                          if (!getMethod(
                                                 ).
                                                isStatic(
                                                  )) {
                                              parameters++;
                                          }
                                          edu.umd.cs.findbugs.ba.XMethod xMethod =
                                            edu.umd.cs.findbugs.ba.XFactory.
                                            createReferencedXMethod(
                                              this);
                                          if (DEBUG) {
                                              java.lang.System.
                                                out.
                                                println(
                                                  "IL: Checking...");
                                              java.lang.System.
                                                out.
                                                println(
                                                  xMethod);
                                              java.lang.System.
                                                out.
                                                println(
                                                  "vs. " +
                                                  getClassName(
                                                    ) +
                                                  "." +
                                                  getMethodName(
                                                    ) +
                                                  " : " +
                                                  getMethodSig(
                                                    ));
                                          }
                                          if (xMethod.
                                                getClassName(
                                                  ).
                                                replace(
                                                  '.',
                                                  '/').
                                                equals(
                                                  getClassName(
                                                    )) ||
                                                seen ==
                                                INVOKEINTERFACE) {
                                              int firstParameter =
                                                0;
                                              if ("<init>".
                                                    equals(
                                                      getMethodName(
                                                        ))) {
                                                  firstParameter =
                                                    1;
                                              }
                                              boolean match1 =
                                                !seenStateChange;
                                              for (int i =
                                                     firstParameter;
                                                   match1 &&
                                                     i <
                                                     parameters;
                                                   i++) {
                                                  edu.umd.cs.findbugs.OpcodeStack.Item it =
                                                    stack.
                                                    getStackItem(
                                                      parameters -
                                                        1 -
                                                        i);
                                                  if (!it.
                                                        isInitialParameter(
                                                          ) ||
                                                        it.
                                                        getRegisterNumber(
                                                          ) !=
                                                        i) {
                                                      match1 =
                                                        false;
                                                  }
                                              }
                                              boolean sameMethod =
                                                seen ==
                                                INVOKESTATIC ||
                                                "<init>".
                                                equals(
                                                  getNameConstantOperand(
                                                    ));
                                              if (!sameMethod) {
                                                  if (DEBUG) {
                                                      java.lang.System.
                                                        out.
                                                        println(
                                                          "Stack is " +
                                                          stack);
                                                  }
                                                  edu.umd.cs.findbugs.OpcodeStack.Item p =
                                                    stack.
                                                    getStackItem(
                                                      parameters -
                                                        1);
                                                  if (DEBUG) {
                                                      java.lang.System.
                                                        out.
                                                        println(
                                                          "parameters = " +
                                                          parameters +
                                                          ", Item is " +
                                                          p);
                                                  }
                                                  java.lang.String sig =
                                                    p.
                                                    getSignature(
                                                      );
                                                  sameMethod =
                                                    p.
                                                      isInitialParameter(
                                                        ) &&
                                                      p.
                                                      getRegisterNumber(
                                                        ) ==
                                                      0 &&
                                                      sig.
                                                      equals(
                                                        "L" +
                                                        getClassName(
                                                          ) +
                                                        ";");
                                              }
                                              boolean match2 =
                                                sameMethod &&
                                                !seenTransferOfControl;
                                              boolean match3 =
                                                sameMethod &&
                                                !seenReturn &&
                                                largestBranchTarget <
                                                getPC(
                                                  );
                                              if (match1 ||
                                                    match2 ||
                                                    match3) {
                                                  if (DEBUG) {
                                                      java.lang.System.
                                                        out.
                                                        println(
                                                          "IL: " +
                                                          sameMethod +
                                                          " " +
                                                          match1 +
                                                          " " +
                                                          match2 +
                                                          " " +
                                                          match3);
                                                  }
                                                  bugReporter.
                                                    reportBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "IL_INFINITE_RECURSIVE_LOOP",
                                                        HIGH_PRIORITY).
                                                        addClassAndMethod(
                                                          this).
                                                        addSourceLine(
                                                          this));
                                              }
                                          }
                                      }
                                      switch (seen) {
                                          case ARETURN:
                                          case IRETURN:
                                          case LRETURN:
                                          case RETURN:
                                          case DRETURN:
                                          case FRETURN:
                                              seenReturn =
                                                true;
                                              seenTransferOfControl =
                                                true;
                                              break;
                                          case ATHROW:
                                              seenTransferOfControl =
                                                true;
                                              break;
                                          case PUTSTATIC:
                                          case PUTFIELD:
                                          case IASTORE:
                                          case AASTORE:
                                          case DASTORE:
                                          case FASTORE:
                                          case LASTORE:
                                          case SASTORE:
                                          case CASTORE:
                                          case BASTORE:
                                              seenStateChange =
                                                true;
                                              break;
                                          case INVOKEVIRTUAL:
                                          case INVOKESPECIAL:
                                          case INVOKEINTERFACE:
                                          case INVOKESTATIC:
                                              if ("print".
                                                    equals(
                                                      getNameConstantOperand(
                                                        )) ||
                                                    "println".
                                                    equals(
                                                      getNameConstantOperand(
                                                        )) ||
                                                    "log".
                                                    equals(
                                                      getNameConstantOperand(
                                                        )) ||
                                                    "toString".
                                                    equals(
                                                      getNameConstantOperand(
                                                        ))) {
                                                  break;
                                              }
                                              seenStateChange =
                                                true;
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
       "9Wjpavfv4hWbD/8L0/Wl0mYeAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
