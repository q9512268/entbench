package edu.umd.cs.findbugs.detect;
public class BuildNonnullReturnDatabase {
    public static final boolean VERBOSE_DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fnd.debug.nullarg.verbose");
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "fnd.debug.nullarg") ||
      VERBOSE_DEBUG;
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        boolean fullAnalysis =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          getBoolProperty(
            edu.umd.cs.findbugs.FindBugsAnalysisFeatures.
              INTERPROCEDURAL_ANALYSIS_OF_REFERENCED_CLASSES);
        if (!fullAnalysis &&
              !edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              isApplicationClass(
                classContext.
                  getJavaClass(
                    ))) {
            return;
        }
        if (VERBOSE_DEBUG) {
            java.lang.System.
              out.
              println(
                "Visiting class " +
                classContext.
                  getJavaClass(
                    ).
                  getClassName(
                    ));
        }
        for (org.apache.bcel.classfile.Method m
              :
              classContext.
               getMethodsInCallOrder(
                 )) {
            considerMethod(
              classContext,
              m);
        }
    }
    private void considerMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                                org.apache.bcel.classfile.Method method) {
        if (method.
              getReturnType(
                ) instanceof org.apache.bcel.generic.ReferenceType &&
              classContext.
              getMethodGen(
                method) !=
              null) {
            if (VERBOSE_DEBUG) {
                java.lang.System.
                  out.
                  println(
                    "Check " +
                    method);
            }
            analyzeMethod(
              classContext,
              method);
        }
    }
    protected int returnsReference;
    protected int returnsNonNull;
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method) {
        returnsReference++;
        try {
            edu.umd.cs.findbugs.ba.CFG cfg =
              classContext.
              getCFG(
                method);
            edu.umd.cs.findbugs.ba.npe.IsNullValueDataflow inv =
              classContext.
              getIsNullValueDataflow(
                method);
            boolean guaranteedNonNull =
              true;
            for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
                   cfg.
                   locationIterator(
                     );
                 i.
                   hasNext(
                     );
                 ) {
                edu.umd.cs.findbugs.ba.Location location =
                  i.
                  next(
                    );
                org.apache.bcel.generic.InstructionHandle handle =
                  location.
                  getHandle(
                    );
                org.apache.bcel.generic.Instruction ins =
                  handle.
                  getInstruction(
                    );
                if (!(ins instanceof org.apache.bcel.generic.ARETURN)) {
                    continue;
                }
                edu.umd.cs.findbugs.ba.npe.IsNullValueFrame frame =
                  inv.
                  getFactAtLocation(
                    location);
                if (!frame.
                      isValid(
                        )) {
                    continue;
                }
                edu.umd.cs.findbugs.ba.npe.IsNullValue value =
                  frame.
                  getTopValue(
                    );
                if (!value.
                      isDefinitelyNotNull(
                        )) {
                    guaranteedNonNull =
                      false;
                    break;
                }
            }
            edu.umd.cs.findbugs.ba.XMethod xmethod =
              edu.umd.cs.findbugs.ba.XFactory.
              createXMethod(
                classContext.
                  getJavaClass(
                    ),
                method);
            if (guaranteedNonNull) {
                returnsNonNull++;
                edu.umd.cs.findbugs.ba.AnalysisContext.
                  currentAnalysisContext(
                    ).
                  getReturnValueNullnessPropertyDatabase(
                    ).
                  setProperty(
                    xmethod.
                      getMethodDescriptor(
                        ),
                    guaranteedNonNull);
                if (DEBUG) {
                    java.lang.System.
                      out.
                      println(
                        "Unconditional deref: " +
                        xmethod +
                        "=" +
                        guaranteedNonNull);
                }
            }
        }
        catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
            edu.umd.cs.findbugs.ba.XMethod xmethod =
              edu.umd.cs.findbugs.ba.XFactory.
              createXMethod(
                classContext.
                  getJavaClass(
                    ),
                method);
            edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getLookupFailureCallback(
                ).
              logError(
                "Error analyzing " +
                xmethod +
                " for unconditional deref training",
                e);
        }
        catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
            edu.umd.cs.findbugs.ba.XMethod xmethod =
              edu.umd.cs.findbugs.ba.XFactory.
              createXMethod(
                classContext.
                  getJavaClass(
                    ),
                method);
            edu.umd.cs.findbugs.ba.AnalysisContext.
              currentAnalysisContext(
                ).
              getLookupFailureCallback(
                ).
              logError(
                "Error analyzing " +
                xmethod +
                " for unconditional deref training",
                e);
        }
    }
    public BuildNonnullReturnDatabase() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zWOcNEzIcCJxk+ba3yUTmhxztsXBW+3iwoUjdnTqov+RjFHwLoT0wrPRNsrG" +
       "AvbMuelGfRhXVYCZzzIBwSWAn0fSZl6kGaNBqlNpjAWjElOC4hoUb3fsYBMC" +
       "nSpg42ex+RoADVZ6MtToFh32HneM+fX/lTE3wTNs6z98i+D8Rrbp8pEWMB02" +
       "3xSsXyhglm9jcxbqPwoV49Q0y2mVc/8Nq6Q4acl/J4QHmOas62nrSlV6/kRd" +
       "xZwTW98S6Ji59qwGnIsDI3eJ7Xov0w0Wl4WS1VbBbZUxF0CO/NdWUEVbL0KN" +
       "8xbJS5zMzEHCYX371T37h5xUOrM5CUie4UtQ0NjDkKuhdQ/+BLpgEF8v6+ng" +
       "rxcHOzyLBK2zSKrIm6cyjmq6laNcqW2JJyWIHxDS8J20fkKISGdPbO7bc+OT" +
       "p6ybFNhz09PIpQqqSOu+JpMCFuflluZVtmn5zdpzM5amk6XnJsctmwgXgBFx" +
       "69Hiu1ow2zI3DO+cXHvhpwfK3oC6eTspouCj7dmntpSehNy7PZxdLUO6FHce" +
       "Hcu/OrVuZfwvvxbnYmJV1/Pyz4dT6ZG3e8+Nf3S/uLEuhQhgKXGc3DClDjJp" +
       "wvCU3rUYrhR/ShB2sM1Xk+nFKzVOWrNPHtkXkZWKNsmMTi2pig0KxXuV0+P5" +
       "JSOdNZO67iNwelyHrR1WgkHrQ/xFwlt03b6PCnygi+0byV9QXhGv2Fz9N4lb" +
       "n71LHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "LpREXtGxy1ea4+IGsXkFbpCr2rgiKRY8rIwxm5KCGuL4jMXX4OVETcSYFZoN" +
       "pjY0q81V3HcGQWdQ1oZ1gGLFuChYFYEp8XJbFrmkV0QpsOEQuC4vg9U82Ujk" +
       "IVNNibSLobNpuV5iy3WjmnCUT1RRztQqXDgukovOchQZ6hgutHFP7/Ya61rB" +
       "0f1Ewah0g7dHSMqMfLABUTYLe1WzJFJZCchwuBEGWNJhGkOkOF+OBkxfpWWq" +
       "LisFivVqG7lHAsxr0gNvvFoxVFQYegQKQNyyIpEPbaeaql5KVCV7WZs6w0AJ" +
       "7Vif6u1eUmtiZlRyYyQdlDtUQZlia8OL56Oyi9Y0FizuI3RRV20n9BjNIDd1" +
       "WkxUnKNqPUzRMCWCKZ+PxHm8Xicg0O0hX4LpTVpR2ZrYL2uNAjkvM3CEdyNj" +
       "bOijaV8pd1Crsxh68Rrlyj43840JzBhtJCBK02XB6Y1SnhJ8ksbC5XQpCiMy" +
       "sAnWRDxTL46SacQXC3R1yFAqKVK1uknGmrXB/ElJ0JeYP4aTXmyFxbJco1Fn" +
       "o5uForzhm+Op0V8jvbRJViyw8SzhGNi+Ztvat7y47fad+cnCwcUt2GVnFd6L" +
       "2FFvqx7OklcdHMPkv3PQ6VcdR46DoezE7pWn3cfmp3UfettTT6vUh0s7e8fo" +
       "eAhdCF3vJyxtrVlHujoLenrt6SeTRH4dfXi8+4W3/fP97E8Zb3oRF1gPnuDz" +
       "ZJe/TTzzpf6rlXfvQGcPDntvuCg/TnTt+BHvxe2ZE3vsoPeVB5p9Saax14On" +
       "uqfZ6skDrkPb3fx06zVb25+4pTizdw24d6L06M0uHWVpa5e9bxXyft77PLcd" +
       "v5ElvwqcbG0GZniU9KZHOWvXVA997t0vdIpzdLS84MkDJWXXzNAAPP09JfVf" +
       "rJK4myppJ2+wk72+b19TD7m+vit5kmJou7KiWbv5xyPZnfiec+Q9feR51PQ7" +
       "WfKbIXQpu0AwVc3f0mWlHzjUx2/9qPrAwMPu6YP9v9dHlnw0b/Xp55H1M1ny" +
       "qRC6Q3Ika5NqNxX1d1+MqEkI3X/6NXh2j3ffDV/kbL8iUT7x9OXb7n2a+6v8" +
       "JvjgS48LOHTbHHR09NrlSP6c52tzMxfmwvYSxsv/Pgf4OP2mPoTObTM5/5/d" +
       "knw+hO6+CUkIxt/LHm39xyF08bB1CO0ox6q/EELn96pD6CxIj1b+GSgClVn2" +
       "y95NTo2391PJmeOwfGCQu17IIEeQ/NFj+Jt/M7WPldH2q6nryiefHpJvfq72" +
       "4e1VNgiYNM16uQ2Hzm9v1Q/w9uFTe9vv6xz22PcvferCq/bnhktbhg8d+ghv" +
       "D978rrhre2F+u5v+wb2///qPPP31/BD7fwEZ5pAczCYAAA==");
}
