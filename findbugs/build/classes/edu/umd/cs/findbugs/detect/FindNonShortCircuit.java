package edu.umd.cs.findbugs.detect;
public class FindNonShortCircuit extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector implements edu.umd.cs.findbugs.StatelessDetector {
    int stage1 = 0;
    int stage2 = 0;
    int distance = 0;
    int operator;
    boolean sawDanger;
    boolean sawNullTestOld;
    boolean sawNullTestVeryOld;
    boolean sawNullTest;
    boolean sawDangerOld;
    boolean sawNumericTest;
    boolean sawNumericTestOld;
    boolean sawNumericTestVeryOld;
    boolean sawArrayDanger;
    boolean sawArrayDangerOld;
    boolean sawMethodCall;
    boolean sawMethodCallOld;
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    public FindNonShortCircuit(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) { clearAll();
                                                              prevOpcode =
                                                                NOP; }
    private void clearAll() { stage1 = 0;
                              stage2 = 0;
                              distance = 1000000;
                              sawArrayDanger = (sawArrayDangerOld = false);
                              sawDanger = (sawDangerOld = false);
                              sawMethodCall = (sawMethodCallOld = false);
                              sawNullTest = (sawNullTestOld = (sawNullTestVeryOld =
                                                                 false));
                              sawNumericTest = (sawNumericTestOld =
                                                  (sawNumericTestVeryOld =
                                                     false)); }
    int prevOpcode;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code code) { super.
                                                               visit(
                                                                 code);
                                                             bugAccumulator.
                                                               reportAccumulatedBugs(
                                                                 );
    }
    @java.lang.Override
    public void sawOpcode(int seen) { distance++;
                                      scanForBooleanValue(
                                        seen);
                                      scanForDanger(seen);
                                      scanForShortCircuit(
                                        seen);
                                      prevOpcode = seen; }
    private void scanForDanger(int seen) { switch (seen) {
                                               case AALOAD:
                                               case BALOAD:
                                               case SALOAD:
                                               case CALOAD:
                                               case IALOAD:
                                               case LALOAD:
                                               case FALOAD:
                                               case DALOAD:
                                                   sawArrayDanger =
                                                     true;
                                                   sawDanger =
                                                     true;
                                                   break;
                                               case INVOKEVIRTUAL:
                                                   if ("length".
                                                         equals(
                                                           getNameConstantOperand(
                                                             )) &&
                                                         "java/lang/String".
                                                         equals(
                                                           getClassConstantOperand(
                                                             ))) {
                                                       break;
                                                   }
                                                   sawDanger =
                                                     true;
                                                   sawMethodCall =
                                                     true;
                                                   break;
                                               case INVOKEINTERFACE:
                                               case INVOKESPECIAL:
                                               case INVOKESTATIC:
                                                   sawDanger =
                                                     true;
                                                   sawMethodCall =
                                                     true;
                                                   break;
                                               case IDIV:
                                               case IREM:
                                               case LDIV:
                                               case LREM:
                                                   sawDanger =
                                                     true;
                                                   break;
                                               case ARRAYLENGTH:
                                               case GETFIELD:
                                                   break;
                                               default:
                                                   break;
                                           }
    }
    private void scanForShortCircuit(int seen) {
        switch (seen) {
            case IAND:
            case IOR:
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
                        ) ==
                      null &&
                      item1.
                      getConstant(
                        ) ==
                      null &&
                      distance <
                      4) {
                    operator =
                      seen;
                    stage2 =
                      1;
                }
                else {
                    stage2 =
                      0;
                }
                break;
            case IFEQ:
            case IFNE:
                if (stage2 ==
                      1) {
                    reportBug(
                      );
                }
                stage2 =
                  0;
                break;
            case PUTFIELD:
            case PUTSTATIC:
            case IRETURN:
                if (operator ==
                      IAND &&
                      stage2 ==
                      1) {
                    reportBug(
                      );
                }
                stage2 =
                  0;
                break;
            default:
                stage2 =
                  0;
                break;
        }
    }
    private void reportBug() { int priority =
                                 LOW_PRIORITY;
                               java.lang.String pattern =
                                 "NS_NON_SHORT_CIRCUIT";
                               if (sawDangerOld) {
                                   if (sawNullTestVeryOld) {
                                       priority =
                                         HIGH_PRIORITY;
                                   }
                                   if (sawMethodCallOld ||
                                         sawNumericTestVeryOld &&
                                         sawArrayDangerOld) {
                                       priority =
                                         HIGH_PRIORITY;
                                       pattern =
                                         "NS_DANGEROUS_NON_SHORT_CIRCUIT";
                                   }
                                   else {
                                       priority =
                                         NORMAL_PRIORITY;
                                   }
                               }
                               bugAccumulator.
                                 accumulateBug(
                                   new edu.umd.cs.findbugs.BugInstance(
                                     this,
                                     pattern,
                                     priority).
                                     addClassAndMethod(
                                       this),
                                   this);
    }
    private void scanForBooleanValue(int seen) {
        switch (seen) {
            case IAND:
            case IOR:
                switch (prevOpcode) {
                    case ILOAD:
                    case ILOAD_0:
                    case ILOAD_1:
                    case ILOAD_2:
                    case ILOAD_3:
                        clearAll(
                          );
                        break;
                    default:
                        break;
                }
                break;
            case ICONST_1:
                stage1 =
                  1;
                switch (prevOpcode) {
                    case IFNONNULL:
                    case IFNULL:
                        sawNullTest =
                          true;
                        break;
                    case IF_ICMPGT:
                    case IF_ICMPGE:
                    case IF_ICMPLT:
                    case IF_ICMPLE:
                        sawNumericTest =
                          true;
                        break;
                }
                break;
            case GOTO:
                if (stage1 ==
                      1) {
                    stage1 =
                      2;
                }
                else {
                    stage1 =
                      0;
                    clearAll(
                      );
                }
                break;
            case ICONST_0:
                if (stage1 ==
                      2) {
                    sawBooleanValue(
                      );
                }
                stage1 =
                  0;
                break;
            case INVOKEINTERFACE:
            case INVOKEVIRTUAL:
            case INVOKESPECIAL:
            case INVOKESTATIC:
                java.lang.String sig =
                  getSigConstantOperand(
                    );
                if (sig.
                      endsWith(
                        ")Z")) {
                    sawBooleanValue(
                      );
                }
                stage1 =
                  0;
                break;
            default:
                stage1 =
                  0;
        }
    }
    private void sawBooleanValue() { sawMethodCallOld =
                                       sawMethodCall;
                                     sawDangerOld =
                                       sawDanger;
                                     sawArrayDangerOld =
                                       sawArrayDanger;
                                     sawNullTestVeryOld =
                                       sawNullTestOld;
                                     sawNullTestOld =
                                       sawNullTest;
                                     sawNumericTestVeryOld =
                                       sawNumericTestOld;
                                     sawNumericTestOld =
                                       sawNumericTest;
                                     sawNumericTest =
                                       false;
                                     sawDanger =
                                       false;
                                     sawArrayDanger =
                                       false;
                                     sawMethodCall =
                                       false;
                                     distance =
                                       0;
                                     stage1 =
                                       0;
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
       "gk8Umx9IS23YqpEZm0zEOLbwQXOJLXxRNii63orhUFeWGKH24W4frlHWLGQH" +
       "LZuZbCkvwlZDFgmqw7bXptqNNipOVwt022qHXTxyfEKS6VT1o6gHeVqNVXpS" +
       "NCu7lUbVmxDraRj1KIwDi858Y5FhbSPwrl3b0IxRrzKhAfFZkCgJP4ExH2s6" +
       "giZ6Gm1QhMgoGLPCJQ5fWCFPOZlK08IqsVYD3V7arGVvgw0dyGMv6cXkjE9F" +
       "wYMqSkb129V6k6wC1VbMaI6P+mWmPB5gbX2arQc+ShmQ5Ezb7XqrXFvQy96M" +
       "0LOqQY0yqF2LAxNpQU6bYBKjHC5Hlcaqz6dWualXKMTS25keGylNTdjYM9do" +
       "2YgrKxjieJ6XKR4srYToiKNqZPX5diVZLdQI7ozIpTNMtrQ+S+ROmcMq000F" +
       "DuohvW6NolYW9iEnmUb+muyvjR5kteq9Vsc1sEp50zBJGXIa0RDy6F4vczWn" +
       "maQDLg7xuiONK72ZabSwoNuvTHWStOFYDuHadkb1x1yCsgKcbdRpnVfWDpiL" +
       "LSNVRWPi99B2L84MaEtCsVFfc8O2Mpok63oFno1qClPLRtRCM9gqBqFeS9D5" +
       "JoU3WaJjkWRfmSGRjosG3qEtK16ZowbWWEdKve0gbSTiOxuqBSdKOELbA4Mf" +
       "jGp0ZbTxasyC7MHjCb4OBGJuCShlZ3A33qYR0UWElq4uyvX2FoKQEJNDcrO2" +
       "GmRTgHAEqtVhzdYgJLEEBpPoqT2nxwqPNSb9CO8kQrejGFWyPm4De5v5Jl1D" +
       "ltWR4oYsHwT1YBgOoijZjucIq464cXUyViseZtIIoeAUbcVEa51FY5PuIBuz" +
       "Qjkxkyk1ItI60obhprLgBzVemEiZMdSGcLna5Nf1oM2R7pwbGGjUpucyOUYz" +
       "tmZx9MAnZWfAtHqOgzIrx3Qr6LyReQw16KDYyjLpvm/KZrIk4D7BMSti7FZY" +
       "bxNSMilZFVTrbMYyhlbRVjIRQr2zac47lWWitWcLqLyor8WxvBqHq2S89DJ2" +
       "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" +
       "wc9VL+8fgnJx6VrsBz8KJqXuHBv4Gujp");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("pfNjCnaH00fBGr/+6f/y9OjHrNfuIVTt2VM4T3f589xXv0l+WP2rl0v3HYZu" +
       "3BH9erLRKycDNq6HepyE3uhE2MYHDuVQhIs9Dy50Xw7o6VPkI0nfoTOXCp3Z" +
       "aUpRdhRzdCpu6Tk/NPfkQFYtfU9RdWeviHPOwzf3SS46+eNTnRwLXLp0Oc/8" +
       "X3HpgbUd2fGZp6Rr39aOVPKPTqrkw4cqeQjq1tHx7mCth6Gt6XfR4jtDioqM" +
       "7x+y8uE8M3/TTeyzkrhXVv6TM1l5nAu37lL2njx5JC5dVR1dDtHiRc6l+w8Z" +
       "cunRi06M70LbQwdTdLRP2+hdUZNnzleTjq/pBZnP3IUFL+TJ+w6U5BT9T5+r" +
       "EHnptR9G9AV7Pgiu+T575u8oe/JHpiDwR+9CPJQnH9lFdBy+zjnOgBffPQYU" +
       "up/HxFj7DLDeGd2/gwEfvQsD8jcel+D8daYqe4QfHr7+Pc6E5g8xCwoq8/I3" +
       "9ql8412ikrgLlbnVu4TGpcf3qTwej32K1gsDwC6i9f3g+sY+rd94Z2g9Topw" +
       "l7JRnuQLc1iEtmKJeYq4/jshyG/tE/etd0mQn7gLha/lyexIkNgu1KoI3jxF" +
       "64WRahfR+gJAdWPXdvf/zgpycZeyYhnS49INYJbuQqJxLySmgGtnfI6Qx1Y/" +
       "dcdHULsPd9RffPPG1fe+Of7XRUT+4cc119jSVSNxnOMhrsfurwShbtgF/dd2" +
       "Aa9BQVQUl54+/1OJuHRld5MDvxTumqwB5jOagPX64PZ47W1cun5UOy5dVk8U" +
       "/0RcenC/OC7dB9LjhZ8EWaAwv/1UcLC0vnwW3GKN3a0VwI1Wl4cu9KVjXvC+" +
       "RhVO1a2LpHTY5Hi4f+45F5+wHXi5ye4jtlfVr73Z6//495o/t/vcAKz2WZb3" +
       "cpUtPbj78uHQU37+3N4O+rpCvfiDR79+7UMHXv2jO8BH2n0M27Nnx/Z33SAu" +
       "ovGzX3nvP/jY33nzd4sX/f8XPLqpuFs4AAA=");
}
