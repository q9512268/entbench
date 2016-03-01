package edu.umd.cs.findbugs.detect;
public class InefficientToArray extends edu.umd.cs.findbugs.BytecodeScanningDetector implements edu.umd.cs.findbugs.StatelessDetector {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "ita.debug");
    private static final java.util.List<edu.umd.cs.findbugs.classfile.MethodDescriptor>
      methods =
      java.util.Collections.
      singletonList(
        new edu.umd.cs.findbugs.classfile.MethodDescriptor(
          "",
          "toArray",
          "([Ljava/lang/Object;)[Ljava/lang/Object;"));
    static final int SEEN_NOTHING = 0;
    static final int SEEN_ICONST_0 = 1;
    static final int SEEN_ANEWARRAY = 2;
    private static final org.apache.bcel.classfile.JavaClass collectionClass;
    private final edu.umd.cs.findbugs.BugReporter bugReporter;
    private final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    private int state = SEEN_NOTHING;
    static { org.apache.bcel.classfile.JavaClass tmp = null;
             try { tmp = edu.umd.cs.findbugs.ba.AnalysisContext.lookupSystemClass(
                                                                  "java.util.Collection");
             }
             catch (java.lang.ClassNotFoundException cnfe) {
                 edu.umd.cs.findbugs.ba.AnalysisContext.
                   reportMissingClass(
                     cnfe);
             }
             collectionClass = tmp; }
    public InefficientToArray(edu.umd.cs.findbugs.BugReporter bugReporter) {
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
        if (collectionClass !=
              null &&
              hasInterestingMethod(
                classContext.
                  getJavaClass(
                    ).
                  getConstantPool(
                    ),
                methods)) {
            classContext.
              getJavaClass(
                ).
              accept(
                this);
        }
    }
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Method obj) {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "------------------- Analyzing " +
                obj.
                  getName(
                    ) +
                " ----------------");
        }
        state =
          SEEN_NOTHING;
        super.
          visit(
            obj);
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
    @java.lang.Override
    public void sawOpcode(int seen) { if (DEBUG) {
                                          java.lang.System.
                                            out.
                                            println(
                                              "State: " +
                                              state +
                                              "  Opcode: " +
                                              OPCODE_NAMES[seen]);
                                      }
                                      switch (state) {
                                          case SEEN_NOTHING:
                                              if (seen ==
                                                    ICONST_0) {
                                                  state =
                                                    SEEN_ICONST_0;
                                              }
                                              break;
                                          case SEEN_ICONST_0:
                                              if (seen ==
                                                    ANEWARRAY) {
                                                  state =
                                                    SEEN_ANEWARRAY;
                                              }
                                              else {
                                                  state =
                                                    SEEN_NOTHING;
                                              }
                                              break;
                                          case SEEN_ANEWARRAY:
                                              if ((seen ==
                                                     INVOKEVIRTUAL ||
                                                     seen ==
                                                     INVOKEINTERFACE) &&
                                                    "toArray".
                                                    equals(
                                                      getNameConstantOperand(
                                                        )) &&
                                                    "([Ljava/lang/Object;)[Ljava/lang/Object;".
                                                    equals(
                                                      getSigConstantOperand(
                                                        ))) {
                                                  try {
                                                      java.lang.String clsName =
                                                        getDottedClassConstantOperand(
                                                          );
                                                      org.apache.bcel.classfile.JavaClass cls =
                                                        org.apache.bcel.Repository.
                                                        lookupClass(
                                                          clsName);
                                                      if (cls.
                                                            implementationOf(
                                                              collectionClass)) {
                                                          bugAccumulator.
                                                            accumulateBug(
                                                              new edu.umd.cs.findbugs.BugInstance(
                                                                this,
                                                                "ITA_INEFFICIENT_TO_ARRAY",
                                                                LOW_PRIORITY).
                                                                addClassAndMethod(
                                                                  this),
                                                              this);
                                                      }
                                                  }
                                                  catch (java.lang.ClassNotFoundException cnfe) {
                                                      bugReporter.
                                                        reportMissingClass(
                                                          cnfe);
                                                  }
                                              }
                                              state =
                                                SEEN_NOTHING;
                                              break;
                                          default:
                                              state =
                                                SEEN_NOTHING;
                                              break;
                                      } }
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
       "A38UkU1jLbruZNOqVYRkVUFppbayx1iV");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("5qd6Bo/xhSvgNVRydU0xBlptYGb2mlJrlaAjylBizBNqsdywIeu26tHab8+N" +
       "eo9R2zEZiUJ30nEhU6tS0FBGVUxJIkfMuGa7IbOjqJ+5q8ZGUHWwryIMSBlh" +
       "cGVltwROMvCxw5WVdYfYKCK3DnEEwSf1VrWN9kZUVYU5S5rE7BbuJzHfnU4H" +
       "02rTRhitVq7quteqDNpGXPfx3lzTHU8vS+wWaiFTdryZQeuZ2q5UR4SKqWw0" +
       "ScyGmIiUvWGbSp1PqJYIHC+0zYk8Nwhm03VDcTU0KZVBwi6/5nFygMZmuxGr" +
       "YyYku8GoPSmvcLWlm4ogcIOpLc0rskXbNYS1sUkwAvAB8o5aE6oPbIjjCHPi" +
       "oyj6w/mrq994e6/UHixeER6enFw4SN7wq2/jrdmu6cm8eObwNWrxd6V06rTd" +
       "sdeoxz4ZHR5teeasF7v58VTDMaKoUxxB88P8c/mj5x2fLD6Vf+Hjr76ms79Q" +
       "ubj/NYqLS/fEfvCDjrE2nGML33Xnr86771xHJzF+/eN//IjwIevFt3EO7fFT" +
       "dJ6e8p8Mv/hV8n3aP7hYunR4LuO2c60nBz1/6rskSK2T0BNOnMl49ORZsPyr" +
       "h7CvB+H06+wjTZ/9LvsDO0s5daDo1KGkp8/SnKrs9LJ/tLiY55t3OJj0X/Pi" +
       "D4BJFp+1jw898+Xu2rf1Iwv9+kkLvf/QQg9pvHHse+faAOFFN+5g1LcfHyoq" +
       "fv+kZJ8E10f2JfuR74tknzj/k9LOLopJvnMHsf5FXrwZly4XYs0fvnUktv9x" +
       "rtjy6m//tQX0OLj0fQHp3xcBPXa+gHBfL745XLh8vngu3JMXpbPFc+HC91k8" +
       "T4NruS+e5d+oePLHlwsG33kH5h/Oi2sAHiNlwwYakNcpAVz/GxRACnzw9gPE" +
       "+WnI99z2Pwu7c/bar7x27e53vzb5z8UZ2sOz8PcMSnfPE8c5fijt2P2VIDTm" +
       "diGce3ZH1IKC2cfi0iPnn22OS1d2NzndFx7dDXkyLj10xpAYrL9/e7z3zbh0" +
       "71HvuHRRO9H8/rh0db85Ll0C5fHG50AVaMxvy8GBbX/wzC+dW0Al0BSvgRBk" +
       "e+ZhXLxwLLTtm1vh4ze+1yevwyHHD+iePiY0THb/c3JLe/01mvnom81f2B0Q" +
       "Bu6WZfksdw9KV3dnlQ/D35PnznYw1xXq2e8+8KV7njkI1Q/sCD4y/WO0PX72" +
       "aVzCDeLi/Gz2L9/9z174xde+Xhzv+L/DxO00CjQAAA==");
}
