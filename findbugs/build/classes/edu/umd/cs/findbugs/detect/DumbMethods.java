package edu.umd.cs.findbugs.detect;
public class DumbMethods extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    private abstract class SubDetector {
        public void initMethod(org.apache.bcel.classfile.Method method) {
            
        }
        public abstract void sawOpcode(int seen);
        public SubDetector() { super(); }
        public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO38Cxl/YmDhgwBgqE3ILaWgTmaaAwcH0/CFM" +
                                                                  "kGIKx9zenG/tvd1ldtY+O6FNIiU4VUsROAmJGv9FmrRKAqoatVWbyFWkJlHS" +
                                                                  "SomiJmkVUqmVSj9Qgyolf9A2fTOze/txtilVa2nHezNv3nvzPn7vzT5/BVXY" +
                                                                  "FLURgyXYpEXsxF6DDWJqk0y3jm37IMyl1CfK8N+PXu6/M44qh1FtDtt9KrZJ" +
                                                                  "j0b0jD2M1miGzbChErufkAzfMUiJTeg4ZpppDKNmze7NW7qmaqzPzBBOcAjT" +
                                                                  "JGrAjFEt7TDS6zJgaE0SNFGEJsqu6HJXEtWopjXpk68KkHcHVjhl3pdlM1Sf" +
                                                                  "HMXjWHGYpitJzWZdBYpusUx9ckQ3WYIUWGJU3+6aYH9ye4kJ2i/WfXLtdK5e" +
                                                                  "mGAFNgyTiePZB4ht6uMkk0R1/uxeneTt4+hrqCyJlgWIGepIekIVEKqAUO+0" +
                                                                  "PhVov5wYTr7bFMdhHqdKS+UKMbQ+zMTCFOddNoNCZ+BQzdyzi81w2nXF08pT" +
                                                                  "lhzxsVuUmSeO1v+gDNUNozrNGOLqqKAEAyHDYFCSTxNq78pkSGYYNRjg7CFC" +
                                                                  "NaxrU66nG21txMDMAfd7ZuGTjkWokOnbCvwIZ6OOykxaPF5WBJT7qyKr4xE4" +
                                                                  "60r/rPKEPXweDrhUA8VoFkPcuVvKxzQjw9Da6I7iGTu+AgSwtSpPWM4siio3" +
                                                                  "MEygRhkiOjZGlCEIPWMESCtMCEDKUOuCTLmtLayO4RGS4hEZoRuUS0C1RBiC" +
                                                                  "b2GoOUomOIGXWiNeCvjnSv+OU/cZ+4w4ioHOGaLqXP9lsKktsukAyRJKIA/k" +
                                                                  "xprNycfxypen4wgBcXOEWNL86P6rO7e0zb0uaW6eh2YgPUpUllLPp2vfXt3d" +
                                                                  "eWcZV6PaMm2NOz90cpFlg+5KV8EChFlZ5MgXE97i3IFf3PvA98lf4mhpL6pU" +
                                                                  "Td3JQxw1qGbe0nRC7yYGoZiRTC9aQoxMt1jvRVXwntQMImcHslmbsF5Uroup" +
                                                                  "SlP8BhNlgQU30VJ414ys6b1bmOXEe8FCCDXDg1rhSSL5J/4zdETJmXmiYBUb" +
                                                                  "mmEqg9Tk57cVQJw02DanZCGY0s6IrdhUVUTokIyjOPmMotr+YoYw2KbscfLp" +
                                                                  "Phl1CU5r/b8FFPgJV0zEYmD81dHU1yFr9pl6htCUOuPs3nv1xdSbMqx4Kri2" +
                                                                  "Yeg2kJcAeQnVTnjyElJeIiCvY8hJ7xGzJkWxmBDZxHWQvgZPjUHOA+jWdA4d" +
                                                                  "2X9sur0MgsyaKAczc9L2UPHp9oHBQ/OUeqFx+dT6S9tejaPyJGrEKnOwzmvJ" +
                                                                  "LjoCKKWOuYlck4ay5FeHdYHqwMsaNVU4ECULVQmXS7U5TiifZ6gpwMGrXTxL" +
                                                                  "lYUrx7z6o7lzEw8e+vrWOIqHCwIXWQFYxrcPchgvwnVHFAjm41t38vInFx4/" +
                                                                  "YfqQEKowXmEs2cnP0B4Niqh5Uurmdfil1MsnOoTZlwBkMwwpBmjYFpURQpwu" +
                                                                  "D735WarhwFmT5rHOlzwbL2U5ak74MyJaG/jQLAOXh1BEQQH8Xxqynn7/V3/6" +
                                                                  "vLCkVyPqAsV9iLCuAC5xZo0CgRr8iDxICQG6D88Nnn3sysnDIhyBYsN8Ajv4" +
                                                                  "2A14BN4BCz78+vEPPrp0/t24H8IMVVlUg26HFMRhmj6Dvxg8/+IPBxM+IUGl" +
                                                                  "sdtFtnVFaLO46E2+cgByOqQSj46OewyIQy2r4bROeAL9o27jtpf+eqpe+luH" +
                                                                  "GS9ctlyfgT9/0270wJtHP20TbGIqL7K+AX0yidwrfM67KMWTXI/Cg++sefI1" +
                                                                  "/DTUAMBdW5siAkqRMAgSHtwubLFVjLdH1r7Ih412MMjDeRRohlLq6Xc/Xn7o" +
                                                                  "41euCm3D3VTQ8X3Y6pJhJL0Awj6H3CEE7Xx1pcXHlgLo0BJFqn3YzgGz2+f6" +
                                                                  "v1qvz10DscMgVoU+wx6gAJmFUCy51BVVv/n5qyuPvV2G4j1oqW7iTA8WGYeW" +
                                                                  "QKgTOwdoW7C+vFPqMVENQ72wByqxUMkE98La+f27N28x4ZGpH7f8cMezs5dE" +
                                                                  "XFqSx81BhpvE2MmHLWI+zl9vZagapwEeQNlC0W5iW9Midguzp2jNQl2L6LjO" +
                                                                  "PzQzmxl4ZpvsLRrDncBeaHRf+PU/30qc+90b85SgSrfr9AXGubxQyZBlyIet" +
                                                                  "D2vP/P4nHSO7b6Ra8Lm269QD/nstnGDzwugfVeW1h/7cevCu3LEbAP61EVtG" +
                                                                  "WX6v7/k37t6knomL1lVifknLG97UFbQqCKUEenSDH5PPLBdZs6Ho/Tru1Vvh" +
                                                                  "6XO93xfNGonQ80YVoGGl5aThtueHEw92VLsIwwhUxNzWgP9eBWXcpCMJDC12" +
                                                                  "jiTSKtET4hbEmzvXNkKfexfBmyN8OMD4lUFzowWCqHOR6x/V8lA+xt0GWjnR" +
                                                                  "+NHYdy6/IAM42m1HiMn0zDc+S5yakcEsryQbSm4FwT3yWiI0redDgqfU+sWk" +
                                                                  "iB09f7xw4qfPnTgZd0+5n6HycVOT15o7+DAkfbDjv4QdPrHbEvP9RWeu4mtb" +
                                                                  "4RlwnTlwA9EhMOcQH3oi4dGyCMcFwiPUOfL8hjbUZhFv3DZ4TJ3uGPyDdN1N" +
                                                                  "82yQdM3PKd869N7oWyJRqzkyFNMjgAqAIIF+xXMW/5cKvENBLdPca3tY4aaw" +
                                                                  "fCl6z6N1PzvdWNYDcNWLqh1DO+6Q3kw4ZatsJx1QyL9K+gnsasN7DYZim6EI" +
                                                                  "iGlrkby4nw+jDNjhiQFLdSEu7QfQ2P8igAoMLQvcELy03vSfXS7AaqtKvlzI" +
                                                                  "27b64mxddcvsPe8JoC/eiGvAgVlH1wPmC5qy0qIkq4nz18h+wRL/HoFL/sIq" +
                                                                  "AazJF6H+w3LLowytmGcL1FTvNUj9TQAgn5qhuBpa/jb0ke4yxA+MwcUzMAWL" +
                                                                  "/PWs5VmwXvQE/HtFQl7OC7HSun+HbKqv48dALd8QgkXxbckLWUd+XYL72Oz+" +
                                                                  "/vuufuEZ2YUDHk9NcS7LIFBlr1+sZusX5ObxqtzXea324pKNHoyFbgFB3UQ0" +
                                                                  "QR6Jhrk10pXaHcXm9IPzO1755XTlOwDAh1EMg48OB77sSEtBa+tAG3E4WZqQ" +
                                                                  "UPlFu9zV+dTkXVuyf/utaKncBF69MH1KHT77fu/FsU93io8ZFRABpDAMNcfe" +
                                                                  "M2kcIOo4DWV3LQ9XzL8yCTu45ltenOXXMYbaSwtH6SUW2s0JQnebjpFx8WGZ" +
                                                                  "PxP6yOU1AI5lRTb4MwGAK0hI4daH+Esl+yzLvcqUNVsiuyejICcmxb7vilc+" +
                                                                  "PPtv0VYesWYWAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALVZC6zjWHn23NmdmR2WndlddtlO2fcAXUKv83CcRAN0HceO" +
           "k9ix87CdpMDg2I7jxK/4bdNtYSUeKhJFZXm0glUrgdqi5aGqqEgV1VZVCwhU" +
           "iQr1JRVQVam0FIlVVVqVtvTYuffm3jszu11VvZLPPTnn/P/5///8/3f+c85z" +
           "P4Bu91yo4NhGohm2v6/G/v7KqO77iaN6+126ykmupyq4IXneGLRdlx/7wqUf" +
           "/fhDy8t70LkZdK9kWbYv+bpteUPVs41QVWjo0q6VMFTT86HL9EoKJTjwdQOm" +
           "dc+/RkOvOEbqQ1fpQxFgIAIMRIBzEWBsNwoQvVK1AhPPKCTL9zbQL0JnaOic" +
           "I2fi+dCjJ5k4kiuZB2y4XAPA4UL2WwBK5cSxCz1ypPtW5xsU/kgBfuZjb7/8" +
           "u2ehSzPokm6NMnFkIIQPJplBd5qqOVddD1MUVZlBd1uqqoxUV5cMPc3lnkH3" +
           "eLpmSX7gqkdGyhoDR3XzOXeWu1POdHMD2bfdI/UWumooh79uXxiSBnS9f6fr" +
           "VkMyawcKXtSBYO5CktVDktvWuqX40MOnKY50vNoDAwDpeVP1l/bRVLdZEmiA" +
           "7tmunSFZGjzyXd3SwNDb7QDM4kNXbsk0s7UjyWtJU6/70AOnx3HbLjDqjtwQ" +
           "GYkP3Xd6WM4JrNKVU6t0bH1+0H/TB99pUdZeLrOiykYm/wVA9NApoqG6UF3V" +
           "ktUt4Z1voD8q3f/l9+9BEBh836nB2zG//wsvPPnGh57/6nbMT99kDDtfqbJ/" +
           "Xf7U/K5vvgZ/onE2E+OCY3t6tvgnNM/dnzvouRY7IPLuP+KYde4fdj4//NPp" +
           "uz6jfn8PutiBzsm2EZjAj+6WbdPRDdVtq5bqSr6qdKA7VEvB8/4OdB7Uad1S" +
           "t63sYuGpfge6zcibztn5b2CiBWCRmeg8qOvWwj6sO5K/zOuxA0HQfeCDroCP" +
           "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" +
           "If3Sq3/vTb/17Lfz68z/AVtyzqcYIQAA");
    }
    private class InvalidMinMaxSubDetector extends edu.umd.cs.findbugs.detect.DumbMethods.SubDetector {
        java.lang.Number lowerBound;
        java.lang.Number upperBound;
        @java.lang.Override
        public void initMethod(org.apache.bcel.classfile.Method method) {
            lowerBound =
              (upperBound =
                 null);
        }
        @java.lang.Override
        public void sawOpcode(int seen) {
            if (seen ==
                  INVOKESTATIC &&
                  getClassConstantOperand(
                    ).
                  equals(
                    "java/lang/Math") &&
                  (getMethodDescriptorOperand(
                     ).
                     getName(
                       ).
                     equals(
                       "max") ||
                     getMethodDescriptorOperand(
                       ).
                     getName(
                       ).
                     equals(
                       "min"))) {
                java.lang.Object const1 =
                  stack.
                  getStackItem(
                    0).
                  getConstant(
                    );
                java.lang.Object const2 =
                  stack.
                  getStackItem(
                    1).
                  getConstant(
                    );
                java.lang.Number n =
                  null;
                if (const1 !=
                      null ^
                      const2 !=
                      null) {
                    n =
                      const1 instanceof java.lang.Number
                        ? (java.lang.Number)
                            const1
                        : (java.lang.Number)
                            const2;
                    if (getMethodDescriptorOperand(
                          ).
                          getName(
                            ).
                          equals(
                            "min")) {
                        upperBound =
                          n;
                    }
                    else {
                        lowerBound =
                          n;
                    }
                }
                else {
                    upperBound =
                      (lowerBound =
                         null);
                }
                edu.umd.cs.findbugs.ba.XMethod rvo1 =
                  stack.
                  getStackItem(
                    0).
                  getReturnValueOf(
                    );
                edu.umd.cs.findbugs.ba.XMethod rvo2 =
                  stack.
                  getStackItem(
                    1).
                  getReturnValueOf(
                    );
                if (rvo1 !=
                      null ^
                      rvo2 !=
                      null) {
                    edu.umd.cs.findbugs.ba.XMethod rvo =
                      rvo1 ==
                      null
                      ? rvo2
                      : rvo1;
                    if (lowerBound instanceof java.lang.Comparable &&
                          upperBound !=
                          null &&
                          upperBound.
                          getClass(
                            ) ==
                          lowerBound.
                          getClass(
                            ) &&
                          rvo.
                          getClassDescriptor(
                            ).
                          getClassName(
                            ).
                          equals(
                            "java/lang/Math") &&
                          (rvo.
                             getName(
                               ).
                             equals(
                               "max") ||
                             rvo.
                             getName(
                               ).
                             equals(
                               "min"))) {
                        int result =
                          ((java.lang.Comparable<java.lang.Number>)
                             lowerBound).
                          compareTo(
                            upperBound);
                        if (result >
                              0) {
                            accumulator.
                              accumulateBug(
                                new edu.umd.cs.findbugs.BugInstance(
                                  "DM_INVALID_MIN_MAX",
                                  HIGH_PRIORITY).
                                  addClassAndMethod(
                                    DumbMethods.this).
                                  addString(
                                    java.lang.String.
                                      valueOf(
                                        n)),
                                DumbMethods.this);
                        }
                    }
                }
            }
        }
        public InvalidMinMaxSubDetector() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "3/Tp576dny7/Dw2trmbuIwAA");
    }
    private class NullMethodsSubDetector extends edu.umd.cs.findbugs.detect.DumbMethods.SubDetector {
        @java.lang.Override
        public void sawOpcode(int seen) {
            if (seen ==
                  INVOKESTATIC &&
                  ("com/google/common/base/Preconditions".
                     equals(
                       getClassConstantOperand(
                         )) &&
                     "checkNotNull".
                     equals(
                       getNameConstantOperand(
                         )) ||
                     "com/google/common/base/Strings".
                     equals(
                       getClassConstantOperand(
                         )) &&
                     ("nullToEmpty".
                        equals(
                          getNameConstantOperand(
                            )) ||
                        "emptyToNull".
                        equals(
                          getNameConstantOperand(
                            )) ||
                        "isNullOrEmpty".
                        equals(
                          getNameConstantOperand(
                            ))))) {
                int args =
                  edu.umd.cs.findbugs.visitclass.PreorderVisitor.
                  getNumberArguments(
                    getSigConstantOperand(
                      ));
                edu.umd.cs.findbugs.OpcodeStack.Item item =
                  stack.
                  getStackItem(
                    args -
                      1);
                java.lang.Object o =
                  item.
                  getConstant(
                    );
                if (o instanceof java.lang.String) {
                    edu.umd.cs.findbugs.OpcodeStack.Item secondArgument =
                      null;
                    java.lang.String bugPattern =
                      "DMI_DOH";
                    if (args >
                          1) {
                        secondArgument =
                          stack.
                            getStackItem(
                              args -
                                2);
                        java.lang.Object secondConstant =
                          secondArgument.
                          getConstant(
                            );
                        if (!(secondConstant instanceof java.lang.String)) {
                            bugPattern =
                              "DMI_ARGUMENTS_WRONG_ORDER";
                        }
                    }
                    edu.umd.cs.findbugs.BugInstance bug =
                      new edu.umd.cs.findbugs.BugInstance(
                      DumbMethods.this,
                      bugPattern,
                      NORMAL_PRIORITY).
                      addClassAndMethod(
                        DumbMethods.this).
                      addCalledMethod(
                        DumbMethods.this).
                      addString(
                        "Passing String constant as value that should be null checked").
                      describe(
                        edu.umd.cs.findbugs.StringAnnotation.
                          STRING_MESSAGE).
                      addString(
                        (java.lang.String)
                          o).
                      describe(
                        edu.umd.cs.findbugs.StringAnnotation.
                          STRING_CONSTANT_ROLE);
                    if (secondArgument !=
                          null) {
                        bug.
                          addValueSource(
                            secondArgument,
                            DumbMethods.this);
                    }
                    accumulator.
                      accumulateBug(
                        bug,
                        DumbMethods.this);
                }
            }
            if (seen ==
                  INVOKESTATIC &&
                  ("junit/framework/Assert".
                     equals(
                       getClassConstantOperand(
                         )) ||
                     "org/junit/Assert".
                     equals(
                       getClassConstantOperand(
                         ))) &&
                  "assertNotNull".
                  equals(
                    getNameConstantOperand(
                      ))) {
                int args =
                  edu.umd.cs.findbugs.visitclass.PreorderVisitor.
                  getNumberArguments(
                    getSigConstantOperand(
                      ));
                edu.umd.cs.findbugs.OpcodeStack.Item item =
                  stack.
                  getStackItem(
                    0);
                java.lang.Object o =
                  item.
                  getConstant(
                    );
                if (o instanceof java.lang.String) {
                    edu.umd.cs.findbugs.OpcodeStack.Item secondArgument =
                      null;
                    java.lang.String bugPattern =
                      "DMI_DOH";
                    if (args ==
                          2) {
                        secondArgument =
                          stack.
                            getStackItem(
                              1);
                        java.lang.Object secondConstant =
                          secondArgument.
                          getConstant(
                            );
                        if (!(secondConstant instanceof java.lang.String)) {
                            bugPattern =
                              "DMI_ARGUMENTS_WRONG_ORDER";
                        }
                    }
                    edu.umd.cs.findbugs.BugInstance bug =
                      new edu.umd.cs.findbugs.BugInstance(
                      DumbMethods.this,
                      bugPattern,
                      NORMAL_PRIORITY).
                      addClassAndMethod(
                        DumbMethods.this).
                      addCalledMethod(
                        DumbMethods.this).
                      addString(
                        "Passing String constant as value that should be null checked").
                      describe(
                        edu.umd.cs.findbugs.StringAnnotation.
                          STRING_MESSAGE).
                      addString(
                        (java.lang.String)
                          o).
                      describe(
                        edu.umd.cs.findbugs.StringAnnotation.
                          STRING_CONSTANT_ROLE);
                    if (secondArgument !=
                          null) {
                        bug.
                          addValueSource(
                            secondArgument,
                            DumbMethods.this);
                    }
                    accumulator.
                      accumulateBug(
                        bug,
                        DumbMethods.this);
                }
            }
        }
        public NullMethodsSubDetector() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private class FutilePoolSizeSubDetector extends edu.umd.cs.findbugs.detect.DumbMethods.SubDetector {
        @java.lang.Override
        public void sawOpcode(int seen) {
            if (seen ==
                  INVOKEVIRTUAL &&
                  "java/util/concurrent/ScheduledThreadPoolExecutor".
                  equals(
                    getClassConstantOperand(
                      )) &&
                  "setMaximumPoolSize".
                  equals(
                    getNameConstantOperand(
                      ))) {
                accumulator.
                  accumulateBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      DumbMethods.this,
                      ("DMI_FUTILE_ATTEMPT_TO_CHANGE_MAXPOOL_SIZE_OF_SCHEDULED_THREA" +
                       "D_POOL_EXECUTOR"),
                      HIGH_PRIORITY).
                      addClassAndMethod(
                        DumbMethods.this),
                    DumbMethods.this);
            }
        }
        public FutilePoolSizeSubDetector() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "hDzK3OEIPoE/h1/82EONd30nxz909wz7keT2AA3ytkNc9FPWv+08cc+f7UDn" +
           "5tAVeS8pnIhmlDnRHCRCwX6mCBLHY/PHk5rtCX7jIJy96WSoObLsyUBzeDCA" +
           "fgad9S8ebvj15BRwxLPoLrZbzL6fyhEfz9trWfPWrdaz7k8Djw3y5BJggHNF" +
           "NHM610NgMaZ8bd9HJyDZBCq+tjSxnMzrQXqdW0cmzO42Q9vGqqwtbbnI+9W7" +
           "WsONfV7B7t97SIxyQLL3oX/48Fd/9clvgi3qQWfjTH1gZ46sOIiy/PeXX3z+" +
           "4dfc+taH8gAEog93XfrXpzKq/VeTOGuaWdPaF/WhTFTOiXxZpcQgpPM4oSq5" +
           "tK9qmaxvWCC0xnvJHfz01W+uPvbtT28Tt5NmeAJYffbWr/xw97lbO0fS5Sdv" +
           "y1iP4mxT5pzp1+5p2Icef7VVcoz2P3726T/6naef2XJ19Xjy1wJ3m0//5X9/" +
           "dfej3/ryHbKOM6bzf9jY8JLSLQdkff+PmsxUdC0nI0tjsJoSJzRmzCwl6bY5" +
           "RuRKix4pzHuypVipgXcSDRs1kGY0rIVpaEvYphThlhLKOMMPV55hRu54OOwM" +
           "zWltghAuwXGeEXoeIZkN3SCc3qjuFUl36M0FkfVIbjIj4aI7L9DYoFTAjLQx" +
           "BZ+9kmTBtqXW4LhQENV4JvWleoS0KqVOtZf0sLYB8wt2Fjg256JdidV7KadZ" +
           "vVa8icuI2sXKnlGz2+NBeRqSI1uat+qmZfVZJ51Pwo0tzAWSbVX76+7QolCa" +
           "E9eTIYJ3u2N/4DU7kwE/n4+ZztBdEC01aY/VgdXuUTxvjZuUQ/c7HqVvZhxS" +
           "HFZbbSxaerSI8k2bZXsDNiYLpbW3TLvGRiIdsWxo62ZvJnuWy02piavg80ZY" +
           "8TqDpep2+FEnWI7QYRjbUUSstXaBaKROhEzxYhlPxvWSRqhe6hPR1EJFtjXw" +
           "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");
    }
    static int saturatingIncrement(int value) {
        if (value ==
              java.lang.Integer.
                MAX_VALUE) {
            return java.lang.Integer.
                     MAX_VALUE;
        }
        return value +
          1;
    }
    private class RangeCheckSubDetector extends edu.umd.cs.findbugs.detect.DumbMethods.SubDetector {
        private void checkRange(edu.umd.cs.findbugs.OpcodeStack.Item item,
                                java.lang.Object minValue,
                                java.lang.Object maxValue,
                                java.lang.String pattern) {
            if (!(item.
                    getConstant(
                      ) instanceof java.lang.Number)) {
                return;
            }
            int value =
              ((java.lang.Number)
                 item.
                 getConstant(
                   )).
              intValue(
                );
            int intMin =
              java.lang.Integer.
                MIN_VALUE;
            int intMax =
              java.lang.Integer.
                MAX_VALUE;
            if (minValue instanceof java.lang.Number) {
                intMin =
                  ((java.lang.Number)
                     minValue).
                    intValue(
                      );
            }
            if (maxValue instanceof java.lang.Number) {
                intMax =
                  ((java.lang.Number)
                     maxValue).
                    intValue(
                      );
            }
            else
                if (maxValue instanceof java.lang.String) {
                    intMax =
                      ((java.lang.String)
                         maxValue).
                        length(
                          ) -
                        1;
                }
                else
                    if (maxValue instanceof edu.umd.cs.findbugs.OpcodeStack.Item) {
                        edu.umd.cs.findbugs.OpcodeStack.Item maxItem =
                          (edu.umd.cs.findbugs.OpcodeStack.Item)
                            maxValue;
                        if (maxItem.
                              getSignature(
                                ).
                              charAt(
                                0) ==
                              '[' &&
                              maxItem.
                              getConstant(
                                ) instanceof java.lang.Integer) {
                            intMax =
                              (java.lang.Integer)
                                maxItem.
                                getConstant(
                                  ) -
                                1;
                        }
                    }
            if (value <
                  intMin ||
                  value >
                  intMax) {
                edu.umd.cs.findbugs.BugInstance bug =
                  new edu.umd.cs.findbugs.BugInstance(
                  pattern,
                  NORMAL_PRIORITY).
                  addClassAndMethod(
                    DumbMethods.this).
                  addSourceLine(
                    DumbMethods.this).
                  addInt(
                    value).
                  describe(
                    edu.umd.cs.findbugs.IntAnnotation.
                      INT_VALUE);
                if (intMin <=
                      intMax) {
                    if (value <
                          intMin) {
                        bug.
                          addInt(
                            intMin).
                          describe(
                            edu.umd.cs.findbugs.IntAnnotation.
                              INT_MIN_VALUE);
                    }
                    if (value >
                          intMax) {
                        bug.
                          addInt(
                            intMax).
                          describe(
                            edu.umd.cs.findbugs.IntAnnotation.
                              INT_MAX_VALUE);
                    }
                }
                if (isMethodCall(
                      )) {
                    bug.
                      addCalledMethod(
                        DumbMethods.this);
                }
                accumulator.
                  accumulateBug(
                    bug,
                    DumbMethods.this);
            }
        }
        @java.lang.Override
        public void sawOpcode(int seen) {
            switch (seen) {
                case IALOAD:
                case AALOAD:
                case SALOAD:
                case CALOAD:
                case BALOAD:
                case LALOAD:
                case DALOAD:
                case FALOAD:
                    {
                        checkRange(
                          stack.
                            getStackItem(
                              0),
                          0,
                          stack.
                            getStackItem(
                              1),
                          "RANGE_ARRAY_INDEX");
                        break;
                    }
                case IASTORE:
                case AASTORE:
                case SASTORE:
                case CASTORE:
                case BASTORE:
                case LASTORE:
                case DASTORE:
                case FASTORE:
                    {
                        checkRange(
                          stack.
                            getStackItem(
                              1),
                          0,
                          stack.
                            getStackItem(
                              2),
                          "RANGE_ARRAY_INDEX");
                        break;
                    }
                case INVOKESTATIC:
                    {
                        edu.umd.cs.findbugs.classfile.MethodDescriptor m =
                          getMethodDescriptorOperand(
                            );
                        if (m.
                              getSlashedClassName(
                                ).
                              equals(
                                "java/lang/System") &&
                              m.
                              getName(
                                ).
                              equals(
                                "arraycopy")) {
                            edu.umd.cs.findbugs.OpcodeStack.Item length =
                              stack.
                              getStackItem(
                                0);
                            java.lang.Object constantLength =
                              length.
                              getConstant(
                                );
                            edu.umd.cs.findbugs.OpcodeStack.Item srcPos =
                              stack.
                              getStackItem(
                                3);
                            edu.umd.cs.findbugs.OpcodeStack.Item src =
                              stack.
                              getStackItem(
                                4);
                            checkRange(
                              srcPos,
                              0,
                              src,
                              "RANGE_ARRAY_OFFSET");
                            edu.umd.cs.findbugs.OpcodeStack.Item dest =
                              stack.
                              getStackItem(
                                2);
                            edu.umd.cs.findbugs.OpcodeStack.Item destPos =
                              stack.
                              getStackItem(
                                1);
                            checkRange(
                              destPos,
                              0,
                              dest,
                              "RANGE_ARRAY_OFFSET");
                            if (constantLength instanceof java.lang.Number) {
                                int length1 =
                                  java.lang.Integer.
                                    MAX_VALUE;
                                if (src.
                                      getConstant(
                                        ) instanceof java.lang.Integer) {
                                    length1 =
                                      (java.lang.Integer)
                                        src.
                                        getConstant(
                                          );
                                }
                                if (srcPos.
                                      getConstant(
                                        ) instanceof java.lang.Integer) {
                                    length1 -=
                                      (java.lang.Integer)
                                        srcPos.
                                        getConstant(
                                          );
                                }
                                int length2 =
                                  java.lang.Integer.
                                    MAX_VALUE;
                                if (dest.
                                      getConstant(
                                        ) instanceof java.lang.Integer) {
                                    length2 =
                                      (java.lang.Integer)
                                        stack.
                                        getStackItem(
                                          2).
                                        getConstant(
                                          );
                                }
                                if (destPos.
                                      getConstant(
                                        ) instanceof java.lang.Integer) {
                                    length2 -=
                                      (java.lang.Integer)
                                        stack.
                                        getStackItem(
                                          1).
                                        getConstant(
                                          );
                                }
                                checkRange(
                                  length,
                                  0,
                                  java.lang.Math.
                                    min(
                                      length1,
                                      length2),
                                  "RANGE_ARRAY_LENGTH");
                            }
                        }
                        break;
                    }
                case INVOKEVIRTUAL:
                case INVOKESPECIAL:
                    {
                        edu.umd.cs.findbugs.classfile.MethodDescriptor m =
                          getMethodDescriptorOperand(
                            );
                        if (m.
                              getSlashedClassName(
                                ).
                              equals(
                                "java/lang/String")) {
                            if ((m.
                                   getName(
                                     ).
                                   equals(
                                     "charAt") ||
                                   m.
                                   getName(
                                     ).
                                   equals(
                                     "codePointAt")) &&
                                  m.
                                  getSignature(
                                    ).
                                  startsWith(
                                    "(I)")) {
                                checkRange(
                                  stack.
                                    getStackItem(
                                      0),
                                  0,
                                  stack.
                                    getStackItem(
                                      1).
                                    getConstant(
                                      ),
                                  "RANGE_STRING_INDEX");
                            }
                            if (m.
                                  getName(
                                    ).
                                  equals(
                                    "substring") ||
                                  m.
                                  getName(
                                    ).
                                  equals(
                                    "subSequence")) {
                                int nArgs =
                                  getNumberArguments(
                                    m.
                                      getSignature(
                                        ));
                                edu.umd.cs.findbugs.OpcodeStack.Item thisArg =
                                  stack.
                                  getStackItem(
                                    nArgs);
                                edu.umd.cs.findbugs.OpcodeStack.Item firstArg =
                                  stack.
                                  getStackItem(
                                    nArgs -
                                      1);
                                java.lang.Object thisConstantValue =
                                  thisArg.
                                  getConstant(
                                    );
                                int maxLength =
                                  thisConstantValue instanceof java.lang.String
                                  ? ((java.lang.String)
                                       thisConstantValue).
                                  length(
                                    )
                                  : java.lang.Integer.
                                      MAX_VALUE;
                                checkRange(
                                  firstArg,
                                  0,
                                  maxLength,
                                  "RANGE_STRING_INDEX");
                                if (nArgs ==
                                      2) {
                                    edu.umd.cs.findbugs.OpcodeStack.Item secondArg =
                                      stack.
                                      getStackItem(
                                        0);
                                    checkRange(
                                      secondArg,
                                      firstArg.
                                        getConstant(
                                          ) ==
                                        null
                                        ? 0
                                        : firstArg.
                                        getConstant(
                                          ),
                                      maxLength,
                                      "RANGE_STRING_INDEX");
                                }
                            }
                        }
                        if ((m.
                               getSignature(
                                 ).
                               startsWith(
                                 "([BII)") ||
                               m.
                               getSignature(
                                 ).
                               startsWith(
                                 "([CII)") ||
                               m.
                               getSignature(
                                 ).
                               startsWith(
                                 "([III)")) &&
                              ((m.
                                  getName(
                                    ).
                                  equals(
                                    "write") ||
                                  m.
                                  getName(
                                    ).
                                  equals(
                                    "read")) &&
                                 m.
                                 getSlashedClassName(
                                   ).
                                 startsWith(
                                   "java/io/") ||
                                 m.
                                 getName(
                                   ).
                                 equals(
                                   "<init>") &&
                                 m.
                                 getSlashedClassName(
                                   ).
                                 equals(
                                   "java/lang/String"))) {
                            edu.umd.cs.findbugs.OpcodeStack.Item arrayArg =
                              stack.
                              getStackItem(
                                2);
                            edu.umd.cs.findbugs.OpcodeStack.Item offsetArg =
                              stack.
                              getStackItem(
                                1);
                            edu.umd.cs.findbugs.OpcodeStack.Item lengthArg =
                              stack.
                              getStackItem(
                                0);
                            int length =
                              java.lang.Integer.
                                MAX_VALUE;
                            if (arrayArg.
                                  getConstant(
                                    ) instanceof java.lang.Integer) {
                                length =
                                  (java.lang.Integer)
                                    arrayArg.
                                    getConstant(
                                      );
                            }
                            if (offsetArg.
                                  getConstant(
                                    ) instanceof java.lang.Integer) {
                                checkRange(
                                  offsetArg,
                                  0,
                                  saturatingIncrement(
                                    length),
                                  "RANGE_ARRAY_OFFSET");
                                length -=
                                  (java.lang.Integer)
                                    offsetArg.
                                    getConstant(
                                      );
                            }
                            checkRange(
                              lengthArg,
                              0,
                              saturatingIncrement(
                                length),
                              "RANGE_ARRAY_LENGTH");
                        }
                        break;
                    }
                default:
                    break;
            }
        }
        public RangeCheckSubDetector() { super(
                                           );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "zrbbDZPPe1hWKPbnTZzmLMHChfm8xxf6NMBpvUY5FZ5FcU4dWTm8j9tkxSTY" +
           "bm+RYf32kK2365Y4M1oaFclSd9mVZmil1yeza4LIhNnFWMfz9lBXc5EjB8tg" +
           "xjTHJsmrI7fB04GzWFcyszpFze1yxMByRuu6mJF4y4rVrpqVOJ726uOV47Ir" +
           "W4bugVfrmZDLgrGsLadRuxNjfb8yKda8jMEOy1lX7oRSNV7kJniGDaNumJmX" +
           "MJdt18rZEFR1bTU3WuPqkpOCUeC0MiPZGqsZuabYC9pYled1bzLqzbsNlO/X" +
           "J26DmvWCcN6vAm+Iz7WauchX7CrfqLQrdR4AYtgy/OEg4vJzYzDt12ZW3xsM" +
           "cCpjVAJKFOrWeDZgpJBeybxA1LkqlxlmySjE3ADr5TWryVJ2LWObRFVknbZY" +
           "sQx2TPfjMht5k/oQNUyJkJyIrbXKKyqiOg0VJVYjN7ue5SYTtYp3I2E+nq1I" +
           "jeoL/BRdZjPoLDtSSDIzGtJ4ES9VRoXVuhdPjHFVXLoczw9rbWERtWp+y83V" +
           "KYLFghWmNgsUFo3qJOVP2mow5Wm6JMza3bmjOlFJ44vesKwP5hakcQcRKQ+F" +
           "So2wM9D6XYMMZlFXKNsjIRc7maCKhXyvMGXqzKiMcY6dX68a0hBfRxgEOtri" +
           "xby1EPOT5VALc4QN9Gq7EfLatG+6jlGgewWxsjbIzryqzrxGBsTLWjib4a1x" +
           "ifbHoK32on5TmjvtVneFWkvaElvdLGtNPIvWiq02k8FIgtKCuDYozhbMsIrG" +
           "xsIRCuVMAJ2AHs0aptnNknWy1FbYMUUFY8op+G3WqgPe6OmFoW9T0qoNenoZ" +
           "owdhoRzbFMkVGAgupWDoRt5Y88Z5oj1iGmg9Q3SXy1kVK4tZLhfTbCnKo76T" +
           "b4VMEbghoBi5nrWq3KRQY5sqWE7RDJnHA0yMdV/RnKrTzbp1pinEkeN2ZGNO" +
           "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");
    }
    private class UrlCollectionSubDetector extends edu.umd.cs.findbugs.detect.DumbMethods.SubDetector {
        @java.lang.Override
        public void sawOpcode(int seen) {
            if (seen ==
                  INVOKEVIRTUAL &&
                  "java/util/HashMap".
                  equals(
                    getClassConstantOperand(
                      )) &&
                  "get".
                  equals(
                    getNameConstantOperand(
                      )) ||
                  seen ==
                  INVOKEINTERFACE &&
                  "java/util/Map".
                  equals(
                    getClassConstantOperand(
                      )) &&
                  "get".
                  equals(
                    getNameConstantOperand(
                      )) ||
                  seen ==
                  INVOKEVIRTUAL &&
                  "java/util/HashSet".
                  equals(
                    getClassConstantOperand(
                      )) &&
                  "contains".
                  equals(
                    getNameConstantOperand(
                      )) ||
                  seen ==
                  INVOKEINTERFACE &&
                  "java/util/Set".
                  equals(
                    getClassConstantOperand(
                      )) &&
                  "contains".
                  equals(
                    getNameConstantOperand(
                      ))) {
                edu.umd.cs.findbugs.OpcodeStack.Item top =
                  stack.
                  getStackItem(
                    0);
                if ("Ljava/net/URL;".
                      equals(
                        top.
                          getSignature(
                            ))) {
                    accumulator.
                      accumulateBug(
                        new edu.umd.cs.findbugs.BugInstance(
                          DumbMethods.this,
                          "DMI_COLLECTION_OF_URLS",
                          HIGH_PRIORITY).
                          addClassAndMethod(
                            DumbMethods.this),
                        DumbMethods.this);
                }
            }
        }
        public UrlCollectionSubDetector() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private class VacuousComparisonSubDetector extends edu.umd.cs.findbugs.detect.DumbMethods.SubDetector {
        @java.lang.Override
        public void sawOpcode(int seen) {
            boolean foundVacuousComparison =
              false;
            if (seen ==
                  IF_ICMPGT ||
                  seen ==
                  IF_ICMPLE) {
                edu.umd.cs.findbugs.OpcodeStack.Item rhs =
                  stack.
                  getStackItem(
                    0);
                java.lang.Object rhsConstant =
                  rhs.
                  getConstant(
                    );
                if (rhsConstant instanceof java.lang.Integer &&
                      ((java.lang.Integer)
                         rhsConstant).
                      intValue(
                        ) ==
                      java.lang.Integer.
                        MAX_VALUE) {
                    foundVacuousComparison =
                      true;
                }
                edu.umd.cs.findbugs.OpcodeStack.Item lhs =
                  stack.
                  getStackItem(
                    1);
                java.lang.Object lhsConstant =
                  lhs.
                  getConstant(
                    );
                if (lhsConstant instanceof java.lang.Integer &&
                      ((java.lang.Integer)
                         lhsConstant).
                      intValue(
                        ) ==
                      java.lang.Integer.
                        MIN_VALUE) {
                    foundVacuousComparison =
                      true;
                }
            }
            if (seen ==
                  IF_ICMPLT ||
                  seen ==
                  IF_ICMPGE) {
                edu.umd.cs.findbugs.OpcodeStack.Item rhs =
                  stack.
                  getStackItem(
                    0);
                java.lang.Object rhsConstant =
                  rhs.
                  getConstant(
                    );
                if (rhsConstant instanceof java.lang.Integer &&
                      ((java.lang.Integer)
                         rhsConstant).
                      intValue(
                        ) ==
                      java.lang.Integer.
                        MIN_VALUE) {
                    foundVacuousComparison =
                      true;
                }
                edu.umd.cs.findbugs.OpcodeStack.Item lhs =
                  stack.
                  getStackItem(
                    1);
                java.lang.Object lhsConstant =
                  lhs.
                  getConstant(
                    );
                if (lhsConstant instanceof java.lang.Integer &&
                      ((java.lang.Integer)
                         lhsConstant).
                      intValue(
                        ) ==
                      java.lang.Integer.
                        MAX_VALUE) {
                    foundVacuousComparison =
                      true;
                }
            }
            if (foundVacuousComparison) {
                accumulator.
                  accumulateBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      DumbMethods.this,
                      "INT_VACUOUS_COMPARISON",
                      getBranchOffset(
                        ) <
                        0
                        ? HIGH_PRIORITY
                        : NORMAL_PRIORITY).
                      addClassAndMethod(
                        DumbMethods.this),
                    DumbMethods.this);
            }
        }
        public VacuousComparisonSubDetector() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private class BadCastInEqualsSubDetector extends edu.umd.cs.findbugs.detect.DumbMethods.SubDetector {
        private boolean isEqualsObject;
        private boolean sawInstanceofCheck;
        private boolean reportedBadCastInEquals;
        @java.lang.Override
        public void initMethod(org.apache.bcel.classfile.Method method) {
            isEqualsObject =
              "equals".
                equals(
                  getMethodName(
                    )) &&
                "(Ljava/lang/Object;)Z".
                equals(
                  getMethodSig(
                    )) &&
                !method.
                isStatic(
                  );
            sawInstanceofCheck =
              false;
            reportedBadCastInEquals =
              false;
        }
        @java.lang.Override
        public void sawOpcode(int seen) {
            if (isEqualsObject &&
                  !reportedBadCastInEquals) {
                if (seen ==
                      INVOKEVIRTUAL &&
                      "isInstance".
                      equals(
                        getNameConstantOperand(
                          )) &&
                      "java/lang/Class".
                      equals(
                        getClassConstantOperand(
                          ))) {
                    edu.umd.cs.findbugs.OpcodeStack.Item item =
                      stack.
                      getStackItem(
                        0);
                    if (item.
                          getRegisterNumber(
                            ) ==
                          1) {
                        sawInstanceofCheck =
                          true;
                    }
                }
                else
                    if (seen ==
                          INSTANCEOF ||
                          seen ==
                          INVOKEVIRTUAL &&
                          "getClass".
                          equals(
                            getNameConstantOperand(
                              )) &&
                          "()Ljava/lang/Class;".
                          equals(
                            getSigConstantOperand(
                              ))) {
                        edu.umd.cs.findbugs.OpcodeStack.Item item =
                          stack.
                          getStackItem(
                            0);
                        if (item.
                              getRegisterNumber(
                                ) ==
                              1) {
                            sawInstanceofCheck =
                              true;
                        }
                    }
                    else
                        if (seen ==
                              INVOKESPECIAL &&
                              "equals".
                              equals(
                                getNameConstantOperand(
                                  )) &&
                              "(Ljava/lang/Object;)Z".
                              equals(
                                getSigConstantOperand(
                                  ))) {
                            edu.umd.cs.findbugs.OpcodeStack.Item item0 =
                              stack.
                              getStackItem(
                                0);
                            edu.umd.cs.findbugs.OpcodeStack.Item item1 =
                              stack.
                              getStackItem(
                                1);
                            if (item1.
                                  getRegisterNumber(
                                    ) +
                                  item0.
                                  getRegisterNumber(
                                    ) ==
                                  1) {
                                sawInstanceofCheck =
                                  true;
                            }
                        }
                        else
                            if (seen ==
                                  CHECKCAST &&
                                  !sawInstanceofCheck) {
                                edu.umd.cs.findbugs.OpcodeStack.Item item =
                                  stack.
                                  getStackItem(
                                    0);
                                if (item.
                                      getRegisterNumber(
                                        ) ==
                                      1) {
                                    if (getSizeOfSurroundingTryBlock(
                                          getPC(
                                            )) ==
                                          java.lang.Integer.
                                            MAX_VALUE) {
                                        accumulator.
                                          accumulateBug(
                                            new edu.umd.cs.findbugs.BugInstance(
                                              DumbMethods.this,
                                              "BC_EQUALS_METHOD_SHOULD_WORK_FOR_ALL_OBJECTS",
                                              NORMAL_PRIORITY).
                                              addClassAndMethod(
                                                DumbMethods.this),
                                            DumbMethods.this);
                                    }
                                    reportedBadCastInEquals =
                                      true;
                                }
                            }
            }
        }
        public BadCastInEqualsSubDetector() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "yLef2nvQ2kvoPOB4i13JlRRd25UVzdzNn/KzF8o9lXMmv3qdpP2TWfF4kL17" +
           "GwF7+IB9Mn8SOYZ66HhPHHe8Ww8c70CyC4eJn36keZ6hatfx1Stz6nnDLx63" +
           "Z5YCfn7Pns//39vzhMo3GHaQ0/zWdcz38az4zQC62Zfivgv2hdwb3n9oqY9c" +
           "01JZ84delk2SALrn2o+i+5Z/3Ut7XgUxePcVv93Y/t5Aefbpc2fvepr/y/wV" +
           "8eA3ATd3obPz0DSPpuyP1E+7njY3cqvcvE3gu/m/54DU1xYJ4MO2kov/7Jbk" +
           "MwF0x1VIAjD/XvXo6M8B7z0cHUA7yrHuLwTQmb1usKigPNr5RdAEOrPqH7j7" +
           "Fiy9xAfqI8ZPTh3HyYP1v/DjkoxHoPXhY5iY//5mH7/C7S9wLivPPd3uvfPF" +
           "6se3D6Ug3NM043K2C53ZvtkeYOCD1+S2z+t065Ef3vapm1+7D9a3bQU+jKQj" +
           "st1/9ZdIynKD/O0w/cJdv/fm3376m3le938AYIkBjRglAAA=");
    }
    private class RandomOnceSubDetector extends edu.umd.cs.findbugs.detect.DumbMethods.SubDetector {
        private boolean freshRandomOnTos =
          false;
        private boolean freshRandomOneBelowTos =
          false;
        @java.lang.Override
        public void initMethod(org.apache.bcel.classfile.Method method) {
            freshRandomOnTos =
              false;
        }
        @java.lang.Override
        public void sawOpcode(int seen) {
            if (seen ==
                  INVOKEVIRTUAL &&
                  "java/util/Random".
                  equals(
                    getClassConstantOperand(
                      )) &&
                  (freshRandomOnTos ||
                     freshRandomOneBelowTos)) {
                accumulator.
                  accumulateBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      DumbMethods.this,
                      "DMI_RANDOM_USED_ONLY_ONCE",
                      HIGH_PRIORITY).
                      addClassAndMethod(
                        DumbMethods.this).
                      addCalledMethod(
                        DumbMethods.this),
                    DumbMethods.this);
            }
            freshRandomOneBelowTos =
              freshRandomOnTos &&
                isRegisterLoad(
                  );
            freshRandomOnTos =
              seen ==
                INVOKESPECIAL &&
                "java/util/Random".
                equals(
                  getClassConstantOperand(
                    )) &&
                "<init>".
                equals(
                  getNameConstantOperand(
                    ));
        }
        public RandomOnceSubDetector() { super(
                                           );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private final edu.umd.cs.findbugs.detect.DumbMethods.SubDetector[]
      subDetectors =
      new edu.umd.cs.findbugs.detect.DumbMethods.SubDetector[] { new edu.umd.cs.findbugs.detect.DumbMethods.VacuousComparisonSubDetector(
      ),
    new edu.umd.cs.findbugs.detect.DumbMethods.RangeCheckSubDetector(
      ),
    new edu.umd.cs.findbugs.detect.DumbMethods.BadCastInEqualsSubDetector(
      ),
    new edu.umd.cs.findbugs.detect.DumbMethods.FutilePoolSizeSubDetector(
      ),
    new edu.umd.cs.findbugs.detect.DumbMethods.UrlCollectionSubDetector(
      ),
    new edu.umd.cs.findbugs.detect.DumbMethods.RandomOnceSubDetector(
      ),
    new edu.umd.cs.findbugs.detect.DumbMethods.NullMethodsSubDetector(
      ),
    new edu.umd.cs.findbugs.detect.DumbMethods.InvalidMinMaxSubDetector(
      ) };
    private static final org.apache.bcel.generic.ObjectType
      CONDITION_TYPE =
      edu.umd.cs.findbugs.ba.ObjectTypeFactory.
      getInstance(
        "java.util.concurrent.locks.Condition");
    private final edu.umd.cs.findbugs.BugReporter
      bugReporter;
    private boolean sawCurrentTimeMillis;
    private edu.umd.cs.findbugs.BugInstance
      gcInvocationBugReport;
    private int gcInvocationPC;
    private org.apache.bcel.classfile.CodeException[]
      exceptionTable;
    private java.lang.String primitiveObjCtorSeen;
    private boolean ctorSeen;
    private boolean prevOpcodeWasReadLine;
    private int prevOpcode;
    private boolean isPublicStaticVoidMain;
    private int sawCheckForNonNegativeSignedByte;
    private int sinceBufferedInputStreamReady;
    private int randomNextIntState;
    private boolean checkForBitIorofSignedByte;
    private static final int OOM_CATCH_LEN =
      20;
    private final boolean testingEnabled;
    private final edu.umd.cs.findbugs.BugAccumulator
      accumulator;
    private final edu.umd.cs.findbugs.BugAccumulator
      absoluteValueAccumulator;
    private static final int MICROS_PER_DAY_OVERFLOWED_AS_INT =
      24 *
      60 *
      60 *
      1000 *
      1000;
    public DumbMethods(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        accumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
        absoluteValueAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
        testingEnabled =
          edu.umd.cs.findbugs.SystemProperties.
            getBoolean(
              "report_TESTING_pattern_in_standard_detectors");
    }
    boolean isSynthetic;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.JavaClass obj) {
        java.lang.String superclassName =
          obj.
          getSuperclassName(
            );
        isSynthetic =
          "java.rmi.server.RemoteStub".
            equals(
              superclassName);
        org.apache.bcel.classfile.Attribute[] attributes =
          obj.
          getAttributes(
            );
        if (attributes !=
              null) {
            for (org.apache.bcel.classfile.Attribute a
                  :
                  attributes) {
                if (a instanceof org.apache.bcel.classfile.Synthetic) {
                    isSynthetic =
                      true;
                }
            }
        }
    }
    @java.lang.Override
    public void visitAfter(org.apache.bcel.classfile.JavaClass obj) {
        accumulator.
          reportAccumulatedBugs(
            );
    }
    public static boolean isTestMethod(org.apache.bcel.classfile.Method method) {
        return method.
          getName(
            ).
          startsWith(
            "test");
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Field field) {
        org.apache.bcel.classfile.ConstantValue value =
          field.
          getConstantValue(
            );
        if (value ==
              null) {
            return;
        }
        org.apache.bcel.classfile.Constant c =
          getConstantPool(
            ).
          getConstant(
            value.
              getConstantValueIndex(
                ));
        if (testingEnabled &&
              c instanceof org.apache.bcel.classfile.ConstantLong &&
              ((org.apache.bcel.classfile.ConstantLong)
                 c).
              getBytes(
                ) ==
              MICROS_PER_DAY_OVERFLOWED_AS_INT) {
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "TESTING",
                  HIGH_PRIORITY).
                  addClass(
                    this).
                  addField(
                    this).
                  addString(
                    "Did you mean MICROS_PER_DAY").
                  addInt(
                    MICROS_PER_DAY_OVERFLOWED_AS_INT).
                  describe(
                    edu.umd.cs.findbugs.IntAnnotation.
                      INT_VALUE));
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method method) {
        java.lang.String cName =
          getDottedClassName(
            );
        for (edu.umd.cs.findbugs.detect.DumbMethods.SubDetector subDetector
              :
              subDetectors) {
            subDetector.
              initMethod(
                method);
        }
        isPublicStaticVoidMain =
          method.
            isPublic(
              ) &&
            method.
            isStatic(
              ) &&
            "main".
            equals(
              getMethodName(
                )) ||
            cName.
            toLowerCase(
              ).
            indexOf(
              "benchmark") >=
            0;
        prevOpcodeWasReadLine =
          false;
        org.apache.bcel.classfile.Code code =
          method.
          getCode(
            );
        if (code !=
              null) {
            this.
              exceptionTable =
              code.
                getExceptionTable(
                  );
        }
        if (this.
              exceptionTable ==
              null) {
            this.
              exceptionTable =
              (new org.apache.bcel.classfile.CodeException[0]);
        }
        primitiveObjCtorSeen =
          null;
        ctorSeen =
          false;
        randomNextIntState =
          0;
        checkForBitIorofSignedByte =
          false;
        sinceBufferedInputStreamReady =
          100000;
        sawCheckForNonNegativeSignedByte =
          -1000;
        sawLoadOfMinValue =
          false;
        previousMethodCall =
          null;
    }
    int opcodesSincePendingAbsoluteValueBug;
    edu.umd.cs.findbugs.BugInstance pendingAbsoluteValueBug;
    edu.umd.cs.findbugs.SourceLineAnnotation
      pendingAbsoluteValueBugSourceLine;
    boolean sawLoadOfMinValue = false;
    edu.umd.cs.findbugs.classfile.MethodDescriptor
      previousMethodCall =
      null;
    @java.lang.Override
    public void sawOpcode(int seen) { if (isMethodCall(
                                            )) {
                                          edu.umd.cs.findbugs.classfile.MethodDescriptor called =
                                            getMethodDescriptorOperand(
                                              );
                                          if (previousMethodCall !=
                                                null &&
                                                !stack.
                                                isJumpTarget(
                                                  getPC(
                                                    ))) {
                                              if ("toString".
                                                    equals(
                                                      called.
                                                        getName(
                                                          )) &&
                                                    "java/lang/Integer".
                                                    equals(
                                                      called.
                                                        getClassDescriptor(
                                                          ).
                                                        getClassName(
                                                          )) &&
                                                    "valueOf".
                                                    equals(
                                                      previousMethodCall.
                                                        getName(
                                                          )) &&
                                                    "(I)Ljava/lang/Integer;".
                                                    equals(
                                                      previousMethodCall.
                                                        getSignature(
                                                          ))) {
                                                  edu.umd.cs.findbugs.MethodAnnotation preferred =
                                                    new edu.umd.cs.findbugs.MethodAnnotation(
                                                    "java.lang.Integer",
                                                    "toString",
                                                    "(I)Ljava/lang/String;",
                                                    true);
                                                  edu.umd.cs.findbugs.BugInstance bug =
                                                    new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "DM_BOXED_PRIMITIVE_TOSTRING",
                                                    HIGH_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addCalledMethod(
                                                      this).
                                                    addMethod(
                                                      preferred).
                                                    describe(
                                                      edu.umd.cs.findbugs.MethodAnnotation.
                                                        SHOULD_CALL);
                                                  accumulator.
                                                    accumulateBug(
                                                      bug,
                                                      this);
                                              }
                                              else
                                                  if ("intValue".
                                                        equals(
                                                          called.
                                                            getName(
                                                              )) &&
                                                        "java/lang/Integer".
                                                        equals(
                                                          called.
                                                            getClassDescriptor(
                                                              ).
                                                            getClassName(
                                                              )) &&
                                                        "java/lang/Integer".
                                                        equals(
                                                          previousMethodCall.
                                                            getSlashedClassName(
                                                              )) &&
                                                        ("<init>".
                                                           equals(
                                                             previousMethodCall.
                                                               getName(
                                                                 )) &&
                                                           "(Ljava/lang/String;)V".
                                                           equals(
                                                             previousMethodCall.
                                                               getSignature(
                                                                 )) ||
                                                           "valueOf".
                                                           equals(
                                                             previousMethodCall.
                                                               getName(
                                                                 )) &&
                                                           "(Ljava/lang/String;)Ljava/lang/Integer;".
                                                           equals(
                                                             previousMethodCall.
                                                               getSignature(
                                                                 )))) {
                                                      edu.umd.cs.findbugs.MethodAnnotation preferred =
                                                        new edu.umd.cs.findbugs.MethodAnnotation(
                                                        "java.lang.Integer",
                                                        "parseInt",
                                                        "(Ljava/lang/String;)I",
                                                        true);
                                                      edu.umd.cs.findbugs.BugInstance bug =
                                                        new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "DM_BOXED_PRIMITIVE_FOR_PARSING",
                                                        HIGH_PRIORITY).
                                                        addClassAndMethod(
                                                          this).
                                                        addCalledMethod(
                                                          this).
                                                        addMethod(
                                                          preferred).
                                                        describe(
                                                          edu.umd.cs.findbugs.MethodAnnotation.
                                                            SHOULD_CALL);
                                                      accumulator.
                                                        accumulateBug(
                                                          bug,
                                                          this);
                                                  }
                                                  else
                                                      if ("longValue".
                                                            equals(
                                                              called.
                                                                getName(
                                                                  )) &&
                                                            "java/lang/Long".
                                                            equals(
                                                              called.
                                                                getClassDescriptor(
                                                                  ).
                                                                getClassName(
                                                                  )) &&
                                                            "java/lang/Long".
                                                            equals(
                                                              previousMethodCall.
                                                                getSlashedClassName(
                                                                  )) &&
                                                            ("<init>".
                                                               equals(
                                                                 previousMethodCall.
                                                                   getName(
                                                                     )) &&
                                                               "(Ljava/lang/String;)V".
                                                               equals(
                                                                 previousMethodCall.
                                                                   getSignature(
                                                                     )) ||
                                                               "valueOf".
                                                               equals(
                                                                 previousMethodCall.
                                                                   getName(
                                                                     )) &&
                                                               "(Ljava/lang/String;)Ljava/lang/Long;".
                                                               equals(
                                                                 previousMethodCall.
                                                                   getSignature(
                                                                     )))) {
                                                          edu.umd.cs.findbugs.MethodAnnotation preferred =
                                                            new edu.umd.cs.findbugs.MethodAnnotation(
                                                            "java.lang.Long",
                                                            "parseLong",
                                                            "(Ljava/lang/String;)J",
                                                            true);
                                                          edu.umd.cs.findbugs.BugInstance bug =
                                                            new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "DM_BOXED_PRIMITIVE_FOR_PARSING",
                                                            HIGH_PRIORITY).
                                                            addClassAndMethod(
                                                              this).
                                                            addCalledMethod(
                                                              this).
                                                            addMethod(
                                                              preferred).
                                                            describe(
                                                              edu.umd.cs.findbugs.MethodAnnotation.
                                                                SHOULD_CALL);
                                                          accumulator.
                                                            accumulateBug(
                                                              bug,
                                                              this);
                                                      }
                                                      else
                                                          if ("compareTo".
                                                                equals(
                                                                  called.
                                                                    getName(
                                                                      )) &&
                                                                "valueOf".
                                                                equals(
                                                                  previousMethodCall.
                                                                    getName(
                                                                      )) &&
                                                                called.
                                                                getClassDescriptor(
                                                                  ).
                                                                equals(
                                                                  previousMethodCall.
                                                                    getClassDescriptor(
                                                                      )) &&
                                                                !previousMethodCall.
                                                                getSignature(
                                                                  ).
                                                                startsWith(
                                                                  "(Ljava/lang/String;")) {
                                                              java.lang.String primitiveType =
                                                                edu.umd.cs.findbugs.util.ClassName.
                                                                getPrimitiveType(
                                                                  called.
                                                                    getClassDescriptor(
                                                                      ).
                                                                    getClassName(
                                                                      ));
                                                              edu.umd.cs.findbugs.ba.XMethod rvo =
                                                                stack.
                                                                getStackItem(
                                                                  1).
                                                                getReturnValueOf(
                                                                  );
                                                              edu.umd.cs.findbugs.ba.XField field =
                                                                stack.
                                                                getStackItem(
                                                                  1).
                                                                getXField(
                                                                  );
                                                              java.lang.String signature;
                                                              if (rvo !=
                                                                    null) {
                                                                  signature =
                                                                    new edu.umd.cs.findbugs.ba.SignatureParser(
                                                                      rvo.
                                                                        getSignature(
                                                                          )).
                                                                      getReturnTypeSignature(
                                                                        );
                                                              }
                                                              else
                                                                  if (field !=
                                                                        null) {
                                                                      signature =
                                                                        field.
                                                                          getSignature(
                                                                            );
                                                                  }
                                                                  else {
                                                                      signature =
                                                                        "";
                                                                  }
                                                              if (primitiveType !=
                                                                    null &&
                                                                    (previousMethodCall.
                                                                       equals(
                                                                         rvo) ||
                                                                       signature.
                                                                       equals(
                                                                         primitiveType)) &&
                                                                    (getThisClass(
                                                                       ).
                                                                       getMajor(
                                                                         ) >=
                                                                       MAJOR_1_7 ||
                                                                       getThisClass(
                                                                         ).
                                                                       getMajor(
                                                                         ) >=
                                                                       MAJOR_1_4 &&
                                                                       (primitiveType.
                                                                          equals(
                                                                            "D") ||
                                                                          primitiveType.
                                                                          equals(
                                                                            "F")))) {
                                                                  edu.umd.cs.findbugs.classfile.MethodDescriptor shouldCall =
                                                                    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
                                                                    called.
                                                                      getClassDescriptor(
                                                                        ).
                                                                      getClassName(
                                                                        ),
                                                                    "compare",
                                                                    "(" +
                                                                    primitiveType +
                                                                    primitiveType +
                                                                    ")I",
                                                                    true);
                                                                  edu.umd.cs.findbugs.BugInstance bug =
                                                                    new edu.umd.cs.findbugs.BugInstance(
                                                                    this,
                                                                    "DM_BOXED_PRIMITIVE_FOR_COMPARE",
                                                                    primitiveType.
                                                                      equals(
                                                                        "Z")
                                                                      ? LOW_PRIORITY
                                                                      : (primitiveType.
                                                                           equals(
                                                                             "B")
                                                                           ? NORMAL_PRIORITY
                                                                           : HIGH_PRIORITY)).
                                                                    addClassAndMethod(
                                                                      this).
                                                                    addCalledMethod(
                                                                      this).
                                                                    addMethod(
                                                                      shouldCall).
                                                                    describe(
                                                                      edu.umd.cs.findbugs.MethodAnnotation.
                                                                        SHOULD_CALL);
                                                                  accumulator.
                                                                    accumulateBug(
                                                                      bug,
                                                                      this);
                                                              }
                                                          }
                                          }
                                          previousMethodCall =
                                            called;
                                      }
                                      else {
                                          previousMethodCall =
                                            null;
                                      }
                                      if (seen ==
                                            LDC ||
                                            seen ==
                                            LDC_W ||
                                            seen ==
                                            LDC2_W) {
                                          org.apache.bcel.classfile.Constant c =
                                            getConstantRefOperand(
                                              );
                                          if (testingEnabled &&
                                                (c instanceof org.apache.bcel.classfile.ConstantInteger &&
                                                   ((org.apache.bcel.classfile.ConstantInteger)
                                                      c).
                                                   getBytes(
                                                     ) ==
                                                   MICROS_PER_DAY_OVERFLOWED_AS_INT ||
                                                   c instanceof org.apache.bcel.classfile.ConstantLong &&
                                                   ((org.apache.bcel.classfile.ConstantLong)
                                                      c).
                                                   getBytes(
                                                     ) ==
                                                   MICROS_PER_DAY_OVERFLOWED_AS_INT)) {
                                              edu.umd.cs.findbugs.BugInstance bug =
                                                new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                "TESTING",
                                                HIGH_PRIORITY).
                                                addClassAndMethod(
                                                  this).
                                                addString(
                                                  "Did you mean MICROS_PER_DAY").
                                                addInt(
                                                  MICROS_PER_DAY_OVERFLOWED_AS_INT).
                                                describe(
                                                  edu.umd.cs.findbugs.IntAnnotation.
                                                    INT_VALUE);
                                              accumulator.
                                                accumulateBug(
                                                  bug,
                                                  this);
                                          }
                                          if (c instanceof org.apache.bcel.classfile.ConstantInteger &&
                                                ((org.apache.bcel.classfile.ConstantInteger)
                                                   c).
                                                getBytes(
                                                  ) ==
                                                java.lang.Integer.
                                                  MIN_VALUE ||
                                                c instanceof org.apache.bcel.classfile.ConstantLong &&
                                                ((org.apache.bcel.classfile.ConstantLong)
                                                   c).
                                                getBytes(
                                                  ) ==
                                                java.lang.Long.
                                                  MIN_VALUE) {
                                              sawLoadOfMinValue =
                                                true;
                                              pendingAbsoluteValueBug =
                                                null;
                                              pendingAbsoluteValueBugSourceLine =
                                                null;
                                              absoluteValueAccumulator.
                                                clearBugs(
                                                  );
                                          }
                                      }
                                      if (seen ==
                                            LCMP) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item left =
                                            stack.
                                            getStackItem(
                                              1);
                                          edu.umd.cs.findbugs.OpcodeStack.Item right =
                                            stack.
                                            getStackItem(
                                              0);
                                          checkForCompatibleLongComparison(
                                            left,
                                            right);
                                          checkForCompatibleLongComparison(
                                            right,
                                            left);
                                      }
                                      if (stack.
                                            getStackDepth(
                                              ) >=
                                            2) {
                                          switch (seen) {
                                              case IF_ICMPEQ:
                                              case IF_ICMPNE:
                                              case IF_ICMPLE:
                                              case IF_ICMPGE:
                                              case IF_ICMPLT:
                                              case IF_ICMPGT:
                                                  edu.umd.cs.findbugs.OpcodeStack.Item item0 =
                                                    stack.
                                                    getStackItem(
                                                      0);
                                                  edu.umd.cs.findbugs.OpcodeStack.Item item1 =
                                                    stack.
                                                    getStackItem(
                                                      1);
                                                  if (item0.
                                                        getConstant(
                                                          ) instanceof java.lang.Integer) {
                                                      edu.umd.cs.findbugs.OpcodeStack.Item tmp =
                                                        item0;
                                                      item0 =
                                                        item1;
                                                      item1 =
                                                        tmp;
                                                  }
                                                  java.lang.Object constant1 =
                                                    item1.
                                                    getConstant(
                                                      );
                                                  edu.umd.cs.findbugs.ba.XMethod returnValueOf =
                                                    item0.
                                                    getReturnValueOf(
                                                      );
                                                  if (constant1 instanceof java.lang.Integer &&
                                                        returnValueOf !=
                                                        null &&
                                                        "getYear".
                                                        equals(
                                                          returnValueOf.
                                                            getName(
                                                              )) &&
                                                        ("java.util.Date".
                                                           equals(
                                                             returnValueOf.
                                                               getClassName(
                                                                 )) ||
                                                           "java.sql.Date".
                                                           equals(
                                                             returnValueOf.
                                                               getClassName(
                                                                 )))) {
                                                      int year =
                                                        (java.lang.Integer)
                                                          constant1;
                                                      if (testingEnabled &&
                                                            year >
                                                            1900) {
                                                          accumulator.
                                                            accumulateBug(
                                                              new edu.umd.cs.findbugs.BugInstance(
                                                                this,
                                                                "TESTING",
                                                                HIGH_PRIORITY).
                                                                addClassAndMethod(
                                                                  this).
                                                                addString(
                                                                  ("Comparison of getYear does understand that it returns year-1" +
                                                                   "900")).
                                                                addMethod(
                                                                  returnValueOf).
                                                                describe(
                                                                  edu.umd.cs.findbugs.MethodAnnotation.
                                                                    METHOD_CALLED).
                                                                addInt(
                                                                  year).
                                                                describe(
                                                                  edu.umd.cs.findbugs.IntAnnotation.
                                                                    INT_VALUE),
                                                              this);
                                                      }
                                                  }
                                                  break;
                                              default:
                                                  break;
                                          }
                                      }
                                      if (seen ==
                                            IFLT &&
                                            stack.
                                            getStackDepth(
                                              ) >
                                            0 &&
                                            stack.
                                            getStackItem(
                                              0).
                                            getSpecialKind(
                                              ) ==
                                            edu.umd.cs.findbugs.OpcodeStack.Item.
                                              SIGNED_BYTE) {
                                          sawCheckForNonNegativeSignedByte =
                                            getPC(
                                              );
                                      }
                                      if (pendingAbsoluteValueBug !=
                                            null) {
                                          if (opcodesSincePendingAbsoluteValueBug ==
                                                0) {
                                              opcodesSincePendingAbsoluteValueBug++;
                                          }
                                          else {
                                              if (seen ==
                                                    IREM) {
                                                  edu.umd.cs.findbugs.OpcodeStack.Item top =
                                                    stack.
                                                    getStackItem(
                                                      0);
                                                  java.lang.Object constantValue =
                                                    top.
                                                    getConstant(
                                                      );
                                                  if (constantValue instanceof java.lang.Number &&
                                                        edu.umd.cs.findbugs.util.Util.
                                                        isPowerOfTwo(
                                                          ((java.lang.Number)
                                                             constantValue).
                                                            intValue(
                                                              ))) {
                                                      pendingAbsoluteValueBug.
                                                        setPriority(
                                                          edu.umd.cs.findbugs.Priorities.
                                                            LOW_PRIORITY);
                                                  }
                                              }
                                              absoluteValueAccumulator.
                                                accumulateBug(
                                                  pendingAbsoluteValueBug,
                                                  pendingAbsoluteValueBugSourceLine);
                                              pendingAbsoluteValueBug =
                                                null;
                                              pendingAbsoluteValueBugSourceLine =
                                                null;
                                          }
                                      }
                                      if (seen ==
                                            INVOKESTATIC &&
                                            "org/easymock/EasyMock".
                                            equals(
                                              getClassConstantOperand(
                                                )) &&
                                            ("replay".
                                               equals(
                                                 getNameConstantOperand(
                                                   )) ||
                                               "verify".
                                               equals(
                                                 getNameConstantOperand(
                                                   )) ||
                                               getNameConstantOperand(
                                                 ).
                                               startsWith(
                                                 "reset")) &&
                                            "([Ljava/lang/Object;)V".
                                            equals(
                                              getSigConstantOperand(
                                                )) &&
                                            getPrevOpcode(
                                              1) ==
                                            ANEWARRAY &&
                                            getPrevOpcode(
                                              2) ==
                                            ICONST_0) {
                                          accumulator.
                                            accumulateBug(
                                              new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                "DMI_VACUOUS_CALL_TO_EASYMOCK_METHOD",
                                                NORMAL_PRIORITY).
                                                addClassAndMethod(
                                                  this).
                                                addCalledMethod(
                                                  this),
                                              this);
                                      }
                                      if ((seen ==
                                             INVOKESTATIC ||
                                             seen ==
                                             INVOKEVIRTUAL ||
                                             seen ==
                                             INVOKESPECIAL ||
                                             seen ==
                                             INVOKEINTERFACE) &&
                                            getSigConstantOperand(
                                              ).
                                            indexOf(
                                              "Ljava/lang/Runnable;") >=
                                            0) {
                                          edu.umd.cs.findbugs.ba.SignatureParser parser =
                                            new edu.umd.cs.findbugs.ba.SignatureParser(
                                            getSigConstantOperand(
                                              ));
                                          int count =
                                            0;
                                          for (java.util.Iterator<java.lang.String> i =
                                                 parser.
                                                 parameterSignatureIterator(
                                                   );
                                               i.
                                                 hasNext(
                                                   );
                                               count++) {
                                              java.lang.String parameter =
                                                i.
                                                next(
                                                  );
                                              if ("Ljava/lang/Runnable;".
                                                    equals(
                                                      parameter)) {
                                                  edu.umd.cs.findbugs.OpcodeStack.Item item =
                                                    stack.
                                                    getStackItem(
                                                      parser.
                                                        getNumParameters(
                                                          ) -
                                                        1 -
                                                        count);
                                                  if ("Ljava/lang/Thread;".
                                                        equals(
                                                          item.
                                                            getSignature(
                                                              ))) {
                                                      accumulator.
                                                        accumulateBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "DMI_THREAD_PASSED_WHERE_RUNNABLE_EXPECTED",
                                                            NORMAL_PRIORITY).
                                                            addClassAndMethod(
                                                              this).
                                                            addCalledMethod(
                                                              this),
                                                          this);
                                                  }
                                              }
                                          }
                                      }
                                      if (prevOpcode ==
                                            I2L &&
                                            seen ==
                                            INVOKESTATIC &&
                                            "java/lang/Double".
                                            equals(
                                              getClassConstantOperand(
                                                )) &&
                                            "longBitsToDouble".
                                            equals(
                                              getNameConstantOperand(
                                                ))) {
                                          accumulator.
                                            accumulateBug(
                                              new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                "DMI_LONG_BITS_TO_DOUBLE_INVOKED_ON_INT",
                                                HIGH_PRIORITY).
                                                addClassAndMethod(
                                                  this).
                                                addCalledMethod(
                                                  this),
                                              this);
                                      }
                                      for (edu.umd.cs.findbugs.detect.DumbMethods.SubDetector subDetector
                                            :
                                            subDetectors) {
                                          subDetector.
                                            sawOpcode(
                                              seen);
                                      }
                                      if (!sawLoadOfMinValue &&
                                            seen ==
                                            INVOKESTATIC &&
                                            edu.umd.cs.findbugs.util.ClassName.
                                            isMathClass(
                                              getClassConstantOperand(
                                                )) &&
                                            "abs".
                                            equals(
                                              getNameConstantOperand(
                                                ))) {
                                          edu.umd.cs.findbugs.OpcodeStack.Item item0 =
                                            stack.
                                            getStackItem(
                                              0);
                                          int special =
                                            item0.
                                            getSpecialKind(
                                              );
                                          if (special ==
                                                edu.umd.cs.findbugs.OpcodeStack.Item.
                                                  RANDOM_INT) {
                                              pendingAbsoluteValueBug =
                                                new edu.umd.cs.findbugs.BugInstance(
                                                  this,
                                                  "RV_ABSOLUTE_VALUE_OF_RANDOM_INT",
                                                  HIGH_PRIORITY).
                                                  addClassAndMethod(
                                                    this);
                                              pendingAbsoluteValueBugSourceLine =
                                                edu.umd.cs.findbugs.SourceLineAnnotation.
                                                  fromVisitedInstruction(
                                                    this);
                                              opcodesSincePendingAbsoluteValueBug =
                                                0;
                                          }
                                          else
                                              if (special ==
                                                    edu.umd.cs.findbugs.OpcodeStack.Item.
                                                      HASHCODE_INT) {
                                                  pendingAbsoluteValueBug =
                                                    new edu.umd.cs.findbugs.BugInstance(
                                                      this,
                                                      "RV_ABSOLUTE_VALUE_OF_HASHCODE",
                                                      HIGH_PRIORITY).
                                                      addClassAndMethod(
                                                        this);
                                                  pendingAbsoluteValueBugSourceLine =
                                                    edu.umd.cs.findbugs.SourceLineAnnotation.
                                                      fromVisitedInstruction(
                                                        this);
                                                  opcodesSincePendingAbsoluteValueBug =
                                                    0;
                                              }
                                      }
                                      try {
                                          int stackLoc =
                                            stackEntryThatMustBeNonnegative(
                                              seen);
                                          if (stackLoc >=
                                                0) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item tos =
                                                stack.
                                                getStackItem(
                                                  stackLoc);
                                              switch (tos.
                                                        getSpecialKind(
                                                          )) {
                                                  case edu.umd.cs.findbugs.OpcodeStack.Item.
                                                         HASHCODE_INT_REMAINDER:
                                                      accumulator.
                                                        accumulateBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "RV_REM_OF_HASHCODE",
                                                            HIGH_PRIORITY).
                                                            addClassAndMethod(
                                                              this),
                                                          this);
                                                      break;
                                                  case edu.umd.cs.findbugs.OpcodeStack.Item.
                                                         RANDOM_INT:
                                                  case edu.umd.cs.findbugs.OpcodeStack.Item.
                                                         RANDOM_INT_REMAINDER:
                                                      accumulator.
                                                        accumulateBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "RV_REM_OF_RANDOM_INT",
                                                            HIGH_PRIORITY).
                                                            addClassAndMethod(
                                                              this),
                                                          this);
                                                      break;
                                                  default:
                                                      break;
                                              }
                                          }
                                          if (seen ==
                                                IREM) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item item0 =
                                                stack.
                                                getStackItem(
                                                  0);
                                              java.lang.Object constant0 =
                                                item0.
                                                getConstant(
                                                  );
                                              if (constant0 instanceof java.lang.Integer &&
                                                    ((java.lang.Integer)
                                                       constant0).
                                                    intValue(
                                                      ) ==
                                                    1) {
                                                  accumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "INT_BAD_REM_BY_1",
                                                        HIGH_PRIORITY).
                                                        addClassAndMethod(
                                                          this),
                                                      this);
                                              }
                                          }
                                          if (stack.
                                                getStackDepth(
                                                  ) >=
                                                1 &&
                                                (seen ==
                                                   LOOKUPSWITCH ||
                                                   seen ==
                                                   TABLESWITCH)) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item item0 =
                                                stack.
                                                getStackItem(
                                                  0);
                                              if (item0.
                                                    getSpecialKind(
                                                      ) ==
                                                    edu.umd.cs.findbugs.OpcodeStack.Item.
                                                      SIGNED_BYTE) {
                                                  int[] switchLabels =
                                                    getSwitchLabels(
                                                      );
                                                  int[] switchOffsets =
                                                    getSwitchOffsets(
                                                      );
                                                  for (int i =
                                                         0;
                                                       i <
                                                         switchLabels.
                                                           length;
                                                       i++) {
                                                      int v =
                                                        switchLabels[i];
                                                      if (v <=
                                                            -129 ||
                                                            v >=
                                                            128) {
                                                          accumulator.
                                                            accumulateBug(
                                                              new edu.umd.cs.findbugs.BugInstance(
                                                                this,
                                                                "INT_BAD_COMPARISON_WITH_SIGNED_BYTE",
                                                                HIGH_PRIORITY).
                                                                addClassAndMethod(
                                                                  this).
                                                                addInt(
                                                                  v).
                                                                describe(
                                                                  edu.umd.cs.findbugs.IntAnnotation.
                                                                    INT_VALUE),
                                                              edu.umd.cs.findbugs.SourceLineAnnotation.
                                                                fromVisitedInstruction(
                                                                  this,
                                                                  getPC(
                                                                    ) +
                                                                    switchOffsets[i]));
                                                      }
                                                  }
                                              }
                                          }
                                          if (stack.
                                                getStackDepth(
                                                  ) >=
                                                2) {
                                              switch (seen) {
                                                  case IF_ICMPEQ:
                                                  case IF_ICMPNE:
                                                  case IF_ICMPLT:
                                                  case IF_ICMPLE:
                                                  case IF_ICMPGE:
                                                  case IF_ICMPGT:
                                                      edu.umd.cs.findbugs.OpcodeStack.Item item0 =
                                                        stack.
                                                        getStackItem(
                                                          0);
                                                      edu.umd.cs.findbugs.OpcodeStack.Item item1 =
                                                        stack.
                                                        getStackItem(
                                                          1);
                                                      int seen2 =
                                                        seen;
                                                      if (item0.
                                                            getConstant(
                                                              ) !=
                                                            null) {
                                                          edu.umd.cs.findbugs.OpcodeStack.Item tmp =
                                                            item0;
                                                          item0 =
                                                            item1;
                                                          item1 =
                                                            tmp;
                                                          switch (seen) {
                                                              case IF_ICMPLT:
                                                                  seen2 =
                                                                    IF_ICMPGT;
                                                                  break;
                                                              case IF_ICMPGE:
                                                                  seen2 =
                                                                    IF_ICMPLE;
                                                                  break;
                                                              case IF_ICMPGT:
                                                                  seen2 =
                                                                    IF_ICMPLT;
                                                                  break;
                                                              case IF_ICMPLE:
                                                                  seen2 =
                                                                    IF_ICMPGE;
                                                                  break;
                                                              default:
                                                                  break;
                                                          }
                                                      }
                                                      java.lang.Object constant1 =
                                                        item1.
                                                        getConstant(
                                                          );
                                                      if (item0.
                                                            getSpecialKind(
                                                              ) ==
                                                            edu.umd.cs.findbugs.OpcodeStack.Item.
                                                              SIGNED_BYTE &&
                                                            constant1 instanceof java.lang.Number) {
                                                          int v1 =
                                                            ((java.lang.Number)
                                                               constant1).
                                                            intValue(
                                                              );
                                                          if (v1 <=
                                                                -129 ||
                                                                v1 >=
                                                                128 ||
                                                                v1 ==
                                                                127 &&
                                                                !(seen2 ==
                                                                    IF_ICMPEQ ||
                                                                    seen2 ==
                                                                    IF_ICMPNE)) {
                                                              int priority =
                                                                HIGH_PRIORITY;
                                                              if (v1 ==
                                                                    127) {
                                                                  switch (seen2) {
                                                                      case IF_ICMPGT:
                                                                          priority =
                                                                            LOW_PRIORITY;
                                                                          break;
                                                                      case IF_ICMPGE:
                                                                          priority =
                                                                            NORMAL_PRIORITY;
                                                                          break;
                                                                      case IF_ICMPLT:
                                                                          priority =
                                                                            NORMAL_PRIORITY;
                                                                          break;
                                                                      case IF_ICMPLE:
                                                                          priority =
                                                                            LOW_PRIORITY;
                                                                          break;
                                                                  }
                                                              }
                                                              else
                                                                  if (v1 ==
                                                                        128) {
                                                                      switch (seen2) {
                                                                          case IF_ICMPGT:
                                                                              priority =
                                                                                NORMAL_PRIORITY;
                                                                              break;
                                                                          case IF_ICMPGE:
                                                                              priority =
                                                                                HIGH_PRIORITY;
                                                                              break;
                                                                          case IF_ICMPLT:
                                                                              priority =
                                                                                HIGH_PRIORITY;
                                                                              break;
                                                                          case IF_ICMPLE:
                                                                              priority =
                                                                                NORMAL_PRIORITY;
                                                                              break;
                                                                      }
                                                                  }
                                                                  else
                                                                      if (v1 <=
                                                                            -129) {
                                                                          priority =
                                                                            NORMAL_PRIORITY;
                                                                      }
                                                              if (getPC(
                                                                    ) -
                                                                    sawCheckForNonNegativeSignedByte <
                                                                    10) {
                                                                  priority++;
                                                              }
                                                              accumulator.
                                                                accumulateBug(
                                                                  new edu.umd.cs.findbugs.BugInstance(
                                                                    this,
                                                                    "INT_BAD_COMPARISON_WITH_SIGNED_BYTE",
                                                                    priority).
                                                                    addClassAndMethod(
                                                                      this).
                                                                    addInt(
                                                                      v1).
                                                                    describe(
                                                                      edu.umd.cs.findbugs.IntAnnotation.
                                                                        INT_VALUE).
                                                                    addValueSource(
                                                                      item0,
                                                                      this),
                                                                  this);
                                                          }
                                                      }
                                                      else
                                                          if (item0.
                                                                getSpecialKind(
                                                                  ) ==
                                                                edu.umd.cs.findbugs.OpcodeStack.Item.
                                                                  NON_NEGATIVE &&
                                                                constant1 instanceof java.lang.Number) {
                                                              int v1 =
                                                                ((java.lang.Number)
                                                                   constant1).
                                                                intValue(
                                                                  );
                                                              if (v1 <
                                                                    0) {
                                                                  accumulator.
                                                                    accumulateBug(
                                                                      new edu.umd.cs.findbugs.BugInstance(
                                                                        this,
                                                                        "INT_BAD_COMPARISON_WITH_NONNEGATIVE_VALUE",
                                                                        HIGH_PRIORITY).
                                                                        addClassAndMethod(
                                                                          this).
                                                                        addInt(
                                                                          v1).
                                                                        describe(
                                                                          edu.umd.cs.findbugs.IntAnnotation.
                                                                            INT_VALUE).
                                                                        addValueSource(
                                                                          item0,
                                                                          this),
                                                                      this);
                                                              }
                                                          }
                                              }
                                          }
                                          switch (seen) {
                                              case IFGE:
                                              case IFLT:
                                                  if (stack.
                                                        getStackDepth(
                                                          ) >
                                                        0 &&
                                                        stack.
                                                        getStackItem(
                                                          0).
                                                        getSpecialKind(
                                                          ) ==
                                                        edu.umd.cs.findbugs.OpcodeStack.Item.
                                                          NON_NEGATIVE) {
                                                      edu.umd.cs.findbugs.OpcodeStack.Item top =
                                                        stack.
                                                        getStackItem(
                                                          0);
                                                      if (top.
                                                            getRegisterNumber(
                                                              ) !=
                                                            -1 &&
                                                            getMaxPC(
                                                              ) >
                                                            getNextPC(
                                                              ) +
                                                            6) {
                                                          if (false) {
                                                              for (int i =
                                                                     -2;
                                                                   i <=
                                                                     0;
                                                                   i++) {
                                                                  int o =
                                                                    getPrevOpcode(
                                                                      -i);
                                                                  java.lang.System.
                                                                    out.
                                                                    printf(
                                                                      "%2d %3d  %2x %s%n",
                                                                      i,
                                                                      o,
                                                                      o,
                                                                      OPCODE_NAMES[o]);
                                                              }
                                                              for (int i =
                                                                     0;
                                                                   i <
                                                                     7;
                                                                   i++) {
                                                                  int o =
                                                                    getNextCodeByte(
                                                                      i);
                                                                  java.lang.System.
                                                                    out.
                                                                    printf(
                                                                      "%2d %3d %2x %s%n",
                                                                      i,
                                                                      o,
                                                                      o,
                                                                      OPCODE_NAMES[o]);
                                                              }
                                                          }
                                                          int jump1;
                                                          int jump2;
                                                          if (seen ==
                                                                IFGE) {
                                                              jump1 =
                                                                IF_ICMPLT;
                                                              jump2 =
                                                                IF_ICMPLE;
                                                          }
                                                          else {
                                                              jump1 =
                                                                IF_ICMPGE;
                                                              jump2 =
                                                                IF_ICMPGT;
                                                          }
                                                          int nextCodeByte0 =
                                                            getNextCodeByte(
                                                              0);
                                                          int loadConstant =
                                                            1;
                                                          if (nextCodeByte0 ==
                                                                ILOAD) {
                                                              loadConstant =
                                                                2;
                                                          }
                                                          int nextCodeByte1 =
                                                            getNextCodeByte(
                                                              loadConstant);
                                                          int nextCodeByte2 =
                                                            getNextCodeByte(
                                                              loadConstant +
                                                                1);
                                                          int nextJumpOffset =
                                                            loadConstant +
                                                            2;
                                                          if (nextCodeByte1 ==
                                                                SIPUSH) {
                                                              nextJumpOffset++;
                                                          }
                                                          int nextCodeByteJump =
                                                            getNextCodeByte(
                                                              nextJumpOffset);
                                                          if (nextCodeByte0 ==
                                                                getPrevOpcode(
                                                                  1) &&
                                                                (nextCodeByte1 ==
                                                                   BIPUSH ||
                                                                   nextCodeByte1 ==
                                                                   SIPUSH) &&
                                                                (IF_ICMPLT <=
                                                                   nextCodeByteJump &&
                                                                   nextCodeByteJump <=
                                                                   IF_ICMPLE)) {
                                                              break;
                                                          }
                                                      }
                                                      accumulator.
                                                        accumulateBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "INT_BAD_COMPARISON_WITH_NONNEGATIVE_VALUE",
                                                            NORMAL_PRIORITY).
                                                            addClassAndMethod(
                                                              this).
                                                            addInt(
                                                              0).
                                                            describe(
                                                              edu.umd.cs.findbugs.IntAnnotation.
                                                                INT_VALUE).
                                                            addValueSource(
                                                              top,
                                                              this),
                                                          this);
                                                  }
                                                  break;
                                              case IAND:
                                              case LAND:
                                              case IOR:
                                              case LOR:
                                              case IXOR:
                                              case LXOR:
                                                  long badValue =
                                                    seen ==
                                                    IAND ||
                                                    seen ==
                                                    LAND
                                                    ? -1
                                                    : 0;
                                                  edu.umd.cs.findbugs.OpcodeStack.Item rhs =
                                                    stack.
                                                    getStackItem(
                                                      0);
                                                  edu.umd.cs.findbugs.OpcodeStack.Item lhs =
                                                    stack.
                                                    getStackItem(
                                                      1);
                                                  int prevOpcode =
                                                    getPrevOpcode(
                                                      1);
                                                  int prevPrevOpcode =
                                                    getPrevOpcode(
                                                      2);
                                                  if (rhs.
                                                        hasConstantValue(
                                                          badValue) &&
                                                        (prevOpcode ==
                                                           LDC ||
                                                           prevOpcode ==
                                                           ICONST_0 ||
                                                           prevOpcode ==
                                                           ICONST_M1 ||
                                                           prevOpcode ==
                                                           LCONST_0) &&
                                                        prevPrevOpcode !=
                                                        GOTO) {
                                                      reportVacuousBitOperation(
                                                        seen,
                                                        lhs);
                                                  }
                                          }
                                          if (checkForBitIorofSignedByte &&
                                                seen !=
                                                I2B) {
                                              java.lang.String pattern =
                                                prevOpcode ==
                                                LOR ||
                                                prevOpcode ==
                                                IOR
                                                ? "BIT_IOR_OF_SIGNED_BYTE"
                                                : "BIT_ADD_OF_SIGNED_BYTE";
                                              int priority =
                                                prevOpcode ==
                                                LOR ||
                                                prevOpcode ==
                                                LADD
                                                ? HIGH_PRIORITY
                                                : NORMAL_PRIORITY;
                                              accumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    pattern,
                                                    priority).
                                                    addClassAndMethod(
                                                      this),
                                                  this);
                                              checkForBitIorofSignedByte =
                                                false;
                                          }
                                          else
                                              if ((seen ==
                                                     IOR ||
                                                     seen ==
                                                     LOR ||
                                                     seen ==
                                                     IADD ||
                                                     seen ==
                                                     LADD) &&
                                                    stack.
                                                    getStackDepth(
                                                      ) >=
                                                    2) {
                                                  edu.umd.cs.findbugs.OpcodeStack.Item item0 =
                                                    stack.
                                                    getStackItem(
                                                      0);
                                                  edu.umd.cs.findbugs.OpcodeStack.Item item1 =
                                                    stack.
                                                    getStackItem(
                                                      1);
                                                  int special0 =
                                                    item0.
                                                    getSpecialKind(
                                                      );
                                                  int special1 =
                                                    item1.
                                                    getSpecialKind(
                                                      );
                                                  if (special0 ==
                                                        edu.umd.cs.findbugs.OpcodeStack.Item.
                                                          SIGNED_BYTE &&
                                                        special1 ==
                                                        edu.umd.cs.findbugs.OpcodeStack.Item.
                                                          LOW_8_BITS_CLEAR &&
                                                        !item1.
                                                        hasConstantValue(
                                                          256) ||
                                                        special0 ==
                                                        edu.umd.cs.findbugs.OpcodeStack.Item.
                                                          LOW_8_BITS_CLEAR &&
                                                        !item0.
                                                        hasConstantValue(
                                                          256) &&
                                                        special1 ==
                                                        edu.umd.cs.findbugs.OpcodeStack.Item.
                                                          SIGNED_BYTE) {
                                                      checkForBitIorofSignedByte =
                                                        true;
                                                  }
                                                  else {
                                                      checkForBitIorofSignedByte =
                                                        false;
                                                  }
                                              }
                                              else {
                                                  checkForBitIorofSignedByte =
                                                    false;
                                              }
                                          if (prevOpcodeWasReadLine &&
                                                sinceBufferedInputStreamReady >=
                                                100 &&
                                                seen ==
                                                INVOKEVIRTUAL &&
                                                "java/lang/String".
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                getSigConstantOperand(
                                                  ).
                                                startsWith(
                                                  "()")) {
                                              accumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "NP_IMMEDIATE_DEREFERENCE_OF_READLINE",
                                                    NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this),
                                                  this);
                                          }
                                          if (seen ==
                                                INVOKEVIRTUAL &&
                                                "java/io/BufferedReader".
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                "ready".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                "()Z".
                                                equals(
                                                  getSigConstantOperand(
                                                    ))) {
                                              sinceBufferedInputStreamReady =
                                                0;
                                          }
                                          else {
                                              sinceBufferedInputStreamReady++;
                                          }
                                          prevOpcodeWasReadLine =
                                            (seen ==
                                               INVOKEVIRTUAL ||
                                               seen ==
                                               INVOKEINTERFACE) &&
                                              "readLine".
                                              equals(
                                                getNameConstantOperand(
                                                  )) &&
                                              "()Ljava/lang/String;".
                                              equals(
                                                getSigConstantOperand(
                                                  ));
                                          switch (randomNextIntState) {
                                              case 0:
                                                  if (seen ==
                                                        INVOKEVIRTUAL &&
                                                        "java/util/Random".
                                                        equals(
                                                          getClassConstantOperand(
                                                            )) &&
                                                        "nextDouble".
                                                        equals(
                                                          getNameConstantOperand(
                                                            )) ||
                                                        seen ==
                                                        INVOKESTATIC &&
                                                        edu.umd.cs.findbugs.util.ClassName.
                                                        isMathClass(
                                                          getClassConstantOperand(
                                                            )) &&
                                                        "random".
                                                        equals(
                                                          getNameConstantOperand(
                                                            ))) {
                                                      randomNextIntState =
                                                        1;
                                                  }
                                                  break;
                                              case 1:
                                                  if (seen ==
                                                        D2I) {
                                                      accumulator.
                                                        accumulateBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "RV_01_TO_INT",
                                                            HIGH_PRIORITY).
                                                            addClassAndMethod(
                                                              this),
                                                          this);
                                                      randomNextIntState =
                                                        0;
                                                  }
                                                  else
                                                      if (seen ==
                                                            DMUL) {
                                                          randomNextIntState =
                                                            4;
                                                      }
                                                      else
                                                          if (seen ==
                                                                LDC2_W &&
                                                                getConstantRefOperand(
                                                                  ) instanceof org.apache.bcel.classfile.ConstantDouble &&
                                                                ((org.apache.bcel.classfile.ConstantDouble)
                                                                   getConstantRefOperand(
                                                                     )).
                                                                getBytes(
                                                                  ) ==
                                                                java.lang.Integer.
                                                                  MIN_VALUE) {
                                                              randomNextIntState =
                                                                0;
                                                          }
                                                          else {
                                                              randomNextIntState =
                                                                2;
                                                          }
                                                  break;
                                              case 2:
                                                  if (seen ==
                                                        I2D) {
                                                      randomNextIntState =
                                                        3;
                                                  }
                                                  else
                                                      if (seen ==
                                                            DMUL) {
                                                          randomNextIntState =
                                                            4;
                                                      }
                                                      else {
                                                          randomNextIntState =
                                                            0;
                                                      }
                                                  break;
                                              case 3:
                                                  if (seen ==
                                                        DMUL) {
                                                      randomNextIntState =
                                                        4;
                                                  }
                                                  else {
                                                      randomNextIntState =
                                                        0;
                                                  }
                                                  break;
                                              case 4:
                                                  if (seen ==
                                                        D2I) {
                                                      accumulator.
                                                        accumulateBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "DM_NEXTINT_VIA_NEXTDOUBLE",
                                                            NORMAL_PRIORITY).
                                                            addClassAndMethod(
                                                              this),
                                                          this);
                                                  }
                                                  randomNextIntState =
                                                    0;
                                                  break;
                                              default:
                                                  throw new java.lang.IllegalStateException(
                                                    );
                                          }
                                          if (isPublicStaticVoidMain &&
                                                seen ==
                                                INVOKEVIRTUAL &&
                                                getClassConstantOperand(
                                                  ).
                                                startsWith(
                                                  "javax/swing/") &&
                                                ("show".
                                                   equals(
                                                     getNameConstantOperand(
                                                       )) &&
                                                   "()V".
                                                   equals(
                                                     getSigConstantOperand(
                                                       )) ||
                                                   "pack".
                                                   equals(
                                                     getNameConstantOperand(
                                                       )) &&
                                                   "()V".
                                                   equals(
                                                     getSigConstantOperand(
                                                       )) ||
                                                   "setVisible".
                                                   equals(
                                                     getNameConstantOperand(
                                                       )) &&
                                                   "(Z)V".
                                                   equals(
                                                     getSigConstantOperand(
                                                       )))) {
                                              accumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "SW_SWING_METHODS_INVOKED_IN_SWING_THREAD",
                                                    LOW_PRIORITY).
                                                    addClassAndMethod(
                                                      this),
                                                  this);
                                          }
                                          if (seen ==
                                                INVOKEVIRTUAL &&
                                                "isAnnotationPresent".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                "(Ljava/lang/Class;)Z".
                                                equals(
                                                  getSigConstantOperand(
                                                    )) &&
                                                stack.
                                                getStackDepth(
                                                  ) >
                                                0) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item item =
                                                stack.
                                                getStackItem(
                                                  0);
                                              java.lang.Object value =
                                                item.
                                                getConstant(
                                                  );
                                              if (value instanceof java.lang.String) {
                                                  java.lang.String annotationClassName =
                                                    (java.lang.String)
                                                      value;
                                                  boolean lacksClassfileRetention =
                                                    edu.umd.cs.findbugs.ba.AnalysisContext.
                                                    currentAnalysisContext(
                                                      ).
                                                    getAnnotationRetentionDatabase(
                                                      ).
                                                    lacksRuntimeRetention(
                                                      annotationClassName.
                                                        replace(
                                                          '/',
                                                          '.'));
                                                  if (lacksClassfileRetention) {
                                                      edu.umd.cs.findbugs.classfile.ClassDescriptor annotationClass =
                                                        edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                        createClassDescriptor(
                                                          annotationClassName);
                                                      accumulator.
                                                        accumulateBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "DMI_ANNOTATION_IS_NOT_VISIBLE_TO_REFLECTION",
                                                            HIGH_PRIORITY).
                                                            addClassAndMethod(
                                                              this).
                                                            addCalledMethod(
                                                              this).
                                                            addClass(
                                                              annotationClass).
                                                            describe(
                                                              edu.umd.cs.findbugs.ClassAnnotation.
                                                                ANNOTATION_ROLE),
                                                          this);
                                                  }
                                              }
                                          }
                                          if (seen ==
                                                INVOKEVIRTUAL &&
                                                "next".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                "()Ljava/lang/Object;".
                                                equals(
                                                  getSigConstantOperand(
                                                    )) &&
                                                "hasNext".
                                                equals(
                                                  getMethodName(
                                                    )) &&
                                                "()Z".
                                                equals(
                                                  getMethodSig(
                                                    )) &&
                                                stack.
                                                getStackDepth(
                                                  ) >
                                                0) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item item =
                                                stack.
                                                getStackItem(
                                                  0);
                                              accumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "DMI_CALLING_NEXT_FROM_HASNEXT",
                                                    item.
                                                      isInitialParameter(
                                                        ) &&
                                                      item.
                                                      getRegisterNumber(
                                                        ) ==
                                                      0
                                                      ? NORMAL_PRIORITY
                                                      : LOW_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addCalledMethod(
                                                      this),
                                                  this);
                                          }
                                          if (seen ==
                                                INVOKESPECIAL &&
                                                "java/lang/String".
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                "<init>".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                "(Ljava/lang/String;)V".
                                                equals(
                                                  getSigConstantOperand(
                                                    )) &&
                                                !edu.umd.cs.findbugs.ba.ch.Subtypes2.
                                                isJSP(
                                                  getThisClass(
                                                    ))) {
                                              accumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "DM_STRING_CTOR",
                                                    NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this),
                                                  this);
                                          }
                                          if (seen ==
                                                INVOKESTATIC &&
                                                "java/lang/System".
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                "runFinalizersOnExit".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) ||
                                                seen ==
                                                INVOKEVIRTUAL &&
                                                "java/lang/Runtime".
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                "runFinalizersOnExit".
                                                equals(
                                                  getNameConstantOperand(
                                                    ))) {
                                              accumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "DM_RUN_FINALIZERS_ON_EXIT",
                                                    HIGH_PRIORITY).
                                                    addClassAndMethod(
                                                      this),
                                                  this);
                                          }
                                          if (seen ==
                                                INVOKESPECIAL &&
                                                "java/lang/String".
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                "<init>".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                "()V".
                                                equals(
                                                  getSigConstantOperand(
                                                    ))) {
                                              accumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "DM_STRING_VOID_CTOR",
                                                    NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this),
                                                  this);
                                          }
                                          if (!isPublicStaticVoidMain &&
                                                seen ==
                                                INVOKESTATIC &&
                                                "java/lang/System".
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                "exit".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                !"processWindowEvent".
                                                equals(
                                                  getMethodName(
                                                    )) &&
                                                !getMethodName(
                                                   ).
                                                startsWith(
                                                  "windowClos") &&
                                                getMethodName(
                                                  ).
                                                indexOf(
                                                  "exit") ==
                                                -1 &&
                                                getMethodName(
                                                  ).
                                                indexOf(
                                                  "Exit") ==
                                                -1 &&
                                                getMethodName(
                                                  ).
                                                indexOf(
                                                  "crash") ==
                                                -1 &&
                                                getMethodName(
                                                  ).
                                                indexOf(
                                                  "Crash") ==
                                                -1 &&
                                                getMethodName(
                                                  ).
                                                indexOf(
                                                  "die") ==
                                                -1 &&
                                                getMethodName(
                                                  ).
                                                indexOf(
                                                  "Die") ==
                                                -1 &&
                                                getMethodName(
                                                  ).
                                                indexOf(
                                                  "main") ==
                                                -1) {
                                              accumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "DM_EXIT",
                                                    getMethod(
                                                      ).
                                                      isStatic(
                                                        )
                                                      ? LOW_PRIORITY
                                                      : NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this),
                                                  edu.umd.cs.findbugs.SourceLineAnnotation.
                                                    fromVisitedInstruction(
                                                      this));
                                          }
                                          if ((seen ==
                                                 INVOKESTATIC &&
                                                 "java/lang/System".
                                                 equals(
                                                   getClassConstantOperand(
                                                     )) ||
                                                 seen ==
                                                 INVOKEVIRTUAL &&
                                                 "java/lang/Runtime".
                                                 equals(
                                                   getClassConstantOperand(
                                                     ))) &&
                                                "gc".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                "()V".
                                                equals(
                                                  getSigConstantOperand(
                                                    )) &&
                                                !getDottedClassName(
                                                   ).
                                                startsWith(
                                                  "java.lang") &&
                                                !getMethodName(
                                                   ).
                                                startsWith(
                                                  "gc") &&
                                                !getMethodName(
                                                   ).
                                                endsWith(
                                                  "gc")) {
                                              if (gcInvocationBugReport ==
                                                    null) {
                                                  if (isPublicStaticVoidMain) {
                                                      return;
                                                  }
                                                  if (isTestMethod(
                                                        getMethod(
                                                          ))) {
                                                      return;
                                                  }
                                                  gcInvocationBugReport =
                                                    new edu.umd.cs.findbugs.BugInstance(
                                                      this,
                                                      "DM_GC",
                                                      HIGH_PRIORITY).
                                                      addClassAndMethod(
                                                        this).
                                                      addSourceLine(
                                                        this);
                                                  gcInvocationPC =
                                                    getPC(
                                                      );
                                              }
                                          }
                                          if (!isSynthetic &&
                                                seen ==
                                                INVOKESPECIAL &&
                                                "java/lang/Boolean".
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                "<init>".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                !"java/lang/Boolean".
                                                equals(
                                                  getClassName(
                                                    ))) {
                                              int majorVersion =
                                                getThisClass(
                                                  ).
                                                getMajor(
                                                  );
                                              if (majorVersion >=
                                                    MAJOR_1_4) {
                                                  accumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "DM_BOOLEAN_CTOR",
                                                        NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this),
                                                      this);
                                              }
                                          }
                                          if (seen ==
                                                INVOKESTATIC &&
                                                "java/lang/System".
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                ("currentTimeMillis".
                                                   equals(
                                                     getNameConstantOperand(
                                                       )) ||
                                                   "nanoTime".
                                                   equals(
                                                     getNameConstantOperand(
                                                       )))) {
                                              sawCurrentTimeMillis =
                                                true;
                                          }
                                          if (seen ==
                                                INVOKEVIRTUAL &&
                                                "java/lang/String".
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                "toString".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                "()Ljava/lang/String;".
                                                equals(
                                                  getSigConstantOperand(
                                                    ))) {
                                              accumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "DM_STRING_TOSTRING",
                                                    LOW_PRIORITY).
                                                    addClassAndMethod(
                                                      this),
                                                  this);
                                          }
                                          if (seen ==
                                                INVOKEVIRTUAL &&
                                                "java/lang/String".
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                ("toUpperCase".
                                                   equals(
                                                     getNameConstantOperand(
                                                       )) ||
                                                   "toLowerCase".
                                                   equals(
                                                     getNameConstantOperand(
                                                       ))) &&
                                                "()Ljava/lang/String;".
                                                equals(
                                                  getSigConstantOperand(
                                                    ))) {
                                              accumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "DM_CONVERT_CASE",
                                                    LOW_PRIORITY).
                                                    addClassAndMethod(
                                                      this),
                                                  this);
                                          }
                                          if (seen ==
                                                INVOKESPECIAL &&
                                                "<init>".
                                                equals(
                                                  getNameConstantOperand(
                                                    ))) {
                                              java.lang.String cls =
                                                getClassConstantOperand(
                                                  );
                                              java.lang.String sig =
                                                getSigConstantOperand(
                                                  );
                                              java.lang.String primitiveType =
                                                edu.umd.cs.findbugs.util.ClassName.
                                                getPrimitiveType(
                                                  cls);
                                              if (primitiveType !=
                                                    null &&
                                                    sig.
                                                    charAt(
                                                      1) ==
                                                    primitiveType.
                                                    charAt(
                                                      0)) {
                                                  primitiveObjCtorSeen =
                                                    cls;
                                              }
                                              else {
                                                  primitiveObjCtorSeen =
                                                    null;
                                              }
                                          }
                                          else
                                              if (primitiveObjCtorSeen !=
                                                    null &&
                                                    seen ==
                                                    INVOKEVIRTUAL &&
                                                    "toString".
                                                    equals(
                                                      getNameConstantOperand(
                                                        )) &&
                                                    getClassConstantOperand(
                                                      ).
                                                    equals(
                                                      primitiveObjCtorSeen) &&
                                                    "()Ljava/lang/String;".
                                                    equals(
                                                      getSigConstantOperand(
                                                        ))) {
                                                  edu.umd.cs.findbugs.BugInstance bug =
                                                    new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "DM_BOXED_PRIMITIVE_TOSTRING",
                                                    NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this).
                                                    addCalledMethod(
                                                      this);
                                                  edu.umd.cs.findbugs.MethodAnnotation preferred =
                                                    new edu.umd.cs.findbugs.MethodAnnotation(
                                                    edu.umd.cs.findbugs.util.ClassName.
                                                      toDottedClassName(
                                                        primitiveObjCtorSeen),
                                                    "toString",
                                                    "(" +
                                                    edu.umd.cs.findbugs.util.ClassName.
                                                      getPrimitiveType(
                                                        primitiveObjCtorSeen) +
                                                    ")Ljava/lang/String;",
                                                    true);
                                                  bug.
                                                    addMethod(
                                                      preferred).
                                                    describe(
                                                      edu.umd.cs.findbugs.MethodAnnotation.
                                                        SHOULD_CALL);
                                                  accumulator.
                                                    accumulateBug(
                                                      bug,
                                                      this);
                                                  primitiveObjCtorSeen =
                                                    null;
                                              }
                                              else {
                                                  primitiveObjCtorSeen =
                                                    null;
                                              }
                                          if (seen ==
                                                INVOKESPECIAL &&
                                                "<init>".
                                                equals(
                                                  getNameConstantOperand(
                                                    ))) {
                                              ctorSeen =
                                                true;
                                          }
                                          else
                                              if (ctorSeen &&
                                                    seen ==
                                                    INVOKEVIRTUAL &&
                                                    "java/lang/Object".
                                                    equals(
                                                      getClassConstantOperand(
                                                        )) &&
                                                    "getClass".
                                                    equals(
                                                      getNameConstantOperand(
                                                        )) &&
                                                    "()Ljava/lang/Class;".
                                                    equals(
                                                      getSigConstantOperand(
                                                        ))) {
                                                  accumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "DM_NEW_FOR_GETCLASS",
                                                        NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this),
                                                      this);
                                                  ctorSeen =
                                                    false;
                                              }
                                              else {
                                                  ctorSeen =
                                                    false;
                                              }
                                          if (seen ==
                                                INVOKEVIRTUAL &&
                                                isMonitorWait(
                                                  getNameConstantOperand(
                                                    ),
                                                  getSigConstantOperand(
                                                    ))) {
                                              checkMonitorWait(
                                                );
                                          }
                                          if (seen ==
                                                INVOKESPECIAL &&
                                                "<init>".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                "java/lang/Thread".
                                                equals(
                                                  getClassConstantOperand(
                                                    ))) {
                                              java.lang.String sig =
                                                getSigConstantOperand(
                                                  );
                                              if ("()V".
                                                    equals(
                                                      sig) ||
                                                    "(Ljava/lang/String;)V".
                                                    equals(
                                                      sig) ||
                                                    "(Ljava/lang/ThreadGroup;Ljava/lang/String;)V".
                                                    equals(
                                                      sig)) {
                                                  edu.umd.cs.findbugs.OpcodeStack.Item invokedOn =
                                                    stack.
                                                    getItemMethodInvokedOn(
                                                      this);
                                                  if (!"<init>".
                                                        equals(
                                                          getMethodName(
                                                            )) ||
                                                        invokedOn.
                                                        getRegisterNumber(
                                                          ) !=
                                                        0) {
                                                      accumulator.
                                                        accumulateBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "DM_USELESS_THREAD",
                                                            LOW_PRIORITY).
                                                            addClassAndMethod(
                                                              this),
                                                          this);
                                                  }
                                              }
                                          }
                                          if (seen ==
                                                INVOKESPECIAL &&
                                                "java/math/BigDecimal".
                                                equals(
                                                  getClassConstantOperand(
                                                    )) &&
                                                "<init>".
                                                equals(
                                                  getNameConstantOperand(
                                                    )) &&
                                                "(D)V".
                                                equals(
                                                  getSigConstantOperand(
                                                    ))) {
                                              edu.umd.cs.findbugs.OpcodeStack.Item top =
                                                stack.
                                                getStackItem(
                                                  0);
                                              java.lang.Object value =
                                                top.
                                                getConstant(
                                                  );
                                              if (value instanceof java.lang.Double &&
                                                    !((java.lang.Double)
                                                        value).
                                                    isInfinite(
                                                      ) &&
                                                    !((java.lang.Double)
                                                        value).
                                                    isNaN(
                                                      )) {
                                                  double arg =
                                                    ((java.lang.Double)
                                                       value).
                                                    doubleValue(
                                                      );
                                                  java.lang.String dblString =
                                                    java.lang.Double.
                                                    toString(
                                                      arg);
                                                  java.lang.String bigDecimalString =
                                                    new java.math.BigDecimal(
                                                    arg).
                                                    toString(
                                                      );
                                                  boolean ok =
                                                    dblString.
                                                    equals(
                                                      bigDecimalString) ||
                                                    dblString.
                                                    equals(
                                                      bigDecimalString +
                                                      ".0");
                                                  if (!ok) {
                                                      boolean scary =
                                                        dblString.
                                                        length(
                                                          ) <=
                                                        8 &&
                                                        bigDecimalString.
                                                        length(
                                                          ) >
                                                        12 &&
                                                        dblString.
                                                        toUpperCase(
                                                          ).
                                                        indexOf(
                                                          'E') ==
                                                        -1;
                                                      bugReporter.
                                                        reportBug(
                                                          new edu.umd.cs.findbugs.BugInstance(
                                                            this,
                                                            "DMI_BIGDECIMAL_CONSTRUCTED_FROM_DOUBLE",
                                                            scary
                                                              ? NORMAL_PRIORITY
                                                              : LOW_PRIORITY).
                                                            addClassAndMethod(
                                                              this).
                                                            addCalledMethod(
                                                              this).
                                                            addMethod(
                                                              "java.math.BigDecimal",
                                                              "valueOf",
                                                              "(D)Ljava/math/BigDecimal;",
                                                              true).
                                                            describe(
                                                              edu.umd.cs.findbugs.MethodAnnotation.
                                                                METHOD_ALTERNATIVE_TARGET).
                                                            addString(
                                                              dblString).
                                                            addString(
                                                              bigDecimalString).
                                                            addSourceLine(
                                                              this));
                                                  }
                                              }
                                          }
                                      }
                                      finally {
                                          prevOpcode =
                                            seen;
                                      } }
    private void checkForCompatibleLongComparison(edu.umd.cs.findbugs.OpcodeStack.Item left,
                                                  edu.umd.cs.findbugs.OpcodeStack.Item right) {
        if (left.
              getSpecialKind(
                ) ==
              edu.umd.cs.findbugs.OpcodeStack.Item.
                RESULT_OF_I2L &&
              right.
              getConstant(
                ) !=
              null) {
            long value =
              ((java.lang.Number)
                 right.
                 getConstant(
                   )).
              longValue(
                );
            if (value >
                  java.lang.Integer.
                    MAX_VALUE ||
                  value <
                  java.lang.Integer.
                    MIN_VALUE) {
                int priority =
                  edu.umd.cs.findbugs.Priorities.
                    HIGH_PRIORITY;
                if (value ==
                      java.lang.Integer.
                        MAX_VALUE +
                      1L ||
                      value ==
                      java.lang.Integer.
                        MIN_VALUE -
                      1L) {
                    priority =
                      edu.umd.cs.findbugs.Priorities.
                        NORMAL_PRIORITY;
                }
                java.lang.String stringValue =
                  edu.umd.cs.findbugs.IntAnnotation.
                  getShortInteger(
                    value) +
                "L";
                if (value ==
                      4294967295L) {
                    stringValue =
                      "0xffffffffL";
                }
                else
                    if (value ==
                          2147483648L) {
                        stringValue =
                          "0x80000000L";
                    }
                accumulator.
                  accumulateBug(
                    new edu.umd.cs.findbugs.BugInstance(
                      this,
                      "INT_BAD_COMPARISON_WITH_INT_VALUE",
                      priority).
                      addClassAndMethod(
                        this).
                      addString(
                        stringValue).
                      describe(
                        edu.umd.cs.findbugs.StringAnnotation.
                          STRING_NONSTRING_CONSTANT_ROLE).
                      addValueSource(
                        left,
                        this),
                    this);
            }
        }
    }
    private void reportVacuousBitOperation(int seen,
                                           edu.umd.cs.findbugs.OpcodeStack.Item item) {
        if (item.
              getConstant(
                ) ==
              null) {
            accumulator.
              accumulateBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "INT_VACUOUS_BIT_OPERATION",
                  NORMAL_PRIORITY).
                  addClassAndMethod(
                    this).
                  addString(
                    OPCODE_NAMES[seen]).
                  addOptionalAnnotation(
                    edu.umd.cs.findbugs.LocalVariableAnnotation.
                      getLocalVariableAnnotation(
                        getMethod(
                          ),
                        item,
                        getPC(
                          ))),
                this);
        }
    }
    private int stackEntryThatMustBeNonnegative(int seen) {
        switch (seen) {
            case INVOKEINTERFACE:
                if ("java/util/List".
                      equals(
                        getClassConstantOperand(
                          ))) {
                    return getStackEntryOfListCallThatMustBeNonnegative(
                             );
                }
                break;
            case INVOKEVIRTUAL:
                if ("java/util/LinkedList".
                      equals(
                        getClassConstantOperand(
                          )) ||
                      "java/util/ArrayList".
                      equals(
                        getClassConstantOperand(
                          ))) {
                    return getStackEntryOfListCallThatMustBeNonnegative(
                             );
                }
                break;
            case IALOAD:
            case AALOAD:
            case SALOAD:
            case CALOAD:
            case BALOAD:
            case LALOAD:
            case DALOAD:
            case FALOAD:
                return 0;
            case IASTORE:
            case AASTORE:
            case SASTORE:
            case CASTORE:
            case BASTORE:
            case LASTORE:
            case DASTORE:
            case FASTORE:
                return 1;
        }
        return -1;
    }
    private int getStackEntryOfListCallThatMustBeNonnegative() {
        java.lang.String name =
          getNameConstantOperand(
            );
        if (("add".
               equals(
                 name) ||
               "set".
               equals(
                 name)) &&
              getSigConstantOperand(
                ).
              startsWith(
                "(I")) {
            return 1;
        }
        if (("get".
               equals(
                 name) ||
               "remove".
               equals(
                 name)) &&
              getSigConstantOperand(
                ).
              startsWith(
                "(I)")) {
            return 0;
        }
        return -1;
    }
    private void checkMonitorWait() { try {
                                          edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow =
                                            getClassContext(
                                              ).
                                            getTypeDataflow(
                                              getMethod(
                                                ));
                                          edu.umd.cs.findbugs.ba.type.TypeDataflow.LocationAndFactPair pair =
                                            typeDataflow.
                                            getLocationAndFactForInstruction(
                                              getPC(
                                                ));
                                          if (pair ==
                                                null) {
                                              return;
                                          }
                                          org.apache.bcel.generic.Type receiver =
                                            pair.
                                              frame.
                                            getInstance(
                                              pair.
                                                location.
                                                getHandle(
                                                  ).
                                                getInstruction(
                                                  ),
                                              getClassContext(
                                                ).
                                                getConstantPoolGen(
                                                  ));
                                          if (!(receiver instanceof org.apache.bcel.generic.ReferenceType)) {
                                              return;
                                          }
                                          if (edu.umd.cs.findbugs.ba.Hierarchy.
                                                isSubtype(
                                                  (org.apache.bcel.generic.ReferenceType)
                                                    receiver,
                                                  CONDITION_TYPE)) {
                                              accumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "DM_MONITOR_WAIT_ON_CONDITION",
                                                    HIGH_PRIORITY).
                                                    addClassAndMethod(
                                                      this),
                                                  this);
                                          }
                                      }
                                      catch (java.lang.ClassNotFoundException e) {
                                          bugReporter.
                                            reportMissingClass(
                                              e);
                                      }
                                      catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                                          bugReporter.
                                            logError(
                                              "Exception caught by DumbMethods",
                                              e);
                                      }
                                      catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                                          bugReporter.
                                            logError(
                                              "Exception caught by DumbMethods",
                                              e);
                                      } }
    private boolean isMonitorWait(java.lang.String name,
                                  java.lang.String sig) {
        return "wait".
          equals(
            name) &&
          ("()V".
             equals(
               sig) ||
             "(J)V".
             equals(
               sig) ||
             "(JI)V".
             equals(
               sig));
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        super.
          visit(
            obj);
        flush(
          );
    }
    private void flush() { if (pendingAbsoluteValueBug !=
                                 null) { absoluteValueAccumulator.
                                           accumulateBug(
                                             pendingAbsoluteValueBug,
                                             pendingAbsoluteValueBugSourceLine);
                                         pendingAbsoluteValueBug =
                                           null;
                                         pendingAbsoluteValueBugSourceLine =
                                           null;
                           }
                           accumulator.reportAccumulatedBugs(
                                         );
                           if (sawLoadOfMinValue) {
                               absoluteValueAccumulator.
                                 clearBugs(
                                   );
                           }
                           else {
                               absoluteValueAccumulator.
                                 reportAccumulatedBugs(
                                   );
                           }
                           if (gcInvocationBugReport !=
                                 null &&
                                 !sawCurrentTimeMillis) {
                               boolean outOfMemoryHandler =
                                 false;
                               for (org.apache.bcel.classfile.CodeException handler
                                     :
                                     exceptionTable) {
                                   if (gcInvocationPC <
                                         handler.
                                         getHandlerPC(
                                           ) ||
                                         gcInvocationPC >
                                         handler.
                                         getHandlerPC(
                                           ) +
                                         OOM_CATCH_LEN) {
                                       continue;
                                   }
                                   int catchTypeIndex =
                                     handler.
                                     getCatchType(
                                       );
                                   if (catchTypeIndex >
                                         0) {
                                       org.apache.bcel.classfile.ConstantPool cp =
                                         getThisClass(
                                           ).
                                         getConstantPool(
                                           );
                                       org.apache.bcel.classfile.Constant constant =
                                         cp.
                                         getConstant(
                                           catchTypeIndex);
                                       if (constant instanceof org.apache.bcel.classfile.ConstantClass) {
                                           java.lang.String exClassName =
                                             (java.lang.String)
                                               ((org.apache.bcel.classfile.ConstantClass)
                                                  constant).
                                               getConstantValue(
                                                 cp);
                                           if ("java/lang/OutOfMemoryError".
                                                 equals(
                                                   exClassName)) {
                                               outOfMemoryHandler =
                                                 true;
                                               break;
                                           }
                                       }
                                   }
                               }
                               if (!outOfMemoryHandler) {
                                   bugReporter.
                                     reportBug(
                                       gcInvocationBugReport);
                               }
                           }
                           sawCurrentTimeMillis =
                             false;
                           gcInvocationBugReport =
                             null;
                           exceptionTable =
                             null; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xTKD+3IqqFjkp9Oi3E9TeJX5P6EOPnFcQAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "395MgK+Lwz7S3FQxuMYzgwVhiAhJiqs2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
