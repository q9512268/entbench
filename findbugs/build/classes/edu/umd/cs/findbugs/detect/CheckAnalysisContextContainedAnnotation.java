package edu.umd.cs.findbugs.detect;
public class CheckAnalysisContextContainedAnnotation extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector.WithCustomJumpInfo {
    final edu.umd.cs.findbugs.BugReporter bugReporter;
    final edu.umd.cs.findbugs.BugAccumulator accumulator;
    private final boolean testingEnabled;
    public CheckAnalysisContextContainedAnnotation(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          accumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
        testingEnabled =
          edu.umd.cs.findbugs.SystemProperties.
            getBoolean(
              "report_TESTING_pattern_in_standard_detectors");
    }
    static final edu.umd.cs.findbugs.classfile.ClassDescriptor ConstantAnnotation =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        edu.umd.cs.findbugs.internalAnnotations.StaticConstant.class);
    static final edu.umd.cs.findbugs.classfile.ClassDescriptor
      AnalysisContextContainedAnnotation =
      edu.umd.cs.findbugs.classfile.DescriptorFactory.
      createClassDescriptor(
        edu.umd.cs.findbugs.internalAnnotations.AnalysisContextContained.class);
    private boolean analysisContextContained(edu.umd.cs.findbugs.ba.XClass xclass) {
        edu.umd.cs.findbugs.classfile.analysis.AnnotatedObject ao =
          xclass;
        do  {
            if (ao.
                  getAnnotation(
                    AnalysisContextContainedAnnotation) !=
                  null) {
                return true;
            }
            ao =
              ao.
                getContainingScope(
                  );
        }while(ao !=
                 null); 
        return false;
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Field field) {
        if (!field.
              isStatic(
                )) {
            return;
        }
        java.lang.String signature =
          field.
          getSignature(
            );
        if (signature.
              startsWith(
                "Ljava/util/") &&
              !"Ljava/util/regex/Pattern;".
              equals(
                signature) &&
              !"Ljava/util/logging/Logger;".
              equals(
                signature) &&
              !"Ljava/util/BitSet;".
              equals(
                signature) &&
              !"Ljava/util/ResourceBundle;".
              equals(
                signature) &&
              !"Ljava/util/Comparator;".
              equals(
                signature) &&
              getXField(
                ).
              getAnnotation(
                ConstantAnnotation) ==
              null) {
            boolean flagged =
              analysisContextContained(
                getXClass(
                  ));
            bugReporter.
              reportBug(
                new edu.umd.cs.findbugs.BugInstance(
                  this,
                  "TESTING",
                  flagged
                    ? NORMAL_PRIORITY
                    : LOW_PRIORITY).
                  addClass(
                    this).
                  addField(
                    this).
                  addType(
                    signature));
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code code) {
        boolean interesting =
          testingEnabled;
        if (interesting) {
            super.
              visit(
                code);
        }
        accumulator.
          reportAccumulatedBugs(
            );
    }
    @java.lang.Override
    public void sawOpcode(int seen) { switch (seen) {
                                          default:
                                              break;
                                          case org.apache.bcel.Constants.
                                                 IF_ICMPEQ:
                                          case org.apache.bcel.Constants.
                                                 IF_ICMPNE:
                                              edu.umd.cs.findbugs.OpcodeStack.Item left =
                                                stack.
                                                getStackItem(
                                                  1);
                                              edu.umd.cs.findbugs.OpcodeStack.Item right =
                                                stack.
                                                getStackItem(
                                                  0);
                                              if (bad(
                                                    left,
                                                    right) ||
                                                    bad(
                                                      right,
                                                      left)) {
                                                  accumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "TESTING",
                                                        NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this).
                                                        addValueSource(
                                                          left,
                                                          this).
                                                        addValueSource(
                                                          right,
                                                          this).
                                                        addString(
                                                          ("Just check the sign of the result of compare or compareTo, n" +
                                                           "ot specific values such as 1 or -1")),
                                                      this);
                                              }
                                              break;
                                      } }
    private boolean bad(edu.umd.cs.findbugs.OpcodeStack.Item left,
                        edu.umd.cs.findbugs.OpcodeStack.Item right) {
        edu.umd.cs.findbugs.ba.XMethod m =
          left.
          getReturnValueOf(
            );
        if (m ==
              null) {
            return false;
        }
        java.lang.Object value =
          right.
          getConstant(
            );
        if (!(value instanceof java.lang.Integer) ||
              ((java.lang.Integer)
                 value).
              intValue(
                ) ==
              0) {
            return false;
        }
        if (m.
              isStatic(
                ) ||
              !m.
              isPublic(
                )) {
            return false;
        }
        if ("compareTo".
              equals(
                m.
                  getName(
                    )) &&
              "(Ljava/lang/Object;)I".
              equals(
                m.
                  getSignature(
                    ))) {
            return true;
        }
        if ("compare".
              equals(
                m.
                  getName(
                    )) &&
              "(Ljava/lang/Object;Ljava/lang/Object;)I".
              equals(
                m.
                  getSignature(
                    ))) {
            return true;
        }
        return false;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.OpcodeStack.JumpInfo customJumpInfo() {
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMUZaZAU1fnNLHuwu+zFKcICy6IBcQaNGsmisgyLLA7sFosk" +
       "GSLLm543u832dLfdr3dnMRgllZKkKhQqIkmU/MFojIpJxRzlUViWUUtNlcZE" +
       "Tcojt8ZYSqXUVEw03/e6e/qY6QEqHlvVb9+8972vv/t4fdebpNY0SCdTeYJP" +
       "6sxM9Kl8kBomy6UUappbYG1YurmG/nP7a5tWxkldhrSMUnOjRE22TmZKzsyQ" +
       "+bJqcqpKzNzEWA5PDBrMZMY45bKmZshM2ewv6IosyXyjlmMIsJUaadJOOTfk" +
       "rMVZv4OAk/lpoCQpKEn2hrd70qRZ0vRJD3yODzzl20HIgvcuk5O29E46TpMW" +
       "l5VkWjZ5T9EgZ+maMjmiaDzBijyxUznfEcGG9PllIui6t/Xd9/ePtgkRTKeq" +
       "qnHBnrmZmZoyznJp0uqt9imsYF5JriY1adLkA+akO+2+NAkvTcJLXW49KKB+" +
       "GlOtQkoT7HAXU50uIUGcLAoi0alBCw6aQUEzYGjgDu/iMHC7sMStzWUZized" +
       "lTxw8/a2H9eQ1gxpldUhJEcCIji8JAMCZYUsM8zeXI7lMqRdBWUPMUOmirzL" +
       "0XSHKY+olFugflcsuGjpzBDv9GQFegTeDEvimlFiLy8MyvlVm1foCPA6y+PV" +
       "5nAdrgODjTIQZuQp2J1zZMqYrOY4WRA+UeKx+zIAgKP1BcZHtdKrpqgUFkiH" +
       "bSIKVUeSQ2B66giA1mpggAYncyORoqx1Ko3RETaMFhmCG7S3AGqqEAQe4WRm" +
       "GExgAi3NDWnJp583N63ad5W6Xo2TGNCcY5KC9DfBoc7Qoc0szwwGfmAfbF6W" +
       "PkhnPbg3TggAzwwB2zA/+8rx1cs7jz1uw5xeAWYgu5NJfFg6km15Zl5q6coa" +
       "JKNB10wZlR/gXHjZoLPTU9QhwswqYcTNhLt5bPMvv3TNneyNOGnsJ3WSplgF" +
       "sKN2SSvossKMS5nKDMpZrp9MZWouJfb7ST3M07LK7NWBfN5kvJ9MUcRSnSZ+" +
       "g4jygAJF1AhzWc1r7lynfFTMizohpB4e0gzPMmL/if+cTCZHtQJLUomqsqol" +
       "Bw0N+TeTEHGyINvRZB6MKWuNmEnTkJLCdFjOSlqFXFIyvc0c43AsmRpl0liv" +
       "SpVJUzYdn8J/FGjOeb6fQDz6p/nyIkpm+kQsBkqbFw4ZCnjbek3JMWNYOmCt" +
       "6Tt+z/CTtjmiCzky5WQN0JIAWhKSmXBpSdi0JE6SFhKLCRJmIE22zYDGxyB2" +
       "QPBuXjp0xYYde7tqwFj1iSmgLgTtCiSxlBdg3KwwLB3tmLZr0cvnPBInU9Kk" +
       "g0rcogrmpF5jBKKdNOYEhOYspDcvyyz0ZRlMj4YmAYMGi8o2DpYGbZwZuM7J" +
       "DB8GNweityejM1BF+smxQxPXbv3qijiJBxMLvrIWYiIeH8R0UAr73eGAUglv" +
       "63WvvXv04G7NCy2BTOUm2LKTyENX2EjC4hmWli2k9w0/uLtbiH2q5Ggbompn" +
       "+B2ByNXjZgHkpQEYzmtGgSq45cq4kY8a2oS3Iqy3XcxngFk0oSuf6zzunODu" +
       "LB3H2ba1o52FuBBZ5qIh/dYXfvX6Z4W43YTU6qskhhjv8QVBRNYhwl27Z7Zb" +
       "DMYA7qVDgzfe9OZ124TNAsTiSi/sxjEFwQ9UCGL++uNXvvjKy0eei3t2zqEK" +
       "sLJQTBVLTOI6aazCJLztDI8eCKIKOCJaTfflKtinnJdpVmHoWP9pXXLOff/Y" +
       "12bbgQIrrhktPzECb/20NeSaJ7e/1ynQxCRM4p7MPDA7M0z3MPcaBp1EOorX" +
       "Pjv/24/RWyHHQFw35V1MhOqY4+tI1BxI9JXCzBprZDPTNQOytlDu+QJ6hRjP" +
       "Q8EIHETsrcRhiel3kqAf+oqyYWn/c29P2/r2Q8cFV8Gqzm8TG6neY5shDmcU" +
       "Af3scBBbT81RgDvv2KYvtynH3geMGcAoQSljDhgQXYsBC3Kga+t/9/Ajs3Y8" +
       "U0Pi60ijotHcOiqckUwFL2DmKATmon7JatsIJhpgaBOskjLmyxZQEQsqq7iv" +
       "oHOhlF0/n/2TVbcffllYo27jOF2cxxZiXiD6it7ACwB3/vpzv7n9+oMTdnWx" +
       "NDrqhc7N+feAkt3zx3+ViVzEuwqVT+h8JnnXLXNTF78hznuBB093F8vzGwRv" +
       "7+y5dxbeiXfVPRon9RnSJjm1+FaqWOjOGag/TbdAh3o9sB+sJe3CqacUWOeF" +
       "g57vteGQ5+VVmCM0zqeFohz6PumCZ7kTAJaHo1yMiMll4siZYlyGw9luUKkF" +
       "/6FKKKZMrYKSk6as52m4dIEdSnH8PA5pG9tFkQbZF2RgCTwJ522JCAa22Azg" +
       "sKmc1qjTXPiWVbAU6rYbED26IqJHrwca4ujyk+eoA1eXwrPCoWlFBEdXVFZJ" +
       "nJN63ZChhRYaHwhppr0KZk5aODM5tC99KoblXLA0wvJjyMqaUMbIBcha406T" +
       "cO7gDmlv9+CfbRc9rcIBG27mHclvbX1+51MiJzZgobTFNUtfGQQFlS8ht9nU" +
       "fwh/MXg+wAepxgX8D/6Scir+haWSH0NM1VgRYiC5u+OVsVteu9tmIBwYQsBs" +
       "74FvfpjYd8BOdHbfuLisdfOfsXtHmx0cRpC6RdXeIk6s+9vR3fffsfs6m6qO" +
       "YBfUB03+3b/971OJQ68+UaGMrs9qmsKoWorWsVKtOyOoH5uptd9ofWB/R806" +
       "KLP6SYOlyldarD8XDCL1ppX1KczrSb3A4rCHyuEktgz0EPKD7SfvB+22egm5" +
       "0LHWCyP8YCLSD+pMcQ9RyQ3aqiAWNmXH5N5g3gDfP7uS74vLFewZ7aZ7LTMl" +
       "Q9bLw0DxFNnfB89Kh8qVEezviWAfp1dFsR6FFGLbiRsshLw6xNnXqnBW9ELv" +
       "WSVSxF8dCfXO/tLTKxIIOsz8qOsN4SxH9hw4nBu47Zy4U5+pHEobTT9bYeNM" +
       "8aGqQ0yBemOjuNDxkvdLLTf86RfdI2tOpdHDtc4TtHL4ewE48rLosBQm5bE9" +
       "f5+75eLRHafQsy0ISSmM8gcb73ri0jOkG+Li9squKspuvYKHeoJhoNFg3DLU" +
       "oOMvLulV6BZT/ipHr6vCdutZTnk5gVMastemKshCFXqoyp9fyVezNPFFYTuC" +
       "kO9WqfG/h8NNnMyhES6B+3nPBw6eyLur19G4kNLF+vXBNhQLtH5HAv2nKs5E" +
       "hXYvCll1cS7QjJEE1ak0yhJZiSm+sCeKZ0HKD6sI9CgOt0HJOC5D1ytAZCch" +
       "4r8CJ1PGNTnnSfT7QYk2lyRaoqlDdB5YLCcGwNEMOceqBKL/Tw0L4ck4kst8" +
       "FGqIQlZdDZ3RakhBnBGUPFxFC4/icL+rBfzxI0/iD0RKHJd/+rHJdjE8OUcc" +
       "uY9CtlHIqsg257PFkF3WyM63FN8Z/GkWBXHPVhH3izg8BenIpBMDuuRkAp/I" +
       "n/7kRS6C9Gx4xh0pjVcROQ6HykNy1NGQKOJ2NeIab3elkGyLRWTX7n7OCgj7" +
       "V0HCX6oI9nUcXgXdZGk4Ev/hY4jEQmYYifc7jO//KMw0ClkVvt+psvceDm9B" +
       "HydZJtcKG6yC3q/mNVf6nzmR9AMHhCjf/gSss8jJmSd5uY+3TXPKPkfan9Ck" +
       "ew63Nsw+fPnzonQrfeZqhiIsbymK/z7EN6/TDZaXhfSa7dsR0bXEoH+YG/0x" +
       "ApoLe4I8xWL2kVpOplc4wuH9ztQP3cBJowfNSVwKbDdBF+dsg43D6N9sgSXY" +
       "xGmr7mr3korlDmYIn4rXCqo1o/sLMh9NBaykGAvW3CUbmHkid/KV6YsD5a34" +
       "vuyWopb9hXlYOnp4w6arjl9wm305Dulr1y7E0gQ9pn1PXypnF0Vic3HVrV/6" +
       "fsu9U5e4hX+7TbDni6f73CMFZqujCc0N3Ryb3aUL5BePrHro6b11z0JXvY3E" +
       "KKh0W/mNXFG3oI/Yli7vpaH0F1faPUu/M3nx8vxbvxd3nsTuvedFww9LmRtf" +
       "6L937L3V4oNmLeiPFcVV4dpJdTOTxo1AY96C1k3xS7OQgyO+aaVV/JQCzVz5" +
       "vUT5B6hGRZtgxhrNUkUYhda+yVtx25hAB2DpeuiAt+KoDkfDzqEofTDX4fRG" +
       "XXeubeIf6ML1zco5Fc26S0xxtvh/K55t/WoiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pVd+9o3fL0/8/h8sEMCFWy0AAA==");
}
