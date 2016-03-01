package edu.umd.cs.findbugs.detect;
public class RedundantConditions implements edu.umd.cs.findbugs.Detector {
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    public RedundantConditions(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        for (org.apache.bcel.classfile.Method method
              :
              classContext.
               getJavaClass(
                 ).
               getMethods(
                 )) {
            edu.umd.cs.findbugs.classfile.MethodDescriptor methodDescriptor =
              edu.umd.cs.findbugs.bcel.BCELUtil.
              getMethodDescriptor(
                classContext.
                  getJavaClass(
                    ),
                method);
            edu.umd.cs.findbugs.classfile.engine.bcel.ValueRangeAnalysisFactory.ValueRangeAnalysis analysis;
            try {
                analysis =
                  edu.umd.cs.findbugs.classfile.Global.
                    getAnalysisCache(
                      ).
                    getMethodAnalysis(
                      edu.umd.cs.findbugs.classfile.engine.bcel.ValueRangeAnalysisFactory.ValueRangeAnalysis.class,
                      methodDescriptor);
            }
            catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                bugReporter.
                  logError(
                    "ValueRangeAnalysis failed for " +
                    methodDescriptor,
                    e);
                continue;
            }
            if (analysis ==
                  null) {
                continue;
            }
            for (edu.umd.cs.findbugs.classfile.engine.bcel.ValueRangeAnalysisFactory.RedundantCondition condition
                  :
                  analysis.
                   getRedundantConditions(
                     )) {
                int priority =
                  getPriority(
                    methodDescriptor,
                    condition);
                edu.umd.cs.findbugs.SourceLineAnnotation sourceLineAnnotation =
                  edu.umd.cs.findbugs.SourceLineAnnotation.
                  fromVisitedInstruction(
                    classContext,
                    method,
                    condition.
                      getLocation(
                        ).
                      getHandle(
                        ).
                      getPosition(
                        ));
                edu.umd.cs.findbugs.BugInstance bug =
                  new edu.umd.cs.findbugs.BugInstance(
                  condition.
                    isByType(
                      )
                    ? "UC_USELESS_CONDITION_TYPE"
                    : "UC_USELESS_CONDITION",
                  priority).
                  addClassAndMethod(
                    methodDescriptor).
                  add(
                    new edu.umd.cs.findbugs.StringAnnotation(
                      normalize(
                        condition.
                          getTrueCondition(
                            ))));
                if (condition.
                      isByType(
                        )) {
                    bug.
                      addType(
                        condition.
                          getSignature(
                            ));
                }
                if (condition.
                      isDeadCodeUnreachable(
                        ) &&
                      condition.
                      getDeadCodeLocation(
                        ) !=
                      null &&
                      priority ==
                      HIGH_PRIORITY) {
                    bug.
                      addSourceLine(
                        methodDescriptor,
                        condition.
                          getDeadCodeLocation(
                            )).
                      describe(
                        edu.umd.cs.findbugs.SourceLineAnnotation.
                          ROLE_UNREACHABLE_CODE);
                }
                bugAccumulator.
                  accumulateBug(
                    bug,
                    sourceLineAnnotation);
            }
            bugAccumulator.
              reportAccumulatedBugs(
                );
        }
    }
    private java.lang.String normalize(java.lang.String condition) {
        if (condition.
              startsWith(
                "this.this$")) {
            return condition.
              substring(
                "this.".
                  length(
                    ));
        }
        if (condition.
              startsWith(
                "this.val$")) {
            return condition.
              substring(
                "this.val$".
                  length(
                    ));
        }
        return condition;
    }
    private int getPriority(edu.umd.cs.findbugs.classfile.MethodDescriptor methodDescriptor,
                            edu.umd.cs.findbugs.classfile.engine.bcel.ValueRangeAnalysisFactory.RedundantCondition condition) {
        if (condition.
              isByType(
                )) {
            long number =
              condition.
              getNumber(
                ).
              longValue(
                );
            if (condition.
                  getSignature(
                    ).
                  equals(
                    "I")) {
                if (number ==
                      java.lang.Integer.
                        MIN_VALUE ||
                      number ==
                      java.lang.Integer.
                        MAX_VALUE) {
                    return IGNORE_PRIORITY;
                }
            }
            else
                if (condition.
                      getSignature(
                        ).
                      equals(
                        "C")) {
                    if (number <=
                          0) {
                        return IGNORE_PRIORITY;
                    }
                }
                else
                    if (condition.
                          getSignature(
                            ).
                          equals(
                            "B")) {
                        if (number <
                              java.lang.Byte.
                                MIN_VALUE ||
                              number >=
                              java.lang.Byte.
                                MAX_VALUE) {
                            return IGNORE_PRIORITY;
                        }
                    }
        }
        int priority =
          condition.
          isDeadCodeUnreachable(
            )
          ? HIGH_PRIORITY
          : (condition.
               isBorder(
                 ) ||
               condition.
               getSignature(
                 ).
               equals(
                 "Z")
               ? LOW_PRIORITY
               : NORMAL_PRIORITY);
        if (condition.
              getDeadCodeLocation(
                ) !=
              null &&
              condition.
              getLiveCodeLocation(
                ) !=
              null &&
              condition.
              isDeadCodeUnreachable(
                )) {
            org.apache.bcel.generic.InstructionHandle deadHandle =
              condition.
              getDeadCodeLocation(
                ).
              getHandle(
                );
            org.apache.bcel.generic.InstructionHandle liveHandle =
              condition.
              getLiveCodeLocation(
                ).
              getHandle(
                );
            int deadValue =
              getIntValue(
                deadHandle);
            int liveValue =
              getIntValue(
                liveHandle);
            if (deadValue ==
                  0 &&
                  liveValue ==
                  1 ||
                  deadValue ==
                  1 &&
                  liveValue ==
                  0) {
                org.apache.bcel.generic.InstructionHandle deadNext =
                  deadHandle.
                  getNext(
                    );
                org.apache.bcel.generic.InstructionHandle liveNext =
                  liveHandle.
                  getNext(
                    );
                if (deadNext !=
                      null &&
                      liveNext !=
                      null) {
                    org.apache.bcel.generic.InstructionHandle middle;
                    org.apache.bcel.generic.InstructionHandle after;
                    if (deadNext.
                          getNext(
                            ) ==
                          liveHandle) {
                        middle =
                          deadNext;
                        after =
                          liveNext;
                    }
                    else
                        if (liveNext.
                              getNext(
                                ) ==
                              deadHandle) {
                            middle =
                              liveNext;
                            after =
                              deadNext;
                        }
                        else {
                            return priority;
                        }
                    if (!(middle.
                            getInstruction(
                              ) instanceof org.apache.bcel.generic.GOTO) ||
                          ((org.apache.bcel.generic.GOTO)
                             middle.
                             getInstruction(
                               )).
                          getTarget(
                            ) !=
                          after) {
                        return priority;
                    }
                    org.apache.bcel.generic.MethodGen methodGen;
                    try {
                        methodGen =
                          edu.umd.cs.findbugs.classfile.Global.
                            getAnalysisCache(
                              ).
                            getMethodAnalysis(
                              org.apache.bcel.generic.MethodGen.class,
                              methodDescriptor);
                    }
                    catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                        return priority;
                    }
                    org.apache.bcel.generic.InstructionHandle consumer =
                      getConsumer(
                        methodGen,
                        after);
                    org.apache.bcel.generic.Instruction consumerInst =
                      consumer ==
                      null
                      ? null
                      : consumer.
                      getInstruction(
                        );
                    if (consumerInst !=
                          null) {
                        short opcode =
                          consumerInst.
                          getOpcode(
                            );
                        if (opcode ==
                              org.apache.bcel.Constants.
                                IADD ||
                              opcode ==
                              org.apache.bcel.Constants.
                                ISUB ||
                              opcode ==
                              org.apache.bcel.Constants.
                                IMUL ||
                              opcode ==
                              org.apache.bcel.Constants.
                                ISHR ||
                              opcode ==
                              org.apache.bcel.Constants.
                                ISHL ||
                              opcode ==
                              org.apache.bcel.Constants.
                                IUSHR) {
                            return priority;
                        }
                    }
                    if (condition.
                          getSignature(
                            ).
                          equals(
                            "Z")) {
                        return IGNORE_PRIORITY;
                    }
                    priority =
                      condition.
                        isBorder(
                          )
                        ? LOW_PRIORITY
                        : NORMAL_PRIORITY;
                    if (consumerInst instanceof org.apache.bcel.generic.InvokeInstruction) {
                        org.apache.bcel.generic.ConstantPoolGen constantPool =
                          methodGen.
                          getConstantPool(
                            );
                        java.lang.String methodName =
                          ((org.apache.bcel.generic.InvokeInstruction)
                             consumerInst).
                          getMethodName(
                            constantPool);
                        if (methodName.
                              equals(
                                "assertTrue") ||
                              methodName.
                              equals(
                                "checkArgument") ||
                              methodName.
                              equals(
                                "isLegal") ||
                              methodName.
                              equals(
                                "isTrue")) {
                            return liveValue ==
                              1
                              ? (condition.
                                   isBorder(
                                     )
                                   ? IGNORE_PRIORITY
                                   : LOW_PRIORITY)
                              : HIGH_PRIORITY;
                        }
                        if (methodName.
                              equals(
                                "assertFalse") ||
                              methodName.
                              equals(
                                "isFalse")) {
                            return liveValue ==
                              0
                              ? (condition.
                                   isBorder(
                                     )
                                   ? IGNORE_PRIORITY
                                   : LOW_PRIORITY)
                              : HIGH_PRIORITY;
                        }
                    }
                }
            }
        }
        return priority;
    }
    private org.apache.bcel.generic.InstructionHandle getConsumer(org.apache.bcel.generic.MethodGen methodGen,
                                                                  org.apache.bcel.generic.InstructionHandle start) {
        int depth =
          1;
        org.apache.bcel.generic.InstructionHandle cur =
          start;
        while (cur !=
                 null) {
            org.apache.bcel.generic.Instruction inst =
              cur.
              getInstruction(
                );
            depth -=
              inst.
                consumeStack(
                  methodGen.
                    getConstantPool(
                      ));
            if (depth <=
                  0) {
                return cur;
            }
            depth +=
              inst.
                produceStack(
                  methodGen.
                    getConstantPool(
                      ));
            if (inst instanceof org.apache.bcel.generic.BranchInstruction) {
                if (inst instanceof org.apache.bcel.generic.GotoInstruction) {
                    cur =
                      ((org.apache.bcel.generic.GotoInstruction)
                         inst).
                        getTarget(
                          );
                    continue;
                }
                if (!(inst instanceof org.apache.bcel.generic.IfInstruction)) {
                    return null;
                }
            }
            cur =
              cur.
                getNext(
                  );
        }
        return null;
    }
    private int getIntValue(org.apache.bcel.generic.InstructionHandle handle) {
        org.apache.bcel.generic.Instruction instruction =
          handle.
          getInstruction(
            );
        if (instruction instanceof org.apache.bcel.generic.ICONST) {
            return ((org.apache.bcel.generic.ICONST)
                      instruction).
              getValue(
                ).
              intValue(
                );
        }
        return -1;
    }
    @java.lang.Override
    public void report() {  }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UAXvYq/yP+N+6e1eHwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16aczk1nEg55M0I41kzUiKba0iy5Y8TiJ18rFvdkNer9kH" +
       "2WSTTTbZZHfTice8m9287+6sdh3nsJEEjpHIiQM4+hMHOeDYRpALCGIoMBIn" +
       "cBIgB3JiY29gIKeDGIvNLta7m31kf/d8M17B3v0Avo/9XlW9qnpV9Yqv3se/" +
       "BD0QhVDF9+ytaXvxoZ7Hh2u7dRhvfT06JKkWK4eRrvVtOYpmoO+2+tynbvzL" +
       "Vz60unkAXZWgJ2TX9WI5tjw34vTIs1Ndo6Abp71DW3eiGLpJreVUhpPYsmHK" +
       "iuIXKejhM6gxdIs6ZgEGLMCABbhkAUZPoQDS63Q3cfoFhuzGUQD9B+gKBV31" +
       "1YK9GHr2PBFfDmXniAxbSgAoPFj8FoFQJXIeQm85kX0v8x0Cf7gCv/xj7775" +
       "C/dBNyTohuXyBTsqYCIGk0jQI47uKHoYoZqmaxL0mKvrGq+Hlmxbu5JvCXo8" +
       "skxXjpNQP1FS0Zn4eljOeaq5R9RCtjBRYy88Ec+wdFs7/vWAYcsmkPUNp7Lu" +
       "JcSKfiDgdQswFhqyqh+j3L+xXC2G3nwR40TGW2MAAFCvOXq88k6mut+VQQf0" +
       "+H7tbNk1YT4OLdcEoA94CZglhp66K9FC176sbmRTvx1DT16EY/dDAOqhUhEF" +
       "Sgy9/iJYSQms0lMXVunM+nxp8vYPfqc7cg9KnjVdtQv+HwRIz1xA4nRDD3VX" +
       "1feIj7xA/aj8hl//wAEEAeDXXwDew/zKv//yO7/1mVd/ew/zjZfAMMpaV+Pb" +
       "6seUR//g6f7z3fsKNh70vcgqFv+c5KX5s0cjL+Y+8Lw3nFAsBg+PB1/lfmv5" +
       "3p/T/+EAuk5AV1XPThxgR4+pnuNbth7iuquHcqxrBPSQ7mr9cpyAroF3ynL1" +
       "fS9jGJEeE9D9dtl11St/AxUZgEShomvg3XIN7/jdl+NV+Z77EARdAw/UPHqO" +
       "36EY0uGV5+iwrMqu5XowG3qF/BGsu7ECdLuCDWBMSmJGcBSqcGk6upbAiaPB" +
       "anQ6qOkxQIM5MOZqwJmBP2ml6NFhgeP//5ooLyS+mV25Ahbj6YuhwAZeNPJs" +
       "TQ9vqy8nveGXP3H7cwcnrnGkqxg6BLQPwbyHanR4PO/hft7DS+aFrlwpp/uG" +
       "Yv79uoNV2wD/B5Hxkef57yDf84Hn7gMG52f3A5UXoPDdA3T/NGIQZVxUgdlC" +
       "r34k+y7xP1YPoIPzkbbgGXRdL9DZIj6exMFbFz3sMro33v+3//LJH33JO/W1" +
       "c6H7KATciVm48HMXtRt6KlBOqJ+Sf+Et8i/d/vWXbh1A94O4AGJhLAPbBWHm" +
       "mYtznHPlF4/DYiHLA0Bgwwsd2S6GjmPZ9XgVetlpT7nsj5bvjwEdP1zY9jPg" +
       "6RwZe/m/GH3CL9pv2JtJsWgXpCjD7r/l/Z/4s9//u0ap7uMIfePMnsfr8Ytn" +
       "okJB7Ebp/4+d2sAs1HUA958+wv7Ih7/0/neVBgAg3nrZhLeKtg+iAVhCoObv" +
       "/e3gzz//Vx/744NTo4nBtpgotqXmJ0IW/dD1ewgJZvumU35AVLGBBRdWc0tw" +
       "HU+zDEtWbL2w0v954221X/rHD97c24ENeo7N6Fu/OoHT/n/Tg977uXf/t2dK" +
       "MlfUYlc71dkp2D5UPnFKGQ1DeVvwkX/XH77pxz8r/wQIuiDQRdZOL2PXlSPH" +
       "KZh6Pdj5LvPPXmJyuu+FYBsrFxcuoV8o28NCMSUNqBxrFM2bo7NOct4Pz2Qp" +
       "t9UP/fE/v078509/uZTqfJpz1iZo2X9xb4ZF85YckH/jxYgwkqMVgGu+Ovn2" +
       "m/arXwEUJUBRBXt7xIQgLOXnLOgI+oFrf/Ebn3nDe/7gPugAg67bnqxhcumM" +
       "0EPAC/RoBSJa7v+7d+6NIHsQNDdLUaE7hN8bz5PlryJRfP7ucQgrspRTV37y" +
       "fzC28r6//u93KKGMQJdszhfwJfjjH32q/45/KPFPQ0GB/Ux+Z6gGGd0pbv3n" +
       "nP968NzV3zyArknQTfUoXRRlOykcTAIpUnScQ4KU8tz4+XRnv7e/eBLqnr4Y" +
       "hs5MezEInW4R4L2ALt6vX4g7jxdaroKndeSSrYtx5wpUvqAlyrNle6tovrlc" +
       "k4MYuuaHVgpygRhMb7myfeTv/wr+roDnfxdPQbTo2O/gj/eP0oi3nOQRPtjF" +
       "HgVugapq4iS2fJx+Aud57i7OcwZ0HxuLtlk0vT0LyF0t7O3n5X8BPO0j+dt3" +
       "kX9yF/mL12HRYKVm8Rh6WDl17KKreoE75qtyVxLKr4AQ+kD9EDksCQiXz39f" +
       "8fotINZG5UfBOUbeuLbVW8eqFsEXArD+W2sbOVbszdJxCzs73KfVFxjF/68Z" +
       "BY756CkxygMZ+g988UO/+0Nv/TzwHhJ6IC0sGzjNmRknSfHR8n0f//CbHn75" +
       "Cz9Q7hsgYPLPK//lnQXV2/cSt2iW50R9qhCV95JQ1Sk5iuky1OtaKe09gwYb" +
       "Wg7YEdOjjBx+6fHPbz76tz+/z7YvRogLwPoHXv7+fz384MsHZ75x3nrHZ8ZZ" +
       "nP13Tsn06440HELP3muWEgP7m0++9Gs/89L791w9fj5jH4IP0p//k//1u4cf" +
       "+cLvXJIa3m97X8PCxjd+cNSMCPT4j6pJ8jIT8nyeOLOGtNCsQTXPKApN56jf" +
       "zNfWcGU17RWqTJpLTEecPkdlMTUTduysOmE1JEBAyiQ4rD8llP58iBPbXDJo" +
       "aptx+XhGjsOJyQwNQtxUzcrQ7mzXzlZoTtYEZ4+icZ/LG0EaODPEyYbTFY81" +
       "BDGsLUQdFvVuFwkrCtETSduReVG2dn3OzANOlIIQU7eUFHqCtaDmZndtwuQA" +
       "00hj0qoZ8W5FB6ZBOBS3CSXBttotPiCDrBeZVU5hlj7tCvON5qNruz2b+5xa" +
       "XVlW0JxsWHxck6q5OBTndczrTiXMNOsznKfYoTN2h4ogI+5UWDqcPNhUZy1e" +
       "pigzZjRaI8x2Ryb4HUJOu4jtCKPxmkoWubCaKURUJYdi7AdrzsHH+S7IydbK" +
       "aTM+yWucvJpziuRZrapIoU4c9tDevOri6woSD1Itx4RMjImquxjl4aAVtHVv" +
       "OlM5wtslbSEQpHZD2bIiwRGwoC83irxE7ImH9HxsoEzAhsRnuj0SOg1GY2x1" +
       "REpKoAXTjtCnd+w0XW4sxx7h87YuuquVGDg8jUiZ5EsV3sZEYm6xazNl1vpq" +
       "t6zB8rY/QdtTbrMI8wpLqKiJO9kWnTobZ7aphXOe7A0zZjNfshQS6A4RuONJ" +
       "ojvzbWb7gkuvkpQNpsJIWTKyMewuxEafJcjY31azRqdC2IkwbBk1wRb5DRZt" +
       "WpnECXwYkfmQ6jHmkpH4qRvtHNxvjH2vL8hOb+du6VAx+uYMnfvMiho33Lgd" +
       "CmTPNCkVaHtoU5yR9rrUVNhgir8kUIdoTSjKC9oTi2sFLd4y6xaHKr5OT0XB" +
       "Q0xrQ8y5jjDcpitKrSYzlFq4SaszbpNKmlQxKVxy4z691b2QoVrtJu5P1IHA" +
       "tVjBZ9CRGWIrxdkaEwaX3DnWN0erjomtpzC7Y6ydwSq7Rs0L+pLg8Q6JtLGt" +
       "k0/ZlWl0OqEQegiGLSx6vmEaGJV33MpM3TYCzVHbETo1d4TSsWYbabtpG203" +
       "heuNpeFzdYyvVeuBJNZrdL032iljneZ40Qm16VryeK9pJ7TnBxbfrDSqtcDr" +
       "dWeTvo/rLZK0EDIRAnfrzQMNzqoBHxF8MCba7X4sCxFcGywdW591w+GQDJp9" +
       "usHYlWSWW6uqwuueiJH2msOqbabre8h2XsNQd7D2JqvaxFyPMESairGQtbab" +
       "+ohMtp4r2ENJTbQZhuLKZFhxJjTfpHfmLNskyUrsjRIWjsXhnOSayAgNe5KQ" +
       "TabecLwIOVnMWWFEzhr1KF4s1lm9QhEZ3ZhOuBoQFR/EfSZTNnKNUOIKUR9o" +
       "vIR1+H46ivNkVGnGyKoWyn04o9FJY1Y1GiAs+LUYm/ey3EXtoJeT9ca2F9AR" +
       "ZnHb7aATjuZVKXUadj3TN1mw3HLYxnbigLMWmO34Zj9vjeuMsDOGhMC3NvMx" +
       "TtZI0xpMavi0FVVtgstqji2uKhbpNXd01N5NrTbjqRrOV3XOS1TXh5dsA2FX" +
       "YZIOSCZjB+HKxnRUjlLV8hl9leyqRD9azBUtz+GQBRFACan1rultqgnfkzLP" +
       "zOPpkiYCR5u663jArN3mjpXqYSpx6KRLo646kPBsgiTYwO001Q0QLuZ7mbBW" +
       "dxvPnzFcYxEpvD9AonUDGyv6oqM6Q6GbOHRoYN0dTLLwGqFnAzxz+1GMM1lM" +
       "ZDyLzYwGvqzDFSRiUnW0cM1NsCbz1PPbuxla55tzNBmFuLJQJrpio5SWwDHS" +
       "3eXNJZBdCScoLafLVdJYaiaOZty877hw1kxqabow6k0mXtU6TYkbEcjAtLmJ" +
       "1dmsfaZNb6i+4rJqJ0OnQdKryoNFHNdt0636/EYnAk412lKFjXq8CjdiYYMM" +
       "+9gGBK+dAnfQBGlO1JRs8N20Em5FKmd4musjjMuSPSpgNVHTJT/k+2RzrXcq" +
       "YTVvVaYLj26anBm1xcjL82TabKfN9tCZKmjSs1wKEafGZDGdEVYFbhBzteKG" +
       "uurOHDlHK3FuKXVJWfBGXgEoUS9ZaGGj09Yjxt3VkI2QbnZ0uzsJyTk9c3C8" +
       "Tu/ILCVm5rZfn4cUPx0Z62CxMGSRZBdLQuzVexiuEVzQUYck3WhTtLUKA79V" +
       "6eouWc8r/nI8FFvDtiipfLCdJWt8KugoXquag/5cp5VJFq3xcRvzPYfizWBI" +
       "5WvUaq10mPAXkrnDqfpCobbLCvhkIdG63ppwvrXmHZVt5nm21Css1W2g+iCT" +
       "a3AX5mi4PlMj2uOZamAummRaXefNmpHAiLHtThlVR4jYpsxRx9STGbcVaxRb" +
       "oTpUippaI6nT5LKnU0lnku8YuN9QxbSmOpMpvekr0lZWG/w4mCDrDGXA3s4j" +
       "xKoFK5MKPOltjLza8rCavBpU2UmEE2pl4mm9kZxs2UHQU/s1ZNU10FhDe+aS" +
       "G9hTj2soiRDVYLJOrZWFpcdrn15mmGy1mgwnNocOj2/6i9Z6TNE7Ah/hFYma" +
       "RNK8JW6ZmdOUahHZhflpP51h3SRd5jRfn7Tm1aYkVhzd6Mcds1ULCJ52KyCz" +
       "2C0RFXfiphX5nGQDh0qaZsRQ04DojKtbwrN8GcElu1uZwe2I8f2e3h0pXYro" +
       "doRm4mumyPrudDaca3IgjlF7Nxwh3RpCTEa7Ckqt1laj0h15tkh0RzDcT+nW" +
       "qGs0tj7fazasxMU13tO8IHSXk3nTn3bQWkoEW2PuaB2106GxGSK7ttgiW01x" +
       "HUoLIoRHUbs/wBuT8XK4hql+uqhI6ajl6yktkthohlY8mkrdWSxoeuLMGXjY" +
       "X9rNWX83jcf8rDvzu5VWu5qNY7lSbySGFcFbctejmvban0ch1yRsVqht2OWa" +
       "40h86MWYaUmmgiJBa53nvLhaVhFy1+yu7anTzbqrDY5vdMHqNTohKUvTyTBs" +
       "2xtiospqFM7arDzvIsuKnra9iOHMCWpOq60agsAdK3KSNMJ9rkN3goByuuyY" +
       "8lqZlgyTEEHTNtZko4ZhmZNBMoBN1tZmidAiat320jerWzXf5hVSCdlw19Hr" +
       "MEtxXa675gZJL2tJ/YTEcrVqbJtVfzCyjW0tZgfZmhu6VZNllrxHzk15nG5y" +
       "xkQnWm/VXXSi5Q4D+U0WGiQttSZiPSDZKUaF/cpuPrIpZURimNdJDKZj2Dsc" +
       "YbW12ttaTkck+sNNpNaZRlAxEGolD+CpM1eNqd+RBWOs9RxxabCDqTkXl2aD" +
       "wF1lSwtaj1vGCbzqE0geMetx3bSdLFhZ2lbZrlkuFAQJw7lkuBP7dLdRSVC8" +
       "PSAJvLqMco4k28IKWYojNp/l05a7ZJYpnfUmG2HF+0pVqGNrw6T0LJPghaIu" +
       "zdEiDbBGhGx3qaGrGYGF1holkhQfeWtY7tDynM53iLwbLVu90WJYN83xyB1v" +
       "eSmKvZQapaMqUh9vpi6mz6kG3lfnG6NRybvLEMF9WG+I47xvkeak7dQmulh3" +
       "GksXxnAzBzudazKtsNFKZiOQ8yGDAY+vEmo1cvM0JcRZTw/JFtlrbN3RNOoY" +
       "+gKfN4Nayo6YGl0TuAGxYfTGcm76K1EaalE2n+5ErG6PqUizm1HGruZ8ze/7" +
       "xjabtYQ8E7urTnuaTYVdiix3RKfVqseL3VbeUEOm2Q4aoQ2+LTSLWrZXi75V" +
       "aTvwOGBoehJ1SG0xRWrTKjNaUGLHyEUB1ViwEj2t0+baYiZpi52vjQ3wkbDY" +
       "GAhLNyYpULlPxKobosYunNlqHLYEuj5Yd2CjS8p0s8hlifp2M++06LERDrl0" +
       "RxF51qzWNs2OOokUtjdi4Zyaori1jLEF+DhptSvxHOclemwjfg8jOzhc6Qw4" +
       "S14YsYrVlibDwjBiJiKrMkuLQnd1DfH1ttmRggXj41OXShOH9RZkzTdx2jNE" +
       "xjDJAU242qxZtcZLxtsi9GqW1wYsjrZhsPO4cyNnE2mVRT4sdNJVuq1VRC4R" +
       "1mB1o0qbsZqRjjUr5HBYbyjqRGybo1quxE4aB8v5YlxrYKEY7KJkPdvksrtM" +
       "FvVs3mvI2tILR7MwRVvmtmqpTs/eySFrwGY3VnqkClc0x6gFLVRWttNVX295" +
       "y8qQ4mI589SdgvcTWrH7Uoc30J3XGnG+wswayBYkQGvCIuSZVZuwW5NFRs6u" +
       "0pnNd3XYYSukYE4XU2rUlecz3OqKWGvL8th2jXnhinB0O2PXqY+3qkbelhwu" +
       "jsZCmg566QYRV22ntUANQ12ScTpL+GBHdnuSH+PoENc6/IziMrHDObUBvGzg" +
       "WBziwzYpjEZqc9RCwp4pjKqsI6CLdBnAW7YyqbT1mj7KULT4LPdf28nIY+Uh" +
       "0EmhdW0jxcC7XsOJwH7o2aJ528m5Wfl39WJx7uxR/um57ckx+NOXneQNyjKV" +
       "FxZHIW+6W5G1PAb52PtefkVjfqp2cHQovomhh2LP/zZbT3X7zHxXAaUX7n7k" +
       "Q5c15tPD2s++7++fmr1j9Z7XUKp68wU+L5L8Wfrjv4N/k/rDB9B9J0e3d1S/" +
       "zyO9eP7A9nqox0nozs4d277pfLno7eB5x5H633Hx2PJ0ge8wlSulqewN5ELN" +
       "4ULd4q2XLZgi79fl6AJCSecD96hd/GDRfDewxNSKrPgsaglunLG/dQzdn3qW" +
       "dmqY33PeMB85McwTHh8/PVNkUj0MLU2/hy3fWWEoO957otknis6nwfPuI82+" +
       "+7VqdngvzZbOVwJ89B4qe6VofgyYt1vWEa1daQTvOlXLR77aCd49JCzBvhE8" +
       "qyMJV18fCQ/2B+LH63JpTbq8J1OU/49cZqBHamj5Z077xXuj6a5pufqhour2" +
       "YVkv4cDC66gr29vIivZlpu2tO2veJcc/cw+Vf6JofjKGHjb1mA0tL7Ti7WX2" +
       "eZ91dO+nXIePfQ3rUFR7oefB85mjdfjM/5N1eNYLzUPZl9XVkdrMouZiqUcr" +
       "gOvuMeTzd4MkjsrpQI8j2dVsvZz31+6hzd8oml/ea7OodCXOvhby6VPV/crX" +
       "w4T/8kh1f/l1d9JPlwCfu4eMv1c0v7WXkTiq3hVdnzqV8bNfg4xliH8SPF88" +
       "kvGLr1XGy0P8WRH+9B5jf140fxhDV8OyllX8+uCpZH9017hcdP/Ia4rAeQw9" +
       "ccktlaLk/uQdd+P297nUT7xy48E3viL8aXlR4+TO1UMU9KCR2PbZyueZ96t+" +
       "qBtWKd1D+zqoX/77zzH01N1v0AAV7F9Kxr+wR/ki4PkSlBjMf/R6FvpvYuj6" +
       "KXQMHajnhv8+hq4dDYMAA9qzg18CXWCweP0n/5LS3b5EnF85kwAd2VK5UI9/" +
       "NRM8QTl706NImsrbi8cJTrK/v3hb/eQr5OQ7v9z+qf1NExCYd7uCyoMUdG1/" +
       "6eUkSXr2rtSOaV0dPf+VRz/10NuOE7pH9wyf2vUZ3t58+bWOoePH5UWM3a++" +
       "8Rff/tOv/FVZSfw/y2OJb1YqAAA=");
}
