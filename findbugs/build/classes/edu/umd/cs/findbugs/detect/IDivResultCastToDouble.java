package edu.umd.cs.findbugs.detect;
public class IDivResultCastToDouble extends edu.umd.cs.findbugs.BytecodeScanningDetector {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "idcd.debug");
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    private int prevOpCode;
    public IDivResultCastToDouble(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) { if (DEBUG) {
                                                                  java.lang.System.
                                                                    out.
                                                                    println(
                                                                      "Visiting " +
                                                                      obj);
                                                              }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        super.
          visit(
            obj);
        bugAccumulator.
          reportAccumulatedBugs(
            );
    }
    edu.umd.cs.findbugs.SourceLineAnnotation pendingIdivCastToDivBugLocation =
      null;
    @java.lang.Override
    public void sawOpcode(int seen) { if (DEBUG) { java.lang.System.
                                                     out.
                                                     println(
                                                       "Saw opcode " +
                                                       OPCODE_NAMES[seen] +
                                                       " " +
                                                       pendingIdivCastToDivBugLocation);
                                      }
                                      if ((prevOpCode ==
                                             I2D ||
                                             prevOpCode ==
                                             L2D) &&
                                            seen ==
                                            INVOKESTATIC &&
                                            edu.umd.cs.findbugs.util.ClassName.
                                            isMathClass(
                                              getClassConstantOperand(
                                                )) &&
                                            "ceil".
                                            equals(
                                              getNameConstantOperand(
                                                ))) {
                                          bugAccumulator.
                                            accumulateBug(
                                              new edu.umd.cs.findbugs.BugInstance(
                                                this,
                                                "ICAST_INT_CAST_TO_DOUBLE_PASSED_TO_CEIL",
                                                HIGH_PRIORITY).
                                                addClassAndMethod(
                                                  this),
                                              this);
                                          pendingIdivCastToDivBugLocation =
                                            null;
                                      }
                                      else
                                          if ((prevOpCode ==
                                                 I2F ||
                                                 prevOpCode ==
                                                 L2F) &&
                                                seen ==
                                                INVOKESTATIC &&
                                                edu.umd.cs.findbugs.util.ClassName.
                                                isMathClass(
                                                  getClassConstantOperand(
                                                    )) &&
                                                "round".
                                                equals(
                                                  getNameConstantOperand(
                                                    ))) {
                                              bugAccumulator.
                                                accumulateBug(
                                                  new edu.umd.cs.findbugs.BugInstance(
                                                    this,
                                                    "ICAST_INT_CAST_TO_FLOAT_PASSED_TO_ROUND",
                                                    NORMAL_PRIORITY).
                                                    addClassAndMethod(
                                                      this),
                                                  this);
                                              pendingIdivCastToDivBugLocation =
                                                null;
                                          }
                                          else
                                              if (pendingIdivCastToDivBugLocation !=
                                                    null) {
                                                  bugAccumulator.
                                                    accumulateBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "ICAST_IDIV_CAST_TO_DOUBLE",
                                                        NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this),
                                                      pendingIdivCastToDivBugLocation);
                                                  pendingIdivCastToDivBugLocation =
                                                    null;
                                              }
                                      if (prevOpCode ==
                                            IDIV &&
                                            (seen ==
                                               I2D ||
                                               seen ==
                                               I2F) ||
                                            prevOpCode ==
                                            LDIV &&
                                            (seen ==
                                               L2D ||
                                               seen ==
                                               L2F)) {
                                          pendingIdivCastToDivBugLocation =
                                            edu.umd.cs.findbugs.SourceLineAnnotation.
                                              fromVisitedInstruction(
                                                this);
                                      }
                                      prevOpCode =
                                        seen;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1lL5eviqeMXhvf8Bn4FkvGAdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Bm0RCNsiEt/HmWWQyV2PFSSpHWcIkbSHa62zxqr9ZLzZZN1GnaQyDMFHjGIN" +
       "rUXSns9r7Wl9UNdXpu5v2JE373KuTDeJ9tacVieY0lxS4sYQsJ0scYI0TjZh" +
       "1GJkeBuQDKN6DTEbztERKVn8XNaJdMSgSYuHQ12dxLYzpsMBbrpxg0rDKs2p" +
       "aEr0LQVD3IZdbYwXa562uEzIKD8eehWiWze1SZPu5iO6h8pO1cx322i+NBc+" +
       "JyyCXi3Lsh6DCjDbYqlmu73cjafMeIqNmRiukJHOTetKbLAhuhDGIzlspYs0" +
       "yiPGxetKOkTnO24d9Fv9dafRATjv5e5u11xt3CVMqEh/oFG7FPYmZINcp2il" +
       "w1GzuadiiDkjqz28SphqsEn7bZhx2DCNw6xenzB9OTLDhSaQdjJTq27EVmy0" +
       "5oYC7xliYy0hodVrtUb9LYt5DL5DJZ7zBnQFm8Z1NAvDkQm23kYwRupJZmmK" +
       "1OTWVromfNZZ8OQ43CF1nXCMioish+zcHnj0hLfd7ThYEm0YCZaj9XIpjER8" +
       "J2AyHM41RSTN3rYftEVz0wQW24pH7dznU2wlDbpjYmI3NqrEOBo8ldxhV4oj" +
       "Nxcm22YOMxV6q8wib0zXhZ4NE3Y/nqcKG2nE1OBCdWtGdHuSY02xQRl9d4So" +
       "GK7N+90AseKJoPKCF8bEEgw8XVS3U5SQSH5SZUbbRU1eisaYRZqoaRgZnGDD" +
       "NRPTcQWEKT1iV+nz3JRJA1oXFKeXZYtelqq7sTGNAMpK2oRCE21u5rXNph8P" +
       "MJ8SVh1Vmrmu1sdnQ2Kpq047bdm0Mps4LCwzMEwOVhKrD2Q5zsJUdNfcpOIZ" +
       "fXM1aDV8PLMb6ryjN2pbeeE0K23dt0mpF+Bcr6LtmmKzkrq80iFNaTFBJZZu" +
       "+VnbhTdtTMfnPpNvq90OiNtZZalsUXUQdkb4MmkshZofranVBlcig+gsCCMI" +
       "mgEpjbmNMw52/JCyeJtTFpVhdTtiF2DahXo+neFwt85hIla1l8mG4n25t920" +
       "HaqatdkKXDPCBBvg8kjm5vNRPuNtHNl1bQrNxE5QXW0WSi65Ep3IcF3Vu93B" +
       "Wh4wZFXnqCYICKJlt4Y4sdLlnA6+1WwunuDqgAK+moH4iUlmlbG77UV60IPb" +
       "aE1p4stmb73257pJ7ughH8VzOGtQ43qDrdO27ofd9Rabux7vcw1NGbM8h/qJ" +
       "bqTcFumyi9RcdwW3yiOrWltfKtFkUWn785XVVpAFx2MJOtHnU9Fk5lJotXix" +
       "3arOp9U+u63TKNuydhGRZApVnYzQTowHNQIm8GUF6LhhN5icWi0zlgFuKo50" +
       "s04TpibZ9MSd0wjeb1p5l52SaxXuWcK4Z6VOi28jzV1E8g1mmouS3Tangoyp" +
       "dGMkjpBlssTgBbdCauhoZ0S8IGl6fRxM6rPtXOf4XUtviHhTF3KVS5MEBHVB" +
       "JV9Rk+4aXUXcNjf8dYLQoTh0XUecz/PGoqqGNRKeeVwEM41K5rq17kJtLgFo" +
       "2SS1cdepmFELmpRW0nzlhOqEHqQNB05C1KdqEhFRotrVqwk9Z2R1JWJUtOYU" +
       "FFsS1VytTjg4Qc1ASYUJGqsVamswJpO1hG2bIeRBKxT1+cozt2mP0es+CPRp" +
       "a9loVldE0xadZdZRuepoHIhwDnPKGu+psAQCFY0VR9WFmk/7KixWrVDudcdN" +
       "RowZy8nGM2nYqsNxi2pU2vQMmawGuDfpVT3gLdvRoJbtpEFdc6poJaqNKujC" +
       "rDpgn5daG228MFO9jXv1vp2SmAp2w99WbJO/7+vbvj9anlScXEuDXXtRkX4d" +
       "O/R91QtF8p6T46Dydx26cJV55jjozOE2VJwoPnO/2+byNPHTH379DZX9yerB" +
       "0TnRJIYeiv3gWx0t1ZwzpK4CSu+7/8npuLxsPz2s/u0P//enhW83P/R1XNU9" +
       "d4HPiyR/Zvzm58lvVn7wALp6cnR9z2cA5zu9ev7A+maoxUnoCeeOrZ+597rs" +
       "mSPNPnPxoO107i4/EHzvfu4v3LlcuLd53g+NQzmQFVM7XCmac1h+8FHcYx+J" +
       "XBL51Ntc3Px4kfxIDF0DuwIrvvQsKPUt9dTIPnneyB4+MbITph47PcRiUy0M" +
       "raOTzMvt8t4rlbLg9fOqfA48d45UeecfRZXP3l+VxVlsSeKzb6PIXyqSnztW" +
       "ZPHyE6dKe/O+SiuKf+rvrZ6XwPPKkXpe+QdVT/GqlA1+422E/80i+bfA3SM5" +
       "YwMF6OuCAn71H1ABeQw9efl3A8Ul6Lvu+Wxp/6mN8gtv3HrwqTfEPymvzk8+" +
       "h3mIhh7UE8c5exd1Jn89CDXdKmV8aH8zFZR/n4+hp+//WUMMXd9nSt4/t+/y" +
       "hRh6/JIuMRj/KHu29e/F0M3T1jF0oJyr/oMYunFUHUNXQXq28o9AEagssn8c" +
       "HNv3K5degWwBl2C2eAXAquUZ3ZJrP8yvnEf+k3l87KsdAp9ZLF46B/HlR2fH" +
       "cJzsPzu7q3zmDYr57i83f3L/XQBwud2uoPIgDd3Yf6JwAukv3JfaMa3rg5e/" +
       "8shnH3rP8fLzyJ7hU/M/w9tzl1/C99wgLq/Nd//mqV96/0+98Wflufv/Bwem" +
       "qWcNKAAA");
}
