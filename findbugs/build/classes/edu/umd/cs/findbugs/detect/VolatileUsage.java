package edu.umd.cs.findbugs.detect;
public class VolatileUsage extends edu.umd.cs.findbugs.BytecodeScanningDetector {
    enum IncrementState {
        START, GETFIELD, LOADCONSTANT, ADD; 
        private IncrementState() {  }
        public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZfWwcxRWfu/NXHNvnOJ+EfOeS1iG9A8pHkQPFsZ3kwvmD" +
                                                                  "2LGEA1zWe3P2kr3dze6cczGfoapIK0EjICFUwZXa0CoQkqgqopUKSoXKRyFI" +
                                                                  "UEqTtgRo/+GjUZO2QFUo7Xszu7cfd2eHSLV047mZeTPvvXnv996bO3yGVFsm" +
                                                                  "WUQ1Fmc7DWrFuzTWJ5kWzXSokmUNwFhafiQi/ePW93uuCZOaIdI0KlndsmTR" +
                                                                  "dQpVM9YQWahoFpM0mVo9lGaQos+kFjXHJKbo2hCZrVjJnKEqssK69QzFBYOS" +
                                                                  "mSIzJMZMZTjPaNLegJGFKeAkwTlJtAen21KkQdaNne7yeZ7lHZ4ZXJlzz7IY" +
                                                                  "aU7dJo1JiTxT1ERKsVhbwSSXGLq6c0TVWZwWWPw29UpbBRtTV5aoYNmx6Cef" +
                                                                  "7Rlt5iqYKWmazrh41iZq6eoYzaRI1B3tUmnO2k7uIpEUme5ZzEgs5RyagEMT" +
                                                                  "cKgjrbsKuG+kWj7XoXNxmLNTjSEjQ4ws9W9iSKaUs7fp4zzDDnXMlp0Tg7RL" +
                                                                  "itIKKUtE3HtJ4uFHbm3+aYREh0hU0fqRHRmYYHDIECiU5oapabVnMjQzRGZo" +
                                                                  "cNn91FQkVRm3b7rFUkY0ieXh+h214GDeoCY/09UV3CPIZuZlpptF8bLcoOxv" +
                                                                  "1VlVGgFZ57iyCgnX4TgIWK8AY2ZWAruzSaq2KVqGkcVBiqKMsRtgAZDW5igb" +
                                                                  "1YtHVWkSDJAWYSKqpI0k+sH0tBFYWq2DAZqMzK+4KerakORt0ghNo0UG1vWJ" +
                                                                  "KVg1jSsCSRiZHVzGd4Jbmh+4Jc/9nOlZ88Dt2gYtTELAc4bKKvI/HYgWBYg2" +
                                                                  "0Sw1KfiBIGxYldonzXl2d5gQWDw7sFiseeaOc9evXnT8JbHm4jJreodvozJL" +
                                                                  "yweHm15f0NF6TQTZqDN0S8HL90nOvazPnmkrGIAwc4o74mTcmTy+6YWb7nmC" +
                                                                  "fhQm9UlSI+tqPgd2NEPWc4aiUnM91agpMZpJkmlUy3Tw+SSphX5K0agY7c1m" +
                                                                  "LcqSpErlQzU6/w4qysIWqKJ66CtaVnf6hsRGeb9gEEKq4EOq4fMVIv5WYMNI" +
                                                                  "OjGq52hCkiVN0fREn6mj/FYCEGcYdDuayIIxDedHrIRlygluOjSTT+RzmYRs" +
                                                                  "uZMZyoAsMair4CQq3WyBMcRxtfH/P6KAUs7cEQrBBSwIur8KnrNBVzPUTMsP" +
                                                                  "59d2nTuSfkWYFrqDrR9GroYT43BiXLbizolxcWLcd2IsqckmzQHvCByUhEL8" +
                                                                  "3FnIiLh0uLJt4PyAvg2t/bds3Lp7WQSszdiBN4BLl/miUIeLEA6sp+WjLY3j" +
                                                                  "S09f9nyYVKVIiySzvKRiUGk3R+BUeZvt0Q3DEJ/cMLHEEyYwvpm6DFKZtFK4" +
                                                                  "sHep08eoieOMzPLs4AQxdNdE5RBSln9yfP+OXYN3XxomYX9kwCOrAdSQvA/x" +
                                                                  "vIjbsSAilNs3et/7nxzdd6fuYoMv1DgRsoQSZVgWtIygetLyqiXS0+ln74xx" +
                                                                  "tU8D7GYS+BrA4qLgGT7oaXNgHGWpA4GzupmTVJxydFzPRk19hzvCTXYGNrOF" +
                                                                  "9aIJBRjkEeDafuOxk6998HWuSSdYRD1Rvp+yNg9A4WYtHIpmuBY5YFIK697e" +
                                                                  "3/fQ3jP3beHmCCuWlzswhm0HABPcDmjw2y9tP/XO6YNvhl0TZqTWMBVIe2iB" +
                                                                  "CzPrv/AXgs8X+EFUwQGBLi0dNsQtKWKcgUevdJkDtFPBy9A6Yps1sEMlq0jD" +
                                                                  "KkUH+jy64rKn//pAs7hvFUYcc1k99Qbu+EVryT2v3PrpIr5NSMZo6yrQXSYg" +
                                                                  "fKa7c7tpSjuRj8KuNxY++qL0GAQDAGBLGaccUwlXCOE3eCXXxaW8vSIwdzU2" +
                                                                  "Kyyvkfv9yJMVpeU9b55tHDz73DnOrT+t8l58t2S0CTMStwCHzSN2s8KL8Tg7" +
                                                                  "x8B2bgF4mBtEqg2SNQqbXXG85+Zm9fhncOwQHCtDwmH1moCbBZ8t2aura//w" +
                                                                  "q+fnbH09QsLrSL2qS5l1Evc4Mg1MnVqjALkF45vXCz521EHTzPVBSjRUMoC3" +
                                                                  "sLj8/XblDMZvZPznc3+25icTp7ldGmKPizl9FVCvqKDnLkg3XXdv2vz3E1s/" +
                                                                  "f+GfIPFGUqubGUWTVJC2tTLa8WLA3WHev3vV4Xv//K+Sq+I4VyZlCdAPJQ4f" +
                                                                  "mN9x3Uec3gUcpI4VSoMZgLZLe/kTuY/Dy2p+HSa1Q6RZtpPoQUnNo68PQeJo" +
                                                                  "OZk1JNq+eX8SKDKetiKgLgiCnefYINS5QRT6uBr7jQGzxMsnjfBZaZvlyqBZ" +
                                                                  "EsI7GznJSt62YrNa3CiDmiA/DKUVdCyerjNgA2+LkSosIfiBcRjsH2jfNMAB" +
                                                                  "VaAqtt/A5gZhImvKWaTzx1d0FtmO4tjc82B7cwW2sduDTS82fdjc6HBat75r" +
                                                                  "YF2yK9VZjtnBqZkNBZi9yHH3qZi9+QKYbUj1tnd29PaAdnvKaveWqRkOBxjm" +
                                                                  "aeiq82BYvgCGI+2dZRWbmZrPSKH8eeHiUfYpHsghiKsLK5U0vBw7eO/DE5ne" +
                                                                  "xy8ThUeLv0xAWHrqrf+8Gt//7stlctMauyR1Dwzjeb40spuXei46vN304F9+" +
                                                                  "ERtZ+2UySBxbNEWOiN8XgwSrKmNkkJUX7/1w/sB1o1u/RDK4OKDL4JaHug+/" +
                                                                  "vH6l/GCY17UCtkrqYT9Rmx+s6k0KBbw24IOs5d6ErKwVRAJW5zEFN/SH7FQf" +
                                                                  "v89jpJmHMoTauKi3OdH4JPnCXdiMQZ41hmjdm+UMGZMQ7CqNoTiwVtCYU4oV" +
                                                                  "dCawOQ3uaIyWlc978u5J5r6LzbdgLy6GNUlcBqvhuZYo0id+vPy1uyeWv8cz" +
                                                                  "kTrFAjsEsy3zauChOXv4nY/eaFx4hNt7FVo1v9bgc0vpa4rvkYSzHfWoyzAM" +
                                                                  "Mpni91RSfIGRJn+l6JjDV8+30gR9zSt5zBIPMPKRiWjd3InNvxfiOo8kDeCo" +
                                                                  "2byqeoOyp19jmDSrcL4bRIg2+L99jMyvzBTcn+hwAfYKkkcZmVmGBOKa0/Wu" +
                                                                  "PsBIvbuakbDsm/4BWLo9DdANrXfyhzAEk9j9kVECe/35YYt5Ho/e61lQr2/r" +
                                                                  "myFgdhKQChLer0yc+M3H0V2C0J8B8odHmzRId+pk5PLpLPY9Dm5Fu5sOaZKF" +
                                                                  "K7Eor/iIyfcSOXyTW0mR8pXULDdhw3AR52+kTuYLZtXkogzO4+iTWFSWqist" +
                                                                  "F2YPzGptuPFdIezSKbSUlpO5dP/Tp+67isem6JgCpaZ4ARePznN8j87O40eb" +
                                                                  "7zG2rB7T8vtH739p6YeDM/krm1AZcn5NQTjdtXagDvFAHSbiAeVin0w2H7zk" +
                                                                  "S8uvrlaurvvTm4eEaJXwxk9zx4EvTnxw5+mXI6QGEAKdSTIpBA5G4pWesb0b" +
                                                                  "xAag1wlUEGKaBDWAPLcR2xZaiqPFRwdGvlZpb3yXL/N0A0XWDmqu1fNaBreN" +
                                                                  "BeJZ3jC8swLJLtiq7oIK+zx0VxTdyZ5auNoDtuidhHRmZkeqvb8/PXBTX1d6" +
                                                                  "sH1Tsn1tqoubqwGToS7O80FsDnEhnhSmjO1TlYwCh5/hTcFbCpKCQPHgYMif" +
                                                                  "uxXTw9mTpIfeChO7G7HZjM3N2MgF34NK0Ny78+IXi7R8dGJjz+3nrnpcPOiA" +
                                                                  "vsfHbSupFc9GxSRoacXdnL1qNrR+1nRs2oqwHY18D0peEXlMAj3xt5f5gQcO" +
                                                                  "K1Z85zh1cM1zJ3bXvAGOvoWEJLirLaWFYsHIAwxvSble6Pm9i5tFW+v3d163" +
                                                                  "Ovu3P/Lq3PbaBZXXQyH80MnksW2fXs8fyKshhNACr2A7d2qbqDxmJkldXlO2" +
                                                                  "52kyU8nJGn1Oxsiykp8opnYqyBemuyO+H07K+xkSuCPFq5tVKmta7vxO9Jd7" +
                                                                  "WiLrIGb7xPFuXwsQWMxJvb+luElqM0/JCsJ/I+lUt2HY/lx3kyFg87diCQ6D" +
                                                                  "R62yRz2pKX59i+/2O97F5uT/AHQLywQlHQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private final edu.umd.cs.findbugs.BugReporter
      bugReporter;
    public VolatileUsage(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        classContext.
          getJavaClass(
            ).
          accept(
            this);
    }
    java.util.Set<edu.umd.cs.findbugs.ba.XField>
      initializationWrites =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    java.util.Set<edu.umd.cs.findbugs.ba.XField>
      otherWrites =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
      );
    edu.umd.cs.findbugs.detect.VolatileUsage.IncrementState
      state =
      edu.umd.cs.findbugs.detect.VolatileUsage.IncrementState.
        START;
    edu.umd.cs.findbugs.ba.XField incrementField;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        resetIncrementState(
          );
        super.
          visit(
            obj);
    }
    @java.lang.Override
    public void sawOpcode(int seen) { switch (state) {
                                          case START:
                                              if (seen ==
                                                    GETFIELD) {
                                                  edu.umd.cs.findbugs.ba.XField f =
                                                    getXFieldOperand(
                                                      );
                                                  if (isVolatile(
                                                        f)) {
                                                      incrementField =
                                                        f;
                                                      state =
                                                        edu.umd.cs.findbugs.detect.VolatileUsage.IncrementState.
                                                          GETFIELD;
                                                  }
                                              }
                                              break;
                                          case GETFIELD:
                                              if (seen ==
                                                    ICONST_1 ||
                                                    seen ==
                                                    LCONST_1 ||
                                                    seen ==
                                                    ICONST_M1) {
                                                  state =
                                                    edu.umd.cs.findbugs.detect.VolatileUsage.IncrementState.
                                                      LOADCONSTANT;
                                              }
                                              else {
                                                  resetIncrementState(
                                                    );
                                              }
                                              break;
                                          case LOADCONSTANT:
                                              if (seen ==
                                                    IADD ||
                                                    seen ==
                                                    ISUB ||
                                                    seen ==
                                                    LADD ||
                                                    seen ==
                                                    LSUB) {
                                                  state =
                                                    edu.umd.cs.findbugs.detect.VolatileUsage.IncrementState.
                                                      ADD;
                                              }
                                              else {
                                                  resetIncrementState(
                                                    );
                                              }
                                              break;
                                          case ADD:
                                              if (seen ==
                                                    PUTFIELD &&
                                                    incrementField.
                                                    equals(
                                                      getXFieldOperand(
                                                        ))) {
                                                  bugReporter.
                                                    reportBug(
                                                      new edu.umd.cs.findbugs.BugInstance(
                                                        this,
                                                        "VO_VOLATILE_INCREMENT",
                                                        "J".
                                                          equals(
                                                            incrementField.
                                                              getSignature(
                                                                ))
                                                          ? edu.umd.cs.findbugs.Priorities.
                                                              HIGH_PRIORITY
                                                          : edu.umd.cs.findbugs.Priorities.
                                                              NORMAL_PRIORITY).
                                                        addClassAndMethod(
                                                          this).
                                                        addField(
                                                          incrementField).
                                                        addSourceLine(
                                                          this));
                                              }
                                              resetIncrementState(
                                                );
                                              break;
                                      }
                                      switch (seen) {
                                          case PUTSTATIC:
                                              {
                                                  edu.umd.cs.findbugs.ba.XField f =
                                                    getXFieldOperand(
                                                      );
                                                  if (!isVolatileArray(
                                                         f)) {
                                                      return;
                                                  }
                                                  if ("<clinit>".
                                                        equals(
                                                          getMethodName(
                                                            ))) {
                                                      initializationWrites.
                                                        add(
                                                          f);
                                                  }
                                                  else {
                                                      otherWrites.
                                                        add(
                                                          f);
                                                  }
                                                  break;
                                              }
                                          case PUTFIELD:
                                              {
                                                  edu.umd.cs.findbugs.ba.XField f =
                                                    getXFieldOperand(
                                                      );
                                                  if (!isVolatileArray(
                                                         f)) {
                                                      return;
                                                  }
                                                  if ("<init>".
                                                        equals(
                                                          getMethodName(
                                                            ))) {
                                                      initializationWrites.
                                                        add(
                                                          f);
                                                  }
                                                  else {
                                                      otherWrites.
                                                        add(
                                                          f);
                                                  }
                                                  break;
                                              }
                                          default:
                                              break;
                                      } }
    private void resetIncrementState() { state =
                                           edu.umd.cs.findbugs.detect.VolatileUsage.IncrementState.
                                             START;
                                         incrementField =
                                           null;
    }
    @java.lang.Override
    public void report() { edu.umd.cs.findbugs.ba.ch.Subtypes2 subtypes2 =
                             edu.umd.cs.findbugs.ba.AnalysisContext.
                             currentAnalysisContext(
                               ).
                             getSubtypes2(
                               );
                           for (edu.umd.cs.findbugs.ba.XField f
                                 :
                                 edu.umd.cs.findbugs.ba.AnalysisContext.
                                  currentXFactory(
                                    ).
                                  allFields(
                                    )) { if (isVolatileArray(
                                               f) &&
                                               subtypes2.
                                               isApplicationClass(
                                                 f.
                                                   getClassDescriptor(
                                                     ))) {
                                             int priority =
                                               LOW_PRIORITY;
                                             if (initializationWrites.
                                                   contains(
                                                     f) &&
                                                   !otherWrites.
                                                   contains(
                                                     f)) {
                                                 priority =
                                                   NORMAL_PRIORITY;
                                             }
                                             bugReporter.
                                               reportBug(
                                                 new edu.umd.cs.findbugs.BugInstance(
                                                   this,
                                                   "VO_VOLATILE_REFERENCE_TO_ARRAY",
                                                   priority).
                                                   addClass(
                                                     f.
                                                       getClassDescriptor(
                                                         )).
                                                   addField(
                                                     f));
                                         }
                           } }
    private boolean isVolatile(edu.umd.cs.findbugs.ba.XField f) {
        return f !=
          null &&
          f.
          isVolatile(
            );
    }
    private boolean isVolatileArray(edu.umd.cs.findbugs.ba.XField f) {
        return isVolatile(
                 f) &&
          f.
          getSignature(
            ).
          charAt(
            0) ==
          '[';
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
       "0YVt8e8ydCYN58SF7alb98CHHrsoU6q4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Yfv0R159XRn9YuXSwU3uayF0d+i4P2qqsWqeIHXl9p/dmCJR7Pgb7Bc+8seP" +
       "cj+uf/AtZKA8cYbPsyT/CfOZLxHvln/2EnTH0RfZW1LYTg964cynGV8NI9/m" +
       "Tn2Nfex0Fsj7Du71D+/3z8kCOdcK9gor2K39mVSCM+kIz1zw1aRYl4MswoLO" +
       "r90mJeFf5sU/A0ZWfNk7ObTo/skTpvWpELozdgzl2OZ+9bTN3Xdkc0c8Xj/x" +
       "zSdWwUFeUW9jprcmDhQVnzut2Seg3Udh6PDvD1yzjzv+al90RVlX9yVZNXdf" +
       "0fLstv22o6gFiS/fRqn/Pi++EEJ3FUrNf/zGsdK+eKHS8urf/L7V8wx42gfq" +
       "af/g1XPGIu4w7J2R/afb6OPrefF7ABACMRm5MlDhGZ38/g9PJ3miIfRu8Lx8" +
       "oJOX36pOuufq5KR837xN27fy4r+F0MO+midN3vK17YQW/vDNPiq82dLnmWev" +
       "HIj5yg9m6U+K8he3aftfefE/QuiyX6R+nJHsT3946/u2vPJx8Lx2IPhrP5j1" +
       "3TvusMk77N15sfR7l/PK74Z5RtDh19XznOWK5DimKtpHitmDvo8lLyTPvf0X" +
       "DiT/hR+S5A/fRvK358UDIXTtWPIiqy6vvnos57W3ImcaQvef+kidp+09cks2" +
       "/S4DXP6V169dfefrs98vkj2PsrTvpqGrWmSaJ7OnTrxfdn1VMwrx797lUrmF" +
       "OO8KoUcv/nQOzHv3krO89yO7IU8A3z5nSAjmP3g92ftpYCTHvUPoknyq+Vlg" +
       "JAfNAFtBebLxPaAKNOavz7mHe9V7z01K3AIuAcyyMoiYDHvVKbh2/HTvdFB3" +
       "5KDX32x9TsSBz1yY2MNEu/8NcVP+7Ov94U9+u/GLu0xWsH1mWU7lKg1d2SXV" +
       "HkVrT11I7ZDWZfK57zzwubufPYwsH9gxfGzcJ3h74vy00a7lhkWiZ/Zr7/zV" +
       "9/2j179afC3/fyFT9xekMgAA");
}
