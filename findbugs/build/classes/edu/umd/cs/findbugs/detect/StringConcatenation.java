package edu.umd.cs.findbugs.detect;
public class StringConcatenation extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "sbsc.debug");
    static final int SEEN_NOTHING = 0;
    static final int SEEN_NEW = 1;
    static final int SEEN_APPEND1 = 2;
    static final int SEEN_APPEND2 = 3;
    static final int CONSTRUCTED_STRING_ON_STACK = 4;
    static final int POSSIBLE_CASE = 5;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private boolean reportedThisMethod;
    private int registerOnStack = -1;
    private int stringSource = -1;
    private int createPC = -1;
    private int state = SEEN_NOTHING;
    public StringConcatenation(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    private java.util.Map<java.lang.Integer,java.lang.Integer> clobberedRegisters =
      new java.util.HashMap<java.lang.Integer,java.lang.Integer>(
      );
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) { if (DEBUG) {
                                                                  java.lang.System.
                                                                    out.
                                                                    println(
                                                                      "------------------- Analyzing " +
                                                                      obj.
                                                                        getName(
                                                                          ) +
                                                                      " ----------------");
                                                              }
                                                              reset(
                                                                );
                                                              clobberedRegisters =
                                                                new java.util.HashMap<java.lang.Integer,java.lang.Integer>(
                                                                  );
                                                              reportedThisMethod =
                                                                false;
                                                              super.
                                                                visit(
                                                                  obj);
    }
    private void reset() { state = SEEN_NOTHING;
                           createPC = -1;
                           registerOnStack =
                             -1;
                           stringSource =
                             -1;
                           if (DEBUG) { java.lang.System.
                                          out.
                                          println(
                                            "Reset from: " +
                                            new java.lang.Throwable(
                                              ).
                                              getStackTrace(
                                                )[1]);
                           } }
    private boolean storeIntoRegister(int seen,
                                      int reg) {
        switch (seen) {
            case ASTORE_0:
                return reg ==
                  0;
            case ASTORE_1:
                return reg ==
                  1;
            case ASTORE_2:
                return reg ==
                  2;
            case ASTORE_3:
                return reg ==
                  3;
            case ASTORE:
                return reg ==
                  getRegisterOperand(
                    );
            default:
                return false;
        }
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (reportedThisMethod) {
                                          return;
                                      }
                                      int oldState =
                                        state;
                                      if (DEBUG) {
                                          java.lang.System.
                                            out.
                                            print(
                                              "Opcode: ");
                                          printOpCode(
                                            seen);
                                      }
                                      int storeTo =
                                        -1;
                                      switch (seen) {
                                          case ASTORE_0:
                                              storeTo =
                                                0;
                                              break;
                                          case ASTORE_1:
                                              storeTo =
                                                1;
                                              break;
                                          case ASTORE_2:
                                              storeTo =
                                                2;
                                              break;
                                          case ASTORE_3:
                                              storeTo =
                                                3;
                                              break;
                                          case ASTORE:
                                              storeTo =
                                                getRegisterOperand(
                                                  );
                                              break;
                                          default:
                                              break;
                                      }
                                      if (storeTo >=
                                            0 &&
                                            state !=
                                            CONSTRUCTED_STRING_ON_STACK) {
                                          clobberedRegisters.
                                            put(
                                              storeTo,
                                              getPC(
                                                ));
                                      }
                                      switch (state) {
                                          case SEEN_NOTHING:
                                              if (seen ==
                                                    NEW &&
                                                    getClassConstantOperand(
                                                      ).
                                                    startsWith(
                                                      "java/lang/StringBu")) {
                                                  state =
                                                    SEEN_NEW;
                                                  createPC =
                                                    getPC(
                                                      );
                                              }
                                              break;
                                          case SEEN_NEW:
                                              if (seen ==
                                                    INVOKESPECIAL &&
                                                    "<init>".
                                                    equals(
                                                      getNameConstantOperand(
                                                        )) &&
                                                    "(Ljava/lang/String;)V".
                                                    equals(
                                                      getSigConstantOperand(
                                                        )) &&
                                                    getClassConstantOperand(
                                                      ).
                                                    startsWith(
                                                      "java/lang/StringBu") &&
                                                    registerOnStack >=
                                                    0) {
                                                  state =
                                                    SEEN_APPEND1;
                                                  stringSource =
                                                    registerOnStack;
                                              }
                                              else
                                                  if (seen ==
                                                        INVOKEVIRTUAL &&
                                                        "append".
                                                        equals(
                                                          getNameConstantOperand(
                                                            )) &&
                                                        getClassConstantOperand(
                                                          ).
                                                        startsWith(
                                                          "java/lang/StringBu")) {
                                                      if (DEBUG) {
                                                          java.lang.System.
                                                            out.
                                                            println(
                                                              "Saw string being appended from register " +
                                                              registerOnStack);
                                                      }
                                                      if (getSigConstantOperand(
                                                            ).
                                                            startsWith(
                                                              "(Ljava/lang/String;)") &&
                                                            registerOnStack >=
                                                            0) {
                                                          if (DEBUG) {
                                                              java.lang.System.
                                                                out.
                                                                println(
                                                                  "Saw string being appended, source = " +
                                                                  registerOnStack);
                                                          }
                                                          state =
                                                            SEEN_APPEND1;
                                                          stringSource =
                                                            registerOnStack;
                                                      }
                                                      else {
                                                          reset(
                                                            );
                                                      }
                                                  }
                                              break;
                                          case SEEN_APPEND1:
                                              if (storeIntoRegister(
                                                    seen,
                                                    stringSource)) {
                                                  reset(
                                                    );
                                              }
                                              else
                                                  if (seen ==
                                                        INVOKEVIRTUAL &&
                                                        "append".
                                                        equals(
                                                          getNameConstantOperand(
                                                            )) &&
                                                        getClassConstantOperand(
                                                          ).
                                                        startsWith(
                                                          "java/lang/StringBu")) {
                                                      state =
                                                        SEEN_APPEND2;
                                                  }
                                              break;
                                          case SEEN_APPEND2:
                                              if (storeIntoRegister(
                                                    seen,
                                                    stringSource)) {
                                                  reset(
                                                    );
                                              }
                                              else
                                                  if (seen ==
                                                        INVOKEVIRTUAL &&
                                                        "toString".
                                                        equals(
                                                          getNameConstantOperand(
                                                            )) &&
                                                        getClassConstantOperand(
                                                          ).
                                                        startsWith(
                                                          "java/lang/StringBu")) {
                                                      state =
                                                        CONSTRUCTED_STRING_ON_STACK;
                                                  }
                                              break;
                                          case CONSTRUCTED_STRING_ON_STACK:
                                              if (storeIntoRegister(
                                                    seen,
                                                    stringSource)) {
                                                  state =
                                                    POSSIBLE_CASE;
                                              }
                                              else {
                                                  reset(
                                                    );
                                              }
                                              break;
                                          case POSSIBLE_CASE:
                                              if (edu.umd.cs.findbugs.visitclass.DismantleBytecode.
                                                    isBranch(
                                                      seen) &&
                                                    getPC(
                                                      ) -
                                                    getBranchTarget(
                                                      ) <
                                                    300 &&
                                                    getBranchTarget(
                                                      ) <=
                                                    createPC) {
                                                  boolean clobberedInLoop =
                                                    false;
                                                  for (java.util.Map.Entry<java.lang.Integer,java.lang.Integer> entry
                                                        :
                                                        clobberedRegisters.
                                                         entrySet(
                                                           )) {
                                                      int reg =
                                                        entry.
                                                        getKey(
                                                          );
                                                      if (reg !=
                                                            stringSource) {
                                                          continue;
                                                      }
                                                      int pc =
                                                        entry.
                                                        getValue(
                                                          );
                                                      if (pc >=
                                                            getBranchTarget(
                                                              )) {
                                                          clobberedInLoop =
                                                            true;
                                                          break;
                                                      }
                                                  }
                                                  if (clobberedInLoop) {
                                                      reset(
                                                        );
                                                      break;
                                                  }
                                                  bugReporter.
                                                    reportBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "SBSC_USE_STRINGBUFFER_CONCATENATION",
                                                        NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this).
                                                        addSourceLine(
                                                          this,
                                                          createPC));
                                                  reset(
                                                    );
                                                  reportedThisMethod =
                                                    true;
                                              }
                                              else
                                                  if (seen ==
                                                        NEW &&
                                                        getClassConstantOperand(
                                                          ).
                                                        startsWith(
                                                          "java/lang/StringBu")) {
                                                      state =
                                                        SEEN_NEW;
                                                      createPC =
                                                        getPC(
                                                          );
                                                  }
                                                  else {
                                                      if (DEBUG &&
                                                            edu.umd.cs.findbugs.visitclass.DismantleBytecode.
                                                            isBranch(
                                                              seen)) {
                                                          java.lang.System.
                                                            out.
                                                            println(
                                                              "Rejecting branch:");
                                                          java.lang.System.
                                                            out.
                                                            println(
                                                              "  spread: " +
                                                              (getPC(
                                                                 ) -
                                                                 getBranchTarget(
                                                                   )));
                                                          java.lang.System.
                                                            out.
                                                            println(
                                                              "  getBranchTarget(): " +
                                                              getBranchTarget(
                                                                ));
                                                          java.lang.System.
                                                            out.
                                                            println(
                                                              "  createPC: " +
                                                              createPC);
                                                      }
                                                  }
                                              break;
                                          default:
                                              break;
                                      }
                                      if (seen ==
                                            INVOKESTATIC &&
                                            "valueOf".
                                            equals(
                                              getNameConstantOperand(
                                                )) &&
                                            "java/lang/String".
                                            equals(
                                              getClassConstantOperand(
                                                )) &&
                                            "(Ljava/lang/Object;)Ljava/lang/String;".
                                            equals(
                                              getSigConstantOperand(
                                                ))) {
                                          
                                      }
                                      else {
                                          registerOnStack =
                                            -1;
                                          switch (seen) {
                                              case ALOAD_0:
                                                  registerOnStack =
                                                    0;
                                                  break;
                                              case ALOAD_1:
                                                  registerOnStack =
                                                    1;
                                                  break;
                                              case ALOAD_2:
                                                  registerOnStack =
                                                    2;
                                                  break;
                                              case ALOAD_3:
                                                  registerOnStack =
                                                    3;
                                                  break;
                                              case ALOAD:
                                                  registerOnStack =
                                                    getRegisterOperand(
                                                      );
                                                  break;
                                              default:
                                                  break;
                                          }
                                      }
                                      if (DEBUG &&
                                            state !=
                                            oldState) {
                                          java.lang.System.
                                            out.
                                            println(
                                              "At PC " +
                                              getPC(
                                                ) +
                                              " changing from state " +
                                              oldState +
                                              " to state " +
                                              state +
                                              ", regOnStack = " +
                                              registerOnStack);
                                      } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "K/Mf6mOFQp4qAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17eezj2H2fZmbP2fXO7qyvbOz17nrWiS37R4k6KGHs2BJJ" +
       "SRRPiRIpsbXHvA/xEg+RkrNp7B5rxIjjpuvUAZxt/nCaNvARFDFaoEjromhi" +
       "5wLcBm0coHaQFqiT1EWMIklRt04fqd89vxnPOEEF8OnpnZ/v+b7v8emz36o8" +
       "GEeVahi4W9MNkgM9Tw4ct3WQbEM9PhhTLU6OYl1DXTmOZ6DslvrCL1/78+98" +
       "wnrycuUhqfK07PtBIid24MdTPQ7cja5RlWsnpbire3FSeZJy5I0MpYntQpQd" +
       "JzepymOnuiaVG9QRBAhAgAAEqIQA9U5agU6v0f3UQ4sesp/E68qPVS5RlYdC" +
       "tYCXVJ4/O0goR7J3OAxXUgBGeKT4LQCiys55VHnumPY9zbcR/Mkq9Mo//MCT" +
       "/+xK5ZpUuWb7fAFHBSASMIlUedzTPUWP4p6m6ZpUecrXdY3XI1t27V2JW6pc" +
       "j23Tl5M00o+ZVBSmoR6Vc55w7nG1oC1K1SSIjskzbN3Vjn49aLiyCWh9/Qmt" +
       "ewoHRTkg8KoNgEWGrOpHXR5Y2b6WVN5yvscxjTdI0AB0fdjTEys4nuoBXwYF" +
       "let72bmyb0J8Etm+CZo+GKRglqTyzB0HLXgdyupKNvVbSeWN59tx+yrQ6tGS" +
       "EUWXpPK6883KkYCUnjknpVPy+Rbz7o9/yB/5l0vMmq66Bf5HQKdnz3Wa6oYe" +
       "6b6q7zs+/g7qZ+TX/+pHL1cqoPHrzjXet/nnP/rt973z2S99ed/mBy9owyqO" +
       "ria31M8oT3z1Tejbu1cKGI+EQWwXwj9Dean+3GHNzTwElvf64xGLyoOjyi9N" +
       "f23547+k/8nlylWi8pAauKkH9OgpNfBC29Wjoe7rkZzoGlF5VPc1tKwnKg+D" +
       "PGX7+r6UNYxYT4jKA25Z9FBQ/gYsMsAQBYseBnnbN4KjfCgnVpnPw0ql8jB4" +
       "Kh8Azzsr+0/5nVR0yAo8HZJV2bf9AOKioKA/hnQ/UQBvLcgAyqSkZgzFkQqV" +
       "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" +
       "HtJW5FWjBjuL16MxOtDicdiLNGYtm4k4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "NwAA");
}
