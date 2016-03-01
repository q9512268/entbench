package edu.umd.cs.findbugs.detect;
public class InefficientInitializationInsideLoop extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor NODELIST_GET_LENGTH =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "org/w3c/dom/NodeList",
      "getLength",
      "()I");
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor
      PATTERN_COMPILE =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/util/regex/Pattern",
      "compile",
      "(Ljava/lang/String;)Ljava/util/regex/Pattern;",
      true);
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor
      PATTERN_COMPILE_2 =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/util/regex/Pattern",
      "compile",
      "(Ljava/lang/String;I)Ljava/util/regex/Pattern;",
      true);
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor
      PATTERN_MATCHES =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/util/regex/Pattern",
      "matches",
      "(Ljava/lang/String;Ljava/lang/CharSequence;)Z",
      true);
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor
      STRING_REPLACEALL =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/lang/String",
      "replaceAll",
      "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;");
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor
      STRING_REPLACEFIRST =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/lang/String",
      "replaceFirst",
      "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;");
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor
      STRING_MATCHES =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/lang/String",
      "matches",
      "(Ljava/lang/String;)Z");
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor
      STRING_SPLIT =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/lang/String",
      "split",
      "(Ljava/lang/String;)[Ljava/lang/String;");
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor
      STRING_SPLIT_2 =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/lang/String",
      "split",
      "(Ljava/lang/String;I)[Ljava/lang/String;");
    private static final java.util.Set<edu.umd.cs.findbugs.classfile.MethodDescriptor>
      implicitPatternMethods =
      new java.util.HashSet<edu.umd.cs.findbugs.classfile.MethodDescriptor>(
      java.util.Arrays.
        asList(
          PATTERN_MATCHES,
          STRING_MATCHES,
          STRING_REPLACEALL,
          STRING_REPLACEFIRST,
          STRING_SPLIT,
          STRING_SPLIT_2));
    private static final java.util.List<edu.umd.cs.findbugs.classfile.MethodDescriptor>
      methods =
      new java.util.ArrayList<edu.umd.cs.findbugs.classfile.MethodDescriptor>(
      );
    static { methods.add(NODELIST_GET_LENGTH);
             methods.add(PATTERN_COMPILE);
             methods.add(PATTERN_COMPILE_2);
             methods.addAll(implicitPatternMethods);
    }
    private java.util.SortedMap<java.lang.Integer,edu.umd.cs.findbugs.BugInstance>
      matched;
    private java.util.SortedMap<java.lang.Integer,java.lang.Integer>
      conditions;
    private java.util.SortedMap<java.lang.Integer,java.lang.Integer>
      sources;
    private final edu.umd.cs.findbugs.BugReporter
      bugReporter;
    public InefficientInitializationInsideLoop(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        if (hasInterestingMethod(
              classContext.
                getJavaClass(
                  ).
                getConstantPool(
                  ),
              methods) ||
              hasInterestingClass(
                classContext.
                  getJavaClass(
                    ).
                  getConstantPool(
                    ),
                java.util.Collections.
                  singleton(
                    "java/sql/Connection"))) {
            super.
              visitClassContext(
                classContext);
        }
    }
    @java.lang.Override
    public void visitMethod(org.apache.bcel.classfile.Method obj) {
        matched =
          new java.util.TreeMap<java.lang.Integer,edu.umd.cs.findbugs.BugInstance>(
            );
        conditions =
          new java.util.TreeMap<java.lang.Integer,java.lang.Integer>(
            );
        sources =
          new java.util.TreeMap<java.lang.Integer,java.lang.Integer>(
            );
        super.
          visitMethod(
            obj);
    }
    private boolean isFastPath(java.lang.String regex) {
        char ch;
        return (regex.
                  length(
                    ) ==
                  1 &&
                  ".$|()[{^?*+\\".
                  indexOf(
                    ch =
                      regex.
                        charAt(
                          0)) ==
                  -1 ||
                  regex.
                  length(
                    ) ==
                  2 &&
                  regex.
                  charAt(
                    0) ==
                  '\\' &&
                  ((ch =
                      regex.
                        charAt(
                          1)) -
                     '0' |
                     '9' -
                     ch) <
                  0 &&
                  (ch -
                     'a' |
                     'z' -
                     ch) <
                  0 &&
                  (ch -
                     'A' |
                     'Z' -
                     ch) <
                  0) &&
          (ch <
             java.lang.Character.
               MIN_HIGH_SURROGATE ||
             ch >
             java.lang.Character.
               MAX_LOW_SURROGATE);
    }
    @java.lang.Override
    public void sawOpcode(int seen) { if (seen ==
                                            INVOKEINTERFACE &&
                                            getClassConstantOperand(
                                              ).
                                            equals(
                                              "java/sql/Connection") &&
                                            getMethodDescriptorOperand(
                                              ).
                                            getName(
                                              ).
                                            equals(
                                              "prepareStatement") &&
                                            hasConstantArguments(
                                              )) {
                                          matched.
                                            put(
                                              getPC(
                                                ),
                                              new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                "IIL_PREPARE_STATEMENT_IN_LOOP",
                                                NORMAL_PRIORITY).
                                                addClassAndMethod(
                                                  this).
                                                addSourceLine(
                                                  this,
                                                  getPC(
                                                    )).
                                                addCalledMethod(
                                                  this));
                                      }
                                      else
                                          if (seen ==
                                                INVOKEINTERFACE &&
                                                getMethodDescriptorOperand(
                                                  ).
                                                equals(
                                                  NODELIST_GET_LENGTH)) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item item =
                                                getStack(
                                                  ).
                                                getStackItem(
                                                  0);
                                              edu.umd.cs.findbugs.ba.XMethod returnValueOf =
                                                item.
                                                getReturnValueOf(
                                                  );
                                              if (returnValueOf !=
                                                    null &&
                                                    returnValueOf.
                                                    getClassName(
                                                      ).
                                                    startsWith(
                                                      "org.w3c.dom.") &&
                                                    returnValueOf.
                                                    getName(
                                                      ).
                                                    startsWith(
                                                      "getElementsByTagName")) {
                                                  matched.
                                                    put(
                                                      getPC(
                                                        ),
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "IIL_ELEMENTS_GET_LENGTH_IN_LOOP",
                                                        NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this).
                                                        addSourceLine(
                                                          this,
                                                          getPC(
                                                            )).
                                                        addCalledMethod(
                                                          this));
                                                  sources.
                                                    put(
                                                      getPC(
                                                        ),
                                                      item.
                                                        getPC(
                                                          ));
                                              }
                                          }
                                          else
                                              if (seen ==
                                                    INVOKESTATIC &&
                                                    (getMethodDescriptorOperand(
                                                       ).
                                                       equals(
                                                         PATTERN_COMPILE) ||
                                                       getMethodDescriptorOperand(
                                                         ).
                                                       equals(
                                                         PATTERN_COMPILE_2)) &&
                                                    hasConstantArguments(
                                                      )) {
                                                  java.lang.String regex =
                                                    getFirstArgument(
                                                      );
                                                  matched.
                                                    put(
                                                      getPC(
                                                        ),
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "IIL_PATTERN_COMPILE_IN_LOOP",
                                                        NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this).
                                                        addSourceLine(
                                                          this,
                                                          getPC(
                                                            )).
                                                        addCalledMethod(
                                                          this).
                                                        addString(
                                                          regex).
                                                        describe(
                                                          edu.umd.cs.findbugs.StringAnnotation.
                                                            REGEX_ROLE));
                                              }
                                              else
                                                  if ((seen ==
                                                         INVOKESTATIC ||
                                                         seen ==
                                                         INVOKEVIRTUAL) &&
                                                        implicitPatternMethods.
                                                        contains(
                                                          getMethodDescriptorOperand(
                                                            ))) {
                                                      java.lang.String regex =
                                                        getFirstArgument(
                                                          );
                                                      if (regex !=
                                                            null &&
                                                            !(getNameConstantOperand(
                                                                ).
                                                                equals(
                                                                  "split") &&
                                                                isFastPath(
                                                                  regex))) {
                                                          edu.umd.cs.findbugs.BugInstance bug =
                                                            new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "IIL_PATTERN_COMPILE_IN_LOOP_INDIRECT",
                                                            LOW_PRIORITY).
                                                            addClassAndMethod(
                                                              this).
                                                            addSourceLine(
                                                              this,
                                                              getPC(
                                                                )).
                                                            addCalledMethod(
                                                              this).
                                                            addString(
                                                              regex).
                                                            describe(
                                                              edu.umd.cs.findbugs.StringAnnotation.
                                                                REGEX_ROLE);
                                                          matched.
                                                            put(
                                                              getPC(
                                                                ),
                                                              bug);
                                                      }
                                                  }
                                                  else
                                                      if (isBranch(
                                                            seen) &&
                                                            getBranchOffset(
                                                              ) >
                                                            0) {
                                                          conditions.
                                                            put(
                                                              getPC(
                                                                ),
                                                              getBranchTarget(
                                                                ));
                                                      }
                                                      else
                                                          if (!matched.
                                                                isEmpty(
                                                                  ) &&
                                                                isBranch(
                                                                  seen) &&
                                                                getBranchOffset(
                                                                  ) <
                                                                0) {
                                                              for (java.util.Map.Entry<java.lang.Integer,edu.umd.cs.findbugs.BugInstance> entry
                                                                    :
                                                                    matched.
                                                                     tailMap(
                                                                       getBranchTarget(
                                                                         )).
                                                                     entrySet(
                                                                       )) {
                                                                  java.lang.Integer source =
                                                                    sources.
                                                                    get(
                                                                      entry.
                                                                        getKey(
                                                                          ));
                                                                  if (source !=
                                                                        null &&
                                                                        (source >
                                                                           getBranchTarget(
                                                                             ) &&
                                                                           source <
                                                                           getPC(
                                                                             ))) {
                                                                      return;
                                                                  }
                                                                  for (int target
                                                                        :
                                                                        conditions.
                                                                         subMap(
                                                                           getBranchTarget(
                                                                             ),
                                                                           entry.
                                                                             getKey(
                                                                               )).
                                                                         values(
                                                                           )) {
                                                                      if (target >
                                                                            entry.
                                                                            getKey(
                                                                              ) &&
                                                                            target <
                                                                            getPC(
                                                                              )) {
                                                                          return;
                                                                      }
                                                                  }
                                                                  bugReporter.
                                                                    reportBug(
                                                                      entry.
                                                                        getValue(
                                                                          ));
                                                              }
                                                          }
    }
    private java.lang.String getFirstArgument() {
        java.lang.Object value =
          getStack(
            ).
          getStackItem(
            getNumberArguments(
              getMethodDescriptorOperand(
                ).
                getSignature(
                  )) -
              1).
          getConstant(
            );
        return value ==
          null
          ? null
          : value.
          toString(
            );
    }
    private boolean hasConstantArguments() {
        int nArgs =
          getNumberArguments(
            getMethodDescriptorOperand(
              ).
              getSignature(
                ));
        for (int i =
               0;
             i <
               nArgs;
             i++) {
            if (getStack(
                  ).
                  getStackItem(
                    i).
                  getConstant(
                    ) ==
                  null) {
                return false;
            }
        }
        return true;
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
      ("H4sIAAAAAAAAAMV7CcwkWX1fz8zeu+zszi4LbGDZZQebpWCqj6qu7uya0N11" +
       "dFdXdVfX0Rc2Q91H19V1dFUXXswiJaDYxggvGCS8UiysxBiDHQUlUkJEEhJD" +
       "fCiOHMdYCpAokrEdIiNkOwoJTlV1f+d83+zMgpWW3vvqe1f9/uf7v6M+++3K" +
       "nWFQAXzP3uq2F11T0+iaZcPXoq2vhtdICmbEIFSVni2GIZ+XXZff9OuX//J7" +
       "HzEeuli5a1l5RHRdLxIj03NDVg09e6MqVOXyUSlmq04YVR6iLHEjgnFk2iBl" +
       "htGzVOX+Y12jylXqAAKYQwBzCGAJAewctco7vUp1Y6dX9BDdKFxX3le5QFXu" +
       "8uUCXlR56uQgvhiIzn4YpqQgH+Ge4v9pTlTZOQ0qTx7SvqP5BoI/BoAv/sK7" +
       "H/rHlyqXl5XLpssVcOQcRJS/ZFl5wFEdSQ3CjqKoyrLysKuqCqcGpmibWYl7" +
       "WbkSmrorRnGgHjKpKIx9NSjfecS5B+SCtiCWIy84JE8zVVs5+O9OzRb1nNbH" +
       "jmjdUYgX5TmB95k5sEATZfWgyx0r01WiyhtP9zik8eowb5B3vdtRI8M7fNUd" +
       "rpgXVK7sZGeLrg5yUWC6et70Ti/O3xJVHj930ILXviivRF29HlVee7ods6vK" +
       "W91bMqLoElVefbpZOVIupcdPSemYfL49eu7D73X77sUSs6LKdoH/nrzTE6c6" +
       "saqmBqorq7uOD7yV+rj42Bc/dLFSyRu/+lTjXZt/+pPfeefbnvjSV3Zt/tYZ" +
       "bcaSpcrRdfnT0oO/9/reM+1LBYx7fC80C+GfoLxUf2Zf82zq55b32OGIReW1" +
       "g8ovsf9u8f7PqH92sXLfoHKX7Nmxk+vRw7Ln+KatBoTqqoEYqcqgcq/qKr2y" +
       "flC5O3+mTFfdlY41LVSjQeUOuyy6yyv/z1mk5UMULLo7fzZdzTt49sXIKJ9T" +
       "v1Kp3J2nygN5ulbZ/cq/USUGDc9RQVEWXdP1QCbwCvpDUHUjKeetAWq5Mkmx" +
       "HoJhIIOl6qhKDMaOAsrhUaWiRnk3cOCqmmbKZt574OakH1rNwA1NRaU8z79W" +
       "jOH//3pxWnDkoeTChVxYrz/tKuzcyvqerajBdfnFuIt953PXf+vioenseRlV" +
       "3pHjuJbjuCaH1w5wXNvhuHYLOCoXLpSvf7TAs9OTXMqr3F/knvSBZ7ifIN/z" +
       "oTddyhXUT+7IRVQ0Bc936L0jDzMo/aicq3nlS59IXpj+VPVi5eJJz1zQkBfd" +
       "V3RnCn966DevnrbIs8a9/MFv/eXnP/68d2SbJ1z93mXc2LMw+Ted5nbgyTkj" +
       "A/Vo+Lc+KX7h+hefv3qxckfuR3LfGYm5rudu6YnT7zhh+s8euNGCljtzgjUv" +
       "cES7qDrwffdFRuAlRyWlGjxYPj+c8/j+A4Og98ZR/i1qH/GL/NGd2hRCO0VF" +
       "6aZ/jPN/8Q9/908aJbsPPPrlY3Mkp0bPHvMixWCXS3/x8JEO8IGq5u3+yyeY" +
       "n//Ytz/4rlIB8hZPn/XCq0Xey71HLsKczX/3K+uvfePrn/79i0dKE+XTaCzZ" +
       "ppweElmUV+67CZH5237kCE/uhexcowutuSq4jqeYmilKtlpo6f+5/ObaF/7H" +
       "hx/a6YGdlxyo0dtefoCj8td1K+//rXf/1RPlMBfkYhY84tlRs51rfeRo5E4Q" +
       "iNsCR/rCf3zDJ39T/MXcSeeOMTQztfR1F/aGU4B6dT5TnmWv3VhnVd8L8mmv" +
       "FC5Ytn5rmZeusRyjUtY1iuyN4XEjOWmHx6Ka6/JHfv/PXzX983/5nZKqk2HR" +
       "cZ2gRf/ZnRoW2ZNpPvxrTnuEvhgaeTvoS6Mff8j+0vfyEZf5iHIeC4TjIHdT" +
       "6QkN2re+8+4/+lf/5rH3/N6lykW8cp/tiQoulsZYuTe3AjU0cg+X+n/nnTsl" +
       "SO7Js4dKUis3EL9TnteW/13JAT5zvh/Ci6jmyJRf+7/HtvSB//a/bmBC6YHO" +
       "mMxP9V+Cn/3U4713/FnZ/8gVFL2fSG903XkEeNS3/hnnLy6+6a5/e7Fy97Ly" +
       "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" +
       "MI7ivLUNe3Btik/mOl5fLfBOJvYs1KvV");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2X66GCpTM9MT06MJFoAzp1XbRktouuwqfVjErMhmpv0OvFIEgBk2A7dlwrNh" +
       "0qu2IIauw5M1kAciii/0nE4jBeoJ7TYTCJq2IwSpEloIzefCtGnYNJqvApI8" +
       "oKmlLXZmVtX1cLtWTcY0DIKZYvzKlIWGPAOiNSpQBmC1s4WD5tF0u0WuPV5N" +
       "TdYR6WY1UPOIUZnrm8mcwjo4BzdimtxU+1N+q9Ai69DbaTVbVOkxoyxxex4K" +
       "TQKB2pGJhCpHC8MkXUryVAz82KJlZzLA10NUjoRAWqsQnYX5vDYdIz0I6yRJ" +
       "bet1Dawq9Wl4g6pCqx0g8KaFW1JIzJO1tpBwfN1CLWwKid1aLHrNJHHnNp5S" +
       "znQtMx1lxkyyDd4IbC6j5UVtmYgrtwFI4moEBX0ApsFWMFM1klSRlr4JzEAz" +
       "YKhdx5Vp01l1F7JtrXWCj+e+39xs1kAnkwYLUYI4wNhilF1FVisXBWo9tz5u" +
       "0euG22FzD55PNfSSkLZVUqjSBEUmKwKpZSC4qc3bsaPOGvXatqmpwbqfLEU9" +
       "nc5rYxPBvJCsdwHLZoS1Hwo62lvNJrSTMmqUrEFWq2LdGFUgrNFUIseC2spc" +
       "xHRloQOKJ2osiEFuLZkbAD90tfVygSS1SQum+i5ItAgOsyyV49NeUpPZXjNW" +
       "t17guhrZTmuexFubettRIBa3YT1a0aGKD4TpXGmDYqwGNaNqELiMGMvGmMqE" +
       "erYiV/l6nwcWiyarTlE9k4yJzgJ9rz9Be4t+E2kacLsHG8Iym1iC4vIaFy1Y" +
       "KZTaFiAgYZOZpKPqYiPwbORUg6ROJ1E3MN0G4wFBpI1mzdnCF9xEg70ZCKxF" +
       "3h/b47AXVu12OscFQJW1MbVItcZGnc95V6VwfGNtOok84WrjYdYdMunWM9oL" +
       "fyIRU7nNR/NNG96CQJJt06Y957JFna1TfVZwmBnajSkobFk1N7S8IIDXalxn" +
       "qAnU0nLj4qAgXxXmC3iQWQpMSvuEIEBbICWnnJxuq+48iAStjrRriKxrWmug" +
       "QUaPbeMJx1iQi7YbVYmhAG0OtE0KCN2J2/PMOaA5c0Rz6pNtPHbILS26NKFC" +
       "LVunkeF27EDtpbxsokbacElpK4g+gRlh1+0uJQU3gEmmhzCKeEsTmS5To75d" +
       "W/GK7jcAemyMF9oAbqymYg2E0C0amw6a0Z1OZ11534V7bm9n+OFyE/zwGwjL" +
       "RoqK797Gjuiu6qkie/PhmUH5u6ty6t78sTODEwcmYVB5w3mfNpQ7vJ/+wIsv" +
       "KeNfrl3cna5cuBRV7o08/+22ulHtY0PddfNrFbu7F0dXHn/zA3/6OP8O4z23" +
       "ceH7jadwnh7yV+jPfpX4EfmjFyuXDi9A3vDNyclOz546eg/UKA5c/sTlxzcc" +
       "cra8dF0cLrN7zrKnT2OOZHf2+dBbdrIv645u7p66/fv0WQeDkriTy/6zn1IU" +
       "T5wa59gN4AtvKrLX5UpW3tw43rVs/v0j1bpwMarcsfFM5VDnLjx+UuceONS5" +
       "Q4xXjp3pb9QgMBX1Jmp64z3d8sWPneTsj+bpXXvOvutvhLNPeoF+TfRF2VCv" +
       "SbJq33ARtGRd/SZsbRbZ26PK/SVbd52KoqtHzLt2LvOK2md+EDY9WhQ+kSdz" +
       "zybzdtmE3YxNpfspyezchAW9InsuKi4l42JY3K0yzlKpuyXPs1XRPWLMj73c" +
       "2c7LKcjTefL3lPs/fAU5RcAl092ZGXMTZghFNsxdYigmY1/2FPWUNlB/c9rw" +
       "yAFPfmnPk1/64WjDcfrec5M6qcjeFVUe0vM1gBmEUSfQ85jLLa+2fPeIBT/+" +
       "A8i91Pi35OlX9zT+6g+fRvsmdcWXLxf0qPKoIR5ewT8gs4SKHdFp3A6dae7n" +
       "b+HTq+I7ktfe8IHo7qNG+XMvXb7nNS8J/7n8+ujww8N7qco9Wmzbx6/zH3u+" +
       "yw9UzSyZcu/ucn95UeVCHFUeP/8zsahy1+6hJDradclpeOSMLlH+/v3j8dbv" +
       "zV3GUeuoclE+Uf2+3GXsq3Pby/PjlS/kRXll8fgB/8Cbv+3MebJw6ztL5KKc" +
       "UWiJ2gvSCyfDngOpVa68nNSORUpPn3u1kY53H/helz//Ejl673eav7z7tCqf" +
       "YLKsGOUeqnL37iuvw3jmqXNHOxjrrv4z33vw1+998z722n14c+WYyh/D9saz" +
       "v2PCHD8qvzzK/tlr/slz//Clr5f3Gf4fdKCy9Xc9AAA=");
}
